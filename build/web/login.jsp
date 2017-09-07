
<%@ page import="com.servidoctor.constantes.IConstantes" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<html:html>
<head>
<title><bean:message key="main.title"/></title>
<LINK rel="stylesheet" href="<%=request.getContextPath()%>/style/main.css" type="text/css">
<meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">  
<SCRIPT language="JavaScript">
function enviar() {
	if(document.loginForm.passforget.checked == true){
		if(document.loginForm.username.value.length <= 0){
			alert('<bean:message key="main.login.passforget"/>');
			return false;
		}
		document.forms[0].action = "<%=request.getContextPath()%>/passrem.do";
		//document.forms[0].submit();   //si tiene boton submit termina enviando dos veces si se quita el comentario
	} else {
		document.forms[0].username.disabled=false;
		document.forms[0].password.disabled=false;
		//document.forms[0].submit();	//si tiene boton submit termina enviando dos veces si se quita el comentario
	}
}
</SCRIPT>
</head>

<body>
<s:set name="idioma" value="es" scope="session" />
<html:form method="post" action="/login">
<table width="100%" height="100%" border="0">
  <tr>
    <td>
	<table width="300 px" align="center">
	<tr>
		<td class="tdlogin"><bean:message key="main.login.username" />:</td>
		<%if (request.getAttribute("mostrarModulos") != null){%>
		<td class="tdlogin" colspan="2"><html:text property="username" styleClass="sel" disabled="true"/>
		<%}else{ 
			if(request.getParameter("username1")!=null){%>
				<td class="tdlogin" colspan="2"><html:text property="username" styleClass="sel" value='<%=request.getParameter("username1")%>'/>
			<%}else{ %>
				<td class="tdlogin" colspan="2"><html:text property="username" styleClass="sel" value='<%=request.getParameter("login")%>'/>
		<%	}
		 } %>
		</td>
	</tr>
	<tr>
		<td class="tdlogin"><bean:message key="main.login.password" />:</td>
		<%if (request.getAttribute("mostrarModulos") != null){%>
		<td class="tdlogin" colspan="2"><html:password property="password" styleClass="sel" disabled="true"/>
		<%}else{ 
			if(request.getParameter("password1")!=null){
			%>
			<td class="tdlogin" colspan="2"><html:password property="password" styleClass="sel" value='<%=request.getParameter("password1")%>'/>
			<%
			}else{
			%>
			<td class="tdlogin" colspan="2"><html:password property="password" styleClass="sel" value='<%=request.getParameter("password")%>'/>
			<%}
		} %>
		</td>
	</tr>
	<TR>
		<TD class="tdlogin" colspan="2"><bean:message key="2300" /></TD>
		<TD><input type="checkbox" name="passforget" value="1" onclick="if(this.checked == true){document.all.password.disabled = true;}else{document.all.password.disabled = false;}"></TD>
	</TR>
	<tr>
		<td class="tdlogin" align="center" style="text-align: center; padding-top: 2px" colspan="3"><INPUT type="submit" value="<bean:message key="main.login.entrar"/>" class="login" onclick="enviar();"></td>
	</tr>
	<%if (request.getAttribute("mostrarModulos") != null){%>
	<tr>
		<td>&nbsp;</td>
		</tr>
	<TR>
		<TD class="tdlogin" colspan="2"><bean:message key="main.login.modulos" /></TD>
		<TD><html:select property="aplicacion" styleClass="select">
			<%if (request.getAttribute("family") != null){%><html:option value='<%=IConstantes.FAMILY%>'><%=IConstantes.FAMILY%></html:option>
			<%}if (request.getAttribute("pets") != null){%><html:option  value='<%=IConstantes.PETS%>'><%=IConstantes.PETS%></html:option>
			<%}if (request.getAttribute("car") != null){%><html:option value='<%=IConstantes.CAR%>'><%=IConstantes.CAR%></html:option>
			<%}%>
		</html:select></TD>
	</TR>
	<%}else if (request.getAttribute("FAILURE") != null) {
%>
	<TD colspan=3><bean:message key="main.login.idioma" /></TD>
	<tr>
		<td class="tdlogin" colspan="3" align="center" style="padding-top: 3px"><span><img src="images/alert_icon.jpg" border="0"></span>&nbsp;<span class="error"><%=(String) request.getAttribute("FAILURE")%></span>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		</tr>
	<%}
%>
<tr>
		<td>&nbsp;</td>
		</tr>
	<tr>
		<td class="tdlogin" colspan="3" align="center"><html:link page="/passchange.jsp"><bean:message key="main.login.passchange" /></html:link></td>
	</tr>
	</table>
	</td>
  </tr>
</table>
</html:form>
</body>
</html:html>