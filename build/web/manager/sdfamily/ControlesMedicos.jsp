<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="com.servidoctor.constantes.IConstantes"%>
<%@ page import="org.apache.struts.util.MessageResources"%>
<%@ page import="com.servidoctor.sdfamily.model.GrupoUsuarioSegmentacion"%>
<%@ page import="com.servidoctor.sdfamily.model.LogoComprador"%>
<%@ page import="com.servidoctor.sdfamily.dao.GrupoUsuarioSegmentacionDAO"%>
<%@ page import="com.servidoctor.sdfamily.dao.LogoCompradorDAO"%>
<%@ page import="com.servidoctor.seguridad.model.UsuarioFamily"%>
<%@ page import="java.util.List"%>

<%!MessageResources res = MessageResources.getMessageResources( "com.servidoctor.resources.ApplicationResources" );%>
<SCRIPT>
function enviarD(ruta)
{
	
	document.forms[0].action = ruta;
	document.forms[0].submit();
}

function add_tabla(tama)
{
	if(tama>=<bean:message key="parametro_adicion_examed"/>){
		alert('<bean:message key="parametro_superado_examed"/>');
		return false;
	}else{
		if(hay_popup_abierto())	
			return false;
		eval("window.open('<%=request.getContextPath()%>/Control_Medico/Popup/add_tabla.do','tabla','scrollbars=yes, top=100, left=200, width=680, height=440')")
		return true;
	}
}

function edit_tabla(x)
{
	if(hay_popup_abierto())	
		return false;
	eval("window.open('<%=request.getContextPath()%>/Control_Medico/Popup/edit_tabla.do?num_tabla="+x+"','tabla','scrollbars=yes, top=100, left=200, width=680, height=440')")
}

function remove_tabla(x, nom)
{
	var r=confirm('<bean:message key="6240"/>' + " " + nom + "?");
	if(r){
		enviar("<%=request.getContextPath()%>/Control_Medico/Popup/remove_tabla.do?num_tabla="+x);
	}
}

function edit_control_u(x)
{
	if(hay_popup_abierto())	
		return false;
	eval("window.open('<%=request.getContextPath()%>/Control_Medico/Popup/edit_controlU.do?num_controlu="+x+"','ControlU','scrollbars=yes, top=100, left=200, width=680, height=540')")
}

function edit_control_p(x)
{
	if(hay_popup_abierto())	
		return false;
	eval("window.open('<%=request.getContextPath()%>/Control_Medico/Popup/edit_controlP.do?num_controlp="+x+"','ControlP','scrollbars=yes, top=100, left=200, width=680, height=620')")}

function actualizar()
{
	enviar('<%=request.getContextPath()%>/Control_Medico/add.do');
}

</SCRIPT>

