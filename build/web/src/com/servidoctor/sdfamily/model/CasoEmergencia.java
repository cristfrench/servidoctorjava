/*   1:    */ package com.servidoctor.sdfamily.model;
/*   2:    */ 
/*   3:    */ import java.math.BigDecimal;
/*   4:    */ 
/*   5:    */ public class CasoEmergencia
/*   6:    */ {
/*   7:    */   private BigDecimal case_cod;
/*   8:    */   private BigDecimal case_usuf_cod;
/*   9:    */   private String case_nombre;
/*  10:    */   private String case_apellido;
/*  11:    */   private BigDecimal case_pais_cod;
/*  12:    */   private BigDecimal case_ciu_cod;
/*  13:    */   private BigDecimal case_rfam_cod;
/*  14:    */   private BigDecimal case_indpais1;
/*  15:    */   private BigDecimal case_indciudad1;
/*  16:    */   private String case_telefono1;
/*  17:    */   private BigDecimal case_indpais2;
/*  18:    */   private String case_telefono2;
/*  19:    */   private String case_mail;
/*  20:    */   private BigDecimal case_orden;
/*  21:    */   
/*  22:    */   public String getCase_apellido()
/*  23:    */   {
/*  24: 30 */     return this.case_apellido;
/*  25:    */   }
/*  26:    */   
/*  27:    */   public BigDecimal getCase_ciu_cod()
/*  28:    */   {
/*  29: 33 */     return this.case_ciu_cod;
/*  30:    */   }
/*  31:    */   
/*  32:    */   public BigDecimal getCase_cod()
/*  33:    */   {
/*  34: 36 */     return this.case_cod;
/*  35:    */   }
/*  36:    */   
/*  37:    */   public BigDecimal getCase_indciudad1()
/*  38:    */   {
/*  39: 39 */     return this.case_indciudad1;
/*  40:    */   }
/*  41:    */   
/*  42:    */   public BigDecimal getCase_indpais1()
/*  43:    */   {
/*  44: 42 */     return this.case_indpais1;
/*  45:    */   }
/*  46:    */   
/*  47:    */   public BigDecimal getCase_indpais2()
/*  48:    */   {
/*  49: 45 */     return this.case_indpais2;
/*  50:    */   }
/*  51:    */   
/*  52:    */   public String getCase_mail()
/*  53:    */   {
/*  54: 48 */     return this.case_mail;
/*  55:    */   }
/*  56:    */   
/*  57:    */   public String getCase_nombre()
/*  58:    */   {
/*  59: 51 */     return this.case_nombre;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public BigDecimal getCase_orden()
/*  63:    */   {
/*  64: 54 */     return this.case_orden;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public BigDecimal getCase_pais_cod()
/*  68:    */   {
/*  69: 57 */     return this.case_pais_cod;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public BigDecimal getCase_rfam_cod()
/*  73:    */   {
/*  74: 60 */     return this.case_rfam_cod;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public String getCase_telefono1()
/*  78:    */   {
/*  79: 63 */     return this.case_telefono1;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public String getCase_telefono2()
/*  83:    */   {
/*  84: 66 */     return this.case_telefono2;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public BigDecimal getCase_usuf_cod()
/*  88:    */   {
/*  89: 69 */     return this.case_usuf_cod;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public void setCase_apellido(String case_apellido)
/*  93:    */   {
/*  94: 72 */     this.case_apellido = case_apellido;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public void setCase_ciu_cod(BigDecimal case_ciu_cod)
/*  98:    */   {
/*  99: 75 */     this.case_ciu_cod = case_ciu_cod;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public void setCase_cod(BigDecimal case_cod)
/* 103:    */   {
/* 104: 78 */     this.case_cod = case_cod;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public void setCase_indciudad1(BigDecimal case_indciudad1)
/* 108:    */   {
/* 109: 81 */     this.case_indciudad1 = case_indciudad1;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public void setCase_indpais1(BigDecimal case_indpais1)
/* 113:    */   {
/* 114: 84 */     this.case_indpais1 = case_indpais1;
/* 115:    */   }
/* 116:    */   
/* 117:    */   public void setCase_indpais2(BigDecimal case_indpais2)
/* 118:    */   {
/* 119: 87 */     this.case_indpais2 = case_indpais2;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public void setCase_mail(String case_mail)
/* 123:    */   {
/* 124: 90 */     this.case_mail = case_mail;
/* 125:    */   }
/* 126:    */   
/* 127:    */   public void setCase_nombre(String case_nombre)
/* 128:    */   {
/* 129: 93 */     this.case_nombre = case_nombre;
/* 130:    */   }
/* 131:    */   
/* 132:    */   public void setCase_orden(BigDecimal case_orden)
/* 133:    */   {
/* 134: 96 */     this.case_orden = case_orden;
/* 135:    */   }
/* 136:    */   
/* 137:    */   public void setCase_pais_cod(BigDecimal case_pais_cod)
/* 138:    */   {
/* 139: 99 */     this.case_pais_cod = case_pais_cod;
/* 140:    */   }
/* 141:    */   
/* 142:    */   public void setCase_rfam_cod(BigDecimal case_rfam_cod)
/* 143:    */   {
/* 144:102 */     this.case_rfam_cod = case_rfam_cod;
/* 145:    */   }
/* 146:    */   
/* 147:    */   public void setCase_telefono1(String case_telefono1)
/* 148:    */   {
/* 149:105 */     this.case_telefono1 = case_telefono1;
/* 150:    */   }
/* 151:    */   
/* 152:    */   public void setCase_telefono2(String case_telefono2)
/* 153:    */   {
/* 154:108 */     this.case_telefono2 = case_telefono2;
/* 155:    */   }
/* 156:    */   
/* 157:    */   public void setCase_usuf_cod(BigDecimal case_usuf_cod)
/* 158:    */   {
/* 159:111 */     this.case_usuf_cod = case_usuf_cod;
/* 160:    */   }
/* 161:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.model.CasoEmergencia
 * JD-Core Version:    0.7.0.1
 */