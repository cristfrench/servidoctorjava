/*   1:    */ package com.servidoctor.sdpets.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdpets.model.ControlCuidados;
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
/*  16:    */ public class ControlCuidadosDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list(BigDecimal ccui_mas_cod)
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 26 */     ArrayList list = new ArrayList();
/*  23: 27 */     Connection conn = null;
/*  24: 28 */     PreparedStatement pstmt = null;
/*  25: 29 */     ResultSet rs = null;
/*  26: 30 */     ControlCuidados controlCuidadosS = new ControlCuidados();
/*  27:    */     try
/*  28:    */     {
/*  29: 32 */       conn = this.ds.getConnection();
/*  30: 33 */       DBUtil db = new DBUtil();
/*  31: 34 */       String sql = db.creaSQLSELECT(controlCuidadosS);
/*  32: 35 */       pstmt = conn.prepareStatement(sql + " where ccui_mas_cod = " + ccui_mas_cod);
/*  33: 36 */       rs = pstmt.executeQuery();
/*  34: 37 */       while (rs.next())
/*  35:    */       {
/*  36: 38 */         ControlCuidados controlCuidados = new ControlCuidados();
/*  37: 39 */         InicializaData.inicializa(controlCuidados.getClass(), controlCuidados);
/*  38: 40 */         populate(controlCuidados, rs);
/*  39: 41 */         list.add(controlCuidados);
/*  40:    */       }
/*  41: 43 */       close(rs);
/*  42: 44 */       close(pstmt);
/*  43:    */     }
/*  44:    */     catch (SQLException e)
/*  45:    */     {
/*  46: 46 */       close(rs);
/*  47: 47 */       close(pstmt);
/*  48: 48 */       rollback(conn);
/*  49: 49 */       throw e;
/*  50:    */     }
/*  51:    */     finally
/*  52:    */     {
/*  53: 51 */       close(conn);
/*  54:    */     }
/*  55: 53 */     return list;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public List list(BigDecimal ccui_mas_cod, BigDecimal ccui_raz_tipo)
/*  59:    */     throws SQLException
/*  60:    */   {
/*  61: 57 */     ArrayList list = new ArrayList();
/*  62: 58 */     Connection conn = null;
/*  63: 59 */     PreparedStatement pstmt = null;
/*  64: 60 */     ResultSet rs = null;
/*  65: 61 */     ControlCuidados controlCuidadosS = new ControlCuidados();
/*  66:    */     try
/*  67:    */     {
/*  68: 63 */       conn = this.ds.getConnection();
/*  69: 64 */       DBUtil db = new DBUtil();
/*  70: 65 */       String sql = db.creaSQLSELECT(controlCuidadosS);
/*  71: 66 */       pstmt = conn.prepareStatement(sql + " where ccui_mas_cod = " + ccui_mas_cod + " and ccui_raz_tipo = " + ccui_raz_tipo);
/*  72: 67 */       rs = pstmt.executeQuery();
/*  73: 68 */       while (rs.next())
/*  74:    */       {
/*  75: 69 */         ControlCuidados controlCuidados = new ControlCuidados();
/*  76: 70 */         InicializaData.inicializa(controlCuidados.getClass(), controlCuidados);
/*  77: 71 */         populate(controlCuidados, rs);
/*  78: 72 */         list.add(controlCuidados);
/*  79:    */       }
/*  80: 74 */       close(rs);
/*  81: 75 */       close(pstmt);
/*  82:    */     }
/*  83:    */     catch (SQLException e)
/*  84:    */     {
/*  85: 77 */       close(rs);
/*  86: 78 */       close(pstmt);
/*  87: 79 */       rollback(conn);
/*  88: 80 */       throw e;
/*  89:    */     }
/*  90:    */     finally
/*  91:    */     {
/*  92: 82 */       close(conn);
/*  93:    */     }
/*  94: 84 */     return list;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public ControlCuidados retrive(BigDecimal ccui_cod, BigDecimal ccui_mas_cod)
/*  98:    */     throws SQLException
/*  99:    */   {
/* 100: 89 */     ControlCuidados controlCuidados = new ControlCuidados();
/* 101: 90 */     Connection conn = null;
/* 102: 91 */     PreparedStatement pstmt = null;
/* 103: 92 */     ResultSet rs = null;
/* 104: 93 */     ControlCuidados controlCuidadosS = new ControlCuidados();
/* 105:    */     try
/* 106:    */     {
/* 107: 95 */       conn = this.ds.getConnection();
/* 108: 96 */       DBUtil db = new DBUtil();
/* 109: 97 */       String sql = db.creaSQLSELECT(controlCuidadosS);
/* 110: 98 */       String where = " where ccui_cod=" + ccui_cod + " and ccui_mas_cod = " + ccui_mas_cod;
/* 111: 99 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 112:100 */       rs = pstmt.executeQuery();
/* 113:101 */       if (rs.next())
/* 114:    */       {
/* 115:103 */         InicializaData.inicializa(controlCuidados.getClass(), controlCuidados);
/* 116:104 */         populate(controlCuidados, rs);
/* 117:    */       }
/* 118:107 */       close(rs);
/* 119:108 */       close(pstmt);
/* 120:    */     }
/* 121:    */     catch (SQLException e)
/* 122:    */     {
/* 123:110 */       close(rs);
/* 124:111 */       close(pstmt);
/* 125:112 */       rollback(conn);
/* 126:113 */       throw e;
/* 127:    */     }
/* 128:    */     finally
/* 129:    */     {
/* 130:115 */       close(conn);
/* 131:    */     }
/* 132:117 */     return controlCuidados;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public void update(ControlCuidados data, String[] llaves, Connection conn)
/* 136:    */     throws SQLException
/* 137:    */   {
/* 138:121 */     PreparedStatement pstmt = null;
/* 139:    */     try
/* 140:    */     {
/* 141:123 */       DBUtil db = new DBUtil();
/* 142:124 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 143:125 */       pstmt = conn.prepareStatement(sql);
/* 144:126 */       pstmt.executeUpdate();
/* 145:    */     }
/* 146:    */     catch (SQLException e)
/* 147:    */     {
/* 148:128 */       throw e;
/* 149:    */     }
/* 150:    */     finally
/* 151:    */     {
/* 152:130 */       close(pstmt);
/* 153:    */     }
/* 154:    */   }
/* 155:    */   
/* 156:    */   public synchronized void insert(ControlCuidados data, Connection conn)
/* 157:    */     throws SQLException
/* 158:    */   {
/* 159:134 */     PreparedStatement pstmt = null;
/* 160:    */     try
/* 161:    */     {
/* 162:136 */       int id = 0;
/* 163:137 */       DBUtil db = new DBUtil();
/* 164:    */       
/* 165:139 */       id = getReqMax(conn, data.getCcui_mas_cod().toString());
/* 166:140 */       data.setCcui_cod(new BigDecimal(id));
/* 167:141 */       String sql = db.creaSQLINSERT(data);
/* 168:    */       
/* 169:143 */       pstmt = conn.prepareStatement(sql);
/* 170:144 */       pstmt.executeUpdate();
/* 171:    */     }
/* 172:    */     catch (SQLException sqle)
/* 173:    */     {
/* 174:146 */       throw sqle;
/* 175:    */     }
/* 176:    */     finally
/* 177:    */     {
/* 178:148 */       close(pstmt);
/* 179:    */     }
/* 180:    */   }
/* 181:    */   
/* 182:    */   public void delete(ControlCuidados data, Connection conn)
/* 183:    */     throws SQLException
/* 184:    */   {
/* 185:153 */     PreparedStatement pstmt = null;
/* 186:    */     try
/* 187:    */     {
/* 188:155 */       String sql = "DELETE FROM sdoctor.controlcuidados WHERE ccui_cod=? and ccui_mas_cod=?";
/* 189:156 */       pstmt = conn.prepareStatement(sql);
/* 190:157 */       pstmt.setBigDecimal(1, data.getCcui_cod());
/* 191:158 */       pstmt.setBigDecimal(2, data.getCcui_mas_cod());
/* 192:159 */       pstmt.executeUpdate();
/* 193:    */     }
/* 194:    */     catch (SQLException e)
/* 195:    */     {
/* 196:161 */       throw e;
/* 197:    */     }
/* 198:    */     finally
/* 199:    */     {
/* 200:163 */       close(pstmt);
/* 201:    */     }
/* 202:    */   }
/* 203:    */   
/* 204:    */   public void deleteAll(BigDecimal mas_cod, Connection conn)
/* 205:    */     throws SQLException
/* 206:    */   {
/* 207:167 */     PreparedStatement pstmt = null;
/* 208:    */     try
/* 209:    */     {
/* 210:169 */       String sql = "DELETE FROM sdoctor.controlcuidados WHERE ccui_mas_cod=?";
/* 211:170 */       pstmt = conn.prepareStatement(sql);
/* 212:171 */       pstmt.setBigDecimal(1, mas_cod);
/* 213:172 */       pstmt.executeUpdate();
/* 214:    */     }
/* 215:    */     catch (SQLException e)
/* 216:    */     {
/* 217:174 */       throw e;
/* 218:    */     }
/* 219:    */     finally
/* 220:    */     {
/* 221:176 */       close(pstmt);
/* 222:    */     }
/* 223:    */   }
/* 224:    */   
/* 225:    */   private int getReqMax(Connection conn, String ccui_mas_cod)
/* 226:    */   {
/* 227:181 */     PreparedStatement pstmt = null;
/* 228:182 */     ResultSet rs = null;
/* 229:183 */     int id = 0;
/* 230:    */     try
/* 231:    */     {
/* 232:185 */       String sqlid = "Select max(ccui_cod) from sdoctor.controlcuidados where ccui_mas_cod = " + ccui_mas_cod;
/* 233:186 */       pstmt = conn.prepareStatement(sqlid);
/* 234:187 */       rs = pstmt.executeQuery();
/* 235:188 */       if ((rs != null) && (rs.next())) {
/* 236:189 */         id = rs.getInt(1) + 1;
/* 237:    */       } else {
/* 238:191 */         id++;
/* 239:    */       }
/* 240:    */     }
/* 241:    */     catch (SQLException e)
/* 242:    */     {
/* 243:195 */       close(rs);
/* 244:196 */       close(pstmt);
/* 245:197 */       rollback(conn);
/* 246:198 */       e.printStackTrace();
/* 247:    */     }
/* 248:    */     finally
/* 249:    */     {
/* 250:200 */       close(rs);
/* 251:201 */       close(pstmt);
/* 252:    */     }
/* 253:203 */     return id;
/* 254:    */   }
/* 255:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdpets.dao.ControlCuidadosDAO
 * JD-Core Version:    0.7.0.1
 */