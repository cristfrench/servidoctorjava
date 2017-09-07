/*  1:   */ package com.servidoctor.sdfamily.dao;
/*  2:   */ 
/*  3:   */ import com.servidoctor.common.dao.DAO;
/*  4:   */ import com.servidoctor.sdfamily.model.Ginecologia;
/*  5:   */ import com.servidoctor.util.classes.DBUtil;
/*  6:   */ import com.servidoctor.util.classes.InicializaData;
/*  7:   */ import java.math.BigDecimal;
/*  8:   */ import java.sql.Connection;
/*  9:   */ import java.sql.PreparedStatement;
/* 10:   */ import java.sql.ResultSet;
/* 11:   */ import java.sql.SQLException;
/* 12:   */ import javax.sql.DataSource;
/* 13:   */ 
/* 14:   */ public class GinecologiaDAO
/* 15:   */   extends DAO
/* 16:   */ {
/* 17:   */   public Ginecologia retrive(BigDecimal gine_usuf_cod)
/* 18:   */     throws SQLException
/* 19:   */   {
/* 20:18 */     Ginecologia ginecologia = new Ginecologia();
/* 21:19 */     Connection conn = null;
/* 22:20 */     PreparedStatement pstmt = null;
/* 23:21 */     ResultSet rs = null;
/* 24:22 */     Ginecologia ginecologiaS = new Ginecologia();
/* 25:   */     try
/* 26:   */     {
/* 27:24 */       conn = this.ds.getConnection();
/* 28:25 */       DBUtil db = new DBUtil();
/* 29:26 */       String sql = db.creaSQLSELECT(ginecologiaS);
/* 30:27 */       String where = " where gine_usuf_cod = " + gine_usuf_cod;
/* 31:28 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 32:29 */       rs = pstmt.executeQuery();
/* 33:30 */       if (rs.next())
/* 34:   */       {
/* 35:32 */         InicializaData.inicializa(ginecologia.getClass(), ginecologia);
/* 36:33 */         populate(ginecologia, rs);
/* 37:   */       }
/* 38:36 */       close(rs);
/* 39:37 */       close(pstmt);
/* 40:   */     }
/* 41:   */     catch (SQLException e)
/* 42:   */     {
/* 43:39 */       close(rs);
/* 44:40 */       close(pstmt);
/* 45:41 */       rollback(conn);
/* 46:42 */       throw e;
/* 47:   */     }
/* 48:   */     finally
/* 49:   */     {
/* 50:44 */       close(conn);
/* 51:   */     }
/* 52:46 */     return ginecologia;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public void update(Ginecologia data, String[] llaves, Connection conn)
/* 56:   */     throws SQLException
/* 57:   */   {
/* 58:49 */     PreparedStatement pstmt = null;
/* 59:   */     try
/* 60:   */     {
/* 61:51 */       DBUtil db = new DBUtil();
/* 62:52 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 63:53 */       pstmt = conn.prepareStatement(sql);
/* 64:54 */       pstmt.executeUpdate();
/* 65:   */     }
/* 66:   */     catch (SQLException e)
/* 67:   */     {
/* 68:56 */       throw e;
/* 69:   */     }
/* 70:   */     finally
/* 71:   */     {
/* 72:58 */       close(pstmt);
/* 73:   */     }
/* 74:   */   }
/* 75:   */   
/* 76:   */   public synchronized void insert(Ginecologia data, Connection conn)
/* 77:   */     throws SQLException
/* 78:   */   {
/* 79:62 */     PreparedStatement pstmt = null;
/* 80:   */     try
/* 81:   */     {
/* 82:64 */       DBUtil db = new DBUtil();
/* 83:   */       
/* 84:66 */       String sql = db.creaSQLINSERT(data);
/* 85:   */       
/* 86:68 */       pstmt = conn.prepareStatement(sql);
/* 87:69 */       pstmt.executeUpdate();
/* 88:   */     }
/* 89:   */     catch (SQLException sqle)
/* 90:   */     {
/* 91:71 */       throw sqle;
/* 92:   */     }
/* 93:   */     finally
/* 94:   */     {
/* 95:73 */       close(pstmt);
/* 96:   */     }
/* 97:   */   }
/* 98:   */   
/* 99:   */   public void delete(BigDecimal gine_usuf_cod, Connection conn)
/* :0:   */     throws SQLException
/* :1:   */   {
/* :2:78 */     PreparedStatement pstmt = null;
/* :3:   */     try
/* :4:   */     {
/* :5:80 */       String sql = "DELETE FROM sdoctor.ginecologia WHERE gine_usuf_cod=?";
/* :6:81 */       pstmt = conn.prepareStatement(sql);
/* :7:82 */       pstmt.setBigDecimal(1, gine_usuf_cod);
/* :8:83 */       pstmt.executeUpdate();
/* :9:   */     }
/* ;0:   */     catch (SQLException e)
/* ;1:   */     {
/* ;2:85 */       throw e;
/* ;3:   */     }
/* ;4:   */     finally
/* ;5:   */     {
/* ;6:87 */       close(pstmt);
/* ;7:   */     }
/* ;8:   */   }
/* ;9:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.dao.GinecologiaDAO
 * JD-Core Version:    0.7.0.1
 */