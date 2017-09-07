/*   1:    */ package com.servidoctor.sdcars.model;
/*   2:    */ 
/*   3:    */ import java.math.BigDecimal;
/*   4:    */ 
/*   5:    */ public class ImpuestoVehiculo
/*   6:    */ {
/*   7:    */   private BigDecimal impv_cod;
/*   8:    */   private BigDecimal impv_veh_cod;
/*   9:    */   private BigDecimal impv_fechapago;
/*  10:    */   private BigDecimal impv_vigenciahasta;
/*  11:    */   private String impv_descripcion;
/*  12:    */   private BigDecimal impv_grup_cod;
/*  13:    */   private BigDecimal impv_mails_enviados;
/*  14:    */   private BigDecimal impv_fecenvio2;
/*  15:    */   private BigDecimal impv_fecenvion2;
/*  16:    */   private BigDecimal impv_fecenvion;
/*  17:    */   private BigDecimal impv_quince_dias;
/*  18:    */   private BigDecimal impv_ultimo_mail;
/*  19:    */   
/*  20:    */   public BigDecimal getImpv_cod()
/*  21:    */   {
/*  22: 20 */     return this.impv_cod;
/*  23:    */   }
/*  24:    */   
/*  25:    */   public String getImpv_descripcion()
/*  26:    */   {
/*  27: 24 */     return this.impv_descripcion;
/*  28:    */   }
/*  29:    */   
/*  30:    */   public BigDecimal getImpv_fechapago()
/*  31:    */   {
/*  32: 28 */     return this.impv_fechapago;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public BigDecimal getImpv_veh_cod()
/*  36:    */   {
/*  37: 32 */     return this.impv_veh_cod;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public BigDecimal getImpv_vigenciahasta()
/*  41:    */   {
/*  42: 36 */     return this.impv_vigenciahasta;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public void setImpv_cod(BigDecimal decimal)
/*  46:    */   {
/*  47: 40 */     this.impv_cod = decimal;
/*  48:    */   }
/*  49:    */   
/*  50:    */   public void setImpv_descripcion(String string)
/*  51:    */   {
/*  52: 44 */     this.impv_descripcion = string;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public void setImpv_fechapago(BigDecimal decimal)
/*  56:    */   {
/*  57: 48 */     this.impv_fechapago = decimal;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public void setImpv_veh_cod(BigDecimal decimal)
/*  61:    */   {
/*  62: 52 */     this.impv_veh_cod = decimal;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public void setImpv_vigenciahasta(BigDecimal decimal)
/*  66:    */   {
/*  67: 56 */     this.impv_vigenciahasta = decimal;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public BigDecimal getImpv_grup_cod()
/*  71:    */   {
/*  72: 60 */     return this.impv_grup_cod;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public BigDecimal getImpv_mails_enviados()
/*  76:    */   {
/*  77: 64 */     return this.impv_mails_enviados;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public BigDecimal getImpv_ultimo_mail()
/*  81:    */   {
/*  82: 68 */     return this.impv_ultimo_mail;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public void setImpv_grup_cod(BigDecimal impv_grup_cod)
/*  86:    */   {
/*  87: 72 */     this.impv_grup_cod = impv_grup_cod;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public void setImpv_mails_enviados(BigDecimal impv_mails_enviados)
/*  91:    */   {
/*  92: 76 */     this.impv_mails_enviados = impv_mails_enviados;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public void setImpv_ultimo_mail(BigDecimal impv_ultimo_mail)
/*  96:    */   {
/*  97: 80 */     this.impv_ultimo_mail = impv_ultimo_mail;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public BigDecimal getImpv_fecenvio2()
/* 101:    */   {
/* 102: 84 */     return this.impv_fecenvio2;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public void setImpv_fecenvio2(BigDecimal impv_fecenvio2)
/* 106:    */   {
/* 107: 88 */     this.impv_fecenvio2 = impv_fecenvio2;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public BigDecimal getImpv_fecenvion()
/* 111:    */   {
/* 112: 92 */     return this.impv_fecenvion;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public void setImpv_fecenvion(BigDecimal impv_fecenvion)
/* 116:    */   {
/* 117: 96 */     this.impv_fecenvion = impv_fecenvion;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public BigDecimal getImpv_fecenvion2()
/* 121:    */   {
/* 122:100 */     return this.impv_fecenvion2;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public void setImpv_fecenvion2(BigDecimal impv_fecenvion2)
/* 126:    */   {
/* 127:104 */     this.impv_fecenvion2 = impv_fecenvion2;
/* 128:    */   }
/* 129:    */   
/* 130:    */   public BigDecimal getImpv_quince_dias()
/* 131:    */   {
/* 132:108 */     return this.impv_quince_dias;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public void setImpv_quince_dias(BigDecimal impv_quince_dias)
/* 136:    */   {
/* 137:112 */     this.impv_quince_dias = impv_quince_dias;
/* 138:    */   }
/* 139:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdcars.model.ImpuestoVehiculo
 * JD-Core Version:    0.7.0.1
 */