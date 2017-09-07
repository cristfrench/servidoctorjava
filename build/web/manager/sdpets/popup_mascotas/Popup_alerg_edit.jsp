<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="com.servidoctor.constantes.IConstantes"%>

<SCRIPT>
function enviar(){

	if(document.forms[0].alep_des.value==''  ){
         alert('<bean:message key="6127" />');
         document.forms[0].alep_des.focus();
         return false;
    }/*if(document.forms[0].alep_novedad.value==''){
         alert('<bean:message key="6126" />');
         document.forms[0].alep_novedad.focus();
         return false;
    }*/
	document.forms[0].alep_anio_desde.value=document.forms[0].anio.value;
	document.forms[0].action="<%=request.getContextPath()%>/DatosMascota/Popup/trasf_ale_pets.do"
	document.forms[0].target='a3'
	top.close();
	actualiza_popup_abierto();	
	//CampoA('anio', 'alep_anio_desde');
	document.forms[0].submit();

}

</SCRIPT>

<html:form target="_self" action="/DatosMascota/Popup/edit_ale_pets.do">
	<html:hidden property="alep_cod" />
	<html:hidden property="alep_mas_cod" />
	<input type="hidden" name="num_aler_pets" value="<%=request.getParameter( "num_aler_pets" )%>" />
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
													<bean:message key="138" />
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
																<P ALIGN="JUSTIFY" >
																	<bean:message key="7213" />
																</P>
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
																<html:text property="alep_des" maxlength="40" size="40" styleClass="sel" />
															</td>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="54" />
																:&nbsp;
															</TD>
															<td class='view_item'>
																<html:hidden property="alep_anio_desde" />
																<SCRIPT language="JavaScript">
							    					CamposFechaB('anio', 'alep_anio_desde');							    				
							    				</SCRIPT>
															</td>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="170" />
																:&nbsp;
															</TD>
															<td>
																<html:text property="alep_novedad" maxlength="80" size="40" styleClass="sel" />
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
	//disableDinamique(document.forms[0].alep_des,document.forms[0].alep_ale_cod)
</script>