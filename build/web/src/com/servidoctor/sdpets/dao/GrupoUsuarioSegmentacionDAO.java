/*   1:    */ package com.servidoctor.sdpets.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdpets.model.GrupoUsuarioSegmentacion;
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
/*  69: 76 */     GrupoUsuarioSegmentacion grupoUsuarioSegmentacion = new GrupoUsuarioSegmentacion();
/*  70: 77 */     Connection conn = null;
/*  71: 78 */     PreparedStatement pstmt = null;
/*  72: 79 */     ResultSet rs = null;
/*  73: 80 */     GrupoUsuarioSegmentacion grupoUsuarioSSegmentacion = new GrupoUsuarioSegmentacion();
/*  74:    */     try
/*  75:    */     {
/*  76: 82 */       conn = this.ds.getConnection();
/*  77: 83 */       DBUtil db = new DBUtil("vega_sdoctor");
/*  78: 84 */       String sql = db.creaSQLSELECT(grupoUsuarioSSegmentacion);
/*  79: 85 */       String where = " where grupousuariosegmentacion.usuario_id = ?";
/*  80: 86 */       pstmt = conn.prepareStatement(sql + where);
/*  81: 87 */       pstmt.setString(1, code);
/*  82: 88 */       rs = pstmt.executeQuery();
/*  83: 89 */       if (rs.next())
/*  84:    */       {
/*  85: 92 */         grupoUsuarioSegmentacion.setGrupo_id(rs.getBigDecimal("grupo_id"));
/*  86: 93 */         grupoUsuarioSegmentacion.setUsuario_id(rs.getString("usuario_id"));
/*  87: 94 */         grupoUsuarioSegmentacion.setConsecutivo(rs.getBigDecimal("consecutivo"));
/*  88:    */       }
/*  89:102 */       close(rs);
/*  90:103 */       close(pstmt);
/*  91:    */     }
/*  92:    */     catch (SQLException e)
/*  93:    */     {
/*  94:105 */       close(rs);
/*  95:106 */       close(pstmt);
/*  96:107 */       rollback(conn);
/*  97:108 */       throw e;
/*  98:    */     }
/*  99:    */     finally
/* 100:    */     {
/* 101:110 */       close(conn);
/* 102:    */     }
/* 103:112 */     return grupoUsuarioSegmentacion;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public List<GrupoUsuarioSegmentacion> list(String compras_merchant_cdgcmp)
/* 107:    */     throws SQLException
/* 108:    */   {
/* 109:116 */     ArrayList<GrupoUsuarioSegmentacion> list = new ArrayList();
/* 110:117 */     Connection conn = null;
/* 111:118 */     PreparedStatement pstmt = null;
/* 112:119 */     ResultSet rs = null;
/* 113:    */     try
/* 114:    */     {
/* 115:121 */       conn = this.ds.getConnection();
/* 116:122 */       String sql = "select compras_licencias_codact from vega_sdoctor.grupousuariosegmentacion join vega_sdoctor.compras_merchant on grupousuariosegmentacion.compras_productos_id = compras_merchant.compras_merchant_id where compras_merchant.compras_merchant_cdgcmp = ?";
/* 117:    */       
/* 118:    */ 
/* 119:    */ 
/* 120:    */ 
/* 121:127 */       pstmt = conn.prepareStatement(sql);
/* 122:128 */       pstmt.setString(1, compras_merchant_cdgcmp);
/* 123:129 */       rs = pstmt.executeQuery();
/* 124:130 */       while (rs.next())
/* 125:    */       {
/* 126:131 */         GrupoUsuarioSegmentacion grupoUsuarioSegmentacion = new GrupoUsuarioSegmentacion();
/* 127:132 */         InicializaData.inicializa(grupoUsuarioSegmentacion.getClass(), grupoUsuarioSegmentacion);
/* 128:133 */         populate(grupoUsuarioSegmentacion, rs);
/* 129:134 */         list.add(grupoUsuarioSegmentacion);
/* 130:    */       }
/* 131:136 */       close(rs);
/* 132:137 */       close(pstmt);
/* 133:    */     }
/* 134:    */     catch (SQLException e)
/* 135:    */     {
/* 136:139 */       close(rs);
/* 137:140 */       close(pstmt);
/* 138:141 */       rollback(conn);
/* 139:142 */       throw e;
/* 140:    */     }
/* 141:    */     finally
/* 142:    */     {
/* 143:144 */       close(conn);
/* 144:    */     }
/* 145:146 */     return list;
/* 146:    */   }
/* 147:    */   
/* 148:    */   public void update(GrupoUsuarioSegmentacion data)
/* 149:    */     throws SQLException
/* 150:    */   {
/* 151:150 */     Connection conn = null;
/* 152:151 */     PreparedStatement pstmt = null;
/* 153:    */     try
/* 154:    */     {
/* 155:153 */       conn = this.ds.getConnection();
/* 156:154 */       conn.setAutoCommit(false);
/* 157:155 */       String sql = "update vega_sdoctor.grupousuariosegmentacion set grupousuariosegmentacion.consecutivo = ?, grupousuariosegmentacion.usuario_id = ? , grupousuariosegmentacion.grupo_id = ? where grupousuariosegmentacion.consecutivo = ?";
/* 158:    */       
/* 159:    */ 
/* 160:158 */       pstmt = conn.prepareStatement(sql);
/* 161:    */       
/* 162:    */ 
/* 163:161 */       pstmt.setBigDecimal(1, data.getConsecutivo());
/* 164:162 */       pstmt.setString(2, data.getUsuario_id());
/* 165:163 */       pstmt.setBigDecimal(3, data.getGrupo_id());
/* 166:164 */       pstmt.setBigDecimal(4, data.getConsecutivo());
/* 167:165 */       pstmt.executeUpdate();
/* 168:166 */       close(pstmt);
/* 169:167 */       conn.commit();
/* 170:    */     }
/* 171:    */     catch (SQLException e)
/* 172:    */     {
/* 173:169 */       close(pstmt);
/* 174:170 */       rollback(conn);
/* 175:171 */       e.printStackTrace();
/* 176:    */     }
/* 177:    */     finally
/* 178:    */     {
/* 179:173 */       close(conn);
/* 180:    */     }
/* 181:    */   }
/* 182:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdpets.dao.GrupoUsuarioSegmentacionDAO
 * JD-Core Version:    0.7.0.1
 */