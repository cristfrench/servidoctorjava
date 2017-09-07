<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


<SCRIPT>
function enviar()
{
	noTelFijo = false;
    noTelMovil = false;
    if ((Trim(document.forms[0].case_indpais1.value)=='' || document.forms[0].case_indpais1.value=='0') || (Trim(document.forms[0].case_indciudad1.value)=='' || document.forms[0].case_indciudad1.value=='0') || (Trim(document.forms[0].case_telefono1.value)=='' || document.forms[0].case_telefono1.value=='0')){
    	noTelFijo = true;
    }if ((Trim(document.forms[0].case_indpais2.value=='') || document.forms[0].case_indpais2.value=='0') || (Trim(document.forms[0].case_telefono2.value)=='' || document.forms[0].case_telefono2.value=='0')){
    	noTelMovil = true;
    }
	if(document.forms[0].case_nombre.value=='' || document.forms[0].case_nombre.value=='0'){
         alert('<bean:message key="6102" />');
         document.forms[0].case_nombre.focus();
         return false;
	}if(document.forms[0].case_apellido.value=='' || document.forms[0].case_apellido.value=='0'){
         alert('<bean:message key="6103" />');
         document.forms[0].case_apellido.focus();
         return false;
	}if((document.forms[0].case_indpais1.value=='' || document.forms[0].case_indpais1.value=='0') && noTelMovil){
         alert('<bean:message key="6104" />');
         document.forms[0].case_indpais1.focus();
         return false;
	}if((document.forms[0].case_indciudad1.value=='' || document.forms[0].case_indciudad1.value=='0') && noTelMovil){
         alert('<bean:message key="6105" />');
         document.forms[0].case_indciudad1.focus();
         return false;
	}if((document.forms[0].case_telefono1.value=='' || document.forms[0].case_telefono1.value=='0') && noTelMovil){
         alert('<bean:message key="6106" />');
         document.forms[0].case_telefono1.focus();
         return false;
	}if((document.forms[0].case_indpais2.value=='' || document.forms[0].case_indpais2.value=='0') && noTelFijo){
         alert('<bean:message key="6107" />');
         document.forms[0].case_indpais2.focus();
         return false;
	}if((document.forms[0].case_telefono2.value=='' || document.forms[0].case_telefono2.value=='0') && noTelFijo){
         alert('<bean:message key="6108" />');
         document.forms[0].case_telefono2.focus();
         return false;
	}
	document.forms[0].case_mail.value = Trim(document.forms[0].case_mail.value);
	
	document.forms[0].action="<%=request.getContextPath()%>/DatosPer/Popup/transferir_cont.do"
	document.forms[0].target='a3'
	top.close();
	actualiza_popup_abierto();
	document.forms[0].submit();

}

</SCRIPT>

<html:form target="_self" action="/DatosPer/Popup/add_cont.do">
	<html:hidden property="case_cod" />
	<html:hidden property="case_usuf_cod" />
	<input type="hidden" name="num_contacto" value="<%=request.getParameter( "num_contacto" )%>" />
	<table border="0" width="100%">
		<tr>
			<td valign=top>
				<table class="tablag" align="center" cellpadding="0" cellspacing="0" border="0" width="630">
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
													<bean:message key="global.button.editar" />
													&nbsp;
													<bean:message key="24" />
												</td>
											</tr>
											<tr>
												<td colspan="3">
													<table border="0" id="tab2" cellspacing="0" cellpadding="0" width="100%">
														<tr>
															<TD colspan="2" class="view_item">
																&nbsp;
																<P ALIGN="JUSTIFY">
																	<bean:message key="7204" />
																</P>
															</TD>
														</tr>
														<tr>
															<TD colspan="2">
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="view_item" nowrap="nowrap">
																&nbsp;
																<bean:message key="4" />
																:&nbsp;
																<html:text property="case_nombre" maxlength="30" size="40" styleClass="sel" />
															</TD>
														</tr>
														<tr>
															<TD class="view_item" nowrap="nowrap">
																&nbsp;
																<bean:message key="5" />
																:&nbsp;
																<html:text property="case_apellido" maxlength="30" size="40" styleClass="sel" />
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																&nbsp;
																<bean:message key="27" />
																:&nbsp;
																<html:select property="case_rfam_cod" styleClass="select">
																	<html:options collection="PARENTESCOS" labelProperty="rfam_des" property="rfam_cod" />
																</html:select>
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="tdNameOption" colspan="2">
																<bean:message key="12" />
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
																<bean:message key="13" />
																:&nbsp;
																<html:select property="case_pais_cod" styleClass="select" onchange="actualizarCiudades(this.value)">
																	<html:options collection="PAISES" labelProperty="pais_des" property="pais_cod" />
																</html:select>
															</TD>
															<TD class="view_item">
																&nbsp;
																<bean:message key="14" />
																:&nbsp;
																<html:select property="case_ciu_cod" styleClass="select" style="select" styleId="ciudadesContent">
																	<html:options collection="CIUDADES" labelProperty="ciu_des" property="ciu_cod" />
																</html:select>
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
																<html:text property="case_indpais1" maxlength="3" size="4" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)"
																	onfocus="this.select()" />
																<bean:message key="14" />
																:
																<html:text property="case_indciudad1" maxlength="3" size="4" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)"
																	onfocus="this.select()" />
																<bean:message key="17" />
																:
																<html:text property="case_telefono1" maxlength="15" size="10" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)"
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
																&nbsp;
																<bean:message key="16" />
																&nbsp;
																<bean:message key="13" />
																:&nbsp;
																<html:text property="case_indpais2" maxlength="3" size="4" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)"
																	onfocus="this.select()" />
																<bean:message key="17" />
																:
																<html:text property="case_telefono2" maxlength="15" size="10" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)"
																	onfocus="this.select()" />
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
																&nbsp;
																<bean:message key="6101" />
																:&nbsp;
															</TD>
															<TD class="view_item">
																<html:select property="case_orden">
																	<html:option value="1" />
																	<html:option value="2" />
																	<html:option value="3" />
																	<html:option value="4" />
																</html:select>
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																&nbsp;
																<bean:message key="19" />
																:&nbsp;
															</TD>
															<TD class="view_item">
																<html:text property="case_mail" maxlength="80" size="50" styleClass="sel" />
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



