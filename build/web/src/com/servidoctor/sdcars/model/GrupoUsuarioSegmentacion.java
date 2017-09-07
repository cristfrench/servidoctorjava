/*  1:   */ package com.servidoctor.sdcars.model;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class GrupoUsuarioSegmentacion
/*  6:   */ {
/*  7:   */   private BigDecimal consecutivo;
/*  8:   */   private String usuario_id;
/*  9:   */   private BigDecimal grupo_id;
/* 10:   */   
/* 11:   */   public BigDecimal getConsecutivo()
/* 12:   */   {
/* 13:17 */     return this.consecutivo;
/* 14:   */   }
/* 15:   */   
/* 16:   */   public void setConsecutivo(BigDecimal consecutivo)
/* 17:   */   {
/* 18:20 */     this.consecutivo = consecutivo;
/* 19:   */   }
/* 20:   */   
/* 21:   */   public BigDecimal getGrupo_id()
/* 22:   */   {
/* 23:23 */     return this.grupo_id;
/* 24:   */   }
/* 25:   */   
/* 26:   */   public void setGrupo_id(BigDecimal grupo_id)
/* 27:   */   {
/* 28:26 */     this.grupo_id = grupo_id;
/* 29:   */   }
/* 30:   */   
/* 31:   */   public String getUsuario_id()
/* 32:   */   {
/* 33:29 */     return this.usuario_id;
/* 34:   */   }
/* 35:   */   
/* 36:   */   public void setUsuario_id(String usuario_id)
/* 37:   */   {
/* 38:32 */     this.usuario_id = usuario_id;
/* 39:   */   }
/* 40:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdcars.model.GrupoUsuarioSegmentacion
 * JD-Core Version:    0.7.0.1
 */