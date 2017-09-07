<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<SCRIPT>

function enviar()
{
	if(document.forms[0].opt_aniosdesde.value=='' || document.forms[0].opt_aniosdesde.value=='0'){
         alert('<bean:message key="6164" />');
         document.forms[0].opt_aniosdesde.focus();
         return false;
    }if(document.forms[0].opt_anioshasta.value=='' || document.forms[0].opt_anioshasta.value=='0'){
         alert('<bean:message key="6165" />');
         document.forms[0].opt_anioshasta.focus();
         return false;
    }if(document.forms[0].opt_frecuencia.value=='' || document.forms[0].opt_frecuencia.value=='0'){
         alert('<bean:message key="6166" />');
         document.forms[0].opt_frecuencia.focus();
         return false;
    }if(document.forms[0].opt_anioshasta.value - document.forms[0].opt_aniosdesde.value < 0){
       	 document.forms[0].opt_aniosdesde.value='0';
         alert('<bean:message key="6164" />');
         document.forms[0].opt_aniosdesde.focus();
         return false;
    }
	
	document.forms[0].action="<%=request.getContextPath()%>/Control_opto/Popup/transferir_tabla.do"
	document.forms[0].target='a3'
	top.close();
	actualiza_popup_abierto();
	document.forms[0].submit();

}

</SCRIPT>

<html:form target="_self" action="/Control_opto/Popup/add_tabla.do">
	<html:hidden property="opt_cod" />
	
	<input type="hidden" name="num_tabla" value="<%=request.getParameter( "num_tabla" )%>" />
	<table border="0" width="100%">
		<tr>
			<td valign=top>
				<table class="tablag" align="center" cellpadding="0" cellspacing="0" border="0" width="590">
					<tr>
						<td>
							<table align="center" cellpadding="0" cellspacing="0" border="0" width="100%">
								<tr>
									<td>
										<table cellpadding="0" cellspacing="0" border="0" width="100%">
											<tr>
												<td colspan="3">
													<img src="<%=request.getContextPath()%>/images/int_tit_family.gif">
													<hr>
												</td>
											</tr>
											<tr>
												<td class="tdOverNameOption" colspan="3">
													<bean:message key="515" />
												</td>
											</tr>
											<tr>
												<td class="tdNameOption" colspan="3">
													<bean:message key="138" />
													&nbsp;
													<bean:message key="708" />
												</td>
											</tr>
											<tr>
												<td colspan="3">
													<table border="0" id="tab2" cellspacing="0" cellpadding="0" width="100%">
														<tr>
															<TD colspan="2" class="view_item">
																&nbsp;
																<bean:message key="7227" />
															</TD>
														</tr>
														<tr>
															<TD colspan="2">
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD colspan="2">
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD colspan="2">
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="555" />
																:&nbsp;
																<bean:message key="124" />
															</TD>
															<TD>
																<html:text property="opt_aniosdesde" maxlength="3" size="3" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)" />
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="555" />
																:&nbsp;
																<bean:message key="125" />
															</TD>
															<TD>
																<html:text property="opt_anioshasta" maxlength="3" size="3" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)" />
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="128" />
																:&nbsp;
															</TD>
															<TD>
																<html:text property="opt_frecuencia" maxlength="2" size="3" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)" />
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
												<td colspan="3">
													<table height="30" cellpadding="0" cellspacing="0" border="0" width="100%">
														<tr>
															<td align="center">
																<hr>
															</td>
														</tr>
														<tr align="center" valign="middle">
															<td>
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
