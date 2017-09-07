/*   1:    */ package com.servidoctor.sdfamily.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdfamily.model.GruposUsuario;
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
/*  16:    */ public class GruposUsuarioDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list(BigDecimal grupu_usuf_cod)
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 26 */     ArrayList list = new ArrayList();
/*  23: 27 */     Connection conn = null;
/*  24: 28 */     PreparedStatement pstmt = null;
/*  25: 29 */     ResultSet rs = null;
/*  26: 30 */     GruposUsuario gruposUsuarioS = new GruposUsuario();
/*  27:    */     try
/*  28:    */     {
/*  29: 32 */       conn = this.ds.getConnection();
/*  30: 33 */       DBUtil db = new DBUtil();
/*  31: 34 */       String sql = db.creaSQLSELECT(gruposUsuarioS);
/*  32: 35 */       String where = " where grupu_usuf_cod=" + grupu_usuf_cod;
/*  33: 36 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  34: 37 */       rs = pstmt.executeQuery();
/*  35: 38 */       while (rs.next())
/*  36:    */       {
/*  37: 39 */         GruposUsuario gruposUsuario = new GruposUsuario();
/*  38: 40 */         InicializaData.inicializa(gruposUsuario.getClass(), gruposUsuario);
/*  39: 41 */         populate(gruposUsuario, rs);
/*  40: 42 */         list.add(gruposUsuario);
/*  41:    */       }
/*  42: 44 */       close(rs);
/*  43: 45 */       close(pstmt);
/*  44:    */     }
/*  45:    */     catch (SQLException e)
/*  46:    */     {
/*  47: 47 */       close(rs);
/*  48: 48 */       close(pstmt);
/*  49: 49 */       rollback(conn);
/*  50: 50 */       throw e;
/*  51:    */     }
/*  52:    */     finally
/*  53:    */     {
/*  54: 52 */       close(conn);
/*  55:    */     }
/*  56: 54 */     return list;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public void update(GruposUsuario data, String[] llaves, Connection conn)
/*  60:    */     throws SQLException
/*  61:    */   {
/*  62: 58 */     PreparedStatement pstmt = null;
/*  63:    */     try
/*  64:    */     {
/*  65: 60 */       DBUtil db = new DBUtil();
/*  66: 61 */       String sql = db.creaSQLUPDATE(data, llaves);
/*  67: 62 */       pstmt = conn.prepareStatement(sql);
/*  68: 63 */       pstmt.executeUpdate();
/*  69:    */     }
/*  70:    */     catch (SQLException e)
/*  71:    */     {
/*  72: 65 */       throw e;
/*  73:    */     }
/*  74:    */     finally
/*  75:    */     {
/*  76: 67 */       close(pstmt);
/*  77:    */     }
/*  78:    */   }
/*  79:    */   
/*  80:    */   public GruposUsuario retrieve(BigDecimal grupu_usuf_cod, BigDecimal grupu_cod)
/*  81:    */     throws SQLException
/*  82:    */   {
/*  83: 72 */     GruposUsuario gruposUsuario = new GruposUsuario();
/*  84: 73 */     Connection conn = null;
/*  85: 74 */     PreparedStatement pstmt = null;
/*  86: 75 */     ResultSet rs = null;
/*  87: 76 */     GruposUsuario gruposUsuarioS = new GruposUsuario();
/*  88:    */     try
/*  89:    */     {
/*  90: 78 */       conn = this.ds.getConnection();
/*  91: 79 */       DBUtil db = new DBUtil();
/*  92: 80 */       String sql = db.creaSQLSELECT(gruposUsuarioS);
/*  93: 81 */       String where = " where grupu_usuf_cod = " + grupu_usuf_cod + " and grupu_cod = " + grupu_cod;
/*  94: 82 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  95: 83 */       rs = pstmt.executeQuery();
/*  96: 84 */       if (rs.next())
/*  97:    */       {
/*  98: 85 */         InicializaData.inicializa(gruposUsuario.getClass(), gruposUsuario);
/*  99: 86 */         populate(gruposUsuario, rs);
/* 100:    */       }
/* 101: 88 */       close(rs);
/* 102: 89 */       close(pstmt);
/* 103:    */     }
/* 104:    */     catch (SQLException e)
/* 105:    */     {
/* 106: 91 */       close(rs);
/* 107: 92 */       close(pstmt);
/* 108: 93 */       rollback(conn);
/* 109: 94 */       throw e;
/* 110:    */     }
/* 111:    */     finally
/* 112:    */     {
/* 113: 96 */       close(conn);
/* 114:    */     }
/* 115: 98 */     return gruposUsuario;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public GruposUsuario retrieveDays(BigDecimal grupu_usuf_cod, BigDecimal grupu_cod)
/* 119:    */     throws SQLException
/* 120:    */   {
/* 121:102 */     GruposUsuario gruposUsuario = new GruposUsuario();
/* 122:103 */     Connection conn = null;
/* 123:104 */     PreparedStatement pstmt = null;
/* 124:105 */     ResultSet rs = null;
/* 125:106 */     GruposUsuario gruposUsuarioS = new GruposUsuario();
/* 126:    */     try
/* 127:    */     {
/* 128:108 */       conn = this.ds.getConnection();
/* 129:109 */       DBUtil db = new DBUtil();
/* 130:110 */       String sql = db.creaSQLSELECT(gruposUsuarioS);
/* 131:111 */       String where = " where grupu_usuf_cod = " + grupu_usuf_cod + " and grupu_grup_cod = " + grupu_cod;
/* 132:112 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 133:113 */       rs = pstmt.executeQuery();
/* 134:114 */       if (rs.next())
/* 135:    */       {
/* 136:115 */         InicializaData.inicializa(gruposUsuario.getClass(), gruposUsuario);
/* 137:116 */         populate(gruposUsuario, rs);
/* 138:    */       }
/* 139:118 */       close(rs);
/* 140:119 */       close(pstmt);
/* 141:    */     }
/* 142:    */     catch (SQLException e)
/* 143:    */     {
/* 144:121 */       close(rs);
/* 145:122 */       close(pstmt);
/* 146:123 */       rollback(conn);
/* 147:124 */       throw e;
/* 148:    */     }
/* 149:    */     finally
/* 150:    */     {
/* 151:126 */       close(conn);
/* 152:    */     }
/* 153:128 */     return gruposUsuario;
/* 154:    */   }
/* 155:    */   
/* 156:    */   public GruposUsuario search(BigDecimal grupu_usuf_cod, BigDecimal grupu_grup_cod)
/* 157:    */     throws SQLException
/* 158:    */   {
/* 159:132 */     GruposUsuario gruposUsuario = new GruposUsuario();
/* 160:133 */     Connection conn = null;
/* 161:134 */     PreparedStatement pstmt = null;
/* 162:135 */     ResultSet rs = null;
/* 163:136 */     GruposUsuario gruposUsuarioS = new GruposUsuario();
/* 164:    */     try
/* 165:    */     {
/* 166:138 */       conn = this.ds.getConnection();
/* 167:139 */       DBUtil db = new DBUtil();
/* 168:140 */       String sql = db.creaSQLSELECT(gruposUsuarioS);
/* 169:141 */       String where = " where grupu_usuf_cod = " + grupu_usuf_cod + " and grupu_grup_cod = " + grupu_grup_cod;
/* 170:142 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 171:143 */       rs = pstmt.executeQuery();
/* 172:144 */       if (rs.next())
/* 173:    */       {
/* 174:145 */         InicializaData.inicializa(gruposUsuario.getClass(), gruposUsuario);
/* 175:146 */         populate(gruposUsuario, rs);
/* 176:    */       }
/* 177:148 */       close(rs);
/* 178:149 */       close(pstmt);
/* 179:    */     }
/* 180:    */     catch (SQLException e)
/* 181:    */     {
/* 182:151 */       close(rs);
/* 183:152 */       close(pstmt);
/* 184:153 */       rollback(conn);
/* 185:154 */       throw e;
/* 186:    */     }
/* 187:    */     finally
/* 188:    */     {
/* 189:156 */       close(conn);
/* 190:    */     }
/* 191:158 */     return gruposUsuario;
/* 192:    */   }
/* 193:    */   
/* 194:    */   public synchronized void insert(GruposUsuario data, Connection conn)
/* 195:    */     throws SQLException
/* 196:    */   {
/* 197:162 */     PreparedStatement pstmt = null;
/* 198:    */     try
/* 199:    */     {
/* 200:164 */       int id = 0;
/* 201:165 */       DBUtil db = new DBUtil();
/* 202:    */       
/* 203:167 */       id = getReqMax(conn, data);
/* 204:168 */       data.setGrupu_cod(new BigDecimal(id));
/* 205:169 */       String sql = db.creaSQLINSERT(data);
/* 206:    */       
/* 207:171 */       pstmt = conn.prepareStatement(sql);
/* 208:172 */       pstmt.executeUpdate();
/* 209:    */     }
/* 210:    */     catch (SQLException sqle)
/* 211:    */     {
/* 212:174 */       throw sqle;
/* 213:    */     }
/* 214:    */     finally
/* 215:    */     {
/* 216:176 */       close(pstmt);
/* 217:    */     }
/* 218:    */   }
/* 219:    */   
/* 220:    */   public void delete(GruposUsuario data, Connection conn)
/* 221:    */     throws SQLException
/* 222:    */   {
/* 223:181 */     PreparedStatement pstmt = null;
/* 224:    */     try
/* 225:    */     {
/* 226:183 */       String sql = "DELETE FROM sdoctor.gruposusuario WHERE grupu_cod = ? and grupu_usuf_cod = ?";
/* 227:184 */       pstmt = conn.prepareStatement(sql);
/* 228:185 */       pstmt.setBigDecimal(1, data.getGrupu_cod());
/* 229:186 */       pstmt.setBigDecimal(2, data.getGrupu_usuf_cod());
/* 230:187 */       pstmt.executeUpdate();
/* 231:    */     }
/* 232:    */     catch (SQLException e)
/* 233:    */     {
/* 234:189 */       throw e;
/* 235:    */     }
/* 236:    */     finally
/* 237:    */     {
/* 238:191 */       close(pstmt);
/* 239:    */     }
/* 240:    */   }
/* 241:    */   
/* 242:    */   public void deleteAll(BigDecimal grupu_usuf_cod)
/* 243:    */     throws SQLException
/* 244:    */   {
/* 245:196 */     Connection conn = null;
/* 246:197 */     PreparedStatement pstmt = null;
/* 247:    */     try
/* 248:    */     {
/* 249:199 */       conn = this.ds.getConnection();
/* 250:200 */       conn.setAutoCommit(false);
/* 251:201 */       String sql = "DELETE FROM sdoctor.gruposusuario WHERE grupu_usuf_cod=?";
/* 252:202 */       pstmt = conn.prepareStatement(sql);
/* 253:203 */       pstmt.setBigDecimal(1, grupu_usuf_cod);
/* 254:204 */       pstmt.executeUpdate();
/* 255:205 */       close(pstmt);
/* 256:206 */       conn.commit();
/* 257:    */     }
/* 258:    */     catch (SQLException e)
/* 259:    */     {
/* 260:208 */       close(pstmt);
/* 261:209 */       rollback(conn);
/* 262:210 */       throw e;
/* 263:    */     }
/* 264:    */     finally
/* 265:    */     {
/* 266:212 */       close(conn);
/* 267:    */     }
/* 268:    */   }
/* 269:    */   
/* 270:    */   private int getReqMax(Connection conn, GruposUsuario data)
/* 271:    */     throws SQLException
/* 272:    */   {
/* 273:217 */     PreparedStatement pstmt = null;
/* 274:218 */     ResultSet rs = null;
/* 275:219 */     int id = 0;
/* 276:    */     try
/* 277:    */     {
/* 278:221 */       String sqlid = "Select max(grupu_cod) from sdoctor.gruposusuario where grupu_usuf_cod = ?";
/* 279:    */       
/* 280:223 */       pstmt = conn.prepareStatement(sqlid);
/* 281:224 */       pstmt.setBigDecimal(1, data.getGrupu_usuf_cod());
/* 282:225 */       rs = pstmt.executeQuery();
/* 283:226 */       if ((rs != null) && (rs.next())) {
/* 284:227 */         id = rs.getInt(1) + 1;
/* 285:    */       } else {
/* 286:229 */         id++;
/* 287:    */       }
/* 288:    */     }
/* 289:    */     catch (SQLException e)
/* 290:    */     {
/* 291:233 */       throw e;
/* 292:    */     }
/* 293:    */     finally
/* 294:    */     {
/* 295:235 */       close(rs);
/* 296:236 */       close(pstmt);
/* 297:    */     }
/* 298:238 */     return id;
/* 299:    */   }
/* 300:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.dao.GruposUsuarioDAO
 * JD-Core Version:    0.7.0.1
 */