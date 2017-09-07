/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.Enfermedades;
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
/*  16:    */ public class EnfermedadesDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list()
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 26 */     ArrayList list = new ArrayList();
/*  23: 27 */     Connection conn = null;
/*  24: 28 */     PreparedStatement pstmt = null;
/*  25: 29 */     ResultSet rs = null;
/*  26: 30 */     Enfermedades EnfermedadS = new Enfermedades();
/*  27:    */     try
/*  28:    */     {
/*  29: 32 */       conn = this.ds.getConnection();
/*  30: 33 */       DBUtil db = new DBUtil();
/*  31: 34 */       if (this.idioma != null) {
/*  32: 35 */         db.setIdioma(this.idioma);
/*  33:    */       }
/*  34: 37 */       String sql = db.creaSQLSELECT(EnfermedadS);
/*  35: 38 */       pstmt = conn.prepareStatement(sql + " where enf_cod > 0 order by enf_des");
/*  36: 39 */       rs = pstmt.executeQuery();
/*  37: 40 */       while (rs.next())
/*  38:    */       {
/*  39: 41 */         Enfermedades enfermedad = new Enfermedades();
/*  40: 42 */         InicializaData.inicializa(enfermedad.getClass(), enfermedad);
/*  41: 43 */         populate(enfermedad, rs);
/*  42: 44 */         list.add(enfermedad);
/*  43:    */       }
/*  44: 46 */       close(rs);
/*  45: 47 */       close(pstmt);
/*  46:    */     }
/*  47:    */     catch (SQLException e)
/*  48:    */     {
/*  49: 49 */       close(rs);
/*  50: 50 */       close(pstmt);
/*  51: 51 */       rollback(conn);
/*  52: 52 */       throw e;
/*  53:    */     }
/*  54:    */     finally
/*  55:    */     {
/*  56: 54 */       close(conn);
/*  57:    */     }
/*  58: 56 */     return list;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public List search(BigDecimal enf_sis_cod)
/*  62:    */     throws SQLException
/*  63:    */   {
/*  64: 60 */     ArrayList list = new ArrayList();
/*  65: 61 */     Connection conn = null;
/*  66: 62 */     PreparedStatement pstmt = null;
/*  67: 63 */     ResultSet rs = null;
/*  68: 64 */     Enfermedades enfermedadesS = new Enfermedades();
/*  69:    */     try
/*  70:    */     {
/*  71: 66 */       conn = this.ds.getConnection();
/*  72: 67 */       DBUtil db = new DBUtil();
/*  73: 68 */       if (this.idioma != null) {
/*  74: 69 */         db.setIdioma(this.idioma);
/*  75:    */       }
/*  76: 71 */       String sql = db.creaSQLSELECT(enfermedadesS);
/*  77: 72 */       pstmt = conn.prepareStatement(sql + " where enf_sis_cod = " + enf_sis_cod + " order by enf_des");
/*  78: 73 */       rs = pstmt.executeQuery();
/*  79: 74 */       while (rs.next())
/*  80:    */       {
/*  81: 75 */         Enfermedades enfermedad = new Enfermedades();
/*  82: 76 */         InicializaData.inicializa(enfermedad.getClass(), enfermedad);
/*  83: 77 */         populate(enfermedad, rs);
/*  84: 78 */         list.add(enfermedad);
/*  85:    */       }
/*  86: 80 */       close(rs);
/*  87: 81 */       close(pstmt);
/*  88:    */     }
/*  89:    */     catch (SQLException e)
/*  90:    */     {
/*  91: 83 */       close(rs);
/*  92: 84 */       close(pstmt);
/*  93: 85 */       rollback(conn);
/*  94: 86 */       throw e;
/*  95:    */     }
/*  96:    */     finally
/*  97:    */     {
/*  98: 88 */       close(conn);
/*  99:    */     }
/* 100: 90 */     return list;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public Enfermedades retrive(BigDecimal enf_cod)
/* 104:    */     throws SQLException
/* 105:    */   {
/* 106: 95 */     Enfermedades enfermedades = new Enfermedades();
/* 107: 96 */     Connection conn = null;
/* 108: 97 */     PreparedStatement pstmt = null;
/* 109: 98 */     ResultSet rs = null;
/* 110: 99 */     Enfermedades enfermedadesS = new Enfermedades();
/* 111:    */     try
/* 112:    */     {
/* 113:101 */       conn = this.ds.getConnection();
/* 114:102 */       DBUtil db = new DBUtil();
/* 115:103 */       if (this.idioma != null) {
/* 116:104 */         db.setIdioma(this.idioma);
/* 117:    */       }
/* 118:106 */       String sql = db.creaSQLSELECT(enfermedadesS);
/* 119:107 */       String where = " where enf_cod=" + enf_cod;
/* 120:108 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 121:109 */       rs = pstmt.executeQuery();
/* 122:110 */       if (rs.next())
/* 123:    */       {
/* 124:111 */         InicializaData.inicializa(enfermedades.getClass(), enfermedades);
/* 125:112 */         populate(enfermedades, rs);
/* 126:    */       }
/* 127:114 */       close(rs);
/* 128:115 */       close(pstmt);
/* 129:    */     }
/* 130:    */     catch (SQLException e)
/* 131:    */     {
/* 132:117 */       close(rs);
/* 133:118 */       close(pstmt);
/* 134:119 */       rollback(conn);
/* 135:120 */       throw e;
/* 136:    */     }
/* 137:    */     finally
/* 138:    */     {
/* 139:122 */       close(conn);
/* 140:    */     }
/* 141:124 */     return enfermedades;
/* 142:    */   }
/* 143:    */   
/* 144:    */   public synchronized void insert(Enfermedades data)
/* 145:    */     throws SQLException
/* 146:    */   {
/* 147:128 */     Connection conn = null;
/* 148:129 */     PreparedStatement pstmt = null;
/* 149:    */     
/* 150:131 */     ResultSet rs = null;
/* 151:    */     try
/* 152:    */     {
/* 153:133 */       int id = 0;
/* 154:134 */       DBUtil db = new DBUtil();
/* 155:135 */       if (this.idioma != null) {
/* 156:136 */         db.setIdioma(this.idioma);
/* 157:    */       }
/* 158:139 */       conn = this.ds.getConnection();
/* 159:140 */       conn.setAutoCommit(false);
/* 160:141 */       id = getReqMax(conn);
/* 161:142 */       data.setEnf_cod(new BigDecimal(id));
/* 162:143 */       String sql = db.creaSQLINSERT(data);
/* 163:144 */       pstmt = conn.prepareStatement(sql);
/* 164:145 */       pstmt.executeUpdate();
/* 165:146 */       pstmt.close();
/* 166:147 */       conn.commit();
/* 167:    */     }
/* 168:    */     catch (SQLException sqle)
/* 169:    */     {
/* 170:149 */       close(rs);
/* 171:150 */       close(pstmt);
/* 172:151 */       rollback(conn);
/* 173:152 */       throw sqle;
/* 174:    */     }
/* 175:    */     finally
/* 176:    */     {
/* 177:154 */       close(rs);
/* 178:155 */       close(pstmt);
/* 179:156 */       close(conn);
/* 180:    */     }
/* 181:    */   }
/* 182:    */   
/* 183:    */   public void update(Enfermedades data, String[] llaves)
/* 184:    */     throws SQLException
/* 185:    */   {
/* 186:161 */     Connection conn = null;
/* 187:162 */     PreparedStatement pstmt = null;
/* 188:    */     try
/* 189:    */     {
/* 190:164 */       DBUtil db = new DBUtil();
/* 191:165 */       if (this.idioma != null) {
/* 192:166 */         db.setIdioma(this.idioma);
/* 193:    */       }
/* 194:168 */       conn = this.ds.getConnection();
/* 195:169 */       conn.setAutoCommit(false);
/* 196:170 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 197:171 */       pstmt = conn.prepareStatement(sql);
/* 198:172 */       pstmt.executeUpdate();
/* 199:173 */       close(pstmt);
/* 200:174 */       conn.commit();
/* 201:    */     }
/* 202:    */     catch (SQLException e)
/* 203:    */     {
/* 204:176 */       close(pstmt);
/* 205:177 */       rollback(conn);
/* 206:178 */       throw e;
/* 207:    */     }
/* 208:    */     finally
/* 209:    */     {
/* 210:180 */       close(conn);
/* 211:    */     }
/* 212:    */   }
/* 213:    */   
/* 214:    */   public void delete(Enfermedades data)
/* 215:    */     throws SQLException
/* 216:    */   {
/* 217:185 */     Connection conn = null;
/* 218:186 */     PreparedStatement pstmt = null;
/* 219:    */     try
/* 220:    */     {
/* 221:188 */       conn = this.ds.getConnection();
/* 222:189 */       conn.setAutoCommit(false);
/* 223:190 */       String sql = "DELETE FROM sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".enfermedades WHERE enf_cod=?";
/* 224:191 */       pstmt = conn.prepareStatement(sql);
/* 225:192 */       pstmt.setBigDecimal(1, data.getEnf_cod());
/* 226:193 */       pstmt.executeUpdate();
/* 227:194 */       close(pstmt);
/* 228:195 */       conn.commit();
/* 229:    */     }
/* 230:    */     catch (SQLException e)
/* 231:    */     {
/* 232:197 */       close(pstmt);
/* 233:198 */       rollback(conn);
/* 234:199 */       throw e;
/* 235:    */     }
/* 236:    */     finally
/* 237:    */     {
/* 238:201 */       close(conn);
/* 239:    */     }
/* 240:    */   }
/* 241:    */   
/* 242:    */   private int getReqMax(Connection conn)
/* 243:    */   {
/* 244:206 */     PreparedStatement pstmt = null;
/* 245:207 */     ResultSet rs = null;
/* 246:208 */     int id = 0;
/* 247:    */     try
/* 248:    */     {
/* 249:210 */       String sql = "Select max(enf_cod) from sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".enfermedades";
/* 250:211 */       pstmt = conn.prepareStatement(sql);
/* 251:212 */       rs = pstmt.executeQuery();
/* 252:213 */       if ((rs != null) && (rs.next())) {
/* 253:214 */         id = rs.getInt(1) + 1;
/* 254:    */       } else {
/* 255:216 */         id++;
/* 256:    */       }
/* 257:    */     }
/* 258:    */     catch (SQLException e)
/* 259:    */     {
/* 260:220 */       close(rs);
/* 261:221 */       close(pstmt);
/* 262:222 */       rollback(conn);
/* 263:223 */       e.printStackTrace();
/* 264:    */     }
/* 265:    */     finally
/* 266:    */     {
/* 267:225 */       close(rs);
/* 268:226 */       close(pstmt);
/* 269:    */     }
/* 270:228 */     return id;
/* 271:    */   }
/* 272:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.EnfermedadesDAO
 * JD-Core Version:    0.7.0.1
 */