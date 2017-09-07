<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="com.servidoctor.seguridad.model.UsuarioFamily,com.servidoctor.constantes.IConstantes"%>
<html>
	<head>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/style/estilo_family.css" type="text/css">
		<SCRIPT language="JavaScript" src="<%=request.getContextPath()%>/script/funciones.js"></SCRIPT>
		<script language="JavaScript">
<!--
	function enviar(action) {		
		form1.action=action
		form1.method='post'
		form1.target='a3'
		form1.submit()
	}

function menuDesp(Lay){
 Cab=eval(Lay.id)
 with (Cab.style) 
 if (display=="none")
    display="" 
   else 
    display="none" 
}

/*function func(nam) {
  eval("form1." + nam + ".style.backgroundColor = '#F4C400'")
  eval("form1." + nam + ".style.color = '#774700'")
  eval("form1." + nam + ".style.borderColor = '#D98200'")
}
function func2(nam) {
  eval("form1." + nam + ".style.backgroundColor = '#D98200'")
  eval("form1." + nam + ".style.color = '#FFFFFF'")
  eval("form1." + nam + ".style.borderColor = '#F4C400'")
}*/


function func(nam) {
  eval("form1." + nam + ".style.backgroundColor = '#F4C400'")
  eval("form1." + nam + ".style.color = '#774700'")
  eval("form1." + nam + ".style.borderColor = '#D98200'")
}
function func2(nam) {
  eval("form1." + nam + ".style.backgroundColor = '#D98200'")
  eval("form1." + nam + ".style.color = '#FFFFFF'")
  eval("form1." + nam + ".style.borderColor = '#F4C400'")
}

function funcsub(nam) {
  eval("form1." + nam + ".style.fontWeight = 'bold'")
}
function funcsub2(nam) {
  eval("form1." + nam + ".style.backgroundColor = 'transparent'")
  eval("form1." + nam + ".style.fontWeight = 'normal'")
}

function MM_openBrWindow(theURL,winName,features) { //v2.0
  window.open(theURL,winName,features);
}
//-->
</script>

		<style>
