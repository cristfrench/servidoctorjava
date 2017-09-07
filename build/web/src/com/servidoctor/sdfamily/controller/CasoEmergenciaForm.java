/*   1:    */ package com.servidoctor.sdfamily.controller;
/*   2:    */ 
/*   3:    */ import org.apache.struts.validator.ValidatorForm;
/*   4:    */ 
/*   5:    */ public class CasoEmergenciaForm
/*   6:    */   extends ValidatorForm
/*   7:    */ {
/*   8: 15 */   private String case_cod = "0";
/*   9: 16 */   private String case_usuf_cod = "0";
/*  10: 17 */   private String case_nombre = "";
/*  11: 18 */   private String case_apellido = "";
/*  12: 19 */   private String case_pais_cod = "0";
/*  13: 20 */   private String case_ciu_cod = "0";
/*  14: 21 */   private String case_rfam_cod = "0";
/*  15: 22 */   private String case_indpais1 = "0";
/*  16: 23 */   private String case_indciudad1 = "0";
/*  17: 24 */   private String case_telefono1 = "";
/*  18: 25 */   private String case_indpais2 = "0";
/*  19: 26 */   private String case_telefono2 = "";
/*  20: 27 */   private String case_mail = "";
/*  21: 28 */   private String case_orden = "";
/*  22:    */   
/*  23:    */   public String getCase_apellido()
/*  24:    */   {
/*  25: 31 */     return this.case_apellido;
/*  26:    */   }
/*  27:    */   
/*  28:    */   public String getCase_ciu_cod()
/*  29:    */   {
/*  30: 34 */     return this.case_ciu_cod;
/*  31:    */   }
/*  32:    */   
/*  33:    */   public String getCase_cod()
/*  34:    */   {
/*  35: 37 */     return this.case_cod;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public String getCase_indciudad1()
/*  39:    */   {
/*  40: 40 */     return this.case_indciudad1;
/*  41:    */   }
/*  42:    */   
/*  43:    */   public String getCase_indpais1()
/*  44:    */   {
/*  45: 43 */     return this.case_indpais1;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public String getCase_indpais2()
/*  49:    */   {
/*  50: 46 */     return this.case_indpais2;
/*  51:    */   }
/*  52:    */   
/*  53:    */   public String getCase_mail()
/*  54:    */   {
/*  55: 49 */     return this.case_mail;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public String getCase_nombre()
/*  59:    */   {
/*  60: 52 */     return this.case_nombre;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public String getCase_orden()
/*  64:    */   {
/*  65: 55 */     return this.case_orden;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public String getCase_pais_cod()
/*  69:    */   {
/*  70: 58 */     return this.case_pais_cod;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public String getCase_rfam_cod()
/*  74:    */   {
/*  75: 61 */     return this.case_rfam_cod;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public String getCase_telefono1()
/*  79:    */   {
/*  80: 64 */     return this.case_telefono1;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public String getCase_telefono2()
/*  84:    */   {
/*  85: 67 */     return this.case_telefono2;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public String getCase_usuf_cod()
/*  89:    */   {
/*  90: 70 */     return this.case_usuf_cod;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public void setCase_apellido(String case_apellido)
/*  94:    */   {
/*  95: 73 */     this.case_apellido = case_apellido;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public void setCase_ciu_cod(String case_ciu_cod)
/*  99:    */   {
/* 100: 76 */     this.case_ciu_cod = case_ciu_cod;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public void setCase_cod(String case_cod)
/* 104:    */   {
/* 105: 79 */     this.case_cod = case_cod;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public void setCase_indciudad1(String case_indciudad1)
/* 109:    */   {
/* 110: 82 */     this.case_indciudad1 = case_indciudad1;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public void setCase_indpais1(String case_indpais1)
/* 114:    */   {
/* 115: 85 */     this.case_indpais1 = case_indpais1;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public void setCase_indpais2(String case_indpais2)
/* 119:    */   {
/* 120: 88 */     this.case_indpais2 = case_indpais2;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public void setCase_mail(String case_mail)
/* 124:    */   {
/* 125: 91 */     this.case_mail = case_mail;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public void setCase_nombre(String case_nombre)
/* 129:    */   {
/* 130: 94 */     this.case_nombre = case_nombre;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public void setCase_orden(String case_orden)
/* 134:    */   {
/* 135: 97 */     this.case_orden = case_orden;
/* 136:    */   }
/* 137:    */   
/* 138:    */   public void setCase_pais_cod(String case_pais_cod)
/* 139:    */   {
/* 140:100 */     this.case_pais_cod = case_pais_cod;
/* 141:    */   }
/* 142:    */   
/* 143:    */   public void setCase_rfam_cod(String case_rfam_cod)
/* 144:    */   {
/* 145:103 */     this.case_rfam_cod = case_rfam_cod;
/* 146:    */   }
/* 147:    */   
/* 148:    */   public void setCase_telefono1(String case_telefono1)
/* 149:    */   {
/* 150:106 */     this.case_telefono1 = case_telefono1;
/* 151:    */   }
/* 152:    */   
/* 153:    */   public void setCase_telefono2(String case_telefono2)
/* 154:    */   {
/* 155:109 */     this.case_telefono2 = case_telefono2;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public void setCase_usuf_cod(String case_usuf_cod)
/* 159:    */   {
/* 160:112 */     this.case_usuf_cod = case_usuf_cod;
/* 161:    */   }
/* 162:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.controller.CasoEmergenciaForm
 * JD-Core Version:    0.7.0.1
 */