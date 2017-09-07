/*   1:    */ package com.servidoctor.common.dao;
/*   2:    */ 
/*   3:    */ import java.lang.reflect.InvocationTargetException;
/*   4:    */ import java.sql.Connection;
/*   5:    */ import java.sql.PreparedStatement;
/*   6:    */ import java.sql.ResultSet;
/*   7:    */ import java.sql.ResultSetMetaData;
/*   8:    */ import java.sql.SQLException;
/*   9:    */ import java.util.HashMap;
/*  10:    */ import java.util.ResourceBundle;
/*  11:    */ import javax.naming.InitialContext;
/*  12:    */ import javax.sql.DataSource;
/*  13:    */ import org.apache.commons.beanutils.BeanUtils;
/*  14:    */ 
/*  15:    */ public class DAO
/*  16:    */ {
/*  17:    */   public static final int DUPLICATE_ENTRY_ERROR_CODE = 1062;
/*  18:    */   protected DataSource ds;
/*  19:    */   public static final String SDOCTOR = "sdoctor";
/*  20: 24 */   protected String idioma = null;
/*  21: 25 */   protected int serverNumber = 0;
/*  22:    */   
/*  23:    */   public void setIdioma(String string)
/*  24:    */   {
/*  25: 28 */     this.idioma = string.toLowerCase();
/*  26:    */   }
/*  27:    */   
/*  28:    */   public void setServerNumber(int serverNumber)
/*  29:    */   {
/*  30: 32 */     this.serverNumber = serverNumber;
/*  31: 33 */     this.ds = null;
/*  32: 34 */     this.ds = getDataSource();
/*  33:    */   }
/*  34:    */   
/*  35:    */   protected void populate(Object bean, ResultSet rs)
/*  36:    */     throws SQLException
/*  37:    */   {
/*  38: 38 */     ResultSetMetaData metaData = rs.getMetaData();
/*  39: 39 */     int ncolumns = metaData.getColumnCount();
/*  40:    */     
/*  41: 41 */     HashMap properties = new HashMap();
/*  42: 43 */     for (int i = 1; i <= ncolumns; i++) {
/*  43: 44 */       properties.put(sql2javaName(metaData.getColumnName(i)), rs.getString(i));
/*  44:    */     }
/*  45:    */     try
/*  46:    */     {
/*  47: 48 */       BeanUtils.copyProperties(bean, properties);
/*  48:    */     }
/*  49:    */     catch (InvocationTargetException ite)
/*  50:    */     {
/*  51: 50 */       ite.printStackTrace();
/*  52: 51 */       throw new SQLException("BeanUtils.populate threw " + ite.toString());
/*  53:    */     }
/*  54:    */     catch (IllegalAccessException iae)
/*  55:    */     {
/*  56: 53 */       iae.printStackTrace();
/*  57: 54 */       throw new SQLException("BeanUtils.populate threw " + iae.toString());
/*  58:    */     }
/*  59:    */   }
/*  60:    */   
/*  61:    */   public int getSize(String tableName, String condition)
/*  62:    */     throws SQLException
/*  63:    */   {
/*  64: 59 */     Connection conn = null;
/*  65: 60 */     PreparedStatement pstmt = null;
/*  66: 61 */     ResultSet rs = null;
/*  67:    */     try
/*  68:    */     {
/*  69: 63 */       String sql = "SELECT count(*) FROM " + tableName + " " + condition;
/*  70: 64 */       conn = this.ds.getConnection();
/*  71: 65 */       pstmt = conn.prepareStatement(sql);
/*  72: 66 */       rs = pstmt.executeQuery();
/*  73: 67 */       rs.next();
/*  74: 68 */       int size = rs.getInt(1);
/*  75: 69 */       close(rs);
/*  76: 70 */       close(pstmt);
/*  77: 71 */       return size;
/*  78:    */     }
/*  79:    */     catch (SQLException sqle)
/*  80:    */     {
/*  81: 73 */       close(rs);
/*  82: 74 */       close(pstmt);
/*  83: 75 */       rollback(conn);
/*  84: 76 */       sqle.printStackTrace();
/*  85: 77 */       throw sqle;
/*  86:    */     }
/*  87:    */     finally
/*  88:    */     {
/*  89: 79 */       close(conn);
/*  90:    */     }
/*  91:    */   }
/*  92:    */   
/*  93:    */   public DAO()
/*  94:    */   {
/*  95: 84 */     this.ds = getDataSource();
/*  96:    */   }
/*  97:    */   
/*  98:    */   public DAO(String jndiName)
/*  99:    */   {
/* 100: 88 */     this.ds = getDataSource(jndiName);
/* 101:    */   }
/* 102:    */   
/* 103:    */   public void setDataSource(DataSource ds)
/* 104:    */   {
/* 105: 92 */     this.ds = ds;
/* 106:    */   }
/* 107:    */   
/* 108:    */   protected void close(ResultSet rs)
/* 109:    */   {
/* 110: 96 */     if (rs != null)
/* 111:    */     {
/* 112:    */       try
/* 113:    */       {
/* 114: 98 */         rs.close();
/* 115:    */       }
/* 116:    */       catch (SQLException e)
/* 117:    */       {
/* 118:100 */         e.printStackTrace();
/* 119:    */       }
/* 120:102 */       rs = null;
/* 121:    */     }
/* 122:    */   }
/* 123:    */   
/* 124:    */   protected void close(PreparedStatement pstmt)
/* 125:    */   {
/* 126:107 */     if (pstmt != null)
/* 127:    */     {
/* 128:    */       try
/* 129:    */       {
/* 130:109 */         pstmt.close();
/* 131:    */       }
/* 132:    */       catch (SQLException e)
/* 133:    */       {
/* 134:111 */         e.printStackTrace();
/* 135:    */       }
/* 136:113 */       pstmt = null;
/* 137:    */     }
/* 138:    */   }
/* 139:    */   
/* 140:    */   protected void close(Connection conn)
/* 141:    */   {
/* 142:118 */     if (conn != null)
/* 143:    */     {
/* 144:    */       try
/* 145:    */       {
/* 146:120 */         conn.close();
/* 147:    */       }
/* 148:    */       catch (SQLException e)
/* 149:    */       {
/* 150:122 */         e.printStackTrace();
/* 151:    */       }
/* 152:124 */       conn = null;
/* 153:    */     }
/* 154:    */   }
/* 155:    */   
/* 156:    */   protected void rollback(Connection conn)
/* 157:    */   {
/* 158:129 */     if (conn != null)
/* 159:    */     {
/* 160:    */       try
/* 161:    */       {
/* 162:131 */         conn.rollback();
/* 163:    */       }
/* 164:    */       catch (SQLException e)
/* 165:    */       {
/* 166:133 */         e.printStackTrace();
/* 167:    */       }
/* 168:135 */       conn = null;
/* 169:    */     }
/* 170:    */   }
/* 171:    */   
/* 172:    */   protected static String java2sqlName(String name)
/* 173:    */   {
/* 174:140 */     String column = "";
/* 175:141 */     for (int i = 0; i < name.length(); i++) {
/* 176:142 */       if ((i < name.length() - 1) && (name.charAt(i) >= 'a') && (name.charAt(i) <= 'z') && (name.charAt(i + 1) >= 'A') && (name.charAt(i + 1) <= 'Z')) {
/* 177:143 */         column = column + name.charAt(i) + "_";
/* 178:    */       } else {
/* 179:145 */         column = column + name.charAt(i);
/* 180:    */       }
/* 181:    */     }
/* 182:148 */     return column.toLowerCase();
/* 183:    */   }
/* 184:    */   
/* 185:    */   protected static String sql2javaName(String name)
/* 186:    */   {
/* 187:152 */     String column = "";
/* 188:153 */     for (int i = 0; i < name.length(); i++) {
/* 189:157 */       column = column + name.charAt(i);
/* 190:    */     }
/* 191:160 */     return column;
/* 192:    */   }
/* 193:    */   
/* 194:    */   private DataSource getDataSource()
/* 195:    */   {
/* 196:164 */     ResourceBundle prop = ResourceBundle.getBundle("com.servidoctor.resources.Config");
/* 197:165 */     if (this.serverNumber == 0) {
/* 198:166 */       return getDataSource(prop.getString("jndi.name"));
/* 199:    */     }
/* 200:168 */     return getDataSource(prop.getString("jndi.serverXX.name") + this.serverNumber);
/* 201:    */   }
/* 202:    */   
/* 203:    */   private DataSource getDataSource(String jndiName)
/* 204:    */   {
/* 205:173 */     if (this.ds == null) {
/* 206:    */       try
/* 207:    */       {
/* 208:175 */         InitialContext contex = new InitialContext();
/* 209:176 */         this.ds = ((DataSource)contex.lookup(jndiName));
/* 210:    */       }
/* 211:    */       catch (Exception e)
/* 212:    */       {
/* 213:178 */         e.printStackTrace();
/* 214:    */       }
/* 215:    */     }
/* 216:181 */     return this.ds;
/* 217:    */   }
/* 218:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.common.dao.DAO
 * JD-Core Version:    0.7.0.1
 */