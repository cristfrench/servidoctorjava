<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="comp"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@page session="true"%>
<html:html>
<head>
  <meta http-equiv="pragma" content="no-cache" />
  <meta http-equiv="cache-control" content="no-cache" />
  <meta http-equiv="expires" content="0" />
  <SCRIPT language="JavaScript" src="<%=request.getContextPath()%>/script/funciones.js"></SCRIPT>
  <SCRIPT language="JavaScript" src="<%=request.getContextPath()%>/script/fechas.js"></SCRIPT>
  <SCRIPT language="JavaScript" src="<%=request.getContextPath()%>/script/jqueryalerts.js"></SCRIPT>
  <SCRIPT language="JavaScript" src="<%=request.getContextPath()%>/script/jquery.js"></SCRIPT>
  <SCRIPT language="JavaScript" src="<%=request.getContextPath()%>/script/switchcontent.js"></SCRIPT>
  <script type="text/javascript" src="<%=request.getContextPath()%>/script/jquery-1.3.2.min.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/script/jquery.corner.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/script/jquery-impromptu.2.7.min.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/script/common.js"></script>
  
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
<%--	<%if (session.getAttribute("usuarioFamily") == null && session.getAttribute("usuarioPets") == null && session.getAttribute("usuarioCar") == null){%>--%>
<%--		alert('<bean:message key="global.session.expired"/>');--%>
<%--		parent.location='http://www.servidoctor.com';--%>
<%--	<%}%>--%>
	actualiza_popup_abierto();
	function validarSoloLectura(){
	<%if (session.getAttribute("soloLectura") != null){%>
		soloLectura()
	<%}%>
	}
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
  <style type="text/css">
.link_family {
  font-family: Arial, Helvetica, sans-serif;
  font-size: 14px;
  color: #D98200;
  font-weight: bold;
}

.link_family:hover {
  color: #000000;
}

#borde_family {
  border: #FF9966 1px solid;
  position: absolute;
  left: 365px;
  z-index: 3;
  top: 0px;
  width: 340px;
  height: 64px;
}

.link_pets {
  font-family: Arial, Helvetica, sans-serif;
  font-size: 14px;
  color: #009966;
  font-weight: bold;
}

.link_pets:hover {
  color: #000000;
}

#borde_pets {
  border: #009966 1px solid;
  position: absolute;
  left: 365px;
  z-index: 3;
  top: 4px;
  width: 340px;
  height: 62px;
}

.link_cars {
  font-family: Arial, Helvetica, sans-serif;
  font-size: 14px;
  color: #0000FF;
  font-weight: bold;
}

.link_cars:hover {
  color: #000000;
}

#borde_cars {
  border: #0000FF 1px solid;
  position: absolute;
  left: 365px;
  z-index: 3;
  top: 4px;
  width: 340px;
  height: 62px;
}

.boton_fijo {
  font-family: Arial, Helvetica, sans-serif;
  font-size: 10px;
  color: #000000;
  font-weight: bold;
}
</style>
</head>

<body onLoad="validarSoloLectura()" onkeydown="if (event.keyCode==8) {event.keyCode=0; return event.keyCode }">
  <%
  	if (session.getAttribute("logo") != null) {
  %>
  <%
  	String todo = (String) session.getAttribute("logo");
  			String app = todo.substring(todo.lastIndexOf('^') + 1, todo.length());
  			todo = todo.substring(0, todo.lastIndexOf('^'));
  			String link_texto = todo.substring(todo.lastIndexOf('^') + 1, todo.length());
  			todo = todo.substring(0, todo.lastIndexOf('^'));
  			String texto = todo.substring(todo.lastIndexOf('^') + 1, todo.length());
  			todo = todo.substring(0, todo.lastIndexOf('^'));
  			String logo_link = todo.substring(todo.lastIndexOf('^') + 1, todo.length());
  			todo = todo.substring(0, todo.lastIndexOf('^'));
  			String logo = todo;
  			String clase = "";
  			String borde = "";
  %>

  <%
  	if (app.equalsIgnoreCase("F")) {
  				clase = "link_family";
  				borde = "borde_family";
  			}
  			if (app.equalsIgnoreCase("P")) {
  				clase = "link_pets";
  				borde = "borde_pets";
  			}
  			if (app.equalsIgnoreCase("C")) {
  				clase = "link_cars";
  				borde = "borde_cars";
  			}
  %>

  <script language="javascript" type="text/javascript">
	
	function desplazar(){
		var nombre = "<%=borde%>";
		if(screen.width >= 1200) document.getElementById(nombre).style.left = 480;
	}
</script>
  <table name="<%=borde%>" id="<%=borde%>" class="<%=borde%>" cellspacing="0" cellpadding="0">
    <tr>
      <td height="7" valign="middle">
        &nbsp;
      </td>
      <td rowspan="3" align="center" id="imagen_show" name="imagen_show">

        <a href="<%=logo_link%>" target="_blank"> <img id="img_imagen_show" name="img_imagen_show" border="0" src="<%=request.getContextPath() + logo%>" height="68" style="left: 530px;" />&nbsp;<br> </a><a href="<%=logo_link%>" target="_blank"><span class="boton_fijo">Clic Ac&aacute;</span> </a>
      </td>
    </tr>
    <tr>
      <td height="12" valign="middle">
        <a href="<%=link_texto%>" target="_blank"> <span class="<%=clase%>"> <marquee onMouseOut="this.start()" onMouseOver="this.stop()" scrolldelay="150"><%=texto%></marquee> </span> </a>
      </td>
    </tr>
    <tr align="center" height=5>
      <td valign="bottom" height=5>
        <a href="<%=link_texto%>" target="_blank"> <span class="boton_fijo">Clic Acá</span> </a>
        <br>
        <br>
      </td>
    </tr>
  </table>
  <%
  	}
  %>

  <br />
  <br />
  <br />
  <br>
  <br>
  <table border="0" width="100%" cellspacing="5">
    <tr>
      <td valign="top" align="left">
        <comp:insert attribute='body' />
      </td>
    </tr>
    <tr>

    </tr>
    <tr>
    </tr>
  </table>
   <script language="javascript" type="text/javascript">
    //document.getElementById('imagen_show').style.width = document.getElementById('img_imagen_show').width+6;
	//desplazar();
</script> 
<script type="text/javascript">
// MAIN FUNCTION: new switchcontent("class name", "[optional_element_type_to_scan_for]") REQUIRED
// Call Instance.init() at the very end. REQUIRED

var bobexample=new switchcontent("switchgroup1", "div") //Limit scanning of switch contents to just "div" elements
bobexample.setStatus('<img src="<%=request.getContextPath()%>/images/opencq8.png" /> ', '<img src="<%=request.getContextPath()%>/images/closedy2.png" /> ')
bobexample.setColor('darkred', 'black')
bobexample.setPersist(true)
bobexample.collapsePrevious(true) //Only one content open at any given time
bobexample.init()
</script>


</body>

</html:html>
