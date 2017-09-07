/*  1:   */ package com.servidoctor.parametros.model;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class ResultadoExamen
/*  6:   */ {
/*  7:19 */   BigDecimal rexa_cod = new BigDecimal("0");
/*  8:20 */   String rexa_des = "";
/*  9:21 */   BigDecimal rexa_elab_cod = new BigDecimal("0");
/* 10:22 */   BigDecimal rexa_desde = new BigDecimal("0");
/* 11:23 */   BigDecimal rexa_hasta = new BigDecimal("0");
/* 12:   */   
/* 13:   */   public BigDecimal getRexa_cod()
/* 14:   */   {
/* 15:29 */     return this.rexa_cod;
/* 16:   */   }
/* 17:   */   
/* 18:   */   public String getRexa_des()
/* 19:   */   {
/* 20:36 */     return this.rexa_des;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public BigDecimal getRexa_desde()
/* 24:   */   {
/* 25:43 */     return this.rexa_desde;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public BigDecimal getRexa_elab_cod()
/* 29:   */   {
/* 30:50 */     return this.rexa_elab_cod;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public BigDecimal getRexa_hasta()
/* 34:   */   {
/* 35:57 */     return this.rexa_hasta;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public void setRexa_cod(BigDecimal decimal)
/* 39:   */   {
/* 40:64 */     this.rexa_cod = decimal;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public void setRexa_des(String string)
/* 44:   */   {
/* 45:71 */     this.rexa_des = string;
/* 46:   */   }
/* 47:   */   
/* 48:   */   public void setRexa_desde(BigDecimal decimal)
/* 49:   */   {
/* 50:78 */     this.rexa_desde = decimal;
/* 51:   */   }
/* 52:   */   
/* 53:   */   public void setRexa_elab_cod(BigDecimal decimal)
/* 54:   */   {
/* 55:85 */     this.rexa_elab_cod = decimal;
/* 56:   */   }
/* 57:   */   
/* 58:   */   public void setRexa_hasta(BigDecimal decimal)
/* 59:   */   {
/* 60:92 */     this.rexa_hasta = decimal;
/* 61:   */   }
/* 62:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.model.ResultadoExamen
 * JD-Core Version:    0.7.0.1
 */