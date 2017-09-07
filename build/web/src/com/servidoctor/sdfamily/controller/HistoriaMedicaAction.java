/*   1:    */ package com.servidoctor.sdfamily.controller;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.controller.BaseAction;
/*   4:    */ import com.servidoctor.constantes.IConstantes;
/*   5:    */ import com.servidoctor.parametros.dao.ConsumoDAO;
/*   6:    */ import com.servidoctor.parametros.model.Alergias;
/*   7:    */ import com.servidoctor.parametros.model.Antecedentes;
/*   8:    */ import com.servidoctor.parametros.model.Cirujias;
/*   9:    */ import com.servidoctor.parametros.model.ElementoConsumo;
/*  10:    */ import com.servidoctor.parametros.model.Enfermedades;
/*  11:    */ import com.servidoctor.parametros.model.GinecologiaOperaciones;
/*  12:    */ import com.servidoctor.parametros.model.PartesCuerpo;
/*  13:    */ import com.servidoctor.sdfamily.dao.HistoriaMedicaDAO;
/*  14:    */ import com.servidoctor.sdfamily.model.AntecedentesUsuario;
/*  15:    */ import com.servidoctor.sdfamily.model.DatosPersonales;
/*  16:    */ import com.servidoctor.sdfamily.model.ElementoConsumoUsuario;
/*  17:    */ import com.servidoctor.sdfamily.model.Ginecologia;
/*  18:    */ import com.servidoctor.sdfamily.model.GinecologiaOperacionesUsuario;
/*  19:    */ import com.servidoctor.sdfamily.model.HistoriaMedica;
/*  20:    */ import com.servidoctor.sdfamily.model.PartesCuerpoUsuario;
/*  21:    */ import com.servidoctor.seguridad.model.Servidores;
/*  22:    */ import com.servidoctor.seguridad.model.UsuarioFamily;
/*  23:    */ import com.servidoctor.util.classes.BorrarSession;
/*  24:    */ import com.servidoctor.util.classes.InicializaData;
/*  25:    */ import com.servidoctor.util.classes.ManejoFechas;
/*  26:    */ import java.math.BigDecimal;
/*  27:    */ import java.util.ArrayList;
/*  28:    */ import java.util.List;
/*  29:    */ import javax.servlet.http.HttpServletRequest;
/*  30:    */ import javax.servlet.http.HttpServletResponse;
/*  31:    */ import javax.servlet.http.HttpSession;
/*  32:    */ import org.apache.commons.beanutils.BeanUtils;
/*  33:    */ import org.apache.struts.action.ActionForm;
/*  34:    */ import org.apache.struts.action.ActionForward;
/*  35:    */ import org.apache.struts.action.ActionMapping;
/*  36:    */ 
/*  37:    */ public class HistoriaMedicaAction
/*  38:    */   extends BaseAction
/*  39:    */ {
/*  40:    */   public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  41:    */     throws Exception
/*  42:    */   {
/*  43: 49 */     ActionForward myforward = super.execute(mapping, actionForm, request, response);
/*  44: 50 */     String myaction = mapping.getParameter();
/*  45: 52 */     if (myforward == null)
/*  46:    */     {
/*  47: 53 */       DatosPersonales datosPersonales = (DatosPersonales)request.getSession().getAttribute("datosPersonales");
/*  48: 54 */       if (datosPersonales.getDatp_usuf_cod() == null) {
/*  49: 55 */         myforward = mapping.findForward("datospersonales");
/*  50: 56 */       } else if ("".equalsIgnoreCase(myaction)) {
/*  51: 57 */         myforward = mapping.findForward("failure");
/*  52: 58 */       } else if ("EDIT".equalsIgnoreCase(myaction)) {
/*  53: 59 */         myforward = performEdit(mapping, actionForm, request, response);
/*  54: 60 */       } else if ("ADD".equalsIgnoreCase(myaction)) {
/*  55: 61 */         myforward = performAdd(mapping, actionForm, request, response);
/*  56: 62 */       } else if ("VIEW".equalsIgnoreCase(myaction)) {
/*  57: 63 */         myforward = performView(mapping, actionForm, request, response);
/*  58: 64 */       } else if ("SAVE".equalsIgnoreCase(myaction)) {
/*  59: 65 */         myforward = performSave(mapping, actionForm, request, response);
/*  60:    */       } else {
/*  61: 67 */         myforward = mapping.findForward("failure");
/*  62:    */       }
/*  63:    */     }
/*  64: 71 */     return myforward;
/*  65:    */   }
/*  66:    */   
/*  67:    */   private ActionForward performEdit(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  68:    */   {
/*  69: 75 */     HistoriaMedicaForm form = (HistoriaMedicaForm)actionForm;
/*  70:    */     
/*  71:    */ 
/*  72:    */ 
/*  73:    */ 
/*  74:    */ 
/*  75:    */ 
/*  76:    */ 
/*  77: 83 */     return mapping.findForward("success");
/*  78:    */   }
/*  79:    */   
/*  80:    */   private ActionForward performView(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  81:    */   {
/*  82: 86 */     HistoriaMedicaForm form = (HistoriaMedicaForm)actionForm;
/*  83: 87 */     int x = 0;
/*  84:    */     try
/*  85:    */     {
/*  86: 91 */       BorrarSession.eliminaAtributos(request.getSession(), "historiaMedicaForm");
/*  87:    */       
/*  88: 93 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/*  89:    */       
/*  90: 95 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  91: 96 */       DatosPersonales datosPersonales = (DatosPersonales)request.getSession().getAttribute("datosPersonales");
/*  92:    */       
/*  93: 98 */       HistoriaMedicaDAO historiaMedicaDAO = new HistoriaMedicaDAO();
/*  94: 99 */       servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  95:100 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  96:101 */         historiaMedicaDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  97:    */       }
/*  98:103 */       //historiaMedicaDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    historiaMedicaDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  99:104 */       HistoriaMedica historiaMedica = historiaMedicaDAO.retrieve(usuarioFamily.getUsuf_cod());
/* 100:    */       
/* 101:    */       System.out.println("antes enfermedades");
/* 102:107 */       List enfermedadesUsuario = historiaMedica.getEnfermedadesUsuario();
                    System.out.println("despues enfermedades");
                    
/* 103:108 */       request.getSession().setAttribute("ENFERMEDADESUSUARIO", enfermedadesUsuario);
/* 104:    */       
/* 105:110 */       int i = 0;
/* 106:111 */       List enfermedades = historiaMedica.getEnfermedades();
/* 107:112 */       while (i < enfermedades.size())
/* 108:    */       {
/* 109:113 */         Enfermedades enfermedad = (Enfermedades)enfermedades.get(i);
/* 110:114 */         request.setAttribute("enf_des" + enfermedad.getEnf_cod(), enfermedad.getEnf_des());
/* 111:115 */         i++;
/* 112:    */       }
/* 113:119 */       List alergiasUsuario = historiaMedica.getAlergiasUsuario();
/* 114:120 */       List alergias = historiaMedica.getAlergias();
/* 115:121 */       request.getSession().setAttribute("ALERGIASUSUARIO", alergiasUsuario);
/* 116:122 */       i = 0;
/* 117:123 */       while (i < alergias.size())
/* 118:    */       {
/* 119:124 */         Alergias alergia = (Alergias)alergias.get(i);
/* 120:125 */         request.setAttribute("ale_des" + alergia.getAle_cod(), alergia.getAle_des());
/* 121:126 */         i++;
/* 122:    */       }
/* 123:130 */       List cirujiasUsuario = historiaMedica.getCirujiasUsuario();
/* 124:131 */       List cirujias = historiaMedica.getCirujias();
/* 125:132 */       request.getSession().setAttribute("CIRUJIASUSUARIO", cirujiasUsuario);
/* 126:133 */       i = 0;
/* 127:134 */       while (i < cirujias.size())
/* 128:    */       {
/* 129:135 */         Cirujias cirujia = (Cirujias)cirujias.get(i);
/* 130:136 */         request.setAttribute("cir_des" + cirujia.getCir_cod(), cirujia.getCir_des());
/* 131:137 */         i++;
/* 132:    */       }
/* 133:141 */       List medicamentosUsuario = historiaMedica.getMedicamentosUsuario();
/* 134:142 */       request.getSession().setAttribute("MEDICAMENTOSUSUARIO", medicamentosUsuario);
/* 135:    */       
/* 136:    */ 
/* 137:145 */       List antecedentesUsuario = historiaMedica.getAntecedentesUsuario();
/* 138:146 */       List antecedentes = historiaMedica.getAntecedentes();
/* 139:147 */       request.getSession().setAttribute("ANTECEDENTESUSUARIO", antecedentesUsuario);
/* 140:148 */       i = 0;
/* 141:149 */       while (i < antecedentes.size())
/* 142:    */       {
/* 143:150 */         Antecedentes antecedente = (Antecedentes)antecedentes.get(i);
/* 144:151 */         request.setAttribute("ante_des" + antecedente.getAnte_cod(), antecedente.getAnte_des());
/* 145:152 */         i++;
/* 146:    */       }
/* 147:156 */       List partesCuerpoUsuario = historiaMedica.getPartesCuerpoUsuario();
/* 148:157 */       List partesCuerpo = historiaMedica.getPartesCuerpo();
/* 149:158 */       request.getSession().setAttribute("PARTESCUERPOUSUARIO", partesCuerpoUsuario);
/* 150:159 */       i = 0;
/* 151:160 */       while (i < partesCuerpo.size())
/* 152:    */       {
/* 153:161 */         PartesCuerpo parteCuerpo = (PartesCuerpo)partesCuerpo.get(i);
/* 154:162 */         request.setAttribute("pcue_des" + parteCuerpo.getPcue_cod(), parteCuerpo.getPcue_des());
/* 155:163 */         i++;
/* 156:    */       }
/* 157:167 */       List elementosConsumoUsuario = historiaMedica.getElementosConsumoUsuario();
/* 158:168 */       List elementosConsumo = historiaMedica.getElementosConsumo();
/* 159:169 */       request.getSession().setAttribute("ELEMENTOSCONSUMOUSUARIO", elementosConsumoUsuario);
/* 160:170 */       i = 0;
/* 161:171 */       while (i < elementosConsumo.size())
/* 162:    */       {
/* 163:172 */         ElementoConsumo elementoConsumo = (ElementoConsumo)elementosConsumo.get(i);
/* 164:173 */         request.setAttribute("econ_des" + elementoConsumo.getEcon_cod(), elementoConsumo.getEcon_des());
/* 165:174 */         i++;
/* 166:    */       }
/* 167:177 */       List consumos = new ArrayList();
/* 168:178 */       ConsumoDAO consumoDAO = new ConsumoDAO();
/* 169:179 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 170:180 */         consumoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 171:    */       }
/* 172:182 */       //consumoDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    consumoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 173:183 */       consumos = consumoDAO.list();
/* 174:184 */       request.getSession().setAttribute("CONSUMOS", consumos);
/* 175:188 */       if (datosPersonales.getDatp_sexo().equals("F"))
/* 176:    */       {
/* 177:189 */         Ginecologia ginecologia = historiaMedica.getGinecologia();
/* 178:    */         
/* 179:191 */         BeanUtils.copyProperties(form, ginecologia);
/* 180:192 */         form.setGine_fec_ult(ManejoFechas.FormateoFecha(ginecologia.getGine_fec_ult().toString()));
/* 181:    */         
/* 182:194 */         List ginecologiaOperacionesUsuario = historiaMedica.getGinecologiaOperacionesUsuario();
/* 183:195 */         List ginecologiaOperaciones = historiaMedica.getGinecologiaOperaciones();
/* 184:    */         
/* 185:197 */         request.getSession().setAttribute("GINECOLOGIAOPERACIONESUSUARIO", ginecologiaOperacionesUsuario);
/* 186:198 */         i = 0;
/* 187:199 */         while (i < ginecologiaOperaciones.size())
/* 188:    */         {
/* 189:200 */           GinecologiaOperaciones operacion = (GinecologiaOperaciones)ginecologiaOperaciones.get(i);
/* 190:201 */           request.setAttribute("gope_des" + operacion.getGope_cod(), operacion.getGope_des());
/* 191:202 */           i++;
/* 192:    */         }
/* 193:    */       }
/* 194:    */     }
/* 195:    */     catch (Exception e)
/* 196:    */     {
/* 197:207 */       e.printStackTrace();
/* 198:208 */       return mapping.findForward("failure");
/* 199:    */     }
/* 200:210 */     return mapping.findForward("success");
/* 201:    */   }
/* 202:    */   
/* 203:    */   private ActionForward performAdd(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 204:    */   {
/* 205:214 */     HistoriaMedicaForm form = (HistoriaMedicaForm)actionForm;
/* 206:    */     try
/* 207:    */     {
/* 208:217 */       List enfermedadesUsuario = (List)request.getSession().getAttribute("ENFERMEDADESUSUARIO");
/* 209:218 */       List alergiasUsuario = (List)request.getSession().getAttribute("ALERGIASUSUARIO");
/* 210:219 */       List cirujiasUsuario = (List)request.getSession().getAttribute("CIRUJIASUSUARIO");
/* 211:220 */       List partesCuerpoUsuario = (List)request.getSession().getAttribute("PARTESCUERPOUSUARIO");
/* 212:221 */       List antecedentesUsuario = (List)request.getSession().getAttribute("ANTECEDENTESUSUARIO");
/* 213:222 */       List elementosConsumoUsuario = (List)request.getSession().getAttribute("ELEMENTOSCONSUMOUSUARIO");
/* 214:    */       
/* 215:224 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/* 216:    */       
/* 217:226 */       int x = 0;
/* 218:227 */       int num_ante = antecedentesUsuario.size();
/* 219:229 */       while (x < num_ante)
/* 220:    */       {
/* 221:230 */         AntecedentesUsuario antecedenteUsuario = (AntecedentesUsuario)antecedentesUsuario.get(x);
/* 222:231 */         if (request.getParameter("abuelo" + x) != null) {
/* 223:232 */           antecedenteUsuario.setAnteu_abuelos(IConstantes.CODIGO_SI);
/* 224:    */         } else {
/* 225:234 */           antecedenteUsuario.setAnteu_abuelos(IConstantes.CODIGO_NO);
/* 226:    */         }
/* 227:236 */         if (request.getParameter("padre" + x) != null) {
/* 228:237 */           antecedenteUsuario.setAnteu_padre(IConstantes.CODIGO_SI);
/* 229:    */         } else {
/* 230:239 */           antecedenteUsuario.setAnteu_padre(IConstantes.CODIGO_NO);
/* 231:    */         }
/* 232:241 */         if (request.getParameter("madre" + x) != null) {
/* 233:242 */           antecedenteUsuario.setAnteu_madre(IConstantes.CODIGO_SI);
/* 234:    */         } else {
/* 235:244 */           antecedenteUsuario.setAnteu_madre(IConstantes.CODIGO_NO);
/* 236:    */         }
/* 237:246 */         if (request.getParameter("hermano" + x) != null) {
/* 238:247 */           antecedenteUsuario.setAnteu_hermanos(IConstantes.CODIGO_SI);
/* 239:    */         } else {
/* 240:249 */           antecedenteUsuario.setAnteu_hermanos(IConstantes.CODIGO_NO);
/* 241:    */         }
/* 242:251 */         x++;
/* 243:    */       }
/* 244:254 */       x = 0;
/* 245:255 */       if (request.getParameter("elemento[" + x + "].econu_cons_cod") != null) {
/* 246:256 */         while (x < elementosConsumoUsuario.size())
/* 247:    */         {
/* 248:257 */           ElementoConsumoUsuario elementoConsumoUsuario = (ElementoConsumoUsuario)elementosConsumoUsuario.get(x);
/* 249:258 */           elementoConsumoUsuario.setEconu_cons_cod(new BigDecimal(request.getParameter("elemento[" + x + "].econu_cons_cod")));
/* 250:259 */           elementoConsumoUsuario.setEconu_usuf_cod(usuarioFamily.getUsuf_cod());
/* 251:260 */           x++;
/* 252:    */         }
/* 253:    */       }
/* 254:264 */       x = 0;
/* 255:265 */       if (request.getParameter("partes[" + x + "].pcueu_comentario") != null) {
/* 256:266 */         while (x < partesCuerpoUsuario.size())
/* 257:    */         {
/* 258:267 */           PartesCuerpoUsuario parteCuerpoUsuario = (PartesCuerpoUsuario)partesCuerpoUsuario.get(x);
/* 259:268 */           parteCuerpoUsuario.setPcueu_comentario(request.getParameter("partes[" + x + "].pcueu_comentario"));
/* 260:269 */           parteCuerpoUsuario.setPcueu_usuf_cod(usuarioFamily.getUsuf_cod());
/* 261:270 */           x++;
/* 262:    */         }
/* 263:    */       }
/* 264:274 */       if (request.getParameter("oper[" + x + "].gopeu_cantidad") != null)
/* 265:    */       {
/* 266:275 */         Ginecologia ginecologia = new Ginecologia();
/* 267:276 */         InicializaData.inicializa(ginecologia.getClass(), ginecologia);
/* 268:277 */         BeanUtils.copyProperties(ginecologia, form);
/* 269:278 */         ginecologia.setGine_usuf_cod(usuarioFamily.getUsuf_cod());
/* 270:    */         
/* 271:280 */         x = 0;
/* 272:281 */         List operaciones = (List)request.getSession().getAttribute("GINECOLOGIAOPERACIONES");
/* 273:283 */         while (x < operaciones.size())
/* 274:    */         {
/* 275:284 */           GinecologiaOperacionesUsuario ginecologiaOperacionesUsuario = (GinecologiaOperacionesUsuario)operaciones.get(x);
/* 276:285 */           ginecologiaOperacionesUsuario.setGopeu_cantidad(new BigDecimal(request.getParameter("oper[" + x + "].gopeu_cantidad")));
/* 277:286 */           ginecologiaOperacionesUsuario.setGopeu_fecha(new BigDecimal(request.getParameter("gopeu_fecha" + x)));
/* 278:287 */           ginecologiaOperacionesUsuario.setGopeu_usuf_cod(usuarioFamily.getUsuf_cod());
/* 279:288 */           x++;
/* 280:    */         }
/* 281:    */       }
/* 282:292 */       HistoriaMedicaDAO historiaMedicaDAO = new HistoriaMedicaDAO();
/* 283:293 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 284:294 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 285:295 */         historiaMedicaDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 286:    */       }
/* 287:297 */       //historiaMedicaDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    historiaMedicaDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 288:298 */       HistoriaMedica historiaMedica = historiaMedicaDAO.retrieve(usuarioFamily.getUsuf_cod());
/* 289:    */       
/* 290:300 */       int i = 0;
/* 291:301 */       List enfermedades = historiaMedica.getEnfermedades();
/* 292:302 */       while (i < enfermedades.size())
/* 293:    */       {
/* 294:303 */         Enfermedades enfermedad = (Enfermedades)enfermedades.get(i);
/* 295:304 */         request.setAttribute("enf_des" + enfermedad.getEnf_cod(), enfermedad.getEnf_des());
/* 296:305 */         i++;
/* 297:    */       }
/* 298:308 */       List alergias = historiaMedica.getAlergias();
/* 299:309 */       request.getSession().setAttribute("ALERGIASUSUARIO", alergiasUsuario);
/* 300:310 */       i = 0;
/* 301:311 */       while (i < alergias.size())
/* 302:    */       {
/* 303:312 */         Alergias alergia = (Alergias)alergias.get(i);
/* 304:313 */         request.setAttribute("ale_des" + alergia.getAle_cod(), alergia.getAle_des());
/* 305:314 */         i++;
/* 306:    */       }
/* 307:317 */       List cirujias = historiaMedica.getCirujias();
/* 308:318 */       request.getSession().setAttribute("CIRUJIASUSUARIO", cirujiasUsuario);
/* 309:319 */       i = 0;
/* 310:320 */       while (i < cirujias.size())
/* 311:    */       {
/* 312:321 */         Cirujias cirujia = (Cirujias)cirujias.get(i);
/* 313:322 */         request.setAttribute("cir_des" + cirujia.getCir_cod(), cirujia.getCir_des());
/* 314:323 */         i++;
/* 315:    */       }
/* 316:326 */       List antecedentes = historiaMedica.getAntecedentes();
/* 317:327 */       request.getSession().setAttribute("ANTECEDENTESUSUARIO", antecedentesUsuario);
/* 318:328 */       i = 0;
/* 319:329 */       while (i < antecedentes.size())
/* 320:    */       {
/* 321:330 */         Antecedentes antecedente = (Antecedentes)antecedentes.get(i);
/* 322:331 */         request.setAttribute("ante_des" + antecedente.getAnte_cod(), antecedente.getAnte_des());
/* 323:332 */         i++;
/* 324:    */       }
/* 325:335 */       List partesCuerpo = historiaMedica.getPartesCuerpo();
/* 326:336 */       request.getSession().setAttribute("PARTESCUERPOUSUARIO", partesCuerpoUsuario);
/* 327:337 */       i = 0;
/* 328:338 */       while (i < partesCuerpo.size())
/* 329:    */       {
/* 330:339 */         PartesCuerpo parteCuerpo = (PartesCuerpo)partesCuerpo.get(i);
/* 331:340 */         request.setAttribute("pcue_des" + parteCuerpo.getPcue_cod(), parteCuerpo.getPcue_des());
/* 332:341 */         i++;
/* 333:    */       }
/* 334:344 */       List elementosConsumo = historiaMedica.getElementosConsumo();
/* 335:345 */       request.getSession().setAttribute("ELEMENTOSCONSUMOUSUARIO", elementosConsumoUsuario);
/* 336:346 */       i = 0;
/* 337:347 */       while (i < elementosConsumo.size())
/* 338:    */       {
/* 339:348 */         ElementoConsumo elementoConsumo = (ElementoConsumo)elementosConsumo.get(i);
/* 340:349 */         request.setAttribute("econ_des" + elementoConsumo.getEcon_cod(), elementoConsumo.getEcon_des());
/* 341:350 */         i++;
/* 342:    */       }
/* 343:353 */       DatosPersonales datosPersonales = (DatosPersonales)request.getSession().getAttribute("datosPersonales");
/* 344:354 */       if (datosPersonales.getDatp_sexo().equals("F"))
/* 345:    */       {
/* 346:355 */         List ginecologiaOperacionesUsuario = (List)request.getSession().getAttribute("GINECOLOGIAOPERACIONESUSUARIO");
/* 347:356 */         List ginecologiaOperaciones = historiaMedica.getGinecologiaOperaciones();
/* 348:    */         
/* 349:358 */         request.getSession().setAttribute("GINECOLOGIAOPERACIONESUSUARIO", ginecologiaOperacionesUsuario);
/* 350:359 */         i = 0;
/* 351:360 */         while (i < ginecologiaOperaciones.size())
/* 352:    */         {
/* 353:361 */           GinecologiaOperaciones operacion = (GinecologiaOperaciones)ginecologiaOperaciones.get(i);
/* 354:362 */           request.setAttribute("gope_des" + operacion.getGope_cod(), operacion.getGope_des());
/* 355:363 */           i++;
/* 356:    */         }
/* 357:    */       }
/* 358:367 */       form.setGine_fec_ult(ManejoFechas.FormateoFecha(form.getGine_fec_ult()));
/* 359:    */     }
/* 360:    */     catch (Exception e)
/* 361:    */     {
/* 362:370 */       e.printStackTrace();
/* 363:371 */       return mapping.findForward("failure");
/* 364:    */     }
/* 365:374 */     return mapping.findForward("success");
/* 366:    */   }
/* 367:    */   
/* 368:    */   private ActionForward performSave(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 369:    */   {
/* 370:378 */     HistoriaMedicaForm form = (HistoriaMedicaForm)actionForm;
/* 371:    */     try
/* 372:    */     {
/* 373:382 */       List enfermedadesUsuario = (List)request.getSession().getAttribute("ENFERMEDADESUSUARIO");
/* 374:383 */       List alergiasUsuario = (List)request.getSession().getAttribute("ALERGIASUSUARIO");
/* 375:384 */       List cirujiasUsuario = (List)request.getSession().getAttribute("CIRUJIASUSUARIO");
/* 376:385 */       List medicamentosUsuario = (List)request.getSession().getAttribute("MEDICAMENTOSUSUARIO");
/* 377:386 */       List partesCuerpoUsuario = (List)request.getSession().getAttribute("PARTESCUERPOUSUARIO");
/* 378:387 */       List antecedentesUsuario = (List)request.getSession().getAttribute("ANTECEDENTESUSUARIO");
/* 379:388 */       List elementosConsumoUsuario = (List)request.getSession().getAttribute("ELEMENTOSCONSUMOUSUARIO");
/* 380:    */       
/* 381:390 */       HistoriaMedicaDAO historiaMedicaDAO = new HistoriaMedicaDAO();
/* 382:391 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 383:392 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 384:393 */         historiaMedicaDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 385:    */       }
/* 386:395 */       //historiaMedicaDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    historiaMedicaDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 387:    */       
/* 388:397 */       HistoriaMedica historiaMedica = new HistoriaMedica();
/* 389:398 */       historiaMedica.setAntecedentesUsuario(antecedentesUsuario);
/* 390:399 */       historiaMedica.setPartesCuerpoUsuario(partesCuerpoUsuario);
/* 391:400 */       historiaMedica.setAlergiasUsuario(alergiasUsuario);
/* 392:401 */       historiaMedica.setCirujiasUsuario(cirujiasUsuario);
/* 393:402 */       historiaMedica.setEnfermedadesUsuario(enfermedadesUsuario);
/* 394:403 */       historiaMedica.setMedicamentosUsuario(medicamentosUsuario);
/* 395:404 */       historiaMedica.setElementosConsumoUsuario(elementosConsumoUsuario);
/* 396:    */       
/* 397:406 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/* 398:    */       
/* 399:408 */       int x = 0;
/* 400:409 */       int num_ante = antecedentesUsuario.size();
/* 401:412 */       while (x < num_ante)
/* 402:    */       {
/* 403:413 */         AntecedentesUsuario antecedenteUsuario = (AntecedentesUsuario)antecedentesUsuario.get(x);
/* 404:414 */         if (request.getParameter("abuelo" + x) != null) {
/* 405:415 */           antecedenteUsuario.setAnteu_abuelos(IConstantes.CODIGO_SI);
/* 406:    */         } else {
/* 407:417 */           antecedenteUsuario.setAnteu_abuelos(IConstantes.CODIGO_NO);
/* 408:    */         }
/* 409:419 */         if (request.getParameter("padre" + x) != null) {
/* 410:420 */           antecedenteUsuario.setAnteu_padre(IConstantes.CODIGO_SI);
/* 411:    */         } else {
/* 412:422 */           antecedenteUsuario.setAnteu_padre(IConstantes.CODIGO_NO);
/* 413:    */         }
/* 414:424 */         if (request.getParameter("madre" + x) != null) {
/* 415:425 */           antecedenteUsuario.setAnteu_madre(IConstantes.CODIGO_SI);
/* 416:    */         } else {
/* 417:427 */           antecedenteUsuario.setAnteu_madre(IConstantes.CODIGO_NO);
/* 418:    */         }
/* 419:429 */         if (request.getParameter("hermano" + x) != null) {
/* 420:430 */           antecedenteUsuario.setAnteu_hermanos(IConstantes.CODIGO_SI);
/* 421:    */         } else {
/* 422:432 */           antecedenteUsuario.setAnteu_hermanos(IConstantes.CODIGO_NO);
/* 423:    */         }
/* 424:434 */         x++;
/* 425:    */       }
/* 426:437 */       x = 0;
/* 427:438 */       int num_partes = partesCuerpoUsuario.size();
/* 428:440 */       while (x < num_partes)
/* 429:    */       {
/* 430:441 */         PartesCuerpoUsuario parteCuerpoUsuario = (PartesCuerpoUsuario)partesCuerpoUsuario.get(x);
/* 431:442 */         parteCuerpoUsuario.setPcueu_comentario(request.getParameter("partes[" + x + "].pcueu_comentario"));
/* 432:443 */         parteCuerpoUsuario.setPcueu_usuf_cod(usuarioFamily.getUsuf_cod());
/* 433:444 */         x++;
/* 434:    */       }
/* 435:447 */       x = 0;
/* 436:448 */       while (x < elementosConsumoUsuario.size())
/* 437:    */       {
/* 438:449 */         ElementoConsumoUsuario elementoConsumoUsuario = (ElementoConsumoUsuario)elementosConsumoUsuario.get(x);
/* 439:450 */         elementoConsumoUsuario.setEconu_cons_cod(new BigDecimal(request.getParameter("elemento[" + x + "].econu_cons_cod")));
/* 440:451 */         elementoConsumoUsuario.setEconu_usuf_cod(usuarioFamily.getUsuf_cod());
/* 441:452 */         x++;
/* 442:    */       }
/* 443:455 */       DatosPersonales datosPersonales = (DatosPersonales)request.getSession().getAttribute("datosPersonales");
/* 444:456 */       if (datosPersonales.getDatp_sexo().equals("F"))
/* 445:    */       {
/* 446:457 */         Ginecologia ginecologia = new Ginecologia();
/* 447:458 */         InicializaData.inicializa(ginecologia.getClass(), ginecologia);
/* 448:459 */         BeanUtils.copyProperties(ginecologia, form);
/* 449:460 */         ginecologia.setGine_usuf_cod(usuarioFamily.getUsuf_cod());
/* 450:    */         
/* 451:462 */         historiaMedica.setGinecologia(ginecologia);
/* 452:    */         
/* 453:464 */         x = 0;
/* 454:465 */         List ginecologiaOperacionesUsuario = (List)request.getSession().getAttribute("GINECOLOGIAOPERACIONESUSUARIO");
/* 455:467 */         while (x < ginecologiaOperacionesUsuario.size())
/* 456:    */         {
/* 457:468 */           GinecologiaOperacionesUsuario operacion = (GinecologiaOperacionesUsuario)ginecologiaOperacionesUsuario.get(x);
/* 458:469 */           operacion.setGopeu_cantidad(new BigDecimal(request.getParameter("oper[" + x + "].gopeu_cantidad")));
/* 459:470 */           operacion.setGopeu_fecha(new BigDecimal(request.getParameter("gopeu_fecha" + x)));
/* 460:471 */           operacion.setGopeu_usuf_cod(usuarioFamily.getUsuf_cod());
/* 461:472 */           x++;
/* 462:    */         }
/* 463:475 */         historiaMedica.setGinecologiaOperacionesUsuario(ginecologiaOperacionesUsuario);
/* 464:    */       }
/* 465:478 */       historiaMedicaDAO.update(historiaMedica, usuarioFamily.getUsuf_cod(), datosPersonales.getDatp_sexo());
/* 466:    */     }
/* 467:    */     catch (Exception e)
/* 468:    */     {
/* 469:481 */       e.printStackTrace();
/* 470:482 */       return mapping.findForward("failure");
/* 471:    */     }
/* 472:484 */     return mapping.findForward("success");
/* 473:    */   }
/* 474:    */ }



/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\

 * Qualified Name:     com.servidoctor.sdfamily.controller.HistoriaMedicaAction

 * JD-Core Version:    0.7.0.1

 */