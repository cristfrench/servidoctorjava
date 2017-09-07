/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.Grupo;
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
/*  21:    */ public class GrupoDAO
/*  22:    */   extends DAO
/*  23:    */ {
/*  24:    */   public void update(Grupo data, String[] llaves)
/*  25:    */     throws SQLException
/*  26:    */   {
/*  27: 29 */     Connection conn = null;
/*  28: 30 */     PreparedStatement pstmt = null;
/*  29:    */     try
/*  30:    */     {
/*  31: 32 */       DBUtil db = new DBUtil();
/*  32: 33 */       conn = this.ds.getConnection();
/*  33: 34 */       conn.setAutoCommit(false);
/*  34: 35 */       String sql = db.creaSQLUPDATE(data, llaves);
/*  35: 36 */       pstmt = conn.prepareStatement(sql);
/*  36: 37 */       pstmt.executeUpdate();
/*  37: 38 */       close(pstmt);
/*  38: 39 */       conn.commit();
/*  39:    */     }
/*  40:    */     catch (SQLException e)
/*  41:    */     {
/*  42: 41 */       close(pstmt);
/*  43: 42 */       rollback(conn);
/*  44: 43 */       throw e;
/*  45:    */     }
/*  46:    */     finally
/*  47:    */     {
/*  48: 45 */       close(conn);
/*  49:    */     }
/*  50:    */   }
/*  51:    */   
/*  52:    */   public Grupo retrieve(BigDecimal consecutivo, String cod_comprador)
/*  53:    */     throws SQLException
/*  54:    */   {
/*  55: 50 */     Grupo grupo = new Grupo();
/*  56: 51 */     Connection conn = null;
/*  57: 52 */     PreparedStatement pstmt = null;
/*  58: 53 */     ResultSet rs = null;
/*  59: 54 */     Grupo grupoS = new Grupo();
/*  60:    */     try
/*  61:    */     {
/*  62: 56 */       conn = this.ds.getConnection();
/*  63: 57 */       DBUtil db = new DBUtil();
/*  64: 58 */       String sql = db.creaSQLSELECT(grupoS);
/*  65: 59 */       String where = " where consecutivo = ? and cod_comprador = ? ";
/*  66: 60 */       pstmt = conn.prepareStatement(sql + where);
/*  67: 61 */       pstmt.setBigDecimal(1, consecutivo);
/*  68: 62 */       pstmt.setString(2, cod_comprador);
/*  69: 63 */       rs = pstmt.executeQuery();
/*  70: 64 */       if (rs.next())
/*  71:    */       {
/*  72: 65 */         InicializaData.inicializa(grupo.getClass(), grupo);
/*  73: 66 */         populate(grupo, rs);
/*  74:    */       }
/*  75: 68 */       close(rs);
/*  76: 69 */       close(pstmt);
/*  77:    */     }
/*  78:    */     catch (SQLException e)
/*  79:    */     {
/*  80: 71 */       close(rs);
/*  81: 72 */       close(pstmt);
/*  82: 73 */       rollback(conn);
/*  83: 74 */       throw e;
/*  84:    */     }
/*  85:    */     finally
/*  86:    */     {
/*  87: 76 */       close(conn);
/*  88:    */     }
/*  89: 78 */     return grupo;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public List list(String consecutivo)
/*  93:    */     throws SQLException
/*  94:    */   {
/*  95: 82 */     ArrayList resultado = new ArrayList();
/*  96: 83 */     Connection conn = null;
/*  97: 84 */     PreparedStatement pstmt = null;
/*  98: 85 */     ResultSet rs = null;
/*  99: 86 */     Grupo grupoS = new Grupo();
/* 100:    */     try
/* 101:    */     {
/* 102: 88 */       conn = this.ds.getConnection();
/* 103: 89 */       String sql = "select distinct consecutivo, cod_comprador, nombre_grupo from grupo";
/* 104: 90 */       String where = " where consecutivo = ?";
/* 105: 91 */       pstmt = conn.prepareStatement(sql + where);
/* 106: 92 */       pstmt.setString(1, consecutivo);
/* 107: 93 */       rs = pstmt.executeQuery();
/* 108: 94 */       while (rs.next())
/* 109:    */       {
/* 110: 95 */         Grupo grupo = new Grupo();
/* 111: 96 */         InicializaData.inicializa(grupo.getClass(), grupo);
/* 112: 97 */         populate(grupo, rs);
/* 113: 98 */         resultado.add(grupo);
/* 114:    */       }
/* 115:101 */       close(rs);
/* 116:102 */       close(pstmt);
/* 117:    */     }
/* 118:    */     catch (SQLException e)
/* 119:    */     {
/* 120:104 */       close(rs);
/* 121:105 */       close(pstmt);
/* 122:106 */       rollback(conn);
/* 123:107 */       throw e;
/* 124:    */     }
/* 125:    */     finally
/* 126:    */     {
/* 127:109 */       close(conn);
/* 128:    */     }
/* 129:111 */     return resultado;
/* 130:    */   }
/* 131:    */   
/* 132:    */   public List list(BigDecimal consecutivo, String cod_comprador)
/* 133:    */     throws SQLException
/* 134:    */   {
/* 135:115 */     ArrayList resultado = new ArrayList();
/* 136:116 */     Connection conn = null;
/* 137:117 */     PreparedStatement pstmt = null;
/* 138:118 */     ResultSet rs = null;
/* 139:119 */     Grupo grupoS = new Grupo();
/* 140:    */     try
/* 141:    */     {
/* 142:121 */       conn = this.ds.getConnection();
/* 143:122 */       DBUtil db = new DBUtil();
/* 144:123 */       String sql = db.creaSQLSELECT(grupoS);
/* 145:124 */       String where = " where consecutivo = ? and cod_comprador = ?";
/* 146:125 */       pstmt = conn.prepareStatement(sql + where);
/* 147:126 */       pstmt.setBigDecimal(1, consecutivo);
/* 148:127 */       pstmt.setString(2, cod_comprador);
/* 149:128 */       rs = pstmt.executeQuery();
/* 150:129 */       while (rs.next())
/* 151:    */       {
/* 152:130 */         Grupo grupo = new Grupo();
/* 153:131 */         InicializaData.inicializa(grupo.getClass(), grupo);
/* 154:132 */         populate(grupo, rs);
/* 155:133 */         resultado.add(grupo);
/* 156:    */       }
/* 157:135 */       close(rs);
/* 158:136 */       close(pstmt);
/* 159:    */     }
/* 160:    */     catch (SQLException e)
/* 161:    */     {
/* 162:138 */       close(rs);
/* 163:139 */       close(pstmt);
/* 164:140 */       rollback(conn);
/* 165:141 */       throw e;
/* 166:    */     }
/* 167:    */     finally
/* 168:    */     {
/* 169:143 */       close(conn);
/* 170:    */     }
/* 171:145 */     return resultado;
/* 172:    */   }
/* 173:    */   
/* 174:    */   public synchronized void insert(Grupo data)
/* 175:    */     throws SQLException
/* 176:    */   {
/* 177:149 */     Connection conn = null;
/* 178:150 */     PreparedStatement pstmt = null;
/* 179:    */     
/* 180:152 */     ResultSet rs = null;
/* 181:    */     try
/* 182:    */     {
/* 183:154 */       int id = 0;
/* 184:155 */       DBUtil db = new DBUtil();
/* 185:    */       
/* 186:157 */       conn = this.ds.getConnection();
/* 187:158 */       conn.setAutoCommit(false);
/* 188:159 */       id = getConsecutivo(conn, data);
/* 189:160 */       data.setConsecutivo(new BigDecimal(id));
/* 190:161 */       String sql = db.creaSQLINSERT(data);
/* 191:    */       
/* 192:163 */       pstmt = conn.prepareStatement(sql);
/* 193:164 */       pstmt.executeUpdate();
/* 194:165 */       pstmt.close();
/* 195:166 */       conn.commit();
/* 196:    */     }
/* 197:    */     catch (SQLException sqle)
/* 198:    */     {
/* 199:168 */       close(rs);
/* 200:169 */       close(pstmt);
/* 201:170 */       rollback(conn);
/* 202:171 */       throw sqle;
/* 203:    */     }
/* 204:    */     finally
/* 205:    */     {
/* 206:173 */       close(rs);
/* 207:174 */       close(pstmt);
/* 208:175 */       close(conn);
/* 209:    */     }
/* 210:    */   }
/* 211:    */   
/* 212:    */   public void delete(Grupo data)
/* 213:    */     throws SQLException
/* 214:    */   {
/* 215:180 */     Connection conn = null;
/* 216:181 */     PreparedStatement pstmt = null;
/* 217:    */     try
/* 218:    */     {
/* 219:183 */       conn = this.ds.getConnection();
/* 220:184 */       conn.setAutoCommit(false);
/* 221:185 */       String sql = "DELETE FROM sdoctor.grupo WHERE consecutivo = ? ";
/* 222:186 */       pstmt = conn.prepareStatement(sql);
/* 223:187 */       pstmt.setBigDecimal(1, data.getConsecutivo());
/* 224:188 */       pstmt.executeUpdate();
/* 225:189 */       close(pstmt);
/* 226:190 */       conn.commit();
/* 227:    */     }
/* 228:    */     catch (SQLException e)
/* 229:    */     {
/* 230:192 */       close(pstmt);
/* 231:193 */       rollback(conn);
/* 232:194 */       throw e;
/* 233:    */     }
/* 234:    */     finally
/* 235:    */     {
/* 236:196 */       close(conn);
/* 237:    */     }
/* 238:    */   }
/* 239:    */   
/* 240:    */   public void deleteGrupo(Grupo data)
/* 241:    */     throws SQLException
/* 242:    */   {
/* 243:201 */     Connection conn = null;
/* 244:202 */     PreparedStatement pstmt = null;
/* 245:    */     try
/* 246:    */     {
/* 247:204 */       conn = this.ds.getConnection();
/* 248:205 */       conn.setAutoCommit(false);
/* 249:206 */       String sql = "DELETE FROM sdoctor.artesmayor WHERE artm_cod = ? and artm_may_cod = ?";
/* 250:207 */       pstmt = conn.prepareStatement(sql);
/* 251:208 */       pstmt.setBigDecimal(1, data.getConsecutivo());
/* 252:209 */       pstmt.setString(2, data.getCod_comprador());
/* 253:210 */       pstmt.executeUpdate();
/* 254:211 */       close(pstmt);
/* 255:212 */       conn.commit();
/* 256:    */     }
/* 257:    */     catch (SQLException e)
/* 258:    */     {
/* 259:214 */       close(pstmt);
/* 260:215 */       rollback(conn);
/* 261:216 */       throw e;
/* 262:    */     }
/* 263:    */     finally
/* 264:    */     {
/* 265:218 */       close(conn);
/* 266:    */     }
/* 267:    */   }
/* 268:    */   
/* 269:    */   public void deleteAll(BigDecimal consecutivo)
/* 270:    */     throws SQLException
/* 271:    */   {
/* 272:223 */     Connection conn = null;
/* 273:224 */     PreparedStatement pstmt = null;
/* 274:    */     try
/* 275:    */     {
/* 276:226 */       conn = this.ds.getConnection();
/* 277:227 */       conn.setAutoCommit(false);
/* 278:228 */       String sql = "DELETE FROM sdoctor.grupo WHERE consecutivo=?";
/* 279:229 */       pstmt = conn.prepareStatement(sql);
/* 280:230 */       pstmt.setBigDecimal(1, consecutivo);
/* 281:231 */       pstmt.executeUpdate();
/* 282:232 */       close(pstmt);
/* 283:233 */       conn.commit();
/* 284:    */     }
/* 285:    */     catch (SQLException e)
/* 286:    */     {
/* 287:235 */       close(pstmt);
/* 288:236 */       rollback(conn);
/* 289:237 */       throw e;
/* 290:    */     }
/* 291:    */     finally
/* 292:    */     {
/* 293:239 */       close(conn);
/* 294:    */     }
/* 295:    */   }
/* 296:    */   
/* 297:    */   public void updateLicencias(Grupo data, String condicionId)
/* 298:    */     throws SQLException
/* 299:    */   {
/* 300:244 */     Connection conn = null;
/* 301:245 */     PreparedStatement pstmt = null;
/* 302:246 */     StringBuilder sb = null;
/* 303:    */     try
/* 304:    */     {
/* 305:248 */       Compras_licenciasDAO compras_licenciasDAO = new Compras_licenciasDAO();
/* 306:249 */       sb = new StringBuilder();
/* 307:250 */       List<Compras_licencias> licencias = compras_licenciasDAO.list(data.getCod_comprador());
/* 308:251 */       for (Compras_licencias compras_licencias : licencias) {
/* 309:252 */         sb.append('\'').append(compras_licencias.getCompras_licencias_codact()).append('\'').append(',');
/* 310:    */       }
/* 311:255 */       UsuarioFamilyDAO usuarioFamilyDAO = new UsuarioFamilyDAO();
/* 312:256 */       usuarioFamilyDAO.updateLicenciasArte(sb.substring(0, sb.length() - 1), condicionId, data.getConsecutivo());
/* 313:    */       
/* 314:258 */       UsuarioPetsDAO usuarioPetsDAO = new UsuarioPetsDAO();
/* 315:259 */       usuarioPetsDAO.updateLicenciasArte(sb.substring(0, sb.length() - 1), condicionId, data.getConsecutivo());
/* 316:    */       
/* 317:261 */       UsuarioCarDAO usuarioCarDAO = new UsuarioCarDAO();
/* 318:262 */       usuarioCarDAO.updateLicenciasArte(sb.substring(0, sb.length() - 1), condicionId, data.getConsecutivo());
/* 319:    */     }
/* 320:    */     catch (SQLException e)
/* 321:    */     {
/* 322:266 */       close(pstmt);
/* 323:267 */       rollback(conn);
/* 324:268 */       throw e;
/* 325:    */     }
/* 326:    */     finally
/* 327:    */     {
/* 328:270 */       close(conn);
/* 329:    */     }
/* 330:    */   }
/* 331:    */   
/* 332:    */   private int getReqMax(Connection conn, Grupo data)
/* 333:    */   {
/* 334:275 */     PreparedStatement pstmt = null;
/* 335:276 */     ResultSet rs = null;
/* 336:277 */     int id = 0;
/* 337:    */     try
/* 338:    */     {
/* 339:279 */       String sqlid = "Select max(artm_cod) from sdoctor.grupo where cod_comprador = ?";
/* 340:    */       
/* 341:281 */       pstmt = conn.prepareStatement(sqlid);
/* 342:282 */       pstmt.setString(1, data.getCod_comprador());
/* 343:283 */       rs = pstmt.executeQuery();
/* 344:284 */       if ((rs != null) && (rs.next())) {
/* 345:285 */         id = rs.getInt(1) + 1;
/* 346:    */       } else {
/* 347:287 */         id++;
/* 348:    */       }
/* 349:    */     }
/* 350:    */     catch (SQLException e)
/* 351:    */     {
/* 352:291 */       close(rs);
/* 353:292 */       close(pstmt);
/* 354:293 */       rollback(conn);
/* 355:294 */       e.printStackTrace();
/* 356:    */     }
/* 357:    */     finally
/* 358:    */     {
/* 359:296 */       close(rs);
/* 360:297 */       close(pstmt);
/* 361:    */     }
/* 362:299 */     return id;
/* 363:    */   }
/* 364:    */   
/* 365:    */   private int getConsecutivo(Connection conn, Grupo data)
/* 366:    */   {
/* 367:304 */     PreparedStatement pstmt = null;
/* 368:305 */     ResultSet rs = null;
/* 369:306 */     int id = 0;
/* 370:    */     try
/* 371:    */     {
/* 372:308 */       String sqlid = "Select max(consecutivo) from sdoctor.grupo";
/* 373:    */       
/* 374:310 */       pstmt = conn.prepareStatement(sqlid);
/* 375:311 */       rs = pstmt.executeQuery();
/* 376:312 */       if ((rs != null) && (rs.next())) {
/* 377:313 */         id = rs.getInt(1) + 1;
/* 378:    */       } else {
/* 379:315 */         id++;
/* 380:    */       }
/* 381:    */     }
/* 382:    */     catch (SQLException e)
/* 383:    */     {
/* 384:319 */       close(rs);
/* 385:320 */       close(pstmt);
/* 386:321 */       rollback(conn);
/* 387:322 */       e.printStackTrace();
/* 388:    */     }
/* 389:    */     finally
/* 390:    */     {
/* 391:324 */       close(rs);
/* 392:325 */       close(pstmt);
/* 393:    */     }
/* 394:327 */     return id;
/* 395:    */   }
/* 396:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.GrupoDAO
 * JD-Core Version:    0.7.0.1
 */