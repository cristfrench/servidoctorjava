/*  1:   */ package com.servidoctor.sdcars.controller;
/*  2:   */ 
/*  3:   */ import org.apache.struts.validator.ValidatorForm;
/*  4:   */ 
/*  5:   */ public class ImpuestoVehiculoForm
/*  6:   */   extends ValidatorForm
/*  7:   */ {
/*  8:13 */   private String impv_cod = "0";
/*  9:14 */   private String impv_veh_cod = "0";
/* 10:15 */   private String impv_fechapago = "0";
/* 11:16 */   private String impv_vigenciahasta = "0";
/* 12:17 */   private String impv_descripcion = "";
/* 13:18 */   private String impv_grup_cod = "0";
/* 14:19 */   private String impv_mails_enviados = "0";
/* 15:20 */   private String impv_ultimo_mail = "0";
/* 16:   */   
/* 17:   */   public String getImpv_cod()
/* 18:   */   {
/* 19:23 */     return this.impv_cod;
/* 20:   */   }
/* 21:   */   
/* 22:   */   public String getImpv_descripcion()
/* 23:   */   {
/* 24:27 */     return this.impv_descripcion;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public String getImpv_fechapago()
/* 28:   */   {
/* 29:31 */     return this.impv_fechapago;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public String getImpv_veh_cod()
/* 33:   */   {
/* 34:35 */     return this.impv_veh_cod;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public String getImpv_vigenciahasta()
/* 38:   */   {
/* 39:39 */     return this.impv_vigenciahasta;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public void setImpv_cod(String string)
/* 43:   */   {
/* 44:43 */     this.impv_cod = string;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public void setImpv_descripcion(String string)
/* 48:   */   {
/* 49:47 */     this.impv_descripcion = string;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public void setImpv_fechapago(String string)
/* 53:   */   {
/* 54:51 */     this.impv_fechapago = string;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public void setImpv_veh_cod(String string)
/* 58:   */   {
/* 59:55 */     this.impv_veh_cod = string;
/* 60:   */   }
/* 61:   */   
/* 62:   */   public void setImpv_vigenciahasta(String string)
/* 63:   */   {
/* 64:59 */     this.impv_vigenciahasta = string;
/* 65:   */   }
/* 66:   */   
/* 67:   */   public String getImpv_grup_cod()
/* 68:   */   {
/* 69:63 */     return this.impv_grup_cod;
/* 70:   */   }
/* 71:   */   
/* 72:   */   public String getImpv_mails_enviados()
/* 73:   */   {
/* 74:67 */     return this.impv_mails_enviados;
/* 75:   */   }
/* 76:   */   
/* 77:   */   public String getImpv_ultimo_mail()
/* 78:   */   {
/* 79:71 */     return this.impv_ultimo_mail;
/* 80:   */   }
/* 81:   */   
/* 82:   */   public void setImpv_grup_cod(String impv_grup_cod)
/* 83:   */   {
/* 84:75 */     this.impv_grup_cod = impv_grup_cod;
/* 85:   */   }
/* 86:   */   
/* 87:   */   public void setImpv_mails_enviados(String impv_mails_enviados)
/* 88:   */   {
/* 89:79 */     this.impv_mails_enviados = impv_mails_enviados;
/* 90:   */   }
/* 91:   */   
/* 92:   */   public void setImpv_ultimo_mail(String impv_ultimo_mail)
/* 93:   */   {
/* 94:83 */     this.impv_ultimo_mail = impv_ultimo_mail;
/* 95:   */   }
/* 96:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdcars.controller.ImpuestoVehiculoForm
 * JD-Core Version:    0.7.0.1
 */