<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<html>
<head>
<%@ page 
language="java"
contentType="text/html; charset=ISO-8859-1"
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="GENERATOR" content="IBM WebSphere Studio">
<meta http-equiv="Content-Style-Type" content="text/css">
<title>Reporte de Beneficiarios</title>
</head>
<BODY>
<script>
function procesar()
{
		if(document.all.numItem.value > 0){
			document.forms[0].action="<%=request.getContextPath()%>/Reportes/generate.do"
			document.forms[0].submit();
		}else{
			alert("Debe seleccionar al menos una columna para el reporte.")
		}
}
function procesarCancel()
{
	top.workFrame.location.href='http://www.mi-bienestar.com'
}
function validatam(vt){
	var t = document.all.ADDRESST.value
	if(t.length>Math.round(vt)){
		document.all.ADDRESST.value = t.substring(0,Math.round(vt))
	}else{
		document.all.ADDRESS.value = document.all.ADDRESST.value
	}
}
function addItem(name)
{
	if (eval('document.all.'+name+'.checked')){
		if (document.all.numItem.value == 7){
			alert("Por cuestiones de presentación, se deberán elegir un máximo de siete (7) columnas por reporte.")
			eval('document.all.'+name+'.checked=false')
		}else{
			document.all.numItem.value = Math.round(document.all.numItem.value) + 1
		}
	}else{
		document.all.numItem.value = Math.round(document.all.numItem.value) - 1
	}
}

</script>
</BODY>
<body>
<html:form target="_self" action="/Reportes/view.do">
<INPUT name="numItem" type="hidden" value="0">
<table border="0" width="750" align="center">
	<tbody>
	<tr align="center">
						<td height="20" colspan="2"><b><font color="#333366" size="4"
							face="Verdana, Arial, Helvetica, sans-serif"><strong><bean:message key="700" /></strong></font></b></td>
					</tr>

		<tr>
			<td align="center" width="50%">
			<table border="0" width="100%">
				<tbody>

					
					<tr>
						<td height="20" colspan="2"></td>
					</tr>
					<tr>
						<td class="tdContentText"><bean:message key="701" /></td>
						<td><html:text  property="nombres" maxlength="30" size="30"/></td>
					</tr>
					<tr>
						<td class="tdContentText"><bean:message key="702" /></td>
						<td><html:text  property="apellido" maxlength="20" size="20"/></td>
					</tr>
					
					
