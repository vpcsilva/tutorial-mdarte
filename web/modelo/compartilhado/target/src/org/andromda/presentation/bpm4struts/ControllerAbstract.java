// license-header java merge-point
package org.andromda.presentation.bpm4struts;
import br.mdarte.exemplo.academico.util.Constantes;
import org.andromda.presentation.bpm4struts.ViewContainer;
import com.opensymphony.xwork2.ActionSupport;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;


public abstract class ControllerAbstract implements java.io.Serializable
{
	
	
    /**
     * Stores a warning message in the session, if any other warning messages exist, this one
     * is simply added. This message will be removed from the session after the first time
     * it has been accessed (a feature supported by Struts since version 1.2.4).
     *
     * @param session the session to which the messages will be saved.
     * @param message the message key to lookup the actual message to display
     * @param arguments any arguments used within the message
     */
	protected final void saveWarningMessage(String message, String[] arguments, ViewContainer container) {
		// we explicitely store and retrieve the messages from the session, as opposed to using
		// Action.saveMessages because this constroller does not have access to the current Action instance
		org.apache.struts.action.ActionMessages messages = (org.apache.struts.action.ActionMessages)container.getFromSession(org.apache.struts.Globals.MESSAGE_KEY);
		if (messages == null)
		{
			messages = new org.apache.struts.action.ActionMessages();
			container.setOnSession(org.apache.struts.Globals.MESSAGE_KEY, messages);
		}
		messages.add("org.andromda.bpm4struts.warningmessages", new org.apache.struts.action.ActionMessage(message, arguments));
}

    /**
     * Stores a warning message in the session, if any other warning messages exist, this one
     * is simply added. This message will be removed from the session after the first time
     * it has been accessed (a feature supported by Struts since version 1.2.4).
     *
     * @param session the session to which the messages will be saved.
     * @param message the message key to lookup the actual message to display
     * @see saveWarningMessage(javax.servlet.http.HttpServletRequest, java.lang.String, java.lang.String[])
     */
    protected final void saveWarningMessage(String message, ViewContainer container) {
        this.saveWarningMessage(message, null, container);
    }

    /**
     * Stores a success message in the session, if any other success messages exist, this one
     * is simply added. This message will be removed from the session after the first time
     * it has been accessed (a feature supported by Struts since version 1.2.4).
     *
     * @param request the request from which the session will be taken into which the messages will be saved.
     * @param message the message key to lookup the actual message to display
     */
    protected final void saveSuccessMessage(String message, String[] arguments, ViewContainer container) {
        

        // we explicitely store and retrieve the messages from the session, as opposed to using
        // Action.saveMessages because this constroller does not have access to the current Action instance
        org.apache.struts.action.ActionMessages messages = (org.apache.struts.action.ActionMessages)container.getFromSession(org.apache.struts.Globals.MESSAGE_KEY);
        if (messages == null)
        {
            messages = new org.apache.struts.action.ActionMessages();
            container.setOnSession(org.apache.struts.Globals.MESSAGE_KEY, messages);
        }
        messages.add("org.andromda.bpm4struts.successmessages", new org.apache.struts.action.ActionMessage(message, arguments));
    }

	protected final void saveSuccessMessage(String message, ViewContainer container) {
		this.saveSuccessMessage(message,null,container);
	}


    /**
     * Stores an error message in the session, if any other error messages exist, this one
     * is simply added. This message will be removed from the session after the first time
     * it has been accessed (a feature supported by Struts since version 1.2.4).
     *
     * @param request the request from which the session will be taken into which the messages will be saved.
     * @param message the message key to lookup the actual message to display
     * @see saveSuccessMessage(javax.servlet.http.HttpServletRequest, java.lang.String, java.lang.String[])
     */
    protected final void saveErrorMessage(String message, String[] arguments, ViewContainer container) {

        // we explicitely store and retrieve the messages from the session, as opposed to using
        // Action.saveMessages because this constroller does not have access to the current Action instance
        org.apache.struts.action.ActionMessages messages = (org.apache.struts.action.ActionMessages)container.getFromSession(org.apache.struts.Globals.MESSAGE_KEY);
        if (messages == null)
        {
            messages = new org.apache.struts.action.ActionMessages();
            container.setOnSession(org.apache.struts.Globals.MESSAGE_KEY, messages);
        }
        messages.add("org.andromda.bpm4struts.errormessages", new org.apache.struts.action.ActionMessage(message, arguments));
    }

    /**
     * Stores an error message in the session, if any other error messages exist, this one
     * is simply added. This message will be removed from the session after the first time
     * it has been accessed (a feature supported by Struts since version 1.2.4).
     *
     * @param request the request from which the session will be taken into which the messages will be saved.
     * @param message the message key to lookup the actual message to display
     * @see saveSuccessMessage(javax.servlet.http.HttpServletRequest, java.lang.String, java.lang.String[])
     */
    protected final void saveErrorMessage(java.lang.String message,ViewContainer container) {
        this.saveErrorMessage(message, null,container);
    }
	
	/**
	 * Mï¿½todo a ser utilizado na recuperaï¿½ï¿½o de serviï¿½os.
	 */
	protected <T> T getService(Class<T> clazz) throws Exception	{
		return br.ufrj.coppetec.ServiceLocator.instance().getServiceBI(clazz);
	}

