<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ page import="java.lang.Float"%>
<%@ page import="java.math.BigDecimal"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%@ page import="com.servidoctor.util.classes.ManejoFechas"%>
<%@ page import="com.servidoctor.constantes.IConstantes"%>

<%@ page import="com.servidoctor.sdcars.model.GrupoUsuarioSegmentacion"%>
<%@ page import="com.servidoctor.sdcars.model.LogoComprador"%>
<%@ page import="com.servidoctor.sdcars.dao.GrupoUsuarioSegmentacionDAO"%>
<%@ page import="com.servidoctor.sdcars.dao.LogoCompradorDAO"%>
<%@ page import="com.servidoctor.seguridad.model.UsuarioCar"%>
<%@ page import="com.servidoctor.parametros.model.RevisionesVehiculo"%>
<%@ page import="com.servidoctor.parametros.dao.RevisionesVehiculoDAO"%>

<%@ page import="com.servidoctor.sdcars.controller.VehiculosCompletoForm"%>


<%@ page import="com.servidoctor.sdcars.model.MantenimientoGeneral"%>
<%@ page import="com.servidoctor.sdcars.dao.MantenimientoGeneralDAO"%>
<%@ page import="org.apache.struts.util.MessageResources,com.servidoctor.sdcars.model.Vehiculos,com.servidoctor.sdcars.dao.VehiculosDAO,com.servidoctor.seguridad.model.UsuarioCar,java.util.List"%>
<%!MessageResources res = MessageResources.getMessageResources( "com.servidoctor.resources.ApplicationResources" );%>

