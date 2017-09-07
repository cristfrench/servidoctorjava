/*   1:    */ package com.servidoctor.sdfamily.controller;
/*   2:    */ 
/*   3:    */ import org.apache.struts.validator.ValidatorForm;
/*   4:    */ 
/*   5:    */ public class ControlMedicoForm
/*   6:    */   extends ValidatorForm
/*   7:    */ {
/*   8: 15 */   private String cmed_cod = "0";
/*   9: 16 */   private String cmed_usuf_cod = "0";
/*  10: 17 */   private String cmed_destratamiento = "";
/*  11: 18 */   private String cmed_feccontrol = "0";
/*  12: 19 */   private String cmed_nommedico = "";
/*  13: 20 */   private String cmed_pais_cod = "0";
/*  14: 21 */   private String cmed_ciudad_cod = "0";
/*  15: 22 */   private String cmed_telefono = "";
/*  16: 23 */   private String cmed_email = "";
/*  17: 24 */   private String cmed_tipo = "0";
/*  18: 25 */   private String cmed_apemedico = "";
/*  19: 26 */   private String cmed_direccion = "";
/*  20: 27 */   private String cmed_entidad = "";
/*  21: 28 */   private String cmed_indpais = "0";
/*  22: 29 */   private String cmed_indciudad = "0";
/*  23: 30 */   private String cmed_hora = "0";
/*  24: 31 */   private String cmed_grup_cod = "0";
/*  25: 32 */   private String cmed_mails_enviados = "0";
/*  26: 33 */   private String cmed_ultimo_mail = "0";
/*  27: 34 */   private String cmed_exa_cod = "0";
/*  28: 35 */   private String cmed_fecenvio2 = "0";
/*  29: 36 */   private String cmed_fecenvion = "0";
/*  30: 37 */   private String cmed_fecenvion2 = "0";
/*  31: 38 */   private String cmed_quince_dias = "0";
/*  32:    */   
/*  33:    */   public String getCmed_apemedico()
/*  34:    */   {
/*  35: 41 */     return this.cmed_apemedico;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public String getCmed_ciudad_cod()
/*  39:    */   {
/*  40: 45 */     return this.cmed_ciudad_cod;
/*  41:    */   }
/*  42:    */   
/*  43:    */   public String getCmed_cod()
/*  44:    */   {
/*  45: 49 */     return this.cmed_cod;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public String getCmed_destratamiento()
/*  49:    */   {
/*  50: 53 */     return this.cmed_destratamiento;
/*  51:    */   }
/*  52:    */   
/*  53:    */   public String getCmed_direccion()
/*  54:    */   {
/*  55: 57 */     return this.cmed_direccion;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public String getCmed_email()
/*  59:    */   {
/*  60: 61 */     return this.cmed_email;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public String getCmed_entidad()
/*  64:    */   {
/*  65: 65 */     return this.cmed_entidad;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public String getCmed_exa_cod()
/*  69:    */   {
/*  70: 69 */     return this.cmed_exa_cod;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public String getCmed_feccontrol()
/*  74:    */   {
/*  75: 73 */     return this.cmed_feccontrol;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public String getCmed_grup_cod()
/*  79:    */   {
/*  80: 77 */     return this.cmed_grup_cod;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public String getCmed_hora()
/*  84:    */   {
/*  85: 81 */     return this.cmed_hora;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public String getCmed_indciudad()
/*  89:    */   {
/*  90: 85 */     return this.cmed_indciudad;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public String getCmed_indpais()
/*  94:    */   {
/*  95: 89 */     return this.cmed_indpais;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public String getCmed_mails_enviados()
/*  99:    */   {
/* 100: 93 */     return this.cmed_mails_enviados;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public String getCmed_nommedico()
/* 104:    */   {
/* 105: 97 */     return this.cmed_nommedico;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public String getCmed_pais_cod()
/* 109:    */   {
/* 110:101 */     return this.cmed_pais_cod;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public String getCmed_telefono()
/* 114:    */   {
/* 115:105 */     return this.cmed_telefono;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public String getCmed_tipo()
/* 119:    */   {
/* 120:109 */     return this.cmed_tipo;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public String getCmed_ultimo_mail()
/* 124:    */   {
/* 125:113 */     return this.cmed_ultimo_mail;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public String getCmed_usuf_cod()
/* 129:    */   {
/* 130:117 */     return this.cmed_usuf_cod;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public void setCmed_apemedico(String string)
/* 134:    */   {
/* 135:121 */     this.cmed_apemedico = string;
/* 136:    */   }
/* 137:    */   
/* 138:    */   public void setCmed_ciudad_cod(String string)
/* 139:    */   {
/* 140:125 */     this.cmed_ciudad_cod = string;
/* 141:    */   }
/* 142:    */   
/* 143:    */   public void setCmed_cod(String string)
/* 144:    */   {
/* 145:129 */     this.cmed_cod = string;
/* 146:    */   }
/* 147:    */   
/* 148:    */   public void setCmed_destratamiento(String string)
/* 149:    */   {
/* 150:133 */     this.cmed_destratamiento = string;
/* 151:    */   }
/* 152:    */   
/* 153:    */   public void setCmed_direccion(String string)
/* 154:    */   {
/* 155:137 */     this.cmed_direccion = string;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public void setCmed_email(String string)
/* 159:    */   {
/* 160:141 */     this.cmed_email = string;
/* 161:    */   }
/* 162:    */   
/* 163:    */   public void setCmed_entidad(String string)
/* 164:    */   {
/* 165:145 */     this.cmed_entidad = string;
/* 166:    */   }
/* 167:    */   
/* 168:    */   public void setCmed_exa_cod(String string)
/* 169:    */   {
/* 170:149 */     this.cmed_exa_cod = string;
/* 171:    */   }
/* 172:    */   
/* 173:    */   public void setCmed_feccontrol(String string)
/* 174:    */   {
/* 175:153 */     this.cmed_feccontrol = string;
/* 176:    */   }
/* 177:    */   
/* 178:    */   public void setCmed_grup_cod(String string)
/* 179:    */   {
/* 180:157 */     this.cmed_grup_cod = string;
/* 181:    */   }
/* 182:    */   
/* 183:    */   public void setCmed_hora(String string)
/* 184:    */   {
/* 185:161 */     this.cmed_hora = string;
/* 186:    */   }
/* 187:    */   
/* 188:    */   public void setCmed_indciudad(String string)
/* 189:    */   {
/* 190:165 */     this.cmed_indciudad = string;
/* 191:    */   }
/* 192:    */   
/* 193:    */   public void setCmed_indpais(String string)
/* 194:    */   {
/* 195:169 */     this.cmed_indpais = string;
/* 196:    */   }
/* 197:    */   
/* 198:    */   public void setCmed_mails_enviados(String string)
/* 199:    */   {
/* 200:173 */     this.cmed_mails_enviados = string;
/* 201:    */   }
/* 202:    */   
/* 203:    */   public void setCmed_nommedico(String string)
/* 204:    */   {
/* 205:177 */     this.cmed_nommedico = string;
/* 206:    */   }
/* 207:    */   
/* 208:    */   public void setCmed_pais_cod(String string)
/* 209:    */   {
/* 210:181 */     this.cmed_pais_cod = string;
/* 211:    */   }
/* 212:    */   
/* 213:    */   public void setCmed_telefono(String string)
/* 214:    */   {
/* 215:185 */     this.cmed_telefono = string;
/* 216:    */   }
/* 217:    */   
/* 218:    */   public void setCmed_tipo(String string)
/* 219:    */   {
/* 220:189 */     this.cmed_tipo = string;
/* 221:    */   }
/* 222:    */   
/* 223:    */   public void setCmed_ultimo_mail(String string)
/* 224:    */   {
/* 225:193 */     this.cmed_ultimo_mail = string;
/* 226:    */   }
/* 227:    */   
/* 228:    */   public void setCmed_usuf_cod(String string)
/* 229:    */   {
/* 230:197 */     this.cmed_usuf_cod = string;
/* 231:    */   }
/* 232:    */   
/* 233:    */   public String getCmed_fecenvio2()
/* 234:    */   {
/* 235:201 */     return this.cmed_fecenvio2;
/* 236:    */   }
/* 237:    */   
/* 238:    */   public void setCmed_fecenvio2(String cmed_fecenvio2)
/* 239:    */   {
/* 240:205 */     this.cmed_fecenvio2 = cmed_fecenvio2;
/* 241:    */   }
/* 242:    */   
/* 243:    */   public String getCmed_fecenvion()
/* 244:    */   {
/* 245:209 */     return this.cmed_fecenvion;
/* 246:    */   }
/* 247:    */   
/* 248:    */   public void setCmed_fecenvion(String cmed_fecenvion)
/* 249:    */   {
/* 250:213 */     this.cmed_fecenvion = cmed_fecenvion;
/* 251:    */   }
/* 252:    */   
/* 253:    */   public String getCmed_fecenvion2()
/* 254:    */   {
/* 255:217 */     return this.cmed_fecenvion2;
/* 256:    */   }
/* 257:    */   
/* 258:    */   public void setCmed_fecenvion2(String cmed_fecenvion2)
/* 259:    */   {
/* 260:221 */     this.cmed_fecenvion2 = cmed_fecenvion2;
/* 261:    */   }
/* 262:    */   
/* 263:    */   public String getCmed_quince_dias()
/* 264:    */   {
/* 265:225 */     return this.cmed_quince_dias;
/* 266:    */   }
/* 267:    */   
/* 268:    */   public void setCmed_quince_dias(String cmed_quince_dias)
/* 269:    */   {
/* 270:229 */     this.cmed_quince_dias = cmed_quince_dias;
/* 271:    */   }
/* 272:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.controller.ControlMedicoForm
 * JD-Core Version:    0.7.0.1
 */