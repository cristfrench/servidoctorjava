/*  1:   */ package com.servidoctor.seguridad.model;
/*  2:   */ 
/*  3:   */ import com.servidoctor.util.AES;
/*  4:   */ import java.math.BigDecimal;
/*  5:   */ 
/*  6:   */ public class UsuarioFamily
/*  7:   */ {
/*  8:   */   private BigDecimal usuf_cod;
/*  9:   */   private String usuf_licencia;
/* 10:   */   private String usuf_usuario;
/* 11:   */   private String usuf_clave;
/* 12:   */   private String usuf_clave_emer;
/* 13:   */   private BigDecimal usuf_logm_cod;
/* 14:   */   private BigDecimal usuf_servidor_cod;
/* 15:   */   private BigDecimal usuf_especial;
/* 16:   */   private BigDecimal usuf_fecha_activacion;
/* 17:   */   private String usuf_may_cod;
/* 18:   */   
/* 19:   */   public BigDecimal getUsuf_especial()
/* 20:   */   {
/* 21:26 */     return this.usuf_especial;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public void setUsuf_especial(BigDecimal usuf_especial)
/* 25:   */   {
/* 26:29 */     this.usuf_especial = usuf_especial;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public String getUsuf_clave()
/* 30:   */   {
/* 31:32 */     return this.usuf_clave;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public String getUsuf_clave_emer()
/* 35:   */   {
/* 36:35 */     return this.usuf_clave_emer;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public BigDecimal getUsuf_cod()
/* 40:   */   {
/* 41:38 */     return this.usuf_cod;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public String getUsuf_licencia()
/* 45:   */   {
/* 46:41 */     return this.usuf_licencia;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public BigDecimal getUsuf_logm_cod()
/* 50:   */   {
/* 51:44 */     return this.usuf_logm_cod;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public String getUsuf_usuario()
/* 55:   */   {
/* 56:47 */     return this.usuf_usuario;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public void setUsuf_clave(String usuf_clave)
/* 60:   */   {
/* 61:50 */     this.usuf_clave = (usuf_clave == null ? null : new AES().encrypt(usuf_clave));
/* 62:   */   }
/* 63:   */   
/* 64:   */   public void setUsuf_clave_emer(String usuf_clave_emer)
/* 65:   */   {
/* 66:53 */     this.usuf_clave_emer = usuf_clave_emer;
/* 67:   */   }
/* 68:   */   
/* 69:   */   public void setUsuf_cod(BigDecimal usuf_cod)
/* 70:   */   {
/* 71:56 */     this.usuf_cod = usuf_cod;
/* 72:   */   }
/* 73:   */   
/* 74:   */   public void setUsuf_licencia(String usuf_licencia)
/* 75:   */   {
/* 76:59 */     this.usuf_licencia = usuf_licencia;
/* 77:   */   }
/* 78:   */   
/* 79:   */   public void setUsuf_logm_cod(BigDecimal usuf_logm_cod)
/* 80:   */   {
/* 81:62 */     this.usuf_logm_cod = usuf_logm_cod;
/* 82:   */   }
/* 83:   */   
/* 84:   */   public void setUsuf_usuario(String usuf_usuario)
/* 85:   */   {
/* 86:65 */     this.usuf_usuario = usuf_usuario;
/* 87:   */   }
/* 88:   */   
/* 89:   */   public BigDecimal getUsuf_servidor_cod()
/* 90:   */   {
/* 91:68 */     return this.usuf_servidor_cod;
/* 92:   */   }
/* 93:   */   
/* 94:   */   public void setUsuf_servidor_cod(BigDecimal usuf_servidor_cod)
/* 95:   */   {
/* 96:71 */     this.usuf_servidor_cod = usuf_servidor_cod;
/* 97:   */   }
/* 98:   */   
/* 99:   */   public BigDecimal getUsuf_fecha_activacion()
/* :0:   */   {
/* :1:74 */     return this.usuf_fecha_activacion;
/* :2:   */   }
/* :3:   */   
/* :4:   */   public void setUsuf_fecha_activacion(BigDecimal usuf_fecha_activacion)
/* :5:   */   {
/* :6:77 */     this.usuf_fecha_activacion = usuf_fecha_activacion;
/* :7:   */   }
/* :8:   */   
/* :9:   */   public String getUsuf_may_cod()
/* ;0:   */   {
/* ;1:80 */     return this.usuf_may_cod;
/* ;2:   */   }
/* ;3:   */   
/* ;4:   */   public void setUsuf_may_cod(String usuf_may_cod)
/* ;5:   */   {
/* ;6:83 */     this.usuf_may_cod = usuf_may_cod;
/* ;7:   */   }
/* ;8:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.seguridad.model.UsuarioFamily
 * JD-Core Version:    0.7.0.1
 */