
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="com.servidoctor.seguridad.model.UsuarioCar,com.servidoctor.constantes.IConstantes"%>
<html>
	<head>
		
    <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/style/estilo_car.css" type="text/css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/style/examples.css" type="text/css" >
    	<link rel="stylesheet" href="<%=request.getContextPath()%>/style/screen.css" type="text/css" >
		<SCRIPT language="JavaScript" src="<%=request.getContextPath()%>/script/funciones.js"></SCRIPT>
		<script language="JavaScript">
<!--
function enviar(action) {		
		form1.action=action
		form1.method='post'
		form1.target='a3'
		setCookie('OdometroCero',0);
		form1.submit()
	}

function enviar2(action) {		
		form1.action=action
		form1.method='post'
		form1.target='a3'
		form1.submit()
	}

function getCode(){
	codigo=4;
	alert(codigo);
	return codigo;
}



function menuDesp(Lay){
 Cab=eval(Lay.id)
 with (Cab.style) 
 if (display=="none")
    display="" 
   else 
    display="none" 
}

function func(nam) {
  eval("form1." + nam + ".style.backgroundColor = '#0099FF'")
  eval("form1." + nam + ".style.color = '#ffffff'")
  eval("form1." + nam + ".style.borderColor = '#0066D3'")
  //eval("form1." + nam + ".style.fontWeight = 'bold'")
}
function func2(nam) {
  eval("form1." + nam + ".style.backgroundColor = '#0066D3'")
  eval("form1." + nam + ".style.color = '#FFFFCC'")
  eval("form1." + nam + ".style.borderColor = '#0099FF'")
  //eval("form1." + nam + ".style.fontWeight = 'normal'")
}

function funcsub(nam) {
  //eval("form1." + nam + ".style.backgroundColor = 'transparent'")
  //eval("form1." + nam + ".style.color = '#333333'")
  eval("form1." + nam + ".style.fontWeight = 'bold'")
}
function funcsub2(nam) {
  eval("form1." + nam + ".style.backgroundColor = 'transparent'")
  //eval("form1." + nam + ".style.color = '#666666'")
  eval("form1." + nam + ".style.fontWeight = 'normal'")
}

function MM_openBrWindow(theURL,winName,features) { //v2.0
  window.open(theURL,winName,features);
}
//-->
</script>

		<style>
