/*   1:    */ package com.servidoctor.sdpets.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdpets.model.MascotaMedicamentos;
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
/*  16:    */ public class MascotaMedicamentosDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list(BigDecimal mas_cod)
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 20 */     ArrayList list = new ArrayList();
/*  23: 21 */     Connection conn = null;
/*  24: 22 */     PreparedStatement pstmt = null;
/*  25: 23 */     ResultSet rs = null;
/*  26: 24 */     MascotaMedicamentos mascotaMedicamentosS = new MascotaMedicamentos();
/*  27:    */     try
/*  28:    */     {
/*  29: 27 */       conn = this.ds.getConnection();
/*  30: 28 */       DBUtil db = new DBUtil();
/*  31: 29 */       String sql = db.creaSQLSELECT(mascotaMedicamentosS);
/*  32: 30 */       pstmt = conn.prepareStatement(sql + " where mmed_mas_cod = " + mas_cod);
/*  33:    */       
/*  34: 32 */       rs = pstmt.executeQuery();
/*  35: 33 */       while (rs.next())
/*  36:    */       {
/*  37: 34 */         MascotaMedicamentos mascotaMedicamentos = new MascotaMedicamentos();
/*  38: 35 */         InicializaData.inicializa(mascotaMedicamentos.getClass(), mascotaMedicamentos);
/*  39: 36 */         populate(mascotaMedicamentos, rs);
/*  40: 37 */         list.add(mascotaMedicamentos);
/*  41:    */       }
/*  42: 39 */       close(rs);
/*  43: 40 */       close(pstmt);
/*  44:    */     }
/*  45:    */     catch (SQLException e)
/*  46:    */     {
/*  47: 42 */       close(rs);
/*  48: 43 */       close(pstmt);
/*  49: 44 */       rollback(conn);
/*  50: 45 */       throw e;
/*  51:    */     }
/*  52:    */     finally
/*  53:    */     {
/*  54: 47 */       close(conn);
/*  55:    */     }
/*  56: 49 */     return list;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public MascotaMedicamentos retrive(BigDecimal mmed_cod, BigDecimal mmed_mas_cod)
/*  60:    */     throws SQLException
/*  61:    */   {
/*  62: 54 */     MascotaMedicamentos mascotaMedicamentos = new MascotaMedicamentos();
/*  63: 55 */     Connection conn = null;
/*  64: 56 */     PreparedStatement pstmt = null;
/*  65: 57 */     ResultSet rs = null;
/*  66: 58 */     MascotaMedicamentos mascotaMedicamentosS = new MascotaMedicamentos();
/*  67:    */     try
/*  68:    */     {
/*  69: 60 */       conn = this.ds.getConnection();
/*  70: 61 */       DBUtil db = new DBUtil();
/*  71: 62 */       String sql = db.creaSQLSELECT(mascotaMedicamentosS);
/*  72: 63 */       String where = " where mmed_cod=" + mmed_cod + " and mmed_mas_cod = " + mmed_mas_cod;
/*  73: 64 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  74: 65 */       rs = pstmt.executeQuery();
/*  75: 66 */       if (rs.next())
/*  76:    */       {
/*  77: 68 */         InicializaData.inicializa(mascotaMedicamentos.getClass(), mascotaMedicamentos);
/*  78: 69 */         populate(mascotaMedicamentos, rs);
/*  79:    */       }
/*  80: 72 */       close(rs);
/*  81: 73 */       close(pstmt);
/*  82:    */     }
/*  83:    */     catch (SQLException e)
/*  84:    */     {
/*  85: 75 */       close(rs);
/*  86: 76 */       close(pstmt);
/*  87: 77 */       rollback(conn);
/*  88: 78 */       e.printStackTrace();
/*  89:    */     }
/*  90:    */     finally
/*  91:    */     {
/*  92: 80 */       close(conn);
/*  93:    */     }
/*  94: 82 */     return mascotaMedicamentos;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public void update(MascotaMedicamentos data, String[] llaves, Connection conn)
/*  98:    */     throws SQLException
/*  99:    */   {
/* 100: 85 */     PreparedStatement pstmt = null;
/* 101:    */     try
/* 102:    */     {
/* 103: 87 */       DBUtil db = new DBUtil();
/* 104: 88 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 105: 89 */       pstmt = conn.prepareStatement(sql);
/* 106: 90 */       pstmt.executeUpdate();
/* 107:    */     }
/* 108:    */     catch (SQLException e)
/* 109:    */     {
/* 110: 92 */       throw e;
/* 111:    */     }
/* 112:    */     finally
/* 113:    */     {
/* 114: 94 */       close(pstmt);
/* 115:    */     }
/* 116:    */   }
/* 117:    */   
/* 118:    */   public synchronized void insert(MascotaMedicamentos data, Connection conn)
/* 119:    */     throws SQLException
/* 120:    */   {
/* 121: 98 */     PreparedStatement pstmt = null;
/* 122:    */     try
/* 123:    */     {
/* 124:100 */       int id = 0;
/* 125:101 */       DBUtil db = new DBUtil();
/* 126:102 */       id = getReqMax(conn, data.getMmed_mas_cod().toString());
/* 127:103 */       data.setMmed_cod(new BigDecimal(id));
/* 128:104 */       String sql = db.creaSQLINSERT(data);
/* 129:    */       
/* 130:106 */       pstmt = conn.prepareStatement(sql);
/* 131:107 */       pstmt.executeUpdate();
/* 132:    */     }
/* 133:    */     catch (SQLException sqle)
/* 134:    */     {
/* 135:109 */       throw sqle;
/* 136:    */     }
/* 137:    */     finally
/* 138:    */     {
/* 139:111 */       close(pstmt);
/* 140:    */     }
/* 141:    */   }
/* 142:    */   
/* 143:    */   public void delete(MascotaMedicamentos data, Connection conn)
/* 144:    */     throws SQLException
/* 145:    */   {
/* 146:116 */     PreparedStatement pstmt = null;
/* 147:    */     try
/* 148:    */     {
/* 149:118 */       String sql = "DELETE FROM sdoctor.mascotamedicamentos WHERE mmed_cod=? and mmed_mas_cod=?";
/* 150:119 */       pstmt = conn.prepareStatement(sql);
/* 151:120 */       pstmt.setBigDecimal(1, data.getMmed_cod());
/* 152:121 */       pstmt.setBigDecimal(2, data.getMmed_mas_cod());
/* 153:122 */       pstmt.executeUpdate();
/* 154:    */     }
/* 155:    */     catch (SQLException e)
/* 156:    */     {
/* 157:124 */       throw e;
/* 158:    */     }
/* 159:    */     finally
/* 160:    */     {
/* 161:126 */       close(pstmt);
/* 162:    */     }
/* 163:    */   }
/* 164:    */   
/* 165:    */   public void deleteAll(BigDecimal mas_cod, Connection conn)
/* 166:    */     throws SQLException
/* 167:    */   {
/* 168:131 */     PreparedStatement pstmt = null;
/* 169:    */     try
/* 170:    */     {
/* 171:133 */       String sql = "DELETE FROM sdoctor.mascotamedicamentos WHERE mmed_mas_cod=?";
/* 172:134 */       pstmt = conn.prepareStatement(sql);
/* 173:135 */       pstmt.setBigDecimal(1, mas_cod);
/* 174:136 */       pstmt.executeUpdate();
/* 175:    */     }
/* 176:    */     catch (SQLException e)
/* 177:    */     {
/* 178:138 */       throw e;
/* 179:    */     }
/* 180:    */     finally
/* 181:    */     {
/* 182:140 */       close(pstmt);
/* 183:    */     }
/* 184:    */   }
/* 185:    */   
/* 186:    */   private int getReqMax(Connection conn, String mas_cod)
/* 187:    */   {
/* 188:145 */     PreparedStatement pstmt = null;
/* 189:146 */     ResultSet rs = null;
/* 190:147 */     int id = 0;
/* 191:    */     try
/* 192:    */     {
/* 193:149 */       String sqlid = "Select max(mmed_cod) from sdoctor.mascotamedicamentos where mmed_mas_cod = " + mas_cod;
/* 194:150 */       pstmt = conn.prepareStatement(sqlid);
/* 195:151 */       rs = pstmt.executeQuery();
/* 196:152 */       if ((rs != null) && (rs.next())) {
/* 197:153 */         id = rs.getInt(1) + 1;
/* 198:    */       } else {
/* 199:155 */         id++;
/* 200:    */       }
/* 201:    */     }
/* 202:    */     catch (SQLException e)
/* 203:    */     {
/* 204:159 */       close(rs);
/* 205:160 */       close(pstmt);
/* 206:161 */       rollback(conn);
/* 207:162 */       e.printStackTrace();
/* 208:    */     }
/* 209:    */     finally
/* 210:    */     {
/* 211:164 */       close(rs);
/* 212:165 */       close(pstmt);
/* 213:    */     }
/* 214:167 */     return id;
/* 215:    */   }
/* 216:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdpets.dao.MascotaMedicamentosDAO
 * JD-Core Version:    0.7.0.1
 */