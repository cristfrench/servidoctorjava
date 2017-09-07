<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ page import="com.servidoctor.util.classes.ManejoFechas" %>

<html>
<head>

<link rel="stylesheet" href="/ServiDoctor/style/estilo_family.css" type="text/css">
<script>
function add_control()
{
//enviar('/ServiDoctor/Exa_Lab/add.do');
eval("window.open('/ServiDoctor/Exa_Lab/Popup/add_control.do?','enfermedad','scrollbars=yes, top=100, left=200, width=700, height=400')")
}
function edit_control(x)
{
//enviar('/ServiDoctor/Exa_Lab/add.do');
eval("window.open('/ServiDoctor/Exa_Lab/Popup/edit_control.do?num_control="+x+"','examen','scrollbars=yes, top=100, left=200, width=700, height=400')")
}
function remove_control(x)
{
//enviar('/ServiDoctor/Exa_Lab/add.do');
enviar('/ServiDoctor/Exa_Lab/Popup/remove_control.do?num_control='+x);
}
</script>

</head>

<body>
<html:form target="_self" action="/Exa_Lab/add.do">
	<table border="0" width="100%">

		<tr>
			<td valign=top>


			<table class="tablag" align="center" cellpadding="0" cellspacing="0" border="0" width="600">
				<tr>
					<td>
					<table align="center" cellpadding="0" cellspacing="0" border="0" width="100%">

						<tr>
							<td>
							<table cellpadding="0" cellspacing="0" border="0" width="100%">
								<tr>
									<td colspan="3"><img src="/ServiDoctor/images/int_tit_family.gif">
									<hr>
									</td>
								</tr>
								<tr>
									<td class="tdOverNameOption" colspan="3"><bean:message key="840" /></td>
								</tr>
								<tr>
									<td class="tdNameOption" colspan="3">
									<table border="0" cellpadding="0" cellspacing="1">

										<tr>
											<TD id="tab11" class="sbttn tdNameOption" onclick="tab('1','exa_lab','family')">&nbsp;<bean:message key="851" />&nbsp;</TD>

										</tr>
									</table>
									</td>

								</tr>

								<tr>
									<td colspan="3">

									<table border="0" id="tab1" cellspacing="0" cellpadding="0" width="100%">
										<tr>
											<TD>&nbsp;</TD>

										</tr>
										<tr>
											<TD colspan="17" class="view_item"><b><bean:message key="850" /></b></TD>
										</tr>
										<tr>
											<TD>&nbsp;</TD>
										</tr>
										<tr>
											<TD colspan="17" class="view_item"><b><bean:message key="852" /></b></TD>
										</tr>
										<tr>
											<TD>&nbsp;</TD>
										</tr>

										<tr>
											<td class="tdNameOption" rowspan="2" style="border: 1px solid #D98200"><bean:message key="842" /></td>
											<td class="tdNameOption" colspan="5" style="border: 1px solid #D98200"><bean:message key="845" />&nbsp;1</td>
											<td class="tdNameOption" colspan="5" style="border: 1px solid #D98200"><bean:message key="845" />&nbsp;2</td>
											<td class="tdNameOption" colspan="5" style="border: 1px solid #D98200"><bean:message key="845" />&nbsp;3</td>
											<td class="tdNameOption" rowspan="2" style="border: 1px solid #D98200"><bean:message key="137" /></td>
										</tr>
										<tr>
											<td class="tdNameOption" style="border: 1px solid #D98200"><bean:message key="853" /></td>
											<td class="tdNameOption" style="border: 1px solid #D98200"><bean:message key="854" /></td>
											<td class="tdNameOption" style="border: 1px solid #D98200"><bean:message key="855" /></td>
											<td class="tdNameOption" style="border: 1px solid #D98200"><bean:message key="856" /></td>
											<td class="tdNameOption" style="border: 1px solid #D98200"><bean:message key="857" /></td>
											<td class="tdNameOption" style="border: 1px solid #D98200"><bean:message key="853" /></td>
											<td class="tdNameOption" style="border: 1px solid #D98200"><bean:message key="854" /></td>
											<td class="tdNameOption" style="border: 1px solid #D98200"><bean:message key="855" /></td>
											<td class="tdNameOption" style="border: 1px solid #D98200"><bean:message key="856" /></td>
											<td class="tdNameOption" style="border: 1px solid #D98200"><bean:message key="857" /></td>
											<td class="tdNameOption" style="border: 1px solid #D98200"><bean:message key="853" /></td>
											<td class="tdNameOption" style="border: 1px solid #D98200"><bean:message key="854" /></td>
											<td class="tdNameOption" style="border: 1px solid #D98200"><bean:message key="855" /></td>
											<td class="tdNameOption" style="border: 1px solid #D98200"><bean:message key="856" /></td>
											<td class="tdNameOption" style="border: 1px solid #D98200"><bean:message key="857" /></td>
										</tr>


										<%int x = 0;%>
										<logic:iterate indexId="ind" id="examenes" name="EXAMENESLABORATORIO" type="com.servidoctor.parametros.model.ExamenesLaboratorio">

											<tr>

												<td class="view_item">&nbsp;&nbsp;<bean:write name="examenes" property="elab_des" scope="page" />&nbsp;&nbsp;</td>
												<td class="view_desc">&nbsp;&nbsp;<%=ManejoFechas.FormateoFecha(examenes.getElab_fecha1().toString())%>&nbsp;&nbsp;</td>
												<td class="view_desc">&nbsp;&nbsp;<bean:write name="examenes" property="elab_resultado1" scope="page" />&nbsp;&nbsp;</td>
												<td class="view_desc">&nbsp;&nbsp;<%=request.getAttribute("clasificacion1" + x)%>&nbsp;&nbsp;</td>
												<td class="view_desc">&nbsp;&nbsp;<%=request.getAttribute("desde1" + x)%>&nbsp;&nbsp;</td>
												<td class="view_desc">&nbsp;&nbsp;<%=request.getAttribute("hasta1" + x)%>&nbsp;&nbsp;</td>
												<td class="view_desc">&nbsp;&nbsp;<%=ManejoFechas.FormateoFecha(examenes.getElab_fecha2().toString())%>&nbsp;&nbsp;</td>
												<td class="view_desc">&nbsp;&nbsp;<bean:write name="examenes" property="elab_resultado2" scope="page" />&nbsp;&nbsp;</td>
												<td class="view_desc">&nbsp;&nbsp;<%=request.getAttribute("clasificacion2" + x)%>&nbsp;&nbsp;</td>
												<td class="view_desc">&nbsp;&nbsp;<%=request.getAttribute("desde2" + x)%>&nbsp;&nbsp;</td>
												<td class="view_desc">&nbsp;&nbsp;<%=request.getAttribute("hasta2" + x)%>&nbsp;&nbsp;</td>
												<td class="view_desc">&nbsp;&nbsp;<%=ManejoFechas.FormateoFecha(examenes.getElab_fecha3().toString())%>&nbsp;&nbsp;</td>
												<td class="view_desc">&nbsp;&nbsp;<bean:write name="examenes" property="elab_resultado3" scope="page" />&nbsp;&nbsp;</td>
												<td class="view_desc">&nbsp;&nbsp;<%=request.getAttribute("clasificacion3" + x)%>&nbsp;&nbsp;</td>
												<td class="view_desc">&nbsp;&nbsp;<%=request.getAttribute("desde3" + x)%>&nbsp;&nbsp;</td>
												<td class="view_desc">&nbsp;&nbsp;<%=request.getAttribute("hasta3" + x)%>&nbsp;&nbsp;</td>
												<td align="center"><IMG border="0" onclick="edit_control('<%=x%>')" src="/ServiDoctor/images/editar.gif" alt="<bean:message key="138"/>" width="16" height="16" style="cursor: hand"> <IMG border="0" onclick="remove_control('<%=x%>')" src="/ServiDoctor/images/eliminar.gif" alt="<bean:message key="139"/>" width="16" height="16" style="cursor: hand"></td>
											</tr>
											<%x++;%>
										</logic:iterate>
										<tr>
											<TD>&nbsp;</TD>

										</tr>
										<tr>
											<TD colspan="17" align="center"><INPUT type="button" onclick="add_control()" class="sbttn" value="<bean:message key="global.button.adicionar"/>&nbsp;<bean:message key="845"/>"></TD>
										</tr>
										<input type="hidden" name="total_enfermedades" value="<%=x%>">


										<tr>
											<TD>&nbsp;</TD>

										</tr>
									</table>

									</td>
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
											<td><INPUT type="button" onclick="enviar('/ServiDoctor/Exa_Lab/save.do')" class="sbttn" value="<bean:message key="136"/>"></td>
										</tr>
										<tr>
											<td>

											<div align="right" class="imprimir"><img alt="<bean:message key="global.imprimiralt"/>" src="/ServiDoctor/images/print.gif" border="0" height="22" width="20">&nbsp;<a href="javascript: self.print();"><b><bean:message key="global.imprimir" /></b></a></div>



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
	<script>
tab_charge('exa_lab','family');
</script>

</html:form>
</body>
</html>



