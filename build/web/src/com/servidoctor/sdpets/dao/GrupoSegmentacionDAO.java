/*   1:    */ package com.servidoctor.sdpets.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdpets.model.GrupoSegmentacion;
/*   5:    */ import com.servidoctor.util.classes.DBUtil;
/*   6:    */ import java.math.BigDecimal;
/*   7:    */ import java.sql.Connection;
/*   8:    */ import java.sql.PreparedStatement;
/*   9:    */ import java.sql.ResultSet;
/*  10:    */ import java.sql.SQLException;
/*  11:    */ import java.util.ResourceBundle;
/*  12:    */ import javax.sql.DataSource;
/*  13:    */ 
/*  14:    */ public class GrupoSegmentacionDAO
/*  15:    */   extends DAO
/*  16:    */ {
/*  17: 25 */   private static final ResourceBundle prop = ResourceBundle.getBundle("com.servidoctor.resources.Config");
/*  18:    */   
/*  19:    */   public GrupoSegmentacionDAO()
/*  20:    */   {
/*  21: 28 */     super(prop.getString("jndi.vega.name"));
/*  22:    */   }
/*  23:    */   
/*  24:    */   public GrupoSegmentacion retrive(BigDecimal consecutivo)
/*  25:    */     throws SQLException
/*  26:    */   {
/*  27: 33 */     GrupoSegmentacion grupoSegmentacion = new GrupoSegmentacion();
/*  28: 34 */     Connection conn = null;
/*  29: 35 */     PreparedStatement pstmt = null;
/*  30: 36 */     ResultSet rs = null;
/*  31: 37 */     GrupoSegmentacion grupoSSegmentacion = new GrupoSegmentacion();
/*  32:    */     try
/*  33:    */     {
/*  34: 39 */       conn = this.ds.getConnection();
/*  35: 40 */       DBUtil db = new DBUtil("vega_sdoctor");
/*  36: 41 */       String sql = db.creaSQLSELECT(grupoSSegmentacion);
/*  37: 42 */       String where = " where gruposegmentacion.consecutivo = ?";
/*  38: 43 */       pstmt = conn.prepareStatement(sql + where);
/*  39: 44 */       pstmt.setBigDecimal(1, consecutivo);
/*  40: 45 */       rs = pstmt.executeQuery();
/*  41: 46 */       if (rs.next())
/*  42:    */       {
/*  43: 49 */         grupoSegmentacion.setCod_usuario(rs.getString("cod_usuario"));
/*  44: 50 */         grupoSegmentacion.setNombre_grupo(rs.getString("nombre_grupo"));
/*  45: 51 */         grupoSegmentacion.setAfiliado(rs.getString("afiliado"));
/*  46: 52 */         grupoSegmentacion.setConsecutivo(rs.getBigDecimal("consecutivo"));
/*  47:    */       }
/*  48: 60 */       close(rs);
/*  49: 61 */       close(pstmt);
/*  50:    */     }
/*  51:    */     catch (SQLException e)
/*  52:    */     {
/*  53: 63 */       close(rs);
/*  54: 64 */       close(pstmt);
/*  55: 65 */       rollback(conn);
/*  56: 66 */       throw e;
/*  57:    */     }
/*  58:    */     finally
/*  59:    */     {
/*  60: 68 */       close(conn);
/*  61:    */     }
/*  62: 70 */     return grupoSegmentacion;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public void update(GrupoSegmentacion data)
/*  66:    */     throws SQLException
/*  67:    */   {
/*  68:108 */     Connection conn = null;
/*  69:109 */     PreparedStatement pstmt = null;
/*  70:    */     try
/*  71:    */     {
/*  72:111 */       conn = this.ds.getConnection();
/*  73:112 */       conn.setAutoCommit(false);
/*  74:113 */       String sql = "update vega_sdoctor.gruposegmentacion set gruposegmentacion.consecutivo = ?, gruposegmentacion.cod_usuario = ? , gruposegmentacion.nombre_grupo = ?, gruposegmentacion.afiliado = ? where gruposegmentacion.consecutivo = ?";
/*  75:    */       
/*  76:    */ 
/*  77:116 */       pstmt = conn.prepareStatement(sql);
/*  78:    */       
/*  79:    */ 
/*  80:119 */       pstmt.setBigDecimal(1, data.getConsecutivo());
/*  81:120 */       pstmt.setString(2, data.getCod_usuario());
/*  82:121 */       pstmt.setString(3, data.getNombre_grupo());
/*  83:122 */       pstmt.setString(4, data.getAfiliado());
/*  84:123 */       pstmt.setBigDecimal(5, data.getConsecutivo());
/*  85:124 */       pstmt.executeUpdate();
/*  86:125 */       close(pstmt);
/*  87:126 */       conn.commit();
/*  88:    */     }
/*  89:    */     catch (SQLException e)
/*  90:    */     {
/*  91:128 */       close(pstmt);
/*  92:129 */       rollback(conn);
/*  93:130 */       e.printStackTrace();
/*  94:    */     }
/*  95:    */     finally
/*  96:    */     {
/*  97:132 */       close(conn);
/*  98:    */     }
/*  99:    */   }
/* 100:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdpets.dao.GrupoSegmentacionDAO
 * JD-Core Version:    0.7.0.1
 */