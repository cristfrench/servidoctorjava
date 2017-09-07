// funciones.js
function soloLectura(){
	var contadorForms = 0;
	var contadorElements = 0;
	while (eval('document.forms['+contadorForms+'] != undefined')){
		while (eval('document.forms['+contadorForms+'].elements['+contadorElements+'] != undefined')){
			eval('document.forms['+contadorForms+'].elements['+contadorElements+'].disabled = true');
			contadorElements++;
		}
		contadorElements = 0;
		contadorForms++;
	}
}

//Cierra sesi�n y la pagina
function logout(){
    top.location = '/ServiDoctor/logout.do'
    top.close();
}

// se utiliza en los tag select que deben activar o desactivar un campo deacuerdo a el elemento escogido
function disableDinamique(objectAfected, objectCause){
	if (objectCause.value == '0' || objectCause.value === 0){
		objectAfected.disabled = false;
	}else{
		objectAfected.value = '';
		objectAfected.disabled = true;
	}
}
// newFunction

function tab(t,tab_cook,module)
{
	var x=1;

	while(eval("document.all.tab"+x)!=null && x < 11) {
		eval("document.all.tab"+x+".style.display='none'"); 
		if (module == "family") {
			eval("document.all.tab1"+x+".style.backgroundColor='#FFF0B7'");
		}
		if (module == "pets") {
			eval("document.all.tab1"+x+".style.backgroundColor='#EDFECB'");
		}
		if (module == "cars") {
			eval("document.all.tab1"+x+".style.backgroundColor='#D6E1EE'");
		}
		x++;
	}
	eval("document.all.tab"+t+".style.display=''"); 
	eval("document.all.tab1"+t+".style.backgroundColor='#ffffff'");
	//eval("document.all.tab1"+t+".style.color='#ffffff'");
	setCookie(tab_cook,t)
}

function tab_charge(tab_cook,module)
{

var t=getCookie(tab_cook);

if(t==null)
t=1;

var x=1;

while(eval("document.all.tab"+x)!=null && x < 11)
{
eval("document.all.tab"+x+".style.display='none'");
if (module == "family"){
eval("document.all.tab1"+x+".style.backgroundColor='#FFF0B7'");
}
if (module == "pets"){
eval("document.all.tab1"+x+".style.backgroundColor='#EDFECB'");
}
if (module == "cars"){
eval("document.all.tab1"+x+".style.backgroundColor='#D6E1EE'");
}
//eval("document.all.tab1"+x+".style.color='#000066'");
x++;
}
eval("document.all.tab"+t+".style.display=''"); 
eval("document.all.tab1"+t+".style.backgroundColor='#ffffff'");
//eval("document.all.tab1"+t+".style.color='#ffffff'");


}

function mostrarVacunasMascota(value){
			if(value==0){
				document.all.vacunasPerro.style.display="";
				document.all.vacunasGato.style.display="none";
			}else{
				document.all.vacunasPerro.style.display="none";
				document.all.vacunasGato.style.display="";
			}
		}
		

//---------------------------------------------------------


function setCookie (name, value, expire) {
  var expires;
  
  if (expire)
   expires = "; expires=" + expire.toGMTString();
  else
    expires = "";
  
  document.cookie = name + "=" + escape(value) + expires +  "; path=/";
} // setCookie

//---------------------------------------------------------

function getCookie (Name) {
  var end;
  var search;
  var offset;
  var value;
  var allcookies = document.cookie;
  
  search = Name + "=";

  if (allcookies.length > 0) {    
    offset = allcookies.indexOf(search);

    if (offset != -1) {
      offset += search.length;
      
      end = allcookies.indexOf(";", offset);
      
      if (end == -1) end = allcookies.length;

      value = unescape(allcookies.substring(offset, end));
    }
    else
      value = null;
  }
  else
    value = null;
    
  return value;
}
function enviar(action){
	document.forms[0].action=action
	document.forms[0].submit();
}

function Trim(TRIM_VALUE){
if(TRIM_VALUE.length < 1){
return"";
}
TRIM_VALUE = RTrim(TRIM_VALUE);
TRIM_VALUE = LTrim(TRIM_VALUE);
if(TRIM_VALUE==""){
return "";
}
else{
return TRIM_VALUE;
}
}

function RTrim(VALUE){
var w_space = String.fromCharCode(32);
var v_length = VALUE.length;
var strTemp = "";
if(v_length < 0){
return"";
}
var iTemp = v_length -1;

while(iTemp > -1){
if(VALUE.charAt(iTemp) == w_space){
}
else{
strTemp = VALUE.substring(0,iTemp +1);
break;
}
iTemp = iTemp-1;

} 
return strTemp;

} 

