<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="com.servidoctor.constantes.IConstantes,org.apache.struts.util.MessageResources,com.servidoctor.seguridad.model.UsuarioFamily"%>
<%@ page import="com.servidoctor.sdfamily.model.GrupoUsuarioSegmentacion"%>
<%@ page import="com.servidoctor.sdfamily.model.LogoComprador"%>
<%@ page import="com.servidoctor.sdfamily.dao.GrupoUsuarioSegmentacionDAO"%>
<%@ page import="com.servidoctor.sdfamily.dao.LogoCompradorDAO"%>
<%@ page import="com.servidoctor.seguridad.model.UsuarioFamily"%>
<%@ page import="com.servidoctor.sdfamily.dao.DatosPersonalesDAO"%>
<%@ page import="com.servidoctor.sdfamily.model.DatosPersonales"%>


<%!MessageResources res = MessageResources.getMessageResources( "com.servidoctor.resources.ApplicationResources" );%>
<SCRIPT>
function enviarD(ruta){
    noTelFijo = false;
    noTelMovil = false;
    if ((Trim(document.forms[0].datp_indpais1.value)=='' || document.forms[0].datp_indpais1.value=='0') || (Trim(document.forms[0].datp_indciudad1.value)=='' || document.forms[0].datp_indciudad1.value=='0') || (Trim(document.forms[0].datp_telefono1.value)=='' || document.forms[0].datp_telefono1.value=='0')){
    	noTelFijo = true;
    }if ((Trim(document.forms[0].datp_indpais2.value=='') || document.forms[0].datp_indpais2.value=='0') || (Trim(document.forms[0].datp_telefono2.value)=='' || document.forms[0].datp_telefono2.value=='0')){
    	noTelMovil = true;
    }
	if(document.forms[0].datp_nombre.value=='' || document.forms[0].datp_nombre.value=='0'){
         alert('<bean:message key="6102" />');
         document.forms[0].datp_nombre.focus();
         return false;
	}if(!(document.forms[0].datp_sexo[0].checked || document.forms[0].datp_sexo[1].checked)){
         alert('<bean:message key="6129" />');
         document.forms[0].datp_apellido.focus();
         return false;
    if(document.forms[0].datp_apellido.value=='' || document.forms[0].datp_apellido.value=='0'){
         alert('<bean:message key="6103" />');
         document.forms[0].datp_apellido.focus();
         return false;
	}
	}if(calculaEdad(true) && (document.forms[0].datp_id_doc.value=='' || document.forms[0].datp_id_doc.value=='0')){
         alert('<bean:message key="6120" />');
         document.forms[0].datp_id_doc.focus();
         return false;
	}if((document.forms[0].datp_indpais1.value=='' || document.forms[0].datp_indpais1.value=='0') && noTelMovil){
         alert('<bean:message key="6104" />');
         document.forms[0].datp_indpais1.focus();
         return false;
	}if((document.forms[0].datp_indciudad1.value=='' || document.forms[0].datp_indciudad1.value=='0') && noTelMovil){
         alert('<bean:message key="6105" />');
         document.forms[0].datp_indciudad1.focus();
         return false;
	}if((document.forms[0].datp_telefono1.value=='' || document.forms[0].datp_telefono1.value=='0') && noTelMovil){
         alert('<bean:message key="6106" />');
         document.forms[0].datp_telefono1.focus();
         return false;
	}if((document.forms[0].datp_indpais2.value=='' || document.forms[0].datp_indpais2.value=='0') && noTelFijo){
         alert('<bean:message key="6107" />');
         document.forms[0].datp_indpais2.focus();
         return false;
	}if((document.forms[0].datp_telefono2.value=='' || document.forms[0].datp_telefono2.value=='0') && noTelFijo){
         alert('<bean:message key="6108" />');
         document.forms[0].datp_telefono2.focus();
         return false;
	}
	
	convertirACampo('cDia1', 'cMes1', 'cAno1', 'datp_fecnacim');
	convertirACampo('cDia2', 'cMes2', 'cAno2', 'datp_med_fecha1');
	convertirACampo('cDia3', 'cMes3', 'cAno3', 'datp_med_fecha2');
	convertirACampo('cDia4', 'cMes4', 'cAno4', 'datp_med_fecha3');
	document.forms[0].action = ruta;
	document.forms[0].datp_mail.disabled = false;
	if (!calculaEdad(true) && (document.forms[0].parent_nombre.value=='' || document.forms[0].parent_apellido.value=='' || document.forms[0].parent_tarjeta.value=='0')){
		disclaimer();
	}else{
		<% UsuarioFamily usuarioFamily2 = (UsuarioFamily) request.getSession().getAttribute("usuarioFamily"); 	  
		  DatosPersonalesDAO datosPersonalesDAO = new DatosPersonalesDAO();
		  DatosPersonales datosPersonales =datosPersonalesDAO.retrive(usuarioFamily2.getUsuf_cod());
		%>
		if ('<%=datosPersonales.getDatp_sexo()%>'=='F' || '<%=datosPersonales.getDatp_sexo()%>'=='M'){
			
			document.forms[0].datp_sexo.disabled=true;
			document.forms[0].submit();
		}else{
			var k=confirm('<bean:message key="2177"/> ?');	//mensaje de confirmacion del sexo
			if(k) {
				 document.forms[0].datp_sexo.disabled=true;
				 document.forms[0].submit();
			}
			 
		}
	}
}

