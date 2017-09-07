<jsp:directive.page import="com.servidoctor.seguridad.model.UsuarioPets"/>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ page import="com.servidoctor.sdpets.model.GrupoUsuarioSegmentacion"%>
<%@ page import="com.servidoctor.sdpets.model.LogoComprador"%>
<%@ page import="com.servidoctor.sdpets.dao.GrupoUsuarioSegmentacionDAO"%>
<%@ page import="com.servidoctor.sdpets.dao.LogoCompradorDAO"%>
<%@ page import="com.servidoctor.seguridad.model.UsuarioPets"%>
<%@ page import="com.servidoctor.constantes.IConstantes" %>
<%@ page import="org.apache.struts.util.MessageResources"%>
<%@ page import="java.math.BigDecimal"%>
<HTML>
<HEAD>
<LINK rel="stylesheet" href="<%=request.getContextPath()%>/style/estilo_pets.css" type="text/css">
<%!MessageResources res = MessageResources.getMessageResources( "com.servidoctor.resources.ApplicationResources" );%>
<SCRIPT language="JavaScript">
	function view_popup_pets(x,y,z)
{
	/*if(hay_popup_abierto())	
		return false;
	alert(x+y+z);*/
	eval("window.open('<%=request.getContextPath()%>/CarnePets/Popup/preview.do?linea1="+x+"&linea2="+y+"&linea3="+z+"','tabla','scrollbars=yes, top=100, left=200, width=680, height=440')");
}
	function edit_control(x) {
		if(hay_popup_abierto())	
			return false;  			
		eval("window.open('<%=request.getContextPath()%>/DatosMascota/Popup/edit_control.do?num_control="+x+"','control','scrollbars=yes, top=100, left=200, width=600, height=600')")
	}

function guardarForm(){
	/*convertirACampo('cDia1', 'cMes1', 'cAno1', 'datp_fecnacim');
	convertirACampo('cDia2', 'cMes2', 'cAno2', 'datp_med_fecha1');
	convertirACampo('cDia3', 'cMes3', 'cAno3', 'datp_med_fecha2');
	convertirACampo('cDia4', 'cMes4', 'cAno4', 'datp_med_fecha3');
	enviar('<%=request.getContextPath()%>/DatosMascota/add.do');*/
}

	
function add_seguro(tama){
	if(tama>=<bean:message key="parametro_adicion_seguro"/>){
		alert('<bean:message key="parametro_superado_seguro"/>');
      	return false;
	}else{
		if(hay_popup_abierto()){
			return false;	
		}
		guardarForm();
		eval("window.open('<%=request.getContextPath()%>/DatosMascota/Popup/add_seguro_pets.do?','seguros','scrollbars=yes, top=50, left=200, width=720, height=700')")
		return true;
	}
}
	

	function add_enf(tama)
	{
		if(tama>=<bean:message key="parametro_adicion_enfermedad"/>){
	      alert('<bean:message key="parametro_superado_enfermedad"/>');
	      return false;
	   }else{
	   	if(hay_popup_abierto())	
			return false;
		eval("window.open('<%=request.getContextPath()%>/DatosMascota/Popup/add_enfermedad_pets.do?','enfermedad','scrollbars=yes, top=100, left=200, width=700, height=630')")
		return true;
		}
	}
	function edit_enf_pets(x)
	{
		if(hay_popup_abierto())	
			return false;
		eval("window.open('<%=request.getContextPath()%>/DatosMascota/Popup/edit_enfermedad_pets.do?num_enf_pets="+x+"','enfermedad','scrollbars=yes, top=100, left=200, width=700, height=500')")
	}
	function remove_enf_pets(x, nom)
	{
		var r=confirm('<bean:message key="6240"/>' + " " + nom + "?");
		if(r){
			enviar('<%=request.getContextPath()%>/DatosMascota/Popup/remove_enfermedad_pets.do?num_enf_pets='+x);
		}
	}
	function add_ale_pets(tam)
	{
		if(tam>=<bean:message key="parametro_adicion_alergia"/>){
	      alert('<bean:message key="parametro_superado_alergia"/>');
	      return false;
	   }else{
	   	if(hay_popup_abierto())	
			return false;
		eval("window.open('<%=request.getContextPath()%>/DatosMascota/Popup/add_ale_pets.do?','alergia','scrollbars=yes, top=100, left=200, width=700, height=550')")
		return true;
		}
	}
	function edit_ale_pets(x)
	{
		if(hay_popup_abierto())	
			return false;
		eval("window.open('<%=request.getContextPath()%>/DatosMascota/Popup/edit_ale_pets.do?num_aler_pets="+x+"','alergia','scrollbars=yes, top=100, left=200, width=700, height=400')")
	}
	function remove_ale_pets(x, nom)
	{
	var r=confirm('<bean:message key="6240"/>' + " " + nom + "?");
	if(r){
		enviar('<%=request.getContextPath()%>/DatosMascota/Popup/remove_ale_pets.do?num_aler_pets='+x);
	}
	}

	function add_cir_pets(tama)
	{
		if(tama>=<bean:message key="parametro_adicion_cirujia"/>){
	      alert('<bean:message key="parametro_superado_cirujia"/>');
	      return false;
	   }else{
	   	if(hay_popup_abierto())	
			return false;
		eval("window.open('<%=request.getContextPath()%>/DatosMascota/Popup/add_cir_pets.do?','cirujia','scrollbars=yes, top=100, left=200, width=700, height=540')")
		return true;
		}
	}
	function edit_cir_pets(x)
	{
		if(hay_popup_abierto())	
			return false;
		eval("window.open('<%=request.getContextPath()%>/DatosMascota/Popup/edit_cir_pets.do?num_cir_pets="+x+"','cirugia','scrollbars=yes, top=100, left=200, width=700, height=450')")
	}
	function remove_cir_pets(x, nom)
	{
		var r=confirm('<bean:message key="6240"/>' + " " + nom + "?");
		if(r){
			enviar('<%=request.getContextPath()%>/DatosMascota/Popup/remove_cir_pets.do?num_cir_pets='+x);
		}	
	}	
	
	
	
	
		
	function add_vacuna() {
		if(document.forms[0].tamVacunas.value>=parseInt('<bean:message key="parametro_adicion_vacunas_mascota"/>',10)){
      		alert('<bean:message key="parametro_superado_vacunas_mascota"/>');
      		return false;
		} else {
			if(hay_popup_abierto())	
				return false;
			eval("window.open('<%=request.getContextPath()%>/DatosMascota/Popup/add_vacuna.do?','control','scrollbars=yes, top=100, left=200, width=580, height=350')")
			return true;
		}
 	}

 	function edit_vacuna(x) {  
 		if(hay_popup_abierto())	
			return false;					 	
 		eval("window.open('<%=request.getContextPath()%>/DatosMascota/Popup/edit_vacuna.do?num_vacuna="+x+"','control','scrollbars=yes, top=100, left=200, width=580, height=320')")	
	}
	
	function remove_vacuna(x,nom) {
		var r=confirm('<bean:message key="3088"/>' + " " + nom + "?");	
		if(r) {
			enviar_sin_validar('<%=request.getContextPath()%>/DatosMascota/recarga.do?redirect=/DatosMascota/Popup/remove_vacuna.do?num_vacuna='+x);   			
		}		
	}
	
	function add_medicamento() {
		if(document.forms[0].tamMedicamentos.value>=parseInt('<bean:message key="parametro_adicion_medicamentos_mascota"/>',10)){
      		alert('<bean:message key="parametro_superado_medicamentos_mascota"/>');
      		return false;
		} else {
			if(hay_popup_abierto())	
				return false;
			eval("window.open('<%=request.getContextPath()%>/DatosMascota/Popup/add_medicamento.do','control','scrollbars=yes, top=100, left=200, width=600, height=500')")
			return true;
		}		
	}
	
	function edit_medicamento(x) {
		if(hay_popup_abierto())	
			return false;  			
		eval("window.open('<%=request.getContextPath()%>/DatosMascota/Popup/edit_medicamento.do?num_medicamento="+x+"','control','scrollbars=yes, top=100, left=200, width=600, height=500')")

	}

	function edit_seguro_pets(x) {
		if(hay_popup_abierto())	
			return false;  			
		eval("window.open('<%=request.getContextPath()%>/DatosMascota/Popup/edit_seguro_pets.do?num_seguro_pets="+x+"','control','scrollbars=yes, top=100, left=200, width=600, height=500')")

	}	
	function remove_medicamento(x, nom) {
		var r=confirm('<bean:message key="3089"/>' + " " + nom + "?");	
		if(r) { 			
			enviar("<%=request.getContextPath()%>/DatosMascota/Popup/remove_medicamento.do?num_medicamento="+x);
		}
	}
	function remove_seguro(x, nom) {
		var r=confirm('<bean:message key="3089"/>' + " " + nom + "?");	
		if(r) { 			
			enviar("<%=request.getContextPath()%>/DatosMascota/Popup/remove_seguro_pets.do?num_seguro_pets="+x);
		}
	}
			
