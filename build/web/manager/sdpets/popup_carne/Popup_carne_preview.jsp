

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="com.servidoctor.constantes.IConstantes"%>
<%@ page import="org.apache.struts.util.MessageResources"%>
<%@ page import="com.servidoctor.seguridad.model.UsuarioPets"%>
<%@ page import="com.servidoctor.sdpets.model.Mascota"%>
<%@ page import="com.servidoctor.sdpets.dao.MascotaDAO"%>
<%@ page import="com.servidoctor.sdpets.model.PropietariosMascota"%>
<%@ page import="com.servidoctor.sdpets.dao.PropietariosMascotaDAO"%>
<%@ page import="com.servidoctor.sdpets.model.ContactosMascota"%>
<%@ page import="com.servidoctor.sdpets.dao.ContactosMascotaDAO"%>
<%@ page import="com.servidoctor.parametros.model.Ciudades"%>
<%@ page import="com.servidoctor.parametros.dao.PaisDAO"%>
<%@ page import="com.servidoctor.parametros.model.Paises"%>
<%@ page import="com.servidoctor.parametros.dao.CiudadDAO"%>
<%@ page import="java.math.BigDecimal"%>
<%UsuarioPets usuarioPets = (UsuarioPets) request.getSession().getAttribute("usuarioPets");
  
  Mascota mascota = (Mascota) request.getSession().getAttribute("mascota");
  PropietariosMascotaDAO  propietariosMascotadao = new PropietariosMascotaDAO();
  BigDecimal nuevo=new BigDecimal(1);
  PropietariosMascota propietariosMascota = propietariosMascotadao.retrieve(mascota.getMas_cod());

  PaisDAO paisDAO = new PaisDAO();
  Paises nombrepais = paisDAO.retrive(propietariosMascota.getPmas_pais_cod());
  CiudadDAO ciudadDAO = new CiudadDAO();
  Ciudades nombreciudad = ciudadDAO.retrive(propietariosMascota.getPmas_pais_cod(),propietariosMascota.getPmas_ciu_cod());
%>
<html>
   <table border="0" cellpadding="0" cellspacing="0" width="100%">
   <tr>
     <td colspan="3">
       <object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,0,0" width="764" height="331" id="carnet_SD" align="middle"
         data="carnet_color_pets.swf?nombre=<%=propietariosMascota.getPmas_nombre()%>&nbsp;<%=propietariosMascota.getPmas_apellido()%>&identificacion=<%=mascota.getMas_nombre()%>&login=<%=usuarioPets.getUsup_usuario()%>&pass=<%=usuarioPets.getUsup_clave_emer()%>&residencia=<%=nombreciudad.getCiu_des()%>&nbsp;<%=nombrepais.getPais_des()%>&contacto=<%=propietariosMascota.getPmas_nombre()%>&nbsp;<%=propietariosMascota.getPmas_apellido()%>&telefono=<%=propietariosMascota.getPmas_indpais1()%>-<%=propietariosMascota.getPmas_indciudad1()%>-<%=propietariosMascota.getPmas_telefono1()%>.&linea1=<%=request.getParameter("linea1")%>&linea2=<%=request.getParameter("linea2")%>&linea3=<%=request.getParameter("linea3")%>">
         <param name="movie"
           value="<%=request.getContextPath()%>/manager/sdpets/popup_carne/carnet_color_pets.swf?nombre=<%=propietariosMascota.getPmas_nombre()%>&nbsp;<%=propietariosMascota.getPmas_apellido()%>&identificacion=<%=mascota.getMas_nombre()%>&login=<%=usuarioPets.getUsup_usuario()%>&pass=<%=usuarioPets.getUsup_clave_emer()%>&residencia=<%=nombreciudad.getCiu_des()%>&nbsp;<%=nombrepais.getPais_des()%>&contacto=<%=propietariosMascota.getPmas_nombre()%>&nbsp;<%=propietariosMascota.getPmas_apellido()%>&telefono=<%=propietariosMascota.getPmas_indpais1()%>-<%=propietariosMascota.getPmas_indciudad1()%>-<%=propietariosMascota.getPmas_telefono1()%>&linea1=<%=request.getParameter("linea1")%>&linea2=<%=request.getParameter("linea2")%>&linea3=<%=request.getParameter("linea3")%>">
         <param name="quality" value="high">
         <param name="bgcolor" value="#ffffff">
         <embed
           src="<%=request.getContextPath()%>/manager/sdpets/popup_carne/carnet_color_pets.swf?nombre=<%=propietariosMascota.getPmas_nombre()%>&nbsp;<%=propietariosMascota.getPmas_apellido()%>&identificacion=<%=mascota.getMas_nombre()%>&login=<%=usuarioPets.getUsup_usuario()%>&pass=<%=usuarioPets.getUsup_clave_emer()%>&residencia=<%=nombreciudad.getCiu_des()%>&nbsp;<%=nombrepais.getPais_des()%>&contacto=<%=propietariosMascota.getPmas_nombre()%>&nbsp;<%=propietariosMascota.getPmas_apellido()%>&telefono=<%=propietariosMascota.getPmas_indpais1()%>-<%=propietariosMascota.getPmas_indciudad1()%>-<%=propietariosMascota.getPmas_telefono1()%>&linea1=<%=request.getParameter("linea1")%>&linea2=<%=request.getParameter("linea2")%>&linea3=<%=request.getParameter("linea3")%>"
           quality="high" bgcolor="#ffffff" width="550" height="240" name="carnet" align="middle" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />
       </object>
     </td>
   </tr>
   <tr><td colspan="3" align="center"><INPUT type="button"  class="sbttn" value="<bean:message key="4012"/>" onClick="javascript: window.close()"></td></tr>
   </table>
</html>
