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
	document.forms[0].action="<%=request.getContextPath()%>/DatosMascota/Popup/add_enfermedad_pets.do"
	document.forms[0].submit();	
}

//function validar() {
//	if(document.forms[0].enfp_sis_cod.value==<%=IConstantes.CODIGO_SISTEMA_DEFAULT.intValue()%>)
//		document.forms[0].enfp_des.disabled = false;	
//	else
//		document.forms[0].enfp_des.disabled = true;	
//}


function enviar(){

	if( document.forms[0].enfp_des.value=='' ){
         alert('<bean:message key="6124" />');
         document.forms[0].enfp_des.focus();
         return false;
    }/*if(document.forms[0].enfp_novedad.value==''){
         alert('<bean:message key="6126" />');
         document.forms[0].enfp_novedad.focus();
         return false;
    }*/
	document.forms[0].enfp_anio_desde.value=document.forms[0].anio.value;
	document.forms[0].action="<%=request.getContextPath()%>/DatosMascota/Popup/trasf_enf_pets.do"
	
	document.forms[0].target='a3';
	document.forms[0].submit();
	actualiza_popup_abierto();	
	top.close();
	
	//CampoA('anio', 'enfp_anio_desde');
	

}

</SCRIPT>

<html:form target="_self" action="/DatosMascota/Popup/add_enfermedad_pets.do">

	<html:hidden property="enfp_cod" />
	<html:hidden property="enfp_mas_cod" />
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
													<img src="<%=request.getContextPath()%>/images/int_tit_pets.gif">
													<hr>
												</td>
											</tr>
											<tr>
												<td class="tdOverNameOption" colspan="3">
													<P ALIGN="JUSTIFY">
														<bean:message key="global.button.adicionar" />
													&nbsp;
													<bean:message key="48" />
													</P>
												</td>
											</tr>
											<tr>
												<td colspan="3">

													<table border="0" id="tab2" cellspacing="0" cellpadding="0" width="100%">
														<tr>
															<TD colspan="2" class="view_item">
																
																<bean:message key="7212a"  />
															</TD>
														</tr>
														<tr>
															<TD colspan="2">
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="704" />
															</TD>
															<td>
																<html:text property="enfp_des" maxlength="80" size="50" styleClass="sel" />
															</td>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="54" />
															</TD>
															<td class='view_item'>
																<html:hidden property="enfp_anio_desde" />
																<SCRIPT language="JavaScript">
							    					CamposFechaB('anio', 'enfp_anio_desde');							    				
							    				</SCRIPT>
															</td>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="170" />
															</TD>
															<td>
																<html:text property="enfp_novedad" maxlength="80" size="40" styleClass="sel" />
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
	//validar();
</script>
