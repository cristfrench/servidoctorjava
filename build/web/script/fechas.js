var fecha = new Date();
var ano = fecha.getYear();

function seleccionarActual(dia, mes, a, campoFinal)  {

	if( document.getElementById( campoFinal ).value.length > 1 && document.getElementById( campoFinal ).value != 0 && document.getElementById( campoFinal ).value != '0000-00-00'){
	
		var dd = document.getElementById( campoFinal ).value.substring(8, 10);
		var mm = document.getElementById( campoFinal ).value.substring(5, 7);
		var aa = document.getElementById( campoFinal ).value.substring(0, 4);
		//alert(dd + ' ' + mm + ' ' + aa);
		document.getElementById( dia ).options[ parseInt(dd, 10) ].selected = 'selected';
		
		document.getElementById( mes ).options[ parseInt(mm, 10) ].selected = 'selected';
		
			
		if (navigator.appName == 'Netscape') {
			var posN = 90 - (((ano) + (1900)) - (aa));
			document.getElementById( a ).options[ posN+1 ].selected = 'selected';	
		} else {
			var posM = 90 - ((ano) - (aa));
			document.getElementById( a ).options[ posM+1 ].selected = 'selected';	
		}

	} else {
		var d = fecha.getDate();
		var m = fecha.getMonth();
//		eval("document.all." + dia + ".options[" + (d - 1) + "].selected = 'selected'");
//		eval("document.all." + mes + ".options[" + m + "].selected = 'selected'");
		document.getElementById( dia ).options[ 0 ].selected = 'selected';
		document.getElementById( mes ).options[ 0 ].selected = 'selected';
		document.getElementById( a ).options[ 0 ].selected = 'selected';
	}
}
function seleccionarActual2(dia, mes, a, campoFinal)  {

	if( document.getElementById( campoFinal ).value.length > 1 && document.getElementById( campoFinal ).value != 0 && document.getElementById( campoFinal ).value != '0000-00-00'){
	
		var dd = document.getElementById( campoFinal ).value.substring(8, 10);
		var mm = document.getElementById( campoFinal ).value.substring(5, 7);
		var aa = document.getElementById( campoFinal ).value.substring(0, 4);
		//alert(dd + ' ' + mm + ' ' + aa);
		document.getElementById( dia ).options[ parseInt(dd, 10) ].selected = 'selected';
		
		document.getElementById( mes ).options[ parseInt(mm, 10) ].selected = 'selected';
		
			
		if (navigator.appName == 'Netscape') {
			var posN =  (((ano) + (1900)) - (aa));
			document.getElementById( a ).options[ posN+1 ].selected = 'selected';	
		} else {
			var posM =  ((ano) - (aa));
			document.getElementById( a ).options[ posM+1 ].selected = 'selected';	
		}

	} else {
		var d = fecha.getDate();
		var m = fecha.getMonth();
//		eval("document.all." + dia + ".options[" + (d - 1) + "].selected = 'selected'");
//		eval("document.all." + mes + ".options[" + m + "].selected = 'selected'");
		document.getElementById( dia ).options[ 0 ].selected = 'selected';
		document.getElementById( mes ).options[ 0 ].selected = 'selected';
		document.getElementById( a ).options[ 0 ].selected = 'selected';
	}
}

function seleccionarActual3(dia, mes, a, campoFinal)  {

	if( document.getElementById( campoFinal ).value.length > 1 && document.getElementById( campoFinal ).value != 0 && document.getElementById( campoFinal ).value != '0000-00-00'){
	
		var dd = document.getElementById( campoFinal ).value.substring(8, 10);
		var mm = document.getElementById( campoFinal ).value.substring(5, 7);
		var aa = document.getElementById( campoFinal ).value.substring(0, 4);
		//alert(dd + ' ' + mm + ' ' + aa);
		document.getElementById( dia ).options[ parseInt(dd, 10) ].selected = 'selected';
		
		document.getElementById( mes ).options[ parseInt(mm, 10) ].selected = 'selected';
		
			
		if (navigator.appName == 'Netscape') {
			var posN =  (((ano) + (1900)) - (aa));
			document.getElementById( a ).options[ posN+1 ].selected = 'selected';	
		} else {
			var posM =  ((ano) - (aa));
			document.getElementById( a ).options[ posM+1 ].selected = 'selected';	
		}

	} else {
		var d = fecha.getDate();
		var m = fecha.getMonth();
//		eval("document.all." + dia + ".options[" + (d - 1) + "].selected = 'selected'");
//		eval("document.all." + mes + ".options[" + m + "].selected = 'selected'");
		document.getElementById( dia ).options[ 0 ].selected = 'selected';
		document.getElementById( mes ).options[ 0 ].selected = 'selected';
		document.getElementById( a ).options[ 0 ].selected = 'selected';
	}
}

