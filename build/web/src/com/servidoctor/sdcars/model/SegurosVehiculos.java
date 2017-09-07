/*   1:    */ package com.servidoctor.sdcars.model;
/*   2:    */ 
/*   3:    */ import java.math.BigDecimal;
/*   4:    */ 
/*   5:    */ public class SegurosVehiculos
/*   6:    */ {
/*   7:    */   private BigDecimal sveh_cod;
/*   8:    */   private BigDecimal sveh_veh_cod;
/*   9:    */   private String sveh_tipo;
/*  10:    */   private String sveh_ciaaseg;
/*  11:    */   private String sveh_ageemisor;
/*  12:    */   private BigDecimal sveh_ciu_cod;
/*  13:    */   private BigDecimal sveh_pais_cod;
/*  14:    */   private String sveh_nomcont;
/*  15:    */   private BigDecimal sveh_indpais1;
/*  16:    */   private BigDecimal sveh_indciudad1;
/*  17:    */   private String sveh_telefono1;
/*  18:    */   private String sveh_mail;
/*  19:    */   private BigDecimal sveh_responsabilidad;
/*  20:    */   private BigDecimal sveh_juridica;
/*  21:    */   private BigDecimal sveh_perdidaparcialdanos;
/*  22:    */   private BigDecimal sveh_perdidatotaldanos;
/*  23:    */   private BigDecimal sveh_perdidahurto;
/*  24:    */   private BigDecimal sveh_amparodanos;
/*  25:    */   private BigDecimal sveh_amparocivil;
/*  26:    */   private BigDecimal sveh_transpordedanos;
/*  27:    */   private BigDecimal sveh_transportehurto;
/*  28:    */   private BigDecimal sveh_asistenciaviaje;
/*  29:    */   private BigDecimal sveh_terremoto;
/*  30:    */   private String sveh_numpoliza;
/*  31:    */   private BigDecimal sveh_fecvigenchasta;
/*  32:    */   private BigDecimal sveh_movilindicativopais;
/*  33:    */   private String sveh_movilnumero;
/*  34:    */   private BigDecimal sveh_fijoindicativopais;
/*  35:    */   private BigDecimal sveh_fijoindicativociudad;
/*  36:    */   private String sveh_fijonumero;
/*  37:    */   private BigDecimal sveh_deducible;
/*  38:    */   private BigDecimal sveh_grup_cod;
/*  39:    */   private BigDecimal sveh_fecenvio2;
/*  40:    */   private BigDecimal sveh_fecenvion2;
/*  41:    */   private BigDecimal sveh_fecenvion;
/*  42:    */   private BigDecimal sveh_quince_dias;
/*  43:    */   private BigDecimal sveh_mails_enviados;
/*  44:    */   private BigDecimal sveh_ultimo_mail;
/*  45:    */   
/*  46:    */   public String getSveh_ageemisor()
/*  47:    */   {
/*  48: 49 */     return this.sveh_ageemisor;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public BigDecimal getSveh_amparocivil()
/*  52:    */   {
/*  53: 53 */     return this.sveh_amparocivil;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public BigDecimal getSveh_amparodanos()
/*  57:    */   {
/*  58: 57 */     return this.sveh_amparodanos;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public BigDecimal getSveh_asistenciaviaje()
/*  62:    */   {
/*  63: 61 */     return this.sveh_asistenciaviaje;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public String getSveh_ciaaseg()
/*  67:    */   {
/*  68: 65 */     return this.sveh_ciaaseg;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public BigDecimal getSveh_ciu_cod()
/*  72:    */   {
/*  73: 69 */     return this.sveh_ciu_cod;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public BigDecimal getSveh_cod()
/*  77:    */   {
/*  78: 73 */     return this.sveh_cod;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public BigDecimal getSveh_deducible()
/*  82:    */   {
/*  83: 77 */     return this.sveh_deducible;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public BigDecimal getSveh_fecvigenchasta()
/*  87:    */   {
/*  88: 81 */     return this.sveh_fecvigenchasta;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public BigDecimal getSveh_fijoindicativociudad()
/*  92:    */   {
/*  93: 85 */     return this.sveh_fijoindicativociudad;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public BigDecimal getSveh_fijoindicativopais()
/*  97:    */   {
/*  98: 89 */     return this.sveh_fijoindicativopais;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public String getSveh_fijonumero()
/* 102:    */   {
/* 103: 93 */     return this.sveh_fijonumero;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public BigDecimal getSveh_indciudad1()
/* 107:    */   {
/* 108: 97 */     return this.sveh_indciudad1;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public BigDecimal getSveh_indpais1()
/* 112:    */   {
/* 113:101 */     return this.sveh_indpais1;
/* 114:    */   }
/* 115:    */   
/* 116:    */   public BigDecimal getSveh_juridica()
/* 117:    */   {
/* 118:105 */     return this.sveh_juridica;
/* 119:    */   }
/* 120:    */   
/* 121:    */   public String getSveh_mail()
/* 122:    */   {
/* 123:109 */     return this.sveh_mail;
/* 124:    */   }
/* 125:    */   
/* 126:    */   public BigDecimal getSveh_movilindicativopais()
/* 127:    */   {
/* 128:113 */     return this.sveh_movilindicativopais;
/* 129:    */   }
/* 130:    */   
/* 131:    */   public String getSveh_movilnumero()
/* 132:    */   {
/* 133:117 */     return this.sveh_movilnumero;
/* 134:    */   }
/* 135:    */   
/* 136:    */   public String getSveh_nomcont()
/* 137:    */   {
/* 138:121 */     return this.sveh_nomcont;
/* 139:    */   }
/* 140:    */   
/* 141:    */   public String getSveh_numpoliza()
/* 142:    */   {
/* 143:125 */     return this.sveh_numpoliza;
/* 144:    */   }
/* 145:    */   
/* 146:    */   public BigDecimal getSveh_pais_cod()
/* 147:    */   {
/* 148:129 */     return this.sveh_pais_cod;
/* 149:    */   }
/* 150:    */   
/* 151:    */   public BigDecimal getSveh_perdidahurto()
/* 152:    */   {
/* 153:133 */     return this.sveh_perdidahurto;
/* 154:    */   }
/* 155:    */   
/* 156:    */   public BigDecimal getSveh_perdidaparcialdanos()
/* 157:    */   {
/* 158:137 */     return this.sveh_perdidaparcialdanos;
/* 159:    */   }
/* 160:    */   
/* 161:    */   public BigDecimal getSveh_perdidatotaldanos()
/* 162:    */   {
/* 163:141 */     return this.sveh_perdidatotaldanos;
/* 164:    */   }
/* 165:    */   
/* 166:    */   public BigDecimal getSveh_responsabilidad()
/* 167:    */   {
/* 168:145 */     return this.sveh_responsabilidad;
/* 169:    */   }
/* 170:    */   
/* 171:    */   public String getSveh_telefono1()
/* 172:    */   {
/* 173:149 */     return this.sveh_telefono1;
/* 174:    */   }
/* 175:    */   
/* 176:    */   public BigDecimal getSveh_terremoto()
/* 177:    */   {
/* 178:153 */     return this.sveh_terremoto;
/* 179:    */   }
/* 180:    */   
/* 181:    */   public String getSveh_tipo()
/* 182:    */   {
/* 183:157 */     return this.sveh_tipo;
/* 184:    */   }
/* 185:    */   
/* 186:    */   public BigDecimal getSveh_transpordedanos()
/* 187:    */   {
/* 188:161 */     return this.sveh_transpordedanos;
/* 189:    */   }
/* 190:    */   
/* 191:    */   public BigDecimal getSveh_transportehurto()
/* 192:    */   {
/* 193:165 */     return this.sveh_transportehurto;
/* 194:    */   }
/* 195:    */   
/* 196:    */   public BigDecimal getSveh_veh_cod()
/* 197:    */   {
/* 198:169 */     return this.sveh_veh_cod;
/* 199:    */   }
/* 200:    */   
/* 201:    */   public void setSveh_ageemisor(String string)
/* 202:    */   {
/* 203:173 */     this.sveh_ageemisor = string;
/* 204:    */   }
/* 205:    */   
/* 206:    */   public void setSveh_amparocivil(BigDecimal decimal)
/* 207:    */   {
/* 208:177 */     this.sveh_amparocivil = decimal;
/* 209:    */   }
/* 210:    */   
/* 211:    */   public void setSveh_amparodanos(BigDecimal decimal)
/* 212:    */   {
/* 213:181 */     this.sveh_amparodanos = decimal;
/* 214:    */   }
/* 215:    */   
/* 216:    */   public void setSveh_asistenciaviaje(BigDecimal decimal)
/* 217:    */   {
/* 218:185 */     this.sveh_asistenciaviaje = decimal;
/* 219:    */   }
/* 220:    */   
/* 221:    */   public void setSveh_ciaaseg(String string)
/* 222:    */   {
/* 223:189 */     this.sveh_ciaaseg = string;
/* 224:    */   }
/* 225:    */   
/* 226:    */   public void setSveh_ciu_cod(BigDecimal decimal)
/* 227:    */   {
/* 228:193 */     this.sveh_ciu_cod = decimal;
/* 229:    */   }
/* 230:    */   
/* 231:    */   public void setSveh_cod(BigDecimal decimal)
/* 232:    */   {
/* 233:197 */     this.sveh_cod = decimal;
/* 234:    */   }
/* 235:    */   
/* 236:    */   public void setSveh_deducible(BigDecimal decimal)
/* 237:    */   {
/* 238:201 */     this.sveh_deducible = decimal;
/* 239:    */   }
/* 240:    */   
/* 241:    */   public void setSveh_fecvigenchasta(BigDecimal decimal)
/* 242:    */   {
/* 243:205 */     this.sveh_fecvigenchasta = decimal;
/* 244:    */   }
/* 245:    */   
/* 246:    */   public void setSveh_fijoindicativociudad(BigDecimal decimal)
/* 247:    */   {
/* 248:209 */     this.sveh_fijoindicativociudad = decimal;
/* 249:    */   }
/* 250:    */   
/* 251:    */   public void setSveh_fijoindicativopais(BigDecimal decimal)
/* 252:    */   {
/* 253:213 */     this.sveh_fijoindicativopais = decimal;
/* 254:    */   }
/* 255:    */   
/* 256:    */   public void setSveh_fijonumero(String string)
/* 257:    */   {
/* 258:217 */     this.sveh_fijonumero = string;
/* 259:    */   }
/* 260:    */   
/* 261:    */   public void setSveh_indciudad1(BigDecimal decimal)
/* 262:    */   {
/* 263:221 */     this.sveh_indciudad1 = decimal;
/* 264:    */   }
/* 265:    */   
/* 266:    */   public void setSveh_indpais1(BigDecimal decimal)
/* 267:    */   {
/* 268:225 */     this.sveh_indpais1 = decimal;
/* 269:    */   }
/* 270:    */   
/* 271:    */   public void setSveh_juridica(BigDecimal decimal)
/* 272:    */   {
/* 273:229 */     this.sveh_juridica = decimal;
/* 274:    */   }
/* 275:    */   
/* 276:    */   public void setSveh_mail(String string)
/* 277:    */   {
/* 278:233 */     this.sveh_mail = string;
/* 279:    */   }
/* 280:    */   
/* 281:    */   public void setSveh_movilindicativopais(BigDecimal decimal)
/* 282:    */   {
/* 283:237 */     this.sveh_movilindicativopais = decimal;
/* 284:    */   }
/* 285:    */   
/* 286:    */   public void setSveh_movilnumero(String string)
/* 287:    */   {
/* 288:241 */     this.sveh_movilnumero = string;
/* 289:    */   }
/* 290:    */   
/* 291:    */   public void setSveh_nomcont(String string)
/* 292:    */   {
/* 293:245 */     this.sveh_nomcont = string;
/* 294:    */   }
/* 295:    */   
/* 296:    */   public void setSveh_numpoliza(String string)
/* 297:    */   {
/* 298:249 */     this.sveh_numpoliza = string;
/* 299:    */   }
/* 300:    */   
/* 301:    */   public void setSveh_pais_cod(BigDecimal decimal)
/* 302:    */   {
/* 303:253 */     this.sveh_pais_cod = decimal;
/* 304:    */   }
/* 305:    */   
/* 306:    */   public void setSveh_perdidahurto(BigDecimal decimal)
/* 307:    */   {
/* 308:257 */     this.sveh_perdidahurto = decimal;
/* 309:    */   }
/* 310:    */   
/* 311:    */   public void setSveh_perdidaparcialdanos(BigDecimal decimal)
/* 312:    */   {
/* 313:261 */     this.sveh_perdidaparcialdanos = decimal;
/* 314:    */   }
/* 315:    */   
/* 316:    */   public void setSveh_perdidatotaldanos(BigDecimal decimal)
/* 317:    */   {
/* 318:265 */     this.sveh_perdidatotaldanos = decimal;
/* 319:    */   }
/* 320:    */   
/* 321:    */   public void setSveh_responsabilidad(BigDecimal decimal)
/* 322:    */   {
/* 323:269 */     this.sveh_responsabilidad = decimal;
/* 324:    */   }
/* 325:    */   
/* 326:    */   public void setSveh_telefono1(String string)
/* 327:    */   {
/* 328:273 */     this.sveh_telefono1 = string;
/* 329:    */   }
/* 330:    */   
/* 331:    */   public void setSveh_terremoto(BigDecimal decimal)
/* 332:    */   {
/* 333:277 */     this.sveh_terremoto = decimal;
/* 334:    */   }
/* 335:    */   
/* 336:    */   public void setSveh_tipo(String string)
/* 337:    */   {
/* 338:281 */     this.sveh_tipo = string;
/* 339:    */   }
/* 340:    */   
/* 341:    */   public void setSveh_transpordedanos(BigDecimal decimal)
/* 342:    */   {
/* 343:285 */     this.sveh_transpordedanos = decimal;
/* 344:    */   }
/* 345:    */   
/* 346:    */   public void setSveh_transportehurto(BigDecimal decimal)
/* 347:    */   {
/* 348:289 */     this.sveh_transportehurto = decimal;
/* 349:    */   }
/* 350:    */   
/* 351:    */   public void setSveh_veh_cod(BigDecimal decimal)
/* 352:    */   {
/* 353:293 */     this.sveh_veh_cod = decimal;
/* 354:    */   }
/* 355:    */   
/* 356:    */   public BigDecimal getSveh_grup_cod()
/* 357:    */   {
/* 358:297 */     return this.sveh_grup_cod;
/* 359:    */   }
/* 360:    */   
/* 361:    */   public BigDecimal getSveh_mails_enviados()
/* 362:    */   {
/* 363:301 */     return this.sveh_mails_enviados;
/* 364:    */   }
/* 365:    */   
/* 366:    */   public BigDecimal getSveh_ultimo_mail()
/* 367:    */   {
/* 368:305 */     return this.sveh_ultimo_mail;
/* 369:    */   }
/* 370:    */   
/* 371:    */   public void setSveh_grup_cod(BigDecimal sveh_grup_cod)
/* 372:    */   {
/* 373:309 */     this.sveh_grup_cod = sveh_grup_cod;
/* 374:    */   }
/* 375:    */   
/* 376:    */   public void setSveh_mails_enviados(BigDecimal sveh_mails_enviados)
/* 377:    */   {
/* 378:313 */     this.sveh_mails_enviados = sveh_mails_enviados;
/* 379:    */   }
/* 380:    */   
/* 381:    */   public void setSveh_ultimo_mail(BigDecimal sveh_ultimo_mail)
/* 382:    */   {
/* 383:317 */     this.sveh_ultimo_mail = sveh_ultimo_mail;
/* 384:    */   }
/* 385:    */   
/* 386:    */   public BigDecimal getSveh_fecenvio2()
/* 387:    */   {
/* 388:321 */     return this.sveh_fecenvio2;
/* 389:    */   }
/* 390:    */   
/* 391:    */   public void setSveh_fecenvio2(BigDecimal sveh_fecenvio2)
/* 392:    */   {
/* 393:325 */     this.sveh_fecenvio2 = sveh_fecenvio2;
/* 394:    */   }
/* 395:    */   
/* 396:    */   public BigDecimal getSveh_fecenvion()
/* 397:    */   {
/* 398:329 */     return this.sveh_fecenvion;
/* 399:    */   }
/* 400:    */   
/* 401:    */   public void setSveh_fecenvion(BigDecimal sveh_fecenvion)
/* 402:    */   {
/* 403:333 */     this.sveh_fecenvion = sveh_fecenvion;
/* 404:    */   }
/* 405:    */   
/* 406:    */   public BigDecimal getSveh_fecenvion2()
/* 407:    */   {
/* 408:337 */     return this.sveh_fecenvion2;
/* 409:    */   }
/* 410:    */   
/* 411:    */   public void setSveh_fecenvion2(BigDecimal sveh_fecenvion2)
/* 412:    */   {
/* 413:341 */     this.sveh_fecenvion2 = sveh_fecenvion2;
/* 414:    */   }
/* 415:    */   
/* 416:    */   public BigDecimal getSveh_quince_dias()
/* 417:    */   {
/* 418:345 */     return this.sveh_quince_dias;
/* 419:    */   }
/* 420:    */   
/* 421:    */   public void setSveh_quince_dias(BigDecimal sveh_quince_dias)
/* 422:    */   {
/* 423:349 */     this.sveh_quince_dias = sveh_quince_dias;
/* 424:    */   }
/* 425:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdcars.model.SegurosVehiculos
 * JD-Core Version:    0.7.0.1
 */