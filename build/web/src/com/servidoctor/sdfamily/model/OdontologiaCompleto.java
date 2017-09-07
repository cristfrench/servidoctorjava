/*  1:   */ package com.servidoctor.sdfamily.model;
/*  2:   */ 
/*  3:   */ import java.util.ArrayList;
/*  4:   */ import java.util.List;
/*  5:   */ 
/*  6:   */ public class OdontologiaCompleto
/*  7:   */ {
/*  8:   */   private List tablaUniversal;
/*  9:   */   private List tablaAjustada;
/* 10:   */   private List controlesAnteriores;
/* 11:   */   private List controlesProximos;
/* 12:   */   private GruposUsuario grupoUsuario;
/* 13:   */   
/* 14:   */   public List getControlesAnteriores()
/* 15:   */   {
/* 16:22 */     if (this.controlesAnteriores == null) {
/* 17:23 */       this.controlesAnteriores = new ArrayList();
/* 18:   */     }
/* 19:25 */     return this.controlesAnteriores;
/* 20:   */   }
/* 21:   */   
/* 22:   */   public List getControlesProximos()
/* 23:   */   {
/* 24:29 */     if (this.controlesProximos == null) {
/* 25:30 */       this.controlesProximos = new ArrayList();
/* 26:   */     }
/* 27:32 */     return this.controlesProximos;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public List getTablaAjustada()
/* 31:   */   {
/* 32:36 */     if (this.tablaAjustada == null) {
/* 33:37 */       this.tablaAjustada = new ArrayList();
/* 34:   */     }
/* 35:39 */     return this.tablaAjustada;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public List getTablaUniversal()
/* 39:   */   {
/* 40:43 */     if (this.tablaUniversal == null) {
/* 41:44 */       this.tablaUniversal = new ArrayList();
/* 42:   */     }
/* 43:46 */     return this.tablaUniversal;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public void setControlesAnteriores(List list)
/* 47:   */   {
/* 48:50 */     this.controlesAnteriores = list;
/* 49:   */   }
/* 50:   */   
/* 51:   */   public void setControlesProximos(List list)
/* 52:   */   {
/* 53:54 */     this.controlesProximos = list;
/* 54:   */   }
/* 55:   */   
/* 56:   */   public void setTablaAjustada(List list)
/* 57:   */   {
/* 58:58 */     this.tablaAjustada = list;
/* 59:   */   }
/* 60:   */   
/* 61:   */   public void setTablaUniversal(List list)
/* 62:   */   {
/* 63:62 */     this.tablaUniversal = list;
/* 64:   */   }
/* 65:   */   
/* 66:   */   public GruposUsuario getGrupoUsuario()
/* 67:   */   {
/* 68:66 */     if (this.grupoUsuario == null) {
/* 69:67 */       this.grupoUsuario = new GruposUsuario();
/* 70:   */     }
/* 71:69 */     return this.grupoUsuario;
/* 72:   */   }
/* 73:   */   
/* 74:   */   public void setGrupoUsuario(GruposUsuario grupoUsuario)
/* 75:   */   {
/* 76:73 */     this.grupoUsuario = grupoUsuario;
/* 77:   */   }
/* 78:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.model.OdontologiaCompleto
 * JD-Core Version:    0.7.0.1
 */