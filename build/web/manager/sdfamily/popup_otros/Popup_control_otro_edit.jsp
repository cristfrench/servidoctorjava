<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<html>
	<head>

		<link rel="stylesheet" href="<%=request.getContextPath()%>/style/estilo_family.css" type="text/css">
		<SCRIPT>


function actualizar(){
	convertirACampo('cDia1', 'cMes1', 'cAno1', 'coot_fecha_ini'); 
	convertirACampo('cDia2', 'cMes2', 'cAno2', 'coot_fecha_fin'); 
	document.forms[0].action='<%=request.getContextPath()%>/Control_Otro/Popup/edit_control.do?change=1';
	document.forms[0].submit();
}

function enviar(){

	/*if(document.forms[0].codo_destratamiento.value==''){
         alert('<bean:message key="6150" />');
         document.forms[0].uodo_destratamiento.focus();
         return false;
    }
    }if(!mail(document.forms[0].codo_email) || document.forms[0].codo_email.value==''){
         alert('<bean:message key="6161" />');
         document.forms[0].codo_email.focus();
         return false;
      }*/
	
	convertirACampo('cDia1', 'cMes1', 'cAno1', 'coot_fecha_ini'); 
	convertirACampo('cDia2', 'cMes2', 'cAno2', 'coot_fecha_fin'); 
	
	document.forms[0].action="<%=request.getContextPath()%>/Control_Otro/Popup/transferir_control.do?"
	document.forms[0].target='a3'
	top.close();
	actualiza_popup_abierto();
	document.forms[0].submit();
}

</SCRIPT>

	</head>

	<body >
		<html:form target="_self" action="/Control_Otro/Popup/transferir_control.do">
			<table border="0" width="100%">
				<html:hidden property="coot_usuf_cod" />
				<html:hidden property="coot_cod" />
				<html:hidden property="coot_mails_enviados" />
				<html:hidden property="coot_ultimo_mail" />				
				<tr>
					<td valign=top>
						<input type="hidden" name="num_control" value="<%=request.getParameter("num_control")%>" />


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
														<TD colspan="2">
														&nbsp;
														</TD>
													</tr>
													<tr>
													<td class="view_item"><bean:message key="7271" />
													</td>
													</tr>
													<tr>
															<TD>&nbsp;
															</TD>
													</tr>
													<tr>
														<td colspan="3">

															<table border="0" id="tab2" cellspacing="0" cellpadding="0" width="100%">
																<tr>
																	<TD colspan="2">
																		&nbsp;
																	</TD>
																</tr>
																<tr>
																	<TD class="view_item">
																		<bean:message key="148" />
																	</TD>
																	<td>
																		<html:text property="coot_actividad" maxlength="40" size="30" styleClass="sel" />
																	</td>
																</tr>
																<tr>
																	<TD class="view_item">
																		<bean:message key="controlotroperiodico.fechainicial" />
																	</TD>
																	<td>
																		<html:hidden property="coot_fecha_ini" styleId="coot_fecha_ini" />
																		<script>obtenerCamposFecha('cDia1', 'cMes1', 'cAno1', 'coot_fecha_ini');</script>
																	</td>
																</tr>
																<tr>
																	<TD class="view_item">
																		<bean:message key="controlotroperiodico.fechafinal" />
																	</TD>
																	<td>
																		<html:hidden property="coot_fecha_fin" styleId="coot_fecha_fin" />
																		<script>obtenerCamposFechaFuturo('cDia2', 'cMes2', 'cAno2', 'coot_fecha_fin', 10);</script>
																	</td>
																</tr>
																<tr>
																	<TD class="view_item">
																		<bean:message key="controlotroperiodico.periodo" />
																	</TD>
																	<TD>
																		<html:text property="coot_hacer_cada" maxlength="2" size="10" styleClass="sel" />
																	</TD>
																</tr>
																<tr>
																	<TD class="view_item">
																		<bean:message key="3809" />
																	</TD>
																	<td>
																		<html:text property="coot_docnom" maxlength="80" size="50" styleClass="sel" />
																	</td>
																</tr>
																<tr>
																	<TD class="view_item">
																		<bean:message key="834" />
																	</TD>
																	<td>
																		<html:text property="coot_direccion" maxlength="80" size="50" styleClass="sel" />
																	</td>
																</tr>
																<tr>
																	<TD class="view_item">
																		<bean:message key="835" />
																	</TD>
																	<td>
																		<html:text property="coot_entidad" maxlength="80" size="60" styleClass="sel" />
																	</td>
																</tr>
																<tr>
																	<TD class="view_item">
																		<bean:message key="13" />
																		<html:select property="coot_pais_cod" styleClass="select" onchange="actualizar()">
																			<html:options collection="PAISES" labelProperty="pais_des" property="pais_cod" />
																		</html:select>
																	</TD>
																	<TD class="view_item">
																		<bean:message key="14" />
																		<html:select property="coot_ciudad_cod" styleClass="select">
																			<html:options collection="CIUDADES" labelProperty="ciu_des" property="ciu_cod" />
																		</html:select>
																	</TD>
																</tr>
																<tr>
																	<TD class="view_item">
																		<bean:message key="31" />
																	</TD>
																	<td>
																		<html:text property="coot_indic_pais" maxlength="3" size="3" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)" />
																		&nbsp;
																		<html:text property="coot_indic_ciudad" maxlength="3" size="3" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)" />
																		&nbsp;
																		<html:text property="coot_telefo" maxlength="20" size="20" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)" />
																	</td>
																</tr>
																<tr>
																	<TD class="view_item">
																		<bean:message key="19" />
																	</TD>
																	<td>
																		<html:text property="coot_email" maxlength="60" size="60" styleClass="sel" />
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
																			<img alt="<bean:message key="global.imprimiralt"/>" src="<%=request.getContextPath()%>/images/print.gif" border="0" height="22" width="20">
																			&nbsp;
																			<a href="javascript: self.print();"><b><bean:message key="global.imprimir" /></b>
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
	</body>
</html>



