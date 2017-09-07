/*   1:    */ package com.servidoctor.sdpets.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdpets.model.EnfermedadesPets;
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
/*  16:    */ public class EnfermedadesPetsDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list(BigDecimal enfp_mas_cod)
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 26 */     ArrayList list = new ArrayList();
/*  23: 27 */     Connection conn = null;
/*  24: 28 */     PreparedStatement pstmt = null;
/*  25: 29 */     ResultSet rs = null;
/*  26: 30 */     EnfermedadesPets enfermedadesS = new EnfermedadesPets();
/*  27:    */     try
/*  28:    */     {
/*  29: 32 */       conn = this.ds.getConnection();
/*  30: 33 */       DBUtil db = new DBUtil();
/*  31: 34 */       String sql = db.creaSQLSELECT(enfermedadesS);
/*  32: 35 */       pstmt = conn.prepareStatement(sql + " where enfp_mas_cod = " + enfp_mas_cod);
/*  33: 36 */       rs = pstmt.executeQuery();
/*  34: 37 */       while (rs.next())
/*  35:    */       {
/*  36: 38 */         EnfermedadesPets enfermedad = new EnfermedadesPets();
/*  37: 39 */         InicializaData.inicializa(enfermedad.getClass(), enfermedad);
/*  38: 40 */         populate(enfermedad, rs);
/*  39: 41 */         list.add(enfermedad);
/*  40:    */       }
/*  41: 43 */       close(rs);
/*  42: 44 */       close(pstmt);
/*  43:    */     }
/*  44:    */     catch (SQLException e)
/*  45:    */     {
/*  46: 46 */       close(rs);
/*  47: 47 */       close(pstmt);
/*  48: 48 */       rollback(conn);
/*  49: 49 */       throw e;
/*  50:    */     }
/*  51:    */     finally
/*  52:    */     {
/*  53: 51 */       close(conn);
/*  54:    */     }
/*  55: 53 */     return list;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public EnfermedadesPets retrive(BigDecimal enfp_mas_cod, BigDecimal enfp_cod)
/*  59:    */     throws SQLException
/*  60:    */   {
/*  61: 58 */     EnfermedadesPets enfermedades = new EnfermedadesPets();
/*  62: 59 */     Connection conn = null;
/*  63: 60 */     PreparedStatement pstmt = null;
/*  64: 61 */     ResultSet rs = null;
/*  65: 62 */     EnfermedadesPets enfermedadesS = new EnfermedadesPets();
/*  66:    */     try
/*  67:    */     {
/*  68: 64 */       conn = this.ds.getConnection();
/*  69: 65 */       DBUtil db = new DBUtil();
/*  70: 66 */       String sql = db.creaSQLSELECT(enfermedadesS);
/*  71: 67 */       String where = " where enfp_mas_cod=" + enfp_mas_cod + " and enfp_cod=" + enfp_cod;
/*  72: 68 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  73: 69 */       rs = pstmt.executeQuery();
/*  74: 70 */       if (rs.next())
/*  75:    */       {
/*  76: 71 */         InicializaData.inicializa(enfermedades.getClass(), enfermedades);
/*  77: 72 */         populate(enfermedades, rs);
/*  78:    */       }
/*  79: 74 */       close(rs);
/*  80: 75 */       close(pstmt);
/*  81:    */     }
/*  82:    */     catch (SQLException e)
/*  83:    */     {
/*  84: 77 */       close(rs);
/*  85: 78 */       close(pstmt);
/*  86: 79 */       rollback(conn);
/*  87: 80 */       throw e;
/*  88:    */     }
/*  89:    */     finally
/*  90:    */     {
/*  91: 82 */       close(conn);
/*  92:    */     }
/*  93: 84 */     return enfermedades;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public synchronized void insert(EnfermedadesPets data, Connection conn)
/*  97:    */     throws SQLException
/*  98:    */   {
/*  99: 88 */     PreparedStatement pstmt = null;
/* 100:    */     try
/* 101:    */     {
/* 102: 90 */       int id = 0;
/* 103: 91 */       DBUtil db = new DBUtil();
/* 104:    */       
/* 105: 93 */       id = getReqMax(conn, data.getEnfp_mas_cod());
/* 106: 94 */       data.setEnfp_cod(new BigDecimal(id));
/* 107: 95 */       String sql = db.creaSQLINSERT(data);
/* 108: 96 */       pstmt = conn.prepareStatement(sql);
/* 109: 97 */       pstmt.executeUpdate();
/* 110:    */     }
/* 111:    */     catch (SQLException sqle)
/* 112:    */     {
/* 113: 99 */       throw sqle;
/* 114:    */     }
/* 115:    */     finally
/* 116:    */     {
/* 117:101 */       close(pstmt);
/* 118:    */     }
/* 119:    */   }
/* 120:    */   
/* 121:    */   public void update(EnfermedadesPets data, String[] llaves, Connection conn)
/* 122:    */     throws SQLException
/* 123:    */   {
/* 124:106 */     PreparedStatement pstmt = null;
/* 125:    */     try
/* 126:    */     {
/* 127:108 */       DBUtil db = new DBUtil();
/* 128:109 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 129:110 */       pstmt = conn.prepareStatement(sql);
/* 130:111 */       pstmt.executeUpdate();
/* 131:    */     }
/* 132:    */     catch (SQLException e)
/* 133:    */     {
/* 134:113 */       throw e;
/* 135:    */     }
/* 136:    */     finally
/* 137:    */     {
/* 138:115 */       close(pstmt);
/* 139:    */     }
/* 140:    */   }
/* 141:    */   
/* 142:    */   public void deleteAll(BigDecimal enfp_mas_cod, Connection conn)
/* 143:    */     throws SQLException
/* 144:    */   {
/* 145:120 */     PreparedStatement pstmt = null;
/* 146:    */     try
/* 147:    */     {
/* 148:122 */       String sql = "DELETE FROM sdoctor.enfermedadespets WHERE enfp_mas_cod=?";
/* 149:123 */       pstmt = conn.prepareStatement(sql);
/* 150:124 */       pstmt.setBigDecimal(1, enfp_mas_cod);
/* 151:125 */       pstmt.executeUpdate();
/* 152:    */     }
/* 153:    */     catch (SQLException e)
/* 154:    */     {
/* 155:127 */       throw e;
/* 156:    */     }
/* 157:    */     finally
/* 158:    */     {
/* 159:129 */       close(pstmt);
/* 160:    */     }
/* 161:    */   }
/* 162:    */   
/* 163:    */   public void delete(EnfermedadesPets data, Connection conn)
/* 164:    */     throws SQLException
/* 165:    */   {
/* 166:134 */     PreparedStatement pstmt = null;
/* 167:    */     try
/* 168:    */     {
/* 169:136 */       String sql = "DELETE FROM sdoctor.enfermedadespets WHERE enfp_mas_cod=? and enfp_cod=?";
/* 170:137 */       pstmt = conn.prepareStatement(sql);
/* 171:138 */       pstmt.setBigDecimal(1, data.getEnfp_mas_cod());
/* 172:139 */       pstmt.setBigDecimal(2, data.getEnfp_cod());
/* 173:140 */       pstmt.executeUpdate();
/* 174:    */     }
/* 175:    */     catch (SQLException e)
/* 176:    */     {
/* 177:142 */       throw e;
/* 178:    */     }
/* 179:    */     finally
/* 180:    */     {
/* 181:144 */       close(pstmt);
/* 182:    */     }
/* 183:    */   }
/* 184:    */   
/* 185:    */   private int getReqMax(Connection conn, BigDecimal enfp_mas_cod)
/* 186:    */     throws SQLException
/* 187:    */   {
/* 188:149 */     PreparedStatement pstmt = null;
/* 189:150 */     ResultSet rs = null;
/* 190:151 */     int id = 0;
/* 191:    */     try
/* 192:    */     {
/* 193:153 */       String sql = "Select max(enfp_cod) from sdoctor.enfermedadespets where enfp_mas_cod = " + enfp_mas_cod;
/* 194:154 */       pstmt = conn.prepareStatement(sql);
/* 195:155 */       rs = pstmt.executeQuery();
/* 196:156 */       if ((rs != null) && (rs.next())) {
/* 197:157 */         id = rs.getInt(1) + 1;
/* 198:    */       } else {
/* 199:159 */         id++;
/* 200:    */       }
/* 201:    */     }
/* 202:    */     catch (SQLException e)
/* 203:    */     {
/* 204:163 */       throw e;
/* 205:    */     }
/* 206:    */     finally
/* 207:    */     {
/* 208:165 */       close(rs);
/* 209:166 */       close(pstmt);
/* 210:    */     }
/* 211:168 */     return id;
/* 212:    */   }
/* 213:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdpets.dao.EnfermedadesPetsDAO
 * JD-Core Version:    0.7.0.1
 */