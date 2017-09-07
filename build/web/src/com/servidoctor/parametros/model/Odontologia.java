/*  1:   */ package com.servidoctor.parametros.model;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class Odontologia
/*  6:   */ {
/*  7:   */   private BigDecimal odo_cod;
/*  8:   */   private String odo_destratamiento;
/*  9:   */   private BigDecimal odo_edaddesdemes;
/* 10:   */   private BigDecimal odo_edaddesdeanio;
/* 11:   */   private BigDecimal odo_edadhastames;
/* 12:   */   private BigDecimal odo_edadhastaanio;
/* 13:   */   private BigDecimal odo_frecuencia;
/* 14:   */   
/* 15:   */   public BigDecimal getOdo_cod()
/* 16:   */   {
/* 17:20 */     return this.odo_cod;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public String getOdo_destratamiento()
/* 21:   */   {
/* 22:24 */     return this.odo_destratamiento;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public BigDecimal getOdo_edaddesdeanio()
/* 26:   */   {
/* 27:28 */     return this.odo_edaddesdeanio;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public BigDecimal getOdo_edaddesdemes()
/* 31:   */   {
/* 32:32 */     return this.odo_edaddesdemes;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public BigDecimal getOdo_edadhastaanio()
/* 36:   */   {
/* 37:36 */     return this.odo_edadhastaanio;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public BigDecimal getOdo_edadhastames()
/* 41:   */   {
/* 42:40 */     return this.odo_edadhastames;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public BigDecimal getOdo_frecuencia()
/* 46:   */   {
/* 47:44 */     return this.odo_frecuencia;
/* 48:   */   }
/* 49:   */   
/* 50:   */   public void setOdo_cod(BigDecimal decimal)
/* 51:   */   {
/* 52:48 */     this.odo_cod = decimal;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public void setOdo_destratamiento(String string)
/* 56:   */   {
/* 57:52 */     this.odo_destratamiento = string;
/* 58:   */   }
/* 59:   */   
/* 60:   */   public void setOdo_edaddesdeanio(BigDecimal decimal)
/* 61:   */   {
/* 62:56 */     this.odo_edaddesdeanio = decimal;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public void setOdo_edaddesdemes(BigDecimal decimal)
/* 66:   */   {
/* 67:60 */     this.odo_edaddesdemes = decimal;
/* 68:   */   }
/* 69:   */   
/* 70:   */   public void setOdo_edadhastaanio(BigDecimal decimal)
/* 71:   */   {
/* 72:64 */     this.odo_edadhastaanio = decimal;
/* 73:   */   }
/* 74:   */   
/* 75:   */   public void setOdo_edadhastames(BigDecimal decimal)
/* 76:   */   {
/* 77:68 */     this.odo_edadhastames = decimal;
/* 78:   */   }
/* 79:   */   
/* 80:   */   public void setOdo_frecuencia(BigDecimal decimal)
/* 81:   */   {
/* 82:72 */     this.odo_frecuencia = decimal;
/* 83:   */   }
/* 84:   */   
/* 85:   */   public boolean equals(Object object)
/* 86:   */   {
/* 87:76 */     boolean resultado = false;
/* 88:77 */     if (object == this)
/* 89:   */     {
/* 90:78 */       resultado = true;
/* 91:   */     }
/* 92:79 */     else if ((object instanceof Odontologia))
/* 93:   */     {
/* 94:80 */       Odontologia odontologia = (Odontologia)object;
/* 95:81 */       if (this.odo_cod.equals(odontologia.odo_cod)) {
/* 96:82 */         resultado = true;
/* 97:   */       }
/* 98:   */     }
/* 99:85 */     return resultado;
/* :0:   */   }
/* :1:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.model.Odontologia
 * JD-Core Version:    0.7.0.1
 */