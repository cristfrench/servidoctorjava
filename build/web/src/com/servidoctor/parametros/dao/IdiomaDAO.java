/*  1:   */ package com.servidoctor.parametros.dao;
/*  2:   */ 
/*  3:   */ import com.servidoctor.common.dao.DAO;
/*  4:   */ import com.servidoctor.parametros.model.Idioma;
/*  5:   */ import com.servidoctor.util.classes.DBUtil;
/*  6:   */ import com.servidoctor.util.classes.InicializaData;
/*  7:   */ import java.sql.Connection;
/*  8:   */ import java.sql.PreparedStatement;
/*  9:   */ import java.sql.ResultSet;
/* 10:   */ import java.sql.SQLException;
/* 11:   */ import java.util.ArrayList;
/* 12:   */ import java.util.List;
/* 13:   */ import javax.sql.DataSource;
/* 14:   */ 
/* 15:   */ public class IdiomaDAO
/* 16:   */   extends DAO
/* 17:   */ {
/* 18:   */   public List list()
/* 19:   */     throws SQLException
/* 20:   */   {
/* 21:26 */     ArrayList list = new ArrayList();
/* 22:27 */     Connection conn = null;
/* 23:28 */     PreparedStatement pstmt = null;
/* 24:29 */     ResultSet rs = null;
/* 25:30 */     Idioma idiomaS = new Idioma();
/* 26:   */     try
/* 27:   */     {
/* 28:32 */       conn = this.ds.getConnection();
/* 29:33 */       DBUtil db = new DBUtil();
/* 30:34 */       String sql = db.creaSQLSELECT(idiomaS);
/* 31:35 */       pstmt = conn.prepareStatement(sql);
/* 32:36 */       rs = pstmt.executeQuery();
/* 33:37 */       while (rs.next())
/* 34:   */       {
/* 35:38 */         Idioma idioma = new Idioma();
/* 36:39 */         InicializaData.inicializa(idioma.getClass(), idioma);
/* 37:40 */         populate(idioma, rs);
/* 38:41 */         list.add(idioma);
/* 39:   */       }
/* 40:43 */       close(rs);
/* 41:44 */       close(pstmt);
/* 42:   */     }
/* 43:   */     catch (SQLException e)
/* 44:   */     {
/* 45:46 */       close(rs);
/* 46:47 */       close(pstmt);
/* 47:48 */       rollback(conn);
/* 48:49 */       throw e;
/* 49:   */     }
/* 50:   */     finally
/* 51:   */     {
/* 52:51 */       close(conn);
/* 53:   */     }
/* 54:53 */     return list;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public Idioma retrive(String idio_cod)
/* 58:   */     throws SQLException
/* 59:   */   {
/* 60:58 */     Idioma Idioma = new Idioma();
/* 61:59 */     Connection conn = null;
/* 62:60 */     PreparedStatement pstmt = null;
/* 63:61 */     ResultSet rs = null;
/* 64:62 */     Idioma IdiomaS = new Idioma();
/* 65:   */     try
/* 66:   */     {
/* 67:64 */       conn = this.ds.getConnection();
/* 68:65 */       DBUtil db = new DBUtil();
/* 69:66 */       String sql = db.creaSQLSELECT(IdiomaS);
/* 70:67 */       String where = " where idio_cod=" + idio_cod;
/* 71:68 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 72:69 */       rs = pstmt.executeQuery();
/* 73:70 */       if (rs.next())
/* 74:   */       {
/* 75:72 */         InicializaData.inicializa(Idioma.getClass(), Idioma);
/* 76:73 */         populate(Idioma, rs);
/* 77:   */       }
/* 78:76 */       close(rs);
/* 79:77 */       close(pstmt);
/* 80:   */     }
/* 81:   */     catch (SQLException e)
/* 82:   */     {
/* 83:79 */       close(rs);
/* 84:80 */       close(pstmt);
/* 85:81 */       rollback(conn);
/* 86:82 */       throw e;
/* 87:   */     }
/* 88:   */     finally
/* 89:   */     {
/* 90:84 */       close(conn);
/* 91:   */     }
/* 92:86 */     return Idioma;
/* 93:   */   }
/* 94:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.IdiomaDAO
 * JD-Core Version:    0.7.0.1
 */