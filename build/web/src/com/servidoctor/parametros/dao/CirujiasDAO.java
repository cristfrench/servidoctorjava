/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.Cirujias;
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
/*  16:    */ public class CirujiasDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list()
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 19 */     ArrayList list = new ArrayList();
/*  23: 20 */     Connection conn = null;
/*  24: 21 */     PreparedStatement pstmt = null;
/*  25: 22 */     ResultSet rs = null;
/*  26: 23 */     Cirujias usuarioCirujiasS = new Cirujias();
/*  27:    */     try
/*  28:    */     {
/*  29: 25 */       conn = this.ds.getConnection();
/*  30: 26 */       DBUtil db = new DBUtil();
/*  31: 27 */       if (this.idioma != null) {
/*  32: 28 */         db.setIdioma(this.idioma);
/*  33:    */       }
/*  34: 30 */       String sql = db.creaSQLSELECT(usuarioCirujiasS);
/*  35: 31 */       pstmt = conn.prepareStatement(sql + " where cir_cod > 0 order by cir_des");
/*  36: 32 */       rs = pstmt.executeQuery();
/*  37: 33 */       while (rs.next())
/*  38:    */       {
/*  39: 34 */         Cirujias usuarioCirujias = new Cirujias();
/*  40: 35 */         InicializaData.inicializa(usuarioCirujias.getClass(), usuarioCirujias);
/*  41: 36 */         populate(usuarioCirujias, rs);
/*  42: 37 */         list.add(usuarioCirujias);
/*  43:    */       }
/*  44: 39 */       close(rs);
/*  45: 40 */       close(pstmt);
/*  46:    */     }
/*  47:    */     catch (SQLException e)
/*  48:    */     {
/*  49: 42 */       close(rs);
/*  50: 43 */       close(pstmt);
/*  51: 44 */       rollback(conn);
/*  52: 45 */       throw e;
/*  53:    */     }
/*  54:    */     finally
/*  55:    */     {
/*  56: 47 */       close(conn);
/*  57:    */     }
/*  58: 49 */     return list;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public Cirujias retrive(BigDecimal cir_cod)
/*  62:    */     throws SQLException
/*  63:    */   {
/*  64: 54 */     Cirujias usuarioCirujias = new Cirujias();
/*  65: 55 */     Connection conn = null;
/*  66: 56 */     PreparedStatement pstmt = null;
/*  67: 57 */     ResultSet rs = null;
/*  68: 58 */     Cirujias usuarioCirujiasS = new Cirujias();
/*  69:    */     try
/*  70:    */     {
/*  71: 60 */       conn = this.ds.getConnection();
/*  72: 61 */       DBUtil db = new DBUtil();
/*  73: 62 */       if (this.idioma != null) {
/*  74: 63 */         db.setIdioma(this.idioma);
/*  75:    */       }
/*  76: 65 */       String sql = db.creaSQLSELECT(usuarioCirujiasS);
/*  77: 66 */       String where = " where cir_cod=" + cir_cod;
/*  78: 67 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  79: 68 */       rs = pstmt.executeQuery();
/*  80: 69 */       if (rs.next())
/*  81:    */       {
/*  82: 70 */         InicializaData.inicializa(usuarioCirujias.getClass(), usuarioCirujias);
/*  83: 71 */         populate(usuarioCirujias, rs);
/*  84:    */       }
/*  85: 73 */       close(rs);
/*  86: 74 */       close(pstmt);
/*  87:    */     }
/*  88:    */     catch (SQLException e)
/*  89:    */     {
/*  90: 76 */       close(rs);
/*  91: 77 */       close(pstmt);
/*  92: 78 */       rollback(conn);
/*  93: 79 */       throw e;
/*  94:    */     }
/*  95:    */     finally
/*  96:    */     {
/*  97: 81 */       close(conn);
/*  98:    */     }
/*  99: 83 */     return usuarioCirujias;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public synchronized void insert(Cirujias data)
/* 103:    */     throws SQLException
/* 104:    */   {
/* 105: 87 */     Connection conn = null;
/* 106: 88 */     PreparedStatement pstmt = null;
/* 107:    */     
/* 108: 90 */     ResultSet rs = null;
/* 109:    */     try
/* 110:    */     {
/* 111: 92 */       int id = 0;
/* 112: 93 */       DBUtil db = new DBUtil();
/* 113: 94 */       if (this.idioma != null) {
/* 114: 95 */         db.setIdioma(this.idioma);
/* 115:    */       }
/* 116: 98 */       conn = this.ds.getConnection();
/* 117: 99 */       conn.setAutoCommit(false);
/* 118:100 */       id = getReqMax(conn);
/* 119:101 */       data.setCir_cod(new BigDecimal(id));
/* 120:102 */       String sql = db.creaSQLINSERT(data);
/* 121:    */       
/* 122:104 */       pstmt = conn.prepareStatement(sql);
/* 123:105 */       pstmt.executeUpdate();
/* 124:106 */       pstmt.close();
/* 125:107 */       conn.commit();
/* 126:    */     }
/* 127:    */     catch (SQLException sqle)
/* 128:    */     {
/* 129:109 */       close(rs);
/* 130:110 */       close(pstmt);
/* 131:111 */       rollback(conn);
/* 132:112 */       throw sqle;
/* 133:    */     }
/* 134:    */     finally
/* 135:    */     {
/* 136:114 */       close(rs);
/* 137:115 */       close(pstmt);
/* 138:116 */       close(conn);
/* 139:    */     }
/* 140:    */   }
/* 141:    */   
/* 142:    */   public void update(Cirujias data, String[] llaves)
/* 143:    */     throws SQLException
/* 144:    */   {
/* 145:120 */     Connection conn = null;
/* 146:121 */     PreparedStatement pstmt = null;
/* 147:    */     try
/* 148:    */     {
/* 149:123 */       DBUtil db = new DBUtil();
/* 150:124 */       if (this.idioma != null) {
/* 151:125 */         db.setIdioma(this.idioma);
/* 152:    */       }
/* 153:127 */       conn = this.ds.getConnection();
/* 154:128 */       conn.setAutoCommit(false);
/* 155:129 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 156:130 */       pstmt = conn.prepareStatement(sql);
/* 157:131 */       pstmt.executeUpdate();
/* 158:132 */       close(pstmt);
/* 159:133 */       conn.commit();
/* 160:    */     }
/* 161:    */     catch (SQLException e)
/* 162:    */     {
/* 163:135 */       close(pstmt);
/* 164:136 */       rollback(conn);
/* 165:137 */       throw e;
/* 166:    */     }
/* 167:    */     finally
/* 168:    */     {
/* 169:139 */       close(conn);
/* 170:    */     }
/* 171:    */   }
/* 172:    */   
/* 173:    */   public void delete(Cirujias data)
/* 174:    */     throws SQLException
/* 175:    */   {
/* 176:143 */     Connection conn = null;
/* 177:144 */     PreparedStatement pstmt = null;
/* 178:    */     try
/* 179:    */     {
/* 180:146 */       conn = this.ds.getConnection();
/* 181:147 */       conn.setAutoCommit(false);
/* 182:148 */       String sql = "DELETE FROM sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".cirujias WHERE cir_cod=? ";
/* 183:149 */       pstmt = conn.prepareStatement(sql);
/* 184:150 */       pstmt.setBigDecimal(1, data.getCir_cod());
/* 185:151 */       pstmt.executeUpdate();
/* 186:152 */       close(pstmt);
/* 187:153 */       conn.commit();
/* 188:    */     }
/* 189:    */     catch (SQLException e)
/* 190:    */     {
/* 191:155 */       close(pstmt);
/* 192:156 */       rollback(conn);
/* 193:157 */       throw e;
/* 194:    */     }
/* 195:    */     finally
/* 196:    */     {
/* 197:159 */       close(conn);
/* 198:    */     }
/* 199:    */   }
/* 200:    */   
/* 201:    */   private int getReqMax(Connection conn)
/* 202:    */   {
/* 203:164 */     PreparedStatement pstmt = null;
/* 204:165 */     ResultSet rs = null;
/* 205:166 */     int id = 0;
/* 206:    */     try
/* 207:    */     {
/* 208:168 */       String sqlid = "Select max(cir_cod) from sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".cirujias";
/* 209:169 */       pstmt = conn.prepareStatement(sqlid);
/* 210:170 */       rs = pstmt.executeQuery();
/* 211:171 */       if ((rs != null) && (rs.next())) {
/* 212:172 */         id = rs.getInt(1) + 1;
/* 213:    */       } else {
/* 214:174 */         id++;
/* 215:    */       }
/* 216:    */     }
/* 217:    */     catch (SQLException e)
/* 218:    */     {
/* 219:178 */       close(rs);
/* 220:179 */       close(pstmt);
/* 221:180 */       rollback(conn);
/* 222:181 */       e.printStackTrace();
/* 223:    */     }
/* 224:    */     finally
/* 225:    */     {
/* 226:183 */       close(rs);
/* 227:184 */       close(pstmt);
/* 228:    */     }
/* 229:186 */     return id;
/* 230:    */   }
/* 231:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.CirujiasDAO
 * JD-Core Version:    0.7.0.1
 */