// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: bpm4struts2/actions/Action.java.vsl in andromda-bpm4struts-cartridge-coppetec.
//

package br.mdarte.exemplo.academico.web.geral.manterEstudante;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.ServletActionContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Enumeration;
import java.io.PrintWriter;
import org.andromda.presentation.bpm4struts.ActionUtil;
import org.andromda.presentation.bpm4struts.Struts2ViewContainer;
import br.mdarte.exemplo.academico.util.Constantes;

import com.opensymphony.xwork2.ActionSupport;

import br.mdarte.exemplo.academico.web.geral.manterEstudante.MantemEstudanteControleFactory;

public class MantemEstudanteUC extends br.mdarte.exemplo.academico.accessControl.Login2
{

	private java.lang.String nome;
	public java.lang.String getNome() 
	{
		return nome;
	}

	public void setNome(java.lang.String nome)
	{
		this.nome = nome;
	}

	private java.lang.Long idEstudante;
	public java.lang.Long getIdEstudante() 
	{
		return idEstudante;
	}

	public void setIdEstudante(Object idEstudante)
	{
		if(idEstudante == null) this.idEstudante = null;
		else if (idEstudante instanceof  String[]) {
			String temp = ((String[])idEstudante)[0];
			if (temp.isEmpty()) this.idEstudante = null;
			else this.idEstudante = java.lang.Long.valueOf(((String[])idEstudante)[0]);
		}
		else this.idEstudante = (java.lang.Long) idEstudante;
	}

	private java.lang.String matricula;
	public java.lang.String getMatricula() 
	{
		return matricula;
	}

	public void setMatricula(java.lang.String matricula)
	{
		this.matricula = matricula;
	}
	public void saveErrorMessage(String message)
	{
		org.apache.struts.action.ActionMessages messages = (org.apache.struts.action.ActionMessages)request.getSession().getAttribute(org.apache.struts.Globals.MESSAGE_KEY);
		if (messages == null)
		{
			messages = new org.apache.struts.action.ActionMessages();
			request.getSession().setAttribute(org.apache.struts.Globals.MESSAGE_KEY, messages);
		}
		messages.add("org.andromda.bpm4struts.errormessages", new org.apache.struts.action.ActionMessage(message, null));
	}

	public void validate()
	{
		//Removendo mensagens antigas
		//request.getSession().setAttribute(org.apache.struts.Globals.MESSAGE_KEY, new org.apache.struts.action.ActionMessages());

		//Validando campos

	}

