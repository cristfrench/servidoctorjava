/*  1:   */ package com.servidoctor.parametros.model;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class Grupo
/*  6:   */ {
/*  7:   */   private BigDecimal consecutivo;
/*  8:   */   private String cod_comprador;
/*  9:   */   private String nombre_grupo;
/* 10:   */   private String es_afiliado;
/* 11:   */   private BigDecimal orden;
/* 12:   */   private String orden_usuario;
/* 13:   */   
/* 14:   */   public String getCod_comprador()
/* 15:   */   {
/* 16:20 */     return this.cod_comprador;
/* 17:   */   }
/* 18:   */   
/* 19:   */   public void setCod_comprador(String cod_comprador)
/* 20:   */   {
/* 21:23 */     this.cod_comprador = cod_comprador;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public BigDecimal getConsecutivo()
/* 25:   */   {
/* 26:26 */     return this.consecutivo;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public void setConsecutivo(BigDecimal consecutivo)
/* 30:   */   {
/* 31:29 */     this.consecutivo = consecutivo;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public String getNombre_grupo()
/* 35:   */   {
/* 36:32 */     return this.nombre_grupo;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public void setNombre_grupo(String nombre_grupo)
/* 40:   */   {
/* 41:35 */     this.nombre_grupo = nombre_grupo;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public String getEs_afiliado()
/* 45:   */   {
/* 46:38 */     return this.es_afiliado;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public void setEs_afiliado(String es_afiliado)
/* 50:   */   {
/* 51:41 */     this.es_afiliado = es_afiliado;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public BigDecimal getOrden()
/* 55:   */   {
/* 56:44 */     return this.orden;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public void setOrden(BigDecimal orden)
/* 60:   */   {
/* 61:47 */     this.orden = orden;
/* 62:   */   }
/* 63:   */   
/* 64:   */   public String getOrden_usuario()
/* 65:   */   {
/* 66:50 */     return this.orden_usuario;
/* 67:   */   }
/* 68:   */   
/* 69:   */   public void setOrden_usuario(String orden_usuario)
/* 70:   */   {
/* 71:53 */     this.orden_usuario = orden_usuario;
/* 72:   */   }
/* 73:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.model.Grupo
 * JD-Core Version:    0.7.0.1
 */