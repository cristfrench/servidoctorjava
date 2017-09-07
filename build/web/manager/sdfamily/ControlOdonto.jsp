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
<%!MessageResources res = MessageResources.getMessageResources( "com.servidoctor.resources.ApplicationResources" );%>
<SCRIPT>
function enviarD(ruta)
{
	document.forms[0].action = ruta;
	document.forms[0].submit();
}
function add_tabla(tama)
{
	if(tama>=<bean:message key="parametro_adicion_odonto"/>){
		alert('<bean:message key="parametro_superado_odonto"/>');
		return false;
	}else{
		if(hay_popup_abierto())	
			return false;
		eval("window.open('<%=request.getContextPath()%>/Control_Odont/Popup/add_tabla.do','tabla','scrollbars=yes, top=100, left=200, width=650, height=550')")
		return true;
	}
}

function edit_tabla(x)
{
	if(hay_popup_abierto())	
		return false;
	eval("window.open('<%=request.getContextPath()%>/Control_Odont/Popup/edit_tabla.do?num_tabla="+x+"','tabla','scrollbars=yes, top=100, left=200, width=650, height=570')")
}

function remove_tabla(x, nom)
{
	var r=confirm('<bean:message key="6240"/>' + " " + nom + "?");
	if(r){
		enviar("<%=request.getContextPath()%>/Control_Odont/Popup/remove_tabla.do?num_tabla="+x);
	}
}

function edit_control_u(x)
{
	if(hay_popup_abierto())	
		return false;
	eval("window.open('<%=request.getContextPath()%>/Control_Odont/Popup/edit_controlU.do?num_controlu="+x+"','ControlU','scrollbars=yes, top=100, left=200, width=650, height=550')")
}

function edit_control_p(x)
{
	if(hay_popup_abierto())	
		return false;
	eval("window.open('<%=request.getContextPath()%>/Control_Odont/Popup/edit_controlP.do?num_controlp="+x+"','ControlP','scrollbars=yes, top=100, left=200, width=650, height=590')")
}

</SCRIPT>

