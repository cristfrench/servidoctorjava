<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="com.servidoctor.constantes.IConstantes"%>
<SCRIPT>
function enviar(){
	
	if(document.forms[0].ciru_des.value=='' && document.forms[0].ciru_cir_cod.value == '<%=IConstantes.CODIGO_NO_EXISTE.toString()%>'){
         alert('<bean:message key="6128" />');
         document.forms[0].ciru_des.focus();
         return false;
    }
	
	document.forms[0].action="<%=request.getContextPath()%>/Histo_Medica/Popup/transferir_cirujia.do"
	document.forms[0].target='a3'
	top.close();
	actualiza_popup_abierto();	
	CampoA('anio', 'ciru_anio');
	document.forms[0].submit();
}

</SCRIPT>

<html:form target="_self" action="/Histo_Medica/Popup/edit_cirujia.do">
	<html:hidden property="ciru_cod" />
	<html:hidden property="ciru_usuf_cod" />
	<input type="hidden" name="num_cir" value="<%=request.getParameter( "num_cir" )%>" />
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
													<bean:message key="2070" />
												</td>
											</tr>
											<tr>
												<td class="tdNameOption" colspan="3">
													<bean:message key="138" />
													&nbsp;
													<bean:message key="706" />
												</td>
											</tr>
											<tr>
												<td colspan="3">

													<table border="0" id="tab2" cellspacing="0" cellpadding="0" width="100%">
														<tr>
															<TD colspan="2" class="view_item">
																&nbsp;
																<P ALIGN="JUSTIFY" >
																	<bean:message key="7215" />
																</P>
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
																<bean:message key="61" />
																:&nbsp;
															</TD>
															<td>
																<html:select property="ciru_cir_cod" onchange="disableDinamique(document.forms[0].ciru_des,document.forms[0].ciru_cir_cod)">
																	<html:option value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>">
																		<bean:message key="579" />
																	</html:option>
																	<html:options collection="CIRUJIAS" property="cir_cod" labelProperty="cir_des" />
																</html:select>
															</td>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="579" />
																:&nbsp;
															</TD>
															<td>
																<html:text property="ciru_des" maxlength="80" size="40" styleClass="sel" />
															</td>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="62" />
															</TD>
															<td class='view_item'>
																<html:hidden property="ciru_anio" styleId="ciru_anio"/>
																<SCRIPT language="JavaScript">
							    					CamposFechaA('anio', 'ciru_anio');							    				
							    				</SCRIPT>
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
<script>
	disableDinamique(document.forms[0].ciru_des,document.forms[0].ciru_cir_cod)
</script>