function seleccionarActualCorta(mes, a, campoFinal)  {
	if( document.getElementById( campoFinal ).value.length > 1 ){
		var mm = document.getElementById( campoFinal ).value.substring(5, 7);
		var aa = document.getElementById( campoFinal ).value.substring(0, 4);
		document.getElementById( mes ).options[ parseInt(mm, 10) ].selected = 'selected';	
		if (navigator.appName == 'Netscape') {
			var posN = 90 - (((ano) + (1900)) - (aa));
			document.getElementById( a ).options[ posN+1 ].selected = 'selected';	
		} else {
			var posM = 90 - ((ano) - (aa));
			document.getElementById( a ).options[ posM+1 ].selected = 'selected';	
		}

	} else {
		var d = fecha.getDate();
		var m = fecha.getMonth();		
		document.getElementById( mes ).options[ m ].selected = 'selected';
	}
}

function seleccionarActualCorta2(mes, a, campoFinal)  {
	if( document.getElementById( campoFinal ).value.length > 1 ){
		var mm = document.getElementById( campoFinal ).value.substring(5, 7);
		var aa = document.getElementById( campoFinal ).value.substring(0, 4);
		document.getElementById( mes ).options[ parseInt(mm, 10) ].selected = 'selected';	
		if (navigator.appName == 'Netscape') {
			var posN = 90 - (((ano) + (1900)) - (aa));
			document.getElementById( a ).options[ posN+1 ].selected = 'selected';	
		} else {
			var posM = 90 - ((ano) - (aa));
			document.getElementById( a ).options[ posM+1 ].selected = 'selected';	
		}

	} else {
		var d = fecha.getDate();
		var m = fecha.getMonth();		
		document.getElementById( mes ).options[ m ].selected = 'selected';
	}
}

function obtenerCamposFecha(namedia, namemes, nameano, campoFinal) {
	var i;	
	if (navigator.appName == 'Netscape') {
		i = ano + 1900 - 90;
		a = ano + 1900;
	} else {
		i = ano- 90; 
		a = ano;
	}
	
	document.write ("<table>");
	document.write ("	<tr align='center'>");
	document.write ("		<td class='view_item'>DD</td>");
	document.write ("		<td class='view_item'>MM</td>");
	document.write ("		<td class='view_item'>YYYY</td>");
	document.write ("	</tr>");
	document.write ("	<tr>");
	document.write ("		<td class='view_item'>");
	document.write ("			<select class='select' name='" + namedia + "' id='" + namedia + "'>");
	document.write ("				<option value='00'>--</option>");
	document.write ("				<option value='01'>01</option>");
	document.write ("				<option value='02'>02</option>");
	document.write ("				<option value='03'>03</option>");
	document.write ("				<option value='04'>04</option>");
	document.write ("				<option value='05'>05</option>");
	document.write ("				<option value='06'>06</option>");
	document.write ("				<option value='07'>07</option>");
	document.write ("				<option value='08'>08</option>");
	document.write ("				<option value='09'>09</option>");
	document.write ("				<option value='10'>10</option>");
	document.write ("				<option value='11'>11</option>");
	document.write ("				<option value='12'>12</option>");
	document.write ("				<option value='13'>13</option>");
	document.write ("				<option value='14'>14</option>");
	document.write ("				<option value='15'>15</option>");
	document.write ("				<option value='16'>16</option>");
	document.write ("				<option value='17'>17</option>");
	document.write ("				<option value='18'>18</option>");
	document.write ("				<option value='19'>19</option>");
	document.write ("				<option value='20'>20</option>");
	document.write ("				<option value='21'>21</option>");
	document.write ("				<option value='22'>22</option>");
	document.write ("				<option value='23'>23</option>");
	document.write ("				<option value='24'>24</option>");
	document.write ("				<option value='25'>25</option>");
	document.write ("				<option value='26'>26</option>");
	document.write ("				<option value='27'>27</option>");
	document.write ("				<option value='28'>28</option>");
	document.write ("				<option value='29'>29</option>");
	document.write ("				<option value='30'>30</option>");
	document.write ("				<option value='31'>31</option>");
	document.write ("			</select>");
	document.write ("		</td>");
	document.write ("		<td class='view_item'>");
	document.write ("			<select class='select' name='" + namemes + "' id='" + namemes + "'>");
	document.write ("				<option value='00'>--</option>");
	document.write ("				<option value='01'>01</option>");
	document.write ("				<option value='02'>02</option>");
	document.write ("				<option value='03'>03</option>");
	document.write ("				<option value='04'>04</option>");
	document.write ("				<option value='05'>05</option>");
	document.write ("				<option value='06'>06</option>");
	document.write ("				<option value='07'>07</option>");
	document.write ("				<option value='08'>08</option>");
	document.write ("				<option value='09'>09</option>");
	document.write ("				<option value='10'>10</option>");
	document.write ("				<option value='11'>11</option>");
	document.write ("				<option value='12'>12</option>");
	document.write ("			</select>");
	document.write ("		</td>");	
	document.write ("		<td class='view_item'>");
	document.write ("			<select class='select' name='" + nameano + "' id='" + nameano + "'>");
	document.write ("				<option value='0000'>----</option>");
	for (i; i <= a; i++) {
		if(i == a) {
			document.write ("			<option value='" + i + "' selected>" + i + "</option>");
		} else {
			document.write ("			<option value='" + i + "'>" + i + "</option>");
		}
	}
	document.write ("			</select>");
	document.write ("		</td>");	
	document.write ("	</tr>");
	document.write ("</table>");
	
	seleccionarActual(namedia, namemes, nameano, campoFinal);
}

