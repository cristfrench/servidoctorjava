/*  1:   */ package com.servidoctor.parametros.model;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class GastosVehiculosAnuales
/*  6:   */ {
/*  7:   */   private BigDecimal gasv_cod;
/*  8:   */   private BigDecimal gasv_veh_cod;
/*  9:   */   private BigDecimal gasv_fechaini;
/* 10:   */   private BigDecimal gasv_fechafin;
/* 11:   */   private BigDecimal gasv_valor;
/* 12:   */   private String gasv_descripcion;
/* 13:   */   
/* 14:   */   public BigDecimal getGasv_cod()
/* 15:   */   {
/* 16:21 */     return this.gasv_cod;
/* 17:   */   }
/* 18:   */   
/* 19:   */   public String getGasv_descripcion()
/* 20:   */   {
/* 21:25 */     return this.gasv_descripcion;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public BigDecimal getGasv_fechafin()
/* 25:   */   {
/* 26:29 */     return this.gasv_fechafin;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public BigDecimal getGasv_fechaini()
/* 30:   */   {
/* 31:33 */     return this.gasv_fechaini;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public BigDecimal getGasv_valor()
/* 35:   */   {
/* 36:37 */     return this.gasv_valor;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public BigDecimal getGasv_veh_cod()
/* 40:   */   {
/* 41:41 */     return this.gasv_veh_cod;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public void setGasv_cod(BigDecimal decimal)
/* 45:   */   {
/* 46:45 */     this.gasv_cod = decimal;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public void setGasv_descripcion(String string)
/* 50:   */   {
/* 51:49 */     this.gasv_descripcion = string;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public void setGasv_fechafin(BigDecimal decimal)
/* 55:   */   {
/* 56:53 */     this.gasv_fechafin = decimal;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public void setGasv_fechaini(BigDecimal decimal)
/* 60:   */   {
/* 61:57 */     this.gasv_fechaini = decimal;
/* 62:   */   }
/* 63:   */   
/* 64:   */   public void setGasv_valor(BigDecimal decimal)
/* 65:   */   {
/* 66:61 */     this.gasv_valor = decimal;
/* 67:   */   }
/* 68:   */   
/* 69:   */   public void setGasv_veh_cod(BigDecimal decimal)
/* 70:   */   {
/* 71:65 */     this.gasv_veh_cod = decimal;
/* 72:   */   }
/* 73:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.model.GastosVehiculosAnuales
 * JD-Core Version:    0.7.0.1
 */