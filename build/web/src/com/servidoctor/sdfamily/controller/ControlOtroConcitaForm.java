/*   1:    */ package com.servidoctor.sdfamily.controller;
/*   2:    */ 
/*   3:    */ import org.apache.struts.validator.ValidatorForm;
/*   4:    */ 
/*   5:    */ public class ControlOtroConcitaForm
/*   6:    */   extends ValidatorForm
/*   7:    */ {
/*   8:  6 */   private String cootc_cod = "0";
/*   9:  7 */   private String cootc_usuf_cod = "0";
/*  10:  8 */   private String cootc_fecha = "0";
/*  11:  9 */   private String cootc_docnom = "";
/*  12: 10 */   private String cootc_entidad = "";
/*  13: 11 */   private String cootc_pais_cod = "0";
/*  14: 12 */   private String cootc_ciudad_cod = "0";
/*  15: 13 */   private String cootc_direccion = "";
/*  16: 14 */   private String cootc_indic_pais = "0";
/*  17: 15 */   private String cootc_indic_ciudad = "0";
/*  18: 16 */   private String cootc_telefo = "";
/*  19: 17 */   private String cootc_email = "";
/*  20: 18 */   private String cootc_actividad = "";
/*  21: 19 */   private String cootc_hora = "0";
/*  22: 20 */   private String cootc_mails_enviados = "0";
/*  23: 21 */   private String cootc_ultimo_mail = "0";
/*  24: 22 */   private String cootc_fecenvio2 = "0";
/*  25: 23 */   private String cootc_fecenvion2 = "0";
/*  26: 24 */   private String cootc_fecenvion = "0";
/*  27: 25 */   private String cootc_quince_dias = "0";
/*  28:    */   
/*  29:    */   public String getCootc_mails_enviados()
/*  30:    */   {
/*  31: 30 */     return this.cootc_mails_enviados;
/*  32:    */   }
/*  33:    */   
/*  34:    */   public void setCootc_mails_enviados(String cootc_mails_enviados)
/*  35:    */   {
/*  36: 33 */     this.cootc_mails_enviados = cootc_mails_enviados;
/*  37:    */   }
/*  38:    */   
/*  39:    */   public String getCootc_ultimo_mail()
/*  40:    */   {
/*  41: 36 */     return this.cootc_ultimo_mail;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public void setCootc_ultimo_mail(String cootc_ultimo_mail)
/*  45:    */   {
/*  46: 39 */     this.cootc_ultimo_mail = cootc_ultimo_mail;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public String getCootc_actividad()
/*  50:    */   {
/*  51: 42 */     return this.cootc_actividad;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public void setCootc_actividad(String cootc_actividad)
/*  55:    */   {
/*  56: 45 */     this.cootc_actividad = cootc_actividad;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public String getCootc_ciudad_cod()
/*  60:    */   {
/*  61: 48 */     return this.cootc_ciudad_cod;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public void setCootc_ciudad_cod(String cootc_ciudad_cod)
/*  65:    */   {
/*  66: 51 */     this.cootc_ciudad_cod = cootc_ciudad_cod;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public String getCootc_cod()
/*  70:    */   {
/*  71: 54 */     return this.cootc_cod;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public void setCootc_cod(String cootc_cod)
/*  75:    */   {
/*  76: 57 */     this.cootc_cod = cootc_cod;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public String getCootc_direccion()
/*  80:    */   {
/*  81: 60 */     return this.cootc_direccion;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public void setCootc_direccion(String cootc_direccion)
/*  85:    */   {
/*  86: 63 */     this.cootc_direccion = cootc_direccion;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public String getCootc_docnom()
/*  90:    */   {
/*  91: 66 */     return this.cootc_docnom;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public void setCootc_docnom(String cootc_docnom)
/*  95:    */   {
/*  96: 69 */     this.cootc_docnom = cootc_docnom;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public String getCootc_email()
/* 100:    */   {
/* 101: 72 */     return this.cootc_email;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public void setCootc_email(String cootc_email)
/* 105:    */   {
/* 106: 75 */     this.cootc_email = cootc_email;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public String getCootc_entidad()
/* 110:    */   {
/* 111: 78 */     return this.cootc_entidad;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public void setCootc_entidad(String cootc_entidad)
/* 115:    */   {
/* 116: 81 */     this.cootc_entidad = cootc_entidad;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public String getCootc_fecha()
/* 120:    */   {
/* 121: 84 */     return this.cootc_fecha;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public void setCootc_fecha(String cootc_fecha)
/* 125:    */   {
/* 126: 87 */     this.cootc_fecha = cootc_fecha;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public String getCootc_hora()
/* 130:    */   {
/* 131: 90 */     return this.cootc_hora;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public void setCootc_hora(String cootc_hora)
/* 135:    */   {
/* 136: 93 */     this.cootc_hora = cootc_hora;
/* 137:    */   }
/* 138:    */   
/* 139:    */   public String getCootc_indic_ciudad()
/* 140:    */   {
/* 141: 96 */     return this.cootc_indic_ciudad;
/* 142:    */   }
/* 143:    */   
/* 144:    */   public void setCootc_indic_ciudad(String cootc_indic_ciudad)
/* 145:    */   {
/* 146: 99 */     this.cootc_indic_ciudad = cootc_indic_ciudad;
/* 147:    */   }
/* 148:    */   
/* 149:    */   public String getCootc_indic_pais()
/* 150:    */   {
/* 151:102 */     return this.cootc_indic_pais;
/* 152:    */   }
/* 153:    */   
/* 154:    */   public void setCootc_indic_pais(String cootc_indic_pais)
/* 155:    */   {
/* 156:105 */     this.cootc_indic_pais = cootc_indic_pais;
/* 157:    */   }
/* 158:    */   
/* 159:    */   public String getCootc_pais_cod()
/* 160:    */   {
/* 161:108 */     return this.cootc_pais_cod;
/* 162:    */   }
/* 163:    */   
/* 164:    */   public void setCootc_pais_cod(String cootc_pais_cod)
/* 165:    */   {
/* 166:111 */     this.cootc_pais_cod = cootc_pais_cod;
/* 167:    */   }
/* 168:    */   
/* 169:    */   public String getCootc_telefo()
/* 170:    */   {
/* 171:114 */     return this.cootc_telefo;
/* 172:    */   }
/* 173:    */   
/* 174:    */   public void setCootc_telefo(String cootc_telefo)
/* 175:    */   {
/* 176:117 */     this.cootc_telefo = cootc_telefo;
/* 177:    */   }
/* 178:    */   
/* 179:    */   public String getCootc_usuf_cod()
/* 180:    */   {
/* 181:120 */     return this.cootc_usuf_cod;
/* 182:    */   }
/* 183:    */   
/* 184:    */   public void setCootc_usuf_cod(String cootc_usu_cod)
/* 185:    */   {
/* 186:123 */     this.cootc_usuf_cod = cootc_usu_cod;
/* 187:    */   }
/* 188:    */   
/* 189:    */   public String getCootc_fecenvio2()
/* 190:    */   {
/* 191:126 */     return this.cootc_fecenvio2;
/* 192:    */   }
/* 193:    */   
/* 194:    */   public void setCootc_fecenvio2(String cootc_fecenvio2)
/* 195:    */   {
/* 196:129 */     this.cootc_fecenvio2 = cootc_fecenvio2;
/* 197:    */   }
/* 198:    */   
/* 199:    */   public String getCootc_fecenvion()
/* 200:    */   {
/* 201:132 */     return this.cootc_fecenvion;
/* 202:    */   }
/* 203:    */   
/* 204:    */   public void setCootc_fecenvion(String cootc_fecenvion)
/* 205:    */   {
/* 206:135 */     this.cootc_fecenvion = cootc_fecenvion;
/* 207:    */   }
/* 208:    */   
/* 209:    */   public String getCootc_fecenvion2()
/* 210:    */   {
/* 211:138 */     return this.cootc_fecenvion2;
/* 212:    */   }
/* 213:    */   
/* 214:    */   public void setCootc_fecenvion2(String cootc_fecenvion2)
/* 215:    */   {
/* 216:141 */     this.cootc_fecenvion2 = cootc_fecenvion2;
/* 217:    */   }
/* 218:    */   
/* 219:    */   public String getCootc_quince_dias()
/* 220:    */   {
/* 221:144 */     return this.cootc_quince_dias;
/* 222:    */   }
/* 223:    */   
/* 224:    */   public void setCootc_quince_dias(String cootc_quince_dias)
/* 225:    */   {
/* 226:147 */     this.cootc_quince_dias = cootc_quince_dias;
/* 227:    */   }
/* 228:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.controller.ControlOtroConcitaForm
 * JD-Core Version:    0.7.0.1
 */