	public String particularExecute() throws Exception
	{
		String casoDeUso = null;
		String urlCasoDeUso = null;
		String modulo = null;

		boolean adicionaBreadCrumb = true;
		casoDeUso = "MantemEstudanteUC";
		urlCasoDeUso = "/MantemEstudanteUC/MantemEstudanteUC";

		modulo = "geral";
		Iterator breadCrumbIt = null;

		String forward = null;
		String redirect = "";
		forward = "alterando.estudante";

		boolean copyParameters = true;

		if (request.getSession().getAttribute(Constantes.COPY_PARAMETERS) != null) {
			copyParameters = (Boolean) request.getSession().getAttribute(Constantes.COPY_PARAMETERS);
			request.getSession().removeAttribute(Constantes.COPY_PARAMETERS);
		}

		org.andromda.presentation.bpm4struts.PageSessionObjectUtil.updatePagesSO(request);

		java.util.List listaCasosUso = new java.util.ArrayList();

		listaCasosUso.add("DetalhaEstudanteUC");

		org.andromda.presentation.bpm4struts.SessionObjectUtil.updateSessionObjects(request, listaCasosUso);


		MantemEstudanteUCFormImpl form = new MantemEstudanteUCFormImpl();

		form.setNome(this.nome);
		form.setIdEstudante(this.idEstudante);
		form.setMatricula(this.matricula);

		final MantemEstudanteUCFormImpl specificForm = (MantemEstudanteUCFormImpl)form;

		final Object previousFormObject = request.getSession().getAttribute("form");

		if(previousFormObject != null)
		{
			Class[] classes = null;
			Object[] objetos = null;

			try {

				Object obj = previousFormObject.getClass().getMethod("getNome", classes).invoke(previousFormObject, objetos);

				if (obj != null && specificForm.getNome() == null)
					specificForm.setNome(((java.lang.String) obj));	
			} catch(NoSuchMethodException e) {
				//Nao faz nada, simplesmente nao copia o parametro
			} catch(ClassCastException cce) {
				br.mdarte.exemplo.academico.SistemaacademicoLogger.warn("error.copia.parametros=nome", this.getClass());
			}
			try {

				Object obj = previousFormObject.getClass().getMethod("getIdEstudante", classes).invoke(previousFormObject, objetos);

				if (obj != null && specificForm.getIdEstudante() == null)
					specificForm.setIdEstudante(((java.lang.Long) obj));	
			} catch(NoSuchMethodException e) {
				//Nao faz nada, simplesmente nao copia o parametro
			} catch(ClassCastException cce) {
				br.mdarte.exemplo.academico.SistemaacademicoLogger.warn("error.copia.parametros=idEstudante", this.getClass());
			}
			try {

				Object obj = previousFormObject.getClass().getMethod("getMatricula", classes).invoke(previousFormObject, objetos);

				if (obj != null && specificForm.getMatricula() == null)
					specificForm.setMatricula(((java.lang.String) obj));	
			} catch(NoSuchMethodException e) {
				//Nao faz nada, simplesmente nao copia o parametro
			} catch(ClassCastException cce) {
				br.mdarte.exemplo.academico.SistemaacademicoLogger.warn("error.copia.parametros=matricula", this.getClass());
			}
		}

		request.getSession().setAttribute("form", form);

		try
		{

			forward = _carregandoEstudante(form);

		}//fim try
		catch (java.lang.Exception exception)
		{
			Object formObj = org.andromda.presentation.bpm4struts.PageSessionObjectUtil.getPageForm(request, "MantemEstudanteUC");

			if (formObj != null) {
				try
				{
					formObj.getClass().getMethod("resetCheckBoxes", new Class[] {org.apache.struts.action.ActionMapping.class, javax.servlet.http.HttpServletRequest.class}).invoke(formObj, new Object[]{null, null});
				}
				catch (Exception e2)
				{
					// ignoring
				}

				final java.util.Map parameters = new java.util.HashMap();
				for (final java.util.Enumeration names = request.getParameterNames(); names.hasMoreElements();)
				{
					final String name = String.valueOf(names.nextElement());
					parameters.put(name, request.getParameterValues(name));
				}
				try
				{
					org.apache.commons.beanutils.BeanUtils.populate(formObj, parameters);
				}
				catch (java.lang.Exception populateException)
				{
					// ignore if we have an exception here (we just don't populate).
				}
			}
			throw exception;
		}
 		
		if(request.getAttribute("$forwardKeyModule") != null && !request.getAttribute("$forwardKeyModule").equals("geral")){
			java.util.Enumeration atributosName = request.getSession().getAttributeNames();
			java.util.Map atributos = new java.util.HashMap();

			while(atributosName.hasMoreElements()){
				String atributo = (String)atributosName.nextElement();
				atributos.put(atributo, request.getSession().getAttribute(atributo));
			}

			org.andromda.presentation.bpm4struts.ShareSessionUtil.saveMapIntoContext(request, response, atributos, ServletActionContext.getServletContext().getContext("/sistemaacademico"));
		}

		if (redirect != "") {//troca de modules - to be tested
			response.sendRedirect(redirect);
		}
		
		request.removeAttribute("$forwardKey");
		request.removeAttribute("$forwardKeyModule");
		
		return forward;
	}

	/**
	 * 
	 */
	private String _carregandoEstudante(org.apache.struts.validator.ValidatorForm form) throws java.lang.Exception
	{
		String forward = null;
		String redirect ="";
	
		MantemEstudanteControleFactory.getMantemEstudanteControleInstance().carregaEstudante((MantemEstudanteUCFormImpl) form, new Struts2ViewContainer(this, request, response));
		if(getInvalidatePageControlCounter(request).get("MantemEstudanteUC.AlterandoEstudante") == null)
			getInvalidatePageControlCounter(request).put("MantemEstudanteUC.AlterandoEstudante", 0);
		getInvalidatePageControlCounter(request).put("MantemEstudanteUC.AlterandoEstudante", ((Integer)getInvalidatePageControlCounter(request).get("MantemEstudanteUC.AlterandoEstudante")).intValue() + 1);

		org.andromda.presentation.bpm4struts.PageSessionObjectUtil.setPageSO(request, new org.andromda.presentation.bpm4struts.FormSessionObject("MantemEstudanteUC.AlterandoEstudante", form, 5));

		if (request.getAttribute("$forwardKey") != null) {
			forward = (String)request.getAttribute("$forwardKey"); 
		} else {
			forward ="alterando.estudante"; 
		}



		return forward;
	}
 

	private java.util.Map getInvalidatePageControlCounter(javax.servlet.http.HttpServletRequest request)
	{
		java.util.Map invalidatePageControlCounter = (java.util.Map)request.getSession().getAttribute("invalidatePageControlCounter");

		if(invalidatePageControlCounter == null)
		{
			invalidatePageControlCounter = new java.util.HashMap();
			request.getSession().setAttribute("invalidatePageControlCounter", invalidatePageControlCounter);
		}

		return invalidatePageControlCounter;
	}

	public void loadUseCaseInfo()
	{
		__casoDeUso = "MantemEstudanteUC";
		__urlCasoDeUso = "/MantemEstudanteUC/MantemEstudanteUC.action";
		__modulo = "geral";
		__contexto = "/geral";
	}
}