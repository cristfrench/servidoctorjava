/*  1:   */ package com.servidoctor.parametros.model;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class Ciudades
/*  6:   */ {
/*  7:   */   private BigDecimal pais_cod;
/*  8:   */   private BigDecimal ciu_cod;
/*  9:   */   private String ciu_des;
/* 10:   */   
/* 11:   */   public BigDecimal getCiu_cod()
/* 12:   */   {
/* 13:18 */     return this.ciu_cod;
/* 14:   */   }
/* 15:   */   
/* 16:   */   public String getCiu_des()
/* 17:   */   {
/* 18:22 */     return this.ciu_des;
/* 19:   */   }
/* 20:   */   
/* 21:   */   public BigDecimal getPais_cod()
/* 22:   */   {
/* 23:26 */     return this.pais_cod;
/* 24:   */   }
/* 25:   */   
/* 26:   */   public void setCiu_cod(BigDecimal decimal)
/* 27:   */   {
/* 28:30 */     this.ciu_cod = decimal;
/* 29:   */   }
/* 30:   */   
/* 31:   */   public void setCiu_des(String string)
/* 32:   */   {
/* 33:34 */     this.ciu_des = string;
/* 34:   */   }
/* 35:   */   
/* 36:   */   public void setPais_cod(BigDecimal decimal)
/* 37:   */   {
/* 38:38 */     this.pais_cod = decimal;
/* 39:   */   }
/* 40:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.model.Ciudades
 * JD-Core Version:    0.7.0.1
 */