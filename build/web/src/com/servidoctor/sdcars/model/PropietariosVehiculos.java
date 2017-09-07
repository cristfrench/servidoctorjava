/*   1:    */ package com.servidoctor.sdcars.model;
/*   2:    */ 
/*   3:    */ import java.math.BigDecimal;
/*   4:    */ 
/*   5:    */ public class PropietariosVehiculos
/*   6:    */ {
/*   7:    */   private BigDecimal pveh_cod;
/*   8:    */   private BigDecimal pveh_veh_cod;
/*   9:    */   private String pveh_nombre;
/*  10:    */   private String pveh_apellido;
/*  11:    */   private BigDecimal pveh_pais_cod;
/*  12:    */   private BigDecimal pveh_ciu_cod;
/*  13:    */   private String pveh_mail;
/*  14:    */   private BigDecimal pveh_indpais1;
/*  15:    */   private BigDecimal pveh_indciudad1;
/*  16:    */   private String pveh_telefono1;
/*  17:    */   private BigDecimal pveh_indpais2;
/*  18:    */   private String pveh_telefono2;
/*  19:    */   private String pveh_sexo;
/*  20:    */   private BigDecimal pveh_fecnacim;
/*  21:    */   private BigDecimal pveh_idio_cod;
/*  22:    */   
/*  23:    */   public String getPveh_apellido()
/*  24:    */   {
/*  25: 30 */     return this.pveh_apellido;
/*  26:    */   }
/*  27:    */   
/*  28:    */   public BigDecimal getPveh_ciu_cod()
/*  29:    */   {
/*  30: 34 */     return this.pveh_ciu_cod;
/*  31:    */   }
/*  32:    */   
/*  33:    */   public BigDecimal getPveh_cod()
/*  34:    */   {
/*  35: 38 */     return this.pveh_cod;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public BigDecimal getPveh_indciudad1()
/*  39:    */   {
/*  40: 42 */     return this.pveh_indciudad1;
/*  41:    */   }
/*  42:    */   
/*  43:    */   public BigDecimal getPveh_indpais1()
/*  44:    */   {
/*  45: 46 */     return this.pveh_indpais1;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public BigDecimal getPveh_indpais2()
/*  49:    */   {
/*  50: 50 */     return this.pveh_indpais2;
/*  51:    */   }
/*  52:    */   
/*  53:    */   public String getPveh_mail()
/*  54:    */   {
/*  55: 54 */     return this.pveh_mail;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public String getPveh_nombre()
/*  59:    */   {
/*  60: 58 */     return this.pveh_nombre;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public BigDecimal getPveh_pais_cod()
/*  64:    */   {
/*  65: 62 */     return this.pveh_pais_cod;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public String getPveh_sexo()
/*  69:    */   {
/*  70: 66 */     return this.pveh_sexo;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public String getPveh_telefono1()
/*  74:    */   {
/*  75: 70 */     return this.pveh_telefono1;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public String getPveh_telefono2()
/*  79:    */   {
/*  80: 74 */     return this.pveh_telefono2;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public BigDecimal getPveh_veh_cod()
/*  84:    */   {
/*  85: 78 */     return this.pveh_veh_cod;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public BigDecimal getPveh_fecnacim()
/*  89:    */   {
/*  90: 82 */     return this.pveh_fecnacim;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public void setPveh_apellido(String string)
/*  94:    */   {
/*  95: 86 */     this.pveh_apellido = string;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public void setPveh_ciu_cod(BigDecimal decimal)
/*  99:    */   {
/* 100: 90 */     this.pveh_ciu_cod = decimal;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public void setPveh_cod(BigDecimal decimal)
/* 104:    */   {
/* 105: 94 */     this.pveh_cod = decimal;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public void setPveh_indciudad1(BigDecimal decimal)
/* 109:    */   {
/* 110: 98 */     this.pveh_indciudad1 = decimal;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public void setPveh_indpais1(BigDecimal decimal)
/* 114:    */   {
/* 115:102 */     this.pveh_indpais1 = decimal;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public void setPveh_indpais2(BigDecimal decimal)
/* 119:    */   {
/* 120:106 */     this.pveh_indpais2 = decimal;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public void setPveh_mail(String string)
/* 124:    */   {
/* 125:110 */     this.pveh_mail = string;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public void setPveh_nombre(String string)
/* 129:    */   {
/* 130:114 */     this.pveh_nombre = string;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public void setPveh_pais_cod(BigDecimal decimal)
/* 134:    */   {
/* 135:118 */     this.pveh_pais_cod = decimal;
/* 136:    */   }
/* 137:    */   
/* 138:    */   public void setPveh_sexo(String string)
/* 139:    */   {
/* 140:122 */     this.pveh_sexo = string;
/* 141:    */   }
/* 142:    */   
/* 143:    */   public void setPveh_telefono1(String string)
/* 144:    */   {
/* 145:126 */     this.pveh_telefono1 = string;
/* 146:    */   }
/* 147:    */   
/* 148:    */   public void setPveh_telefono2(String string)
/* 149:    */   {
/* 150:130 */     this.pveh_telefono2 = string;
/* 151:    */   }
/* 152:    */   
/* 153:    */   public void setPveh_veh_cod(BigDecimal decimal)
/* 154:    */   {
/* 155:134 */     this.pveh_veh_cod = decimal;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public void setPveh_fecnacim(BigDecimal decimal)
/* 159:    */   {
/* 160:138 */     this.pveh_fecnacim = decimal;
/* 161:    */   }
/* 162:    */   
/* 163:    */   public BigDecimal getPveh_idio_cod()
/* 164:    */   {
/* 165:142 */     return this.pveh_idio_cod;
/* 166:    */   }
/* 167:    */   
/* 168:    */   public void setPveh_idio_cod(BigDecimal pveh_idio_cod)
/* 169:    */   {
/* 170:146 */     this.pveh_idio_cod = pveh_idio_cod;
/* 171:    */   }
/* 172:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdcars.model.PropietariosVehiculos
 * JD-Core Version:    0.7.0.1
 */