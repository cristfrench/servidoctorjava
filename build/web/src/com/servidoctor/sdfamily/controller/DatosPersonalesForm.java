/*   1:    */ package com.servidoctor.sdfamily.controller;
/*   2:    */ 
/*   3:    */ import org.apache.struts.validator.ValidatorForm;
/*   4:    */ 
/*   5:    */ public class DatosPersonalesForm
/*   6:    */   extends ValidatorForm
/*   7:    */ {
/*   8:    */   private String datp_usuf_cod;
/*   9:    */   private String datp_id_doc;
/*  10:    */   private String datp_id_tipo;
/*  11:    */   private String datp_nombre;
/*  12:    */   private String datp_apellido;
/*  13:    */   private String datp_pais_cod;
/*  14:    */   private String datp_ciu_cod;
/*  15:    */   private String datp_idioma;
/*  16:    */   private String datp_fecnacim;
/*  17:    */   private String datp_tipsan_cod;
/*  18:    */   private String datp_sexo;
/*  19:    */   private String datp_indpais1;
/*  20:    */   private String datp_indciudad1;
/*  21:    */   private String datp_telefono1;
/*  22:    */   private String datp_indpais2;
/*  23:    */   private String datp_telefono2;
/*  24:    */   private String datp_mail;
/*  25:    */   private String datp_fecinscripcion;
/*  26:    */   private String datp_estado;
/*  27:    */   private String datp_hijos;
/*  28:    */   private String datp_escolaridad;
/*  29:    */   private String datp_perro;
/*  30:    */   private String datp_gato;
/*  31:    */   private String datp_carro;
/*  32:    */   private String datp_med_fecha1;
/*  33:    */   private String datp_med_est1;
/*  34:    */   private String datp_med_est1b;
/*  35:    */   private String datp_med_peso1;
/*  36:    */   private String datp_med_fecha2;
/*  37:    */   private String datp_med_est2;
/*  38:    */   private String datp_med_est2b;
/*  39:    */   private String datp_med_peso2;
/*  40:    */   private String datp_med_fecha3;
/*  41:    */   private String datp_med_est3;
/*  42:    */   private String datp_med_est3b;
/*  43:    */   private String datp_med_peso3;
/*  44: 53 */   private String grupu_dias_antes = "0";
/*  45: 55 */   private String datp_num_dias_no_mail = "0";
/*  46: 57 */   private String parent_usuf_cod = "0";
/*  47: 58 */   private String parent_nombre = "";
/*  48: 59 */   private String parent_apellido = "";
/*  49: 60 */   private String parent_tarjeta = "0";
/*  50: 61 */   private String parent_rfam_cod = "0";
/*  51:    */   
/*  52:    */   public String getDatp_apellido()
/*  53:    */   {
/*  54: 64 */     return this.datp_apellido;
/*  55:    */   }
/*  56:    */   
/*  57:    */   public String getDatp_carro()
/*  58:    */   {
/*  59: 67 */     return this.datp_carro;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public String getDatp_ciu_cod()
/*  63:    */   {
/*  64: 70 */     return this.datp_ciu_cod;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public String getDatp_escolaridad()
/*  68:    */   {
/*  69: 73 */     return this.datp_escolaridad;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public String getDatp_estado()
/*  73:    */   {
/*  74: 76 */     return this.datp_estado;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public String getDatp_fecinscripcion()
/*  78:    */   {
/*  79: 79 */     return this.datp_fecinscripcion;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public String getDatp_fecnacim()
/*  83:    */   {
/*  84: 82 */     return this.datp_fecnacim;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public String getDatp_gato()
/*  88:    */   {
/*  89: 85 */     return this.datp_gato;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public String getDatp_hijos()
/*  93:    */   {
/*  94: 88 */     return this.datp_hijos;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public String getDatp_id_doc()
/*  98:    */   {
/*  99: 91 */     return this.datp_id_doc;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public String getDatp_id_tipo()
/* 103:    */   {
/* 104: 94 */     return this.datp_id_tipo;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public String getDatp_idioma()
/* 108:    */   {
/* 109: 97 */     return this.datp_idioma;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public String getDatp_indciudad1()
/* 113:    */   {
/* 114:100 */     return this.datp_indciudad1;
/* 115:    */   }
/* 116:    */   
/* 117:    */   public String getDatp_indpais1()
/* 118:    */   {
/* 119:103 */     return this.datp_indpais1;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public String getDatp_indpais2()
/* 123:    */   {
/* 124:106 */     return this.datp_indpais2;
/* 125:    */   }
/* 126:    */   
/* 127:    */   public String getDatp_mail()
/* 128:    */   {
/* 129:109 */     return this.datp_mail;
/* 130:    */   }
/* 131:    */   
/* 132:    */   public String getDatp_med_est1()
/* 133:    */   {
/* 134:112 */     return this.datp_med_est1;
/* 135:    */   }
/* 136:    */   
/* 137:    */   public String getDatp_med_est1b()
/* 138:    */   {
/* 139:115 */     return this.datp_med_est1b;
/* 140:    */   }
/* 141:    */   
/* 142:    */   public String getDatp_med_est2()
/* 143:    */   {
/* 144:118 */     return this.datp_med_est2;
/* 145:    */   }
/* 146:    */   
/* 147:    */   public String getDatp_med_est2b()
/* 148:    */   {
/* 149:121 */     return this.datp_med_est2b;
/* 150:    */   }
/* 151:    */   
/* 152:    */   public String getDatp_med_est3()
/* 153:    */   {
/* 154:124 */     return this.datp_med_est3;
/* 155:    */   }
/* 156:    */   
/* 157:    */   public String getDatp_med_est3b()
/* 158:    */   {
/* 159:127 */     return this.datp_med_est3b;
/* 160:    */   }
/* 161:    */   
/* 162:    */   public String getDatp_med_fecha1()
/* 163:    */   {
/* 164:130 */     return this.datp_med_fecha1;
/* 165:    */   }
/* 166:    */   
/* 167:    */   public String getDatp_med_fecha2()
/* 168:    */   {
/* 169:133 */     return this.datp_med_fecha2;
/* 170:    */   }
/* 171:    */   
/* 172:    */   public String getDatp_med_fecha3()
/* 173:    */   {
/* 174:136 */     return this.datp_med_fecha3;
/* 175:    */   }
/* 176:    */   
/* 177:    */   public String getDatp_med_peso1()
/* 178:    */   {
/* 179:139 */     return this.datp_med_peso1;
/* 180:    */   }
/* 181:    */   
/* 182:    */   public String getDatp_med_peso2()
/* 183:    */   {
/* 184:142 */     return this.datp_med_peso2;
/* 185:    */   }
/* 186:    */   
/* 187:    */   public String getDatp_med_peso3()
/* 188:    */   {
/* 189:145 */     return this.datp_med_peso3;
/* 190:    */   }
/* 191:    */   
/* 192:    */   public String getDatp_nombre()
/* 193:    */   {
/* 194:151 */     return this.datp_nombre;
/* 195:    */   }
/* 196:    */   
/* 197:    */   public String getDatp_num_dias_no_mail()
/* 198:    */   {
/* 199:154 */     return this.datp_num_dias_no_mail;
/* 200:    */   }
/* 201:    */   
/* 202:    */   public String getDatp_pais_cod()
/* 203:    */   {
/* 204:157 */     return this.datp_pais_cod;
/* 205:    */   }
/* 206:    */   
/* 207:    */   public String getDatp_perro()
/* 208:    */   {
/* 209:160 */     return this.datp_perro;
/* 210:    */   }
/* 211:    */   
/* 212:    */   public String getDatp_sexo()
/* 213:    */   {
/* 214:163 */     return this.datp_sexo;
/* 215:    */   }
/* 216:    */   
/* 217:    */   public String getDatp_telefono1()
/* 218:    */   {
/* 219:166 */     return this.datp_telefono1;
/* 220:    */   }
/* 221:    */   
/* 222:    */   public String getDatp_telefono2()
/* 223:    */   {
/* 224:169 */     return this.datp_telefono2;
/* 225:    */   }
/* 226:    */   
/* 227:    */   public String getDatp_tipsan_cod()
/* 228:    */   {
/* 229:172 */     return this.datp_tipsan_cod;
/* 230:    */   }
/* 231:    */   
/* 232:    */   public String getDatp_usuf_cod()
/* 233:    */   {
/* 234:175 */     return this.datp_usuf_cod;
/* 235:    */   }
/* 236:    */   
/* 237:    */   public String getGrupu_dias_antes()
/* 238:    */   {
/* 239:178 */     return this.grupu_dias_antes;
/* 240:    */   }
/* 241:    */   
/* 242:    */   public String getParent_apellido()
/* 243:    */   {
/* 244:181 */     return this.parent_apellido;
/* 245:    */   }
/* 246:    */   
/* 247:    */   public String getParent_nombre()
/* 248:    */   {
/* 249:184 */     return this.parent_nombre;
/* 250:    */   }
/* 251:    */   
/* 252:    */   public String getParent_rfam_cod()
/* 253:    */   {
/* 254:187 */     return this.parent_rfam_cod;
/* 255:    */   }
/* 256:    */   
/* 257:    */   public String getParent_tarjeta()
/* 258:    */   {
/* 259:190 */     return this.parent_tarjeta;
/* 260:    */   }
/* 261:    */   
/* 262:    */   public String getParent_usuf_cod()
/* 263:    */   {
/* 264:193 */     return this.parent_usuf_cod;
/* 265:    */   }
/* 266:    */   
/* 267:    */   public void setDatp_apellido(String datp_apellido)
/* 268:    */   {
/* 269:196 */     this.datp_apellido = datp_apellido;
/* 270:    */   }
/* 271:    */   
/* 272:    */   public void setDatp_carro(String datp_carro)
/* 273:    */   {
/* 274:199 */     this.datp_carro = datp_carro;
/* 275:    */   }
/* 276:    */   
/* 277:    */   public void setDatp_ciu_cod(String datp_ciu_cod)
/* 278:    */   {
/* 279:202 */     this.datp_ciu_cod = datp_ciu_cod;
/* 280:    */   }
/* 281:    */   
/* 282:    */   public void setDatp_escolaridad(String datp_escolaridad)
/* 283:    */   {
/* 284:205 */     this.datp_escolaridad = datp_escolaridad;
/* 285:    */   }
/* 286:    */   
/* 287:    */   public void setDatp_estado(String datp_estado)
/* 288:    */   {
/* 289:208 */     this.datp_estado = datp_estado;
/* 290:    */   }
/* 291:    */   
/* 292:    */   public void setDatp_fecinscripcion(String datp_fecinscripcion)
/* 293:    */   {
/* 294:211 */     this.datp_fecinscripcion = datp_fecinscripcion;
/* 295:    */   }
/* 296:    */   
/* 297:    */   public void setDatp_fecnacim(String datp_fecnacim)
/* 298:    */   {
/* 299:214 */     this.datp_fecnacim = datp_fecnacim;
/* 300:    */   }
/* 301:    */   
/* 302:    */   public void setDatp_gato(String datp_gato)
/* 303:    */   {
/* 304:217 */     this.datp_gato = datp_gato;
/* 305:    */   }
/* 306:    */   
/* 307:    */   public void setDatp_hijos(String datp_hijos)
/* 308:    */   {
/* 309:220 */     this.datp_hijos = datp_hijos;
/* 310:    */   }
/* 311:    */   
/* 312:    */   public void setDatp_id_doc(String datp_id_doc)
/* 313:    */   {
/* 314:223 */     this.datp_id_doc = datp_id_doc;
/* 315:    */   }
/* 316:    */   
/* 317:    */   public void setDatp_id_tipo(String datp_id_tipo)
/* 318:    */   {
/* 319:226 */     this.datp_id_tipo = datp_id_tipo;
/* 320:    */   }
/* 321:    */   
/* 322:    */   public void setDatp_idioma(String datp_idioma)
/* 323:    */   {
/* 324:229 */     this.datp_idioma = datp_idioma;
/* 325:    */   }
/* 326:    */   
/* 327:    */   public void setDatp_indciudad1(String datp_indciudad1)
/* 328:    */   {
/* 329:232 */     this.datp_indciudad1 = datp_indciudad1;
/* 330:    */   }
/* 331:    */   
/* 332:    */   public void setDatp_indpais1(String datp_indpais1)
/* 333:    */   {
/* 334:235 */     this.datp_indpais1 = datp_indpais1;
/* 335:    */   }
/* 336:    */   
/* 337:    */   public void setDatp_indpais2(String datp_indpais2)
/* 338:    */   {
/* 339:238 */     this.datp_indpais2 = datp_indpais2;
/* 340:    */   }
/* 341:    */   
/* 342:    */   public void setDatp_mail(String datp_mail)
/* 343:    */   {
/* 344:241 */     this.datp_mail = datp_mail;
/* 345:    */   }
/* 346:    */   
/* 347:    */   public void setDatp_med_est1(String datp_med_est1)
/* 348:    */   {
/* 349:244 */     this.datp_med_est1 = datp_med_est1;
/* 350:    */   }
/* 351:    */   
/* 352:    */   public void setDatp_med_est1b(String datp_med_est1b)
/* 353:    */   {
/* 354:247 */     this.datp_med_est1b = datp_med_est1b;
/* 355:    */   }
/* 356:    */   
/* 357:    */   public void setDatp_med_est2(String datp_med_est2)
/* 358:    */   {
/* 359:250 */     this.datp_med_est2 = datp_med_est2;
/* 360:    */   }
/* 361:    */   
/* 362:    */   public void setDatp_med_est2b(String datp_med_est2b)
/* 363:    */   {
/* 364:253 */     this.datp_med_est2b = datp_med_est2b;
/* 365:    */   }
/* 366:    */   
/* 367:    */   public void setDatp_med_est3(String datp_med_est3)
/* 368:    */   {
/* 369:256 */     this.datp_med_est3 = datp_med_est3;
/* 370:    */   }
/* 371:    */   
/* 372:    */   public void setDatp_med_est3b(String datp_med_est3b)
/* 373:    */   {
/* 374:259 */     this.datp_med_est3b = datp_med_est3b;
/* 375:    */   }
/* 376:    */   
/* 377:    */   public void setDatp_med_fecha1(String datp_med_fecha1)
/* 378:    */   {
/* 379:262 */     this.datp_med_fecha1 = datp_med_fecha1;
/* 380:    */   }
/* 381:    */   
/* 382:    */   public void setDatp_med_fecha2(String datp_med_fecha2)
/* 383:    */   {
/* 384:265 */     this.datp_med_fecha2 = datp_med_fecha2;
/* 385:    */   }
/* 386:    */   
/* 387:    */   public void setDatp_med_fecha3(String datp_med_fecha3)
/* 388:    */   {
/* 389:268 */     this.datp_med_fecha3 = datp_med_fecha3;
/* 390:    */   }
/* 391:    */   
/* 392:    */   public void setDatp_med_peso1(String datp_med_peso1)
/* 393:    */   {
/* 394:271 */     this.datp_med_peso1 = datp_med_peso1;
/* 395:    */   }
/* 396:    */   
/* 397:    */   public void setDatp_med_peso2(String datp_med_peso2)
/* 398:    */   {
/* 399:274 */     this.datp_med_peso2 = datp_med_peso2;
/* 400:    */   }
/* 401:    */   
/* 402:    */   public void setDatp_med_peso3(String datp_med_peso3)
/* 403:    */   {
/* 404:277 */     this.datp_med_peso3 = datp_med_peso3;
/* 405:    */   }
/* 406:    */   
/* 407:    */   public void setDatp_nombre(String datp_nombre)
/* 408:    */   {
/* 409:283 */     this.datp_nombre = datp_nombre;
/* 410:    */   }
/* 411:    */   
/* 412:    */   public void setDatp_num_dias_no_mail(String datp_num_dias_no_mail)
/* 413:    */   {
/* 414:286 */     this.datp_num_dias_no_mail = datp_num_dias_no_mail;
/* 415:    */   }
/* 416:    */   
/* 417:    */   public void setDatp_pais_cod(String datp_pais_cod)
/* 418:    */   {
/* 419:289 */     this.datp_pais_cod = datp_pais_cod;
/* 420:    */   }
/* 421:    */   
/* 422:    */   public void setDatp_perro(String datp_perro)
/* 423:    */   {
/* 424:292 */     this.datp_perro = datp_perro;
/* 425:    */   }
/* 426:    */   
/* 427:    */   public void setDatp_sexo(String datp_sexo)
/* 428:    */   {
/* 429:295 */     this.datp_sexo = datp_sexo;
/* 430:    */   }
/* 431:    */   
/* 432:    */   public void setDatp_telefono1(String datp_telefono1)
/* 433:    */   {
/* 434:298 */     this.datp_telefono1 = datp_telefono1;
/* 435:    */   }
/* 436:    */   
/* 437:    */   public void setDatp_telefono2(String datp_telefono2)
/* 438:    */   {
/* 439:301 */     this.datp_telefono2 = datp_telefono2;
/* 440:    */   }
/* 441:    */   
/* 442:    */   public void setDatp_tipsan_cod(String datp_tipsan_cod)
/* 443:    */   {
/* 444:304 */     this.datp_tipsan_cod = datp_tipsan_cod;
/* 445:    */   }
/* 446:    */   
/* 447:    */   public void setDatp_usuf_cod(String datp_usuf_cod)
/* 448:    */   {
/* 449:307 */     this.datp_usuf_cod = datp_usuf_cod;
/* 450:    */   }
/* 451:    */   
/* 452:    */   public void setGrupu_dias_antes(String grupu_dias_antes)
/* 453:    */   {
/* 454:310 */     this.grupu_dias_antes = grupu_dias_antes;
/* 455:    */   }
/* 456:    */   
/* 457:    */   public void setParent_apellido(String parent_apellido)
/* 458:    */   {
/* 459:313 */     this.parent_apellido = parent_apellido;
/* 460:    */   }
/* 461:    */   
/* 462:    */   public void setParent_nombre(String parent_nombre)
/* 463:    */   {
/* 464:316 */     this.parent_nombre = parent_nombre;
/* 465:    */   }
/* 466:    */   
/* 467:    */   public void setParent_rfam_cod(String parent_rfam_cod)
/* 468:    */   {
/* 469:319 */     this.parent_rfam_cod = parent_rfam_cod;
/* 470:    */   }
/* 471:    */   
/* 472:    */   public void setParent_tarjeta(String parent_tarjeta)
/* 473:    */   {
/* 474:322 */     this.parent_tarjeta = parent_tarjeta;
/* 475:    */   }
/* 476:    */   
/* 477:    */   public void setParent_usuf_cod(String parent_usuf_cod)
/* 478:    */   {
/* 479:325 */     this.parent_usuf_cod = parent_usuf_cod;
/* 480:    */   }
/* 481:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.controller.DatosPersonalesForm
 * JD-Core Version:    0.7.0.1
 */