/*   1:    */ package com.servidoctor.sdpets.model;
/*   2:    */ 
/*   3:    */ import java.util.List;
/*   4:    */ 
/*   5:    */ public class MascotaCompleto
/*   6:    */ {
/*   7:    */   PropietariosMascota propietarioMascota;
/*   8:    */   Mascota mascota;
/*   9:    */   MascotaAlimentacion mascotaAlimentacion;
/*  10:    */   ContactosMascota contactoMascota;
/*  11:    */   List tablaAjustada;
/*  12:    */   List tablaUniversal;
/*  13:    */   List controles;
/*  14:    */   List medicamentos;
/*  15:    */   List grupos;
/*  16:    */   List seguros;
/*  17:    */   List enfermedades;
/*  18:    */   List cirugias;
/*  19:    */   List alergias;
/*  20:    */   
/*  21:    */   public MascotaCompleto()
/*  22:    */   {
/*  23: 26 */     this.propietarioMascota = new PropietariosMascota();
/*  24: 27 */     this.mascota = new Mascota();
/*  25: 28 */     this.mascotaAlimentacion = new MascotaAlimentacion();
/*  26: 29 */     this.contactoMascota = new ContactosMascota();
/*  27:    */   }
/*  28:    */   
/*  29:    */   public List getControles()
/*  30:    */   {
/*  31: 33 */     return this.controles;
/*  32:    */   }
/*  33:    */   
/*  34:    */   public Mascota getMascota()
/*  35:    */   {
/*  36: 37 */     return this.mascota;
/*  37:    */   }
/*  38:    */   
/*  39:    */   public MascotaAlimentacion getMascotaAlimentacion()
/*  40:    */   {
/*  41: 41 */     return this.mascotaAlimentacion;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public List getMedicamentos()
/*  45:    */   {
/*  46: 45 */     return this.medicamentos;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public PropietariosMascota getPropietarioMascota()
/*  50:    */   {
/*  51: 49 */     return this.propietarioMascota;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public List getTablaAjustada()
/*  55:    */   {
/*  56: 53 */     return this.tablaAjustada;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public void setControles(List list)
/*  60:    */   {
/*  61: 57 */     this.controles = list;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public void setMascota(Mascota mascota)
/*  65:    */   {
/*  66: 61 */     this.mascota = mascota;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public void setMascotaAlimentacion(MascotaAlimentacion alimentacion)
/*  70:    */   {
/*  71: 65 */     this.mascotaAlimentacion = alimentacion;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public void setMedicamentos(List list)
/*  75:    */   {
/*  76: 69 */     this.medicamentos = list;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void setPropietarioMascota(PropietariosMascota mascota)
/*  80:    */   {
/*  81: 73 */     this.propietarioMascota = mascota;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public void setTablaAjustada(List list)
/*  85:    */   {
/*  86: 77 */     this.tablaAjustada = list;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public ContactosMascota getContactoMascota()
/*  90:    */   {
/*  91: 81 */     return this.contactoMascota;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public void setContactoMascota(ContactosMascota mascota)
/*  95:    */   {
/*  96: 85 */     this.contactoMascota = mascota;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public List getTablaUniversal()
/* 100:    */   {
/* 101: 89 */     return this.tablaUniversal;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public void setTablaUniversal(List list)
/* 105:    */   {
/* 106: 93 */     this.tablaUniversal = list;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public List getGrupos()
/* 110:    */   {
/* 111: 97 */     return this.grupos;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public void setGrupos(List list)
/* 115:    */   {
/* 116:101 */     this.grupos = list;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public List getSeguros()
/* 120:    */   {
/* 121:105 */     return this.seguros;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public void setSeguros(List list)
/* 125:    */   {
/* 126:109 */     this.seguros = list;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public List getEnfermedades()
/* 130:    */   {
/* 131:113 */     return this.enfermedades;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public void setEnfermedades(List enfermedades)
/* 135:    */   {
/* 136:117 */     this.enfermedades = enfermedades;
/* 137:    */   }
/* 138:    */   
/* 139:    */   public List getCirugias()
/* 140:    */   {
/* 141:121 */     return this.cirugias;
/* 142:    */   }
/* 143:    */   
/* 144:    */   public void setCirugias(List cirugias)
/* 145:    */   {
/* 146:125 */     this.cirugias = cirugias;
/* 147:    */   }
/* 148:    */   
/* 149:    */   public List getAlergias()
/* 150:    */   {
/* 151:129 */     return this.alergias;
/* 152:    */   }
/* 153:    */   
/* 154:    */   public void setAlergias(List alergias)
/* 155:    */   {
/* 156:133 */     this.alergias = alergias;
/* 157:    */   }
/* 158:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdpets.model.MascotaCompleto
 * JD-Core Version:    0.7.0.1
 */