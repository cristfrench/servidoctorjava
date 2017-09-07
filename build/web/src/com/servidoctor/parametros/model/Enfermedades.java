/*  1:   */ package com.servidoctor.parametros.model;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class Enfermedades
/*  6:   */ {
/*  7:   */   private BigDecimal enf_cod;
/*  8:   */   private BigDecimal enf_sis_cod;
/*  9:   */   private String enf_des;
/* 10:   */   
/* 11:   */   public BigDecimal getEnf_cod()
/* 12:   */   {
/* 13:20 */     return this.enf_cod;
/* 14:   */   }
/* 15:   */   
/* 16:   */   public String getEnf_des()
/* 17:   */   {
/* 18:24 */     return this.enf_des;
/* 19:   */   }
/* 20:   */   
/* 21:   */   public BigDecimal getEnf_sis_cod()
/* 22:   */   {
/* 23:28 */     return this.enf_sis_cod;
/* 24:   */   }
/* 25:   */   
/* 26:   */   public void setEnf_cod(BigDecimal decimal)
/* 27:   */   {
/* 28:32 */     this.enf_cod = decimal;
/* 29:   */   }
/* 30:   */   
/* 31:   */   public void setEnf_des(String string)
/* 32:   */   {
/* 33:36 */     this.enf_des = string;
/* 34:   */   }
/* 35:   */   
/* 36:   */   public void setEnf_sis_cod(BigDecimal decimal)
/* 37:   */   {
/* 38:40 */     this.enf_sis_cod = decimal;
/* 39:   */   }
/* 40:   */   
/* 41:   */   public boolean equals(Object object)
/* 42:   */   {
/* 43:44 */     boolean resultado = false;
/* 44:45 */     if (object == this)
/* 45:   */     {
/* 46:46 */       resultado = true;
/* 47:   */     }
/* 48:47 */     else if ((object instanceof Enfermedades))
/* 49:   */     {
/* 50:48 */       Enfermedades enfermedades = (Enfermedades)object;
/* 51:49 */       if (this.enf_cod.equals(enfermedades.enf_cod)) {
/* 52:50 */         resultado = true;
/* 53:   */       }
/* 54:   */     }
/* 55:53 */     return resultado;
/* 56:   */   }
/* 57:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.model.Enfermedades
 * JD-Core Version:    0.7.0.1
 */