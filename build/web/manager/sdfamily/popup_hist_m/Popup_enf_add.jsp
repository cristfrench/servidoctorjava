<%@page import="com.servidoctor.constantes.IConstantes"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="org.apache.struts.util.MessageResources"%>
<%!MessageResources res = MessageResources.getMessageResources( "com.servidoctor.resources.ApplicationResources" );%>
<SCRIPT LANGUAGE="JavaScript">
	var fecha = new Date();
	var ano = fecha.getYear();
	
function actualizar() {	
	document.forms[0].action="<%=request.getContextPath()%>/Histo_Medica/Popup/add_enfermedad.do";
	document.forms[0].submit();	
}

function validar() {
	if(document.forms[0].enfu_sis_cod.value==<%=IConstantes.CODIGO_SISTEMA_DEFAULT.intValue()%>)
		document.forms[0].enfu_des.disabled = false;	
	else
		document.forms[0].enfu_des.disabled = true;	
}


function enviar(){
	

	if(document.forms[0].enfu_sis_cod.value==1 && document.forms[0].enfu_des.value=='' ){
         alert('<bean:message key="6124" />');
         document.forms[0].enfu_des.focus();
         return false;
    }

    /*if(document.forms[0].enfu_novedad.value==''){
         alert('<bean:message key="6126" />');
         document.forms[0].enfu_novedad.focus();
         return false;
    }*/

    CampoA('anio', 'enfu_anio_desde');

	document.forms[0].action="<%=request.getContextPath()%>/Histo_Medica/Popup/transferir_enfermedad.do";
	document.forms[0].target='a3';

	top.close();

	actualiza_popup_abierto();	
	
	document.forms[0].submit();

}

</SCRIPT>

<html:form target="_self" action="/Histo_Medica/Popup/add_enfermedad.do">
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
													<P ALIGN="JUSTIFY">
														<bean:message key="2070" />
													</P>
												</td>
											</tr>
											<tr>
												<td class="tdNameOption" colspan="3">
													<bean:message key="global.button.adicionar" />
													&nbsp;
													<bean:message key="48" />
												</td>
											</tr>

											<tr>
												<td colspan="3">

													<table border="0" id="tab2" cellspacing="0" cellpadding="0" width="100%">
														<tr>
															<TD colspan="2" class="view_item">
																&nbsp;
																<bean:message key="7212" arg0="<%=res.getMessage( "parametro_adicion_enfermedad" )%>" />
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
														<TR>
															<TD class="view_item">
																<bean:message key="165" />
																:
															</TD>
															<TD class="tdContentText">
																<html:select property="enfu_sis_cod" styleClass="select" onchange="actualizar()">
																	<html:option value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>">
																		<bean:message key="global.todas" />
																	</html:option>
																	<html:options collection="LISTSISTEMAS" labelProperty="sis_desc" property="sis_cod" />
																</html:select>
															</TD>
														</TR>
														<TR>
															<TD class="view_item">
																<bean:message key="704" />
																:
															</TD>
															<TD class="tdContentText">
																<html:select property="enfu_enf_cod" styleClass="select">
																	<html:options collection="LISTENFERMEDADES" labelProperty="enf_des" property="enf_cod" />
																</html:select>
															</TD>
														</TR>
														<tr>
															<TD colspan="2">
																&nbsp;
															</TD>

														</tr>

														<tr>
															<TD class="view_item">
																<bean:message key="52" />
															</TD>
															<td>
																<html:text property="enfu_des" maxlength="80" size="50" styleClass="sel" />
															</td>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="54" />
															</TD>
															<td class='view_item'>
																<html:hidden property="enfu_anio_desde" styleId="enfu_anio_desde" />
																<script language="JavaScript">
							    					CamposFechaA('anio', 'enfu_anio_desde');							    				
							    				</script>
															</td>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="170" />
															</TD>
															<td>
																<html:text property="enfu_novedad" maxlength="80" size="40" styleClass="sel" />
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
	validar();
</script>
