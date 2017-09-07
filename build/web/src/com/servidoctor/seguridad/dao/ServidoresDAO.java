/*   1:    */ package com.servidoctor.seguridad.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.seguridad.model.Servidores;
/*   5:    */ import com.servidoctor.util.classes.DBUtil;
/*   6:    */ import com.servidoctor.util.classes.InicializaData;
/*   7:    */ import java.math.BigDecimal;
/*   8:    */ import java.sql.Connection;
/*   9:    */ import java.sql.PreparedStatement;
/*  10:    */ import java.sql.ResultSet;
/*  11:    */ import java.sql.SQLException;
/*  12:    */ import java.util.ArrayList;
/*  13:    */ import java.util.List;
/*  14:    */ import java.util.ResourceBundle;
/*  15:    */ import javax.sql.DataSource;
/*  16:    */ 
/*  17:    */ public class ServidoresDAO
/*  18:    */   extends DAO
/*  19:    */ {
/*  20: 20 */   private static final ResourceBundle prop = ResourceBundle.getBundle("com.servidoctor.resources.Config");
/*  21:    */   
/*  22:    */   public ServidoresDAO()
/*  23:    */   {
/*  24: 23 */     super(prop.getString("jndi.vega.name"));
/*  25:    */   }
/*  26:    */   
/*  27:    */   public void update(Servidores data, String[] llaves)
/*  28:    */     throws SQLException
/*  29:    */   {
/*  30: 27 */     Connection conn = null;
/*  31: 28 */     PreparedStatement pstmt = null;
/*  32:    */     try
/*  33:    */     {
/*  34: 30 */       DBUtil db = new DBUtil("vega_sdoctor");
/*  35: 31 */       conn = this.ds.getConnection();
/*  36: 32 */       conn.setAutoCommit(false);
/*  37: 33 */       String sql = db.creaSQLUPDATE(data, llaves);
/*  38: 34 */       pstmt = conn.prepareStatement(sql);
/*  39: 35 */       pstmt.executeUpdate();
/*  40: 36 */       close(pstmt);
/*  41: 37 */       conn.commit();
/*  42:    */     }
/*  43:    */     catch (SQLException e)
/*  44:    */     {
/*  45: 39 */       close(pstmt);
/*  46: 40 */       rollback(conn);
/*  47: 41 */       throw e;
/*  48:    */     }
/*  49:    */     finally
/*  50:    */     {
/*  51: 43 */       close(conn);
/*  52:    */     }
/*  53:    */   }
/*  54:    */   
/*  55:    */   public Servidores retrive(BigDecimal serv_cod)
/*  56:    */     throws SQLException
/*  57:    */   {
/*  58: 48 */     Servidores servidor = new Servidores();
/*  59: 49 */     Connection conn = null;
/*  60: 50 */     PreparedStatement pstmt = null;
/*  61: 51 */     ResultSet rs = null;
/*  62: 52 */     Servidores servidorS = new Servidores();
/*  63:    */     try
/*  64:    */     {
/*  65: 54 */       conn = this.ds.getConnection();
/*  66: 55 */       DBUtil db = new DBUtil("vega_sdoctor");
/*  67: 56 */       String sql = db.creaSQLSELECT(servidorS);
/*  68: 57 */       String where = " where serv_cod = ?";
/*  69: 58 */       pstmt = conn.prepareStatement(sql + where);
/*  70: 59 */       pstmt.setBigDecimal(1, serv_cod);
/*  71: 60 */       rs = pstmt.executeQuery();
/*  72: 61 */       if (rs.next())
/*  73:    */       {
/*  74: 62 */         InicializaData.inicializa(servidor.getClass(), servidor);
/*  75: 63 */         populate(servidor, rs);
/*  76:    */       }
/*  77: 65 */       close(rs);
/*  78: 66 */       close(pstmt);
/*  79:    */     }
/*  80:    */     catch (SQLException e)
/*  81:    */     {
/*  82: 68 */       close(rs);
/*  83: 69 */       close(pstmt);
/*  84: 70 */       rollback(conn);
/*  85: 71 */       throw e;
/*  86:    */     }
/*  87:    */     finally
/*  88:    */     {
/*  89: 73 */       close(conn);
/*  90:    */     }
/*  91: 75 */     return servidor;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public List list()
/*  95:    */     throws SQLException
/*  96:    */   {
/*  97: 79 */     Connection conn = null;
/*  98: 80 */     PreparedStatement pstmt = null;
/*  99: 81 */     ResultSet rs = null;
/* 100: 82 */     Servidores servidorS = new Servidores();
/* 101: 83 */     List servidores = new ArrayList();
/* 102:    */     try
/* 103:    */     {
/* 104: 85 */       conn = this.ds.getConnection();
/* 105: 86 */       DBUtil db = new DBUtil("vega_sdoctor");
/* 106: 87 */       String sql = db.creaSQLSELECT(servidorS);
/* 107: 88 */       pstmt = conn.prepareStatement(sql);
/* 108: 89 */       rs = pstmt.executeQuery();
/* 109: 90 */       while (rs.next())
/* 110:    */       {
/* 111: 91 */         Servidores servidor = new Servidores();
/* 112: 92 */         InicializaData.inicializa(servidor.getClass(), servidor);
/* 113: 93 */         populate(servidor, rs);
/* 114: 94 */         servidores.add(servidor);
/* 115:    */       }
/* 116: 96 */       close(rs);
/* 117: 97 */       close(pstmt);
/* 118:    */     }
/* 119:    */     catch (SQLException e)
/* 120:    */     {
/* 121: 99 */       close(rs);
/* 122:100 */       close(pstmt);
/* 123:101 */       rollback(conn);
/* 124:102 */       throw e;
/* 125:    */     }
/* 126:    */     finally
/* 127:    */     {
/* 128:104 */       close(conn);
/* 129:    */     }
/* 130:106 */     return servidores;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public synchronized void insert(Servidores data)
/* 134:    */     throws SQLException
/* 135:    */   {
/* 136:110 */     Connection conn = null;
/* 137:111 */     PreparedStatement pstmt = null;
/* 138:    */     
/* 139:113 */     ResultSet rs = null;
/* 140:    */     try
/* 141:    */     {
/* 142:115 */       int id = 0;
/* 143:116 */       DBUtil db = new DBUtil("vega_sdoctor");
/* 144:117 */       conn = this.ds.getConnection();
/* 145:118 */       conn.setAutoCommit(false);
/* 146:119 */       id = getReqMax(conn);
/* 147:120 */       data.setServ_cod(new BigDecimal(id));
/* 148:121 */       String sql = db.creaSQLINSERT(data);
/* 149:122 */       pstmt = conn.prepareStatement(sql);
/* 150:123 */       pstmt.executeUpdate();
/* 151:124 */       pstmt.close();
/* 152:125 */       conn.commit();
/* 153:    */     }
/* 154:    */     catch (SQLException sqle)
/* 155:    */     {
/* 156:127 */       close(rs);
/* 157:128 */       close(pstmt);
/* 158:129 */       rollback(conn);
/* 159:130 */       throw sqle;
/* 160:    */     }
/* 161:    */     finally
/* 162:    */     {
/* 163:132 */       close(rs);
/* 164:133 */       close(pstmt);
/* 165:134 */       close(conn);
/* 166:    */     }
/* 167:    */   }
/* 168:    */   
/* 169:    */   public void delete(Servidores data)
/* 170:    */     throws SQLException
/* 171:    */   {
/* 172:139 */     Connection conn = null;
/* 173:140 */     PreparedStatement pstmt = null;
/* 174:    */     try
/* 175:    */     {
/* 176:142 */       conn = this.ds.getConnection();
/* 177:143 */       conn.setAutoCommit(false);
/* 178:144 */       String sql = "DELETE FROM vega_sdoctor.servidores WHERE serv_cod = ?";
/* 179:145 */       pstmt = conn.prepareStatement(sql);
/* 180:146 */       pstmt.setBigDecimal(1, data.getServ_cod());
/* 181:147 */       pstmt.executeUpdate();
/* 182:148 */       close(pstmt);
/* 183:149 */       conn.commit();
/* 184:    */     }
/* 185:    */     catch (SQLException e)
/* 186:    */     {
/* 187:151 */       close(pstmt);
/* 188:152 */       rollback(conn);
/* 189:153 */       throw e;
/* 190:    */     }
/* 191:    */     finally
/* 192:    */     {
/* 193:155 */       close(conn);
/* 194:    */     }
/* 195:    */   }
/* 196:    */   
/* 197:    */   private int getReqMax(Connection conn)
/* 198:    */   {
/* 199:160 */     PreparedStatement pstmt = null;
/* 200:161 */     ResultSet rs = null;
/* 201:162 */     int id2 = 0;
/* 202:    */     try
/* 203:    */     {
/* 204:164 */       String sqlid = "Select max(serv_cod) from vega_sdoctor.servidores";
/* 205:165 */       pstmt = conn.prepareStatement(sqlid);
/* 206:166 */       rs = pstmt.executeQuery();
/* 207:167 */       if ((rs != null) && (rs.next())) {
/* 208:168 */         id2 = rs.getInt(1) + 1;
/* 209:    */       } else {
/* 210:170 */         id2++;
/* 211:    */       }
/* 212:    */     }
/* 213:    */     catch (SQLException e)
/* 214:    */     {
/* 215:173 */       close(rs);
/* 216:174 */       close(pstmt);
/* 217:175 */       rollback(conn);
/* 218:176 */       e.printStackTrace();
/* 219:    */     }
/* 220:    */     finally
/* 221:    */     {
/* 222:178 */       close(rs);
/* 223:179 */       close(pstmt);
/* 224:    */     }
/* 225:181 */     return id2;
/* 226:    */   }
/* 227:    */   
/* 228:    */   public void updateNewUser(BigDecimal codigoServidor)
/* 229:    */     throws SQLException
/* 230:    */   {
/* 231:185 */     Connection conn = null;
/* 232:186 */     PreparedStatement pstmt = null;
/* 233:    */     try
/* 234:    */     {
/* 235:188 */       conn = this.ds.getConnection();
/* 236:189 */       conn.setAutoCommit(false);
/* 237:190 */       String sql = "update vega_sdoctor.servidores set current_users = current_users + 1 where serv_cod = ?";
/* 238:191 */       pstmt = conn.prepareStatement(sql);
/* 239:192 */       pstmt.setBigDecimal(1, codigoServidor);
/* 240:193 */       pstmt.executeUpdate();
/* 241:194 */       close(pstmt);
/* 242:195 */       conn.commit();
/* 243:    */     }
/* 244:    */     catch (SQLException e)
/* 245:    */     {
/* 246:197 */       close(pstmt);
/* 247:198 */       rollback(conn);
/* 248:199 */       throw e;
/* 249:    */     }
/* 250:    */     finally
/* 251:    */     {
/* 252:201 */       close(conn);
/* 253:    */     }
/* 254:    */   }
/* 255:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.seguridad.dao.ServidoresDAO
 * JD-Core Version:    0.7.0.1
 */