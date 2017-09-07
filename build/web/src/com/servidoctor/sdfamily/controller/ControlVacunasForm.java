/*  1:   */ package com.servidoctor.sdfamily.controller;
/*  2:   */ 
/*  3:   */ import org.apache.struts.validator.ValidatorForm;
/*  4:   */ 
/*  5:   */ public class ControlVacunasForm
/*  6:   */   extends ValidatorForm
/*  7:   */ {
/*  8:15 */   private String grupu_dias_antes = "0";
/*  9:   */   
/* 10:   */   public String getGrupu_dias_antes()
/* 11:   */   {
/* 12:18 */     return this.grupu_dias_antes;
/* 13:   */   }
/* 14:   */   
/* 15:   */   public void setGrupu_dias_antes(String string)
/* 16:   */   {
/* 17:22 */     this.grupu_dias_antes = string;
/* 18:   */   }
/* 19:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.controller.ControlVacunasForm
 * JD-Core Version:    0.7.0.1
 */