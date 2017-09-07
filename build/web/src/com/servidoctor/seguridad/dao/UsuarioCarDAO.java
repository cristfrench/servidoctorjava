/*   1:    */ package com.servidoctor.seguridad.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.seguridad.model.UsuarioCar;
/*   5:    */ import com.servidoctor.util.classes.DBUtil;
/*   6:    */ import com.servidoctor.util.classes.InicializaData;
/*   7:    */ import java.math.BigDecimal;
/*   8:    */ import java.sql.Connection;
/*   9:    */ import java.sql.PreparedStatement;
/*  10:    */ import java.sql.ResultSet;
/*  11:    */ import java.sql.SQLException;
/*  12:    */ import java.util.ArrayList;
/*  13:    */ import java.util.List;
/*  14:    */ import java.util.ResourceBundle;
/*  15:    */ import javax.sql.DataSource;
/*  16:    */ 
/*  17:    */ public class UsuarioCarDAO
/*  18:    */   extends DAO
/*  19:    */ {
/*  20: 19 */   private static final ResourceBundle prop = ResourceBundle.getBundle("com.servidoctor.resources.Config");
/*  21:    */   
/*  22:    */   public UsuarioCarDAO()
/*  23:    */   {
/*  24: 22 */     super(prop.getString("jndi.central.name"));
/*  25:    */   }
/*  26:    */   
/*  27:    */   public void update(UsuarioCar data, String[] llaves)
/*  28:    */     throws SQLException
/*  29:    */   {
/*  30: 26 */     Connection conn = null;
/*  31: 27 */     PreparedStatement pstmt = null;
/*  32:    */     try
/*  33:    */     {
/*  34: 29 */       DBUtil db = new DBUtil();
/*  35: 30 */       conn = this.ds.getConnection();
/*  36: 31 */       conn.setAutoCommit(false);
/*  37: 32 */       String sql = db.creaSQLUPDATE(data, llaves);
/*  38: 33 */       pstmt = conn.prepareStatement(sql);
/*  39: 34 */       pstmt.executeUpdate();
/*  40: 35 */       close(pstmt);
/*  41: 36 */       conn.commit();
/*  42:    */     }
/*  43:    */     catch (SQLException e)
/*  44:    */     {
/*  45: 38 */       close(pstmt);
/*  46: 39 */       rollback(conn);
/*  47: 40 */       throw e;
/*  48:    */     }
/*  49:    */     finally
/*  50:    */     {
/*  51: 42 */       close(conn);
/*  52:    */     }
/*  53:    */   }
/*  54:    */   
/*  55:    */   public UsuarioCar retrive(BigDecimal usuc_cod)
/*  56:    */     throws SQLException
/*  57:    */   {
/*  58: 47 */     UsuarioCar usuarioCar = new UsuarioCar();
/*  59: 48 */     Connection conn = null;
/*  60: 49 */     PreparedStatement pstmt = null;
/*  61: 50 */     ResultSet rs = null;
/*  62: 51 */     UsuarioCar usuarioCarS = new UsuarioCar();
/*  63:    */     try
/*  64:    */     {
/*  65: 53 */       conn = this.ds.getConnection();
/*  66: 54 */       DBUtil db = new DBUtil();
/*  67: 55 */       String sql = db.creaSQLSELECT(usuarioCarS);
/*  68: 56 */       String where = " where usuc_cod = ?";
/*  69: 57 */       pstmt = conn.prepareStatement(sql + where);
/*  70: 58 */       pstmt.setBigDecimal(1, usuc_cod);
/*  71: 59 */       rs = pstmt.executeQuery();
/*  72: 60 */       if (rs.next())
/*  73:    */       {
/*  74: 61 */         InicializaData.inicializa(usuarioCar.getClass(), usuarioCar);
/*  75: 62 */         populate(usuarioCar, rs);
/*  76:    */       }
/*  77: 64 */       close(rs);
/*  78: 65 */       close(pstmt);
/*  79:    */     }
/*  80:    */     catch (SQLException e)
/*  81:    */     {
/*  82: 67 */       close(rs);
/*  83: 68 */       close(pstmt);
/*  84: 69 */       rollback(conn);
/*  85: 70 */       throw e;
/*  86:    */     }
/*  87:    */     finally
/*  88:    */     {
/*  89: 72 */       close(conn);
/*  90:    */     }
/*  91: 74 */     return usuarioCar;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public UsuarioCar login(String usuc_usuario, String usuc_clave)
/*  95:    */     throws SQLException
/*  96:    */   {
/*  97: 78 */     UsuarioCar usuarioCar = new UsuarioCar();
/*  98: 79 */     Connection conn = null;
/*  99: 80 */     PreparedStatement pstmt = null;
/* 100: 81 */     ResultSet rs = null;
/* 101: 82 */     UsuarioCar usuarioCarS = new UsuarioCar();
/* 102:    */     try
/* 103:    */     {
/* 104: 84 */       conn = this.ds.getConnection();
/* 105: 85 */       DBUtil db = new DBUtil();
/* 106: 86 */       String sql = db.creaSQLSELECT(usuarioCarS);
/* 107: 87 */       String where = " where usuc_usuario = ? and usuc_clave = ?";
/* 108: 88 */       pstmt = conn.prepareStatement(sql + where);
/* 109: 89 */       pstmt.setString(1, usuc_usuario);
/* 110: 90 */       pstmt.setString(2, usuc_clave);
/* 111: 91 */       rs = pstmt.executeQuery();
/* 112: 92 */       if (rs.next())
/* 113:    */       {
/* 114: 93 */         InicializaData.inicializa(usuarioCar.getClass(), usuarioCar);
/* 115: 94 */         populate(usuarioCar, rs);
/* 116:    */       }
/* 117: 96 */       close(rs);
/* 118: 97 */       close(pstmt);
/* 119:    */     }
/* 120:    */     catch (SQLException e)
/* 121:    */     {
/* 122: 99 */       close(rs);
/* 123:100 */       close(pstmt);
/* 124:101 */       rollback(conn);
/* 125:102 */       throw e;
/* 126:    */     }
/* 127:    */     finally
/* 128:    */     {
/* 129:104 */       close(conn);
/* 130:    */     }
/* 131:106 */     return usuarioCar;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public UsuarioCar login(String usuc_usuario)
/* 135:    */     throws SQLException
/* 136:    */   {
/* 137:110 */     UsuarioCar usuarioCar = new UsuarioCar();
/* 138:111 */     Connection conn = null;
/* 139:112 */     PreparedStatement pstmt = null;
/* 140:113 */     ResultSet rs = null;
/* 141:114 */     UsuarioCar usuarioCarS = new UsuarioCar();
/* 142:    */     try
/* 143:    */     {
/* 144:116 */       conn = this.ds.getConnection();
/* 145:117 */       DBUtil db = new DBUtil();
/* 146:118 */       String sql = db.creaSQLSELECT(usuarioCarS);
/* 147:119 */       String where = " where usuc_usuario = ? ";
/* 148:120 */       pstmt = conn.prepareStatement(sql + where);
/* 149:121 */       pstmt.setString(1, usuc_usuario);
/* 150:122 */       rs = pstmt.executeQuery();
/* 151:123 */       if (rs.next())
/* 152:    */       {
/* 153:124 */         InicializaData.inicializa(usuarioCar.getClass(), usuarioCar);
/* 154:125 */         populate(usuarioCar, rs);
/* 155:    */       }
/* 156:127 */       close(rs);
/* 157:128 */       close(pstmt);
/* 158:    */     }
/* 159:    */     catch (SQLException e)
/* 160:    */     {
/* 161:130 */       close(rs);
/* 162:131 */       close(pstmt);
/* 163:132 */       rollback(conn);
/* 164:133 */       throw e;
/* 165:    */     }
/* 166:    */     finally
/* 167:    */     {
/* 168:135 */       close(conn);
/* 169:    */     }
/* 170:137 */     return usuarioCar;
/* 171:    */   }
/* 172:    */   
/* 173:    */   public UsuarioCar loginPassword(String usuc_usuario, String usuc_password)
/* 174:    */     throws SQLException
/* 175:    */   {
/* 176:142 */     UsuarioCar usuarioCar = new UsuarioCar();
/* 177:143 */     Connection conn = null;
/* 178:144 */     PreparedStatement pstmt = null;
/* 179:145 */     ResultSet rs = null;
/* 180:146 */     UsuarioCar usuarioCarS = new UsuarioCar();
/* 181:    */     try
/* 182:    */     {
/* 183:148 */       conn = this.ds.getConnection();
/* 184:149 */       DBUtil db = new DBUtil();
/* 185:150 */       String sql = db.creaSQLSELECT(usuarioCarS);
/* 186:151 */       String where = " where usuc_usuario = ? and usuc_clave = ?";
/* 187:152 */       pstmt = conn.prepareStatement(sql + where);
/* 188:153 */       pstmt.setString(1, usuc_usuario);
/* 189:154 */       pstmt.setString(2, usuc_password);
/* 190:155 */       rs = pstmt.executeQuery();
/* 191:156 */       if (rs.next())
/* 192:    */       {
/* 193:157 */         InicializaData.inicializa(usuarioCar.getClass(), usuarioCar);
/* 194:158 */         populate(usuarioCar, rs);
/* 195:    */       }
/* 196:160 */       close(rs);
/* 197:161 */       close(pstmt);
/* 198:    */     }
/* 199:    */     catch (SQLException e)
/* 200:    */     {
/* 201:163 */       close(rs);
/* 202:164 */       close(pstmt);
/* 203:165 */       rollback(conn);
/* 204:166 */       throw e;
/* 205:    */     }
/* 206:    */     finally
/* 207:    */     {
/* 208:168 */       close(conn);
/* 209:    */     }
/* 210:170 */     return usuarioCar;
/* 211:    */   }
/* 212:    */   
/* 213:    */   public synchronized void insert(UsuarioCar data)
/* 214:    */     throws SQLException
/* 215:    */   {
/* 216:174 */     Connection conn = null;
/* 217:175 */     PreparedStatement pstmt = null;
/* 218:    */     
/* 219:177 */     ResultSet rs = null;
/* 220:    */     try
/* 221:    */     {
/* 222:179 */       int id = 0;
/* 223:180 */       DBUtil db = new DBUtil();
/* 224:181 */       conn = this.ds.getConnection();
/* 225:182 */       conn.setAutoCommit(false);
/* 226:183 */       id = getReqMax(conn);
/* 227:184 */       data.setUsuc_cod(new BigDecimal(id));
/* 228:185 */       String sql = db.creaSQLINSERT(data);
/* 229:186 */       pstmt = conn.prepareStatement(sql);
/* 230:187 */       pstmt.executeUpdate();
/* 231:188 */       pstmt.close();
/* 232:189 */       conn.commit();
/* 233:    */     }
/* 234:    */     catch (SQLException sqle)
/* 235:    */     {
/* 236:191 */       close(rs);
/* 237:192 */       close(pstmt);
/* 238:193 */       rollback(conn);
/* 239:194 */       throw sqle;
/* 240:    */     }
/* 241:    */     finally
/* 242:    */     {
/* 243:196 */       close(rs);
/* 244:197 */       close(pstmt);
/* 245:198 */       close(conn);
/* 246:    */     }
/* 247:    */   }
/* 248:    */   
/* 249:    */   public void delete(UsuarioCar data)
/* 250:    */     throws SQLException
/* 251:    */   {
/* 252:203 */     Connection conn = null;
/* 253:204 */     PreparedStatement pstmt = null;
/* 254:    */     try
/* 255:    */     {
/* 256:206 */       conn = this.ds.getConnection();
/* 257:207 */       conn.setAutoCommit(false);
/* 258:208 */       String sql = "DELETE FROM sdoctor.usuariocar WHERE usuc_cod = ?";
/* 259:209 */       pstmt = conn.prepareStatement(sql);
/* 260:210 */       pstmt.setBigDecimal(1, data.getUsuc_cod());
/* 261:211 */       pstmt.executeUpdate();
/* 262:212 */       close(pstmt);
/* 263:213 */       conn.commit();
/* 264:    */     }
/* 265:    */     catch (SQLException e)
/* 266:    */     {
/* 267:215 */       close(pstmt);
/* 268:216 */       rollback(conn);
/* 269:217 */       throw e;
/* 270:    */     }
/* 271:    */     finally
/* 272:    */     {
/* 273:219 */       close(conn);
/* 274:    */     }
/* 275:    */   }
/* 276:    */   
/* 277:    */   public void updatePassword(BigDecimal usuc_cod, String usuario, String password)
/* 278:    */     throws SQLException
/* 279:    */   {
/* 280:224 */     Connection conn = null;
/* 281:225 */     PreparedStatement pstmt = null;
/* 282:    */     try
/* 283:    */     {
/* 284:228 */       String sql = "UPDATE sdoctor.usuariocar SET usuc_clave = ?, usuc_usuario = ? WHERE usuc_cod = ?";
/* 285:229 */       conn = this.ds.getConnection();
/* 286:230 */       conn.setAutoCommit(false);
/* 287:231 */       pstmt = conn.prepareStatement(sql);
/* 288:232 */       pstmt.setString(1, password);
/* 289:233 */       pstmt.setString(2, usuario);
/* 290:234 */       pstmt.setBigDecimal(3, usuc_cod);
/* 291:235 */       pstmt.executeUpdate();
/* 292:236 */       conn.commit();
/* 293:    */     }
/* 294:    */     catch (SQLException e)
/* 295:    */     {
/* 296:238 */       close(pstmt);
/* 297:239 */       rollback(conn);
/* 298:240 */       throw e;
/* 299:    */     }
/* 300:    */     finally
/* 301:    */     {
/* 302:242 */       close(conn);
/* 303:    */     }
/* 304:    */   }
/* 305:    */   
/* 306:    */   public void updatePasswordEmergencias(BigDecimal usuc_cod, String password)
/* 307:    */     throws SQLException
/* 308:    */   {
/* 309:247 */     Connection conn = null;
/* 310:248 */     PreparedStatement pstmt = null;
/* 311:    */     try
/* 312:    */     {
/* 313:251 */       String sql = "UPDATE sdoctor.usuariocar SET usuc_clave_emer = ? WHERE usuc_cod = ?";
/* 314:252 */       conn = this.ds.getConnection();
/* 315:253 */       conn.setAutoCommit(false);
/* 316:254 */       pstmt = conn.prepareStatement(sql);
/* 317:255 */       pstmt.setString(1, password);
/* 318:256 */       pstmt.setBigDecimal(2, usuc_cod);
/* 319:257 */       pstmt.executeUpdate();
/* 320:258 */       conn.commit();
/* 321:    */     }
/* 322:    */     catch (SQLException e)
/* 323:    */     {
/* 324:261 */       close(pstmt);
/* 325:262 */       rollback(conn);
/* 326:263 */       throw e;
/* 327:    */     }
/* 328:    */     finally
/* 329:    */     {
/* 330:265 */       close(conn);
/* 331:    */     }
/* 332:    */   }
/* 333:    */   
/* 334:    */   public UsuarioCar loginEmergencia(String usuc_usuario, String usuc_clave_emer)
/* 335:    */     throws SQLException
/* 336:    */   {
/* 337:270 */     UsuarioCar usuarioCar = new UsuarioCar();
/* 338:271 */     Connection conn = null;
/* 339:272 */     PreparedStatement pstmt = null;
/* 340:273 */     ResultSet rs = null;
/* 341:274 */     UsuarioCar usuarioCarS = new UsuarioCar();
/* 342:    */     try
/* 343:    */     {
/* 344:276 */       conn = this.ds.getConnection();
/* 345:277 */       DBUtil db = new DBUtil();
/* 346:278 */       String sql = db.creaSQLSELECT(usuarioCarS);
/* 347:279 */       String where = " where usuc_usuario = ? and usuc_clave_emer = ?";
/* 348:280 */       pstmt = conn.prepareStatement(sql + where);
/* 349:281 */       pstmt.setString(1, usuc_usuario);
/* 350:282 */       pstmt.setString(2, usuc_clave_emer);
/* 351:283 */       rs = pstmt.executeQuery();
/* 352:284 */       if (rs.next())
/* 353:    */       {
/* 354:285 */         InicializaData.inicializa(usuarioCar.getClass(), usuarioCar);
/* 355:286 */         populate(usuarioCar, rs);
/* 356:    */       }
/* 357:288 */       close(rs);
/* 358:289 */       close(pstmt);
/* 359:    */     }
/* 360:    */     catch (SQLException e)
/* 361:    */     {
/* 362:291 */       close(rs);
/* 363:292 */       close(pstmt);
/* 364:293 */       rollback(conn);
/* 365:294 */       throw e;
/* 366:    */     }
/* 367:    */     finally
/* 368:    */     {
/* 369:296 */       close(conn);
/* 370:    */     }
/* 371:298 */     return usuarioCar;
/* 372:    */   }
/* 373:    */   
/* 374:    */   private int getReqMax(Connection conn)
/* 375:    */   {
/* 376:302 */     PreparedStatement pstmt = null;
/* 377:303 */     ResultSet rs = null;
/* 378:304 */     int id2 = 0;
/* 379:    */     try
/* 380:    */     {
/* 381:306 */       String sqlid = "Select max(usuc_cod) from sdoctor.usuariocar";
/* 382:307 */       pstmt = conn.prepareStatement(sqlid);
/* 383:308 */       rs = pstmt.executeQuery();
/* 384:309 */       if ((rs != null) && (rs.next())) {
/* 385:310 */         id2 = rs.getInt(1) + 1;
/* 386:    */       } else {
/* 387:312 */         id2++;
/* 388:    */       }
/* 389:    */     }
/* 390:    */     catch (SQLException e)
/* 391:    */     {
/* 392:315 */       close(rs);
/* 393:316 */       close(pstmt);
/* 394:317 */       rollback(conn);
/* 395:318 */       e.printStackTrace();
/* 396:    */     }
/* 397:    */     finally
/* 398:    */     {
/* 399:320 */       close(rs);
/* 400:321 */       close(pstmt);
/* 401:    */     }
/* 402:323 */     return id2;
/* 403:    */   }
/* 404:    */   
/* 405:    */   public List retrive_list(String usu_usuario)
/* 406:    */     throws SQLException
/* 407:    */   {
/* 408:327 */     ArrayList list = new ArrayList();
/* 409:328 */     UsuarioCar usuario = null;
/* 410:329 */     UsuarioCar usuarioS = new UsuarioCar();
/* 411:330 */     Connection conn = null;
/* 412:331 */     PreparedStatement pstmt = null;
/* 413:332 */     ResultSet rs = null;
/* 414:    */     try
/* 415:    */     {
/* 416:335 */       conn = this.ds.getConnection();
/* 417:336 */       DBUtil db = new DBUtil();
/* 418:337 */       String sql = db.creaSQLSELECT(usuarioS);
/* 419:338 */       String where = " where usuc_usuario = ?";
/* 420:339 */       pstmt = conn.prepareStatement(sql + where);
/* 421:340 */       pstmt.setString(1, usu_usuario);
/* 422:341 */       rs = pstmt.executeQuery();
/* 423:342 */       while (rs.next())
/* 424:    */       {
/* 425:343 */         usuario = new UsuarioCar();
/* 426:344 */         InicializaData.inicializa(usuario.getClass(), usuario);
/* 427:345 */         populate(usuario, rs);
/* 428:346 */         list.add(usuario);
/* 429:    */       }
/* 430:348 */       close(rs);
/* 431:349 */       close(pstmt);
/* 432:    */     }
/* 433:    */     catch (SQLException e)
/* 434:    */     {
/* 435:351 */       close(rs);
/* 436:352 */       close(pstmt);
/* 437:353 */       rollback(conn);
/* 438:354 */       throw e;
/* 439:    */     }
/* 440:    */     finally
/* 441:    */     {
/* 442:356 */       close(conn);
/* 443:    */     }
/* 444:358 */     return list;
/* 445:    */   }
/* 446:    */   
/* 447:    */   public void updateLicenciasLogo(String string, String condicionId, BigDecimal logm_cod)
/* 448:    */     throws SQLException
/* 449:    */   {
/* 450:362 */     Connection conn = null;
/* 451:363 */     PreparedStatement pstmt = null;
/* 452:    */     try
/* 453:    */     {
/* 454:365 */       DBUtil db = new DBUtil();
/* 455:366 */       conn = this.ds.getConnection();
/* 456:367 */       conn.setAutoCommit(false);
/* 457:368 */       String sql = "update usuariocar set usuc_logm_cod = ? where usuc_licencia in ( " + string + " ) and usuc_licencia in (" + condicionId + ")";
/* 458:369 */       pstmt = conn.prepareStatement(sql);
/* 459:370 */       pstmt.setBigDecimal(1, logm_cod);
/* 460:371 */       pstmt.executeUpdate();
/* 461:372 */       close(pstmt);
/* 462:373 */       conn.commit();
/* 463:    */     }
/* 464:    */     catch (SQLException e)
/* 465:    */     {
/* 466:375 */       close(pstmt);
/* 467:376 */       rollback(conn);
/* 468:377 */       throw e;
/* 469:    */     }
/* 470:    */     finally
/* 471:    */     {
/* 472:379 */       close(conn);
/* 473:    */     }
/* 474:    */   }
/* 475:    */   
/* 476:    */   public void updateLicenciasArte(String string, String condicionId, BigDecimal logm_cod)
/* 477:    */     throws SQLException
/* 478:    */   {
/* 479:384 */     Connection conn = null;
/* 480:385 */     PreparedStatement pstmt = null;
/* 481:    */     try
/* 482:    */     {
/* 483:387 */       DBUtil db = new DBUtil();
/* 484:388 */       conn = this.ds.getConnection();
/* 485:389 */       conn.setAutoCommit(false);
/* 486:390 */       String sql = "update usuariocar set usuc_artm_cod = ? where usuc_licencia in ( " + string + " ) and usuc_licencia in (" + condicionId + ")";
/* 487:391 */       pstmt = conn.prepareStatement(sql);
/* 488:392 */       pstmt.setBigDecimal(1, logm_cod);
/* 489:393 */       pstmt.executeUpdate();
/* 490:394 */       close(pstmt);
/* 491:395 */       conn.commit();
/* 492:    */     }
/* 493:    */     catch (SQLException e)
/* 494:    */     {
/* 495:397 */       close(pstmt);
/* 496:398 */       rollback(conn);
/* 497:399 */       throw e;
/* 498:    */     }
/* 499:    */     finally
/* 500:    */     {
/* 501:401 */       close(conn);
/* 502:    */     }
/* 503:    */   }
/* 504:    */   
/* 505:    */   public int count(String usuc_licencia)
/* 506:    */     throws SQLException
/* 507:    */   {
/* 508:406 */     Connection conn = null;
/* 509:407 */     PreparedStatement pstmt = null;
/* 510:408 */     ResultSet rs = null;
/* 511:409 */     int counter = 0;
/* 512:    */     try
/* 513:    */     {
/* 514:411 */       conn = this.ds.getConnection();
/* 515:412 */       DBUtil db = new DBUtil();
/* 516:413 */       String sql = db.creaSQLSELECT(new UsuarioCar());
/* 517:414 */       String where = " where usuc_licencia = ?";
/* 518:415 */       pstmt = conn.prepareStatement(sql + where);
/* 519:416 */       pstmt.setString(1, usuc_licencia);
/* 520:417 */       rs = pstmt.executeQuery();
/* 521:418 */       while (rs.next()) {
/* 522:419 */         counter++;
/* 523:    */       }
/* 524:421 */       close(rs);
/* 525:422 */       close(pstmt);
/* 526:    */     }
/* 527:    */     catch (SQLException e)
/* 528:    */     {
/* 529:424 */       close(rs);
/* 530:425 */       close(pstmt);
/* 531:426 */       rollback(conn);
/* 532:427 */       throw e;
/* 533:    */     }
/* 534:    */     finally
/* 535:    */     {
/* 536:429 */       close(conn);
/* 537:    */     }
/* 538:431 */     return counter;
/* 539:    */   }
/* 540:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.seguridad.dao.UsuarioCarDAO
 * JD-Core Version:    0.7.0.1
 */