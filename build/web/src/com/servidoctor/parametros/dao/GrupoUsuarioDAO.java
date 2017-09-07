/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.GrupoUsuario;
/*   5:    */ import com.servidoctor.util.classes.DBUtil;
/*   6:    */ import com.servidoctor.util.classes.InicializaData;
/*   7:    */ import java.math.BigDecimal;
/*   8:    */ import java.sql.Connection;
/*   9:    */ import java.sql.PreparedStatement;
/*  10:    */ import java.sql.ResultSet;
/*  11:    */ import java.sql.SQLException;
/*  12:    */ import java.util.ArrayList;
/*  13:    */ import java.util.List;
/*  14:    */ import javax.sql.DataSource;
/*  15:    */ 
/*  16:    */ public class GrupoUsuarioDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public void update(GrupoUsuario data, String[] llaves)
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 26 */     Connection conn = null;
/*  23: 27 */     PreparedStatement pstmt = null;
/*  24:    */     try
/*  25:    */     {
/*  26: 29 */       DBUtil db = new DBUtil();
/*  27: 30 */       conn = this.ds.getConnection();
/*  28: 31 */       conn.setAutoCommit(false);
/*  29: 32 */       String sql = db.creaSQLUPDATE(data, llaves);
/*  30: 33 */       pstmt = conn.prepareStatement(sql);
/*  31: 34 */       pstmt.executeUpdate();
/*  32: 35 */       close(pstmt);
/*  33: 36 */       conn.commit();
/*  34:    */     }
/*  35:    */     catch (SQLException e)
/*  36:    */     {
/*  37: 38 */       close(pstmt);
/*  38: 39 */       rollback(conn);
/*  39: 40 */       throw e;
/*  40:    */     }
/*  41:    */     finally
/*  42:    */     {
/*  43: 42 */       close(conn);
/*  44:    */     }
/*  45:    */   }
/*  46:    */   
/*  47:    */   public GrupoUsuario retrieve(BigDecimal consecutivo, String reco_grupo_id, BigDecimal artm_consecutivo)
/*  48:    */     throws SQLException
/*  49:    */   {
/*  50: 47 */     GrupoUsuario grupoUsuario = new GrupoUsuario();
/*  51: 48 */     Connection conn = null;
/*  52: 49 */     PreparedStatement pstmt = null;
/*  53: 50 */     ResultSet rs = null;
/*  54: 51 */     GrupoUsuario grupoUsuarioS = new GrupoUsuario();
/*  55:    */     try
/*  56:    */     {
/*  57: 53 */       conn = this.ds.getConnection();
/*  58: 54 */       DBUtil db = new DBUtil();
/*  59: 55 */       String sql = db.creaSQLSELECT(grupoUsuarioS);
/*  60: 56 */       String where = " where consecutivo = ? and grupo_id = ? ";
/*  61: 57 */       pstmt = conn.prepareStatement(sql + where);
/*  62: 58 */       pstmt.setBigDecimal(1, consecutivo);
/*  63: 59 */       pstmt.setString(2, reco_grupo_id);
/*  64: 60 */       rs = pstmt.executeQuery();
/*  65: 61 */       if (rs.next())
/*  66:    */       {
/*  67: 62 */         InicializaData.inicializa(grupoUsuario.getClass(), grupoUsuario);
/*  68: 63 */         populate(grupoUsuario, rs);
/*  69:    */       }
/*  70: 65 */       close(rs);
/*  71: 66 */       close(pstmt);
/*  72:    */     }
/*  73:    */     catch (SQLException e)
/*  74:    */     {
/*  75: 68 */       close(rs);
/*  76: 69 */       close(pstmt);
/*  77: 70 */       rollback(conn);
/*  78: 71 */       throw e;
/*  79:    */     }
/*  80:    */     finally
/*  81:    */     {
/*  82: 73 */       close(conn);
/*  83:    */     }
/*  84: 75 */     return grupoUsuario;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public List list(String grupo_id)
/*  88:    */     throws SQLException
/*  89:    */   {
/*  90: 79 */     ArrayList resultado = new ArrayList();
/*  91: 80 */     Connection conn = null;
/*  92: 81 */     PreparedStatement pstmt = null;
/*  93: 82 */     ResultSet rs = null;
/*  94: 83 */     GrupoUsuario grupoUsuarioS = new GrupoUsuario();
/*  95:    */     try
/*  96:    */     {
/*  97: 85 */       conn = this.ds.getConnection();
/*  98: 86 */       String sql = "select distinct consecutivo, grupo_id from grupousuario";
/*  99: 87 */       String where = " where grupo_id = ?";
/* 100: 88 */       pstmt = conn.prepareStatement(sql + where);
/* 101: 89 */       pstmt.setString(1, grupo_id);
/* 102: 90 */       rs = pstmt.executeQuery();
/* 103: 91 */       while (rs.next())
/* 104:    */       {
/* 105: 92 */         GrupoUsuario grupoUsuario = new GrupoUsuario();
/* 106: 93 */         InicializaData.inicializa(grupoUsuario.getClass(), grupoUsuario);
/* 107: 94 */         populate(grupoUsuario, rs);
/* 108: 95 */         resultado.add(grupoUsuario);
/* 109:    */       }
/* 110: 97 */       close(rs);
/* 111: 98 */       close(pstmt);
/* 112:    */     }
/* 113:    */     catch (SQLException e)
/* 114:    */     {
/* 115:100 */       close(rs);
/* 116:101 */       close(pstmt);
/* 117:102 */       rollback(conn);
/* 118:103 */       throw e;
/* 119:    */     }
/* 120:    */     finally
/* 121:    */     {
/* 122:105 */       close(conn);
/* 123:    */     }
/* 124:107 */     return resultado;
/* 125:    */   }
/* 126:    */   
/* 127:    */   public List list(BigDecimal consecutivo, String grupo_id)
/* 128:    */     throws SQLException
/* 129:    */   {
/* 130:111 */     ArrayList resultado = new ArrayList();
/* 131:112 */     Connection conn = null;
/* 132:113 */     PreparedStatement pstmt = null;
/* 133:114 */     ResultSet rs = null;
/* 134:115 */     GrupoUsuario grupoUsuarioS = new GrupoUsuario();
/* 135:    */     try
/* 136:    */     {
/* 137:117 */       conn = this.ds.getConnection();
/* 138:118 */       DBUtil db = new DBUtil();
/* 139:119 */       String sql = db.creaSQLSELECT(grupoUsuarioS);
/* 140:120 */       String where = " where consecutivo = ? and grupo_id = ?";
/* 141:121 */       pstmt = conn.prepareStatement(sql + where);
/* 142:122 */       pstmt.setBigDecimal(1, consecutivo);
/* 143:123 */       pstmt.setString(2, grupo_id);
/* 144:124 */       rs = pstmt.executeQuery();
/* 145:125 */       while (rs.next())
/* 146:    */       {
/* 147:126 */         GrupoUsuario grupoUsuario = new GrupoUsuario();
/* 148:127 */         InicializaData.inicializa(grupoUsuario.getClass(), grupoUsuario);
/* 149:128 */         populate(grupoUsuario, rs);
/* 150:129 */         resultado.add(grupoUsuario);
/* 151:    */       }
/* 152:131 */       close(rs);
/* 153:132 */       close(pstmt);
/* 154:    */     }
/* 155:    */     catch (SQLException e)
/* 156:    */     {
/* 157:134 */       close(rs);
/* 158:135 */       close(pstmt);
/* 159:136 */       rollback(conn);
/* 160:137 */       throw e;
/* 161:    */     }
/* 162:    */     finally
/* 163:    */     {
/* 164:139 */       close(conn);
/* 165:    */     }
/* 166:141 */     return resultado;
/* 167:    */   }
/* 168:    */   
/* 169:    */   public synchronized void insert(GrupoUsuario data)
/* 170:    */     throws SQLException
/* 171:    */   {
/* 172:145 */     Connection conn = null;
/* 173:146 */     PreparedStatement pstmt = null;
/* 174:    */     
/* 175:148 */     ResultSet rs = null;
/* 176:    */     try
/* 177:    */     {
/* 178:150 */       int id = 0;
/* 179:151 */       DBUtil db = new DBUtil();
/* 180:    */       
/* 181:153 */       conn = this.ds.getConnection();
/* 182:154 */       conn.setAutoCommit(false);
/* 183:155 */       id = getConsecutivo(conn, data);
/* 184:156 */       data.setConsecutivo(new BigDecimal(id));
/* 185:157 */       String sql = db.creaSQLINSERT(data);
/* 186:    */       
/* 187:159 */       pstmt = conn.prepareStatement(sql);
/* 188:160 */       pstmt.executeUpdate();
/* 189:161 */       pstmt.close();
/* 190:162 */       conn.commit();
/* 191:    */     }
/* 192:    */     catch (SQLException sqle)
/* 193:    */     {
/* 194:164 */       close(rs);
/* 195:165 */       close(pstmt);
/* 196:166 */       rollback(conn);
/* 197:167 */       throw sqle;
/* 198:    */     }
/* 199:    */     finally
/* 200:    */     {
/* 201:169 */       close(rs);
/* 202:170 */       close(pstmt);
/* 203:171 */       close(conn);
/* 204:    */     }
/* 205:    */   }
/* 206:    */   
/* 207:    */   public void delete(GrupoUsuario data)
/* 208:    */     throws SQLException
/* 209:    */   {
/* 210:176 */     Connection conn = null;
/* 211:177 */     PreparedStatement pstmt = null;
/* 212:    */     try
/* 213:    */     {
/* 214:179 */       conn = this.ds.getConnection();
/* 215:180 */       conn.setAutoCommit(false);
/* 216:181 */       String sql = "DELETE FROM sdoctor.grupousuario WHERE consecutivo = ? ";
/* 217:182 */       pstmt = conn.prepareStatement(sql);
/* 218:183 */       pstmt.setBigDecimal(1, data.getConsecutivo());
/* 219:184 */       pstmt.executeUpdate();
/* 220:185 */       close(pstmt);
/* 221:186 */       conn.commit();
/* 222:    */     }
/* 223:    */     catch (SQLException e)
/* 224:    */     {
/* 225:188 */       close(pstmt);
/* 226:189 */       rollback(conn);
/* 227:190 */       throw e;
/* 228:    */     }
/* 229:    */     finally
/* 230:    */     {
/* 231:192 */       close(conn);
/* 232:    */     }
/* 233:    */   }
/* 234:    */   
/* 235:    */   public void deleteGrupo(GrupoUsuario data)
/* 236:    */     throws SQLException
/* 237:    */   {
/* 238:197 */     Connection conn = null;
/* 239:198 */     PreparedStatement pstmt = null;
/* 240:    */     try
/* 241:    */     {
/* 242:200 */       conn = this.ds.getConnection();
/* 243:201 */       conn.setAutoCommit(false);
/* 244:202 */       String sql = "DELETE FROM sdoctor.grupousuario WHERE consecutivo = ? and grupo_id = ?";
/* 245:203 */       pstmt = conn.prepareStatement(sql);
/* 246:204 */       pstmt.setBigDecimal(1, data.getConsecutivo());
/* 247:205 */       pstmt.setBigDecimal(2, data.getGrupo_id());
/* 248:206 */       pstmt.executeUpdate();
/* 249:207 */       close(pstmt);
/* 250:208 */       conn.commit();
/* 251:    */     }
/* 252:    */     catch (SQLException e)
/* 253:    */     {
/* 254:210 */       close(pstmt);
/* 255:211 */       rollback(conn);
/* 256:212 */       throw e;
/* 257:    */     }
/* 258:    */     finally
/* 259:    */     {
/* 260:214 */       close(conn);
/* 261:    */     }
/* 262:    */   }
/* 263:    */   
/* 264:    */   public void deleteAll(BigDecimal grupo_id)
/* 265:    */     throws SQLException
/* 266:    */   {
/* 267:219 */     Connection conn = null;
/* 268:220 */     PreparedStatement pstmt = null;
/* 269:    */     try
/* 270:    */     {
/* 271:222 */       conn = this.ds.getConnection();
/* 272:223 */       conn.setAutoCommit(false);
/* 273:224 */       String sql = "DELETE FROM sdoctor.grupousuario WHERE grupo_id=?";
/* 274:225 */       pstmt = conn.prepareStatement(sql);
/* 275:226 */       pstmt.setBigDecimal(1, grupo_id);
/* 276:227 */       pstmt.executeUpdate();
/* 277:228 */       close(pstmt);
/* 278:229 */       conn.commit();
/* 279:    */     }
/* 280:    */     catch (SQLException e)
/* 281:    */     {
/* 282:231 */       close(pstmt);
/* 283:232 */       rollback(conn);
/* 284:233 */       throw e;
/* 285:    */     }
/* 286:    */     finally
/* 287:    */     {
/* 288:235 */       close(conn);
/* 289:    */     }
/* 290:    */   }
/* 291:    */   
/* 292:    */   public void updateLicencias(GrupoUsuario data, String condicionId)
/* 293:    */     throws SQLException
/* 294:    */   {
/* 295:240 */     Connection conn = null;
/* 296:241 */     PreparedStatement pstmt = null;
/* 297:242 */     StringBuilder sb = null;
/* 298:    */   }
/* 299:    */   
/* 300:    */   private int getConsecutivo(Connection conn, GrupoUsuario data)
/* 301:    */   {
/* 302:328 */     PreparedStatement pstmt = null;
/* 303:329 */     ResultSet rs = null;
/* 304:330 */     int id = 0;
/* 305:    */     try
/* 306:    */     {
/* 307:332 */       String sqlid = "Select max(consecutivo) from sdoctor.grupousuario";
/* 308:    */       
/* 309:334 */       pstmt = conn.prepareStatement(sqlid);
/* 310:335 */       rs = pstmt.executeQuery();
/* 311:336 */       if ((rs != null) && (rs.next())) {
/* 312:337 */         id = rs.getInt(1) + 1;
/* 313:    */       } else {
/* 314:339 */         id++;
/* 315:    */       }
/* 316:    */     }
/* 317:    */     catch (SQLException e)
/* 318:    */     {
/* 319:343 */       close(rs);
/* 320:344 */       close(pstmt);
/* 321:345 */       rollback(conn);
/* 322:346 */       e.printStackTrace();
/* 323:    */     }
/* 324:    */     finally
/* 325:    */     {
/* 326:348 */       close(rs);
/* 327:349 */       close(pstmt);
/* 328:    */     }
/* 329:351 */     return id;
/* 330:    */   }
/* 331:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.GrupoUsuarioDAO
 * JD-Core Version:    0.7.0.1
 */