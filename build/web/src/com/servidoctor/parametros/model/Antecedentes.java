/*  1:   */ package com.servidoctor.parametros.model;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class Antecedentes
/*  6:   */ {
/*  7:   */   private BigDecimal ante_cod;
/*  8:   */   private String ante_des;
/*  9:   */   
/* 10:   */   public BigDecimal getAnte_cod()
/* 11:   */   {
/* 12:19 */     return this.ante_cod;
/* 13:   */   }
/* 14:   */   
/* 15:   */   public String getAnte_des()
/* 16:   */   {
/* 17:23 */     return this.ante_des;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public void setAnte_cod(BigDecimal decimal)
/* 21:   */   {
/* 22:27 */     this.ante_cod = decimal;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public void setAnte_des(String string)
/* 26:   */   {
/* 27:31 */     this.ante_des = string;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public boolean equals(Object object)
/* 31:   */   {
/* 32:35 */     boolean resultado = false;
/* 33:36 */     if (object == this)
/* 34:   */     {
/* 35:37 */       resultado = true;
/* 36:   */     }
/* 37:38 */     else if ((object instanceof Antecedentes))
/* 38:   */     {
/* 39:39 */       Antecedentes antecedentes = (Antecedentes)object;
/* 40:40 */       if (this.ante_cod.equals(antecedentes.ante_cod)) {
/* 41:41 */         resultado = true;
/* 42:   */       }
/* 43:   */     }
/* 44:44 */     return resultado;
/* 45:   */   }
/* 46:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.model.Antecedentes
 * JD-Core Version:    0.7.0.1
 */