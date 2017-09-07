<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
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
													<TD class="tdOverNameOption" colspan="4" align="center">
														<bean:message key="1504" />
													</TD>
												</TR>
												<tr>
													<TD colspan="4" class="view_item" align="justify">
														<bean:message key="7547" />
													</TD>
												</tr>
												<TR>
													<TD colspan="4" class="view_item" align="justify">
														<bean:message key="7500" />
														<bean:message key="7501" />
													</TD>
												</TR>
												<tr>
													<td class="view_item" colspan="4">
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="4" class="view_item">
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="4">
																</TD>
															</TR>
															<tr>
																<td class="view_new">
																	<bean:message key="9000" />
																</td>
																<td class="view_new">
																	<bean:message key="9002" />
																</td>
																<td class="view_new">
																	<bean:message key="9004" />
																</td>
																<td class="view_new">
																	<bean:message key="9006" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9001" />
																</td>
																<td class="view_new">
																	<bean:message key="9003" />
																</td>
																<td class="view_new">
																	<bean:message key="9005" />
																</td>
																<td class="view_new">
																	<bean:message key="9007" />
																</td>
															</TR>
														</TABLE>
													</td>
												</tr>
												<TR>
													<TD class="view_item" colspan="4">
														<bean:message key="7502" />
														<bean:message key="7503" />
														<bean:message key="7504" />
														<bean:message key="7505" />
														<bean:message key="7506" />
														<bean:message key="7507" />
														<bean:message key="7508" />
													</TD>
												</TR>
												<tr>
													<td class="view_item" colspan="4">
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="5" class="view_item">
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="5">
																</TD>
															</TR>
															<tr>
																<td class="view_new">
																	<bean:message key="9008" />
																</td>
																<td class="view_new">
																	<bean:message key="9010" />
																</td>
																<td class="view_new">
																	<bean:message key="9012" />
																</td>
																<td class="view_new">
																	<bean:message key="9014" />
																</td>
																<td class="view_new">
																	<bean:message key="9016" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9009" />
																</td>
																<td class="view_new">
																	<bean:message key="9011" />
																</td>
																<td class="view_new">
																	<bean:message key="9013" />
																</td>
																<td class="view_new">
																	<bean:message key="9015" />
																</td>
																<td class="view_new">
																	<bean:message key="9017" />
																</td>
															</TR>
														</TABLE>
													</td>
												</tr>
												<tr>
													<td class="view_item" colspan="4">
														<bean:message key="7509" />
														<bean:message key="7510" />
														<bean:message key="7511a" />
														<bean:message key="7512a" />
														<bean:message key="7513a" />
													</td>
												</tr>
												<tr>
													<td class="view_item"  colspan="4">
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="5" class="view_item">
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="5"></TD>
															</TR>
															<tr>
																<td class="view_new">
																	<bean:message key="9018" />
																</td>
																<td class="view_new">
																	<bean:message key="9020" />
																</td>
																<td class="view_new">
																	<bean:message key="9022" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9019" />
																</td>
																<td class="view_new">
																	<bean:message key="9021" />
																</td>
																<td class="view_new">
																	<bean:message key="9023" />
																</td>
															</TR>
															<TR>
																<TD></TD>
															</TR>
														</TABLE>
													</td>
												</tr>
												<tr>
													<td class="view_item"  colspan="4">
														<bean:message key="7511" />
														<bean:message key="7548" />
														
													</td>
												</tr>
												<tr>
													<td class="view_item"  colspan="4">
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="5" class="view_item">
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="5"></TD>
															</TR>
															<tr>
																<td class="view_new">
																	<bean:message key="9024" />
																</td>
																<td class="view_new">
																	<bean:message key="9026" />
																</td>
																<td class="view_new">
																	<bean:message key="9028" />
																</td>
															<tr>
																<td class="view_new">
																	<bean:message key="9025" />
																</td>
																<td class="view_new">
																	<bean:message key="9027" />
																</td>
																<td class="view_new">
																	<bean:message key="9029" />
																</td>
															</TR>
															<TR>
																<TD></TD>
															</TR>
														</TABLE>
													</td>
												</tr>
												<tr>
													<td class="view_item"  colspan="4">
														<bean:message key="7512" />
														<bean:message key="7513" />
														<bean:message key="7514" />
														<bean:message key="7515" />
														<bean:message key="7516" />
														<bean:message key="7517" />
													</td>
												</tr>
												<tr>
													<td class="view_item"  colspan="4">
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="5" class="view_item">
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="5"></TD>
															</TR>
															<tr>
																<td class="view_new" colspan="4">
																	<bean:message key="9030" />
																</td>
																<td class="view_new" colspan="4">
																	<bean:message key="9032" />
																</td>
																<td class="view_new" colspan="4">
																	<bean:message key="9034" />
																</td>
																<td class="view_new" colspan="4">
																	<bean:message key="9036" />
																</td>
															<tr>
																<td class="view_new">
																	<bean:message key="9031" />
																</td>
																<td class="view_new">
																	<bean:message key="9033" />
																</td>
																<td class="view_new">
																	<bean:message key="9035" />
																</td>
																<td class="view_new">
																	<bean:message key="9037" />
																</td>
															</TR>
															<TR>
																<TD></TD>
															</TR>
														</TABLE>
													</td>
												</tr>
												<tr>
													<td class="view_item" colspan="4">
														<bean:message key="7518" />
														<bean:message key="7519" />
														<bean:message key="7520" />
														<bean:message key="7521" />
														<bean:message key="7522" />
													</td>
												</tr>
												<tr>
													<td class="view_item" colspan="4">
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="5" class="view_item">
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="5"></TD>
															</TR>
															<tr>
																<td class="view_new">
																	<bean:message key="9039" />
																</td>
																<td class="view_new">
																	<bean:message key="9040" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9041" />
																</td>
																<td class="view_new">
																	<bean:message key="9042" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9043" />
																</td>
																<td class="view_new">
																	<bean:message key="9044" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9045" />
																</td>
																<td class="view_new">
																	<bean:message key="9046" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9047" />
																</td>
																<td class="view_new">
																	<bean:message key="9048" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9049" />
																</td>
																<td class="view_new">
																	<bean:message key="9050" />
																</td>
															</TR>
															<TR>
																<TD></TD>
															</TR>
														</TABLE>
												<br><br>
													<tr>
													<td class="view_item" colspan="4">
														<bean:message key="7906" />
													</td>
												</tr>
												<tr>
													<td colspan="4">
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="5" class="view_item">
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="5"></TD>
															</TR>
															<tr>
																<td class="view_new">
																	<bean:message key="9051" />
																</td>
																<td class="view_new">
																	<bean:message key="9052" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9053" />
																</td>
																<td class="view_new">
																	<bean:message key="9054" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9055" />
																</td>
																<td class="view_new">
																	<bean:message key="9056" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9057" />
																</td>
																<td class="view_new">
																	<bean:message key="9058" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9059" />
																</td>
																<td class="view_new">
																	<bean:message key="9060" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9061" />
																</td>
																<td class="view_new">
																	<bean:message key="9062" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9063" />
																</td>
																<td class="view_new">
																	<bean:message key="9064" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9065" />
																</td>
																<td class="view_new">
																	<bean:message key="9066" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9067" />
																</td>
																<td class="view_new">
																	<bean:message key="9068" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9069" />
																</td>
																<td class="view_new">
																	<bean:message key="9070" />
																</td>
															</TR>
															<TR>
																<TD></TD>
															</TR>
														</TABLE>
													</td>
												</tr>
												<tr>
													<td class="view_item" colspan="4">
														<bean:message key="7523" />
														<bean:message key="7524" />
														<bean:message key="7525" />
													</td>
												</tr>
												<tr>
													<td class="view_item" colspan="4">
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="5" class="view_item">
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="5"></TD>
															</TR>
															<tr>
																<td colspan="3" align="center" class="view_new">
																	<bean:message key="9071" />
																</td>
															</tr>
															<tr>
															<TR align="center">
																<td class="view_new">
																	<bean:message key="9072" />
																</td>
																<td class="view_new">
																	<bean:message key="9073" />
																</td>
																<td class="view_new">
																	<bean:message key="9074" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9075" />
																</td>
																<td class="view_new">
																	<bean:message key="9076" />
																</td>
																<td class="view_new">
																	<bean:message key="9077" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9078" />
																</td>
																<td class="view_new">
																	<bean:message key="9079" />
																</td>
																<td class="view_new">
																	<bean:message key="9080" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9081" />
																</td>
																<td class="view_new">
																	<bean:message key="9082" />
																</td>
																<td class="view_new">
																	<bean:message key="9083" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9084" />
																</td>
																<td class="view_new">
																	<bean:message key="9085" />
																</td>
																<td class="view_new">
																	<bean:message key="9086" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9087" />
																</td>
																<td class="view_new">
																	<bean:message key="9088" />
																</td>
																<td class="view_new">
																	<bean:message key="9089" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9603" />
																</td>
																<td class="view_new">
																	<bean:message key="9604" />
																</td>
																<td class="view_new">
																	<bean:message key="9605" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9606" />
																</td>
																<td class="view_new">
																	<bean:message key="9607" />
																</td>
																<td class="view_new">
																	<bean:message key="9608" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9090" />
																</td>
																<td class="view_new">
																	<bean:message key="9091" />
																</td>
																<td class="view_new">
																	<bean:message key="9092" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9093" />
																</td>
																<td class="view_new">
																	<bean:message key="9094" />
																</td>
																<td class="view_new">
																	<bean:message key="9095" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9096" />
																</td>
																<td class="view_new">
																	<bean:message key="9097" />
																</td>
																<td class="view_new">
																	<bean:message key="9098" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9099" />
																</td>
																<td class="view_new">
																	<bean:message key="9100" />
																</td>
																<td class="view_new">
																	<bean:message key="9101" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9102" />
																</td>
																<td class="view_new">
																	<bean:message key="9103" />
																</td>
																<td class="view_new">
																	<bean:message key="9104" />
																</td>
															</TR>
															<TR>
																<TD></TD>
															</TR>
														</TABLE>
													</td>
												</tr>
												<tr>
													<td class="view_item" colspan="4">
														<bean:message key="7526" />
													</td>
												</tr>
												<tr>
													<td class="view_item" colspan="4">
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="5" class="view_item">
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="5"></TD>
															</TR>
															<Tr>
																<td class="view_new">
																	<bean:message key="9105" />
																</td>
																<td class="view_new">
																	<bean:message key="9106" />
																</td>
															</Tr>
															<Tr>
																<td class="view_new">
																	<bean:message key="9107" />
																</td>
																<td class="view_new">
																	<bean:message key="9108" />
																</td>
															</TR>
															<TR>
																<TD></TD>
															</TR>
														</TABLE>
													</td>
												</tr>
												<tr>
													<td class="view_item" colspan="4">
														<bean:message key="7527a" />
														<bean:message key="7528" />
														<bean:message key="7529" />
														<bean:message key="7527" />
													</td>
												</tr>
												<tr>
													<td class="view_item" colspan="4">
														<table border="1" width="600" align="center">
															<tr>
																<td class="view_new">
																	<bean:message key="9109" />
																</td>
																<td class="view_new">
																	<bean:message key="9110" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9111" />
																</td>
																<td class="view_new">
																	<bean:message key="9112" />
																</td>
															</tr>
														</table>
													</td>
												</tr>
												<tr>
													<td class="view_item" colspan="4">
														<bean:message key="7530a" />
														<bean:message key="7530" />
														<bean:message key="7531" />
														<bean:message key="7532" />
														<bean:message key="7533" />
														<bean:message key="7534a" />
														<bean:message key="7535a" />
														<bean:message key="7536a" />
														<bean:message key="7537a" />
														<bean:message key="7538a" />
														<bean:message key="7539a" />
														<bean:message key="7534" />
														<bean:message key="7535" />
														<bean:message key="7536" />
														<bean:message key="7537" />
														<bean:message key="7538" />
														<bean:message key="7539" />
														<bean:message key="7540" />
														<bean:message key="7541" />
														<bean:message key="7542" />
													</td>
												</tr>
												<tr>
													<td class="view_item" colspan="4">
														<table border="1" width="600" align="center">
															<tr>
																<td class="view_new">
																	<bean:message key="9113" />
																</td>
																<td class="view_new">
																	<bean:message key="9114" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9115" />
																</td>
																<td class="view_new">
																	<bean:message key="9116" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9117" />
																</td>
																<td class="view_new">
																	<bean:message key="9118" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9119" />
																</td>
																<td class="view_new">
																	<bean:message key="9120" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9121" />
																</td>
																<td class="view_new">
																	<bean:message key="9122" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9123" />
																</td>
																<td class="view_new">
																	<bean:message key="9124" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9125" />
																</td>
																<td class="view_new">
																	<bean:message key="9126" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9127" />
																</td>
																<td class="view_new">
																	<bean:message key="9128" />
																</td>
															</tr>
															<TR>
																<TD></TD>
															</TR>
														</table>
													</td>
												</tr>
												<tr>
													<td class="view_item" colspan="4">
														<table border="1" width="600" align="center">
															<tr>
																<td class="view_new">
																	<bean:message key="9129" />
																</td>
																<td class="view_new">
																	<bean:message key="9130" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9131" />
																</td>
																<td class="view_new">
																	<bean:message key="9132" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9133" />
																</td>
																<td class="view_new">
																	<bean:message key="9134" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9135" />
																</td>
																<td class="view_new">
																	<bean:message key="9136" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9137" />
																</td>
																<td class="view_new">
																	<bean:message key="9138" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9139" />
																</td>
																<td class="view_new">
																	<bean:message key="9140" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9141" />
																</td>
																<td class="view_new">
																	<bean:message key="9142" />
																</td>
															</tr>
															<TR>
																<TD></TD>
															</TR>
														</table>
													</td>
												</tr>
												<tr>
													<td class="view_item" colspan="4">
														<table border="1" width="600" align="center">
															<tr>
																<td class="view_new">
																	<bean:message key="9143" />
																</td>
																<td class="view_new">
																	<bean:message key="9144" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9145" />
																</td>
																<td class="view_new">
																	<bean:message key="9146" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9147" />
																</td>
																<td class="view_new">
																	<bean:message key="9148" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9149" />
																</td>
																<td class="view_new">
																	<bean:message key="9150" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9152" />
																</td>
																<td class="view_new">
																	<bean:message key="9153" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9154" />
																</td>
																<td class="view_new">
																	<bean:message key="9155" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9157" />
																</td>
																<td class="view_new">
																	<bean:message key="9158" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9159" />
																</td>
																<td class="view_new">
																	<bean:message key="9160" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9161" />
																</td>
																<td class="view_new">
																	<bean:message key="9162" />
																</td>
															</tr>
															<TR>
																<TD></TD>
															</TR>
														</table>
													</td>
												</tr>
												<tr>
													<td class="view_item" colspan="4">
														<table border="1" width="600" align="center">
															<tr>
																<td class="view_new">
																	<bean:message key="9163" />
																</td>
																<td class="view_new">
																	<bean:message key="9164" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9165" />
																</td>
																<td class="view_new">
																	<bean:message key="9166" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9167" />
																</td>
																<td class="view_new">
																	<bean:message key="9168" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9169" />
																</td>
																<td class="view_new">
																	<bean:message key="9170" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9171" />
																</td>
																<td class="view_new">
																	<bean:message key="9172" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9173" />
																</td>
																<td class="view_new">
																	<bean:message key="9174" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9175" />
																</td>
																<td class="view_new">
																	<bean:message key="9176" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9177" />
																</td>
																<td class="view_new">
																	<bean:message key="9178" />
																</td>
															</tr>
															<TR>
																<TD></TD>
															</TR>
														</table>
													</td>
												</tr>
												<tr>
													<td class="view_item" colspan="4">
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="5" class="view_item">
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="5"></TD>
															</TR>
															<tr>
																<td class="view_new">
																	<bean:message key="9179" />
																</td>
																<td class="view_new">
																	<bean:message key="9180" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9181" />
																</td>
																<td class="view_new">
																	<bean:message key="9182" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9183" />
																</td>
																<td class="view_new">
																	<bean:message key="9184" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9185" />
																</td>
																<td class="view_new">
																	<bean:message key="9186" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9187" />
																</td>
																<td class="view_new">
																	<bean:message key="9188" />
																</td>
															</tr>
															<tr>
																<td class="view_newt">
																	<bean:message key="9189" />
																</td>
																<td class="view_new">
																	<bean:message key="9190" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9191" />
																</td>
																<td class="view_new">
																	<bean:message key="9192" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9193" />
																</td>
																<td class="view_new">
																	<bean:message key="9194" />
																</td>
															</tr>
															<TR>
																<TD></TD>
															</TR>
														</TABLE>
													</td>
												</tr>
												<tr>
													<td class="view_item" colspan="4">
														<bean:message key="7543" />
													</td>
												</tr>
												<tr>
													<td colspan="4">
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="5" class="view_item">
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="5"></TD>
															</TR>
															<tr>
																<td class="view_new">
																	<bean:message key="9195" />
																</td>
																<td class="view_new">
																	<bean:message key="9196" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9197" />
																</td>
																<td class="view_new">
																	<bean:message key="9198" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9199" />
																</td>
																<td class="view_new">
																	<bean:message key="9200" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9201" />
																</td>
																<td class="view_new">
																	<bean:message key="9202" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9203" />
																</td>
																<td class="view_new">
																	<bean:message key="9204" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9205" />
																</td>
																<td class="view_new">
																	<bean:message key="9206" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9207" />
																</td>
																<td class="view_new">
																	<bean:message key="9208" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9209" />
																</td>
																<td class="view_new">
																	<bean:message key="9210" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9211" />
																</td>
																<td class="view_new">
																	<bean:message key="9212" />
																</td>
															</tr>
															<TR>
																<TD></TD>
															</TR>
														</TABLE>
													</td>
												</tr>
												<tr>
													<td class="view_item" colspan="4">
														<bean:message key="7544" />
													</td>
												</tr>
												<tr>
													<td colspan="4">
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="5" class="view_item">
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="5"></TD>
															</TR>
															<tr>
																<td class="view_new">
																	<bean:message key="9213" />
																</td>
																<td class="view_new">
																	<bean:message key="9214" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9215" />
																</td>
																<td class="view_new">
																	<bean:message key="9216" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9217" />
																</td>
																<td class="view_new">
																	<bean:message key="9218" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9219" />
																</td>
																<td class="view_new">
																	<bean:message key="9220" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9221" />
																</td>
																<td class="view_new">
																	<bean:message key="9222" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9223" />
																</td>
																<td class="view_new">
																	<bean:message key="9224" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9225" />
																</td>
																<td class="view_new">
																	<bean:message key="9226" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9227" />
																</td>
																<td class="view_new">
																	<bean:message key="9228" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9229" />
																</td>
																<td class="view_new">
																	<bean:message key="9230" />
																</td>
															</tr>
															<TR>
																<TD></TD>
															</TR>
														</TABLE>
													</td>
												</tr>
												<tr>
													<td colspan="4">
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="5" class="view_item">
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="5"></TD>
															</TR>
															<tr>
																<td class="view_new">
																	<bean:message key="9243" />
																</td>
																<td class="view_new">
																	<bean:message key="9244" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9245" />
																</td>
																<td class="view_new">
																	<bean:message key="9246" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9247" />
																</td>
																<td class="view_new">
																	<bean:message key="9248" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9249" />
																</td>
																<td class="view_new">
																	<bean:message key="9250" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9251" />
																</td>
																<td class="view_new">
																	<bean:message key="9252" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9253" />
																</td>
																<td class="view_new">
																	<bean:message key="9254" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9255" />
																</td>
																<td class="view_new">
																	<bean:message key="9256" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9257" />
																</td>
																<td class="view_new">
																	<bean:message key="9258" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9259" />
																</td>
																<td class="view_new">
																	<bean:message key="9260" />
																</td>
															</tr>
															<TR>
																<TD></TD>
															</TR>
														</TABLE>
													</td>
												</tr>
												<tr>
													<td colspan="4">
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="5" class="view_item">
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="5">
																</TD>
															</TR>
															<tr>
																<td class="view_new">
																	<bean:message key="9261" />
																</td>
																<td class="view_new">
																	<bean:message key="9262" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9263" />
																</td>
																<td class="view_new">
																	<bean:message key="9264" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9265" />
																</td>
																<td class="view_new">
																	<bean:message key="9266" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9267" />
																</td>
																<td class="view_new">
																	<bean:message key="9268" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9269" />
																</td>
																<td class="view_new">
																	<bean:message key="9270" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9271" />
																</td>
																<td class="view_new">
																	<bean:message key="9272" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9273" />
																</td>
																<td class="view_new">
																	<bean:message key="9274" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9275" />
																</td>
																<td class="view_new">
																	<bean:message key="9276" />
																</td>
															</tr>
															<TR>
																<TD></TD>
															</TR>
														</TABLE>
													</td>
												</tr>
												<tr>
													<td colspan="4">
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="5" class="view_item">
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="5">
																</TD>
															</TR>
															<tr>
																<td class="view_new">
																	<bean:message key="9277" />
																</td>
																<td class="view_new">
																	<bean:message key="9278" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9281" />
																</td>
																<td class="view_new">
																	<bean:message key="9282" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9283" />
																</td>
																<td class="view_new">
																	<bean:message key="9284" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9285" />
																</td>
																<td class="view_new">
																	<bean:message key="9286" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9287" />
																</td>
																<td class="view_new">
																	<bean:message key="9288" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9289" />
																</td>
																<td class="view_new">
																	<bean:message key="9290" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9291" />
																</td>
																<td class="view_new">
																	<bean:message key="9292" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9293" />
																</td>
																<td class="view_new">
																	<bean:message key="9294" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9295" />
																</td>
																<td class="view_new">
																	<bean:message key="9296" />
																</td>
															</tr>
															<TR>
																<TD></TD>
															</TR>
														</TABLE>
													</td>
												</tr>
												<tr>
													<td class="view_item" colspan="4">
														<bean:message key="7545" />
													</td>
												</tr>
												<tr>
													<td colspan="4">
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="5" class="view_item">
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="5">
																</TD>
															</TR>
															<tr>
																<td class="view_new">
																	<bean:message key="9297" />
																</td>
																<td class="view_new">
																	<bean:message key="9298" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9299" />
																</td>
																<td class="view_new">
																	<bean:message key="9300" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9301" />
																</td>
																<td class="view_new">
																	<bean:message key="9302" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9303" />
																</td>
																<td class="view_new">
																	<bean:message key="9304" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9305" />
																</td>
																<td class="view_new">
																	<bean:message key="9306" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9307" />
																</td>
																<td class="view_new">
																	<bean:message key="9308" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9309" />
																</td>
																<td class="view_new">
																	<bean:message key="9310" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9311" />
																</td>
																<td class="view_new">
																	<bean:message key="9312" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9313" />
																</td>
																<td class="view_new">
																	<bean:message key="9314" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9315" />
																</td>
																<td class="view_new">
																	<bean:message key="9316" />
																</td>
															</tr>
															<TR>
																<TD></TD>
															</TR>
														</TABLE>
													</td>
												</tr>
												<tr>
													<td colspan="4">
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="5" class="view_item">
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="5">
																</TD>
															</TR>
															<tr>
																<td class="view_new">
																	<bean:message key="9317" />
																</td>
																<td class="view_new">
																	<bean:message key="9318" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9319" />
																</td>
																<td class="view_new">
																	<bean:message key="9320" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9321" />
																</td>
																<td class="view_new">
																	<bean:message key="9322" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9323" />
																</td>
																<td class="view_new">
																	<bean:message key="9324" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9325" />
																</td>
																<td class="view_new">
																	<bean:message key="9326" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9609" />
																</td>
																<td class="view_new">
																	<bean:message key="9610" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9327" />
																</td>
																<td class="view_new">
																	<bean:message key="9328" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9329" />
																</td>
																<td class="view_new">
																	<bean:message key="9330" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9331" />
																</td>
																<td class="view_new">
																	<bean:message key="9332" />
																</td>
															</tr>
															<TR>
																<TD></TD>
															</TR>
														</TABLE>
													</td>
												</tr>
												<tr>
													<td colspan="4">
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="5" class="view_item">
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="5">
																</TD>
															</TR>
															<tr>
																<td class="view_new">
																	<bean:message key="9333" />
																</td>
																<td class="view_new">
																	<bean:message key="9334" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9335" />
																</td>
																<td class="view_new">
																	<bean:message key="9336" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9337" />
																</td>
																<td class="view_new">
																	<bean:message key="9338" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9339" />
																</td>
																<td class="view_new">
																	<bean:message key="9340" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9341" />
																</td>
																<td class="view_new">
																	<bean:message key="9342" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9343" />
																</td>
																<td class="view_new">
																	<bean:message key="9344" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9345" />
																</td>
																<td class="view_new">
																	<bean:message key="9346" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9347" />
																</td>
																<td class="view_new">
																	<bean:message key="9348" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9349" />
																</td>
																<td class="view_new">
																	<bean:message key="9350" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9351" />
																</td>
																<td class="view_new">
																	<bean:message key="9352" />
																</td>
															</tr>
															<TR>
																<TD></TD>
															</TR>
														</TABLE>
												<tr>
													<td colspan="4">
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="5" class="view_item">
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="5">
																</TD>
															</TR>
															<tr>
																<td class="view_new">
																	<bean:message key="9353" />
																</td>
																<td class="view_new">
																	<bean:message key="9354" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9355" />
																</td>
																<td class="view_new">
																	<bean:message key="9356" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9357" />
																</td>
																<td class="view_new">
																	<bean:message key="9358" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9359" />
																</td>
																<td class="view_new">
																	<bean:message key="9360" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9361" />
																</td>
																<td class="view_new">
																	<bean:message key="9362" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9363" />
																</td>
																<td class="view_new">
																	<bean:message key="9364" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9365" />
																</td>
																<td class="view_new">
																	<bean:message key="9366" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9367" />
																</td>
																<td class="view_new">
																	<bean:message key="9368" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9369" />
																</td>
																<td class="view_new">
																	<bean:message key="9370" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9371" />
																</td>
																<td class="view_new">
																	<bean:message key="9372" />
																</td>
															</tr>
															<TR>
																<TD></TD>
															</TR>
														</TABLE>
												<tr>
													<td colspan="4">
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="5" class="view_item">
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="5">
																</TD>
															</TR>
															<tr>
																<td class="view_new">
																	<bean:message key="9373" />
																</td>
																<td class="view_new">
																	<bean:message key="9374" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9375" />
																</td>
																<td class="view_new">
																	<bean:message key="9376" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9377" />
																</td>
																<td class="view_new">
																	<bean:message key="9378" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9379" />
																</td>
																<td class="view_new">
																	<bean:message key="9380" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9381" />
																</td>
																<td class="view_new">
																	<bean:message key="9382" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9383" />
																</td>
																<td class="view_new">
																	<bean:message key="9384" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9385" />
																</td>
																<td class="view_new">
																	<bean:message key="9386" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9387" />
																</td>
																<td class="view_new">
																	<bean:message key="9388" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9389" />
																</td>
																<td class="view_new">
																	<bean:message key="9390" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9391" />
																</td>
																<td class="view_new">
																	<bean:message key="9392" />
																</td>
															</tr>
															<TR>
																<TD></TD>
															</TR>
														</TABLE>
												<tr>
													<td colspan="4">
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="5" class="view_item">
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="5">
																</TD>
															</TR>
															<tr>
																<td class="view_new">
																	<bean:message key="9393" />
																</td>
																<td class="view_new">
																	<bean:message key="9394" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9395" />
																</td>
																<td class="view_new">
																	<bean:message key="9396" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9397" />
																</td>
																<td class="view_new">
																	<bean:message key="9398" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9399" />
																</td>
																<td class="view_new">
																	<bean:message key="9400" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9401" />
																</td>
																<td class="view_new">
																	<bean:message key="9402" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9403" />
																</td>
																<td class="view_new">
																	<bean:message key="9404" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9405" />
																</td>
																<td class="view_new">
																	<bean:message key="9406" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9407" />
																</td>
																<td class="view_new">
																	<bean:message key="9408" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9409" />
																</td>
																<td class="view_new">
																	<bean:message key="9410" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9411" />
																</td>
																<td class="view_new">
																	<bean:message key="9412" />
																</td>
															</tr>
															<TR>
																<TD></TD>
															</TR>
														</TABLE>
												<tr>
													<td colspan="4">
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="5" class="view_item">
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="5">
																</TD>
															</TR>
															<tr>
																<td class="view_new">
																	<bean:message key="9413" />
																</td>
																<td class="view_new">
																	<bean:message key="9414" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9415" />
																</td>
																<td class="view_new">
																	<bean:message key="9416" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9417" />
																</td>
																<td class="view_new">
																	<bean:message key="9418" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9419" />
																</td>
																<td class="view_new">
																	<bean:message key="9420" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9421" />
																</td>
																<td class="view_new">
																	<bean:message key="9422" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9423" />
																</td>
																<td class="view_new">
																	<bean:message key="9424" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9425" />
																</td>
																<td class="view_new">
																	<bean:message key="9426" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9427" />
																</td>
																<td class="view_new">
																	<bean:message key="9428" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9429" />
																</td>
																<td class="view_new">
																	<bean:message key="9430" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9431" />
																</td>
																<td class="view_new">
																	<bean:message key="9432" />
																</td>
															</tr>
															<TR>
																<TD></TD>
															</TR>
														</TABLE>
												<tr>
													<td colspan="4">
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="5" class="view_item">
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="5">
																</TD>
															</TR>
															<tr>
																<td class="view_new">
																	<bean:message key="9433" />
																</td>
																<td class="view_new">
																	<bean:message key="9434" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9435" />
																</td>
																<td class="view_new">
																	<bean:message key="9436" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9437" />
																</td>
																<td class="view_new">
																	<bean:message key="9438" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9439" />
																</td>
																<td class="view_new">
																	<bean:message key="9440" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9441" />
																</td>
																<td class="view_new">
																	<bean:message key="9442" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9443" />
																</td>
																<td class="view_new">
																	<bean:message key="9444" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9445" />
																</td>
																<td class="view_new">
																	<bean:message key="9446" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9447" />
																</td>
																<td class="view_new">
																	<bean:message key="9448" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9449" />
																</td>
																<td class="view_new">
																	<bean:message key="9450" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9451" />
																</td>
																<td class="view_new">
																	<bean:message key="9452" />
																</td>
															</tr>
															<TR>
																<TD></TD>
															</TR>
														</TABLE>
												<tr>
													<td colspan="4">
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="5" class="view_item">
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="5">
																</TD>
															</TR>
															<tr>
																<td class="view_new">
																	<bean:message key="9453" />
																</td>
																<td class="view_new">
																	<bean:message key="9454" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9455" />
																</td>
																<td class="view_new">
																	<bean:message key="9456" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9457" />
																</td>
																<td class="view_new">
																	<bean:message key="9458" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9459" />
																</td>
																<td class="view_new">
																	<bean:message key="9460" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9461" />
																</td>
																<td class="view_new">
																	<bean:message key="9462" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9463" />
																</td>
																<td class="view_new">
																	<bean:message key="9464" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9465" />
																</td>
																<td class="view_new">
																	<bean:message key="9466" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9467" />
																</td>
																<td class="view_new">
																	<bean:message key="9468" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9469" />
																</td>
																<td class="view_new">
																	<bean:message key="9470" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9471" />
																</td>
																<td class="view_new">
																	<bean:message key="9472" />
																</td>
															</tr>
															<TR>
																<TD></TD>
															</TR>
														</TABLE>
												<tr>
													<td colspan="4">
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="5" class="view_item">
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="5">
																</TD>
															</TR>
															<tr>
																<td class="view_new">
																	<bean:message key="9473" />
																</td>
																<td class="view_new">
																	<bean:message key="9474" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9475" />
																</td>
																<td class="view_new">
																	<bean:message key="9476" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9477" />
																</td>
																<td class="view_new">
																	<bean:message key="9478" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9479" />
																</td>
																<td class="view_new">
																	<bean:message key="9480" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9481" />
																</td>
																<td class="view_new">
																	<bean:message key="9482" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9483" />
																</td>
																<td class="view_new">
																	<bean:message key="9484" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9485" />
																</td>
																<td class="view_new">
																	<bean:message key="9486" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9487" />
																</td>
																<td class="view_new">
																	<bean:message key="9488" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9489" />
																</td>
																<td class="view_new">
																	<bean:message key="9490" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9491" />
																</td>
																<td class="view_new">
																	<bean:message key="9492" />
																</td>
															</tr>
															<TR>
																<TD></TD>
															</TR>
														</TABLE>
												<tr>
													<td colspan="4">
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="5" class="view_item">
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="5"></TD>
															</TR>
															<tr>
																<td class="view_new">
																	<bean:message key="9493" />
																</td>
																<td class="view_new">
																	<bean:message key="9494" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9495" />
																</td>
																<td class="view_new">
																	<bean:message key="9496" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9497" />
																</td>
																<td class="view_new">
																	<bean:message key="9498" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9499" />
																</td>
																<td class="view_new">
																	<bean:message key="9500" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9501" />
																</td>
																<td class="view_new">
																	<bean:message key="9502" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9503" />
																</td>
																<td class="view_new">
																	<bean:message key="9504" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9505" />
																</td>
																<td class="view_new">
																	<bean:message key="9506" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9507" />
																</td>
																<td class="view_new">
																	<bean:message key="9508" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9509" />
																</td>
																<td class="view_new">
																	<bean:message key="9510" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9511" />
																</td>
																<td class="view_new">
																	<bean:message key="9512" />
																</td>
															</tr>
															<TR>
																<TD></TD>
															</TR>
														</TABLE>
												<tr>
													<td colspan="4">
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="5" class="view_new">
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="5">
																</TD>
															</TR>
															<tr>
																<td class="view_new">
																	<bean:message key="9513" />
																</td>
																<td class="view_new">
																	<bean:message key="9514" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9515" />
																</td>
																<td class="view_new">
																	<bean:message key="9516" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9517" />
																</td>
																<td class="view_new">
																	<bean:message key="9518" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9519" />
																</td>
																<td class="view_new">
																	<bean:message key="9520" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9521" />
																</td>
																<td class="view_new">
																	<bean:message key="9522" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9523" />
																</td>
																<td class="view_new">
																	<bean:message key="9524" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9525" />
																</td>
																<td class="view_new">
																	<bean:message key="9526" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9527" />
																</td>
																<td class="view_new">
																	<bean:message key="9528" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9529" />
																</td>
																<td class="view_new">
																	<bean:message key="9530" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9531" />
																</td>
																<td class="view_new">
																	<bean:message key="9532" />
																</td>
															</tr>
															<TR>
																<TD></TD>
															</TR>
														</TABLE>
												<tr>
													<td  colspan="4">
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="5" class="view_item">
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="5">
																</TD>
															</TR>
															<tr>
																<td class="view_new">
																	<bean:message key="9533" />
																</td>
																<td class="view_new">
																	<bean:message key="9534" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9535" />
																</td>
																<td class="view_new">
																	<bean:message key="9536" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9537" />
																</td>
																<td class="view_new">
																	<bean:message key="9538" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9539" />
																</td>
																<td class="view_new">
																	<bean:message key="9540" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9541" />
																</td>
																<td class="view_new">
																	<bean:message key="9542" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9543" />
																</td>
																<td class="view_new">
																	<bean:message key="9544" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9545" />
																</td>
																<td class="view_new">
																	<bean:message key="9546" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9547" />
																</td>
																<td class="view_new">
																	<bean:message key="9548" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9549" />
																</td>
																<td class="view_new">
																	<bean:message key="9550" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9551" />
																</td>
																<td class="view_new">
																	<bean:message key="9552" />
																</td>
															</tr>
															<TR>
																<TD></TD>
															</TR>
														</TABLE>
												<tr>
													<td>
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="5" class="view_item">
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="5">
																</TD>
															</TR>
															<tr>
																<td class="view_new">
																	<bean:message key="9553" />
																</td>
																<td class="view_new">
																	<bean:message key="9554" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9555" />
																</td>
																<td class="view_new">
																	<bean:message key="9556" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9557" />
																</td>
																<td class="view_new">
																	<bean:message key="9558" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9559" />
																</td>
																<td class="view_new">
																	<bean:message key="9560" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9561" />
																</td>
																<td class="view_new">
																	<bean:message key="9562" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9563" />
																</td>
																<td class="view_new">
																	<bean:message key="9564" />
																</td>
															</tr>
															<TR>
																<TD></TD>
															</TR>
														</TABLE>
												<tr>
													<td colspan="4">
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="5" class="view_item" >
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="5">
																</TD>
															</TR>
															<tr>
																<td class="view_new">
																	<bean:message key="9565" />
																</td>
																<td class="view_new">
																	<bean:message key="9566" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9567" />
																</td>
																<td class="view_new">
																	<bean:message key="9568" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9569" />
																</td>
																<td class="view_new">
																	<bean:message key="9570" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9571" />
																</td>
																<td class="view_new">
																	<bean:message key="9572" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9573" />
																</td>
																<td class="view_new">
																	<bean:message key="9574" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9575" />
																</td>
																<td class="view_new">
																	<bean:message key="9576" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9577" />
																</td>
																<td class="view_new">
																	<bean:message key="9578" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9579" />
																</td>
																<td class="view_new">
																	<bean:message key="9580" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9581" />
																</td>
																<td class="view_new">
																	<bean:message key="9582" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9583" />
																</td>
																<td class="view_new">
																	<bean:message key="9584" />
																</td>
															</tr>
															<TR>
																<TD></TD>
															</TR>
														</TABLE>
														<tr>
													<td colspan="4">
														<TABLE border="1" cellpadding="1" cellspacing="1" width="100%">
															<TR>
																<TD colspan="5" class="view_item">
																	<bean:message key="3013" />
																</TD>
															</TR>
															<TR>
																<TD colspan="5">
																</TD>
															</TR>
															<tr>
																<td class="view_new">
																	<bean:message key="9585" />
																</td>
																<td class="view_new">
																	<bean:message key="9586" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9587" />
																</td>
																<td class="view_new">
																	<bean:message key="9588" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9589" />
																</td>
																<td class="view_new">
																	<bean:message key="9590" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9591" />
																</td>
																<td class="view_new">
																	<bean:message key="9592" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9611" />
																</td>
																<td class="view_new">
																	<bean:message key="9612" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9593" />
																</td>
																<td class="view_new">
																	<bean:message key="9594" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9595" />
																</td>
																<td class="view_new">
																	<bean:message key="9596" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9597" />
																</td>
																<td class="view_new">
																	<bean:message key="9598" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9599" />
																</td>
																<td class="view_new">
																	<bean:message key="9600" />
																</td>
															</tr>
															<tr>
																<td class="view_new">
																	<bean:message key="9601" />
																</td>
																<td class="view_new">
																	<bean:message key="9602" />
																</td>
															</tr>
															<TR>
																<TD></TD>
															</TR>
														</TABLE>
												<tr>
													<td class="view_item"  colspan="4">
														
														<bean:message key="7546" />
													</TD>
													<!-- 								<TR>
																		<TD class="tdNameOption" colspan="4" align="center"><bean:message key="global.button.Adicionar" />&nbsp;<bean:message key="3090"/></TD>
												</TR>
			 -->
												<TR>
													<TD colspan="2" class="view_item">
														<br>
														<br>
													</TD>
												</TR>
												<TR>
													<TD colspan="2">
														
													</TD>
												</TR>
												<TR>
													<TD colspan="2" align="center">
														<HR>
													</TD>
												</TR>
												<TR>
													<TD colspan="2">
														<DIV align="right" class="imprimir">
															<IMG alt="<bean:message key="global.imprimiralt"/>" src="<%=request.getContextPath()%>/images/print.gif" border="0" height="22" width="20">
															&nbsp;
															<A href="javascript: self.print();"><B><bean:message key="global.imprimir" /></B> </A>
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
		


/***********************************************
* Jump To Top Link Script- © Dynamic Drive (www.dynamicdrive.com)
* Last updated Nov 13th, 03'.
* This notice MUST stay intact for legal use
* Visit http://www.dynamicdrive.com/ for full source code
***********************************************/


	</BODY>
</HTML>
