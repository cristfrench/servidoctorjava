/*   1:    */ package com.servidoctor.sdfamily.controller;
/*   2:    */ 
/*   3:    */ import com.servidoctor.constantes.IConstantes;
/*   4:    */ import com.servidoctor.parametros.controller.OptometriaForm;
/*   5:    */ import com.servidoctor.parametros.model.Optometria;
/*   6:    */ import com.servidoctor.seguridad.model.UsuarioFamily;
/*   7:    */ import com.servidoctor.util.classes.InicializaData;
/*   8:    */ import java.math.BigDecimal;
/*   9:    */ import java.util.ArrayList;
/*  10:    */ import java.util.Iterator;
/*  11:    */ import java.util.List;
/*  12:    */ import javax.servlet.http.HttpServletRequest;
/*  13:    */ import javax.servlet.http.HttpServletResponse;
/*  14:    */ import javax.servlet.http.HttpSession;
/*  15:    */ import org.apache.commons.beanutils.BeanUtils;
/*  16:    */ import org.apache.struts.action.Action;
/*  17:    */ import org.apache.struts.action.ActionForm;
/*  18:    */ import org.apache.struts.action.ActionForward;
/*  19:    */ import org.apache.struts.action.ActionMapping;
/*  20:    */ 
/*  21:    */ public class PopupControlesOptomAction
/*  22:    */   extends Action
/*  23:    */ {
/*  24:    */   public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  25:    */     throws Exception
/*  26:    */   {
/*  27: 26 */     ActionForward myforward = null;
/*  28: 27 */     String myaction = mapping.getParameter();
/*  29: 29 */     if ("".equalsIgnoreCase(myaction)) {
/*  30: 30 */       myforward = mapping.findForward("failure");
/*  31: 31 */     } else if ("TRANSFER_TABLA".equalsIgnoreCase(myaction)) {
/*  32: 32 */       myforward = performTrasf_tabla(mapping, actionForm, request, response);
/*  33: 33 */     } else if ("EDIT_TABLA".equalsIgnoreCase(myaction)) {
/*  34: 34 */       myforward = performEdit_tabla(mapping, actionForm, request, response);
/*  35: 35 */     } else if ("REMOVE_TABLA".equalsIgnoreCase(myaction)) {
/*  36: 36 */       myforward = performRemove_tabla(mapping, actionForm, request, response);
/*  37: 37 */     } else if ("ADD_TABLA".equalsIgnoreCase(myaction)) {
/*  38: 38 */       myforward = performAdd_tabla(mapping, actionForm, request, response);
/*  39:    */     } else {
/*  40: 40 */       myforward = mapping.findForward("failure");
/*  41:    */     }
/*  42: 43 */     return myforward;
/*  43:    */   }
/*  44:    */   
/*  45:    */   private ActionForward performTrasf_tabla(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  46:    */   {
/*  47: 47 */     OptometriaForm form = (OptometriaForm)actionForm;
/*  48:    */     try
/*  49:    */     {
/*  50: 49 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/*  51:    */       
/*  52: 51 */       List opto = new ArrayList();
/*  53: 52 */       Optometria optometria = new Optometria();
/*  54: 53 */       InicializaData.inicializa(optometria.getClass(), optometria);
/*  55: 54 */       BeanUtils.copyProperties(optometria, form);
/*  56: 55 */       optometria.setOpt_usuf_cod(usuarioFamily.getUsuf_cod());
/*  57: 56 */       if (request.getSession().getAttribute("USUARIO_OPTO") != null) {
/*  58: 57 */         opto = (List)request.getSession().getAttribute("USUARIO_OPTO");
/*  59:    */       }
/*  60: 60 */       Iterator it = opto.iterator();
/*  61:    */       
/*  62: 62 */       int desde = optometria.getOpt_aniosdesde().intValue();
/*  63: 63 */       int hasta = optometria.getOpt_anioshasta().intValue();
/*  64: 65 */       while (it.hasNext())
/*  65:    */       {
/*  66: 66 */         Optometria optometriaLista = (Optometria)it.next();
/*  67: 67 */         if (!optometria.getOpt_cod().equals(optometriaLista.getOpt_cod()))
/*  68:    */         {
/*  69: 68 */           if ((desde > optometriaLista.getOpt_aniosdesde().intValue()) && (desde < optometriaLista.getOpt_anioshasta().intValue())) {
/*  70: 69 */             optometria.setOpt_aniosdesde(optometriaLista.getOpt_anioshasta());
/*  71:    */           }
/*  72: 70 */           if ((hasta > optometriaLista.getOpt_aniosdesde().intValue()) && (hasta < optometriaLista.getOpt_anioshasta().intValue())) {
/*  73: 71 */             optometria.setOpt_aniosdesde(optometriaLista.getOpt_anioshasta().add(IConstantes.CODIGO_CONTROL_PROXIMO));
/*  74:    */           }
/*  75: 72 */           if (optometria.getOpt_aniosdesde().intValue() > optometria.getOpt_anioshasta().intValue()) {
/*  76: 73 */             optometria.setOpt_anioshasta(optometria.getOpt_aniosdesde().add(IConstantes.CODIGO_CONTROL_PROXIMO));
/*  77:    */           }
/*  78:    */         }
/*  79:    */       }
/*  80: 77 */       if (request.getParameter("num_tabla") == null) {
/*  81: 78 */         opto.add(optometria);
/*  82:    */       } else {
/*  83: 80 */         opto.set(Integer.parseInt(request.getParameter("num_tabla")), optometria);
/*  84:    */       }
/*  85: 83 */       request.getSession().setAttribute("USUARIO_OPTO", opto);
/*  86:    */     }
/*  87:    */     catch (Exception e)
/*  88:    */     {
/*  89: 87 */       return mapping.findForward("failure");
/*  90:    */     }
/*  91: 90 */     return mapping.findForward("success");
/*  92:    */   }
/*  93:    */   
/*  94:    */   private ActionForward performAdd_tabla(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  95:    */   {
/*  96: 94 */     OptometriaForm form = (OptometriaForm)actionForm;
/*  97:    */     
/*  98:    */ 
/*  99:    */ 
/* 100:    */ 
/* 101:    */ 
/* 102:    */ 
/* 103:101 */     return mapping.findForward("success");
/* 104:    */   }
/* 105:    */   
/* 106:    */   private ActionForward performRemove_tabla(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 107:    */   {
/* 108:105 */     OptometriaForm form = (OptometriaForm)actionForm;
/* 109:    */     try
/* 110:    */     {
/* 111:107 */       List opto = (List)request.getSession().getAttribute("USUARIO_OPTO");
/* 112:108 */       opto.remove(Integer.parseInt(request.getParameter("num_tabla")));
/* 113:    */       
/* 114:110 */       int x = 0;
/* 115:111 */       while (x < opto.size())
/* 116:    */       {
/* 117:112 */         Optometria usuariooptometria = (Optometria)opto.get(x);
/* 118:113 */         usuariooptometria.setOpt_cod(new BigDecimal(x + 1));
/* 119:114 */         opto.set(x, usuariooptometria);
/* 120:115 */         x++;
/* 121:    */       }
/* 122:    */     }
/* 123:    */     catch (Exception e)
/* 124:    */     {
/* 125:119 */       return mapping.findForward("failure");
/* 126:    */     }
/* 127:122 */     return mapping.findForward("success");
/* 128:    */   }
/* 129:    */   
/* 130:    */   private ActionForward performEdit_tabla(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 131:    */   {
/* 132:126 */     OptometriaForm form = (OptometriaForm)actionForm;
/* 133:    */     try
/* 134:    */     {
/* 135:130 */       List opto = (List)request.getSession().getAttribute("USUARIO_OPTO");
/* 136:131 */       Optometria optometria = (Optometria)opto.get(Integer.parseInt(request.getParameter("num_tabla")));
/* 137:132 */       BeanUtils.copyProperties(form, optometria);
/* 138:    */     }
/* 139:    */     catch (Exception e)
/* 140:    */     {
/* 141:136 */       return mapping.findForward("failure");
/* 142:    */     }
/* 143:138 */     return mapping.findForward("success");
/* 144:    */   }
/* 145:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.controller.PopupControlesOptomAction
 * JD-Core Version:    0.7.0.1
 */