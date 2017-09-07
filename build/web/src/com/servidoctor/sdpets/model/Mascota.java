/*   1:    */ package com.servidoctor.sdpets.model;
/*   2:    */ 
/*   3:    */ import java.math.BigDecimal;
/*   4:    */ 
/*   5:    */ public class Mascota
/*   6:    */ {
/*   7:    */   private BigDecimal mas_cod;
/*   8:    */   private BigDecimal mas_usup_cod;
/*   9:    */   private BigDecimal mas_raz_cod;
/*  10:    */   private String mas_nombre;
/*  11:    */   private BigDecimal mas_fecnac;
/*  12:    */   private String mas_tipo;
/*  13:    */   private String mas_sexo;
/*  14:    */   private BigDecimal mas_rechec;
/*  15:    */   private String mas_color;
/*  16:    */   private BigDecimal mas_largo;
/*  17:    */   private BigDecimal mas_altura;
/*  18:    */   private String mas_marcas;
/*  19:    */   private String mas_esteril;
/*  20:    */   private String mas_microchip;
/*  21:    */   private String mas_licenciarabia;
/*  22:    */   private String mas_kennelclub;
/*  23:    */   private BigDecimal mas_fecinscripcion;
/*  24:    */   private BigDecimal mas_num_dias_no_mail;
/*  25:    */   
/*  26:    */   public BigDecimal getMas_cod()
/*  27:    */   {
/*  28: 28 */     return this.mas_cod;
/*  29:    */   }
/*  30:    */   
/*  31:    */   public void setMas_cod(BigDecimal mas_cod)
/*  32:    */   {
/*  33: 31 */     this.mas_cod = mas_cod;
/*  34:    */   }
/*  35:    */   
/*  36:    */   public BigDecimal getMas_fecinscripcion()
/*  37:    */   {
/*  38: 34 */     return this.mas_fecinscripcion;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public void setMas_fecinscripcion(BigDecimal mas_fecinscripcion)
/*  42:    */   {
/*  43: 37 */     this.mas_fecinscripcion = mas_fecinscripcion;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public BigDecimal getMas_fecnac()
/*  47:    */   {
/*  48: 40 */     return this.mas_fecnac;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public void setMas_fecnac(BigDecimal mas_fecnac)
/*  52:    */   {
/*  53: 43 */     this.mas_fecnac = mas_fecnac;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public String getMas_nombre()
/*  57:    */   {
/*  58: 46 */     return this.mas_nombre;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public void setMas_nombre(String mas_nombre)
/*  62:    */   {
/*  63: 49 */     this.mas_nombre = mas_nombre;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public BigDecimal getMas_num_dias_no_mail()
/*  67:    */   {
/*  68: 52 */     return this.mas_num_dias_no_mail;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public void setMas_num_dias_no_mail(BigDecimal mas_num_dias_no_mail)
/*  72:    */   {
/*  73: 55 */     this.mas_num_dias_no_mail = mas_num_dias_no_mail;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public BigDecimal getMas_raz_cod()
/*  77:    */   {
/*  78: 58 */     return this.mas_raz_cod;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public void setMas_raz_cod(BigDecimal mas_raz_cod)
/*  82:    */   {
/*  83: 61 */     this.mas_raz_cod = mas_raz_cod;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public BigDecimal getMas_rechec()
/*  87:    */   {
/*  88: 64 */     return this.mas_rechec;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public void setMas_rechec(BigDecimal mas_rechec)
/*  92:    */   {
/*  93: 67 */     this.mas_rechec = mas_rechec;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public String getMas_sexo()
/*  97:    */   {
/*  98: 70 */     return this.mas_sexo;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public void setMas_sexo(String mas_sexo)
/* 102:    */   {
/* 103: 73 */     this.mas_sexo = mas_sexo;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public String getMas_tipo()
/* 107:    */   {
/* 108: 76 */     return this.mas_tipo;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public void setMas_tipo(String mas_tipo)
/* 112:    */   {
/* 113: 79 */     this.mas_tipo = mas_tipo;
/* 114:    */   }
/* 115:    */   
/* 116:    */   public BigDecimal getMas_usup_cod()
/* 117:    */   {
/* 118: 82 */     return this.mas_usup_cod;
/* 119:    */   }
/* 120:    */   
/* 121:    */   public void setMas_usup_cod(BigDecimal mas_usup_cod)
/* 122:    */   {
/* 123: 85 */     this.mas_usup_cod = mas_usup_cod;
/* 124:    */   }
/* 125:    */   
/* 126:    */   public String getMas_color()
/* 127:    */   {
/* 128: 88 */     return this.mas_color;
/* 129:    */   }
/* 130:    */   
/* 131:    */   public void setMas_color(String masColor)
/* 132:    */   {
/* 133: 91 */     this.mas_color = masColor;
/* 134:    */   }
/* 135:    */   
/* 136:    */   public BigDecimal getMas_largo()
/* 137:    */   {
/* 138: 94 */     return this.mas_largo;
/* 139:    */   }
/* 140:    */   
/* 141:    */   public void setMas_largo(BigDecimal masLargo)
/* 142:    */   {
/* 143: 97 */     this.mas_largo = masLargo;
/* 144:    */   }
/* 145:    */   
/* 146:    */   public BigDecimal getMas_altura()
/* 147:    */   {
/* 148:100 */     return this.mas_altura;
/* 149:    */   }
/* 150:    */   
/* 151:    */   public void setMas_altura(BigDecimal masAltura)
/* 152:    */   {
/* 153:103 */     this.mas_altura = masAltura;
/* 154:    */   }
/* 155:    */   
/* 156:    */   public String getMas_marcas()
/* 157:    */   {
/* 158:106 */     return this.mas_marcas;
/* 159:    */   }
/* 160:    */   
/* 161:    */   public void setMas_marcas(String masMarcas)
/* 162:    */   {
/* 163:109 */     this.mas_marcas = masMarcas;
/* 164:    */   }
/* 165:    */   
/* 166:    */   public String getMas_esteril()
/* 167:    */   {
/* 168:112 */     return this.mas_esteril;
/* 169:    */   }
/* 170:    */   
/* 171:    */   public void setMas_esteril(String masEsteril)
/* 172:    */   {
/* 173:115 */     this.mas_esteril = masEsteril;
/* 174:    */   }
/* 175:    */   
/* 176:    */   public String getMas_microchip()
/* 177:    */   {
/* 178:118 */     return this.mas_microchip;
/* 179:    */   }
/* 180:    */   
/* 181:    */   public void setMas_microchip(String masMicrochip)
/* 182:    */   {
/* 183:121 */     this.mas_microchip = masMicrochip;
/* 184:    */   }
/* 185:    */   
/* 186:    */   public String getMas_licenciarabia()
/* 187:    */   {
/* 188:124 */     return this.mas_licenciarabia;
/* 189:    */   }
/* 190:    */   
/* 191:    */   public void setMas_licenciarabia(String masLicenciarabia)
/* 192:    */   {
/* 193:127 */     this.mas_licenciarabia = masLicenciarabia;
/* 194:    */   }
/* 195:    */   
/* 196:    */   public String getMas_kennelclub()
/* 197:    */   {
/* 198:130 */     return this.mas_kennelclub;
/* 199:    */   }
/* 200:    */   
/* 201:    */   public void setMas_kennelclub(String masKennelclub)
/* 202:    */   {
/* 203:133 */     this.mas_kennelclub = masKennelclub;
/* 204:    */   }
/* 205:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdpets.model.Mascota
 * JD-Core Version:    0.7.0.1
 */