function obtenerCamposFecha2(namedia, namemes, nameano, campoFinal) {
	var i;	
	if (navigator.appName == 'Netscape') {
		i = ano + 1900 - 90;
		a = ano + 1900;
	} else {
		i = ano- 90; 
		a = ano;
	}
	
	document.write ("<table>");
	document.write ("	<tr align='center'>");
	document.write ("		<td class='view_item'>YYYY</td>");
	document.write ("		<td class='view_item'>MM</td>");
	document.write ("		<td class='view_item'>DD</td>");
	document.write ("	</tr>");
	document.write ("	<tr>");
	document.write ("		<td class='view_item'>");
	document.write ("			<select class='select' name='" + nameano + "' id='" + nameano + "'>");
	document.write ("				<option value='0000'>----</option>");
	for (a; a >= i; a--) {
		if(i == a) {
			document.write ("			<option value='" + a + "' selected>" + a + "</option>");
		} else {
			document.write ("			<option value='" + a + "'>" + a + "</option>");
		}
	}
	document.write ("			</select>");
	document.write ("		</td>");
	document.write ("		<td class='view_item'>");
	document.write ("			<select class='select' name='" + namemes + "' id='" + namemes + "'>");
	document.write ("				<option value='00'>--</option>");
	document.write ("				<option value='01'>01</option>");
	document.write ("				<option value='02'>02</option>");
	document.write ("				<option value='03'>03</option>");
	document.write ("				<option value='04'>04</option>");
	document.write ("				<option value='05'>05</option>");
	document.write ("				<option value='06'>06</option>");
	document.write ("				<option value='07'>07</option>");
	document.write ("				<option value='08'>08</option>");
	document.write ("				<option value='09'>09</option>");
	document.write ("				<option value='10'>10</option>");
	document.write ("				<option value='11'>11</option>");
	document.write ("				<option value='12'>12</option>");
	document.write ("			</select>");
	document.write ("		</td>");	
	document.write ("		<td class='view_item'>");
	document.write ("			<select class='select' name='" + namedia + "' id='" + namedia + "'>");
	document.write ("				<option value='00'>--</option>");
	document.write ("				<option value='01'>01</option>");
	document.write ("				<option value='02'>02</option>");
	document.write ("				<option value='03'>03</option>");
	document.write ("				<option value='04'>04</option>");
	document.write ("				<option value='05'>05</option>");
	document.write ("				<option value='06'>06</option>");
	document.write ("				<option value='07'>07</option>");
	document.write ("				<option value='08'>08</option>");
	document.write ("				<option value='09'>09</option>");
	document.write ("				<option value='10'>10</option>");
	document.write ("				<option value='11'>11</option>");
	document.write ("				<option value='12'>12</option>");
	document.write ("				<option value='13'>13</option>");
	document.write ("				<option value='14'>14</option>");
	document.write ("				<option value='15'>15</option>");
	document.write ("				<option value='16'>16</option>");
	document.write ("				<option value='17'>17</option>");
	document.write ("				<option value='18'>18</option>");
	document.write ("				<option value='19'>19</option>");
	document.write ("				<option value='20'>20</option>");
	document.write ("				<option value='21'>21</option>");
	document.write ("				<option value='22'>22</option>");
	document.write ("				<option value='23'>23</option>");
	document.write ("				<option value='24'>24</option>");
	document.write ("				<option value='25'>25</option>");
	document.write ("				<option value='26'>26</option>");
	document.write ("				<option value='27'>27</option>");
	document.write ("				<option value='28'>28</option>");
	document.write ("				<option value='29'>29</option>");
	document.write ("				<option value='30'>30</option>");
	document.write ("				<option value='31'>31</option>");
	document.write ("			</select>");
	document.write ("		</td>");
	document.write ("	</tr>");
	document.write ("</table>");
	
	seleccionarActual2(namedia, namemes, nameano, campoFinal);
}

