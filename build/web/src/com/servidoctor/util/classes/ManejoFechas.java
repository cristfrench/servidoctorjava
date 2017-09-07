/*    1:     */ package com.servidoctor.util.classes;
/*    2:     */ 
/*    3:     */ import com.essecorp.util.GestorFechasCompleto;
/*    4:     */ import com.servidoctor.constantes.IConstantes;
/*    5:     */ import com.servidoctor.parametros.model.RevisionesVehiculo;
/*    6:     */ import com.servidoctor.sdcars.dao.MantenimientoGeneralDAO;
/*    7:     */ import com.servidoctor.sdcars.dao.VehiculosDAO;
/*    8:     */ import com.servidoctor.sdcars.model.MantenimientoGeneral;
/*    9:     */ import com.servidoctor.sdcars.model.Vehiculos;
/*   10:     */ import java.io.PrintStream;
/*   11:     */ import java.math.BigDecimal;
/*   12:     */ import java.sql.SQLException;
/*   13:     */ import java.text.ParseException;
/*   14:     */ import java.text.SimpleDateFormat;
/*   15:     */ import java.util.Calendar;
/*   16:     */ import java.util.Date;
/*   17:     */ import java.util.GregorianCalendar;
/*   18:     */ import java.util.Iterator;
/*   19:     */ import java.util.List;
/*   20:     */ import javax.servlet.http.HttpServletRequest;
/*   21:     */ 
/*   22:     */ public class ManejoFechas
/*   23:     */ {
/*   24:     */   public static String getFechaActual()
/*   25:     */   {
/*   26:  27 */     SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
/*   27:  28 */     Date currentTime = new Date();
/*   28:  29 */     return formatter.format(currentTime);
/*   29:     */   }
/*   30:     */   
/*   31:     */   public static String getHoraActual()
/*   32:     */   {
/*   33:  35 */     SimpleDateFormat formatter = new SimpleDateFormat("hhmmss");
/*   34:  36 */     Date currentTime = new Date();
/*   35:  37 */     return formatter.format(currentTime);
/*   36:     */   }
/*   37:     */   
/*   38:     */   public static String convertirDate2String(long fec)
/*   39:     */   {
/*   40:  43 */     SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
/*   41:  44 */     Date currentTime = new Date(fec);
/*   42:  45 */     return formatter.format(currentTime);
/*   43:     */   }
/*   44:     */   
/*   45:     */   public static String convertirDate2StringSin(long fec)
/*   46:     */   {
/*   47:  51 */     SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
/*   48:  52 */     Date currentTime = new Date(fec);
/*   49:  53 */     return formatter.format(currentTime);
/*   50:     */   }
/*   51:     */   
/*   52:     */   public static String convertirDate2StringYMD(long fec)
/*   53:     */   {
/*   54:  59 */     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
/*   55:  60 */     Date currentTime = new Date(fec);
/*   56:  61 */     return formatter.format(currentTime);
/*   57:     */   }
/*   58:     */   
/*   59:     */   public static long convertirDate2long(int anio, int mes, int dia)
/*   60:     */   {
/*   61:  66 */     GregorianCalendar g = new GregorianCalendar(anio, mes - 1, dia);
/*   62:  67 */     return g.getTime().getTime();
/*   63:     */   }
/*   64:     */   
/*   65:     */   public static String convertirAnioMes(String fec)
/*   66:     */   {
/*   67:  73 */     String anio = fec.substring(0, 4);
/*   68:  74 */     String mes = fec.substring(4, 6);
/*   69:  75 */     String fecha = "";
/*   70:  76 */     if (mes.equals("01")) {
/*   71:  77 */       fecha = "Enero";
/*   72:     */     }
/*   73:  78 */     if (mes.equals("02")) {
/*   74:  79 */       fecha = "Febrero";
/*   75:     */     }
/*   76:  80 */     if (mes.equals("03")) {
/*   77:  81 */       fecha = "Marzo";
/*   78:     */     }
/*   79:  82 */     if (mes.equals("04")) {
/*   80:  83 */       fecha = "Abril";
/*   81:     */     }
/*   82:  84 */     if (mes.equals("05")) {
/*   83:  85 */       fecha = "Mayo";
/*   84:     */     }
/*   85:  86 */     if (mes.equals("06")) {
/*   86:  87 */       fecha = "Junio";
/*   87:     */     }
/*   88:  88 */     if (mes.equals("07")) {
/*   89:  89 */       fecha = "Julio";
/*   90:     */     }
/*   91:  90 */     if (mes.equals("08")) {
/*   92:  91 */       fecha = "Agosto";
/*   93:     */     }
/*   94:  92 */     if (mes.equals("09")) {
/*   95:  93 */       fecha = "Septiembre";
/*   96:     */     }
/*   97:  94 */     if (mes.equals("10")) {
/*   98:  95 */       fecha = "Octubre";
/*   99:     */     }
/*  100:  96 */     if (mes.equals("11")) {
/*  101:  97 */       fecha = "Noviembre";
/*  102:     */     }
/*  103:  98 */     if (mes.equals("12")) {
/*  104:  99 */       fecha = "Diciembre";
/*  105:     */     }
/*  106: 101 */     fecha = fecha + " de " + anio;
/*  107:     */     
/*  108: 103 */     return fecha;
/*  109:     */   }
/*  110:     */   
/*  111:     */   public static String convertirMes(String mes)
/*  112:     */   {
/*  113: 109 */     String fecha = "";
/*  114: 110 */     if ((mes.equals("01")) || (mes.equals("1"))) {
/*  115: 111 */       fecha = "Enero";
/*  116:     */     }
/*  117: 112 */     if ((mes.equals("02")) || (mes.equals("2"))) {
/*  118: 113 */       fecha = "Febrero";
/*  119:     */     }
/*  120: 114 */     if ((mes.equals("03")) || (mes.equals("3"))) {
/*  121: 115 */       fecha = "Marzo";
/*  122:     */     }
/*  123: 116 */     if ((mes.equals("04")) || (mes.equals("4"))) {
/*  124: 117 */       fecha = "Abril";
/*  125:     */     }
/*  126: 118 */     if ((mes.equals("05")) || (mes.equals("5"))) {
/*  127: 119 */       fecha = "Mayo";
/*  128:     */     }
/*  129: 120 */     if ((mes.equals("06")) || (mes.equals("6"))) {
/*  130: 121 */       fecha = "Junio";
/*  131:     */     }
/*  132: 122 */     if ((mes.equals("07")) || (mes.equals("7"))) {
/*  133: 123 */       fecha = "Julio";
/*  134:     */     }
/*  135: 124 */     if ((mes.equals("08")) || (mes.equals("8"))) {
/*  136: 125 */       fecha = "Agosto";
/*  137:     */     }
/*  138: 126 */     if ((mes.equals("09")) || (mes.equals("9"))) {
/*  139: 127 */       fecha = "Septiembre";
/*  140:     */     }
/*  141: 128 */     if (mes.equals("10")) {
/*  142: 129 */       fecha = "Octubre";
/*  143:     */     }
/*  144: 130 */     if (mes.equals("11")) {
/*  145: 131 */       fecha = "Noviembre";
/*  146:     */     }
/*  147: 132 */     if (mes.equals("12")) {
/*  148: 133 */       fecha = "Diciembre";
/*  149:     */     }
/*  150: 135 */     return fecha;
/*  151:     */   }
/*  152:     */   
/*  153:     */   public static String getChangeFecha(String fecha)
/*  154:     */   {
/*  155:     */     try
/*  156:     */     {
/*  157: 140 */       if (fecha != null) {
/*  158: 141 */         if ((!fecha.equals("")) && (fecha.length() == 10))
/*  159:     */         {
/*  160: 146 */           String ano = fecha.substring(0, 4);
/*  161: 147 */           String mes = fecha.substring(5, 7);
/*  162: 148 */           String dia = fecha.substring(8, 10);
/*  163: 149 */           fecha = ano + mes + dia;
/*  164:     */         }
/*  165: 150 */         else if ((!fecha.equals("")) && (fecha.length() == 7))
/*  166:     */         {
/*  167: 155 */           String ano = fecha.substring(0, 4);
/*  168: 156 */           String mes = fecha.substring(5, 7);
/*  169:     */           
/*  170: 158 */           fecha = ano + mes;
/*  171:     */         }
/*  172:     */         else
/*  173:     */         {
/*  174: 160 */           return fecha;
/*  175:     */         }
/*  176:     */       }
/*  177:     */     }
/*  178:     */     catch (Exception e)
/*  179:     */     {
/*  180: 164 */       return fecha;
/*  181:     */     }
/*  182: 167 */     return fecha;
/*  183:     */   }
/*  184:     */   
/*  185:     */   public static String FormateoFecha(String fecha)
/*  186:     */   {
/*  187:     */     try
/*  188:     */     {
/*  189: 175 */       if (fecha != null)
/*  190:     */       {
/*  191: 176 */         fecha = fecha.trim();
/*  192: 177 */         if (fecha.length() == 8)
/*  193:     */         {
/*  194: 179 */           String ano = fecha.substring(0, 4);
/*  195: 180 */           String mes = fecha.substring(4, 6);
/*  196: 181 */           String dia = fecha.substring(6, 8);
/*  197: 182 */           return ano + "-" + mes + "-" + dia;
/*  198:     */         }
/*  199: 185 */         if (fecha.length() == 6)
/*  200:     */         {
/*  201: 187 */           String ano = fecha.substring(0, 4);
/*  202: 188 */           String mes = fecha.substring(4, 6);
/*  203: 189 */           return ano + "-" + mes;
/*  204:     */         }
/*  205: 193 */         return fecha;
/*  206:     */       }
/*  207: 195 */       return fecha;
/*  208:     */     }
/*  209:     */     catch (Exception e) {}
/*  210: 197 */     return "0000-00-00";
/*  211:     */   }
/*  212:     */   
/*  213:     */   public static String FormateoFechaYYYYMM(String fecha)
/*  214:     */   {
/*  215:     */     try
/*  216:     */     {
/*  217: 207 */       if (fecha != null)
/*  218:     */       {
/*  219: 208 */         fecha = fecha.trim();
/*  220: 209 */         if (fecha.equals("0")) {
/*  221: 210 */           return "0000-00";
/*  222:     */         }
/*  223: 212 */         if (fecha.length() == 6)
/*  224:     */         {
/*  225: 214 */           String ano = fecha.substring(0, 4);
/*  226: 215 */           String mes = fecha.substring(4, 6);
/*  227:     */           
/*  228: 217 */           return ano + "-" + mes;
/*  229:     */         }
/*  230: 221 */         return fecha;
/*  231:     */       }
/*  232: 223 */       return fecha;
/*  233:     */     }
/*  234:     */     catch (Exception e) {}
/*  235: 225 */     return "0000-00";
/*  236:     */   }
/*  237:     */   
/*  238:     */   public static String getChangeHora(String hora)
/*  239:     */   {
/*  240:     */     try
/*  241:     */     {
/*  242: 233 */       if (hora != null) {
/*  243: 234 */         if ((!hora.equals("")) && (hora.length() == 5))
/*  244:     */         {
/*  245: 238 */           String h = hora.substring(0, 2);
/*  246: 239 */           String m = hora.substring(3, 5);
/*  247:     */           
/*  248: 241 */           hora = h + m;
/*  249:     */         }
/*  250:     */         else
/*  251:     */         {
/*  252: 243 */           return "0000";
/*  253:     */         }
/*  254:     */       }
/*  255:     */     }
/*  256:     */     catch (Exception e)
/*  257:     */     {
/*  258: 247 */       return "0000";
/*  259:     */     }
/*  260: 250 */     return hora;
/*  261:     */   }
/*  262:     */   
/*  263:     */   public static String getChangeHoraAMPM(String hora)
/*  264:     */   {
/*  265:     */     try
/*  266:     */     {
/*  267: 255 */       if (hora != null) {
/*  268: 256 */         if ((!hora.equals("")) && (hora.length() == 9))
/*  269:     */         {
/*  270: 261 */           String h = hora.substring(0, 3);
/*  271: 262 */           String m = hora.substring(4, 6);
/*  272: 263 */           String ampm = hora.substring(7, 9);
/*  273:     */           
/*  274: 265 */           hora = h + m + ampm;
/*  275:     */         }
/*  276:     */         else
/*  277:     */         {
/*  278: 268 */           return hora;
/*  279:     */         }
/*  280:     */       }
/*  281:     */     }
/*  282:     */     catch (Exception e)
/*  283:     */     {
/*  284: 272 */       return "006000";
/*  285:     */     }
/*  286: 275 */     return hora;
/*  287:     */   }
/*  288:     */   
/*  289:     */   public static String getChangeHoraAMPM2(String hora)
/*  290:     */   {
/*  291:     */     try
/*  292:     */     {
/*  293: 280 */       if (hora != null) {
/*  294: 281 */         if ((!hora.equals("")) && (hora.length() == 8))
/*  295:     */         {
/*  296: 285 */           hora = '1' + hora;
/*  297: 286 */           String h = hora.substring(0, 3);
/*  298: 287 */           String m = hora.substring(4, 6);
/*  299: 288 */           String ampm = hora.substring(7, 9);
/*  300:     */           
/*  301: 290 */           hora = h + m + ampm;
/*  302:     */         }
/*  303:     */         else
/*  304:     */         {
/*  305: 293 */           return hora;
/*  306:     */         }
/*  307:     */       }
/*  308:     */     }
/*  309:     */     catch (Exception e)
/*  310:     */     {
/*  311: 297 */       return "006000";
/*  312:     */     }
/*  313: 300 */     return hora;
/*  314:     */   }
/*  315:     */   
/*  316:     */   public static String FormateoHora(String hora)
/*  317:     */   {
/*  318:     */     try
/*  319:     */     {
/*  320: 308 */       if (hora != null)
/*  321:     */       {
/*  322: 309 */         hora = hora.trim();
/*  323: 310 */         if (hora.length() == 4)
/*  324:     */         {
/*  325: 312 */           String h = hora.substring(0, 2);
/*  326: 313 */           String m = hora.substring(2, 4);
/*  327:     */           
/*  328: 315 */           return h + ":" + m;
/*  329:     */         }
/*  330: 319 */         return "00:00";
/*  331:     */       }
/*  332: 321 */       return hora;
/*  333:     */     }
/*  334:     */     catch (Exception e) {}
/*  335: 323 */     return "00:00";
/*  336:     */   }
/*  337:     */   
/*  338:     */   public static String FormateoHoraAMPM(String hora)
/*  339:     */   {
/*  340:     */     try
/*  341:     */     {
/*  342: 334 */       if (hora != null)
/*  343:     */       {
/*  344: 335 */         hora = hora.trim();
/*  345: 336 */         if (hora.length() == 7)
/*  346:     */         {
/*  347: 338 */           String h = hora.substring(0, 3);
/*  348: 339 */           String m = hora.substring(3, 5);
/*  349: 340 */           String ampm = hora.substring(5, 7);
/*  350:     */           
/*  351: 342 */           return h + ":" + m + ":" + ampm;
/*  352:     */         }
/*  353: 346 */         return "00:60:00";
/*  354:     */       }
/*  355: 348 */       return hora;
/*  356:     */     }
/*  357:     */     catch (Exception e) {}
/*  358: 350 */     return "00:60:00";
/*  359:     */   }
/*  360:     */   
/*  361:     */   public static String FormateoHoraAMPMReportes(String hora)
/*  362:     */   {
/*  363:     */     try
/*  364:     */     {
/*  365: 361 */       if (hora != null)
/*  366:     */       {
/*  367: 362 */         hora = hora.trim();
/*  368: 363 */         if (hora.length() == 7)
/*  369:     */         {
/*  370: 365 */           String h = hora.substring(1, 3);
/*  371: 366 */           String m = hora.substring(3, 5);
/*  372: 367 */           String ampm = hora.substring(5, 7);
/*  373:     */           
/*  374: 369 */           return h + ":" + m + " " + (ampm.equals("00") ? "AM" : "PM");
/*  375:     */         }
/*  376: 373 */         return "00:60:00";
/*  377:     */       }
/*  378: 375 */       return hora;
/*  379:     */     }
/*  380:     */     catch (Exception e) {}
/*  381: 377 */     return "00:60:00";
/*  382:     */   }
/*  383:     */   
/*  384:     */   public static int restaFechas(String fechaIni, String fechaFin)
/*  385:     */   {
/*  386:     */     try
/*  387:     */     {
/*  388: 391 */       SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
/*  389: 392 */       Date date1 = sdf.parse(fechaIni);
/*  390: 393 */       Date date2 = sdf.parse(fechaFin);
/*  391: 394 */       long mills = date2.getTime() - date1.getTime();
/*  392: 395 */       return (int)(mills / 86400000L);
/*  393:     */     }
/*  394:     */     catch (ParseException e) {}
/*  395: 397 */     return 0;
/*  396:     */   }
/*  397:     */   
/*  398:     */   private static Date getFechaRevision(Vehiculos vehiculo, Date fechaUltimaRevision, BigDecimal distanciaUltimaRevision, BigDecimal frecuenciaDistancia, int frecuenciaTiempo, BigDecimal alternativa, BigDecimal DistanciaCero, int porcentaje, StringBuffer UltimaFecha)
/*  399:     */   {
/*  400: 402 */     Date result = null;
/*  401: 403 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
/*  402: 404 */     Date fechaOdometro = null;
/*  403:     */     try
/*  404:     */     {
/*  405: 406 */       fechaOdometro = sdf.parse(vehiculo.getVehi_fechaodometro().toString());
/*  406:     */     }
/*  407:     */     catch (Exception e)
/*  408:     */     {
/*  409: 408 */       fechaOdometro = new Date();
/*  410:     */     }
/*  411: 410 */     BigDecimal distanciaActualOdometro = vehiculo.getVehi_kmsact();
/*  412: 411 */     BigDecimal fechaOdometroCero = vehiculo.getVehi_fechaencero();
/*  413:     */     
/*  414:     */ 
/*  415: 414 */     Date fechaActual = new Date();
/*  416: 415 */     Calendar calendar = new GregorianCalendar();
/*  417:     */     
/*  418: 417 */     BigDecimal[] curva = { vehiculo.getVehi_enero().divideToIntegralValue(new BigDecimal(31.0D)), 
/*  419: 418 */       vehiculo.getVehi_febrero().divideToIntegralValue(new BigDecimal(28.0D)), 
/*  420: 419 */       vehiculo.getVehi_marzo().divideToIntegralValue(new BigDecimal(31.0D)), 
/*  421: 420 */       vehiculo.getVehi_abril().divideToIntegralValue(new BigDecimal(30.0D)), 
/*  422: 421 */       vehiculo.getVehi_mayo().divideToIntegralValue(new BigDecimal(31.0D)), 
/*  423: 422 */       vehiculo.getVehi_junio().divideToIntegralValue(new BigDecimal(30.0D)), 
/*  424: 423 */       vehiculo.getVehi_julio().divideToIntegralValue(new BigDecimal(31.0D)), 
/*  425: 424 */       vehiculo.getVehi_agosto().divideToIntegralValue(new BigDecimal(31.0D)), 
/*  426: 425 */       vehiculo.getVehi_septiembre().divideToIntegralValue(new BigDecimal(30.0D)), 
/*  427: 426 */       vehiculo.getVehi_octubre().divideToIntegralValue(new BigDecimal(31.0D)), 
/*  428: 427 */       vehiculo.getVehi_noviembre().divideToIntegralValue(new BigDecimal(30.0D)), 
/*  429: 428 */       vehiculo.getVehi_diciembre().divideToIntegralValue(new BigDecimal(31.0D)) };
/*  430:     */     
/*  431:     */ 
/*  432: 431 */     calendar.setTime(fechaUltimaRevision);
/*  433: 432 */     calendar.add(2, frecuenciaTiempo);
/*  434: 433 */     Date fechaSiguienteRevisionTiempo = calendar.getTime();
/*  435: 434 */     BigDecimal distanciaSiguienteRevision = distanciaUltimaRevision.add(frecuenciaDistancia);
/*  436: 435 */     Date fechaSiguienteRevisionDistancia = null;
/*  437:     */     
/*  438:     */ 
/*  439: 438 */     calendar.setTime(fechaSiguienteRevisionTiempo);
/*  440: 439 */     while ((fechaSiguienteRevisionTiempo.compareTo(fechaActual) == -1) && (frecuenciaTiempo != 0))
/*  441:     */     {
/*  442: 440 */       calendar.add(2, frecuenciaTiempo);
/*  443: 441 */       fechaSiguienteRevisionTiempo = calendar.getTime();
/*  444:     */     }
/*  445: 445 */     calendar.add(2, -1 * frecuenciaTiempo);
/*  446: 446 */     Date fechaInicial = calendar.getTime();
/*  447: 447 */     int diasDiferencia = restaFechas(sdf.format(fechaInicial), sdf.format(fechaSiguienteRevisionTiempo));
/*  448: 448 */     diasDiferencia = diasDiferencia * porcentaje / 100;
/*  449: 449 */     calendar.add(6, diasDiferencia);
/*  450: 450 */     fechaSiguienteRevisionTiempo = calendar.getTime();
/*  451: 452 */     while ((distanciaSiguienteRevision.compareTo(distanciaActualOdometro) != 1) && (!frecuenciaDistancia.equals(BigDecimal.ZERO))) {
/*  452: 453 */       distanciaSiguienteRevision = distanciaSiguienteRevision.add(frecuenciaDistancia);
/*  453:     */     }
/*  454: 456 */     BigDecimal distanciaReferencia = null;
/*  455: 457 */     Date fechaReferencia = null;
/*  456: 459 */     if ((fechaOdometro.compareTo(fechaUltimaRevision) == 1) || (distanciaUltimaRevision.equals(BigDecimal.ZERO)))
/*  457:     */     {
/*  458: 460 */       distanciaReferencia = distanciaActualOdometro;
/*  459: 461 */       fechaReferencia = fechaOdometro;
/*  460:     */     }
/*  461:     */     else
/*  462:     */     {
/*  463: 463 */       distanciaReferencia = distanciaUltimaRevision;
/*  464: 464 */       fechaReferencia = fechaUltimaRevision;
/*  465:     */     }
/*  466: 467 */     boolean denuevo = false;
/*  467: 468 */     sdf.applyPattern("yyyy-MM-dd");
/*  468:     */     do
/*  469:     */     {
/*  470: 471 */       BigDecimal distanciaInicial = distanciaSiguienteRevision.subtract(frecuenciaDistancia);
/*  471:     */       
/*  472: 473 */       BigDecimal distanciaSimulada = distanciaReferencia;
/*  473: 474 */       Calendar fechaSimulada = new GregorianCalendar();
/*  474: 475 */       fechaSimulada.setTime(fechaReferencia);
/*  475: 476 */       while (distanciaSimulada.compareTo(distanciaSiguienteRevision) == -1)
/*  476:     */       {
/*  477: 477 */         distanciaSimulada = distanciaSimulada.add(curva[fechaSimulada.get(2)]);
/*  478: 478 */         fechaSimulada.add(6, 1);
/*  479:     */       }
/*  480: 480 */       fechaSiguienteRevisionDistancia = fechaSimulada.getTime();
/*  481: 481 */       if (fechaSiguienteRevisionDistancia.compareTo(fechaActual) == -1)
/*  482:     */       {
/*  483: 482 */         denuevo = true;
/*  484: 483 */         distanciaSiguienteRevision = distanciaInicial.add(frecuenciaDistancia.multiply(new BigDecimal(2)));
/*  485: 484 */         distanciaReferencia = distanciaSimulada;
/*  486: 485 */         fechaReferencia = fechaSimulada.getTime();
/*  487:     */       }
/*  488:     */       else
/*  489:     */       {
/*  490: 487 */         denuevo = false;
/*  491: 488 */         distanciaSiguienteRevision = distanciaInicial.add(frecuenciaDistancia.multiply(new BigDecimal(porcentaje * 0.01D)));
/*  492:     */         
/*  493: 490 */         distanciaSimulada = distanciaReferencia;
/*  494: 491 */         fechaSimulada = new GregorianCalendar();
/*  495: 492 */         fechaSimulada.setTime(fechaReferencia);
/*  496: 493 */         while (distanciaSimulada.compareTo(distanciaSiguienteRevision) == -1)
/*  497:     */         {
/*  498: 494 */           distanciaSimulada = distanciaSimulada.add(curva[fechaSimulada.get(2)]);
/*  499: 495 */           fechaSimulada.add(6, 1);
/*  500:     */         }
/*  501: 497 */         fechaSiguienteRevisionDistancia = fechaSimulada.getTime();
/*  502:     */       }
/*  503: 499 */     } while ((denuevo) && (!frecuenciaDistancia.equals(BigDecimal.ZERO)));
/*  504: 501 */     if (alternativa.equals(IConstantes.DISTANCIA)) {
/*  505: 502 */       result = fechaSiguienteRevisionDistancia;
/*  506: 503 */     } else if (alternativa.equals(IConstantes.TIEMPO)) {
/*  507: 504 */       result = fechaSiguienteRevisionTiempo;
/*  508: 505 */     } else if (fechaSiguienteRevisionDistancia.compareTo(fechaSiguienteRevisionTiempo) == -1) {
/*  509: 506 */       result = fechaSiguienteRevisionDistancia;
/*  510:     */     } else {
/*  511: 508 */       result = fechaSiguienteRevisionTiempo;
/*  512:     */     }
/*  513: 511 */     return result;
/*  514:     */   }
/*  515:     */   
/*  516:     */   private static String getFechaRevision2(Vehiculos vehiculo, Date fechaUltimaRevision, BigDecimal distanciaUltimaRevision, BigDecimal frecuenciaDistancia, int frecuenciaTiempo, int porcentaje, RevisionesVehiculo revision, StringBuffer UltimaFecha)
/*  517:     */     throws Exception
/*  518:     */   {
/*  519: 515 */     Date result = null;
/*  520: 516 */     String resultado = null;
/*  521: 517 */     Date fechaActual = new Date();
/*  522: 518 */     Calendar calendar = new GregorianCalendar();
/*  523: 519 */     Calendar fechaSimulada = new GregorianCalendar();
/*  524: 520 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
/*  525: 521 */     Date fechaSiguienteRevisionFinal = null;
/*  526:     */     
/*  527: 523 */     Date fechaSiguienteRevisionActualTiempo = null;
/*  528: 524 */     Date fechaSiguienteRevisionActualDistancia = null;
/*  529:     */     
/*  530: 526 */     BigDecimal[] curva = { vehiculo.getVehi_enero().divideToIntegralValue(new BigDecimal(31.0D)), 
/*  531: 527 */       vehiculo.getVehi_febrero().divideToIntegralValue(new BigDecimal(28.0D)), 
/*  532: 528 */       vehiculo.getVehi_marzo().divideToIntegralValue(new BigDecimal(31.0D)), 
/*  533: 529 */       vehiculo.getVehi_abril().divideToIntegralValue(new BigDecimal(30.0D)), 
/*  534: 530 */       vehiculo.getVehi_mayo().divideToIntegralValue(new BigDecimal(31.0D)), 
/*  535: 531 */       vehiculo.getVehi_junio().divideToIntegralValue(new BigDecimal(30.0D)), 
/*  536: 532 */       vehiculo.getVehi_julio().divideToIntegralValue(new BigDecimal(31.0D)), 
/*  537: 533 */       vehiculo.getVehi_agosto().divideToIntegralValue(new BigDecimal(31.0D)), 
/*  538: 534 */       vehiculo.getVehi_septiembre().divideToIntegralValue(new BigDecimal(30.0D)), 
/*  539: 535 */       vehiculo.getVehi_octubre().divideToIntegralValue(new BigDecimal(31.0D)), 
/*  540: 536 */       vehiculo.getVehi_noviembre().divideToIntegralValue(new BigDecimal(30.0D)), 
/*  541: 537 */       vehiculo.getVehi_diciembre().divideToIntegralValue(new BigDecimal(31.0D)) };
/*  542:     */     
/*  543:     */ 
/*  544:     */ 
/*  545:     */ 
/*  546:     */ 
/*  547:     */ 
/*  548:     */ 
/*  549: 545 */     int error = 0;
/*  550: 546 */     int valor = 0;
/*  551: 547 */     int valor2 = 0;
/*  552:     */     
/*  553:     */ 
/*  554: 550 */     Date FechaOdometroInicial = null;
/*  555: 551 */     Date FechaUltimoControl = null;
/*  556: 552 */     Date FechaCompraInicial = null;
/*  557: 553 */     Date FechaDistanciaOdometroInicial = null;
/*  558: 554 */     Date FechaDistanciaUltimoControl = null;
/*  559: 555 */     Date FechaDistanciaCompraInicial = null;
/*  560: 556 */     BigDecimal DistanciaInicial = BigDecimal.ZERO;
/*  561: 561 */     if ((revision.getRveh_alt_cod().equals(new BigDecimal("2"))) || (revision.getRveh_alt_cod().equals(new BigDecimal("3"))))
/*  562:     */     {
/*  563: 563 */       Date FechaTiempoInicial = null;
/*  564: 564 */       if (vehiculo.getVehi_kmsodometroinicial() != null)
/*  565:     */       {
/*  566: 565 */         if (vehiculo.getVehi_kmsodometroinicial().compareTo(BigDecimal.ZERO) != 0)
/*  567:     */         {
/*  568: 566 */           FechaOdometroInicial = sdf.parse(vehiculo.getVehi_fechaodometroinicial().toString());
/*  569:     */         }
/*  570:     */         else
/*  571:     */         {
/*  572: 568 */           error++;
/*  573: 569 */           valor = 1;
/*  574: 570 */           valor2 += valor;
/*  575:     */         }
/*  576:     */       }
/*  577:     */       else
/*  578:     */       {
/*  579: 573 */         error++;
/*  580: 574 */         valor = 1;
/*  581: 575 */         valor2 += valor;
/*  582:     */       }
/*  583: 577 */       if (revision.getRveh_control_fec() != null)
/*  584:     */       {
/*  585: 578 */         if (revision.getRveh_control_fec().compareTo(BigDecimal.ZERO) != 0)
/*  586:     */         {
/*  587: 579 */           FechaUltimoControl = sdf.parse(revision.getRveh_control_fec().toString());
/*  588:     */         }
/*  589:     */         else
/*  590:     */         {
/*  591: 581 */           error++;
/*  592: 582 */           valor = 2;
/*  593: 583 */           valor2 += valor;
/*  594:     */         }
/*  595:     */       }
/*  596:     */       else
/*  597:     */       {
/*  598: 586 */         error++;
/*  599: 587 */         valor = 2;
/*  600: 588 */         valor2 += valor;
/*  601:     */       }
/*  602: 590 */       if (vehiculo.getVehi_feccomp() != null)
/*  603:     */       {
/*  604: 591 */         if (vehiculo.getVehi_feccomp().compareTo(BigDecimal.ZERO) != 0)
/*  605:     */         {
/*  606: 592 */           FechaCompraInicial = sdf.parse(vehiculo.getVehi_feccomp().toString());
/*  607:     */         }
/*  608:     */         else
/*  609:     */         {
/*  610: 594 */           error++;
/*  611: 595 */           valor = 3;
/*  612: 596 */           valor2 += valor;
/*  613:     */         }
/*  614:     */       }
/*  615:     */       else
/*  616:     */       {
/*  617: 599 */         error++;
/*  618: 600 */         valor = 3;
/*  619: 601 */         valor2 += valor;
/*  620:     */       }
/*  621: 604 */       switch (error)
/*  622:     */       {
/*  623:     */       case 0: 
/*  624: 606 */         FechaTiempoInicial = FechaUltimoControl;
/*  625: 607 */         break;
/*  626:     */       case 1: 
/*  627: 609 */         if (valor == 1) {
/*  628: 610 */           FechaTiempoInicial = FechaUltimoControl;
/*  629:     */         }
/*  630: 613 */         if (valor == 2) {
/*  631: 614 */           FechaTiempoInicial = FechaOdometroInicial;
/*  632:     */         }
/*  633: 617 */         if (valor == 3) {
/*  634: 618 */           FechaTiempoInicial = FechaUltimoControl;
/*  635:     */         }
/*  636: 622 */         break;
/*  637:     */       case 2: 
/*  638: 624 */         if (valor2 == 3) {
/*  639: 625 */           FechaTiempoInicial = FechaCompraInicial;
/*  640:     */         }
/*  641: 627 */         if (valor2 == 4) {
/*  642: 628 */           FechaTiempoInicial = FechaUltimoControl;
/*  643:     */         }
/*  644: 630 */         if (valor2 == 5) {
/*  645: 631 */           FechaTiempoInicial = FechaOdometroInicial;
/*  646:     */         }
/*  647: 633 */         break;
/*  648:     */       }
/*  649: 643 */       fechaSiguienteRevisionActualTiempo = getFechaRevisionActual(FechaTiempoInicial, vehiculo, porcentaje, revision.getRveh_cada_cdm(), revision.getRveh_cada_cdk());
/*  650:     */     }
/*  651: 648 */     if ((revision.getRveh_alt_cod().equals(new BigDecimal("1"))) || (revision.getRveh_alt_cod().equals(new BigDecimal("3"))))
/*  652:     */     {
/*  653: 650 */       int opcion = 0;
/*  654: 651 */       int errorDistancia = 0;
/*  655: 652 */       valor2 = 0;
/*  656: 653 */       valor = 0;
/*  657:     */       
/*  658:     */ 
/*  659: 656 */       Date FechaDistanciaInicial = null;
/*  660: 657 */       Date FechaDistanciaCero = null;
/*  661: 659 */       if (vehiculo.getVehi_fechaodometroinicial() != null)
/*  662:     */       {
/*  663: 660 */         if (vehiculo.getVehi_fechaodometroinicial().compareTo(BigDecimal.ZERO) != 0)
/*  664:     */         {
/*  665: 661 */           FechaDistanciaOdometroInicial = sdf.parse(vehiculo.getVehi_fechaodometroinicial().toString());
/*  666:     */         }
/*  667:     */         else
/*  668:     */         {
/*  669: 663 */           errorDistancia++;
/*  670: 664 */           valor = 1;
/*  671: 665 */           valor2 += valor;
/*  672:     */         }
/*  673:     */       }
/*  674:     */       else
/*  675:     */       {
/*  676: 668 */         errorDistancia++;
/*  677: 669 */         valor = 1;
/*  678: 670 */         valor2 += valor;
/*  679:     */       }
/*  680: 672 */       if (revision.getRveh_control_fec() != null)
/*  681:     */       {
/*  682: 673 */         if (revision.getRveh_control_fec().compareTo(BigDecimal.ZERO) != 0)
/*  683:     */         {
/*  684: 674 */           FechaDistanciaUltimoControl = sdf.parse(revision.getRveh_control_fec().toString());
/*  685:     */         }
/*  686:     */         else
/*  687:     */         {
/*  688: 676 */           errorDistancia++;
/*  689: 677 */           valor = 2;
/*  690: 678 */           valor2 += valor;
/*  691:     */         }
/*  692:     */       }
/*  693:     */       else
/*  694:     */       {
/*  695: 681 */         errorDistancia++;
/*  696: 682 */         valor = 2;
/*  697: 683 */         valor2 += valor;
/*  698:     */       }
/*  699: 685 */       if (vehiculo.getVehi_feccomp() != null)
/*  700:     */       {
/*  701: 686 */         if (vehiculo.getVehi_feccomp().compareTo(BigDecimal.ZERO) != 0)
/*  702:     */         {
/*  703: 687 */           FechaDistanciaCompraInicial = sdf.parse(vehiculo.getVehi_feccomp().toString());
/*  704:     */         }
/*  705:     */         else
/*  706:     */         {
/*  707: 689 */           errorDistancia++;
/*  708: 690 */           valor = 3;
/*  709: 691 */           valor2 += valor;
/*  710:     */         }
/*  711:     */       }
/*  712:     */       else
/*  713:     */       {
/*  714: 694 */         errorDistancia++;
/*  715: 695 */         valor = 3;
/*  716: 696 */         valor2 += valor;
/*  717:     */       }
/*  718: 699 */       switch (errorDistancia)
/*  719:     */       {
/*  720:     */       case 0: 
/*  721: 701 */         FechaDistanciaInicial = FechaDistanciaUltimoControl;
/*  722: 702 */         if (vehiculo.getVehi_fechaencero() != null) {
/*  723: 703 */           if (vehiculo.getVehi_fechaencero().compareTo(BigDecimal.ZERO) != 0)
/*  724:     */           {
/*  725: 705 */             FechaDistanciaCero = sdf.parse(vehiculo.getVehi_fechaencero().toString());
/*  726: 706 */             if (FechaDistanciaUltimoControl.compareTo(FechaDistanciaCero) == -1) {
/*  727: 707 */               opcion = 2;
/*  728:     */             } else {
/*  729: 709 */               opcion = 3;
/*  730:     */             }
/*  731:     */           }
/*  732:     */           else
/*  733:     */           {
/*  734: 712 */             opcion = 5;
/*  735:     */           }
/*  736:     */         }
/*  737: 715 */         break;
/*  738:     */       case 1: 
/*  739: 717 */         if (valor == 1)
/*  740:     */         {
/*  741: 718 */           FechaDistanciaInicial = FechaDistanciaUltimoControl;
/*  742:     */           
/*  743: 720 */           DistanciaInicial = revision.getRveh_control_kms();
/*  744: 721 */           if (vehiculo.getVehi_fechaencero() != null) {
/*  745: 722 */             if (vehiculo.getVehi_fechaencero().compareTo(BigDecimal.ZERO) != 0)
/*  746:     */             {
/*  747: 724 */               FechaDistanciaCero = sdf.parse(vehiculo.getVehi_fechaencero().toString());
/*  748: 725 */               if (FechaDistanciaUltimoControl.compareTo(FechaDistanciaCero) == -1) {
/*  749: 726 */                 opcion = 2;
/*  750:     */               } else {
/*  751: 728 */                 opcion = 3;
/*  752:     */               }
/*  753:     */             }
/*  754:     */             else
/*  755:     */             {
/*  756: 731 */               opcion = 5;
/*  757:     */             }
/*  758:     */           }
/*  759:     */         }
/*  760: 735 */         if (valor == 2)
/*  761:     */         {
/*  762: 736 */           FechaDistanciaInicial = FechaDistanciaOdometroInicial;
/*  763:     */           
/*  764: 738 */           DistanciaInicial = vehiculo.getVehi_kmsodometroinicial();
/*  765: 739 */           opcion = 1;
/*  766:     */         }
/*  767: 741 */         if (valor == 3)
/*  768:     */         {
/*  769: 742 */           FechaDistanciaInicial = FechaDistanciaUltimoControl;
/*  770:     */           
/*  771: 744 */           DistanciaInicial = revision.getRveh_control_kms();
/*  772: 745 */           if (vehiculo.getVehi_fechaencero() != null) {
/*  773: 746 */             if (vehiculo.getVehi_fechaencero().compareTo(BigDecimal.ZERO) != 0)
/*  774:     */             {
/*  775: 748 */               FechaDistanciaCero = sdf.parse(vehiculo.getVehi_fechaencero().toString());
/*  776: 749 */               if (FechaDistanciaUltimoControl.compareTo(FechaDistanciaCero) == -1) {
/*  777: 750 */                 opcion = 2;
/*  778:     */               } else {
/*  779: 752 */                 opcion = 3;
/*  780:     */               }
/*  781:     */             }
/*  782:     */             else
/*  783:     */             {
/*  784: 755 */               opcion = 5;
/*  785:     */             }
/*  786:     */           }
/*  787:     */         }
/*  788: 759 */         break;
/*  789:     */       case 2: 
/*  790: 761 */         if (valor2 == 3)
/*  791:     */         {
/*  792: 762 */           FechaDistanciaInicial = FechaDistanciaCompraInicial;
/*  793: 763 */           DistanciaInicial = BigDecimal.ZERO;
/*  794: 764 */           opcion = 4;
/*  795:     */         }
/*  796: 766 */         if (valor2 == 4)
/*  797:     */         {
/*  798: 767 */           FechaDistanciaInicial = FechaUltimoControl;
/*  799: 768 */           DistanciaInicial = revision.getRveh_control_kms();
/*  800: 769 */           if (vehiculo.getVehi_fechaencero() != null) {
/*  801: 770 */             if (vehiculo.getVehi_fechaencero().compareTo(BigDecimal.ZERO) != 0)
/*  802:     */             {
/*  803: 772 */               FechaDistanciaCero = sdf.parse(vehiculo.getVehi_fechaencero().toString());
/*  804: 773 */               if (FechaDistanciaUltimoControl.compareTo(FechaDistanciaCero) == -1) {
/*  805: 774 */                 opcion = 2;
/*  806:     */               } else {
/*  807: 776 */                 opcion = 3;
/*  808:     */               }
/*  809:     */             }
/*  810:     */             else
/*  811:     */             {
/*  812: 779 */               opcion = 5;
/*  813:     */             }
/*  814:     */           }
/*  815:     */         }
/*  816: 783 */         if (valor2 == 5)
/*  817:     */         {
/*  818: 784 */           FechaDistanciaInicial = FechaDistanciaOdometroInicial;
/*  819: 785 */           DistanciaInicial = vehiculo.getVehi_kmsodometroinicial();
/*  820: 786 */           opcion = 1;
/*  821:     */         }
/*  822: 788 */         break;
/*  823:     */       }
/*  824: 796 */       fechaSiguienteRevisionActualDistancia = getFechaDistanciaActual(FechaDistanciaInicial, DistanciaInicial, vehiculo, porcentaje, opcion, revision.getRveh_cada_cdm(), revision.getRveh_cada_cdk(), revision.getRveh_kmscero(), UltimaFecha);
/*  825:     */     }
/*  826: 798 */     if (revision.getRveh_alt_cod().equals(new BigDecimal("1")))
/*  827:     */     {
/*  828: 799 */       result = fechaSiguienteRevisionActualDistancia;
/*  829: 800 */       resultado = sdf.format(result) + "-" + revision.getRveh_alt_cod().toString();
/*  830:     */     }
/*  831: 802 */     if (revision.getRveh_alt_cod().equals(new BigDecimal("2")))
/*  832:     */     {
/*  833: 803 */       result = fechaSiguienteRevisionActualTiempo;
/*  834: 804 */       resultado = sdf.format(result) + "-" + revision.getRveh_alt_cod().toString();
/*  835:     */     }
/*  836: 806 */     if (revision.getRveh_alt_cod().equals(new BigDecimal("3"))) {
/*  837: 807 */       if (fechaSiguienteRevisionActualDistancia.compareTo(fechaSiguienteRevisionActualTiempo) == -1)
/*  838:     */       {
/*  839: 808 */         result = fechaSiguienteRevisionActualDistancia;
/*  840: 809 */         resultado = sdf.format(result) + "-1";
/*  841:     */       }
/*  842:     */       else
/*  843:     */       {
/*  844: 811 */         result = fechaSiguienteRevisionActualTiempo;
/*  845: 812 */         resultado = sdf.format(result) + "-2";
/*  846:     */       }
/*  847:     */     }
/*  848: 817 */     return resultado;
/*  849:     */   }
/*  850:     */   
/*  851:     */   private static Date getFechaRevision3(Vehiculos vehiculo, Date fechaUltimaRevision, BigDecimal distanciaUltimaRevision, BigDecimal frecuenciaDistancia, int frecuenciaTiempo, MantenimientoGeneral mantenimiento, List revisiones, int porcentaje, StringBuffer UltimaFecha)
/*  852:     */     throws Exception
/*  853:     */   {
/*  854: 820 */     Date result = null;
/*  855: 821 */     Date fechaActual = new Date();
/*  856: 822 */     Calendar calendar = new GregorianCalendar();
/*  857: 823 */     Calendar fechaSimulada = new GregorianCalendar();
/*  858: 824 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
/*  859: 825 */     Date fechaSiguienteRevisionFinal = null;
/*  860:     */     
/*  861: 827 */     Date fechaSiguienteRevisionActualTiempo = null;
/*  862: 828 */     Date fechaSiguienteRevisionActualDistancia = null;
/*  863:     */     
/*  864: 830 */     int x = 0;
/*  865: 831 */     BigDecimal[] curva = { vehiculo.getVehi_enero().divideToIntegralValue(new BigDecimal(31.0D)), 
/*  866: 832 */       vehiculo.getVehi_febrero().divideToIntegralValue(new BigDecimal(28.0D)), 
/*  867: 833 */       vehiculo.getVehi_marzo().divideToIntegralValue(new BigDecimal(31.0D)), 
/*  868: 834 */       vehiculo.getVehi_abril().divideToIntegralValue(new BigDecimal(30.0D)), 
/*  869: 835 */       vehiculo.getVehi_mayo().divideToIntegralValue(new BigDecimal(31.0D)), 
/*  870: 836 */       vehiculo.getVehi_junio().divideToIntegralValue(new BigDecimal(30.0D)), 
/*  871: 837 */       vehiculo.getVehi_julio().divideToIntegralValue(new BigDecimal(31.0D)), 
/*  872: 838 */       vehiculo.getVehi_agosto().divideToIntegralValue(new BigDecimal(31.0D)), 
/*  873: 839 */       vehiculo.getVehi_septiembre().divideToIntegralValue(new BigDecimal(30.0D)), 
/*  874: 840 */       vehiculo.getVehi_octubre().divideToIntegralValue(new BigDecimal(31.0D)), 
/*  875: 841 */       vehiculo.getVehi_noviembre().divideToIntegralValue(new BigDecimal(30.0D)), 
/*  876: 842 */       vehiculo.getVehi_diciembre().divideToIntegralValue(new BigDecimal(31.0D)) };
/*  877:     */     
/*  878:     */ 
/*  879: 845 */     Date fechaSiguienteRevisionTiempo = null;
/*  880: 846 */     Date fechaSiguienteRevisionDistancia = null;
/*  881: 847 */     Date fechaInicial = null;
/*  882: 848 */     int diasDiferencia = 10000000;
/*  883: 849 */    // BigDecimal fechaReferenciaA = new BigDecimal(sdf.format(fechaUltimaRevision));
/*  884: 850 */    // BigDecimal distanciaReferencia = distanciaUltimaRevision;
/*  885: 851 */   //  BigDecimal distanciaHoy = BigDecimal.ZERO;
/*  886: 852 */    // BigDecimal nuevaDistanciaReferencia = BigDecimal.ZERO;
/*  887: 853 */     Date hoy = new Date();
/*  888: 854 */    // BigDecimal Bhoy = new BigDecimal(sdf.format(hoy));
/*  889:     */     
/*  890: 856 */     int error = 0;
/*  891: 857 */     int valor = 0;
/*  892: 858 */     int valor2 = 0;
/*  893:     */     
/*  894:     */ 
/*  895: 861 */     Date FechaOdometroInicial = null;
/*  896: 862 */     Date FechaUltimoControl = null;
/*  897: 863 */     Date FechaCompraInicial = null;
/*  898: 864 */     Date FechaDistanciaOdometroInicial = null;
/*  899: 865 */     Date FechaDistanciaUltimoControl = null;
/*  900: 866 */     Date FechaDistanciaCompraInicial = null;
/*  901: 867 */     BigDecimal DistanciaInicial = BigDecimal.ZERO;
/*  902: 875 */     if ((mantenimiento.getMant_alt_cod().equals(new BigDecimal("2"))) || (mantenimiento.getMant_alt_cod().equals(new BigDecimal("3"))))
/*  903:     */     {
/*  904: 877 */       Date FechaTiempoInicial = null;
/*  905: 878 */       if (vehiculo.getVehi_kmsodometroinicial() != null) {
/*  906: 879 */         if (vehiculo.getVehi_kmsodometroinicial().compareTo(BigDecimal.ZERO) != 0)
/*  907:     */         {
/*  908: 880 */           FechaOdometroInicial = sdf.parse(vehiculo.getVehi_fechaodometroinicial().toString());
/*  909:     */         }
/*  910:     */         else
/*  911:     */         {
/*  912: 882 */           error++;
/*  913: 883 */           valor = 1;
/*  914: 884 */           valor2 += valor;
/*  915:     */         }
/*  916:     */       }
/*  917: 887 */       if (mantenimiento.getMant_control_fec() != null) {
/*  918: 888 */         if (mantenimiento.getMant_control_fec().compareTo(BigDecimal.ZERO) != 0)
/*  919:     */         {
/*  920: 889 */           FechaUltimoControl = sdf.parse(mantenimiento.getMant_control_fec().toString());
/*  921:     */         }
/*  922:     */         else
/*  923:     */         {
/*  924: 891 */           error++;
/*  925: 892 */           valor = 2;
/*  926: 893 */           valor2 += valor;
/*  927:     */         }
/*  928:     */       }
/*  929: 896 */       if (vehiculo.getVehi_feccomp() != null) {
/*  930: 897 */         if (vehiculo.getVehi_feccomp().compareTo(BigDecimal.ZERO) != 0)
/*  931:     */         {
/*  932: 898 */           FechaCompraInicial = sdf.parse(vehiculo.getVehi_feccomp().toString());
/*  933:     */         }
/*  934:     */         else
/*  935:     */         {
/*  936: 900 */           error++;
/*  937: 901 */           valor = 3;
/*  938: 902 */           valor2 += valor;
/*  939:     */         }
/*  940:     */       }
/*  941: 905 */       switch (error)
/*  942:     */       {
/*  943:     */       case 0: 
/*  944: 907 */         FechaTiempoInicial = FechaUltimoControl;
/*  945: 908 */         break;
/*  946:     */       case 1: 
/*  947: 910 */         if (valor == 1) {
/*  948: 911 */           FechaTiempoInicial = FechaUltimoControl;
/*  949:     */         }
/*  950: 914 */         if (valor == 2) {
/*  951: 915 */           FechaTiempoInicial = FechaOdometroInicial;
/*  952:     */         }
/*  953: 918 */         if (valor == 3) {
/*  954: 919 */           FechaTiempoInicial = FechaUltimoControl;
/*  955:     */         }
/*  956: 923 */         break;
/*  957:     */       case 2: 
/*  958: 925 */         if (valor2 == 3) {
/*  959: 926 */           FechaTiempoInicial = FechaCompraInicial;
/*  960:     */         }
/*  961: 928 */         if (valor2 == 4) {
/*  962: 929 */           FechaTiempoInicial = FechaUltimoControl;
/*  963:     */         }
/*  964: 931 */         if (valor2 == 5) {
/*  965: 932 */           FechaTiempoInicial = FechaOdometroInicial;
/*  966:     */         }
/*  967: 934 */         break;
/*  968:     */       }
/*  969: 944 */       fechaSiguienteRevisionActualTiempo = getFechaRevisionActual(FechaTiempoInicial, vehiculo, porcentaje, mantenimiento.getMant_cada_cdm(), mantenimiento.getMant_cada_cdk());
/*  970:     */     }
/*  971: 949 */     if ((mantenimiento.getMant_alt_cod().equals(new BigDecimal("1"))) || (mantenimiento.getMant_alt_cod().equals(new BigDecimal("3"))))
/*  972:     */     {
/*  973: 951 */       int opcion = 0;
/*  974: 952 */       int errorDistancia = 0;
/*  975: 953 */       valor2 = 0;
/*  976: 954 */       valor = 0;
/*  977:     */       
/*  978:     */ 
/*  979: 957 */       Date FechaDistanciaInicial = null;
/*  980: 958 */       Date FechaDistanciaCero = null;
/*  981: 960 */       if (vehiculo.getVehi_fechaodometroinicial() != null) {
/*  982: 961 */         if (vehiculo.getVehi_fechaodometroinicial().compareTo(BigDecimal.ZERO) != 0)
/*  983:     */         {
/*  984: 962 */           FechaDistanciaOdometroInicial = sdf.parse(vehiculo.getVehi_fechaodometroinicial().toString());
/*  985:     */         }
/*  986:     */         else
/*  987:     */         {
/*  988: 964 */           errorDistancia++;
/*  989: 965 */           valor = 1;
/*  990: 966 */           valor2 += valor;
/*  991:     */         }
/*  992:     */       }
/*  993: 969 */       if (mantenimiento.getMant_control_fec() != null) {
/*  994: 970 */         if (mantenimiento.getMant_control_fec().compareTo(BigDecimal.ZERO) != 0)
/*  995:     */         {
/*  996: 971 */           FechaDistanciaUltimoControl = sdf.parse(mantenimiento.getMant_control_fec().toString());
/*  997:     */         }
/*  998:     */         else
/*  999:     */         {
/* 1000: 973 */           errorDistancia++;
/* 1001: 974 */           valor = 2;
/* 1002: 975 */           valor2 += valor;
/* 1003:     */         }
/* 1004:     */       }
/* 1005: 979 */       if (vehiculo.getVehi_feccomp() != null) {
/* 1006: 980 */         if (vehiculo.getVehi_feccomp().compareTo(BigDecimal.ZERO) != 0)
/* 1007:     */         {
/* 1008: 981 */           FechaDistanciaCompraInicial = sdf.parse(vehiculo.getVehi_feccomp().toString());
/* 1009:     */         }
/* 1010:     */         else
/* 1011:     */         {
/* 1012: 983 */           errorDistancia++;
/* 1013: 984 */           valor = 3;
/* 1014: 985 */           valor2 += valor;
/* 1015:     */         }
/* 1016:     */       }
/* 1017: 988 */       switch (errorDistancia)
/* 1018:     */       {
/* 1019:     */       case 0: 
/* 1020: 990 */         FechaDistanciaInicial = FechaDistanciaUltimoControl;
/* 1021: 991 */         if (vehiculo.getVehi_fechaencero() != null) {
/* 1022: 992 */           if (vehiculo.getVehi_fechaencero().compareTo(BigDecimal.ZERO) != 0)
/* 1023:     */           {
/* 1024: 994 */             FechaDistanciaCero = sdf.parse(vehiculo.getVehi_fechaencero().toString());
/* 1025: 995 */             if (FechaDistanciaUltimoControl.compareTo(FechaDistanciaCero) == -1) {
/* 1026: 996 */               opcion = 2;
/* 1027:     */             } else {
/* 1028: 998 */               opcion = 3;
/* 1029:     */             }
/* 1030:     */           }
/* 1031:     */           else
/* 1032:     */           {
/* 1033:1001 */             opcion = 5;
/* 1034:     */           }
/* 1035:     */         }
/* 1036:1004 */         break;
/* 1037:     */       case 1: 
/* 1038:1006 */         if (valor == 1)
/* 1039:     */         {
/* 1040:1007 */           FechaDistanciaInicial = FechaDistanciaUltimoControl;
/* 1041:     */           
/* 1042:1009 */           DistanciaInicial = mantenimiento.getMant_control_kms();
/* 1043:1010 */           if (vehiculo.getVehi_fechaencero() != null) {
/* 1044:1011 */             if (vehiculo.getVehi_fechaencero().compareTo(BigDecimal.ZERO) != 0)
/* 1045:     */             {
/* 1046:1013 */               FechaDistanciaCero = sdf.parse(vehiculo.getVehi_fechaencero().toString());
/* 1047:1014 */               if (FechaDistanciaUltimoControl.compareTo(FechaDistanciaCero) == -1) {
/* 1048:1015 */                 opcion = 2;
/* 1049:     */               } else {
/* 1050:1017 */                 opcion = 3;
/* 1051:     */               }
/* 1052:     */             }
/* 1053:     */             else
/* 1054:     */             {
/* 1055:1020 */               opcion = 5;
/* 1056:     */             }
/* 1057:     */           }
/* 1058:     */         }
/* 1059:1024 */         if (valor == 2)
/* 1060:     */         {
/* 1061:1025 */           FechaDistanciaInicial = FechaDistanciaOdometroInicial;
/* 1062:     */           
/* 1063:1027 */           DistanciaInicial = vehiculo.getVehi_kmsodometroinicial();
/* 1064:1028 */           opcion = 1;
/* 1065:     */         }
/* 1066:1030 */         if (valor == 3)
/* 1067:     */         {
/* 1068:1031 */           FechaDistanciaInicial = FechaDistanciaUltimoControl;
/* 1069:     */           
/* 1070:1033 */           DistanciaInicial = mantenimiento.getMant_control_kms();
/* 1071:1034 */           if (vehiculo.getVehi_fechaencero() != null) {
/* 1072:1035 */             if (vehiculo.getVehi_fechaencero().compareTo(BigDecimal.ZERO) != 0)
/* 1073:     */             {
/* 1074:1037 */               FechaDistanciaCero = sdf.parse(vehiculo.getVehi_fechaencero().toString());
/* 1075:1038 */               if (FechaDistanciaUltimoControl.compareTo(FechaDistanciaCero) == -1) {
/* 1076:1039 */                 opcion = 2;
/* 1077:     */               } else {
/* 1078:1041 */                 opcion = 3;
/* 1079:     */               }
/* 1080:     */             }
/* 1081:     */             else
/* 1082:     */             {
/* 1083:1044 */               opcion = 5;
/* 1084:     */             }
/* 1085:     */           }
/* 1086:     */         }
/* 1087:1048 */         break;
/* 1088:     */       case 2: 
/* 1089:1050 */         if (valor2 == 3)
/* 1090:     */         {
/* 1091:1051 */           FechaDistanciaInicial = FechaDistanciaCompraInicial;
/* 1092:1052 */           DistanciaInicial = BigDecimal.ZERO;
/* 1093:1053 */           opcion = 4;
/* 1094:     */         }
/* 1095:1055 */         if (valor2 == 4)
/* 1096:     */         {
/* 1097:1056 */           FechaDistanciaInicial = FechaUltimoControl;
/* 1098:1057 */           DistanciaInicial = mantenimiento.getMant_control_kms();
/* 1099:1058 */           if (vehiculo.getVehi_fechaencero() != null) {
/* 1100:1059 */             if (vehiculo.getVehi_fechaencero().compareTo(BigDecimal.ZERO) != 0)
/* 1101:     */             {
/* 1102:1061 */               FechaDistanciaCero = sdf.parse(vehiculo.getVehi_fechaencero().toString());
/* 1103:1062 */               if (FechaDistanciaUltimoControl.compareTo(FechaDistanciaCero) == -1) {
/* 1104:1063 */                 opcion = 2;
/* 1105:     */               } else {
/* 1106:1065 */                 opcion = 3;
/* 1107:     */               }
/* 1108:     */             }
/* 1109:     */             else
/* 1110:     */             {
/* 1111:1068 */               opcion = 5;
/* 1112:     */             }
/* 1113:     */           }
/* 1114:     */         }
/* 1115:1072 */         if (valor2 == 5)
/* 1116:     */         {
/* 1117:1073 */           FechaDistanciaInicial = FechaDistanciaOdometroInicial;
/* 1118:1074 */           DistanciaInicial = vehiculo.getVehi_kmsodometroinicial();
/* 1119:1075 */           opcion = 1;
/* 1120:     */         }
/* 1121:1077 */         break;
/* 1122:     */       }
/* 1123:1085 */       fechaSiguienteRevisionActualDistancia = getFechaDistanciaActual(FechaDistanciaInicial, DistanciaInicial, vehiculo, porcentaje, opcion, mantenimiento.getMant_cada_cdm(), mantenimiento.getMant_cada_cdk(), vehiculo.getVehi_kmsencero(), UltimaFecha);
/* 1124:     */     }
/* 1125:1087 */     if (mantenimiento.getMant_alt_cod().equals(new BigDecimal("1"))) {
/* 1126:1088 */       result = fechaSiguienteRevisionActualDistancia;
/* 1127:     */     }
/* 1128:1090 */     if (mantenimiento.getMant_alt_cod().equals(new BigDecimal("2"))) {
/* 1129:1091 */       result = fechaSiguienteRevisionActualTiempo;
/* 1130:     */     }
/* 1131:1093 */     if (mantenimiento.getMant_alt_cod().equals(new BigDecimal("3"))) {
/* 1132:1094 */       if (fechaSiguienteRevisionActualDistancia.compareTo(fechaSiguienteRevisionActualTiempo) == -1) {
/* 1133:1095 */         result = fechaSiguienteRevisionActualDistancia;
/* 1134:     */       } else {
/* 1135:1097 */         result = fechaSiguienteRevisionActualTiempo;
/* 1136:     */       }
/* 1137:     */     }
/* 1138:1102 */     return result;
/* 1139:     */   }
/* 1140:     */   
/* 1141:     */   public static void setFechaRevision(Vehiculos vehiculo, MantenimientoGeneral mantenimientoGeneral, List revision, BigDecimal distanciaUltimaRevision, Date fechaUltimaRevision, StringBuffer UltimaFecha)
/* 1142:     */     throws Exception
/* 1143:     */   {
/* 1144:1105 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
/* 1145:1106 */     BigDecimal frecuenciaDistancia = mantenimientoGeneral.getMant_cada_cdk();
/* 1146:     */     
/* 1147:1108 */     int frecuenciaTiempo = mantenimientoGeneral.getMant_cada_cdm().intValue();
/* 1148:     */     
/* 1149:1110 */     mantenimientoGeneral.setMant_fecprox(new BigDecimal(sdf.format(getFechaRevision3(vehiculo, fechaUltimaRevision, distanciaUltimaRevision, frecuenciaDistancia, frecuenciaTiempo, mantenimientoGeneral, revision, 75, UltimaFecha))));
/* 1150:1111 */     mantenimientoGeneral.setMant_fecprox2(new BigDecimal(sdf.format(getFechaRevision3(vehiculo, fechaUltimaRevision, distanciaUltimaRevision, frecuenciaDistancia, frecuenciaTiempo, mantenimientoGeneral, revision, 90, UltimaFecha))));
/* 1151:1112 */     mantenimientoGeneral.setMant_fecprox3(new BigDecimal(sdf.format(getFechaRevision3(vehiculo, fechaUltimaRevision, distanciaUltimaRevision, frecuenciaDistancia, frecuenciaTiempo, mantenimientoGeneral, revision, 100, UltimaFecha))));
/* 1152:1113 */     BigDecimal nuevo4 = new BigDecimal(GestorFechasCompleto.fechaMasDias(mantenimientoGeneral.getMant_fecprox3().toString(), "yyyyMMdd", 15));
/* 1153:     */     
/* 1154:1115 */     int resta = restaFechas(mantenimientoGeneral.getMant_control_fec().toString().equals("0") ? "19010101" : mantenimientoGeneral.getMant_control_fec().toString(), nuevo4.toString());
/* 1155:1116 */     if (resta < 32) {
/* 1156:1117 */       nuevo4 = BigDecimal.ZERO;
/* 1157:     */     }
/* 1158:1119 */     mantenimientoGeneral.setMant_fecprox4(nuevo4);
/* 1159:     */   }
/* 1160:     */   
/* 1161:     */   public static void setFechaRevision(Vehiculos vehiculo, RevisionesVehiculo revisionVehiculo, BigDecimal distanciaUltimaRevision, Date fechaUltimaRevision, StringBuffer UltimaFecha)
/* 1162:     */     throws Exception
/* 1163:     */   {
/* 1164:1124 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
/* 1165:1125 */     String resultado = null;
/* 1166:1126 */     String alternativaSeleccionada = null;
/* 1167:1127 */     BigDecimal frecuenciaDistancia = revisionVehiculo.getRveh_cada_cdk();
/* 1168:     */     
/* 1169:1129 */     int frecuenciaTiempo = revisionVehiculo.getRveh_cada_cdm().intValue();
/* 1170:1130 */     BigDecimal alternativa = revisionVehiculo.getRveh_alt_cod();
/* 1171:1131 */     revisionVehiculo.setRveh_kmscerodiferencia(distanciaUltimaRevision);
/* 1172:     */     
/* 1173:     */ 
/* 1174:1134 */     System.out.println("Revision :" + revisionVehiculo.getRveh_cod());
                    System.out.println("fecha:" + fechaUltimaRevision);
                    System.out.println("fecha2:" + UltimaFecha);
                    
/* 1175:1135 */     resultado = getFechaRevision2(vehiculo, fechaUltimaRevision, distanciaUltimaRevision, frecuenciaDistancia, frecuenciaTiempo, 100, revisionVehiculo, UltimaFecha);
                    System.out.println("Revision2");
/* 1176:1136 */     alternativaSeleccionada = resultado.substring(resultado.length() - 1, resultado.length());
                    System.out.println("Revision3: " + resultado.substring(0, 8));
/* 1177:1137 */     BigDecimal nuevo3 = new BigDecimal(resultado.substring(0, 8));
                    System.out.println("Revision4");
/* 1178:1138 */     revisionVehiculo.setRveh_control_3(nuevo3);

/* 1179:1139 */     System.out.println("100% :" + nuevo3);
/* 1180:1141 */     if (alternativaSeleccionada != "2")
/* 1181:     */     {
/* 1182:1142 */       resultado = getFechaRevision2(vehiculo, fechaUltimaRevision, distanciaUltimaRevision, frecuenciaDistancia, frecuenciaTiempo, 75, revisionVehiculo, UltimaFecha);
/* 1183:1143 */       BigDecimal nuevo = new BigDecimal(resultado.substring(0, 8));
/* 1184:1144 */       revisionVehiculo.setRveh_control_1(nuevo);
/* 1185:1145 */       System.out.println("75% :" + nuevo);
/* 1186:1146 */       resultado = getFechaRevision2(vehiculo, fechaUltimaRevision, distanciaUltimaRevision, frecuenciaDistancia, frecuenciaTiempo, 90, revisionVehiculo, UltimaFecha);
/* 1187:1147 */       BigDecimal nuevo2 = new BigDecimal(resultado.substring(0, 8));
/* 1188:1148 */       revisionVehiculo.setRveh_control_2(nuevo2);
/* 1189:1149 */       System.out.println("90% :" + nuevo2);
/* 1190:     */     }
/* 1191:     */     else
/* 1192:     */     {
/* 1193:1151 */       BigDecimal nuevo = BigDecimal.ZERO;
/* 1194:1152 */       revisionVehiculo.setRveh_control_1(nuevo);
/* 1195:1153 */       System.out.println("75% :" + nuevo);
/* 1196:1154 */       BigDecimal nuevo2 = BigDecimal.ZERO;
/* 1197:1155 */       revisionVehiculo.setRveh_control_2(nuevo2);
/* 1198:1156 */       System.out.println("90% :" + nuevo2);
/* 1199:     */     }
/* 1200:1159 */     BigDecimal nuevo4 = new BigDecimal(GestorFechasCompleto.fechaMasDias(nuevo3.toString(), "yyyyMMdd", 15));
/* 1201:1160 */     int resta = restaFechas(revisionVehiculo.getRveh_control_fec().toString().equals("0") ? "19010101" : revisionVehiculo.getRveh_control_fec().toString(), nuevo4.toString());
/* 1202:1161 */     if (resta < 32) {
/* 1203:1162 */       nuevo4 = BigDecimal.ZERO;
/* 1204:     */     }
/* 1205:1164 */     revisionVehiculo.setRveh_control_4(nuevo4);
/* 1206:1165 */     System.out.println("15d :" + nuevo4);
/* 1207:     */   }
/* 1208:     */   
/* 1209:     */   public static BigDecimal getUltimaFecha(Vehiculos vehiculo, HttpServletRequest request, MantenimientoGeneral mantenimientoGeneral, List revisiones)
/* 1210:     */   {
/* 1211:1170 */     BigDecimal fechaReferenciaInicial = BigDecimal.ZERO;
/* 1212:1171 */     BigDecimal distanciaReferenciaInicial = BigDecimal.ZERO;
/* 1213:1172 */     if (vehiculo.getVehi_fechaodometro().compareTo(fechaReferenciaInicial) == 1)
/* 1214:     */     {
/* 1215:1173 */       fechaReferenciaInicial = vehiculo.getVehi_fechaodometro();
/* 1216:1174 */       distanciaReferenciaInicial = vehiculo.getVehi_kmsact();
/* 1217:     */     }
/* 1218:1176 */     if (mantenimientoGeneral.getMant_control_fec().compareTo(fechaReferenciaInicial) == 1)
/* 1219:     */     {
/* 1220:1177 */       fechaReferenciaInicial = mantenimientoGeneral.getMant_control_fec();
/* 1221:1178 */       distanciaReferenciaInicial = mantenimientoGeneral.getMant_control_kms();
/* 1222:     */     }
/* 1223:1180 */     for (Iterator revisionesIterator = revisiones.iterator(); revisionesIterator.hasNext();)
/* 1224:     */     {
/* 1225:1181 */       RevisionesVehiculo revisionVehiculo = (RevisionesVehiculo)revisionesIterator.next();
/* 1226:1182 */       if (revisionVehiculo.getRveh_control_fec().compareTo(fechaReferenciaInicial) == 1)
/* 1227:     */       {
/* 1228:1183 */         fechaReferenciaInicial = revisionVehiculo.getRveh_control_fec();
/* 1229:1184 */         distanciaReferenciaInicial = revisionVehiculo.getRveh_control_kms();
/* 1230:     */       }
/* 1231:     */     }
/* 1232:1188 */     return fechaReferenciaInicial;
/* 1233:     */   }
/* 1234:     */   
/* 1235:     */   public static BigDecimal getUltimaDistancia(Vehiculos vehiculo, HttpServletRequest request, MantenimientoGeneral mantenimientoGeneral, List revisiones)
/* 1236:     */   {
/* 1237:1193 */     BigDecimal fechaReferenciaInicial = BigDecimal.ZERO;
/* 1238:1194 */     BigDecimal distanciaReferenciaInicial = BigDecimal.ZERO;
/* 1239:1195 */     if (vehiculo.getVehi_fechaodometro().compareTo(fechaReferenciaInicial) == 1)
/* 1240:     */     {
/* 1241:1196 */       fechaReferenciaInicial = vehiculo.getVehi_fechaodometro();
/* 1242:1197 */       distanciaReferenciaInicial = vehiculo.getVehi_kmsact();
/* 1243:     */     }
/* 1244:1199 */     if (mantenimientoGeneral.getMant_control_fec().compareTo(fechaReferenciaInicial) == 1)
/* 1245:     */     {
/* 1246:1200 */       fechaReferenciaInicial = mantenimientoGeneral.getMant_control_fec();
/* 1247:1201 */       distanciaReferenciaInicial = mantenimientoGeneral.getMant_control_kms();
/* 1248:     */     }
/* 1249:1203 */     for (Iterator revisionesIterator = revisiones.iterator(); revisionesIterator.hasNext();)
/* 1250:     */     {
/* 1251:1204 */       RevisionesVehiculo revisionVehiculo = (RevisionesVehiculo)revisionesIterator.next();
/* 1252:1205 */       if (revisionVehiculo.getRveh_control_fec().compareTo(fechaReferenciaInicial) == 1)
/* 1253:     */       {
/* 1254:1206 */         fechaReferenciaInicial = revisionVehiculo.getRveh_control_fec();
/* 1255:1207 */         distanciaReferenciaInicial = revisionVehiculo.getRveh_control_kms();
/* 1256:     */       }
/* 1257:     */     }
/* 1258:1211 */     return distanciaReferenciaInicial;
/* 1259:     */   }
/* 1260:     */   
/* 1261:     */   public static StringBuffer getUltimaFecha2(Vehiculos vehiculo, HttpServletRequest request, MantenimientoGeneral mantenimientoGeneral, List revisiones)
/* 1262:     */   {
/* 1263:1215 */     StringBuffer otra = new StringBuffer();
/* 1264:1216 */     BigDecimal fechaReferenciaInicial = BigDecimal.ZERO;
/* 1265:1217 */     BigDecimal distanciaReferenciaInicial = BigDecimal.ZERO;
/* 1266:1218 */     if (vehiculo.getVehi_fechaodometro().compareTo(fechaReferenciaInicial) == 1)
/* 1267:     */     {
/* 1268:1219 */       fechaReferenciaInicial = vehiculo.getVehi_fechaodometro();
/* 1269:1220 */       distanciaReferenciaInicial = vehiculo.getVehi_kmsact();
/* 1270:     */     }
/* 1271:1222 */     if (mantenimientoGeneral.getMant_control_fec().compareTo(fechaReferenciaInicial) == 1)
/* 1272:     */     {
/* 1273:1223 */       fechaReferenciaInicial = mantenimientoGeneral.getMant_control_fec();
/* 1274:1224 */       distanciaReferenciaInicial = mantenimientoGeneral.getMant_control_kms();
/* 1275:     */     }
/* 1276:1226 */     for (Iterator revisionesIterator = revisiones.iterator(); revisionesIterator.hasNext();)
/* 1277:     */     {
/* 1278:1227 */       RevisionesVehiculo revisionVehiculo = (RevisionesVehiculo)revisionesIterator.next();
/* 1279:1228 */       if (revisionVehiculo.getRveh_control_fec().compareTo(fechaReferenciaInicial) == 1)
/* 1280:     */       {
/* 1281:1229 */         fechaReferenciaInicial = revisionVehiculo.getRveh_control_fec();
/* 1282:1230 */         distanciaReferenciaInicial = revisionVehiculo.getRveh_control_kms();
/* 1283:     */       }
/* 1284:     */     }
/* 1285:1233 */     otra.append(fechaReferenciaInicial.toString());
/* 1286:1234 */     otra.append("-");
/* 1287:1235 */     otra.append(distanciaReferenciaInicial);
/* 1288:1236 */     return otra;
/* 1289:     */   }
/* 1290:     */   
/* 1291:     */   public static String getDistanciaOdometroCero(Vehiculos vehiculo, Date fechaPreviaCero, BigDecimal distanciaUltimaRevision, Date fechaCero)
/* 1292:     */   {
/* 1293:1241 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
/* 1294:1242 */     Calendar fechaSimulada = new GregorianCalendar();
/* 1295:1243 */     BigDecimal[] curva = { vehiculo.getVehi_enero().divideToIntegralValue(new BigDecimal(31.0D)), 
/* 1296:1244 */       vehiculo.getVehi_febrero().divideToIntegralValue(new BigDecimal(28.0D)), 
/* 1297:1245 */       vehiculo.getVehi_marzo().divideToIntegralValue(new BigDecimal(31.0D)), 
/* 1298:1246 */       vehiculo.getVehi_abril().divideToIntegralValue(new BigDecimal(30.0D)), 
/* 1299:1247 */       vehiculo.getVehi_mayo().divideToIntegralValue(new BigDecimal(31.0D)), 
/* 1300:1248 */       vehiculo.getVehi_junio().divideToIntegralValue(new BigDecimal(30.0D)), 
/* 1301:1249 */       vehiculo.getVehi_julio().divideToIntegralValue(new BigDecimal(31.0D)), 
/* 1302:1250 */       vehiculo.getVehi_agosto().divideToIntegralValue(new BigDecimal(31.0D)), 
/* 1303:1251 */       vehiculo.getVehi_septiembre().divideToIntegralValue(new BigDecimal(30.0D)), 
/* 1304:1252 */       vehiculo.getVehi_octubre().divideToIntegralValue(new BigDecimal(31.0D)), 
/* 1305:1253 */       vehiculo.getVehi_noviembre().divideToIntegralValue(new BigDecimal(30.0D)), 
/* 1306:1254 */       vehiculo.getVehi_diciembre().divideToIntegralValue(new BigDecimal(31.0D)) };
/* 1307:     */     
/* 1308:     */ 
/* 1309:     */ 
/* 1310:     */ 
/* 1311:1259 */     fechaSimulada.setTime(fechaPreviaCero);
/* 1312:     */     
/* 1313:1261 */     int diasDiferencia = restaFechas(sdf.format(fechaPreviaCero), sdf.format(fechaCero));
/* 1314:1262 */     BigDecimal distanciaSimulada = distanciaUltimaRevision;
/* 1315:1264 */     for (int contador = 1; contador < diasDiferencia; contador++)
/* 1316:     */     {
/* 1317:1265 */       fechaSimulada.add(6, 1);
/* 1318:1266 */       distanciaSimulada = distanciaSimulada.add(curva[fechaSimulada.get(2)]);
/* 1319:     */     }
/* 1320:1269 */     return distanciaSimulada.toString();
/* 1321:     */   }
/* 1322:     */   
/* 1323:     */   public static Date getFechaDistancia(BigDecimal distanciaInicio1, Date FechaInicial, int porcentaje, StringBuffer UltimaFechaDistancia, BigDecimal[] curva, BigDecimal frecuenciaDistancia)
/* 1324:     */     throws Exception
/* 1325:     */   {
/* 1326:1278 */     int NoFrecuencias1 = 0;int NodiasdistanciaCumplida1 = 0;int tiempoDistanciaCumplida1 = 0;int tiempoDistanciaCumplida2 = 0;int distanciaCumplida1 = 0;
/* 1327:1279 */     int Siguiente_distancia = 0;
/* 1328:1280 */     BigDecimal distanciaAproximada = BigDecimal.ZERO;
/* 1329:1281 */     BigDecimal distanciaCumplida2 = BigDecimal.ZERO;
/* 1330:1282 */     BigDecimal distanciaSimulada = BigDecimal.ZERO;
/* 1331:1283 */     Calendar fechaSimulada = new GregorianCalendar();
/* 1332:1284 */     Calendar calendar = new GregorianCalendar();
/* 1333:1285 */     Boolean terminaciclo = Boolean.valueOf(false);
/* 1334:1286 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
/* 1335:1287 */     Date FechaActual = new Date();
/* 1336:1288 */     calendar.setTime(FechaActual);
/* 1337:1289 */     calendar.add(6, 1);
/* 1338:1290 */     FechaActual = calendar.getTime();
/* 1339:1291 */     BigDecimal fechaActualnow = new BigDecimal(sdf.format(FechaActual));
/* 1340:     */     
/* 1341:     */ 
/* 1342:1294 */     fechaSimulada.setTime(FechaInicial);
/* 1343:1295 */     calendar.setTime(FechaInicial);
/* 1344:1296 */     BigDecimal fechaSimuladaInicial = new BigDecimal(sdf.format(FechaInicial));
/* 1345:     */     
/* 1346:1298 */     BigDecimal UltimaFecha = new BigDecimal(UltimaFechaDistancia.substring(0, 8));
/* 1347:     */     
/* 1348:1300 */     BigDecimal UltimaDistancia = new BigDecimal(UltimaFechaDistancia.substring(9, UltimaFechaDistancia.length()));
/* 1349:1303 */     while ((fechaSimuladaInicial.compareTo(fechaActualnow) == -1) && (!terminaciclo.booleanValue()))
/* 1350:     */     {
/* 1351:1304 */       distanciaSimulada = distanciaSimulada.add(curva[fechaSimulada.get(2)]);
/* 1352:1305 */       distanciaInicio1 = distanciaInicio1.add(curva[fechaSimulada.get(2)]);
/* 1353:1306 */       fechaSimulada.add(6, 1);
/* 1354:1307 */       fechaSimuladaInicial = new BigDecimal(sdf.format(fechaSimulada.getTime()));
/* 1355:1308 */       NodiasdistanciaCumplida1++;
/* 1356:1309 */       if (fechaSimuladaInicial.compareTo(UltimaFecha) == -1) {
/* 1357:1311 */         if (distanciaSimulada.intValue() % frecuenciaDistancia.intValue() == 0)
/* 1358:     */         {
/* 1359:1312 */           NoFrecuencias1++;
/* 1360:1313 */           distanciaCumplida1 = distanciaSimulada.intValue();
/* 1361:1314 */           tiempoDistanciaCumplida1 = NodiasdistanciaCumplida1;
/* 1362:1315 */           calendar.setTime(fechaSimulada.getTime());
/* 1363:     */         }
/* 1364:     */       }
/* 1365:1318 */       if (fechaSimuladaInicial.compareTo(UltimaFecha) == 0)
/* 1366:     */       {
/* 1367:1319 */         distanciaAproximada = distanciaInicio1;
/* 1368:1320 */         Siguiente_distancia = distanciaInicio1.intValue() / frecuenciaDistancia.intValue();
/* 1369:1321 */         Siguiente_distancia++;
/* 1370:1322 */         tiempoDistanciaCumplida2 = 0;
/* 1371:     */       }
/* 1372:1324 */       if (fechaSimuladaInicial.compareTo(UltimaFecha) == 1)
/* 1373:     */       {
/* 1374:1325 */         int Parada_distancia = distanciaInicio1.intValue() / frecuenciaDistancia.intValue();
/* 1375:1326 */         if (Parada_distancia == Siguiente_distancia)
/* 1376:     */         {
/* 1377:1327 */           terminaciclo = Boolean.valueOf(true);
/* 1378:1328 */           NoFrecuencias1++;
/* 1379:1329 */           distanciaCumplida2 = distanciaInicio1;
/* 1380:1330 */           tiempoDistanciaCumplida2 = NodiasdistanciaCumplida1;
/* 1381:1331 */           calendar.setTime(fechaSimulada.getTime());
/* 1382:     */         }
/* 1383:     */       }
/* 1384:     */     }
/* 1385:1337 */     BigDecimal DistanciaReferencia = UltimaDistancia.add(distanciaCumplida2.subtract(distanciaAproximada));
/* 1386:1338 */     BigDecimal FechaReferencia = new BigDecimal(sdf.format(fechaSimulada.getTime()));
/* 1387:1339 */     BigDecimal FechaReferencia2 = new BigDecimal(sdf.format(fechaSimulada.getTime()));
/* 1388:1340 */     int NodiasdistanciaCumplida = 0;int tiempoDistanciaCumplida = 0;int distanciaCumplida = 0;int ValorPrevio = 0;int Valor = 0;
/* 1389:1341 */     Boolean termina = Boolean.valueOf(false);
/* 1390:1342 */     BigDecimal fecha = BigDecimal.ZERO;
/* 1391:1343 */     BigDecimal fechaanterior = BigDecimal.ZERO;
/* 1392:1344 */     Date hoy = new Date();
/* 1393:1345 */     Calendar fechaAnterior = new GregorianCalendar();
/* 1394:     */     
/* 1395:     */ 
/* 1396:1348 */     distanciaSimulada = BigDecimal.ZERO;
/* 1397:1349 */     if (FechaReferencia.compareTo(fechaActualnow) == -1)
/* 1398:     */     {
/* 1399:1350 */       BigDecimal NuevaDistanciaFrecuencia = DistanciaReferencia.add(frecuenciaDistancia);
/* 1400:1351 */       while (!termina.booleanValue())
/* 1401:     */       {
/* 1402:1352 */         DistanciaReferencia = DistanciaReferencia.add(curva[fechaSimulada.get(2)]);
/* 1403:1353 */         distanciaSimulada = distanciaSimulada.add(curva[fechaSimulada.get(2)]);
/* 1404:1354 */         fechaSimulada.add(6, 1);
/* 1405:1355 */         NodiasdistanciaCumplida++;
/* 1406:1356 */         BigDecimal bfechaSimulada = new BigDecimal(sdf.format(fechaSimulada.getTime()));
/* 1407:1357 */         if (bfechaSimulada.compareTo(fechaActualnow) < 1)
/* 1408:     */         {
/* 1409:1358 */           if (DistanciaReferencia.compareTo(NuevaDistanciaFrecuencia) == 1)
/* 1410:     */           {
/* 1411:1359 */             NuevaDistanciaFrecuencia = NuevaDistanciaFrecuencia.add(frecuenciaDistancia);
/* 1412:1360 */             fechaAnterior.setTime(fechaSimulada.getTime());
/* 1413:1361 */             fechaAnterior.add(6, -1);
/* 1414:1362 */             fechaanterior = new BigDecimal(sdf.format(fechaAnterior.getTime()));
/* 1415:     */           }
/* 1416:     */         }
/* 1417:1365 */         else if (DistanciaReferencia.compareTo(NuevaDistanciaFrecuencia) == 1)
/* 1418:     */         {
/* 1419:1366 */           fechaAnterior.setTime(fechaSimulada.getTime());
/* 1420:1367 */           fechaAnterior.add(6, -1);
/* 1421:1368 */           fecha = new BigDecimal(sdf.format(fechaAnterior.getTime()));
/* 1422:1369 */           if (fechaanterior == BigDecimal.ZERO)
/* 1423:     */           {
/* 1424:1370 */             BigDecimal frecuenciaDistancia2 = frecuenciaDistancia;
/* 1425:1371 */             while (frecuenciaDistancia2.compareTo(BigDecimal.ZERO) >= 0)
/* 1426:     */             {
/* 1427:1372 */               fechaAnterior.add(6, -1);
/* 1428:1373 */               DistanciaReferencia = DistanciaReferencia.subtract(curva[fechaAnterior.get(2)]);
/* 1429:1374 */               frecuenciaDistancia2 = frecuenciaDistancia2.subtract(curva[fechaAnterior.get(2)]);
/* 1430:     */             }
/* 1431:1376 */             fechaanterior = new BigDecimal(sdf.format(fechaAnterior.getTime()));
/* 1432:     */           }
/* 1433:1380 */           termina = Boolean.valueOf(true);
/* 1434:     */         }
/* 1435:     */       }
/* 1436:     */     }
/* 1437:     */     else
/* 1438:     */     {
/* 1439:1387 */       BigDecimal frecuenciaDistancia2 = frecuenciaDistancia;
/* 1440:1388 */       fechaSimulada.setTime(sdf.parse(FechaReferencia.toString()));
/* 1441:1389 */       while (frecuenciaDistancia2.compareTo(BigDecimal.ZERO) >= 0)
/* 1442:     */       {
/* 1443:1390 */         fechaSimulada.add(6, -1);
/* 1444:1391 */         DistanciaReferencia = DistanciaReferencia.subtract(curva[fechaAnterior.get(2)]);
/* 1445:1392 */         frecuenciaDistancia2 = frecuenciaDistancia2.subtract(curva[fechaAnterior.get(2)]);
/* 1446:     */       }
/* 1447:1394 */       fechaanterior = new BigDecimal(sdf.format(fechaSimulada.getTime()));
/* 1448:1395 */       fecha = FechaReferencia;
/* 1449:     */     }
/* 1450:1400 */     int restantes = restaFechas(fechaanterior.toString(), fecha.toString());
/* 1451:1401 */     if (fechaanterior != BigDecimal.ZERO) {
/* 1452:1402 */       calendar.setTime(sdf.parse(fechaanterior.toString()));
/* 1453:     */     }
/* 1454:1406 */     restantes = restantes * porcentaje / 100;
/* 1455:1407 */     for (int y = 1; y <= restantes; y++) {
/* 1456:1408 */       calendar.add(6, 1);
/* 1457:     */     }
/* 1458:1410 */     Date FechaActualDistancia = calendar.getTime();
/* 1459:     */     
/* 1460:1412 */     return FechaActualDistancia;
/* 1461:     */   }
/* 1462:     */   
/* 1463:     */   public static StringBuffer HallarDelta(BigDecimal FechaCero, BigDecimal DistanciaCero, BigDecimal distanciaInicio0, BigDecimal[] curva, Date fechaInicio0, BigDecimal frecuenciaDistancia)
/* 1464:     */   {
/* 1465:1416 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
/* 1466:1417 */     Boolean terminaciclo = Boolean.valueOf(false);
/* 1467:1418 */     Calendar fechaSimulada = new GregorianCalendar();
/* 1468:1419 */     Calendar calendar = new GregorianCalendar();
/* 1469:1420 */     BigDecimal distanciaSimulada = BigDecimal.ZERO;
/* 1470:1421 */     BigDecimal distanciaAproximada = BigDecimal.ZERO;
/* 1471:1422 */     BigDecimal distanciaCumplida2 = BigDecimal.ZERO;
/* 1472:1423 */     fechaSimulada.setTime(fechaInicio0);
/* 1473:1424 */     calendar.setTime(fechaInicio0);
/* 1474:     */     
/* 1475:1426 */     int Siguiente_distancia = 0;
/* 1476:1427 */     int NoFrecuencias1 = 0;int NodiasdistanciaCumplida1 = 0;int tiempoDistanciaCumplida1 = 0;int tiempoDistanciaCumplida2 = 0;int distanciaCumplida1 = 0;
/* 1477:1428 */     BigDecimal fechaSimuladaInicial = new BigDecimal(sdf.format(fechaInicio0));
/* 1478:1430 */     while ((fechaSimuladaInicial.compareTo(FechaCero) == -1) && (!terminaciclo.booleanValue()))
/* 1479:     */     {
/* 1480:1431 */       distanciaSimulada = distanciaSimulada.add(curva[fechaSimulada.get(2)]);
/* 1481:1432 */       DistanciaCero = DistanciaCero.add(curva[fechaSimulada.get(2)]);
/* 1482:1433 */       fechaSimulada.add(6, 1);
/* 1483:1434 */       fechaSimuladaInicial = new BigDecimal(sdf.format(fechaSimulada.getTime()));
/* 1484:1435 */       NodiasdistanciaCumplida1++;
/* 1485:1436 */       if ((fechaSimuladaInicial.compareTo(FechaCero) == -1) && 
/* 1486:1437 */         (distanciaSimulada.intValue() % frecuenciaDistancia.intValue() == 0))
/* 1487:     */       {
/* 1488:1438 */         NoFrecuencias1++;
/* 1489:1439 */         distanciaCumplida1 = distanciaSimulada.intValue();
/* 1490:1440 */         tiempoDistanciaCumplida1 = NodiasdistanciaCumplida1;
/* 1491:1441 */         calendar.setTime(fechaSimulada.getTime());
/* 1492:     */       }
/* 1493:1444 */       if (fechaSimuladaInicial.compareTo(FechaCero) == 0)
/* 1494:     */       {
/* 1495:1445 */         distanciaAproximada = DistanciaCero;
/* 1496:1446 */         Siguiente_distancia = DistanciaCero.intValue() / frecuenciaDistancia.intValue();
/* 1497:1447 */         Siguiente_distancia++;
/* 1498:1448 */         tiempoDistanciaCumplida2 = 0;
/* 1499:     */       }
/* 1500:1450 */       if (fechaSimuladaInicial.compareTo(FechaCero) == 1)
/* 1501:     */       {
/* 1502:1451 */         int Parada_distancia = DistanciaCero.intValue() / frecuenciaDistancia.intValue();
/* 1503:1452 */         if (Parada_distancia == Siguiente_distancia)
/* 1504:     */         {
/* 1505:1453 */           terminaciclo = Boolean.valueOf(true);
/* 1506:1454 */           NoFrecuencias1++;
/* 1507:1455 */           distanciaCumplida2 = DistanciaCero;
/* 1508:1456 */           tiempoDistanciaCumplida2 = NodiasdistanciaCumplida1;
/* 1509:1457 */           calendar.setTime(fechaSimulada.getTime());
/* 1510:     */         }
/* 1511:     */       }
/* 1512:     */     }
/* 1513:1464 */     DistanciaCero.add(distanciaCumplida2.subtract(distanciaAproximada));
/* 1514:1465 */     StringBuffer distanciaTiempo = new StringBuffer();
/* 1515:1466 */     distanciaTiempo.append(sdf.format(fechaSimulada.getTime()));
/* 1516:1467 */     distanciaTiempo.append("-");
/* 1517:1468 */     distanciaTiempo.append(DistanciaCero);
/* 1518:1469 */     return distanciaTiempo;
/* 1519:     */   }
/* 1520:     */   
/* 1521:     */   public static Date getFechaRevisionActual(Date FechaInicio, Vehiculos vehiculo, int porcentaje, BigDecimal frecuenciaTiempoRevision, BigDecimal frecuenciaDistanciaRevision)
/* 1522:     */     throws Exception
/* 1523:     */   {
/* 1524:1473 */     Date FechaActualTiempo = null;
/* 1525:1474 */     Date fechaSiguienteRevision = FechaInicio;
/* 1526:1475 */     Calendar calendar = new GregorianCalendar();
/* 1527:1476 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
/* 1528:1477 */     Date fechaActualNow = new Date();
/* 1529:1478 */     calendar.setTime(fechaActualNow);
/* 1530:1479 */     calendar.add(6, 1);
/* 1531:1480 */     fechaActualNow = calendar.getTime();
/* 1532:1481 */     int frecuenciaTiempo = frecuenciaTiempoRevision.intValue();
/* 1533:     */     
/* 1534:1483 */     calendar.setTime(FechaInicio);
/* 1535:1485 */     while ((fechaSiguienteRevision.compareTo(fechaActualNow) == -1) && 
/* 1536:1486 */       (frecuenciaTiempo != 0))
/* 1537:     */     {
/* 1538:1487 */       calendar.add(2, frecuenciaTiempo);
/* 1539:1488 */       fechaSiguienteRevision = calendar.getTime();
/* 1540:     */     }
/* 1541:1491 */     int frecuenciaTiempot = frecuenciaTiempo * -1;
/* 1542:1492 */     calendar.add(2, frecuenciaTiempot);
/* 1543:     */     
/* 1544:1494 */     Date fechaInicialD = calendar.getTime();
/* 1545:1495 */     int diasDiferencia = restaFechas(sdf.format(fechaInicialD), sdf.format(fechaSiguienteRevision));
/* 1546:1496 */     diasDiferencia = diasDiferencia * porcentaje / 100;
/* 1547:1497 */     calendar.add(6, diasDiferencia);
/* 1548:1498 */     FechaActualTiempo = calendar.getTime();
/* 1549:     */     
/* 1550:1500 */     return FechaActualTiempo;
/* 1551:     */   }
/* 1552:     */   
/* 1553:     */   public static Date getFechaDistanciaActual(Date FechaInicial, BigDecimal DistanciaInicio, Vehiculos vehiculo, int porcentaje, int opcion, BigDecimal frecuenciaTiempoRevision, BigDecimal frecuenciaDistanciaRevision, BigDecimal DistanciaCero, StringBuffer UltimaFecha)
/* 1554:     */     throws Exception
/* 1555:     */   {
/* 1556:1504 */     Date FechaActualDistancia = null;
/* 1557:1505 */     StringBuffer UltimaFechaDistancia = UltimaFecha;
/* 1558:     */     
/* 1559:1507 */     StringBuffer UltimaDelta = new StringBuffer();
/* 1560:1508 */     BigDecimal usuarioactual = BigDecimal.ZERO;
/* 1561:     */     
/* 1562:1510 */     BigDecimal user = vehiculo.getVehi_cod();
/* 1563:1511 */     if (user.compareTo(usuarioactual) != 0) {
/* 1564:1513 */       usuarioactual = user;
/* 1565:     */     }
/* 1566:1515 */     BigDecimal[] curva = { vehiculo.getVehi_enero().divideToIntegralValue(new BigDecimal(31.0D)), 
/* 1567:1516 */       vehiculo.getVehi_febrero().divideToIntegralValue(new BigDecimal(28.0D)), 
/* 1568:1517 */       vehiculo.getVehi_marzo().divideToIntegralValue(new BigDecimal(31.0D)), 
/* 1569:1518 */       vehiculo.getVehi_abril().divideToIntegralValue(new BigDecimal(30.0D)), 
/* 1570:1519 */       vehiculo.getVehi_mayo().divideToIntegralValue(new BigDecimal(31.0D)), 
/* 1571:1520 */       vehiculo.getVehi_junio().divideToIntegralValue(new BigDecimal(30.0D)), 
/* 1572:1521 */       vehiculo.getVehi_julio().divideToIntegralValue(new BigDecimal(31.0D)), 
/* 1573:1522 */       vehiculo.getVehi_agosto().divideToIntegralValue(new BigDecimal(31.0D)), 
/* 1574:1523 */       vehiculo.getVehi_septiembre().divideToIntegralValue(new BigDecimal(30.0D)), 
/* 1575:1524 */       vehiculo.getVehi_octubre().divideToIntegralValue(new BigDecimal(31.0D)), 
/* 1576:1525 */       vehiculo.getVehi_noviembre().divideToIntegralValue(new BigDecimal(30.0D)), 
/* 1577:1526 */       vehiculo.getVehi_diciembre().divideToIntegralValue(new BigDecimal(31.0D)) };
/* 1578:     */     
/* 1579:1528 */     BigDecimal frecuenciaDistancia = frecuenciaDistanciaRevision;
/* 1580:     */     
/* 1581:1530 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
/* 1582:1531 */     BigDecimal distanciaInicio = DistanciaInicio;
/* 1583:1532 */     String distance = "";
/* 1584:1535 */     switch (opcion)
/* 1585:     */     {
/* 1586:     */     case 1: 
/* 1587:1537 */       if ((vehiculo.getVehi_fechaencero() != BigDecimal.ZERO) || (vehiculo.getVehi_fechaencero() != null))
/* 1588:     */       {
/* 1589:1539 */         UltimaDelta = HallarDelta(vehiculo.getVehi_fechaencero(), DistanciaCero, distanciaInicio, curva, FechaInicial, frecuenciaDistancia);
/* 1590:1540 */         FechaInicial = sdf.parse(UltimaDelta.substring(0, 8));
/* 1591:     */         
/* 1592:1542 */         distance = UltimaDelta.substring(9, UltimaDelta.length());
/* 1593:1543 */         distanciaInicio = new BigDecimal(distance);
/* 1594:1544 */         FechaActualDistancia = getFechaDistancia(distanciaInicio, FechaInicial, porcentaje, UltimaFechaDistancia, curva, frecuenciaDistancia);
/* 1595:     */       }
/* 1596:     */       else
/* 1597:     */       {
/* 1598:1547 */         FechaActualDistancia = getFechaDistancia(distanciaInicio, FechaInicial, porcentaje, UltimaFechaDistancia, curva, frecuenciaDistancia);
/* 1599:     */       }
/* 1600:1548 */       break;
/* 1601:     */     case 2: 
/* 1602:1552 */       UltimaDelta = HallarDelta(vehiculo.getVehi_fechaencero(), DistanciaCero, distanciaInicio, curva, FechaInicial, frecuenciaDistancia);
/* 1603:1553 */       FechaInicial = sdf.parse(UltimaDelta.substring(0, 8));
/* 1604:1554 */       distance = UltimaDelta.substring(9, UltimaDelta.length());
/* 1605:1555 */       distanciaInicio = new BigDecimal(distance);
/* 1606:     */       
/* 1607:1557 */       FechaActualDistancia = getFechaDistancia(distanciaInicio, FechaInicial, porcentaje, UltimaFechaDistancia, curva, frecuenciaDistancia);
/* 1608:1558 */       break;
/* 1609:     */     case 3: 
/* 1610:1561 */       distanciaInicio = vehiculo.getVehi_fechaencero();
/* 1611:1562 */       FechaActualDistancia = getFechaDistancia(distanciaInicio, FechaInicial, porcentaje, UltimaFechaDistancia, curva, frecuenciaDistancia);
/* 1612:1563 */       break;
/* 1613:     */     case 4: 
/* 1614:1566 */       if ((vehiculo.getVehi_fechaencero() != BigDecimal.ZERO) || (vehiculo.getVehi_fechaencero() != null))
/* 1615:     */       {
/* 1616:1567 */         distanciaInicio = vehiculo.getVehi_fechaencero();
/* 1617:1568 */         FechaActualDistancia = getFechaDistancia(distanciaInicio, FechaInicial, porcentaje, UltimaFechaDistancia, curva, frecuenciaDistancia);
/* 1618:     */       }
/* 1619:     */       else
/* 1620:     */       {
/* 1621:1570 */         FechaActualDistancia = getFechaDistancia(distanciaInicio, FechaInicial, porcentaje, UltimaFechaDistancia, curva, frecuenciaDistancia);
/* 1622:     */       }
/* 1623:1572 */       break;
/* 1624:     */     case 5: 
/* 1625:1574 */       FechaActualDistancia = getFechaDistancia(distanciaInicio, FechaInicial, porcentaje, UltimaFechaDistancia, curva, frecuenciaDistancia);
/* 1626:     */     }
/* 1627:1582 */     return FechaActualDistancia;
/* 1628:     */   }
/* 1629:     */   
/* 1630:     */   public static StringBuffer getUltimaFechaPorUsuario(BigDecimal usuario, List revisiones)
/* 1631:     */     throws SQLException
/* 1632:     */   {
/* 1633:1587 */     StringBuffer otra = new StringBuffer();
/* 1634:1588 */     VehiculosDAO vehiDAO = new VehiculosDAO();
/* 1635:1589 */     Vehiculos vehiculo = vehiDAO.retrieveCarByUser(usuario);
/* 1636:1590 */     MantenimientoGeneralDAO mantenimientoGeneralDAO = new MantenimientoGeneralDAO();
/* 1637:1591 */     MantenimientoGeneral mantenimientoGeneral = mantenimientoGeneralDAO.retrive(vehiculo.getVehi_usuc_cod(), vehiculo.getVehi_cod());
/* 1638:     */     
/* 1639:1593 */     int c = 0;
/* 1640:     */     
/* 1641:1595 */     BigDecimal fechaReferenciaInicial = BigDecimal.ZERO;
/* 1642:1596 */     BigDecimal distanciaReferenciaInicial = BigDecimal.ZERO;
/* 1643:1597 */     if (vehiculo.getVehi_fechaodometro().compareTo(fechaReferenciaInicial) == 1)
/* 1644:     */     {
/* 1645:1598 */       fechaReferenciaInicial = vehiculo.getVehi_fechaodometro();
/* 1646:1599 */       distanciaReferenciaInicial = vehiculo.getVehi_kmsact();
/* 1647:     */     }
/* 1648:1601 */     if ((mantenimientoGeneral.getMant_control_fec() != null) && 
/* 1649:1602 */       (mantenimientoGeneral.getMant_control_fec().compareTo(fechaReferenciaInicial) == 1)) {
/* 1650:1603 */       fechaReferenciaInicial = mantenimientoGeneral.getMant_control_fec();
/* 1651:     */     }
/* 1652:1607 */     for (Iterator revisionesIterator = revisiones.iterator(); revisionesIterator.hasNext();)
/* 1653:     */     {
/* 1654:1608 */       RevisionesVehiculo revisionVehiculo = (RevisionesVehiculo)revisionesIterator.next();
/* 1655:1609 */       if (revisionVehiculo.getRveh_control_fec().compareTo(fechaReferenciaInicial) == 1)
/* 1656:     */       {
/* 1657:1610 */         fechaReferenciaInicial = revisionVehiculo.getRveh_control_fec();
/* 1658:1611 */         distanciaReferenciaInicial = revisionVehiculo.getRveh_control_kms();
/* 1659:     */       }
/* 1660:     */     }
/* 1661:1614 */     otra.append(fechaReferenciaInicial.toString());
/* 1662:1615 */     otra.append("-");
/* 1663:1616 */     otra.append(distanciaReferenciaInicial);
/* 1664:1617 */     return otra;
/* 1665:     */   }
/* 1666:     */ }



/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\

 * Qualified Name:     com.servidoctor.util.classes.ManejoFechas

 * JD-Core Version:    0.7.0.1

 */