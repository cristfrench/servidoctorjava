<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="com.servidoctor.constantes.IConstantes" %>
<html:html>
<HEAD>
<LINK rel="stylesheet" href="<%=request.getContextPath()%>/style/estilo_pets.css" type="text/css">
<SCRIPT language="JavaScript">


function actualizar() {
	convertirACampo('cDia1', 'cMes1', 'cAno1', 'ccui_fecultapli');
	convertirACampo('cDia2', 'cMes2', 'cAno2', 'ccui_fecproxapli');
	document.forms[0].action="<%=request.getContextPath()%>/DatosMascota/Popup/edit_control.do?change=1";
	document.forms[0].submit();
}
	
function enviar() {
	if(document.forms[0].ccui_descripcion.value==''){
		alert('<bean:message key="3071" />');
       	document.forms[0].ccui_descripcion.focus();
       	return false;
	}

	if(!document.forms[0].ccui_email.value==''){
		if(!mail(document.forms[0].ccui_email)){
			alert('<bean:message key="3077" />');
       		document.forms[0].ccui_email.focus();
       		return false;
       	}
	} 

	/*if(document.forms[0].ccui_indpais.value==''){
    	alert('<bean:message key="3074" />');
        document.forms[0].ccui_indpais.focus();
        return false;
	}
	if(document.forms[0].ccui_indciudad.value==''){
    	alert('<bean:message key="3075" />');
        document.forms[0].ccui_indciudad.focus();
        return false;
	}
	if(document.forms[0].ccui_telefono.value==''){
    	alert('<bean:message key="3076" />');
        document.forms[0].ccui_telefono.focus();
        return false;
	}*/		
	
	convertirACampo('cDia1', 'cMes1', 'cAno1', 'ccui_fecultapli');
	convertirACampo('cDia2', 'cMes2', 'cAno2', 'ccui_fecproxapli');
	document.forms[0].action="<%=request.getContextPath()%>/DatosMascota/Popup/transferir_control.do";
	document.forms[0].target='a3';
	top.close();
	actualiza_popup_abierto();
	document.forms[0].submit();
}

function hab() {	
	if(document.all.ccui_cita_prox[1].checked==true) {
		deshabilita();
	} else {
		habilita();
	}	
}

function habilita(){
	document.forms[0].cDia2.disabled = false;
    document.forms[0].cMes2.disabled = false;
	document.forms[0].cAno2.disabled = false;
}

