/*  1:   */ package com.servidoctor.sdfamily.model;
/*  2:   */ 
/*  3:   */ import java.util.ArrayList;
/*  4:   */ import java.util.List;
/*  5:   */ 
/*  6:   */ public class DatosPersonalesCompleto
/*  7:   */ {
/*  8:   */   private DatosPersonales datosPersonales;
/*  9:   */   private UsuarioParent usuarioParent;
/* 10:   */   private List contactos;
/* 11:   */   private List seguros;
/* 12:   */   private GruposUsuario grupoUsuario;
/* 13:   */   
/* 14:   */   public List getContactos()
/* 15:   */   {
/* 16:21 */     if (this.contactos == null) {
/* 17:22 */       this.contactos = new ArrayList();
/* 18:   */     }
/* 19:24 */     return this.contactos;
/* 20:   */   }
/* 21:   */   
/* 22:   */   public DatosPersonales getDatosPersonales()
/* 23:   */   {
/* 24:28 */     if (this.datosPersonales == null) {
/* 25:29 */       this.datosPersonales = new DatosPersonales();
/* 26:   */     }
/* 27:31 */     return this.datosPersonales;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public List getSeguros()
/* 31:   */   {
/* 32:35 */     if (this.seguros == null) {
/* 33:36 */       this.seguros = new ArrayList();
/* 34:   */     }
/* 35:38 */     return this.seguros;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public UsuarioParent getUsuarioParent()
/* 39:   */   {
/* 40:42 */     if (this.usuarioParent == null) {
/* 41:43 */       this.usuarioParent = new UsuarioParent();
/* 42:   */     }
/* 43:45 */     return this.usuarioParent;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public void setContactos(List contactos)
/* 47:   */   {
/* 48:49 */     this.contactos = contactos;
/* 49:   */   }
/* 50:   */   
/* 51:   */   public void setDatosPersonales(DatosPersonales datosPersonales)
/* 52:   */   {
/* 53:53 */     this.datosPersonales = datosPersonales;
/* 54:   */   }
/* 55:   */   
/* 56:   */   public void setSeguros(List seguros)
/* 57:   */   {
/* 58:57 */     this.seguros = seguros;
/* 59:   */   }
/* 60:   */   
/* 61:   */   public void setUsuarioParent(UsuarioParent usuarioParent)
/* 62:   */   {
/* 63:61 */     this.usuarioParent = usuarioParent;
/* 64:   */   }
/* 65:   */   
/* 66:   */   public GruposUsuario getGrupoUsuario()
/* 67:   */   {
/* 68:65 */     if (this.grupoUsuario == null) {
/* 69:66 */       this.grupoUsuario = new GruposUsuario();
/* 70:   */     }
/* 71:68 */     return this.grupoUsuario;
/* 72:   */   }
/* 73:   */   
/* 74:   */   public void setGrupoUsuario(GruposUsuario grupoUsuario)
/* 75:   */   {
/* 76:72 */     this.grupoUsuario = grupoUsuario;
/* 77:   */   }
/* 78:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.model.DatosPersonalesCompleto
 * JD-Core Version:    0.7.0.1
 */