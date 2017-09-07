<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<SCRIPT>

function enviar()
{
	if(document.forms[0].codo_destratamiento.value==''){
         alert('<bean:message key="6150" />');
         document.forms[0].uodo_destratamiento.focus();
         return false;
    }
	
	convertirACampo('cDia1', 'cMes1', 'cAno1', 'codo_feccontrol'); 
	convertirACampoHora('hora','minuto','ampm','codo_hora');
	
	document.forms[0].action="<%=request.getContextPath()%>/Control_Odont/Popup/transferir_controlP.do"
	document.forms[0].target='a3'
	top.close();
	actualiza_popup_abierto();
	document.forms[0].submit();
}

</SCRIPT>

<html:form target="_self" action="/Control_Odont/Popup/transferir_controlP.do">
	<html:hidden property="codo_usuf_cod" />
	<html:hidden property="codo_grup_cod" />
	<html:hidden property="codo_mails_enviados" />
	<html:hidden property="codo_ultimo_mail" />
	<html:hidden property="codo_odo_cod" />
	<html:hidden property="codo_cod" />
	<html:hidden property="codo_destratamiento" />
	<input type="hidden" name="num_controlp" value="<%=request.getParameter( "num_controlp" )%>" />
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
												<td colspan="3">
													<img src="<%=request.getContextPath()%>/images/int_tit_family.gif">
													<hr>
												</td>
											</tr>
											<tr>
												<td class="tdOverNameOption" colspan="3">
													<bean:message key="514" />
												</td>
											</tr>
											<tr>
												<td class="tdNameOption" colspan="3">
													<bean:message key="138" />
													&nbsp;
													<bean:message key="838" />
												</td>
											</tr>
											<tr>
												<td colspan="3">
													<table border="0" id="tab2" cellspacing="0" cellpadding="0" width="100%">
														<tr>
															<TD colspan="2" class="view_item">
																&nbsp;
																<bean:message key="7235" />
															</TD>
														</tr>
														<tr>
															<TD colspan="2">
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="148" />
															</TD>
															<td class="view_item">
																<bean:write name="controlOdontologiaForm" property="codo_destratamiento" />
															</td>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="3805" />
															</TD>
															<td>
																<html:hidden property="codo_feccontrol" styleId="codo_feccontrol" />
																<script>obtenerCamposFechaFuturo('cDia1', 'cMes1', 'cAno1', 'codo_feccontrol', 10);</script>
															</td>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="1999" />
															</TD>
															<td class='view_item'>
																<html:hidden property="codo_hora" styleId="codo_hora" />
																<SCRIPT language="JavaScript">
											    					CamposHora('hora','minuto','ampm','codo_hora');							    											    					
											    				</SCRIPT>
															</td>
														</tr>
														<tr>
															<TD class="view_item" colspan="2">
																<bean:message key="116" />
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
																<html:text property="codo_nommedico" maxlength="30" size="50" styleClass="sel" />
															</td>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="5" />
															</TD>
															<td>
																<html:text property="codo_apemedico" maxlength="30" size="50" styleClass="sel" />
															</td>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="834" />
															</TD>
															<td>
																<html:text property="codo_direccion" maxlength="80" size="50" styleClass="sel" />
															</td>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="835" />
															</TD>
															<td>
																<html:text property="codo_entidad" maxlength="40" size="60" styleClass="sel" />
															</td>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="13" />
																<html:select property="codo_pais_cod" styleClass="select" onchange="actualizarCiudades(this.value)">
																	<html:options collection="PAISES" labelProperty="pais_des" property="pais_cod" />
																</html:select>
															</TD>
															<TD class="view_item">
																<bean:message key="14" />
																<html:select property="codo_ciudad_cod" styleClass="select" styleId="ciudadesContent">
																	<html:options collection="CIUDADES" labelProperty="ciu_des" property="ciu_cod" />
																</html:select>
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="31" />
															</TD>
															<td>
																<html:text property="codo_indpais" maxlength="3" size="3" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)" />
																&nbsp;
																<html:text property="codo_indciudad" maxlength="3" size="3" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)" />
																&nbsp;
																<html:text property="codo_telefono" maxlength="15" size="20" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)" />
															</td>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="19" />
															</TD>
															<td>
																<html:text property="codo_email" maxlength="30" size="60" styleClass="sel" />
															</td>
														</tr>
														<tr>
															<TD>
																&nbsp;
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


