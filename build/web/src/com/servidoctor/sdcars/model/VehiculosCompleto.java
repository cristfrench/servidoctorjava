/*   1:    */ package com.servidoctor.sdcars.model;
/*   2:    */ 
/*   3:    */ import java.util.List;
/*   4:    */ 
/*   5:    */ public class VehiculosCompleto
/*   6:    */ {
/*   7:    */   private Vehiculos vehiculo;
/*   8:    */   private PropietariosVehiculos propietario;
/*   9:    */   private MantenimientoGeneral mantenimientoGeneral;
/*  10:    */   private List controles;
/*  11:    */   private List gastosAnuales;
/*  12:    */   private List gastosNoAnuales;
/*  13:    */   private List gastosMecanica;
/*  14:    */   private List impuestos;
/*  15:    */   private List consumosCombustible;
/*  16:    */   private List revisiones;
/*  17:    */   private List seguros;
/*  18:    */   
/*  19:    */   public List getConsumosCombustible()
/*  20:    */   {
/*  21: 27 */     return this.consumosCombustible;
/*  22:    */   }
/*  23:    */   
/*  24:    */   public List getControles()
/*  25:    */   {
/*  26: 31 */     return this.controles;
/*  27:    */   }
/*  28:    */   
/*  29:    */   public List getGastosAnuales()
/*  30:    */   {
/*  31: 35 */     return this.gastosAnuales;
/*  32:    */   }
/*  33:    */   
/*  34:    */   public List getGastosMecanica()
/*  35:    */   {
/*  36: 39 */     return this.gastosMecanica;
/*  37:    */   }
/*  38:    */   
/*  39:    */   public List getGastosNoAnuales()
/*  40:    */   {
/*  41: 43 */     return this.gastosNoAnuales;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public List getImpuestos()
/*  45:    */   {
/*  46: 47 */     return this.impuestos;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public PropietariosVehiculos getPropietario()
/*  50:    */   {
/*  51: 51 */     return this.propietario;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public List getRevisiones()
/*  55:    */   {
/*  56: 55 */     return this.revisiones;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public List getSeguros()
/*  60:    */   {
/*  61: 59 */     return this.seguros;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public Vehiculos getVehiculo()
/*  65:    */   {
/*  66: 63 */     return this.vehiculo;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public void setConsumosCombustible(List list)
/*  70:    */   {
/*  71: 67 */     this.consumosCombustible = list;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public void setControles(List list)
/*  75:    */   {
/*  76: 71 */     this.controles = list;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void setGastosAnuales(List list)
/*  80:    */   {
/*  81: 75 */     this.gastosAnuales = list;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public void setGastosMecanica(List list)
/*  85:    */   {
/*  86: 79 */     this.gastosMecanica = list;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void setGastosNoAnuales(List list)
/*  90:    */   {
/*  91: 83 */     this.gastosNoAnuales = list;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public void setImpuestos(List list)
/*  95:    */   {
/*  96: 87 */     this.impuestos = list;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public void setPropietario(PropietariosVehiculos vehiculos)
/* 100:    */   {
/* 101: 91 */     this.propietario = vehiculos;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public void setRevisiones(List list)
/* 105:    */   {
/* 106: 95 */     this.revisiones = list;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public void setSeguros(List list)
/* 110:    */   {
/* 111: 99 */     this.seguros = list;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public void setVehiculo(Vehiculos vehiculos)
/* 115:    */   {
/* 116:103 */     this.vehiculo = vehiculos;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public MantenimientoGeneral getMantenimientoGeneral()
/* 120:    */   {
/* 121:107 */     return this.mantenimientoGeneral;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public void setMantenimientoGeneral(MantenimientoGeneral general)
/* 125:    */   {
/* 126:111 */     this.mantenimientoGeneral = general;
/* 127:    */   }
/* 128:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdcars.model.VehiculosCompleto
 * JD-Core Version:    0.7.0.1
 */