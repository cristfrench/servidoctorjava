/*   1:    */ package com.servidoctor.sdfamily.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdfamily.model.ControlOdontologia;
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
/*  16:    */ public class ControlOdontologiaDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list(BigDecimal codo_usuf_cod)
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 26 */     ArrayList list = new ArrayList();
/*  23: 27 */     Connection conn = null;
/*  24: 28 */     PreparedStatement pstmt = null;
/*  25: 29 */     ResultSet rs = null;
/*  26: 30 */     ControlOdontologia controlOdontologiaS = new ControlOdontologia();
/*  27:    */     try
/*  28:    */     {
/*  29: 32 */       conn = this.ds.getConnection();
/*  30: 33 */       DBUtil db = new DBUtil();
/*  31: 34 */       String sql = db.creaSQLSELECT(controlOdontologiaS);
/*  32: 35 */       String where = " where codo_usuf_cod=" + codo_usuf_cod;
/*  33: 36 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  34: 37 */       rs = pstmt.executeQuery();
/*  35: 38 */       while (rs.next())
/*  36:    */       {
/*  37: 39 */         ControlOdontologia controlOdontologia = new ControlOdontologia();
/*  38: 40 */         InicializaData.inicializa(controlOdontologia.getClass(), controlOdontologia);
/*  39: 41 */         populate(controlOdontologia, rs);
/*  40: 42 */         list.add(controlOdontologia);
/*  41:    */       }
/*  42: 44 */       close(rs);
/*  43: 45 */       close(pstmt);
/*  44:    */     }
/*  45:    */     catch (SQLException e)
/*  46:    */     {
/*  47: 47 */       close(rs);
/*  48: 48 */       close(pstmt);
/*  49: 49 */       rollback(conn);
/*  50: 50 */       throw e;
/*  51:    */     }
/*  52:    */     finally
/*  53:    */     {
/*  54: 52 */       close(conn);
/*  55:    */     }
/*  56: 54 */     return list;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public List list(BigDecimal codo_usuf_cod, BigDecimal codo_tipo)
/*  60:    */     throws SQLException
/*  61:    */   {
/*  62: 58 */     ArrayList list = list = new ArrayList();
/*  63: 59 */     Connection conn = null;
/*  64: 60 */     PreparedStatement pstmt = null;
/*  65: 61 */     ResultSet rs = null;
/*  66: 62 */     ControlOdontologia controlOdontologiaS = new ControlOdontologia();
/*  67:    */     try
/*  68:    */     {
/*  69: 64 */       conn = this.ds.getConnection();
/*  70: 65 */       DBUtil db = new DBUtil();
/*  71: 66 */       String sql = db.creaSQLSELECT(controlOdontologiaS);
/*  72: 67 */       String where = " where codo_usuf_cod = " + codo_usuf_cod + " AND codo_tipo = " + codo_tipo + " order by codo_cod";
/*  73: 68 */       pstmt = conn.prepareStatement(sql + where);
/*  74: 69 */       rs = pstmt.executeQuery();
/*  75: 70 */       while (rs.next())
/*  76:    */       {
/*  77: 71 */         ControlOdontologia controlOdontologia = new ControlOdontologia();
/*  78: 72 */         InicializaData.inicializa(controlOdontologia.getClass(), controlOdontologia);
/*  79: 73 */         populate(controlOdontologia, rs);
/*  80: 74 */         list.add(controlOdontologia);
/*  81:    */       }
/*  82: 76 */       close(rs);
/*  83: 77 */       close(pstmt);
/*  84:    */     }
/*  85:    */     catch (SQLException e)
/*  86:    */     {
/*  87: 79 */       close(rs);
/*  88: 80 */       close(pstmt);
/*  89: 81 */       rollback(conn);
/*  90: 82 */       throw e;
/*  91:    */     }
/*  92:    */     finally
/*  93:    */     {
/*  94: 84 */       close(conn);
/*  95:    */     }
/*  96: 86 */     return list;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public void update(ControlOdontologia data, String[] llaves, Connection conn)
/* 100:    */     throws SQLException
/* 101:    */   {
/* 102: 90 */     PreparedStatement pstmt = null;
/* 103:    */     try
/* 104:    */     {
/* 105: 92 */       DBUtil db = new DBUtil();
/* 106: 93 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 107: 94 */       pstmt = conn.prepareStatement(sql);
/* 108: 95 */       pstmt.executeUpdate();
/* 109:    */     }
/* 110:    */     catch (SQLException e)
/* 111:    */     {
/* 112: 97 */       throw e;
/* 113:    */     }
/* 114:    */     finally
/* 115:    */     {
/* 116: 99 */       close(pstmt);
/* 117:    */     }
/* 118:    */   }
/* 119:    */   
/* 120:    */   public ControlOdontologia retrieve(BigDecimal codo_usuf_cod, BigDecimal codo_cod)
/* 121:    */     throws SQLException
/* 122:    */   {
/* 123:105 */     ControlOdontologia controlOdontologia = new ControlOdontologia();
/* 124:106 */     Connection conn = null;
/* 125:107 */     PreparedStatement pstmt = null;
/* 126:108 */     ResultSet rs = null;
/* 127:109 */     ControlOdontologia controlOdontologiaS = new ControlOdontologia();
/* 128:    */     try
/* 129:    */     {
/* 130:111 */       conn = this.ds.getConnection();
/* 131:112 */       DBUtil db = new DBUtil();
/* 132:113 */       String sql = db.creaSQLSELECT(controlOdontologiaS);
/* 133:114 */       String where = " where codo_usuf_cod = " + codo_usuf_cod + " and codo_cod = " + codo_cod + " order by codo_cod";
/* 134:115 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 135:116 */       rs = pstmt.executeQuery();
/* 136:117 */       if (rs.next())
/* 137:    */       {
/* 138:118 */         InicializaData.inicializa(controlOdontologia.getClass(), controlOdontologia);
/* 139:119 */         populate(controlOdontologia, rs);
/* 140:    */       }
/* 141:121 */       close(rs);
/* 142:122 */       close(pstmt);
/* 143:    */     }
/* 144:    */     catch (SQLException e)
/* 145:    */     {
/* 146:124 */       close(rs);
/* 147:125 */       close(pstmt);
/* 148:126 */       rollback(conn);
/* 149:127 */       throw e;
/* 150:    */     }
/* 151:    */     finally
/* 152:    */     {
/* 153:129 */       close(conn);
/* 154:    */     }
/* 155:131 */     return controlOdontologia;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public synchronized void insert(ControlOdontologia data, Connection conn)
/* 159:    */     throws SQLException
/* 160:    */   {
/* 161:135 */     PreparedStatement pstmt = null;
/* 162:    */     try
/* 163:    */     {
/* 164:137 */       int id = 0;
/* 165:138 */       DBUtil db = new DBUtil();
/* 166:    */       
/* 167:140 */       String sql = db.creaSQLINSERT(data);
/* 168:141 */       pstmt = conn.prepareStatement(sql);
/* 169:142 */       pstmt.executeUpdate();
/* 170:    */     }
/* 171:    */     catch (SQLException sqle)
/* 172:    */     {
/* 173:144 */       throw sqle;
/* 174:    */     }
/* 175:    */     finally
/* 176:    */     {
/* 177:146 */       close(pstmt);
/* 178:    */     }
/* 179:    */   }
/* 180:    */   
/* 181:    */   public void delete(ControlOdontologia data, Connection conn)
/* 182:    */     throws SQLException
/* 183:    */   {
/* 184:151 */     PreparedStatement pstmt = null;
/* 185:    */     try
/* 186:    */     {
/* 187:153 */       String sql = "DELETE FROM sdoctor.controlodontologia WHERE codo_cod = ? and codo_usuf_cod = ?";
/* 188:154 */       pstmt = conn.prepareStatement(sql);
/* 189:155 */       pstmt.setBigDecimal(1, data.getCodo_cod());
/* 190:156 */       pstmt.setBigDecimal(2, data.getCodo_usuf_cod());
/* 191:157 */       pstmt.executeUpdate();
/* 192:    */     }
/* 193:    */     catch (SQLException e)
/* 194:    */     {
/* 195:159 */       throw e;
/* 196:    */     }
/* 197:    */     finally
/* 198:    */     {
/* 199:161 */       close(pstmt);
/* 200:    */     }
/* 201:    */   }
/* 202:    */   
/* 203:    */   public void deleteAll(BigDecimal codo_usuf_cod, Connection conn)
/* 204:    */     throws SQLException
/* 205:    */   {
/* 206:166 */     PreparedStatement pstmt = null;
/* 207:    */     try
/* 208:    */     {
/* 209:168 */       String sql = "DELETE FROM sdoctor.controlodontologia WHERE codo_usuf_cod=?";
/* 210:169 */       pstmt = conn.prepareStatement(sql);
/* 211:170 */       pstmt.setBigDecimal(1, codo_usuf_cod);
/* 212:171 */       pstmt.executeUpdate();
/* 213:    */     }
/* 214:    */     catch (SQLException e)
/* 215:    */     {
/* 216:173 */       throw e;
/* 217:    */     }
/* 218:    */     finally
/* 219:    */     {
/* 220:175 */       close(pstmt);
/* 221:    */     }
/* 222:    */   }
/* 223:    */   
/* 224:    */   private int getReqMax(Connection conn, ControlOdontologia data)
/* 225:    */     throws SQLException
/* 226:    */   {
/* 227:180 */     PreparedStatement pstmt = null;
/* 228:181 */     ResultSet rs = null;
/* 229:182 */     int id = 0;
/* 230:    */     try
/* 231:    */     {
/* 232:184 */       String sqlid = "Select max(codo_cod) from sdoctor.controlodontologia where codo_usuf_cod = ?";
/* 233:    */       
/* 234:186 */       pstmt = conn.prepareStatement(sqlid);
/* 235:187 */       pstmt.setBigDecimal(1, data.getCodo_usuf_cod());
/* 236:188 */       rs = pstmt.executeQuery();
/* 237:189 */       if ((rs != null) && (rs.next())) {
/* 238:190 */         id = rs.getInt(1) + 1;
/* 239:    */       } else {
/* 240:192 */         id++;
/* 241:    */       }
/* 242:    */     }
/* 243:    */     catch (SQLException e)
/* 244:    */     {
/* 245:196 */       throw e;
/* 246:    */     }
/* 247:    */     finally
/* 248:    */     {
/* 249:198 */       close(rs);
/* 250:199 */       close(pstmt);
/* 251:    */     }
/* 252:201 */     return id;
/* 253:    */   }
/* 254:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.dao.ControlOdontologiaDAO
 * JD-Core Version:    0.7.0.1
 */