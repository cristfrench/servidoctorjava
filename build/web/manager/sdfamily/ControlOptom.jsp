<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="org.apache.struts.util.MessageResources"%>
<%@ page import="com.servidoctor.sdfamily.model.GrupoUsuarioSegmentacion"%>
<%@ page import="com.servidoctor.sdfamily.model.LogoComprador"%>
<%@ page import="com.servidoctor.sdfamily.dao.GrupoUsuarioSegmentacionDAO"%>
<%@ page import="com.servidoctor.sdfamily.dao.LogoCompradorDAO"%>
<%@ page import="com.servidoctor.seguridad.model.UsuarioFamily"%>

<%!MessageResources res = MessageResources.getMessageResources( "com.servidoctor.resources.ApplicationResources" );%>
<SCRIPT>

function enviarD(ruta)
{
	var s=getCookie("control_optometra");
	if (s==3){
		convertirACampo('cDia1', 'cMes1', 'cAno1', 'copt_feccontrol1');
		convertirACampo('cDia2', 'cMes2', 'cAno2', 'copt_feccontrol2'); 
		fechaAnterior=document.forms[0].copt_feccontrol1.value;
		fechaProximo=document.forms[0].copt_feccontrol2.value;
		var fechaProximoS=parseInt(document.forms[0].copt_feccontrol2.value.substr(0,4)+''+document.forms[0].copt_feccontrol2.value.substr(4,2)+''+document.forms[0].copt_feccontrol2.value.substr(6,2));
		var fechaAnteriorS=parseInt(document.forms[0].copt_feccontrol1.value.substr(0,4)+''+document.forms[0].copt_feccontrol1.value.substr(4,2)+''+document.forms[0].copt_feccontrol1.value.substr(6,2));
		var fechaHoy=new Date;
		var mes=fechaHoy.getMonth()+1;
		var dia=fechaHoy.getDate();
		if (mes<10) mes='0'+mes;
		if (dia<10) dia='0'+dia;
		var fechaHoyS=parseInt(fechaHoy.getFullYear()+''+mes+''+dia);

		
		
		if (fechaProximo>=0){
			if (fechaProximo!=0){
				if (fechaHoyS>fechaProximoS){
					alert("Debe ingresar una fecha posterior a la fecha actual");
				}else{
					convertirACampoHora('hora2','minuto2','ampm2','copt_horacontrol2');
					document.forms[0].action = ruta;
					document.forms[0].submit();
				}
			}else{
				convertirACampoHora('hora2','minuto2','ampm2','copt_horacontrol2');
				document.forms[0].action = ruta;
				document.forms[0].submit();
			}
		}
		if (fechaAnterior>=0){
			if (fechaHoyS<fechaAnteriorS ){
				alert("Debe ingresar una fecha anterior a la fecha actual");
			}else{
				
				document.forms[0].action = ruta;
				document.forms[0].submit();
			}
		}		
		
	}else{
		document.forms[0].action = ruta;
		document.forms[0].submit();
	}

}

function add_tabla(tama)
{
	if(tama>=<bean:message key="parametro_adicion_opto"/>){
		alert('<bean:message key="parametro_superado_opto"/>');
		return false;
	}else{
		if(hay_popup_abierto())	
			return false;
		eval("window.open('<%=request.getContextPath()%>/Control_opto/Popup/add_tabla.do?','contacto','scrollbars=yes, top=100, left=200, width=640, height=480')")
		return true;
	}
}

function remove_tabla(x, nom)
{
	var r=confirm('<bean:message key="6240"/>' + " " + '<bean:message key="2112"/>' + " " + nom + "?");
	if(r){
		enviar("<%=request.getContextPath()%>/Control_opto/Popup/remove_tabla.do?num_tabla="+x);
	}
}

function edit_tabla(x)
{
	if(hay_popup_abierto())	
		return false;
	eval("window.open('<%=request.getContextPath()%>/Control_opto/Popup/edit_tabla.do?num_tabla="+x+"','control','scrollbars=yes, top=100, left=200, width=640, height=400')")
}

</SCRIPT>

