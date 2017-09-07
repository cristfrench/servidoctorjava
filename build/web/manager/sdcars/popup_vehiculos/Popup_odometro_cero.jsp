<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.util.List"%>
<link rel="stylesheet" href="/ServiDoctor/style/estilo_car.css" type="text/css">
 <script type="text/javascript" src="<%=request.getContextPath()%>/script/funciones.js"></script>
<SCRIPT>

   function enviar(dato){

		if (dato=='1'){
			window.opener.llegada(1);
		}
		if (dato=='2'){
			window.opener.llegada(2);
		}

		setCookie('POPUP',0)//actualizo el cookie
		window.close();
		
	}
	

</SCRIPT>
<body  onUnload="setCookie('POPUP',0)">
<html:form target="_self" action="/DatosVehiculo/Popup/add_control.do">
	<html:hidden property="cveh_veh_cod" />
	<table border="0" width="100%">
		<tr>
			<td valign="top">
				<table class="tablag" align="center" cellpadding="0" cellspacing="0" border="0" width="550">
					<tr>
						<td>
							<table align="center" cellpadding="0" cellspacing="0" border="0" width="100%">
								<tr>
									<td>
										<table cellpadding="0" cellspacing="0" border="0" width="100%">
											<tr>
												<td colspan="2">
													<img src="<%=request.getContextPath()%>/images/int_tit_car.gif">
													<hr>
												</td>
											</tr>
											<tr>
												<TD class="tdOverNameOption" colspan="2">												
													&nbsp;									
												</TD>
											</tr>
											<tr>
												<td>
													&nbsp;
												</td>
											</tr>
											<tr>
												<td colspan="2" class="view_item">
														      				<bean:message key="5161"/><br><br>
	      				<table width="100%" border="1" cellpadding="0" cellspacing="0"><tr><td width="60%">&nbsp;</td><td width="20%">&nbsp;<bean:message key="5163"/></td>
	      				<td width="20%">&nbsp;<bean:message key="5164"/></td></tr><tr><td class="view_item">&nbsp;<bean:message key="5162"/></td><td class="view_item">&nbsp;<%=request.getParameter( "FechaOdometroControlA" )%></td><td class="view_item">&nbsp;<%=request.getParameter( "DistanciaOdometroControl" )%></td></tr></table><br />
	      				<br /><bean:message key="5138"/><br /><br />
	      				<table width="100%" border="1" cellpadding="0" cellspacing="0"><tr><td width="60%">&nbsp;</td><td width="20%">&nbsp;<bean:message key="5163"/></td>
	      				<td width="20%">&nbsp;<bean:message key="5164"/></td></tr><tr><td class="view_item">&nbsp;<%=request.getParameter( "texto" ) %></td><td class="view_item">&nbsp;<%=request.getParameter( "AnteriorFechaControlBD0" )%></td><td class="view_item">&nbsp;<%=request.getParameter( "AnteriorDistanciaControlBD0" )%></td></tr></table>
	      				<br><br /><bean:message key="5139"/>
	      				<br><br><bean:message key="5140"/>
												</td>
											</tr>
											<tr>
												<td>
													&nbsp;
												</td>
											</tr>
											<tr>
												<td style="background-color: #F1F5FA" colspan="2">
												</td>
											</tr>
											<tr>
												<td>
													&nbsp;
												</td>
											</tr>
											<tr>
												<td colspan="2">
													<table height="30" cellpadding="0" cellspacing="0" border="0" width="100%">
														<tr>
															<td colspan="2" align="center">
																<hr>
															</td>
														</tr>
														<tr align="center" valign="middle">
															<TD colspan="2" align="center">
																<INPUT type="button" onClick="enviar('1')" class="sbttn" value="<bean:message key="5165"/>">
																<INPUT type="button" onClick="enviar('2')" class="sbttn" value="<bean:message key="5166"/>">
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
				</table>
			</td>
		</tr>
	</table>
</html:form>
</body>