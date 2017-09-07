/*  1:   */ package com.servidoctor.parametros.model;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class RecoComprador
/*  6:   */ {
/*  7:   */   private BigDecimal consecutivo;
/*  8:   */   private BigDecimal reco_grupo_id;
/*  9:   */   private BigDecimal reco_grupo_consecutivo;
/* 10:   */   private String reco_html_code;
/* 11:   */   private String reco_html_link;
/* 12:   */   
/* 13:   */   public BigDecimal getReco_grupo_consecutivo()
/* 14:   */   {
/* 15:19 */     return this.reco_grupo_consecutivo;
/* 16:   */   }
/* 17:   */   
/* 18:   */   public void setReco_grupo_consecutivo(BigDecimal reco_grupo_consecutivo)
/* 19:   */   {
/* 20:22 */     this.reco_grupo_consecutivo = reco_grupo_consecutivo;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public BigDecimal getConsecutivo()
/* 24:   */   {
/* 25:25 */     return this.consecutivo;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public void setConsecutivo(BigDecimal consecutivo)
/* 29:   */   {
/* 30:28 */     this.consecutivo = consecutivo;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public BigDecimal getReco_grupo_id()
/* 34:   */   {
/* 35:31 */     return this.reco_grupo_id;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public void setReco_grupo_id(BigDecimal reco_grupo_id)
/* 39:   */   {
/* 40:34 */     this.reco_grupo_id = reco_grupo_id;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public String getReco_html_code()
/* 44:   */   {
/* 45:37 */     return this.reco_html_code;
/* 46:   */   }
/* 47:   */   
/* 48:   */   public void setReco_html_code(String reco_html_code)
/* 49:   */   {
/* 50:40 */     this.reco_html_code = reco_html_code;
/* 51:   */   }
/* 52:   */   
/* 53:   */   public String getReco_html_link()
/* 54:   */   {
/* 55:43 */     return this.reco_html_link;
/* 56:   */   }
/* 57:   */   
/* 58:   */   public void setReco_html_link(String reco_html_link)
/* 59:   */   {
/* 60:46 */     this.reco_html_link = reco_html_link;
/* 61:   */   }
/* 62:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.parametros.model.RecoComprador
 * JD-Core Version:    0.7.0.1
 */