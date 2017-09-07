
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page
	import="com.servidoctor.util.classes.ManejoFechas,com.servidoctor.sdfamily.model.DatosPersonales,com.servidoctor.constantes.IConstantes,org.apache.struts.util.MessageResources"%>

<%!MessageResources res = MessageResources.getMessageResources( "com.servidoctor.resources.ApplicationResources" );%>
<%@ page import="com.servidoctor.sdfamily.model.GrupoUsuarioSegmentacion"%>
<%@ page import="com.servidoctor.sdfamily.model.LogoComprador"%>
<%@ page import="com.servidoctor.sdfamily.dao.GrupoUsuarioSegmentacionDAO"%>
<%@ page import="com.servidoctor.sdfamily.dao.LogoCompradorDAO"%>
<%@ page import="com.servidoctor.seguridad.model.UsuarioFamily"%>
<script>
function enviarD(ruta){
      <%//if (((DatosPersonales) request.getSession().getAttribute("datosPersonales")).getDatp_sexo().equals(IConstantes.SEXO_FEMENINO)) {%>
	//	convertirACampo('cDia1', 'cMes1', 'cAno1', 'gine_fec_ult');
	//x = 0;
	//while(x < document.forms[0].xMax.value){
	//	eval("convertirACampo('cDia1"+x+"', 'cMes1"+x+"', 'cAno1"+x+"', 'gopeu_fecha"+x+"')");
	//	x++;
	//}
	<%//}%>
	
	document.forms[0].action = ruta;
	document.forms[0].submit();
}


function add_enf(tama)
{
if(tama>=<bean:message key="parametro_adicion_enfermedad"/>){
      alert('<bean:message key="parametro_superado_enfermedad"/>');
      return false;
   }else{
   	if(hay_popup_abierto())	
		return false;
	eval("window.open('<%=request.getContextPath()%>/Histo_Medica/Popup/add_enfermedad.do?','enfermedad','scrollbars=yes, top=100, left=200, width=700, height=630')")
	return true;
	}
}
function edit_enf(x)
{
	if(hay_popup_abierto())	
		return false;
	eval("window.open('<%=request.getContextPath()%>/Histo_Medica/Popup/edit_enfermedad.do?num_enf="+x+"','enfermedad','scrollbars=yes, top=100, left=200, width=700, height=500')")
}
function remove_enf(x, nom)
{
var r=confirm('<bean:message key="6240"/>' + " " + nom + "?");
if(r){
	enviar('<%=request.getContextPath()%>/Histo_Medica/Popup/remove_enfermedad.do?num_enf='+x);
}
}

function add_aler(tam)
{
	if(tam>=<bean:message key="parametro_adicion_alergia"/>){
      alert('<bean:message key="parametro_superado_alergia"/>');
      return false;
   }else{
   	if(hay_popup_abierto())	
		return false;
	eval("window.open('<%=request.getContextPath()%>/Histo_Medica/Popup/add_alergia.do?','alergia','scrollbars=yes, top=100, left=200, width=700, height=550')")
	return true;
	}
}
function edit_aler(x)
{
	if(hay_popup_abierto())	
		return false;
	eval("window.open('<%=request.getContextPath()%>/Histo_Medica/Popup/edit_alergia.do?num_aler="+x+"','alergia','scrollbars=yes, top=100, left=200, width=700, height=400')")
}
function remove_aler(x, nom)
{
var r=confirm('<bean:message key="6240"/>' + " " + nom + "?");
if(r){
	enviar('<%=request.getContextPath()%>/Histo_Medica/Popup/remove_alergia.do?num_aler='+x);
}
}

