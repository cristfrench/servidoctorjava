/*   1:    */ package com.servidoctor.seguridad.model;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.math.BigDecimal;
/*   5:    */ import java.sql.Date;
/*   6:    */ 
/*   7:    */ public class Compras_merchant
/*   8:    */   implements Serializable
/*   9:    */ {
/*  10:    */   public static final String TIPO_CLIENTE_MAYOR = "m";
/*  11:    */   public static final String TIPO_CLIENTE_DETAL = "d";
/*  12:    */   private String compras_merchant_id;
/*  13:    */   private String compras_merchant_cdgcmp;
/*  14:    */   private String compras_merchant_cdgesp;
/*  15:    */   private String compras_merchant_nombre_apellido;
/*  16:    */   private String compras_merchant_tc;
/*  17:    */   private Date compras_merchant_datec;
/*  18:    */   private String compras_pais;
/*  19:    */   private String compras_dias_activar_mayor;
/*  20:    */   private String compras_merchant_date_aprob;
/*  21:    */   private String compras_margen_emision;
/*  22:    */   private BigDecimal server_id;
/*  23:    */   
/*  24:    */   public String getCompras_dias_activar_mayor()
/*  25:    */   {
/*  26: 35 */     return this.compras_dias_activar_mayor;
/*  27:    */   }
/*  28:    */   
/*  29:    */   public void setCompras_dias_activar_mayor(String comprasDiasActivarMayor)
/*  30:    */   {
/*  31: 39 */     this.compras_dias_activar_mayor = comprasDiasActivarMayor;
/*  32:    */   }
/*  33:    */   
/*  34:    */   public String getCompras_merchant_date_aprob()
/*  35:    */   {
/*  36: 43 */     return this.compras_merchant_date_aprob;
/*  37:    */   }
/*  38:    */   
/*  39:    */   public void setCompras_merchant_date_aprob(String comprasMerchantDateAprob)
/*  40:    */   {
/*  41: 47 */     this.compras_merchant_date_aprob = comprasMerchantDateAprob;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public String getCompras_margen_emision()
/*  45:    */   {
/*  46: 51 */     return this.compras_margen_emision;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public void setCompras_margen_emision(String comprasMargenEmision)
/*  50:    */   {
/*  51: 55 */     this.compras_margen_emision = comprasMargenEmision;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public String getCompras_pais()
/*  55:    */   {
/*  56: 60 */     return this.compras_pais;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public void setCompras_pais(String comprasPais)
/*  60:    */   {
/*  61: 64 */     this.compras_pais = comprasPais;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public String getCompras_merchant_cdgcmp()
/*  65:    */   {
/*  66: 70 */     return this.compras_merchant_cdgcmp;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public String getCompras_merchant_nombre_apellido()
/*  70:    */   {
/*  71: 74 */     return this.compras_merchant_nombre_apellido;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public String getCompras_merchant_tc()
/*  75:    */   {
/*  76: 78 */     return this.compras_merchant_tc;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void setCompras_merchant_cdgcmp(String string)
/*  80:    */   {
/*  81: 82 */     this.compras_merchant_cdgcmp = string;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public void setCompras_merchant_nombre_apellido(String string)
/*  85:    */   {
/*  86: 86 */     this.compras_merchant_nombre_apellido = string;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void setCompras_merchant_tc(String string)
/*  90:    */   {
/*  91: 90 */     this.compras_merchant_tc = string;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public String getCompras_merchant_cdgesp()
/*  95:    */   {
/*  96: 94 */     return this.compras_merchant_cdgesp;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public void setCompras_merchant_cdgesp(String compras_merchant_cdgesp)
/* 100:    */   {
/* 101: 98 */     this.compras_merchant_cdgesp = compras_merchant_cdgesp;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public String getCompras_merchant_id()
/* 105:    */   {
/* 106:102 */     return this.compras_merchant_id;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public void setCompras_merchant_id(String compras_merchant_id)
/* 110:    */   {
/* 111:106 */     this.compras_merchant_id = compras_merchant_id;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public Date getCompras_merchant_datec()
/* 115:    */   {
/* 116:110 */     return this.compras_merchant_datec;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public void setCompras_merchant_datec(Date compras_merchant_datec)
/* 120:    */   {
/* 121:114 */     this.compras_merchant_datec = compras_merchant_datec;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public BigDecimal getServer_id()
/* 125:    */   {
/* 126:117 */     return this.server_id;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public void setServer_id(BigDecimal sever_id)
/* 130:    */   {
/* 131:121 */     this.server_id = sever_id;
/* 132:    */   }
/* 133:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.seguridad.model.Compras_merchant
 * JD-Core Version:    0.7.0.1
 */