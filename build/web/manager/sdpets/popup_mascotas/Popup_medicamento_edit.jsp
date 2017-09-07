<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<HTML>
<HEAD>
<LINK rel="stylesheet" href="<%=request.getContextPath()%>/style/estilo_pets.css" type="text/css">
<SCRIPT language="JavaScript">

function enviar() {
	if(document.forms[0].mmed_afeccion.value==''){
		alert('<bean:message key="3078" />');
       	document.forms[0].mmed_afeccion.focus();
       	return false;
	}
	if(document.forms[0].mmed_nombre.value==''){
		alert('<bean:message key="3079" />');
       	document.forms[0].mmed_nombre.focus();
       	return false;
	}

	if(document.forms[0].mmed_dias_uso.value=='' || document.forms[0].mmed_dias_uso.value=='0'){
    	alert('<bean:message key="3081" />');
        document.forms[0].mmed_dias_uso.focus();
        return false;
	}
	if(document.forms[0].mmed_veces_dia.value=='' || document.forms[0].mmed_veces_dia.value=='0'){
    	alert('<bean:message key="3082" />');
        document.forms[0].mmed_veces_dia.focus();
        return false;
	}	
	if(document.forms[0].mmed_dosis.value==''){
    	alert('<bean:message key="3083" />');
        document.forms[0].mmed_dosis.focus();
        return false;
	}
	
	convertirACampo('cDia', 'cMes', 'cAno', 'mmed_fec_inicio');
	document.forms[0].action = "<%=request.getContextPath()%>/DatosMascota/Popup/transferir_medicamento.do";
	document.forms[0].target = "a3";
	top.close();
	actualiza_popup_abierto();
	document.forms[0].submit();
}
</SCRIPT>
<TITLE><bean:message key="2279" /></TITLE>
</HEAD>
<BODY >
<html:form target="_self" action="/DatosMascota/Popup/add_medicamento.do">
	<TABLE border="0" width="98%" align="center">
	<html:hidden property="mmed_mas_cod"/>
	<html:hidden property="mmed_cod"/>
	<input type="hidden" name="num_medicamento" value="<%=request.getParameter("num_medicamento")%>"/>
		<TR>
			<TD valign=top>
			<TABLE class="tablag" align="center" cellpadding="0" cellspacing="0" border="0" width="100%">
				<TR>
					<TD>
					<TABLE align="center" cellpadding="0" cellspacing="0" border="0" width="100%">
						<TR>
							<TD>
							<TABLE cellpadding="0" cellspacing="0" border="0" width="100%">
								<TR>
									<TD colspan="3"><IMG src="<%=request.getContextPath()%>/images/int_tit_pets.gif"><HR></TD>
								</TR>
								<TR>
									<TD class="tdOverNameOption" colspan="3"><bean:message key="1504" /></TD>
								</TR>
								<TR>
									<TD class="tdOverNameOption" colspan="3"><bean:message key="global.button.editar" />&nbsp;<bean:message key="1513" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="tdNameOption2"><bean:message key="58"/>&nbsp;<%=Integer.parseInt(request.getParameter("num_medicamento"))+1%></TD>
								</TR>
								<TR>
									<TD colspan="2">&nbsp;</TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7314"/>&nbsp;</TD>
								</TR>
								
								<TR>
									<TD colspan="3">
									<TABLE border="0" id="tab2" cellspacing="0" cellpadding="0" width="100%">
										<TR>
											<TD colspan="2">&nbsp;</TD>
										</TR>
										<TR>
											<TD class="view_item"><bean:message key="1514" />:</TD>
											<TD><html:text property="mmed_afeccion" maxlength="40" size="40" styleClass="sel" /></TD>
										</TR>
										<TR>
											<TD class="view_item"><bean:message key="1515" />:</TD>
											<TD><html:text property="mmed_nombre" maxlength="40" size="40" styleClass="Sel" /></TD>
										</TR>
										
										<TR>
											<TD class="view_item"><bean:message key="1517" />:</TD>
											<TD>											
												<html:hidden property="mmed_fec_inicio" styleId="mmed_fec_inicio"/>
												<SCRIPT language="JavaScript">obtenerCamposFecha('cDia', 'cMes', 'cAno', 'mmed_fec_inicio');</SCRIPT>
											</TD>
										</TR>
										<TR>
											<TD>&nbsp;</TD>
										</TR>
										<TR>
											<TD colspan="2" class="view_item"><B><bean:message key="1518" />:&nbsp;</B></TD>
										</TR>
										<TR>
											<TD>&nbsp;</TD>
										</TR>
										<TR>
											<TD class="view_item"><bean:message key="1519" />:&nbsp;</TD>
											<TD><html:text property="mmed_dias_uso" maxlength="3" size="3" styleClass="selNum" onkeyup="isNatural(this);" onblur="isNatural(this);" onfocus="this.select()" /></TD>
										</TR>
										<TR>
											<TD class="view_item"><bean:message key="1520" />:&nbsp;</TD>
											<TD><html:text property="mmed_veces_dia" maxlength="3" size="3" styleClass="selNum" onkeyup="isNatural(this);" onblur="isNatural(this);" onfocus="this.select()"/></TD>
										</TR>
										<TR>
											<TD class="view_item"><bean:message key="1521" />:</TD>
											<TD><html:text property="mmed_dosis" maxlength="40" size="40" styleClass="sel" /></TD>
										</TR>
										<TR>
											<TD>&nbsp;</TD>
										</TR>
									</TABLE>
									</TD>
								</TR>
								<TR>
									<TD colspan="3">
									<TABLE height="30" cellpadding="0" cellspacing="0" border="0" width="100%">
										<TR>
											<TD align="center">
											<HR>
											</TD>
										</TR>
										<TR align="center" valign="middle">
											<TD><INPUT type="button" onclick="enviar()" class="sbttn" value="<bean:message key="global.button.aceptar"/>"></TD>
										</TR>
									</TABLE>
									</TD>
								</TR>
							</TABLE>
							</TD>
						</TR>
					</TABLE>
					</TD>
				</TR>
			</TABLE>
			</TD>
		</TR>
	</TABLE>
</html:form>
</BODY>
</HTML>
