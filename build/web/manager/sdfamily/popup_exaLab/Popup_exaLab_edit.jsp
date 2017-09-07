<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<html>
<head>

<link rel="stylesheet" href="/ServiDoctor/style/estilo_family.css" type="text/css">
<SCRIPT>
function enviar(x)
{
document.forms[0].action="/ServiDoctor/Exa_Lab/Popup/transferir_control.do?num_control="+x
document.forms[0].target='a3'
top.close();
document.forms[0].submit();


}

</SCRIPT>

</head>

<body>
<html:form target="_self" action="/Exa_Lab/Popup/edit_control.do">
	<table border="0" width="100%">

		<tr>
			<td valign=top>


			<table class="tablag" align="center" cellpadding="0" cellspacing="0" border="0" width="600">
				<tr>
					<td>
					<table align="center" cellpadding="0" cellspacing="0" border="0" width="100%">

						<tr>
							<td>
							<table cellpadding="0" cellspacing="0" border="0" width="100%">
								<tr>
									<td colspan="3"><img src="/ServiDoctor/images/int_tit_family.gif">
									<hr>
									</td>
								</tr>
								<tr>
									<td class="tdOverNameOption" colspan="3"><bean:message key="840" /></td>
								</tr>
								<tr>
									<td class="tdOverNameOption" colspan="3"><bean:message key="138" />&nbsp;<bean:message key="845" /></td>
								</tr>
								<tr>
									<td colspan="3">

									<table border="0" id="tab2" cellspacing="0" cellpadding="0" width="100%">
										<tr>
											<TD colspan="2">&nbsp;</TD>
											<html:hidden property="elab_cod" />
										</tr>

										<tr>
											<TD class="view_item"><bean:message key="842" />:&nbsp;</TD>
											<td><html:text property="elab_des" maxlength="50" size="50" styleClass="sel" /></td>
										</tr>
										<tr>
											<TD class="view_item"><bean:message key="853" />&nbsp;1:&nbsp;</TD>
											<td><html:text property="elab_fecha1" maxlength="7" size="7" styleClass="sel" /></td>
										</tr>
										<tr>
											<TD class="view_item"><bean:message key="854" />&nbsp;1:&nbsp;</TD>
											<td><html:text property="elab_resultado1" maxlength="6" size="6" styleClass="selNum" /></td>
										</tr>
										<tr>
											<TD class="view_item"><bean:message key="853" />&nbsp;2:&nbsp;</TD>
											<td><html:text property="elab_fecha2" maxlength="7" size="7" styleClass="sel" /></td>
										</tr>
										<tr>
											<TD class="view_item"><bean:message key="854" />&nbsp;2:&nbsp;</TD>
											<td><html:text property="elab_resultado2" maxlength="6" size="6" styleClass="selNum" /></td>
										</tr>
										<tr>
											<TD class="view_item"><bean:message key="853" />&nbsp;3:&nbsp;</TD>
											<td><html:text property="elab_fecha3" maxlength="7" size="7" styleClass="sel" /></td>
										</tr>
										<tr>
											<TD class="view_item"><bean:message key="854" />&nbsp;3:&nbsp;</TD>
											<td><html:text property="elab_resultado3" maxlength="6" size="6" styleClass="selNum" /></td>
										</tr>

										<tr>
											<TD>&nbsp;</TD>

										</tr>

										
									</table>
									</TD>
								</tr>

								<tr>
									<td colspan="3">
									<table height="30" cellpadding="0" cellspacing="0" border="0" width="100%">
										<tr>
											<td align="center">
											<hr>
											</td>
										</tr>
										<tr align="center" valign="middle">
											<td><INPUT type="button" onclick="enviar('<%=request.getAttribute("num_control")%>')" class="sbttn" value="Aceptar"></td>
										</tr>
										<tr>
											<td>

											<div align="right" class="imprimir"><img alt="<bean:message key="global.imprimiralt"/>" src="/ServiDoctor/images/print.gif" border="0" height="22" width="20">&nbsp;<a href="javascript: self.print();"><b><bean:message key="global.imprimir" /></b></a></div>



											</td>
										</tr>
									</table>
									</td>
								</tr>
							</table>
							</td>
						</tr>
					</table>
					</td>
				</tr>
			</table>




			</td>
		</tr>
	</table>

</html:form>
</body>
</html>



