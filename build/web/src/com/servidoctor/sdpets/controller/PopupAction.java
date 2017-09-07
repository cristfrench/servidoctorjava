/*   1:    */ package com.servidoctor.sdpets.controller;
/*   2:    */ 
/*   3:    */ import com.essecorp.util.GestorFechasCompleto;
/*   4:    */ import com.servidoctor.constantes.IGrupos;
/*   5:    */ import com.servidoctor.parametros.controller.VacunasCuidadosForm;
/*   6:    */ import com.servidoctor.parametros.dao.CiudadDAO;
/*   7:    */ import com.servidoctor.parametros.dao.PaisDAO;
/*   8:    */ import com.servidoctor.parametros.dao.TipoCuidadoDAO;
/*   9:    */ import com.servidoctor.parametros.model.Paises;
/*  10:    */ import com.servidoctor.parametros.model.VacunasCuidados;
/*  11:    */ import com.servidoctor.sdpets.dao.MascotaDAO;
/*  12:    */ import com.servidoctor.sdpets.model.AlergiasPets;
/*  13:    */ import com.servidoctor.sdpets.model.CirugiasPets;
/*  14:    */ import com.servidoctor.sdpets.model.ControlCuidados;
/*  15:    */ import com.servidoctor.sdpets.model.EnfermedadesPets;
/*  16:    */ import com.servidoctor.sdpets.model.GruposMascota;
/*  17:    */ import com.servidoctor.sdpets.model.Mascota;
/*  18:    */ import com.servidoctor.sdpets.model.MascotaMedicamentos;
/*  19:    */ import com.servidoctor.sdpets.model.SeguroPets;
/*  20:    */ import com.servidoctor.seguridad.model.Servidores;
/*  21:    */ import com.servidoctor.util.classes.InicializaData;
/*  22:    */ import com.servidoctor.util.classes.ManejoFechas;
/*  23:    */ import java.math.BigDecimal;
/*  24:    */ import java.util.ArrayList;
/*  25:    */ import java.util.List;
/*  26:    */ import javax.servlet.http.HttpServletRequest;
/*  27:    */ import javax.servlet.http.HttpServletResponse;
/*  28:    */ import javax.servlet.http.HttpSession;
/*  29:    */ import javax.sql.DataSource;
/*  30:    */ import org.apache.commons.beanutils.BeanUtils;
/*  31:    */ import org.apache.struts.action.Action;
/*  32:    */ import org.apache.struts.action.ActionForm;
/*  33:    */ import org.apache.struts.action.ActionForward;
/*  34:    */ import org.apache.struts.action.ActionMapping;
/*  35:    */ 
/*  36:    */ public class PopupAction
/*  37:    */   extends Action
/*  38:    */ {
/*  39: 41 */   private DataSource ds = null;
/*  40:    */   
/*  41:    */   public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  42:    */     throws Exception
/*  43:    */   {
/*  44: 44 */     ActionForward myforward = null;
/*  45: 45 */     String myaction = mapping.getParameter();
/*  46: 47 */     if ("".equalsIgnoreCase(myaction)) {
/*  47: 48 */       myforward = mapping.findForward("failure");
/*  48: 49 */     } else if ("ADD_VACUNA".equalsIgnoreCase(myaction)) {
/*  49: 50 */       myforward = performAdd_vacuna(mapping, actionForm, request, response);
/*  50: 51 */     } else if ("TRASF_VACUNA".equalsIgnoreCase(myaction)) {
/*  51: 52 */       myforward = performTrasf_vacuna(mapping, actionForm, request, response);
/*  52: 53 */     } else if ("REMOVE_VACUNA".equalsIgnoreCase(myaction)) {
/*  53: 54 */       myforward = performRemove_vacuna(mapping, actionForm, request, response);
/*  54: 55 */     } else if ("TRASF_CONTROL".equalsIgnoreCase(myaction)) {
/*  55: 56 */       myforward = performTrasf_control(mapping, actionForm, request, response);
/*  56: 57 */     } else if ("EDIT_CONTROL".equalsIgnoreCase(myaction)) {
/*  57: 58 */       myforward = performEdit_control(mapping, actionForm, request, response);
/*  58: 59 */     } else if ("ADD_MEDICAMENTO".equalsIgnoreCase(myaction)) {
/*  59: 60 */       myforward = performAdd_medicamento(mapping, actionForm, request, response);
/*  60: 61 */     } else if ("TRASF_MEDICAMENTO".equalsIgnoreCase(myaction)) {
/*  61: 62 */       myforward = performTrasf_medicamento(mapping, actionForm, request, response);
/*  62: 63 */     } else if ("EDIT_MEDICAMENTO".equalsIgnoreCase(myaction)) {
/*  63: 64 */       myforward = performEdit_medicamento(mapping, actionForm, request, response);
/*  64: 65 */     } else if ("REMOVE_MEDICAMENTO".equalsIgnoreCase(myaction)) {
/*  65: 66 */       myforward = performRemove_medicamento(mapping, actionForm, request, response);
/*  66: 67 */     } else if ("EDIT_VACUNA".equalsIgnoreCase(myaction)) {
/*  67: 68 */       myforward = performEdit_vacuna(mapping, actionForm, request, response);
/*  68: 69 */     } else if ("ADD_SEGURO_PETS".equalsIgnoreCase(myaction)) {
/*  69: 70 */       myforward = performAdd_seguro_pets(mapping, actionForm, request, response);
/*  70: 71 */     } else if ("EDIT_SEGURO_PETS".equalsIgnoreCase(myaction)) {
/*  71: 72 */       myforward = performEdit_seguro_pets(mapping, actionForm, request, response);
/*  72: 73 */     } else if ("TRASF_SEGURO_PETS".equalsIgnoreCase(myaction)) {
/*  73: 74 */       myforward = performTrasf_seguro_pets(mapping, actionForm, request, response);
/*  74: 75 */     } else if ("REMOVE_SEGURO_PETS".equalsIgnoreCase(myaction)) {
/*  75: 76 */       myforward = performRemove_seguro_pets(mapping, actionForm, request, response);
/*  76: 77 */     } else if ("ADD_ENF_PETS".equalsIgnoreCase(myaction)) {
/*  77: 78 */       myforward = performAdd_enf_pets(mapping, actionForm, request, response);
/*  78: 79 */     } else if ("EDIT_ENF_PETS".equalsIgnoreCase(myaction)) {
/*  79: 80 */       myforward = performEdit_enf_pets(mapping, actionForm, request, response);
/*  80: 81 */     } else if ("TRASF_ENF_PETS".equalsIgnoreCase(myaction)) {
/*  81: 82 */       myforward = performTrasf_enf_pets(mapping, actionForm, request, response);
/*  82: 83 */     } else if ("REMOVE_ENF_PETS".equalsIgnoreCase(myaction)) {
/*  83: 84 */       myforward = performRemove_enf_pets(mapping, actionForm, request, response);
/*  84: 85 */     } else if ("ADD_ALE_PETS".equalsIgnoreCase(myaction)) {
/*  85: 86 */       myforward = performAdd_ale_pets(mapping, actionForm, request, response);
/*  86: 87 */     } else if ("EDIT_ALE_PETS".equalsIgnoreCase(myaction)) {
/*  87: 88 */       myforward = performEdit_ale_pets(mapping, actionForm, request, response);
/*  88: 89 */     } else if ("TRASF_ALE_PETS".equalsIgnoreCase(myaction)) {
/*  89: 90 */       myforward = performTrasf_ale_pets(mapping, actionForm, request, response);
/*  90: 91 */     } else if ("REMOVE_ALE_PETS".equalsIgnoreCase(myaction)) {
/*  91: 92 */       myforward = performRemove_ale_pets(mapping, actionForm, request, response);
/*  92: 93 */     } else if ("ADD_CIR_PETS".equalsIgnoreCase(myaction)) {
/*  93: 94 */       myforward = performAdd_cir_pets(mapping, actionForm, request, response);
/*  94: 95 */     } else if ("EDIT_CIR_PETS".equalsIgnoreCase(myaction)) {
/*  95: 96 */       myforward = performEdit_cir_pets(mapping, actionForm, request, response);
/*  96: 97 */     } else if ("TRASF_CIR_PETS".equalsIgnoreCase(myaction)) {
/*  97: 98 */       myforward = performTrasf_cir_pets(mapping, actionForm, request, response);
/*  98: 99 */     } else if ("REMOVE_CIR_PETS".equalsIgnoreCase(myaction)) {
/*  99:100 */       myforward = performRemove_cir_pets(mapping, actionForm, request, response);
/* 100:    */     } else {
/* 101:102 */       myforward = mapping.findForward("failure");
/* 102:    */     }
/* 103:105 */     return myforward;
/* 104:    */   }
/* 105:    */   
/* 106:    */   private ActionForward performAdd_vacuna(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 107:    */   {
/* 108:110 */     VacunasCuidadosForm form = (VacunasCuidadosForm)actionForm;
/* 109:    */     
/* 110:    */ 
/* 111:    */ 
/* 112:    */ 
/* 113:    */ 
/* 114:    */ 
/* 115:    */ 
/* 116:118 */     return mapping.findForward("success");
/* 117:    */   }
/* 118:    */   
/* 119:    */   private ActionForward performTrasf_vacuna(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 120:    */   {
/* 121:123 */     VacunasCuidadosForm form = (VacunasCuidadosForm)actionForm;
/* 122:    */     try
/* 123:    */     {
/* 124:127 */       Mascota mascota = (Mascota)request.getSession().getAttribute("mascota");
/* 125:    */       
/* 126:129 */       List vacunas = null;
/* 127:130 */       if (request.getSession().getAttribute("VACUNASCUIDADOS") != null) {
/* 128:131 */         vacunas = (List)request.getSession().getAttribute("VACUNASCUIDADOS");
/* 129:    */       } else {
/* 130:133 */         vacunas = new ArrayList();
/* 131:    */       }
/* 132:136 */       List controles = null;
/* 133:137 */       if (request.getSession().getAttribute("CONTROLCUIDADOS") != null) {
/* 134:138 */         controles = (List)request.getSession().getAttribute("CONTROLCUIDADOS");
/* 135:    */       } else {
/* 136:140 */         controles = new ArrayList();
/* 137:    */       }
/* 138:143 */       VacunasCuidados vacunasCuidados = null;
/* 139:145 */       if (request.getParameter("num_vacuna") == null)
/* 140:    */       {
/* 141:148 */         vacunasCuidados = new VacunasCuidados();
/* 142:149 */         InicializaData.inicializa(vacunasCuidados.getClass(), vacunasCuidados);
/* 143:150 */         BeanUtils.copyProperties(vacunasCuidados, form);
/* 144:151 */         vacunasCuidados.setVcui_mas_cod(mascota.getMas_cod());
/* 145:    */         
/* 146:153 */         vacunas.add(vacunasCuidados);
/* 147:    */         
/* 148:155 */         ControlCuidados control = new ControlCuidados();
/* 149:156 */         InicializaData.inicializa(control.getClass(), control);
/* 150:157 */         control.setElementoTabla(vacunasCuidados);
/* 151:158 */         control.setCcui_grup_cod(IGrupos.PETS_GRUPO_A);
/* 152:159 */         control.setCcui_mas_cod(mascota.getMas_cod());
/* 153:160 */         controles.add(control);
/* 154:    */       }
/* 155:    */       else
/* 156:    */       {
/* 157:164 */         vacunasCuidados = (VacunasCuidados)vacunas.get(Integer.parseInt(request.getParameter("num_vacuna")));
/* 158:165 */         vacunasCuidados.setVcui_descripcion(request.getParameter("vcui_descripcion"));
/* 159:    */         
/* 160:    */ 
/* 161:168 */         vacunas.set(Integer.parseInt(request.getParameter("num_vacuna")), vacunasCuidados);
/* 162:    */         
/* 163:170 */         ControlCuidados control = (ControlCuidados)controles.get(Integer.parseInt(request.getParameter("num_vacuna")));
/* 164:171 */         control.setCcui_descripcion(request.getParameter("vcui_descripcion"));
/* 165:172 */         controles.set(Integer.parseInt(request.getParameter("num_vacuna")), control);
/* 166:    */       }
/* 167:    */     }
/* 168:    */     catch (Exception e)
/* 169:    */     {
/* 170:179 */       return mapping.findForward("failure");
/* 171:    */     }
/* 172:182 */     return mapping.findForward("success");
/* 173:    */   }
/* 174:    */   
/* 175:    */   private ActionForward performRemove_vacuna(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 176:    */   {
/* 177:187 */     VacunasCuidadosForm form = (VacunasCuidadosForm)actionForm;
/* 178:    */     try
/* 179:    */     {
/* 180:191 */       List vacunas = (List)request.getSession().getAttribute("VACUNASCUIDADOS");
/* 181:    */       
/* 182:193 */       List controles = (List)request.getSession().getAttribute("CONTROLCUIDADOS");
/* 183:    */       
/* 184:195 */       int x = 0;
/* 185:196 */       while (x < controles.size())
/* 186:    */       {
/* 187:197 */         ControlCuidados controlCuidados = (ControlCuidados)controles.get(x);
/* 188:198 */         if (controlCuidados.getElementoTabla() == (VacunasCuidados)vacunas.get(Integer.parseInt(request.getParameter("num_vacuna"))))
/* 189:    */         {
/* 190:199 */           controles.remove(x);
/* 191:    */         }
/* 192:    */         else
/* 193:    */         {
/* 194:201 */           x++;
/* 195:202 */           controlCuidados.setCcui_cod(new BigDecimal(1.0D));
/* 196:    */         }
/* 197:    */       }
/* 198:206 */       vacunas.remove(Integer.parseInt(request.getParameter("num_vacuna")));
/* 199:    */       
/* 200:208 */       x = 0;
/* 201:209 */       while (x < vacunas.size())
/* 202:    */       {
/* 203:210 */         VacunasCuidados vacunasCuidados = (VacunasCuidados)vacunas.get(x);
/* 204:211 */         vacunasCuidados.setVcui_cod(new BigDecimal(x + 1.0D));
/* 205:212 */         vacunas.set(x, vacunasCuidados);
/* 206:213 */         x++;
/* 207:    */       }
/* 208:    */     }
/* 209:    */     catch (Exception e)
/* 210:    */     {
/* 211:217 */       return mapping.findForward("failure");
/* 212:    */     }
/* 213:220 */     return mapping.findForward("success");
/* 214:    */   }
/* 215:    */   
/* 216:    */   private ActionForward performTrasf_control(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 217:    */   {
/* 218:224 */     ControlCuidadosForm form = (ControlCuidadosForm)actionForm;
/* 219:    */     try
/* 220:    */     {
/* 221:228 */       List controles = null;
/* 222:229 */       if (request.getSession().getAttribute("CONTROLCUIDADOS") != null) {
/* 223:230 */         controles = (List)request.getSession().getAttribute("CONTROLCUIDADOS");
/* 224:    */       }
/* 225:233 */       ControlCuidados controlCuidados = null;
/* 226:234 */       ControlCuidados controlCuidados2 = null;
/* 227:235 */       GruposMascota gruposMascota = null;
/* 228:237 */       if (request.getParameter("num_control") != null)
/* 229:    */       {
/* 230:240 */         controlCuidados = (ControlCuidados)controles.get(Integer.parseInt(request.getParameter("num_control")));
/* 231:241 */         form.setCcui_fecultapli(ManejoFechas.getChangeFecha(form.getCcui_fecultapli()));
/* 232:242 */         form.setCcui_fecproxapli(ManejoFechas.getChangeFecha(form.getCcui_fecproxapli()));
/* 233:    */         
/* 234:244 */         List grupos = (List)request.getSession().getAttribute("GRUPOSMASCOTA");
/* 235:245 */         gruposMascota = (GruposMascota)grupos.get(controlCuidados.getCcui_grup_cod().intValue() - 1);
/* 236:246 */         int noRecordatorios = 0;
/* 237:247 */         if (gruposMascota.getGrupm_grup_cod().intValue() == 1) {
/* 238:247 */           noRecordatorios = 2;
/* 239:    */         } else {
/* 240:248 */           noRecordatorios = 1;
/* 241:    */         }
/* 242:249 */         int diasAntes = gruposMascota.getGrupm_dias_antes().intValue();
/* 243:250 */         String fechaActual = ManejoFechas.getFechaActual();
/* 244:251 */         MascotaDAO mascotaDAO = new MascotaDAO();
/* 245:252 */         Mascota mascota = mascotaDAO.retrieve(new BigDecimal(form.getCcui_mas_cod()));
/* 246:253 */         String fecnacMascota = mascota.getMas_fecnac().toString();
/* 247:254 */         int frecuencia = controlCuidados.getElementoTabla().getVcui_control().intValue();
/* 248:256 */         if (form.getCcui_cita_prox().equals("1"))
/* 249:    */         {
/* 250:257 */           if (noRecordatorios == 2) {
/* 251:257 */             form.setCcui_fecenvion(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(form.getCcui_fecproxapli(), "yyyyMMdd", -diasAntes)));
/* 252:    */           } else {
/* 253:258 */             form.setCcui_fecenvion(BigDecimal.ZERO.toString());
/* 254:    */           }
/* 255:259 */           form.setCcui_fecenvio2(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(form.getCcui_fecproxapli(), "yyyyMMdd", -2)));
/* 256:260 */           form.setCcui_quince_dias(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(form.getCcui_fecproxapli(), "yyyyMMdd", 15)));
/* 257:    */         }
/* 258:262 */         if (form.getCcui_cita_prox().equals("0"))
/* 259:    */         {
/* 260:263 */           String fechaParametro = form.getCcui_fecultapli().toString();
/* 261:    */           
/* 262:    */ 
/* 263:266 */           int dias = 0;
/* 264:267 */           String fechaParametroEdad = fecnacMascota;
/* 265:268 */           while (fechaParametroEdad.compareTo(fechaParametro) < 1)
/* 266:    */           {
/* 267:269 */             fechaParametroEdad = GestorFechasCompleto.fechaMasDias(fechaParametroEdad, "yyyyMMdd", 1);
/* 268:270 */             dias++;
/* 269:    */           }
/* 270:273 */           boolean siguiente = false;
/* 271:274 */           if ((controlCuidados.getElementoTabla().getVcui_30().equals("1")) && (dias < 30))
/* 272:    */           {
/* 273:275 */             if (noRecordatorios == 2) {
/* 274:275 */               form.setCcui_fecenvion(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 30 - diasAntes)));
/* 275:    */             } else {
/* 276:276 */               form.setCcui_fecenvion(BigDecimal.ZERO.toString());
/* 277:    */             }
/* 278:277 */             form.setCcui_fecenvio2(GestorFechasCompleto.fechaMasDias(fecnacMascota, "yyyyMMdd", 28));
/* 279:278 */             form.setCcui_quince_dias(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 45));
/* 280:279 */             siguiente = true;
/* 281:    */           }
/* 282:281 */           if ((controlCuidados.getElementoTabla().getVcui_45().equals("1")) && (dias < 45) && (!siguiente))
/* 283:    */           {
/* 284:282 */             if (noRecordatorios == 2) {
/* 285:282 */               form.setCcui_fecenvion(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 45 - diasAntes)));
/* 286:    */             } else {
/* 287:283 */               form.setCcui_fecenvion(BigDecimal.ZERO.toString());
/* 288:    */             }
/* 289:284 */             form.setCcui_fecenvio2(GestorFechasCompleto.fechaMasDias(fecnacMascota, "yyyyMMdd", 43));
/* 290:285 */             form.setCcui_quince_dias(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 60));
/* 291:286 */             siguiente = true;
/* 292:    */           }
/* 293:288 */           if ((controlCuidados.getElementoTabla().getVcui_60().equals("1")) && (dias < 60) && (!siguiente))
/* 294:    */           {
/* 295:289 */             if (noRecordatorios == 2) {
/* 296:289 */               form.setCcui_fecenvion(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 60 - diasAntes)));
/* 297:    */             } else {
/* 298:290 */               form.setCcui_fecenvion(BigDecimal.ZERO.toString());
/* 299:    */             }
/* 300:291 */             form.setCcui_fecenvio2(GestorFechasCompleto.fechaMasDias(fecnacMascota, "yyyyMMdd", 58));
/* 301:292 */             form.setCcui_quince_dias(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 75));
/* 302:293 */             siguiente = true;
/* 303:    */           }
/* 304:295 */           if ((controlCuidados.getElementoTabla().getVcui_75().equals("1")) && (dias < 75) && (!siguiente))
/* 305:    */           {
/* 306:296 */             if (noRecordatorios == 2) {
/* 307:296 */               form.setCcui_fecenvion(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 75 - diasAntes)));
/* 308:    */             } else {
/* 309:297 */               form.setCcui_fecenvion(BigDecimal.ZERO.toString());
/* 310:    */             }
/* 311:298 */             form.setCcui_fecenvio2(GestorFechasCompleto.fechaMasDias(fecnacMascota, "yyyyMMdd", 73));
/* 312:299 */             form.setCcui_quince_dias(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 90));
/* 313:300 */             siguiente = true;
/* 314:    */           }
/* 315:302 */           if ((controlCuidados.getElementoTabla().getVcui_90().equals("1")) && (dias < 90) && (!siguiente))
/* 316:    */           {
/* 317:303 */             if (noRecordatorios == 2) {
/* 318:303 */               form.setCcui_fecenvion(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 90 - diasAntes)));
/* 319:    */             } else {
/* 320:304 */               form.setCcui_fecenvion(BigDecimal.ZERO.toString());
/* 321:    */             }
/* 322:305 */             form.setCcui_fecenvio2(GestorFechasCompleto.fechaMasDias(fecnacMascota, "yyyyMMdd", 88));
/* 323:306 */             form.setCcui_quince_dias(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 105));
/* 324:307 */             siguiente = true;
/* 325:    */           }
/* 326:309 */           if ((controlCuidados.getElementoTabla().getVcui_105().equals("1")) && (dias < 105) && (!siguiente))
/* 327:    */           {
/* 328:310 */             if (noRecordatorios == 2) {
/* 329:310 */               form.setCcui_fecenvion(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 105 - diasAntes)));
/* 330:    */             } else {
/* 331:311 */               form.setCcui_fecenvion(BigDecimal.ZERO.toString());
/* 332:    */             }
/* 333:312 */             form.setCcui_fecenvio2(GestorFechasCompleto.fechaMasDias(fecnacMascota, "yyyyMMdd", 103));
/* 334:313 */             form.setCcui_quince_dias(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 120));
/* 335:314 */             siguiente = true;
/* 336:    */           }
/* 337:316 */           if ((controlCuidados.getElementoTabla().getVcui_120().equals("1")) && (dias < 120) && (!siguiente))
/* 338:    */           {
/* 339:317 */             if (noRecordatorios == 2) {
/* 340:317 */               form.setCcui_fecenvion(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 120 - diasAntes)));
/* 341:    */             } else {
/* 342:318 */               form.setCcui_fecenvion(BigDecimal.ZERO.toString());
/* 343:    */             }
/* 344:319 */             form.setCcui_fecenvio2(GestorFechasCompleto.fechaMasDias(fecnacMascota, "yyyyMMdd", 118));
/* 345:320 */             form.setCcui_quince_dias(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 135));
/* 346:321 */             siguiente = true;
/* 347:    */           }
/* 348:323 */           if ((controlCuidados.getElementoTabla().getVcui_150().equals("1")) && (dias < 150) && (!siguiente))
/* 349:    */           {
/* 350:324 */             if (noRecordatorios == 2) {
/* 351:324 */               form.setCcui_fecenvion(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 150 - diasAntes)));
/* 352:    */             } else {
/* 353:325 */               form.setCcui_fecenvion(BigDecimal.ZERO.toString());
/* 354:    */             }
/* 355:326 */             form.setCcui_fecenvio2(GestorFechasCompleto.fechaMasDias(fecnacMascota, "yyyyMMdd", 148));
/* 356:327 */             form.setCcui_quince_dias(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 165));
/* 357:328 */             siguiente = true;
/* 358:    */           }
/* 359:330 */           if ((controlCuidados.getElementoTabla().getVcui_180().equals("1")) && (dias < 180) && (!siguiente))
/* 360:    */           {
/* 361:331 */             if (noRecordatorios == 2) {
/* 362:331 */               form.setCcui_fecenvion(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 180 - diasAntes)));
/* 363:    */             } else {
/* 364:332 */               form.setCcui_fecenvion(BigDecimal.ZERO.toString());
/* 365:    */             }
/* 366:333 */             form.setCcui_fecenvio2(GestorFechasCompleto.fechaMasDias(fecnacMascota, "yyyyMMdd", 178));
/* 367:334 */             form.setCcui_quince_dias(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 195));
/* 368:335 */             siguiente = true;
/* 369:    */           }
/* 370:337 */           if ((dias >= 180) && (!siguiente) && 
/* 371:338 */             (frecuencia != 0))
/* 372:    */           {
/* 373:339 */             fechaParametro = GestorFechasCompleto.fechaMasDias(fecnacMascota, "yyyyMMdd", 180);
/* 374:340 */             while (fechaParametro.compareTo(fechaActual) < 1) {
/* 375:341 */               fechaParametro = GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", frecuencia);
/* 376:    */             }
/* 377:343 */             if (noRecordatorios == 2) {
/* 378:343 */               form.setCcui_fecenvion(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", -diasAntes)));
/* 379:    */             } else {
/* 380:344 */               form.setCcui_fecenvion(BigDecimal.ZERO.toString());
/* 381:    */             }
/* 382:345 */             form.setCcui_fecenvio2(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", -2)));
/* 383:346 */             form.setCcui_quince_dias(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 15)));
/* 384:    */           }
/* 385:    */         }
/* 386:350 */         BeanUtils.copyProperties(controlCuidados, form);
/* 387:351 */         controles.set(Integer.parseInt(request.getParameter("num_control")), controlCuidados);
/* 388:352 */         request.getSession().setAttribute("CONTROLCUIDADOS", controles);
/* 389:    */       }
/* 390:    */     }
/* 391:    */     catch (Exception e)
/* 392:    */     {
/* 393:356 */       return mapping.findForward("failure");
/* 394:    */     }
/* 395:359 */     return mapping.findForward("success");
/* 396:    */   }
/* 397:    */   
/* 398:    */   private ActionForward performEdit_control(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 399:    */   {
/* 400:363 */     ControlCuidadosForm form = (ControlCuidadosForm)actionForm;
/* 401:    */     try
/* 402:    */     {
/* 403:365 */       TipoCuidadoDAO tipoCuidadoDAO = new TipoCuidadoDAO();
/* 404:366 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 405:367 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 406:368 */         tipoCuidadoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 407:    */       }
/* 408:371 */       List controles = (List)request.getSession().getAttribute("CONTROLCUIDADOS");
/* 409:373 */       if (controles.size() > 0)
/* 410:    */       {
/* 411:374 */         ControlCuidados controlCuidados = (ControlCuidados)controles.get(Integer.parseInt(request.getParameter("num_control")));
/* 412:375 */         if (request.getParameter("change") == null) {
/* 413:376 */           BeanUtils.copyProperties(form, controlCuidados);
/* 414:    */         }
/* 415:378 */         form.setCcui_fecproxapli(ManejoFechas.FormateoFecha(form.getCcui_fecproxapli()));
/* 416:379 */         form.setCcui_fecultapli(ManejoFechas.FormateoFecha(form.getCcui_fecultapli()));
/* 417:    */       }
/* 418:383 */       PaisDAO paisDAO = new PaisDAO();
/* 419:384 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 420:385 */         paisDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 421:    */       }
/* 422:387 */       paisDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 423:388 */       List paises = paisDAO.list();
/* 424:389 */       request.setAttribute("PAISES", paises);
/* 425:    */       
/* 426:391 */       List ciudades = null;
/* 427:392 */       CiudadDAO ciudadesDAO = new CiudadDAO();
/* 428:393 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 429:394 */         ciudadesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 430:    */       }
/* 431:396 */       ciudadesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 432:397 */       if (paises.size() > 0) {
/* 433:398 */         if ((!form.getCcui_pais_cod().equals("")) && (!form.getCcui_pais_cod().equals("0"))) {
/* 434:399 */           ciudades = ciudadesDAO.search(form.getCcui_pais_cod());
/* 435:    */         } else {
/* 436:401 */           ciudades = ciudadesDAO.search(((Paises)paises.get(0)).getPais_cod().toString());
/* 437:    */         }
/* 438:    */       }
/* 439:405 */       request.setAttribute("CIUDADES", ciudades);
/* 440:    */     }
/* 441:    */     catch (Exception e)
/* 442:    */     {
/* 443:407 */       return mapping.findForward("failure");
/* 444:    */     }
/* 445:410 */     return mapping.findForward("success");
/* 446:    */   }
/* 447:    */   
/* 448:    */   private ActionForward performAdd_medicamento(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 449:    */   {
/* 450:414 */     MascotaMedicamentosForm form = (MascotaMedicamentosForm)actionForm;
/* 451:    */     
/* 452:    */ 
/* 453:    */ 
/* 454:    */ 
/* 455:    */ 
/* 456:    */ 
/* 457:    */ 
/* 458:422 */     return mapping.findForward("success");
/* 459:    */   }
/* 460:    */   
/* 461:    */   private ActionForward performTrasf_medicamento(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 462:    */   {
/* 463:427 */     MascotaMedicamentosForm form = (MascotaMedicamentosForm)actionForm;
/* 464:    */     try
/* 465:    */     {
/* 466:430 */       MascotaMedicamentos mascotaMedicamentos = new MascotaMedicamentos();
/* 467:431 */       InicializaData.inicializa(mascotaMedicamentos.getClass(), mascotaMedicamentos);
/* 468:    */       
/* 469:433 */       Mascota mascota = (Mascota)request.getSession().getAttribute("mascota");
/* 470:    */       
/* 471:435 */       form.setMmed_fec_inicio(ManejoFechas.getChangeFecha(form.getMmed_fec_inicio()));
/* 472:436 */       BeanUtils.copyProperties(mascotaMedicamentos, form);
/* 473:437 */       mascotaMedicamentos.setMmed_mas_cod(mascota.getMas_cod());
/* 474:    */       
/* 475:439 */       List medicamentos = new ArrayList();
/* 476:441 */       if (request.getSession().getAttribute("MASCOTAMEDICAMENTOS") != null) {
/* 477:442 */         medicamentos = (List)request.getSession().getAttribute("MASCOTAMEDICAMENTOS");
/* 478:    */       }
/* 479:445 */       if (request.getParameter("num_medicamento") == null) {
/* 480:446 */         medicamentos.add(mascotaMedicamentos);
/* 481:    */       } else {
/* 482:449 */         medicamentos.set(Integer.parseInt(request.getParameter("num_medicamento")), mascotaMedicamentos);
/* 483:    */       }
/* 484:452 */       request.getSession().setAttribute("MASCOTAMEDICAMENTOS", medicamentos);
/* 485:    */     }
/* 486:    */     catch (Exception e)
/* 487:    */     {
/* 488:455 */       return mapping.findForward("failure");
/* 489:    */     }
/* 490:458 */     return mapping.findForward("success");
/* 491:    */   }
/* 492:    */   
/* 493:    */   private ActionForward performEdit_medicamento(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 494:    */   {
/* 495:463 */     MascotaMedicamentosForm form = (MascotaMedicamentosForm)actionForm;
/* 496:    */     try
/* 497:    */     {
/* 498:467 */       List medicamentos = (List)request.getSession().getAttribute("MASCOTAMEDICAMENTOS");
/* 499:469 */       if (medicamentos.size() > 0)
/* 500:    */       {
/* 501:471 */         MascotaMedicamentos mascotaMedicamentos = (MascotaMedicamentos)medicamentos.get(Integer.parseInt(request.getParameter("num_medicamento")));
/* 502:    */         
/* 503:473 */         BeanUtils.copyProperties(form, mascotaMedicamentos);
/* 504:474 */         form.setMmed_fec_inicio(ManejoFechas.FormateoFecha(form.getMmed_fec_inicio()));
/* 505:    */       }
/* 506:    */     }
/* 507:    */     catch (Exception e)
/* 508:    */     {
/* 509:478 */       return mapping.findForward("failure");
/* 510:    */     }
/* 511:481 */     return mapping.findForward("success");
/* 512:    */   }
/* 513:    */   
/* 514:    */   private ActionForward performRemove_medicamento(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 515:    */   {
/* 516:485 */     MascotaMedicamentosForm form = (MascotaMedicamentosForm)actionForm;
/* 517:    */     try
/* 518:    */     {
/* 519:489 */       List medicamentos = new ArrayList();
/* 520:490 */       medicamentos = (List)request.getSession().getAttribute("MASCOTAMEDICAMENTOS");
/* 521:491 */       medicamentos.remove(Integer.parseInt(request.getParameter("num_medicamento")));
/* 522:    */       
/* 523:493 */       int x = 0;
/* 524:494 */       while (x < medicamentos.size())
/* 525:    */       {
/* 526:495 */         MascotaMedicamentos mascotaMedicamentos = (MascotaMedicamentos)medicamentos.get(x);
/* 527:496 */         mascotaMedicamentos.setMmed_cod(new BigDecimal(x + 1));
/* 528:497 */         medicamentos.set(x, mascotaMedicamentos);
/* 529:498 */         x++;
/* 530:    */       }
/* 531:501 */       request.getSession().setAttribute("MASCOTAMEDICAMENTOS", medicamentos);
/* 532:    */     }
/* 533:    */     catch (Exception e)
/* 534:    */     {
/* 535:503 */       return mapping.findForward("failure");
/* 536:    */     }
/* 537:506 */     return mapping.findForward("success");
/* 538:    */   }
/* 539:    */   
/* 540:    */   private ActionForward performEdit_vacuna(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 541:    */   {
/* 542:511 */     VacunasCuidadosForm form = (VacunasCuidadosForm)actionForm;
/* 543:    */     try
/* 544:    */     {
/* 545:515 */       List vacunas = (List)request.getSession().getAttribute("VACUNASCUIDADOS");
/* 546:517 */       if (vacunas.size() > 0)
/* 547:    */       {
/* 548:518 */         VacunasCuidados vacunasCuidados = (VacunasCuidados)vacunas.get(Integer.parseInt(request.getParameter("num_vacuna")));
/* 549:519 */         BeanUtils.copyProperties(form, vacunasCuidados);
/* 550:    */       }
/* 551:    */     }
/* 552:    */     catch (Exception e)
/* 553:    */     {
/* 554:523 */       return mapping.findForward("failure");
/* 555:    */     }
/* 556:526 */     return mapping.findForward("success");
/* 557:    */   }
/* 558:    */   
/* 559:    */   private ActionForward performAdd_seguro_pets(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 560:    */   {
/* 561:530 */     SeguroPetsForm form = (SeguroPetsForm)actionForm;
/* 562:    */     
/* 563:    */ 
/* 564:    */ 
/* 565:    */ 
/* 566:    */ 
/* 567:    */ 
/* 568:    */ 
/* 569:538 */     return mapping.findForward("success");
/* 570:    */   }
/* 571:    */   
/* 572:    */   private ActionForward performEdit_seguro_pets(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 573:    */   {
/* 574:543 */     SeguroPetsForm form = (SeguroPetsForm)actionForm;
/* 575:    */     try
/* 576:    */     {
/* 577:546 */       List seguros = new ArrayList();
/* 578:547 */       seguros = (List)request.getSession().getAttribute("SEGUROPETS");
/* 579:548 */       SeguroPets seguro = (SeguroPets)seguros.get(Integer.parseInt(request.getParameter("num_seguro_pets")));
/* 580:549 */       if (request.getParameter("change") == null) {
/* 581:550 */         BeanUtils.copyProperties(form, seguro);
/* 582:    */       }
/* 583:552 */       form.setSegp_vig_desde(ManejoFechas.FormateoFecha(seguro.getSegp_vig_desde().toString()));
/* 584:553 */       form.setSegp_vig_hasta(ManejoFechas.FormateoFecha(seguro.getSegp_vig_hasta().toString()));
/* 585:554 */       form.setSegp_fecenvio2(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(form.getSegp_vig_hasta().toString(), "yyyyMMdd", -2)));
/* 586:555 */       form.setSegp_quince_dias(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(form.getSegp_vig_hasta().toString(), "yyyyMMdd", 15)));
/* 587:    */     }
/* 588:    */     catch (Exception e)
/* 589:    */     {
/* 590:559 */       return mapping.findForward("failure");
/* 591:    */     }
/* 592:562 */     return mapping.findForward("success");
/* 593:    */   }
/* 594:    */   
/* 595:    */   private ActionForward performTrasf_seguro_pets(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 596:    */   {
/* 597:566 */     SeguroPetsForm form = (SeguroPetsForm)actionForm;
/* 598:    */     try
/* 599:    */     {
/* 600:570 */       Mascota mascota = (Mascota)request.getSession().getAttribute("mascota");
/* 601:    */       
/* 602:572 */       SeguroPets seguroPets = new SeguroPets();
/* 603:573 */       InicializaData.inicializa(seguroPets.getClass(), seguroPets);
/* 604:574 */       if (form.getSegp_indpais1().length() == 0) {
/* 605:575 */         form.setSegp_indpais1("0");
/* 606:    */       }
/* 607:576 */       if (form.getSegp_indciudad1().length() == 0) {
/* 608:577 */         form.setSegp_indciudad1("0");
/* 609:    */       }
/* 610:578 */       if (form.getSegp_indpais2().length() == 0) {
/* 611:579 */         form.setSegp_indpais2("0");
/* 612:    */       }
/* 613:580 */       if (form.getSegp_indpais3().length() == 0) {
/* 614:581 */         form.setSegp_indpais3("0");
/* 615:    */       }
/* 616:582 */       if (form.getSegp_indciudad3().length() == 0) {
/* 617:583 */         form.setSegp_indciudad3("0");
/* 618:    */       }
/* 619:585 */       form.setSegp_vig_desde(ManejoFechas.getChangeFecha(form.getSegp_vig_desde().toString()));
/* 620:586 */       form.setSegp_vig_hasta(ManejoFechas.getChangeFecha(form.getSegp_vig_hasta().toString()));
/* 621:587 */       form.setSegp_mas_cod(mascota.getMas_cod().toString());
/* 622:588 */       form.setSegp_grup_cod(IGrupos.PETS_GRUPO_A.toString());
/* 623:    */       
/* 624:590 */       form.setSegp_fecenvio2(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(form.getSegp_vig_hasta().toString(), "yyyyMMdd", -2)));
/* 625:591 */       form.setSegp_quince_dias(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(form.getSegp_vig_hasta().toString(), "yyyyMMdd", 15)));
/* 626:592 */       BeanUtils.copyProperties(seguroPets, form);
/* 627:    */       
/* 628:    */ 
/* 629:595 */       List seguros = new ArrayList();
/* 630:597 */       if (request.getSession().getAttribute("SEGUROPETS") != null) {
/* 631:598 */         seguros = (List)request.getSession().getAttribute("SEGUROPETS");
/* 632:    */       }
/* 633:601 */       if (request.getParameter("num_seguro_pets") == null) {
/* 634:602 */         seguros.add(seguroPets);
/* 635:    */       } else {
/* 636:604 */         seguros.set(Integer.parseInt(request.getParameter("num_seguro_pets")), seguroPets);
/* 637:    */       }
/* 638:607 */       request.getSession().setAttribute("SEGUROPETS", seguros);
/* 639:    */     }
/* 640:    */     catch (Exception e)
/* 641:    */     {
/* 642:610 */       return mapping.findForward("failure");
/* 643:    */     }
/* 644:613 */     return mapping.findForward("success");
/* 645:    */   }
/* 646:    */   
/* 647:    */   private ActionForward performRemove_seguro_pets(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 648:    */   {
/* 649:616 */     SeguroPetsForm form = (SeguroPetsForm)actionForm;
/* 650:    */     try
/* 651:    */     {
/* 652:620 */       List seguros = new ArrayList();
/* 653:621 */       seguros = (List)request.getSession().getAttribute("SEGUROPETS");
/* 654:622 */       seguros.remove(Integer.parseInt(request.getParameter("num_seguro_pets")));
/* 655:    */       
/* 656:624 */       int x = 0;
/* 657:625 */       while (x < seguros.size())
/* 658:    */       {
/* 659:626 */         SeguroPets seguro = (SeguroPets)seguros.get(x);
/* 660:627 */         seguro.setSegp_cod(new BigDecimal(x + 1));
/* 661:628 */         seguros.set(x, seguro);
/* 662:629 */         x++;
/* 663:    */       }
/* 664:    */     }
/* 665:    */     catch (Exception e)
/* 666:    */     {
/* 667:633 */       return mapping.findForward("failure");
/* 668:    */     }
/* 669:636 */     return mapping.findForward("success");
/* 670:    */   }
/* 671:    */   
/* 672:    */   private ActionForward performAdd_enf_pets(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 673:    */   {
/* 674:640 */     EnfermedadesPetsForm form = (EnfermedadesPetsForm)actionForm;
/* 675:    */     
/* 676:    */ 
/* 677:    */ 
/* 678:    */ 
/* 679:    */ 
/* 680:    */ 
/* 681:    */ 
/* 682:    */ 
/* 683:    */ 
/* 684:650 */     return mapping.findForward("success");
/* 685:    */   }
/* 686:    */   
/* 687:    */   private ActionForward performTrasf_enf_pets(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 688:    */   {
/* 689:655 */     EnfermedadesPetsForm form = (EnfermedadesPetsForm)actionForm;
/* 690:    */     try
/* 691:    */     {
/* 692:658 */       Mascota mascota = (Mascota)request.getSession().getAttribute("mascota");
/* 693:    */       
/* 694:660 */       EnfermedadesPets enfermedadesPets = new EnfermedadesPets();
/* 695:661 */       InicializaData.inicializa(enfermedadesPets.getClass(), enfermedadesPets);
/* 696:    */       
/* 697:663 */       form.setEnfp_mas_cod(mascota.getMas_cod().toString());
/* 698:664 */       BeanUtils.copyProperties(enfermedadesPets, form);
/* 699:    */       
/* 700:    */ 
/* 701:    */ 
/* 702:668 */       List enfermedades = new ArrayList();
/* 703:670 */       if (request.getSession().getAttribute("ENFERMEDADESPETS") != null) {
/* 704:671 */         enfermedades = (List)request.getSession().getAttribute("ENFERMEDADESPETS");
/* 705:    */       }
/* 706:674 */       if (request.getParameter("num_enf_pets") == null) {
/* 707:675 */         enfermedades.add(enfermedadesPets);
/* 708:    */       } else {
/* 709:677 */         enfermedades.set(Integer.parseInt(request.getParameter("num_enf_pets")), enfermedadesPets);
/* 710:    */       }
/* 711:680 */       request.getSession().setAttribute("ENFERMEDADESPETS", enfermedades);
/* 712:    */     }
/* 713:    */     catch (Exception e)
/* 714:    */     {
/* 715:684 */       return mapping.findForward("failure");
/* 716:    */     }
/* 717:686 */     return mapping.findForward("success");
/* 718:    */   }
/* 719:    */   
/* 720:    */   private ActionForward performEdit_enf_pets(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 721:    */   {
/* 722:690 */     EnfermedadesPetsForm form = (EnfermedadesPetsForm)actionForm;
/* 723:    */     try
/* 724:    */     {
/* 725:693 */       List enfermedades = new ArrayList();
/* 726:694 */       enfermedades = (List)request.getSession().getAttribute("ENFERMEDADESPETS");
/* 727:695 */       EnfermedadesPets enfermedad = (EnfermedadesPets)enfermedades.get(Integer.parseInt(request.getParameter("num_enf_pets")));
/* 728:696 */       if (request.getParameter("change") == null) {
/* 729:697 */         BeanUtils.copyProperties(form, enfermedad);
/* 730:    */       }
/* 731:    */     }
/* 732:    */     catch (Exception e)
/* 733:    */     {
/* 734:703 */       return mapping.findForward("failure");
/* 735:    */     }
/* 736:705 */     return mapping.findForward("success");
/* 737:    */   }
/* 738:    */   
/* 739:    */   private ActionForward performRemove_enf_pets(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 740:    */   {
/* 741:708 */     EnfermedadesPetsForm form = (EnfermedadesPetsForm)actionForm;
/* 742:    */     try
/* 743:    */     {
/* 744:712 */       List enfermedades = new ArrayList();
/* 745:713 */       enfermedades = (List)request.getSession().getAttribute("ENFERMEDADESPETS");
/* 746:714 */       enfermedades.remove(Integer.parseInt(request.getParameter("num_enf_pets")));
/* 747:    */       
/* 748:716 */       int x = 0;
/* 749:717 */       while (x < enfermedades.size())
/* 750:    */       {
/* 751:718 */         EnfermedadesPets enfermedadesPets = (EnfermedadesPets)enfermedades.get(x);
/* 752:719 */         enfermedadesPets.setEnfp_cod(new BigDecimal(x + 1));
/* 753:720 */         enfermedades.set(x, enfermedadesPets);
/* 754:721 */         x++;
/* 755:    */       }
/* 756:    */     }
/* 757:    */     catch (Exception e)
/* 758:    */     {
/* 759:726 */       return mapping.findForward("failure");
/* 760:    */     }
/* 761:728 */     return mapping.findForward("success");
/* 762:    */   }
/* 763:    */   
/* 764:    */   private ActionForward performAdd_ale_pets(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 765:    */   {
/* 766:734 */     AlergiasPetsForm form = (AlergiasPetsForm)actionForm;
/* 767:    */     
/* 768:    */ 
/* 769:    */ 
/* 770:    */ 
/* 771:    */ 
/* 772:    */ 
/* 773:    */ 
/* 774:    */ 
/* 775:743 */     return mapping.findForward("success");
/* 776:    */   }
/* 777:    */   
/* 778:    */   private ActionForward performEdit_ale_pets(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 779:    */   {
/* 780:748 */     AlergiasPetsForm form = (AlergiasPetsForm)actionForm;
/* 781:    */     try
/* 782:    */     {
/* 783:751 */       List alergias = new ArrayList();
/* 784:752 */       alergias = (List)request.getSession().getAttribute("ALERGIASPETS");
/* 785:753 */       AlergiasPets alergiasPets = (AlergiasPets)alergias.get(Integer.parseInt(request.getParameter("num_aler_pets")));
/* 786:754 */       if (request.getParameter("change") == null) {
/* 787:755 */         BeanUtils.copyProperties(form, alergiasPets);
/* 788:    */       }
/* 789:    */     }
/* 790:    */     catch (Exception e)
/* 791:    */     {
/* 792:761 */       return mapping.findForward("failure");
/* 793:    */     }
/* 794:763 */     return mapping.findForward("success");
/* 795:    */   }
/* 796:    */   
/* 797:    */   private ActionForward performTrasf_ale_pets(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 798:    */   {
/* 799:766 */     AlergiasPetsForm form = (AlergiasPetsForm)actionForm;
/* 800:    */     try
/* 801:    */     {
/* 802:769 */       Mascota mascota = (Mascota)request.getSession().getAttribute("mascota");
/* 803:    */       
/* 804:771 */       AlergiasPets alergiasPets = new AlergiasPets();
/* 805:772 */       InicializaData.inicializa(alergiasPets.getClass(), alergiasPets);
/* 806:    */       
/* 807:774 */       form.setAlep_mas_cod(mascota.getMas_cod().toString());
/* 808:775 */       BeanUtils.copyProperties(alergiasPets, form);
/* 809:    */       
/* 810:    */ 
/* 811:    */ 
/* 812:779 */       List alergias = new ArrayList();
/* 813:781 */       if (request.getSession().getAttribute("ALERGIASPETS") != null) {
/* 814:782 */         alergias = (List)request.getSession().getAttribute("ALERGIASPETS");
/* 815:    */       }
/* 816:785 */       if (request.getParameter("num_aler_pets") == null) {
/* 817:786 */         alergias.add(alergiasPets);
/* 818:    */       } else {
/* 819:788 */         alergias.set(Integer.parseInt(request.getParameter("num_aler_pets")), alergiasPets);
/* 820:    */       }
/* 821:791 */       request.getSession().setAttribute("ALERGIASPETS", alergias);
/* 822:    */     }
/* 823:    */     catch (Exception e)
/* 824:    */     {
/* 825:795 */       return mapping.findForward("failure");
/* 826:    */     }
/* 827:797 */     return mapping.findForward("success");
/* 828:    */   }
/* 829:    */   
/* 830:    */   private ActionForward performRemove_ale_pets(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 831:    */   {
/* 832:800 */     AlergiasPetsForm form = (AlergiasPetsForm)actionForm;
/* 833:    */     try
/* 834:    */     {
/* 835:803 */       List alergias = (List)request.getSession().getAttribute("ALERGIASPETS");
/* 836:804 */       alergias.remove(Integer.parseInt(request.getParameter("num_aler_pets")));
/* 837:    */       
/* 838:806 */       int x = 0;
/* 839:807 */       while (x < alergias.size())
/* 840:    */       {
/* 841:808 */         AlergiasPets alergiasPets = (AlergiasPets)alergias.get(x);
/* 842:809 */         alergiasPets.setAlep_cod(new BigDecimal(x + 1));
/* 843:810 */         alergias.set(x, alergiasPets);
/* 844:811 */         x++;
/* 845:    */       }
/* 846:    */     }
/* 847:    */     catch (Exception e)
/* 848:    */     {
/* 849:816 */       return mapping.findForward("failure");
/* 850:    */     }
/* 851:818 */     return mapping.findForward("success");
/* 852:    */   }
/* 853:    */   
/* 854:    */   private ActionForward performAdd_cir_pets(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 855:    */   {
/* 856:823 */     CirugiasPetsForm form = (CirugiasPetsForm)actionForm;
/* 857:    */     
/* 858:    */ 
/* 859:    */ 
/* 860:    */ 
/* 861:    */ 
/* 862:    */ 
/* 863:    */ 
/* 864:    */ 
/* 865:    */ 
/* 866:833 */     return mapping.findForward("success");
/* 867:    */   }
/* 868:    */   
/* 869:    */   private ActionForward performEdit_cir_pets(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 870:    */   {
/* 871:838 */     CirugiasPetsForm form = (CirugiasPetsForm)actionForm;
/* 872:    */     try
/* 873:    */     {
/* 874:843 */       List cirugias = new ArrayList();
/* 875:844 */       cirugias = (List)request.getSession().getAttribute("CIRUGIASPETS");
/* 876:845 */       CirugiasPets cirugiasPets = (CirugiasPets)cirugias.get(Integer.parseInt(request.getParameter("num_cir_pets")));
/* 877:846 */       if (request.getParameter("change") == null) {
/* 878:847 */         BeanUtils.copyProperties(form, cirugiasPets);
/* 879:    */       }
/* 880:    */     }
/* 881:    */     catch (Exception e)
/* 882:    */     {
/* 883:854 */       return mapping.findForward("failure");
/* 884:    */     }
/* 885:856 */     return mapping.findForward("success");
/* 886:    */   }
/* 887:    */   
/* 888:    */   private ActionForward performTrasf_cir_pets(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 889:    */   {
/* 890:860 */     CirugiasPetsForm form = (CirugiasPetsForm)actionForm;
/* 891:    */     try
/* 892:    */     {
/* 893:863 */       Mascota mascota = (Mascota)request.getSession().getAttribute("mascota");
/* 894:    */       
/* 895:865 */       CirugiasPets cirugiasPets = new CirugiasPets();
/* 896:866 */       InicializaData.inicializa(cirugiasPets.getClass(), cirugiasPets);
/* 897:    */       
/* 898:868 */       form.setCirp_mas_cod(mascota.getMas_cod().toString());
/* 899:869 */       BeanUtils.copyProperties(cirugiasPets, form);
/* 900:    */       
/* 901:    */ 
/* 902:    */ 
/* 903:873 */       List cirugias = new ArrayList();
/* 904:875 */       if (request.getSession().getAttribute("CIRUGIASPETS") != null) {
/* 905:876 */         cirugias = (List)request.getSession().getAttribute("CIRUGIASPETS");
/* 906:    */       }
/* 907:879 */       if (request.getParameter("num_cir_pets") == null) {
/* 908:880 */         cirugias.add(cirugiasPets);
/* 909:    */       } else {
/* 910:882 */         cirugias.set(Integer.parseInt(request.getParameter("num_cir_pets")), cirugiasPets);
/* 911:    */       }
/* 912:885 */       request.getSession().setAttribute("CIRUGIASPETS", cirugias);
/* 913:    */     }
/* 914:    */     catch (Exception e)
/* 915:    */     {
/* 916:890 */       return mapping.findForward("failure");
/* 917:    */     }
/* 918:892 */     return mapping.findForward("success");
/* 919:    */   }
/* 920:    */   
/* 921:    */   private ActionForward performRemove_cir_pets(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 922:    */   {
/* 923:895 */     CirugiasPetsForm form = (CirugiasPetsForm)actionForm;
/* 924:    */     try
/* 925:    */     {
/* 926:899 */       List cirujias = (List)request.getSession().getAttribute("CIRUGIASPETS");
/* 927:900 */       cirujias.remove(Integer.parseInt(request.getParameter("num_cir_pets")));
/* 928:    */       
/* 929:902 */       int x = 0;
/* 930:903 */       while (x < cirujias.size())
/* 931:    */       {
/* 932:904 */         CirugiasPets cirugiasPets = (CirugiasPets)cirujias.get(x);
/* 933:905 */         cirugiasPets.setCirp_cod(new BigDecimal(x + 1));
/* 934:906 */         cirujias.set(x, cirugiasPets);
/* 935:907 */         x++;
/* 936:    */       }
/* 937:    */     }
/* 938:    */     catch (Exception e)
/* 939:    */     {
/* 940:912 */       return mapping.findForward("failure");
/* 941:    */     }
/* 942:914 */     return mapping.findForward("success");
/* 943:    */   }
/* 944:    */ }



/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\

 * Qualified Name:     com.servidoctor.sdpets.controller.PopupAction

 * JD-Core Version:    0.7.0.1

 */