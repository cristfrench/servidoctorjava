
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<SCRIPT>
function actualizar(){
	document.forms[0].action="<%=request.getContextPath()%>/DatosVehiculo/Popup/edit_seguro.do?change=1"
	document.forms[0].submit();
}

function enviar2(){
      if(document.forms[0].sveh_ciaaseg.value==''){
         alert('<bean:message key="5081" />');
         document.forms[0].sveh_ciaaseg.focus();
         return false;
      }
<%--      if(document.forms[0].sveh_ageemisor.value==''){
         alert('<bean:message key="5082" />');
         document.forms[0].sveh_ageemisor.focus();
         return false;
      }
      if(document.forms[0].sveh_nomcont.value==''){
         alert('<bean:message key="5083" />');
         document.forms[0].sveh_nomcont.focus();
         return false;
      }--%>
      if(document.forms[0].sveh_mail.value!='' && !mail(document.forms[0].sveh_mail)){
      	alert('<bean:message key="5084" />');
      	document.forms[0].sveh_mail.focus();
      	return false;
      }      
      if(document.forms[0].sveh_fijoindicativopais.value==''){
         //alert('<bean:message key="5083" />');
         document.forms[0].sveh_fijoindicativopais.value='0';
         //return false;
      }
      if(document.forms[0].sveh_fijoindicativociudad.value==''){
         //alert('<bean:message key="5083" />');
         document.forms[0].sveh_fijoindicativociudad.value='0';
         //return false;
      }
      if(document.forms[0].sveh_fijonumero.value==''){
         //alert('<bean:message key="5083" />');
         document.forms[0].sveh_fijonumero.value='0';
         //return false;
      }
      if(document.forms[0].sveh_indpais1.value==''){
         //alert('<bean:message key="5083" />');
         document.forms[0].sveh_indpais1.value='0';
         //return false;
      }
      if(document.forms[0].sveh_indciudad1.value==''){
         //alert('<bean:message key="5083" />');
         document.forms[0].sveh_indciudad1.value='0';
         //return false;
      }
      if(document.forms[0].sveh_telefono1.value==''){
         //alert('<bean:message key="5083" />');
         document.forms[0].sveh_telefono1.value='0';
         //return false;
      }
      if(document.forms[0].sveh_movilindicativopais.value==''){
         //alert('<bean:message key="5083" />');
         document.forms[0].sveh_movilindicativopais.value='0';
         //return false;
      }
      if(document.forms[0].sveh_movilnumero.value==''){
         //alert('<bean:message key="5083" />');
         document.forms[0].sveh_movilnumero.value='0';
         //return false;
      }
      if(document.forms[0].sveh_responsabilidad.value==''){
         //alert('<bean:message key="5096" />');
         document.forms[0].sveh_responsabilidad.value='0';
         //return false;
      } 
      if(document.forms[0].sveh_deducible.value==''){
         //alert('<bean:message key="5081" />');
         document.forms[0].sveh_deducible.value='0';
         //return false;
      }
      if(document.forms[0].sveh_juridica.value==''){
         //alert('<bean:message key="5097" />');
         document.forms[0].sveh_juridica.value='0';
         //return false;
      }  
      if(document.forms[0].sveh_perdidaparcialdanos.value==''){
         //alert('<bean:message key="5098" />');
         document.forms[0].sveh_perdidaparcialdanos.value='0';
         //return false;
      }  
      if(document.forms[0].sveh_perdidatotaldanos.value==''){
         //alert('<bean:message key="5099" />');
         document.forms[0].sveh_perdidatotaldanos.value='0';
         //return false;
      }  
      if(document.forms[0].sveh_perdidahurto.value==''){
         //alert('<bean:message key="5100" />');
         document.forms[0].sveh_perdidahurto.value='0';
         //return false;
      }
      if(document.forms[0].sveh_amparodanos.value==''){
         //alert('<bean:message key="5101" />');
         document.forms[0].sveh_amparodanos.value='0';
         //return false;
      }  
      if(document.forms[0].sveh_amparocivil.value==''){
         //alert('<bean:message key="5102" />');
         document.forms[0].sveh_amparocivil.value='0';
         //return false;
      }  
      if(document.forms[0].sveh_transpordedanos.value==''){
         //alert('<bean:message key="5103" />');
         document.forms[0].sveh_transpordedanos.value='0';
         //return false;
      }  
      if(document.forms[0].sveh_transportehurto.value==''){
         //alert('<bean:message key="5104" />');
         document.forms[0].sveh_transportehurto.value='0';
         //return false;
      }  
      if(document.forms[0].sveh_asistenciaviaje.value==''){
         //alert('<bean:message key="5105" />');
         document.forms[0].sveh_asistenciaviaje.value='0';
         //return false;
      }  
      if(document.forms[0].sveh_terremoto.value==''){
         //alert('<bean:message key="5106" />');
         document.forms[0].sveh_terremoto.value='0';
         //return false;
      }  
      if(document.forms[0].sveh_numpoliza.value==''){
         //alert('<bean:message key="5107" />');
         document.forms[0].sveh_numpoliza.value='0';
         //return false;
      }
      
      convertirACampo('cDia2', 'cMes2', 'cAno2', 'sveh_fecvigenchasta'); 
       
document.forms[0].action="<%=request.getContextPath()%>/DatosVehiculo/Popup/transferir_seguro.do"
document.forms[0].target='a3'
top.close();
actualiza_popup_abierto();
document.forms[0].submit();

}

