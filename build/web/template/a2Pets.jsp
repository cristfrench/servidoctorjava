<html>

<head>



<script language="JavaScript">

<!--

function Ayuda() { 

window.open('powered.htm','tp','top=100,left=100,width=350,height=350');

}



function mV() { 

  top.fr.cols = "200,*"; 

  top.a3.document.body.scroll = "no"; 

 

}

function mV2() { 

  top.fr.cols = "0,*"; 

  top.a3.document.body.scroll = "yes"; 

}







//-->

</SCRIPT>

<STYLE>



SPAN:hover{cursor:pointer;COLOR: #ffcc00; }

A:hover {COLOR: #ffcc00; TEXT-DECORATION: none;}

A {COLOR: #ffffff; align: center; TEXT-DECORATION: none}

</STYLE>



<body bgcolor="#74AC00" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" background="/ServiDoctor/images/fona2_pets.gif	">

<table border="0" cellspacing="0" cellpadding="0" width="100%">

  <tr> 

  <td valign=top align=left width="1px"><img src="/ServiDoctor/images/curva_pets.jpg" border=0 ></td>

  <td valign=top align=left ></td>

    <td >

<div id="Fecha" style="position:absolute; left:66px; top:6px; width:300px; height:10px; z-index:2; visibility: visible"> 

        <font style="font-family:arial; font-size:10px; text-transform:uppercase; color:#ffffff;"> 

        

        <script language="JavaScript">

// Array of day names
var languageApp='en';
var dayNames = new Array("Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado");
var dayNamesEn = new Array("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday");

// Array of month Names

var monthNames = new Array("Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre");
var monthNamesEn = new Array("January","February","March","April","May","June","July","August","September","October","November","December");
var now = new Date();
var anio=parseInt(now.getYear());

if (navigator.appName == 'Netscape') {
			anio= anio + (1900);			
		
}
if (languageApp=='<%=session.getAttribute("idioma")%>'){
	document.write(dayNamesEn[now.getDay()] + ", " + now.getDate() +" "+ monthNamesEn[now.getMonth()] + " " +  anio);
}else{
	document.write(dayNames[now.getDay()] + " " + now.getDate() +" de "+ monthNames[now.getMonth()] + " de " +  anio);
}
// -->

</script>

        </font> </div>

</td>

    <td align="right" > <img src="/ServiDoctor/images/tit_pets.jpg" ></td>

  </tr>

</table>

</body>

</html>

