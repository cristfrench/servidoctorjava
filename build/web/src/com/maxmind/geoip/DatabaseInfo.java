/*   1:    */ package com.maxmind.geoip;
/*   2:    */ 
/*   3:    */ import java.text.ParseException;
/*   4:    */ import java.text.SimpleDateFormat;
/*   5:    */ import java.util.Date;
/*   6:    */ 
/*   7:    */ public class DatabaseInfo
/*   8:    */ {
/*   9:    */   public static final int COUNTRY_EDITION = 1;
/*  10:    */   public static final int REGION_EDITION_REV0 = 7;
/*  11:    */   public static final int REGION_EDITION_REV1 = 3;
/*  12:    */   public static final int CITY_EDITION_REV0 = 6;
/*  13:    */   public static final int CITY_EDITION_REV1 = 2;
/*  14:    */   public static final int ORG_EDITION = 5;
/*  15:    */   public static final int ISP_EDITION = 4;
/*  16:    */   public static final int PROXY_EDITION = 8;
/*  17:    */   public static final int ASNUM_EDITION = 9;
/*  18:    */   public static final int NETSPEED_EDITION = 10;
/*  19: 59 */   private static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
/*  20:    */   private String info;
/*  21:    */   
/*  22:    */   public DatabaseInfo(String info)
/*  23:    */   {
/*  24: 68 */     this.info = info;
/*  25:    */   }
/*  26:    */   
/*  27:    */   public int getType()
/*  28:    */   {
/*  29: 72 */     if ((this.info == null) || (this.info.equals(""))) {
/*  30: 73 */       return 1;
/*  31:    */     }
/*  32: 79 */     return Integer.parseInt(this.info.substring(4, 7)) - 105;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public boolean isPremium()
/*  36:    */   {
/*  37: 89 */     return this.info.indexOf("FREE") < 0;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public Date getDate()
/*  41:    */   {
/*  42: 98 */     for (int i = 0; i < this.info.length() - 9;) {
/*  43: 99 */       if (Character.isWhitespace(this.info.charAt(i)))
/*  44:    */       {
/*  45:100 */         String dateString = this.info.substring(i + 1, i + 9);
/*  46:    */         try
/*  47:    */         {
/*  48:102 */           synchronized (formatter)
/*  49:    */           {
/*  50:103 */             return formatter.parse(dateString);
/*  51:    */           }
/*  52: 98 */           i++;
/*  53:    */         }
/*  54:    */         catch (ParseException localParseException) {}
/*  55:    */       }
/*  56:    */     }
/*  57:110 */     return null;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public String toString()
/*  61:    */   {
/*  62:114 */     return this.info;
/*  63:    */   }
/*  64:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.maxmind.geoip.DatabaseInfo
 * JD-Core Version:    0.7.0.1
 */