<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page
	import="org.apache.struts.util.MessageResources,java.math.BigDecimal,com.servidoctor.constantes.IConstantes,com.servidoctor.util.classes.ManejoFechas,com.servidoctor.parametros.model.RevisionesVehiculo"%>
<%@ page import="com.servidoctor.sdcars.model.GrupoUsuarioSegmentacion"%>
<%@ page import="com.servidoctor.sdcars.model.LogoComprador"%>
<%@ page import="com.servidoctor.sdcars.dao.GrupoUsuarioSegmentacionDAO"%>
<%@ page import="com.servidoctor.sdcars.dao.LogoCompradorDAO"%>
<%@ page import="com.servidoctor.seguridad.model.UsuarioCar"%>
<script language="JavaScript">

function enviarD(ruta){

  /*    if(document.forms[0].pveh_indpais2.value=='' || document.forms[0].pveh_indpais2.value=='0'){
         alert('<bean:message key="5016" />');
         document.forms[0].pveh_indpais2.focus();
         return false;
      }

      if(!mail(document.forms[0].pveh_mail)){
         alert('<bean:message key="5019" />');
         document.forms[0].pveh_mail.focus();
         return false;
      }      */

	document.forms[0].action = ruta;
	document.forms[0].submit();
}

function actualizarTabla(){
	document.forms[0].vehi_enero.value=document.forms[0].vehi_promedio.value;
	document.forms[0].vehi_febrero.value=document.forms[0].vehi_promedio.value;
	document.forms[0].vehi_marzo.value=document.forms[0].vehi_promedio.value;
	document.forms[0].vehi_abril.value=document.forms[0].vehi_promedio.value;
	document.forms[0].vehi_mayo.value=document.forms[0].vehi_promedio.value;
	document.forms[0].vehi_junio.value=document.forms[0].vehi_promedio.value;
	document.forms[0].vehi_julio.value=document.forms[0].vehi_promedio.value;
	document.forms[0].vehi_agosto.value=document.forms[0].vehi_promedio.value;
	document.forms[0].vehi_septiembre.value=document.forms[0].vehi_promedio.value;
	document.forms[0].vehi_octubre.value=document.forms[0].vehi_promedio.value;
	document.forms[0].vehi_noviembre.value=document.forms[0].vehi_promedio.value;
	document.forms[0].vehi_diciembre.value=document.forms[0].vehi_promedio.value;
	}
function validarDatosCurva(){
	b=true;
	if (document.forms[0].vehi_promedio.value=='' || document.forms[0].vehi_promedio.value==null){
		alert('<bean:message key="5189" />');
		document.forms[0].vehi_promedio.focus();
		b=false;
	}	
	if (document.forms[0].vehi_enero.value=='' || document.forms[0].vehi_enero.value==null){
		alert('<bean:message key="5188" /> <bean:message key="3574" />');
		document.forms[0].vehi_enero.focus();
		b=false;
	}	
	if (document.forms[0].vehi_febrero.value=='' || document.forms[0].vehi_febrero.value==null){
		alert('<bean:message key="5188" /> <bean:message key="3575" />');
		document.forms[0].vehi_febrero.focus();
		b=false;
	}
	if (document.forms[0].vehi_marzo.value=='' || document.forms[0].vehi_marzo.value==null){
		alert('<bean:message key="5019" /> <bean:message key="3576" />');
		document.forms[0].vehi_marzo.focus();
		b=false;
	}
	if (document.forms[0].vehi_abril.value=='' || document.forms[0].vehi_abril.value==null){
		alert('<bean:message key="5188" /> <bean:message key="3577" />');
		document.forms[0].vehi_abril.focus();
		b=false;
	}
	if (document.forms[0].vehi_mayo.value=='' || document.forms[0].vehi_mayo.value==null){
		alert('<bean:message key="5188" /> <bean:message key="3578" />');
		document.forms[0].vehi_mayo.focus();
		b=false;
	}
	if (document.forms[0].vehi_junio.value=='' || document.forms[0].vehi_junio.value==null){
		alert('<bean:message key="5188" /> <bean:message key="3579" />');
		document.forms[0].vehi_junio.focus();
		b=false;
	}
	if (document.forms[0].vehi_julio.value=='' || document.forms[0].vehi_julio.value==null){
		alert('<bean:message key="5188" /> <bean:message key="3580" />');
		document.forms[0].vehi_julio.focus();
		b=false;
	}
	if (document.forms[0].vehi_agosto.value=='' || document.forms[0].vehi_agosto.value==null){
		alert('<bean:message key="5188" /> <bean:message key="3581" />');
		document.forms[0].vehi_agosto.focus();
		b=false;
	}
	if (document.forms[0].vehi_septiembre.value=='' || document.forms[0].vehi_septiembre.value==null){
		alert('<bean:message key="5188" /> <bean:message key="3582" />');
		document.forms[0].vehi_septiembre.focus();
		b=false;
	}
	if (document.forms[0].vehi_octubre.value=='' || document.forms[0].vehi_octubre.value==null){
		alert('<bean:message key="5188" /> <bean:message key="3583" />');
		document.forms[0].vehi_octubre.focus();
		b=false;
	}
	if (document.forms[0].vehi_noviembre.value=='' || document.forms[0].vehi_noviembre.value==null){
		alert('<bean:message key="5188" /> <bean:message key="3584" />');
		document.forms[0].vehi_noviembre.focus();
		b=false;
	}
	if (document.forms[0].vehi_diciembre.value=='' || document.forms[0].vehi_diciembre.value==null){
		alert('<bean:message key="5188" /> <bean:message key="3585" />');
		document.forms[0].vehi_diciembre.focus();
		b=false;
	}
	return b;
	
	}
