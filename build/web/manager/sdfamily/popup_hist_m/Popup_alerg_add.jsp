<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="com.servidoctor.constantes.IConstantes"%>
<%@ page import="org.apache.struts.util.MessageResources"%>

<%!MessageResources res = MessageResources.getMessageResources( "com.servidoctor.resources.ApplicationResources" );%>
<SCRIPT>
function enviar(){

	if(document.forms[0].aleu_des.value=='' && document.forms[0].aleu_ale_cod.value == <%=IConstantes.CODIGO_NO_EXISTE.toString()%>){
         document.forms[0].aleu_des.focus();
         return false;
    }/*if(document.forms[0].aleu_novedad.value==''){
         document.forms[0].aleu_novedad.focus();
         return false;
    }*/
	
	document.forms[0].action="<%=request.getContextPath()%>/Histo_Medica/Popup/transferir_alergia.do"
	document.forms[0].target='a3'
	top.close();
	actualiza_popup_abierto();	
	CampoA('anio', 'aleu_anio_desde');
	document.forms[0].submit();

}

</SCRIPT>

<html:form target="_self" action="/Histo_Medica/Popup/edit_alergia.do">
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
													<bean:message key="global.button.adicionar" />
													&nbsp;
													<bean:message key="705" />
												</td>
											</tr>
											<tr>
												<td colspan="3">
													<table border="0" id="tab2" cellspacing="0" cellpadding="0" width="100%">
														<tr>
															<TD colspan="2" class="view_item">
																&nbsp;
																<P ALIGN="JUSTIFY">
																	<bean:message key="7214" arg0="<%=res.getMessage( "parametro_adicion_alergia" )%>" />
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
																<bean:message key="56" />
																:&nbsp;
															</TD>
															<td>
																<html:select property="aleu_ale_cod" onchange="disableDinamique(document.forms[0].aleu_des,document.forms[0].aleu_ale_cod)">
																	<html:option value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>">
																		<bean:message key="579" />
																	</html:option>
																	<html:options collection="ALERGIAS" property="ale_cod" labelProperty="ale_des" />
																</html:select>
															</td>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="579" />
																:&nbsp;
															</TD>
															<td>
																<html:text property="aleu_des" maxlength="40" size="40" styleClass="sel" />
															</td>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="54" />
															</TD>
															<td class='view_item'>
																<html:hidden property="aleu_anio_desde" styleId="aleu_anio_desde"/>
																<SCRIPT language="JavaScript">
							    					CamposFechaA('anio', 'aleu_anio_desde');							    				
							    				</SCRIPT>
															</td>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="170" />
																:&nbsp;
															</TD>
															<td>
																<html:text property="aleu_novedad" maxlength="80" size="40" styleClass="sel" />
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
	disableDinamique(document.forms[0].aleu_des,document.forms[0].aleu_ale_cod)
</script>


