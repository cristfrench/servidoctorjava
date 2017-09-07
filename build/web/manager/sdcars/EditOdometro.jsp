<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page
	import="org.apache.struts.util.MessageResources,java.math.BigDecimal,com.servidoctor.constantes.IConstantes,com.servidoctor.util.classes.ManejoFechas,com.servidoctor.parametros.model.RevisionesVehiculo"%>
<%@ page import="com.servidoctor.sdcars.model.GrupoUsuarioSegmentacion"%>
<%@ page import="com.servidoctor.sdcars.model.LogoComprador"%>
<%@ page import="com.servidoctor.sdcars.dao.GrupoUsuarioSegmentacionDAO"%>
<%@ page import="com.servidoctor.sdcars.dao.LogoCompradorDAO"%>
<%@ page import="com.servidoctor.seguridad.model.UsuarioCar"%>
<%@ page import="org.apache.struts.util.MessageResources,com.servidoctor.sdcars.model.Vehiculos,com.servidoctor.sdcars.dao.VehiculosDAO,com.servidoctor.seguridad.model.UsuarioCar,java.util.List"%>
<%@ page import="com.servidoctor.sdcars.model.GrupoUsuarioSegmentacion"%>
<%@ page import="com.servidoctor.parametros.model.RevisionesVehiculo"%>
<%@ page import="com.servidoctor.parametros.dao.RevisionesVehiculoDAO"%>
<%@ page import="com.servidoctor.parametros.model.RevisionesVehiculo"%>
<%@ page import="com.servidoctor.parametros.dao.RevisionesVehiculoDAO"%>
<%@ page import="com.servidoctor.sdcars.controller.VehiculosCompletoForm"%>
<%@ page import="com.servidoctor.sdcars.model.MantenimientoGeneral"%>
<%@ page import="com.servidoctor.sdcars.dao.MantenimientoGeneralDAO"%>
<%@ page import="org.apache.struts.util.MessageResources,com.servidoctor.sdcars.model.Vehiculos,com.servidoctor.sdcars.dao.VehiculosDAO,com.servidoctor.seguridad.model.UsuarioCar,java.util.List"%>


<script language="JavaScript" src="../../script/fechas.js"> </script>
<script language="JavaScript">

function verificarValorOdometro(){
	var t=confirm('Usted ha ingresado la siguiente información:\n\n Distancia: '+document.forms[0].vehi_kmsact.value +'    Fecha: '+document.forms[0].AnoO.value+document.forms[0].MesO.value+document.forms[0].DiaO.value +'. \n\nPresione "Aceptar" si su información es correcta, de lo contrario presione "Cancelar" para modificar la información');
	if (t){
		enviarDatos('<%=request.getContextPath()%>/DatosVehiculo/saveOdometro.do');
	}else{
		document.forms[0].vehi_kmsact.focus();
		return false;
		}
}
		function llegadaA1(dato){
		if (dato==1){
			document.forms[0].action = '<%=request.getContextPath()%>/DatosVehiculo/saveOdometro.do';
			document.forms[0].submit();
		}
		if (dato==2){
			//document.forms[0].vehi_kmsact.value='';
			document.forms[0].AnoO.focus();
			/*document.forms[0].AnoO.options[0].selected=true;
			document.forms[0].MesO.options[0].selected=true;
			document.forms[0].DiaO.options[0].selected=true;*/
			document.forms[0].vehi_kmsact.focus();
			return false;
		}
		
		
	}

		function llegadaA2(dato){
		if (dato==1){
			document.forms[0].action = '<%=request.getContextPath()%>/DatosVehiculo/saveOdometro.do';
			document.forms[0].submit();
		}
		if (dato==2){
			//document.forms[0].vehi_kmsact.value='';
			document.forms[0].AnoO.focus();
			/*document.forms[0].AnoO.options[0].selected=true;
			document.forms[0].MesO.options[0].selected=true;
			document.forms[0].DiaO.options[0].selected=true;*/
			document.forms[0].vehi_kmsact.focus();
			return false;
		}
		
		
	}
/*function enviarD(ruta){

      if(document.forms[0].pveh_indpais2.value=='' || document.forms[0].pveh_indpais2.value=='0'){
         alert('<bean:message key="5016" />');
         document.forms[0].pveh_indpais2.focus();
         return false;
      }

      if(!mail(document.forms[0].pveh_mail)){
         alert('<bean:message key="5019" />');
         document.forms[0].pveh_mail.focus();
         return false;
      }      

	document.forms[0].action = ruta;
	document.forms[0].submit();
}*/

