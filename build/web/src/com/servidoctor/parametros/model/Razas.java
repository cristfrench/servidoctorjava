/*  1:   */ package com.servidoctor.parametros.model;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class Razas
/*  6:   */ {
/*  7:   */   private BigDecimal raz_cod;
/*  8:   */   private BigDecimal raz_tipo;
/*  9:   */   private String raz_des;
/* 10:   */   
/* 11:   */   public BigDecimal getRaz_cod()
/* 12:   */   {
/* 13:19 */     return this.raz_cod;
/* 14:   */   }
/* 15:   */   
/* 16:   */   public String getRaz_des()
/* 17:   */   {
/* 18:23 */     return this.raz_des;
/* 19:   */   }
/* 20:   */   
/* 21:   */   public BigDecimal getRaz_tipo()
/* 22:   */   {
/* 23:27 */     return this.raz_tipo;
/* 24:   */   }
/* 25:   */   
/* 26:   */   public void setRaz_cod(BigDecimal decimal)
/* 27:   */   {
/* 28:31 */     this.raz_cod = decimal;
/* 29:   */   }
/* 30:   */   
/* 31:   */   public void setRaz_des(String string)
/* 32:   */   {
/* 33:35 */     this.raz_des = string;
/* 34:   */   }
/* 35:   */   
/* 36:   */   public void setRaz_tipo(BigDecimal decimal)
/* 37:   */   {
/* 38:39 */     this.raz_tipo = decimal;
/* 39:   */   }
/* 40:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.model.Razas
 * JD-Core Version:    0.7.0.1
 */