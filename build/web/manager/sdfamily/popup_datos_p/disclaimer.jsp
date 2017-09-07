<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<SCRIPT>
function enviar()
{
	if(document.forms[0].parent_nombre.value==''){
         alert('<bean:message key="6231" />');
         document.forms[0].parent_nombre.focus();
         return false;
	}
	if(document.forms[0].parent_apellido.value==''){
         alert('<bean:message key="6232" />');
         document.forms[0].parent_apellido.focus();
         return false;
	}
	if(document.forms[0].parent_tarjeta.value=='' || document.forms[0].parent_tarjeta.value=='0'){
         alert('<bean:message key="6233" />');
         document.forms[0].parent_tarjeta.focus();
         return false;
	}
	document.forms[0].action="<%=request.getContextPath()%>/DatosPer/Popup/transferir_disclaimer.do"
	document.forms[0].target='a3'
	top.close();
	actualiza_popup_abierto();
	document.forms[0].submit();

}
</SCRIPT>

<html:form target="_self" action="/DatosPer/Popup/disclaimer.do">
	<html:hidden property="parent_usuf_cod" />
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
												<td colspan="2">
													<img src="<%=request.getContextPath()%>/images/int_tit_family.gif">
													<hr>
												</td>
											</tr>
											<tr>
												<td class="tdOverNameOption" colspan="3">
													<bean:message key="2002" />
												</td>
											</tr>
											<tr>
												<td class="tdNameOption" colspan="3"></td>
											</tr>
											<tr>
												<td colspan="2">
													<table border="0" id="tab2" cellspacing="0" cellpadding="0" width="100%">
														<tr>
															<TD colspan="2">
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD colspan="2">
																<bean:message key="6226" />
															</TD>
														</tr>
														<tr>
															<TD colspan="2">
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																&nbsp;
																<bean:message key="27" />
																:&nbsp;
															</TD>
															<TD class="view_item">
																<html:select property="parent_rfam_cod" styleClass="select">
																	<html:options collection="PARENTESCOS" labelProperty="rfam_des" property="rfam_cod" />
																</html:select>
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																&nbsp;
																<bean:message key="4" />
																:&nbsp;
															</TD>
															<TD class="view_item">
																<html:text property="parent_nombre" maxlength="30" size="40" styleClass="sel" />
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																&nbsp;
																<bean:message key="5" />
																:&nbsp;
															</TD>
															<TD class="view_item">
																<html:text property="parent_apellido" maxlength="30" size="40" styleClass="sel" />
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																&nbsp;
																<bean:message key="6206" />
																:&nbsp;
															</TD>
															<TD class="view_item">
																<html:text property="parent_tarjeta" maxlength="20" size="20" styleClass="selNum" />
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
													</table>
												</TD>
											</tr>
											<tr>
												<td colspan="2">
													<table height="30" cellpadding="0" cellspacing="0" border="0" width="100%">
														<tr>
															<td align="center">
																<hr>
															</td>
														</tr>
														<tr align="center" valign="middle">
															<td>
																<INPUT type="button" onclick="top.close()" class="sbttn" value="<bean:message key="global.button.cancelar"/>">
																<INPUT type="button" onclick="enviar()" class="sbttn" value="<bean:message key="global.button.aceptar"/>">
															</td>
														</tr>
														<tr>
															<td>
																<div align="right" class="imprimir">
																	<img alt="<bean:message key="global.imprimiralt"/>" src="<%=request.getContextPath()%>/images/print.gif" border="0" height="22"
																		width="20">
																	&nbsp;
																	<a href="javascript: self.print();"><b><bean:message key="global.imprimir" />
																	</b>
																	</a>
																</div>
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


