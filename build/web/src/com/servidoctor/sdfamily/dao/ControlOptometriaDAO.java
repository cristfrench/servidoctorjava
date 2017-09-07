/*   1:    */ package com.servidoctor.sdfamily.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdfamily.model.ControlOptometria;
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
/*  16:    */ public class ControlOptometriaDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list(BigDecimal copt_usuf_cod)
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 26 */     ArrayList list = new ArrayList();
/*  23: 27 */     Connection conn = null;
/*  24: 28 */     PreparedStatement pstmt = null;
/*  25: 29 */     ResultSet rs = null;
/*  26: 30 */     ControlOptometria controlOptometriaS = new ControlOptometria();
/*  27:    */     try
/*  28:    */     {
/*  29: 32 */       conn = this.ds.getConnection();
/*  30: 33 */       DBUtil db = new DBUtil();
/*  31: 34 */       String sql = db.creaSQLSELECT(controlOptometriaS);
/*  32: 35 */       String where = " where copt_usuf_cod=" + copt_usuf_cod;
/*  33: 36 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  34: 37 */       rs = pstmt.executeQuery();
/*  35: 38 */       while (rs.next())
/*  36:    */       {
/*  37: 39 */         ControlOptometria controlOptometria = new ControlOptometria();
/*  38: 40 */         InicializaData.inicializa(controlOptometria.getClass(), controlOptometria);
/*  39: 41 */         populate(controlOptometria, rs);
/*  40: 42 */         list.add(controlOptometria);
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
/*  59:    */   public List list(BigDecimal copt_usuf_cod, BigDecimal copt_tipo)
/*  60:    */     throws SQLException
/*  61:    */   {
/*  62: 58 */     ArrayList list = list = new ArrayList();
/*  63: 59 */     Connection conn = null;
/*  64: 60 */     PreparedStatement pstmt = null;
/*  65: 61 */     ResultSet rs = null;
/*  66: 62 */     ControlOptometria controlOptometriaS = new ControlOptometria();
/*  67:    */     try
/*  68:    */     {
/*  69: 64 */       conn = this.ds.getConnection();
/*  70: 65 */       DBUtil db = new DBUtil();
/*  71: 66 */       String sql = db.creaSQLSELECT(controlOptometriaS);
/*  72: 67 */       String where = " where copt_usuf_cod = " + copt_usuf_cod + " AND copt_tipo = " + copt_tipo;
/*  73: 68 */       pstmt = conn.prepareStatement(sql + where);
/*  74: 69 */       rs = pstmt.executeQuery();
/*  75: 70 */       while (rs.next())
/*  76:    */       {
/*  77: 71 */         ControlOptometria controlOptometria = new ControlOptometria();
/*  78: 72 */         InicializaData.inicializa(controlOptometria.getClass(), controlOptometria);
/*  79: 73 */         populate(controlOptometria, rs);
/*  80: 74 */         list.add(controlOptometria);
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
/*  99:    */   public void update(ControlOptometria data, String[] llaves, Connection conn)
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
/* 120:    */   public ControlOptometria retrieve(BigDecimal copt_usuf_cod, BigDecimal copt_cod)
/* 121:    */     throws SQLException
/* 122:    */   {
/* 123:105 */     ControlOptometria controlOptometria = new ControlOptometria();
/* 124:106 */     Connection conn = null;
/* 125:107 */     PreparedStatement pstmt = null;
/* 126:108 */     ResultSet rs = null;
/* 127:109 */     ControlOptometria controlOptometriaS = new ControlOptometria();
/* 128:    */     try
/* 129:    */     {
/* 130:111 */       conn = this.ds.getConnection();
/* 131:112 */       DBUtil db = new DBUtil();
/* 132:113 */       String sql = db.creaSQLSELECT(controlOptometriaS);
/* 133:114 */       String where = " where copt_usuf_cod = " + copt_usuf_cod + " and copt_cod = " + copt_cod;
/* 134:115 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 135:116 */       rs = pstmt.executeQuery();
/* 136:117 */       if (rs.next())
/* 137:    */       {
/* 138:118 */         InicializaData.inicializa(controlOptometria.getClass(), controlOptometria);
/* 139:119 */         populate(controlOptometria, rs);
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
/* 155:131 */     return controlOptometria;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public synchronized void insert(ControlOptometria data, Connection conn)
/* 159:    */     throws SQLException
/* 160:    */   {
/* 161:135 */     PreparedStatement pstmt = null;
/* 162:    */     try
/* 163:    */     {
/* 164:137 */       int id = 0;
/* 165:138 */       DBUtil db = new DBUtil();
/* 166:    */       
/* 167:140 */       id = getReqMax(conn, data);
/* 168:141 */       data.setCopt_cod(new BigDecimal(id));
/* 169:142 */       String sql = db.creaSQLINSERT(data);
/* 170:143 */       pstmt = conn.prepareStatement(sql);
/* 171:144 */       pstmt.executeUpdate();
/* 172:    */     }
/* 173:    */     catch (SQLException sqle)
/* 174:    */     {
/* 175:146 */       throw sqle;
/* 176:    */     }
/* 177:    */     finally
/* 178:    */     {
/* 179:148 */       close(pstmt);
/* 180:    */     }
/* 181:    */   }
/* 182:    */   
/* 183:    */   public void delete(ControlOptometria data, Connection conn)
/* 184:    */     throws SQLException
/* 185:    */   {
/* 186:153 */     PreparedStatement pstmt = null;
/* 187:    */     try
/* 188:    */     {
/* 189:155 */       String sql = "DELETE FROM sdoctor.controloptometria WHERE copt_cod = ? and copt_usuf_cod = ?";
/* 190:156 */       pstmt = conn.prepareStatement(sql);
/* 191:157 */       pstmt.setBigDecimal(1, data.getCopt_cod());
/* 192:158 */       pstmt.setBigDecimal(2, data.getCopt_usuf_cod());
/* 193:159 */       pstmt.executeUpdate();
/* 194:    */     }
/* 195:    */     catch (SQLException e)
/* 196:    */     {
/* 197:161 */       throw e;
/* 198:    */     }
/* 199:    */     finally
/* 200:    */     {
/* 201:163 */       close(pstmt);
/* 202:    */     }
/* 203:    */   }
/* 204:    */   
/* 205:    */   public void deleteAll(BigDecimal copt_usuf_cod, Connection conn)
/* 206:    */     throws SQLException
/* 207:    */   {
/* 208:168 */     PreparedStatement pstmt = null;
/* 209:    */     try
/* 210:    */     {
/* 211:170 */       String sql = "DELETE FROM sdoctor.controloptometria WHERE copt_usuf_cod=?";
/* 212:171 */       pstmt = conn.prepareStatement(sql);
/* 213:172 */       pstmt.setBigDecimal(1, copt_usuf_cod);
/* 214:173 */       pstmt.executeUpdate();
/* 215:    */     }
/* 216:    */     catch (SQLException e)
/* 217:    */     {
/* 218:175 */       throw e;
/* 219:    */     }
/* 220:    */     finally
/* 221:    */     {
/* 222:177 */       close(pstmt);
/* 223:    */     }
/* 224:    */   }
/* 225:    */   
/* 226:    */   private int getReqMax(Connection conn, ControlOptometria data)
/* 227:    */     throws SQLException
/* 228:    */   {
/* 229:182 */     PreparedStatement pstmt = null;
/* 230:183 */     ResultSet rs = null;
/* 231:184 */     int id = 0;
/* 232:    */     try
/* 233:    */     {
/* 234:186 */       String sqlid = "Select max(copt_cod) from sdoctor.controloptometria where copt_usuf_cod = ?";
/* 235:    */       
/* 236:188 */       pstmt = conn.prepareStatement(sqlid);
/* 237:189 */       pstmt.setBigDecimal(1, data.getCopt_usuf_cod());
/* 238:190 */       rs = pstmt.executeQuery();
/* 239:191 */       if ((rs != null) && (rs.next())) {
/* 240:192 */         id = rs.getInt(1) + 1;
/* 241:    */       } else {
/* 242:194 */         id++;
/* 243:    */       }
/* 244:    */     }
/* 245:    */     catch (SQLException e)
/* 246:    */     {
/* 247:198 */       throw e;
/* 248:    */     }
/* 249:    */     finally
/* 250:    */     {
/* 251:200 */       close(rs);
/* 252:201 */       close(pstmt);
/* 253:    */     }
/* 254:203 */     return id;
/* 255:    */   }
/* 256:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.dao.ControlOptometriaDAO
 * JD-Core Version:    0.7.0.1
 */