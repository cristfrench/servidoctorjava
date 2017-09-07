/*  1:   */ package com.servidoctor.sdfamily.controller;
/*  2:   */ 
/*  3:   */ import org.apache.struts.validator.ValidatorForm;
/*  4:   */ 
/*  5:   */ public class MedicamentosForm
/*  6:   */   extends ValidatorForm
/*  7:   */ {
/*  8:15 */   private String mtom_cod = "0";
/*  9:16 */   private String mtom_usuf_cod = "0";
/* 10:17 */   private String mtom_des = "";
/* 11:18 */   private String mtom_form_cod = "0";
/* 12:19 */   private String mtom_fecdesde = "0";
/* 13:20 */   private String mtom_dosis = "0";
/* 14:21 */   private String mtom_medi_cod = "0";
/* 15:22 */   private String mtom_peri_cod = "0";
/* 16:23 */   private String mtom_cantidad = "0";
/* 17:24 */   private String mtom_vadm_cod = "0";
/* 18:   */   
/* 19:   */   public String getMtom_cantidad()
/* 20:   */   {
/* 21:27 */     return this.mtom_cantidad;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public String getMtom_cod()
/* 25:   */   {
/* 26:30 */     return this.mtom_cod;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public String getMtom_des()
/* 30:   */   {
/* 31:33 */     return this.mtom_des;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public String getMtom_dosis()
/* 35:   */   {
/* 36:36 */     return this.mtom_dosis;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public String getMtom_fecdesde()
/* 40:   */   {
/* 41:39 */     return this.mtom_fecdesde;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public String getMtom_form_cod()
/* 45:   */   {
/* 46:42 */     return this.mtom_form_cod;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public String getMtom_medi_cod()
/* 50:   */   {
/* 51:45 */     return this.mtom_medi_cod;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public String getMtom_peri_cod()
/* 55:   */   {
/* 56:48 */     return this.mtom_peri_cod;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public String getMtom_usuf_cod()
/* 60:   */   {
/* 61:51 */     return this.mtom_usuf_cod;
/* 62:   */   }
/* 63:   */   
/* 64:   */   public String getMtom_vadm_cod()
/* 65:   */   {
/* 66:54 */     return this.mtom_vadm_cod;
/* 67:   */   }
/* 68:   */   
/* 69:   */   public void setMtom_cantidad(String mtom_cantidad)
/* 70:   */   {
/* 71:57 */     this.mtom_cantidad = mtom_cantidad;
/* 72:   */   }
/* 73:   */   
/* 74:   */   public void setMtom_cod(String mtom_cod)
/* 75:   */   {
/* 76:60 */     this.mtom_cod = mtom_cod;
/* 77:   */   }
/* 78:   */   
/* 79:   */   public void setMtom_des(String mtom_des)
/* 80:   */   {
/* 81:63 */     this.mtom_des = mtom_des;
/* 82:   */   }
/* 83:   */   
/* 84:   */   public void setMtom_dosis(String mtom_dosis)
/* 85:   */   {
/* 86:66 */     this.mtom_dosis = mtom_dosis;
/* 87:   */   }
/* 88:   */   
/* 89:   */   public void setMtom_fecdesde(String mtom_fecdesde)
/* 90:   */   {
/* 91:69 */     this.mtom_fecdesde = mtom_fecdesde;
/* 92:   */   }
/* 93:   */   
/* 94:   */   public void setMtom_form_cod(String mtom_form_cod)
/* 95:   */   {
/* 96:72 */     this.mtom_form_cod = mtom_form_cod;
/* 97:   */   }
/* 98:   */   
/* 99:   */   public void setMtom_medi_cod(String mtom_medi_cod)
/* :0:   */   {
/* :1:75 */     this.mtom_medi_cod = mtom_medi_cod;
/* :2:   */   }
/* :3:   */   
/* :4:   */   public void setMtom_peri_cod(String mtom_peri_cod)
/* :5:   */   {
/* :6:78 */     this.mtom_peri_cod = mtom_peri_cod;
/* :7:   */   }
/* :8:   */   
/* :9:   */   public void setMtom_usuf_cod(String mtom_usuf_cod)
/* ;0:   */   {
/* ;1:81 */     this.mtom_usuf_cod = mtom_usuf_cod;
/* ;2:   */   }
/* ;3:   */   
/* ;4:   */   public void setMtom_vadm_cod(String mtom_vadm_cod)
/* ;5:   */   {
/* ;6:84 */     this.mtom_vadm_cod = mtom_vadm_cod;
/* ;7:   */   }
/* ;8:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.controller.MedicamentosForm
 * JD-Core Version:    0.7.0.1
 */