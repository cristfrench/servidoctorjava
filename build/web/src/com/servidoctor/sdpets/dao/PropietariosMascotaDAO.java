/*   1:    */ package com.servidoctor.sdpets.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdpets.model.PropietariosMascota;
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
/*  16:    */ public class PropietariosMascotaDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public PropietariosMascota retrive(BigDecimal pmas_cod, BigDecimal pmas_mas_cod)
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 27 */     PropietariosMascota propietariosMascota = new PropietariosMascota();
/*  23: 28 */     Connection conn = null;
/*  24: 29 */     PreparedStatement pstmt = null;
/*  25: 30 */     ResultSet rs = null;
/*  26: 31 */     PropietariosMascota propietariosMascotaS = new PropietariosMascota();
/*  27:    */     try
/*  28:    */     {
/*  29: 33 */       conn = this.ds.getConnection();
/*  30: 34 */       DBUtil db = new DBUtil();
/*  31: 35 */       String sql = db.creaSQLSELECT(propietariosMascotaS);
/*  32: 36 */       String where = " where pmas_cod=" + pmas_cod + " and pmas_mas_cod = " + pmas_mas_cod;
/*  33: 37 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  34: 38 */       rs = pstmt.executeQuery();
/*  35: 39 */       if (rs.next())
/*  36:    */       {
/*  37: 40 */         InicializaData.inicializa(propietariosMascota.getClass(), propietariosMascota);
/*  38: 41 */         populate(propietariosMascota, rs);
/*  39:    */       }
/*  40: 44 */       close(rs);
/*  41: 45 */       close(pstmt);
/*  42:    */     }
/*  43:    */     catch (SQLException e)
/*  44:    */     {
/*  45: 47 */       close(rs);
/*  46: 48 */       close(pstmt);
/*  47: 49 */       rollback(conn);
/*  48: 50 */       throw e;
/*  49:    */     }
/*  50:    */     finally
/*  51:    */     {
/*  52: 52 */       close(conn);
/*  53:    */     }
/*  54: 54 */     return propietariosMascota;
/*  55:    */   }
/*  56:    */   
/*  57:    */   public PropietariosMascota retrieve(BigDecimal pmas_mas_cod)
/*  58:    */     throws SQLException
/*  59:    */   {
/*  60: 59 */     PropietariosMascota propietariosMascota = new PropietariosMascota();
/*  61: 60 */     Connection conn = null;
/*  62: 61 */     PreparedStatement pstmt = null;
/*  63: 62 */     ResultSet rs = null;
/*  64: 63 */     PropietariosMascota propietariosMascotaS = new PropietariosMascota();
/*  65:    */     try
/*  66:    */     {
/*  67: 65 */       conn = this.ds.getConnection();
/*  68: 66 */       DBUtil db = new DBUtil();
/*  69: 67 */       String sql = db.creaSQLSELECT(propietariosMascotaS);
/*  70: 68 */       String where = "WHERE pmas_mas_cod = " + pmas_mas_cod;
/*  71: 69 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  72: 70 */       rs = pstmt.executeQuery();
/*  73: 71 */       if (rs.next())
/*  74:    */       {
/*  75: 72 */         InicializaData.inicializa(propietariosMascota.getClass(), propietariosMascota);
/*  76: 73 */         populate(propietariosMascota, rs);
/*  77:    */       }
/*  78: 76 */       close(rs);
/*  79: 77 */       close(pstmt);
/*  80:    */     }
/*  81:    */     catch (SQLException e)
/*  82:    */     {
/*  83: 79 */       close(rs);
/*  84: 80 */       close(pstmt);
/*  85: 81 */       rollback(conn);
/*  86: 82 */       throw e;
/*  87:    */     }
/*  88:    */     finally
/*  89:    */     {
/*  90: 84 */       close(conn);
/*  91:    */     }
/*  92: 86 */     return propietariosMascota;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public List list(BigDecimal mas_cod)
/*  96:    */     throws SQLException
/*  97:    */   {
/*  98: 92 */     ArrayList list = new ArrayList();
/*  99:    */     
/* 100: 94 */     Connection conn = null;
/* 101: 95 */     PreparedStatement pstmt = null;
/* 102: 96 */     ResultSet rs = null;
/* 103:    */     try
/* 104:    */     {
/* 105:100 */       conn = this.ds.getConnection();
/* 106:    */       
/* 107:102 */       String sql = "SELECT * FROM sdoctor.propietariosmascota ";
/* 108:103 */       String where = " WHERE pmas_mas_cod = ? ";
/* 109:104 */       pstmt = conn.prepareStatement(sql + where);
/* 110:105 */       pstmt.setBigDecimal(1, mas_cod);
/* 111:106 */       rs = pstmt.executeQuery();
/* 112:108 */       while (rs.next())
/* 113:    */       {
/* 114:109 */         PropietariosMascota propietariosMascota = new PropietariosMascota();
/* 115:110 */         populate(propietariosMascota, rs);
/* 116:111 */         list.add(propietariosMascota);
/* 117:    */       }
/* 118:114 */       close(rs);
/* 119:115 */       close(pstmt);
/* 120:    */     }
/* 121:    */     catch (SQLException e)
/* 122:    */     {
/* 123:117 */       close(rs);
/* 124:118 */       close(pstmt);
/* 125:119 */       rollback(conn);
/* 126:120 */       throw e;
/* 127:    */     }
/* 128:    */     finally
/* 129:    */     {
/* 130:122 */       close(conn);
/* 131:    */     }
/* 132:124 */     return list;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public void update(PropietariosMascota data, String[] llaves, Connection conn)
/* 136:    */     throws SQLException
/* 137:    */   {
/* 138:128 */     PreparedStatement pstmt = null;
/* 139:    */     try
/* 140:    */     {
/* 141:130 */       DBUtil db = new DBUtil();
/* 142:131 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 143:132 */       pstmt = conn.prepareStatement(sql);
/* 144:133 */       pstmt.executeUpdate();
/* 145:    */     }
/* 146:    */     catch (SQLException e)
/* 147:    */     {
/* 148:135 */       throw e;
/* 149:    */     }
/* 150:    */     finally
/* 151:    */     {
/* 152:137 */       close(pstmt);
/* 153:    */     }
/* 154:    */   }
/* 155:    */   
/* 156:    */   public synchronized void insert(PropietariosMascota data, Connection conn)
/* 157:    */     throws SQLException
/* 158:    */   {
/* 159:141 */     PreparedStatement pstmt = null;
/* 160:    */     try
/* 161:    */     {
/* 162:143 */       int id = 0;
/* 163:144 */       DBUtil db = new DBUtil();
/* 164:    */       
/* 165:146 */       id = getReqMax(conn, data.getPmas_mas_cod().toString());
/* 166:147 */       data.setPmas_cod(new BigDecimal(id));
/* 167:148 */       String sql = db.creaSQLINSERT(data);
/* 168:    */       
/* 169:150 */       pstmt = conn.prepareStatement(sql);
/* 170:151 */       pstmt.executeUpdate();
/* 171:    */     }
/* 172:    */     catch (SQLException sqle)
/* 173:    */     {
/* 174:153 */       throw sqle;
/* 175:    */     }
/* 176:    */     finally
/* 177:    */     {
/* 178:155 */       close(pstmt);
/* 179:    */     }
/* 180:    */   }
/* 181:    */   
/* 182:    */   public void delete(PropietariosMascota data)
/* 183:    */     throws SQLException
/* 184:    */   {
/* 185:160 */     Connection conn = null;
/* 186:161 */     PreparedStatement pstmt = null;
/* 187:    */     try
/* 188:    */     {
/* 189:163 */       conn = this.ds.getConnection();
/* 190:164 */       conn.setAutoCommit(false);
/* 191:165 */       String sql = "DELETE FROM sdoctor.propietariosmascota WHERE pmas_cod=? and pmas_mas_cod=?";
/* 192:166 */       pstmt = conn.prepareStatement(sql);
/* 193:167 */       pstmt.setBigDecimal(1, data.getPmas_cod());
/* 194:168 */       pstmt.setBigDecimal(2, data.getPmas_mas_cod());
/* 195:169 */       pstmt.executeUpdate();
/* 196:170 */       close(pstmt);
/* 197:171 */       conn.commit();
/* 198:    */     }
/* 199:    */     catch (SQLException e)
/* 200:    */     {
/* 201:173 */       close(pstmt);
/* 202:174 */       rollback(conn);
/* 203:175 */       throw e;
/* 204:    */     }
/* 205:    */     finally
/* 206:    */     {
/* 207:177 */       close(conn);
/* 208:    */     }
/* 209:    */   }
/* 210:    */   
/* 211:    */   public void deleteAll(BigDecimal mas_cod, Connection conn)
/* 212:    */     throws SQLException
/* 213:    */   {
/* 214:181 */     PreparedStatement pstmt = null;
/* 215:    */     try
/* 216:    */     {
/* 217:183 */       String sql = "DELETE FROM sdoctor.propietariosmascota WHERE pmas_mas_cod=?";
/* 218:184 */       pstmt = conn.prepareStatement(sql);
/* 219:185 */       pstmt.setBigDecimal(1, mas_cod);
/* 220:186 */       pstmt.executeUpdate();
/* 221:    */     }
/* 222:    */     catch (SQLException e)
/* 223:    */     {
/* 224:188 */       throw e;
/* 225:    */     }
/* 226:    */     finally
/* 227:    */     {
/* 228:190 */       close(pstmt);
/* 229:    */     }
/* 230:    */   }
/* 231:    */   
/* 232:    */   private int getReqMax(Connection conn, String pmas_mas_cod)
/* 233:    */   {
/* 234:195 */     PreparedStatement pstmt = null;
/* 235:196 */     ResultSet rs = null;
/* 236:197 */     int id = 0;
/* 237:    */     try
/* 238:    */     {
/* 239:199 */       String sqlid = "Select max(pmas_cod) from sdoctor.propietariosmascota where pmas_mas_cod = " + pmas_mas_cod;
/* 240:200 */       pstmt = conn.prepareStatement(sqlid);
/* 241:201 */       rs = pstmt.executeQuery();
/* 242:202 */       if ((rs != null) && (rs.next())) {
/* 243:203 */         id = rs.getInt(1) + 1;
/* 244:    */       } else {
/* 245:205 */         id++;
/* 246:    */       }
/* 247:    */     }
/* 248:    */     catch (SQLException e)
/* 249:    */     {
/* 250:209 */       close(rs);
/* 251:210 */       close(pstmt);
/* 252:211 */       rollback(conn);
/* 253:212 */       e.printStackTrace();
/* 254:    */     }
/* 255:    */     finally
/* 256:    */     {
/* 257:214 */       close(rs);
/* 258:215 */       close(pstmt);
/* 259:    */     }
/* 260:217 */     return id;
/* 261:    */   }
/* 262:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdpets.dao.PropietariosMascotaDAO
 * JD-Core Version:    0.7.0.1
 */