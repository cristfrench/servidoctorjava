/*   1:    */ package com.servidoctor.sdcars.controller;
/*   2:    */ 
/*   3:    */ import org.apache.struts.validator.ValidatorForm;
/*   4:    */ 
/*   5:    */ public class SegurosVehiculosForm
/*   6:    */   extends ValidatorForm
/*   7:    */ {
/*   8: 13 */   String sveh_cod = "0";
/*   9: 14 */   String sveh_veh_cod = "0";
/*  10: 15 */   String sveh_tipo = "";
/*  11: 16 */   String sveh_ciaaseg = "";
/*  12: 17 */   String sveh_ageemisor = "";
/*  13: 18 */   String sveh_indpais1 = "0";
/*  14: 19 */   String sveh_indciudad1 = "0";
/*  15: 20 */   String sveh_telefono1 = "";
/*  16: 21 */   String sveh_nomcont = "";
/*  17: 22 */   String sveh_ciu_cod = "0";
/*  18: 23 */   String sveh_pais_cod = "0";
/*  19: 24 */   String sveh_mail = "";
/*  20: 26 */   String sveh_responsabilidad = "";
/*  21: 27 */   String sveh_juridica = "";
/*  22: 28 */   String sveh_perdidaparcialdanos = "";
/*  23: 29 */   String sveh_perdidatotaldanos = "";
/*  24: 30 */   String sveh_perdidahurto = "";
/*  25: 31 */   String sveh_amparodanos = "";
/*  26: 32 */   String sveh_amparocivil = "";
/*  27: 33 */   String sveh_transpordedanos = "";
/*  28: 34 */   String sveh_transportehurto = "";
/*  29: 35 */   String sveh_asistenciaviaje = "";
/*  30: 36 */   String sveh_terremoto = "";
/*  31: 37 */   String sveh_numpoliza = "0";
/*  32: 38 */   String sveh_fecvigenchasta = "0";
/*  33: 39 */   String sveh_movilindicativopais = "0";
/*  34: 40 */   String sveh_movilnumero = "";
/*  35: 41 */   String sveh_fijoindicativopais = "0";
/*  36: 42 */   String sveh_fijoindicativociudad = "0";
/*  37: 43 */   String sveh_fijonumero = "";
/*  38: 44 */   String sveh_deducible = "";
/*  39: 46 */   String sveh_grup_cod = "0";
/*  40: 47 */   String sveh_mails_enviados = "0";
/*  41: 48 */   String sveh_ultimo_mail = "0";
/*  42:    */   
/*  43:    */   public String getSveh_ageemisor()
/*  44:    */   {
/*  45: 51 */     return this.sveh_ageemisor;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public String getSveh_amparocivil()
/*  49:    */   {
/*  50: 55 */     return this.sveh_amparocivil;
/*  51:    */   }
/*  52:    */   
/*  53:    */   public String getSveh_amparodanos()
/*  54:    */   {
/*  55: 59 */     return this.sveh_amparodanos;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public String getSveh_asistenciaviaje()
/*  59:    */   {
/*  60: 63 */     return this.sveh_asistenciaviaje;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public String getSveh_ciaaseg()
/*  64:    */   {
/*  65: 67 */     return this.sveh_ciaaseg;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public String getSveh_ciu_cod()
/*  69:    */   {
/*  70: 71 */     return this.sveh_ciu_cod;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public String getSveh_cod()
/*  74:    */   {
/*  75: 75 */     return this.sveh_cod;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public String getSveh_deducible()
/*  79:    */   {
/*  80: 79 */     return this.sveh_deducible;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public String getSveh_fecvigenchasta()
/*  84:    */   {
/*  85: 83 */     return this.sveh_fecvigenchasta;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public String getSveh_fijoindicativociudad()
/*  89:    */   {
/*  90: 87 */     return this.sveh_fijoindicativociudad;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public String getSveh_fijoindicativopais()
/*  94:    */   {
/*  95: 91 */     return this.sveh_fijoindicativopais;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public String getSveh_fijonumero()
/*  99:    */   {
/* 100: 95 */     return this.sveh_fijonumero;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public String getSveh_indciudad1()
/* 104:    */   {
/* 105: 99 */     return this.sveh_indciudad1;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public String getSveh_indpais1()
/* 109:    */   {
/* 110:103 */     return this.sveh_indpais1;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public String getSveh_juridica()
/* 114:    */   {
/* 115:107 */     return this.sveh_juridica;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public String getSveh_mail()
/* 119:    */   {
/* 120:111 */     return this.sveh_mail;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public String getSveh_movilindicativopais()
/* 124:    */   {
/* 125:115 */     return this.sveh_movilindicativopais;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public String getSveh_movilnumero()
/* 129:    */   {
/* 130:119 */     return this.sveh_movilnumero;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public String getSveh_nomcont()
/* 134:    */   {
/* 135:123 */     return this.sveh_nomcont;
/* 136:    */   }
/* 137:    */   
/* 138:    */   public String getSveh_numpoliza()
/* 139:    */   {
/* 140:127 */     return this.sveh_numpoliza;
/* 141:    */   }
/* 142:    */   
/* 143:    */   public String getSveh_pais_cod()
/* 144:    */   {
/* 145:131 */     return this.sveh_pais_cod;
/* 146:    */   }
/* 147:    */   
/* 148:    */   public String getSveh_perdidahurto()
/* 149:    */   {
/* 150:135 */     return this.sveh_perdidahurto;
/* 151:    */   }
/* 152:    */   
/* 153:    */   public String getSveh_perdidaparcialdanos()
/* 154:    */   {
/* 155:139 */     return this.sveh_perdidaparcialdanos;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public String getSveh_perdidatotaldanos()
/* 159:    */   {
/* 160:143 */     return this.sveh_perdidatotaldanos;
/* 161:    */   }
/* 162:    */   
/* 163:    */   public String getSveh_responsabilidad()
/* 164:    */   {
/* 165:147 */     return this.sveh_responsabilidad;
/* 166:    */   }
/* 167:    */   
/* 168:    */   public String getSveh_telefono1()
/* 169:    */   {
/* 170:151 */     return this.sveh_telefono1;
/* 171:    */   }
/* 172:    */   
/* 173:    */   public String getSveh_terremoto()
/* 174:    */   {
/* 175:155 */     return this.sveh_terremoto;
/* 176:    */   }
/* 177:    */   
/* 178:    */   public String getSveh_tipo()
/* 179:    */   {
/* 180:159 */     return this.sveh_tipo;
/* 181:    */   }
/* 182:    */   
/* 183:    */   public String getSveh_transpordedanos()
/* 184:    */   {
/* 185:163 */     return this.sveh_transpordedanos;
/* 186:    */   }
/* 187:    */   
/* 188:    */   public String getSveh_transportehurto()
/* 189:    */   {
/* 190:167 */     return this.sveh_transportehurto;
/* 191:    */   }
/* 192:    */   
/* 193:    */   public String getSveh_veh_cod()
/* 194:    */   {
/* 195:171 */     return this.sveh_veh_cod;
/* 196:    */   }
/* 197:    */   
/* 198:    */   public void setSveh_ageemisor(String string)
/* 199:    */   {
/* 200:175 */     this.sveh_ageemisor = string;
/* 201:    */   }
/* 202:    */   
/* 203:    */   public void setSveh_amparocivil(String string)
/* 204:    */   {
/* 205:179 */     this.sveh_amparocivil = string;
/* 206:    */   }
/* 207:    */   
/* 208:    */   public void setSveh_amparodanos(String string)
/* 209:    */   {
/* 210:183 */     this.sveh_amparodanos = string;
/* 211:    */   }
/* 212:    */   
/* 213:    */   public void setSveh_asistenciaviaje(String string)
/* 214:    */   {
/* 215:187 */     this.sveh_asistenciaviaje = string;
/* 216:    */   }
/* 217:    */   
/* 218:    */   public void setSveh_ciaaseg(String string)
/* 219:    */   {
/* 220:191 */     this.sveh_ciaaseg = string;
/* 221:    */   }
/* 222:    */   
/* 223:    */   public void setSveh_ciu_cod(String string)
/* 224:    */   {
/* 225:195 */     this.sveh_ciu_cod = string;
/* 226:    */   }
/* 227:    */   
/* 228:    */   public void setSveh_cod(String string)
/* 229:    */   {
/* 230:199 */     this.sveh_cod = string;
/* 231:    */   }
/* 232:    */   
/* 233:    */   public void setSveh_deducible(String string)
/* 234:    */   {
/* 235:203 */     this.sveh_deducible = string;
/* 236:    */   }
/* 237:    */   
/* 238:    */   public void setSveh_fecvigenchasta(String string)
/* 239:    */   {
/* 240:207 */     this.sveh_fecvigenchasta = string;
/* 241:    */   }
/* 242:    */   
/* 243:    */   public void setSveh_fijoindicativociudad(String string)
/* 244:    */   {
/* 245:211 */     this.sveh_fijoindicativociudad = string;
/* 246:    */   }
/* 247:    */   
/* 248:    */   public void setSveh_fijoindicativopais(String string)
/* 249:    */   {
/* 250:215 */     this.sveh_fijoindicativopais = string;
/* 251:    */   }
/* 252:    */   
/* 253:    */   public void setSveh_fijonumero(String string)
/* 254:    */   {
/* 255:219 */     this.sveh_fijonumero = string;
/* 256:    */   }
/* 257:    */   
/* 258:    */   public void setSveh_indciudad1(String string)
/* 259:    */   {
/* 260:223 */     this.sveh_indciudad1 = string;
/* 261:    */   }
/* 262:    */   
/* 263:    */   public void setSveh_indpais1(String string)
/* 264:    */   {
/* 265:227 */     this.sveh_indpais1 = string;
/* 266:    */   }
/* 267:    */   
/* 268:    */   public void setSveh_juridica(String string)
/* 269:    */   {
/* 270:231 */     this.sveh_juridica = string;
/* 271:    */   }
/* 272:    */   
/* 273:    */   public void setSveh_mail(String string)
/* 274:    */   {
/* 275:235 */     this.sveh_mail = string;
/* 276:    */   }
/* 277:    */   
/* 278:    */   public void setSveh_movilindicativopais(String string)
/* 279:    */   {
/* 280:239 */     this.sveh_movilindicativopais = string;
/* 281:    */   }
/* 282:    */   
/* 283:    */   public void setSveh_movilnumero(String string)
/* 284:    */   {
/* 285:243 */     this.sveh_movilnumero = string;
/* 286:    */   }
/* 287:    */   
/* 288:    */   public void setSveh_nomcont(String string)
/* 289:    */   {
/* 290:247 */     this.sveh_nomcont = string;
/* 291:    */   }
/* 292:    */   
/* 293:    */   public void setSveh_numpoliza(String string)
/* 294:    */   {
/* 295:251 */     this.sveh_numpoliza = string;
/* 296:    */   }
/* 297:    */   
/* 298:    */   public void setSveh_pais_cod(String string)
/* 299:    */   {
/* 300:255 */     this.sveh_pais_cod = string;
/* 301:    */   }
/* 302:    */   
/* 303:    */   public void setSveh_perdidahurto(String string)
/* 304:    */   {
/* 305:259 */     this.sveh_perdidahurto = string;
/* 306:    */   }
/* 307:    */   
/* 308:    */   public void setSveh_perdidaparcialdanos(String string)
/* 309:    */   {
/* 310:263 */     this.sveh_perdidaparcialdanos = string;
/* 311:    */   }
/* 312:    */   
/* 313:    */   public void setSveh_perdidatotaldanos(String string)
/* 314:    */   {
/* 315:267 */     this.sveh_perdidatotaldanos = string;
/* 316:    */   }
/* 317:    */   
/* 318:    */   public void setSveh_responsabilidad(String string)
/* 319:    */   {
/* 320:271 */     this.sveh_responsabilidad = string;
/* 321:    */   }
/* 322:    */   
/* 323:    */   public void setSveh_telefono1(String string)
/* 324:    */   {
/* 325:275 */     this.sveh_telefono1 = string;
/* 326:    */   }
/* 327:    */   
/* 328:    */   public void setSveh_terremoto(String string)
/* 329:    */   {
/* 330:279 */     this.sveh_terremoto = string;
/* 331:    */   }
/* 332:    */   
/* 333:    */   public void setSveh_tipo(String string)
/* 334:    */   {
/* 335:283 */     this.sveh_tipo = string;
/* 336:    */   }
/* 337:    */   
/* 338:    */   public void setSveh_transpordedanos(String string)
/* 339:    */   {
/* 340:287 */     this.sveh_transpordedanos = string;
/* 341:    */   }
/* 342:    */   
/* 343:    */   public void setSveh_transportehurto(String string)
/* 344:    */   {
/* 345:291 */     this.sveh_transportehurto = string;
/* 346:    */   }
/* 347:    */   
/* 348:    */   public void setSveh_veh_cod(String string)
/* 349:    */   {
/* 350:295 */     this.sveh_veh_cod = string;
/* 351:    */   }
/* 352:    */   
/* 353:    */   public String getSveh_grup_cod()
/* 354:    */   {
/* 355:299 */     return this.sveh_grup_cod;
/* 356:    */   }
/* 357:    */   
/* 358:    */   public String getSveh_mails_enviados()
/* 359:    */   {
/* 360:303 */     return this.sveh_mails_enviados;
/* 361:    */   }
/* 362:    */   
/* 363:    */   public String getSveh_ultimo_mail()
/* 364:    */   {
/* 365:307 */     return this.sveh_ultimo_mail;
/* 366:    */   }
/* 367:    */   
/* 368:    */   public void setSveh_grup_cod(String sveh_grup_cod)
/* 369:    */   {
/* 370:311 */     this.sveh_grup_cod = sveh_grup_cod;
/* 371:    */   }
/* 372:    */   
/* 373:    */   public void setSveh_mails_enviados(String sveh_mails_enviados)
/* 374:    */   {
/* 375:315 */     this.sveh_mails_enviados = sveh_mails_enviados;
/* 376:    */   }
/* 377:    */   
/* 378:    */   public void setSveh_ultimo_mail(String sveh_ultimo_mail)
/* 379:    */   {
/* 380:319 */     this.sveh_ultimo_mail = sveh_ultimo_mail;
/* 381:    */   }
/* 382:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdcars.controller.SegurosVehiculosForm
 * JD-Core Version:    0.7.0.1
 */