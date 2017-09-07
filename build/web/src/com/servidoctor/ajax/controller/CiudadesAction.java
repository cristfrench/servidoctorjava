/*  1:   */ package com.servidoctor.ajax.controller;
/*  2:   */ 
/*  3:   */ import com.servidoctor.parametros.dao.CiudadDAO;
/*  4:   */ import com.servidoctor.seguridad.model.Servidores;
/*  5:   */ import java.math.BigDecimal;
/*  6:   */ import java.util.List;
/*  7:   */ import java.util.Locale;
/*  8:   */ import javax.servlet.http.HttpServletRequest;
/*  9:   */ import javax.servlet.http.HttpServletResponse;
/* 10:   */ import javax.servlet.http.HttpSession;
/* 11:   */ import org.apache.struts.action.Action;
/* 12:   */ import org.apache.struts.action.ActionForm;
/* 13:   */ import org.apache.struts.action.ActionForward;
/* 14:   */ import org.apache.struts.action.ActionMapping;
/* 15:   */ 
/* 16:   */ public class CiudadesAction
/* 17:   */   extends Action
/* 18:   */ {
/* 19:   */   public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 20:   */     throws Exception
/* 21:   */   {

    /* 22:22 */     List ciudades = null;
/* 23:23 */     String pais_cod = request.getParameter("pais_cod");

                
/* 24:24 */     Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 25:   */     
/* 26:26 */     CiudadDAO ciudadesDAO = new CiudadDAO();
/* 27:27 */     if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 28:28 */       ciudadesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 29:   */     }
/* 30:30 */     ciudadesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 31:31 */     ciudades = ciudadesDAO.search(pais_cod);
/* 32:32 */     request.setAttribute("CIUDADES", ciudades);
/* 33:   */     
/* 34:34 */     response.setLocale(new Locale(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2)));
/* 35:   */     
/* 36:36 */     return mapping.findForward("success");
/* 37:   */   }
/* 38:   */ }



/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\

 * Qualified Name:     com.servidoctor.ajax.controller.CiudadesAction

 * JD-Core Version:    0.7.0.1

 */