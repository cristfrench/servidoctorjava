/*   1:    */ package com.servidoctor.seguridad.model;
/*   2:    */ 
/*   3:    */ import java.math.BigDecimal;
/*   4:    */ 
/*   5:    */ public class IntercambioDatos
/*   6:    */ {
/*   7:    */   private BigDecimal usu_cod;
/*   8:    */   private String usu_licencia;
/*   9:    */   private String usu_usuario;
/*  10:    */   private BigDecimal usu_solo_lectura;
/*  11:    */   private String idioma;
/*  12:    */   private BigDecimal serv_cod;
/*  13:    */   private String serv_ip;
/*  14:    */   private String app;
/*  15:    */   private BigDecimal logm_cod;
/*  16:    */   private String logm_ruta;
/*  17:    */   private String logm_link;
/*  18:    */   private String logm_left_text;
/*  19:    */   private String logm_link_text;
/*  20:    */   private String usu_may_cod;
/*  21:    */   
/*  22:    */   public String getApp()
/*  23:    */   {
/*  24: 22 */     return this.app;
/*  25:    */   }
/*  26:    */   
/*  27:    */   public void setApp(String app)
/*  28:    */   {
/*  29: 25 */     this.app = app;
/*  30:    */   }
/*  31:    */   
/*  32:    */   public String getIdioma()
/*  33:    */   {
/*  34: 28 */     return this.idioma;
/*  35:    */   }
/*  36:    */   
/*  37:    */   public void setIdioma(String idioma)
/*  38:    */   {
/*  39: 31 */     this.idioma = idioma;
/*  40:    */   }
/*  41:    */   
/*  42:    */   public BigDecimal getLogm_cod()
/*  43:    */   {
/*  44: 34 */     return this.logm_cod;
/*  45:    */   }
/*  46:    */   
/*  47:    */   public void setLogm_cod(BigDecimal logm_cod)
/*  48:    */   {
/*  49: 37 */     this.logm_cod = logm_cod;
/*  50:    */   }
/*  51:    */   
/*  52:    */   public String getLogm_link_text()
/*  53:    */   {
/*  54: 40 */     return this.logm_link_text;
/*  55:    */   }
/*  56:    */   
/*  57:    */   public void setLogm_link_text(String logm_link_text)
/*  58:    */   {
/*  59: 43 */     this.logm_link_text = logm_link_text;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public String getLogm_left_text()
/*  63:    */   {
/*  64: 46 */     return this.logm_left_text;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public void setLogm_left_text(String logm_left_text)
/*  68:    */   {
/*  69: 49 */     this.logm_left_text = logm_left_text;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public String getLogm_link()
/*  73:    */   {
/*  74: 52 */     return this.logm_link;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public void setLogm_link(String logm_link)
/*  78:    */   {
/*  79: 55 */     this.logm_link = logm_link;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public String getLogm_ruta()
/*  83:    */   {
/*  84: 58 */     return this.logm_ruta;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public void setLogm_ruta(String logm_ruta)
/*  88:    */   {
/*  89: 61 */     this.logm_ruta = logm_ruta;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public BigDecimal getServ_cod()
/*  93:    */   {
/*  94: 64 */     return this.serv_cod;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public void setServ_cod(BigDecimal serv_cod)
/*  98:    */   {
/*  99: 67 */     this.serv_cod = serv_cod;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public String getServ_ip()
/* 103:    */   {
/* 104: 70 */     return this.serv_ip;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public void setServ_ip(String serv_ip)
/* 108:    */   {
/* 109: 73 */     this.serv_ip = serv_ip;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public BigDecimal getUsu_cod()
/* 113:    */   {
/* 114: 76 */     return this.usu_cod;
/* 115:    */   }
/* 116:    */   
/* 117:    */   public void setUsu_cod(BigDecimal usu_cod)
/* 118:    */   {
/* 119: 79 */     this.usu_cod = usu_cod;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public String getUsu_licencia()
/* 123:    */   {
/* 124: 82 */     return this.usu_licencia;
/* 125:    */   }
/* 126:    */   
/* 127:    */   public void setUsu_licencia(String usu_licencia)
/* 128:    */   {
/* 129: 85 */     this.usu_licencia = usu_licencia;
/* 130:    */   }
/* 131:    */   
/* 132:    */   public String getUsu_usuario()
/* 133:    */   {
/* 134: 88 */     return this.usu_usuario;
/* 135:    */   }
/* 136:    */   
/* 137:    */   public void setUsu_usuario(String usu_usuario)
/* 138:    */   {
/* 139: 91 */     this.usu_usuario = usu_usuario;
/* 140:    */   }
/* 141:    */   
/* 142:    */   public BigDecimal getUsu_solo_lectura()
/* 143:    */   {
/* 144: 94 */     return this.usu_solo_lectura;
/* 145:    */   }
/* 146:    */   
/* 147:    */   public void setUsu_solo_lectura(BigDecimal usu_solo_lectura)
/* 148:    */   {
/* 149: 97 */     this.usu_solo_lectura = usu_solo_lectura;
/* 150:    */   }
/* 151:    */   
/* 152:    */   public String getUsu_may_cod()
/* 153:    */   {
/* 154:100 */     return this.usu_may_cod;
/* 155:    */   }
/* 156:    */   
/* 157:    */   public void setUsu_may_cod(String usu_may_cod)
/* 158:    */   {
/* 159:103 */     this.usu_may_cod = usu_may_cod;
/* 160:    */   }
/* 161:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.seguridad.model.IntercambioDatos
 * JD-Core Version:    0.7.0.1
 */