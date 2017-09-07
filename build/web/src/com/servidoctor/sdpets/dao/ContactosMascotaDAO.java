/*   1:    */ package com.servidoctor.sdpets.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdpets.model.ContactosMascota;
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
/*  16:    */ public class ContactosMascotaDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public synchronized void insert(ContactosMascota data, Connection conn)
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 19 */     PreparedStatement pstmt = null;
/*  23:    */     try
/*  24:    */     {
/*  25: 21 */       int id = 0;
/*  26: 22 */       DBUtil db = new DBUtil();
/*  27:    */       
/*  28: 24 */       id = getReqMax(conn, data.getCmas_mas_cod());
/*  29: 25 */       data.setCmas_cod(new BigDecimal(id));
/*  30: 26 */       String sql = db.creaSQLINSERT(data);
/*  31:    */       
/*  32: 28 */       pstmt = conn.prepareStatement(sql);
/*  33: 29 */       pstmt.executeUpdate();
/*  34:    */     }
/*  35:    */     catch (SQLException sqle)
/*  36:    */     {
/*  37: 31 */       throw sqle;
/*  38:    */     }
/*  39:    */     finally
/*  40:    */     {
/*  41: 33 */       close(pstmt);
/*  42:    */     }
/*  43:    */   }
/*  44:    */   
/*  45:    */   public void update(ContactosMascota data, String[] llaves, Connection conn)
/*  46:    */     throws SQLException
/*  47:    */   {
/*  48: 38 */     PreparedStatement pstmt = null;
/*  49:    */     try
/*  50:    */     {
/*  51: 40 */       DBUtil db = new DBUtil();
/*  52: 41 */       String sql = db.creaSQLUPDATE(data, llaves);
/*  53: 42 */       pstmt = conn.prepareStatement(sql);
/*  54: 43 */       pstmt.executeUpdate();
/*  55:    */     }
/*  56:    */     catch (SQLException e)
/*  57:    */     {
/*  58: 45 */       throw e;
/*  59:    */     }
/*  60:    */     finally
/*  61:    */     {
/*  62: 47 */       close(pstmt);
/*  63:    */     }
/*  64:    */   }
/*  65:    */   
/*  66:    */   public void delete(BigDecimal cmas_cod)
/*  67:    */     throws SQLException
/*  68:    */   {
/*  69: 53 */     Connection conn = null;
/*  70: 54 */     PreparedStatement pstmt = null;
/*  71:    */     try
/*  72:    */     {
/*  73: 56 */       conn = this.ds.getConnection();
/*  74: 57 */       conn.setAutoCommit(false);
/*  75: 58 */       String sql = "DELETE FROM sdoctor.contactosmascota WHERE cmas_cod=?";
/*  76: 59 */       pstmt = conn.prepareStatement(sql);
/*  77: 60 */       pstmt.setBigDecimal(1, cmas_cod);
/*  78: 61 */       pstmt.executeUpdate();
/*  79: 62 */       close(pstmt);
/*  80: 63 */       conn.commit();
/*  81:    */     }
/*  82:    */     catch (SQLException e)
/*  83:    */     {
/*  84: 65 */       close(pstmt);
/*  85: 66 */       rollback(conn);
/*  86: 67 */       e.printStackTrace();
/*  87:    */     }
/*  88:    */     finally
/*  89:    */     {
/*  90: 69 */       close(conn);
/*  91:    */     }
/*  92:    */   }
/*  93:    */   
/*  94:    */   public void deleteAll(BigDecimal cmas_mas_cod, Connection conn)
/*  95:    */     throws SQLException
/*  96:    */   {
/*  97: 74 */     PreparedStatement pstmt = null;
/*  98:    */     try
/*  99:    */     {
/* 100: 76 */       String sql = "DELETE FROM sdoctor.contactosmascota WHERE cmas_mas_cod=?";
/* 101: 77 */       pstmt = conn.prepareStatement(sql);
/* 102: 78 */       pstmt.setBigDecimal(1, cmas_mas_cod);
/* 103: 79 */       pstmt.executeUpdate();
/* 104:    */     }
/* 105:    */     catch (SQLException e)
/* 106:    */     {
/* 107: 81 */       throw e;
/* 108:    */     }
/* 109:    */     finally
/* 110:    */     {
/* 111: 83 */       close(pstmt);
/* 112:    */     }
/* 113:    */   }
/* 114:    */   
/* 115:    */   public ContactosMascota retrieve(BigDecimal cmas_cod, BigDecimal cmas_mas_cod)
/* 116:    */     throws SQLException
/* 117:    */   {
/* 118: 89 */     ContactosMascota contactoMascota = new ContactosMascota();
/* 119: 90 */     Connection conn = null;
/* 120: 91 */     PreparedStatement pstmt = null;
/* 121: 92 */     ResultSet rs = null;
/* 122: 93 */     ContactosMascota contactoMascotaS = new ContactosMascota();
/* 123:    */     try
/* 124:    */     {
/* 125: 95 */       conn = this.ds.getConnection();
/* 126: 96 */       DBUtil db = new DBUtil();
/* 127: 97 */       String sql = db.creaSQLSELECT(contactoMascotaS);
/* 128: 98 */       String where = " where cmas_mas_cod = " + cmas_mas_cod + " and cmas_cod = " + cmas_cod;
/* 129: 99 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 130:100 */       rs = pstmt.executeQuery();
/* 131:101 */       if (rs.next())
/* 132:    */       {
/* 133:102 */         InicializaData.inicializa(contactoMascota.getClass(), contactoMascota);
/* 134:103 */         populate(contactoMascota, rs);
/* 135:    */       }
/* 136:105 */       close(rs);
/* 137:106 */       close(pstmt);
/* 138:    */     }
/* 139:    */     catch (SQLException e)
/* 140:    */     {
/* 141:108 */       close(rs);
/* 142:109 */       close(pstmt);
/* 143:110 */       rollback(conn);
/* 144:111 */       e.printStackTrace();
/* 145:    */     }
/* 146:    */     finally
/* 147:    */     {
/* 148:113 */       close(conn);
/* 149:    */     }
/* 150:115 */     return contactoMascota;
/* 151:    */   }
/* 152:    */   
/* 153:    */   public ContactosMascota retrive(BigDecimal cmas_mas_cod)
/* 154:    */     throws SQLException
/* 155:    */   {
/* 156:120 */     ContactosMascota contactoMascota = new ContactosMascota();
/* 157:121 */     Connection conn = null;
/* 158:122 */     PreparedStatement pstmt = null;
/* 159:123 */     ResultSet rs = null;
/* 160:124 */     ContactosMascota contactoMascotaS = new ContactosMascota();
/* 161:    */     try
/* 162:    */     {
/* 163:126 */       conn = this.ds.getConnection();
/* 164:127 */       DBUtil db = new DBUtil();
/* 165:128 */       String sql = db.creaSQLSELECT(contactoMascotaS);
/* 166:129 */       String where = " where cmas_mas_cod = " + cmas_mas_cod;
/* 167:130 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 168:131 */       rs = pstmt.executeQuery();
/* 169:132 */       if (rs.next())
/* 170:    */       {
/* 171:133 */         InicializaData.inicializa(contactoMascota.getClass(), contactoMascota);
/* 172:134 */         populate(contactoMascota, rs);
/* 173:    */       }
/* 174:136 */       close(rs);
/* 175:137 */       close(pstmt);
/* 176:    */     }
/* 177:    */     catch (SQLException e)
/* 178:    */     {
/* 179:139 */       close(rs);
/* 180:140 */       close(pstmt);
/* 181:141 */       rollback(conn);
/* 182:142 */       e.printStackTrace();
/* 183:    */     }
/* 184:    */     finally
/* 185:    */     {
/* 186:144 */       close(conn);
/* 187:    */     }
/* 188:146 */     return contactoMascota;
/* 189:    */   }
/* 190:    */   
/* 191:    */   public List list(BigDecimal cmas_mas_cod)
/* 192:    */     throws SQLException
/* 193:    */   {
/* 194:151 */     ArrayList list = new ArrayList();
/* 195:152 */     Connection conn = null;
/* 196:153 */     PreparedStatement pstmt = null;
/* 197:154 */     ResultSet rs = null;
/* 198:155 */     ContactosMascota contactoMascotaS = new ContactosMascota();
/* 199:    */     try
/* 200:    */     {
/* 201:157 */       conn = this.ds.getConnection();
/* 202:158 */       DBUtil db = new DBUtil();
/* 203:159 */       String sql = db.creaSQLSELECT(contactoMascotaS);
/* 204:160 */       String where = " where cmas_mas_cod = " + cmas_mas_cod;
/* 205:161 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 206:162 */       rs = pstmt.executeQuery();
/* 207:163 */       while (rs.next())
/* 208:    */       {
/* 209:164 */         ContactosMascota contactoMascota = new ContactosMascota();
/* 210:165 */         InicializaData.inicializa(contactoMascota.getClass(), contactoMascota);
/* 211:166 */         populate(contactoMascota, rs);
/* 212:167 */         list.add(contactoMascota);
/* 213:    */       }
/* 214:169 */       close(rs);
/* 215:170 */       close(pstmt);
/* 216:    */     }
/* 217:    */     catch (SQLException e)
/* 218:    */     {
/* 219:172 */       close(rs);
/* 220:173 */       close(pstmt);
/* 221:174 */       rollback(conn);
/* 222:175 */       e.printStackTrace();
/* 223:    */     }
/* 224:    */     finally
/* 225:    */     {
/* 226:177 */       close(conn);
/* 227:    */     }
/* 228:179 */     return list;
/* 229:    */   }
/* 230:    */   
/* 231:    */   private int getReqMax(Connection conn, BigDecimal cmas_mas_cod)
/* 232:    */   {
/* 233:183 */     PreparedStatement pstmt = null;
/* 234:184 */     ResultSet rs = null;
/* 235:185 */     int id = 0;
/* 236:    */     try
/* 237:    */     {
/* 238:187 */       String sqlid = "Select max(cmas_cod) from sdoctor.contactosmascota";
/* 239:188 */       String where = " where cmas_mas_cod=" + cmas_mas_cod;
/* 240:189 */       pstmt = conn.prepareStatement(sqlid + " " + where);
/* 241:190 */       rs = pstmt.executeQuery();
/* 242:191 */       if ((rs != null) && (rs.next())) {
/* 243:192 */         id = rs.getInt(1) + 1;
/* 244:    */       } else {
/* 245:194 */         id++;
/* 246:    */       }
/* 247:    */     }
/* 248:    */     catch (SQLException e)
/* 249:    */     {
/* 250:198 */       close(rs);
/* 251:199 */       close(pstmt);
/* 252:200 */       rollback(conn);
/* 253:201 */       e.printStackTrace();
/* 254:    */     }
/* 255:    */     finally
/* 256:    */     {
/* 257:203 */       close(rs);
/* 258:204 */       close(pstmt);
/* 259:    */     }
/* 260:206 */     return id;
/* 261:    */   }
/* 262:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdpets.dao.ContactosMascotaDAO
 * JD-Core Version:    0.7.0.1
 */