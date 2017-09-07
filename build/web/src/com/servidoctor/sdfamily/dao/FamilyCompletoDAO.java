/*   1:    */ package com.servidoctor.sdfamily.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.sdfamily.model.DatosPersonales;
/*   5:    */ import com.servidoctor.sdfamily.model.DatosPersonalesCompleto;
/*   6:    */ import com.servidoctor.sdfamily.model.FamilyCompleto;
/*   7:    */ import java.math.BigDecimal;
/*   8:    */ import java.sql.Connection;
/*   9:    */ import javax.sql.DataSource;
/*  10:    */ 
/*  11:    */ public class FamilyCompletoDAO
/*  12:    */   extends DAO
/*  13:    */ {
/*  14:    */   public void update(FamilyCompleto familyCompleto)
/*  15:    */     throws Exception
/*  16:    */   {
/*  17: 18 */     Connection conn = null;
/*  18:    */     try
/*  19:    */     {
/*  20: 22 */       conn = this.ds.getConnection();
/*  21: 23 */       conn.setAutoCommit(false);
/*  22:    */       
/*  23: 25 */       BigDecimal usuf_cod = familyCompleto.getDatosPersonalesCompleto().getDatosPersonales().getDatp_usuf_cod();
/*  24: 26 */       String sexo = familyCompleto.getDatosPersonalesCompleto().getDatosPersonales().getDatp_sexo();
/*  25:    */       
/*  26:    */ 
/*  27: 29 */       DatosPersonalesCompletoDAO datosPersonalesCompletoDAO = new DatosPersonalesCompletoDAO();
/*  28: 30 */       datosPersonalesCompletoDAO.setServerNumber(this.serverNumber);
/*  29: 31 */       datosPersonalesCompletoDAO.update(familyCompleto.getDatosPersonalesCompleto(), conn);
/*  30:    */       
/*  31:    */ 
/*  32: 34 */       OptometriaCompletoDAO optometriaCompletoDAO = new OptometriaCompletoDAO();
/*  33: 35 */       optometriaCompletoDAO.setServerNumber(this.serverNumber);
/*  34: 36 */       optometriaCompletoDAO.update(familyCompleto.getOptometriaCompleto(), usuf_cod, conn);
/*  35:    */       
/*  36:    */ 
/*  37: 39 */       OdontologiaCompletoDAO odontologiaCompletoDAO = new OdontologiaCompletoDAO();
/*  38: 40 */       odontologiaCompletoDAO.setServerNumber(this.serverNumber);
/*  39: 41 */       odontologiaCompletoDAO.update(familyCompleto.getOdontologiaCompleto(), usuf_cod, conn);
/*  40:    */       
/*  41:    */ 
/*  42: 44 */       MedicinaCompletoDAO medicinaCompletoDAO = new MedicinaCompletoDAO();
/*  43: 45 */       medicinaCompletoDAO.setServerNumber(this.serverNumber);
/*  44: 46 */       medicinaCompletoDAO.update(familyCompleto.getMedicinaCompleto(), usuf_cod, conn);
/*  45:    */       
/*  46:    */ 
/*  47: 49 */       VacunasCompletoDAO vacunasCompletoDAO = new VacunasCompletoDAO();
/*  48: 50 */       vacunasCompletoDAO.setServerNumber(this.serverNumber);
/*  49: 51 */       vacunasCompletoDAO.update(familyCompleto.getVacunasCompleto(), usuf_cod, conn);
/*  50:    */       
/*  51:    */ 
/*  52: 54 */       HistoriaMedicaDAO historiaMedicaDAO = new HistoriaMedicaDAO();
/*  53: 55 */       historiaMedicaDAO.setServerNumber(this.serverNumber);
/*  54: 56 */       historiaMedicaDAO.update(familyCompleto.getHistoriaMedica(), usuf_cod, familyCompleto.getDatosPersonalesCompleto().getDatosPersonales().getDatp_sexo(), conn);
/*  55:    */       
/*  56: 58 */       conn.commit();
/*  57:    */     }
/*  58:    */     catch (Exception e)
/*  59:    */     {
/*  60: 61 */       rollback(conn);
/*  61: 62 */       throw e;
/*  62:    */     }
/*  63:    */     finally
/*  64:    */     {
/*  65: 64 */       close(conn);
/*  66:    */     }
/*  67:    */   }
/*  68:    */   
/*  69:    */   public FamilyCompleto retrieve(BigDecimal usuf_cod)
/*  70:    */     throws Exception
/*  71:    */   {
/*  72: 70 */     FamilyCompleto familyCompleto = new FamilyCompleto();
/*  73:    */     try
/*  74:    */     {
/*  75: 75 */       DatosPersonalesCompletoDAO datosPersonalesCompletoDAO = new DatosPersonalesCompletoDAO();
/*  76: 76 */       datosPersonalesCompletoDAO.setServerNumber(this.serverNumber);
/*  77: 77 */       familyCompleto.setDatosPersonalesCompleto(datosPersonalesCompletoDAO.retrieve(usuf_cod));
/*  78:    */       
/*  79: 79 */       String sexo = familyCompleto.getDatosPersonalesCompleto().getDatosPersonales().getDatp_sexo();
/*  80:    */       
/*  81:    */ 
/*  82: 82 */       OptometriaCompletoDAO optometriaCompletoDAO = new OptometriaCompletoDAO();
/*  83: 83 */       optometriaCompletoDAO.setServerNumber(this.serverNumber);
/*  84: 84 */       familyCompleto.setOptometriaCompleto(optometriaCompletoDAO.retrieve(usuf_cod));
/*  85:    */       
/*  86:    */ 
/*  87: 87 */       OdontologiaCompletoDAO odontologiaCompletoDAO = new OdontologiaCompletoDAO();
/*  88: 88 */       odontologiaCompletoDAO.setServerNumber(this.serverNumber);
/*  89: 89 */       familyCompleto.setOdontologiaCompleto(odontologiaCompletoDAO.retrieve(usuf_cod));
/*  90:    */       
/*  91:    */ 
/*  92: 92 */       MedicinaCompletoDAO medicinaCompletoDAO = new MedicinaCompletoDAO();
/*  93: 93 */       medicinaCompletoDAO.setServerNumber(this.serverNumber);
/*  94: 94 */       familyCompleto.setMedicinaCompleto(medicinaCompletoDAO.retrieve(usuf_cod, sexo));
/*  95:    */       
/*  96:    */ 
/*  97: 97 */       VacunasCompletoDAO vacunasCompletoDAO = new VacunasCompletoDAO();
/*  98: 98 */       vacunasCompletoDAO.setServerNumber(this.serverNumber);
/*  99: 99 */       familyCompleto.setVacunasCompleto(vacunasCompletoDAO.retrieve(usuf_cod));
/* 100:    */       
/* 101:    */ 
/* 102:102 */       HistoriaMedicaDAO historiaMedicaDAO = new HistoriaMedicaDAO();
/* 103:103 */       historiaMedicaDAO.setServerNumber(this.serverNumber);
/* 104:104 */       familyCompleto.setHistoriaMedica(historiaMedicaDAO.retrieve(usuf_cod));
/* 105:    */     }
/* 106:    */     catch (Exception e)
/* 107:    */     {
/* 108:117 */       throw e;
/* 109:    */     }
/* 110:120 */     return familyCompleto;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public void delete(BigDecimal usuf_cod)
/* 114:    */     throws Exception
/* 115:    */   {
/* 116:125 */     Connection conn = null;
/* 117:    */     try
/* 118:    */     {
/* 119:129 */       conn = this.ds.getConnection();
/* 120:130 */       conn.setAutoCommit(false);
/* 121:    */       
/* 122:    */ 
/* 123:133 */       HistoriaMedicaDAO historiaMedicaDAO = new HistoriaMedicaDAO();
/* 124:134 */       historiaMedicaDAO.setServerNumber(this.serverNumber);
/* 125:135 */       historiaMedicaDAO.delete(usuf_cod, conn);
/* 126:    */       
/* 127:    */ 
/* 128:    */ 
/* 129:    */ 
/* 130:    */ 
/* 131:    */ 
/* 132:    */ 
/* 133:    */ 
/* 134:    */ 
/* 135:    */ 
/* 136:    */ 
/* 137:    */ 
/* 138:148 */       VacunasCompletoDAO vacunasCompletoDAO = new VacunasCompletoDAO();
/* 139:149 */       vacunasCompletoDAO.setServerNumber(this.serverNumber);
/* 140:150 */       vacunasCompletoDAO.delete(usuf_cod, conn);
/* 141:    */       
/* 142:    */ 
/* 143:153 */       MedicinaCompletoDAO medicinaCompletoDAO = new MedicinaCompletoDAO();
/* 144:154 */       medicinaCompletoDAO.setServerNumber(this.serverNumber);
/* 145:155 */       medicinaCompletoDAO.delete(usuf_cod, conn);
/* 146:    */       
/* 147:    */ 
/* 148:158 */       OdontologiaCompletoDAO odontologiaCompletoDAO = new OdontologiaCompletoDAO();
/* 149:159 */       odontologiaCompletoDAO.setServerNumber(this.serverNumber);
/* 150:160 */       odontologiaCompletoDAO.delete(usuf_cod, conn);
/* 151:    */       
/* 152:    */ 
/* 153:163 */       OptometriaCompletoDAO optometriaCompletoDAO = new OptometriaCompletoDAO();
/* 154:164 */       optometriaCompletoDAO.setServerNumber(this.serverNumber);
/* 155:165 */       optometriaCompletoDAO.delete(usuf_cod, conn);
/* 156:    */       
/* 157:    */ 
/* 158:168 */       DatosPersonalesCompletoDAO datosPersonalesCompletoDAO = new DatosPersonalesCompletoDAO();
/* 159:169 */       datosPersonalesCompletoDAO.setServerNumber(this.serverNumber);
/* 160:170 */       datosPersonalesCompletoDAO.delete(usuf_cod, conn);
/* 161:    */       
/* 162:172 */       conn.commit();
/* 163:    */     }
/* 164:    */     catch (Exception e)
/* 165:    */     {
/* 166:175 */       rollback(conn);
/* 167:176 */       throw e;
/* 168:    */     }
/* 169:    */     finally
/* 170:    */     {
/* 171:178 */       close(conn);
/* 172:    */     }
/* 173:    */   }
/* 174:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.dao.FamilyCompletoDAO
 * JD-Core Version:    0.7.0.1
 */