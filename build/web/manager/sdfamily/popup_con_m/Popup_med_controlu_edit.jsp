<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<SCRIPT>

function enviar()
{
	if(document.forms[0].cmed_destratamiento.value==''){
         alert('<bean:message key="6150" />');
         document.forms[0].cmed_destratamiento.focus();
         return false;
    }
	convertirACampo('cDia1', 'cMes1', 'cAno1', 'cmed_feccontrol'); 
	document.forms[0].action="<%=request.getContextPath()%>/Control_Medico/Popup/transferir_controlU.do"
	document.forms[0].target='a3'
	top.close();
	actualiza_popup_abierto();
	document.forms[0].submit();
}

</SCRIPT>

<html:form target="_self" action="/Control_Medico/Popup/transferir_controlU.do">
	<html:hidden property="cmed_usuf_cod" />
	<html:hidden property="cmed_grup_cod" />
	<html:hidden property="cmed_mails_enviados" />
	<html:hidden property="cmed_ultimo_mail" />
	<html:hidden property="cmed_exa_cod" />
	<html:hidden property="cmed_cod" />
	<html:hidden property="cmed_destratamiento" />
	<input type="hidden" name="num_controlu" value="<%=request.getParameter( "num_controlu" )%>" />
	<table border="0" width="100%">
		<tr>
			<td valign=top>
				<table class="tablag" align="center" cellpadding="0" cellspacing="0" border="0" width="610">
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
													<bean:message key="2153" />
												</td>
											</tr>
											<tr>
												<td class="tdNameOption" colspan="3">
													<bean:message key="138" />
													&nbsp;
													<bean:message key="839" />
												</td>
											</tr>
											<tr>
												<td colspan="3">
													<table border="0" id="tab2" cellspacing="0" cellpadding="0" width="100%">
														
														<tr>
															<TD colspan="2" class="view_item">
																&nbsp;
																<bean:message key="7241" />
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="148" />
															</TD>
															<td class="view_item">
																<bean:write name="controlMedicoForm" property="cmed_destratamiento"  />
															</td>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="115" />
															</TD>
															<td>
																<html:hidden property="cmed_feccontrol" styleId="cmed_feccontrol" />
																<script>obtenerCamposFecha('cDia1', 'cMes1', 'cAno1', 'cmed_feccontrol');</script>
															</td>
														</tr>

														<tr>
															<TD class="view_item" colspan="2">
																<bean:message key="91" />
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="4" />
															</TD>
															<td>
																<html:text property="cmed_nommedico" maxlength="30" size="50" styleClass="sel" />
															</td>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="5" />
															</TD>
															<td>
																<html:text property="cmed_apemedico" maxlength="30" size="50" styleClass="sel" />
															</td>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="834" />
															</TD>
															<td>
																<html:text property="cmed_direccion" maxlength="80" size="50" styleClass="sel" />
															</td>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="835" />
															</TD>
															<td>
																<html:text property="cmed_entidad" maxlength="40" size="60" styleClass="sel" />
															</td>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="13" />
																<html:select property="cmed_pais_cod" styleClass="select" onchange="actualizarCiudades(this.value)">
																	<html:options collection="PAISES" labelProperty="pais_des" property="pais_cod" />
																</html:select>
															</TD>
															<TD class="view_item">
																<bean:message key="14" />
																<html:select property="cmed_ciudad_cod" styleClass="select" styleId="ciudadesContent">
																	<html:options collection="CIUDADES" labelProperty="ciu_des" property="ciu_cod" />
																</html:select>
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="31" />
															</TD>
															<td>
																<html:text property="cmed_indpais" maxlength="3" size="3" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)" />
																&nbsp;
																<html:text property="cmed_indciudad" maxlength="3" size="3" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)" />
																&nbsp;
																<html:text property="cmed_telefono" maxlength="15" size="20" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)" />
															</td>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="19" />
															</TD>
															<td>
																<html:text property="cmed_email" maxlength="30" size="60" styleClass="sel" />
															</td>
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
																	<a href="javascript: self.print();"><b><bean:message key="global.imprimir" /> </b> </a>
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


