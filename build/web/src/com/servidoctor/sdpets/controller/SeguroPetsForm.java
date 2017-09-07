/*   1:    */ package com.servidoctor.sdpets.controller;
/*   2:    */ 
/*   3:    */ import org.apache.struts.validator.ValidatorForm;
/*   4:    */ 
/*   5:    */ public class SeguroPetsForm
/*   6:    */   extends ValidatorForm
/*   7:    */ {
/*   8: 14 */   private String segp_cod = "0";
/*   9: 15 */   private String segp_mas_cod = "0";
/*  10: 16 */   private String segp_nomcia = "";
/*  11: 17 */   private String segp_polizaafi = "";
/*  12: 18 */   private String segp_contacto = "";
/*  13: 19 */   private String segp_indpais1 = "0";
/*  14: 20 */   private String segp_indciudad1 = "0";
/*  15: 21 */   private String segp_telefono1 = "";
/*  16: 22 */   private String segp_indpais2 = "0";
/*  17: 23 */   private String segp_telefono2 = "";
/*  18: 24 */   private String segp_indpais3 = "0";
/*  19: 25 */   private String segp_indciudad3 = "0";
/*  20: 26 */   private String segp_telefono3 = "";
/*  21: 27 */   private String segp_vig_desde = "0";
/*  22: 28 */   private String segp_vig_hasta = "0";
/*  23: 29 */   private String segp_email = "";
/*  24: 30 */   private String segp_grup_cod = "0";
/*  25: 31 */   private String segp_mails_enviados = "0";
/*  26: 32 */   private String segp_ultimo_mail = "0";
/*  27: 33 */   private String segp_quince_dias = "0";
/*  28: 34 */   private String segp_fecenvio2 = "0";
/*  29: 35 */   private String segp_fecenvion2 = "0";
/*  30: 36 */   private String segp_fecenvion = "0";
/*  31:    */   
/*  32:    */   public String getSegp_cod()
/*  33:    */   {
/*  34: 40 */     return this.segp_cod;
/*  35:    */   }
/*  36:    */   
/*  37:    */   public String getSegp_contacto()
/*  38:    */   {
/*  39: 43 */     return this.segp_contacto;
/*  40:    */   }
/*  41:    */   
/*  42:    */   public String getSegp_email()
/*  43:    */   {
/*  44: 46 */     return this.segp_email;
/*  45:    */   }
/*  46:    */   
/*  47:    */   public String getSegp_grup_cod()
/*  48:    */   {
/*  49: 49 */     return this.segp_grup_cod;
/*  50:    */   }
/*  51:    */   
/*  52:    */   public String getSegp_indciudad1()
/*  53:    */   {
/*  54: 52 */     return this.segp_indciudad1;
/*  55:    */   }
/*  56:    */   
/*  57:    */   public String getSegp_indciudad3()
/*  58:    */   {
/*  59: 55 */     return this.segp_indciudad3;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public String getSegp_indpais1()
/*  63:    */   {
/*  64: 58 */     return this.segp_indpais1;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public String getSegp_indpais2()
/*  68:    */   {
/*  69: 61 */     return this.segp_indpais2;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public String getSegp_indpais3()
/*  73:    */   {
/*  74: 64 */     return this.segp_indpais3;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public String getSegp_mails_enviados()
/*  78:    */   {
/*  79: 67 */     return this.segp_mails_enviados;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public String getSegp_nomcia()
/*  83:    */   {
/*  84: 70 */     return this.segp_nomcia;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public String getSegp_polizaafi()
/*  88:    */   {
/*  89: 73 */     return this.segp_polizaafi;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public String getSegp_telefono1()
/*  93:    */   {
/*  94: 76 */     return this.segp_telefono1;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public String getSegp_telefono2()
/*  98:    */   {
/*  99: 79 */     return this.segp_telefono2;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public String getSegp_telefono3()
/* 103:    */   {
/* 104: 82 */     return this.segp_telefono3;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public String getSegp_ultimo_mail()
/* 108:    */   {
/* 109: 85 */     return this.segp_ultimo_mail;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public String getSegp_vig_desde()
/* 113:    */   {
/* 114: 89 */     return this.segp_vig_desde;
/* 115:    */   }
/* 116:    */   
/* 117:    */   public String getSegp_vig_hasta()
/* 118:    */   {
/* 119: 92 */     return this.segp_vig_hasta;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public void setSegp_cod(String segp_cod)
/* 123:    */   {
/* 124: 95 */     this.segp_cod = segp_cod;
/* 125:    */   }
/* 126:    */   
/* 127:    */   public void setSegp_contacto(String segp_contacto)
/* 128:    */   {
/* 129: 98 */     this.segp_contacto = segp_contacto;
/* 130:    */   }
/* 131:    */   
/* 132:    */   public void setSegp_email(String segp_email)
/* 133:    */   {
/* 134:101 */     this.segp_email = segp_email;
/* 135:    */   }
/* 136:    */   
/* 137:    */   public void setSegp_grup_cod(String segp_grup_cod)
/* 138:    */   {
/* 139:104 */     this.segp_grup_cod = segp_grup_cod;
/* 140:    */   }
/* 141:    */   
/* 142:    */   public void setSegp_indciudad1(String segp_indciudad1)
/* 143:    */   {
/* 144:107 */     this.segp_indciudad1 = segp_indciudad1;
/* 145:    */   }
/* 146:    */   
/* 147:    */   public void setSegp_indciudad3(String segp_indciudad3)
/* 148:    */   {
/* 149:110 */     this.segp_indciudad3 = segp_indciudad3;
/* 150:    */   }
/* 151:    */   
/* 152:    */   public void setSegp_indpais1(String segp_indpais1)
/* 153:    */   {
/* 154:113 */     this.segp_indpais1 = segp_indpais1;
/* 155:    */   }
/* 156:    */   
/* 157:    */   public void setSegp_indpais2(String segp_indpais2)
/* 158:    */   {
/* 159:116 */     this.segp_indpais2 = segp_indpais2;
/* 160:    */   }
/* 161:    */   
/* 162:    */   public void setSegp_indpais3(String segp_indpais3)
/* 163:    */   {
/* 164:119 */     this.segp_indpais3 = segp_indpais3;
/* 165:    */   }
/* 166:    */   
/* 167:    */   public void setSegp_mails_enviados(String segp_mails_enviados)
/* 168:    */   {
/* 169:122 */     this.segp_mails_enviados = segp_mails_enviados;
/* 170:    */   }
/* 171:    */   
/* 172:    */   public void setSegp_nomcia(String segp_nomcia)
/* 173:    */   {
/* 174:125 */     this.segp_nomcia = segp_nomcia;
/* 175:    */   }
/* 176:    */   
/* 177:    */   public void setSegp_polizaafi(String segp_polizaafi)
/* 178:    */   {
/* 179:128 */     this.segp_polizaafi = segp_polizaafi;
/* 180:    */   }
/* 181:    */   
/* 182:    */   public void setSegp_telefono1(String segp_telefono1)
/* 183:    */   {
/* 184:131 */     this.segp_telefono1 = segp_telefono1;
/* 185:    */   }
/* 186:    */   
/* 187:    */   public void setSegp_telefono2(String segp_telefono2)
/* 188:    */   {
/* 189:134 */     this.segp_telefono2 = segp_telefono2;
/* 190:    */   }
/* 191:    */   
/* 192:    */   public void setSegp_telefono3(String segp_telefono3)
/* 193:    */   {
/* 194:137 */     this.segp_telefono3 = segp_telefono3;
/* 195:    */   }
/* 196:    */   
/* 197:    */   public void setSegp_ultimo_mail(String segp_ultimo_mail)
/* 198:    */   {
/* 199:140 */     this.segp_ultimo_mail = segp_ultimo_mail;
/* 200:    */   }
/* 201:    */   
/* 202:    */   public void setSegp_vig_desde(String segp_vig_desde)
/* 203:    */   {
/* 204:143 */     this.segp_vig_desde = segp_vig_desde;
/* 205:    */   }
/* 206:    */   
/* 207:    */   public void setSegp_vig_hasta(String segp_vig_hasta)
/* 208:    */   {
/* 209:146 */     this.segp_vig_hasta = segp_vig_hasta;
/* 210:    */   }
/* 211:    */   
/* 212:    */   public String getSegp_mas_cod()
/* 213:    */   {
/* 214:149 */     return this.segp_mas_cod;
/* 215:    */   }
/* 216:    */   
/* 217:    */   public void setSegp_mas_cod(String segpMasCod)
/* 218:    */   {
/* 219:152 */     this.segp_mas_cod = segpMasCod;
/* 220:    */   }
/* 221:    */   
/* 222:    */   public String getSegp_fecenvio2()
/* 223:    */   {
/* 224:155 */     return this.segp_fecenvio2;
/* 225:    */   }
/* 226:    */   
/* 227:    */   public void setSegp_fecenvio2(String segp_fecenvio2)
/* 228:    */   {
/* 229:158 */     this.segp_fecenvio2 = segp_fecenvio2;
/* 230:    */   }
/* 231:    */   
/* 232:    */   public String getSegp_fecenvion()
/* 233:    */   {
/* 234:161 */     return this.segp_fecenvion;
/* 235:    */   }
/* 236:    */   
/* 237:    */   public void setSegp_fecenvion(String segp_fecenvion)
/* 238:    */   {
/* 239:164 */     this.segp_fecenvion = segp_fecenvion;
/* 240:    */   }
/* 241:    */   
/* 242:    */   public String getSegp_fecenvion2()
/* 243:    */   {
/* 244:167 */     return this.segp_fecenvion2;
/* 245:    */   }
/* 246:    */   
/* 247:    */   public void setSegp_fecenvion2(String segp_fecenvion2)
/* 248:    */   {
/* 249:170 */     this.segp_fecenvion2 = segp_fecenvion2;
/* 250:    */   }
/* 251:    */   
/* 252:    */   public String getSegp_quince_dias()
/* 253:    */   {
/* 254:173 */     return this.segp_quince_dias;
/* 255:    */   }
/* 256:    */   
/* 257:    */   public void setSegp_quince_dias(String segp_quince_dias)
/* 258:    */   {
/* 259:176 */     this.segp_quince_dias = segp_quince_dias;
/* 260:    */   }
/* 261:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdpets.controller.SeguroPetsForm
 * JD-Core Version:    0.7.0.1
 */