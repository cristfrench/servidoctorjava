/*  1:   */ package com.servidoctor.sdfamily.model;
/*  2:   */ 
/*  3:   */ import java.util.ArrayList;
/*  4:   */ import java.util.List;
/*  5:   */ 
/*  6:   */ public class VacunasCompleto
/*  7:   */ {
/*  8:   */   private List tablaUniversal;
/*  9:   */   private List tablaAjustada;
/* 10:   */   private GruposUsuario grupoUsuario;
/* 11:   */   
/* 12:   */   public List getTablaUniversal()
/* 13:   */   {
/* 14:12 */     if (this.tablaUniversal == null) {
/* 15:13 */       this.tablaUniversal = new ArrayList();
/* 16:   */     }
/* 17:15 */     return this.tablaUniversal;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public void setTablaUniversal(List tablaUniversal)
/* 21:   */   {
/* 22:19 */     this.tablaUniversal = tablaUniversal;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public List getTablaAjustada()
/* 26:   */   {
/* 27:23 */     if (this.tablaAjustada == null) {
/* 28:24 */       this.tablaAjustada = new ArrayList();
/* 29:   */     }
/* 30:26 */     return this.tablaAjustada;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public void setTablaAjustada(List tablaAjustada)
/* 34:   */   {
/* 35:30 */     this.tablaAjustada = tablaAjustada;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public GruposUsuario getGrupoUsuario()
/* 39:   */   {
/* 40:34 */     if (this.grupoUsuario == null) {
/* 41:35 */       this.grupoUsuario = new GruposUsuario();
/* 42:   */     }
/* 43:37 */     return this.grupoUsuario;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public void setGrupoUsuario(GruposUsuario grupoUsuario)
/* 47:   */   {
/* 48:41 */     this.grupoUsuario = grupoUsuario;
/* 49:   */   }
/* 50:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.model.VacunasCompleto
 * JD-Core Version:    0.7.0.1
 */