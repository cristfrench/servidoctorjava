/*   1:    */ package com.servidoctor.sdfamily.controller;
/*   2:    */ 
/*   3:    */ import com.essecorp.util.GestorFechasCompleto;
/*   4:    */ import com.servidoctor.constantes.IGrupos;
/*   5:    */ import com.servidoctor.parametros.dao.CiudadDAO;
/*   6:    */ import com.servidoctor.parametros.dao.PaisDAO;
/*   7:    */ import com.servidoctor.parametros.dao.ParentescoDAO;
/*   8:    */ import com.servidoctor.parametros.model.Paises;
/*   9:    */ import com.servidoctor.sdfamily.model.CasoEmergencia;
/*  10:    */ import com.servidoctor.sdfamily.model.SeguroMedico;
/*  11:    */ import com.servidoctor.seguridad.model.Servidores;
/*  12:    */ import com.servidoctor.seguridad.model.UsuarioFamily;
/*  13:    */ import com.servidoctor.util.classes.InicializaData;
/*  14:    */ import com.servidoctor.util.classes.ManejoFechas;
/*  15:    */ import java.math.BigDecimal;
/*  16:    */ import java.util.ArrayList;
/*  17:    */ import java.util.List;
/*  18:    */ import javax.servlet.http.HttpServletRequest;
/*  19:    */ import javax.servlet.http.HttpServletResponse;
/*  20:    */ import javax.servlet.http.HttpSession;
/*  21:    */ import org.apache.commons.beanutils.BeanUtils;
/*  22:    */ import org.apache.struts.action.Action;
/*  23:    */ import org.apache.struts.action.ActionForm;
/*  24:    */ import org.apache.struts.action.ActionForward;
/*  25:    */ import org.apache.struts.action.ActionMapping;
/*  26:    */ 
/*  27:    */ public class PopupDatosPersoAction
/*  28:    */   extends Action
/*  29:    */ {
/*  30:    */   public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  31:    */     throws Exception
/*  32:    */   {
/*  33: 33 */     ActionForward myforward = null;
/*  34: 34 */     String myaction = mapping.getParameter();
/*  35: 36 */     if ("".equalsIgnoreCase(myaction)) {
/*  36: 37 */       myforward = mapping.findForward("failure");
/*  37: 38 */     } else if ("ADD_CONTACTO".equalsIgnoreCase(myaction)) {
/*  38: 39 */       myforward = performAdd_contacto(mapping, actionForm, request, response);
/*  39: 40 */     } else if ("TRASF_CONTACTO".equalsIgnoreCase(myaction)) {
/*  40: 41 */       myforward = performTrasf_contacto(mapping, actionForm, request, response);
/*  41: 42 */     } else if ("EDIT_CONTACTO".equalsIgnoreCase(myaction)) {
/*  42: 43 */       myforward = performEdit_contacto(mapping, actionForm, request, response);
/*  43: 44 */     } else if ("REMOVE_CONTACTO".equalsIgnoreCase(myaction)) {
/*  44: 45 */       myforward = performRemove_contacto(mapping, actionForm, request, response);
/*  45: 46 */     } else if ("ADD_SEGURO".equalsIgnoreCase(myaction)) {
/*  46: 47 */       myforward = performAdd_seguro(mapping, actionForm, request, response);
/*  47: 48 */     } else if ("TRASF_SEGURO".equalsIgnoreCase(myaction)) {
/*  48: 49 */       myforward = performTrasf_seguro(mapping, actionForm, request, response);
/*  49: 50 */     } else if ("EDIT_SEGURO".equalsIgnoreCase(myaction)) {
/*  50: 51 */       myforward = performEdit_seguro(mapping, actionForm, request, response);
/*  51: 52 */     } else if ("REMOVE_SEGURO".equalsIgnoreCase(myaction)) {
/*  52: 53 */       myforward = performRemove_seguro(mapping, actionForm, request, response);
/*  53: 54 */     } else if ("DISCLAIMER".equalsIgnoreCase(myaction)) {
/*  54: 55 */       myforward = performDisclaimer(mapping, actionForm, request, response);
/*  55: 56 */     } else if ("TRASF_DISCLAIMER".equalsIgnoreCase(myaction)) {
/*  56: 57 */       myforward = performTrasf_Disclaimer(mapping, actionForm, request, response);
/*  57:    */     } else {
/*  58: 59 */       myforward = mapping.findForward("failure");
/*  59:    */     }
/*  60: 62 */     return myforward;
/*  61:    */   }
/*  62:    */   
/*  63:    */   private ActionForward performTrasf_Disclaimer(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  64:    */   {
/*  65: 66 */     DisclaimerForm form = (DisclaimerForm)actionForm;
/*  66:    */     try
/*  67:    */     {
/*  68: 69 */       ParentescoDAO parentescoDAO = new ParentescoDAO();
/*  69: 70 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  70: 71 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  71: 72 */         parentescoDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  72:    */       }
/*  73: 74 */       //parentescoDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    parentescoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  74: 75 */       List parentescos = parentescoDAO.list();
/*  75: 76 */       request.setAttribute("PARENTESCOS", parentescos);
/*  76:    */       
/*  77: 78 */       DatosPersonalesForm datosPersonalesForm = (DatosPersonalesForm)request.getSession().getAttribute("datosPersonalesForm");
/*  78: 79 */       BeanUtils.copyProperties(datosPersonalesForm, form);
/*  79:    */     }
/*  80:    */     catch (Exception e)
/*  81:    */     {
                    e.printStackTrace();
/*  82: 82 */       return mapping.findForward("failure");
/*  83:    */     }
/*  84: 84 */     return mapping.findForward("success");
/*  85:    */   }
/*  86:    */   
/*  87:    */   private ActionForward performDisclaimer(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  88:    */   {
/*  89: 88 */     DisclaimerForm form = (DisclaimerForm)actionForm;
/*  90:    */     try
/*  91:    */     {
/*  92: 91 */       ParentescoDAO parentescoDAO = new ParentescoDAO();
/*  93: 92 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  94: 93 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  95: 94 */         parentescoDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  96:    */       }
/*  97: 96 */       //parentescoDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    parentescoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
                    
/*  98: 97 */       List parentescos = parentescoDAO.list();
/*  99: 98 */       request.setAttribute("PARENTESCOS", parentescos);
/* 100:    */       
/* 101:100 */       DatosPersonalesForm datosPersonalesForm = (DatosPersonalesForm)request.getSession().getAttribute("datosPersonalesForm");
/* 102:101 */       BeanUtils.copyProperties(form, datosPersonalesForm);
/* 103:    */     }
/* 104:    */     catch (Exception e)
/* 105:    */     {
                    e.printStackTrace();
/* 106:104 */       return mapping.findForward("failure");
/* 107:    */     }
/* 108:106 */     return mapping.findForward("success");
/* 109:    */   }
/* 110:    */   
/* 111:    */   private ActionForward performAdd_contacto(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 112:    */   {
/* 113:110 */     CasoEmergenciaForm form = (CasoEmergenciaForm)actionForm;
/* 114:    */     try
/* 115:    */     {
/* 116:114 */       PaisDAO paisDAO = new PaisDAO();
/* 117:115 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 118:116 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 119:117 */         paisDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 120:    */       }
/* 121:119 */       //paisDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    paisDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
                    
/* 122:120 */       List paises = paisDAO.list();
/* 123:121 */       request.setAttribute("PAISES", paises);
/* 124:    */       
/* 125:123 */       List ciudades = null;
/* 126:124 */       CiudadDAO ciudadesDAO = new CiudadDAO();
/* 127:125 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 128:126 */         ciudadesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 129:    */       }
/* 130:128 */       //ciudadesDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    ciudadesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 131:129 */       if ((paises.size() > 0) && (!form.getCase_pais_cod().equals("0"))) {
/* 132:130 */         ciudades = ciudadesDAO.search(form.getCase_pais_cod());
/* 133:131 */       } else if (paises.size() > 0) {
/* 134:132 */         ciudades = ciudadesDAO.search(((Paises)paises.get(0)).getPais_cod().toString());
/* 135:    */       }
/* 136:135 */       request.setAttribute("CIUDADES", ciudades);
/* 137:    */       
/* 138:137 */       ParentescoDAO parentescoDAO = new ParentescoDAO();
/* 139:138 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 140:139 */         parentescoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 141:    */       }
/* 142:141 */       //parentescoDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    parentescoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 143:142 */       List parentescos = parentescoDAO.list();
/* 144:143 */       request.setAttribute("PARENTESCOS", parentescos);
/* 145:    */     }
/* 146:    */     catch (Exception e)
/* 147:    */     {
                    e.printStackTrace();
/* 148:146 */       return mapping.findForward("failure");
/* 149:    */     }
/* 150:149 */     return mapping.findForward("success");
/* 151:    */   }
/* 152:    */   
/* 153:    */   private ActionForward performTrasf_contacto(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 154:    */   {
/* 155:152 */     CasoEmergenciaForm form = (CasoEmergenciaForm)actionForm;
/* 156:    */     try
/* 157:    */     {
/* 158:155 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/* 159:    */       
/* 160:157 */       CasoEmergencia casoEmergencia = new CasoEmergencia();
/* 161:158 */       if (form.getCase_indpais1().length() == 0) {
/* 162:159 */         form.setCase_indpais1("0");
/* 163:    */       }
/* 164:160 */       if (form.getCase_indciudad1().length() == 0) {
/* 165:161 */         form.setCase_indciudad1("0");
/* 166:    */       }
/* 167:162 */       if (form.getCase_indpais2().length() == 0) {
/* 168:163 */         form.setCase_indpais2("0");
/* 169:    */       }
/* 170:165 */       InicializaData.inicializa(casoEmergencia.getClass(), casoEmergencia);
/* 171:166 */       BeanUtils.copyProperties(casoEmergencia, form);
/* 172:167 */       casoEmergencia.setCase_usuf_cod(usuarioFamily.getUsuf_cod());
/* 173:    */       
/* 174:169 */       List contactos = new ArrayList();
/* 175:171 */       if (request.getSession().getAttribute("CONTACTOS") != null) {
/* 176:172 */         contactos = (List)request.getSession().getAttribute("CONTACTOS");
/* 177:    */       }
/* 178:175 */       if (request.getParameter("num_contacto") == null) {
/* 179:176 */         contactos.add(casoEmergencia);
/* 180:    */       } else {
/* 181:178 */         contactos.set(Integer.parseInt(request.getParameter("num_contacto")), casoEmergencia);
/* 182:    */       }
/* 183:181 */       request.getSession().setAttribute("CONTACTOS", contactos);
/* 184:    */     }
/* 185:    */     catch (Exception e)
/* 186:    */     {
                    e.printStackTrace();
/* 187:184 */       return mapping.findForward("failure");
/* 188:    */     }
/* 189:187 */     return mapping.findForward("success");
/* 190:    */   }
/* 191:    */   
/* 192:    */   private ActionForward performEdit_contacto(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 193:    */   {
/* 194:191 */     CasoEmergenciaForm form = (CasoEmergenciaForm)actionForm;
/* 195:    */     try
/* 196:    */     {
/* 197:195 */       List contactos = (List)request.getSession().getAttribute("CONTACTOS");
/* 198:196 */       CasoEmergencia casoEmergencia = (CasoEmergencia)contactos.get(Integer.parseInt(request.getParameter("num_contacto")));
/* 199:197 */       if (request.getParameter("change") == null) {
/* 200:198 */         BeanUtils.copyProperties(form, casoEmergencia);
/* 201:    */       }
/* 202:201 */       PaisDAO paisDAO = new PaisDAO();
/* 203:202 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 204:203 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 205:204 */         paisDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 206:    */       }
/* 207:206 */       //paisDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    paisDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 208:207 */       List paises = paisDAO.list();
/* 209:208 */       request.setAttribute("PAISES", paises);
/* 210:    */       
/* 211:210 */       List ciudades = null;
/* 212:211 */       CiudadDAO ciudadesDAO = new CiudadDAO();
/* 213:212 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 214:213 */         ciudadesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 215:    */       }
/* 216:215 */       //ciudadesDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    ciudadesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 217:216 */       if ((paises.size() > 0) && (!form.getCase_pais_cod().equals("0"))) {
/* 218:217 */         ciudades = ciudadesDAO.search(form.getCase_pais_cod());
/* 219:218 */       } else if (paises.size() > 0) {
/* 220:219 */         ciudades = ciudadesDAO.search(((Paises)paises.get(0)).getPais_cod().toString());
/* 221:    */       }
/* 222:222 */       request.setAttribute("CIUDADES", ciudades);
/* 223:    */       
/* 224:224 */       ParentescoDAO parentescoDAO = new ParentescoDAO();
/* 225:225 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 226:226 */         parentescoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 227:    */       }
/* 228:228 */       //parentescoDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    parentescoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 229:229 */       List parentescos = parentescoDAO.list();
/* 230:230 */       request.setAttribute("PARENTESCOS", parentescos);
/* 231:    */     }
/* 232:    */     catch (Exception e)
/* 233:    */     {
                    e.printStackTrace();
/* 234:234 */       return mapping.findForward("failure");
/* 235:    */     }
/* 236:236 */     return mapping.findForward("success");
/* 237:    */   }
/* 238:    */   
/* 239:    */   private ActionForward performRemove_contacto(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 240:    */   {
/* 241:240 */     CasoEmergenciaForm form = (CasoEmergenciaForm)actionForm;
/* 242:    */     try
/* 243:    */     {
/* 244:244 */       List contactos = new ArrayList();
/* 245:245 */       contactos = (List)request.getSession().getAttribute("CONTACTOS");
/* 246:246 */       contactos.remove(Integer.parseInt(request.getParameter("num_contacto")));
/* 247:247 */       int x = 0;
/* 248:248 */       while (x < contactos.size())
/* 249:    */       {
/* 250:249 */         CasoEmergencia casoEmergencia = (CasoEmergencia)contactos.get(x);
/* 251:250 */         casoEmergencia.setCase_cod(new BigDecimal(x + 1));
/* 252:251 */         contactos.set(x, casoEmergencia);
/* 253:252 */         x++;
/* 254:    */       }
/* 255:    */     }
/* 256:    */     catch (Exception e)
/* 257:    */     {
                    e.printStackTrace();
/* 258:258 */       return mapping.findForward("failure");
/* 259:    */     }
/* 260:260 */     return mapping.findForward("success");
/* 261:    */   }
/* 262:    */   
/* 263:    */   private ActionForward performAdd_seguro(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 264:    */   {
/* 265:263 */     SeguroMedicoForm form = (SeguroMedicoForm)actionForm;
/* 266:    */     
/* 267:    */ 
/* 268:    */ 
/* 269:    */ 
/* 270:    */ 
/* 271:    */ 
/* 272:    */ 
/* 273:271 */     return mapping.findForward("success");
/* 274:    */   }
/* 275:    */   
/* 276:    */   private ActionForward performTrasf_seguro(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 277:    */   {
/* 278:274 */     SeguroMedicoForm form = (SeguroMedicoForm)actionForm;
/* 279:    */     try
/* 280:    */     {
/* 281:278 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/* 282:    */       
/* 283:280 */       SeguroMedico seguro = new SeguroMedico();
/* 284:281 */       InicializaData.inicializa(seguro.getClass(), seguro);
/* 285:282 */       if (form.getSegm_indpais1().length() == 0) {
/* 286:283 */         form.setSegm_indpais1("0");
/* 287:    */       }
/* 288:284 */       if (form.getSegm_indciudad1().length() == 0) {
/* 289:285 */         form.setSegm_indciudad1("0");
/* 290:    */       }
/* 291:286 */       if (form.getSegm_indpais2().length() == 0) {
/* 292:287 */         form.setSegm_indpais2("0");
/* 293:    */       }
/* 294:288 */       if (form.getSegm_indpais3().length() == 0) {
/* 295:289 */         form.setSegm_indpais3("0");
/* 296:    */       }
/* 297:290 */       if (form.getSegm_indciudad3().length() == 0) {
/* 298:291 */         form.setSegm_indciudad3("0");
/* 299:    */       }
/* 300:293 */       BeanUtils.copyProperties(seguro, form);
/* 301:294 */       seguro.setSegm_vig_desde(new BigDecimal(ManejoFechas.getChangeFecha(form.getSegm_vig_desde())));
/* 302:295 */       seguro.setSegm_vig_hasta(new BigDecimal(ManejoFechas.getChangeFecha(form.getSegm_vig_hasta())));
/* 303:296 */       seguro.setSegm_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(form.getSegm_vig_hasta().toString(), "yyyyMMdd", 15)));
/* 304:297 */       seguro.setSegm_usuf_cod(usuarioFamily.getUsuf_cod());
/* 305:298 */       seguro.setSegm_grup_cod(IGrupos.FAMILY_SEGUROS);
/* 306:    */       
/* 307:300 */       List seguros = new ArrayList();
/* 308:302 */       if (request.getSession().getAttribute("SEGUROS") != null) {
/* 309:303 */         seguros = (List)request.getSession().getAttribute("SEGUROS");
/* 310:    */       }
/* 311:306 */       if (request.getParameter("num_seguro") == null) {
/* 312:307 */         seguros.add(seguro);
/* 313:    */       } else {
/* 314:309 */         seguros.set(Integer.parseInt(request.getParameter("num_seguro")), seguro);
/* 315:    */       }
/* 316:312 */       request.getSession().setAttribute("SEGUROS", seguros);
/* 317:    */     }
/* 318:    */     catch (Exception e)
/* 319:    */     {
                    e.printStackTrace();
/* 320:315 */       return mapping.findForward("failure");
/* 321:    */     }
/* 322:318 */     return mapping.findForward("success");
/* 323:    */   }
/* 324:    */   
/* 325:    */   private ActionForward performEdit_seguro(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 326:    */   {
/* 327:321 */     SeguroMedicoForm form = (SeguroMedicoForm)actionForm;
/* 328:    */     try
/* 329:    */     {
/* 330:324 */       List seguros = new ArrayList();
/* 331:325 */       seguros = (List)request.getSession().getAttribute("SEGUROS");
/* 332:326 */       SeguroMedico seguro = (SeguroMedico)seguros.get(Integer.parseInt(request.getParameter("num_seguro")));
/* 333:327 */       if (request.getParameter("change") == null) {
/* 334:328 */         BeanUtils.copyProperties(form, seguro);
/* 335:    */       }
/* 336:330 */       form.setSegm_vig_desde(ManejoFechas.FormateoFecha(seguro.getSegm_vig_desde().toString()));
/* 337:331 */       form.setSegm_vig_hasta(ManejoFechas.FormateoFecha(seguro.getSegm_vig_hasta().toString()));
/* 338:    */     }
/* 339:    */     catch (Exception e)
/* 340:    */     {
                    e.printStackTrace();
/* 341:335 */       return mapping.findForward("failure");
/* 342:    */     }
/* 343:338 */     return mapping.findForward("success");
/* 344:    */   }
/* 345:    */   
/* 346:    */   private ActionForward performRemove_seguro(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 347:    */   {
/* 348:342 */     SeguroMedicoForm form = (SeguroMedicoForm)actionForm;
/* 349:    */     try
/* 350:    */     {
/* 351:346 */       List seguros = new ArrayList();
/* 352:347 */       seguros = (List)request.getSession().getAttribute("SEGUROS");
/* 353:348 */       seguros.remove(Integer.parseInt(request.getParameter("num_seguro")));
/* 354:    */       
/* 355:350 */       int x = 0;
/* 356:351 */       while (x < seguros.size())
/* 357:    */       {
/* 358:352 */         SeguroMedico seguro = (SeguroMedico)seguros.get(x);
/* 359:353 */         seguro.setSegm_cod(new BigDecimal(x + 1));
/* 360:354 */         seguros.set(x, seguro);
/* 361:355 */         x++;
/* 362:    */       }
/* 363:    */     }
/* 364:    */     catch (Exception e)
/* 365:    */     {
                    e.printStackTrace();
/* 366:359 */       return mapping.findForward("failure");
/* 367:    */     }
/* 368:362 */     return mapping.findForward("success");
/* 369:    */   }
/* 370:    */ }



/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\

 * Qualified Name:     com.servidoctor.sdfamily.controller.PopupDatosPersoAction

 * JD-Core Version:    0.7.0.1

 */