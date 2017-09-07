/*  1:   */ package com.servidoctor.sdcars.controller;
/*  2:   */ 
/*  3:   */ import org.apache.struts.validator.ValidatorForm;
/*  4:   */ 
/*  5:   */ public class ControlesVehiculosForm
/*  6:   */   extends ValidatorForm
/*  7:   */ {
/*  8:13 */   private String cveh_cod = "0";
/*  9:14 */   private String cveh_veh_cod = "0";
/* 10:15 */   private String cveh_concepto = "";
/* 11:16 */   private String cveh_fecvigenc = "0";
/* 12:17 */   private String cveh_grup_cod = "0";
/* 13:18 */   private String cveh_mails_enviados = "0";
/* 14:19 */   private String cveh_ultimo_mail = "0";
/* 15:   */   
/* 16:   */   public String getCveh_cod()
/* 17:   */   {
/* 18:22 */     return this.cveh_cod;
/* 19:   */   }
/* 20:   */   
/* 21:   */   public String getCveh_concepto()
/* 22:   */   {
/* 23:26 */     return this.cveh_concepto;
/* 24:   */   }
/* 25:   */   
/* 26:   */   public String getCveh_fecvigenc()
/* 27:   */   {
/* 28:30 */     return this.cveh_fecvigenc;
/* 29:   */   }
/* 30:   */   
/* 31:   */   public String getCveh_veh_cod()
/* 32:   */   {
/* 33:34 */     return this.cveh_veh_cod;
/* 34:   */   }
/* 35:   */   
/* 36:   */   public void setCveh_cod(String string)
/* 37:   */   {
/* 38:38 */     this.cveh_cod = string;
/* 39:   */   }
/* 40:   */   
/* 41:   */   public void setCveh_concepto(String string)
/* 42:   */   {
/* 43:42 */     this.cveh_concepto = string;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public void setCveh_fecvigenc(String string)
/* 47:   */   {
/* 48:46 */     this.cveh_fecvigenc = string;
/* 49:   */   }
/* 50:   */   
/* 51:   */   public void setCveh_veh_cod(String string)
/* 52:   */   {
/* 53:50 */     this.cveh_veh_cod = string;
/* 54:   */   }
/* 55:   */   
/* 56:   */   public String getCveh_grup_cod()
/* 57:   */   {
/* 58:54 */     return this.cveh_grup_cod;
/* 59:   */   }
/* 60:   */   
/* 61:   */   public String getCveh_mails_enviados()
/* 62:   */   {
/* 63:58 */     return this.cveh_mails_enviados;
/* 64:   */   }
/* 65:   */   
/* 66:   */   public String getCveh_ultimo_mail()
/* 67:   */   {
/* 68:62 */     return this.cveh_ultimo_mail;
/* 69:   */   }
/* 70:   */   
/* 71:   */   public void setCveh_grup_cod(String cveh_grup_cod)
/* 72:   */   {
/* 73:66 */     this.cveh_grup_cod = cveh_grup_cod;
/* 74:   */   }
/* 75:   */   
/* 76:   */   public void setCveh_mails_enviados(String cveh_mails_enviados)
/* 77:   */   {
/* 78:70 */     this.cveh_mails_enviados = cveh_mails_enviados;
/* 79:   */   }
/* 80:   */   
/* 81:   */   public void setCveh_ultimo_mail(String cveh_ultimo_mail)
/* 82:   */   {
/* 83:74 */     this.cveh_ultimo_mail = cveh_ultimo_mail;
/* 84:   */   }
/* 85:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdcars.controller.ControlesVehiculosForm
 * JD-Core Version:    0.7.0.1
 */