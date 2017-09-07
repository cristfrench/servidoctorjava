/*  1:   */ package com.servidoctor.sdpets.controller;
/*  2:   */ 
/*  3:   */ import org.apache.struts.validator.ValidatorForm;
/*  4:   */ 
/*  5:   */ public class EnfermedadesPetsForm
/*  6:   */   extends ValidatorForm
/*  7:   */ {
/*  8:14 */   private String enfp_cod = "0";
/*  9:15 */   private String enfp_mas_cod = "0";
/* 10:16 */   private String enfp_des = "";
/* 11:17 */   private String enfp_anio_desde = "0";
/* 12:18 */   private String enfp_novedad = "";
/* 13:   */   
/* 14:   */   public String getEnfp_cod()
/* 15:   */   {
/* 16:20 */     return this.enfp_cod;
/* 17:   */   }
/* 18:   */   
/* 19:   */   public void setEnfp_cod(String enfpCod)
/* 20:   */   {
/* 21:23 */     this.enfp_cod = enfpCod;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public String getEnfp_mas_cod()
/* 25:   */   {
/* 26:26 */     return this.enfp_mas_cod;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public void setEnfp_mas_cod(String enfpMasCod)
/* 30:   */   {
/* 31:29 */     this.enfp_mas_cod = enfpMasCod;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public String getEnfp_des()
/* 35:   */   {
/* 36:32 */     return this.enfp_des;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public void setEnfp_des(String enfpDes)
/* 40:   */   {
/* 41:35 */     this.enfp_des = enfpDes;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public String getEnfp_anio_desde()
/* 45:   */   {
/* 46:38 */     return this.enfp_anio_desde;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public void setEnfp_anio_desde(String enfpAnioDesde)
/* 50:   */   {
/* 51:41 */     this.enfp_anio_desde = enfpAnioDesde;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public String getEnfp_novedad()
/* 55:   */   {
/* 56:44 */     return this.enfp_novedad;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public void setEnfp_novedad(String enfpNovedad)
/* 60:   */   {
/* 61:47 */     this.enfp_novedad = enfpNovedad;
/* 62:   */   }
/* 63:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdpets.controller.EnfermedadesPetsForm
 * JD-Core Version:    0.7.0.1
 */