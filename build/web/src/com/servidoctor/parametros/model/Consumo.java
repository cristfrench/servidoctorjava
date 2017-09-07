/*  1:   */ package com.servidoctor.parametros.model;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class Consumo
/*  6:   */ {
/*  7:   */   private BigDecimal cons_cod;
/*  8:   */   private String cons_des;
/*  9:   */   
/* 10:   */   public BigDecimal getCons_cod()
/* 11:   */   {
/* 12:19 */     return this.cons_cod;
/* 13:   */   }
/* 14:   */   
/* 15:   */   public String getCons_des()
/* 16:   */   {
/* 17:23 */     return this.cons_des;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public void setCons_cod(BigDecimal decimal)
/* 21:   */   {
/* 22:27 */     this.cons_cod = decimal;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public void setCons_des(String string)
/* 26:   */   {
/* 27:31 */     this.cons_des = string;
/* 28:   */   }
/* 29:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.model.Consumo
 * JD-Core Version:    0.7.0.1
 */