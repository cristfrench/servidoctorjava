/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.ResultadoExamen;
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
/*  16:    */ public class ResultadoExamenDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list()
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 19 */     ArrayList list = new ArrayList();
/*  23: 20 */     Connection conn = null;
/*  24: 21 */     PreparedStatement pstmt = null;
/*  25: 22 */     ResultSet rs = null;
/*  26: 23 */     ResultadoExamen resultadoExamenS = new ResultadoExamen();
/*  27:    */     try
/*  28:    */     {
/*  29: 25 */       conn = this.ds.getConnection();
/*  30: 26 */       DBUtil db = new DBUtil();
/*  31: 27 */       String sql = db.creaSQLSELECT(resultadoExamenS);
/*  32: 28 */       pstmt = conn.prepareStatement(sql);
/*  33:    */       
/*  34: 30 */       rs = pstmt.executeQuery();
/*  35: 31 */       while (rs.next())
/*  36:    */       {
/*  37: 32 */         ResultadoExamen resultadoExamen = new ResultadoExamen();
/*  38: 33 */         InicializaData.inicializa(resultadoExamen.getClass(), resultadoExamen);
/*  39: 34 */         populate(resultadoExamen, rs);
/*  40: 35 */         list.add(resultadoExamen);
/*  41:    */       }
/*  42: 37 */       close(rs);
/*  43: 38 */       close(pstmt);
/*  44:    */     }
/*  45:    */     catch (SQLException e)
/*  46:    */     {
/*  47: 40 */       close(rs);
/*  48: 41 */       close(pstmt);
/*  49: 42 */       rollback(conn);
/*  50: 43 */       throw e;
/*  51:    */     }
/*  52:    */     finally
/*  53:    */     {
/*  54: 45 */       close(conn);
/*  55:    */     }
/*  56: 47 */     return list;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public ResultadoExamen retrive(BigDecimal rexa_cod)
/*  60:    */     throws SQLException
/*  61:    */   {
/*  62: 52 */     ResultadoExamen resultadoExamen = new ResultadoExamen();
/*  63: 53 */     Connection conn = null;
/*  64: 54 */     PreparedStatement pstmt = null;
/*  65: 55 */     ResultSet rs = null;
/*  66: 56 */     ResultadoExamen resultadoExamenS = new ResultadoExamen();
/*  67:    */     try
/*  68:    */     {
/*  69: 58 */       conn = this.ds.getConnection();
/*  70: 59 */       DBUtil db = new DBUtil();
/*  71: 60 */       String sql = db.creaSQLSELECT(resultadoExamenS);
/*  72: 61 */       String where = " where rexa_cod=" + rexa_cod;
/*  73: 62 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  74: 63 */       rs = pstmt.executeQuery();
/*  75: 64 */       if (rs.next())
/*  76:    */       {
/*  77: 66 */         InicializaData.inicializa(resultadoExamen.getClass(), resultadoExamen);
/*  78: 67 */         populate(resultadoExamen, rs);
/*  79:    */       }
/*  80: 70 */       close(rs);
/*  81: 71 */       close(pstmt);
/*  82:    */     }
/*  83:    */     catch (SQLException e)
/*  84:    */     {
/*  85: 73 */       close(rs);
/*  86: 74 */       close(pstmt);
/*  87: 75 */       rollback(conn);
/*  88: 76 */       throw e;
/*  89:    */     }
/*  90:    */     finally
/*  91:    */     {
/*  92: 78 */       close(conn);
/*  93:    */     }
/*  94: 80 */     return resultadoExamen;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public ResultadoExamen retriveClasificacion(BigDecimal rexa_elab_cod, BigDecimal rexa_resultado)
/*  98:    */     throws SQLException
/*  99:    */   {
/* 100: 85 */     ResultadoExamen resultadoExamen = new ResultadoExamen();
/* 101: 86 */     Connection conn = null;
/* 102: 87 */     PreparedStatement pstmt = null;
/* 103: 88 */     ResultSet rs = null;
/* 104: 89 */     ResultadoExamen resultadoExamenS = new ResultadoExamen();
/* 105:    */     try
/* 106:    */     {
/* 107: 91 */       conn = this.ds.getConnection();
/* 108: 92 */       DBUtil db = new DBUtil();
/* 109: 93 */       String sql = db.creaSQLSELECT(resultadoExamenS);
/* 110: 94 */       String where = " where rexa_elab_cod=" + rexa_elab_cod + " and rexa_desde <= " + rexa_resultado + " and rexa_hasta >= " + rexa_resultado;
/* 111: 95 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 112: 96 */       rs = pstmt.executeQuery();
/* 113: 97 */       if (rs.next())
/* 114:    */       {
/* 115: 99 */         InicializaData.inicializa(resultadoExamen.getClass(), resultadoExamen);
/* 116:100 */         populate(resultadoExamen, rs);
/* 117:    */       }
/* 118:103 */       close(rs);
/* 119:104 */       close(pstmt);
/* 120:    */     }
/* 121:    */     catch (SQLException e)
/* 122:    */     {
/* 123:106 */       close(rs);
/* 124:107 */       close(pstmt);
/* 125:108 */       rollback(conn);
/* 126:109 */       throw e;
/* 127:    */     }
/* 128:    */     finally
/* 129:    */     {
/* 130:111 */       close(conn);
/* 131:    */     }
/* 132:113 */     return resultadoExamen;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public void update(ResultadoExamen data, String[] llaves)
/* 136:    */     throws SQLException
/* 137:    */   {
/* 138:117 */     Connection conn = null;
/* 139:118 */     PreparedStatement pstmt = null;
/* 140:    */     try
/* 141:    */     {
/* 142:120 */       DBUtil db = new DBUtil();
/* 143:121 */       conn = this.ds.getConnection();
/* 144:122 */       conn.setAutoCommit(false);
/* 145:123 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 146:124 */       pstmt = conn.prepareStatement(sql);
/* 147:125 */       pstmt.executeUpdate();
/* 148:126 */       close(pstmt);
/* 149:127 */       conn.commit();
/* 150:    */     }
/* 151:    */     catch (SQLException e)
/* 152:    */     {
/* 153:129 */       close(pstmt);
/* 154:130 */       rollback(conn);
/* 155:131 */       throw e;
/* 156:    */     }
/* 157:    */     finally
/* 158:    */     {
/* 159:133 */       close(conn);
/* 160:    */     }
/* 161:    */   }
/* 162:    */   
/* 163:    */   public synchronized void insert(ResultadoExamen data)
/* 164:    */     throws SQLException
/* 165:    */   {
/* 166:138 */     Connection conn = null;
/* 167:139 */     PreparedStatement pstmt = null;
/* 168:    */     
/* 169:141 */     ResultSet rs = null;
/* 170:    */     try
/* 171:    */     {
/* 172:143 */       int id = 0;
/* 173:144 */       DBUtil db = new DBUtil();
/* 174:    */       
/* 175:146 */       conn = this.ds.getConnection();
/* 176:147 */       conn.setAutoCommit(false);
/* 177:148 */       id = getReqMax(conn);
/* 178:149 */       data.setRexa_cod(new BigDecimal(id));
/* 179:150 */       String sql = db.creaSQLINSERT(data);
/* 180:    */       
/* 181:152 */       pstmt = conn.prepareStatement(sql);
/* 182:153 */       pstmt.executeUpdate();
/* 183:154 */       pstmt.close();
/* 184:155 */       conn.commit();
/* 185:    */     }
/* 186:    */     catch (SQLException sqle)
/* 187:    */     {
/* 188:157 */       close(rs);
/* 189:158 */       close(pstmt);
/* 190:159 */       rollback(conn);
/* 191:160 */       throw sqle;
/* 192:    */     }
/* 193:    */     finally
/* 194:    */     {
/* 195:162 */       close(rs);
/* 196:163 */       close(pstmt);
/* 197:164 */       close(conn);
/* 198:    */     }
/* 199:    */   }
/* 200:    */   
/* 201:    */   public void delete(ResultadoExamen data)
/* 202:    */     throws SQLException
/* 203:    */   {
/* 204:169 */     Connection conn = null;
/* 205:170 */     PreparedStatement pstmt = null;
/* 206:    */     try
/* 207:    */     {
/* 208:172 */       conn = this.ds.getConnection();
/* 209:173 */       conn.setAutoCommit(false);
/* 210:174 */       String sql = "DELETE FROM sdoctor.resultadoexamen WHERE rexa_cod=?";
/* 211:175 */       pstmt = conn.prepareStatement(sql);
/* 212:176 */       pstmt.setBigDecimal(1, data.getRexa_cod());
/* 213:177 */       pstmt.executeUpdate();
/* 214:178 */       close(pstmt);
/* 215:179 */       conn.commit();
/* 216:    */     }
/* 217:    */     catch (SQLException e)
/* 218:    */     {
/* 219:181 */       close(pstmt);
/* 220:182 */       rollback(conn);
/* 221:183 */       throw e;
/* 222:    */     }
/* 223:    */     finally
/* 224:    */     {
/* 225:185 */       close(conn);
/* 226:    */     }
/* 227:    */   }
/* 228:    */   
/* 229:    */   private int getReqMax(Connection conn)
/* 230:    */   {
/* 231:190 */     PreparedStatement pstmt = null;
/* 232:191 */     ResultSet rs = null;
/* 233:192 */     int id = 0;
/* 234:    */     try
/* 235:    */     {
/* 236:194 */       String sqlid = "Select max(rexa_cod) from sdoctor.resultadoexamen ";
/* 237:195 */       pstmt = conn.prepareStatement(sqlid);
/* 238:196 */       rs = pstmt.executeQuery();
/* 239:197 */       if ((rs != null) && (rs.next())) {
/* 240:198 */         id = rs.getInt(1) + 1;
/* 241:    */       } else {
/* 242:200 */         id++;
/* 243:    */       }
/* 244:    */     }
/* 245:    */     catch (SQLException e)
/* 246:    */     {
/* 247:204 */       close(rs);
/* 248:205 */       close(pstmt);
/* 249:206 */       rollback(conn);
/* 250:207 */       e.printStackTrace();
/* 251:    */     }
/* 252:    */     finally
/* 253:    */     {
/* 254:209 */       close(rs);
/* 255:210 */       close(pstmt);
/* 256:    */     }
/* 257:212 */     return id;
/* 258:    */   }
/* 259:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.ResultadoExamenDAO
 * JD-Core Version:    0.7.0.1
 */