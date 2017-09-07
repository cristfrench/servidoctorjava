/*  1:   */ package com.servidoctor.seguridad.model;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import java.math.BigDecimal;
/*  5:   */ 
/*  6:   */ public class Compras_productos
/*  7:   */   implements Serializable
/*  8:   */ {
/*  9:   */   private String compras_merchant_id;
/* 10:   */   private BigDecimal grp_precio_id;
/* 11:   */   private BigDecimal compras_productos_cantidad;
/* 12:   */   
/* 13:   */   public String getCompras_merchant_id()
/* 14:   */   {
/* 15:20 */     return this.compras_merchant_id;
/* 16:   */   }
/* 17:   */   
/* 18:   */   public void setCompras_merchant_id(String compras_merchant_id)
/* 19:   */   {
/* 20:23 */     this.compras_merchant_id = compras_merchant_id;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public BigDecimal getCompras_productos_cantidad()
/* 24:   */   {
/* 25:26 */     return this.compras_productos_cantidad;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public void setCompras_productos_cantidad(BigDecimal compras_productos_cantidad)
/* 29:   */   {
/* 30:29 */     this.compras_productos_cantidad = compras_productos_cantidad;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public BigDecimal getGrp_precio_id()
/* 34:   */   {
/* 35:32 */     return this.grp_precio_id;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public void setGrp_precio_id(BigDecimal grp_precio_id)
/* 39:   */   {
/* 40:35 */     this.grp_precio_id = grp_precio_id;
/* 41:   */   }
/* 42:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.seguridad.model.Compras_productos
 * JD-Core Version:    0.7.0.1
 */