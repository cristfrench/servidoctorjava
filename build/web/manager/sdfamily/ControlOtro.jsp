<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="org.apache.struts.util.MessageResources"%>
<%@ page import="com.servidoctor.sdfamily.model.GrupoUsuarioSegmentacion"%>
<%@ page import="com.servidoctor.sdfamily.model.LogoComprador"%>
<%@ page import="com.servidoctor.sdfamily.dao.GrupoUsuarioSegmentacionDAO"%>
<%@ page import="com.servidoctor.sdfamily.dao.LogoCompradorDAO"%>
<%@ page import="com.servidoctor.seguridad.model.UsuarioFamily"%>
<%!MessageResources res = MessageResources.getMessageResources("com.servidoctor.resources.ApplicationResources");%>

<SCRIPT>
function enviarD(ruta){	
	document.forms[0].action = ruta;
	document.forms[0].submit();
}

function edit_control_periodico(x){
	if(hay_popup_abierto())	
		return false;
	eval("window.open('<%=request.getContextPath()%>/Control_Otro/Popup/edit_control.do?num_control="+x+"','Control','scrollbars=yes, top=100, left=200, width=700, height=550')")
}

function add_control_periodico(tama){
if(tama>=<bean:message key="parametro_adicion_controlotroperiodico"/>){
      alert('<bean:message key="parametro_superado_controlotroperiodico"/>');
      return false;
   }else{
   	if(hay_popup_abierto())	
		return false;
	eval("window.open('<%=request.getContextPath()%>/Control_Otro/Popup/add_control.do?','Control','scrollbars=yes, top=100, left=200, width=700, height=550')")
	return true;
	}
}

function remove_control_periodico(x, nom){
var r=confirm('<bean:message key="6240"/>' + " " + nom + "?");
	if(r){
		enviar("<%=request.getContextPath()%>/Control_Otro/Popup/remove_control.do?num_control="+x);
		}	
}
function edit_control_concita(x){
	if(hay_popup_abierto())	
		return false;
	eval("window.open('<%=request.getContextPath()%>/Control_Otro/Popup/edit_controlconcita.do?num_control="+x+"','Control','scrollbars=yes, top=100, left=200, width=700, height=550')")
}

function add_control_concita(tama){
if(tama>=<bean:message key="parametro_adicion_controlotroconcita"/>){
      alert('<bean:message key="parametro_superado_controlotroconcita"/>');
      return false;
   }else{
	if(hay_popup_abierto())	
		return false;
	eval("window.open('<%=request.getContextPath()%>/Control_Otro/Popup/add_controlconcita.do?','Control','scrollbars=yes, top=100, left=200, width=700, height=580')")
	return true;
	}
}

function remove_control_concita(x, nom){
var r=confirm('<bean:message key="6240"/>' + " " + nom + "?");
	if(r){
		enviar("<%=request.getContextPath()%>/Control_Otro/Popup/remove_controlconcita.do?num_control="+x);
	}	
}