<SCRIPT language="JavaScript">
	function ayuda(ayuda){
  		window.open('<%=request.getContextPath()%>/Popup_ayuda.jsp?ayuda='+ayuda+'','ayuda','scrollbars=yes, top=100, left=200, width=650, height=480')
	}
	function enviarCancelar(ruta){
		document.forms[0].reset();
		document.forms[0].action = ruta;
	}
   	function enviarD(ruta){
   		

// *************************************************ODOMETRO**************************************************************
		var odometroesCero= 0;
      	//Validation about basic info
      	 	      	//Searching closest previous date   	

	      	<% 	UsuarioCar usuarioCar2 = (UsuarioCar) request.getSession().getAttribute("usuarioCar"); 
	      		VehiculosDAO vehiculosDAO = new  VehiculosDAO(); 
	      		Vehiculos vehiculosC=vehiculosDAO.retrieveCarByUser(usuarioCar2.getUsuc_cod());       		
	      		MantenimientoGeneralDAO mantenimientoGeneralDao = new MantenimientoGeneralDAO();
				BigDecimal mant_cod=new BigDecimal(1);
				MantenimientoGeneral mantenimientoGeneral = mantenimientoGeneralDao.retrive(mant_cod, vehiculosC.getVehi_cod());
	      		RevisionesVehiculoDAO revisionesVehiculoDAO1 = new RevisionesVehiculoDAO(); 
	      		List revisionVehiculoA = revisionesVehiculoDAO1.list2(vehiculosC.getVehi_cod());
	      		BigDecimal ultimaFecha= ManejoFechas.getUltimaFecha(vehiculosC,request,mantenimientoGeneral,revisionVehiculoA);     		 
				List revisionesVehiculo1 = (List) request.getSession().getAttribute("REVISIONES");
	      	%>
      	if (document.all.tab1.style.display==''){
     	   		hoy = new Date(); 
			var anio= hoy.getFullYear().toString();
			var mes=hoy.getMonth(); 
			mes=mes+1;
			if (mes<10){
				var mesac='0' + mes.toString();
			}else{
				var mesac=mes.toString();
			}
			var dia=hoy.getDate();
			if (dia<10){
				var diaa='0' + dia.toString();
			}else{
				var diaa=dia.toString();
			}			
			var today = anio + mesac + diaa;
			
	       	if(document.forms[0].vehi_placa.value==''){
	        	alert('<bean:message key="5007" />');
	         	document.forms[0].vehi_placa.focus();
	         	return false;
	      	}      
	      	if(document.forms[0].vehi_modelo.value=='' || document.forms[0].vehi_modelo.value=='0'){
	        	alert('<bean:message key="5009" />');
	         	document.forms[0].vehi_modelo.focus();
	         	return false;
	      	}      

	      	if(document.forms[0].pveh_nombre.value==''){
	        	alert('<bean:message key="5011" />');
	         	document.forms[0].pveh_nombre.focus();
	         	return false;
	      	}
	      	if(document.forms[0].pveh_apellido.value==''){
	        	alert('<bean:message key="5012" />');
	         	document.forms[0].pveh_apellido.focus();
	         	return false;
	      	}      

    	}
      	
      	
      	//alert(document.getElementById('vehi_fechaencero2').value+'-'+document.getElementById('vehi_fechaencero').value);
      	// Revisions Case ADDING COTROL AND MAINTENANCES
      	if (document.all.tab9.style.display==''){
            if (document.getElementById('vehi_fechaencero2').value!=null ||document.getElementById('vehi_fechaencero2').value!=''||document.getElementById('vehi_fechaencero2').value!=0){
	            dd1 = document.getElementById('vehi_fechaencero2').value.substring(8, 10);		
	      		dd = document.getElementById('vehi_fechaencero2').value.substring(8, 10);		
				mm1 = document.getElementById('vehi_fechaencero2').value.substring(5, 7);
				mm = document.getElementById('vehi_fechaencero2').value.substring(5, 7);
				aa = document.getElementById('vehi_fechaencero2').value.substring(0, 4);		
				document.getElementById('vehi_fechaencero2').value=aa+mm+dd;
				//document.getElementById('vehi_fechaencero').value=aa+mm+dd;
				setCookie('OdometroCero',0);	
			}
			if (document.getElementById('tempcero').value!=null && document.getElementById('tempcero').value!='' && document.getElementById('tempcero').value!=0){
				dd1 = document.getElementById('tempcero').value.substring(8, 10);		
	      		dd = document.getElementById('tempcero').value.substring(8, 10);		
				mm1 = document.getElementById('tempcero').value.substring(5, 7);
				mm = document.getElementById('tempcero').value.substring(5, 7);
				aa = document.getElementById('tempcero').value.substring(0, 4);		
				document.getElementById('vehi_fechaencero2').value=aa+mm+dd;
				document.getElementById('tempcero').value=aa+mm+dd;	
				setCookie('OdometroCero',0);
			}
      	}
      	
	      if((document.forms[0].pveh_indpais1.value=='' || document.forms[0].pveh_indpais1.value=='0'||
				document.forms[0].pveh_indciudad1.value=='' || document.forms[0].pveh_indciudad1.value=='0'||
				document.forms[0].pveh_telefono1.value=='' || document.forms[0].pveh_telefono1.value=='0')&&
				(document.forms[0].pveh_indpais2.value=='' || document.forms[0].pveh_indpais2.value=='0'||
				document.forms[0].pveh_telefono2.value==''||document.forms[0].pveh_telefono2.value=='0')){
				alert('<bean:message key="5014" />');
				document.forms[0].pveh_indpais1.focus();
				return false;
	      }
	      
      	if(!mail(document.forms[0].pveh_mail) || document.forms[0].pveh_mail.value==''){
        	alert('<bean:message key="5019" />');
         	document.forms[0].pveh_mail.focus();
         	return false;
      	}      
		
		convertirACampo('cDia1', 'cMes1', 'cAno1', 'vehi_feccomp');
		convertirACampo('cDia2', 'cMes2', 'cAno2', 'com_fechaini');
		convertirACampo('cDia3', 'cMes3', 'cAno3', 'com_fechafin');

		fechaCeroOdometro=document.getElementById('tempcero').value;
		
		if (fechaCeroOdometro!=0){
			dd1 = document.getElementById('vehi_fechaencero2').value.substring(8, 10);		
      		dd = document.getElementById('vehi_fechaencero2').value.substring(8, 10);		
			mm1 = document.getElementById('vehi_fechaencero2').value.substring(5, 7);
			mm = document.getElementById('vehi_fechaencero2').value.substring(5, 7);
			aa = document.getElementById('vehi_fechaencero2').value.substring(0, 4);		
			document.getElementById('vehi_fechaencero2').value=aa+mm+dd;
					
		}
		convertirACampo('cDia4', 'cMes4', 'cAno4', 'fechaMantenimientosBasicos');
		convertirACampo('cDia5', 'cMes5', 'cAno5', 'pveh_fecnacim');
		convertirACampo('cDia6', 'cMes6', 'cAno6', 'mant_control_fec');
		
		
		document.forms[0].pveh_mail.disabled = false;
		//Revisiones Bloqueadas no dejarlas pasar
		ListadoBloqueados='';
		<%	 
      		int zX = 0; 
			while (zX < revisionesVehiculo1.size()) {%>
		      	Bloqueado=parseInt(<%=((RevisionesVehiculo)revisionesVehiculo1.get(zX)).getRveh_bloqueado() %>);
				if (Bloqueado==1){
					ListadoBloqueados=ListadoBloqueados+<%=((RevisionesVehiculo)revisionesVehiculo1.get(zX)).getRveh_cod() %>+',';
					
				}

      		<% 	zX++;
      		} %>
      	
      	if (ListadoBloqueados.length>0){
	      	if (document.all.tab9.style.display==''){
		      	ListadoBloqueados=ListadoBloqueados.substring(0,ListadoBloqueados.length-1);  	
		      	if(hay_popup_abierto())
					return false;
		      	window.open('<%=request.getContextPath()%>/manager/sdcars/popup_vehiculos/Popup_bloqueo_save.jsp?ListadoBloqueados='+ListadoBloqueados,'Lista de Controles Bloqueados','scrollbars=yes, top=100, left=200, width=650, height=480');
	      	}

		}else{
			document.forms[0].action = ruta;
			document.forms[0].submit();
		}
	}

	function add_control(tama) {
		if(tama>=<bean:message key="parametro_adicion_controles"/>){
      		alert('<bean:message key="parametro_superado_controles"/>');
      		return false;
		} else {
			if(hay_popup_abierto())
				return false;   			
			eval("window.open('<%=request.getContextPath()%>/DatosVehiculo/Popup/add_control.do?','control','scrollbars=yes, top=100, left=200, width=650, height=370')")
			return true;
		}						
	}

	function Activardiv(dato){
		if (dato % 2 ==0){
			document.getElementById("bobcontent77").style.visibility='visible';
			document.forms[0].vehi_cerorevision.value=1;
			document.getElementById("variable").value=parseInt(document.getElementById("variable").value)+1;
		}else{
			document.getElementById("bobcontent77").style.visibility='hidden';
			document.forms[0].vehi_cerorevision.value=0;
			document.getElementById("variable").value=parseInt(document.getElementById("variable").value)+1;
		}
	}

	function edit_control(x) {
		if(hay_popup_abierto())
			return false;
		eval("window.open('<%=request.getContextPath()%>/DatosVehiculo/Popup/edit_control.do?num_control="+x+"','control','scrollbars=yes, top=100, left=200, width=650, height=350')")
	}
	
	function remove_control(x,nom) {
		var r=confirm('<bean:message key="3548"/>' + " " + nom + "?");	
		if(r) {
			enviarD("<%=request.getContextPath()%>/DatosVehiculo/Popup/remove_control.do?num_control="+x);
		}			
	}
	
	function add_seguro(tama) {  
		if(tama>=<bean:message key="parametro_adicion_seguros"/>){
      		alert('<bean:message key="parametro_superado_seguros"/>');
      		return false;
		} else {
			if(hay_popup_abierto())
				return false;   			
			eval("window.open('<%=request.getContextPath()%>/DatosVehiculo/Popup/add_seguro.do?','seguro','scrollbars=yes, top=0, left=80, width=910, height=720')")		
			return true;
		} 				
   		
	}
	
	function edit_seguro(x) {
		if(hay_popup_abierto())
			return false;
		eval("window.open('<%=request.getContextPath()%>/DatosVehiculo/Popup/edit_seguro.do?num_seguro="+x+"','seguro','scrollbars=yes, top=20, left=50, width=900, height=650')")		
	}
	
	function remove_seguro(x,nom) {
		var r=confirm('<bean:message key="3549"/>' + " " + nom + "?");	
		if(r) {
			enviarD("<%=request.getContextPath()%>/DatosVehiculo/Popup/remove_seguro.do?num_seguro="+x);
		}
	}

	function add_revision(tama) {
		if(tama>=<bean:message key="parametro_adicion_revision"/>){
      		alert('<bean:message key="parametro_superado_revision"/>');
      		return false;
		} else {
			if(hay_popup_abierto())
				return false;   			
			eval("window.open('<%=request.getContextPath()%>/DatosVehiculo/Popup/add_revision.do?','contacto','scrollbars=yes, top=100, left=250, width=690, height=620')")		
			return true;
		}		
	}
	
	function edit_revision(x) {
		if(hay_popup_abierto())
			return false;
		eval("window.open('<%=request.getContextPath()%>/DatosVehiculo/Popup/edit_revision.do?num_revision="+x+"','contacto','scrollbars=yes, top=100, left=250, width=690, height=620')")		
	}

	function remove_revision(x,nom) {
		var r=confirm('<bean:message key="3550"/>' + " " + nom + "?");	
		if(r) {

			enviarD("<%=request.getContextPath()%>/DatosVehiculo/Popup/remove_revision.do?num_revision="+x);
		}
	}

	function undo_revision(x,nom) {
		var r=confirm('<bean:message key="3567"/>' + " " + nom + "?");	
		if(r) {
			enviarD("<%=request.getContextPath()%>/DatosVehiculo/Popup/undo_revision.do?num_revision="+x);
		}
	}
	
	function add_gastoMecanica(tama) {
		if(tama>=<bean:message key="parametro_adicion_gastos_mecanica"/>){
      		alert('<bean:message key="parametro_superado_gastos_mecanica"/>');
      		return false;
		} else {   			
			if(hay_popup_abierto())
				return false;
			eval("window.open('<%=request.getContextPath()%>/DatosVehiculo/Popup/add_gastosmecanica.do?','gastos','scrollbars=yes, top=100, left=200, width=600, height=470')")
			return true;
		}				
	}
	
	function edit_gastoMecanica(x) {
		if(hay_popup_abierto())
			return false;
		eval("window.open('<%=request.getContextPath()%>/DatosVehiculo/Popup/edit_gastosmecanica.do?num_gastosmecanica="+x+"','gasto','scrollbars=yes, top=100, left=200, width=600, height=430')")
	}
	
	function remove_gastoMecanica(x,nom) {
		var r=confirm('<bean:message key="3551"/>' + " " + nom + "?");	
		if(r) {
			enviarD("<%=request.getContextPath()%>/DatosVehiculo/Popup/remove_gastosmecanica.do?num_gastosmecanica="+x);
		}	
	}

	function add_gasto(tama) {
		if(tama>=<bean:message key="parametro_adicion_gastos"/>){
      		alert('<bean:message key="parametro_superado_gastos"/>');
      		return false;
		} else {
			if(hay_popup_abierto())
				return false;		
			eval("window.open('<%=request.getContextPath()%>/DatosVehiculo/Popup/add_gastos.do?','gastos','scrollbars=yes, top=100, left=200, width=550, height=490')")
			return true;
		}			
	}
	
	function edit_gasto(x) {
		if(hay_popup_abierto())
			return false;
		eval("window.open('<%=request.getContextPath()%>/DatosVehiculo/Popup/edit_gastos.do?num_gastos="+x+"','gasto','scrollbars=yes, top=100, left=200, width=550, height=495')")
	}
	
	function remove_gasto(x,nom) {
		var r=confirm('<bean:message key="3552"/>' + " " + nom + "?");	
		if(r) {
			enviarD("<%=request.getContextPath()%>/DatosVehiculo/Popup/remove_gastos.do?num_gastos="+x);
		}
	}

	function add_gastoanuales(tama) {
		if(tama>=<bean:message key="parametro_adicion_gastos_anuales"/>){
      		alert('<bean:message key="parametro_superado_gastos_anuales"/>');
      		return false;
		} else {
			if(hay_popup_abierto()){
				return false;
			}   			
			eval("window.open('<%=request.getContextPath()%>/DatosVehiculo/Popup/add_gastosanuales.do?','gastosanuales','scrollbars=yes, top=100, left=200, width=520, height=410')")
			return true;
		}	   		
	}
	
	function edit_gastoanuales(x) {
		if(hay_popup_abierto())
			return false;
		eval("window.open('<%=request.getContextPath()%>/DatosVehiculo/Popup/edit_gastosanuales.do?num_gastosanuales="+x+"','gastosanuales','scrollbars=yes, top=100, left=200, width=520, height=480')")		
	}
	
	function remove_gastoanuales(x,nom) {
		var r=confirm('<bean:message key="3553"/>' + " " + nom + "?");	
		if(r) {
			enviarD("<%=request.getContextPath()%>/DatosVehiculo/Popup/remove_gastosanuales.do?num_gastosanuales="+x);
		}
	}

	function add_impuestos(tama) {
		
		if(tama>=<bean:message key="parametro_adicion_impuestos"/>){
      		alert('<bean:message key="parametro_superado_impuestos"/>');
      		return false;
		} else {
			if(hay_popup_abierto())
				return false;  			
			eval("window.open('<%=request.getContextPath()%>/DatosVehiculo/Popup/add_impuesto.do?','impuesto','scrollbars=yes, top=100, left=200, width=600, height=400')")		
			return true;
		}		
	}
	
	function edit_impuestos(x) {
		if(hay_popup_abierto())
			return false;
		eval("window.open('<%=request.getContextPath()%>/DatosVehiculo/Popup/edit_impuesto.do?num_impuesto="+x+"','impuesto','scrollbars=yes, top=100, left=200, width=600, height=420')")		
	}
	
	function remove_impuestos(x,nom) {
		var r=confirm('<bean:message key="3554"/>' + " " + nom + "?");	
		if(r) {
			enviarD("<%=request.getContextPath()%>/DatosVehiculo/Popup/remove_impuesto.do?num_impuesto="+x);
		}
	}

	function add_combustible(tama) {
		if(tama>=<bean:message key="parametro_adicion_combustible"/>){
      		alert('<bean:message key="parametro_superado_combustible"/>');
      		return false;
		}else{
			if(hay_popup_abierto())
				return false;
			eval("window.open('<%=request.getContextPath()%>/DatosVehiculo/Popup/add_combustible.do?','combustible','scrollbars=yes, top=100, left=200, width=600, height=370')");		
			return true;
		}
	}
	
	function edit_combustible(x) {
		if(hay_popup_abierto())
			return false;
		eval("window.open('<%=request.getContextPath()%>/DatosVehiculo/Popup/edit_combustible.do?num_combustible="+x+"','combustible','scrollbars=yes, top=100, left=200, width=600, height=320')")		
	}
	
	function remove_combustible(x,nom) {		
		var r=confirm('<bean:message key="3555"/>' + " " + nom + "?");	
		if(r) {
			enviarD("<%=request.getContextPath()%>/DatosVehiculo/Popup/remove_combustible.do?num_combustible="+x);
		}
	}

	function DiferenciaFechas() {	  
  		//Obtiene objetos Date
		var miFecha1 = new Date(document.forms[0].cAno2.value, document.forms[0].cMes2.value, document.forms[0].cDia2.value);
   		var miFecha2 = new Date(document.forms[0].cAno3.value, document.forms[0].cMes3.value, document.forms[0].cDia3.value);

   		//Resta fechas y retorna el valor
   		var diferencia = miFecha2.getTime() - miFecha1.getTime();
   		return diferencia;
	}
	
	function DiferenciaFechas2() {	  
  		//Obtiene objetos Date
		var miFecha1 = new Date(document.forms[0].cAno4.value, document.forms[0].cMes4.value - 1, document.forms[0].cDia4.value);
   		var miFecha2 = new Date();

   		//Resta fechas y retorna el valor
   		var diferencia = miFecha2.getTime() - miFecha1.getTime();
   		return diferencia;
	}
		
	function habilitar() {
		if(document.forms[0].mant_alt_cod.value==1) {
			document.forms[0].mant_cada_cdm.disabled=true;
			document.forms[0].mant_cada_cdk.disabled=false;
		}
		else if(document.forms[0].mant_alt_cod.value==2) {
			document.forms[0].mant_cada_cdm.disabled=false;
			document.forms[0].mant_cada_cdk.disabled=true;
		}
		else if(document.forms[0].mant_alt_cod.value==3) {
			document.forms[0].mant_cada_cdm.disabled=false;
			document.forms[0].mant_cada_cdk.disabled=false;
		}	
	}
	
	
	function cargarCombustible() {
		if(DiferenciaFechas()<=0) {
   			alert('<bean:message key="3530" />');
   			document.forms[0].cDia2.focus();
   			return false
   		}
   		if(document.forms[0].com_lecturaini.value=='' || document.forms[0].com_lecturaini.value=='0') {
			alert('<bean:message key="3561" />');
         	document.forms[0].com_lecturaini.focus();
         	return false;
		}
		if(document.forms[0].com_lecturafin.value=='' || document.forms[0].com_lecturafin.value=='0') {
			alert('<bean:message key="3562" />');
         	document.forms[0].com_lecturafin.focus();
         	return false;
		}
		if(document.forms[0].com_cantidadconsumo.value=='' || document.forms[0].com_cantidadconsumo.value=='0') {
			alert('<bean:message key="3563" />');
         	document.forms[0].com_cantidadconsumo.focus();
         	return false;
		}
		if(document.forms[0].com_costocombustible.value=='' || document.forms[0].com_costocombustible.value=='0') {
			alert('<bean:message key="3564" />');
         	document.forms[0].com_costocombustible.focus();
         	return false;
		}
		
		if(document.forms[0].com_lecturafin.value - document.forms[0].com_lecturaini.value<0){
			alert('<bean:message key="3586" />');
			document.forms[0].com_lecturaini.focus();
         	return false;
		}
		
		var rendimiento = (document.forms[0].com_lecturafin.value - document.forms[0].com_lecturaini.value) / document.forms[0].com_cantidadconsumo.value;
		var costoDistancia = (document.forms[0].com_costocombustible.value / document.forms[0].com_cantidadconsumo.value) / rendimiento;
		var diferencia = DiferenciaFechas();
		var dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
		var costoDia = document.forms[0].com_costocombustible.value / dias;
		
		rendimiento = Math.round(rendimiento * 100);
		rendimiento /= 100;
		
		
		costoDistancia = Math.round(costoDistancia * 100);
		costoDistancia /= 100;
		

		costoDia = Math.round(costoDia * 100);
		costoDia /= 100;
		

		document.forms[0].resultado_rendimientoS.value = rendimiento;
		document.forms[0].resultado_costoDistanciaS.value = costoDistancia;
		document.forms[0].resultado_costoDiaS.value = costoDia;
	}
	
	//Seleccionar fila de la tabla de Mantenimientos Bascios Ultimo Control
	function seleccionar(ch,id) {
		celda = document.getElementById("celda" + id)	
		if(ch.checked) {
			if (id % 2 == 0) 
				celda.style.backgroundColor = "#FEFDCB";
			else if(id % 2 != 0)
			 	celda.style.backgroundColor = "#FDFB99";
		}
		else {
			if (id % 2 == 0) 
				celda.style.backgroundColor = "#ffffff";
			else if(id % 2 != 0)
			 	celda.style.backgroundColor = "#F1F5FA";											
		}
	}

	function habilitarceroodometro(valor) {
		valor= parseInt(valor);
		if(valor%2==0) {
			/*document.forms[0].mant_cada_cdm.disabled=true;
			document.forms[0].mant_cada_cdk.disabled=false;*/
			document.getElementById('cargar').style.display='';
		}else{
			document.getElementById('cargar').style.display='';
		}
		document.getElementById('contador').value=valor+1;
	}
	
	
	function actualizar(){
		if (document.all.tab9.style.display==''){
			setCookie('OdometroCero',0);		
			var UltimaFechaControlBD=0;
			var UltimaFechaControlA1=0;
			var UltimaDistanciaControlBD=0;
			var DefinitivaFechaControlBD=0;
			var DefinitivaDistanciaControlBD=0;
			var UltimaFechaControl=0;
			var UltimaDistanciaControl=0;
			var DiferenciaFecha=0;
			var miMantenimiento = new Array(); 
			var miOdometro = new Array(); 
			var miRevisiones = new Array();
			var DiferenciaCero1=0;var DiferenciaOdometro1=0;
      		<%	UsuarioCar usuarioCar3 = (UsuarioCar) request.getSession().getAttribute("usuarioCar");
      			VehiculosDAO vehiculosDAO2 = new  VehiculosDAO();
	      		Vehiculos vehiculosR=vehiculosDAO2.retrieveCarByUser(usuarioCar3.getUsuc_cod()); 
	      		RevisionesVehiculoDAO revisionesVehiculoDAO = new RevisionesVehiculoDAO(); 
	      		MantenimientoGeneralDAO mantenimientoGeneralDao2 = new MantenimientoGeneralDAO();
				MantenimientoGeneral mantenimientoGeneral2 = mantenimientoGeneralDao2.retrive(new BigDecimal(1), vehiculosR.getVehi_cod());
	      		List revisionVehiculo = revisionesVehiculoDAO.list2(vehiculosR.getVehi_cod());
	      		int revisionVehiculocontador=revisionVehiculo.size();
	      		BigDecimal ultimaFecha2= ManejoFechas.getUltimaFecha(vehiculosR,request,mantenimientoGeneral2,revisionVehiculo);
	      		BigDecimal ultimaDistancia2= ManejoFechas.getUltimaDistancia(vehiculosR,request,mantenimientoGeneral2,revisionVehiculo);
	      		VehiculosCompletoForm formulario = new VehiculosCompletoForm();
	      		List revisionesVehiculo = (List) request.getSession().getAttribute("REVISIONES");
	      	%>

	      	var y=0;
	      	var NumeroControles=<%=revisionVehiculocontador%>;
	      	for (r=0;r<NumeroControles; r++){
	      		eval('if (document.forms[0].mantenimientosBasicos'+r+'.checked){y=1;}');	      		
	      	}
	      	if (y==0){
	      		alert('<bean:message key="5122" />');
	      		return false;
	      	}
	      	
	      	if (document.forms[0].cDia4.value==0){
	      		alert('<bean:message key="5120" />');
	      		document.forms[0].cDia4.focus();
	      		return false;
	      	}
			if (document.forms[0].cMes4.value==0){
	      		alert('<bean:message key="5120" />');
	      		document.forms[0].cMes4.focus();
	      		return false;
	      	}
	      	if (document.forms[0].cAno4.value==0){
	      		alert('<bean:message key="5120" />');
	      		document.forms[0].cAno4.focus();
	      		return false;
	      	}
	      	if (document.forms[0].distanciaMantenimientosBasicos.value==0){
	      		alert('<bean:message key="5123" />');
	      		document.forms[0].distanciaMantenimientosBasicos.focus();
	      		return false;
	      	}
			
			//Dates which user is recently registering. 
			
	      	UltimaFechaControl=''+(document.getElementById("cAno4").value)+(document.getElementById("cMes4").value)+(document.getElementById("cDia4").value);
			UltimaFechaControl=parseInt(UltimaFechaControl);
			UltimaDistanciaControl=parseInt(document.forms[0].distanciaMantenimientosBasicos.value);
			fechaCero=document.forms[0].AnoCero3.value+''+document.forms[0].MesCero3.value+''+document.forms[0].DiaCero3.value;
			UltimaFechaCeroControl=parseInt(fechaCero);
			
			//Last date in BD (Odometer-Revisions-Maintenance)
			
			UltimaFechaTotal=<%=ultimaFecha2.intValue()%>
			
			//Registered Dates in DB
			
			UltimaFechaControlBDCero=parseInt(<%=vehiculosR.getVehi_fechaencero() %>);
			UltimaFechaControlBDOdo=parseInt(<%=vehiculosR.getVehi_fechaodometro() %>);
			UltimaDistanciaControlBDOdo=parseInt(<%=vehiculosR.getVehi_kmsact() %>);
			if (UltimaFechaControlBDCero>0){
				UltimaFechaCeroControl=UltimaFechaControlBDCero;
			}
	      	var OdometroCeroBase =<%=vehiculosR.getVehi_fechaencero()%>;
	      	var UltimaFecha2=<%=ultimaFecha2%>
	      	var UltimaDistancia2=<%=ultimaDistancia2%>;
			//New variables to be considered
			
			var DiferenciaFechaFinal0=10000000;
			var DiferenciaFechaFinalS=10000000;
			var PosteriorFechaControlBD0=-1;
			var PosteriorDistanciaControlBD0=-1;
			var byUser=-1;
			var fechaceroVirtual=0;
			//alert('UK1->'+UltimaFechaControl+' O0->'+UltimaFechaControlBDCero+' O->'+UltimaFechaControlBDOdo+' ODis->'+UltimaDistanciaControlBDOdo);
			

		//ADDING CONTROL-MAINTENANCE WITHOUT ODOMETER DATE WON'T BECOME 0

			if (document.getElementById('bobcontent77').style.visibility=='hidden'){
				document.forms[0].vehi_cerorevision.value=0;
				byUser=0;
				document.getElementById('cargar').style.visibility='visible';
				document.forms[0].vehi_sistema.value=1;
			}
			
			if (document.getElementById('bobcontent77').style.visibility=='visible'){
				document.forms[0].vehi_sistema.value=2;
				document.forms[0].vehi_cerorevision.value=1;
				document.forms[0].vehi_fechaencero.value=UltimaFechaCeroControl;
				document.forms[0].tempcero.value=UltimaFechaCeroControl;
				if (document.forms[0].DiaCero3.value=='00' || document.forms[0].MesCero3.value=='00' || document.forms[0].AnoCero3.value=='0000'){
					byUser=2;
					alert('<bean:message key="5124" />');
					document.forms[0].DiaCero3.focus();
					return false;
				}else{
					//First validations
					
					if (UltimaFechaCeroControl>UltimaFechaControl){
						alert('<bean:message key="5126" /> '+UltimaDistanciaControl+' <bean:message key="5127" /> '+UltimaFechaControl+' <bean:message key="5128" /> '+UltimaFechaCeroControl+' <bean:message key="5129" /> ');
						document.forms[0].AnoCero3.focus();
						return false;
					}
					byUser=1;
					//en estudio
					/*if (fechacero<UltimaFechaTotal){
						alert('Error: La fecha que registra cuando el odómetro pasó por cero es menor que la fecha del último control registrado en el sistema ');
						document.forms[0].AnoCero3.focus();
						return false;
					}*/
					document.forms[0].vehi_sistema.value=3;	
				}
			}

			
			//Create a table of revisions which all time and distance values are correct.
			
			var odometrocero=-1;
			var temporal=-1;			
			//Evaluate database when odometer value has become to 0 and if it has been registered
			
			if (UltimaFechaControlBDCero!=0) {
				odometrocero=1;
				temporal=0;
				DiferenciaCero1=UltimaFechaControl-UltimaFechaControlBDCero;
			}else{
				odometrocero=0;
				temporal=0;
				DiferenciaCero1=UltimaFechaControl-UltimaFechaControlBDCero;		
			}

			//Evaluate temporal table of revisions (No saved table) when odometer odometer value has become to 0 and if it has indicated
			if (UltimaFechaCeroControl!=0) {
				odometrocero=1;
				temporal=1;
				DiferenciaCero1=UltimaFechaControl-UltimaFechaCeroControl;
			}else{
				odometrocero=0;
				temporal=1;
				DiferenciaCero1=UltimaFechaControl-UltimaFechaCeroControl;			
			}
			
			//Search if there's blocked controls and getting the date when the odometer was registered 0 
			var FechaTopeBloqueo=0;
			var DistanciaTopeBloqueo=0;
			var existenBloqueados=0;
			<%	 
      			int zXy = 0; 
				while (zXy < revisionesVehiculo1.size()) {%>
		      		Bloqueado=parseInt(<%=((RevisionesVehiculo)revisionesVehiculo1.get(zXy)).getRveh_bloqueado() %>);
					
					if (Bloqueado==2){
						FechaTopeBloqueo=parseInt(<%=((RevisionesVehiculo)revisionesVehiculo.get(zXy)).getRveh_control_fec() %>);
						DistanciaTopeBloqueo=parseInt(<%=((RevisionesVehiculo)revisionesVehiculo.get(zXy)).getRveh_control_kms() %>);
						existenBloqueados=1;
					}

      		<% 	zXy++;
      		} %>
						<%	 
      			int zXw = 0; 
				while (zXw < revisionesVehiculo1.size()) {%>
		      		Bloqueado=parseInt(<%=((RevisionesVehiculo)revisionesVehiculo1.get(zXw)).getRveh_bloqueado() %>);
					
					if (Bloqueado==2){
						FechaTopeBloqueo=parseInt(<%=((RevisionesVehiculo)revisionesVehiculo1.get(zXw)).getRveh_control_fec() %>);
						DistanciaTopeBloqueo=parseInt(<%=((RevisionesVehiculo)revisionesVehiculo1.get(zXw)).getRveh_control_kms() %>);
						
					}

      		<% 	zXw++;
      		} %>
			if (UltimaFechaControl>UltimaFechaCeroControl && UltimaFechaControl<FechaTopeBloqueo){
				existenBloqueados=1;
			}
			if (UltimaFechaCeroControl!=0 || OdometroCeroBase!=0){
				if (UltimaFechaCeroControl!=0){
					if (UltimaFechaControl<OdometroCeroBase){
						alert('<bean:message key="5194" />'+OdometroCeroBase+'<bean:message key="5195" />');
						return false;					
					}
				}
				if (OdometroCeroBase!=0){
					if (UltimaFechaControl<UltimaFechaCeroControl){
						alert('<bean:message key="5194" />'+OdometroCeroBase+'<bean:message key="5195" />');
						return false;					
					}
				}
				
			}
			//Find a closer date to the new control which you're registering in the interval (UltimaFechaCeroControl/OdometroCeroBase-FechaTopeBloqueo)
			DiferenciaSuperiorIntervalo=90000000;
			DiferenciaInferiorIntervalo=90000000;
			FechaSuperiorReferencia=FechaTopeBloqueo;
			FechaInferiorReferencia=UltimaFechaCeroControl;
			DistanciaSuperiorReferencia=DistanciaTopeBloqueo;
			DistanciaInferiorReferencia=0;
			
			if (existenBloqueados==1){
				which='';which2='';
				if (UltimaFechaCeroControl!=0 || OdometroCeroBase!=0){	
					if (OdometroCeroBase!=0) UltimaFechaCeroControl=OdometroCeroBase;
					if (UltimaFechaCeroControl!=0){
						FechaInferiorReferencia=UltimaFechaCeroControl;
						<%	 
		      			int zXz = 0; 
						while (zXz < revisionesVehiculo1.size()) {%>
							codigo=<%=((RevisionesVehiculo)revisionesVehiculo1.get(zXz)).getRveh_cod() %>;
							FechaControlTemporal=parseInt(<%=((RevisionesVehiculo)revisionesVehiculo1.get(zXz)).getRveh_control_fec() %>);
							DistanciaControlTemporal=parseInt(<%=((RevisionesVehiculo)revisionesVehiculo1.get(zXz)).getRveh_control_kms() %>);
							Bloqueado=parseInt(<%=((RevisionesVehiculo)revisionesVehiculo1.get(zXz)).getRveh_bloqueado() %>);
							if (FechaControlTemporal>UltimaFechaCeroControl && FechaControlTemporal<FechaTopeBloqueo){
								if (Bloqueado!=1){
									DiferenciaSuperior=FechaControlTemporal-UltimaFechaControl;
									DiferenciaInferior=UltimaFechaControl-FechaControlTemporal;
									//alert(DiferenciaInferior+' * '+DiferenciaSuperior+' * '+FechaControlTemporal+' * '+UltimaFechaControl);
									if (DiferenciaInferior<DiferenciaInferiorIntervalo && DiferenciaInferior>0){
										DiferenciaInferiorIntervalo=DiferenciaInferior;
										FechaInferiorReferencia=FechaControlTemporal;
										DistanciaInferiorReferencia=DistanciaControlTemporal;
										which='a'+codigo;
									}
									if (DiferenciaSuperior<DiferenciaSuperiorIntervalo && DiferenciaSuperior>0){
										DiferenciaSuperiorIntervalo=DiferenciaSuperior;
										FechaSuperiorReferencia=FechaControlTemporal;
										DistanciaSuperiorReferencia=DistanciaControlTemporal;
										which2='b'+codigo;
									}
								}
								
							}
							
							
		
		      				<% 	zXz++;
   						} %>
						
					}
					revisionY='';
					<%	 
						int s2y = 0; 
						while (s2y < revisionesVehiculo.size()) {%> 
						
						if (document.getElementById("mantenimientosBasicos" + <%=s2y%>).checked ) {
							NombreRevision='<%=((RevisionesVehiculo) revisionesVehiculo.get(s2y)).getRveh_cod()%>';
							revisionY=revisionY+NombreRevision+',';							
						}
					<%s2y++;}%>
					if (revisionY.length>0){
						revisionY=revisionY.substring(0,revisionY.length-1);
					}
					textoN='';
    				switch (which){

						default: 
							if (which.length>0) {
								var numReve=which.substring(1,which.length);
								quien=2;
								
								<%	 
								int nx = 0; 
								while (nx < revisionesVehiculo.size()) {%>
								if (<%=nx%>==numReve-1){
									
									textoN='<%=((RevisionesVehiculo) revisionesVehiculo.get(nx)).getRveh_cod()%>';
									textoN=textoN+' - ';
									textoN=textoN+'<%=((RevisionesVehiculo) revisionesVehiculo.get(nx)).getRveh_actividad()%>';
									
								}	
								
								<%nx++;}%>
							}
					}
					textoS='';
    				switch (which2){

						default: 
							if (which2.length>0) {
								var numReve=which2.substring(1,which2.length);
								quien=2;
								
								<%	 
								int nxS = 0; 
								while (nxS < revisionesVehiculo.size()) {%>
								if (<%=nxS%>==numReve-1){
									
									textoS='<%=((RevisionesVehiculo) revisionesVehiculo.get(nxS)).getRveh_cod()%>';
									textoS=textoS+' - ';
									textoS=textoS+'<%=((RevisionesVehiculo) revisionesVehiculo.get(nxS)).getRveh_actividad()%>';
									
								}	
								
								<%nxS++;}%>
							}
					}
				}
				//alert(' FechaA='+FechaInferiorReferencia+' DistA='+DistanciaInferiorReferencia+' FechaSuministrada='+UltimaFechaControl+' DistSuministrada='+UltimaDistanciaControl+'FechaC='+FechaSuperiorReferencia+' DistC='+DistanciaSuperiorReferencia);
			}else{
			//Find out the Initial Reference Date and Posterior date to evaluate if it is right to be accepted according to validation rules.				
			
			// ODOMETER
			

			

			DiferenciaOdometro1=UltimaFechaControl-UltimaFechaControlBDOdo;			
			
			if (odometrocero==0){// zero's odometer value = 0 	
				//CASE A :odometer value has NEVER become 0
				//Case 5: Odometer has NEVER passed by 0 and the revision/maintanance date is later than odometer date
			
				if (UltimaFechaControl >= UltimaFechaControlBDOdo ){					
					odo=5;
					DiferenciaFechaFinal0=DiferenciaOdometro1;
					DiferenciaFechaFinalS=10000000;
      				//Previous Date
      				DefinitivaFechaControlBD0=UltimaFechaControlBDOdo;
		      		DefinitivaDistanciaControlBD0=UltimaDistanciaControlBDOdo;
			      	//Next Date
		      		PosteriorFechaControlBD0=UltimaFechaControl;
		      		PosteriorDistanciaControlBD0=UltimaDistanciaControl;	
		      		who='o';whoi='o';     	
		      	}else{
		      	//Case 6: Odometer has NEVER passed by 0 and the revision/maintanance date is earlier than odometer date
		      		odo=6;
		      		DiferenciaFechaFinal0=10000000;
		      		DiferenciaFechaFinalS=UltimaFechaControlBDOdo-UltimaFechaControl;
      				//Previous Date
      				DefinitivaFechaControlBD0=UltimaFechaControl;
		      		DefinitivaDistanciaControlBD0=UltimaDistanciaControl;
		      		//Next Date
		      		PosteriorFechaControlBD0=UltimaFechaControlBDOdo;
		      		PosteriorDistanciaControlBD0=UltimaDistanciaControlBDOdo;
		      		who='o';whoi='o';
		      	}
			}else{
				//CASE B :odometer value has become 0
				//Case 1: Date which user has selected for revision/maintenance is earlier than date when the odometer has been passed by 0. 
				if (temporal==0){
					if (UltimaFechaControl< UltimaFechaControlBDOdo && UltimaFechaControl<UltimaFechaControlBDCero ){
	
						odo=1;
						DiferenciaFechaFinal0=10000000;
						DiferenciaFechaFinalS=UltimaFechaControlBDCero-UltimaFechaControl;
						//Previous Date
	      				DefinitivaFechaControlBD0=UltimaFechaControl;     				
			      		DefinitivaDistanciaControlBD0=UltimaDistanciaControl; 
			      		//Next Date
			      		PosteriorFechaControlBD0=UltimaFechaControlBDCero;
			      		PosteriorDistanciaControlBD0=0;    
			      		who='o';whoi='o'; 		
			      	}
		      	}
		      	if (temporal==1){	
			      	if (UltimaFechaControl< UltimaFechaControlBDOdo && UltimaFechaControl<UltimaFechaCeroControl ){
	
						odo=1;
						DiferenciaFechaFinal0=10000000;
						DiferenciaFechaFinalS=UltimaFechaCeroControl-UltimaFechaControl;
						//Previous Date
	      				DefinitivaFechaControlBD0=UltimaFechaControl;     				
			      		DefinitivaDistanciaControlBD0=UltimaDistanciaControl; 
			      		//Next Date
			      		PosteriorFechaControlBD0=UltimaFechaCeroControl;
			      		PosteriorDistanciaControlBD0=0;  
			      		who='o';whoi='o';		
			      	}
		      	}
		      	
		      	//Case 2: Date which user has selected for revision/maintaince is later than date when the odometer has been passed by 0
		      	if (temporal==0){
			      	if (UltimaFechaControl< UltimaFechaControlBDOdo && UltimaFechaControl>UltimaFechaControlBDCero ){
			      		
			      		odo=2;
			      		DiferenciaFechaFinal0=DiferenciaCero1;
			      		DiferenciaFechaFinalS=UltimaFechaControlBDOdo-UltimaFechaControl;
	      				//Previous Date
	      				DefinitivaFechaControlBD0=UltimaFechaControlBDCero;
			      		DefinitivaDistanciaControlBD0=0;
			      		//Next Date
			      		PosteriorFechaControlBD0=UltimaFechaControlBDOdo;
			      		PosteriorDistanciaControlBD0=UltimaDistanciaControlBDOdo;
			      		who='o';whoi='o';
			      	}
		      	}
		      	
		      	if (temporal==1){
			      	if (UltimaFechaControl< UltimaFechaControlBDOdo && UltimaFechaControl>UltimaFechaCeroControl ){
			      		
			      		odo=2;
			      		DiferenciaFechaFinal0=DiferenciaCero1;
			      		DiferenciaFechaFinalS=UltimaFechaControlBDOdo-UltimaFechaControl;
	      				//Previous Date
	      				DefinitivaFechaControlBD0=UltimaFechaCeroControl;
			      		DefinitivaDistanciaControlBD0=0;
			      		//Next Date
			      		PosteriorFechaControlBD0=UltimaFechaControlBDOdo;
			      		PosteriorDistanciaControlBD0=UltimaDistanciaControlBDOdo;
			      		who='o';whoi='o';
			      	}
		      	}
		      	
		      	//Case 3: Date which user has selected for revision/maintaince is later than date when the odometer date
		      	if (temporal==0){
			      	if (UltimaFechaControl> UltimaFechaControlBDOdo && UltimaFechaControl>UltimaFechaControlBDCero ){
			      		
			      		odo=3;
			      		DiferenciaFechaFinal0=DiferenciaOdometro1;
			      		DiferenciaFechaFinalS=10000000;
	      				//Previous Date
	      				DefinitivaFechaControlBD0=UltimaFechaControlBDOdo;
			      		DefinitivaDistanciaControlBD0=UltimaDistanciaControlBDOdo;   
			      		//Next Date
			      		PosteriorFechaControlBD0=UltimaFechaControl;
			      		PosteriorDistanciaControlBD0=UltimaDistanciaControl;
			      		who='o';whoi='o';
			      	}
		      	}
		      	if (temporal==1){
			      	if (UltimaFechaControl> UltimaFechaControlBDOdo && UltimaFechaControl>UltimaFechaCeroControl ){
			      		
			      		odo=3;
			      		DiferenciaFechaFinal0=DiferenciaOdometro1;
			      		DiferenciaFechaFinalS=10000000;
	      				//Previous Date
	      				DefinitivaFechaControlBD0=UltimaFechaControlBDOdo;
			      		DefinitivaDistanciaControlBD0=UltimaDistanciaControlBDOdo;   
			      		//Next Date
			      		PosteriorFechaControlBD0=UltimaFechaControl;
			      		PosteriorDistanciaControlBD0=UltimaDistanciaControl;
			      		who='o';whoi='o';
			      	}
		      	}
		      	
		      	//Case 4: Date which user has selected for revision/maintaince is equal than date when the odometer date or odometer when its value becomes 0
		      	if (temporal==0){
			      	if (UltimaFechaControl== UltimaFechaControlBDOdo || UltimaFechaControl==UltimaFechaControlBDCero ){
						odo=4;
						//Determine whether Odometer has come through 0 in loaded/saved controls
						if (UltimaFechaControlBDCero==0 || UltimaFechaCeroControl==0){
							if (UltimaFechaControl== UltimaFechaControlBDOdo)							
								alert('<bean:message key="5178" />...'+UltimaFechaControlBDOdo);
							if (UltimaFechaControl==UltimaFechaControlBDCero)
								alert('<bean:message key="5178" />...'+UltimaFechaControlBDCero);
							return false;
						}
			      	}
		      	}
		      	if (temporal==1){
			      	if (UltimaFechaControl== UltimaFechaControlBDOdo || UltimaFechaControl==UltimaFechaCeroControl ){
						odo=4;
						//Determine whether Odometer has come through 0 in loaded/saved controls
						if (UltimaFechaControlBDCero==0 || UltimaFechaCeroControl==0){
		
								if (UltimaFechaControl== UltimaFechaControlBDOdo)									
									alert('<bean:message key="5178" />...'+UltimaFechaControlBDOdo);
								if (UltimaFechaControl==UltimaFechaCeroControl)
									//alert('ERROR: La fecha que está registrando ya tiene asignado un valor para distancia '+' O0->'+UltimaFechaControlBDCero );
									alert('<bean:message key="5178" />...'+UltimaFechaControlBDCero);
								return false;
						}
			      	}
		      	}
		      	
			}
			
				
			

			//REVISION
		    
		    //Variables which could be considered
			identi=0;
			bloqueo="-1"; 			    
		    DiferenciaBloqueo=10000000;	    
		    DistanciaAnteriorCeroBloqueo=0;
		    FechaSiguienteCeroBloqueo=0;
		    DistanciaSiguienteCeroBloqueo=0;
	      	var revisionesTemporalBloqueadas = new Array();
	      	
	      	//Revision tables
	      	if (temporal==1){
	      		
	      		FechaAnteriorCeroBloqueo=UltimaFechaCeroControl;
	      		<%  int zn = 0; 
				while (zn < revisionesVehiculo.size()) {%>	
					bloqueo="<%=((RevisionesVehiculo)revisionesVehiculo.get(zn)).getRveh_bloqueado() %>";
			      	if (bloqueo=="1"){
			     		revisionesTemporalBloqueadas[identi]=<%=((RevisionesVehiculo)revisionesVehiculo.get(zn)).getRveh_cod() %>;
					    identi++;
				     }
	      		<%zn++;} %>
	      		bloqueo="-1";
	      		
	      		<% int z1 = 0; 
				while (z1 < revisionesVehiculo.size()) {%>	
					bloqueo="<%=((RevisionesVehiculo)revisionesVehiculo.get(z1)).getRveh_bloqueado() %>";
					UltimaFechaControlBD=parseInt(<%=((RevisionesVehiculo)revisionesVehiculo.get(z1)).getRveh_control_fec() %>);					
					UltimaDistanciaControlBD=parseInt(<%=((RevisionesVehiculo)revisionesVehiculo.get(z1)).getRveh_control_kms() %>);	      		
			      	DiferenciaFecha=UltimaFechaControl-UltimaFechaControlBD;
			      	
			      	codigo=parseInt(<%=((RevisionesVehiculo)revisionesVehiculo.get(z1)).getRveh_cod().intValue() %>);					
			      	if (bloqueo!="1"){
				      	
				      	if (DiferenciaFecha>0){
				      		if (DiferenciaFecha<=DiferenciaFechaFinal0){
					      		//Searching Closer Previous Date
					      		DiferenciaFechaFinal0=DiferenciaFecha;
			      				DefinitivaFechaControlBD0=UltimaFechaControlBD;
					      		DefinitivaDistanciaControlBD0=UltimaDistanciaControlBD;	
					      		who='r'+codigo;	      		
					      	}
				      	}else{
				      		if (DiferenciaFecha<0){
				      			DiferenciaFecha=0-DiferenciaFecha;
					      		
					      		if (DiferenciaFecha<=DiferenciaFechaFinalS){
						      		//Searching Closer Next Date
						      		DiferenciaFechaFinalS=DiferenciaFecha;
						      		PosteriorFechaControlBD0=UltimaFechaControlBD;
						      		PosteriorDistanciaControlBD0=UltimaDistanciaControlBD;
						      		whoi='r'+codigo;	
			      				}
				      		}else{//DiferenciaFecha=0
				      			if (UltimaFechaControlBDCero==0 || UltimaFechaCeroControl==0){
					      			//alert('ERROR: .....La fecha que está registrando ya tiene asignado un valor para distancia '+'UK->'+UltimaFechaControlBD+' UKDis->'+UltimaDistanciaControlBD );
									if (UltimaDistanciaControlBD != UltimaDistanciaControl){
										alert('<bean:message key="5178" />');
										return false;
									}
								}
							}
				      	}		
				          				      
				     //Find the date value when the odometer has become to 0 and the next value closest to the previous date.
				     	
				     	DiferenciaBloqueo2=UltimaFechaControlBD-UltimaFechaCeroControl;
				     	
				     	if (DiferenciaBloqueo2<DiferenciaBloqueo && DiferenciaBloqueo2>0){
				      		
				      		
				      		DiferenciaBloqueo=DiferenciaBloqueo2;
							
							TemporalFecha=FechaAnteriorCeroBloqueo;
							TemporalDistancia=DistanciaAnteriorCeroBloqueo;				      		
				      		
				      		FechaAnteriorCeroBloqueo=UltimaFechaControlBD;
				      		DistanciaAnteriorCeroBloqueo=UltimaDistanciaControlBD;
				      		
				      		FechaSiguienteCeroBloqueo=TemporalFecha;
				      		DistanciaSiguienteCeroBloqueo=TemporalDistancia;
				      		
				      	}
				     }
	      		<%z1++;} %>
	      	}
	      	//BD tables
	      	
	      	
	      	if (temporal==0){
	      		FechaAnteriorCeroBloqueo=UltimaFechaControlBDCero;
	      		<%  int zn2 = 0; 
				while (zn2 < revisionVehiculo.size()) {%>	
					bloqueo="<%=((RevisionesVehiculo)revisionVehiculo.get(zn2)).getRveh_bloqueado() %>";
			      	if (bloqueo=="1"){
			     		revisionesTemporalBloqueadas[identi]=<%=((RevisionesVehiculo)revisionVehiculo.get(zn2)).getRveh_cod() %>;
					    identi++;
				     }
	      		<%zn2++;} %>
	      		bloqueo="-1";
	      		
	      		<% int z12 = 0; 
				while (z12 < revisionVehiculo.size()) {%>	
					bloqueo="<%=((RevisionesVehiculo)revisionVehiculo.get(z12)).getRveh_bloqueado() %>";
					UltimaFechaControlBD=parseInt(<%=((RevisionesVehiculo)revisionVehiculo.get(z12)).getRveh_control_fec() %>);					
					UltimaDistanciaControlBD=parseInt(<%=((RevisionesVehiculo)revisionVehiculo.get(z12)).getRveh_control_kms() %>);	      		
			      	DiferenciaFecha=UltimaFechaControl-UltimaFechaControlBD;
					UltimaDistanciaControlBD=parseInt(<%=((RevisionesVehiculo)revisionVehiculo.get(z12)).getRveh_control_kms() %>);	      					      	
			      	if (bloqueo!="1"){
				      	
				      	if (DiferenciaFecha>0){
				      		if (DiferenciaFecha<=DiferenciaFechaFinal0){
					      		//Searching Closer Previous Date
					      		DiferenciaFechaFinal0=DiferenciaFecha;
			      				DefinitivaFechaControlBD0=UltimaFechaControlBD;
					      		DefinitivaDistanciaControlBD0=UltimaDistanciaControlBD;		      		
					      	}
				      	}else{
				      		if (DiferenciaFecha<0){
				      			DiferenciaFecha=0-DiferenciaFecha;
					      		if (DiferenciaFecha<=DiferenciaFechaFinalS){
						      		//Searching Closer Next Date
						      		DiferenciaFechaFinalS=DiferenciaFecha;
						      		PosteriorFechaControlBD0=UltimaFechaControl;
						      		PosteriorDistanciaControlBD0=UltimaDistanciaControl;
			      				}
				      		}else{
				      			if (UltimaFechaControlBDCero==0 || UltimaFechaCeroControl==0){
					      			//alert('ERROR: .....La fecha que está registrando ya tiene asignado un valor para distancia '+'UK->'+UltimaFechaControlBD+' UKDis->'+UltimaDistanciaControlBD );
									alert('<bean:message key="5178" />');
									return false;
								}
							}
				      	}		
				          				      
				     //Find the date value when the odometer has become to 0 and the next value closest to the previous date.
				     	
				     	DiferenciaBloqueo2=UltimaFechaControlBD-UltimaFechaControlBDCero;
				     	
				     	if (DiferenciaBloqueo2<DiferenciaBloqueo && DiferenciaBloqueo2>0){
				      		DiferenciaBloqueo=DiferenciaBloqueo2;
							
							TemporalFecha=FechaAnteriorCeroBloqueo;
							TemporalDistancia=DistanciaAnteriorCeroBloqueo;				      		
				      		
				      		FechaAnteriorCeroBloqueo=UltimaFechaControlBD;
				      		DistanciaAnteriorCeroBloqueo=UltimaDistanciaControlBD;
				      		
				      		FechaSiguienteCeroBloqueo=TemporalFecha;
				      		DistanciaSiguienteCeroBloqueo=TemporalDistancia;
				      		
				      	}
				     }
	      		<%z12++;} %>
	      	}
	      	
	      	//alert('DifInf1='+DiferenciaFechaFinal0+' DifSup1='+DiferenciaFechaFinalS);
		    
		    
		    //MAINTENANCE
			
			//Dates which user is recently registering. 
			
	      	UltimaFechaControlM=''+(document.getElementById("cAno6").value)+(document.getElementById("cMes6").value)+(document.getElementById("cDia6").value);
			UltimaFechaControlM=parseInt(UltimaFechaControlM);
			UltimaDistanciaControlM=parseInt(document.forms[0].mant_control_kms.value);
			if (document.getElementById('bobcontent77').style.visibility=='visible'){
				fechaCero=document.forms[0].AnoCero3.value+''+document.forms[0].MesCero3.value+''+document.forms[0].DiaCero3.value;
				UltimaFechaCeroControl=parseInt(fechaCero);
			}else{
				UltimaFechaCeroControl=0;
			}
					
			//Registered Dates in DB
			
			UltimaFechaControlBD=parseInt(<%=mantenimientoGeneral2.getMant_control_fec() %>);					
			UltimaDistanciaControlBD=parseInt(<%=mantenimientoGeneral2.getMant_control_kms() %>);
			
			
			//New variables to be considered
			
			if (temporal==0){
				DiferenciaFecha=DefinitivaFechaControlBD0-UltimaFechaControlBD;
				if (DiferenciaFecha>0){
		      		if (DiferenciaFecha<=DiferenciaFechaFinal0){
			      		//Searching Closer Previous Date
			      		DiferenciaFechaFinal0=DiferenciaFecha;
	      				DefinitivaFechaControlBD0=UltimaFechaControlBD;
			      		DefinitivaDistanciaControlBD0=UltimaDistanciaControlBD;
			      		who='m';	
	      			}
		      	}else{
		      		if (DiferenciaFecha<0){
		      			DiferenciaFecha=0-DiferenciaFecha;
			      		if (DiferenciaFecha<=DiferenciaFechaFinalS){
				      		//Searching Closer Next Date
				      		DiferenciaFechaFinalS=DiferenciaFecha;
				      		PosteriorFechaControlBD0=UltimaFechaControl;
				      		PosteriorDistanciaControlBD0=UltimaDistanciaControl;
				      		whoi='m';
		      			}
		      		}else{
		      			if (UltimaFechaControlBDCero==0 || UltimaFechaCeroControl==0){
			      			//alert('ERROR: La fecha que está registrando ya tiene asignado un valor para distancia '+'Mnt->'+UltimaFechaControlBD+' MntDis->'+UltimaDistanciaControlBD );
			      			alert('<bean:message key="5178" />');
							return false;
						}
		      		}
		      	}
			}
			if (temporal==1){
				
				if (UltimaFechaControlM!=0){
					DiferenciaFecha=DefinitivaFechaControlBD0-UltimaFechaControlM;
					alert(DiferenciaFecha+''+UltimaFechaControlM);
					if (DiferenciaFecha>0){
						
						if (DiferenciaFecha<=DiferenciaFechaFinal0){
							who='m';
							//Searching Closer Previous Date
							DiferenciaFechaFinal0=DiferenciaFecha;
							DefinitivaFechaControlBD0=UltimaFechaControlM;
							DefinitivaDistanciaControlBD0=UltimaDistanciaControlM;
						}
					}else{
						if (DiferenciaFecha<0){
							DiferenciaFecha=0-DiferenciaFecha;
							if (DiferenciaFecha<=DiferenciaFechaFinalS){
								//Searching Closer Next Date
								DiferenciaFechaFinalS=DiferenciaFecha;
								PosteriorFechaControlBD0=UltimaFechaControlM;
								PosteriorDistanciaControlBD0=UltimaDistanciaControlM;
							}
						}else{
							if (UltimaFechaControlBDCero==0 || UltimaFechaCeroControl==0){
								//alert('ERROR: La fecha que está registrando ya tiene asignado un valor para distancia '+'Mnt->'+UltimaFechaControlBD+' MntDis->'+UltimaDistanciaControlBD );
								alert('<bean:message key="5178" />');
								return false;
							}
						}
					}
				}
			}
			

		 	
				
			}//fin de ExisteBloqueos (Cuando no hay revisiones bloqueadas)
			
			
			
			//LAST TIME VALIDATIONS


			if (existenBloqueados==1){
				if (FechaSuperiorReferencia> UltimaFechaControl){
					if (DistanciaSuperiorReferencia< UltimaDistanciaControl){
						window.open('<%=request.getContextPath()%>/manager/sdcars/popup_vehiculos/Popup_revision_intervalo.jsp?FechaSuperiorReferencia='+FechaSuperiorReferencia+'&DistanciaSuperiorReferencia='+DistanciaSuperiorReferencia+'&UltimaFechaControl='+UltimaFechaControl+'&UltimaDistanciaControl='+UltimaDistanciaControl+'&revisionX='+revisionY+'&texto='+textoN,'Paso de odómetro en cero','scrollbars=yes, top=100, left=200, width=650, height=480');
						alert('a');
						return false;
					
					}
				}
				if (FechaInferiorReferencia< UltimaFechaControl){
					if (DistanciaInferiorReferencia> UltimaDistanciaControl){
						window.open('<%=request.getContextPath()%>/manager/sdcars/popup_vehiculos/Popup_revision_intervalo2.jsp?FechaInferiorReferencia='+FechaInferiorReferencia+'&DistanciaInferiorReferencia='+DistanciaInferiorReferencia+'&UltimaFechaControl='+UltimaFechaControl+'&UltimaDistanciaControl='+UltimaDistanciaControl+'&revisionX='+revisionY+'&texto='+textoN,'Paso de odómetro en cero','scrollbars=yes, top=100, left=200, width=650, height=480');
						return false;
					}
				}
				
				
				
			}else{
      		//alert('FechaA='+DefinitivaFechaControlBD0+' DistA='+DefinitivaDistanciaControlBD0+' UK='+UltimaFechaControl+' DistSuministrada='+UltimaDistanciaControl+' FechaC='+PosteriorFechaControlBD0+' DistC='+PosteriorDistanciaControlBD0+' UltimaFinal='+UltimaFechaTotal);
			
			//Verify if odometer value hasn't become 0
			revisionesbloqueadas='';
			bloqueados=0;
			fechaceroVirtual=document.getElementById("vehi_fechaencero2").value;
			
			if (UltimaFechaControlBDCero==0 && fechaceroVirtual!=0){
				bloqueados=1;
			}

			
			if (temporal==1){

				if (UltimaFechaCeroControl==0 ){	//odo  no ha pasado por 0 en control
					
					//alert('who '+who+' FechaA='+DefinitivaFechaControlBD0+' DistA='+DefinitivaDistanciaControlBD0+' FechaSuministrada='+UltimaFechaControl+' DistSuministrada='+UltimaDistanciaControl+'FechaC='+PosteriorFechaControlBD0+' DistC='+PosteriorDistanciaControlBD0+' UltimaFinal='+UltimaFechaTotal+' o0='+UltimaFechaCeroControl);
					//Checking distances 	
		      		
		      		revisionX='';
					<%	 
						int s2x = 0; 
						while (s2x < revisionesVehiculo.size()) {%> 
						
						if (document.getElementById("mantenimientosBasicos" + <%=s2x%>).checked ) {
							NombreRevision='<%=((RevisionesVehiculo) revisionesVehiculo.get(s2x)).getRveh_cod()%>';
							revisionX=revisionX+NombreRevision+',';							
						}
					<%s2x++;}%>
					if (revisionX.length>0){
						revisionX=revisionX.substring(0,revisionX.length-1);
					}
		      		texto='';
    				switch (whoi){
						case 'm':texto='<bean:message key="5177"/>';quien=0;break;
						case 'o':texto='<bean:message key="5176"/>';quien=1;break;
						default: 
							if (whoi.length>0) {
								var numRev=whoi.substring(1,whoi.length);
								quien=2;
								
								<%	 
								int n21x = 0; 
								while (n21x < revisionesVehiculo.size()) {%>
								if (<%=n21x%>==numRev-1){
									
									texto='<%=((RevisionesVehiculo) revisionesVehiculo.get(n21x)).getRveh_cod()%>';
									texto=texto+' - ';
									texto=texto+'<%=((RevisionesVehiculo) revisionesVehiculo.get(n21x)).getRveh_actividad()%>';
									texto=texto.substring(0,35);
								}	
								
								<%n21x++;}%>
							}
					}
		      		
		      		if (PosteriorFechaControlBD0 > UltimaFechaControl){		    			
		    			if (PosteriorDistanciaControlBD0 < UltimaDistanciaControl){ 
		    				
		    				
		    				window.open('<%=request.getContextPath()%>/manager/sdcars/popup_vehiculos/Popup_revision_mas_reciente.jsp?DefinitivaFechaControlBD0='+PosteriorFechaControlBD0+'&DefinitivaDistanciaControlBD0='+PosteriorDistanciaControlBD0+'&UltimaFechaControl='+UltimaFechaControl+'&UltimaDistanciaControl='+UltimaDistanciaControl+'&revisionX='+revisionX+'&texto='+texto,'Paso de odómetro en cero','scrollbars=yes, top=100, left=200, width=650, height=480');
		    				//alert('ERROR: FECHA DEL ODÓMETRO QUE ESTÁ REGISTRANDO NO CONTIENE UNA DISTANCIA VALIDA DEBIDO AL REGISTRO ANTERIOR'+DefinitivaFechaControlBD+DefinitivaDistanciaControlBD);
		    			 	return false;
		     			}
		    		}
	   		      	
		      		if (DefinitivaFechaControlBD0 < UltimaFechaControl){	    			      			
		      			if (DefinitivaDistanciaControlBD0 > UltimaDistanciaControl){
		      				var fechaenCeroBD=<%=vehiculosR.getVehi_fechaencero()%>;
		      				if (fechaenCeroBD!=0){     						
	      						document.getElementById('revisorOdometroCero').value=1;
	      					}
		      				
		      				if (document.getElementById('bobcontent77').style.visibility=='hidden'){ 
			      				document.forms[0].vehi_cerorevision.value=0;
			      				if(document.getElementById('revisorOdometroCero').value==0){
			      				    if (UltimaFechaCeroControl==0){  				
													revisionX='';
													var textocero='<bean:message key="5120"/> \n\n';
													textocero=textocero+'<bean:message key="5126"/>\n';
													<%	 
	      												int s2 = 0; 
														while (s2 < revisionesVehiculo.size()) {%> 
														
														if (document.getElementById("mantenimientosBasicos" + <%=s2%>).checked ) {
															NombreRevision='<%=((RevisionesVehiculo) revisionesVehiculo.get(s2)).getRveh_cod()%>';
															revisionX=revisionX+NombreRevision+',';
															NombreRevision=NombreRevision+' - ';
															NombreRevision=NombreRevision+'<%=((RevisionesVehiculo) revisionesVehiculo.get(s2)).getRveh_actividad()%>';
															NombreRevision=NombreRevision.substring(0,35);
															textocero=textocero+'\n'+NombreRevision+'                         '+UltimaFechaControl+'                   '+UltimaDistanciaControl;
															
														}
													<%s2++;}%>
													if (revisionX.length>0){
														revisionX=revisionX.substring(0,revisionX.length-1);
													}
													textocero=textocero+'\n\n\n<bean:message key="5122"/>';
													textocero=textocero+'\n\n<bean:message key="5121"/>\n';
													var quien=-1;
													texto='';
													switch (who){
														case 'm':texto='<bean:message key="5124"/>';quien=0;break;
														case 'o':texto='<bean:message key="5125"/>';quien=1;break;
														default: 
															if (who.length>0) {
																var numRev=who.substring(1,who.length);
																quien=2;
																<%	 
	      														int n21 = 0; 
																while (n21 < revisionesVehiculo.size()) {%>
																if (<%=n21%>==numRev-1){
																	
																	texto='<%=((RevisionesVehiculo) revisionesVehiculo.get(n21)).getRveh_cod()%>';
																	texto=texto+' - ';
																	texto=texto+'<%=((RevisionesVehiculo) revisionesVehiculo.get(n21)).getRveh_actividad()%>';
																	texto=texto.substring(0,35);
																}	
																
																<%n21++;}%>
															}
													}
													
													textocero=textocero+'\n'+texto+'                         '+DefinitivaFechaControlBD0+'                   '+DefinitivaDistanciaControlBD0;
													textocero=textocero+'\n\n\n<bean:message key="5123"/>';										
													numRev=numRev-1;
													
													if(hay_popup_abierto())
														return false;
													if (quien==0 || quien ==1)
										window.open('<%=request.getContextPath()%>/manager/sdcars/popup_vehiculos/Popup_control_odometro_cero.jsp?texto='+texto+'&DefinitivaFechaControlBD0='+DefinitivaFechaControlBD0+'&DefinitivaDistanciaControlBD0='+DefinitivaDistanciaControlBD0+'&UltimaFechaControl='+UltimaFechaControl+'&UltimaDistanciaControl='+UltimaDistanciaControl+'&who='+who+'&revisionX='+revisionX,'Paso de odómetro en cero','scrollbars=yes, top=100, left=200, width=650, height=480');
	      											if (quien==2)
	      								window.open('<%=request.getContextPath()%>/manager/sdcars/popup_vehiculos/Popup_control_odometro_cero.jsp?texto='+texto+'&DefinitivaFechaControlBD0='+DefinitivaFechaControlBD0+'&DefinitivaDistanciaControlBD0='+DefinitivaDistanciaControlBD0+'&UltimaFechaControl='+UltimaFechaControl+'&UltimaDistanciaControl='+UltimaDistanciaControl+'&who='+numRev+'&revisionX='+revisionX,'Paso de odómetro en cero','scrollbars=yes, top=100, left=200, width=650, height=480');
	      											return false;
													
													/*var k=confirm(textocero);																	
										if(k) {																				
												document.forms[0].vehi_cerorevision.value=1;
					    			 			document.getElementById('bobcontent77').style.visibility='visible';
					    			 			document.forms[0].DiaCero3.focus();
					    			 			return false;																
										}else{
											document.forms[0].vehi_cerorevision.value=0;
											document.getElementById('bobcontent77').style.visibility='hidden';
											document.forms[0].distanciaMantenimientosBasicos.focus();
										 	return false;
										}			*/			

								}else{
										alert('<bean:message key="5160a" />');
										document.getElementById('bobcontent77').style.visibility='hidden';
										document.forms[0].vehi_cerorevision.value=0;
										return false;
									}
								}else{
									alert('<bean:message key="5160a" />');
									document.getElementById('bobcontent77').style.visibility='hidden';
									document.forms[0].vehi_cerorevision.value=0;
									
									return false;
								}
								
							}else{//bobcontent77 is visible
							
							//No data in odo in 0's field
							if (document.forms[0].DiaCero3.value=='00' || document.forms[0].MesCero3.value=='00'|| document.forms[0].AnoCero3.value=='0000'){
									alert('<bean:message key="5124" />');
		    			 			document.forms[0].DiaCero3.focus();
		    			 			return false;
								}
							}
								
		      			}
		      		}
			      		
		      		if (DefinitivaFechaControlBD0 == UltimaFechaControl){	    			      			
		      			if (DefinitivaDistanciaControlBD0 != UltimaDistanciaControl){
			      			if (document.forms[0].revisionesBloqueadasA.value == "-1"){
				      			alert('<bean:message key="5178" />');				      			
				      			return false;
				      		}
		      			}
		      		}
	    			      		
		      	}else{ //Odometro paso por cero
					
	      			
	      			if (revisionesbloqueadas.length>0){//Hay revisiones bloqueadas??


	      				
						//La fecha de revisión que se ingresa está en el rango de fecha cuando la revisión esta bloqueada?
						if (UltimaFechaControl>UltimaFechaControlBDCero && UltimaFechaControl<FechaAnteriorCeroBloqueo){
							if ( UltimaDistanciaControl > DistanciaAnteriorCeroBloqueo ){
								alert('<bean:message key="5160" />');
								return false;
							}
						}
						
					}	
						
						      				
	      			
		      			//odometer value has become to 0     			
		      			//Special Case: Next date = Odometer zero date - Get the distance when its value had become 0
						if (PosteriorFechaControlBD0==UltimaFechaCeroControl){
							PosteriorDistancia=parseInt(<%=vehiculosR.getVehi_kmsencero() %>);
						}else{
							PosteriorDistancia=PosteriorDistanciaControlBD0;
		      			}
		
		      			//Choosing the definitive valid value for revision/maintanance control
						//Verifing distances
						
					//	alert(' '+ DefinitivaFechaControlBD0+'--'+UltimaFechaControl+'--'+UltimaDistanciaControl+'--'+DefinitivaDistanciaControlBD0);
			      			
		      			if (DefinitivaFechaControlBD0 > UltimaFechaControl){    				
		    				if (DefinitivaDistanciaControlBD0 < UltimaDistanciaControl){ 
		    					window.open('<%=request.getContextPath()%>/manager/sdcars/popup_vehiculos/Popup_revision_mas_reciente.jsp?texto='+texto+'&DefinitivaFechaControlBD0='+DefinitivaFechaControlBD0+'&DefinitivaDistanciaControlBD0='+DefinitivaDistanciaControlBD0+'&UltimaFechaControl='+UltimaFechaControl+'&UltimaDistanciaControl='+UltimaDistanciaControl+'&who='+numRev+'&revisionX='+revisionX,'Paso de odómetro en cero','scrollbars=yes, top=100, left=200, width=650, height=480');
		    					//alert('ERROR: FECHA DEL ODOMETRO QUE ESTÁ REGISTRANDO NO CONTIENE UNA DISTANCIA VALIDA DEBIDO AL REGISTRO ANTERIOR'+ DefinitivaFechaControlBD0+ UltimaFechaControl+DefinitivaFechaControlBD+DefinitivaDistanciaControlBD);
		    				 	return false;
		     				}
		    			}
		      			if (DefinitivaFechaControlBD0 < UltimaFechaControl){
		      				if (DefinitivaDistanciaControlBD0 > UltimaDistanciaControl){ 		    			 	
			      				
			      				if (document.getElementById('bobcontent77').style.visibility=='hidden'){
			      					document.forms[0].vehi_cerorevision.value=0;
			      					if(document.getElementById('revisorOdometroCero').value==0){
					      				if (UltimaFechaCeroControl==0){
													var textocero='<bean:message key="5120"/> \n\n';
													textocero=textocero+'\n\n<bean:message key="5121"/>';
													var textocero='<bean:message key="5120"/> \n\n';
													textocero=textocero+'\n\n<bean:message key="5121"/>';
													revisionX='';
													<%	 
	      												int s3 = 0; 
														while (s3 < revisionesVehiculo.size()) {%> 
														
														if (document.getElementById("mantenimientosBasicos" + <%=s3%>).checked ) {
															
															NombreRevision='<%=((RevisionesVehiculo) revisionesVehiculo.get(s3)).getRveh_cod()%>';
															revisionX=revisionX+NombreRevision+',';
															NombreRevision=NombreRevision+' - ';
															NombreRevision=NombreRevision+'<%=((RevisionesVehiculo) revisionesVehiculo.get(s3)).getRveh_actividad()%>';
															NombreRevision=NombreRevision.substring(0,40);
															textocero=textocero+'\n'+NombreRevision+'                         '+UltimaFechaControl+'                   '+UltimaDistanciaControl;
														}
													<%s3++;}%>
													if (revisionX.length>0){
														revisionX=revisionX.substring(0,revisionX.length-1);
													}
													
													textocero=textocero+'\n\n<bean:message key="5122"/>\n \n';
													textocero=textocero+'\n\n<bean:message key="5121"/>';
													var quien=-1;
													texto='';
													switch (who){
														case 'm':texto='Mantenimiento';quien=0;break;
														case 'o':texto='Odometro';quien=1;break;
														default: 
															if (who.length>0) {
																var numRev=who.substring(1,who.length);
																quien=2;
																<%	 
	      														int n3 = 0; 
																while (n3 < revisionesVehiculo.size()) {%>
																if (numRev==<%=n3%>){
																	texto='<%=((RevisionesVehiculo) revisionesVehiculo.get(n3)).getRveh_cod()%>';
																	texto=texto+' - ';
																	texto=texto+'<%=((RevisionesVehiculo) revisionesVehiculo.get(n3)).getRveh_actividad()%>';
																}	
																<%n3++;}%>
															}
													}
													textocero=textocero+'\n'+texto+'                         '+DefinitivaFechaControlBD0+'                   '+DefinitivaDistanciaControlBD0;
													numRev=numRev-1;
													
													if(hay_popup_abierto())
														return false;
													if (quien==0 || quien ==1)
										window.open('<%=request.getContextPath()%>/manager/sdcars/popup_vehiculos/Popup_control_odometro_cero.jsp?texto='+texto+'&DefinitivaFechaControlBD0='+DefinitivaFechaControlBD0+'&DefinitivaDistanciaControlBD0='+DefinitivaDistanciaControlBD0+'&UltimaFechaControl='+UltimaFechaControl+'&UltimaDistanciaControl='+UltimaDistanciaControl+'&who='+who+'&revisionX='+revisionX,'Paso de odómetro en cero','scrollbars=yes, top=100, left=200, width=650, height=480');
	      											if (quien==2)
	      								window.open('<%=request.getContextPath()%>/manager/sdcars/popup_vehiculos/Popup_control_odometro_cero.jsp?texto='+texto+'&DefinitivaFechaControlBD0='+DefinitivaFechaControlBD0+'&DefinitivaDistanciaControlBD0='+DefinitivaDistanciaControlBD0+'&UltimaFechaControl='+UltimaFechaControl+'&UltimaDistanciaControl='+UltimaDistanciaControl+'&who='+numRev+'&revisionX='+revisionX,'Paso de odómetro en cero','scrollbars=yes, top=100, left=200, width=650, height=480');
	      											
													

											}else{
												alert('<bean:message key="5160a" />');
												document.getElementById('bobcontent77').style.visibility='hidden';
												document.forms[0].vehi_cerorevision.value=0;
												return false;
											}
										}																	
																						
								}else{//bobcontent77 visible
										fechacero=document.forms[0].AnoCero3.value+''+document.forms[0].MesCero3.value+''+document.forms[0].DiaCero3.value;
										fechaRevision=document.forms[0].cAno4.value+''+document.forms[0].cMes4.value+''+document.forms[0].cDia4.value;
										setCookie('OdometroCero',fechacero);
										var miMantenimiento = new Array(); 
										var miOdometro = new Array(); 
										var miRevisiones = new Array();
										var miRevisionesTexto = new Array();
										var miRevisionesFecha = new Array();
										var miRevisionesDistancia = new Array();
										var hayInconsistencias=0;
									
										//Odometer: Get the vehicle id for inconsistence trouble
										
										if (UltimaFechaControlBDOdo > UltimaFechaCeroControl && UltimaFechaControlBDOdo < UltimaFechaControl){
											//hayInconsistencias++;
											miOdometro[0]=<%=vehiculosR.getVehi_cod()%>;
										}
										
										//Revision
										var counter=0;
										<%  int z21 = 0; 
										while (z21 < revisionesVehiculo.size()) {%>	
											FechaControlRevision=parseInt(<%=((RevisionesVehiculo)revisionesVehiculo.get(z21)).getRveh_control_fec()%>);												
											if (FechaControlRevision > UltimaFechaCeroControl && FechaControlRevision < UltimaFechaControl){
												miRevisiones[counter]=<%=((RevisionesVehiculo)revisionesVehiculo.get(z21)).getRveh_cod()%>;
												miRevisionesTexto[counter]='<%=((RevisionesVehiculo)revisionesVehiculo.get(z21)).getRveh_actividad()%>';
												miRevisionesFecha[counter]='<%=((RevisionesVehiculo)revisionesVehiculo.get(z21)).getRveh_control_fec()%>';									
												counter++;
												hayInconsistencias++;
											}							
											
										<% 		z21++;} %>
										
										
										
										//Mantenimiento
										
										FechaControlMantenimiento=parseInt(<%=mantenimientoGeneral2.getMant_control_fec() %>);
										if (FechaControlMantenimiento > UltimaFechaCeroControl && FechaControlMantenimiento < UltimaFechaControl){											
											miMantenimiento[0]=parseInt(<%=mantenimientoGeneral2.getMant_cod() %>);
											//hayInconsistencias++;
										}
										
										if (hayInconsistencias!=0){
												//alert(hayInconsistencias);
							
											if(hay_popup_abierto())
														return false;
											
											revisionesBloqueadas='';
											for(t=0;t<miRevisiones.length;t++){												  	
													if (t<(miRevisiones.length)-1){
														revisionesBloqueadas=revisionesBloqueadas+miRevisiones[t];
														revisionesBloqueadas=revisionesBloqueadas+',';
													}else{
														revisionesBloqueadas=revisionesBloqueadas+miRevisiones[t];
													}
											}
											
											document.forms[0].revisionesBloqueadasA.value=revisionesBloqueadas;
											if (revisionesBloqueadas.length>0){
												window.open('<%=request.getContextPath()%>/manager/sdcars/popup_vehiculos/Popup_control_bloqueo_revision.jsp?fechaCero='+fechaCero+'&UltimaFechaControl='+UltimaFechaControl+'&UltimaDistanciaControl='+UltimaDistanciaControl+'&revisionesBloqueadas='+revisionesBloqueadas,' ','scrollbars=yes, top=100, left=200, width=650, height=480');
												return false;
											}
											
											
										}
									
									
									document.forms[0].vehi_cerorevision.value=1;
									if (document.forms[0].DiaCero3.value=='00' || document.forms[0].MesCero3.value=='00'){
										alert('<bean:message key="5124" />');
			    			 			document.forms[0].DiaCero3.focus();
			    			 			return false;
									}
								}			
		      				}      		
		     			}
	     			
		      	}//end odometer=0 en la bd
			
			}
			
			}
	      	


			
		}//Revision validations

			if (DiferenciaFechas2()<0){
				alert('<bean:message key="3530" />'+DiferenciaFechas2());
   				return false
			}
			
			convertirACampo('cDia1', 'cMes1', 'cAno1', 'vehi_feccomp');
			convertirACampo('cDia2', 'cMes2', 'cAno2', 'com_fechaini');
			convertirACampo('cDia3', 'cMes3', 'cAno3', 'com_fechafin');
			convertirACampo('cDia4', 'cMes4', 'cAno4', 'fechaMantenimientosBasicos');
			convertirACampo('cDia5', 'cMes5', 'cAno5', 'pveh_fecnacim');
			convertirACampo('cDia6', 'cMes6', 'cAno6', 'mant_control_fec');
		
		enviar('<%=request.getContextPath()%>/DatosVehiculo/recarga2.do');

		
	}
	function llegada1(dato){
		if (dato==1){
 			document.getElementById('bobcontent77').style.visibility='visible';
	 		document.forms[0].vehi_cerorevision.value=1;
	 		document.forms[0].DiaCero3.focus();
	 		setCookie('OdometroCero','0');
		}
		if (dato==2){
			//alert(dato);
			document.forms[0].vehi_cerorevision.value=0;
			document.getElementById('bobcontent77').style.visibility='hidden';
			document.getElementById('distanciaMantenimientosBasicos').focus();
			document.forms[0].cAno4.focus();
		}
		return false;
	}
	function llegada2(dato){
		if (dato==1){
			if (DiferenciaFechas2()<0){
				alert('<bean:message key="3530" />'+DiferenciaFechas2());
   				return false;
			}
			convertirACampo('cDia1', 'cMes1', 'cAno1', 'vehi_feccomp');
			convertirACampo('cDia2', 'cMes2', 'cAno2', 'com_fechaini');
			convertirACampo('cDia3', 'cMes3', 'cAno3', 'com_fechafin');
			convertirACampo('cDia4', 'cMes4', 'cAno4', 'fechaMantenimientosBasicos');
			convertirACampo('cDia4', 'cMes4', 'cAno4', 'vehi_fechatopebloqueo');
			convertirACampo('cDia5', 'cMes5', 'cAno5', 'pveh_fecnacim');
			convertirACampo('cDia6', 'cMes6', 'cAno6', 'mant_control_fec');	
		enviar('<%=request.getContextPath()%>/DatosVehiculo/recarga2.do');
		}
		if (dato==2){
			document.forms[0].DiaCero3.focus();
		}
		if (dato==3){
			location.href="<%=request.getContextPath()%>/DatosVehiculo/editcontroles.do";
		}
		return false;
	}
	function llegada3(dato){
		if (dato==1){	
		 	document.forms[0].distanciaMantenimientosBasicos.focus();
		}
		if (dato==2){
			document.forms[0].distanciaMantenimientosBasicos.value='';
			document.forms[0].cAno4.focus();
			document.forms[0].distanciaMantenimientosBasicos.focus();
		}
		
		return false;
	}
		function llegada4(dato){
		if (dato==1){
			document.forms[0].action = '/ServiDoctor/DatosVehiculo/saveEditControl.do';
			document.forms[0].submit();
		}
		if (dato==2){
			document.forms[0].distanciaMantenimientosBasicos.value='';
			document.forms[0].cAno4.focus();
			document.forms[0].distanciaMantenimientosBasicos.focus();
			return false;
		}
		
		
	}
	function mycallbackfunc(v,m,f){
      if(!v){
			document.forms[0].vehi_cerorevision.value=1;
 			document.getElementById('bobcontent77').style.visibility='visible';
 			document.forms[0].DiaCero3.focus();
 			return false;
      }else{
			document.forms[0].vehi_cerorevision.value=0;
			document.getElementById('bobcontent77').style.visibility='hidden';
			document.forms[0].distanciaMantenimientosBasicos.focus();
			return false;
      }
	}
