// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: bpm4struts2/actions/Action.java.vsl in andromda-bpm4struts-cartridge-coppetec.
//

package br.mdarte.exemplo.academico.web.geral.consultarCurso;

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

import br.mdarte.exemplo.academico.web.geral.consultarCurso.ConsultaCursoControleFactory;

public class ResultadoConsultaNovaConsulta extends br.mdarte.exemplo.academico.accessControl.Login2
{
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
		casoDeUso = "ConsultaCursoUC";
		urlCasoDeUso = "/ConsultaCursoUC/ResultadoConsultaNovaConsulta";

		modulo = "geral";
		Iterator breadCrumbIt = null;
		Boolean aplicacaoPermiteUsoBackBrowser = (Boolean) request.getSession().getServletContext().getAttribute("aplicacaoPermiteUsoBackBrowser");
		
		if (!aplicacaoPermiteUsoBackBrowser ^ false)
		{
			if(getInvalidatePageControlCounter(request).get("ConsultaCursoUC.ResultadoConsulta") != null && request.getParameter("invalidatePageControlCounter") != null && !(((Integer)getInvalidatePageControlCounter(request).get("ConsultaCursoUC.ResultadoConsulta")).equals(Integer.valueOf(request.getParameter("invalidatePageControlCounter")))))
			{
				javax.servlet.http.HttpSession session = request.getSession();
				org.apache.struts.action.ActionMessages messages = (org.apache.struts.action.ActionMessages)session.getAttribute(org.apache.struts.Globals.MESSAGE_KEY);
				if (messages == null)
				{
					messages = new org.apache.struts.action.ActionMessages();
					session.setAttribute(org.apache.struts.Globals.MESSAGE_KEY, messages);
				}
				messages.add("org.andromda.bpm4struts.errormessages", new org.apache.struts.action.ActionMessage("pagina.expirou"));
				
				return "forwardAction";
			}
		}

		String forward = null;
		String redirect = "";
		request.getSession().setAttribute(org.apache.struts.Globals.MESSAGE_KEY, new org.apache.struts.action.ActionMessages());
		forward = "nova.consulta";

		boolean copyParameters = true;

		if (request.getSession().getAttribute(Constantes.COPY_PARAMETERS) != null) {
			copyParameters = (Boolean) request.getSession().getAttribute(Constantes.COPY_PARAMETERS);
			request.getSession().removeAttribute(Constantes.COPY_PARAMETERS);
		}

		org.apache.struts.validator.ValidatorForm form = null;
		java.util.HashMap map = new java.util.HashMap();
		if(request.getSession().getAttribute(Constantes.MODO_OPERACAO) != null)
			map = (java.util.HashMap)request.getSession().getAttribute(Constantes.MODO_OPERACAO);
		map.remove("geral/ConsultaCursoUC/ConsultaCursoUC.action");
		request.getSession().setAttribute(Constantes.MODO_OPERACAO, map);

		if(request.getSession().getAttribute("tableNameList") != null){
			java.util.Collection tableNameList = (java.util.Collection)request.getSession().getAttribute("tableNameList");

			for(java.util.Iterator it = tableNameList.iterator();it.hasNext();){
				String tableName = (String) it.next();
				request.getSession().removeAttribute(tableName);
			}

			request.getSession().removeAttribute("tableNameList");
		}



		if (request.getAttribute("$forwardKey") != null) {
			forward = (String)request.getAttribute("$forwardKey"); 
		} else {
			forward ="nova.consulta"; 
		}

		request.getSession().setAttribute("form", null);
 		
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
		__casoDeUso = "ConsultaCursoUC";
		__urlCasoDeUso = "/ConsultaCursoUC/ResultadoConsultaNovaConsulta.action";
		__modulo = "geral";
		__contexto = "";
	}
}
