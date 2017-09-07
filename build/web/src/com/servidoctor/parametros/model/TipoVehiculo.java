/*  1:   */ package com.servidoctor.parametros.model;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class TipoVehiculo
/*  6:   */ {
/*  7:   */   BigDecimal tveh_cod;
/*  8:   */   String tveh_des;
/*  9:   */   
/* 10:   */   public BigDecimal getTveh_cod()
/* 11:   */   {
/* 12:28 */     return this.tveh_cod;
/* 13:   */   }
/* 14:   */   
/* 15:   */   public String getTveh_des()
/* 16:   */   {
/* 17:35 */     return this.tveh_des;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public void setTveh_cod(BigDecimal decimal)
/* 21:   */   {
/* 22:42 */     this.tveh_cod = decimal;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public void setTveh_des(String string)
/* 26:   */   {
/* 27:49 */     this.tveh_des = string;
/* 28:   */   }
/* 29:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.model.TipoVehiculo
 * JD-Core Version:    0.7.0.1
 */