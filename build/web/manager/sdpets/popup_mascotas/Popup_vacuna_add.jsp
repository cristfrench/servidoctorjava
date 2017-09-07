<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@page import="java.util.List"%>

<html:html>
<HEAD>
<LINK rel="stylesheet" href="<%=request.getContextPath()%>/style/estilo_pets.css" type="text/css">
<SCRIPT language="JavaScript">
//esta con lo de medicamentos jaja
function enviar() {
	if(document.forms[0].vcui_descripcion.value==''){
		alert('<bean:message key="3084" />');
       	document.forms[0].vcui_descripcion.focus();
       	return false;
	}

	document.forms[0].action="<%=request.getContextPath()%>/DatosMascota/Popup/transferir_vacuna.do";
	document.forms[0].target='a3';
	top.close();
	actualiza_popup_abierto();
	document.forms[0].submit();	
}
</SCRIPT>
<TITLE><bean:message key="2278" /></TITLE>
</HEAD>
<body >
<html:form target="_self" action="/DatosMascota/Popup/add_vacuna.do">
	<TABLE border="0" cellpadding="0" cellspacing="0" align="center" width="98%">
		<TR>
			<TD>
					<br>
					<br>
			<TABLE class="tablag" border="0" id="tab2" cellspacing="0" cellpadding="0" width="100%">
				<TR>
					<TD colspan="3"><IMG src="<%=request.getContextPath()%>/images/int_tit_pets.gif"><HR></TD>
				</TR>
				<TR>
					<TD class="tdOverNameOption" colspan="3"><bean:message key="2282" /></TD>
				</TR>
				<TR>
					<TD colspan="3" class="tdNameOption2"><bean:message key="global.button.adicionar" />&nbsp;<bean:message key="1505" />&nbsp;O&nbsp;<bean:message key="1509" />&nbsp;Nº&nbsp;<%=session.getAttribute("VACUNASCUIDADOS") != null && ((List)session.getAttribute("VACUNASCUIDADOS")).size() > 0 ? ((List)session.getAttribute("VACUNASCUIDADOS")).size() + 1 : 1%></TD>					
				</TR>
				<TR>
					<TD colspan="3">&nbsp;</TD>
				</TR>
				<TR>
					<TD colspan="3" class="view_item"><bean:message key="7307" /></TD>
				</TR>
				<TR>
					<TD colspan="3">&nbsp;</TD>
				</TR>
				<TR>
					<TD class="view_item">&nbsp;<bean:message key="1028" />&nbsp;&nbsp;</TD>
					<TD class="view_item" colspan="2"><html:text property="vcui_descripcion" maxlength="80" size="50" styleClass="sel"/></TD>
				</TR>
				<TR>
					<TD colspan="3"> &nbsp;</TD>
				</TR>
				<TR>
					<TD colspan="3" align="center"><INPUT type="button" onclick="enviar()" class="sbttn" value="<bean:message key="global.button.aceptar"/>"></TD>
				</TR>
			</TABLE>
			</TD>
		</TR>
	</TABLE>
</html:form>
</html:html>
