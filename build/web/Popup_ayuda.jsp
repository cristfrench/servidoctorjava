
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html:html>
<HEAD>
<%@ page 
language="java"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
%>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=ISO-8859-1">
<META NAME="GENERATOR" CONTENT="IBM WebSphere Studio">
<META HTTP-EQUIV="Content-Style-Type" CONTENT="text/css">
<LINK REL="stylesheet" HREF="/ServiDoctor/style/estilo_car.css"
	TYPE="text/css">
    <link rel="stylesheet" href="/ServiDoctor/style/examples.css" type="text/css" >
    <link rel="stylesheet" href="/ServiDoctor/style/screen.css" type="text/css" >

<SCRIPT>

function enviar(){
  top.close();
}

</SCRIPT>

<TITLE><bean:message key="a_titulo"/></TITLE>
</HEAD>


	<table border="0" cellpadding="0" cellspacing="0" align="center"
		width="100%">


		<tr>
			<TD><br>
			<br>
			<br>
			<table border="0" id="tab2" cellspacing="0" cellpadding="0"
				width="100%">
				<tr>
					<td colspan="2"><img src="/ServiDoctor/images/int_tit_car.gif">
				</tr>
				<tr>
					<TD colspan="2" class="tdtitle">
					<hr />
					</td>
				</tr>
				<tr>
					<TD colspan="2" class="tdOverNameOption"><bean:message key="a_titulo"/></TD>
				</tr>
				<tr>
					<TD colspan="2" style="background-color: #F1F5FA">&nbsp;</TD>

				</tr>
				<tr>
					<TD class="view_item"></TD>
					<TD  align="justify"><bean:message key='<%=request.getParameter("ayuda")%>'/></TD>
				</tr>
				<tr>
					<TD colspan="2">
					&nbsp;
					</TD>

				</tr>
				<tr>
					<TD colspan="2">
					<HR>
					</TD>

				</tr>
				<tr>
					<TD colspan="2" align="center"><INPUT type="button"
						onclick="enviar()" class="sbttn" value="Aceptar"></TD>

				</tr>
			</table>

			</TD>
		</tr>
	</table>
</html:html>

