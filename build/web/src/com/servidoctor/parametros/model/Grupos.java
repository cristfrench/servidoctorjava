/*  1:   */ package com.servidoctor.parametros.model;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class Grupos
/*  6:   */ {
/*  7:   */   private BigDecimal grup_cod;
/*  8:   */   private BigDecimal grup_tipg_cod;
/*  9:   */   private String grup_desc;
/* 10:   */   private BigDecimal grup_dias_antes;
/* 11:   */   
/* 12:   */   public BigDecimal getGrup_cod()
/* 13:   */   {
/* 14:21 */     return this.grup_cod;
/* 15:   */   }
/* 16:   */   
/* 17:   */   public String getGrup_desc()
/* 18:   */   {
/* 19:25 */     return this.grup_desc;
/* 20:   */   }
/* 21:   */   
/* 22:   */   public BigDecimal getGrup_dias_antes()
/* 23:   */   {
/* 24:29 */     return this.grup_dias_antes;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public BigDecimal getGrup_tipg_cod()
/* 28:   */   {
/* 29:33 */     return this.grup_tipg_cod;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public void setGrup_cod(BigDecimal decimal)
/* 33:   */   {
/* 34:37 */     this.grup_cod = decimal;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public void setGrup_desc(String string)
/* 38:   */   {
/* 39:41 */     this.grup_desc = string;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public void setGrup_dias_antes(BigDecimal decimal)
/* 43:   */   {
/* 44:45 */     this.grup_dias_antes = decimal;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public void setGrup_tipg_cod(BigDecimal decimal)
/* 48:   */   {
/* 49:49 */     this.grup_tipg_cod = decimal;
/* 50:   */   }
/* 51:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.model.Grupos
 * JD-Core Version:    0.7.0.1
 */