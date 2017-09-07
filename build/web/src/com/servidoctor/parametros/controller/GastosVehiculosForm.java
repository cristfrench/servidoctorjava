/*  1:   */ package com.servidoctor.parametros.controller;
/*  2:   */ 
/*  3:   */ import org.apache.struts.validator.ValidatorForm;
/*  4:   */ 
/*  5:   */ public class GastosVehiculosForm
/*  6:   */   extends ValidatorForm
/*  7:   */ {
/*  8:14 */   private String gasv_cod = "0";
/*  9:15 */   private String gasv_veh_cod = "0";
/* 10:16 */   private String gasv_valor = "0";
/* 11:17 */   private String gasv_fechaini = "0";
/* 12:18 */   private String gasv_fechafin = "0";
/* 13:19 */   private String gasv_descripcion = "";
/* 14:   */   
/* 15:   */   public String getGasv_cod()
/* 16:   */   {
/* 17:23 */     return this.gasv_cod;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public String getGasv_descripcion()
/* 21:   */   {
/* 22:27 */     return this.gasv_descripcion;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public String getGasv_fechafin()
/* 26:   */   {
/* 27:31 */     return this.gasv_fechafin;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public String getGasv_fechaini()
/* 31:   */   {
/* 32:35 */     return this.gasv_fechaini;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public String getGasv_valor()
/* 36:   */   {
/* 37:39 */     return this.gasv_valor;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public String getGasv_veh_cod()
/* 41:   */   {
/* 42:43 */     return this.gasv_veh_cod;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public void setGasv_cod(String string)
/* 46:   */   {
/* 47:47 */     this.gasv_cod = string;
/* 48:   */   }
/* 49:   */   
/* 50:   */   public void setGasv_descripcion(String string)
/* 51:   */   {
/* 52:51 */     this.gasv_descripcion = string;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public void setGasv_fechafin(String string)
/* 56:   */   {
/* 57:55 */     this.gasv_fechafin = string;
/* 58:   */   }
/* 59:   */   
/* 60:   */   public void setGasv_fechaini(String string)
/* 61:   */   {
/* 62:59 */     this.gasv_fechaini = string;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public void setGasv_valor(String string)
/* 66:   */   {
/* 67:63 */     this.gasv_valor = string;
/* 68:   */   }
/* 69:   */   
/* 70:   */   public void setGasv_veh_cod(String string)
/* 71:   */   {
/* 72:67 */     this.gasv_veh_cod = string;
/* 73:   */   }
/* 74:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.controller.GastosVehiculosForm
 * JD-Core Version:    0.7.0.1
 */