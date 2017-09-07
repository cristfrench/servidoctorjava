/*   1:    */ package com.servidoctor.sdpets.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.constantes.IConstantes;
/*   5:    */ import com.servidoctor.parametros.dao.VacunasCuidadosDAO;
/*   6:    */ import com.servidoctor.parametros.model.VacunasCuidados;
/*   7:    */ import com.servidoctor.sdpets.model.AlergiasPets;
/*   8:    */ import com.servidoctor.sdpets.model.CirugiasPets;
/*   9:    */ import com.servidoctor.sdpets.model.ContactosMascota;
/*  10:    */ import com.servidoctor.sdpets.model.ControlCuidados;
/*  11:    */ import com.servidoctor.sdpets.model.EnfermedadesPets;
/*  12:    */ import com.servidoctor.sdpets.model.GruposMascota;
/*  13:    */ import com.servidoctor.sdpets.model.Mascota;
/*  14:    */ import com.servidoctor.sdpets.model.MascotaAlimentacion;
/*  15:    */ import com.servidoctor.sdpets.model.MascotaCompleto;
/*  16:    */ import com.servidoctor.sdpets.model.MascotaMedicamentos;
/*  17:    */ import com.servidoctor.sdpets.model.PropietariosMascota;
/*  18:    */ import com.servidoctor.sdpets.model.SeguroPets;
/*  19:    */ import java.math.BigDecimal;
/*  20:    */ import java.sql.Connection;
/*  21:    */ import java.util.Collection;
/*  22:    */ import java.util.HashMap;
/*  23:    */ import java.util.Iterator;
/*  24:    */ import java.util.List;
/*  25:    */ import java.util.Map;
/*  26:    */ import javax.sql.DataSource;
/*  27:    */ 
/*  28:    */ public class MascotaCompletoDAO
/*  29:    */   extends DAO
/*  30:    */ {
/*  31:    */   public void update(MascotaCompleto mascotaCompleto, BigDecimal mas_cod)
/*  32:    */     throws Exception
/*  33:    */   {
/*  34: 37 */     Connection conn = null;
/*  35:    */     try
/*  36:    */     {
/*  37: 40 */       conn = this.ds.getConnection();
/*  38: 41 */       conn.setAutoCommit(false);
/*  39:    */       
/*  40:    */ 
/*  41: 44 */       String[] llavesMascota = { "mas_cod" };
/*  42: 45 */       MascotaDAO mascotaDAO = new MascotaDAO();
/*  43: 46 */       mascotaDAO.setServerNumber(this.serverNumber);
/*  44: 47 */       mascotaDAO.update(mascotaCompleto.getMascota(), llavesMascota, conn);
/*  45:    */       
/*  46:    */ 
/*  47: 50 */       String[] llavesPropietario = { "pmas_cod", "pmas_mas_cod" };
/*  48: 51 */       PropietariosMascotaDAO propietariosMascotaDAO = new PropietariosMascotaDAO();
/*  49: 52 */       propietariosMascotaDAO.setServerNumber(this.serverNumber);
/*  50: 53 */       propietariosMascotaDAO.update(mascotaCompleto.getPropietarioMascota(), llavesPropietario, conn);
/*  51:    */       
/*  52:    */ 
/*  53: 56 */       String[] llavesAlimentacion = { "mali_cod", "mali_mas_cod" };
/*  54: 57 */       MascotaAlimentacionDAO mascotaAlimentacionDAO = new MascotaAlimentacionDAO();
/*  55: 58 */       mascotaAlimentacionDAO.setServerNumber(this.serverNumber);
/*  56: 59 */       mascotaAlimentacionDAO.update(mascotaCompleto.getMascotaAlimentacion(), llavesAlimentacion, conn);
/*  57:    */       
/*  58:    */ 
/*  59: 62 */       String[] llavesContacto = { "cmas_cod", "cmas_mas_cod" };
/*  60: 63 */       ContactosMascotaDAO contactosMascotaDAO = new ContactosMascotaDAO();
/*  61: 64 */       contactosMascotaDAO.setServerNumber(this.serverNumber);
/*  62: 65 */       contactosMascotaDAO.update(mascotaCompleto.getContactoMascota(), llavesContacto, conn);
/*  63:    */       
/*  64:    */ 
/*  65: 68 */       String[] llavesTablaAjustada = { "vcui_cod", "vcui_mas_cod" };
/*  66: 69 */       VacunasCuidadosDAO vacunasCuidadosDAO = new VacunasCuidadosDAO();
/*  67: 70 */       vacunasCuidadosDAO.setServerNumber(this.serverNumber);
/*  68: 71 */       List tablaAjustadaBase = vacunasCuidadosDAO.list(mas_cod);
/*  69:    */       
/*  70: 73 */       Map tablaAjustadaBaseMap = new HashMap();
/*  71: 74 */       for (Iterator it = tablaAjustadaBase.iterator(); it.hasNext();)
/*  72:    */       {
/*  73: 75 */         VacunasCuidados vacunasCuidados = (VacunasCuidados)it.next();
/*  74: 76 */         tablaAjustadaBaseMap.put(vacunasCuidados.getVcui_cod(), vacunasCuidados);
/*  75:    */       }
/*  76: 79 */       for (Iterator it = mascotaCompleto.getTablaAjustada().iterator(); it.hasNext();)
/*  77:    */       {
/*  78: 80 */         VacunasCuidados vacunasCuidados = (VacunasCuidados)it.next();
/*  79: 81 */         if (tablaAjustadaBaseMap.containsKey(vacunasCuidados.getVcui_cod()))
/*  80:    */         {
/*  81: 82 */           vacunasCuidadosDAO.update(vacunasCuidados, llavesTablaAjustada, conn);
/*  82: 83 */           tablaAjustadaBaseMap.remove(vacunasCuidados.getVcui_cod());
/*  83:    */         }
/*  84:    */         else
/*  85:    */         {
/*  86: 85 */           vacunasCuidadosDAO.insert(vacunasCuidados, conn);
/*  87:    */         }
/*  88:    */       }
/*  89: 89 */       for (Iterator it = tablaAjustadaBaseMap.values().iterator(); it.hasNext();)
/*  90:    */       {
/*  91: 90 */         VacunasCuidados vacunasCuidados = (VacunasCuidados)it.next();
/*  92: 91 */         vacunasCuidadosDAO.delete(vacunasCuidados, conn);
/*  93:    */       }
/*  94: 95 */       String[] llavesControles = { "ccui_cod", "ccui_mas_cod" };
/*  95: 96 */       ControlCuidadosDAO controlCuidadosDAO = new ControlCuidadosDAO();
/*  96: 97 */       controlCuidadosDAO.setServerNumber(this.serverNumber);
/*  97: 98 */       List controlesAnterioresBase = controlCuidadosDAO.list(mas_cod);
/*  98:    */       
/*  99:100 */       Map controlesAnterioresBaseMap = new HashMap();
/* 100:101 */       for (Iterator it = controlesAnterioresBase.iterator(); it.hasNext();)
/* 101:    */       {
/* 102:102 */         ControlCuidados controlCuidados = (ControlCuidados)it.next();
/* 103:103 */         controlesAnterioresBaseMap.put(controlCuidados.getCcui_cod(), controlCuidados);
/* 104:    */       }
/* 105:106 */       for (Iterator it = mascotaCompleto.getControles().iterator(); it.hasNext();)
/* 106:    */       {
/* 107:107 */         ControlCuidados controlCuidados = (ControlCuidados)it.next();
/* 108:108 */         controlCuidados.setCcui_vcui_cod(controlCuidados.getElementoTabla().getVcui_cod());
/* 109:109 */         if (controlesAnterioresBaseMap.containsKey(controlCuidados.getCcui_cod()))
/* 110:    */         {
/* 111:110 */           controlCuidadosDAO.update(controlCuidados, llavesControles, conn);
/* 112:111 */           controlesAnterioresBaseMap.remove(controlCuidados.getCcui_cod());
/* 113:    */         }
/* 114:    */         else
/* 115:    */         {
/* 116:113 */           controlCuidadosDAO.insert(controlCuidados, conn);
/* 117:    */         }
/* 118:    */       }
/* 119:117 */       for (Iterator it = controlesAnterioresBaseMap.values().iterator(); it.hasNext();)
/* 120:    */       {
/* 121:118 */         ControlCuidados controlCuidados = (ControlCuidados)it.next();
/* 122:119 */         controlCuidadosDAO.delete(controlCuidados, conn);
/* 123:    */       }
/* 124:123 */       String[] llavesMedicamentos = { "mmed_cod", "mmed_mas_cod" };
/* 125:124 */       MascotaMedicamentosDAO mascotaMedicamentosDAO = new MascotaMedicamentosDAO();
/* 126:125 */       mascotaMedicamentosDAO.setServerNumber(this.serverNumber);
/* 127:126 */       List mascotaMedicamentosBase = mascotaMedicamentosDAO.list(mas_cod);
/* 128:    */       
/* 129:128 */       Map mascotaMedicamentosBaseMap = new HashMap();
/* 130:129 */       for (Iterator it = mascotaMedicamentosBase.iterator(); it.hasNext();)
/* 131:    */       {
/* 132:130 */         MascotaMedicamentos mascotaMedicamentos = (MascotaMedicamentos)it.next();
/* 133:131 */         mascotaMedicamentosBaseMap.put(mascotaMedicamentos.getMmed_cod(), mascotaMedicamentos);
/* 134:    */       }
/* 135:134 */       for (Iterator it = mascotaCompleto.getMedicamentos().iterator(); it.hasNext();)
/* 136:    */       {
/* 137:135 */         MascotaMedicamentos mascotaMedicamentos = (MascotaMedicamentos)it.next();
/* 138:136 */         if (mascotaMedicamentosBaseMap.containsKey(mascotaMedicamentos.getMmed_cod()))
/* 139:    */         {
/* 140:137 */           mascotaMedicamentosDAO.update(mascotaMedicamentos, llavesMedicamentos, conn);
/* 141:138 */           mascotaMedicamentosBaseMap.remove(mascotaMedicamentos.getMmed_cod());
/* 142:    */         }
/* 143:    */         else
/* 144:    */         {
/* 145:140 */           mascotaMedicamentosDAO.insert(mascotaMedicamentos, conn);
/* 146:    */         }
/* 147:    */       }
/* 148:144 */       for (Iterator it = mascotaMedicamentosBaseMap.values().iterator(); it.hasNext();)
/* 149:    */       {
/* 150:145 */         MascotaMedicamentos mascotaMedicamentos = (MascotaMedicamentos)it.next();
/* 151:146 */         mascotaMedicamentosDAO.delete(mascotaMedicamentos, conn);
/* 152:    */       }
/* 153:150 */       String[] llavesSeguros = { "segp_cod", "segp_mas_cod" };
/* 154:151 */       SeguroPetsDAO seguroPetsDAO = new SeguroPetsDAO();
/* 155:152 */       seguroPetsDAO.setServerNumber(this.serverNumber);
/* 156:153 */       List seguroPetsBase = seguroPetsDAO.list(mas_cod);
/* 157:    */       
/* 158:155 */       Map seguroPetsBaseMap = new HashMap();
/* 159:156 */       for (Iterator it = seguroPetsBase.iterator(); it.hasNext();)
/* 160:    */       {
/* 161:157 */         SeguroPets seguroPets = (SeguroPets)it.next();
/* 162:158 */         seguroPetsBaseMap.put(seguroPets.getSegp_cod(), seguroPets);
/* 163:    */       }
/* 164:161 */       for (Iterator it = mascotaCompleto.getSeguros().iterator(); it.hasNext();)
/* 165:    */       {
/* 166:162 */         SeguroPets seguroPets = (SeguroPets)it.next();
/* 167:163 */         if (seguroPetsBaseMap.containsKey(seguroPets.getSegp_cod()))
/* 168:    */         {
/* 169:164 */           seguroPetsDAO.update(seguroPets, llavesSeguros, conn);
/* 170:165 */           seguroPetsBaseMap.remove(seguroPets.getSegp_cod());
/* 171:    */         }
/* 172:    */         else
/* 173:    */         {
/* 174:167 */           seguroPetsDAO.insert(seguroPets, conn);
/* 175:    */         }
/* 176:    */       }
/* 177:172 */       for (Iterator it = seguroPetsBaseMap.values().iterator(); it.hasNext();)
/* 178:    */       {
/* 179:173 */         SeguroPets seguroPets = (SeguroPets)it.next();
/* 180:174 */         seguroPetsDAO.delete(seguroPets, conn);
/* 181:    */       }
/* 182:178 */       String[] llavesEnfermedades = { "enfp_cod", "enfp_mas_cod" };
/* 183:179 */       EnfermedadesPetsDAO enfermedadesPetsDAO = new EnfermedadesPetsDAO();
/* 184:180 */       enfermedadesPetsDAO.setServerNumber(this.serverNumber);
/* 185:181 */       List enfermedadesPetsBase = enfermedadesPetsDAO.list(mas_cod);
/* 186:    */       
/* 187:183 */       Map enfermedadesPetsBaseMap = new HashMap();
/* 188:184 */       for (Iterator it = enfermedadesPetsBase.iterator(); it.hasNext();)
/* 189:    */       {
/* 190:185 */         EnfermedadesPets enfermedadesPets = (EnfermedadesPets)it.next();
/* 191:186 */         enfermedadesPetsBaseMap.put(enfermedadesPets.getEnfp_cod(), enfermedadesPets);
/* 192:    */       }
/* 193:189 */       for (Iterator it = mascotaCompleto.getEnfermedades().iterator(); it.hasNext();)
/* 194:    */       {
/* 195:190 */         EnfermedadesPets enfermedadesPets = (EnfermedadesPets)it.next();
/* 196:191 */         if (enfermedadesPetsBaseMap.containsKey(enfermedadesPets.getEnfp_cod()))
/* 197:    */         {
/* 198:192 */           enfermedadesPetsDAO.update(enfermedadesPets, llavesEnfermedades, conn);
/* 199:193 */           enfermedadesPetsBaseMap.remove(enfermedadesPets.getEnfp_cod());
/* 200:    */         }
/* 201:    */         else
/* 202:    */         {
/* 203:195 */           enfermedadesPetsDAO.insert(enfermedadesPets, conn);
/* 204:    */         }
/* 205:    */       }
/* 206:200 */       for (Iterator it = enfermedadesPetsBaseMap.values().iterator(); it.hasNext();)
/* 207:    */       {
/* 208:201 */         EnfermedadesPets enfermedadesPets = (EnfermedadesPets)it.next();
/* 209:202 */         enfermedadesPetsDAO.delete(enfermedadesPets, conn);
/* 210:    */       }
/* 211:206 */       String[] llavesCirugias = { "cirp_cod", "cirp_mas_cod" };
/* 212:207 */       CirugiasPetsDAO cirugiasPetsDAO = new CirugiasPetsDAO();
/* 213:208 */       cirugiasPetsDAO.setServerNumber(this.serverNumber);
/* 214:209 */       List cirugiasPetsBase = cirugiasPetsDAO.list(mas_cod);
/* 215:    */       
/* 216:211 */       Map cirugiasPetsBaseMap = new HashMap();
/* 217:212 */       for (Iterator it = cirugiasPetsBase.iterator(); it.hasNext();)
/* 218:    */       {
/* 219:213 */         CirugiasPets cirugiasPets = (CirugiasPets)it.next();
/* 220:214 */         cirugiasPetsBaseMap.put(cirugiasPets.getCirp_cod(), cirugiasPets);
/* 221:    */       }
/* 222:217 */       for (Iterator it = mascotaCompleto.getCirugias().iterator(); it.hasNext();)
/* 223:    */       {
/* 224:218 */         CirugiasPets cirugiasPets = (CirugiasPets)it.next();
/* 225:219 */         if (cirugiasPetsBaseMap.containsKey(cirugiasPets.getCirp_cod()))
/* 226:    */         {
/* 227:220 */           cirugiasPetsDAO.update(cirugiasPets, llavesCirugias, conn);
/* 228:221 */           cirugiasPetsBaseMap.remove(cirugiasPets.getCirp_cod());
/* 229:    */         }
/* 230:    */         else
/* 231:    */         {
/* 232:223 */           cirugiasPetsDAO.insert(cirugiasPets, conn);
/* 233:    */         }
/* 234:    */       }
/* 235:228 */       for (Iterator it = cirugiasPetsBaseMap.values().iterator(); it.hasNext();)
/* 236:    */       {
/* 237:229 */         CirugiasPets cirugiasPets = (CirugiasPets)it.next();
/* 238:230 */         cirugiasPetsDAO.delete(cirugiasPets, conn);
/* 239:    */       }
/* 240:234 */       String[] llavesAlergias = { "alep_cod", "alep_mas_cod" };
/* 241:235 */       AlergiasPetsDAO alergiasPetsDAO = new AlergiasPetsDAO();
/* 242:236 */       alergiasPetsDAO.setServerNumber(this.serverNumber);
/* 243:237 */       List alergiasPetsBase = alergiasPetsDAO.list(mas_cod);
/* 244:    */       
/* 245:239 */       Map alergiasPetsBaseMap = new HashMap();
/* 246:240 */       for (Iterator it = alergiasPetsBase.iterator(); it.hasNext();)
/* 247:    */       {
/* 248:241 */         AlergiasPets alergiasPets = (AlergiasPets)it.next();
/* 249:242 */         alergiasPetsBaseMap.put(alergiasPets.getAlep_cod(), alergiasPets);
/* 250:    */       }
/* 251:245 */       for (Iterator it = mascotaCompleto.getAlergias().iterator(); it.hasNext();)
/* 252:    */       {
/* 253:246 */         AlergiasPets alergiasPets = (AlergiasPets)it.next();
/* 254:247 */         if (alergiasPetsBaseMap.containsKey(alergiasPets.getAlep_cod()))
/* 255:    */         {
/* 256:248 */           alergiasPetsDAO.update(alergiasPets, llavesAlergias, conn);
/* 257:249 */           alergiasPetsBaseMap.remove(alergiasPets.getAlep_cod());
/* 258:    */         }
/* 259:    */         else
/* 260:    */         {
/* 261:251 */           alergiasPetsDAO.insert(alergiasPets, conn);
/* 262:    */         }
/* 263:    */       }
/* 264:256 */       for (Iterator it = alergiasPetsBaseMap.values().iterator(); it.hasNext();)
/* 265:    */       {
/* 266:257 */         AlergiasPets alergiasPets = (AlergiasPets)it.next();
/* 267:258 */         alergiasPetsDAO.delete(alergiasPets, conn);
/* 268:    */       }
/* 269:263 */       String[] llavesGrupos = { "grupm_cod", "grupm_mas_cod" };
/* 270:264 */       GruposMascotaDAO gruposMascotaDAO = new GruposMascotaDAO();
/* 271:265 */       gruposMascotaDAO.setServerNumber(this.serverNumber);
/* 272:266 */       List gruposBase = gruposMascotaDAO.list(mas_cod);
/* 273:    */       
/* 274:268 */       Map gruposBaseMap = new HashMap();
/* 275:269 */       for (Iterator it = gruposBase.iterator(); it.hasNext();)
/* 276:    */       {
/* 277:270 */         GruposMascota gruposMascota = (GruposMascota)it.next();
/* 278:271 */         gruposBaseMap.put(gruposMascota.getGrupm_grup_cod(), gruposMascota);
/* 279:    */       }
/* 280:274 */       for (Iterator it = mascotaCompleto.getGrupos().iterator(); it.hasNext();)
/* 281:    */       {
/* 282:275 */         GruposMascota gruposMascota = (GruposMascota)it.next();
/* 283:276 */         gruposMascota.setGrupm_mas_cod(mas_cod);
/* 284:277 */         if (gruposBaseMap.containsKey(gruposMascota.getGrupm_grup_cod()))
/* 285:    */         {
/* 286:278 */           gruposMascotaDAO.update(gruposMascota, llavesGrupos, conn);
/* 287:279 */           gruposBaseMap.remove(gruposMascota.getGrupm_cod());
/* 288:    */         }
/* 289:    */         else
/* 290:    */         {
/* 291:281 */           gruposMascotaDAO.insert(gruposMascota, conn);
/* 292:    */         }
/* 293:    */       }
/* 294:290 */       conn.commit();
/* 295:    */     }
/* 296:    */     catch (Exception e)
/* 297:    */     {
/* 298:292 */       rollback(conn);
/* 299:293 */       throw e;
/* 300:    */     }
/* 301:    */     finally
/* 302:    */     {
/* 303:295 */       close(conn);
/* 304:    */     }
/* 305:    */   }
/* 306:    */   
/* 307:    */   public MascotaCompleto retrieve(BigDecimal mas_cod)
/* 308:    */     throws Exception
/* 309:    */   {
/* 310:301 */     MascotaCompleto mascotaCompleto = new MascotaCompleto();
/* 311:    */     try
/* 312:    */     {
/* 313:306 */       MascotaDAO mascotaDAO = new MascotaDAO();
/* 314:307 */       mascotaDAO.setServerNumber(this.serverNumber);
/* 315:308 */       mascotaCompleto.setMascota(mascotaDAO.retrieve(mas_cod));
/* 316:    */       
/* 317:    */ 
/* 318:311 */       PropietariosMascotaDAO propietariosMascotaDAO = new PropietariosMascotaDAO();
/* 319:312 */       propietariosMascotaDAO.setServerNumber(this.serverNumber);
/* 320:313 */       mascotaCompleto.setPropietarioMascota((PropietariosMascota)propietariosMascotaDAO.list(mas_cod).get(0));
/* 321:    */       
/* 322:    */ 
/* 323:316 */       MascotaAlimentacionDAO mascotaAlimentacionDAO = new MascotaAlimentacionDAO();
/* 324:317 */       mascotaAlimentacionDAO.setServerNumber(this.serverNumber);
/* 325:318 */       mascotaCompleto.setMascotaAlimentacion((MascotaAlimentacion)mascotaAlimentacionDAO.list(mas_cod).get(0));
/* 326:    */       
/* 327:    */ 
/* 328:321 */       ContactosMascotaDAO contactosMascotaDAO = new ContactosMascotaDAO();
/* 329:322 */       contactosMascotaDAO.setServerNumber(this.serverNumber);
/* 330:323 */       mascotaCompleto.setContactoMascota((ContactosMascota)contactosMascotaDAO.list(mas_cod).get(0));
/* 331:    */       
/* 332:    */ 
/* 333:326 */       VacunasCuidadosDAO vacunasCuidadosDAO = new VacunasCuidadosDAO();
/* 334:327 */       vacunasCuidadosDAO.setServerNumber(this.serverNumber);
/* 335:328 */       mascotaCompleto.setTablaAjustada(vacunasCuidadosDAO.list(mas_cod));
/* 336:    */       
/* 337:    */ 
/* 338:331 */       vacunasCuidadosDAO.setIdioma(this.idioma);
/* 339:332 */       mascotaCompleto.setTablaUniversal(vacunasCuidadosDAO.list(IConstantes.CODIGO_MASCOTA_DEFAULT, new BigDecimal(mascotaCompleto.getMascota().getMas_tipo())));
/* 340:    */       
/* 341:    */ 
/* 342:335 */       ControlCuidadosDAO controlCuidadosDAO = new ControlCuidadosDAO();
/* 343:336 */       controlCuidadosDAO.setServerNumber(this.serverNumber);
/* 344:337 */       mascotaCompleto.setControles(controlCuidadosDAO.list(mas_cod));
/* 345:    */       
/* 346:339 */       int x = 0;
/* 347:340 */       while (x < mascotaCompleto.getControles().size())
/* 348:    */       {
/* 349:341 */         ControlCuidados controlCuidados = (ControlCuidados)mascotaCompleto.getControles().get(x);
/* 350:342 */         VacunasCuidados vacunasCuidados = new VacunasCuidados();
/* 351:343 */         vacunasCuidados.setVcui_mas_cod(controlCuidados.getCcui_mas_cod());
/* 352:344 */         vacunasCuidados.setVcui_cod(controlCuidados.getCcui_vcui_cod());
/* 353:345 */         vacunasCuidados = (VacunasCuidados)mascotaCompleto.getTablaAjustada().get(mascotaCompleto.getTablaAjustada().indexOf(vacunasCuidados));
/* 354:346 */         controlCuidados.setElementoTabla(vacunasCuidados);
/* 355:347 */         x++;
/* 356:    */       }
/* 357:351 */       MascotaMedicamentosDAO mascotaMedicamentosDAO = new MascotaMedicamentosDAO();
/* 358:352 */       mascotaMedicamentosDAO.setServerNumber(this.serverNumber);
/* 359:353 */       mascotaCompleto.setMedicamentos(mascotaMedicamentosDAO.list(mas_cod));
/* 360:    */       
/* 361:    */ 
/* 362:356 */       SeguroPetsDAO seguroPetsDAO = new SeguroPetsDAO();
/* 363:357 */       seguroPetsDAO.setServerNumber(this.serverNumber);
/* 364:358 */       mascotaCompleto.setSeguros(seguroPetsDAO.list(mas_cod));
/* 365:    */       
/* 366:    */ 
/* 367:361 */       EnfermedadesPetsDAO enfermedadesPetsDAO = new EnfermedadesPetsDAO();
/* 368:362 */       enfermedadesPetsDAO.setServerNumber(this.serverNumber);
/* 369:363 */       mascotaCompleto.setEnfermedades(enfermedadesPetsDAO.list(mas_cod));
/* 370:    */       
/* 371:    */ 
/* 372:366 */       CirugiasPetsDAO cirugiasPetsDAO = new CirugiasPetsDAO();
/* 373:367 */       cirugiasPetsDAO.setServerNumber(this.serverNumber);
/* 374:368 */       mascotaCompleto.setCirugias(cirugiasPetsDAO.list(mas_cod));
/* 375:    */       
/* 376:    */ 
/* 377:371 */       AlergiasPetsDAO alergiasPetsDAO = new AlergiasPetsDAO();
/* 378:372 */       alergiasPetsDAO.setServerNumber(this.serverNumber);
/* 379:373 */       mascotaCompleto.setAlergias(alergiasPetsDAO.list(mas_cod));
/* 380:    */     }
/* 381:    */     catch (Exception e)
/* 382:    */     {
/* 383:376 */       throw e;
/* 384:    */     }
/* 385:379 */     return mascotaCompleto;
/* 386:    */   }
/* 387:    */   
/* 388:    */   public void delete(BigDecimal mas_cod)
/* 389:    */     throws Exception
/* 390:    */   {
/* 391:384 */     Connection conn = null;
/* 392:    */     try
/* 393:    */     {
/* 394:387 */       conn = this.ds.getConnection();
/* 395:388 */       conn.setAutoCommit(false);
/* 396:    */       
/* 397:    */ 
/* 398:391 */       MascotaDAO mascotaDAO = new MascotaDAO();
/* 399:392 */       mascotaDAO.setServerNumber(this.serverNumber);
/* 400:393 */       mascotaDAO.delete(mas_cod, conn);
/* 401:    */       
/* 402:    */ 
/* 403:396 */       PropietariosMascotaDAO propietariosMascotaDAO = new PropietariosMascotaDAO();
/* 404:397 */       propietariosMascotaDAO.setServerNumber(this.serverNumber);
/* 405:398 */       propietariosMascotaDAO.deleteAll(mas_cod, conn);
/* 406:    */       
/* 407:    */ 
/* 408:401 */       MascotaAlimentacionDAO mascotaAlimentacionDAO = new MascotaAlimentacionDAO();
/* 409:402 */       mascotaAlimentacionDAO.setServerNumber(this.serverNumber);
/* 410:403 */       mascotaAlimentacionDAO.deleteAll(mas_cod, conn);
/* 411:    */       
/* 412:    */ 
/* 413:406 */       ContactosMascotaDAO contactosMascotaDAO = new ContactosMascotaDAO();
/* 414:407 */       contactosMascotaDAO.setServerNumber(this.serverNumber);
/* 415:408 */       contactosMascotaDAO.deleteAll(mas_cod, conn);
/* 416:    */       
/* 417:    */ 
/* 418:411 */       VacunasCuidadosDAO vacunasCuidadosDAO = new VacunasCuidadosDAO();
/* 419:412 */       vacunasCuidadosDAO.setServerNumber(this.serverNumber);
/* 420:413 */       vacunasCuidadosDAO.deleteAll(mas_cod, conn);
/* 421:    */       
/* 422:    */ 
/* 423:416 */       ControlCuidadosDAO controlCuidadosDAO = new ControlCuidadosDAO();
/* 424:417 */       controlCuidadosDAO.setServerNumber(this.serverNumber);
/* 425:418 */       controlCuidadosDAO.deleteAll(mas_cod, conn);
/* 426:    */       
/* 427:    */ 
/* 428:421 */       MascotaMedicamentosDAO mascotaMedicamentosDAO = new MascotaMedicamentosDAO();
/* 429:422 */       mascotaMedicamentosDAO.setServerNumber(this.serverNumber);
/* 430:423 */       mascotaMedicamentosDAO.deleteAll(mas_cod, conn);
/* 431:    */       
/* 432:    */ 
/* 433:426 */       SeguroPetsDAO seguroPetsDAO = new SeguroPetsDAO();
/* 434:427 */       seguroPetsDAO.setServerNumber(this.serverNumber);
/* 435:428 */       seguroPetsDAO.deleteAll(mas_cod, conn);
/* 436:    */       
/* 437:    */ 
/* 438:431 */       EnfermedadesPetsDAO enfermedadesPetsDAO = new EnfermedadesPetsDAO();
/* 439:432 */       enfermedadesPetsDAO.setServerNumber(this.serverNumber);
/* 440:433 */       enfermedadesPetsDAO.deleteAll(mas_cod, conn);
/* 441:    */       
/* 442:    */ 
/* 443:436 */       CirugiasPetsDAO cirugiasPetsDAO = new CirugiasPetsDAO();
/* 444:437 */       cirugiasPetsDAO.setServerNumber(this.serverNumber);
/* 445:438 */       cirugiasPetsDAO.deleteAll(mas_cod, conn);
/* 446:    */       
/* 447:    */ 
/* 448:441 */       AlergiasPetsDAO alergiasPetsDAO = new AlergiasPetsDAO();
/* 449:442 */       alergiasPetsDAO.setServerNumber(this.serverNumber);
/* 450:443 */       alergiasPetsDAO.deleteAll(mas_cod, conn);
/* 451:    */       
/* 452:    */ 
/* 453:446 */       GruposMascotaDAO gruposMascotaDAO = new GruposMascotaDAO();
/* 454:447 */       gruposMascotaDAO.setServerNumber(this.serverNumber);
/* 455:448 */       gruposMascotaDAO.deleteAll(mas_cod, conn);
/* 456:    */       
/* 457:450 */       conn.commit();
/* 458:    */     }
/* 459:    */     catch (Exception e)
/* 460:    */     {
/* 461:453 */       rollback(conn);
/* 462:454 */       throw e;
/* 463:    */     }
/* 464:    */     finally
/* 465:    */     {
/* 466:456 */       close(conn);
/* 467:    */     }
/* 468:    */   }
/* 469:    */   
/* 470:    */   public void insert(MascotaCompleto mascotaCompleto)
/* 471:    */     throws Exception
/* 472:    */   {
/* 473:462 */     Connection conn = null;
/* 474:    */     try
/* 475:    */     {
/* 476:465 */       conn = this.ds.getConnection();
/* 477:466 */       conn.setAutoCommit(false);
/* 478:    */       
/* 479:    */ 
/* 480:469 */       MascotaDAO mascotaDAO = new MascotaDAO();
/* 481:470 */       mascotaDAO.setServerNumber(this.serverNumber);
/* 482:471 */       mascotaDAO.insert(mascotaCompleto.getMascota(), conn);
/* 483:    */       
/* 484:473 */       BigDecimal mas_cod = mascotaCompleto.getMascota().getMas_cod();
/* 485:    */       
/* 486:    */ 
/* 487:476 */       PropietariosMascotaDAO propietariosMascotaDAO = new PropietariosMascotaDAO();
/* 488:477 */       propietariosMascotaDAO.setServerNumber(this.serverNumber);
/* 489:478 */       mascotaCompleto.getPropietarioMascota().setPmas_mas_cod(mascotaCompleto.getMascota().getMas_cod());
/* 490:479 */       propietariosMascotaDAO.insert(mascotaCompleto.getPropietarioMascota(), conn);
/* 491:    */       
/* 492:    */ 
/* 493:482 */       MascotaAlimentacionDAO mascotaAlimentacionDAO = new MascotaAlimentacionDAO();
/* 494:483 */       mascotaAlimentacionDAO.setServerNumber(this.serverNumber);
/* 495:484 */       mascotaCompleto.getMascotaAlimentacion().setMali_mas_cod(mascotaCompleto.getMascota().getMas_cod());
/* 496:485 */       mascotaAlimentacionDAO.insert(mascotaCompleto.getMascotaAlimentacion(), conn);
/* 497:    */       
/* 498:    */ 
/* 499:488 */       ContactosMascotaDAO contactosMascotaDAO = new ContactosMascotaDAO();
/* 500:489 */       contactosMascotaDAO.setServerNumber(this.serverNumber);
/* 501:490 */       mascotaCompleto.getContactoMascota().setCmas_mas_cod(mascotaCompleto.getMascota().getMas_cod());
/* 502:491 */       contactosMascotaDAO.insert(mascotaCompleto.getContactoMascota(), conn);
/* 503:    */       
/* 504:    */ 
/* 505:    */ 
/* 506:495 */       VacunasCuidadosDAO vacunasCuidadosDAO = new VacunasCuidadosDAO();
/* 507:496 */       vacunasCuidadosDAO.setServerNumber(this.serverNumber);
/* 508:497 */       for (Iterator it = mascotaCompleto.getTablaAjustada().iterator(); it.hasNext();)
/* 509:    */       {
/* 510:498 */         VacunasCuidados vacunasCuidados = (VacunasCuidados)it.next();
/* 511:499 */         vacunasCuidados.setVcui_mas_cod(mas_cod);
/* 512:500 */         vacunasCuidadosDAO.insert(vacunasCuidados, conn);
/* 513:    */       }
/* 514:504 */       ControlCuidadosDAO controlCuidadosDAO = new ControlCuidadosDAO();
/* 515:505 */       controlCuidadosDAO.setServerNumber(this.serverNumber);
/* 516:506 */       for (Iterator it = mascotaCompleto.getControles().iterator(); it.hasNext();)
/* 517:    */       {
/* 518:507 */         ControlCuidados controlCuidados = (ControlCuidados)it.next();
/* 519:508 */         controlCuidados.setCcui_vcui_cod(controlCuidados.getElementoTabla().getVcui_cod());
/* 520:509 */         controlCuidados.setCcui_mas_cod(mas_cod);
/* 521:510 */         controlCuidadosDAO.insert(controlCuidados, conn);
/* 522:    */       }
/* 523:514 */       GruposMascotaDAO gruposMascotaDAO = new GruposMascotaDAO();
/* 524:515 */       gruposMascotaDAO.setServerNumber(this.serverNumber);
/* 525:516 */       for (Iterator it = mascotaCompleto.getGrupos().iterator(); it.hasNext();)
/* 526:    */       {
/* 527:517 */         GruposMascota gruposMascota = (GruposMascota)it.next();
/* 528:518 */         gruposMascota.setGrupm_mas_cod(mas_cod);
/* 529:519 */         gruposMascotaDAO.insert(gruposMascota, conn);
/* 530:    */       }
/* 531:521 */       conn.commit();
/* 532:    */     }
/* 533:    */     catch (Exception e)
/* 534:    */     {
/* 535:524 */       rollback(conn);
/* 536:525 */       throw e;
/* 537:    */     }
/* 538:    */     finally
/* 539:    */     {
/* 540:527 */       close(conn);
/* 541:    */     }
/* 542:    */   }
/* 543:    */ }



/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\

 * Qualified Name:     com.servidoctor.sdpets.dao.MascotaCompletoDAO

 * JD-Core Version:    0.7.0.1

 */