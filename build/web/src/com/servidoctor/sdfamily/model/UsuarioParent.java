/*  1:   */ package com.servidoctor.sdfamily.model;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class UsuarioParent
/*  6:   */ {
/*  7:   */   private BigDecimal parent_usuf_cod;
/*  8:   */   private String parent_nombre;
/*  9:   */   private String parent_apellido;
/* 10:   */   private String parent_tarjeta;
/* 11:   */   private BigDecimal parent_rfam_cod;
/* 12:   */   
/* 13:   */   public String getParent_apellido()
/* 14:   */   {
/* 15:20 */     return this.parent_apellido;
/* 16:   */   }
/* 17:   */   
/* 18:   */   public String getParent_nombre()
/* 19:   */   {
/* 20:23 */     return this.parent_nombre;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public BigDecimal getParent_rfam_cod()
/* 24:   */   {
/* 25:26 */     return this.parent_rfam_cod;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public String getParent_tarjeta()
/* 29:   */   {
/* 30:29 */     return this.parent_tarjeta;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public BigDecimal getParent_usuf_cod()
/* 34:   */   {
/* 35:32 */     return this.parent_usuf_cod;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public void setParent_apellido(String parent_apellido)
/* 39:   */   {
/* 40:35 */     this.parent_apellido = parent_apellido;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public void setParent_nombre(String parent_nombre)
/* 44:   */   {
/* 45:38 */     this.parent_nombre = parent_nombre;
/* 46:   */   }
/* 47:   */   
/* 48:   */   public void setParent_rfam_cod(BigDecimal parent_rfam_cod)
/* 49:   */   {
/* 50:41 */     this.parent_rfam_cod = parent_rfam_cod;
/* 51:   */   }
/* 52:   */   
/* 53:   */   public void setParent_tarjeta(String parent_tarjeta)
/* 54:   */   {
/* 55:44 */     this.parent_tarjeta = parent_tarjeta;
/* 56:   */   }
/* 57:   */   
/* 58:   */   public void setParent_usuf_cod(BigDecimal parent_usuf_cod)
/* 59:   */   {
/* 60:47 */     this.parent_usuf_cod = parent_usuf_cod;
/* 61:   */   }
/* 62:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.model.UsuarioParent
 * JD-Core Version:    0.7.0.1
 */