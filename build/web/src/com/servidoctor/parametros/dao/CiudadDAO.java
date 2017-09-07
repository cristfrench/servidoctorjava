/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.Ciudades;
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
/*  16:    */ public class CiudadDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list()
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 19 */     ArrayList list = new ArrayList();
/*  23: 20 */     Connection conn = null;
/*  24: 21 */     PreparedStatement pstmt = null;
/*  25: 22 */     ResultSet rs = null;
/*  26: 23 */     Ciudades ciudadS = new Ciudades();
/*  27:    */     try
/*  28:    */     {
/*  29: 25 */       conn = this.ds.getConnection();
/*  30: 26 */       DBUtil db = new DBUtil();
/*  31: 27 */       String sql = db.creaSQLSELECT(ciudadS);
/*  32: 28 */       pstmt = conn.prepareStatement(sql);
/*  33: 29 */       rs = pstmt.executeQuery();
/*  34: 30 */       while (rs.next())
/*  35:    */       {
/*  36: 31 */         Ciudades ciudad = new Ciudades();
/*  37: 32 */         InicializaData.inicializa(ciudad.getClass(), ciudad);
/*  38: 33 */         populate(ciudad, rs);
/*  39: 34 */         list.add(ciudad);
/*  40:    */       }
/*  41: 36 */       close(rs);
/*  42: 37 */       close(pstmt);
/*  43:    */     }
/*  44:    */     catch (SQLException e)
/*  45:    */     {
/*  46: 39 */       close(rs);
/*  47: 40 */       close(pstmt);
/*  48: 41 */       rollback(conn);
/*  49: 42 */       throw e;
/*  50:    */     }
/*  51:    */     finally
/*  52:    */     {
/*  53: 44 */       close(conn);
/*  54:    */     }
/*  55: 46 */     return list;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public List search(String cod_pais)
/*  59:    */     throws SQLException
/*  60:    */   {
/*  61: 49 */     ArrayList list = new ArrayList();
/*  62: 50 */     Connection conn = null;
/*  63: 51 */     PreparedStatement pstmt = null;
/*  64: 52 */     ResultSet rs = null;
/*  65: 53 */     Ciudades ciudadS = new Ciudades();
/*  66:    */     try
/*  67:    */     {
                    System.out.println("paiss:" + cod_pais);
/*  68: 55 */       conn = this.ds.getConnection();
/*  69: 56 */       DBUtil db = new DBUtil();
/*  70: 57 */       String sql = db.creaSQLSELECT(ciudadS);
/*  71: 58 */       String where = " where pais_cod=" + cod_pais;
/*  72: 59 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  73:    */       
/*  74: 61 */       rs = pstmt.executeQuery();
/*  75: 62 */       while (rs.next())
/*  76:    */       {
/*  77: 63 */         Ciudades ciudad = new Ciudades();
/*  78: 64 */         InicializaData.inicializa(ciudad.getClass(), ciudad);
/*  79: 65 */         populate(ciudad, rs);
/*  80: 66 */         list.add(ciudad);
/*  81:    */       }
/*  82: 68 */       close(rs);
/*  83: 69 */       close(pstmt);
/*  84:    */     }
/*  85:    */     catch (SQLException e)
/*  86:    */     {
/*  87: 71 */       close(rs);
/*  88: 72 */       close(pstmt);
/*  89: 73 */       throw e;
/*  90:    */     }
/*  91:    */     finally
/*  92:    */     {
/*  93: 75 */       close(conn);
/*  94:    */     }
/*  95: 77 */     return list;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public Ciudades retrive(BigDecimal pais_cod, BigDecimal ciu_cod)
/*  99:    */     throws SQLException
/* 100:    */   {
/* 101: 80 */     Ciudades ciudad = new Ciudades();
/* 102: 81 */     Connection conn = null;
/* 103: 82 */     PreparedStatement pstmt = null;
/* 104: 83 */     ResultSet rs = null;
/* 105: 84 */     Ciudades ciudadS = new Ciudades();
/* 106:    */     try
/* 107:    */     {
/* 108: 86 */       conn = this.ds.getConnection();
/* 109: 87 */       DBUtil db = new DBUtil();
/* 110: 88 */       String sql = db.creaSQLSELECT(ciudadS);
/* 111: 89 */       String where = " where pais_cod=" + pais_cod + " and ciu_cod=" + ciu_cod;
/* 112: 90 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 113: 91 */       rs = pstmt.executeQuery();
/* 114: 92 */       if (rs.next())
/* 115:    */       {
/* 116: 94 */         InicializaData.inicializa(ciudad.getClass(), ciudad);
/* 117: 95 */         populate(ciudad, rs);
/* 118:    */       }
/* 119: 98 */       close(rs);
/* 120: 99 */       close(pstmt);
/* 121:    */     }
/* 122:    */     catch (SQLException e)
/* 123:    */     {
/* 124:101 */       close(rs);
/* 125:102 */       close(pstmt);
/* 126:103 */       rollback(conn);
/* 127:104 */       throw e;
/* 128:    */     }
/* 129:    */     finally
/* 130:    */     {
/* 131:106 */       close(conn);
/* 132:    */     }
/* 133:108 */     return ciudad;
/* 134:    */   }
/* 135:    */   
/* 136:    */   public void delete(Ciudades data)
/* 137:    */     throws SQLException
/* 138:    */   {
/* 139:112 */     Connection conn = null;
/* 140:113 */     PreparedStatement pstmt = null;
/* 141:    */     try
/* 142:    */     {
/* 143:115 */       conn = this.ds.getConnection();
/* 144:116 */       conn.setAutoCommit(false);
/* 145:117 */       String sql = "DELETE FROM sdoctor.ciudades WHERE pais_cod=? and ciu_cod=?";
/* 146:118 */       pstmt = conn.prepareStatement(sql);
/* 147:119 */       pstmt.setBigDecimal(1, data.getPais_cod());
/* 148:120 */       pstmt.setBigDecimal(2, data.getCiu_cod());
/* 149:121 */       pstmt.executeUpdate();
/* 150:122 */       close(pstmt);
/* 151:123 */       conn.commit();
/* 152:    */     }
/* 153:    */     catch (SQLException e)
/* 154:    */     {
/* 155:125 */       close(pstmt);
/* 156:126 */       rollback(conn);
/* 157:127 */       throw e;
/* 158:    */     }
/* 159:    */     finally
/* 160:    */     {
/* 161:129 */       close(conn);
/* 162:    */     }
/* 163:    */   }
/* 164:    */   
/* 165:    */   public synchronized void insert(Ciudades data)
/* 166:    */     throws SQLException
/* 167:    */   {
/* 168:133 */     Connection conn = null;
/* 169:134 */     PreparedStatement pstmt = null;
/* 170:    */     
/* 171:136 */     ResultSet rs = null;
/* 172:    */     try
/* 173:    */     {
/* 174:138 */       int id = 0;
/* 175:139 */       DBUtil db = new DBUtil();
/* 176:140 */       conn = this.ds.getConnection();
/* 177:141 */       conn.setAutoCommit(false);
/* 178:142 */       id = getReqMax(conn, data.getPais_cod());
/* 179:143 */       data.setCiu_cod(new BigDecimal(id));
/* 180:144 */       String sql = db.creaSQLINSERT(data);
/* 181:    */       
/* 182:146 */       pstmt = conn.prepareStatement(sql);
/* 183:147 */       pstmt.executeUpdate();
/* 184:148 */       pstmt.close();
/* 185:149 */       conn.commit();
/* 186:    */     }
/* 187:    */     catch (SQLException sqle)
/* 188:    */     {
/* 189:151 */       close(rs);
/* 190:152 */       close(pstmt);
/* 191:153 */       rollback(conn);
/* 192:154 */       throw sqle;
/* 193:    */     }
/* 194:    */     finally
/* 195:    */     {
/* 196:156 */       close(rs);
/* 197:157 */       close(pstmt);
/* 198:158 */       close(conn);
/* 199:    */     }
/* 200:    */   }
/* 201:    */   
/* 202:    */   public void update(Ciudades data, String[] llaves)
/* 203:    */     throws SQLException
/* 204:    */   {
/* 205:162 */     Connection conn = null;
/* 206:163 */     PreparedStatement pstmt = null;
/* 207:    */     try
/* 208:    */     {
/* 209:165 */       DBUtil db = new DBUtil();
/* 210:166 */       conn = this.ds.getConnection();
/* 211:167 */       conn.setAutoCommit(false);
/* 212:168 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 213:169 */       pstmt = conn.prepareStatement(sql);
/* 214:170 */       pstmt.executeUpdate();
/* 215:171 */       close(pstmt);
/* 216:172 */       conn.commit();
/* 217:    */     }
/* 218:    */     catch (SQLException e)
/* 219:    */     {
/* 220:174 */       close(pstmt);
/* 221:175 */       rollback(conn);
/* 222:176 */       throw e;
/* 223:    */     }
/* 224:    */     finally
/* 225:    */     {
/* 226:178 */       close(conn);
/* 227:    */     }
/* 228:    */   }
/* 229:    */   
/* 230:    */   private int getReqMax(Connection conn, BigDecimal pais_cod)
/* 231:    */   {
/* 232:182 */     PreparedStatement pstmt = null;
/* 233:183 */     ResultSet rs = null;
/* 234:184 */     int id = 0;
/* 235:    */     try
/* 236:    */     {
/* 237:186 */       String sqlid = "Select max(ciu_cod) from sdoctor.ciudades where pais_cod=" + pais_cod;
/* 238:187 */       pstmt = conn.prepareStatement(sqlid);
/* 239:188 */       rs = pstmt.executeQuery();
/* 240:189 */       if ((rs != null) && (rs.next())) {
/* 241:190 */         id = rs.getInt(1) + 1;
/* 242:    */       } else {
/* 243:192 */         id++;
/* 244:    */       }
/* 245:    */     }
/* 246:    */     catch (SQLException e)
/* 247:    */     {
/* 248:196 */       close(rs);
/* 249:197 */       close(pstmt);
/* 250:198 */       rollback(conn);
/* 251:199 */       e.printStackTrace();
/* 252:    */     }
/* 253:    */     finally
/* 254:    */     {
/* 255:201 */       close(rs);
/* 256:202 */       close(pstmt);
/* 257:    */     }
/* 258:204 */     return id;
/* 259:    */   }
/* 260:    */ }



/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\

 * Qualified Name:     com.servidoctor.parametros.dao.CiudadDAO

 * JD-Core Version:    0.7.0.1

 */