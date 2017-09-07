/*   1:    */ package com.servidoctor.sdfamily.controller;
/*   2:    */ 
/*   3:    */ import org.apache.struts.validator.ValidatorForm;
/*   4:    */ 
/*   5:    */ public class ControlOtroPeriodicoForm
/*   6:    */   extends ValidatorForm
/*   7:    */ {
/*   8:  7 */   private String coot_cod = "0";
/*   9:  8 */   private String coot_usuf_cod = "0";
/*  10:  9 */   private String coot_fecha_ini = "0";
/*  11: 10 */   private String coot_fecha_fin = "0";
/*  12: 11 */   private String coot_hacer_cada = "0";
/*  13: 12 */   private String coot_docnom = "";
/*  14: 13 */   private String coot_entidad = "";
/*  15: 14 */   private String coot_pais_cod = "0";
/*  16: 15 */   private String coot_ciudad_cod = "0";
/*  17: 16 */   private String coot_direccion = "";
/*  18: 17 */   private String coot_indic_pais = "0";
/*  19: 18 */   private String coot_indic_ciudad = "0";
/*  20: 19 */   private String coot_telefo = "";
/*  21: 20 */   private String coot_email = "";
/*  22: 21 */   private String coot_actividad = "";
/*  23: 22 */   private String coot_mails_enviados = "0";
/*  24: 23 */   private String coot_ultimo_mail = "0";
/*  25:    */   
/*  26:    */   public String getCoot_actividad()
/*  27:    */   {
/*  28: 26 */     return this.coot_actividad;
/*  29:    */   }
/*  30:    */   
/*  31:    */   public void setCoot_actividad(String coot_actividad)
/*  32:    */   {
/*  33: 29 */     this.coot_actividad = coot_actividad;
/*  34:    */   }
/*  35:    */   
/*  36:    */   public String getCoot_ciudad_cod()
/*  37:    */   {
/*  38: 32 */     return this.coot_ciudad_cod;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public void setCoot_ciudad_cod(String coot_ciudad_cod)
/*  42:    */   {
/*  43: 35 */     this.coot_ciudad_cod = coot_ciudad_cod;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public String getCoot_cod()
/*  47:    */   {
/*  48: 38 */     return this.coot_cod;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public void setCoot_cod(String coot_cod)
/*  52:    */   {
/*  53: 41 */     this.coot_cod = coot_cod;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public String getCoot_direccion()
/*  57:    */   {
/*  58: 44 */     return this.coot_direccion;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public void setCoot_direccion(String coot_direccion)
/*  62:    */   {
/*  63: 47 */     this.coot_direccion = coot_direccion;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public String getCoot_docnom()
/*  67:    */   {
/*  68: 50 */     return this.coot_docnom;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public void setCoot_docnom(String coot_docnom)
/*  72:    */   {
/*  73: 53 */     this.coot_docnom = coot_docnom;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public String getCoot_email()
/*  77:    */   {
/*  78: 56 */     return this.coot_email;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public void setCoot_email(String coot_email)
/*  82:    */   {
/*  83: 59 */     this.coot_email = coot_email;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public String getCoot_entidad()
/*  87:    */   {
/*  88: 62 */     return this.coot_entidad;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public void setCoot_entidad(String coot_entidad)
/*  92:    */   {
/*  93: 65 */     this.coot_entidad = coot_entidad;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public String getCoot_fecha_fin()
/*  97:    */   {
/*  98: 68 */     return this.coot_fecha_fin;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public void setCoot_fecha_fin(String coot_fecha_fin)
/* 102:    */   {
/* 103: 71 */     this.coot_fecha_fin = coot_fecha_fin;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public String getCoot_fecha_ini()
/* 107:    */   {
/* 108: 74 */     return this.coot_fecha_ini;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public void setCoot_fecha_ini(String coot_fecha_ini)
/* 112:    */   {
/* 113: 77 */     this.coot_fecha_ini = coot_fecha_ini;
/* 114:    */   }
/* 115:    */   
/* 116:    */   public String getCoot_hacer_cada()
/* 117:    */   {
/* 118: 80 */     return this.coot_hacer_cada;
/* 119:    */   }
/* 120:    */   
/* 121:    */   public void setCoot_hacer_cada(String coot_hacer_cada)
/* 122:    */   {
/* 123: 83 */     this.coot_hacer_cada = coot_hacer_cada;
/* 124:    */   }
/* 125:    */   
/* 126:    */   public String getCoot_indic_ciudad()
/* 127:    */   {
/* 128: 86 */     return this.coot_indic_ciudad;
/* 129:    */   }
/* 130:    */   
/* 131:    */   public void setCoot_indic_ciudad(String coot_indic_ciudad)
/* 132:    */   {
/* 133: 89 */     this.coot_indic_ciudad = coot_indic_ciudad;
/* 134:    */   }
/* 135:    */   
/* 136:    */   public String getCoot_indic_pais()
/* 137:    */   {
/* 138: 92 */     return this.coot_indic_pais;
/* 139:    */   }
/* 140:    */   
/* 141:    */   public void setCoot_indic_pais(String coot_indic_pais)
/* 142:    */   {
/* 143: 95 */     this.coot_indic_pais = coot_indic_pais;
/* 144:    */   }
/* 145:    */   
/* 146:    */   public String getCoot_pais_cod()
/* 147:    */   {
/* 148: 98 */     return this.coot_pais_cod;
/* 149:    */   }
/* 150:    */   
/* 151:    */   public void setCoot_pais_cod(String coot_pais_cod)
/* 152:    */   {
/* 153:101 */     this.coot_pais_cod = coot_pais_cod;
/* 154:    */   }
/* 155:    */   
/* 156:    */   public String getCoot_telefo()
/* 157:    */   {
/* 158:104 */     return this.coot_telefo;
/* 159:    */   }
/* 160:    */   
/* 161:    */   public void setCoot_telefo(String coot_telefo)
/* 162:    */   {
/* 163:107 */     this.coot_telefo = coot_telefo;
/* 164:    */   }
/* 165:    */   
/* 166:    */   public String getCoot_usuf_cod()
/* 167:    */   {
/* 168:110 */     return this.coot_usuf_cod;
/* 169:    */   }
/* 170:    */   
/* 171:    */   public void setCoot_usuf_cod(String coot_usu_cod)
/* 172:    */   {
/* 173:113 */     this.coot_usuf_cod = coot_usu_cod;
/* 174:    */   }
/* 175:    */   
/* 176:    */   public String getCoot_mails_enviados()
/* 177:    */   {
/* 178:116 */     return this.coot_mails_enviados;
/* 179:    */   }
/* 180:    */   
/* 181:    */   public void setCoot_mails_enviados(String coot_mails_enviados)
/* 182:    */   {
/* 183:119 */     this.coot_mails_enviados = coot_mails_enviados;
/* 184:    */   }
/* 185:    */   
/* 186:    */   public String getCoot_ultimo_mail()
/* 187:    */   {
/* 188:122 */     return this.coot_ultimo_mail;
/* 189:    */   }
/* 190:    */   
/* 191:    */   public void setCoot_ultimo_mail(String coot_ultimo_mail)
/* 192:    */   {
/* 193:125 */     this.coot_ultimo_mail = coot_ultimo_mail;
/* 194:    */   }
/* 195:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.controller.ControlOtroPeriodicoForm
 * JD-Core Version:    0.7.0.1
 */