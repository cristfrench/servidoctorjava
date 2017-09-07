/*   1:    */ package com.servidoctor.parametros.model;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.math.BigDecimal;
/*   5:    */ 
/*   6:    */ public class RevisionesVehiculo
/*   7:    */   implements Serializable
/*   8:    */ {
/*   9:    */   private BigDecimal rveh_cod;
/*  10:    */   private BigDecimal rveh_veh_cod;
/*  11:    */   private String rveh_actividad;
/*  12:    */   private BigDecimal rveh_acc_cod;
/*  13:    */   private BigDecimal rveh_alt_cod;
/*  14:    */   private BigDecimal rveh_cada_cdm;
/*  15:    */   private BigDecimal rveh_cada_cdk;
/*  16:    */   private BigDecimal rveh_control_fec;
/*  17:    */   private BigDecimal rveh_control_kms;
/*  18:    */   private BigDecimal rveh_control_1;
/*  19:    */   private BigDecimal rveh_control_2;
/*  20:    */   private BigDecimal rveh_control_3;
/*  21:    */   private BigDecimal rveh_control_4;
/*  22:    */   private BigDecimal rveh_registro;
/*  23:    */   private BigDecimal rveh_kmscero;
/*  24:    */   private BigDecimal rveh_kmscerodiferencia;
/*  25:    */   private BigDecimal rveh_bloqueado;
/*  26:    */   private BigDecimal rveh_mails_enviados;
/*  27:    */   
/*  28:    */   public BigDecimal getRveh_acc_cod()
/*  29:    */   {
/*  30: 35 */     return this.rveh_acc_cod;
/*  31:    */   }
/*  32:    */   
/*  33:    */   public void setRveh_acc_cod(BigDecimal rveh_acc_cod)
/*  34:    */   {
/*  35: 38 */     this.rveh_acc_cod = rveh_acc_cod;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public String getRveh_actividad()
/*  39:    */   {
/*  40: 41 */     return this.rveh_actividad;
/*  41:    */   }
/*  42:    */   
/*  43:    */   public void setRveh_actividad(String rveh_actividad)
/*  44:    */   {
/*  45: 44 */     this.rveh_actividad = rveh_actividad;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public BigDecimal getRveh_alt_cod()
/*  49:    */   {
/*  50: 47 */     return this.rveh_alt_cod;
/*  51:    */   }
/*  52:    */   
/*  53:    */   public void setRveh_alt_cod(BigDecimal rveh_alt_cod)
/*  54:    */   {
/*  55: 50 */     this.rveh_alt_cod = rveh_alt_cod;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public BigDecimal getRveh_cada_cdk()
/*  59:    */   {
/*  60: 53 */     return this.rveh_cada_cdk;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public void setRveh_cada_cdk(BigDecimal rveh_cada_cdk)
/*  64:    */   {
/*  65: 56 */     this.rveh_cada_cdk = rveh_cada_cdk;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public BigDecimal getRveh_cada_cdm()
/*  69:    */   {
/*  70: 59 */     return this.rveh_cada_cdm;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public void setRveh_cada_cdm(BigDecimal rveh_cada_cdm)
/*  74:    */   {
/*  75: 62 */     this.rveh_cada_cdm = rveh_cada_cdm;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public BigDecimal getRveh_cod()
/*  79:    */   {
/*  80: 65 */     return this.rveh_cod;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public void setRveh_cod(BigDecimal rveh_cod)
/*  84:    */   {
/*  85: 68 */     this.rveh_cod = rveh_cod;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public BigDecimal getRveh_control_1()
/*  89:    */   {
/*  90: 71 */     return this.rveh_control_1;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public void setRveh_control_1(BigDecimal rveh_control_1)
/*  94:    */   {
/*  95: 74 */     this.rveh_control_1 = rveh_control_1;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public BigDecimal getRveh_control_2()
/*  99:    */   {
/* 100: 77 */     return this.rveh_control_2;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public void setRveh_control_2(BigDecimal rveh_control_2)
/* 104:    */   {
/* 105: 80 */     this.rveh_control_2 = rveh_control_2;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public BigDecimal getRveh_control_3()
/* 109:    */   {
/* 110: 83 */     return this.rveh_control_3;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public void setRveh_control_3(BigDecimal rveh_control_3)
/* 114:    */   {
/* 115: 86 */     this.rveh_control_3 = rveh_control_3;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public BigDecimal getRveh_control_fec()
/* 119:    */   {
/* 120: 89 */     return this.rveh_control_fec;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public void setRveh_control_fec(BigDecimal rveh_control_fec)
/* 124:    */   {
/* 125: 92 */     this.rveh_control_fec = rveh_control_fec;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public BigDecimal getRveh_control_kms()
/* 129:    */   {
/* 130: 95 */     return this.rveh_control_kms;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public void setRveh_control_kms(BigDecimal rveh_control_kms)
/* 134:    */   {
/* 135: 98 */     this.rveh_control_kms = rveh_control_kms;
/* 136:    */   }
/* 137:    */   
/* 138:    */   public BigDecimal getRveh_mails_enviados()
/* 139:    */   {
/* 140:101 */     return this.rveh_mails_enviados;
/* 141:    */   }
/* 142:    */   
/* 143:    */   public void setRveh_mails_enviados(BigDecimal rveh_mails_enviados)
/* 144:    */   {
/* 145:104 */     this.rveh_mails_enviados = rveh_mails_enviados;
/* 146:    */   }
/* 147:    */   
/* 148:    */   public BigDecimal getRveh_veh_cod()
/* 149:    */   {
/* 150:107 */     return this.rveh_veh_cod;
/* 151:    */   }
/* 152:    */   
/* 153:    */   public void setRveh_veh_cod(BigDecimal rveh_veh_cod)
/* 154:    */   {
/* 155:110 */     this.rveh_veh_cod = rveh_veh_cod;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public BigDecimal getRveh_control_4()
/* 159:    */   {
/* 160:113 */     return this.rveh_control_4;
/* 161:    */   }
/* 162:    */   
/* 163:    */   public void setRveh_control_4(BigDecimal rveh_control_4)
/* 164:    */   {
/* 165:116 */     this.rveh_control_4 = rveh_control_4;
/* 166:    */   }
/* 167:    */   
/* 168:    */   public BigDecimal getRveh_registro()
/* 169:    */   {
/* 170:119 */     return this.rveh_registro;
/* 171:    */   }
/* 172:    */   
/* 173:    */   public void setRveh_registro(BigDecimal rveh_registro)
/* 174:    */   {
/* 175:122 */     this.rveh_registro = rveh_registro;
/* 176:    */   }
/* 177:    */   
/* 178:    */   public BigDecimal getRveh_kmscero()
/* 179:    */   {
/* 180:125 */     return this.rveh_kmscero;
/* 181:    */   }
/* 182:    */   
/* 183:    */   public void setRveh_kmscero(BigDecimal rveh_kmscero)
/* 184:    */   {
/* 185:128 */     this.rveh_kmscero = rveh_kmscero;
/* 186:    */   }
/* 187:    */   
/* 188:    */   public BigDecimal getRveh_kmscerodiferencia()
/* 189:    */   {
/* 190:131 */     return this.rveh_kmscerodiferencia;
/* 191:    */   }
/* 192:    */   
/* 193:    */   public void setRveh_kmscerodiferencia(BigDecimal rveh_kmscerodiferencia)
/* 194:    */   {
/* 195:134 */     this.rveh_kmscerodiferencia = rveh_kmscerodiferencia;
/* 196:    */   }
/* 197:    */   
/* 198:    */   public BigDecimal getRveh_bloqueado()
/* 199:    */   {
/* 200:137 */     return this.rveh_bloqueado;
/* 201:    */   }
/* 202:    */   
/* 203:    */   public void setRveh_bloqueado(BigDecimal rveh_bloqueado)
/* 204:    */   {
/* 205:140 */     this.rveh_bloqueado = rveh_bloqueado;
/* 206:    */   }
/* 207:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.model.RevisionesVehiculo
 * JD-Core Version:    0.7.0.1
 */