/*   1:    */ package com.servidoctor.sdfamily.model;
/*   2:    */ 
/*   3:    */ import java.math.BigDecimal;
/*   4:    */ 
/*   5:    */ public class ControlOtroPeriodico
/*   6:    */ {
/*   7:    */   private BigDecimal coot_cod;
/*   8:    */   private BigDecimal coot_usuf_cod;
/*   9:    */   private BigDecimal coot_fecha_ini;
/*  10:    */   private BigDecimal coot_fecha_fin;
/*  11:    */   private BigDecimal coot_hacer_cada;
/*  12:    */   private String coot_docnom;
/*  13:    */   private String coot_entidad;
/*  14:    */   private BigDecimal coot_pais_cod;
/*  15:    */   private BigDecimal coot_ciudad_cod;
/*  16:    */   private String coot_direccion;
/*  17:    */   private BigDecimal coot_indic_pais;
/*  18:    */   private BigDecimal coot_indic_ciudad;
/*  19:    */   private String coot_telefo;
/*  20:    */   private String coot_email;
/*  21:    */   private String coot_actividad;
/*  22:    */   private BigDecimal coot_mails_enviados;
/*  23:    */   private BigDecimal coot_ultimo_mail;
/*  24:    */   
/*  25:    */   public BigDecimal getCoot_ciudad_cod()
/*  26:    */   {
/*  27: 26 */     return this.coot_ciudad_cod;
/*  28:    */   }
/*  29:    */   
/*  30:    */   public void setCoot_ciudad_cod(BigDecimal coot_ciudad_cod)
/*  31:    */   {
/*  32: 30 */     this.coot_ciudad_cod = coot_ciudad_cod;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public BigDecimal getCoot_cod()
/*  36:    */   {
/*  37: 34 */     return this.coot_cod;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public void setCoot_cod(BigDecimal coot_cod)
/*  41:    */   {
/*  42: 38 */     this.coot_cod = coot_cod;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public String getCoot_direccion()
/*  46:    */   {
/*  47: 42 */     return this.coot_direccion;
/*  48:    */   }
/*  49:    */   
/*  50:    */   public void setCoot_direccion(String coot_direccion)
/*  51:    */   {
/*  52: 46 */     this.coot_direccion = coot_direccion;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public String getCoot_docnom()
/*  56:    */   {
/*  57: 50 */     return this.coot_docnom;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public void setCoot_docnom(String coot_docnom)
/*  61:    */   {
/*  62: 54 */     this.coot_docnom = coot_docnom;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public String getCoot_email()
/*  66:    */   {
/*  67: 58 */     return this.coot_email;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public void setCoot_email(String coot_email)
/*  71:    */   {
/*  72: 62 */     this.coot_email = coot_email;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public String getCoot_entidad()
/*  76:    */   {
/*  77: 66 */     return this.coot_entidad;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public void setCoot_entidad(String coot_entidad)
/*  81:    */   {
/*  82: 70 */     this.coot_entidad = coot_entidad;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public BigDecimal getCoot_fecha_fin()
/*  86:    */   {
/*  87: 74 */     return this.coot_fecha_fin;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public void setCoot_fecha_fin(BigDecimal coot_fecha_fin)
/*  91:    */   {
/*  92: 78 */     this.coot_fecha_fin = coot_fecha_fin;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public BigDecimal getCoot_fecha_ini()
/*  96:    */   {
/*  97: 82 */     return this.coot_fecha_ini;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public void setCoot_fecha_ini(BigDecimal coot_fecha_ini)
/* 101:    */   {
/* 102: 86 */     this.coot_fecha_ini = coot_fecha_ini;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public BigDecimal getCoot_hacer_cada()
/* 106:    */   {
/* 107: 90 */     return this.coot_hacer_cada;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public void setCoot_hacer_cada(BigDecimal coot_hacer_cada)
/* 111:    */   {
/* 112: 94 */     this.coot_hacer_cada = coot_hacer_cada;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public BigDecimal getCoot_indic_ciudad()
/* 116:    */   {
/* 117: 98 */     return this.coot_indic_ciudad;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public void setCoot_indic_ciudad(BigDecimal coot_indic_ciudad)
/* 121:    */   {
/* 122:102 */     this.coot_indic_ciudad = coot_indic_ciudad;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public BigDecimal getCoot_indic_pais()
/* 126:    */   {
/* 127:106 */     return this.coot_indic_pais;
/* 128:    */   }
/* 129:    */   
/* 130:    */   public void setCoot_indic_pais(BigDecimal coot_indic_pais)
/* 131:    */   {
/* 132:110 */     this.coot_indic_pais = coot_indic_pais;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public BigDecimal getCoot_pais_cod()
/* 136:    */   {
/* 137:114 */     return this.coot_pais_cod;
/* 138:    */   }
/* 139:    */   
/* 140:    */   public void setCoot_pais_cod(BigDecimal coot_pais_cod)
/* 141:    */   {
/* 142:118 */     this.coot_pais_cod = coot_pais_cod;
/* 143:    */   }
/* 144:    */   
/* 145:    */   public String getCoot_telefo()
/* 146:    */   {
/* 147:122 */     return this.coot_telefo;
/* 148:    */   }
/* 149:    */   
/* 150:    */   public void setCoot_telefo(String coot_telefo)
/* 151:    */   {
/* 152:126 */     this.coot_telefo = coot_telefo;
/* 153:    */   }
/* 154:    */   
/* 155:    */   public BigDecimal getCoot_usuf_cod()
/* 156:    */   {
/* 157:130 */     return this.coot_usuf_cod;
/* 158:    */   }
/* 159:    */   
/* 160:    */   public void setCoot_usuf_cod(BigDecimal coot_usu_cod)
/* 161:    */   {
/* 162:134 */     this.coot_usuf_cod = coot_usu_cod;
/* 163:    */   }
/* 164:    */   
/* 165:    */   public String getCoot_actividad()
/* 166:    */   {
/* 167:138 */     return this.coot_actividad;
/* 168:    */   }
/* 169:    */   
/* 170:    */   public void setCoot_actividad(String coot_actividad)
/* 171:    */   {
/* 172:142 */     this.coot_actividad = coot_actividad;
/* 173:    */   }
/* 174:    */   
/* 175:    */   public BigDecimal getCoot_mails_enviados()
/* 176:    */   {
/* 177:146 */     return this.coot_mails_enviados;
/* 178:    */   }
/* 179:    */   
/* 180:    */   public void setCoot_mails_enviados(BigDecimal coot_mails_enviados)
/* 181:    */   {
/* 182:150 */     this.coot_mails_enviados = coot_mails_enviados;
/* 183:    */   }
/* 184:    */   
/* 185:    */   public BigDecimal getCoot_ultimo_mail()
/* 186:    */   {
/* 187:154 */     return this.coot_ultimo_mail;
/* 188:    */   }
/* 189:    */   
/* 190:    */   public void setCoot_ultimo_mail(BigDecimal coot_ultimo_mail)
/* 191:    */   {
/* 192:158 */     this.coot_ultimo_mail = coot_ultimo_mail;
/* 193:    */   }
/* 194:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.model.ControlOtroPeriodico
 * JD-Core Version:    0.7.0.1
 */