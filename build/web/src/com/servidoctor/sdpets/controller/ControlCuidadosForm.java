/*   1:    */ package com.servidoctor.sdpets.controller;
/*   2:    */ 
/*   3:    */ import com.servidoctor.constantes.IConstantes;
/*   4:    */ import org.apache.struts.validator.ValidatorForm;
/*   5:    */ 
/*   6:    */ public class ControlCuidadosForm
/*   7:    */   extends ValidatorForm
/*   8:    */ {
/*   9: 18 */   private String ccui_cod = "0";
/*  10: 19 */   private String ccui_mas_cod = "0";
/*  11: 20 */   private String ccui_descripcion = "";
/*  12: 21 */   private String ccui_fecultapli = "0";
/*  13: 22 */   private String ccui_fecproxapli = "0";
/*  14: 23 */   private String ccui_vetnombre = "";
/*  15: 24 */   private String ccui_pais_cod = "0";
/*  16: 25 */   private String ccui_ciu_cod = "0";
/*  17: 26 */   private String ccui_email = "";
/*  18: 27 */   private String ccui_telefono = "";
/*  19: 28 */   private String ccui_indciudad = "0";
/*  20: 29 */   private String ccui_indpais = "0";
/*  21: 30 */   private String ccui_entidad = "";
/*  22: 31 */   private String ccui_direccion = "";
/*  23: 32 */   private String ccui_raz_tipo = "0";
/*  24: 33 */   private String ccui_cita_prox = IConstantes.CODIGO_SI;
/*  25: 35 */   private String ccui_vetdireccion = "";
/*  26: 36 */   private String ccui_grup_cod = "0";
/*  27: 37 */   private String ccui_mails_enviados = "0";
/*  28: 38 */   private String ccui_ultimo_mail = "0";
/*  29: 39 */   private String ccui_vcui_cod = "0";
/*  30: 40 */   private String ccui_fecenvio2 = "0";
/*  31: 41 */   private String ccui_fecenvion2 = "0";
/*  32: 42 */   private String ccui_fecenvion = "0";
/*  33: 43 */   private String ccui_quince_dias = "0";
/*  34:    */   
/*  35:    */   public String getCcui_ciu_cod()
/*  36:    */   {
/*  37: 47 */     return this.ccui_ciu_cod;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public String getCcui_cod()
/*  41:    */   {
/*  42: 51 */     return this.ccui_cod;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public String getCcui_descripcion()
/*  46:    */   {
/*  47: 55 */     return this.ccui_descripcion;
/*  48:    */   }
/*  49:    */   
/*  50:    */   public String getCcui_direccion()
/*  51:    */   {
/*  52: 59 */     return this.ccui_direccion;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public String getCcui_email()
/*  56:    */   {
/*  57: 63 */     return this.ccui_email;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public String getCcui_entidad()
/*  61:    */   {
/*  62: 67 */     return this.ccui_entidad;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public String getCcui_fecproxapli()
/*  66:    */   {
/*  67: 71 */     return this.ccui_fecproxapli;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public String getCcui_fecultapli()
/*  71:    */   {
/*  72: 75 */     return this.ccui_fecultapli;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public String getCcui_grup_cod()
/*  76:    */   {
/*  77: 79 */     return this.ccui_grup_cod;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public String getCcui_indciudad()
/*  81:    */   {
/*  82: 83 */     return this.ccui_indciudad;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public String getCcui_indpais()
/*  86:    */   {
/*  87: 87 */     return this.ccui_indpais;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public String getCcui_mails_enviados()
/*  91:    */   {
/*  92: 91 */     return this.ccui_mails_enviados;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public String getCcui_mas_cod()
/*  96:    */   {
/*  97: 95 */     return this.ccui_mas_cod;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public String getCcui_pais_cod()
/* 101:    */   {
/* 102: 99 */     return this.ccui_pais_cod;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public String getCcui_raz_tipo()
/* 106:    */   {
/* 107:103 */     return this.ccui_raz_tipo;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public String getCcui_telefono()
/* 111:    */   {
/* 112:107 */     return this.ccui_telefono;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public String getCcui_ultimo_mail()
/* 116:    */   {
/* 117:111 */     return this.ccui_ultimo_mail;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public String getCcui_vcui_cod()
/* 121:    */   {
/* 122:115 */     return this.ccui_vcui_cod;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public String getCcui_vetdireccion()
/* 126:    */   {
/* 127:119 */     return this.ccui_vetdireccion;
/* 128:    */   }
/* 129:    */   
/* 130:    */   public String getCcui_vetnombre()
/* 131:    */   {
/* 132:123 */     return this.ccui_vetnombre;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public void setCcui_ciu_cod(String string)
/* 136:    */   {
/* 137:127 */     this.ccui_ciu_cod = string;
/* 138:    */   }
/* 139:    */   
/* 140:    */   public void setCcui_cod(String string)
/* 141:    */   {
/* 142:131 */     this.ccui_cod = string;
/* 143:    */   }
/* 144:    */   
/* 145:    */   public void setCcui_descripcion(String string)
/* 146:    */   {
/* 147:135 */     this.ccui_descripcion = string;
/* 148:    */   }
/* 149:    */   
/* 150:    */   public void setCcui_direccion(String string)
/* 151:    */   {
/* 152:139 */     this.ccui_direccion = string;
/* 153:    */   }
/* 154:    */   
/* 155:    */   public void setCcui_email(String string)
/* 156:    */   {
/* 157:143 */     this.ccui_email = string;
/* 158:    */   }
/* 159:    */   
/* 160:    */   public void setCcui_entidad(String string)
/* 161:    */   {
/* 162:147 */     this.ccui_entidad = string;
/* 163:    */   }
/* 164:    */   
/* 165:    */   public void setCcui_fecproxapli(String string)
/* 166:    */   {
/* 167:151 */     this.ccui_fecproxapli = string;
/* 168:    */   }
/* 169:    */   
/* 170:    */   public void setCcui_fecultapli(String string)
/* 171:    */   {
/* 172:155 */     this.ccui_fecultapli = string;
/* 173:    */   }
/* 174:    */   
/* 175:    */   public void setCcui_grup_cod(String string)
/* 176:    */   {
/* 177:159 */     this.ccui_grup_cod = string;
/* 178:    */   }
/* 179:    */   
/* 180:    */   public void setCcui_indciudad(String string)
/* 181:    */   {
/* 182:163 */     this.ccui_indciudad = string;
/* 183:    */   }
/* 184:    */   
/* 185:    */   public void setCcui_indpais(String string)
/* 186:    */   {
/* 187:167 */     this.ccui_indpais = string;
/* 188:    */   }
/* 189:    */   
/* 190:    */   public void setCcui_mails_enviados(String string)
/* 191:    */   {
/* 192:171 */     this.ccui_mails_enviados = string;
/* 193:    */   }
/* 194:    */   
/* 195:    */   public void setCcui_mas_cod(String string)
/* 196:    */   {
/* 197:175 */     this.ccui_mas_cod = string;
/* 198:    */   }
/* 199:    */   
/* 200:    */   public void setCcui_pais_cod(String string)
/* 201:    */   {
/* 202:179 */     this.ccui_pais_cod = string;
/* 203:    */   }
/* 204:    */   
/* 205:    */   public void setCcui_raz_tipo(String string)
/* 206:    */   {
/* 207:183 */     this.ccui_raz_tipo = string;
/* 208:    */   }
/* 209:    */   
/* 210:    */   public void setCcui_telefono(String string)
/* 211:    */   {
/* 212:187 */     this.ccui_telefono = string;
/* 213:    */   }
/* 214:    */   
/* 215:    */   public void setCcui_ultimo_mail(String string)
/* 216:    */   {
/* 217:191 */     this.ccui_ultimo_mail = string;
/* 218:    */   }
/* 219:    */   
/* 220:    */   public void setCcui_vcui_cod(String string)
/* 221:    */   {
/* 222:195 */     this.ccui_vcui_cod = string;
/* 223:    */   }
/* 224:    */   
/* 225:    */   public void setCcui_vetdireccion(String string)
/* 226:    */   {
/* 227:199 */     this.ccui_vetdireccion = string;
/* 228:    */   }
/* 229:    */   
/* 230:    */   public void setCcui_vetnombre(String string)
/* 231:    */   {
/* 232:203 */     this.ccui_vetnombre = string;
/* 233:    */   }
/* 234:    */   
/* 235:    */   public String getCcui_cita_prox()
/* 236:    */   {
/* 237:207 */     return this.ccui_cita_prox;
/* 238:    */   }
/* 239:    */   
/* 240:    */   public void setCcui_cita_prox(String string)
/* 241:    */   {
/* 242:211 */     this.ccui_cita_prox = string;
/* 243:    */   }
/* 244:    */   
/* 245:    */   public String getCcui_fecenvio2()
/* 246:    */   {
/* 247:215 */     return this.ccui_fecenvio2;
/* 248:    */   }
/* 249:    */   
/* 250:    */   public void setCcui_fecenvio2(String ccui_fecenvio2)
/* 251:    */   {
/* 252:219 */     this.ccui_fecenvio2 = ccui_fecenvio2;
/* 253:    */   }
/* 254:    */   
/* 255:    */   public String getCcui_fecenvion()
/* 256:    */   {
/* 257:223 */     return this.ccui_fecenvion;
/* 258:    */   }
/* 259:    */   
/* 260:    */   public void setCcui_fecenvion(String ccui_fecenvion)
/* 261:    */   {
/* 262:227 */     this.ccui_fecenvion = ccui_fecenvion;
/* 263:    */   }
/* 264:    */   
/* 265:    */   public String getCcui_fecenvion2()
/* 266:    */   {
/* 267:231 */     return this.ccui_fecenvion2;
/* 268:    */   }
/* 269:    */   
/* 270:    */   public void setCcui_fecenvion2(String ccui_fecenvion2)
/* 271:    */   {
/* 272:235 */     this.ccui_fecenvion2 = ccui_fecenvion2;
/* 273:    */   }
/* 274:    */   
/* 275:    */   public String getCcui_quince_dias()
/* 276:    */   {
/* 277:239 */     return this.ccui_quince_dias;
/* 278:    */   }
/* 279:    */   
/* 280:    */   public void setCcui_quince_dias(String ccui_quince_dias)
/* 281:    */   {
/* 282:243 */     this.ccui_quince_dias = ccui_quince_dias;
/* 283:    */   }
/* 284:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdpets.controller.ControlCuidadosForm
 * JD-Core Version:    0.7.0.1
 */