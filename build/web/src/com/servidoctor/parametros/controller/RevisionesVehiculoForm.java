/*   1:    */ package com.servidoctor.parametros.controller;
/*   2:    */ 
/*   3:    */ import org.apache.struts.validator.ValidatorForm;
/*   4:    */ 
/*   5:    */ public class RevisionesVehiculoForm
/*   6:    */   extends ValidatorForm
/*   7:    */ {
/*   8: 15 */   private String rveh_cod = "0";
/*   9: 16 */   private String rveh_veh_cod = "0";
/*  10: 17 */   private String rveh_actividad = "";
/*  11: 18 */   private String rveh_acc_cod = "0";
/*  12: 19 */   private String rveh_alt_cod = "0";
/*  13: 20 */   private String rveh_cada_cdm = "0";
/*  14: 21 */   private String rveh_cada_cdk = "0";
/*  15: 22 */   private String rveh_control_fec = "0";
/*  16: 23 */   private String rveh_control_kms = "0";
/*  17: 24 */   private String rveh_control_1 = "0";
/*  18: 25 */   private String rveh_control_2 = "0";
/*  19: 26 */   private String rveh_control_3 = "0";
/*  20: 27 */   private String rveh_control_4 = "0";
/*  21: 28 */   private String rveh_registro = "0";
/*  22: 29 */   private String rveh_mails_enviados = "0";
/*  23:    */   
/*  24:    */   public String getRveh_acc_cod()
/*  25:    */   {
/*  26: 33 */     return this.rveh_acc_cod;
/*  27:    */   }
/*  28:    */   
/*  29:    */   public String getRveh_actividad()
/*  30:    */   {
/*  31: 36 */     return this.rveh_actividad;
/*  32:    */   }
/*  33:    */   
/*  34:    */   public String getRveh_alt_cod()
/*  35:    */   {
/*  36: 39 */     return this.rveh_alt_cod;
/*  37:    */   }
/*  38:    */   
/*  39:    */   public String getRveh_cada_cdk()
/*  40:    */   {
/*  41: 42 */     return this.rveh_cada_cdk;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public String getRveh_cada_cdm()
/*  45:    */   {
/*  46: 45 */     return this.rveh_cada_cdm;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public String getRveh_cod()
/*  50:    */   {
/*  51: 48 */     return this.rveh_cod;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public String getRveh_control_1()
/*  55:    */   {
/*  56: 51 */     return this.rveh_control_1;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public String getRveh_control_2()
/*  60:    */   {
/*  61: 54 */     return this.rveh_control_2;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public String getRveh_control_3()
/*  65:    */   {
/*  66: 57 */     return this.rveh_control_3;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public String getRveh_control_fec()
/*  70:    */   {
/*  71: 60 */     return this.rveh_control_fec;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public String getRveh_control_kms()
/*  75:    */   {
/*  76: 63 */     return this.rveh_control_kms;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public String getRveh_mails_enviados()
/*  80:    */   {
/*  81: 66 */     return this.rveh_mails_enviados;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public String getRveh_veh_cod()
/*  85:    */   {
/*  86: 69 */     return this.rveh_veh_cod;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void setRveh_acc_cod(String rveh_acc_cod)
/*  90:    */   {
/*  91: 72 */     this.rveh_acc_cod = rveh_acc_cod;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public void setRveh_actividad(String rveh_actividad)
/*  95:    */   {
/*  96: 75 */     this.rveh_actividad = rveh_actividad;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public void setRveh_alt_cod(String rveh_alt_cod)
/* 100:    */   {
/* 101: 78 */     this.rveh_alt_cod = rveh_alt_cod;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public void setRveh_cada_cdk(String rveh_cada_cdk)
/* 105:    */   {
/* 106: 81 */     this.rveh_cada_cdk = rveh_cada_cdk;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public void setRveh_cada_cdm(String rveh_cada_cdm)
/* 110:    */   {
/* 111: 84 */     this.rveh_cada_cdm = rveh_cada_cdm;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public void setRveh_cod(String rveh_cod)
/* 115:    */   {
/* 116: 87 */     this.rveh_cod = rveh_cod;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public void setRveh_control_1(String rveh_control_1)
/* 120:    */   {
/* 121: 90 */     this.rveh_control_1 = rveh_control_1;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public void setRveh_control_2(String rveh_control_2)
/* 125:    */   {
/* 126: 93 */     this.rveh_control_2 = rveh_control_2;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public void setRveh_control_3(String rveh_control_3)
/* 130:    */   {
/* 131: 96 */     this.rveh_control_3 = rveh_control_3;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public void setRveh_control_fec(String rveh_control_fec)
/* 135:    */   {
/* 136: 99 */     this.rveh_control_fec = rveh_control_fec;
/* 137:    */   }
/* 138:    */   
/* 139:    */   public void setRveh_control_kms(String rveh_control_kms)
/* 140:    */   {
/* 141:102 */     this.rveh_control_kms = rveh_control_kms;
/* 142:    */   }
/* 143:    */   
/* 144:    */   public void setRveh_mails_enviados(String rveh_mails_enviados)
/* 145:    */   {
/* 146:105 */     this.rveh_mails_enviados = rveh_mails_enviados;
/* 147:    */   }
/* 148:    */   
/* 149:    */   public void setRveh_veh_cod(String rveh_veh_cod)
/* 150:    */   {
/* 151:108 */     this.rveh_veh_cod = rveh_veh_cod;
/* 152:    */   }
/* 153:    */   
/* 154:    */   public String getRveh_control_4()
/* 155:    */   {
/* 156:111 */     return this.rveh_control_4;
/* 157:    */   }
/* 158:    */   
/* 159:    */   public void setRveh_control_4(String rveh_control_4)
/* 160:    */   {
/* 161:114 */     this.rveh_control_4 = rveh_control_4;
/* 162:    */   }
/* 163:    */   
/* 164:    */   public String getRveh_registro()
/* 165:    */   {
/* 166:117 */     return this.rveh_registro;
/* 167:    */   }
/* 168:    */   
/* 169:    */   public void setRveh_registro(String rveh_registro)
/* 170:    */   {
/* 171:120 */     this.rveh_registro = rveh_registro;
/* 172:    */   }
/* 173:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.controller.RevisionesVehiculoForm
 * JD-Core Version:    0.7.0.1
 */