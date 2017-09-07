<jsp:directive.page import="com.servidoctor.seguridad.model.UsuarioPets" />
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="com.servidoctor.constantes.IConstantes"%>
<%@ page import="com.servidoctor.sdpets.model.GrupoUsuarioSegmentacion"%>
<%@ page import="com.servidoctor.sdpets.model.LogoComprador"%>
<%@ page import="com.servidoctor.sdpets.dao.GrupoUsuarioSegmentacionDAO"%>
<%@ page import="com.servidoctor.sdpets.dao.LogoCompradorDAO"%>
<%@ page import="com.servidoctor.seguridad.model.UsuarioPets"%>
<SCRIPT language="JavaScript">
function enviar(ruta) {
		
	var noTelFijo = false;
	var noTelMovil = false;
	if ((Trim(document.forms[0].pmas_indpais1.value)=='' || document.forms[0].pmas_indpais1.value=='0') || (Trim(document.forms[0].pmas_indciudad1.value)=='' || document.forms[0].pmas_indciudad1.value=='0') || (Trim(document.forms[0].pmas_telefono1.value)=='' || document.forms[0].pmas_telefono1.value=='0')){
    	noTelFijo = true;
    }if ((Trim(document.forms[0].pmas_indpais2.value=='') || document.forms[0].pmas_indpais2.value=='0') || (Trim(document.forms[0].pmas_telefono2.value)=='' || document.forms[0].pmas_telefono2.value=='0')){
    	noTelMovil = true;
    }
    if(document.forms[0].mas_nombre.value==''){
		alert('<bean:message key="3050" />');
        document.forms[0].mas_nombre.focus();
        return false;
	}
    if(document.forms[0].pmas_nombre.value==''){
    	alert('<bean:message key="3051" />');
        document.forms[0].pmas_nombre.focus();
        return false;
	}	
	if(document.forms[0].pmas_apellido.value==''){
    	alert('<bean:message key="3052" />');
        document.forms[0].pmas_apellido.focus();
        return false;
	}
	
	if((document.forms[0].pmas_indpais1.value=='' || document.forms[0].pmas_indpais1.value=='0') && noTelMovil){
    	alert('<bean:message key="3053" />');
        document.forms[0].pmas_indpais1.focus();
        return false;
	}
	if((document.forms[0].pmas_indciudad1.value=='' || document.forms[0].pmas_indciudad1.value=='0') && noTelMovil){
    	alert('<bean:message key="3054" />');
        document.forms[0].pmas_indciudad1.focus();
        return false;
	}
	if((document.forms[0].pmas_telefono1.value=='' || document.forms[0].pmas_telefono1.value=='0') && noTelMovil){
    	alert('<bean:message key="3055" />');
        document.forms[0].pmas_telefono1.focus();
        return false;
	}	
	if((document.forms[0].pmas_indpais2.value=='' || document.forms[0].pmas_indpais2.value=='0') && noTelFijo){
    	alert('<bean:message key="3056" />');
        document.forms[0].pmas_indpais2.focus();
        return false;
	}
	if((document.forms[0].pmas_telefono2.value=='' || document.forms[0].pmas_telefono2.value=='0') && noTelFijo){
    	alert('<bean:message key="3057" />');
        document.forms[0].pmas_telefono2.focus();
        return false;
	}document.forms[0].pmas_mail.value = Trim(document.forms[0].pmas_mail.value);
	if(!mail(document.forms[0].pmas_mail)){
         alert('<bean:message key="5019" />');
         document.forms[0].pmas_mail.focus();
         return false;
      }
	     
    convertirACampo('cDia', 'cMes', 'cAno', 'mas_fecnac');
	document.forms[0].action = ruta;
	document.forms[0].submit();
	
}

function validar_mail() {
	if(!mail(document.forms[0].pmas_mail)){
		alert('<bean:message key="5019" />');
        document.forms[0].pmas_mail.focus();
        return false;
	} 
}

function enviar_sin_validar(ruta) {
	convertirACampo('cDia', 'cMes', 'cAno', 'mas_fecnac');
	document.forms[0].action = ruta;
	document.forms[0].submit();
}

function actualizar(){
	enviar_sin_validar('<%=request.getContextPath()%>/DatosMascota/add.do');
}

</SCRIPT>

