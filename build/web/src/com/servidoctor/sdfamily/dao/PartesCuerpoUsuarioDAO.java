/*   1:    */ package com.servidoctor.sdfamily.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdfamily.model.PartesCuerpoUsuario;
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
/*  16:    */ public class PartesCuerpoUsuarioDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list(BigDecimal pcueu_usuf_cod)
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 26 */     ArrayList list = new ArrayList();
/*  23: 27 */     Connection conn = null;
/*  24: 28 */     PreparedStatement pstmt = null;
/*  25: 29 */     ResultSet rs = null;
/*  26: 30 */     PartesCuerpoUsuario partesCuerpoUsuarioS = new PartesCuerpoUsuario();
/*  27:    */     try
/*  28:    */     {
/*  29: 32 */       conn = this.ds.getConnection();
/*  30: 33 */       DBUtil db = new DBUtil();
/*  31: 34 */       String sql = db.creaSQLSELECT(partesCuerpoUsuarioS);
/*  32: 35 */       String where = " where pcueu_usuf_cod=" + pcueu_usuf_cod;
/*  33: 36 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  34: 37 */       rs = pstmt.executeQuery();
/*  35: 38 */       while (rs.next())
/*  36:    */       {
/*  37: 39 */         PartesCuerpoUsuario partesCuerpoUsuario = new PartesCuerpoUsuario();
/*  38: 40 */         InicializaData.inicializa(partesCuerpoUsuario.getClass(), partesCuerpoUsuario);
/*  39: 41 */         populate(partesCuerpoUsuario, rs);
/*  40: 42 */         list.add(partesCuerpoUsuario);
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
/*  59:    */   public void update(PartesCuerpoUsuario data, String[] llaves, Connection conn)
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
/*  80:    */   public PartesCuerpoUsuario retrieve(BigDecimal pcueu_usuf_cod, BigDecimal pcueu_cod)
/*  81:    */     throws SQLException
/*  82:    */   {
/*  83: 72 */     PartesCuerpoUsuario partesCuerpoUsuario = new PartesCuerpoUsuario();
/*  84: 73 */     Connection conn = null;
/*  85: 74 */     PreparedStatement pstmt = null;
/*  86: 75 */     ResultSet rs = null;
/*  87: 76 */     PartesCuerpoUsuario partesCuerpoUsuarioS = new PartesCuerpoUsuario();
/*  88:    */     try
/*  89:    */     {
/*  90: 78 */       conn = this.ds.getConnection();
/*  91: 79 */       DBUtil db = new DBUtil();
/*  92: 80 */       String sql = db.creaSQLSELECT(partesCuerpoUsuarioS);
/*  93: 81 */       String where = " where pcueu_usuf_cod = " + pcueu_usuf_cod + " and pcueu_cod = " + pcueu_cod;
/*  94: 82 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  95: 83 */       rs = pstmt.executeQuery();
/*  96: 84 */       if (rs.next())
/*  97:    */       {
/*  98: 85 */         InicializaData.inicializa(partesCuerpoUsuario.getClass(), partesCuerpoUsuario);
/*  99: 86 */         populate(partesCuerpoUsuario, rs);
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
/* 115: 98 */     return partesCuerpoUsuario;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public synchronized void insert(PartesCuerpoUsuario data, Connection conn)
/* 119:    */     throws SQLException
/* 120:    */   {
/* 121:102 */     PreparedStatement pstmt = null;
/* 122:    */     try
/* 123:    */     {
/* 124:104 */       int id = 0;
/* 125:105 */       DBUtil db = new DBUtil();
/* 126:    */       
/* 127:107 */       id = getReqMax(conn, data);
/* 128:108 */       data.setPcueu_cod(new BigDecimal(id));
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
/* 144:    */   public void delete(PartesCuerpoUsuario data, Connection conn)
/* 145:    */     throws SQLException
/* 146:    */   {
/* 147:121 */     PreparedStatement pstmt = null;
/* 148:    */     try
/* 149:    */     {
/* 150:123 */       String sql = "DELETE FROM sdoctor.partescuerpousuario WHERE pcueu_cod = ? and pcueu_usuf_cod = ?";
/* 151:124 */       pstmt = conn.prepareStatement(sql);
/* 152:125 */       pstmt.setBigDecimal(1, data.getPcueu_cod());
/* 153:126 */       pstmt.setBigDecimal(2, data.getPcueu_usuf_cod());
/* 154:127 */       pstmt.executeUpdate();
/* 155:    */     }
/* 156:    */     catch (SQLException e)
/* 157:    */     {
/* 158:129 */       close(pstmt);
/* 159:130 */       throw e;
/* 160:    */     }
/* 161:    */     finally
/* 162:    */     {
/* 163:132 */       close(pstmt);
/* 164:    */     }
/* 165:    */   }
/* 166:    */   
/* 167:    */   public void deleteAll(BigDecimal pcueu_usuf_cod, Connection conn)
/* 168:    */     throws SQLException
/* 169:    */   {
/* 170:137 */     PreparedStatement pstmt = null;
/* 171:    */     try
/* 172:    */     {
/* 173:139 */       String sql = "DELETE FROM sdoctor.partescuerpousuario WHERE pcueu_usuf_cod=?";
/* 174:140 */       pstmt = conn.prepareStatement(sql);
/* 175:141 */       pstmt.setBigDecimal(1, pcueu_usuf_cod);
/* 176:142 */       pstmt.executeUpdate();
/* 177:    */     }
/* 178:    */     catch (SQLException e)
/* 179:    */     {
/* 180:144 */       throw e;
/* 181:    */     }
/* 182:    */     finally
/* 183:    */     {
/* 184:146 */       close(pstmt);
/* 185:    */     }
/* 186:    */   }
/* 187:    */   
/* 188:    */   private int getReqMax(Connection conn, PartesCuerpoUsuario data)
/* 189:    */     throws SQLException
/* 190:    */   {
/* 191:151 */     PreparedStatement pstmt = null;
/* 192:152 */     ResultSet rs = null;
/* 193:153 */     int id = 0;
/* 194:    */     try
/* 195:    */     {
/* 196:155 */       String sqlid = "Select max(pcueu_cod) from sdoctor.partescuerpousuario where pcueu_usuf_cod = ?";
/* 197:    */       
/* 198:157 */       pstmt = conn.prepareStatement(sqlid);
/* 199:158 */       pstmt.setBigDecimal(1, data.getPcueu_usuf_cod());
/* 200:159 */       rs = pstmt.executeQuery();
/* 201:160 */       if ((rs != null) && (rs.next())) {
/* 202:161 */         id = rs.getInt(1) + 1;
/* 203:    */       } else {
/* 204:163 */         id++;
/* 205:    */       }
/* 206:    */     }
/* 207:    */     catch (SQLException e)
/* 208:    */     {
/* 209:167 */       throw e;
/* 210:    */     }
/* 211:    */     finally
/* 212:    */     {
/* 213:169 */       close(rs);
/* 214:170 */       close(pstmt);
/* 215:    */     }
/* 216:172 */     return id;
/* 217:    */   }
/* 218:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.dao.PartesCuerpoUsuarioDAO
 * JD-Core Version:    0.7.0.1
 */