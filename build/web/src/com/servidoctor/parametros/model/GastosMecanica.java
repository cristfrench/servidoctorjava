/*  1:   */ package com.servidoctor.parametros.model;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import java.math.BigDecimal;
/*  5:   */ 
/*  6:   */ public class GastosMecanica
/*  7:   */   implements Serializable
/*  8:   */ {
/*  9:   */   private BigDecimal gas_cod;
/* 10:   */   private String gas_descripcion;
/* 11:   */   
/* 12:   */   public BigDecimal getGas_cod()
/* 13:   */   {
/* 14:18 */     return this.gas_cod;
/* 15:   */   }
/* 16:   */   
/* 17:   */   public void setGas_cod(BigDecimal gas_cod)
/* 18:   */   {
/* 19:22 */     this.gas_cod = gas_cod;
/* 20:   */   }
/* 21:   */   
/* 22:   */   public String getGas_descripcion()
/* 23:   */   {
/* 24:26 */     return this.gas_descripcion;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public void setGas_descripcion(String gas_descripcion)
/* 28:   */   {
/* 29:30 */     this.gas_descripcion = gas_descripcion;
/* 30:   */   }
/* 31:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.model.GastosMecanica
 * JD-Core Version:    0.7.0.1
 */