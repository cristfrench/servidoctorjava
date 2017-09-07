/*   1:    */ package com.servidoctor.sdfamily.controller;
/*   2:    */ 
/*   3:    */ import org.apache.struts.validator.ValidatorForm;
/*   4:    */ 
/*   5:    */ public class ControlOdontologiaForm
/*   6:    */   extends ValidatorForm
/*   7:    */ {
/*   8: 15 */   private String codo_cod = "0";
/*   9: 16 */   private String codo_usuf_cod = "0";
/*  10:    */   private String codo_destratamiento;
/*  11: 18 */   private String codo_feccontrol = "";
/*  12: 19 */   private String codo_nommedico = "";
/*  13: 20 */   private String codo_pais_cod = "0";
/*  14: 21 */   private String codo_ciudad_cod = "0";
/*  15: 22 */   private String codo_telefono = "";
/*  16: 23 */   private String codo_email = "";
/*  17: 24 */   private String codo_tipo = "0";
/*  18: 25 */   private String codo_apemedico = "";
/*  19: 26 */   private String codo_direccion = "";
/*  20: 27 */   private String codo_entidad = "";
/*  21: 28 */   private String codo_indpais = "0";
/*  22: 29 */   private String codo_indciudad = "0";
/*  23: 30 */   private String codo_hora = "0";
/*  24: 31 */   private String codo_grup_cod = "0";
/*  25: 32 */   private String codo_mails_enviados = "0";
/*  26: 33 */   private String codo_ultimo_mail = "0";
/*  27: 34 */   private String codo_odo_cod = "0";
/*  28: 35 */   private String codo_fecenvion = "0";
/*  29: 36 */   private String codo_fecenvion2 = "0";
/*  30: 37 */   private String codo_fecenvio2 = "0";
/*  31: 38 */   private String codo_quince_dias = "0";
/*  32:    */   
/*  33:    */   public String getCodo_apemedico()
/*  34:    */   {
/*  35: 41 */     return this.codo_apemedico;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public String getCodo_ciudad_cod()
/*  39:    */   {
/*  40: 45 */     return this.codo_ciudad_cod;
/*  41:    */   }
/*  42:    */   
/*  43:    */   public String getCodo_cod()
/*  44:    */   {
/*  45: 49 */     return this.codo_cod;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public String getCodo_destratamiento()
/*  49:    */   {
/*  50: 53 */     return this.codo_destratamiento;
/*  51:    */   }
/*  52:    */   
/*  53:    */   public String getCodo_direccion()
/*  54:    */   {
/*  55: 57 */     return this.codo_direccion;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public String getCodo_email()
/*  59:    */   {
/*  60: 61 */     return this.codo_email;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public String getCodo_entidad()
/*  64:    */   {
/*  65: 65 */     return this.codo_entidad;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public String getCodo_feccontrol()
/*  69:    */   {
/*  70: 69 */     return this.codo_feccontrol;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public String getCodo_grup_cod()
/*  74:    */   {
/*  75: 73 */     return this.codo_grup_cod;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public String getCodo_hora()
/*  79:    */   {
/*  80: 77 */     return this.codo_hora;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public String getCodo_indciudad()
/*  84:    */   {
/*  85: 81 */     return this.codo_indciudad;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public String getCodo_indpais()
/*  89:    */   {
/*  90: 85 */     return this.codo_indpais;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public String getCodo_nommedico()
/*  94:    */   {
/*  95: 89 */     return this.codo_nommedico;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public String getCodo_pais_cod()
/*  99:    */   {
/* 100: 93 */     return this.codo_pais_cod;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public String getCodo_telefono()
/* 104:    */   {
/* 105: 97 */     return this.codo_telefono;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public String getCodo_tipo()
/* 109:    */   {
/* 110:101 */     return this.codo_tipo;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public String getCodo_usuf_cod()
/* 114:    */   {
/* 115:105 */     return this.codo_usuf_cod;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public void setCodo_apemedico(String string)
/* 119:    */   {
/* 120:109 */     this.codo_apemedico = string;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public void setCodo_ciudad_cod(String string)
/* 124:    */   {
/* 125:113 */     this.codo_ciudad_cod = string;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public void setCodo_cod(String string)
/* 129:    */   {
/* 130:117 */     this.codo_cod = string;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public void setCodo_destratamiento(String string)
/* 134:    */   {
/* 135:121 */     this.codo_destratamiento = string;
/* 136:    */   }
/* 137:    */   
/* 138:    */   public void setCodo_direccion(String string)
/* 139:    */   {
/* 140:125 */     this.codo_direccion = string;
/* 141:    */   }
/* 142:    */   
/* 143:    */   public void setCodo_email(String string)
/* 144:    */   {
/* 145:129 */     this.codo_email = string;
/* 146:    */   }
/* 147:    */   
/* 148:    */   public void setCodo_entidad(String string)
/* 149:    */   {
/* 150:133 */     this.codo_entidad = string;
/* 151:    */   }
/* 152:    */   
/* 153:    */   public void setCodo_feccontrol(String string)
/* 154:    */   {
/* 155:137 */     this.codo_feccontrol = string;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public void setCodo_grup_cod(String string)
/* 159:    */   {
/* 160:141 */     this.codo_grup_cod = string;
/* 161:    */   }
/* 162:    */   
/* 163:    */   public void setCodo_hora(String string)
/* 164:    */   {
/* 165:145 */     this.codo_hora = string;
/* 166:    */   }
/* 167:    */   
/* 168:    */   public void setCodo_indciudad(String string)
/* 169:    */   {
/* 170:149 */     this.codo_indciudad = string;
/* 171:    */   }
/* 172:    */   
/* 173:    */   public void setCodo_indpais(String string)
/* 174:    */   {
/* 175:153 */     this.codo_indpais = string;
/* 176:    */   }
/* 177:    */   
/* 178:    */   public void setCodo_nommedico(String string)
/* 179:    */   {
/* 180:157 */     this.codo_nommedico = string;
/* 181:    */   }
/* 182:    */   
/* 183:    */   public void setCodo_pais_cod(String string)
/* 184:    */   {
/* 185:161 */     this.codo_pais_cod = string;
/* 186:    */   }
/* 187:    */   
/* 188:    */   public void setCodo_telefono(String string)
/* 189:    */   {
/* 190:165 */     this.codo_telefono = string;
/* 191:    */   }
/* 192:    */   
/* 193:    */   public void setCodo_tipo(String string)
/* 194:    */   {
/* 195:169 */     this.codo_tipo = string;
/* 196:    */   }
/* 197:    */   
/* 198:    */   public void setCodo_usuf_cod(String string)
/* 199:    */   {
/* 200:173 */     this.codo_usuf_cod = string;
/* 201:    */   }
/* 202:    */   
/* 203:    */   public String getCodo_mails_enviados()
/* 204:    */   {
/* 205:177 */     return this.codo_mails_enviados;
/* 206:    */   }
/* 207:    */   
/* 208:    */   public String getCodo_ultimo_mail()
/* 209:    */   {
/* 210:181 */     return this.codo_ultimo_mail;
/* 211:    */   }
/* 212:    */   
/* 213:    */   public void setCodo_mails_enviados(String string)
/* 214:    */   {
/* 215:185 */     this.codo_mails_enviados = string;
/* 216:    */   }
/* 217:    */   
/* 218:    */   public void setCodo_ultimo_mail(String string)
/* 219:    */   {
/* 220:189 */     this.codo_ultimo_mail = string;
/* 221:    */   }
/* 222:    */   
/* 223:    */   public String getCodo_odo_cod()
/* 224:    */   {
/* 225:193 */     return this.codo_odo_cod;
/* 226:    */   }
/* 227:    */   
/* 228:    */   public void setCodo_odo_cod(String string)
/* 229:    */   {
/* 230:197 */     this.codo_odo_cod = string;
/* 231:    */   }
/* 232:    */   
/* 233:    */   public String getCodo_fecenvio2()
/* 234:    */   {
/* 235:201 */     return this.codo_fecenvio2;
/* 236:    */   }
/* 237:    */   
/* 238:    */   public void setCodo_fecenvio2(String codo_fecenvio2)
/* 239:    */   {
/* 240:205 */     this.codo_fecenvio2 = codo_fecenvio2;
/* 241:    */   }
/* 242:    */   
/* 243:    */   public String getCodo_fecenvion()
/* 244:    */   {
/* 245:209 */     return this.codo_fecenvion;
/* 246:    */   }
/* 247:    */   
/* 248:    */   public void setCodo_fecenvion(String codo_fecenvion)
/* 249:    */   {
/* 250:213 */     this.codo_fecenvion = codo_fecenvion;
/* 251:    */   }
/* 252:    */   
/* 253:    */   public String getCodo_fecenvion2()
/* 254:    */   {
/* 255:217 */     return this.codo_fecenvion2;
/* 256:    */   }
/* 257:    */   
/* 258:    */   public void setCodo_fecenvion2(String codo_fecenvion2)
/* 259:    */   {
/* 260:221 */     this.codo_fecenvion2 = codo_fecenvion2;
/* 261:    */   }
/* 262:    */   
/* 263:    */   public String getCodo_quince_dias()
/* 264:    */   {
/* 265:225 */     return this.codo_quince_dias;
/* 266:    */   }
/* 267:    */   
/* 268:    */   public void setCodo_quince_dias(String codo_quince_dias)
/* 269:    */   {
/* 270:229 */     this.codo_quince_dias = codo_quince_dias;
/* 271:    */   }
/* 272:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.controller.ControlOdontologiaForm
 * JD-Core Version:    0.7.0.1
 */