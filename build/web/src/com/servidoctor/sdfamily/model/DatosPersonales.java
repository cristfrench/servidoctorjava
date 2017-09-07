/*   1:    */ package com.servidoctor.sdfamily.model;
/*   2:    */ 
/*   3:    */ import java.math.BigDecimal;
/*   4:    */ 
/*   5:    */ public class DatosPersonales
/*   6:    */ {
/*   7:    */   private BigDecimal datp_usuf_cod;
/*   8:    */   private String datp_id_doc;
/*   9:    */   private BigDecimal datp_id_tipo;
/*  10:    */   private String datp_nombre;
/*  11:    */   private String datp_apellido;
/*  12:    */   private BigDecimal datp_pais_cod;
/*  13:    */   private BigDecimal datp_ciu_cod;
/*  14:    */   private BigDecimal datp_idioma;
/*  15:    */   private BigDecimal datp_fecnacim;
/*  16:    */   private BigDecimal datp_tipsan_cod;
/*  17:    */   private String datp_sexo;
/*  18:    */   private BigDecimal datp_indpais1;
/*  19:    */   private BigDecimal datp_indciudad1;
/*  20:    */   private String datp_telefono1;
/*  21:    */   private BigDecimal datp_indpais2;
/*  22:    */   private String datp_telefono2;
/*  23:    */   private String datp_mail;
/*  24:    */   private BigDecimal datp_fecinscripcion;
/*  25:    */   private BigDecimal datp_estado;
/*  26:    */   private BigDecimal datp_hijos;
/*  27:    */   private BigDecimal datp_escolaridad;
/*  28:    */   private BigDecimal datp_perro;
/*  29:    */   private BigDecimal datp_gato;
/*  30:    */   private BigDecimal datp_carro;
/*  31:    */   private BigDecimal datp_med_fecha1;
/*  32:    */   private BigDecimal datp_med_est1;
/*  33:    */   private BigDecimal datp_med_est1b;
/*  34:    */   private BigDecimal datp_med_peso1;
/*  35:    */   private BigDecimal datp_med_fecha2;
/*  36:    */   private BigDecimal datp_med_est2;
/*  37:    */   private BigDecimal datp_med_est2b;
/*  38:    */   private BigDecimal datp_med_peso2;
/*  39:    */   private BigDecimal datp_med_fecha3;
/*  40:    */   private BigDecimal datp_med_est3;
/*  41:    */   private BigDecimal datp_med_est3b;
/*  42:    */   private BigDecimal datp_med_peso3;
/*  43:    */   private BigDecimal datp_num_dias_no_mail;
/*  44:    */   
/*  45:    */   public String getDatp_apellido()
/*  46:    */   {
/*  47: 62 */     return this.datp_apellido;
/*  48:    */   }
/*  49:    */   
/*  50:    */   public BigDecimal getDatp_carro()
/*  51:    */   {
/*  52: 66 */     return this.datp_carro;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public BigDecimal getDatp_ciu_cod()
/*  56:    */   {
/*  57: 70 */     return this.datp_ciu_cod;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public BigDecimal getDatp_escolaridad()
/*  61:    */   {
/*  62: 74 */     return this.datp_escolaridad;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public BigDecimal getDatp_estado()
/*  66:    */   {
/*  67: 78 */     return this.datp_estado;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public BigDecimal getDatp_fecinscripcion()
/*  71:    */   {
/*  72: 82 */     return this.datp_fecinscripcion;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public BigDecimal getDatp_fecnacim()
/*  76:    */   {
/*  77: 86 */     return this.datp_fecnacim;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public BigDecimal getDatp_gato()
/*  81:    */   {
/*  82: 90 */     return this.datp_gato;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public BigDecimal getDatp_hijos()
/*  86:    */   {
/*  87: 94 */     return this.datp_hijos;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public String getDatp_id_doc()
/*  91:    */   {
/*  92: 98 */     return this.datp_id_doc;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public BigDecimal getDatp_id_tipo()
/*  96:    */   {
/*  97:102 */     return this.datp_id_tipo;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public BigDecimal getDatp_idioma()
/* 101:    */   {
/* 102:106 */     return this.datp_idioma;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public BigDecimal getDatp_indciudad1()
/* 106:    */   {
/* 107:110 */     return this.datp_indciudad1;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public BigDecimal getDatp_indpais1()
/* 111:    */   {
/* 112:114 */     return this.datp_indpais1;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public BigDecimal getDatp_indpais2()
/* 116:    */   {
/* 117:118 */     return this.datp_indpais2;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public String getDatp_mail()
/* 121:    */   {
/* 122:122 */     return this.datp_mail;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public BigDecimal getDatp_med_est1()
/* 126:    */   {
/* 127:126 */     return this.datp_med_est1;
/* 128:    */   }
/* 129:    */   
/* 130:    */   public BigDecimal getDatp_med_est1b()
/* 131:    */   {
/* 132:130 */     return this.datp_med_est1b;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public BigDecimal getDatp_med_est2()
/* 136:    */   {
/* 137:134 */     return this.datp_med_est2;
/* 138:    */   }
/* 139:    */   
/* 140:    */   public BigDecimal getDatp_med_est2b()
/* 141:    */   {
/* 142:138 */     return this.datp_med_est2b;
/* 143:    */   }
/* 144:    */   
/* 145:    */   public BigDecimal getDatp_med_est3()
/* 146:    */   {
/* 147:142 */     return this.datp_med_est3;
/* 148:    */   }
/* 149:    */   
/* 150:    */   public BigDecimal getDatp_med_est3b()
/* 151:    */   {
/* 152:146 */     return this.datp_med_est3b;
/* 153:    */   }
/* 154:    */   
/* 155:    */   public BigDecimal getDatp_med_fecha1()
/* 156:    */   {
/* 157:150 */     return this.datp_med_fecha1;
/* 158:    */   }
/* 159:    */   
/* 160:    */   public BigDecimal getDatp_med_fecha2()
/* 161:    */   {
/* 162:154 */     return this.datp_med_fecha2;
/* 163:    */   }
/* 164:    */   
/* 165:    */   public BigDecimal getDatp_med_fecha3()
/* 166:    */   {
/* 167:158 */     return this.datp_med_fecha3;
/* 168:    */   }
/* 169:    */   
/* 170:    */   public BigDecimal getDatp_med_peso1()
/* 171:    */   {
/* 172:162 */     return this.datp_med_peso1;
/* 173:    */   }
/* 174:    */   
/* 175:    */   public BigDecimal getDatp_med_peso2()
/* 176:    */   {
/* 177:166 */     return this.datp_med_peso2;
/* 178:    */   }
/* 179:    */   
/* 180:    */   public BigDecimal getDatp_med_peso3()
/* 181:    */   {
/* 182:170 */     return this.datp_med_peso3;
/* 183:    */   }
/* 184:    */   
/* 185:    */   public String getDatp_nombre()
/* 186:    */   {
/* 187:174 */     return this.datp_nombre;
/* 188:    */   }
/* 189:    */   
/* 190:    */   public BigDecimal getDatp_num_dias_no_mail()
/* 191:    */   {
/* 192:178 */     return this.datp_num_dias_no_mail;
/* 193:    */   }
/* 194:    */   
/* 195:    */   public BigDecimal getDatp_pais_cod()
/* 196:    */   {
/* 197:182 */     return this.datp_pais_cod;
/* 198:    */   }
/* 199:    */   
/* 200:    */   public BigDecimal getDatp_perro()
/* 201:    */   {
/* 202:186 */     return this.datp_perro;
/* 203:    */   }
/* 204:    */   
/* 205:    */   public String getDatp_sexo()
/* 206:    */   {
/* 207:190 */     return this.datp_sexo;
/* 208:    */   }
/* 209:    */   
/* 210:    */   public String getDatp_telefono1()
/* 211:    */   {
/* 212:194 */     return this.datp_telefono1;
/* 213:    */   }
/* 214:    */   
/* 215:    */   public String getDatp_telefono2()
/* 216:    */   {
/* 217:198 */     return this.datp_telefono2;
/* 218:    */   }
/* 219:    */   
/* 220:    */   public BigDecimal getDatp_tipsan_cod()
/* 221:    */   {
/* 222:202 */     return this.datp_tipsan_cod;
/* 223:    */   }
/* 224:    */   
/* 225:    */   public BigDecimal getDatp_usuf_cod()
/* 226:    */   {
/* 227:206 */     return this.datp_usuf_cod;
/* 228:    */   }
/* 229:    */   
/* 230:    */   public void setDatp_apellido(String datp_apellido)
/* 231:    */   {
/* 232:210 */     this.datp_apellido = datp_apellido;
/* 233:    */   }
/* 234:    */   
/* 235:    */   public void setDatp_carro(BigDecimal datp_carro)
/* 236:    */   {
/* 237:214 */     this.datp_carro = datp_carro;
/* 238:    */   }
/* 239:    */   
/* 240:    */   public void setDatp_ciu_cod(BigDecimal datp_ciu_cod)
/* 241:    */   {
/* 242:218 */     this.datp_ciu_cod = datp_ciu_cod;
/* 243:    */   }
/* 244:    */   
/* 245:    */   public void setDatp_escolaridad(BigDecimal datp_escolaridad)
/* 246:    */   {
/* 247:222 */     this.datp_escolaridad = datp_escolaridad;
/* 248:    */   }
/* 249:    */   
/* 250:    */   public void setDatp_estado(BigDecimal datp_estado)
/* 251:    */   {
/* 252:226 */     this.datp_estado = datp_estado;
/* 253:    */   }
/* 254:    */   
/* 255:    */   public void setDatp_fecinscripcion(BigDecimal datp_fecinscripcion)
/* 256:    */   {
/* 257:230 */     this.datp_fecinscripcion = datp_fecinscripcion;
/* 258:    */   }
/* 259:    */   
/* 260:    */   public void setDatp_fecnacim(BigDecimal datp_fecnacim)
/* 261:    */   {
/* 262:234 */     this.datp_fecnacim = datp_fecnacim;
/* 263:    */   }
/* 264:    */   
/* 265:    */   public void setDatp_gato(BigDecimal datp_gato)
/* 266:    */   {
/* 267:238 */     this.datp_gato = datp_gato;
/* 268:    */   }
/* 269:    */   
/* 270:    */   public void setDatp_hijos(BigDecimal datp_hijos)
/* 271:    */   {
/* 272:242 */     this.datp_hijos = datp_hijos;
/* 273:    */   }
/* 274:    */   
/* 275:    */   public void setDatp_id_doc(String datp_id_doc)
/* 276:    */   {
/* 277:246 */     this.datp_id_doc = datp_id_doc;
/* 278:    */   }
/* 279:    */   
/* 280:    */   public void setDatp_id_tipo(BigDecimal datp_id_tipo)
/* 281:    */   {
/* 282:250 */     this.datp_id_tipo = datp_id_tipo;
/* 283:    */   }
/* 284:    */   
/* 285:    */   public void setDatp_idioma(BigDecimal datp_idioma)
/* 286:    */   {
/* 287:254 */     this.datp_idioma = datp_idioma;
/* 288:    */   }
/* 289:    */   
/* 290:    */   public void setDatp_indciudad1(BigDecimal datp_indciudad1)
/* 291:    */   {
/* 292:258 */     this.datp_indciudad1 = datp_indciudad1;
/* 293:    */   }
/* 294:    */   
/* 295:    */   public void setDatp_indpais1(BigDecimal datp_indpais1)
/* 296:    */   {
/* 297:262 */     this.datp_indpais1 = datp_indpais1;
/* 298:    */   }
/* 299:    */   
/* 300:    */   public void setDatp_indpais2(BigDecimal datp_indpais2)
/* 301:    */   {
/* 302:266 */     this.datp_indpais2 = datp_indpais2;
/* 303:    */   }
/* 304:    */   
/* 305:    */   public void setDatp_mail(String datp_mail)
/* 306:    */   {
/* 307:270 */     this.datp_mail = datp_mail;
/* 308:    */   }
/* 309:    */   
/* 310:    */   public void setDatp_med_est1(BigDecimal datp_med_est1)
/* 311:    */   {
/* 312:274 */     this.datp_med_est1 = datp_med_est1;
/* 313:    */   }
/* 314:    */   
/* 315:    */   public void setDatp_med_est1b(BigDecimal datp_med_est1b)
/* 316:    */   {
/* 317:278 */     this.datp_med_est1b = datp_med_est1b;
/* 318:    */   }
/* 319:    */   
/* 320:    */   public void setDatp_med_est2(BigDecimal datp_med_est2)
/* 321:    */   {
/* 322:282 */     this.datp_med_est2 = datp_med_est2;
/* 323:    */   }
/* 324:    */   
/* 325:    */   public void setDatp_med_est2b(BigDecimal datp_med_est2b)
/* 326:    */   {
/* 327:286 */     this.datp_med_est2b = datp_med_est2b;
/* 328:    */   }
/* 329:    */   
/* 330:    */   public void setDatp_med_est3(BigDecimal datp_med_est3)
/* 331:    */   {
/* 332:290 */     this.datp_med_est3 = datp_med_est3;
/* 333:    */   }
/* 334:    */   
/* 335:    */   public void setDatp_med_est3b(BigDecimal datp_med_est3b)
/* 336:    */   {
/* 337:294 */     this.datp_med_est3b = datp_med_est3b;
/* 338:    */   }
/* 339:    */   
/* 340:    */   public void setDatp_med_fecha1(BigDecimal datp_med_fecha1)
/* 341:    */   {
/* 342:298 */     this.datp_med_fecha1 = datp_med_fecha1;
/* 343:    */   }
/* 344:    */   
/* 345:    */   public void setDatp_med_fecha2(BigDecimal datp_med_fecha2)
/* 346:    */   {
/* 347:302 */     this.datp_med_fecha2 = datp_med_fecha2;
/* 348:    */   }
/* 349:    */   
/* 350:    */   public void setDatp_med_fecha3(BigDecimal datp_med_fecha3)
/* 351:    */   {
/* 352:306 */     this.datp_med_fecha3 = datp_med_fecha3;
/* 353:    */   }
/* 354:    */   
/* 355:    */   public void setDatp_med_peso1(BigDecimal datp_med_peso1)
/* 356:    */   {
/* 357:310 */     this.datp_med_peso1 = datp_med_peso1;
/* 358:    */   }
/* 359:    */   
/* 360:    */   public void setDatp_med_peso2(BigDecimal datp_med_peso2)
/* 361:    */   {
/* 362:314 */     this.datp_med_peso2 = datp_med_peso2;
/* 363:    */   }
/* 364:    */   
/* 365:    */   public void setDatp_med_peso3(BigDecimal datp_med_peso3)
/* 366:    */   {
/* 367:318 */     this.datp_med_peso3 = datp_med_peso3;
/* 368:    */   }
/* 369:    */   
/* 370:    */   public void setDatp_nombre(String datp_nombre)
/* 371:    */   {
/* 372:322 */     this.datp_nombre = datp_nombre;
/* 373:    */   }
/* 374:    */   
/* 375:    */   public void setDatp_num_dias_no_mail(BigDecimal datp_num_dias_no_mail)
/* 376:    */   {
/* 377:326 */     this.datp_num_dias_no_mail = datp_num_dias_no_mail;
/* 378:    */   }
/* 379:    */   
/* 380:    */   public void setDatp_pais_cod(BigDecimal datp_pais_cod)
/* 381:    */   {
/* 382:330 */     this.datp_pais_cod = datp_pais_cod;
/* 383:    */   }
/* 384:    */   
/* 385:    */   public void setDatp_perro(BigDecimal datp_perro)
/* 386:    */   {
/* 387:334 */     this.datp_perro = datp_perro;
/* 388:    */   }
/* 389:    */   
/* 390:    */   public void setDatp_sexo(String datp_sexo)
/* 391:    */   {
/* 392:338 */     this.datp_sexo = datp_sexo;
/* 393:    */   }
/* 394:    */   
/* 395:    */   public void setDatp_telefono1(String datp_telefono1)
/* 396:    */   {
/* 397:342 */     this.datp_telefono1 = datp_telefono1;
/* 398:    */   }
/* 399:    */   
/* 400:    */   public void setDatp_telefono2(String datp_telefono2)
/* 401:    */   {
/* 402:346 */     this.datp_telefono2 = datp_telefono2;
/* 403:    */   }
/* 404:    */   
/* 405:    */   public void setDatp_tipsan_cod(BigDecimal datp_tipsan_cod)
/* 406:    */   {
/* 407:350 */     this.datp_tipsan_cod = datp_tipsan_cod;
/* 408:    */   }
/* 409:    */   
/* 410:    */   public void setDatp_usuf_cod(BigDecimal datp_usuf_cod)
/* 411:    */   {
/* 412:354 */     this.datp_usuf_cod = datp_usuf_cod;
/* 413:    */   }
/* 414:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.model.DatosPersonales
 * JD-Core Version:    0.7.0.1
 */