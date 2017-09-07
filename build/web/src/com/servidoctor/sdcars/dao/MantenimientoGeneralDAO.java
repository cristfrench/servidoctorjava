/*   1:    */ package com.servidoctor.sdcars.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdcars.model.MantenimientoGeneral;
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
/*  16:    */ public class MantenimientoGeneralDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public void update(MantenimientoGeneral data, String[] llaves, Connection conn)
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 19 */     PreparedStatement pstmt = null;
/*  23:    */     try
/*  24:    */     {
/*  25: 21 */       DBUtil db = new DBUtil();
/*  26: 22 */       String sql = db.creaSQLUPDATE(data, llaves);
/*  27: 23 */       pstmt = conn.prepareStatement(sql);
/*  28: 24 */       pstmt.executeUpdate();
/*  29:    */     }
/*  30:    */     catch (SQLException e)
/*  31:    */     {
/*  32: 26 */       throw e;
/*  33:    */     }
/*  34:    */     finally
/*  35:    */     {
/*  36: 28 */       close(pstmt);
/*  37:    */     }
/*  38:    */   }
/*  39:    */   
/*  40:    */   public MantenimientoGeneral retrive(BigDecimal mant_cod, BigDecimal mant_veh_cod)
/*  41:    */     throws SQLException
/*  42:    */   {
/*  43: 33 */     MantenimientoGeneral mantenimientoGeneral = new MantenimientoGeneral();
/*  44: 34 */     Connection conn = null;
/*  45: 35 */     PreparedStatement pstmt = null;
/*  46: 36 */     ResultSet rs = null;
/*  47: 37 */     MantenimientoGeneral mantenimientoGeneralS = new MantenimientoGeneral();
/*  48:    */     try
/*  49:    */     {
/*  50: 39 */       conn = this.ds.getConnection();
/*  51: 40 */       DBUtil db = new DBUtil();
/*  52: 41 */       String sql = db.creaSQLSELECT(mantenimientoGeneralS);
/*  53: 42 */       String where = " where mant_cod=" + mant_cod + " and mant_veh_cod = " + mant_veh_cod;
/*  54: 43 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  55: 44 */       rs = pstmt.executeQuery();
/*  56: 45 */       if (rs.next())
/*  57:    */       {
/*  58: 47 */         InicializaData.inicializa(mantenimientoGeneral.getClass(), mantenimientoGeneral);
/*  59: 48 */         populate(mantenimientoGeneral, rs);
/*  60:    */       }
/*  61: 51 */       close(rs);
/*  62: 52 */       close(pstmt);
/*  63:    */     }
/*  64:    */     catch (SQLException e)
/*  65:    */     {
/*  66: 54 */       close(rs);
/*  67: 55 */       close(pstmt);
/*  68: 56 */       rollback(conn);
/*  69: 57 */       throw e;
/*  70:    */     }
/*  71:    */     finally
/*  72:    */     {
/*  73: 59 */       close(conn);
/*  74:    */     }
/*  75: 61 */     return mantenimientoGeneral;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public List list(BigDecimal mant_veh_cod)
/*  79:    */     throws SQLException
/*  80:    */   {
/*  81: 65 */     ArrayList list = list = new ArrayList();
/*  82: 66 */     Connection conn = null;
/*  83: 67 */     PreparedStatement pstmt = null;
/*  84: 68 */     ResultSet rs = null;
/*  85: 69 */     MantenimientoGeneral mantenimientoGeneralS = new MantenimientoGeneral();
/*  86:    */     try
/*  87:    */     {
/*  88: 71 */       conn = this.ds.getConnection();
/*  89: 72 */       DBUtil db = new DBUtil();
/*  90: 73 */       String sql = db.creaSQLSELECT(mantenimientoGeneralS);
/*  91: 74 */       pstmt = conn.prepareStatement(sql + " where mant_veh_cod = ?");
/*  92: 75 */       pstmt.setBigDecimal(1, mant_veh_cod);
/*  93: 76 */       rs = pstmt.executeQuery();
/*  94: 77 */       while (rs.next())
/*  95:    */       {
/*  96: 78 */         MantenimientoGeneral mantenimientoGeneral = new MantenimientoGeneral();
/*  97: 79 */         InicializaData.inicializa(mantenimientoGeneral.getClass(), mantenimientoGeneral);
/*  98: 80 */         populate(mantenimientoGeneral, rs);
/*  99: 81 */         list.add(mantenimientoGeneral);
/* 100:    */       }
/* 101: 83 */       close(rs);
/* 102: 84 */       close(pstmt);
/* 103:    */     }
/* 104:    */     catch (SQLException e)
/* 105:    */     {
/* 106: 86 */       close(rs);
/* 107: 87 */       close(pstmt);
/* 108: 88 */       rollback(conn);
/* 109: 89 */       throw e;
/* 110:    */     }
/* 111:    */     finally
/* 112:    */     {
/* 113: 91 */       close(conn);
/* 114:    */     }
/* 115: 93 */     return list;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public synchronized void insert(MantenimientoGeneral data, Connection conn)
/* 119:    */     throws SQLException
/* 120:    */   {
/* 121: 97 */     PreparedStatement pstmt = null;
/* 122:    */     try
/* 123:    */     {
/* 124:100 */       int id = 0;
/* 125:101 */       DBUtil db = new DBUtil();
/* 126:    */       
/* 127:103 */       id = getReqMax(conn, data.getMant_veh_cod());
/* 128:104 */       data.setMant_cod(new BigDecimal(id));
/* 129:105 */       String sql = db.creaSQLINSERT(data);
/* 130:106 */       pstmt = conn.prepareStatement(sql);
/* 131:107 */       pstmt.executeUpdate();
/* 132:    */     }
/* 133:    */     catch (SQLException sqle)
/* 134:    */     {
/* 135:109 */       throw sqle;
/* 136:    */     }
/* 137:    */     finally
/* 138:    */     {
/* 139:111 */       close(pstmt);
/* 140:    */     }
/* 141:    */   }
/* 142:    */   
/* 143:    */   public void delete(MantenimientoGeneral data)
/* 144:    */     throws SQLException
/* 145:    */   {
/* 146:115 */     Connection conn = null;
/* 147:116 */     PreparedStatement pstmt = null;
/* 148:    */     try
/* 149:    */     {
/* 150:118 */       conn = this.ds.getConnection();
/* 151:119 */       conn.setAutoCommit(false);
/* 152:120 */       String sql = "DELETE FROM sdoctor.mantenimientogeneral WHERE mant_cod=? and mant_veh_cod=?";
/* 153:121 */       pstmt = conn.prepareStatement(sql);
/* 154:122 */       pstmt.setBigDecimal(1, data.getMant_cod());
/* 155:123 */       pstmt.setBigDecimal(2, data.getMant_veh_cod());
/* 156:124 */       pstmt.executeUpdate();
/* 157:125 */       close(pstmt);
/* 158:126 */       conn.commit();
/* 159:    */     }
/* 160:    */     catch (SQLException e)
/* 161:    */     {
/* 162:128 */       close(pstmt);
/* 163:129 */       rollback(conn);
/* 164:130 */       throw e;
/* 165:    */     }
/* 166:    */     finally
/* 167:    */     {
/* 168:132 */       close(conn);
/* 169:    */     }
/* 170:    */   }
/* 171:    */   
/* 172:    */   public void deleteAll(BigDecimal mant_veh_cod, Connection conn)
/* 173:    */     throws SQLException
/* 174:    */   {
/* 175:137 */     PreparedStatement pstmt = null;
/* 176:    */     try
/* 177:    */     {
/* 178:139 */       String sql = "DELETE FROM sdoctor.mantenimientogeneral WHERE mant_veh_cod=?";
/* 179:140 */       pstmt = conn.prepareStatement(sql);
/* 180:141 */       pstmt.setBigDecimal(1, mant_veh_cod);
/* 181:142 */       pstmt.executeUpdate();
/* 182:    */     }
/* 183:    */     catch (SQLException e)
/* 184:    */     {
/* 185:144 */       throw e;
/* 186:    */     }
/* 187:    */     finally
/* 188:    */     {
/* 189:146 */       close(pstmt);
/* 190:    */     }
/* 191:    */   }
/* 192:    */   
/* 193:    */   private int getReqMax(Connection conn, BigDecimal mant_veh_cod)
/* 194:    */     throws SQLException
/* 195:    */   {
/* 196:151 */     PreparedStatement pstmt = null;
/* 197:152 */     ResultSet rs = null;
/* 198:153 */     int id = 0;
/* 199:    */     try
/* 200:    */     {
/* 201:155 */       String sqlid = "Select max(mant_cod) from sdoctor.mantenimientogeneral where mant_veh_cod=?";
/* 202:156 */       pstmt = conn.prepareStatement(sqlid);
/* 203:157 */       pstmt.setBigDecimal(1, mant_veh_cod);
/* 204:158 */       rs = pstmt.executeQuery();
/* 205:159 */       if ((rs != null) && (rs.next())) {
/* 206:160 */         id = rs.getInt(1) + 1;
/* 207:    */       } else {
/* 208:162 */         id++;
/* 209:    */       }
/* 210:    */     }
/* 211:    */     catch (SQLException e)
/* 212:    */     {
/* 213:166 */       close(rs);
/* 214:167 */       close(pstmt);
/* 215:168 */       throw e;
/* 216:    */     }
/* 217:    */     finally
/* 218:    */     {
/* 219:170 */       close(rs);
/* 220:171 */       close(pstmt);
/* 221:    */     }
/* 222:173 */     return id;
/* 223:    */   }
/* 224:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdcars.dao.MantenimientoGeneralDAO
 * JD-Core Version:    0.7.0.1
 */