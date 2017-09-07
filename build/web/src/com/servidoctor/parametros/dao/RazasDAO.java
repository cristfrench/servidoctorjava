/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.Razas;
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
/*  16:    */ public class RazasDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list()
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 19 */     ArrayList list = new ArrayList();
/*  23: 20 */     Connection conn = null;
/*  24: 21 */     PreparedStatement pstmt = null;
/*  25: 22 */     ResultSet rs = null;
/*  26: 23 */     Razas razaS = new Razas();
/*  27:    */     try
/*  28:    */     {
/*  29: 25 */       conn = this.ds.getConnection();
/*  30: 26 */       DBUtil db = new DBUtil();
/*  31: 27 */       if (this.idioma != null) {
/*  32: 28 */         db.setIdioma(this.idioma);
/*  33:    */       }
/*  34: 30 */       String sql = db.creaSQLSELECT(razaS);
/*  35: 31 */       pstmt = conn.prepareStatement(sql);
/*  36: 32 */       rs = pstmt.executeQuery();
/*  37: 33 */       while (rs.next())
/*  38:    */       {
/*  39: 34 */         Razas raza = new Razas();
/*  40: 35 */         InicializaData.inicializa(raza.getClass(), raza);
/*  41: 36 */         populate(raza, rs);
/*  42: 37 */         list.add(raza);
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
/*  61:    */   public List list(BigDecimal raz_tipo)
/*  62:    */     throws SQLException
/*  63:    */   {
/*  64: 53 */     ArrayList list = new ArrayList();
/*  65: 54 */     Connection conn = null;
/*  66: 55 */     PreparedStatement pstmt = null;
/*  67: 56 */     ResultSet rs = null;
/*  68: 57 */     Razas razaS = new Razas();
/*  69:    */     try
/*  70:    */     {
/*  71: 59 */       conn = this.ds.getConnection();
/*  72: 60 */       DBUtil db = new DBUtil();
/*  73: 61 */       if (this.idioma != null) {
/*  74: 62 */         db.setIdioma(this.idioma);
/*  75:    */       }
/*  76: 64 */       String sql = db.creaSQLSELECT(razaS);
/*  77: 65 */       pstmt = conn.prepareStatement(sql + " where raz_tipo = ?");
/*  78: 66 */       pstmt.setBigDecimal(1, raz_tipo);
/*  79: 67 */       rs = pstmt.executeQuery();
/*  80: 68 */       while (rs.next())
/*  81:    */       {
/*  82: 69 */         Razas raza = new Razas();
/*  83: 70 */         InicializaData.inicializa(raza.getClass(), raza);
/*  84: 71 */         populate(raza, rs);
/*  85: 72 */         list.add(raza);
/*  86:    */       }
/*  87: 74 */       close(rs);
/*  88: 75 */       close(pstmt);
/*  89:    */     }
/*  90:    */     catch (SQLException e)
/*  91:    */     {
/*  92: 77 */       close(rs);
/*  93: 78 */       close(pstmt);
/*  94: 79 */       rollback(conn);
/*  95: 80 */       throw e;
/*  96:    */     }
/*  97:    */     finally
/*  98:    */     {
/*  99: 82 */       close(conn);
/* 100:    */     }
/* 101: 84 */     return list;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public void update(Razas data, String[] llaves)
/* 105:    */     throws SQLException
/* 106:    */   {
/* 107: 88 */     Connection conn = null;
/* 108: 89 */     PreparedStatement pstmt = null;
/* 109:    */     try
/* 110:    */     {
/* 111: 91 */       DBUtil db = new DBUtil();
/* 112: 92 */       if (this.idioma != null) {
/* 113: 93 */         db.setIdioma(this.idioma);
/* 114:    */       }
/* 115: 95 */       conn = this.ds.getConnection();
/* 116: 96 */       conn.setAutoCommit(false);
/* 117: 97 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 118: 98 */       pstmt = conn.prepareStatement(sql);
/* 119:    */       
/* 120:100 */       pstmt.executeUpdate();
/* 121:101 */       close(pstmt);
/* 122:102 */       conn.commit();
/* 123:    */     }
/* 124:    */     catch (SQLException e)
/* 125:    */     {
/* 126:104 */       close(pstmt);
/* 127:105 */       rollback(conn);
/* 128:106 */       throw e;
/* 129:    */     }
/* 130:    */     finally
/* 131:    */     {
/* 132:108 */       close(conn);
/* 133:    */     }
/* 134:    */   }
/* 135:    */   
/* 136:    */   public synchronized void insert(Razas data)
/* 137:    */     throws SQLException
/* 138:    */   {
/* 139:113 */     Connection conn = null;
/* 140:114 */     PreparedStatement pstmt = null;
/* 141:    */     
/* 142:116 */     ResultSet rs = null;
/* 143:    */     try
/* 144:    */     {
/* 145:118 */       int id = 0;
/* 146:119 */       DBUtil db = new DBUtil();
/* 147:120 */       if (this.idioma != null) {
/* 148:121 */         db.setIdioma(this.idioma);
/* 149:    */       }
/* 150:124 */       conn = this.ds.getConnection();
/* 151:125 */       conn.setAutoCommit(false);
/* 152:126 */       id = getReqMax(conn);
/* 153:127 */       data.setRaz_cod(new BigDecimal(id));
/* 154:128 */       String sql = db.creaSQLINSERT(data);
/* 155:    */       
/* 156:130 */       pstmt = conn.prepareStatement(sql);
/* 157:131 */       pstmt.executeUpdate();
/* 158:132 */       pstmt.close();
/* 159:133 */       conn.commit();
/* 160:    */     }
/* 161:    */     catch (SQLException sqle)
/* 162:    */     {
/* 163:135 */       close(rs);
/* 164:136 */       close(pstmt);
/* 165:137 */       rollback(conn);
/* 166:138 */       throw sqle;
/* 167:    */     }
/* 168:    */     finally
/* 169:    */     {
/* 170:140 */       close(rs);
/* 171:141 */       close(pstmt);
/* 172:142 */       close(conn);
/* 173:    */     }
/* 174:    */   }
/* 175:    */   
/* 176:    */   public void delete(Razas data)
/* 177:    */     throws SQLException
/* 178:    */   {
/* 179:146 */     Connection conn = null;
/* 180:147 */     PreparedStatement pstmt = null;
/* 181:    */     try
/* 182:    */     {
/* 183:149 */       conn = this.ds.getConnection();
/* 184:150 */       conn.setAutoCommit(false);
/* 185:151 */       String sql = "DELETE FROM sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".razas WHERE raz_cod=?";
/* 186:152 */       pstmt = conn.prepareStatement(sql);
/* 187:153 */       pstmt.setBigDecimal(1, data.getRaz_cod());
/* 188:154 */       pstmt.executeUpdate();
/* 189:155 */       close(pstmt);
/* 190:156 */       conn.commit();
/* 191:    */     }
/* 192:    */     catch (SQLException e)
/* 193:    */     {
/* 194:158 */       close(pstmt);
/* 195:159 */       rollback(conn);
/* 196:160 */       throw e;
/* 197:    */     }
/* 198:    */     finally
/* 199:    */     {
/* 200:162 */       close(conn);
/* 201:    */     }
/* 202:    */   }
/* 203:    */   
/* 204:    */   private int getReqMax(Connection conn)
/* 205:    */   {
/* 206:166 */     PreparedStatement pstmt = null;
/* 207:167 */     ResultSet rs = null;
/* 208:168 */     int id = 0;
/* 209:    */     try
/* 210:    */     {
/* 211:170 */       String sqlid = "Select max(raz_cod) from sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".razas ";
/* 212:171 */       pstmt = conn.prepareStatement(sqlid);
/* 213:172 */       rs = pstmt.executeQuery();
/* 214:173 */       if ((rs != null) && (rs.next())) {
/* 215:174 */         id = rs.getInt(1) + 1;
/* 216:    */       } else {
/* 217:176 */         id++;
/* 218:    */       }
/* 219:    */     }
/* 220:    */     catch (SQLException e)
/* 221:    */     {
/* 222:180 */       close(rs);
/* 223:181 */       close(pstmt);
/* 224:182 */       rollback(conn);
/* 225:183 */       e.printStackTrace();
/* 226:    */     }
/* 227:    */     finally
/* 228:    */     {
/* 229:185 */       close(rs);
/* 230:186 */       close(pstmt);
/* 231:    */     }
/* 232:188 */     return id;
/* 233:    */   }
/* 234:    */   
/* 235:    */   public Razas retrive(BigDecimal raz_cod)
/* 236:    */     throws SQLException
/* 237:    */   {
/* 238:193 */     Connection conn = null;
/* 239:194 */     PreparedStatement pstmt = null;
/* 240:195 */     ResultSet rs = null;
/* 241:196 */     Razas razaS = new Razas();
/* 242:197 */     Razas raza = null;
/* 243:    */     try
/* 244:    */     {
/* 245:200 */       conn = this.ds.getConnection();
/* 246:201 */       DBUtil db = new DBUtil();
/* 247:202 */       if (this.idioma != null) {
/* 248:203 */         db.setIdioma(this.idioma);
/* 249:    */       }
/* 250:205 */       String sql = db.creaSQLSELECT(razaS);
/* 251:206 */       pstmt = conn.prepareStatement(sql + " where raz_cod = ?");
/* 252:207 */       pstmt.setBigDecimal(1, raz_cod);
/* 253:208 */       rs = pstmt.executeQuery();
/* 254:209 */       if (rs.next())
/* 255:    */       {
/* 256:210 */         raza = new Razas();
/* 257:211 */         InicializaData.inicializa(raza.getClass(), raza);
/* 258:212 */         populate(raza, rs);
/* 259:    */       }
/* 260:214 */       close(rs);
/* 261:215 */       close(pstmt);
/* 262:    */     }
/* 263:    */     catch (SQLException e)
/* 264:    */     {
/* 265:218 */       close(rs);
/* 266:219 */       close(pstmt);
/* 267:220 */       rollback(conn);
/* 268:221 */       throw e;
/* 269:    */     }
/* 270:    */     finally
/* 271:    */     {
/* 272:224 */       close(conn);
/* 273:    */     }
/* 274:227 */     return raza;
/* 275:    */   }
/* 276:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.RazasDAO
 * JD-Core Version:    0.7.0.1
 */