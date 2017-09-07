/*   1:    */ package com.servidoctor.sdpets.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdpets.model.AlergiasPets;
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
/*  16:    */ public class AlergiasPetsDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list(BigDecimal alep_mas_cod)
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 26 */     ArrayList list = new ArrayList();
/*  23: 27 */     Connection conn = null;
/*  24: 28 */     PreparedStatement pstmt = null;
/*  25: 29 */     ResultSet rs = null;
/*  26: 30 */     AlergiasPets AlergiasPetsS = new AlergiasPets();
/*  27:    */     try
/*  28:    */     {
/*  29: 32 */       conn = this.ds.getConnection();
/*  30: 33 */       DBUtil db = new DBUtil();
/*  31: 34 */       String sql = db.creaSQLSELECT(AlergiasPetsS);
/*  32: 35 */       String where = " where alep_mas_cod=" + alep_mas_cod;
/*  33: 36 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  34: 37 */       rs = pstmt.executeQuery();
/*  35: 38 */       while (rs.next())
/*  36:    */       {
/*  37: 39 */         AlergiasPets AlergiasPets = new AlergiasPets();
/*  38: 40 */         InicializaData.inicializa(AlergiasPets.getClass(), AlergiasPets);
/*  39: 41 */         populate(AlergiasPets, rs);
/*  40: 42 */         list.add(AlergiasPets);
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
/*  59:    */   public void update(AlergiasPets data, String[] llaves, Connection conn)
/*  60:    */     throws SQLException
/*  61:    */   {
/*  62: 58 */     PreparedStatement pstmt = null;
/*  63:    */     try
/*  64:    */     {
/*  65: 60 */       DBUtil db = new DBUtil();
/*  66: 61 */       String sql = db.creaSQLUPDATE(data, llaves);
/*  67: 62 */       pstmt = conn.prepareStatement(sql);
/*  68: 63 */       pstmt.executeUpdate();
/*  69: 64 */       conn.commit();
/*  70:    */     }
/*  71:    */     catch (SQLException e)
/*  72:    */     {
/*  73: 66 */       throw e;
/*  74:    */     }
/*  75:    */     finally
/*  76:    */     {
/*  77: 68 */       close(pstmt);
/*  78:    */     }
/*  79:    */   }
/*  80:    */   
/*  81:    */   public AlergiasPets retrieve(BigDecimal alep_mas_cod, BigDecimal alep_cod)
/*  82:    */     throws SQLException
/*  83:    */   {
/*  84: 73 */     AlergiasPets AlergiasPets = new AlergiasPets();
/*  85: 74 */     Connection conn = null;
/*  86: 75 */     PreparedStatement pstmt = null;
/*  87: 76 */     ResultSet rs = null;
/*  88: 77 */     AlergiasPets AlergiasPetsS = new AlergiasPets();
/*  89:    */     try
/*  90:    */     {
/*  91: 79 */       conn = this.ds.getConnection();
/*  92: 80 */       DBUtil db = new DBUtil();
/*  93: 81 */       String sql = db.creaSQLSELECT(AlergiasPetsS);
/*  94: 82 */       String where = " where alep_mas_cod = " + alep_mas_cod + " and alep_cod = " + alep_cod;
/*  95: 83 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  96: 84 */       rs = pstmt.executeQuery();
/*  97: 85 */       if (rs.next())
/*  98:    */       {
/*  99: 86 */         InicializaData.inicializa(AlergiasPets.getClass(), AlergiasPets);
/* 100: 87 */         populate(AlergiasPets, rs);
/* 101:    */       }
/* 102: 89 */       close(rs);
/* 103: 90 */       close(pstmt);
/* 104:    */     }
/* 105:    */     catch (SQLException e)
/* 106:    */     {
/* 107: 92 */       close(rs);
/* 108: 93 */       close(pstmt);
/* 109: 94 */       rollback(conn);
/* 110: 95 */       throw e;
/* 111:    */     }
/* 112:    */     finally
/* 113:    */     {
/* 114: 97 */       close(conn);
/* 115:    */     }
/* 116: 99 */     return AlergiasPets;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public synchronized void insert(AlergiasPets data, Connection conn)
/* 120:    */     throws SQLException
/* 121:    */   {
/* 122:103 */     PreparedStatement pstmt = null;
/* 123:    */     try
/* 124:    */     {
/* 125:105 */       int id = 0;
/* 126:106 */       DBUtil db = new DBUtil();
/* 127:    */       
/* 128:108 */       id = getReqMax(conn, data);
/* 129:109 */       data.setAlep_cod(new BigDecimal(id));
/* 130:110 */       String sql = db.creaSQLINSERT(data);
/* 131:    */       
/* 132:112 */       pstmt = conn.prepareStatement(sql);
/* 133:113 */       pstmt.executeUpdate();
/* 134:    */     }
/* 135:    */     catch (SQLException sqle)
/* 136:    */     {
/* 137:115 */       throw sqle;
/* 138:    */     }
/* 139:    */     finally
/* 140:    */     {
/* 141:117 */       close(pstmt);
/* 142:    */     }
/* 143:    */   }
/* 144:    */   
/* 145:    */   public void delete(AlergiasPets data, Connection conn)
/* 146:    */     throws SQLException
/* 147:    */   {
/* 148:122 */     PreparedStatement pstmt = null;
/* 149:    */     try
/* 150:    */     {
/* 151:124 */       String sql = "DELETE FROM sdoctor.alergiaspets WHERE alep_cod = ? and alep_mas_cod = ?";
/* 152:125 */       pstmt = conn.prepareStatement(sql);
/* 153:126 */       pstmt.setBigDecimal(1, data.getAlep_cod());
/* 154:127 */       pstmt.setBigDecimal(2, data.getAlep_mas_cod());
/* 155:128 */       pstmt.executeUpdate();
/* 156:    */     }
/* 157:    */     catch (SQLException e)
/* 158:    */     {
/* 159:130 */       throw e;
/* 160:    */     }
/* 161:    */     finally
/* 162:    */     {
/* 163:132 */       close(pstmt);
/* 164:    */     }
/* 165:    */   }
/* 166:    */   
/* 167:    */   public void deleteAll(BigDecimal alep_mas_cod, Connection conn)
/* 168:    */     throws SQLException
/* 169:    */   {
/* 170:137 */     PreparedStatement pstmt = null;
/* 171:    */     try
/* 172:    */     {
/* 173:139 */       String sql = "DELETE FROM sdoctor.alergiaspets WHERE alep_mas_cod=?";
/* 174:140 */       pstmt = conn.prepareStatement(sql);
/* 175:141 */       pstmt.setBigDecimal(1, alep_mas_cod);
/* 176:142 */       pstmt.executeUpdate();
/* 177:    */     }
/* 178:    */     catch (SQLException e)
/* 179:    */     {
/* 180:144 */       throw e;
/* 181:    */     }
/* 182:    */     finally
/* 183:    */     {
/* 184:146 */       close(pstmt);
/* 185:    */     }
/* 186:    */   }
/* 187:    */   
/* 188:    */   private int getReqMax(Connection conn, AlergiasPets data)
/* 189:    */     throws SQLException
/* 190:    */   {
/* 191:151 */     PreparedStatement pstmt = null;
/* 192:152 */     ResultSet rs = null;
/* 193:153 */     int id = 0;
/* 194:    */     try
/* 195:    */     {
/* 196:155 */       String sqlid = "Select max(alep_cod) from sdoctor.alergiaspets where alep_mas_cod = ?";
/* 197:    */       
/* 198:157 */       pstmt = conn.prepareStatement(sqlid);
/* 199:158 */       pstmt.setBigDecimal(1, data.getAlep_mas_cod());
/* 200:159 */       rs = pstmt.executeQuery();
/* 201:160 */       if ((rs != null) && (rs.next())) {
/* 202:161 */         id = rs.getInt(1) + 1;
/* 203:    */       } else {
/* 204:163 */         id++;
/* 205:    */       }
/* 206:    */     }
/* 207:    */     catch (SQLException e)
/* 208:    */     {
/* 209:167 */       throw e;
/* 210:    */     }
/* 211:    */     finally
/* 212:    */     {
/* 213:169 */       close(rs);
/* 214:170 */       close(pstmt);
/* 215:    */     }
/* 216:172 */     return id;
/* 217:    */   }
/* 218:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdpets.dao.AlergiasPetsDAO
 * JD-Core Version:    0.7.0.1
 */