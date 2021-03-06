
<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/layout-configuration.jsp" %>

<logic:messagesPresent message="true" property="org.andromda.bpm4struts.successmessages">
	<div id="messages">
		<div class="alert alert-success">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			<h4 class="alert-heading"><bean:message key="sucess.message.window"/></h4>
			<html:messages id="message" message="true" property="org.andromda.bpm4struts.successmessages">
				<div class="message">${message}</div>
			</html:messages>
		</div>
	</div>
</logic:messagesPresent>

<s:if test="hasFieldErrors() || hasActionErrors()">
	<div id="messages">
		<div class="alert alert-danger">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			<h4 class="alert-heading"><bean:message key="error.message.window"/></h4>
			<s:if test="hasFieldErrors()">
				<s:iterator value="fieldErrors">
					<div class="message">
						<s:property value="top.value[0]" escape="false" />
					</div>
				</s:iterator>
			</s:if>
			<s:if test="hasActionErrors()">
				<s:iterator value="actionErrors">
					<div class="message">
						<s:property value="top.value[0]" escape="false" />
					</div>
				</s:iterator>
			</s:if>
		</div>
    </div>
</s:if>

<logic:messagesPresent message="true">
	<%  Exception e = (Exception)request.getSession().getAttribute(org.apache.struts.Globals.EXCEPTION_KEY); 
		request.getSession().removeAttribute(org.apache.struts.Globals.EXCEPTION_KEY);
		if(e != null) {
			java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
			java.io.PrintStream ps = new java.io.PrintStream(baos);
			e.printStackTrace(ps);
			String stackTrace = baos.toString();
			request.getSession().getServletContext().getContext("/sistemaacademico").setAttribute("stackTrace", stackTrace);
	%>

		<script>
			function stackTrace() { 
				window.open('/sistemaacademico/stackTrace.jsp','StackTrace','width=1024,height=600,scrollbars=yes');
			}	
		</script>
	<%
		}
	%>

	<div id="messages">		
		<logic:messagesPresent message="true" property="org.andromda.bpm4struts.errormessages">
			<div class="alert alert-danger">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<h4 class="alert-heading"><bean:message key="error.message.window"/></h4>
				<html:messages id="error" message="true" property="org.andromda.bpm4struts.errormessages">
					<strong>${error}</strong>
					<% if(e != null) {%>
						<p>
							<a class="btn btn-danger" href="javascript:stackTrace();void(0);"><bean:message key="error.stack.trace"/></a>
						</p>
					<%}%>
				</html:messages>
			</div>
		</logic:messagesPresent>

		<logic:messagesPresent message="true" property="org.andromda.bpm4struts.warningmessages">
			<div class="alert alert-warning">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<h4 class="alert-heading"><bean:message key="warning.message.window"/></h4>
				<html:messages id="warning" message="true" property="org.andromda.bpm4struts.warningmessages">
					<strong>${warning}</strong>
				</html:messages>
			</div>
		</logic:messagesPresent>
	</div>
</logic:messagesPresent>

