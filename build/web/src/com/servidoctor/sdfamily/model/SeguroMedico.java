/*   1:    */ package com.servidoctor.sdfamily.model;
/*   2:    */ 
/*   3:    */ import java.math.BigDecimal;
/*   4:    */ 
/*   5:    */ public class SeguroMedico
/*   6:    */ {
/*   7:    */   protected BigDecimal segm_cod;
/*   8:    */   protected BigDecimal segm_usuf_cod;
/*   9:    */   protected String segm_nomcia;
/*  10:    */   protected String segm_polizaafi;
/*  11:    */   protected String segm_contacto;
/*  12:    */   protected BigDecimal segm_indpais1;
/*  13:    */   protected BigDecimal segm_indciudad1;
/*  14:    */   protected String segm_telefono1;
/*  15:    */   protected BigDecimal segm_indpais2;
/*  16:    */   protected String segm_telefono2;
/*  17:    */   protected BigDecimal segm_indpais3;
/*  18:    */   protected BigDecimal segm_indciudad3;
/*  19:    */   protected String segm_telefono3;
/*  20:    */   protected BigDecimal segm_vig_desde;
/*  21:    */   protected BigDecimal segm_vig_hasta;
/*  22:    */   protected BigDecimal segm_fecenvio2;
/*  23:    */   protected BigDecimal segm_quince_dias;
/*  24:    */   protected String segm_email;
/*  25:    */   protected BigDecimal segm_grup_cod;
/*  26:    */   protected BigDecimal segm_mails_enviados;
/*  27:    */   protected BigDecimal segm_ultimo_mail;
/*  28:    */   
/*  29:    */   public BigDecimal getSegm_cod()
/*  30:    */   {
/*  31: 44 */     return this.segm_cod;
/*  32:    */   }
/*  33:    */   
/*  34:    */   public String getSegm_contacto()
/*  35:    */   {
/*  36: 47 */     return this.segm_contacto;
/*  37:    */   }
/*  38:    */   
/*  39:    */   public String getSegm_email()
/*  40:    */   {
/*  41: 50 */     return this.segm_email;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public BigDecimal getSegm_grup_cod()
/*  45:    */   {
/*  46: 53 */     return this.segm_grup_cod;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public BigDecimal getSegm_indciudad1()
/*  50:    */   {
/*  51: 56 */     return this.segm_indciudad1;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public BigDecimal getSegm_indciudad3()
/*  55:    */   {
/*  56: 59 */     return this.segm_indciudad3;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public BigDecimal getSegm_indpais1()
/*  60:    */   {
/*  61: 62 */     return this.segm_indpais1;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public BigDecimal getSegm_indpais2()
/*  65:    */   {
/*  66: 65 */     return this.segm_indpais2;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public BigDecimal getSegm_indpais3()
/*  70:    */   {
/*  71: 68 */     return this.segm_indpais3;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public BigDecimal getSegm_mails_enviados()
/*  75:    */   {
/*  76: 71 */     return this.segm_mails_enviados;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public String getSegm_nomcia()
/*  80:    */   {
/*  81: 74 */     return this.segm_nomcia;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public String getSegm_polizaafi()
/*  85:    */   {
/*  86: 77 */     return this.segm_polizaafi;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public String getSegm_telefono1()
/*  90:    */   {
/*  91: 80 */     return this.segm_telefono1;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public String getSegm_telefono2()
/*  95:    */   {
/*  96: 83 */     return this.segm_telefono2;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public String getSegm_telefono3()
/* 100:    */   {
/* 101: 86 */     return this.segm_telefono3;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public BigDecimal getSegm_ultimo_mail()
/* 105:    */   {
/* 106: 89 */     return this.segm_ultimo_mail;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public BigDecimal getSegm_usuf_cod()
/* 110:    */   {
/* 111: 92 */     return this.segm_usuf_cod;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public BigDecimal getSegm_vig_desde()
/* 115:    */   {
/* 116: 95 */     return this.segm_vig_desde;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public BigDecimal getSegm_vig_hasta()
/* 120:    */   {
/* 121: 98 */     return this.segm_vig_hasta;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public void setSegm_cod(BigDecimal segm_cod)
/* 125:    */   {
/* 126:101 */     this.segm_cod = segm_cod;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public void setSegm_contacto(String segm_contacto)
/* 130:    */   {
/* 131:104 */     this.segm_contacto = segm_contacto;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public void setSegm_email(String segm_email)
/* 135:    */   {
/* 136:107 */     this.segm_email = segm_email;
/* 137:    */   }
/* 138:    */   
/* 139:    */   public void setSegm_grup_cod(BigDecimal segm_grup_cod)
/* 140:    */   {
/* 141:110 */     this.segm_grup_cod = segm_grup_cod;
/* 142:    */   }
/* 143:    */   
/* 144:    */   public void setSegm_indciudad1(BigDecimal segm_indciudad1)
/* 145:    */   {
/* 146:113 */     this.segm_indciudad1 = segm_indciudad1;
/* 147:    */   }
/* 148:    */   
/* 149:    */   public void setSegm_indciudad3(BigDecimal segm_indciudad3)
/* 150:    */   {
/* 151:116 */     this.segm_indciudad3 = segm_indciudad3;
/* 152:    */   }
/* 153:    */   
/* 154:    */   public void setSegm_indpais1(BigDecimal segm_indpais1)
/* 155:    */   {
/* 156:119 */     this.segm_indpais1 = segm_indpais1;
/* 157:    */   }
/* 158:    */   
/* 159:    */   public void setSegm_indpais2(BigDecimal segm_indpais2)
/* 160:    */   {
/* 161:122 */     this.segm_indpais2 = segm_indpais2;
/* 162:    */   }
/* 163:    */   
/* 164:    */   public void setSegm_indpais3(BigDecimal segm_indpais3)
/* 165:    */   {
/* 166:125 */     this.segm_indpais3 = segm_indpais3;
/* 167:    */   }
/* 168:    */   
/* 169:    */   public void setSegm_mails_enviados(BigDecimal segm_mails_enviados)
/* 170:    */   {
/* 171:128 */     this.segm_mails_enviados = segm_mails_enviados;
/* 172:    */   }
/* 173:    */   
/* 174:    */   public void setSegm_nomcia(String segm_nomcia)
/* 175:    */   {
/* 176:131 */     this.segm_nomcia = segm_nomcia;
/* 177:    */   }
/* 178:    */   
/* 179:    */   public void setSegm_polizaafi(String segm_polizaafi)
/* 180:    */   {
/* 181:134 */     this.segm_polizaafi = segm_polizaafi;
/* 182:    */   }
/* 183:    */   
/* 184:    */   public void setSegm_telefono1(String segm_telefono1)
/* 185:    */   {
/* 186:137 */     this.segm_telefono1 = segm_telefono1;
/* 187:    */   }
/* 188:    */   
/* 189:    */   public void setSegm_telefono2(String segm_telefono2)
/* 190:    */   {
/* 191:140 */     this.segm_telefono2 = segm_telefono2;
/* 192:    */   }
/* 193:    */   
/* 194:    */   public void setSegm_telefono3(String segm_telefono3)
/* 195:    */   {
/* 196:143 */     this.segm_telefono3 = segm_telefono3;
/* 197:    */   }
/* 198:    */   
/* 199:    */   public void setSegm_ultimo_mail(BigDecimal segm_ultimo_mail)
/* 200:    */   {
/* 201:146 */     this.segm_ultimo_mail = segm_ultimo_mail;
/* 202:    */   }
/* 203:    */   
/* 204:    */   public void setSegm_usuf_cod(BigDecimal segm_usuf_cod)
/* 205:    */   {
/* 206:149 */     this.segm_usuf_cod = segm_usuf_cod;
/* 207:    */   }
/* 208:    */   
/* 209:    */   public void setSegm_vig_desde(BigDecimal segm_vig_desde)
/* 210:    */   {
/* 211:152 */     this.segm_vig_desde = segm_vig_desde;
/* 212:    */   }
/* 213:    */   
/* 214:    */   public void setSegm_vig_hasta(BigDecimal segm_vig_hasta)
/* 215:    */   {
/* 216:155 */     this.segm_vig_hasta = segm_vig_hasta;
/* 217:    */   }
/* 218:    */   
/* 219:    */   public BigDecimal getSegm_fecenvio2()
/* 220:    */   {
/* 221:158 */     return this.segm_fecenvio2;
/* 222:    */   }
/* 223:    */   
/* 224:    */   public void setSegm_fecenvio2(BigDecimal segm_fecenvio2)
/* 225:    */   {
/* 226:161 */     this.segm_fecenvio2 = segm_fecenvio2;
/* 227:    */   }
/* 228:    */   
/* 229:    */   public BigDecimal getSegm_quince_dias()
/* 230:    */   {
/* 231:164 */     return this.segm_quince_dias;
/* 232:    */   }
/* 233:    */   
/* 234:    */   public void setSegm_quince_dias(BigDecimal segm_quince_dias)
/* 235:    */   {
/* 236:167 */     this.segm_quince_dias = segm_quince_dias;
/* 237:    */   }
/* 238:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.model.SeguroMedico
 * JD-Core Version:    0.7.0.1
 */