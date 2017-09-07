/*   1:    */ package com.servidoctor.sdfamily.controller;
/*   2:    */ 
/*   3:    */ import com.essecorp.util.GestorFechasCompleto;
/*   4:    */ import com.servidoctor.parametros.dao.CiudadDAO;
/*   5:    */ import com.servidoctor.parametros.dao.PaisDAO;
/*   6:    */ import com.servidoctor.parametros.model.Paises;
/*   7:    */ import com.servidoctor.sdfamily.model.ControlOtroConcita;
/*   8:    */ import com.servidoctor.seguridad.model.Servidores;
/*   9:    */ import com.servidoctor.seguridad.model.UsuarioFamily;
/*  10:    */ import com.servidoctor.util.classes.InicializaData;
/*  11:    */ import com.servidoctor.util.classes.ManejoFechas;
/*  12:    */ import java.math.BigDecimal;
/*  13:    */ import java.util.ArrayList;
/*  14:    */ import java.util.List;
/*  15:    */ import javax.servlet.http.HttpServletRequest;
/*  16:    */ import javax.servlet.http.HttpServletResponse;
/*  17:    */ import javax.servlet.http.HttpSession;
/*  18:    */ import org.apache.commons.beanutils.BeanUtils;
/*  19:    */ import org.apache.struts.action.Action;
/*  20:    */ import org.apache.struts.action.ActionForm;
/*  21:    */ import org.apache.struts.action.ActionForward;
/*  22:    */ import org.apache.struts.action.ActionMapping;
/*  23:    */ 
/*  24:    */ public class PopupControlOtroConcitaAction
/*  25:    */   extends Action
/*  26:    */ {
/*  27:    */   public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  28:    */     throws Exception
/*  29:    */   {
/*  30: 29 */     ActionForward myforward = null;
/*  31: 30 */     String myaction = mapping.getParameter();
/*  32: 32 */     if ("".equalsIgnoreCase(myaction)) {
/*  33: 33 */       myforward = mapping.findForward("failure");
/*  34: 34 */     } else if ("TRANSFER_CONTROL".equalsIgnoreCase(myaction)) {
/*  35: 35 */       myforward = performTrasf_control(mapping, actionForm, request, response);
/*  36: 36 */     } else if ("EDIT_CONTROL".equalsIgnoreCase(myaction)) {
/*  37: 37 */       myforward = performEdit_control(mapping, actionForm, request, response);
/*  38: 38 */     } else if ("ADD_CONTROL".equalsIgnoreCase(myaction)) {
/*  39: 39 */       myforward = performAdd_control(mapping, actionForm, request, response);
/*  40: 40 */     } else if ("REMOVE_CONTROL".equalsIgnoreCase(myaction)) {
/*  41: 41 */       myforward = performRemove_control(mapping, actionForm, request, response);
/*  42:    */     } else {
/*  43: 43 */       myforward = mapping.findForward("failure");
/*  44:    */     }
/*  45: 46 */     return myforward;
/*  46:    */   }
/*  47:    */   
/*  48:    */   private ActionForward performTrasf_control(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  49:    */   {
/*  50: 50 */     ControlOtroConcitaForm form = (ControlOtroConcitaForm)actionForm;
/*  51:    */     try
/*  52:    */     {
/*  53: 52 */       List controlesConcita = null;
/*  54: 53 */       if (request.getSession().getAttribute("CONTROL_OTRO_CONCITA") != null) {
/*  55: 54 */         controlesConcita = (List)request.getSession().getAttribute("CONTROL_OTRO_CONCITA");
/*  56:    */       } else {
/*  57: 56 */         controlesConcita = new ArrayList();
/*  58:    */       }
/*  59: 58 */       ControlOtroConcita controlOtroConcita = new ControlOtroConcita();
/*  60: 59 */       InicializaData.inicializa(controlOtroConcita.getClass(), controlOtroConcita);
/*  61: 61 */       if (form.getCootc_indic_pais().length() == 0) {
/*  62: 62 */         form.setCootc_indic_pais("0");
/*  63:    */       }
/*  64: 63 */       if (form.getCootc_indic_ciudad().length() == 0) {
/*  65: 64 */         form.setCootc_indic_ciudad("0");
/*  66:    */       }
/*  67: 67 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/*  68: 68 */       String fechaActual = ManejoFechas.getFechaActual().toString();
/*  69: 72 */       if (request.getParameter("num_control") != null)
/*  70:    */       {
/*  71: 73 */         if (controlOtroConcita.getCootc_fecha().toString().compareTo(fechaActual) < 0)
/*  72:    */         {
/*  73: 74 */           controlOtroConcita.setCootc_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(form.getCootc_fecha().toString()), "yyyyMMdd", -2)));
/*  74: 75 */           controlOtroConcita.setCootc_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(form.getCootc_fecha().toString()), "yyyyMMdd", 15)));
/*  75: 76 */           form.setCootc_fecenvio2(controlOtroConcita.getCootc_fecenvio2().toString());
/*  76: 77 */           form.setCootc_quince_dias(controlOtroConcita.getCootc_quince_dias().toString());
/*  77:    */         }
/*  78: 79 */         controlesConcita.set(Integer.parseInt(request.getParameter("num_control")), controlOtroConcita);
/*  79:    */       }
/*  80:    */       else
/*  81:    */       {
/*  82: 81 */         if (controlOtroConcita.getCootc_fecha().toString().compareTo(fechaActual) < 0)
/*  83:    */         {
/*  84: 82 */           controlOtroConcita.setCootc_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(form.getCootc_fecha().toString()), "yyyyMMdd", -2)));
/*  85: 83 */           controlOtroConcita.setCootc_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(form.getCootc_fecha().toString()), "yyyyMMdd", 15)));
/*  86: 84 */           form.setCootc_fecenvio2(controlOtroConcita.getCootc_fecenvio2().toString());
/*  87: 85 */           form.setCootc_quince_dias(controlOtroConcita.getCootc_quince_dias().toString());
/*  88:    */         }
/*  89: 87 */         controlesConcita.add(controlOtroConcita);
/*  90:    */       }
/*  91: 89 */       BeanUtils.copyProperties(controlOtroConcita, form);
/*  92: 90 */       request.getSession().setAttribute("CONTROL_OTRO_CONCITA", controlesConcita);
/*  93:    */     }
/*  94:    */     catch (Exception e)
/*  95:    */     {
/*  96: 93 */       return mapping.findForward("failure");
/*  97:    */     }
/*  98: 96 */     return mapping.findForward("success");
/*  99:    */   }
/* 100:    */   
/* 101:    */   private ActionForward performEdit_control(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 102:    */   {
/* 103:100 */     ControlOtroConcitaForm form = (ControlOtroConcitaForm)actionForm;
/* 104:    */     try
/* 105:    */     {
/* 106:104 */       List controlesConcita = (List)request.getSession().getAttribute("CONTROL_OTRO_CONCITA");
/* 107:105 */       ControlOtroConcita controlOtroConcita = (ControlOtroConcita)controlesConcita.get(Integer.parseInt(request.getParameter("num_control")));
/* 108:107 */       if (request.getParameter("change") == null) {
/* 109:108 */         BeanUtils.copyProperties(form, controlOtroConcita);
/* 110:    */       }
/* 111:109 */       form.setCootc_fecha(ManejoFechas.FormateoFecha(form.getCootc_fecha()));
/* 112:110 */       form.setCootc_hora(ManejoFechas.FormateoHoraAMPM(form.getCootc_hora()));
/* 113:    */       
/* 114:    */ 
/* 115:113 */       PaisDAO paisDAO = new PaisDAO();
/* 116:114 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 117:115 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 118:116 */         paisDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 119:    */       }
/* 120:118 */       //paisDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    paisDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
                    
/* 121:119 */       List paises = paisDAO.list();
/* 122:120 */       request.setAttribute("PAISES", paises);
/* 123:    */       
/* 124:122 */       List ciudades = null;
/* 125:123 */       CiudadDAO ciudadesDAO = new CiudadDAO();
/* 126:124 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 127:125 */         ciudadesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 128:    */       }
/* 129:127 */       //ciudadesDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    ciudadesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
                    
/* 130:128 */       if ((paises.size() > 0) && (!form.getCootc_pais_cod().equals("0"))) {
/* 131:129 */         ciudades = ciudadesDAO.search(form.getCootc_pais_cod());
/* 132:130 */       } else if (paises.size() > 0) {
/* 133:131 */         ciudades = ciudadesDAO.search(((Paises)paises.get(0)).getPais_cod().toString());
/* 134:    */       }
/* 135:133 */       request.setAttribute("CIUDADES", ciudades);
/* 136:    */     }
/* 137:    */     catch (Exception e)
/* 138:    */     {
/* 139:136 */       return mapping.findForward("failure");
/* 140:    */     }
/* 141:138 */     return mapping.findForward("success");
/* 142:    */   }
/* 143:    */   
/* 144:    */   private ActionForward performAdd_control(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 145:    */   {
/* 146:142 */     ControlOtroConcitaForm form = (ControlOtroConcitaForm)actionForm;
/* 147:    */     try
/* 148:    */     {
/* 149:146 */       form.setCootc_fecha(ManejoFechas.FormateoFecha(form.getCootc_fecha()));
/* 150:    */       
/* 151:148 */       PaisDAO paisDAO = new PaisDAO();
/* 152:149 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 153:150 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 154:151 */         paisDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 155:    */       }
/* 156:153 */       //paisDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    paisDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
                    
/* 157:154 */       List paises = paisDAO.list();
/* 158:155 */       request.setAttribute("PAISES", paises);
/* 159:    */       
/* 160:157 */       List ciudades = null;
/* 161:158 */       CiudadDAO ciudadesDAO = new CiudadDAO();
/* 162:159 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 163:160 */         ciudadesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 164:    */       }
/* 165:162 */       //ciudadesDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    ciudadesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 166:163 */       if ((paises.size() > 0) && (!form.getCootc_pais_cod().equals("0"))) {
/* 167:164 */         ciudades = ciudadesDAO.search(form.getCootc_pais_cod());
/* 168:165 */       } else if (paises.size() > 0) {
/* 169:166 */         ciudades = ciudadesDAO.search(((Paises)paises.get(0)).getPais_cod().toString());
/* 170:    */       }
/* 171:168 */       request.setAttribute("CIUDADES", ciudades);
/* 172:    */     }
/* 173:    */     catch (Exception e)
/* 174:    */     {
/* 175:171 */       return mapping.findForward("failure");
/* 176:    */     }
/* 177:173 */     return mapping.findForward("success");
/* 178:    */   }
/* 179:    */   
/* 180:    */   private ActionForward performRemove_control(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 181:    */   {
/* 182:177 */     ControlOtroConcitaForm form = (ControlOtroConcitaForm)actionForm;
/* 183:    */     try
/* 184:    */     {
/* 185:180 */       List controlesConcita = new ArrayList();
/* 186:181 */       controlesConcita = (List)request.getSession().getAttribute("CONTROL_OTRO_CONCITA");
/* 187:182 */       controlesConcita.remove(Integer.parseInt(request.getParameter("num_control")));
/* 188:183 */       int x = 0;
/* 189:184 */       while (x < controlesConcita.size())
/* 190:    */       {
/* 191:185 */         ControlOtroConcita controlOtroConcita = (ControlOtroConcita)controlesConcita.get(x);
/* 192:186 */         controlOtroConcita.setCootc_cod(new BigDecimal(x + 1));
/* 193:187 */         controlesConcita.set(x, controlOtroConcita);
/* 194:188 */         x++;
/* 195:    */       }
/* 196:    */     }
/* 197:    */     catch (Exception e)
/* 198:    */     {
/* 199:191 */       e.printStackTrace();
/* 200:192 */       return mapping.findForward("failure");
/* 201:    */     }
/* 202:194 */     return mapping.findForward("success");
/* 203:    */   }
/* 204:    */ }



/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\

 * Qualified Name:     com.servidoctor.sdfamily.controller.PopupControlOtroConcitaAction

 * JD-Core Version:    0.7.0.1

 */