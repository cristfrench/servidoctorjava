<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="com.servidoctor.sdcars.model.GrupoUsuarioSegmentacion"%>
<%@ page import="com.servidoctor.sdcars.model.LogoComprador"%>
<%@ page import="com.servidoctor.sdcars.dao.GrupoUsuarioSegmentacionDAO"%>
<%@ page import="com.servidoctor.sdcars.dao.LogoCompradorDAO"%>
<%@ page import="com.servidoctor.seguridad.model.UsuarioCar"%>
<HTML>
<HEAD>
<LINK rel="stylesheet" href="<%=request.getContextPath()%>/style/estilo_car.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/style/examples.css" type="text/css" >
<link rel="stylesheet" href="<%=request.getContextPath()%>/style/screen.css" type="text/css" >
<SCRIPT language="JavaScript">
	function enviar() {
		document.forms[0].submit();
	}
</SCRIPT>
</HEAD>
<BODY>
<html:form action="/DatosVehiculo/report.do">
	<TABLE border="0" width="550px" align="center">
		<TR>
			<TD>
			<TABLE class="tablag" align="center" cellpadding="0" cellspacing="0" border="0" width="100%">
				<TR>
					<TD  colspan="4">
						<TABLE cellpadding="0" cellspacing="0" border="0" width="100%">
							<TR>
								<TD  align="left" valign="bottom">
								   	<img src="<%=request.getContextPath()%>/images/int_tit_car.gif">                           
								</TD>

	                          <TD>&nbsp;<%
		                           UsuarioCar usuarioCar = (UsuarioCar) request.getSession().getAttribute("usuarioCar");
		                             
		                             GrupoUsuarioSegmentacion grupoUsuarioSegmentacion = new GrupoUsuarioSegmentacion();
		                             GrupoUsuarioSegmentacionDAO grupoUsuarioSegmentacionDAO = new GrupoUsuarioSegmentacionDAO();
		                             GrupoUsuarioSegmentacion grupoUsuarioCar = grupoUsuarioSegmentacionDAO.retrieve(usuarioCar.getUsuc_licencia());  
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
								<TD colspan="4" class="tdOverNameOption"><bean:message key="2287" /></TD>
							</TR>
							<TR>
								<TD colspan="4" style="background-color: #f1f5fa">&nbsp;</TD>
							</TR>
							<TR>
								<TD class="view_item"  colspan="2" ><bean:message key="2288" /></TD>
								<TD class="view_item"  colspan="2" ><input type="checkbox" name="infobasica" value="InfBasica"/></TD>
							</TR>
							<TR>
								<TD class="view_item" colspan="2"><bean:message key="6180" /></TD>
								<TD class="view_item"  colspan="2" ><input type="checkbox" name="manAct" value="MantAct"/></TD>
							</TR>
							<TR>
								<TD class="view_item" colspan="2"><bean:message key="6181" /></TD>
								<TD class="view_item" colspan="2"><input type="checkbox" name="manUlt" value="MantUlt"/></TD>
							</TR>
							<TR>
								<TD class="view_item" colspan="2"><bean:message key="6182" /></TD>
								<TD class="view_item" colspan="2"><input type="checkbox" name="contLey" value="contLey"/></TD>
							</TR>
							<TR>
								<TD class="view_item" colspan="2"><bean:message key="6183" /></TD>
								<TD class="view_item"  colspan="2"><input type="checkbox" name="seguros" value="seguros"/></TD>
							</TR>
							<TR>
								<TD class="view_item" colspan="2"><bean:message key="6184" /></TD>
								<TD class="view_item"  colspan="2"><input type="checkbox" name="gastosMec" value="gastosMec"/></TD>
							</TR>
							<TR>
								<TD class="view_item" colspan="2"><bean:message key="6185" /></TD>
								<TD class="view_item"  colspan="2"><input type="checkbox" name="gastosAnuales" value="gastosAnuales"/></TD>
							</TR>
							<TR>
								<TD class="view_item" colspan="2"><bean:message key="6186" /></TD>
								<TD class="view_item"  colspan="2"><input type="checkbox" name="gastosNoAnuales" value="gastosNoAnuales"/></TD>
							</TR>
							<TR>
								<TD class="view_item" colspan="2"><bean:message key="6187" /></TD>
								<TD class="view_item"  colspan="2""><input type="checkbox" name="impuestos" value="impuestos"/></TD>
							</TR>
							<TR>
								<TD class="view_item" colspan="2"><bean:message key="6188" /></TD>
								<TD class="view_item"  colspan="2" ><input type="checkbox" name="combustible" value="combustible"/></TD>
							</TR>
							<TR>
								<TD colspan="4"  align="center"><INPUT type="button" onclick="enviar()" class="sbttn" value="Aceptar"></TD>
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