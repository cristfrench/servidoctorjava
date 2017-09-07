/*  1:   */ package com.servidoctor.sdfamily.model;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class ExamenesUsuario
/*  6:   */ {
/*  7:   */   private BigDecimal exau_cod;
/*  8:   */   private BigDecimal exau_usuf_cod;
/*  9:   */   private BigDecimal exau_exa_cod;
/* 10:   */   private BigDecimal exau_grup_cod;
/* 11:   */   private String exau_des;
/* 12:   */   private BigDecimal exau_edad;
/* 13:   */   private BigDecimal exau_frecuencia;
/* 14:   */   
/* 15:   */   public BigDecimal getExau_cod()
/* 16:   */   {
/* 17:22 */     return this.exau_cod;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public String getExau_des()
/* 21:   */   {
/* 22:26 */     return this.exau_des;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public BigDecimal getExau_edad()
/* 26:   */   {
/* 27:30 */     return this.exau_edad;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public BigDecimal getExau_exa_cod()
/* 31:   */   {
/* 32:34 */     return this.exau_exa_cod;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public BigDecimal getExau_frecuencia()
/* 36:   */   {
/* 37:38 */     return this.exau_frecuencia;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public BigDecimal getExau_grup_cod()
/* 41:   */   {
/* 42:42 */     return this.exau_grup_cod;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public BigDecimal getExau_usuf_cod()
/* 46:   */   {
/* 47:46 */     return this.exau_usuf_cod;
/* 48:   */   }
/* 49:   */   
/* 50:   */   public void setExau_cod(BigDecimal decimal)
/* 51:   */   {
/* 52:50 */     this.exau_cod = decimal;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public void setExau_des(String string)
/* 56:   */   {
/* 57:54 */     this.exau_des = string;
/* 58:   */   }
/* 59:   */   
/* 60:   */   public void setExau_edad(BigDecimal decimal)
/* 61:   */   {
/* 62:58 */     this.exau_edad = decimal;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public void setExau_exa_cod(BigDecimal decimal)
/* 66:   */   {
/* 67:62 */     this.exau_exa_cod = decimal;
/* 68:   */   }
/* 69:   */   
/* 70:   */   public void setExau_frecuencia(BigDecimal decimal)
/* 71:   */   {
/* 72:66 */     this.exau_frecuencia = decimal;
/* 73:   */   }
/* 74:   */   
/* 75:   */   public void setExau_grup_cod(BigDecimal decimal)
/* 76:   */   {
/* 77:70 */     this.exau_grup_cod = decimal;
/* 78:   */   }
/* 79:   */   
/* 80:   */   public void setExau_usuf_cod(BigDecimal decimal)
/* 81:   */   {
/* 82:74 */     this.exau_usuf_cod = decimal;
/* 83:   */   }
/* 84:   */   
/* 85:   */   public boolean equals(Object object)
/* 86:   */   {
/* 87:78 */     boolean resultado = false;
/* 88:79 */     if (object == this)
/* 89:   */     {
/* 90:80 */       resultado = true;
/* 91:   */     }
/* 92:81 */     else if ((object instanceof ExamenesUsuario))
/* 93:   */     {
/* 94:82 */       ExamenesUsuario examenesUsuario = (ExamenesUsuario)object;
/* 95:83 */       if ((this.exau_cod.equals(examenesUsuario.exau_cod)) && (this.exau_usuf_cod.equals(examenesUsuario.exau_usuf_cod))) {
/* 96:84 */         resultado = true;
/* 97:   */       }
/* 98:   */     }
/* 99:87 */     return resultado;
/* :0:   */   }
/* :1:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.model.ExamenesUsuario
 * JD-Core Version:    0.7.0.1
 */