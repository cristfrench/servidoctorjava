/*  1:   */ package com.servidoctor.parametros.controller;
/*  2:   */ 
/*  3:   */ import org.apache.struts.validator.ValidatorForm;
/*  4:   */ 
/*  5:   */ public class OptometriaForm
/*  6:   */   extends ValidatorForm
/*  7:   */ {
/*  8:14 */   private String opt_cod = "0";
/*  9:15 */   private String opt_aniosdesde = "0";
/* 10:16 */   private String opt_anioshasta = "0";
/* 11:17 */   private String opt_frecuencia = "0";
/* 12:   */   
/* 13:   */   public String getOpt_aniosdesde()
/* 14:   */   {
/* 15:20 */     return this.opt_aniosdesde;
/* 16:   */   }
/* 17:   */   
/* 18:   */   public String getOpt_anioshasta()
/* 19:   */   {
/* 20:24 */     return this.opt_anioshasta;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public String getOpt_cod()
/* 24:   */   {
/* 25:28 */     return this.opt_cod;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public String getOpt_frecuencia()
/* 29:   */   {
/* 30:32 */     return this.opt_frecuencia;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public void setOpt_aniosdesde(String string)
/* 34:   */   {
/* 35:36 */     this.opt_aniosdesde = string;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public void setOpt_anioshasta(String string)
/* 39:   */   {
/* 40:40 */     this.opt_anioshasta = string;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public void setOpt_cod(String string)
/* 44:   */   {
/* 45:44 */     this.opt_cod = string;
/* 46:   */   }
/* 47:   */   
/* 48:   */   public void setOpt_frecuencia(String string)
/* 49:   */   {
/* 50:48 */     this.opt_frecuencia = string;
/* 51:   */   }
/* 52:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.controller.OptometriaForm
 * JD-Core Version:    0.7.0.1
 */