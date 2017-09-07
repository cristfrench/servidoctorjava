<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="com.servidoctor.sdfamily.model.GrupoUsuarioSegmentacion"%>
<%@ page import="com.servidoctor.sdfamily.model.LogoComprador"%>
<%@ page import="com.servidoctor.sdfamily.dao.GrupoUsuarioSegmentacionDAO"%>
<%@ page import="com.servidoctor.sdfamily.dao.LogoCompradorDAO"%>
<%@ page import="com.servidoctor.seguridad.model.UsuarioFamily"%>
<SCRIPT>
function view_popup(x,y,z)
{
	/*if(hay_popup_abierto())	
		return false;
	alert(x+y+z);*/
	eval("window.open('<%=request.getContextPath()%>/Carne/Popup/preview.do?linea1="+x+"&linea2="+y+"&linea3="+z+"','tabla','scrollbars=yes, top=100, left=200, width=680, height=440')");
}

</SCRIPT>
<html:form action="/Carne/generar.do" target="_self">
  <table border="0" width="100%">
    <tr>
      <td valign=top>
        <table class="tablag" align="center" cellpadding="0" cellspacing="0" border="0" width="600">
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
							</tr><tr>
                        <td class="tdOverNameOption" colspan="51" >
                          <b><bean:message key="6230" /></b>
                        </td>
                      </tr><tr>
                                <td colspan="4" class="view_item">
                                 <bean:message key="4008" arg0="<%=request.getContextPath()%>" />
                                </td>
                             </tr><tr>
                                <td colspan="4">
                                 &nbsp;
                                </td>
                             </tr>
                      
                      <tr>
                        <td colspan="4">
                          <table border="0" id="tab1" cellspacing="0" cellpadding="0" width="100%">
                            <tr>
                              <td>
                                <table border="0" cellpadding="0" cellspacing="0" width="100%">
                                  <tr><td colspan="3" class="view_item">
                                      <bean:message key="4007" arg0="<%=request.getContextPath()%>" />
                                    </td>
                                  </tr>
                                  <tr>
			                        <td class="tdNameOption" colspan="4">
			                          <table border="0" cellpadding="0" cellspacing="1">
			                            <tr>
			                              <TD id="tab11" class="sbttn tdNameOption" >
			                                </TD>
			                            </tr>
			                          </table>
			                        </td>
			                      </tr>
                                  <tr>
                                    <td colspan="3" class="view_item">
                                      <bean:message key="4006" arg0="<%=request.getContextPath()%>" />
                                    </td>
                                  </tr>
                                  <tr>
                                    <td colspan="3" class="view_item">
                                      <bean:message key="4005" arg0="<%=request.getContextPath()%>" />
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
                                      <bean:write name="usuarioFamilyForm" property="usuf_usuario" />
                                    </td>
                                    <td></td>
                                  </tr>
                                  <tr>
                                    <td class="view_item">
                                      <bean:message key="main.login.password" />
                                    </td>
                                    <td>
                                      <html:text name="usuarioFamilyForm" property="usuf_clave_emer" size="30" maxlength="30" disabled="true" />
                                    </td>
                                    <td>
                                      <input type="button" class="sbttn" value="<bean:message key="6236" />" onclick="enviar('<%=request.getContextPath()%>/Carne/generar.do')">
                                    </td>
                                  </tr>
                                  <tr>
                                    <td>
                                      &nbsp;
                                    </td>
                                  </tr>
                                  <tr>
                                    <td colspan="3">
                                      <strong><bean:message key="4014" arg0="<%=request.getContextPath()%>" /></strong><br/><br/><img src="<%=request.getContextPath()%>/manager/sdfamily/carne_<%=session.getAttribute("idioma")%>.jpg" border="0"><br>
                                    </td>
                                  </tr>
                                  <tr>                                  
                                    <td colspan="3">
                                      &nbsp;
                                    </td>
                                  </tr>
                                  <tr>                                  
                                    <td class="view_item" colspan="3">
                                      <bean:message key="4013" arg0="<%=request.getContextPath()%>" />
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
                                      <INPUT type="button"  class="sbttn" value="<bean:message key="4010"/>" onClick="view_popup(this.form.nuevo1.value,this.form.nuevo2.value,this.form.nuevo3.value);">
                                    </td>
                                  </tr>
                                </table>
                              </td>
                            </tr>
                          </table>
                        </td>
                      </tr>
                      <tr>
                        <td colspan="4">
                          <table height="30" cellpadding="0" cellspacing="0" border="0" width="100%">
                            <tr>
                              <td align="center">
                                <hr>
                              </td>
                            </tr>
                            <tr>
                              <td>
                                <div align="right" class="imprimir">
                                  <img alt="<bean:message key="global.imprimiralt"/>" src="<%=request.getContextPath()%>/images/print.gif" border="0" height="22" width="20">
                                  &nbsp;
                                  <a href="javascript: self.print();"><b><bean:message key="global.imprimir" /> </b> </a>
                                </div>
                              </td>
                            </tr>
                            <tr>
                              <td>
                                &nbsp;
                              </td>
                            </tr>
                            <tr>
                              <td>
                                &nbsp;
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
  <script>tab_charge('carne','family');</script>
</html:form>