<tr>
						<td class="tdContentText"><bean:message key="703" /></td>
						<td><html:select property="pais" styleClass="aClassSelectL" onchange="enviar('<%=request.getContextPath()%>/Reportes/view.do')">
				 		<html:options collection="PAISES" labelProperty="pais_des" property="pais_des" />
				 		</html:select></td>
					</tr>					
					<tr>
						<td class="tdContentText"><bean:message key="704" /></td>
						<td><html:text property="enfermedad" maxlength="20" size="20" /></td>
					</tr>										
					<tr>
						<td class="tdContentText"><bean:message key="705" /></td>
						<td><html:text property="alergia" maxlength="20" size="20" /></td>
					</tr>
					<tr>
						<td class="tdContentText"><bean:message key="706" /></td>
						<td><html:text property="cirujia" maxlength="20" size="20" /></td>
					</tr>
					<tr>
						<td class="tdContentText"><bean:message key="707" /></td>
						<td><html:text property="examen" maxlength="20" size="20" /></td>
					</tr>
					<tr>
						<td class="tdContentText"><bean:message key="708" /></td>
						<td><html:text property="optometria" maxlength="20" size="20" /></td>
					</tr>
					<tr>
						<td class="tdContentText"><bean:message key="709" /></td>
						<td><html:text property="odontologia" maxlength="20" size="20" /></td>
					</tr>
					<tr>
						<td class="tdContentText"><bean:message key="710" /></td>
						<td colspan="2"><html:text property="vacuna" maxlength="20" size="20" /></td>
					</tr>
					
																			
					<tr>
						<td class="tdContentText"><bean:message key="711" /></td>
						<td class="tdContentText"><bean:message key="124" /><html:text property="fecinscripcion_desde" maxlength="20" size="20" /></td>
						<td class="tdContentText"><bean:message key="125" /><html:text property="fecinscripcion_hasta" maxlength="20" size="20" /></td>
					</tr>
					<tr>
						<td class="tdContentText"><bean:message key="712" /></td>
						<td><bean:message key="713"/><html:radio  property="id_doc_si" value="si" /><bean:message key="714"/><html:radio  property="id_doc_si" value="no" /></TD>
					</tr>
					<tr>
						<td class="tdContentText"><bean:message key="715" /></td>
						<td colspan="2"><html:text property="identificador" maxlength="20" size="20" /></td>
					</tr>
					
					<tr>
						<td height="20" colspan="2"></td>
					</tr>
				</tbody>
			</table>
			</td>
			<td width="50%">
			<table border="0" width="100%">
				<tbody>
					<tr align="left">
						<td height="20" colspan="2"><b><font color="#333366" size="2"
							face="Verdana, Arial, Helvetica, sans-serif"><strong><bean:message key="716" /></strong></font> </b><bean:message key="718" /></td>
					</tr>
					<tr align="left">
						<td height="20" colspan="2"></td>
					</tr>
					<tr align="left">
						<td height="20" colspan="2"><b><font color="#333366" size="2"
							face="Verdana, Arial, Helvetica, sans-serif"><strong><bean:message key="717" /></strong></font></b></td>
					</tr>
					<tr>
						<td height="20" align="left">
						<html:checkbox property="indNomApe" onclick="addItem(this.name)">&nbsp;Nombres y Apellidos</html:checkbox><br>
						<html:checkbox property="indDocumento" onclick="addItem(this.name)">&nbsp;Documento</html:checkbox><br>
						<html:checkbox property="indSexo" onclick="addItem(this.name)">&nbsp;Sexo</html:checkbox><br>
						<html:checkbox property="indPais" onclick="addItem(this.name)">&nbsp;Pais</html:checkbox><br>
						<html:checkbox property="indCiudad" onclick="addItem(this.name)">&nbsp;ciudad</html:checkbox><br>
						<html:checkbox property="indRelacion" onclick="addItem(this.name)">&nbsp;Relacion</html:checkbox><br>
						<html:checkbox property="indFecNacimiento" onclick="addItem(this.name)">&nbsp;Fecha Nacimiento</html:checkbox><br>
						</td>
						<td height="20" align="left" valign="top">
						<html:checkbox property="indTipoSangre" onclick="addItem(this.name)">&nbsp;Tipo Sangre</html:checkbox><br>
						<html:checkbox property="indTelFijo" onclick="addItem(this.name)">&nbsp;Telefono Fijo</html:checkbox><br>
						<html:checkbox property="indTelMovil" onclick="addItem(this.name)">&nbsp;Telefono Móvil</html:checkbox><br>
						<html:checkbox property="indEMail" onclick="addItem(this.name)">&nbsp;E-Mail</html:checkbox><br>
						<html:checkbox property="indContactos" onclick="addItem(this.name)">&nbsp;Contactos</html:checkbox><br>
						<html:checkbox property="indSeguros" onclick="addItem(this.name)">&nbsp;Seguros</html:checkbox><br>
						<html:checkbox property="indIdentificadores" onclick="addItem(this.name)">&nbsp;Identificadores</html:checkbox><br>
						
						
						</td>
					</tr>
				</tbody>
			</table>
			</td>
		</tr>
		<tr>
			<td width="50%"><b><font color="#333366" size="2" face="Verdana, Arial, Helvetica, sans-serif"><strong>Ordenamiento:</strong></font></b><br>
			<html:radio  property="indOrdenamiento" value="indNomApe" />&nbsp;Nombres y Apellidos<br>
			
			<html:radio  property="indOrdenamiento" value="indDocumento" />&nbsp;Documento<br>
			<html:radio  property="indOrdenamiento" value="indPais" />&nbsp;Pais<br>
			<html:radio  property="indOrdenamiento" value="indCiudad" />&nbsp;Ciudad<br>
			<html:radio  property="indOrdenamiento" value="indRelacion" />&nbsp;Relacion<br>
			<html:radio  property="indOrdenamiento" value="indFecNacimiento" />&nbsp;Fecha Nacimiento<br>
			<html:radio  property="indOrdenamiento" value="indTipoSangre" />&nbsp;Tipo Sangre<br>
			<html:radio  property="indOrdenamiento" value="indTelFijo" />&nbsp;Telefono Fijo<br>
			<html:radio  property="indOrdenamiento" value="indTelMovil" />&nbsp;Telefono Móvil<br>
			<html:radio  property="indOrdenamiento" value="indContactos" />&nbsp;Contactos<br>
			<html:radio  property="indOrdenamiento" value="indSeguros" />&nbsp;Seguros<br>
			<html:radio  property="indOrdenamiento" value="indIdentificadores" />&nbsp;Identificador<br>
			</td>
			<td width="50%"></td>
		</tr>
		<tr align="center">
			<td height="20" colspan="2"><input type="button" name="def"
				value="Generar Reporte" onclick="procesar()" class="sbttn"></td>
		</tr>

	</tbody>
</table>
</html:form>
</body>
</html>
