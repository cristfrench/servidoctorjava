/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.RevisionAccion;
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
/*  16:    */ public class RevisionAccionDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list()
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 19 */     ArrayList list = new ArrayList();
/*  23: 20 */     Connection conn = null;
/*  24: 21 */     PreparedStatement pstmt = null;
/*  25: 22 */     ResultSet rs = null;
/*  26: 23 */     RevisionAccion revisionAccionS = new RevisionAccion();
/*  27:    */     try
/*  28:    */     {
/*  29: 25 */       conn = this.ds.getConnection();
/*  30: 26 */       DBUtil db = new DBUtil();
/*  31: 27 */       if (this.idioma != null) {
/*  32: 28 */         db.setIdioma(this.idioma);
/*  33:    */       }
/*  34: 31 */       String sql = db.creaSQLSELECT(revisionAccionS);
/*  35: 32 */       pstmt = conn.prepareStatement(sql + " where racc_cod > 0");
/*  36: 33 */       rs = pstmt.executeQuery();
/*  37: 34 */       while (rs.next())
/*  38:    */       {
/*  39: 35 */         RevisionAccion revisionAccion = new RevisionAccion();
/*  40: 36 */         InicializaData.inicializa(revisionAccion.getClass(), revisionAccion);
/*  41: 37 */         populate(revisionAccion, rs);
/*  42: 38 */         list.add(revisionAccion);
/*  43:    */       }
/*  44: 40 */       close(rs);
/*  45: 41 */       close(pstmt);
/*  46:    */     }
/*  47:    */     catch (SQLException e)
/*  48:    */     {
/*  49: 43 */       close(rs);
/*  50: 44 */       close(pstmt);
/*  51: 45 */       rollback(conn);
/*  52: 46 */       throw e;
/*  53:    */     }
/*  54:    */     finally
/*  55:    */     {
/*  56: 48 */       close(conn);
/*  57:    */     }
/*  58: 50 */     return list;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public RevisionAccion retrive(BigDecimal racc_cod)
/*  62:    */     throws SQLException
/*  63:    */   {
/*  64: 55 */     RevisionAccion revisionAccion = new RevisionAccion();
/*  65: 56 */     Connection conn = null;
/*  66: 57 */     PreparedStatement pstmt = null;
/*  67: 58 */     ResultSet rs = null;
/*  68: 59 */     RevisionAccion revisionAccionS = new RevisionAccion();
/*  69:    */     try
/*  70:    */     {
/*  71: 61 */       conn = this.ds.getConnection();
/*  72: 62 */       DBUtil db = new DBUtil();
/*  73: 63 */       if (this.idioma != null) {
/*  74: 64 */         db.setIdioma(this.idioma);
/*  75:    */       }
/*  76: 66 */       String sql = db.creaSQLSELECT(revisionAccionS);
/*  77: 67 */       String where = " where racc_cod=" + racc_cod;
/*  78: 68 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  79: 69 */       rs = pstmt.executeQuery();
/*  80: 70 */       if (rs.next())
/*  81:    */       {
/*  82: 72 */         InicializaData.inicializa(revisionAccion.getClass(), revisionAccion);
/*  83: 73 */         populate(revisionAccion, rs);
/*  84:    */       }
/*  85: 76 */       close(rs);
/*  86: 77 */       close(pstmt);
/*  87:    */     }
/*  88:    */     catch (SQLException e)
/*  89:    */     {
/*  90: 79 */       close(rs);
/*  91: 80 */       close(pstmt);
/*  92: 81 */       rollback(conn);
/*  93: 82 */       throw e;
/*  94:    */     }
/*  95:    */     finally
/*  96:    */     {
/*  97: 84 */       close(conn);
/*  98:    */     }
/*  99: 86 */     return revisionAccion;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public void update(RevisionAccion data, String[] llaves)
/* 103:    */     throws SQLException
/* 104:    */   {
/* 105: 89 */     Connection conn = null;
/* 106: 90 */     PreparedStatement pstmt = null;
/* 107:    */     try
/* 108:    */     {
/* 109: 92 */       DBUtil db = new DBUtil();
/* 110: 93 */       if (this.idioma != null) {
/* 111: 94 */         db.setIdioma(this.idioma);
/* 112:    */       }
/* 113: 96 */       conn = this.ds.getConnection();
/* 114: 97 */       conn.setAutoCommit(false);
/* 115: 98 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 116: 99 */       pstmt = conn.prepareStatement(sql);
/* 117:100 */       pstmt.executeUpdate();
/* 118:101 */       close(pstmt);
/* 119:102 */       conn.commit();
/* 120:    */     }
/* 121:    */     catch (SQLException e)
/* 122:    */     {
/* 123:104 */       close(pstmt);
/* 124:105 */       rollback(conn);
/* 125:106 */       throw e;
/* 126:    */     }
/* 127:    */     finally
/* 128:    */     {
/* 129:108 */       close(conn);
/* 130:    */     }
/* 131:    */   }
/* 132:    */   
/* 133:    */   public synchronized void insert(RevisionAccion data)
/* 134:    */     throws SQLException
/* 135:    */   {
/* 136:112 */     Connection conn = null;
/* 137:113 */     PreparedStatement pstmt = null;
/* 138:    */     
/* 139:115 */     ResultSet rs = null;
/* 140:    */     try
/* 141:    */     {
/* 142:117 */       int id = 0;
/* 143:118 */       DBUtil db = new DBUtil();
/* 144:119 */       if (this.idioma != null) {
/* 145:120 */         db.setIdioma(this.idioma);
/* 146:    */       }
/* 147:123 */       conn = this.ds.getConnection();
/* 148:124 */       conn.setAutoCommit(false);
/* 149:125 */       id = getReqMax(conn);
/* 150:126 */       data.setRacc_cod(new BigDecimal(id));
/* 151:127 */       String sql = db.creaSQLINSERT(data);
/* 152:    */       
/* 153:129 */       pstmt = conn.prepareStatement(sql);
/* 154:130 */       pstmt.executeUpdate();
/* 155:131 */       pstmt.close();
/* 156:132 */       conn.commit();
/* 157:    */     }
/* 158:    */     catch (SQLException sqle)
/* 159:    */     {
/* 160:134 */       close(rs);
/* 161:135 */       close(pstmt);
/* 162:136 */       rollback(conn);
/* 163:137 */       throw sqle;
/* 164:    */     }
/* 165:    */     finally
/* 166:    */     {
/* 167:139 */       close(rs);
/* 168:140 */       close(pstmt);
/* 169:141 */       close(conn);
/* 170:    */     }
/* 171:    */   }
/* 172:    */   
/* 173:    */   public void delete(RevisionAccion data)
/* 174:    */     throws SQLException
/* 175:    */   {
/* 176:146 */     Connection conn = null;
/* 177:147 */     PreparedStatement pstmt = null;
/* 178:    */     try
/* 179:    */     {
/* 180:149 */       conn = this.ds.getConnection();
/* 181:150 */       conn.setAutoCommit(false);
/* 182:151 */       String sql = "DELETE FROM sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".revisionaccion WHERE racc_cod=?";
/* 183:152 */       pstmt = conn.prepareStatement(sql);
/* 184:153 */       pstmt.setBigDecimal(1, data.getRacc_cod());
/* 185:154 */       pstmt.executeUpdate();
/* 186:155 */       close(pstmt);
/* 187:156 */       conn.commit();
/* 188:    */     }
/* 189:    */     catch (SQLException e)
/* 190:    */     {
/* 191:158 */       close(pstmt);
/* 192:159 */       rollback(conn);
/* 193:160 */       throw e;
/* 194:    */     }
/* 195:    */     finally
/* 196:    */     {
/* 197:162 */       close(conn);
/* 198:    */     }
/* 199:    */   }
/* 200:    */   
/* 201:    */   private int getReqMax(Connection conn)
/* 202:    */   {
/* 203:166 */     PreparedStatement pstmt = null;
/* 204:167 */     ResultSet rs = null;
/* 205:168 */     int id = 0;
/* 206:    */     try
/* 207:    */     {
/* 208:170 */       String sqlid = "Select max(racc_cod) from sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".revisionaccion ";
/* 209:171 */       pstmt = conn.prepareStatement(sqlid);
/* 210:172 */       rs = pstmt.executeQuery();
/* 211:173 */       if ((rs != null) && (rs.next())) {
/* 212:174 */         id = rs.getInt(1) + 1;
/* 213:    */       } else {
/* 214:176 */         id++;
/* 215:    */       }
/* 216:    */     }
/* 217:    */     catch (SQLException e)
/* 218:    */     {
/* 219:180 */       close(rs);
/* 220:181 */       close(pstmt);
/* 221:182 */       rollback(conn);
/* 222:183 */       e.printStackTrace();
/* 223:    */     }
/* 224:    */     finally
/* 225:    */     {
/* 226:185 */       close(rs);
/* 227:186 */       close(pstmt);
/* 228:    */     }
/* 229:188 */     return id;
/* 230:    */   }
/* 231:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.RevisionAccionDAO
 * JD-Core Version:    0.7.0.1
 */