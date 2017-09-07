/*   1:    */ package com.servidoctor.sdfamily.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdfamily.model.DatosPersonales;
/*   5:    */ import com.servidoctor.util.classes.DBUtil;
/*   6:    */ import com.servidoctor.util.classes.InicializaData;
/*   7:    */ import java.math.BigDecimal;
/*   8:    */ import java.sql.Connection;
/*   9:    */ import java.sql.PreparedStatement;
/*  10:    */ import java.sql.ResultSet;
/*  11:    */ import java.sql.SQLException;
/*  12:    */ import javax.sql.DataSource;
/*  13:    */ 
/*  14:    */ public class DatosPersonalesDAO
/*  15:    */   extends DAO
/*  16:    */ {
/*  17:    */   public synchronized void insert(DatosPersonales data, Connection conn)
/*  18:    */     throws SQLException
/*  19:    */   {
/*  20: 17 */     PreparedStatement pstmt = null;
/*  21:    */     try
/*  22:    */     {
/*  23: 19 */       DBUtil db = new DBUtil();
/*  24: 20 */       String sql = db.creaSQLINSERT(data);
/*  25: 21 */       pstmt = conn.prepareStatement(sql);
/*  26: 22 */       pstmt.executeUpdate();
/*  27:    */     }
/*  28:    */     catch (SQLException sqle)
/*  29:    */     {
/*  30: 24 */       throw sqle;
/*  31:    */     }
/*  32:    */     finally
/*  33:    */     {
/*  34: 26 */       close(pstmt);
/*  35:    */     }
/*  36:    */   }
/*  37:    */   
/*  38:    */   public void update(DatosPersonales datosPersonales, String[] llaves, Connection conn)
/*  39:    */     throws SQLException
/*  40:    */   {
/*  41: 30 */     PreparedStatement pstmt = null;
/*  42:    */     try
/*  43:    */     {
/*  44: 32 */       DBUtil db = new DBUtil();
/*  45: 33 */       String sql = db.creaSQLUPDATE(datosPersonales, llaves);
/*  46: 34 */       pstmt = conn.prepareStatement(sql);
/*  47: 35 */       pstmt.executeUpdate();
/*  48:    */     }
/*  49:    */     catch (SQLException e)
/*  50:    */     {
/*  51: 37 */       throw e;
/*  52:    */     }
/*  53:    */     finally
/*  54:    */     {
/*  55: 39 */       close(pstmt);
/*  56:    */     }
/*  57:    */   }
/*  58:    */   
/*  59:    */   public void delete(BigDecimal datp_usuf_cod, Connection conn)
/*  60:    */     throws SQLException
/*  61:    */   {
/*  62: 44 */     PreparedStatement pstmt = null;
/*  63:    */     try
/*  64:    */     {
/*  65: 46 */       String sql = "DELETE FROM sdoctor.datospersonales where datp_usuf_cod=" + datp_usuf_cod;
/*  66: 47 */       pstmt = conn.prepareStatement(sql);
/*  67: 48 */       pstmt.executeUpdate();
/*  68:    */     }
/*  69:    */     catch (SQLException e)
/*  70:    */     {
/*  71: 50 */       throw e;
/*  72:    */     }
/*  73:    */     finally
/*  74:    */     {
/*  75: 52 */       close(pstmt);
/*  76:    */     }
/*  77:    */   }
/*  78:    */   
/*  79:    */   public DatosPersonales retrive(BigDecimal datp_usuf_cod)
/*  80:    */     throws SQLException
/*  81:    */   {
/*  82: 57 */     DatosPersonales datosPersonales = new DatosPersonales();
/*  83: 58 */     DatosPersonales datosPersonalesS = new DatosPersonales();
/*  84: 59 */     Connection conn = null;
/*  85: 60 */     PreparedStatement pstmt = null;
/*  86: 61 */     ResultSet rs = null;
/*  87:    */     try
/*  88:    */     {
/*  89: 64 */       conn = this.ds.getConnection();
/*  90: 65 */       DBUtil db = new DBUtil();
/*  91: 66 */       String sql = db.creaSQLSELECT(datosPersonalesS);
/*  92: 67 */       String where = " where datp_usuf_cod = ?";
/*  93: 68 */       pstmt = conn.prepareStatement(sql + where);
/*  94: 69 */       pstmt.setBigDecimal(1, datp_usuf_cod);
/*  95: 70 */       rs = pstmt.executeQuery();
/*  96: 71 */       if (rs.next())
/*  97:    */       {
/*  98: 72 */         InicializaData.inicializa(datosPersonales.getClass(), datosPersonales);
/*  99: 73 */         populate(datosPersonales, rs);
/* 100:    */       }
/* 101: 75 */       close(rs);
/* 102: 76 */       close(pstmt);
/* 103:    */     }
/* 104:    */     catch (SQLException e)
/* 105:    */     {
/* 106: 78 */       close(rs);
/* 107: 79 */       close(pstmt);
/* 108: 80 */       rollback(conn);
/* 109: 81 */       throw e;
/* 110:    */     }
/* 111:    */     finally
/* 112:    */     {
/* 113: 83 */       close(conn);
/* 114:    */     }
/* 115: 85 */     return datosPersonales;
/* 116:    */   }
/* 117:    */   
/* 118:    */   private BigDecimal getReqMax(Connection conn)
/* 119:    */   {
/* 120: 89 */     PreparedStatement pstmt = null;
/* 121: 90 */     ResultSet rs = null;
/* 122: 91 */     BigDecimal id = null;
/* 123:    */     try
/* 124:    */     {
/* 125: 93 */       String sqlid = "Select max(datp_usuf_cod) from sdoctor.datospersonales";
/* 126: 94 */       pstmt = conn.prepareStatement(sqlid);
/* 127: 95 */       rs = pstmt.executeQuery();
/* 128: 96 */       if ((rs != null) && (rs.next())) {
/* 129: 97 */         id = rs.getBigDecimal(1);
/* 130:    */       }
/* 131:    */     }
/* 132:    */     catch (SQLException e)
/* 133:    */     {
/* 134:100 */       close(rs);
/* 135:101 */       close(pstmt);
/* 136:102 */       rollback(conn);
/* 137:103 */       e.printStackTrace();
/* 138:    */     }
/* 139:    */     finally
/* 140:    */     {
/* 141:105 */       close(rs);
/* 142:106 */       close(pstmt);
/* 143:    */     }
/* 144:108 */     return id != null ? id.add(new BigDecimal(1)) : new BigDecimal(1);
/* 145:    */   }
/* 146:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.dao.DatosPersonalesDAO
 * JD-Core Version:    0.7.0.1
 */