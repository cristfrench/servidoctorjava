/*  1:   */ package com.servidoctor.sdfamily.model;
/*  2:   */ 
/*  3:   */ import java.util.ArrayList;
/*  4:   */ import java.util.List;
/*  5:   */ 
/*  6:   */ public class ControlOtroCompleto
/*  7:   */ {
/*  8:   */   List controlesPeriodicos;
/*  9:   */   List controlesConcita;
/* 10:   */   
/* 11:   */   public List getControlesConcita()
/* 12:   */   {
/* 13:11 */     if (this.controlesConcita == null) {
/* 14:12 */       this.controlesConcita = new ArrayList();
/* 15:   */     }
/* 16:14 */     return this.controlesConcita;
/* 17:   */   }
/* 18:   */   
/* 19:   */   public void setControlesConcita(List controlesConcita)
/* 20:   */   {
/* 21:17 */     this.controlesConcita = controlesConcita;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public List getControlesPeriodicos()
/* 25:   */   {
/* 26:20 */     if (this.controlesPeriodicos == null) {
/* 27:21 */       this.controlesPeriodicos = new ArrayList();
/* 28:   */     }
/* 29:23 */     return this.controlesPeriodicos;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public void setControlesPeriodicos(List controlesPeriodicos)
/* 33:   */   {
/* 34:26 */     this.controlesPeriodicos = controlesPeriodicos;
/* 35:   */   }
/* 36:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.model.ControlOtroCompleto
 * JD-Core Version:    0.7.0.1
 */