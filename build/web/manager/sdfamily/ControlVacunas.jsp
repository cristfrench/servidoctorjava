<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="comp"%>
<%@ page import="com.servidoctor.constantes.IConstantes"%>
<%@ page import="org.apache.struts.util.MessageResources"%>
<%@ page import="com.servidoctor.sdfamily.model.GrupoUsuarioSegmentacion"%>
<%@ page import="com.servidoctor.sdfamily.model.LogoComprador"%>
<%@ page import="com.servidoctor.sdfamily.dao.GrupoUsuarioSegmentacionDAO"%>
<%@ page import="com.servidoctor.sdfamily.dao.LogoCompradorDAO"%>
<%@ page import="com.servidoctor.seguridad.model.UsuarioFamily"%>
<%!MessageResources res = MessageResources.getMessageResources("com.servidoctor.resources.ApplicationResources");%>
<SCRIPT>
function add_vacuna(tama){
	if(tama>=<bean:message key="parametro_adicion_vacuna"/>){
      alert('<bean:message key="parametro_superado_vacuna"/>');
      return false;
   }else{
	if(hay_popup_abierto())	
		return false;
	eval("window.open('<%=request.getContextPath()%>/Control_Vacunas/Popup/add_vacuna.do','contacto','scrollbars=yes, top=100, left=200, width=650, height=350')")
	return true;
	}
}
function remove_vacuna(x,des){
	var r=confirm("Borrar "+des+"?")
	if(r){
		enviar('<%=request.getContextPath()%>/Control_Vacunas/add.do?redirect=/Control_Vacunas/Popup/remove_vacuna.do?num_vacuna='+x);
	}
}


</SCRIPT>