function obtenerCamposFecha3(namedia, namemes, nameano, campoFinal) {
	var i;	
	if (navigator.appName == 'Netscape') {
		i = ano + 1900 - 90;
		a = ano + 1900;
	} else {
		i = ano- 90; 
		a = ano;
	}
	
	document.write ("<table>");
	document.write ("	<tr align='center'>");
	document.write ("		<td class='view_item'>YYYY</td>");
	document.write ("		<td class='view_item'>MM</td>");
	document.write ("		<td class='view_item'>DD</td>");
	document.write ("	</tr>");
	document.write ("	<tr>");
	document.write ("		<td class='view_item'>");
	document.write ("			<select class='select' name='" + namedia + "' id='" + namedia + "'>");
	document.write ("				<option value='00'>--</option>");
	document.write ("				<option value='01'>01</option>");
	document.write ("				<option value='02'>02</option>");
	document.write ("				<option value='03'>03</option>");
	document.write ("				<option value='04'>04</option>");
	document.write ("				<option value='05'>05</option>");
	document.write ("				<option value='06'>06</option>");
	document.write ("				<option value='07'>07</option>");
	document.write ("				<option value='08'>08</option>");
	document.write ("				<option value='09'>09</option>");
	document.write ("				<option value='10'>10</option>");
	document.write ("				<option value='11'>11</option>");
	document.write ("				<option value='12'>12</option>");
	document.write ("				<option value='13'>13</option>");
	document.write ("				<option value='14'>14</option>");
	document.write ("				<option value='15'>15</option>");
	document.write ("				<option value='16'>16</option>");
	document.write ("				<option value='17'>17</option>");
	document.write ("				<option value='18'>18</option>");
	document.write ("				<option value='19'>19</option>");
	document.write ("				<option value='20'>20</option>");
	document.write ("				<option value='21'>21</option>");
	document.write ("				<option value='22'>22</option>");
	document.write ("				<option value='23'>23</option>");
	document.write ("				<option value='24'>24</option>");
	document.write ("				<option value='25'>25</option>");
	document.write ("				<option value='26'>26</option>");
	document.write ("				<option value='27'>27</option>");
	document.write ("				<option value='28'>28</option>");
	document.write ("				<option value='29'>29</option>");
	document.write ("				<option value='30'>30</option>");
	document.write ("				<option value='31'>31</option>");
	document.write ("			</select>");
	document.write ("		</td>");
	document.write ("		<td class='view_item'>");
	document.write ("			<select class='select' name='" + namemes + "' id='" + namemes + "'>");
	document.write ("				<option value='00'>--</option>");
	document.write ("				<option value='01'>01</option>");
	document.write ("				<option value='02'>02</option>");
	document.write ("				<option value='03'>03</option>");
	document.write ("				<option value='04'>04</option>");
	document.write ("				<option value='05'>05</option>");
	document.write ("				<option value='06'>06</option>");
	document.write ("				<option value='07'>07</option>");
	document.write ("				<option value='08'>08</option>");
	document.write ("				<option value='09'>09</option>");
	document.write ("				<option value='10'>10</option>");
	document.write ("				<option value='11'>11</option>");
	document.write ("				<option value='12'>12</option>");
	document.write ("			</select>");
	document.write ("		</td>");
	document.write ("		<td class='view_item'>");
	document.write ("			<select class='select' name='" + nameano + "' id='" + nameano + "'>");
	document.write ("				<option value='0000'>----</option>");
	for (a; a >= i; a--) {
		if(i == a) {
			document.write ("			<option value='" + a + "' selected>" + a + "</option>");
		} else {
			document.write ("			<option value='" + a + "'>" + a + "</option>");
		}
	}
	document.write ("			</select>");
	document.write ("		</td>");
	document.write ("	</tr>");
	document.write ("</table>");
	
	seleccionarActual3(namedia, namemes, nameano, campoFinal);
}



function obtenerCamposFechaCorta(namemes, nameano, campoFinal) {
	var i;	
	if (navigator.appName == 'Netscape') {
		i = ano + 1900 - 90;
		a = ano + 1900;
	} else {
		i = ano- 90; 
		a = ano;
	}
	
	document.write ("<table>");
	document.write ("	<tr align='center'>");
	document.write ("		<td class='view_item'>MM</td>");
	document.write ("		<td class='view_item'>YYYY</td>");
	document.write ("	</tr>");
	document.write ("	<tr>");
	document.write ("		<td class='view_item'>");
	document.write ("			<select class='select' name='" + namemes + "' id='" + namemes + "'>");
	document.write ("				<option value='01'>01</option>");
	document.write ("				<option value='02'>02</option>");
	document.write ("				<option value='03'>03</option>");
	document.write ("				<option value='04'>04</option>");
	document.write ("				<option value='05'>05</option>");
	document.write ("				<option value='06'>06</option>");
	document.write ("				<option value='07'>07</option>");
	document.write ("				<option value='08'>08</option>");
	document.write ("				<option value='09'>09</option>");
	document.write ("				<option value='10'>10</option>");
	document.write ("				<option value='11'>11</option>");
	document.write ("				<option value='12'>12</option>");
	document.write ("			</select>");
	document.write ("		</td>");	
	document.write ("		<td class='view_item'>");
	document.write ("			<select class='select' name='" + nameano + "' id='" + nameano + "'>");
	for (i; i <= a; i++) {
		if(i == a) {
			document.write ("			<option value='" + i + "' selected>" + i + "</option>");
		} else {
			document.write ("			<option value='" + i + "'>" + i + "</option>");
		}
	}
	document.write ("			</select>");
	document.write ("		</td>");	
	document.write ("	</tr>");
	document.write ("</table>");
	
	seleccionarActualCorta(namemes, nameano, campoFinal);
}


