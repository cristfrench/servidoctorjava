/*   1:    */ package com.servidoctor.parametros.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.model.Vacunas;
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
/*  16:    */ public class VacunasDAO
/*  17:    */   extends DAO
/*  18:    */ {
/*  19:    */   public List list()
/*  20:    */     throws SQLException
/*  21:    */   {
/*  22: 26 */     ArrayList list = new ArrayList();
/*  23: 27 */     Connection conn = null;
/*  24: 28 */     PreparedStatement pstmt = null;
/*  25: 29 */     ResultSet rs = null;
/*  26: 30 */     Vacunas vacunasS = new Vacunas();
/*  27:    */     try
/*  28:    */     {
/*  29: 32 */       conn = this.ds.getConnection();
/*  30: 33 */       DBUtil db = new DBUtil();
/*  31: 34 */       if (this.idioma != null) {
/*  32: 35 */         db.setIdioma(this.idioma);
/*  33:    */       }
/*  34: 37 */       String sql = db.creaSQLSELECT(vacunasS);
/*  35: 38 */       pstmt = conn.prepareStatement(sql + " order by vac_des");
/*  36: 39 */       rs = pstmt.executeQuery();
/*  37: 40 */       while (rs.next())
/*  38:    */       {
/*  39: 41 */         Vacunas vacunas = new Vacunas();
/*  40: 42 */         InicializaData.inicializa(vacunas.getClass(), vacunas);
/*  41: 43 */         populate(vacunas, rs);
/*  42: 44 */         list.add(vacunas);
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
/*  61:    */   public void update(Vacunas data, String[] llaves)
/*  62:    */     throws SQLException
/*  63:    */   {
/*  64: 60 */     Connection conn = null;
/*  65: 61 */     PreparedStatement pstmt = null;
/*  66:    */     try
/*  67:    */     {
/*  68: 63 */       DBUtil db = new DBUtil();
/*  69: 64 */       if (this.idioma != null) {
/*  70: 65 */         db.setIdioma(this.idioma);
/*  71:    */       }
/*  72: 67 */       conn = this.ds.getConnection();
/*  73: 68 */       conn.setAutoCommit(false);
/*  74: 69 */       String sql = db.creaSQLUPDATE(data, llaves);
/*  75:    */       
/*  76: 71 */       pstmt = conn.prepareStatement(sql);
/*  77: 72 */       pstmt.executeUpdate();
/*  78: 73 */       close(pstmt);
/*  79: 74 */       conn.commit();
/*  80:    */     }
/*  81:    */     catch (SQLException e)
/*  82:    */     {
/*  83: 76 */       close(pstmt);
/*  84: 77 */       rollback(conn);
/*  85: 78 */       throw e;
/*  86:    */     }
/*  87:    */     finally
/*  88:    */     {
/*  89: 80 */       close(conn);
/*  90:    */     }
/*  91:    */   }
/*  92:    */   
/*  93:    */   public Vacunas retrieve(BigDecimal vac_cod)
/*  94:    */     throws SQLException
/*  95:    */   {
/*  96: 86 */     Vacunas vacunas = new Vacunas();
/*  97: 87 */     Connection conn = null;
/*  98: 88 */     PreparedStatement pstmt = null;
/*  99: 89 */     ResultSet rs = null;
/* 100: 90 */     Vacunas vacunasS = new Vacunas();
/* 101:    */     try
/* 102:    */     {
/* 103: 92 */       conn = this.ds.getConnection();
/* 104: 93 */       DBUtil db = new DBUtil();
/* 105: 94 */       if (this.idioma != null) {
/* 106: 95 */         db.setIdioma(this.idioma);
/* 107:    */       }
/* 108: 97 */       String sql = db.creaSQLSELECT(vacunasS);
/* 109: 98 */       String where = " where vac_cod=" + vac_cod;
/* 110: 99 */       pstmt = conn.prepareStatement(sql + " " + where);
/* 111:100 */       rs = pstmt.executeQuery();
/* 112:101 */       if (rs.next())
/* 113:    */       {
/* 114:102 */         InicializaData.inicializa(vacunas.getClass(), vacunas);
/* 115:103 */         populate(vacunas, rs);
/* 116:    */       }
/* 117:105 */       close(rs);
/* 118:106 */       close(pstmt);
/* 119:    */     }
/* 120:    */     catch (SQLException e)
/* 121:    */     {
/* 122:108 */       close(rs);
/* 123:109 */       close(pstmt);
/* 124:110 */       rollback(conn);
/* 125:111 */       throw e;
/* 126:    */     }
/* 127:    */     finally
/* 128:    */     {
/* 129:113 */       close(conn);
/* 130:    */     }
/* 131:115 */     return vacunas;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public synchronized void insert(Vacunas data)
/* 135:    */     throws SQLException
/* 136:    */   {
/* 137:119 */     Connection conn = null;
/* 138:120 */     PreparedStatement pstmt = null;
/* 139:    */     
/* 140:122 */     ResultSet rs = null;
/* 141:    */     try
/* 142:    */     {
/* 143:124 */       int id = 0;
/* 144:125 */       DBUtil db = new DBUtil();
/* 145:126 */       if (this.idioma != null) {
/* 146:127 */         db.setIdioma(this.idioma);
/* 147:    */       }
/* 148:130 */       conn = this.ds.getConnection();
/* 149:131 */       conn.setAutoCommit(false);
/* 150:132 */       id = getReqMax(conn);
/* 151:133 */       data.setVac_cod(new BigDecimal(id));
/* 152:134 */       String sql = db.creaSQLINSERT(data);
/* 153:    */       
/* 154:136 */       pstmt = conn.prepareStatement(sql);
/* 155:137 */       pstmt.executeUpdate();
/* 156:138 */       pstmt.close();
/* 157:139 */       conn.commit();
/* 158:    */     }
/* 159:    */     catch (SQLException sqle)
/* 160:    */     {
/* 161:141 */       close(rs);
/* 162:142 */       close(pstmt);
/* 163:143 */       rollback(conn);
/* 164:144 */       throw sqle;
/* 165:    */     }
/* 166:    */     finally
/* 167:    */     {
/* 168:146 */       close(rs);
/* 169:147 */       close(pstmt);
/* 170:148 */       close(conn);
/* 171:    */     }
/* 172:    */   }
/* 173:    */   
/* 174:    */   public void delete(Vacunas data)
/* 175:    */     throws SQLException
/* 176:    */   {
/* 177:153 */     Connection conn = null;
/* 178:154 */     PreparedStatement pstmt = null;
/* 179:    */     try
/* 180:    */     {
/* 181:156 */       conn = this.ds.getConnection();
/* 182:157 */       conn.setAutoCommit(false);
/* 183:158 */       String sql = "DELETE FROM sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".vacunas WHERE vac_cod = ? ";
/* 184:159 */       pstmt = conn.prepareStatement(sql);
/* 185:160 */       pstmt.setBigDecimal(1, data.getVac_cod());
/* 186:161 */       pstmt.executeUpdate();
/* 187:162 */       close(pstmt);
/* 188:163 */       conn.commit();
/* 189:    */     }
/* 190:    */     catch (SQLException e)
/* 191:    */     {
/* 192:165 */       close(pstmt);
/* 193:166 */       rollback(conn);
/* 194:167 */       throw e;
/* 195:    */     }
/* 196:    */     finally
/* 197:    */     {
/* 198:169 */       close(conn);
/* 199:    */     }
/* 200:    */   }
/* 201:    */   
/* 202:    */   private int getReqMax(Connection conn)
/* 203:    */   {
/* 204:174 */     PreparedStatement pstmt = null;
/* 205:175 */     ResultSet rs = null;
/* 206:176 */     int id = 0;
/* 207:    */     try
/* 208:    */     {
/* 209:178 */       String sqlid = "Select max(vac_cod) from sdoctor" + (this.idioma != null ? "_" + this.idioma : "") + ".vacunas ";
/* 210:    */       
/* 211:180 */       pstmt = conn.prepareStatement(sqlid);
/* 212:181 */       rs = pstmt.executeQuery();
/* 213:182 */       if ((rs != null) && (rs.next())) {
/* 214:183 */         id = rs.getInt(1) + 1;
/* 215:    */       } else {
/* 216:185 */         id++;
/* 217:    */       }
/* 218:    */     }
/* 219:    */     catch (SQLException e)
/* 220:    */     {
/* 221:189 */       close(rs);
/* 222:190 */       close(pstmt);
/* 223:191 */       rollback(conn);
/* 224:192 */       e.printStackTrace();
/* 225:    */     }
/* 226:    */     finally
/* 227:    */     {
/* 228:194 */       close(rs);
/* 229:195 */       close(pstmt);
/* 230:    */     }
/* 231:197 */     return id;
/* 232:    */   }
/* 233:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.dao.VacunasDAO
 * JD-Core Version:    0.7.0.1
 */