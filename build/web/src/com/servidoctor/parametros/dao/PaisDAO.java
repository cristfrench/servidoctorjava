/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.Paises;
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
/*  16:    */ public class PaisDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list()
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 19 */     ArrayList list = new ArrayList();
/*  23: 20 */     Connection conn = null;
/*  24: 21 */     PreparedStatement pstmt = null;
/*  25: 22 */     ResultSet rs = null;
/*  26: 23 */     Paises paisS = new Paises();
/*  27:    */     try
/*  28:    */     {
/*  29: 25 */       conn = this.ds.getConnection();
/*  30: 26 */       DBUtil db = new DBUtil();
/*  31:    */       
/*  32: 28 */       String sql = db.creaSQLSELECT(paisS);
/*  33: 29 */       pstmt = conn.prepareStatement(sql);
/*  34: 30 */       rs = pstmt.executeQuery();
/*  35: 31 */       while (rs.next())
/*  36:    */       {
/*  37: 32 */         Paises pais = new Paises();
/*  38: 33 */         InicializaData.inicializa(pais.getClass(), pais);
/*  39: 34 */         populate(pais, rs);
/*  40: 35 */         list.add(pais);
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
/*  59:    */   public Paises retrive(BigDecimal pais_cod)
/*  60:    */     throws SQLException
/*  61:    */   {
/*  62: 51 */     Paises pais = new Paises();
/*  63: 52 */     Connection conn = null;
/*  64: 53 */     PreparedStatement pstmt = null;
/*  65: 54 */     ResultSet rs = null;
/*  66: 55 */     Paises paisS = new Paises();
/*  67:    */     try
/*  68:    */     {
/*  69: 57 */       conn = this.ds.getConnection();
/*  70: 58 */       DBUtil db = new DBUtil();
/*  71: 59 */       String sql = db.creaSQLSELECT(paisS);
/*  72: 60 */       String where = " where pais_cod=" + pais_cod;
/*  73: 61 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  74: 62 */       rs = pstmt.executeQuery();
/*  75: 63 */       if (rs.next())
/*  76:    */       {
/*  77: 65 */         InicializaData.inicializa(pais.getClass(), pais);
/*  78: 66 */         populate(pais, rs);
/*  79:    */       }
/*  80: 69 */       close(rs);
/*  81: 70 */       close(pstmt);
/*  82:    */     }
/*  83:    */     catch (SQLException e)
/*  84:    */     {
/*  85: 72 */       close(rs);
/*  86: 73 */       close(pstmt);
/*  87: 74 */       rollback(conn);
/*  88: 75 */       throw e;
/*  89:    */     }
/*  90:    */     finally
/*  91:    */     {
/*  92: 77 */       close(conn);
/*  93:    */     }
/*  94: 79 */     return pais;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public synchronized void insert(Paises data)
/*  98:    */     throws SQLException
/*  99:    */   {
/* 100: 82 */     Connection conn = null;
/* 101: 83 */     PreparedStatement pstmt = null;
/* 102:    */     
/* 103: 85 */     ResultSet rs = null;
/* 104:    */     try
/* 105:    */     {
/* 106: 87 */       int id = 0;
/* 107: 88 */       DBUtil db = new DBUtil();
/* 108:    */       
/* 109: 90 */       conn = this.ds.getConnection();
/* 110: 91 */       conn.setAutoCommit(false);
/* 111: 92 */       id = getReqMax(conn);
/* 112: 93 */       data.setPais_cod(new BigDecimal(id));
/* 113: 94 */       String sql = db.creaSQLINSERT(data);
/* 114:    */       
/* 115: 96 */       pstmt = conn.prepareStatement(sql);
/* 116: 97 */       pstmt.executeUpdate();
/* 117: 98 */       pstmt.close();
/* 118: 99 */       conn.commit();
/* 119:    */     }
/* 120:    */     catch (SQLException sqle)
/* 121:    */     {
/* 122:101 */       close(rs);
/* 123:102 */       close(pstmt);
/* 124:103 */       rollback(conn);
/* 125:104 */       throw sqle;
/* 126:    */     }
/* 127:    */     finally
/* 128:    */     {
/* 129:106 */       close(rs);
/* 130:107 */       close(pstmt);
/* 131:108 */       close(conn);
/* 132:    */     }
/* 133:    */   }
/* 134:    */   
/* 135:    */   public void update(Paises data, String[] llaves)
/* 136:    */     throws SQLException
/* 137:    */   {
/* 138:112 */     Connection conn = null;
/* 139:113 */     PreparedStatement pstmt = null;
/* 140:    */     try
/* 141:    */     {
/* 142:115 */       DBUtil db = new DBUtil();
/* 143:    */       
/* 144:117 */       conn = this.ds.getConnection();
/* 145:118 */       conn.setAutoCommit(false);
/* 146:119 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 147:120 */       pstmt = conn.prepareStatement(sql);
/* 148:121 */       pstmt.executeUpdate();
/* 149:122 */       close(pstmt);
/* 150:123 */       conn.commit();
/* 151:    */     }
/* 152:    */     catch (SQLException e)
/* 153:    */     {
/* 154:125 */       close(pstmt);
/* 155:126 */       rollback(conn);
/* 156:127 */       throw e;
/* 157:    */     }
/* 158:    */     finally
/* 159:    */     {
/* 160:129 */       close(conn);
/* 161:    */     }
/* 162:    */   }
/* 163:    */   
/* 164:    */   public void delete(Paises data)
/* 165:    */     throws SQLException
/* 166:    */   {
/* 167:133 */     Connection conn = null;
/* 168:134 */     PreparedStatement pstmt = null;
/* 169:135 */     PreparedStatement pstmt2 = null;
/* 170:    */     try
/* 171:    */     {
/* 172:137 */       conn = this.ds.getConnection();
/* 173:138 */       conn.setAutoCommit(false);
/* 174:139 */       String sql = "DELETE FROM sdoctor.paises WHERE pais_cod=?";
/* 175:140 */       pstmt = conn.prepareStatement(sql);
/* 176:141 */       pstmt.setBigDecimal(1, data.getPais_cod());
/* 177:142 */       pstmt.executeUpdate();
/* 178:    */       
/* 179:144 */       sql = "DELETE FROM sdoctor.ciudades WHERE pais_cod=?";
/* 180:145 */       pstmt2 = conn.prepareStatement(sql);
/* 181:146 */       pstmt2.setBigDecimal(1, data.getPais_cod());
/* 182:147 */       pstmt2.executeUpdate();
/* 183:    */       
/* 184:149 */       close(pstmt);
/* 185:150 */       close(pstmt2);
/* 186:151 */       conn.commit();
/* 187:    */     }
/* 188:    */     catch (SQLException e)
/* 189:    */     {
/* 190:153 */       close(pstmt);
/* 191:154 */       close(pstmt2);
/* 192:155 */       rollback(conn);
/* 193:156 */       throw e;
/* 194:    */     }
/* 195:    */     finally
/* 196:    */     {
/* 197:158 */       close(conn);
/* 198:    */     }
/* 199:    */   }
/* 200:    */   
/* 201:    */   private int getReqMax(Connection conn)
/* 202:    */   {
/* 203:162 */     PreparedStatement pstmt = null;
/* 204:163 */     ResultSet rs = null;
/* 205:164 */     int id = 0;
/* 206:    */     try
/* 207:    */     {
/* 208:166 */       String sqlid = "Select max(pais_cod) from sdoctor.paises";
/* 209:167 */       pstmt = conn.prepareStatement(sqlid);
/* 210:168 */       rs = pstmt.executeQuery();
/* 211:169 */       if ((rs != null) && (rs.next())) {
/* 212:170 */         id = rs.getInt(1) + 1;
/* 213:    */       } else {
/* 214:172 */         id++;
/* 215:    */       }
/* 216:    */     }
/* 217:    */     catch (SQLException e)
/* 218:    */     {
/* 219:176 */       close(rs);
/* 220:177 */       close(pstmt);
/* 221:178 */       rollback(conn);
/* 222:179 */       e.printStackTrace();
/* 223:    */     }
/* 224:    */     finally
/* 225:    */     {
/* 226:181 */       close(rs);
/* 227:182 */       close(pstmt);
/* 228:    */     }
/* 229:184 */     return id;
/* 230:    */   }
/* 231:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.PaisDAO
 * JD-Core Version:    0.7.0.1
 */