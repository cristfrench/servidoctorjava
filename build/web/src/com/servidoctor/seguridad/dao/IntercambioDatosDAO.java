/*  1:   */ package com.servidoctor.seguridad.dao;
/*  2:   */ 
/*  3:   */ import com.servidoctor.common.dao.DAO;
/*  4:   */ import com.servidoctor.seguridad.model.IntercambioDatos;
/*  5:   */ import com.servidoctor.util.classes.DBUtil;
/*  6:   */ import com.servidoctor.util.classes.InicializaData;
/*  7:   */ import java.math.BigDecimal;
/*  8:   */ import java.sql.Connection;
/*  9:   */ import java.sql.PreparedStatement;
/* 10:   */ import java.sql.ResultSet;
/* 11:   */ import java.sql.SQLException;
/* 12:   */ import javax.sql.DataSource;
/* 13:   */ 
/* 14:   */ public class IntercambioDatosDAO
/* 15:   */   extends DAO
/* 16:   */ {
/* 17:   */   public IntercambioDatos retrive(BigDecimal usu_cod)
/* 18:   */     throws SQLException
/* 19:   */   {
/* 20:17 */     IntercambioDatos intercambioDatos = new IntercambioDatos();
/* 21:18 */     Connection conn = null;
/* 22:19 */     PreparedStatement pstmt = null;
/* 23:20 */     ResultSet rs = null;
/* 24:21 */     IntercambioDatos intercambioDatosS = new IntercambioDatos();
/* 25:   */     try
/* 26:   */     {
/* 27:23 */       conn = this.ds.getConnection();
/* 28:24 */       DBUtil db = new DBUtil();
/* 29:25 */       String sql = db.creaSQLSELECT(intercambioDatosS);
/* 30:26 */       String where = " where usu_cod = ?";
/* 31:27 */       pstmt = conn.prepareStatement(sql + where);
/* 32:28 */       pstmt.setBigDecimal(1, usu_cod);
/* 33:29 */       rs = pstmt.executeQuery();
/* 34:30 */       if (rs.next())
/* 35:   */       {
/* 36:31 */         InicializaData.inicializa(intercambioDatos.getClass(), intercambioDatos);
/* 37:32 */         populate(intercambioDatos, rs);
/* 38:   */       }
/* 39:34 */       close(rs);
/* 40:35 */       close(pstmt);
/* 41:   */     }
/* 42:   */     catch (SQLException e)
/* 43:   */     {
/* 44:37 */       close(rs);
/* 45:38 */       close(pstmt);
/* 46:39 */       rollback(conn);
/* 47:40 */       throw e;
/* 48:   */     }
/* 49:   */     finally
/* 50:   */     {
/* 51:42 */       close(conn);
/* 52:   */     }
/* 53:44 */     return intercambioDatos;
/* 54:   */   }
/* 55:   */   
/* 56:   */   public synchronized void insert(IntercambioDatos data)
/* 57:   */     throws SQLException
/* 58:   */   {
/* 59:48 */     Connection conn = null;
/* 60:49 */     PreparedStatement pstmt = null;
/* 61:   */     
/* 62:51 */     ResultSet rs = null;
/* 63:   */     try
/* 64:   */     {
/* 65:53 */       int id = 0;
/* 66:54 */       DBUtil db = new DBUtil();
/* 67:55 */       conn = this.ds.getConnection();
/* 68:56 */       conn.setAutoCommit(false);
/* 69:57 */       String sql = db.creaSQLINSERT(data);
/* 70:58 */       pstmt = conn.prepareStatement(sql);
/* 71:59 */       pstmt.executeUpdate();
/* 72:60 */       pstmt.close();
/* 73:61 */       conn.commit();
/* 74:   */     }
/* 75:   */     catch (SQLException sqle)
/* 76:   */     {
/* 77:63 */       close(rs);
/* 78:64 */       close(pstmt);
/* 79:65 */       rollback(conn);
/* 80:66 */       throw sqle;
/* 81:   */     }
/* 82:   */     finally
/* 83:   */     {
/* 84:68 */       close(rs);
/* 85:69 */       close(pstmt);
/* 86:70 */       close(conn);
/* 87:   */     }
/* 88:   */   }
/* 89:   */   
/* 90:   */   public void delete(IntercambioDatos data)
/* 91:   */     throws SQLException
/* 92:   */   {
/* 93:75 */     Connection conn = null;
/* 94:76 */     PreparedStatement pstmt = null;
/* 95:   */     try
/* 96:   */     {
/* 97:78 */       conn = this.ds.getConnection();
/* 98:79 */       conn.setAutoCommit(false);
/* 99:80 */       String sql = "DELETE FROM sdoctor.intercambiodatos WHERE usu_cod = ?";
/* :0:81 */       pstmt = conn.prepareStatement(sql);
/* :1:82 */       pstmt.setBigDecimal(1, data.getUsu_cod());
/* :2:83 */       pstmt.executeUpdate();
/* :3:84 */       close(pstmt);
/* :4:85 */       conn.commit();
/* :5:   */     }
/* :6:   */     catch (SQLException e)
/* :7:   */     {
/* :8:87 */       close(pstmt);
/* :9:88 */       rollback(conn);
/* ;0:89 */       throw e;
/* ;1:   */     }
/* ;2:   */     finally
/* ;3:   */     {
/* ;4:91 */       close(conn);
/* ;5:   */     }
/* ;6:   */   }
/* ;7:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.seguridad.dao.IntercambioDatosDAO
 * JD-Core Version:    0.7.0.1
 */