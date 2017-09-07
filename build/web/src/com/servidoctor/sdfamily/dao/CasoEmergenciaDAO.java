/*   1:    */ package com.servidoctor.sdfamily.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdfamily.model.CasoEmergencia;
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
/*  16:    */ public class CasoEmergenciaDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list(BigDecimal case_usuf_cod)
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 26 */     ArrayList list = new ArrayList();
/*  23: 27 */     Connection conn = null;
/*  24: 28 */     PreparedStatement pstmt = null;
/*  25: 29 */     ResultSet rs = null;
/*  26: 30 */     CasoEmergencia casoEmergenciaS = new CasoEmergencia();
/*  27:    */     try
/*  28:    */     {
/*  29: 32 */       conn = this.ds.getConnection();
/*  30: 33 */       DBUtil db = new DBUtil();
/*  31: 34 */       String sql = db.creaSQLSELECT(casoEmergenciaS);
/*  32: 35 */       String where = " where case_usuf_cod=" + case_usuf_cod;
/*  33: 36 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  34: 37 */       rs = pstmt.executeQuery();
/*  35: 38 */       while (rs.next())
/*  36:    */       {
/*  37: 39 */         CasoEmergencia casoEmergencia = new CasoEmergencia();
/*  38: 40 */         InicializaData.inicializa(casoEmergencia.getClass(), casoEmergencia);
/*  39: 41 */         populate(casoEmergencia, rs);
/*  40: 42 */         list.add(casoEmergencia);
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
/*  59:    */   public void update(CasoEmergencia data, String[] llaves, Connection conn)
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
/*  80:    */   public CasoEmergencia retrieve(BigDecimal case_usuf_cod, BigDecimal case_cod)
/*  81:    */     throws SQLException
/*  82:    */   {
/*  83: 73 */     CasoEmergencia casoEmergencia = new CasoEmergencia();
/*  84: 74 */     Connection conn = null;
/*  85: 75 */     PreparedStatement pstmt = null;
/*  86: 76 */     ResultSet rs = null;
/*  87: 77 */     CasoEmergencia casoEmergenciaS = new CasoEmergencia();
/*  88:    */     try
/*  89:    */     {
/*  90: 79 */       conn = this.ds.getConnection();
/*  91: 80 */       DBUtil db = new DBUtil();
/*  92: 81 */       String sql = db.creaSQLSELECT(casoEmergenciaS);
/*  93: 82 */       String where = " where case_usuf_cod = " + case_usuf_cod + " and case_cod = " + case_cod;
/*  94: 83 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  95: 84 */       rs = pstmt.executeQuery();
/*  96: 85 */       if (rs.next())
/*  97:    */       {
/*  98: 86 */         InicializaData.inicializa(casoEmergencia.getClass(), casoEmergencia);
/*  99: 87 */         populate(casoEmergencia, rs);
/* 100:    */       }
/* 101: 89 */       close(rs);
/* 102: 90 */       close(pstmt);
/* 103:    */     }
/* 104:    */     catch (SQLException e)
/* 105:    */     {
/* 106: 92 */       close(rs);
/* 107: 93 */       close(pstmt);
/* 108: 94 */       rollback(conn);
/* 109: 95 */       throw e;
/* 110:    */     }
/* 111:    */     finally
/* 112:    */     {
/* 113: 97 */       close(conn);
/* 114:    */     }
/* 115: 99 */     return casoEmergencia;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public synchronized void insert(CasoEmergencia data, Connection conn)
/* 119:    */     throws SQLException
/* 120:    */   {
/* 121:103 */     PreparedStatement pstmt = null;
/* 122:    */     try
/* 123:    */     {
/* 124:105 */       int id = 0;
/* 125:106 */       DBUtil db = new DBUtil();
/* 126:    */       
/* 127:108 */       id = getReqMax(conn, data);
/* 128:109 */       data.setCase_cod(new BigDecimal(id));
/* 129:110 */       String sql = db.creaSQLINSERT(data);
/* 130:    */       
/* 131:112 */       pstmt = conn.prepareStatement(sql);
/* 132:113 */       pstmt.executeUpdate();
/* 133:    */     }
/* 134:    */     catch (SQLException sqle)
/* 135:    */     {
/* 136:115 */       throw sqle;
/* 137:    */     }
/* 138:    */     finally
/* 139:    */     {
/* 140:117 */       close(pstmt);
/* 141:    */     }
/* 142:    */   }
/* 143:    */   
/* 144:    */   public void delete(CasoEmergencia data, Connection conn)
/* 145:    */     throws SQLException
/* 146:    */   {
/* 147:122 */     PreparedStatement pstmt = null;
/* 148:    */     try
/* 149:    */     {
/* 150:124 */       String sql = "DELETE FROM sdoctor.casoemergencia WHERE case_cod = ? and case_usuf_cod = ?";
/* 151:125 */       pstmt = conn.prepareStatement(sql);
/* 152:126 */       pstmt.setBigDecimal(1, data.getCase_cod());
/* 153:127 */       pstmt.setBigDecimal(2, data.getCase_usuf_cod());
/* 154:128 */       pstmt.executeUpdate();
/* 155:    */     }
/* 156:    */     catch (SQLException e)
/* 157:    */     {
/* 158:130 */       throw e;
/* 159:    */     }
/* 160:    */     finally
/* 161:    */     {
/* 162:132 */       close(pstmt);
/* 163:    */     }
/* 164:    */   }
/* 165:    */   
/* 166:    */   public void deleteAll(BigDecimal case_usuf_cod, Connection conn)
/* 167:    */     throws SQLException
/* 168:    */   {
/* 169:137 */     PreparedStatement pstmt = null;
/* 170:    */     try
/* 171:    */     {
/* 172:139 */       String sql = "DELETE FROM sdoctor.casoemergencia WHERE case_usuf_cod=?";
/* 173:140 */       pstmt = conn.prepareStatement(sql);
/* 174:141 */       pstmt.setBigDecimal(1, case_usuf_cod);
/* 175:142 */       pstmt.executeUpdate();
/* 176:    */     }
/* 177:    */     catch (SQLException e)
/* 178:    */     {
/* 179:144 */       throw e;
/* 180:    */     }
/* 181:    */     finally
/* 182:    */     {
/* 183:146 */       close(pstmt);
/* 184:    */     }
/* 185:    */   }
/* 186:    */   
/* 187:    */   private int getReqMax(Connection conn, CasoEmergencia data)
/* 188:    */     throws SQLException
/* 189:    */   {
/* 190:151 */     PreparedStatement pstmt = null;
/* 191:152 */     ResultSet rs = null;
/* 192:153 */     int id = 0;
/* 193:    */     try
/* 194:    */     {
/* 195:155 */       String sqlid = "Select max(case_cod) from sdoctor.casoemergencia where case_usuf_cod = ?";
/* 196:    */       
/* 197:157 */       pstmt = conn.prepareStatement(sqlid);
/* 198:158 */       pstmt.setBigDecimal(1, data.getCase_usuf_cod());
/* 199:159 */       rs = pstmt.executeQuery();
/* 200:160 */       if ((rs != null) && (rs.next())) {
/* 201:161 */         id = rs.getInt(1) + 1;
/* 202:    */       } else {
/* 203:163 */         id++;
/* 204:    */       }
/* 205:    */     }
/* 206:    */     catch (SQLException e)
/* 207:    */     {
/* 208:167 */       throw e;
/* 209:    */     }
/* 210:    */     finally
/* 211:    */     {
/* 212:169 */       close(rs);
/* 213:170 */       close(pstmt);
/* 214:    */     }
/* 215:172 */     return id;
/* 216:    */   }
/* 217:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.dao.CasoEmergenciaDAO
 * JD-Core Version:    0.7.0.1
 */