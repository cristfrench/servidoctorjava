<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ page import="com.servidoctor.sdpets.model.GrupoUsuarioSegmentacion"%>
<%@ page import="com.servidoctor.sdpets.model.LogoComprador"%>
<%@ page import="com.servidoctor.sdpets.dao.GrupoUsuarioSegmentacionDAO"%>
<%@ page import="com.servidoctor.sdpets.dao.LogoCompradorDAO"%>
<%@ page import="com.servidoctor.seguridad.model.UsuarioPets"%>
<HTML>
<HEAD>
<SCRIPT language="JavaScript">
function enviar(ruta) {
	document.forms[0].action = ruta;
	document.forms[0].submit();	
}

</SCRIPT>
<LINK rel="stylesheet" href="<%=request.getContextPath()%>/style/estilo_pets.css" type="text/css">
</HEAD>
<BODY>

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
											<TD class="tdOverNameOption" colspan="4" align="center"><bean:message key="1504" /></TD>
											</TR>
<!-- 											
												<TR>
													<TD class="tdNameOption" colspan="4" align="center"><bean:message key="global.button.Adicionar" />&nbsp;<bean:message key="3090"/></TD>
												</TR>
													<TR>
														<TD colspan="2" class="view_item"><bean:message key="3013" /></TD>
													</TR>
	-->									<TR>
											<TD colspan="2" class="view_item"><bean:message key="7699" /></TD>	
										</TR>
										<TR>
											<TD colspan="2" class="view_item" align="justify">
											<bean:message key="7600" />
											<bean:message key="7601" />
											<bean:message key="7602" />
											<bean:message key="7602a" />
											<bean:message key="7602b" />
											<bean:message key="7603" />
											<bean:message key="7603d" />
											<bean:message key="7603a" />
											<bean:message key="7603b" />
											<bean:message key="7603c" />
										</tr>
										<tr>
										  	<td class="view_item">
											<TABLE border="2" cellpadding="2" cellspacing="2" width="100%">
											<TR>
												<TD colspan="5" class="view_item"><bean:message key="3013" /></TD>
											</TR>
											<TR>
													<TD colspan="5">										
													</TD>
											</TR>
												<tr>
													<td class= "view_new">  <bean:message key="8000"/></td>
													<td class= "view_new"><bean:message key="8005"/></td>
												</tr>
												<tr>
													<td class= "view_new"><bean:message key="8001"/></td>
													<td class= "view_new"><bean:message key="8006"/></td>
												</tr>
												<tr>
													<td class= "view_new"><bean:message key="8002"/></td>
													<td class= "view_new"><bean:message key="8007"/></td>
												</tr>
												<tr>
													<td class= "view_new"><bean:message key="8003"/></td>
													<td class= "view_new"><bean:message key="8008"/></td>
												</tr>
												<tr>
													<td class= "view_new"><bean:message key="8004"/></td>
													<td class= "view_new"><bean:message key="8009"/></td>
												</tr>
												<tr>
													<TD></TD>
												</TR>
											</TABLE>
												</TD>
													</TR>	
												<tr>				
													<TD colspan="2" class="view_item" align="justify">
													<bean:message key="7604" />
													<bean:message key="7604a" />
													<bean:message key="7604b" />
													<bean:message key="7604c" />
													<bean:message key="7604d" />
													<bean:message key="7604e" />
													<bean:message key="7604f" />
													<bean:message key="7605" />
													<bean:message key="7605a" />
													<bean:message key="7605b" />
												</tr>
												<tr>
													<td class="view_item" colspan="4">
													<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
														<TR>
															<TD colspan="5" class="view_item"><bean:message key="3013" /></TD>
														</TR>
														<TR>
															<TD colspan="5">										
															</TD>
														</TR>
														<tr>
															<td class= "view_new" colspan="6">
															<bean:message key="8010"/></td>
														</tr>
														<tr>
															<td class= "view_new"><bean:message key="8011"/></td>
															<td class= "view_new"><bean:message key="8012"/></td>
															<td class= "view_new"><bean:message key="8013"/></td>
															<td class= "view_new"><bean:message key="8014"/></td>
															<td class= "view_new"><bean:message key="8015"/></td>
															<td class= "view_new"><bean:message key="8016"/></td>
														</tr>
														<tr>
															<td colspan="6" class= "view_new"><bean:message key="8017"/></td>
														</tr>
														<tr>
															<td class= "view_new"><bean:message key="8018"/></td>
															<td class= "view_new"><bean:message key="8019"/></td>
															<td class= "view_new"><bean:message key="8020"/></td>
															<td class= "view_new"><bean:message key="8021"/></td>
															<td class= "view_new"><bean:message key="8022"/></td>
															<td class= "view_new"><bean:message key="8023"/></td>
														</tr>
														<tr>
															<td colspan="6" class= "view_new"><bean:message key="8024"/></td>
														</tr>
														<tr>
															<td><bean:message key="8074"/></td>
															<td class= "view_new"><bean:message key="8025"/></td>
															<td><bean:message key="8074"/></td>
															<td><bean:message key="8074"/></td>
															<td class= "view_new"><bean:message key="8026"/></td>
															<td class= "view_new"><bean:message key="8027"/></td>
														</tr>
														<tr>
															<td colspan="6" class= "view_new"><bean:message key="8028"/></td>
														</tr>
														<tr>
															<td><bean:message key="8074"/></td>
															<td><bean:message key="8074"/></td>
															<td><bean:message key="8074"/></td>
															<td class= "view_new"><bean:message key="8029"/></td>
															<td class= "view_new"><bean:message key="8030"/></td>
															<td class= "view_new"><bean:message key="8031"/></td>
														</tr>
														<tr>
															<td colspan="6" class= "view_new"><bean:message key="8032"/></td>
														</tr>
														<tr>
															<td colspan="4" class="view_new"><bean:message key="8033"/></td>
															<td class= "view_new"><bean:message key="8034"/></td>
															<td class= "view_new"><bean:message key="8035"/></td>
														</tr>
														<tr>
															<td colspan="6" class= "view_new"><bean:message key="8036"/></td>
														</tr>
														<tr>
															<td colspan="4" class= "view_new"><bean:message key="8037"/></td>
															<td class= "view_new"><bean:message key="8038"/></td>
															<td class= "view_new"><bean:message key="8039"/></td>
														</tr>
														<TR>
															<TD></TD>
														</TR>
											</TABLE>
													
													<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
													<TR>
													<TD colspan="5" class="view_item"><bean:message key="3013" /></TD>
													</TR>
													<TR>
													<TD colspan="5">										
													</TD>
													</TR>
													<tr>
															<td colspan="3" class= "view_new"><bean:message key="8040"/></td>
														</tr>
														<tr>
															<td class= "view_new"><bean:message key="8041"/></td>
															<td class= "view_new"><bean:message key="8045"/></td>
															<td class= "view_new"><bean:message key="8049"/></td>
															</tr>
															<TR>
															<td class= "view_new"><bean:message key="8042"/></td>
															<td class= "view_new"><bean:message key="8046"/></td>
															<td class= "view_new"><bean:message key="8050"/></td>
															<TR>
															<td class= "view_new"><bean:message key="8043"/></td>
															<td class= "view_new"><bean:message key="8047"/></td>
															<td class= "view_new"><bean:message key="8051"/></td>
															</tr>
															<TR>
															<td class= "view_new"><bean:message key="8044"/></td>
															<td class= "view_new"><bean:message key="8048"/></td>
															<td class= "view_new"><bean:message key="8052"/></td>
															</tr>
															<TR>
															<TD></TD>
															</TR>
															</TABLE>
													
													<bean:message key="7606" />
													<bean:message key="7606a" />
													
													<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
														<TR>
														<TD colspan="5" class="view_item"><bean:message key="3013" /></TD>
														</TR>
														<TR>
														<TD colspan="3">										
														</TD>
														</TR>
														<tr>
														<td class= "view_new"><bean:message key="8053"/></td>
														<td class= "view_new"><bean:message key="8057"/></td>
														</tr>
														<tr>
														<td class= "view_new"><bean:message key="8054"/></td>
														<td class= "view_new"><bean:message key="8058"/></td>
														</tr>
														<tr>
														<td class= "view_new"><bean:message key="8055"/></td>
														<td class= "view_new"><bean:message key="8059"/></td>
														</tr>
														<tr>
														<td class= "view_new"><bean:message key="8056"/></td>
														<td class= "view_new"><bean:message key="8060"/></td>
														</tr>
														<TR>
														<TD></TD>
														</TR>
														</TABLE>
													
													<bean:message key="7607a" />
													<bean:message key="7607b" />
													<bean:message key="7607c" />
													<bean:message key="7607d" />
													<bean:message key="7607e" />
													<bean:message key="7607f" />
													<bean:message key="7607g" />
													<bean:message key="7607h" />
													<bean:message key="7607i" />
													<bean:message key="7607j" />
													<bean:message key="7608" />
													<bean:message key="7608a" />
													<bean:message key="7608b" />
													<bean:message key="7609" />
													<bean:message key="7610" />
													<bean:message key="7611" />
													<bean:message key="7612" />
													<bean:message key="7613" />
													<bean:message key="7614" />
													<bean:message key="7615" />
													<bean:message key="7616" />
													<bean:message key="7617" />
													<bean:message key="7618" />
													<bean:message key="7619" />
													<bean:message key="7620" />
													<bean:message key="7621" />
													
												<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
														<TR>
														<TD colspan="5" class="view_item"><bean:message key="3013" /></TD>
														</TR>
														<TR>
														<TD colspan="5">										
														</TD>
														</TR>	
														<tr>
															<td colspan="3"class= "view_new"><bean:message key="8061"/></td>
														</TR>
														<TR>	
															<td class= "view_new"><bean:message key="8062"/></td>
															<td class= "view_new"><bean:message key="8067"/></td>
															<td class= "view_new"><bean:message key="8071"/></td>
														</tr>
														<tr>
															<td class= "view_new"><bean:message key="8063"/></td>
															<td class= "view_new"><bean:message key="8068"/></td>
															<td class= "view_new"><bean:message key="8072"/></td>
														</tr>
														<tr>
															<td class= "view_new"><bean:message key="8064"/></td>
															<td class= "view_new"><bean:message key="8069"/></td>
															<td class= "view_new"><bean:message key="8073"/></td>
														</tr>
														<tr>
															<td class= "view_new"><bean:message key="8065"/></td>
															<td class= "view_new"><bean:message key="8070"/></td>
															<td class= "view_new"><bean:message key="8072"/></td>
														</tr>
														<tr>
															<td></td>
														</tr>
														<tr>
															<td class= "view_new"><bean:message key="8066"/></td>
															<td colspan="2"class= "view_new"><bean:message key="8074"/></td>
														</tr>
														<tr>
															<td></td>
														</tr>
														<TR>
															<TD></TD>
														</TR>
													</TABLE>
													<bean:message key="7623" />
													<bean:message key="7624" />
													<bean:message key="7625" />
													<bean:message key="7626" />
													<bean:message key="7627" />
													<bean:message key="7628" />
													<bean:message key="7629" />
													<bean:message key="7630" />
													<bean:message key="7631" />
													<bean:message key="7632" />
													<bean:message key="7633" />
													<bean:message key="7634" />
													<bean:message key="7635" />
													<bean:message key="7636" />
													<bean:message key="7637" />
													<bean:message key="7638" />
													<bean:message key="7639" />
													<bean:message key="7640" />
													<bean:message key="7641" />
													<bean:message key="7642" />
													<bean:message key="7643" />
													<bean:message key="7644" />
													<bean:message key="7645" />
													<bean:message key="7646" />
													<bean:message key="7647" />
													<bean:message key="7648" />
													<bean:message key="7649" />
													<bean:message key="7650" />
													<bean:message key="7651" />
													<bean:message key="7652" />
													<bean:message key="7653" />
													<bean:message key="7654" />
													<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
													<TR>
														<TD colspan="5" class="view_item"><bean:message key="3013" /></TD>
													</TR>
													<TR>
														<TD colspan="5">										
														</TD>
													</TR>
													<tr>
														<td class= "view_new"><bean:message key="8075"/></td>
														<td class= "view_new"><bean:message key="8076"/></td>
														<td class= "view_new"><bean:message key="8077"/></td>
														<td class= "view_new"><bean:message key="8078"/></td>
													</tr>
													<tr>
														<td class= "view_new"><bean:message key="8079"/></td>
														<td class= "view_new"><bean:message key="8084"/></td>
														<td class= "view_new"><bean:message key="8088"/></td>
														<td class= "view_new"><bean:message key="8093"/></td>
													</tr>
													<tr>
														<td class= "view_new"><bean:message key="8080"/></td>
														<td class= "view_new"><bean:message key="8085"/></td>
														<td class= "view_new"><bean:message key="8089"/></td>
														<td class= "view_new"><bean:message key="8094"/></td>
													</tr>
													<tr>
														<td class= "view_new"><bean:message key="8081"/></td>
														<td class= "view_new"><bean:message key="8086"/></td>
														<td class= "view_new"><bean:message key="8090"/></td>
														<td class= "view_new"><bean:message key="8095"/></td>
													</tr>
													<tr>
														<td class= "view_new"><bean:message key="8082"/></td>
														<td class= "view_new"><bean:message key="8086"/></td>
														<td class= "view_new"><bean:message key="8091"/></td>
														<td class= "view_new"><bean:message key="8096"/></td>
													</tr>
													<tr>
														<td class= "view_new"><bean:message key="8083"/></td>
														<td class= "view_new"><bean:message key="8087"/></td>
														<td class= "view_new"><bean:message key="8092"/></td>
														<td class= "view_new"><bean:message key="8097"/></td>
													</tr>
													<TR>
														<TD></TD>
													</TR>
												</TABLE>
																		
																		
																	<bean:message key="7656" />
																	<bean:message key="7657" />
																<bean:message key="7658" />
															<bean:message key="7659" />
														<bean:message key="7660" />
													<bean:message key="7661" />
													<bean:message key="7662" />
													<bean:message key="7663" />
													<bean:message key="7664" />
													<bean:message key="7665" />
												</TD>
													<TR>
											<TD colspan="2" align="center"><HR></TD>
										</TR>
										<TR>
									<TD colspan="2"><DIV align="right" class="imprimir"><IMG alt="<bean:message key="global.imprimiralt"/>" src="<%=request.getContextPath()%>/images/print.gif" border="0" height="22" width="20">&nbsp;<A href="javascript: self.print();"><B><bean:message key="global.imprimir" /></B></A></DIV></TD>
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


/***********************************************
* Jump To Top Link Script- © Dynamic Drive (www.dynamicdrive.com)
* Last updated Nov 13th, 03'.
* This notice MUST stay intact for legal use
* Visit http://www.dynamicdrive.com/ for full source code
***********************************************/


</BODY>
</HTML>