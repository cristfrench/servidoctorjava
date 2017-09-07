/*  1:   */ package com.servidoctor.seguridad.model;
/*  2:   */ 
/*  3:   */ import com.servidoctor.util.AES;
/*  4:   */ import java.math.BigDecimal;
/*  5:   */ 
/*  6:   */ public class UsuarioCar
/*  7:   */ {
/*  8:   */   private BigDecimal usuc_cod;
/*  9:   */   private String usuc_licencia;
/* 10:   */   private String usuc_usuario;
/* 11:   */   private String usuc_clave;
/* 12:   */   private String usuc_clave_emer;
/* 13:   */   private BigDecimal usuc_logm_cod;
/* 14:   */   private BigDecimal usuc_servidor_cod;
/* 15:   */   private BigDecimal usuc_especial;
/* 16:   */   private BigDecimal usuc_fecha_activacion;
/* 17:   */   private String usuc_may_cod;
/* 18:   */   
/* 19:   */   public String getUsuc_clave()
/* 20:   */   {
/* 21:27 */     return this.usuc_clave;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public void setUsuc_clave(String usuc_clave)
/* 25:   */   {
/* 26:30 */     this.usuc_clave = (usuc_clave == null ? null : new AES().encrypt(usuc_clave));
/* 27:   */   }
/* 28:   */   
/* 29:   */   public String getUsuc_clave_emer()
/* 30:   */   {
/* 31:33 */     return this.usuc_clave_emer;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public void setUsuc_clave_emer(String usuc_clave_emer)
/* 35:   */   {
/* 36:36 */     this.usuc_clave_emer = usuc_clave_emer;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public BigDecimal getUsuc_cod()
/* 40:   */   {
/* 41:39 */     return this.usuc_cod;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public void setUsuc_cod(BigDecimal usuc_cod)
/* 45:   */   {
/* 46:42 */     this.usuc_cod = usuc_cod;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public String getUsuc_licencia()
/* 50:   */   {
/* 51:45 */     return this.usuc_licencia;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public void setUsuc_licencia(String usuc_licencia)
/* 55:   */   {
/* 56:48 */     this.usuc_licencia = usuc_licencia;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public String getUsuc_usuario()
/* 60:   */   {
/* 61:51 */     return this.usuc_usuario;
/* 62:   */   }
/* 63:   */   
/* 64:   */   public void setUsuc_usuario(String usuc_usuario)
/* 65:   */   {
/* 66:54 */     this.usuc_usuario = usuc_usuario;
/* 67:   */   }
/* 68:   */   
/* 69:   */   public BigDecimal getUsuc_logm_cod()
/* 70:   */   {
/* 71:57 */     return this.usuc_logm_cod;
/* 72:   */   }
/* 73:   */   
/* 74:   */   public void setUsuc_logm_cod(BigDecimal usuc_logm_cod)
/* 75:   */   {
/* 76:60 */     this.usuc_logm_cod = usuc_logm_cod;
/* 77:   */   }
/* 78:   */   
/* 79:   */   public BigDecimal getUsuc_servidor_cod()
/* 80:   */   {
/* 81:63 */     return this.usuc_servidor_cod;
/* 82:   */   }
/* 83:   */   
/* 84:   */   public void setUsuc_servidor_cod(BigDecimal usuc_servidor_cod)
/* 85:   */   {
/* 86:66 */     this.usuc_servidor_cod = usuc_servidor_cod;
/* 87:   */   }
/* 88:   */   
/* 89:   */   public BigDecimal getUsuc_especial()
/* 90:   */   {
/* 91:69 */     return this.usuc_especial;
/* 92:   */   }
/* 93:   */   
/* 94:   */   public void setUsuc_especial(BigDecimal usuc_especial)
/* 95:   */   {
/* 96:72 */     this.usuc_especial = usuc_especial;
/* 97:   */   }
/* 98:   */   
/* 99:   */   public BigDecimal getUsuc_fecha_activacion()
/* :0:   */   {
/* :1:75 */     return this.usuc_fecha_activacion;
/* :2:   */   }
/* :3:   */   
/* :4:   */   public void setUsuc_fecha_activacion(BigDecimal usuc_fecha_activacion)
/* :5:   */   {
/* :6:78 */     this.usuc_fecha_activacion = usuc_fecha_activacion;
/* :7:   */   }
/* :8:   */   
/* :9:   */   public String getUsuc_may_cod()
/* ;0:   */   {
/* ;1:81 */     return this.usuc_may_cod;
/* ;2:   */   }
/* ;3:   */   
/* ;4:   */   public void setUsuc_may_cod(String usuc_may_cod)
/* ;5:   */   {
/* ;6:84 */     this.usuc_may_cod = usuc_may_cod;
/* ;7:   */   }
/* ;8:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.seguridad.model.UsuarioCar
 * JD-Core Version:    0.7.0.1
 */