function deshabilita(){
	document.forms[0].cDia2.disabled = true;
    document.forms[0].cMes2.disabled = true;
	document.forms[0].cAno2.disabled = true;
} 
</SCRIPT>
</HEAD>
<body onLoad="hab()" >
<html:form target="_self" action="/DatosMascota/Popup/edit_control.do">
	<TABLE border="0" cellpadding="0" cellspacing="0" align="center" width="510px">
	<html:hidden property="ccui_cod"/>
	<html:hidden property="ccui_mas_cod"/>
	<html:hidden property="ccui_grup_cod"/>
	<html:hidden property="ccui_mails_enviados"/>
	<html:hidden property="ccui_ultimo_mail"/>
	<html:hidden property="ccui_vcui_cod"/>
	<input type="hidden" name="num_control" value="<%=request.getParameter("num_control")%>"/>
		<TR>
			<TD>
			<TABLE border="0" id="tab2" cellspacing="0" cellpadding="0" width="100%">
				<TR>
					<TD colspan="2"><IMG src="<%=request.getContextPath()%>/images/int_tit_pets.gif"></TD>
				</TR>						
				<TR>
					<TD colspan="2"><HR size="1" noshade="noshade" align="center" width="100%"></TD>
				</TR>	
				<TR>
					<TD class="tdOverNameOption" colspan="3"><bean:message key="2281" /></TD>
				</TR>
				<TR>
					<TD class="tdNameOption2" colspan="3"><bean:message key="138" />&nbsp;<bean:message key="3043" /></TD>
				</TR>																			
				<TR>
					<TD class="view_item" colspan="3"><bean:message key="7318" /></TD>
				</TR>
				<TR>
					<TD colspan="3">&nbsp;</TD>
				</TR>
			</TABLE>

			<TABLE border="0" id="tab2" cellspacing="3" cellpadding="2" width="100%">
				<TR>
					<TD colspan="2" class="tdNameOption2"><bean:message key="3036"/>&nbsp;<%=Integer.parseInt(request.getParameter("num_control"))+1%></TD>
				</TR>
				
				<TR>
					<TD class="view_item">&nbsp;<bean:message key="1028" />:</TD>
					<TD class="tdContentText"><html:text property="ccui_descripcion" maxlength="40" size="40" styleClass="sel"/>&nbsp;&nbsp;</TD>
				</TR>
				<TR>
					<TD class="view_item">&nbsp;<bean:message key="1039" />:</TD>
					<TD class="tdContentText">
					<html:hidden property="ccui_fecultapli" styleId="ccui_fecultapli" />
					<SCRIPT language="JavaScript">obtenerCamposFecha('cDia1', 'cMes1', 'cAno1', 'ccui_fecultapli');</SCRIPT>
					</TD>
				</TR>
				<TR>
					<TD class="view_item" colspan="2">&nbsp;
						<bean:message key="3047"/>&nbsp; 
						<bean:message key="3045"/> <html:radio property="ccui_cita_prox" value="<%=IConstantes.CODIGO_SI.toString()%>" onclick="hab()"/> 
						<bean:message key="3046"/> <html:radio property="ccui_cita_prox" value="<%=IConstantes.CODIGO_NO.toString()%>" onclick="hab()"/>
					</TD>
				</TR>	
				<TR>
					<TD class="view_item">&nbsp;<bean:message key="1040" />:</TD>
					<TD class="tdContentText">
						<html:hidden property="ccui_fecproxapli" styleId="ccui_fecproxapli"/>
						<SCRIPT language="JavaScript">obtenerCamposFechaFuturo('cDia2', 'cMes2', 'cAno2', 'ccui_fecproxapli',10);</SCRIPT>
					</TD>
				</TR>							
				<TR>
					<TD class="tdNameOption2" colspan="2"><bean:message key="3037" /></TD>
				</TR>
				<TR>
					<TD class="view_item">&nbsp;<bean:message key="4" />:</TD>
					<TD class="tdContentText"><html:text property="ccui_vetnombre" maxlength="40" size="40" styleClass="sel"/></TD>
				</TR>
				<TR>
					<TD class="view_item"><bean:message key="3033" />:</TD>
					<TD class="tdContentText"><html:text property="ccui_vetdireccion" maxlength="80" size="40" styleClass="sel"/></TD>
				</TR>

				<TR>
					<TD class="view_item">&nbsp;<bean:message key="13" />:</TD>
					<TD class="tdContentText"><html:select property="ccui_pais_cod" styleClass="sel" onchange="actualizar()">
						<html:options collection="PAISES" labelProperty="pais_des" property="pais_cod" />
					</html:select></TD>
				</TR>
				<TR>
					<TD class="view_item">&nbsp;<bean:message key="14" />:</TD>
					<TD class="tdContentText">
						<html:select property="ccui_ciu_cod" styleClass="sel">
							<html:options collection="CIUDADES" labelProperty="ciu_des" property="ciu_cod" />
						</html:select>
					</TD>
				</TR>
				<TR>
					<TD class="view_item">&nbsp;<bean:message key="19" />:</TD>
					<TD class="tdContentText"><html:text property="ccui_email" maxlength="60" size="35"  styleClass="sel"/></TD>
				</TR>
				<TR>
					<TD class="view_item" colspan="2"><bean:message key="31" />: </TD>
				</TR>
				<TR>
					<TD class="view_item" colspan="2"><bean:message key="16" /> <bean:message key="13" />: <html:text property="ccui_indpais" maxlength="3" size="3" styleClass="selNum" onkeyup="isNatural(this);" onblur="isNatural(this);" onfocus="this.select()"/>&nbsp;&nbsp;<bean:message key="14" />: <html:text property="ccui_indciudad" maxlength="3" size="3" styleClass="selNum" onkeyup="isNatural(this);" onblur="isNatural(this);" onfocus="this.select()"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="17" />: <html:text property="ccui_telefono" maxlength="12" size="12" styleClass="selNum" onkeyup="isNatural(this);" onblur="isNatural(this);" onfocus="this.select()" /></TD>
				</TR>
				<TR>
					<TD colspan="2"><HR size="1" noshade="noshade" align="center" width="100%"></TD>
				</TR>																				
				<TR>
					<TD colspan="2" align="center"><INPUT type="button" onClick="enviar()" class="sbttn" value="<bean:message key="global.button.aceptar"/>"></TD>
				</TR>
			</TABLE>
			</TD>
		</TR>
	</TABLE>
</html:form>
</body>
</html:html>
