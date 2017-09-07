<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="com.servidoctor.sdpets.model.GrupoUsuarioSegmentacion"%>
<%@ page import="com.servidoctor.sdpets.model.LogoComprador"%>
<%@ page import="com.servidoctor.sdpets.dao.GrupoUsuarioSegmentacionDAO"%>
<%@ page import="com.servidoctor.sdpets.dao.LogoCompradorDAO"%>
<%@ page import="com.servidoctor.seguridad.model.UsuarioPets"%>
<HTML>
<HEAD>
<LINK rel="stylesheet" href="<%=request.getContextPath()%>/style/estilo_pets.css" type="text/css">
<SCRIPT language="JavaScript">
	function enviar() {
		document.forms[0].submit();
	}
</SCRIPT>
</HEAD>
<BODY>
<html:form action="/DatosMascota/report.do">
	<TABLE border="0" width="550px" align="center">
		<TR>
			<TD>
			<TABLE class="tablag" align="center" cellpadding="0" cellspacing="0" border="0" width="100%">
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
		                             GrupoUsuarioSegmentacion grupoUsuarioPets = grupoUsuarioSegmentacionDAO.retrieve(usuarioPets.getUsup_licencia());  
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
							<tr>
								<TD colspan="4" class="tdOverNameOption"><bean:message key="2287" /></TD>
							</TR>
							<TR>
								<TD colspan="4" style="background-color: #f1f5fa">&nbsp;</TD>
							</TR>
							<TR>
								<TD class="view_item" colspan="3"><bean:message key="2288" /></TD>
								<TD class="view_item"><input type="checkbox" name="infobasica" value="InfBasica"/></TD>
							</TR>
							<TR>
								<TD class="view_item" colspan="3"><bean:message key="2289" /></TD>
								<TD class="view_item"><input type="checkbox" name="contalipes" value="ContAliPeso"/></TD>
							</TR>
							<TR>
								<TD class="view_item" colspan="3"><bean:message key="2290" /></TD>
								<TD class="view_item"><input type="checkbox" name="contvacuna" value="ContVacunas"/></TD>
							</TR>
							<TR>
								<TD class="view_item" colspan="3"><bean:message key="2291" /></TD>
								<TD class="view_item" ><input type="checkbox" name="contactmas" value="ContMascota"/></TD>
							</TR>
							<TR>
								<TD class="view_item"  colspan="3"><bean:message key="2292" /></TD>
								<TD class="view_item"><input type="checkbox" name="medicammas" value="Medicamentos"/></TD>
							</TR>																												
							<TR>
								<TD colspan="4" style="background-color: #f1f5fa">&nbsp;</TD>
							</TR>
							<TR>
								<TD colspan="4" align="center"><INPUT type="button" onclick="enviar()" class="sbttn" value="Aceptar"></TD>
							</TR>
						</TABLE>
					</TD>
				</TR>
			</TABLE>
			</TD>
		</TR>
	</TABLE>
</html:form>
</BODY>
</HTML>