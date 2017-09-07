
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<SCRIPT>

function enviar(){
      if(document.forms[0].cveh_concepto.value==''){
         alert('<bean:message key="5026" />');
         document.forms[0].cveh_concepto.focus();
         return false;
      }
     convertirACampo('cDia', 'cMes', 'cAno', 'cveh_fecvigenc'); 
   	document.forms[0].action="<%=request.getContextPath()%>/DatosVehiculo/Popup/transferir_control.do"
	document.forms[0].target='a3';
	top.close();
	actualiza_popup_abierto();
	document.forms[0].submit();
}




</SCRIPT>

<html:form target="_self" action="/DatosVehiculo/Popup/edit_control.do">
	<input type="hidden" name="num_control" value="<%=request.getParameter( "num_control" )%>" />
	<html:hidden property="cveh_cod" />
	<html:hidden property="cveh_veh_cod" />
	<html:hidden property="cveh_mails_enviados" />
	<html:hidden property="cveh_ultimo_mail" />
	<table border="0" width="100%">
		<tr>
			<td valign=top>
				<table class="tablag" align="center" cellpadding="0" cellspacing="0" border="0" width="550">
					<tr>
						<td>
							<table align="center" cellpadding="0" cellspacing="0" border="0" width="100%">
								<tr>
									<td>
										<table cellpadding="0" cellspacing="0" border="0" width="100%">
											<tr>
												<td colspan="2">
													<img src="<%=request.getContextPath()%>/images/int_tit_car.gif">
													<hr>
												</td>
											</tr>
											<tr>
												<TD class="tdOverNameOption" colspan="2">
													<bean:message key="3529" />
													&nbsp;
													<%=Integer.parseInt( request.getParameter( "num_control" ) ) + 1%>
													&nbsp;&nbsp;-&nbsp;&nbsp;
													<bean:message key="global.button.editar" />
													&nbsp;
													<bean:message key="3522" />
												</TD>
											</tr>
											<tr>
												<td>
													&nbsp;

												</td>
											</tr>
											<tr>
												<td colspan="2" class="view_item">
													<bean:message key="7419" />
												</td>
											</tr>
											<tr>
												<td>
													&nbsp;

												</td>
											</tr>
											<tr>
												<TD class="view_item">
													<bean:message key="1091" />
													:&nbsp;
												</TD>
												<td>
													<html:text property="cveh_concepto" maxlength="80" size="50" styleClass="sel" />
												</td>
											</tr>
											<tr>
												<TD class="view_item">
													<bean:message key="1092" />
													&nbsp;&nbsp;
												</TD>
												<TD class="tdContentText">
													<html:hidden property="cveh_fecvigenc" styleId="cveh_fecvigenc" />
													<SCRIPT language="JavaScript">obtenerCamposFechaFuturo('cDia', 'cMes', 'cAno', 'cveh_fecvigenc',10);</SCRIPT>
												</TD>
											</tr>
											<tr>
												<td colspan="2">
													<table height="30" cellpadding="0" cellspacing="0" border="0" width="100%">
														<tr>
															<td colspan="2" align="center">
																<hr>
															</td>
														</tr>
														<tr align="center" valign="middle">
															<TD colspan="2" align="center">
																<INPUT type="button" onClick="enviar()" class="sbttn" value="<bean:message key="global.button.aceptar"/>">
															</TD>
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
