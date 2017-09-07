/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.ArtesMayor;
/*   5:    */ import com.servidoctor.seguridad.dao.Compras_licenciasDAO;
/*   6:    */ import com.servidoctor.seguridad.dao.UsuarioCarDAO;
/*   7:    */ import com.servidoctor.seguridad.dao.UsuarioFamilyDAO;
/*   8:    */ import com.servidoctor.seguridad.dao.UsuarioPetsDAO;
/*   9:    */ import com.servidoctor.seguridad.model.Compras_licencias;
/*  10:    */ import com.servidoctor.util.classes.DBUtil;
/*  11:    */ import com.servidoctor.util.classes.InicializaData;
/*  12:    */ import java.math.BigDecimal;
/*  13:    */ import java.sql.Connection;
/*  14:    */ import java.sql.PreparedStatement;
/*  15:    */ import java.sql.ResultSet;
/*  16:    */ import java.sql.SQLException;
/*  17:    */ import java.util.ArrayList;
/*  18:    */ import java.util.List;
/*  19:    */ import javax.sql.DataSource;
/*  20:    */ 
/*  21:    */ public class ArtesMayorDAO
/*  22:    */   extends DAO
/*  23:    */ {
/*  24:    */   public void update(ArtesMayor data, String[] llaves)
/*  25:    */     throws SQLException
/*  26:    */   {
/*  27: 31 */     Connection conn = null;
/*  28: 32 */     PreparedStatement pstmt = null;
/*  29:    */     try
/*  30:    */     {
/*  31: 34 */       DBUtil db = new DBUtil();
/*  32: 35 */       conn = this.ds.getConnection();
/*  33: 36 */       conn.setAutoCommit(false);
/*  34: 37 */       String sql = db.creaSQLUPDATE(data, llaves);
/*  35: 38 */       pstmt = conn.prepareStatement(sql);
/*  36: 39 */       pstmt.executeUpdate();
/*  37: 40 */       close(pstmt);
/*  38: 41 */       conn.commit();
/*  39:    */     }
/*  40:    */     catch (SQLException e)
/*  41:    */     {
/*  42: 43 */       close(pstmt);
/*  43: 44 */       rollback(conn);
/*  44: 45 */       throw e;
/*  45:    */     }
/*  46:    */     finally
/*  47:    */     {
/*  48: 47 */       close(conn);
/*  49:    */     }
/*  50:    */   }
/*  51:    */   
/*  52:    */   public ArtesMayor retrieve(BigDecimal artm_cod, String artm_may_cod, BigDecimal artm_consecutivo)
/*  53:    */     throws SQLException
/*  54:    */   {
/*  55: 52 */     ArtesMayor artesMayor = new ArtesMayor();
/*  56: 53 */     Connection conn = null;
/*  57: 54 */     PreparedStatement pstmt = null;
/*  58: 55 */     ResultSet rs = null;
/*  59: 56 */     ArtesMayor artesMayorS = new ArtesMayor();
/*  60:    */     try
/*  61:    */     {
/*  62: 58 */       conn = this.ds.getConnection();
/*  63: 59 */       DBUtil db = new DBUtil();
/*  64: 60 */       String sql = db.creaSQLSELECT(artesMayorS);
/*  65: 61 */       String where = " where artm_cod = ? and artm_may_cod = ? and artm_consecutivo = ?";
/*  66: 62 */       pstmt = conn.prepareStatement(sql + where);
/*  67: 63 */       pstmt.setBigDecimal(1, artm_cod);
/*  68: 64 */       pstmt.setString(2, artm_may_cod);
/*  69: 65 */       pstmt.setBigDecimal(3, artm_consecutivo);
/*  70: 66 */       rs = pstmt.executeQuery();
/*  71: 67 */       if (rs.next())
/*  72:    */       {
/*  73: 68 */         InicializaData.inicializa(artesMayor.getClass(), artesMayor);
/*  74: 69 */         populate(artesMayor, rs);
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
/*  90: 81 */     return artesMayor;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public List list(String artm_may_cod)
/*  94:    */     throws SQLException
/*  95:    */   {
/*  96: 85 */     ArrayList resultado = new ArrayList();
/*  97: 86 */     Connection conn = null;
/*  98: 87 */     PreparedStatement pstmt = null;
/*  99: 88 */     ResultSet rs = null;
/* 100: 89 */     ArtesMayor artesMayorS = new ArtesMayor();
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
/* 111: 98 */         ArtesMayor artesMayor = new ArtesMayor();
/* 112: 99 */         InicializaData.inicializa(artesMayor.getClass(), artesMayor);
/* 113:100 */         populate(artesMayor, rs);
/* 114:101 */         resultado.add(artesMayor);
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
/* 133:    */   public List list(BigDecimal artm_cod, String artm_may_cod)
/* 134:    */     throws SQLException
/* 135:    */   {
/* 136:117 */     ArrayList resultado = new ArrayList();
/* 137:118 */     Connection conn = null;
/* 138:119 */     PreparedStatement pstmt = null;
/* 139:120 */     ResultSet rs = null;
/* 140:121 */     ArtesMayor artesMayorS = new ArtesMayor();
/* 141:    */     try
/* 142:    */     {
/* 143:123 */       conn = this.ds.getConnection();
/* 144:124 */       DBUtil db = new DBUtil();
/* 145:125 */       String sql = db.creaSQLSELECT(artesMayorS);
/* 146:126 */       String where = " where artm_cod = ? and artm_may_cod = ?";
/* 147:127 */       pstmt = conn.prepareStatement(sql + where);
/* 148:128 */       pstmt.setBigDecimal(1, artm_cod);
/* 149:129 */       pstmt.setString(2, artm_may_cod);
/* 150:130 */       rs = pstmt.executeQuery();
/* 151:131 */       while (rs.next())
/* 152:    */       {
/* 153:132 */         ArtesMayor artesMayor = new ArtesMayor();
/* 154:133 */         InicializaData.inicializa(artesMayor.getClass(), artesMayor);
/* 155:134 */         populate(artesMayor, rs);
/* 156:135 */         resultado.add(artesMayor);
/* 157:    */       }
/* 158:137 */       close(rs);
/* 159:138 */       close(pstmt);
/* 160:    */     }
/* 161:    */     catch (SQLException e)
/* 162:    */     {
/* 163:140 */       close(rs);
/* 164:141 */       close(pstmt);
/* 165:142 */       rollback(conn);
/* 166:143 */       throw e;
/* 167:    */     }
/* 168:    */     finally
/* 169:    */     {
/* 170:145 */       close(conn);
/* 171:    */     }
/* 172:147 */     return resultado;
/* 173:    */   }
/* 174:    */   
/* 175:    */   public synchronized void insert(ArtesMayor data)
/* 176:    */     throws SQLException
/* 177:    */   {
/* 178:151 */     Connection conn = null;
/* 179:152 */     PreparedStatement pstmt = null;
/* 180:    */     
/* 181:154 */     ResultSet rs = null;
/* 182:    */     try
/* 183:    */     {
/* 184:156 */       int id = 0;
/* 185:157 */       DBUtil db = new DBUtil();
/* 186:    */       
/* 187:159 */       conn = this.ds.getConnection();
/* 188:160 */       conn.setAutoCommit(false);
/* 189:161 */       id = getConsecutivo(conn, data);
/* 190:162 */       data.setArtm_consecutivo(new BigDecimal(id));
/* 191:163 */       String sql = db.creaSQLINSERT(data);
/* 192:    */       
/* 193:165 */       pstmt = conn.prepareStatement(sql);
/* 194:166 */       pstmt.executeUpdate();
/* 195:167 */       pstmt.close();
/* 196:168 */       conn.commit();
/* 197:    */     }
/* 198:    */     catch (SQLException sqle)
/* 199:    */     {
/* 200:170 */       close(rs);
/* 201:171 */       close(pstmt);
/* 202:172 */       rollback(conn);
/* 203:173 */       throw sqle;
/* 204:    */     }
/* 205:    */     finally
/* 206:    */     {
/* 207:175 */       close(rs);
/* 208:176 */       close(pstmt);
/* 209:177 */       close(conn);
/* 210:    */     }
/* 211:    */   }
/* 212:    */   
/* 213:    */   public synchronized void insertGrupo(ArtesMayor data)
/* 214:    */     throws SQLException
/* 215:    */   {
/* 216:182 */     Connection conn = null;
/* 217:183 */     PreparedStatement pstmt = null;
/* 218:    */     
/* 219:185 */     ResultSet rs = null;
/* 220:    */     try
/* 221:    */     {
/* 222:187 */       int id = 0;
/* 223:188 */       DBUtil db = new DBUtil();
/* 224:    */       
/* 225:190 */       conn = this.ds.getConnection();
/* 226:191 */       conn.setAutoCommit(false);
/* 227:192 */       id = getReqMax(conn, data);
/* 228:193 */       data.setArtm_consecutivo(new BigDecimal(1.0D));
/* 229:194 */       data.setArtm_cod(new BigDecimal(id));
/* 230:195 */       String sql = db.creaSQLINSERT(data);
/* 231:    */       
/* 232:197 */       pstmt = conn.prepareStatement(sql);
/* 233:198 */       pstmt.executeUpdate();
/* 234:199 */       pstmt.close();
/* 235:200 */       conn.commit();
/* 236:    */     }
/* 237:    */     catch (SQLException sqle)
/* 238:    */     {
/* 239:202 */       close(rs);
/* 240:203 */       close(pstmt);
/* 241:204 */       rollback(conn);
/* 242:205 */       throw sqle;
/* 243:    */     }
/* 244:    */     finally
/* 245:    */     {
/* 246:207 */       close(rs);
/* 247:208 */       close(pstmt);
/* 248:209 */       close(conn);
/* 249:    */     }
/* 250:    */   }
/* 251:    */   
/* 252:    */   public void delete(ArtesMayor data)
/* 253:    */     throws SQLException
/* 254:    */   {
/* 255:214 */     Connection conn = null;
/* 256:215 */     PreparedStatement pstmt = null;
/* 257:    */     try
/* 258:    */     {
/* 259:217 */       conn = this.ds.getConnection();
/* 260:218 */       conn.setAutoCommit(false);
/* 261:219 */       String sql = "DELETE FROM sdoctor.artesmayor WHERE artm_cod = ? and artm_may_cod = ? and artm_consecutivo = ?";
/* 262:220 */       pstmt = conn.prepareStatement(sql);
/* 263:221 */       pstmt.setBigDecimal(1, data.getArtm_cod());
/* 264:222 */       pstmt.setString(2, data.getArtm_may_cod());
/* 265:223 */       pstmt.setBigDecimal(3, data.getArtm_consecutivo());
/* 266:224 */       pstmt.executeUpdate();
/* 267:225 */       close(pstmt);
/* 268:226 */       conn.commit();
/* 269:    */     }
/* 270:    */     catch (SQLException e)
/* 271:    */     {
/* 272:228 */       close(pstmt);
/* 273:229 */       rollback(conn);
/* 274:230 */       throw e;
/* 275:    */     }
/* 276:    */     finally
/* 277:    */     {
/* 278:232 */       close(conn);
/* 279:    */     }
/* 280:    */   }
/* 281:    */   
/* 282:    */   public void deleteGrupo(ArtesMayor data)
/* 283:    */     throws SQLException
/* 284:    */   {
/* 285:237 */     Connection conn = null;
/* 286:238 */     PreparedStatement pstmt = null;
/* 287:    */     try
/* 288:    */     {
/* 289:240 */       conn = this.ds.getConnection();
/* 290:241 */       conn.setAutoCommit(false);
/* 291:242 */       String sql = "DELETE FROM sdoctor.artesmayor WHERE artm_cod = ? and artm_may_cod = ?";
/* 292:243 */       pstmt = conn.prepareStatement(sql);
/* 293:244 */       pstmt.setBigDecimal(1, data.getArtm_cod());
/* 294:245 */       pstmt.setString(2, data.getArtm_may_cod());
/* 295:246 */       pstmt.executeUpdate();
/* 296:247 */       close(pstmt);
/* 297:248 */       conn.commit();
/* 298:    */     }
/* 299:    */     catch (SQLException e)
/* 300:    */     {
/* 301:250 */       close(pstmt);
/* 302:251 */       rollback(conn);
/* 303:252 */       throw e;
/* 304:    */     }
/* 305:    */     finally
/* 306:    */     {
/* 307:254 */       close(conn);
/* 308:    */     }
/* 309:    */   }
/* 310:    */   
/* 311:    */   public void deleteAll(BigDecimal artm_may_cod)
/* 312:    */     throws SQLException
/* 313:    */   {
/* 314:259 */     Connection conn = null;
/* 315:260 */     PreparedStatement pstmt = null;
/* 316:    */     try
/* 317:    */     {
/* 318:262 */       conn = this.ds.getConnection();
/* 319:263 */       conn.setAutoCommit(false);
/* 320:264 */       String sql = "DELETE FROM sdoctor.artesmayor WHERE artm_may_cod=?";
/* 321:265 */       pstmt = conn.prepareStatement(sql);
/* 322:266 */       pstmt.setBigDecimal(1, artm_may_cod);
/* 323:267 */       pstmt.executeUpdate();
/* 324:268 */       close(pstmt);
/* 325:269 */       conn.commit();
/* 326:    */     }
/* 327:    */     catch (SQLException e)
/* 328:    */     {
/* 329:271 */       close(pstmt);
/* 330:272 */       rollback(conn);
/* 331:273 */       throw e;
/* 332:    */     }
/* 333:    */     finally
/* 334:    */     {
/* 335:275 */       close(conn);
/* 336:    */     }
/* 337:    */   }
/* 338:    */   
/* 339:    */   public void updateLicencias(ArtesMayor data, String condicionId)
/* 340:    */     throws SQLException
/* 341:    */   {
/* 342:280 */     Connection conn = null;
/* 343:281 */     PreparedStatement pstmt = null;
/* 344:282 */     StringBuilder sb = null;
/* 345:    */     try
/* 346:    */     {
/* 347:284 */       Compras_licenciasDAO compras_licenciasDAO = new Compras_licenciasDAO();
/* 348:285 */       sb = new StringBuilder();
/* 349:286 */       List<Compras_licencias> licencias = compras_licenciasDAO.list(data.getArtm_may_cod());
/* 350:287 */       for (Compras_licencias compras_licencias : licencias) {
/* 351:288 */         sb.append('\'').append(compras_licencias.getCompras_licencias_codact()).append('\'').append(',');
/* 352:    */       }
/* 353:291 */       UsuarioFamilyDAO usuarioFamilyDAO = new UsuarioFamilyDAO();
/* 354:292 */       usuarioFamilyDAO.updateLicenciasArte(sb.substring(0, sb.length() - 1), condicionId, data.getArtm_cod());
/* 355:    */       
/* 356:294 */       UsuarioPetsDAO usuarioPetsDAO = new UsuarioPetsDAO();
/* 357:295 */       usuarioPetsDAO.updateLicenciasArte(sb.substring(0, sb.length() - 1), condicionId, data.getArtm_cod());
/* 358:    */       
/* 359:297 */       UsuarioCarDAO usuarioCarDAO = new UsuarioCarDAO();
/* 360:298 */       usuarioCarDAO.updateLicenciasArte(sb.substring(0, sb.length() - 1), condicionId, data.getArtm_cod());
/* 361:    */     }
/* 362:    */     catch (SQLException e)
/* 363:    */     {
/* 364:302 */       close(pstmt);
/* 365:303 */       rollback(conn);
/* 366:304 */       throw e;
/* 367:    */     }
/* 368:    */     finally
/* 369:    */     {
/* 370:306 */       close(conn);
/* 371:    */     }
/* 372:    */   }
/* 373:    */   
/* 374:    */   private int getReqMax(Connection conn, ArtesMayor data)
/* 375:    */   {
/* 376:311 */     PreparedStatement pstmt = null;
/* 377:312 */     ResultSet rs = null;
/* 378:313 */     int id = 0;
/* 379:    */     try
/* 380:    */     {
/* 381:315 */       String sqlid = "Select max(artm_cod) from sdoctor.artesmayor where artm_may_cod = ?";
/* 382:    */       
/* 383:317 */       pstmt = conn.prepareStatement(sqlid);
/* 384:318 */       pstmt.setString(1, data.getArtm_may_cod());
/* 385:319 */       rs = pstmt.executeQuery();
/* 386:320 */       if ((rs != null) && (rs.next())) {
/* 387:321 */         id = rs.getInt(1) + 1;
/* 388:    */       } else {
/* 389:323 */         id++;
/* 390:    */       }
/* 391:    */     }
/* 392:    */     catch (SQLException e)
/* 393:    */     {
/* 394:327 */       close(rs);
/* 395:328 */       close(pstmt);
/* 396:329 */       rollback(conn);
/* 397:330 */       e.printStackTrace();
/* 398:    */     }
/* 399:    */     finally
/* 400:    */     {
/* 401:332 */       close(rs);
/* 402:333 */       close(pstmt);
/* 403:    */     }
/* 404:335 */     return id;
/* 405:    */   }
/* 406:    */   
/* 407:    */   private int getConsecutivo(Connection conn, ArtesMayor data)
/* 408:    */   {
/* 409:339 */     PreparedStatement pstmt = null;
/* 410:340 */     ResultSet rs = null;
/* 411:341 */     int id = 0;
/* 412:    */     try
/* 413:    */     {
/* 414:343 */       String sqlid = "Select max(artm_consecutivo) from sdoctor.artesmayor where artm_cod = ? and artm_may_cod = ?";
/* 415:    */       
/* 416:345 */       pstmt = conn.prepareStatement(sqlid);
/* 417:346 */       pstmt.setBigDecimal(1, data.getArtm_cod());
/* 418:347 */       pstmt.setString(2, data.getArtm_may_cod());
/* 419:348 */       rs = pstmt.executeQuery();
/* 420:349 */       if ((rs != null) && (rs.next())) {
/* 421:350 */         id = rs.getInt(1) + 1;
/* 422:    */       } else {
/* 423:352 */         id++;
/* 424:    */       }
/* 425:    */     }
/* 426:    */     catch (SQLException e)
/* 427:    */     {
/* 428:356 */       close(rs);
/* 429:357 */       close(pstmt);
/* 430:358 */       rollback(conn);
/* 431:359 */       e.printStackTrace();
/* 432:    */     }
/* 433:    */     finally
/* 434:    */     {
/* 435:361 */       close(rs);
/* 436:362 */       close(pstmt);
/* 437:    */     }
/* 438:364 */     return id;
/* 439:    */   }
/* 440:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.ArtesMayorDAO
 * JD-Core Version:    0.7.0.1
 */