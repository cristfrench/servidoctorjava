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
			window.opener.llegada4(1);
		}
		if (dato=='2'){
			window.opener.llegada4(2);
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
						<bean:message key="5184"/><br><br>
	      				<table width="100%" border="1" cellpadding="0" cellspacing="0">
	      				<tr>
	      					<td width="60%">&nbsp;<bean:message key="5167"/></td>
	      					<td width="20%">&nbsp;<bean:message key="5163"/></td>
	      					<td width="20%">&nbsp;<bean:message key="5164"/></td>
	      				</tr>
	      				<%  int c=0; int d=0;int revisionesN=0;     					
	      				String str = "";
	      				try{
	      				str=request.getParameter( "ListadoBloqueados" );
	      				if (str.length()>0 && str != null){
							String[] tokens = str.split(",");
		      				while(d<tokens.length){     						
	      						c=0;
	      						
	      						while(c<revisionesVehiculo.size()){

		      						Integer revisiones2 = new Integer(tokens[d]);  
		      						revisionesN=revisiones2.intValue();
		      						
		      						if (revisionesN==c+1){
		      							int b=0;
		      						%>
					      				<tr>
					      					<td class="view_item">&nbsp;<%=((RevisionesVehiculo) revisionesVehiculo.get(c)).getRveh_cod()%> - <%=((RevisionesVehiculo) revisionesVehiculo.get(c)).getRveh_actividad()%></td>
						      				<td class="view_item">&nbsp;<%=((RevisionesVehiculo) revisionesVehiculo.get(c)).getRveh_control_fec()%></td>
						      				<td class="view_item">&nbsp;<%=((RevisionesVehiculo) revisionesVehiculo.get(c)).getRveh_control_kms()%></td>
						      			</tr>
			      				<%	}
			      				  	c++;
			      				}
			      				d++;	
			      			} 
		      			}
		      			}catch(NullPointerException e){
		      			//%>
		      				<tr>
					      		<% try{
					      		
					      		if (request.getParameter("who").toString().equals("o")) {%>
					      		<td class="view_item">&nbsp;<bean:message key="5176"/></td>
					      		<%}
					      		 if (request.getParameter("who").toString().equals("m")) {%>
					      		<td class="view_item">&nbsp;<bean:message key="5177"/></td>
					      		<%} %>
					      		<%}catch(NullPointerException ex){
					      		
					      		} %>
						      	<td class="view_item">&nbsp;<%=request.getParameter( "UltimaFechaControl" )%></td>
						      	<td class="view_item">&nbsp;<%=request.getParameter( "UltimaDistanciaControl" )%></td>
						    </tr>
		      			<%
		      			}
		      			 %>
		      			</table>	      			
		      			<br />
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
															<TD colspan="2" align="center">
																<INPUT type="button" onClick="enviar('1')" class="sbttn" value="<bean:message key="5186"/>">
																<INPUT type="button" onClick="enviar('2')" class="sbttn" value="<bean:message key="5166"/>">
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