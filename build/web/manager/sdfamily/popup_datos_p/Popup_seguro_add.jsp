<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="org.apache.struts.util.MessageResources"%>

<%!MessageResources res = MessageResources.getMessageResources( "com.servidoctor.resources.ApplicationResources" );%>
<SCRIPT>

function enviar()
{

	if(document.forms[0].segm_nomcia.value=='' || document.forms[0].segm_nomcia.value=='0'){
         alert('<bean:message key="6111" />');
         document.forms[0].segm_nomcia.focus();
         return false;
	}if(document.forms[0].segm_polizaafi.value==''){
         alert('<bean:message key="6112" />');
         document.forms[0].segm_polizaafi.focus();
         return false;
	}if(document.forms[0].segm_contacto.value=='' || document.forms[0].segm_contacto.value=='0'){
         alert('<bean:message key="6113" />');
         document.forms[0].segm_contacto.focus();
         return false;
	}
	convertirACampo('cDia1', 'cMes1', 'cAno1', 'segm_vig_desde');
	convertirACampo('cDia2', 'cMes2', 'cAno2', 'segm_vig_hasta');
	document.forms[0].action="<%=request.getContextPath()%>/DatosPer/Popup/transferir_seguro.do"
	document.forms[0].target='a3'
	top.close();
	actualiza_popup_abierto();
	document.forms[0].submit();

}

</SCRIPT>

<html:form target="_self" action="/DatosPer/Popup/add_seguro.do">
	<table border="0" width="100%">
		<tr>
			<td valign=top>
				<table class="tablag" align="center" cellpadding="0" cellspacing="0" border="0" width="650">
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
													<bean:message key="2002" />
												</td>
											</tr>
											<tr>
												<td class="tdNameOption" colspan="3">
													<bean:message key="global.button.adicionar" />
													&nbsp;
													<bean:message key="3" />
												</td>
											</tr>
											<tr>
												<td colspan="3">
													<table border="0" id="tab2" cellspacing="0" cellpadding="0" width="100%">
														<tr>
															<TD colspan="2" class="view_item">
																&nbsp;
																<P ALIGN="JUSTIFY">
																	<bean:message key="7206" arg0="<%=res.getMessage( "parametro_adicion_seguro" )%>" />
																</P>
															</TD>
														</tr>
														<tr>
															<TD colspan="2">
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="28" />
																:&nbsp;
															</TD>
															<TD class="view_item">
																<html:text property="segm_nomcia" maxlength="40" size="40" styleClass="sel" />
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="29" />
																:&nbsp;
															</TD>
															<TD class="view_item">
																<html:text property="segm_polizaafi" maxlength="40" size="40" styleClass="sel" />
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="30" />
																:&nbsp;
															</TD>
															<TD class="view_item">
																<html:text property="segm_contacto" maxlength="60" size="40" styleClass="sel" />
															</TD>
														</tr>
														<table border="0" cellspacing="0" cellpadding="0" width="100%">
														<tr>
															<TD class="view_item">
																<bean:message key="807" />
																:&nbsp;
															</td>
															<td>
																<html:hidden property="segm_vig_desde" styleId="segm_vig_desde" />
																<SCRIPT language="JavaScript">obtenerCamposFecha('cDia1', 'cMes1', 'cAno1', 'segm_vig_desde');</SCRIPT>
															</td>
																<TD class="view_item">
																<bean:message key="808" />
																:&nbsp;
															</td>
														<td>
																<html:hidden property="segm_vig_hasta" styleId="segm_vig_hasta" />
																<SCRIPT language="JavaScript">obtenerCamposFechaFuturo('cDia2', 'cMes2', 'cAno2', 'segm_vig_hasta',10);</SCRIPT>
															</td>
														</tr>
														</table>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="tdNameOption" colspan="2">
																<bean:message key="15" />
															</TD>
														</tr>
														<tr>
															<TD class="view_item" colspan="2">
																&nbsp;
																<bean:message key="16" />
																&nbsp;
																<bean:message key="13" />
																:
																<html:text property="segm_indpais1" maxlength="3" size="4" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)"
																	onfocus="this.select()" />
																<bean:message key="14" />
																:
																<html:text property="segm_indciudad1" maxlength="3" size="4" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)"
																	onfocus="this.select()" />
																<bean:message key="17" />
																:
																<html:text property="segm_telefono1" maxlength="15" size="10" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)"
																	onfocus="this.select()" />
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="tdNameOption" colspan="2">
																<bean:message key="18" />
															</TD>
														</tr>
														<tr>
															<TD class="view_item" colspan="2">
																<bean:message key="16" />
																&nbsp;
																<bean:message key="13" />
																:&nbsp;
																<html:text property="segm_indpais2" maxlength="3" size="4" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)"
																	onfocus="this.select()" />
																<bean:message key="17" />
																:
																<html:text property="segm_telefono2" maxlength="15" size="10" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)"
																	onfocus="this.select()" />
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="tdNameOption" colspan="2">
																<bean:message key="6114" />
															</TD>
														</tr>
														<tr>
															<TD class="view_item" colspan="2">
																&nbsp;
																<bean:message key="16" />
																&nbsp;
																<bean:message key="13" />
																:
																<html:text property="segm_indpais3" maxlength="3" size="4" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)"
																	onfocus="this.select()" />
																<bean:message key="14" />
																:
																<html:text property="segm_indciudad3" maxlength="3" size="4" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)"
																	onfocus="this.select()" />
																<bean:message key="17" />
																:
																<html:text property="segm_telefono3" maxlength="15" size="10" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)"
																	onfocus="this.select()" />
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																&nbsp;
																<bean:message key="19" />
																:&nbsp;
															</TD>
															<TD class="view_item">
																<html:text property="segm_email" maxlength="30" size="50" styleClass="sel" />
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
																<INPUT type="button" onClick="enviar()" class="sbttn" value="<bean:message key="global.button.aceptar"/>">
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




