/*  1:   */ package com.servidoctor.parametros.model;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class Documento
/*  6:   */ {
/*  7:   */   private BigDecimal doc_cod;
/*  8:   */   private String doc_des;
/*  9:   */   
/* 10:   */   public BigDecimal getDoc_cod()
/* 11:   */   {
/* 12:15 */     return this.doc_cod;
/* 13:   */   }
/* 14:   */   
/* 15:   */   public String getDoc_des()
/* 16:   */   {
/* 17:19 */     return this.doc_des;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public void setDoc_cod(BigDecimal decimal)
/* 21:   */   {
/* 22:23 */     this.doc_cod = decimal;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public void setDoc_des(String string)
/* 26:   */   {
/* 27:27 */     this.doc_des = string;
/* 28:   */   }
/* 29:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.model.Documento
 * JD-Core Version:    0.7.0.1
 */