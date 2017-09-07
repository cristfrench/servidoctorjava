/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.TipoCuidado;
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
/*  16:    */ public class TipoCuidadoDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list()
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 19 */     ArrayList list = new ArrayList();
/*  23: 20 */     Connection conn = null;
/*  24: 21 */     PreparedStatement pstmt = null;
/*  25: 22 */     ResultSet rs = null;
/*  26: 23 */     TipoCuidado tipoCuidadoS = new TipoCuidado();
/*  27:    */     try
/*  28:    */     {
/*  29: 25 */       conn = this.ds.getConnection();
/*  30: 26 */       DBUtil db = new DBUtil();
/*  31: 27 */       String sql = db.creaSQLSELECT(tipoCuidadoS);
/*  32: 28 */       pstmt = conn.prepareStatement(sql);
/*  33: 29 */       rs = pstmt.executeQuery();
/*  34: 30 */       while (rs.next())
/*  35:    */       {
/*  36: 31 */         TipoCuidado tipoCuidado = new TipoCuidado();
/*  37: 32 */         InicializaData.inicializa(tipoCuidado.getClass(), tipoCuidado);
/*  38: 33 */         populate(tipoCuidado, rs);
/*  39: 34 */         list.add(tipoCuidado);
/*  40:    */       }
/*  41: 36 */       close(rs);
/*  42: 37 */       close(pstmt);
/*  43:    */     }
/*  44:    */     catch (SQLException e)
/*  45:    */     {
/*  46: 39 */       close(rs);
/*  47: 40 */       close(pstmt);
/*  48: 41 */       rollback(conn);
/*  49: 42 */       throw e;
/*  50:    */     }
/*  51:    */     finally
/*  52:    */     {
/*  53: 44 */       close(conn);
/*  54:    */     }
/*  55: 46 */     return list;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public TipoCuidado retrive(BigDecimal cod_cuidado)
/*  59:    */     throws SQLException
/*  60:    */   {
/*  61: 51 */     TipoCuidado tipoCuidado = new TipoCuidado();
/*  62: 52 */     Connection conn = null;
/*  63: 53 */     PreparedStatement pstmt = null;
/*  64: 54 */     ResultSet rs = null;
/*  65: 55 */     TipoCuidado tipoCuidadoS = new TipoCuidado();
/*  66:    */     try
/*  67:    */     {
/*  68: 57 */       conn = this.ds.getConnection();
/*  69: 58 */       DBUtil db = new DBUtil();
/*  70: 59 */       String sql = db.creaSQLSELECT(tipoCuidadoS);
/*  71: 60 */       String where = " where cod_cuidado=" + cod_cuidado;
/*  72: 61 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  73: 62 */       rs = pstmt.executeQuery();
/*  74: 63 */       if (rs.next())
/*  75:    */       {
/*  76: 65 */         InicializaData.inicializa(tipoCuidado.getClass(), tipoCuidado);
/*  77: 66 */         populate(tipoCuidado, rs);
/*  78:    */       }
/*  79: 69 */       close(rs);
/*  80: 70 */       close(pstmt);
/*  81:    */     }
/*  82:    */     catch (SQLException e)
/*  83:    */     {
/*  84: 72 */       close(rs);
/*  85: 73 */       close(pstmt);
/*  86: 74 */       rollback(conn);
/*  87: 75 */       throw e;
/*  88:    */     }
/*  89:    */     finally
/*  90:    */     {
/*  91: 77 */       close(conn);
/*  92:    */     }
/*  93: 79 */     return tipoCuidado;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public void update(TipoCuidado data, String[] llaves)
/*  97:    */     throws SQLException
/*  98:    */   {
/*  99: 83 */     Connection conn = null;
/* 100: 84 */     PreparedStatement pstmt = null;
/* 101:    */     try
/* 102:    */     {
/* 103: 86 */       DBUtil db = new DBUtil();
/* 104: 87 */       conn = this.ds.getConnection();
/* 105: 88 */       conn.setAutoCommit(false);
/* 106: 89 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 107: 90 */       pstmt = conn.prepareStatement(sql);
/* 108: 91 */       pstmt.executeUpdate();
/* 109: 92 */       close(pstmt);
/* 110: 93 */       conn.commit();
/* 111:    */     }
/* 112:    */     catch (SQLException e)
/* 113:    */     {
/* 114: 95 */       close(pstmt);
/* 115: 96 */       rollback(conn);
/* 116: 97 */       throw e;
/* 117:    */     }
/* 118:    */     finally
/* 119:    */     {
/* 120:100 */       close(conn);
/* 121:    */     }
/* 122:    */   }
/* 123:    */   
/* 124:    */   public synchronized void insert(TipoCuidado data)
/* 125:    */     throws SQLException
/* 126:    */   {
/* 127:104 */     Connection conn = null;
/* 128:105 */     PreparedStatement pstmt = null;
/* 129:    */     
/* 130:107 */     ResultSet rs = null;
/* 131:    */     try
/* 132:    */     {
/* 133:109 */       int id = 0;
/* 134:110 */       DBUtil db = new DBUtil();
/* 135:    */       
/* 136:112 */       conn = this.ds.getConnection();
/* 137:113 */       conn.setAutoCommit(false);
/* 138:114 */       id = getReqMax(conn);
/* 139:115 */       data.setCod_cuidado(new BigDecimal(id));
/* 140:116 */       String sql = db.creaSQLINSERT(data);
/* 141:    */       
/* 142:118 */       pstmt = conn.prepareStatement(sql);
/* 143:119 */       pstmt.executeUpdate();
/* 144:120 */       pstmt.close();
/* 145:121 */       conn.commit();
/* 146:    */     }
/* 147:    */     catch (SQLException sqle)
/* 148:    */     {
/* 149:123 */       close(rs);
/* 150:124 */       close(pstmt);
/* 151:125 */       rollback(conn);
/* 152:126 */       throw sqle;
/* 153:    */     }
/* 154:    */     finally
/* 155:    */     {
/* 156:128 */       close(rs);
/* 157:129 */       close(pstmt);
/* 158:130 */       close(conn);
/* 159:    */     }
/* 160:    */   }
/* 161:    */   
/* 162:    */   public void delete(TipoCuidado data)
/* 163:    */     throws SQLException
/* 164:    */   {
/* 165:135 */     Connection conn = null;
/* 166:136 */     PreparedStatement pstmt = null;
/* 167:    */     try
/* 168:    */     {
/* 169:138 */       conn = this.ds.getConnection();
/* 170:139 */       conn.setAutoCommit(false);
/* 171:140 */       String sql = "DELETE FROM sdoctor.tipocuidado WHERE cod_cuidado=?";
/* 172:141 */       pstmt = conn.prepareStatement(sql);
/* 173:142 */       pstmt.setBigDecimal(1, data.getCod_cuidado());
/* 174:143 */       pstmt.executeUpdate();
/* 175:144 */       close(pstmt);
/* 176:145 */       conn.commit();
/* 177:    */     }
/* 178:    */     catch (SQLException e)
/* 179:    */     {
/* 180:147 */       close(pstmt);
/* 181:148 */       rollback(conn);
/* 182:149 */       throw e;
/* 183:    */     }
/* 184:    */     finally
/* 185:    */     {
/* 186:151 */       close(conn);
/* 187:    */     }
/* 188:    */   }
/* 189:    */   
/* 190:    */   private int getReqMax(Connection conn)
/* 191:    */   {
/* 192:155 */     PreparedStatement pstmt = null;
/* 193:156 */     ResultSet rs = null;
/* 194:157 */     int id = 0;
/* 195:    */     try
/* 196:    */     {
/* 197:159 */       String sqlid = "Select max(cod_cuidado) from sdoctor.tipocuidado ";
/* 198:160 */       pstmt = conn.prepareStatement(sqlid);
/* 199:161 */       rs = pstmt.executeQuery();
/* 200:162 */       if ((rs != null) && (rs.next())) {
/* 201:163 */         id = rs.getInt(1) + 1;
/* 202:    */       } else {
/* 203:165 */         id++;
/* 204:    */       }
/* 205:    */     }
/* 206:    */     catch (SQLException e)
/* 207:    */     {
/* 208:169 */       close(rs);
/* 209:170 */       close(pstmt);
/* 210:171 */       rollback(conn);
/* 211:172 */       e.printStackTrace();
/* 212:    */     }
/* 213:    */     finally
/* 214:    */     {
/* 215:174 */       close(rs);
/* 216:175 */       close(pstmt);
/* 217:    */     }
/* 218:177 */     return id;
/* 219:    */   }
/* 220:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.TipoCuidadoDAO
 * JD-Core Version:    0.7.0.1
 */