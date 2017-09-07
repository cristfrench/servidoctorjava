/*  1:   */ package com.servidoctor.sdfamily.model;
/*  2:   */ 
            import java.io.Serializable;
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class PartesCuerpoUsuario implements Serializable 
/*  6:   */ {
/*  7:   */   private BigDecimal pcueu_cod;
/*  8:   */   private BigDecimal pcueu_usuf_cod;
/*  9:   */   private BigDecimal pcueu_pcue_cod;
/* 10:   */   private String pcueu_des;
/* 11:   */   private String pcueu_comentario;
/* 12:   */   
/* 13:   */   public BigDecimal getPcueu_cod()
/* 14:   */   {
/* 15:20 */     return this.pcueu_cod;
/* 16:   */   }
/* 17:   */   
/* 18:   */   public String getPcueu_comentario()
/* 19:   */   {
/* 20:23 */     return this.pcueu_comentario;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public String getPcueu_des()
/* 24:   */   {
/* 25:26 */     return this.pcueu_des;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public BigDecimal getPcueu_pcue_cod()
/* 29:   */   {
/* 30:29 */     return this.pcueu_pcue_cod;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public BigDecimal getPcueu_usuf_cod()
/* 34:   */   {
/* 35:32 */     return this.pcueu_usuf_cod;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public void setPcueu_cod(BigDecimal pcueu_cod)
/* 39:   */   {
/* 40:35 */     this.pcueu_cod = pcueu_cod;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public void setPcueu_comentario(String pcueu_comentario)
/* 44:   */   {
/* 45:38 */     this.pcueu_comentario = pcueu_comentario;
/* 46:   */   }
/* 47:   */   
/* 48:   */   public void setPcueu_des(String pcueu_des)
/* 49:   */   {
/* 50:41 */     this.pcueu_des = pcueu_des;
/* 51:   */   }
/* 52:   */   
/* 53:   */   public void setPcueu_pcue_cod(BigDecimal pcueu_pcue_cod)
/* 54:   */   {
/* 55:44 */     this.pcueu_pcue_cod = pcueu_pcue_cod;
/* 56:   */   }
/* 57:   */   
/* 58:   */   public void setPcueu_usuf_cod(BigDecimal pcueu_usuf_cod)
/* 59:   */   {
/* 60:47 */     this.pcueu_usuf_cod = pcueu_usuf_cod;
/* 61:   */   }
/* 62:   */ }



/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\

 * Qualified Name:     com.servidoctor.sdfamily.model.PartesCuerpoUsuario

 * JD-Core Version:    0.7.0.1

 */