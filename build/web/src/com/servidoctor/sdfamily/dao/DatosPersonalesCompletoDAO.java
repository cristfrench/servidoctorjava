/*   1:    */ package com.servidoctor.sdfamily.dao;
/*   2:    */ 
/*   3:    */ import com.essecorp.util.GestorFechasCompleto;
/*   4:    */ import com.servidoctor.common.dao.DAO;
/*   5:    */ import com.servidoctor.constantes.IGrupos;
/*   6:    */ import com.servidoctor.sdfamily.model.CasoEmergencia;
/*   7:    */ import com.servidoctor.sdfamily.model.DatosPersonales;
/*   8:    */ import com.servidoctor.sdfamily.model.DatosPersonalesCompleto;
/*   9:    */ import com.servidoctor.sdfamily.model.GruposUsuario;
/*  10:    */ import com.servidoctor.sdfamily.model.SeguroMedico;
/*  11:    */ import com.servidoctor.sdfamily.model.UsuarioParent;
/*  12:    */ import java.math.BigDecimal;
/*  13:    */ import java.sql.Connection;
/*  14:    */ import java.util.Collection;
/*  15:    */ import java.util.HashMap;
/*  16:    */ import java.util.Iterator;
/*  17:    */ import java.util.List;
/*  18:    */ import java.util.Map;
/*  19:    */ import javax.sql.DataSource;
/*  20:    */ 
/*  21:    */ public class DatosPersonalesCompletoDAO
/*  22:    */   extends DAO
/*  23:    */ {
/*  24:    */   public void update(DatosPersonalesCompleto datosPersonalesCompleto)
/*  25:    */     throws Exception
/*  26:    */   {
/*  27: 28 */     update(datosPersonalesCompleto, null);
/*  28:    */   }
/*  29:    */   
/*  30:    */   public void update(DatosPersonalesCompleto datosPersonalesCompleto, Connection conn)
/*  31:    */     throws Exception
/*  32:    */   {
/*  33: 33 */     boolean manejado = conn != null;
/*  34:    */     try
/*  35:    */     {
/*  36: 37 */       if (!manejado)
/*  37:    */       {
/*  38: 38 */         conn = this.ds.getConnection();
/*  39: 39 */         conn.setAutoCommit(false);
/*  40:    */       }
/*  41: 44 */       String[] llavesGruposUsuario = { "grupu_cod", "grupu_usuf_cod" };
/*  42: 45 */       GruposUsuarioDAO gruposUsuarioDAO = new GruposUsuarioDAO();
/*  43: 46 */       gruposUsuarioDAO.setServerNumber(this.serverNumber);
/*  44: 47 */       if (gruposUsuarioDAO.search(datosPersonalesCompleto.getGrupoUsuario().getGrupu_usuf_cod(), IGrupos.FAMILY_SEGUROS).getGrupu_cod() != null) {
/*  45: 48 */         gruposUsuarioDAO.update(datosPersonalesCompleto.getGrupoUsuario(), llavesGruposUsuario, conn);
/*  46:    */       } else {
/*  47: 50 */         gruposUsuarioDAO.insert(datosPersonalesCompleto.getGrupoUsuario(), conn);
/*  48:    */       }
/*  49: 54 */       String[] llavesDatosPersonales = { "datp_usuf_cod" };
/*  50: 55 */       DatosPersonalesDAO datosPersonalesDAO = new DatosPersonalesDAO();
/*  51: 56 */       datosPersonalesDAO.setServerNumber(this.serverNumber);
/*  52: 57 */       if (datosPersonalesDAO.retrive(datosPersonalesCompleto.getDatosPersonales().getDatp_usuf_cod()).getDatp_usuf_cod() != null) {
/*  53: 58 */         datosPersonalesDAO.update(datosPersonalesCompleto.getDatosPersonales(), llavesDatosPersonales, conn);
/*  54:    */       } else {
/*  55: 60 */         datosPersonalesDAO.insert(datosPersonalesCompleto.getDatosPersonales(), conn);
/*  56:    */       }
/*  57: 64 */       String[] llavesUsuarioParent = { "parent_usuf_cod" };
/*  58: 65 */       datosPersonalesCompleto.getUsuarioParent().setParent_usuf_cod(datosPersonalesCompleto.getDatosPersonales().getDatp_usuf_cod());
/*  59: 66 */       UsuarioParentDAO usuarioParentDAO = new UsuarioParentDAO();
/*  60: 67 */       usuarioParentDAO.setServerNumber(this.serverNumber);
/*  61: 68 */       if (usuarioParentDAO.retrieve(datosPersonalesCompleto.getDatosPersonales().getDatp_usuf_cod()).getParent_usuf_cod() == null) {
/*  62: 69 */         usuarioParentDAO.insert(datosPersonalesCompleto.getUsuarioParent(), conn);
/*  63:    */       } else {
/*  64: 71 */         usuarioParentDAO.update(datosPersonalesCompleto.getUsuarioParent(), llavesUsuarioParent, conn);
/*  65:    */       }
/*  66: 75 */       String[] llavesCasoEmergencia = { "case_cod", "case_usuf_cod" };
/*  67: 76 */       CasoEmergenciaDAO casoEmergenciaDAO = new CasoEmergenciaDAO();
/*  68: 77 */       casoEmergenciaDAO.setServerNumber(this.serverNumber);
/*  69: 78 */       List contactosBase = casoEmergenciaDAO.list(datosPersonalesCompleto.getDatosPersonales().getDatp_usuf_cod());
/*  70:    */       
/*  71: 80 */       Map contactosBaseMap = new HashMap();
/*  72: 81 */       for (Iterator it = contactosBase.iterator(); it.hasNext();)
/*  73:    */       {
/*  74: 82 */         CasoEmergencia casoEmergencia = (CasoEmergencia)it.next();
/*  75: 83 */         contactosBaseMap.put(casoEmergencia.getCase_cod(), casoEmergencia);
/*  76:    */       }
/*  77: 86 */       for (Iterator it = datosPersonalesCompleto.getContactos().iterator(); it.hasNext();)
/*  78:    */       {
/*  79: 87 */         CasoEmergencia casoEmergencia = (CasoEmergencia)it.next();
/*  80: 88 */         casoEmergencia.setCase_usuf_cod(datosPersonalesCompleto.getDatosPersonales().getDatp_usuf_cod());
/*  81: 89 */         if (contactosBaseMap.containsKey(casoEmergencia.getCase_cod()))
/*  82:    */         {
/*  83: 90 */           casoEmergenciaDAO.update(casoEmergencia, llavesCasoEmergencia, conn);
/*  84: 91 */           contactosBaseMap.remove(casoEmergencia.getCase_cod());
/*  85:    */         }
/*  86:    */         else
/*  87:    */         {
/*  88: 93 */           casoEmergenciaDAO.insert(casoEmergencia, conn);
/*  89:    */         }
/*  90:    */       }
/*  91: 97 */       for (Iterator it = contactosBaseMap.values().iterator(); it.hasNext();)
/*  92:    */       {
/*  93: 98 */         CasoEmergencia casoEmergencia = (CasoEmergencia)it.next();
/*  94: 99 */         casoEmergenciaDAO.delete(casoEmergencia, conn);
/*  95:    */       }
/*  96:103 */       String[] llavesSeguros = { "segm_cod", "segm_usuf_cod" };
/*  97:104 */       SeguroMedicoDAO seguroMedicoDAO = new SeguroMedicoDAO();
/*  98:105 */       seguroMedicoDAO.setServerNumber(this.serverNumber);
/*  99:106 */       List segurosBase = seguroMedicoDAO.list(datosPersonalesCompleto.getDatosPersonales().getDatp_usuf_cod());
/* 100:    */       
/* 101:108 */       Map segurosBaseMap = new HashMap();
/* 102:109 */       for (Iterator it = segurosBase.iterator(); it.hasNext();)
/* 103:    */       {
/* 104:110 */         SeguroMedico seguroMedico = (SeguroMedico)it.next();
/* 105:111 */         segurosBaseMap.put(seguroMedico.getSegm_cod(), seguroMedico);
/* 106:    */       }
/* 107:114 */       for (Iterator it = datosPersonalesCompleto.getSeguros().iterator(); it.hasNext();)
/* 108:    */       {
/* 109:115 */         SeguroMedico seguroMedico = (SeguroMedico)it.next();
/* 110:116 */         seguroMedico.setSegm_usuf_cod(datosPersonalesCompleto.getDatosPersonales().getDatp_usuf_cod());
/* 111:117 */         seguroMedico.setSegm_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(seguroMedico.getSegm_vig_hasta().toString(), "yyyyMMdd", -2)));
/* 112:118 */         if (segurosBaseMap.containsKey(seguroMedico.getSegm_cod()))
/* 113:    */         {
/* 114:119 */           seguroMedicoDAO.update(seguroMedico, llavesSeguros, conn);
/* 115:120 */           segurosBaseMap.remove(seguroMedico.getSegm_cod());
/* 116:    */         }
/* 117:    */         else
/* 118:    */         {
/* 119:122 */           seguroMedicoDAO.insert(seguroMedico, conn);
/* 120:    */         }
/* 121:    */       }
/* 122:126 */       for (Iterator it = segurosBaseMap.values().iterator(); it.hasNext();)
/* 123:    */       {
/* 124:127 */         SeguroMedico seguroMedico = (SeguroMedico)it.next();
/* 125:128 */         seguroMedicoDAO.delete(seguroMedico, conn);
/* 126:    */       }
/* 127:131 */       if (!manejado) {
/* 128:132 */         conn.commit();
/* 129:    */       }
/* 130:    */     }
/* 131:    */     catch (Exception e)
/* 132:    */     {
/* 133:136 */       if (!manejado) {
/* 134:137 */         rollback(conn);
/* 135:    */       }
/* 136:139 */       throw e;
/* 137:    */     }
/* 138:    */     finally
/* 139:    */     {
/* 140:141 */       if (!manejado) {
/* 141:142 */         close(conn);
/* 142:    */       }
/* 143:    */     }
/* 144:    */   }
/* 145:    */   
/* 146:    */   public DatosPersonalesCompleto retrieve(BigDecimal usuf_cod)
/* 147:    */     throws Exception
/* 148:    */   {
/* 149:149 */     DatosPersonalesCompleto datosPersonalesCompleto = new DatosPersonalesCompleto();
/* 150:    */     try
/* 151:    */     {
/* 152:154 */       GruposUsuarioDAO gruposUsuarioDAO = new GruposUsuarioDAO();
/* 153:155 */       gruposUsuarioDAO.setServerNumber(this.serverNumber);
/* 154:156 */       datosPersonalesCompleto.setGrupoUsuario(gruposUsuarioDAO.search(usuf_cod, IGrupos.FAMILY_SEGUROS));
/* 155:    */       
/* 156:    */ 
/* 157:159 */       DatosPersonalesDAO datosPersonalesDAO = new DatosPersonalesDAO();
/* 158:160 */       datosPersonalesDAO.setServerNumber(this.serverNumber);
/* 159:161 */       datosPersonalesCompleto.setDatosPersonales(datosPersonalesDAO.retrive(usuf_cod));
/* 160:    */       
/* 161:    */ 
/* 162:164 */       UsuarioParentDAO usuarioParentDAO = new UsuarioParentDAO();
/* 163:165 */       usuarioParentDAO.setServerNumber(this.serverNumber);
/* 164:166 */       datosPersonalesCompleto.setUsuarioParent(usuarioParentDAO.retrieve(usuf_cod));
/* 165:    */       
/* 166:    */ 
/* 167:169 */       CasoEmergenciaDAO casoEmergenciaDAO = new CasoEmergenciaDAO();
/* 168:170 */       casoEmergenciaDAO.setServerNumber(this.serverNumber);
/* 169:171 */       datosPersonalesCompleto.setContactos(casoEmergenciaDAO.list(usuf_cod));
/* 170:    */       
/* 171:    */ 
/* 172:174 */       SeguroMedicoDAO seguroMedicoDAO = new SeguroMedicoDAO();
/* 173:175 */       seguroMedicoDAO.setServerNumber(this.serverNumber);
/* 174:176 */       datosPersonalesCompleto.setSeguros(seguroMedicoDAO.list(usuf_cod));
/* 175:    */     }
/* 176:    */     catch (Exception e)
/* 177:    */     {
/* 178:179 */       throw e;
/* 179:    */     }
/* 180:182 */     return datosPersonalesCompleto;
/* 181:    */   }
/* 182:    */   
/* 183:    */   public void delete(BigDecimal usuf_cod, Connection conn)
/* 184:    */     throws Exception
/* 185:    */   {
/* 186:187 */     boolean manejado = conn != null;
/* 187:    */     try
/* 188:    */     {
/* 189:191 */       if (!manejado)
/* 190:    */       {
/* 191:192 */         conn = this.ds.getConnection();
/* 192:193 */         conn.setAutoCommit(false);
/* 193:    */       }
/* 194:197 */       UsuarioParentDAO usuarioParentDAO = new UsuarioParentDAO();
/* 195:198 */       usuarioParentDAO.setServerNumber(this.serverNumber);
/* 196:199 */       usuarioParentDAO.delete(usuf_cod, conn);
/* 197:    */       
/* 198:    */ 
/* 199:202 */       CasoEmergenciaDAO casoEmergenciaDAO = new CasoEmergenciaDAO();
/* 200:203 */       casoEmergenciaDAO.setServerNumber(this.serverNumber);
/* 201:204 */       casoEmergenciaDAO.deleteAll(usuf_cod, conn);
/* 202:    */       
/* 203:    */ 
/* 204:207 */       SeguroMedicoDAO seguroMedicoDAO = new SeguroMedicoDAO();
/* 205:208 */       seguroMedicoDAO.setServerNumber(this.serverNumber);
/* 206:209 */       seguroMedicoDAO.deleteAll(usuf_cod, conn);
/* 207:    */       
/* 208:    */ 
/* 209:212 */       DatosPersonalesDAO datosPersonalesDAO = new DatosPersonalesDAO();
/* 210:213 */       datosPersonalesDAO.setServerNumber(this.serverNumber);
/* 211:214 */       datosPersonalesDAO.delete(usuf_cod, conn);
/* 212:    */       
/* 213:    */ 
/* 214:217 */       GruposUsuarioDAO gruposUsuarioDAO = new GruposUsuarioDAO();
/* 215:218 */       gruposUsuarioDAO.setServerNumber(this.serverNumber);
/* 216:219 */       GruposUsuario grupoUsuarioABorrar = new GruposUsuario();
/* 217:220 */       grupoUsuarioABorrar.setGrupu_cod(IGrupos.FAMILY_SEGUROS);
/* 218:221 */       grupoUsuarioABorrar.setGrupu_usuf_cod(usuf_cod);
/* 219:222 */       gruposUsuarioDAO.delete(grupoUsuarioABorrar, conn);
/* 220:224 */       if (!manejado) {
/* 221:225 */         conn.commit();
/* 222:    */       }
/* 223:    */     }
/* 224:    */     catch (Exception e)
/* 225:    */     {
/* 226:229 */       if (!manejado) {
/* 227:230 */         rollback(conn);
/* 228:    */       }
/* 229:232 */       throw e;
/* 230:    */     }
/* 231:    */     finally
/* 232:    */     {
/* 233:234 */       if (!manejado) {
/* 234:235 */         close(conn);
/* 235:    */       }
/* 236:    */     }
/* 237:    */   }
/* 238:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.dao.DatosPersonalesCompletoDAO
 * JD-Core Version:    0.7.0.1
 */