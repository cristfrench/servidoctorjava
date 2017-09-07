<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.List"%>

<SCRIPT>
function enviar()
{
     if(document.forms[0].gasv_descripcion.value==''){
         alert('<bean:message key="5031" />');
         document.forms[0].gasv_descripcion.focus();
         return false;
      }
      if(document.forms[0].gasv_valor.value=='0' || document.forms[0].gasv_valor.value==''){
         alert('<bean:message key="5034" />');
         document.forms[0].costomes.focus();
         return false;
      } 
       if(DiferenciaFechas()<=0) {
   			alert('<bean:message key="3530" />');
   			document.forms[0].gasv_fechaini.focus();
   			return false
   	   }

	convertirACampo('cDia1', 'cMes1', 'cAno1', 'gasv_fechaini');
	convertirACampo('cDia2', 'cMes2', 'cAno2', 'gasv_fechafin');
	
	document.forms[0].action="<%=request.getContextPath()%>/DatosVehiculo/Popup/transferir_gastos.do"
	document.forms[0].target='a3'
	top.close();
	actualiza_popup_abierto();
	document.forms[0].submit();
}

function DiferenciaFechas() {	  
  		//Obtiene objetos Date
		var miFecha1 = new Date(document.forms[0].cAno1.value, document.forms[0].cMes1.value, document.forms[0].cDia1.value);
   		var miFecha2 = new Date(document.forms[0].cAno2.value, document.forms[0].cMes2.value, document.forms[0].cDia2.value);

   		//Resta fechas y retorna el gasv_valor
   		var diferencia = miFecha2.getTime() - miFecha1.getTime();
   		return diferencia;
	}


</SCRIPT>

<html:form target="_self" action="/DatosVehiculo/Popup/add_gastos.do">
	<table border="0" cellpadding="0" cellspacing="0" align="center" width="500">
		<tr>
			<TD>
				<table border="0" id="tab2" cellspacing="0" cellpadding="0" width="100%">
					<tr>
						<td colspan="2">
							<img src="<%=request.getContextPath()%>/images/int_tit_car.gif">
							<HR>
					</tr>
					<tr>
						<TD colspan="2" class="tdtitle">
							&nbsp;
						</td>
					</tr>
					<tr>
						<TD class="tdOverNameOption">
							<bean:message key="3593" />
							&nbsp;
							<%=session.getAttribute( "GASTOSVEHICULOSNOANUALES" ) != null
						&& ( ( List ) session.getAttribute( "GASTOSVEHICULOSNOANUALES" ) ).size() > 0 ? ( ( List ) session
						.getAttribute( "GASTOSVEHICULOSNOANUALES" ) ).size() + 1 : 1%>
						</TD>
						<TD class="tdOverNameOption">
							<bean:message key="global.button.adicionar" />
							&nbsp;
							<bean:message key="3523" />
						</TD>
					</tr>
					<TR>
						<TD>
							&nbsp;
						</TD>
					</TR>
					<tr>
						<TD colspan="4" class="view_item">
							<bean:message key="7436" />
							&nbsp;
							<BR>
						</TD>
					</tr>
					<TR>
						<TD>
							&nbsp;
						</TD>
					</TR>
					<tr>
						<TD class="view_item" align="left">
							<bean:message key="1099" />
							&nbsp;&nbsp;
						</TD>
						<TD align="left" class="tdContentText">
							<html:text property="gasv_descripcion" maxlength="80" size="40" styleClass="sel" />
						</TD>
					</tr>
					<tr>
						<TD class="view_item">
							<bean:message key="6001" />
							&nbsp;&nbsp;
						</TD>
						<TD class="tdContentText">
							<html:hidden property="gasv_fechaini" styleId="gasv_fechaini" />
							<SCRIPT language="JavaScript">obtenerCamposFecha3('cDia1', 'cMes1', 'cAno1', 'gasv_fechaini');</SCRIPT>
						</TD>
					</tr>
					<tr>
						<TD class="view_item">
							<bean:message key="6002" />
							&nbsp;&nbsp;
						</TD>
						<TD class="tdContentText">
							<html:hidden property="gasv_fechafin" styleId="gasv_fechafin" />
							<SCRIPT language="JavaScript">obtenerCamposFechaFuturo2('cDia2', 'cMes2', 'cAno2', 'gasv_fechafin',10);</SCRIPT>
						</TD>
					</tr>
					<tr>
						<TD class="view_item" align="left">
							<bean:message key="1101" />
							&nbsp;
							<bean:message key="3519" />
							&nbsp;
							<bean:message key="3569" />
							&nbsp;&nbsp;
						</TD>
						<TD align="left" class="tdContentText">
							<html:text property="gasv_valor" maxlength="10" onkeyup="isFloat(this, 10, 2);" onblur="isFloat(this, 10, 2);" size="20" styleClass="sel"
								onfocus="this.select()" />
						</TD>
					</tr>
					<tr>
						<TD colspan="2">
							&nbsp;
						</TD>
					</tr>
					<tr>
						<TD colspan="2">
							&nbsp;
						</TD>
					</tr>
					<tr>
						<TD colspan="2">
							<hr />
						</TD>
					</tr>
					<tr>
						<TD colspan="2" align="center">
							<INPUT type="button" onclick="enviar()" class="sbttn" value="<bean:message key="global.button.aceptar"/>">
						</TD>
					</tr>
				</table>
			</TD>
		</tr>
	</table>
</html:form>