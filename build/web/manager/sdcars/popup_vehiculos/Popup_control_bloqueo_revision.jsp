<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.List"%>
<%@ page import="java.math.BigDecimal"%>
<%@ page import="com.servidoctor.parametros.model.RevisionesVehiculo"%>
<%@ page import="com.servidoctor.parametros.dao.RevisionesVehiculoDAO"%>
<%@ page import="com.servidoctor.sdcars.model.MantenimientoGeneral"%>
<%@ page import="com.servidoctor.sdcars.dao.MantenimientoGeneralDAO"%>
<%@ page import="org.apache.struts.util.MessageResources,com.servidoctor.sdcars.model.Vehiculos,com.servidoctor.sdcars.dao.VehiculosDAO,com.servidoctor.seguridad.model.UsuarioCar"%>
<%@ page import="com.servidoctor.util.classes.ManejoFechas"%>
<link rel="stylesheet" href="/ServiDoctor/style/estilo_car.css" type="text/css">
 <script type="text/javascript" src="<%=request.getContextPath()%>/script/funciones.js"></script>
<SCRIPT>

   function enviar(dato){

		if (dato=='1'){
			window.opener.llegada2(1);
		}
		if (dato=='2'){
			window.opener.llegada2(2);
		}
		if (dato=='3'){
			window.opener.llegada2(3);
		}
		setCookie('POPUP',0)//actualizo el cookie
		window.close();
		
	}
	

