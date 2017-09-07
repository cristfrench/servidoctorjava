/*   1:    */ package com.servidoctor.sdpets.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.constantes.IConstantes;
/*   4:    */ import com.servidoctor.parametros.dao.CiudadDAO;
/*   5:    */ import com.servidoctor.parametros.dao.PaisDAO;
/*   6:    */ import com.servidoctor.parametros.dao.RazasDAO;
/*   7:    */ import com.servidoctor.parametros.dao.VacunasCuidadosDAO;
/*   8:    */ import com.servidoctor.parametros.model.Ciudades;
/*   9:    */ import com.servidoctor.parametros.model.Paises;
/*  10:    */ import com.servidoctor.parametros.model.Razas;
/*  11:    */ import com.servidoctor.parametros.model.VacunasCuidados;
/*  12:    */ import com.servidoctor.sdpets.model.ContactosMascota;
/*  13:    */ import com.servidoctor.sdpets.model.Mascota;
/*  14:    */ import com.servidoctor.sdpets.model.MascotaAlimentacion;
/*  15:    */ import com.servidoctor.sdpets.model.MascotaMedicamentos;
/*  16:    */ import com.servidoctor.seguridad.model.UsuarioPets;
/*  17:    */ import com.servidoctor.util.classes.ManejoFechas;
/*  18:    */ import java.io.OutputStream;
/*  19:    */ import java.math.BigDecimal;
/*  20:    */ import java.util.Iterator;
/*  21:    */ import java.util.List;
/*  22:    */ import java.util.ResourceBundle;
/*  23:    */ import org.apache.poi.hssf.usermodel.HSSFCell;
/*  24:    */ import org.apache.poi.hssf.usermodel.HSSFCellStyle;
/*  25:    */ import org.apache.poi.hssf.usermodel.HSSFFont;
/*  26:    */ import org.apache.poi.hssf.usermodel.HSSFRow;
/*  27:    */ import org.apache.poi.hssf.usermodel.HSSFSheet;
/*  28:    */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*  29:    */ 
/*  30:    */ public class GestorHojasCalculoPets
/*  31:    */ {
/*  32: 44 */   private static HSSFWorkbook wb = new HSSFWorkbook();
/*  33: 45 */   private static UsuarioPets usuarioPets = null;
/*  34: 46 */   private static ResourceBundle RES = null;
/*  35: 47 */   private static OutputStream out = null;
/*  36:    */   
/*  37:    */   public static void generarArchivo()
/*  38:    */     throws Exception
/*  39:    */   {
/*  40:    */     try
/*  41:    */     {
/*  42: 51 */       wb = new HSSFWorkbook();
/*  43:    */     }
/*  44:    */     catch (Exception e)
/*  45:    */     {
/*  46: 53 */       throw e;
/*  47:    */     }
/*  48:    */   }
/*  49:    */   
/*  50:    */   public static void generarHoja(String nombreHoja, UsuarioPets user, ResourceBundle res)
/*  51:    */     throws Exception
/*  52:    */   {
/*  53:    */     try
/*  54:    */     {
/*  55: 66 */       usuarioPets = user;
/*  56: 67 */       RES = res;
/*  57: 68 */       HSSFSheet sheet = wb.createSheet(nombreHoja);
/*  58:    */       
/*  59: 70 */       sheet.setColumnWidth((short)0, (short)6000);
/*  60: 71 */       sheet.setColumnWidth((short)1, (short)6000);
/*  61: 72 */       sheet.setColumnWidth((short)2, (short)6000);
/*  62: 73 */       sheet.setColumnWidth((short)3, (short)6000);
/*  63: 74 */       sheet.setColumnWidth((short)4, (short)6000);
/*  64: 75 */       sheet.setColumnWidth((short)5, (short)6000);
/*  65: 76 */       sheet.setColumnWidth((short)6, (short)6000);
/*  66: 77 */       sheet.setColumnWidth((short)7, (short)6000);
/*  67: 78 */       sheet.setColumnWidth((short)8, (short)6000);
/*  68: 79 */       sheet.setColumnWidth((short)9, (short)6000);
/*  69: 80 */       sheet.setColumnWidth((short)10, (short)6000);
/*  70: 81 */       sheet.setColumnWidth((short)11, (short)6000);
/*  71: 82 */       sheet.setColumnWidth((short)12, (short)6000);
/*  72: 83 */       sheet.setColumnWidth((short)13, (short)6000);
/*  73: 84 */       sheet.setColumnWidth((short)14, (short)6000);
/*  74:    */     }
/*  75:    */     catch (Exception e)
/*  76:    */     {
/*  77: 87 */       throw e;
/*  78:    */     }
/*  79:    */   }
/*  80:    */   
/*  81:    */   public static void generarDatosInfobasica(String nombreHoja, String idioma, int servidor)
/*  82:    */     throws Exception
/*  83:    */   {
/*  84:    */     try
/*  85:    */     {
/*  86: 99 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/*  87:100 */       HSSFFont boldFont = wb.createFont();
/*  88:101 */       boldFont.setBoldweight((short)700);
/*  89:102 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/*  90:103 */       boldStyle.setFont(boldFont);
/*  91:    */       
/*  92:105 */       MascotaDAO mascotaDAO = new MascotaDAO();
/*  93:106 */       mascotaDAO.setServerNumber(servidor);
/*  94:107 */       List mascotas = mascotaDAO.list(usuarioPets.getUsup_cod());
/*  95:    */       
/*  96:109 */       HSSFRow row = null;
/*  97:110 */       HSSFCell cell = null;
/*  98:    */       
/*  99:112 */       int y = 0;
/* 100:113 */       int x = 0;
/* 101:    */       
/* 102:115 */       row = sheet.createRow(x);
/* 103:    */       
/* 104:117 */       cell = row.createCell((short)y++);
/* 105:118 */       cell.setCellValue(RES.getString("xls.mas_cod"));
/* 106:119 */       cell.setCellStyle(boldStyle);
/* 107:    */       
/* 108:121 */       cell = row.createCell((short)y++);
/* 109:122 */       cell.setCellValue(RES.getString("xls.mas_nombre"));
/* 110:123 */       cell.setCellStyle(boldStyle);
/* 111:    */       
/* 112:125 */       cell = row.createCell((short)y++);
/* 113:126 */       cell.setCellValue(RES.getString("xls.mas_fecnac"));
/* 114:127 */       cell.setCellStyle(boldStyle);
/* 115:    */       
/* 116:129 */       cell = row.createCell((short)y++);
/* 117:130 */       cell.setCellValue(RES.getString("xls.mas_tipo"));
/* 118:131 */       cell.setCellStyle(boldStyle);
/* 119:    */       
/* 120:133 */       cell = row.createCell((short)y++);
/* 121:134 */       cell.setCellValue(RES.getString("xls.mas_raz_cod"));
/* 122:135 */       cell.setCellStyle(boldStyle);
/* 123:    */       
/* 124:137 */       cell = row.createCell((short)y++);
/* 125:138 */       cell.setCellValue(RES.getString("xls.mas_sexo"));
/* 126:139 */       cell.setCellStyle(boldStyle);
/* 127:    */       
/* 128:141 */       cell = row.createCell((short)y++);
/* 129:142 */       cell.setCellValue(RES.getString("xls.mas_rechec"));
/* 130:143 */       cell.setCellStyle(boldStyle);
/* 131:    */       
/* 132:145 */       x++;
/* 133:146 */       y = 0;
/* 134:    */       
/* 135:148 */       Iterator it = mascotas.iterator();
/* 136:    */       do
/* 137:    */       {
/* 138:150 */         Mascota mascota = (Mascota)it.next();
/* 139:    */         
/* 140:152 */         RazasDAO razasDAO = new RazasDAO();
/* 141:153 */         razasDAO.setServerNumber(servidor);
/* 142:154 */         razasDAO.setIdioma(idioma);
/* 143:155 */         Razas razas = razasDAO.retrive(mascota.getMas_raz_cod());
/* 144:    */         
/* 145:157 */         row = sheet.createRow(x++);
/* 146:    */         
/* 147:159 */         cell = row.createCell((short)y++);
/* 148:160 */         cell.setCellValue(mascota.getMas_cod().doubleValue());
/* 149:    */         
/* 150:162 */         cell = row.createCell((short)y++);
/* 151:163 */         cell.setCellValue(mascota.getMas_nombre());
/* 152:    */         
/* 153:165 */         cell = row.createCell((short)y++);
/* 154:166 */         cell.setCellValue(ManejoFechas.FormateoFecha(mascota.getMas_fecnac().toString()));
/* 155:    */         
/* 156:168 */         cell = row.createCell((short)y++);
/* 157:169 */         cell.setCellValue(mascota.getMas_tipo().equalsIgnoreCase("0") ? RES.getString("1005") : RES.getString("1006"));
/* 158:    */         
/* 159:171 */         cell = row.createCell((short)y++);
/* 160:172 */         cell.setCellValue(razas.getRaz_des());
/* 161:    */         
/* 162:174 */         cell = row.createCell((short)y++);
/* 163:175 */         cell.setCellValue(mascota.getMas_sexo().equals("M") ? RES.getString("1007") : RES.getString("1008"));
/* 164:    */         
/* 165:177 */         cell = row.createCell((short)y++);
/* 166:178 */         cell.setCellValue(mascota.getMas_rechec().doubleValue());
/* 167:    */         
/* 168:180 */         y = 0;
/* 169:149 */         if (it == null) {
/* 170:    */           break;
/* 171:    */         }
/* 172:149 */       } while (it.hasNext());
/* 173:    */     }
/* 174:    */     catch (Exception e)
/* 175:    */     {
/* 176:184 */       throw e;
/* 177:    */     }
/* 178:    */   }
/* 179:    */   
/* 180:    */   public static void generarDatosContalipes(String nombreHoja, int servidor)
/* 181:    */     throws Exception
/* 182:    */   {
/* 183:    */     try
/* 184:    */     {
/* 185:196 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/* 186:197 */       HSSFFont boldFont = wb.createFont();
/* 187:198 */       boldFont.setBoldweight((short)700);
/* 188:199 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/* 189:200 */       boldStyle.setFont(boldFont);
/* 190:    */       
/* 191:202 */       MascotaAlimentacionDAO mascotaAlimentacionDAO = new MascotaAlimentacionDAO();
/* 192:203 */       mascotaAlimentacionDAO.setServerNumber(servidor);
/* 193:204 */       MascotaDAO mascotaDAO = new MascotaDAO();
/* 194:205 */       mascotaDAO.setServerNumber(servidor);
/* 195:206 */       List mascotas = mascotaDAO.list(usuarioPets.getUsup_cod());
/* 196:207 */       List mascotaAlimentacions = null;
/* 197:    */       
/* 198:209 */       HSSFRow row = null;
/* 199:210 */       HSSFCell cell = null;
/* 200:    */       
/* 201:212 */       int x = 0;
/* 202:213 */       int y = 0;
/* 203:    */       
/* 204:215 */       Iterator it = mascotas.iterator();
/* 205:    */       Iterator iter;
/* 206:216 */       for (; it.hasNext(); (iter != null) && (iter.hasNext()))
/* 207:    */       {
/* 208:217 */         Mascota mascota = (Mascota)it.next();
/* 209:218 */         mascotaAlimentacions = mascotaAlimentacionDAO.list(mascota.getMas_cod());
/* 210:219 */         iter = mascotaAlimentacions.iterator();
/* 211:    */         
/* 212:221 */         row = sheet.createRow(x++);
/* 213:222 */         cell = row.createCell((short)y++);
/* 214:223 */         cell.setCellValue(mascota.getMas_nombre());
/* 215:224 */         cell.setCellStyle(boldStyle);
/* 216:    */         
/* 217:226 */         y = 0;
/* 218:227 */         x++;
/* 219:228 */         row = sheet.createRow(x++);
/* 220:    */         
/* 221:230 */         cell = row.createCell((short)y++);
/* 222:231 */         cell.setCellValue(RES.getString("xls.mali_cod"));
/* 223:232 */         cell.setCellStyle(boldStyle);
/* 224:    */         
/* 225:234 */         cell = row.createCell((short)y++);
/* 226:235 */         cell.setCellValue(RES.getString("xls.mali_mas_cod"));
/* 227:236 */         cell.setCellStyle(boldStyle);
/* 228:    */         
/* 229:238 */         cell = row.createCell((short)y++);
/* 230:239 */         cell.setCellValue(RES.getString("xls.mali_fecultpeso"));
/* 231:240 */         cell.setCellStyle(boldStyle);
/* 232:    */         
/* 233:242 */         cell = row.createCell((short)y++);
/* 234:243 */         cell.setCellValue(RES.getString("xls.mali_kilosultpeso"));
/* 235:244 */         cell.setCellStyle(boldStyle);
/* 236:    */         
/* 237:246 */         cell = row.createCell((short)y++);
/* 238:247 */         cell.setCellValue(RES.getString("xls.mali_pesomaxveterinario"));
/* 239:248 */         cell.setCellStyle(boldStyle);
/* 240:    */         
/* 241:250 */         cell = row.createCell((short)y++);
/* 242:251 */         cell.setCellValue(RES.getString("xls.mali_pesominveterinario"));
/* 243:252 */         cell.setCellStyle(boldStyle);
/* 244:    */         
/* 245:254 */         cell = row.createCell((short)y++);
/* 246:255 */         cell.setCellValue(RES.getString("xls.mali_unidadpais"));
/* 247:256 */         cell.setCellStyle(boldStyle);
/* 248:    */         
/* 249:258 */         cell = row.createCell((short)y++);
/* 250:259 */         cell.setCellValue(RES.getString("xls.mali_tipocomida"));
/* 251:260 */         cell.setCellStyle(boldStyle);
/* 252:    */         
/* 253:262 */         cell = row.createCell((short)y++);
/* 254:263 */         cell.setCellValue(RES.getString("xls.mali_fabricante"));
/* 255:264 */         cell.setCellStyle(boldStyle);
/* 256:    */         
/* 257:266 */         cell = row.createCell((short)y++);
/* 258:267 */         cell.setCellValue(RES.getString("xls.mali_tipo"));
/* 259:268 */         cell.setCellStyle(boldStyle);
/* 260:    */         
/* 261:270 */         cell = row.createCell((short)y++);
/* 262:271 */         cell.setCellValue(RES.getString("xls.mali_peso"));
/* 263:272 */         cell.setCellStyle(boldStyle);
/* 264:    */         
/* 265:274 */         cell = row.createCell((short)y++);
/* 266:275 */         cell.setCellValue(RES.getString("xls.mali_grxdosis"));
/* 267:276 */         cell.setCellStyle(boldStyle);
/* 268:    */         
/* 269:278 */         cell = row.createCell((short)y++);
/* 270:279 */         cell.setCellValue(RES.getString("xls.mali_dosisxdia"));
/* 271:280 */         cell.setCellStyle(boldStyle);
/* 272:    */         
/* 273:282 */         y = 0;
/* 274:    */         
/* 275:284 */         continue;
/* 276:285 */         MascotaAlimentacion mascotaAlimentacion = (MascotaAlimentacion)iter.next();
/* 277:    */         
/* 278:287 */         row = sheet.createRow(x++);
/* 279:    */         
/* 280:289 */         cell = row.createCell((short)y++);
/* 281:290 */         cell.setCellValue(mascotaAlimentacion.getMali_cod().doubleValue());
/* 282:    */         
/* 283:292 */         cell = row.createCell((short)y++);
/* 284:293 */         cell.setCellValue(mascota.getMas_cod().doubleValue());
/* 285:    */         
/* 286:295 */         cell = row.createCell((short)y++);
/* 287:296 */         cell.setCellValue(ManejoFechas.FormateoFecha(mascotaAlimentacion.getMali_fecultpeso().toString()));
/* 288:    */         
/* 289:    */ 
/* 290:299 */         cell = row.createCell((short)y++);
/* 291:300 */         cell.setCellValue(mascotaAlimentacion.getMali_pesomascota().doubleValue());
/* 292:    */         
/* 293:302 */         cell = row.createCell((short)y++);
/* 294:303 */         cell.setCellValue(mascotaAlimentacion.getMali_pesomaxveterinario().doubleValue());
/* 295:    */         
/* 296:305 */         cell = row.createCell((short)y++);
/* 297:306 */         cell.setCellValue(mascotaAlimentacion.getMali_pesominveterinario().doubleValue());
/* 298:    */         
/* 299:308 */         cell = row.createCell((short)y++);
/* 300:309 */         cell.setCellValue(mascotaAlimentacion.getMali_unidadpais().doubleValue());
/* 301:    */         
/* 302:311 */         cell = row.createCell((short)y++);
/* 303:312 */         cell.setCellValue(mascotaAlimentacion.getMali_tipocomida().doubleValue() == 2.0D ? RES.getString("1024") : mascotaAlimentacion.getMali_tipocomida().doubleValue() == 1.0D ? RES.getString("1023") : mascotaAlimentacion.getMali_tipocomida().doubleValue() == 0.0D ? RES.getString("1022") : RES.getString("2302"));
/* 304:    */         
/* 305:314 */         cell = row.createCell((short)y++);
/* 306:315 */         cell.setCellValue(mascotaAlimentacion.getMali_fabricante());
/* 307:    */         
/* 308:317 */         cell = row.createCell((short)y++);
/* 309:318 */         cell.setCellValue(mascotaAlimentacion.getMali_tipo());
/* 310:    */         
/* 311:320 */         cell = row.createCell((short)y++);
/* 312:321 */         cell.setCellValue(mascotaAlimentacion.getMali_peso().doubleValue());
/* 313:    */         
/* 314:323 */         cell = row.createCell((short)y++);
/* 315:324 */         cell.setCellValue(mascotaAlimentacion.getMali_grxdosis().doubleValue());
/* 316:    */         
/* 317:326 */         cell = row.createCell((short)y++);
/* 318:327 */         cell.setCellValue(mascotaAlimentacion.getMali_dosisxdia().doubleValue());
/* 319:    */         
/* 320:329 */         y = 0;
/* 321:    */       }
/* 322:    */     }
/* 323:    */     catch (Exception e)
/* 324:    */     {
/* 325:335 */       throw e;
/* 326:    */     }
/* 327:    */   }
/* 328:    */   
/* 329:    */   public static void generarDatosContvacuna(String nombreHoja, int servidor)
/* 330:    */     throws Exception
/* 331:    */   {
/* 332:    */     try
/* 333:    */     {
/* 334:347 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/* 335:348 */       HSSFFont boldFont = wb.createFont();
/* 336:349 */       boldFont.setBoldweight((short)700);
/* 337:350 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/* 338:351 */       boldStyle.setFont(boldFont);
/* 339:    */       
/* 340:353 */       MascotaDAO mascotaDAO = new MascotaDAO();
/* 341:354 */       mascotaDAO.setServerNumber(servidor);
/* 342:355 */       List mascotas = mascotaDAO.list(usuarioPets.getUsup_cod());
/* 343:356 */       VacunasCuidadosDAO vacunasCuidadosDAO = new VacunasCuidadosDAO();
/* 344:357 */       vacunasCuidadosDAO.setServerNumber(servidor);
/* 345:358 */       List vacunasCuidadoss = null;
/* 346:    */       
/* 347:360 */       HSSFRow row = null;
/* 348:361 */       HSSFCell cell = null;
/* 349:    */       
/* 350:363 */       int x = 0;
/* 351:364 */       int y = 0;
/* 352:    */       
/* 353:366 */       Iterator it = mascotas.iterator();
/* 354:    */       Iterator iter;
/* 355:367 */       for (; it.hasNext(); (iter != null) && (iter.hasNext()))
/* 356:    */       {
/* 357:368 */         Mascota mascota = (Mascota)it.next();
/* 358:369 */         vacunasCuidadoss = vacunasCuidadosDAO.list(mascota.getMas_cod());
/* 359:370 */         iter = vacunasCuidadoss.iterator();
/* 360:    */         
/* 361:372 */         row = sheet.createRow(x++);
/* 362:373 */         cell = row.createCell((short)y++);
/* 363:374 */         cell.setCellValue(mascota.getMas_nombre());
/* 364:375 */         cell.setCellStyle(boldStyle);
/* 365:    */         
/* 366:377 */         y = 0;
/* 367:378 */         x++;
/* 368:379 */         row = sheet.createRow(x++);
/* 369:    */         
/* 370:381 */         cell = row.createCell((short)y++);
/* 371:382 */         cell.setCellValue(RES.getString("xls.vcui_cod"));
/* 372:383 */         cell.setCellStyle(boldStyle);
/* 373:    */         
/* 374:385 */         cell = row.createCell((short)y++);
/* 375:386 */         cell.setCellValue(RES.getString("xls.vcui_mas_cod"));
/* 376:387 */         cell.setCellStyle(boldStyle);
/* 377:    */         
/* 378:389 */         cell = row.createCell((short)y++);
/* 379:390 */         cell.setCellValue(RES.getString("xls.vcui_descripcion"));
/* 380:391 */         cell.setCellStyle(boldStyle);
/* 381:    */         
/* 382:393 */         cell = row.createCell((short)y++);
/* 383:394 */         cell.setCellValue(RES.getString("xls.vcui_30"));
/* 384:395 */         cell.setCellStyle(boldStyle);
/* 385:    */         
/* 386:397 */         cell = row.createCell((short)y++);
/* 387:398 */         cell.setCellValue(RES.getString("xls.vcui_45"));
/* 388:399 */         cell.setCellStyle(boldStyle);
/* 389:    */         
/* 390:401 */         cell = row.createCell((short)y++);
/* 391:402 */         cell.setCellValue(RES.getString("xls.vcui_60"));
/* 392:403 */         cell.setCellStyle(boldStyle);
/* 393:    */         
/* 394:405 */         cell = row.createCell((short)y++);
/* 395:406 */         cell.setCellValue(RES.getString("xls.vcui_75"));
/* 396:407 */         cell.setCellStyle(boldStyle);
/* 397:    */         
/* 398:409 */         cell = row.createCell((short)y++);
/* 399:410 */         cell.setCellValue(RES.getString("xls.vcui_90"));
/* 400:411 */         cell.setCellStyle(boldStyle);
/* 401:    */         
/* 402:413 */         cell = row.createCell((short)y++);
/* 403:414 */         cell.setCellValue(RES.getString("xls.vcui_105"));
/* 404:415 */         cell.setCellStyle(boldStyle);
/* 405:    */         
/* 406:417 */         cell = row.createCell((short)y++);
/* 407:418 */         cell.setCellValue(RES.getString("xls.vcui_120"));
/* 408:419 */         cell.setCellStyle(boldStyle);
/* 409:    */         
/* 410:421 */         cell = row.createCell((short)y++);
/* 411:422 */         cell.setCellValue(RES.getString("xls.vcui_150"));
/* 412:423 */         cell.setCellStyle(boldStyle);
/* 413:    */         
/* 414:425 */         cell = row.createCell((short)y++);
/* 415:426 */         cell.setCellValue(RES.getString("xls.vcui_180"));
/* 416:427 */         cell.setCellStyle(boldStyle);
/* 417:    */         
/* 418:429 */         cell = row.createCell((short)y++);
/* 419:430 */         cell.setCellValue(RES.getString("xls.vcui_control"));
/* 420:431 */         cell.setCellStyle(boldStyle);
/* 421:    */         
/* 422:433 */         cell = row.createCell((short)y++);
/* 423:434 */         cell.setCellValue(RES.getString("xls.vcui_raz_tipo"));
/* 424:435 */         cell.setCellStyle(boldStyle);
/* 425:    */         
/* 426:437 */         y = 0;
/* 427:    */         
/* 428:439 */         continue;
/* 429:440 */         VacunasCuidados vacunasCuidados = (VacunasCuidados)iter.next();
/* 430:    */         
/* 431:442 */         row = sheet.createRow(x++);
/* 432:    */         
/* 433:444 */         cell = row.createCell((short)y++);
/* 434:445 */         cell.setCellValue(vacunasCuidados.getVcui_cod().doubleValue());
/* 435:    */         
/* 436:447 */         cell = row.createCell((short)y++);
/* 437:448 */         cell.setCellValue(mascota.getMas_cod().doubleValue());
/* 438:    */         
/* 439:450 */         cell = row.createCell((short)y++);
/* 440:451 */         cell.setCellValue(vacunasCuidados.getVcui_descripcion());
/* 441:    */         
/* 442:453 */         cell = row.createCell((short)y++);
/* 443:454 */         cell.setCellValue(vacunasCuidados.getVcui_30().equals(IConstantes.CODIGO_SI.toString()) ? RES.getString("global.si") : RES.getString("global.no"));
/* 444:    */         
/* 445:456 */         cell = row.createCell((short)y++);
/* 446:457 */         cell.setCellValue(vacunasCuidados.getVcui_45().equals(IConstantes.CODIGO_SI.toString()) ? RES.getString("global.si") : RES.getString("global.no"));
/* 447:    */         
/* 448:459 */         cell = row.createCell((short)y++);
/* 449:460 */         cell.setCellValue(vacunasCuidados.getVcui_60().equals(IConstantes.CODIGO_SI.toString()) ? RES.getString("global.si") : RES.getString("global.no"));
/* 450:    */         
/* 451:462 */         cell = row.createCell((short)y++);
/* 452:463 */         cell.setCellValue(vacunasCuidados.getVcui_75().equals(IConstantes.CODIGO_SI.toString()) ? RES.getString("global.si") : RES.getString("global.no"));
/* 453:    */         
/* 454:465 */         cell = row.createCell((short)y++);
/* 455:466 */         cell.setCellValue(vacunasCuidados.getVcui_90().equals(IConstantes.CODIGO_SI.toString()) ? RES.getString("global.si") : RES.getString("global.no"));
/* 456:    */         
/* 457:468 */         cell = row.createCell((short)y++);
/* 458:469 */         cell.setCellValue(vacunasCuidados.getVcui_105().equals(IConstantes.CODIGO_SI.toString()) ? RES.getString("global.si") : RES.getString("global.no"));
/* 459:    */         
/* 460:471 */         cell = row.createCell((short)y++);
/* 461:472 */         cell.setCellValue(vacunasCuidados.getVcui_120().equals(IConstantes.CODIGO_SI.toString()) ? RES.getString("global.si") : RES.getString("global.no"));
/* 462:    */         
/* 463:474 */         cell = row.createCell((short)y++);
/* 464:475 */         cell.setCellValue(vacunasCuidados.getVcui_150().equals(IConstantes.CODIGO_SI.toString()) ? RES.getString("global.si") : RES.getString("global.no"));
/* 465:    */         
/* 466:477 */         cell = row.createCell((short)y++);
/* 467:478 */         cell.setCellValue(vacunasCuidados.getVcui_180().equals(IConstantes.CODIGO_SI.toString()) ? RES.getString("global.si") : RES.getString("global.no"));
/* 468:    */         
/* 469:480 */         cell = row.createCell((short)y++);
/* 470:481 */         cell.setCellValue(vacunasCuidados.getVcui_control().doubleValue());
/* 471:    */         
/* 472:483 */         cell = row.createCell((short)y++);
/* 473:484 */         cell.setCellValue(vacunasCuidados.getVcui_raz_tipo().intValue() == 0 ? RES.getString("1005") : RES.getString("1006"));
/* 474:    */         
/* 475:486 */         y = 0;
/* 476:    */       }
/* 477:    */     }
/* 478:    */     catch (Exception e)
/* 479:    */     {
/* 480:491 */       throw e;
/* 481:    */     }
/* 482:    */   }
/* 483:    */   
/* 484:    */   public static void generarDatosContactmas(String nombreHoja, String idioma, int servidor)
/* 485:    */     throws Exception
/* 486:    */   {
/* 487:    */     try
/* 488:    */     {
/* 489:503 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/* 490:504 */       HSSFFont boldFont = wb.createFont();
/* 491:505 */       boldFont.setBoldweight((short)700);
/* 492:506 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/* 493:507 */       boldStyle.setFont(boldFont);
/* 494:    */       
/* 495:509 */       MascotaDAO mascotaDAO = new MascotaDAO();
/* 496:510 */       mascotaDAO.setServerNumber(servidor);
/* 497:511 */       List mascotas = mascotaDAO.list(usuarioPets.getUsup_cod());
/* 498:    */       
/* 499:513 */       ContactosMascotaDAO contactosMascotaDAO = new ContactosMascotaDAO();
/* 500:514 */       contactosMascotaDAO.setServerNumber(servidor);
/* 501:515 */       List contactosMascotas = null;
/* 502:    */       
/* 503:517 */       HSSFRow row = null;
/* 504:518 */       HSSFCell cell = null;
/* 505:    */       
/* 506:520 */       int x = 0;
/* 507:521 */       int y = 0;
/* 508:    */       
/* 509:523 */       Iterator it = mascotas.iterator();
/* 510:    */       Iterator iter;
/* 511:524 */       for (; it.hasNext(); (iter != null) && (iter.hasNext()))
/* 512:    */       {
/* 513:525 */         Mascota mascota = (Mascota)it.next();
/* 514:526 */         contactosMascotas = contactosMascotaDAO.list(mascota.getMas_cod());
/* 515:527 */         iter = contactosMascotas.iterator();
/* 516:    */         
/* 517:529 */         row = sheet.createRow(x++);
/* 518:530 */         cell = row.createCell((short)y++);
/* 519:531 */         cell.setCellValue(mascota.getMas_nombre());
/* 520:532 */         cell.setCellStyle(boldStyle);
/* 521:    */         
/* 522:534 */         y = 0;
/* 523:535 */         x++;
/* 524:536 */         row = sheet.createRow(x++);
/* 525:    */         
/* 526:538 */         cell = row.createCell((short)y++);
/* 527:539 */         cell.setCellValue(RES.getString("xls.cmas_cod"));
/* 528:540 */         cell.setCellStyle(boldStyle);
/* 529:    */         
/* 530:542 */         cell = row.createCell((short)y++);
/* 531:543 */         cell.setCellValue(RES.getString("xls.cmas_mas_cod"));
/* 532:544 */         cell.setCellStyle(boldStyle);
/* 533:    */         
/* 534:546 */         cell = row.createCell((short)y++);
/* 535:547 */         cell.setCellValue(RES.getString("xls.cmas_nombre1"));
/* 536:548 */         cell.setCellStyle(boldStyle);
/* 537:    */         
/* 538:550 */         cell = row.createCell((short)y++);
/* 539:551 */         cell.setCellValue(RES.getString("xls.cmas_apellido"));
/* 540:552 */         cell.setCellStyle(boldStyle);
/* 541:    */         
/* 542:554 */         cell = row.createCell((short)y++);
/* 543:555 */         cell.setCellValue(RES.getString("xls.cmas_pais_cod"));
/* 544:556 */         cell.setCellStyle(boldStyle);
/* 545:    */         
/* 546:558 */         cell = row.createCell((short)y++);
/* 547:559 */         cell.setCellValue(RES.getString("xls.cmas_ciu_cod"));
/* 548:560 */         cell.setCellStyle(boldStyle);
/* 549:    */         
/* 550:562 */         cell = row.createCell((short)y++);
/* 551:563 */         cell.setCellValue(RES.getString("xls.cmas_mail"));
/* 552:564 */         cell.setCellStyle(boldStyle);
/* 553:    */         
/* 554:566 */         y = 0;
/* 555:    */         
/* 556:568 */         continue;
/* 557:569 */         ContactosMascota contactosMascota = (ContactosMascota)iter.next();
/* 558:    */         
/* 559:571 */         PaisDAO paisDAO = new PaisDAO();
/* 560:572 */         paisDAO.setServerNumber(servidor);
/* 561:573 */         paisDAO.setIdioma(idioma);
/* 562:574 */         Paises pais = paisDAO.retrive(contactosMascota.getCmas_pais_cod());
/* 563:    */         
/* 564:576 */         CiudadDAO ciudadDAO = new CiudadDAO();
/* 565:577 */         ciudadDAO.setServerNumber(servidor);
/* 566:578 */         ciudadDAO.setIdioma(idioma);
/* 567:579 */         Ciudades ciudad = ciudadDAO.retrive(contactosMascota.getCmas_pais_cod(), contactosMascota.getCmas_ciu_cod());
/* 568:    */         
/* 569:581 */         row = sheet.createRow(x++);
/* 570:    */         
/* 571:583 */         cell = row.createCell((short)y++);
/* 572:584 */         cell.setCellValue(contactosMascota.getCmas_cod().doubleValue());
/* 573:    */         
/* 574:586 */         cell = row.createCell((short)y++);
/* 575:587 */         cell.setCellValue(mascota.getMas_nombre());
/* 576:    */         
/* 577:589 */         cell = row.createCell((short)y++);
/* 578:590 */         cell.setCellValue(contactosMascota.getCmas_nombre());
/* 579:    */         
/* 580:592 */         cell = row.createCell((short)y++);
/* 581:593 */         cell.setCellValue(contactosMascota.getCmas_apellido());
/* 582:    */         
/* 583:595 */         cell = row.createCell((short)y++);
/* 584:596 */         cell.setCellValue(pais.getPais_des());
/* 585:    */         
/* 586:598 */         cell = row.createCell((short)y++);
/* 587:599 */         cell.setCellValue(ciudad.getCiu_des());
/* 588:    */         
/* 589:601 */         cell = row.createCell((short)y++);
/* 590:602 */         cell.setCellValue(contactosMascota.getCmas_mail());
/* 591:    */         
/* 592:604 */         y = 0;
/* 593:    */       }
/* 594:    */     }
/* 595:    */     catch (Exception e)
/* 596:    */     {
/* 597:609 */       throw e;
/* 598:    */     }
/* 599:    */   }
/* 600:    */   
/* 601:    */   public static void generarDatosMedicammas(String nombreHoja, int servidor)
/* 602:    */     throws Exception
/* 603:    */   {
/* 604:    */     try
/* 605:    */     {
/* 606:621 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/* 607:622 */       HSSFFont boldFont = wb.createFont();
/* 608:623 */       boldFont.setBoldweight((short)700);
/* 609:624 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/* 610:625 */       boldStyle.setFont(boldFont);
/* 611:    */       
/* 612:627 */       MascotaDAO mascotaDAO = new MascotaDAO();
/* 613:628 */       mascotaDAO.setServerNumber(servidor);
/* 614:629 */       List mascotas = mascotaDAO.list(usuarioPets.getUsup_cod());
/* 615:    */       
/* 616:631 */       MascotaMedicamentosDAO mascotaMedicamentosDAO = new MascotaMedicamentosDAO();
/* 617:632 */       mascotaMedicamentosDAO.setServerNumber(servidor);
/* 618:633 */       List mascotaMedicamentoss = null;
/* 619:    */       
/* 620:635 */       HSSFRow row = null;
/* 621:636 */       HSSFCell cell = null;
/* 622:    */       
/* 623:638 */       int x = 0;
/* 624:639 */       int y = 0;
/* 625:    */       
/* 626:641 */       Iterator it = mascotas.iterator();
/* 627:    */       Iterator iter;
/* 628:642 */       for (; it.hasNext(); (iter != null) && (iter.hasNext()))
/* 629:    */       {
/* 630:643 */         Mascota mascota = (Mascota)it.next();
/* 631:644 */         mascotaMedicamentoss = mascotaMedicamentosDAO.list(mascota.getMas_cod());
/* 632:645 */         iter = mascotaMedicamentoss.iterator();
/* 633:    */         
/* 634:647 */         row = sheet.createRow(x++);
/* 635:648 */         cell = row.createCell((short)y++);
/* 636:649 */         cell.setCellValue(mascota.getMas_nombre());
/* 637:650 */         cell.setCellStyle(boldStyle);
/* 638:    */         
/* 639:652 */         y = 0;
/* 640:653 */         x++;
/* 641:654 */         row = sheet.createRow(x++);
/* 642:    */         
/* 643:656 */         cell = row.createCell((short)y++);
/* 644:657 */         cell.setCellValue(RES.getString("xls.mmed_cod"));
/* 645:658 */         cell.setCellStyle(boldStyle);
/* 646:    */         
/* 647:660 */         cell = row.createCell((short)y++);
/* 648:661 */         cell.setCellValue(RES.getString("xls.mmed_mas_cod"));
/* 649:662 */         cell.setCellStyle(boldStyle);
/* 650:    */         
/* 651:664 */         cell = row.createCell((short)y++);
/* 652:665 */         cell.setCellValue(RES.getString("xls.mmed_afeccion"));
/* 653:666 */         cell.setCellStyle(boldStyle);
/* 654:    */         
/* 655:668 */         cell = row.createCell((short)y++);
/* 656:669 */         cell.setCellValue(RES.getString("xls.mmed_nombre"));
/* 657:670 */         cell.setCellStyle(boldStyle);
/* 658:    */         
/* 659:672 */         cell = row.createCell((short)y++);
/* 660:673 */         cell.setCellValue(RES.getString("xls.mmed_costo"));
/* 661:674 */         cell.setCellStyle(boldStyle);
/* 662:    */         
/* 663:676 */         cell = row.createCell((short)y++);
/* 664:677 */         cell.setCellValue(RES.getString("xls.mmed_fec_inicio"));
/* 665:678 */         cell.setCellStyle(boldStyle);
/* 666:    */         
/* 667:680 */         cell = row.createCell((short)y++);
/* 668:681 */         cell.setCellValue(RES.getString("xls.mmed_dias_uso"));
/* 669:682 */         cell.setCellStyle(boldStyle);
/* 670:    */         
/* 671:684 */         cell = row.createCell((short)y++);
/* 672:685 */         cell.setCellValue(RES.getString("xls.mmed_veces_dia"));
/* 673:686 */         cell.setCellStyle(boldStyle);
/* 674:    */         
/* 675:688 */         cell = row.createCell((short)y++);
/* 676:689 */         cell.setCellValue(RES.getString("xls.mmed_dosis"));
/* 677:690 */         cell.setCellStyle(boldStyle);
/* 678:    */         
/* 679:692 */         y = 0;
/* 680:    */         
/* 681:694 */         continue;
/* 682:695 */         MascotaMedicamentos mascotaMedicamentos = (MascotaMedicamentos)iter.next();
/* 683:    */         
/* 684:697 */         row = sheet.createRow(x++);
/* 685:    */         
/* 686:699 */         cell = row.createCell((short)y++);
/* 687:700 */         cell.setCellValue(mascotaMedicamentos.getMmed_cod().doubleValue());
/* 688:    */         
/* 689:702 */         cell = row.createCell((short)y++);
/* 690:703 */         cell.setCellValue(mascota.getMas_cod().doubleValue());
/* 691:    */         
/* 692:705 */         cell = row.createCell((short)y++);
/* 693:706 */         cell.setCellValue(mascotaMedicamentos.getMmed_afeccion());
/* 694:    */         
/* 695:708 */         cell = row.createCell((short)y++);
/* 696:709 */         cell.setCellValue(mascotaMedicamentos.getMmed_nombre());
/* 697:    */         
/* 698:711 */         cell = row.createCell((short)y++);
/* 699:712 */         cell.setCellValue(ManejoFechas.FormateoFecha(mascotaMedicamentos.getMmed_fec_inicio().toString()));
/* 700:    */         
/* 701:714 */         cell = row.createCell((short)y++);
/* 702:715 */         cell.setCellValue(mascotaMedicamentos.getMmed_dias_uso().doubleValue());
/* 703:    */         
/* 704:717 */         cell = row.createCell((short)y++);
/* 705:718 */         cell.setCellValue(mascotaMedicamentos.getMmed_veces_dia().doubleValue());
/* 706:    */         
/* 707:720 */         cell = row.createCell((short)y++);
/* 708:721 */         cell.setCellValue(mascotaMedicamentos.getMmed_dosis());
/* 709:    */         
/* 710:723 */         y = 0;
/* 711:    */       }
/* 712:    */     }
/* 713:    */     catch (Exception e)
/* 714:    */     {
/* 715:728 */       throw e;
/* 716:    */     }
/* 717:    */   }
/* 718:    */   
/* 719:    */   public static HSSFWorkbook getWb()
/* 720:    */   {
/* 721:735 */     return wb;
/* 722:    */   }
/* 723:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdpets.dao.GestorHojasCalculoPets
 * JD-Core Version:    0.7.0.1
 */