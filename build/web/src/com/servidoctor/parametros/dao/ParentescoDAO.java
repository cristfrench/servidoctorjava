/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.Parentesco;
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
/*  16:    */ public class ParentescoDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list()
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 26 */     ArrayList list = new ArrayList();
/*  23: 27 */     Connection conn = null;
/*  24: 28 */     PreparedStatement pstmt = null;
/*  25: 29 */     ResultSet rs = null;
/*  26: 30 */     Parentesco parentescoS = new Parentesco();
/*  27:    */     try
/*  28:    */     {
/*  29: 32 */       conn = this.ds.getConnection();
/*  30: 33 */       DBUtil db = new DBUtil();
/*  31: 33 */       if (this.idioma != null) {
/*  32: 33 */         db.setIdioma(this.idioma);
/*  33:    */       }
/*  34: 34 */       String sql = db.creaSQLSELECT(parentescoS);
/*  35: 35 */       pstmt = conn.prepareStatement(sql + " order by rfam_des");
/*  36: 36 */       rs = pstmt.executeQuery();
/*  37: 37 */       while (rs.next())
/*  38:    */       {
/*  39: 38 */         Parentesco parentesco = new Parentesco();
/*  40: 39 */         InicializaData.inicializa(parentesco.getClass(), parentesco);
/*  41: 40 */         populate(parentesco, rs);
/*  42: 41 */         list.add(parentesco);
/*  43:    */       }
/*  44: 43 */       close(rs);
/*  45: 44 */       close(pstmt);
/*  46:    */     }
/*  47:    */     catch (SQLException e)
/*  48:    */     {
/*  49: 46 */       close(rs);
/*  50: 47 */       close(pstmt);
/*  51: 48 */       rollback(conn);
/*  52: 49 */       throw e;
/*  53:    */     }
/*  54:    */     finally
/*  55:    */     {
/*  56: 51 */       close(conn);
/*  57:    */     }
/*  58: 53 */     return list;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public Parentesco retrive(BigDecimal rfam_cod)
/*  62:    */     throws SQLException
/*  63:    */   {
/*  64: 56 */     Parentesco parentesco = new Parentesco();
/*  65: 57 */     Connection conn = null;
/*  66: 58 */     PreparedStatement pstmt = null;
/*  67: 59 */     ResultSet rs = null;
/*  68: 60 */     Parentesco parentescoS = new Parentesco();
/*  69:    */     try
/*  70:    */     {
/*  71: 62 */       conn = this.ds.getConnection();
/*  72: 63 */       DBUtil db = new DBUtil();
/*  73: 64 */       if (this.idioma != null) {
/*  74: 65 */         db.setIdioma(this.idioma);
/*  75:    */       }
/*  76: 67 */       String sql = db.creaSQLSELECT(parentescoS);
/*  77: 68 */       String where = " where rfam_cod=" + rfam_cod;
/*  78: 69 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  79: 70 */       rs = pstmt.executeQuery();
/*  80: 71 */       while (rs.next())
/*  81:    */       {
/*  82: 73 */         InicializaData.inicializa(parentesco.getClass(), parentesco);
/*  83: 74 */         populate(parentesco, rs);
/*  84:    */       }
/*  85: 77 */       close(rs);
/*  86: 78 */       close(pstmt);
/*  87:    */     }
/*  88:    */     catch (SQLException e)
/*  89:    */     {
/*  90: 80 */       close(rs);
/*  91: 81 */       close(pstmt);
/*  92: 82 */       rollback(conn);
/*  93: 83 */       throw e;
/*  94:    */     }
/*  95:    */     finally
/*  96:    */     {
/*  97: 85 */       close(conn);
/*  98:    */     }
/*  99: 87 */     return parentesco;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public synchronized void insert(Parentesco data)
/* 103:    */     throws SQLException
/* 104:    */   {
/* 105: 90 */     Connection conn = null;
/* 106: 91 */     PreparedStatement pstmt = null;
/* 107:    */     
/* 108: 93 */     ResultSet rs = null;
/* 109:    */     try
/* 110:    */     {
/* 111: 95 */       int id = 0;
/* 112: 96 */       DBUtil db = new DBUtil();
/* 113: 97 */       if (this.idioma != null) {
/* 114: 98 */         db.setIdioma(this.idioma);
/* 115:    */       }
/* 116:100 */       conn = this.ds.getConnection();
/* 117:101 */       conn.setAutoCommit(false);
/* 118:102 */       id = getReqMax(conn);
/* 119:103 */       data.setRfam_cod(new BigDecimal(id));
/* 120:104 */       String sql = db.creaSQLINSERT(data);
/* 121:    */       
/* 122:106 */       pstmt = conn.prepareStatement(sql);
/* 123:107 */       pstmt.executeUpdate();
/* 124:108 */       pstmt.close();
/* 125:109 */       conn.commit();
/* 126:    */     }
/* 127:    */     catch (SQLException sqle)
/* 128:    */     {
/* 129:111 */       close(rs);
/* 130:112 */       close(pstmt);
/* 131:113 */       rollback(conn);
/* 132:114 */       throw sqle;
/* 133:    */     }
/* 134:    */     finally
/* 135:    */     {
/* 136:116 */       close(rs);
/* 137:117 */       close(pstmt);
/* 138:118 */       close(conn);
/* 139:    */     }
/* 140:    */   }
/* 141:    */   
/* 142:    */   public void update(Parentesco data, String[] llaves)
/* 143:    */     throws SQLException
/* 144:    */   {
/* 145:122 */     Connection conn = null;
/* 146:123 */     PreparedStatement pstmt = null;
/* 147:    */     try
/* 148:    */     {
/* 149:125 */       DBUtil db = new DBUtil();
/* 150:126 */       if (this.idioma != null) {
/* 151:127 */         db.setIdioma(this.idioma);
/* 152:    */       }
/* 153:129 */       conn = this.ds.getConnection();
/* 154:130 */       conn.setAutoCommit(false);
/* 155:131 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 156:132 */       pstmt = conn.prepareStatement(sql);
/* 157:133 */       pstmt.executeUpdate();
/* 158:134 */       close(pstmt);
/* 159:135 */       conn.commit();
/* 160:    */     }
/* 161:    */     catch (SQLException e)
/* 162:    */     {
/* 163:137 */       close(pstmt);
/* 164:138 */       rollback(conn);
/* 165:139 */       throw e;
/* 166:    */     }
/* 167:    */     finally
/* 168:    */     {
/* 169:141 */       close(conn);
/* 170:    */     }
/* 171:    */   }
/* 172:    */   
/* 173:    */   public void delete(Parentesco data)
/* 174:    */     throws SQLException
/* 175:    */   {
/* 176:145 */     Connection conn = null;
/* 177:146 */     PreparedStatement pstmt = null;
/* 178:    */     try
/* 179:    */     {
/* 180:148 */       conn = this.ds.getConnection();
/* 181:149 */       conn.setAutoCommit(false);
/* 182:150 */       String sql = "DELETE FROM sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".parentesco WHERE rfam_cod=?";
/* 183:151 */       pstmt = conn.prepareStatement(sql);
/* 184:152 */       pstmt.setBigDecimal(1, data.getRfam_cod());
/* 185:153 */       pstmt.executeUpdate();
/* 186:154 */       close(pstmt);
/* 187:155 */       conn.commit();
/* 188:    */     }
/* 189:    */     catch (SQLException e)
/* 190:    */     {
/* 191:157 */       close(pstmt);
/* 192:158 */       rollback(conn);
/* 193:159 */       throw e;
/* 194:    */     }
/* 195:    */     finally
/* 196:    */     {
/* 197:161 */       close(conn);
/* 198:    */     }
/* 199:    */   }
/* 200:    */   
/* 201:    */   private int getReqMax(Connection conn)
/* 202:    */   {
/* 203:165 */     PreparedStatement pstmt = null;
/* 204:166 */     ResultSet rs = null;
/* 205:167 */     int id = 0;
/* 206:    */     try
/* 207:    */     {
/* 208:169 */       String sqlid = "Select max(rfam_cod) from sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".parentesco";
/* 209:170 */       pstmt = conn.prepareStatement(sqlid);
/* 210:171 */       rs = pstmt.executeQuery();
/* 211:172 */       if ((rs != null) && (rs.next())) {
/* 212:173 */         id = rs.getInt(1) + 1;
/* 213:    */       } else {
/* 214:175 */         id++;
/* 215:    */       }
/* 216:    */     }
/* 217:    */     catch (SQLException e)
/* 218:    */     {
/* 219:179 */       close(rs);
/* 220:180 */       close(pstmt);
/* 221:181 */       rollback(conn);
/* 222:182 */       e.printStackTrace();
/* 223:    */     }
/* 224:    */     finally
/* 225:    */     {
/* 226:184 */       close(rs);
/* 227:185 */       close(pstmt);
/* 228:    */     }
/* 229:187 */     return id;
/* 230:    */   }
/* 231:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.ParentescoDAO
 * JD-Core Version:    0.7.0.1
 */