/*  1:   */ package com.servidoctor.seguridad.dao;
/*  2:   */ 
/*  3:   */ import com.servidoctor.common.dao.DAO;
/*  4:   */ import com.servidoctor.seguridad.model.Compras_productos;
/*  5:   */ import com.servidoctor.util.classes.DBUtil;
/*  6:   */ import com.servidoctor.util.classes.InicializaData;
/*  7:   */ import java.sql.Connection;
/*  8:   */ import java.sql.PreparedStatement;
/*  9:   */ import java.sql.ResultSet;
/* 10:   */ import java.sql.SQLException;
/* 11:   */ import java.util.ResourceBundle;
/* 12:   */ import javax.sql.DataSource;
/* 13:   */ 
/* 14:   */ public class Compras_productosDAO
/* 15:   */   extends DAO
/* 16:   */ {
/* 17:24 */   private static final ResourceBundle prop = ResourceBundle.getBundle("com.servidoctor.resources.Config");
/* 18:   */   
/* 19:   */   public Compras_productosDAO()
/* 20:   */   {
/* 21:27 */     super(prop.getString("jndi.vega.name"));
/* 22:   */   }
/* 23:   */   
/* 24:   */   public Compras_productos retrive(String compras_merchant_id)
/* 25:   */     throws SQLException
/* 26:   */   {
/* 27:32 */     Compras_productos compras_productos = new Compras_productos();
/* 28:33 */     Connection conn = null;
/* 29:34 */     PreparedStatement pstmt = null;
/* 30:35 */     ResultSet rs = null;
/* 31:   */     try
/* 32:   */     {
/* 33:37 */       conn = this.ds.getConnection();
/* 34:38 */       DBUtil util = new DBUtil("vega_sdoctor");
/* 35:39 */       String sql = util.creaSQLSELECT(new Compras_productos()) + " where compras_merchant_id = ?";
/* 36:40 */       pstmt = conn.prepareStatement(sql);
/* 37:41 */       pstmt.setString(1, compras_merchant_id);
/* 38:42 */       rs = pstmt.executeQuery();
/* 39:43 */       if (rs.next())
/* 40:   */       {
/* 41:44 */         InicializaData.inicializa(compras_productos.getClass(), compras_productos);
/* 42:45 */         populate(compras_productos, rs);
/* 43:   */       }
/* 44:47 */       close(rs);
/* 45:48 */       close(pstmt);
/* 46:   */     }
/* 47:   */     catch (SQLException e)
/* 48:   */     {
/* 49:50 */       close(rs);
/* 50:51 */       close(pstmt);
/* 51:52 */       rollback(conn);
/* 52:53 */       throw e;
/* 53:   */     }
/* 54:   */     finally
/* 55:   */     {
/* 56:55 */       close(conn);
/* 57:   */     }
/* 58:57 */     return compras_productos;
/* 59:   */   }
/* 60:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.seguridad.dao.Compras_productosDAO
 * JD-Core Version:    0.7.0.1
 */