</SCRIPT>
<html:form target="_self" action="/Control_Otro/view.do">
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
                          <bean:message key="3807" />
                        </td>
                      </tr>
                      <tr>
                        <TD colspan="4">
                          <table border="0" cellpadding="0" cellspacing="0" id="tab3" width="100%">
                            <tr>
                              <TD>
                                &nbsp;

                              </TD>
                            </tr>
                            <tr>
                              <TD colspan="6" class="view_item">
                                <bean:message key="4003" />
                              </TD>
                            </tr>
                            <tr>
                              <TD>
                                &nbsp;
                              </TD>
                            </tr>
                            <tr>
                              <TD colspan="6" class="view_item">
                                <bean:message key="4000" arg0='<%=res.getMessage("parametro_adicion_controlotroperiodico")%>' />
                              </TD>
                            </tr>
                            <tr>
                              <TD>
                                <table border="0" cellpadding="0" cellspacing="0" id="tab3" width="100%">
                                  <tr>
                                    <TD>
                                      &nbsp;

                                    </TD>
                                  </tr>

                                  <tr>
                                    <TD colspan="6" class="view_item">
                                      <bean:message key="4001" arg0="<%=res.getMessage("parametro_adicion_controlotroconcita")%>" />
                                    </TD>
                                  </tr>
                                </table>
                              </TD>
                            </tr>
                          </table>
                        </td>
                      </tr>
                    </table>
                    <!-- LA TABLA CON CITA -->
                    <table cellpadding="0" cellspacing="0" border="0" width="100%">
                      <tr>
                        <td align="center" class="tdOverNameOption" colspan="5">
                          <bean:message key="controlotroconcita.controlotroconcita" />
                        </td>
                      </tr>
                      <tr>
                        <TD>
                          <table border="0" cellpadding="0" cellspacing="0" id="tab4" width="100%">
                            <tr>
                              <TD class="tdNameOption" style="border: 1px solid #D98200" align="center">
                                <bean:message key="global.numeral" />
                              </TD>
                              <TD class="tdNameOption" style="border: 1px solid #D98200" align="center">
                                <bean:message key="controlotroconcita.actividad" />
                              </TD>
                              <TD class="tdNameOption" style="border: 1px solid #D98200" align="center">
                                <bean:message key="controlotroconcita.fechainicial" />
                              </TD>
                              <TD class="tdNameOption" style="border: 1px solid #D98200" align="center">
                                <bean:message key="controlotroconcita.hora" />
                              </TD>
                              <TD class="tdNameOption" style="border: 1px solid #D98200" align="center">
                                <bean:message key="controlotroconcita.nombredoctor" />
                              </TD>
                              <td class="tdNameOption" style="border: 1px solid #D98200" align="center">
                                <bean:message key="controlotroperiodico.acciones" />
                              </td>
                            </tr>
                            <tr>
                              <%
                              	int x = 0;
                              %>
                              <logic:iterate indexId="ind" id="controlOtroConcita" name="CONTROL_OTRO_CONCITA" type="com.servidoctor.sdfamily.model.ControlOtroConcita">
                                <%
                                	if (x % 2 == 0) {
                                %>
                                <tr style="background: #ffffff">
                                  <%
                                  	}
                                  %>
                                  <%
                                  	if (x % 2 != 0) {
                                  %>
                                
                                <tr style="background: #ffffff">
                                  <%
                                  	}
                                  %>
                                  <td class="view_item" align="center">
                                    <%=x + 1%>
                                  </td>
                                  <td class="view_item" align="center">
                                    <bean:write name="controlOtroConcita" property="cootc_actividad" scope="page" />
                                  </td>
                                  <td class="view_desc" align="center">
                                    <%=com.servidoctor.util.classes.ManejoFechas.FormateoFecha(controlOtroConcita.getCootc_fecha().toString())%>
                                  </td>
                                  <td class="view_desc" align="center">
                                    <%=com.servidoctor.util.classes.ManejoFechas.FormateoHoraAMPM(controlOtroConcita.getCootc_hora().toString()).substring(1)%>
                                  </td>
                                  <td class="view_desc" align="center">
                                    <bean:write name="controlOtroConcita" property="cootc_docnom" scope="page" />
                                  </td>
                                  <td align="center">
                                    <IMG border="0" onClick="edit_control_concita('<%=x%>')" src="<%=request.getContextPath()%>/images/editar.gif" alt="<bean:message key="138"/>" width="16" height="16" style="cursor: hand">
                                    <IMG border="0" onClick="remove_control_concita('<%=x%>','<bean:write name="controlOtroConcita" property="cootc_actividad" scope="page" />')" src="<%=request.getContextPath()%>/images/eliminar.gif" alt="<bean:message key="138"/>" width="16" height="16" style="cursor: hand">
                                  </td>
                                </tr>
                                <%
                                	x++;
                                %>
                              </logic:iterate>
                            </tr>
                            <tr>
                              <TD class="tdNameOption" style="border: 1px solid #D98200" align="center">
                                <bean:message key="global.numeral" />
                              </TD>
                              <td class="tdNameOption" style="border: 1px solid #D98200" align="center">
                                <bean:message key="controlotroperiodico.entidad" />
                              </td>
                              <td colspan="2" class="tdNameOption" style="border: 1px solid #D98200" align="center">
                                <bean:message key="controlotroperiodico.direccion" />
                              </td>
                              <td colspan="2" class="tdNameOption" style="border: 1px solid #D98200" align="center">
                                <bean:message key="controlotroperiodico.telefono" />
                              </td>
                            </tr>
                            <tr>
                              <%
                              	x = 0;
                              %>
                              <logic:iterate indexId="ind" id="controlOtroConcita" name="CONTROL_OTRO_CONCITA" type="com.servidoctor.sdfamily.model.ControlOtroConcita">
                                <%
                                	if (x % 2 == 0) {
                                %>
                                <tr style="background: #ffffff">
                                  <%
                                  	}
                                  %>
                                  <%
                                  	if (x % 2 != 0) {
                                  %>
                                
                                <tr style="background: #ffffff">
                                  <%
                                  	}
                                  %>
                                  <td class="view_item" align="center">
                                    <%=x + 1%>
                                  </td>
                                  <td class="view_desc" align="center">
                                    <bean:write name="controlOtroConcita" property="cootc_entidad" scope="page" />
                                  </td>
                                  <td colspan="2" class="view_desc" align="center">
                                    <bean:write name="controlOtroConcita" property="cootc_direccion" scope="page" />
                                  </td>
                                  <td colspan="2" class="view_desc" align="center">
                                    <bean:write name="controlOtroConcita" property="cootc_telefo" scope="page" />
                                  </td>
                                </tr>
                                <%
                                	x++;
                                %>
                              </logic:iterate>
                            <tr>
                              <TD colspan="8" align="center">
                                <INPUT type="button" onClick="add_control_concita(<%=x%>)" class="sbttn" value="<bean:message key="controlotroconcita.button"/>">
                              </TD>
                            </tr>
                            <tr>
                              <TD colspan="5" align="center">
                                <!--  INPUT type="button" onClick="add_control_u()" class="sbttn" value="Adicionar Control No Regular, No periodico"-->
                              </TD>
                            </tr>
                            <tr>
                              <TD>
                                &nbsp;

                              </TD>
                            </tr>
                            <tr>
                              <TD colspan="6" class="view_item">
                                <bean:message key="4002" />
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
                                <INPUT type="button" onClick="enviarD('<%=request.getContextPath()%>/Control_Otro/save.do')" class="sbttn" value="<bean:message key="136"/>">
                              </td>
                            </tr>
                            <tr>
                              <td>
                                <div align="right" class="imprimir">
                                  <img alt="<bean:message key="global.imprimiralt"/>" src="/ServiDoctor/images/print.gif" border="0" height="22" width="20">
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
</html:form>

