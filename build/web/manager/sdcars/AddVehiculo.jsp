<jsp:directive.page import="com.servidoctor.seguridad.model.UsuarioCar" />
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="com.servidoctor.constantes.IConstantes"%>
<%@ page import="com.servidoctor.sdcars.model.GrupoUsuarioSegmentacion"%>
<%@ page import="com.servidoctor.sdcars.model.LogoComprador"%>
<%@ page import="com.servidoctor.sdcars.dao.GrupoUsuarioSegmentacionDAO"%>
<%@ page import="com.servidoctor.sdcars.dao.LogoCompradorDAO"%>
<%@ page import="com.servidoctor.seguridad.model.UsuarioCar"%>
<script language="JavaScript">

   function enviarD(ruta){
      if(document.forms[0].vehi_placa.value==''){
         alert('<bean:message key="5007" />');
         document.forms[0].vehi_placa.focus();
         return false;
      }
      if(document.forms[0].vehi_modelo.value=='' || document.forms[0].vehi_modelo.value=='0'){
         alert('<bean:message key="5009" />');
         document.forms[0].vehi_modelo.focus();
         return false;
      }
      if(document.forms[0].Dia3.value=='00' || document.forms[0].Mes3.value=='00'){
         alert('<bean:message key="50090" />');
         document.forms[0].Dia3.focus();
         return false;
      }
      if(document.forms[0].vehi_kmsact.value==''){
         alert('<bean:message key="5010" />');
         document.forms[0].vehi_kmsact.focus();
         return false;
      }

      if(document.forms[0].pveh_nombre.value==''){
         alert('<bean:message key="5011" />');
         document.forms[0].pveh_nombre.focus();
         return false;
      }
      if(document.forms[0].pveh_apellido.value==''){
         alert('<bean:message key="5012" />');
         document.forms[0].pveh_apellido.focus();
         return false;
      }      

      if((document.forms[0].pveh_indpais1.value=='' || document.forms[0].pveh_indpais1.value=='0'||
      document.forms[0].pveh_indciudad1.value=='' || document.forms[0].pveh_indciudad1.value=='0'||
      document.forms[0].pveh_telefono1.value=='' || document.forms[0].pveh_telefono1.value=='0')&&
      (document.forms[0].pveh_indpais2.value=='' || document.forms[0].pveh_indpais2.value=='0'||
      document.forms[0].pveh_telefono2.value==''||document.forms[0].pveh_telefono2.value=='0')){
         alert('<bean:message key="5014" />');
         document.forms[0].pveh_indpais1.focus();
         return false;
      }
      
      if(!mail(document.forms[0].pveh_mail)){
         alert('<bean:message key="5019" />');
         document.forms[0].pveh_mail.focus();
         return false;
      }
      
      if(document.forms[0].vehi_num_dias_no_mail<2){
         document.forms[0].vehi_num_dias_no_mail.value="2";
      }
      
	convertirACampo('Dia1', 'Mes1', 'Ano1', 'vehi_feccomp');
	convertirACampo('Dia2', 'Mes2', 'Ano2', 'pveh_fecnacim');
	convertirACampo('Dia3', 'Mes3', 'Ano3', 'vehi_fechaodometro');
	document.forms[0].pveh_mail.disabled = false;
	document.forms[0].action = ruta;
	document.forms[0].submit();
}

	function actualizar(){
		convertirACampo('Dia1', 'Mes1', 'Ano1', 'vehi_feccomp');
		convertirACampo('Dia2', 'Mes2', 'Ano2', 'pveh_fecnacim');
		convertirACampo('Dia3', 'Mes3', 'Ano3', 'vehi_fechaodometro');
		enviar('<%=request.getContextPath()%>/DatosVehiculo/add.do');
	}

</script>

