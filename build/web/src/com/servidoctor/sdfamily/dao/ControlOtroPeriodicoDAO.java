/*   1:    */ package com.servidoctor.sdfamily.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdfamily.model.ControlOtroPeriodico;
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
/*  16:    */ public class ControlOtroPeriodicoDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list(BigDecimal coot_usuf_cod)
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 25 */     ArrayList list = new ArrayList();
/*  23: 26 */     Connection conn = null;
/*  24: 27 */     PreparedStatement pstmt = null;
/*  25: 28 */     ResultSet rs = null;
/*  26: 29 */     ControlOtroPeriodico controlOtroS = new ControlOtroPeriodico();
/*  27:    */     try
/*  28:    */     {
/*  29: 31 */       conn = this.ds.getConnection();
/*  30: 32 */       DBUtil db = new DBUtil();
/*  31: 33 */       String sql = db.creaSQLSELECT(controlOtroS);
/*  32: 34 */       String where = " where coot_usuf_cod=" + coot_usuf_cod;
/*  33: 35 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  34: 36 */       rs = pstmt.executeQuery();
/*  35: 37 */       while (rs.next())
/*  36:    */       {
/*  37: 38 */         ControlOtroPeriodico controlOtroPeriodico = new ControlOtroPeriodico();
/*  38: 39 */         InicializaData.inicializa(controlOtroPeriodico.getClass(), controlOtroPeriodico);
/*  39: 40 */         populate(controlOtroPeriodico, rs);
/*  40: 41 */         list.add(controlOtroPeriodico);
/*  41:    */       }
/*  42: 43 */       close(rs);
/*  43: 44 */       close(pstmt);
/*  44:    */     }
/*  45:    */     catch (SQLException e)
/*  46:    */     {
/*  47: 46 */       close(rs);
/*  48: 47 */       close(pstmt);
/*  49: 48 */       rollback(conn);
/*  50: 49 */       throw e;
/*  51:    */     }
/*  52:    */     finally
/*  53:    */     {
/*  54: 51 */       close(conn);
/*  55:    */     }
/*  56: 53 */     return list;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public void update(ControlOtroPeriodico data, String[] llaves)
/*  60:    */     throws SQLException
/*  61:    */   {
/*  62: 57 */     Connection conn = null;
/*  63: 58 */     PreparedStatement pstmt = null;
/*  64:    */     try
/*  65:    */     {
/*  66: 60 */       DBUtil db = new DBUtil();
/*  67: 61 */       conn = this.ds.getConnection();
/*  68: 62 */       conn.setAutoCommit(false);
/*  69: 63 */       String sql = db.creaSQLUPDATE(data, llaves);
/*  70: 64 */       pstmt = conn.prepareStatement(sql);
/*  71: 65 */       pstmt.executeUpdate();
/*  72: 66 */       close(pstmt);
/*  73: 67 */       conn.commit();
/*  74:    */     }
/*  75:    */     catch (SQLException e)
/*  76:    */     {
/*  77: 69 */       close(pstmt);
/*  78: 70 */       rollback(conn);
/*  79: 71 */       throw e;
/*  80:    */     }
/*  81:    */     finally
/*  82:    */     {
/*  83: 73 */       close(conn);
/*  84:    */     }
/*  85:    */   }
/*  86:    */   
/*  87:    */   public ControlOtroPeriodico retrieve(BigDecimal coot_usuf_cod, BigDecimal coot_cod)
/*  88:    */     throws SQLException
/*  89:    */   {
/*  90: 79 */     ControlOtroPeriodico controlOtroPeriodico = new ControlOtroPeriodico();
/*  91: 80 */     Connection conn = null;
/*  92: 81 */     PreparedStatement pstmt = null;
/*  93: 82 */     ResultSet rs = null;
/*  94: 83 */     ControlOtroPeriodico controlOtroS = new ControlOtroPeriodico();
/*  95:    */     try
/*  96:    */     {
/*  97: 85 */       conn = this.ds.getConnection();
/*  98: 86 */       DBUtil db = new DBUtil();
/*  99: 87 */       String sql = db.creaSQLSELECT(controlOtroS);
/* 100: 88 */       String where = " where coot_usuf_cod = " + coot_usuf_cod + " and coot_cod = " + coot_cod;
/* 101: 89 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 102: 90 */       rs = pstmt.executeQuery();
/* 103: 91 */       if (rs.next())
/* 104:    */       {
/* 105: 92 */         InicializaData.inicializa(controlOtroPeriodico.getClass(), controlOtroPeriodico);
/* 106: 93 */         populate(controlOtroPeriodico, rs);
/* 107:    */       }
/* 108: 95 */       close(rs);
/* 109: 96 */       close(pstmt);
/* 110:    */     }
/* 111:    */     catch (SQLException e)
/* 112:    */     {
/* 113: 98 */       close(rs);
/* 114: 99 */       close(pstmt);
/* 115:100 */       rollback(conn);
/* 116:101 */       throw e;
/* 117:    */     }
/* 118:    */     finally
/* 119:    */     {
/* 120:103 */       close(conn);
/* 121:    */     }
/* 122:105 */     return controlOtroPeriodico;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public synchronized void insert(ControlOtroPeriodico data)
/* 126:    */     throws SQLException
/* 127:    */   {
/* 128:109 */     Connection conn = null;
/* 129:110 */     PreparedStatement pstmt = null;
/* 130:    */     
/* 131:112 */     ResultSet rs = null;
/* 132:    */     try
/* 133:    */     {
/* 134:114 */       int id = 0;
/* 135:115 */       DBUtil db = new DBUtil();
/* 136:    */       
/* 137:117 */       conn = this.ds.getConnection();
/* 138:118 */       conn.setAutoCommit(false);
/* 139:119 */       id = getReqMax(conn, data);
/* 140:120 */       data.setCoot_cod(new BigDecimal(id));
/* 141:121 */       String sql = db.creaSQLINSERT(data);
/* 142:122 */       pstmt = conn.prepareStatement(sql);
/* 143:123 */       pstmt.executeUpdate();
/* 144:124 */       pstmt.close();
/* 145:125 */       conn.commit();
/* 146:    */     }
/* 147:    */     catch (SQLException sqle)
/* 148:    */     {
/* 149:127 */       close(rs);
/* 150:128 */       close(pstmt);
/* 151:129 */       rollback(conn);
/* 152:130 */       throw sqle;
/* 153:    */     }
/* 154:    */     finally
/* 155:    */     {
/* 156:132 */       close(rs);
/* 157:133 */       close(pstmt);
/* 158:134 */       close(conn);
/* 159:    */     }
/* 160:    */   }
/* 161:    */   
/* 162:    */   public void delete(ControlOtroPeriodico data)
/* 163:    */     throws SQLException
/* 164:    */   {
/* 165:139 */     Connection conn = null;
/* 166:140 */     PreparedStatement pstmt = null;
/* 167:    */     try
/* 168:    */     {
/* 169:142 */       conn = this.ds.getConnection();
/* 170:143 */       conn.setAutoCommit(false);
/* 171:144 */       String sql = "DELETE FROM sdoctor.controlotroperiodico WHERE coot_cod = ? and coot_usuf_cod = ?";
/* 172:145 */       pstmt = conn.prepareStatement(sql);
/* 173:146 */       pstmt.setBigDecimal(1, data.getCoot_cod());
/* 174:147 */       pstmt.setBigDecimal(2, data.getCoot_usuf_cod());
/* 175:148 */       pstmt.executeUpdate();
/* 176:149 */       close(pstmt);
/* 177:150 */       conn.commit();
/* 178:    */     }
/* 179:    */     catch (SQLException e)
/* 180:    */     {
/* 181:152 */       close(pstmt);
/* 182:153 */       rollback(conn);
/* 183:154 */       throw e;
/* 184:    */     }
/* 185:    */     finally
/* 186:    */     {
/* 187:156 */       close(conn);
/* 188:    */     }
/* 189:    */   }
/* 190:    */   
/* 191:    */   public void deleteAll(BigDecimal coot_usuf_cod)
/* 192:    */     throws SQLException
/* 193:    */   {
/* 194:161 */     Connection conn = null;
/* 195:162 */     PreparedStatement pstmt = null;
/* 196:    */     try
/* 197:    */     {
/* 198:164 */       conn = this.ds.getConnection();
/* 199:165 */       conn.setAutoCommit(false);
/* 200:166 */       String sql = "DELETE FROM sdoctor.controlotroperiodico WHERE coot_usuf_cod=?";
/* 201:167 */       pstmt = conn.prepareStatement(sql);
/* 202:168 */       pstmt.setBigDecimal(1, coot_usuf_cod);
/* 203:169 */       pstmt.executeUpdate();
/* 204:170 */       close(pstmt);
/* 205:171 */       conn.commit();
/* 206:    */     }
/* 207:    */     catch (SQLException e)
/* 208:    */     {
/* 209:173 */       close(pstmt);
/* 210:174 */       rollback(conn);
/* 211:175 */       throw e;
/* 212:    */     }
/* 213:    */     finally
/* 214:    */     {
/* 215:177 */       close(conn);
/* 216:    */     }
/* 217:    */   }
/* 218:    */   
/* 219:    */   private int getReqMax(Connection conn, ControlOtroPeriodico data)
/* 220:    */   {
/* 221:182 */     PreparedStatement pstmt = null;
/* 222:183 */     ResultSet rs = null;
/* 223:184 */     int id = 0;
/* 224:    */     try
/* 225:    */     {
/* 226:186 */       String sqlid = "Select max(coot_cod) from sdoctor.controlotroperiodico where coot_usuf_cod = ?";
/* 227:    */       
/* 228:188 */       pstmt = conn.prepareStatement(sqlid);
/* 229:189 */       pstmt.setBigDecimal(1, data.getCoot_usuf_cod());
/* 230:190 */       rs = pstmt.executeQuery();
/* 231:191 */       if ((rs != null) && (rs.next())) {
/* 232:192 */         id = rs.getInt(1) + 1;
/* 233:    */       } else {
/* 234:194 */         id++;
/* 235:    */       }
/* 236:    */     }
/* 237:    */     catch (SQLException e)
/* 238:    */     {
/* 239:198 */       close(rs);
/* 240:199 */       close(pstmt);
/* 241:200 */       rollback(conn);
/* 242:    */     }
/* 243:    */     finally
/* 244:    */     {
/* 245:202 */       close(rs);
/* 246:203 */       close(pstmt);
/* 247:    */     }
/* 248:205 */     return id;
/* 249:    */   }
/* 250:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.dao.ControlOtroPeriodicoDAO
 * JD-Core Version:    0.7.0.1
 */