function convertirACampo2(namedia, namemes, nameano, nombreFinal){
	valorFinal = document.getElementById( nameano ).value + '-' + document.getElementById( namemes ).value + '-' +  document.getElementById( namedia ).value;
	eval("document.getElementById(\""+nombreFinal+"\").value = "+valorFinal);
}

function convertirACampo(namedia, namemes, nameano, nombreFinal){
	valorFinal = document.getElementById( nameano ).value +  document.getElementById( namemes ).value +  document.getElementById( namedia ).value;
	eval("document.getElementById(\""+nombreFinal+"\").value = "+valorFinal);
}

function convertirACampoCorta(namemes, nameano, nombreFinal){
	valorFinal = document.getElementById( nameano ).value + document.getElementById( namemes ).value;
	document.getElementById( nombreFinal ).value = valorFinal;
}

function CamposFechaA(nameano, campoFinal) {
	var i;	
	
	if (navigator.appName == 'Netscape') {
		i = ano + 1900 - 90;
		a = ano + 1900;
	} else {
		i = ano- 90; 
		a = ano;
	}
	
	document.write ("			<select class='select' name='" + nameano + "' id='" + nameano + "'>");
	for (i; i <= a; i++) {
		if(i == a) {
			document.write ("			<option value='" + i + "' selected>" + i + "</option>");
		} else {
			document.write ("			<option value='" + i + "'>" + i + "</option>");
		}
	}
	document.write ("			</select>");
	
	ActualA(nameano, campoFinal);
}

function CamposFechaB(nameano, campoFinal) {
	var i;	
	
	if (navigator.appName == 'Netscape') {
		i = ano + 1900 - 90;
		a = ano + 1900;
	} else {
		i = ano- 90; 
		a = ano;
	}
	
	document.write ("			<select class='select' name='" + nameano + "' id='" + nameano + "'>");
	for (i; i <= a; i++) {
		if(i == a) {
			document.write ("			<option value='" + i + "' selected>" + i + "</option>");
		} else {
			document.write ("			<option value='" + i + "'>" + i + "</option>");
		}
	}
	document.write ("			</select>");
	

}

function ActualA(a, campoFinal)  {
	if( document.getElementById('"'+ campoFinal + '"').value.length > 1 ){
		var aa = document.getElementById( campoFinal ).value.substring(0, 4);	
		if (navigator.appName == 'Netscape') {
			var posN = 90 - (((ano) + (1900)) - (aa));
			document.getElementById( a ).options[ posN ].selected = 'selected';	
		} else {
			var posM = 90 - ((ano) - (aa));
			document.getElementById( a ).options[ posM ].selected = 'selected';	
		}
	}
}

function CampoA(nameano, nombreFinal){	
	valorFinal = document.getElementById( nameano ).value;
	document.getElementById( nombreFinal ).value = valorFinal;
	//eval("document.getElementById(\""+nombreFinal+"\").value = "+valorFinal);
}


///////JUANKPAPI

function seleccionarHoy(dia, mes, a, campoFinal)  {
	if( document.getElementById( campoFinal ).value.length > 1 && document.getElementById( campoFinal ).value != 0 && document.getElementById( campoFinal ).value != '0000-00-00' ){
		var dd = document.getElementById( campoFinal ).value.substring(8, 10);
		var mm = document.getElementById( campoFinal ).value.substring(5, 7);
		var aa = document.getElementById( campoFinal ).value.substring(0, 4);
		document.getElementById( dia ).options[ parseInt(dd, 10) ].selected = 'selected';
		document.getElementById( mes ).options[ parseInt(mm, 10) ].selected = 'selected';	
		if (navigator.appName == 'Netscape') {
			var posN = 5 - (((ano) + (1900)) - (aa));
			document.getElementById( a ).options[ posN+1 ].selected = 'selected';	
		} else {
			var posM = 5 - ((ano) - (aa));
			document.getElementById( a ).options[ posM+1 ].selected = 'selected';	
		}

	} else {
//		var d = fecha.getDate();
//		var m = fecha.getMonth();	
//		var pos = eval("document.all." + a + ".length");
		document.getElementById( dia ).options[ 0 ].selected = 'selected';
		document.getElementById( mes ).options[ 0 ].selected = 'selected';
		document.getElementById( a ).options[ 0 ].selected = 'selected';
							
//		eval("document.all." + dia + ".options[" + (d - 1) + "].selected = 'selected'");
//		eval("document.all." + mes + ".options[" + m + "].selected = 'selected'");
//		eval("document.all." + a + ".options[" + (pos - 1) + "].selected = 'selected'");
	}
}

