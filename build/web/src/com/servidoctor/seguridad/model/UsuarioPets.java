/*  1:   */ package com.servidoctor.seguridad.model;
/*  2:   */ 
/*  3:   */ import com.servidoctor.util.AES;
/*  4:   */ import java.math.BigDecimal;
/*  5:   */ 
/*  6:   */ public class UsuarioPets
/*  7:   */ {
/*  8:   */   private BigDecimal usup_cod;
/*  9:   */   private String usup_licencia;
/* 10:   */   private String usup_usuario;
/* 11:   */   private String usup_clave;
/* 12:   */   private String usup_clave_emer;
/* 13:   */   private BigDecimal usup_logm_cod;
/* 14:   */   private BigDecimal usup_servidor_cod;
/* 15:   */   private BigDecimal usup_especial;
/* 16:   */   private BigDecimal usup_fecha_activacion;
/* 17:   */   private String usup_may_cod;
/* 18:   */   
/* 19:   */   public BigDecimal getUsup_especial()
/* 20:   */   {
/* 21:27 */     return this.usup_especial;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public void setUsup_especial(BigDecimal usup_especial)
/* 25:   */   {
/* 26:30 */     this.usup_especial = usup_especial;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public BigDecimal getUsup_logm_cod()
/* 30:   */   {
/* 31:33 */     return this.usup_logm_cod;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public void setUsup_logm_cod(BigDecimal usup_logm_cod)
/* 35:   */   {
/* 36:36 */     this.usup_logm_cod = usup_logm_cod;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public String getUsup_clave()
/* 40:   */   {
/* 41:39 */     return this.usup_clave;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public void setUsup_clave(String usup_clave)
/* 45:   */   {
/* 46:42 */     this.usup_clave = (usup_clave == null ? null : new AES().encrypt(usup_clave));
/* 47:   */   }
/* 48:   */   
/* 49:   */   public String getUsup_clave_emer()
/* 50:   */   {
/* 51:45 */     return this.usup_clave_emer;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public void setUsup_clave_emer(String usup_clave_emer)
/* 55:   */   {
/* 56:48 */     this.usup_clave_emer = usup_clave_emer;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public BigDecimal getUsup_cod()
/* 60:   */   {
/* 61:51 */     return this.usup_cod;
/* 62:   */   }
/* 63:   */   
/* 64:   */   public void setUsup_cod(BigDecimal usup_cod)
/* 65:   */   {
/* 66:54 */     this.usup_cod = usup_cod;
/* 67:   */   }
/* 68:   */   
/* 69:   */   public String getUsup_licencia()
/* 70:   */   {
/* 71:57 */     return this.usup_licencia;
/* 72:   */   }
/* 73:   */   
/* 74:   */   public void setUsup_licencia(String usup_licencia)
/* 75:   */   {
/* 76:60 */     this.usup_licencia = usup_licencia;
/* 77:   */   }
/* 78:   */   
/* 79:   */   public String getUsup_usuario()
/* 80:   */   {
/* 81:63 */     return this.usup_usuario;
/* 82:   */   }
/* 83:   */   
/* 84:   */   public void setUsup_usuario(String usup_usuario)
/* 85:   */   {
/* 86:66 */     this.usup_usuario = usup_usuario;
/* 87:   */   }
/* 88:   */   
/* 89:   */   public BigDecimal getUsup_servidor_cod()
/* 90:   */   {
/* 91:69 */     return this.usup_servidor_cod;
/* 92:   */   }
/* 93:   */   
/* 94:   */   public void setUsup_servidor_cod(BigDecimal usup_servidor_cod)
/* 95:   */   {
/* 96:72 */     this.usup_servidor_cod = usup_servidor_cod;
/* 97:   */   }
/* 98:   */   
/* 99:   */   public BigDecimal getUsup_fecha_activacion()
/* :0:   */   {
/* :1:75 */     return this.usup_fecha_activacion;
/* :2:   */   }
/* :3:   */   
/* :4:   */   public void setUsup_fecha_activacion(BigDecimal usup_fecha_activacion)
/* :5:   */   {
/* :6:78 */     this.usup_fecha_activacion = usup_fecha_activacion;
/* :7:   */   }
/* :8:   */   
/* :9:   */   public String getUsup_may_cod()
/* ;0:   */   {
/* ;1:81 */     return this.usup_may_cod;
/* ;2:   */   }
/* ;3:   */   
/* ;4:   */   public void setUsup_may_cod(String usup_may_cod)
/* ;5:   */   {
/* ;6:84 */     this.usup_may_cod = usup_may_cod;
/* ;7:   */   }
/* ;8:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.seguridad.model.UsuarioPets
 * JD-Core Version:    0.7.0.1
 */