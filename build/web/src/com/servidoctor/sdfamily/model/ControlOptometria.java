/*   1:    */ package com.servidoctor.sdfamily.model;
/*   2:    */ 
/*   3:    */ import java.math.BigDecimal;
/*   4:    */ 
/*   5:    */ public class ControlOptometria
/*   6:    */ {
/*   7:    */   private BigDecimal copt_cod;
/*   8:    */   private BigDecimal copt_usuf_cod;
/*   9:    */   private BigDecimal copt_feccontrol;
/*  10:    */   private String copt_nommedico;
/*  11:    */   private BigDecimal copt_pais_cod;
/*  12:    */   private BigDecimal copt_ciudad_cod;
/*  13:    */   private String copt_telefono;
/*  14:    */   private String copt_email;
/*  15:    */   private BigDecimal copt_tipo;
/*  16:    */   private String copt_apemedico;
/*  17:    */   private String copt_direccion;
/*  18:    */   private String copt_entidad;
/*  19:    */   private BigDecimal copt_indpais;
/*  20:    */   private BigDecimal copt_indciudad;
/*  21:    */   private BigDecimal copt_horacontrol;
/*  22:    */   private BigDecimal copt_grup_cod;
/*  23:    */   private BigDecimal copt_mails_enviados;
/*  24:    */   private BigDecimal copt_ultimo_mail;
/*  25:    */   private BigDecimal copt_fecenvion;
/*  26:    */   private BigDecimal copt_fecenvion2;
/*  27:    */   private BigDecimal copt_fecenvio2;
/*  28:    */   private BigDecimal copt_quince_dias;
/*  29:    */   
/*  30:    */   public String getCopt_apemedico()
/*  31:    */   {
/*  32: 32 */     return this.copt_apemedico;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public BigDecimal getCopt_ciudad_cod()
/*  36:    */   {
/*  37: 35 */     return this.copt_ciudad_cod;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public BigDecimal getCopt_cod()
/*  41:    */   {
/*  42: 38 */     return this.copt_cod;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public String getCopt_direccion()
/*  46:    */   {
/*  47: 41 */     return this.copt_direccion;
/*  48:    */   }
/*  49:    */   
/*  50:    */   public String getCopt_email()
/*  51:    */   {
/*  52: 44 */     return this.copt_email;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public String getCopt_entidad()
/*  56:    */   {
/*  57: 47 */     return this.copt_entidad;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public BigDecimal getCopt_feccontrol()
/*  61:    */   {
/*  62: 50 */     return this.copt_feccontrol;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public BigDecimal getCopt_grup_cod()
/*  66:    */   {
/*  67: 53 */     return this.copt_grup_cod;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public BigDecimal getCopt_horacontrol()
/*  71:    */   {
/*  72: 56 */     return this.copt_horacontrol;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public BigDecimal getCopt_indciudad()
/*  76:    */   {
/*  77: 59 */     return this.copt_indciudad;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public BigDecimal getCopt_indpais()
/*  81:    */   {
/*  82: 62 */     return this.copt_indpais;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public BigDecimal getCopt_mails_enviados()
/*  86:    */   {
/*  87: 65 */     return this.copt_mails_enviados;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public String getCopt_nommedico()
/*  91:    */   {
/*  92: 68 */     return this.copt_nommedico;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public BigDecimal getCopt_pais_cod()
/*  96:    */   {
/*  97: 71 */     return this.copt_pais_cod;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public String getCopt_telefono()
/* 101:    */   {
/* 102: 74 */     return this.copt_telefono;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public BigDecimal getCopt_tipo()
/* 106:    */   {
/* 107: 77 */     return this.copt_tipo;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public BigDecimal getCopt_ultimo_mail()
/* 111:    */   {
/* 112: 80 */     return this.copt_ultimo_mail;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public BigDecimal getCopt_usuf_cod()
/* 116:    */   {
/* 117: 83 */     return this.copt_usuf_cod;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public void setCopt_apemedico(String copt_apemedico)
/* 121:    */   {
/* 122: 86 */     this.copt_apemedico = copt_apemedico;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public void setCopt_ciudad_cod(BigDecimal copt_ciudad_cod)
/* 126:    */   {
/* 127: 89 */     this.copt_ciudad_cod = copt_ciudad_cod;
/* 128:    */   }
/* 129:    */   
/* 130:    */   public void setCopt_cod(BigDecimal copt_cod)
/* 131:    */   {
/* 132: 92 */     this.copt_cod = copt_cod;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public void setCopt_direccion(String copt_direccion)
/* 136:    */   {
/* 137: 95 */     this.copt_direccion = copt_direccion;
/* 138:    */   }
/* 139:    */   
/* 140:    */   public void setCopt_email(String copt_email)
/* 141:    */   {
/* 142: 98 */     this.copt_email = copt_email;
/* 143:    */   }
/* 144:    */   
/* 145:    */   public void setCopt_entidad(String copt_entidad)
/* 146:    */   {
/* 147:101 */     this.copt_entidad = copt_entidad;
/* 148:    */   }
/* 149:    */   
/* 150:    */   public void setCopt_feccontrol(BigDecimal copt_feccontrol)
/* 151:    */   {
/* 152:104 */     this.copt_feccontrol = copt_feccontrol;
/* 153:    */   }
/* 154:    */   
/* 155:    */   public void setCopt_grup_cod(BigDecimal copt_grup_cod)
/* 156:    */   {
/* 157:107 */     this.copt_grup_cod = copt_grup_cod;
/* 158:    */   }
/* 159:    */   
/* 160:    */   public void setCopt_horacontrol(BigDecimal copt_horacontrol)
/* 161:    */   {
/* 162:110 */     this.copt_horacontrol = copt_horacontrol;
/* 163:    */   }
/* 164:    */   
/* 165:    */   public void setCopt_indciudad(BigDecimal copt_indciudad)
/* 166:    */   {
/* 167:113 */     this.copt_indciudad = copt_indciudad;
/* 168:    */   }
/* 169:    */   
/* 170:    */   public void setCopt_indpais(BigDecimal copt_indpais)
/* 171:    */   {
/* 172:116 */     this.copt_indpais = copt_indpais;
/* 173:    */   }
/* 174:    */   
/* 175:    */   public void setCopt_mails_enviados(BigDecimal copt_mails_enviados)
/* 176:    */   {
/* 177:119 */     this.copt_mails_enviados = copt_mails_enviados;
/* 178:    */   }
/* 179:    */   
/* 180:    */   public void setCopt_nommedico(String copt_nommedico)
/* 181:    */   {
/* 182:122 */     this.copt_nommedico = copt_nommedico;
/* 183:    */   }
/* 184:    */   
/* 185:    */   public void setCopt_pais_cod(BigDecimal copt_pais_cod)
/* 186:    */   {
/* 187:125 */     this.copt_pais_cod = copt_pais_cod;
/* 188:    */   }
/* 189:    */   
/* 190:    */   public void setCopt_telefono(String copt_telefono)
/* 191:    */   {
/* 192:128 */     this.copt_telefono = copt_telefono;
/* 193:    */   }
/* 194:    */   
/* 195:    */   public void setCopt_tipo(BigDecimal copt_tipo)
/* 196:    */   {
/* 197:131 */     this.copt_tipo = copt_tipo;
/* 198:    */   }
/* 199:    */   
/* 200:    */   public void setCopt_ultimo_mail(BigDecimal copt_ultimo_mail)
/* 201:    */   {
/* 202:134 */     this.copt_ultimo_mail = copt_ultimo_mail;
/* 203:    */   }
/* 204:    */   
/* 205:    */   public void setCopt_usuf_cod(BigDecimal copt_usuf_cod)
/* 206:    */   {
/* 207:137 */     this.copt_usuf_cod = copt_usuf_cod;
/* 208:    */   }
/* 209:    */   
/* 210:    */   public BigDecimal getCopt_fecenvio2()
/* 211:    */   {
/* 212:140 */     return this.copt_fecenvio2;
/* 213:    */   }
/* 214:    */   
/* 215:    */   public void setCopt_fecenvio2(BigDecimal copt_fecenvio2)
/* 216:    */   {
/* 217:143 */     this.copt_fecenvio2 = copt_fecenvio2;
/* 218:    */   }
/* 219:    */   
/* 220:    */   public BigDecimal getCopt_fecenvion()
/* 221:    */   {
/* 222:146 */     return this.copt_fecenvion;
/* 223:    */   }
/* 224:    */   
/* 225:    */   public void setCopt_fecenvion(BigDecimal copt_fecenvion)
/* 226:    */   {
/* 227:149 */     this.copt_fecenvion = copt_fecenvion;
/* 228:    */   }
/* 229:    */   
/* 230:    */   public BigDecimal getCopt_fecenvion2()
/* 231:    */   {
/* 232:152 */     return this.copt_fecenvion2;
/* 233:    */   }
/* 234:    */   
/* 235:    */   public void setCopt_fecenvion2(BigDecimal copt_fecenvion2)
/* 236:    */   {
/* 237:155 */     this.copt_fecenvion2 = copt_fecenvion2;
/* 238:    */   }
/* 239:    */   
/* 240:    */   public BigDecimal getCopt_quince_dias()
/* 241:    */   {
/* 242:158 */     return this.copt_quince_dias;
/* 243:    */   }
/* 244:    */   
/* 245:    */   public void setCopt_quince_dias(BigDecimal copt_quince_dias)
/* 246:    */   {
/* 247:161 */     this.copt_quince_dias = copt_quince_dias;
/* 248:    */   }
/* 249:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.model.ControlOptometria
 * JD-Core Version:    0.7.0.1
 */