/*  1:   */ package com.servidoctor.parametros.model;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import java.math.BigDecimal;
/*  5:   */ 
/*  6:   */ public class Revisiones
/*  7:   */   implements Serializable
/*  8:   */ {
/*  9:   */   private BigDecimal rev_cod;
/* 10:   */   private String rev_actividad;
/* 11:   */   private BigDecimal rev_acc_cod;
/* 12:   */   private BigDecimal rev_alt_cod;
/* 13:   */   private BigDecimal rev_cada_cdm;
/* 14:   */   private BigDecimal rev_cada_cdk;
/* 15:   */   
/* 16:   */   public BigDecimal getRev_cod()
/* 17:   */   {
/* 18:23 */     return this.rev_cod;
/* 19:   */   }
/* 20:   */   
/* 21:   */   public void setRev_cod(BigDecimal rev_cod)
/* 22:   */   {
/* 23:27 */     this.rev_cod = rev_cod;
/* 24:   */   }
/* 25:   */   
/* 26:   */   public String getRev_actividad()
/* 27:   */   {
/* 28:31 */     return this.rev_actividad;
/* 29:   */   }
/* 30:   */   
/* 31:   */   public void setRev_actividad(String rev_actividad)
/* 32:   */   {
/* 33:35 */     this.rev_actividad = rev_actividad;
/* 34:   */   }
/* 35:   */   
/* 36:   */   public BigDecimal getRev_acc_cod()
/* 37:   */   {
/* 38:39 */     return this.rev_acc_cod;
/* 39:   */   }
/* 40:   */   
/* 41:   */   public void setRev_acc_cod(BigDecimal rev_acc_cod)
/* 42:   */   {
/* 43:43 */     this.rev_acc_cod = rev_acc_cod;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public BigDecimal getRev_alt_cod()
/* 47:   */   {
/* 48:47 */     return this.rev_alt_cod;
/* 49:   */   }
/* 50:   */   
/* 51:   */   public void setRev_alt_cod(BigDecimal rev_alt_cod)
/* 52:   */   {
/* 53:51 */     this.rev_alt_cod = rev_alt_cod;
/* 54:   */   }
/* 55:   */   
/* 56:   */   public BigDecimal getRev_cada_cdm()
/* 57:   */   {
/* 58:55 */     return this.rev_cada_cdm;
/* 59:   */   }
/* 60:   */   
/* 61:   */   public void setRev_cada_cdm(BigDecimal rev_cada_cdm)
/* 62:   */   {
/* 63:59 */     this.rev_cada_cdm = rev_cada_cdm;
/* 64:   */   }
/* 65:   */   
/* 66:   */   public BigDecimal getRev_cada_cdk()
/* 67:   */   {
/* 68:63 */     return this.rev_cada_cdk;
/* 69:   */   }
/* 70:   */   
/* 71:   */   public void setRev_cada_cdk(BigDecimal rev_cada_cdk)
/* 72:   */   {
/* 73:67 */     this.rev_cada_cdk = rev_cada_cdk;
/* 74:   */   }
/* 75:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.model.Revisiones
 * JD-Core Version:    0.7.0.1
 */