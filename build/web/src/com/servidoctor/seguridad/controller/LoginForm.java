/*  1:   */ package com.servidoctor.seguridad.controller;
/*  2:   */ 
/*  3:   */ import org.apache.struts.validator.ValidatorForm;
/*  4:   */ 
/*  5:   */ public class LoginForm
/*  6:   */   extends ValidatorForm
/*  7:   */ {
/*  8: 6 */   private String username = "";
/*  9: 7 */   private String password = "";
/* 10: 8 */   private String aplicacion = "";
/* 11: 9 */   private String radio = "pass";
/* 12:10 */   private String servidor = "";
/* 13:11 */   private String username1 = "";
/* 14:12 */   private String password1 = "";
/* 15:13 */   private String servicio = "";
/* 16:   */   
/* 17:   */   public String getPassword()
/* 18:   */   {
/* 19:16 */     return this.password;
/* 20:   */   }
/* 21:   */   
/* 22:   */   public void setPassword(String password)
/* 23:   */   {
/* 24:20 */     this.password = password;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public String getUsername()
/* 28:   */   {
/* 29:24 */     return this.username;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public void setUsername(String username)
/* 33:   */   {
/* 34:28 */     this.username = username;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public String getAplicacion()
/* 38:   */   {
/* 39:32 */     return this.aplicacion;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public void setAplicacion(String aplicacion)
/* 43:   */   {
/* 44:36 */     this.aplicacion = aplicacion;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public String getRadio()
/* 48:   */   {
/* 49:40 */     return this.radio;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public void setRadio(String radio)
/* 53:   */   {
/* 54:44 */     this.radio = radio;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public String getServidor()
/* 58:   */   {
/* 59:48 */     return this.servidor;
/* 60:   */   }
/* 61:   */   
/* 62:   */   public void setServidor(String servidor)
/* 63:   */   {
/* 64:52 */     this.servidor = servidor;
/* 65:   */   }
/* 66:   */   
/* 67:   */   public String getServicio()
/* 68:   */   {
/* 69:56 */     return this.servicio;
/* 70:   */   }
/* 71:   */   
/* 72:   */   public void setServicio(String servicio)
/* 73:   */   {
/* 74:60 */     this.servicio = servicio;
/* 75:   */   }
/* 76:   */   
/* 77:   */   public String getUsername1()
/* 78:   */   {
/* 79:64 */     return this.username1;
/* 80:   */   }
/* 81:   */   
/* 82:   */   public void setUsername1(String username1)
/* 83:   */   {
/* 84:68 */     this.username1 = username1;
/* 85:   */   }
/* 86:   */   
/* 87:   */   public String getPassword1()
/* 88:   */   {
/* 89:72 */     return this.password1;
/* 90:   */   }
/* 91:   */   
/* 92:   */   public void setPassword1(String password1)
/* 93:   */   {
/* 94:76 */     this.password1 = password1;
/* 95:   */   }
/* 96:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.seguridad.controller.LoginForm
 * JD-Core Version:    0.7.0.1
 */