function seleccionarHoy2(dia, mes, a, campoFinal)  {
	if( document.getElementById( campoFinal ).value.length > 1 && document.getElementById( campoFinal ).value != 0 && document.getElementById( campoFinal ).value != '0000-00-00' ){
		var dd = document.getElementById( campoFinal ).value.substring(8, 10);
		var mm = document.getElementById( campoFinal ).value.substring(5, 7);
		var aa = document.getElementById( campoFinal ).value.substring(0, 4);
		document.getElementById( dia ).options[ parseInt(dd, 10) ].selected = 'selected';
		document.getElementById( mes ).options[ parseInt(mm, 10) ].selected = 'selected';	
		if (navigator.appName == 'Netscape') {
			var posN = 10 + (((ano) + (1900)) - (aa));
			document.getElementById( a ).options[ posN+1 ].selected = 'selected';	
		} else {
			var posM = 10 + ((ano) - (aa));
			document.getElementById( a ).options[ posM+1 ].selected = 'selected';	
		}

	} else {
//		var d = fecha.getDate();
//		var m = fecha.getMonth();	
//		var pos = eval("document.all." + a + ".length");
		document.getElementById( dia ).options[ 0 ].selected = 'selected';
		document.getElementById( mes ).options[ 0 ].selected = 'selected';
		document.getElementById( a ).options[ 0 ].selected = 'selected';
							
//		eval("document.all." + dia + ".options[" + (d - 1) + "].selected = 'selected'");
//		eval("document.all." + mes + ".options[" + m + "].selected = 'selected'");
//		eval("document.all." + a + ".options[" + (pos - 1) + "].selected = 'selected'");
	}
}

function obtenerCamposFechaFuturo(namedia, namemes, nameano, campoFinal, f) {
	var i;	
	if (navigator.appName == 'Netscape') {
		i = ano + 1900 -5;
		a = ano + 1900 + f;
	} else {
		i = ano - 5; 
		a = ano + f;
	}
	
	document.write ("<table>");
	document.write ("	<tr align='center'>");
	document.write ("		<td class='view_item'>DD</td>");
	document.write ("		<td class='view_item'>MM</td>");
	document.write ("		<td class='view_item'>YYYY</td>");
	document.write ("	</tr>");
	document.write ("	<tr>");
	document.write ("		<td class='view_item'>");
	document.write ("			<select class='select' name='" + namedia + "' id='" + namedia + "'>");
	document.write ("				<option value='00'>--</option>");
	document.write ("				<option value='01'>01</option>");
	document.write ("				<option value='02'>02</option>");
	document.write ("				<option value='03'>03</option>");
	document.write ("				<option value='04'>04</option>");
	document.write ("				<option value='05'>05</option>");
	document.write ("				<option value='06'>06</option>");
	document.write ("				<option value='07'>07</option>");
	document.write ("				<option value='08'>08</option>");
	document.write ("				<option value='09'>09</option>");
	document.write ("				<option value='10'>10</option>");
	document.write ("				<option value='11'>11</option>");
	document.write ("				<option value='12'>12</option>");
	document.write ("				<option value='13'>13</option>");
	document.write ("				<option value='14'>14</option>");
	document.write ("				<option value='15'>15</option>");
	document.write ("				<option value='16'>16</option>");
	document.write ("				<option value='17'>17</option>");
	document.write ("				<option value='18'>18</option>");
	document.write ("				<option value='19'>19</option>");
	document.write ("				<option value='20'>20</option>");
	document.write ("				<option value='21'>21</option>");
	document.write ("				<option value='22'>22</option>");
	document.write ("				<option value='23'>23</option>");
	document.write ("				<option value='24'>24</option>");
	document.write ("				<option value='25'>25</option>");
	document.write ("				<option value='26'>26</option>");
	document.write ("				<option value='27'>27</option>");
	document.write ("				<option value='28'>28</option>");
	document.write ("				<option value='29'>29</option>");
	document.write ("				<option value='30'>30</option>");
	document.write ("				<option value='31'>31</option>");
	document.write ("			</select>");
	document.write ("		</td>");
	document.write ("		<td class='view_item'>");
	document.write ("			<select class='select' name='" + namemes + "' id='" + namemes + "'>");
	document.write ("				<option value='00'>--</option>");
	document.write ("				<option value='01'>01</option>");
	document.write ("				<option value='02'>02</option>");
	document.write ("				<option value='03'>03</option>");
	document.write ("				<option value='04'>04</option>");
	document.write ("				<option value='05'>05</option>");
	document.write ("				<option value='06'>06</option>");
	document.write ("				<option value='07'>07</option>");
	document.write ("				<option value='08'>08</option>");
	document.write ("				<option value='09'>09</option>");
	document.write ("				<option value='10'>10</option>");
	document.write ("				<option value='11'>11</option>");
	document.write ("				<option value='12'>12</option>");
	document.write ("			</select>");
	document.write ("		</td>");	
	document.write ("		<td class='view_item'>");
	document.write ("			<select class='select' name='" + nameano + "' id='" + nameano + "'>");
	document.write ("				<option value='0000'>----</option>");
	for (i; i <= a; i++) {
		if(i == a) {
			document.write ("			<option value='" + i + "' selected>" + i + "</option>");
		} else {
			document.write ("			<option value='" + i + "'>" + i + "</option>");
		}
	}
	document.write ("			</select>");
	document.write ("		</td>");	
	document.write ("	</tr>");
	document.write ("</table>");
	
	seleccionarHoy(namedia, namemes, nameano, campoFinal);
	
}

