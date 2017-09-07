/*  1:   */ package com.servidoctor.sdfamily.controller;
/*  2:   */ 
/*  3:   */ import org.apache.struts.validator.ValidatorForm;
/*  4:   */ 
/*  5:   */ public class UsuarioEnfermedadesForm
/*  6:   */   extends ValidatorForm
/*  7:   */ {
/*  8:14 */   private String enfu_cod = "0";
/*  9:15 */   private String enfu_usuf_cod = "0";
/* 10:16 */   private String enfu_sis_cod = "0";
/* 11:17 */   private String enfu_des = "";
/* 12:18 */   private String enfu_enf_cod = "0";
/* 13:19 */   private String enfu_anio_desde = "0";
/* 14:20 */   private String enfu_novedad = "";
/* 15:   */   
/* 16:   */   public String getEnfu_anio_desde()
/* 17:   */   {
/* 18:23 */     return this.enfu_anio_desde;
/* 19:   */   }
/* 20:   */   
/* 21:   */   public String getEnfu_cod()
/* 22:   */   {
/* 23:26 */     return this.enfu_cod;
/* 24:   */   }
/* 25:   */   
/* 26:   */   public String getEnfu_des()
/* 27:   */   {
/* 28:29 */     return this.enfu_des;
/* 29:   */   }
/* 30:   */   
/* 31:   */   public String getEnfu_enf_cod()
/* 32:   */   {
/* 33:32 */     return this.enfu_enf_cod;
/* 34:   */   }
/* 35:   */   
/* 36:   */   public String getEnfu_novedad()
/* 37:   */   {
/* 38:35 */     return this.enfu_novedad;
/* 39:   */   }
/* 40:   */   
/* 41:   */   public String getEnfu_sis_cod()
/* 42:   */   {
/* 43:38 */     return this.enfu_sis_cod;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public String getEnfu_usuf_cod()
/* 47:   */   {
/* 48:41 */     return this.enfu_usuf_cod;
/* 49:   */   }
/* 50:   */   
/* 51:   */   public void setEnfu_anio_desde(String enfu_anio_desde)
/* 52:   */   {
/* 53:44 */     this.enfu_anio_desde = enfu_anio_desde;
/* 54:   */   }
/* 55:   */   
/* 56:   */   public void setEnfu_cod(String enfu_cod)
/* 57:   */   {
/* 58:47 */     this.enfu_cod = enfu_cod;
/* 59:   */   }
/* 60:   */   
/* 61:   */   public void setEnfu_des(String enfu_des)
/* 62:   */   {
/* 63:50 */     this.enfu_des = enfu_des;
/* 64:   */   }
/* 65:   */   
/* 66:   */   public void setEnfu_enf_cod(String enfu_enf_cod)
/* 67:   */   {
/* 68:53 */     this.enfu_enf_cod = enfu_enf_cod;
/* 69:   */   }
/* 70:   */   
/* 71:   */   public void setEnfu_novedad(String enfu_novedad)
/* 72:   */   {
/* 73:56 */     this.enfu_novedad = enfu_novedad;
/* 74:   */   }
/* 75:   */   
/* 76:   */   public void setEnfu_sis_cod(String enfu_sis_cod)
/* 77:   */   {
/* 78:59 */     this.enfu_sis_cod = enfu_sis_cod;
/* 79:   */   }
/* 80:   */   
/* 81:   */   public void setEnfu_usuf_cod(String enfu_usuf_cod)
/* 82:   */   {
/* 83:62 */     this.enfu_usuf_cod = enfu_usuf_cod;
/* 84:   */   }
/* 85:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.controller.UsuarioEnfermedadesForm
 * JD-Core Version:    0.7.0.1
 */