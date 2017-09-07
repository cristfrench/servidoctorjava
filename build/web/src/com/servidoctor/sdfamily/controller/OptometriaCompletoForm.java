/*   1:    */ package com.servidoctor.sdfamily.controller;
/*   2:    */ 
/*   3:    */ import org.apache.struts.validator.ValidatorForm;
/*   4:    */ 
/*   5:    */ public class OptometriaCompletoForm
/*   6:    */   extends ValidatorForm
/*   7:    */ {
/*   8: 14 */   private String copt_cod1 = "1";
/*   9: 15 */   private String copt_usuf_cod1 = "0";
/*  10: 16 */   private String copt_feccontrol1 = "";
/*  11: 17 */   private String copt_nommedico1 = "";
/*  12: 18 */   private String copt_telefono1 = "";
/*  13: 19 */   private String copt_email1 = "";
/*  14: 20 */   private String copt_pais_cod1 = "0";
/*  15: 21 */   private String copt_ciudad_cod1 = "0";
/*  16: 22 */   private String copt_horacontrol1 = "0";
/*  17: 23 */   private String copt_apemedico1 = "";
/*  18: 24 */   private String copt_direccion1 = "";
/*  19: 25 */   private String copt_entidad1 = "";
/*  20: 26 */   private String copt_indpais1 = "0";
/*  21: 27 */   private String copt_indciudad1 = "0";
/*  22: 29 */   private String copt_cod2 = "2";
/*  23: 30 */   private String copt_usuf_cod2 = "0";
/*  24: 31 */   private String copt_feccontrol2 = "";
/*  25: 32 */   private String copt_nommedico2 = "";
/*  26: 33 */   private String copt_telefono2 = "";
/*  27: 34 */   private String copt_email2 = "";
/*  28: 35 */   private String copt_pais_cod2 = "0";
/*  29: 36 */   private String copt_ciudad_cod2 = "0";
/*  30: 37 */   private String copt_horacontrol2 = "0";
/*  31: 38 */   private String copt_apemedico2 = "";
/*  32: 39 */   private String copt_direccion2 = "";
/*  33: 40 */   private String copt_entidad2 = "";
/*  34: 41 */   private String copt_indpais2 = "0";
/*  35: 42 */   private String copt_indciudad2 = "0";
/*  36: 43 */   private String copt_fecenvion = "0";
/*  37: 44 */   private String copt_fecenvion2 = "0";
/*  38: 45 */   private String copt_fecenvio2 = "0";
/*  39: 46 */   private String copt_quince_dias = "0";
/*  40: 47 */   private String grupu_dias_antes = "0";
/*  41: 48 */   private String copt_mails_enviados = "0";
/*  42: 49 */   private String copt_ultimo_mail = "0";
/*  43:    */   
/*  44:    */   public String getCopt_apemedico1()
/*  45:    */   {
/*  46: 52 */     return this.copt_apemedico1;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public String getCopt_apemedico2()
/*  50:    */   {
/*  51: 55 */     return this.copt_apemedico2;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public String getCopt_ciudad_cod1()
/*  55:    */   {
/*  56: 58 */     return this.copt_ciudad_cod1;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public String getCopt_ciudad_cod2()
/*  60:    */   {
/*  61: 61 */     return this.copt_ciudad_cod2;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public String getCopt_cod1()
/*  65:    */   {
/*  66: 64 */     return this.copt_cod1;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public String getCopt_cod2()
/*  70:    */   {
/*  71: 67 */     return this.copt_cod2;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public String getCopt_direccion1()
/*  75:    */   {
/*  76: 70 */     return this.copt_direccion1;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public String getCopt_direccion2()
/*  80:    */   {
/*  81: 73 */     return this.copt_direccion2;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public String getCopt_email1()
/*  85:    */   {
/*  86: 76 */     return this.copt_email1;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public String getCopt_email2()
/*  90:    */   {
/*  91: 79 */     return this.copt_email2;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public String getCopt_entidad1()
/*  95:    */   {
/*  96: 82 */     return this.copt_entidad1;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public String getCopt_entidad2()
/* 100:    */   {
/* 101: 85 */     return this.copt_entidad2;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public String getCopt_feccontrol1()
/* 105:    */   {
/* 106: 88 */     return this.copt_feccontrol1;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public String getCopt_feccontrol2()
/* 110:    */   {
/* 111: 91 */     return this.copt_feccontrol2;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public String getCopt_horacontrol1()
/* 115:    */   {
/* 116: 94 */     return this.copt_horacontrol1;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public String getCopt_horacontrol2()
/* 120:    */   {
/* 121: 97 */     return this.copt_horacontrol2;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public String getCopt_indciudad1()
/* 125:    */   {
/* 126:100 */     return this.copt_indciudad1;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public String getCopt_indciudad2()
/* 130:    */   {
/* 131:103 */     return this.copt_indciudad2;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public String getCopt_indpais1()
/* 135:    */   {
/* 136:106 */     return this.copt_indpais1;
/* 137:    */   }
/* 138:    */   
/* 139:    */   public String getCopt_indpais2()
/* 140:    */   {
/* 141:109 */     return this.copt_indpais2;
/* 142:    */   }
/* 143:    */   
/* 144:    */   public String getCopt_mails_enviados()
/* 145:    */   {
/* 146:112 */     return this.copt_mails_enviados;
/* 147:    */   }
/* 148:    */   
/* 149:    */   public String getCopt_nommedico1()
/* 150:    */   {
/* 151:115 */     return this.copt_nommedico1;
/* 152:    */   }
/* 153:    */   
/* 154:    */   public String getCopt_nommedico2()
/* 155:    */   {
/* 156:118 */     return this.copt_nommedico2;
/* 157:    */   }
/* 158:    */   
/* 159:    */   public String getCopt_pais_cod1()
/* 160:    */   {
/* 161:121 */     return this.copt_pais_cod1;
/* 162:    */   }
/* 163:    */   
/* 164:    */   public String getCopt_pais_cod2()
/* 165:    */   {
/* 166:124 */     return this.copt_pais_cod2;
/* 167:    */   }
/* 168:    */   
/* 169:    */   public String getCopt_telefono1()
/* 170:    */   {
/* 171:127 */     return this.copt_telefono1;
/* 172:    */   }
/* 173:    */   
/* 174:    */   public String getCopt_telefono2()
/* 175:    */   {
/* 176:130 */     return this.copt_telefono2;
/* 177:    */   }
/* 178:    */   
/* 179:    */   public String getCopt_ultimo_mail()
/* 180:    */   {
/* 181:133 */     return this.copt_ultimo_mail;
/* 182:    */   }
/* 183:    */   
/* 184:    */   public String getCopt_usuf_cod1()
/* 185:    */   {
/* 186:136 */     return this.copt_usuf_cod1;
/* 187:    */   }
/* 188:    */   
/* 189:    */   public String getCopt_usuf_cod2()
/* 190:    */   {
/* 191:139 */     return this.copt_usuf_cod2;
/* 192:    */   }
/* 193:    */   
/* 194:    */   public String getGrupu_dias_antes()
/* 195:    */   {
/* 196:142 */     return this.grupu_dias_antes;
/* 197:    */   }
/* 198:    */   
/* 199:    */   public void setCopt_apemedico1(String copt_apemedico1)
/* 200:    */   {
/* 201:145 */     this.copt_apemedico1 = copt_apemedico1;
/* 202:    */   }
/* 203:    */   
/* 204:    */   public void setCopt_apemedico2(String copt_apemedico2)
/* 205:    */   {
/* 206:148 */     this.copt_apemedico2 = copt_apemedico2;
/* 207:    */   }
/* 208:    */   
/* 209:    */   public void setCopt_ciudad_cod1(String copt_ciudad_cod1)
/* 210:    */   {
/* 211:151 */     this.copt_ciudad_cod1 = copt_ciudad_cod1;
/* 212:    */   }
/* 213:    */   
/* 214:    */   public void setCopt_ciudad_cod2(String copt_ciudad_cod2)
/* 215:    */   {
/* 216:154 */     this.copt_ciudad_cod2 = copt_ciudad_cod2;
/* 217:    */   }
/* 218:    */   
/* 219:    */   public void setCopt_cod1(String copt_cod1)
/* 220:    */   {
/* 221:157 */     this.copt_cod1 = copt_cod1;
/* 222:    */   }
/* 223:    */   
/* 224:    */   public void setCopt_cod2(String copt_cod2)
/* 225:    */   {
/* 226:160 */     this.copt_cod2 = copt_cod2;
/* 227:    */   }
/* 228:    */   
/* 229:    */   public void setCopt_direccion1(String copt_direccion1)
/* 230:    */   {
/* 231:163 */     this.copt_direccion1 = copt_direccion1;
/* 232:    */   }
/* 233:    */   
/* 234:    */   public void setCopt_direccion2(String copt_direccion2)
/* 235:    */   {
/* 236:166 */     this.copt_direccion2 = copt_direccion2;
/* 237:    */   }
/* 238:    */   
/* 239:    */   public void setCopt_email1(String copt_email1)
/* 240:    */   {
/* 241:169 */     this.copt_email1 = copt_email1;
/* 242:    */   }
/* 243:    */   
/* 244:    */   public void setCopt_email2(String copt_email2)
/* 245:    */   {
/* 246:172 */     this.copt_email2 = copt_email2;
/* 247:    */   }
/* 248:    */   
/* 249:    */   public void setCopt_entidad1(String copt_entidad1)
/* 250:    */   {
/* 251:175 */     this.copt_entidad1 = copt_entidad1;
/* 252:    */   }
/* 253:    */   
/* 254:    */   public void setCopt_entidad2(String copt_entidad2)
/* 255:    */   {
/* 256:178 */     this.copt_entidad2 = copt_entidad2;
/* 257:    */   }
/* 258:    */   
/* 259:    */   public void setCopt_feccontrol1(String copt_feccontrol1)
/* 260:    */   {
/* 261:181 */     this.copt_feccontrol1 = copt_feccontrol1;
/* 262:    */   }
/* 263:    */   
/* 264:    */   public void setCopt_feccontrol2(String copt_feccontrol2)
/* 265:    */   {
/* 266:184 */     this.copt_feccontrol2 = copt_feccontrol2;
/* 267:    */   }
/* 268:    */   
/* 269:    */   public void setCopt_horacontrol1(String copt_horacontrol1)
/* 270:    */   {
/* 271:187 */     this.copt_horacontrol1 = copt_horacontrol1;
/* 272:    */   }
/* 273:    */   
/* 274:    */   public void setCopt_horacontrol2(String copt_horacontrol2)
/* 275:    */   {
/* 276:190 */     this.copt_horacontrol2 = copt_horacontrol2;
/* 277:    */   }
/* 278:    */   
/* 279:    */   public void setCopt_indciudad1(String copt_indciudad1)
/* 280:    */   {
/* 281:193 */     this.copt_indciudad1 = copt_indciudad1;
/* 282:    */   }
/* 283:    */   
/* 284:    */   public void setCopt_indciudad2(String copt_indciudad2)
/* 285:    */   {
/* 286:196 */     this.copt_indciudad2 = copt_indciudad2;
/* 287:    */   }
/* 288:    */   
/* 289:    */   public void setCopt_indpais1(String copt_indpais1)
/* 290:    */   {
/* 291:199 */     this.copt_indpais1 = copt_indpais1;
/* 292:    */   }
/* 293:    */   
/* 294:    */   public void setCopt_indpais2(String copt_indpais2)
/* 295:    */   {
/* 296:202 */     this.copt_indpais2 = copt_indpais2;
/* 297:    */   }
/* 298:    */   
/* 299:    */   public void setCopt_mails_enviados(String copt_mails_enviados)
/* 300:    */   {
/* 301:205 */     this.copt_mails_enviados = copt_mails_enviados;
/* 302:    */   }
/* 303:    */   
/* 304:    */   public void setCopt_nommedico1(String copt_nommedico1)
/* 305:    */   {
/* 306:208 */     this.copt_nommedico1 = copt_nommedico1;
/* 307:    */   }
/* 308:    */   
/* 309:    */   public void setCopt_nommedico2(String copt_nommedico2)
/* 310:    */   {
/* 311:211 */     this.copt_nommedico2 = copt_nommedico2;
/* 312:    */   }
/* 313:    */   
/* 314:    */   public void setCopt_pais_cod1(String copt_pais_cod1)
/* 315:    */   {
/* 316:214 */     this.copt_pais_cod1 = copt_pais_cod1;
/* 317:    */   }
/* 318:    */   
/* 319:    */   public void setCopt_pais_cod2(String copt_pais_cod2)
/* 320:    */   {
/* 321:217 */     this.copt_pais_cod2 = copt_pais_cod2;
/* 322:    */   }
/* 323:    */   
/* 324:    */   public void setCopt_telefono1(String copt_telefono1)
/* 325:    */   {
/* 326:220 */     this.copt_telefono1 = copt_telefono1;
/* 327:    */   }
/* 328:    */   
/* 329:    */   public void setCopt_telefono2(String copt_telefono2)
/* 330:    */   {
/* 331:223 */     this.copt_telefono2 = copt_telefono2;
/* 332:    */   }
/* 333:    */   
/* 334:    */   public void setCopt_ultimo_mail(String copt_ultimo_mail)
/* 335:    */   {
/* 336:226 */     this.copt_ultimo_mail = copt_ultimo_mail;
/* 337:    */   }
/* 338:    */   
/* 339:    */   public void setCopt_usuf_cod1(String copt_usuf_cod1)
/* 340:    */   {
/* 341:229 */     this.copt_usuf_cod1 = copt_usuf_cod1;
/* 342:    */   }
/* 343:    */   
/* 344:    */   public void setCopt_usuf_cod2(String copt_usuf_cod2)
/* 345:    */   {
/* 346:232 */     this.copt_usuf_cod2 = copt_usuf_cod2;
/* 347:    */   }
/* 348:    */   
/* 349:    */   public void setGrupu_dias_antes(String grupu_dias_antes)
/* 350:    */   {
/* 351:235 */     this.grupu_dias_antes = grupu_dias_antes;
/* 352:    */   }
/* 353:    */   
/* 354:    */   public String getCopt_fecenvio2()
/* 355:    */   {
/* 356:238 */     return this.copt_fecenvio2;
/* 357:    */   }
/* 358:    */   
/* 359:    */   public void setCopt_fecenvio2(String copt_fecenvio2)
/* 360:    */   {
/* 361:241 */     this.copt_fecenvio2 = copt_fecenvio2;
/* 362:    */   }
/* 363:    */   
/* 364:    */   public String getCopt_fecenvion()
/* 365:    */   {
/* 366:244 */     return this.copt_fecenvion;
/* 367:    */   }
/* 368:    */   
/* 369:    */   public void setCopt_fecenvion(String copt_fecenvion)
/* 370:    */   {
/* 371:247 */     this.copt_fecenvion = copt_fecenvion;
/* 372:    */   }
/* 373:    */   
/* 374:    */   public String getCopt_fecenvion2()
/* 375:    */   {
/* 376:250 */     return this.copt_fecenvion2;
/* 377:    */   }
/* 378:    */   
/* 379:    */   public void setCopt_fecenvion2(String copt_fecenvion2)
/* 380:    */   {
/* 381:253 */     this.copt_fecenvion2 = copt_fecenvion2;
/* 382:    */   }
/* 383:    */   
/* 384:    */   public String getCopt_quince_dias()
/* 385:    */   {
/* 386:256 */     return this.copt_quince_dias;
/* 387:    */   }
/* 388:    */   
/* 389:    */   public void setCopt_quince_dias(String copt_quince_dias)
/* 390:    */   {
/* 391:259 */     this.copt_quince_dias = copt_quince_dias;
/* 392:    */   }
/* 393:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.controller.OptometriaCompletoForm
 * JD-Core Version:    0.7.0.1
 */