function guardarForm(){
	convertirACampo('cDia1', 'cMes1', 'cAno1', 'datp_fecnacim');
	convertirACampo('cDia2', 'cMes2', 'cAno2', 'datp_med_fecha1');
	convertirACampo('cDia3', 'cMes3', 'cAno3', 'datp_med_fecha2');
	convertirACampo('cDia4', 'cMes4', 'cAno4', 'datp_med_fecha3');
	enviar('<%=request.getContextPath()%>/DatosPer/add.do');
}

function add_cont(tama){
	if(tama>=<bean:message key="parametro_adicion_cont"/>){
		alert('<bean:message key="parametro_superado_cont"/>');
		return false;
	}else{
		if(hay_popup_abierto()){
			return false;
		}
		guardarForm();
		eval("window.open('<%=request.getContextPath()%>/DatosPer/Popup/add_cont.do?','contacto','scrollbars=yes, top=100, left=200, width=700, height=630')")
		return true;
	}
}

function edit_cont(x)
{
	if(hay_popup_abierto()){
		return false;
	}
	guardarForm();
	eval("window.open('<%=request.getContextPath()%>/DatosPer/Popup/edit_cont.do?num_contacto="+x+"','contacto','scrollbars=yes, top=100, left=200, width=700, height=600')")
}

function remove_cont(x, nom){
	var r=confirm('<bean:message key="6240"/>' + " " + nom + "?");
	if(r){
		guardarForm();
		enviar("<%=request.getContextPath()%>/DatosPer/Popup/remove_cont.do?num_contacto="+x);
	}
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
		eval("window.open('<%=request.getContextPath()%>/DatosPer/Popup/add_seguro.do?','contacto','scrollbars=yes, top=50, left=200, width=720, height=700')")
		return true;
	}
}

function edit_seguro(x){
	if(hay_popup_abierto()){	
		return false;
	}
	guardarForm();
	eval("window.open('<%=request.getContextPath()%>/DatosPer/Popup/edit_seguro.do?num_seguro="+x+"','contacto','scrollbars=yes, top=50, left=200, width=720, height=700')")
}

function remove_seguro(x, nom){
	var r=confirm('<bean:message key="6240"/>' + " " + nom + "?");
	if(r){
		guardarForm();
		enviar("<%=request.getContextPath()%>/DatosPer/Popup/remove_seguro.do?num_seguro="+x);
	}
}

function calculaEdad(noPopup){
	var now = new Date();
	var mayor = false;
	if (parseInt(now.getFullYear(),10) - parseInt(datosPersonalesForm.cAno1.value, 10) > 18){
		mayor = true;
	}
	if (parseInt(now.getFullYear(),10) - parseInt(datosPersonalesForm.cAno1.value, 10) == 18){
		
		if (parseInt(now.getMonth(),10) - parseInt(datosPersonalesForm.cMes1.value, 10) > -1){
			mayor = true;
		}else if(parseInt(now.getMonth(),10) - parseInt(datosPersonalesForm.cMes1.value, 10) == -1){
			if (parseInt(now.getDate(),10) - parseInt(datosPersonalesForm.cDia1.value, 10) >= -1){
				mayor = true;
			}
		}
	}
	if (!mayor){
		convertirACampo('cDia1', 'cMes1', 'cAno1', 'datp_fecnacim');
		if (!noPopup){
			disclaimer();
		}
		document.all.documento.style.display='none'
		document.all.parentescos.style.display=''
		document.all.parent1.style.display=''
		document.all.parent2.style.display=''
		document.all.parent3.style.display=''
	}else{
		document.all.documento.style.display=''
		document.all.parentescos.style.display='none'
		document.all.parent1.style.display='none'
		document.all.parent2.style.display='none'
		document.all.parent3.style.display='none'
	}
	return mayor;
}

function disclaimer(){
	guardarForm();
	eval("window.open('<%=request.getContextPath()%>/DatosPer/Popup/disclaimer.do?','contacto','scrollbars=yes, top=100, left=250, width=650, height=380')")
}

