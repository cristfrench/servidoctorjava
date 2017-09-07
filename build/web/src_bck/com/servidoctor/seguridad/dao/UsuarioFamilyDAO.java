/*   1:    */ package com.servidoctor.seguridad.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.seguridad.model.UsuarioFamily;
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
/*  17:    */ public class UsuarioFamilyDAO
/*  18:    */   extends DAO
/*  19:    */ {
/*  20: 19 */   private static final ResourceBundle prop = ResourceBundle.getBundle("com.servidoctor.resources.Config");
/*  21:    */   
/*  22:    */   public UsuarioFamilyDAO()
/*  23:    */   {
/*  24: 22 */     super(prop.getString("jndi.central.name"));
/*  25:    */   }
/*  26:    */   
/*  27:    */   public void update(UsuarioFamily data, String[] llaves)
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
/*  55:    */   public UsuarioFamily retrive(BigDecimal usuf_cod)
/*  56:    */     throws SQLException
/*  57:    */   {
/*  58: 47 */     UsuarioFamily usuarioFamily = new UsuarioFamily();
/*  59: 48 */     Connection conn = null;
/*  60: 49 */     PreparedStatement pstmt = null;
/*  61: 50 */     ResultSet rs = null;
/*  62: 51 */     UsuarioFamily usuarioFamilyS = new UsuarioFamily();
/*  63:    */     try
/*  64:    */     {
/*  65: 53 */       conn = this.ds.getConnection();
/*  66: 54 */       DBUtil db = new DBUtil();
/*  67: 55 */       String sql = db.creaSQLSELECT(usuarioFamilyS);
/*  68: 56 */       String where = " where usuf_cod = ?";
/*  69: 57 */       pstmt = conn.prepareStatement(sql + where);
/*  70: 58 */       pstmt.setBigDecimal(1, usuf_cod);
/*  71: 59 */       rs = pstmt.executeQuery();
/*  72: 60 */       if (rs.next())
/*  73:    */       {
/*  74: 61 */         InicializaData.inicializa(usuarioFamily.getClass(), usuarioFamily);
/*  75: 62 */         populate(usuarioFamily, rs);
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
/*  91: 74 */     return usuarioFamily;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public UsuarioFamily login(String usuf_usuario, String usuf_clave)
/*  95:    */     throws SQLException
/*  96:    */   {
/*  97: 78 */     UsuarioFamily usuarioFamily = new UsuarioFamily();
/*  98: 79 */     Connection conn = null;
/*  99: 80 */     PreparedStatement pstmt = null;
/* 100: 81 */     ResultSet rs = null;
/* 101: 82 */     UsuarioFamily usuarioFamilyS = new UsuarioFamily();
/* 102:    */     try
/* 103:    */     {
/* 104: 84 */       conn = this.ds.getConnection();
/* 105: 85 */       DBUtil db = new DBUtil();
/* 106: 86 */       String sql = db.creaSQLSELECT(usuarioFamilyS);
/* 107: 87 */       String where = " where usuf_usuario = ? and usuf_clave = ?";
/* 108: 88 */       pstmt = conn.prepareStatement(sql + where);
/* 109: 89 */       pstmt.setString(1, usuf_usuario);
/* 110: 90 */       pstmt.setString(2, usuf_clave);
/* 111: 91 */       rs = pstmt.executeQuery();
/* 112: 92 */       if (rs.next())
/* 113:    */       {
/* 114: 93 */         InicializaData.inicializa(usuarioFamily.getClass(), usuarioFamily);
/* 115: 94 */         populate(usuarioFamily, rs);
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
/* 131:106 */     return usuarioFamily;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public UsuarioFamily login(String usuf_usuario)
/* 135:    */     throws SQLException
/* 136:    */   {
/* 137:110 */     UsuarioFamily usuarioFamily = new UsuarioFamily();
/* 138:111 */     Connection conn = null;
/* 139:112 */     PreparedStatement pstmt = null;
/* 140:113 */     ResultSet rs = null;
/* 141:114 */     UsuarioFamily usuarioFamilyS = new UsuarioFamily();
/* 142:    */     try
/* 143:    */     {
/* 144:116 */       conn = this.ds.getConnection();
/* 145:117 */       DBUtil db = new DBUtil();
/* 146:118 */       String sql = db.creaSQLSELECT(usuarioFamilyS);
/* 147:119 */       String where = " where usuf_usuario = ? ";
/* 148:120 */       pstmt = conn.prepareStatement(sql + where);
/* 149:121 */       pstmt.setString(1, usuf_usuario);
/* 150:122 */       rs = pstmt.executeQuery();
/* 151:123 */       if (rs.next())
/* 152:    */       {
/* 153:124 */         InicializaData.inicializa(usuarioFamily.getClass(), usuarioFamily);
/* 154:125 */         populate(usuarioFamily, rs);
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
/* 170:137 */     return usuarioFamily;
/* 171:    */   }
/* 172:    */   
/* 173:    */   public UsuarioFamily loginPassword(String usuf_usuario, String usuf_password)
/* 174:    */     throws SQLException
/* 175:    */   {
/* 176:141 */     UsuarioFamily usuarioFamily = new UsuarioFamily();
/* 177:142 */     Connection conn = null;
/* 178:143 */     PreparedStatement pstmt = null;
/* 179:144 */     ResultSet rs = null;
/* 180:145 */     UsuarioFamily usuarioFamilyS = new UsuarioFamily();
/* 181:    */     try
/* 182:    */     {
/* 183:147 */       conn = this.ds.getConnection();
/* 184:148 */       DBUtil db = new DBUtil();
/* 185:149 */       String sql = db.creaSQLSELECT(usuarioFamilyS);
/* 186:150 */       String where = " where usuf_usuario = ? and usuf_clave = ? ";
/* 187:151 */       pstmt = conn.prepareStatement(sql + where);
                    System.out.println("sql:" + sql + where);
/* 188:152 */       pstmt.setString(1, usuf_usuario);
/* 189:153 */       pstmt.setString(2, usuf_password);
/* 190:154 */       rs = pstmt.executeQuery();
/* 191:155 */       if (rs.next())
/* 192:    */       {
/* 193:156 */         InicializaData.inicializa(usuarioFamily.getClass(), usuarioFamily);
/* 194:157 */         populate(usuarioFamily, rs);
/* 195:    */       }
/* 196:159 */       close(rs);
/* 197:160 */       close(pstmt);
/* 198:    */     }
/* 199:    */     catch (SQLException e)
/* 200:    */     {
/* 201:162 */       close(rs);
/* 202:163 */       close(pstmt);
/* 203:164 */       rollback(conn);
/* 204:165 */       throw e;
/* 205:    */     }
/* 206:    */     finally
/* 207:    */     {
/* 208:167 */       close(conn);
/* 209:    */     }
/* 210:169 */     return usuarioFamily;
/* 211:    */   }
/* 212:    */   
/* 213:    */   public synchronized void insert(UsuarioFamily data)
/* 214:    */     throws SQLException
/* 215:    */   {
/* 216:172 */     Connection conn = null;
/* 217:173 */     PreparedStatement pstmt = null;
/* 218:    */     
/* 219:175 */     ResultSet rs = null;
/* 220:    */     try
/* 221:    */     {
/* 222:177 */       int id = 0;
/* 223:178 */       DBUtil db = new DBUtil();
/* 224:179 */       conn = this.ds.getConnection();
/* 225:180 */       conn.setAutoCommit(false);
/* 226:181 */       id = getReqMax(conn);

                    System.out.println("id:" + id);
/* 227:182 */       data.setUsuf_cod(new BigDecimal(id));
/* 228:183 */       String sql = db.creaSQLINSERT(data);

                    System.out.println("sql:" + sql);
/* 229:184 */       pstmt = conn.prepareStatement(sql);
/* 230:185 */       pstmt.executeUpdate();
/* 231:186 */       pstmt.close();
/* 232:187 */       conn.commit();
/* 233:    */     }
/* 234:    */     catch (SQLException sqle)
/* 235:    */     {
/* 236:189 */       close(rs);
/* 237:190 */       close(pstmt);
/* 238:191 */       rollback(conn);
/* 239:192 */       throw sqle;
/* 240:    */     }
/* 241:    */     finally
/* 242:    */     {
/* 243:194 */       close(rs);
/* 244:195 */       close(pstmt);
/* 245:196 */       close(conn);
/* 246:    */     }
/* 247:    */   }
/* 248:    */   
/* 249:    */   public void delete(UsuarioFamily data)
/* 250:    */     throws SQLException
/* 251:    */   {
/* 252:201 */     Connection conn = null;
/* 253:202 */     PreparedStatement pstmt = null;
/* 254:    */     try
/* 255:    */     {
/* 256:204 */       conn = this.ds.getConnection();
/* 257:205 */       conn.setAutoCommit(false);
/* 258:206 */       String sql = "DELETE FROM sdoctor.usuariofamily WHERE usuf_cod = ?";
/* 259:207 */       pstmt = conn.prepareStatement(sql);
/* 260:208 */       pstmt.setBigDecimal(1, data.getUsuf_cod());
/* 261:209 */       pstmt.executeUpdate();
/* 262:210 */       close(pstmt);
/* 263:211 */       conn.commit();
/* 264:    */     }
/* 265:    */     catch (SQLException e)
/* 266:    */     {
/* 267:213 */       close(pstmt);
/* 268:214 */       rollback(conn);
/* 269:215 */       throw e;
/* 270:    */     }
/* 271:    */     finally
/* 272:    */     {
/* 273:217 */       close(conn);
/* 274:    */     }
/* 275:    */   }
/* 276:    */   
/* 277:    */   public void updatePassword(BigDecimal usuf_cod, String usuario, String password)
/* 278:    */     throws SQLException
/* 279:    */   {
/* 280:222 */     Connection conn = null;
/* 281:223 */     PreparedStatement pstmt = null;
/* 282:    */     try
/* 283:    */     {
/* 284:226 */       String sql = "UPDATE sdoctor.usuariofamily SET usuf_clave = ?, usuf_usuario = ? WHERE usuf_cod = ?";
/* 285:227 */       conn = this.ds.getConnection();
/* 286:228 */       conn.setAutoCommit(false);
/* 287:229 */       pstmt = conn.prepareStatement(sql);
/* 288:230 */       pstmt.setString(1, password);
/* 289:231 */       pstmt.setString(2, usuario);
/* 290:232 */       pstmt.setBigDecimal(3, usuf_cod);
/* 291:233 */       pstmt.executeUpdate();
/* 292:234 */       conn.commit();
/* 293:    */     }
/* 294:    */     catch (SQLException e)
/* 295:    */     {
/* 296:236 */       close(pstmt);
/* 297:237 */       rollback(conn);
/* 298:238 */       throw e;
/* 299:    */     }
/* 300:    */     finally
/* 301:    */     {
/* 302:240 */       close(conn);
/* 303:    */     }
/* 304:    */   }
/* 305:    */   
/* 306:    */   public void updatePasswordEmergencias(BigDecimal usuf_cod, String password)
/* 307:    */     throws SQLException
/* 308:    */   {
/* 309:245 */     Connection conn = null;
/* 310:246 */     PreparedStatement pstmt = null;
/* 311:    */     try
/* 312:    */     {
/* 313:249 */       String sql = "UPDATE sdoctor.usuariofamily SET usuf_clave_emer = ? WHERE usuf_cod = ?";
/* 314:250 */       conn = this.ds.getConnection();
/* 315:251 */       conn.setAutoCommit(false);
/* 316:252 */       pstmt = conn.prepareStatement(sql);
/* 317:253 */       pstmt.setString(1, password);
/* 318:254 */       pstmt.setBigDecimal(2, usuf_cod);
/* 319:255 */       pstmt.executeUpdate();
/* 320:256 */       conn.commit();
/* 321:    */     }
/* 322:    */     catch (SQLException e)
/* 323:    */     {
/* 324:259 */       close(pstmt);
/* 325:260 */       rollback(conn);
/* 326:261 */       throw e;
/* 327:    */     }
/* 328:    */     finally
/* 329:    */     {
/* 330:263 */       close(conn);
/* 331:    */     }
/* 332:    */   }
/* 333:    */   
/* 334:    */   public UsuarioFamily loginEmergencia(String usuf_usuario, String usuf_clave_emer)
/* 335:    */     throws SQLException
/* 336:    */   {
/* 337:268 */     UsuarioFamily usuarioFamily = new UsuarioFamily();
/* 338:269 */     Connection conn = null;
/* 339:270 */     PreparedStatement pstmt = null;
/* 340:271 */     ResultSet rs = null;
/* 341:272 */     UsuarioFamily usuarioFamilyS = new UsuarioFamily();
/* 342:    */     try
/* 343:    */     {
/* 344:274 */       conn = this.ds.getConnection();
/* 345:275 */       DBUtil db = new DBUtil();
/* 346:276 */       String sql = db.creaSQLSELECT(usuarioFamilyS);
/* 347:277 */       String where = " where usuf_usuario = ? and usuf_clave_emer = ?";
/* 348:278 */       pstmt = conn.prepareStatement(sql + where);
/* 349:279 */       pstmt.setString(1, usuf_usuario);
/* 350:280 */       pstmt.setString(2, usuf_clave_emer);
/* 351:281 */       rs = pstmt.executeQuery();
/* 352:282 */       if (rs.next())
/* 353:    */       {
/* 354:283 */         InicializaData.inicializa(usuarioFamily.getClass(), usuarioFamily);
/* 355:284 */         populate(usuarioFamily, rs);
/* 356:    */       }
/* 357:286 */       close(rs);
/* 358:287 */       close(pstmt);
/* 359:    */     }
/* 360:    */     catch (SQLException e)
/* 361:    */     {
/* 362:289 */       close(rs);
/* 363:290 */       close(pstmt);
/* 364:291 */       rollback(conn);
/* 365:292 */       throw e;
/* 366:    */     }
/* 367:    */     finally
/* 368:    */     {
/* 369:294 */       close(conn);
/* 370:    */     }
/* 371:296 */     return usuarioFamily;
/* 372:    */   }
/* 373:    */   
/* 374:    */   private int getReqMax(Connection conn)
/* 375:    */   {
/* 376:300 */     PreparedStatement pstmt = null;
/* 377:301 */     ResultSet rs = null;
/* 378:302 */     int id2 = 0;
/* 379:    */     try
/* 380:    */     {
/* 381:304 */       String sqlid = "Select max(usuf_cod) from sdoctor.usuariofamily";
/* 382:305 */       pstmt = conn.prepareStatement(sqlid);
/* 383:306 */       rs = pstmt.executeQuery();
/* 384:307 */       if ((rs != null) && (rs.next())) {
/* 385:308 */         id2 = rs.getInt(1) + 1;
/* 386:    */       } else {
/* 387:310 */         id2++;
/* 388:    */       }
/* 389:    */     }
/* 390:    */     catch (SQLException e)
/* 391:    */     {
/* 392:313 */       close(rs);
/* 393:314 */       close(pstmt);
/* 394:315 */       rollback(conn);
/* 395:316 */       e.printStackTrace();
/* 396:    */     }
/* 397:    */     finally
/* 398:    */     {
/* 399:318 */       close(rs);
/* 400:319 */       close(pstmt);
/* 401:    */     }
/* 402:321 */     return id2;
/* 403:    */   }
/* 404:    */   
/* 405:    */   public List retrive_list(String usu_usuario)
/* 406:    */     throws SQLException
/* 407:    */   {
/* 408:325 */     ArrayList list = new ArrayList();
/* 409:326 */     UsuarioFamily usuario = null;
/* 410:327 */     UsuarioFamily usuarioS = new UsuarioFamily();
/* 411:328 */     Connection conn = null;
/* 412:329 */     PreparedStatement pstmt = null;
/* 413:330 */     ResultSet rs = null;
/* 414:    */     try
/* 415:    */     {
/* 416:333 */       conn = this.ds.getConnection();
/* 417:334 */       DBUtil db = new DBUtil();
/* 418:335 */       String sql = db.creaSQLSELECT(usuarioS);
/* 419:336 */       String where = " where usuf_usuario = ?";
/* 420:337 */       pstmt = conn.prepareStatement(sql + where);
/* 421:338 */       pstmt.setString(1, usu_usuario);
/* 422:339 */       rs = pstmt.executeQuery();
/* 423:340 */       while (rs.next())
/* 424:    */       {
/* 425:341 */         usuario = new UsuarioFamily();
/* 426:342 */         InicializaData.inicializa(usuario.getClass(), usuario);
/* 427:343 */         populate(usuario, rs);
/* 428:344 */         list.add(usuario);
/* 429:    */       }
/* 430:346 */       close(rs);
/* 431:347 */       close(pstmt);
/* 432:    */     }
/* 433:    */     catch (SQLException e)
/* 434:    */     {
/* 435:349 */       close(rs);
/* 436:350 */       close(pstmt);
/* 437:351 */       rollback(conn);
/* 438:352 */       throw e;
/* 439:    */     }
/* 440:    */     finally
/* 441:    */     {
/* 442:354 */       close(conn);
/* 443:    */     }
/* 444:356 */     return list;
/* 445:    */   }
/* 446:    */   
/* 447:    */   public void updateLicenciasLogo(String string, String condicionId, BigDecimal logm_cod)
/* 448:    */     throws SQLException
/* 449:    */   {
/* 450:360 */     Connection conn = null;
/* 451:361 */     PreparedStatement pstmt = null;
/* 452:    */     try
/* 453:    */     {
/* 454:363 */       DBUtil db = new DBUtil();
/* 455:364 */       conn = this.ds.getConnection();
/* 456:365 */       conn.setAutoCommit(false);
/* 457:366 */       String sql = "update usuariofamily set usuf_logm_cod = ? where usuf_licencia in ( " + string + " ) and usuf_licencia in (" + condicionId + ")";
/* 458:367 */       pstmt = conn.prepareStatement(sql);
/* 459:368 */       pstmt.setBigDecimal(1, logm_cod);
/* 460:369 */       pstmt.executeUpdate();
/* 461:370 */       close(pstmt);
/* 462:371 */       conn.commit();
/* 463:    */     }
/* 464:    */     catch (SQLException e)
/* 465:    */     {
/* 466:373 */       close(pstmt);
/* 467:374 */       rollback(conn);
/* 468:375 */       throw e;
/* 469:    */     }
/* 470:    */     finally
/* 471:    */     {
/* 472:377 */       close(conn);
/* 473:    */     }
/* 474:    */   }
/* 475:    */   
/* 476:    */   public void updateLicenciasArte(String string, String condicionId, BigDecimal logm_cod)
/* 477:    */     throws SQLException
/* 478:    */   {
/* 479:382 */     Connection conn = null;
/* 480:383 */     PreparedStatement pstmt = null;
/* 481:    */     try
/* 482:    */     {
/* 483:385 */       DBUtil db = new DBUtil();
/* 484:386 */       conn = this.ds.getConnection();
/* 485:387 */       conn.setAutoCommit(false);
/* 486:388 */       String sql = "update usuariofamily set usuf_artm_cod = ? where usuf_licencia in ( " + string + " ) and usuf_licencia in (" + condicionId + ")";
/* 487:389 */       pstmt = conn.prepareStatement(sql);
/* 488:390 */       pstmt.setBigDecimal(1, logm_cod);
/* 489:391 */       pstmt.executeUpdate();
/* 490:392 */       close(pstmt);
/* 491:393 */       conn.commit();
/* 492:    */     }
/* 493:    */     catch (SQLException e)
/* 494:    */     {
/* 495:395 */       close(pstmt);
/* 496:396 */       rollback(conn);
/* 497:397 */       throw e;
/* 498:    */     }
/* 499:    */     finally
/* 500:    */     {
/* 501:399 */       close(conn);
/* 502:    */     }
/* 503:    */   }
/* 504:    */   
/* 505:    */   public int count(String usuf_licencia)
/* 506:    */     throws SQLException
/* 507:    */   {
/* 508:404 */     Connection conn = null;
/* 509:405 */     PreparedStatement pstmt = null;
/* 510:406 */     ResultSet rs = null;
/* 511:407 */     int counter = 0;
/* 512:    */     try
/* 513:    */     {
/* 514:409 */       conn = this.ds.getConnection();
/* 515:410 */       DBUtil db = new DBUtil();
/* 516:411 */       String sql = db.creaSQLSELECT(new UsuarioFamily());
/* 517:412 */       String where = " where usuf_licencia = ?";
/* 518:413 */       pstmt = conn.prepareStatement(sql + where);
/* 519:414 */       pstmt.setString(1, usuf_licencia);
/* 520:415 */       rs = pstmt.executeQuery();
/* 521:416 */       while (rs.next()) {
/* 522:417 */         counter++;
/* 523:    */       }
/* 524:419 */       close(rs);
/* 525:420 */       close(pstmt);
/* 526:    */     }
/* 527:    */     catch (SQLException e)
/* 528:    */     {
/* 529:422 */       close(rs);
/* 530:423 */       close(pstmt);
/* 531:424 */       rollback(conn);
/* 532:425 */       throw e;
/* 533:    */     }
/* 534:    */     finally
/* 535:    */     {
/* 536:427 */       close(conn);
/* 537:    */     }
/* 538:429 */     return counter;
/* 539:    */   }
/* 540:    */ }



/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\

 * Qualified Name:     com.servidoctor.seguridad.dao.UsuarioFamilyDAO

 * JD-Core Version:    0.7.0.1

 */