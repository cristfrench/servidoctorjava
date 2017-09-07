/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.GastosMecanica;
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
/*  16:    */ public class GastosMecanicaDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list()
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 19 */     ArrayList list = new ArrayList();
/*  23: 20 */     Connection conn = null;
/*  24: 21 */     PreparedStatement pstmt = null;
/*  25: 22 */     ResultSet rs = null;
/*  26: 23 */     GastosMecanica gastoMecanicaS = new GastosMecanica();
/*  27:    */     try
/*  28:    */     {
/*  29: 25 */       conn = this.ds.getConnection();
/*  30: 26 */       DBUtil db = new DBUtil();
/*  31: 27 */       if (this.idioma != null) {
/*  32: 28 */         db.setIdioma(this.idioma);
/*  33:    */       }
/*  34: 31 */       String sql = db.creaSQLSELECT(gastoMecanicaS);
/*  35: 32 */       pstmt = conn.prepareStatement(sql + " where gas_cod > 0");
/*  36: 33 */       rs = pstmt.executeQuery();
/*  37: 34 */       while (rs.next())
/*  38:    */       {
/*  39: 35 */         GastosMecanica gastoMecanica = new GastosMecanica();
/*  40: 36 */         InicializaData.inicializa(gastoMecanica.getClass(), gastoMecanica);
/*  41: 37 */         populate(gastoMecanica, rs);
/*  42: 38 */         list.add(gastoMecanica);
/*  43:    */       }
/*  44:    */     }
/*  45:    */     catch (SQLException e)
/*  46:    */     {
/*  47: 41 */       rollback(conn);
/*  48: 42 */       throw e;
/*  49:    */     }
/*  50:    */     finally
/*  51:    */     {
/*  52: 44 */       close(rs);
/*  53: 45 */       close(pstmt);
/*  54: 46 */       close(conn);
/*  55:    */     }
/*  56: 48 */     return list;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public GastosMecanica retrive(BigDecimal gas_cod)
/*  60:    */     throws SQLException
/*  61:    */   {
/*  62: 53 */     GastosMecanica gastoMecanica = new GastosMecanica();
/*  63: 54 */     Connection conn = null;
/*  64: 55 */     PreparedStatement pstmt = null;
/*  65: 56 */     ResultSet rs = null;
/*  66: 57 */     GastosMecanica gastoMecanicaS = new GastosMecanica();
/*  67:    */     try
/*  68:    */     {
/*  69: 59 */       conn = this.ds.getConnection();
/*  70: 60 */       DBUtil db = new DBUtil();
/*  71: 61 */       if (this.idioma != null) {
/*  72: 62 */         db.setIdioma(this.idioma);
/*  73:    */       }
/*  74: 65 */       String sql = db.creaSQLSELECT(gastoMecanicaS);
/*  75: 66 */       String where = " where gas_cod=" + gas_cod;
/*  76: 67 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  77: 68 */       rs = pstmt.executeQuery();
/*  78: 69 */       if (rs.next())
/*  79:    */       {
/*  80: 71 */         InicializaData.inicializa(gastoMecanica.getClass(), gastoMecanica);
/*  81: 72 */         populate(gastoMecanica, rs);
/*  82:    */       }
/*  83:    */     }
/*  84:    */     catch (SQLException e)
/*  85:    */     {
/*  86: 76 */       rollback(conn);
/*  87: 77 */       throw e;
/*  88:    */     }
/*  89:    */     finally
/*  90:    */     {
/*  91: 79 */       close(rs);
/*  92: 80 */       close(pstmt);
/*  93: 81 */       close(conn);
/*  94:    */     }
/*  95: 83 */     return gastoMecanica;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public synchronized void insert(GastosMecanica data)
/*  99:    */     throws SQLException
/* 100:    */   {
/* 101: 87 */     Connection conn = null;
/* 102: 88 */     PreparedStatement pstmt = null;
/* 103:    */     try
/* 104:    */     {
/* 105: 90 */       int id = 0;
/* 106: 91 */       DBUtil db = new DBUtil();
/* 107: 92 */       if (this.idioma != null) {
/* 108: 93 */         db.setIdioma(this.idioma);
/* 109:    */       }
/* 110: 96 */       conn = this.ds.getConnection();
/* 111: 97 */       conn.setAutoCommit(false);
/* 112: 98 */       id = getReqMax(conn);
/* 113: 99 */       data.setGas_cod(new BigDecimal(id));
/* 114:100 */       String sql = db.creaSQLINSERT(data);
/* 115:    */       
/* 116:102 */       pstmt = conn.prepareStatement(sql);
/* 117:103 */       pstmt.executeUpdate();
/* 118:104 */       conn.commit();
/* 119:    */     }
/* 120:    */     catch (SQLException sqle)
/* 121:    */     {
/* 122:106 */       rollback(conn);
/* 123:107 */       throw sqle;
/* 124:    */     }
/* 125:    */     finally
/* 126:    */     {
/* 127:109 */       close(pstmt);
/* 128:110 */       close(conn);
/* 129:    */     }
/* 130:    */   }
/* 131:    */   
/* 132:    */   public void update(GastosMecanica data, String[] llaves)
/* 133:    */     throws SQLException
/* 134:    */   {
/* 135:114 */     Connection conn = null;
/* 136:115 */     PreparedStatement pstmt = null;
/* 137:    */     try
/* 138:    */     {
/* 139:117 */       DBUtil db = new DBUtil();
/* 140:118 */       if (this.idioma != null) {
/* 141:119 */         db.setIdioma(this.idioma);
/* 142:    */       }
/* 143:122 */       conn = this.ds.getConnection();
/* 144:123 */       conn.setAutoCommit(false);
/* 145:124 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 146:125 */       pstmt = conn.prepareStatement(sql);
/* 147:126 */       pstmt.executeUpdate();
/* 148:127 */       conn.commit();
/* 149:    */     }
/* 150:    */     catch (SQLException e)
/* 151:    */     {
/* 152:129 */       rollback(conn);
/* 153:130 */       throw e;
/* 154:    */     }
/* 155:    */     finally
/* 156:    */     {
/* 157:132 */       close(pstmt);
/* 158:133 */       close(conn);
/* 159:    */     }
/* 160:    */   }
/* 161:    */   
/* 162:    */   public void delete(GastosMecanica data)
/* 163:    */     throws SQLException
/* 164:    */   {
/* 165:137 */     Connection conn = null;
/* 166:138 */     PreparedStatement pstmt = null;
/* 167:    */     try
/* 168:    */     {
/* 169:140 */       conn = this.ds.getConnection();
/* 170:141 */       conn.setAutoCommit(false);
/* 171:142 */       String sql = "DELETE FROM sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".gastoMecanicaes WHERE gas_cod=?";
/* 172:143 */       pstmt = conn.prepareStatement(sql);
/* 173:144 */       pstmt.setBigDecimal(1, data.getGas_cod());
/* 174:145 */       pstmt.executeUpdate();
/* 175:146 */       conn.commit();
/* 176:    */     }
/* 177:    */     catch (SQLException e)
/* 178:    */     {
/* 179:148 */       rollback(conn);
/* 180:149 */       throw e;
/* 181:    */     }
/* 182:    */     finally
/* 183:    */     {
/* 184:151 */       close(pstmt);
/* 185:152 */       close(conn);
/* 186:    */     }
/* 187:    */   }
/* 188:    */   
/* 189:    */   private int getReqMax(Connection conn)
/* 190:    */     throws SQLException
/* 191:    */   {
/* 192:156 */     PreparedStatement pstmt = null;
/* 193:157 */     ResultSet rs = null;
/* 194:158 */     int id = 0;
/* 195:    */     try
/* 196:    */     {
/* 197:160 */       String sqlid = "Select max(gas_cod) from sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".gastosmecanica";
/* 198:161 */       pstmt = conn.prepareStatement(sqlid);
/* 199:162 */       rs = pstmt.executeQuery();
/* 200:163 */       if ((rs != null) && (rs.next())) {
/* 201:164 */         id = rs.getInt(1) + 1;
/* 202:    */       } else {
/* 203:166 */         id++;
/* 204:    */       }
/* 205:    */     }
/* 206:    */     catch (SQLException e)
/* 207:    */     {
/* 208:170 */       rollback(conn);
/* 209:171 */       throw e;
/* 210:    */     }
/* 211:    */     finally
/* 212:    */     {
/* 213:173 */       close(rs);
/* 214:174 */       close(pstmt);
/* 215:    */     }
/* 216:176 */     return id;
/* 217:    */   }
/* 218:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.GastosMecanicaDAO
 * JD-Core Version:    0.7.0.1
 */