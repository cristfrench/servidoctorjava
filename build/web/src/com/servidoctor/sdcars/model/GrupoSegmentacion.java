/*  1:   */ package com.servidoctor.sdcars.model;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class GrupoSegmentacion
/*  6:   */ {
/*  7:   */   private BigDecimal consecutivo;
/*  8:   */   private String cod_usuario;
/*  9:   */   private String nombre_grupo;
/* 10:   */   private String afiliado;
/* 11:   */   
/* 12:   */   public String getAfiliado()
/* 13:   */   {
/* 14:17 */     return this.afiliado;
/* 15:   */   }
/* 16:   */   
/* 17:   */   public void setAfiliado(String afiliado)
/* 18:   */   {
/* 19:20 */     this.afiliado = afiliado;
/* 20:   */   }
/* 21:   */   
/* 22:   */   public String getCod_usuario()
/* 23:   */   {
/* 24:23 */     return this.cod_usuario;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public void setCod_usuario(String cod_usuario)
/* 28:   */   {
/* 29:26 */     this.cod_usuario = cod_usuario;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public BigDecimal getConsecutivo()
/* 33:   */   {
/* 34:29 */     return this.consecutivo;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public void setConsecutivo(BigDecimal consecutivo)
/* 38:   */   {
/* 39:32 */     this.consecutivo = consecutivo;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public String getNombre_grupo()
/* 43:   */   {
/* 44:35 */     return this.nombre_grupo;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public void setNombre_grupo(String nombre_grupo)
/* 48:   */   {
/* 49:38 */     this.nombre_grupo = nombre_grupo;
/* 50:   */   }
/* 51:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdcars.model.GrupoSegmentacion
 * JD-Core Version:    0.7.0.1
 */