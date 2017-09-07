/*   1:    */ package com.servidoctor.sdfamily.controller;
/*   2:    */ 
/*   3:    */ import com.servidoctor.parametros.dao.ExamenesLaboratorioDAO;
/*   4:    */ import com.servidoctor.parametros.dao.ResultadoExamenDAO;
/*   5:    */ import com.servidoctor.parametros.model.ExamenesLaboratorio;
/*   6:    */ import com.servidoctor.parametros.model.ResultadoExamen;
/*   7:    */ import com.servidoctor.seguridad.model.Servidores;
/*   8:    */ import com.servidoctor.seguridad.model.UsuarioFamily;
/*   9:    */ import java.math.BigDecimal;
/*  10:    */ import java.util.ArrayList;
/*  11:    */ import java.util.List;
/*  12:    */ import javax.servlet.http.HttpServletRequest;
/*  13:    */ import javax.servlet.http.HttpServletResponse;
/*  14:    */ import javax.servlet.http.HttpSession;
/*  15:    */ import org.apache.struts.action.Action;
/*  16:    */ import org.apache.struts.action.ActionForm;
/*  17:    */ import org.apache.struts.action.ActionForward;
/*  18:    */ import org.apache.struts.action.ActionMapping;
/*  19:    */ 
/*  20:    */ public class ExamenesLaboratorioAction
/*  21:    */   extends Action
/*  22:    */ {
/*  23:    */   public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  24:    */     throws Exception
/*  25:    */   {
/*  26: 26 */     ActionForward myforward = null;
/*  27: 27 */     String myaction = mapping.getParameter();
/*  28: 29 */     if ("".equalsIgnoreCase(myaction)) {
/*  29: 30 */       myforward = mapping.findForward("failure");
/*  30: 31 */     } else if ("EDIT".equalsIgnoreCase(myaction)) {
/*  31: 32 */       myforward = performEdit(mapping, actionForm, request, response);
/*  32: 33 */     } else if ("ADD".equalsIgnoreCase(myaction)) {
/*  33: 34 */       myforward = performAdd(mapping, actionForm, request, response);
/*  34: 35 */     } else if ("VIEW".equalsIgnoreCase(myaction)) {
/*  35: 36 */       myforward = performView(mapping, actionForm, request, response);
/*  36: 37 */     } else if ("SAVE".equalsIgnoreCase(myaction)) {
/*  37: 38 */       myforward = performSave(mapping, actionForm, request, response);
/*  38:    */     } else {
/*  39: 40 */       myforward = mapping.findForward("failure");
/*  40:    */     }
/*  41: 43 */     return myforward;
/*  42:    */   }
/*  43:    */   
/*  44:    */   private ActionForward performEdit(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  45:    */   {
/*  46: 47 */     ExamenesLaboratorioForm form = (ExamenesLaboratorioForm)actionForm;
/*  47:    */     
/*  48:    */ 
/*  49:    */ 
/*  50:    */ 
/*  51:    */ 
/*  52:    */ 
/*  53:    */ 
/*  54:    */ 
/*  55: 56 */     return mapping.findForward("success");
/*  56:    */   }
/*  57:    */   
/*  58:    */   private ActionForward performView(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  59:    */   {
/*  60: 59 */     ExamenesLaboratorioForm form = (ExamenesLaboratorioForm)actionForm;
/*  61:    */     try
/*  62:    */     {
/*  63: 66 */       List examenes = new ArrayList();
/*  64:    */       
/*  65: 68 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/*  66:    */       
/*  67: 70 */       ExamenesLaboratorioDAO examenesLaboratorioDAO = new ExamenesLaboratorioDAO();
/*  68: 71 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  69: 72 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  70: 73 */         examenesLaboratorioDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  71:    */       }
/*  72: 75 */       examenes = examenesLaboratorioDAO.list(usuarioFamily.getUsuf_cod());
/*  73:    */       
/*  74: 77 */       int x = 0;
/*  75: 79 */       if (examenes.size() == 0) {
/*  76: 81 */         examenes = examenesLaboratorioDAO.list(new BigDecimal(1.0D));
/*  77:    */       }
/*  78: 84 */       ResultadoExamenDAO resultadoExamenDAO = new ResultadoExamenDAO();
/*  79: 85 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  80: 86 */         resultadoExamenDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  81:    */       }
/*  82: 89 */       while (x < examenes.size())
/*  83:    */       {
/*  84: 91 */         ExamenesLaboratorio examenesLaboratorio = new ExamenesLaboratorio();
/*  85: 92 */         examenesLaboratorio = (ExamenesLaboratorio)examenes.get(x);
/*  86: 93 */         examenesLaboratorio.setElab_usuf_cod(usuarioFamily.getUsuf_cod());
/*  87: 94 */         examenes.set(x, examenesLaboratorio);
/*  88: 95 */         ResultadoExamen resultadoExamen = new ResultadoExamen();
/*  89: 96 */         resultadoExamen = resultadoExamenDAO.retriveClasificacion(examenesLaboratorio.getElab_cod(), examenesLaboratorio.getElab_resultado1());
/*  90: 97 */         request.setAttribute("clasificacion1" + x, resultadoExamen.getRexa_des());
/*  91: 98 */         request.setAttribute("desde1" + x, resultadoExamen.getRexa_desde());
/*  92: 99 */         request.setAttribute("hasta1" + x, resultadoExamen.getRexa_hasta());
/*  93:    */         
/*  94:101 */         resultadoExamen = resultadoExamenDAO.retriveClasificacion(examenesLaboratorio.getElab_cod(), examenesLaboratorio.getElab_resultado2());
/*  95:102 */         request.setAttribute("clasificacion2" + x, resultadoExamen.getRexa_des());
/*  96:103 */         request.setAttribute("desde2" + x, resultadoExamen.getRexa_desde());
/*  97:104 */         request.setAttribute("hasta2" + x, resultadoExamen.getRexa_hasta());
/*  98:    */         
/*  99:106 */         resultadoExamen = resultadoExamenDAO.retriveClasificacion(examenesLaboratorio.getElab_cod(), examenesLaboratorio.getElab_resultado3());
/* 100:107 */         request.setAttribute("clasificacion3" + x, resultadoExamen.getRexa_des());
/* 101:108 */         request.setAttribute("desde3" + x, resultadoExamen.getRexa_desde());
/* 102:109 */         request.setAttribute("hasta3" + x, resultadoExamen.getRexa_hasta());
/* 103:110 */         x++;
/* 104:    */       }
/* 105:113 */       request.getSession().setAttribute("EXAMENESLABORATORIO", examenes);
/* 106:    */     }
/* 107:    */     catch (Exception e)
/* 108:    */     {
/* 109:117 */       return mapping.findForward("failure");
/* 110:    */     }
/* 111:119 */     return mapping.findForward("success");
/* 112:    */   }
/* 113:    */   
/* 114:    */   private ActionForward performAdd(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 115:    */   {
/* 116:123 */     ExamenesLaboratorioForm form = (ExamenesLaboratorioForm)actionForm;
/* 117:    */     try
/* 118:    */     {
/* 119:126 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/* 120:    */       
/* 121:128 */       List examenes = new ArrayList();
/* 122:129 */       examenes = (List)request.getSession().getAttribute("EXAMENESLABORATORIO");
/* 123:    */       
/* 124:131 */       ResultadoExamenDAO resultadoExamenDAO = new ResultadoExamenDAO();
/* 125:132 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 126:133 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 127:134 */         resultadoExamenDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 128:    */       }
/* 129:137 */       int x = 0;
/* 130:139 */       while (x < examenes.size())
/* 131:    */       {
/* 132:141 */         ExamenesLaboratorio examenesLaboratorio = new ExamenesLaboratorio();
/* 133:142 */         examenesLaboratorio = (ExamenesLaboratorio)examenes.get(x);
/* 134:143 */         examenesLaboratorio.setElab_usuf_cod(usuarioFamily.getUsuf_cod());
/* 135:144 */         examenes.set(x, examenesLaboratorio);
/* 136:145 */         ResultadoExamen resultadoExamen = new ResultadoExamen();
/* 137:146 */         resultadoExamen = resultadoExamenDAO.retriveClasificacion(examenesLaboratorio.getElab_cod(), examenesLaboratorio.getElab_resultado1());
/* 138:147 */         request.setAttribute("clasificacion1" + x, resultadoExamen.getRexa_des());
/* 139:148 */         request.setAttribute("desde1" + x, resultadoExamen.getRexa_desde());
/* 140:149 */         request.setAttribute("hasta1" + x, resultadoExamen.getRexa_hasta());
/* 141:    */         
/* 142:151 */         resultadoExamen = resultadoExamenDAO.retriveClasificacion(examenesLaboratorio.getElab_cod(), examenesLaboratorio.getElab_resultado2());
/* 143:152 */         request.setAttribute("clasificacion2" + x, resultadoExamen.getRexa_des());
/* 144:153 */         request.setAttribute("desde2" + x, resultadoExamen.getRexa_desde());
/* 145:154 */         request.setAttribute("hasta2" + x, resultadoExamen.getRexa_hasta());
/* 146:    */         
/* 147:156 */         resultadoExamen = resultadoExamenDAO.retriveClasificacion(examenesLaboratorio.getElab_cod(), examenesLaboratorio.getElab_resultado3());
/* 148:157 */         request.setAttribute("clasificacion3" + x, resultadoExamen.getRexa_des());
/* 149:158 */         request.setAttribute("desde3" + x, resultadoExamen.getRexa_desde());
/* 150:159 */         request.setAttribute("hasta3" + x, resultadoExamen.getRexa_hasta());
/* 151:160 */         x++;
/* 152:    */       }
/* 153:    */     }
/* 154:    */     catch (Exception localException) {}
/* 155:167 */     return mapping.findForward("success");
/* 156:    */   }
/* 157:    */   
/* 158:    */   private ActionForward performSave(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 159:    */   {
/* 160:171 */     ExamenesLaboratorioForm form = (ExamenesLaboratorioForm)actionForm;
/* 161:    */     try
/* 162:    */     {
/* 163:174 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/* 164:    */       
/* 165:176 */       List examenes = new ArrayList();
/* 166:177 */       examenes = (List)request.getSession().getAttribute("EXAMENESLABORATORIO");
/* 167:    */       
/* 168:179 */       ExamenesLaboratorioDAO examenesLaboratorioDAO = new ExamenesLaboratorioDAO();
/* 169:180 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 170:181 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 171:182 */         examenesLaboratorioDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 172:    */       }
/* 173:185 */       examenesLaboratorioDAO.deleteAll(usuarioFamily.getUsuf_cod());
/* 174:    */       
/* 175:187 */       int x = 0;
/* 176:189 */       while (x < examenes.size())
/* 177:    */       {
/* 178:190 */         ExamenesLaboratorio examenesLaboratorio = new ExamenesLaboratorio();
/* 179:191 */         examenesLaboratorio = (ExamenesLaboratorio)examenes.get(x);
/* 180:192 */         examenesLaboratorio.setElab_usuf_cod(usuarioFamily.getUsuf_cod());
/* 181:    */         
/* 182:194 */         examenesLaboratorioDAO.insert(examenesLaboratorio);
/* 183:    */         
/* 184:    */ 
/* 185:197 */         x++;
/* 186:    */       }
/* 187:    */     }
/* 188:    */     catch (Exception e)
/* 189:    */     {
/* 190:202 */       return mapping.findForward("failure");
/* 191:    */     }
/* 192:204 */     return mapping.findForward("success");
/* 193:    */   }
/* 194:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.controller.ExamenesLaboratorioAction
 * JD-Core Version:    0.7.0.1
 */