function enviarDatos(ruta){
// *************************************************ODOMETRO**************************************************************
		var odometroesCero= 0;
      	//Validation about basic info
			
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
			
     
	      	if(document.forms[0].vehi_kmsact.value==''){
	        	alert('<bean:message key="5010" />');
	         	document.forms[0].vehi_kmsact.focus();
	         	return false;
	      	}
 
	      	
	      	
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
				BigDecimal ultimaDistancia= ManejoFechas.getUltimaDistancia(vehiculosC,request,mantenimientoGeneral,revisionVehiculoA);
				List revisionesVehiculo1 = (List) request.getSession().getAttribute("REVISIONES");
	      	%>
			
			//variables which could be considered
	      	var Revisar=0;UltimaFechaTotal=0;
	      	var UltimaFechaControlBD0=0;
	      	var UltimaFechaControlA=0;
			var UltimaDistanciaControlBD0=0;
			var DefinitivaFechaControlBD0=0;
			var DefinitivaDistanciaControlBD0=0;
			var UltimaFechaControl0=0;
			var UltimaDistanciaControl0=0;
			var DiferenciaFecha0=0;
			whoi='';
      		var DiferenciaCero=0;var DiferenciaOdometro=0;
			dobleRegistroOdometroCero=0;

			
		//Mistakes about doble 0'Odometers record
     		var ceroNoRevisiones=0;
     		var ceroNoOdometro=0;
  
			//Odometer cases  
      		
			//Database variables
      		OdometroCeroBase =<%=vehiculosC.getVehi_fechaencero()%>;			
			FechaOdometroBase=parseInt(<%=vehiculosC.getVehi_fechaodometro() %>);		
			DistanciaOdometroBase=parseInt(<%=vehiculosC.getVehi_kmsact() %>);	
			FechaCompra=parseInt(<%=vehiculosC.getVehi_feccomp() %>);		
			UltimaFechaTotal=<%=ultimaFecha.intValue()%>
			UltimaDistanciaTotal=<%=ultimaDistancia.intValue()%>
			//Form variables
			FechaOdometroControl=''+(document.getElementById("AnoO").value)+(document.getElementById("MesO").value)+(document.getElementById("DiaO").value);
			FechaOdometroControl=parseInt(FechaOdometroControl);
			FechaOdometroControlA=FechaOdometroControl;		
			DistanciaOdometroControl=parseInt(document.forms[0].vehi_kmsact.value);
			if (document.getElementById("AnoCeroO").value != null || document.getElementById("AnoCeroO").value != 0){
				FechaCeroControl=''+(document.getElementById("AnoCeroO").value)+(document.getElementById("MesCeroO").value)+(document.getElementById("DiaCeroO").value);
			}

			if (OdometroCeroBase > 0){
				FechaCeroControl=OdometroCeroBase;
			}
			//UltimaDistanciaControlMan=document.getElementById("mant_control_kms").value;
			//UltimaFechaControlMan=document.getElementById("mant_control_fec").value;
			
			//Variables which could be considered
			var miMantenimiento = new Array(); 
			var miOdometro = new Array(); 
			var miRevisiones = new Array();			
			DiferenciaOdometro=FechaOdometroControl-FechaOdometroBase;
			var DiferenciaFechaFinal0=10000000;
			DiferenciaInferiorFinal=90000000;	
			
			/// Verify whether there's a blocked revision
			var FechaTopeBloqueo=0;
			var DistanciaTopeBloqueo=0;
			var existenBloqueados=0;
			<% 
				int zj = 0; 
				while (zj < revisionVehiculoA.size()) {%>
					FechaControlBase=parseInt(<%=((RevisionesVehiculo)revisionVehiculoA.get(zj)).getRveh_control_fec() %>); 
					DistanciaControlBase=parseInt(<%=((RevisionesVehiculo)revisionVehiculoA.get(zj)).getRveh_control_kms() %>);
					Bloqueado=parseInt(<%=((RevisionesVehiculo)revisionVehiculoA.get(zj)).getRveh_bloqueado() %>);
					codigo=parseInt(<%=((RevisionesVehiculo)revisionVehiculoA.get(zj)).getRveh_cod().intValue() %>);
					if (Bloqueado==2){
						FechaTopeBloqueo=FechaControlBase;
						DistanciaTopeBloqueo=DistanciaControlBase;
						existenBloqueados=1;
						who='w'+codigo;
						
					}
					
				<% zj++;
				} %>
			

				if (OdometroCeroBase!=0){
					if (FechaOdometroControl<FechaCeroControl){
						alert('<bean:message key="5194" />'+FechaCeroControl+'<bean:message key="5195" />');
						return false;					
					}
				}


			if (existenBloqueados==1){
				if (FechaOdometroControl<=FechaTopeBloqueo && FechaOdometroControl>=FechaOdometroControl){
					//These referential dates are taken like Initial date to find the closer dates to the date and distance you are registering
						DefinitivaFechaControlBD0=FechaTopeBloqueo;
						DefinitivaDistanciaControlBD0=DistanciaTopeBloqueo; 
						AnteriorFechaControlBD0=FechaCeroControl;
						AnteriorDistanciaControlBD0=0;
						DiferenciaFechaFinal0=FechaTopeBloqueo-FechaOdometroControl; 
						DiferenciaInferiorFinal=FechaOdometroControl-FechaCeroControl;
						whoi='o0';
				}
			}else{
			
			
			
			
			
			
			
			
			//CASE ODOMETER
			//Adding data when Odometer has passed by 0 

			
			if (document.getElementById('hcero').style.display==''){
				if (document.getElementById("AnoCeroO").value == null || document.getElementById("AnoCeroO").value == 0 || document.getElementById("MesCeroO").value == null || document.getElementById("MesCeroO").value == 0 || document.getElementById("DiaCeroO").value == null || document.getElementById("DiaCeroO").value == 0){
					alert('<bean:message key="5124"/>');
					return false;
				}else{
					document.forms[0].vehi_cerobasica.value=1;
					FechaCeroControl=''+(document.getElementById("AnoCeroO").value)+(document.getElementById("MesCeroO").value)+(document.getElementById("DiaCeroO").value);
					FechaCeroControl=parseInt(FechaCeroControl);
					if (FechaOdometroControl<FechaCeroControl ){
						DefinitivaFechaControlBD0=FechaOdometroBase;
						DefinitivaDistanciaControlBD0=DistanciaOdometroBase; 
						AnteriorFechaControlBD0=FechaCeroControl;
						AnteriorDistanciaControlBD0=0;
						DiferenciaFechaFinal0=90000000; 
						DiferenciaInferiorFinal=FechaOdometroControl-FechaCeroControl;						 
					} else{
						if (FechaOdometroControl>FechaCeroControl ){
							DefinitivaFechaControlBD0=90000000;
							DefinitivaDistanciaControlBD0=90000000; 
							AnteriorFechaControlBD0=FechaCeroControl;
							AnteriorDistanciaControlBD0=0;
							DiferenciaFechaFinal0=90000000; 
							DiferenciaInferiorFinal=FechaOdometroControl-FechaCeroControl;
						}
					}
					Revisar=1; 
				} 
			}else{ 
				//Adding data when Odometer doesn't pass by 0
				document.forms[0].vehi_cerobasica.value=0;
				if (FechaOdometroBase<FechaOdometroControl){	
					
					DefinitivaFechaControlBD0=90000000;
					DefinitivaDistanciaControlBD0=90000000;
					AnteriorFechaControlBD0=FechaCompra;
					AnteriorDistanciaControlBD0=0;
					DiferenciaFechaFinal0=FechaOdometroControl-FechaOdometroBase;
					DiferenciaInferiorFinal=FechaOdometroControl-FechaCompra;
				}else{
					if (FechaOdometroBase>FechaOdometroControl){
						DefinitivaFechaControlBD0=FechaOdometroBase;
						DefinitivaDistanciaControlBD0=DistanciaOdometroBase;
						AnteriorFechaControlBD0=FechaCompra;
						AnteriorDistanciaControlBD0=0;
						DiferenciaFechaFinal0=FechaOdometroBase-FechaOdometroControl;
						DiferenciaInferiorFinal=FechaOdometroControl-FechaCompra;
					}else{
						if (DistanciaOdometroBase!=DistanciaOdometroControl){
							alert('<bean:message key="5178" />');
			      			return false;				
			      		}
					}
				}
				Revisar=0;
			}
			
			who='o';whoi='o';
			var option=-2;
			//alert('TA= '+AnteriorFechaControlBD0+' DA= '+AnteriorDistanciaControlBD0+' TB= '+FechaOdometroControlA+' DB= '+DistanciaOdometroControl+' TC= '+DefinitivaFechaControlBD0+' DC= '+DefinitivaDistanciaControlBD0);
			
			//CASE MAINTENANCE		
			
			FechaManBase=parseInt(<%=mantenimientoGeneral.getMant_control_fec() %>); 
			DistanciaManBase=parseInt(<%=mantenimientoGeneral.getMant_control_kms() %>);
			Bloqueado=parseInt(<%=mantenimientoGeneral.getMant_bloqueado() %>);
			
			if (Bloqueado==0){
				if (FechaManBase!=0){
					option=-1;
				}
				
				
				DiferenciaFecha0=FechaManBase-FechaOdometroControl;		
				DiferenciaFecha1=FechaOdometroControl-FechaManBase;
				if (DiferenciaFecha0<=DiferenciaFechaFinal0 && DiferenciaFecha0>0){
					DiferenciaFechaFinal0=DiferenciaFecha0;
					DefinitivaFechaControlBD0=FechaOdometroBase;
					DefinitivaDistanciaControlBD0=DistanciaOdometroBase;
					
					who='m';
				}
				if (DiferenciaFecha1<=DiferenciaInferiorFinal && DiferenciaFecha1>0){
					DiferenciaInferiorFinal=DiferenciaFecha1;
					AnteriorFechaControlBD0=FechaManBase;
					AnteriorDistanciaControlBD0=DistanciaManBase;
					whoi='m';
				}
			}		
			
			}//fin de ExisteBloqueos (Cuando no hay revisiones bloqueadas) Se exceptuan las revisiones.	
			
			//alert('TA= '+AnteriorFechaControlBD0+' DA= '+AnteriorDistanciaControlBD0+' TB= '+FechaOdometroControlA+' DB= '+DistanciaOdometroControl+' TC= '+DefinitivaFechaControlBD0+' DC= '+DefinitivaDistanciaControlBD0);
			prueba=0;
			//alert(who);
			//CASE REVISION
			if (Revisar==0){
				<% 
				int z0 = 0; 
				while (z0 < revisionVehiculoA.size()) {%>
					FechaControlBase=parseInt(<%=((RevisionesVehiculo)revisionVehiculoA.get(z0)).getRveh_control_fec() %>); 
					DistanciaControlBase=parseInt(<%=((RevisionesVehiculo)revisionVehiculoA.get(z0)).getRveh_control_kms() %>);
					Bloqueado=parseInt(<%=((RevisionesVehiculo)revisionVehiculoA.get(z0)).getRveh_bloqueado() %>);
					codigo=parseInt(<%=((RevisionesVehiculo)revisionVehiculoA.get(z0)).getRveh_cod().intValue() %>);
					if (Bloqueado!=1){
						if (FechaControlBase!=0){
							option=-1;
						}
						
						
						DiferenciaFecha0=FechaControlBase-FechaOdometroControl; 
						DiferenciaFecha1=0-DiferenciaFecha0;
						
						if (DiferenciaFecha0<=DiferenciaFechaFinal0 && DiferenciaFecha0>0){
							DiferenciaFechaFinal0=DiferenciaFecha0;
							DefinitivaFechaControlBD0=FechaControlBase;
							DefinitivaDistanciaControlBD0=DistanciaControlBase;
							who='r'+codigo;	
						}
						if (DiferenciaFecha1<=DiferenciaInferiorFinal && DiferenciaFecha1>0){
							DiferenciaInferiorFinal=DiferenciaFecha1;
							AnteriorFechaControlBD0=FechaControlBase;
							AnteriorDistanciaControlBD0=DistanciaControlBase;
							whoi='r'+codigo;	
						}
						//alert(prueba+'. DF2='+DiferenciaFecha0+' DF1='+DiferenciaFecha1+' / DFF2='+DiferenciaFechaFinal0+' DFF1='+DiferenciaInferiorFinal+' / FC='+FechaControlBase+' DC= '+DistanciaControlBase+' / TA= '+AnteriorFechaControlBD0+' DA= '+AnteriorDistanciaControlBD0+' TB= '+FechaOdometroControlA+' DB= '+DistanciaOdometroControl+' TC= '+DefinitivaFechaControlBD0+' DC= '+DefinitivaDistanciaControlBD0);
						prueba=prueba+1;
					}
				<% z0++;
				} %>

			}
						
			//alert(who);
			//alert('1. TA= '+AnteriorFechaControlBD0+' DA= '+AnteriorDistanciaControlBD0+' TB= '+FechaOdometroControlA+' DB= '+DistanciaOdometroControl+' TC= '+DefinitivaFechaControlBD0+' DC= '+DefinitivaDistanciaControlBD0);
			
			//LAST VALIDATIONS
      		// Validation adding odometer=0
	      	if (document.getElementById('hcero').style.display==''){
				
				if(FechaOdometroBase > FechaCeroControl){
					
					alert('<bean:message key="5126" /> '+DistanciaOdometroBase+' <bean:message key="5127" /> '+FechaOdometroBase+' <bean:message key="5128" /> '+FechaCeroControl+' <bean:message key="5129" /> ');
					document.forms[0].DiaCeroO.focus();
			  	 	return false;
				}
				if( FechaCeroControl > FechaOdometroControl){
					alert('<bean:message key="5126" /> '+DistanciaOdometroControl+' <bean:message key="5127" /> '+FechaOdometroControl+' <bean:message key="5128" /> '+FechaCeroControl+' <bean:message key="5129" /> ');
					
					document.forms[0].DiaCeroO.focus();
			  	 	return false;
				}
			}
      		
      		//alert('2. TA= '+AnteriorFechaControlBD0+' DA= '+AnteriorDistanciaControlBD0+' TB= '+FechaOdometroControlA+' DB= '+DistanciaOdometroControl+' TC= '+DefinitivaFechaControlBD0+' DC= '+DefinitivaDistanciaControlBD0);
      		
      		
      		
      		//Final Validation about closer previous date
      		if (AnteriorFechaControlBD0 == FechaOdometroControlA){
	      		if (AnteriorDistanciaControlBD0 != DistanciaOdometroControl){ 
	      			option=0;
	      			
		      	}
      		}
     		//Final Validation about closer posterior date
      		if (DefinitivaFechaControlBD0 == FechaOdometroControlA){
	      		if (DefinitivaDistanciaControlBD0 != DistanciaOdometroControl){ 
	      			option=0;
	      	  	}
      		}


    		var contadorD=0;
      		if (AnteriorFechaControlBD0 < FechaOdometroControl){
      			if (AnteriorDistanciaControlBD0 > DistanciaOdometroControl){ 
      				if (DefinitivaFechaControlBD0==90000000 && DefinitivaDistanciaControlBD0==90000000 ){
      					option=1;//odometro cero
      				}else{
      					contadorD=contadorD+1;
      					

      				}
      			}
      		}
 			//alert(contadorD+'3. TB= '+FechaOdometroControl+' DB= '+DistanciaOdometroControl+' TC= '+DefinitivaFechaControlBD0+' DC= '+DefinitivaDistanciaControlBD0);
 			if (DefinitivaFechaControlBD0 > FechaOdometroControl){
      			if (DefinitivaDistanciaControlBD0 < DistanciaOdometroControl){ 
      				
      					contadorD=contadorD+1;     				
      				
      			}
      		}
      		if (contadorD==1){
      			option=2;//error 1 fecha posterior
      		}
      		if (contadorD==2){
      			option=3;//error 2 fechas posteriores
      		}
      		
      		if (option==0){
      			alert('<bean:message key="5178" />');
	      		return false;	    
      		}
      		if (option==2 || option==3){
	      		var texto='';
	      		switch (who){
					case 'm':texto='<bean:message key="5177"/>';quien=0;break;
					case 'o':texto='<bean:message key="5176"/>';quien=1;break;
					
					default: 
						if (who.length>0) {
							var numRev=who.substring(1,who.length);
							quien=2;
							
							<%	 
							int c1 = 0; 
							while (c1 < revisionVehiculoA.size()) {%>
							if (<%=c1%>==numRev-1){
								
								texto='<%=((RevisionesVehiculo) revisionVehiculoA.get(c1)).getRveh_cod()%>';
								texto=texto+' - ';
								texto=texto+'<%=((RevisionesVehiculo) revisionVehiculoA.get(c1)).getRveh_actividad()%>';
								//texto=texto.substring(0,35);
							}	
							
							<%c1++;}%>
						}
				}
				var texto2='';
				switch (whoi){
					case 'm':texto2='<bean:message key="5177"/>';quien=0;break;
					case 'o':texto2='<bean:message key="5176"/>';quien=1;break;
					case 'o0':texto2='<bean:message key="5193"/>';quien=1;break;
					default: 
						if (whoi.length>0) {
							var numRevA=whoi.substring(1,whoi.length);
							quien=2;
							
							<%	 
							int d1 = 0; 
							while (d1 < revisionVehiculoA.size()) {%>
							if (<%=d1%>==numRevA-1){
								
								texto2='<%=((RevisionesVehiculo) revisionVehiculoA.get(d1)).getRveh_cod()%>';
								texto2=texto2+' - ';
								texto2=texto2+'<%=((RevisionesVehiculo) revisionVehiculoA.get(d1)).getRveh_actividad()%>';
								//texto2=texto2.substring(0,35);
							}	
							
							<%d1++;}%>
						}
				}
				
				if (option==2){//+'&revisionX='+revisionX
	      			window.open('<%=request.getContextPath()%>/manager/sdcars/popup_vehiculos/Popup_control_odometro_mas_reciente1.jsp?texto='+texto+'&texto2='+texto2+'&AnteriorFechaControlBD0='+AnteriorFechaControlBD0+'&AnteriorDistanciaControlBD0='+AnteriorDistanciaControlBD0+'&DefinitivaFechaControlBD0='+DefinitivaFechaControlBD0+'&DefinitivaDistanciaControlBD0='+DefinitivaDistanciaControlBD0+'&FechaOdometroControl='+FechaOdometroControl+'&DistanciaOdometroControl='+DistanciaOdometroControl+'&who='+numRev+'&whoi='+numRevA,'Paso de odómetro en cero','scrollbars=yes, top=100, left=200, width=650, height=480');
	      			return false;
	      		}
	      		if (option==3){//+'&revisionX='+revisionX
	      			window.open('<%=request.getContextPath()%>/manager/sdcars/popup_vehiculos/Popup_control_odometro_mas_reciente2.jsp?texto='+texto+'&texto2='+texto2+'&AnteriorFechaControlBD0='+AnteriorFechaControlBD0+'&AnteriorDistanciaControlBD0='+AnteriorDistanciaControlBD0+'&DefinitivaFechaControlBD0='+DefinitivaFechaControlBD0+'&DefinitivaDistanciaControlBD0='+DefinitivaDistanciaControlBD0+'&UltimaFechaControl='+UltimaFechaControl+'&UltimaDistanciaControl='+UltimaDistanciaControl+'&who='+numRev+'&whoi='+numRevA,'Paso de odómetro en cero','scrollbars=yes, top=100, left=200, width=650, height=480');
	      			return false;
	      		}
			}

 			if (option==1){
				if (document.getElementById('vehi_fechaencero').value!=0){
   					odometroesCero=1;	
   					document.getElementById('revisorOdometroCero').value=1;
   				}
   				if (odometroesCero==0){//No se ha activado la peticion de ingresar la fecha en cero
      				switch (who){
						case 'm':texto='Mantenimiento en el sistema';break;
						case 'o':texto='Odometro en el sistema';break;
						default: 
							if (who.length>0) {
								var numRev=who.substring(1,who.length);
								<%	 
								int n0 = 0; 
								while (n0 < revisionVehiculoA.size()) {%>
								if (numRev==<%=n0%>){
									texto='<%=((RevisionesVehiculo) revisionVehiculoA.get(n0)).getRveh_cod()%>';
									texto=texto+' - ';
									texto=texto+'<%=((RevisionesVehiculo) revisionVehiculoA.get(n0)).getRveh_actividad()%>';
								}	
								<%n0++;}%>
							}
					}
      				var textocero='<bean:message key="5161"/><br><br>';
      				textocero=textocero+'<table width="100%" border="1" cellpadding="0" cellspacing="0"><tr><td>&nbsp;</td><td><bean:message key="5163"/></td>';
      				textocero=textocero+'<td><bean:message key="5164"/></td></tr><tr><td><bean:message key="5162"/></td><td>'+FechaOdometroControlA+'</td><td>'+DistanciaOdometroControl+'</td></tr></table><br />';
      				textocero=textocero+'<bean:message key="5138"/><br>';
      				textocero=textocero+'<table width="100%" border="1" cellpadding="0" cellspacing="0"><tr><td>&nbsp;</td><td><bean:message key="5163"/></td>';
      				textocero=textocero+'<td><bean:message key="5164"/></td></tr><tr><td>'+texto+'</td><td>'+DefinitivaFechaControlBD0+'</td><td>'+DefinitivaDistanciaControlBD0+'</td></tr></table>';
      				textocero=textocero+'<br><bean:message key="5139"/>';
      				textocero=textocero+'<br><br><bean:message key="5140"/>';
					
					if(hay_popup_abierto())
						return false;						
					window.open('<%=request.getContextPath()%>/manager/sdcars/popup_vehiculos/Popup_odometro_cero.jsp?texto='+texto+'&AnteriorFechaControlBD0='+AnteriorFechaControlBD0+'&AnteriorDistanciaControlBD0='+AnteriorDistanciaControlBD0+'&FechaOdometroControlA='+FechaOdometroControlA+'&DistanciaOdometroControl='+DistanciaOdometroControl,'Paso de odómetro en cero','scrollbars=yes, top=100, left=200, width=650, height=520');
      				return false;
      				

				}else{
					alert('<bean:message key="5185"/>');
					return false;
				}
							
      		}      		
      		
			//Enable/Disable Odometer=0's date 
			if (document.getElementById('vehi_fechaencero').value!=0){
      					odometroesCero=1;	
      					document.getElementById('revisorOdometroCero').value=1;
      					
      		}
			if (document.forms[0].vehi_kmsact.value<<%=vehiculosC.getVehi_kmsact() %> && document.getElementById('hcero').style.display=='none' && option==-2){
				if (odometroesCero==0){//No se ha activado la peticion de ingresar la fecha en cero
	      				switch (who){
							case 'm':texto='<bean:message key="5177"/>';break;
							case 'o':texto='<bean:message key="5176"/>';break;
							default: 
								if (who.length>0) {
									var numRev=who.substring(1,who.length);
									<%	 
									int n1 = 0; 
									while (n1 < revisionVehiculoA.size()) {%>
									if (numRev==<%=n0%>){
										texto='<%=((RevisionesVehiculo) revisionVehiculoA.get(n1)).getRveh_cod()%>';
										texto=texto+' - ';
										texto=texto+'<%=((RevisionesVehiculo) revisionVehiculoA.get(n1)).getRveh_actividad()%>';
									}	
									<%n1++;}%>
								}
						}
	      				
	      				var textocero='<bean:message key="5161"/><br><br>';
	      				textocero=textocero+'<table width="100%" border="1" cellpadding="0" cellspacing="0"><tr><td>&nbsp;</td><td><bean:message key="5163"/></td>';
	      				textocero=textocero+'<td><bean:message key="5164"/></td></tr><tr><td><bean:message key="5162"/></td><td>'+FechaOdometroControlA+'</td><td>'+DistanciaOdometroControl+'</td></tr></table><br />';
	      				textocero=textocero+'<bean:message key="5138"/><br>';
	      				textocero=textocero+'<table width="100%" border="1" cellpadding="0" cellspacing="0"><tr><td>&nbsp;</td><td><bean:message key="5163"/></td>';
	      				textocero=textocero+'<td><bean:message key="5164"/></td></tr><tr><td>'+texto+'</td><td>'+DefinitivaFechaControlBD0+'</td><td>'+DefinitivaDistanciaControlBD0+'</td></tr></table>';
	      				textocero=textocero+'<br><bean:message key="5139"/>';
	      				textocero=textocero+'<br><br><bean:message key="5140"/>';
						if(hay_popup_abierto())
							return false;
	      				window.open('<%=request.getContextPath()%>/manager/sdcars/popup_vehiculos/Popup_odometro_cero.jsp?texto='+texto+'&DefinitivaFechaControlBD0='+DefinitivaFechaControlBD0+'&DefinitivaDistanciaControlBD0='+DefinitivaDistanciaControlBD0+'&FechaOdometroControlA='+FechaOdometroControlA+'&DistanciaOdometroControl='+DistanciaOdometroControl,'dataitem','scrollbars=yes, top=100, left=200, width=650, height=480');      				      				
						return false;
				}else{
					alert('<bean:message key="5121"/>');
					return false;
				}
			}	
			if (document.getElementById('hcero').style.display==''){
				convertirACampo('DiaCeroO', 'MesCeroO', 'AnoCeroO', 'vehi_fechaencero');
			}
      	
      	if (document.getElementById('vehi_fechaencero').value!=0){
      		var fechaenCero=document.getElementById('vehi_fechaencero').value;
      		if (fechaenCero.length==10){
      			var diaCero=document.getElementById('vehi_fechaencero').value.substring(8, 10);
	      		var mesCero=document.getElementById('vehi_fechaencero').value.substring(5, 7);
    	  		var anoCero=document.getElementById('vehi_fechaencero').value.substring(0, 4);
    	  		//alert(anoCero+'-'+mesCero+'-'+diaCero)
      		}
      		if (fechaenCero.length==8){
      			var diaCero=document.getElementById('vehi_fechaencero').value.substring(6, 8);
	      		var mesCero=document.getElementById('vehi_fechaencero').value.substring(4, 6);
    	  		var anoCero=document.getElementById('vehi_fechaencero').value.substring(0, 4);
    	  		//alert(anoCero+'/'+mesCero+'/'+diaCero)
      		}
			document.getElementById('vehi_fechaencero').value=''+anoCero+mesCero+diaCero;
      						
      	}
      				
		convertirACampo('DiaO', 'MesO', 'AnoO', 'vehi_fechaodometro');
		document.forms[0].action = ruta;
		document.forms[0].submit();
	}

