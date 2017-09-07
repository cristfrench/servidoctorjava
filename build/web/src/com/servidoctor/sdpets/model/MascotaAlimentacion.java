/*   1:    */ package com.servidoctor.sdpets.model;
/*   2:    */ 
/*   3:    */ import java.math.BigDecimal;
/*   4:    */ 
/*   5:    */ public class MascotaAlimentacion
/*   6:    */ {
/*   7:    */   private BigDecimal mali_cod;
/*   8:    */   private BigDecimal mali_mas_cod;
/*   9:    */   private BigDecimal mali_fecultpeso;
/*  10:    */   private BigDecimal mali_tipocomida;
/*  11:    */   private String mali_fabricante;
/*  12:    */   private BigDecimal mali_peso;
/*  13:    */   private BigDecimal mali_grxdosis;
/*  14:    */   private BigDecimal mali_dosisxdia;
/*  15:    */   private String mali_tipo;
/*  16:    */   private BigDecimal mali_pesomascota;
/*  17:    */   private BigDecimal mali_pesominveterinario;
/*  18:    */   private BigDecimal mali_pesomaxveterinario;
/*  19:    */   private BigDecimal mali_unidadpais;
/*  20:    */   
/*  21:    */   public BigDecimal getMali_cod()
/*  22:    */   {
/*  23: 21 */     return this.mali_cod;
/*  24:    */   }
/*  25:    */   
/*  26:    */   public BigDecimal getMali_dosisxdia()
/*  27:    */   {
/*  28: 25 */     return this.mali_dosisxdia;
/*  29:    */   }
/*  30:    */   
/*  31:    */   public String getMali_fabricante()
/*  32:    */   {
/*  33: 29 */     return this.mali_fabricante;
/*  34:    */   }
/*  35:    */   
/*  36:    */   public BigDecimal getMali_fecultpeso()
/*  37:    */   {
/*  38: 33 */     return this.mali_fecultpeso;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public BigDecimal getMali_grxdosis()
/*  42:    */   {
/*  43: 37 */     return this.mali_grxdosis;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public BigDecimal getMali_mas_cod()
/*  47:    */   {
/*  48: 41 */     return this.mali_mas_cod;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public BigDecimal getMali_peso()
/*  52:    */   {
/*  53: 45 */     return this.mali_peso;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public BigDecimal getMali_pesomascota()
/*  57:    */   {
/*  58: 49 */     return this.mali_pesomascota;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public BigDecimal getMali_pesomaxveterinario()
/*  62:    */   {
/*  63: 53 */     return this.mali_pesomaxveterinario;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public BigDecimal getMali_pesominveterinario()
/*  67:    */   {
/*  68: 57 */     return this.mali_pesominveterinario;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public String getMali_tipo()
/*  72:    */   {
/*  73: 61 */     return this.mali_tipo;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public BigDecimal getMali_tipocomida()
/*  77:    */   {
/*  78: 65 */     return this.mali_tipocomida;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public BigDecimal getMali_unidadpais()
/*  82:    */   {
/*  83: 69 */     return this.mali_unidadpais;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public void setMali_cod(BigDecimal decimal)
/*  87:    */   {
/*  88: 73 */     this.mali_cod = decimal;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public void setMali_dosisxdia(BigDecimal decimal)
/*  92:    */   {
/*  93: 77 */     this.mali_dosisxdia = decimal;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public void setMali_fabricante(String string)
/*  97:    */   {
/*  98: 81 */     this.mali_fabricante = string;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public void setMali_fecultpeso(BigDecimal decimal)
/* 102:    */   {
/* 103: 85 */     this.mali_fecultpeso = decimal;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public void setMali_grxdosis(BigDecimal decimal)
/* 107:    */   {
/* 108: 89 */     this.mali_grxdosis = decimal;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public void setMali_mas_cod(BigDecimal decimal)
/* 112:    */   {
/* 113: 93 */     this.mali_mas_cod = decimal;
/* 114:    */   }
/* 115:    */   
/* 116:    */   public void setMali_peso(BigDecimal decimal)
/* 117:    */   {
/* 118: 97 */     this.mali_peso = decimal;
/* 119:    */   }
/* 120:    */   
/* 121:    */   public void setMali_pesomascota(BigDecimal decimal)
/* 122:    */   {
/* 123:101 */     this.mali_pesomascota = decimal;
/* 124:    */   }
/* 125:    */   
/* 126:    */   public void setMali_pesomaxveterinario(BigDecimal decimal)
/* 127:    */   {
/* 128:105 */     this.mali_pesomaxveterinario = decimal;
/* 129:    */   }
/* 130:    */   
/* 131:    */   public void setMali_pesominveterinario(BigDecimal decimal)
/* 132:    */   {
/* 133:109 */     this.mali_pesominveterinario = decimal;
/* 134:    */   }
/* 135:    */   
/* 136:    */   public void setMali_tipo(String string)
/* 137:    */   {
/* 138:113 */     this.mali_tipo = string;
/* 139:    */   }
/* 140:    */   
/* 141:    */   public void setMali_tipocomida(BigDecimal decimal)
/* 142:    */   {
/* 143:117 */     this.mali_tipocomida = decimal;
/* 144:    */   }
/* 145:    */   
/* 146:    */   public void setMali_unidadpais(BigDecimal decimal)
/* 147:    */   {
/* 148:121 */     this.mali_unidadpais = decimal;
/* 149:    */   }
/* 150:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdpets.model.MascotaAlimentacion
 * JD-Core Version:    0.7.0.1
 */