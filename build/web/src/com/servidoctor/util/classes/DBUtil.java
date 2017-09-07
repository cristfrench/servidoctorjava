/*   1:    */ package com.servidoctor.util.classes;
/*   2:    */ 
/*   3:    */ import java.io.PrintStream;
/*   4:    */ import java.io.Serializable;
/*   5:    */ import java.lang.reflect.Method;
/*   6:    */ import java.math.BigDecimal;
/*   7:    */ import java.sql.Connection;
/*   8:    */ import java.sql.PreparedStatement;
/*   9:    */ import java.sql.ResultSet;
/*  10:    */ import java.sql.ResultSetMetaData;
/*  11:    */ import java.sql.SQLException;
/*  12:    */ import java.util.HashMap;
/*  13:    */ 
/*  14:    */ public class DBUtil
/*  15:    */   implements Serializable
/*  16:    */ {
/*  17:    */   protected String schema;
/*  18:    */   
/*  19:    */   public DBUtil()
/*  20:    */   {
/*  21: 22 */     this.schema = "sdoctor";
/*  22:    */   }
/*  23:    */   
/*  24:    */   public DBUtil(String schema)
/*  25:    */   {
/*  26: 26 */     this.schema = schema;
/*  27:    */   }
/*  28:    */   
/*  29:    */   public void setIdioma(String idioma)
/*  30:    */   {
/*  31: 30 */     this.schema = (this.schema.substring(0, "sdoctor".length()) + "_" + idioma.substring(0, 2).toLowerCase());
/*  32:    */   }
/*  33:    */   
/*  34:    */   public void resetIdioma()
/*  35:    */   {
/*  36: 34 */     this.schema = this.schema.substring(0, "sdoctor".length());
/*  37:    */   }
/*  38:    */   
/*  39:    */   /* Error */
/*  40:    */   public void insertSQL(String DBName, Object registro, String dsName)
/*  41:    */     throws Exception
/*  42:    */   {
/*  43:    */     // Byte code:
/*  44:    */     //   0: aconst_null
/*  45:    */     //   1: astore 4
/*  46:    */     //   3: aconst_null
/*  47:    */     //   4: astore 5
/*  48:    */     //   6: aconst_null
/*  49:    */     //   7: astore 6
/*  50:    */     //   9: new 1	com/servidoctor/util/classes/DBUtil
/*  51:    */     //   12: dup
/*  52:    */     //   13: invokespecial 62	com/servidoctor/util/classes/DBUtil:<init>	()V
/*  53:    */     //   16: astore 7
/*  54:    */     //   18: new 63	javax/naming/InitialContext
/*  55:    */     //   21: dup
/*  56:    */     //   22: invokespecial 65	javax/naming/InitialContext:<init>	()V
/*  57:    */     //   25: astore 8
/*  58:    */     //   27: aload 8
/*  59:    */     //   29: aload_3
/*  60:    */     //   30: invokevirtual 66	javax/naming/InitialContext:lookup	(Ljava/lang/String;)Ljava/lang/Object;
/*  61:    */     //   33: checkcast 70	javax/sql/DataSource
/*  62:    */     //   36: astore 6
/*  63:    */     //   38: aload 6
/*  64:    */     //   40: invokeinterface 72 1 0
/*  65:    */     //   45: astore 4
/*  66:    */     //   47: aload 4
/*  67:    */     //   49: aload 7
/*  68:    */     //   51: aload_2
/*  69:    */     //   52: invokevirtual 76	com/servidoctor/util/classes/DBUtil:creaSQLINSERT	(Ljava/lang/Object;)Ljava/lang/String;
/*  70:    */     //   55: invokeinterface 79 2 0
/*  71:    */     //   60: astore 5
/*  72:    */     //   62: aload 5
/*  73:    */     //   64: invokeinterface 85 1 0
/*  74:    */     //   69: istore 9
/*  75:    */     //   71: iload 9
/*  76:    */     //   73: ifne +57 -> 130
/*  77:    */     //   76: new 60	java/lang/Exception
/*  78:    */     //   79: dup
/*  79:    */     //   80: new 24	java/lang/StringBuilder
/*  80:    */     //   83: dup
/*  81:    */     //   84: ldc 90
/*  82:    */     //   86: invokespecial 40	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
/*  83:    */     //   89: aload 7
/*  84:    */     //   91: aload_2
/*  85:    */     //   92: invokevirtual 92	java/lang/Object:getClass	()Ljava/lang/Class;
/*  86:    */     //   95: invokespecial 96	com/servidoctor/util/classes/DBUtil:getTabla	(Ljava/lang/Class;)Ljava/lang/String;
/*  87:    */     //   98: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*  88:    */     //   101: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*  89:    */     //   104: invokespecial 100	java/lang/Exception:<init>	(Ljava/lang/String;)V
/*  90:    */     //   107: athrow
/*  91:    */     //   108: astore 8
/*  92:    */     //   110: aload 8
/*  93:    */     //   112: athrow
/*  94:    */     //   113: astore 10
/*  95:    */     //   115: aload_0
/*  96:    */     //   116: aload 5
/*  97:    */     //   118: invokevirtual 101	com/servidoctor/util/classes/DBUtil:close	(Ljava/sql/PreparedStatement;)V
/*  98:    */     //   121: aload_0
/*  99:    */     //   122: aload 4
/* 100:    */     //   124: invokevirtual 105	com/servidoctor/util/classes/DBUtil:close	(Ljava/sql/Connection;)V
/* 101:    */     //   127: aload 10
/* 102:    */     //   129: athrow
/* 103:    */     //   130: aload_0
/* 104:    */     //   131: aload 5
/* 105:    */     //   133: invokevirtual 101	com/servidoctor/util/classes/DBUtil:close	(Ljava/sql/PreparedStatement;)V
/* 106:    */     //   136: aload_0
/* 107:    */     //   137: aload 4
/* 108:    */     //   139: invokevirtual 105	com/servidoctor/util/classes/DBUtil:close	(Ljava/sql/Connection;)V
/* 109:    */     //   142: return
/* 110:    */     // Line number table:
/* 111:    */     //   Java source line #39	-> byte code offset #0
/* 112:    */     //   Java source line #40	-> byte code offset #3
/* 113:    */     //   Java source line #41	-> byte code offset #6
/* 114:    */     //   Java source line #42	-> byte code offset #9
/* 115:    */     //   Java source line #45	-> byte code offset #18
/* 116:    */     //   Java source line #46	-> byte code offset #27
/* 117:    */     //   Java source line #47	-> byte code offset #38
/* 118:    */     //   Java source line #48	-> byte code offset #47
/* 119:    */     //   Java source line #49	-> byte code offset #62
/* 120:    */     //   Java source line #50	-> byte code offset #71
/* 121:    */     //   Java source line #51	-> byte code offset #76
/* 122:    */     //   Java source line #54	-> byte code offset #108
/* 123:    */     //   Java source line #55	-> byte code offset #110
/* 124:    */     //   Java source line #56	-> byte code offset #113
/* 125:    */     //   Java source line #57	-> byte code offset #115
/* 126:    */     //   Java source line #58	-> byte code offset #121
/* 127:    */     //   Java source line #59	-> byte code offset #127
/* 128:    */     //   Java source line #57	-> byte code offset #130
/* 129:    */     //   Java source line #58	-> byte code offset #136
/* 130:    */     //   Java source line #61	-> byte code offset #142
/* 131:    */     // Local variable table:
/* 132:    */     //   start	length	slot	name	signature
/* 133:    */     //   0	143	0	this	DBUtil
/* 134:    */     //   0	143	1	DBName	String
/* 135:    */     //   0	143	2	registro	Object
/* 136:    */     //   0	143	3	dsName	String
/* 137:    */     //   1	137	4	conn	Connection
/* 138:    */     //   4	128	5	pstmt	PreparedStatement
/* 139:    */     //   7	32	6	ds	javax.sql.DataSource
/* 140:    */     //   16	74	7	util	DBUtil
/* 141:    */     //   25	3	8	initCxt	javax.naming.InitialContext
/* 142:    */     //   108	3	8	ex	Exception
/* 143:    */     //   69	3	9	i	int
/* 144:    */     //   113	15	10	localObject	Object
/* 145:    */     // Exception table:
/* 146:    */     //   from	to	target	type
/* 147:    */     //   18	108	108	java/lang/Exception
/* 148:    */     //   18	113	113	finally
/* 149:    */   }
/* 150:    */   
/* 151:    */   /* Error */
/* 152:    */   public void updateSQL(String DBName, Object registro, String dsName, String whereSQL, String[] llaves)
/* 153:    */     throws Exception
/* 154:    */   {
/* 155:    */     // Byte code:
/* 156:    */     //   0: aconst_null
/* 157:    */     //   1: astore 6
/* 158:    */     //   3: aconst_null
/* 159:    */     //   4: astore 7
/* 160:    */     //   6: aconst_null
/* 161:    */     //   7: astore 8
/* 162:    */     //   9: new 1	com/servidoctor/util/classes/DBUtil
/* 163:    */     //   12: dup
/* 164:    */     //   13: invokespecial 62	com/servidoctor/util/classes/DBUtil:<init>	()V
/* 165:    */     //   16: astore 9
/* 166:    */     //   18: new 63	javax/naming/InitialContext
/* 167:    */     //   21: dup
/* 168:    */     //   22: invokespecial 65	javax/naming/InitialContext:<init>	()V
/* 169:    */     //   25: astore 10
/* 170:    */     //   27: aload 10
/* 171:    */     //   29: aload_3
/* 172:    */     //   30: invokevirtual 66	javax/naming/InitialContext:lookup	(Ljava/lang/String;)Ljava/lang/Object;
/* 173:    */     //   33: checkcast 70	javax/sql/DataSource
/* 174:    */     //   36: astore 8
/* 175:    */     //   38: aload 8
/* 176:    */     //   40: invokeinterface 72 1 0
/* 177:    */     //   45: astore 6
/* 178:    */     //   47: aload 6
/* 179:    */     //   49: new 24	java/lang/StringBuilder
/* 180:    */     //   52: dup
/* 181:    */     //   53: aload 9
/* 182:    */     //   55: aload_2
/* 183:    */     //   56: aload 5
/* 184:    */     //   58: invokevirtual 127	com/servidoctor/util/classes/DBUtil:creaSQLUPDATE	(Ljava/lang/Object;[Ljava/lang/String;)Ljava/lang/String;
/* 185:    */     //   61: invokestatic 36	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
/* 186:    */     //   64: invokespecial 40	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
/* 187:    */     //   67: aload 4
/* 188:    */     //   69: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/* 189:    */     //   72: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
/* 190:    */     //   75: invokeinterface 79 2 0
/* 191:    */     //   80: astore 7
/* 192:    */     //   82: aload 7
/* 193:    */     //   84: invokeinterface 85 1 0
/* 194:    */     //   89: istore 11
/* 195:    */     //   91: iload 11
/* 196:    */     //   93: ifne +57 -> 150
/* 197:    */     //   96: new 60	java/lang/Exception
/* 198:    */     //   99: dup
/* 199:    */     //   100: new 24	java/lang/StringBuilder
/* 200:    */     //   103: dup
/* 201:    */     //   104: ldc 131
/* 202:    */     //   106: invokespecial 40	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
/* 203:    */     //   109: aload 9
/* 204:    */     //   111: aload_2
/* 205:    */     //   112: invokevirtual 92	java/lang/Object:getClass	()Ljava/lang/Class;
/* 206:    */     //   115: invokespecial 96	com/servidoctor/util/classes/DBUtil:getTabla	(Ljava/lang/Class;)Ljava/lang/String;
/* 207:    */     //   118: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/* 208:    */     //   121: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
/* 209:    */     //   124: invokespecial 100	java/lang/Exception:<init>	(Ljava/lang/String;)V
/* 210:    */     //   127: athrow
/* 211:    */     //   128: astore 10
/* 212:    */     //   130: aload 10
/* 213:    */     //   132: athrow
/* 214:    */     //   133: astore 12
/* 215:    */     //   135: aload_0
/* 216:    */     //   136: aload 7
/* 217:    */     //   138: invokevirtual 101	com/servidoctor/util/classes/DBUtil:close	(Ljava/sql/PreparedStatement;)V
/* 218:    */     //   141: aload_0
/* 219:    */     //   142: aload 6
/* 220:    */     //   144: invokevirtual 105	com/servidoctor/util/classes/DBUtil:close	(Ljava/sql/Connection;)V
/* 221:    */     //   147: aload 12
/* 222:    */     //   149: athrow
/* 223:    */     //   150: aload_0
/* 224:    */     //   151: aload 7
/* 225:    */     //   153: invokevirtual 101	com/servidoctor/util/classes/DBUtil:close	(Ljava/sql/PreparedStatement;)V
/* 226:    */     //   156: aload_0
/* 227:    */     //   157: aload 6
/* 228:    */     //   159: invokevirtual 105	com/servidoctor/util/classes/DBUtil:close	(Ljava/sql/Connection;)V
/* 229:    */     //   162: return
/* 230:    */     // Line number table:
/* 231:    */     //   Java source line #65	-> byte code offset #0
/* 232:    */     //   Java source line #66	-> byte code offset #3
/* 233:    */     //   Java source line #67	-> byte code offset #6
/* 234:    */     //   Java source line #68	-> byte code offset #9
/* 235:    */     //   Java source line #71	-> byte code offset #18
/* 236:    */     //   Java source line #72	-> byte code offset #27
/* 237:    */     //   Java source line #73	-> byte code offset #38
/* 238:    */     //   Java source line #74	-> byte code offset #47
/* 239:    */     //   Java source line #75	-> byte code offset #82
/* 240:    */     //   Java source line #76	-> byte code offset #91
/* 241:    */     //   Java source line #77	-> byte code offset #96
/* 242:    */     //   Java source line #80	-> byte code offset #128
/* 243:    */     //   Java source line #81	-> byte code offset #130
/* 244:    */     //   Java source line #82	-> byte code offset #133
/* 245:    */     //   Java source line #83	-> byte code offset #135
/* 246:    */     //   Java source line #84	-> byte code offset #141
/* 247:    */     //   Java source line #85	-> byte code offset #147
/* 248:    */     //   Java source line #83	-> byte code offset #150
/* 249:    */     //   Java source line #84	-> byte code offset #156
/* 250:    */     //   Java source line #86	-> byte code offset #162
/* 251:    */     // Local variable table:
/* 252:    */     //   start	length	slot	name	signature
/* 253:    */     //   0	163	0	this	DBUtil
/* 254:    */     //   0	163	1	DBName	String
/* 255:    */     //   0	163	2	registro	Object
/* 256:    */     //   0	163	3	dsName	String
/* 257:    */     //   0	163	4	whereSQL	String
/* 258:    */     //   0	163	5	llaves	String[]
/* 259:    */     //   1	157	6	conn	Connection
/* 260:    */     //   4	148	7	pstmt	PreparedStatement
/* 261:    */     //   7	32	8	ds	javax.sql.DataSource
/* 262:    */     //   16	94	9	util	DBUtil
/* 263:    */     //   25	3	10	initCxt	javax.naming.InitialContext
/* 264:    */     //   128	3	10	ex	Exception
/* 265:    */     //   89	3	11	i	int
/* 266:    */     //   133	15	12	localObject	Object
/* 267:    */     // Exception table:
/* 268:    */     //   from	to	target	type
/* 269:    */     //   18	128	128	java/lang/Exception
/* 270:    */     //   18	133	133	finally
/* 271:    */   }
/* 272:    */   
/* 273:    */   public void inicializa(Class clase, Object objeto)
/* 274:    */   {
/* 275: 90 */     Method[] m = clase.getDeclaredMethods();
/* 276:    */     try
/* 277:    */     {
/* 278: 93 */       for (int i = 0; i < m.length; i++) {
/* 279: 94 */         if (m[i].getName().substring(0, 3).equals("set"))
/* 280:    */         {
/* 281: 95 */           Class[] parametros = m[i].getParameterTypes();
/* 282: 96 */           if (parametros[0].getName().equals("java.math.BigDecimal"))
/* 283:    */           {
/* 284: 97 */             Object[] param = new Object[1];
/* 285: 98 */             param[0] = new BigDecimal(0);
/* 286: 99 */             m[i].invoke(objeto, param);
/* 287:    */           }
/* 288:100 */           else if (parametros[0].getName().equals("java.lang.String"))
/* 289:    */           {
/* 290:101 */             Object[] param = new Object[1];
/* 291:102 */             param[0] = new String("");
/* 292:103 */             m[i].invoke(objeto, param);
/* 293:    */           }
/* 294:    */         }
/* 295:    */       }
/* 296:    */     }
/* 297:    */     catch (Throwable localThrowable) {}
/* 298:    */   }
/* 299:    */   
/* 300:    */   public void inicializa(Object objeto)
/* 301:    */   {
/* 302:112 */     Class clase = objeto.getClass();
/* 303:113 */     Method[] m = clase.getDeclaredMethods();
/* 304:    */     try
/* 305:    */     {
/* 306:116 */       for (int i = 0; i < m.length; i++) {
/* 307:117 */         if (m[i].getName().substring(0, 3).equals("set"))
/* 308:    */         {
/* 309:118 */           Class[] parametros = m[i].getParameterTypes();
/* 310:119 */           if (parametros[0].getName().equals("java.math.BigDecimal"))
/* 311:    */           {
/* 312:120 */             Object[] param = new Object[1];
/* 313:121 */             param[0] = new BigDecimal(0);
/* 314:122 */             m[i].invoke(objeto, param);
/* 315:    */           }
/* 316:123 */           else if (parametros[0].getName().equals("java.lang.String"))
/* 317:    */           {
/* 318:124 */             Object[] param = new Object[1];
/* 319:125 */             param[0] = new String("");
/* 320:126 */             m[i].invoke(objeto, param);
/* 321:    */           }
/* 322:    */         }
/* 323:    */       }
/* 324:    */     }
/* 325:    */     catch (Throwable localThrowable) {}
/* 326:    */   }
/* 327:    */   
/* 328:    */   public String creaSQLUPDATE(Object objeto, String[] llaves)
/* 329:    */   {
/* 330:136 */     Class clase = objeto.getClass();
/* 331:137 */     Method[] m = clase.getDeclaredMethods();
/* 332:    */     
/* 333:139 */     StringBuffer update = new StringBuffer("UPDATE " + this.schema + "." + getTabla(clase) + " SET ");
/* 334:140 */     StringBuffer where = new StringBuffer(" WHERE  ");
/* 335:141 */     boolean isLlave = false;
/* 336:142 */     int cont = 0;
/* 337:    */     try
/* 338:    */     {
/* 339:144 */       for (int i = 0; i < m.length; i++)
/* 340:    */       {
/* 341:145 */         isLlave = false;
/* 342:146 */         for (int j = 0; j < llaves.length; j++) {
/* 343:147 */           if ((m[i].getName().substring(0, 3).equals("get")) && (m[i].getName().substring(3).toLowerCase().equals(llaves[j].trim().toLowerCase())))
/* 344:    */           {
/* 345:148 */             isLlave = true;
/* 346:149 */             if (cont == 0) {
/* 347:150 */               where.append(m[i].getName().substring(3).toLowerCase() + " = ");
/* 348:    */             } else {
/* 349:152 */               where.append(" and " + m[i].getName().substring(3).toLowerCase() + " = ");
/* 350:    */             }
/* 351:154 */             cont++;
/* 352:    */           }
/* 353:    */         }
/* 354:158 */         if ((m[i].getName().substring(0, 3).equals("get")) && (!m[i].getName().substring(0, 5).equals("getIs")) && (!m[i].getName().substring(0, 5).equals("getLl")) && (!m[i].getName().substring(0, 5).equals("getll")) && (!m[i].getName().equals("getElementoTabla")) && (m[i].getName().indexOf("clave") == -1) && (m[i].getName().indexOf("usuario") == -1) && (m[i].getName().indexOf("licencia") == -1) && (m[i].getName().indexOf("logm_cod") == -1))
/* 355:    */         {
/* 356:159 */           if (!isLlave) {
/* 357:160 */             update.append(m[i].getName().substring(3).toLowerCase() + " = ");
/* 358:    */           }
/* 359:162 */           Class retorno = m[i].getReturnType();
/* 360:163 */           if (retorno.getName().equals("java.math.BigDecimal"))
/* 361:    */           {
/* 362:164 */             Object[] param = new Object[0];
/* 363:165 */             BigDecimal numero = (BigDecimal)m[i].invoke(objeto, param);
/* 364:166 */             if (!isLlave) {
/* 365:167 */               update.append(numero.toString() + ", ");
/* 366:    */             } else {
/* 367:169 */               where.append(numero.toString() + " ");
/* 368:    */             }
/* 369:    */           }
/* 370:171 */           else if (retorno.getName().equals("java.lang.String"))
/* 371:    */           {
/* 372:172 */             Object[] param = new Object[0];
/* 373:173 */             String texto = (String)m[i].invoke(objeto, param);
/* 374:174 */             if (!isLlave) {
/* 375:175 */               update.append("'" + texto + "' , ");
/* 376:    */             } else {
/* 377:177 */               where.append("'" + texto + "' ");
/* 378:    */             }
/* 379:    */           }
/* 380:179 */           else if (retorno.getName().equals("int"))
/* 381:    */           {
/* 382:180 */             Object[] param = new Object[0];
/* 383:181 */             Integer numint = (Integer)m[i].invoke(objeto, param);
/* 384:182 */             if (!isLlave) {
/* 385:183 */               update.append(numint.intValue() + " , ");
/* 386:    */             } else {
/* 387:185 */               where.append(numint.intValue() + " ");
/* 388:    */             }
/* 389:    */           }
/* 390:187 */           else if (retorno.getName().equals("double"))
/* 391:    */           {
/* 392:188 */             Object[] param = new Object[0];
/* 393:189 */             Double numdou = (Double)m[i].invoke(objeto, param);
/* 394:190 */             if (!isLlave) {
/* 395:191 */               update.append(numdou.doubleValue() + " , ");
/* 396:    */             } else {
/* 397:193 */               where.append(numdou.doubleValue() + " ");
/* 398:    */             }
/* 399:    */           }
/* 400:195 */           else if (retorno.getName().equals("long"))
/* 401:    */           {
/* 402:196 */             Object[] param = new Object[0];
/* 403:197 */             Long numlon = (Long)m[i].invoke(objeto, param);
/* 404:198 */             if (!isLlave) {
/* 405:199 */               update.append(numlon.longValue() + " , ");
/* 406:    */             } else {
/* 407:201 */               where.append(numlon.longValue() + " ");
/* 408:    */             }
/* 409:    */           }
/* 410:    */         }
/* 411:    */       }
/* 412:    */     }
/* 413:    */     catch (Exception e)
/* 414:    */     {
/* 415:207 */       e.printStackTrace();
/* 416:    */     }
/* 417:209 */     return update.toString().substring(0, update.toString().lastIndexOf(",")) + where.toString();
/* 418:    */   }
/* 419:    */   
/* 420:    */   public String creaSQLINSERT(Object objeto)
/* 421:    */   {
/* 422:213 */     Class clase = objeto.getClass();
/* 423:214 */     Method[] m = clase.getDeclaredMethods();
/* 424:    */     
/* 425:216 */     StringBuffer insert = new StringBuffer("INSERT INTO " + this.schema + "." + getTabla(clase) + "(");
/* 426:217 */     StringBuffer values = new StringBuffer("VALUES(");
/* 427:    */     try
/* 428:    */     {
/* 429:219 */       for (int i = 0; i < m.length; i++) {
/* 430:220 */         if ((m[i].getName().substring(0, 3).equals("get")) && (!m[i].getName().substring(0, 5).equals("getIs")) && (!m[i].getName().substring(0, 5).equals("getLl")) && (!m[i].getName().substring(0, 5).equals("getll")) && (!m[i].getName().equals("getElementoTabla")))
/* 431:    */         {
/* 432:221 */           insert.append(m[i].getName().substring(3).toLowerCase() + ", ");
/* 433:222 */           Class retorno = m[i].getReturnType();
/* 434:223 */           if (retorno.getName().equals("java.math.BigDecimal"))
/* 435:    */           {
/* 436:224 */             Object[] param = new Object[0];
/* 437:225 */             BigDecimal numero = (BigDecimal)m[i].invoke(objeto, param);
/* 438:226 */             values.append(numero.toString() + ", ");
/* 439:    */           }
/* 440:227 */           else if (retorno.getName().equals("java.lang.String"))
/* 441:    */           {
/* 442:228 */             Object[] param = new Object[0];
/* 443:229 */             String texto = (String)m[i].invoke(objeto, param);
/* 444:230 */             values.append("'" + texto + "' , ");
/* 445:    */           }
/* 446:231 */           else if (retorno.getName().equals("int"))
/* 447:    */           {
/* 448:232 */             Object[] param = new Object[0];
/* 449:233 */             Integer numint = (Integer)m[i].invoke(objeto, param);
/* 450:    */             
/* 451:    */ 
/* 452:    */ 
/* 453:237 */             values.append(numint.intValue() + " , ");
/* 454:    */           }
/* 455:239 */           else if (retorno.getName().equals("double"))
/* 456:    */           {
/* 457:240 */             Object[] param = new Object[0];
/* 458:241 */             Double numdou = (Double)m[i].invoke(objeto, param);
/* 459:242 */             values.append(numdou.doubleValue() + " , ");
/* 460:    */           }
/* 461:243 */           else if (retorno.getName().equals("long"))
/* 462:    */           {
/* 463:244 */             Object[] param = new Object[0];
/* 464:245 */             Long numlon = (Long)m[i].invoke(objeto, param);
/* 465:    */             
/* 466:    */ 
/* 467:    */ 
/* 468:249 */             values.append(numlon.longValue() + " , ");
/* 469:    */           }
/* 470:    */         }
/* 471:    */       }
/* 472:    */     }
/* 473:    */     catch (Exception localException) {}
/* 474:257 */     return insert.toString().substring(0, insert.toString().lastIndexOf(",")) + ") " + values.toString().substring(0, values.toString().lastIndexOf(",")) + ")";
/* 475:    */   }
/* 476:    */   
/* 477:    */   public String creaSQLSELECT(Object objeto)
/* 478:    */   {
/* 479:262 */     Class clase = objeto.getClass();
/* 480:263 */     Method[] m = clase.getDeclaredMethods();
/* 481:    */     
/* 482:265 */     StringBuffer select = new StringBuffer("SELECT ");
/* 483:266 */     StringBuffer from = new StringBuffer(" FROM " + this.schema + "." + getTabla(clase));
/* 484:    */     try
/* 485:    */     {
/* 486:268 */       for (int i = 0; i < m.length; i++) {
/* 487:269 */         if ((m[i].getName().substring(0, 3).equals("get")) && (!m[i].getName().substring(0, 5).equals("getIs")) && (!m[i].getName().substring(0, 5).equals("getLl")) && (!m[i].getName().substring(0, 5).equals("getll")) && (!m[i].getName().equals("getElementoTabla"))) {
/* 488:271 */           select.append(m[i].getName().substring(3).toLowerCase() + ", ");
/* 489:    */         }
/* 490:    */       }
/* 491:    */     }
/* 492:    */     catch (Exception localException) {}
/* 493:276 */     return select.toString().substring(0, select.toString().lastIndexOf(",")) + from.toString();
/* 494:    */   }
/* 495:    */   
/* 496:    */   public String creaSQLSELECT2(Object objeto)
/* 497:    */   {
/* 498:281 */     Class clase = objeto.getClass();
/* 499:282 */     Method[] m = clase.getDeclaredMethods();
/* 500:    */     
/* 501:284 */     StringBuffer select = new StringBuffer("SELECT ");
/* 502:285 */     StringBuffer from = new StringBuffer(" FROM " + this.schema + "." + getTabla(clase));
/* 503:    */     try
/* 504:    */     {
/* 505:287 */       for (int i = 0; i < m.length; i++) {
/* 506:288 */         if ((m[i].getName().substring(0, 3).equals("get")) && (!m[i].getName().substring(0, 5).equals("getIs")) && (!m[i].getName().substring(0, 5).equals("getLl")) && (!m[i].getName().substring(0, 5).equals("getll")) && (!m[i].getName().equals("getElementoTabla"))) {
/* 507:290 */           select.append(m[i].getName().substring(3).toLowerCase() + ", ");
/* 508:    */         }
/* 509:    */       }
/* 510:    */     }
/* 511:    */     catch (Exception localException) {}
/* 512:295 */     return select.toString().substring(0, select.toString().lastIndexOf(",")) + "AS SERVIDOR" + from.toString();
/* 513:    */   }
/* 514:    */   
/* 515:    */   private String getTabla(Class clase)
/* 516:    */   {
/* 517:299 */     String nombreData = clase.getName();
/* 518:300 */     return nombreData.toLowerCase().substring(nombreData.lastIndexOf(".") + 1);
/* 519:    */   }
/* 520:    */   
/* 521:    */   public void close(ResultSet rs)
/* 522:    */   {
/* 523:304 */     if (rs != null)
/* 524:    */     {
/* 525:    */       try
/* 526:    */       {
/* 527:306 */         rs.close();
/* 528:    */       }
/* 529:    */       catch (SQLException localSQLException) {}
/* 530:309 */       rs = null;
/* 531:    */     }
/* 532:    */   }
/* 533:    */   
/* 534:    */   public void close(PreparedStatement pstmt)
/* 535:    */   {
/* 536:314 */     if (pstmt != null)
/* 537:    */     {
/* 538:    */       try
/* 539:    */       {
/* 540:316 */         pstmt.close();
/* 541:    */       }
/* 542:    */       catch (SQLException localSQLException) {}
/* 543:319 */       pstmt = null;
/* 544:    */     }
/* 545:    */   }
/* 546:    */   
/* 547:    */   public void close(Connection conn)
/* 548:    */   {
/* 549:324 */     if (conn != null)
/* 550:    */     {
/* 551:    */       try
/* 552:    */       {
/* 553:326 */         conn.close();
/* 554:    */       }
/* 555:    */       catch (SQLException e)
/* 556:    */       {
/* 557:328 */         e.printStackTrace();
/* 558:    */       }
/* 559:330 */       conn = null;
/* 560:    */     }
/* 561:    */   }
/* 562:    */   
/* 563:    */   public void populate(Object bean, ResultSet rs)
/* 564:    */     throws SQLException
/* 565:    */   {
/* 566:336 */     Class clase = bean.getClass();
/* 567:337 */     Method[] m = clase.getDeclaredMethods();
/* 568:338 */     ResultSetMetaData metaData = rs.getMetaData();
/* 569:339 */     int ncolumns = metaData.getColumnCount();
/* 570:    */     
/* 571:341 */     HashMap properties = new HashMap();
/* 572:    */     try
/* 573:    */     {
/* 574:344 */       for (int i = 1; i <= ncolumns; i++) {
/* 575:346 */         properties.put(metaData.getColumnName(i).toLowerCase(), rs.getString(i));
/* 576:    */       }
/* 577:350 */       for (int i = 0; i < m.length; i++) {
/* 578:351 */         if (m[i].getName().substring(0, 3).equals("set"))
/* 579:    */         {
/* 580:352 */           Class[] parametros = m[i].getParameterTypes();
/* 581:353 */           String obje = (String)properties.get(m[i].getName().substring(3, m[i].getName().length()).toLowerCase());
/* 582:354 */           if (parametros[0].getName().equals("java.math.BigDecimal"))
/* 583:    */           {
/* 584:355 */             Object[] param = new Object[1];
/* 585:356 */             if (obje != null) {
/* 586:357 */               param[0] = new BigDecimal(obje);
/* 587:    */             } else {
/* 588:359 */               param[0] = new BigDecimal(0);
/* 589:    */             }
/* 590:361 */             m[i].invoke(bean, param);
/* 591:    */           }
/* 592:362 */           else if (parametros[0].getName().equals("java.lang.String"))
/* 593:    */           {
/* 594:363 */             Object[] param = new Object[1];
/* 595:364 */             if (obje != null) {
/* 596:365 */               param[0] = obje;
/* 597:    */             } else {
/* 598:367 */               param[0] = new String("");
/* 599:    */             }
/* 600:370 */             m[i].invoke(bean, param);
/* 601:    */           }
/* 602:371 */           else if (parametros[0].getName().equals("int"))
/* 603:    */           {
/* 604:372 */             Object[] param = new Object[1];
/* 605:373 */             if (obje != null) {
/* 606:374 */               param[0] = new Integer(obje);
/* 607:    */             } else {
/* 608:376 */               param[0] = new Integer(0);
/* 609:    */             }
/* 610:379 */             m[i].invoke(bean, param);
/* 611:    */           }
/* 612:380 */           else if (parametros[0].getName().equals("double"))
/* 613:    */           {
/* 614:381 */             Object[] param = new Object[1];
/* 615:382 */             if (obje != null) {
/* 616:383 */               param[0] = new Double(obje);
/* 617:    */             } else {
/* 618:385 */               param[0] = new Double(0.0D);
/* 619:    */             }
/* 620:388 */             m[i].invoke(bean, param);
/* 621:    */           }
/* 622:389 */           else if (parametros[0].getName().equals("long"))
/* 623:    */           {
/* 624:390 */             Object[] param = new Object[1];
/* 625:391 */             if (obje != null) {
/* 626:392 */               param[0] = new Long(obje);
/* 627:    */             } else {
/* 628:394 */               param[0] = new Long(0L);
/* 629:    */             }
/* 630:397 */             m[i].invoke(bean, param);
/* 631:    */           }
/* 632:    */         }
/* 633:    */       }
/* 634:    */     }
/* 635:    */     catch (Exception e)
/* 636:    */     {
/* 637:402 */       System.out.println("Error " + e);
/* 638:403 */       throw new SQLException("El match de los campos ha fallado. " + e.toString());
/* 639:    */     }
/* 640:    */   }
/* 641:    */   
/* 642:    */   protected static String java2sqlName(String name)
/* 643:    */   {
/* 644:417 */     return name;
/* 645:    */   }
/* 646:    */   
/* 647:    */   protected static String sql2javaName(String name)
/* 648:    */   {
/* 649:430 */     return name;
/* 650:    */   }
/* 651:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.util.classes.DBUtil
 * JD-Core Version:    0.7.0.1
 */