function add_cir(tama)
{
	if(tama>=<bean:message key="parametro_adicion_cirujia"/>){
      alert('<bean:message key="parametro_superado_cirujia"/>');
      return false;
   }else{
   	if(hay_popup_abierto())	
		return false;
	eval("window.open('<%=request.getContextPath()%>/Histo_Medica/Popup/add_cirujia.do?','cirujia','scrollbars=yes, top=100, left=200, width=700, height=540')")
	return true;
	}
}
function edit_cir(x)
{
	if(hay_popup_abierto())	
		return false;
	eval("window.open('<%=request.getContextPath()%>/Histo_Medica/Popup/edit_cirujia.do?num_cir="+x+"','cirujia','scrollbars=yes, top=100, left=200, width=700, height=450')")
}
function remove_cir(x, nom)
{
	var r=confirm('<bean:message key="6240"/>' + " " + nom + "?");
	if(r){
		enviar('<%=request.getContextPath()%>/Histo_Medica/Popup/remove_cirujia.do?num_cir='+x);
	}	
}

function add_medto(tama)
{
	if(tama>=<bean:message key="parametro_adicion_medicamento"/>){
      alert('<bean:message key="parametro_superado_medicamento"/>');
      return false;
   }else{
   	if(hay_popup_abierto())	
		return false;
	eval("window.open('<%=request.getContextPath()%>/Histo_Medica/Popup/add_medicamento.do?','medicamento','scrollbars=yes, top=100, left=200, width=700, height=530')")
	return true;
	}
}
function edit_medto(x)
{
	if(hay_popup_abierto())	
		return false;
	eval("window.open('<%=request.getContextPath()%>/Histo_Medica/Popup/edit_medicamento.do?num_medto="+x+"','medicamento','scrollbars=yes, top=100, left=200, width=700, height=530')")
}
function remove_medto(x, nom)
{
	var r=confirm('<bean:message key="6240"/>' + " " + nom + "?");
	if(r){
		enviar('<%=request.getContextPath()%>/Histo_Medica/Popup/remove_medicamento.do?num_medto='+x);
	}	
}

function add_ante(tama)
{
	if(tama>=<bean:message key="parametro_adicion_antecedente"/>){
      alert('<bean:message key="parametro_superado_antecedente"/>');
      return false;
   }else{
   	if(hay_popup_abierto())	
		return false;
	eval("window.open('<%=request.getContextPath()%>/Histo_Medica/Popup/add_antecedente.do?','antecedente','scrollbars=yes, top=100, left=200, width=700, height=300')")
	return true;
	}
}

function remove_ante(x)
{
	enviar('<%=request.getContextPath()%>/Histo_Medica/Popup/remove_antecedente.do?num_ante='+x);
}

function actualizar(){
	<%if (((DatosPersonales) request.getSession().getAttribute("datosPersonales")).getDatp_sexo().equals(IConstantes.SEXO_FEMENINO)) {%>
		convertirACampo('cDia1', 'cMes1', 'cAno1', 'gine_fec_ult');
	x = 0;
	while(x < document.forms[0].xMax.value){
		eval("convertirACampo('cDia1"+x+"', 'cMes1"+x+"', 'cAno1"+x+"', 'gopeu_fecha"+x+"')");
		x++;
	}
	<%}%>
	enviar('<%=request.getContextPath()%>/Histo_Medica/add.do');
}

</script>

