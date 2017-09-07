/*   1:    */ package com.servidoctor.sdfamily.model;
/*   2:    */ 
/*   3:    */ import java.math.BigDecimal;
/*   4:    */ 
/*   5:    */ public class ControlOdontologia
/*   6:    */ {
/*   7:    */   private BigDecimal codo_cod;
/*   8:    */   private BigDecimal codo_usuf_cod;
/*   9:    */   private String codo_destratamiento;
/*  10:    */   private BigDecimal codo_feccontrol;
/*  11:    */   private String codo_nommedico;
/*  12:    */   private BigDecimal codo_pais_cod;
/*  13:    */   private BigDecimal codo_ciudad_cod;
/*  14:    */   private String codo_telefono;
/*  15:    */   private String codo_email;
/*  16:    */   private BigDecimal codo_tipo;
/*  17:    */   private String codo_apemedico;
/*  18:    */   private String codo_direccion;
/*  19:    */   private String codo_entidad;
/*  20:    */   private BigDecimal codo_indpais;
/*  21:    */   private BigDecimal codo_indciudad;
/*  22:    */   private BigDecimal codo_hora;
/*  23:    */   private BigDecimal codo_grup_cod;
/*  24:    */   private BigDecimal codo_mails_enviados;
/*  25:    */   private BigDecimal codo_ultimo_mail;
/*  26:    */   private BigDecimal codo_odo_cod;
/*  27:    */   private BigDecimal codo_fecenvion;
/*  28:    */   private BigDecimal codo_fecenvion2;
/*  29:    */   private BigDecimal codo_fecenvio2;
/*  30:    */   private BigDecimal codo_quince_dias;
/*  31:    */   private OdontologiaUsuario elementoTabla;
/*  32:    */   
/*  33:    */   public String getCodo_apemedico()
/*  34:    */   {
/*  35: 41 */     return this.codo_apemedico;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public BigDecimal getCodo_ciudad_cod()
/*  39:    */   {
/*  40: 45 */     return this.codo_ciudad_cod;
/*  41:    */   }
/*  42:    */   
/*  43:    */   public BigDecimal getCodo_cod()
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
/*  68:    */   public BigDecimal getCodo_feccontrol()
/*  69:    */   {
/*  70: 69 */     return this.codo_feccontrol;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public BigDecimal getCodo_grup_cod()
/*  74:    */   {
/*  75: 73 */     return this.codo_grup_cod;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public BigDecimal getCodo_hora()
/*  79:    */   {
/*  80: 77 */     return this.codo_hora;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public BigDecimal getCodo_indciudad()
/*  84:    */   {
/*  85: 81 */     return this.codo_indciudad;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public BigDecimal getCodo_indpais()
/*  89:    */   {
/*  90: 85 */     return this.codo_indpais;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public BigDecimal getCodo_mails_enviados()
/*  94:    */   {
/*  95: 89 */     return this.codo_mails_enviados;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public String getCodo_nommedico()
/*  99:    */   {
/* 100: 93 */     return this.codo_nommedico;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public BigDecimal getCodo_odo_cod()
/* 104:    */   {
/* 105: 97 */     return this.codo_odo_cod;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public BigDecimal getCodo_pais_cod()
/* 109:    */   {
/* 110:101 */     return this.codo_pais_cod;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public String getCodo_telefono()
/* 114:    */   {
/* 115:105 */     return this.codo_telefono;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public BigDecimal getCodo_tipo()
/* 119:    */   {
/* 120:109 */     return this.codo_tipo;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public BigDecimal getCodo_ultimo_mail()
/* 124:    */   {
/* 125:113 */     return this.codo_ultimo_mail;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public BigDecimal getCodo_usuf_cod()
/* 129:    */   {
/* 130:117 */     return this.codo_usuf_cod;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public void setCodo_apemedico(String codo_apemedico)
/* 134:    */   {
/* 135:121 */     this.codo_apemedico = codo_apemedico;
/* 136:    */   }
/* 137:    */   
/* 138:    */   public void setCodo_ciudad_cod(BigDecimal codo_ciudad_cod)
/* 139:    */   {
/* 140:125 */     this.codo_ciudad_cod = codo_ciudad_cod;
/* 141:    */   }
/* 142:    */   
/* 143:    */   public void setCodo_cod(BigDecimal codo_cod)
/* 144:    */   {
/* 145:129 */     this.codo_cod = codo_cod;
/* 146:    */   }
/* 147:    */   
/* 148:    */   public void setCodo_destratamiento(String codo_destratamiento)
/* 149:    */   {
/* 150:133 */     this.codo_destratamiento = codo_destratamiento;
/* 151:    */   }
/* 152:    */   
/* 153:    */   public void setCodo_direccion(String codo_direccion)
/* 154:    */   {
/* 155:137 */     this.codo_direccion = codo_direccion;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public void setCodo_email(String codo_email)
/* 159:    */   {
/* 160:141 */     this.codo_email = codo_email;
/* 161:    */   }
/* 162:    */   
/* 163:    */   public void setCodo_entidad(String codo_entidad)
/* 164:    */   {
/* 165:145 */     this.codo_entidad = codo_entidad;
/* 166:    */   }
/* 167:    */   
/* 168:    */   public void setCodo_feccontrol(BigDecimal codo_feccontrol)
/* 169:    */   {
/* 170:149 */     this.codo_feccontrol = codo_feccontrol;
/* 171:    */   }
/* 172:    */   
/* 173:    */   public void setCodo_grup_cod(BigDecimal codo_grup_cod)
/* 174:    */   {
/* 175:153 */     this.codo_grup_cod = codo_grup_cod;
/* 176:    */   }
/* 177:    */   
/* 178:    */   public void setCodo_hora(BigDecimal codo_hora)
/* 179:    */   {
/* 180:157 */     this.codo_hora = codo_hora;
/* 181:    */   }
/* 182:    */   
/* 183:    */   public void setCodo_indciudad(BigDecimal codo_indciudad)
/* 184:    */   {
/* 185:161 */     this.codo_indciudad = codo_indciudad;
/* 186:    */   }
/* 187:    */   
/* 188:    */   public void setCodo_indpais(BigDecimal codo_indpais)
/* 189:    */   {
/* 190:165 */     this.codo_indpais = codo_indpais;
/* 191:    */   }
/* 192:    */   
/* 193:    */   public void setCodo_mails_enviados(BigDecimal codo_mails_enviados)
/* 194:    */   {
/* 195:169 */     this.codo_mails_enviados = codo_mails_enviados;
/* 196:    */   }
/* 197:    */   
/* 198:    */   public void setCodo_nommedico(String codo_nommedico)
/* 199:    */   {
/* 200:173 */     this.codo_nommedico = codo_nommedico;
/* 201:    */   }
/* 202:    */   
/* 203:    */   public void setCodo_odo_cod(BigDecimal codo_odo_cod)
/* 204:    */   {
/* 205:177 */     this.codo_odo_cod = codo_odo_cod;
/* 206:    */   }
/* 207:    */   
/* 208:    */   public void setCodo_pais_cod(BigDecimal codo_pais_cod)
/* 209:    */   {
/* 210:181 */     this.codo_pais_cod = codo_pais_cod;
/* 211:    */   }
/* 212:    */   
/* 213:    */   public void setCodo_telefono(String codo_telefono)
/* 214:    */   {
/* 215:185 */     this.codo_telefono = codo_telefono;
/* 216:    */   }
/* 217:    */   
/* 218:    */   public void setCodo_tipo(BigDecimal codo_tipo)
/* 219:    */   {
/* 220:189 */     this.codo_tipo = codo_tipo;
/* 221:    */   }
/* 222:    */   
/* 223:    */   public void setCodo_ultimo_mail(BigDecimal codo_ultimo_mail)
/* 224:    */   {
/* 225:193 */     this.codo_ultimo_mail = codo_ultimo_mail;
/* 226:    */   }
/* 227:    */   
/* 228:    */   public void setCodo_usuf_cod(BigDecimal codo_usuf_cod)
/* 229:    */   {
/* 230:197 */     this.codo_usuf_cod = codo_usuf_cod;
/* 231:    */   }
/* 232:    */   
/* 233:    */   public OdontologiaUsuario getElementoTabla()
/* 234:    */   {
/* 235:201 */     return this.elementoTabla;
/* 236:    */   }
/* 237:    */   
/* 238:    */   public void setElementoTabla(OdontologiaUsuario odontologia)
/* 239:    */   {
/* 240:206 */     this.elementoTabla = odontologia;
/* 241:207 */     this.codo_cod = odontologia.getOdou_cod();
/* 242:208 */     this.codo_odo_cod = odontologia.getOdou_odo_cod();
/* 243:209 */     this.codo_usuf_cod = odontologia.getOdou_usuf_cod();
/* 244:210 */     this.codo_destratamiento = odontologia.getOdou_destratamiento();
/* 245:    */   }
/* 246:    */   
/* 247:    */   public BigDecimal getCodo_fecenvio2()
/* 248:    */   {
/* 249:214 */     return this.codo_fecenvio2;
/* 250:    */   }
/* 251:    */   
/* 252:    */   public void setCodo_fecenvio2(BigDecimal codo_fecenvio2)
/* 253:    */   {
/* 254:218 */     this.codo_fecenvio2 = codo_fecenvio2;
/* 255:    */   }
/* 256:    */   
/* 257:    */   public BigDecimal getCodo_fecenvion()
/* 258:    */   {
/* 259:222 */     return this.codo_fecenvion;
/* 260:    */   }
/* 261:    */   
/* 262:    */   public void setCodo_fecenvion(BigDecimal codo_fecenvion)
/* 263:    */   {
/* 264:226 */     this.codo_fecenvion = codo_fecenvion;
/* 265:    */   }
/* 266:    */   
/* 267:    */   public BigDecimal getCodo_fecenvion2()
/* 268:    */   {
/* 269:230 */     return this.codo_fecenvion2;
/* 270:    */   }
/* 271:    */   
/* 272:    */   public void setCodo_fecenvion2(BigDecimal codo_fecenvion2)
/* 273:    */   {
/* 274:234 */     this.codo_fecenvion2 = codo_fecenvion2;
/* 275:    */   }
/* 276:    */   
/* 277:    */   public BigDecimal getCodo_quince_dias()
/* 278:    */   {
/* 279:238 */     return this.codo_quince_dias;
/* 280:    */   }
/* 281:    */   
/* 282:    */   public void setCodo_quince_dias(BigDecimal codo_quince_dias)
/* 283:    */   {
/* 284:242 */     this.codo_quince_dias = codo_quince_dias;
/* 285:    */   }
/* 286:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.model.ControlOdontologia
 * JD-Core Version:    0.7.0.1
 */