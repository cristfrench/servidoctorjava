
<%@ page import="com.servidoctor.constantes.IConstantes"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<html:html>
<head>
<meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
	<SCRIPT language="JavaScript" src="<%=request.getContextPath()%>/script/funciones.js"></SCRIPT>
	<LINK rel="stylesheet" href="<%=request.getContextPath()%>/style/main.css" type="text/css">
	<SCRIPT language="JavaScript">
		function changeRadio(){
			if(document.forms[0].radio[0].checked){
				document.all.idPass.style.display='none'
				document.all.idLogin.style.display=''
				document.forms[0].password1.value = document.forms[0].password2.value
			}else{
				document.all.idPass.style.display=''
				document.all.idLogin.style.display='none'
				document.forms[0].username1.value = document.forms[0].username2.value
			}
		}
		
		function enviar(){
			if ((document.forms[0].username1.value != document.forms[0].username2.value)|| (document.forms[0].password1.value != document.forms[0].password2.value)){
				alert("<bean:message key='main.login.loginPasswordNuevosDiferentes' />");
				return false;
			}
			
			if (document.forms[0].radio[0].checked){

				if(document.forms[0].servicio.value=="0"){
					alert("<bean:message key='main.activar.loginleft' />");
					document.forms[0].servicio.select();
					return false;				
				}
				if(!mail(document.forms[0].username1)){
					alert("<bean:message key='main.activar.login' />");
					document.forms[0].username1.focus();
					return false;				
				}
				document.forms[0].action = '<%=request.getContextPath()%>/passChange.do?login';
			}else{
				if(document.forms[0].servicio.value==0){
					alert("<bean:message key='main.activar.loginleft'  />");
					document.forms[0].servicio.select();
					return false;				
				}
				if((document.forms[0].password1.value.length < 5)){
					alert("<bean:message key='main.activar.password' />");
					document.forms[0].password1.focus();
					return false;			
				}
				if((document.forms[0].password1.value.length > 10)){
					alert("<bean:message key='main.activar.password2' />");
					document.forms[0].password1.focus();
					return false;			
				}
				document.forms[0].action = '<%=request.getContextPath()%>/passChange.do?pass';
			}
			document.forms[0].submit();
		}
		
	</SCRIPT>
</head>
<body>
	<html:form method="post" action="/passChange">
	<table width="100%" height="100%" border="0">
  <tr>
    <td>
		<table width="350 px" align="center">
			<tr>
				<td class="tdlogin" colspan="4">
					<html:radio property="radio" value="login" onclick="changeRadio()" />
					<bean:message key="main.login.loginchange" />
					:
				</td>
			</tr>
			<tr>
				<td class="tdlogin" colspan="4">
					<html:radio property="radio" value="pass" onclick="changeRadio()" />
					<bean:message key="main.login.passchange" />
					:
				</td>
			</tr>
			<tr>
				<td class="tdlogin">
					<bean:message key="main.login.usernamechange" />:
				</td>
				<td class="tdlogin" colspan="2">
					<html:text property="username" styleClass="sel" />
				</td>
			</tr>
			<tr>
				<td class="tdlogin">
					<bean:message key="main.login.password" />
					:
				</td>
				<td class="tdlogin" colspan="2">
					<html:password property="password" styleClass="sel" />
				</td>
			</tr>
			<tr>
					<td class="tdlogin">
						<bean:message key="9934" />:
					</td>
					<td class="tdlogin" colspan="2">
						<html:select property="servicio" styleClass="sel">
							<html:option value="0"><bean:message key="9935" /></html:option>
							<html:option value="<%=IConstantes.FAMILY%>"><%=IConstantes.FAMILY%></html:option>
							<html:option value="<%=IConstantes.PETS%>"><%=IConstantes.PETS%></html:option>
							<html:option value="<%=IConstantes.CAR%>"><%=IConstantes.CAR%></html:option>
						</html:select>															
					</td>
				</tr>
			<tbody id="idLogin">
				
				<tr>
					<td class="tdlogin">
						<bean:message key="main.login.usernamenew" />:
					</td>
					<td class="tdlogin" colspan="2">
						<input type="text" name="username1" class="sel" />
					</td>
				</tr>
				<tr>
					<td class="tdlogin">
						<bean:message key="main.login.usernamenew" />:
					</td>
					<td class="tdlogin" colspan="2">
						<input type="text" name="username2" class="sel" />
					</td>
				</tr>
				<tr>
					<td class="tdlogin" align="center" style="text-align: center; padding-top: 2px" colspan="3">
						<INPUT type="button" value="•CAMBIAR" class="login" onclick="enviar();">
					</td>
				</tr>
			</tbody>
			<tbody id="idPass">
				<tr>
					<td class="tdlogin">
						<bean:message key="main.login.passwordnew" />:
					</td>
					<td class="tdlogin" colspan="2">
						<input type="password" name="password1" class="sel" />
					</td>
				</tr>
				<tr>
					<td class="tdlogin">
						<bean:message key="main.login.passwordnew" />:
					</td>
					<td class="tdlogin" colspan="2">
						<input type="password" ext" name="password2" class="sel" />
					</td>
				</tr>
				<tr>
					<td class="tdlogin" align="center" style="text-align: center; padding-top: 2px" colspan="3">
						<INPUT type="button" value="•CAMBIAR" class="login" onclick="enviar();">
					</td>
				</tr>
			</tbody>
			<%
			if (request.getAttribute("mostrarModulos") != null) {
			%>
			<TR>
				<TD class="tdlogin" colspan="2">
					<bean:message key="main.login.modulos" />
				</TD>
				<TD>
					<html:select property="aplicacion" styleClass="select">
						<%
						if (request.getAttribute("family") != null) {
						%>
						<html:option value="<%=IConstantes.FAMILY%>">
							<%=IConstantes.FAMILY%>
						</html:option>
						<%
									}
									if (request.getAttribute("pets") != null) {
						%>
						<html:option value="<%=IConstantes.PETS%>">
							<%=IConstantes.PETS%>
						</html:option>
						<%
									}
									if (request.getAttribute("car") != null) {
						%>
						<html:option value="<%=IConstantes.CAR%>">
							<%=IConstantes.CAR%>
						</html:option>
						<%
						}
						%>
					</html:select>
				</TD>
			</TR>
			<%
			} else if (request.getAttribute("FAILURE") != null) {
			%>
			<tr>
				<td class="tdlogin" colspan=3 align="center" style="padding-top: 3px">
					<span><img src="images/alert_icon.jpg" border="0"> </span>&nbsp;
					<span class="error"><%=(String) request.getAttribute("FAILURE")%> </span>
				</td>
			</tr>
			<%
			}
			%>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td class="tdlogin" colspan=3 align="center"><html:link page="/login.jsp"><bean:message key="main.login" /></html:link></td>
			</tr>
		</table>
		</td>
  </tr>
</table>
	</html:form>
</body>
<script>changeRadio()</script>
</html:html>
