<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ page import="com.servidoctor.sdfamily.model.GrupoUsuarioSegmentacion"%>
<%@ page import="com.servidoctor.sdfamily.model.LogoComprador"%>
<%@ page import="com.servidoctor.sdfamily.dao.GrupoUsuarioSegmentacionDAO"%>
<%@ page import="com.servidoctor.sdfamily.dao.LogoCompradorDAO"%>
<%@ page import="com.servidoctor.seguridad.model.UsuarioFamily"%>
<input type="hidden" name="recargar" value="" />
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
							<TR>
								<TD class="tdOverNameOption" colspan="4" align="center"><bean:message key="8109" /></TD>
							</TR>
							<TR>
								<TD class="tdNameOption" colspan="4" align="center"></TD>
							</TR>
							<TR>
									<TD colspan="4">&nbsp;</TD>
								</TR>	
								<TR>
									<TD colspan="4" class="view_item"><bean:message key="8110" /></TD>
								</TR>
								<TR>
									<TD colspan="4">&nbsp;</TD>
								</TR>		
							<TR>
								<TD colspan="4" class="view_item" ><p align="justify"><bean:message key="8100" /></p></TD>
							</TR>
							<TR>
								<TD colspan="4" class="view_item" ><p align="justify"><bean:message key="8101" /></p></TD>
							</TR>
							<TR>
								<TD colspan="4">
								<table cellpadding="0" cellspacing="0" border="0" width="100%">
									<tr>
										<td width="10%"></td>
										</tr>
								</table>								
							</TR>
							<TR>
								<TD colspan="4" class="view_item" ><p align="justify"><bean:message key="8103" /></p></TD>
							</TR>
							<TR>
								<TD colspan="4">
								<table width="100%">
									<tr>
										<td width="10%"></td>
										<td class="view_item" ><p align="justify"><bean:message key="8104" /></p></TD>
									</TR>
								</table>
							<TR>
								<TD colspan="4" class="view_item" ><p align="justify"><bean:message key="8105" /></p></TD>
							</TR>
							<TR>
								<TD colspan="4" class="view_item" ><p align="justify"><bean:message key="8106" /></p></TD>
							</TR>
							<TR>
								<TD colspan="4">
								<table width="100%">
									<tr>
										<td width="10%"></td>
										<td class="view_item" ><p align="justify"><bean:message key="8107" /></p></TD>
									</TR>
								</table>
							<TR>
								<TD colspan="4" class="view_item" ><p align="justify"><bean:message key="8108" /></p></TD>
							</TR>
							
							<TR>
								<TD colspan="4" width="297"></TD>
							</TR>
							<TR>
								<TD colspan="4" align="center">
								<HR>
								</TD>
							</TR>
							<TR>
								<TD colspan="2">
								<DIV align="right" class="imprimir"><IMG alt="<bean:message key="global.imprimiralt"/>" src="<%=request.getContextPath()%>/images/print.gif" border="0" height="22" width="20">&nbsp;<A
									href="javascript: self.print();"><B><bean:message key="global.imprimir" /></B></A></DIV>
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

