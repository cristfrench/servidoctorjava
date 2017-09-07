/*   1:    */ package com.servidoctor.sdfamily.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdfamily.model.ControlOtroCompleto;
/*   5:    */ import com.servidoctor.sdfamily.model.ControlOtroConcita;
/*   6:    */ import com.servidoctor.sdfamily.model.ControlOtroPeriodico;
/*   7:    */ import java.math.BigDecimal;
/*   8:    */ import java.util.Collection;
/*   9:    */ import java.util.HashMap;
/*  10:    */ import java.util.Iterator;
/*  11:    */ import java.util.List;
/*  12:    */ import java.util.Map;
/*  13:    */ 
/*  14:    */ public class ControlOtroCompletoDAO
/*  15:    */   extends DAO
/*  16:    */ {
/*  17:    */   public void update(ControlOtroCompleto controlOtroCompleto, BigDecimal usuf_cod)
/*  18:    */     throws Exception
/*  19:    */   {
/*  20:    */     try
/*  21:    */     {
/*  22: 27 */       String[] llavesControles = { "coot_cod", "coot_usuf_cod" };
/*  23: 28 */       ControlOtroPeriodicoDAO controlOtroPeriodicoDAO = new ControlOtroPeriodicoDAO();
/*  24: 29 */       controlOtroPeriodicoDAO.setServerNumber(this.serverNumber);
/*  25: 30 */       List controlesPeriodicosBase = controlOtroPeriodicoDAO.list(usuf_cod);
/*  26:    */       
/*  27: 32 */       Map controlesPeriodicosBaseMap = new HashMap();
/*  28: 33 */       for (Iterator it = controlesPeriodicosBase.iterator(); it.hasNext();)
/*  29:    */       {
/*  30: 34 */         ControlOtroPeriodico controlOtroPeriodico = (ControlOtroPeriodico)it.next();
/*  31: 35 */         controlesPeriodicosBaseMap.put(controlOtroPeriodico.getCoot_cod(), controlOtroPeriodico);
/*  32:    */       }
/*  33: 38 */       for (Iterator it = controlOtroCompleto.getControlesPeriodicos().iterator(); it.hasNext();)
/*  34:    */       {
/*  35: 39 */         ControlOtroPeriodico controlOtroPeriodico = (ControlOtroPeriodico)it.next();
/*  36: 40 */         controlOtroPeriodico.setCoot_usuf_cod(usuf_cod);
/*  37: 41 */         if (controlesPeriodicosBaseMap.containsKey(controlOtroPeriodico.getCoot_cod()))
/*  38:    */         {
/*  39: 42 */           controlOtroPeriodicoDAO.update(controlOtroPeriodico, llavesControles);
/*  40: 43 */           controlesPeriodicosBaseMap.remove(controlOtroPeriodico.getCoot_cod());
/*  41:    */         }
/*  42:    */         else
/*  43:    */         {
/*  44: 45 */           controlOtroPeriodicoDAO.insert(controlOtroPeriodico);
/*  45:    */         }
/*  46:    */       }
/*  47: 49 */       for (Iterator it = controlesPeriodicosBaseMap.values().iterator(); it.hasNext();)
/*  48:    */       {
/*  49: 50 */         ControlOtroPeriodico controlOtroPeriodico = (ControlOtroPeriodico)it.next();
/*  50: 51 */         controlOtroPeriodicoDAO.delete(controlOtroPeriodico);
/*  51:    */       }
/*  52: 55 */       String[] llavesControlesConcita = { "cootc_cod", "cootc_usuf_cod" };
/*  53: 56 */       ControlOtroConcitaDAO controlOtroConcitaDAO = new ControlOtroConcitaDAO();
/*  54: 57 */       controlOtroConcitaDAO.setServerNumber(this.serverNumber);
/*  55: 58 */       List controlesConcitaBase = controlOtroConcitaDAO.list(usuf_cod);
/*  56:    */       
/*  57: 60 */       Map controlesConcitaBaseMap = new HashMap();
/*  58: 61 */       for (Iterator it = controlesConcitaBase.iterator(); it.hasNext();)
/*  59:    */       {
/*  60: 62 */         ControlOtroConcita controlOtroConcita = (ControlOtroConcita)it.next();
/*  61: 63 */         controlesConcitaBaseMap.put(controlOtroConcita.getCootc_cod(), controlOtroConcita);
/*  62:    */       }
/*  63: 66 */       for (Iterator it = controlOtroCompleto.getControlesConcita().iterator(); it.hasNext();)
/*  64:    */       {
/*  65: 67 */         ControlOtroConcita controlOtroConcita = (ControlOtroConcita)it.next();
/*  66: 68 */         controlOtroConcita.setCootc_usuf_cod(usuf_cod);
/*  67: 69 */         if (controlesConcitaBaseMap.containsKey(controlOtroConcita.getCootc_cod()))
/*  68:    */         {
/*  69: 70 */           controlOtroConcitaDAO.update(controlOtroConcita, llavesControlesConcita);
/*  70: 71 */           controlesConcitaBaseMap.remove(controlOtroConcita.getCootc_cod());
/*  71:    */         }
/*  72:    */         else
/*  73:    */         {
/*  74: 73 */           controlOtroConcitaDAO.insert(controlOtroConcita);
/*  75:    */         }
/*  76:    */       }
/*  77: 77 */       for (Iterator it = controlesConcitaBaseMap.values().iterator(); it.hasNext();)
/*  78:    */       {
/*  79: 78 */         ControlOtroConcita controlOtroConcita = (ControlOtroConcita)it.next();
/*  80: 79 */         controlOtroConcitaDAO.delete(controlOtroConcita);
/*  81:    */       }
/*  82:    */     }
/*  83:    */     catch (Exception e)
/*  84:    */     {
/*  85: 82 */       throw e;
/*  86:    */     }
/*  87:    */   }
/*  88:    */   
/*  89:    */   public ControlOtroCompleto retrieve(BigDecimal usuf_cod)
/*  90:    */     throws Exception
/*  91:    */   {
/*  92: 90 */     ControlOtroCompleto controlOtroCompleto = new ControlOtroCompleto();
/*  93:    */     try
/*  94:    */     {
/*  95: 95 */       ControlOtroPeriodicoDAO controlOtroPeriodicoDAO = new ControlOtroPeriodicoDAO();
/*  96: 96 */       controlOtroPeriodicoDAO.setServerNumber(this.serverNumber);
/*  97: 97 */       controlOtroCompleto.setControlesPeriodicos(controlOtroPeriodicoDAO.list(usuf_cod));
/*  98:    */       
/*  99:    */ 
/* 100:100 */       ControlOtroConcitaDAO controlOtroConcitaDAO = new ControlOtroConcitaDAO();
/* 101:101 */       controlOtroConcitaDAO.setServerNumber(this.serverNumber);
/* 102:102 */       controlOtroCompleto.setControlesConcita(controlOtroConcitaDAO.list(usuf_cod));
/* 103:    */     }
/* 104:    */     catch (Exception e)
/* 105:    */     {
/* 106:105 */       throw e;
/* 107:    */     }
/* 108:108 */     return controlOtroCompleto;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public void delete(BigDecimal usuf_cod)
/* 112:    */     throws Exception
/* 113:    */   {
/* 114:    */     try
/* 115:    */     {
/* 116:116 */       ControlOtroPeriodicoDAO controlOtroPeriodicoDAO = new ControlOtroPeriodicoDAO();
/* 117:117 */       controlOtroPeriodicoDAO.setServerNumber(this.serverNumber);
/* 118:118 */       controlOtroPeriodicoDAO.deleteAll(usuf_cod);
/* 119:    */       
/* 120:    */ 
/* 121:121 */       ControlOtroConcitaDAO controlOtroConcitaDAO = new ControlOtroConcitaDAO();
/* 122:122 */       controlOtroConcitaDAO.setServerNumber(this.serverNumber);
/* 123:123 */       controlOtroConcitaDAO.deleteAll(usuf_cod);
/* 124:    */     }
/* 125:    */     catch (Exception e)
/* 126:    */     {
/* 127:126 */       throw e;
/* 128:    */     }
/* 129:    */   }
/* 130:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.dao.ControlOtroCompletoDAO
 * JD-Core Version:    0.7.0.1
 */