/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.TiposSangre;
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
/*  16:    */ public class TipoSangreDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list()
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 19 */     ArrayList list = new ArrayList();
/*  23: 20 */     Connection conn = null;
/*  24: 21 */     PreparedStatement pstmt = null;
/*  25: 22 */     ResultSet rs = null;
/*  26: 23 */     TiposSangre tiposSangreS = new TiposSangre();
/*  27:    */     try
/*  28:    */     {
/*  29: 25 */       conn = this.ds.getConnection();
/*  30: 26 */       DBUtil db = new DBUtil();
/*  31: 27 */       if (this.idioma != null) {
/*  32: 28 */         db.setIdioma(this.idioma);
/*  33:    */       }
/*  34: 30 */       String sql = db.creaSQLSELECT(tiposSangreS);
/*  35: 31 */       pstmt = conn.prepareStatement(sql);
/*  36: 32 */       rs = pstmt.executeQuery();
/*  37: 33 */       while (rs.next())
/*  38:    */       {
/*  39: 34 */         TiposSangre tiposSangre = new TiposSangre();
/*  40: 35 */         InicializaData.inicializa(tiposSangre.getClass(), tiposSangre);
/*  41: 36 */         populate(tiposSangre, rs);
/*  42: 37 */         list.add(tiposSangre);
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
/*  61:    */   public TiposSangre retrieve(BigDecimal tipsan_cod)
/*  62:    */     throws SQLException
/*  63:    */   {
/*  64: 53 */     Connection conn = null;
/*  65: 54 */     PreparedStatement pstmt = null;
/*  66: 55 */     ResultSet rs = null;
/*  67: 56 */     TiposSangre tiposSangreS = new TiposSangre();
/*  68: 57 */     TiposSangre tiposSangre = new TiposSangre();
/*  69:    */     try
/*  70:    */     {
/*  71: 59 */       conn = this.ds.getConnection();
/*  72: 60 */       DBUtil db = new DBUtil();
/*  73: 61 */       if (this.idioma != null) {
/*  74: 62 */         db.setIdioma(this.idioma);
/*  75:    */       }
/*  76: 64 */       String sql = db.creaSQLSELECT(tiposSangreS) + " where tipsan_cod = " + tipsan_cod;
/*  77: 65 */       pstmt = conn.prepareStatement(sql);
/*  78: 66 */       rs = pstmt.executeQuery();
/*  79: 67 */       if (rs.next())
/*  80:    */       {
/*  81: 68 */         tiposSangre = new TiposSangre();
/*  82: 69 */         InicializaData.inicializa(tiposSangre.getClass(), tiposSangre);
/*  83: 70 */         populate(tiposSangre, rs);
/*  84:    */       }
/*  85: 72 */       close(rs);
/*  86: 73 */       close(pstmt);
/*  87:    */     }
/*  88:    */     catch (SQLException e)
/*  89:    */     {
/*  90: 75 */       close(rs);
/*  91: 76 */       close(pstmt);
/*  92: 77 */       rollback(conn);
/*  93: 78 */       throw e;
/*  94:    */     }
/*  95:    */     finally
/*  96:    */     {
/*  97: 80 */       close(conn);
/*  98:    */     }
/*  99: 82 */     return tiposSangre;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public void update(TiposSangre data, String[] llaves)
/* 103:    */     throws SQLException
/* 104:    */   {
/* 105: 86 */     Connection conn = null;
/* 106: 87 */     PreparedStatement pstmt = null;
/* 107:    */     try
/* 108:    */     {
/* 109: 89 */       DBUtil db = new DBUtil();
/* 110: 90 */       if (this.idioma != null) {
/* 111: 91 */         db.setIdioma(this.idioma);
/* 112:    */       }
/* 113: 93 */       conn = this.ds.getConnection();
/* 114: 94 */       conn.setAutoCommit(false);
/* 115: 95 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 116: 96 */       pstmt = conn.prepareStatement(sql);
/* 117: 97 */       pstmt.executeUpdate();
/* 118: 98 */       close(pstmt);
/* 119: 99 */       conn.commit();
/* 120:    */     }
/* 121:    */     catch (SQLException e)
/* 122:    */     {
/* 123:101 */       close(pstmt);
/* 124:102 */       rollback(conn);
/* 125:103 */       throw e;
/* 126:    */     }
/* 127:    */     finally
/* 128:    */     {
/* 129:105 */       close(conn);
/* 130:    */     }
/* 131:    */   }
/* 132:    */   
/* 133:    */   public synchronized void insert(TiposSangre data)
/* 134:    */     throws SQLException
/* 135:    */   {
/* 136:109 */     Connection conn = null;
/* 137:110 */     PreparedStatement pstmt = null;
/* 138:    */     
/* 139:112 */     ResultSet rs = null;
/* 140:    */     try
/* 141:    */     {
/* 142:114 */       int id = 0;
/* 143:115 */       DBUtil db = new DBUtil();
/* 144:116 */       if (this.idioma != null) {
/* 145:117 */         db.setIdioma(this.idioma);
/* 146:    */       }
/* 147:119 */       conn = this.ds.getConnection();
/* 148:120 */       conn.setAutoCommit(false);
/* 149:121 */       id = getReqMax(conn);
/* 150:122 */       data.setTipsan_cod(new BigDecimal(id));
/* 151:123 */       String sql = db.creaSQLINSERT(data);
/* 152:    */       
/* 153:125 */       pstmt = conn.prepareStatement(sql);
/* 154:126 */       pstmt.executeUpdate();
/* 155:127 */       pstmt.close();
/* 156:128 */       conn.commit();
/* 157:    */     }
/* 158:    */     catch (SQLException sqle)
/* 159:    */     {
/* 160:130 */       close(rs);
/* 161:131 */       close(pstmt);
/* 162:132 */       rollback(conn);
/* 163:133 */       throw sqle;
/* 164:    */     }
/* 165:    */     finally
/* 166:    */     {
/* 167:135 */       close(rs);
/* 168:136 */       close(pstmt);
/* 169:137 */       close(conn);
/* 170:    */     }
/* 171:    */   }
/* 172:    */   
/* 173:    */   public void delete(TiposSangre data)
/* 174:    */     throws SQLException
/* 175:    */   {
/* 176:141 */     Connection conn = null;
/* 177:142 */     PreparedStatement pstmt = null;
/* 178:    */     try
/* 179:    */     {
/* 180:144 */       conn = this.ds.getConnection();
/* 181:145 */       conn.setAutoCommit(false);
/* 182:146 */       String sql = "DELETE FROM sdoctorsdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".tipossangre WHERE tipsan_cod=?";
/* 183:147 */       pstmt = conn.prepareStatement(sql);
/* 184:148 */       pstmt.setBigDecimal(1, data.getTipsan_cod());
/* 185:149 */       pstmt.executeUpdate();
/* 186:150 */       close(pstmt);
/* 187:151 */       conn.commit();
/* 188:    */     }
/* 189:    */     catch (SQLException e)
/* 190:    */     {
/* 191:153 */       close(pstmt);
/* 192:154 */       rollback(conn);
/* 193:155 */       throw e;
/* 194:    */     }
/* 195:    */     finally
/* 196:    */     {
/* 197:157 */       close(conn);
/* 198:    */     }
/* 199:    */   }
/* 200:    */   
/* 201:    */   private int getReqMax(Connection conn)
/* 202:    */   {
/* 203:161 */     PreparedStatement pstmt = null;
/* 204:162 */     ResultSet rs = null;
/* 205:163 */     int id = 0;
/* 206:    */     try
/* 207:    */     {
/* 208:165 */       String sqlid = "Select max(tipsan_cod) from sdoctorsdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".tipossangre ";
/* 209:166 */       pstmt = conn.prepareStatement(sqlid);
/* 210:167 */       rs = pstmt.executeQuery();
/* 211:168 */       if ((rs != null) && (rs.next())) {
/* 212:169 */         id = rs.getInt(1) + 1;
/* 213:    */       } else {
/* 214:171 */         id++;
/* 215:    */       }
/* 216:    */     }
/* 217:    */     catch (SQLException e)
/* 218:    */     {
/* 219:175 */       close(rs);
/* 220:176 */       close(pstmt);
/* 221:177 */       rollback(conn);
/* 222:178 */       e.printStackTrace();
/* 223:    */     }
/* 224:    */     finally
/* 225:    */     {
/* 226:180 */       close(rs);
/* 227:181 */       close(pstmt);
/* 228:    */     }
/* 229:183 */     return id;
/* 230:    */   }
/* 231:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.TipoSangreDAO
 * JD-Core Version:    0.7.0.1
 */