<html:form target="_self" action="/Histo_Medica/add.do">
	<table border="0" width="100%">
		<html:hidden property="gine_cod" />
		<html:hidden property="gine_usuf_cod" />
		<tr>
			<td valign=top>
				<table class="tablag" align="center" cellpadding="0" cellspacing="0" border="0" width="620">
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
													<bean:message key="2070" />
												</td>
											</tr>
											<tr>
												<td class="tdNameOption" colspan="3">
													<table border="0" cellpadding="0" cellspacing="1">
														<tr>
															<TD id="tab11" class="sbttn tdNameOption" onClick="tab('1','histo_medica','family')">
																&nbsp;
																<bean:message key="819" />
																&nbsp;
															</TD>
															<TD id="tab12" class="sbttn tdNameOption" onClick="tab('2','histo_medica','family')">
																&nbsp;
																<bean:message key="48" />
																&nbsp;
															</TD>
															<TD id="tab13" class="sbttn tdNameOption" onClick="tab('3','histo_medica','family')">
																&nbsp;
																<bean:message key="49" />
																&nbsp;
															</TD>
															<TD id="tab14" class="sbttn tdNameOption" onClick="tab('4','histo_medica','family')">
																&nbsp;
																<bean:message key="50" />
																&nbsp;
															</TD>
															<TD id="tab15" class="sbttn tdNameOption" onClick="tab('5','histo_medica','family')">
																&nbsp;
																<bean:message key="183" />
																&nbsp;
															</TD>
															<%
																if ( ( ( DatosPersonales ) request.getSession().getAttribute( "datosPersonales" ) ).getDatp_sexo().equals( IConstantes.SEXO_FEMENINO ) ) {
															%>
															<TD id="tab16" class="sbttn tdNameOption" onClick="tab('6','histo_medica','family')">
																&nbsp;
																<bean:message key="823" />
																&nbsp;
															</TD>
															<%
																}
															%>
														</tr>
													</table>
												</td>
											</tr>
											<tr>
												<td colspan="3">
													<br />
													<table border="0" id="tab1" cellspacing="0" cellpadding="0" width="100%">
														<tr>
															<TD colspan="4" class="view_item">
																<bean:message key="7209" />
															</TD>
														</tr>
														<tr>
															<TD colspan="4" >
																&nbsp;
															</TD>
														</tr>
														<%
															int x = 0;
														%>
														<logic:iterate indexId="ind" id="elemento" name="ELEMENTOSCONSUMOUSUARIO" type="com.servidoctor.sdfamily.model.ElementoConsumoUsuario">
															<tr>
																<td class="view_item">
																	<logic:notEqual name="elemento" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="econu_econ_cod">
																		<%=request.getAttribute( "econ_des" + elemento.getEconu_econ_cod() )%>
																	</logic:notEqual>
																	<logic:equal name="elemento" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="econu_econ_cod">
																		<bean:write name="elemento" property="econu_des" scope="page" />
																	</logic:equal>
																</td>
																<td>
																	<html:select indexed="true" name="elemento" property="econu_cons_cod" styleClass="select">
																		<html:options collection="CONSUMOS" labelProperty="cons_des" property="cons_cod" />
																	</html:select>
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
												<td colspan="3">
													<table border="0" id="tab2" cellspacing="0" cellpadding="0" width="100%">
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
																<bean:message key="7210" />
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>

														<tr>
															<TD class="view_item">
																<bean:message key="7247" arg0='<%=res.getMessage("parametro_adicion_enfermedad")%>' />
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
																		<td class="tdNameOption" width="5%" style="border: 1px solid #D98200" align="center">
																			<bean:message key="global.numeral" />
																		</td>
																		<TD class="tdNameOption" width="30%" style="border: 1px solid #D98200">
																			<bean:message key="52" />
																		</TD>
																		<TD class="tdNameOption" width="30%" style="border: 1px solid #D98200">
																			<bean:message key="170" />
																		</TD>
																		<TD class="tdNameOption" width="20%" style="border: 1px solid #D98200" align="center">
																			<bean:message key="54" />
																		</TD>
																		<td width="15%" class="tdNameOption" style="border: 1px solid #D98200" align="center">
																			&nbsp;
																			<bean:message key="137" />
																			&nbsp;&nbsp;
																		</td>
																	</tr>
																	<%
																		x = 0;
																	%>
																	<logic:iterate indexId="ind" id="enfermedad" name="ENFERMEDADESUSUARIO" type="com.servidoctor.sdfamily.model.EnfermedadesUsuario">
																		<tr>
																			<TD class="view_desc" align="center"><%=x + 1%></TD>
																			<td class="view_item">
																				<logic:notEqual name="enfermedad" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="enfu_enf_cod">
																					<%=request.getAttribute( "enf_des" + enfermedad.getEnfu_enf_cod() )%>
																				</logic:notEqual>
																				<logic:equal name="enfermedad" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="enfu_enf_cod">
																					<bean:write name="enfermedad" property="enfu_des" scope="page" />
																				</logic:equal>
																			</td>
																			<td class="view_desc">
																				&nbsp;&nbsp;
																				<bean:write name="enfermedad" property="enfu_novedad" scope="page" />
																				&nbsp;&nbsp;
																			</td>
																			<td class="view_desc" align="center">
																				&nbsp;&nbsp;
																				<bean:write name="enfermedad" property="enfu_anio_desde" scope="page" />
																				&nbsp;&nbsp;
																			</td>
																			<td align="center">
																				<IMG border="0" onClick="edit_enf('<%=x%>')" src="<%=request.getContextPath()%>/images/editar.gif" alt="<bean:message key="138"/>"
																					width="16" height="16" style="cursor: hand">
																				<logic:notEqual name="enfermedad" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="enfu_enf_cod">
																					<IMG border="0" onClick="remove_enf('<%=x%>','<%=request.getAttribute( "enf_des" + enfermedad.getEnfu_enf_cod() )%>')"
																					src="<%=request.getContextPath()%>/images/eliminar.gif" alt="<bean:message key="139"/>" width="16" height="16"
																					style="cursor: hand">
																				</logic:notEqual>
																				<logic:equal name="enfermedad" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="enfu_enf_cod">
																					<IMG border="0" onClick="remove_enf('<%=x%>','<bean:write name="enfermedad" property="enfu_des" scope="page" />')"
																					src="<%=request.getContextPath()%>/images/eliminar.gif" alt="<bean:message key="139"/>" width="16" height="16"
																					style="cursor: hand">
																				</logic:equal>
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
																<bean:message key="7248" arg0='<%=res.getMessage( "parametro_adicion_alergia" )%>' />
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
																		<td class="tdNameOption" width="5%" style="border: 1px solid #D98200" align="center">
																			<bean:message key="global.numeral" />
																		</td>
																		<TD class="tdNameOption" width="30%" style="border: 1px solid #D98200">
																			<bean:message key="56" />
																		</TD>
																		<TD class="tdNameOption" width="30%" style="border: 1px solid #D98200">
																			<bean:message key="170" />
																		</TD>
																		<TD class="tdNameOption" width="20%" style="border: 1px solid #D98200" align="center">
																			<bean:message key="54" />
																		</TD>
																		<td class="tdNameOption" width="15%" style="border: 1px solid #D98200" align="center">
																			&nbsp;
																			<bean:message key="137" />
																			&nbsp;&nbsp;
																		</td>
																	</tr>
																	<%
																		x = 0;
																	%>
																	<logic:iterate indexId="indx" id="alergia" name="ALERGIASUSUARIO" type="com.servidoctor.sdfamily.model.AlergiasUsuario">
																		<tr>
																			<TD class="view_desc" align="center"><%=x + 1%></TD>
																			<td class="view_item">
																				<logic:notEqual name="alergia" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="aleu_ale_cod">
																					<%=request.getAttribute( "ale_des" + alergia.getAleu_ale_cod() )%>
																				</logic:notEqual>
																				<logic:equal name="alergia" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="aleu_ale_cod">
																					<bean:write name="alergia" property="aleu_des" scope="page" />
																				</logic:equal>
																			</td>
																			<td class="view_desc">
																				<bean:write name="alergia" property="aleu_novedad" scope="page" />
																			</td>
																			<td class="view_desc" align="center">
																				<bean:write name="alergia" property="aleu_anio_desde" scope="page" />
																			</td>
																			<td align="center">
																				<IMG border="0" onClick="edit_aler('<%=x%>')" src="<%=request.getContextPath()%>/images/editar.gif"
																					alt="<bean:message key="138"/>" width="16" height="16" style="cursor: hand">
																				<logic:notEqual name="alergia" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="aleu_ale_cod">
																					<IMG border="0" onClick="remove_aler('<%=x%>','<%=request.getAttribute( "ale_des" + alergia.getAleu_ale_cod() )%>')"
																						src="<%=request.getContextPath()%>/images/eliminar.gif" alt="<bean:message key="139"/>" width="16" height="16"
																						style="cursor: hand">
																				</logic:notEqual>
																				<logic:equal name="alergia" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="aleu_ale_cod">
																					<IMG border="0" onClick="remove_aler('<%=x%>','<bean:write name="alergia" property="aleu_des" scope="page" />')"
																						src="<%=request.getContextPath()%>/images/eliminar.gif" alt="<bean:message key="139"/>" width="16" height="16"
																						style="cursor: hand">
																				</logic:equal>
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
																<INPUT type="button" onClick="add_aler('<%=x%>')" class="sbttn" value="<bean:message key="historiamedica_alergia.button"/>">
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
																<bean:message key="7249" arg0="<%=res.getMessage( "parametro_adicion_cirujia" )%>" />
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
																		<td class="tdNameOption" width="5%" style="border: 1px solid #D98200" align="center">
																			<bean:message key="global.numeral" />
																		</td>
																		<TD class="tdNameOption" width="50%" style="border: 1px solid #D98200">
																			<bean:message key="61" />
																		</TD>
																		<TD class="tdNameOption" width="30%" style="border: 1px solid #D98200" align="center">
																			<bean:message key="62" />
																		</TD>
																		<td class="tdNameOption" width="15%" style="border: 1px solid #D98200" align="center">
																			&nbsp;
																			<bean:message key="137" />
																			&nbsp;&nbsp;
																		</td>
																	</tr>
																	<%
																		x = 0;
																	%>
																	<logic:iterate indexId="indx" id="cirujia" name="CIRUJIASUSUARIO" type="com.servidoctor.sdfamily.model.CirujiasUsuario">

																		<tr>
																			<TD class="view_desc" align="center"><%=x + 1%></TD>
																			<td class="view_item">
																				<logic:notEqual name="cirujia" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="ciru_cir_cod">
																					<%=request.getAttribute( "cir_des" + cirujia.getCiru_cir_cod() )%>
																				</logic:notEqual>
																				<logic:equal name="cirujia" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="ciru_cir_cod">
																					<bean:write name="cirujia" property="ciru_des" scope="page" />
																				</logic:equal>
																			</td>
																			<td class="view_desc" align="center">
																				<bean:write name="cirujia" property="ciru_anio" scope="page" />
																			</td>
																			<td colspan="2" align="center">
																				<IMG border="0" onClick="edit_cir('<%=x%>')" src="<%=request.getContextPath()%>/images/editar.gif" alt="<bean:message key="138"/>"
																					width="16" height="16" style="cursor: hand">
																				<logic:notEqual name="cirujia" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="ciru_cir_cod">
																					<IMG border="0" onClick="remove_cir('<%=x%>','<%=request.getAttribute( "cir_des" + cirujia.getCiru_cir_cod() )%>')"
																						src="<%=request.getContextPath()%>/images/eliminar.gif" alt="<bean:message key="139"/>" width="16" height="16"
																						style="cursor: hand">
																				</logic:notEqual>
																				<logic:equal name="cirujia" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="ciru_cir_cod">
																					<IMG border="0" onClick="remove_cir('<%=x%>','<bean:write name="cirujia" property="ciru_des" scope="page" />')"
																						src="<%=request.getContextPath()%>/images/eliminar.gif" alt="<bean:message key="139"/>" width="16" height="16"
																						style="cursor: hand">
																				</logic:equal>
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
																<INPUT type="button" onClick="add_cir('<%=x%>')" class="sbttn" value="<bean:message key="historiamedica_cirujia.button"/>">
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
												<td width="1786" colspan="3">
													<table border="0" id="tab3" cellspacing="0" cellpadding="0" style="display: none" width="100%">
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD colspan="9" class="view_item">
																<p align="justify">
																	<bean:message key="7217" />
																</p>
															</TD>
														</tr>
														<tr>
															<TD colspan="9" class="view_item">
																<p align="justify">
																	<bean:message key="7250" />
																</p>
															</TD>
														</tr>
														<tr>
															<TD colspan="9" class="view_item">
																<bean:message key="7217a" arg0='<%=res.getMessage( "parametro_adicion_medicamento")%>' />
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD colspan="9" class="view_item">
																<p align="center">
																	<b><bean:message key="67" />
																	</b>
																</p>
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<td class="view_item" colspan="9">
																<bean:message key="7202a" />
															</td>
														</tr>
														<tr>
															<td width="5%" valign="middle" class="tdNameOption" style="border: 1px solid #D98200" align="center">
																<bean:message key="global.numeral" />
															</td>
															<TD width="40%" valign="middle" class="tdNameOption" style="border: 1px solid #D98200">
																<bean:message key="4" />
															</TD>
															<TD width="30%" valign="middle" class="tdNameOption" style="border: 1px solid #D98200">
																U
															</TD>
															<TD width="30%" valign="top" class="tdNameOption" style="border: 1px solid #D98200" align="center">
																<bean:message key="72" />
															</TD>
															<td width="15%" valign="middle" class="tdNameOption" style="border: 1px solid #D98200">
																&nbsp;
																<bean:message key="137" />
																&nbsp;&nbsp;
															</td>
														</tr>

														<%
															x = 0;
														%>
														<logic:iterate indexId="ind" id="medicamento" name="MEDICAMENTOSUSUARIO" type="com.servidoctor.sdfamily.model.UsuarioMedicamentos">
															<tr>
																<TD class="view_desc" align="center"><%=x + 1%></TD>
																<td class="view_item">
																	<bean:write name="medicamento" property="mtom_des" scope="page" />
																</td>
																<td class="view_item">
																	<%
																		if ( medicamento.getMtom_form_cod().intValue() == 1 ) {
																	%>
																	P
																	<%
																		} else if ( medicamento.getMtom_form_cod().intValue() == 2 ) {
																	%>
																	2
																	<%
																		} else if ( medicamento.getMtom_form_cod().intValue() == 3 ) {
																	%>
																	A
																	<%
																		}
																	%>
																	&nbsp;&nbsp;
																</td>
																<td class="view_desc"><%=ManejoFechas.FormateoFecha( medicamento.getMtom_fecdesde().toString() )%></td>
																<td align="center">
																	<IMG border="0" onClick="edit_medto('<%=x%>')" src="<%=request.getContextPath()%>/images/editar.gif" alt="<bean:message key="138"/>"
																		width="16" height="16" style="cursor: hand">
																	<IMG border="0" onClick="remove_medto('<%=x%>','<bean:write name="medicamento" property="mtom_des" scope="page" />')"
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
															<TD colspan="9" align="center">
																<INPUT type="button" onClick="add_medto(<%=x%>)" class="sbttn" value="<bean:message key="historiamedica_medicamento.button"/>">
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD colspan="9" class="view_item">
																<bean:message key="7250a" />
															</TD>
														</tr>
														<tr>
															<TD colspan="8">
																&nbsp;
															</TD>
														</tr>
													</table>
												</td>
											</tr>
											<tr>
												<TD width="1786" colspan="3">
													<br />
													<table border="0" cellpadding="0" cellspacing="0" id="tab4" style="display: none" width="100%">
														<tr>
															<td class="view_item" colspan="6">
																<bean:message key="7220" arg0="<%=res.getMessage( "parametro_adicion_antecedente" )%>" />
															</td>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<td class="tdNameOption" style="border: 1px solid #D98200" align="center">
																<bean:message key="global.numeral" />
															</td>
															<TD class="tdNameOption" style="border: 1px solid #D98200">
																<bean:message key="809" />
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #D98200">
																<bean:message key="75" />
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #D98200">
																<bean:message key="76" />
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #D98200">
																<bean:message key="133" />
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #D98200">
																<bean:message key="77" />
															</TD>
														</tr>
														<%
															x = 0;
														%>
														<logic:iterate indexId="ind" id="antecedente" name="ANTECEDENTESUSUARIO" type="com.servidoctor.sdfamily.model.AntecedentesUsuario">

															<tr>
																<TD class="view_desc" align="center"><%=x + 1%></TD>
																<td class="view_item">
																	<logic:notEqual name="antecedente" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="anteu_ante_cod">
																		<%=request.getAttribute( "ante_des" + antecedente.getAnteu_ante_cod() )%>
																	</logic:notEqual>
																	<logic:equal name="antecedente" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="anteu_ante_cod">
																		<bean:write name="antecedente" property="anteu_des" scope="page" />
																	</logic:equal>
																</td>

																<logic:equal value="1" name="antecedente" property="anteu_abuelos">
																	<td class="view_desc">
																		&nbsp;&nbsp;
																		<INPUT type="checkbox" name="abuelo<%=x%>" checked="checked" />
																		&nbsp;&nbsp;
																	</td>
																</logic:equal>
																<logic:equal value="0" name="antecedente" property="anteu_abuelos">
																	<td class="view_desc">
																		&nbsp;&nbsp;
																		<INPUT type="checkbox" name="abuelo<%=x%>" />
																		&nbsp;&nbsp;
																	</td>
																</logic:equal>
																<logic:equal value="1" name="antecedente" property="anteu_padre">
																	<td class="view_desc">
																		&nbsp;&nbsp;
																		<INPUT type="checkbox" name="padre<%=x%>" checked="checked" />
																		&nbsp;&nbsp;
																	</td>
																</logic:equal>
																<logic:equal value="0" name="antecedente" property="anteu_padre">
																	<td class="view_desc">
																		&nbsp;&nbsp;
																		<INPUT type="checkbox" name="padre<%=x%>" />
																		&nbsp;&nbsp;
																	</td>
																</logic:equal>
																<logic:equal value="1" name="antecedente" property="anteu_madre">
																	<td class="view_desc">
																		&nbsp;&nbsp;
																		<INPUT type="checkbox" name="madre<%=x%>" checked="checked" />
																		&nbsp;&nbsp;
																	</td>
																</logic:equal>
																<logic:equal value="0" name="antecedente" property="anteu_madre">
																	<td class="view_desc">
																		&nbsp;&nbsp;
																		<INPUT type="checkbox" name="madre<%=x%>" />
																		&nbsp;&nbsp;
																	</td>
																</logic:equal>
																<logic:equal value="1" name="antecedente" property="anteu_hermanos">
																	<td class="view_desc">
																		&nbsp;&nbsp;
																		<INPUT type="checkbox" name="hermano<%=x%>" checked="checked" />
																		&nbsp;&nbsp;
																	</td>
																</logic:equal>
																<logic:equal value="0" name="antecedente" property="anteu_hermanos">
																	<td class="view_desc">
																		&nbsp;&nbsp;
																		<INPUT type="checkbox" name="hermano<%=x%>" />
																		&nbsp;&nbsp;
																	</td>
																</logic:equal>
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
															<TD colspan="9" align="center">
																<INPUT type="button" onClick="add_ante(<%=x%>)" class="sbttn" value="<bean:message key="historiamedica_antecedente.button"/>">
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
												<TD width="1786" colspan="3">
													<table border="0" cellpadding="0" cellspacing="0" id="tab5" style="display: none" width="100%">
														<tr>
															<TD colspan="2" class="view_item">
																<bean:message key="7222" />
															</TD>
														</tr>
														<tr>
															<TD colspan="2">
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<%
															x = 0;
														%>
														<logic:iterate indexId="ind" id="partes" name="PARTESCUERPOUSUARIO" type="com.servidoctor.sdfamily.model.PartesCuerpoUsuario">
															<tr>
																<td class="view_item">
																	<logic:notEqual name="partes" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="pcueu_pcue_cod">
																		<%=request.getAttribute( "pcue_des" + partes.getPcueu_pcue_cod() )%>
																	</logic:notEqual>
																	<logic:equal name="partes" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="pcueu_pcue_cod">
																		<bean:write name="partes" property="pcueu_des" scope="page" />
																	</logic:equal>
																</td>
																<td>
																	<html:text indexed="true" name="partes" property="pcueu_comentario" size="40" maxlength="80" styleClass="sel" />
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
												</TD>
											</tr>
											<tr>
												<td colspan="3">
													<%
														if ( ( ( DatosPersonales ) request.getSession().getAttribute( "datosPersonales" ) ).getDatp_sexo().equals( IConstantes.SEXO_FEMENINO ) ) {
													%>
													<table border="0" id="tab6" cellspacing="0" cellpadding="0" width="100%">
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD colspan="5" class="view_item" />
																<bean:message key="7223" />
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="824" />
																:&nbsp;
															</td>
															<td>
																<html:select property="gine_tipo_ovul" styleClass="select">
																	<html:option value="1">
																		<bean:message key="825" />
																	</html:option>
																	<html:option value="0">
																		<bean:message key="826" />
																	</html:option>
																</html:select>
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="827" />
																:&nbsp;
															</td>
															<td>
																<html:hidden property="gine_fec_ult" styleId="gine_fec_ult" />
																<script>obtenerCamposFecha('cDia1', 'cMes1', 'cAno1', 'gine_fec_ult');</script>
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD colspan="5" class="view_item">
																<bean:message key="828" />
																:
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<td colspan="5" class="view_item">
																<bean:message key="829" />
															</td>
														</tr>

														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																:&nbsp;
																<html:select property="gine_frecuencia" styleClass="select">
																	<html:option value="20" />
																	<html:option value="21" />
																	<html:option value="22" />
																	<html:option value="23" />
																	<html:option value="24" />
																	<html:option value="25" />
																	<html:option value="26" />
																	<html:option value="27" />
																	<html:option value="28" />
																	<html:option value="29" />
																	<html:option value="30" />
																	<html:option value="31" />
																	<html:option value="32" />
																	<html:option value="33" />
																	<html:option value="34" />
																	<html:option value="35" />
																	<html:option value="36" />
																</html:select>
																&nbsp;
																<bean:message key="831" />
															</TD>

															<TD class="view_item">
																<bean:message key="830" />
																:&nbsp;
																<html:select property="gine_periodo" styleClass="select">
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
																&nbsp;
																<bean:message key="831" />
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<td class="tdNameOption" style="border: 1px solid #D98200" align="center">
																&nbsp;&nbsp;Nº&nbsp;&nbsp;
															</td>
															<TD class="tdNameOption" style="border: 1px solid #D98200">
																<bean:message key="818" />
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #D98200">
																<bean:message key="832" />
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #D98200">
																<bean:message key="833" />
															</TD>
														</tr>


														<%
															x = 0;
														%>
														<logic:iterate indexId="ind" id="oper" name="GINECOLOGIAOPERACIONESUSUARIO" type="com.servidoctor.sdfamily.model.GinecologiaOperacionesUsuario">

															<tr>
																<TD class="view_desc" align="center"><%=x + 1%></TD>
																<td class="view_item">
																	<logic:notEqual name="oper" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="gopeu_gope_cod">
																		<%=request.getAttribute( "gope_des" + oper.getGopeu_gope_cod() )%>
																	</logic:notEqual>
																	<logic:equal name="oper" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="gopeu_gope_cod">
																		<bean:write name="oper" property="gopeu_des" scope="page" />
																	</logic:equal>
																</td>
																<td align="center">
																	<html:text indexed="true" name="oper" property="gopeu_cantidad" maxlength="4" size="4" styleClass="selNum" />
																</td>
																<td align="center">
																	<input type="hidden" name="gopeu_fecha<%=x%>" value="<%=ManejoFechas.FormateoFecha( oper.getGopeu_fecha().toString() )%>" />
																	<script>obtenerCamposFecha('cDia1<%=x%>', 'cMes1<%=x%>', 'cAno1<%=x%>', 'gopeu_fecha<%=x%>');</script>
																</TD>
															</tr>
															<%
																x++;
															%>
														</logic:iterate>
														<input type="hidden" name="xMax" value="<%=x%>" />
													</table>
													<%
														}
													%>
												</td>
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
																<INPUT type="button" onClick="enviarD('<%=request.getContextPath()%>/Histo_Medica/save.do')" class="sbttn"
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
tab_charge('histo_medica','family');
</script>

</html:form>