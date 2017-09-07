/*   1:    */ package com.servidoctor.sdfamily.controller;
/*   2:    */ 
/*   3:    */ import org.apache.struts.validator.ValidatorForm;
/*   4:    */ 
/*   5:    */ public class SeguroMedicoForm
/*   6:    */   extends ValidatorForm
/*   7:    */ {
/*   8: 14 */   private String segm_cod = "0";
/*   9: 15 */   private String segm_usuf_cod = "0";
/*  10: 16 */   private String segm_nomcia = "";
/*  11: 17 */   private String segm_polizaafi = "";
/*  12: 18 */   private String segm_contacto = "";
/*  13: 19 */   private String segm_indpais1 = "0";
/*  14: 20 */   private String segm_indciudad1 = "0";
/*  15: 21 */   private String segm_telefono1 = "";
/*  16: 22 */   private String segm_indpais2 = "0";
/*  17: 23 */   private String segm_telefono2 = "";
/*  18: 24 */   private String segm_indpais3 = "0";
/*  19: 25 */   private String segm_indciudad3 = "0";
/*  20: 26 */   private String segm_telefono3 = "";
/*  21: 27 */   private String segm_vig_desde = "0";
/*  22: 28 */   private String segm_vig_hasta = "0";
/*  23: 29 */   private String segm_email = "";
/*  24: 30 */   private String segm_grup_cod = "0";
/*  25: 31 */   private String segm_mails_enviados = "0";
/*  26: 32 */   private String segm_ultimo_mail = "0";
/*  27: 33 */   private String segm_fecenvio2 = "0";
/*  28:    */   
/*  29:    */   public String getSegm_cod()
/*  30:    */   {
/*  31: 36 */     return this.segm_cod;
/*  32:    */   }
/*  33:    */   
/*  34:    */   public String getSegm_contacto()
/*  35:    */   {
/*  36: 39 */     return this.segm_contacto;
/*  37:    */   }
/*  38:    */   
/*  39:    */   public String getSegm_email()
/*  40:    */   {
/*  41: 42 */     return this.segm_email;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public String getSegm_grup_cod()
/*  45:    */   {
/*  46: 45 */     return this.segm_grup_cod;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public String getSegm_indciudad1()
/*  50:    */   {
/*  51: 48 */     return this.segm_indciudad1;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public String getSegm_indciudad3()
/*  55:    */   {
/*  56: 51 */     return this.segm_indciudad3;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public String getSegm_indpais1()
/*  60:    */   {
/*  61: 54 */     return this.segm_indpais1;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public String getSegm_indpais2()
/*  65:    */   {
/*  66: 57 */     return this.segm_indpais2;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public String getSegm_indpais3()
/*  70:    */   {
/*  71: 60 */     return this.segm_indpais3;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public String getSegm_mails_enviados()
/*  75:    */   {
/*  76: 63 */     return this.segm_mails_enviados;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public String getSegm_nomcia()
/*  80:    */   {
/*  81: 66 */     return this.segm_nomcia;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public String getSegm_polizaafi()
/*  85:    */   {
/*  86: 69 */     return this.segm_polizaafi;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public String getSegm_telefono1()
/*  90:    */   {
/*  91: 72 */     return this.segm_telefono1;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public String getSegm_telefono2()
/*  95:    */   {
/*  96: 75 */     return this.segm_telefono2;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public String getSegm_telefono3()
/* 100:    */   {
/* 101: 78 */     return this.segm_telefono3;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public String getSegm_ultimo_mail()
/* 105:    */   {
/* 106: 81 */     return this.segm_ultimo_mail;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public String getSegm_usuf_cod()
/* 110:    */   {
/* 111: 84 */     return this.segm_usuf_cod;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public String getSegm_vig_desde()
/* 115:    */   {
/* 116: 87 */     return this.segm_vig_desde;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public String getSegm_vig_hasta()
/* 120:    */   {
/* 121: 90 */     return this.segm_vig_hasta;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public void setSegm_cod(String segm_cod)
/* 125:    */   {
/* 126: 93 */     this.segm_cod = segm_cod;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public void setSegm_contacto(String segm_contacto)
/* 130:    */   {
/* 131: 96 */     this.segm_contacto = segm_contacto;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public void setSegm_email(String segm_email)
/* 135:    */   {
/* 136: 99 */     this.segm_email = segm_email;
/* 137:    */   }
/* 138:    */   
/* 139:    */   public void setSegm_grup_cod(String segm_grup_cod)
/* 140:    */   {
/* 141:102 */     this.segm_grup_cod = segm_grup_cod;
/* 142:    */   }
/* 143:    */   
/* 144:    */   public void setSegm_indciudad1(String segm_indciudad1)
/* 145:    */   {
/* 146:105 */     this.segm_indciudad1 = segm_indciudad1;
/* 147:    */   }
/* 148:    */   
/* 149:    */   public void setSegm_indciudad3(String segm_indciudad3)
/* 150:    */   {
/* 151:108 */     this.segm_indciudad3 = segm_indciudad3;
/* 152:    */   }
/* 153:    */   
/* 154:    */   public void setSegm_indpais1(String segm_indpais1)
/* 155:    */   {
/* 156:111 */     this.segm_indpais1 = segm_indpais1;
/* 157:    */   }
/* 158:    */   
/* 159:    */   public void setSegm_indpais2(String segm_indpais2)
/* 160:    */   {
/* 161:114 */     this.segm_indpais2 = segm_indpais2;
/* 162:    */   }
/* 163:    */   
/* 164:    */   public void setSegm_indpais3(String segm_indpais3)
/* 165:    */   {
/* 166:117 */     this.segm_indpais3 = segm_indpais3;
/* 167:    */   }
/* 168:    */   
/* 169:    */   public void setSegm_mails_enviados(String segm_mails_enviados)
/* 170:    */   {
/* 171:120 */     this.segm_mails_enviados = segm_mails_enviados;
/* 172:    */   }
/* 173:    */   
/* 174:    */   public void setSegm_nomcia(String segm_nomcia)
/* 175:    */   {
/* 176:123 */     this.segm_nomcia = segm_nomcia;
/* 177:    */   }
/* 178:    */   
/* 179:    */   public void setSegm_polizaafi(String segm_polizaafi)
/* 180:    */   {
/* 181:126 */     this.segm_polizaafi = segm_polizaafi;
/* 182:    */   }
/* 183:    */   
/* 184:    */   public void setSegm_telefono1(String segm_telefono1)
/* 185:    */   {
/* 186:129 */     this.segm_telefono1 = segm_telefono1;
/* 187:    */   }
/* 188:    */   
/* 189:    */   public void setSegm_telefono2(String segm_telefono2)
/* 190:    */   {
/* 191:132 */     this.segm_telefono2 = segm_telefono2;
/* 192:    */   }
/* 193:    */   
/* 194:    */   public void setSegm_telefono3(String segm_telefono3)
/* 195:    */   {
/* 196:135 */     this.segm_telefono3 = segm_telefono3;
/* 197:    */   }
/* 198:    */   
/* 199:    */   public void setSegm_ultimo_mail(String segm_ultimo_mail)
/* 200:    */   {
/* 201:138 */     this.segm_ultimo_mail = segm_ultimo_mail;
/* 202:    */   }
/* 203:    */   
/* 204:    */   public void setSegm_usuf_cod(String segm_usuf_cod)
/* 205:    */   {
/* 206:141 */     this.segm_usuf_cod = segm_usuf_cod;
/* 207:    */   }
/* 208:    */   
/* 209:    */   public void setSegm_vig_desde(String segm_vig_desde)
/* 210:    */   {
/* 211:144 */     this.segm_vig_desde = segm_vig_desde;
/* 212:    */   }
/* 213:    */   
/* 214:    */   public void setSegm_vig_hasta(String segm_vig_hasta)
/* 215:    */   {
/* 216:147 */     this.segm_vig_hasta = segm_vig_hasta;
/* 217:    */   }
/* 218:    */   
/* 219:    */   public String getSegm_fecenvio2()
/* 220:    */   {
/* 221:150 */     return this.segm_fecenvio2;
/* 222:    */   }
/* 223:    */   
/* 224:    */   public void setSegm_fecenvio2(String segm_fecenvio2)
/* 225:    */   {
/* 226:153 */     this.segm_fecenvio2 = segm_fecenvio2;
/* 227:    */   }
/* 228:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.controller.SeguroMedicoForm
 * JD-Core Version:    0.7.0.1
 */