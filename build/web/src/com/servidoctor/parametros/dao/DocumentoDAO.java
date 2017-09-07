/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.Documento;
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
/*  16:    */ public class DocumentoDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list()
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 19 */     ArrayList list = new ArrayList();
/*  23: 20 */     Connection conn = null;
/*  24: 21 */     PreparedStatement pstmt = null;
/*  25: 22 */     ResultSet rs = null;
/*  26: 23 */     Documento documentoS = new Documento();
/*  27:    */     try
/*  28:    */     {
/*  29: 25 */       conn = this.ds.getConnection();
/*  30: 26 */       DBUtil db = new DBUtil();
/*  31: 27 */       if (this.idioma != null) {
/*  32: 28 */         db.setIdioma(this.idioma);
/*  33:    */       }
/*  34: 30 */       String sql = db.creaSQLSELECT(documentoS);
/*  35: 31 */       pstmt = conn.prepareStatement(sql + " order by doc_des");
/*  36: 32 */       rs = pstmt.executeQuery();
/*  37: 33 */       while (rs.next())
/*  38:    */       {
/*  39: 34 */         Documento documento = new Documento();
/*  40: 35 */         InicializaData.inicializa(documento.getClass(), documento);
/*  41: 36 */         populate(documento, rs);
/*  42: 37 */         list.add(documento);
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
/*  61:    */   public Documento retrieve(BigDecimal doc_cod)
/*  62:    */     throws SQLException
/*  63:    */   {
/*  64: 54 */     Connection conn = null;
/*  65: 55 */     PreparedStatement pstmt = null;
/*  66: 56 */     ResultSet rs = null;
/*  67: 57 */     Documento documentoS = new Documento();
/*  68: 58 */     Documento documento = new Documento();
/*  69:    */     try
/*  70:    */     {
/*  71: 60 */       conn = this.ds.getConnection();
/*  72: 61 */       DBUtil db = new DBUtil();
/*  73: 62 */       if (this.idioma != null) {
/*  74: 63 */         db.setIdioma(this.idioma);
/*  75:    */       }
/*  76: 65 */       String sql = db.creaSQLSELECT(documentoS) + " where doc_cod = " + doc_cod;
/*  77: 66 */       pstmt = conn.prepareStatement(sql);
/*  78: 67 */       rs = pstmt.executeQuery();
/*  79: 68 */       if (rs.next())
/*  80:    */       {
/*  81: 69 */         documento = new Documento();
/*  82: 70 */         InicializaData.inicializa(documento.getClass(), documento);
/*  83: 71 */         populate(documento, rs);
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
/*  99: 84 */     return documento;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public void update(Documento data, String[] llaves)
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
/* 133:    */   public synchronized void insert(Documento data)
/* 134:    */     throws SQLException
/* 135:    */   {
/* 136:110 */     Connection conn = null;
/* 137:111 */     PreparedStatement pstmt = null;
/* 138:    */     
/* 139:113 */     ResultSet rs = null;
/* 140:    */     try
/* 141:    */     {
/* 142:115 */       int id = 0;
/* 143:116 */       DBUtil db = new DBUtil();
/* 144:117 */       if (this.idioma != null) {
/* 145:118 */         db.setIdioma(this.idioma);
/* 146:    */       }
/* 147:120 */       conn = this.ds.getConnection();
/* 148:121 */       conn.setAutoCommit(false);
/* 149:122 */       id = getReqMax(conn);
/* 150:123 */       data.setDoc_cod(new BigDecimal(id));
/* 151:124 */       String sql = db.creaSQLINSERT(data);
/* 152:    */       
/* 153:126 */       pstmt = conn.prepareStatement(sql);
/* 154:127 */       pstmt.executeUpdate();
/* 155:128 */       pstmt.close();
/* 156:129 */       conn.commit();
/* 157:    */     }
/* 158:    */     catch (SQLException sqle)
/* 159:    */     {
/* 160:131 */       close(rs);
/* 161:132 */       close(pstmt);
/* 162:133 */       rollback(conn);
/* 163:134 */       throw sqle;
/* 164:    */     }
/* 165:    */     finally
/* 166:    */     {
/* 167:136 */       close(rs);
/* 168:137 */       close(pstmt);
/* 169:138 */       close(conn);
/* 170:    */     }
/* 171:    */   }
/* 172:    */   
/* 173:    */   public void delete(Documento data)
/* 174:    */     throws SQLException
/* 175:    */   {
/* 176:142 */     Connection conn = null;
/* 177:143 */     PreparedStatement pstmt = null;
/* 178:    */     try
/* 179:    */     {
/* 180:145 */       conn = this.ds.getConnection();
/* 181:146 */       conn.setAutoCommit(false);
/* 182:147 */       String sql = "DELETE FROM sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".documento WHERE doc_cod=?";
/* 183:148 */       pstmt = conn.prepareStatement(sql);
/* 184:149 */       pstmt.setBigDecimal(1, data.getDoc_cod());
/* 185:150 */       pstmt.executeUpdate();
/* 186:151 */       close(pstmt);
/* 187:152 */       conn.commit();
/* 188:    */     }
/* 189:    */     catch (SQLException e)
/* 190:    */     {
/* 191:154 */       close(pstmt);
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
/* 208:166 */       String sqlid = "Select max(doc_cod) from sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".documento ";
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
 * Qualified Name:     com.servidoctor.parametros.dao.DocumentoDAO
 * JD-Core Version:    0.7.0.1
 */