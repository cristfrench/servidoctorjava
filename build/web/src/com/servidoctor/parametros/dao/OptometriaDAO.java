/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.Optometria;
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
/*  16:    */ public class OptometriaDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list(BigDecimal opt_usuf_cod)
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 26 */     ArrayList list = new ArrayList();
/*  23: 27 */     Connection conn = null;
/*  24: 28 */     PreparedStatement pstmt = null;
/*  25: 29 */     ResultSet rs = null;
/*  26: 30 */     Optometria usuarioOptometriaS = new Optometria();
/*  27:    */     try
/*  28:    */     {
/*  29: 32 */       conn = this.ds.getConnection();
/*  30: 33 */       DBUtil db = new DBUtil();
/*  31: 34 */       if (this.idioma != null) {
/*  32: 35 */         db.setIdioma(this.idioma);
/*  33:    */       }
/*  34: 37 */       String sql = db.creaSQLSELECT(usuarioOptometriaS);
/*  35: 38 */       pstmt = conn.prepareStatement(sql + " where opt_cod > 0 and opt_usuf_cod = " + opt_usuf_cod);
/*  36: 39 */       rs = pstmt.executeQuery();
/*  37: 40 */       while (rs.next())
/*  38:    */       {
/*  39: 41 */         Optometria usuarioOptometria = new Optometria();
/*  40: 42 */         InicializaData.inicializa(usuarioOptometria.getClass(), usuarioOptometria);
/*  41: 43 */         populate(usuarioOptometria, rs);
/*  42: 44 */         list.add(usuarioOptometria);
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
/*  61:    */   public Optometria retrive(BigDecimal opt_cod, BigDecimal opt_usuf_cod)
/*  62:    */     throws SQLException
/*  63:    */   {
/*  64: 61 */     Optometria usuarioOptometria = new Optometria();
/*  65: 62 */     Connection conn = null;
/*  66: 63 */     PreparedStatement pstmt = null;
/*  67: 64 */     ResultSet rs = null;
/*  68: 65 */     Optometria usuarioOptometriaS = new Optometria();
/*  69:    */     try
/*  70:    */     {
/*  71: 67 */       conn = this.ds.getConnection();
/*  72: 68 */       DBUtil db = new DBUtil();
/*  73: 69 */       if (this.idioma != null) {
/*  74: 70 */         db.setIdioma(this.idioma);
/*  75:    */       }
/*  76: 72 */       String sql = db.creaSQLSELECT(usuarioOptometriaS);
/*  77: 73 */       String where = " where opt_usuf_cod=" + opt_usuf_cod + " and opt_cod=" + opt_cod;
/*  78: 74 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  79: 75 */       rs = pstmt.executeQuery();
/*  80: 76 */       if (rs.next())
/*  81:    */       {
/*  82: 77 */         InicializaData.inicializa(usuarioOptometria.getClass(), usuarioOptometria);
/*  83: 78 */         populate(usuarioOptometria, rs);
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
/*  99: 90 */     return usuarioOptometria;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public synchronized void insert(Optometria data, Connection conn)
/* 103:    */     throws SQLException
/* 104:    */   {
/* 105: 94 */     PreparedStatement pstmt = null;
/* 106:    */     try
/* 107:    */     {
/* 108: 96 */       int id = 0;
/* 109: 97 */       DBUtil db = new DBUtil();
/* 110: 98 */       if (this.idioma != null) {
/* 111: 99 */         db.setIdioma(this.idioma);
/* 112:    */       }
/* 113:102 */       id = getReqMax(conn, data.getOpt_usuf_cod());
/* 114:103 */       data.setOpt_cod(new BigDecimal(id));
/* 115:104 */       String sql = db.creaSQLINSERT(data);
/* 116:    */       
/* 117:106 */       pstmt = conn.prepareStatement(sql);
/* 118:107 */       pstmt.executeUpdate();
/* 119:    */     }
/* 120:    */     catch (SQLException sqle)
/* 121:    */     {
/* 122:109 */       throw sqle;
/* 123:    */     }
/* 124:    */     finally
/* 125:    */     {
/* 126:111 */       close(pstmt);
/* 127:    */     }
/* 128:    */   }
/* 129:    */   
/* 130:    */   public void update(Optometria data, String[] llaves, Connection conn)
/* 131:    */     throws SQLException
/* 132:    */   {
/* 133:115 */     PreparedStatement pstmt = null;
/* 134:    */     try
/* 135:    */     {
/* 136:117 */       DBUtil db = new DBUtil();
/* 137:118 */       if (this.idioma != null) {
/* 138:119 */         db.setIdioma(this.idioma);
/* 139:    */       }
/* 140:121 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 141:122 */       pstmt = conn.prepareStatement(sql);
/* 142:123 */       pstmt.executeUpdate();
/* 143:    */     }
/* 144:    */     catch (SQLException e)
/* 145:    */     {
/* 146:125 */       throw e;
/* 147:    */     }
/* 148:    */     finally
/* 149:    */     {
/* 150:127 */       close(pstmt);
/* 151:    */     }
/* 152:    */   }
/* 153:    */   
/* 154:    */   public void delete(Optometria data, Connection conn)
/* 155:    */     throws SQLException
/* 156:    */   {
/* 157:131 */     PreparedStatement pstmt = null;
/* 158:    */     try
/* 159:    */     {
/* 160:133 */       String sql = "DELETE FROM sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".optometria WHERE opt_usuf_cod=? and opt_cod=?";
/* 161:134 */       pstmt = conn.prepareStatement(sql);
/* 162:135 */       pstmt.setBigDecimal(1, data.getOpt_usuf_cod());
/* 163:136 */       pstmt.setBigDecimal(2, data.getOpt_cod());
/* 164:137 */       pstmt.executeUpdate();
/* 165:    */     }
/* 166:    */     catch (SQLException e)
/* 167:    */     {
/* 168:139 */       throw e;
/* 169:    */     }
/* 170:    */     finally
/* 171:    */     {
/* 172:141 */       close(pstmt);
/* 173:    */     }
/* 174:    */   }
/* 175:    */   
/* 176:    */   public void deleteAll(BigDecimal opt_usuf_cod, Connection conn)
/* 177:    */     throws SQLException
/* 178:    */   {
/* 179:146 */     PreparedStatement pstmt = null;
/* 180:    */     try
/* 181:    */     {
/* 182:148 */       String sql = "DELETE FROM sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".optometria WHERE opt_usuf_cod=? ";
/* 183:149 */       pstmt = conn.prepareStatement(sql);
/* 184:150 */       pstmt.setBigDecimal(1, opt_usuf_cod);
/* 185:151 */       pstmt.executeUpdate();
/* 186:    */     }
/* 187:    */     catch (SQLException e)
/* 188:    */     {
/* 189:153 */       throw e;
/* 190:    */     }
/* 191:    */     finally
/* 192:    */     {
/* 193:155 */       close(pstmt);
/* 194:    */     }
/* 195:    */   }
/* 196:    */   
/* 197:    */   private int getReqMax(Connection conn, BigDecimal opt_usuf_cod)
/* 198:    */     throws SQLException
/* 199:    */   {
/* 200:160 */     PreparedStatement pstmt = null;
/* 201:161 */     ResultSet rs = null;
/* 202:162 */     int id = 0;
/* 203:    */     try
/* 204:    */     {
/* 205:164 */       String sqlid = "Select max(opt_cod) from sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".optometria";
/* 206:165 */       String where = " where opt_usuf_cod=" + opt_usuf_cod;
/* 207:166 */       pstmt = conn.prepareStatement(sqlid + " " + where);
/* 208:167 */       rs = pstmt.executeQuery();
/* 209:168 */       if ((rs != null) && (rs.next())) {
/* 210:169 */         id = rs.getInt(1) + 1;
/* 211:    */       } else {
/* 212:171 */         id++;
/* 213:    */       }
/* 214:    */     }
/* 215:    */     catch (SQLException e)
/* 216:    */     {
/* 217:175 */       throw e;
/* 218:    */     }
/* 219:    */     finally
/* 220:    */     {
/* 221:177 */       close(rs);
/* 222:178 */       close(pstmt);
/* 223:    */     }
/* 224:180 */     return id;
/* 225:    */   }
/* 226:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.OptometriaDAO
 * JD-Core Version:    0.7.0.1
 */