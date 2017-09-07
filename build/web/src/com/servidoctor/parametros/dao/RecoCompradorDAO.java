/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.Grupo;
/*   5:    */ import com.servidoctor.parametros.model.RecoComprador;
/*   6:    */ import com.servidoctor.seguridad.dao.Compras_licenciasDAO;
/*   7:    */ import com.servidoctor.seguridad.dao.UsuarioCarDAO;
/*   8:    */ import com.servidoctor.seguridad.dao.UsuarioFamilyDAO;
/*   9:    */ import com.servidoctor.seguridad.dao.UsuarioPetsDAO;
/*  10:    */ import com.servidoctor.seguridad.model.Compras_licencias;
/*  11:    */ import com.servidoctor.util.classes.DBUtil;
/*  12:    */ import com.servidoctor.util.classes.InicializaData;
/*  13:    */ import java.math.BigDecimal;
/*  14:    */ import java.sql.Connection;
/*  15:    */ import java.sql.PreparedStatement;
/*  16:    */ import java.sql.ResultSet;
/*  17:    */ import java.sql.SQLException;
/*  18:    */ import java.util.ArrayList;
/*  19:    */ import java.util.List;
/*  20:    */ import javax.sql.DataSource;
/*  21:    */ 
/*  22:    */ public class RecoCompradorDAO
/*  23:    */   extends DAO
/*  24:    */ {
/*  25:    */   public void update(RecoComprador data, String[] llaves)
/*  26:    */     throws SQLException
/*  27:    */   {
/*  28: 32 */     Connection conn = null;
/*  29: 33 */     PreparedStatement pstmt = null;
/*  30:    */     try
/*  31:    */     {
/*  32: 35 */       DBUtil db = new DBUtil();
/*  33: 36 */       conn = this.ds.getConnection();
/*  34: 37 */       conn.setAutoCommit(false);
/*  35: 38 */       String sql = db.creaSQLUPDATE(data, llaves);
/*  36: 39 */       pstmt = conn.prepareStatement(sql);
/*  37: 40 */       pstmt.executeUpdate();
/*  38: 41 */       close(pstmt);
/*  39: 42 */       conn.commit();
/*  40:    */     }
/*  41:    */     catch (SQLException e)
/*  42:    */     {
/*  43: 44 */       close(pstmt);
/*  44: 45 */       rollback(conn);
/*  45: 46 */       throw e;
/*  46:    */     }
/*  47:    */     finally
/*  48:    */     {
/*  49: 48 */       close(conn);
/*  50:    */     }
/*  51:    */   }
/*  52:    */   
/*  53:    */   public RecoComprador retrieve(BigDecimal consecutivo, String reco_grupo_id, BigDecimal artm_consecutivo)
/*  54:    */     throws SQLException
/*  55:    */   {
/*  56: 53 */     RecoComprador recoComprador = new RecoComprador();
/*  57: 54 */     Connection conn = null;
/*  58: 55 */     PreparedStatement pstmt = null;
/*  59: 56 */     ResultSet rs = null;
/*  60: 57 */     RecoComprador recoCompradorS = new RecoComprador();
/*  61:    */     try
/*  62:    */     {
/*  63: 59 */       conn = this.ds.getConnection();
/*  64: 60 */       DBUtil db = new DBUtil();
/*  65: 61 */       String sql = db.creaSQLSELECT(recoCompradorS);
/*  66: 62 */       String where = " where consecutivo = ? and reco_grupo_id = ? ";
/*  67: 63 */       pstmt = conn.prepareStatement(sql + where);
/*  68: 64 */       pstmt.setBigDecimal(1, consecutivo);
/*  69: 65 */       pstmt.setString(2, reco_grupo_id);
/*  70: 66 */       rs = pstmt.executeQuery();
/*  71: 67 */       if (rs.next())
/*  72:    */       {
/*  73: 68 */         InicializaData.inicializa(recoComprador.getClass(), recoComprador);
/*  74: 69 */         populate(recoComprador, rs);
/*  75:    */       }
/*  76: 71 */       close(rs);
/*  77: 72 */       close(pstmt);
/*  78:    */     }
/*  79:    */     catch (SQLException e)
/*  80:    */     {
/*  81: 74 */       close(rs);
/*  82: 75 */       close(pstmt);
/*  83: 76 */       rollback(conn);
/*  84: 77 */       throw e;
/*  85:    */     }
/*  86:    */     finally
/*  87:    */     {
/*  88: 79 */       close(conn);
/*  89:    */     }
/*  90: 81 */     return recoComprador;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public List list(String artm_may_cod)
/*  94:    */     throws SQLException
/*  95:    */   {
/*  96: 85 */     ArrayList resultado = new ArrayList();
/*  97: 86 */     Connection conn = null;
/*  98: 87 */     PreparedStatement pstmt = null;
/*  99: 88 */     ResultSet rs = null;
/* 100: 89 */     RecoComprador recoCompradorS = new RecoComprador();
/* 101:    */     try
/* 102:    */     {
/* 103: 91 */       conn = this.ds.getConnection();
/* 104: 92 */       String sql = "select distinct artm_cod, artm_may_cod, artm_nombre_grupo from artesmayor";
/* 105: 93 */       String where = " where artm_may_cod = ?";
/* 106: 94 */       pstmt = conn.prepareStatement(sql + where);
/* 107: 95 */       pstmt.setString(1, artm_may_cod);
/* 108: 96 */       rs = pstmt.executeQuery();
/* 109: 97 */       while (rs.next())
/* 110:    */       {
/* 111: 98 */         RecoComprador recoComprador = new RecoComprador();
/* 112: 99 */         InicializaData.inicializa(recoComprador.getClass(), recoComprador);
/* 113:100 */         populate(recoComprador, rs);
/* 114:101 */         resultado.add(recoComprador);
/* 115:    */       }
/* 116:103 */       close(rs);
/* 117:104 */       close(pstmt);
/* 118:    */     }
/* 119:    */     catch (SQLException e)
/* 120:    */     {
/* 121:106 */       close(rs);
/* 122:107 */       close(pstmt);
/* 123:108 */       rollback(conn);
/* 124:109 */       throw e;
/* 125:    */     }
/* 126:    */     finally
/* 127:    */     {
/* 128:111 */       close(conn);
/* 129:    */     }
/* 130:113 */     return resultado;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public List list(BigDecimal consecutivo, BigDecimal reco_grupo_id, BigDecimal reco_grupo_consecutivo)
/* 134:    */     throws SQLException
/* 135:    */   {
/* 136:117 */     ArrayList resultado = new ArrayList();
/* 137:118 */     Connection conn = null;
/* 138:119 */     PreparedStatement pstmt = null;
/* 139:120 */     ResultSet rs = null;
/* 140:121 */     RecoComprador recoCompradorS = new RecoComprador();
/* 141:    */     try
/* 142:    */     {
/* 143:123 */       conn = this.ds.getConnection();
/* 144:124 */       DBUtil db = new DBUtil();
/* 145:125 */       String sql = db.creaSQLSELECT(recoCompradorS);
/* 146:126 */       String where = " where consecutivo = ? and reco_grupo_id = ? and reco_grupo_consecutivo = ?";
/* 147:127 */       pstmt = conn.prepareStatement(sql + where);
/* 148:128 */       pstmt.setBigDecimal(1, consecutivo);
/* 149:129 */       pstmt.setBigDecimal(2, reco_grupo_id);
/* 150:130 */       pstmt.setBigDecimal(3, reco_grupo_consecutivo);
/* 151:131 */       rs = pstmt.executeQuery();
/* 152:132 */       while (rs.next())
/* 153:    */       {
/* 154:133 */         RecoComprador recoComprador = new RecoComprador();
/* 155:134 */         InicializaData.inicializa(recoComprador.getClass(), recoComprador);
/* 156:135 */         populate(recoComprador, rs);
/* 157:136 */         resultado.add(recoComprador);
/* 158:    */       }
/* 159:138 */       close(rs);
/* 160:139 */       close(pstmt);
/* 161:    */     }
/* 162:    */     catch (SQLException e)
/* 163:    */     {
/* 164:141 */       close(rs);
/* 165:142 */       close(pstmt);
/* 166:143 */       rollback(conn);
/* 167:144 */       throw e;
/* 168:    */     }
/* 169:    */     finally
/* 170:    */     {
/* 171:146 */       close(conn);
/* 172:    */     }
/* 173:148 */     return resultado;
/* 174:    */   }
/* 175:    */   
/* 176:    */   public synchronized void insert(RecoComprador data)
/* 177:    */     throws SQLException
/* 178:    */   {
/* 179:152 */     Connection conn = null;
/* 180:153 */     PreparedStatement pstmt = null;
/* 181:    */     
/* 182:155 */     ResultSet rs = null;
/* 183:    */     try
/* 184:    */     {
/* 185:157 */       int id = 0;
/* 186:158 */       DBUtil db = new DBUtil();
/* 187:    */       
/* 188:160 */       conn = this.ds.getConnection();
/* 189:161 */       conn.setAutoCommit(false);
/* 190:162 */       id = getConsecutivo(conn, data);
/* 191:163 */       data.setConsecutivo(new BigDecimal(id));
/* 192:164 */       String sql = db.creaSQLINSERT(data);
/* 193:    */       
/* 194:166 */       pstmt = conn.prepareStatement(sql);
/* 195:167 */       pstmt.executeUpdate();
/* 196:168 */       pstmt.close();
/* 197:169 */       conn.commit();
/* 198:    */     }
/* 199:    */     catch (SQLException sqle)
/* 200:    */     {
/* 201:171 */       close(rs);
/* 202:172 */       close(pstmt);
/* 203:173 */       rollback(conn);
/* 204:174 */       throw sqle;
/* 205:    */     }
/* 206:    */     finally
/* 207:    */     {
/* 208:176 */       close(rs);
/* 209:177 */       close(pstmt);
/* 210:178 */       close(conn);
/* 211:    */     }
/* 212:    */   }
/* 213:    */   
/* 214:    */   public synchronized void insertGrupo(RecoComprador data)
/* 215:    */     throws SQLException
/* 216:    */   {
/* 217:183 */     Connection conn = null;
/* 218:184 */     PreparedStatement pstmt = null;
/* 219:    */     
/* 220:186 */     ResultSet rs = null;
/* 221:    */     try
/* 222:    */     {
/* 223:188 */       int id = 0;
/* 224:189 */       DBUtil db = new DBUtil();
/* 225:    */       
/* 226:191 */       conn = this.ds.getConnection();
/* 227:192 */       conn.setAutoCommit(false);
/* 228:193 */       id = getReqMax(conn, data);
/* 229:    */       
/* 230:    */ 
/* 231:196 */       String sql = db.creaSQLINSERT(data);
/* 232:    */       
/* 233:198 */       pstmt = conn.prepareStatement(sql);
/* 234:199 */       pstmt.executeUpdate();
/* 235:200 */       pstmt.close();
/* 236:201 */       conn.commit();
/* 237:    */     }
/* 238:    */     catch (SQLException sqle)
/* 239:    */     {
/* 240:203 */       close(rs);
/* 241:204 */       close(pstmt);
/* 242:205 */       rollback(conn);
/* 243:206 */       throw sqle;
/* 244:    */     }
/* 245:    */     finally
/* 246:    */     {
/* 247:208 */       close(rs);
/* 248:209 */       close(pstmt);
/* 249:210 */       close(conn);
/* 250:    */     }
/* 251:    */   }
/* 252:    */   
/* 253:    */   public void delete(RecoComprador data)
/* 254:    */     throws SQLException
/* 255:    */   {
/* 256:215 */     Connection conn = null;
/* 257:216 */     PreparedStatement pstmt = null;
/* 258:    */     try
/* 259:    */     {
/* 260:218 */       conn = this.ds.getConnection();
/* 261:219 */       conn.setAutoCommit(false);
/* 262:220 */       String sql = "DELETE FROM sdoctor.recocomprador WHERE consecutivo = ? ";
/* 263:221 */       pstmt = conn.prepareStatement(sql);
/* 264:222 */       pstmt.setBigDecimal(1, data.getConsecutivo());
/* 265:223 */       pstmt.executeUpdate();
/* 266:224 */       close(pstmt);
/* 267:225 */       conn.commit();
/* 268:    */     }
/* 269:    */     catch (SQLException e)
/* 270:    */     {
/* 271:227 */       close(pstmt);
/* 272:228 */       rollback(conn);
/* 273:229 */       throw e;
/* 274:    */     }
/* 275:    */     finally
/* 276:    */     {
/* 277:231 */       close(conn);
/* 278:    */     }
/* 279:    */   }
/* 280:    */   
/* 281:    */   public void deleteGrupo(RecoComprador data)
/* 282:    */     throws SQLException
/* 283:    */   {
/* 284:236 */     Connection conn = null;
/* 285:237 */     PreparedStatement pstmt = null;
/* 286:    */     try
/* 287:    */     {
/* 288:239 */       conn = this.ds.getConnection();
/* 289:240 */       conn.setAutoCommit(false);
/* 290:241 */       String sql = "DELETE FROM sdoctor.recocomprador WHERE consecutivo = ? and reco_grupo_id = ?";
/* 291:242 */       pstmt = conn.prepareStatement(sql);
/* 292:243 */       pstmt.setBigDecimal(1, data.getConsecutivo());
/* 293:244 */       pstmt.setBigDecimal(2, data.getReco_grupo_id());
/* 294:245 */       pstmt.executeUpdate();
/* 295:246 */       close(pstmt);
/* 296:247 */       conn.commit();
/* 297:    */     }
/* 298:    */     catch (SQLException e)
/* 299:    */     {
/* 300:249 */       close(pstmt);
/* 301:250 */       rollback(conn);
/* 302:251 */       throw e;
/* 303:    */     }
/* 304:    */     finally
/* 305:    */     {
/* 306:253 */       close(conn);
/* 307:    */     }
/* 308:    */   }
/* 309:    */   
/* 310:    */   public void deleteAll(BigDecimal reco_grupo_id)
/* 311:    */     throws SQLException
/* 312:    */   {
/* 313:258 */     Connection conn = null;
/* 314:259 */     PreparedStatement pstmt = null;
/* 315:    */     try
/* 316:    */     {
/* 317:261 */       conn = this.ds.getConnection();
/* 318:262 */       conn.setAutoCommit(false);
/* 319:263 */       String sql = "DELETE FROM sdoctor.recocomprador WHERE reco_grupo_id=?";
/* 320:264 */       pstmt = conn.prepareStatement(sql);
/* 321:265 */       pstmt.setBigDecimal(1, reco_grupo_id);
/* 322:266 */       pstmt.executeUpdate();
/* 323:267 */       close(pstmt);
/* 324:268 */       conn.commit();
/* 325:    */     }
/* 326:    */     catch (SQLException e)
/* 327:    */     {
/* 328:270 */       close(pstmt);
/* 329:271 */       rollback(conn);
/* 330:272 */       throw e;
/* 331:    */     }
/* 332:    */     finally
/* 333:    */     {
/* 334:274 */       close(conn);
/* 335:    */     }
/* 336:    */   }
/* 337:    */   
/* 338:    */   public void updateLicencias(Grupo data, String condicionId)
/* 339:    */     throws SQLException
/* 340:    */   {
/* 341:280 */     Connection conn = null;
/* 342:281 */     PreparedStatement pstmt = null;
/* 343:282 */     StringBuilder sb = null;
/* 344:    */     try
/* 345:    */     {
/* 346:284 */       Compras_licenciasDAO compras_licenciasDAO = new Compras_licenciasDAO();
/* 347:285 */       sb = new StringBuilder();
/* 348:286 */       List<Compras_licencias> licencias = compras_licenciasDAO.list(data.getCod_comprador());
/* 349:287 */       for (Compras_licencias compras_licencias : licencias) {
/* 350:288 */         sb.append('\'').append(compras_licencias.getCompras_licencias_codact()).append('\'').append(',');
/* 351:    */       }
/* 352:291 */       UsuarioFamilyDAO usuarioFamilyDAO = new UsuarioFamilyDAO();
/* 353:292 */       usuarioFamilyDAO.updateLicenciasArte(sb.substring(0, sb.length() - 1), condicionId, new BigDecimal(data.getCod_comprador()));
/* 354:    */       
/* 355:294 */       UsuarioPetsDAO usuarioPetsDAO = new UsuarioPetsDAO();
/* 356:295 */       usuarioPetsDAO.updateLicenciasArte(sb.substring(0, sb.length() - 1), condicionId, new BigDecimal(data.getCod_comprador()));
/* 357:    */       
/* 358:297 */       UsuarioCarDAO usuarioCarDAO = new UsuarioCarDAO();
/* 359:298 */       usuarioCarDAO.updateLicenciasArte(sb.substring(0, sb.length() - 1), condicionId, new BigDecimal(data.getCod_comprador()));
/* 360:    */     }
/* 361:    */     catch (SQLException e)
/* 362:    */     {
/* 363:302 */       close(pstmt);
/* 364:303 */       rollback(conn);
/* 365:304 */       throw e;
/* 366:    */     }
/* 367:    */     finally
/* 368:    */     {
/* 369:306 */       close(conn);
/* 370:    */     }
/* 371:    */   }
/* 372:    */   
/* 373:    */   private int getReqMax(Connection conn, RecoComprador data)
/* 374:    */   {
/* 375:311 */     PreparedStatement pstmt = null;
/* 376:312 */     ResultSet rs = null;
/* 377:313 */     int id = 0;
/* 378:    */     try
/* 379:    */     {
/* 380:315 */       String sqlid = "Select max(consecutivo) from sdoctor.recocomprador where artm_may_cod = ?";
/* 381:    */       
/* 382:317 */       pstmt = conn.prepareStatement(sqlid);
/* 383:    */       
/* 384:319 */       rs = pstmt.executeQuery();
/* 385:320 */       if ((rs != null) && (rs.next())) {
/* 386:321 */         id = rs.getInt(1) + 1;
/* 387:    */       } else {
/* 388:323 */         id++;
/* 389:    */       }
/* 390:    */     }
/* 391:    */     catch (SQLException e)
/* 392:    */     {
/* 393:327 */       close(rs);
/* 394:328 */       close(pstmt);
/* 395:329 */       rollback(conn);
/* 396:330 */       e.printStackTrace();
/* 397:    */     }
/* 398:    */     finally
/* 399:    */     {
/* 400:332 */       close(rs);
/* 401:333 */       close(pstmt);
/* 402:    */     }
/* 403:335 */     return id;
/* 404:    */   }
/* 405:    */   
/* 406:    */   private int getMaxMemoryByCompany(Connection conn, RecoComprador data, Grupo data2)
/* 407:    */   {
/* 408:339 */     PreparedStatement pstmt = null;
/* 409:340 */     ResultSet rs = null;
/* 410:341 */     int id = 0;
/* 411:    */     try
/* 412:    */     {
/* 413:343 */       String sqlid = "Select max(sdoctor.recocomprador.reco_grupo_consecutivo) FROM sdoctor.recocomprador  INNER JOIN sdoctor.grupo";
/* 414:344 */       sqlid = sqlid + "   WHERE " + "sdoctor" + ".grupo.consecutivo = " + "sdoctor" + ".recocomprador.reco_grupo_id AND " + "sdoctor" + ".grupo.cod_comprador = ?";
/* 415:345 */       pstmt = conn.prepareStatement(sqlid);
/* 416:346 */       pstmt.setString(1, data2.getCod_comprador());
/* 417:347 */       rs = pstmt.executeQuery();
/* 418:348 */       if ((rs != null) && (rs.next())) {
/* 419:349 */         id = rs.getInt(1) + 1;
/* 420:    */       } else {
/* 421:351 */         id++;
/* 422:    */       }
/* 423:    */     }
/* 424:    */     catch (SQLException e)
/* 425:    */     {
/* 426:355 */       close(rs);
/* 427:356 */       close(pstmt);
/* 428:357 */       rollback(conn);
/* 429:358 */       e.printStackTrace();
/* 430:    */     }
/* 431:    */     finally
/* 432:    */     {
/* 433:360 */       close(rs);
/* 434:361 */       close(pstmt);
/* 435:    */     }
/* 436:363 */     return id;
/* 437:    */   }
/* 438:    */   
/* 439:    */   private int getConsecutivo(Connection conn, RecoComprador data)
/* 440:    */   {
/* 441:367 */     PreparedStatement pstmt = null;
/* 442:368 */     ResultSet rs = null;
/* 443:369 */     int id = 0;
/* 444:    */     try
/* 445:    */     {
/* 446:371 */       String sqlid = "Select max(consecutivo) from sdoctor.recocomprador";
/* 447:    */       
/* 448:373 */       pstmt = conn.prepareStatement(sqlid);
/* 449:374 */       rs = pstmt.executeQuery();
/* 450:375 */       if ((rs != null) && (rs.next())) {
/* 451:376 */         id = rs.getInt(1) + 1;
/* 452:    */       } else {
/* 453:378 */         id++;
/* 454:    */       }
/* 455:    */     }
/* 456:    */     catch (SQLException e)
/* 457:    */     {
/* 458:382 */       close(rs);
/* 459:383 */       close(pstmt);
/* 460:384 */       rollback(conn);
/* 461:385 */       e.printStackTrace();
/* 462:    */     }
/* 463:    */     finally
/* 464:    */     {
/* 465:387 */       close(rs);
/* 466:388 */       close(pstmt);
/* 467:    */     }
/* 468:390 */     return id;
/* 469:    */   }
/* 470:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.RecoCompradorDAO
 * JD-Core Version:    0.7.0.1
 */