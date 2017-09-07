/*  1:   */ package com.servidoctor.parametros.model;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class Periodo
/*  6:   */ {
/*  7:   */   private BigDecimal peri_cod;
/*  8:   */   private String peri_des;
/*  9:   */   
/* 10:   */   public BigDecimal getPeri_cod()
/* 11:   */   {
/* 12:18 */     return this.peri_cod;
/* 13:   */   }
/* 14:   */   
/* 15:   */   public String getPeri_des()
/* 16:   */   {
/* 17:22 */     return this.peri_des;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public void setPeri_cod(BigDecimal decimal)
/* 21:   */   {
/* 22:26 */     this.peri_cod = decimal;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public void setPeri_des(String string)
/* 26:   */   {
/* 27:30 */     this.peri_des = string;
/* 28:   */   }
/* 29:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.model.Periodo
 * JD-Core Version:    0.7.0.1
 */