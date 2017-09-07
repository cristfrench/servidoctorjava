<%@ page import="com.servidoctor.constantes.IConstantes" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ page import="com.maxmind.geoip.*" %>
<%@ page import="java.io.IOException" %>
<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>

<%  ReCaptcha c = ReCaptchaFactory.newReCaptcha("6LdOD8ESAAAAANpyVDRrk24HewvZM-IzuF22BdtN ", "6LdOD8ESAAAAAIa7S3BTVvZqgD5ZI2843vthykjL", false); %>    
<html:html>
<head>
<title><bean:message key="main.title"/></title>
<meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
<LINK rel="stylesheet" href="<%=request.getContextPath()%>/style/main.css" type="text/css">
</head>
<body>
<s:set name="idioma" value="es" scope="session" />
<!-- target="_self" -->
<html:form action="/CrearLogin"  method="post" >
    
<table width="100%" height="100%" border="0">
  <tr>
    <td>
	<table align="center">
		<tr>
			<td class="error" colspan="2"><html:errors/></td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td class="tdlogin"><bean:message key="main.activar.codigo"/> </td>
			<td class="tdlogin"><html:text property="compras_licencias_codact" size="20" maxlength="20" styleClass="sel"/></td>
		</tr>
		<tr>
			<td class="tdlogin"><bean:message key="main.activar.login"/></td>
			<td class="tdlogin"><html:text property="login" size="40" maxlength="80" styleClass="sel"/></td>
		</tr>
		<tr>
			<td class="tdlogin"><bean:message key="main.activar.reLogin"/></td>
			<td class="tdlogin"><html:text property="reLogin" size="40" maxlength="80" styleClass="sel"/></td>
		</tr>
		<tr>
			<td class="tdlogin"><bean:message key="main.activar.password"/></td>
			<td class="tdlogin"><html:password property="password" size="40" maxlength="80" styleClass="sel"/></td>
		</tr>
		<tr>
			<td class="tdlogin"><bean:message key="main.activar.rePassword"/></td>
			<td class="tdlogin"><html:password property="rePassword" size="40" maxlength="80" styleClass="sel"/></td>
		</tr>
		<%if (request.getAttribute("mostrarModulos2") != null){%>
		<tr>
			<td class="tdlogin"><bean:message key="main.login.modulos" /></td>
			<td class="tdlogin"><html:select property="aplicacion" styleClass="select">
			<%if (request.getAttribute("familyespecial") != null){%><html:option value='<%=IConstantes.FAMILY%>'><%=IConstantes.FAMILY%></html:option>
			<%}if (request.getAttribute("petsespecial") != null){%><html:option  value='<%=IConstantes.PETS%>'><%=IConstantes.PETS%></html:option>
			<%}if (request.getAttribute("carespecial") != null){%><html:option value='<%=IConstantes.CAR%>'><%=IConstantes.CAR%></html:option>
			<%}%></html:select>
			</td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<!--<tr>		-->
			<!--<td class="tdlogin" colspan="2" align="center"><% //out.print(c.createRecaptchaHtml(null, null));%></td> -->
		<!--</tr> -->
		<%} %>
		<tr>		
			<td class="tdlogin" colspan="2" align="center"><html:submit><bean:message key="main.activar.activar"/></html:submit></td>
		</tr>
		<tr>			
			<td class="tdlogin" colspan="2" align="center">&nbsp;<bean:message key="main.activar.idiomaservicio"/></td>
		</tr>
		<%
		/*
		try {
	    String sep = System.getProperty("file.separator");
 		
 		System.out.println(sep);
	    
	    // Uncomment for windows
	    //String dir = System.getProperty("user.dir"); 

		//System.out.println(dir);

	    // Uncomment for Linux
	   String dir = "/usr/local/share/GeoIP";

	    String dbfile = dir + sep + "GeoIP.dat"; 
	    // You should only call LookupService once, especially if you use
	    // GEOIP_MEMORY_CACHE mode, since the LookupService constructor takes up
	    // resources to load the GeoIP.dat file into memory
	    //LookupService cl = new LookupService(dbfile,LookupService.GEOIP_STANDARD);
	    LookupService cl = new LookupService(dbfile,LookupService.GEOIP_MEMORY_CACHE);
		String ipCustom = request.getRemoteAddr();
		System.out.println(ipCustom);
 		System.out.println(cl.getCountry(ipCustom).getName());*/
		 %>		
		<!--  <tr>			
			<td class="tdlogin" colspan="2" align="center">Pais: <% /*c=l.getCountry(ipCustom).getName()*/%> IP: <%/*=ipCustom*/%></td>
		</tr>-->
		<% /* cl.close();
	}
	catch (IOException e) {
	    System.out.println("IO Exception");
	}
		*/
		 %>		
	</table>
	</td>
  </tr>
</table>
</html:form>
</body>
</html:html>
