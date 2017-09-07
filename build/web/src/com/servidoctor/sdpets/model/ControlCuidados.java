/*   1:    */ package com.servidoctor.sdpets.model;
/*   2:    */ 
/*   3:    */ import com.servidoctor.parametros.model.VacunasCuidados;
/*   4:    */ import java.math.BigDecimal;
/*   5:    */ 
/*   6:    */ public class ControlCuidados
/*   7:    */ {
/*   8:    */   private BigDecimal ccui_cod;
/*   9:    */   private BigDecimal ccui_mas_cod;
/*  10:    */   private String ccui_descripcion;
/*  11:    */   private BigDecimal ccui_fecultapli;
/*  12:    */   private BigDecimal ccui_fecproxapli;
/*  13:    */   private String ccui_vetnombre;
/*  14:    */   private BigDecimal ccui_pais_cod;
/*  15:    */   private BigDecimal ccui_ciu_cod;
/*  16:    */   private String ccui_email;
/*  17:    */   private String ccui_telefono;
/*  18:    */   private BigDecimal ccui_indciudad;
/*  19:    */   private BigDecimal ccui_indpais;
/*  20:    */   private String ccui_entidad;
/*  21:    */   private String ccui_direccion;
/*  22:    */   private BigDecimal ccui_raz_tipo;
/*  23:    */   private String ccui_vetdireccion;
/*  24:    */   private BigDecimal ccui_grup_cod;
/*  25:    */   private BigDecimal ccui_mails_enviados;
/*  26:    */   private BigDecimal ccui_ultimo_mail;
/*  27:    */   private BigDecimal ccui_vcui_cod;
/*  28:    */   private BigDecimal ccui_cita_prox;
/*  29:    */   private BigDecimal ccui_fecenvio2;
/*  30:    */   private BigDecimal ccui_fecenvion2;
/*  31:    */   private BigDecimal ccui_fecenvion;
/*  32:    */   private BigDecimal ccui_quince_dias;
/*  33:    */   private VacunasCuidados elementoTabla;
/*  34:    */   
/*  35:    */   public BigDecimal getCcui_ciu_cod()
/*  36:    */   {
/*  37: 44 */     return this.ccui_ciu_cod;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public BigDecimal getCcui_cod()
/*  41:    */   {
/*  42: 48 */     return this.ccui_cod;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public String getCcui_descripcion()
/*  46:    */   {
/*  47: 52 */     return this.ccui_descripcion;
/*  48:    */   }
/*  49:    */   
/*  50:    */   public String getCcui_direccion()
/*  51:    */   {
/*  52: 56 */     return this.ccui_direccion;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public String getCcui_email()
/*  56:    */   {
/*  57: 60 */     return this.ccui_email;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public String getCcui_entidad()
/*  61:    */   {
/*  62: 64 */     return this.ccui_entidad;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public BigDecimal getCcui_fecproxapli()
/*  66:    */   {
/*  67: 68 */     return this.ccui_fecproxapli;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public BigDecimal getCcui_fecultapli()
/*  71:    */   {
/*  72: 72 */     return this.ccui_fecultapli;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public BigDecimal getCcui_grup_cod()
/*  76:    */   {
/*  77: 76 */     return this.ccui_grup_cod;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public BigDecimal getCcui_indciudad()
/*  81:    */   {
/*  82: 80 */     return this.ccui_indciudad;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public BigDecimal getCcui_indpais()
/*  86:    */   {
/*  87: 84 */     return this.ccui_indpais;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public BigDecimal getCcui_mails_enviados()
/*  91:    */   {
/*  92: 88 */     return this.ccui_mails_enviados;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public BigDecimal getCcui_mas_cod()
/*  96:    */   {
/*  97: 92 */     return this.ccui_mas_cod;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public BigDecimal getCcui_pais_cod()
/* 101:    */   {
/* 102: 96 */     return this.ccui_pais_cod;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public BigDecimal getCcui_raz_tipo()
/* 106:    */   {
/* 107:100 */     return this.ccui_raz_tipo;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public String getCcui_telefono()
/* 111:    */   {
/* 112:104 */     return this.ccui_telefono;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public BigDecimal getCcui_ultimo_mail()
/* 116:    */   {
/* 117:108 */     return this.ccui_ultimo_mail;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public BigDecimal getCcui_vcui_cod()
/* 121:    */   {
/* 122:112 */     return this.ccui_vcui_cod;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public String getCcui_vetdireccion()
/* 126:    */   {
/* 127:116 */     return this.ccui_vetdireccion;
/* 128:    */   }
/* 129:    */   
/* 130:    */   public String getCcui_vetnombre()
/* 131:    */   {
/* 132:120 */     return this.ccui_vetnombre;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public void setCcui_ciu_cod(BigDecimal decimal)
/* 136:    */   {
/* 137:124 */     this.ccui_ciu_cod = decimal;
/* 138:    */   }
/* 139:    */   
/* 140:    */   public void setCcui_cod(BigDecimal decimal)
/* 141:    */   {
/* 142:128 */     this.ccui_cod = decimal;
/* 143:    */   }
/* 144:    */   
/* 145:    */   public void setCcui_descripcion(String string)
/* 146:    */   {
/* 147:132 */     this.ccui_descripcion = string;
/* 148:    */   }
/* 149:    */   
/* 150:    */   public void setCcui_direccion(String string)
/* 151:    */   {
/* 152:136 */     this.ccui_direccion = string;
/* 153:    */   }
/* 154:    */   
/* 155:    */   public void setCcui_email(String string)
/* 156:    */   {
/* 157:140 */     this.ccui_email = string;
/* 158:    */   }
/* 159:    */   
/* 160:    */   public void setCcui_entidad(String string)
/* 161:    */   {
/* 162:144 */     this.ccui_entidad = string;
/* 163:    */   }
/* 164:    */   
/* 165:    */   public void setCcui_fecproxapli(BigDecimal decimal)
/* 166:    */   {
/* 167:148 */     this.ccui_fecproxapli = decimal;
/* 168:    */   }
/* 169:    */   
/* 170:    */   public void setCcui_fecultapli(BigDecimal decimal)
/* 171:    */   {
/* 172:152 */     this.ccui_fecultapli = decimal;
/* 173:    */   }
/* 174:    */   
/* 175:    */   public void setCcui_grup_cod(BigDecimal decimal)
/* 176:    */   {
/* 177:156 */     this.ccui_grup_cod = decimal;
/* 178:    */   }
/* 179:    */   
/* 180:    */   public void setCcui_indciudad(BigDecimal decimal)
/* 181:    */   {
/* 182:160 */     this.ccui_indciudad = decimal;
/* 183:    */   }
/* 184:    */   
/* 185:    */   public void setCcui_indpais(BigDecimal decimal)
/* 186:    */   {
/* 187:164 */     this.ccui_indpais = decimal;
/* 188:    */   }
/* 189:    */   
/* 190:    */   public void setCcui_mails_enviados(BigDecimal decimal)
/* 191:    */   {
/* 192:168 */     this.ccui_mails_enviados = decimal;
/* 193:    */   }
/* 194:    */   
/* 195:    */   public void setCcui_mas_cod(BigDecimal decimal)
/* 196:    */   {
/* 197:172 */     this.ccui_mas_cod = decimal;
/* 198:    */   }
/* 199:    */   
/* 200:    */   public void setCcui_pais_cod(BigDecimal decimal)
/* 201:    */   {
/* 202:176 */     this.ccui_pais_cod = decimal;
/* 203:    */   }
/* 204:    */   
/* 205:    */   public void setCcui_raz_tipo(BigDecimal decimal)
/* 206:    */   {
/* 207:180 */     this.ccui_raz_tipo = decimal;
/* 208:    */   }
/* 209:    */   
/* 210:    */   public void setCcui_telefono(String string)
/* 211:    */   {
/* 212:184 */     this.ccui_telefono = string;
/* 213:    */   }
/* 214:    */   
/* 215:    */   public void setCcui_ultimo_mail(BigDecimal decimal)
/* 216:    */   {
/* 217:188 */     this.ccui_ultimo_mail = decimal;
/* 218:    */   }
/* 219:    */   
/* 220:    */   public void setCcui_vcui_cod(BigDecimal decimal)
/* 221:    */   {
/* 222:192 */     this.ccui_vcui_cod = decimal;
/* 223:    */   }
/* 224:    */   
/* 225:    */   public void setCcui_vetdireccion(String string)
/* 226:    */   {
/* 227:196 */     this.ccui_vetdireccion = string;
/* 228:    */   }
/* 229:    */   
/* 230:    */   public void setCcui_vetnombre(String string)
/* 231:    */   {
/* 232:200 */     this.ccui_vetnombre = string;
/* 233:    */   }
/* 234:    */   
/* 235:    */   public VacunasCuidados getElementoTabla()
/* 236:    */   {
/* 237:204 */     return this.elementoTabla;
/* 238:    */   }
/* 239:    */   
/* 240:    */   public void setElementoTabla(VacunasCuidados cuidados)
/* 241:    */   {
/* 242:208 */     this.elementoTabla = cuidados;
/* 243:209 */     this.ccui_descripcion = cuidados.getVcui_descripcion();
/* 244:210 */     this.ccui_vcui_cod = cuidados.getVcui_cod();
/* 245:211 */     this.ccui_mas_cod = cuidados.getVcui_mas_cod();
/* 246:    */   }
/* 247:    */   
/* 248:    */   public BigDecimal getCcui_cita_prox()
/* 249:    */   {
/* 250:215 */     return this.ccui_cita_prox;
/* 251:    */   }
/* 252:    */   
/* 253:    */   public void setCcui_cita_prox(BigDecimal decimal)
/* 254:    */   {
/* 255:219 */     this.ccui_cita_prox = decimal;
/* 256:    */   }
/* 257:    */   
/* 258:    */   public BigDecimal getCcui_fecenvio2()
/* 259:    */   {
/* 260:223 */     return this.ccui_fecenvio2;
/* 261:    */   }
/* 262:    */   
/* 263:    */   public void setCcui_fecenvio2(BigDecimal ccui_fecenvio2)
/* 264:    */   {
/* 265:227 */     this.ccui_fecenvio2 = ccui_fecenvio2;
/* 266:    */   }
/* 267:    */   
/* 268:    */   public BigDecimal getCcui_fecenvion()
/* 269:    */   {
/* 270:231 */     return this.ccui_fecenvion;
/* 271:    */   }
/* 272:    */   
/* 273:    */   public void setCcui_fecenvion(BigDecimal ccui_fecenvion)
/* 274:    */   {
/* 275:235 */     this.ccui_fecenvion = ccui_fecenvion;
/* 276:    */   }
/* 277:    */   
/* 278:    */   public BigDecimal getCcui_fecenvion2()
/* 279:    */   {
/* 280:239 */     return this.ccui_fecenvion2;
/* 281:    */   }
/* 282:    */   
/* 283:    */   public void setCcui_fecenvion2(BigDecimal ccui_fecenvion2)
/* 284:    */   {
/* 285:243 */     this.ccui_fecenvion2 = ccui_fecenvion2;
/* 286:    */   }
/* 287:    */   
/* 288:    */   public BigDecimal getCcui_quince_dias()
/* 289:    */   {
/* 290:247 */     return this.ccui_quince_dias;
/* 291:    */   }
/* 292:    */   
/* 293:    */   public void setCcui_quince_dias(BigDecimal ccui_quince_dias)
/* 294:    */   {
/* 295:251 */     this.ccui_quince_dias = ccui_quince_dias;
/* 296:    */   }
/* 297:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdpets.model.ControlCuidados
 * JD-Core Version:    0.7.0.1
 */