.usuariomenu{
	font-size:10px;
	font-family:verdana; 
	color:#ffffff;
	font-weight:bold;
	height:22px;
	padding: 5 5 5 5;
	text-transform:uppercase;
}
</style>

	</head>
	<body bgcolor="#CCCCCC" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" scroll="no" background="<%=request.getContextPath()%>/images/fondo_menu_car.jpg" onkeydown="if (event.keyCode==8) {event.keyCode=0; return event.keyCode }">
		<form name="form1" method="post" action="<%=request.getContextPath()%>/Car.do">
			<table width="200px" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td>
						<!--  <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
							<tr>
								<td class="usuariomenu">
									<bean:message key="main.welcome" />
									:
									<BR>
									<%=((UsuarioCar) request.getSession().getAttribute(
							"usuarioCar")).getUsuc_usuario()%>

								</td>
							</tr>

						</table>-->
					</TD>
				</TR>
				<tr>
					<td>
						<!-- <input class=boton type="button" name="bt01" value="  <bean:message key="1806"/> 1" onMouseover="func(this.name)" onMouseout="func2(this.name)" onclick="menuDesp(submen1)">-->
					</td>
				</tr>
				<tr>
					<td style="margin-top:10px;">
						<!-- <input type="image" src="//=request.getContextPath()%>/images/bot_family.jpg" style="border-style: none; margin-left: 4px; cursor: pointer; margin-top: 5px"> --> 
						<!-- <input type="image" src="//=request.getContextPath()%>/images/bot_pets.jpg" style="border-style: none; margin-left: 4px; cursor: pointer; margin-top: 2px"> -->
						<!-- <input type="image" src="//=request.getContextPath()%>/images/bot_car.jpg" style="border-style: none; margin-left: 4px; cursor: pointer; margin-top: 2px" onClick="top.location.href='<%=request.getContextPath()%>/Car.do'" title="Ir a SERVIDOCTOR CAR"> -->
						<div id="submen8">
							<input class="boton2" type="button" name="bt61" value="<bean:message key="9918"/>" onMouseover="funcsub(this.name)" onMouseout="funcsub2(this.name)" onClick="enviar('<%=request.getContextPath()%>/DatosVehiculo/aspectos_generales.do');">
							<input class="boton2" type="button" name="bt70" value="<bean:message key="9919"/>" onMouseover="funcsub(this.name)" onMouseout="funcsub2(this.name)" onClick="enviar('<%=request.getContextPath()%>/DatosVehiculo/odometro.do');">
							<input class="boton2" type="button" name="bt71" value="<bean:message key="9920"/>" onMouseover="funcsub(this.name)" onMouseout="funcsub2(this.name)" onClick="enviar('<%=request.getContextPath()%>/DatosVehiculo/dellist.do');">						
							<input class="boton2" type="button" name="bt73" value="<bean:message key="9921"/>" onMouseover="funcsub(this.name)" onMouseout="funcsub2(this.name)" onClick="enviar('<%=request.getContextPath()%>/DatosVehiculo/editcontroles.do');">
							<input class="boton2" type="button" name="bt74" value="&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="9922"/>" onMouseover="funcsub(this.name)" onMouseout="funcsub2(this.name)" onClick="enviar('<%=request.getContextPath()%>/DatosVehiculo/editcontroles.do');setCookie('editvehiculo',1);">
							<input class="boton2" type="button" name="bt75" value="&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="9923"/>" onMouseover="funcsub(this.name)" onMouseout="funcsub2(this.name)" onClick="enviar('<%=request.getContextPath()%>/DatosVehiculo/editcontroles.do');setCookie('editvehiculo',2);">
							<input class="boton2" type="button" name="bt76" value="&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="9924"/>" onMouseover="funcsub(this.name)" onMouseout="funcsub2(this.name)" onClick="enviar('<%=request.getContextPath()%>/DatosVehiculo/editcontroles.do');setCookie('editvehiculo',9);">
							<input class="boton2" type="button" name="bt77" value="&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="9925"/>" onMouseover="funcsub(this.name)" onMouseout="funcsub2(this.name)" onClick="enviar('<%=request.getContextPath()%>/DatosVehiculo/editcontroles.do');setCookie('editvehiculo',3);">
							<input class="boton2" type="button" name="bt78" value="&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="9926"/>" onMouseover="funcsub(this.name)" onMouseout="funcsub2(this.name)" onClick="enviar('<%=request.getContextPath()%>/DatosVehiculo/editcontroles.do');setCookie('editvehiculo',4);">
							<input class="boton2" type="button" name="bt79" value="&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="9927"/>" onMouseover="funcsub(this.name)" onMouseout="funcsub2(this.name)" onClick="enviar('<%=request.getContextPath()%>/DatosVehiculo/editcontroles.do');setCookie('editvehiculo',7);">
							<input class="boton2" type="button" name="bt80" value="&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="9928"/>" onMouseover="funcsub(this.name)" onMouseout="funcsub2(this.name)" onClick="enviar('<%=request.getContextPath()%>/DatosVehiculo/editcontroles.do');setCookie('editvehiculo',10);">
							<input class="boton2" type="button" name="bt81" value="&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="9929"/>" onMouseover="funcsub(this.name)" onMouseout="funcsub2(this.name)" onClick="enviar('<%=request.getContextPath()%>/DatosVehiculo/editcontroles.do');setCookie('editvehiculo',5);">
							<input class="boton2" type="button" name="bt82" value="&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="9930"/>" onMouseover="funcsub(this.name)" onMouseout="funcsub2(this.name)" onClick="enviar('<%=request.getContextPath()%>/DatosVehiculo/editcontroles.do');setCookie('editvehiculo',6);">
							<input class="boton2" type="button" name="bt83" value="&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="9931"/>" onMouseover="funcsub(this.name)" onMouseout="funcsub2(this.name)" onClick="enviar('<%=request.getContextPath()%>/DatosVehiculo/editcontroles.do');setCookie('editvehiculo',8);">
							
							<input class="boton2" type="button" name="bt62" value="<bean:message key="9932"/>" onMouseover="funcsub(this.name)" onMouseout="funcsub2(this.name)" onClick="enviar('<%=request.getContextPath()%>/DatosVehiculo/curva.do');">							
							<input class="boton2" type="button" name="bt13" value="<bean:message key="9933"/>" onMouseover="funcsub(this.name)" onMouseout="funcsub2(this.name)" onClick="top.a3.location='rangosReportesCar.jsp'; ">
						</div>

            <input class="boton" type="button" name="bt11" value="<bean:message key="9620"/>"
              style="background-image: url('<%=request.getContextPath()%>/images/salseg.gif'); padding-left: 22px; height: 22px; margin-top: 5px;"
              onMouseOver="func(this.name)" onMouseOut="func2(this.name)" onClick="logout()">
          </td>
				</tr>
				

			</table>
		</form>

	</body>
</html>
