/*   1:    */ package com.servidoctor.sdcars.controller;
/*   2:    */ 
/*   3:    */ import org.apache.struts.validator.ValidatorForm;
/*   4:    */ 
/*   5:    */ public class VehiculosCompletoForm
/*   6:    */   extends ValidatorForm
/*   7:    */ {
/*   8: 16 */   private String vehi_cod = "0";
/*   9: 17 */   private String vehi_usuc_cod = "0";
/*  10: 18 */   private String vehi_placa = "";
/*  11: 19 */   private String vehi_maut_cod = "0";
/*  12: 20 */   private String vehi_tveh_cod = "0";
/*  13: 21 */   private String vehi_modelo = "0";
/*  14: 22 */   private String vehi_feccomp = "0";
/*  15: 23 */   private String vehi_kmsact = "0";
/*  16: 25 */   private String vehi_kmsactm = "0";
/*  17: 26 */   private String vehi_fechaodometrom = "0";
/*  18: 27 */   private String vehi_fechaencerom = "0";
/*  19: 29 */   private String vehi_fechaodometro = "0";
/*  20: 30 */   private String vehi_fechaencero = "0";
/*  21: 31 */   private String vehi_registro = "0";
/*  22: 32 */   private String vehi_kmsencero = "0";
/*  23: 33 */   private String vehi_fechacambiocurva = "0";
/*  24: 34 */   private String vehi_tipo = "";
/*  25: 35 */   private String vehi_kmscomp = "0";
/*  26: 36 */   private String vehi_distancia = "K";
/*  27: 37 */   private String vehi_fecinscripcion = "0";
/*  28: 38 */   private String vehi_num_dias_no_mail = "0";
/*  29: 39 */   private String vehi_sistema = "0";
/*  30: 40 */   private String vehi_cerobasica = "0";
/*  31: 41 */   private String vehi_cerorevision = "0";
/*  32: 42 */   private String vehi_fechatopebloqueo = "0";
/*  33: 45 */   private String tempcero = "0";
/*  34: 47 */   private String revisionesBloqueadasA = "-1";
/*  35: 48 */   private String odometroBloqueado = "-1";
/*  36: 49 */   private String mntnmntoBloqueado = "-1";
/*  37: 51 */   private String pveh_cod = "0";
/*  38: 52 */   private String pveh_veh_cod = "0";
/*  39: 53 */   private String pveh_nombre = "";
/*  40: 54 */   private String pveh_apellido = "";
/*  41: 55 */   private String pveh_pais_cod = "0";
/*  42: 56 */   private String pveh_ciu_cod = "0";
/*  43: 57 */   private String pveh_mail = "";
/*  44: 58 */   private String pveh_indpais1 = "0";
/*  45: 59 */   private String pveh_indciudad1 = "0";
/*  46: 60 */   private String pveh_telefono1 = "";
/*  47: 61 */   private String pveh_indpais2 = "0";
/*  48: 62 */   private String pveh_telefono2 = "";
/*  49: 63 */   private String pveh_sexo = "M";
/*  50: 64 */   private String pveh_fecnacim = "0";
/*  51: 65 */   private String pveh_idio_cod = "0";
/*  52: 67 */   private String com_cod = "0";
/*  53: 68 */   private String com_veh_cod = "0";
/*  54: 69 */   private String com_fechaini = "0";
/*  55: 70 */   private String com_fechafin = "0";
/*  56: 71 */   private String com_lecturaini = "0";
/*  57: 72 */   private String com_lecturafin = "0";
/*  58: 73 */   private String com_cantidadconsumo = "0";
/*  59: 74 */   private String com_costocombustible = "0";
/*  60: 76 */   private String mant_cod = "0";
/*  61: 77 */   private String mant_veh_cod = "0";
/*  62: 78 */   private String mant_cada_cdm = "4";
/*  63: 79 */   private String mant_cada_cdk = "10000";
/*  64: 80 */   private String mant_alt_cod = "3";
/*  65: 81 */   private String mant_fecprox = "0";
/*  66: 82 */   private String mant_fecprox2 = "0";
/*  67: 83 */   private String mant_fecprox3 = "0";
/*  68: 84 */   private String mant_fecprox4 = "0";
/*  69: 85 */   private String mant_registro = "0";
/*  70: 86 */   private String mant_control_fec = "0";
/*  71: 87 */   private String mant_control_kms = "0";
/*  72: 88 */   private String mant_mails_enviados = "0";
/*  73: 91 */   private String fechaMantenimientosBasicos = "0";
/*  74: 92 */   private String distanciaMantenimientosBasicos = "0";
/*  75: 93 */   private String totalMensualGastosMecanica = "0";
/*  76: 94 */   private String totalAnualGastosMecanica = "0";
/*  77: 95 */   private String totalAnualGastosAnuales = "0";
/*  78: 96 */   private String totalMensualGastosNoAnuales = "0";
/*  79: 97 */   private String totalAnualGastosNoAnuales = "0";
/*  80: 98 */   private String resultado_rendimientoS = "0";
/*  81: 99 */   private String resultado_costoDistanciaS = "0";
/*  82:100 */   private String resultado_costoDiaS = "0";
/*  83:102 */   private String vehi_enero = "2500";
/*  84:103 */   private String vehi_febrero = "2500";
/*  85:104 */   private String vehi_marzo = "2500";
/*  86:105 */   private String vehi_abril = "2500";
/*  87:106 */   private String vehi_mayo = "2500";
/*  88:107 */   private String vehi_junio = "2500";
/*  89:108 */   private String vehi_julio = "2500";
/*  90:109 */   private String vehi_agosto = "2500";
/*  91:110 */   private String vehi_septiembre = "2500";
/*  92:111 */   private String vehi_octubre = "2500";
/*  93:112 */   private String vehi_noviembre = "2500";
/*  94:113 */   private String vehi_diciembre = "2500";
/*  95:114 */   private String vehi_promedio = "2500";
/*  96:116 */   private String cveh_dias_antes = "0";
/*  97:117 */   private String sveh_dias_antes = "0";
/*  98:118 */   private String iveh_dias_antes = "0";
/*  99:    */   
/* 100:    */   public String getCom_cantidadconsumo()
/* 101:    */   {
/* 102:121 */     return this.com_cantidadconsumo;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public String getCom_cod()
/* 106:    */   {
/* 107:125 */     return this.com_cod;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public String getCom_costocombustible()
/* 111:    */   {
/* 112:129 */     return this.com_costocombustible;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public String getCom_fechafin()
/* 116:    */   {
/* 117:133 */     return this.com_fechafin;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public String getCom_fechaini()
/* 121:    */   {
/* 122:137 */     return this.com_fechaini;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public String getCom_lecturafin()
/* 126:    */   {
/* 127:141 */     return this.com_lecturafin;
/* 128:    */   }
/* 129:    */   
/* 130:    */   public String getCom_lecturaini()
/* 131:    */   {
/* 132:145 */     return this.com_lecturaini;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public String getCom_veh_cod()
/* 136:    */   {
/* 137:149 */     return this.com_veh_cod;
/* 138:    */   }
/* 139:    */   
/* 140:    */   public String getPveh_apellido()
/* 141:    */   {
/* 142:153 */     return this.pveh_apellido;
/* 143:    */   }
/* 144:    */   
/* 145:    */   public String getPveh_ciu_cod()
/* 146:    */   {
/* 147:157 */     return this.pveh_ciu_cod;
/* 148:    */   }
/* 149:    */   
/* 150:    */   public String getPveh_cod()
/* 151:    */   {
/* 152:161 */     return this.pveh_cod;
/* 153:    */   }
/* 154:    */   
/* 155:    */   public String getPveh_indciudad1()
/* 156:    */   {
/* 157:165 */     return this.pveh_indciudad1;
/* 158:    */   }
/* 159:    */   
/* 160:    */   public String getPveh_indpais1()
/* 161:    */   {
/* 162:169 */     return this.pveh_indpais1;
/* 163:    */   }
/* 164:    */   
/* 165:    */   public String getPveh_indpais2()
/* 166:    */   {
/* 167:173 */     return this.pveh_indpais2;
/* 168:    */   }
/* 169:    */   
/* 170:    */   public String getPveh_mail()
/* 171:    */   {
/* 172:177 */     return this.pveh_mail;
/* 173:    */   }
/* 174:    */   
/* 175:    */   public String getPveh_nombre()
/* 176:    */   {
/* 177:181 */     return this.pveh_nombre;
/* 178:    */   }
/* 179:    */   
/* 180:    */   public String getPveh_pais_cod()
/* 181:    */   {
/* 182:185 */     return this.pveh_pais_cod;
/* 183:    */   }
/* 184:    */   
/* 185:    */   public String getPveh_sexo()
/* 186:    */   {
/* 187:189 */     return this.pveh_sexo;
/* 188:    */   }
/* 189:    */   
/* 190:    */   public String getPveh_telefono1()
/* 191:    */   {
/* 192:193 */     return this.pveh_telefono1;
/* 193:    */   }
/* 194:    */   
/* 195:    */   public String getPveh_telefono2()
/* 196:    */   {
/* 197:197 */     return this.pveh_telefono2;
/* 198:    */   }
/* 199:    */   
/* 200:    */   public String getPveh_veh_cod()
/* 201:    */   {
/* 202:201 */     return this.pveh_veh_cod;
/* 203:    */   }
/* 204:    */   
/* 205:    */   public String getVehi_cod()
/* 206:    */   {
/* 207:205 */     return this.vehi_cod;
/* 208:    */   }
/* 209:    */   
/* 210:    */   public String getVehi_distancia()
/* 211:    */   {
/* 212:209 */     return this.vehi_distancia;
/* 213:    */   }
/* 214:    */   
/* 215:    */   public String getVehi_feccomp()
/* 216:    */   {
/* 217:213 */     return this.vehi_feccomp;
/* 218:    */   }
/* 219:    */   
/* 220:    */   public String getVehi_fecinscripcion()
/* 221:    */   {
/* 222:217 */     return this.vehi_fecinscripcion;
/* 223:    */   }
/* 224:    */   
/* 225:    */   public String getVehi_kmsact()
/* 226:    */   {
/* 227:221 */     return this.vehi_kmsact;
/* 228:    */   }
/* 229:    */   
/* 230:    */   public String getVehi_kmscomp()
/* 231:    */   {
/* 232:225 */     return this.vehi_kmscomp;
/* 233:    */   }
/* 234:    */   
/* 235:    */   public String getVehi_maut_cod()
/* 236:    */   {
/* 237:229 */     return this.vehi_maut_cod;
/* 238:    */   }
/* 239:    */   
/* 240:    */   public String getVehi_modelo()
/* 241:    */   {
/* 242:233 */     return this.vehi_modelo;
/* 243:    */   }
/* 244:    */   
/* 245:    */   public String getVehi_num_dias_no_mail()
/* 246:    */   {
/* 247:237 */     return this.vehi_num_dias_no_mail;
/* 248:    */   }
/* 249:    */   
/* 250:    */   public String getVehi_placa()
/* 251:    */   {
/* 252:241 */     return this.vehi_placa;
/* 253:    */   }
/* 254:    */   
/* 255:    */   public String getVehi_tveh_cod()
/* 256:    */   {
/* 257:245 */     return this.vehi_tveh_cod;
/* 258:    */   }
/* 259:    */   
/* 260:    */   public String getVehi_usuc_cod()
/* 261:    */   {
/* 262:249 */     return this.vehi_usuc_cod;
/* 263:    */   }
/* 264:    */   
/* 265:    */   public String getVehi_abril()
/* 266:    */   {
/* 267:253 */     return this.vehi_abril;
/* 268:    */   }
/* 269:    */   
/* 270:    */   public String getVehi_agosto()
/* 271:    */   {
/* 272:257 */     return this.vehi_agosto;
/* 273:    */   }
/* 274:    */   
/* 275:    */   public String getVehi_diciembre()
/* 276:    */   {
/* 277:261 */     return this.vehi_diciembre;
/* 278:    */   }
/* 279:    */   
/* 280:    */   public String getVehi_enero()
/* 281:    */   {
/* 282:265 */     return this.vehi_enero;
/* 283:    */   }
/* 284:    */   
/* 285:    */   public String getVehi_febrero()
/* 286:    */   {
/* 287:269 */     return this.vehi_febrero;
/* 288:    */   }
/* 289:    */   
/* 290:    */   public String getVehi_julio()
/* 291:    */   {
/* 292:273 */     return this.vehi_julio;
/* 293:    */   }
/* 294:    */   
/* 295:    */   public String getVehi_junio()
/* 296:    */   {
/* 297:277 */     return this.vehi_junio;
/* 298:    */   }
/* 299:    */   
/* 300:    */   public String getVehi_marzo()
/* 301:    */   {
/* 302:281 */     return this.vehi_marzo;
/* 303:    */   }
/* 304:    */   
/* 305:    */   public String getVehi_mayo()
/* 306:    */   {
/* 307:285 */     return this.vehi_mayo;
/* 308:    */   }
/* 309:    */   
/* 310:    */   public String getVehi_noviembre()
/* 311:    */   {
/* 312:289 */     return this.vehi_noviembre;
/* 313:    */   }
/* 314:    */   
/* 315:    */   public String getVehi_octubre()
/* 316:    */   {
/* 317:293 */     return this.vehi_octubre;
/* 318:    */   }
/* 319:    */   
/* 320:    */   public String getVehi_promedio()
/* 321:    */   {
/* 322:297 */     return this.vehi_promedio;
/* 323:    */   }
/* 324:    */   
/* 325:    */   public String getVehi_septiembre()
/* 326:    */   {
/* 327:301 */     return this.vehi_septiembre;
/* 328:    */   }
/* 329:    */   
/* 330:    */   public void setVehi_abril(String string)
/* 331:    */   {
/* 332:305 */     this.vehi_abril = string;
/* 333:    */   }
/* 334:    */   
/* 335:    */   public void setVehi_agosto(String string)
/* 336:    */   {
/* 337:309 */     this.vehi_agosto = string;
/* 338:    */   }
/* 339:    */   
/* 340:    */   public void setVehi_diciembre(String string)
/* 341:    */   {
/* 342:313 */     this.vehi_diciembre = string;
/* 343:    */   }
/* 344:    */   
/* 345:    */   public void setVehi_enero(String string)
/* 346:    */   {
/* 347:317 */     this.vehi_enero = string;
/* 348:    */   }
/* 349:    */   
/* 350:    */   public void setVehi_febrero(String string)
/* 351:    */   {
/* 352:321 */     this.vehi_febrero = string;
/* 353:    */   }
/* 354:    */   
/* 355:    */   public void setVehi_julio(String string)
/* 356:    */   {
/* 357:325 */     this.vehi_julio = string;
/* 358:    */   }
/* 359:    */   
/* 360:    */   public void setVehi_junio(String string)
/* 361:    */   {
/* 362:329 */     this.vehi_junio = string;
/* 363:    */   }
/* 364:    */   
/* 365:    */   public void setVehi_marzo(String string)
/* 366:    */   {
/* 367:333 */     this.vehi_marzo = string;
/* 368:    */   }
/* 369:    */   
/* 370:    */   public void setVehi_mayo(String string)
/* 371:    */   {
/* 372:337 */     this.vehi_mayo = string;
/* 373:    */   }
/* 374:    */   
/* 375:    */   public void setVehi_noviembre(String string)
/* 376:    */   {
/* 377:341 */     this.vehi_noviembre = string;
/* 378:    */   }
/* 379:    */   
/* 380:    */   public void setVehi_octubre(String string)
/* 381:    */   {
/* 382:345 */     this.vehi_octubre = string;
/* 383:    */   }
/* 384:    */   
/* 385:    */   public void setVehi_promedio(String string)
/* 386:    */   {
/* 387:349 */     this.vehi_promedio = string;
/* 388:    */   }
/* 389:    */   
/* 390:    */   public void setVehi_septiembre(String string)
/* 391:    */   {
/* 392:353 */     this.vehi_septiembre = string;
/* 393:    */   }
/* 394:    */   
/* 395:    */   public void setCom_cantidadconsumo(String string)
/* 396:    */   {
/* 397:357 */     this.com_cantidadconsumo = string;
/* 398:    */   }
/* 399:    */   
/* 400:    */   public void setCom_cod(String string)
/* 401:    */   {
/* 402:361 */     this.com_cod = string;
/* 403:    */   }
/* 404:    */   
/* 405:    */   public void setCom_costocombustible(String string)
/* 406:    */   {
/* 407:365 */     this.com_costocombustible = string;
/* 408:    */   }
/* 409:    */   
/* 410:    */   public void setCom_fechafin(String string)
/* 411:    */   {
/* 412:369 */     this.com_fechafin = string;
/* 413:    */   }
/* 414:    */   
/* 415:    */   public void setCom_fechaini(String string)
/* 416:    */   {
/* 417:373 */     this.com_fechaini = string;
/* 418:    */   }
/* 419:    */   
/* 420:    */   public void setCom_lecturafin(String string)
/* 421:    */   {
/* 422:377 */     this.com_lecturafin = string;
/* 423:    */   }
/* 424:    */   
/* 425:    */   public void setCom_lecturaini(String string)
/* 426:    */   {
/* 427:381 */     this.com_lecturaini = string;
/* 428:    */   }
/* 429:    */   
/* 430:    */   public void setCom_veh_cod(String string)
/* 431:    */   {
/* 432:385 */     this.com_veh_cod = string;
/* 433:    */   }
/* 434:    */   
/* 435:    */   public void setPveh_apellido(String string)
/* 436:    */   {
/* 437:389 */     this.pveh_apellido = string;
/* 438:    */   }
/* 439:    */   
/* 440:    */   public void setPveh_ciu_cod(String string)
/* 441:    */   {
/* 442:393 */     this.pveh_ciu_cod = string;
/* 443:    */   }
/* 444:    */   
/* 445:    */   public void setPveh_cod(String string)
/* 446:    */   {
/* 447:397 */     this.pveh_cod = string;
/* 448:    */   }
/* 449:    */   
/* 450:    */   public void setPveh_indciudad1(String string)
/* 451:    */   {
/* 452:401 */     this.pveh_indciudad1 = string;
/* 453:    */   }
/* 454:    */   
/* 455:    */   public void setPveh_indpais1(String string)
/* 456:    */   {
/* 457:405 */     this.pveh_indpais1 = string;
/* 458:    */   }
/* 459:    */   
/* 460:    */   public void setPveh_indpais2(String string)
/* 461:    */   {
/* 462:409 */     this.pveh_indpais2 = string;
/* 463:    */   }
/* 464:    */   
/* 465:    */   public void setPveh_mail(String string)
/* 466:    */   {
/* 467:413 */     this.pveh_mail = string;
/* 468:    */   }
/* 469:    */   
/* 470:    */   public void setPveh_nombre(String string)
/* 471:    */   {
/* 472:417 */     this.pveh_nombre = string;
/* 473:    */   }
/* 474:    */   
/* 475:    */   public void setPveh_pais_cod(String string)
/* 476:    */   {
/* 477:421 */     this.pveh_pais_cod = string;
/* 478:    */   }
/* 479:    */   
/* 480:    */   public void setPveh_sexo(String string)
/* 481:    */   {
/* 482:425 */     this.pveh_sexo = string;
/* 483:    */   }
/* 484:    */   
/* 485:    */   public void setPveh_telefono1(String string)
/* 486:    */   {
/* 487:429 */     this.pveh_telefono1 = string;
/* 488:    */   }
/* 489:    */   
/* 490:    */   public void setPveh_telefono2(String string)
/* 491:    */   {
/* 492:433 */     this.pveh_telefono2 = string;
/* 493:    */   }
/* 494:    */   
/* 495:    */   public void setPveh_veh_cod(String string)
/* 496:    */   {
/* 497:437 */     this.pveh_veh_cod = string;
/* 498:    */   }
/* 499:    */   
/* 500:    */   public void setVehi_cod(String string)
/* 501:    */   {
/* 502:441 */     this.vehi_cod = string;
/* 503:    */   }
/* 504:    */   
/* 505:    */   public void setVehi_distancia(String string)
/* 506:    */   {
/* 507:445 */     this.vehi_distancia = string;
/* 508:    */   }
/* 509:    */   
/* 510:    */   public void setVehi_feccomp(String string)
/* 511:    */   {
/* 512:449 */     this.vehi_feccomp = string;
/* 513:    */   }
/* 514:    */   
/* 515:    */   public void setVehi_fecinscripcion(String string)
/* 516:    */   {
/* 517:453 */     this.vehi_fecinscripcion = string;
/* 518:    */   }
/* 519:    */   
/* 520:    */   public void setVehi_kmsact(String string)
/* 521:    */   {
/* 522:457 */     this.vehi_kmsact = string;
/* 523:    */   }
/* 524:    */   
/* 525:    */   public void setVehi_kmscomp(String string)
/* 526:    */   {
/* 527:461 */     this.vehi_kmscomp = string;
/* 528:    */   }
/* 529:    */   
/* 530:    */   public void setVehi_maut_cod(String string)
/* 531:    */   {
/* 532:465 */     this.vehi_maut_cod = string;
/* 533:    */   }
/* 534:    */   
/* 535:    */   public void setVehi_modelo(String string)
/* 536:    */   {
/* 537:469 */     this.vehi_modelo = string;
/* 538:    */   }
/* 539:    */   
/* 540:    */   public void setVehi_num_dias_no_mail(String string)
/* 541:    */   {
/* 542:473 */     this.vehi_num_dias_no_mail = string;
/* 543:    */   }
/* 544:    */   
/* 545:    */   public void setVehi_placa(String string)
/* 546:    */   {
/* 547:477 */     this.vehi_placa = string;
/* 548:    */   }
/* 549:    */   
/* 550:    */   public void setVehi_tveh_cod(String string)
/* 551:    */   {
/* 552:481 */     this.vehi_tveh_cod = string;
/* 553:    */   }
/* 554:    */   
/* 555:    */   public void setVehi_usuc_cod(String string)
/* 556:    */   {
/* 557:485 */     this.vehi_usuc_cod = string;
/* 558:    */   }
/* 559:    */   
/* 560:    */   public String getDistanciaMantenimientosBasicos()
/* 561:    */   {
/* 562:489 */     return this.distanciaMantenimientosBasicos;
/* 563:    */   }
/* 564:    */   
/* 565:    */   public String getFechaMantenimientosBasicos()
/* 566:    */   {
/* 567:493 */     return this.fechaMantenimientosBasicos;
/* 568:    */   }
/* 569:    */   
/* 570:    */   public void setDistanciaMantenimientosBasicos(String string)
/* 571:    */   {
/* 572:497 */     this.distanciaMantenimientosBasicos = string;
/* 573:    */   }
/* 574:    */   
/* 575:    */   public void setFechaMantenimientosBasicos(String string)
/* 576:    */   {
/* 577:501 */     this.fechaMantenimientosBasicos = string;
/* 578:    */   }
/* 579:    */   
/* 580:    */   public String getMant_alt_cod()
/* 581:    */   {
/* 582:505 */     return this.mant_alt_cod;
/* 583:    */   }
/* 584:    */   
/* 585:    */   public String getMant_cada_cdk()
/* 586:    */   {
/* 587:509 */     return this.mant_cada_cdk;
/* 588:    */   }
/* 589:    */   
/* 590:    */   public String getMant_cada_cdm()
/* 591:    */   {
/* 592:513 */     return this.mant_cada_cdm;
/* 593:    */   }
/* 594:    */   
/* 595:    */   public String getMant_cod()
/* 596:    */   {
/* 597:517 */     return this.mant_cod;
/* 598:    */   }
/* 599:    */   
/* 600:    */   public String getMant_veh_cod()
/* 601:    */   {
/* 602:521 */     return this.mant_veh_cod;
/* 603:    */   }
/* 604:    */   
/* 605:    */   public void setMant_alt_cod(String string)
/* 606:    */   {
/* 607:525 */     this.mant_alt_cod = string;
/* 608:    */   }
/* 609:    */   
/* 610:    */   public void setMant_cada_cdk(String string)
/* 611:    */   {
/* 612:529 */     this.mant_cada_cdk = string;
/* 613:    */   }
/* 614:    */   
/* 615:    */   public void setMant_cada_cdm(String string)
/* 616:    */   {
/* 617:533 */     this.mant_cada_cdm = string;
/* 618:    */   }
/* 619:    */   
/* 620:    */   public void setMant_cod(String string)
/* 621:    */   {
/* 622:537 */     this.mant_cod = string;
/* 623:    */   }
/* 624:    */   
/* 625:    */   public void setMant_veh_cod(String string)
/* 626:    */   {
/* 627:541 */     this.mant_veh_cod = string;
/* 628:    */   }
/* 629:    */   
/* 630:    */   public String getTotalAnualGastosAnuales()
/* 631:    */   {
/* 632:545 */     return this.totalAnualGastosAnuales;
/* 633:    */   }
/* 634:    */   
/* 635:    */   public String getTotalAnualGastosMecanica()
/* 636:    */   {
/* 637:549 */     return this.totalAnualGastosMecanica;
/* 638:    */   }
/* 639:    */   
/* 640:    */   public String getTotalAnualGastosNoAnuales()
/* 641:    */   {
/* 642:553 */     return this.totalAnualGastosNoAnuales;
/* 643:    */   }
/* 644:    */   
/* 645:    */   public String getTotalMensualGastosMecanica()
/* 646:    */   {
/* 647:557 */     return this.totalMensualGastosMecanica;
/* 648:    */   }
/* 649:    */   
/* 650:    */   public String getTotalMensualGastosNoAnuales()
/* 651:    */   {
/* 652:561 */     return this.totalMensualGastosNoAnuales;
/* 653:    */   }
/* 654:    */   
/* 655:    */   public void setTotalAnualGastosAnuales(String string)
/* 656:    */   {
/* 657:565 */     this.totalAnualGastosAnuales = string;
/* 658:    */   }
/* 659:    */   
/* 660:    */   public void setTotalAnualGastosMecanica(String string)
/* 661:    */   {
/* 662:569 */     this.totalAnualGastosMecanica = string;
/* 663:    */   }
/* 664:    */   
/* 665:    */   public void setTotalAnualGastosNoAnuales(String string)
/* 666:    */   {
/* 667:573 */     this.totalAnualGastosNoAnuales = string;
/* 668:    */   }
/* 669:    */   
/* 670:    */   public void setTotalMensualGastosMecanica(String string)
/* 671:    */   {
/* 672:577 */     this.totalMensualGastosMecanica = string;
/* 673:    */   }
/* 674:    */   
/* 675:    */   public void setTotalMensualGastosNoAnuales(String string)
/* 676:    */   {
/* 677:581 */     this.totalMensualGastosNoAnuales = string;
/* 678:    */   }
/* 679:    */   
/* 680:    */   public String getResultado_costoDiaS()
/* 681:    */   {
/* 682:585 */     return this.resultado_costoDiaS;
/* 683:    */   }
/* 684:    */   
/* 685:    */   public String getResultado_costoDistanciaS()
/* 686:    */   {
/* 687:589 */     return this.resultado_costoDistanciaS;
/* 688:    */   }
/* 689:    */   
/* 690:    */   public String getResultado_rendimientoS()
/* 691:    */   {
/* 692:593 */     return this.resultado_rendimientoS;
/* 693:    */   }
/* 694:    */   
/* 695:    */   public void setResultado_costoDiaS(String string)
/* 696:    */   {
/* 697:597 */     this.resultado_costoDiaS = string;
/* 698:    */   }
/* 699:    */   
/* 700:    */   public void setResultado_costoDistanciaS(String string)
/* 701:    */   {
/* 702:601 */     this.resultado_costoDistanciaS = string;
/* 703:    */   }
/* 704:    */   
/* 705:    */   public void setResultado_rendimientoS(String string)
/* 706:    */   {
/* 707:605 */     this.resultado_rendimientoS = string;
/* 708:    */   }
/* 709:    */   
/* 710:    */   public String getPveh_fecnacim()
/* 711:    */   {
/* 712:610 */     return this.pveh_fecnacim;
/* 713:    */   }
/* 714:    */   
/* 715:    */   public void setPveh_fecnacim(String string)
/* 716:    */   {
/* 717:615 */     this.pveh_fecnacim = string;
/* 718:    */   }
/* 719:    */   
/* 720:    */   public String getMant_fecprox()
/* 721:    */   {
/* 722:619 */     return this.mant_fecprox;
/* 723:    */   }
/* 724:    */   
/* 725:    */   public void setMant_fecprox(String string)
/* 726:    */   {
/* 727:623 */     this.mant_fecprox = string;
/* 728:    */   }
/* 729:    */   
/* 730:    */   public String getCveh_dias_antes()
/* 731:    */   {
/* 732:627 */     return this.cveh_dias_antes;
/* 733:    */   }
/* 734:    */   
/* 735:    */   public void setCveh_dias_antes(String cveh_dias_antes)
/* 736:    */   {
/* 737:631 */     this.cveh_dias_antes = cveh_dias_antes;
/* 738:    */   }
/* 739:    */   
/* 740:    */   public String getSveh_dias_antes()
/* 741:    */   {
/* 742:635 */     return this.sveh_dias_antes;
/* 743:    */   }
/* 744:    */   
/* 745:    */   public void setSveh_dias_antes(String sveh_dias_antes)
/* 746:    */   {
/* 747:639 */     this.sveh_dias_antes = sveh_dias_antes;
/* 748:    */   }
/* 749:    */   
/* 750:    */   public String getIveh_dias_antes()
/* 751:    */   {
/* 752:643 */     return this.iveh_dias_antes;
/* 753:    */   }
/* 754:    */   
/* 755:    */   public void setIveh_dias_antes(String iveh_dias_antes)
/* 756:    */   {
/* 757:647 */     this.iveh_dias_antes = iveh_dias_antes;
/* 758:    */   }
/* 759:    */   
/* 760:    */   public String getPveh_idio_cod()
/* 761:    */   {
/* 762:651 */     return this.pveh_idio_cod;
/* 763:    */   }
/* 764:    */   
/* 765:    */   public void setPveh_idio_cod(String pveh_idio_cod)
/* 766:    */   {
/* 767:655 */     this.pveh_idio_cod = pveh_idio_cod;
/* 768:    */   }
/* 769:    */   
/* 770:    */   public String getMant_fecprox2()
/* 771:    */   {
/* 772:659 */     return this.mant_fecprox2;
/* 773:    */   }
/* 774:    */   
/* 775:    */   public void setMant_fecprox2(String mant_fecprox2)
/* 776:    */   {
/* 777:663 */     this.mant_fecprox2 = mant_fecprox2;
/* 778:    */   }
/* 779:    */   
/* 780:    */   public String getMant_fecprox3()
/* 781:    */   {
/* 782:667 */     return this.mant_fecprox3;
/* 783:    */   }
/* 784:    */   
/* 785:    */   public void setMant_fecprox3(String mant_fecprox3)
/* 786:    */   {
/* 787:671 */     this.mant_fecprox3 = mant_fecprox3;
/* 788:    */   }
/* 789:    */   
/* 790:    */   public String getMant_control_fec()
/* 791:    */   {
/* 792:675 */     return this.mant_control_fec;
/* 793:    */   }
/* 794:    */   
/* 795:    */   public void setMant_control_fec(String mant_control_fec)
/* 796:    */   {
/* 797:679 */     this.mant_control_fec = mant_control_fec;
/* 798:    */   }
/* 799:    */   
/* 800:    */   public String getMant_control_kms()
/* 801:    */   {
/* 802:683 */     return this.mant_control_kms;
/* 803:    */   }
/* 804:    */   
/* 805:    */   public void setMant_control_kms(String mant_control_kms)
/* 806:    */   {
/* 807:687 */     this.mant_control_kms = mant_control_kms;
/* 808:    */   }
/* 809:    */   
/* 810:    */   public String getMant_mails_enviados()
/* 811:    */   {
/* 812:691 */     return this.mant_mails_enviados;
/* 813:    */   }
/* 814:    */   
/* 815:    */   public void setMant_mails_enviados(String mant_mails_enviados)
/* 816:    */   {
/* 817:695 */     this.mant_mails_enviados = mant_mails_enviados;
/* 818:    */   }
/* 819:    */   
/* 820:    */   public String getVehi_fechaodometro()
/* 821:    */   {
/* 822:699 */     return this.vehi_fechaodometro;
/* 823:    */   }
/* 824:    */   
/* 825:    */   public void setVehi_fechaodometro(String vehi_fechaodometro)
/* 826:    */   {
/* 827:703 */     this.vehi_fechaodometro = vehi_fechaodometro;
/* 828:    */   }
/* 829:    */   
/* 830:    */   public String getVehi_tipo()
/* 831:    */   {
/* 832:707 */     return this.vehi_tipo;
/* 833:    */   }
/* 834:    */   
/* 835:    */   public void setVehi_tipo(String vehi_tipo)
/* 836:    */   {
/* 837:711 */     this.vehi_tipo = vehi_tipo;
/* 838:    */   }
/* 839:    */   
/* 840:    */   public String getVehi_fechaencero()
/* 841:    */   {
/* 842:715 */     return this.vehi_fechaencero;
/* 843:    */   }
/* 844:    */   
/* 845:    */   public void setVehi_fechaencero(String vehi_fechaencero)
/* 846:    */   {
/* 847:719 */     this.vehi_fechaencero = vehi_fechaencero;
/* 848:    */   }
/* 849:    */   
/* 850:    */   public String getMant_fecprox4()
/* 851:    */   {
/* 852:723 */     return this.mant_fecprox4;
/* 853:    */   }
/* 854:    */   
/* 855:    */   public void setMant_fecprox4(String mant_fecprox4)
/* 856:    */   {
/* 857:727 */     this.mant_fecprox4 = mant_fecprox4;
/* 858:    */   }
/* 859:    */   
/* 860:    */   public String getMant_registro()
/* 861:    */   {
/* 862:731 */     return this.mant_registro;
/* 863:    */   }
/* 864:    */   
/* 865:    */   public void setMant_registro(String mant_registro)
/* 866:    */   {
/* 867:735 */     this.mant_registro = mant_registro;
/* 868:    */   }
/* 869:    */   
/* 870:    */   public String getVehi_kmsencero()
/* 871:    */   {
/* 872:739 */     return this.vehi_kmsencero;
/* 873:    */   }
/* 874:    */   
/* 875:    */   public void setVehi_kmsencero(String vehi_kmsencero)
/* 876:    */   {
/* 877:743 */     this.vehi_kmsencero = vehi_kmsencero;
/* 878:    */   }
/* 879:    */   
/* 880:    */   public String getVehi_registro()
/* 881:    */   {
/* 882:747 */     return this.vehi_registro;
/* 883:    */   }
/* 884:    */   
/* 885:    */   public void setVehi_registro(String vehi_registro)
/* 886:    */   {
/* 887:751 */     this.vehi_registro = vehi_registro;
/* 888:    */   }
/* 889:    */   
/* 890:    */   public String getVehi_fechacambiocurva()
/* 891:    */   {
/* 892:755 */     return this.vehi_fechacambiocurva;
/* 893:    */   }
/* 894:    */   
/* 895:    */   public void setVehi_fechacambiocurva(String vehi_fechacambiocurva)
/* 896:    */   {
/* 897:759 */     this.vehi_fechacambiocurva = vehi_fechacambiocurva;
/* 898:    */   }
/* 899:    */   
/* 900:    */   public String getVehi_sistema()
/* 901:    */   {
/* 902:763 */     return this.vehi_sistema;
/* 903:    */   }
/* 904:    */   
/* 905:    */   public void setVehi_sistema(String vehi_sistema)
/* 906:    */   {
/* 907:767 */     this.vehi_sistema = vehi_sistema;
/* 908:    */   }
/* 909:    */   
/* 910:    */   public String getVehi_cerobasica()
/* 911:    */   {
/* 912:771 */     return this.vehi_cerobasica;
/* 913:    */   }
/* 914:    */   
/* 915:    */   public void setVehi_cerobasica(String vehi_cerobasica)
/* 916:    */   {
/* 917:775 */     this.vehi_cerobasica = vehi_cerobasica;
/* 918:    */   }
/* 919:    */   
/* 920:    */   public String getVehi_cerorevision()
/* 921:    */   {
/* 922:779 */     return this.vehi_cerorevision;
/* 923:    */   }
/* 924:    */   
/* 925:    */   public void setVehi_cerorevision(String vehi_cerorevision)
/* 926:    */   {
/* 927:783 */     this.vehi_cerorevision = vehi_cerorevision;
/* 928:    */   }
/* 929:    */   
/* 930:    */   public String getTempcero()
/* 931:    */   {
/* 932:787 */     return this.tempcero;
/* 933:    */   }
/* 934:    */   
/* 935:    */   public void setTempcero(String tempcero)
/* 936:    */   {
/* 937:791 */     this.tempcero = tempcero;
/* 938:    */   }
/* 939:    */   
/* 940:    */   public String getRevisionesBloqueadasA()
/* 941:    */   {
/* 942:795 */     return this.revisionesBloqueadasA;
/* 943:    */   }
/* 944:    */   
/* 945:    */   public void setRevisionesBloqueadasA(String revisionesBloqueadasA)
/* 946:    */   {
/* 947:799 */     this.revisionesBloqueadasA = revisionesBloqueadasA;
/* 948:    */   }
/* 949:    */   
/* 950:    */   public String getMntnmntoBloqueado()
/* 951:    */   {
/* 952:803 */     return this.mntnmntoBloqueado;
/* 953:    */   }
/* 954:    */   
/* 955:    */   public void setMntnmntoBloqueado(String mntnmntoBloqueado)
/* 956:    */   {
/* 957:807 */     this.mntnmntoBloqueado = mntnmntoBloqueado;
/* 958:    */   }
/* 959:    */   
/* 960:    */   public String getOdometroBloqueado()
/* 961:    */   {
/* 962:811 */     return this.odometroBloqueado;
/* 963:    */   }
/* 964:    */   
/* 965:    */   public void setOdometroBloqueado(String odometroBloqueado)
/* 966:    */   {
/* 967:815 */     this.odometroBloqueado = odometroBloqueado;
/* 968:    */   }
/* 969:    */   
/* 970:    */   public String getVehi_fechaencerom()
/* 971:    */   {
/* 972:819 */     return this.vehi_fechaencerom;
/* 973:    */   }
/* 974:    */   
/* 975:    */   public void setVehi_fechaencerom(String vehi_fechaencerom)
/* 976:    */   {
/* 977:823 */     this.vehi_fechaencerom = vehi_fechaencerom;
/* 978:    */   }
/* 979:    */   
/* 980:    */   public String getVehi_fechaodometrom()
/* 981:    */   {
/* 982:827 */     return this.vehi_fechaodometrom;
/* 983:    */   }
/* 984:    */   
/* 985:    */   public void setVehi_fechaodometrom(String vehi_fechaodometrom)
/* 986:    */   {
/* 987:831 */     this.vehi_fechaodometrom = vehi_fechaodometrom;
/* 988:    */   }
/* 989:    */   
/* 990:    */   public String getVehi_kmsactm()
/* 991:    */   {
/* 992:835 */     return this.vehi_kmsactm;
/* 993:    */   }
/* 994:    */   
/* 995:    */   public void setVehi_kmsactm(String vehi_kmsactm)
/* 996:    */   {
/* 997:839 */     this.vehi_kmsactm = vehi_kmsactm;
/* 998:    */   }
/* 999:    */   
/* :00:    */   public String getVehi_fechatopebloqueo()
/* :01:    */   {
/* :02:842 */     return this.vehi_fechatopebloqueo;
/* :03:    */   }
/* :04:    */   
/* :05:    */   public void setVehi_fechatopebloqueo(String vehi_fechatopebloqueo)
/* :06:    */   {
/* :07:846 */     this.vehi_fechatopebloqueo = vehi_fechatopebloqueo;
/* :08:    */   }
/* :09:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdcars.controller.VehiculosCompletoForm
 * JD-Core Version:    0.7.0.1
 */