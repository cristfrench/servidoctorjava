/*  1:   */ package com.servidoctor.sdfamily.controller;
/*  2:   */ 
/*  3:   */ import org.apache.struts.validator.ValidatorForm;
/*  4:   */ 
/*  5:   */ public class AlergiasUsuarioForm
/*  6:   */   extends ValidatorForm
/*  7:   */ {
/*  8:13 */   private String aleu_cod = "0";
/*  9:14 */   private String aleu_usuf_cod = "0";
/* 10:15 */   private String aleu_ale_cod = "0";
/* 11:16 */   private String aleu_des = "";
/* 12:17 */   private String aleu_anio_desde = "0";
/* 13:18 */   private String aleu_novedad = "";
/* 14:   */   
/* 15:   */   public String getAleu_ale_cod()
/* 16:   */   {
/* 17:21 */     return this.aleu_ale_cod;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public String getAleu_anio_desde()
/* 21:   */   {
/* 22:24 */     return this.aleu_anio_desde;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public String getAleu_cod()
/* 26:   */   {
/* 27:27 */     return this.aleu_cod;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public String getAleu_des()
/* 31:   */   {
/* 32:30 */     return this.aleu_des;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public String getAleu_novedad()
/* 36:   */   {
/* 37:33 */     return this.aleu_novedad;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public String getAleu_usuf_cod()
/* 41:   */   {
/* 42:36 */     return this.aleu_usuf_cod;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public void setAleu_ale_cod(String aleu_ale_cod)
/* 46:   */   {
/* 47:39 */     this.aleu_ale_cod = aleu_ale_cod;
/* 48:   */   }
/* 49:   */   
/* 50:   */   public void setAleu_anio_desde(String aleu_anio_desde)
/* 51:   */   {
/* 52:42 */     this.aleu_anio_desde = aleu_anio_desde;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public void setAleu_cod(String aleu_cod)
/* 56:   */   {
/* 57:45 */     this.aleu_cod = aleu_cod;
/* 58:   */   }
/* 59:   */   
/* 60:   */   public void setAleu_des(String aleu_des)
/* 61:   */   {
/* 62:48 */     this.aleu_des = aleu_des;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public void setAleu_novedad(String aleu_novedad)
/* 66:   */   {
/* 67:51 */     this.aleu_novedad = aleu_novedad;
/* 68:   */   }
/* 69:   */   
/* 70:   */   public void setAleu_usuf_cod(String aleu_usuf_cod)
/* 71:   */   {
/* 72:54 */     this.aleu_usuf_cod = aleu_usuf_cod;
/* 73:   */   }
/* 74:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.controller.AlergiasUsuarioForm
 * JD-Core Version:    0.7.0.1
 */