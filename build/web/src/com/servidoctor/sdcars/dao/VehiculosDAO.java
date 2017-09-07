/*   1:    */ package com.servidoctor.sdcars.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdcars.model.Vehiculos;
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
/*  16:    */ public class VehiculosDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public void update(Vehiculos data, String[] llaves, Connection conn)
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 19 */     PreparedStatement pstmt = null;
/*  23:    */     try
/*  24:    */     {
/*  25: 21 */       DBUtil db = new DBUtil();
/*  26: 22 */       String sql = db.creaSQLUPDATE(data, llaves);
/*  27:    */       
/*  28: 24 */       pstmt = conn.prepareStatement(sql);
/*  29: 25 */       pstmt.executeUpdate();
/*  30:    */     }
/*  31:    */     catch (SQLException e)
/*  32:    */     {
/*  33: 27 */       throw e;
/*  34:    */     }
/*  35:    */     finally
/*  36:    */     {
/*  37: 29 */       close(pstmt);
/*  38:    */     }
/*  39:    */   }
/*  40:    */   
/*  41:    */   public Vehiculos retrive(BigDecimal vehi_cod)
/*  42:    */     throws SQLException
/*  43:    */   {
/*  44: 34 */     Vehiculos vehiculos = new Vehiculos();
/*  45: 35 */     Connection conn = null;
/*  46: 36 */     PreparedStatement pstmt = null;
/*  47: 37 */     ResultSet rs = null;
/*  48: 38 */     Vehiculos vehiculosS = new Vehiculos();
/*  49:    */     try
/*  50:    */     {
/*  51: 40 */       conn = this.ds.getConnection();
/*  52: 41 */       DBUtil db = new DBUtil();
/*  53: 42 */       String sql = db.creaSQLSELECT(vehiculosS);
/*  54: 43 */       String where = " where vehi_cod = ?";
/*  55: 44 */       pstmt = conn.prepareStatement(sql + where);
/*  56: 45 */       pstmt.setBigDecimal(1, vehi_cod);
/*  57: 46 */       rs = pstmt.executeQuery();
/*  58: 47 */       if (rs.next())
/*  59:    */       {
/*  60: 48 */         InicializaData.inicializa(vehiculos.getClass(), vehiculos);
/*  61: 49 */         populate(vehiculos, rs);
/*  62:    */       }
/*  63: 51 */       close(rs);
/*  64: 52 */       close(pstmt);
/*  65:    */     }
/*  66:    */     catch (SQLException e)
/*  67:    */     {
/*  68: 54 */       close(rs);
/*  69: 55 */       close(pstmt);
/*  70: 56 */       rollback(conn);
/*  71: 57 */       throw e;
/*  72:    */     }
/*  73:    */     finally
/*  74:    */     {
/*  75: 59 */       close(conn);
/*  76:    */     }
/*  77: 61 */     return vehiculos;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public Vehiculos retrieveCarByUser(BigDecimal vehi_usuc_cod)
/*  81:    */     throws SQLException
/*  82:    */   {
/*  83: 65 */     Vehiculos vehiculos = new Vehiculos();
/*  84: 66 */     Connection conn = null;
/*  85: 67 */     PreparedStatement pstmt = null;
/*  86: 68 */     ResultSet rs = null;
/*  87: 69 */     Vehiculos vehiculosS = new Vehiculos();
/*  88:    */     try
/*  89:    */     {
/*  90: 71 */       conn = this.ds.getConnection();
/*  91: 72 */       DBUtil db = new DBUtil();
/*  92: 73 */       String sql = db.creaSQLSELECT(vehiculosS);
/*  93: 74 */       String where = " where vehi_usuc_cod = ? ";
/*  94: 75 */       pstmt = conn.prepareStatement(sql + where);
/*  95: 76 */       pstmt.setBigDecimal(1, vehi_usuc_cod);
/*  96:    */       
/*  97: 78 */       rs = pstmt.executeQuery();
/*  98: 79 */       if (rs.next())
/*  99:    */       {
/* 100: 80 */         InicializaData.inicializa(vehiculos.getClass(), vehiculos);
/* 101: 81 */         populate(vehiculos, rs);
/* 102:    */       }
/* 103: 83 */       close(rs);
/* 104: 84 */       close(pstmt);
/* 105:    */     }
/* 106:    */     catch (SQLException e)
/* 107:    */     {
/* 108: 86 */       close(rs);
/* 109: 87 */       close(pstmt);
/* 110: 88 */       rollback(conn);
/* 111: 89 */       throw e;
/* 112:    */     }
/* 113:    */     finally
/* 114:    */     {
/* 115: 91 */       close(conn);
/* 116:    */     }
/* 117: 93 */     return vehiculos;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public List list(BigDecimal vehi_usuc_cod)
/* 121:    */     throws SQLException
/* 122:    */   {
/* 123: 99 */     ArrayList list = new ArrayList();
/* 124:100 */     Connection conn = null;
/* 125:101 */     PreparedStatement pstmt = null;
/* 126:102 */     ResultSet rs = null;
/* 127:103 */     Vehiculos vehiculosS = new Vehiculos();
/* 128:    */     try
/* 129:    */     {
/* 130:105 */       conn = this.ds.getConnection();
/* 131:106 */       DBUtil db = new DBUtil();
/* 132:107 */       String sql = db.creaSQLSELECT(vehiculosS);
/* 133:108 */       pstmt = conn.prepareStatement(sql + " where vehi_usuc_cod = ?");
/* 134:109 */       pstmt.setBigDecimal(1, vehi_usuc_cod);
/* 135:110 */       rs = pstmt.executeQuery();
/* 136:111 */       while (rs.next())
/* 137:    */       {
/* 138:112 */         Vehiculos vehiculos = new Vehiculos();
/* 139:113 */         InicializaData.inicializa(vehiculos.getClass(), vehiculos);
/* 140:114 */         populate(vehiculos, rs);
/* 141:115 */         list.add(vehiculos);
/* 142:    */       }
/* 143:117 */       close(rs);
/* 144:118 */       close(pstmt);
/* 145:    */     }
/* 146:    */     catch (SQLException e)
/* 147:    */     {
/* 148:120 */       close(rs);
/* 149:121 */       close(pstmt);
/* 150:122 */       rollback(conn);
/* 151:123 */       throw e;
/* 152:    */     }
/* 153:    */     finally
/* 154:    */     {
/* 155:125 */       close(conn);
/* 156:    */     }
/* 157:127 */     return list;
/* 158:    */   }
/* 159:    */   
/* 160:    */   public synchronized BigDecimal insert(Vehiculos data, Connection conn)
/* 161:    */     throws SQLException
/* 162:    */   {
/* 163:131 */     PreparedStatement pstmt = null;
/* 164:    */     try
/* 165:    */     {
/* 166:134 */       int id = 0;
/* 167:135 */       DBUtil db = new DBUtil();
/* 168:    */       
/* 169:137 */       id = getReqMax(conn);
/* 170:138 */       data.setVehi_cod(new BigDecimal(id));
/* 171:139 */       String sql = db.creaSQLINSERT(data);
/* 172:140 */       pstmt = conn.prepareStatement(sql);
/* 173:141 */       pstmt.executeUpdate();
/* 174:    */     }
/* 175:    */     catch (SQLException sqle)
/* 176:    */     {
/* 177:143 */       throw sqle;
/* 178:    */     }
/* 179:    */     finally
/* 180:    */     {
/* 181:145 */       close(pstmt);
/* 182:    */     }
/* 183:147 */     return data.getVehi_cod();
/* 184:    */   }
/* 185:    */   
/* 186:    */   public void delete(BigDecimal vehi_cod, Connection conn)
/* 187:    */     throws SQLException
/* 188:    */   {
/* 189:151 */     PreparedStatement pstmt = null;
/* 190:    */     try
/* 191:    */     {
/* 192:153 */       String sql = "DELETE FROM sdoctor.vehiculos WHERE vehi_cod=?";
/* 193:154 */       pstmt = conn.prepareStatement(sql);
/* 194:155 */       pstmt.setBigDecimal(1, vehi_cod);
/* 195:156 */       pstmt.executeUpdate();
/* 196:157 */       close(pstmt);
/* 197:    */     }
/* 198:    */     catch (SQLException e)
/* 199:    */     {
/* 200:159 */       throw e;
/* 201:    */     }
/* 202:    */     finally
/* 203:    */     {
/* 204:161 */       close(pstmt);
/* 205:    */     }
/* 206:    */   }
/* 207:    */   
/* 208:    */   private int getReqMax(Connection conn)
/* 209:    */     throws SQLException
/* 210:    */   {
/* 211:166 */     PreparedStatement pstmt = null;
/* 212:167 */     ResultSet rs = null;
/* 213:168 */     int id = 0;
/* 214:    */     try
/* 215:    */     {
/* 216:170 */       String sqlid = "Select max(vehi_cod) from sdoctor.vehiculos ";
/* 217:171 */       pstmt = conn.prepareStatement(sqlid);
/* 218:172 */       rs = pstmt.executeQuery();
/* 219:173 */       if ((rs != null) && (rs.next())) {
/* 220:174 */         id = rs.getInt(1) + 1;
/* 221:    */       } else {
/* 222:176 */         id++;
/* 223:    */       }
/* 224:    */     }
/* 225:    */     catch (SQLException e)
/* 226:    */     {
/* 227:180 */       close(rs);
/* 228:181 */       close(pstmt);
/* 229:182 */       throw e;
/* 230:    */     }
/* 231:    */     finally
/* 232:    */     {
/* 233:184 */       close(rs);
/* 234:185 */       close(pstmt);
/* 235:    */     }
/* 236:187 */     return id;
/* 237:    */   }
/* 238:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdcars.dao.VehiculosDAO
 * JD-Core Version:    0.7.0.1
 */