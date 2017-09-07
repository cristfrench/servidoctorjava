<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ page import="com.servidoctor.sdpets.model.GrupoUsuarioSegmentacion"%>
<%@ page import="com.servidoctor.sdpets.model.LogoComprador"%>
<%@ page import="com.servidoctor.sdpets.dao.GrupoUsuarioSegmentacionDAO"%>
<%@ page import="com.servidoctor.sdpets.dao.LogoCompradorDAO"%>
<%@ page import="com.servidoctor.seguridad.model.UsuarioPets"%>
<input type="hidden" name="recargar" value=""/>
	<TABLE border="0" width="100%">
		<TR>
			<TD valign=top>
			<TABLE class="tablag" align="center" cellpadding="0" cellspacing="0" border="0" width="600">
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
									<TD class="tdOverNameOption" colspan="2" align="center""><bean:message key="3806" />&nbsp;<bean:message key="7800" /></TD>
								</TR>	
								<TR>
									<TD colspan="2">&nbsp;</TD>
								</TR>	
								<TR>
									<TD colspan="2" class="view_item"><bean:message key="7831" /></TD>
								</TR>
								<TR>
									<TD colspan="2">&nbsp;</TD>
								</TR>	
								<TR>
									<TD colspan="2" class="view_item""><bean:message key="7824" /></TD>
								</TR>
								
								<TR>
									<TD colspan="2" class="view_item""><bean:message key="7801" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item""><bean:message key="7804" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item""><bean:message key="7805" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item""><bean:message key="7806" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item""><bean:message key="7807" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item""><bean:message key="7830" /></TD>
								</TR>
								     <TR>
									<TD colspan="2" class="view_item""><bean:message key="7811" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item""><bean:message key="7812" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item""><bean:message key="7813" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item""><bean:message key="7814" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item""><bean:message key="7815" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item""><bean:message key="7816" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item""><bean:message key="7817" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item""><bean:message key="7818" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item""><bean:message key="7819" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item""><bean:message key="7820" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item""><bean:message key="7821" /></TD>
								</TR>
								<TR>
									<TD colspan="2" class="view_item""><bean:message key="7823" /></TD>
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
