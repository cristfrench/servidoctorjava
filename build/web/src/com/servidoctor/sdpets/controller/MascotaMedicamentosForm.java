/*  1:   */ package com.servidoctor.sdpets.controller;
/*  2:   */ 
/*  3:   */ import org.apache.struts.validator.ValidatorForm;
/*  4:   */ 
/*  5:   */ public class MascotaMedicamentosForm
/*  6:   */   extends ValidatorForm
/*  7:   */ {
/*  8:13 */   private String num_medicamento = "0";
/*  9:14 */   private String mmed_cod = "0";
/* 10:15 */   private String mmed_mas_cod = "0";
/* 11:16 */   private String mmed_afeccion = "";
/* 12:17 */   private String mmed_nombre = "";
/* 13:18 */   private String mmed_fec_inicio = "0";
/* 14:19 */   private String mmed_dias_uso = "0";
/* 15:20 */   private String mmed_veces_dia = "0";
/* 16:21 */   private String mmed_dosis = "";
/* 17:   */   
/* 18:   */   public String getMmed_afeccion()
/* 19:   */   {
/* 20:26 */     return this.mmed_afeccion;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public String getMmed_cod()
/* 24:   */   {
/* 25:30 */     return this.mmed_cod;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public String getMmed_dias_uso()
/* 29:   */   {
/* 30:34 */     return this.mmed_dias_uso;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public String getMmed_dosis()
/* 34:   */   {
/* 35:38 */     return this.mmed_dosis;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public String getMmed_fec_inicio()
/* 39:   */   {
/* 40:42 */     return this.mmed_fec_inicio;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public String getMmed_mas_cod()
/* 44:   */   {
/* 45:46 */     return this.mmed_mas_cod;
/* 46:   */   }
/* 47:   */   
/* 48:   */   public String getMmed_nombre()
/* 49:   */   {
/* 50:50 */     return this.mmed_nombre;
/* 51:   */   }
/* 52:   */   
/* 53:   */   public String getMmed_veces_dia()
/* 54:   */   {
/* 55:54 */     return this.mmed_veces_dia;
/* 56:   */   }
/* 57:   */   
/* 58:   */   public String getNum_medicamento()
/* 59:   */   {
/* 60:58 */     return this.num_medicamento;
/* 61:   */   }
/* 62:   */   
/* 63:   */   public void setMmed_afeccion(String string)
/* 64:   */   {
/* 65:62 */     this.mmed_afeccion = string;
/* 66:   */   }
/* 67:   */   
/* 68:   */   public void setMmed_cod(String string)
/* 69:   */   {
/* 70:66 */     this.mmed_cod = string;
/* 71:   */   }
/* 72:   */   
/* 73:   */   public void setMmed_dias_uso(String string)
/* 74:   */   {
/* 75:70 */     this.mmed_dias_uso = string;
/* 76:   */   }
/* 77:   */   
/* 78:   */   public void setMmed_dosis(String string)
/* 79:   */   {
/* 80:74 */     this.mmed_dosis = string;
/* 81:   */   }
/* 82:   */   
/* 83:   */   public void setMmed_fec_inicio(String string)
/* 84:   */   {
/* 85:78 */     this.mmed_fec_inicio = string;
/* 86:   */   }
/* 87:   */   
/* 88:   */   public void setMmed_mas_cod(String string)
/* 89:   */   {
/* 90:82 */     this.mmed_mas_cod = string;
/* 91:   */   }
/* 92:   */   
/* 93:   */   public void setMmed_nombre(String string)
/* 94:   */   {
/* 95:86 */     this.mmed_nombre = string;
/* 96:   */   }
/* 97:   */   
/* 98:   */   public void setMmed_veces_dia(String string)
/* 99:   */   {
/* :0:90 */     this.mmed_veces_dia = string;
/* :1:   */   }
/* :2:   */   
/* :3:   */   public void setNum_medicamento(String string)
/* :4:   */   {
/* :5:94 */     this.num_medicamento = string;
/* :6:   */   }
/* :7:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdpets.controller.MascotaMedicamentosForm
 * JD-Core Version:    0.7.0.1
 */