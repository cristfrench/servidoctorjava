<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<SCRIPT>

function enviarD(){
      if(document.forms[0].impv_descripcion.value==''){
         alert('<bean:message key="5037" />');
         document.forms[0].impv_descripcion.focus();
         return false;
      }
      
      if(!DiferenciaFechas1()) {
   			alert('<bean:message key="3530" />');
   			document.forms[0].impv_fechapago.focus();
   			return false
   	   }
   	   
	convertirACampo('cDia1', 'cMes1', 'cAno1', 'impv_fechapago');
	convertirACampo('cDia2', 'cMes2', 'cAno2', 'impv_vigenciahasta');
	document.forms[0].action="<%=request.getContextPath()%>/DatosVehiculo/Popup/transferir_impuesto.do"
	document.forms[0].target='a3'
	top.close();
	actualiza_popup_abierto();
	document.forms[0].submit();
}

	function DiferenciaFechas1() {
  		//Obtiene objetos Date
		var miFecha1 = new Date(document.forms[0].cAno1.value, document.forms[0].cMes1.value, document.forms[0].cDia1.value);
   		var miFecha2 = new Date(document.forms[0].cAno2.value, document.forms[0].cMes2.value, document.forms[0].cDia2.value);
		var miFecha3 = new Date();
   		//Resta fechas y retorna el valor
   		var diferencia = miFecha2.getTime() - miFecha1.getTime();
 		var diferencia2 = miFecha2.getTime() - miFecha3.getTime();
 		if(diferencia<=0 || diferencia2<=0){
 			return false;
 		}
   		return true;

	}
	
</SCRIPT>
<html:form target="_self" action="/DatosVehiculo/Popup/add_impuesto.do">
	<input type="hidden" name="num_impuesto" value="<%=request.getParameter( "num_impuesto" )%>" />
	<html:hidden property="impv_veh_cod" />
	<html:hidden property="impv_cod" />
	<table border="0" cellpadding="0" cellspacing="0" align="center" width="550">
		<tr>
			<TD>
				<br>
				<br>
				<br>
				<table border="0" id="tab2" cellspacing="0" cellpadding="0" width="100%">
					<tr>
						<td colspan="2">
							<img src="<%=request.getContextPath()%>/images/int_tit_car.gif">
					</tr>
					<tr>
						<TD colspan="2" class="tdtitle">
							<hr />
						</td>
					</tr>
					<tr>
						<TD class="tdOverNameOption">
							Impuesto &nbsp;
							<%=Integer.parseInt( request.getParameter( "num_impuesto" ) ) + 1%>
						</TD>
						<TD class="tdOverNameOption">
							<bean:message key="global.button.editar" />
							&nbsp;
							<bean:message key="3526" />
						</TD>
					</tr>
					<tr>
						<TD colspan="2" class="view_item">
							&nbsp;
							<bean:message key="7427" />
						</TD>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
					</tr>
					<tr>
						<TD class="view_item">
							<bean:message key="1102" />
							&nbsp;&nbsp;
						</TD>
						<TD class="tdContentText">
							<html:text name="impuestoVehiculoForm" property="impv_descripcion" styleClass="sel" maxlength="80" size="40" />
						</TD>
					</tr>
					<tr>
						<TD class="view_item">
							<bean:message key="1109" />
							&nbsp;&nbsp;
						</TD>
						<TD class="tdContentText">
							<html:hidden name="impuestoVehiculoForm" property="impv_fechapago" styleId="impv_fechapago"/>
							<SCRIPT language="JavaScript">obtenerCamposFecha('cDia1', 'cMes1', 'cAno1', 'impv_fechapago');</SCRIPT>
						</TD>
					</tr>
					<tr>
						<TD class="view_item">
							<bean:message key="1107" />
							&nbsp;&nbsp;
						</TD>
						<TD class="tdContentText">
							<html:hidden name="impuestoVehiculoForm" property="impv_vigenciahasta" styleId="impv_vigenciahasta" />
							<SCRIPT language="JavaScript">obtenerCamposFechaFuturo('cDia2', 'cMes2', 'cAno2', 'impv_vigenciahasta',10);</SCRIPT>
						</TD>
					</tr>
					<tr>
						<TD colspan="2">
							&nbsp;
						</TD>
					</tr>
					<tr>
						<TD colspan="2">
							<bean:message key="7443" />
						</TD>
					</tr>
					<tr>
						<TD colspan="2">
							&nbsp;
						</TD>
					</tr>
					<tr>
						<TD colspan="2">
							<HR>
						</TD>
					</tr>
					<tr>
						<TD colspan="2" align="center">
							<INPUT type="button" onClick="enviarD()" class="sbttn" value="<bean:message key="global.button.aceptar"/>">
						</TD>
					</tr>
				</table>
			</TD>
		</tr>
	</table>
</html:form>
