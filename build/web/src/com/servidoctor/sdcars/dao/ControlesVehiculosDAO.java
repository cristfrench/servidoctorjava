/*   1:    */ package com.servidoctor.sdcars.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdcars.model.ControlesVehiculos;
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
/*  16:    */ public class ControlesVehiculosDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list(BigDecimal cveh_veh_cod)
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 19 */     ArrayList list = new ArrayList();
/*  23: 20 */     Connection conn = null;
/*  24: 21 */     PreparedStatement pstmt = null;
/*  25: 22 */     ResultSet rs = null;
/*  26: 23 */     ControlesVehiculos controlesVehiculosS = new ControlesVehiculos();
/*  27:    */     try
/*  28:    */     {
/*  29: 25 */       conn = this.ds.getConnection();
/*  30: 26 */       DBUtil db = new DBUtil();
/*  31: 27 */       String sql = db.creaSQLSELECT(controlesVehiculosS);
/*  32: 28 */       pstmt = conn.prepareStatement(sql + " where cveh_veh_cod = ?");
/*  33: 29 */       pstmt.setBigDecimal(1, cveh_veh_cod);
/*  34: 30 */       rs = pstmt.executeQuery();
/*  35: 31 */       while (rs.next())
/*  36:    */       {
/*  37: 32 */         ControlesVehiculos controlesVehiculos = new ControlesVehiculos();
/*  38: 33 */         InicializaData.inicializa(controlesVehiculos.getClass(), controlesVehiculos);
/*  39: 34 */         populate(controlesVehiculos, rs);
/*  40: 35 */         list.add(controlesVehiculos);
/*  41:    */       }
/*  42: 37 */       close(rs);
/*  43: 38 */       close(pstmt);
/*  44:    */     }
/*  45:    */     catch (SQLException e)
/*  46:    */     {
/*  47: 40 */       close(rs);
/*  48: 41 */       close(pstmt);
/*  49: 42 */       rollback(conn);
/*  50: 43 */       throw e;
/*  51:    */     }
/*  52:    */     finally
/*  53:    */     {
/*  54: 45 */       close(conn);
/*  55:    */     }
/*  56: 47 */     return list;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public void update(ControlesVehiculos data, String[] llaves, Connection conn)
/*  60:    */     throws SQLException
/*  61:    */   {
/*  62: 51 */     PreparedStatement pstmt = null;
/*  63:    */     try
/*  64:    */     {
/*  65: 53 */       DBUtil db = new DBUtil();
/*  66: 54 */       String sql = db.creaSQLUPDATE(data, llaves);
/*  67: 55 */       pstmt = conn.prepareStatement(sql);
/*  68: 56 */       pstmt.executeUpdate();
/*  69:    */     }
/*  70:    */     catch (SQLException e)
/*  71:    */     {
/*  72: 58 */       throw e;
/*  73:    */     }
/*  74:    */     finally
/*  75:    */     {
/*  76: 60 */       close(pstmt);
/*  77:    */     }
/*  78:    */   }
/*  79:    */   
/*  80:    */   public ControlesVehiculos retrive(BigDecimal cveh_cod, BigDecimal cveh_veh_cod)
/*  81:    */     throws SQLException
/*  82:    */   {
/*  83: 65 */     ControlesVehiculos controlesVehiculos = new ControlesVehiculos();
/*  84: 66 */     Connection conn = null;
/*  85: 67 */     PreparedStatement pstmt = null;
/*  86: 68 */     ResultSet rs = null;
/*  87: 69 */     ControlesVehiculos controlesVehiculosS = new ControlesVehiculos();
/*  88:    */     try
/*  89:    */     {
/*  90: 71 */       conn = this.ds.getConnection();
/*  91: 72 */       DBUtil db = new DBUtil();
/*  92: 73 */       String sql = db.creaSQLSELECT(controlesVehiculosS);
/*  93: 74 */       String where = " where cveh_cod=" + cveh_cod + " and cvh_veh_cod = " + cveh_veh_cod;
/*  94: 75 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  95: 76 */       rs = pstmt.executeQuery();
/*  96: 77 */       if (rs.next())
/*  97:    */       {
/*  98: 79 */         InicializaData.inicializa(controlesVehiculos.getClass(), controlesVehiculos);
/*  99: 80 */         populate(controlesVehiculos, rs);
/* 100:    */       }
/* 101: 83 */       close(rs);
/* 102: 84 */       close(pstmt);
/* 103:    */     }
/* 104:    */     catch (SQLException e)
/* 105:    */     {
/* 106: 86 */       close(rs);
/* 107: 87 */       close(pstmt);
/* 108: 88 */       rollback(conn);
/* 109: 89 */       throw e;
/* 110:    */     }
/* 111:    */     finally
/* 112:    */     {
/* 113: 91 */       close(conn);
/* 114:    */     }
/* 115: 93 */     return controlesVehiculos;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public synchronized void insert(ControlesVehiculos data, Connection conn)
/* 119:    */     throws SQLException
/* 120:    */   {
/* 121: 96 */     PreparedStatement pstmt = null;
/* 122:    */     try
/* 123:    */     {
/* 124: 99 */       int id = 0;
/* 125:100 */       DBUtil db = new DBUtil();
/* 126:    */       
/* 127:102 */       id = getReqMax(conn, data.getCveh_veh_cod());
/* 128:103 */       data.setCveh_cod(new BigDecimal(id));
/* 129:104 */       String sql = db.creaSQLINSERT(data);
/* 130:    */       
/* 131:106 */       pstmt = conn.prepareStatement(sql);
/* 132:107 */       pstmt.executeUpdate();
/* 133:    */     }
/* 134:    */     catch (SQLException sqle)
/* 135:    */     {
/* 136:109 */       throw sqle;
/* 137:    */     }
/* 138:    */     finally
/* 139:    */     {
/* 140:111 */       close(pstmt);
/* 141:    */     }
/* 142:    */   }
/* 143:    */   
/* 144:    */   public void delete(ControlesVehiculos data, Connection conn)
/* 145:    */     throws SQLException
/* 146:    */   {
/* 147:115 */     PreparedStatement pstmt = null;
/* 148:    */     try
/* 149:    */     {
/* 150:117 */       String sql = "DELETE FROM sdoctor.controlesvehiculos WHERE cveh_cod=? and cveh_veh_cod=?";
/* 151:118 */       pstmt = conn.prepareStatement(sql);
/* 152:119 */       pstmt.setBigDecimal(1, data.getCveh_cod());
/* 153:120 */       pstmt.setBigDecimal(2, data.getCveh_veh_cod());
/* 154:121 */       pstmt.executeUpdate();
/* 155:    */     }
/* 156:    */     catch (SQLException e)
/* 157:    */     {
/* 158:123 */       throw e;
/* 159:    */     }
/* 160:    */     finally
/* 161:    */     {
/* 162:125 */       close(pstmt);
/* 163:    */     }
/* 164:    */   }
/* 165:    */   
/* 166:    */   public void deleteAll(BigDecimal cveh_veh_cod, Connection conn)
/* 167:    */     throws SQLException
/* 168:    */   {
/* 169:130 */     PreparedStatement pstmt = null;
/* 170:    */     try
/* 171:    */     {
/* 172:132 */       String sql = "DELETE FROM sdoctor.controlesvehiculos WHERE cveh_veh_cod=?";
/* 173:133 */       pstmt = conn.prepareStatement(sql);
/* 174:134 */       pstmt.setBigDecimal(1, cveh_veh_cod);
/* 175:135 */       pstmt.executeUpdate();
/* 176:    */     }
/* 177:    */     catch (SQLException e)
/* 178:    */     {
/* 179:137 */       throw e;
/* 180:    */     }
/* 181:    */     finally
/* 182:    */     {
/* 183:139 */       close(pstmt);
/* 184:    */     }
/* 185:    */   }
/* 186:    */   
/* 187:    */   private int getReqMax(Connection conn, BigDecimal cveh_veh_cod)
/* 188:    */   {
/* 189:144 */     PreparedStatement pstmt = null;
/* 190:145 */     ResultSet rs = null;
/* 191:146 */     int id = 0;
/* 192:    */     try
/* 193:    */     {
/* 194:148 */       String sqlid = "Select max(cveh_cod) from sdoctor.controlesvehiculos where cveh_veh_cod=?";
/* 195:149 */       pstmt = conn.prepareStatement(sqlid);
/* 196:150 */       pstmt.setBigDecimal(1, cveh_veh_cod);
/* 197:151 */       rs = pstmt.executeQuery();
/* 198:152 */       if ((rs != null) && (rs.next())) {
/* 199:153 */         id = rs.getInt(1) + 1;
/* 200:    */       } else {
/* 201:155 */         id++;
/* 202:    */       }
/* 203:    */     }
/* 204:    */     catch (SQLException e)
/* 205:    */     {
/* 206:159 */       close(rs);
/* 207:160 */       close(pstmt);
/* 208:161 */       rollback(conn);
/* 209:162 */       e.printStackTrace();
/* 210:    */     }
/* 211:    */     finally
/* 212:    */     {
/* 213:164 */       close(rs);
/* 214:165 */       close(pstmt);
/* 215:    */     }
/* 216:167 */     return id;
/* 217:    */   }
/* 218:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdcars.dao.ControlesVehiculosDAO
 * JD-Core Version:    0.7.0.1
 */