.usuariomenu {
	font-size: 10px;
	font-family: verdana;
	color: #ffffff;
	font-weight: bold;
	height: 22px;
	padding: 5 5 5 5;
	text-transform: uppercase;
}
</style>

	</head>

	<body bgcolor="#CCCCCC" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" scroll=no
		background="<%=request.getContextPath()%>/images/fondo_menu_family.jpg" onkeydown="if (event.keyCode==8) {event.keyCode=0; return event.keyCode }">
		<form name="form1" method="post" action="">
			<table width="200px" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td>
						<!--  <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
							<tr>
								<td class="usuariomenu">
									<bean:message key="main.welcome" />
									:
									<BR>
									<%=( ( UsuarioFamily ) request.getSession().getAttribute( "usuarioFamily" ) ).getUsuf_usuario()%>
								</td>
							</tr>

						</table>-->
					</TD>
				</TR>
				<tr>
					<td style="margin-top: 10px;">
						<!-- <input type="image" src="//=request.getContextPath()%>/images/bot_family.jpg"
              style="border-style: none; margin-left: 4px; cursor: pointer; margin-top: 5px"
              onclick="top.location.href='//=request.getContextPath()%>/Family.do'"
              title="Ir a SERVIDOCTOR FAMILY">-->
						<div id="submen4">
							 <input class=boton2 type="button" name="bt28" value="<bean:message key="3806"/>" onMouseOver="funcsub(this.name)"
								onMouseOut="funcsub2(this.name)" onclick="enviar('<%=request.getContextPath()%>/AspectosGenerales/aspectos_generales.do');">
							<input class=boton2 type="button" name="bt70" value="<bean:message key="9900"/>" onMouseOver="funcsub(this.name)"
								onMouseOut="funcsub2(this.name)" onclick="enviar('<%=request.getContextPath()%>/DatosPer/view.do');setCookie('datos_personales',1);">
							<input class=boton2 type="button" name="bt71" value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="9901"/>" onMouseOver="funcsub(this.name)"
								onMouseOut="funcsub2(this.name)" onclick="enviar('<%=request.getContextPath()%>/DatosPer/view.do');setCookie('datos_personales',1);">
							<input class=boton3 type="button" name="bt72" value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="9902"/>" onMouseOver="funcsub(this.name)"
								onMouseOut="funcsub2(this.name)" onclick="enviar('<%=request.getContextPath()%>/DatosPer/view.do');setCookie('datos_personales',2);">
							<input class=boton2 type="button" name="bt73" value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="9903"/>" onMouseOver="funcsub(this.name)"
								onMouseOut="funcsub2(this.name)" onclick="enviar('<%=request.getContextPath()%>/DatosPer/view.do');setCookie('datos_personales',3);" >
							<input class=boton3 type="button" name="bt74" value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="9904"/>" onMouseOver="funcsub(this.name)"
								onMouseOut="funcsub2(this.name)" onclick="enviar('<%=request.getContextPath()%>/DatosPer/view.do');setCookie('datos_personales',4);" >
							<input class=boton2 type="button" name="bt75" value="<bean:message key="9905"/>" onMouseOver="funcsub(this.name)"
								onMouseOut="funcsub2(this.name)"  onclick="enviar('<%=request.getContextPath()%>/Control_opto/view.do');">
							<input class=boton2 type="button" name="bt76" value="<bean:message key="9906"/>" onMouseOver="funcsub(this.name)"
								onMouseOut="funcsub2(this.name)"  onclick="enviar('<%=request.getContextPath()%>/Control_Odont/view.do');">
							<input class=boton2 type="button" name="bt77" value="<bean:message key="9907"/>" onMouseOver="funcsub(this.name)"
								onMouseOut="funcsub2(this.name)"  onclick="enviar('<%=request.getContextPath()%>/Control_Medico/view.do');">
							<input class=boton3 type="button" name="bt78" value="<bean:message key="9908"/>" onMouseOver="funcsub(this.name)"
								onMouseOut="funcsub2(this.name)"  onclick="enviar('<%=request.getContextPath()%>/Control_Vacunas/view.do');">
							<input class=boton2 type="button" name="bt79" value="<bean:message key="9909"/>" onMouseOver="funcsub(this.name)"
								onMouseOut="funcsub2(this.name)"  onclick="enviar('<%=request.getContextPath()%>/Control_Otro/view.do');">
							<input class=boton2 type="button" name="bt80" value="<bean:message key="9910"/>" onMouseOver="funcsub(this.name)"
								onMouseOut="funcsub2(this.name)" onClick="enviar('<%=request.getContextPath()%>/Histo_Medica/view.do');setCookie('histo_medica',1);" >
							<input class=boton2 type="button" name="bt81" value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="9911"/>" onMouseOver="funcsub(this.name)"
								onMouseOut="funcsub2(this.name)" onClick="enviar('<%=request.getContextPath()%>/Histo_Medica/view.do');setCookie('histo_medica',1);" >
							<input class=boton2 type="button" name="bt82" value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="9912"/>" onMouseOver="funcsub(this.name)"
								onMouseOut="funcsub2(this.name)" onClick="enviar('<%=request.getContextPath()%>/Histo_Medica/view.do');setCookie('histo_medica',2);" >
							<input class=boton2 type="button" name="bt83" value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="9913"/>" onMouseOver="funcsub(this.name)"
								onMouseOut="funcsub2(this.name)" onClick="enviar('<%=request.getContextPath()%>/Histo_Medica/view.do');setCookie('histo_medica',3);" >
							<input class=boton2 type="button" name="bt84" value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="9914"/>" onMouseOver="funcsub(this.name)"
								onMouseOut="funcsub2(this.name)" onClick="enviar('<%=request.getContextPath()%>/Histo_Medica/view.do');setCookie('histo_medica',4);" >
							<input class=boton2 type="button" name="bt85" value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="9915"/>" onMouseOver="funcsub(this.name)"
								onMouseOut="funcsub2(this.name)" onClick="enviar('<%=request.getContextPath()%>/Histo_Medica/view.do');setCookie('histo_medica',5);" >
							<input class=boton2 type="button" name="bt86" value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<bean:message key="9916"/>" onMouseOver="funcsub(this.name)"
								onMouseOut="funcsub2(this.name)" onClick="enviar('<%=request.getContextPath()%>/Histo_Medica/view.do');setCookie('histo_medica',6);" >
							<input type="button" class="boton2" name="bt29" value="<bean:message key="6230"/>" onMouseOver="funcsub(this.name)"
								onMouseOut="funcsub2(this.name)" onclick="enviar('<%=request.getContextPath()%>/Carne/view.do');">
							<input class=boton2 type="button" name="bt06" value="<bean:message key="724"/>" onMouseover="funcsub(this.name)"
								onMouseout="funcsub2(this.name)" onClick="top.a3.location='rangosReportesFam.jsp'; ">
						
						</div>
						<!-- <input type="image" src="=//request.getContextPath()%>/images/bot_pets.jpg"
              style="border-style: none; margin-left: 4px; cursor: pointer; margin-top: 2px"> -->
						<!-- <input type="image" src="=//request.getContextPath()%>/images/bot_car.jpg"
              style="border-style: none; margin-left: 4px; cursor: pointer; margin-top: 2px"> -->
						<input class=boton type="button" name="bt91" value="<bean:message key="9620"/>"
							style="background-image: url('<%=request.getContextPath()%>/images/salseg.gif'); padding-left: 22px; height: 22px; margin-top: 5px;"
							onMouseOver="func(this.name)" onMouseOut="func2(this.name)" onClick="logout()">
					</td>
				</tr>

			</TABLE>
		</form>

	</body>
</html>
