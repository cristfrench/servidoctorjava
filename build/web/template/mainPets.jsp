<jsp:directive.page import="com.servidoctor.seguridad.model.UsuarioPets"/><%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ page import="com.servidoctor.sdpets.model.GrupoUsuarioSegmentacion"%>
<%@ page import="com.servidoctor.sdpets.model.LogoComprador"%>
<%@ page import="com.servidoctor.sdpets.dao.GrupoUsuarioSegmentacionDAO"%>
<%@ page import="com.servidoctor.sdpets.dao.LogoCompradorDAO"%>
<%@ page import="com.servidoctor.seguridad.model.UsuarioPets"%>
<html >
<head>
  
  <link rel="stylesheet" href="<%=request.getContextPath()%>/style/estilo_pets.css" type="text/css">

  
</head>

<body>

<table border="0" width="100%">
	
<tr>
  <td valign=top>
    

	<table class="tablag" align="center" cellpadding="0" cellspacing="0" border="0" width="600">
	<tr>
	<td>
	<table align="center" cellpadding="0" cellspacing="0" border="0" width="100%">
	<tr>
		<TD  colspan="4">
						<TABLE cellpadding="0" cellspacing="0" border="0" width="100%">
							<TR>
								<TD  align="left" valign="bottom">
								   	<img src="<%=request.getContextPath()%>/images/int_tit_pets.gif">                           
								</TD>

	                          <TD>&nbsp;<%
		                           UsuarioPets usuarioPets = (UsuarioPets) request.getSession().getAttribute("usuarioPets");
		                             
		                             GrupoUsuarioSegmentacion grupoUsuarioSegmentacion = new GrupoUsuarioSegmentacion();
		                             GrupoUsuarioSegmentacionDAO grupoUsuarioSegmentacionDAO = new GrupoUsuarioSegmentacionDAO();
		                             GrupoUsuarioSegmentacion grupoUsuarioPets=null;
		                             if (usuarioPets.getUsup_especial().intValue()==1){
		                             	grupoUsuarioPets = grupoUsuarioSegmentacionDAO.retrive("P"+usuarioPets.getUsup_cod().toString());  
		                             }else{
		                             	grupoUsuarioPets = grupoUsuarioSegmentacionDAO.retrieve("P"+usuarioPets.getUsup_licencia());  
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
									LogoComprador datosPublicidadCompletos = logoCompradorDAO.retrieve(grupoUsuarioPets.getGrupo_id(),ifechaActual);
									//int ifechaInicio = Integer.parseInt(datosPublicidadCompletos.getLogc_fecini());
									//int ifechaFinal = Integer.parseInt(datosPublicidadCompletos.getLogc_fecfin());
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
                              	    		<a href="<%=datosPublicidadCompletos.getClickizquierdo()%>" target="_blank">
                             	    	<%}else{%>
											<a href="<%=datosPublicidadCompletos.getClickderecho()%>" target="_blank">
                              	    	<%}%>
                                  <img src="<%=request.getContextPath()%>/images/clickleft.jpg" border="0" ></a>
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
			<tr><td class="tdOverNameOption" colspan="2"><bean:message key="main.welcome"/> <%=((UsuarioPets)request.getSession().getAttribute("usuarioPets")).getUsup_usuario()%></td></tr>
	    		<tr>
      			<td colspan="2" class=tdOverNameOption style="background-color:#ffffff;font-weight:normal;"> <!--Usted tiene los siguientes recordatorios para el día de hoy:-->
      			</td>
    		</tr>   
 	    	<tr><td colspan="2">&nbsp;</td></tr>
 	    	</table>
 	    </td>
 	</tr>
 	<!--<tr>
		<td>
		<table width="100%" cellspacing="2" cellpadding="2" border="0">


				

  	            <tr>
					<td></td>
					<td width="30px"><img src="<%=request.getContextPath()%>/images/bell_icon.gif"></td>
					<td class=view_item width=10%><b>Item</b></td>
					<td class=view_desc width=80%>
					Descripción
					</td>
		         </tr>
		       

  	            <tr>
					<td></td>
					<td width="30px"><img src="<%=request.getContextPath()%>/images/bell_icon.gif"></td>
					<td class=view_item width=10%><b>Item</b></td>
					<td class=view_desc width=80%>
					Descripción
					</td>
		         </tr>
  	            <tr>
					<td></td>
					<td width="30px"><img src="<%=request.getContextPath()%>/images/bell_icon.gif"></td>
					<td class=view_item width=10%><b>Item</b></td>
					<td class=view_desc width=80%>
					Descripción
					</td>
		         </tr>
  	            <tr>
					<td></td>
					<td width="30px"><img src="<%=request.getContextPath()%>/images/bell_icon.gif"></td>
					<td class=view_item width=10%><b>Item</b></td>
					<td class=view_desc  width=80%>
					Descripción
					</td>
		         </tr>
		 
				
				
				
				
				<tr>
					<td colspan="4">
						<table height="30" cellpadding="0" cellspacing="0" border="0" width="100%">
							<tr>
								<td align="center">
								<hr>
								</td>
							</tr>
							<tr align="center" valign="middle">
								<td><form name="form1" method="POST" >
									<input type="submit" name="boton" value="Acción"  class="sbttn" >
								</form></td>
							</tr>
							<tr>
							<td>
							
							<div align="right" class="imprimir">
							<img alt="<bean:message key="global.imprimiralt"/>" src="<%=request.getContextPath()%>/images/print.gif" border="0" height="22" width="20">&nbsp;<a href="javascript: self.print();"><b><bean:message key="global.imprimir" /></b></a>
							</div>
							
							
							
							</td>
							</tr>
						</table>
					</td>
				</tr>	
		</table>
	</td>
</tr>-->
</table>
</td>
</tr>
</table>							




  </td>
</tr>


</table>
</body>
</html>