/*function tabpropio(t,tab_cook,module)
{
	var x=1;

	while(eval("document.getElementById('tab"+x+"')")!=null && x < 11) {
		eval("document.getElementById('tab"+x+"').style.display='none'"); 
		if (module == "family") {
			eval("document.getElementById('tab1"+x+"').style.backgroundColor='#FFF0B7'");
		}
		if (module == "pets") {
			eval("document.getElementById('tab1"+x+"').style.backgroundColor='#EDFECB'");
		}
		if (module == "cars") {
			eval("document.getElementById('tab1"+x+"').style.backgroundColor='#D6E1EE'");
		}
		x++;
	}
	eval("document.getElementById('tab"+t+"').style.display=''"); 
	eval("document.getElementById('tab1"+t+"').style.backgroundColor='#ffffff'");
	//eval("document.all.tab1"+t+".style.color='#ffffff'");
	setCookie(tab_cook,t)
}*/
</SCRIPT>

<html:form target="_self" action="/DatosVehiculo/editcontroles.do">
	<html:hidden property="vehi_fecinscripcion" />
	<html:hidden property="vehi_cod" />
	<html:hidden property="vehi_usuc_cod" />
	<html:hidden property="pveh_cod" />
	<html:hidden property="pveh_veh_cod" />
	<html:hidden property="mant_cod" />
	<html:hidden property="mant_veh_cod" />
	<html:hidden property="mant_fecprox" />
	<html:hidden property="mant_fecprox2" />
	<html:hidden property="mant_fecprox3" />
	<html:hidden property="mant_fecprox4" />
	<html:hidden property="mant_mails_enviados" />
	<html:hidden property="vehi_enero" />
	<html:hidden property="vehi_febrero" />
	<html:hidden property="vehi_marzo" />
	<html:hidden property="vehi_abril" />
	<html:hidden property="vehi_mayo" />
	<html:hidden property="vehi_junio" />
	<html:hidden property="vehi_julio" />
	<html:hidden property="vehi_agosto" />
	<html:hidden property="vehi_septiembre" />
	<html:hidden property="vehi_octubre" />
	<html:hidden property="vehi_noviembre" />
	<html:hidden property="vehi_diciembre" />
	<html:hidden property="vehi_promedio" />
	<html:hidden property="vehi_registro"  styleId="vehi_registro"  />	
	<html:hidden property="vehi_cerobasica"  styleId="vehi_cerobasica"  />
	<html:hidden property="vehi_cerorevision"  styleId="vehi_cerorevision"   />
	<html:hidden property="vehi_fechatopebloqueo"  styleId="vehi_fechatopebloqueo"   />

	
	<input type="hidden" name="vehi_sistema" id="vehi_sistema" value="0" READONLY="readonly"></input>
	<input type="hidden" name="contador" id="contador" value="0" READONLY="readonly"></input>
	<input type="hidden" name="revisorOdometroCero" id="revisorOdometroCero" value="0" READONLY="readonly" ></input>
	<input type="hidden" name="revisionesBloqueadasA" id="revisionesBloqueadasA" value="-1" READONLY="readonly"></input>
	<input type="hidden" name="rBloqueadas" id="rBloqueadas" value="-1" READONLY="readonly"></input>
	<input type="hidden" name="odometroBloqueado" id="odometroBloqueado" value="-1" READONLY="readonly"></input>
	<input type="hidden" name="mntnmntoBloqueado" id="mntnmntoBloqueado" value="-1" READONLY="readonly"></input>
	<input type="hidden" name="tempcero2" id="tempcero2" value="-1" READONLY="readonly"></input>
	<html:hidden property="tempcero"   styleId="tempcero"/>
	<table border="0" width="100%">
		<tr>
			<td valign="top">
				<table class="tablag" align="center" cellpadding="0" cellspacing="0" border="0" width="95%">
					<tr>
						<td>
							<table align="center" cellpadding="0" cellspacing="0" border="0" width="100%">
								<tr>
						<TD  colspan="4">
						<TABLE cellpadding="0" cellspacing="0" border="0" width="100%">
							<TR>
								<TD  align="left" valign="bottom">
								   	<img src="<%=request.getContextPath()%>/images/int_tit_car.gif">                           
								</TD>

	                          <TD colspan="3">&nbsp;<%  UsuarioCar usuarioCar = (UsuarioCar) request.getSession().getAttribute("usuarioCar");
		                             
		                             GrupoUsuarioSegmentacion grupoUsuarioSegmentacion = new GrupoUsuarioSegmentacion();
		                             GrupoUsuarioSegmentacionDAO grupoUsuarioSegmentacionDAO = new GrupoUsuarioSegmentacionDAO();
		                             
		                             GrupoUsuarioSegmentacion grupoUsuarioCar= new GrupoUsuarioSegmentacion();
		                             grupoUsuarioCar.setGrupo_id(BigDecimal.ZERO);
		                             if (usuarioCar.getUsuc_especial().intValue()==1){
		                             	grupoUsuarioCar = grupoUsuarioSegmentacionDAO.retrive("C"+usuarioCar.getUsuc_cod().toString());  
		                             }else{
		                             	grupoUsuarioCar = grupoUsuarioSegmentacionDAO.retrieve("C"+usuarioCar.getUsuc_licencia());  
		                             }  
			                         LogoCompradorDAO logoCompradorDAO = new LogoCompradorDAO();
			                         
									 java.util.Calendar fecha = java.util.Calendar.getInstance();
									 
									 String diafechaactual = new String();			 
									 if (fecha.get(java.util.Calendar.DATE)<10)
									 	diafechaactual = "0" + Integer.toString(fecha.get(java.util.Calendar.DATE));
									 else
								 	 	diafechaactual = Integer.toString(fecha.get(java.util.Calendar.DATE));
									 
									 String mesfechaactual = new String();			 
									 if (fecha.get(java.util.Calendar.MONTH)<9){
									 	Integer mesActual = new Integer(fecha.get(java.util.Calendar.MONTH));				 	
									 	int mesActual1=mesActual.intValue() + 1;
									 	Integer mesA= new Integer(mesActual1);
									 	mesfechaactual = "0" + mesA.toString(mesActual1);
									 	
									 }else{
									 	Integer mesActual = new Integer(fecha.get(java.util.Calendar.MONTH));				 	
									 	int mesActual1=mesActual.intValue() + 1;
									 	Integer mesA= new Integer(mesActual1);	
									 	mesfechaactual =  mesA.toString(mesActual1);							 		
								 	 }
									
									String aniofechaactual = new String();	
									aniofechaactual = Integer.toString(fecha.get(java.util.Calendar.YEAR));		
									 		
									String fechaActual= aniofechaactual + mesfechaactual + diafechaactual;
									Integer ifechaActual = Integer.parseInt(fechaActual); 
									LogoComprador datosPublicidadCompletos = logoCompradorDAO.retrieve(grupoUsuarioCar.getGrupo_id(),ifechaActual);
									//int ifechaInicio = Integer.parseInt(datosPublicidadCompletos.getLogc_fecini());
									//int ifechaFinal = Integer.parseInt(datosPublicidadCompletos.getLogc_fecfin());
		                          	%>
		                      		      				                      		
		                          	
	                          <table align="right" width="380px" height="80px" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                  <td  width="20px" height="100%">
                                  	<% if (datosPublicidadCompletos.getLogc_html_code()!= null){ %>
                                  		<a href="<%=datosPublicidadCompletos.getClickizquierdo()%>" target="_blank"><img src="<%=request.getContextPath()%>/images/clickright.jpg" border="0"></a>
                    				<%} %>
                                  </td>
                                  <td><%if (datosPublicidadCompletos.getLogc_html_code()!= null){ %>
                                  <%=datosPublicidadCompletos.getLogc_html_code()%> 
                                  <%}else{ %>
                                  	&nbsp;
                                  <%} %>
                                  </td>
                                  <td width="20px" height="100%">
                                    <%if (datosPublicidadCompletos.getLogc_html_code()!= null){ 
                                     	if (datosPublicidadCompletos.getClickderecho().equals("0") || datosPublicidadCompletos.getClickderecho().equals("") ){ %>
                              	    		<a href="<%=datosPublicidadCompletos.getClickizquierdo()%>" target="_blank"><img src="<%=request.getContextPath()%>/images/clickleft.jpg" border="0" ></a>
                             	    	<%}else{%>
											<a href="<%=datosPublicidadCompletos.getClickderecho()%>" target="_blank"><img src="<%=request.getContextPath()%>/images/clickleft.jpg" border="0" ></a>
                              	    	<%}%>
                                  
									<%}%>
                                  </td>
                                </tr>
                              </table>
							</TD>	
							</TR>
							<tr style="line-height:5px">
							  <td colspan="4">&nbsp;</td>
							</tr>
							<tr>
							  <td colspan="9"><hr></td>
							</tr>
											<tr>
												<td class="tdOverNameOption" colspan="9" align="center">
													<bean:message key="1506" />
												</td>
											</tr>
											<tr>
												<td class="tdNameOption" colspan="9">
													<table border="0" cellpadding="0" cellspacing="1" width="100%" align="center">
														<tr>
															<td colspan="5">
																<bean:message key="5200" />
															</td>
														</tr>
														<tr>
															<TD align="center" id="tab11" class="sbttn tdNameOption" onClick="tab('1','editvehiculo','cars')">
																<bean:message key="1117" />
															</TD>
															<TD align="center" id="tab12" class="sbttn tdNameOption" onClick="tab('2','editvehiculo','cars')">
																&nbsp;
																<bean:message key="1050" />
															</TD>
															<TD align="center" id="tab19" class="sbttn tdNameOption" onClick="tab('9','editvehiculo','cars')">
																&nbsp;
																<bean:message key="5118" />
															</TD>
															<TD align="center" id="tab13" class="sbttn tdNameOption" onClick="tab('3','editvehiculo','cars')">
																&nbsp;
																<bean:message key="1089" />
															</TD>
															<TD align="center" id="tab14" class="sbttn tdNameOption" onClick="tab('4','editvehiculo','cars')">
																&nbsp;
																<bean:message key="1090" />
															</TD>
														</TR>
														<tr>
															<TD align="center" id="tab17" class="sbttn tdNameOption" onClick="tab('7','editvehiculo','cars')">
																&nbsp;
																<bean:message key="1108" />
															</TD>
															<TD align="center" id="tab110" class="sbttn tdNameOption" onClick="tab('10','editvehiculo','cars')">
																&nbsp;
																<bean:message key="6016" />
															</TD>
															<TD align="center" id="tab15" class="sbttn tdNameOption" onClick="tab('5','editvehiculo','cars')">
																&nbsp;
																<bean:message key="1097" />
															</TD>
															<TD align="center" id="tab16" class="sbttn tdNameOption" onClick="tab('6','editvehiculo','cars')">
																&nbsp;
																<bean:message key="1098" />
															</TD>
															<TD align="center" id="tab18" class="sbttn tdNameOption" onClick="tab('8','editvehiculo','cars')">
																&nbsp;
																<bean:message key="5074" />
															</TD>

														</tr>
													</table>
												</td>
											</tr>

											<tr>
												<td colspan="9">
													<br>
													<table border="0" id="tab1" cellspacing="0" cellpadding="0" style="display: none" width="100%">
														<tr>
															<td>&nbsp;
																
															</td>
														</tr>
														<tr>
															<td colspan="5" align="center">
																<bean:message key="global.guardar" />
															</td>
														</tr>
														<tr>
															<td>&nbsp;
																
															</td>
														</tr>
														<tr>
															<td class="view_item" colspan="4">
																<bean:message key="7402" />
															</td>
														</tr>
														<tr>
															<td>&nbsp;
																
															</td>
														</tr>
														<html:hidden property="pveh_cod" />
														<tr>
															<TD colspan="2" class="tdNameOption" style="border: 1px solid #0066D3">
																<bean:message key="1051" />
															</TD>
														</tr>
														<tr>
															<TD class="view_item" nowrap="nowrap">
																<bean:message key="1041" />
																:&nbsp;
																<html:text property="vehi_placa" maxlength="10" size="20" styleClass="sel" onfocus="this.select()" />
															</TD>
															<TD class="view_item" nowrap="nowrap">
																<bean:message key="1052" />
																:&nbsp;
																<html:hidden property="vehi_feccomp" styleId="vehi_feccomp" />
																<SCRIPT language="JavaScript">obtenerCamposFecha('cDia1', 'cMes1', 'cAno1', 'vehi_feccomp');</SCRIPT>
															</TD>

														</tr>
														<tr>
															<td>&nbsp;
																
															</td>
														</tr>
														<tr>
															<TD class="view_item" nowrap="nowrap">
																<bean:message key="1053" />
																:&nbsp;
																<html:select property="vehi_tveh_cod" styleClass="select">
																	<html:options collection="TIPOVEHICULO" labelProperty="tveh_des" property="tveh_cod" />
																</html:select>
																&nbsp;&nbsp;&nbsp;&nbsp;
															</td>
															<td class="view_item" nowrap="nowrap">
																<bean:message key="1042" />
																:&nbsp;
																<html:select property="vehi_maut_cod" styleClass="select">
																	<html:options collection="MARCASAUTOS" labelProperty="maut_des" property="maut_cod" />
																</html:select>
															</td>
														</tr>
														<tr>
															<td>&nbsp;
																
															</td>
														</tr>
														<tr>
															<TD class="view_item" nowrap="nowrap">
																<bean:message key="1054" />
																:&nbsp;
																<html:text property="vehi_modelo" maxlength="4" size="4" onkeyup="isNatural(this);" onblur="isNatural(this);" styleClass="sel"
																	onfocus="this.select()" />
																&nbsp;&nbsp;
															</td>
															<TD class="view_item" nowrap="nowrap">
																<bean:message key="10530" />
																:
																<html:text property="vehi_tipo" maxlength="15" size="10" styleClass="sel" onfocus='this.select()' />
																<br />
															</TD>
														</tr>
														<tr>
															<td>&nbsp;
																
															</td>
														</tr>
														<!--  <tr>
															<TD class="view_item">
																<bean:message key="1055" />
																
																<html:text property="vehi_kmsact" maxlength="6" onkeyup="isNatural(this);" onblur="isNatural(this);" size="10" styleClass="sel"
																	onfocus="this.select()" />
 
																
																
															</td>
															<TD class="view_item" nowrap="nowrap">
																<bean:message key="10550" />
																<html:hidden property="vehi_fechaodometro"  styleId="vehi_fechaodometrom" />
																<script language="JavaScript">obtenerCamposFecha('Dia3', 'Mes3', 'Ano3', 'vehi_fechaodometrom');</script>
															</TD>
														</tr>
														<tr>
															<TD class="view_item" colspan="2"  nowrap="nowrap">&nbsp;<html:hidden property="vehi_fechaencero" styleId="vehi_fechaencerom" />
													        <div id="hcero" name="hcero" style="display:none">
																<bean:message key="10551" />
																<script language="JavaScript">obtenerCamposFecha('DiaCero', 'MesCero', 'AnoCero', 'vehi_fechaencerom');		</script>													
															</div>
															</TD>
														</tr>-->
														<!-- <tr>
															<TD class="view_item" colspan="2" height="11">
																<bean:message key="1111" />
																:&nbsp;&nbsp;&nbsp;&nbsp;
																<%
																/*	if ( ( ( Vehiculos ) request.getSession().getAttribute( "vehiculo" ) ).getVehi_distancia().equals( IConstantes.DISTANCIA_KILOMETROS ) ) {*/
																%>
																<bean:message key="1112" />
																<html:radio property="vehi_distancia" disabled="true" value="<%=IConstantes.DISTANCIA_KILOMETROS%>" />
																<%
																	/*} else {*/
																%>
																<bean:message key="1113" />
																<html:radio property="vehi_distancia" disabled="true" value="<%=IConstantes.DISTANCIA_MILLAS%>" />
															</td>
															<%
																/*}*/
															%>
														</tr> -->
														<tr>
															<TD colspan="3" style="background-color: #ffffff">&nbsp;
																
															</TD>
														</tr>
														<tr>
															<TD colspan="2" class="tdNameOption" style="border: 1px solid #0066D3">
																<bean:message key="1027" />
															</TD>
														</tr>
														<tr>
															<td>&nbsp;
																
															</td>
														</tr>
														<tr>
															<TD class="view_item" nowrap="nowrap">
																<bean:message key="4" />
																&nbsp;
																<html:text property="pveh_nombre" maxlength="30" size="40" styleClass="sel" />
															</TD>
															<TD class="view_item" nowrap="nowrap">
																<bean:message key="5" />
																&nbsp;
																<html:text property="pveh_apellido" maxlength="30" size="40" styleClass="sel" />
															</TD>
														</tr>
														<tr>
															<TD colspan="3" style="background-color: #ffffff">&nbsp;
																
															</TD>
														</tr>
														<tr>
															<TD class="view_item" colspan="3">
																<bean:message key="12" />
															</TD>
														</tr>
														<tr>
															<TD class="view_item" nowrap="nowrap">
																&nbsp;
																<bean:message key="13" />
																:&nbsp;
																<html:select property="pveh_pais_cod" styleClass="select" onchange="actualizarCiudades(this.value)">
																	<html:options collection="PAISES" labelProperty="pais_des" property="pais_cod" />
																</html:select>
																<br>
																<br>
																<bean:message key="14" />
																:&nbsp;
																<html:select property="pveh_ciu_cod" styleClass="select" styleId="ciudadesContent">
																	<html:options collection="CIUDADES" labelProperty="ciu_des" property="ciu_cod" />
																</html:select>
															</TD>
															<TD class="view_item" nowrap="nowrap">
																&nbsp;
																<bean:message key="22" />
																:&nbsp;
																<html:hidden property="pveh_fecnacim" styleId="pveh_fecnacim" />
																<SCRIPT language="JavaScript">obtenerCamposFecha('cDia5', 'cMes5', 'cAno5', 'pveh_fecnacim');</SCRIPT>
																<br>
																<bean:message key="3507" />
																:&nbsp;
																<bean:message key="20" />
																<html:radio property="pveh_sexo" value="<%=IConstantes.SEXO_MASCULINO%>" />
																<bean:message key="21" />
																<html:radio property="pveh_sexo" value="<%=IConstantes.SEXO_FEMENINO%>" />
															</TD>
														</tr>

														<tr>
															<TD class="view_item" nowrap="nowrap">
																<bean:message key="6177" />
																:&nbsp;
																<html:select property="pveh_idio_cod" styleClass="select">
																	<html:options collection="IDIOMAS" labelProperty="idio_descripcion" property="idio_cod" />
																</html:select>
															</TD>
														</tr>
														<tr>
															<TD colspan="3" style="background-color: #ffffff">&nbsp;
																
															</TD>
														</tr>
														<tr>
															<TD class="view_item" colspan="3">
																<bean:message key="15" />
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																&nbsp;
																<bean:message key="16" />
																&nbsp;
																<bean:message key="13" />
																:
																<html:text property="pveh_indpais1" onkeyup="isNatural(this);" onblur="isNatural(this);" maxlength="3" size="6" styleClass="sel"
																	onfocus="this.select()" />
																&nbsp;
																<bean:message key="16" />
																&nbsp;
																<bean:message key="14" />
																:&nbsp;
																<html:text property="pveh_indciudad1" maxlength="3" onkeyup="isNatural(this);" onblur="isNatural(this);" size="6" styleClass="sel"
																	onfocus="this.select()" />
															</TD>
															<TD class="view_item">
																<bean:message key="17" />
																:
																<html:text property="pveh_telefono1" maxlength="15" onkeyup="isNatural(this);" onblur="isNatural(this);" size="30" styleClass="sel"
																	onfocus="this.select()" />
															</TD>
														</tr>
														<tr>
															<TD colspan="3" style="background-color: #ffffff">&nbsp;
																
															</TD>
														</tr>
														<tr>
															<TD colspan="3" class="view_item">
																<bean:message key="18" />
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="16" />
																&nbsp;
																<bean:message key="13" />
																:&nbsp;
																<html:text property="pveh_indpais2" maxlength="3" onkeyup="isNatural(this);" onblur="isNatural(this);" size="6" styleClass="sel"
																	onfocus="this.select()" />
															</TD>
															<TD class="view_item">
																<bean:message key="17" />
																:
																<html:text property="pveh_telefono2" maxlength="15" onkeyup="isNatural(this);" onblur="isNatural(this);" size="30" styleClass="sel"
																	onfocus="this.select()" />
															</TD>
														</tr>
														<tr>
															<TD colspan="3" style="background-color: #ffffff">&nbsp;
																
															</TD>

														</tr>
														<tr>
															<TD class="view_item" colspan="3">
																<bean:message key="19" />
																:&nbsp;
																<html:text property="pveh_mail" maxlength="40" size="40" styleClass="sel"
																	value='<%=( ( UsuarioCar ) request.getSession().getAttribute( "usuarioCar" ) ).getUsuc_usuario()%>' disabled="true" />
															</TD>
														</tr>
														<tr>
															<TD colspan="2" style="background-color: #ffffff">&nbsp;
																
															</TD>
														</tr>
														<tr>
															<td colspan="2">
															</td>
														</tr>
													</table>
												</TD>
											</tr>
											<TR>
												<TD colspan="9" class="view_item">
													<b><bean:message key="7447" />
													</b>
												</TD>
											</TR>
											<tr>
												<TD colspan="9">
													<table border="0" id="tab2" cellspacing="0" cellpadding="0" style="display: none" width="100%">
														<tr>
															<td colspan="6" align="center">
																<bean:message key="global.guardar" />
															</td>
														</tr>
														<tr>
															<td class="view_item" colspan="6" align="center">
																<b><bean:message key="834a" arg0='<%=res.getMessage( "parametro_adicion_revision" )%>' />
																</b>
															</td>
														</tr>
														<tr>
															<td>&nbsp;
																
															</td>
														</tr>
														<tr>
															<td class="view_item" colspan="6">
																<bean:message key="7404" />
															</td>
														</tr>
														<tr>
															<td class="view_item" colspan="6">
																<bean:message key="7404a" />
															</td>
														</tr>
														<tr>
															<td>&nbsp;
																
															</td>
														</tr>
														<tr>
															<td class="view_item" colspan="6">
																<bean:message key="7405" />
															</td>
														</tr>
														<tr>
															<td colspan="7">
																<table align="center" width="100%" border="0" cellspacing="0" cellpadding="0">
																	<tr>
																		<td rowspan="2" class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																			<bean:message key="global.numeral" />
																		</td>
																		<td height="75" rowspan="2" class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																			<bean:message key="1056" />
																		</td>
																		<td rowspan="2" class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																			<bean:message key="6175" />
																			&nbsp;
																		</td>
																		<td rowspan="2" class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																			<bean:message key="1057" />
																		</td>
																		<td class="tdNameOption" style="border: 1px solid #0066D3" align="center" colspan="2">
																			<bean:message key="1058" />
																		</td>
																		<td rowspan="2" class="tdNameOption" style="border: 1px solid #0066D3">
																			<bean:message key="global.acciones" />
																		</td>
																	</tr>
																	<tr>
																		<td class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																			<bean:message key="1068" />
																		</td>
																		<td class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																			<bean:message key="6176" />
																		</td>
																		<td></td>
																	</tr>
																	<%
																		int z = 0;
																			String valor = "0";
																			String totalMensualGM = "";
																			String totalAnualGM = "";
																			String totalMensualGA = "";
																			String totalAnualGA = "";
																			String totalMensualGNA = "";
																			String totalAnualGNA = "";
																			String TotalDistancia = "";
																			String TotalDia = "";
																	%>
																	<logic:iterate indexId="ind" id="revisiones" name="REVISIONES" type="com.servidoctor.parametros.model.RevisionesVehiculo">
																		<%
																			if ( z % 2 == 0 ) {
																		%>
																		<tr style="background: #ffffff"><TD width="40" class="view_desc" align="center"><%=z + 1%></TD>
																			<td class="view_item">
																				<bean:write name="revisiones" property="rveh_actividad" scope="page" />
																			</td>
																			<%
																				if ( request.getAttribute( "rveh_acc_des" + z ).equals( "1" ) ) {
																			%>
																			<td class="view_desc" align="center">
																				&nbsp;&nbsp;&nbsp;I&nbsp;&nbsp;&nbsp;
																			</td>
																			<%
																				} else if ( request.getAttribute( "rveh_acc_des" + z ).equals( "2" ) ) {
																			%>
																			<td class="view_desc" align="center">
																				&nbsp;&nbsp;&nbsp;C&nbsp;&nbsp;&nbsp;
																			</td>
																			<%
																				}
																			%>
																			<td class="view_desc" align="center"><%=request.getAttribute( "rveh_alt_cod" + z )%></td>
																			<td class="view_desc" align="center">
																				&nbsp;&nbsp;&nbsp;
																				<bean:write name="revisiones" property="rveh_cada_cdm" scope="page" />
																			</td>
																			<td class="view_desc" align="center">
																				&nbsp;&nbsp;&nbsp;
																				<bean:write name="revisiones" formatKey="global.numberformat" property="rveh_cada_cdk" scope="page" />
																			</td>
																			<td align="center">
																				<IMG border="0" onClick="edit_revision('<%=z%>')" src="<%=request.getContextPath()%>/images/editar.gif"
																					alt="<bean:message key="138"/>" width="16" height="16" style="cursor: hand">
																				<IMG border="0" onClick="remove_revision('<%=z%>', '<bean:write name="revisiones" property="rveh_actividad" scope="page"/>')"
																					src="<%=request.getContextPath()%>/images/eliminar.gif" alt="<bean:message key="139"/>" width="16" height="16"
																					style="cursor: hand">
																			</td>
																		</tr>
																			<%
																				}
																			%>
																			<%
																				if ( z % 2 != 0 ) {
																			%>
																		<tr style="background: #F1F5FA"><TD width="40" class="view_desc" align="center"><%=z + 1%></TD>
																			<td class="view_item">
																				<bean:write name="revisiones" property="rveh_actividad" scope="page" />
																			</td>
																			<%
																				if ( request.getAttribute( "rveh_acc_des" + z ).equals( "1" ) ) {
																			%>
																			<td class="view_desc" align="center">
																				&nbsp;&nbsp;&nbsp;I&nbsp;&nbsp;&nbsp;
																			</td>
																			<%
																				} else if ( request.getAttribute( "rveh_acc_des" + z ).equals( "2" ) ) {
																			%>
																			<td class="view_desc" align="center">
																				&nbsp;&nbsp;&nbsp;C&nbsp;&nbsp;&nbsp;
																			</td>
																			<%
																				}
																			%>
																			<td class="view_desc" align="center"><%=request.getAttribute( "rveh_alt_cod" + z )%></td>
																			<td class="view_desc" align="center">
																				&nbsp;&nbsp;&nbsp;
																				<bean:write name="revisiones" property="rveh_cada_cdm" scope="page" />
																			</td>
																			<td class="view_desc" align="center">
																				&nbsp;&nbsp;&nbsp;
																				<bean:write name="revisiones" formatKey="global.numberformat" property="rveh_cada_cdk" scope="page" />
																			</td>
																			<td align="center">
																				<IMG border="0" onClick="edit_revision('<%=z%>')" src="<%=request.getContextPath()%>/images/editar.gif"
																					alt="<bean:message key="138"/>" width="16" height="16" style="cursor: hand">
																				<IMG border="0" onClick="remove_revision('<%=z%>', '<bean:write name="revisiones" property="rveh_actividad" scope="page"/>')"
																					src="<%=request.getContextPath()%>/images/eliminar.gif" alt="<bean:message key="139"/>" width="16" height="16"
																					style="cursor: hand">
																			</td>
																		</tr>
																			<%
																				}
																			%>
																			
																		<%
																			z++;
																		%>
																	</logic:iterate>
																</table>
															</td>
														</tr>
														<TR>
															<TD>&nbsp;
																
															</TD>
														</TR>
														<tr>
															<TD colspan="6">
																&nbsp;
																<INPUT type="hidden" name="tamMantBasicos" value="<%=z%>">
															</TD>
														</tr>
														<tr>
															<TD colspan="6" align="center">
																<INPUT type="button" onClick="add_revision('<%=z%>')" class="sbttn" value="<bean:message key="6010"/>">
																<br>
																<BR>
															</TD>
														</tr>
														<tr>
															<td>&nbsp;
																
															</td>
														</tr>
														<tr>
															<td class="view_item" colspan="6">&nbsp;
																
															</td>
														</tr>
														<tr>
															<td class="view_item" colspan="6">
																<bean:message key="7450" />
															</td>
														</tr>
														<tr>
															<td class="view_item" colspan="6">
																<bean:message key="7450a" />
															</td>
														</tr>
														<tr>
															<td>&nbsp;
																
															</td>
														</tr>
														<tr>
															<td class="view_item" colspan="6">
																<bean:message key="7450b" />
															</td>
														</tr>
														<tr>
															<td>&nbsp;
																
															</td>
														</tr>
														<tr>
															<td class="view_item" colspan="6">
																<bean:message key="7450c" />
															</td>
														</tr>
														<tr>
															<td>&nbsp;
																
															</td>
														</tr>
														<tr>
															<td>&nbsp;
																
															</td>
														</tr>
														<tr>
															<td class="view_item" colspan="6">
																<bean:message key="7406" />
															</td>
														</tr>
														<tr>
															<td>&nbsp;
																
															</td>
														</tr>

														<tr>
															<td class="view_item" colspan="6">
																<bean:message key="7407" />
															</td>
														</tr>
														<tr>
															<td colspan="3">
																<table align="center" width="70%">
																	<TR>
																		<TD rowspan="2" align="center" class="tdNameOption" style="border: 1px solid #0066D3">
																			<bean:message key="3559" />
																		</TD>
																		<TD align="center" class="tdNameOption" style="border: 1px solid #0066D3">
																			<bean:message key="6191" />
																		</TD>
																		<TD align="center" class="tdNameOption" style="border: 1px solid #0066D3">
																			<bean:message key="1068" />
																		</TD>
																		<TD align="center" class="tdNameOption" style="border: 1px solid #0066D3">
																			<bean:message key="1057" />
																		</TD>
																	</TR>
																	<TR>
																		<TD align="center" class="view_item">
																			<html:text property="mant_cada_cdk" size="6" onkeyup="isNatural(this);" onblur="isNatural(this);" maxlength="10"
																				styleClass="selNum" onfocus="this.select()" />
																		</TD>
																		<TD align="center" class="view_item">
																			<html:text property="mant_cada_cdm" size="2" onkeyup="isNatural(this);" onblur="isNatural(this);" maxlength="10"
																				styleClass="selNum" onfocus="this.select()" />
																		</TD>
																		<TD align="center" class="view_item">
																			<html:select property="mant_alt_cod" styleClass="aClassSelectL" onchange="habilitar()">
																				<html:options collection="alternativas" labelProperty="ralt_des" property="ralt_cod" />
																			</html:select>
																		</TD>
																	</TR>
																</table>
															</td>
														</tr>
														<tr>
															<td>&nbsp;
																
															</td>
														</tr>
														<tr>
															<td>&nbsp;
																
															</td>
														</tr>
														<tr>
															<td>&nbsp;
																
															</td>
														</tr>
													</table>
												</TD>
											</tr>
											<tr>
												<TD  colspan="9">
													<table border="0" id="tab9" cellspacing="0" cellpadding="0" style="display: none" width="100%">
														<tr>
															<td colspan="7">
																<table width="100%" border="0">
																	<tr>
																		<td colspan="7" align="center">
																			<bean:message key="global.guardar" />
																		</td>
																	</tr>
																	<tr>
																		<td class="view_item" colspan="7" align="center">
																			<b><bean:message key="834a" />
																			</b>
																		</td>
																	</tr>
																	<tr>
																		<td>&nbsp;
																			
																		</td>
																	</tr>
																	<tr>
																		<td class="view_item" colspan="7">
																			<bean:message key="7413" />
																		</td>
																	</tr>

																	
																	<% if (vehiculosC.getVehi_fechaencero().compareTo(BigDecimal.ZERO)==1){ %>
																	<tr>
																		<td class="view_item" colspan="7"><bean:message key="5190" />&nbsp;<strong><%=vehiculosC.getVehi_fechaencero().toString()%></strong>
																			
																		</td>
																			
																		
																	</tr>
																	<%} %>
																	
																	<%try{
																	Cookie cookies[] = request.getCookies();
																	BigDecimal bg=BigDecimal.ZERO;
																	for(int u=0; u < cookies.length; u++) {
                														Cookie thisCookie = cookies[u];
														           		if (thisCookie.getName().equals("OdometroCero")) {
																			if (thisCookie.getValue().compareTo("")==0){
																				bg=BigDecimal.ZERO;
																			}else{
															                    bg= new BigDecimal(thisCookie.getValue());
														                    // Delete the cookie by setting its maximum age to zero
														                    }
														                    //thisCookie.setMaxAge(0);
														            	}
												            		}
																	if (bg.compareTo(BigDecimal.ZERO)==1){ %>
																	<tr>
																		<td class="view_item" colspan="7"><bean:message key="5191" />&nbsp;<strong><%=bg.toString()%></strong><bean:message key="5192" />
																			
																		</td>
																			
																		
																	</tr>
																	<%}
																	}catch(Exception e){
																	
																	} %>
																	<tr>
																		<td class="view_item"  width="15%" valign="bottom" >
																			<bean:message key="6191" />
																		</td>
																		<td width="20%" valign="bottom">
																			<html:text property="distanciaMantenimientosBasicos" styleId="distanciaMantenimientosBasicos" size="10" maxlength="10" styleClass="selNum" onfocus="this.select()" />
																		</td>
																		<td class="view_item" width="15%" valign="bottom">
																			<bean:message key="6190" />
																		</td>
																		<td width="50%" valign="bottom">
																			<html:hidden property="fechaMantenimientosBasicos" styleId="fechaMantenimientosBasicos" />
																			<SCRIPT language="JavaScript">obtenerCamposFecha2('cDia4', 'cMes4', 'cAno4', 'fechaMantenimientosBasicos');</SCRIPT>
																		</td>
																		
																	</tr>
																

																	
																</table>
															</td>
														</tr>

														<tr>
															<td class="view_item" colspan="7">
																<bean:message key="7414" />
															</td>
														</tr>
														<tr>
															<td>&nbsp;
																
															</td>
														</tr>
														<tr>
															<td class="view_item" colspan="7">
																<bean:message key="7416a" />
															</td>
														</tr>
														<tr>
															<td class="tdNameOption" style="border: 1px solid #0066D3" align="center" width="5%">
																<bean:message key="7448" />
															</td>
															<td class="tdNameOption" colspan="2" style="border: 1px solid #0066D3" align="center" width="60%">
																<bean:message key="1056" />
															</td>

															<td class="tdNameOption" style="border: 1px solid #0066D3" align="center" width="5%">
																<bean:message key="6175" />
																&nbsp;
															</td>
															<td colspan="2" class="tdNameOption" style="border: 1px solid #0066D3" align="center" width="20%">
																<bean:message key="1500" />
															</td>
															<td class="tdNameOption" style="border: 1px solid #0066D3" width="10%">
																<bean:message key="global.acciones" />
															</td>
														</tr>
														<tr>
															<td class="tdtitle" align="center"></td>
															<td></td>
															<td class="tdtitle" align="center"></td>
															<td class="tdtitle" align="center"></td>
															<td class="tdtitle" align="center">
																<bean:message key="6191" />
															</td>
															<td class="tdtitle" align="center">
																<bean:message key="1070" />
															</td>
															<td></td>
														</tr>
														<%
															z = 0;
															valor = "0";
															int counter;
														%>
														
														<logic:iterate indexId="ind" id="revisiones" name="REVISIONES" type="com.servidoctor.parametros.model.RevisionesVehiculo">
															<logic:notEqual name="revisiones" value="1" property="rveh_bloqueado">

															<%
																counter=revisiones.getRveh_cod().intValue();
																
																if ( z % 2 == 0 ) {
															%>
															<tr style="background: #ffffff" id="celda<%=z%>"><td class="view_item" align="center"><%=z + 1%></td>
																<td class="view_item">
																	<input type="checkbox" name="mantenimientosBasicos<%=z%>" id="mantenimientosBasicos<%=z%>" value="true" onClick="seleccionar(this, <%=z%>)" />
																</td>
																<td class="view_item">
																	<bean:write name="revisiones" property="rveh_actividad" scope="page" />
																</td>
																<%
																	if ( request.getAttribute( "rveh_acc_des" + z ).equals( "1" ) ) {
																%>
																<td class="view_desc" align="center">
																	&nbsp;&nbsp;&nbsp;I&nbsp;&nbsp;&nbsp;
																</td>
																<%
																	} else if ( request.getAttribute( "rveh_acc_des" + z ).equals( "2" ) ) {
																%>
																<td class="view_desc" align="center">
																	&nbsp;&nbsp;&nbsp;C&nbsp;&nbsp;&nbsp;
																</td>
																<%
																	}
																%>
																<td class="view_desc" align="center">
																	&nbsp;&nbsp;&nbsp;
																	<bean:write name="revisiones" property="rveh_control_kms" scope="page" />
																</td>
																<TD class="view_desc" align="center">
																	&nbsp;&nbsp;&nbsp;<%=ManejoFechas.FormateoFecha( revisiones.getRveh_control_fec().toString() )%></TD>

																<td align="center">
																	<IMG border="0" onClick="undo_revision('<%=z%>','<bean:write name="revisiones" property="rveh_actividad" scope="page"/>')"
																		src="<%=request.getContextPath()%>/images/boton.jpg" alt="<bean:message key="global.button.deshacer"/>" width="16" height="16"
																		style="cursor: hand">
																</td>
															</tr>
															
																<%
																	}
																%>
																<%
																	if ( z % 2 != 0 ) {
																%>
															<tr style="background: #F1F5FA" id="celda<%=z%>"><td class="view_item" align="center"><%=z + 1%></td>
																<td class="view_item">
																	<input type="checkbox" name="mantenimientosBasicos<%=z%>"  id="mantenimientosBasicos<%=z%>" value="true" onClick="seleccionar(this, <%=z%>)" />
																</td>
																<td class="view_item">
																	<bean:write name="revisiones" property="rveh_actividad" scope="page" />
																</td>
																<%
																	if ( request.getAttribute( "rveh_acc_des" + z ).equals( "1" ) ) {
																%>
																<td class="view_desc" align="center">
																	&nbsp;&nbsp;&nbsp;I&nbsp;&nbsp;&nbsp;
																</td>
																<%
																	} else if ( request.getAttribute( "rveh_acc_des" + z ).equals( "2" ) ) {
																%>
																<td class="view_desc" align="center">
																	&nbsp;&nbsp;&nbsp;C&nbsp;&nbsp;&nbsp;
																</td>
																<%
																	}
																%>
																<td class="view_desc" align="center">
																	&nbsp;&nbsp;&nbsp;
																	<bean:write name="revisiones" property="rveh_control_kms" scope="page" />
																</td>
																<TD class="view_desc" align="center">
																	&nbsp;&nbsp;&nbsp;<%=ManejoFechas.FormateoFecha( revisiones.getRveh_control_fec().toString() )%></TD>

																<td align="center">
																	<IMG border="0" onClick="undo_revision('<%=z%>','<bean:write name="revisiones" property="rveh_actividad" scope="page"/>')"
																		src="<%=request.getContextPath()%>/images/boton.jpg" alt="<bean:message key="global.button.deshacer"/>" width="16" height="16"
																		style="cursor: hand">
																</td>
															</tr>
															
																<%
																	}
																%>
																</logic:notEqual>
																<logic:equal name="revisiones" value="1" property="rveh_bloqueado">
																<tr style="background: #FDC1DB" id="celda<%=z%>"><td class="view_item" align="center"><%=z + 1%></td>
																<td class="view_item">
																	<input type="checkbox" name="mantenimientosBasicos<%=z%>"  id="mantenimientosBasicos<%=z%>" value="true" onClick="seleccionar(this, <%=z%>)" />
																</td>
																<td class="view_item">
																	<bean:write name="revisiones" property="rveh_actividad" scope="page" />
																</td>
																<%
																	if ( request.getAttribute( "rveh_acc_des" + z ).equals( "1" ) ) {
																%>
																<td class="view_desc" align="center">
																	&nbsp;&nbsp;&nbsp;I&nbsp;&nbsp;&nbsp;
																</td>
																<%
																	} else if ( request.getAttribute( "rveh_acc_des" + z ).equals( "2" ) ) {
																%>
																<td class="view_desc" align="center">
																	&nbsp;&nbsp;&nbsp;C&nbsp;&nbsp;&nbsp;
																</td>
																<%
																	}
																%>
																<td class="view_desc" align="center">
																	&nbsp;&nbsp;&nbsp;
																	<bean:write name="revisiones" property="rveh_control_kms" scope="page" />
																</td>
																<TD class="view_desc" align="center">
																	&nbsp;&nbsp;&nbsp;<%=ManejoFechas.FormateoFecha( revisiones.getRveh_control_fec().toString() )%></TD>

																<td align="center">
																	<IMG border="0" onClick="undo_revision('<%=z%>','<bean:write name="revisiones" property="rveh_actividad" scope="page"/>')"
																		src="<%=request.getContextPath()%>/images/boton.jpg" alt="<bean:message key="global.button.deshacer"/>" width="16" height="16"
																		style="cursor: hand">
																</td>
															</tr>
																
																</logic:equal>
																															<%
																z++;
															%>
														</logic:iterate>
														<TR>
															<TD colspan="7">&nbsp;
																
															</TD>
														</TR>
														<TR>
															<TD colspan="7">
																
															
														<div id="bobcontent77" style="visibility:hidden" ><table width="100%" border="0"  cellpadding="0" cellspacing="0" bgcolor="0099FF">
  <tr>
    <td width="3%">&nbsp;</td>
    <td valign="bottom" width="42%"><html:hidden property="vehi_fechaencero" styleId="vehi_fechaencero2" /><font color="#ffffff"><strong> <bean:message key="10551" /></strong></font></td>
    <td valign="top" width="55%"><script language="Javascript">obtenerCamposFecha2('DiaCero3', 'MesCero3', 'AnoCero3', 'tempcero');</script></td>
  </tr>
