/*   1:    */ package com.servidoctor.sdpets.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdpets.model.GruposMascota;
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
/*  16:    */ public class GruposMascotaDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list(BigDecimal grupm_mas_cod)
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 26 */     ArrayList list = new ArrayList();
/*  23: 27 */     Connection conn = null;
/*  24: 28 */     PreparedStatement pstmt = null;
/*  25: 29 */     ResultSet rs = null;
/*  26: 30 */     GruposMascota gruposMascotaS = new GruposMascota();
/*  27:    */     try
/*  28:    */     {
/*  29: 32 */       conn = this.ds.getConnection();
/*  30: 33 */       DBUtil db = new DBUtil();
/*  31: 34 */       String sql = db.creaSQLSELECT(gruposMascotaS);
/*  32: 35 */       String where = " where grupm_mas_cod=" + grupm_mas_cod;
/*  33: 36 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  34: 37 */       rs = pstmt.executeQuery();
/*  35: 38 */       while (rs.next())
/*  36:    */       {
/*  37: 39 */         GruposMascota gruposMascota = new GruposMascota();
/*  38: 40 */         InicializaData.inicializa(gruposMascota.getClass(), gruposMascota);
/*  39: 41 */         populate(gruposMascota, rs);
/*  40: 42 */         list.add(gruposMascota);
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
/*  59:    */   public void update(GruposMascota data, String[] llaves, Connection conn)
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
/*  80:    */   public GruposMascota retrieve(BigDecimal grupm_mas_cod, BigDecimal grupm_cod)
/*  81:    */     throws SQLException
/*  82:    */   {
/*  83: 72 */     GruposMascota gruposMascota = new GruposMascota();
/*  84: 73 */     Connection conn = null;
/*  85: 74 */     PreparedStatement pstmt = null;
/*  86: 75 */     ResultSet rs = null;
/*  87: 76 */     GruposMascota gruposMascotaS = new GruposMascota();
/*  88:    */     try
/*  89:    */     {
/*  90: 78 */       conn = this.ds.getConnection();
/*  91: 79 */       DBUtil db = new DBUtil();
/*  92: 80 */       String sql = db.creaSQLSELECT(gruposMascotaS);
/*  93: 81 */       String where = " where grupm_mas_cod = " + grupm_mas_cod + " and grupm_cod = " + grupm_cod;
/*  94: 82 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  95: 83 */       rs = pstmt.executeQuery();
/*  96: 84 */       if (rs.next())
/*  97:    */       {
/*  98: 85 */         InicializaData.inicializa(gruposMascota.getClass(), gruposMascota);
/*  99: 86 */         populate(gruposMascota, rs);
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
/* 115: 98 */     return gruposMascota;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public GruposMascota search(BigDecimal grupm_mas_cod, BigDecimal grupm_grup_cod)
/* 119:    */     throws SQLException
/* 120:    */   {
/* 121:102 */     GruposMascota gruposMascota = new GruposMascota();
/* 122:103 */     Connection conn = null;
/* 123:104 */     PreparedStatement pstmt = null;
/* 124:105 */     ResultSet rs = null;
/* 125:106 */     GruposMascota gruposMascotaS = new GruposMascota();
/* 126:    */     try
/* 127:    */     {
/* 128:108 */       conn = this.ds.getConnection();
/* 129:109 */       DBUtil db = new DBUtil();
/* 130:110 */       String sql = db.creaSQLSELECT(gruposMascotaS);
/* 131:111 */       String where = " where grupm_mas_cod = " + grupm_mas_cod + " and grupm_grup_cod = " + grupm_grup_cod;
/* 132:112 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 133:113 */       rs = pstmt.executeQuery();
/* 134:114 */       if (rs.next())
/* 135:    */       {
/* 136:115 */         InicializaData.inicializa(gruposMascota.getClass(), gruposMascota);
/* 137:116 */         populate(gruposMascota, rs);
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
/* 153:128 */     return gruposMascota;
/* 154:    */   }
/* 155:    */   
/* 156:    */   public synchronized void insert(GruposMascota data, Connection conn)
/* 157:    */     throws SQLException
/* 158:    */   {
/* 159:132 */     PreparedStatement pstmt = null;
/* 160:    */     try
/* 161:    */     {
/* 162:134 */       int id = 0;
/* 163:135 */       DBUtil db = new DBUtil();
/* 164:    */       
/* 165:137 */       id = getReqMax(conn, data);
/* 166:138 */       data.setGrupm_cod(new BigDecimal(id));
/* 167:139 */       String sql = db.creaSQLINSERT(data);
/* 168:    */       
/* 169:141 */       pstmt = conn.prepareStatement(sql);
/* 170:142 */       pstmt.executeUpdate();
/* 171:    */     }
/* 172:    */     catch (SQLException sqle)
/* 173:    */     {
/* 174:144 */       throw sqle;
/* 175:    */     }
/* 176:    */     finally
/* 177:    */     {
/* 178:146 */       close(pstmt);
/* 179:    */     }
/* 180:    */   }
/* 181:    */   
/* 182:    */   public void delete(GruposMascota data)
/* 183:    */     throws SQLException
/* 184:    */   {
/* 185:151 */     Connection conn = null;
/* 186:152 */     PreparedStatement pstmt = null;
/* 187:    */     try
/* 188:    */     {
/* 189:154 */       conn = this.ds.getConnection();
/* 190:155 */       conn.setAutoCommit(false);
/* 191:156 */       String sql = "DELETE FROM sdoctor.gruposmascota WHERE grupm_cod = ? and grupm_mas_cod = ?";
/* 192:157 */       pstmt = conn.prepareStatement(sql);
/* 193:158 */       pstmt.setBigDecimal(1, data.getGrupm_cod());
/* 194:159 */       pstmt.setBigDecimal(2, data.getGrupm_mas_cod());
/* 195:160 */       pstmt.executeUpdate();
/* 196:161 */       close(pstmt);
/* 197:162 */       conn.commit();
/* 198:    */     }
/* 199:    */     catch (SQLException e)
/* 200:    */     {
/* 201:164 */       close(pstmt);
/* 202:165 */       rollback(conn);
/* 203:166 */       throw e;
/* 204:    */     }
/* 205:    */     finally
/* 206:    */     {
/* 207:168 */       close(conn);
/* 208:    */     }
/* 209:    */   }
/* 210:    */   
/* 211:    */   public void deleteAll(BigDecimal grupm_mas_cod, Connection conn)
/* 212:    */     throws SQLException
/* 213:    */   {
/* 214:173 */     PreparedStatement pstmt = null;
/* 215:    */     try
/* 216:    */     {
/* 217:175 */       String sql = "DELETE FROM sdoctor.gruposmascota WHERE grupm_mas_cod=?";
/* 218:176 */       pstmt = conn.prepareStatement(sql);
/* 219:177 */       pstmt.setBigDecimal(1, grupm_mas_cod);
/* 220:178 */       pstmt.executeUpdate();
/* 221:    */     }
/* 222:    */     catch (SQLException e)
/* 223:    */     {
/* 224:180 */       throw e;
/* 225:    */     }
/* 226:    */     finally
/* 227:    */     {
/* 228:182 */       close(pstmt);
/* 229:    */     }
/* 230:    */   }
/* 231:    */   
/* 232:    */   private int getReqMax(Connection conn, GruposMascota data)
/* 233:    */   {
/* 234:187 */     PreparedStatement pstmt = null;
/* 235:188 */     ResultSet rs = null;
/* 236:189 */     int id = 0;
/* 237:    */     try
/* 238:    */     {
/* 239:191 */       String sqlid = "Select max(grupm_cod) from sdoctor.gruposmascota where grupm_mas_cod = ?";
/* 240:    */       
/* 241:193 */       pstmt = conn.prepareStatement(sqlid);
/* 242:194 */       pstmt.setBigDecimal(1, data.getGrupm_mas_cod());
/* 243:195 */       rs = pstmt.executeQuery();
/* 244:196 */       if ((rs != null) && (rs.next())) {
/* 245:197 */         id = rs.getInt(1) + 1;
/* 246:    */       } else {
/* 247:199 */         id++;
/* 248:    */       }
/* 249:    */     }
/* 250:    */     catch (SQLException e)
/* 251:    */     {
/* 252:203 */       close(rs);
/* 253:204 */       close(pstmt);
/* 254:205 */       rollback(conn);
/* 255:206 */       e.printStackTrace();
/* 256:    */     }
/* 257:    */     finally
/* 258:    */     {
/* 259:208 */       close(rs);
/* 260:209 */       close(pstmt);
/* 261:    */     }
/* 262:211 */     return id;
/* 263:    */   }
/* 264:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdpets.dao.GruposMascotaDAO
 * JD-Core Version:    0.7.0.1
 */