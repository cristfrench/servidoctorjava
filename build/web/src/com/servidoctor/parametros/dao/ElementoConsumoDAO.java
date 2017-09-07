/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.ElementoConsumo;
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
/*  16:    */ public class ElementoConsumoDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list()
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 19 */     ArrayList list = new ArrayList();
/*  23: 20 */     Connection conn = null;
/*  24: 21 */     PreparedStatement pstmt = null;
/*  25: 22 */     ResultSet rs = null;
/*  26: 23 */     ElementoConsumo elementoConsumoS = new ElementoConsumo();
/*  27:    */     try
/*  28:    */     {
/*  29: 25 */       conn = this.ds.getConnection();
/*  30: 26 */       DBUtil db = new DBUtil();
/*  31: 27 */       if (this.idioma != null) {
/*  32: 28 */         db.setIdioma(this.idioma);
/*  33:    */       }
/*  34: 30 */       String sql = db.creaSQLSELECT(elementoConsumoS);
/*  35: 31 */       pstmt = conn.prepareStatement(sql);
/*  36:    */       
/*  37: 33 */       rs = pstmt.executeQuery();
/*  38: 34 */       while (rs.next())
/*  39:    */       {
/*  40: 35 */         ElementoConsumo elementoConsumo = new ElementoConsumo();
/*  41: 36 */         InicializaData.inicializa(elementoConsumo.getClass(), elementoConsumo);
/*  42: 37 */         populate(elementoConsumo, rs);
/*  43: 38 */         list.add(elementoConsumo);
/*  44:    */       }
/*  45: 40 */       close(rs);
/*  46: 41 */       close(pstmt);
/*  47:    */     }
/*  48:    */     catch (SQLException e)
/*  49:    */     {
/*  50: 43 */       close(rs);
/*  51: 44 */       close(pstmt);
/*  52: 45 */       rollback(conn);
/*  53: 46 */       throw e;
/*  54:    */     }
/*  55:    */     finally
/*  56:    */     {
/*  57: 48 */       close(conn);
/*  58:    */     }
/*  59: 50 */     return list;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public ElementoConsumo retrive(BigDecimal econ_cod)
/*  63:    */     throws SQLException
/*  64:    */   {
/*  65: 55 */     ElementoConsumo elementoConsumo = new ElementoConsumo();
/*  66: 56 */     Connection conn = null;
/*  67: 57 */     PreparedStatement pstmt = null;
/*  68: 58 */     ResultSet rs = null;
/*  69: 59 */     ElementoConsumo elementoConsumoS = new ElementoConsumo();
/*  70:    */     try
/*  71:    */     {
/*  72: 61 */       conn = this.ds.getConnection();
/*  73: 62 */       DBUtil db = new DBUtil();
/*  74: 63 */       if (this.idioma != null) {
/*  75: 64 */         db.setIdioma(this.idioma);
/*  76:    */       }
/*  77: 66 */       String sql = db.creaSQLSELECT(elementoConsumoS);
/*  78: 67 */       String where = " where econ_cod=" + econ_cod;
/*  79: 68 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  80: 69 */       rs = pstmt.executeQuery();
/*  81: 70 */       if (rs.next())
/*  82:    */       {
/*  83: 72 */         InicializaData.inicializa(elementoConsumo.getClass(), elementoConsumo);
/*  84: 73 */         populate(elementoConsumo, rs);
/*  85:    */       }
/*  86: 76 */       close(rs);
/*  87: 77 */       close(pstmt);
/*  88:    */     }
/*  89:    */     catch (SQLException e)
/*  90:    */     {
/*  91: 79 */       close(rs);
/*  92: 80 */       close(pstmt);
/*  93: 81 */       rollback(conn);
/*  94: 82 */       throw e;
/*  95:    */     }
/*  96:    */     finally
/*  97:    */     {
/*  98: 84 */       close(conn);
/*  99:    */     }
/* 100: 86 */     return elementoConsumo;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public void update(ElementoConsumo data, String[] llaves)
/* 104:    */     throws SQLException
/* 105:    */   {
/* 106: 90 */     Connection conn = null;
/* 107: 91 */     PreparedStatement pstmt = null;
/* 108:    */     try
/* 109:    */     {
/* 110: 93 */       DBUtil db = new DBUtil();
/* 111: 94 */       if (this.idioma != null) {
/* 112: 95 */         db.setIdioma(this.idioma);
/* 113:    */       }
/* 114: 97 */       conn = this.ds.getConnection();
/* 115: 98 */       conn.setAutoCommit(false);
/* 116: 99 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 117:100 */       pstmt = conn.prepareStatement(sql);
/* 118:101 */       pstmt.executeUpdate();
/* 119:102 */       close(pstmt);
/* 120:103 */       conn.commit();
/* 121:    */     }
/* 122:    */     catch (SQLException e)
/* 123:    */     {
/* 124:105 */       close(pstmt);
/* 125:106 */       rollback(conn);
/* 126:107 */       throw e;
/* 127:    */     }
/* 128:    */     finally
/* 129:    */     {
/* 130:109 */       close(conn);
/* 131:    */     }
/* 132:    */   }
/* 133:    */   
/* 134:    */   public synchronized void insert(ElementoConsumo data)
/* 135:    */     throws SQLException
/* 136:    */   {
/* 137:113 */     Connection conn = null;
/* 138:114 */     PreparedStatement pstmt = null;
/* 139:    */     
/* 140:116 */     ResultSet rs = null;
/* 141:    */     try
/* 142:    */     {
/* 143:118 */       int id = 0;
/* 144:119 */       DBUtil db = new DBUtil();
/* 145:120 */       if (this.idioma != null) {
/* 146:121 */         db.setIdioma(this.idioma);
/* 147:    */       }
/* 148:124 */       conn = this.ds.getConnection();
/* 149:125 */       conn.setAutoCommit(false);
/* 150:126 */       id = getReqMax(conn);
/* 151:127 */       data.setEcon_cod(new BigDecimal(id));
/* 152:128 */       String sql = db.creaSQLINSERT(data);
/* 153:    */       
/* 154:130 */       pstmt = conn.prepareStatement(sql);
/* 155:131 */       pstmt.executeUpdate();
/* 156:132 */       pstmt.close();
/* 157:133 */       conn.commit();
/* 158:    */     }
/* 159:    */     catch (SQLException sqle)
/* 160:    */     {
/* 161:135 */       close(rs);
/* 162:136 */       close(pstmt);
/* 163:137 */       rollback(conn);
/* 164:138 */       throw sqle;
/* 165:    */     }
/* 166:    */     finally
/* 167:    */     {
/* 168:140 */       close(rs);
/* 169:141 */       close(pstmt);
/* 170:142 */       close(conn);
/* 171:    */     }
/* 172:    */   }
/* 173:    */   
/* 174:    */   public void delete(ElementoConsumo data)
/* 175:    */     throws SQLException
/* 176:    */   {
/* 177:147 */     Connection conn = null;
/* 178:148 */     PreparedStatement pstmt = null;
/* 179:    */     try
/* 180:    */     {
/* 181:150 */       conn = this.ds.getConnection();
/* 182:151 */       conn.setAutoCommit(false);
/* 183:152 */       String sql = "DELETE FROM sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".elementoconsumo WHERE econ_cod=? ";
/* 184:153 */       pstmt = conn.prepareStatement(sql);
/* 185:154 */       pstmt.setBigDecimal(1, data.getEcon_cod());
/* 186:155 */       pstmt.executeUpdate();
/* 187:156 */       close(pstmt);
/* 188:157 */       conn.commit();
/* 189:    */     }
/* 190:    */     catch (SQLException e)
/* 191:    */     {
/* 192:159 */       close(pstmt);
/* 193:160 */       rollback(conn);
/* 194:161 */       throw e;
/* 195:    */     }
/* 196:    */     finally
/* 197:    */     {
/* 198:163 */       close(conn);
/* 199:    */     }
/* 200:    */   }
/* 201:    */   
/* 202:    */   private int getReqMax(Connection conn)
/* 203:    */   {
/* 204:168 */     PreparedStatement pstmt = null;
/* 205:169 */     ResultSet rs = null;
/* 206:170 */     int id = 0;
/* 207:    */     try
/* 208:    */     {
/* 209:172 */       String sqlid = "Select max(econ_cod) from sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".elementoconsumo ";
/* 210:173 */       pstmt = conn.prepareStatement(sqlid);
/* 211:174 */       rs = pstmt.executeQuery();
/* 212:175 */       if ((rs != null) && (rs.next())) {
/* 213:176 */         id = rs.getInt(1) + 1;
/* 214:    */       } else {
/* 215:178 */         id++;
/* 216:    */       }
/* 217:    */     }
/* 218:    */     catch (SQLException e)
/* 219:    */     {
/* 220:182 */       close(rs);
/* 221:183 */       close(pstmt);
/* 222:184 */       rollback(conn);
/* 223:185 */       e.printStackTrace();
/* 224:    */     }
/* 225:    */     finally
/* 226:    */     {
/* 227:187 */       close(rs);
/* 228:188 */       close(pstmt);
/* 229:    */     }
/* 230:190 */     return id;
/* 231:    */   }
/* 232:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.ElementoConsumoDAO
 * JD-Core Version:    0.7.0.1
 */