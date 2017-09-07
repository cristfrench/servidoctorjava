/*  1:   */ package com.servidoctor.sdfamily.controller;
/*  2:   */ 
/*  3:   */ import org.apache.struts.validator.ValidatorForm;
/*  4:   */ 
/*  5:   */ public class AntecedentesUsuarioForm
/*  6:   */   extends ValidatorForm
/*  7:   */ {
/*  8:13 */   private String anteu_cod = "0";
/*  9:14 */   private String anteu_usuf_cod = "0";
/* 10:15 */   private String anteu_ante_cod = "0";
/* 11:16 */   private String anteu_abuelos = "0";
/* 12:17 */   private String anteu_padre = "0";
/* 13:18 */   private String anteu_madre = "0";
/* 14:19 */   private String anteu_hermanos = "0";
/* 15:20 */   private String anteu_des = "";
/* 16:   */   
/* 17:   */   public String getAnteu_abuelos()
/* 18:   */   {
/* 19:23 */     return this.anteu_abuelos;
/* 20:   */   }
/* 21:   */   
/* 22:   */   public String getAnteu_ante_cod()
/* 23:   */   {
/* 24:26 */     return this.anteu_ante_cod;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public String getAnteu_cod()
/* 28:   */   {
/* 29:29 */     return this.anteu_cod;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public String getAnteu_des()
/* 33:   */   {
/* 34:32 */     return this.anteu_des;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public String getAnteu_hermanos()
/* 38:   */   {
/* 39:35 */     return this.anteu_hermanos;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public String getAnteu_madre()
/* 43:   */   {
/* 44:38 */     return this.anteu_madre;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public String getAnteu_padre()
/* 48:   */   {
/* 49:41 */     return this.anteu_padre;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public String getAnteu_usuf_cod()
/* 53:   */   {
/* 54:44 */     return this.anteu_usuf_cod;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public void setAnteu_abuelos(String anteu_abuelos)
/* 58:   */   {
/* 59:47 */     this.anteu_abuelos = anteu_abuelos;
/* 60:   */   }
/* 61:   */   
/* 62:   */   public void setAnteu_ante_cod(String anteu_ante_cod)
/* 63:   */   {
/* 64:50 */     this.anteu_ante_cod = anteu_ante_cod;
/* 65:   */   }
/* 66:   */   
/* 67:   */   public void setAnteu_cod(String anteu_cod)
/* 68:   */   {
/* 69:53 */     this.anteu_cod = anteu_cod;
/* 70:   */   }
/* 71:   */   
/* 72:   */   public void setAnteu_des(String anteu_des)
/* 73:   */   {
/* 74:56 */     this.anteu_des = anteu_des;
/* 75:   */   }
/* 76:   */   
/* 77:   */   public void setAnteu_hermanos(String anteu_hermanos)
/* 78:   */   {
/* 79:59 */     this.anteu_hermanos = anteu_hermanos;
/* 80:   */   }
/* 81:   */   
/* 82:   */   public void setAnteu_madre(String anteu_madre)
/* 83:   */   {
/* 84:62 */     this.anteu_madre = anteu_madre;
/* 85:   */   }
/* 86:   */   
/* 87:   */   public void setAnteu_padre(String anteu_padre)
/* 88:   */   {
/* 89:65 */     this.anteu_padre = anteu_padre;
/* 90:   */   }
/* 91:   */   
/* 92:   */   public void setAnteu_usuf_cod(String anteu_usuf_cod)
/* 93:   */   {
/* 94:68 */     this.anteu_usuf_cod = anteu_usuf_cod;
/* 95:   */   }
/* 96:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.controller.AntecedentesUsuarioForm
 * JD-Core Version:    0.7.0.1
 */