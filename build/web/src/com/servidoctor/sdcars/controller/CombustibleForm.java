/*  1:   */ package com.servidoctor.sdcars.controller;
/*  2:   */ 
/*  3:   */ import org.apache.struts.validator.ValidatorForm;
/*  4:   */ 
/*  5:   */ public class CombustibleForm
/*  6:   */   extends ValidatorForm
/*  7:   */ {
/*  8:15 */   private String com_cod = "0";
/*  9:16 */   private String com_veh_cod = "0";
/* 10:17 */   private String com_fechaini = "0";
/* 11:18 */   private String com_fechafin = "0";
/* 12:19 */   private String com_lecturaini = "0";
/* 13:20 */   private String com_lecturafin = "0";
/* 14:21 */   private String com_cantidadconsumo = "0";
/* 15:22 */   private String com_costocombustible = "0";
/* 16:   */   
/* 17:   */   public String getCom_cantidadconsumo()
/* 18:   */   {
/* 19:25 */     return this.com_cantidadconsumo;
/* 20:   */   }
/* 21:   */   
/* 22:   */   public String getCom_cod()
/* 23:   */   {
/* 24:29 */     return this.com_cod;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public String getCom_costocombustible()
/* 28:   */   {
/* 29:33 */     return this.com_costocombustible;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public String getCom_fechafin()
/* 33:   */   {
/* 34:37 */     return this.com_fechafin;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public String getCom_fechaini()
/* 38:   */   {
/* 39:41 */     return this.com_fechaini;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public String getCom_lecturafin()
/* 43:   */   {
/* 44:45 */     return this.com_lecturafin;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public String getCom_lecturaini()
/* 48:   */   {
/* 49:49 */     return this.com_lecturaini;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public String getCom_veh_cod()
/* 53:   */   {
/* 54:53 */     return this.com_veh_cod;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public void setCom_cantidadconsumo(String string)
/* 58:   */   {
/* 59:57 */     this.com_cantidadconsumo = string;
/* 60:   */   }
/* 61:   */   
/* 62:   */   public void setCom_cod(String string)
/* 63:   */   {
/* 64:61 */     this.com_cod = string;
/* 65:   */   }
/* 66:   */   
/* 67:   */   public void setCom_costocombustible(String string)
/* 68:   */   {
/* 69:65 */     this.com_costocombustible = string;
/* 70:   */   }
/* 71:   */   
/* 72:   */   public void setCom_fechafin(String string)
/* 73:   */   {
/* 74:69 */     this.com_fechafin = string;
/* 75:   */   }
/* 76:   */   
/* 77:   */   public void setCom_fechaini(String string)
/* 78:   */   {
/* 79:73 */     this.com_fechaini = string;
/* 80:   */   }
/* 81:   */   
/* 82:   */   public void setCom_lecturafin(String string)
/* 83:   */   {
/* 84:77 */     this.com_lecturafin = string;
/* 85:   */   }
/* 86:   */   
/* 87:   */   public void setCom_lecturaini(String string)
/* 88:   */   {
/* 89:81 */     this.com_lecturaini = string;
/* 90:   */   }
/* 91:   */   
/* 92:   */   public void setCom_veh_cod(String string)
/* 93:   */   {
/* 94:85 */     this.com_veh_cod = string;
/* 95:   */   }
/* 96:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdcars.controller.CombustibleForm
 * JD-Core Version:    0.7.0.1
 */