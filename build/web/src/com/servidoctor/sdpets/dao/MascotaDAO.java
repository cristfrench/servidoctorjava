/*   1:    */ package com.servidoctor.sdpets.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdpets.model.Mascota;
/*   5:    */ import com.servidoctor.util.classes.DBUtil;
/*   6:    */ import com.servidoctor.util.classes.InicializaData;
/*   7:    */ import java.math.BigDecimal;
/*   8:    */ import java.sql.Connection;
/*   9:    */ import java.sql.PreparedStatement;
/*  10:    */ import java.sql.ResultSet;
/*  11:    */ import java.sql.SQLException;
/*  12:    */ import java.util.ArrayList;
/*  13:    */ import java.util.List;
/*  14:    */ import javax.sql.DataSource;
/*  15:    */ 
/*  16:    */ public class MascotaDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public synchronized void insert(Mascota data, Connection conn)
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 19 */     PreparedStatement pstmt = null;
/*  23:    */     try
/*  24:    */     {
/*  25: 21 */       int id = 0;
/*  26: 22 */       DBUtil db = new DBUtil();
/*  27: 23 */       id = getReqMax(conn);
/*  28: 24 */       data.setMas_cod(new BigDecimal(id));
/*  29: 25 */       String sql = db.creaSQLINSERT(data);
/*  30: 26 */       pstmt = conn.prepareStatement(sql);
/*  31: 27 */       pstmt.executeUpdate();
/*  32:    */     }
/*  33:    */     catch (SQLException sqle)
/*  34:    */     {
/*  35: 29 */       throw sqle;
/*  36:    */     }
/*  37:    */     finally
/*  38:    */     {
/*  39: 31 */       close(pstmt);
/*  40:    */     }
/*  41:    */   }
/*  42:    */   
/*  43:    */   public void update(Mascota data, String[] llaves, Connection conn)
/*  44:    */     throws SQLException
/*  45:    */   {
/*  46: 36 */     PreparedStatement pstmt = null;
/*  47:    */     try
/*  48:    */     {
/*  49: 38 */       DBUtil db = new DBUtil();
/*  50: 39 */       String sql = db.creaSQLUPDATE(data, llaves);
/*  51: 40 */       pstmt = conn.prepareStatement(sql);
/*  52: 41 */       pstmt.executeUpdate();
/*  53: 42 */       close(pstmt);
/*  54:    */     }
/*  55:    */     catch (SQLException e)
/*  56:    */     {
/*  57: 44 */       throw e;
/*  58:    */     }
/*  59:    */     finally
/*  60:    */     {
/*  61: 46 */       close(pstmt);
/*  62:    */     }
/*  63:    */   }
/*  64:    */   
/*  65:    */   public void delete(BigDecimal id_mascota, Connection conn)
/*  66:    */     throws SQLException
/*  67:    */   {
/*  68: 51 */     PreparedStatement pstmt = null;
/*  69:    */     try
/*  70:    */     {
/*  71: 53 */       String sql = "DELETE FROM sdoctor.mascota where mas_cod= ?";
/*  72: 54 */       pstmt = conn.prepareStatement(sql);
/*  73: 55 */       pstmt.setBigDecimal(1, id_mascota);
/*  74:    */       
/*  75: 57 */       pstmt.executeUpdate();
/*  76:    */     }
/*  77:    */     catch (SQLException e)
/*  78:    */     {
/*  79: 59 */       throw e;
/*  80:    */     }
/*  81:    */     finally
/*  82:    */     {
/*  83: 61 */       close(pstmt);
/*  84:    */     }
/*  85:    */   }
/*  86:    */   
/*  87:    */   public Mascota retrieve(BigDecimal mas_cod)
/*  88:    */     throws SQLException
/*  89:    */   {
/*  90: 66 */     Mascota mascota = new Mascota();
/*  91: 67 */     Connection conn = null;
/*  92: 68 */     PreparedStatement pstmt = null;
/*  93: 69 */     ResultSet rs = null;
/*  94: 70 */     Mascota mascotaS = new Mascota();
/*  95:    */     try
/*  96:    */     {
/*  97: 72 */       conn = this.ds.getConnection();
/*  98: 73 */       DBUtil db = new DBUtil();
/*  99: 74 */       String sql = db.creaSQLSELECT(mascotaS);
/* 100: 75 */       String where = " where mas_cod = " + mas_cod;
/* 101: 76 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 102: 77 */       rs = pstmt.executeQuery();
/* 103: 78 */       if (rs.next())
/* 104:    */       {
/* 105: 79 */         InicializaData.inicializa(mascota.getClass(), mascota);
/* 106: 80 */         populate(mascota, rs);
/* 107:    */       }
/* 108: 82 */       close(rs);
/* 109: 83 */       close(pstmt);
/* 110:    */     }
/* 111:    */     catch (SQLException e)
/* 112:    */     {
/* 113: 85 */       close(rs);
/* 114: 86 */       close(pstmt);
/* 115: 87 */       rollback(conn);
/* 116: 88 */       throw e;
/* 117:    */     }
/* 118:    */     finally
/* 119:    */     {
/* 120: 90 */       close(conn);
/* 121:    */     }
/* 122: 92 */     return mascota;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public List list(BigDecimal mas_usup_cod)
/* 126:    */     throws SQLException
/* 127:    */   {
/* 128: 96 */     ArrayList list = new ArrayList();
/* 129: 97 */     Connection conn = null;
/* 130: 98 */     PreparedStatement pstmt = null;
/* 131: 99 */     ResultSet rs = null;
/* 132:100 */     Mascota mascotaS = new Mascota();
/* 133:    */     try
/* 134:    */     {
/* 135:102 */       conn = this.ds.getConnection();
/* 136:103 */       DBUtil db = new DBUtil();
/* 137:104 */       String sql = db.creaSQLSELECT(mascotaS);
/* 138:105 */       pstmt = conn.prepareStatement(sql + " where mas_usup_cod = ?");
/* 139:106 */       pstmt.setBigDecimal(1, mas_usup_cod);
/* 140:107 */       rs = pstmt.executeQuery();
/* 141:108 */       while (rs.next())
/* 142:    */       {
/* 143:109 */         Mascota mascota = new Mascota();
/* 144:110 */         InicializaData.inicializa(mascota.getClass(), mascota);
/* 145:111 */         populate(mascota, rs);
/* 146:112 */         list.add(mascota);
/* 147:    */       }
/* 148:114 */       close(rs);
/* 149:115 */       close(pstmt);
/* 150:    */     }
/* 151:    */     catch (SQLException e)
/* 152:    */     {
/* 153:117 */       close(rs);
/* 154:118 */       close(pstmt);
/* 155:119 */       rollback(conn);
/* 156:120 */       throw e;
/* 157:    */     }
/* 158:    */     finally
/* 159:    */     {
/* 160:122 */       close(conn);
/* 161:    */     }
/* 162:124 */     return list;
/* 163:    */   }
/* 164:    */   
/* 165:    */   private int getReqMax(Connection conn)
/* 166:    */   {
/* 167:128 */     PreparedStatement pstmt = null;
/* 168:129 */     ResultSet rs = null;
/* 169:130 */     int id = 0;
/* 170:    */     try
/* 171:    */     {
/* 172:132 */       String sqlid = "Select max(mas_cod) from sdoctor.mascota ";
/* 173:133 */       pstmt = conn.prepareStatement(sqlid);
/* 174:134 */       rs = pstmt.executeQuery();
/* 175:135 */       if ((rs != null) && (rs.next())) {
/* 176:136 */         id = rs.getInt(1) + 1;
/* 177:    */       } else {
/* 178:138 */         id++;
/* 179:    */       }
/* 180:    */     }
/* 181:    */     catch (SQLException e)
/* 182:    */     {
/* 183:142 */       close(rs);
/* 184:143 */       close(pstmt);
/* 185:144 */       rollback(conn);
/* 186:145 */       e.printStackTrace();
/* 187:    */     }
/* 188:    */     finally
/* 189:    */     {
/* 190:147 */       close(rs);
/* 191:148 */       close(pstmt);
/* 192:    */     }
/* 193:150 */     return id;
/* 194:    */   }
/* 195:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdpets.dao.MascotaDAO
 * JD-Core Version:    0.7.0.1
 */