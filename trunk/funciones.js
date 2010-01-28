// JavaScript Document
function llamarasincrono(url, id_contenedor){
var pagina_requerida = false
if (window.XMLHttpRequest) {// Si es Mozilla, Safari etc
pagina_requerida = new XMLHttpRequest()
} else if (window.ActiveXObject){ // pero si es IE
try {
pagina_requerida = new ActiveXObject("Msxml2.XMLHTTP")
} 
catch (e){ // en caso que sea una versi�n antigua
try{
pagina_requerida = new ActiveXObject("Microsoft.XMLHTTP")
}
catch (e){}
}
}
else
return false
pagina_requerida.onreadystatechange=function(){ // funci�n de respuesta
cargarpagina(pagina_requerida, id_contenedor)
}
pagina_requerida.open('GET', url, true) // asignamos los m�todos open y send
pagina_requerida.send(null)
}
// todo es correcto y ha llegado el momento de poner la informaci�n requerida
// en su sitio en la pagina xhtml
function cargarpagina(pagina_requerida, id_contenedor){
if (pagina_requerida.readyState == 4 && (pagina_requerida.status==200 || window.location.href.indexOf("http")==-1))
document.getElementById(id_contenedor).innerHTML=pagina_requerida.responseText
}

function zoomText(Accion,Elemento){
//inicializacion de variables y par�metros
var obj=document.getElementById(Elemento);
var max = 300 //tama�o m�ximo del fontSize
var min = 70 //tama�o m�nimo del fontSize
if (obj.style.fontSize==""){
obj.style.fontSize="100%";
}
actual=parseInt(obj.style.fontSize); //valor actual del tama�o del texto
incremento=10;// el valor del incremento o decremento en el tama�o

//accion sobre el texto
if( Accion=="aumentar" && ((actual+incremento) <= max )){
valor=actual+incremento;
obj.style.fontSize=valor+"%"
}
if( Accion=="disminuir" && ((actual+incremento) >= min )){
valor=actual-incremento;
obj.style.fontSize=valor+"%"
}
} 