function obtenerCamposFechaFuturo2(namedia, namemes, nameano, campoFinal, f) {
	var i;	
	if (navigator.appName == 'Netscape') {
		i = ano + 1900 -5;
		a = ano + 1900 + f;
	} else {
		i = ano - 5; 
		a = ano + f;
	}
	
	document.write ("<table>");
	document.write ("	<tr align='center'>");
	document.write ("		<td class='view_item'>DD</td>");
	document.write ("		<td class='view_item'>MM</td>");
	document.write ("		<td class='view_item'>YYYY</td>");
	document.write ("	</tr>");
	document.write ("	<tr>");
	document.write ("		<td class='view_item'>");
	document.write ("			<select class='select' name='" + namedia + "' id='" + namedia + "'>");
	document.write ("				<option value='00'>--</option>");
	document.write ("				<option value='01'>01</option>");
	document.write ("				<option value='02'>02</option>");
	document.write ("				<option value='03'>03</option>");
	document.write ("				<option value='04'>04</option>");
	document.write ("				<option value='05'>05</option>");
	document.write ("				<option value='06'>06</option>");
	document.write ("				<option value='07'>07</option>");
	document.write ("				<option value='08'>08</option>");
	document.write ("				<option value='09'>09</option>");
	document.write ("				<option value='10'>10</option>");
	document.write ("				<option value='11'>11</option>");
	document.write ("				<option value='12'>12</option>");
	document.write ("				<option value='13'>13</option>");
	document.write ("				<option value='14'>14</option>");
	document.write ("				<option value='15'>15</option>");
	document.write ("				<option value='16'>16</option>");
	document.write ("				<option value='17'>17</option>");
	document.write ("				<option value='18'>18</option>");
	document.write ("				<option value='19'>19</option>");
	document.write ("				<option value='20'>20</option>");
	document.write ("				<option value='21'>21</option>");
	document.write ("				<option value='22'>22</option>");
	document.write ("				<option value='23'>23</option>");
	document.write ("				<option value='24'>24</option>");
	document.write ("				<option value='25'>25</option>");
	document.write ("				<option value='26'>26</option>");
	document.write ("				<option value='27'>27</option>");
	document.write ("				<option value='28'>28</option>");
	document.write ("				<option value='29'>29</option>");
	document.write ("				<option value='30'>30</option>");
	document.write ("				<option value='31'>31</option>");
	document.write ("			</select>");
	document.write ("		</td>");
	document.write ("		<td class='view_item'>");
	document.write ("			<select class='select' name='" + namemes + "' id='" + namemes + "'>");
	document.write ("				<option value='00'>--</option>");
	document.write ("				<option value='01'>01</option>");
	document.write ("				<option value='02'>02</option>");
	document.write ("				<option value='03'>03</option>");
	document.write ("				<option value='04'>04</option>");
	document.write ("				<option value='05'>05</option>");
	document.write ("				<option value='06'>06</option>");
	document.write ("				<option value='07'>07</option>");
	document.write ("				<option value='08'>08</option>");
	document.write ("				<option value='09'>09</option>");
	document.write ("				<option value='10'>10</option>");
	document.write ("				<option value='11'>11</option>");
	document.write ("				<option value='12'>12</option>");
	document.write ("			</select>");
	document.write ("		</td>");	
	document.write ("		<td class='view_item'>");
	document.write ("			<select class='select' name='" + nameano + "' id='" + nameano + "'>");
	document.write ("				<option value='0000'>----</option>");

	for (a; a >= i; a--) {
		if(i == a) {
			document.write ("			<option value='" + a + "' selected>" + a + "</option>");
		} else {
			document.write ("			<option value='" + a + "'>" + a + "</option>");
		}
	}
	document.write ("			</select>");
	document.write ("		</td>");	
	document.write ("	</tr>");
	document.write ("</table>");
	
	seleccionarHoy2(namedia, namemes, nameano, campoFinal);
	
}

