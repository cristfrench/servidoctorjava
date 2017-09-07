


<%@ taglib uri="/WEB-INF/tiles.tld" prefix="comp"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<html:html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
  <SCRIPT language="JavaScript" src="<%=request.getContextPath()%>/script/funciones.js"></SCRIPT>
  <SCRIPT language="JavaScript" src="<%=request.getContextPath()%>/script/fechas.js"></SCRIPT>
  <LINK rel="stylesheet" href="<%=request.getContextPath()%>/calendario/CalendarControl.css" type="text/css">
  <SCRIPT language="JavaScript" src="<%=request.getContextPath()%>/calendario/CalendarControl.js"></SCRIPT>
  <%if (session.getAttribute("usuarioFamily") != null){ %>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style/estilo_family.css" type="text/css" >
  <%} else if (session.getAttribute("usuarioPets") != null){ %>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style/estilo_pets.css" type="text/css" >
  <%} else if (session.getAttribute("usuarioCar") != null){ %>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style/estilo_car.css" type="text/css" >
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style/examples.css" type="text/css" >
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style/screen.css" type="text/css" >
  <%}%>
  <script>
	function validarSoloLectura(){
	<%if (session.getAttribute("soloLectura") != null){%>
		soloLectura()
	<%}%>
	}
	<%if (session.getAttribute("usuarioFamily") == null && session.getAttribute("usuarioPets") == null && session.getAttribute("usuarioCar") == null){%>
		top.close();
	<%}%>
</script>
  <title><comp:getAsString name="title" />
  </title>

  <%
  	if (request.getServerPort() == 80) {
  %>
  <base href="http://<%=request.getServerName()%><%=request.getContextPath()%>/">
  <%
  	} else {
  %>
  <base href="http://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/">
  <%
  	}
  %>
</head>

<body onLoad="this.focus();validarSoloLectura();actualiza_popup_abierto()" onUnload="actualiza_popup_abierto()" onkeydown="if (event.keyCode==8) {event.keyCode=0; return event.keyCode }">
  <%
  	if (session.getAttribute("logo") != null) {
  %>
  <div style="position: absolute; left: 70%; z-index: 2">
    <img src="<%=request.getContextPath() + session.getAttribute("logo")%>" height="60" />
  </div>
  <%
  	}
  %>
  <br />
  <br />
  <br />
  <table border="0" width="100%" cellspacing="5">
    <tr>
      <td>
        <comp:insert attribute='body' />
      </td>
    </tr>
  </table>
</body>
</html:html>



