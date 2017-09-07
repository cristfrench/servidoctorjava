<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="com.servidoctor.constantes.IConstantes"%>
<%@ page import="org.apache.struts.util.MessageResources"%>

<%!MessageResources res = MessageResources.getMessageResources( "com.servidoctor.resources.ApplicationResources" );%>
<SCRIPT>
function enviar()
{
	if(document.forms[0].exau_des.value=='' && document.forms[0].exau_exa_cod.value=='0'){
         alert('<bean:message key="6168" />');
         document.forms[0].exau_des.focus();
         return false;
    }
    
    if(document.forms[0].exau_edad.value==''){
         alert('<bean:message key="6151" />');
         document.forms[0].exau_edad.focus();
         return false;
    }

	if(document.forms[0].exau_frecuencia.value=='' || document.forms[0].exau_frecuencia.value=='0'){
         alert('<bean:message key="6153" />');
         document.forms[0].exau_frecuencia.focus();
         return false;
    }

	document.forms[0].action="<%=request.getContextPath()%>/Control_Medico/Popup/transferir_tabla.do"
	document.forms[0].target='a3'
	top.close();
	actualiza_popup_abierto();
	document.forms[0].submit();

}

</SCRIPT>

<html:form target="_self" action="/Control_Medico/Popup/transferir_tabla.do">
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
													<bean:message key="2153" />
												</td>
											</tr>
											<tr>
												<td class="tdNameOption" colspan="3">
													<bean:message key="global.button.adicionar" />
													&nbsp;
													<bean:message key="112" />
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
																<bean:message key="7238" arg0="<%=res.getMessage( "parametro_adicion_examed" )%>" />
															</TD>
														</tr>
														<tr>
															<TD colspan="2">
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="842" />
																:&nbsp;
															</TD>
															<td>
																<html:select property="exau_exa_cod" onchange="disableDinamique(document.forms[0].exau_des,document.forms[0].exau_exa_cod)">
																	<html:option value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>">
																		<bean:message key="579" />
																	</html:option>
																	<html:options collection="LISTAUNIVERSAL" property="exa_cod" labelProperty="exa_des" />
																</html:select>
															</td>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="579" />
																:&nbsp;
															</TD>
															<td>
																<html:text property="exau_des" maxlength="40" size="40" styleClass="sel" />
															</td>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="168" />
															</TD>
															<td>
																<html:text property="exau_edad" maxlength="3" size="3" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)" />
															</td>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="97" />
															</TD>
															<td>
																<html:text property="exau_frecuencia" maxlength="3" size="3" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)" />
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
																<INPUT type="button" onclick="enviar()" class="sbttn" value=<bean:message key="global.button.aceptar"/>>
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
	disableDinamique(document.forms[0].exau_des,document.forms[0].exau_exa_cod)
</script>