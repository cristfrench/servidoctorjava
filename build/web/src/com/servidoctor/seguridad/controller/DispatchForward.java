/*  1:   */ package com.servidoctor.seguridad.controller;
/*  2:   */ 
/*  3:   */ import javax.servlet.http.HttpServletRequest;
/*  4:   */ import javax.servlet.http.HttpServletResponse;
/*  5:   */ import org.apache.struts.action.Action;
/*  6:   */ import org.apache.struts.action.ActionError;
/*  7:   */ import org.apache.struts.action.ActionErrors;
/*  8:   */ import org.apache.struts.action.ActionForm;
/*  9:   */ import org.apache.struts.action.ActionForward;
/* 10:   */ import org.apache.struts.action.ActionMapping;
/* 11:   */ 
/* 12:   */ public final class DispatchForward
/* 13:   */   extends Action
/* 14:   */ {
/* 15:   */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/* 16:   */   {
/* 17:33 */     if (isCancelled(request))
/* 18:   */     {
/* 19:34 */       form.reset(mapping, request);
/* 20:35 */       return mapping.findForward("cancel");
/* 21:   */     }
/* 22:39 */     ActionForward thisForward = null;
/* 23:40 */     String wantForward = null;
/* 24:   */     
/* 25:   */ 
/* 26:43 */     wantForward = mapping.getParameter();
/* 27:46 */     if (wantForward == null) {
/* 28:47 */       wantForward = request.getParameter("forward");
/* 29:   */     }
/* 30:51 */     if (wantForward != null) {
/* 31:52 */       thisForward = mapping.findForward(wantForward);
/* 32:   */     }
/* 33:56 */     if (thisForward == null)
/* 34:   */     {
/* 35:57 */       thisForward = mapping.findForward("error");
/* 36:58 */       ActionErrors errors = new ActionErrors();
/* 37:59 */       errors.add("org.apache.struts.action.GLOBAL_ERROR", 
/* 38:60 */         new ActionError("action.missing.parameter"));
/* 39:61 */       saveErrors(request, errors);
/* 40:   */     }
/* 41:64 */     return thisForward;
/* 42:   */   }
/* 43:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.seguridad.controller.DispatchForward
 * JD-Core Version:    0.7.0.1
 */