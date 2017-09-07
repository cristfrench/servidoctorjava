/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.Medida;
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
/*  16:    */ public class MedidaDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list()
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 26 */     ArrayList list = new ArrayList();
/*  23: 27 */     Connection conn = null;
/*  24: 28 */     PreparedStatement pstmt = null;
/*  25: 29 */     ResultSet rs = null;
/*  26: 30 */     Medida medidaS = new Medida();
/*  27:    */     try
/*  28:    */     {
/*  29: 32 */       conn = this.ds.getConnection();
/*  30: 33 */       DBUtil db = new DBUtil();
/*  31: 34 */       if (this.idioma != null) {
/*  32: 35 */         db.setIdioma(this.idioma);
/*  33:    */       }
/*  34: 37 */       String sql = db.creaSQLSELECT(medidaS);
/*  35: 38 */       pstmt = conn.prepareStatement(sql + " order by medi_des");
/*  36: 39 */       rs = pstmt.executeQuery();
/*  37: 40 */       while (rs.next())
/*  38:    */       {
/*  39: 41 */         Medida medida = new Medida();
/*  40: 42 */         InicializaData.inicializa(medida.getClass(), medida);
/*  41: 43 */         populate(medida, rs);
/*  42: 44 */         list.add(medida);
/*  43:    */       }
/*  44: 46 */       close(rs);
/*  45: 47 */       close(pstmt);
/*  46:    */     }
/*  47:    */     catch (SQLException e)
/*  48:    */     {
/*  49: 49 */       close(rs);
/*  50: 50 */       close(pstmt);
/*  51: 51 */       rollback(conn);
/*  52: 52 */       throw e;
/*  53:    */     }
/*  54:    */     finally
/*  55:    */     {
/*  56: 54 */       close(conn);
/*  57:    */     }
/*  58: 56 */     return list;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public Medida retrive(BigDecimal medi_cod)
/*  62:    */     throws SQLException
/*  63:    */   {
/*  64: 61 */     Medida medida = new Medida();
/*  65: 62 */     Connection conn = null;
/*  66: 63 */     PreparedStatement pstmt = null;
/*  67: 64 */     ResultSet rs = null;
/*  68: 65 */     Medida medidaS = new Medida();
/*  69:    */     try
/*  70:    */     {
/*  71: 67 */       conn = this.ds.getConnection();
/*  72: 68 */       DBUtil db = new DBUtil();
/*  73: 69 */       if (this.idioma != null) {
/*  74: 70 */         db.setIdioma(this.idioma);
/*  75:    */       }
/*  76: 72 */       String sql = db.creaSQLSELECT(medidaS);
/*  77: 73 */       String where = " where medi_cod=" + medi_cod;
/*  78: 74 */       pstmt = conn.prepareStatement(sql + " " + where);
/*  79: 75 */       rs = pstmt.executeQuery();
/*  80: 76 */       if (rs.next())
/*  81:    */       {
/*  82: 78 */         InicializaData.inicializa(medida.getClass(), medida);
/*  83: 79 */         populate(medida, rs);
/*  84:    */       }
/*  85: 82 */       close(rs);
/*  86: 83 */       close(pstmt);
/*  87:    */     }
/*  88:    */     catch (SQLException e)
/*  89:    */     {
/*  90: 85 */       close(rs);
/*  91: 86 */       close(pstmt);
/*  92: 87 */       rollback(conn);
/*  93: 88 */       throw e;
/*  94:    */     }
/*  95:    */     finally
/*  96:    */     {
/*  97: 90 */       close(conn);
/*  98:    */     }
/*  99: 92 */     return medida;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public void update(Medida data, String[] llaves)
/* 103:    */     throws SQLException
/* 104:    */   {
/* 105: 95 */     Connection conn = null;
/* 106: 96 */     PreparedStatement pstmt = null;
/* 107:    */     try
/* 108:    */     {
/* 109: 98 */       DBUtil db = new DBUtil();
/* 110: 99 */       if (this.idioma != null) {
/* 111:100 */         db.setIdioma(this.idioma);
/* 112:    */       }
/* 113:102 */       conn = this.ds.getConnection();
/* 114:103 */       conn.setAutoCommit(false);
/* 115:104 */       String sql = db.creaSQLUPDATE(data, llaves);
/* 116:105 */       pstmt = conn.prepareStatement(sql);
/* 117:106 */       pstmt.executeUpdate();
/* 118:107 */       close(pstmt);
/* 119:108 */       conn.commit();
/* 120:    */     }
/* 121:    */     catch (SQLException e)
/* 122:    */     {
/* 123:110 */       close(pstmt);
/* 124:111 */       rollback(conn);
/* 125:112 */       throw e;
/* 126:    */     }
/* 127:    */     finally
/* 128:    */     {
/* 129:114 */       close(conn);
/* 130:    */     }
/* 131:    */   }
/* 132:    */   
/* 133:    */   public synchronized void insert(Medida data)
/* 134:    */     throws SQLException
/* 135:    */   {
/* 136:118 */     Connection conn = null;
/* 137:119 */     PreparedStatement pstmt = null;
/* 138:    */     
/* 139:121 */     ResultSet rs = null;
/* 140:    */     try
/* 141:    */     {
/* 142:123 */       int id = 0;
/* 143:124 */       DBUtil db = new DBUtil();
/* 144:125 */       if (this.idioma != null) {
/* 145:126 */         db.setIdioma(this.idioma);
/* 146:    */       }
/* 147:129 */       conn = this.ds.getConnection();
/* 148:130 */       conn.setAutoCommit(false);
/* 149:131 */       id = getReqMax(conn);
/* 150:132 */       data.setMedi_cod(new BigDecimal(id));
/* 151:133 */       String sql = db.creaSQLINSERT(data);
/* 152:    */       
/* 153:135 */       pstmt = conn.prepareStatement(sql);
/* 154:136 */       pstmt.executeUpdate();
/* 155:137 */       pstmt.close();
/* 156:138 */       conn.commit();
/* 157:    */     }
/* 158:    */     catch (SQLException sqle)
/* 159:    */     {
/* 160:140 */       close(rs);
/* 161:141 */       close(pstmt);
/* 162:142 */       rollback(conn);
/* 163:143 */       throw sqle;
/* 164:    */     }
/* 165:    */     finally
/* 166:    */     {
/* 167:145 */       close(rs);
/* 168:146 */       close(pstmt);
/* 169:147 */       close(conn);
/* 170:    */     }
/* 171:    */   }
/* 172:    */   
/* 173:    */   public void delete(Medida data)
/* 174:    */     throws SQLException
/* 175:    */   {
/* 176:152 */     Connection conn = null;
/* 177:153 */     PreparedStatement pstmt = null;
/* 178:    */     try
/* 179:    */     {
/* 180:155 */       conn = this.ds.getConnection();
/* 181:156 */       conn.setAutoCommit(false);
/* 182:157 */       String sql = "DELETE FROM sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".medida WHERE medi_cod=?";
/* 183:158 */       pstmt = conn.prepareStatement(sql);
/* 184:159 */       pstmt.setBigDecimal(1, data.getMedi_cod());
/* 185:160 */       pstmt.executeUpdate();
/* 186:161 */       close(pstmt);
/* 187:162 */       conn.commit();
/* 188:    */     }
/* 189:    */     catch (SQLException e)
/* 190:    */     {
/* 191:164 */       close(pstmt);
/* 192:165 */       rollback(conn);
/* 193:166 */       throw e;
/* 194:    */     }
/* 195:    */     finally
/* 196:    */     {
/* 197:168 */       close(conn);
/* 198:    */     }
/* 199:    */   }
/* 200:    */   
/* 201:    */   private int getReqMax(Connection conn)
/* 202:    */   {
/* 203:172 */     PreparedStatement pstmt = null;
/* 204:173 */     ResultSet rs = null;
/* 205:174 */     int id = 0;
/* 206:    */     try
/* 207:    */     {
/* 208:176 */       String sqlid = "Select max(medi_cod) from sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".medida ";
/* 209:177 */       pstmt = conn.prepareStatement(sqlid);
/* 210:178 */       rs = pstmt.executeQuery();
/* 211:179 */       if ((rs != null) && (rs.next())) {
/* 212:180 */         id = rs.getInt(1) + 1;
/* 213:    */       } else {
/* 214:182 */         id++;
/* 215:    */       }
/* 216:    */     }
/* 217:    */     catch (SQLException e)
/* 218:    */     {
/* 219:186 */       close(rs);
/* 220:187 */       close(pstmt);
/* 221:188 */       rollback(conn);
/* 222:189 */       e.printStackTrace();
/* 223:    */     }
/* 224:    */     finally
/* 225:    */     {
/* 226:191 */       close(rs);
/* 227:192 */       close(pstmt);
/* 228:    */     }
/* 229:194 */     return id;
/* 230:    */   }
/* 231:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.MedidaDAO
 * JD-Core Version:    0.7.0.1
 */