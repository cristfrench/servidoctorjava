/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.RevisionesVehiculo;
/*   5:    */ import com.servidoctor.util.classes.DBUtil;
/*   6:    */ import com.servidoctor.util.classes.InicializaData;
/*   7:    */ import java.io.PrintStream;
/*   8:    */ import java.math.BigDecimal;
/*   9:    */ import java.sql.Connection;
/*  10:    */ import java.sql.PreparedStatement;
/*  11:    */ import java.sql.ResultSet;
/*  12:    */ import java.sql.SQLException;
/*  13:    */ import java.util.ArrayList;
/*  14:    */ import java.util.List;
/*  15:    */ import javax.sql.DataSource;
/*  16:    */ 
/*  17:    */ public class RevisionesVehiculoDAO
/*  18:    */   extends DAO
/*  19:    */ {
/*  20:    */   public List list(BigDecimal rveh_veh_cod)
/*  21:    */     throws Exception
/*  22:    */   {
/*  23: 19 */     ArrayList list = new ArrayList();
/*  24: 20 */     Connection conn = null;
/*  25: 21 */     PreparedStatement pstmt = null;
/*  26: 22 */     ResultSet rs = null;
/*  27: 23 */     RevisionesVehiculo revisionesVehiculoS = new RevisionesVehiculo();
/*  28:    */     try
/*  29:    */     {
/*  30: 25 */       conn = this.ds.getConnection();
/*  31: 26 */       DBUtil db = new DBUtil();
/*  32: 27 */       String sql = db.creaSQLSELECT(revisionesVehiculoS);
/*  33: 28 */       pstmt = conn.prepareStatement(sql + " where rveh_veh_cod = ? order by rveh_cod");
/*  34: 29 */       pstmt.setBigDecimal(1, rveh_veh_cod);
/*  35: 30 */       rs = pstmt.executeQuery();
/*  36: 32 */       while (rs.next())
/*  37:    */       {
/*  38: 33 */         RevisionesVehiculo revisionesVehiculo = new RevisionesVehiculo();
/*  39: 34 */         InicializaData.inicializa(revisionesVehiculo.getClass(), revisionesVehiculo);
/*  40: 35 */         populate(revisionesVehiculo, rs);
/*  41: 36 */         list.add(revisionesVehiculo);
/*  42:    */       }
/*  43: 38 */       close(rs);
/*  44: 39 */       close(pstmt);
/*  45:    */     }
/*  46:    */     catch (Exception e)
/*  47:    */     {
/*  48: 42 */       close(rs);
/*  49: 43 */       close(pstmt);
/*  50: 44 */       rollback(conn);
/*  51: 45 */       throw e;
/*  52:    */     }
/*  53:    */     finally
/*  54:    */     {
/*  55: 47 */       close(conn);
/*  56:    */     }
/*  57: 49 */     return list;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public List list2(BigDecimal rveh_veh_cod)
/*  61:    */     throws SQLException
/*  62:    */   {
/*  63: 53 */     ArrayList list = new ArrayList();
/*  64: 54 */     Connection conn = null;
/*  65: 55 */     PreparedStatement pstmt = null;
/*  66: 56 */     ResultSet rs = null;
/*  67: 57 */     RevisionesVehiculo revisionesVehiculoS = new RevisionesVehiculo();
/*  68:    */     try
/*  69:    */     {
/*  70: 59 */       conn = this.ds.getConnection();
/*  71: 60 */       DBUtil db = new DBUtil();
/*  72: 61 */       String sql = db.creaSQLSELECT(revisionesVehiculoS);
/*  73: 62 */       pstmt = conn.prepareStatement(sql + " where rveh_veh_cod = ? order by rveh_cod ASC");
/*  74: 63 */       pstmt.setBigDecimal(1, rveh_veh_cod);
/*  75: 64 */       rs = pstmt.executeQuery();
/*  76: 65 */       while (rs.next())
/*  77:    */       {
/*  78: 66 */         RevisionesVehiculo revisionesVehiculo = new RevisionesVehiculo();
/*  79: 67 */         InicializaData.inicializa(revisionesVehiculo.getClass(), revisionesVehiculo);
/*  80: 68 */         populate(revisionesVehiculo, rs);
/*  81: 69 */         list.add(revisionesVehiculo);
/*  82:    */       }
/*  83: 71 */       close(rs);
/*  84: 72 */       close(pstmt);
/*  85:    */     }
/*  86:    */     catch (SQLException e)
/*  87:    */     {
/*  88: 74 */       close(rs);
/*  89: 75 */       close(pstmt);
/*  90: 76 */       rollback(conn);
/*  91: 77 */       throw e;
/*  92:    */     }
/*  93:    */     finally
/*  94:    */     {
/*  95: 79 */       close(conn);
/*  96:    */     }
/*  97: 81 */     return list;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public RevisionesVehiculo retrive(BigDecimal rveh_cod, BigDecimal rveh_veh_cod)
/* 101:    */     throws SQLException
/* 102:    */   {
/* 103: 86 */     RevisionesVehiculo revisionesVehiculo = new RevisionesVehiculo();
/* 104: 87 */     Connection conn = null;
/* 105: 88 */     PreparedStatement pstmt = null;
/* 106: 89 */     ResultSet rs = null;
/* 107: 90 */     RevisionesVehiculo revisionesVehiculoS = new RevisionesVehiculo();
/* 108:    */     try
/* 109:    */     {
/* 110: 92 */       conn = this.ds.getConnection();
/* 111: 93 */       DBUtil db = new DBUtil();
/* 112: 94 */       String sql = db.creaSQLSELECT(revisionesVehiculoS);
/* 113: 95 */       String where = " where rveh_cod=" + rveh_cod + " and rveh_veh_cod = " + rveh_veh_cod;
/* 114: 96 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 115: 97 */       rs = pstmt.executeQuery();
/* 116: 98 */       if (rs.next())
/* 117:    */       {
/* 118:100 */         InicializaData.inicializa(revisionesVehiculo.getClass(), revisionesVehiculo);
/* 119:101 */         populate(revisionesVehiculo, rs);
/* 120:    */       }
/* 121:104 */       close(rs);
/* 122:105 */       close(pstmt);
/* 123:    */     }
/* 124:    */     catch (SQLException e)
/* 125:    */     {
/* 126:107 */       close(rs);
/* 127:108 */       close(pstmt);
/* 128:109 */       rollback(conn);
/* 129:110 */       throw e;
/* 130:    */     }
/* 131:    */     finally
/* 132:    */     {
/* 133:112 */       close(conn);
/* 134:    */     }
/* 135:114 */     return revisionesVehiculo;
/* 136:    */   }
/* 137:    */   
/* 138:    */   public void update(RevisionesVehiculo data, String[] llaves, Connection conn)
/* 139:    */     throws SQLException
/* 140:    */   {
/* 141:118 */     PreparedStatement pstmt = null;
/* 142:    */     try
/* 143:    */     {
/* 144:120 */       DBUtil db = new DBUtil();
/* 145:121 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 146:122 */       pstmt = conn.prepareStatement(sql);
/* 147:123 */       pstmt.executeUpdate();
/* 148:    */     }
/* 149:    */     catch (SQLException e)
/* 150:    */     {
/* 151:125 */       throw e;
/* 152:    */     }
/* 153:    */     finally
/* 154:    */     {
/* 155:127 */       close(pstmt);
/* 156:    */     }
/* 157:    */   }
/* 158:    */   
/* 159:    */   public synchronized void insert(RevisionesVehiculo data, Connection conn)
/* 160:    */     throws SQLException
/* 161:    */   {
/* 162:131 */     PreparedStatement pstmt = null;
/* 163:    */     try
/* 164:    */     {
/* 165:134 */       int id = 0;
/* 166:135 */       DBUtil db = new DBUtil();
/* 167:    */       
/* 168:137 */       id = getReqMax(conn, data.getRveh_veh_cod());
/* 169:138 */       data.setRveh_cod(new BigDecimal(id));
/* 170:139 */       String sql = db.creaSQLINSERT(data);
/* 171:140 */       pstmt = conn.prepareStatement(sql);
/* 172:141 */       System.out.println(sql);
/* 173:142 */       pstmt.executeUpdate();
/* 174:    */     }
/* 175:    */     catch (SQLException sqle)
/* 176:    */     {
/* 177:144 */       throw sqle;
/* 178:    */     }
/* 179:    */     finally
/* 180:    */     {
/* 181:146 */       close(pstmt);
/* 182:    */     }
/* 183:    */   }
/* 184:    */   
/* 185:    */   public void delete(RevisionesVehiculo data, Connection conn)
/* 186:    */     throws SQLException
/* 187:    */   {
/* 188:150 */     PreparedStatement pstmt = null;
/* 189:    */     try
/* 190:    */     {
/* 191:152 */       String sql = "DELETE FROM sdoctor.revisionesvehiculo WHERE rveh_cod=? and rveh_veh_cod=?";
/* 192:153 */       pstmt = conn.prepareStatement(sql);
/* 193:154 */       pstmt.setBigDecimal(1, data.getRveh_cod());
/* 194:155 */       pstmt.setBigDecimal(2, data.getRveh_veh_cod());
/* 195:156 */       pstmt.executeUpdate();
/* 196:    */     }
/* 197:    */     catch (SQLException e)
/* 198:    */     {
/* 199:158 */       throw e;
/* 200:    */     }
/* 201:    */     finally
/* 202:    */     {
/* 203:160 */       close(pstmt);
/* 204:    */     }
/* 205:    */   }
/* 206:    */   
/* 207:    */   public void deleteAll(BigDecimal vehi_cod, Connection conn)
/* 208:    */     throws SQLException
/* 209:    */   {
/* 210:165 */     PreparedStatement pstmt = null;
/* 211:    */     try
/* 212:    */     {
/* 213:167 */       String sql = "DELETE FROM sdoctor.revisionesvehiculo WHERE rveh_veh_cod=?";
/* 214:168 */       pstmt = conn.prepareStatement(sql);
/* 215:169 */       pstmt.setBigDecimal(1, vehi_cod);
/* 216:170 */       pstmt.executeUpdate();
/* 217:    */     }
/* 218:    */     catch (SQLException e)
/* 219:    */     {
/* 220:172 */       throw e;
/* 221:    */     }
/* 222:    */     finally
/* 223:    */     {
/* 224:174 */       close(pstmt);
/* 225:    */     }
/* 226:    */   }
/* 227:    */   
/* 228:    */   private int getReqMax(Connection conn, BigDecimal cveh_veh_cod)
/* 229:    */     throws SQLException
/* 230:    */   {
/* 231:179 */     PreparedStatement pstmt = null;
/* 232:180 */     ResultSet rs = null;
/* 233:181 */     int id = 0;
/* 234:    */     try
/* 235:    */     {
/* 236:183 */       String sqlid = "Select max(rveh_cod) from sdoctor.revisionesvehiculo where rveh_veh_cod=?";
/* 237:184 */       pstmt = conn.prepareStatement(sqlid);
/* 238:185 */       pstmt.setBigDecimal(1, cveh_veh_cod);
/* 239:186 */       rs = pstmt.executeQuery();
/* 240:187 */       if ((rs != null) && (rs.next())) {
/* 241:188 */         id = rs.getInt(1) + 1;
/* 242:    */       } else {
/* 243:190 */         id++;
/* 244:    */       }
/* 245:    */     }
/* 246:    */     catch (SQLException e)
/* 247:    */     {
/* 248:194 */       close(rs);
/* 249:195 */       close(pstmt);
/* 250:196 */       throw e;
/* 251:    */     }
/* 252:    */     finally
/* 253:    */     {
/* 254:198 */       close(rs);
/* 255:199 */       close(pstmt);
/* 256:    */     }
/* 257:201 */     return id;
/* 258:    */   }
/* 259:    */   
/* 260:    */   public RevisionesVehiculo retrieve(BigDecimal rveh_cod, BigDecimal rveh_veh_cod)
/* 261:    */     throws SQLException
/* 262:    */   {
/* 263:207 */     RevisionesVehiculo revisionesVehiculo = new RevisionesVehiculo();
/* 264:208 */     Connection conn = null;
/* 265:209 */     PreparedStatement pstmt = null;
/* 266:210 */     ResultSet rs = null;
/* 267:211 */     RevisionesVehiculo revisionesVehiculoS = new RevisionesVehiculo();
/* 268:    */     try
/* 269:    */     {
/* 270:213 */       conn = this.ds.getConnection();
/* 271:214 */       DBUtil db = new DBUtil();
/* 272:215 */       String sql = db.creaSQLSELECT(revisionesVehiculoS);
/* 273:216 */       String where = " where rveh_cod=" + rveh_cod + " and rveh_veh_cod = " + rveh_veh_cod + " order by rveh_control_fec DESC,rveh_control_kms DESC LIMIT 0,1";
/* 274:217 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 275:218 */       rs = pstmt.executeQuery();
/* 276:219 */       if (rs.next())
/* 277:    */       {
/* 278:221 */         InicializaData.inicializa(revisionesVehiculo.getClass(), revisionesVehiculo);
/* 279:222 */         populate(revisionesVehiculo, rs);
/* 280:    */       }
/* 281:225 */       close(rs);
/* 282:226 */       close(pstmt);
/* 283:    */     }
/* 284:    */     catch (SQLException e)
/* 285:    */     {
/* 286:228 */       close(rs);
/* 287:229 */       close(pstmt);
/* 288:230 */       rollback(conn);
/* 289:231 */       throw e;
/* 290:    */     }
/* 291:    */     finally
/* 292:    */     {
/* 293:233 */       close(conn);
/* 294:    */     }
/* 295:235 */     return revisionesVehiculo;
/* 296:    */   }
/* 297:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.RevisionesVehiculoDAO
 * JD-Core Version:    0.7.0.1
 */