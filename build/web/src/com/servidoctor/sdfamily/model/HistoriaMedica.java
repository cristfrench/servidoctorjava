/*   1:    */ package com.servidoctor.sdfamily.model;
/*   2:    */ 
/*   3:    */ import java.util.ArrayList;
/*   4:    */ import java.util.List;
/*   5:    */ 
/*   6:    */ public class HistoriaMedica
/*   7:    */ {
/*   8:    */   private List elementosConsumo;
/*   9:    */   private List enfermedades;
/*  10:    */   private List antecedentes;
/*  11:    */   private List alergias;
/*  12:    */   private List cirujias;
/*  13:    */   private List partesCuerpo;
/*  14:    */   private List ginecologiaOperaciones;
/*  15:    */   private List elementosConsumoUsuario;
/*  16:    */   private List enfermedadesUsuario;
/*  17:    */   private List antecedentesUsuario;
/*  18:    */   private List alergiasUsuario;
/*  19:    */   private List cirujiasUsuario;
/*  20:    */   private List medicamentosUsuario;
/*  21:    */   private List partesCuerpoUsuario;
/*  22:    */   private Ginecologia ginecologia;
/*  23:    */   private List ginecologiaOperacionesUsuario;
/*  24:    */   
/*  25:    */   public List getElementosConsumoUsuario()
/*  26:    */   {
/*  27: 36 */     if (this.elementosConsumoUsuario == null) {
/*  28: 37 */       this.elementosConsumoUsuario = new ArrayList();
/*  29:    */     }
/*  30: 39 */     return this.elementosConsumoUsuario;
/*  31:    */   }
/*  32:    */   
/*  33:    */   public List getEnfermedadesUsuario()
/*  34:    */   {
/*  35: 43 */     if (this.enfermedadesUsuario == null) {
/*  36: 44 */       this.enfermedadesUsuario = new ArrayList();
/*  37:    */     }
/*  38: 46 */     return this.enfermedadesUsuario;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public void setElementosConsumoUsuario(List list)
/*  42:    */   {
/*  43: 50 */     this.elementosConsumoUsuario = list;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public void setEnfermedadesUsuario(List list)
/*  47:    */   {
/*  48: 55 */     this.enfermedadesUsuario = list;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public List getAntecedentesUsuario()
/*  52:    */   {
/*  53: 59 */     if (this.antecedentesUsuario == null) {
/*  54: 60 */       this.antecedentesUsuario = new ArrayList();
/*  55:    */     }
/*  56: 62 */     return this.antecedentesUsuario;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public void setAntecedentesUsuario(List list)
/*  60:    */   {
/*  61: 66 */     this.antecedentesUsuario = list;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public List getAlergiasUsuario()
/*  65:    */   {
/*  66: 70 */     if (this.alergiasUsuario == null) {
/*  67: 71 */       this.alergiasUsuario = new ArrayList();
/*  68:    */     }
/*  69: 73 */     return this.alergiasUsuario;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public void setAlergiasUsuario(List list)
/*  73:    */   {
/*  74: 77 */     this.alergiasUsuario = list;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public List getCirujiasUsuario()
/*  78:    */   {
/*  79: 81 */     if (this.cirujiasUsuario == null) {
/*  80: 82 */       this.cirujiasUsuario = new ArrayList();
/*  81:    */     }
/*  82: 84 */     return this.cirujiasUsuario;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public void setCirujiasUsuario(List list)
/*  86:    */   {
/*  87: 88 */     this.cirujiasUsuario = list;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public List getMedicamentosUsuario()
/*  91:    */   {
/*  92: 92 */     if (this.medicamentosUsuario == null) {
/*  93: 93 */       this.medicamentosUsuario = new ArrayList();
/*  94:    */     }
/*  95: 95 */     return this.medicamentosUsuario;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public void setMedicamentosUsuario(List list)
/*  99:    */   {
/* 100: 99 */     this.medicamentosUsuario = list;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public List getPartesCuerpoUsuario()
/* 104:    */   {
/* 105:103 */     if (this.partesCuerpoUsuario == null) {
/* 106:104 */       this.partesCuerpoUsuario = new ArrayList();
/* 107:    */     }
/* 108:106 */     return this.partesCuerpoUsuario;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public void setPartesCuerpoUsuario(List list)
/* 112:    */   {
/* 113:110 */     this.partesCuerpoUsuario = list;
/* 114:    */   }
/* 115:    */   
/* 116:    */   public Ginecologia getGinecologia()
/* 117:    */   {
/* 118:114 */     if (this.ginecologia == null) {
/* 119:115 */       this.ginecologia = new Ginecologia();
/* 120:    */     }
/* 121:117 */     return this.ginecologia;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public List getGinecologiaOperacionesUsuario()
/* 125:    */   {
/* 126:121 */     if (this.ginecologiaOperacionesUsuario == null) {
/* 127:122 */       this.ginecologiaOperacionesUsuario = new ArrayList();
/* 128:    */     }
/* 129:124 */     return this.ginecologiaOperacionesUsuario;
/* 130:    */   }
/* 131:    */   
/* 132:    */   public void setGinecologia(Ginecologia ginecologia)
/* 133:    */   {
/* 134:128 */     this.ginecologia = ginecologia;
/* 135:    */   }
/* 136:    */   
/* 137:    */   public void setGinecologiaOperacionesUsuario(List list)
/* 138:    */   {
/* 139:132 */     this.ginecologiaOperacionesUsuario = list;
/* 140:    */   }
/* 141:    */   
/* 142:    */   public List getElementosConsumo()
/* 143:    */   {
/* 144:136 */     if (this.elementosConsumo == null) {
/* 145:137 */       this.elementosConsumo = new ArrayList();
/* 146:    */     }
/* 147:139 */     return this.elementosConsumo;
/* 148:    */   }
/* 149:    */   
/* 150:    */   public void setElementosConsumo(List elementosConsumo)
/* 151:    */   {
/* 152:143 */     this.elementosConsumo = elementosConsumo;
/* 153:    */   }
/* 154:    */   
/* 155:    */   public List getEnfermedades()
/* 156:    */   {
/* 157:147 */     if (this.enfermedades == null) {
/* 158:148 */       this.enfermedades = new ArrayList();
/* 159:    */     }
/* 160:150 */     return this.enfermedades;
/* 161:    */   }
/* 162:    */   
/* 163:    */   public void setEnfermedades(List enfermedades)
/* 164:    */   {
/* 165:154 */     this.enfermedades = enfermedades;
/* 166:    */   }
/* 167:    */   
/* 168:    */   public List getAntecedentes()
/* 169:    */   {
/* 170:158 */     if (this.antecedentes == null) {
/* 171:159 */       this.antecedentes = new ArrayList();
/* 172:    */     }
/* 173:161 */     return this.antecedentes;
/* 174:    */   }
/* 175:    */   
/* 176:    */   public void setAntecedentes(List antecedentes)
/* 177:    */   {
/* 178:165 */     this.antecedentes = antecedentes;
/* 179:    */   }
/* 180:    */   
/* 181:    */   public List getAlergias()
/* 182:    */   {
/* 183:169 */     if (this.alergias == null) {
/* 184:170 */       this.alergias = new ArrayList();
/* 185:    */     }
/* 186:172 */     return this.alergias;
/* 187:    */   }
/* 188:    */   
/* 189:    */   public void setAlergias(List alergias)
/* 190:    */   {
/* 191:176 */     this.alergias = alergias;
/* 192:    */   }
/* 193:    */   
/* 194:    */   public List getCirujias()
/* 195:    */   {
/* 196:180 */     if (this.cirujias == null) {
/* 197:181 */       this.cirujias = new ArrayList();
/* 198:    */     }
/* 199:183 */     return this.cirujias;
/* 200:    */   }
/* 201:    */   
/* 202:    */   public void setCirujias(List cirujias)
/* 203:    */   {
/* 204:187 */     this.cirujias = cirujias;
/* 205:    */   }
/* 206:    */   
/* 207:    */   public List getPartesCuerpo()
/* 208:    */   {
/* 209:191 */     if (this.partesCuerpo == null) {
/* 210:192 */       this.partesCuerpo = new ArrayList();
/* 211:    */     }
/* 212:194 */     return this.partesCuerpo;
/* 213:    */   }
/* 214:    */   
/* 215:    */   public void setPartesCuerpo(List partesCuerpo)
/* 216:    */   {
/* 217:198 */     this.partesCuerpo = partesCuerpo;
/* 218:    */   }
/* 219:    */   
/* 220:    */   public List getGinecologiaOperaciones()
/* 221:    */   {
/* 222:202 */     if (this.ginecologiaOperaciones == null) {
/* 223:203 */       this.ginecologiaOperaciones = new ArrayList();
/* 224:    */     }
/* 225:205 */     return this.ginecologiaOperaciones;
/* 226:    */   }
/* 227:    */   
/* 228:    */   public void setGinecologiaOperaciones(List ginecologiaOperaciones)
/* 229:    */   {
/* 230:209 */     this.ginecologiaOperaciones = ginecologiaOperaciones;
/* 231:    */   }
/* 232:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.model.HistoriaMedica
 * JD-Core Version:    0.7.0.1
 */