function actualizarTabla(){
	document.forms[0].vehi_enero.value=document.forms[0].vehi_promedio.value;
	document.forms[0].vehi_febrero.value=document.forms[0].vehi_promedio.value;
	document.forms[0].vehi_marzo.value=document.forms[0].vehi_promedio.value;
	document.forms[0].vehi_abril.value=document.forms[0].vehi_promedio.value;
	document.forms[0].vehi_mayo.value=document.forms[0].vehi_promedio.value;
	document.forms[0].vehi_junio.value=document.forms[0].vehi_promedio.value;
	document.forms[0].vehi_julio.value=document.forms[0].vehi_promedio.value;
	document.forms[0].vehi_agosto.value=document.forms[0].vehi_promedio.value;
	document.forms[0].vehi_septiembre.value=document.forms[0].vehi_promedio.value;
	document.forms[0].vehi_octubre.value=document.forms[0].vehi_promedio.value;
	document.forms[0].vehi_noviembre.value=document.forms[0].vehi_promedio.value;
	document.forms[0].vehi_diciembre.value=document.forms[0].vehi_promedio.value;
	}
	function llegada(valor){
	if (valor==2){
		document.getElementById('hcero').style.display='none';
		document.forms[0].vehi_cerorevision.value=0;
		document.forms[0].vehi_kmsact.focus();
	}
	if (valor==1){
		document.getElementById('hcero').style.display='';
		document.forms[0].vehi_cerorevision.value=1;
		document.forms[0].DiaCeroO.focus(); 
	}
	return false;
	}

	function mycallbackfunc(v,m,f){
      if(!v){
      		document.getElementById('hcero').style.display='none';
			document.forms[0].vehi_cerorevision.value=0;
			document.forms[0].vehi_kmsact.focus();
			return false;
      }else{
      		document.getElementById('hcero').style.display='';
			document.forms[0].vehi_cerorevision.value=1;
			document.forms[0].DiaCeroO.focus();
			return false; 
      }
      
	}

