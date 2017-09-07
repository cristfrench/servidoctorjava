/*   1:    */ package com.servidoctor.seguridad.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.seguridad.model.GrupoSegmentacion;
/*   5:    */ import com.servidoctor.util.classes.DBUtil;
/*   6:    */ import java.math.BigDecimal;
/*   7:    */ import java.sql.Connection;
/*   8:    */ import java.sql.PreparedStatement;
/*   9:    */ import java.sql.ResultSet;
/*  10:    */ import java.sql.SQLException;
/*  11:    */ import java.util.ResourceBundle;
/*  12:    */ import javax.sql.DataSource;
/*  13:    */ 
/*  14:    */ public class GrupoSegmentacionDAO
/*  15:    */   extends DAO
/*  16:    */ {
/*  17: 25 */   private static final ResourceBundle prop = ResourceBundle.getBundle("com.servidoctor.resources.Config");
/*  18:    */   
/*  19:    */   public GrupoSegmentacionDAO()
/*  20:    */   {
/*  21: 28 */     super(prop.getString("jndi.vega.name"));
/*  22:    */   }
/*  23:    */   
/*  24:    */   public GrupoSegmentacion retrive(BigDecimal consecutivo)
/*  25:    */     throws SQLException
/*  26:    */   {
/*  27: 33 */     GrupoSegmentacion grupoSegmentacion = new GrupoSegmentacion();
/*  28: 34 */     Connection conn = null;
/*  29: 35 */     PreparedStatement pstmt = null;
/*  30: 36 */     ResultSet rs = null;
/*  31: 37 */     GrupoSegmentacion grupoSSegmentacion = new GrupoSegmentacion();
/*  32:    */     try
/*  33:    */     {
/*  34: 39 */       conn = this.ds.getConnection();
/*  35: 40 */       DBUtil db = new DBUtil("vega_sdoctor");
/*  36: 41 */       String sql = db.creaSQLSELECT(grupoSSegmentacion);
/*  37: 42 */       String where = " where gruposegmentacion.consecutivo = ?";
/*  38: 43 */       pstmt = conn.prepareStatement(sql + where);
/*  39: 44 */       pstmt.setBigDecimal(1, consecutivo);
/*  40: 45 */       rs = pstmt.executeQuery();
/*  41: 46 */       if (rs.next())
/*  42:    */       {
/*  43: 49 */         grupoSegmentacion.setCod_usuario(rs.getString("cod_usuario"));
/*  44: 50 */         grupoSegmentacion.setNombre_grupo(rs.getString("nombre_grupo"));
/*  45: 51 */         grupoSegmentacion.setAfiliado(rs.getString("afiliado"));
/*  46: 52 */         grupoSegmentacion.setConsecutivo(rs.getBigDecimal("consecutivo"));
/*  47:    */       }
/*  48: 60 */       close(rs);
/*  49: 61 */       close(pstmt);
/*  50:    */     }
/*  51:    */     catch (SQLException e)
/*  52:    */     {
/*  53: 63 */       close(rs);
/*  54: 64 */       close(pstmt);
/*  55: 65 */       rollback(conn);
/*  56: 66 */       throw e;
/*  57:    */     }
/*  58:    */     finally
/*  59:    */     {
/*  60: 68 */       close(conn);
/*  61:    */     }
/*  62: 70 */     return grupoSegmentacion;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public GrupoSegmentacion retrieve(String cod_usuario)
/*  66:    */     throws SQLException
/*  67:    */   {
/*  68: 76 */     GrupoSegmentacion grupoSegmentacion = new GrupoSegmentacion();
/*  69: 77 */     Connection conn = null;
/*  70: 78 */     PreparedStatement pstmt = null;
/*  71: 79 */     ResultSet rs = null;
/*  72: 80 */     GrupoSegmentacion grupoSSegmentacion = new GrupoSegmentacion();
/*  73:    */     try
/*  74:    */     {
/*  75: 82 */       conn = this.ds.getConnection();
/*  76: 83 */       DBUtil db = new DBUtil("vega_sdoctor");
/*  77: 84 */       String sql = db.creaSQLSELECT(grupoSSegmentacion);
/*  78: 85 */       String where = " where gruposegmentacion.cod_usuario = ?";
/*  79: 86 */       pstmt = conn.prepareStatement(sql + where);
/*  80: 87 */       pstmt.setString(1, cod_usuario);
/*  81: 88 */       rs = pstmt.executeQuery();
/*  82: 89 */       if (rs.next())
/*  83:    */       {
/*  84: 92 */         grupoSegmentacion.setCod_usuario(rs.getString("cod_usuario"));
/*  85: 93 */         grupoSegmentacion.setNombre_grupo(rs.getString("nombre_grupo"));
/*  86: 94 */         grupoSegmentacion.setAfiliado(rs.getString("afiliado"));
/*  87: 95 */         grupoSegmentacion.setConsecutivo(rs.getBigDecimal("consecutivo"));
/*  88:    */       }
/*  89:103 */       close(rs);
/*  90:104 */       close(pstmt);
/*  91:    */     }
/*  92:    */     catch (SQLException e)
/*  93:    */     {
/*  94:106 */       close(rs);
/*  95:107 */       close(pstmt);
/*  96:108 */       rollback(conn);
/*  97:109 */       throw e;
/*  98:    */     }
/*  99:    */     finally
/* 100:    */     {
/* 101:111 */       close(conn);
/* 102:    */     }
/* 103:113 */     return grupoSegmentacion;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public void update(GrupoSegmentacion data)
/* 107:    */     throws SQLException
/* 108:    */   {
/* 109:150 */     Connection conn = null;
/* 110:151 */     PreparedStatement pstmt = null;
/* 111:    */     try
/* 112:    */     {
/* 113:153 */       conn = this.ds.getConnection();
/* 114:154 */       conn.setAutoCommit(false);
/* 115:155 */       String sql = "update vega_sdoctor.gruposegmentacion set gruposegmentacion.consecutivo = ?, gruposegmentacion.cod_usuario = ? , gruposegmentacion.nombre_grupo = ?, gruposegmentacion.afiliado = ? where gruposegmentacion.consecutivo = ?";
/* 116:    */       
/* 117:    */ 
/* 118:158 */       pstmt = conn.prepareStatement(sql);
/* 119:    */       
/* 120:    */ 
/* 121:161 */       pstmt.setBigDecimal(1, data.getConsecutivo());
/* 122:162 */       pstmt.setString(2, data.getCod_usuario());
/* 123:163 */       pstmt.setString(3, data.getNombre_grupo());
/* 124:164 */       pstmt.setString(4, data.getAfiliado());
/* 125:165 */       pstmt.setBigDecimal(5, data.getConsecutivo());
/* 126:166 */       pstmt.executeUpdate();
/* 127:167 */       close(pstmt);
/* 128:168 */       conn.commit();
/* 129:    */     }
/* 130:    */     catch (SQLException e)
/* 131:    */     {
/* 132:170 */       close(pstmt);
/* 133:171 */       rollback(conn);
/* 134:172 */       e.printStackTrace();
/* 135:    */     }
/* 136:    */     finally
/* 137:    */     {
/* 138:174 */       close(conn);
/* 139:    */     }
/* 140:    */   }
/* 141:    */   
/* 142:    */   public synchronized void insert(GrupoSegmentacion data)
/* 143:    */     throws SQLException
/* 144:    */   {
/* 145:178 */     Connection conn = null;
/* 146:179 */     PreparedStatement pstmt = null;
/* 147:    */     
/* 148:181 */     ResultSet rs = null;
/* 149:    */     try
/* 150:    */     {
/* 151:183 */       int id = 0;
/* 152:184 */       DBUtil db = new DBUtil();
/* 153:185 */       conn = this.ds.getConnection();
/* 154:186 */       conn.setAutoCommit(false);
/* 155:187 */       id = getReqMax(conn);
/* 156:188 */       data.setConsecutivo(new BigDecimal(id));
/* 157:189 */       String sql = db.creaSQLINSERT(data);
/* 158:190 */       pstmt = conn.prepareStatement(sql);
/* 159:191 */       pstmt.executeUpdate();
/* 160:192 */       pstmt.close();
/* 161:193 */       conn.commit();
/* 162:    */     }
/* 163:    */     catch (SQLException sqle)
/* 164:    */     {
/* 165:195 */       close(rs);
/* 166:196 */       close(pstmt);
/* 167:197 */       rollback(conn);
/* 168:198 */       throw sqle;
/* 169:    */     }
/* 170:    */     finally
/* 171:    */     {
/* 172:200 */       close(rs);
/* 173:201 */       close(pstmt);
/* 174:202 */       close(conn);
/* 175:    */     }
/* 176:    */   }
/* 177:    */   
/* 178:    */   private int getReqMax(Connection conn)
/* 179:    */   {
/* 180:207 */     PreparedStatement pstmt = null;
/* 181:208 */     ResultSet rs = null;
/* 182:209 */     int id2 = 0;
/* 183:    */     try
/* 184:    */     {
/* 185:211 */       String sqlid = "Select max(consecutivo) from vega_sdoctor.gruposegmentacion";
/* 186:212 */       pstmt = conn.prepareStatement(sqlid);
/* 187:213 */       rs = pstmt.executeQuery();
/* 188:214 */       if ((rs != null) && (rs.next())) {
/* 189:215 */         id2 = rs.getInt(1) + 1;
/* 190:    */       } else {
/* 191:217 */         id2++;
/* 192:    */       }
/* 193:    */     }
/* 194:    */     catch (SQLException e)
/* 195:    */     {
/* 196:220 */       close(rs);
/* 197:221 */       close(pstmt);
/* 198:222 */       rollback(conn);
/* 199:223 */       e.printStackTrace();
/* 200:    */     }
/* 201:    */     finally
/* 202:    */     {
/* 203:225 */       close(rs);
/* 204:226 */       close(pstmt);
/* 205:    */     }
/* 206:228 */     return id2;
/* 207:    */   }
/* 208:    */   
/* 209:    */   public int count(String codComprador)
/* 210:    */     throws SQLException
/* 211:    */   {
/* 212:231 */     Connection conn = null;
/* 213:232 */     PreparedStatement pstmt = null;
/* 214:233 */     ResultSet rs = null;
/* 215:234 */     int counter = 0;
/* 216:    */     try
/* 217:    */     {
/* 218:236 */       conn = this.ds.getConnection();
/* 219:237 */       DBUtil db = new DBUtil();
/* 220:238 */       String sql = "Select consecutivo,cod_usuario,nombre_grupo,afiliado,orden from vega_sdoctor.gruposegmentacion";
/* 221:239 */       String where = " where cod_usuario = ?";
/* 222:240 */       pstmt = conn.prepareStatement(sql + where);
/* 223:241 */       pstmt.setString(1, codComprador);
/* 224:242 */       rs = pstmt.executeQuery();
/* 225:243 */       while (rs.next()) {
/* 226:244 */         counter++;
/* 227:    */       }
/* 228:246 */       close(rs);
/* 229:247 */       close(pstmt);
/* 230:    */     }
/* 231:    */     catch (SQLException e)
/* 232:    */     {
/* 233:249 */       close(rs);
/* 234:250 */       close(pstmt);
/* 235:251 */       rollback(conn);
/* 236:252 */       throw e;
/* 237:    */     }
/* 238:    */     finally
/* 239:    */     {
/* 240:254 */       close(conn);
/* 241:    */     }
/* 242:256 */     return counter;
/* 243:    */   }
/* 244:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.seguridad.dao.GrupoSegmentacionDAO
 * JD-Core Version:    0.7.0.1
 */