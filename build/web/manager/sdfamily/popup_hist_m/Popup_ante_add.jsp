<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="com.servidoctor.constantes.IConstantes"%>

<SCRIPT>

function enviar(){
	if(document.all.anteu_des.value == '' && document.forms[0].anteu_ante_cod.value == <%=IConstantes.CODIGO_NO_EXISTE.toString()%>){
		alert("El campo no puede estar vacio!");
		document.all.anteu_des.focus();
		return false;
	}
	document.forms[0].action="<%=request.getContextPath()%>/Histo_Medica/Popup/transferir_antecedente.do"
	document.forms[0].target='a3'
	top.close();
	actualiza_popup_abierto();
	document.forms[0].submit();
}

</SCRIPT>

<html:form target="_self" action="/Histo_Medica/Popup/add_antecedente.do">
	<html:hidden property="anteu_usuf_cod" />
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
													<bean:message key="50" />
												</td>
											</tr>
											<tr>
												<td colspan="3">

													<table border="0" id="tab2" cellspacing="0" cellpadding="0" width="100%">
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD colspan="2" class="view_item">
																&nbsp;
																<bean:message key="7221" />
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
																<bean:message key="809" />
																:&nbsp;
															</TD>
															<td>
																<html:select property="anteu_ante_cod" onchange="disableDinamique(document.forms[0].anteu_des,document.forms[0].anteu_ante_cod)">
																	<html:option value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>">
																		<bean:message key="579" />
																	</html:option>
																	<html:options collection="ANTECEDENTES" property="ante_cod" labelProperty="ante_des" />
																</html:select>
															</td>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="579" />
																:&nbsp;
															</TD>
															<td>
																<html:text property="anteu_des" maxlength="80" size="40" styleClass="sel" />
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
	disableDinamique(document.forms[0].anteu_des,document.forms[0].anteu_ante_cod);
</script>