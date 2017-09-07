/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.GastosVehiculosNoAnuales;
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
/*  16:    */ public class GastosVehiculosNoAnualesDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list(BigDecimal gasv_veh_cod)
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 19 */     ArrayList list = new ArrayList();
/*  23: 20 */     Connection conn = null;
/*  24: 21 */     PreparedStatement pstmt = null;
/*  25: 22 */     ResultSet rs = null;
/*  26: 23 */     GastosVehiculosNoAnuales gastosVehiculosNoAnualesS = new GastosVehiculosNoAnuales();
/*  27:    */     try
/*  28:    */     {
/*  29: 25 */       conn = this.ds.getConnection();
/*  30: 26 */       DBUtil db = new DBUtil();
/*  31: 27 */       if (this.idioma != null) {
/*  32: 28 */         db.setIdioma(this.idioma);
/*  33:    */       }
/*  34: 30 */       String sql = db.creaSQLSELECT(gastosVehiculosNoAnualesS);
/*  35: 31 */       pstmt = conn.prepareStatement(sql + " where gasv_veh_cod = ?");
/*  36: 32 */       pstmt.setBigDecimal(1, gasv_veh_cod);
/*  37: 33 */       rs = pstmt.executeQuery();
/*  38: 34 */       while (rs.next())
/*  39:    */       {
/*  40: 35 */         GastosVehiculosNoAnuales gastosVehiculosNoAnuales = new GastosVehiculosNoAnuales();
/*  41: 36 */         InicializaData.inicializa(gastosVehiculosNoAnuales.getClass(), gastosVehiculosNoAnuales);
/*  42: 37 */         populate(gastosVehiculosNoAnuales, rs);
/*  43: 38 */         list.add(gastosVehiculosNoAnuales);
/*  44:    */       }
/*  45: 40 */       close(rs);
/*  46: 41 */       close(pstmt);
/*  47:    */     }
/*  48:    */     catch (SQLException e)
/*  49:    */     {
/*  50: 43 */       close(rs);
/*  51: 44 */       close(pstmt);
/*  52: 45 */       rollback(conn);
/*  53: 46 */       throw e;
/*  54:    */     }
/*  55:    */     finally
/*  56:    */     {
/*  57: 48 */       close(conn);
/*  58:    */     }
/*  59: 50 */     return list;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public void update(GastosVehiculosNoAnuales data, String[] llaves, Connection conn)
/*  63:    */     throws SQLException
/*  64:    */   {
/*  65: 54 */     PreparedStatement pstmt = null;
/*  66:    */     try
/*  67:    */     {
/*  68: 56 */       DBUtil db = new DBUtil();
/*  69: 57 */       if (this.idioma != null) {
/*  70: 58 */         db.setIdioma(this.idioma);
/*  71:    */       }
/*  72: 60 */       String sql = db.creaSQLUPDATE(data, llaves);
/*  73: 61 */       pstmt = conn.prepareStatement(sql);
/*  74: 62 */       pstmt.executeUpdate();
/*  75:    */     }
/*  76:    */     catch (SQLException e)
/*  77:    */     {
/*  78: 64 */       throw e;
/*  79:    */     }
/*  80:    */     finally
/*  81:    */     {
/*  82: 66 */       close(pstmt);
/*  83:    */     }
/*  84:    */   }
/*  85:    */   
/*  86:    */   public GastosVehiculosNoAnuales retrive(BigDecimal gasv_cod, BigDecimal gasv_veh_cod)
/*  87:    */     throws SQLException
/*  88:    */   {
/*  89: 71 */     GastosVehiculosNoAnuales gastosVehiculosNoAnuales = new GastosVehiculosNoAnuales();
/*  90: 72 */     Connection conn = null;
/*  91: 73 */     PreparedStatement pstmt = null;
/*  92: 74 */     ResultSet rs = null;
/*  93: 75 */     GastosVehiculosNoAnuales gastosVehiculosNoAnualesS = new GastosVehiculosNoAnuales();
/*  94:    */     try
/*  95:    */     {
/*  96: 77 */       conn = this.ds.getConnection();
/*  97: 78 */       DBUtil db = new DBUtil();
/*  98: 79 */       if (this.idioma != null) {
/*  99: 80 */         db.setIdioma(this.idioma);
/* 100:    */       }
/* 101: 82 */       String sql = db.creaSQLSELECT(gastosVehiculosNoAnualesS);
/* 102: 83 */       String where = " where gasv_cod=" + gasv_cod + " and gasv_veh_cod = " + gasv_veh_cod;
/* 103: 84 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 104: 85 */       rs = pstmt.executeQuery();
/* 105: 86 */       if (rs.next())
/* 106:    */       {
/* 107: 87 */         InicializaData.inicializa(gastosVehiculosNoAnuales.getClass(), gastosVehiculosNoAnuales);
/* 108: 88 */         populate(gastosVehiculosNoAnuales, rs);
/* 109:    */       }
/* 110: 91 */       close(rs);
/* 111: 92 */       close(pstmt);
/* 112:    */     }
/* 113:    */     catch (SQLException e)
/* 114:    */     {
/* 115: 94 */       close(rs);
/* 116: 95 */       close(pstmt);
/* 117: 96 */       rollback(conn);
/* 118: 97 */       throw e;
/* 119:    */     }
/* 120:    */     finally
/* 121:    */     {
/* 122: 99 */       close(conn);
/* 123:    */     }
/* 124:101 */     return gastosVehiculosNoAnuales;
/* 125:    */   }
/* 126:    */   
/* 127:    */   public synchronized void insert(GastosVehiculosNoAnuales data, Connection conn)
/* 128:    */     throws SQLException
/* 129:    */   {
/* 130:104 */     PreparedStatement pstmt = null;
/* 131:    */     try
/* 132:    */     {
/* 133:107 */       int id = 0;
/* 134:108 */       DBUtil db = new DBUtil();
/* 135:109 */       if (this.idioma != null) {
/* 136:110 */         db.setIdioma(this.idioma);
/* 137:    */       }
/* 138:113 */       id = getReqMax(conn, data.getGasv_veh_cod());
/* 139:114 */       data.setGasv_cod(new BigDecimal(id));
/* 140:115 */       String sql = db.creaSQLINSERT(data);
/* 141:    */       
/* 142:117 */       pstmt = conn.prepareStatement(sql);
/* 143:118 */       pstmt.executeUpdate();
/* 144:    */     }
/* 145:    */     catch (SQLException sqle)
/* 146:    */     {
/* 147:120 */       throw sqle;
/* 148:    */     }
/* 149:    */     finally
/* 150:    */     {
/* 151:122 */       close(pstmt);
/* 152:    */     }
/* 153:    */   }
/* 154:    */   
/* 155:    */   public void delete(GastosVehiculosNoAnuales data, Connection conn)
/* 156:    */     throws SQLException
/* 157:    */   {
/* 158:126 */     PreparedStatement pstmt = null;
/* 159:    */     try
/* 160:    */     {
/* 161:128 */       String sql = "DELETE FROM sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".gastosvehiculosnoanuales WHERE gasv_cod=? and gasv_veh_cod=?";
/* 162:129 */       pstmt = conn.prepareStatement(sql);
/* 163:130 */       pstmt.setBigDecimal(1, data.getGasv_cod());
/* 164:131 */       pstmt.setBigDecimal(2, data.getGasv_veh_cod());
/* 165:132 */       pstmt.executeUpdate();
/* 166:    */     }
/* 167:    */     catch (SQLException e)
/* 168:    */     {
/* 169:134 */       throw e;
/* 170:    */     }
/* 171:    */     finally
/* 172:    */     {
/* 173:136 */       close(pstmt);
/* 174:    */     }
/* 175:    */   }
/* 176:    */   
/* 177:    */   public void deleteAll(BigDecimal gasv_veh_cod, Connection conn)
/* 178:    */     throws SQLException
/* 179:    */   {
/* 180:141 */     PreparedStatement pstmt = null;
/* 181:    */     try
/* 182:    */     {
/* 183:143 */       String sql = "DELETE FROM sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".gastosvehiculosnoanuales WHERE gasv_veh_cod=?";
/* 184:144 */       pstmt = conn.prepareStatement(sql);
/* 185:145 */       pstmt.setBigDecimal(1, gasv_veh_cod);
/* 186:146 */       pstmt.executeUpdate();
/* 187:    */     }
/* 188:    */     catch (SQLException e)
/* 189:    */     {
/* 190:148 */       throw e;
/* 191:    */     }
/* 192:    */     finally
/* 193:    */     {
/* 194:150 */       close(pstmt);
/* 195:    */     }
/* 196:    */   }
/* 197:    */   
/* 198:    */   private int getReqMax(Connection conn, BigDecimal gasv_veh_cod)
/* 199:    */   {
/* 200:155 */     PreparedStatement pstmt = null;
/* 201:156 */     ResultSet rs = null;
/* 202:157 */     int id2 = 0;
/* 203:    */     try
/* 204:    */     {
/* 205:159 */       String sqlid = "Select max(gasv_cod) from sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".gastosvehiculosnoanuales where gasv_veh_cod=?";
/* 206:160 */       pstmt = conn.prepareStatement(sqlid);
/* 207:161 */       pstmt.setBigDecimal(1, gasv_veh_cod);
/* 208:162 */       rs = pstmt.executeQuery();
/* 209:163 */       if ((rs != null) && (rs.next())) {
/* 210:164 */         id2 = rs.getInt(1) + 1;
/* 211:    */       } else {
/* 212:166 */         id2++;
/* 213:    */       }
/* 214:    */     }
/* 215:    */     catch (SQLException e)
/* 216:    */     {
/* 217:170 */       close(rs);
/* 218:171 */       close(pstmt);
/* 219:172 */       rollback(conn);
/* 220:173 */       e.printStackTrace();
/* 221:    */     }
/* 222:    */     finally
/* 223:    */     {
/* 224:175 */       close(rs);
/* 225:176 */       close(pstmt);
/* 226:    */     }
/* 227:178 */     return id2;
/* 228:    */   }
/* 229:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.GastosVehiculosNoAnualesDAO
 * JD-Core Version:    0.7.0.1
 */