/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.Alergias;
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
/*  16:    */ public class AlergiasDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list()
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 26 */     ArrayList list = new ArrayList();
/*  23: 27 */     Connection conn = null;
/*  24: 28 */     PreparedStatement pstmt = null;
/*  25: 29 */     ResultSet rs = null;
/*  26: 30 */     Alergias usuarioAlergiasS = new Alergias();
/*  27:    */     try
/*  28:    */     {
/*  29: 32 */       conn = this.ds.getConnection();
/*  30: 33 */       DBUtil db = new DBUtil();
/*  31: 34 */       if (this.idioma != null) {
/*  32: 35 */         db.setIdioma(this.idioma);
/*  33:    */       }
/*  34: 37 */       String sql = db.creaSQLSELECT(usuarioAlergiasS);
/*  35: 38 */       pstmt = conn.prepareStatement(sql + " where ale_cod > 0");
/*  36: 39 */       rs = pstmt.executeQuery();
/*  37: 40 */       while (rs.next())
/*  38:    */       {
/*  39: 41 */         Alergias usuarioAlergias = new Alergias();
/*  40: 42 */         InicializaData.inicializa(usuarioAlergias.getClass(), usuarioAlergias);
/*  41: 43 */         populate(usuarioAlergias, rs);
/*  42: 44 */         list.add(usuarioAlergias);
/*  43:    */       }
/*  44: 46 */       close(rs);
/*  45: 47 */       close(pstmt);
/*  46:    */     }
/*  47:    */     catch (SQLException e)
/*  48:    */     {
/*  49: 49 */       close(rs);
/*  50: 50 */       close(pstmt);
/*  51: 51 */       rollback(conn);
/*  52: 52 */       throw e;
/*  53:    */     }
/*  54:    */     finally
/*  55:    */     {
/*  56: 54 */       close(conn);
/*  57:    */     }
/*  58: 56 */     return list;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public Alergias retrive(BigDecimal ale_cod)
/*  62:    */     throws SQLException
/*  63:    */   {
/*  64: 61 */     Alergias usuarioAlergias = new Alergias();
/*  65: 62 */     Connection conn = null;
/*  66: 63 */     PreparedStatement pstmt = null;
/*  67: 64 */     ResultSet rs = null;
/*  68: 65 */     Alergias usuarioAlergiasS = new Alergias();
/*  69:    */     try
/*  70:    */     {
/*  71: 67 */       conn = this.ds.getConnection();
/*  72: 68 */       DBUtil db = new DBUtil();
/*  73: 69 */       if (this.idioma != null) {
/*  74: 70 */         db.setIdioma(this.idioma);
/*  75:    */       }
/*  76: 72 */       String sql = db.creaSQLSELECT(usuarioAlergiasS);
/*  77: 73 */       String where = " where ale_cod=" + ale_cod;
/*  78: 74 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  79: 75 */       rs = pstmt.executeQuery();
/*  80: 76 */       if (rs.next())
/*  81:    */       {
/*  82: 77 */         InicializaData.inicializa(usuarioAlergias.getClass(), usuarioAlergias);
/*  83: 78 */         populate(usuarioAlergias, rs);
/*  84:    */       }
/*  85: 80 */       close(rs);
/*  86: 81 */       close(pstmt);
/*  87:    */     }
/*  88:    */     catch (SQLException e)
/*  89:    */     {
/*  90: 83 */       close(rs);
/*  91: 84 */       close(pstmt);
/*  92: 85 */       rollback(conn);
/*  93: 86 */       throw e;
/*  94:    */     }
/*  95:    */     finally
/*  96:    */     {
/*  97: 88 */       close(conn);
/*  98:    */     }
/*  99: 90 */     return usuarioAlergias;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public synchronized void insert(Alergias data)
/* 103:    */     throws SQLException
/* 104:    */   {
/* 105: 94 */     Connection conn = null;
/* 106: 95 */     PreparedStatement pstmt = null;
/* 107:    */     
/* 108: 97 */     ResultSet rs = null;
/* 109:    */     try
/* 110:    */     {
/* 111: 99 */       int id = 0;
/* 112:100 */       DBUtil db = new DBUtil();
/* 113:101 */       if (this.idioma != null) {
/* 114:102 */         db.setIdioma(this.idioma);
/* 115:    */       }
/* 116:105 */       conn = this.ds.getConnection();
/* 117:106 */       conn.setAutoCommit(false);
/* 118:107 */       id = getReqMax(conn);
/* 119:108 */       data.setAle_cod(new BigDecimal(id));
/* 120:109 */       String sql = db.creaSQLINSERT(data);
/* 121:    */       
/* 122:111 */       pstmt = conn.prepareStatement(sql);
/* 123:112 */       pstmt.executeUpdate();
/* 124:113 */       pstmt.close();
/* 125:114 */       conn.commit();
/* 126:    */     }
/* 127:    */     catch (SQLException sqle)
/* 128:    */     {
/* 129:116 */       close(rs);
/* 130:117 */       close(pstmt);
/* 131:118 */       rollback(conn);
/* 132:119 */       throw sqle;
/* 133:    */     }
/* 134:    */     finally
/* 135:    */     {
/* 136:121 */       close(rs);
/* 137:122 */       close(pstmt);
/* 138:123 */       close(conn);
/* 139:    */     }
/* 140:    */   }
/* 141:    */   
/* 142:    */   public void update(Alergias data, String[] llaves)
/* 143:    */     throws SQLException
/* 144:    */   {
/* 145:127 */     Connection conn = null;
/* 146:128 */     PreparedStatement pstmt = null;
/* 147:    */     try
/* 148:    */     {
/* 149:130 */       DBUtil db = new DBUtil();
/* 150:131 */       if (this.idioma != null) {
/* 151:132 */         db.setIdioma(this.idioma);
/* 152:    */       }
/* 153:134 */       conn = this.ds.getConnection();
/* 154:135 */       conn.setAutoCommit(false);
/* 155:136 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 156:137 */       pstmt = conn.prepareStatement(sql);
/* 157:138 */       pstmt.executeUpdate();
/* 158:139 */       close(pstmt);
/* 159:140 */       conn.commit();
/* 160:    */     }
/* 161:    */     catch (SQLException e)
/* 162:    */     {
/* 163:142 */       close(pstmt);
/* 164:143 */       rollback(conn);
/* 165:144 */       throw e;
/* 166:    */     }
/* 167:    */     finally
/* 168:    */     {
/* 169:146 */       close(conn);
/* 170:    */     }
/* 171:    */   }
/* 172:    */   
/* 173:    */   public void delete(Alergias data)
/* 174:    */     throws SQLException
/* 175:    */   {
/* 176:150 */     Connection conn = null;
/* 177:151 */     PreparedStatement pstmt = null;
/* 178:    */     try
/* 179:    */     {
/* 180:153 */       conn = this.ds.getConnection();
/* 181:154 */       conn.setAutoCommit(false);
/* 182:155 */       String sql = "DELETE FROM sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".alergias WHERE ale_cod=?";
/* 183:156 */       pstmt = conn.prepareStatement(sql);
/* 184:157 */       pstmt.setBigDecimal(1, data.getAle_cod());
/* 185:158 */       pstmt.executeUpdate();
/* 186:159 */       close(pstmt);
/* 187:160 */       conn.commit();
/* 188:    */     }
/* 189:    */     catch (SQLException e)
/* 190:    */     {
/* 191:162 */       close(pstmt);
/* 192:163 */       rollback(conn);
/* 193:164 */       throw e;
/* 194:    */     }
/* 195:    */     finally
/* 196:    */     {
/* 197:166 */       close(conn);
/* 198:    */     }
/* 199:    */   }
/* 200:    */   
/* 201:    */   private int getReqMax(Connection conn)
/* 202:    */   {
/* 203:171 */     PreparedStatement pstmt = null;
/* 204:172 */     ResultSet rs = null;
/* 205:173 */     int id = 0;
/* 206:    */     try
/* 207:    */     {
/* 208:175 */       String sqlid = "Select max(ale_cod) from sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".alergias";
/* 209:176 */       pstmt = conn.prepareStatement(sqlid);
/* 210:177 */       rs = pstmt.executeQuery();
/* 211:178 */       if ((rs != null) && (rs.next())) {
/* 212:179 */         id = rs.getInt(1) + 1;
/* 213:    */       } else {
/* 214:181 */         id++;
/* 215:    */       }
/* 216:    */     }
/* 217:    */     catch (SQLException e)
/* 218:    */     {
/* 219:185 */       close(rs);
/* 220:186 */       close(pstmt);
/* 221:187 */       rollback(conn);
/* 222:188 */       e.printStackTrace();
/* 223:    */     }
/* 224:    */     finally
/* 225:    */     {
/* 226:190 */       close(rs);
/* 227:191 */       close(pstmt);
/* 228:    */     }
/* 229:193 */     return id;
/* 230:    */   }
/* 231:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.AlergiasDAO
 * JD-Core Version:    0.7.0.1
 */