/*   1:    */ package com.servidoctor.seguridad.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.seguridad.model.GrupoUsuarioSegmentacion;
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
/*  17:    */ public class GrupoUsuarioSegmentacionDAO
/*  18:    */   extends DAO
/*  19:    */ {
/*  20: 28 */   private static final ResourceBundle prop = ResourceBundle.getBundle("com.servidoctor.resources.Config");
/*  21:    */   
/*  22:    */   public GrupoUsuarioSegmentacionDAO()
/*  23:    */   {
/*  24: 31 */     super(prop.getString("jndi.vega.name"));
/*  25:    */   }
/*  26:    */   
/*  27:    */   public GrupoUsuarioSegmentacion retrieve(String usuario)
/*  28:    */     throws SQLException
/*  29:    */   {
/*  30: 36 */     GrupoUsuarioSegmentacion grupoUsuarioSegmentacion = new GrupoUsuarioSegmentacion();
/*  31: 37 */     Connection conn = null;
/*  32: 38 */     PreparedStatement pstmt = null;
/*  33: 39 */     ResultSet rs = null;
/*  34: 40 */     GrupoUsuarioSegmentacion grupoUsuarioSSegmentacion = new GrupoUsuarioSegmentacion();
/*  35:    */     try
/*  36:    */     {
/*  37: 42 */       conn = this.ds.getConnection();
/*  38: 43 */       DBUtil db = new DBUtil("vega_sdoctor");
/*  39: 44 */       String sql = db.creaSQLSELECT(grupoUsuarioSSegmentacion);
/*  40: 45 */       String where = " where grupousuariosegmentacion.usuario_id LIKE ?";
/*  41: 46 */       pstmt = conn.prepareStatement(sql + where);
/*  42: 47 */       pstmt.setString(1, usuario);
/*  43: 48 */       rs = pstmt.executeQuery();
/*  44: 49 */       if (rs.next())
/*  45:    */       {
/*  46: 52 */         grupoUsuarioSegmentacion.setGrupo_id(rs.getBigDecimal("grupo_id"));
/*  47: 53 */         grupoUsuarioSegmentacion.setUsuario_id(rs.getString("usuario_id"));
/*  48: 54 */         grupoUsuarioSegmentacion.setConsecutivo(rs.getBigDecimal("consecutivo"));
/*  49:    */       }
/*  50: 62 */       close(rs);
/*  51: 63 */       close(pstmt);
/*  52:    */     }
/*  53:    */     catch (SQLException e)
/*  54:    */     {
/*  55: 65 */       close(rs);
/*  56: 66 */       close(pstmt);
/*  57: 67 */       rollback(conn);
/*  58: 68 */       throw e;
/*  59:    */     }
/*  60:    */     finally
/*  61:    */     {
/*  62: 70 */       close(conn);
/*  63:    */     }
/*  64: 72 */     return grupoUsuarioSegmentacion;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public GrupoUsuarioSegmentacion retrive(String usuario, String grupoId)
/*  68:    */     throws SQLException
/*  69:    */   {
/*  70: 77 */     GrupoUsuarioSegmentacion grupoUsuarioSegmentacion = new GrupoUsuarioSegmentacion();
/*  71: 78 */     Connection conn = null;
/*  72: 79 */     PreparedStatement pstmt = null;
/*  73: 80 */     ResultSet rs = null;
/*  74: 81 */     GrupoUsuarioSegmentacion grupoUsuarioSSegmentacion = new GrupoUsuarioSegmentacion();
/*  75:    */     try
/*  76:    */     {
/*  77: 83 */       conn = this.ds.getConnection();
/*  78: 84 */       DBUtil db = new DBUtil("vega_sdoctor");
/*  79: 85 */       String sql = db.creaSQLSELECT(grupoUsuarioSSegmentacion);
/*  80: 86 */       String where = " where grupousuariosegmentacion.usuario_id LIKE ? AND grupousuariosegmentacion.grupo_id=?";
/*  81: 87 */       pstmt = conn.prepareStatement(sql + where);
/*  82: 88 */       pstmt.setString(1, usuario);
/*  83: 89 */       pstmt.setString(2, grupoId);
/*  84: 90 */       rs = pstmt.executeQuery();
/*  85: 91 */       if (rs.next())
/*  86:    */       {
/*  87: 94 */         grupoUsuarioSegmentacion.setGrupo_id(rs.getBigDecimal("grupo_id"));
/*  88: 95 */         grupoUsuarioSegmentacion.setUsuario_id(rs.getString("usuario_id"));
/*  89: 96 */         grupoUsuarioSegmentacion.setConsecutivo(rs.getBigDecimal("consecutivo"));
/*  90:    */       }
/*  91:104 */       close(rs);
/*  92:105 */       close(pstmt);
/*  93:    */     }
/*  94:    */     catch (SQLException e)
/*  95:    */     {
/*  96:107 */       close(rs);
/*  97:108 */       close(pstmt);
/*  98:109 */       rollback(conn);
/*  99:110 */       throw e;
/* 100:    */     }
/* 101:    */     finally
/* 102:    */     {
/* 103:112 */       close(conn);
/* 104:    */     }
/* 105:114 */     return grupoUsuarioSegmentacion;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public List<GrupoUsuarioSegmentacion> list(String compras_merchant_cdgcmp)
/* 109:    */     throws SQLException
/* 110:    */   {
/* 111:118 */     ArrayList<GrupoUsuarioSegmentacion> list = new ArrayList();
/* 112:119 */     Connection conn = null;
/* 113:120 */     PreparedStatement pstmt = null;
/* 114:121 */     ResultSet rs = null;
/* 115:    */     try
/* 116:    */     {
/* 117:123 */       conn = this.ds.getConnection();
/* 118:124 */       String sql = "select compras_licencias_codact from vega_sdoctor.grupousuariosegmentacion join vega_sdoctor.compras_merchant on grupousuariosegmentacion.compras_productos_id = compras_merchant.compras_merchant_id where compras_merchant.compras_merchant_cdgcmp = ?";
/* 119:    */       
/* 120:    */ 
/* 121:    */ 
/* 122:    */ 
/* 123:129 */       pstmt = conn.prepareStatement(sql);
/* 124:130 */       pstmt.setString(1, compras_merchant_cdgcmp);
/* 125:131 */       rs = pstmt.executeQuery();
/* 126:132 */       while (rs.next())
/* 127:    */       {
/* 128:133 */         GrupoUsuarioSegmentacion grupoUsuarioSegmentacion = new GrupoUsuarioSegmentacion();
/* 129:134 */         InicializaData.inicializa(grupoUsuarioSegmentacion.getClass(), grupoUsuarioSegmentacion);
/* 130:135 */         populate(grupoUsuarioSegmentacion, rs);
/* 131:136 */         list.add(grupoUsuarioSegmentacion);
/* 132:    */       }
/* 133:138 */       close(rs);
/* 134:139 */       close(pstmt);
/* 135:    */     }
/* 136:    */     catch (SQLException e)
/* 137:    */     {
/* 138:141 */       close(rs);
/* 139:142 */       close(pstmt);
/* 140:143 */       rollback(conn);
/* 141:144 */       throw e;
/* 142:    */     }
/* 143:    */     finally
/* 144:    */     {
/* 145:146 */       close(conn);
/* 146:    */     }
/* 147:148 */     return list;
/* 148:    */   }
/* 149:    */   
/* 150:    */   public void update(GrupoUsuarioSegmentacion data)
/* 151:    */     throws SQLException
/* 152:    */   {
/* 153:152 */     Connection conn = null;
/* 154:153 */     PreparedStatement pstmt = null;
/* 155:    */     try
/* 156:    */     {
/* 157:155 */       conn = this.ds.getConnection();
/* 158:156 */       conn.setAutoCommit(false);
/* 159:157 */       String sql = "update vega_sdoctor.grupousuariosegmentacion set grupousuariosegmentacion.consecutivo = ?, grupousuariosegmentacion.usuario_id = ? , grupousuariosegmentacion.grupo_id = ? where grupousuariosegmentacion.consecutivo = ?";
/* 160:    */       
/* 161:    */ 
/* 162:160 */       pstmt = conn.prepareStatement(sql);
/* 163:    */       
/* 164:    */ 
/* 165:163 */       pstmt.setBigDecimal(1, data.getConsecutivo());
/* 166:164 */       pstmt.setString(2, data.getUsuario_id());
/* 167:165 */       pstmt.setBigDecimal(3, data.getGrupo_id());
/* 168:166 */       pstmt.setBigDecimal(4, data.getConsecutivo());
/* 169:167 */       pstmt.executeUpdate();
/* 170:168 */       close(pstmt);
/* 171:169 */       conn.commit();
/* 172:    */     }
/* 173:    */     catch (SQLException e)
/* 174:    */     {
/* 175:171 */       close(pstmt);
/* 176:172 */       rollback(conn);
/* 177:173 */       e.printStackTrace();
/* 178:    */     }
/* 179:    */     finally
/* 180:    */     {
/* 181:175 */       close(conn);
/* 182:    */     }
/* 183:    */   }
/* 184:    */   
/* 185:    */   public synchronized void insert(GrupoUsuarioSegmentacion data)
/* 186:    */     throws SQLException
/* 187:    */   {
/* 188:180 */     Connection conn = null;
/* 189:181 */     PreparedStatement pstmt = null;
/* 190:    */     
/* 191:183 */     ResultSet rs = null;
/* 192:    */     try
/* 193:    */     {
/* 194:185 */       int id = 0;
/* 195:186 */       DBUtil db = new DBUtil();
/* 196:187 */       conn = this.ds.getConnection();
/* 197:188 */       conn.setAutoCommit(false);
/* 198:189 */       id = getReqMax(conn);
/* 199:190 */       data.setConsecutivo(new BigDecimal(id));
/* 200:191 */       String sql = "INSERT INTO vega_sdoctor.grupousuariosegmentacion (usuario_id,grupo_id) VALUES('" + data.getUsuario_id() + "'," + data.getGrupo_id() + ");";
/* 201:192 */       String sql2 = db.creaSQLINSERT(data);
/* 202:193 */       pstmt = conn.prepareStatement(sql);
/* 203:194 */       pstmt.executeUpdate();
/* 204:195 */       pstmt.close();
/* 205:196 */       conn.commit();
/* 206:    */     }
/* 207:    */     catch (SQLException sqle)
/* 208:    */     {
/* 209:198 */       close(rs);
/* 210:199 */       close(pstmt);
/* 211:200 */       rollback(conn);
/* 212:201 */       throw sqle;
/* 213:    */     }
/* 214:    */     finally
/* 215:    */     {
/* 216:203 */       close(rs);
/* 217:204 */       close(pstmt);
/* 218:205 */       close(conn);
/* 219:    */     }
/* 220:    */   }
/* 221:    */   
/* 222:    */   private int getReqMax(Connection conn)
/* 223:    */   {
/* 224:210 */     PreparedStatement pstmt = null;
/* 225:211 */     ResultSet rs = null;
/* 226:212 */     int id2 = 0;
/* 227:    */     try
/* 228:    */     {
/* 229:214 */       String sqlid = "Select max(consecutivo) from vega_sdoctor.grupousuariosegmentacion";
/* 230:215 */       pstmt = conn.prepareStatement(sqlid);
/* 231:216 */       rs = pstmt.executeQuery();
/* 232:217 */       if ((rs != null) && (rs.next())) {
/* 233:218 */         id2 = rs.getInt(1) + 1;
/* 234:    */       } else {
/* 235:220 */         id2++;
/* 236:    */       }
/* 237:    */     }
/* 238:    */     catch (SQLException e)
/* 239:    */     {
/* 240:223 */       close(rs);
/* 241:224 */       close(pstmt);
/* 242:225 */       rollback(conn);
/* 243:226 */       e.printStackTrace();
/* 244:    */     }
/* 245:    */     finally
/* 246:    */     {
/* 247:228 */       close(rs);
/* 248:229 */       close(pstmt);
/* 249:    */     }
/* 250:231 */     return id2;
/* 251:    */   }
/* 252:    */   
/* 253:    */   public int count(String usuarioId)
/* 254:    */     throws SQLException
/* 255:    */   {
/* 256:234 */     Connection conn = null;
/* 257:235 */     PreparedStatement pstmt = null;
/* 258:236 */     ResultSet rs = null;
/* 259:237 */     int counter = 0;
/* 260:    */     try
/* 261:    */     {
/* 262:239 */       conn = this.ds.getConnection();
/* 263:240 */       DBUtil db = new DBUtil();
/* 264:241 */       String sql = db.creaSQLSELECT(new GrupoUsuarioSegmentacion());
/* 265:242 */       String where = " where usuario_id = ?";
/* 266:243 */       pstmt = conn.prepareStatement(sql + where);
/* 267:244 */       pstmt.setString(1, usuarioId);
/* 268:245 */       rs = pstmt.executeQuery();
/* 269:246 */       while (rs.next()) {
/* 270:247 */         counter++;
/* 271:    */       }
/* 272:249 */       close(rs);
/* 273:250 */       close(pstmt);
/* 274:    */     }
/* 275:    */     catch (SQLException e)
/* 276:    */     {
/* 277:252 */       close(rs);
/* 278:253 */       close(pstmt);
/* 279:254 */       rollback(conn);
/* 280:255 */       throw e;
/* 281:    */     }
/* 282:    */     finally
/* 283:    */     {
/* 284:257 */       close(conn);
/* 285:    */     }
/* 286:259 */     return counter;
/* 287:    */   }
/* 288:    */   
/* 289:    */   public int countUsersPerGroup(String usuarioId, String grupoId)
/* 290:    */     throws SQLException
/* 291:    */   {
/* 292:263 */     Connection conn = null;
/* 293:264 */     PreparedStatement pstmt = null;
/* 294:265 */     ResultSet rs = null;
/* 295:266 */     int counter = 0;
/* 296:    */     try
/* 297:    */     {
/* 298:268 */       conn = this.ds.getConnection();
/* 299:269 */       DBUtil db = new DBUtil();
/* 300:270 */       String sql = "Select consecutivo,usuario_id,grupo_id from vega_sdoctor.grupousuariosegmentacion";
/* 301:271 */       String where = " where usuario_id = ? AND grupo_id = ?";
/* 302:272 */       pstmt = conn.prepareStatement(sql + where);
/* 303:273 */       pstmt.setString(1, usuarioId);
/* 304:274 */       pstmt.setString(2, grupoId);
/* 305:275 */       rs = pstmt.executeQuery();
/* 306:276 */       while (rs.next()) {
/* 307:277 */         counter++;
/* 308:    */       }
/* 309:279 */       close(rs);
/* 310:280 */       close(pstmt);
/* 311:    */     }
/* 312:    */     catch (SQLException e)
/* 313:    */     {
/* 314:282 */       close(rs);
/* 315:283 */       close(pstmt);
/* 316:284 */       rollback(conn);
/* 317:285 */       throw e;
/* 318:    */     }
/* 319:    */     finally
/* 320:    */     {
/* 321:287 */       close(conn);
/* 322:    */     }
/* 323:289 */     return counter;
/* 324:    */   }
/* 325:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.seguridad.dao.GrupoUsuarioSegmentacionDAO
 * JD-Core Version:    0.7.0.1
 */