function LTrim(VALUE){
var w_space = String.fromCharCode(32);
if(v_length < 1){
return"";
}
var v_length = VALUE.length;
var strTemp = "";

var iTemp = 0;

while(iTemp < v_length){
if(VALUE.charAt(iTemp) == w_space){
}
else{
strTemp = VALUE.substring(iTemp,v_length);
break;
}
iTemp = iTemp + 1;
} 
return strTemp;
} 


function isNatural(texto){
    //texto = sinEspaciosIniciales(texto);
 while (isNaN(texto.value)){
        texto.value = texto.value.substring(0,texto.value.length-1);
    }
    if (texto.value.indexOf (".") != -1){
        texto.value = texto.value.substring(0,texto.value.indexOf("."));
    }
    if (texto.value.indexOf("-") != -1){
        texto.value = texto.value.substring(1, texto.value.length);
    }
}

function sinEspaciosIniciales (s)
{   
 var whitespace = " \t\n\r"; 
 var i = 0;
    while ((i < s.value.length) && charInString (s.value.charAt(i), whitespace))
       i++;
    if (i>0){
        s.value = s.value.substring (i, s.value.length);
    }
    return s;
}

function charInString (c, s)
{   for (i = 0; i < s.length; i++)
    {   if (s.charAt(i) == c) return true;
    }
    return false
}


function mail(campo){ 
    var texto=Trim(campo.value);
    var mailres = true;             
    var cadena = "abcdefghijklmn�opqrstuvwxyzABCDEFGHIJKLMN�OPQRSTUVWXYZ1234567890@._-"; 
     
    var arroba = texto.indexOf("@",0); 
    if ((texto.lastIndexOf("@")) != arroba) arroba = -1; 
     
    var punto = texto.lastIndexOf("."); 
                 
     for (var contador = 0 ; contador < texto.length ; contador++){ 
        if (cadena.indexOf(texto.substr(contador, 1),0) == -1){ 
            mailres = false; 
            break; 
     } 
    } 

    if ((arroba > 1) && (arroba + 1 < punto) && (punto + 1 < (texto.length)) && (mailres == true) && (texto.indexOf("..",0) == -1)) 
       mailres = true; 
    else {
       campo.value='';
       return false;
    }       
    return true;          
 }
 
 function isFloat(texto, length, decimalLength){
    texto = sinEspaciosIniciales(texto);
 
    while (isNaN(texto.value)){   
        texto.value = texto.value.substring(0,texto.value.length-1);  
    }
 
	miFloat = parseFloat( texto.value);
	if(miFloat < 0){
		miFloat = miFloat * -1;
		texto.value = miFloat;
	}

	if (length != undefined && decimalLength != undefined){
		parteEntera = parseInt(texto.value);
		if ( parteEntera / ( Math.pow( 10, ( length - decimalLength ) ) ) >=1 ){
			if (texto.value.indexOf (".") != -1){
				if (texto.value.substring(texto.value.indexOf(".")).length > decimalLength){
					texto.value = texto.value.substring(0, 3) + texto.value.substring(texto.value.indexOf("."));
				} else {
					texto.value = texto.value.substring(0, 3) + texto.value.substring(texto.value.indexOf("."), texto.value.indexOf(".") + 3);
				}
		    } else {
		    	texto.value = texto.value.substring(0, 3);
		    }
		}
	}
}


function validateDate(dtStr){
  var dtCh= "/";
  var minYear=1900;
  var maxYear=2100;
  var daysInMonth = DaysArray(12)
  var pos1=dtStr.indexOf(dtCh)
  var pos2=dtStr.indexOf(dtCh,pos1+1)
  var strDay=dtStr.substring(0,pos1)
  var strMonth=dtStr.substring(pos1+1,pos2)
  var strYear=dtStr.substring(pos2+1)
  strYr=strYear
  if (strDay.charAt(0)=="0" && strDay.length>1) strDay=strDay.substring(1)
  if (strMonth.charAt(0)=="0" && strMonth.length>1) strMonth=strMonth.substring(1)
  for (var i = 1; i <= 3; i++) {
    if (strYr.charAt(0)=="0" && strYr.length>1) strYr=strYr.substring(1)
  }
  month=parseInt(strMonth)
  day=parseInt(strDay)
  year=parseInt(strYr)
  if (pos1==-1 || pos2==-1){
    return "El Formato de la fecha debe ser : dd/mm/aaaa"
  }
  if (strMonth.length<1 || month<1 || month>12){
    return "Por favor ingrese un mes v�lido"
  }
  if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]){
    return "Por favor ingrese un d�a v�lido"
  }
  if (strYear.length != 4 || year==0 || year<minYear || year>maxYear){
    return "Por favor ingrese un a�o v�lido entre "+minYear+" y "+maxYear
  }
  if (dtStr.indexOf(dtCh,pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr, dtCh))==false){
    return "Por favor ingrese una fecha v�lida"
  }
  return ""

}


