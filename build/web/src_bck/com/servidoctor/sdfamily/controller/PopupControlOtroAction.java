/*   1:    */ package com.servidoctor.sdfamily.controller;
/*   2:    */ 
/*   3:    */ import com.servidoctor.parametros.dao.CiudadDAO;
/*   4:    */ import com.servidoctor.parametros.dao.PaisDAO;
/*   5:    */ import com.servidoctor.parametros.model.Paises;
/*   6:    */ import com.servidoctor.sdfamily.model.ControlOtroPeriodico;
/*   7:    */ import com.servidoctor.seguridad.model.Servidores;
/*   8:    */ import com.servidoctor.seguridad.model.UsuarioFamily;
/*   9:    */ import com.servidoctor.util.classes.InicializaData;
/*  10:    */ import com.servidoctor.util.classes.ManejoFechas;
/*  11:    */ import java.math.BigDecimal;
/*  12:    */ import java.util.ArrayList;
/*  13:    */ import java.util.List;
/*  14:    */ import javax.servlet.http.HttpServletRequest;
/*  15:    */ import javax.servlet.http.HttpServletResponse;
/*  16:    */ import javax.servlet.http.HttpSession;
/*  17:    */ import org.apache.commons.beanutils.BeanUtils;
/*  18:    */ import org.apache.struts.action.Action;
/*  19:    */ import org.apache.struts.action.ActionForm;
/*  20:    */ import org.apache.struts.action.ActionForward;
/*  21:    */ import org.apache.struts.action.ActionMapping;
/*  22:    */ 
/*  23:    */ public class PopupControlOtroAction
/*  24:    */   extends Action
/*  25:    */ {
/*  26:    */   public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  27:    */     throws Exception
/*  28:    */   {
/*  29: 28 */     ActionForward myforward = null;
/*  30: 29 */     String myaction = mapping.getParameter();
/*  31: 31 */     if ("".equalsIgnoreCase(myaction)) {
/*  32: 32 */       myforward = mapping.findForward("failure");
/*  33: 33 */     } else if ("TRANSFER_CONTROL".equalsIgnoreCase(myaction)) {
/*  34: 34 */       myforward = performTrasf_control(mapping, actionForm, request, response);
/*  35: 35 */     } else if ("EDIT_CONTROL".equalsIgnoreCase(myaction)) {
/*  36: 36 */       myforward = performEdit_control(mapping, actionForm, request, response);
/*  37: 37 */     } else if ("ADD_CONTROL".equalsIgnoreCase(myaction)) {
/*  38: 38 */       myforward = performAdd_control(mapping, actionForm, request, response);
/*  39: 39 */     } else if ("REMOVE_CONTROL".equalsIgnoreCase(myaction)) {
/*  40: 40 */       myforward = performRemove_control(mapping, actionForm, request, response);
/*  41:    */     } else {
/*  42: 42 */       myforward = mapping.findForward("failure");
/*  43:    */     }
/*  44: 45 */     return myforward;
/*  45:    */   }
/*  46:    */   
/*  47:    */   private ActionForward performTrasf_control(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  48:    */   {
/*  49: 49 */     ControlOtroPeriodicoForm form = (ControlOtroPeriodicoForm)actionForm;
/*  50:    */     try
/*  51:    */     {
/*  52: 51 */       List controlesPeriodicos = null;
/*  53: 52 */       if (request.getSession().getAttribute("CONTROL_OTRO_PERIODICO") != null) {
/*  54: 53 */         controlesPeriodicos = (List)request.getSession().getAttribute("CONTROL_OTRO_PERIODICO");
/*  55:    */       } else {
/*  56: 55 */         controlesPeriodicos = new ArrayList();
/*  57:    */       }
/*  58: 57 */       ControlOtroPeriodico controlOtroPeriodico = new ControlOtroPeriodico();
/*  59:    */       
/*  60: 59 */       InicializaData.inicializa(controlOtroPeriodico.getClass(), controlOtroPeriodico);
/*  61: 61 */       if (form.getCoot_indic_pais().length() == 0) {
/*  62: 62 */         form.setCoot_indic_pais("0");
/*  63:    */       }
/*  64: 63 */       if (form.getCoot_indic_ciudad().length() == 0) {
/*  65: 64 */         form.setCoot_indic_ciudad("0");
/*  66:    */       }
/*  67: 67 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/*  68:    */       
/*  69: 69 */       BeanUtils.copyProperties(controlOtroPeriodico, form);
/*  70: 71 */       if (request.getParameter("num_control") != null) {
/*  71: 72 */         controlesPeriodicos.set(Integer.parseInt(request.getParameter("num_control")), controlOtroPeriodico);
/*  72:    */       } else {
/*  73: 74 */         controlesPeriodicos.add(controlOtroPeriodico);
/*  74:    */       }
/*  75: 77 */       request.getSession().setAttribute("CONTROL_OTRO_PERIODICO", controlesPeriodicos);
/*  76:    */     }
/*  77:    */     catch (Exception e)
/*  78:    */     {
/*  79: 80 */       return mapping.findForward("failure");
/*  80:    */     }
/*  81: 83 */     return mapping.findForward("success");
/*  82:    */   }
/*  83:    */   
/*  84:    */   private ActionForward performEdit_control(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  85:    */   {
/*  86: 87 */     ControlOtroPeriodicoForm form = (ControlOtroPeriodicoForm)actionForm;
/*  87:    */     try
/*  88:    */     {
/*  89: 91 */       List controlesPeriodicos = (List)request.getSession().getAttribute("CONTROL_OTRO_PERIODICO");
/*  90: 92 */       ControlOtroPeriodico controlOtroPeriodico = (ControlOtroPeriodico)controlesPeriodicos.get(Integer.parseInt(request.getParameter("num_control")));
/*  91: 94 */       if (request.getParameter("change") == null) {
/*  92: 95 */         BeanUtils.copyProperties(form, controlOtroPeriodico);
/*  93:    */       }
/*  94: 96 */       form.setCoot_fecha_ini(ManejoFechas.FormateoFecha(form.getCoot_fecha_ini()));
/*  95: 97 */       form.setCoot_fecha_fin(ManejoFechas.FormateoFecha(form.getCoot_fecha_fin()));
/*  96:    */       
/*  97: 99 */       PaisDAO paisDAO = new PaisDAO();
/*  98:100 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  99:101 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 100:102 */         paisDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 101:    */       }
/* 102:104 */       //paisDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    paisDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
                    
/* 103:105 */       List paises = paisDAO.list();
/* 104:106 */       request.setAttribute("PAISES", paises);
/* 105:    */       
/* 106:108 */       List ciudades = null;
/* 107:109 */       CiudadDAO ciudadesDAO = new CiudadDAO();
/* 108:110 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 109:111 */         ciudadesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 110:    */       }
/* 111:113 */       //ciudadesDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    ciudadesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
                    
/* 112:114 */       if ((paises.size() > 0) && (!form.getCoot_pais_cod().equals("0"))) {
/* 113:115 */         ciudades = ciudadesDAO.search(form.getCoot_pais_cod());
/* 114:116 */       } else if (paises.size() > 0) {
/* 115:117 */         ciudades = ciudadesDAO.search(((Paises)paises.get(0)).getPais_cod().toString());
/* 116:    */       }
/* 117:119 */       request.setAttribute("CIUDADES", ciudades);
/* 118:    */     }
/* 119:    */     catch (Exception e)
/* 120:    */     {
/* 121:122 */       return mapping.findForward("failure");
/* 122:    */     }
/* 123:124 */     return mapping.findForward("success");
/* 124:    */   }
/* 125:    */   
/* 126:    */   private ActionForward performAdd_control(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 127:    */   {
/* 128:128 */     ControlOtroPeriodicoForm form = (ControlOtroPeriodicoForm)actionForm;
/* 129:    */     try
/* 130:    */     {
/* 131:132 */       form.setCoot_fecha_ini(ManejoFechas.FormateoFecha(form.getCoot_fecha_ini()));
/* 132:133 */       form.setCoot_fecha_fin(ManejoFechas.FormateoFecha(form.getCoot_fecha_fin()));
/* 133:    */       
/* 134:135 */       PaisDAO paisDAO = new PaisDAO();
/* 135:136 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 136:137 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 137:138 */         paisDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 138:    */       }
/* 139:140 */       //paisDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    paisDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
                    
/* 140:141 */       List paises = paisDAO.list();
/* 141:142 */       request.setAttribute("PAISES", paises);
/* 142:    */       
/* 143:144 */       List ciudades = null;
/* 144:145 */       CiudadDAO ciudadesDAO = new CiudadDAO();
/* 145:146 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 146:147 */         ciudadesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 147:    */       }
/* 148:149 */       //ciudadesDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    ciudadesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
                    
/* 149:150 */       if ((paises.size() > 0) && (!form.getCoot_pais_cod().equals("0"))) {
/* 150:151 */         ciudades = ciudadesDAO.search(form.getCoot_pais_cod());
/* 151:152 */       } else if (paises.size() > 0) {
/* 152:153 */         ciudades = ciudadesDAO.search(((Paises)paises.get(0)).getPais_cod().toString());
/* 153:    */       }
/* 154:155 */       request.setAttribute("CIUDADES", ciudades);
/* 155:    */     }
/* 156:    */     catch (Exception e)
/* 157:    */     {
/* 158:158 */       return mapping.findForward("failure");
/* 159:    */     }
/* 160:160 */     return mapping.findForward("success");
/* 161:    */   }
/* 162:    */   
/* 163:    */   private ActionForward performRemove_control(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 164:    */   {
/* 165:164 */     ControlOtroPeriodicoForm form = (ControlOtroPeriodicoForm)actionForm;
/* 166:    */     try
/* 167:    */     {
/* 168:167 */       List controlesPeriodicos = new ArrayList();
/* 169:168 */       controlesPeriodicos = (List)request.getSession().getAttribute("CONTROL_OTRO_PERIODICO");
/* 170:169 */       controlesPeriodicos.remove(Integer.parseInt(request.getParameter("num_control")));
/* 171:170 */       int x = 0;
/* 172:171 */       while (x < controlesPeriodicos.size())
/* 173:    */       {
/* 174:172 */         ControlOtroPeriodico controlOtroPeriodico = (ControlOtroPeriodico)controlesPeriodicos.get(x);
/* 175:173 */         controlOtroPeriodico.setCoot_cod(new BigDecimal(x + 1));
/* 176:174 */         controlesPeriodicos.set(x, controlOtroPeriodico);
/* 177:175 */         x++;
/* 178:    */       }
/* 179:    */     }
/* 180:    */     catch (Exception e)
/* 181:    */     {
/* 182:178 */       e.printStackTrace();
/* 183:179 */       return mapping.findForward("failure");
/* 184:    */     }
/* 185:181 */     return mapping.findForward("success");
/* 186:    */   }
/* 187:    */ }



/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\

 * Qualified Name:     com.servidoctor.sdfamily.controller.PopupControlOtroAction

 * JD-Core Version:    0.7.0.1

 */