function enviarD(ruta) {
	var noTelFijo = false;
	var noTelMovil = false;
	if ((Trim(document.forms[0].pmas_indpais1.value)=='' || document.forms[0].pmas_indpais1.value=='0') || (Trim(document.forms[0].pmas_indciudad1.value)=='' || document.forms[0].pmas_indciudad1.value=='0') || (Trim(document.forms[0].pmas_telefono1.value)=='' || document.forms[0].pmas_telefono1.value=='0')){
    	noTelFijo = true;
    }if ((Trim(document.forms[0].pmas_indpais2.value=='') || document.forms[0].pmas_indpais2.value=='0') || (Trim(document.forms[0].pmas_telefono2.value)=='' || document.forms[0].pmas_telefono2.value=='0')){
    	noTelMovil = true;
    }
    if(document.forms[0].mas_nombre.value==''){
		alert('<bean:message key="3050" />');
        document.forms[0].mas_nombre.focus();
        return false;
	}
    if(document.forms[0].pmas_nombre.value==''){
    	alert('<bean:message key="3051" />');
        document.forms[0].pmas_nombre.focus();
        return false;
	}	
	if(document.forms[0].pmas_apellido.value==''){
    	alert('<bean:message key="3052" />');
        document.forms[0].pmas_apellido.focus();
        return false;
	}	
	if((document.forms[0].pmas_indpais1.value=='' || document.forms[0].pmas_indpais1.value=='0') && noTelMovil){
    	alert('<bean:message key="3053" />');
        document.forms[0].pmas_indpais1.focus();
        return false;
	}
	if((document.forms[0].pmas_indciudad1.value=='' || document.forms[0].pmas_indciudad1.value=='0') && noTelMovil){
    	alert('<bean:message key="3054" />');
        document.forms[0].pmas_indciudad1.focus();
        return false;
	}
	if((document.forms[0].pmas_telefono1.value=='' || document.forms[0].pmas_telefono1.value=='0') && noTelMovil){
    	alert('<bean:message key="3055" />');
        document.forms[0].pmas_telefono1.focus();
        return false;
	}	
	if((document.forms[0].pmas_indpais2.value=='' || document.forms[0].pmas_indpais2.value=='0') && noTelFijo){
    	alert('<bean:message key="3056" />');
        document.forms[0].pmas_indpais2.focus();
        return false;
	}
	if((document.forms[0].pmas_telefono2.value=='' || document.forms[0].pmas_telefono2.value=='0') && noTelFijo){
    	alert('<bean:message key="3057" />');
        document.forms[0].pmas_telefono2.focus();
        return false;
	}       
    if(document.forms[0].mali_pesomascota.value=='' || document.forms[0].mali_pesomascota.value=='0'){
    	alert('<bean:message key="3058" />');
        document.forms[0].mali_pesomascota.focus();
        return false;
	}
	if(document.forms[0].mali_pesominveterinario.value=='' || document.forms[0].mali_pesominveterinario.value=='0'){
    	alert('<bean:message key="3059" />');
        document.forms[0].mali_pesominveterinario.focus();
        return false;
	}
	if(document.forms[0].mali_pesomaxveterinario.value=='' || document.forms[0].mali_pesomaxveterinario.value=='0'){
    	alert('<bean:message key="3060" />');
        document.forms[0].mali_pesomaxveterinario.focus();
        return false;
	}
	if(document.forms[0].mali_fabricante.value=='' && document.forms[0].mali_tipocomida[1].checked){
    	alert('<bean:message key="3061" />');
        document.forms[0].mali_fabricante.focus();
        return false;
	}
	if((document.forms[0].mali_peso.value=='' || document.forms[0].mali_peso.value=='0') && document.forms[0].mali_tipocomida[1].checked) {
	    alert('<bean:message key="3062" />');
    	document.forms[0].mali_peso.focus();
        return false;       	
	}
	if((document.forms[0].mali_grxdosis.value=='' || document.forms[0].mali_grxdosis.value=='0') && document.forms[0].mali_tipocomida[1].checked) {
		alert('<bean:message key="3063" />');
       	document.forms[0].mali_grxdosis.focus();
        return false;
	}
	if((document.forms[0].mali_dosisxdia.value=='' || document.forms[0].mali_dosisxdia.value=='0') && document.forms[0].mali_tipocomida[1].checked) {
    	alert('<bean:message key="3064" />');
	    document.forms[0].mali_dosisxdia.focus();
        return false;
	}document.forms[0].pmas_mail.value = Trim(document.forms[0].pmas_mail.value);
	if(!mail(document.forms[0].pmas_mail)){
         alert('<bean:message key="5019" />');
         document.forms[0].pmas_mail.focus();
         return false;
      }document.forms[0].cmas_mail.value = Trim(document.forms[0].cmas_mail.value);
	if(!mail(document.forms[0].cmas_mail)){
         alert('<bean:message key="3067" />');
         document.forms[0].cmas_mail.focus();
         return false;
      }
	
	convertirACampo('cDia1', 'cMes1', 'cAno1', 'mas_fecnac');
	convertirACampo('cDia2', 'cMes2', 'cAno2', 'mali_fecultpeso');
	convertirACampo('cDia3', 'cMes3', 'cAno3', 'cmas_fecnacim');
	document.forms[0].cmas_mail.disabled = false;
	document.forms[0].mas_tipo.disabled = false;
	document.forms[0].mas_raz_cod.disabled = false;
	document.forms[0].action = ruta;
	document.forms[0].submit();	
}

function validar_mail1() {
	if(!mail(document.forms[0].pmas_mail)){
		alert('<bean:message key="5019" />');
        document.forms[0].pmas_mail.focus();
        return false;
	} 
}

function validar_mali2() {
	if(!mail(document.forms[0].cmas_mail)){
		alert('<bean:message key="3067" />');
        document.forms[0].cmas_mail.focus();
        return false;
	} 
}

function habilita(){
	document.forms[0].mali_fabricante.disabled = false;
    document.forms[0].mali_tipo.disabled = false;
	document.forms[0].mali_peso.disabled = false;
	document.forms[0].mali_grxdosis.disabled = false;
	document.forms[0].mali_dosisxdia.disabled = false;
}

function deshabilita(){
	document.forms[0].mali_fabricante.disabled = true;
	document.forms[0].mali_tipo.disabled = true;
	document.forms[0].mali_peso.disabled = true;
	document.forms[0].mali_grxdosis.disabled = true;
	document.forms[0].mali_dosisxdia.disabled = true;
	
	document.forms[0].mali_fabricante.value = "";
	document.forms[0].mali_tipo.value = "";
	document.forms[0].mali_peso.value = "0.00";
	document.forms[0].mali_grxdosis.value = "0.00";
	document.forms[0].mali_dosisxdia.value = "0";
} 

function hab() {	
	if(document.all.mali_tipocomida[1].checked==true || document.all.mali_tipocomida[2].checked==true) {
		habilita();
	} else {
		deshabilita();
	}	
}

function actualizar(){
	enviar_sin_validar('<%=request.getContextPath()%>/DatosMascota/recarga.do');
}

function enviar_sin_validar(ruta) {
	convertirACampo('cDia1', 'cMes1', 'cAno1', 'mas_fecnac');
	convertirACampo('cDia2', 'cMes2', 'cAno2', 'mali_fecultpeso');
	convertirACampo('cDia3', 'cMes3', 'cAno3', 'cmas_fecnacim');
	document.forms[0].action = ruta;
	document.forms[0].submit();	
}

function calcularInfoPeso(){
	
	if (parseFloat(document.forms[0].mali_pesominveterinario.value, 10) < parseFloat(document.forms[0].mali_pesomaxveterinario.value, 10)){
		if (parseFloat(document.forms[0].mali_pesomascota.value, 10) > parseFloat(document.forms[0].mali_pesomaxveterinario.value, 10)){
			document.all.siSobrepeso.style.display='';
			document.all.noSobrepeso.style.display='none';
			document.forms[0].sobrepeso.value = (parseFloat(document.forms[0].mali_pesomascota.value, 10) - parseFloat(document.forms[0].mali_pesomaxveterinario.value, 10));
		}if (parseFloat(document.forms[0].mali_pesomascota.value, 10) < parseFloat(document.forms[0].mali_pesomaxveterinario.value, 10)){
			document.all.siSobrepeso.style.display='none';
			document.all.noSobrepeso.style.display='';
		}
	}
}


</SCRIPT>

</HEAD>
<BODY onLoad="hab()"><br>
<html:form action="/DatosMascota/edit.do">
	<input type="hidden" name="load" value=""/>
	<html:hidden property="mas_fecinscripcion" />
	<html:hidden property="mas_cod" />
	<html:hidden property="mas_licencia" />
	<html:hidden property="mas_licencia" />
	<html:hidden property="pmas_cod" />
	<html:hidden property="pmas_mas_cod" />
	<html:hidden property="mali_cod" />
	<html:hidden property="mali_mas_cod" />
	<html:hidden property="cmas_cod" />
	<html:hidden property="cmas_mas_cod" />
	<html:hidden property="cmas_fecnacim" styleId="cmas_fecnacim" />
	<TABLE border="0" width="95%" align="center" >
		<TR>
			<TD valign="top">
			<TABLE class="tablag" align="center" cellpadding="0" cellspacing="0" border="0" width="100%">
				<TR>
					<TD>
					<TABLE align="center" cellpadding="0" cellspacing="0" border="0" width="100%">
						<TR>
