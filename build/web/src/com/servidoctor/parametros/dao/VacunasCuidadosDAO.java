/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.VacunasCuidados;
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
/*  16:    */ public class VacunasCuidadosDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list()
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 26 */     ArrayList list = new ArrayList();
/*  23: 27 */     Connection conn = null;
/*  24: 28 */     PreparedStatement pstmt = null;
/*  25: 29 */     ResultSet rs = null;
/*  26: 30 */     VacunasCuidados vacunasCuidadosS = new VacunasCuidados();
/*  27:    */     try
/*  28:    */     {
/*  29: 33 */       conn = this.ds.getConnection();
/*  30: 34 */       DBUtil db = new DBUtil();
/*  31: 35 */       if (this.idioma != null) {
/*  32: 36 */         db.setIdioma(this.idioma);
/*  33:    */       }
/*  34: 38 */       String sql = db.creaSQLSELECT(vacunasCuidadosS);
/*  35: 39 */       pstmt = conn.prepareStatement(sql);
/*  36: 40 */       rs = pstmt.executeQuery();
/*  37: 42 */       while (rs.next())
/*  38:    */       {
/*  39: 43 */         VacunasCuidados vacunasCuidados = new VacunasCuidados();
/*  40: 44 */         InicializaData.inicializa(vacunasCuidados.getClass(), vacunasCuidados);
/*  41: 45 */         populate(vacunasCuidados, rs);
/*  42: 46 */         list.add(vacunasCuidados);
/*  43:    */       }
/*  44: 48 */       close(rs);
/*  45: 49 */       close(pstmt);
/*  46:    */     }
/*  47:    */     catch (SQLException e)
/*  48:    */     {
/*  49: 51 */       close(rs);
/*  50: 52 */       close(pstmt);
/*  51: 53 */       rollback(conn);
/*  52: 54 */       throw e;
/*  53:    */     }
/*  54:    */     finally
/*  55:    */     {
/*  56: 56 */       close(conn);
/*  57:    */     }
/*  58: 58 */     return list;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public List list(BigDecimal vcui_mas_cod)
/*  62:    */     throws SQLException
/*  63:    */   {
/*  64: 63 */     ArrayList list = new ArrayList();
/*  65: 64 */     Connection conn = null;
/*  66: 65 */     PreparedStatement pstmt = null;
/*  67: 66 */     ResultSet rs = null;
/*  68: 67 */     VacunasCuidados vacunasCuidadosS = new VacunasCuidados();
/*  69:    */     try
/*  70:    */     {
/*  71: 70 */       conn = this.ds.getConnection();
/*  72: 71 */       DBUtil db = new DBUtil();
/*  73: 72 */       if (this.idioma != null) {
/*  74: 73 */         db.setIdioma(this.idioma);
/*  75:    */       }
/*  76: 75 */       String sql = db.creaSQLSELECT(vacunasCuidadosS);
/*  77: 76 */       pstmt = conn.prepareStatement(sql + " where vcui_mas_cod = " + vcui_mas_cod);
/*  78: 77 */       rs = pstmt.executeQuery();
/*  79: 79 */       while (rs.next())
/*  80:    */       {
/*  81: 80 */         VacunasCuidados vacunasCuidados = new VacunasCuidados();
/*  82: 81 */         InicializaData.inicializa(vacunasCuidados.getClass(), vacunasCuidados);
/*  83: 82 */         populate(vacunasCuidados, rs);
/*  84: 83 */         list.add(vacunasCuidados);
/*  85:    */       }
/*  86: 85 */       close(rs);
/*  87: 86 */       close(pstmt);
/*  88:    */     }
/*  89:    */     catch (SQLException e)
/*  90:    */     {
/*  91: 88 */       close(rs);
/*  92: 89 */       close(pstmt);
/*  93: 90 */       rollback(conn);
/*  94: 91 */       throw e;
/*  95:    */     }
/*  96:    */     finally
/*  97:    */     {
/*  98: 93 */       close(conn);
/*  99:    */     }
/* 100: 95 */     return list;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public List list(BigDecimal vcui_mas_cod, BigDecimal vcui_raz_tipo)
/* 104:    */     throws SQLException
/* 105:    */   {
/* 106: 99 */     ArrayList list = list = new ArrayList();
/* 107:100 */     Connection conn = null;
/* 108:101 */     PreparedStatement pstmt = null;
/* 109:102 */     ResultSet rs = null;
/* 110:103 */     VacunasCuidados vacunasCuidadosS = new VacunasCuidados();
/* 111:    */     try
/* 112:    */     {
/* 113:105 */       conn = this.ds.getConnection();
/* 114:106 */       DBUtil db = new DBUtil();
/* 115:107 */       if (this.idioma != null) {
/* 116:108 */         db.setIdioma(this.idioma);
/* 117:    */       }
/* 118:110 */       String sql = db.creaSQLSELECT(vacunasCuidadosS);
/* 119:111 */       pstmt = conn.prepareStatement(sql + " where vcui_mas_cod = " + vcui_mas_cod + " and vcui_raz_tipo = " + vcui_raz_tipo);
/* 120:112 */       rs = pstmt.executeQuery();
/* 121:113 */       while (rs.next())
/* 122:    */       {
/* 123:114 */         VacunasCuidados vacunasCuidados = new VacunasCuidados();
/* 124:115 */         InicializaData.inicializa(vacunasCuidados.getClass(), vacunasCuidados);
/* 125:116 */         populate(vacunasCuidados, rs);
/* 126:117 */         list.add(vacunasCuidados);
/* 127:    */       }
/* 128:119 */       close(rs);
/* 129:120 */       close(pstmt);
/* 130:    */     }
/* 131:    */     catch (SQLException e)
/* 132:    */     {
/* 133:122 */       close(rs);
/* 134:123 */       close(pstmt);
/* 135:124 */       rollback(conn);
/* 136:125 */       throw e;
/* 137:    */     }
/* 138:    */     finally
/* 139:    */     {
/* 140:127 */       close(conn);
/* 141:    */     }
/* 142:129 */     return list;
/* 143:    */   }
/* 144:    */   
/* 145:    */   public VacunasCuidados retrive(BigDecimal vcui_cod, BigDecimal vcui_mas_cod)
/* 146:    */     throws SQLException
/* 147:    */   {
/* 148:134 */     VacunasCuidados vacunasCuidados = new VacunasCuidados();
/* 149:135 */     Connection conn = null;
/* 150:136 */     PreparedStatement pstmt = null;
/* 151:137 */     ResultSet rs = null;
/* 152:138 */     VacunasCuidados vacunasCuidadosS = new VacunasCuidados();
/* 153:    */     try
/* 154:    */     {
/* 155:140 */       conn = this.ds.getConnection();
/* 156:141 */       DBUtil db = new DBUtil();
/* 157:142 */       if (this.idioma != null) {
/* 158:143 */         db.setIdioma(this.idioma);
/* 159:    */       }
/* 160:145 */       String sql = db.creaSQLSELECT(vacunasCuidadosS);
/* 161:146 */       String where = " where vcui_cod=" + vcui_cod + " and vcui_mas_cod = " + vcui_mas_cod;
/* 162:147 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 163:148 */       rs = pstmt.executeQuery();
/* 164:149 */       if (rs.next())
/* 165:    */       {
/* 166:151 */         InicializaData.inicializa(vacunasCuidados.getClass(), vacunasCuidados);
/* 167:152 */         populate(vacunasCuidados, rs);
/* 168:    */       }
/* 169:155 */       close(rs);
/* 170:156 */       close(pstmt);
/* 171:    */     }
/* 172:    */     catch (SQLException e)
/* 173:    */     {
/* 174:158 */       close(rs);
/* 175:159 */       close(pstmt);
/* 176:160 */       rollback(conn);
/* 177:161 */       throw e;
/* 178:    */     }
/* 179:    */     finally
/* 180:    */     {
/* 181:163 */       close(conn);
/* 182:    */     }
/* 183:165 */     return vacunasCuidados;
/* 184:    */   }
/* 185:    */   
/* 186:    */   public void update(VacunasCuidados data, String[] llaves, Connection conn)
/* 187:    */     throws SQLException
/* 188:    */   {
/* 189:169 */     PreparedStatement pstmt = null;
/* 190:    */     try
/* 191:    */     {
/* 192:171 */       DBUtil db = new DBUtil();
/* 193:172 */       if (this.idioma != null) {
/* 194:173 */         db.setIdioma(this.idioma);
/* 195:    */       }
/* 196:175 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 197:176 */       pstmt = conn.prepareStatement(sql);
/* 198:177 */       pstmt.executeUpdate();
/* 199:    */     }
/* 200:    */     catch (SQLException e)
/* 201:    */     {
/* 202:179 */       throw e;
/* 203:    */     }
/* 204:    */     finally
/* 205:    */     {
/* 206:181 */       close(pstmt);
/* 207:    */     }
/* 208:    */   }
/* 209:    */   
/* 210:    */   public synchronized void insert(VacunasCuidados data, Connection conn)
/* 211:    */     throws SQLException
/* 212:    */   {
/* 213:185 */     PreparedStatement pstmt = null;
/* 214:    */     try
/* 215:    */     {
/* 216:187 */       int id = 0;
/* 217:188 */       DBUtil db = new DBUtil();
/* 218:189 */       if (this.idioma != null) {
/* 219:190 */         db.setIdioma(this.idioma);
/* 220:    */       }
/* 221:193 */       id = getReqMax(conn, data.getVcui_mas_cod().toString());
/* 222:194 */       data.setVcui_cod(new BigDecimal(id));
/* 223:195 */       String sql = db.creaSQLINSERT(data);
/* 224:    */       
/* 225:197 */       pstmt = conn.prepareStatement(sql);
/* 226:198 */       pstmt.executeUpdate();
/* 227:    */     }
/* 228:    */     catch (SQLException sqle)
/* 229:    */     {
/* 230:200 */       throw sqle;
/* 231:    */     }
/* 232:    */     finally
/* 233:    */     {
/* 234:202 */       close(pstmt);
/* 235:    */     }
/* 236:    */   }
/* 237:    */   
/* 238:    */   public void delete(VacunasCuidados data, Connection conn)
/* 239:    */     throws SQLException
/* 240:    */   {
/* 241:207 */     PreparedStatement pstmt = null;
/* 242:    */     try
/* 243:    */     {
/* 244:209 */       String sql = "DELETE FROM sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".vacunascuidados WHERE vcui_cod=? and vcui_mas_cod=?";
/* 245:210 */       pstmt = conn.prepareStatement(sql);
/* 246:211 */       pstmt.setBigDecimal(1, data.getVcui_cod());
/* 247:212 */       pstmt.setBigDecimal(2, data.getVcui_mas_cod());
/* 248:213 */       pstmt.executeUpdate();
/* 249:    */     }
/* 250:    */     catch (SQLException e)
/* 251:    */     {
/* 252:215 */       throw e;
/* 253:    */     }
/* 254:    */     finally
/* 255:    */     {
/* 256:217 */       close(pstmt);
/* 257:    */     }
/* 258:    */   }
/* 259:    */   
/* 260:    */   public void deleteAll(BigDecimal mas_cod, Connection conn)
/* 261:    */     throws SQLException
/* 262:    */   {
/* 263:222 */     PreparedStatement pstmt = null;
/* 264:    */     try
/* 265:    */     {
/* 266:224 */       String sql = "DELETE FROM sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".vacunascuidados WHERE vcui_mas_cod=?";
/* 267:225 */       pstmt = conn.prepareStatement(sql);
/* 268:226 */       pstmt.setBigDecimal(1, mas_cod);
/* 269:    */       
/* 270:228 */       pstmt.executeUpdate();
/* 271:    */     }
/* 272:    */     catch (SQLException e)
/* 273:    */     {
/* 274:230 */       throw e;
/* 275:    */     }
/* 276:    */     finally
/* 277:    */     {
/* 278:232 */       close(pstmt);
/* 279:    */     }
/* 280:    */   }
/* 281:    */   
/* 282:    */   private int getReqMax(Connection conn, String vcui_mas_cod)
/* 283:    */   {
/* 284:236 */     PreparedStatement pstmt = null;
/* 285:237 */     ResultSet rs = null;
/* 286:238 */     int id = 0;
/* 287:    */     try
/* 288:    */     {
/* 289:240 */       String sqlid = "Select max(vcui_cod) from sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".vacunascuidados where vcui_mas_cod = " + vcui_mas_cod;
/* 290:241 */       pstmt = conn.prepareStatement(sqlid);
/* 291:242 */       rs = pstmt.executeQuery();
/* 292:243 */       if ((rs != null) && (rs.next())) {
/* 293:244 */         id = rs.getInt(1) + 1;
/* 294:    */       } else {
/* 295:246 */         id++;
/* 296:    */       }
/* 297:    */     }
/* 298:    */     catch (SQLException e)
/* 299:    */     {
/* 300:250 */       close(rs);
/* 301:251 */       close(pstmt);
/* 302:252 */       rollback(conn);
/* 303:253 */       e.printStackTrace();
/* 304:    */     }
/* 305:    */     finally
/* 306:    */     {
/* 307:255 */       close(rs);
/* 308:256 */       close(pstmt);
/* 309:    */     }
/* 310:258 */     return id;
/* 311:    */   }
/* 312:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.VacunasCuidadosDAO
 * JD-Core Version:    0.7.0.1
 */