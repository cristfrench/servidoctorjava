/*  1:   */ package com.servidoctor.parametros.model;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class EstadoCivil
/*  6:   */ {
/*  7:   */   private BigDecimal eciv_cod;
/*  8:   */   private String eciv_des;
/*  9:   */   
/* 10:   */   public BigDecimal getEciv_cod()
/* 11:   */   {
/* 12:17 */     return this.eciv_cod;
/* 13:   */   }
/* 14:   */   
/* 15:   */   public String getEciv_des()
/* 16:   */   {
/* 17:21 */     return this.eciv_des;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public void setEciv_cod(BigDecimal decimal)
/* 21:   */   {
/* 22:25 */     this.eciv_cod = decimal;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public void setEciv_des(String string)
/* 26:   */   {
/* 27:29 */     this.eciv_des = string;
/* 28:   */   }
/* 29:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.model.EstadoCivil
 * JD-Core Version:    0.7.0.1
 */