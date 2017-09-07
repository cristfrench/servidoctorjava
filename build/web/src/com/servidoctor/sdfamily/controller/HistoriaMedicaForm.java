/*  1:   */ package com.servidoctor.sdfamily.controller;
/*  2:   */ 
/*  3:   */ import org.apache.struts.validator.ValidatorForm;
/*  4:   */ 
/*  5:   */ public class HistoriaMedicaForm
/*  6:   */   extends ValidatorForm
/*  7:   */ {
/*  8:13 */   private String gine_cod = "0";
/*  9:14 */   private String gine_usuf_cod = "0";
/* 10:15 */   private String gine_tipo_ovul = "0";
/* 11:16 */   private String gine_fec_ult = "0";
/* 12:17 */   private String gine_periodo = "0";
/* 13:18 */   private String gine_frecuencia = "0";
/* 14:   */   
/* 15:   */   public String getGine_cod()
/* 16:   */   {
/* 17:21 */     return this.gine_cod;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public String getGine_fec_ult()
/* 21:   */   {
/* 22:24 */     return this.gine_fec_ult;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public String getGine_frecuencia()
/* 26:   */   {
/* 27:27 */     return this.gine_frecuencia;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public String getGine_periodo()
/* 31:   */   {
/* 32:30 */     return this.gine_periodo;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public String getGine_tipo_ovul()
/* 36:   */   {
/* 37:33 */     return this.gine_tipo_ovul;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public String getGine_usuf_cod()
/* 41:   */   {
/* 42:36 */     return this.gine_usuf_cod;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public void setGine_cod(String gine_cod)
/* 46:   */   {
/* 47:39 */     this.gine_cod = gine_cod;
/* 48:   */   }
/* 49:   */   
/* 50:   */   public void setGine_fec_ult(String gine_fec_ult)
/* 51:   */   {
/* 52:42 */     this.gine_fec_ult = gine_fec_ult;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public void setGine_frecuencia(String gine_frecuencia)
/* 56:   */   {
/* 57:45 */     this.gine_frecuencia = gine_frecuencia;
/* 58:   */   }
/* 59:   */   
/* 60:   */   public void setGine_periodo(String gine_periodo)
/* 61:   */   {
/* 62:48 */     this.gine_periodo = gine_periodo;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public void setGine_tipo_ovul(String gine_tipo_ovul)
/* 66:   */   {
/* 67:51 */     this.gine_tipo_ovul = gine_tipo_ovul;
/* 68:   */   }
/* 69:   */   
/* 70:   */   public void setGine_usuf_cod(String gine_usuf_cod)
/* 71:   */   {
/* 72:54 */     this.gine_usuf_cod = gine_usuf_cod;
/* 73:   */   }
/* 74:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.controller.HistoriaMedicaForm
 * JD-Core Version:    0.7.0.1
 */