function CamposHora(hora, minuto, ampm, campoFinal)	{
	document.write ("<table>");
	document.write ("	<tr align='center'>");
	document.write ("		<td class='view_item'>hh</td>");
	document.write ("		<td class='view_item'>mm</td>");
	document.write ("		<td class='view_item'>AM/PM</td>");
	document.write ("	</tr>");
	document.write ("	<tr>");
	document.write ("		<td class='view_item'>");
	document.write ("			<select class='select' name='" + hora + "' id='" + hora + "'>");
	document.write ("				<option value='100'> </option>");
	document.write ("				<option value='101'>01</option>");
	document.write ("				<option value='102'>02</option>");
	document.write ("				<option value='103'>03</option>");
	document.write ("				<option value='104'>04</option>");
	document.write ("				<option value='105'>05</option>");
	document.write ("				<option value='106'>06</option>");
	document.write ("				<option value='107'>07</option>");
	document.write ("				<option value='108'>08</option>");
	document.write ("				<option value='109'>09</option>");
	document.write ("				<option value='110'>10</option>");
	document.write ("				<option value='111'>11</option>");
	document.write ("				<option value='112'>12</option>");	
	document.write ("			</select>");
	document.write ("		</td>");
	document.write ("		<td class='view_item'>");
	document.write ("			<select class='select' name='" + minuto + "' id='" + minuto + "'>");	
	document.write ("				<option value='60'> </option>");
	document.write ("				<option value='00'>00</option>");
	document.write ("				<option value='05'>05</option>");
	document.write ("				<option value='10'>10</option>");
	document.write ("				<option value='15'>15</option>");
	document.write ("				<option value='20'>20</option>");
	document.write ("				<option value='25'>25</option>");
	document.write ("				<option value='30'>30</option>");
	document.write ("				<option value='35'>35</option>");
	document.write ("				<option value='40'>40</option>");
	document.write ("				<option value='45'>45</option>");
	document.write ("				<option value='50'>50</option>");
	document.write ("				<option value='55'>55</option>");	
	document.write ("			</select>");
	document.write ("		</td>");	
	document.write ("		<td class='view_item'>");
	document.write ("			<select class='select' name='" + ampm + "' id='" + ampm + "'>");
	document.write ("				<option value='00'>AM</option>");
	document.write ("				<option value='01'>PM</option>");	
	document.write ("			</select>");
	document.write ("		</td>");	
	document.write ("	</tr>");
	document.write ("</table>");
		
	seleccionarHoraActual(hora, minuto, ampm, campoFinal);
}

function seleccionarHoraActual(hora, minuto, ampm, campoFinal)  {
	if( document.getElementById( campoFinal ).value.length > 1 ){
		var valorHora = document.getElementById( campoFinal ).value.substring(1,3);
		var valorMinuto = ConvertirMinutoASelect( document.getElementById( campoFinal ).value.substring(4,6) );
		var valorAMPM = document.getElementById( campoFinal ).value.substring(7,9);
		
		document.getElementById( hora ).options[ parseInt(valorHora, 10) ].selected = 'selected';	
		document.getElementById( minuto ).options[ parseInt(valorMinuto, 10) ].selected = 'selected';	
		document.getElementById( ampm ).options[ parseInt(valorAMPM, 10) ].selected = 'selected';	
				
	} else {
		document.getElementById( hora ).options[0].selected = 'selected';	
		document.getElementById( minuto ).options[0].selected = 'selected';	
		document.getElementById( ampm ).options[0].selected = 'selected';	
	}
}




function convertirACampoHora(hora, minuto, ampm, nombreFinal){
	valorFinal = document.getElementById( hora ).value + document.getElementById( minuto ).value + document.getElementById( ampm ).value;
	eval("document.all." + nombreFinal + ".value = '" + valorFinal + "'");	
}

function ConvertirMinutoASelect(minuto) {
	if(minuto=="00") return 1;
	if(minuto=="05") return 2;
	if(minuto=="10") return 3;
	if(minuto=="15") return 4;
	if(minuto=="20") return 5;
	if(minuto=="25") return 6;
	if(minuto=="30") return 7;
	if(minuto=="35") return 8;
	if(minuto=="40") return 9;
	if(minuto=="45") return 10;
	if(minuto=="50") return 11;
	if(minuto=="55") return 12;
	if(minuto=="60") return 0;	
}
