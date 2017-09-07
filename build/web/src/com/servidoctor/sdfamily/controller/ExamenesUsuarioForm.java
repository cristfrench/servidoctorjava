/*  1:   */ package com.servidoctor.sdfamily.controller;
/*  2:   */ 
/*  3:   */ import org.apache.struts.validator.ValidatorForm;
/*  4:   */ 
/*  5:   */ public class ExamenesUsuarioForm
/*  6:   */   extends ValidatorForm
/*  7:   */ {
/*  8:13 */   private String exau_cod = "0";
/*  9:14 */   private String exau_usuf_cod = "0";
/* 10:15 */   private String exau_exa_cod = "0";
/* 11:16 */   private String exau_grup_cod = "0";
/* 12:17 */   private String exau_des = "";
/* 13:18 */   private String exau_edad = "0";
/* 14:19 */   private String exau_frecuencia = "0";
/* 15:   */   
/* 16:   */   public String getExau_cod()
/* 17:   */   {
/* 18:22 */     return this.exau_cod;
/* 19:   */   }
/* 20:   */   
/* 21:   */   public String getExau_des()
/* 22:   */   {
/* 23:26 */     return this.exau_des;
/* 24:   */   }
/* 25:   */   
/* 26:   */   public String getExau_edad()
/* 27:   */   {
/* 28:30 */     return this.exau_edad;
/* 29:   */   }
/* 30:   */   
/* 31:   */   public String getExau_exa_cod()
/* 32:   */   {
/* 33:34 */     return this.exau_exa_cod;
/* 34:   */   }
/* 35:   */   
/* 36:   */   public String getExau_frecuencia()
/* 37:   */   {
/* 38:38 */     return this.exau_frecuencia;
/* 39:   */   }
/* 40:   */   
/* 41:   */   public String getExau_grup_cod()
/* 42:   */   {
/* 43:42 */     return this.exau_grup_cod;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public String getExau_usuf_cod()
/* 47:   */   {
/* 48:46 */     return this.exau_usuf_cod;
/* 49:   */   }
/* 50:   */   
/* 51:   */   public void setExau_cod(String string)
/* 52:   */   {
/* 53:50 */     this.exau_cod = string;
/* 54:   */   }
/* 55:   */   
/* 56:   */   public void setExau_des(String string)
/* 57:   */   {
/* 58:54 */     this.exau_des = string;
/* 59:   */   }
/* 60:   */   
/* 61:   */   public void setExau_edad(String string)
/* 62:   */   {
/* 63:58 */     this.exau_edad = string;
/* 64:   */   }
/* 65:   */   
/* 66:   */   public void setExau_exa_cod(String string)
/* 67:   */   {
/* 68:62 */     this.exau_exa_cod = string;
/* 69:   */   }
/* 70:   */   
/* 71:   */   public void setExau_frecuencia(String string)
/* 72:   */   {
/* 73:66 */     this.exau_frecuencia = string;
/* 74:   */   }
/* 75:   */   
/* 76:   */   public void setExau_grup_cod(String string)
/* 77:   */   {
/* 78:70 */     this.exau_grup_cod = string;
/* 79:   */   }
/* 80:   */   
/* 81:   */   public void setExau_usuf_cod(String string)
/* 82:   */   {
/* 83:74 */     this.exau_usuf_cod = string;
/* 84:   */   }
/* 85:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.controller.ExamenesUsuarioForm
 * JD-Core Version:    0.7.0.1
 */