/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.PartesCuerpo;
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
/*  16:    */ public class PartesCuerpoDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list()
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 19 */     ArrayList list = new ArrayList();
/*  23: 20 */     Connection conn = null;
/*  24: 21 */     PreparedStatement pstmt = null;
/*  25: 22 */     ResultSet rs = null;
/*  26: 23 */     PartesCuerpo partesCuerpoS = new PartesCuerpo();
/*  27:    */     try
/*  28:    */     {
/*  29: 25 */       conn = this.ds.getConnection();
/*  30: 26 */       DBUtil db = new DBUtil();
/*  31: 27 */       if (this.idioma != null) {
/*  32: 28 */         db.setIdioma(this.idioma);
/*  33:    */       }
/*  34: 30 */       String sql = db.creaSQLSELECT(partesCuerpoS);
/*  35: 31 */       pstmt = conn.prepareStatement(sql);
/*  36: 32 */       rs = pstmt.executeQuery();
/*  37: 33 */       while (rs.next())
/*  38:    */       {
/*  39: 34 */         PartesCuerpo partesCuerpo = new PartesCuerpo();
/*  40: 35 */         InicializaData.inicializa(partesCuerpo.getClass(), partesCuerpo);
/*  41: 36 */         populate(partesCuerpo, rs);
/*  42: 37 */         list.add(partesCuerpo);
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
/*  61:    */   public PartesCuerpo retrive(BigDecimal pcue_cod)
/*  62:    */     throws SQLException
/*  63:    */   {
/*  64: 54 */     PartesCuerpo partesCuerpo = new PartesCuerpo();
/*  65: 55 */     Connection conn = null;
/*  66: 56 */     PreparedStatement pstmt = null;
/*  67: 57 */     ResultSet rs = null;
/*  68: 58 */     PartesCuerpo partesCuerpoS = new PartesCuerpo();
/*  69:    */     try
/*  70:    */     {
/*  71: 60 */       conn = this.ds.getConnection();
/*  72: 61 */       DBUtil db = new DBUtil();
/*  73: 62 */       if (this.idioma != null) {
/*  74: 63 */         db.setIdioma(this.idioma);
/*  75:    */       }
/*  76: 65 */       String sql = db.creaSQLSELECT(partesCuerpoS);
/*  77: 66 */       String where = " where pcue_cod=" + pcue_cod;
/*  78: 67 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  79: 68 */       rs = pstmt.executeQuery();
/*  80: 69 */       if (rs.next())
/*  81:    */       {
/*  82: 71 */         InicializaData.inicializa(partesCuerpo.getClass(), partesCuerpo);
/*  83: 72 */         populate(partesCuerpo, rs);
/*  84:    */       }
/*  85: 75 */       close(rs);
/*  86: 76 */       close(pstmt);
/*  87:    */     }
/*  88:    */     catch (SQLException e)
/*  89:    */     {
/*  90: 78 */       close(rs);
/*  91: 79 */       close(pstmt);
/*  92: 80 */       rollback(conn);
/*  93: 81 */       throw e;
/*  94:    */     }
/*  95:    */     finally
/*  96:    */     {
/*  97: 83 */       close(conn);
/*  98:    */     }
/*  99: 85 */     return partesCuerpo;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public void update(PartesCuerpo data, String[] llaves)
/* 103:    */     throws SQLException
/* 104:    */   {
/* 105: 88 */     Connection conn = null;
/* 106: 89 */     PreparedStatement pstmt = null;
/* 107:    */     try
/* 108:    */     {
/* 109: 91 */       DBUtil db = new DBUtil();
/* 110: 92 */       if (this.idioma != null) {
/* 111: 93 */         db.setIdioma(this.idioma);
/* 112:    */       }
/* 113: 95 */       conn = this.ds.getConnection();
/* 114: 96 */       conn.setAutoCommit(false);
/* 115: 97 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 116: 98 */       pstmt = conn.prepareStatement(sql);
/* 117: 99 */       pstmt.executeUpdate();
/* 118:100 */       close(pstmt);
/* 119:101 */       conn.commit();
/* 120:    */     }
/* 121:    */     catch (SQLException e)
/* 122:    */     {
/* 123:103 */       close(pstmt);
/* 124:104 */       rollback(conn);
/* 125:105 */       throw e;
/* 126:    */     }
/* 127:    */     finally
/* 128:    */     {
/* 129:107 */       close(conn);
/* 130:    */     }
/* 131:    */   }
/* 132:    */   
/* 133:    */   public synchronized void insert(PartesCuerpo data)
/* 134:    */     throws SQLException
/* 135:    */   {
/* 136:111 */     Connection conn = null;
/* 137:112 */     PreparedStatement pstmt = null;
/* 138:    */     
/* 139:114 */     ResultSet rs = null;
/* 140:    */     try
/* 141:    */     {
/* 142:116 */       int id = 0;
/* 143:117 */       DBUtil db = new DBUtil();
/* 144:118 */       if (this.idioma != null) {
/* 145:119 */         db.setIdioma(this.idioma);
/* 146:    */       }
/* 147:122 */       conn = this.ds.getConnection();
/* 148:123 */       conn.setAutoCommit(false);
/* 149:124 */       id = getReqMax(conn);
/* 150:125 */       data.setPcue_cod(new BigDecimal(id));
/* 151:126 */       String sql = db.creaSQLINSERT(data);
/* 152:    */       
/* 153:128 */       pstmt = conn.prepareStatement(sql);
/* 154:129 */       pstmt.executeUpdate();
/* 155:130 */       pstmt.close();
/* 156:131 */       conn.commit();
/* 157:    */     }
/* 158:    */     catch (SQLException sqle)
/* 159:    */     {
/* 160:133 */       close(rs);
/* 161:134 */       close(pstmt);
/* 162:135 */       rollback(conn);
/* 163:136 */       throw sqle;
/* 164:    */     }
/* 165:    */     finally
/* 166:    */     {
/* 167:138 */       close(rs);
/* 168:139 */       close(pstmt);
/* 169:140 */       close(conn);
/* 170:    */     }
/* 171:    */   }
/* 172:    */   
/* 173:    */   public void delete(PartesCuerpo data)
/* 174:    */     throws SQLException
/* 175:    */   {
/* 176:145 */     Connection conn = null;
/* 177:146 */     PreparedStatement pstmt = null;
/* 178:    */     try
/* 179:    */     {
/* 180:148 */       conn = this.ds.getConnection();
/* 181:149 */       conn.setAutoCommit(false);
/* 182:150 */       String sql = "DELETE FROM sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".partescuerpo WHERE pcue_cod=?";
/* 183:151 */       pstmt = conn.prepareStatement(sql);
/* 184:152 */       pstmt.setBigDecimal(1, data.getPcue_cod());
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
/* 203:166 */     PreparedStatement pstmt = null;
/* 204:167 */     ResultSet rs = null;
/* 205:168 */     int id = 0;
/* 206:    */     try
/* 207:    */     {
/* 208:170 */       String sqlid = "Select max(pcue_cod) from sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".partescuerpo";
/* 209:171 */       pstmt = conn.prepareStatement(sqlid);
/* 210:172 */       rs = pstmt.executeQuery();
/* 211:173 */       if ((rs != null) && (rs.next())) {
/* 212:174 */         id = rs.getInt(1) + 1;
/* 213:    */       } else {
/* 214:176 */         id++;
/* 215:    */       }
/* 216:    */     }
/* 217:    */     catch (SQLException e)
/* 218:    */     {
/* 219:180 */       close(rs);
/* 220:181 */       close(pstmt);
/* 221:182 */       rollback(conn);
/* 222:183 */       e.printStackTrace();
/* 223:    */     }
/* 224:    */     finally
/* 225:    */     {
/* 226:185 */       close(rs);
/* 227:186 */       close(pstmt);
/* 228:    */     }
/* 229:188 */     return id;
/* 230:    */   }
/* 231:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.PartesCuerpoDAO
 * JD-Core Version:    0.7.0.1
 */