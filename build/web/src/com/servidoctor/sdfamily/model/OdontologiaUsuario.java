/*  1:   */ package com.servidoctor.sdfamily.model;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class OdontologiaUsuario
/*  6:   */ {
/*  7:   */   private BigDecimal odou_cod;
/*  8:   */   private BigDecimal odou_usuf_cod;
/*  9:   */   private BigDecimal odou_odo_cod;
/* 10:   */   private String odou_destratamiento;
/* 11:   */   private BigDecimal odou_edaddesdemes;
/* 12:   */   private BigDecimal odou_edaddesdeanio;
/* 13:   */   private BigDecimal odou_edadhastames;
/* 14:   */   private BigDecimal odou_edadhastaanio;
/* 15:   */   private BigDecimal odou_frecuencia;
/* 16:   */   
/* 17:   */   public BigDecimal getOdou_cod()
/* 18:   */   {
/* 19:24 */     return this.odou_cod;
/* 20:   */   }
/* 21:   */   
/* 22:   */   public String getOdou_destratamiento()
/* 23:   */   {
/* 24:27 */     return this.odou_destratamiento;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public BigDecimal getOdou_edaddesdeanio()
/* 28:   */   {
/* 29:30 */     return this.odou_edaddesdeanio;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public BigDecimal getOdou_edaddesdemes()
/* 33:   */   {
/* 34:33 */     return this.odou_edaddesdemes;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public BigDecimal getOdou_edadhastaanio()
/* 38:   */   {
/* 39:36 */     return this.odou_edadhastaanio;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public BigDecimal getOdou_edadhastames()
/* 43:   */   {
/* 44:39 */     return this.odou_edadhastames;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public BigDecimal getOdou_frecuencia()
/* 48:   */   {
/* 49:42 */     return this.odou_frecuencia;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public BigDecimal getOdou_odo_cod()
/* 53:   */   {
/* 54:45 */     return this.odou_odo_cod;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public BigDecimal getOdou_usuf_cod()
/* 58:   */   {
/* 59:48 */     return this.odou_usuf_cod;
/* 60:   */   }
/* 61:   */   
/* 62:   */   public void setOdou_cod(BigDecimal odou_cod)
/* 63:   */   {
/* 64:51 */     this.odou_cod = odou_cod;
/* 65:   */   }
/* 66:   */   
/* 67:   */   public void setOdou_destratamiento(String odou_destratamiento)
/* 68:   */   {
/* 69:54 */     this.odou_destratamiento = odou_destratamiento;
/* 70:   */   }
/* 71:   */   
/* 72:   */   public void setOdou_edaddesdeanio(BigDecimal odou_edaddesdeanio)
/* 73:   */   {
/* 74:57 */     this.odou_edaddesdeanio = odou_edaddesdeanio;
/* 75:   */   }
/* 76:   */   
/* 77:   */   public void setOdou_edaddesdemes(BigDecimal odou_edaddesdemes)
/* 78:   */   {
/* 79:60 */     this.odou_edaddesdemes = odou_edaddesdemes;
/* 80:   */   }
/* 81:   */   
/* 82:   */   public void setOdou_edadhastaanio(BigDecimal odou_edadhastaanio)
/* 83:   */   {
/* 84:63 */     this.odou_edadhastaanio = odou_edadhastaanio;
/* 85:   */   }
/* 86:   */   
/* 87:   */   public void setOdou_edadhastames(BigDecimal odou_edadhastames)
/* 88:   */   {
/* 89:66 */     this.odou_edadhastames = odou_edadhastames;
/* 90:   */   }
/* 91:   */   
/* 92:   */   public void setOdou_frecuencia(BigDecimal odou_frecuencia)
/* 93:   */   {
/* 94:69 */     this.odou_frecuencia = odou_frecuencia;
/* 95:   */   }
/* 96:   */   
/* 97:   */   public void setOdou_odo_cod(BigDecimal odou_odo_cod)
/* 98:   */   {
/* 99:72 */     this.odou_odo_cod = odou_odo_cod;
/* :0:   */   }
/* :1:   */   
/* :2:   */   public void setOdou_usuf_cod(BigDecimal odou_usuf_cod)
/* :3:   */   {
/* :4:75 */     this.odou_usuf_cod = odou_usuf_cod;
/* :5:   */   }
/* :6:   */   
/* :7:   */   public boolean equals(Object object)
/* :8:   */   {
/* :9:79 */     boolean resultado = false;
/* ;0:80 */     if (object == this)
/* ;1:   */     {
/* ;2:81 */       resultado = true;
/* ;3:   */     }
/* ;4:82 */     else if ((object instanceof OdontologiaUsuario))
/* ;5:   */     {
/* ;6:83 */       OdontologiaUsuario odontologiaUsuario = (OdontologiaUsuario)object;
/* ;7:84 */       if ((this.odou_cod.equals(odontologiaUsuario.odou_cod)) && (this.odou_usuf_cod.equals(odontologiaUsuario.odou_usuf_cod))) {
/* ;8:85 */         resultado = true;
/* ;9:   */       }
/* <0:   */     }
/* <1:88 */     return resultado;
/* <2:   */   }
/* <3:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.model.OdontologiaUsuario
 * JD-Core Version:    0.7.0.1
 */