<html:form target="_self" action="/Control_Odont/add.do">
	<table border="0" width="100%">
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
													<bean:message key="514" />
												</td>
											</tr>
											<tr>
												<td class="tdNameOption" colspan="3">
													<table border="0" cellpadding="0" cellspacing="1">
														<tr>
															<TD id="tab11" class="sbttn tdNameOption" onClick="tab('1','control_odontologico','family')">
																<bean:message key="99" />
															</TD>
															<TD id="tab12" class="sbttn tdNameOption" onClick="tab('2','control_odontologico','family')">
																<bean:message key="100" />
															</TD>
															<TD id="tab13" class="sbttn tdNameOption" onClick="tab('3','control_odontologico','family')">
																<bean:message key="101" />
															</TD>
														</tr>
													</table>
												</td>
											</tr>
											<tr>
												<td colspan="3">
													<table border="0" id="tab1" cellspacing="0" cellpadding="0">
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD colspan="6" class="view_item">
																<p align="justify">
																	<bean:message key="7229" />
																</p>
															</TD>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD rowspan="2" class="tdNameOption" style="border: 1px solid #D98200">
																<bean:message key="815" />
															</TD>
															<TD colspan="2" class="tdNameOption" style="border: 1px solid #D98200" align="center">
																<bean:message key="103" />
															</TD>
															<TD colspan="2" class="tdNameOption" style="border: 1px solid #D98200" align="center">
																<bean:message key="104" />
															</TD>
															<TD rowspan="2" class="tdNameOption" style="border: 1px solid #D98200" align="center">
																<bean:message key="105" />
															</TD>
														</tr>
														<tr>
															<TD class="tdNameOption" style="border: 1px solid #D98200" align="center">
																<bean:message key="106" />
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #D98200" align="center">
																<bean:message key="107" />
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #D98200" align="center">
																<bean:message key="106" />
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #D98200" align="center">
																<bean:message key="107" />
															</TD>
														</tr>
														<%
															int x = 0;
														%>
														<logic:iterate indexId="ind" id="odontologia" name="CONTROLES_ODON" type="com.servidoctor.parametros.model.Odontologia">
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
																	<bean:write name="odontologia" property="odo_destratamiento" scope="page" />
																</td>
																<td class="view_desc" align="center">
																	<%=odontologia.getOdo_edaddesdemes().toString().equals( "0" ) ? "-" : odontologia.getOdo_edaddesdemes()
									.toString()%>
																</td>
																<td class="view_desc" align="center">
																	<%=odontologia.getOdo_edaddesdeanio().toString().equals( "0" ) ? "-" : odontologia.getOdo_edaddesdeanio()
									.toString()%>
																</td>
																<td class="view_desc" align="center">
																	<%=odontologia.getOdo_edadhastames().toString().equals( "0" ) ? "-" : odontologia.getOdo_edadhastames()
									.toString()%>
																</td>
																<td class="view_desc" align="center">
																	<%=odontologia.getOdo_edadhastaanio().toString().equals( "0" ) ? "-" : odontologia.getOdo_edadhastaanio()
									.toString()%>
																</td>
																<td class="view_desc" align="center">
																	<bean:write name="odontologia" property="odo_frecuencia" scope="page" />
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
															<TD>
																&nbsp;
															</TD>
														</tr>
													</table>
												</td>
											</tr>
											<tr>
												<td  colspan="3">
													<table border="0" id="tab2" cellspacing="0" cellpadding="0" style="display: none" width="100%">
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD colspan="7" class="view_item">
																<bean:message key="7230" arg0='<%=res.getMessage( "parametro_adicion_odonto" )%>' />
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
															<TD rowspan="2" class="tdNameOption" style="border: 1px solid #D98200" align="CENTER">
																<bean:message key="global.numeral" />
															</TD>
															<TD rowspan="2" class="tdNameOption" style="border: 1px solid #D98200">
																<bean:message key="815" />
															</TD>
															<TD colspan="2" class="tdNameOption" style="border: 1px solid #D98200" align="center">
																<bean:message key="103" />
															</TD>
															<TD colspan="2" class="tdNameOption" style="border: 1px solid #D98200" align="center">
																<bean:message key="104" />
															</TD>
															<TD rowspan="2" class="tdNameOption" style="border: 1px solid #D98200" align="center">
																<bean:message key="105" />
															</TD>
															<td rowspan="2" class="tdNameOption" style="border: 1px solid #D98200" align="center">
																&nbsp;
																<bean:message key="137" />
																&nbsp;&nbsp;
															</td>
														</tr>
														<tr>
															<TD class="tdNameOption" style="border: 1px solid #D98200" align="center">
																<bean:message key="106" />
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #D98200" align="center">
																<bean:message key="107" />
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #D98200" align="center">
																<bean:message key="106" />
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #D98200" align="center">
																<bean:message key="107" />
															</TD>
														</tr>
														<%
															x = 0;
														%>
														<logic:iterate indexId="ind" id="odontologia" name="CONTROLES_ODON_T" type="com.servidoctor.sdfamily.model.OdontologiaUsuario">
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
																<td class="view_desc" align="center">
																	<%=x + 1%>
																</td>
																<td class="view_desc">
																	<logic:notEqual name="odontologia" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="odou_odo_cod">
																		<%=request.getAttribute( "odo_destratamiento" + odontologia.getOdou_odo_cod() )%>
																	</logic:notEqual>
																	<logic:equal name="odontologia" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="odou_odo_cod">
																		<bean:write name="odontologia" property="odou_destratamiento" scope="page" />
																	</logic:equal>
																</td>
																<td class="view_desc" align="center">
																	<%=odontologia.getOdou_edaddesdemes().toString().equals( "0" ) ? "-" : odontologia.getOdou_edaddesdemes()
									.toString()%>
																</td>
																<td class="view_desc" align="center">
																	<%=odontologia.getOdou_edaddesdeanio().toString().equals( "0" ) ? "-" : odontologia.getOdou_edaddesdeanio()
									.toString()%>
																</td>
																<td class="view_desc" align="center">
																	<%=odontologia.getOdou_edadhastames().toString().equals( "0" ) ? "-" : odontologia.getOdou_edadhastames()
									.toString()%>
																</td>
																<td class="view_desc" align="center">
																	<%=odontologia.getOdou_edadhastaanio().toString().equals( "0" ) ? "-" : odontologia.getOdou_edadhastaanio()
									.toString()%>
																</td>
																<td class="view_desc" align="center">
																	<bean:write name="odontologia" property="odou_frecuencia" scope="page" />
																</td>
																<td align="center">
																	<IMG border="0" onClick="edit_tabla('<%=x%>')" src="/ServiDoctor/images/editar.gif" alt="<bean:message key="138"/>" width="16"
																		height="16" style="cursor: hand">
																	<logic:notEqual name="odontologia" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="odou_odo_cod">
																		<IMG border="0" onClick="remove_tabla('<%=x%>','<%=request.getAttribute( "odou_destratamiento" + x )%>')"
																			src="<%=request.getContextPath()%>/images/eliminar.gif" alt="<bean:message key="138"/>" width="16" height="16" style="cursor: hand">
																	</logic:notEqual>
																	<logic:equal name="odontologia" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="odou_odo_cod">
																		<IMG border="0" onClick="remove_tabla('<%=x%>','<bean:write name="odontologia" property="odou_destratamiento" scope="page" />')"
																			src="<%=request.getContextPath()%>/images/eliminar.gif" alt="<bean:message key="138"/>" width="16" height="16" style="cursor: hand">
																	</logic:equal>
																</td>
															</tr>
															<%
																x++;
															%>
														</logic:iterate>
														<tr>
															<TD colspan="8" align="center">
																<INPUT type="button" onClick="add_tabla(<%=x%>)" class="sbttn" value="<bean:message key="controlodonto.button"/>">
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
												<TD  colspan="3" >
													<table border="0" cellpadding="0" cellspacing="0" id="tab3" style="display: none" width="100%">
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD colspan="8" class="view_item">
																<p align="justify">
																	<bean:message key="7233" />
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
																<bean:message key="116" />
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
															%>
															<logic:iterate indexId="ind" id="controlOdontologiaAnterior" name="CONTROLES_ODON_U"
																type="com.servidoctor.sdfamily.model.ControlOdontologia">
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
																	
																		
																		
																		<logic:notEqual name="controlOdontologiaAnterior" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="elementoTabla.odou_odo_cod">
																			<%=request.getAttribute( "odo_destratamiento" + controlOdontologiaAnterior.getCodo_odo_cod() )%>
																		</logic:notEqual>
																		<logic:equal name="controlOdontologiaAnterior" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="elementoTabla.odou_odo_cod">
																			<bean:write name="controlOdontologiaAnterior" property="elementoTabla.odou_destratamiento" scope="page" />
																		</logic:equal>
																	</td>
																	<td class="view_desc" align="center">
																		<%=com.servidoctor.util.classes.ManejoFechas.FormateoFecha( controlOdontologiaAnterior.getCodo_feccontrol()
											.toString() )%>
																	</td>
																	<td class="view_desc" align="center">
																		<bean:write name="controlOdontologiaAnterior" property="codo_nommedico" scope="page" />
																		&nbsp;
																		<bean:write name="controlOdontologiaAnterior" property="codo_apemedico" scope="page" />
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
															<TD colspan="4">
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD colspan="4" class="view_item">
																<bean:message key="7253" />
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
																<bean:message key="116" />
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
														<logic:iterate indexId="ind" id="controlOdontologiaProximo" name="CONTROLES_ODON_P"
															type="com.servidoctor.sdfamily.model.ControlOdontologia">
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
																	<logic:notEqual name="controlOdontologiaProximo" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="elementoTabla.odou_odo_cod">
																		<%=request.getAttribute( "odo_destratamiento" + controlOdontologiaProximo.getCodo_odo_cod() )%>
																	</logic:notEqual>
																	<logic:equal name="controlOdontologiaProximo" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="elementoTabla.odou_odo_cod">
																		<bean:write name="controlOdontologiaProximo" property="elementoTabla.odou_destratamiento" scope="page" />
																	</logic:equal>
																</td>
																<td class="view_desc" align="center">
																	<%=com.servidoctor.util.classes.ManejoFechas.FormateoFecha( controlOdontologiaProximo.getCodo_feccontrol()
											.toString() )%>
																</td>
																<td class="view_desc" align="center">
																	<bean:write name="controlOdontologiaProximo" property="codo_nommedico" scope="page" />
																	&nbsp;
																	<bean:write name="controlOdontologiaProximo" property="codo_apemedico" scope="page" />
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
															<TD colspan="4" class="view_item">
																<p align="justify">
																	<bean:message key="7254" />
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
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD colspan="4" class="view_item">
																<bean:message key="7255" />
															</TD>
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
														<tr align="center" valign="middle">
															<td>
																<INPUT type="button" onClick="enviarD('<%=request.getContextPath()%>/Control_Odont/save.do')" class="sbttn"
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
		tab_charge('control_odontologico','family');
	</script>
</html:form>