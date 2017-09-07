/*   1:    */ package com.servidoctor.sdpets.controller;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.controller.BaseAction;
/*   4:    */ import com.servidoctor.parametros.controller.UsuarioPetsForm;
/*   5:    */ import com.servidoctor.parametros.dao.CiudadDAO;
/*   6:    */ import com.servidoctor.parametros.dao.PaisDAO;
/*   7:    */ import com.servidoctor.parametros.model.Ciudades;
/*   8:    */ import com.servidoctor.parametros.model.Paises;
/*   9:    */ import com.servidoctor.sdpets.dao.PropietariosMascotaDAO;
/*  10:    */ import com.servidoctor.sdpets.model.Mascota;
/*  11:    */ import com.servidoctor.sdpets.model.PropietariosMascota;
/*  12:    */ import com.servidoctor.seguridad.dao.UsuarioPetsDAO;
/*  13:    */ import com.servidoctor.seguridad.model.Servidores;
/*  14:    */ import com.servidoctor.seguridad.model.UsuarioPets;
/*  15:    */ import java.math.BigDecimal;
/*  16:    */ import javax.servlet.http.HttpServletRequest;
/*  17:    */ import javax.servlet.http.HttpServletResponse;
/*  18:    */ import javax.servlet.http.HttpSession;
/*  19:    */ import org.apache.commons.beanutils.BeanUtils;
/*  20:    */ import org.apache.struts.action.ActionForm;
/*  21:    */ import org.apache.struts.action.ActionForward;
/*  22:    */ import org.apache.struts.action.ActionMapping;
/*  23:    */ 
/*  24:    */ public class CarnePetsAction
/*  25:    */   extends BaseAction
/*  26:    */ {
/*  27:    */   public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  28:    */     throws Exception
/*  29:    */   {
/*  30: 33 */     ActionForward myforward = super.execute(mapping, actionForm, request, response);
/*  31: 34 */     String myaction = mapping.getParameter();
/*  32: 36 */     if (myforward == null)
/*  33:    */     {
/*  34: 37 */       Mascota mascota = (Mascota)request.getSession().getAttribute("mascota");
/*  35: 40 */       if (mascota.getMas_usup_cod() == null) {
/*  36: 41 */         myforward = mapping.findForward("mascota");
/*  37: 42 */       } else if ("".equalsIgnoreCase(myaction)) {
/*  38: 43 */         myforward = mapping.findForward("failure");
/*  39: 44 */       } else if ("VIEW".equalsIgnoreCase(myaction)) {
/*  40: 45 */         myforward = performView(mapping, actionForm, request, response);
/*  41: 46 */       } else if ("GENERATE".equalsIgnoreCase(myaction)) {
/*  42: 47 */         myforward = performGenerate(mapping, actionForm, request, response);
/*  43: 48 */       } else if ("PREVIEW".equalsIgnoreCase(myaction)) {
/*  44: 49 */         myforward = performPreview(mapping, actionForm, request, response);
/*  45:    */       } else {
/*  46: 51 */         myforward = mapping.findForward("failure");
/*  47:    */       }
/*  48:    */     }
/*  49: 55 */     return myforward;
/*  50:    */   }
/*  51:    */   
/*  52:    */   private ActionForward performGenerate(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  53:    */   {
/*  54: 59 */     UsuarioPetsForm form = (UsuarioPetsForm)actionForm;
/*  55:    */     try
/*  56:    */     {
/*  57: 62 */       int tam = 0;
/*  58: 63 */       while (tam < 5) {
/*  59: 64 */         tam = 6 + (int)(System.currentTimeMillis() % 5L);
/*  60:    */       }
/*  61: 67 */       char[] password = new char[tam];
/*  62: 69 */       for (int i = 0; i < password.length; i++) {
/*  63: 70 */         while ((password[i] < '0') || ((password[i] > '9') && (password[i] < 'A')) || ((password[i] > 'Z') && (password[i] < 'a')) || (password[i] > 'z'))
/*  64:    */         {
/*  65: 71 */           int current = (int)(Math.random() * 123.0D);
/*  66: 72 */           password[i] = ((char)(current % 123));
/*  67:    */         }
/*  68:    */       }
/*  69: 76 */       UsuarioPets usuarioPets = (UsuarioPets)request.getSession().getAttribute("usuarioPets");
/*  70: 77 */       usuarioPets.setUsup_clave_emer(String.valueOf(password));
/*  71: 78 */       UsuarioPetsDAO usuarioPetsDAO = new UsuarioPetsDAO();
/*  72: 79 */       usuarioPetsDAO.updatePasswordEmergencias(usuarioPets.getUsup_cod(), String.valueOf(password));
/*  73: 80 */       Mascota mascota = new Mascota();
/*  74:    */       
/*  75: 82 */       BeanUtils.copyProperties(form, usuarioPets);
/*  76:    */       
/*  77: 84 */       PropietariosMascotaDAO propietariosMascotaDAO = new PropietariosMascotaDAO();
/*  78: 85 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  79: 86 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  80: 87 */         propietariosMascotaDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  81:    */       }
/*  82: 89 */       PropietariosMascota propietariosMascota = propietariosMascotaDAO.retrieve(mascota.getMas_cod());
/*  83:    */       
/*  84: 91 */       request.getSession().setAttribute("datosPersonales", propietariosMascota);
/*  85: 92 */       request.getSession().setAttribute("propietariosMascota", propietariosMascota);
/*  86:    */     }
/*  87:    */     catch (Exception e)
/*  88:    */     {
/*  89: 95 */       return mapping.findForward("failure");
/*  90:    */     }
/*  91: 97 */     return mapping.findForward("success");
/*  92:    */   }
/*  93:    */   
/*  94:    */   private ActionForward performView(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  95:    */   {
/*  96:101 */     UsuarioPetsForm form = (UsuarioPetsForm)actionForm;
/*  97:    */     try
/*  98:    */     {
/*  99:104 */       Mascota mascota = new Mascota();
/* 100:105 */       UsuarioPets usuarioPets = (UsuarioPets)request.getSession().getAttribute("usuarioPets");
/* 101:106 */       BeanUtils.copyProperties(form, usuarioPets);
/* 102:    */       
/* 103:108 */       PropietariosMascotaDAO propietariosMascotaDAO = new PropietariosMascotaDAO();
/* 104:109 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 105:110 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 106:111 */         propietariosMascotaDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 107:    */       }
/* 108:113 */       PropietariosMascota propietariosMascota = propietariosMascotaDAO.retrieve(mascota.getMas_cod());
/* 109:    */       
/* 110:115 */       request.getSession().setAttribute("propietariosMascota", propietariosMascota);
/* 111:    */       
/* 112:117 */       PaisDAO paisDAO = new PaisDAO();
/* 113:118 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 114:119 */         paisDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 115:    */       }
/* 116:121 */       paisDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 117:122 */       request.setAttribute("pais", paisDAO.retrive(propietariosMascota.getPmas_pais_cod()).getPais_des());
/* 118:    */       
/* 119:124 */       CiudadDAO ciudadDAO = new CiudadDAO();
/* 120:125 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 121:126 */         ciudadDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 122:    */       }
/* 123:128 */       ciudadDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 124:129 */       request.setAttribute("ciudad", ciudadDAO.retrive(propietariosMascota.getPmas_pais_cod(), propietariosMascota.getPmas_ciu_cod()).getCiu_des());
/* 125:    */     }
/* 126:    */     catch (Exception e)
/* 127:    */     {
/* 128:150 */       e.printStackTrace();
/* 129:151 */       return mapping.findForward("failure");
/* 130:    */     }
/* 131:153 */     return mapping.findForward("success");
/* 132:    */   }
/* 133:    */   
/* 134:    */   private ActionForward performPreview(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 135:    */   {
/* 136:157 */     UsuarioPetsForm form = (UsuarioPetsForm)actionForm;
/* 137:    */     try
/* 138:    */     {
/* 139:160 */       UsuarioPets usuarioPets = (UsuarioPets)request.getSession().getAttribute("usuarioPets");
/* 140:161 */       Mascota mascota = (Mascota)request.getSession().getAttribute("mascota");
/* 141:162 */       PropietariosMascotaDAO propietariosMascotaDAO = new PropietariosMascotaDAO();
                    PropietariosMascota propietariosMascota;
/* 142:163 */       propietariosMascota = propietariosMascotaDAO.retrieve(mascota.getMas_cod());
/* 143:    */     }
/* 144:    */     catch (Exception e)
/* 145:    */     {
/* 146:    */       
/* 147:166 */       e.printStackTrace();
/* 148:167 */       return mapping.findForward("failure");
/* 149:    */     }
/* 150:169 */     return mapping.findForward("success");
/* 151:    */   }
/* 152:    */ }



/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\

 * Qualified Name:     com.servidoctor.sdpets.controller.CarnePetsAction

 * JD-Core Version:    0.7.0.1

 */