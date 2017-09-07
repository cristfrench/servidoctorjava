/*  1:   */ package com.servidoctor.sdpets.controller;
/*  2:   */ 
/*  3:   */ import org.apache.struts.validator.ValidatorForm;
/*  4:   */ 
/*  5:   */ public class AlergiasPetsForm
/*  6:   */   extends ValidatorForm
/*  7:   */ {
/*  8:13 */   private String alep_cod = "0";
/*  9:14 */   private String alep_mas_cod = "0";
/* 10:15 */   private String alep_des = "";
/* 11:16 */   private String alep_anio_desde = "0";
/* 12:17 */   private String alep_novedad = "";
/* 13:   */   
/* 14:   */   public String getAlep_anio_desde()
/* 15:   */   {
/* 16:21 */     return this.alep_anio_desde;
/* 17:   */   }
/* 18:   */   
/* 19:   */   public String getAlep_cod()
/* 20:   */   {
/* 21:24 */     return this.alep_cod;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public String getAlep_des()
/* 25:   */   {
/* 26:27 */     return this.alep_des;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public String getAlep_novedad()
/* 30:   */   {
/* 31:30 */     return this.alep_novedad;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public String getAlep_mas_cod()
/* 35:   */   {
/* 36:33 */     return this.alep_mas_cod;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public void setAlep_anio_desde(String alep_anio_desde)
/* 40:   */   {
/* 41:37 */     this.alep_anio_desde = alep_anio_desde;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public void setAlep_cod(String alep_cod)
/* 45:   */   {
/* 46:40 */     this.alep_cod = alep_cod;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public void setAlep_des(String alep_des)
/* 50:   */   {
/* 51:43 */     this.alep_des = alep_des;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public void setAlep_novedad(String alep_novedad)
/* 55:   */   {
/* 56:46 */     this.alep_novedad = alep_novedad;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public void setAlep_mas_cod(String alep_mas_cod)
/* 60:   */   {
/* 61:49 */     this.alep_mas_cod = alep_mas_cod;
/* 62:   */   }
/* 63:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdpets.controller.AlergiasPetsForm
 * JD-Core Version:    0.7.0.1
 */