<html:form target="_self" action="/Control_Medico/add.do">
	<table border="0" width="100%">
		<tr>
			<td valign=top>
				<table class="tablag" align="center" cellpadding="0" cellspacing="0" border="0" width="620">
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
												<td class="tdOverNameOption" colspan="4">
													<bean:message key="2153" />
												</td>
											</tr>
											<tr>
												<td class="tdNameOption" colspan="4">
													<table border="0" cellpadding="0" cellspacing="1" width="100%">
														<tr>
															<TD id="tab11" class="sbttn tdNameOption" onClick="tab('1','control_medico','family')">
																<bean:message key="78" />
															</TD>
															<TD id="tab12" class="sbttn tdNameOption" onClick="tab('2','control_medico','family')">
																<bean:message key="79" />
															</TD>
															<TD id="tab13" class="sbttn tdNameOption" onClick="tab('3','control_medico','family')">
																<bean:message key="80" />
															</TD>																								
															
															<TD>&nbsp;															
															</TD>
														</tr>
													</table>
												</td>
											</tr>
											<tr>
												<td colspan="4">
													<table border="0" id="tab1" cellspacing="0" cellpadding="0" width=100%>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD colspan="3" class="view_item">
																<p align="justify">
																	<bean:message key="7236" />
																</p>
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="tdNameOption" style="border: 1px solid #D98200">
																<bean:message key="82" />
															</TD>
															<TD align="center" class="tdNameOption" style="border: 1px solid #D98200">
																<bean:message key="84" />
															</TD>
															<TD align="center" class="tdNameOption" style="border: 1px solid #D98200">
																<bean:message key="97" />
															</TD>
														</tr>
														<%
															int x = 0;
														%>
														<logic:iterate indexId="ind" id="examen" name="EXAMENES" type="com.servidoctor.parametros.model.Examenes">
															<tr>
																<td class="view_desc">
																	<bean:write name="examen" property="exa_des" scope="page" />
																</td>
																<td align="center" class="view_desc">
																	<bean:write name="examen" property="exa_edad" scope="page" />
																</td>
																<td align="center" class="view_desc">
																	<bean:write name="examen" property="exa_frecuencia" scope="page" />
																</td>
															</tr>
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
																	<bean:message key="7237" arg0='<%=res.getMessage( "parametro_adicion_examed" )%>' />
																</p>
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
															<TD align="center" class="tdNameOption" style="border: 1px solid #D98200">
																<bean:message key="global.numeral" />
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #D98200">
																<bean:message key="82" />
															</TD>
															<TD align="center" class="tdNameOption" style="border: 1px solid #D98200">
																<bean:message key="84" />
															</TD>
															<TD align="center" class="tdNameOption" style="border: 1px solid #D98200">
																<bean:message key="97" />
															</TD>
															<td class="tdNameOption" style="border: 1px solid #D98200" align="center">
																&nbsp;
																<bean:message key="137" />
																&nbsp;&nbsp;
															</td>
														</tr>
														<%
															x = 0;
														%>
														<logic:iterate indexId="ind" id="examen" name="EXAMENES_USUARIO" type="com.servidoctor.sdfamily.model.ExamenesUsuario">
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
																<TD class="view_item" align="center">
																	<%=x + 1%></TD>
																<td class="view_item">
																	<logic:notEqual name="examen" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="exau_exa_cod">
																		<%=request.getAttribute( "exa_des" + examen.getExau_exa_cod() )%>
																	</logic:notEqual>
																	<logic:equal name="examen" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="exau_exa_cod">
																		<bean:write name="examen" property="exau_des" scope="page" />
																	</logic:equal>
																</td>
																<td align="center" class="view_desc">
																	<bean:write name="examen" property="exau_edad" scope="page" />
																</td>
																<td align="center" class="view_desc">
																	<bean:write name="examen" property="exau_frecuencia" scope="page" />
																</td>
																<td align="center">
																	<IMG border="0" onClick="edit_tabla('<%=x%>')" src="<%=request.getContextPath()%>/images/editar.gif" alt="<bean:message key="138"/>"
																		width="16" height="16" style="cursor: hand">
																	<logic:notEqual name="examen" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="exau_exa_cod">
																		<IMG border="0" onClick="remove_tabla('<%=x%>','<%=request.getAttribute( "exa_des" + examen.getExau_exa_cod() )%>')"
																			src="<%=request.getContextPath()%>/images/eliminar.gif" alt="<bean:message key="139"/>" width="16" height="16" style="cursor: hand">
																	</logic:notEqual>
																	<logic:equal name="examen" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="exau_exa_cod">
																		<IMG border="0" onClick="remove_tabla('<%=x%>','<bean:write name="examen" property="exau_des" scope="page" />')"
																			src="<%=request.getContextPath()%>/images/eliminar.gif" alt="<bean:message key="139"/>" width="16" height="16" style="cursor: hand">
																	</logic:equal>
																</td>
															</tr>
															<%
																x++;
															%>
														</logic:iterate>
														<tr>
															<TD colspan="6" align="center">
																<INPUT type="button" onClick="add_tabla(<%=x%>)" class="sbttn" value="<bean:message key="controlmedico.button"/>">
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
												<TD colspan="4">

													<table border="0" cellpadding="0" cellspacing="0" id="tab3" style="display: none" width="100%">
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD colspan="4" class="view_item">
																<p align="justify">
																	<bean:message key="7240" />
																</p>
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>

														<tr>
															<TD class="tdNameOption" style="border: 1px solid #D98200">
																<bean:message key="148" />
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #D98200" align="center">
																<bean:message key="171" />
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #D98200" align="center">
																<bean:message key="91" />
															</TD>
															<td class="tdNameOption" style="border: 1px solid #D98200" align="center">
																&nbsp;
																<bean:message key="137" />
																&nbsp;&nbsp;
															</td>
														</tr>
														<tr>
															<%
																x = 0;
																List tablaAjustada = (List) request.getSession().getAttribute("EXAMENES_USUARIO");			
																List controlesAnteriores = (List) request.getSession().getAttribute("CONTROLESANTERIORES");
																List controlesProximos = (List) request.getSession().getAttribute("CONTROLESPROXIMOS");																								
																request.getSession().setAttribute("CONTROLESANTERIORES", controlesAnteriores);
																request.getSession().setAttribute("CONTROLESPROXIMOS", controlesProximos);
															%>
															
															<logic:iterate indexId="ind" id="controlAnterior" name="CONTROLESANTERIORES" type="com.servidoctor.sdfamily.model.ControlMedico">
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
																	<td class="view_desc">
																		<logic:notEqual name="controlAnterior" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="cmed_exa_cod">
																			<%if (request.getAttribute("exa_des" + controlAnterior.getCmed_exa_cod())!=null){%>
																				<%=request.getAttribute("exa_des" + controlAnterior.getCmed_exa_cod())%>
																			<%}else{
																			 
																			 	
																			 %>
																				
																				
																				<bean:write name="controlAnterior" property="cmed_destratamiento" scope="page" />
																			<%}%>
																		</logic:notEqual>
																		<logic:equal name="controlAnterior" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="cmed_exa_cod">
																			<bean:write name="controlAnterior" property="cmed_destratamiento" scope="page" />
																		</logic:equal>
																	</td>
																	<td class="view_desc" align="center"><%=com.servidoctor.util.classes.ManejoFechas.FormateoFecha( controlAnterior.getCmed_feccontrol()
													.toString() )%></td>
																	<td class="view_desc" align="center">
																		<bean:write name="controlAnterior" property="cmed_nommedico" scope="page" />
																		&nbsp;
																		<bean:write name="controlAnterior" property="cmed_apemedico" scope="page" />
																	</td>
																	<td align="center">
																		<IMG border="0" onClick="edit_control_u('<%=x%>')" src="<%=request.getContextPath()%>/images/editar.gif"
																			alt="<bean:message key="138"/>" width="16" height="16" style="cursor: hand">
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
															<TD colspan="4">
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD colspan="4" class="view_item">
																<bean:message key="7256" />
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="tdNameOption" style="border: 1px solid #D98200">
																<bean:message key="148" />
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #D98200" align="center">
																<bean:message key="171" />
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #D98200" align="center">
																<bean:message key="91" />
															</TD>
															<td class="tdNameOption" style="border: 1px solid #D98200" align="center">
																&nbsp;
																<bean:message key="137" />
																&nbsp;&nbsp;
															</td>
														</tr>
														<%
															x = 0;
														%>
														<logic:iterate indexId="ind" id="controlProximo" name="CONTROLESPROXIMOS" type="com.servidoctor.sdfamily.model.ControlMedico">
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
																<td class="view_desc">
																	<logic:notEqual name="controlProximo" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="cmed_exa_cod">
																		<%=request.getAttribute( "exa_des" + controlProximo.getCmed_exa_cod() )%>
																	</logic:notEqual>
																	<logic:equal name="controlProximo" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="cmed_exa_cod">
																		<bean:write name="controlProximo" property="cmed_destratamiento" scope="page" />
																	</logic:equal>
																</td>
																<td class="view_desc" align="center"><%=com.servidoctor.util.classes.ManejoFechas
													.FormateoFecha( controlProximo.getCmed_feccontrol().toString() )%></td>
																<td class="view_desc" align="center">
																	<bean:write name="controlProximo" property="cmed_nommedico" scope="page" />
																	&nbsp;
																	<bean:write name="controlProximo" property="cmed_apemedico" scope="page" />
																</td>
																<td align="center">
																	<IMG border="0" onClick="edit_control_p('<%=x%>')" src="<%=request.getContextPath()%>/images/editar.gif"
																		alt="<bean:message key="138"/>" width="16" height="16" style="cursor: hand">
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
															<TD colspan="4">
																<table width="100%">
																	<tr>
																		<TD colspan="4" class="view_item">
																			<p align="justify">
																				<bean:message key="7257" />
																			</p>
																		</TD>
																	</tr>
																	<tr>
																		<TD>
																			&nbsp;
																		</TD>
																	</tr>
																	<tr>
																		<TD class="tdNameOption" style="border: 1px solid #D98200">
																			<bean:message key="6200" />
																		</TD>
																		<TD class="tdNameOption" style="border: 1px solid #D98200" align="center">
																			<bean:message key="6201" />
																		</TD>
																	</tr>
																	<%
																		x = 0;
																	%>
																	<%
																		int y = 0;
																	%>
																	<logic:iterate indexId="ind" id="grupo" name="GRUPOSMEDICINA" type="com.servidoctor.sdfamily.model.GruposUsuario">
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
																			<td class="view_desc"><%=request.getAttribute( "grupu_desc" + x )%></td>
																			<td class="view_desc" align="center">
																				<html:text name="grupo" property="grupu_dias_antes" size="3" maxlength="3" style="selNum" indexed="true" />
																			</td>
																		</tr>
																		<logic:iterate id="control" name="CONTROLESPROXIMOS" type="com.servidoctor.sdfamily.model.ControlMedico">
																			<%
																				if ( control.getCmed_grup_cod().equals( grupo.getGrupu_grup_cod() ) ) {
																			%>
																			<tr>
																				<td class="view_item">
																					&nbsp;&nbsp;&nbsp;- - -&nbsp;
																					<logic:notEqual name="control" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="cmed_exa_cod">
																						<%=request.getAttribute( "exa_des" + control.getCmed_exa_cod() )%>
																					</logic:notEqual>
																					<logic:equal name="control" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="cmed_exa_cod">
																						<bean:write name="control" property="cmed_destratamiento" scope="page" />
																					</logic:equal>
																				</td>
																				<td class="view_item">
																					<bean:message key="6219" />
																					<html:select indexed="true" name="control" property="cmed_grup_cod" onchange="actualizar()">
																						<html:options collection="GRUPOS" property="grup_cod" labelProperty="grup_desc"></html:options>
																					</html:select>
																				</td>
																			</tr>
																			<%
																				}
																			%>
																		</logic:iterate>
																		<%
																			x++;
																		%>
																	</logic:iterate>
																</table>
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
												<td colspan="4">
													<table height="30" cellpadding="0" cellspacing="0" border="0" width="100%">
														<tr>
															<td align="center">
																<hr>
															</td>
														</tr>
														<tr align="center" valign="middle">
															<td>
																<INPUT type="button" onClick="enviar('<%=request.getContextPath()%>/Control_Medico/save.do')" class="sbttn"
																	value="<bean:message key="136"/>">
															</td>
														</tr>
														<tr>
															<td>
																<div align="right" class="imprimir">
																	<img alt="<bean:message key="global.imprimiralt"/>" src="<%=request.getContextPath()%>/images/print.gif" border="0" height="22"
																		width="20">
																	&nbsp;
																	<a href="javascript: self.print();"><b><bean:message key="global.imprimir" />
																	</b>
																	</a>
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

	<script>
		tab_charge('control_medico','family');
	</script>
</html:form>




