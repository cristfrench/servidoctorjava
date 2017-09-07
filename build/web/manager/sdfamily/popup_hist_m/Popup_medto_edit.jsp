<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ page import="org.apache.struts.util.MessageResources"%>
<html>
<head>
<%!MessageResources res=MessageResources.getMessageResources("com.servidoctor.resources.ApplicationResources"); %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/style/estilo_family.css" type="text/css">
<SCRIPT>
function enviar(){

	if(document.forms[0].mtom_des.value==''){
         alert('<bean:message key="6146" />');
         document.forms[0].mtom_des.focus();
         return false;
    }if(document.forms[0].mtom_dosis.value=='' || document.forms[0].mtom_dosis.value=='0'){
         alert('<bean:message key="6147" />');
         document.forms[0].mtom_dosis.focus();
         return false;
    }if(document.forms[0].mtom_cantidad.value=='' || document.forms[0].mtom_cantidad.value=='0'){
         alert('<bean:message key="6148" />');
         document.forms[0].mtom_cantidad.focus();
         return false;
    }
	
	convertirACampo('cDia1', 'cMes1', 'cAno1', 'mtom_fecdesde'); 
	document.forms[0].action="<%=request.getContextPath()%>/Histo_Medica/Popup/transferir_medicamento.do"
	document.forms[0].target='a3'
	top.close();
	actualiza_popup_abierto();
	document.forms[0].submit();

}

</SCRIPT>

</head>

<body >
<html:form target="_self" action="/Histo_Medica/Popup/edit_medicamento.do">
	<table border="0" width="100%">
		<html:hidden property="mtom_cod"/>
		<html:hidden property="mtom_usuf_cod"/>
		<input type="hidden" name="num_medto" value="<%=request.getParameter("num_medto")%>" />
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
									<td colspan="3"><img src="<%=request.getContextPath()%>/images/int_tit_family.gif">
									<hr>
									</td>
								</tr>
								<tr>
									<td class="tdOverNameOption" colspan="3"><bean:message key="2098" /></td>
								</tr>
								<tr>
									<td class="tdNameOption" colspan="3"><bean:message key="138" />&nbsp;<bean:message key="3802" /></td>
								</tr>

								<tr>
									<td colspan="3">

									<table border="0" id="tab2" cellspacing="0" cellpadding="0" width="100%">
										<tr>
											<TD colspan="2">&nbsp;</TD>
										</tr>
										<tr>
											<TD colspan="2" class="view_item">&nbsp;<bean:message key="7218" arg0="<%=res.getMessage("parametro_adicion_medicamento") %>"/></TD>
										</tr>
										<tr>
											<TD colspan="2">&nbsp;</TD>
										</tr>
										<tr>
											<TD colspan="2">&nbsp;</TD>
										</tr>

										<tr>
											<TD class="view_item"><bean:message key="4" />:&nbsp;</TD>
											<td><html:text property="mtom_des" maxlength="80" size="40" styleClass="sel" /></td>
										</tr>
										<tr>
											<TD class="view_item"><bean:message key="141" />:&nbsp;</TD>
											<td><html:select property="mtom_form_cod" styleClass="select">
												<html:options collection="FORMAS" property="form_cod" labelProperty="form_des"></html:options>
											</html:select></td>
										</tr>
										<tr>
											<TD class="view_item"><bean:message key="72" />:&nbsp;</TD>
											<td><html:hidden property="mtom_fecdesde" styleId="mtom_fecdesde" /><script>obtenerCamposFecha('cDia1', 'cMes1', 'cAno1', 'mtom_fecdesde');</script></td>
										</tr>
										<tr>
											<td class="view_item"><bean:message key="69" />:&nbsp;</td>
											<td><html:text property="mtom_dosis" maxlength="6" styleClass="selNum" size="6" onkeyup="isFloat(this, 6, 2)" onblur="isFloat(this, 6, 2)" /></td>
										</tr>
										<tr>
											<TD class="view_item"><bean:message key="142" />:&nbsp;</TD>
											<td><html:select property="mtom_medi_cod" styleClass="select">
												<html:options collection="MEDIDAS" property="medi_cod" labelProperty="medi_des"></html:options>

											</html:select></td>
										</tr>
										<tr>
											<TD class="view_item"><bean:message key="65" />:&nbsp;</TD>
											<td><html:select property="mtom_peri_cod" styleClass="select">
												<html:options collection="PERIODOS" property="peri_cod" labelProperty="peri_des"></html:options>

											</html:select></td>
										</tr>
										<tr>
											<td class="view_item"><bean:message key="143" />:&nbsp;</td>
											<td><html:text property="mtom_cantidad" maxlength="6" size="6" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)" /></td>
										</tr>
										<tr>
											<TD class="view_item"><bean:message key="71" />:&nbsp;</TD>
											<td><html:select property="mtom_vadm_cod" styleClass="select">
												<html:options collection="VIASADMINISTRACION" property="vadm_cod" labelProperty="vadm_des"></html:options>
											</html:select></td>
										</tr>
										<tr>
											<TD>&nbsp;</TD>

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
											<td><INPUT type="button" onclick="enviar()" class="sbttn" value="<bean:message key="global.button.aceptar"/>"></td>
										</tr>
										<tr>
											<TD>&nbsp;</TD>
										</tr>
										<tr>
											<TD colspan="2">&nbsp;<bean:message key="7250"/></TD>
										</tr>
										<tr>
											<td>

											<div align="right" class="imprimir"><img alt="<bean:message key="global.imprimiralt"/>" src="<%=request.getContextPath()%>/images/print.gif" border="0" height="22" width="20">&nbsp;<a
												href="javascript: self.print();"><b><bean:message key="global.imprimir" /></b></a></div>



											</td>
										</tr>
									</table>
									</td>
								</tr></table>
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



