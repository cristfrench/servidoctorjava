/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.Sistemas;
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
/*  16:    */ public class SistemasDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list()
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 19 */     ArrayList list = new ArrayList();
/*  23: 20 */     Connection conn = null;
/*  24: 21 */     PreparedStatement pstmt = null;
/*  25: 22 */     ResultSet rs = null;
/*  26: 23 */     Sistemas sistemasS = new Sistemas();
/*  27:    */     try
/*  28:    */     {
/*  29: 25 */       conn = this.ds.getConnection();
/*  30: 26 */       DBUtil db = new DBUtil();
/*  31: 27 */       if (this.idioma != null) {
/*  32: 28 */         db.setIdioma(this.idioma);
/*  33:    */       }
/*  34: 30 */       String sql = db.creaSQLSELECT(sistemasS);
/*  35: 31 */       pstmt = conn.prepareStatement(sql + " order by sis_desc");
/*  36: 32 */       rs = pstmt.executeQuery();
/*  37: 33 */       while (rs.next())
/*  38:    */       {
/*  39: 34 */         Sistemas sistema = new Sistemas();
/*  40: 35 */         InicializaData.inicializa(sistema.getClass(), sistema);
/*  41: 36 */         populate(sistema, rs);
/*  42: 37 */         list.add(sistema);
/*  43:    */       }
/*  44: 39 */       close(rs);
/*  45: 40 */       close(pstmt);
/*  46:    */     }
/*  47:    */     catch (SQLException e)
/*  48:    */     {
/*  49: 42 */       close(rs);
/*  50: 43 */       close(pstmt);
/*  51: 44 */       rollback(conn);
/*  52: 45 */       throw e;
/*  53:    */     }
/*  54:    */     finally
/*  55:    */     {
/*  56: 47 */       close(conn);
/*  57:    */     }
/*  58: 49 */     return list;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public Sistemas retrive(BigDecimal sis_cod)
/*  62:    */     throws SQLException
/*  63:    */   {
/*  64: 53 */     Sistemas sistema = new Sistemas();
/*  65: 54 */     Connection conn = null;
/*  66: 55 */     PreparedStatement pstmt = null;
/*  67: 56 */     ResultSet rs = null;
/*  68: 57 */     Sistemas sistemasS = new Sistemas();
/*  69:    */     try
/*  70:    */     {
/*  71: 59 */       conn = this.ds.getConnection();
/*  72: 60 */       DBUtil db = new DBUtil();
/*  73: 61 */       if (this.idioma != null) {
/*  74: 62 */         db.setIdioma(this.idioma);
/*  75:    */       }
/*  76: 64 */       String sql = db.creaSQLSELECT(sistemasS);
/*  77: 65 */       String where = " where sis_cod=" + sis_cod;
/*  78: 66 */       pstmt = conn.prepareStatement(sql + where);
/*  79: 67 */       rs = pstmt.executeQuery();
/*  80: 68 */       if (rs.next())
/*  81:    */       {
/*  82: 70 */         InicializaData.inicializa(sistema.getClass(), sistema);
/*  83: 71 */         populate(sistema, rs);
/*  84:    */       }
/*  85: 74 */       close(rs);
/*  86: 75 */       close(pstmt);
/*  87:    */     }
/*  88:    */     catch (SQLException e)
/*  89:    */     {
/*  90: 77 */       close(rs);
/*  91: 78 */       close(pstmt);
/*  92: 79 */       rollback(conn);
/*  93: 80 */       throw e;
/*  94:    */     }
/*  95:    */     finally
/*  96:    */     {
/*  97: 82 */       close(conn);
/*  98:    */     }
/*  99: 84 */     return sistema;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public void update(Sistemas data, String[] llaves)
/* 103:    */     throws SQLException
/* 104:    */   {
/* 105: 87 */     Connection conn = null;
/* 106: 88 */     PreparedStatement pstmt = null;
/* 107:    */     try
/* 108:    */     {
/* 109: 90 */       DBUtil db = new DBUtil();
/* 110: 91 */       if (this.idioma != null) {
/* 111: 92 */         db.setIdioma(this.idioma);
/* 112:    */       }
/* 113: 94 */       conn = this.ds.getConnection();
/* 114: 95 */       conn.setAutoCommit(false);
/* 115: 96 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 116: 97 */       pstmt = conn.prepareStatement(sql);
/* 117: 98 */       pstmt.executeUpdate();
/* 118: 99 */       close(pstmt);
/* 119:100 */       conn.commit();
/* 120:    */     }
/* 121:    */     catch (SQLException e)
/* 122:    */     {
/* 123:102 */       close(pstmt);
/* 124:103 */       rollback(conn);
/* 125:104 */       throw e;
/* 126:    */     }
/* 127:    */     finally
/* 128:    */     {
/* 129:106 */       close(conn);
/* 130:    */     }
/* 131:    */   }
/* 132:    */   
/* 133:    */   public synchronized void insert(Sistemas data)
/* 134:    */     throws SQLException
/* 135:    */   {
/* 136:110 */     Connection conn = null;
/* 137:111 */     PreparedStatement pstmt = null;
/* 138:    */     try
/* 139:    */     {
/* 140:114 */       int id = 0;
/* 141:115 */       DBUtil db = new DBUtil();
/* 142:116 */       if (this.idioma != null) {
/* 143:117 */         db.setIdioma(this.idioma);
/* 144:    */       }
/* 145:120 */       conn = this.ds.getConnection();
/* 146:121 */       conn.setAutoCommit(false);
/* 147:122 */       id = getReqMax(conn);
/* 148:123 */       data.setSis_cod(new BigDecimal(id));
/* 149:124 */       String sql = db.creaSQLINSERT(data);
/* 150:    */       
/* 151:126 */       pstmt = conn.prepareStatement(sql);
/* 152:127 */       pstmt.executeUpdate();
/* 153:128 */       pstmt.close();
/* 154:129 */       conn.commit();
/* 155:    */     }
/* 156:    */     catch (SQLException sqle)
/* 157:    */     {
/* 158:131 */       close(pstmt);
/* 159:132 */       rollback(conn);
/* 160:133 */       throw sqle;
/* 161:    */     }
/* 162:    */     finally
/* 163:    */     {
/* 164:135 */       close(pstmt);
/* 165:136 */       close(conn);
/* 166:    */     }
/* 167:    */   }
/* 168:    */   
/* 169:    */   public void delete(Sistemas data)
/* 170:    */     throws SQLException
/* 171:    */   {
/* 172:141 */     Connection conn = null;
/* 173:142 */     PreparedStatement pstmt = null;
/* 174:143 */     PreparedStatement pstmt2 = null;
/* 175:    */     try
/* 176:    */     {
/* 177:145 */       conn = this.ds.getConnection();
/* 178:146 */       conn.setAutoCommit(false);
/* 179:147 */       String sql = "DELETE FROM sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".sistemas WHERE sis_cod=?";
/* 180:148 */       pstmt = conn.prepareStatement(sql);
/* 181:149 */       pstmt.setBigDecimal(1, data.getSis_cod());
/* 182:150 */       pstmt.executeUpdate();
/* 183:    */       
/* 184:152 */       sql = "DELETE FROM sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".enfermedades WHERE enf_sis_cod=?";
/* 185:153 */       pstmt2 = conn.prepareStatement(sql);
/* 186:154 */       pstmt2.setBigDecimal(1, data.getSis_cod());
/* 187:155 */       pstmt2.executeUpdate();
/* 188:    */       
/* 189:157 */       close(pstmt);
/* 190:158 */       conn.commit();
/* 191:    */     }
/* 192:    */     catch (SQLException e)
/* 193:    */     {
/* 194:160 */       close(pstmt);
/* 195:161 */       rollback(conn);
/* 196:162 */       throw e;
/* 197:    */     }
/* 198:    */     finally
/* 199:    */     {
/* 200:164 */       close(conn);
/* 201:    */     }
/* 202:    */   }
/* 203:    */   
/* 204:    */   private int getReqMax(Connection conn)
/* 205:    */   {
/* 206:168 */     PreparedStatement pstmt = null;
/* 207:169 */     ResultSet rs = null;
/* 208:170 */     int id = 0;
/* 209:    */     try
/* 210:    */     {
/* 211:172 */       String sqlid = "Select max(sis_cod) from sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".sistemas ";
/* 212:173 */       pstmt = conn.prepareStatement(sqlid);
/* 213:174 */       rs = pstmt.executeQuery();
/* 214:175 */       if ((rs != null) && (rs.next())) {
/* 215:176 */         id = rs.getInt(1) + 1;
/* 216:    */       } else {
/* 217:178 */         id++;
/* 218:    */       }
/* 219:    */     }
/* 220:    */     catch (SQLException e)
/* 221:    */     {
/* 222:182 */       close(rs);
/* 223:183 */       close(pstmt);
/* 224:184 */       rollback(conn);
/* 225:185 */       e.printStackTrace();
/* 226:    */     }
/* 227:    */     finally
/* 228:    */     {
/* 229:187 */       close(rs);
/* 230:188 */       close(pstmt);
/* 231:    */     }
/* 232:190 */     return id;
/* 233:    */   }
/* 234:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.SistemasDAO
 * JD-Core Version:    0.7.0.1
 */