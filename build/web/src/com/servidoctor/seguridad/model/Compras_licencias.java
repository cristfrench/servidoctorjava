/*   1:    */ package com.servidoctor.seguridad.model;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.math.BigDecimal;
/*   5:    */ import java.sql.Timestamp;
/*   6:    */ import java.util.Date;
/*   7:    */ 
/*   8:    */ public class Compras_licencias
/*   9:    */   implements Serializable
/*  10:    */ {
/*  11:    */   private String compras_productos_id;
/*  12:    */   private BigDecimal grp_precio_id;
/*  13:    */   private String compras_licencias_codact;
/*  14:    */   private Date compras_licencias_datgc;
/*  15:    */   private Timestamp compras_licencias_actc;
/*  16:    */   private BigDecimal compras_licencias_nma;
/*  17:    */   private Date compras_licencias_dattl;
/*  18:    */   private BigDecimal server_id;
/*  19:    */   
/*  20:    */   public BigDecimal getServer_id()
/*  21:    */   {
/*  22: 55 */     return this.server_id;
/*  23:    */   }
/*  24:    */   
/*  25:    */   public void setServer_id(BigDecimal servidor_id)
/*  26:    */   {
/*  27: 62 */     this.server_id = servidor_id;
/*  28:    */   }
/*  29:    */   
/*  30:    */   public Timestamp getCompras_licencias_actc()
/*  31:    */   {
/*  32: 69 */     return this.compras_licencias_actc;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public String getCompras_licencias_codact()
/*  36:    */   {
/*  37: 76 */     return this.compras_licencias_codact;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public Date getCompras_licencias_datgc()
/*  41:    */   {
/*  42: 83 */     return this.compras_licencias_datgc;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public Date getCompras_licencias_dattl()
/*  46:    */   {
/*  47: 90 */     return this.compras_licencias_dattl;
/*  48:    */   }
/*  49:    */   
/*  50:    */   public BigDecimal getCompras_licencias_nma()
/*  51:    */   {
/*  52: 97 */     return this.compras_licencias_nma;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public String getCompras_productos_id()
/*  56:    */   {
/*  57:104 */     return this.compras_productos_id;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public BigDecimal getGrp_precio_id()
/*  61:    */   {
/*  62:111 */     return this.grp_precio_id;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public void setCompras_licencias_actc(Timestamp timestamp)
/*  66:    */   {
/*  67:118 */     this.compras_licencias_actc = timestamp;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public void setCompras_licencias_codact(String string)
/*  71:    */   {
/*  72:125 */     this.compras_licencias_codact = string;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public void setCompras_licencias_datgc(Date date)
/*  76:    */   {
/*  77:132 */     this.compras_licencias_datgc = date;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public void setCompras_licencias_dattl(Date date)
/*  81:    */   {
/*  82:139 */     this.compras_licencias_dattl = date;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public void setCompras_licencias_nma(BigDecimal decimal)
/*  86:    */   {
/*  87:146 */     this.compras_licencias_nma = decimal;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public void setCompras_productos_id(String string)
/*  91:    */   {
/*  92:153 */     this.compras_productos_id = string;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public void setGrp_precio_id(BigDecimal decimal)
/*  96:    */   {
/*  97:160 */     this.grp_precio_id = decimal;
/*  98:    */   }
/*  99:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.seguridad.model.Compras_licencias
 * JD-Core Version:    0.7.0.1
 */