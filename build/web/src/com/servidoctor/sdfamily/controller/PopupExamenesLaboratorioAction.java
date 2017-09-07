/*   1:    */ package com.servidoctor.sdfamily.controller;
/*   2:    */ 
/*   3:    */ import com.servidoctor.parametros.model.ExamenesLaboratorio;
/*   4:    */ import com.servidoctor.util.classes.ManejoFechas;
/*   5:    */ import java.math.BigDecimal;
/*   6:    */ import java.util.ArrayList;
/*   7:    */ import java.util.List;
/*   8:    */ import javax.servlet.http.HttpServletRequest;
/*   9:    */ import javax.servlet.http.HttpServletResponse;
/*  10:    */ import javax.servlet.http.HttpSession;
/*  11:    */ import javax.sql.DataSource;
/*  12:    */ import org.apache.commons.beanutils.BeanUtils;
/*  13:    */ import org.apache.struts.action.Action;
/*  14:    */ import org.apache.struts.action.ActionForm;
/*  15:    */ import org.apache.struts.action.ActionForward;
/*  16:    */ import org.apache.struts.action.ActionMapping;
/*  17:    */ 
/*  18:    */ public class PopupExamenesLaboratorioAction
/*  19:    */   extends Action
/*  20:    */ {
/*  21: 21 */   private DataSource ds = null;
/*  22:    */   
/*  23:    */   public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  24:    */     throws Exception
/*  25:    */   {
/*  26: 24 */     ActionForward myforward = null;
/*  27: 25 */     String myaction = mapping.getParameter();
/*  28: 27 */     if ("".equalsIgnoreCase(myaction)) {
/*  29: 28 */       myforward = mapping.findForward("failure");
/*  30: 29 */     } else if ("TRANSFER_CONTROL".equalsIgnoreCase(myaction)) {
/*  31: 30 */       myforward = performTrasf_control(mapping, actionForm, request, response);
/*  32: 31 */     } else if ("EDIT_CONTROL".equalsIgnoreCase(myaction)) {
/*  33: 32 */       myforward = performEdit_control(mapping, actionForm, request, response);
/*  34: 33 */     } else if ("VIEW_CONTROL".equalsIgnoreCase(myaction)) {
/*  35: 34 */       myforward = performView_control(mapping, actionForm, request, response);
/*  36: 35 */     } else if ("REMOVE_CONTROL".equalsIgnoreCase(myaction)) {
/*  37: 36 */       myforward = performRemove_control(mapping, actionForm, request, response);
/*  38: 37 */     } else if ("ADD_CONTROL".equalsIgnoreCase(myaction)) {
/*  39: 38 */       myforward = performAdd_control(mapping, actionForm, request, response);
/*  40:    */     } else {
/*  41: 40 */       myforward = mapping.findForward("failure");
/*  42:    */     }
/*  43: 43 */     return myforward;
/*  44:    */   }
/*  45:    */   
/*  46:    */   private ActionForward performTrasf_control(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  47:    */   {
/*  48: 47 */     ExamenesLaboratorioForm form = (ExamenesLaboratorioForm)actionForm;
/*  49:    */     try
/*  50:    */     {
/*  51: 49 */       List examenes = new ArrayList();
/*  52: 50 */       int num_control = Integer.parseInt(request.getParameter("num_control"));
/*  53:    */       
/*  54:    */ 
/*  55: 53 */       ExamenesLaboratorio examenesLaboratorio = new ExamenesLaboratorio();
/*  56: 54 */       examenesLaboratorio.setElab_des(form.getElab_des());
/*  57: 55 */       examenesLaboratorio.setElab_fecha1(new BigDecimal(ManejoFechas.getChangeFecha(form.getElab_fecha1())));
/*  58: 56 */       examenesLaboratorio.setElab_fecha2(new BigDecimal(ManejoFechas.getChangeFecha(form.getElab_fecha2())));
/*  59: 57 */       examenesLaboratorio.setElab_fecha3(new BigDecimal(ManejoFechas.getChangeFecha(form.getElab_fecha3())));
/*  60: 58 */       examenesLaboratorio.setElab_resultado1(new BigDecimal(form.getElab_resultado1()));
/*  61: 59 */       examenesLaboratorio.setElab_resultado2(new BigDecimal(form.getElab_resultado2()));
/*  62: 60 */       examenesLaboratorio.setElab_resultado3(new BigDecimal(form.getElab_resultado3()));
/*  63:    */       
/*  64: 62 */       examenes = (List)request.getSession().getAttribute("EXAMENESLABORATORIO");
/*  65: 64 */       if (num_control < examenes.size())
/*  66:    */       {
/*  67: 65 */         examenes.set(num_control, examenesLaboratorio);
/*  68: 66 */         request.getSession().setAttribute("EXAMENESLABORATORIO", examenes);
/*  69:    */       }
/*  70:    */       else
/*  71:    */       {
/*  72: 68 */         examenes.add(num_control, examenesLaboratorio);
/*  73: 69 */         request.getSession().setAttribute("EXAMENESLABORATORIO", examenes);
/*  74:    */       }
/*  75:    */     }
/*  76:    */     catch (Exception localException) {}
/*  77: 76 */     return mapping.findForward("success");
/*  78:    */   }
/*  79:    */   
/*  80:    */   private ActionForward performEdit_control(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  81:    */   {
/*  82: 80 */     ExamenesLaboratorioForm form = (ExamenesLaboratorioForm)actionForm;
/*  83:    */     try
/*  84:    */     {
/*  85: 84 */       List examenes = new ArrayList();
/*  86: 85 */       ExamenesLaboratorio examenesLaboratorio = new ExamenesLaboratorio();
/*  87: 86 */       examenes = (List)request.getSession().getAttribute("EXAMENESLABORATORIO");
/*  88: 87 */       int num_control = Integer.parseInt(request.getParameter("num_control"));
/*  89: 88 */       examenesLaboratorio = (ExamenesLaboratorio)examenes.get(num_control);
/*  90: 89 */       request.setAttribute("num_control", num_control);
/*  91:    */       
/*  92: 91 */       BeanUtils.copyProperties(form, examenesLaboratorio);
/*  93: 92 */       form.setElab_fecha1(ManejoFechas.FormateoFecha(form.getElab_fecha1()));
/*  94: 93 */       form.setElab_fecha2(ManejoFechas.FormateoFecha(form.getElab_fecha2()));
/*  95: 94 */       form.setElab_fecha3(ManejoFechas.FormateoFecha(form.getElab_fecha3()));
/*  96:    */     }
/*  97:    */     catch (Exception e)
/*  98:    */     {
/*  99: 98 */       return mapping.findForward("failure");
/* 100:    */     }
/* 101:100 */     return mapping.findForward("success");
/* 102:    */   }
/* 103:    */   
/* 104:    */   private ActionForward performView_control(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 105:    */   {
/* 106:103 */     ExamenesLaboratorioForm form = (ExamenesLaboratorioForm)actionForm;
/* 107:    */     try
/* 108:    */     {
/* 109:106 */       List examenes = new ArrayList();
/* 110:107 */       ExamenesLaboratorio examenesLaboratorio = new ExamenesLaboratorio();
/* 111:108 */       examenes = (List)request.getSession().getAttribute("EXAMENESLABORATORIO");
/* 112:109 */       int num_control = Integer.parseInt(request.getParameter("num_control"));
/* 113:110 */       examenesLaboratorio = (ExamenesLaboratorio)examenes.get(num_control);
/* 114:111 */       request.setAttribute("num_control", num_control);
/* 115:    */       
/* 116:113 */       BeanUtils.copyProperties(form, examenesLaboratorio);
/* 117:114 */       form.setElab_fecha1(ManejoFechas.FormateoFecha(form.getElab_fecha1()));
/* 118:115 */       form.setElab_fecha2(ManejoFechas.FormateoFecha(form.getElab_fecha2()));
/* 119:116 */       form.setElab_fecha3(ManejoFechas.FormateoFecha(form.getElab_fecha3()));
/* 120:    */     }
/* 121:    */     catch (Exception e)
/* 122:    */     {
/* 123:120 */       return mapping.findForward("failure");
/* 124:    */     }
/* 125:122 */     return mapping.findForward("success");
/* 126:    */   }
/* 127:    */   
/* 128:    */   private ActionForward performRemove_control(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 129:    */   {
/* 130:126 */     ExamenesLaboratorioForm form = (ExamenesLaboratorioForm)actionForm;
/* 131:    */     try
/* 132:    */     {
/* 133:130 */       List examenes = new ArrayList();
/* 134:    */       
/* 135:132 */       examenes = (List)request.getSession().getAttribute("EXAMENESLABORATORIO");
/* 136:133 */       int num_control = Integer.parseInt(request.getParameter("num_control"));
/* 137:134 */       examenes.remove(num_control);
/* 138:135 */       request.getSession().setAttribute("EXAMENESLABORATORIO", examenes);
/* 139:    */     }
/* 140:    */     catch (Exception e)
/* 141:    */     {
/* 142:139 */       return mapping.findForward("failure");
/* 143:    */     }
/* 144:141 */     return mapping.findForward("success");
/* 145:    */   }
/* 146:    */   
/* 147:    */   private ActionForward performAdd_control(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 148:    */   {
/* 149:144 */     ExamenesLaboratorioForm form = (ExamenesLaboratorioForm)actionForm;
/* 150:    */     try
/* 151:    */     {
/* 152:147 */       List examenes = new ArrayList();
/* 153:148 */       ExamenesLaboratorio examenesLaboratorio = new ExamenesLaboratorio();
/* 154:149 */       examenes = (List)request.getSession().getAttribute("EXAMENESLABORATORIO");
/* 155:150 */       int num_control = examenes.size();
/* 156:    */       
/* 157:152 */       request.setAttribute("num_control", num_control);
/* 158:    */     }
/* 159:    */     catch (Exception e)
/* 160:    */     {
/* 161:155 */       e.printStackTrace();
/* 162:156 */       return mapping.findForward("failure");
/* 163:    */     }
/* 164:158 */     return mapping.findForward("success");
/* 165:    */   }
/* 166:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.controller.PopupExamenesLaboratorioAction
 * JD-Core Version:    0.7.0.1
 */