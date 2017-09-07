/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.TiposGrupos;
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
/*  16:    */ public class TiposGruposDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list()
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 26 */     ArrayList list = new ArrayList();
/*  23: 27 */     Connection conn = null;
/*  24: 28 */     PreparedStatement pstmt = null;
/*  25: 29 */     ResultSet rs = null;
/*  26: 30 */     TiposGrupos tiposGruposS = new TiposGrupos();
/*  27:    */     try
/*  28:    */     {
/*  29: 32 */       conn = this.ds.getConnection();
/*  30: 33 */       DBUtil db = new DBUtil();
/*  31: 34 */       String sql = db.creaSQLSELECT(tiposGruposS);
/*  32: 35 */       pstmt = conn.prepareStatement(sql);
/*  33: 36 */       rs = pstmt.executeQuery();
/*  34: 37 */       while (rs.next())
/*  35:    */       {
/*  36: 38 */         TiposGrupos tiposGrupos = new TiposGrupos();
/*  37: 39 */         InicializaData.inicializa(tiposGrupos.getClass(), tiposGrupos);
/*  38: 40 */         populate(tiposGrupos, rs);
/*  39: 41 */         list.add(tiposGrupos);
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
/*  58:    */   public TiposGrupos retrieve(BigDecimal tipg_cod)
/*  59:    */     throws SQLException
/*  60:    */   {
/*  61: 57 */     Connection conn = null;
/*  62: 58 */     PreparedStatement pstmt = null;
/*  63: 59 */     ResultSet rs = null;
/*  64: 60 */     TiposGrupos tiposGruposS = new TiposGrupos();
/*  65: 61 */     TiposGrupos tiposGrupos = new TiposGrupos();
/*  66:    */     try
/*  67:    */     {
/*  68: 63 */       conn = this.ds.getConnection();
/*  69: 64 */       DBUtil db = new DBUtil();
/*  70: 65 */       String sql = db.creaSQLSELECT(tiposGruposS) + " where tipg_cod = " + tipg_cod;
/*  71: 66 */       pstmt = conn.prepareStatement(sql);
/*  72: 67 */       rs = pstmt.executeQuery();
/*  73: 68 */       if (rs.next())
/*  74:    */       {
/*  75: 69 */         tiposGrupos = new TiposGrupos();
/*  76: 70 */         InicializaData.inicializa(tiposGrupos.getClass(), tiposGrupos);
/*  77: 71 */         populate(tiposGrupos, rs);
/*  78:    */       }
/*  79: 73 */       close(rs);
/*  80: 74 */       close(pstmt);
/*  81:    */     }
/*  82:    */     catch (SQLException e)
/*  83:    */     {
/*  84: 76 */       close(rs);
/*  85: 77 */       close(pstmt);
/*  86: 78 */       rollback(conn);
/*  87: 79 */       throw e;
/*  88:    */     }
/*  89:    */     finally
/*  90:    */     {
/*  91: 81 */       close(conn);
/*  92:    */     }
/*  93: 83 */     return tiposGrupos;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public void update(TiposGrupos data, String[] llaves)
/*  97:    */     throws SQLException
/*  98:    */   {
/*  99: 87 */     Connection conn = null;
/* 100: 88 */     PreparedStatement pstmt = null;
/* 101:    */     try
/* 102:    */     {
/* 103: 90 */       DBUtil db = new DBUtil();
/* 104: 91 */       conn = this.ds.getConnection();
/* 105: 92 */       conn.setAutoCommit(false);
/* 106: 93 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 107: 94 */       pstmt = conn.prepareStatement(sql);
/* 108: 95 */       pstmt.executeUpdate();
/* 109: 96 */       close(pstmt);
/* 110: 97 */       conn.commit();
/* 111:    */     }
/* 112:    */     catch (SQLException e)
/* 113:    */     {
/* 114: 99 */       close(pstmt);
/* 115:100 */       rollback(conn);
/* 116:101 */       throw e;
/* 117:    */     }
/* 118:    */     finally
/* 119:    */     {
/* 120:103 */       close(conn);
/* 121:    */     }
/* 122:    */   }
/* 123:    */   
/* 124:    */   public synchronized void insert(TiposGrupos data)
/* 125:    */     throws SQLException
/* 126:    */   {
/* 127:107 */     Connection conn = null;
/* 128:108 */     PreparedStatement pstmt = null;
/* 129:    */     
/* 130:110 */     ResultSet rs = null;
/* 131:    */     try
/* 132:    */     {
/* 133:112 */       int id = 0;
/* 134:113 */       DBUtil db = new DBUtil();
/* 135:    */       
/* 136:115 */       conn = this.ds.getConnection();
/* 137:116 */       conn.setAutoCommit(false);
/* 138:117 */       id = getReqMax(conn);
/* 139:118 */       data.setTipg_cod(new BigDecimal(id));
/* 140:119 */       String sql = db.creaSQLINSERT(data);
/* 141:    */       
/* 142:121 */       pstmt = conn.prepareStatement(sql);
/* 143:122 */       pstmt.executeUpdate();
/* 144:123 */       pstmt.close();
/* 145:124 */       conn.commit();
/* 146:    */     }
/* 147:    */     catch (SQLException sqle)
/* 148:    */     {
/* 149:126 */       close(rs);
/* 150:127 */       close(pstmt);
/* 151:128 */       rollback(conn);
/* 152:129 */       throw sqle;
/* 153:    */     }
/* 154:    */     finally
/* 155:    */     {
/* 156:131 */       close(rs);
/* 157:132 */       close(pstmt);
/* 158:133 */       close(conn);
/* 159:    */     }
/* 160:    */   }
/* 161:    */   
/* 162:    */   public void delete(TiposGrupos data)
/* 163:    */     throws SQLException
/* 164:    */   {
/* 165:137 */     Connection conn = null;
/* 166:138 */     PreparedStatement pstmt = null;
/* 167:    */     try
/* 168:    */     {
/* 169:140 */       conn = this.ds.getConnection();
/* 170:141 */       conn.setAutoCommit(false);
/* 171:142 */       String sql = "DELETE FROM sdoctor.tiposgrupos WHERE tipg_cod=?";
/* 172:143 */       pstmt = conn.prepareStatement(sql);
/* 173:144 */       pstmt.setBigDecimal(1, data.getTipg_cod());
/* 174:145 */       pstmt.executeUpdate();
/* 175:146 */       close(pstmt);
/* 176:147 */       conn.commit();
/* 177:    */     }
/* 178:    */     catch (SQLException e)
/* 179:    */     {
/* 180:149 */       close(pstmt);
/* 181:150 */       rollback(conn);
/* 182:151 */       throw e;
/* 183:    */     }
/* 184:    */     finally
/* 185:    */     {
/* 186:153 */       close(conn);
/* 187:    */     }
/* 188:    */   }
/* 189:    */   
/* 190:    */   private int getReqMax(Connection conn)
/* 191:    */   {
/* 192:157 */     PreparedStatement pstmt = null;
/* 193:158 */     ResultSet rs = null;
/* 194:159 */     int id = 0;
/* 195:    */     try
/* 196:    */     {
/* 197:161 */       String sqlid = "Select max(tipg_cod) from sdoctor.tiposgrupos ";
/* 198:162 */       pstmt = conn.prepareStatement(sqlid);
/* 199:163 */       rs = pstmt.executeQuery();
/* 200:164 */       if ((rs != null) && (rs.next())) {
/* 201:165 */         id = rs.getInt(1) + 1;
/* 202:    */       } else {
/* 203:167 */         id++;
/* 204:    */       }
/* 205:    */     }
/* 206:    */     catch (SQLException e)
/* 207:    */     {
/* 208:171 */       close(rs);
/* 209:172 */       close(pstmt);
/* 210:173 */       rollback(conn);
/* 211:174 */       e.printStackTrace();
/* 212:    */     }
/* 213:    */     finally
/* 214:    */     {
/* 215:176 */       close(rs);
/* 216:177 */       close(pstmt);
/* 217:    */     }
/* 218:179 */     return id;
/* 219:    */   }
/* 220:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.TiposGruposDAO
 * JD-Core Version:    0.7.0.1
 */