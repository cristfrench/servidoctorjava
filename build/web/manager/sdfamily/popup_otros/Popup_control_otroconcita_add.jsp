<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<html>
	<head>

		<link rel="stylesheet" href="<%=request.getContextPath()%>/style/estilo_family.css" type="text/css">
		<SCRIPT>

function actualizar(){
	convertirACampo('cDia1', 'cMes1', 'cAno1', 'cootc_fecha'); 
	convertirACampoHora('hora1','minuto1','ampm1','cootc_hora');
	document.forms[0].action='<%=request.getContextPath()%>/Control_Otro/Popup/add_controlconcita.do?change=1';
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
	
	convertirACampo('cDia1', 'cMes1', 'cAno1', 'cootc_fecha');
	convertirACampoHora('hora1','minuto1','ampm1','cootc_hora');
	
	document.forms[0].action="<%=request.getContextPath()%>/Control_Otro/Popup/transferir_controlconcita.do?"
	document.forms[0].target='a3'
	top.close();
	actualiza_popup_abierto()
	document.forms[0].submit();
}


</SCRIPT>

	</head>

	<body >
		<html:form target="_self" action="/Control_Otro/Popup/transferir_controlconcita.do">
			<table border="0" width="100%">
				<html:hidden property="cootc_usuf_cod" />
				<html:hidden property="cootc_cod" />
				<html:hidden property="cootc_mails_enviados" />
				<html:hidden property="cootc_ultimo_mail" />
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
															<bean:message key="2167" />
														</td>
													</tr>
													<tr>
														<td class="tdNameOption" colspan="3">
															<bean:message key="global.button.adicionar" />
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
													<td class="view_item"><bean:message key="7272" />
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
																	<TD colspan="3">
																		&nbsp;
																	</TD>
																</tr>
																<tr>
																	<TD class="view_item">
																		<bean:message key="148" />
																	</TD>
																	<td>
																		<html:text property="cootc_actividad" maxlength="40" size="30" styleClass="sel" />
																	</td>
																</tr>
																<tr>
																	<TD class="view_item">
																		<bean:message key="1517" />
																	</TD>
																	<td>
																		<html:hidden property="cootc_fecha" styleId="cootc_fecha" />
																		<script>obtenerCamposFechaFuturo('cDia1', 'cMes1', 'cAno1', 'cootc_fecha',15);</script>
																	</td>
																</tr>
																<tr>
																	<TD class="view_item">
																		<bean:message key="controlotroconcita.hora" />
																	</TD>
																	<td>
																		<html:hidden property="cootc_hora" styleId="cootc_hora" />
																		<script language="JavaScript">CamposHora('hora1','minuto1','ampm1','cootc_hora');</script>
																	</td>
																</tr>
																<tr>
																	<TD class="view_item">
																		<bean:message key="controlotroconcita.nombredoctor" />
																	</TD>
																	<td>
																		<html:text property="cootc_docnom" maxlength="40" size="30" styleClass="sel" />
																	</td>
																</tr>
																<tr>
																	<TD class="view_item">
																		<bean:message key="controlotroconcita.entidad" />
																	</TD>
																	<TD>
																		<html:text property="cootc_entidad" maxlength="40" size="10" styleClass="sel" />
																	</TD>
																</tr>
																<tr>
																	<TD class="view_item">
																		<bean:message key="13" />
																		<html:select property="cootc_pais_cod" styleClass="select" onchange="actualizar()">
																			<html:options collection="PAISES" labelProperty="pais_des" property="pais_cod" />
																		</html:select>
																	</TD>
																	<TD class="view_item">
																		<bean:message key="14" />
																		<html:select property="cootc_ciudad_cod" styleClass="select">
																			<html:options collection="CIUDADES" labelProperty="ciu_des" property="ciu_cod" />
																		</html:select>
																	</TD>
																</tr>
																<tr>
																	<TD class="view_item">
																		<bean:message key="834" />
																	</TD>
																	<td>
																		<html:text property="cootc_direccion" maxlength="80" size="50" styleClass="sel" />
																	</td>
																</tr>
																
																<tr>
																	<TD class="view_item">
																		<bean:message key="31" />
																	</TD>
																	<td>
																		<html:text property="cootc_indic_pais" maxlength="3" size="3" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)" />
																		&nbsp;
																		<html:text property="cootc_indic_ciudad" maxlength="3" size="3" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)" />
																		&nbsp;
																		<html:text property="cootc_telefo" maxlength="20" size="20" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)" />
																	</td>
																</tr>
																<tr>
																	<TD class="view_item">
																		<bean:message key="19" />
																	</TD>
																	<td>
																		<html:text property="cootc_email" maxlength="60" size="60" styleClass="sel" />
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
																			<a href="javascript: self.print();"><b><bean:message key="global.imprimir" /></b> </a>
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
