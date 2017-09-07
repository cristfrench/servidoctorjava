/*  1:   */ package com.servidoctor.sdfamily.model;
/*  2:   */ 
/*  3:   */ public class FamilyCompleto
/*  4:   */ {
/*  5:   */   private DatosPersonalesCompleto datosPersonalesCompleto;
/*  6:   */   private OptometriaCompleto optometriaCompleto;
/*  7:   */   private OdontologiaCompleto odontologiaCompleto;
/*  8:   */   private MedicinaCompleto medicinaCompleto;
/*  9:   */   private VacunasCompleto vacunasCompleto;
/* 10:   */   private HistoriaMedica historiaMedica;
/* 11:   */   
/* 12:   */   public DatosPersonalesCompleto getDatosPersonalesCompleto()
/* 13:   */   {
/* 14:13 */     if (this.datosPersonalesCompleto == null) {
/* 15:14 */       this.datosPersonalesCompleto = new DatosPersonalesCompleto();
/* 16:   */     }
/* 17:16 */     return this.datosPersonalesCompleto;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public void setDatosPersonalesCompleto(DatosPersonalesCompleto datosPersonalesCompleto)
/* 21:   */   {
/* 22:19 */     this.datosPersonalesCompleto = datosPersonalesCompleto;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public OptometriaCompleto getOptometriaCompleto()
/* 26:   */   {
/* 27:22 */     if (this.optometriaCompleto == null) {
/* 28:23 */       this.optometriaCompleto = new OptometriaCompleto();
/* 29:   */     }
/* 30:25 */     return this.optometriaCompleto;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public void setOptometriaCompleto(OptometriaCompleto optometriaCompleto)
/* 34:   */   {
/* 35:28 */     this.optometriaCompleto = optometriaCompleto;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public OdontologiaCompleto getOdontologiaCompleto()
/* 39:   */   {
/* 40:31 */     if (this.odontologiaCompleto == null) {
/* 41:32 */       this.odontologiaCompleto = new OdontologiaCompleto();
/* 42:   */     }
/* 43:34 */     return this.odontologiaCompleto;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public void setOdontologiaCompleto(OdontologiaCompleto odontologiaCompleto)
/* 47:   */   {
/* 48:37 */     this.odontologiaCompleto = odontologiaCompleto;
/* 49:   */   }
/* 50:   */   
/* 51:   */   public MedicinaCompleto getMedicinaCompleto()
/* 52:   */   {
/* 53:40 */     if (this.medicinaCompleto == null) {
/* 54:41 */       this.medicinaCompleto = new MedicinaCompleto();
/* 55:   */     }
/* 56:43 */     return this.medicinaCompleto;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public void setMedicinaCompleto(MedicinaCompleto medicinaCompleto)
/* 60:   */   {
/* 61:46 */     this.medicinaCompleto = medicinaCompleto;
/* 62:   */   }
/* 63:   */   
/* 64:   */   public VacunasCompleto getVacunasCompleto()
/* 65:   */   {
/* 66:49 */     if (this.vacunasCompleto == null) {
/* 67:50 */       this.vacunasCompleto = new VacunasCompleto();
/* 68:   */     }
/* 69:52 */     return this.vacunasCompleto;
/* 70:   */   }
/* 71:   */   
/* 72:   */   public void setVacunasCompleto(VacunasCompleto vacunasCompleto)
/* 73:   */   {
/* 74:55 */     this.vacunasCompleto = vacunasCompleto;
/* 75:   */   }
/* 76:   */   
/* 77:   */   public HistoriaMedica getHistoriaMedica()
/* 78:   */   {
/* 79:58 */     if (this.historiaMedica == null) {
/* 80:59 */       this.historiaMedica = new HistoriaMedica();
/* 81:   */     }
/* 82:61 */     return this.historiaMedica;
/* 83:   */   }
/* 84:   */   
/* 85:   */   public void setHistoriaMedica(HistoriaMedica historiaMedica)
/* 86:   */   {
/* 87:64 */     this.historiaMedica = historiaMedica;
/* 88:   */   }
/* 89:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.model.FamilyCompleto
 * JD-Core Version:    0.7.0.1
 */