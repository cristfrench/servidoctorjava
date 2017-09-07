/*   1:    */ package com.servidoctor.reportes.model;
/*   2:    */ 
/*   3:    */ import java.math.BigDecimal;
/*   4:    */ 
/*   5:    */ public class ReporteUsuario
/*   6:    */ {
/*   7:    */   private BigDecimal usu_cod;
/*   8:    */   private BigDecimal documento;
/*   9:    */   private String nombres;
/*  10:    */   private String apellido;
/*  11:    */   private String sexo;
/*  12:    */   private String pais;
/*  13:    */   private String ciudad;
/*  14:    */   private String nombre_pariente;
/*  15:    */   private String fecha_nacimiento;
/*  16: 27 */   private String relacion = "";
/*  17:    */   private String tipo_sangre;
/*  18:    */   private String telefono_fijo;
/*  19:    */   private String telefono_movil;
/*  20:    */   private String email;
/*  21:    */   private String id_doc_si;
/*  22:    */   private BigDecimal fecha_registro;
/*  23:    */   private String identificadores;
/*  24:    */   
/*  25:    */   public String getApellido()
/*  26:    */   {
/*  27: 40 */     return this.apellido;
/*  28:    */   }
/*  29:    */   
/*  30:    */   public String getCiudad()
/*  31:    */   {
/*  32: 47 */     return this.ciudad;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public BigDecimal getDocumento()
/*  36:    */   {
/*  37: 54 */     return this.documento;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public String getEmail()
/*  41:    */   {
/*  42: 61 */     return this.email;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public String getFecha_nacimiento()
/*  46:    */   {
/*  47: 68 */     return this.fecha_nacimiento;
/*  48:    */   }
/*  49:    */   
/*  50:    */   public String getIdentificadores()
/*  51:    */   {
/*  52: 75 */     return this.identificadores;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public String getNombre_pariente()
/*  56:    */   {
/*  57: 82 */     return this.nombre_pariente;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public String getNombres()
/*  61:    */   {
/*  62: 89 */     return this.nombres;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public String getPais()
/*  66:    */   {
/*  67: 96 */     return this.pais;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public String getRelacion()
/*  71:    */   {
/*  72:103 */     return this.relacion;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public String getSexo()
/*  76:    */   {
/*  77:110 */     return this.sexo;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public String getTelefono_fijo()
/*  81:    */   {
/*  82:117 */     return this.telefono_fijo;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public String getTelefono_movil()
/*  86:    */   {
/*  87:124 */     return this.telefono_movil;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public String getTipo_sangre()
/*  91:    */   {
/*  92:131 */     return this.tipo_sangre;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public void setApellido(String string)
/*  96:    */   {
/*  97:138 */     this.apellido = string;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public void setCiudad(String string)
/* 101:    */   {
/* 102:145 */     this.ciudad = string;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public void setDocumento(BigDecimal decimal)
/* 106:    */   {
/* 107:152 */     this.documento = decimal;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public void setEmail(String string)
/* 111:    */   {
/* 112:159 */     this.email = string;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public void setFecha_nacimiento(String string)
/* 116:    */   {
/* 117:166 */     this.fecha_nacimiento = string;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public void setIdentificadores(String string)
/* 121:    */   {
/* 122:173 */     this.identificadores = string;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public void setNombre_pariente(String string)
/* 126:    */   {
/* 127:180 */     this.nombre_pariente = string;
/* 128:    */   }
/* 129:    */   
/* 130:    */   public void setNombres(String string)
/* 131:    */   {
/* 132:187 */     this.nombres = string;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public void setPais(String string)
/* 136:    */   {
/* 137:194 */     this.pais = string;
/* 138:    */   }
/* 139:    */   
/* 140:    */   public void setRelacion(String string)
/* 141:    */   {
/* 142:201 */     this.relacion = string;
/* 143:    */   }
/* 144:    */   
/* 145:    */   public void setSexo(String string)
/* 146:    */   {
/* 147:208 */     this.sexo = string;
/* 148:    */   }
/* 149:    */   
/* 150:    */   public void setTelefono_fijo(String string)
/* 151:    */   {
/* 152:215 */     this.telefono_fijo = string;
/* 153:    */   }
/* 154:    */   
/* 155:    */   public void setTelefono_movil(String string)
/* 156:    */   {
/* 157:222 */     this.telefono_movil = string;
/* 158:    */   }
/* 159:    */   
/* 160:    */   public void setTipo_sangre(String string)
/* 161:    */   {
/* 162:229 */     this.tipo_sangre = string;
/* 163:    */   }
/* 164:    */   
/* 165:    */   public BigDecimal getUsu_cod()
/* 166:    */   {
/* 167:236 */     return this.usu_cod;
/* 168:    */   }
/* 169:    */   
/* 170:    */   public void setUsu_cod(BigDecimal decimal)
/* 171:    */   {
/* 172:243 */     this.usu_cod = decimal;
/* 173:    */   }
/* 174:    */   
/* 175:    */   public String getId_doc_si()
/* 176:    */   {
/* 177:250 */     return this.id_doc_si;
/* 178:    */   }
/* 179:    */   
/* 180:    */   public void setId_doc_si(String string)
/* 181:    */   {
/* 182:257 */     this.id_doc_si = string;
/* 183:    */   }
/* 184:    */   
/* 185:    */   public BigDecimal getFecha_registro()
/* 186:    */   {
/* 187:264 */     return this.fecha_registro;
/* 188:    */   }
/* 189:    */   
/* 190:    */   public void setFecha_registro(BigDecimal decimal)
/* 191:    */   {
/* 192:271 */     this.fecha_registro = decimal;
/* 193:    */   }
/* 194:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.reportes.model.ReporteUsuario
 * JD-Core Version:    0.7.0.1
 */