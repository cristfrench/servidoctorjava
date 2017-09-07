/*   1:    */ package com.servidoctor.sdfamily.controller;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.controller.BaseAction;
/*   4:    */ import com.servidoctor.sdfamily.dao.ControlOtroCompletoDAO;
/*   5:    */ import com.servidoctor.sdfamily.model.ControlOtroCompleto;
/*   6:    */ import com.servidoctor.sdfamily.model.DatosPersonales;
/*   7:    */ import com.servidoctor.seguridad.model.Servidores;
/*   8:    */ import com.servidoctor.seguridad.model.UsuarioFamily;
/*   9:    */ import com.servidoctor.util.classes.BorrarSession;
/*  10:    */ import java.math.BigDecimal;
/*  11:    */ import java.util.List;
/*  12:    */ import javax.servlet.http.HttpServletRequest;
/*  13:    */ import javax.servlet.http.HttpServletResponse;
/*  14:    */ import javax.servlet.http.HttpSession;
/*  15:    */ import org.apache.struts.action.ActionForm;
/*  16:    */ import org.apache.struts.action.ActionForward;
/*  17:    */ import org.apache.struts.action.ActionMapping;
/*  18:    */ 
/*  19:    */ public class ControlOtroAction
/*  20:    */   extends BaseAction
/*  21:    */ {
/*  22:    */   public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  23:    */     throws Exception
/*  24:    */   {
/*  25: 31 */     ActionForward myforward = super.execute(mapping, actionForm, request, response);
/*  26: 32 */     String myaction = mapping.getParameter();
/*  27: 34 */     if (myforward == null)
/*  28:    */     {
/*  29: 35 */       DatosPersonales datosPersonales = (DatosPersonales)request.getSession().getAttribute("datosPersonales");
/*  30: 36 */       if (datosPersonales.getDatp_usuf_cod() == null) {
/*  31: 37 */         myforward = mapping.findForward("datospersonales");
/*  32: 38 */       } else if ("".equalsIgnoreCase(myaction)) {
/*  33: 39 */         myforward = mapping.findForward("failure");
/*  34: 40 */       } else if ("ADD".equalsIgnoreCase(myaction)) {
/*  35: 41 */         myforward = performAdd(mapping, actionForm, request, response);
/*  36: 42 */       } else if ("VIEW".equalsIgnoreCase(myaction)) {
/*  37: 43 */         myforward = performView(mapping, actionForm, request, response);
/*  38: 44 */       } else if ("SAVE".equalsIgnoreCase(myaction)) {
/*  39: 45 */         myforward = performSave(mapping, actionForm, request, response);
/*  40:    */       } else {
/*  41: 47 */         myforward = mapping.findForward("failure");
/*  42:    */       }
/*  43:    */     }
/*  44: 51 */     return myforward;
/*  45:    */   }
/*  46:    */   
/*  47:    */   private ActionForward performView(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  48:    */   {
/*  49: 55 */     ControlOtroPeriodicoForm form = (ControlOtroPeriodicoForm)actionForm;
/*  50:    */     try
/*  51:    */     {
/*  52: 59 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/*  53:    */       
/*  54: 61 */       BorrarSession.eliminaAtributos(request.getSession(), "controlOtroPeriodicoForm");
/*  55: 62 */       ControlOtroCompletoDAO controlOtroCompletoDAO = new ControlOtroCompletoDAO();
/*  56: 63 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  57: 64 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  58: 65 */         controlOtroCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  59:    */       }
/*  60: 67 */       ControlOtroCompleto controlOtroCompleto = controlOtroCompletoDAO.retrieve(usuarioFamily.getUsuf_cod());
/*  61: 68 */       request.getSession().setAttribute("CONTROL_OTRO_PERIODICO", controlOtroCompleto.getControlesPeriodicos());
/*  62: 69 */       request.getSession().setAttribute("CONTROL_OTRO_CONCITA", controlOtroCompleto.getControlesConcita());
/*  63:    */     }
/*  64:    */     catch (Exception e)
/*  65:    */     {
/*  66: 72 */       e.printStackTrace();
/*  67: 73 */       return mapping.findForward("failure");
/*  68:    */     }
/*  69: 75 */     return mapping.findForward("success");
/*  70:    */   }
/*  71:    */   
/*  72:    */   private ActionForward performAdd(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  73:    */   {
/*  74: 79 */     ControlOtroPeriodicoForm form = (ControlOtroPeriodicoForm)actionForm;
/*  75:    */     
/*  76:    */ 
/*  77:    */ 
/*  78:    */ 
/*  79:    */ 
/*  80:    */ 
/*  81:    */ 
/*  82:    */ 
/*  83: 88 */     return mapping.findForward("success");
/*  84:    */   }
/*  85:    */   
/*  86:    */   private ActionForward performSave(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  87:    */   {
/*  88: 92 */     ControlOtroPeriodicoForm form = (ControlOtroPeriodicoForm)actionForm;
/*  89:    */     try
/*  90:    */     {
/*  91: 95 */       List controlesPeriodicos = (List)request.getSession().getAttribute("CONTROL_OTRO_PERIODICO");
/*  92: 96 */       List controlesConcita = (List)request.getSession().getAttribute("CONTROL_OTRO_CONCITA");
/*  93: 97 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/*  94:    */       
/*  95: 99 */       ControlOtroCompleto controlOtroCompleto = new ControlOtroCompleto();
/*  96:100 */       controlOtroCompleto.setControlesPeriodicos(controlesPeriodicos);
/*  97:101 */       controlOtroCompleto.setControlesConcita(controlesConcita);
/*  98:    */       
/*  99:103 */       ControlOtroCompletoDAO controlOtroCompletoDAO = new ControlOtroCompletoDAO();
/* 100:104 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 101:105 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 102:106 */         controlOtroCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 103:    */       }
/* 104:108 */       controlOtroCompletoDAO.update(controlOtroCompleto, usuarioFamily.getUsuf_cod());
/* 105:    */     }
/* 106:    */     catch (Exception e)
/* 107:    */     {
/* 108:111 */       e.printStackTrace();
/* 109:112 */       return mapping.findForward("failure");
/* 110:    */     }
/* 111:114 */     return mapping.findForward("success");
/* 112:    */   }
/* 113:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.controller.ControlOtroAction
 * JD-Core Version:    0.7.0.1
 */