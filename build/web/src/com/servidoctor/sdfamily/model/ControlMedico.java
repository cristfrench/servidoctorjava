/*   1:    */ package com.servidoctor.sdfamily.model;
/*   2:    */ 
/*   3:    */ import java.math.BigDecimal;
/*   4:    */ 
/*   5:    */ public class ControlMedico
/*   6:    */ {
/*   7:    */   private BigDecimal cmed_cod;
/*   8:    */   private BigDecimal cmed_usuf_cod;
/*   9:    */   private String cmed_destratamiento;
/*  10:    */   private BigDecimal cmed_feccontrol;
/*  11:    */   private String cmed_nommedico;
/*  12:    */   private BigDecimal cmed_pais_cod;
/*  13:    */   private BigDecimal cmed_ciudad_cod;
/*  14:    */   private String cmed_telefono;
/*  15:    */   private String cmed_email;
/*  16:    */   private BigDecimal cmed_tipo;
/*  17:    */   private String cmed_apemedico;
/*  18:    */   private String cmed_direccion;
/*  19:    */   private String cmed_entidad;
/*  20:    */   private BigDecimal cmed_indpais;
/*  21:    */   private BigDecimal cmed_indciudad;
/*  22:    */   private BigDecimal cmed_hora;
/*  23:    */   private BigDecimal cmed_grup_cod;
/*  24:    */   private BigDecimal cmed_mails_enviados;
/*  25:    */   private BigDecimal cmed_ultimo_mail;
/*  26:    */   private BigDecimal cmed_exa_cod;
/*  27:    */   private BigDecimal cmed_fecenvio2;
/*  28:    */   private BigDecimal cmed_fecenvion;
/*  29:    */   private BigDecimal cmed_fecenvion2;
/*  30:    */   private BigDecimal cmed_quince_dias;
/*  31:    */   private ExamenesUsuario elementoTabla;
/*  32:    */   
/*  33:    */   public String getCmed_apemedico()
/*  34:    */   {
/*  35: 41 */     return this.cmed_apemedico;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public BigDecimal getCmed_ciudad_cod()
/*  39:    */   {
/*  40: 45 */     return this.cmed_ciudad_cod;
/*  41:    */   }
/*  42:    */   
/*  43:    */   public BigDecimal getCmed_cod()
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
/*  68:    */   public BigDecimal getCmed_feccontrol()
/*  69:    */   {
/*  70: 69 */     return this.cmed_feccontrol;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public BigDecimal getCmed_grup_cod()
/*  74:    */   {
/*  75: 73 */     return this.cmed_grup_cod;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public BigDecimal getCmed_hora()
/*  79:    */   {
/*  80: 77 */     return this.cmed_hora;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public BigDecimal getCmed_indciudad()
/*  84:    */   {
/*  85: 81 */     return this.cmed_indciudad;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public BigDecimal getCmed_indpais()
/*  89:    */   {
/*  90: 85 */     return this.cmed_indpais;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public String getCmed_nommedico()
/*  94:    */   {
/*  95: 89 */     return this.cmed_nommedico;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public BigDecimal getCmed_pais_cod()
/*  99:    */   {
/* 100: 93 */     return this.cmed_pais_cod;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public String getCmed_telefono()
/* 104:    */   {
/* 105: 97 */     return this.cmed_telefono;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public BigDecimal getCmed_tipo()
/* 109:    */   {
/* 110:101 */     return this.cmed_tipo;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public BigDecimal getCmed_usuf_cod()
/* 114:    */   {
/* 115:105 */     return this.cmed_usuf_cod;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public void setCmed_apemedico(String string)
/* 119:    */   {
/* 120:109 */     this.cmed_apemedico = string;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public void setCmed_ciudad_cod(BigDecimal decimal)
/* 124:    */   {
/* 125:113 */     this.cmed_ciudad_cod = decimal;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public void setCmed_cod(BigDecimal decimal)
/* 129:    */   {
/* 130:117 */     this.cmed_cod = decimal;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public void setCmed_destratamiento(String string)
/* 134:    */   {
/* 135:121 */     this.cmed_destratamiento = string;
/* 136:    */   }
/* 137:    */   
/* 138:    */   public void setCmed_direccion(String string)
/* 139:    */   {
/* 140:125 */     this.cmed_direccion = string;
/* 141:    */   }
/* 142:    */   
/* 143:    */   public void setCmed_email(String string)
/* 144:    */   {
/* 145:129 */     this.cmed_email = string;
/* 146:    */   }
/* 147:    */   
/* 148:    */   public void setCmed_entidad(String string)
/* 149:    */   {
/* 150:133 */     this.cmed_entidad = string;
/* 151:    */   }
/* 152:    */   
/* 153:    */   public void setCmed_feccontrol(BigDecimal decimal)
/* 154:    */   {
/* 155:137 */     this.cmed_feccontrol = decimal;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public void setCmed_grup_cod(BigDecimal decimal)
/* 159:    */   {
/* 160:141 */     this.cmed_grup_cod = decimal;
/* 161:    */   }
/* 162:    */   
/* 163:    */   public void setCmed_hora(BigDecimal decimal)
/* 164:    */   {
/* 165:145 */     this.cmed_hora = decimal;
/* 166:    */   }
/* 167:    */   
/* 168:    */   public void setCmed_indciudad(BigDecimal decimal)
/* 169:    */   {
/* 170:149 */     this.cmed_indciudad = decimal;
/* 171:    */   }
/* 172:    */   
/* 173:    */   public void setCmed_indpais(BigDecimal decimal)
/* 174:    */   {
/* 175:153 */     this.cmed_indpais = decimal;
/* 176:    */   }
/* 177:    */   
/* 178:    */   public void setCmed_nommedico(String string)
/* 179:    */   {
/* 180:157 */     this.cmed_nommedico = string;
/* 181:    */   }
/* 182:    */   
/* 183:    */   public void setCmed_pais_cod(BigDecimal decimal)
/* 184:    */   {
/* 185:161 */     this.cmed_pais_cod = decimal;
/* 186:    */   }
/* 187:    */   
/* 188:    */   public void setCmed_telefono(String string)
/* 189:    */   {
/* 190:165 */     this.cmed_telefono = string;
/* 191:    */   }
/* 192:    */   
/* 193:    */   public void setCmed_tipo(BigDecimal decimal)
/* 194:    */   {
/* 195:169 */     this.cmed_tipo = decimal;
/* 196:    */   }
/* 197:    */   
/* 198:    */   public void setCmed_usuf_cod(BigDecimal decimal)
/* 199:    */   {
/* 200:173 */     this.cmed_usuf_cod = decimal;
/* 201:    */   }
/* 202:    */   
/* 203:    */   public BigDecimal getCmed_mails_enviados()
/* 204:    */   {
/* 205:177 */     return this.cmed_mails_enviados;
/* 206:    */   }
/* 207:    */   
/* 208:    */   public BigDecimal getCmed_ultimo_mail()
/* 209:    */   {
/* 210:181 */     return this.cmed_ultimo_mail;
/* 211:    */   }
/* 212:    */   
/* 213:    */   public void setCmed_mails_enviados(BigDecimal decimal)
/* 214:    */   {
/* 215:185 */     this.cmed_mails_enviados = decimal;
/* 216:    */   }
/* 217:    */   
/* 218:    */   public void setCmed_ultimo_mail(BigDecimal decimal)
/* 219:    */   {
/* 220:189 */     this.cmed_ultimo_mail = decimal;
/* 221:    */   }
/* 222:    */   
/* 223:    */   public BigDecimal getCmed_exa_cod()
/* 224:    */   {
/* 225:193 */     return this.cmed_exa_cod;
/* 226:    */   }
/* 227:    */   
/* 228:    */   public void setCmed_exa_cod(BigDecimal decimal)
/* 229:    */   {
/* 230:197 */     this.cmed_exa_cod = decimal;
/* 231:    */   }
/* 232:    */   
/* 233:    */   public ExamenesUsuario getElementoTabla()
/* 234:    */   {
/* 235:201 */     return this.elementoTabla;
/* 236:    */   }
/* 237:    */   
/* 238:    */   public BigDecimal getCmed_fecenvio2()
/* 239:    */   {
/* 240:205 */     return this.cmed_fecenvio2;
/* 241:    */   }
/* 242:    */   
/* 243:    */   public void setCmed_fecenvio2(BigDecimal cmed_fecenvio2)
/* 244:    */   {
/* 245:209 */     this.cmed_fecenvio2 = cmed_fecenvio2;
/* 246:    */   }
/* 247:    */   
/* 248:    */   public BigDecimal getCmed_fecenvion()
/* 249:    */   {
/* 250:213 */     return this.cmed_fecenvion;
/* 251:    */   }
/* 252:    */   
/* 253:    */   public void setCmed_fecenvion(BigDecimal cmed_fecenvion)
/* 254:    */   {
/* 255:217 */     this.cmed_fecenvion = cmed_fecenvion;
/* 256:    */   }
/* 257:    */   
/* 258:    */   public BigDecimal getCmed_fecenvion2()
/* 259:    */   {
/* 260:221 */     return this.cmed_fecenvion2;
/* 261:    */   }
/* 262:    */   
/* 263:    */   public void setCmed_fecenvion2(BigDecimal cmed_fecenvion2)
/* 264:    */   {
/* 265:225 */     this.cmed_fecenvion2 = cmed_fecenvion2;
/* 266:    */   }
/* 267:    */   
/* 268:    */   public BigDecimal getCmed_quince_dias()
/* 269:    */   {
/* 270:229 */     return this.cmed_quince_dias;
/* 271:    */   }
/* 272:    */   
/* 273:    */   public void setCmed_quince_dias(BigDecimal cmed_quince_dias)
/* 274:    */   {
/* 275:233 */     this.cmed_quince_dias = cmed_quince_dias;
/* 276:    */   }
/* 277:    */   
/* 278:    */   public void setElementoTabla(ExamenesUsuario examenes)
/* 279:    */   {
/* 280:237 */     this.elementoTabla = examenes;
/* 281:238 */     this.cmed_cod = examenes.getExau_cod();
/* 282:239 */     this.cmed_exa_cod = examenes.getExau_exa_cod();
/* 283:240 */     this.cmed_usuf_cod = examenes.getExau_usuf_cod();
/* 284:241 */     this.cmed_destratamiento = examenes.getExau_des();
/* 285:    */   }
/* 286:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.model.ControlMedico
 * JD-Core Version:    0.7.0.1
 */