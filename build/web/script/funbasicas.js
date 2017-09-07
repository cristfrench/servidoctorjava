
function setVariables() {
horz=".pixelLeft";
vert=".pixelTop";
docStyle="";
styleDoc=".style";
offsetX="document.body.scrollLeft";
offsetY="document.body.scrollTop";
}


function checkLocation() {
objectXY="branding";
var currentX=eval(offsetX);
var currentY=eval(offsetY);
x=currentX;
y=currentY;
evalMove();
setTimeout("checkLocation()",100);
}


function evalMove() {
eval(docStyle + objectXY + styleDoc + horz + "=" + x);
eval(docStyle + objectXY + styleDoc + vert + "=" + y);
}


function menuDesp(Lay){
 Cab=eval(Lay.id)
 with (Cab.style) 
 if (display=="none")
    display="" 
   else 
    display="none" 
}


function maymin(forma,nombre) { 
var may = eval("document." + forma + "." + nombre)
var mayusc = eval(forma + "." + nombre + ".value.toUpperCase()")
may.value = mayusc
}


function tiponumerico(forma,nombre) { 
var valor1 = eval("document." + forma + "." + nombre + ".value")
if(isNaN(valor1)){
alert("Debe ingresar un valor númerico")
eval("document." + forma + "." + nombre + ".value = ''")
eval("document." + forma + "." + nombre + ".focus()")
 }
}

//  End -->