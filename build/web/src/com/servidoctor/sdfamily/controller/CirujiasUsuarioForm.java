/*  1:   */ package com.servidoctor.sdfamily.controller;
/*  2:   */ 
/*  3:   */ import org.apache.struts.validator.ValidatorForm;
/*  4:   */ 
/*  5:   */ public class CirujiasUsuarioForm
/*  6:   */   extends ValidatorForm
/*  7:   */ {
/*  8:13 */   private String ciru_cod = "0";
/*  9:14 */   private String ciru_usuf_cod = "0";
/* 10:15 */   private String ciru_cir_cod = "0";
/* 11:16 */   private String ciru_des = "";
/* 12:17 */   private String ciru_anio = "0";
/* 13:   */   
/* 14:   */   public String getCiru_anio()
/* 15:   */   {
/* 16:20 */     return this.ciru_anio;
/* 17:   */   }
/* 18:   */   
/* 19:   */   public String getCiru_cir_cod()
/* 20:   */   {
/* 21:23 */     return this.ciru_cir_cod;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public String getCiru_cod()
/* 25:   */   {
/* 26:26 */     return this.ciru_cod;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public String getCiru_des()
/* 30:   */   {
/* 31:29 */     return this.ciru_des;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public String getCiru_usuf_cod()
/* 35:   */   {
/* 36:32 */     return this.ciru_usuf_cod;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public void setCiru_anio(String ciru_anio)
/* 40:   */   {
/* 41:35 */     this.ciru_anio = ciru_anio;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public void setCiru_cir_cod(String ciru_cir_cod)
/* 45:   */   {
/* 46:38 */     this.ciru_cir_cod = ciru_cir_cod;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public void setCiru_cod(String ciru_cod)
/* 50:   */   {
/* 51:41 */     this.ciru_cod = ciru_cod;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public void setCiru_des(String ciru_des)
/* 55:   */   {
/* 56:44 */     this.ciru_des = ciru_des;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public void setCiru_usuf_cod(String ciru_usuf_cod)
/* 60:   */   {
/* 61:47 */     this.ciru_usuf_cod = ciru_usuf_cod;
/* 62:   */   }
/* 63:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.controller.CirujiasUsuarioForm
 * JD-Core Version:    0.7.0.1
 */