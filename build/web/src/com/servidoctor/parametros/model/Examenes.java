/*  1:   */ package com.servidoctor.parametros.model;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class Examenes
/*  6:   */ {
/*  7:   */   private BigDecimal exa_cod;
/*  8:   */   private BigDecimal exa_grup_cod;
/*  9:   */   private String exa_sexo;
/* 10:   */   private String exa_des;
/* 11:   */   private BigDecimal exa_edad;
/* 12:   */   private BigDecimal exa_frecuencia;
/* 13:   */   
/* 14:   */   public BigDecimal getExa_cod()
/* 15:   */   {
/* 16:21 */     return this.exa_cod;
/* 17:   */   }
/* 18:   */   
/* 19:   */   public String getExa_des()
/* 20:   */   {
/* 21:25 */     return this.exa_des;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public BigDecimal getExa_edad()
/* 25:   */   {
/* 26:29 */     return this.exa_edad;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public BigDecimal getExa_frecuencia()
/* 30:   */   {
/* 31:33 */     return this.exa_frecuencia;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public BigDecimal getExa_grup_cod()
/* 35:   */   {
/* 36:37 */     return this.exa_grup_cod;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public String getExa_sexo()
/* 40:   */   {
/* 41:41 */     return this.exa_sexo;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public void setExa_cod(BigDecimal decimal)
/* 45:   */   {
/* 46:45 */     this.exa_cod = decimal;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public void setExa_des(String string)
/* 50:   */   {
/* 51:49 */     this.exa_des = string;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public void setExa_edad(BigDecimal decimal)
/* 55:   */   {
/* 56:53 */     this.exa_edad = decimal;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public void setExa_frecuencia(BigDecimal decimal)
/* 60:   */   {
/* 61:57 */     this.exa_frecuencia = decimal;
/* 62:   */   }
/* 63:   */   
/* 64:   */   public void setExa_grup_cod(BigDecimal decimal)
/* 65:   */   {
/* 66:61 */     this.exa_grup_cod = decimal;
/* 67:   */   }
/* 68:   */   
/* 69:   */   public void setExa_sexo(String string)
/* 70:   */   {
/* 71:65 */     this.exa_sexo = string;
/* 72:   */   }
/* 73:   */   
/* 74:   */   public boolean equals(Object object)
/* 75:   */   {
/* 76:69 */     boolean resultado = false;
/* 77:70 */     if (object == this)
/* 78:   */     {
/* 79:71 */       resultado = true;
/* 80:   */     }
/* 81:72 */     else if ((object instanceof Examenes))
/* 82:   */     {
/* 83:73 */       Examenes examen = (Examenes)object;
/* 84:74 */       if (this.exa_cod.equals(examen.exa_cod)) {
/* 85:75 */         resultado = true;
/* 86:   */       }
/* 87:   */     }
/* 88:78 */     return resultado;
/* 89:   */   }
/* 90:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.model.Examenes
 * JD-Core Version:    0.7.0.1
 */