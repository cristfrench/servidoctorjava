/*  1:   */ package com.maxmind.geoip;
/*  2:   */ 
/*  3:   */ public class Country
/*  4:   */ {
/*  5:   */   private String code;
/*  6:   */   private String name;
/*  7:   */   
/*  8:   */   public Country(String code, String name)
/*  9:   */   {
/* 10:40 */     this.code = code;
/* 11:41 */     this.name = name;
/* 12:   */   }
/* 13:   */   
/* 14:   */   public String getCode()
/* 15:   */   {
/* 16:50 */     return this.code;
/* 17:   */   }
/* 18:   */   
/* 19:   */   public String getName()
/* 20:   */   {
/* 21:59 */     return this.name;
/* 22:   */   }
/* 23:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.maxmind.geoip.Country
 * JD-Core Version:    0.7.0.1
 */