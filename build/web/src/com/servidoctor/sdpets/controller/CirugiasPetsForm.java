/*  1:   */ package com.servidoctor.sdpets.controller;
/*  2:   */ 
/*  3:   */ import org.apache.struts.validator.ValidatorForm;
/*  4:   */ 
/*  5:   */ public class CirugiasPetsForm
/*  6:   */   extends ValidatorForm
/*  7:   */ {
/*  8:13 */   private String cirp_cod = "0";
/*  9:14 */   private String cirp_mas_cod = "0";
/* 10:15 */   private String cirp_des = "";
/* 11:16 */   private String cirp_anio = "0";
/* 12:   */   
/* 13:   */   public String getCirp_anio()
/* 14:   */   {
/* 15:19 */     return this.cirp_anio;
/* 16:   */   }
/* 17:   */   
/* 18:   */   public String getCirp_cod()
/* 19:   */   {
/* 20:22 */     return this.cirp_cod;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public String getCirp_des()
/* 24:   */   {
/* 25:25 */     return this.cirp_des;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public String getCirp_mas_cod()
/* 29:   */   {
/* 30:28 */     return this.cirp_mas_cod;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public void setCirp_anio(String cirp_anio)
/* 34:   */   {
/* 35:31 */     this.cirp_anio = cirp_anio;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public void setCirp_cod(String cirp_cod)
/* 39:   */   {
/* 40:34 */     this.cirp_cod = cirp_cod;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public void setCirp_des(String cirp_des)
/* 44:   */   {
/* 45:37 */     this.cirp_des = cirp_des;
/* 46:   */   }
/* 47:   */   
/* 48:   */   public void setCirp_mas_cod(String cirp_mas_cod)
/* 49:   */   {
/* 50:40 */     this.cirp_mas_cod = cirp_mas_cod;
/* 51:   */   }
/* 52:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdpets.controller.CirugiasPetsForm
 * JD-Core Version:    0.7.0.1
 */