/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.Grupos;
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
/*  16:    */ public class GruposDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list()
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 26 */     ArrayList list = new ArrayList();
/*  23: 27 */     Connection conn = null;
/*  24: 28 */     PreparedStatement pstmt = null;
/*  25: 29 */     ResultSet rs = null;
/*  26: 30 */     Grupos gruposS = new Grupos();
/*  27:    */     try
/*  28:    */     {
/*  29: 32 */       conn = this.ds.getConnection();
/*  30: 33 */       DBUtil db = new DBUtil();
/*  31: 34 */       String sql = db.creaSQLSELECT(gruposS);
/*  32: 35 */       pstmt = conn.prepareStatement(sql);
/*  33: 36 */       rs = pstmt.executeQuery();
/*  34: 37 */       while (rs.next())
/*  35:    */       {
/*  36: 38 */         Grupos grupos = new Grupos();
/*  37: 39 */         InicializaData.inicializa(grupos.getClass(), grupos);
/*  38: 40 */         populate(grupos, rs);
/*  39: 41 */         list.add(grupos);
/*  40:    */       }
/*  41: 43 */       close(rs);
/*  42: 44 */       close(pstmt);
/*  43:    */     }
/*  44:    */     catch (SQLException e)
/*  45:    */     {
/*  46: 46 */       close(rs);
/*  47: 47 */       close(pstmt);
/*  48: 48 */       rollback(conn);
/*  49: 49 */       throw e;
/*  50:    */     }
/*  51:    */     finally
/*  52:    */     {
/*  53: 51 */       close(conn);
/*  54:    */     }
/*  55: 53 */     return list;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public Grupos retrive(BigDecimal grup_cod)
/*  59:    */     throws SQLException
/*  60:    */   {
/*  61: 58 */     Grupos grupos = new Grupos();
/*  62: 59 */     Connection conn = null;
/*  63: 60 */     PreparedStatement pstmt = null;
/*  64: 61 */     ResultSet rs = null;
/*  65: 62 */     Grupos gruposS = new Grupos();
/*  66:    */     try
/*  67:    */     {
/*  68: 64 */       conn = this.ds.getConnection();
/*  69: 65 */       DBUtil db = new DBUtil();
/*  70: 66 */       String sql = db.creaSQLSELECT(gruposS);
/*  71: 67 */       String where = " where grup_cod = " + grup_cod;
/*  72: 68 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  73: 69 */       rs = pstmt.executeQuery();
/*  74: 70 */       if (rs.next())
/*  75:    */       {
/*  76: 71 */         InicializaData.inicializa(grupos.getClass(), grupos);
/*  77: 72 */         populate(grupos, rs);
/*  78:    */       }
/*  79: 74 */       close(rs);
/*  80: 75 */       close(pstmt);
/*  81:    */     }
/*  82:    */     catch (SQLException e)
/*  83:    */     {
/*  84: 77 */       close(rs);
/*  85: 78 */       close(pstmt);
/*  86: 79 */       rollback(conn);
/*  87: 80 */       throw e;
/*  88:    */     }
/*  89:    */     finally
/*  90:    */     {
/*  91: 82 */       close(conn);
/*  92:    */     }
/*  93: 84 */     return grupos;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public synchronized void insert(Grupos data)
/*  97:    */     throws SQLException
/*  98:    */   {
/*  99: 88 */     Connection conn = null;
/* 100: 89 */     PreparedStatement pstmt = null;
/* 101:    */     
/* 102: 91 */     ResultSet rs = null;
/* 103:    */     try
/* 104:    */     {
/* 105: 93 */       int id = 0;
/* 106: 94 */       DBUtil db = new DBUtil();
/* 107:    */       
/* 108: 96 */       conn = this.ds.getConnection();
/* 109: 97 */       conn.setAutoCommit(false);
/* 110: 98 */       id = getReqMax(conn);
/* 111: 99 */       data.setGrup_cod(new BigDecimal(id));
/* 112:100 */       String sql = db.creaSQLINSERT(data);
/* 113:    */       
/* 114:102 */       pstmt = conn.prepareStatement(sql);
/* 115:103 */       pstmt.executeUpdate();
/* 116:104 */       pstmt.close();
/* 117:105 */       conn.commit();
/* 118:    */     }
/* 119:    */     catch (SQLException sqle)
/* 120:    */     {
/* 121:107 */       close(rs);
/* 122:108 */       close(pstmt);
/* 123:109 */       rollback(conn);
/* 124:110 */       throw sqle;
/* 125:    */     }
/* 126:    */     finally
/* 127:    */     {
/* 128:112 */       close(rs);
/* 129:113 */       close(pstmt);
/* 130:114 */       close(conn);
/* 131:    */     }
/* 132:    */   }
/* 133:    */   
/* 134:    */   public void update(Grupos data, String[] llaves)
/* 135:    */     throws SQLException
/* 136:    */   {
/* 137:118 */     Connection conn = null;
/* 138:119 */     PreparedStatement pstmt = null;
/* 139:    */     try
/* 140:    */     {
/* 141:121 */       DBUtil db = new DBUtil();
/* 142:122 */       conn = this.ds.getConnection();
/* 143:123 */       conn.setAutoCommit(false);
/* 144:124 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 145:125 */       pstmt = conn.prepareStatement(sql);
/* 146:126 */       pstmt.executeUpdate();
/* 147:127 */       close(pstmt);
/* 148:128 */       conn.commit();
/* 149:    */     }
/* 150:    */     catch (SQLException e)
/* 151:    */     {
/* 152:130 */       close(pstmt);
/* 153:131 */       rollback(conn);
/* 154:132 */       throw e;
/* 155:    */     }
/* 156:    */     finally
/* 157:    */     {
/* 158:134 */       close(conn);
/* 159:    */     }
/* 160:    */   }
/* 161:    */   
/* 162:    */   public void delete(Grupos data)
/* 163:    */     throws SQLException
/* 164:    */   {
/* 165:138 */     Connection conn = null;
/* 166:139 */     PreparedStatement pstmt = null;
/* 167:    */     try
/* 168:    */     {
/* 169:141 */       conn = this.ds.getConnection();
/* 170:142 */       conn.setAutoCommit(false);
/* 171:143 */       String sql = "DELETE FROM sdoctor.grupos WHERE grup_cod=?";
/* 172:144 */       pstmt = conn.prepareStatement(sql);
/* 173:145 */       pstmt.setBigDecimal(1, data.getGrup_cod());
/* 174:146 */       pstmt.executeUpdate();
/* 175:147 */       close(pstmt);
/* 176:148 */       conn.commit();
/* 177:    */     }
/* 178:    */     catch (SQLException e)
/* 179:    */     {
/* 180:150 */       close(pstmt);
/* 181:151 */       rollback(conn);
/* 182:152 */       throw e;
/* 183:    */     }
/* 184:    */     finally
/* 185:    */     {
/* 186:154 */       close(conn);
/* 187:    */     }
/* 188:    */   }
/* 189:    */   
/* 190:    */   private int getReqMax(Connection conn)
/* 191:    */   {
/* 192:158 */     PreparedStatement pstmt = null;
/* 193:159 */     ResultSet rs = null;
/* 194:160 */     int id = 0;
/* 195:    */     try
/* 196:    */     {
/* 197:162 */       String sqlid = "Select max(grup_cod) from sdoctor.grupos";
/* 198:163 */       pstmt = conn.prepareStatement(sqlid);
/* 199:164 */       rs = pstmt.executeQuery();
/* 200:165 */       if ((rs != null) && (rs.next())) {
/* 201:166 */         id = rs.getInt(1) + 1;
/* 202:    */       } else {
/* 203:168 */         id++;
/* 204:    */       }
/* 205:    */     }
/* 206:    */     catch (SQLException e)
/* 207:    */     {
/* 208:172 */       close(rs);
/* 209:173 */       close(pstmt);
/* 210:174 */       rollback(conn);
/* 211:    */     }
/* 212:    */     finally
/* 213:    */     {
/* 214:176 */       close(rs);
/* 215:177 */       close(pstmt);
/* 216:    */     }
/* 217:179 */     return id;
/* 218:    */   }
/* 219:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.GruposDAO
 * JD-Core Version:    0.7.0.1
 */