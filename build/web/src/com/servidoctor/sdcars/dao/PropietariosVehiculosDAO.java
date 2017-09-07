/*   1:    */ package com.servidoctor.sdcars.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdcars.model.PropietariosVehiculos;
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
/*  16:    */ public class PropietariosVehiculosDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public void update(PropietariosVehiculos data, String[] llaves, Connection conn)
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 19 */     PreparedStatement pstmt = null;
/*  23:    */     try
/*  24:    */     {
/*  25: 21 */       DBUtil db = new DBUtil();
/*  26: 22 */       String sql = db.creaSQLUPDATE(data, llaves);
/*  27: 23 */       pstmt = conn.prepareStatement(sql);
/*  28: 24 */       pstmt.executeUpdate();
/*  29:    */     }
/*  30:    */     catch (SQLException e)
/*  31:    */     {
/*  32: 26 */       throw e;
/*  33:    */     }
/*  34:    */     finally
/*  35:    */     {
/*  36: 28 */       close(pstmt);
/*  37:    */     }
/*  38:    */   }
/*  39:    */   
/*  40:    */   public PropietariosVehiculos retrive(BigDecimal pveh_cod, BigDecimal pveh_veh_cod)
/*  41:    */     throws SQLException
/*  42:    */   {
/*  43: 34 */     PropietariosVehiculos propietariosVehiculos = new PropietariosVehiculos();
/*  44: 35 */     Connection conn = null;
/*  45: 36 */     PreparedStatement pstmt = null;
/*  46: 37 */     ResultSet rs = null;
/*  47: 38 */     PropietariosVehiculos propietariosVehiculosS = new PropietariosVehiculos();
/*  48:    */     try
/*  49:    */     {
/*  50: 40 */       conn = this.ds.getConnection();
/*  51: 41 */       DBUtil db = new DBUtil();
/*  52: 42 */       String sql = db.creaSQLSELECT(propietariosVehiculosS);
/*  53: 43 */       String where = " where pveh_cod=" + pveh_cod + " and pveh_veh_cod = " + pveh_veh_cod;
/*  54: 44 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  55: 45 */       rs = pstmt.executeQuery();
/*  56: 46 */       if (rs.next())
/*  57:    */       {
/*  58: 48 */         InicializaData.inicializa(propietariosVehiculos.getClass(), propietariosVehiculos);
/*  59: 49 */         populate(propietariosVehiculos, rs);
/*  60:    */       }
/*  61: 52 */       close(rs);
/*  62: 53 */       close(pstmt);
/*  63:    */     }
/*  64:    */     catch (SQLException e)
/*  65:    */     {
/*  66: 55 */       close(rs);
/*  67: 56 */       close(pstmt);
/*  68: 57 */       rollback(conn);
/*  69: 58 */       throw e;
/*  70:    */     }
/*  71:    */     finally
/*  72:    */     {
/*  73: 60 */       close(conn);
/*  74:    */     }
/*  75: 62 */     return propietariosVehiculos;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public List list(BigDecimal pveh_veh_cod)
/*  79:    */     throws SQLException
/*  80:    */   {
/*  81: 66 */     ArrayList list = list = new ArrayList();
/*  82: 67 */     Connection conn = null;
/*  83: 68 */     PreparedStatement pstmt = null;
/*  84: 69 */     ResultSet rs = null;
/*  85: 70 */     PropietariosVehiculos propietariosVehiculosS = new PropietariosVehiculos();
/*  86:    */     try
/*  87:    */     {
/*  88: 72 */       conn = this.ds.getConnection();
/*  89: 73 */       DBUtil db = new DBUtil();
/*  90: 74 */       String sql = db.creaSQLSELECT(propietariosVehiculosS);
/*  91: 75 */       pstmt = conn.prepareStatement(sql + " where pveh_veh_cod = ?");
/*  92: 76 */       pstmt.setBigDecimal(1, pveh_veh_cod);
/*  93: 77 */       rs = pstmt.executeQuery();
/*  94: 78 */       while (rs.next())
/*  95:    */       {
/*  96: 79 */         PropietariosVehiculos propietariosVehiculos = new PropietariosVehiculos();
/*  97: 80 */         InicializaData.inicializa(propietariosVehiculos.getClass(), propietariosVehiculos);
/*  98: 81 */         populate(propietariosVehiculos, rs);
/*  99: 82 */         list.add(propietariosVehiculos);
/* 100:    */       }
/* 101: 84 */       close(rs);
/* 102: 85 */       close(pstmt);
/* 103:    */     }
/* 104:    */     catch (SQLException e)
/* 105:    */     {
/* 106: 87 */       close(rs);
/* 107: 88 */       close(pstmt);
/* 108: 89 */       rollback(conn);
/* 109: 90 */       throw e;
/* 110:    */     }
/* 111:    */     finally
/* 112:    */     {
/* 113: 92 */       close(conn);
/* 114:    */     }
/* 115: 94 */     return list;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public synchronized void insert(PropietariosVehiculos data, Connection conn)
/* 119:    */     throws SQLException
/* 120:    */   {
/* 121: 98 */     PreparedStatement pstmt = null;
/* 122:    */     try
/* 123:    */     {
/* 124:101 */       int id = 0;
/* 125:102 */       DBUtil db = new DBUtil();
/* 126:    */       
/* 127:104 */       id = getReqMax(conn, data.getPveh_veh_cod());
/* 128:105 */       data.setPveh_cod(new BigDecimal(id));
/* 129:106 */       String sql = db.creaSQLINSERT(data);
/* 130:107 */       pstmt = conn.prepareStatement(sql);
/* 131:108 */       pstmt.executeUpdate();
/* 132:    */     }
/* 133:    */     catch (SQLException sqle)
/* 134:    */     {
/* 135:110 */       throw sqle;
/* 136:    */     }
/* 137:    */     finally
/* 138:    */     {
/* 139:112 */       close(pstmt);
/* 140:    */     }
/* 141:    */   }
/* 142:    */   
/* 143:    */   public void delete(PropietariosVehiculos data)
/* 144:    */     throws SQLException
/* 145:    */   {
/* 146:116 */     Connection conn = null;
/* 147:117 */     PreparedStatement pstmt = null;
/* 148:    */     try
/* 149:    */     {
/* 150:119 */       conn = this.ds.getConnection();
/* 151:120 */       conn.setAutoCommit(false);
/* 152:121 */       String sql = "DELETE FROM sdoctor.propietariosvehiculos WHERE pveh_cod=? and pveh_veh_cod=?";
/* 153:122 */       pstmt = conn.prepareStatement(sql);
/* 154:123 */       pstmt.setBigDecimal(1, data.getPveh_cod());
/* 155:124 */       pstmt.setBigDecimal(2, data.getPveh_veh_cod());
/* 156:125 */       pstmt.executeUpdate();
/* 157:126 */       close(pstmt);
/* 158:127 */       conn.commit();
/* 159:    */     }
/* 160:    */     catch (SQLException e)
/* 161:    */     {
/* 162:129 */       close(pstmt);
/* 163:130 */       rollback(conn);
/* 164:131 */       throw e;
/* 165:    */     }
/* 166:    */     finally
/* 167:    */     {
/* 168:133 */       close(conn);
/* 169:    */     }
/* 170:    */   }
/* 171:    */   
/* 172:    */   public void deleteAll(BigDecimal vehi_cod, Connection conn)
/* 173:    */     throws SQLException
/* 174:    */   {
/* 175:138 */     PreparedStatement pstmt = null;
/* 176:    */     try
/* 177:    */     {
/* 178:140 */       String sql = "DELETE FROM sdoctor.propietariosvehiculos WHERE pveh_veh_cod=?";
/* 179:141 */       pstmt = conn.prepareStatement(sql);
/* 180:142 */       pstmt.setBigDecimal(1, vehi_cod);
/* 181:143 */       pstmt.executeUpdate();
/* 182:144 */       close(pstmt);
/* 183:    */     }
/* 184:    */     catch (SQLException e)
/* 185:    */     {
/* 186:146 */       throw e;
/* 187:    */     }
/* 188:    */     finally
/* 189:    */     {
/* 190:148 */       close(pstmt);
/* 191:    */     }
/* 192:    */   }
/* 193:    */   
/* 194:    */   public void delete(BigDecimal pveh_veh_cod)
/* 195:    */     throws SQLException
/* 196:    */   {
/* 197:153 */     Connection conn = null;
/* 198:154 */     PreparedStatement pstmt = null;
/* 199:    */     try
/* 200:    */     {
/* 201:156 */       conn = this.ds.getConnection();
/* 202:157 */       conn.setAutoCommit(false);
/* 203:158 */       String sql = "DELETE FROM sdoctor.propietariosvehiculos WHERE pveh_veh_cod=?";
/* 204:159 */       pstmt = conn.prepareStatement(sql);
/* 205:160 */       pstmt.setBigDecimal(1, pveh_veh_cod);
/* 206:161 */       pstmt.executeUpdate();
/* 207:162 */       close(pstmt);
/* 208:163 */       conn.commit();
/* 209:    */     }
/* 210:    */     catch (SQLException e)
/* 211:    */     {
/* 212:165 */       close(pstmt);
/* 213:166 */       rollback(conn);
/* 214:167 */       throw e;
/* 215:    */     }
/* 216:    */     finally
/* 217:    */     {
/* 218:169 */       close(conn);
/* 219:    */     }
/* 220:    */   }
/* 221:    */   
/* 222:    */   private int getReqMax(Connection conn, BigDecimal pveh_veh_cod)
/* 223:    */     throws SQLException
/* 224:    */   {
/* 225:174 */     PreparedStatement pstmt = null;
/* 226:175 */     ResultSet rs = null;
/* 227:176 */     int id = 0;
/* 228:    */     try
/* 229:    */     {
/* 230:178 */       String sqlid = "Select max(pveh_cod) from sdoctor.propietariosvehiculos where pveh_veh_cod=?";
/* 231:179 */       pstmt = conn.prepareStatement(sqlid);
/* 232:180 */       pstmt.setBigDecimal(1, pveh_veh_cod);
/* 233:181 */       rs = pstmt.executeQuery();
/* 234:182 */       if ((rs != null) && (rs.next())) {
/* 235:183 */         id = rs.getInt(1) + 1;
/* 236:    */       } else {
/* 237:185 */         id++;
/* 238:    */       }
/* 239:    */     }
/* 240:    */     catch (SQLException e)
/* 241:    */     {
/* 242:189 */       close(rs);
/* 243:190 */       close(pstmt);
/* 244:191 */       throw e;
/* 245:    */     }
/* 246:    */     finally
/* 247:    */     {
/* 248:193 */       close(rs);
/* 249:194 */       close(pstmt);
/* 250:    */     }
/* 251:196 */     return id;
/* 252:    */   }
/* 253:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdcars.dao.PropietariosVehiculosDAO
 * JD-Core Version:    0.7.0.1
 */