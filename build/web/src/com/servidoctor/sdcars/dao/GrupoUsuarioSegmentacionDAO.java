/*   1:    */ package com.servidoctor.sdcars.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdcars.model.GrupoUsuarioSegmentacion;
/*   5:    */ import com.servidoctor.util.classes.DBUtil;
/*   6:    */ import com.servidoctor.util.classes.InicializaData;
/*   7:    */ import java.sql.Connection;
/*   8:    */ import java.sql.PreparedStatement;
/*   9:    */ import java.sql.ResultSet;
/*  10:    */ import java.sql.SQLException;
/*  11:    */ import java.util.ArrayList;
/*  12:    */ import java.util.List;
/*  13:    */ import java.util.ResourceBundle;
/*  14:    */ import javax.sql.DataSource;
/*  15:    */ 
/*  16:    */ public class GrupoUsuarioSegmentacionDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19: 27 */   private static final ResourceBundle prop = ResourceBundle.getBundle("com.servidoctor.resources.Config");
/*  20:    */   
/*  21:    */   public GrupoUsuarioSegmentacionDAO()
/*  22:    */   {
/*  23: 30 */     super(prop.getString("jndi.vega.name"));
/*  24:    */   }
/*  25:    */   
/*  26:    */   public GrupoUsuarioSegmentacion retrieve(String usuario)
/*  27:    */     throws SQLException
/*  28:    */   {
/*  29: 35 */     GrupoUsuarioSegmentacion grupoUsuarioSegmentacion = new GrupoUsuarioSegmentacion();
/*  30: 36 */     Connection conn = null;
/*  31: 37 */     PreparedStatement pstmt = null;
/*  32: 38 */     ResultSet rs = null;
/*  33: 39 */     GrupoUsuarioSegmentacion grupoUsuarioSSegmentacion = new GrupoUsuarioSegmentacion();
/*  34:    */     try
/*  35:    */     {
/*  36: 41 */       conn = this.ds.getConnection();
/*  37: 42 */       DBUtil db = new DBUtil("vega_sdoctor");
/*  38: 43 */       String sql = db.creaSQLSELECT(grupoUsuarioSSegmentacion);
/*  39: 44 */       String where = " where grupousuariosegmentacion.usuario_id = ?";
/*  40: 45 */       pstmt = conn.prepareStatement(sql + where);
/*  41: 46 */       pstmt.setString(1, usuario);
/*  42: 47 */       rs = pstmt.executeQuery();
/*  43: 48 */       if (rs.next())
/*  44:    */       {
/*  45: 51 */         grupoUsuarioSegmentacion.setGrupo_id(rs.getBigDecimal("grupo_id"));
/*  46: 52 */         grupoUsuarioSegmentacion.setUsuario_id(rs.getString("usuario_id"));
/*  47: 53 */         grupoUsuarioSegmentacion.setConsecutivo(rs.getBigDecimal("consecutivo"));
/*  48:    */       }
/*  49: 61 */       close(rs);
/*  50: 62 */       close(pstmt);
/*  51:    */     }
/*  52:    */     catch (SQLException e)
/*  53:    */     {
/*  54: 64 */       close(rs);
/*  55: 65 */       close(pstmt);
/*  56: 66 */       rollback(conn);
/*  57: 67 */       throw e;
/*  58:    */     }
/*  59:    */     finally
/*  60:    */     {
/*  61: 69 */       close(conn);
/*  62:    */     }
/*  63: 71 */     return grupoUsuarioSegmentacion;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public GrupoUsuarioSegmentacion retrive(String code)
/*  67:    */     throws SQLException
/*  68:    */   {
/*  69: 75 */     GrupoUsuarioSegmentacion grupoUsuarioSegmentacion = new GrupoUsuarioSegmentacion();
/*  70: 76 */     Connection conn = null;
/*  71: 77 */     PreparedStatement pstmt = null;
/*  72: 78 */     ResultSet rs = null;
/*  73: 79 */     GrupoUsuarioSegmentacion grupoUsuarioSSegmentacion = new GrupoUsuarioSegmentacion();
/*  74:    */     try
/*  75:    */     {
/*  76: 81 */       conn = this.ds.getConnection();
/*  77: 82 */       DBUtil db = new DBUtil("vega_sdoctor");
/*  78: 83 */       String sql = db.creaSQLSELECT(grupoUsuarioSSegmentacion);
/*  79: 84 */       String where = " where grupousuariosegmentacion.usuario_id = ?";
/*  80: 85 */       pstmt = conn.prepareStatement(sql + where);
/*  81: 86 */       pstmt.setString(1, code);
/*  82: 87 */       rs = pstmt.executeQuery();
/*  83: 88 */       if (rs.next())
/*  84:    */       {
/*  85: 91 */         grupoUsuarioSegmentacion.setGrupo_id(rs.getBigDecimal("grupo_id"));
/*  86: 92 */         grupoUsuarioSegmentacion.setUsuario_id(rs.getString("usuario_id"));
/*  87: 93 */         grupoUsuarioSegmentacion.setConsecutivo(rs.getBigDecimal("consecutivo"));
/*  88:    */       }
/*  89:101 */       close(rs);
/*  90:102 */       close(pstmt);
/*  91:    */     }
/*  92:    */     catch (SQLException e)
/*  93:    */     {
/*  94:104 */       close(rs);
/*  95:105 */       close(pstmt);
/*  96:106 */       rollback(conn);
/*  97:107 */       throw e;
/*  98:    */     }
/*  99:    */     finally
/* 100:    */     {
/* 101:109 */       close(conn);
/* 102:    */     }
/* 103:111 */     return grupoUsuarioSegmentacion;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public List<GrupoUsuarioSegmentacion> list(String compras_merchant_cdgcmp)
/* 107:    */     throws SQLException
/* 108:    */   {
/* 109:115 */     ArrayList<GrupoUsuarioSegmentacion> list = new ArrayList();
/* 110:116 */     Connection conn = null;
/* 111:117 */     PreparedStatement pstmt = null;
/* 112:118 */     ResultSet rs = null;
/* 113:    */     try
/* 114:    */     {
/* 115:120 */       conn = this.ds.getConnection();
/* 116:121 */       String sql = "select compras_licencias_codact from vega_sdoctor.grupousuariosegmentacion join vega_sdoctor.compras_merchant on grupousuariosegmentacion.compras_productos_id = compras_merchant.compras_merchant_id where compras_merchant.compras_merchant_cdgcmp = ?";
/* 117:    */       
/* 118:    */ 
/* 119:    */ 
/* 120:    */ 
/* 121:126 */       pstmt = conn.prepareStatement(sql);
/* 122:127 */       pstmt.setString(1, compras_merchant_cdgcmp);
/* 123:128 */       rs = pstmt.executeQuery();
/* 124:129 */       while (rs.next())
/* 125:    */       {
/* 126:130 */         GrupoUsuarioSegmentacion grupoUsuarioSegmentacion = new GrupoUsuarioSegmentacion();
/* 127:131 */         InicializaData.inicializa(grupoUsuarioSegmentacion.getClass(), grupoUsuarioSegmentacion);
/* 128:132 */         populate(grupoUsuarioSegmentacion, rs);
/* 129:133 */         list.add(grupoUsuarioSegmentacion);
/* 130:    */       }
/* 131:135 */       close(rs);
/* 132:136 */       close(pstmt);
/* 133:    */     }
/* 134:    */     catch (SQLException e)
/* 135:    */     {
/* 136:138 */       close(rs);
/* 137:139 */       close(pstmt);
/* 138:140 */       rollback(conn);
/* 139:141 */       throw e;
/* 140:    */     }
/* 141:    */     finally
/* 142:    */     {
/* 143:143 */       close(conn);
/* 144:    */     }
/* 145:145 */     return list;
/* 146:    */   }
/* 147:    */   
/* 148:    */   public void update(GrupoUsuarioSegmentacion data)
/* 149:    */     throws SQLException
/* 150:    */   {
/* 151:149 */     Connection conn = null;
/* 152:150 */     PreparedStatement pstmt = null;
/* 153:    */     try
/* 154:    */     {
/* 155:152 */       conn = this.ds.getConnection();
/* 156:153 */       conn.setAutoCommit(false);
/* 157:154 */       String sql = "update vega_sdoctor.grupousuariosegmentacion set grupousuariosegmentacion.consecutivo = ?, grupousuariosegmentacion.usuario_id = ? , grupousuariosegmentacion.grupo_id = ? where grupousuariosegmentacion.consecutivo = ?";
/* 158:    */       
/* 159:    */ 
/* 160:157 */       pstmt = conn.prepareStatement(sql);
/* 161:    */       
/* 162:    */ 
/* 163:160 */       pstmt.setBigDecimal(1, data.getConsecutivo());
/* 164:161 */       pstmt.setString(2, data.getUsuario_id());
/* 165:162 */       pstmt.setBigDecimal(3, data.getGrupo_id());
/* 166:163 */       pstmt.setBigDecimal(4, data.getConsecutivo());
/* 167:164 */       pstmt.executeUpdate();
/* 168:165 */       close(pstmt);
/* 169:166 */       conn.commit();
/* 170:    */     }
/* 171:    */     catch (SQLException e)
/* 172:    */     {
/* 173:168 */       close(pstmt);
/* 174:169 */       rollback(conn);
/* 175:170 */       e.printStackTrace();
/* 176:    */     }
/* 177:    */     finally
/* 178:    */     {
/* 179:172 */       close(conn);
/* 180:    */     }
/* 181:    */   }
/* 182:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdcars.dao.GrupoUsuarioSegmentacionDAO
 * JD-Core Version:    0.7.0.1
 */