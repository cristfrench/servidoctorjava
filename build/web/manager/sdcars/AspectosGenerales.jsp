<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ page import="com.servidoctor.sdcars.model.GrupoUsuarioSegmentacion"%>
<%@ page import="com.servidoctor.sdcars.model.LogoComprador"%>
<%@ page import="com.servidoctor.sdcars.dao.GrupoUsuarioSegmentacionDAO"%>
<%@ page import="com.servidoctor.sdcars.dao.LogoCompradorDAO"%>
<%@ page import="com.servidoctor.seguridad.model.UsuarioCar"%>
<input type="hidden" name="recargar" value=""/>
	<TABLE border="0" width="100%">
		<TR>
			<TD valign=top>
			<TABLE class="tablag" align="center" cellpadding="0" cellspacing="1" border="0" width="600">
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
		                           UsuarioCar usuarioCar = (UsuarioCar) request.getSession().getAttribute("usuarioCar");
		                             
		                             GrupoUsuarioSegmentacion grupoUsuarioSegmentacion = new GrupoUsuarioSegmentacion();
		                             GrupoUsuarioSegmentacionDAO grupoUsuarioSegmentacionDAO = new GrupoUsuarioSegmentacionDAO();
		                             GrupoUsuarioSegmentacion grupoUsuarioCar=null;
		                             if (usuarioCar.getUsuc_especial().intValue()==1){
		                             	grupoUsuarioCar = grupoUsuarioSegmentacionDAO.retrive("C"+usuarioCar.getUsuc_cod().toString());  
		                             }else{
		                             	grupoUsuarioCar = grupoUsuarioSegmentacionDAO.retrieve("C"+usuarioCar.getUsuc_licencia());  
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
									LogoComprador datosPublicidadCompletos = logoCompradorDAO.retrieve(grupoUsuarioCar.getGrupo_id(),ifechaActual);
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
									<TD class="tdOverNameOption" colspan="2" align="center"><bean:message key="3806" />&nbsp;<bean:message key="7751" /></TD>
								</TR>
                                <TR>
                                  <TD class="tdNameOption" colspan="4" align="center"></TD>
                                </TR>	
								<TR>
									<TD colspan="2">&nbsp;</TD>
								</TR>	
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7785" /></TD>
								</TR>
								<TR>
									<TD colspan="2">&nbsp;</TD>
								</TR>							
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7752" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7753" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7757" /></TD>
								</TR>
								<TR>
									<TD colspan="2">&nbsp;</TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7758" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7759" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7760" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7761" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7765" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7766" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7766a" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7771" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7772" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7773" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7774" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7775" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7776" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7777" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7778" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7779" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7779a" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7767" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7768" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7769" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7780" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7781" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7782" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7783" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7784" /></TD>
								</TR>
								<TR>
									<TD colspan="2">&nbsp;</TD>
								</TR>
								<TR>
									<TD colspan="2" align="center"><HR></TD>
								</TR>
								<TR>
									<TD colspan="2"><DIV align="right" class="imprimir"><IMG alt="<bean:message key="global.imprimiralt"/>" src="/ServiDoctor/images/print.gif" border="0" height="22" width="20">&nbsp;<A href="javascript: self.print();"><B><bean:message key="global.imprimir" /></B></A></DIV></TD>
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