</table></div></TD>
														</TR>
														<TR>
															<TD colspan="7">&nbsp;
																
															</TD>
														</TR>
														
														<tr>
															<TD align="center" colspan="8">

																
																<div id="cargar" name="cargar" style="display:block;"><INPUT type="button" onClick="actualizar()" class="sbttn" value="<bean:message key="global.button.cargar"/>">
																</div>
																<script type="text/javascript">			
																/*if (document.forms[0].vehi_sistema.value=='3'){
																	document.getElementById('cargar').style.display='none';
																}*/
																</script>
															</td>
														</tr>
														<TR>
															<TD colspan="7">&nbsp;
																
															</TD>
														</TR>
														<tr>
															<td class="view_item" colspan="7">
																<bean:message key="7449" />
															</td>
														</tr>
														<TR>
															<TD colspan="7">&nbsp;
																
															</TD>
														</TR>
														<tr>
															<td colspan="7">
																<table align="center" width="70%">
																	<TR>
																		<TD rowspan="2" align="center" class="tdNameOption" style="border: 1px solid #0066D3">
																			<bean:message key="1500" />
																		</TD>
																		<TD align="center" class="tdNameOption" style="border: 1px solid #0066D3">
																			<bean:message key="6191" />
																		</TD>
																		<TD align="center" class="tdNameOption" style="border: 1px solid #0066D3">
																			<bean:message key="1070" />
																		</TD>
																	</TR>
																	<TR>
																		<TD align="center" class="view_item">
																			<html:text property="mant_control_kms" size="10" onkeyup="isNatural(this);" onblur="isNatural(this);" maxlength="10"
																				styleClass="selNum" onfocus="this.select()" styleId="mant_control_kms" />
																		</TD>
																		<TD align="center" class="view_item">
																			<html:hidden property="mant_control_fec" styleId="mant_control_fec" />
																			<SCRIPT language="JavaScript">obtenerCamposFecha2('cDia6', 'cMes6', 'cAno6', 'mant_control_fec');</SCRIPT>
																		</TD>
																	</TR>
																</table>
															</td>
														</tr>
													</table>
												</TD>
											</tr>
											<tr>
												<TD colspan="9">
													<table border="0" id="tab3" cellspacing="0" cellpadding="0" style="display: none" width="100%">
														<tr>
															<td colspan="5" align="center">
																<bean:message key="global.guardar" />
															</td>
														</tr>
														<tr>
															<td>&nbsp;
																
															</td>
														</tr>
														<tr>
															<td class="view_item" colspan="4">
																<bean:message key="7417" arg0='<%=res.getMessage( "parametro_adicion_controles" )%>' />
															</td>
														</tr>
														<tr>
															<td>&nbsp;
																
															</td>
														</tr>
														<tr>
															<td class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="global.numeral" />
															</td>
															<td class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																&nbsp;
																<bean:message key="1091" />
																&nbsp;&nbsp;
															</td>
															<td class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																&nbsp;
																<bean:message key="1092" />
																&nbsp;&nbsp;
															</td>
															<td class="tdNameOption" style="border: 1px solid #0066D3" align="center" width="197">
																&nbsp;
																<bean:message key="global.acciones" />
																&nbsp;&nbsp;
															</td>
														</tr>
														<tr>
															<TD colspan="3">&nbsp;
																
															</TD>
														</tr>
														<%
															int x = 0;
														%>
														<logic:iterate indexId="ind" id="controlVehiculo" name="CONTROLESVEHICULOS" type="com.servidoctor.sdcars.model.ControlesVehiculos">
															<tr>
																<td class="view_item" align="center"><%=x + 1%></td>
																<td class="view_item">
																	<bean:write name="controlVehiculo" property="cveh_concepto" scope="page" />
																	&nbsp;&nbsp;
																</td>
																<td class="view_item" class="tdContentText" valign="middle" align="center"><%=ManejoFechas.FormateoFecha( controlVehiculo.getCveh_fecvigenc().toString() )%></td>
																<td align="center">
																	<IMG border="0" onClick="edit_control('<%=x%>')" src="<%=request.getContextPath()%>/images/editar.gif"
																		alt="<bean:message key="138"/>" width="16" height="16" style="cursor: hand">
																	<IMG border="0" onClick="remove_control('<%=x%>', '<bean:write name="controlVehiculo" property="cveh_concepto" scope="page"/>')"
																		src="<%=request.getContextPath()%>/images/eliminar.gif" alt="<bean:message key="139"/>" width="16" height="16" style="cursor: hand">
																</td>
															</tr>
															<%
																x++;
															%>
														</logic:iterate>
														<tr>
															<TD colspan="4">&nbsp;
																
															</TD>
														</tr>
														<tr>
															<TD colspan="4" align="center">
																<INPUT type="button" align="middle" onClick="add_control('<%=x%>')" class="sbttn" value="<bean:message key="3505"/>">
															</TD>
														</tr>
														<tr>
															<TD colspan="4">&nbsp;
																
															</TD>
														</tr>
														<tr>
															<td class="view_item" colspan="5">
																<bean:message key="7445" />
															</td>
														</tr>
														<tr>
															<TD colspan="4">
																<html:text styleClass="selNum" property="cveh_dias_antes" maxlength="3" size="3" onkeyup="isNatural(this)"
																	onblur="isNatural(this)" onfocus="this.select()" />
															</TD>
														</tr>
													</table>
												</TD>
											</tr>
											<tr>
												<TD colspan="9">
													<table border="0" cellpadding="0" cellspacing="0" id="tab4" style="display: none" width="100%">
														<tr>
															<td colspan="5" align="center">
																<bean:message key="global.guardar" />
															</td>
														</tr>
														<tr>
															<td>&nbsp;
																
															</td>
														</tr>
														<tr>
															<td class="view_item" colspan="5">
																<bean:message key="7420" arg0='<%=res.getMessage( "parametro_adicion_seguros" )%>' />
															</td>
														</tr>
														<tr>
															<td class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="global.numeral" />
															</td>
															<TD class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="3518" />
																&nbsp;&nbsp;&nbsp;
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="1095" />
																&nbsp;&nbsp;&nbsp;
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="1092" />
															</TD>
															<td class="tdNameOption" style="border: 1px solid #0066D3">
																<bean:message key="global.acciones" />
															</td>
														</tr>
														<tr>
															<TD>&nbsp;
																
															</TD>
															<TD>&nbsp;
																
															</TD>
															<TD>&nbsp;
																
															</TD>
															<TD>&nbsp;
																
															</TD>
															<TD>&nbsp;
																
															</TD>
														</tr>
														<%
															x = 0;
														%>
														<logic:iterate indexId="ind" id="seguro" name="SEGUROSVEHICULOS" type="com.servidoctor.sdcars.model.SegurosVehiculos">
															<tr>
																<td class="view_item" align="center"><%=x + 1%></td>
																<td class="view_item">
																	&nbsp;&nbsp;
																	<bean:write name="seguro" property="sveh_ciaaseg" scope="page" />
																	&nbsp;&nbsp;
																</td>
																<td class="view_item" align="center">
																	<bean:write name="seguro" property="sveh_indpais1" scope="page" />
																	&nbsp;
																	<bean:write name="seguro" property="sveh_indciudad1" scope="page" />
																	&nbsp;
																	<bean:write name="seguro" property="sveh_telefono1" scope="page" />
																	&nbsp;&nbsp;
																</td>
																<td class="view_item" align="center"><%=ManejoFechas.FormateoFecha( seguro.getSveh_fecvigenchasta().toString() )%></td>
																<td align="center">
																	<IMG border="0" onClick="edit_seguro('<%=x%>')" src="<%=request.getContextPath()%>/images/editar.gif" alt="<bean:message key="138"/>"
																		width="16" height="16" style="cursor: hand">
																	<IMG border="0" onClick="remove_seguro('<%=x%>', '<bean:write name="seguro" property="sveh_ciaaseg" scope="page"/>')"
																		src="<%=request.getContextPath()%>/images/eliminar.gif" alt="<bean:message key="139"/>" width="16" height="16" style="cursor: hand">
																</td>
															</tr>
															<%
																x++;
															%>
														</logic:iterate>
														<input type="hidden" name="total_seguros" value="<%=x%>">
														<tr>
															<TD colspan="6">&nbsp;
																
															</TD>
														</tr>
														<tr>
															<td class="view_item" colspan="5">
																&nbsp;
																<INPUT type="hidden" name="tamSeguros" value="<%=x%>">
															</td>
														</tr>
														<tr>
															<TD colspan="6" align="center">
																<INPUT type="button" onClick="add_seguro('<%=x%>')" class="sbttn" value="<bean:message key="6011"/>">
																<BR>
																<BR>
															</TD>
														</tr>
														<tr>
															<td class="view_item" colspan="5">
																<bean:message key="7444" />
															</td>
														</tr>
														<tr>
															<TD colspan="4">
																<html:text property="sveh_dias_antes" maxlength="3" size="3" styleClass="selNum" onkeyup="isNatural(this)"
																	onblur="isNatural(this)" onfocus="this.select()" />
															</TD>
														</tr>
													</table>
												</TD>
											</tr>
											<tr>
												<TD  colspan="9">
													<table border="0" cellpadding="0" cellspacing="0" id="tab10" style="display: none" width="100%">
														<tr>
															<td colspan="8" align="center">
																<bean:message key="global.guardar" />
															</td>
														</tr>
														<tr>
															<td class="view_item" colspan="7" align="center">
																<b><bean:message key="834a" />
																</b>
															</td>
														</tr>
														<tr>
															<td>&nbsp;
																
															</td>
														</tr>
														<tr>
															<td class="view_item" colspan="8">
																<bean:message key="7428" arg0='<%=res.getMessage( "parametro_adicion_gastos_mecanica" )%>' />&nbsp;<bean:message key="6033" />
															</td>
														</tr>
														<tr>
															<td>&nbsp;
																
															</td>
														</tr>
														<tr>
															<td class="view_item" colspan="8">
																<bean:message key="7429" arg0='<%=res.getMessage( "parametro_adicion_gastos_mecanica" )%>' />
															</td>
														</tr>
														<tr>
															<TD rowspan="2" class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="global.numeral" />
															</TD>
															<TD rowspan="2" class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="1099" />
																&nbsp;&nbsp;&nbsp;
															</TD>
															<TD colspan="2" class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="1100" />
															</TD>
															<TD colspan="3" class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="1101" />
															</TD>
															<TD rowspan="2" class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="global.acciones" />
															</td>
														</tr>
														<tr>
															<TD class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="6017" />
																&nbsp;&nbsp;&nbsp;
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="6018" />
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="6019" />
																&nbsp;&nbsp;&nbsp;
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="6020" />
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="6021" />
																&nbsp;&nbsp;&nbsp;
															</TD>
														</tr>
														<tr>
															<TD colspan="7">&nbsp;
																
															</TD>
														</tr>
														<%
															x = 0;
																float totalMensual = 0;
																float totalAnual = 0;
																float mensual = 0;
																float anual = 0;
														%>
														<logic:iterate indexId="indx" id="gastos" name="GASTOSVEHICULOSMECANICA" type="com.servidoctor.parametros.model.GastosVehiculosMecanica">
															<%
																int diasDiferencia=( ManejoFechas.restaFechas( gastos.getGasv_fechaini().toString(), gastos.getGasv_fechafin().toString() ) );
																
																if (diasDiferencia!=0){
																		mensual = ( 30 * Float.parseFloat( gastos.getGasv_valor().toString() ) )/ diasDiferencia;
																		Float val = new Float( mensual );
																		
																		if ( !val.isNaN() ) {
																			anual = mensual * 12;
																			totalMensual += mensual;
																			totalAnual += anual;

																			mensual = java.lang.Math.round( mensual * 100 );
																			mensual /= 100;

																			anual = java.lang.Math.round( anual * 100 );
																			anual /= 100;
																		}
																}
															%>
															<tr>
																<td class="view_item" align="center"><%=x + 1%></td>
																<td class="view_item">
																	<bean:write name="gastos" property="gasv_descripcion" scope="page" />
																	&nbsp;&nbsp;
																</td>
																<td class="view_desc" align="center">
																<%if (diasDiferencia!=0){%>
																<%= ManejoFechas.FormateoFecha( gastos.getGasv_fechaini().toString() )%>
																<%}else{ %>
																---
																<%} %>
																</td>
																<td class="view_desc" align="center">
																<%if (diasDiferencia!=0){%>
																<%=ManejoFechas.FormateoFecha( gastos.getGasv_fechafin().toString() )%>
																<%}else{ %>
																---
																<%} %>
																</td>
																<td class="view_desc" align="center">
																	<%
																		if (diasDiferencia==0){
																		//if ( val.isNaN() ) {
																	%>
																	---
																	<%
																		} else {
																	%>
																	<bean:write name="gastos" property="gasv_valor" scope="page" />
																	<%
																		}
																	%>
																	
																	
																	&nbsp;&nbsp;
																</td>
																<td class="view_desc" align="center">
																	<%
																		if (diasDiferencia==0){
																		//if ( val.isNaN() ) {
																	%>
																	---
																	<%
																		} else {
																	%>
																	<%=mensual%>
																	<%
																		}
																	%>
																</td>
																<td class="view_desc" align="center">
																	<%
																		if (diasDiferencia==0){
																		//if ( val.isNaN() ) {
																	%>
																	---
																	<%
																		} else {
																	%>
																	<%=anual%>
																	<%
																		}
																	%>
																</td>
																<td align="center">
																	<IMG border="0" onClick="edit_gastoMecanica('<%=x%>')" src="<%=request.getContextPath()%>/images/editar.gif"
																		alt="<bean:message key="138"/>" width="16" height="16" style="cursor: hand">
																	<IMG border="0" onClick="remove_gastoMecanica('<%=x%>', '<bean:write name="gastos" property="gasv_descripcion" scope="page"/>')"
																		src="<%=request.getContextPath()%>/images/eliminar.gif" alt="<bean:message key="139"/>" width="16" height="16" style="cursor: hand">
																</td>
															</tr>
															<%
																x++;
															%>
														</logic:iterate>
														<tr>
															<TD colspan="7">&nbsp;
																
															</TD>
														</tr>
														<%
															if ( x > 0 ) {
																	totalMensual = java.lang.Math.round( totalMensual * 100 );
																	totalMensual /= 100;

																	totalAnual = java.lang.Math.round( totalAnual * 100 );
																	totalAnual /= 100;
														%>
														<tr>
															<td class="view_item">
																<bean:message key="6026" />
															</td>
															<td colspan="4"></td>
															<td class="view_desc" align="center"><%=totalMensual%></td>
															<td class="view_desc" align="center"><%=totalAnual%></td>
															<%
																//Hay q convertir los valores a String o si no la etiqueta no los soporta
																		totalMensualGM = String.valueOf( totalMensual );
																		totalAnualGM = String.valueOf( totalAnual );
															%>
															<!-- Esto es para poder acceder al resumen desde el pop-up-->
															<html:hidden property="totalMensualGastosMecanica" value="<%=totalMensualGM%>" />
															<html:hidden property="totalAnualGastosMecanica" value="<%=totalAnualGM%>" />
															<td></td>
														</tr>
														<%
															}
														%>
														<tr>
															<TD colspan="7">&nbsp;
																
															</TD>
														</tr>
														<tr>
															<TD colspan="7">
																<INPUT type="hidden" name="tamGastosMecanica" value="<%=x%>">
															</TD>
														</tr>
														<tr>
															<TD colspan="7" align="center">
																<INPUT type="button" onClick="add_gastoMecanica('<%=x%>')" class="sbttn" value="<bean:message key="3590" />">
																<br>
																<br>
															</TD>
														</tr>
													</table>
												</TD>
											</tr>
											<tr>
												<TD  colspan="9">
													<table border="0" cellpadding="0" cellspacing="0" id="tab5" style="display: none" width="100%">
														<tr>
															<td colspan="12" align="center">
																<bean:message key="global.guardar" />
															</td>
														</tr>
														<tr>
															<td>&nbsp;
																
															</td>
														</tr>
														<tr>
															<td class="view_item" colspan="12">
																<bean:message key="7432" arg0='<%=res.getMessage( "parametro_adicion_gastos_anuales" )%>' />&nbsp;<bean:message key="6033" />
															</td>
														</tr>
														<tr>
															<td>&nbsp;
																
															</td>
														</tr>
														<tr>
															<TD rowspan="2" class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="global.numeral" />
															</TD>
															<TD rowspan="2" class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="1099" />
																&nbsp;&nbsp;&nbsp;
															</TD>
															<TD colspan="2" class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="1100" />
															</TD>
															<TD rowspan="2" class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="1101" />
															</TD>
															<TD rowspan="2" class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="6022" />
															</TD>
															<TD rowspan="2" class="tdNameOption" style="border: 1px solid #0066D3">
																<bean:message key="global.acciones" />
															</td>
														</tr>
														<tr>
															<TD class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="6017" />
																&nbsp;&nbsp;&nbsp;
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="6018" />
															</TD>
														</tr>
														<tr>
															<TD colspan="6">&nbsp;
																
															</TD>
														</tr>
														<%
															x = 0;
																totalAnual = 0;
																totalMensual = 0;
																mensual = 0;
																anual = 0;
														%>
														<logic:iterate indexId="indx" id="gastosanuales" name="GASTOSVEHICULOSANUALES"
															type="com.servidoctor.parametros.model.GastosVehiculosAnuales">
															<%
																int diasDiferencia=ManejoFechas.restaFechas( gastosanuales.getGasv_fechaini().toString(), gastosanuales.getGasv_fechafin().toString() );
																						
																if (diasDiferencia!=0){
																
																				mensual = ( 30 * Float.parseFloat( gastosanuales.getGasv_valor().toString() ) )/ ( diasDiferencia );
																				Float val = new Float( mensual );
																				
																				if ( !val.isNaN() ) {
																					anual = Float.parseFloat( gastosanuales.getGasv_valor().toString() );
																					totalMensual += mensual;
																					totalAnual += anual;

																					mensual = java.lang.Math.round( mensual * 100 );
																					mensual /= 100;

																					anual = java.lang.Math.round( anual * 100 );
																					anual /= 100;
																				}
																}
															%>
															<tr>
																<td class="view_item" align="center"><%=x + 1%></td>
																<td class="view_item">
																	
																	<bean:write name="gastosanuales" property="gasv_descripcion" scope="page" />
																	&nbsp;&nbsp;
																</td>
																<td class="view_desc" align="center">
																<%
																		if (diasDiferencia==0){
																		//if ( val.isNaN() ) {
																	%>
																	---
																	<%
																		} else {
																	%>
																	<%=ManejoFechas.FormateoFecha( gastosanuales.getGasv_fechaini().toString() )%>
																	<%
																		}
																	%>
																
																
																</td>
																<td class="view_desc" align="center">
																<%
																		if (diasDiferencia==0){
																		//if ( val.isNaN() ) {
																	%>
																	---
																	<%
																		} else {
																	%>
																	<%=ManejoFechas.FormateoFecha( gastosanuales.getGasv_fechafin().toString() )%>
																	<%
																		}
																	%>
																
																
																</td>
																<td class="view_desc" align="center">
																	<%
																		if (diasDiferencia==0){
																		//if ( val.isNaN() ) {
																	%>
																	---
																	<%
																		} else {
																	%>
																	<bean:write name="gastosanuales" property="gasv_valor" scope="page" />
																	&nbsp;&nbsp;
																	<%
																		}
																	%>
																	
																	
																</td>
																<td class="view_desc" align="center">
																	<%
																		if (diasDiferencia==0){
																		//if ( val.isNaN() ) {
																	%>
																	---
																	<%
																		} else {
																	%>
																	<%=mensual%>
																	<%
																		}
																	%>
																</td>
																<td align="center">
																	<IMG border="0" onClick="edit_gastoanuales('<%=x%>')" src="<%=request.getContextPath()%>/images/editar.gif"
																		alt="<bean:message key="138"/>" width="16" height="16" style="cursor: hand">
																	<IMG border="0"
																		onClick="remove_gastoanuales('<%=x%>', '<bean:write name="gastosanuales" property="gasv_descripcion" scope="page"/>')"
																		src="<%=request.getContextPath()%>/images/eliminar.gif" alt="<bean:message key="139"/>" width="16" height="16" style="cursor: hand">
																	&nbsp;&nbsp;&nbsp;&nbsp;
																</td>
															</tr>
															<%
																x++;
															%>
														</logic:iterate>
														<tr>
															<TD colspan="6">&nbsp;
																
															</TD>
														</tr>
														<%
															if ( x > 0 ) {
																	totalMensual = java.lang.Math.round( totalMensual * 100 );
																	totalMensual /= 100;
														%>
														<tr>
															<td class="view_item">
																<bean:message key="6026" />
															</td>
															<td colspan="3"></td>
															<td class="view_desc" align="center"><%=totalAnual%></td>
															<td class="view_desc" align="center"><%=totalMensual%></td>
															<%
																//Hay q convertir los valores a String o si no la etiqueta no los soporta
																		totalAnualGA = String.valueOf( totalAnual );
																		totalMensualGA = String.valueOf( totalMensual );
															%>
															<!-- Esto es para poder acceder al resumen desde el pop-up-->
															<html:hidden property="totalAnualGastosAnuales" value="<%=totalAnualGA%>" />
															<td></td>
														</tr>
														<%
															}
														%>
														<tr>
															<TD colspan="8">&nbsp;
																
															</TD>
														</tr>
														<tr>
															<TD colspan="8">
																<INPUT type="hidden" name="tamGastosAnuales" value="<%=x%>">
															</TD>
														</tr>
														<tr>
															<TD align="center" colspan="8">
																<INPUT type="button" onClick="add_gastoanuales('<%=x%>')" class="sbttn" value="<bean:message key="3591" />">
																<br>
																<br>
															</TD>
														</tr>
													</table>
												</TD>
											</tr>
											<tr>
												<TD colspan="9">
													<table border="0" cellpadding="0" cellspacing="0" id="tab6" style="display: none" width="100%">
														<tr>
															<td colspan="8" align="center">
																<bean:message key="global.guardar" />
															</td>
														</tr>
														<tr>
															<td>&nbsp;
																
															</td>
														</tr>
														<tr>
															<td class="view_item" colspan="8">
																<bean:message key="7435" arg0='<%=res.getMessage( "parametro_adicion_gastos" )%>' />&nbsp;<bean:message key="6033" />
															</td>
														</tr>
														<tr>
															<td>&nbsp;
																
															</td>
														</tr>
														<tr>
															<TD rowspan="2" class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="global.numeral" />
															</TD>
															<TD rowspan="2" class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="1099" />
																&nbsp;&nbsp;&nbsp;
															</TD>
															<TD colspan="2" class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="1100" />
															</TD>
															<TD colspan="3" class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="1101" />
															</TD>
															<TD rowspan="2" class="tdNameOption" style="border: 1px solid #0066D3">
																<bean:message key="global.acciones" />
															</td>
														</tr>
														<tr>
															<TD class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="6017" />
																&nbsp;&nbsp;&nbsp;
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="6018" />
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="6019" />
																&nbsp;&nbsp;&nbsp;
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="6020" />
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="6021" />
																&nbsp;&nbsp;&nbsp;
															</TD>
														</tr>
														<tr>
															<TD colspan="7">&nbsp;
																
															</TD>
														</tr>
														<%
															x = 0;
																totalMensual = 0;
																totalAnual = 0;
																mensual = 0;
																anual = 0;
														%>
														<logic:iterate indexId="indx" id="gastos" name="GASTOSVEHICULOSNOANUALES"
															type="com.servidoctor.parametros.model.GastosVehiculosNoAnuales">
															<%
																int diasDiferencia= ManejoFechas.restaFechas( gastos.getGasv_fechaini().toString(), gastos.getGasv_fechafin().toString() ) ;
																						
																if (diasDiferencia!=0){
																mensual = ( 30 * Float.parseFloat( gastos.getGasv_valor().toString() ) )/ ( diasDiferencia );
																				Float val = new Float( mensual );
																				
																				if ( !val.isNaN() ) {
																					anual = mensual * 12;
																					totalMensual += mensual;
																					totalAnual += anual;

																					mensual = java.lang.Math.round( mensual * 100 );
																					mensual /= 100;

																					anual = java.lang.Math.round( anual * 100 );
																					anual /= 100;
																				}
																}
															%>
															<tr>
																<td class="view_item" align="center"><%=x + 1%></td>
																<td class="view_item">
																	<bean:write name="gastos" property="gasv_descripcion" scope="page" />
																	&nbsp;&nbsp;
																</td>
																<td class="view_desc" align="center">
																<%
																		if (diasDiferencia==0){
																		//if ( val.isNaN() ) {
																	%>
																	---
																	<%
																		} else {
																	%>
																	<%=ManejoFechas.FormateoFecha( gastos.getGasv_fechaini().toString() )%>
																	<%
																		}
																	%>
																
																</td>
																<td class="view_desc" align="center">
																<%
																		if (diasDiferencia==0){
																		//if ( val.isNaN() ) {
																	%>
																	---
																	<%
																		} else {
																	%>
																	<%=ManejoFechas.FormateoFecha( gastos.getGasv_fechafin().toString() )%>
																	<%
																		}
																	%>
																
																</td>
																<td class="view_desc" align="center">
																	<%
																		if (diasDiferencia==0){
																		//if ( val.isNaN() ) {
																	%>
																	---
																	<%
																		} else {
																	%>
																	<bean:write name="gastos" property="gasv_valor" scope="page" />
																	&nbsp;&nbsp;
																	<%
																		}
																	%>
																	
																	
																</td>
																<td class="view_desc" align="center">
																	<%
																		if (diasDiferencia==0){
																		//if ( val.isNaN() ) {
																	%>
																	---
																	<%
																		} else {
																	%>
																	<%=mensual%>
																	<%
																		}
																	%>
																</td>
																<td class="view_desc" align="center">
																	<%
																		if (diasDiferencia==0){
																		//if ( val.isNaN() ) {
																	%>
																	---
																	<%
																		} else {
																	%>
																	<%=anual%>
																	<%
																		}
																	%>
																	
																</td>
																<td align="center">
																	<IMG border="0" onClick="edit_gasto('<%=x%>')" src="<%=request.getContextPath()%>/images/editar.gif" alt="<bean:message key="138"/>"
																		width="16" height="16" style="cursor: hand">
																	<IMG border="0" onClick="remove_gasto('<%=x%>', '<bean:write name="gastos" property="gasv_descripcion" scope="page"/>')"
																		src="<%=request.getContextPath()%>/images/eliminar.gif" alt="<bean:message key="139"/>" width="16" height="16" style="cursor: hand">
																</td>
															</tr>
															<%
																x++;
															%>
														</logic:iterate>
														<tr>
															<TD colspan="7">&nbsp;
																
															</TD>
														</tr>
														<%
															if ( x > 0 ) {
																	totalMensual = java.lang.Math.round( totalMensual * 100 );
																	totalMensual /= 100;

																	totalAnual = java.lang.Math.round( totalAnual * 100 );
																	totalAnual /= 100;
														%>
														<tr>
															<td class="view_item">
																<bean:message key="6026" />
															</td>
															<td colspan="4"></td>
															<td class="view_desc" align="center"><%=totalMensual%></td>
															<td class="view_desc" align="center"><%=totalAnual%></td>
															<%
																//Hay q convertir los valores a String o si no la etiqueta no los soporta
																		totalMensualGNA = String.valueOf( totalMensual );
																		totalAnualGNA = String.valueOf( totalAnual );
															%>
															<!-- Esto es para poder acceder al resumen desde el pop-up-->
															<html:hidden property="totalMensualGastosNoAnuales" value="<%=totalMensualGNA%>" />
															<html:hidden property="totalAnualGastosNoAnuales" value="<%=totalAnualGNA%>" />
															<td></td>
														</tr>
														<%
															}
														%>
														<tr>
															<TD colspan="7">&nbsp;
																
															</TD>
														</tr>
														<tr>
															<TD colspan="8">
																<INPUT type="hidden" name="tamGastosNOAnuales" value="<%=x%>">
															</TD>
														</tr>
														<tr>
															<TD colspan="8" align="center">
																<INPUT type="button" onClick="add_gasto('<%=x%>')" class="sbttn" value="<bean:message key="3592" />">
																<br>
																<br>
															</TD>
														</tr>
													</table>
												</TD>
											</tr>
											<tr>
												<TD  colspan="9">
													<table border="0" cellpadding="0" cellspacing="0" id="tab7" style="display: none" width="100%">
														<tr>
															<td colspan="5" align="center">
																<bean:message key="global.guardar" />
															</td>
														</tr>
														<tr>
															<td>&nbsp;
																
															</td>
														</tr>
														<tr>
															<td class="view_item" colspan="5">
																<bean:message key="7425" arg0='<%=res.getMessage( "parametro_adicion_impuestos" )%>' />
															</td>
														</tr>
														<tr>
															<td>&nbsp;
																
															</td>
														</tr>
														<tr>
															<TD class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="global.numeral" />
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="1102" />
																&nbsp;&nbsp;&nbsp;
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="1107" />
															</TD>
															<TD class="tdNameOption" style="border: 1px solid #0066D3" align="center">
																<bean:message key="global.acciones" />
															</td>
														</tr>
														<tr>
															<TD>&nbsp;
																
															</TD>
															<TD>&nbsp;
																
															</TD>
															<TD>&nbsp;
																
															</TD>
															<TD>&nbsp;
																
															</TD>
														</tr>
														<%
															x = 0;
														%>
														<logic:iterate indexId="indx" id="impuestos" name="IMPUESTOS" type="com.servidoctor.sdcars.model.ImpuestoVehiculo">
															<tr>
																<td class="view_item" align="center"><%=x + 1%></td>
																<td class="view_item">
																	<bean:write name="impuestos" property="impv_descripcion" scope="page" />
																	&nbsp;&nbsp;
																</td>
																<td class="view_item" align="center"><%=ManejoFechas.FormateoFecha( impuestos.getImpv_vigenciahasta().toString() )%></td>
																<td align="center">
																	<IMG border="0" onClick="edit_impuestos('<%=x%>')" src="<%=request.getContextPath()%>/images/editar.gif"
																		alt="<bean:message key="138"/>" width="16" height="16" style="cursor: hand">
																	<IMG border="0" onClick="remove_impuestos('<%=x%>', '<bean:write name="impuestos" property="impv_descripcion" scope="page"/>')"
																		src="<%=request.getContextPath()%>/images/eliminar.gif" alt="<bean:message key="139"/>" width="16" height="16" style="cursor: hand">
																</td>
															</tr>
															<%
																x++;
															%>
														</logic:iterate>
														<tr>
															<TD>&nbsp;
																
															</TD>
														</tr>
														<tr>
															<TD colspan="6">
																<INPUT type="hidden" name="tamImpuestos" value="<%=x%>">
															</TD>
														</tr>
														<tr>
															<TD colspan="6" align="center">
																<INPUT type="button" onClick="add_impuestos('<%=x%>')" class="sbttn" value="<bean:message key="6032"/>">
																<br>
																<br>
															</TD>
														</tr>
														<tr>
															<td class="view_item" colspan="5">
																<bean:message key="7446" />
															</td>
														</tr>
														<tr>
															<TD colspan="4">
																<html:text property="iveh_dias_antes" maxlength="3" size="3" styleClass="selNum" onkeyup="isNatural(this)"
																	onblur="isNatural(this)" onfocus="this.select()" />
															</TD>
														</tr>
													</table>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<TD  colspan="9">
							<table border="0" id="tab8" cellspacing="0" cellpadding="0" style="display: none" width="100%">
								<tr>
									<td colspan="9" align="center">
										<bean:message key="global.guardar" />
									</td>
								</tr>
								<tr>
									<td>&nbsp;
										
									</td>
								</tr>
								<tr>
									<td colspan="9" class="view_item">
										<bean:message key="7438" />
									</td>
								</tr>
								<tr>
									<td colspan="9">&nbsp;
										
									</td>
								</tr>
								<tr>
									<td colspan="9" class="view_item">
										<bean:message key="7451" />
									</td>
								</tr>
								<tr>
									<td colspan="9">
										<table align="center">
											<tr>
												<td colspan="3" class="view_item">
													<bean:message key="6001" />
												</td>
												<td>
													&nbsp;&nbsp;&nbsp;
												</td>
												<td colspan="3">
													<html:hidden property="com_fechaini" styleId="com_fechaini" />
													<SCRIPT language="JavaScript">obtenerCamposFecha('cDia2', 'cMes2', 'cAno2', 'com_fechaini');</SCRIPT>
												</td>
												<td>
													&nbsp;&nbsp;&nbsp;
												</td>
												<td colspan="3" class="view_item">
													<bean:message key="6002" />
												</td>
												<td>
													&nbsp;&nbsp;&nbsp;
												</td>
												<td colspan="3">
													<html:hidden property="com_fechafin" styleId="com_fechafin" />
													<SCRIPT language="JavaScript">obtenerCamposFechaFuturo('cDia3', 'cMes3', 'cAno3', 'com_fechafin',1);</SCRIPT>
												</td>
											</tr>
											<tr>
												<td colspan="3" class="view_item">
													<bean:message key="6003" />
												</td>
												<td>
													&nbsp;&nbsp;&nbsp;
												</td>
												<td colspan="3">
													<html:text styleClass="selNum" property="com_lecturaini" maxlength="6" size="10" onkeyup="isNatural(this);" onblur="isNatural(this);"
														onfocus="this.select()" value="0" />
												</td>
												<td>
													&nbsp;&nbsp;&nbsp;
												</td>
												<td colspan="3" class="view_item">
													<bean:message key="6004" />
												</td>
												<td>
													&nbsp;&nbsp;&nbsp;
												</td>
												<td colspan="3">
													<html:text styleClass="selNum" property="com_lecturafin" maxlength="6" size="10" onkeyup="isNatural(this);" onblur="isNatural(this);"
														onfocus="this.select()" value="0" />
												</td>
											</tr>
											<tr>
												<td colspan="3" class="view_item">
													<bean:message key="6005" />
												</td>
												<td>
													&nbsp;&nbsp;&nbsp;
												</td>
												<td colspan="3">
													<html:text styleClass="selNum" property="com_cantidadconsumo" maxlength="8" size="5" onkeyup="isFloat(this, 8, 2);" onblur="isFloat(this, 8, 2);"
														onfocus="this.select()" value="0" />
												</td>
												<td>
													&nbsp;&nbsp;&nbsp;
												</td>
												<td colspan="3" class="view_item">
													<bean:message key="6006" />
												</td>
												<td>
													&nbsp;&nbsp;&nbsp;
												</td>
												<td colspan="3">
													<html:text styleClass="selNum" property="com_costocombustible" maxlength="10" size="10" onkeyup="isFloat(this, 10, 2);" onblur="isFloat(this, 10, 2);"
														onfocus="this.select()" value="0" />
												</td>
											</tr>
											<tr>
												<td colspan="19" class="view_item" align="center">
													<br>
												</td>
											</tr>
											<tr>
												<TD colspan="19" align="center">
													<INPUT type="button" onClick="cargarCombustible()" class="sbttn" value="<bean:message key="3520" />">
												</TD>
											</tr>
											<tr>
												<td colspan="19" class="view_item" align="center">
													<br>
												</td>
											</tr>
											<tr>
												<td colspan="19" class="view_item" align="center">
													<bean:message key="3560" />
												</td>
											</tr>
										</table>
										<table align="center">
											<tr>
												<td colspan="3" class="view_item">
													<bean:message key="5069" />
												</td>
												<td>
													&nbsp;&nbsp;&nbsp;
												</td>
												<td colspan="3">
													<html:text styleClass="selNum" property="resultado_rendimientoS" maxlength="10" size="10" onkeyup="isFloat(this, 10, 2);"
														onblur="isFloat(this, 10, 2);" onfocus="this.select()" disabled="true" />
												</td>
												<td>
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												</td>
												<td colspan="3" class="view_item">
													<bean:message key="5071" />
												</td>
												<td>
													&nbsp;&nbsp;&nbsp;
												</td>
												<td colspan="3">
													<html:text styleClass="selNum" property="resultado_costoDistanciaS" maxlength="10" size="10" onkeyup="isFloat(this, 10, 2);"
														onblur="isFloat(this, 10, 2);" onfocus="this.select()" disabled="true" />
												</td>
												<td>
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												</td>
												<td colspan="3" class="view_item">
													<bean:message key="5072" />
												</td>
												<td>
													&nbsp;&nbsp;&nbsp;
												</td>
												<td colspan="3">
													<html:text styleClass="selNum" property="resultado_costoDiaS" maxlength="10" size="10" onkeyup="isFloat(this, 10, 2);" onblur="isFloat(this, 10, 2);"
														onfocus="this.select()" disabled="true" />
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td colspan="10">&nbsp;
										
									</td>
								</tr>
								<tr>
									<td colspan="10">&nbsp;
										
									</td>
								</tr>
								<tr>
									<td colspan="10">&nbsp;
										
									</td>
								</tr>
								<tr>
									<td colspan="10">&nbsp;
										
									</td>
								</tr>
								<tr>
									<td colspan="9">
										<table align="center" width="100%">
											<TR align="center">
												<TD rowspan="2" class="tdNameOption" align="center" style="border: 1px solid #0066D3">
													<bean:message key="5063" />
												</TD>
												<TD rowspan="2" class="tdNameOption" align="center" style="border: 1px solid #0066D3">
													<bean:message key="6008" />
												</TD>
												<TD rowspan="2" class="tdNameOption" align="center" style="border: 1px solid #0066D3">
													<bean:message key="5069" />
												</TD>
												<TD COLSPAN="2" class="tdNameOption" align="center" style="border: 1px solid #0066D3" width="186">
													<bean:message key="5070" />
												</TD>
												<TD rowspan="2" class="tdNameOption" align="center" style="border: 1px solid #0066D3" align="center" width="13">
													<bean:message key="global.acciones" />
												</td>
											</TR>
											<TR align="center">
												<TD BGCOLOR="#ffa8a8" ALIGN="center" class="tdNameOption" style="border: 1px solid #0066D3">
													<bean:message key="5071" />
												</TD>
												<TD BGCOLOR="#ffa8a8" ALIGN="center" class="tdNameOption" style="border: 1px solid #0066D3">
													<bean:message key="5072" />
												</TD>
											</TR>
											<%
												x = 0;
													float totalDistancia = 0;
													float totalDia = 0;
													float rendimiento = 0;
													float costoDistancia = 0;
													float costoDia = 0;
													float gastoCombustibleMensual=0;
													BigDecimal lecturafin=BigDecimal.ZERO;
													BigDecimal lecturafin2=BigDecimal.ZERO;
											%>
											<logic:iterate indexId="indx" id="combustible" name="COMBUSTIBLEVEHICULO" type="com.servidoctor.sdcars.model.Combustible">
												<%
													rendimiento = ( Float.parseFloat( combustible.getCom_lecturafin().toString() ) - Float.parseFloat( combustible
																			.getCom_lecturaini().toString() ) )
																			/ Float.parseFloat( combustible.getCom_cantidadconsumo().toString() );
																	costoDistancia = ( Float.parseFloat( combustible.getCom_costocombustible().toString() ) / Float.parseFloat( combustible
																			.getCom_cantidadconsumo().toString() ) )
																			/ rendimiento;
																	costoDia = Float.parseFloat( combustible.getCom_costocombustible().toString() )
																			/ ( ManejoFechas.restaFechas( combustible.getCom_fechaini().toString(), combustible.getCom_fechafin().toString() ) );
																	totalDia += costoDia;
																	totalDistancia += costoDistancia;

																	rendimiento = java.lang.Math.round( rendimiento * 100 );
																	rendimiento /= 100;

																	costoDistancia = java.lang.Math.round( costoDistancia * 100 );
																	costoDistancia /= 100;

																	costoDia = java.lang.Math.round( costoDia * 100 );
																	costoDia /= 100;
																	
																	lecturafin=combustible.getCom_lecturafin();
																	
																	if (lecturafin.compareTo(lecturafin2)==1){
																		gastoCombustibleMensual=costoDia;
																		lecturafin2=lecturafin;
																	}
																	
												%>
												<TR>
													<TD class="view_item" align="center"><%=x + 1%></TD>
													<TD class="view_desc" align="center"><%=ManejoFechas.FormateoFecha( combustible.getCom_fechafin().toString() )%></TD>
													<TD class="view_desc" align="center"><%=rendimiento%></TD>
													<TD class="view_desc" align="center"><%=costoDistancia%></TD>
													<TD class="view_desc" align="center"><%=costoDia%></TD>
													<td align="center">
														<!--  <IMG border="0" onClick="edit_combustible('<%=x%>')" src="<%=request.getContextPath()%>/images/editar.gif"
															alt="<bean:message key="138"/>" width="16" height="16" style="cursor: hand">-->
														<IMG border="0" onClick="remove_combustible('<%=x%>','<%=x + 1%>')" src="<%=request.getContextPath()%>/images/eliminar.gif"
															alt="<bean:message key="139"/>" width="16" height="16" style="cursor: hand">
													</td>
												</TR>
												<%
													x++;
												%>
											</logic:iterate>
											<tr>
												<TD align="center" colspan="9">&nbsp;
													
												</TD>
											</tr>
											<%
												if ( x > 0 ) {
														totalDistancia = java.lang.Math.round( totalDistancia * 100 );
														totalDistancia /= 100;

														totalDia = java.lang.Math.round( totalDia * 100 );
														totalDia /= 100;
														
														
											%>
											<!--  <tr>
												<td class="view_item">
													<bean:message key="6026" />
												</td>
												<td colspan="2"></td>
												<td class="view_desc" align="center"><%=totalDistancia%></td>
												<td class="view_desc" align="center"><%=totalDia%></td>-->
												<%
													//Hay q convertir los valores a String o si no la etiqueta no los soporta
															TotalDistancia = String.valueOf( totalDistancia );
															TotalDia = String.valueOf( totalDia );
												%>
												<!-- Esto es para poder acceder al resumen desde el pop-up-->
												<!--<html:hidden property="TotalDistancia" value="<%=TotalDistancia%>" />
												<html:hidden property="TotalDia" value="<%=TotalDia%>" />
												<td></td>
											</tr> -->
											<%
												}
											%>
										</table>
									</td>
								</tr>
								<tr>
									<td colspan="10" class="view_item">
										<bean:message key="7439" arg0='<%=res.getMessage( "parametro_adicion_combustible" )%>' />
									</td>
								</tr>
								<tr>
									<TD align="center" colspan="9">&nbsp;
										
									</TD>
								</tr>
								<tr>
									<TD align="center" colspan="9">
										<br>
										<br>
									</TD>
								</tr>
								<tr>
									<td colspan="9">
										<table align="center" width="50%">
											<TR>
												<TD colspan="3" align="center" class="tdNameOption" style="border: 1px solid #0066D3">
													<bean:message key="3558" />
												</TD>
											</TR>
											<TR>
												<TD align="center" class="tdNameOption" style="border: 1px solid #0066D3">
													<bean:message key="6019" />
												</TD>
												<TD align="center" class="tdNameOption" style="border: 1px solid #0066D3">
													<bean:message key="6020" />
												</TD>
												<TD align="center" class="tdNameOption" style="border: 1px solid #0066D3">
													<bean:message key="6021" />
												</TD>
											</TR>
											<%
												float q1 = Float.parseFloat( totalMensualGM );
													float q3 = Float.parseFloat( totalAnualGM );
													float q6 = Float.parseFloat( totalMensualGA );
													float q4 = Float.parseFloat( totalAnualGA );
													float q2 = Float.parseFloat( totalMensualGNA );
													float q5 = Float.parseFloat( totalAnualGNA );
											%>
											<TR>
												<TD align="left" class="view_item" style="border: 1px solid #0066D3">
													<bean:message key="6184" />
												</TD>
												<TD class="view_item" align="center"><%=java.lang.Math.round( q1 )%></TD>
												<TD class="view_item" align="center"><%=java.lang.Math.round( q3 )%></TD>
											</TR>
											<TR>
												<TD align="left" class="view_item" style="border: 1px solid #0066D3">
													<bean:message key="6185" />
												</TD>
												<TD class="view_item" align="center"><%=java.lang.Math.round( q6 )%></TD>
												<TD class="view_item" align="center"><%=java.lang.Math.round( q4 )%></TD>
											</TR>
											<TR>
												<TD align="left" class="view_item" style="border: 1px solid #0066D3">
													<bean:message key="6186" />
												</TD>
												<TD class="view_item" align="center"><%=java.lang.Math.round( q2 )%></TD>
												<TD class="view_item" align="center"><%=java.lang.Math.round( q5 )%></TD>
											</TR>
											<TR>
												<TD align="left" class="view_item" style="border: 1px solid #0066D3"><bean:message key="3501" /></TD>
												<%%>
												<TD class="view_item" align="center"><%=String.valueOf(java.lang.Math.round(gastoCombustibleMensual * 30))%></TD>
												<TD class="view_item" align="center"><%=String.valueOf(java.lang.Math.round(gastoCombustibleMensual * 30 * 12))%></TD>
											</TR>
											<TR>
												<TD align="left" class="view_item" style="border: 1px solid #0066D3"><bean:message key="6026" /></TD>
												<TD class="view_item" align="center"><%=String.valueOf(java.lang.Math.round((gastoCombustibleMensual * 30) + q1 + q2 + q6))%></TD>
												<TD class="view_item" align="center"><%=String.valueOf(java.lang.Math.round((gastoCombustibleMensual * 30 * 12) + q3 + q4 + q5))%></TD>
											</TR>
										</table>
									</td>
								</tr>
							</table>
						</TD>
					</tr>
					<tr>
						<td colspan="3">
							<table height="30" cellpadding="0" cellspacing="0" border="0" width="100%">
								<tr>
									<td align="center">
									<hr>
									</td>
								</tr>
								<tr align="center" valign="middle">
									<td><INPUT type="button" onClick="enviarD('<%=request.getContextPath()%>/DatosVehiculo/saveEditControl.do')" class="sbttn" value="<bean:message key="136"/>"></td>
								</tr>
								<tr>
									<td>
										<div align="right" class="imprimir"><img alt="<bean:message key="global.imprimiralt"/>" src="<%=request.getContextPath()%>/images/print.gif" border="0" height="22" width="20">&nbsp;<a
										href="javascript: self.print();"><b><bean:message key="global.imprimir" /></b></a></div>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
<script>
tab_charge('editvehiculo','cars');
</script>
</html:form>
<script>
	habilitar();
</script>



