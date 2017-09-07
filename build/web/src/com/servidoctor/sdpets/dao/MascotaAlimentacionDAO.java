/*   1:    */ package com.servidoctor.sdpets.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdpets.model.MascotaAlimentacion;
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
/*  16:    */ public class MascotaAlimentacionDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public void insert(MascotaAlimentacion data, Connection conn)
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 19 */     PreparedStatement pstmt = null;
/*  23:    */     try
/*  24:    */     {
/*  25: 21 */       int id = 0;
/*  26:    */       
/*  27: 23 */       DBUtil db = new DBUtil();
/*  28: 24 */       id = getReqMax(conn, data.getMali_mas_cod().toString());
/*  29: 25 */       data.setMali_cod(new BigDecimal(id));
/*  30: 26 */       String sql = db.creaSQLINSERT(data);
/*  31: 27 */       pstmt = conn.prepareStatement(sql);
/*  32: 28 */       pstmt.executeUpdate();
/*  33:    */     }
/*  34:    */     catch (SQLException sqle)
/*  35:    */     {
/*  36: 30 */       throw sqle;
/*  37:    */     }
/*  38:    */     finally
/*  39:    */     {
/*  40: 32 */       close(pstmt);
/*  41:    */     }
/*  42:    */   }
/*  43:    */   
/*  44:    */   public void update(MascotaAlimentacion data, String[] llaves, Connection conn)
/*  45:    */     throws SQLException
/*  46:    */   {
/*  47: 37 */     PreparedStatement pstmt = null;
/*  48:    */     try
/*  49:    */     {
/*  50: 39 */       DBUtil db = new DBUtil();
/*  51: 40 */       String sql = db.creaSQLUPDATE(data, llaves);
/*  52: 41 */       pstmt = conn.prepareStatement(sql);
/*  53: 42 */       pstmt.executeUpdate();
/*  54:    */     }
/*  55:    */     catch (SQLException e)
/*  56:    */     {
/*  57: 44 */       throw e;
/*  58:    */     }
/*  59:    */     finally
/*  60:    */     {
/*  61: 46 */       close(pstmt);
/*  62:    */     }
/*  63:    */   }
/*  64:    */   
/*  65:    */   public void delete(BigDecimal mali_cod, BigDecimal mali_mas_cod)
/*  66:    */     throws SQLException
/*  67:    */   {
/*  68: 52 */     Connection conn = null;
/*  69: 53 */     PreparedStatement pstmt = null;
/*  70:    */     try
/*  71:    */     {
/*  72: 55 */       conn = this.ds.getConnection();
/*  73: 56 */       conn.setAutoCommit(false);
/*  74: 57 */       String sql = "DELETE FROM sdoctor.mascotaalimentacion WHERE mali_cod=? and mali_mas_cod = ?";
/*  75: 58 */       pstmt = conn.prepareStatement(sql);
/*  76: 59 */       pstmt.setBigDecimal(1, mali_cod);
/*  77: 60 */       pstmt.setBigDecimal(2, mali_mas_cod);
/*  78: 61 */       pstmt.executeUpdate();
/*  79: 62 */       close(pstmt);
/*  80: 63 */       conn.commit();
/*  81:    */     }
/*  82:    */     catch (SQLException e)
/*  83:    */     {
/*  84: 65 */       close(pstmt);
/*  85: 66 */       rollback(conn);
/*  86: 67 */       throw e;
/*  87:    */     }
/*  88:    */     finally
/*  89:    */     {
/*  90: 69 */       close(conn);
/*  91:    */     }
/*  92:    */   }
/*  93:    */   
/*  94:    */   public void deleteAll(BigDecimal mali_mas_cod, Connection conn)
/*  95:    */     throws SQLException
/*  96:    */   {
/*  97: 74 */     PreparedStatement pstmt = null;
/*  98:    */     try
/*  99:    */     {
/* 100: 76 */       String sql = "DELETE FROM sdoctor.mascotaalimentacion WHERE mali_mas_cod=?";
/* 101: 77 */       pstmt = conn.prepareStatement(sql);
/* 102: 78 */       pstmt.setBigDecimal(1, mali_mas_cod);
/* 103: 79 */       pstmt.executeUpdate();
/* 104:    */     }
/* 105:    */     catch (SQLException e)
/* 106:    */     {
/* 107: 81 */       throw e;
/* 108:    */     }
/* 109:    */     finally
/* 110:    */     {
/* 111: 83 */       close(pstmt);
/* 112:    */     }
/* 113:    */   }
/* 114:    */   
/* 115:    */   public MascotaAlimentacion retrieve(BigDecimal mali_cod, BigDecimal mali_mas_cod)
/* 116:    */     throws SQLException
/* 117:    */   {
/* 118: 89 */     MascotaAlimentacion mascotaAlimentacion = new MascotaAlimentacion();
/* 119: 90 */     Connection conn = null;
/* 120: 91 */     PreparedStatement pstmt = null;
/* 121: 92 */     ResultSet rs = null;
/* 122: 93 */     MascotaAlimentacion mascotaAlimentacionS = new MascotaAlimentacion();
/* 123:    */     try
/* 124:    */     {
/* 125: 95 */       conn = this.ds.getConnection();
/* 126: 96 */       DBUtil db = new DBUtil();
/* 127: 97 */       String sql = db.creaSQLSELECT(mascotaAlimentacionS);
/* 128: 98 */       String where = " where mali_mas_cod = " + mali_mas_cod + " and mali_cod = " + mali_cod;
/* 129: 99 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 130:100 */       rs = pstmt.executeQuery();
/* 131:101 */       if (rs.next())
/* 132:    */       {
/* 133:102 */         InicializaData.inicializa(mascotaAlimentacion.getClass(), mascotaAlimentacion);
/* 134:103 */         populate(mascotaAlimentacion, rs);
/* 135:    */       }
/* 136:105 */       close(rs);
/* 137:106 */       close(pstmt);
/* 138:    */     }
/* 139:    */     catch (SQLException e)
/* 140:    */     {
/* 141:108 */       close(rs);
/* 142:109 */       close(pstmt);
/* 143:110 */       rollback(conn);
/* 144:111 */       throw e;
/* 145:    */     }
/* 146:    */     finally
/* 147:    */     {
/* 148:113 */       close(conn);
/* 149:    */     }
/* 150:115 */     return mascotaAlimentacion;
/* 151:    */   }
/* 152:    */   
/* 153:    */   public List list(BigDecimal mali_mas_cod)
/* 154:    */     throws SQLException
/* 155:    */   {
/* 156:120 */     ArrayList list = new ArrayList();
/* 157:121 */     Connection conn = null;
/* 158:122 */     PreparedStatement pstmt = null;
/* 159:123 */     ResultSet rs = null;
/* 160:124 */     MascotaAlimentacion mascotaAlimentacionS = new MascotaAlimentacion();
/* 161:    */     try
/* 162:    */     {
/* 163:126 */       conn = this.ds.getConnection();
/* 164:127 */       DBUtil db = new DBUtil();
/* 165:128 */       String sql = db.creaSQLSELECT(mascotaAlimentacionS);
/* 166:129 */       String where = " where mali_mas_cod = " + mali_mas_cod;
/* 167:130 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 168:131 */       rs = pstmt.executeQuery();
/* 169:132 */       while (rs.next())
/* 170:    */       {
/* 171:133 */         MascotaAlimentacion mascotaAlimentacion = new MascotaAlimentacion();
/* 172:134 */         InicializaData.inicializa(mascotaAlimentacion.getClass(), mascotaAlimentacion);
/* 173:135 */         populate(mascotaAlimentacion, rs);
/* 174:136 */         list.add(mascotaAlimentacion);
/* 175:    */       }
/* 176:138 */       close(rs);
/* 177:139 */       close(pstmt);
/* 178:    */     }
/* 179:    */     catch (SQLException e)
/* 180:    */     {
/* 181:141 */       close(rs);
/* 182:142 */       close(pstmt);
/* 183:143 */       rollback(conn);
/* 184:144 */       throw e;
/* 185:    */     }
/* 186:    */     finally
/* 187:    */     {
/* 188:146 */       close(conn);
/* 189:    */     }
/* 190:148 */     return list;
/* 191:    */   }
/* 192:    */   
/* 193:    */   private int getReqMax(Connection conn, String mas_cod)
/* 194:    */   {
/* 195:152 */     PreparedStatement pstmt = null;
/* 196:153 */     ResultSet rs = null;
/* 197:154 */     int id = 0;
/* 198:    */     try
/* 199:    */     {
/* 200:156 */       String sqlid = "Select max(mali_cod) from sdoctor.mascotaalimentacion where mali_mas_cod = " + mas_cod;
/* 201:157 */       pstmt = conn.prepareStatement(sqlid);
/* 202:158 */       rs = pstmt.executeQuery();
/* 203:159 */       if ((rs != null) && (rs.next())) {
/* 204:160 */         id = rs.getInt(1) + 1;
/* 205:    */       } else {
/* 206:162 */         id++;
/* 207:    */       }
/* 208:    */     }
/* 209:    */     catch (SQLException e)
/* 210:    */     {
/* 211:166 */       close(rs);
/* 212:167 */       close(pstmt);
/* 213:168 */       rollback(conn);
/* 214:169 */       e.printStackTrace();
/* 215:    */     }
/* 216:    */     finally
/* 217:    */     {
/* 218:171 */       close(rs);
/* 219:172 */       close(pstmt);
/* 220:    */     }
/* 221:174 */     return id;
/* 222:    */   }
/* 223:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdpets.dao.MascotaAlimentacionDAO
 * JD-Core Version:    0.7.0.1
 */