	protected java.util.Collection<String> getModoOperacao(String nomeCasoDeUso, ViewContainer container) {
		java.util.Collection<String> modoOperacao = new java.util.ArrayList();
		if(container.getFromSession(Constantes.MODO_OPERACAO) != null){
			java.util.Map map = (java.util.Map)container.getFromSession(Constantes.MODO_OPERACAO);
			if(nomeCasoDeUso != null){
				if(map.get(nomeCasoDeUso) != null){
					String modoOperacaoStr = (String)map.get(nomeCasoDeUso);
					java.util.StringTokenizer st = new java.util.StringTokenizer(modoOperacaoStr, ",");
					while(st.hasMoreTokens()){
						String next = st.nextToken();
						modoOperacao.add(next);
					}
				}
			}
		}
		return modoOperacao;
	}
	
	protected void adicionaModoOperacao(String modoOperacao, ViewContainer container) {
		this.adicionaModoOperacao(this.getNomeCasoUso(), modoOperacao, container);
	}
	
	protected void adicionaModoOperacao(String casoUso, String modoOperacao, ViewContainer container) {
		if(possuiModoOperacao(casoUso, modoOperacao, container))
			return;
		
		Map listaModosOperacao = (Map) container.getFromSession(Constantes.MODO_OPERACAO);
		
		if(listaModosOperacao == null) {
			listaModosOperacao = new HashMap<String, String>();
			container.setOnSession(Constantes.MODO_OPERACAO, listaModosOperacao);
		}
		
		String modosOperacao = (String) listaModosOperacao.get(casoUso);
		modosOperacao += "," + modoOperacao;
		
		listaModosOperacao.put(casoUso, modosOperacao);
	}
	
	protected boolean possuiModoOperacao(String modoOperacao, ViewContainer container) 	{
		return this.possuiModoOperacao(this.getNomeCasoUso(), modoOperacao, container);
	}
	
	protected boolean possuiModoOperacao(String casoUso, String modoOperacao, ViewContainer container)
	{
		Map listaModosOperacao = (Map) container.getFromSession(Constantes.MODO_OPERACAO);
		
		if(listaModosOperacao == null)
			return false;
		else
			return this.possuiModoOperacao(casoUso, modoOperacao, (String) listaModosOperacao.get(casoUso));
	}
	
	protected boolean possuiModoOperacao(String modoOperacao, String modosOperacao) {
		return this.possuiModoOperacao(this.getNomeCasoUso(), modoOperacao, modosOperacao);
	}
	
	protected boolean possuiModoOperacao(String casoUso, String modoOperacao, String modosOperacao) {
		if(modoOperacao == null || modoOperacao.length() < 1)
			return false;
		if(modosOperacao == null || modosOperacao.length() < 1)
			return false;
		
		String lista[] = modosOperacao.split(",");
		for(String str:lista) {
			if(modoOperacao.equals(str))
				return true;
		}
		
		return false;
	}
	
	protected void removeModoOperacao(String modoOperacaoASerRemovido, ViewContainer container) {
		this.removeModoOperacao(this.getNomeCasoUso(), modoOperacaoASerRemovido, container);
	}
	
	protected void removeModoOperacao(String casoUso, String modoOperacaoASerRemovido, ViewContainer container) {
		Map listaModosOperacao = (Map) container.getFromSession(Constantes.MODO_OPERACAO);
		
		if(listaModosOperacao == null) {
			listaModosOperacao = new HashMap<String, String>();
			container.setOnSession(Constantes.MODO_OPERACAO, listaModosOperacao);
		}
		
		String modosOperacao = (String) listaModosOperacao.get(casoUso);
		if(modosOperacao != null && modosOperacao.contains(modoOperacaoASerRemovido)) {
			modosOperacao = modosOperacao.replace(modoOperacaoASerRemovido, "");
		}
		
		listaModosOperacao.put(casoUso, modosOperacao);
	}
	
	protected JSONObject parseObjectToJSON(Object object, String[] attributes ) throws Exception{
		
		java.lang.reflect.Method[] methods = object.getClass().getDeclaredMethods();
		
		if(object instanceof br.mdarte.exemplo.academico.cd.AbstractEntity)
			methods = object.getClass().getSuperclass().getDeclaredMethods();
				
		JSONObject obj = new JSONObject();

        for(int i = 0; i < attributes.length; i++) {
                
        	for(int j = 0; j < methods.length; j++) {
            
            	String methodName = "get".concat(attributes[i].subSequence(0,1).toString().toUpperCase().concat(attributes[i].substring(1)));
                        
                if(methods[j].getName().equals(methodName)) {
            
                    obj.put(attributes[i], String.valueOf(methods[j].invoke(object)));
                            
                	break;
                            
                }
            
        	}
    	}
        
		return obj;	
	}
	
	protected JSONArray parseArrayToJSON(Object[] objects, String[] attributes ) throws Exception {
		
		JSONArray array = new JSONArray();
		
		for(int i = 0; i < objects.length; i++){
			array.add(this.parseObjectToJSON(objects[i],attributes));
		}
		
		return array;
	}
	
	protected JSONArray parseCollectionToJSON(java.util.Collection objects, String[] attributes ) throws Exception {
		
		JSONArray array = new JSONArray();
		
		for(Object obj : objects){
			array.add(this.parseObjectToJSON(obj,attributes));
		}
		
		return array;
	}
	
	protected String extractParameterFromViewContainer(ViewContainer container, String parameter) {
		return container.getParameter(parameter) == null ? "" : String.valueOf(container.getParameter(parameter));
	}
	
	protected java.util.Collection<String> getModoOperacao(ViewContainer container) {
		return this.getModoOperacao(this.getNomeCasoUso(), container);
	}
	
	protected String getMessage(br.ufrj.coppetec.Enumeration eo) {
		return getMessage(eo.getInternationalizationKey());
	}
	
	protected String getMessage(String key) {
		ActionSupport actionSupport = new ActionSupport();
		return actionSupport.getText(key);
	}
	
	protected abstract String getNomeCasoUso();
}