<html:form target="_self" action="/Control_Vacunas/add.do">
  <input type="hidden" name="add" value="" />
  <table border="0" width="100%">
    <tr>
      <td valign=top>
        <table class="tablag" align="center" cellpadding="0" cellspacing="0" border="0" width="620">
          <tr>
            <td>
              <table align="center" cellpadding="0" cellspacing="0" border="0" width="100%">
                <tr>
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
                      <tr>
                        <td class="tdOverNameOption" colspan="51">
                          <bean:message key="1505" />
                        </td>
                      </tr>
                      <tr>
                        <td class="tdNameOption" colspan="4">
                          <table border="0" cellpadding="0" cellspacing="1">
                            <tr>
                              <TD id="tab11" class="sbttn tdNameOption" onClick="tab('1','vacunas','family')">
                                &nbsp;
                                <bean:message key="550" />
                                &nbsp;
                              </TD>
                              <TD id="tab12" class="sbttn tdNameOption" onClick="tab('2','vacunas','family')">
                                &nbsp;
                                <bean:message key="551" />
                                &nbsp;
                              </TD>
                            </tr>
                          </table>
                        </td>
                      </tr>
                      <tr>
                        <td colspan="4">
                          <br />
                          <table border="0" id="tab1" cellspacing="0" cellpadding="0" width="100%">
                            <tr>
                              <td>
                                <table border="0" cellpadding="0" cellspacing="0" width="100%">
                                  <tr>
                                    <TD width="99">
                                      &nbsp;
                                    </TD>
                                  </tr>
                                  <tr>
                                    <TD colspan="35" class="view_item">
                                      <bean:message key="7243" />
                                    </TD>
                                  </tr>
                                  <tr>
                                    <TD class="tdNameOption" align="center">
                                      <bean:message key="558" />
                                    </TD>
                                    <TD colspan="35" class="tdNameOption" align="center">
                                      <bean:message key="554" />
                                    </TD>
                                  </tr>
                                  <tr>
                                    <td></td>
                                    <%
                                    	int z = 0;
                                    %>
                                    <%
                                    	while (z < 24) {
                                    			z++;
                                    			if (z % 2 == 0) {
                                    %>
                                    <td width="17" class="tdtitle" style="background: #ffffff" align="center">
                                      <%=z%>
                                    </td>
                                    <%
                                    	} else {
                                    %>
                                    <td width="17" class="tdtitle" style="background: #F1F5FA" align="center">
                                      <%=z%>
                                    </td>
                                    <%
                                    	}
                                    		}
                                    %>
                                  </tr>
                                  <logic:iterate indexId="ind" id="usuariovacunas" name="VACUNAS" type="com.servidoctor.parametros.model.Vacunas">
                                    <%
                                    	z = 1;
                                    %>
                                    <tr>
                                      <td class="view_item" nowrap="nowrap">
                                        <bean:write name="usuariovacunas" property="vac_des" scope="page" />
                                      </td>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_mes1">
                                        <td>
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_mes1">
                                        <td>
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_mes2">
                                        <td width="24">
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_mes2">
                                        <td width="24">
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_mes3">
                                        <td width="24">
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_mes3">
                                        <td width="24">
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_mes4">
                                        <td width="24">
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_mes4">
                                        <td width="24">
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_mes5">
                                        <td width="24">
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_mes5">
                                        <td width="24">
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_mes6">
                                        <td width="24">
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_mes6">
                                        <td width="24">
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_mes7">
                                        <td width="24">
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_mes7">
                                        <td width="24">
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_mes8">
                                        <td width="24">
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_mes8">
                                        <td width="24">

                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_mes9">
                                        <td width="24">
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_mes9">
                                        <td width="24">
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_mes10">
                                        <td width="24">
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_mes10">
                                        <td width="24">
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_mes11">
                                        <td width="24">
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_mes11">
                                        <td width="24">
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_mes12">
                                        <td width="47">
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_mes12">
                                        <td width="1">
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_mes13">
                                        <td width="24">
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_mes13">
                                        <td width="24">
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_mes14">
                                        <td width="24">
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_mes14">
                                        <td width="24">
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_mes15">
                                        <td width="24">
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_mes15">
                                        <td width="24">
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_mes16">
                                        <td width="24">
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_mes16">
                                        <td width="24">
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_mes17">
                                        <td width="24">
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_mes17">
                                        <td width="24">
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_mes18">
                                        <td width="24">
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_mes18">
                                        <td width="24">
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_mes19">
                                        <td width="24">
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_mes19">
                                        <td width="24">
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_mes20">
                                        <td width="24">
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_mes20">
                                        <td width="24">
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_mes21">
                                        <td width="24">
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_mes21">
                                        <td width="24">
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_mes22">
                                        <td width="24">
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_mes22">
                                        <td width="24">
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_mes23">
                                        <td width="24">
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_mes23">
                                        <td width="24">
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_mes24">
                                        <td width="24">
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_mes24">
                                        <td width="63">
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                    </tr>
                                  </logic:iterate>
                                  <tr>
                                    <TD colspan="10"></TD>
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
                              <td>
                                <table border="0" cellpadding="0" cellspacing="0" width="100%">
                                  <tr>
                                    <TD class="tdNameOption" align="center">
                                      <bean:message key="558" />
                                    </TD>
                                    <TD colspan="24" class="tdNameOption" align="center">
                                      <bean:message key="555" />
                                    </TD>
                                  </tr>
                                  <tr>
                                    <td></td>
                                    <%
                                    	z = 2;
                                    		while (z < 18) {
                                    			z++;
                                    			if (z % 2 == 0) {
                                    %>
                                    <td width="10" class="tdtitle" style="background: #ffffff" align="center">
                                      <%=z%>
                                    </td>
                                    <%
                                    	} else {
                                    %>
                                    <td width="10" class="tdtitle" style="background: #F1F5FA" align="center">
                                      <%=z%>
                                    </td>
                                    <%
                                    	}
                                    		}
                                    		z = 1;
                                    %>
                                    <td width="10" class="tdtitle" style="background: #F1F5FA" align="center">
                                      20
                                    </td>
                                    <td width="10" class="tdtitle" style="background: #ffffff" align="center">
                                      30
                                    </td>
                                    <td width="10" class="tdtitle" style="background: #F1F5FA" align="center">
                                      40
                                    </td>
                                    <td width="10" class="tdtitle" style="background: #ffffff" align="center">
                                      50
                                    </td>
                                    <td width="10" class="tdtitle" style="background: #F1F5FA" align="center">
                                      60
                                    </td>
                                    <td width="10" class="tdtitle" style="background: #ffffff" align="center">
                                      70
                                    </td>
                                    <td width="10" class="tdtitle" style="background: #F1F5FA" align="center">
                                      80
                                    </td>
                                    <td width="10" class="tdtitle" style="background: #ffffff" align="center">
                                      90
                                    </td>
                                  </tr>
                                  <logic:iterate indexId="ind" id="usuariovacunas" name="VACUNAS" type="com.servidoctor.parametros.model.Vacunas">
                                    <tr>
                                      <td class="view_item" nowrap="nowrap">
                                        <bean:write name="usuariovacunas" property="vac_des" scope="page" />
                                      </td>
                                      <%
                                      	z = 3;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_anno3">
                                        <td>
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_anno3">
                                        <td>
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_anno4">
                                        <td>
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_anno4">
                                        <td>
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_anno5">
                                        <td>
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_anno5">
                                        <td>
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_anno6">
                                        <td>
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_anno6">
                                        <td>
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_anno7">
                                        <td>
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_anno7">
                                        <td>
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_anno8">
                                        <td>
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_anno8">
                                        <td>
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_anno9">
                                        <td>
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_anno9">
                                        <td>
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_anno10">
                                        <td>
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_anno10">
                                        <td>
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_anno11">
                                        <td>
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_anno11">
                                        <td>
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_anno12">
                                        <td>
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_anno12">
                                        <td>
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_anno13">
                                        <td>
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_anno13">
                                        <td>
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_anno14">
                                        <td>
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_anno14">
                                        <td>
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_anno15">
                                        <td>
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_anno15">
                                        <td>
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_anno16">
                                        <td>
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_anno16">
                                        <td>
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_anno17">
                                        <td>
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_anno17">
                                        <td>
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_anno18">
                                        <td>
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_anno18">
                                        <td>
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z = z + 2;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_anno20">
                                        <td>
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_anno20">
                                        <td>
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z = z + 10;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_anno30">
                                        <td>
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_anno30">
                                        <td>
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z = z + 10;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_anno40">
                                        <td>
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_anno40">
                                        <td>
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z = z + 10;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_anno50">
                                        <td>
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_anno50">
                                        <td>
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z = z + 10;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_anno60">
                                        <td>
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_anno60">
                                        <td>
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z = z + 10;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_anno70">
                                        <td>
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_anno70">
                                        <td>
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z = z + 10;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_anno80">
                                        <td>
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_anno80">
                                        <td>
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z = z + 10;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vac_edad_anno90">
                                        <td>
                                          <html:img page="/img/checkbox_checked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vac_edad_anno90">
                                        <td>
                                          <html:img page="/img/checkbox_unchecked.jpg" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	z = 1;
                                      %>
                                    </tr>
                                  </logic:iterate>
                                </table>
                              </td>
                            </tr>
                          </table>
                        </td>
                      </tr>
                      <tr>
                        <td colspan="4">
                          <br />

                          <table border="0" id="tab2" cellspacing="0" cellpadding="0" width="100%">
                            <tr>
                              <td>
                                <table border="0" cellpadding="0" cellspacing="0" width="100%">
                                  <tr>
                                    <TD colspan="35" class="view_item">
                                      <bean:message key="7244" arg0='<%=res.getMessage("parametro_adicion_vacuna")%>' />
                                    </TD>
                                  </tr>
                                  <tr>
                                    <TD class="tdNameOption" align="center">
                                      <bean:message key="global.numeral" />
                                    </TD>
                                    <TD class="tdNameOption" align="center">
                                      <bean:message key="558" />
                                    </TD>
                                    <TD colspan="24" class="tdNameOption" align="center">
                                      <bean:message key="554" />
                                    </TD>
                                    <TD class="tdNameOption" align="center">
                                      <bean:message key="global.acciones" />
                                    </TD>
                                  </tr>
                                  <tr>

                                    <td></td>
                                    <td></td>
                                    <%
                                    	int y = 0;
                                    %>

                                    <%
                                    	while (y < 24) {
                                    			y++;
                                    			if (y % 2 == 0) {
                                    %>

                                    <td width="10" class="tdtitle" style="background: #ffffff" align="center"><%=y%></td>
                                    <%
                                    	} else {
                                    %>
                                    <td width="10" class="tdtitle" style="background: #F1F5FA" align="center"><%=y%></td>
                                    <%
                                    	}
                                    		}
                                    %>
                                  </tr>
                                  <%
                                  	int x = 0;
                                  %>
                                  <logic:iterate indexId="ind" id="usuariovacunas" name="USUARIO_VACUNAS" type="com.servidoctor.sdfamily.model.VacunasUsuario">
                                    <%
                                    	y = 1;
                                    %>
                                    <tr>
                                      <td class="view_item"><%=x + 1%></td>

                                      <td class="view_item" nowrap="nowrap">
                                        <logic:notEqual name="usuariovacunas" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="vacu_vac_cod">
                                          <%=request.getAttribute("vacu_des" + x)%>
                                        </logic:notEqual>
                                        <logic:equal name="usuariovacunas" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="vacu_vac_cod">
                                          <bean:write name="usuariovacunas" property="vacu_des" scope="page" />
                                        </logic:equal>
                                      </td>

                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_mes1">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes1<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_mes1">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes1<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_mes2">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes2<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_mes2">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes2<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_mes3">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes3<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_mes3">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes3<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_mes4">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes4<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_mes4">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes4<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_mes5">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes5<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_mes5">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes5<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_mes6">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes6<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_mes6">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes6<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_mes7">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes7<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_mes7">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes7<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_mes8">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes8<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_mes8">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes8<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_mes9">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes9<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_mes9">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes9<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_mes10">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes10<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_mes10">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes10<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_mes11">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes11<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_mes11">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes11<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_mes12">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes12<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_mes12">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes12<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_mes13">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes13<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_mes13">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes13<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_mes14">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes14<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_mes14">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes14<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_mes15">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes15<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_mes15">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes15<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_mes16">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes16<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_mes16">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes16<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_mes17">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes17<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_mes17">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes17<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_mes18">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes18<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_mes18">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes18<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_mes19">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes19<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_mes19">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes19<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_mes20">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes20<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_mes20">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes20<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_mes21">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes21<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_mes21">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes21<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_mes22">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes22<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_mes22">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes22<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_mes23">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes23<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_mes23">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes23<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_mes24">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes24<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_mes24">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_mes24<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="503"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <td align="center">
                                        <logic:notEqual name="usuariovacunas" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="vacu_vac_cod">
                                          <IMG border="0" src="<%=request.getContextPath()%>/images/eliminar.gif" onClick="remove_vacuna('<%=x%>','<%=request.getAttribute("vacu_des" + x)%>')" width="17" height="17" style="cursor: hand" alt="<bean:message key="global.button.borrar"/>" />
                                        </logic:notEqual>
                                        <logic:equal name="usuariovacunas" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="vacu_vac_cod">
                                          <IMG border="0" src="<%=request.getContextPath()%>/images/eliminar.gif" onClick="remove_vacuna('<%=x%>','<bean:write name="usuariovacunas" property="vacu_des" scope="page"/>')" width="17" height="17" style="cursor: hand" alt="<bean:message key="global.button.borrar"/>" />
                                        </logic:equal>
                                      </td>
                                    </tr>

                                    <%
                                    	x++;
                                    %>
                                  </logic:iterate>
                                </table>
                              </td>
                            </tr>
                            <tr>
                              <td>
                                &nbsp;
                              </td>
                            </tr>

                            <tr>
                              <td>
                                <table border="0" cellpadding="0" cellspacing="0" width="100%">
                                  <tr>
                                    <TD class="tdNameOption" align="center">
                                      <bean:message key="global.numeral" />
                                    </TD>
                                    <TD class="tdNameOption" align="center">
                                      <bean:message key="558" />
                                    </TD>
                                    <TD colspan="24" class="tdNameOption" align="center">
                                      <bean:message key="555" />
                                    </TD>
                                    <TD class="tdNameOption" align="center">
                                      <bean:message key="global.acciones" />
                                    </TD>
                                  </tr>
                                  <tr>

                                    <td></td>
                                    <td></td>
                                    <%
                                    	y = 2;
                                    		while (y < 18) {
                                    			y++;
                                    			if (y % 2 == 0) {
                                    %>

                                    <td width="10" class="tdtitle" style="background: #ffffff" align="center"><%=y%></td>
                                    <%
                                    	} else {
                                    %>
                                    <td width="10" class="tdtitle" style="background: #F1F5FA" align="center"><%=y%></td>
                                    <%
                                    	}
                                    		}
                                    		y = 1;
                                    %>

                                    <td width="10" class="tdtitle" style="background: #F1F5FA" align="center">
                                      20
                                    </td>
                                    <td width="10" class="tdtitle" style="background: #ffffff" align="center">
                                      30
                                    </td>
                                    <td width="10" class="tdtitle" style="background: #F1F5FA" align="center">
                                      40
                                    </td>
                                    <td width="10" class="tdtitle" style="background: #ffffff" align="center">
                                      50
                                    </td>
                                    <td width="10" class="tdtitle" style="background: #F1F5FA" align="center">
                                      60
                                    </td>
                                    <td width="10" class="tdtitle" style="background: #ffffff" align="center">
                                      70
                                    </td>
                                    <td width="10" class="tdtitle" style="background: #F1F5FA" align="center">
                                      80
                                    </td>
                                    <td width="10" class="tdtitle" style="background: #ffffff" align="center">
                                      90
                                    </td>


                                  </tr>
                                  <%
                                  	x = 0;
                                  %>
                                  <logic:iterate indexId="ind" id="usuariovacunas" name="USUARIO_VACUNAS" type="com.servidoctor.sdfamily.model.VacunasUsuario">
                                    <tr>
                                      <td class="view_item"><%=x + 1%></td>
                                      <td class="view_item" nowrap="nowrap">
                                        <logic:notEqual name="usuariovacunas" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="vacu_vac_cod">
                                          <%=request.getAttribute("vacu_des" + x)%>
                                        </logic:notEqual>
                                        <logic:equal name="usuariovacunas" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="vacu_vac_cod">
                                          <bean:write name="usuariovacunas" property="vacu_des" scope="page" />
                                        </logic:equal>
                                      </td>

                                      <%
                                      	y = 3;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_anno3">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno3<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_anno3">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno3<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_anno4">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno4<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_anno4">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno4<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_anno5">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno5<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_anno5">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno5<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_anno6">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno6<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_anno6">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno6<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_anno7">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno7<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_anno7">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno7<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_anno8">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno8<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_anno8">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno8<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_anno9">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno9<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_anno9">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno9<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_anno10">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno10<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_anno10">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno10<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_anno11">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno11<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_anno11">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno11<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_anno12">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno12<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_anno12">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno12<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_anno13">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno13<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_anno13">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno13<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_anno14">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno14<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_anno14">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno14<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_anno15">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno15<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_anno15">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno15<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_anno16">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno16<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_anno16">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno16<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_anno17">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno17<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_anno17">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno17<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y++;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_anno18">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno18<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_anno18">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno18<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y = y + 2;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_anno20">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno20<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_anno20">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno20<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y = y + 10;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_anno30">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno30<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_anno30">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno30<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y = y + 10;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_anno40">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno40<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_anno40">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno40<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y = y + 10;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_anno50">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno50<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_anno50">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno50<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y = y + 10;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_anno60">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno60<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_anno60">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno60<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y = y + 10;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_anno70">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno70<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_anno70">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno70<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y = y + 10;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_anno80">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno80<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_anno80">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno80<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y = y + 10;
                                      %>
                                      <logic:equal value="1" name="usuariovacunas" property="vacu_edad_anno90">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno90<%=x%>" checked="checked" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <logic:equal value="0" name="usuariovacunas" property="vacu_edad_anno90">
                                        <td>
                                          <INPUT type="checkbox" name="vacu_edad_anno90<%=x%>" title="<bean:write name="usuariovacunas" property="vacu_des"/>:<bean:message key="504"/> <%=y%>" />
                                        </td>
                                      </logic:equal>
                                      <%
                                      	y = 1;
                                      %>
                                      <td align="center">
                                        <logic:notEqual name="usuariovacunas" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="vacu_vac_cod">
                                          <IMG border="0" src="<%=request.getContextPath()%>/images/eliminar.gif" onClick="remove_vacuna('<%=x%>','<%=request.getAttribute("vacu_des" + x)%>')" width="17" height="17" style="cursor: hand" alt="<bean:message key="global.button.borrar"/>" />
                                        </logic:notEqual>
                                        <logic:equal name="usuariovacunas" value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>" property="vacu_vac_cod">
                                          <IMG border="0" src="<%=request.getContextPath()%>/images/eliminar.gif" onClick="remove_vacuna('<%=x%>','<bean:write name="usuariovacunas" property="vacu_des" scope="page"/>')" width="17" height="17" style="cursor: hand" alt="<bean:message key="global.button.borrar"/>" />
                                        </logic:equal>
                                      </td>
                                    </tr>


                                    <%
                                    	x++;
                                    %>
                                  </logic:iterate>
                                </table>
                              </td>
                            </tr>
                            <tr>
                              <td>
                                &nbsp;
                              </td>
                            </tr>
                            <tr>
                              <td colspan="3" align="center">
                                <INPUT type="button" onClick="add_vacuna(<%=x%>)" class="sbttn" value="<bean:message key="global.button.adicionar"/>">
                              </td>
                            </tr>
                            <tr>
                              <td>
                                &nbsp;
                              </td>
                            </tr>
                            <tr>
                              <TD colspan="3">
                                <table width="100%">
                                  <tr>
                                    <TD colspan="2" class="view_item">
                                      <bean:message key="7258" />
                                    </TD>
                                  </tr>
                                  <tr>
                                    <TD class="view_item">
                                      &nbsp;
                                    </TD>
                                    <td>
                                      <html:text property="grupu_dias_antes" maxlength="2" size="3" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)" />
                                    </td>
                                  </tr>
                                  <tr>
                                    <TD>
                                      &nbsp;
                                    </TD>
                                  </tr>
                                  <tr>
                                    <TD colspan="2" class="view_item">
                                      <bean:message key="7259" />
                                    </TD>
                                  </tr>
                                </table>
                              </TD>
                            </tr>
                          </table>
                        </td>
                      </tr>
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
                                <INPUT type="button" onClick="enviar('<%=request.getContextPath()%>/Control_Vacunas/save.do')" class="sbttn" value="<bean:message key="136"/>">
                              </td>
                            </tr>
                            <tr>
                              <td>

                                <div align="right" class="imprimir">
                                  <img alt="<bean:message key="global.imprimiralt"/>" src="<%=request.getContextPath()%>/images/print.gif" border="0" height="22" width="20">
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
  <script>tab_charge('vacunas','family');</script>
</html:form>




