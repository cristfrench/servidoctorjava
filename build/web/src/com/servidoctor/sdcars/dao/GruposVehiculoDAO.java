/*   1:    */ package com.servidoctor.sdcars.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdcars.model.GruposVehiculo;
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
/*  16:    */ public class GruposVehiculoDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list(BigDecimal grupv_vehi_cod)
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 26 */     ArrayList list = new ArrayList();
/*  23: 27 */     Connection conn = null;
/*  24: 28 */     PreparedStatement pstmt = null;
/*  25: 29 */     ResultSet rs = null;
/*  26: 30 */     GruposVehiculo gruposVehiculoS = new GruposVehiculo();
/*  27:    */     try
/*  28:    */     {
/*  29: 32 */       conn = this.ds.getConnection();
/*  30: 33 */       DBUtil db = new DBUtil();
/*  31: 34 */       String sql = db.creaSQLSELECT(gruposVehiculoS);
/*  32: 35 */       String where = " where grupv_vehi_cod=" + grupv_vehi_cod;
/*  33: 36 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  34: 37 */       rs = pstmt.executeQuery();
/*  35: 38 */       while (rs.next())
/*  36:    */       {
/*  37: 39 */         GruposVehiculo gruposVehiculo = new GruposVehiculo();
/*  38: 40 */         InicializaData.inicializa(gruposVehiculo.getClass(), gruposVehiculo);
/*  39: 41 */         populate(gruposVehiculo, rs);
/*  40: 42 */         list.add(gruposVehiculo);
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
/*  59:    */   public void update(GruposVehiculo data, String[] llaves)
/*  60:    */     throws SQLException
/*  61:    */   {
/*  62: 58 */     Connection conn = null;
/*  63: 59 */     PreparedStatement pstmt = null;
/*  64:    */     try
/*  65:    */     {
/*  66: 61 */       DBUtil db = new DBUtil();
/*  67: 62 */       conn = this.ds.getConnection();
/*  68: 63 */       conn.setAutoCommit(false);
/*  69: 64 */       String sql = db.creaSQLUPDATE(data, llaves);
/*  70: 65 */       pstmt = conn.prepareStatement(sql);
/*  71: 66 */       pstmt.executeUpdate();
/*  72: 67 */       close(pstmt);
/*  73: 68 */       conn.commit();
/*  74:    */     }
/*  75:    */     catch (SQLException e)
/*  76:    */     {
/*  77: 70 */       close(pstmt);
/*  78: 71 */       rollback(conn);
/*  79: 72 */       throw e;
/*  80:    */     }
/*  81:    */     finally
/*  82:    */     {
/*  83: 74 */       close(conn);
/*  84:    */     }
/*  85:    */   }
/*  86:    */   
/*  87:    */   public GruposVehiculo retrieve(BigDecimal grupv_vehi_cod, BigDecimal grupv_cod)
/*  88:    */     throws SQLException
/*  89:    */   {
/*  90: 79 */     GruposVehiculo gruposVehiculo = new GruposVehiculo();
/*  91: 80 */     Connection conn = null;
/*  92: 81 */     PreparedStatement pstmt = null;
/*  93: 82 */     ResultSet rs = null;
/*  94: 83 */     GruposVehiculo gruposVehiculoS = new GruposVehiculo();
/*  95:    */     try
/*  96:    */     {
/*  97: 85 */       conn = this.ds.getConnection();
/*  98: 86 */       DBUtil db = new DBUtil();
/*  99: 87 */       String sql = db.creaSQLSELECT(gruposVehiculoS);
/* 100: 88 */       String where = " where grupv_vehi_cod = " + grupv_vehi_cod + " and grupv_cod = " + grupv_cod;
/* 101: 89 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 102: 90 */       rs = pstmt.executeQuery();
/* 103: 91 */       if (rs.next())
/* 104:    */       {
/* 105: 92 */         InicializaData.inicializa(gruposVehiculo.getClass(), gruposVehiculo);
/* 106: 93 */         populate(gruposVehiculo, rs);
/* 107:    */       }
/* 108: 95 */       close(rs);
/* 109: 96 */       close(pstmt);
/* 110:    */     }
/* 111:    */     catch (SQLException e)
/* 112:    */     {
/* 113: 98 */       close(rs);
/* 114: 99 */       close(pstmt);
/* 115:100 */       rollback(conn);
/* 116:101 */       throw e;
/* 117:    */     }
/* 118:    */     finally
/* 119:    */     {
/* 120:103 */       close(conn);
/* 121:    */     }
/* 122:105 */     return gruposVehiculo;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public GruposVehiculo search(BigDecimal grupv_vehi_cod, BigDecimal grupv_grup_cod)
/* 126:    */     throws SQLException
/* 127:    */   {
/* 128:109 */     GruposVehiculo gruposVehiculo = new GruposVehiculo();
/* 129:110 */     Connection conn = null;
/* 130:111 */     PreparedStatement pstmt = null;
/* 131:112 */     ResultSet rs = null;
/* 132:113 */     GruposVehiculo gruposVehiculoS = new GruposVehiculo();
/* 133:    */     try
/* 134:    */     {
/* 135:115 */       conn = this.ds.getConnection();
/* 136:116 */       DBUtil db = new DBUtil();
/* 137:117 */       String sql = db.creaSQLSELECT(gruposVehiculoS);
/* 138:118 */       String where = " where grupv_vehi_cod = " + grupv_vehi_cod + " and grupv_grup_cod = " + grupv_grup_cod;
/* 139:119 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 140:120 */       rs = pstmt.executeQuery();
/* 141:121 */       if (rs.next())
/* 142:    */       {
/* 143:122 */         InicializaData.inicializa(gruposVehiculo.getClass(), gruposVehiculo);
/* 144:123 */         populate(gruposVehiculo, rs);
/* 145:    */       }
/* 146:125 */       close(rs);
/* 147:126 */       close(pstmt);
/* 148:    */     }
/* 149:    */     catch (SQLException e)
/* 150:    */     {
/* 151:128 */       close(rs);
/* 152:129 */       close(pstmt);
/* 153:130 */       rollback(conn);
/* 154:131 */       throw e;
/* 155:    */     }
/* 156:    */     finally
/* 157:    */     {
/* 158:133 */       close(conn);
/* 159:    */     }
/* 160:135 */     return gruposVehiculo;
/* 161:    */   }
/* 162:    */   
/* 163:    */   public synchronized void insert(GruposVehiculo data, Connection conn)
/* 164:    */     throws SQLException
/* 165:    */   {
/* 166:139 */     PreparedStatement pstmt = null;
/* 167:    */     try
/* 168:    */     {
/* 169:142 */       int id = 0;
/* 170:143 */       DBUtil db = new DBUtil();
/* 171:    */       
/* 172:145 */       id = getReqMax(conn, data);
/* 173:146 */       data.setGrupv_cod(new BigDecimal(id));
/* 174:147 */       String sql = db.creaSQLINSERT(data);
/* 175:    */       
/* 176:149 */       pstmt = conn.prepareStatement(sql);
/* 177:150 */       pstmt.executeUpdate();
/* 178:    */     }
/* 179:    */     catch (SQLException sqle)
/* 180:    */     {
/* 181:152 */       throw sqle;
/* 182:    */     }
/* 183:    */     finally
/* 184:    */     {
/* 185:154 */       close(pstmt);
/* 186:    */     }
/* 187:    */   }
/* 188:    */   
/* 189:    */   public void delete(GruposVehiculo data)
/* 190:    */     throws SQLException
/* 191:    */   {
/* 192:159 */     Connection conn = null;
/* 193:160 */     PreparedStatement pstmt = null;
/* 194:    */     try
/* 195:    */     {
/* 196:162 */       conn = this.ds.getConnection();
/* 197:163 */       conn.setAutoCommit(false);
/* 198:164 */       String sql = "DELETE FROM sdoctor.gruposvehiculo WHERE grupv_cod = ? and grupv_vehi_cod = ?";
/* 199:165 */       pstmt = conn.prepareStatement(sql);
/* 200:166 */       pstmt.setBigDecimal(1, data.getGrupv_cod());
/* 201:167 */       pstmt.setBigDecimal(2, data.getGrupv_vehi_cod());
/* 202:168 */       pstmt.executeUpdate();
/* 203:169 */       close(pstmt);
/* 204:170 */       conn.commit();
/* 205:    */     }
/* 206:    */     catch (SQLException e)
/* 207:    */     {
/* 208:172 */       close(pstmt);
/* 209:173 */       rollback(conn);
/* 210:174 */       throw e;
/* 211:    */     }
/* 212:    */     finally
/* 213:    */     {
/* 214:176 */       close(conn);
/* 215:    */     }
/* 216:    */   }
/* 217:    */   
/* 218:    */   public void deleteAll(BigDecimal grupv_vehi_cod, Connection conn)
/* 219:    */     throws SQLException
/* 220:    */   {
/* 221:181 */     PreparedStatement pstmt = null;
/* 222:    */     try
/* 223:    */     {
/* 224:183 */       String sql = "DELETE FROM sdoctor.gruposvehiculo WHERE grupv_vehi_cod=?";
/* 225:184 */       pstmt = conn.prepareStatement(sql);
/* 226:185 */       pstmt.setBigDecimal(1, grupv_vehi_cod);
/* 227:186 */       pstmt.executeUpdate();
/* 228:    */     }
/* 229:    */     catch (SQLException e)
/* 230:    */     {
/* 231:188 */       throw e;
/* 232:    */     }
/* 233:    */     finally
/* 234:    */     {
/* 235:190 */       close(pstmt);
/* 236:    */     }
/* 237:    */   }
/* 238:    */   
/* 239:    */   private int getReqMax(Connection conn, GruposVehiculo data)
/* 240:    */     throws SQLException
/* 241:    */   {
/* 242:195 */     PreparedStatement pstmt = null;
/* 243:196 */     ResultSet rs = null;
/* 244:197 */     int id = 0;
/* 245:    */     try
/* 246:    */     {
/* 247:199 */       String sqlid = "Select max(grupv_cod) from sdoctor.gruposvehiculo where grupv_vehi_cod = ?";
/* 248:    */       
/* 249:201 */       pstmt = conn.prepareStatement(sqlid);
/* 250:202 */       pstmt.setBigDecimal(1, data.getGrupv_vehi_cod());
/* 251:203 */       rs = pstmt.executeQuery();
/* 252:204 */       if ((rs != null) && (rs.next())) {
/* 253:205 */         id = rs.getInt(1) + 1;
/* 254:    */       } else {
/* 255:207 */         id++;
/* 256:    */       }
/* 257:    */     }
/* 258:    */     catch (SQLException e)
/* 259:    */     {
/* 260:211 */       close(rs);
/* 261:212 */       close(pstmt);
/* 262:213 */       throw e;
/* 263:    */     }
/* 264:    */     finally
/* 265:    */     {
/* 266:215 */       close(rs);
/* 267:216 */       close(pstmt);
/* 268:    */     }
/* 269:218 */     return id;
/* 270:    */   }
/* 271:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdcars.dao.GruposVehiculoDAO
 * JD-Core Version:    0.7.0.1
 */