</script>

<html:form target="_self" action="/DatosVehiculo/curva.do">
	<html:hidden property="vehi_cod" />
	<html:hidden property="vehi_usuc_cod" />
	<html:hidden property="vehi_fecinscripcion" />
	<html:hidden property="vehi_fechaodometro" />
	<html:hidden property="vehi_feccomp" />
	<html:hidden property="vehi_placa" />
	<html:hidden property="vehi_tveh_cod" />
	<html:hidden property="vehi_tipo" />
	<html:hidden property="vehi_maut_cod" />
	<html:hidden property="vehi_modelo" />
	<html:hidden property="vehi_distancia" />
	<html:hidden property="vehi_num_dias_no_mail" />
	<html:hidden property="vehi_kmscomp" />
	<html:hidden property="vehi_kmsact" />
	<html:hidden property="vehi_fechacambiocurva"  styleId="vehi_fechacambiocurva"  />
	
	
	<table border="0" width="100%">
		<tr>
			<td valign=top>
				<table class="tablag" align="center" cellpadding="0" cellspacing="0" border="0" width="600">
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
												<td class="tdOverNameOption" colspan="2">
													<bean:message key="3570" />
												</td>
											</tr>
											<tr>
												<td colspan="2">
													&nbsp;
												</td>
											<tr>
												<td colspan="2">
													&nbsp;
												</td>
											<tr>
												<td colspan="2" class="view_item">
													<bean:message key="3589" />
												</td>
											</tr>
											<tr>
												<td colspan="2">
													&nbsp;
												</td>
											</tr>
											<tr>
												<td colspan="2" class="view_item">
													<bean:message key="3572" />
													<div align="center">
														<html:text property='vehi_promedio' maxlength='6' size='10' styleClass="selNum" onkeyup='isNatural(this);' onblur='isNatural(this);'
															onfocus='this.select()' onchange="actualizarTabla()" />
													</div>
												</td>
											</tr>
											<tr>
												<td class="view_item">
												</td>
												<td class="view_item">
												</td>
											</tr>
											<tr>
												<td>
													&nbsp;
												</td>
											</tr>
											<tr>
												<td class="view_item">
													<bean:message key="3588" />
												</td>
											</tr>
											<tr>
												<td>
													&nbsp;
												</td>
											</tr>
											<tr>
												<td colspan="2">
													<table align='center'>
														<tr align='center'>
															<td class='view_item'>
																<bean:message key='3574' />
															</td>
															<td class='view_item'>
																<bean:message key='3575' />
															</td>
															<td class='view_item'>
																<bean:message key='3576' />
															</td>
															<td class='view_item'>
																<bean:message key='3577' />
															</td>
															<td class='view_item'>
																<bean:message key='3578' />
															</td>
															<td class='view_item'>
																<bean:message key='3579' />
															</td>
														</tr>
														<tr>
															<td class='view_item'>
																<html:text property='vehi_enero' maxlength='6' size='10' styleClass="selNum" onkeyup='isNatural(this);' onblur='isNatural(this);'
																	onfocus='this.select()' />
															</td>
															<td class='view_item'>
																<html:text property='vehi_febrero' maxlength='6' size='10' styleClass="selNum" onkeyup='isNatural(this);' onblur='isNatural(this);'
																	onfocus='this.select()' />
															</td>
															<td class='view_item'>
																<html:text property='vehi_marzo' maxlength='6' size='10' styleClass="selNum" onkeyup='isNatural(this);' onblur='isNatural(this);'
																	onfocus='this.select()' />
															</td>
															<td class='view_item'>
																<html:text property='vehi_abril' maxlength='6' size='10' styleClass="selNum" onkeyup='isNatural(this);' onblur='isNatural(this);'
																	onfocus='this.select()' />
															</td>
															<td class='view_item'>
																<html:text property='vehi_mayo' maxlength='6' size='10' styleClass="selNum" onkeyup='isNatural(this);' onblur='isNatural(this);'
																	onfocus='this.select()' />
															</td>
															<td class='view_item'>
																<html:text property='vehi_junio' maxlength='6' size='10' styleClass="selNum" onkeyup='isNatural(this);' onblur='isNatural(this);'
																	onfocus='this.select()' />
															</td>
														</tr>
													</table>
												</td>
											</tr>
											<tr>
												<td colspan='2'>
													&nbsp;
												</td>
											</tr>
											<tr>
												<td colspan="2">
													&nbsp;
												</td>
											</tr>
											<tr>
												<td colspan='2'>
													<table align='center'>
														<tr align='center'>
															<td class='view_item'>
																<bean:message key='3580' />
															</td>
															<td class='view_item'>
																<bean:message key='3581' />
															</td>
															<td class='view_item'>
																<bean:message key='3582' />
															</td>
															<td class='view_item'>
																<bean:message key='3583' />
															</td>
															<td class='view_item'>
																<bean:message key='3584' />
															</td>
															<td class='view_item'>
																<bean:message key='3585' />
															</td>
														</tr>
														<tr>

															<td class='view_item'>
																<html:text property='vehi_julio' maxlength='6' size='10' styleClass="selNum" onkeyup='isNatural(this);' onblur='isNatural(this);'
																	onfocus='this.select()' />
															</td>
															<td class='view_item'>
																<html:text property='vehi_agosto' maxlength='6' size='10' styleClass="selNum" onkeyup='isNatural(this);' onblur='isNatural(this);'
																	onfocus='this.select()' />
															</td>
															<td class='view_item'>
																<html:text property='vehi_septiembre' maxlength='6' size='10' styleClass="selNum" onkeyup='isNatural(this);'
																	onblur='isNatural(this);' onfocus='this.select()' />
															</td>
															<td class='view_item'>
																<html:text property='vehi_octubre' maxlength='6' size='10' styleClass="selNum" onkeyup='isNatural(this);' onblur='isNatural(this);'
																	onfocus='this.select()' />
															</td>
															<td class='view_item'>
																<html:text property='vehi_noviembre' maxlength='6' size='10' styleClass="selNum" onkeyup='isNatural(this);' onblur='isNatural(this);'
																	onfocus='this.select()' />
															</td>
															<td class='view_item'>
																<html:text property='vehi_diciembre' maxlength='6' size='10' styleClass="selNum" onkeyup='isNatural(this);' onblur='isNatural(this);'
																	onfocus='this.select()' />
															</td>
														</tr>
													</table>
												</td>
											</tr>
											<tr>
												<td colspan="2">
													&nbsp;
												</td>
											</tr>
											<tr>
												<td colspan="2">
													&nbsp;
												</td>
											</tr>
											<tr>
												<td colspan="2">
													&nbsp;
												</td>
											</tr>
											<tr>
												<td colspan="2">
													&nbsp;
												</td>
											</tr>
											<tr>
												<td colspan="2">
													&nbsp;
												</td>
											</tr>
											<tr>
												<td colspan="2">
													&nbsp;
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
																<INPUT type="button" onclick="if (validarDatosCurva()){ enviarD('<%=request.getContextPath()%>/DatosVehiculo/saveCurva.do');}" class="sbttn"
																	value="<bean:message key="136"/>">
															</td>
														</tr>
														<tr>
															<td>
																<div align="right" class="imprimir">
																	<img alt="<bean:message key="global.imprimiralt"/>" src="/ServiDoctor/images/print.gif" border="0" height="22" width="20">
																	&nbsp;
																	<a href="javascript: self.print();"><b><bean:message key="global.imprimir" />
																	</b> </a>
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

