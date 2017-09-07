/*  1:   */ package com.essecorp.utils.struts.controller;
/*  2:   */ 
/*  3:   */ import java.io.PrintStream;
/*  4:   */ import java.sql.Timestamp;
/*  5:   */ import java.util.Enumeration;
/*  6:   */ import javax.servlet.http.Cookie;
/*  7:   */ import javax.servlet.http.HttpServletRequest;
/*  8:   */ import javax.servlet.http.HttpServletResponse;
/*  9:   */ import javax.servlet.http.HttpSession;
/* 10:   */ import org.apache.struts.tiles.TilesRequestProcessor;
/* 11:   */ 
/* 12:   */ public class CustomRequestProcessor
/* 13:   */   extends TilesRequestProcessor
/* 14:   */ {
/* 15:   */   public boolean processPreprocess(HttpServletRequest request, HttpServletResponse response)
/* 16:   */   {
/* 17:29 */     System.out.println("-----------processPreprocess Logging-------------");
/* 18:30 */     System.out.println("Hora = " + new Timestamp(System.currentTimeMillis()));
/* 19:31 */     System.out.println("Request URI = " + request.getRequestURI());
/* 20:32 */     System.out.println("Context Path = " + request.getContextPath());
/* 21:   */     
/* 22:34 */     Cookie[] cookies = request.getCookies();
/* 23:35 */     if (cookies != null) {
/* 24:36 */       for (int i = 0; i < cookies.length; i++) {
/* 25:37 */         System.out.println("Cookie = " + cookies[i].getName() + " = " + 
/* 26:38 */           cookies[i].getValue());
/* 27:   */       }
/* 28:   */     }
/* 29:42 */     Enumeration headerNames = request.getHeaderNames();
/* 30:   */     Enumeration headerValues;
/* 31:44 */     for (; headerNames.hasMoreElements(); headerValues.hasMoreElements())
/* 32:   */     {
/* 33:45 */       String headerName = (String)headerNames.nextElement();
/* 34:46 */       headerValues = request.getHeaders(headerName);
/* 35:47 */       continue;
/* 36:48 */       String headerValue = (String)headerValues.nextElement();
/* 37:49 */       System.out.println("Header = " + headerName + " = " + headerValue);
/* 38:   */     }
/* 39:53 */     Enumeration parameterNames = request.getParameterNames();
/* 40:55 */     while (parameterNames.hasMoreElements())
/* 41:   */     {
/* 42:56 */       String parameterName = (String)parameterNames.nextElement();
/* 43:57 */       String parameterValue = request.getParameter(parameterName);
/* 44:58 */       System.out.println("Parameter = " + parameterName + " = " + parameterValue);
/* 45:   */     }
/* 46:61 */     Enumeration attributeNames = request.getAttributeNames();
/* 47:63 */     while (attributeNames.hasMoreElements())
/* 48:   */     {
/* 49:64 */       String attributeName = (String)attributeNames.nextElement();
/* 50:65 */       Object attributeValue = request.getAttribute(attributeName);
/* 51:66 */       System.out.println("Attribute = " + attributeName + " = " + attributeValue);
/* 52:   */     }
/* 53:69 */     Enumeration sessionAttributeNames = request.getSession().getAttributeNames();
/* 54:71 */     while (sessionAttributeNames.hasMoreElements())
/* 55:   */     {
/* 56:72 */       String sessionAttributeName = (String)sessionAttributeNames.nextElement();
/* 57:73 */       Object sessionAttributeValue = request.getSession().getAttribute(sessionAttributeName);
/* 58:74 */       System.out.println("Session Attribute = " + sessionAttributeName + " = " + sessionAttributeValue);
/* 59:   */     }
/* 60:77 */     System.out.println("Locale = " + request.getLocale());
/* 61:78 */     System.out.println("Method = " + request.getMethod());
/* 62:79 */     System.out.println("Path Info = " + request.getPathInfo());
/* 63:80 */     System.out.println("Protocol = " + request.getProtocol());
/* 64:81 */     System.out.println("Remote Address = " + request.getRemoteAddr());
/* 65:82 */     System.out.println("Remote Host = " + request.getRemoteHost());
/* 66:83 */     System.out.println("Remote User = " + request.getRemoteUser());
/* 67:84 */     System.out.println("Requested Session Id = " + request.getRequestedSessionId());
/* 68:85 */     System.out.println("Scheme = " + request.getScheme());
/* 69:86 */     System.out.println("Server Name = " + request.getServerName());
/* 70:87 */     System.out.println("Server Port = " + request.getServerPort());
/* 71:88 */     System.out.println("Servlet Path = " + request.getServletPath());
/* 72:89 */     System.out.println("Secure = " + request.isSecure());
/* 73:90 */     System.out.println("-------------------------------------------------");
/* 74:   */     
/* 75:92 */     return true;
/* 76:   */   }
/* 77:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.essecorp.utils.struts.controller.CustomRequestProcessor
 * JD-Core Version:    0.7.0.1
 */