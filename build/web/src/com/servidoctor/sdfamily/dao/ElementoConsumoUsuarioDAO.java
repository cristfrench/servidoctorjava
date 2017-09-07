/*   1:    */ package com.servidoctor.sdfamily.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdfamily.model.ElementoConsumoUsuario;
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
/*  16:    */ public class ElementoConsumoUsuarioDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list(BigDecimal econu_usuf_cod)
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 26 */     ArrayList list = new ArrayList();
/*  23: 27 */     Connection conn = null;
/*  24: 28 */     PreparedStatement pstmt = null;
/*  25: 29 */     ResultSet rs = null;
/*  26: 30 */     ElementoConsumoUsuario elementoConsumoUsuarioS = new ElementoConsumoUsuario();
/*  27:    */     try
/*  28:    */     {
/*  29: 32 */       conn = this.ds.getConnection();
/*  30: 33 */       DBUtil db = new DBUtil();
/*  31: 34 */       String sql = db.creaSQLSELECT(elementoConsumoUsuarioS);
/*  32: 35 */       String where = " where econu_usuf_cod=" + econu_usuf_cod;
/*  33: 36 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  34: 37 */       rs = pstmt.executeQuery();
/*  35: 38 */       while (rs.next())
/*  36:    */       {
/*  37: 39 */         ElementoConsumoUsuario elementoConsumoUsuario = new ElementoConsumoUsuario();
/*  38: 40 */         InicializaData.inicializa(elementoConsumoUsuario.getClass(), elementoConsumoUsuario);
/*  39: 41 */         populate(elementoConsumoUsuario, rs);
/*  40: 42 */         list.add(elementoConsumoUsuario);
/*  41:    */       }
/*  42: 44 */       close(rs);
/*  43: 45 */       close(pstmt);
/*  44:    */     }
/*  45:    */     catch (SQLException e)
/*  46:    */     {
/*  47: 47 */       close(rs);
/*  48: 48 */       close(pstmt);
/*  49: 49 */       rollback(conn);
/*  50: 50 */       throw e;
/*  51:    */     }
/*  52:    */     finally
/*  53:    */     {
/*  54: 52 */       close(conn);
/*  55:    */     }
/*  56: 54 */     return list;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public void update(ElementoConsumoUsuario data, String[] llaves, Connection conn)
/*  60:    */     throws SQLException
/*  61:    */   {
/*  62: 58 */     PreparedStatement pstmt = null;
/*  63:    */     try
/*  64:    */     {
/*  65: 60 */       DBUtil db = new DBUtil();
/*  66: 61 */       String sql = db.creaSQLUPDATE(data, llaves);
/*  67: 62 */       pstmt = conn.prepareStatement(sql);
/*  68: 63 */       pstmt.executeUpdate();
/*  69:    */     }
/*  70:    */     catch (SQLException e)
/*  71:    */     {
/*  72: 65 */       throw e;
/*  73:    */     }
/*  74:    */     finally
/*  75:    */     {
/*  76: 67 */       close(pstmt);
/*  77:    */     }
/*  78:    */   }
/*  79:    */   
/*  80:    */   public ElementoConsumoUsuario retrieve(BigDecimal econu_usuf_cod, BigDecimal econu_cod)
/*  81:    */     throws SQLException
/*  82:    */   {
/*  83: 72 */     ElementoConsumoUsuario elementoConsumoUsuario = new ElementoConsumoUsuario();
/*  84: 73 */     Connection conn = null;
/*  85: 74 */     PreparedStatement pstmt = null;
/*  86: 75 */     ResultSet rs = null;
/*  87: 76 */     ElementoConsumoUsuario elementoConsumoUsuarioS = new ElementoConsumoUsuario();
/*  88:    */     try
/*  89:    */     {
/*  90: 78 */       conn = this.ds.getConnection();
/*  91: 79 */       DBUtil db = new DBUtil();
/*  92: 80 */       String sql = db.creaSQLSELECT(elementoConsumoUsuarioS);
/*  93: 81 */       String where = " where econu_usuf_cod = " + econu_usuf_cod + " and econu_cod = " + econu_cod;
/*  94: 82 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  95: 83 */       rs = pstmt.executeQuery();
/*  96: 84 */       if (rs.next())
/*  97:    */       {
/*  98: 85 */         InicializaData.inicializa(elementoConsumoUsuario.getClass(), elementoConsumoUsuario);
/*  99: 86 */         populate(elementoConsumoUsuario, rs);
/* 100:    */       }
/* 101: 88 */       close(rs);
/* 102: 89 */       close(pstmt);
/* 103:    */     }
/* 104:    */     catch (SQLException e)
/* 105:    */     {
/* 106: 91 */       close(rs);
/* 107: 92 */       close(pstmt);
/* 108: 93 */       rollback(conn);
/* 109: 94 */       throw e;
/* 110:    */     }
/* 111:    */     finally
/* 112:    */     {
/* 113: 96 */       close(conn);
/* 114:    */     }
/* 115: 98 */     return elementoConsumoUsuario;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public synchronized void insert(ElementoConsumoUsuario data, Connection conn)
/* 119:    */     throws SQLException
/* 120:    */   {
/* 121:102 */     PreparedStatement pstmt = null;
/* 122:    */     try
/* 123:    */     {
/* 124:104 */       int id = 0;
/* 125:105 */       DBUtil db = new DBUtil();
/* 126:    */       
/* 127:107 */       id = getReqMax(conn, data);
/* 128:108 */       data.setEconu_cod(new BigDecimal(id));
/* 129:109 */       String sql = db.creaSQLINSERT(data);
/* 130:    */       
/* 131:111 */       pstmt = conn.prepareStatement(sql);
/* 132:112 */       pstmt.executeUpdate();
/* 133:    */     }
/* 134:    */     catch (SQLException sqle)
/* 135:    */     {
/* 136:114 */       throw sqle;
/* 137:    */     }
/* 138:    */     finally
/* 139:    */     {
/* 140:116 */       close(pstmt);
/* 141:    */     }
/* 142:    */   }
/* 143:    */   
/* 144:    */   public void delete(ElementoConsumoUsuario data, Connection conn)
/* 145:    */     throws SQLException
/* 146:    */   {
/* 147:121 */     PreparedStatement pstmt = null;
/* 148:    */     try
/* 149:    */     {
/* 150:123 */       String sql = "DELETE FROM sdoctor.elementoconsumousuario WHERE econu_cod = ? and econu_usuf_cod = ?";
/* 151:124 */       pstmt = conn.prepareStatement(sql);
/* 152:125 */       pstmt.setBigDecimal(1, data.getEconu_cod());
/* 153:126 */       pstmt.setBigDecimal(2, data.getEconu_usuf_cod());
/* 154:127 */       pstmt.executeUpdate();
/* 155:    */     }
/* 156:    */     catch (SQLException e)
/* 157:    */     {
/* 158:129 */       throw e;
/* 159:    */     }
/* 160:    */     finally
/* 161:    */     {
/* 162:131 */       close(pstmt);
/* 163:    */     }
/* 164:    */   }
/* 165:    */   
/* 166:    */   public void deleteAll(BigDecimal econu_usuf_cod, Connection conn)
/* 167:    */     throws SQLException
/* 168:    */   {
/* 169:136 */     PreparedStatement pstmt = null;
/* 170:    */     try
/* 171:    */     {
/* 172:138 */       String sql = "DELETE FROM sdoctor.elementoconsumousuario WHERE econu_usuf_cod=?";
/* 173:139 */       pstmt = conn.prepareStatement(sql);
/* 174:140 */       pstmt.setBigDecimal(1, econu_usuf_cod);
/* 175:141 */       pstmt.executeUpdate();
/* 176:    */     }
/* 177:    */     catch (SQLException e)
/* 178:    */     {
/* 179:143 */       throw e;
/* 180:    */     }
/* 181:    */     finally
/* 182:    */     {
/* 183:145 */       close(pstmt);
/* 184:    */     }
/* 185:    */   }
/* 186:    */   
/* 187:    */   private int getReqMax(Connection conn, ElementoConsumoUsuario data)
/* 188:    */     throws SQLException
/* 189:    */   {
/* 190:150 */     PreparedStatement pstmt = null;
/* 191:151 */     ResultSet rs = null;
/* 192:152 */     int id = 0;
/* 193:    */     try
/* 194:    */     {
/* 195:154 */       String sqlid = "Select max(econu_cod) from sdoctor.elementoconsumousuario where econu_usuf_cod = ?";
/* 196:    */       
/* 197:156 */       pstmt = conn.prepareStatement(sqlid);
/* 198:157 */       pstmt.setBigDecimal(1, data.getEconu_usuf_cod());
/* 199:158 */       rs = pstmt.executeQuery();
/* 200:159 */       if ((rs != null) && (rs.next())) {
/* 201:160 */         id = rs.getInt(1) + 1;
/* 202:    */       } else {
/* 203:162 */         id++;
/* 204:    */       }
/* 205:    */     }
/* 206:    */     catch (SQLException e)
/* 207:    */     {
/* 208:166 */       throw e;
/* 209:    */     }
/* 210:    */     finally
/* 211:    */     {
/* 212:168 */       close(rs);
/* 213:169 */       close(pstmt);
/* 214:    */     }
/* 215:171 */     return id;
/* 216:    */   }
/* 217:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.dao.ElementoConsumoUsuarioDAO
 * JD-Core Version:    0.7.0.1
 */