function obtenerCamposFechaModified(namedia, namemes, nameano, campoFinal) {
	var i;	
	if (navigator.appName == 'Netscape') {
		i = ano + 1900 - 90;
		a = ano + 1900;
	} else {
		i = ano- 90; 
		a = ano;
	}
	
	document.write ("<table>");
	document.write ("	<tr align='center'>");
	document.write ("		<td class='view_item'>DD</td>");
	document.write ("		<td class='view_item'>MM</td>");
	document.write ("		<td class='view_item'>YYYY</td>");
	document.write ("	</tr>");
	document.write ("	<tr>");
	document.write ("		<td class='view_item'>");
	document.write ("			<select class='select' name='" + namedia + "' id='" + namedia + "'>");
	document.write ("				<option value='00'>--</option>");
	document.write ("				<option value='01'>01</option>");
	document.write ("				<option value='02'>02</option>");
	document.write ("				<option value='03'>03</option>");
	document.write ("				<option value='04'>04</option>");
	document.write ("				<option value='05'>05</option>");
	document.write ("				<option value='06'>06</option>");
	document.write ("				<option value='07'>07</option>");
	document.write ("				<option value='08'>08</option>");
	document.write ("				<option value='09'>09</option>");
	document.write ("				<option value='10'>10</option>");
	document.write ("				<option value='11'>11</option>");
	document.write ("				<option value='12'>12</option>");
	document.write ("				<option value='13'>13</option>");
	document.write ("				<option value='14'>14</option>");
	document.write ("				<option value='15'>15</option>");
	document.write ("				<option value='16'>16</option>");
	document.write ("				<option value='17'>17</option>");
	document.write ("				<option value='18'>18</option>");
	document.write ("				<option value='19'>19</option>");
	document.write ("				<option value='20'>20</option>");
	document.write ("				<option value='21'>21</option>");
	document.write ("				<option value='22'>22</option>");
	document.write ("				<option value='23'>23</option>");
	document.write ("				<option value='24'>24</option>");
	document.write ("				<option value='25'>25</option>");
	document.write ("				<option value='26'>26</option>");
	document.write ("				<option value='27'>27</option>");
	document.write ("				<option value='28'>28</option>");
	document.write ("				<option value='29'>29</option>");
	document.write ("				<option value='30'>30</option>");
	document.write ("				<option value='31'>31</option>");
	document.write ("			</select>");
	document.write ("		</td>");
	document.write ("		<td class='view_item'>");
	document.write ("			<select class='select' name='" + namemes + "' id='" + namemes + "'>");
	document.write ("				<option value='00'>--</option>");
	document.write ("				<option value='01'>01</option>");
	document.write ("				<option value='02'>02</option>");
	document.write ("				<option value='03'>03</option>");
	document.write ("				<option value='04'>04</option>");
	document.write ("				<option value='05'>05</option>");
	document.write ("				<option value='06'>06</option>");
	document.write ("				<option value='07'>07</option>");
	document.write ("				<option value='08'>08</option>");
	document.write ("				<option value='09'>09</option>");
	document.write ("				<option value='10'>10</option>");
	document.write ("				<option value='11'>11</option>");
	document.write ("				<option value='12'>12</option>");
	document.write ("			</select>");
	document.write ("		</td>");	
	document.write ("		<td class='view_item'>");
	document.write ("			<select class='select' name='" + nameano + "' id='" + nameano + "' onchange='calculaEdad(false)'>");
	document.write ("				<option value='0000'>----</option>");
	for (i; i <= a; i++) {
		if(i == a) {
			document.write ("			<option value='" + i + "' selected>" + i + "</option>");
		} else {
			document.write ("			<option value='" + i + "'>" + i + "</option>");
		}
	}
	document.write ("			</select>");
	document.write ("		</td>");	
	document.write ("	</tr>");
	document.write ("</table>");
	
	seleccionarActual(namedia, namemes, nameano, campoFinal);
}

</SCRIPT>

