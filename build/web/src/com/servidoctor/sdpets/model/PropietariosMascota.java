/*   1:    */ package com.servidoctor.sdpets.model;
/*   2:    */ 
/*   3:    */ import java.math.BigDecimal;
/*   4:    */ 
/*   5:    */ public class PropietariosMascota
/*   6:    */ {
/*   7:    */   private BigDecimal pmas_cod;
/*   8:    */   private BigDecimal pmas_mas_cod;
/*   9:    */   private String pmas_nombre;
/*  10:    */   private String pmas_apellido;
/*  11:    */   private BigDecimal pmas_pais_cod;
/*  12:    */   private BigDecimal pmas_ciu_cod;
/*  13:    */   private String pmas_mail;
/*  14:    */   private BigDecimal pmas_indpais1;
/*  15:    */   private BigDecimal pmas_indciudad1;
/*  16:    */   private String pmas_telefono1;
/*  17:    */   private BigDecimal pmas_indpais2;
/*  18:    */   private String pmas_telefono2;
/*  19:    */   private String pmas_sexo;
/*  20:    */   
/*  21:    */   public String getPmas_apellido()
/*  22:    */   {
/*  23: 23 */     return this.pmas_apellido;
/*  24:    */   }
/*  25:    */   
/*  26:    */   public BigDecimal getPmas_ciu_cod()
/*  27:    */   {
/*  28: 27 */     return this.pmas_ciu_cod;
/*  29:    */   }
/*  30:    */   
/*  31:    */   public BigDecimal getPmas_cod()
/*  32:    */   {
/*  33: 31 */     return this.pmas_cod;
/*  34:    */   }
/*  35:    */   
/*  36:    */   public BigDecimal getPmas_indciudad1()
/*  37:    */   {
/*  38: 35 */     return this.pmas_indciudad1;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public BigDecimal getPmas_indpais1()
/*  42:    */   {
/*  43: 39 */     return this.pmas_indpais1;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public BigDecimal getPmas_indpais2()
/*  47:    */   {
/*  48: 43 */     return this.pmas_indpais2;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public String getPmas_mail()
/*  52:    */   {
/*  53: 47 */     return this.pmas_mail;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public BigDecimal getPmas_mas_cod()
/*  57:    */   {
/*  58: 51 */     return this.pmas_mas_cod;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public String getPmas_nombre()
/*  62:    */   {
/*  63: 55 */     return this.pmas_nombre;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public BigDecimal getPmas_pais_cod()
/*  67:    */   {
/*  68: 59 */     return this.pmas_pais_cod;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public String getPmas_telefono1()
/*  72:    */   {
/*  73: 63 */     return this.pmas_telefono1;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public String getPmas_telefono2()
/*  77:    */   {
/*  78: 67 */     return this.pmas_telefono2;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public void setPmas_apellido(String string)
/*  82:    */   {
/*  83: 71 */     this.pmas_apellido = string;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public void setPmas_ciu_cod(BigDecimal decimal)
/*  87:    */   {
/*  88: 75 */     this.pmas_ciu_cod = decimal;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public void setPmas_cod(BigDecimal decimal)
/*  92:    */   {
/*  93: 79 */     this.pmas_cod = decimal;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public void setPmas_indciudad1(BigDecimal decimal)
/*  97:    */   {
/*  98: 83 */     this.pmas_indciudad1 = decimal;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public void setPmas_indpais1(BigDecimal decimal)
/* 102:    */   {
/* 103: 87 */     this.pmas_indpais1 = decimal;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public void setPmas_indpais2(BigDecimal decimal)
/* 107:    */   {
/* 108: 91 */     this.pmas_indpais2 = decimal;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public void setPmas_mail(String string)
/* 112:    */   {
/* 113: 95 */     this.pmas_mail = string;
/* 114:    */   }
/* 115:    */   
/* 116:    */   public void setPmas_mas_cod(BigDecimal decimal)
/* 117:    */   {
/* 118: 99 */     this.pmas_mas_cod = decimal;
/* 119:    */   }
/* 120:    */   
/* 121:    */   public void setPmas_nombre(String string)
/* 122:    */   {
/* 123:103 */     this.pmas_nombre = string;
/* 124:    */   }
/* 125:    */   
/* 126:    */   public void setPmas_pais_cod(BigDecimal decimal)
/* 127:    */   {
/* 128:107 */     this.pmas_pais_cod = decimal;
/* 129:    */   }
/* 130:    */   
/* 131:    */   public void setPmas_telefono1(String string)
/* 132:    */   {
/* 133:111 */     this.pmas_telefono1 = string;
/* 134:    */   }
/* 135:    */   
/* 136:    */   public void setPmas_telefono2(String string)
/* 137:    */   {
/* 138:115 */     this.pmas_telefono2 = string;
/* 139:    */   }
/* 140:    */   
/* 141:    */   public String getPmas_sexo()
/* 142:    */   {
/* 143:122 */     return this.pmas_sexo;
/* 144:    */   }
/* 145:    */   
/* 146:    */   public void setPmas_sexo(String string)
/* 147:    */   {
/* 148:129 */     this.pmas_sexo = string;
/* 149:    */   }
/* 150:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdpets.model.PropietariosMascota
 * JD-Core Version:    0.7.0.1
 */