<html:form target="_self" action="/DatosVehiculo/add.do">
	<input type="hidden" name="recargar" value="recargar" />
	<html:hidden property="vehi_enero" />
	<html:hidden property="vehi_febrero" />
	<html:hidden property="vehi_marzo" />
	<html:hidden property="vehi_abril" />
	<html:hidden property="vehi_mayo" />
	<html:hidden property="vehi_junio" />
	<html:hidden property="vehi_julio" />
	<html:hidden property="vehi_agosto" />
	<html:hidden property="vehi_septiembre" />
	<html:hidden property="vehi_octubre" />
	<html:hidden property="vehi_noviembre" />
	<html:hidden property="vehi_diciembre" />
	<html:hidden property="vehi_promedio" />
	<table border="0" width="100%">
		<tr>
			<td valign=top>
				<table class="tablag" align="center" cellpadding="0" cellspacing="0" border="0" width="650">
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
											
											<tr>
												<td class="tdOverNameOption" colspan="4">
													<bean:message key="1506" />
												</td>
											</tr>
											<tr>
												<td class="tdNameOption" colspan="4">
													<bean:message key="global.button.Adicionar" />
												</td>
											</tr>
											<tr>
												<td>
													&nbsp;
												</td>
											</tr>
											<tr>
												<td class="view_item" colspan="4">
													<bean:message key="7401" />
												</td>
											</tr>
											<tr>
												<td>
													&nbsp;
												</td>
											</tr>
											<tr>
												<TD colspan="2" class="tdNameOption">
													<bean:message key="1051" />
												</TD>
											</tr>
											<tr>
												<TD class="view_item" nowrap="nowrap">
													<bean:message key="1041" />
													:&nbsp;
													<html:text property="vehi_placa" maxlength="14" size="20" styleClass="sel" onfocus='this.select()' />
												</TD>
												<TD class="view_item" nowrap="nowrap">
													<bean:message key="1052" />
													:&nbsp;
													<html:hidden property="vehi_feccomp"  styleId="vehi_feccomp" />
													<SCRIPT language="JavaScript">obtenerCamposFecha('Dia1', 'Mes1', 'Ano1', 'vehi_feccomp');</SCRIPT>
												</TD>
											</tr>
											<tr>
												<td>
													&nbsp;
												</td>
											</tr>
											<tr>
												<TD class="view_item" nowrap="nowrap">
													<bean:message key="1053" />
													:&nbsp;
													<html:select property="vehi_tveh_cod" styleClass="select">
														<html:options collection="TIPOVEHICULO" labelProperty="tveh_des" property="tveh_cod" />
													</html:select>
													&nbsp;&nbsp;&nbsp;&nbsp;
												</td>
												<td class="view_item" nowrap="nowrap">
													<bean:message key="1042" />
													:&nbsp;
													<html:select property="vehi_maut_cod" styleClass="select">
														<html:options collection="MARCASAUTOS" labelProperty="maut_des" property="maut_cod" />
													</html:select>
												</td>
											</tr>
											<tr>
												<td>
													&nbsp;
												</td>
											</tr>
											<tr>
												<TD class="view_item" nowrap="nowrap">
													<bean:message key="1054" />
													:&nbsp;
													<html:text property="vehi_modelo" maxlength="4" size="4" onkeyup="isNatural(this);" onblur="isNatural(this);" styleClass="sel"
														onfocus='this.select()' />
													&nbsp;&nbsp;
												</td>
												<TD class="view_item" nowrap="nowrap">
													<bean:message key="10530" />
													:
													<html:text property="vehi_tipo" maxlength="15" size="10" styleClass="sel" onfocus='this.select()' />
													<br />
												</TD>
											</tr>
											<tr>
												<td>
													&nbsp;
												</td>
											</tr>
											<tr>
												<TD class="view_item">
													<bean:message key="1055" />
													:
													<html:text property="vehi_kmsact" maxlength="6" onkeyup="isNatural(this);" onblur="isNatural(this);" size="10" styleClass="sel"
														onfocus="this.select()" />
												</td>
												<TD class="view_item" nowrap="nowrap">
													<bean:message key="10550" />
													:
													<html:hidden property="vehi_fechaodometro"  styleId="vehi_fechaodometro"  />
													<script language="JavaScript">obtenerCamposFecha('Dia3', 'Mes3', 'Ano3', 'vehi_fechaodometro');</script>
												</TD>
											</tr>
											<tr>
												<TD class="view_item" colspan="2" height="11">
													<bean:message key="1111" />
													:&nbsp;&nbsp;&nbsp;&nbsp;
													<bean:message key="1112" />
													<html:radio property="vehi_distancia" value="<%=IConstantes.DISTANCIA_KILOMETROS%>" />
													<bean:message key="1113" />
													<html:radio property="vehi_distancia" value="<%=IConstantes.DISTANCIA_MILLAS%>" />
												</td>
											</tr>
											<tr>
												<TD colspan="3" style="background-color: #ffffff">
													&nbsp;
												</TD>
											</tr>
											<tr>
												<TD colspan="2" class="tdNameOption">
													<bean:message key="1027" />
												</TD>
											</tr>

											<tr>
												<TD class="view_item" nowrap="nowrap">
													<bean:message key="4" />
													&nbsp;
													<html:text property="pveh_nombre" maxlength="30" size="40" styleClass="sel" />
												</TD>
												<TD class="view_item" nowrap="nowrap">
													<bean:message key="5" />
													&nbsp;
													<html:text property="pveh_apellido" maxlength="30" size="40" styleClass="sel" />
												</TD>
											</tr>
											<tr>
												<TD colspan="3" style="background-color: #ffffff">
													&nbsp;
												</TD>
											</tr>
											<tr>
												<TD class="view_item" nowrap="nowrap" colspan="3">
													<bean:message key="12" />
												</TD>
											</tr>
											<tr>
												<TD class="view_item" nowrap="nowrap">
													<bean:message key="13" />
													:&nbsp;
													<html:select property="pveh_pais_cod" styleClass="select" onchange="actualizarCiudades(this.value)">
														<html:options collection="PAISES" labelProperty="pais_des" property="pais_cod" />
													</html:select>
													<br>
													<br>
													<bean:message key="14" />
													:&nbsp;
													<html:select property="pveh_ciu_cod" styleClass="select" styleId="ciudadesContent">
														<html:options collection="CIUDADES" labelProperty="ciu_des" property="ciu_cod" />
													</html:select>
												</TD>
												<TD class="view_item" nowrap="nowrap">
													&nbsp;
													<bean:message key="22" />
													:&nbsp;
													<html:hidden property="pveh_fecnacim"  styleId="pveh_fecnacim" />
													<SCRIPT language="JavaScript">obtenerCamposFecha('Dia2', 'Mes2', 'Ano2', 'pveh_fecnacim');</SCRIPT>
													<br>
													<bean:message key="3507" />
													:&nbsp;
													<bean:message key="20" />
													<html:radio property="pveh_sexo" value="<%=IConstantes.SEXO_MASCULINO%>" />
													<bean:message key="21" />
													<html:radio property="pveh_sexo" value="<%=IConstantes.SEXO_FEMENINO%>" />
												</TD>
											</tr>
											<tr>
												<TD class="view_item" nowrap="nowrap">
													<bean:message key="6177" />
													:&nbsp;
													<html:select property="pveh_idio_cod" styleClass="select">
														<html:options collection="IDIOMAS" labelProperty="idio_descripcion" property="idio_cod" />
													</html:select>
												</TD>
											</tr>
											<tr>
												<TD colspan="3" style="background-color: #ffffff">
													&nbsp;
												</TD>
											</tr>
											<tr>
												<TD class="view_item" nowrap="nowrap" colspan="3">
													<bean:message key="15" />
												</TD>
											</tr>
											<tr>
												<TD colspan="2" class="view_item" nowrap="nowrap">
													&nbsp;
													<bean:message key="16" />
													&nbsp;
													<bean:message key="13" />
													:
													<html:text onfocus='this.select()' property="pveh_indpais1" onkeyup="isNatural(this);" onblur="isNatural(this);" maxlength="3" size="4"
														styleClass="sel" />
													&nbsp;
													<bean:message key="16" />
													&nbsp;
													<bean:message key="14" />
													:&nbsp;
													<html:text property="pveh_indciudad1" maxlength="3" onkeyup="isNatural(this);" onblur="isNatural(this);" size="4" styleClass="sel"
														onfocus='this.select()' />
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<bean:message key="17" />
													:
													<html:text onfocus='this.select()' property="pveh_telefono1" maxlength="15" onkeyup="isNatural(this);" onblur="isNatural(this);"
														size="30" styleClass="sel" />
												</TD>
											</tr>
											<tr>
												<TD colspan="3" style="background-color: #ffffff">
													&nbsp;
												</TD>
											</tr>
											<tr>
												<TD colspan="3" class="view_item">
													<bean:message key="18" />
												</TD>
											</tr>
											<tr>
												<TD colspan="2" class="view_item" nowrap="nowrap">
													<bean:message key="16" />
													&nbsp;
													<bean:message key="13" />
													:&nbsp;
													<html:text onfocus='this.select()' property="pveh_indpais2" maxlength="3" onkeyup="isNatural(this);" onblur="isNatural(this);" size="6"
														styleClass="sel" />
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<bean:message key="17" />
													:
													<html:text onfocus='this.select()' property="pveh_telefono2" maxlength="15" onkeyup="isNatural(this);" onblur="isNatural(this);"
														size="30" styleClass="sel" />
												</TD>
											</tr>
											<tr>
												<TD colspan="3" style="background-color: #ffffff">
													&nbsp;
												</TD>
											</tr>
											<tr>
												<TD class="view_item" nowrap="nowrap" colspan="3">
													<bean:message key="19" />
													:&nbsp;
													<html:text property="pveh_mail" maxlength="30" size="50" styleClass="sel"
														value="<%=( ( UsuarioCar ) request.getSession().getAttribute( "usuarioCar" ) ).getUsuc_usuario()%>" disabled="true" />
												</TD>
											</tr>
											<tr>
												<td colspan="2">
													&nbsp;
												</td>
											</tr>
											<tr>
												<td colspan="2">
												</td>
											</tr>
											<!-- Lo de abajo -->
											<tr>
												<td colspan="4">
													<table height="30" cellpadding="0" cellspacing="0" border="0" width="100%">
														<tr>
															<td align="center">
																<hr>
															</td>
														</tr>
														<tr align="center" valign="middle">
															<td>
																<INPUT type="button" onclick="return enviarD('<%=request.getContextPath()%>/DatosVehiculo/save.do')" class="sbttn"
																	value="<bean:message key="136"/>">
															</td>
														</tr>
														<tr>
															<td>

																<div align="right" class="imprimir">
																	<img alt="<bean:message key="global.imprimiralt"/>" src="<%=request.getContextPath()%>/images/print.gif" border="0" height="22"
																		width="20">
																	&nbsp;
																	<a href="javascript: self.print();"><b><bean:message key="global.imprimir" />
																	</b>
																	</a>
																</div>
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
			</td>
		</tr>
	</table>
</html:form>




