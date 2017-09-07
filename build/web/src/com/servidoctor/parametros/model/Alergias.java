/*  1:   */ package com.servidoctor.parametros.model;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class Alergias
/*  6:   */ {
/*  7:   */   private BigDecimal ale_cod;
/*  8:   */   private String ale_des;
/*  9:   */   
/* 10:   */   public BigDecimal getAle_cod()
/* 11:   */   {
/* 12:16 */     return this.ale_cod;
/* 13:   */   }
/* 14:   */   
/* 15:   */   public String getAle_des()
/* 16:   */   {
/* 17:20 */     return this.ale_des;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public void setAle_cod(BigDecimal decimal)
/* 21:   */   {
/* 22:24 */     this.ale_cod = decimal;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public void setAle_des(String string)
/* 26:   */   {
/* 27:28 */     this.ale_des = string;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public boolean equals(Object object)
/* 31:   */   {
/* 32:32 */     boolean resultado = false;
/* 33:33 */     if (object == this)
/* 34:   */     {
/* 35:34 */       resultado = true;
/* 36:   */     }
/* 37:35 */     else if ((object instanceof Alergias))
/* 38:   */     {
/* 39:36 */       Alergias alergias = (Alergias)object;
/* 40:37 */       if (this.ale_cod.equals(alergias.ale_cod)) {
/* 41:38 */         resultado = true;
/* 42:   */       }
/* 43:   */     }
/* 44:41 */     return resultado;
/* 45:   */   }
/* 46:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.model.Alergias
 * JD-Core Version:    0.7.0.1
 */