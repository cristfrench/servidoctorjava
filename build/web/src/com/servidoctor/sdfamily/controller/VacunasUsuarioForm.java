/*   1:    */ package com.servidoctor.sdfamily.controller;
/*   2:    */ 
/*   3:    */ import org.apache.struts.validator.ValidatorForm;
/*   4:    */ 
/*   5:    */ public class VacunasUsuarioForm
/*   6:    */   extends ValidatorForm
/*   7:    */ {
/*   8: 14 */   private String vacu_cod = "0";
/*   9: 15 */   private String vacu_usuf_cod = "0";
/*  10: 16 */   private String vacu_vac_cod = "0";
/*  11: 17 */   private String vacu_des = "";
/*  12: 18 */   private String vacu_edad_mes1 = "0";
/*  13: 19 */   private String vacu_edad_mes2 = "0";
/*  14: 20 */   private String vacu_edad_mes3 = "0";
/*  15: 21 */   private String vacu_edad_mes4 = "0";
/*  16: 22 */   private String vacu_edad_mes5 = "0";
/*  17: 23 */   private String vacu_edad_mes6 = "0";
/*  18: 24 */   private String vacu_edad_mes7 = "0";
/*  19: 25 */   private String vacu_edad_mes8 = "0";
/*  20: 26 */   private String vacu_edad_mes9 = "0";
/*  21: 27 */   private String vacu_edad_mes10 = "0";
/*  22: 28 */   private String vacu_edad_mes11 = "0";
/*  23: 29 */   private String vacu_edad_mes12 = "0";
/*  24: 30 */   private String vacu_edad_mes13 = "0";
/*  25: 31 */   private String vacu_edad_mes14 = "0";
/*  26: 32 */   private String vacu_edad_mes15 = "0";
/*  27: 33 */   private String vacu_edad_mes16 = "0";
/*  28: 34 */   private String vacu_edad_mes17 = "0";
/*  29: 35 */   private String vacu_edad_mes18 = "0";
/*  30: 36 */   private String vacu_edad_mes19 = "0";
/*  31: 37 */   private String vacu_edad_mes20 = "0";
/*  32: 38 */   private String vacu_edad_mes21 = "0";
/*  33: 39 */   private String vacu_edad_mes22 = "0";
/*  34: 40 */   private String vacu_edad_mes23 = "0";
/*  35: 41 */   private String vacu_edad_mes24 = "0";
/*  36: 42 */   private String vacu_edad_anno3 = "0";
/*  37: 43 */   private String vacu_edad_anno4 = "0";
/*  38: 44 */   private String vacu_edad_anno5 = "0";
/*  39: 45 */   private String vacu_edad_anno6 = "0";
/*  40: 46 */   private String vacu_edad_anno7 = "0";
/*  41: 47 */   private String vacu_edad_anno8 = "0";
/*  42: 48 */   private String vacu_edad_anno9 = "0";
/*  43: 49 */   private String vacu_edad_anno10 = "0";
/*  44: 50 */   private String vacu_edad_anno11 = "0";
/*  45: 51 */   private String vacu_edad_anno12 = "0";
/*  46: 52 */   private String vacu_edad_anno13 = "0";
/*  47: 53 */   private String vacu_edad_anno14 = "0";
/*  48: 54 */   private String vacu_edad_anno15 = "0";
/*  49: 55 */   private String vacu_edad_anno16 = "0";
/*  50: 56 */   private String vacu_edad_anno17 = "0";
/*  51: 57 */   private String vacu_edad_anno18 = "0";
/*  52: 58 */   private String vacu_edad_anno20 = "0";
/*  53: 59 */   private String vacu_edad_anno30 = "0";
/*  54: 60 */   private String vacu_edad_anno40 = "0";
/*  55: 61 */   private String vacu_edad_anno50 = "0";
/*  56: 62 */   private String vacu_edad_anno60 = "0";
/*  57: 63 */   private String vacu_edad_anno70 = "0";
/*  58: 64 */   private String vacu_edad_anno80 = "0";
/*  59: 65 */   private String vacu_edad_anno90 = "0";
/*  60: 66 */   private String vacu_fecenvio2 = "0";
/*  61: 67 */   private String vacu_fecenvion2 = "0";
/*  62: 68 */   private String vacu_fecenvion = "0";
/*  63: 69 */   private String vacu_quince_dias = "0";
/*  64: 70 */   private String vacu_mails_enviados = "0";
/*  65: 71 */   private String vacu_ultimo_mail = "0";
/*  66: 72 */   private String vacu_grup_cod = "0";
/*  67:    */   
/*  68:    */   public String getVacu_cod()
/*  69:    */   {
/*  70: 75 */     return this.vacu_cod;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public String getVacu_des()
/*  74:    */   {
/*  75: 79 */     return this.vacu_des;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public String getVacu_edad_anno10()
/*  79:    */   {
/*  80: 83 */     return this.vacu_edad_anno10;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public String getVacu_edad_anno11()
/*  84:    */   {
/*  85: 87 */     return this.vacu_edad_anno11;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public String getVacu_edad_anno12()
/*  89:    */   {
/*  90: 91 */     return this.vacu_edad_anno12;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public String getVacu_edad_anno13()
/*  94:    */   {
/*  95: 95 */     return this.vacu_edad_anno13;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public String getVacu_edad_anno14()
/*  99:    */   {
/* 100: 99 */     return this.vacu_edad_anno14;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public String getVacu_edad_anno15()
/* 104:    */   {
/* 105:103 */     return this.vacu_edad_anno15;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public String getVacu_edad_anno16()
/* 109:    */   {
/* 110:107 */     return this.vacu_edad_anno16;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public String getVacu_edad_anno17()
/* 114:    */   {
/* 115:111 */     return this.vacu_edad_anno17;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public String getVacu_edad_anno18()
/* 119:    */   {
/* 120:115 */     return this.vacu_edad_anno18;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public String getVacu_edad_anno20()
/* 124:    */   {
/* 125:119 */     return this.vacu_edad_anno20;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public String getVacu_edad_anno3()
/* 129:    */   {
/* 130:123 */     return this.vacu_edad_anno3;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public String getVacu_edad_anno30()
/* 134:    */   {
/* 135:127 */     return this.vacu_edad_anno30;
/* 136:    */   }
/* 137:    */   
/* 138:    */   public String getVacu_edad_anno4()
/* 139:    */   {
/* 140:131 */     return this.vacu_edad_anno4;
/* 141:    */   }
/* 142:    */   
/* 143:    */   public String getVacu_edad_anno40()
/* 144:    */   {
/* 145:135 */     return this.vacu_edad_anno40;
/* 146:    */   }
/* 147:    */   
/* 148:    */   public String getVacu_edad_anno5()
/* 149:    */   {
/* 150:139 */     return this.vacu_edad_anno5;
/* 151:    */   }
/* 152:    */   
/* 153:    */   public String getVacu_edad_anno50()
/* 154:    */   {
/* 155:143 */     return this.vacu_edad_anno50;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public String getVacu_edad_anno6()
/* 159:    */   {
/* 160:147 */     return this.vacu_edad_anno6;
/* 161:    */   }
/* 162:    */   
/* 163:    */   public String getVacu_edad_anno60()
/* 164:    */   {
/* 165:151 */     return this.vacu_edad_anno60;
/* 166:    */   }
/* 167:    */   
/* 168:    */   public String getVacu_edad_anno7()
/* 169:    */   {
/* 170:155 */     return this.vacu_edad_anno7;
/* 171:    */   }
/* 172:    */   
/* 173:    */   public String getVacu_edad_anno70()
/* 174:    */   {
/* 175:159 */     return this.vacu_edad_anno70;
/* 176:    */   }
/* 177:    */   
/* 178:    */   public String getVacu_edad_anno8()
/* 179:    */   {
/* 180:163 */     return this.vacu_edad_anno8;
/* 181:    */   }
/* 182:    */   
/* 183:    */   public String getVacu_edad_anno80()
/* 184:    */   {
/* 185:167 */     return this.vacu_edad_anno80;
/* 186:    */   }
/* 187:    */   
/* 188:    */   public String getVacu_edad_anno9()
/* 189:    */   {
/* 190:171 */     return this.vacu_edad_anno9;
/* 191:    */   }
/* 192:    */   
/* 193:    */   public String getVacu_edad_anno90()
/* 194:    */   {
/* 195:175 */     return this.vacu_edad_anno90;
/* 196:    */   }
/* 197:    */   
/* 198:    */   public String getVacu_edad_mes1()
/* 199:    */   {
/* 200:179 */     return this.vacu_edad_mes1;
/* 201:    */   }
/* 202:    */   
/* 203:    */   public String getVacu_edad_mes10()
/* 204:    */   {
/* 205:183 */     return this.vacu_edad_mes10;
/* 206:    */   }
/* 207:    */   
/* 208:    */   public String getVacu_edad_mes11()
/* 209:    */   {
/* 210:187 */     return this.vacu_edad_mes11;
/* 211:    */   }
/* 212:    */   
/* 213:    */   public String getVacu_edad_mes12()
/* 214:    */   {
/* 215:191 */     return this.vacu_edad_mes12;
/* 216:    */   }
/* 217:    */   
/* 218:    */   public String getVacu_edad_mes13()
/* 219:    */   {
/* 220:195 */     return this.vacu_edad_mes13;
/* 221:    */   }
/* 222:    */   
/* 223:    */   public String getVacu_edad_mes14()
/* 224:    */   {
/* 225:199 */     return this.vacu_edad_mes14;
/* 226:    */   }
/* 227:    */   
/* 228:    */   public String getVacu_edad_mes15()
/* 229:    */   {
/* 230:203 */     return this.vacu_edad_mes15;
/* 231:    */   }
/* 232:    */   
/* 233:    */   public String getVacu_edad_mes16()
/* 234:    */   {
/* 235:207 */     return this.vacu_edad_mes16;
/* 236:    */   }
/* 237:    */   
/* 238:    */   public String getVacu_edad_mes17()
/* 239:    */   {
/* 240:211 */     return this.vacu_edad_mes17;
/* 241:    */   }
/* 242:    */   
/* 243:    */   public String getVacu_edad_mes18()
/* 244:    */   {
/* 245:215 */     return this.vacu_edad_mes18;
/* 246:    */   }
/* 247:    */   
/* 248:    */   public String getVacu_edad_mes19()
/* 249:    */   {
/* 250:219 */     return this.vacu_edad_mes19;
/* 251:    */   }
/* 252:    */   
/* 253:    */   public String getVacu_edad_mes2()
/* 254:    */   {
/* 255:223 */     return this.vacu_edad_mes2;
/* 256:    */   }
/* 257:    */   
/* 258:    */   public String getVacu_edad_mes20()
/* 259:    */   {
/* 260:227 */     return this.vacu_edad_mes20;
/* 261:    */   }
/* 262:    */   
/* 263:    */   public String getVacu_edad_mes21()
/* 264:    */   {
/* 265:231 */     return this.vacu_edad_mes21;
/* 266:    */   }
/* 267:    */   
/* 268:    */   public String getVacu_edad_mes22()
/* 269:    */   {
/* 270:235 */     return this.vacu_edad_mes22;
/* 271:    */   }
/* 272:    */   
/* 273:    */   public String getVacu_edad_mes23()
/* 274:    */   {
/* 275:239 */     return this.vacu_edad_mes23;
/* 276:    */   }
/* 277:    */   
/* 278:    */   public String getVacu_edad_mes24()
/* 279:    */   {
/* 280:243 */     return this.vacu_edad_mes24;
/* 281:    */   }
/* 282:    */   
/* 283:    */   public String getVacu_edad_mes3()
/* 284:    */   {
/* 285:247 */     return this.vacu_edad_mes3;
/* 286:    */   }
/* 287:    */   
/* 288:    */   public String getVacu_edad_mes4()
/* 289:    */   {
/* 290:251 */     return this.vacu_edad_mes4;
/* 291:    */   }
/* 292:    */   
/* 293:    */   public String getVacu_edad_mes5()
/* 294:    */   {
/* 295:255 */     return this.vacu_edad_mes5;
/* 296:    */   }
/* 297:    */   
/* 298:    */   public String getVacu_edad_mes6()
/* 299:    */   {
/* 300:259 */     return this.vacu_edad_mes6;
/* 301:    */   }
/* 302:    */   
/* 303:    */   public String getVacu_edad_mes7()
/* 304:    */   {
/* 305:263 */     return this.vacu_edad_mes7;
/* 306:    */   }
/* 307:    */   
/* 308:    */   public String getVacu_edad_mes8()
/* 309:    */   {
/* 310:267 */     return this.vacu_edad_mes8;
/* 311:    */   }
/* 312:    */   
/* 313:    */   public String getVacu_edad_mes9()
/* 314:    */   {
/* 315:271 */     return this.vacu_edad_mes9;
/* 316:    */   }
/* 317:    */   
/* 318:    */   public String getVacu_grup_cod()
/* 319:    */   {
/* 320:275 */     return this.vacu_grup_cod;
/* 321:    */   }
/* 322:    */   
/* 323:    */   public String getVacu_mails_enviados()
/* 324:    */   {
/* 325:279 */     return this.vacu_mails_enviados;
/* 326:    */   }
/* 327:    */   
/* 328:    */   public String getVacu_ultimo_mail()
/* 329:    */   {
/* 330:283 */     return this.vacu_ultimo_mail;
/* 331:    */   }
/* 332:    */   
/* 333:    */   public String getVacu_usuf_cod()
/* 334:    */   {
/* 335:287 */     return this.vacu_usuf_cod;
/* 336:    */   }
/* 337:    */   
/* 338:    */   public String getVacu_vac_cod()
/* 339:    */   {
/* 340:291 */     return this.vacu_vac_cod;
/* 341:    */   }
/* 342:    */   
/* 343:    */   public void setVacu_cod(String string)
/* 344:    */   {
/* 345:295 */     this.vacu_cod = string;
/* 346:    */   }
/* 347:    */   
/* 348:    */   public void setVacu_des(String string)
/* 349:    */   {
/* 350:299 */     this.vacu_des = string;
/* 351:    */   }
/* 352:    */   
/* 353:    */   public void setVacu_edad_anno10(String string)
/* 354:    */   {
/* 355:303 */     this.vacu_edad_anno10 = string;
/* 356:    */   }
/* 357:    */   
/* 358:    */   public void setVacu_edad_anno11(String string)
/* 359:    */   {
/* 360:307 */     this.vacu_edad_anno11 = string;
/* 361:    */   }
/* 362:    */   
/* 363:    */   public void setVacu_edad_anno12(String string)
/* 364:    */   {
/* 365:311 */     this.vacu_edad_anno12 = string;
/* 366:    */   }
/* 367:    */   
/* 368:    */   public void setVacu_edad_anno13(String string)
/* 369:    */   {
/* 370:315 */     this.vacu_edad_anno13 = string;
/* 371:    */   }
/* 372:    */   
/* 373:    */   public void setVacu_edad_anno14(String string)
/* 374:    */   {
/* 375:319 */     this.vacu_edad_anno14 = string;
/* 376:    */   }
/* 377:    */   
/* 378:    */   public void setVacu_edad_anno15(String string)
/* 379:    */   {
/* 380:323 */     this.vacu_edad_anno15 = string;
/* 381:    */   }
/* 382:    */   
/* 383:    */   public void setVacu_edad_anno16(String string)
/* 384:    */   {
/* 385:327 */     this.vacu_edad_anno16 = string;
/* 386:    */   }
/* 387:    */   
/* 388:    */   public void setVacu_edad_anno17(String string)
/* 389:    */   {
/* 390:331 */     this.vacu_edad_anno17 = string;
/* 391:    */   }
/* 392:    */   
/* 393:    */   public void setVacu_edad_anno18(String string)
/* 394:    */   {
/* 395:335 */     this.vacu_edad_anno18 = string;
/* 396:    */   }
/* 397:    */   
/* 398:    */   public void setVacu_edad_anno20(String string)
/* 399:    */   {
/* 400:339 */     this.vacu_edad_anno20 = string;
/* 401:    */   }
/* 402:    */   
/* 403:    */   public void setVacu_edad_anno3(String string)
/* 404:    */   {
/* 405:343 */     this.vacu_edad_anno3 = string;
/* 406:    */   }
/* 407:    */   
/* 408:    */   public void setVacu_edad_anno30(String string)
/* 409:    */   {
/* 410:347 */     this.vacu_edad_anno30 = string;
/* 411:    */   }
/* 412:    */   
/* 413:    */   public void setVacu_edad_anno4(String string)
/* 414:    */   {
/* 415:351 */     this.vacu_edad_anno4 = string;
/* 416:    */   }
/* 417:    */   
/* 418:    */   public void setVacu_edad_anno40(String string)
/* 419:    */   {
/* 420:355 */     this.vacu_edad_anno40 = string;
/* 421:    */   }
/* 422:    */   
/* 423:    */   public void setVacu_edad_anno5(String string)
/* 424:    */   {
/* 425:359 */     this.vacu_edad_anno5 = string;
/* 426:    */   }
/* 427:    */   
/* 428:    */   public void setVacu_edad_anno50(String string)
/* 429:    */   {
/* 430:363 */     this.vacu_edad_anno50 = string;
/* 431:    */   }
/* 432:    */   
/* 433:    */   public void setVacu_edad_anno6(String string)
/* 434:    */   {
/* 435:367 */     this.vacu_edad_anno6 = string;
/* 436:    */   }
/* 437:    */   
/* 438:    */   public void setVacu_edad_anno60(String string)
/* 439:    */   {
/* 440:371 */     this.vacu_edad_anno60 = string;
/* 441:    */   }
/* 442:    */   
/* 443:    */   public void setVacu_edad_anno7(String string)
/* 444:    */   {
/* 445:375 */     this.vacu_edad_anno7 = string;
/* 446:    */   }
/* 447:    */   
/* 448:    */   public void setVacu_edad_anno70(String string)
/* 449:    */   {
/* 450:379 */     this.vacu_edad_anno70 = string;
/* 451:    */   }
/* 452:    */   
/* 453:    */   public void setVacu_edad_anno8(String string)
/* 454:    */   {
/* 455:383 */     this.vacu_edad_anno8 = string;
/* 456:    */   }
/* 457:    */   
/* 458:    */   public void setVacu_edad_anno80(String string)
/* 459:    */   {
/* 460:387 */     this.vacu_edad_anno80 = string;
/* 461:    */   }
/* 462:    */   
/* 463:    */   public void setVacu_edad_anno9(String string)
/* 464:    */   {
/* 465:391 */     this.vacu_edad_anno9 = string;
/* 466:    */   }
/* 467:    */   
/* 468:    */   public void setVacu_edad_anno90(String string)
/* 469:    */   {
/* 470:395 */     this.vacu_edad_anno90 = string;
/* 471:    */   }
/* 472:    */   
/* 473:    */   public void setVacu_edad_mes1(String string)
/* 474:    */   {
/* 475:399 */     this.vacu_edad_mes1 = string;
/* 476:    */   }
/* 477:    */   
/* 478:    */   public void setVacu_edad_mes10(String string)
/* 479:    */   {
/* 480:403 */     this.vacu_edad_mes10 = string;
/* 481:    */   }
/* 482:    */   
/* 483:    */   public void setVacu_edad_mes11(String string)
/* 484:    */   {
/* 485:407 */     this.vacu_edad_mes11 = string;
/* 486:    */   }
/* 487:    */   
/* 488:    */   public void setVacu_edad_mes12(String string)
/* 489:    */   {
/* 490:411 */     this.vacu_edad_mes12 = string;
/* 491:    */   }
/* 492:    */   
/* 493:    */   public void setVacu_edad_mes13(String string)
/* 494:    */   {
/* 495:415 */     this.vacu_edad_mes13 = string;
/* 496:    */   }
/* 497:    */   
/* 498:    */   public void setVacu_edad_mes14(String string)
/* 499:    */   {
/* 500:419 */     this.vacu_edad_mes14 = string;
/* 501:    */   }
/* 502:    */   
/* 503:    */   public void setVacu_edad_mes15(String string)
/* 504:    */   {
/* 505:423 */     this.vacu_edad_mes15 = string;
/* 506:    */   }
/* 507:    */   
/* 508:    */   public void setVacu_edad_mes16(String string)
/* 509:    */   {
/* 510:427 */     this.vacu_edad_mes16 = string;
/* 511:    */   }
/* 512:    */   
/* 513:    */   public void setVacu_edad_mes17(String string)
/* 514:    */   {
/* 515:431 */     this.vacu_edad_mes17 = string;
/* 516:    */   }
/* 517:    */   
/* 518:    */   public void setVacu_edad_mes18(String string)
/* 519:    */   {
/* 520:435 */     this.vacu_edad_mes18 = string;
/* 521:    */   }
/* 522:    */   
/* 523:    */   public void setVacu_edad_mes19(String string)
/* 524:    */   {
/* 525:439 */     this.vacu_edad_mes19 = string;
/* 526:    */   }
/* 527:    */   
/* 528:    */   public void setVacu_edad_mes2(String string)
/* 529:    */   {
/* 530:443 */     this.vacu_edad_mes2 = string;
/* 531:    */   }
/* 532:    */   
/* 533:    */   public void setVacu_edad_mes20(String string)
/* 534:    */   {
/* 535:447 */     this.vacu_edad_mes20 = string;
/* 536:    */   }
/* 537:    */   
/* 538:    */   public void setVacu_edad_mes21(String string)
/* 539:    */   {
/* 540:451 */     this.vacu_edad_mes21 = string;
/* 541:    */   }
/* 542:    */   
/* 543:    */   public void setVacu_edad_mes22(String string)
/* 544:    */   {
/* 545:455 */     this.vacu_edad_mes22 = string;
/* 546:    */   }
/* 547:    */   
/* 548:    */   public void setVacu_edad_mes23(String string)
/* 549:    */   {
/* 550:459 */     this.vacu_edad_mes23 = string;
/* 551:    */   }
/* 552:    */   
/* 553:    */   public void setVacu_edad_mes24(String string)
/* 554:    */   {
/* 555:463 */     this.vacu_edad_mes24 = string;
/* 556:    */   }
/* 557:    */   
/* 558:    */   public void setVacu_edad_mes3(String string)
/* 559:    */   {
/* 560:467 */     this.vacu_edad_mes3 = string;
/* 561:    */   }
/* 562:    */   
/* 563:    */   public void setVacu_edad_mes4(String string)
/* 564:    */   {
/* 565:471 */     this.vacu_edad_mes4 = string;
/* 566:    */   }
/* 567:    */   
/* 568:    */   public void setVacu_edad_mes5(String string)
/* 569:    */   {
/* 570:475 */     this.vacu_edad_mes5 = string;
/* 571:    */   }
/* 572:    */   
/* 573:    */   public void setVacu_edad_mes6(String string)
/* 574:    */   {
/* 575:479 */     this.vacu_edad_mes6 = string;
/* 576:    */   }
/* 577:    */   
/* 578:    */   public void setVacu_edad_mes7(String string)
/* 579:    */   {
/* 580:483 */     this.vacu_edad_mes7 = string;
/* 581:    */   }
/* 582:    */   
/* 583:    */   public void setVacu_edad_mes8(String string)
/* 584:    */   {
/* 585:487 */     this.vacu_edad_mes8 = string;
/* 586:    */   }
/* 587:    */   
/* 588:    */   public void setVacu_edad_mes9(String string)
/* 589:    */   {
/* 590:491 */     this.vacu_edad_mes9 = string;
/* 591:    */   }
/* 592:    */   
/* 593:    */   public void setVacu_grup_cod(String string)
/* 594:    */   {
/* 595:495 */     this.vacu_grup_cod = string;
/* 596:    */   }
/* 597:    */   
/* 598:    */   public void setVacu_mails_enviados(String string)
/* 599:    */   {
/* 600:499 */     this.vacu_mails_enviados = string;
/* 601:    */   }
/* 602:    */   
/* 603:    */   public void setVacu_ultimo_mail(String string)
/* 604:    */   {
/* 605:503 */     this.vacu_ultimo_mail = string;
/* 606:    */   }
/* 607:    */   
/* 608:    */   public void setVacu_usuf_cod(String string)
/* 609:    */   {
/* 610:507 */     this.vacu_usuf_cod = string;
/* 611:    */   }
/* 612:    */   
/* 613:    */   public void setVacu_vac_cod(String string)
/* 614:    */   {
/* 615:511 */     this.vacu_vac_cod = string;
/* 616:    */   }
/* 617:    */   
/* 618:    */   public String getVacu_fecenvio2()
/* 619:    */   {
/* 620:515 */     return this.vacu_fecenvio2;
/* 621:    */   }
/* 622:    */   
/* 623:    */   public void setVacu_fecenvio2(String vacu_fecenvio2)
/* 624:    */   {
/* 625:519 */     this.vacu_fecenvio2 = vacu_fecenvio2;
/* 626:    */   }
/* 627:    */   
/* 628:    */   public String getVacu_fecenvion()
/* 629:    */   {
/* 630:523 */     return this.vacu_fecenvion;
/* 631:    */   }
/* 632:    */   
/* 633:    */   public void setVacu_fecenvion(String vacu_fecenvion)
/* 634:    */   {
/* 635:527 */     this.vacu_fecenvion = vacu_fecenvion;
/* 636:    */   }
/* 637:    */   
/* 638:    */   public String getVacu_fecenvion2()
/* 639:    */   {
/* 640:531 */     return this.vacu_fecenvion2;
/* 641:    */   }
/* 642:    */   
/* 643:    */   public void setVacu_fecenvion2(String vacu_fecenvion2)
/* 644:    */   {
/* 645:535 */     this.vacu_fecenvion2 = vacu_fecenvion2;
/* 646:    */   }
/* 647:    */   
/* 648:    */   public String getVacu_quince_dias()
/* 649:    */   {
/* 650:539 */     return this.vacu_quince_dias;
/* 651:    */   }
/* 652:    */   
/* 653:    */   public void setVacu_quince_dias(String vacu_quince_dias)
/* 654:    */   {
/* 655:543 */     this.vacu_quince_dias = vacu_quince_dias;
/* 656:    */   }
/* 657:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.controller.VacunasUsuarioForm
 * JD-Core Version:    0.7.0.1
 */