<html:form target="_self" action="/DatosPer/add.do">
	<html:hidden property="datp_usuf_cod"/>
	<html:hidden property="datp_fecinscripcion"/>
	<html:hidden property="datp_num_dias_no_mail"/>
	<table border="0" width="100%">
		<tr>
			<td>
				<table class="tablag" align="center" cellpadding="0" cellspacing="0" border="0" width="650">
					<tr>
						<td>
							<table align="center" cellpadding="0" cellspacing="0" border="0" width="100%">
								<tr>
									<TD  colspan="4">
						<TABLE cellpadding="0" cellspacing="0" border="0" width="100%">
							<TR>
								<TD  align="left" valign="bottom">
								   	<img src="<%=request.getContextPath()%>/images/int_tit_family.gif">                           
								</TD>

	                          <TD>&nbsp;<%
		                           UsuarioFamily usuarioFamily = (UsuarioFamily) request.getSession().getAttribute("usuarioFamily");
		                             
		                             GrupoUsuarioSegmentacion grupoUsuarioSegmentacion = new GrupoUsuarioSegmentacion();
		                             GrupoUsuarioSegmentacionDAO grupoUsuarioSegmentacionDAO = new GrupoUsuarioSegmentacionDAO();
		                             GrupoUsuarioSegmentacion grupoUsuario=null;
		                             if (usuarioFamily.getUsuf_especial().intValue()==1){
		                             	grupoUsuario = grupoUsuarioSegmentacionDAO.retrive("F"+usuarioFamily.getUsuf_cod().toString());  
		                             }else{
		                             	grupoUsuario = grupoUsuarioSegmentacionDAO.retrieve("F"+usuarioFamily.getUsuf_licencia());  
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
									LogoComprador datosPublicidadCompletos = logoCompradorDAO.retrieve(grupoUsuario.getGrupo_id(),ifechaActual);
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
											<tr>
												<td class="tdOverNameOption" colspan="3">
													<bean:message key="2002" />
												</td>
											</tr>
											<tr>
												<td class="tdNameOption" colspan="3">
													<table border="0" cellpadding="0" cellspacing="1">
														<tr>
															<TD id="tab11" class="sbttn tdNameOption" onClick="tab('1','datos_personales','family')">
																<bean:message key="1" />
															</TD>
															<TD id="tab12" class="sbttn tdNameOption" onClick="tab('2','datos_personales','family')">
																<bean:message key="2" />
															</TD>
															<TD id="tab13" class="sbttn tdNameOption" onClick="tab('3','datos_personales','family')">
																<bean:message key="3" />
															</TD>
															<TD id="tab14" class="sbttn tdNameOption" onClick="tab('4','datos_personales','family')">
																<bean:message key="578" />
															</TD>
														</tr>
													</table>
												</td>
											</tr>
											<tr>
												<td colspan="3">
													<table border="0" id="tab1">
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<td class="view_item" colspan="9">
																<bean:message key="7201" />
															</td>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="view_item" nowrap="nowrap">
																<bean:message key="4" />
																:&nbsp;&nbsp;
																<html:text property="datp_nombre" maxlength="30" size="40" styleClass="sel" />
															</TD>
															<TD class="view_item" nowrap="nowrap">
																<bean:message key="5" />
																:&nbsp;&nbsp;&nbsp;
																<html:text property="datp_apellido" maxlength="30" size="40" styleClass="sel" />
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="view_item" colspan="3">
																<bean:message key="12" />
															</TD>
														</tr>
														<tr>
															<TD class="view_item" nowrap="nowrap">
																&nbsp;
																<bean:message key="13" />
																:&nbsp;
																<html:select property="datp_pais_cod" styleClass="select" onchange="actualizarCiudades(this.value, 'ciudadesContent');">
																	<html:options collection="PAISES" labelProperty="pais_des" property="pais_cod" />
																</html:select>
															</TD>
															<TD class="view_item" nowrap="nowrap">
																&nbsp;
																<bean:message key="14" />
																:&nbsp;
																<html:select property="datp_ciu_cod" styleClass="select" styleId="ciudadesContent">
																	<html:options collection="CIUDADES" labelProperty="ciu_des" property="ciu_cod" />
																</html:select>
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="view_item" nowrap="nowrap">
																<bean:message key="47" />
																:&nbsp;																
																<%
																UsuarioFamily usuarioFamily3 = (UsuarioFamily) request.getSession().getAttribute("usuarioFamily"); 	  
							 									DatosPersonalesDAO datosPersonalesDAO1 = new DatosPersonalesDAO();
	  															
	  															DatosPersonales datosPersonalesa =datosPersonalesDAO1.retrive(usuarioFamily3.getUsuf_cod());
																if (datosPersonales.getDatp_sexo()!=null){
																	if ( datosPersonalesa.getDatp_sexo().equals(new String("F")) || datosPersonalesa.getDatp_sexo().equals(new String("M")) ) {
																		if (datosPersonalesa.getDatp_sexo().equals(new String("F"))){
																		%>
																			<bean:message key="20" />
																			<html:radio property="datp_sexo" value="M"  disabled="true"/>
																			<bean:message key="21" />
																			<html:radio property="datp_sexo" value="F" />	
																		<% 
																		}
																		if (datosPersonalesa.getDatp_sexo().equals(new String("M"))){
																		%>
																		<bean:message key="20" />
																			<html:radio property="datp_sexo" value="M" />
																			<bean:message key="21" />
																			<html:radio property="datp_sexo" value="F"  disabled="true"/>
																		<%}%>
																	
																	<%
																	} else {
																	%>
																	<bean:message key="20" />
																	<html:radio property="datp_sexo" value="M" />
																	<bean:message key="21" />
																	<html:radio property="datp_sexo" value="F" />
																
																	<%
																	}
																	%>
																<%}else{%>
																<bean:message key="20" />
																	<html:radio property="datp_sexo" value="M" />
																	<bean:message key="21" />
																	<html:radio property="datp_sexo" value="F" />
																
																<%} %>
																
																
																
																
																
																
																
																
															</TD>
															<TD class="view_item" nowrap="nowrap">
																<bean:message key="22" />
																:&nbsp;
																<html:hidden property="datp_fecnacim" styleId="datp_fecnacim" />
																<SCRIPT language="JavaScript">obtenerCamposFechaModified('cDia1', 'cMes1', 'cAno1', 'datp_fecnacim');</SCRIPT>
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="view_item" nowrap="nowrap">
																<bean:message key="23" />
																:&nbsp;
																<html:select property="datp_tipsan_cod" styleClass="select">
																	<html:options collection="TIPOSANGRE" labelProperty="tipsan_des" property="tipsan_cod" />
																</html:select>
															</TD>
															<TD class="view_item" nowrap="nowrap">
																<bean:message key="571" />
																:&nbsp;
																<html:select property="datp_escolaridad" styleClass="select">
																	<html:options collection="ESCOLARIDAD" labelProperty="esco_des" property="esco_cod" />
																</html:select>
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="view_item" nowrap="nowrap">
																<bean:message key="572" />
																:&nbsp;
																<html:select property="datp_estado" styleClass="select">
																	<html:options collection="ESTADOCIVIL" labelProperty="eciv_des" property="eciv_cod" />
																</html:select>
															</TD>
															<TD class="view_item" nowrap="nowrap">
																<bean:message key="562" />
																:&nbsp;
																<html:select property="datp_hijos" styleClass="select">
																	<html:option value="0" />
																	<html:option value="1" />
																	<html:option value="2" />
																	<html:option value="3" />
																	<html:option value="4" />
																	<html:option value="5" />
																	<html:option value="6" />
																	<html:option value="7" />
																	<html:option value="8" />
																	<html:option value="9" />
																	<html:option value="10" />
																	<html:option value="11" />
																	<html:option value="12" />
																	<html:option value="13" />
																	<html:option value="14" />
																	<html:option value="15" />
																</html:select>
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="view_item" nowrap="nowrap">
																<bean:message key="6177" />
																:&nbsp;
																<html:select property="datp_idioma" styleClass="select">
																	<html:options collection="IDIOMAS" labelProperty="idio_descripcion" property="idio_cod" />
																</html:select>
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr id="documento">
															<TD class="view_item" nowrap="nowrap">
																<bean:message key="6" />
																:&nbsp;
																<html:select property="datp_id_tipo" styleClass="select">
																	<html:options collection="DOCUMENTOS" labelProperty="doc_des" property="doc_cod" />
																</html:select>
															</TD>
															<TD class="view_item" nowrap="nowrap">
																<bean:message key="11" />
																:&nbsp;
																<html:text property="datp_id_doc" maxlength="20" size="20" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)" />
															</TD>
														</tr>
														<tr id="parentescos">
															<TD class="view_item" nowrap="nowrap">
																&nbsp;
																<bean:message key="27" />
																:&nbsp;
															</TD>
															<TD class="view_item" colspan="2"><%=request.getAttribute( "rfam_des" )%></TD>
														</tr>

														<tr id="parent1">
															<TD class="view_item">
																&nbsp;
																<bean:message key="4" />
																:&nbsp;
															</TD>
															<TD class="view_item" colspan="2">
																<html:hidden property="parent_nombre" />
																<bean:write name="datosPersonalesForm" property="parent_nombre" />
															</TD>
														</tr>
														<tr id="parent2">
															<TD class="view_item">
																&nbsp;
																<bean:message key="5" />
																:&nbsp;
															</TD>
															<TD class="view_item" colspan="2">
																<html:hidden property="parent_apellido" />
																<bean:write name="datosPersonalesForm" property="parent_apellido" />
															</TD>
														</tr>
														<tr id="parent3">
															<TD class="view_item">
																&nbsp;
																<bean:message key="6206" />
																:&nbsp;
															</TD>
															<TD class="view_item" colspan="2">
																<html:hidden property="parent_tarjeta" />
																<bean:write name="datosPersonalesForm" property="parent_tarjeta" />
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="view_item" colspan="3">
																<bean:message key="15" />
															</TD>
														</tr>
														<tr>
															<TD class="view_item" nowrap="nowrap">
																&nbsp;
																<bean:message key="16" />
																&nbsp;
																<bean:message key="13" />
																:
																<html:text property="datp_indpais1" maxlength="3" size="6" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)"
																	onfocus="this.select()" />
																&nbsp;
																<bean:message key="14" />
																:&nbsp;
																<html:text property="datp_indciudad1" maxlength="4" size="6" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)"
																	onfocus="this.select()" />
															</TD>
															<TD class="view_item" nowrap="nowrap">
																<bean:message key="17" />
																:
																<html:text property="datp_telefono1" maxlength="15" size="30" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)"
																	onfocus="this.select()" />
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD colspan="3" class="view_item">
																<bean:message key="18" />
															</TD>
														</tr>
														<tr>
															<TD class="view_item" nowrap="nowrap">
																<bean:message key="16" />
																&nbsp;
																<bean:message key="13" />
																:&nbsp;
																<html:text property="datp_indpais2" maxlength="3" size="6" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)"
																	onfocus="this.select()" />
																&nbsp;
															</TD>
															<TD class="view_item" nowrap="nowrap">
																<bean:message key="17" />
																:
																<html:text property="datp_telefono2" maxlength="15" size="30" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)"
																	onfocus="this.select()" />
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="view_item" colspan="3">
																<bean:message key="19" />
																:&nbsp;
																  <html:text property="datp_mail" maxlength="40" size="50" styleClass="sel" value='<%=( ( UsuarioFamily ) session.getAttribute( "usuarioFamily" ) ).getUsuf_usuario()%>' disabled="true" />
															</TD>
														</tr>
													</table>
												</td>
											</tr>
											<tr>
												<td colspan="3">
													<table border="0" id="tab2" cellspacing="0" cellpadding="0" style="display: none" width="100%">
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<td class="view_item" colspan="8">
																<bean:message key="7202" arg0='<%=res.getMessage( "parametro_adicion_cont" )%>' />
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
															<td class="tdNameOption" style="border: 1px solid #D98200" rowspan="3" align="center">
																<bean:message key="global.numeral" />
															</td>
															<td class="tdNameOption" style="border: 1px solid #D98200" rowspan="3" align="center">
																<bean:message key="6101" />
															</td>
															<td class="tdNameOption" style="border: 1px solid #D98200" rowspan="3" align="center">
																<bean:message key="4" />
															</td>
															<td class="tdNameOption" style="border: 1px solid #D98200" rowspan="3" align="center">
																<bean:message key="5" />
															</td>
															<TD class="tdNameOption" style="border: 1px solid #D98200" colspan="3" align="center">
																<bean:message key="31" />
															</TD>
															<td class="tdNameOption" style="border: 1px solid #D98200" rowspan="3" align="center">
																<bean:message key="137" />
															</td>
														</tr>
														<tr>
															<TD class="tdNameOption" style="border: 1px solid #D98200" align="center" colspan="2">
																<bean:message key="32" />
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #D98200" align="center" rowspan="2">
																<bean:message key="17" />
																&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															</TD>

														</tr>
														<tr>
															<TD class="tdNameOption" style="border: 1px solid #D98200" align="center">
																<bean:message key="13" />
																&nbsp;&nbsp;&nbsp;
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #D98200" align="center">
																<bean:message key="14" />
																&nbsp;&nbsp;&nbsp;
															</TD>
														</tr>
														<%
															int x = 0;
														%>
														<logic:iterate indexId="ind" id="contacto" name="CONTACTOS" type="com.servidoctor.sdfamily.model.CasoEmergencia">
															<tr>
																<TD class="view_desc" align="center"><%=x + 1%></TD>
																<td class="view_desc" align="center">
																	<bean:write name="contacto" property="case_orden" scope="page" />
																	&nbsp;&nbsp;
																</td>
																<td class="view_desc" align="left">
																	<bean:write name="contacto" property="case_nombre" scope="page" />
																</td>
																<td class="view_desc" align="left">
																	<bean:write name="contacto" property="case_apellido" scope="page" />
																</td>
																<%
																	if ( contacto.getCase_indpais1().equals( IConstantes.CODIGO_NO_EXISTE ) ) {
																%>
																<td class="view_desc" align="center">
																	<bean:write name="contacto" property="case_indpais2" scope="page" />
																</td>
																<td class="view_desc" align="center"></td>
																<td class="view_desc" align="center">
																	<bean:write name="contacto" property="case_telefono2" scope="page" />
																</td>
																<%
																	} else {
																%>
																<td class="view_desc" align="center">
																	<bean:write name="contacto" property="case_indpais1" scope="page" />
																</td>
																<td class="view_desc" align="center">
																	<bean:write name="contacto" property="case_indciudad1" scope="page" />
																</td>
																<td class="view_desc" align="center">
																	<bean:write name="contacto" property="case_telefono1" scope="page" />
																</td>
																<%
																	}
																%>
																<td align="center">
																	<IMG border="0" onClick="edit_cont('<%=x%>')" src="<%=request.getContextPath()%>/images/editar.gif" alt="<bean:message key="138"/>"
																		width="16" height="16" style="cursor: hand">
																	<IMG border="0"
																		onClick="remove_cont('<%=x%>', '<bean:write name="contacto" property="case_nombre" scope="page"/> <bean:write name="contacto" property="case_apellido" scope="page"/>')"
																		src="<%=request.getContextPath()%>/images/eliminar.gif" alt="<bean:message key="139"/>" width="16" height="16" style="cursor: hand">
																</td>
															</tr>
															<%
																x++;
															%>
														</logic:iterate>
														<tr>
															<TD colspan="7">
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD colspan="8" align="center">
																<INPUT type="button" onClick="add_cont(<%=x%>)" class="sbttn" value="<bean:message key="datospersonales_contacto.button"/>">
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
													</table>
												</td>
											</tr>
											<tr>
												<TD colspan="3">
													<table border="0" cellpadding="0" cellspacing="0" id="tab3" style="display: none" width="100%">
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<td class="view_item" colspan="8">
																<bean:message key="7205" arg0="<%=res.getMessage( "parametro_adicion_seguro" )%>" />
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
															<td class="tdNameOption" style="border: 1px solid #D98200" rowspan="3" align="center">
																&nbsp;
																<bean:message key="global.numeral" />
																&nbsp;
															</td>
															<TD class="tdNameOption" style="border: 1px solid #D98200" rowspan="3" align="center">
																<bean:message key="28" />
																&nbsp;&nbsp;&nbsp;
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #D98200" rowspan="3" align="center">
																<bean:message key="29" />
																&nbsp;&nbsp;&nbsp;
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #D98200" rowspan="3" width="40%" align="center">
																<bean:message key="30" />
																&nbsp;&nbsp;&nbsp;
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #D98200" colspan="3" align="center">
																<bean:message key="31" />
															</TD>
															<td class="tdNameOption" style="border: 1px solid #D98200" rowspan="3" align="center">
																&nbsp;
																<bean:message key="137" />
																&nbsp;&nbsp;
															</td>
														</tr>
														<tr>
															<TD class="tdNameOption" style="border: 1px solid #D98200" align="center" colspan="2">
																<bean:message key="32" />
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #D98200" rowspan="2" align="center">
																<bean:message key="17" />
																&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="tdNameOption" style="border: 1px solid #D98200" align="center">
																<bean:message key="13" />
																&nbsp;&nbsp;&nbsp;
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #D98200" align="center">
																<bean:message key="14" />
																&nbsp;&nbsp;&nbsp;
															</TD>

														</tr>
														<%
															x = 0;
														%>
														<logic:iterate indexId="indx" id="seguro" name="SEGUROS" type="com.servidoctor.sdfamily.model.SeguroMedico">
															<tr>
																<TD class="view_desc" align="center"><%=x + 1%></TD>
																<td class="view_item" align="left">
																	<bean:write name="seguro" property="segm_nomcia" scope="page" />
																	&nbsp;&nbsp;
																</td>
																<td class="view_desc" align="center">
																	<bean:write name="seguro" property="segm_polizaafi" scope="page" />
																	&nbsp;&nbsp;
																</td>
																<td class="view_desc" align="left">
																	<bean:write name="seguro" property="segm_contacto" scope="page" />
																	&nbsp;&nbsp;
																</td>
																<td class="view_desc" align="center">
																	<bean:write name="seguro" property="segm_indpais3" scope="page" />
																	&nbsp;&nbsp;
																</td>
																<td class="view_desc" align="center">
																	<bean:write name="seguro" property="segm_indciudad3" scope="page" />
																	&nbsp;&nbsp;
																</td>
																<td class="view_desc" align="center">
																	<bean:write name="seguro" property="segm_telefono3" scope="page" />
																	&nbsp;&nbsp;
																</td>
																<td align="center">
																	<IMG border="0" onClick="edit_seguro('<%=x%>')" src="<%=request.getContextPath()%>/images/editar.gif" alt="<bean:message key="138"/>"
																		width="16" height="16" style="cursor: hand">
																	<IMG border="0" onClick="remove_seguro('<%=x%>', '<bean:write name="seguro" property="segm_nomcia" scope="page" />')"
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
											<tr>
												<TD colspan="3">
													<table border="0" cellpadding="0" cellspacing="0" id="tab4" style="display: none" width="100%">
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<td class="view_item" colspan="7">
																<p align="justify">
																	<bean:message key="7208" />
																</p>
															</td>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD>
																<TABLE width="100%">
																	<tr>
																		<TD class="view_item">
																			<b><bean:message key="802" /> </b>
																		</td>
																		<td class="view_item">
																			<b><bean:message key="171" /> </b>
																		</td>
																		<td class="view_item" colspan="2" align="center">
																			<b><bean:message key="804" /> </b>
																		</TD>
																		<td class="view_item" align="center">
																			<b><bean:message key="803" /> </b>
																		</td>
																	</tr>
																	<tr>
																		<td class="view_item" colspan="2">
																			&nbsp;
																		</td>
																		<td class="view_item">
																			<b><bean:message key="3803" /> </b>
																		</td>
																		<td class="view_item">
																			<b><bean:message key="3804" /> </b>
																		</td>
																		<td>
																			&nbsp;
																		</td>
																	</tr>
																	<tr>
																		<TD class="view_item" align="center">
																			1&nbsp;
																		</td>
																		<td>
																			<html:hidden property="datp_med_fecha1" styleId="datp_med_fecha1" />
																			<SCRIPT language="JavaScript">obtenerCamposFecha('cDia2', 'cMes2', 'cAno2', 'datp_med_fecha1');</SCRIPT>
																		</td>
																		<td>
																			<html:text property="datp_med_est1" maxlength="6" size="6" styleClass="selNum" onkeyup="isFloat(this, 6, 3)" onblur="isFloat(this, 6, 3)"
																				onfocus="this.select()" />
																		</td>
																		<td>
																			<html:text property="datp_med_est1b" maxlength="6" size="6" styleClass="selNum" onkeyup="isFloat(this, 6, 3)" onblur="isFloat(this, 6, 3)"
																				onfocus="this.select()" />
																		</TD>
																		<td>
																			<html:text property="datp_med_peso1" maxlength="6" size="6" styleClass="selNum" onkeyup="isFloat(this, 6, 3)" onblur="isFloat(this, 6, 3)"
																				onfocus="this.select()" />
																		</TD>

																	</tr>
																	<tr>
																		<TD class="view_item" align="center">
																			2&nbsp;
																		</td>
																		<td>
																			<html:hidden property="datp_med_fecha2" styleId="datp_med_fecha2" />
																			<SCRIPT language="JavaScript">obtenerCamposFecha('cDia3', 'cMes3', 'cAno3', 'datp_med_fecha2');</SCRIPT>
																		</td>
																		<td>
																			<html:text property="datp_med_est2" maxlength="6" size="6" styleClass="selNum" onkeyup="isFloat(this, 6, 3)" onblur="isFloat(this, 6, 3)"
																				onfocus="this.select()" />
																		</td>
																		<td>
																			<html:text property="datp_med_est2b" maxlength="6" size="6" styleClass="selNum" onkeyup="isFloat(this, 6, 3)" onblur="isFloat(this, 6, 3)"
																				onfocus="this.select()" />
																		</TD>
																		<td>
																			<html:text property="datp_med_peso2" maxlength="6" size="6" styleClass="selNum" onkeyup="isFloat(this, 6, 3)" onblur="isFloat(this, 6, 3)"
																				onfocus="this.select()" />
																		</TD>
																	</tr>
																	<tr>
																		<TD class="view_item" align="center">
																			3&nbsp;
																		</td>
																		<td>
																			<html:hidden property="datp_med_fecha3" styleId="datp_med_fecha3" />
																			<SCRIPT language="JavaScript">obtenerCamposFecha('cDia4', 'cMes4', 'cAno4', 'datp_med_fecha3');</SCRIPT>
																		</td>
																		<td>
																			<html:text property="datp_med_est3" maxlength="6" size="6" styleClass="selNum" onkeyup="isFloat(this, 6, 3)" onblur="isFloat(this, 6, 3)"
																				onfocus="this.select()" />
																		</td>
																		<td>
																			<html:text property="datp_med_est3b" maxlength="6" size="6" styleClass="selNum" onkeyup="isFloat(this, 6, 3)" onblur="isFloat(this, 6, 3)"
																				onfocus="this.select()" />
																		</TD>
																		<td>
																			<html:text property="datp_med_peso3" maxlength="6" size="6" styleClass="selNum" onkeyup="isFloat(this, 6, 3)" onblur="isFloat(this, 6, 3)"
																				onfocus="this.select()" />
																		</TD>
																	</tr>
																</TABLE>
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<!-- <tr>
															<TD class="view_item">
																<bean:message key="806" />
																:&nbsp;
																
															</TD>
														</tr> -->
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="559" />
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="1005" />
																:&nbsp;
																<html:select property="datp_perro" styleClass="select">
																	<html:option value="1">
																		<bean:message key="560" />
																	</html:option>
																	<html:option value="0">
																		<bean:message key="561" />
																	</html:option>
																</html:select>
																&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																<bean:message key="1006" />
																:&nbsp;
																<html:select property="datp_gato" styleClass="select">
																	<html:option value="1">
																		<bean:message key="560" />
																	</html:option>
																	<html:option value="0">
																		<bean:message key="561" />
																	</html:option>
																</html:select>
																&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																<bean:message key="3801" />
																:&nbsp;
																<html:select property="datp_carro" styleClass="select">
																	<html:option value="1">
																		<bean:message key="560" />
																	</html:option>
																	<html:option value="0">
																		<bean:message key="561" />
																	</html:option>
																</html:select>
															</TD>
														</tr>
														<tr>
															<td>
																&nbsp;
															</td>
														</tr>
														<tr>
															<td>
																<table>
																	<tr>
																		<TD colspan="2" class="view_item">
																			<p align="justify">
																				<bean:message key="7280" />
																			</p>
																		</TD>
																	</tr>
																</table>
															</td>
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
														<tr>
															<TD colspan="2" class="view_item">
																<bean:message key="7263" />
															</TD>
														</tr>
														<tr align="center" valign="middle">
															<td>
																<INPUT type="button" onClick="enviarD('<%=request.getContextPath()%>/DatosPer/save.do')" class="sbttn"
																	value="<bean:message key="136"/>">
															</td>
														</tr>
														<tr>
															<td>

																<div align="right" class="imprimir">
																	<img alt="<bean:message key="global.imprimiralt"/>" src="<%=request.getContextPath()%>/images/print.gif" border="0" height="22"
																		width="20">
																	&nbsp;
																	<a href="javascript: self.print();"><b><bean:message key="global.imprimir" /> </b> </a>
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
	<script type="text/javascript">
// MAIN FUNCTION: new switchcontent("class name", "[optional_element_type_to_scan_for]") REQUIRED
// Call Instance.init() at the very end. REQUIRED

var bobexample=new switchcontent("switchgroup1", "div") //Limit scanning of switch contents to just "div" elements
bobexample.setStatus('<img src="<%=request.getContextPath()%>/images/opencq8.png" /> ', '<img src="<%=request.getContextPath()%>/images/closedy2.png" /> ')
bobexample.setColor('darkred', 'black')
bobexample.setPersist(true)
bobexample.collapsePrevious(true) //Only one content open at any given time
bobexample.init()
</script>


	<script>
calculaEdad(true);
tab_charge('datos_personales','family');
</script>
</html:form>