</script>

<html:form target="_self" action="/DatosVehiculo/odometro.do">
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
	<input type="hidden" name="vehi_sistema" id="vehi_sistema" value="0" READONLY="readonly"></input>
	<input type="hidden" name="contador" id="contador" value="0" READONLY="readonly"></input>
<input type="hidden" name="revisorOdometroCero" id="revisorOdometroCero" value="0" READONLY="readonly" ></input>
<input type="hidden" name="revisionesBloqueadasA" id="revisionesBloqueadasA" value="-1" READONLY="readonly"></input>
<input type="hidden" name="rBloqueadas" id="rBloqueadas" value="-1" READONLY="readonly"></input>
<input type="hidden" name="odometroBloqueado" id="odometroBloqueado" value="-1" READONLY="readonly"></input>
<input type="hidden" name="mntnmntoBloqueado" id="mntnmntoBloqueado" value="-1" READONLY="readonly"></input>
<input type="hidden" name="odoBloqueado" id="odoBloqueado" value="-1" READONLY="readonly"></input>



	<html:hidden property="tempcero"   styleId="tempcero"/>
	
	
	<table border="0" width="100%">
		<tr>
			<td valign="top">
				<table class="tablag" align="center" cellpadding="0" cellspacing="0" border="0" width="600">
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

	                          <TD>&nbsp;<%
		                           UsuarioCar usuarioCar = (UsuarioCar) request.getSession().getAttribute("usuarioCar");
		                             
		                             GrupoUsuarioSegmentacion grupoUsuarioSegmentacion = new GrupoUsuarioSegmentacion();
		                             GrupoUsuarioSegmentacionDAO grupoUsuarioSegmentacionDAO = new GrupoUsuarioSegmentacionDAO();
		                             GrupoUsuarioSegmentacion grupoUsuarioCar=null;
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
		                          	
	                          <table align="right" width="380px" height="80px" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                  <td  width="20px" height="100%">
                                  	<%if (datosPublicidadCompletos.getLogc_html_code()!= null){ %>
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
							  <td colspan="4"><hr></td>
							</tr>
											<tr>
												<td class="tdOverNameOption" colspan="2">
													<bean:message key="3595" />
												</td>
											</tr>
																	<% if (vehiculosR.getVehi_fechaencero().compareTo(BigDecimal.ZERO)==1){ %>
																	<tr>
															<td>&nbsp;
																
															</td>
														</tr>
														<tr><tr>
																		<td class="view_item" colspan="7"><bean:message key="5190" />&nbsp;<strong><%=vehiculosR.getVehi_fechaencero().toString()%></strong>
																			
																		</td>
																			
																		
																	</tr>
																	<%} %>
										<tr>
															<td>&nbsp;
																
															</td>
														</tr>
														<tr>
															<TD class="view_item" colspan="2">
																<bean:message key="1055" />
																
																<html:text property="vehi_kmsact"  styleId="vehi_fechaencerom"  maxlength="6" onkeyup="isNatural(this);" onblur="isNatural(this);" size="10" styleClass="sel"
																	onfocus="this.select()" />
 
																
																
															</td>
														</tr>
														<tr>
															  <TD class="view_item" nowrap="nowrap" colspan="2" >
																<br /><br /><bean:message key="10550" /><html:hidden property="vehi_fechaodometro"  styleId="vehi_fechaodometro" />
																<div align="center"><script language="JavaScript">obtenerCamposFecha2('DiaO', 'MesO', 'AnoO', 'vehi_fechaodometro');</script></div>	
															</TD>
														</tr>
														<tr ><td colspan="2" class="view_item"> <div id="hcero" name="hcero" style="display:none" >
														<table width="100%" border="0"  cellpadding="0" cellspacing="0" bgcolor="0099FF">
  <tr>
    <td width="3%">&nbsp;</td>
    <td valign="bottom" width="42%"><html:hidden property="vehi_fechaencero" styleId="vehi_fechaencero" /><font color="#ffffff"><strong> <bean:message key="10551" /></strong></font></td>
    <td valign="top" width="55%"><script language="JavaScript">obtenerCamposFecha2('DiaCeroO', 'MesCeroO', 'AnoCeroO', 'vehi_fechaencero');</script></td>
  </tr>
</table></div></td></tr>
														
													
														
														
														
														

														
														
														
														<tr>
															<TD class="view_item" colspan="2" height="11">
																<bean:message key="1111" />
																:&nbsp;&nbsp;&nbsp;&nbsp;
																<%
																	if ( ( ( Vehiculos ) request.getSession().getAttribute( "vehiculo" ) ).getVehi_distancia().equals( IConstantes.DISTANCIA_KILOMETROS ) ) {
																%>
																<bean:message key="1112" />
																<html:radio property="vehi_distancia" disabled="true" value="<%=IConstantes.DISTANCIA_KILOMETROS%>" />
																<%
																	} else {
																%>
																<bean:message key="1113" />
																<html:radio property="vehi_distancia" disabled="true" value="<%=IConstantes.DISTANCIA_MILLAS%>" />
															</td>
															<%
																}
															%>
														</tr>
														<tr>
															<TD colspan="3" style="background-color: #ffffff">&nbsp;
																
															</TD>
														</tr>

											<!-- Lo de abajo -->
											<tr>
												<td colspan="4">
													<table height="30" cellpadding="0" cellspacing="0" border="0" width="100%">
														<tr>
															<td align="center">
																<hr>
															</td>
														</tr>
														<tr align="center" valign="middle">
															<td>
																<INPUT type="button" onclick="verificarValorOdometro()" class="sbttn"
																	value="<bean:message key="136"/>">
															</td>
														</tr>
														<tr>
															<td>
																<div align="right" class="imprimir">
																	<img alt="<bean:message key="global.imprimiralt"/>" src="/ServiDoctor/images/print.gif" border="0" height="22" width="20">
																	&nbsp;
																	<a href="javascript: self.print();"><b><bean:message key="global.imprimir" />
																	</b> </a>
																</div>
															</td>
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
				</table>
			</td>
		</tr>
	</table>
</html:form>

