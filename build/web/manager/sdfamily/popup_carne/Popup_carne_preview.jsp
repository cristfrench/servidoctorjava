

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="com.servidoctor.constantes.IConstantes"%>
<%@ page import="org.apache.struts.util.MessageResources"%>
<%@ page import="com.servidoctor.seguridad.model.UsuarioFamily"%>
<%@ page import="com.servidoctor.sdfamily.model.DatosPersonales"%>
<%@ page import="com.servidoctor.sdfamily.dao.DatosPersonalesDAO"%>
<%@ page import="com.servidoctor.sdfamily.model.CasoEmergencia"%>
<%@ page import="com.servidoctor.sdfamily.dao.CasoEmergenciaDAO"%>
<%@ page import="com.servidoctor.parametros.model.Ciudades"%>
<%@ page import="com.servidoctor.parametros.dao.PaisDAO"%>
<%@ page import="com.servidoctor.parametros.model.Paises"%>
<%@ page import="com.servidoctor.parametros.dao.CiudadDAO"%>
<%@ page import="java.math.BigDecimal"%>
<%UsuarioFamily usuarioFamily = (UsuarioFamily) request.getSession().getAttribute("usuarioFamily");
  DatosPersonalesDAO  datosPersonalesdao = new DatosPersonalesDAO();
  DatosPersonales datospersonales = datosPersonalesdao.retrive(usuarioFamily.getUsuf_cod());
  CasoEmergenciaDAO  casoEmergenciadao = new CasoEmergenciaDAO();
  BigDecimal nuevo=new BigDecimal(1);
  CasoEmergencia casoEmergencia = casoEmergenciadao.retrieve(usuarioFamily.getUsuf_cod(),nuevo);
  PaisDAO paisDAO = new PaisDAO();
  Paises nombrepais = paisDAO.retrive(datospersonales.getDatp_pais_cod());
  CiudadDAO ciudadDAO = new CiudadDAO();
  Ciudades nombreciudad = ciudadDAO.retrive(datospersonales.getDatp_pais_cod(),datospersonales.getDatp_ciu_cod());
%>
<html>
   <table border="0" cellpadding="0" cellspacing="0" width="100%">
   <tr>
     <td colspan="3">
       <object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,0,0" width="764" height="331" id="carnet_SD" align="middle"
         data="carnet_color1.swf?nombre=<%=datospersonales.getDatp_nombre()%>&nbsp;<%=datospersonales.getDatp_apellido()%>&identificacion=<%=datospersonales.getDatp_id_doc()%>&login=<%=usuarioFamily.getUsuf_usuario()%>&pass=<%=usuarioFamily.getUsuf_clave_emer()%>&residencia=<%=nombreciudad.getCiu_des()%>&nbsp;<%=nombrepais.getPais_des()%>&contacto=<%=casoEmergencia.getCase_nombre()%>&nbsp;<%=casoEmergencia.getCase_apellido()%>&telefono=<%=casoEmergencia.getCase_indpais1()%>-<%=casoEmergencia.getCase_indciudad1()%>-<%=casoEmergencia.getCase_telefono1()%>.&linea1=<%=request.getParameter("linea1")%>&linea2=<%=request.getParameter("linea2")%>&linea3=<%=request.getParameter("linea3")%>">
         <param name="movie"
           value="<%=request.getContextPath()%>/manager/sdfamily/carnet_color1.swf?nombre=<%=datospersonales.getDatp_nombre()%>&nbsp;<%=datospersonales.getDatp_apellido()%>&identificacion=<%=datospersonales.getDatp_id_doc()%>&login=<%=usuarioFamily.getUsuf_usuario()%>&pass=<%=usuarioFamily.getUsuf_clave_emer()%>&residencia=<%=nombreciudad.getCiu_des()%>&nbsp;<%=nombrepais.getPais_des()%>&contacto=<%=casoEmergencia.getCase_nombre()%>&nbsp;<%=casoEmergencia.getCase_apellido()%>&telefono=<%=casoEmergencia.getCase_indpais1()%>-<%=casoEmergencia.getCase_indciudad1()%>-<%=casoEmergencia.getCase_telefono1()%>&linea1=<%=request.getParameter("linea1")%>&linea2=<%=request.getParameter("linea2")%>&linea3=<%=request.getParameter("linea3")%>">
         <param name="quality" value="high">
         <param name="bgcolor" value="#ffffff">
         <embed
           src="<%=request.getContextPath()%>/manager/sdfamily/carnet_color1.swf?nombre=<%=datospersonales.getDatp_nombre()%>&nbsp;<%=datospersonales.getDatp_apellido()%>&identificacion=<%=datospersonales.getDatp_id_doc()%>&login=<%=usuarioFamily.getUsuf_usuario()%>&pass=<%=usuarioFamily.getUsuf_clave_emer()%>&residencia=<%=nombreciudad.getCiu_des()%>&nbsp;<%=nombrepais.getPais_des()%>&contacto=<%=casoEmergencia.getCase_nombre()%>&nbsp;<%=casoEmergencia.getCase_apellido()%>&telefono=<%=casoEmergencia.getCase_indpais1()%>-<%=casoEmergencia.getCase_indciudad1()%>-<%=casoEmergencia.getCase_telefono1()%>&linea1=<%=request.getParameter("linea1")%>&linea2=<%=request.getParameter("linea2")%>&linea3=<%=request.getParameter("linea3")%>"
           quality="high" bgcolor="#ffffff" width="550" height="240" name="carnet" align="middle" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />
       </object>
     </td>
   </tr>
   <tr><td colspan="3" align="center"><INPUT type="button"  class="sbttn" value="<bean:message key="4012"/>" onClick="javascript: window.close()"></td></tr>
   </table>
</html>
<!--   688 X 305  visual  Original=550X240           <bean:write name="datosPersonales" property="datp_nombre"/>&nbsp;<bean:write name="datosPersonales" property="datp_apellido"/><bean:write name="datosPersonales" property="datp_id_doc"/><bean:write name="usuarioFamilyForm" property="usuf_usuario" /><bean:write name="usuarioFamilyForm" property="usuf_clave_emer" />-->