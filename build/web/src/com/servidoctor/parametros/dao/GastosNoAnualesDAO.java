/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.GastosNoAnuales;
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
/*  16:    */ public class GastosNoAnualesDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list()
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 19 */     ArrayList list = new ArrayList();
/*  23: 20 */     Connection conn = null;
/*  24: 21 */     PreparedStatement pstmt = null;
/*  25: 22 */     ResultSet rs = null;
/*  26: 23 */     GastosNoAnuales gastoNoAnualS = new GastosNoAnuales();
/*  27:    */     try
/*  28:    */     {
/*  29: 25 */       conn = this.ds.getConnection();
/*  30: 26 */       DBUtil db = new DBUtil();
/*  31: 27 */       if (this.idioma != null) {
/*  32: 28 */         db.setIdioma(this.idioma);
/*  33:    */       }
/*  34: 31 */       String sql = db.creaSQLSELECT(gastoNoAnualS);
/*  35: 32 */       pstmt = conn.prepareStatement(sql + " where gas_cod > 0");
/*  36: 33 */       rs = pstmt.executeQuery();
/*  37: 34 */       while (rs.next())
/*  38:    */       {
/*  39: 35 */         GastosNoAnuales gastoNoAnual = new GastosNoAnuales();
/*  40: 36 */         InicializaData.inicializa(gastoNoAnual.getClass(), gastoNoAnual);
/*  41: 37 */         populate(gastoNoAnual, rs);
/*  42: 38 */         list.add(gastoNoAnual);
/*  43:    */       }
/*  44:    */     }
/*  45:    */     catch (SQLException e)
/*  46:    */     {
/*  47: 41 */       rollback(conn);
/*  48: 42 */       throw e;
/*  49:    */     }
/*  50:    */     finally
/*  51:    */     {
/*  52: 44 */       close(rs);
/*  53: 45 */       close(pstmt);
/*  54: 46 */       close(conn);
/*  55:    */     }
/*  56: 48 */     return list;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public GastosNoAnuales retrive(BigDecimal gas_cod)
/*  60:    */     throws SQLException
/*  61:    */   {
/*  62: 52 */     GastosNoAnuales gastoNoAnual = new GastosNoAnuales();
/*  63: 53 */     Connection conn = null;
/*  64: 54 */     PreparedStatement pstmt = null;
/*  65: 55 */     ResultSet rs = null;
/*  66: 56 */     GastosNoAnuales gastoNoAnualS = new GastosNoAnuales();
/*  67:    */     try
/*  68:    */     {
/*  69: 58 */       conn = this.ds.getConnection();
/*  70: 59 */       DBUtil db = new DBUtil();
/*  71: 60 */       if (this.idioma != null) {
/*  72: 61 */         db.setIdioma(this.idioma);
/*  73:    */       }
/*  74: 64 */       String sql = db.creaSQLSELECT(gastoNoAnualS);
/*  75: 65 */       String where = " where gas_cod=" + gas_cod;
/*  76: 66 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  77: 67 */       rs = pstmt.executeQuery();
/*  78: 68 */       if (rs.next())
/*  79:    */       {
/*  80: 70 */         InicializaData.inicializa(gastoNoAnual.getClass(), gastoNoAnual);
/*  81: 71 */         populate(gastoNoAnual, rs);
/*  82:    */       }
/*  83:    */     }
/*  84:    */     catch (SQLException e)
/*  85:    */     {
/*  86: 75 */       rollback(conn);
/*  87: 76 */       throw e;
/*  88:    */     }
/*  89:    */     finally
/*  90:    */     {
/*  91: 78 */       close(rs);
/*  92: 79 */       close(pstmt);
/*  93: 80 */       close(conn);
/*  94:    */     }
/*  95: 82 */     return gastoNoAnual;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public synchronized void insert(GastosNoAnuales data)
/*  99:    */     throws SQLException
/* 100:    */   {
/* 101: 86 */     Connection conn = null;
/* 102: 87 */     PreparedStatement pstmt = null;
/* 103:    */     try
/* 104:    */     {
/* 105: 89 */       int id = 0;
/* 106: 90 */       DBUtil db = new DBUtil();
/* 107: 91 */       if (this.idioma != null) {
/* 108: 92 */         db.setIdioma(this.idioma);
/* 109:    */       }
/* 110: 95 */       conn = this.ds.getConnection();
/* 111: 96 */       conn.setAutoCommit(false);
/* 112: 97 */       id = getReqMax(conn);
/* 113: 98 */       data.setGas_cod(new BigDecimal(id));
/* 114: 99 */       String sql = db.creaSQLINSERT(data);
/* 115:    */       
/* 116:101 */       pstmt = conn.prepareStatement(sql);
/* 117:102 */       pstmt.executeUpdate();
/* 118:103 */       conn.commit();
/* 119:    */     }
/* 120:    */     catch (SQLException sqle)
/* 121:    */     {
/* 122:105 */       rollback(conn);
/* 123:106 */       throw sqle;
/* 124:    */     }
/* 125:    */     finally
/* 126:    */     {
/* 127:108 */       close(pstmt);
/* 128:109 */       close(conn);
/* 129:    */     }
/* 130:    */   }
/* 131:    */   
/* 132:    */   public void update(GastosNoAnuales data, String[] llaves)
/* 133:    */     throws SQLException
/* 134:    */   {
/* 135:113 */     Connection conn = null;
/* 136:114 */     PreparedStatement pstmt = null;
/* 137:    */     try
/* 138:    */     {
/* 139:116 */       DBUtil db = new DBUtil();
/* 140:117 */       if (this.idioma != null) {
/* 141:118 */         db.setIdioma(this.idioma);
/* 142:    */       }
/* 143:121 */       conn = this.ds.getConnection();
/* 144:122 */       conn.setAutoCommit(false);
/* 145:123 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 146:124 */       pstmt = conn.prepareStatement(sql);
/* 147:125 */       pstmt.executeUpdate();
/* 148:126 */       conn.commit();
/* 149:    */     }
/* 150:    */     catch (SQLException e)
/* 151:    */     {
/* 152:128 */       rollback(conn);
/* 153:129 */       throw e;
/* 154:    */     }
/* 155:    */     finally
/* 156:    */     {
/* 157:131 */       close(pstmt);
/* 158:132 */       close(conn);
/* 159:    */     }
/* 160:    */   }
/* 161:    */   
/* 162:    */   public void delete(GastosNoAnuales data)
/* 163:    */     throws SQLException
/* 164:    */   {
/* 165:136 */     Connection conn = null;
/* 166:137 */     PreparedStatement pstmt = null;
/* 167:    */     try
/* 168:    */     {
/* 169:139 */       conn = this.ds.getConnection();
/* 170:140 */       conn.setAutoCommit(false);
/* 171:141 */       String sql = "DELETE FROM sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".gastosnoanuales WHERE gas_cod=?";
/* 172:142 */       pstmt = conn.prepareStatement(sql);
/* 173:143 */       pstmt.setBigDecimal(1, data.getGas_cod());
/* 174:144 */       pstmt.executeUpdate();
/* 175:145 */       conn.commit();
/* 176:    */     }
/* 177:    */     catch (SQLException e)
/* 178:    */     {
/* 179:147 */       rollback(conn);
/* 180:148 */       throw e;
/* 181:    */     }
/* 182:    */     finally
/* 183:    */     {
/* 184:150 */       close(pstmt);
/* 185:151 */       close(conn);
/* 186:    */     }
/* 187:    */   }
/* 188:    */   
/* 189:    */   private int getReqMax(Connection conn)
/* 190:    */     throws SQLException
/* 191:    */   {
/* 192:155 */     PreparedStatement pstmt = null;
/* 193:156 */     ResultSet rs = null;
/* 194:157 */     int id = 0;
/* 195:    */     try
/* 196:    */     {
/* 197:159 */       String sqlid = "Select max(gas_cod) from sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".gastosnoanuales";
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
/* 208:169 */       rollback(conn);
/* 209:170 */       throw e;
/* 210:    */     }
/* 211:    */     finally
/* 212:    */     {
/* 213:172 */       close(rs);
/* 214:173 */       close(pstmt);
/* 215:    */     }
/* 216:175 */     return id;
/* 217:    */   }
/* 218:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.GastosNoAnualesDAO
 * JD-Core Version:    0.7.0.1
 */