
<jsp:directive.page import="com.servidoctor.constantes.IConstantes"/><%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ page import="com.servidoctor.sdcars.model.GrupoUsuarioSegmentacion"%>
<%@ page import="com.servidoctor.sdcars.model.LogoComprador"%>
<%@ page import="com.servidoctor.sdcars.dao.GrupoUsuarioSegmentacionDAO"%>
<%@ page import="com.servidoctor.sdcars.dao.LogoCompradorDAO"%>
<%@ page import="com.servidoctor.seguridad.model.UsuarioCar"%>
<SCRIPT>

function ayudaGeneral(){
   window.open('<%=request.getContextPath()%>/Popup_ayuda.jsp?ayuda=a_general','contacto','scrollbars=yes, top=100, left=200, width=650, height=580')
}

function verTamano(tama){
   //if(document.forms[0].tama.value>='<bean:message key="parametro_adicion_vehiculo"/>'){
   if(document.forms[0].tama.value>='<bean:message key="parametro_adicion_vehiculo"/>'){
      alert('<bean:message key="parametro_superado_vehiculo"/>');
      return false;
   }
   return true;
}

function remove(cod,nom){
	var r=confirm("¿Borrar "+nom+"?")
	if(r){
		enviar('<%=request.getContextPath()%>/DatosVehiculo/remove.do?vehi_cod='+cod)
	}
}

function edit(cod){
	enviar('<%=request.getContextPath()%>/DatosVehiculo/edit.do?vehi_cod='+cod)
}

function view(cod){
	enviar('<%=request.getContextPath()%>/DatosVehiculo/view.do?vehi_cod='+cod)
}		
</SCRIPT>


<html:form target="_self" action="/DatosVehiculo/add.do">
	<table border="0" width="100%">

		<tr>
			<td valign=top>


			<table class="tablag" align="center" cellpadding="0" cellspacing="1" border="0" width="600">
				<tr>
					<td>
					<table align="center" cellpadding="0" cellspacing="0" border="0" width="100%">
						<tr>
						<TD  colspan="4">
						<TABLE cellpadding="0" cellspacing="0" border="0" width="100%">
							<TR>
								<TD  align="left" valign="bottom">
								   	<img src="<%=request.getContextPath()%>/images/int_tit_car.gif">                           
								</TD>

	                          <TD colspan="3">&nbsp;<%
		                           UsuarioCar usuarioCar = (UsuarioCar) request.getSession().getAttribute("usuarioCar");
		                             
		                             GrupoUsuarioSegmentacion grupoUsuarioSegmentacion = new GrupoUsuarioSegmentacion();
		                             GrupoUsuarioSegmentacionDAO grupoUsuarioSegmentacionDAO = new GrupoUsuarioSegmentacionDAO();
		                             		                             GrupoUsuarioSegmentacion grupoUsuarioCar= new GrupoUsuarioSegmentacion();
		                             grupoUsuarioCar.setGrupo_id(IConstantes.CODIGO_NO);
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
                              	    		<a href="<%=datosPublicidadCompletos.getClickizquierdo()%>" target="_blank"><img src="<%=request.getContextPath()%>/images/clickleft.jpg" border="0" ></a>
                             	    	<%}else{%>
											<a href="<%=datosPublicidadCompletos.getClickderecho()%>" target="_blank"><img src="<%=request.getContextPath()%>/images/clickleft.jpg" border="0" ></a>
                              	    	<%}%>
                                  
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
									<td class="tdOverNameOption" colspan="4"><bean:message key="1506" /></td>
								</tr>
								<tr>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td colspan="5" align="center"><bean:message key="global.guardar" /></td>
								</tr>
								<tr>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td colspan="5" class="view_item" align="justify"><bean:message key="7400a" /></td>
								</tr>
								<tr>
									<td class="tdNameOption"  style="border: 1px solid #0066D3" width="10%"><bean:message key="1041" /></td>
									<td class="tdNameOption" style="border: 1px solid #0066D3" width="25%" align="center"><bean:message key="1042" /></td>
									<td class="tdNameOption" style="border: 1px solid #0066D3" width="45%" align="center"><bean:message key="1043" /></td>
									<td class="tdNameOption" style="border: 1px solid #0066D3" width="20%" align="center"><bean:message key="global.acciones" /></td>
								</tr>
								<tr>
									<td>&nbsp;</td>
								</tr>
								<tr>


									<%int x = 0;
String valor = "0";
%>

									<logic:iterate indexId="ind" id="vehiculo" name="VEHICULOS" type="com.servidoctor.sdcars.model.Vehiculos">
										<%if (x % 2 == 0) {%>
										<tr style="background: #F1F5FA">
											<%}%>

											<%if (x % 2 != 0) {%>
										<tr style="background: #FFFFFF">
											<%}%>

											<td class="view_item"><bean:write name="vehiculo" property="vehi_placa" scope="page" /></td>
											<td class="view_desc" align="center"><%=request.getAttribute("mveh_des" + x)%></td>
											<td class="view_desc" align="center"><%=request.getAttribute("tveh_des" + x)%></td>
											<td align="center"><IMG border="0" src="<%=request.getContextPath()%>/images/eliminar.gif"
												onclick="remove('<bean:write name="vehiculo" property="vehi_cod" scope="page"/>','<%=request.getAttribute("mveh_des" + x)%>')" width="17" height="17"
												style="cursor: 'hand'" alt="<bean:message key="global.button.borrar" />" /></td>
										</tr>
										<%x++;%>
									</logic:iterate>
								
								<tr>

									<td colspan="4">
									<table height="30" cellpadding="0" cellspacing="0" border="0" width="100%">
										<tr>
											<td align="center">
											<hr>
										</tr>
										<tr>
											<TD align="right" colspan="4"><img src="<%=request.getContextPath()%>/images/ayuda.bmp" onclick="ayudaGeneral()" /></TD>
										</tr>
										<tr align="center" valign="middle">
											<td>
												<%if (x>=IConstantes.USER_MAX_CARS){%>
													<html:submit styleClass="sbttn" disabled="true"><bean:message key="global.button.adicionarVehiculo" /></html:submit>
												<%}else { %>
													<html:submit styleClass="sbttn" ><bean:message key="global.button.adicionarVehiculo" /></html:submit>
												<%} %>
											</td>
										</tr>
										<tr>
											<td>

											<div align="right" class="imprimir"><img alt="<bean:message key="global.imprimiralt"/>" src="<%=request.getContextPath()%>/images/print.gif" border="0" height="22" width="20">&nbsp;<a
												href="javascript: self.print();"><b><bean:message key="global.imprimir" /></b></a></div>
											</td>
										</tr></table>
									</td>
								</tr></table>
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



