/*  1:   */ package com.servidoctor.sdfamily.dao;
/*  2:   */ 
/*  3:   */ import com.servidoctor.common.dao.DAO;
/*  4:   */ import com.servidoctor.sdfamily.model.UsuarioParent;
/*  5:   */ import com.servidoctor.util.classes.DBUtil;
/*  6:   */ import com.servidoctor.util.classes.InicializaData;
/*  7:   */ import java.math.BigDecimal;
/*  8:   */ import java.sql.Connection;
/*  9:   */ import java.sql.PreparedStatement;
/* 10:   */ import java.sql.ResultSet;
/* 11:   */ import java.sql.SQLException;
/* 12:   */ import javax.sql.DataSource;
/* 13:   */ 
/* 14:   */ public class UsuarioParentDAO
/* 15:   */   extends DAO
/* 16:   */ {
/* 17:   */   public void update(UsuarioParent data, String[] llaves, Connection conn)
/* 18:   */     throws SQLException
/* 19:   */   {
/* 20:24 */     PreparedStatement pstmt = null;
/* 21:   */     try
/* 22:   */     {
/* 23:26 */       DBUtil db = new DBUtil();
/* 24:27 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 25:28 */       pstmt = conn.prepareStatement(sql);
/* 26:29 */       pstmt.executeUpdate();
/* 27:   */     }
/* 28:   */     catch (SQLException e)
/* 29:   */     {
/* 30:31 */       throw e;
/* 31:   */     }
/* 32:   */     finally
/* 33:   */     {
/* 34:33 */       close(pstmt);
/* 35:   */     }
/* 36:   */   }
/* 37:   */   
/* 38:   */   public UsuarioParent retrieve(BigDecimal parent_usuf_cod)
/* 39:   */     throws SQLException
/* 40:   */   {
/* 41:39 */     UsuarioParent usuarioParent = new UsuarioParent();
/* 42:40 */     Connection conn = null;
/* 43:41 */     PreparedStatement pstmt = null;
/* 44:42 */     ResultSet rs = null;
/* 45:43 */     UsuarioParent usuarioParentS = new UsuarioParent();
/* 46:   */     try
/* 47:   */     {
/* 48:45 */       conn = this.ds.getConnection();
/* 49:46 */       DBUtil db = new DBUtil();
/* 50:47 */       String sql = db.creaSQLSELECT(usuarioParentS);
/* 51:48 */       String where = " where parent_usuf_cod = " + parent_usuf_cod;
/* 52:49 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 53:50 */       rs = pstmt.executeQuery();
/* 54:51 */       if (rs.next())
/* 55:   */       {
/* 56:52 */         InicializaData.inicializa(usuarioParent.getClass(), usuarioParent);
/* 57:53 */         populate(usuarioParent, rs);
/* 58:   */       }
/* 59:55 */       close(rs);
/* 60:56 */       close(pstmt);
/* 61:   */     }
/* 62:   */     catch (SQLException e)
/* 63:   */     {
/* 64:58 */       close(rs);
/* 65:59 */       close(pstmt);
/* 66:60 */       rollback(conn);
/* 67:61 */       throw e;
/* 68:   */     }
/* 69:   */     finally
/* 70:   */     {
/* 71:63 */       close(conn);
/* 72:   */     }
/* 73:65 */     return usuarioParent;
/* 74:   */   }
/* 75:   */   
/* 76:   */   public synchronized void insert(UsuarioParent data, Connection conn)
/* 77:   */     throws SQLException
/* 78:   */   {
/* 79:69 */     PreparedStatement pstmt = null;
/* 80:   */     try
/* 81:   */     {
/* 82:71 */       DBUtil db = new DBUtil();
/* 83:   */       
/* 84:73 */       String sql = db.creaSQLINSERT(data);
/* 85:   */       
/* 86:75 */       pstmt = conn.prepareStatement(sql);
/* 87:76 */       pstmt.executeUpdate();
/* 88:   */     }
/* 89:   */     catch (SQLException sqle)
/* 90:   */     {
/* 91:78 */       throw sqle;
/* 92:   */     }
/* 93:   */     finally
/* 94:   */     {
/* 95:80 */       close(pstmt);
/* 96:   */     }
/* 97:   */   }
/* 98:   */   
/* 99:   */   public void delete(BigDecimal parent_usuf_cod, Connection conn)
/* :0:   */     throws SQLException
/* :1:   */   {
/* :2:85 */     PreparedStatement pstmt = null;
/* :3:   */     try
/* :4:   */     {
/* :5:87 */       String sql = "DELETE FROM sdoctor.usuarioparent WHERE parent_usuf_cod = ?";
/* :6:88 */       pstmt = conn.prepareStatement(sql);
/* :7:89 */       pstmt.setBigDecimal(1, parent_usuf_cod);
/* :8:90 */       pstmt.executeUpdate();
/* :9:   */     }
/* ;0:   */     catch (SQLException e)
/* ;1:   */     {
/* ;2:92 */       throw e;
/* ;3:   */     }
/* ;4:   */     finally
/* ;5:   */     {
/* ;6:94 */       close(pstmt);
/* ;7:   */     }
/* ;8:   */   }
/* ;9:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.dao.UsuarioParentDAO
 * JD-Core Version:    0.7.0.1
 */