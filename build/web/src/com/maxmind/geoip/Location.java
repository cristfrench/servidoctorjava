/*  1:   */ package com.maxmind.geoip;
/*  2:   */ 
/*  3:   */ public class Location
/*  4:   */ {
/*  5:   */   public String countryCode;
/*  6:   */   public String countryName;
/*  7:   */   public String region;
/*  8:   */   public String city;
/*  9:   */   public String postalCode;
/* 10:   */   public float latitude;
/* 11:   */   public float longitude;
/* 12:   */   public int dma_code;
/* 13:   */   public int area_code;
/* 14:   */   private static final double EARTH_DIAMETER = 12756.4D;
/* 15:   */   private static final double PI = 3.14159265D;
/* 16:   */   private static final double RAD_CONVERT = 0.0174532925D;
/* 17:   */   
/* 18:   */   public double distance(Location loc)
/* 19:   */   {
/* 20:42 */     float lat1 = this.latitude;
/* 21:43 */     float lon1 = this.longitude;
/* 22:44 */     float lat2 = loc.latitude;
/* 23:45 */     float lon2 = loc.longitude;
/* 24:   */     
/* 25:   */ 
/* 26:48 */     lat1 = (float)(lat1 * 0.0174532925D);
/* 27:49 */     lat2 = (float)(lat2 * 0.0174532925D);
/* 28:   */     
/* 29:   */ 
/* 30:52 */     double delta_lat = lat2 - lat1;
/* 31:53 */     double delta_lon = (lon2 - lon1) * 0.0174532925D;
/* 32:   */     
/* 33:   */ 
/* 34:56 */     double temp = Math.pow(Math.sin(delta_lat / 2.0D), 2.0D) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(delta_lon / 2.0D), 2.0D);
/* 35:57 */     return 12756.4D * Math.atan2(Math.sqrt(temp), Math.sqrt(1.0D - temp));
/* 36:   */   }
/* 37:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.maxmind.geoip.Location
 * JD-Core Version:    0.7.0.1
 */