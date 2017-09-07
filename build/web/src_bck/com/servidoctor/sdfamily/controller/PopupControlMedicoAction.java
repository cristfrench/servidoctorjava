/*   1:    */ package com.servidoctor.sdfamily.controller;
/*   2:    */ 
/*   3:    */ import com.essecorp.util.GestorFechasCompleto;
/*   4:    */ import com.servidoctor.constantes.IConstantes;
/*   5:    */ import com.servidoctor.constantes.IGrupos;
/*   6:    */ import com.servidoctor.parametros.dao.CiudadDAO;
/*   7:    */ import com.servidoctor.parametros.dao.ExamenesDAO;
/*   8:    */ import com.servidoctor.parametros.dao.PaisDAO;
/*   9:    */ import com.servidoctor.parametros.model.Examenes;
/*  10:    */ import com.servidoctor.parametros.model.Paises;
/*  11:    */ import com.servidoctor.sdfamily.dao.DatosPersonalesDAO;
/*  12:    */ import com.servidoctor.sdfamily.dao.GruposUsuarioDAO;
/*  13:    */ import com.servidoctor.sdfamily.model.ControlMedico;
/*  14:    */ import com.servidoctor.sdfamily.model.DatosPersonales;
/*  15:    */ import com.servidoctor.sdfamily.model.ExamenesUsuario;
/*  16:    */ import com.servidoctor.sdfamily.model.GruposUsuario;
/*  17:    */ import com.servidoctor.seguridad.model.Servidores;
/*  18:    */ import com.servidoctor.seguridad.model.UsuarioFamily;
/*  19:    */ import com.servidoctor.util.classes.InicializaData;
/*  20:    */ import com.servidoctor.util.classes.ManejoFechas;
/*  21:    */ import java.math.BigDecimal;
/*  22:    */ import java.util.ArrayList;
/*  23:    */ import java.util.Iterator;
/*  24:    */ import java.util.List;
/*  25:    */ import javax.servlet.http.HttpServletRequest;
/*  26:    */ import javax.servlet.http.HttpServletResponse;
/*  27:    */ import javax.servlet.http.HttpSession;
/*  28:    */ import org.apache.commons.beanutils.BeanUtils;
/*  29:    */ import org.apache.struts.action.Action;
/*  30:    */ import org.apache.struts.action.ActionForm;
/*  31:    */ import org.apache.struts.action.ActionForward;
/*  32:    */ import org.apache.struts.action.ActionMapping;
/*  33:    */ 
/*  34:    */ public class PopupControlMedicoAction
/*  35:    */   extends Action
/*  36:    */ {
/*  37:    */   public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  38:    */     throws Exception
/*  39:    */   {
/*  40: 39 */     ActionForward myforward = null;
/*  41: 40 */     String myaction = mapping.getParameter();
/*  42: 42 */     if ("".equalsIgnoreCase(myaction)) {
/*  43: 43 */       myforward = mapping.findForward("failure");
/*  44: 44 */     } else if ("TRANSFER_TABLA".equalsIgnoreCase(myaction)) {
/*  45: 45 */       myforward = performTrasf_tabla(mapping, actionForm, request, response);
/*  46: 46 */     } else if ("EDIT_TABLA".equalsIgnoreCase(myaction)) {
/*  47: 47 */       myforward = performEdit_tabla(mapping, actionForm, request, response);
/*  48: 48 */     } else if ("ADD_TABLA".equalsIgnoreCase(myaction)) {
/*  49: 49 */       myforward = performAdd_tabla(mapping, actionForm, request, response);
/*  50: 50 */     } else if ("REMOVE_TABLA".equalsIgnoreCase(myaction)) {
/*  51: 51 */       myforward = performRemove_tabla(mapping, actionForm, request, response);
/*  52: 52 */     } else if ("TRANSFER_CONTROLU".equalsIgnoreCase(myaction)) {
/*  53: 53 */       myforward = performTrasf_controlu(mapping, actionForm, request, response);
/*  54: 54 */     } else if ("EDIT_CONTROLU".equalsIgnoreCase(myaction)) {
/*  55: 55 */       myforward = performEdit_controlu(mapping, actionForm, request, response);
/*  56: 56 */     } else if ("TRANSFER_CONTROLP".equalsIgnoreCase(myaction)) {
/*  57: 57 */       myforward = performTrasf_controlp(mapping, actionForm, request, response);
/*  58: 58 */     } else if ("EDIT_CONTROLP".equalsIgnoreCase(myaction)) {
/*  59: 59 */       myforward = performEdit_controlp(mapping, actionForm, request, response);
/*  60:    */     } else {
/*  61: 61 */       myforward = mapping.findForward("failure");
/*  62:    */     }
/*  63: 64 */     return myforward;
/*  64:    */   }
/*  65:    */   
/*  66:    */   private ActionForward performTrasf_tabla(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  67:    */   {
/*  68: 68 */     ExamenesUsuarioForm form = (ExamenesUsuarioForm)actionForm;
/*  69:    */     try
/*  70:    */     {
/*  71: 70 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/*  72:    */       
/*  73: 72 */       List examenes = null;
/*  74: 73 */       if (request.getSession().getAttribute("EXAMENES_USUARIO") != null) {
/*  75: 74 */         examenes = (List)request.getSession().getAttribute("EXAMENES_USUARIO");
/*  76:    */       } else {
/*  77: 76 */         examenes = new ArrayList();
/*  78:    */       }
/*  79: 79 */       List controlesAnteriores = null;
/*  80: 80 */       List controlesProximos = null;
/*  81: 81 */       if (request.getSession().getAttribute("CONTROLESANTERIORES") != null) {
/*  82: 82 */         controlesAnteriores = (List)request.getSession().getAttribute("CONTROLESANTERIORES");
/*  83:    */       } else {
/*  84: 84 */         controlesAnteriores = new ArrayList();
/*  85:    */       }
/*  86: 86 */       if (request.getSession().getAttribute("CONTROLESPROXIMOS") != null) {
/*  87: 87 */         controlesProximos = (List)request.getSession().getAttribute("CONTROLESPROXIMOS");
/*  88:    */       } else {
/*  89: 89 */         controlesProximos = new ArrayList();
/*  90:    */       }
/*  91: 92 */       ExamenesUsuario examenUsuario = null;
/*  92: 93 */       ExamenesDAO examenesDAO = new ExamenesDAO();
/*  93: 94 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  94: 95 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  95: 96 */         examenesDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  96:    */       }
/*  97: 98 */       //examenesDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    examenesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  98: 99 */       List tablaUniversal = examenesDAO.list();
/*  99:100 */       Examenes temp = new Examenes();
/* 100:101 */       InicializaData.inicializa(temp.getClass(), temp);
/* 101:103 */       if (request.getParameter("num_tabla") == null)
/* 102:    */       {
/* 103:104 */         examenUsuario = new ExamenesUsuario();
/* 104:105 */         InicializaData.inicializa(examenUsuario.getClass(), examenUsuario);
/* 105:106 */         BeanUtils.copyProperties(examenUsuario, form);
/* 106:107 */         examenes.add(examenUsuario);
/* 107:    */         
/* 108:109 */         ControlMedico control = new ControlMedico();
/* 109:110 */         InicializaData.inicializa(control.getClass(), control);
/* 110:111 */         control.setCmed_usuf_cod(usuarioFamily.getUsuf_cod());
/* 111:112 */         control.setElementoTabla(examenUsuario);
/* 112:113 */         if (!examenUsuario.getExau_exa_cod().equals(IConstantes.CODIGO_NO_EXISTE))
/* 113:    */         {
/* 114:114 */           temp.setExa_cod(examenUsuario.getExau_exa_cod());
/* 115:115 */           control.setCmed_destratamiento(((Examenes)tablaUniversal.get(tablaUniversal.indexOf(temp))).getExa_des());
/* 116:    */         }
/* 117:    */         else
/* 118:    */         {
/* 119:117 */           control.setCmed_destratamiento(examenUsuario.getExau_des());
/* 120:    */         }
/* 121:119 */         control.setCmed_grup_cod(IGrupos.FAMILY_MEDICINA_A);
/* 122:120 */         control.setCmed_tipo(IConstantes.CODIGO_CONTROL_ANTERIOR);
/* 123:121 */         controlesAnteriores.add(control);
/* 124:122 */         control = new ControlMedico();
/* 125:123 */         control.setCmed_usuf_cod(usuarioFamily.getUsuf_cod());
/* 126:124 */         InicializaData.inicializa(control.getClass(), control);
/* 127:125 */         control.setElementoTabla(examenUsuario);
/* 128:126 */         if (!examenUsuario.getExau_exa_cod().equals(IConstantes.CODIGO_NO_EXISTE))
/* 129:    */         {
/* 130:127 */           temp.setExa_cod(examenUsuario.getExau_exa_cod());
/* 131:128 */           control.setCmed_destratamiento(((Examenes)tablaUniversal.get(tablaUniversal.indexOf(temp))).getExa_des());
/* 132:    */         }
/* 133:    */         else
/* 134:    */         {
/* 135:130 */           control.setCmed_destratamiento(examenUsuario.getExau_des());
/* 136:    */         }
/* 137:132 */         control.setCmed_grup_cod(IGrupos.FAMILY_MEDICINA_A);
/* 138:133 */         control.setCmed_tipo(IConstantes.CODIGO_CONTROL_PROXIMO);
/* 139:134 */         controlesProximos.add(control);
/* 140:    */       }
/* 141:    */       else
/* 142:    */       {
/* 143:143 */         examenUsuario = new ExamenesUsuario();
/* 144:144 */         InicializaData.inicializa(examenUsuario.getClass(), examenUsuario);
/* 145:145 */         BeanUtils.copyProperties(examenUsuario, form);
/* 146:146 */         examenes.set(Integer.parseInt(request.getParameter("num_tabla")), examenUsuario);
/* 147:    */         
/* 148:148 */         ControlMedico control = (ControlMedico)controlesAnteriores.get(Integer.parseInt(request.getParameter("num_tabla")));
/* 149:149 */         control.setCmed_usuf_cod(usuarioFamily.getUsuf_cod());
/* 150:150 */         control.setElementoTabla(examenUsuario);
/* 151:151 */         if (!examenUsuario.getExau_exa_cod().equals(IConstantes.CODIGO_NO_EXISTE))
/* 152:    */         {
/* 153:152 */           temp.setExa_cod(examenUsuario.getExau_exa_cod());
/* 154:153 */           control.setCmed_destratamiento(((Examenes)tablaUniversal.get(tablaUniversal.indexOf(temp))).getExa_des());
/* 155:    */         }
/* 156:    */         else
/* 157:    */         {
/* 158:155 */           control.setCmed_destratamiento(examenUsuario.getExau_des());
/* 159:    */         }
/* 160:157 */         control.setCmed_grup_cod(IGrupos.FAMILY_MEDICINA_A);
/* 161:158 */         control.setCmed_tipo(IConstantes.CODIGO_CONTROL_ANTERIOR);
/* 162:159 */         controlesAnteriores.set(Integer.parseInt(request.getParameter("num_tabla")), control);
/* 163:160 */         control = (ControlMedico)controlesProximos.get(Integer.parseInt(request.getParameter("num_tabla")));
/* 164:161 */         control.setCmed_usuf_cod(usuarioFamily.getUsuf_cod());
/* 165:162 */         control.setElementoTabla(examenUsuario);
/* 166:163 */         if (!examenUsuario.getExau_exa_cod().equals(IConstantes.CODIGO_NO_EXISTE))
/* 167:    */         {
/* 168:164 */           temp.setExa_cod(examenUsuario.getExau_exa_cod());
/* 169:165 */           control.setCmed_destratamiento(((Examenes)tablaUniversal.get(tablaUniversal.indexOf(temp))).getExa_des());
/* 170:    */         }
/* 171:    */         else
/* 172:    */         {
/* 173:167 */           control.setCmed_destratamiento(examenUsuario.getExau_des());
/* 174:    */         }
/* 175:169 */         control.setCmed_grup_cod(IGrupos.FAMILY_MEDICINA_A);
/* 176:170 */         control.setCmed_tipo(IConstantes.CODIGO_CONTROL_PROXIMO);
/* 177:171 */         controlesProximos.set(Integer.parseInt(request.getParameter("num_tabla")), control);
/* 178:    */       }
/* 179:174 */       request.getSession().setAttribute("EXAMENES_USUARIO", examenes);
/* 180:175 */       request.getSession().setAttribute("CONTROLESANTERIORES", controlesAnteriores);
/* 181:176 */       request.getSession().setAttribute("CONTROLESPROXIMOS", controlesProximos);
/* 182:    */     }
/* 183:    */     catch (Exception e)
/* 184:    */     {
/* 185:179 */       return mapping.findForward("failure");
/* 186:    */     }
/* 187:182 */     return mapping.findForward("success");
/* 188:    */   }
/* 189:    */   
/* 190:    */   private ActionForward performEdit_tabla(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 191:    */   {
/* 192:186 */     ExamenesUsuarioForm form = (ExamenesUsuarioForm)actionForm;
/* 193:    */     try
/* 194:    */     {
/* 195:189 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/* 196:    */       
/* 197:191 */       DatosPersonalesDAO datosPersonalesDAO = new DatosPersonalesDAO();
/* 198:192 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 199:193 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 200:194 */         datosPersonalesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 201:    */       }
/* 202:196 */       DatosPersonales datosPersonales = datosPersonalesDAO.retrive(usuarioFamily.getUsuf_cod());
/* 203:    */       
/* 204:198 */       List examenes = (List)request.getSession().getAttribute("EXAMENES_USUARIO");
/* 205:199 */       ExamenesUsuario examenUsuario = (ExamenesUsuario)examenes.get(Integer.parseInt(request.getParameter("num_tabla")));
/* 206:200 */       BeanUtils.copyProperties(form, examenUsuario);
/* 207:    */       
/* 208:202 */       ExamenesDAO examenesDAO = new ExamenesDAO();
/* 209:203 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 210:204 */         examenesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 211:    */       }
/* 212:206 */       //examenesDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    examenesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
                    
/* 213:207 */       List listExamenes = examenesDAO.list(datosPersonales.getDatp_sexo());
/* 214:    */       
/* 215:209 */       Examenes examenTemp = new Examenes();
/* 216:210 */       for (Iterator iter = examenes.iterator(); iter.hasNext();)
/* 217:    */       {
/* 218:211 */         ExamenesUsuario examenUsu = (ExamenesUsuario)iter.next();
/* 219:212 */         if (!examenUsu.equals(examenUsuario))
/* 220:    */         {
/* 221:213 */           examenTemp.setExa_cod(examenUsu.getExau_exa_cod());
/* 222:214 */           listExamenes.remove(examenTemp);
/* 223:    */         }
/* 224:    */       }
/* 225:218 */       request.setAttribute("LISTAUNIVERSAL", listExamenes);
/* 226:    */     }
/* 227:    */     catch (Exception e)
/* 228:    */     {
/* 229:222 */       return mapping.findForward("failure");
/* 230:    */     }
/* 231:224 */     return mapping.findForward("success");
/* 232:    */   }
/* 233:    */   
/* 234:    */   private ActionForward performAdd_tabla(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 235:    */   {
/* 236:227 */     ExamenesUsuarioForm form = (ExamenesUsuarioForm)actionForm;
/* 237:    */     try
/* 238:    */     {
/* 239:230 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/* 240:    */       
/* 241:232 */       DatosPersonalesDAO datosPersonalesDAO = new DatosPersonalesDAO();
/* 242:233 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 243:234 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 244:235 */         datosPersonalesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 245:    */       }
/* 246:237 */       DatosPersonales datosPersonales = datosPersonalesDAO.retrive(usuarioFamily.getUsuf_cod());
/* 247:    */       
/* 248:239 */       ExamenesDAO examenesDAO = new ExamenesDAO();
/* 249:240 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 250:241 */         examenesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 251:    */       }
/* 252:243 */       //examenesDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    examenesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
                    
/* 253:244 */       List listExamenes = examenesDAO.list(datosPersonales.getDatp_sexo());
/* 254:    */       
/* 255:246 */       List examenes = (List)request.getSession().getAttribute("EXAMENES_USUARIO");
/* 256:247 */       if (examenes == null) {
/* 257:248 */         examenes = new ArrayList();
/* 258:    */       }
/* 259:250 */       Examenes examenTemp = new Examenes();
/* 260:251 */       for (Iterator iter = examenes.iterator(); iter.hasNext();)
/* 261:    */       {
/* 262:252 */         ExamenesUsuario examenUsu = (ExamenesUsuario)iter.next();
/* 263:253 */         examenTemp.setExa_cod(examenUsu.getExau_exa_cod());
/* 264:254 */         listExamenes.remove(examenTemp);
/* 265:    */       }
/* 266:257 */       request.setAttribute("LISTAUNIVERSAL", listExamenes);
/* 267:    */     }
/* 268:    */     catch (Exception e)
/* 269:    */     {
/* 270:260 */       return mapping.findForward("failure");
/* 271:    */     }
/* 272:262 */     return mapping.findForward("success");
/* 273:    */   }
/* 274:    */   
/* 275:    */   private ActionForward performRemove_tabla(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 276:    */   {
/* 277:265 */     ExamenesUsuarioForm form = (ExamenesUsuarioForm)actionForm;
/* 278:    */     try
/* 279:    */     {
/* 280:269 */       List examenes = (List)request.getSession().getAttribute("EXAMENES_USUARIO");
/* 281:270 */       List controlesAnteriores = (List)request.getSession().getAttribute("CONTROLESANTERIORES");
/* 282:271 */       List controlesProximos = (List)request.getSession().getAttribute("CONTROLESPROXIMOS");
/* 283:    */       
/* 284:273 */       int x = 0;
/* 285:274 */       while (x < controlesAnteriores.size())
/* 286:    */       {
/* 287:275 */         ControlMedico control = (ControlMedico)controlesAnteriores.get(x);
/* 288:276 */         if (control.getElementoTabla().equals((ExamenesUsuario)examenes.get(Integer.parseInt(request.getParameter("num_tabla"))))) {
/* 289:277 */           controlesAnteriores.remove(x);
/* 290:    */         }
/* 291:279 */         control = (ControlMedico)controlesProximos.get(x);
/* 292:280 */         if (control.getElementoTabla().equals((ExamenesUsuario)examenes.get(Integer.parseInt(request.getParameter("num_tabla"))))) {
/* 293:281 */           controlesProximos.remove(x);
/* 294:    */         }
/* 295:283 */         x++;
/* 296:    */       }
/* 297:286 */       examenes.remove(Integer.parseInt(request.getParameter("num_tabla")));
/* 298:    */       
/* 299:288 */       x = 0;
/* 300:289 */       while (x < examenes.size())
/* 301:    */       {
/* 302:290 */         ExamenesUsuario examenUsuario = (ExamenesUsuario)examenes.get(x);
/* 303:291 */         examenUsuario.setExau_cod(new BigDecimal(x + 1));
/* 304:292 */         examenes.set(x, examenUsuario);
/* 305:293 */         x++;
/* 306:    */       }
/* 307:    */     }
/* 308:    */     catch (Exception e)
/* 309:    */     {
/* 310:297 */       return mapping.findForward("failure");
/* 311:    */     }
/* 312:299 */     return mapping.findForward("success");
/* 313:    */   }
/* 314:    */   
/* 315:    */   private ActionForward performTrasf_controlu(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 316:    */   {
/* 317:302 */     ControlMedicoForm form = (ControlMedicoForm)actionForm;
/* 318:    */     try
/* 319:    */     {
/* 320:304 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/* 321:306 */       if (form.getCmed_indpais().length() == 0) {
/* 322:307 */         form.setCmed_indpais("0");
/* 323:    */       }
/* 324:308 */       if (form.getCmed_indciudad().length() == 0) {
/* 325:309 */         form.setCmed_indciudad("0");
/* 326:    */       }
/* 327:312 */       List controles = null;
/* 328:313 */       if (request.getSession().getAttribute("CONTROLESANTERIORES") != null) {
/* 329:314 */         controles = (List)request.getSession().getAttribute("CONTROLESANTERIORES");
/* 330:    */       }
/* 331:317 */       ControlMedico control = null;
/* 332:319 */       if (request.getParameter("num_controlu") != null)
/* 333:    */       {
/* 334:322 */         control = (ControlMedico)controles.get(Integer.parseInt(request.getParameter("num_controlu")));
/* 335:323 */         form.setCmed_feccontrol(ManejoFechas.getChangeFecha(form.getCmed_feccontrol()));
/* 336:324 */         form.setCmed_cod(control.getCmed_cod().toString());
/* 337:325 */         form.setCmed_grup_cod(control.getCmed_grup_cod().toString());
/* 338:326 */         form.setCmed_mails_enviados(control.getCmed_mails_enviados().toString());
/* 339:327 */         form.setCmed_ultimo_mail(control.getCmed_ultimo_mail().toString());
/* 340:328 */         form.setCmed_usuf_cod(usuarioFamily.getUsuf_cod().toString());
/* 341:329 */         form.setCmed_tipo(IConstantes.CODIGO_CONTROL_ANTERIOR.toString());
/* 342:330 */         form.setCmed_exa_cod(control.getCmed_exa_cod().toString());
/* 343:    */         
/* 344:    */ 
/* 345:    */ 
/* 346:    */ 
/* 347:335 */         List controlesUC = (List)request.getSession().getAttribute("CONTROLESANTERIORES");
/* 348:336 */         ControlMedico controlMedicoUC = (ControlMedico)controlesUC.get(Integer.parseInt(request.getParameter("num_controlu")));
/* 349:    */         
/* 350:338 */         GruposUsuarioDAO gruposUsuarioDAO = new GruposUsuarioDAO();
/* 351:339 */         GruposUsuario gruposUsuario = gruposUsuarioDAO.retrieveDays(new BigDecimal(form.getCmed_usuf_cod()), control.getCmed_grup_cod());
/* 352:340 */         int diasAntesn = gruposUsuario.getGrupu_dias_antes().intValue();
/* 353:341 */         int diasAntesn2 = gruposUsuario.getGrupu_dias_antes().intValue() / 2;
/* 354:343 */         if (controlMedicoUC.getCmed_feccontrol().toString().compareTo("0") != 0)
/* 355:    */         {
/* 356:345 */           String controlUltimo = form.getCmed_feccontrol().toString();
/* 357:346 */           String fechaActual = ManejoFechas.getFechaActual();
/* 358:347 */           List cmedicos = (List)request.getSession().getAttribute("EXAMENES_USUARIO");
/* 359:348 */           ExamenesUsuario examenesUsuario = (ExamenesUsuario)cmedicos.get(Integer.parseInt(request.getParameter("num_controlu")));
/* 360:    */           
/* 361:350 */           int frecuencia = examenesUsuario.getExau_frecuencia().intValue();
/* 362:351 */           while (controlUltimo.compareTo(fechaActual) < 1) {
/* 363:352 */             controlUltimo = GestorFechasCompleto.fechaMasMeses(controlUltimo, "yyyyMMdd", frecuencia);
/* 364:    */           }
/* 365:354 */           controlMedicoUC.setCmed_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlUltimo), "yyyyMMdd", -2)));
/* 366:355 */           controlMedicoUC.setCmed_fecenvion(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlUltimo), "yyyyMMdd", -diasAntesn)));
/* 367:356 */           controlMedicoUC.setCmed_fecenvion2(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlUltimo), "yyyyMMdd", -diasAntesn2)));
/* 368:357 */           controlMedicoUC.setCmed_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlUltimo), "yyyyMMdd", 16)));
/* 369:358 */           form.setCmed_fecenvio2(controlMedicoUC.getCmed_fecenvio2().toString());
/* 370:359 */           form.setCmed_fecenvion(controlMedicoUC.getCmed_fecenvion().toString());
/* 371:360 */           form.setCmed_fecenvion2(controlMedicoUC.getCmed_fecenvion2().toString());
/* 372:361 */           form.setCmed_quince_dias(controlMedicoUC.getCmed_quince_dias().toString());
/* 373:362 */           controlesUC.set(Integer.parseInt(request.getParameter("num_controlu")), controlMedicoUC);
/* 374:363 */           request.getSession().setAttribute("CONTROLESANTERIORES", controlesUC);
/* 375:    */         }
/* 376:368 */         BeanUtils.copyProperties(control, form);
/* 377:    */       }
/* 378:    */     }
/* 379:    */     catch (Exception e)
/* 380:    */     {
/* 381:372 */       return mapping.findForward("failure");
/* 382:    */     }
/* 383:375 */     return mapping.findForward("success");
/* 384:    */   }
/* 385:    */   
/* 386:    */   private ActionForward performEdit_controlu(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 387:    */   {
/* 388:379 */     ControlMedicoForm form = (ControlMedicoForm)actionForm;
/* 389:    */     try
/* 390:    */     {
/* 391:382 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 392:383 */       ExamenesDAO examenesDAO = new ExamenesDAO();
/* 393:384 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 394:385 */         examenesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 395:    */       }
/* 396:387 */       //examenesDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    examenesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 397:    */       
/* 398:389 */       List controles = new ArrayList();
/* 399:390 */       ControlMedico controlMedico = new ControlMedico();
/* 400:391 */       controles = (List)request.getSession().getAttribute("CONTROLESANTERIORES");
/* 401:392 */       controlMedico = (ControlMedico)controles.get(Integer.parseInt(request.getParameter("num_controlu")));
/* 402:    */       
/* 403:394 */       BeanUtils.copyProperties(form, controlMedico);
/* 404:395 */       if (!controlMedico.getCmed_exa_cod().equals(IConstantes.CODIGO_NO_EXISTE)) {
/* 405:396 */         form.setCmed_destratamiento(examenesDAO.retrive(controlMedico.getCmed_exa_cod()).getExa_des());
/* 406:    */       }
/* 407:398 */       form.setCmed_feccontrol(ManejoFechas.FormateoFecha(form.getCmed_feccontrol()));
/* 408:    */       
/* 409:400 */       PaisDAO paisDAO = new PaisDAO();
/* 410:401 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 411:402 */         paisDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 412:    */       }
/* 413:404 */       //paisDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    paisDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
                    
/* 414:405 */       List paises = paisDAO.list();
/* 415:406 */       request.setAttribute("PAISES", paises);
/* 416:    */       
/* 417:408 */       List ciudades = null;
/* 418:409 */       CiudadDAO ciudadesDAO = new CiudadDAO();
/* 419:410 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 420:411 */         ciudadesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 421:    */       }
/* 422:413 */       //ciudadesDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    ciudadesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 423:414 */       if ((paises.size() > 0) && (!form.getCmed_pais_cod().equals("0"))) {
/* 424:415 */         ciudades = ciudadesDAO.search(form.getCmed_pais_cod());
/* 425:416 */       } else if (paises.size() > 0) {
/* 426:417 */         ciudades = ciudadesDAO.search(((Paises)paises.get(0)).getPais_cod().toString());
/* 427:    */       }
/* 428:419 */       request.setAttribute("CIUDADES", ciudades);
/* 429:    */     }
/* 430:    */     catch (Exception e)
/* 431:    */     {
/* 432:423 */       return mapping.findForward("failure");
/* 433:    */     }
/* 434:425 */     return mapping.findForward("success");
/* 435:    */   }
/* 436:    */   
/* 437:    */   private ActionForward performTrasf_controlp(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 438:    */   {
/* 439:428 */     ControlMedicoForm form = (ControlMedicoForm)actionForm;
/* 440:    */     try
/* 441:    */     {
/* 442:430 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/* 443:    */       
/* 444:432 */       List controles = null;
/* 445:433 */       if (request.getSession().getAttribute("CONTROLESPROXIMOS") != null) {
/* 446:434 */         controles = (List)request.getSession().getAttribute("CONTROLESPROXIMOS");
/* 447:    */       }
/* 448:437 */       ControlMedico control = null;
/* 449:439 */       if (request.getParameter("num_controlp") != null)
/* 450:    */       {
/* 451:442 */         control = (ControlMedico)controles.get(Integer.parseInt(request.getParameter("num_controlp")));
/* 452:443 */         form.setCmed_feccontrol(ManejoFechas.getChangeFecha(form.getCmed_feccontrol()));
/* 453:444 */         form.setCmed_hora(ManejoFechas.getChangeHoraAMPM(form.getCmed_hora()));
/* 454:445 */         form.setCmed_cod(control.getCmed_cod().toString());
/* 455:446 */         form.setCmed_grup_cod(control.getCmed_grup_cod().toString());
/* 456:447 */         form.setCmed_mails_enviados(control.getCmed_mails_enviados().toString());
/* 457:448 */         form.setCmed_ultimo_mail(control.getCmed_ultimo_mail().toString());
/* 458:449 */         form.setCmed_usuf_cod(usuarioFamily.getUsuf_cod().toString());
/* 459:450 */         form.setCmed_tipo(IConstantes.CODIGO_CONTROL_PROXIMO.toString());
/* 460:451 */         form.setCmed_exa_cod(control.getCmed_exa_cod().toString());
/* 461:    */         
/* 462:    */ 
/* 463:454 */         GruposUsuarioDAO gruposUsuarioDAO = new GruposUsuarioDAO();
/* 464:455 */         GruposUsuario gruposUsuario = gruposUsuarioDAO.retrieveDays(new BigDecimal(form.getCmed_usuf_cod()), control.getCmed_grup_cod());
/* 465:    */         
/* 466:457 */         int diasAntesn = gruposUsuario.getGrupu_dias_antes().intValue();
/* 467:458 */         int diasAntesn2 = gruposUsuario.getGrupu_dias_antes().intValue() / 2;
/* 468:459 */         form.setCmed_fecenvio2(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(form.getCmed_feccontrol()), "yyyyMMdd", -2));
/* 469:460 */         form.setCmed_fecenvion(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(form.getCmed_feccontrol()), "yyyyMMdd", -diasAntesn));
/* 470:461 */         form.setCmed_fecenvion2(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(form.getCmed_feccontrol()), "yyyyMMdd", -diasAntesn2));
/* 471:462 */         form.setCmed_quince_dias(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(form.getCmed_feccontrol()), "yyyyMMdd", 15));
/* 472:463 */         control.setCmed_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(form.getCmed_feccontrol()), "yyyyMMdd", -2)));
/* 473:464 */         control.setCmed_fecenvion(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(form.getCmed_feccontrol()), "yyyyMMdd", -diasAntesn)));
/* 474:465 */         control.setCmed_fecenvion2(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(form.getCmed_feccontrol()), "yyyyMMdd", -diasAntesn2)));
/* 475:466 */         control.setCmed_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(form.getCmed_feccontrol()), "yyyyMMdd", 15)));
/* 476:    */         
/* 477:468 */         controles.set(Integer.parseInt(request.getParameter("num_controlp")), control);
/* 478:469 */         request.getSession().setAttribute("CONTROLESPROXIMOS", controles);
/* 479:    */         
/* 480:    */ 
/* 481:472 */         BeanUtils.copyProperties(control, form);
/* 482:    */       }
/* 483:    */     }
/* 484:    */     catch (Exception e)
/* 485:    */     {
/* 486:476 */       return mapping.findForward("failure");
/* 487:    */     }
/* 488:479 */     return mapping.findForward("success");
/* 489:    */   }
/* 490:    */   
/* 491:    */   private ActionForward performEdit_controlp(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 492:    */   {
/* 493:483 */     ControlMedicoForm form = (ControlMedicoForm)actionForm;
/* 494:    */     try
/* 495:    */     {
/* 496:486 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 497:487 */       ExamenesDAO examenesDAO = new ExamenesDAO();
/* 498:488 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 499:489 */         examenesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 500:    */       }
/* 501:491 */       //examenesDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
/* 502:    */       examenesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 503:493 */       List controles = (List)request.getSession().getAttribute("CONTROLESPROXIMOS");
/* 504:494 */       ControlMedico controlMedico = (ControlMedico)controles.get(Integer.parseInt(request.getParameter("num_controlp")));
/* 505:496 */       if (form.getCmed_indpais().length() == 0) {
/* 506:497 */         form.setCmed_indpais("0");
/* 507:    */       }
/* 508:498 */       if (form.getCmed_indciudad().length() == 0) {
/* 509:499 */         form.setCmed_indciudad("0");
/* 510:    */       }
/* 511:502 */       BeanUtils.copyProperties(form, controlMedico);
/* 512:503 */       if (!controlMedico.getCmed_exa_cod().equals(IConstantes.CODIGO_NO_EXISTE)) {
/* 513:504 */         form.setCmed_destratamiento(examenesDAO.retrive(controlMedico.getCmed_exa_cod()).getExa_des());
/* 514:    */       }
/* 515:506 */       form.setCmed_feccontrol(ManejoFechas.FormateoFecha(form.getCmed_feccontrol()));
/* 516:507 */       form.setCmed_hora(ManejoFechas.FormateoHoraAMPM(form.getCmed_hora()));
/* 517:    */       
/* 518:509 */       PaisDAO paisDAO = new PaisDAO();
/* 519:510 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 520:511 */         paisDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 521:    */       }
/* 522:513 */       //paisDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    paisDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
                    
/* 523:514 */       List paises = paisDAO.list();
/* 524:515 */       request.setAttribute("PAISES", paises);
/* 525:    */       
/* 526:517 */       List ciudades = null;
/* 527:518 */       CiudadDAO ciudadesDAO = new CiudadDAO();
/* 528:519 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 529:520 */         ciudadesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 530:    */       }
/* 531:522 */       //ciudadesDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    ciudadesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
                    
/* 532:523 */       if ((paises.size() > 0) && (!form.getCmed_pais_cod().equals("0"))) {
/* 533:524 */         ciudades = ciudadesDAO.search(form.getCmed_pais_cod());
/* 534:525 */       } else if (paises.size() > 0) {
/* 535:526 */         ciudades = ciudadesDAO.search(((Paises)paises.get(0)).getPais_cod().toString());
/* 536:    */       }
/* 537:528 */       request.setAttribute("CIUDADES", ciudades);
/* 538:    */     }
/* 539:    */     catch (Exception e)
/* 540:    */     {
/* 541:531 */       return mapping.findForward("failure");
/* 542:    */     }
/* 543:533 */     return mapping.findForward("success");
/* 544:    */   }
/* 545:    */ }



/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\

 * Qualified Name:     com.servidoctor.sdfamily.controller.PopupControlMedicoAction

 * JD-Core Version:    0.7.0.1

 */