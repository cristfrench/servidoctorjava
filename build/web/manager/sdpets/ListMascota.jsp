<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="com.servidoctor.constantes.IConstantes"%>
<%@ page import="com.servidoctor.sdpets.model.GrupoUsuarioSegmentacion"%>
<%@ page import="com.servidoctor.sdpets.model.LogoComprador"%>
<%@ page import="com.servidoctor.sdpets.dao.GrupoUsuarioSegmentacionDAO"%>
<%@ page import="com.servidoctor.sdpets.dao.LogoCompradorDAO"%>
<%@ page import="com.servidoctor.seguridad.model.UsuarioPets"%>
<SCRIPT language="JavaScript">
function remove(cod,nom) {
	var r=confirm("¿<bean:message key="global.button.borrar"/> " + nom + "?");	
	if(r) {
		enviar('<%=request.getContextPath()%>/DatosMascota/remove.do?mas_cod='+cod);	
	}
}	

function verTamano(){  
   if(document.forms[0].tama.value>='<bean:message key="parametro_adicion_mascota"/>'){
      alert('<bean:message key="parametro_superado_mascota"/>');
      return false;
   }
   return true;
}

function ayudaGeneral(){
   window.open('<%=request.getContextPath()%>/Popup_ayuda.jsp?ayuda=a_general','contacto','scrollbars=yes, top=100, left=200, width=650, height=580')
}
</SCRIPT>

<html:form target="_self" action="/DatosMascota/add.do">
  <TABLE border="0" width="100%">
    <TR>
      <TD valign=top>
        <TABLE class="tablag" align="center" cellpadding="0" cellspacing="0" border="0" width="600px">
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

	                          <TD colspan="3">&nbsp;<%
		                           UsuarioPets usuarioPets = (UsuarioPets) request.getSession().getAttribute("usuarioPets");
		                             
		                             GrupoUsuarioSegmentacion grupoUsuarioSegmentacion = new GrupoUsuarioSegmentacion();
		                             GrupoUsuarioSegmentacionDAO grupoUsuarioSegmentacionDAO = new GrupoUsuarioSegmentacionDAO();
		                              GrupoUsuarioSegmentacion grupoUsuarioPets=null;
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
                        <TD class="tdOverNameOption" colspan="4" align="center">
                          <bean:message key="1504" />
                        </TD>
                      </TR>
                      <tr>
                      <td>&nbsp;
                      </td>
                      </tr>
                      <TR>
                        <TD class="view_item" colspan="4" >
                          <bean:message key="7300" />
                        </TD>
                      </TR>
                      <TR>
                        <TD class="tdNameOption" align="center" style="border: 1px solid #009F00">
                          <bean:message key="1003" />
                        </TD>
                        <TD class="tdNameOption" align="center" style="border: 1px solid #009F00">
                          <bean:message key="1004" />
                        </TD>
                        <TD class="tdNameOption" align="center" style="border: 1px solid #009F00">
                          <bean:message key="47" />
                        </TD>
                        <TD class="tdNameOption" align="center" style="border: 1px solid #009F00">
                          <bean:message key="global.acciones" />
                        </TD>
                      </TR>
                      <TR>
                        <%
                        	int x = 0;
                        %>
                        <logic:iterate indexId="ind" id="mascota" name="MASCOTAS" type="com.servidoctor.sdpets.model.Mascota">
                          <%
                          	if (x % 2 == 0) {
                          %>
                          <TR style="background: #ffffff">
                            <%
                            	}
                            %>
                            <%
                            	if (x % 2 != 0) {
                            %>
                          
                          <TR style="background: #f1f5fa">
                            <%
                            	}
                            %>
                            <TD class="view_item" align="center">
                              &nbsp;&nbsp;&nbsp;
                              <bean:write name="mascota" property="mas_nombre" scope="page" />
                            </TD>
                            <%
                            	if (mascota.getMas_tipo().equals("0")) {
                            %>
                            <TD class="view_desc" align="center">
                              <bean:message key="1005" />
                            </TD>
                            <%
                            	} else {
                            %>
                            <TD class="view_desc" align="center">
                              <bean:message key="1006" />
                            </TD>
                            <%
                            	}
                            %>
                            <%
                            	if (mascota.getMas_sexo().equals(IConstantes.SEXO_MASCULINO)) {
                            %>
                            <TD class="view_desc" align="center">
                              <bean:message key="1007" />
                            </TD>
                            <%
                            	} else {
                            %>
                            <TD class="view_desc" align="center">
                              <bean:message key="1008" />
                            </TD>
                            <%
                            	}
                            %>
                            <TD align="center">
                              <%
                              	java.util.HashMap map = new java.util.HashMap();
                              					map.put("mas_cod", String.valueOf(mascota.getMas_cod()));
                              					pageContext.setAttribute("map", map, PageContext.PAGE_SCOPE);
                              					x++;
                              %>
                              <html:link action="/DatosMascota/edit.do" name="map" scope="page">
                                <html:img border="0" page="/images/editar.gif" width="17" height="17" alt="Editar" title="Editar" />
                              </html:link>
                              &nbsp;&nbsp;
                              <IMG border="0" src="<%=request.getContextPath()%>/images/eliminar.gif" onclick="remove('<bean:write name="mascota" property="mas_cod" scope="page"/>','<bean:write name="mascota" property="mas_nombre" scope="page"/>')" width="17" height="17" style="cursor: 'hand';" alt="<bean:message key="global.button.borrar" />" title="Eliminar" />
                            </TD>
                          </TR>
                        </logic:iterate>
                      <TR>
                        <TD colspan="4">
                          <TABLE height="30" cellpadding="0" cellspacing="0" border="0" width="100%">
                            <TR>
                              <TD align="center">
                                <HR size="1" noshade="noshade" align="center" width="100%">
                                <input type="hidden" name="tama" value="<%=x%>" />
                              </TD>
                            </TR>
                            <tr>
                              <TD align="right" colspan="4"></TD>
                            </tr>
                            <TR align="center" valign="middle">
                              <TD>
                                <%
                                	if (x >= IConstantes.USER_MAX_PETS) {
                                %>
                                <html:submit styleClass="sbttn" disabled="true">
                                  <bean:message key="global.button.adicionar" />&nbsp;<bean:message key="3011" />
                                </html:submit>
                                <%
                                	} else {
                                %>
                                <html:submit styleClass="sbttn">
                                  <bean:message key="global.button.adicionar" />&nbsp;<bean:message key="3011" />
                                </html:submit>
                                <%
                                	}
                                %>
                              </TD>
                            </TR>
                            <TR>
                              <TD>
                                <DIV align="right" class="imprimir">
                                  <IMG alt="<bean:message key="global.imprimiralt"/>" src="<%=request.getContextPath()%>/images/print.gif" border="0" height="22" width="20">
                                  &nbsp;
                                  <A href="javascript: self.print();"><B><bean:message key="global.imprimir" />
                                  </B> </A>
                                </DIV>
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
</html:form>

