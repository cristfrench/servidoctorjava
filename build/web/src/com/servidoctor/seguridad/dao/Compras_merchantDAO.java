/*   1:    */ package com.servidoctor.seguridad.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.seguridad.model.Compras_merchant;
/*   5:    */ import com.servidoctor.util.classes.DBUtil;
/*   6:    */ import com.servidoctor.util.classes.InicializaData;
/*   7:    */ import java.io.PrintStream;
/*   8:    */ import java.sql.Connection;
/*   9:    */ import java.sql.PreparedStatement;
/*  10:    */ import java.sql.ResultSet;
/*  11:    */ import java.sql.SQLException;
/*  12:    */ import java.util.ArrayList;
/*  13:    */ import java.util.List;
/*  14:    */ import java.util.ResourceBundle;
/*  15:    */ import javax.sql.DataSource;
/*  16:    */ 
/*  17:    */ public class Compras_merchantDAO
/*  18:    */   extends DAO
/*  19:    */ {
/*  20: 27 */   private static final ResourceBundle prop = ResourceBundle.getBundle("com.servidoctor.resources.Config");
/*  21:    */   
/*  22:    */   public Compras_merchantDAO()
/*  23:    */   {
/*  24: 30 */     super(prop.getString("jndi.vega.name"));
/*  25:    */   }
/*  26:    */   
/*  27:    */   public List list()
/*  28:    */     throws SQLException
/*  29:    */   {
/*  30: 34 */     ArrayList list = new ArrayList();
/*  31: 35 */     Connection conn = null;
/*  32: 36 */     PreparedStatement pstmt = null;
/*  33: 37 */     ResultSet rs = null;
/*  34: 38 */     Compras_merchant compras_merchantS = new Compras_merchant();
/*  35:    */     try
/*  36:    */     {
/*  37: 40 */       conn = this.ds.getConnection();
/*  38: 41 */       DBUtil db = new DBUtil("vega_sdoctor");
/*  39: 42 */       String sql = db.creaSQLSELECT(compras_merchantS);
/*  40: 43 */       String where = " where compras_merchant_tc = ?";
/*  41: 44 */       pstmt = conn.prepareStatement(sql + where);
/*  42: 45 */       System.out.println(sql + where);
/*  43:    */       
/*  44: 47 */       pstmt.setString(1, "m");
/*  45: 48 */       rs = pstmt.executeQuery();
/*  46: 49 */       while (rs.next())
/*  47:    */       {
/*  48: 50 */         Compras_merchant compras_merchant = new Compras_merchant();
/*  49: 51 */         InicializaData.inicializa(compras_merchant.getClass(), compras_merchant);
/*  50: 52 */         populate(compras_merchant, rs);
/*  51: 53 */         list.add(compras_merchant);
/*  52:    */       }
/*  53: 55 */       close(rs);
/*  54: 56 */       close(pstmt);
/*  55:    */     }
/*  56:    */     catch (SQLException e)
/*  57:    */     {
/*  58: 58 */       close(rs);
/*  59: 59 */       close(pstmt);
/*  60: 60 */       rollback(conn);
/*  61: 61 */       throw e;
/*  62:    */     }
/*  63:    */     finally
/*  64:    */     {
/*  65: 63 */       close(conn);
/*  66:    */     }
/*  67: 65 */     return list;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public Compras_merchant retrieve(String code)
/*  71:    */     throws SQLException
/*  72:    */   {
/*  73: 69 */     Compras_merchant compras_merchant = retriveByActivationCode(code);
/*  74: 70 */     if (compras_merchant.getCompras_merchant_cdgcmp() == null) {
/*  75: 71 */       compras_merchant = retriveBySpecialCode(code);
/*  76:    */     }
/*  77: 73 */     return compras_merchant;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public List listPadre(String compras_merchant_id)
/*  81:    */     throws SQLException
/*  82:    */   {
/*  83: 76 */     ArrayList list = new ArrayList();
/*  84:    */     
/*  85:    */ 
/*  86: 79 */     Connection conn = null;
/*  87: 80 */     PreparedStatement pstmt = null;
/*  88: 81 */     ResultSet rs = null;
/*  89: 82 */     Compras_merchant compras_merchantS = new Compras_merchant();
/*  90: 83 */     Compras_merchant compras_merchant = new Compras_merchant();
/*  91:    */     try
/*  92:    */     {
/*  93: 85 */       conn = this.ds.getConnection();
/*  94: 86 */       DBUtil db = new DBUtil("vega_sdoctor");
/*  95: 87 */       String sql = db.creaSQLSELECT(compras_merchantS);
/*  96: 88 */       String where = " where compras_merchant_id LIKE ?";
/*  97: 89 */       pstmt = conn.prepareStatement(sql + where);
/*  98: 90 */       pstmt.setString(1, compras_merchant_id);
/*  99: 91 */       rs = pstmt.executeQuery();
/* 100: 92 */       while (rs.next())
/* 101:    */       {
/* 102: 93 */         compras_merchant.setCompras_margen_emision(rs.getString("compras_margen_emision"));
/* 103:    */         
/* 104: 95 */         compras_merchant.setCompras_merchant_id(rs.getString("compras_merchant_id"));
/* 105: 96 */         compras_merchant.setCompras_merchant_cdgcmp(rs.getString("compras_merchant_cdgcmp"));
/* 106: 97 */         compras_merchant.setCompras_merchant_cdgesp(rs.getString("compras_merchant_cdgesp"));
/* 107: 98 */         compras_merchant.setCompras_merchant_nombre_apellido(rs.getString("compras_merchant_nombre_apellido"));
/* 108: 99 */         compras_merchant.setCompras_merchant_tc(rs.getString("compras_merchant_tc"));
/* 109:100 */         compras_merchant.setCompras_merchant_datec(rs.getDate("compras_merchant_datec"));
/* 110:101 */         compras_merchant.setCompras_pais(rs.getString("compras_pais"));
/* 111:102 */         compras_merchant.setCompras_dias_activar_mayor(rs.getString("compras_dias_activar_mayor"));
/* 112:103 */         compras_merchant.setCompras_merchant_date_aprob(rs.getString("compras_merchant_date_aprob"));
/* 113:104 */         compras_merchant.setServer_id(rs.getBigDecimal("server_id"));
/* 114:    */         
/* 115:106 */         list.add(compras_merchant);
/* 116:    */       }
/* 117:111 */       close(rs);
/* 118:112 */       close(pstmt);
/* 119:    */     }
/* 120:    */     catch (SQLException e)
/* 121:    */     {
/* 122:114 */       close(rs);
/* 123:115 */       close(pstmt);
/* 124:116 */       rollback(conn);
/* 125:117 */       throw e;
/* 126:    */     }
/* 127:    */     finally
/* 128:    */     {
/* 129:119 */       close(conn);
/* 130:    */     }
/* 131:121 */     return list;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public Compras_merchant retrieveComplete(String code)
/* 135:    */     throws SQLException
/* 136:    */   {
/* 137:126 */     Compras_merchant compras_merchant = retriveByActivationCodeComplete(code);
/* 138:    */     
/* 139:    */ 
/* 140:    */ 
/* 141:130 */     return compras_merchant;
/* 142:    */   }
/* 143:    */   
/* 144:    */   public Compras_merchant retriveByActivationCode(String compras_licencias_codact)
/* 145:    */     throws SQLException
/* 146:    */   {
/* 147:135 */     Compras_merchant compras_merchant = new Compras_merchant();
/* 148:136 */     Connection conn = null;
/* 149:137 */     PreparedStatement pstmt = null;
/* 150:138 */     ResultSet rs = null;
/* 151:    */     try
/* 152:    */     {
/* 153:140 */       conn = this.ds.getConnection();
/* 154:141 */       String sql = "select compras_merchant.compras_merchant_cdgcmp from vega_sdoctor.compras_licencias join vega_sdoctor.compras_merchant on compras_licencias.compras_productos_id = compras_merchant.compras_merchant_id where compras_licencias.compras_licencias_codact = ?";
/* 155:142 */       pstmt = conn.prepareStatement(sql);
/* 156:143 */       pstmt.setString(1, compras_licencias_codact);
/* 157:144 */       rs = pstmt.executeQuery();
/* 158:145 */       if (rs.next())
/* 159:    */       {
/* 160:146 */         InicializaData.inicializa(compras_merchant.getClass(), compras_merchant);
/* 161:147 */         populate(compras_merchant, rs);
/* 162:    */       }
/* 163:149 */       close(rs);
/* 164:150 */       close(pstmt);
/* 165:    */     }
/* 166:    */     catch (SQLException e)
/* 167:    */     {
/* 168:152 */       close(rs);
/* 169:153 */       close(pstmt);
/* 170:154 */       rollback(conn);
/* 171:155 */       throw e;
/* 172:    */     }
/* 173:    */     finally
/* 174:    */     {
/* 175:157 */       close(conn);
/* 176:    */     }
/* 177:159 */     return compras_merchant;
/* 178:    */   }
/* 179:    */   
/* 180:    */   public Compras_merchant retriveByActivationCodeComplete(String compras_licencias_codact)
/* 181:    */     throws SQLException
/* 182:    */   {
/* 183:163 */     DBUtil db = new DBUtil("vega_sdoctor");
/* 184:164 */     Compras_merchant compras_merchant = new Compras_merchant();
/* 185:165 */     Connection conn = null;
/* 186:166 */     PreparedStatement pstmt = null;
/* 187:167 */     ResultSet rs = null;
/* 188:    */     try
/* 189:    */     {
/* 190:169 */       conn = this.ds.getConnection();
/* 191:170 */       String sql = db.creaSQLSELECT(compras_merchant);
/* 192:171 */       sql = sql + " where compras_merchant_id = ?";
/* 193:172 */       pstmt = conn.prepareStatement(sql);
/* 194:173 */       pstmt.setString(1, compras_licencias_codact);
/* 195:174 */       rs = pstmt.executeQuery();
/* 196:175 */       if (rs.next())
/* 197:    */       {
/* 198:176 */         InicializaData.inicializa(compras_merchant.getClass(), compras_merchant);
/* 199:177 */         populate(compras_merchant, rs);
/* 200:    */       }
/* 201:179 */       close(rs);
/* 202:180 */       close(pstmt);
/* 203:    */     }
/* 204:    */     catch (SQLException e)
/* 205:    */     {
/* 206:182 */       close(rs);
/* 207:183 */       close(pstmt);
/* 208:184 */       rollback(conn);
/* 209:185 */       throw e;
/* 210:    */     }
/* 211:    */     finally
/* 212:    */     {
/* 213:187 */       close(conn);
/* 214:    */     }
/* 215:189 */     return compras_merchant;
/* 216:    */   }
/* 217:    */   
/* 218:    */   public Compras_merchant retriveBySpecialCode(String compras_merchant_cogesp)
/* 219:    */     throws SQLException
/* 220:    */   {
/* 221:195 */     Compras_merchant compras_merchant = new Compras_merchant();
/* 222:196 */     Connection conn = null;
/* 223:197 */     PreparedStatement pstmt = null;
/* 224:198 */     ResultSet rs = null;
/* 225:    */     try
/* 226:    */     {
/* 227:200 */       conn = this.ds.getConnection();
/* 228:201 */       DBUtil util = new DBUtil("vega_sdoctor");
/* 229:202 */       String sql = util.creaSQLSELECT(new Compras_merchant()) + " where compras_merchant_cdgesp = ?";
/* 230:203 */       pstmt = conn.prepareStatement(sql);
/* 231:204 */       pstmt.setString(1, compras_merchant_cogesp);
/* 232:205 */       rs = pstmt.executeQuery();
/* 233:206 */       if (rs.next())
/* 234:    */       {
/* 235:207 */         InicializaData.inicializa(compras_merchant.getClass(), compras_merchant);
/* 236:208 */         populate(compras_merchant, rs);
/* 237:    */       }
/* 238:210 */       close(rs);
/* 239:211 */       close(pstmt);
/* 240:    */     }
/* 241:    */     catch (SQLException e)
/* 242:    */     {
/* 243:213 */       close(rs);
/* 244:214 */       close(pstmt);
/* 245:215 */       rollback(conn);
/* 246:216 */       throw e;
/* 247:    */     }
/* 248:    */     finally
/* 249:    */     {
/* 250:218 */       close(conn);
/* 251:    */     }
/* 252:220 */     return compras_merchant;
/* 253:    */   }
/* 254:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.seguridad.dao.Compras_merchantDAO
 * JD-Core Version:    0.7.0.1
 */