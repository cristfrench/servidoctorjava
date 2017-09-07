/*   1:    */ package com.servidoctor.seguridad.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.seguridad.model.Compras_licencias;
/*   5:    */ import com.servidoctor.util.classes.DBUtil;
/*   6:    */ import com.servidoctor.util.classes.InicializaData;
/*   7:    */ import java.sql.Connection;
/*   8:    */ import java.sql.Date;
/*   9:    */ import java.sql.PreparedStatement;
/*  10:    */ import java.sql.ResultSet;
/*  11:    */ import java.sql.SQLException;
/*  12:    */ import java.util.ArrayList;
/*  13:    */ import java.util.List;
/*  14:    */ import java.util.ResourceBundle;
/*  15:    */ import javax.sql.DataSource;
/*  16:    */ 
/*  17:    */ public class Compras_licenciasDAO
/*  18:    */   extends DAO
/*  19:    */ {
/*  20: 29 */   private static final ResourceBundle prop = ResourceBundle.getBundle("com.servidoctor.resources.Config");
/*  21:    */   
/*  22:    */   public Compras_licenciasDAO()
/*  23:    */   {
/*  24: 32 */     super(prop.getString("jndi.vega.name"));
/*  25:    */   }
/*  26:    */   
/*  27:    */   public Compras_licencias retrive(String compras_licencias_codact)
/*  28:    */     throws SQLException
/*  29:    */   {
/*  30: 37 */     Compras_licencias compras_licencias = new Compras_licencias();
/*  31: 38 */     Connection conn = null;
/*  32: 39 */     PreparedStatement pstmt = null;
/*  33: 40 */     ResultSet rs = null;
/*  34: 41 */     Compras_licencias compras_licenciasS = new Compras_licencias();
/*  35:    */     try
/*  36:    */     {
/*  37: 43 */       conn = this.ds.getConnection();
/*  38: 44 */       DBUtil db = new DBUtil("vega_sdoctor");
/*  39: 45 */       String sql = db.creaSQLSELECT(compras_licenciasS);
/*  40: 46 */       String where = " where compras_licencias_codact = ?";
/*  41: 47 */       pstmt = conn.prepareStatement(sql + where);
/*  42: 48 */       pstmt.setString(1, compras_licencias_codact);
/*  43: 49 */       rs = pstmt.executeQuery();
/*  44: 50 */       if (rs.next())
/*  45:    */       {
/*  46: 53 */         compras_licencias.setCompras_licencias_actc(rs.getTimestamp("compras_licencias_actc"));
/*  47: 54 */         compras_licencias.setCompras_licencias_codact(rs.getString("compras_licencias_codact"));
/*  48: 55 */         compras_licencias.setCompras_licencias_datgc(rs.getDate("compras_licencias_datgc"));
/*  49:    */         try
/*  50:    */         {
/*  51: 57 */           compras_licencias.setCompras_licencias_dattl(rs.getDate("compras_licencias_dattl"));
/*  52:    */         }
/*  53:    */         catch (Exception localException) {}
/*  54: 60 */         compras_licencias.setCompras_licencias_nma(rs.getBigDecimal("compras_licencias_nma"));
/*  55: 61 */         compras_licencias.setCompras_productos_id(rs.getString("compras_productos_id"));
/*  56: 62 */         compras_licencias.setServer_id(rs.getBigDecimal("server_id"));
/*  57: 63 */         compras_licencias.setGrp_precio_id(rs.getBigDecimal("grp_precio_id"));
/*  58:    */       }
/*  59: 65 */       close(rs);
/*  60: 66 */       close(pstmt);
/*  61:    */     }
/*  62:    */     catch (SQLException e)
/*  63:    */     {
/*  64: 68 */       close(rs);
/*  65: 69 */       close(pstmt);
/*  66: 70 */       rollback(conn);
/*  67: 71 */       throw e;
/*  68:    */     }
/*  69:    */     finally
/*  70:    */     {
/*  71: 73 */       close(conn);
/*  72:    */     }
/*  73: 75 */     return compras_licencias;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public List<Compras_licencias> list(String compras_merchant_cdgcmp)
/*  77:    */     throws SQLException
/*  78:    */   {
/*  79: 79 */     ArrayList<Compras_licencias> list = new ArrayList();
/*  80: 80 */     Connection conn = null;
/*  81: 81 */     PreparedStatement pstmt = null;
/*  82: 82 */     ResultSet rs = null;
/*  83:    */     try
/*  84:    */     {
/*  85: 84 */       conn = this.ds.getConnection();
/*  86: 85 */       String sql = "select compras_licencias_codact from vega_sdoctor.compras_licencias join vega_sdoctor.compras_merchant on compras_licencias.compras_productos_id = compras_merchant.compras_merchant_id where compras_merchant.compras_merchant_cdgcmp = ?";
/*  87:    */       
/*  88:    */ 
/*  89:    */ 
/*  90:    */ 
/*  91: 90 */       pstmt = conn.prepareStatement(sql);
/*  92: 91 */       pstmt.setString(1, compras_merchant_cdgcmp);
/*  93: 92 */       rs = pstmt.executeQuery();
/*  94: 93 */       while (rs.next())
/*  95:    */       {
/*  96: 94 */         Compras_licencias compras_licencias = new Compras_licencias();
/*  97: 95 */         InicializaData.inicializa(compras_licencias.getClass(), compras_licencias);
/*  98: 96 */         populate(compras_licencias, rs);
/*  99: 97 */         list.add(compras_licencias);
/* 100:    */       }
/* 101: 99 */       close(rs);
/* 102:100 */       close(pstmt);
/* 103:    */     }
/* 104:    */     catch (SQLException e)
/* 105:    */     {
/* 106:102 */       close(rs);
/* 107:103 */       close(pstmt);
/* 108:104 */       rollback(conn);
/* 109:105 */       throw e;
/* 110:    */     }
/* 111:    */     finally
/* 112:    */     {
/* 113:107 */       close(conn);
/* 114:    */     }
/* 115:109 */     return list;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public List<Compras_licencias> listLicencias(String compras_merchant_cdgcmp)
/* 119:    */     throws SQLException
/* 120:    */   {
/* 121:114 */     ArrayList<Compras_licencias> list = new ArrayList();
/* 122:115 */     Connection conn = null;
/* 123:116 */     PreparedStatement pstmt = null;
/* 124:117 */     ResultSet rs = null;
/* 125:    */     try
/* 126:    */     {
/* 127:119 */       conn = this.ds.getConnection();
/* 128:120 */       String sql = "select * from vega_sdoctor.compras_licencias join vega_sdoctor.compras_merchant on compras_licencias.compras_productos_id = compras_merchant.compras_merchant_id where compras_merchant.compras_merchant_cdgcmp = ?";
/* 129:    */       
/* 130:    */ 
/* 131:    */ 
/* 132:    */ 
/* 133:125 */       pstmt = conn.prepareStatement(sql);
/* 134:126 */       pstmt.setString(1, compras_merchant_cdgcmp);
/* 135:127 */       rs = pstmt.executeQuery();
/* 136:128 */       while (rs.next())
/* 137:    */       {
/* 138:129 */         Compras_licencias compras_licencias = new Compras_licencias();
/* 139:130 */         compras_licencias.setCompras_productos_id(rs.getString("compras_productos_id"));
/* 140:131 */         compras_licencias.setGrp_precio_id(rs.getBigDecimal("grp_precio_id"));
/* 141:132 */         compras_licencias.setCompras_licencias_codact(rs.getString("compras_licencias_codact"));
/* 142:133 */         compras_licencias.setCompras_licencias_datgc(rs.getDate("compras_licencias_datgc"));
/* 143:134 */         compras_licencias.setCompras_licencias_actc(rs.getTimestamp("compras_licencias_actc"));
/* 144:135 */         compras_licencias.setCompras_licencias_nma(rs.getBigDecimal("compras_licencias_nma"));
/* 145:136 */         compras_licencias.setCompras_licencias_dattl(rs.getDate("compras_licencias_dattl"));
/* 146:137 */         compras_licencias.setServer_id(rs.getBigDecimal("server_id"));
/* 147:138 */         list.add(compras_licencias);
/* 148:    */       }
/* 149:140 */       close(rs);
/* 150:141 */       close(pstmt);
/* 151:    */     }
/* 152:    */     catch (SQLException e)
/* 153:    */     {
/* 154:143 */       close(rs);
/* 155:144 */       close(pstmt);
/* 156:145 */       rollback(conn);
/* 157:146 */       throw e;
/* 158:    */     }
/* 159:    */     finally
/* 160:    */     {
/* 161:148 */       close(conn);
/* 162:    */     }
/* 163:150 */     return list;
/* 164:    */   }
/* 165:    */   
/* 166:    */   public void update(Compras_licencias data)
/* 167:    */     throws SQLException
/* 168:    */   {
/* 169:154 */     Connection conn = null;
/* 170:155 */     PreparedStatement pstmt = null;
/* 171:    */     try
/* 172:    */     {
/* 173:157 */       conn = this.ds.getConnection();
/* 174:158 */       conn.setAutoCommit(false);
/* 175:159 */       String sql = "update vega_sdoctor.compras_licencias set compras_licencias.compras_licencias_actc = ?, compras_licencias.compras_licencias_dattl = ? where compras_licencias.compras_licencias_codact = ?";
/* 176:    */       
/* 177:    */ 
/* 178:162 */       pstmt = conn.prepareStatement(sql);
/* 179:163 */       pstmt.setTimestamp(1, data.getCompras_licencias_actc());
/* 180:164 */       pstmt.setDate(2, (Date)data.getCompras_licencias_dattl());
/* 181:165 */       pstmt.setString(3, data.getCompras_licencias_codact());
/* 182:166 */       pstmt.executeUpdate();
/* 183:167 */       close(pstmt);
/* 184:168 */       conn.commit();
/* 185:    */     }
/* 186:    */     catch (SQLException e)
/* 187:    */     {
/* 188:170 */       close(pstmt);
/* 189:171 */       rollback(conn);
/* 190:172 */       e.printStackTrace();
/* 191:    */     }
/* 192:    */     finally
/* 193:    */     {
/* 194:174 */       close(conn);
/* 195:    */     }
/* 196:    */   }
/* 197:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.seguridad.dao.Compras_licenciasDAO
 * JD-Core Version:    0.7.0.1
 */