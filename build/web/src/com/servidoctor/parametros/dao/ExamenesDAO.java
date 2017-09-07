/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.Examenes;
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
/*  16:    */ public class ExamenesDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list()
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 27 */     ArrayList list = new ArrayList();
/*  23: 28 */     Connection conn = null;
/*  24: 29 */     PreparedStatement pstmt = null;
/*  25: 30 */     ResultSet rs = null;
/*  26: 31 */     Examenes examenesS = new Examenes();
/*  27:    */     try
/*  28:    */     {
/*  29: 33 */       conn = this.ds.getConnection();
/*  30: 34 */       DBUtil db = new DBUtil();
/*  31: 35 */       if (this.idioma != null) {
/*  32: 36 */         db.setIdioma(this.idioma);
/*  33:    */       }
/*  34: 38 */       String sql = db.creaSQLSELECT(examenesS);
/*  35: 39 */       pstmt = conn.prepareStatement(sql + " order by exa_des");
/*  36: 40 */       rs = pstmt.executeQuery();
/*  37: 41 */       while (rs.next())
/*  38:    */       {
/*  39: 42 */         Examenes examen = new Examenes();
/*  40: 43 */         InicializaData.inicializa(examen.getClass(), examen);
/*  41: 44 */         populate(examen, rs);
/*  42: 45 */         list.add(examen);
/*  43:    */       }
/*  44: 47 */       close(rs);
/*  45: 48 */       close(pstmt);
/*  46:    */     }
/*  47:    */     catch (SQLException e)
/*  48:    */     {
/*  49: 50 */       close(rs);
/*  50: 51 */       close(pstmt);
/*  51: 52 */       rollback(conn);
/*  52: 53 */       throw e;
/*  53:    */     }
/*  54:    */     finally
/*  55:    */     {
/*  56: 55 */       close(conn);
/*  57:    */     }
/*  58: 57 */     return list;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public List list(String sexo)
/*  62:    */     throws SQLException
/*  63:    */   {
/*  64: 61 */     ArrayList list = new ArrayList();
/*  65: 62 */     Connection conn = null;
/*  66: 63 */     PreparedStatement pstmt = null;
/*  67: 64 */     ResultSet rs = null;
/*  68: 65 */     Examenes examenesS = new Examenes();
/*  69:    */     try
/*  70:    */     {
/*  71: 67 */       conn = this.ds.getConnection();
/*  72: 68 */       DBUtil db = new DBUtil();
/*  73: 69 */       if (this.idioma != null) {
/*  74: 70 */         db.setIdioma(this.idioma);
/*  75:    */       }
/*  76: 72 */       String sql = db.creaSQLSELECT(examenesS);
/*  77: 73 */       String where = " where exa_sexo='" + sexo + "' or exa_sexo='" + "A" + "'";
/*  78: 74 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  79: 75 */       rs = pstmt.executeQuery();
/*  80: 76 */       while (rs.next())
/*  81:    */       {
/*  82: 77 */         Examenes examen = new Examenes();
/*  83: 78 */         InicializaData.inicializa(examen.getClass(), examen);
/*  84: 79 */         populate(examen, rs);
/*  85: 80 */         list.add(examen);
/*  86:    */       }
/*  87: 82 */       close(rs);
/*  88: 83 */       close(pstmt);
/*  89:    */     }
/*  90:    */     catch (SQLException e)
/*  91:    */     {
/*  92: 85 */       close(rs);
/*  93: 86 */       close(pstmt);
/*  94: 87 */       rollback(conn);
/*  95: 88 */       throw e;
/*  96:    */     }
/*  97:    */     finally
/*  98:    */     {
/*  99: 90 */       close(conn);
/* 100:    */     }
/* 101: 92 */     return list;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public void update(Examenes data, String[] llaves)
/* 105:    */     throws SQLException
/* 106:    */   {
/* 107: 96 */     Connection conn = null;
/* 108: 97 */     PreparedStatement pstmt = null;
/* 109:    */     try
/* 110:    */     {
/* 111: 99 */       DBUtil db = new DBUtil();
/* 112:100 */       if (this.idioma != null) {
/* 113:101 */         db.setIdioma(this.idioma);
/* 114:    */       }
/* 115:103 */       conn = this.ds.getConnection();
/* 116:104 */       conn.setAutoCommit(false);
/* 117:105 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 118:106 */       pstmt = conn.prepareStatement(sql);
/* 119:107 */       pstmt.executeUpdate();
/* 120:108 */       close(pstmt);
/* 121:109 */       conn.commit();
/* 122:    */     }
/* 123:    */     catch (SQLException e)
/* 124:    */     {
/* 125:111 */       close(pstmt);
/* 126:112 */       rollback(conn);
/* 127:113 */       throw e;
/* 128:    */     }
/* 129:    */     finally
/* 130:    */     {
/* 131:115 */       close(conn);
/* 132:    */     }
/* 133:    */   }
/* 134:    */   
/* 135:    */   public Examenes retrive(BigDecimal exa_cod)
/* 136:    */     throws SQLException
/* 137:    */   {
/* 138:121 */     Examenes examenes = new Examenes();
/* 139:122 */     Connection conn = null;
/* 140:123 */     PreparedStatement pstmt = null;
/* 141:124 */     ResultSet rs = null;
/* 142:125 */     Examenes examenesS = new Examenes();
/* 143:    */     try
/* 144:    */     {
/* 145:127 */       conn = this.ds.getConnection();
/* 146:128 */       DBUtil db = new DBUtil();
/* 147:129 */       if (this.idioma != null) {
/* 148:130 */         db.setIdioma(this.idioma);
/* 149:    */       }
/* 150:132 */       String sql = db.creaSQLSELECT(examenesS);
/* 151:133 */       String where = " where exa_cod=" + exa_cod;
/* 152:134 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 153:135 */       rs = pstmt.executeQuery();
/* 154:136 */       if (rs.next())
/* 155:    */       {
/* 156:137 */         InicializaData.inicializa(examenes.getClass(), examenes);
/* 157:138 */         populate(examenes, rs);
/* 158:    */       }
/* 159:140 */       close(rs);
/* 160:141 */       close(pstmt);
/* 161:    */     }
/* 162:    */     catch (SQLException e)
/* 163:    */     {
/* 164:143 */       close(rs);
/* 165:144 */       close(pstmt);
/* 166:145 */       rollback(conn);
/* 167:146 */       throw e;
/* 168:    */     }
/* 169:    */     finally
/* 170:    */     {
/* 171:148 */       close(conn);
/* 172:    */     }
/* 173:150 */     return examenes;
/* 174:    */   }
/* 175:    */   
/* 176:    */   public synchronized void insert(Examenes data)
/* 177:    */     throws SQLException
/* 178:    */   {
/* 179:153 */     Connection conn = null;
/* 180:154 */     PreparedStatement pstmt = null;
/* 181:    */     
/* 182:156 */     ResultSet rs = null;
/* 183:    */     try
/* 184:    */     {
/* 185:158 */       int id = 0;
/* 186:159 */       DBUtil db = new DBUtil();
/* 187:160 */       if (this.idioma != null) {
/* 188:161 */         db.setIdioma(this.idioma);
/* 189:    */       }
/* 190:164 */       conn = this.ds.getConnection();
/* 191:165 */       conn.setAutoCommit(false);
/* 192:166 */       id = getReqMax(conn);
/* 193:167 */       data.setExa_cod(new BigDecimal(id));
/* 194:168 */       String sql = db.creaSQLINSERT(data);
/* 195:    */       
/* 196:170 */       pstmt = conn.prepareStatement(sql);
/* 197:171 */       pstmt.executeUpdate();
/* 198:172 */       pstmt.close();
/* 199:173 */       conn.commit();
/* 200:    */     }
/* 201:    */     catch (SQLException sqle)
/* 202:    */     {
/* 203:175 */       close(rs);
/* 204:176 */       close(pstmt);
/* 205:177 */       rollback(conn);
/* 206:178 */       throw sqle;
/* 207:    */     }
/* 208:    */     finally
/* 209:    */     {
/* 210:180 */       close(rs);
/* 211:181 */       close(pstmt);
/* 212:182 */       close(conn);
/* 213:    */     }
/* 214:    */   }
/* 215:    */   
/* 216:    */   public void delete(Examenes data)
/* 217:    */     throws SQLException
/* 218:    */   {
/* 219:186 */     Connection conn = null;
/* 220:187 */     PreparedStatement pstmt = null;
/* 221:    */     try
/* 222:    */     {
/* 223:189 */       conn = this.ds.getConnection();
/* 224:190 */       conn.setAutoCommit(false);
/* 225:191 */       String sql = "DELETE FROM sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".examenes WHERE exa_cod = ?";
/* 226:192 */       pstmt = conn.prepareStatement(sql);
/* 227:193 */       pstmt.setBigDecimal(1, data.getExa_cod());
/* 228:194 */       pstmt.executeUpdate();
/* 229:195 */       close(pstmt);
/* 230:196 */       conn.commit();
/* 231:    */     }
/* 232:    */     catch (SQLException e)
/* 233:    */     {
/* 234:198 */       close(pstmt);
/* 235:199 */       rollback(conn);
/* 236:200 */       throw e;
/* 237:    */     }
/* 238:    */     finally
/* 239:    */     {
/* 240:202 */       close(conn);
/* 241:    */     }
/* 242:    */   }
/* 243:    */   
/* 244:    */   private int getReqMax(Connection conn)
/* 245:    */   {
/* 246:207 */     PreparedStatement pstmt = null;
/* 247:208 */     ResultSet rs = null;
/* 248:209 */     int id = 0;
/* 249:    */     try
/* 250:    */     {
/* 251:211 */       String sqlid = "Select max(exa_cod) from sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".examenes ";
/* 252:212 */       pstmt = conn.prepareStatement(sqlid);
/* 253:213 */       rs = pstmt.executeQuery();
/* 254:214 */       if ((rs != null) && (rs.next())) {
/* 255:215 */         id = rs.getInt(1) + 1;
/* 256:    */       } else {
/* 257:217 */         id++;
/* 258:    */       }
/* 259:    */     }
/* 260:    */     catch (SQLException e)
/* 261:    */     {
/* 262:221 */       close(rs);
/* 263:222 */       close(pstmt);
/* 264:223 */       rollback(conn);
/* 265:224 */       e.printStackTrace();
/* 266:    */     }
/* 267:    */     finally
/* 268:    */     {
/* 269:226 */       close(rs);
/* 270:227 */       close(pstmt);
/* 271:    */     }
/* 272:229 */     return id;
/* 273:    */   }
/* 274:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.ExamenesDAO
 * JD-Core Version:    0.7.0.1
 */