/*  1:   */ package com.servidoctor.parametros.model;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class Idioma
/*  6:   */ {
/*  7:   */   private BigDecimal idio_cod;
/*  8:   */   private String idio_descripcion;
/*  9:   */   private String idio_description;
/* 10:   */   private String idio_abreviacion;
/* 11:   */   
/* 12:   */   public String getIdio_abreviacion()
/* 13:   */   {
/* 14:21 */     return this.idio_abreviacion;
/* 15:   */   }
/* 16:   */   
/* 17:   */   public BigDecimal getIdio_cod()
/* 18:   */   {
/* 19:28 */     return this.idio_cod;
/* 20:   */   }
/* 21:   */   
/* 22:   */   public String getIdio_descripcion()
/* 23:   */   {
/* 24:35 */     return this.idio_descripcion;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public void setIdio_abreviacion(String string)
/* 28:   */   {
/* 29:42 */     this.idio_abreviacion = string;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public void setIdio_cod(BigDecimal decimal)
/* 33:   */   {
/* 34:49 */     this.idio_cod = decimal;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public void setIdio_descripcion(String string)
/* 38:   */   {
/* 39:56 */     this.idio_descripcion = string;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public String getIdio_description()
/* 43:   */   {
/* 44:60 */     return this.idio_description;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public void setIdio_description(String idio_description)
/* 48:   */   {
/* 49:64 */     this.idio_description = idio_description;
/* 50:   */   }
/* 51:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.model.Idioma
 * JD-Core Version:    0.7.0.1
 */