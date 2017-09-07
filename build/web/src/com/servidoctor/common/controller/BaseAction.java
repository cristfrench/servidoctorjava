/*  1:   */ package com.servidoctor.common.controller;
/*  2:   */ 
/*  3:   */ import javax.servlet.http.HttpServletRequest;
/*  4:   */ import javax.servlet.http.HttpServletResponse;
/*  5:   */ import javax.servlet.http.HttpSession;
/*  6:   */ import org.apache.struts.action.Action;
/*  7:   */ import org.apache.struts.action.ActionForm;
/*  8:   */ import org.apache.struts.action.ActionForward;
/*  9:   */ import org.apache.struts.action.ActionMapping;
/* 10:   */ 
/* 11:   */ public class BaseAction
/* 12:   */   extends Action
/* 13:   */ {
/* 14:   */   public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 15:   */     throws Exception
/* 16:   */   {
/* 17:13 */     ActionForward myforward = null;
/* 18:15 */     if ((request.getSession().getAttribute("usuarioFamily") == null) && (request.getSession().getAttribute("usuarioPets") == null) && (request.getSession().getAttribute("usuarioCar") == null)) {
/* 19:16 */       myforward = mapping.findForward("login");
/* 20:   */     }
/* 21:18 */     return myforward;
/* 22:   */   }
/* 23:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.common.controller.BaseAction
 * JD-Core Version:    0.7.0.1
 */