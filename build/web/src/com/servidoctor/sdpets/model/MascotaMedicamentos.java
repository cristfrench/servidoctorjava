/*  1:   */ package com.servidoctor.sdpets.model;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class MascotaMedicamentos
/*  6:   */ {
/*  7:   */   private BigDecimal mmed_cod;
/*  8:   */   private BigDecimal mmed_mas_cod;
/*  9:   */   private String mmed_afeccion;
/* 10:   */   private String mmed_nombre;
/* 11:   */   private BigDecimal mmed_fec_inicio;
/* 12:   */   private BigDecimal mmed_dias_uso;
/* 13:   */   private BigDecimal mmed_veces_dia;
/* 14:   */   private String mmed_dosis;
/* 15:   */   
/* 16:   */   public String getMmed_afeccion()
/* 17:   */   {
/* 18:18 */     return this.mmed_afeccion;
/* 19:   */   }
/* 20:   */   
/* 21:   */   public BigDecimal getMmed_cod()
/* 22:   */   {
/* 23:22 */     return this.mmed_cod;
/* 24:   */   }
/* 25:   */   
/* 26:   */   public BigDecimal getMmed_dias_uso()
/* 27:   */   {
/* 28:26 */     return this.mmed_dias_uso;
/* 29:   */   }
/* 30:   */   
/* 31:   */   public String getMmed_dosis()
/* 32:   */   {
/* 33:30 */     return this.mmed_dosis;
/* 34:   */   }
/* 35:   */   
/* 36:   */   public BigDecimal getMmed_fec_inicio()
/* 37:   */   {
/* 38:34 */     return this.mmed_fec_inicio;
/* 39:   */   }
/* 40:   */   
/* 41:   */   public BigDecimal getMmed_mas_cod()
/* 42:   */   {
/* 43:38 */     return this.mmed_mas_cod;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public String getMmed_nombre()
/* 47:   */   {
/* 48:42 */     return this.mmed_nombre;
/* 49:   */   }
/* 50:   */   
/* 51:   */   public BigDecimal getMmed_veces_dia()
/* 52:   */   {
/* 53:46 */     return this.mmed_veces_dia;
/* 54:   */   }
/* 55:   */   
/* 56:   */   public void setMmed_afeccion(String string)
/* 57:   */   {
/* 58:50 */     this.mmed_afeccion = string;
/* 59:   */   }
/* 60:   */   
/* 61:   */   public void setMmed_cod(BigDecimal decimal)
/* 62:   */   {
/* 63:54 */     this.mmed_cod = decimal;
/* 64:   */   }
/* 65:   */   
/* 66:   */   public void setMmed_dias_uso(BigDecimal decimal)
/* 67:   */   {
/* 68:58 */     this.mmed_dias_uso = decimal;
/* 69:   */   }
/* 70:   */   
/* 71:   */   public void setMmed_dosis(String string)
/* 72:   */   {
/* 73:62 */     this.mmed_dosis = string;
/* 74:   */   }
/* 75:   */   
/* 76:   */   public void setMmed_fec_inicio(BigDecimal decimal)
/* 77:   */   {
/* 78:66 */     this.mmed_fec_inicio = decimal;
/* 79:   */   }
/* 80:   */   
/* 81:   */   public void setMmed_mas_cod(BigDecimal decimal)
/* 82:   */   {
/* 83:70 */     this.mmed_mas_cod = decimal;
/* 84:   */   }
/* 85:   */   
/* 86:   */   public void setMmed_nombre(String string)
/* 87:   */   {
/* 88:74 */     this.mmed_nombre = string;
/* 89:   */   }
/* 90:   */   
/* 91:   */   public void setMmed_veces_dia(BigDecimal decimal)
/* 92:   */   {
/* 93:78 */     this.mmed_veces_dia = decimal;
/* 94:   */   }
/* 95:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdpets.model.MascotaMedicamentos
 * JD-Core Version:    0.7.0.1
 */