</SCRIPT>
<body  onUnload="setCookie('POPUP',0)">
<html:form target="_self" action="/DatosVehiculo/Popup/add_control.do">
	<html:hidden property="cveh_veh_cod" />
	<% UsuarioCar usuarioCar3 = (UsuarioCar) request.getSession().getAttribute("usuarioCar");
	VehiculosDAO vehiculosDAO2 = new  VehiculosDAO();
	Vehiculos vehiculosR=vehiculosDAO2.retrieveCarByUser(usuarioCar3.getUsuc_cod()); 
	RevisionesVehiculoDAO revisionesVehiculoDAO = new RevisionesVehiculoDAO(); 
	MantenimientoGeneralDAO mantenimientoGeneralDao2 = new MantenimientoGeneralDAO();
	MantenimientoGeneral mantenimientoGeneral2 = mantenimientoGeneralDao2.retrive(new BigDecimal(1), vehiculosR.getVehi_cod());
	List revisionVehiculo = revisionesVehiculoDAO.list2(vehiculosR.getVehi_cod());      		
	List revisionesVehiculo = (List) request.getSession().getAttribute("REVISIONES");
	BigDecimal ultimaFecha2= ManejoFechas.getUltimaFecha(vehiculosR,request,mantenimientoGeneral2,revisionVehiculo);

	 %>
	<table border="0" width="100%">
		<tr>
			<td valign="top">
				<table class="tablag" align="center" cellpadding="0" cellspacing="0" border="0" width="550">
					<tr>
						<td>
							<table align="center" cellpadding="0" cellspacing="0" border="0" width="100%">
								<tr>
									<td>
										<table cellpadding="0" cellspacing="0" border="0" width="100%">
											<tr>
												<td colspan="2">
													<img src="<%=request.getContextPath()%>/images/int_tit_car.gif">
													<hr>
												</td>
											</tr>
											<tr>
												<TD class="tdOverNameOption" colspan="2">												
													&nbsp;									
												</TD>
											</tr>
											<tr>
												<td>
													&nbsp;
												</td>
											</tr>
											<tr>
												<td colspan="2" class="view_item">
												
						<bean:message key="5133"/>&nbsp;&nbsp;<%=request.getParameter( "fechaCero" )%><bean:message key="5134"/>
	      				<br /><br /><bean:message key="5135"/><br /><br />
	      				
	      				<% int j=0;int fechacodigo1;int fechacodigo2;int k=0;
	      				
	      				 while(j<revisionVehiculo.size()){ 
	      				 	if (revisionesVehiculo!=null){
		      				 	fechacodigo1=((RevisionesVehiculo) revisionesVehiculo.get(j)).getRveh_control_fec().intValue();
		      				 	fechacodigo2=((RevisionesVehiculo) revisionVehiculo.get(j)).getRveh_control_fec().intValue();
		      				 	if (fechacodigo1!=fechacodigo2 && fechacodigo1!=0){
		      				  		k++;	      				  		
		      				  		if(k==1){
	      				  %>
			      				<table width="100%" border="1" cellpadding="0" cellspacing="0">
			      				<tr>
			      					<td width="60%">&nbsp;<bean:message key="5171"/></td>
			      					<td width="20%">&nbsp;<bean:message key="5163"/></td>
			      					<td width="20%">&nbsp;<bean:message key="5164"/></td>
			      				</tr>
			      			<%		}%>
	      				  
				      				<tr>
				      					<td class="view_item">&nbsp;<%=((RevisionesVehiculo) revisionesVehiculo.get(j)).getRveh_cod()%> - <%=((RevisionesVehiculo) revisionesVehiculo.get(j)).getRveh_actividad()%></td>
					      				<td class="view_item">&nbsp;<%=((RevisionesVehiculo) revisionesVehiculo.get(j)).getRveh_control_fec()%></td>
					      				<td class="view_item">&nbsp;<%=((RevisionesVehiculo) revisionesVehiculo.get(j)).getRveh_control_kms()%></td>
					      			</tr>
		      			<%		
		      					}}
		      					j++;
		      				
		      			}%>
		      			<% 
		      			if(k>0){
		      			 %>
		      			 </table>
						<%}else{ %>
							<div align="center"><bean:message key="5175"/></div>
		      			<% }%>
		      			<br />
	      				<br /><bean:message key="5136"/>	      			
	      				<br /><br />
	      				<% %> 
	      				
	      				
	      				
	      				<table width="100%" border="1" cellpadding="0" cellspacing="0">
	      				<tr>
		      				<td width="60%">&nbsp;<bean:message key="5171"/></td>
		      				<td width="20%">&nbsp;<bean:message key="5163"/></td>
		      				<td width="20%">&nbsp;<bean:message key="5164"/></td>
	      				</tr>
	      				<% 
	      				int b=0;
	      				String fechaCeroS=request.getParameter("fechaCero");
	      				String fechaControlS=request.getParameter("UltimaFechaControl");
	      				int fechaCero = (new Integer(fechaCeroS)).intValue();
	      				int fechaControl= (new Integer(fechaControlS)).intValue();
	      				int fechaControlRevision;
	      				 while(b<revisionVehiculo.size()){ 
	      				 	fechaControlRevision=((RevisionesVehiculo) revisionVehiculo.get(b)).getRveh_control_fec().intValue();
	      				 	if (fechaControlRevision>fechaCero && fechaControlRevision<fechaControl){
	      				 	
	      				 %>
	      				<tr>
		      				<td class="view_item">&nbsp;<%=((RevisionesVehiculo) revisionVehiculo.get(b)).getRveh_cod()%> - <%=((RevisionesVehiculo) revisionVehiculo.get(b)).getRveh_actividad()%></td>
		      				<td class="view_item">&nbsp;<%=((RevisionesVehiculo) revisionVehiculo.get(b)).getRveh_control_fec()%></td>
		      				<td class="view_item">&nbsp;<%=((RevisionesVehiculo) revisionVehiculo.get(b)).getRveh_control_kms()%></td>
	      				</tr>
	      				<%
	      					}
	      					b++;	
		      			} 
		      			int fechaOdometro=vehiculosR.getVehi_fechaodometro().intValue();
		      			int distanciaOdometro=vehiculosR.getVehi_kmsact().intValue();
		      			
		      			if (fechaOdometro>fechaCero && fechaOdometro<fechaControl){ 
		      			%>
		      			<tr>
		      				<td class="view_item">&nbsp;<bean:message key="5176"/></td>
		      				<td class="view_item">&nbsp;<%=fechaOdometro%></td>
		      				<td class="view_item">&nbsp;<%=distanciaOdometro%></td>
	      				</tr>
	      				<%} 		      			
	      				int fechaMantenimiento=mantenimientoGeneral2.getMant_control_fec().intValue();
		      			int distanciaMantenimiento=mantenimientoGeneral2.getMant_control_kms().intValue();
		      			
		      			if (fechaMantenimiento>fechaCero && fechaMantenimiento<fechaControl){ 
		      			%>
		      			<tr>
		      				<td class="view_item">&nbsp;<bean:message key="5177"/></td>
		      				<td class="view_item">&nbsp;<%=fechaMantenimiento%></td>
		      				<td class="view_item">&nbsp;<%=distanciaMantenimiento%></td>
	      				</tr>
	      				<%} %>
		      			
		      			
	      				</table>
	      				<br /><bean:message key="5137"/>
	      				<br><br><table width="100%" border="1" cellpadding="0" cellspacing="0">
	      				<tr>
		      				<td  width="70%">&nbsp;<bean:message key="5168"/></td>
		      				<td  class="view_item" width="30%"><div align="center"><INPUT type="button" onClick="enviar('2')" class="sbttn" value="<bean:message key="5172"/>"></div></td>
	      				</tr>
	      				
	      				<tr>
		      				<td >&nbsp;<bean:message key="5169"/></td>
		      				<td class="view_item"><div align="center"><INPUT type="button" onClick="enviar('1')" class="sbttn" value="<bean:message key="5173"/>"></div></td>
	      				</tr>
	      				<tr>
		      				<td >&nbsp;<bean:message key="5170"/></td>
		      				<td class="view_item"><div align="center"><INPUT type="button" onClick="enviar('3')" class="sbttn" value="<bean:message key="5174"/>"></div></td>
	      				</tr>	      				
	      				</table>
	      				
												</td>
											</tr>
											<tr>
												<td>
													&nbsp;
												</td>
											</tr>
											<tr>
												<td style="background-color: #F1F5FA" colspan="2">
												</td>
											</tr>
											<tr>
												<td>
													&nbsp;
												</td>
											</tr>
											<tr>
												<td colspan="2">
													<table height="30" cellpadding="0" cellspacing="0" border="0" width="100%">
														<tr>
															<td colspan="2" align="center">
																<hr>
															</td>
														</tr>
														<tr align="center" valign="middle">
															<TD colspan="2" align="center">&nbsp;
																
															</TD>
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
</body>