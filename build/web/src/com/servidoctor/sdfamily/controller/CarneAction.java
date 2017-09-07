/*   1:    */ package com.servidoctor.sdfamily.controller;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.controller.BaseAction;
/*   4:    */ import com.servidoctor.parametros.controller.UsuarioFamilyForm;
/*   5:    */ import com.servidoctor.parametros.dao.CiudadDAO;
/*   6:    */ import com.servidoctor.parametros.dao.PaisDAO;
/*   7:    */ import com.servidoctor.parametros.model.Ciudades;
/*   8:    */ import com.servidoctor.parametros.model.Paises;
/*   9:    */ import com.servidoctor.sdfamily.dao.DatosPersonalesCompletoDAO;
/*  10:    */ import com.servidoctor.sdfamily.dao.DatosPersonalesDAO;
/*  11:    */ import com.servidoctor.sdfamily.model.CasoEmergencia;
/*  12:    */ import com.servidoctor.sdfamily.model.DatosPersonales;
/*  13:    */ import com.servidoctor.sdfamily.model.DatosPersonalesCompleto;
/*  14:    */ import com.servidoctor.seguridad.dao.UsuarioFamilyDAO;
/*  15:    */ import com.servidoctor.seguridad.model.Servidores;
/*  16:    */ import com.servidoctor.seguridad.model.UsuarioFamily;
/*  17:    */ import java.math.BigDecimal;
/*  18:    */ import java.util.Iterator;
/*  19:    */ import java.util.List;
/*  20:    */ import javax.servlet.http.HttpServletRequest;
/*  21:    */ import javax.servlet.http.HttpServletResponse;
/*  22:    */ import javax.servlet.http.HttpSession;
/*  23:    */ import org.apache.commons.beanutils.BeanUtils;
/*  24:    */ import org.apache.struts.action.ActionForm;
/*  25:    */ import org.apache.struts.action.ActionForward;
/*  26:    */ import org.apache.struts.action.ActionMapping;
/*  27:    */ 
/*  28:    */ public class CarneAction
/*  29:    */   extends BaseAction
/*  30:    */ {
/*  31:    */   public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  32:    */     throws Exception
/*  33:    */   {
/*  34: 38 */     ActionForward myforward = super.execute(mapping, actionForm, request, response);
/*  35: 39 */     String myaction = mapping.getParameter();
/*  36: 41 */     if (myforward == null)
/*  37:    */     {
/*  38: 42 */       DatosPersonales datosPersonales = (DatosPersonales)request.getSession().getAttribute("datosPersonales");
/*  39: 43 */       if (datosPersonales.getDatp_usuf_cod() == null) {
/*  40: 44 */         myforward = mapping.findForward("datospersonales");
/*  41: 45 */       } else if ("".equalsIgnoreCase(myaction)) {
/*  42: 46 */         myforward = mapping.findForward("failure");
/*  43: 47 */       } else if ("VIEW".equalsIgnoreCase(myaction)) {
/*  44: 48 */         myforward = performView(mapping, actionForm, request, response);
/*  45: 49 */       } else if ("GENERATE".equalsIgnoreCase(myaction)) {
/*  46: 50 */         myforward = performGenerate(mapping, actionForm, request, response);
/*  47: 51 */       } else if ("PREVIEW".equalsIgnoreCase(myaction)) {
/*  48: 52 */         myforward = performPreview(mapping, actionForm, request, response);
/*  49:    */       } else {
/*  50: 54 */         myforward = mapping.findForward("failure");
/*  51:    */       }
/*  52:    */     }
/*  53: 58 */     return myforward;
/*  54:    */   }
/*  55:    */   
/*  56:    */   private ActionForward performGenerate(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  57:    */   {
/*  58: 62 */     UsuarioFamilyForm form = (UsuarioFamilyForm)actionForm;
/*  59:    */     try
/*  60:    */     {
/*  61: 65 */       int tam = 0;
/*  62: 66 */       while (tam < 5) {
/*  63: 67 */         tam = 6 + (int)(System.currentTimeMillis() % 5L);
/*  64:    */       }
/*  65: 70 */       char[] password = new char[tam];
/*  66: 72 */       for (int i = 0; i < password.length; i++) {
/*  67: 73 */         while ((password[i] < '0') || ((password[i] > '9') && (password[i] < 'A')) || ((password[i] > 'Z') && (password[i] < 'a')) || (password[i] > 'z'))
/*  68:    */         {
/*  69: 74 */           int current = (int)(Math.random() * 123.0D);
/*  70: 75 */           password[i] = ((char)(current % 123));
/*  71:    */         }
/*  72:    */       }
/*  73: 79 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/*  74: 80 */       usuarioFamily.setUsuf_clave_emer(String.valueOf(password));
/*  75: 81 */       UsuarioFamilyDAO usuarioFamilyDAO = new UsuarioFamilyDAO();
/*  76: 82 */       usuarioFamilyDAO.updatePasswordEmergencias(usuarioFamily.getUsuf_cod(), String.valueOf(password));
/*  77:    */       
/*  78: 84 */       BeanUtils.copyProperties(form, usuarioFamily);
/*  79:    */       
/*  80: 86 */       DatosPersonalesDAO datosPersonalesDAO = new DatosPersonalesDAO();
/*  81: 87 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  82: 88 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  83: 89 */         datosPersonalesDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  84:    */       }
/*  85: 91 */       DatosPersonales datosPersonales = datosPersonalesDAO.retrive(usuarioFamily.getUsuf_cod());
/*  86:    */       
/*  87: 93 */       request.getSession().setAttribute("datosPersonales", datosPersonales);
/*  88:    */     }
/*  89:    */     catch (Exception e)
/*  90:    */     {
/*  91: 96 */       return mapping.findForward("failure");
/*  92:    */     }
/*  93: 98 */     return mapping.findForward("success");
/*  94:    */   }
/*  95:    */   
/*  96:    */   private ActionForward performView(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  97:    */   {
/*  98:102 */     UsuarioFamilyForm form = (UsuarioFamilyForm)actionForm;
/*  99:    */     try
/* 100:    */     {
/* 101:106 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/* 102:107 */       BeanUtils.copyProperties(form, usuarioFamily);
/* 103:    */       
/* 104:109 */       DatosPersonalesDAO datosPersonalesDAO = new DatosPersonalesDAO();
/* 105:110 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 106:111 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 107:112 */         datosPersonalesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 108:    */       }
/* 109:114 */       DatosPersonales datosPersonales = datosPersonalesDAO.retrive(usuarioFamily.getUsuf_cod());
/* 110:    */       
/* 111:116 */       request.getSession().setAttribute("datosPersonales", datosPersonales);
/* 112:    */       
/* 113:118 */       PaisDAO paisDAO = new PaisDAO();
/* 114:119 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 115:120 */         paisDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 116:    */       }
/* 117:122 */       //paisDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    paisDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 118:123 */       request.setAttribute("pais", paisDAO.retrive(datosPersonales.getDatp_pais_cod()).getPais_des());
/* 119:    */       
/* 120:125 */       CiudadDAO ciudadDAO = new CiudadDAO();
/* 121:126 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 122:127 */         ciudadDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 123:    */       }
/* 124:129 */       //ciudadDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    ciudadDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 125:130 */       request.setAttribute("ciudad", ciudadDAO.retrive(datosPersonales.getDatp_pais_cod(), datosPersonales.getDatp_ciu_cod()).getCiu_des());
/* 126:    */       
/* 127:132 */       DatosPersonalesCompletoDAO datosPersonalesCompletoDAO = new DatosPersonalesCompletoDAO();
/* 128:133 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 129:134 */         datosPersonalesCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 130:    */       }
/* 131:136 */       DatosPersonalesCompleto datosPersonalesCompleto = datosPersonalesCompletoDAO.retrieve(usuarioFamily.getUsuf_cod());
/* 132:    */       
/* 133:138 */       Iterator itContactos = datosPersonalesCompleto.getContactos().iterator();
/* 134:139 */       while (itContactos.hasNext())
/* 135:    */       {
/* 136:140 */         CasoEmergencia contacto = (CasoEmergencia)itContactos.next();
/* 137:141 */         if (contacto.getCase_orden().equals(new BigDecimal(1)))
/* 138:    */         {
/* 139:142 */           request.setAttribute("nombreContacto", contacto.getCase_nombre() + " " + contacto.getCase_apellido());
/* 140:143 */           request.setAttribute(
/* 141:144 */             "telContacto", 
/* 142:    */             
/* 143:    */ 
/* 144:147 */             contacto.getCase_indpais2() + contacto.getCase_telefono2());
/* 145:    */         }
/* 146:    */       }
/* 147:    */     }
/* 148:    */     catch (Exception e)
/* 149:    */     {
/* 150:151 */       e.printStackTrace();
/* 151:152 */       return mapping.findForward("failure");
/* 152:    */     }
/* 153:154 */     return mapping.findForward("success");
/* 154:    */   }
/* 155:    */   
/* 156:    */   private ActionForward performPreview(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 157:    */   {
/* 158:209 */     return mapping.findForward("success");
/* 159:    */   }
/* 160:    */ }



/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\

 * Qualified Name:     com.servidoctor.sdfamily.controller.CarneAction

 * JD-Core Version:    0.7.0.1

 */