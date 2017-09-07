/*  1:   */ package com.servidoctor.parametros.model;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class Cirujias
/*  6:   */ {
/*  7:   */   private BigDecimal cir_cod;
/*  8:   */   private String cir_des;
/*  9:   */   
/* 10:   */   public BigDecimal getCir_cod()
/* 11:   */   {
/* 12:17 */     return this.cir_cod;
/* 13:   */   }
/* 14:   */   
/* 15:   */   public String getCir_des()
/* 16:   */   {
/* 17:21 */     return this.cir_des;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public void setCir_cod(BigDecimal decimal)
/* 21:   */   {
/* 22:25 */     this.cir_cod = decimal;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public void setCir_des(String string)
/* 26:   */   {
/* 27:29 */     this.cir_des = string;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public boolean equals(Object object)
/* 31:   */   {
/* 32:33 */     boolean resultado = false;
/* 33:34 */     if (object == this)
/* 34:   */     {
/* 35:35 */       resultado = true;
/* 36:   */     }
/* 37:36 */     else if ((object instanceof Cirujias))
/* 38:   */     {
/* 39:37 */       Cirujias cirujias = (Cirujias)object;
/* 40:38 */       if (this.cir_cod.equals(cirujias.cir_cod)) {
/* 41:39 */         resultado = true;
/* 42:   */       }
/* 43:   */     }
/* 44:42 */     return resultado;
/* 45:   */   }
/* 46:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.model.Cirujias
 * JD-Core Version:    0.7.0.1
 */