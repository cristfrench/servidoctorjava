/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.ExamenesLaboratorio;
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
/*  16:    */ public class ExamenesLaboratorioDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list(BigDecimal usuf_cod)
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 19 */     ArrayList list = new ArrayList();
/*  23: 20 */     Connection conn = null;
/*  24: 21 */     PreparedStatement pstmt = null;
/*  25: 22 */     ResultSet rs = null;
/*  26: 23 */     ExamenesLaboratorio examenesLaboratorioS = new ExamenesLaboratorio();
/*  27:    */     try
/*  28:    */     {
/*  29: 25 */       conn = this.ds.getConnection();
/*  30: 26 */       DBUtil db = new DBUtil();
/*  31: 27 */       String sql = db.creaSQLSELECT(examenesLaboratorioS);
/*  32: 28 */       pstmt = conn.prepareStatement(sql + " where elab_usuf_cod = " + usuf_cod);
/*  33:    */       
/*  34: 30 */       rs = pstmt.executeQuery();
/*  35: 31 */       while (rs.next())
/*  36:    */       {
/*  37: 32 */         ExamenesLaboratorio examenesLaboratorio = new ExamenesLaboratorio();
/*  38: 33 */         InicializaData.inicializa(examenesLaboratorio.getClass(), examenesLaboratorio);
/*  39: 34 */         populate(examenesLaboratorio, rs);
/*  40: 35 */         list.add(examenesLaboratorio);
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
/*  59:    */   public ExamenesLaboratorio retrive(BigDecimal elab_cod, BigDecimal elab_usuf_cod)
/*  60:    */     throws SQLException
/*  61:    */   {
/*  62: 52 */     ExamenesLaboratorio examenesLaboratorio = new ExamenesLaboratorio();
/*  63: 53 */     Connection conn = null;
/*  64: 54 */     PreparedStatement pstmt = null;
/*  65: 55 */     ResultSet rs = null;
/*  66: 56 */     ExamenesLaboratorio examenesLaboratorioS = new ExamenesLaboratorio();
/*  67:    */     try
/*  68:    */     {
/*  69: 58 */       conn = this.ds.getConnection();
/*  70: 59 */       DBUtil db = new DBUtil();
/*  71: 60 */       String sql = db.creaSQLSELECT(examenesLaboratorioS);
/*  72: 61 */       String where = " where elab_cod=" + elab_cod + " and elab_usuf_cod = " + elab_usuf_cod;
/*  73: 62 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  74: 63 */       rs = pstmt.executeQuery();
/*  75: 64 */       if (rs.next())
/*  76:    */       {
/*  77: 66 */         InicializaData.inicializa(examenesLaboratorio.getClass(), examenesLaboratorio);
/*  78: 67 */         populate(examenesLaboratorio, rs);
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
/*  94: 80 */     return examenesLaboratorio;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public void update(ExamenesLaboratorio data, String[] llaves)
/*  98:    */     throws SQLException
/*  99:    */   {
/* 100: 84 */     Connection conn = null;
/* 101: 85 */     PreparedStatement pstmt = null;
/* 102:    */     try
/* 103:    */     {
/* 104: 87 */       DBUtil db = new DBUtil();
/* 105: 88 */       conn = this.ds.getConnection();
/* 106: 89 */       conn.setAutoCommit(false);
/* 107: 90 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 108: 91 */       pstmt = conn.prepareStatement(sql);
/* 109: 92 */       pstmt.executeUpdate();
/* 110: 93 */       close(pstmt);
/* 111: 94 */       conn.commit();
/* 112:    */     }
/* 113:    */     catch (SQLException e)
/* 114:    */     {
/* 115: 96 */       close(pstmt);
/* 116: 97 */       rollback(conn);
/* 117: 98 */       throw e;
/* 118:    */     }
/* 119:    */     finally
/* 120:    */     {
/* 121:100 */       close(conn);
/* 122:    */     }
/* 123:    */   }
/* 124:    */   
/* 125:    */   public synchronized void insert(ExamenesLaboratorio data)
/* 126:    */     throws SQLException
/* 127:    */   {
/* 128:105 */     Connection conn = null;
/* 129:106 */     PreparedStatement pstmt = null;
/* 130:    */     
/* 131:108 */     ResultSet rs = null;
/* 132:    */     try
/* 133:    */     {
/* 134:110 */       int id = 0;
/* 135:111 */       DBUtil db = new DBUtil();
/* 136:    */       
/* 137:113 */       conn = this.ds.getConnection();
/* 138:114 */       conn.setAutoCommit(false);
/* 139:115 */       id = getReqMax(conn, data.getElab_usuf_cod().toString());
/* 140:116 */       data.setElab_cod(new BigDecimal(id));
/* 141:117 */       String sql = db.creaSQLINSERT(data);
/* 142:    */       
/* 143:119 */       pstmt = conn.prepareStatement(sql);
/* 144:120 */       pstmt.executeUpdate();
/* 145:121 */       pstmt.close();
/* 146:122 */       conn.commit();
/* 147:    */     }
/* 148:    */     catch (SQLException sqle)
/* 149:    */     {
/* 150:124 */       close(rs);
/* 151:125 */       close(pstmt);
/* 152:126 */       rollback(conn);
/* 153:127 */       throw sqle;
/* 154:    */     }
/* 155:    */     finally
/* 156:    */     {
/* 157:129 */       close(rs);
/* 158:130 */       close(pstmt);
/* 159:131 */       close(conn);
/* 160:    */     }
/* 161:    */   }
/* 162:    */   
/* 163:    */   public void delete(ExamenesLaboratorio data)
/* 164:    */     throws SQLException
/* 165:    */   {
/* 166:136 */     Connection conn = null;
/* 167:137 */     PreparedStatement pstmt = null;
/* 168:    */     try
/* 169:    */     {
/* 170:139 */       conn = this.ds.getConnection();
/* 171:140 */       conn.setAutoCommit(false);
/* 172:141 */       String sql = "DELETE FROM sdoctor.exameneslaboratorio WHERE elab_cod=? and elab_usuf_cod=?";
/* 173:142 */       pstmt = conn.prepareStatement(sql);
/* 174:143 */       pstmt.setBigDecimal(1, data.getElab_cod());
/* 175:144 */       pstmt.setBigDecimal(2, data.getElab_usuf_cod());
/* 176:145 */       pstmt.executeUpdate();
/* 177:146 */       close(pstmt);
/* 178:147 */       conn.commit();
/* 179:    */     }
/* 180:    */     catch (SQLException e)
/* 181:    */     {
/* 182:149 */       close(pstmt);
/* 183:150 */       rollback(conn);
/* 184:151 */       throw e;
/* 185:    */     }
/* 186:    */     finally
/* 187:    */     {
/* 188:153 */       close(conn);
/* 189:    */     }
/* 190:    */   }
/* 191:    */   
/* 192:    */   public void deleteAll(BigDecimal elab_usuf_cod)
/* 193:    */     throws SQLException
/* 194:    */   {
/* 195:158 */     Connection conn = null;
/* 196:159 */     PreparedStatement pstmt = null;
/* 197:    */     try
/* 198:    */     {
/* 199:161 */       conn = this.ds.getConnection();
/* 200:162 */       conn.setAutoCommit(false);
/* 201:163 */       String sql = "DELETE FROM sdoctor.exameneslaboratorio WHERE elab_usuf_cod=?";
/* 202:164 */       pstmt = conn.prepareStatement(sql);
/* 203:    */       
/* 204:166 */       pstmt.setBigDecimal(1, elab_usuf_cod);
/* 205:167 */       pstmt.executeUpdate();
/* 206:168 */       close(pstmt);
/* 207:169 */       conn.commit();
/* 208:    */     }
/* 209:    */     catch (SQLException e)
/* 210:    */     {
/* 211:171 */       close(pstmt);
/* 212:172 */       rollback(conn);
/* 213:173 */       throw e;
/* 214:    */     }
/* 215:    */     finally
/* 216:    */     {
/* 217:175 */       close(conn);
/* 218:    */     }
/* 219:    */   }
/* 220:    */   
/* 221:    */   private int getReqMax(Connection conn, String usuf_cod)
/* 222:    */   {
/* 223:180 */     PreparedStatement pstmt = null;
/* 224:181 */     ResultSet rs = null;
/* 225:182 */     int id = 0;
/* 226:    */     try
/* 227:    */     {
/* 228:184 */       String sqlid = "Select max(elab_cod) from sdoctor.exameneslaboratorio where elab_usuf_cod = " + usuf_cod;
/* 229:185 */       pstmt = conn.prepareStatement(sqlid);
/* 230:186 */       rs = pstmt.executeQuery();
/* 231:187 */       if ((rs != null) && (rs.next())) {
/* 232:188 */         id = rs.getInt(1) + 1;
/* 233:    */       } else {
/* 234:190 */         id++;
/* 235:    */       }
/* 236:    */     }
/* 237:    */     catch (SQLException e)
/* 238:    */     {
/* 239:194 */       close(rs);
/* 240:195 */       close(pstmt);
/* 241:196 */       rollback(conn);
/* 242:197 */       e.printStackTrace();
/* 243:    */     }
/* 244:    */     finally
/* 245:    */     {
/* 246:199 */       close(rs);
/* 247:200 */       close(pstmt);
/* 248:    */     }
/* 249:202 */     return id;
/* 250:    */   }
/* 251:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.ExamenesLaboratorioDAO
 * JD-Core Version:    0.7.0.1
 */