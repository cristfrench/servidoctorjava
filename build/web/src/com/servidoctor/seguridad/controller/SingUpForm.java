/*   1:    */ package com.servidoctor.seguridad.controller;
/*   2:    */ 
/*   3:    */ import java.util.regex.Matcher;
/*   4:    */ import java.util.regex.Pattern;
/*   5:    */ import javax.servlet.http.HttpServletRequest;
/*   6:    */ import org.apache.struts.action.ActionError;
/*   7:    */ import org.apache.struts.action.ActionErrors;
/*   8:    */ import org.apache.struts.action.ActionMapping;
/*   9:    */ import org.apache.struts.validator.ValidatorForm;
/*  10:    */ 
/*  11:    */ public class SingUpForm
/*  12:    */   extends ValidatorForm
/*  13:    */ {
/*  14:    */   private String compras_licencias_codact;
/*  15:    */   private String login;
/*  16:    */   private String reLogin;
/*  17:    */   private String password;
/*  18:    */   private String rePassword;
/*  19: 27 */   private String aplicacion = "";
/*  20:    */   
/*  21:    */   public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
/*  22:    */   {
/*  23: 30 */     ActionErrors errors = new ActionErrors();
/*  24: 31 */     if ((!this.login.contains("@")) || (!this.login.contains(".")) || (this.login.length() < 6) || (!isMail(this.login))) {
/*  25: 32 */       errors.add("org.apache.struts.action.GLOBAL_ERROR", new ActionError("errors.login.mail"));
/*  26:    */     }
/*  27: 34 */     if (!this.login.equals(this.reLogin)) {
/*  28: 35 */       errors.add("org.apache.struts.action.GLOBAL_ERROR", new ActionError("errors.login"));
/*  29:    */     }
/*  30: 37 */     if (this.password.length() < 5) {
/*  31: 38 */       errors.add("org.apache.struts.action.GLOBAL_ERROR", new ActionError("errors.password.length"));
/*  32:    */     }
/*  33: 40 */     if (!this.password.equals(this.rePassword)) {
/*  34: 41 */       errors.add("org.apache.struts.action.GLOBAL_ERROR", new ActionError("errors.password"));
/*  35:    */     }
/*  36: 43 */     return errors;
/*  37:    */   }
/*  38:    */   
/*  39:    */   public static boolean isMail(String aEmailAddress)
/*  40:    */   {
/*  41: 47 */     String email = aEmailAddress;
/*  42:    */     
/*  43:    */ 
/*  44: 50 */     Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
/*  45:    */     
/*  46:    */ 
/*  47: 53 */     Matcher m = p.matcher(email);
/*  48:    */     
/*  49:    */ 
/*  50: 56 */     boolean matchFound = m.matches();
/*  51:    */     
/*  52: 58 */     return matchFound;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public String getCompras_licencias_codact()
/*  56:    */   {
/*  57: 62 */     return this.compras_licencias_codact;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public String getLogin()
/*  61:    */   {
/*  62: 66 */     return this.login;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public String getPassword()
/*  66:    */   {
/*  67: 70 */     return this.password;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public String getReLogin()
/*  71:    */   {
/*  72: 74 */     return this.reLogin;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public String getRePassword()
/*  76:    */   {
/*  77: 78 */     return this.rePassword;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public void setCompras_licencias_codact(String string)
/*  81:    */   {
/*  82: 82 */     this.compras_licencias_codact = string;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public void setLogin(String string)
/*  86:    */   {
/*  87: 86 */     this.login = string;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public void setPassword(String string)
/*  91:    */   {
/*  92: 90 */     this.password = string;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public void setReLogin(String string)
/*  96:    */   {
/*  97: 94 */     this.reLogin = string;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public void setRePassword(String string)
/* 101:    */   {
/* 102: 98 */     this.rePassword = string;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public String getAplicacion()
/* 106:    */   {
/* 107:102 */     return this.aplicacion;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public void setAplicacion(String aplicacion)
/* 111:    */   {
/* 112:106 */     this.aplicacion = aplicacion;
/* 113:    */   }
/* 114:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.seguridad.controller.SingUpForm
 * JD-Core Version:    0.7.0.1
 */