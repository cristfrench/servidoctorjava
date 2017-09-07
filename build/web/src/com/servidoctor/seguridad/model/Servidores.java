/*  1:   */ package com.servidoctor.seguridad.model;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import java.math.BigDecimal;
/*  5:   */ 
/*  6:   */ public class Servidores
/*  7:   */   implements Serializable
/*  8:   */ {
/*  9:14 */   private BigDecimal serv_cod = null;
/* 10:15 */   private String serv_nombre = null;
/* 11:16 */   private String serv_ip = null;
/* 12:   */   
/* 13:   */   public Servidores(int id)
/* 14:   */   {
/* 15:18 */     this.serv_cod = new BigDecimal(id);
/* 16:   */   }
/* 17:   */   
/* 18:   */   public Servidores() {}
/* 19:   */   
/* 20:   */   public boolean equals(Object obj)
/* 21:   */   {
/* 22:23 */     if (obj == this) {
/* 23:23 */       return true;
/* 24:   */     }
/* 25:24 */     if (((obj instanceof Servidores)) && 
/* 26:25 */       (((Servidores)obj).getServ_cod().equals(getServ_cod()))) {
/* 27:25 */       return true;
/* 28:   */     }
/* 29:26 */     return false;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public BigDecimal getServ_cod()
/* 33:   */   {
/* 34:30 */     return this.serv_cod;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public void setServ_cod(BigDecimal serv_cod)
/* 38:   */   {
/* 39:33 */     this.serv_cod = serv_cod;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public String getServ_ip()
/* 43:   */   {
/* 44:36 */     return this.serv_ip;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public void setServ_ip(String serv_ip)
/* 48:   */   {
/* 49:39 */     this.serv_ip = serv_ip;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public String getServ_nombre()
/* 53:   */   {
/* 54:42 */     return this.serv_nombre;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public void setServ_nombre(String serv_nombre)
/* 58:   */   {
/* 59:45 */     this.serv_nombre = serv_nombre;
/* 60:   */   }
/* 61:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.seguridad.model.Servidores
 * JD-Core Version:    0.7.0.1
 */