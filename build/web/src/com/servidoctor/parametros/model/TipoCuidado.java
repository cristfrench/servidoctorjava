/*  1:   */ package com.servidoctor.parametros.model;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class TipoCuidado
/*  6:   */ {
/*  7:   */   BigDecimal cod_cuidado;
/*  8:   */   String tipo_cuidado;
/*  9:   */   
/* 10:   */   public BigDecimal getCod_cuidado()
/* 11:   */   {
/* 12:26 */     return this.cod_cuidado;
/* 13:   */   }
/* 14:   */   
/* 15:   */   public String getTipo_cuidado()
/* 16:   */   {
/* 17:33 */     return this.tipo_cuidado;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public void setCod_cuidado(BigDecimal decimal)
/* 21:   */   {
/* 22:40 */     this.cod_cuidado = decimal;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public void setTipo_cuidado(String string)
/* 26:   */   {
/* 27:47 */     this.tipo_cuidado = string;
/* 28:   */   }
/* 29:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.model.TipoCuidado
 * JD-Core Version:    0.7.0.1
 */