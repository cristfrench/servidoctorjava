/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.LogosMayor;
/*   5:    */ import com.servidoctor.seguridad.dao.Compras_licenciasDAO;
/*   6:    */ import com.servidoctor.seguridad.dao.Compras_merchantDAO;
/*   7:    */ import com.servidoctor.seguridad.dao.UsuarioCarDAO;
/*   8:    */ import com.servidoctor.seguridad.dao.UsuarioFamilyDAO;
/*   9:    */ import com.servidoctor.seguridad.dao.UsuarioPetsDAO;
/*  10:    */ import com.servidoctor.seguridad.model.Compras_licencias;
/*  11:    */ import com.servidoctor.seguridad.model.Compras_merchant;
/*  12:    */ import com.servidoctor.util.classes.DBUtil;
/*  13:    */ import com.servidoctor.util.classes.InicializaData;
/*  14:    */ import java.math.BigDecimal;
/*  15:    */ import java.sql.Connection;
/*  16:    */ import java.sql.PreparedStatement;
/*  17:    */ import java.sql.ResultSet;
/*  18:    */ import java.sql.SQLException;
/*  19:    */ import java.util.ArrayList;
/*  20:    */ import java.util.List;
/*  21:    */ import javax.sql.DataSource;
/*  22:    */ 
/*  23:    */ public class LogosMayorDAO
/*  24:    */   extends DAO
/*  25:    */ {
/*  26:    */   public void update(LogosMayor data, String[] llaves)
/*  27:    */     throws SQLException
/*  28:    */   {
/*  29: 33 */     Connection conn = null;
/*  30: 34 */     PreparedStatement pstmt = null;
/*  31:    */     try
/*  32:    */     {
/*  33: 36 */       DBUtil db = new DBUtil();
/*  34: 37 */       conn = this.ds.getConnection();
/*  35: 38 */       conn.setAutoCommit(false);
/*  36: 39 */       String sql = db.creaSQLUPDATE(data, llaves);
/*  37: 40 */       pstmt = conn.prepareStatement(sql);
/*  38: 41 */       pstmt.executeUpdate();
/*  39: 42 */       close(pstmt);
/*  40: 43 */       conn.commit();
/*  41:    */     }
/*  42:    */     catch (SQLException e)
/*  43:    */     {
/*  44: 45 */       close(pstmt);
/*  45: 46 */       rollback(conn);
/*  46: 47 */       throw e;
/*  47:    */     }
/*  48:    */     finally
/*  49:    */     {
/*  50: 49 */       close(conn);
/*  51:    */     }
/*  52:    */   }
/*  53:    */   
/*  54:    */   public void updateLicencias(LogosMayor data, String condicionId)
/*  55:    */     throws SQLException
/*  56:    */   {
/*  57: 54 */     Connection conn = null;
/*  58: 55 */     PreparedStatement pstmt = null;
/*  59: 56 */     StringBuilder sb = null;
/*  60:    */     try
/*  61:    */     {
/*  62: 58 */       Compras_licenciasDAO compras_licenciasDAO = new Compras_licenciasDAO();
/*  63: 59 */       sb = new StringBuilder();
/*  64: 60 */       List<Compras_licencias> licencias = compras_licenciasDAO.list(data.getLogm_may_cod());
/*  65: 61 */       for (Compras_licencias compras_licencias : licencias) {
/*  66: 62 */         sb.append("'").append(compras_licencias.getCompras_licencias_codact()).append("'").append(',');
/*  67:    */       }
/*  68: 64 */       UsuarioFamilyDAO usuarioFamilyDAO = new UsuarioFamilyDAO();
/*  69: 65 */       usuarioFamilyDAO.updateLicenciasLogo(sb.substring(0, sb.length() - 1), condicionId, data.getLogm_cod());
/*  70:    */       
/*  71: 67 */       UsuarioPetsDAO usuarioPetsDAO = new UsuarioPetsDAO();
/*  72: 68 */       usuarioPetsDAO.updateLicenciasLogo(sb.substring(0, sb.length() - 1), condicionId, data.getLogm_cod());
/*  73:    */       
/*  74: 70 */       UsuarioCarDAO usuarioCarDAO = new UsuarioCarDAO();
/*  75: 71 */       usuarioCarDAO.updateLicenciasLogo(sb.substring(0, sb.length() - 1), condicionId, data.getLogm_cod());
/*  76:    */     }
/*  77:    */     catch (SQLException e)
/*  78:    */     {
/*  79: 74 */       close(pstmt);
/*  80: 75 */       rollback(conn);
/*  81: 76 */       throw e;
/*  82:    */     }
/*  83:    */     finally
/*  84:    */     {
/*  85: 78 */       close(conn);
/*  86:    */     }
/*  87:    */   }
/*  88:    */   
/*  89:    */   public List<LogosMayor> list(String logm_may_cod)
/*  90:    */     throws SQLException
/*  91:    */   {
/*  92: 83 */     ArrayList<LogosMayor> resultado = new ArrayList();
/*  93: 84 */     Connection conn = null;
/*  94: 85 */     PreparedStatement pstmt = null;
/*  95: 86 */     ResultSet rs = null;
/*  96:    */     try
/*  97:    */     {
/*  98: 88 */       conn = this.ds.getConnection();
/*  99: 89 */       String sql = "select distinct logm_cod, logm_may_cod, logm_nombre_grupo from logosmayor";
/* 100: 90 */       String where = " where logm_may_cod = ?";
/* 101: 91 */       pstmt = conn.prepareStatement(sql + where);
/* 102: 92 */       pstmt.setString(1, logm_may_cod);
/* 103: 93 */       rs = pstmt.executeQuery();
/* 104: 94 */       while (rs.next())
/* 105:    */       {
/* 106: 95 */         LogosMayor logosMayor = new LogosMayor();
/* 107: 96 */         InicializaData.inicializa(logosMayor.getClass(), logosMayor);
/* 108: 97 */         populate(logosMayor, rs);
/* 109: 98 */         resultado.add(logosMayor);
/* 110:    */       }
/* 111:100 */       close(rs);
/* 112:101 */       close(pstmt);
/* 113:    */     }
/* 114:    */     catch (SQLException e)
/* 115:    */     {
/* 116:103 */       close(rs);
/* 117:104 */       close(pstmt);
/* 118:105 */       rollback(conn);
/* 119:106 */       throw e;
/* 120:    */     }
/* 121:    */     finally
/* 122:    */     {
/* 123:108 */       close(conn);
/* 124:    */     }
/* 125:110 */     return resultado;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public List<LogosMayor> list(BigDecimal logm_cod, String logm_may_cod)
/* 129:    */     throws SQLException
/* 130:    */   {
/* 131:114 */     ArrayList<LogosMayor> resultado = new ArrayList();
/* 132:115 */     Connection conn = null;
/* 133:116 */     PreparedStatement pstmt = null;
/* 134:117 */     ResultSet rs = null;
/* 135:118 */     LogosMayor logosMayorS = new LogosMayor();
/* 136:    */     try
/* 137:    */     {
/* 138:120 */       conn = this.ds.getConnection();
/* 139:121 */       DBUtil db = new DBUtil();
/* 140:122 */       String sql = db.creaSQLSELECT(logosMayorS);
/* 141:123 */       String where = " where logm_cod = ? and logm_may_cod = ?";
/* 142:124 */       pstmt = conn.prepareStatement(sql + where);
/* 143:125 */       pstmt.setBigDecimal(1, logm_cod);
/* 144:126 */       pstmt.setString(2, logm_may_cod);
/* 145:127 */       rs = pstmt.executeQuery();
/* 146:128 */       while (rs.next())
/* 147:    */       {
/* 148:129 */         LogosMayor logosMayor = new LogosMayor();
/* 149:130 */         InicializaData.inicializa(logosMayor.getClass(), logosMayor);
/* 150:131 */         populate(logosMayor, rs);
/* 151:132 */         resultado.add(logosMayor);
/* 152:    */       }
/* 153:134 */       close(rs);
/* 154:135 */       close(pstmt);
/* 155:    */     }
/* 156:    */     catch (SQLException e)
/* 157:    */     {
/* 158:137 */       close(rs);
/* 159:138 */       close(pstmt);
/* 160:139 */       rollback(conn);
/* 161:140 */       throw e;
/* 162:    */     }
/* 163:    */     finally
/* 164:    */     {
/* 165:142 */       close(conn);
/* 166:    */     }
/* 167:144 */     return resultado;
/* 168:    */   }
/* 169:    */   
/* 170:    */   public LogosMayor retrieve(BigDecimal logm_cod, String logm_may_cod, BigDecimal logm_consecutivo)
/* 171:    */     throws SQLException
/* 172:    */   {
/* 173:148 */     LogosMayor logosMayor = new LogosMayor();
/* 174:149 */     Connection conn = null;
/* 175:150 */     PreparedStatement pstmt = null;
/* 176:151 */     ResultSet rs = null;
/* 177:152 */     LogosMayor logosMayorS = new LogosMayor();
/* 178:    */     try
/* 179:    */     {
/* 180:154 */       conn = this.ds.getConnection();
/* 181:155 */       DBUtil db = new DBUtil();
/* 182:156 */       String sql = db.creaSQLSELECT(logosMayorS);
/* 183:157 */       String where = " where logm_cod = ? and logm_may_cod = ? and logm_consecutivo = ?";
/* 184:158 */       pstmt = conn.prepareStatement(sql + where);
/* 185:159 */       pstmt.setBigDecimal(1, logm_cod);
/* 186:160 */       pstmt.setString(2, logm_may_cod);
/* 187:161 */       pstmt.setBigDecimal(3, logm_consecutivo);
/* 188:162 */       rs = pstmt.executeQuery();
/* 189:163 */       if (rs.next())
/* 190:    */       {
/* 191:164 */         InicializaData.inicializa(logosMayor.getClass(), logosMayor);
/* 192:165 */         populate(logosMayor, rs);
/* 193:    */       }
/* 194:167 */       close(rs);
/* 195:168 */       close(pstmt);
/* 196:    */     }
/* 197:    */     catch (SQLException e)
/* 198:    */     {
/* 199:170 */       close(rs);
/* 200:171 */       close(pstmt);
/* 201:172 */       rollback(conn);
/* 202:173 */       throw e;
/* 203:    */     }
/* 204:    */     finally
/* 205:    */     {
/* 206:175 */       close(conn);
/* 207:    */     }
/* 208:177 */     return logosMayor;
/* 209:    */   }
/* 210:    */   
/* 211:    */   public List<LogosMayor> retrieveByMayorCode(String logm_may_cod)
/* 212:    */     throws SQLException
/* 213:    */   {
/* 214:181 */     Connection conn = null;
/* 215:182 */     PreparedStatement pstmt = null;
/* 216:183 */     ResultSet rs = null;
/* 217:184 */     LogosMayor logosMayorS = new LogosMayor();
/* 218:185 */     List<LogosMayor> resultado = new ArrayList();
/* 219:    */     try
/* 220:    */     {
/* 221:187 */       conn = this.ds.getConnection();
/* 222:188 */       DBUtil db = new DBUtil();
/* 223:189 */       String sql = db.creaSQLSELECT(logosMayorS);
/* 224:190 */       String where = " where logm_may_cod = ?";
/* 225:191 */       pstmt = conn.prepareStatement(sql + where);
/* 226:192 */       pstmt.setString(1, logm_may_cod);
/* 227:193 */       rs = pstmt.executeQuery();
/* 228:194 */       while (rs.next())
/* 229:    */       {
/* 230:195 */         LogosMayor logosMayor = new LogosMayor();
/* 231:196 */         InicializaData.inicializa(logosMayor.getClass(), logosMayor);
/* 232:197 */         populate(logosMayor, rs);
/* 233:198 */         resultado.add(logosMayor);
/* 234:    */       }
/* 235:200 */       close(rs);
/* 236:201 */       close(pstmt);
/* 237:    */     }
/* 238:    */     catch (SQLException e)
/* 239:    */     {
/* 240:203 */       close(rs);
/* 241:204 */       close(pstmt);
/* 242:205 */       rollback(conn);
/* 243:206 */       throw e;
/* 244:    */     }
/* 245:    */     finally
/* 246:    */     {
/* 247:208 */       close(conn);
/* 248:    */     }
/* 249:210 */     return resultado;
/* 250:    */   }
/* 251:    */   
/* 252:    */   public LogosMayor search(String licencia, BigDecimal logm_cod)
/* 253:    */     throws SQLException
/* 254:    */   {
/* 255:214 */     LogosMayor logosMayor = new LogosMayor();
/* 256:215 */     Connection conn = null;
/* 257:216 */     PreparedStatement pstmt = null;
/* 258:217 */     ResultSet rs = null;
/* 259:218 */     LogosMayor logosMayorS = new LogosMayor();
/* 260:    */     try
/* 261:    */     {
/* 262:220 */       Compras_merchantDAO compras_merchantDAO = new Compras_merchantDAO();
/* 263:221 */       Compras_merchant compras_merchant = compras_merchantDAO.retrieve(licencia);
/* 264:222 */       conn = this.ds.getConnection();
/* 265:223 */       DBUtil db = new DBUtil();
/* 266:224 */       String sql = db.creaSQLSELECT(logosMayorS);
/* 267:225 */       String where = " where logm_may_cod = ( '" + compras_merchant.getCompras_merchant_cdgcmp() + "' ) and logm_cod = ?";
/* 268:226 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 269:227 */       pstmt.setBigDecimal(1, logm_cod);
/* 270:228 */       rs = pstmt.executeQuery();
/* 271:229 */       if (rs.next())
/* 272:    */       {
/* 273:230 */         InicializaData.inicializa(logosMayor.getClass(), logosMayor);
/* 274:231 */         populate(logosMayor, rs);
/* 275:    */       }
/* 276:233 */       close(rs);
/* 277:234 */       close(pstmt);
/* 278:    */     }
/* 279:    */     catch (SQLException e)
/* 280:    */     {
/* 281:236 */       close(rs);
/* 282:237 */       close(pstmt);
/* 283:238 */       rollback(conn);
/* 284:239 */       throw e;
/* 285:    */     }
/* 286:    */     finally
/* 287:    */     {
/* 288:241 */       close(conn);
/* 289:    */     }
/* 290:243 */     return logosMayor;
/* 291:    */   }
/* 292:    */   
/* 293:    */   public LogosMayor search(String licencia, BigDecimal logm_cod, String fechaActual)
/* 294:    */     throws SQLException
/* 295:    */   {
/* 296:247 */     LogosMayor logosMayor = new LogosMayor();
/* 297:248 */     Connection conn = null;
/* 298:249 */     PreparedStatement pstmt = null;
/* 299:250 */     ResultSet rs = null;
/* 300:251 */     LogosMayor logosMayorS = new LogosMayor();
/* 301:    */     try
/* 302:    */     {
/* 303:253 */       Compras_merchantDAO compras_merchantDAO = new Compras_merchantDAO();
/* 304:254 */       Compras_merchant compras_merchant = compras_merchantDAO.retrieve(licencia);
/* 305:255 */       conn = this.ds.getConnection();
/* 306:256 */       DBUtil db = new DBUtil();
/* 307:257 */       String sql = db.creaSQLSELECT(logosMayorS);
/* 308:258 */       String where = " where logm_may_cod = ( '" + compras_merchant.getCompras_merchant_cdgcmp() + "' ) and logm_cod= ? and ? between logm_fecini and logm_fecfin";
/* 309:259 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 310:260 */       pstmt.setBigDecimal(1, logm_cod);
/* 311:261 */       pstmt.setString(2, fechaActual);
/* 312:262 */       rs = pstmt.executeQuery();
/* 313:263 */       while (rs.next())
/* 314:    */       {
/* 315:264 */         InicializaData.inicializa(logosMayor.getClass(), logosMayor);
/* 316:265 */         populate(logosMayor, rs);
/* 317:    */       }
/* 318:267 */       close(rs);
/* 319:268 */       close(pstmt);
/* 320:    */     }
/* 321:    */     catch (SQLException e)
/* 322:    */     {
/* 323:270 */       close(rs);
/* 324:271 */       close(pstmt);
/* 325:272 */       rollback(conn);
/* 326:273 */       throw e;
/* 327:    */     }
/* 328:    */     finally
/* 329:    */     {
/* 330:275 */       close(conn);
/* 331:    */     }
/* 332:277 */     return logosMayor;
/* 333:    */   }
/* 334:    */   
/* 335:    */   public synchronized void insert(LogosMayor data)
/* 336:    */     throws SQLException
/* 337:    */   {
/* 338:281 */     Connection conn = null;
/* 339:282 */     PreparedStatement pstmt = null;
/* 340:    */     
/* 341:284 */     ResultSet rs = null;
/* 342:    */     try
/* 343:    */     {
/* 344:286 */       int id = 0;
/* 345:287 */       DBUtil db = new DBUtil();
/* 346:    */       
/* 347:289 */       conn = this.ds.getConnection();
/* 348:290 */       conn.setAutoCommit(false);
/* 349:291 */       id = getConsecutivo(conn, data);
/* 350:292 */       data.setLogm_consecutivo(new BigDecimal(id));
/* 351:293 */       String sql = db.creaSQLINSERT(data);
/* 352:    */       
/* 353:295 */       pstmt = conn.prepareStatement(sql);
/* 354:296 */       pstmt.executeUpdate();
/* 355:297 */       pstmt.close();
/* 356:298 */       conn.commit();
/* 357:    */     }
/* 358:    */     catch (SQLException sqle)
/* 359:    */     {
/* 360:300 */       close(rs);
/* 361:301 */       close(pstmt);
/* 362:302 */       rollback(conn);
/* 363:303 */       throw sqle;
/* 364:    */     }
/* 365:    */     finally
/* 366:    */     {
/* 367:305 */       close(rs);
/* 368:306 */       close(pstmt);
/* 369:307 */       close(conn);
/* 370:    */     }
/* 371:    */   }
/* 372:    */   
/* 373:    */   public synchronized void insertGrupo(LogosMayor data)
/* 374:    */     throws SQLException
/* 375:    */   {
/* 376:312 */     Connection conn = null;
/* 377:313 */     PreparedStatement pstmt = null;
/* 378:    */     
/* 379:315 */     ResultSet rs = null;
/* 380:    */     try
/* 381:    */     {
/* 382:317 */       int id = 0;
/* 383:318 */       DBUtil db = new DBUtil();
/* 384:    */       
/* 385:320 */       conn = this.ds.getConnection();
/* 386:321 */       conn.setAutoCommit(false);
/* 387:322 */       id = getReqMax(conn, data);
/* 388:323 */       data.setLogm_consecutivo(new BigDecimal(1.0D));
/* 389:324 */       data.setLogm_cod(new BigDecimal(id));
/* 390:325 */       String sql = db.creaSQLINSERT(data);
/* 391:    */       
/* 392:327 */       pstmt = conn.prepareStatement(sql);
/* 393:328 */       pstmt.executeUpdate();
/* 394:329 */       pstmt.close();
/* 395:330 */       conn.commit();
/* 396:    */     }
/* 397:    */     catch (SQLException sqle)
/* 398:    */     {
/* 399:332 */       close(rs);
/* 400:333 */       close(pstmt);
/* 401:334 */       rollback(conn);
/* 402:335 */       throw sqle;
/* 403:    */     }
/* 404:    */     finally
/* 405:    */     {
/* 406:337 */       close(rs);
/* 407:338 */       close(pstmt);
/* 408:339 */       close(conn);
/* 409:    */     }
/* 410:    */   }
/* 411:    */   
/* 412:    */   public void delete(LogosMayor data)
/* 413:    */     throws SQLException
/* 414:    */   {
/* 415:344 */     Connection conn = null;
/* 416:345 */     PreparedStatement pstmt = null;
/* 417:    */     try
/* 418:    */     {
/* 419:347 */       conn = this.ds.getConnection();
/* 420:348 */       conn.setAutoCommit(false);
/* 421:349 */       String sql = "DELETE FROM sdoctor.logosmayor WHERE logm_cod = ? and logm_may_cod = ? and logm_consecutivo = ?";
/* 422:350 */       pstmt = conn.prepareStatement(sql);
/* 423:351 */       pstmt.setBigDecimal(1, data.getLogm_cod());
/* 424:352 */       pstmt.setString(2, data.getLogm_may_cod());
/* 425:353 */       pstmt.setBigDecimal(3, data.getLogm_consecutivo());
/* 426:354 */       pstmt.executeUpdate();
/* 427:355 */       close(pstmt);
/* 428:356 */       conn.commit();
/* 429:    */     }
/* 430:    */     catch (SQLException e)
/* 431:    */     {
/* 432:358 */       close(pstmt);
/* 433:359 */       rollback(conn);
/* 434:360 */       throw e;
/* 435:    */     }
/* 436:    */     finally
/* 437:    */     {
/* 438:362 */       close(conn);
/* 439:    */     }
/* 440:    */   }
/* 441:    */   
/* 442:    */   public void deleteGrupo(LogosMayor data)
/* 443:    */     throws SQLException
/* 444:    */   {
/* 445:367 */     Connection conn = null;
/* 446:368 */     PreparedStatement pstmt = null;
/* 447:    */     try
/* 448:    */     {
/* 449:370 */       conn = this.ds.getConnection();
/* 450:371 */       conn.setAutoCommit(false);
/* 451:372 */       String sql = "DELETE FROM sdoctor.logosmayor WHERE logm_cod = ? and logm_may_cod = ?";
/* 452:373 */       pstmt = conn.prepareStatement(sql);
/* 453:374 */       pstmt.setBigDecimal(1, data.getLogm_cod());
/* 454:375 */       pstmt.setString(2, data.getLogm_may_cod());
/* 455:376 */       pstmt.executeUpdate();
/* 456:377 */       close(pstmt);
/* 457:378 */       conn.commit();
/* 458:    */     }
/* 459:    */     catch (SQLException e)
/* 460:    */     {
/* 461:380 */       close(pstmt);
/* 462:381 */       rollback(conn);
/* 463:382 */       throw e;
/* 464:    */     }
/* 465:    */     finally
/* 466:    */     {
/* 467:384 */       close(conn);
/* 468:    */     }
/* 469:    */   }
/* 470:    */   
/* 471:    */   public void deleteAll(BigDecimal logm_may_cod)
/* 472:    */     throws SQLException
/* 473:    */   {
/* 474:389 */     Connection conn = null;
/* 475:390 */     PreparedStatement pstmt = null;
/* 476:    */     try
/* 477:    */     {
/* 478:392 */       conn = this.ds.getConnection();
/* 479:393 */       conn.setAutoCommit(false);
/* 480:394 */       String sql = "DELETE FROM sdoctor.logosmayor WHERE logm_may_cod=?";
/* 481:395 */       pstmt = conn.prepareStatement(sql);
/* 482:396 */       pstmt.setBigDecimal(1, logm_may_cod);
/* 483:397 */       pstmt.executeUpdate();
/* 484:398 */       close(pstmt);
/* 485:399 */       conn.commit();
/* 486:    */     }
/* 487:    */     catch (SQLException e)
/* 488:    */     {
/* 489:401 */       close(pstmt);
/* 490:402 */       rollback(conn);
/* 491:403 */       throw e;
/* 492:    */     }
/* 493:    */     finally
/* 494:    */     {
/* 495:405 */       close(conn);
/* 496:    */     }
/* 497:    */   }
/* 498:    */   
/* 499:    */   private int getReqMax(Connection conn, LogosMayor data)
/* 500:    */   {
/* 501:410 */     PreparedStatement pstmt = null;
/* 502:411 */     ResultSet rs = null;
/* 503:412 */     int id = 0;
/* 504:    */     try
/* 505:    */     {
/* 506:414 */       String sqlid = "Select max(logm_cod) from sdoctor.logosmayor where logm_may_cod = ?";
/* 507:    */       
/* 508:416 */       pstmt = conn.prepareStatement(sqlid);
/* 509:417 */       pstmt.setString(1, data.getLogm_may_cod());
/* 510:418 */       rs = pstmt.executeQuery();
/* 511:419 */       if ((rs != null) && (rs.next())) {
/* 512:420 */         id = rs.getInt(1) + 1;
/* 513:    */       } else {
/* 514:422 */         id++;
/* 515:    */       }
/* 516:    */     }
/* 517:    */     catch (SQLException e)
/* 518:    */     {
/* 519:426 */       close(rs);
/* 520:427 */       close(pstmt);
/* 521:428 */       rollback(conn);
/* 522:429 */       e.printStackTrace();
/* 523:    */     }
/* 524:    */     finally
/* 525:    */     {
/* 526:431 */       close(rs);
/* 527:432 */       close(pstmt);
/* 528:    */     }
/* 529:434 */     return id;
/* 530:    */   }
/* 531:    */   
/* 532:    */   private int getConsecutivo(Connection conn, LogosMayor data)
/* 533:    */   {
/* 534:438 */     PreparedStatement pstmt = null;
/* 535:439 */     ResultSet rs = null;
/* 536:440 */     int id = 0;
/* 537:    */     try
/* 538:    */     {
/* 539:442 */       String sqlid = "Select max(logm_consecutivo) from sdoctor.logosmayor where logm_cod = ? and logm_may_cod = ?";
/* 540:    */       
/* 541:444 */       pstmt = conn.prepareStatement(sqlid);
/* 542:445 */       pstmt.setBigDecimal(1, data.getLogm_cod());
/* 543:446 */       pstmt.setString(2, data.getLogm_may_cod());
/* 544:447 */       rs = pstmt.executeQuery();
/* 545:448 */       if ((rs != null) && (rs.next())) {
/* 546:449 */         id = rs.getInt(1) + 1;
/* 547:    */       } else {
/* 548:451 */         id++;
/* 549:    */       }
/* 550:    */     }
/* 551:    */     catch (SQLException e)
/* 552:    */     {
/* 553:455 */       close(rs);
/* 554:456 */       close(pstmt);
/* 555:457 */       rollback(conn);
/* 556:458 */       e.printStackTrace();
/* 557:    */     }
/* 558:    */     finally
/* 559:    */     {
/* 560:460 */       close(rs);
/* 561:461 */       close(pstmt);
/* 562:    */     }
/* 563:463 */     return id;
/* 564:    */   }
/* 565:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.LogosMayorDAO
 * JD-Core Version:    0.7.0.1
 */