<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<HTML>
<HEAD>
<LINK rel="stylesheet" href="<%=request.getContextPath()%>/style/estilo_pets.css" type="text/css">
<SCRIPT language="JavaScript">
	function enviar() {
		document.forms[0].submit();
	}
</SCRIPT>
</HEAD>
<BODY>
	<TABLE border="0" width="550px" align="center">
		<TR>
			<TD>
			<TABLE class="tablag" align="center" cellpadding="0" cellspacing="0" border="0" width="100%">
				<TR>
					<TD>
						<TABLE class="tablag" border="0" id="tab2" cellspacing="0" cellpadding="0" width="70%" align="center">
							<TR>
								<TD colspan="2"><IMG src="<%=request.getContextPath()%>/images/int_tit_pets.gif"><HR></TD>
							</TR>
							<TR>
								<TD colspan="2" class="tdOverNameOption"><bean:message key="700" /></TD>
							</TR>
							<TR>
								<TD colspan="2" style="background-color: #f1f5fa">&nbsp;</TD>
							</TR>
							<TR>
								<TD class="view_item"><bean:message key="2293"/></TD>
								<TD class="view_item" colspan="2"><B><%=(String)request.getAttribute("CONFIRM")%></B></TD>
							</TR>
							<TR>
								<TD colspan="2" style="background-color: #f1f5fa">&nbsp;</TD>
							</TR>
							<TR>
								<TD colspan="2" align="center"><INPUT type="button" onclick="history.back();" class="sbttn" value="Aceptar"></TD>
							</TR>
						</TABLE>
					</TD>
				</TR>
			</TABLE>
			</TD>
		</TR>
	</TABLE>
</BODY>
</HTML>