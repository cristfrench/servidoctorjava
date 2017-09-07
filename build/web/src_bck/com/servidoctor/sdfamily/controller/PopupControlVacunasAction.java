/*   1:    */ package com.servidoctor.sdfamily.controller;
/*   2:    */ 
/*   3:    */ import com.servidoctor.parametros.dao.VacunasDAO;
/*   4:    */ import com.servidoctor.parametros.model.Vacunas;
/*   5:    */ import com.servidoctor.sdfamily.model.VacunasUsuario;
/*   6:    */ import com.servidoctor.seguridad.model.Servidores;
/*   7:    */ import com.servidoctor.seguridad.model.UsuarioFamily;
/*   8:    */ import com.servidoctor.util.classes.InicializaData;
/*   9:    */ import java.math.BigDecimal;
/*  10:    */ import java.util.ArrayList;
/*  11:    */ import java.util.Iterator;
/*  12:    */ import java.util.List;
/*  13:    */ import javax.servlet.http.HttpServletRequest;
/*  14:    */ import javax.servlet.http.HttpServletResponse;
/*  15:    */ import javax.servlet.http.HttpSession;
/*  16:    */ import org.apache.commons.beanutils.BeanUtils;
/*  17:    */ import org.apache.struts.action.Action;
/*  18:    */ import org.apache.struts.action.ActionForm;
/*  19:    */ import org.apache.struts.action.ActionForward;
/*  20:    */ import org.apache.struts.action.ActionMapping;
/*  21:    */ 
/*  22:    */ public class PopupControlVacunasAction
/*  23:    */   extends Action
/*  24:    */ {
/*  25:    */   public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  26:    */     throws Exception
/*  27:    */   {
/*  28: 34 */     ActionForward myforward = null;
/*  29: 35 */     String myaction = mapping.getParameter();
/*  30: 36 */     if ("".equalsIgnoreCase(myaction)) {
/*  31: 37 */       myforward = mapping.findForward("failure");
/*  32: 38 */     } else if ("TRANSFER_CONTROL".equalsIgnoreCase(myaction)) {
/*  33: 39 */       myforward = performTrasf_control(mapping, actionForm, request, response);
/*  34: 40 */     } else if ("ADD_CONTROL".equalsIgnoreCase(myaction)) {
/*  35: 41 */       myforward = performAdd_control(mapping, actionForm, request, response);
/*  36: 42 */     } else if ("REMOVE_CONTROL".equalsIgnoreCase(myaction)) {
/*  37: 43 */       myforward = performRemove_control(mapping, actionForm, request, response);
/*  38:    */     } else {
/*  39: 45 */       myforward = mapping.findForward("failure");
/*  40:    */     }
/*  41: 47 */     return myforward;
/*  42:    */   }
/*  43:    */   
/*  44:    */   private ActionForward performAdd_control(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  45:    */   {
/*  46: 51 */     VacunasUsuarioForm form = (VacunasUsuarioForm)actionForm;
/*  47:    */     try
/*  48:    */     {
/*  49: 54 */       VacunasDAO vacunasDAO = new VacunasDAO();
/*  50: 55 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  51: 56 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  52: 57 */         vacunasDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  53:    */       }
/*  54: 59 */       //vacunasDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    vacunasDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
                    
/*  55: 60 */       List listVacunas = vacunasDAO.list();
/*  56:    */       
/*  57: 62 */       List vacunasUsuario = (List)request.getSession().getAttribute("USUARIO_VACUNAS");
/*  58: 63 */       Vacunas vacunaTemp = new Vacunas();
/*  59: 64 */       for (Iterator iter = vacunasUsuario.iterator(); iter.hasNext();)
/*  60:    */       {
/*  61: 65 */         VacunasUsuario vacunaUsuario = (VacunasUsuario)iter.next();
/*  62: 66 */         vacunaTemp.setVac_cod(vacunaUsuario.getVacu_vac_cod());
/*  63: 67 */         listVacunas.remove(vacunaTemp);
/*  64:    */       }
/*  65: 70 */       request.setAttribute("LISTAUNIVERSAL", listVacunas);
/*  66:    */     }
/*  67:    */     catch (Exception e)
/*  68:    */     {
/*  69: 73 */       return mapping.findForward("failure");
/*  70:    */     }
/*  71: 75 */     return mapping.findForward("success");
/*  72:    */   }
/*  73:    */   
/*  74:    */   private ActionForward performTrasf_control(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  75:    */   {
/*  76: 79 */     VacunasUsuarioForm form = (VacunasUsuarioForm)actionForm;
/*  77:    */     try
/*  78:    */     {
/*  79: 81 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/*  80:    */       
/*  81: 83 */       List vacunas = new ArrayList();
/*  82: 84 */       VacunasUsuario vacunasUsuario = new VacunasUsuario();
/*  83: 85 */       InicializaData.inicializa(vacunasUsuario.getClass(), vacunasUsuario);
/*  84: 86 */       BeanUtils.copyProperties(vacunasUsuario, form);
/*  85: 87 */       vacunasUsuario.setVacu_usuf_cod(usuarioFamily.getUsuf_cod());
/*  86: 89 */       if (request.getSession().getAttribute("USUARIO_VACUNAS") != null) {
/*  87: 90 */         vacunas = (List)request.getSession().getAttribute("USUARIO_VACUNAS");
/*  88:    */       }
/*  89: 93 */       if (request.getParameter("num_vacuna") == null)
/*  90:    */       {
/*  91: 94 */         vacunasUsuario.setVacu_cod(new BigDecimal(vacunas.size()));
/*  92: 95 */         vacunasUsuario.setVacu_usuf_cod(usuarioFamily.getUsuf_cod());
/*  93: 96 */         vacunas.add(vacunasUsuario);
/*  94:    */       }
/*  95:100 */       request.getSession().setAttribute("USUARIO_VACUNAS", vacunas);
/*  96:    */     }
/*  97:    */     catch (Exception e)
/*  98:    */     {
/*  99:103 */       return mapping.findForward("failure");
/* 100:    */     }
/* 101:105 */     return mapping.findForward("success");
/* 102:    */   }
/* 103:    */   
/* 104:    */   private ActionForward performRemove_control(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 105:    */   {
/* 106:109 */     VacunasUsuarioForm form = (VacunasUsuarioForm)actionForm;
/* 107:    */     try
/* 108:    */     {
/* 109:113 */       List vacunas = new ArrayList();
/* 110:114 */       vacunas = (List)request.getSession().getAttribute("USUARIO_VACUNAS");
/* 111:115 */       vacunas.remove(Integer.parseInt(request.getParameter("num_vacuna")));
/* 112:    */       
/* 113:117 */       int x = 0;
/* 114:118 */       while (x < vacunas.size())
/* 115:    */       {
/* 116:119 */         VacunasUsuario vacunaUsuario = (VacunasUsuario)vacunas.get(x);
/* 117:120 */         vacunaUsuario.setVacu_cod(new BigDecimal(x + 1));
/* 118:121 */         vacunas.set(x, vacunaUsuario);
/* 119:122 */         x++;
/* 120:    */       }
/* 121:    */     }
/* 122:    */     catch (Exception e)
/* 123:    */     {
/* 124:125 */       return mapping.findForward("failure");
/* 125:    */     }
/* 126:127 */     return mapping.findForward("success");
/* 127:    */   }
/* 128:    */ }



/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\

 * Qualified Name:     com.servidoctor.sdfamily.controller.PopupControlVacunasAction

 * JD-Core Version:    0.7.0.1

 */