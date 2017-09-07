/*  1:   */ package com.servidoctor.reportes.controller;
/*  2:   */ 
/*  3:   */ import com.servidoctor.fachada.ReportFacade;
/*  4:   */ import javax.servlet.http.HttpServletRequest;
/*  5:   */ import javax.servlet.http.HttpServletResponse;
/*  6:   */ import org.apache.struts.action.Action;
/*  7:   */ import org.apache.struts.action.ActionForm;
/*  8:   */ import org.apache.struts.action.ActionForward;
/*  9:   */ import org.apache.struts.action.ActionMapping;
/* 10:   */ 
/* 11:   */ public class ReportePanelMayorAction
/* 12:   */   extends Action
/* 13:   */ {
/* 14:   */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/* 15:   */     throws Exception
/* 16:   */   {
/* 17:24 */     boolean family = false;
/* 18:25 */     boolean pets = false;
/* 19:26 */     boolean car = false;
/* 20:27 */     String codigoMayor = null;
/* 21:28 */     boolean plain = request.getParameter("archivo").equals("plano");
/* 22:   */     try
/* 23:   */     {
/* 24:32 */       codigoMayor = request.getParameter("codigoMayor");
/* 25:   */       
/* 26:34 */       response.setContentType("application/x-download");
/* 27:35 */       response.setHeader("Content-Disposition", "attachment; filename = " + (plain ? "consultaSDoctor.txt" : "consultaSDoctor.xls"));
/* 28:37 */       if ((family = request.getParameter("report").equals("family"))) {
/* 29:38 */         ReportFacade.consultarUsuariosFamily(response.getOutputStream(), codigoMayor, plain);
/* 30:   */       }
/* 31:39 */       if ((pets = request.getParameter("report").equals("pets"))) {
/* 32:40 */         ReportFacade.consultarUsuariosPets(response.getOutputStream(), codigoMayor, plain);
/* 33:   */       }
/* 34:41 */       if ((car = request.getParameter("report").equals("car"))) {
/* 35:42 */         ReportFacade.consultarUsuariosCar(response.getOutputStream(), codigoMayor, plain);
/* 36:   */       }
/* 37:   */     }
/* 38:   */     catch (Exception e)
/* 39:   */     {
/* 40:46 */       e.printStackTrace();
/* 41:47 */       request.setAttribute("FAILURE", e.getMessage());
/* 42:48 */       return mapping.findForward("failure");
/* 43:   */     }
/* 44:51 */     return null;
/* 45:   */   }
/* 46:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.reportes.controller.ReportePanelMayorAction
 * JD-Core Version:    0.7.0.1
 */