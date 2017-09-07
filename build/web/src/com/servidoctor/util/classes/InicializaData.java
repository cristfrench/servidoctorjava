/*  1:   */ package com.servidoctor.util.classes;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import java.lang.reflect.Method;
/*  5:   */ import java.math.BigDecimal;
/*  6:   */ import java.sql.Date;
/*  7:   */ import java.sql.Timestamp;
/*  8:   */ 
/*  9:   */ public class InicializaData
/* 10:   */   implements Serializable
/* 11:   */ {
/* 12:   */   public String getTabla(Class clase)
/* 13:   */   {
/* 14: 9 */     String nombreData = clase.getName();
/* 15:10 */     return nombreData.substring(0, nombreData.indexOf("Data"));
/* 16:   */   }
/* 17:   */   
/* 18:   */   public static void inicializa(Class clase, Object objeto)
/* 19:   */   {
/* 20:16 */     Method[] m = clase.getDeclaredMethods();
/* 21:   */     try
/* 22:   */     {
/* 23:19 */       for (int i = 0; i < m.length; i++) {
/* 24:20 */         if (m[i].getName().substring(0, 3).equals("set"))
/* 25:   */         {
/* 26:21 */           Class[] parametros = m[i].getParameterTypes();
/* 27:22 */           if (parametros[0].getName().equals("java.math.BigDecimal"))
/* 28:   */           {
/* 29:23 */             Object[] param = new Object[1];
/* 30:24 */             param[0] = new BigDecimal(0);
/* 31:25 */             m[i].invoke(objeto, param);
/* 32:   */           }
/* 33:26 */           else if (parametros[0].getName().equals("java.lang.String"))
/* 34:   */           {
/* 35:27 */             Object[] param = new Object[1];
/* 36:28 */             param[0] = new String("");
/* 37:29 */             m[i].invoke(objeto, param);
/* 38:   */           }
/* 39:30 */           else if (parametros[0].getName().equals("java.sql.Timestamp"))
/* 40:   */           {
/* 41:31 */             Object[] param = new Object[1];
/* 42:32 */             param[0] = new Timestamp(0L);
/* 43:33 */             m[i].invoke(objeto, param);
/* 44:   */           }
/* 45:34 */           else if (parametros[0].getName().equals("java.sql.Date"))
/* 46:   */           {
/* 47:35 */             Object[] param = new Object[1];
/* 48:36 */             param[0] = new Date(0L);
/* 49:37 */             m[i].invoke(objeto, param);
/* 50:   */           }
/* 51:   */         }
/* 52:   */       }
/* 53:   */     }
/* 54:   */     catch (Throwable localThrowable) {}
/* 55:   */   }
/* 56:   */   
/* 57:   */   public static String creaSQLUPDATE(Class clase, Object objeto, String libreria)
/* 58:   */   {
/* 59:51 */     Method[] m = clase.getDeclaredMethods();
/* 60:   */     
/* 61:53 */     StringBuffer update = new StringBuffer("UPDATE " + libreria + ".");
/* 62:   */     try
/* 63:   */     {
/* 64:56 */       for (int i = 0; i < m.length; i++) {
/* 65:57 */         if (m[i].getName().substring(0, 3).equals("set"))
/* 66:   */         {
/* 67:59 */           Class[] parametros = m[i].getParameterTypes();
/* 68:60 */           if (parametros[0].getName().equals("java.math.BigDecimal"))
/* 69:   */           {
/* 70:61 */             Object[] param = new Object[1];
/* 71:62 */             param[0] = new BigDecimal(0);
/* 72:63 */             m[i].invoke(objeto, param);
/* 73:   */           }
/* 74:64 */           else if (parametros[0].getName().equals("java.lang.String"))
/* 75:   */           {
/* 76:65 */             Object[] param = new Object[1];
/* 77:66 */             param[0] = new String("");
/* 78:67 */             m[i].invoke(objeto, param);
/* 79:   */           }
/* 80:   */         }
/* 81:   */       }
/* 82:   */     }
/* 83:   */     catch (Throwable localThrowable) {}
/* 84:74 */     return "";
/* 85:   */   }
/* 86:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.util.classes.InicializaData
 * JD-Core Version:    0.7.0.1
 */