function daysInFebruary (year){
  // February has 29 days in any year evenly divisible by four,
  // EXCEPT for centurial years which are not also divisible by 400.
  return (((year % 4 == 0) && ( (!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28 );
}

function stripCharsInBag(s, bag){
  var i;
  var returnString = "";
  // Search through string's characters one by one.
  // If character is not in bag, append to returnString.
  for (i = 0; i < s.length; i++){   
    var c = s.charAt(i);
    if (bag.indexOf(c) == -1) returnString += c;
  }
  return returnString;
}


function isInteger(s){
  var i;
  for (i = 0; i < s.length; i++){   
    // Check that current character is number.
    var c = s.charAt(i);
    if (((c < "0") || (c > "9")))
      return false;
  }
  // All characters are numbers.
  return true;
}


function DaysArray(n) {
  for (var i = 1; i <= n; i++) {
    this[i] = 31
    if (i==4 || i==6 || i==9 || i==11) {this[i] = 30}
    if (i==2) {this[i] = 29}
  } 
  return this
}
function creaFecha(fecha){
	return new Date(fecha.substring(0,5),fecha.substring(5,6),fecha.substring(7,8));
}

function restaFechas(fecha1,fecha2){
	return (fecha1.substring(0,5)-fecha2.substring(0,5))*365+(fecha1.substring(5,6)-fecha2.substring(5,6))*30+(fecha1.substring(7,8)-fecha2.substring(7,8))
}

//Harry El pote Arango
//---------------------------------------------------------
function hay_popup_abierto(){//con esto detecto si hay popup abierto
	if(getCookie('POPUP') == null || getCookie('POPUP') == 0){//no hay POPUP
		setCookie('POPUP',1)//actualizo el cookie
		return false;
	}else{
		if(getCookie('POPUP') >= 1){//hay 1 POPUP
			//setCookie('POPUP',2)//actualizo el cookie
			//alert("Lo sentimos, hay un POPUP abierto, por favor cierrelo.")
			alert('Lo sentimos, hay un POPUP abierto, por favor cierrelo.\n\n Sorry , you have open a POPUP , please close it');
			return true;
		}else{
			return true;
		}
	}
}
//---------------------------------------------------------
function actualiza_popup_abierto(){
	if(getCookie('POPUP') >= 0){//hay 1 o + POPUP
		setCookie('POPUP',0);//actualizo el cookie
	}else{//hay menos de 1 VENTANA
		setCookie('POPUP',0);
	}
}

//AJAX
function actualizarCiudades(pais_cod, ciudadesContent) {
    if (window.XMLHttpRequest) { // Non-IE browsers
      req = new XMLHttpRequest();
      req.onreadystatechange = function(){
      	actualizarCiudadesProcessStateChange(ciudadesContent);
      };
      try {
        
        req.open("GET", "/ServiDoctor/actualizarCiudades.do?pais_cod=" + pais_cod, true);
      } catch (e) {
        alert(e);
      }
      req.send(null);
    } else if (window.ActiveXObject) { // IE
      //try {
		
		//req = new ActiveXObject("Msxml2.XMLHTTP");
		//} catch(e) {
			try {
				//xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
				req = new ActiveXObject("Microsoft.XMLHTTP");
				
			} catch(e) {
				alert("Your browser does not support XMLHTTP!");
				req = false;
			}
		//}
	    if (req){
	    
		    req.onreadystatechange=function(){
			    var	ciudadesContent = "ciudadesContent";
			
			    if (req.readyState===1){
			        // Mientras carga elimino la opcion "Selecciona ..." y pongo una que dice "Cargando..."
			        document.getElementById(ciudadesContent).length=0;
			        var nuevaOpcion=document.createElement("option"); 
			        nuevaOpcion.value=0; 
			        nuevaOpcion.innerHTML="...";
			        document.getElementById(ciudadesContent).appendChild(nuevaOpcion);    
			    }
			    if (req.readyState === 4) { // Complete
			      /*if (req.status == 200) { // OK response
			      	try{*/
			      		document.getElementById(ciudadesContent).length=0;
			//      		document.getElementById(ciudadesContent).innerHTML = req.responseText;
						select_innerHTML(document.getElementById(ciudadesContent), req.responseText);
			      	//} catch (e){
			      		//alert('error haciendo innerHTML' + e);
			      	//}
			      //} else {
			       // alert("Problem: " + req.statusText);
			      ///}
	   		   }
			}
			req.open("GET", "/ServiDoctor/actualizarCiudades.do?pais_cod=" + pais_cod, true);
			req.send(null);


      }
    }
  }

  function actualizarCiudadesProcessStateChange(ciudadesContent) {
    if (ciudadesContent == undefined){
      		ciudadesContent = "ciudadesContent";
      	}
    if (req.readyState==1){
        // Mientras carga elimino la opcion "Selecciona ..." y pongo una que dice "Cargando..."
        document.getElementById(ciudadesContent).length=0;
        var nuevaOpcion=document.createElement("option"); 
        nuevaOpcion.value=0; 
        nuevaOpcion.innerHTML="...";
        document.getElementById(ciudadesContent).appendChild(nuevaOpcion);    
    }
    if (req.readyState == 4) { // Complete
      if (req.status == 200) { // OK response
      	try{
      		document.getElementById(ciudadesContent).length=0;
//      		document.getElementById(ciudadesContent).innerHTML = req.responseText;
			select_innerHTML(document.getElementById(ciudadesContent), req.responseText);
      	} catch (e){
      		alert('error haciendo innerHTML' + e);
      	}
      } else {
        alert("Problem: " + req.statusText);
      }
      req.onreadystatechange=null;
    }
  }
 
   function actualizarCiudadesProcessStateChange2() {
    var	ciudadesContent = "ciudadesContent";
    if (req.readyState==1){
        // Mientras carga elimino la opcion "Selecciona ..." y pongo una que dice "Cargando..."
        document.getElementById(ciudadesContent).length=0;
        var nuevaOpcion=document.createElement("option"); 
        nuevaOpcion.value=0; 
        nuevaOpcion.innerHTML="...";
        document.getElementById(ciudadesContent).appendChild(nuevaOpcion);    
    }
    if (req.readyState == 4) { // Complete
      if (req.status == 200) { // OK response
      	try{
      		document.getElementById(ciudadesContent).length=0;
//      		document.getElementById(ciudadesContent).innerHTML = req.responseText;
			select_innerHTML(document.getElementById(ciudadesContent), req.responseText);
      	} catch (e){
      		alert('error haciendo innerHTML' + e);
      	}
      } else {
        alert("Problem: " + req.statusText);
      }
      req.onreadystatechange=null;
    }
  }
 
 
  
  function select_innerHTML(objeto,innerHTML){
/******
* select_innerHTML - corrige o bug do InnerHTML em selects no IE
* Veja o problema em: http://support.microsoft.com/default.aspx?scid=kb;en-us;276228
* Vers�o: 2.1 - 04/09/2007
* Autor: Micox - N�iron Jos� C. Guimar�es - micoxjcg@yahoo.com.br
* @objeto(tipo HTMLobject): o select a ser alterado
* @innerHTML(tipo string): o novo valor do innerHTML
*******/
    objeto.innerHTML = ""
    var selTemp = document.createElement("micoxselect")
    var opt;
    selTemp.id="micoxselect1"
    document.body.appendChild(selTemp)
    selTemp = document.getElementById("micoxselect1")
    selTemp.style.display="none"
    if(innerHTML.toLowerCase().indexOf("<option")<0){//se n�o � option eu converto
        innerHTML = "<option>" + innerHTML + "</option>"
    }
    innerHTML = innerHTML.replace(/<option/g,"<span").replace(/<\/option/g,"</span")
    selTemp.innerHTML = innerHTML
      
    
    for(var i=0;i<selTemp.childNodes.length;i++){
  var spantemp = selTemp.childNodes[i];
  
        if(spantemp.tagName){     
            opt = document.createElement("OPTION")
    
   if(document.all){ //IE
    objeto.add(opt)
   }else{
    objeto.appendChild(opt)
   }       
    
   //getting attributes
   for(var j=0; j<spantemp.attributes.length ; j++){
    var attrName = spantemp.attributes[j].nodeName;
    var attrVal = spantemp.attributes[j].nodeValue;
    if(attrVal){
     try{
      opt.setAttribute(attrName,attrVal);
      opt.setAttributeNode(spantemp.attributes[j].cloneNode(true));
     }catch(e){}
    }
   }
   //getting styles
   if(spantemp.style){
    for(var y in spantemp.style){
     try{opt.style[y] = spantemp.style[y];}catch(e){}
    }
   }
   //value and text
   opt.value = spantemp.getAttribute("value")
   opt.text = spantemp.innerHTML
   //IE
   opt.selected = spantemp.getAttribute('selected');
   opt.className = spantemp.className;
  } 
 }    
 document.body.removeChild(selTemp)
 selTemp = null
}