
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page
  import="com.servidoctor.seguridad.model.UsuarioPets,com.servidoctor.constantes.IConstantes"%>
<html>
  <head>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style/estilo_pets.css" type="text/css">
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

function func(nam) {
  eval("form1." + nam + ".style.backgroundColor = '#71A700'")
  eval("form1." + nam + ".style.color = '#ffffff'")
  eval("form1." + nam + ".style.borderColor = '#4A6D00'")
  //eval("form1." + nam + ".style.fontWeight = 'bold'")
}
function func2(nam) {
  eval("form1." + nam + ".style.backgroundColor = '#4A6D00'")
  eval("form1." + nam + ".style.color = '#FFFFCC'")
  eval("form1." + nam + ".style.borderColor = '#71A700'")
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

  <body bgcolor="#CCCCCC" text="#000000" leftmargin="0" topmargin="0" marginwidth="0"
    marginheight="0" scroll=no background="<%=request.getContextPath()%>/images/fondo_menu_pets.jpg"
    onkeydown="if (event.keyCode==8) {event.keyCode=0; return event.keyCode }">
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
                  <%=((UsuarioPets) request.getSession().getAttribute(
							"usuarioPets")).getUsup_usuario()%></td>
              </tr>
            </table>-->
          </TD>
        </TR>
        <tr>
          <td>
            <!-- <input class=boton type="button" name="bt01" value="  <bean:message key="1806"/> 1"
              onMouseover="func(this.name)" onMouseout="func2(this.name)"
              onclick="menuDesp(submen1)">-->
          </td>
        </tr>
        <tr>
          <td style="margin-top: 10px">
            <!--  <input type="image" src="=//request.getContextPath()/images/bot_family.jpg"
              style="border-style: none; margin-left: 4px; cursor: pointer; margin-top: 5px"> -->
            <!-- <input type="image" src="//=request.getContextPath()%>/images/bot_pets.jpg"
              style="border-style: none; margin-left: 4px; cursor: pointer; margin-top: 2px"
              onclick="top.location.href='//=request.getContextPath()%>/Pets.do'" title="Ir a SERVIDOCTOR PETS">-->
            <div id="submen6"> 
              <input class=boton2 type="button" name="bt41" value="    <bean:message key="3806"/>"
                onMouseover="funcsub(this.name)" onMouseout="funcsub2(this.name)"
                onClick="enviar('<%=request.getContextPath()%>/DatosMascota/aspectos_generales.do');">
              <input class=boton2 type="button" name="bt40" value="    <bean:message key="1504"/>"
                onMouseover="funcsub(this.name)" onMouseout="funcsub2(this.name)"
                onClick="enviar('<%=request.getContextPath()%>/DatosMascota/list.do');">
              <input class=boton2 type="button" name="bt42" value="    <bean:message key="3090"/>"
                onMouseover="funcsub(this.name)" onMouseout="funcsub2(this.name)"
                onClick="enviar('<%=request.getContextPath()%>/DatosMascota/manual_perros.do');">
              <input class=boton2 type="button" name="bt43" value="    <bean:message key="3091"/>"
                onMouseover="funcsub(this.name)" onMouseout="funcsub2(this.name)"
                onClick="enviar('<%=request.getContextPath()%>/DatosMascota/manual_gatos.do');">
              <input class=boton2 type="button" name="bt12" value="    <bean:message key="724"/>"
                onMouseover="funcsub(this.name)" onMouseout="funcsub2(this.name)"
                onClick="top.a3.location='rangosReportesPet.jsp'; ">
            </div>
         <!-- <input type="image" src="=//request.getContextPath()/images/bot_car.jpg"
              style="border-style: none; margin-left: 4px; cursor: pointer; margin-top: 2px"> -->
            <input class=boton type="button" name="bt11" value="<bean:message key="9620"/>"
              style="background-image: url('<%=request.getContextPath()%>/images/salseg.gif'); padding-left: 22px; height: 22px; margin-top: 5px"
              onMouseOver="func(this.name)" onMouseOut="func2(this.name)" onClick="logout()">
          </td>
        </tr>
      </TABLE>
    </form>
  </body>
</html>