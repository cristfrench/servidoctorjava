/*  1:   */ package com.servidoctor.parametros.model;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class ArtesMayor
/*  6:   */ {
/*  7:   */   private BigDecimal artm_cod;
/*  8:   */   private String artm_may_cod;
/*  9:   */   private BigDecimal artm_consecutivo;
/* 10:   */   private String artm_ruta;
/* 11:   */   private String artm_nombre_grupo;
/* 12:   */   
/* 13:   */   public BigDecimal getArtm_cod()
/* 14:   */   {
/* 15:20 */     return this.artm_cod;
/* 16:   */   }
/* 17:   */   
/* 18:   */   public String getArtm_may_cod()
/* 19:   */   {
/* 20:24 */     return this.artm_may_cod;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public String getArtm_ruta()
/* 24:   */   {
/* 25:28 */     return this.artm_ruta;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public void setArtm_cod(BigDecimal decimal)
/* 29:   */   {
/* 30:32 */     this.artm_cod = decimal;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public void setArtm_may_cod(String string)
/* 34:   */   {
/* 35:36 */     this.artm_may_cod = string;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public void setArtm_ruta(String string)
/* 39:   */   {
/* 40:40 */     this.artm_ruta = string;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public BigDecimal getArtm_consecutivo()
/* 44:   */   {
/* 45:44 */     return this.artm_consecutivo;
/* 46:   */   }
/* 47:   */   
/* 48:   */   public void setArtm_consecutivo(BigDecimal artm_consecutivo)
/* 49:   */   {
/* 50:48 */     this.artm_consecutivo = artm_consecutivo;
/* 51:   */   }
/* 52:   */   
/* 53:   */   public String getArtm_nombre_grupo()
/* 54:   */   {
/* 55:52 */     return this.artm_nombre_grupo;
/* 56:   */   }
/* 57:   */   
/* 58:   */   public void setArtm_nombre_grupo(String artm_nombre_grupo)
/* 59:   */   {
/* 60:56 */     this.artm_nombre_grupo = artm_nombre_grupo;
/* 61:   */   }
/* 62:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.model.ArtesMayor
 * JD-Core Version:    0.7.0.1
 */