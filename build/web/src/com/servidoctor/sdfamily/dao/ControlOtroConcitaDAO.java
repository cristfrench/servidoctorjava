/*   1:    */ package com.servidoctor.sdfamily.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdfamily.model.ControlOtroConcita;
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
/*  16:    */ public class ControlOtroConcitaDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list(BigDecimal cootc_usuf_cod)
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 26 */     ArrayList list = new ArrayList();
/*  23: 27 */     Connection conn = null;
/*  24: 28 */     PreparedStatement pstmt = null;
/*  25: 29 */     ResultSet rs = null;
/*  26: 30 */     ControlOtroConcita controlOtroS = new ControlOtroConcita();
/*  27:    */     try
/*  28:    */     {
/*  29: 32 */       conn = this.ds.getConnection();
/*  30: 33 */       DBUtil db = new DBUtil();
/*  31: 34 */       String sql = db.creaSQLSELECT(controlOtroS);
/*  32: 35 */       String where = " where cootc_usuf_cod=" + cootc_usuf_cod;
/*  33: 36 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  34: 37 */       rs = pstmt.executeQuery();
/*  35: 38 */       while (rs.next())
/*  36:    */       {
/*  37: 39 */         ControlOtroConcita controlOtroConcita = new ControlOtroConcita();
/*  38: 40 */         InicializaData.inicializa(controlOtroConcita.getClass(), controlOtroConcita);
/*  39: 41 */         populate(controlOtroConcita, rs);
/*  40: 42 */         list.add(controlOtroConcita);
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
/*  59:    */   public void update(ControlOtroConcita data, String[] llaves)
/*  60:    */     throws SQLException
/*  61:    */   {
/*  62: 58 */     Connection conn = null;
/*  63: 59 */     PreparedStatement pstmt = null;
/*  64:    */     try
/*  65:    */     {
/*  66: 61 */       DBUtil db = new DBUtil();
/*  67: 62 */       conn = this.ds.getConnection();
/*  68: 63 */       conn.setAutoCommit(false);
/*  69: 64 */       String sql = db.creaSQLUPDATE(data, llaves);
/*  70: 65 */       pstmt = conn.prepareStatement(sql);
/*  71: 66 */       pstmt.executeUpdate();
/*  72: 67 */       close(pstmt);
/*  73: 68 */       conn.commit();
/*  74:    */     }
/*  75:    */     catch (SQLException e)
/*  76:    */     {
/*  77: 70 */       close(pstmt);
/*  78: 71 */       rollback(conn);
/*  79: 72 */       throw e;
/*  80:    */     }
/*  81:    */     finally
/*  82:    */     {
/*  83: 74 */       close(conn);
/*  84:    */     }
/*  85:    */   }
/*  86:    */   
/*  87:    */   public ControlOtroConcita retrieve(BigDecimal cootc_usuf_cod, BigDecimal cootc_cod)
/*  88:    */     throws SQLException
/*  89:    */   {
/*  90: 80 */     ControlOtroConcita controlOtroConcita = new ControlOtroConcita();
/*  91: 81 */     Connection conn = null;
/*  92: 82 */     PreparedStatement pstmt = null;
/*  93: 83 */     ResultSet rs = null;
/*  94: 84 */     ControlOtroConcita controlOtroS = new ControlOtroConcita();
/*  95:    */     try
/*  96:    */     {
/*  97: 86 */       conn = this.ds.getConnection();
/*  98: 87 */       DBUtil db = new DBUtil();
/*  99: 88 */       String sql = db.creaSQLSELECT(controlOtroS);
/* 100: 89 */       String where = " where cootc_usuf_cod = " + cootc_usuf_cod + " and cootc_cod = " + cootc_cod;
/* 101: 90 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 102: 91 */       rs = pstmt.executeQuery();
/* 103: 92 */       if (rs.next())
/* 104:    */       {
/* 105: 93 */         InicializaData.inicializa(controlOtroConcita.getClass(), controlOtroConcita);
/* 106: 94 */         populate(controlOtroConcita, rs);
/* 107:    */       }
/* 108: 96 */       close(rs);
/* 109: 97 */       close(pstmt);
/* 110:    */     }
/* 111:    */     catch (SQLException e)
/* 112:    */     {
/* 113: 99 */       close(rs);
/* 114:100 */       close(pstmt);
/* 115:101 */       rollback(conn);
/* 116:102 */       throw e;
/* 117:    */     }
/* 118:    */     finally
/* 119:    */     {
/* 120:104 */       close(conn);
/* 121:    */     }
/* 122:106 */     return controlOtroConcita;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public synchronized void insert(ControlOtroConcita data)
/* 126:    */     throws SQLException
/* 127:    */   {
/* 128:110 */     Connection conn = null;
/* 129:111 */     PreparedStatement pstmt = null;
/* 130:    */     
/* 131:113 */     ResultSet rs = null;
/* 132:    */     try
/* 133:    */     {
/* 134:115 */       int id = 0;
/* 135:116 */       DBUtil db = new DBUtil();
/* 136:    */       
/* 137:118 */       conn = this.ds.getConnection();
/* 138:119 */       conn.setAutoCommit(false);
/* 139:120 */       id = getReqMax(conn, data);
/* 140:121 */       data.setCootc_cod(new BigDecimal(id));
/* 141:122 */       String sql = db.creaSQLINSERT(data);
/* 142:123 */       pstmt = conn.prepareStatement(sql);
/* 143:124 */       pstmt.executeUpdate();
/* 144:125 */       pstmt.close();
/* 145:126 */       conn.commit();
/* 146:    */     }
/* 147:    */     catch (SQLException sqle)
/* 148:    */     {
/* 149:128 */       close(rs);
/* 150:129 */       close(pstmt);
/* 151:130 */       rollback(conn);
/* 152:131 */       throw sqle;
/* 153:    */     }
/* 154:    */     finally
/* 155:    */     {
/* 156:133 */       close(rs);
/* 157:134 */       close(pstmt);
/* 158:135 */       close(conn);
/* 159:    */     }
/* 160:    */   }
/* 161:    */   
/* 162:    */   public void delete(ControlOtroConcita data)
/* 163:    */     throws SQLException
/* 164:    */   {
/* 165:140 */     Connection conn = null;
/* 166:141 */     PreparedStatement pstmt = null;
/* 167:    */     try
/* 168:    */     {
/* 169:143 */       conn = this.ds.getConnection();
/* 170:144 */       conn.setAutoCommit(false);
/* 171:145 */       String sql = "DELETE FROM sdoctor.controlotroconcita WHERE cootc_cod = ? and cootc_usuf_cod = ?";
/* 172:146 */       pstmt = conn.prepareStatement(sql);
/* 173:147 */       pstmt.setBigDecimal(1, data.getCootc_cod());
/* 174:148 */       pstmt.setBigDecimal(2, data.getCootc_usuf_cod());
/* 175:149 */       pstmt.executeUpdate();
/* 176:150 */       close(pstmt);
/* 177:151 */       conn.commit();
/* 178:    */     }
/* 179:    */     catch (SQLException e)
/* 180:    */     {
/* 181:153 */       close(pstmt);
/* 182:154 */       rollback(conn);
/* 183:155 */       throw e;
/* 184:    */     }
/* 185:    */     finally
/* 186:    */     {
/* 187:157 */       close(conn);
/* 188:    */     }
/* 189:    */   }
/* 190:    */   
/* 191:    */   public void deleteAll(BigDecimal cootc_usuf_cod)
/* 192:    */     throws SQLException
/* 193:    */   {
/* 194:162 */     Connection conn = null;
/* 195:163 */     PreparedStatement pstmt = null;
/* 196:    */     try
/* 197:    */     {
/* 198:165 */       conn = this.ds.getConnection();
/* 199:166 */       conn.setAutoCommit(false);
/* 200:167 */       String sql = "DELETE FROM sdoctor.controlotroconcita WHERE cootc_usuf_cod=?";
/* 201:168 */       pstmt = conn.prepareStatement(sql);
/* 202:169 */       pstmt.setBigDecimal(1, cootc_usuf_cod);
/* 203:170 */       pstmt.executeUpdate();
/* 204:171 */       close(pstmt);
/* 205:172 */       conn.commit();
/* 206:    */     }
/* 207:    */     catch (SQLException e)
/* 208:    */     {
/* 209:174 */       close(pstmt);
/* 210:175 */       rollback(conn);
/* 211:176 */       throw e;
/* 212:    */     }
/* 213:    */     finally
/* 214:    */     {
/* 215:178 */       close(conn);
/* 216:    */     }
/* 217:    */   }
/* 218:    */   
/* 219:    */   private int getReqMax(Connection conn, ControlOtroConcita data)
/* 220:    */   {
/* 221:183 */     PreparedStatement pstmt = null;
/* 222:184 */     ResultSet rs = null;
/* 223:185 */     int id = 0;
/* 224:    */     try
/* 225:    */     {
/* 226:187 */       String sqlid = "Select max(cootc_cod) from sdoctor.controlotroconcita where cootc_usuf_cod = ?";
/* 227:    */       
/* 228:189 */       pstmt = conn.prepareStatement(sqlid);
/* 229:190 */       pstmt.setBigDecimal(1, data.getCootc_usuf_cod());
/* 230:191 */       rs = pstmt.executeQuery();
/* 231:192 */       if ((rs != null) && (rs.next())) {
/* 232:193 */         id = rs.getInt(1) + 1;
/* 233:    */       } else {
/* 234:195 */         id++;
/* 235:    */       }
/* 236:    */     }
/* 237:    */     catch (SQLException e)
/* 238:    */     {
/* 239:199 */       close(rs);
/* 240:200 */       close(pstmt);
/* 241:201 */       rollback(conn);
/* 242:    */     }
/* 243:    */     finally
/* 244:    */     {
/* 245:203 */       close(rs);
/* 246:204 */       close(pstmt);
/* 247:    */     }
/* 248:206 */     return id;
/* 249:    */   }
/* 250:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.dao.ControlOtroConcitaDAO
 * JD-Core Version:    0.7.0.1
 */