<html:form target="_self" action="/Control_opto/view.do">
	<html:hidden property="copt_cod1" />
	<html:hidden property="copt_cod2" />
	<html:hidden property="copt_mails_enviados" />
	<html:hidden property="copt_ultimo_mail" />
	<input type="hidden" id="id_doc_si_no" value="<%=request.getAttribute( "id_doc_si_no" )%>">
	<table border="0" width="100%">
		<tr>
			<td valign=top>
				
				<table class="tablag" align="center" cellpadding="0" cellspacing="0" border="0" width="700">
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
													<bean:message key="515" />
												</td>
											</tr>
											<tr>
												<td class="tdNameOption" colspan="3">
													<table border="0" cellpadding="0" cellspacing="1">
														<tr>
															<TD id="tab11" class="sbttn tdNameOption" onClick="tab('1','control_optometra','family')">
																<bean:message key="118" />
															</TD>
															<TD id="tab12" class="sbttn tdNameOption" onClick="tab('2','control_optometra','family')">
																<bean:message key="119" />
															</TD>
															<TD id="tab13" class="sbttn tdNameOption" onClick="tab('3','control_optometra','family')">
																<bean:message key="120" />
															</TD>
														</tr>
													</table>
												</td>
											</tr>
											<tr>
												<td colspan="4">
													<table border="0" id="tab1" cellspacing="0" cellpadding="0">
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD colspan="12" class="view_item">
																<bean:message key="7260" />
															</TD>
														</tr>
														<tr>
															<TD colspan="4" class="view_item">
																<bean:message key="7224" />
															</TD>
														</tr>
														<tr>
															<td width="5%" align="center" rowspan="2" class="tdNameOption" style="border: 1px solid #D98200">
																<bean:message key="global.numeral" />
															</td>
															<TD width="65%" align="center" colspan="2" class="tdNameOption" style="border: 1px solid #D98200">
																<bean:message key="122" />
															</TD>
															<TD width="30%" align="center" rowspan="2" class="tdNameOption" style="border: 1px solid #D98200">
																<bean:message key="123" />
															</TD>
														</tr>
														<tr>
															<TD align="center" class="tdNameOption" style="border: 1px solid #D98200">
																<bean:message key="124" />
															</TD>
															<TD align="center" class="tdNameOption" style="border: 1px solid #D98200">
																<bean:message key="125" />
															</TD>
														</tr>
														<%
															int x = 0;
														%>
														<logic:iterate indexId="ind" id="optometria" name="CONTROLES_OPTO" type="com.servidoctor.parametros.model.Optometria">
															<%
																if ( x % 2 == 0 ) {
															%>
															<tr style="background: #ffffff">
																<%
																	}
																%>
																<%
																	if ( x % 2 != 0 ) {
																%>
															
															<tr style="background: #ffffff">
																<%
																	}
																%>
																<TD class="view_desc" align="center">
																	<%=x + 1%>
																</TD>
																<td align="center" class="view_item">
																	<bean:write name="optometria" property="opt_aniosdesde" scope="page" />
																</td>
																<td align="center" class="view_desc">
																	<bean:write name="optometria" property="opt_anioshasta" scope="page" />
																</td>
																<td align="center" class="view_desc">
																	<bean:write name="optometria" property="opt_frecuencia" scope="page" />
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
													</table>
												</td>
											</tr>
											<tr>
												<td colspan="4">
													<table border="0" id="tab2" cellspacing="0" cellpadding="0" style="display: none" width="100%">
														<tr>
															<TD>
																&nbsp;

															</TD>
														</tr>
														<tr>
															<TD colspan="6" class="view_item">
																<p align="justify">
																	<bean:message key="7225" />
																</p>
															</TD>
														</tr>
														<tr>
															<TD colspan="6" class="view_item">
																<bean:message key="7226" arg0='<%=res.getMessage( "parametro_adicion_opto" )%>' />
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<td class="view_item" colspan="6">
																<bean:message key="7202a" />
															</td>
														</tr>
														<tr>
															<td width="5%" align="center" rowspan="2" class="tdNameOption" style="border: 1px solid #D98200">
																<bean:message key="global.numeral" />
															</td>
															<TD width="50%" align="center" colspan="2" class="tdNameOption" style="border: 1px solid #D98200">
																<bean:message key="122" />
															</TD>
															<TD width="25%" align="center" rowspan="2" class="tdNameOption" style="border: 1px solid #D98200">
																<bean:message key="128" />
															</TD>
															<td width="20%" align="center" rowspan="2" class="tdNameOption" style="border: 1px solid #D98200">
																&nbsp;
																<bean:message key="137" />
																&nbsp;&nbsp;
															</td>
														</tr>
														<tr>
															<TD class="tdNameOption" style="border: 1px solid #D98200">
																<bean:message key="124" />
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #D98200">
																<bean:message key="125" />
															</TD>
														</tr>
														<%
															x = 0;
														%>
														<logic:iterate indexId="ind" id="usuarioopto" name="USUARIO_OPTO" type="com.servidoctor.parametros.model.Optometria">
															<tr>
																<TD class="view_desc" align="center">
																	<%=x + 1%>
																</TD>
																<td align="center" class="view_item">
																	<bean:write name="usuarioopto" property="opt_aniosdesde" scope="page" />
																</td>
																<td align="center" class="view_desc">
																	<bean:write name="usuarioopto" property="opt_anioshasta" scope="page" />
																</td>
																<td align="center" class="view_desc">
																	<bean:write name="usuarioopto" property="opt_frecuencia" scope="page" />
																</td>
																<td align="center">
																	<IMG border="0" onClick="edit_tabla('<%=x%>')" src="<%=request.getContextPath()%>/images/editar.gif" alt="<bean:message key="138"/>"
																		width="16" height="16" style="cursor: hand">
																	<IMG border="0" onClick="remove_tabla('<%=x%>','<%=x + 1%>')" src="<%=request.getContextPath()%>/images/eliminar.gif"
																		alt="<bean:message key="139"/>" width="16" height="16" style="cursor: hand">
																</td>
															</tr>
															<%
																x++;
															%>
														</logic:iterate>
														<tr>
															<TD>
																&nbsp;
																<input type="hidden" name="total_opto" value="<%=x%>">
															</TD>
														</tr>
														<tr>
															<TD colspan="5" align="center">
																<INPUT type="button" onClick="add_tabla(<%=x%>)" class="sbttn" value="<bean:message key="600"/>">
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
												<TD  colspan="4">
													<table border="0" cellpadding="0" cellspacing="0" id="tab3" style="display: none" width="100%">
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD colspan="4" class="view_item">
																<p align="justify">
																	<bean:message key="7228" />
																</p>
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;

															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="130" />
															</TD>
															<TD>
																<html:hidden property="copt_feccontrol1" styleId="copt_feccontrol1" />
																<script>obtenerCamposFecha('cDia1', 'cMes1', 'cAno1', 'copt_feccontrol1');</script>
															</TD>
														</tr>
														<tr style="display: none">
															<TD class="view_item">
																<bean:message key="1999" />
															</TD>
															<td class='view_item'>
																<html:hidden property="copt_horacontrol1" styleId="copt_horacontrol1" />
																<SCRIPT language="JavaScript">
											    					CamposHora('hora1','minuto1','ampm1','copt_horacontrol1');							    											    					
											    				</SCRIPT>
															</td>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="4" />
																&nbsp;
																<bean:message key="131" />
															</TD>
															<TD>
																<html:text styleClass="sel" property="copt_nommedico1" maxlength="30" size="50" />
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="5" />
																&nbsp;
																<bean:message key="131" />
															</TD>
															<TD>
																<html:text property="copt_apemedico1" maxlength="30" size="50" styleClass="sel" />
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="834" />
																:&nbsp;
															</TD>
															<TD>
																<html:text property="copt_direccion1" maxlength="80" size="50" styleClass="sel" />
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="835" />
																:&nbsp;
															</TD>
															<TD>
																<html:text property="copt_entidad1" maxlength="40" size="50" styleClass="sel" />
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="13" />
															</TD>
															<TD>
																<html:select property="copt_pais_cod1" styleClass="select" onchange="actualizarCiudades(this.value, 'ciudadesContent1')">
																	<html:options collection="PAISES" labelProperty="pais_des" property="pais_cod" />
																</html:select>
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="14" />
															</TD>
															<TD>
																<html:select property="copt_ciudad_cod1" styleClass="select" styleId="ciudadesContent1">
																	<html:options collection="CIUDADES1" labelProperty="ciu_des" property="ciu_cod" />
																</html:select>
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="31" />
															</TD>
															<TD>
																<html:text property="copt_indpais1" maxlength="3" size="3" styleClass="selNum" />
																&nbsp;
																<html:text property="copt_indciudad1" maxlength="3" size="3" styleClass="selNum" />
																&nbsp;
																<html:text property="copt_telefono1" maxlength="15" size="10" styleClass="selNum" />
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="19" />
															</TD>
															<TD>
																<html:text property="copt_email1" maxlength="30" size="40" styleClass="sel" />
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD colspan="4" class="view_item">
																<bean:message key="7251" />
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="130" />
															</TD>
															<TD>
																<html:hidden property="copt_feccontrol2" styleId="copt_feccontrol2" />
																<script>obtenerCamposFechaFuturo('cDia2', 'cMes2', 'cAno2', 'copt_feccontrol2',10);</script>
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="1999" />
															</TD>
															<td class='view_item'>
																<html:hidden property="copt_horacontrol2" styleId="copt_horacontrol2" />
																<SCRIPT language="JavaScript">
											    					CamposHora('hora2','minuto2','ampm2','copt_horacontrol2');							    											    					
											    				</SCRIPT>
															</td>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="4" />
																&nbsp;
																<bean:message key="131" />
															</TD>
															<TD>
																<html:text property="copt_nommedico2" maxlength="30" size="50" styleClass="sel" />
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="5" />
																&nbsp;
																<bean:message key="131" />
															</TD>
															<TD>
																<html:text property="copt_apemedico2" maxlength="30" size="50" styleClass="sel" />
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="834" />
																:&nbsp;
															</TD>
															<TD>
																<html:text property="copt_direccion2" maxlength="80" size="50" styleClass="sel" />
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="835" />
																:&nbsp;
															</TD>
															<TD>
																<html:text property="copt_entidad2" maxlength="40" size="50" styleClass="sel" />
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="13" />
															</TD>
															<TD>
																<html:select property="copt_pais_cod2" styleClass="select" onchange="actualizarCiudades(this.value, 'ciudadesContent2')">
																	<html:options collection="PAISES" labelProperty="pais_des" property="pais_cod" />
																</html:select>
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="14" />
															</TD>
															<TD>
																<html:select property="copt_ciudad_cod2" styleClass="select" styleId="ciudadesContent2">
																	<html:options collection="CIUDADES2" labelProperty="ciu_des" property="ciu_cod" />
																</html:select>
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="31" />
															</TD>
															<TD>
																<html:text property="copt_indpais2" maxlength="3" size="3" styleClass="selNum" />
																&nbsp;
																<html:text property="copt_indciudad2" maxlength="3" size="3" styleClass="selNum" />
																&nbsp;
																<html:text property="copt_telefono2" maxlength="15" size="10" styleClass="selNum" />
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="19" />
															</TD>
															<TD>
																<html:text property="copt_email2" maxlength="30" size="40" styleClass="sel" />
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD colspan="4" class="view_item">
																<p align="justify">
																	<bean:message key="7252" />
																</p>
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																&nbsp;
															</TD>
															<td>
																<html:text property="grupu_dias_antes" maxlength="2" size="3" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)" />
															</td>
														</tr>
													</table>
												</TD>
											</tr>
											<tr>
												<TD  colspan="3">
													&nbsp;
												</TD>
											</tr>
											<tr>
												<TD colspan="4" class="view_item">
													<bean:message key="7262" />
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
																<INPUT type="button" onClick="enviarD('<%=request.getContextPath()%>/Control_opto/save.do')" class="sbttn"
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
	<script>
	tab_charge('control_optometra','family');
	</script>
</html:form>

