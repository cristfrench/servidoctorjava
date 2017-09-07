/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.GinecologiaOperaciones;
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
/*  16:    */ public class GinecologiaOperacionesDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list()
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 19 */     ArrayList list = new ArrayList();
/*  23: 20 */     Connection conn = null;
/*  24: 21 */     PreparedStatement pstmt = null;
/*  25: 22 */     ResultSet rs = null;
/*  26: 23 */     GinecologiaOperaciones ginecologiaOperacionesS = new GinecologiaOperaciones();
/*  27:    */     try
/*  28:    */     {
/*  29: 25 */       conn = this.ds.getConnection();
/*  30: 26 */       DBUtil db = new DBUtil();
/*  31: 26 */       if (this.idioma != null) {
/*  32: 26 */         db.setIdioma(this.idioma);
/*  33:    */       }
/*  34: 27 */       String sql = db.creaSQLSELECT(ginecologiaOperacionesS);
/*  35: 28 */       pstmt = conn.prepareStatement(sql + " order by gope_des");
/*  36:    */       
/*  37: 30 */       rs = pstmt.executeQuery();
/*  38: 31 */       while (rs.next())
/*  39:    */       {
/*  40: 32 */         GinecologiaOperaciones ginecologiaOperaciones = new GinecologiaOperaciones();
/*  41: 33 */         InicializaData.inicializa(ginecologiaOperaciones.getClass(), ginecologiaOperaciones);
/*  42: 34 */         populate(ginecologiaOperaciones, rs);
/*  43: 35 */         list.add(ginecologiaOperaciones);
/*  44:    */       }
/*  45: 37 */       close(rs);
/*  46: 38 */       close(pstmt);
/*  47:    */     }
/*  48:    */     catch (SQLException e)
/*  49:    */     {
/*  50: 40 */       close(rs);
/*  51: 41 */       close(pstmt);
/*  52: 42 */       rollback(conn);
/*  53: 43 */       throw e;
/*  54:    */     }
/*  55:    */     finally
/*  56:    */     {
/*  57: 45 */       close(conn);
/*  58:    */     }
/*  59: 47 */     return list;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public GinecologiaOperaciones retrive(BigDecimal gope_cod)
/*  63:    */     throws SQLException
/*  64:    */   {
/*  65: 52 */     GinecologiaOperaciones ginecologiaOperaciones = new GinecologiaOperaciones();
/*  66: 53 */     Connection conn = null;
/*  67: 54 */     PreparedStatement pstmt = null;
/*  68: 55 */     ResultSet rs = null;
/*  69: 56 */     GinecologiaOperaciones ginecologiaOperacionesS = new GinecologiaOperaciones();
/*  70:    */     try
/*  71:    */     {
/*  72: 58 */       conn = this.ds.getConnection();
/*  73: 59 */       DBUtil db = new DBUtil();
/*  74: 59 */       if (this.idioma != null) {
/*  75: 59 */         db.setIdioma(this.idioma);
/*  76:    */       }
/*  77: 60 */       String sql = db.creaSQLSELECT(ginecologiaOperacionesS);
/*  78: 61 */       String where = " where gope_cod=" + gope_cod;
/*  79: 62 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  80: 63 */       rs = pstmt.executeQuery();
/*  81: 64 */       if (rs.next())
/*  82:    */       {
/*  83: 65 */         InicializaData.inicializa(ginecologiaOperaciones.getClass(), ginecologiaOperaciones);
/*  84: 66 */         populate(ginecologiaOperaciones, rs);
/*  85:    */       }
/*  86: 68 */       close(rs);
/*  87: 69 */       close(pstmt);
/*  88:    */     }
/*  89:    */     catch (SQLException e)
/*  90:    */     {
/*  91: 71 */       close(rs);
/*  92: 72 */       close(pstmt);
/*  93: 73 */       rollback(conn);
/*  94: 74 */       throw e;
/*  95:    */     }
/*  96:    */     finally
/*  97:    */     {
/*  98: 76 */       close(conn);
/*  99:    */     }
/* 100: 78 */     return ginecologiaOperaciones;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public void update(GinecologiaOperaciones data, String[] llaves)
/* 104:    */     throws SQLException
/* 105:    */   {
/* 106: 82 */     Connection conn = null;
/* 107: 83 */     PreparedStatement pstmt = null;
/* 108:    */     try
/* 109:    */     {
/* 110: 85 */       DBUtil db = new DBUtil();
/* 111: 85 */       if (this.idioma != null) {
/* 112: 85 */         db.setIdioma(this.idioma);
/* 113:    */       }
/* 114: 86 */       conn = this.ds.getConnection();
/* 115: 87 */       conn.setAutoCommit(false);
/* 116: 88 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 117: 89 */       pstmt = conn.prepareStatement(sql);
/* 118: 90 */       pstmt.executeUpdate();
/* 119: 91 */       close(pstmt);
/* 120: 92 */       conn.commit();
/* 121:    */     }
/* 122:    */     catch (SQLException e)
/* 123:    */     {
/* 124: 94 */       close(pstmt);
/* 125: 95 */       rollback(conn);
/* 126: 96 */       throw e;
/* 127:    */     }
/* 128:    */     finally
/* 129:    */     {
/* 130: 98 */       close(conn);
/* 131:    */     }
/* 132:    */   }
/* 133:    */   
/* 134:    */   public synchronized void insert(GinecologiaOperaciones data)
/* 135:    */     throws SQLException
/* 136:    */   {
/* 137:103 */     Connection conn = null;
/* 138:104 */     PreparedStatement pstmt = null;
/* 139:    */     
/* 140:106 */     ResultSet rs = null;
/* 141:    */     try
/* 142:    */     {
/* 143:108 */       int id = 0;
/* 144:109 */       DBUtil db = new DBUtil();
/* 145:109 */       if (this.idioma != null) {
/* 146:109 */         db.setIdioma(this.idioma);
/* 147:    */       }
/* 148:111 */       conn = this.ds.getConnection();
/* 149:112 */       conn.setAutoCommit(false);
/* 150:113 */       id = getReqMax(conn);
/* 151:114 */       data.setGope_cod(new BigDecimal(id));
/* 152:115 */       String sql = db.creaSQLINSERT(data);
/* 153:    */       
/* 154:117 */       pstmt = conn.prepareStatement(sql);
/* 155:118 */       pstmt.executeUpdate();
/* 156:119 */       pstmt.close();
/* 157:120 */       conn.commit();
/* 158:    */     }
/* 159:    */     catch (SQLException sqle)
/* 160:    */     {
/* 161:122 */       close(rs);
/* 162:123 */       close(pstmt);
/* 163:124 */       rollback(conn);
/* 164:125 */       throw sqle;
/* 165:    */     }
/* 166:    */     finally
/* 167:    */     {
/* 168:127 */       close(rs);
/* 169:128 */       close(pstmt);
/* 170:129 */       close(conn);
/* 171:    */     }
/* 172:    */   }
/* 173:    */   
/* 174:    */   public void delete(GinecologiaOperaciones data)
/* 175:    */     throws SQLException
/* 176:    */   {
/* 177:134 */     Connection conn = null;
/* 178:135 */     PreparedStatement pstmt = null;
/* 179:    */     try
/* 180:    */     {
/* 181:137 */       conn = this.ds.getConnection();
/* 182:138 */       conn.setAutoCommit(false);
/* 183:139 */       String sql = "DELETE FROM sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".ginecologiaoperaciones WHERE gope_cod=?";
/* 184:140 */       pstmt = conn.prepareStatement(sql);
/* 185:141 */       pstmt.setBigDecimal(1, data.getGope_cod());
/* 186:142 */       pstmt.executeUpdate();
/* 187:143 */       close(pstmt);
/* 188:144 */       conn.commit();
/* 189:    */     }
/* 190:    */     catch (SQLException e)
/* 191:    */     {
/* 192:146 */       close(pstmt);
/* 193:147 */       rollback(conn);
/* 194:148 */       throw e;
/* 195:    */     }
/* 196:    */     finally
/* 197:    */     {
/* 198:150 */       close(conn);
/* 199:    */     }
/* 200:    */   }
/* 201:    */   
/* 202:    */   private int getReqMax(Connection conn)
/* 203:    */   {
/* 204:155 */     PreparedStatement pstmt = null;
/* 205:156 */     ResultSet rs = null;
/* 206:157 */     int id = 0;
/* 207:    */     try
/* 208:    */     {
/* 209:159 */       String sqlid = "Select max(gope_cod) from sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".ginecologiaoperaciones";
/* 210:160 */       pstmt = conn.prepareStatement(sqlid);
/* 211:161 */       rs = pstmt.executeQuery();
/* 212:162 */       if ((rs != null) && (rs.next())) {
/* 213:163 */         id = rs.getInt(1) + 1;
/* 214:    */       } else {
/* 215:165 */         id++;
/* 216:    */       }
/* 217:    */     }
/* 218:    */     catch (SQLException e)
/* 219:    */     {
/* 220:169 */       close(rs);
/* 221:170 */       close(pstmt);
/* 222:171 */       rollback(conn);
/* 223:172 */       e.printStackTrace();
/* 224:    */     }
/* 225:    */     finally
/* 226:    */     {
/* 227:174 */       close(rs);
/* 228:175 */       close(pstmt);
/* 229:    */     }
/* 230:177 */     return id;
/* 231:    */   }
/* 232:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.GinecologiaOperacionesDAO
 * JD-Core Version:    0.7.0.1
 */