<TD  colspan="4">
						<TABLE cellpadding="0" cellspacing="0" border="0" width="100%">
							<TR>
								<TD  align="left" valign="bottom">
								   	<img src="<%=request.getContextPath()%>/images/int_tit_pets.gif">                           
								</TD>

	                          <TD>&nbsp;<%
		                           UsuarioPets usuarioPets = (UsuarioPets) request.getSession().getAttribute("usuarioPets");
		                             
		                             GrupoUsuarioSegmentacion grupoUsuarioSegmentacion = new GrupoUsuarioSegmentacion();
		                             GrupoUsuarioSegmentacionDAO grupoUsuarioSegmentacionDAO = new GrupoUsuarioSegmentacionDAO();
		                              GrupoUsuarioSegmentacion grupoUsuarioPets= new GrupoUsuarioSegmentacion();
		                             grupoUsuarioPets.setGrupo_id(BigDecimal.ZERO);
		                             if (usuarioPets.getUsup_especial().intValue()==1){
		                             	grupoUsuarioPets = grupoUsuarioSegmentacionDAO.retrive("P"+usuarioPets.getUsup_cod().toString());  
		                             }else{
		                             	grupoUsuarioPets = grupoUsuarioSegmentacionDAO.retrieve("P"+usuarioPets.getUsup_licencia());  
		                             }  
			                         
			                         
			                         LogoCompradorDAO logoCompradorDAO = new LogoCompradorDAO();
			                         
									 java.util.Calendar fecha = java.util.Calendar.getInstance();
									 
									 String diafechaactual = new String();			 
									 if (fecha.get(java.util.Calendar.DATE)<10)
									 	diafechaactual = "0" + Integer.toString(fecha.get(java.util.Calendar.DATE));
									 else
								 	 	diafechaactual = Integer.toString(fecha.get(java.util.Calendar.DATE));
									 
									 String mesfechaactual = new String();			 
									 if (fecha.get(java.util.Calendar.MONTH)<9){
									 	Integer mesActual = new Integer(fecha.get(java.util.Calendar.MONTH));				 	
									 	int mesActual1=mesActual.intValue() + 1;
									 	Integer mesA= new Integer(mesActual1);
									 	mesfechaactual = "0" + mesA.toString(mesActual1);
									 	
									 }else{
									 	Integer mesActual = new Integer(fecha.get(java.util.Calendar.MONTH));				 	
									 	int mesActual1=mesActual.intValue() + 1;
									 	Integer mesA= new Integer(mesActual1);	
									 	mesfechaactual =  mesA.toString(mesActual1);							 		
								 	 }
									
									String aniofechaactual = new String();	
									aniofechaactual = Integer.toString(fecha.get(java.util.Calendar.YEAR));		
									 		
									String fechaActual= aniofechaactual + mesfechaactual + diafechaactual;
									Integer ifechaActual = Integer.parseInt(fechaActual); 
									
									LogoComprador datosPublicidadCompletos = logoCompradorDAO.retrieve(grupoUsuarioPets.getGrupo_id(),ifechaActual);
									//int ifechaInicio = Integer.parseInt(datosPublicidadCompletos.getLogc_fecini());
									//int ifechaFinal = Integer.parseInt(datosPublicidadCompletos.getLogc_fecfin());
		                          	%>
		                      		      				                      		
		                          	
	                          <table align="right" width="380px" height="80px" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                  <td  width="20px" height="100%">
                                  	<%if (datosPublicidadCompletos.getLogc_html_code()!= null){ %>
                                  		<a href="<%=datosPublicidadCompletos.getClickizquierdo()%>" target="_blank"><img src="<%=request.getContextPath()%>/images/clickright.jpg" border="0"></a>
                    				<%} %>
                                  </td>
                                  <td><%if (datosPublicidadCompletos.getLogc_html_code()!= null){ %>
                                  <%=datosPublicidadCompletos.getLogc_html_code()%> 
                                  <%}else{ %>
                                  	&nbsp;
                                  <%} %>
                                  </td>
                                  <td width="20px" height="100%">
                                    <%if (datosPublicidadCompletos.getLogc_html_code()!= null){ 
                                     	if (datosPublicidadCompletos.getClickderecho().equals("0") || datosPublicidadCompletos.getClickderecho().equals("") ){ %>
                              	    		<a href="<%=datosPublicidadCompletos.getClickizquierdo()%>" target="_blank">
                             	    	<%}else{%>
											<a href="<%=datosPublicidadCompletos.getClickderecho()%>" target="_blank">
                              	    	<%}%>
                                  <img src="<%=request.getContextPath()%>/images/clickleft.jpg" border="0" ></a>
									<%}%>
                                  </td>
                                </tr>
                              </table>
							</TD>	
							</TR>
							<tr style="line-height:5px">
							  <td colspan="4">&nbsp;</td>
							</tr>
							<tr>
							  <td colspan="4"><hr></td>
							</tr>
								<TR>
									<TD colspan="4">
									<HR size="1" noshade="noshade" align="center" width="100%">
									</TD>
								</TR>
								<TR>
									<TD class="tdOverNameOption" align="center" colspan="4" ><bean:message key="1504" />&nbsp;--&nbsp;<bean:write name="mascotaCompletoForm" property="mas_nombre"/></TD>
								</TR>
								<TR>
									<TD class="tdNameOption" colspan="4">
									<TABLE border="0" cellpadding="0" cellspacing="1" width="100%">
										<TR align="center" valign="middle">
											<TD id="tab11" class="sbttn tdNameOption" onClick="tab('1','editmascota','pets')" width="25%"><bean:message key="1" /></TD>
											<TD id="tab14" class="sbttn tdNameOption" onClick="tab('4','editmascota','pets')" width="25%"><bean:message key="3044a" /></TD>
											<TD id="tab18" class="sbttn tdNameOption" onClick="tab('8','editmascota','pets')" width="20%"><bean:message key="3819" /></TD>											
											<TD id="tab13" class="sbttn tdNameOption" onClick="tab('3','editmascota','pets')" width="25%" width="25%"><bean:message key="1001" /></TD>
										</TR>
										<TR align="center" valign="middle">
										<td colspan="4">
											<TABLE border="0" cellpadding="0" cellspacing="1" width="100%">
											<tr align="center" valign="middle">
											
											<TD id="tab16" class="sbttn tdNameOption" onClick="tab('6','editmascota','pets')" width="20%"><bean:message key="3085" /></TD>
												
											
											<TD id="tab19" class="sbttn tdNameOption" onClick="tab('9','editmascota','pets')" width="20%"><bean:message key="3822" /></TD>
											<TD id="tab15" class="sbttn tdNameOption" onClick="tab('5','editmascota','pets')" width="20%"><bean:message key="3821" /></TD>
											<TD id="tab12" class="sbttn tdNameOption" onClick="tab('2','editmascota','pets')" width="25%"><bean:message key="1000" /></TD>
											<TD id="tab17" class="sbttn tdNameOption" onClick="tab('7','editmascota','pets')" width="20%"><bean:message key="3820" /></TD>
											
											</tr>											
											</table>
											</td>
										</tr>
									</TABLE>
									</TD>
								</TR>
								<!-- Primer id -->
								<TR>
									<TD colspan="4">
									<TABLE border="0" id="tab1" width="100%" cellspacing="0" cellpadding="0">
										<TR>
											<TD colspan="2">&nbsp;</TD>
										</TR>
										<TR>
											<TD colspan="2" class="view_item" align="left"><bean:message key="7302" /></TD>
										</TR>
										<TR>
											<TD colspan="2">&nbsp;</TD>
										</TR>
										<TR>
											<TD colspan="2" align="center" class="view_item"  style="border: 1px solid #009F00"><b><bean:message key="1011" /></b></TD>
											</TR>
											<tr>
												<td> &nbsp; </td>
											</tr>
										<TR>
											<TD class="view_item"><bean:message key="1003" />:&nbsp;<html:text property="mas_nombre" maxlength="30" size="30" styleClass="sel" /></TD>
											<TD class="view_item" align="center"><bean:message key="22" />:&nbsp; <html:hidden property="mas_fecnac" styleId="mas_fecnac" /> <SCRIPT language="JavaScript">obtenerCamposFecha('cDia1', 'cMes1', 'cAno1', 'mas_fecnac');</SCRIPT></TD>
										</TR>
										<TR>
											<TD class="view_item" colspan="2"><bean:message key="1004" />:&nbsp; <html:select property="mas_tipo" styleClass="select" onchange="actualizar()" disabled="true">
												<html:option value="0">
													<bean:message key="1005" />
												</html:option>
												<html:option value="1">
													<bean:message key="1006" />
												</html:option>
											</html:select> &nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="1009" />:&nbsp; <html:select property="mas_raz_cod" styleClass="select" disabled="true">
												<html:options collection="RAZAS" labelProperty="raz_des" property="raz_cod" />
											</html:select> &nbsp;&nbsp;&nbsp;&nbsp; <bean:message key="47" />:&nbsp;&nbsp;&nbsp;<bean:message key="1007" /> <html:radio property="mas_sexo" value="<%=IConstantes.SEXO_MASCULINO%>" /> <bean:message key="1008" /> <html:radio property="mas_sexo" value="<%=IConstantes.SEXO_FEMENINO%>" /></TD>
										</TR>
										<TR>
											<TD colspan="2">&nbsp;</TD>
										</TR>
										<TR>
											<TD colspan="2">&nbsp;</TD>
										</TR>

										<TR>
											<TD class="view_item"><bean:message key="m3006" />&nbsp;<html:text property="mas_color" maxlength="35" size="35" styleClass="sel" /></TD>
											<TD class="view_item"><bean:message key="m3007" /> &nbsp;<html:text property="mas_marcas" maxlength="35" size="35" styleClass="sel" /></TD>
										</TR>
										<tr>
											<td> &nbsp;</td>
										</tr>
										<TR>
											<TD class="view_item"><bean:message key="m3008" />&nbsp;<html:text property="mas_altura" maxlength="35" size="35" styleClass="sel"  onkeyup="isNatural(this);" onblur="isNatural(this);" onfocus="this.select()" /></TD>
											<TD class="view_item"><bean:message key="m3009" /> &nbsp;<html:text property="mas_largo" maxlength="35" size="35" styleClass="sel"  onkeyup="isNatural(this);" onblur="isNatural(this);" onfocus="this.select()" /></TD>
										</TR>
										<tr>
											<td> &nbsp;</td>
										</tr>
										<TR>
											<TD class="view_item"><bean:message key="m3010" />&nbsp;
											
											<html:select property="mas_esteril" styleClass="select">
												<html:option value="0">
													<bean:message key="m3014" />
												</html:option>
												<html:option value="1">
													<bean:message key="m3015" />
												</html:option>
												<html:option value="2">
													<bean:message key="m3016" />
												</html:option>
											</html:select>
											</TD>
											<TD class="view_item"><bean:message key="m3011" /> &nbsp;<html:text property="mas_microchip" maxlength="35" size="35" styleClass="sel" /></TD>
										</TR>
										<tr>
											<td> &nbsp;</td>
										</tr>
										<TR>
											<TD class="view_item"><bean:message key="m3012" />&nbsp;<html:text property="mas_licenciarabia" maxlength="35" size="35" styleClass="sel" /></TD>
											<TD class="view_item"><bean:message key="m3013" /> &nbsp;<html:text property="mas_kennelclub" maxlength="35" size="35" styleClass="sel" /></TD>
										</TR>
										<tr>
											<td> &nbsp;</td>
										</tr>	
										
																				<TR>
											<TD colspan="2">&nbsp;</TD>
										</TR>
										<TR>
											<TD colspan="2" align="center" class="view_item"  style="border: 1px solid #009F00"><b><bean:message key="1027" /></b></TD>
										</TR>
										<tr>
											<td> &nbsp;</td>
										</tr>
										<TR>
											<TD class="view_item"><bean:message key="4" />&nbsp;<html:text property="pmas_nombre" maxlength="50" size="35" styleClass="sel" /></TD>
											<TD class="view_item"><bean:message key="5" /> &nbsp;<html:text property="pmas_apellido" maxlength="50" size="35" styleClass="sel" /></TD>
										</TR>
										<tr>
											<td> &nbsp;</td>
										</tr>	
									
										<TR>
											<TD class="view_item" colspan="2"><bean:message key="12" /></TD>
										</TR>
										<TR>
											<TD class="view_item"><bean:message key="13" />:&nbsp; <html:select property="pmas_pais_cod" styleClass="select" onchange="actualizar()">
												<html:options collection="PAISES" labelProperty="pais_des" property="pais_cod" />
											</html:select>&nbsp;&nbsp; <bean:message key="14" />:&nbsp; <html:select property="pmas_ciu_cod" styleClass="select">
												<html:options collection="CIUDADESPROP" labelProperty="ciu_des" property="ciu_cod" />
											</html:select></TD>
											<TD class="view_item">&nbsp; <bean:message key="47" />:&nbsp; <bean:message key="20" /> <html:radio property="pmas_sexo" value="<%=IConstantes.SEXO_MASCULINO%>" /> <bean:message key="21" /> <html:radio property="pmas_sexo" value="<%=IConstantes.SEXO_FEMENINO%>" /></TD>
										</TR>
										<TR>
											<TD colspan="2">&nbsp;</TD>
										</TR>
										<TR>
											<TD class="view_item" colspan="2"><bean:message key="15" /></TD>
										</TR>
										<TR>
											<TD class="view_item">&nbsp;<bean:message key="16" />&nbsp;<bean:message key="13" />:<html:text property="pmas_indpais1" maxlength="6" size="6" styleClass="sel" onkeyup="isNatural(this);" onblur="isNatural(this);" onfocus="this.select()" />&nbsp;<bean:message key="14" />:&nbsp;<html:text property="pmas_indciudad1" maxlength="6" size="6" styleClass="sel" onkeyup="isNatural(this);" onblur="isNatural(this);" onfocus="this.select()" /></TD>
											<TD class="view_item"><bean:message key="17" />:<html:text property="pmas_telefono1" maxlength="40" size="30" styleClass="sel" onkeyup="isNatural(this);" onblur="isNatural(this);" onfocus="this.select()" /></TD>
										</TR>
										<TR>
											<TD colspan="3" style="background-color: #ffffff">&nbsp;</TD>
										</TR>
										<TR>
											<TD colspan="3" class="view_item"><bean:message key="18" /></TD>
										</TR>
										<TR>
											<TD class="view_item"><bean:message key="16" />&nbsp;<bean:message key="13" />:&nbsp;<html:text property="pmas_indpais2" maxlength="6" size="6" styleClass="sel" onkeyup="isNatural(this);" onblur="isNatural(this);" onfocus="this.select()" /></TD>
											<TD class="view_item"><bean:message key="17" />:<html:text property="pmas_telefono2" maxlength="40" size="30" styleClass="sel" onkeyup="isNatural(this);" onblur="isNatural(this);" onfocus="this.select()" /></TD>
										</TR>
										<TR>
											<TD colspan="2">&nbsp;</TD>
										</TR>
										<TR>
											<TD class="view_item" colspan="2"><bean:message key="19" />:&nbsp;<html:text property="pmas_mail" maxlength="60" size="35" styleClass="sel" onchange="validar_mail1()" value='<%=((UsuarioPets)request.getSession().getAttribute("usuarioPets")).getUsup_usuario()%>' /></TD>
										</TR>
									</TABLE>
									</TD>
								</TR>


								<!-- Segundo id -->
								<TR>
									<TD colspan="4">
									<TABLE width="100%" id="tab2" cellspacing="0" cellpadding="0" style="display: none">
										<TR>
											<TD colspan="4">&nbsp;&nbsp;</TD>
										</TR>
										<TR>
											<TD colspan="4" class="view_item" align="left"><bean:message key="7320" /></TD>
										</TR>
										
										<TR>
											<TD class="view_item" align="left"><b><bean:message key="3019" /></b></TD>
											<TD colspan="2" class="view_item" align="left"><b><bean:message key="3020" />&nbsp;<html:radio property="mali_unidadpais" value="0" /></b> &nbsp;&nbsp;&nbsp;&nbsp;<b><bean:message key="3021" />&nbsp;<html:radio property="mali_unidadpais" value="1" /></b></TD>
											<TD class="view_item" align="left">&nbsp;</TD>
										</TR>
										<TR>
											<TD colspan="4" class="view_item">&nbsp;</TD>
										</TR>
										<TR>
											<TD colspan="4" class="view_item" align="left"><bean:message key="7303" /></TD>
										</TR>
										<TR>
											<TD colspan="4" class="view_item" align="left"><bean:message key="7304" /></TD>
										</TR>
										<TR>
											<TD colspan="4" class="view_item">&nbsp;</TD>
										</TR>

										<TR>
											<TD colspan="4" align="center" class="view_item"  style="border: 1px solid #009F00"><b><bean:message key="3016" /></b></TD>
										</TR>

										<TR>
											<TD align="center" rowspan="2" class="view_item"><b><bean:message key="3017" />&nbsp;</b></TD>
											<TD align="center">&nbsp; <html:hidden property="mali_fecultpeso" styleId="mali_fecultpeso" /> <SCRIPT language="JavaScript">obtenerCamposFecha('cDia2', 'cMes2', 'cAno2', 'mali_fecultpeso');</SCRIPT></TD>
											<TD align="center" rowspan="2" class="view_item"><b><bean:message key="3018" />&nbsp;</b></TD>
											<TD align="center" rowspan="2" class="view_item">&nbsp;<html:text property="mali_pesomascota" maxlength="5" size="5" styleClass="selNum" onkeyup="isFloat(this);" onblur="isFloat(this);calcularInfoPeso()" onfocus="this.select()" /></TD>
										</TR>

										<TR>
											<TD colspan="4" align="center">&nbsp;</TD>
										</TR>
										<TR>
											<TD colspan="2" class="view_item" align="center"><b><bean:message key="3022" /></b></TD>
											<TD class="view_item" align="center"><b><bean:message key="3023" />&nbsp;</b><html:text property="mali_pesominveterinario" maxlength="5" size="5" styleClass="selNum" onkeyup="isFloat(this);calcularInfoPeso()" onblur="isFloat(this);" onfocus="this.select()" /></TD>
											<TD class="view_item" align="center"><b><bean:message key="3024" />&nbsp;</b><html:text property="mali_pesomaxveterinario" maxlength="5" size="5" styleClass="selNum" onkeyup="isFloat(this);calcularInfoPeso()" onblur="isFloat(this);" onfocus="this.select()" /></TD>
										</TR>
										<!-- Peso recomendado por el veterinario -->
										<TR id="noSobrepeso" style="display: none">
											<TD colspan="4" class="view_item" align="center"><b><bean:message key="3027" /></b></td>
										</TR>
										<TR id="siSobrepeso" style="display: none">
											<TD colspan="4" class="view_item" align="center"><b><bean:message key="3025" /><script>calcularInfoPeso()</script>&nbsp;<html:text readonly="true" property="sobrepeso" size="2" maxlength="3" styleClass="selNum"/>&nbsp;<bean:message key="3026" /></b></TD>
										</TR>
										<TR>
											<TD colspan="4">&nbsp;</TD>
										</TR>
										<TR>
											<TD colspan="4">&nbsp;</TD>
										</TR>
										<TR>
											<TD colspan="4" align="center" class="view_item"  style="border: 1px solid #009F00"><B><bean:message key="1015" /></B></TD>
										</TR>
										<TR>
											<TD class="tdNameOption" align="center"><bean:message key="1022" /></TD>
											<TD class="tdNameOption" align="center"><bean:message key="1023" /></TD>
											<TD class="tdNameOption" align="center"><bean:message key="1024" /></TD>
											<TD class="tdNameOption" align="center"><bean:message key="2302" /></TD>
										</TR>
										<TR>
											<TD align="center"><html:radio property="mali_tipocomida" value="0" onclick="hab()" /></TD>
											<TD align="center"><html:radio property="mali_tipocomida" value="1" onclick="hab()" /></TD>
											<TD align="center"><html:radio property="mali_tipocomida" value="2" onclick="hab()" /></TD>
											<TD align="center"><html:radio property="mali_tipocomida" value="3" onclick="hab()" /></TD>
										</TR>
										<TR>
											<TD colspan="4">&nbsp;</TD>
										</TR>
										<TR>
											<TD colspan="4" align="center" class="view_item"  style="border: 1px solid #009F00"><B><bean:message key="1016" /></B></TD>
										</TR>
										<TR>
											<TD class="tdNameOption" align="center" colspan="2"><bean:message key="1017" /></TD>
											<TD class="tdNameOption" align="center" colspan="2"><bean:message key="1018" /></TD>
										</TR>
										<TR>
											<TD align="center" colspan="2">&nbsp;<html:text property="mali_fabricante" maxlength="30" size="30" styleClass="sel" onfocus="this.select()" /></TD>
											<TD align="center" colspan="2">&nbsp;<html:text property="mali_tipo" maxlength="30" size="30" styleClass="sel" onfocus="this.select()" /></TD>
										</TR>
										<TR>
											<TD colspan="4">&nbsp;</TD>
										</TR>
										<TR>
											<TD class="tdNameOption" align="center"><bean:message key="1019" /></TD>
											<TD class="tdNameOption" align="center"><bean:message key="1020" /></TD>
											<TD class="tdNameOption" align="center" colspan="2"><bean:message key="1021" /></TD>
										</TR>
										<TR>
											<TD align="center">&nbsp;<html:text property="mali_peso" maxlength="5" size="5" styleClass="selNum" onkeyup="isFloat(this);" onblur="isFloat(this);" onfocus="this.select()" /></TD>
											<TD align="center">&nbsp;<html:text property="mali_grxdosis" maxlength="5" size="5" styleClass="selNum" onkeyup="isFloat(this);" onblur="isFloat(this);" onfocus="this.select()" /></TD>
											<TD align="center" colspan="2">&nbsp;<html:text property="mali_dosisxdia" maxlength="5" size="5" styleClass="selNum" onkeyup="isNatural(this);" onblur="isNatural(this);" onfocus="this.select()" /></TD>
										</TR>
										<TR>
											<TD colspan="4">&nbsp;</TD>
										</TR>
									</TABLE>
									</TD>
								</TR>
								<!-- Tercer id -->
								<TR>
									<TD colspan="4">
									<TABLE border="0" id="tab3" cellspacing="0" cellpadding="0" style="display: none" width="100%">
										<TR>
											<TD>&nbsp;</TD>
										</TR>
										<TR>
											<TD class="view_item" align="left"><bean:message key="7305" /></TD>
										</TR>
										<TR>
											<TD>&nbsp;</TD>
										</TR>
										<!-- CUADRO UNIVERSAL DE VACUNAS -->
										<TR>
											<TD>
											<TABLE width="100%">
												<TR>
													<TD class="tdNameOption" align="center" colspan="13" style="border: 1px solid #4a6d00"><bean:message key="2282" /></TD>
												</TR>
												<TR>
												
													<TD class="tdNameOption" align="center" rowspan="2" style="border: 1px solid #4a6d00"><bean:message key="1028" /></TD>
													<TD class="tdNameOption" align="center" colspan="9" style="border: 1px solid #4a6d00"><bean:message key="2303" /></TD>
													<TD class="tdNameOption" align="center" rowspan="2" style="border: 1px solid #4a6d00">&nbsp;<bean:message key="1029" /></TD>
												</TR>
												<TR>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00">&nbsp;<bean:message key="1030" /></TD>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00">&nbsp;<bean:message key="1031" /></TD>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00">&nbsp;<bean:message key="1032" /></TD>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00">&nbsp;<bean:message key="1033" /></TD>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00">&nbsp;<bean:message key="1034" /></TD>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00">&nbsp;<bean:message key="1035" /></TD>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00">&nbsp;<bean:message key="1036" /></TD>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00">&nbsp;<bean:message key="1037" /></TD>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00">&nbsp;<bean:message key="1038" /></TD>
												</TR>

												<%int y = 0;%>
												<logic:iterate indexId="ind" id="vacunasCuidados" name="VACUNASCUIDADOSUNIVERSALES" type="com.servidoctor.parametros.model.VacunasCuidados" >
													<%if (y % 2 == 0) {%>
													<TR style="background: #ffffff">
														<%}%>
														<%if (y % 2 != 0) {%>
													<TR style="background: #f1f5fa">
														<%}%>

														
														<TD class="view_item"><bean:write name="vacunasCuidados" property="vcui_descripcion" /></TD>
														<logic:equal value="1" name="vacunasCuidados" property="vcui_30">
															<TD class="view_desc" align="center">
																<html:img page="/img/checkbox_checked.jpg"/>
															</TD>
														</logic:equal>
														<logic:equal value="0" name="vacunasCuidados" property="vcui_30">
															<TD class="view_desc" align="center">
																<html:img page="/img/checkbox_unchecked.jpg"/>
															</TD>
														</logic:equal>
														<logic:equal value="1" name="vacunasCuidados" property="vcui_45">
															<TD class="view_desc" align="center">
																<html:img page="/img/checkbox_checked.jpg"/>
															</TD>
														</logic:equal>
														<logic:equal value="0" name="vacunasCuidados" property="vcui_45">
															<TD class="view_desc" align="center">
																<html:img page="/img/checkbox_unchecked.jpg"/>
															</TD>
														</logic:equal>
														<logic:equal value="1" name="vacunasCuidados" property="vcui_60">
															<TD class="view_desc" align="center">
																<html:img page="/img/checkbox_checked.jpg"/>
															</TD>
														</logic:equal>
														<logic:equal value="0" name="vacunasCuidados" property="vcui_60">
															<TD class="view_desc" align="center">
																<html:img page="/img/checkbox_unchecked.jpg"/>
															</TD>
														</logic:equal>
														<logic:equal value="1" name="vacunasCuidados" property="vcui_75">
															<TD class="view_desc" align="center">
																<html:img page="/img/checkbox_checked.jpg"/>
															</TD>
														</logic:equal>
														<logic:equal value="0" name="vacunasCuidados" property="vcui_75">
															<TD class="view_desc" align="center">
																<html:img page="/img/checkbox_unchecked.jpg"/>
															</TD>
														</logic:equal>
														<logic:equal value="1" name="vacunasCuidados" property="vcui_90">
															<TD class="view_desc" align="center">
																<html:img page="/img/checkbox_checked.jpg"/>
															</TD>
														</logic:equal>
														<logic:equal value="0" name="vacunasCuidados" property="vcui_90">
															<TD class="view_desc" align="center">
																<html:img page="/img/checkbox_unchecked.jpg"/>
															</TD>
														</logic:equal>
														<logic:equal value="1" name="vacunasCuidados" property="vcui_105">
															<TD class="view_desc" align="center">
																<html:img page="/img/checkbox_checked.jpg"/>
															</TD>
														</logic:equal>
														<logic:equal value="0" name="vacunasCuidados" property="vcui_105">
															<TD class="view_desc" align="center">
																<html:img page="/img/checkbox_unchecked.jpg"/>
															</TD>
														</logic:equal>
														<logic:equal value="1" name="vacunasCuidados" property="vcui_120">
															<TD class="view_desc" align="center">
																<html:img page="/img/checkbox_checked.jpg"/>
															</TD>
														</logic:equal>
														<logic:equal value="0" name="vacunasCuidados" property="vcui_120">
															<TD class="view_desc" align="center">
																<html:img page="/img/checkbox_unchecked.jpg"/>
															</TD>
														</logic:equal>
														<logic:equal value="1" name="vacunasCuidados" property="vcui_150">
															<TD class="view_desc" align="center">
																<html:img page="/img/checkbox_checked.jpg"/>
															</TD>
														</logic:equal>
														<logic:equal value="0" name="vacunasCuidados" property="vcui_150">
															<TD class="view_desc" align="center">
																<html:img page="/img/checkbox_unchecked.jpg"/>
															</TD>
														</logic:equal>
														<logic:equal value="1" name="vacunasCuidados" property="vcui_180">
															<TD class="view_desc" align="center">
																<html:img page="/img/checkbox_checked.jpg"/>
															</TD>
														</logic:equal>
														<logic:equal value="0" name="vacunasCuidados" property="vcui_180">
															<TD class="view_desc" align="center">
																<html:img page="/img/checkbox_unchecked.jpg"/>
															</TD>
														</logic:equal>
														<TD class="view_desc" align="center"><bean:write name="vacunasCuidados" property="vcui_control" /></TD>
														<%y++;%>
													</TR>

												</logic:iterate>
											</TABLE>
											</TD>
										</TR>

										<!-- FIN CUADRO UNIVERSAL DE VACUNAS -->
										<TR>
											<TD colspan="4">&nbsp;</TD>
										</TR>
										<TR>
											<TD class="view_item" align="left" colspan="4"><bean:message key="7306" /></TD>
										</TR>
										
										<TR>
											<TD colspan="4">&nbsp;</TD>
										</TR>

										<!-- CUADRO AJUSTADO DE VACUNAS -->
										<TR>
											<TD colspan="4">
											<TABLE width="100%">
												<TR>
													<TD class="tdNameOption" align="center" colspan="13" style="border: 1px solid #4a6d00"><bean:message key="3086" /></TD>
												</TR>
												<TR>
													<TD class="tdNameOption" rowspan="2" style="border: 1px solid #4a6d00"><bean:message key="global.numeral"/></TD>
													<TD class="tdNameOption" rowspan="2" style="border: 1px solid #4a6d00" align="center"><bean:message key="1028" /></TD>
													<TD class="tdNameOption" align="center" colspan="9" style="border: 1px solid #4a6d00"><bean:message key="2303" /></TD>
													<TD class="tdNameOption" rowspan="2" style="border: 1px solid #4a6d00" align="center">&nbsp;<bean:message key="1029" /></TD>
													<TD class="tdNameOption" rowspan="2" style="border: 1px solid #4a6d00" align="center"><bean:message key="global.acciones" /></TD>
												</TR>
												<TR>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00">&nbsp;<bean:message key="1030" /></TD>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00">&nbsp;<bean:message key="1031" /></TD>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00">&nbsp;<bean:message key="1032" /></TD>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00">&nbsp;<bean:message key="1033" /></TD>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00">&nbsp;<bean:message key="1034" /></TD>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00">&nbsp;<bean:message key="1035" /></TD>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00">&nbsp;<bean:message key="1036" /></TD>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00">&nbsp;<bean:message key="1037" /></TD>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00">&nbsp;<bean:message key="1038" /></TD>
												</TR>

												<%int x = 0;%>
												<logic:iterate indexId="ind" id="vacunasCuidados" name="VACUNASCUIDADOS" type="com.servidoctor.parametros.model.VacunasCuidados" >
													<%if (x % 2 == 0) {%>
													<TR style="background: #ffffff">
														<%}%>
														<%if (x % 2 != 0) {%>
													<TR style="background: #f1f5fa">
														<%}%>

														<TD class="view_desc" align="center"><%=x + 1%></TD>
														<TD class="view_item"><bean:write name="vacunasCuidados" property="vcui_descripcion" /> <INPUT type="hidden" name="vcui_descripcion<%=x%>" value="<bean:write name="vacunasCuidados" property="vcui_descripcion" />"></TD>
														<logic:equal value="1" name="vacunasCuidados" property="vcui_30">
															<TD class="view_desc" align="center"><INPUT checked="checked" type="checkbox" name="check030<%=x%>"></TD>
														</logic:equal>
														<logic:equal value="0" name="vacunasCuidados" property="vcui_30">
															<TD class="view_desc" align="center"><INPUT type="checkbox" name="check030<%=x%>"></TD>
														</logic:equal>
														<logic:equal value="1" name="vacunasCuidados" property="vcui_45">
															<TD class="view_desc" align="center"><INPUT checked="checked" type="checkbox" name="check045<%=x%>"></TD>
														</logic:equal>
														<logic:equal value="0" name="vacunasCuidados" property="vcui_45">
															<TD class="view_desc" align="center"><INPUT type="checkbox" name="check045<%=x%>"></TD>
														</logic:equal>
														<logic:equal value="1" name="vacunasCuidados" property="vcui_60">
															<TD class="view_desc" align="center"><INPUT checked="checked" type="checkbox" name="check060<%=x%>"></TD>
														</logic:equal>
														<logic:equal value="0" name="vacunasCuidados" property="vcui_60">
															<TD class="view_desc" align="center"><INPUT type="checkbox" name="check060<%=x%>"></TD>
														</logic:equal>
														<logic:equal value="1" name="vacunasCuidados" property="vcui_75">
															<TD class="view_desc" align="center"><INPUT checked="checked" type="checkbox" name="check075<%=x%>"></TD>
														</logic:equal>
														<logic:equal value="0" name="vacunasCuidados" property="vcui_75">
															<TD class="view_desc" align="center"><INPUT type="checkbox" name="check075<%=x%>"></TD>
														</logic:equal>
														<logic:equal value="1" name="vacunasCuidados" property="vcui_90">
															<TD class="view_desc" align="center"><INPUT checked="checked" type="checkbox" name="check090<%=x%>"></TD>
														</logic:equal>
														<logic:equal value="0" name="vacunasCuidados" property="vcui_90">
															<TD class="view_desc" align="center"><INPUT type="checkbox" name="check090<%=x%>"></TD>
														</logic:equal>
														<logic:equal value="1" name="vacunasCuidados" property="vcui_105">
															<TD class="view_desc" align="center"><INPUT checked="checked" type="checkbox" name="check105<%=x%>"></TD>
														</logic:equal>
														<logic:equal value="0" name="vacunasCuidados" property="vcui_105">
															<TD class="view_desc" align="center"><INPUT type="checkbox" name="check105<%=x%>"></TD>
														</logic:equal>
														<logic:equal value="1" name="vacunasCuidados" property="vcui_120">
															<TD class="view_desc" align="center"><INPUT checked="checked" type="checkbox" name="check120<%=x%>"></TD>
														</logic:equal>
														<logic:equal value="0" name="vacunasCuidados" property="vcui_120">
															<TD class="view_desc" align="center"><INPUT type="checkbox" name="check120<%=x%>"></TD>
														</logic:equal>
														<logic:equal value="1" name="vacunasCuidados" property="vcui_150">
															<TD class="view_desc" align="center"><INPUT checked="checked" type="checkbox" name="check150<%=x%>"></TD>
														</logic:equal>
														<logic:equal value="0" name="vacunasCuidados" property="vcui_150">
															<TD class="view_desc" align="center"><INPUT type="checkbox" name="check150<%=x%>"></TD>
														</logic:equal>
														<logic:equal value="1" name="vacunasCuidados" property="vcui_180">
															<TD class="view_desc" align="center"><INPUT checked="checked" type="checkbox" name="check180<%=x%>"></TD>
														</logic:equal>
														<logic:equal value="0" name="vacunasCuidados" property="vcui_180">
															<TD class="view_desc" align="center"><INPUT type="checkbox" name="check180<%=x%>"></TD>
														</logic:equal>
														<TD class="view_desc" align="center"><INPUT type="text" name="control<%=x%>" value="<bean:write name="vacunasCuidados" property="vcui_control" scope="page" />" maxlength="4" size="4" class="sel" onkeyup="isNatural(this);" onblur="isNatural(this);"></TD>
														<TD align="center"><IMG border="0" onClick="edit_vacuna('<%=x%>')" src="<%=request.getContextPath()%>/images/editar.gif" alt="<bean:message key="138"/>" width="16" height="16" style='cursor: "hand"'> <IMG border="0" onClick="remove_vacuna('<%=x%>', '<bean:write name="vacunasCuidados" property="vcui_descripcion" scope="page"/>')" src="<%=request.getContextPath()%>/images/eliminar.gif" alt="<bean:message key="139"/>" width="16" height="16" style="cursor: hand"></TD>
														<%x++;%>
													</TR>
												</logic:iterate>
												<TR>
													<TD colspan="13" align="center"><INPUT type="button" onClick="add_vacuna()" class="sbttn" value="<bean:message key="global.button.adicionar"/> <bean:message key="3028"/>"> <input type="hidden" name="tamVacunas" value="<%=x%>" /></TD>
												</TR>
													  <TR>
											<TD class="view_item" align="left" colspan="13"><bean:message key="730701" /></TD>
										</TR>

											</TABLE>
											</TD>
										</TR>
										<TR>
											<TD><INPUT type="hidden" name="total" value="<%=x%>"></TD>
										</TR>
										<!-- FIN CUADRO AJUSTADO DE VACUNAS -->
										<TR>
											<TD>&nbsp;</TD>
										</TR>
									</TABLE>
									</TD>
								</TR>


								<!-- Cuarto id -->
								<TR>
									<TD colspan="4">
									<TABLE border="0" id="tab4" cellspacing="0" cellpadding="0" style="display: none" width="100%">
										<TR>
											<TD colspan="2">&nbsp;</TD>
										</TR>
										<TR>
											<TD colspan="2" class="view_item" align="left"><bean:message key="7308" /></TD>
										</TR>
										<TR>
											<TD colspan="2">&nbsp;</TD>
										</TR>
										<TR>
											<TD colspan="2" align="center" class="view_item"  style="border: 1px solid #009F00"><bean:message key="1025" /></TD>
										</TR>
										<TR>
											<TD colspan="2">&nbsp;</TD>
										</TR>
										<TR>
											<TD class="view_item"><bean:message key="4" />:&nbsp;<html:text property="cmas_nombre" size="40" maxlength="40" styleClass="sel" /></TD>
											<TD class="view_item"><bean:message key="5" />:&nbsp;<html:text property="cmas_apellido" size="40" maxlength="40" styleClass="sel" /></TD>
										</TR>
										<TR>
											<TD colspan="2">&nbsp;</TD>
										</TR>
										<TR>
											<TD class="view_item"><bean:message key="22" />:&nbsp;<html:hidden property="cmas_fecnacim" styleId="mali_fecultpeso" /><SCRIPT language="JavaScript">obtenerCamposFecha('cDia3', 'cMes3', 'cAno3', 'cmas_fecnacim');</SCRIPT></TD>
											<TD class="view_item">&nbsp; <bean:message key="47" />:&nbsp; <bean:message key="20" /> <html:radio property="cmas_sexo" value="<%=IConstantes.SEXO_MASCULINO%>" /> <bean:message key="21" /> <html:radio property="cmas_sexo" value="<%=IConstantes.SEXO_FEMENINO%>" /></TD>
										</TR>
										<TR>
											<TD colspan="2">&nbsp;</TD>
										</TR>
										<tr>
											<TD class="view_item"><bean:message key="6177" />:&nbsp; <html:select property="cmas_idio_cod" styleClass="select">
												<% 
												if(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2).equals("es")){ %>
												<html:options collection="IDIOMAS" labelProperty="idio_descripcion" property="idio_cod" />
												<%}
												if(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2).equals("en")){ %>
												<html:options collection="IDIOMAS" labelProperty="idio_description" property="idio_cod" />
												<%} %>
											</html:select></TD>
										</tr>
										<TR>
											<TD colspan="2">&nbsp;</TD>
										</TR>
										<TR>
											<TD class="view_item" colspan="2"><bean:message key="12" /></TD>
										</TR>
										<TR>
											<TD colspan="2">&nbsp;</TD>
										</TR>
										<TR>
											<TD class="view_item" colspan="2">&nbsp; <bean:message key="13" />:&nbsp; <html:select property="cmas_pais_cod" styleClass="select" onchange="actualizar()">
												<html:options collection="PAISES" labelProperty="pais_des" property="pais_cod" />
											</html:select>&nbsp;&nbsp; <bean:message key="14" />:&nbsp; <html:select property="cmas_ciu_cod" styleClass="select">
												<html:options collection="CIUDADESCONT1" labelProperty="ciu_des" property="ciu_cod" />
											</html:select></TD>
										</TR>
										<TR>
											<TD>&nbsp;</TD>
										</TR>
										<TR>
											<TD class="view_item" colspan="2">&nbsp;<bean:message key="19" />:&nbsp;<html:text property="cmas_mail" size="35" maxlength="60" styleClass="sel" onchange="validar_mali2()" value="<%=((UsuarioPets)request.getSession().getAttribute(\"usuarioPets\")).getUsup_usuario()%>" disabled="true"/></TD>
										</TR>
										<TR>
											<TD colspan="2">&nbsp;</TD>
										</TR>
										<tr>
											<td colspan="2">
											<table>
																								
											</table>
											</td>
										</tr>
									</TABLE>
									</TD>
								</TR>


								<!-- Quinto id -->
								<TR>
									<TD colspan="4">
									<TABLE border="0" id="tab5" cellspacing="0" cellpadding="0" style="display: none" width="100%">
										<TR>
											<TD>&nbsp;</TD>
										</TR>
										<TR>
											<TD>
											<TABLE width="100%">
												<TR>
													<TD colspan="8" valign="middle" class="view_item" align="left"><bean:message key="7310" /></TD>
												</TR>
												<TR>
													<TD colspan="8" valign="middle" class="view_item" align="left"><bean:message key="7312" /></TD>
												</TR>
												<TR align="center" valign="middle">
													<TD rowspan="2" class="tdNameOption" style="border: 1px solid #4a6d00" align="center"><bean:message key="global.numeral"/></TD>
													<TD rowspan="2" class="tdNameOption" style="border: 1px solid #4a6d00" align="center"><bean:message key="1514" /></TD>
													<TD rowspan="2" class="tdNameOption" style="border: 1px solid #4a6d00" align="center"><bean:message key="1515" /></TD>
													<TD rowspan="2" class="tdNameOption" style="border: 1px solid #4a6d00" align="center"><bean:message key="1517" /></TD>
													<TD colspan="3" class="tdNameOption" style="border: 1px solid #4a6d00" align="center"><bean:message key="1518" /></TD>
													<TD rowspan="2" class="tdNameOption" style="border: 1px solid #4a6d00" align="center"><bean:message key="global.acciones" /></TD>
												</TR>
												<TR>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00" align="center">&nbsp;<bean:message key="1519" />&nbsp;&nbsp;</TD>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00" align="center">&nbsp;<bean:message key="1520" />&nbsp;&nbsp;</TD>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00" align="center">&nbsp;<bean:message key="1521" />&nbsp;&nbsp;</TD>
												</TR>
												<%x = 0;%>
												<logic:iterate indexId="ind" id="medicamento" name="MASCOTAMEDICAMENTOS" type="com.servidoctor.sdpets.model.MascotaMedicamentos">
													<%if (x % 2 == 0) {%>
													<TR style="background: #ffffff" align="center" valign="middle">
														<%}%>
														<%if (x % 2 != 0) {%>
													<TR style="background: #f1f5fa" align="center" valign="middle">
														<%}%>

														<TD class="view_item" align="center"><%=x + 1%></TD>
														<TD class="view_item" align="left"><bean:write name="medicamento" property="mmed_afeccion" scope="page" /></TD>
														<TD class="view_desc" align="left"><bean:write name="medicamento" property="mmed_nombre" scope="page" /></TD>
														<TD class="view_desc" align="center"><%=com.servidoctor.util.classes.ManejoFechas.FormateoFecha(medicamento.getMmed_fec_inicio().toString())%></TD>
														<TD class="view_desc" align="center"><bean:write name="medicamento" property="mmed_dias_uso" scope="page" /></TD>
														<TD class="view_desc" align="center"><bean:write name="medicamento" property="mmed_veces_dia" scope="page" /></TD>
														<TD class="view_desc" align="center"><bean:write name="medicamento" property="mmed_dosis" scope="page" /></TD>
														<TD align="center"><IMG border="0" onClick="edit_medicamento('<%=x%>')" src="<%=request.getContextPath()%>/images/editar.gif" alt="<bean:message key="138"/>" width="16" height="16" style='cursor: "hand"'> <IMG border="0" onClick="remove_medicamento('<%=x%>', '<bean:write name="medicamento" property="mmed_nombre" scope="page"/>')" src="<%=request.getContextPath()%>/images/eliminar.gif" alt="<bean:message key="139"/>" width="16" height="16" style='cursor: "hand"'></TD>
													</TR>
													<%x++;%>
													
												</logic:iterate>
												<TR>
													<TD colspan="8" align="center"><INPUT type="button" onClick="add_medicamento()" class="sbttn" value="<bean:message key="global.button.adicionar"/>&nbsp;<bean:message key="58"/>"> <input type="hidden" name="tamMedicamentos" value="<%=x%>" /></TD>
												</TR>
												<!--<TR>
													<TD colspan="8">
													<HR size="1" noshade="noshade" align="center" width="100%">
													</TD>
												</TR>
												<TR>
													<TD colspan="8" valign="middle" class="view_item" align="left"><bean:message key="7311" /></TD>
												</TR>
												<TR>
													<TD colspan="8" align="center" valign="middle"><html:text styleClass="selNum" property="mas_rechec" maxlength="3" size="3" onkeyup="isNatural(this);" onblur="isNatural(this);" onfocus="this.select()" /></TD>
												</TR>
												<TR>
													<TD colspan="8" align="center" valign="middle" class="view_item">&nbsp;</TD>
												</TR>-->
												
											</TABLE>
											</TD>
										</TR>
									</TABLE>
									</TD>
								</TR>

								<!-- Sexto id -->
								<TR>
									<TD colspan="4">
									<TABLE border="0" id="tab6" cellspacing="0" cellpadding="0" style="display: none" width="100%">
										<TR>
											<TD>
											<TABLE width="100%">
												<TR>
													<TD colspan="5" class="view_item" align="left"><bean:message key="7315" /></TD>
												</TR>
												<TR>
													<TD colspan="5">&nbsp;</TD>
												</TR>
												<TR>
													<TD class="tdNameOption" align="center" colspan="5" style="border: 1px solid #4a6d00"><bean:message key="2281" /></TD>
												</TR>
												<TR align="center" valign="middle" align="center">
													<TD class="tdNameOption" style="border: 1px solid #4a6d00"><bean:message key="global.numeral"/></TD>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00"><bean:message key="1028" /></TD>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00"><bean:message key="3029" /></TD>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00"><bean:message key="3042" /></TD>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00"><bean:message key="global.acciones" /></TD>
												</TR>
												<%int j = 0;%>
												<logic:iterate indexId="ind" id="controlCuidados" name="CONTROLCUIDADOS" type="com.servidoctor.sdpets.model.ControlCuidados">
													<%if (j % 2 == 0) {%>
													<TR style="background: #ffffff" align="center" valign="middle">
														<%}%>
														<%if (j % 2 != 0) {%>
													<TR style="background: #f1f5fa" align="center" valign="middle">
														<%}%>
														<TD class="view_item" align="center"><%=j + 1%> <INPUT type="hidden" name="ccui_cod<%=j%>" value="<bean:write name="controlCuidados" property="ccui_cod" scope="page" />" /></TD>
														<TD class="view_item" align="left"><bean:write name="controlCuidados" property="ccui_descripcion" scope="page" /> <INPUT type="hidden" name="ccui_descripcion<%=j%>" value="<bean:write name="controlCuidados" property="ccui_descripcion" scope="page" />" /></TD>
														<TD class="view_item" align="center"><%=com.servidoctor.util.classes.ManejoFechas.FormateoFecha(controlCuidados.getCcui_fecultapli().toString())%> <INPUT type="hidden" name="ccui_fecultapli<%=j%>" value="<%=controlCuidados.getCcui_fecultapli().toString()%>" /></TD>
														<%if (controlCuidados.getCcui_cita_prox().equals(IConstantes.CODIGO_SI)) {%>
														<TD class="view_item" align="center"><%=com.servidoctor.util.classes.ManejoFechas.FormateoFecha(controlCuidados.getCcui_fecproxapli().toString())%> <%} else {%>
														<TD class="view_item" align="center">--- <%}%> <INPUT type="hidden" name="ccui_fecproxapli<%=j%>" value="<%=controlCuidados.getCcui_fecproxapli().toString()%>" /></TD>
														<TD align="center"><IMG border="0" onClick="edit_control('<%=j%>')" src="<%=request.getContextPath()%>/images/editar.gif" alt="<bean:message key="138"/>" width="16" height="16" style="cursor: hand"></TD>
													</TR>
													<%j++;%>
												</logic:iterate>
											</TABLE>
											</TD>
										</TR>

										<TR>
											<TD>
											<TABLE width="100%">
												<TR>
													<TD colspan="5">&nbsp;</TD>
												</TR>
												<TR>
													<TD class="tdNameOption" align="center" colspan="5" style="border: 1px solid #4a6d00"><bean:message key="3030" /></TD>
												</TR>
												<TR align="center" valign="middle">
													<TD class="tdNameOption" style="border: 1px solid #4a6d00"><bean:message key="global.numeral"/></TD>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00"><bean:message key="3032" /></TD>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00"><bean:message key="3033" /></TD>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00"><bean:message key="3034" /></TD>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00"><bean:message key="3035" /></TD>
												</TR>
												<%j = 0;%>
												<logic:iterate indexId="ind" id="controlCuidados" name="CONTROLCUIDADOS" type="com.servidoctor.sdpets.model.ControlCuidados">
													<%if (j % 2 == 0) {%>
													<TR style="background: #ffffff" align="center" valign="middle">
														<%}%>
														<%if (j % 2 != 0) {%>
													<TR style="background: #f1f5fa" align="center" valign="middle">
														<%}%>
														<TD class="view_item" align="center"><%=j + 1%> <INPUT type="hidden" name="ccui_cod<%=j%>" value="<bean:write name="controlCuidados" property="ccui_cod" scope="page" />" /></TD>
														<TD class="view_item" align="left"><bean:write name="controlCuidados" property="ccui_vetnombre" scope="page" /> <INPUT type="hidden" name="ccui_vetnombre<%=j%>" value="<bean:write name="controlCuidados" property="ccui_vetnombre" scope="page" />" /></TD>
														<TD class="view_item" align="left"><bean:write name="controlCuidados" property="ccui_vetdireccion" scope="page" /> <INPUT type="hidden" name="ccui_vetdireccion<%=j%>" value="<bean:write name="controlCuidados" property="ccui_vetdireccion" scope="page" />" /></TD>
														<TD class="view_item" align="left"><bean:write name="controlCuidados" property="ccui_email" scope="page" /> <INPUT type="hidden" name="ccui_email<%=j%>" value="<bean:write name="controlCuidados" property="ccui_email" scope="page" />" /></TD>
														<TD class="view_item" align="center"><bean:write name="controlCuidados" property="ccui_indpais" scope="page" /> <INPUT type="hidden" name="ccui_indpais<%=x%>" value="<bean:write name="controlCuidados" property="ccui_indpais" scope="page" />" />&nbsp; <bean:write name="controlCuidados" property="ccui_indciudad" scope="page" /> <INPUT type="hidden" name="ccui_indciudad<%=j%>" value="<bean:write name="controlCuidados" property="ccui_indciudad" scope="page" />" />&nbsp; <bean:write
															name="controlCuidados" property="ccui_telefono" scope="page" /> <INPUT type="hidden" name="ccui_telefono<%=j%>" value="<bean:write name="controlCuidados" property="ccui_telefono" scope="page" />" /></TD>
													</TR>
													<%j++;%>
												</logic:iterate>
											</TABLE>
											</TD>
										</TR>
										<TR>
											<TD>&nbsp;</TD>
										</TR>
										<tr>
											<TD colspan="5">
											<table width="100%">
												<TR>
													<TD colspan="2" class="view_item" align="left"><bean:message key="7316" /></TD>
												</TR>
												<TR>
													<TD colspan="2" class="view_item" align="left"><bean:message key="7317" /></TD>
												</TR>
												<TR>
													<TD colspan="2">&nbsp;</TD>
												</TR>
												<tr>
													<TD colspan="2" class="view_item"></TD>
												</tr>
												<tr>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00"><bean:message key="6200" /></TD>
													<TD class="tdNameOption" style="border: 1px solid #4a6d00" align="center"><bean:message key="6201" /></TD>
												</tr>
												<%x = 0;%>
												<%y = 0;%>
												<logic:iterate indexId="ind" id="grupo" name="GRUPOSMASCOTA" type="com.servidoctor.sdpets.model.GruposMascota">
													<%if (x % 2 == 0) {%>
													<tr style="background: #ffffff">
														<td class="view_item"><%=request.getAttribute("grupm_desc" + x)%></td>													
														<td class="view_desc" align="center"><html:text name="grupo" property="grupm_dias_antes" size="3" maxlength="3" style="selNum" indexed="true" /></td>
													</tr>
													<%}%>
													<%if (x % 2 != 0) {%>
													<tr style="background: #ffffff">
														<td class="view_item"><%=request.getAttribute("grupm_desc" + x)%></td>													
														<td class="view_desc" align="center"><html:text name="grupo" property="grupm_dias_antes" size="3" maxlength="3" style="selNum" indexed="true" readonly="true" /></td>
													</tr>
													<%}%>

													<logic:iterate id="control" name="CONTROLCUIDADOS" type="com.servidoctor.sdpets.model.ControlCuidados">
														<%if (control.getCcui_grup_cod().equals(grupo.getGrupm_grup_cod())) {%>
														<tr>
															<td class="view_item">&nbsp;&nbsp;&nbsp;- - -&nbsp;<bean:write name="control" property="ccui_descripcion" /></td>
															<td class="view_item"><bean:message key="6219" /><html:select indexed="true" name="control" property="ccui_grup_cod" onchange="actualizar()">
																<html:options collection="GRUPOS" property="grup_cod" labelProperty="grup_desc"></html:options>
															</html:select></td>
														</tr>
														<%}%>
													</logic:iterate>
													<%x++;%>
												</logic:iterate>
											</table>
											</TD>
										</tr>
										<tr>
											<TD>&nbsp;</TD>
										</tr>
									</TABLE>
									</TD>
								</TR>
								
								<!-- Septimo tab-->
								<tr>
									<TD colspan="4">
										
										
										<TABLE border="0"  id="tab9"  cellspacing="0" cellpadding="0" width="100%">
														<tr>
															<TD colspan="4" class="view_item">
																<bean:message key="7264" />
															</TD>
														</tr>
														<tr>
															<TD class="TdNameOption">
																<bean:message key="2071" />
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>


														<tr>
															<TD class="view_item">
																<bean:message key="7247a" arg0='<%=res.getMessage("parametro_adicion_enfermedad")%>' />
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<td class="view_item">
																<bean:message key="7202a" />
															</td>
														</tr>
														<tr>
															<td>
																<table width="100%">
																	<tr>
																		<td class="tdNameOption" width="5%" style="border: 1px solid #009F00" align="center">
																			<bean:message key="global.numeral" />
																		</td>
																		<TD class="tdNameOption" width="30%" style="border: 1px solid #009F00">
																			<bean:message key="704" />
																		</TD>
																		<TD class="tdNameOption" width="30%" style="border: 1px solid #009F00">
																			<bean:message key="170" />
																		</TD>
																		<TD class="tdNameOption" width="20%" style="border: 1px solid #009F00" align="center">
																			<bean:message key="54" />
																		</TD>
																		<td width="15%" class="tdNameOption" style="border: 1px solid #009F00" align="center">
																			&nbsp;
																			<bean:message key="137" />
																			&nbsp;&nbsp;
																		</td>
																	</tr>
																	<%
																		x = 0;
																	%>
																	<logic:iterate indexId="ind" id="enfermedad" name="ENFERMEDADESPETS" type="com.servidoctor.sdpets.model.EnfermedadesPets">
																		<tr>
																			<TD class="view_desc" align="center"><%=x + 1%></TD>
																			<td class="view_item">
																				<bean:write name="enfermedad"  property="enfp_des" scope="page" />
																					
																			</td>
																			<td class="view_desc">
																				&nbsp;&nbsp;
																				<bean:write name="enfermedad" property="enfp_novedad" scope="page" />
																				&nbsp;&nbsp;
																			</td>
																			<td class="view_desc" align="center">
																				&nbsp;&nbsp;
																				<bean:write name="enfermedad" property="enfp_anio_desde" scope="page" />
																				&nbsp;&nbsp;
																			</td>
																			<td align="center">
																				<IMG border="0" onClick="edit_enf_pets('<%=x%>')" src="<%=request.getContextPath()%>/images/editar.gif" alt="<bean:message key="138"/>"
																		width="16" height="16" style="cursor: hand">
																	<IMG border="0" onClick="remove_enf_pets('<%=x%>', '<bean:write name="enfermedad" property="enfp_des" scope="page" />')"
																		src="<%=request.getContextPath()%>/images/eliminar.gif" alt="<bean:message key="139"/>" width="16" height="16" style="cursor: hand">

																			</td>
																		</tr>
																		<%
																			x++;
																		%>
																	</logic:iterate>
																</table>
															</td>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD align="center">
																<INPUT type="button" onClick="add_enf('<%=x%>')" class="sbttn" value="<bean:message key="historiamedica_enfermedad.button"/>">
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="TdNameOption">
																<bean:message key="2080" />
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="7248a" arg0='<%=res.getMessage( "parametro_adicion_alergia" )%>' />
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<td class="view_item">
																<bean:message key="7202a" />
															</td>
														</tr>
														<tr>
															<td>
																<table width="100%">
																	<tr>
																		<td class="tdNameOption" width="5%" style="border: 1px solid #009F00" align="center">
																			<bean:message key="global.numeral" />
																		</td>
																		<TD class="tdNameOption" width="30%" style="border: 1px solid #009F00">
																			<bean:message key="56" />
																		</TD>
																		<TD class="tdNameOption" width="30%" style="border: 1px solid #009F00">
																			<bean:message key="170" />
																		</TD>
																		<TD class="tdNameOption" width="20%" style="border: 1px solid #009F00" align="center">
																			<bean:message key="54" />
																		</TD>
																		<td class="tdNameOption" width="15%" style="border: 1px solid #009F00" align="center">
																			&nbsp;
																			<bean:message key="137" />
																			&nbsp;&nbsp;
																		</td>
																	</tr>
																	<%
																		x = 0;
																	%>
																	<logic:iterate indexId="indx" id="alergia" name="ALERGIASPETS" type="com.servidoctor.sdpets.model.AlergiasPets">
																		<tr>
																			<TD class="view_desc" align="center"><%=x + 1%></TD>
																			<td class="view_item">
																				<bean:write name="alergia"  property="alep_des" scope="page" />
																			</td>
																			<td class="view_desc">
																				<bean:write name="alergia" property="alep_novedad" scope="page" />
																			</td>
																			<td class="view_desc" align="center">
																				<bean:write name="alergia" property="alep_anio_desde" scope="page" />
																			</td>
																			<td align="center">
																				<IMG border="0" onClick="edit_ale_pets('<%=x%>')" src="<%=request.getContextPath()%>/images/editar.gif" alt="<bean:message key="138"/>"
																		width="16" height="16" style="cursor: hand">
																	<IMG border="0" onClick="remove_ale_pets('<%=x%>', '<bean:write name="alergia" property="alep_des" scope="page" />')"
																		src="<%=request.getContextPath()%>/images/eliminar.gif" alt="<bean:message key="139"/>" width="16" height="16" style="cursor: hand">

																			</td>
																		</tr>
																		<%
																			x++;
																		%>
																	</logic:iterate>
																	
																	
																</table>
															</td>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD align="center">
																<INPUT type="button" onClick="add_ale_pets('<%=x%>')" class="sbttn" value="<bean:message key="historiamedica_alergia.button"/>">
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="TdNameOption">
																<bean:message key="2089" />
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="7249a" arg0="<%=res.getMessage(\"parametro_adicion_cirujia\" )%>" />
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<td class="view_item">
																<bean:message key="7202a" />
															</td>
														</tr>
														<tr>
															<td>
																<table width="100%">
																	<tr>
																		<td class="tdNameOption" width="5%" style="border: 1px solid #009F00" align="center">
																			<bean:message key="global.numeral" />
																		</td>
																		<TD class="tdNameOption" width="50%" style="border: 1px solid #009F00">
																			<bean:message key="61" />
																		</TD>
																		<TD class="tdNameOption" width="30%" style="border: 1px solid #009F00" align="center">
																			<bean:message key="62" />
																		</TD>
																		<td class="tdNameOption" width="15%" style="border: 1px solid #009F00" align="center">
																			&nbsp;
																			<bean:message key="137" />
																			&nbsp;&nbsp;
																		</td>
																	</tr>
																	<%
																		x = 0;
																	%>
																	<logic:iterate indexId="indx" id="cirujia" name="CIRUGIASPETS" type="com.servidoctor.sdpets.model.CirugiasPets">

																		<tr>
																			<TD class="view_desc" align="center"><%=x + 1%></TD>
																			<td class="view_item">
																				
																					<bean:write name="cirujia"  property="cirp_des" scope="page" />
																				
																			</td>
																			<td class="view_desc" align="center">
																				<bean:write name="cirujia" property="cirp_anio" scope="page" />
																			</td>
																			<td colspan="2" align="center">
																				<IMG border="0" onClick="edit_cir_pets('<%=x%>')" src="<%=request.getContextPath()%>/images/editar.gif" alt="<bean:message key="138"/>"
																					width="16" height="16" style="cursor: hand">
																				
																					<IMG border="0" onClick="remove_cir_pets('<%=x%>','<bean:write name="cirujia" property="cirp_des" scope="page" />')"
																						src="<%=request.getContextPath()%>/images/eliminar.gif" alt="<bean:message key="139"/>" width="16" height="16"
																						style="cursor: hand">
																				
																			</td>
																		</tr>
																		<%
																			x++;
																		%>
																	</logic:iterate>
																</table>
															</td>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD align="center">
																<INPUT type="button" onClick="add_cir_pets('<%=x%>')" class="sbttn" value="<bean:message key="historiamedica_cirujia.button"/>">
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
													</TABLE>
												</td>
											</tr>
										
								<!-- Octavo tab-->
								
								<tr>
									<TD colspan="4">
										<TABLE border="0" id="tab8" cellspacing="0" cellpadding="0" style="display: none" width="100%">
										<tr>
												<TD colspan="3">
													<table border="0" cellpadding="0" cellspacing="0"  width="100%">
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<td class="view_item" colspan="8">
																<bean:message key="7205" arg0="<%=res.getMessage( \"parametro_adicion_seguro\" )%>" />
															</td>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<td class="view_item" colspan="8">
																<bean:message key="7202a" />
															</td>
														</tr>
														<tr>
															<td class="tdNameOption" style="border: 1px solid #009F00" rowspan="3" align="center">
																&nbsp;
																<bean:message key="global.numeral" />
																&nbsp;
															</td>
															<TD class="tdNameOption" style="border: 1px solid #009F00" rowspan="3" align="center">
																<bean:message key="28" />
																&nbsp;&nbsp;&nbsp;
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #009F00" rowspan="3" align="center">
																<bean:message key="29" />
																&nbsp;&nbsp;&nbsp;
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #009F00" rowspan="3" width="40%" align="center">
																<bean:message key="30" />
																&nbsp;&nbsp;&nbsp;
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #009F00" colspan="3" align="center">
																<bean:message key="31" />
															</TD>
															<td class="tdNameOption" style="border: 1px solid #009F00" rowspan="3" align="center">
																&nbsp;
																<bean:message key="137" />
																&nbsp;&nbsp;
															</td>
														</tr>
														<tr>
															<TD class="tdNameOption" style="border: 1px solid #009F00" align="center" colspan="2">
																<bean:message key="32" />
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #009F00" rowspan="2" align="center">
																<bean:message key="17" />
																&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="tdNameOption" style="border: 1px solid #009F00" align="center">
																<bean:message key="13" />
																&nbsp;&nbsp;&nbsp;
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #009F00" align="center">
																<bean:message key="14" />
																&nbsp;&nbsp;&nbsp;
															</TD>

														</tr>
														<%
															x = 0;
														%>
														<logic:iterate indexId="indx" id="seguropets" name="SEGUROPETS" type="com.servidoctor.sdpets.model.SeguroPets">
															<tr>
																<TD class="view_desc" align="center"><%=x + 1%></TD>
																<td class="view_item" align="left">
																	<bean:write name="seguropets" property="segp_nomcia" scope="page" />
																	&nbsp;&nbsp;
																</td>
																<td class="view_desc" align="center">
																	<bean:write name="seguropets" property="segp_polizaafi" scope="page" />
																	&nbsp;&nbsp;
																</td>
																<td class="view_desc" align="left">
																	<bean:write name="seguropets" property="segp_contacto" scope="page" />
																	&nbsp;&nbsp;
																</td>
																<td class="view_desc" align="center">
																	<bean:write name="seguropets" property="segp_indpais3" scope="page" />
																	&nbsp;&nbsp;
																</td>
																<td class="view_desc" align="center">
																	<bean:write name="seguropets" property="segp_indciudad3" scope="page" />
																	&nbsp;&nbsp;
																</td>
																<td class="view_desc" align="center">
																	<bean:write name="seguropets" property="segp_telefono3" scope="page" />
																	&nbsp;&nbsp;
																</td>
																<td align="center">
																	<IMG border="0" onClick="edit_seguro_pets('<%=x%>')" src="<%=request.getContextPath()%>/images/editar.gif" alt="<bean:message key="138"/>"
																		width="16" height="16" style="cursor: hand">
																	<IMG border="0" onClick="remove_seguro('<%=x%>', '<bean:write name="seguropets" property="segp_nomcia" scope="page" />')"
																		src="<%=request.getContextPath()%>/images/eliminar.gif" alt="<bean:message key="139"/>" width="16" height="16" style="cursor: hand">
																</td>
															</tr>
															<%
																x++;
															%>
														</logic:iterate>
														
														
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD colspan="8" align="center">
																<INPUT type="button" onClick="add_seguro(<%=x%>)" class="sbttn" value="<bean:message key="datospersonales_seguro.button"/>">
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
													</table>
												</TD>
											</tr>
											
											
											
									</TABLE>
									</TD>
								</tr>
								
								<!--  Noveno id -->
								
                      <tr>
                        <td colspan="4">
                          <TABLE border="0" id="tab7" cellspacing="0" cellpadding="0"  style="display: none" width="100%">
                            <tr>
                              <td>
                                <table border="0" cellpadding="0" cellspacing="0" width="100%">
                                 <tr>
                                <td colspan="4">
                                 &nbsp;
                                </td>
                             </tr> <tr>
                                <td colspan="4">
                                 &nbsp;
                                </td>
                             </tr>
                                  <tr><td colspan="3" class="view_item">
                                      <bean:message key="4007" arg0="<%=request.getContextPath()%>" />
                                    </td>
                                  </tr>
                                  <tr>
			                        <td class="tdNameOption" colspan="4">

			                        </td>
			                      </tr>
   
                                  
                                  <tr>
                                    <td>
                                      &nbsp;
                                    </td>
                                  </tr>
                                  <tr>
                                    <td class="view_item">
                                      <bean:message key="main.login.username" />
                                    </td>
                                    <td class="view_desc">
                                      <bean:write name="usuarioPets" property="usup_usuario" />
                                    </td>
                                    <td></td>
                                  </tr>
                                  <tr>
                                    <td class="view_item">
                                      <bean:message key="main.login.password" />
                                    </td>
                                    <td>
                                      <html:text name="usuarioPets" property="usup_clave_emer" size="30" maxlength="30" disabled="true" />
                                    </td>
                                    <td>&nbsp;
                                      <!--  <input type="button" class="sbttn" value="<bean:message key="6236" />" onclick="enviar('<%=request.getContextPath()%>/CarnePets/generar.do')">-->
                                    </td>
                                  </tr>
                                  <tr>
                                    <td>
                                      &nbsp;
                                    </td>
                                  </tr>
                                  <tr>
                                    <td colspan="3">
                                      <strong><bean:message key="4014" arg0="<%=request.getContextPath()%>" /></strong><br/><br/><img src="<%=request.getContextPath()%>/manager/sdpets/carnep_<%=request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2)%>.jpg" border="0"><br>
                                    </td>
                                  </tr>
                                  <tr>                                  
                                    <td colspan="3">
                                      &nbsp;
                                    </td>
                                  </tr>
                                  <tr>                                  
                                    <td class="view_item" colspan="3">
                                      <bean:message key="4013a" arg0="<%=request.getContextPath()%>" />
                                    </td>
                                  </tr>
                                  <tr>                                  
                                    <td colspan="3">
                                      &nbsp;
                                    </td>
                                  </tr>
                                  <tr>                                  
                                    <td class="view_item" colspan="3">
                                      <bean:message key="4011" arg0="<%=request.getContextPath()%>" />&nbsp;1&nbsp;&nbsp;&nbsp;<INPUT type="text" name="nuevo1" id="nuevo1"   size="50" maxlength="30" value=""/>
                                    </td>
                                  </tr>
                                  <tr>                                  
                                    <td colspan="3">
                                      &nbsp;
                                    </td>
                                  </tr>
                                  <tr>                                  
                                  <td class="view_item" colspan="3">
                                      <bean:message key="4011" arg0="<%=request.getContextPath()%>" />&nbsp;2&nbsp;&nbsp;&nbsp;<INPUT type="text" name="nuevo2" id="nuevo2" size="50" maxlength="30" value=""/>
                                    </td>
                                  </tr>
                                  <tr>                                  
                                    <td colspan="3">
                                      &nbsp;
                                    </td>
                                  </tr>
                                  <tr>                                  
                                  <td class="view_item" colspan="3">
                                      <bean:message key="4011" arg0="<%=request.getContextPath()%>" />&nbsp;3&nbsp;&nbsp;&nbsp;<INPUT type="text" name="nuevo3" id="nuevo3"  size="50" maxlength="30" value=""/>
                                    </td>
                                  </tr>
                                  <tr>                                  
                                    <td colspan="3">
                                      &nbsp;
                                    </td>
                                  </tr>
                                  <tr>                                  
                                    <td class="view_item" colspan="3" align="center">
                                      <INPUT type="button"  class="sbttn" value="<bean:message key="4010"/>" onClick="view_popup_pets(this.form.nuevo1.value,this.form.nuevo2.value,this.form.nuevo3.value);">
                                    </td>
                                  </tr>
                                  <tr>                                  
                                    <td colspan="3">
                                      &nbsp;
                                    </td>
                                  </tr>
                                </table>
                              </td>
                            </tr>
                          </table>
                        </td>
                      </tr>
								
								
								
								<!-- Tabla abajo BOTON GUARDAR-->
								<TR>
									<TD colspan="4">
									<TABLE height="30px" cellpadding="0" cellspacing="0" border="0" width="100%">
										<TR>
											<TD align="center">
											<HR size="1" noshade="noshade" align="center" width="100%">
											</TD>
										</TR>
										<TR align="center" valign="middle">
											<TD><INPUT type="button" onClick="enviarD('<%=request.getContextPath()%>/DatosMascota/saveEdit.do')" class="sbttn" value="<bean:message key="136"/>"></TD>
										</TR>
										<TR>
											<TD>
											<DIV align="right" class="imprimir"><IMG alt="<bean:message key="global.imprimiralt"/>" src="<%=request.getContextPath()%>/images/print.gif" border="0" height="22" width="20">&nbsp;<A href="javascript: self.print();"><B><bean:message key="global.imprimir" /></B></A></DIV>
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
			</TD>
		</TR>
	</TABLE>
	<input type="hidden" id="fabricante_si_no" value="<%=request.getAttribute("fabricante_si_no")%>">
	<SCRIPT language="JavaScript">
	tab_charge('editmascota','pets');
	</SCRIPT>
</html:form>



</BODY>
</HTML>
