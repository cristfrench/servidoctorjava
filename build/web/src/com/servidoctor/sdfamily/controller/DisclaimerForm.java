/*  1:   */ package com.servidoctor.sdfamily.controller;
/*  2:   */ 
/*  3:   */ import org.apache.struts.validator.ValidatorForm;
/*  4:   */ 
/*  5:   */ public class DisclaimerForm
/*  6:   */   extends ValidatorForm
/*  7:   */ {
/*  8:14 */   private String parent_usuf_cod = "0";
/*  9:15 */   private String parent_nombre = "";
/* 10:16 */   private String parent_apellido = "";
/* 11:17 */   private String parent_tarjeta = "0";
/* 12:18 */   private String parent_rfam_cod = "0";
/* 13:   */   
/* 14:   */   public String getParent_apellido()
/* 15:   */   {
/* 16:21 */     return this.parent_apellido;
/* 17:   */   }
/* 18:   */   
/* 19:   */   public String getParent_nombre()
/* 20:   */   {
/* 21:24 */     return this.parent_nombre;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public String getParent_rfam_cod()
/* 25:   */   {
/* 26:27 */     return this.parent_rfam_cod;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public String getParent_tarjeta()
/* 30:   */   {
/* 31:30 */     return this.parent_tarjeta;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public String getParent_usuf_cod()
/* 35:   */   {
/* 36:33 */     return this.parent_usuf_cod;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public void setParent_apellido(String parent_apellido)
/* 40:   */   {
/* 41:36 */     this.parent_apellido = parent_apellido;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public void setParent_nombre(String parent_nombre)
/* 45:   */   {
/* 46:39 */     this.parent_nombre = parent_nombre;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public void setParent_rfam_cod(String parent_rfam_cod)
/* 50:   */   {
/* 51:42 */     this.parent_rfam_cod = parent_rfam_cod;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public void setParent_tarjeta(String parent_tarjeta)
/* 55:   */   {
/* 56:45 */     this.parent_tarjeta = parent_tarjeta;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public void setParent_usuf_cod(String parent_usuf_cod)
/* 60:   */   {
/* 61:48 */     this.parent_usuf_cod = parent_usuf_cod;
/* 62:   */   }
/* 63:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.controller.DisclaimerForm
 * JD-Core Version:    0.7.0.1
 */