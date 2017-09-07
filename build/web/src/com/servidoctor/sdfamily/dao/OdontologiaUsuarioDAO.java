/*   1:    */ package com.servidoctor.sdfamily.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdfamily.model.OdontologiaUsuario;
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
/*  16:    */ public class OdontologiaUsuarioDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list(BigDecimal odou_usuf_cod)
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 26 */     ArrayList list = new ArrayList();
/*  23: 27 */     Connection conn = null;
/*  24: 28 */     PreparedStatement pstmt = null;
/*  25: 29 */     ResultSet rs = null;
/*  26: 30 */     OdontologiaUsuario odontologiaUsuarioS = new OdontologiaUsuario();
/*  27:    */     try
/*  28:    */     {
/*  29: 32 */       conn = this.ds.getConnection();
/*  30: 33 */       DBUtil db = new DBUtil();
/*  31: 34 */       String sql = db.creaSQLSELECT(odontologiaUsuarioS);
/*  32: 35 */       String where = " where odou_usuf_cod=" + odou_usuf_cod;
/*  33: 36 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  34: 37 */       rs = pstmt.executeQuery();
/*  35: 38 */       while (rs.next())
/*  36:    */       {
/*  37: 39 */         OdontologiaUsuario odontologiaUsuario = new OdontologiaUsuario();
/*  38: 40 */         InicializaData.inicializa(odontologiaUsuario.getClass(), odontologiaUsuario);
/*  39: 41 */         populate(odontologiaUsuario, rs);
/*  40: 42 */         list.add(odontologiaUsuario);
/*  41:    */       }
/*  42: 44 */       close(rs);
/*  43: 45 */       close(pstmt);
/*  44:    */     }
/*  45:    */     catch (SQLException e)
/*  46:    */     {
/*  47: 47 */       close(rs);
/*  48: 48 */       close(pstmt);
/*  49: 49 */       rollback(conn);
/*  50: 50 */       throw e;
/*  51:    */     }
/*  52:    */     finally
/*  53:    */     {
/*  54: 52 */       close(conn);
/*  55:    */     }
/*  56: 54 */     return list;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public List list2(BigDecimal odou_usuf_cod, BigDecimal odou_cod)
/*  60:    */     throws SQLException
/*  61:    */   {
/*  62: 58 */     ArrayList list = new ArrayList();
/*  63: 59 */     Connection conn = null;
/*  64: 60 */     PreparedStatement pstmt = null;
/*  65: 61 */     ResultSet rs = null;
/*  66: 62 */     OdontologiaUsuario odontologiaUsuarioS = new OdontologiaUsuario();
/*  67:    */     try
/*  68:    */     {
/*  69: 64 */       conn = this.ds.getConnection();
/*  70: 65 */       DBUtil db = new DBUtil();
/*  71: 66 */       String sql = db.creaSQLSELECT(odontologiaUsuarioS);
/*  72: 67 */       String where = " where odou_usuf_cod=" + odou_usuf_cod + " AND odou_cod=" + odou_cod;
/*  73: 68 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  74: 69 */       rs = pstmt.executeQuery();
/*  75: 70 */       while (rs.next())
/*  76:    */       {
/*  77: 71 */         OdontologiaUsuario odontologiaUsuario = new OdontologiaUsuario();
/*  78: 72 */         InicializaData.inicializa(odontologiaUsuario.getClass(), odontologiaUsuario);
/*  79: 73 */         populate(odontologiaUsuario, rs);
/*  80: 74 */         list.add(odontologiaUsuario);
/*  81:    */       }
/*  82: 76 */       close(rs);
/*  83: 77 */       close(pstmt);
/*  84:    */     }
/*  85:    */     catch (SQLException e)
/*  86:    */     {
/*  87: 79 */       close(rs);
/*  88: 80 */       close(pstmt);
/*  89: 81 */       rollback(conn);
/*  90: 82 */       throw e;
/*  91:    */     }
/*  92:    */     finally
/*  93:    */     {
/*  94: 84 */       close(conn);
/*  95:    */     }
/*  96: 86 */     return list;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public void update(OdontologiaUsuario data, String[] llaves, Connection conn)
/* 100:    */     throws SQLException
/* 101:    */   {
/* 102: 90 */     PreparedStatement pstmt = null;
/* 103:    */     try
/* 104:    */     {
/* 105: 92 */       DBUtil db = new DBUtil();
/* 106: 93 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 107: 94 */       pstmt = conn.prepareStatement(sql);
/* 108: 95 */       pstmt.executeUpdate();
/* 109:    */     }
/* 110:    */     catch (SQLException e)
/* 111:    */     {
/* 112: 97 */       throw e;
/* 113:    */     }
/* 114:    */     finally
/* 115:    */     {
/* 116: 99 */       close(pstmt);
/* 117:    */     }
/* 118:    */   }
/* 119:    */   
/* 120:    */   public OdontologiaUsuario retrieve(BigDecimal odou_usuf_cod, BigDecimal odou_cod)
/* 121:    */     throws SQLException
/* 122:    */   {
/* 123:104 */     OdontologiaUsuario odontologiaUsuario = new OdontologiaUsuario();
/* 124:105 */     Connection conn = null;
/* 125:106 */     PreparedStatement pstmt = null;
/* 126:107 */     ResultSet rs = null;
/* 127:108 */     OdontologiaUsuario odontologiaUsuarioS = new OdontologiaUsuario();
/* 128:    */     try
/* 129:    */     {
/* 130:110 */       conn = this.ds.getConnection();
/* 131:111 */       DBUtil db = new DBUtil();
/* 132:112 */       String sql = db.creaSQLSELECT(odontologiaUsuarioS);
/* 133:113 */       String where = " where odou_usuf_cod = " + odou_usuf_cod + " and odou_cod = " + odou_cod;
/* 134:114 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 135:115 */       rs = pstmt.executeQuery();
/* 136:116 */       if (rs.next())
/* 137:    */       {
/* 138:117 */         InicializaData.inicializa(odontologiaUsuario.getClass(), odontologiaUsuario);
/* 139:118 */         populate(odontologiaUsuario, rs);
/* 140:    */       }
/* 141:120 */       close(rs);
/* 142:121 */       close(pstmt);
/* 143:    */     }
/* 144:    */     catch (SQLException e)
/* 145:    */     {
/* 146:123 */       close(rs);
/* 147:124 */       close(pstmt);
/* 148:125 */       rollback(conn);
/* 149:126 */       throw e;
/* 150:    */     }
/* 151:    */     finally
/* 152:    */     {
/* 153:128 */       close(conn);
/* 154:    */     }
/* 155:130 */     return odontologiaUsuario;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public synchronized void insert(OdontologiaUsuario data, Connection conn)
/* 159:    */     throws SQLException
/* 160:    */   {
/* 161:134 */     PreparedStatement pstmt = null;
/* 162:    */     try
/* 163:    */     {
/* 164:136 */       int id = 0;
/* 165:137 */       DBUtil db = new DBUtil();
/* 166:    */       
/* 167:139 */       id = getReqMax(conn, data);
/* 168:140 */       data.setOdou_cod(new BigDecimal(id));
/* 169:141 */       String sql = db.creaSQLINSERT(data);
/* 170:    */       
/* 171:143 */       pstmt = conn.prepareStatement(sql);
/* 172:144 */       pstmt.executeUpdate();
/* 173:    */     }
/* 174:    */     catch (SQLException sqle)
/* 175:    */     {
/* 176:146 */       throw sqle;
/* 177:    */     }
/* 178:    */     finally
/* 179:    */     {
/* 180:148 */       close(pstmt);
/* 181:    */     }
/* 182:    */   }
/* 183:    */   
/* 184:    */   public void delete(OdontologiaUsuario data, Connection conn)
/* 185:    */     throws SQLException
/* 186:    */   {
/* 187:153 */     PreparedStatement pstmt = null;
/* 188:    */     try
/* 189:    */     {
/* 190:155 */       String sql = "DELETE FROM sdoctor.odontologiausuario WHERE odou_cod = ? and odou_usuf_cod = ?";
/* 191:156 */       pstmt = conn.prepareStatement(sql);
/* 192:157 */       pstmt.setBigDecimal(1, data.getOdou_cod());
/* 193:158 */       pstmt.setBigDecimal(2, data.getOdou_usuf_cod());
/* 194:159 */       pstmt.executeUpdate();
/* 195:    */     }
/* 196:    */     catch (SQLException e)
/* 197:    */     {
/* 198:161 */       throw e;
/* 199:    */     }
/* 200:    */     finally
/* 201:    */     {
/* 202:163 */       close(pstmt);
/* 203:    */     }
/* 204:    */   }
/* 205:    */   
/* 206:    */   public void deleteAll(BigDecimal odou_usuf_cod, Connection conn)
/* 207:    */     throws SQLException
/* 208:    */   {
/* 209:168 */     PreparedStatement pstmt = null;
/* 210:    */     try
/* 211:    */     {
/* 212:170 */       String sql = "DELETE FROM sdoctor.odontologiausuario WHERE odou_usuf_cod=?";
/* 213:171 */       pstmt = conn.prepareStatement(sql);
/* 214:172 */       pstmt.setBigDecimal(1, odou_usuf_cod);
/* 215:173 */       pstmt.executeUpdate();
/* 216:    */     }
/* 217:    */     catch (SQLException e)
/* 218:    */     {
/* 219:175 */       throw e;
/* 220:    */     }
/* 221:    */     finally
/* 222:    */     {
/* 223:177 */       close(pstmt);
/* 224:    */     }
/* 225:    */   }
/* 226:    */   
/* 227:    */   private int getReqMax(Connection conn, OdontologiaUsuario data)
/* 228:    */     throws SQLException
/* 229:    */   {
/* 230:182 */     PreparedStatement pstmt = null;
/* 231:183 */     ResultSet rs = null;
/* 232:184 */     int id = 0;
/* 233:    */     try
/* 234:    */     {
/* 235:186 */       String sqlid = "Select max(odou_cod) from sdoctor.odontologiausuario where odou_usuf_cod = ?";
/* 236:    */       
/* 237:188 */       pstmt = conn.prepareStatement(sqlid);
/* 238:189 */       pstmt.setBigDecimal(1, data.getOdou_usuf_cod());
/* 239:190 */       rs = pstmt.executeQuery();
/* 240:191 */       if ((rs != null) && (rs.next())) {
/* 241:192 */         id = rs.getInt(1) + 1;
/* 242:    */       } else {
/* 243:194 */         id++;
/* 244:    */       }
/* 245:    */     }
/* 246:    */     catch (SQLException e)
/* 247:    */     {
/* 248:198 */       throw e;
/* 249:    */     }
/* 250:    */     finally
/* 251:    */     {
/* 252:200 */       close(rs);
/* 253:201 */       close(pstmt);
/* 254:    */     }
/* 255:203 */     return id;
/* 256:    */   }
/* 257:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.dao.OdontologiaUsuarioDAO
 * JD-Core Version:    0.7.0.1
 */