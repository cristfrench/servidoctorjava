/*   1:    */ package com.servidoctor.sdpets.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdpets.model.SeguroPets;
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
/*  16:    */ public class SeguroPetsDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list(BigDecimal Segp_mas_cod)
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 26 */     ArrayList list = new ArrayList();
/*  23: 27 */     Connection conn = null;
/*  24: 28 */     PreparedStatement pstmt = null;
/*  25: 29 */     ResultSet rs = null;
/*  26: 30 */     SeguroPets SeguroPetsS = new SeguroPets();
/*  27:    */     try
/*  28:    */     {
/*  29: 32 */       conn = this.ds.getConnection();
/*  30: 33 */       DBUtil db = new DBUtil();
/*  31: 34 */       String sql = db.creaSQLSELECT(SeguroPetsS);
/*  32: 35 */       String where = " where segp_mas_cod=" + Segp_mas_cod;
/*  33: 36 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  34: 37 */       rs = pstmt.executeQuery();
/*  35: 38 */       while (rs.next())
/*  36:    */       {
/*  37: 39 */         SeguroPets SeguroPets = new SeguroPets();
/*  38: 40 */         InicializaData.inicializa(SeguroPets.getClass(), SeguroPets);
/*  39: 41 */         populate(SeguroPets, rs);
/*  40: 42 */         list.add(SeguroPets);
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
/*  59:    */   public void update(SeguroPets data, String[] llaves, Connection conn)
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
/*  80:    */   public SeguroPets retrieve(BigDecimal Segp_mas_cod, BigDecimal Segp_cod)
/*  81:    */     throws SQLException
/*  82:    */   {
/*  83: 72 */     SeguroPets SeguroPets = new SeguroPets();
/*  84: 73 */     Connection conn = null;
/*  85: 74 */     PreparedStatement pstmt = null;
/*  86: 75 */     ResultSet rs = null;
/*  87: 76 */     SeguroPets SeguroPetsS = new SeguroPets();
/*  88:    */     try
/*  89:    */     {
/*  90: 78 */       conn = this.ds.getConnection();
/*  91: 79 */       DBUtil db = new DBUtil();
/*  92: 80 */       String sql = db.creaSQLSELECT(SeguroPetsS);
/*  93: 81 */       String where = " where segp_mas_cod = " + Segp_mas_cod + " and segp_cod = " + Segp_cod;
/*  94: 82 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  95: 83 */       rs = pstmt.executeQuery();
/*  96: 84 */       if (rs.next())
/*  97:    */       {
/*  98: 85 */         InicializaData.inicializa(SeguroPets.getClass(), SeguroPets);
/*  99: 86 */         populate(SeguroPets, rs);
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
/* 115: 98 */     return SeguroPets;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public synchronized void insert(SeguroPets data, Connection conn)
/* 119:    */     throws SQLException
/* 120:    */   {
/* 121:102 */     PreparedStatement pstmt = null;
/* 122:    */     try
/* 123:    */     {
/* 124:104 */       int id = 0;
/* 125:105 */       DBUtil db = new DBUtil();
/* 126:    */       
/* 127:107 */       id = getReqMax(conn, data);
/* 128:108 */       data.setSegp_cod(new BigDecimal(id));
/* 129:109 */       String sql = db.creaSQLINSERT(data);
/* 130:110 */       pstmt = conn.prepareStatement(sql);
/* 131:111 */       pstmt.executeUpdate();
/* 132:    */     }
/* 133:    */     catch (SQLException sqle)
/* 134:    */     {
/* 135:113 */       throw sqle;
/* 136:    */     }
/* 137:    */     finally
/* 138:    */     {
/* 139:115 */       close(pstmt);
/* 140:    */     }
/* 141:    */   }
/* 142:    */   
/* 143:    */   public void delete(SeguroPets data, Connection conn)
/* 144:    */     throws SQLException
/* 145:    */   {
/* 146:120 */     PreparedStatement pstmt = null;
/* 147:    */     try
/* 148:    */     {
/* 149:122 */       String sql = "DELETE FROM sdoctor.seguroPets WHERE segp_cod = ? and segp_mas_cod = ?";
/* 150:123 */       pstmt = conn.prepareStatement(sql);
/* 151:124 */       pstmt.setBigDecimal(1, data.getSegp_cod());
/* 152:125 */       pstmt.setBigDecimal(2, data.getSegp_mas_cod());
/* 153:126 */       pstmt.executeUpdate();
/* 154:    */     }
/* 155:    */     catch (SQLException e)
/* 156:    */     {
/* 157:128 */       throw e;
/* 158:    */     }
/* 159:    */     finally
/* 160:    */     {
/* 161:130 */       close(pstmt);
/* 162:    */     }
/* 163:    */   }
/* 164:    */   
/* 165:    */   public void deleteAll(BigDecimal Segp_mas_cod, Connection conn)
/* 166:    */     throws SQLException
/* 167:    */   {
/* 168:135 */     PreparedStatement pstmt = null;
/* 169:    */     try
/* 170:    */     {
/* 171:137 */       String sql = "DELETE FROM sdoctor.seguropets WHERE segp_mas_cod=?";
/* 172:138 */       pstmt = conn.prepareStatement(sql);
/* 173:139 */       pstmt.setBigDecimal(1, Segp_mas_cod);
/* 174:140 */       pstmt.executeUpdate();
/* 175:    */     }
/* 176:    */     catch (SQLException e)
/* 177:    */     {
/* 178:142 */       throw e;
/* 179:    */     }
/* 180:    */     finally
/* 181:    */     {
/* 182:144 */       close(pstmt);
/* 183:    */     }
/* 184:    */   }
/* 185:    */   
/* 186:    */   private int getReqMax(Connection conn, SeguroPets data)
/* 187:    */     throws SQLException
/* 188:    */   {
/* 189:149 */     PreparedStatement pstmt = null;
/* 190:150 */     ResultSet rs = null;
/* 191:151 */     int id = 0;
/* 192:    */     try
/* 193:    */     {
/* 194:153 */       String sqlid = "Select max(segp_cod) from sdoctor.seguropets where segp_mas_cod = ?";
/* 195:    */       
/* 196:155 */       pstmt = conn.prepareStatement(sqlid);
/* 197:156 */       pstmt.setBigDecimal(1, data.getSegp_mas_cod());
/* 198:157 */       rs = pstmt.executeQuery();
/* 199:158 */       if ((rs != null) && (rs.next())) {
/* 200:159 */         id = rs.getInt(1) + 1;
/* 201:    */       } else {
/* 202:161 */         id++;
/* 203:    */       }
/* 204:    */     }
/* 205:    */     catch (SQLException e)
/* 206:    */     {
/* 207:165 */       throw e;
/* 208:    */     }
/* 209:    */     finally
/* 210:    */     {
/* 211:167 */       close(rs);
/* 212:168 */       close(pstmt);
/* 213:    */     }
/* 214:170 */     return id;
/* 215:    */   }
/* 216:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdpets.dao.SeguroPetsDAO
 * JD-Core Version:    0.7.0.1
 */