</SCRIPT>
<html:form target="_self" action="/DatosVehiculo/Popup/edit_seguro.do">
	<html:hidden property="sveh_cod" />
	<html:hidden property="sveh_veh_cod" />
	<html:hidden property="sveh_mails_enviados" />
	<html:hidden property="sveh_grup_cod" />
	<html:hidden property="sveh_ultimo_mail" />
	<input type="hidden" name="num_seguro" value="<%=request.getParameter( "num_seguro" )%>" />
	<table border="0" cellpadding="0" cellspacing="0" align="center" width="95%">
		<tr>
			<TD>
				<table border="0" id="tab2" cellspacing="0" cellpadding="0" width="100%">
					<tr>
						<td colspan="5">
							<img src="<%=request.getContextPath()%>/images/int_tit_car.gif">
							<hr>
						</td>
					</tr>
					<tr>
						<TD colspan="2" class="tdOverNameOption">
							<bean:message key="3528" />
							&nbsp;
							<%=Integer.parseInt( request.getParameter( "num_seguro" ) ) + 1%>
						</TD>
						<TD colspan="3" class="tdOverNameOption">
							<bean:message key="global.button.adicionar" />
							&nbsp;
							<bean:message key="3528" />
						</TD>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
					</tr>
					<tr>
						<TD colspan="5" class="view_item">
							<bean:message key="7423" />
							&nbsp;
						</TD>
					<tr>
						<td>
							&nbsp;
						</td>
					</tr>
					<tr>
						<TD class="view_item">
							<bean:message key="3518" />
							&nbsp;&nbsp;
						</TD>
						<TD>
							<html:text name="segurosVehiculosForm" property="sveh_ciaaseg" maxlength="40" size="30" styleClass="sel" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</TD>
						<TD width="5%">
							&nbsp;&nbsp;
							<BR>
							&nbsp;
						</TD>
						<TD class="view_item">
							<bean:message key="3517" />
							&nbsp;&nbsp;
						</TD>
						<TD>
							<html:text name="segurosVehiculosForm" styleClass="sel" property="sveh_ageemisor" maxlength="60" size="30" />
						</TD>
					</tr>
					<tr>
						<TD class="view_item">
							<bean:message key="720" />
							<br>
							<bean:message key="721" />
							&nbsp;&nbsp;
						</TD>
						<TD class="view_item">
							<html:select name="segurosVehiculosForm" property="sveh_pais_cod" styleClass="select" onchange="actualizarCiudades(this.value)">
								<html:options collection="PAISES" labelProperty="pais_des" property="pais_cod" />
							</html:select>
							<html:select name="segurosVehiculosForm" property="sveh_ciu_cod" styleClass="select" styleId="ciudadesContent">
								<html:options collection="CIUDADES" labelProperty="ciu_des" property="ciu_cod" />
							</html:select>
							&nbsp;&nbsp;&nbsp;
						</TD>
						<TD>
							&nbsp;
							<BR>
							&nbsp;&nbsp;
						</TD>
						<TD class="view_item">
							<bean:message key="1132" />
							&nbsp;&nbsp;
						</TD>
						<TD class="tdContentText">
							<html:text name="segurosVehiculosForm" onfocus="this.select()" property="sveh_numpoliza" maxlength="45" size="30" styleClass="sel" />
						</TD>
					</tr>
					<tr>
						<TD class="view_item">
							<bean:message key="1096" />
							&nbsp;&nbsp;
						</TD>
						<TD class="tdContentText">
							<html:text name="segurosVehiculosForm" styleClass="sel" property="sveh_nomcont" maxlength="60" size="30" />
						</TD>
						<TD>
							<BR>
							&nbsp;&nbsp;&nbsp;
						</TD>
						<TD class="view_item">
							<bean:message key="19" />
							&nbsp;&nbsp;
						</TD>
						<TD class="tdContentText">
							<html:text name="segurosVehiculosForm" property="sveh_mail" maxlength="30" size="30" styleClass="sel" />
						</TD>
					</tr>
					<tr>
						<TD class="view_item">
							<bean:message key="5076" />
							&nbsp;&nbsp;
						</TD>
						<TD class="view_item">
							<html:text name="segurosVehiculosForm" onfocus="this.select()" property="sveh_fijoindicativopais" styleClass="sel" maxlength="3" size="5"
								onkeyup="isNatural(this);" onblur="isNatural(this);" />
							<bean:message key="1138" />
						</TD>
						<TD>
							&nbsp;&nbsp;
							<BR>
						</TD>
						<TD class="view_item">
							<bean:message key="1139" />
							&nbsp;&nbsp;
							<html:text styleClass="sel" name="segurosVehiculosForm" onfocus="this.select()" property="sveh_fijoindicativociudad" maxlength="3" size="5"
								onkeyup="isNatural(this);" onblur="isNatural(this);" />
						</TD>
						<TD class="view_item">
							&nbsp;&nbsp;
							<bean:message key="1140" />
							&nbsp;
							<html:text styleClass="sel" name="segurosVehiculosForm" onfocus="this.select()" property="sveh_fijonumero" maxlength="15" size="15"
								onkeyup="isNatural(this);" onblur="isNatural(this);" />
						</TD>
					</tr>
					<tr>
						<TD class="view_item">
							<bean:message key="5078" />
							&nbsp;&nbsp;
						</TD>
						<TD class="view_item">
							<html:text name="segurosVehiculosForm" onfocus="this.select()" property="sveh_indpais1" styleClass="sel" maxlength="3" size="5"
								onkeyup="isNatural(this);" onblur="isNatural(this);" />
							<bean:message key="1138" />
						</TD>
						<TD>
							<BR>
							&nbsp;&nbsp;&nbsp;
						</TD>
						<TD class="view_item">
							<bean:message key="1136" />
							&nbsp;&nbsp;
							<html:text name="segurosVehiculosForm" styleClass="sel" onfocus="this.select()" property="sveh_indciudad1" maxlength="3" size="5"
								onkeyup="isNatural(this);" onblur="isNatural(this);" />
						</TD>
						<TD class="view_item">
							&nbsp;&nbsp;
							<bean:message key="1137" />
							&nbsp;&nbsp;
							<html:text name="segurosVehiculosForm" onfocus="this.select()" property="sveh_telefono1" maxlength="15" size="15" styleClass="sel"
								onkeyup="isNatural(this);" onblur="isNatural(this);" />
						</TD>
					</tr>
					<TR>
						<TD class="view_item">
							<bean:message key="5077" />
							&nbsp;&nbsp;
						</TD>
						<TD class="view_item">
							<html:text name="segurosVehiculosForm" onfocus="this.select()" property="sveh_movilindicativopais" styleClass="sel" maxlength="3" size="5"
								onkeyup="isNatural(this);" onblur="isNatural(this);" />
							<bean:message key="1138" />
						</TD>
						<td></td>
						<TD class="view_item">
							&nbsp;
							<BR>
							&nbsp;
						</TD>
						<TD class="view_item">
							&nbsp;&nbsp;
							<bean:message key="1137" />
							&nbsp;&nbsp;
							<html:text name="segurosVehiculosForm" onfocus="this.select()" property="sveh_movilnumero" styleClass="sel" maxlength="15" size="15"
								onkeyup="isNatural(this);" onblur="isNatural(this);" />
						</TD>
					</TR>
					<tr>
						<TD class="view_item">
							<bean:message key="1092" />
							&nbsp;&nbsp;
						</TD>
						<TD class="tdContentText">
							<html:hidden property="sveh_fecvigenchasta" styleId="sveh_fecvigenchasta" />
							<SCRIPT language="JavaScript">obtenerCamposFechaFuturo('cDia2', 'cMes2', 'cAno2', 'sveh_fecvigenchasta',10);</SCRIPT>
						</td>
						<TD>
							<BR>
							&nbsp;&nbsp;&nbsp;
						</TD>
						<TD class="view_item">
							<bean:message key="3565" />
							&nbsp;&nbsp;
						</TD>
						<TD class="tdContentText">
							<html:text name="segurosVehiculosForm" styleClass="sel" onfocus="this.select()" property="sveh_deducible" maxlength="8" size="30"
								onkeyup="isFloat(this, 8, 2);" onblur="isFloat(this, 8, 2);" />
						</TD>
					</tr>
					<tr>
						<TD colspan="5" style="background-color: #F1F5FA">
							<bean:message key="3566" />
							&nbsp;
							<BR>
						</TD>
					</tr>
					<tr>
						<TD class="view_item">
							<bean:message key="1122" />
							&nbsp;&nbsp;
						</TD>
						<TD class="tdContentText">
							<html:text name="segurosVehiculosForm" onfocus="this.select()" property="sveh_juridica" maxlength="10" size="30" styleClass="sel"
								onkeyup="isFloat(this, 10, 2);" onblur="isFloat(this, 10, 2);" />
						</TD>
						<TD>
							<BR>
							&nbsp;&nbsp;&nbsp;
						</TD>
						<TD class="view_item">
							<bean:message key="1121" />
							&nbsp;&nbsp;
						</TD>
						<TD class="tdContentText">
							<html:text name="segurosVehiculosForm" onfocus="this.select()" property="sveh_responsabilidad" styleClass="sel" maxlength="10" size="30"
								onkeyup="isFloat(this, 10, 2);" onblur="isFloat(this, 10, 2);" />
						</TD>
					</tr>
					<tr>
						<TD class="view_item">
							<bean:message key="1124" />
							&nbsp;&nbsp;
						</TD>
						<TD class="tdContentText">
							<html:text name="segurosVehiculosForm" onfocus="this.select()" property="sveh_perdidatotaldanos" styleClass="sel" maxlength="10" size="30"
								onkeyup="isFloat(this, 10, 2);" onblur="isFloat(this, 10, 2);" />
						</TD>
						<TD>
							<BR>
							&nbsp;&nbsp;&nbsp;
						</TD>
						<TD class="view_item">
							<bean:message key="1123" />
							&nbsp;&nbsp;
						</TD>
						<TD class="tdContentText">
							<html:text name="segurosVehiculosForm" onfocus="this.select()" property="sveh_perdidaparcialdanos" styleClass="sel" maxlength="10" size="30"
								onkeyup="isFloat(this, 10, 2);" onblur="isFloat(this, 10, 2);" />
						</TD>
					</tr>
					<tr>
						<TD class="view_item">
							<bean:message key="1126" />
							&nbsp;&nbsp;
						</TD>
						<TD class="tdContentText">
							<html:text name="segurosVehiculosForm" onfocus="this.select()" property="sveh_amparodanos" maxlength="10" size="10" styleClass="sel"
								onkeyup="isFloat(this, 10, 2);" onblur="isFloat(this, 10, 2);" />
						</TD>
						<TD>
							<BR>
							&nbsp;&nbsp;&nbsp;
						</TD>
						<TD class="view_item">
							<bean:message key="1125" />
							&nbsp;&nbsp;
						</TD>
						<TD class="tdContentText">
							<html:text name="segurosVehiculosForm" onfocus="this.select()" property="sveh_perdidahurto" styleClass="sel" maxlength="10" size="30"
								onkeyup="isFloat(this, 10, 2);" onblur="isFloat(this, 10, 2);" />
						</TD>
					</tr>
					<tr>
						<TD class="view_item">
							<bean:message key="1128" />
							&nbsp;&nbsp;
						</TD>
						<TD class="tdContentText">
							<html:text name="segurosVehiculosForm" onfocus="this.select()" property="sveh_transpordedanos" maxlength="10" size="30" styleClass="sel"
								onkeyup="isFloat(this, 10, 2);" onblur="isFloat(this, 10, 2);" />
						</TD>
						<TD>
							<BR>
							&nbsp;&nbsp;&nbsp;
						</TD>
						<TD class="view_item">
							<bean:message key="1127" />
							&nbsp;&nbsp;
						</TD>
						<TD class="tdContentText">
							<html:text name="segurosVehiculosForm" onfocus="this.select()" property="sveh_amparocivil" maxlength="10" size="30" styleClass="sel"
								onkeyup="isFloat(this, 10, 2);" onblur="isFloat(this, 10, 2);" />
						</TD>
					</tr>
					<tr>
						<TD class="view_item">
							<bean:message key="1130" />
							&nbsp;&nbsp;
						</TD>
						<TD class="tdContentText">
							<html:text name="segurosVehiculosForm" onfocus="this.select()" property="sveh_asistenciaviaje" maxlength="10" size="30" styleClass="sel"
								onkeyup="isFloat(this, 10, 2);" onblur="isFloat(this, 10, 2);" />
						</TD>
						<TD>
							<BR>
							&nbsp;&nbsp;&nbsp;
						</TD>
						<TD class="view_item">
							<bean:message key="1129" />
							&nbsp;&nbsp;
						</TD>
						<TD class="tdContentText">
							<html:text name="segurosVehiculosForm" onfocus="this.select()" property="sveh_transportehurto" maxlength="10" size="30" styleClass="sel"
								onkeyup="isFloat(this, 10, 2);" onblur="isFloat(this, 10, 2);" />
						</TD>
					</tr>
					<tr>
						<TD class="view_item">
							<bean:message key="1131" />
							&nbsp;&nbsp;
						</TD>
						<TD class="tdContentText">
							<html:text name="segurosVehiculosForm" onfocus="this.select()" property="sveh_terremoto" maxlength="10" size="30" styleClass="sel"
								onkeyup="isFloat(this, 10, 2);" onblur="isFloat(this, 10, 2);" />
						</TD>
					</tr>
					<tr>
						<td class="view_item" colspan="5">
							&nbsp;

						</td>
					</tr>
					<tr>
						<td class="view_item" colspan="5">
							<bean:message key="7443" />
						</td>
					</tr>
					<tr>
						<TD colspan="5">
							<hr />
						</TD>
					</tr>
					<tr>
						<TD colspan="5" align="center">
							<INPUT type="button" onClick="enviar2()" class="sbttn" value="<bean:message key="global.button.aceptar"/>">
						</TD>
					</tr>
				</table>
			</TD>
		</tr>
	</table>
</html:form>