<html:form action="/DatosMascota/add.do">
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
								   	<img src="<%=request.getContextPath()%>/images/int_tit_pets.gif">                           
								</TD>

	                          <TD>&nbsp;<%
		                           UsuarioPets usuarioPets = (UsuarioPets) request.getSession().getAttribute("usuarioPets");
		                             
		                             GrupoUsuarioSegmentacion grupoUsuarioSegmentacion = new GrupoUsuarioSegmentacion();
		                             GrupoUsuarioSegmentacionDAO grupoUsuarioSegmentacionDAO = new GrupoUsuarioSegmentacionDAO();
		                             GrupoUsuarioSegmentacion grupoUsuarioPets=null;
		                             if (usuarioPets.getUsup_especial().intValue()==1){
		                             	grupoUsuarioPets = grupoUsuarioSegmentacionDAO.retrive(usuarioPets.getUsup_cod().toString());  
		                             }else{
		                             	grupoUsuarioPets = grupoUsuarioSegmentacionDAO.retrieve(usuarioPets.getUsup_licencia());  
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
                      <TR>
                        <TD class="tdNameOption" colspan="4" align="center">
                          <bean:message key="global.button.Adicionar" />
                          &nbsp;
                          <bean:message key="3011" />
                        </TD>
                      </TR>
                      <TR>
                        <TD colspan="2" class="view_item">
                          <bean:message key="7301" />
                        </TD>
                      </TR>
                      <TR>
                        <TD>
                          &nbsp;
                        </TD>
                      </TR>
                      <TR>
                        <TD colspan="2" class="tdNameOption">
                          <bean:message key="1011" />
                        </TD>
                      </TR>
                      <TR>
                        <TD class="view_item">
                          <bean:message key="1003" />
                          :&nbsp;
                          <html:text property="mas_nombre" maxlength="40" size="20" styleClass="sel" />
                        </TD>
                        <TD class="view_item">
                          <bean:message key="22" />
                          :
                          <html:hidden property="mas_fecnac" styleId="mas_fecnac" />
                          <SCRIPT language="JavaScript">obtenerCamposFecha('cDia', 'cMes', 'cAno', 'mas_fecnac');</SCRIPT>
                        </TD>
                      </TR>
                      <TR>
                        <TD class="view_item" colspan="2">
                          <bean:message key="1004" />
                          :&nbsp;
                          <html:select property="mas_tipo" styleClass="select" onchange="actualizar()">
                            <html:option value="0">
                              <bean:message key="1005" />
                            </html:option>
                            <html:option value="1">
                              <bean:message key="1006" />
                            </html:option>
                          </html:select>
                          &nbsp;&nbsp;&nbsp;&nbsp;
                          <bean:message key="1009" />
                          :&nbsp;
                          <html:select property="mas_raz_cod" styleClass="select">
                            <html:options collection="RAZAS" labelProperty="raz_des" property="raz_cod" />
                          </html:select>
                          &nbsp;&nbsp;&nbsp;&nbsp;
                          <bean:message key="47" />
                          :&nbsp;
                          <bean:message key="1007" />
                          <html:radio property="mas_sexo" value="<%=IConstantes.SEXO_MASCULINO%>" />
                          <bean:message key="1008" />
                          <html:radio property="mas_sexo" value="<%=IConstantes.SEXO_FEMENINO%>" />
                        </TD>
                      </TR>
                      <TR>
                        <TD colspan="3" style="background-color: #ffffff">
                          &nbsp;
                        </TD>
                      </TR>
                      <TR>
                        <TD colspan="2" class="tdNameOption">
                          <bean:message key="1027" />
                        </TD>
                      </TR>
                      <TR>
                        <TD class="view_item">
                          <bean:message key="4" />
                          &nbsp;
                          <html:text property="pmas_nombre" maxlength="80" size="40" styleClass="sel" />
                        </TD>
                        <TD class="view_item">
                          <bean:message key="5" />
                          &nbsp;
                          <html:text property="pmas_apellido" maxlength="80" size="40" styleClass="sel" />
                        </TD>
                      </TR>
                      <TR>
                        <TD colspan="3" style="background-color: #ffffff">
                          &nbsp;
                        </TD>
                      </TR>
                      <TR>
                        <TD class="view_item" colspan="3">
                          <bean:message key="12" />
                        </TD>
                      </TR>
                      <TR>
                        <TD class="view_item">
                          <bean:message key="13" />
                          :&nbsp;
                          <html:select property="pmas_pais_cod" styleClass="select" onchange="actualizarCiudades(this.value, 'ciudadesContent')">
                            <html:options collection="PAISES" labelProperty="pais_des" property="pais_cod" />
                          </html:select>
                          &nbsp;&nbsp;
                          <bean:message key="14" />
                          :&nbsp;
                          <html:select property="pmas_ciu_cod" styleClass="select" styleId="ciudadesContent">
                            <html:options collection="CIUDADESPROP" labelProperty="ciu_des" property="ciu_cod" />
                          </html:select>
                        </TD>
                        <TD class="view_item">
                          &nbsp;
                          <bean:message key="47" />
                          :&nbsp;
                          <bean:message key="20" />
                          <html:radio property="pmas_sexo" value="<%=IConstantes.SEXO_MASCULINO%>" />
                          <bean:message key="21" />
                          <html:radio property="pmas_sexo" value="<%=IConstantes.SEXO_FEMENINO%>" />
                        </TD>
                      </TR>
                      <TR>
                        <TD colspan="3" style="background-color: #ffffff">
                          &nbsp;
                        </TD>
                      </TR>
                      <TR>
                        <TD class="view_item" colspan="3">
                          <bean:message key="15" />
                        </TD>
                      </TR>
                      <TR>
                        <TD class="view_item">
                          &nbsp;
                          <bean:message key="16" />
                          &nbsp;
                          <bean:message key="13" />
                          :
                          <html:text property="pmas_indpais1" maxlength="6" size="6" styleClass="sel" onkeyup="isNatural(this);" onblur="isNatural(this);" onfocus="this.select()" />
                          &nbsp;
                          <bean:message key="14" />
                          :&nbsp;
                          <html:text property="pmas_indciudad1" maxlength="6" size="6" styleClass="sel" onkeyup="isNatural(this);" onblur="isNatural(this);" onfocus="this.select()" />
                        </TD>
                        <TD class="view_item">
                          <bean:message key="17" />
                          :
                          <html:text property="pmas_telefono1" maxlength="40" size="30" styleClass="sel" onkeyup="isNatural(this);" onblur="isNatural(this);" onfocus="this.select()" />
                        </TD>
                      </TR>
                      <TR>
                        <TD colspan="3" style="background-color: #ffffff">
                          &nbsp;
                        </TD>
                      </TR>
                      <TR>
                        <TD colspan="3" class="view_item">
                          <bean:message key="18" />
                        </TD>
                      </TR>
                      <TR>
                        <TD class="view_item">
                          <bean:message key="16" />
                          &nbsp;
                          <bean:message key="13" />
                          :&nbsp;
                          <html:text property="pmas_indpais2" maxlength="6" size="6" styleClass="sel" onkeyup="isNatural(this);" onblur="isNatural(this);" onfocus="this.select()" />
                        </TD>
                        <TD class="view_item">
                          <bean:message key="17" />
                          :
                          <html:text property="pmas_telefono2" maxlength="40" size="30" styleClass="sel" onkeyup="isNatural(this);" onblur="isNatural(this);" onfocus="this.select()" />
                        </TD>
                      </TR>
                      <TR>
                        <TD colspan="3" style="background-color: #ffffff">
                          &nbsp;
                        </TD>
                      </TR>
                      <TR>
                        <TD class="view_item" colspan="3">
                          <bean:message key="19" />
                          :&nbsp;
                          <html:text property="pmas_mail" maxlength="80" size="50" styleClass="sel" onchange="validar_mail()" value="<%=((UsuarioPets) request.getSession().getAttribute(\"usuarioPets\")).getUsup_usuario()%>" />
                        </TD>
                      </TR>
                      <TR>
                        <TD colspan="2" style="background-color: #ffffff">
                          &nbsp;
                        </TD>
                      </TR>
                      <TR>
                        <TD>
                          &nbsp;
                        </TD>
                      </TR>
                      <TR>
                        <TD colspan="4">
                          <TABLE height="30" cellpadding="0" cellspacing="0" border="0" width="100%">
                            <TR>
                              <TD align="center">
                                <HR>
                              </TD>
                            </TR>
                            <TR align="center" valign="middle">
                              <TD>
                                <INPUT type="button" onclick="return enviar('/ServiDoctor/DatosMascota/save.do')" class="sbttn" value="<bean:message key="136"/>">
                              </TD>
                            </TR>
                            <TR>
                              <TD>
                                <DIV align="right" class="imprimir">
                                  <IMG alt="<bean:message key="global.imprimiralt"/>" src="/ServiDoctor/images/print.gif" border="0" height="22" width="20">
                                  &nbsp;
                                  <A href="javascript: self.print();"><B><bean:message key="global.imprimir" />
                                  </B>
                                  </A>
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
      </TD>
    </TR>
  </TABLE>
</html:form>
