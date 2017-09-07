/*   1:    */ package com.servidoctor.sdpets.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdpets.model.LogoComprador;
/*   5:    */ import com.servidoctor.util.classes.DBUtil;
/*   6:    */ import com.servidoctor.util.classes.InicializaData;
/*   7:    */ import java.math.BigDecimal;
/*   8:    */ import java.sql.Connection;
/*   9:    */ import java.sql.PreparedStatement;
/*  10:    */ import java.sql.ResultSet;
/*  11:    */ import java.sql.SQLException;
/*  12:    */ import java.util.ArrayList;
/*  13:    */ import java.util.List;
/*  14:    */ import java.util.ResourceBundle;
/*  15:    */ import javax.sql.DataSource;
/*  16:    */ 
/*  17:    */ public class LogoCompradorDAO
/*  18:    */   extends DAO
/*  19:    */ {
/*  20: 28 */   private static final ResourceBundle prop = ResourceBundle.getBundle("com.servidoctor.resources.Config");
/*  21:    */   
/*  22:    */   public LogoCompradorDAO()
/*  23:    */   {
/*  24: 31 */     super(prop.getString("jndi.vega.name"));
/*  25:    */   }
/*  26:    */   
/*  27:    */   public LogoComprador retrieve(BigDecimal grupo, Integer fechaactual)
/*  28:    */     throws SQLException
/*  29:    */   {
/*  30: 36 */     LogoComprador logoComprador = new LogoComprador();
/*  31: 37 */     Connection conn = null;
/*  32: 38 */     PreparedStatement pstmt = null;
/*  33: 39 */     ResultSet rs = null;
/*  34: 40 */     LogoComprador logoCompradorS = new LogoComprador();
/*  35:    */     try
/*  36:    */     {
/*  37: 42 */       conn = this.ds.getConnection();
/*  38: 43 */       DBUtil db = new DBUtil("vega_sdoctor");
/*  39: 44 */       String sql = db.creaSQLSELECT(logoCompradorS);
/*  40: 45 */       String where = " where logocomprador.logc_id_grupo = ? AND logocomprador.logc_fecini <= ? AND logocomprador.logc_fecfin >= ?";
/*  41: 46 */       pstmt = conn.prepareStatement(sql + where);
/*  42: 47 */       pstmt.setBigDecimal(1, grupo);
/*  43: 48 */       pstmt.setString(2, fechaactual.toString());
/*  44: 49 */       pstmt.setString(3, fechaactual.toString());
/*  45: 50 */       rs = pstmt.executeQuery();
/*  46: 51 */       if (rs.next())
/*  47:    */       {
/*  48: 54 */         logoComprador.setConsecutivo(rs.getBigDecimal("consecutivo"));
/*  49: 55 */         logoComprador.setLogc_id_grupo(rs.getBigDecimal("logc_id_grupo"));
/*  50: 56 */         logoComprador.setLogc_fecini(rs.getString("logc_fecini"));
/*  51: 57 */         logoComprador.setLogc_fecfin(rs.getString("logc_fecfin"));
/*  52: 58 */         logoComprador.setLogc_html_code(rs.getString("logc_html_code"));
/*  53: 59 */         logoComprador.setClickizquierdo(rs.getString("clickizquierdo"));
/*  54: 60 */         logoComprador.setClickderecho(rs.getString("clickderecho"));
/*  55:    */       }
/*  56: 68 */       close(rs);
/*  57: 69 */       close(pstmt);
/*  58:    */     }
/*  59:    */     catch (SQLException e)
/*  60:    */     {
/*  61: 71 */       close(rs);
/*  62: 72 */       close(pstmt);
/*  63: 73 */       rollback(conn);
/*  64: 74 */       throw e;
/*  65:    */     }
/*  66:    */     finally
/*  67:    */     {
/*  68: 76 */       close(conn);
/*  69:    */     }
/*  70: 78 */     return logoComprador;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public List<LogoComprador> list(String compras_merchant_cdgcmp)
/*  74:    */     throws SQLException
/*  75:    */   {
/*  76: 82 */     ArrayList<LogoComprador> list = new ArrayList();
/*  77: 83 */     Connection conn = null;
/*  78: 84 */     PreparedStatement pstmt = null;
/*  79: 85 */     ResultSet rs = null;
/*  80:    */     try
/*  81:    */     {
/*  82: 87 */       conn = this.ds.getConnection();
/*  83: 88 */       String sql = "select compras_licencias_codact from vega_sdoctor.grupo join vega_sdoctor.compras_merchant on grupo.compras_productos_id = compras_merchant.compras_merchant_id where compras_merchant.compras_merchant_cdgcmp = ?";
/*  84:    */       
/*  85:    */ 
/*  86:    */ 
/*  87:    */ 
/*  88: 93 */       pstmt = conn.prepareStatement(sql);
/*  89: 94 */       pstmt.setString(1, compras_merchant_cdgcmp);
/*  90: 95 */       rs = pstmt.executeQuery();
/*  91: 96 */       while (rs.next())
/*  92:    */       {
/*  93: 97 */         LogoComprador logoComprador = new LogoComprador();
/*  94: 98 */         InicializaData.inicializa(logoComprador.getClass(), logoComprador);
/*  95: 99 */         populate(logoComprador, rs);
/*  96:100 */         list.add(logoComprador);
/*  97:    */       }
/*  98:102 */       close(rs);
/*  99:103 */       close(pstmt);
/* 100:    */     }
/* 101:    */     catch (SQLException e)
/* 102:    */     {
/* 103:105 */       close(rs);
/* 104:106 */       close(pstmt);
/* 105:107 */       rollback(conn);
/* 106:108 */       throw e;
/* 107:    */     }
/* 108:    */     finally
/* 109:    */     {
/* 110:110 */       close(conn);
/* 111:    */     }
/* 112:112 */     return list;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public void update(LogoComprador data)
/* 116:    */     throws SQLException
/* 117:    */   {
/* 118:116 */     Connection conn = null;
/* 119:117 */     PreparedStatement pstmt = null;
/* 120:    */     try
/* 121:    */     {
/* 122:119 */       conn = this.ds.getConnection();
/* 123:120 */       conn.setAutoCommit(false);
/* 124:121 */       String sql = "update vega_sdoctor.logocomprador set logocomprador.consecutivo = ?, logocomprador.usuario_id = ? , logocomprador.grupo_id = ? where logocomprador.consecutivo = ?";
/* 125:    */       
/* 126:    */ 
/* 127:124 */       pstmt = conn.prepareStatement(sql);
/* 128:    */       
/* 129:    */ 
/* 130:127 */       pstmt.setBigDecimal(1, data.getConsecutivo());
/* 131:128 */       pstmt.setBigDecimal(2, data.getLogc_id_grupo());
/* 132:129 */       pstmt.setString(3, data.getLogc_fecini());
/* 133:130 */       pstmt.setString(4, data.getLogc_fecfin());
/* 134:131 */       pstmt.setString(5, data.getLogc_html_code());
/* 135:132 */       pstmt.setBigDecimal(6, data.getConsecutivo());
/* 136:133 */       pstmt.executeUpdate();
/* 137:    */       
/* 138:135 */       close(pstmt);
/* 139:136 */       conn.commit();
/* 140:    */     }
/* 141:    */     catch (SQLException e)
/* 142:    */     {
/* 143:138 */       close(pstmt);
/* 144:139 */       rollback(conn);
/* 145:140 */       e.printStackTrace();
/* 146:    */     }
/* 147:    */     finally
/* 148:    */     {
/* 149:142 */       close(conn);
/* 150:    */     }
/* 151:    */   }
/* 152:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdpets.dao.LogoCompradorDAO
 * JD-Core Version:    0.7.0.1
 */