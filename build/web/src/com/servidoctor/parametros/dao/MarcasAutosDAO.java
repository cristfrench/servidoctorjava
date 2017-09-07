/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.MarcasAutos;
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
/*  16:    */ public class MarcasAutosDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list()
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 19 */     ArrayList list = new ArrayList();
/*  23: 20 */     Connection conn = null;
/*  24: 21 */     PreparedStatement pstmt = null;
/*  25: 22 */     ResultSet rs = null;
/*  26: 23 */     MarcasAutos marcaAutos = new MarcasAutos();
/*  27:    */     try
/*  28:    */     {
/*  29: 25 */       conn = this.ds.getConnection();
/*  30: 26 */       DBUtil db = new DBUtil();
/*  31: 27 */       String sql = db.creaSQLSELECT(marcaAutos);
/*  32: 28 */       pstmt = conn.prepareStatement(sql);
/*  33: 29 */       rs = pstmt.executeQuery();
/*  34: 30 */       while (rs.next())
/*  35:    */       {
/*  36: 31 */         MarcasAutos marcaAuto = new MarcasAutos();
/*  37: 32 */         InicializaData.inicializa(marcaAuto.getClass(), marcaAuto);
/*  38: 33 */         populate(marcaAuto, rs);
/*  39: 34 */         list.add(marcaAuto);
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
/*  58:    */   public MarcasAutos retrive(String maut_cod)
/*  59:    */     throws SQLException
/*  60:    */   {
/*  61: 51 */     MarcasAutos marcasAutos = new MarcasAutos();
/*  62: 52 */     Connection conn = null;
/*  63: 53 */     PreparedStatement pstmt = null;
/*  64: 54 */     ResultSet rs = null;
/*  65: 55 */     MarcasAutos marcasAutosS = new MarcasAutos();
/*  66:    */     try
/*  67:    */     {
/*  68: 57 */       conn = this.ds.getConnection();
/*  69: 58 */       DBUtil db = new DBUtil();
/*  70: 59 */       String sql = db.creaSQLSELECT(marcasAutosS);
/*  71: 60 */       String where = " where maut_cod=" + maut_cod;
/*  72: 61 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  73: 62 */       rs = pstmt.executeQuery();
/*  74: 63 */       if (rs.next())
/*  75:    */       {
/*  76: 65 */         InicializaData.inicializa(marcasAutos.getClass(), marcasAutos);
/*  77: 66 */         populate(marcasAutos, rs);
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
/*  93: 79 */     return marcasAutos;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public void update(MarcasAutos data, String[] llaves)
/*  97:    */     throws SQLException
/*  98:    */   {
/*  99: 84 */     Connection conn = null;
/* 100: 85 */     PreparedStatement pstmt = null;
/* 101:    */     try
/* 102:    */     {
/* 103: 87 */       DBUtil db = new DBUtil();
/* 104: 88 */       conn = this.ds.getConnection();
/* 105: 89 */       conn.setAutoCommit(false);
/* 106: 90 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 107: 91 */       pstmt = conn.prepareStatement(sql);
/* 108: 92 */       pstmt.executeUpdate();
/* 109: 93 */       close(pstmt);
/* 110: 94 */       conn.commit();
/* 111:    */     }
/* 112:    */     catch (SQLException e)
/* 113:    */     {
/* 114: 96 */       close(pstmt);
/* 115: 97 */       rollback(conn);
/* 116: 98 */       throw e;
/* 117:    */     }
/* 118:    */     finally
/* 119:    */     {
/* 120:100 */       close(conn);
/* 121:    */     }
/* 122:    */   }
/* 123:    */   
/* 124:    */   public synchronized void insert(MarcasAutos data)
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
/* 139:115 */       data.setMaut_cod(new BigDecimal(id));
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
/* 162:    */   public void delete(MarcasAutos data)
/* 163:    */     throws SQLException
/* 164:    */   {
/* 165:135 */     Connection conn = null;
/* 166:136 */     PreparedStatement pstmt = null;
/* 167:    */     try
/* 168:    */     {
/* 169:138 */       conn = this.ds.getConnection();
/* 170:139 */       conn.setAutoCommit(false);
/* 171:140 */       String sql = 
/* 172:141 */         "DELETE FROM sdoctor.marcasautos WHERE maut_cod=?";
/* 173:142 */       pstmt = conn.prepareStatement(sql);
/* 174:143 */       pstmt.setBigDecimal(1, data.getMaut_cod());
/* 175:144 */       pstmt.executeUpdate();
/* 176:145 */       close(pstmt);
/* 177:146 */       conn.commit();
/* 178:    */     }
/* 179:    */     catch (SQLException e)
/* 180:    */     {
/* 181:148 */       close(pstmt);
/* 182:149 */       rollback(conn);
/* 183:150 */       throw e;
/* 184:    */     }
/* 185:    */     finally
/* 186:    */     {
/* 187:152 */       close(conn);
/* 188:    */     }
/* 189:    */   }
/* 190:    */   
/* 191:    */   private int getReqMax(Connection conn)
/* 192:    */   {
/* 193:156 */     PreparedStatement pstmt = null;
/* 194:157 */     ResultSet rs = null;
/* 195:158 */     int id = 0;
/* 196:    */     try
/* 197:    */     {
/* 198:160 */       String sqlid = 
/* 199:161 */         "Select max(maut_cod) from sdoctor.marcasautos ";
/* 200:162 */       pstmt = conn.prepareStatement(sqlid);
/* 201:163 */       rs = pstmt.executeQuery();
/* 202:164 */       if ((rs != null) && (rs.next())) {
/* 203:165 */         id = rs.getInt(1) + 1;
/* 204:    */       } else {
/* 205:167 */         id++;
/* 206:    */       }
/* 207:    */     }
/* 208:    */     catch (SQLException e)
/* 209:    */     {
/* 210:171 */       close(rs);
/* 211:172 */       close(pstmt);
/* 212:173 */       rollback(conn);
/* 213:174 */       e.printStackTrace();
/* 214:    */     }
/* 215:    */     finally
/* 216:    */     {
/* 217:176 */       close(rs);
/* 218:177 */       close(pstmt);
/* 219:    */     }
/* 220:179 */     return id;
/* 221:    */   }
/* 222:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.MarcasAutosDAO
 * JD-Core Version:    0.7.0.1
 */