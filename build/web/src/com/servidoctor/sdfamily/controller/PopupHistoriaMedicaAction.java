/*   1:    */ package com.servidoctor.sdfamily.controller;
/*   2:    */ 
/*   3:    */ import com.servidoctor.constantes.IConstantes;
/*   4:    */ import com.servidoctor.parametros.dao.AlergiasDAO;
/*   5:    */ import com.servidoctor.parametros.dao.AntecedentesDAO;
/*   6:    */ import com.servidoctor.parametros.dao.CirujiasDAO;
/*   7:    */ import com.servidoctor.parametros.dao.EnfermedadesDAO;
/*   8:    */ import com.servidoctor.parametros.dao.FormaDAO;
/*   9:    */ import com.servidoctor.parametros.dao.MedidaDAO;
/*  10:    */ import com.servidoctor.parametros.dao.PeriodoDAO;
/*  11:    */ import com.servidoctor.parametros.dao.SistemasDAO;
/*  12:    */ import com.servidoctor.parametros.dao.ViaAdministracionDAO;
/*  13:    */ import com.servidoctor.parametros.model.Alergias;
/*  14:    */ import com.servidoctor.parametros.model.Antecedentes;
/*  15:    */ import com.servidoctor.parametros.model.Cirujias;
/*  16:    */ import com.servidoctor.parametros.model.Enfermedades;
/*  17:    */ import com.servidoctor.parametros.model.Sistemas;
/*  18:    */ import com.servidoctor.sdfamily.model.AlergiasUsuario;
/*  19:    */ import com.servidoctor.sdfamily.model.AntecedentesUsuario;
/*  20:    */ import com.servidoctor.sdfamily.model.CirujiasUsuario;
/*  21:    */ import com.servidoctor.sdfamily.model.EnfermedadesUsuario;
/*  22:    */ import com.servidoctor.sdfamily.model.UsuarioMedicamentos;
/*  23:    */ import com.servidoctor.seguridad.model.Servidores;
/*  24:    */ import com.servidoctor.seguridad.model.UsuarioFamily;
/*  25:    */ import com.servidoctor.util.classes.InicializaData;
/*  26:    */ import com.servidoctor.util.classes.ManejoFechas;
/*  27:    */ import java.math.BigDecimal;
/*  28:    */ import java.util.ArrayList;
/*  29:    */ import java.util.Iterator;
/*  30:    */ import java.util.List;
/*  31:    */ import javax.servlet.http.HttpServletRequest;
/*  32:    */ import javax.servlet.http.HttpServletResponse;
/*  33:    */ import javax.servlet.http.HttpSession;
/*  34:    */ import org.apache.commons.beanutils.BeanUtils;
/*  35:    */ import org.apache.struts.action.Action;
/*  36:    */ import org.apache.struts.action.ActionForm;
/*  37:    */ import org.apache.struts.action.ActionForward;
/*  38:    */ import org.apache.struts.action.ActionMapping;
/*  39:    */ 
/*  40:    */ public class PopupHistoriaMedicaAction
/*  41:    */   extends Action
/*  42:    */ {
/*  43:    */   public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  44:    */     throws Exception
/*  45:    */   {
/*  46: 52 */     ActionForward myforward = null;
/*  47: 53 */     String myaction = mapping.getParameter();
/*  48: 55 */     if ("".equalsIgnoreCase(myaction)) {
/*  49: 56 */       myforward = mapping.findForward("failure");
/*  50: 57 */     } else if ("EDIT_ENF".equalsIgnoreCase(myaction)) {
/*  51: 58 */       myforward = performEdit_enf(mapping, actionForm, request, response);
/*  52: 59 */     } else if ("ADD_ENF".equalsIgnoreCase(myaction)) {
/*  53: 60 */       myforward = performAdd_enf(mapping, actionForm, request, response);
/*  54: 61 */     } else if ("REMOVE_ENF".equalsIgnoreCase(myaction)) {
/*  55: 62 */       myforward = performRemove_enf(mapping, actionForm, request, response);
/*  56: 63 */     } else if ("TRANSFER_ENF".equalsIgnoreCase(myaction)) {
/*  57: 64 */       myforward = performTransfer_enf(mapping, actionForm, request, response);
/*  58: 65 */     } else if ("EDIT_ALERGIA".equalsIgnoreCase(myaction)) {
/*  59: 66 */       myforward = performEdit_alergia(mapping, actionForm, request, response);
/*  60: 67 */     } else if ("ADD_ALERGIA".equalsIgnoreCase(myaction)) {
/*  61: 68 */       myforward = performAdd_alergia(mapping, actionForm, request, response);
/*  62: 69 */     } else if ("REMOVE_ALERGIA".equalsIgnoreCase(myaction)) {
/*  63: 70 */       myforward = performRemove_alergia(mapping, actionForm, request, response);
/*  64: 71 */     } else if ("TRANSFER_ALERGIA".equalsIgnoreCase(myaction)) {
/*  65: 72 */       myforward = performTransfer_alergia(mapping, actionForm, request, response);
/*  66: 73 */     } else if ("EDIT_CIR".equalsIgnoreCase(myaction)) {
/*  67: 74 */       myforward = performEdit_cir(mapping, actionForm, request, response);
/*  68: 75 */     } else if ("ADD_CIR".equalsIgnoreCase(myaction)) {
/*  69: 76 */       myforward = performAdd_cir(mapping, actionForm, request, response);
/*  70: 77 */     } else if ("REMOVE_CIR".equalsIgnoreCase(myaction)) {
/*  71: 78 */       myforward = performRemove_cir(mapping, actionForm, request, response);
/*  72: 79 */     } else if ("TRANSFER_CIR".equalsIgnoreCase(myaction)) {
/*  73: 80 */       myforward = performTransfer_cir(mapping, actionForm, request, response);
/*  74: 81 */     } else if ("EDIT_MED".equalsIgnoreCase(myaction)) {
/*  75: 82 */       myforward = performEdit_med(mapping, actionForm, request, response);
/*  76: 83 */     } else if ("ADD_MED".equalsIgnoreCase(myaction)) {
/*  77: 84 */       myforward = performAdd_med(mapping, actionForm, request, response);
/*  78: 85 */     } else if ("REMOVE_MED".equalsIgnoreCase(myaction)) {
/*  79: 86 */       myforward = performRemove_med(mapping, actionForm, request, response);
/*  80: 87 */     } else if ("TRANSFER_MED".equalsIgnoreCase(myaction)) {
/*  81: 88 */       myforward = performTransfer_med(mapping, actionForm, request, response);
/*  82: 89 */     } else if ("ADD_ANTE".equalsIgnoreCase(myaction)) {
/*  83: 90 */       myforward = performAdd_ante(mapping, actionForm, request, response);
/*  84: 91 */     } else if ("TRANSFER_ANTE".equalsIgnoreCase(myaction)) {
/*  85: 92 */       myforward = performTransfer_ante(mapping, actionForm, request, response);
/*  86:    */     } else {
/*  87: 94 */       myforward = mapping.findForward("failure");
/*  88:    */     }
/*  89: 97 */     return myforward;
/*  90:    */   }
/*  91:    */   
/*  92:    */   private ActionForward performEdit_enf(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  93:    */   {
/*  94:101 */     UsuarioEnfermedadesForm form = (UsuarioEnfermedadesForm)actionForm;
/*  95:    */     try
/*  96:    */     {
/*  97:104 */       List enfermedades = (List)request.getSession().getAttribute("ENFERMEDADESUSUARIO");
/*  98:105 */       EnfermedadesUsuario enfermedad = new EnfermedadesUsuario();
/*  99:106 */       enfermedad = (EnfermedadesUsuario)enfermedades.get(Integer.parseInt(request.getParameter("num_enf")));
/* 100:108 */       if (request.getParameter("change") == null) {
/* 101:109 */         BeanUtils.copyProperties(form, enfermedad);
/* 102:    */       }
/* 103:112 */       SistemasDAO sistemasDAO = new SistemasDAO();
/* 104:113 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 105:114 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 106:115 */         sistemasDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 107:    */       }
/* 108:117 */       //sistemasDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    sistemasDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 109:118 */       List listSistemas = sistemasDAO.list();
/* 110:119 */       request.setAttribute("LISTSISTEMAS", listSistemas);
/* 111:    */       
/* 112:121 */       List listEnfermedades = null;
/* 113:122 */       EnfermedadesDAO enfermedadesDAO = new EnfermedadesDAO();
/* 114:123 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 115:124 */         enfermedadesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 116:    */       }
/* 117:126 */       //enfermedadesDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    enfermedadesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 118:127 */       if (listSistemas.size() > 0)
/* 119:    */       {
/* 120:128 */         if ((!form.getEnfu_sis_cod().equals("")) && (!form.getEnfu_sis_cod().equals("0"))) {
/* 121:129 */           listEnfermedades = enfermedadesDAO.search(new BigDecimal(form.getEnfu_sis_cod()));
/* 122:    */         } else {
/* 123:131 */           listEnfermedades = enfermedadesDAO.search(((Sistemas)listSistemas.get(0)).getSis_cod());
/* 124:    */         }
/* 125:133 */         if (form.getEnfu_sis_cod().equals(IConstantes.CODIGO_NO_EXISTE.toString())) {
/* 126:134 */           listEnfermedades = enfermedadesDAO.list();
/* 127:    */         }
/* 128:    */       }
/* 129:137 */       Enfermedades enfermedadTemp = new Enfermedades();
/* 130:138 */       for (Iterator iter = enfermedades.iterator(); iter.hasNext();)
/* 131:    */       {
/* 132:139 */         EnfermedadesUsuario enfermedadesUsuario = (EnfermedadesUsuario)iter.next();
/* 133:140 */         if (!enfermedadesUsuario.equals(enfermedad))
/* 134:    */         {
/* 135:141 */           enfermedadTemp.setEnf_cod(enfermedadesUsuario.getEnfu_enf_cod());
/* 136:142 */           listEnfermedades.remove(enfermedadTemp);
/* 137:    */         }
/* 138:    */       }
/* 139:146 */       request.setAttribute("LISTENFERMEDADES", listEnfermedades);
/* 140:    */     }
/* 141:    */     catch (Exception e)
/* 142:    */     {
                    e.printStackTrace();
/* 143:151 */       return mapping.findForward("failure");
/* 144:    */     }
/* 145:153 */     return mapping.findForward("success");
/* 146:    */   }
/* 147:    */   
/* 148:    */   private ActionForward performAdd_enf(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 149:    */   {
/* 150:157 */     UsuarioEnfermedadesForm form = (UsuarioEnfermedadesForm)actionForm;
/* 151:    */     try
/* 152:    */     {
/* 153:160 */       List listSistemas = new ArrayList();
/* 154:161 */       SistemasDAO sistemasDAO = new SistemasDAO();
/* 155:162 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 156:163 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 157:164 */         sistemasDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 158:    */       }
/* 159:166 */       //sistemasDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    sistemasDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 160:167 */       listSistemas = sistemasDAO.list();
/* 161:168 */       request.setAttribute("LISTSISTEMAS", listSistemas);
/* 162:    */       
/* 163:170 */       List listEnfermedades = new ArrayList();
/* 164:171 */       EnfermedadesDAO enfermedadesDAO = new EnfermedadesDAO();
/* 165:172 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 166:173 */         enfermedadesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 167:    */       }
/* 168:175 */       //enfermedadesDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    enfermedadesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 169:176 */       if (listSistemas.size() > 0)
/* 170:    */       {
/* 171:177 */         if ((!form.getEnfu_sis_cod().equals("")) && (!form.getEnfu_sis_cod().equals("0"))) {
/* 172:178 */           listEnfermedades = enfermedadesDAO.search(new BigDecimal(form.getEnfu_sis_cod()));
/* 173:    */         } else {
/* 174:180 */           listEnfermedades = enfermedadesDAO.search(((Sistemas)listSistemas.get(0)).getSis_cod());
/* 175:    */         }
/* 176:182 */         if (form.getEnfu_sis_cod().equals(IConstantes.CODIGO_NO_EXISTE.toString())) {
/* 177:183 */           listEnfermedades = enfermedadesDAO.list();
/* 178:    */         }
/* 179:    */       }
/* 180:186 */       List enfermedades = (List)request.getSession().getAttribute("ENFERMEDADESUSUARIO");
/* 181:188 */       if (enfermedades == null) {
/* 182:189 */         enfermedades = new ArrayList();
/* 183:    */       }
/* 184:192 */       Enfermedades enfermedadTemp = new Enfermedades();
/* 185:193 */       for (Iterator iter = enfermedades.iterator(); iter.hasNext();)
/* 186:    */       {
/* 187:194 */         EnfermedadesUsuario enfermedadesUsuario = (EnfermedadesUsuario)iter.next();
/* 188:195 */         enfermedadTemp.setEnf_cod(enfermedadesUsuario.getEnfu_enf_cod());
/* 189:196 */         listEnfermedades.remove(enfermedadTemp);
/* 190:    */       }
/* 191:199 */       request.setAttribute("LISTENFERMEDADES", listEnfermedades);
/* 192:    */     }
/* 193:    */     catch (Exception e)
/* 194:    */     {
                    e.printStackTrace();
/* 195:202 */       return mapping.findForward("failure");
/* 196:    */     }
/* 197:205 */     return mapping.findForward("success");
/* 198:    */   }
/* 199:    */   
/* 200:    */   private ActionForward performRemove_enf(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 201:    */   {
/* 202:209 */     UsuarioEnfermedadesForm form = (UsuarioEnfermedadesForm)actionForm;
/* 203:    */     try
/* 204:    */     {
/* 205:213 */       List enfermedades = new ArrayList();
/* 206:214 */       enfermedades = (List)request.getSession().getAttribute("ENFERMEDADESUSUARIO");
/* 207:215 */       enfermedades.remove(Integer.parseInt(request.getParameter("num_enf")));
/* 208:    */       
/* 209:217 */       int x = 0;
/* 210:218 */       while (x < enfermedades.size())
/* 211:    */       {
/* 212:219 */         EnfermedadesUsuario usuarioEnfermedades = (EnfermedadesUsuario)enfermedades.get(x);
/* 213:220 */         usuarioEnfermedades.setEnfu_cod(new BigDecimal(x + 1));
/* 214:221 */         enfermedades.set(x, usuarioEnfermedades);
/* 215:222 */         x++;
/* 216:    */       }
/* 217:    */     }
/* 218:    */     catch (Exception e)
/* 219:    */     {
                    e.printStackTrace();
/* 220:227 */       return mapping.findForward("failure");
/* 221:    */     }
/* 222:229 */     return mapping.findForward("success");
/* 223:    */   }
/* 224:    */   
/* 225:    */   private ActionForward performTransfer_enf(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 226:    */   {
/* 227:234 */     UsuarioEnfermedadesForm form = (UsuarioEnfermedadesForm)actionForm;
/* 228:    */     try
/* 229:    */     {
/* 230:238 */       List enfermedades = new ArrayList();
/* 231:239 */       EnfermedadesUsuario usuarioEnfermedades = new EnfermedadesUsuario();
/* 232:240 */       InicializaData.inicializa(usuarioEnfermedades.getClass(), usuarioEnfermedades);
/* 233:241 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/* 234:242 */       BeanUtils.copyProperties(usuarioEnfermedades, form);
/* 235:243 */       usuarioEnfermedades.setEnfu_usuf_cod(usuarioFamily.getUsuf_cod());
/* 236:    */       
/* 237:245 */       enfermedades = (List)request.getSession().getAttribute("ENFERMEDADESUSUARIO");
/* 238:247 */       if (request.getParameter("num_enf") == null)
/* 239:    */       {
/* 240:248 */         enfermedades.add(usuarioEnfermedades);
/* 241:249 */         request.getSession().setAttribute("ENFERMEDADESUSUARIO", enfermedades);
/* 242:    */       }
/* 243:    */       else
/* 244:    */       {
/* 245:251 */         enfermedades.set(Integer.parseInt(request.getParameter("num_enf")), usuarioEnfermedades);
/* 246:    */       }
/* 247:254 */       int i = 0;
/* 248:255 */       EnfermedadesDAO listEnfermedadesDAO = new EnfermedadesDAO();
/* 249:256 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 250:257 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 251:258 */         listEnfermedadesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 252:    */       }
/* 253:260 */       //listEnfermedadesDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    listEnfermedadesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 254:261 */       while (i < enfermedades.size())
/* 255:    */       {
/* 256:262 */         request.setAttribute("enfer_des" + i, listEnfermedadesDAO.retrive(((EnfermedadesUsuario)enfermedades.get(i)).getEnfu_cod()).getEnf_des());
/* 257:263 */         i++;
/* 258:    */       }
/* 259:    */     }
/* 260:    */     catch (Exception e)
/* 261:    */     {
                    e.printStackTrace();
/* 262:269 */       return mapping.findForward("failure");
/* 263:    */     }
/* 264:271 */     return mapping.findForward("success");
/* 265:    */   }
/* 266:    */   
/* 267:    */   private ActionForward performEdit_alergia(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 268:    */   {
/* 269:275 */     AlergiasUsuarioForm form = (AlergiasUsuarioForm)actionForm;
/* 270:    */     try
/* 271:    */     {
/* 272:278 */       AlergiasUsuario alergiasUsuario = new AlergiasUsuario();
/* 273:279 */       List alergias = (List)request.getSession().getAttribute("ALERGIASUSUARIO");
/* 274:280 */       alergiasUsuario = (AlergiasUsuario)alergias.get(Integer.parseInt(request.getParameter("num_aler")));
/* 275:281 */       BeanUtils.copyProperties(form, alergiasUsuario);
/* 276:    */       
/* 277:283 */       AlergiasDAO alergiasDAO = new AlergiasDAO();
/* 278:284 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 279:285 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 280:286 */         alergiasDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 281:    */       }
/* 282:288 */       //alergiasDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    alergiasDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 283:289 */       List listAlergias = alergiasDAO.list();
/* 284:    */       
/* 285:291 */       Alergias alergiaTemp = new Alergias();
/* 286:292 */       for (Iterator iter = alergias.iterator(); iter.hasNext();)
/* 287:    */       {
/* 288:293 */         AlergiasUsuario alergiaUsuario = (AlergiasUsuario)iter.next();
/* 289:294 */         if (!alergiaUsuario.equals(alergiasUsuario))
/* 290:    */         {
/* 291:295 */           alergiaTemp.setAle_cod(alergiaUsuario.getAleu_ale_cod());
/* 292:296 */           listAlergias.remove(alergiaTemp);
/* 293:    */         }
/* 294:    */       }
/* 295:300 */       request.setAttribute("ALERGIAS", listAlergias);
/* 296:    */     }
/* 297:    */     catch (Exception e)
/* 298:    */     {
                    e.printStackTrace();
/* 299:304 */       return mapping.findForward("failure");
/* 300:    */     }
/* 301:306 */     return mapping.findForward("success");
/* 302:    */   }
/* 303:    */   
/* 304:    */   private ActionForward performAdd_alergia(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 305:    */   {
/* 306:310 */     AlergiasUsuarioForm form = (AlergiasUsuarioForm)actionForm;
/* 307:    */     try
/* 308:    */     {
/* 309:314 */       AlergiasDAO alergiasDAO = new AlergiasDAO();
/* 310:315 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 311:316 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 312:317 */         alergiasDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 313:    */       }
/* 314:319 */       //alergiasDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    alergiasDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 315:    */       
/* 316:321 */       List alergias = (List)request.getSession().getAttribute("ALERGIASUSUARIO");
/* 317:322 */       if (alergias == null) {
/* 318:323 */         alergias = new ArrayList();
/* 319:    */       }
/* 320:325 */       List listAlergias = alergiasDAO.list();
/* 321:    */       
/* 322:327 */       Alergias alergiaTemp = new Alergias();
/* 323:328 */       for (Iterator iter = alergias.iterator(); iter.hasNext();)
/* 324:    */       {
/* 325:329 */         AlergiasUsuario alergiaUsuario = (AlergiasUsuario)iter.next();
/* 326:330 */         alergiaTemp.setAle_cod(alergiaUsuario.getAleu_ale_cod());
/* 327:331 */         listAlergias.remove(alergiaTemp);
/* 328:    */       }
/* 329:334 */       request.setAttribute("ALERGIAS", listAlergias);
/* 330:    */     }
/* 331:    */     catch (Exception e)
/* 332:    */     {
                    e.printStackTrace();
/* 333:337 */       return mapping.findForward("failure");
/* 334:    */     }
/* 335:340 */     return mapping.findForward("success");
/* 336:    */   }
/* 337:    */   
/* 338:    */   private ActionForward performRemove_alergia(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 339:    */   {
/* 340:344 */     AlergiasUsuarioForm form = (AlergiasUsuarioForm)actionForm;
/* 341:    */     try
/* 342:    */     {
/* 343:347 */       List alergias = (List)request.getSession().getAttribute("ALERGIASUSUARIO");
/* 344:348 */       alergias.remove(Integer.parseInt(request.getParameter("num_aler")));
/* 345:    */       
/* 346:350 */       int x = 0;
/* 347:351 */       while (x < alergias.size())
/* 348:    */       {
/* 349:352 */         AlergiasUsuario alergiasUsuario = (AlergiasUsuario)alergias.get(x);
/* 350:353 */         alergiasUsuario.setAleu_cod(new BigDecimal(x + 1));
/* 351:354 */         alergias.set(x, alergiasUsuario);
/* 352:355 */         x++;
/* 353:    */       }
/* 354:    */     }
/* 355:    */     catch (Exception e)
/* 356:    */     {
                    e.printStackTrace();
/* 357:360 */       return mapping.findForward("failure");
/* 358:    */     }
/* 359:362 */     return mapping.findForward("success");
/* 360:    */   }
/* 361:    */   
/* 362:    */   private ActionForward performTransfer_alergia(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 363:    */   {
/* 364:365 */     AlergiasUsuarioForm form = (AlergiasUsuarioForm)actionForm;
/* 365:    */     try
/* 366:    */     {
/* 367:368 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/* 368:369 */       List alergias = (List)request.getSession().getAttribute("ALERGIASUSUARIO");
/* 369:370 */       AlergiasUsuario alergiaUsuario = new AlergiasUsuario();
/* 370:    */       
/* 371:372 */       BeanUtils.copyProperties(alergiaUsuario, form);
/* 372:373 */       alergiaUsuario.setAleu_usuf_cod(usuarioFamily.getUsuf_cod());
/* 373:375 */       if (request.getParameter("num_aler") == null) {
/* 374:376 */         alergias.add(alergiaUsuario);
/* 375:    */       } else {
/* 376:378 */         alergias.set(Integer.parseInt(request.getParameter("num_aler")), alergiaUsuario);
/* 377:    */       }
/* 378:    */     }
/* 379:    */     catch (Exception e)
/* 380:    */     {
                    e.printStackTrace();
/* 381:383 */       return mapping.findForward("failure");
/* 382:    */     }
/* 383:385 */     return mapping.findForward("success");
/* 384:    */   }
/* 385:    */   
/* 386:    */   private ActionForward performEdit_cir(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 387:    */   {
/* 388:389 */     CirujiasUsuarioForm form = (CirujiasUsuarioForm)actionForm;
/* 389:    */     try
/* 390:    */     {
/* 391:392 */       List cirujias = (List)request.getSession().getAttribute("CIRUJIASUSUARIO");
/* 392:393 */       CirujiasUsuario cirujiaUsuario = new CirujiasUsuario();
/* 393:394 */       cirujiaUsuario = (CirujiasUsuario)cirujias.get(Integer.parseInt(request.getParameter("num_cir")));
/* 394:395 */       BeanUtils.copyProperties(form, cirujiaUsuario);
/* 395:    */       
/* 396:397 */       CirujiasDAO cirujiasDAO = new CirujiasDAO();
/* 397:398 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 398:399 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 399:400 */         cirujiasDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 400:    */       }
/* 401:402 */       //cirujiasDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    cirujiasDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 402:403 */       List listCirujias = cirujiasDAO.list();
/* 403:    */       
/* 404:405 */       Cirujias cirujiaTemp = new Cirujias();
/* 405:406 */       for (Iterator iter = cirujias.iterator(); iter.hasNext();)
/* 406:    */       {
/* 407:407 */         CirujiasUsuario cirujiaUsu = (CirujiasUsuario)iter.next();
/* 408:408 */         if (!cirujiaUsu.equals(cirujiaUsuario))
/* 409:    */         {
/* 410:409 */           cirujiaTemp.setCir_cod(cirujiaUsu.getCiru_cir_cod());
/* 411:410 */           listCirujias.remove(cirujiaTemp);
/* 412:    */         }
/* 413:    */       }
/* 414:414 */       request.setAttribute("CIRUJIAS", listCirujias);
/* 415:    */     }
/* 416:    */     catch (Exception e)
/* 417:    */     {
                    e.printStackTrace();
/* 418:418 */       return mapping.findForward("failure");
/* 419:    */     }
/* 420:420 */     return mapping.findForward("success");
/* 421:    */   }
/* 422:    */   
/* 423:    */   private ActionForward performAdd_cir(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 424:    */   {
/* 425:424 */     CirujiasUsuarioForm form = (CirujiasUsuarioForm)actionForm;
/* 426:    */     try
/* 427:    */     {
/* 428:427 */       CirujiasDAO cirujiasDAO = new CirujiasDAO();
/* 429:428 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 430:429 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 431:430 */         cirujiasDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 432:    */       }
/* 433:432 */       //cirujiasDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    cirujiasDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 434:433 */       request.setAttribute("CIRUJIAS", cirujiasDAO.list());
/* 435:    */       
/* 436:435 */       List cirujias = (List)request.getSession().getAttribute("CIRUJIASUSUARIO");
/* 437:436 */       if (cirujias == null) {
/* 438:437 */         cirujias = new ArrayList();
/* 439:    */       }
/* 440:439 */       List listCirujias = cirujiasDAO.list();
/* 441:    */       
/* 442:441 */       Cirujias cirujiaTemp = new Cirujias();
/* 443:442 */       for (Iterator iter = cirujias.iterator(); iter.hasNext();)
/* 444:    */       {
/* 445:443 */         CirujiasUsuario cirujiaUsu = (CirujiasUsuario)iter.next();
/* 446:444 */         cirujiaTemp.setCir_cod(cirujiaUsu.getCiru_cir_cod());
/* 447:445 */         listCirujias.remove(cirujiaTemp);
/* 448:    */       }
/* 449:448 */       request.setAttribute("CIRUJIAS", listCirujias);
/* 450:    */     }
/* 451:    */     catch (Exception e)
/* 452:    */     {
                    e.printStackTrace();
/* 453:451 */       return mapping.findForward("failure");
/* 454:    */     }
/* 455:454 */     return mapping.findForward("success");
/* 456:    */   }
/* 457:    */   
/* 458:    */   private ActionForward performRemove_cir(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 459:    */   {
/* 460:458 */     CirujiasUsuarioForm form = (CirujiasUsuarioForm)actionForm;
/* 461:    */     try
/* 462:    */     {
/* 463:461 */       List cirujias = (List)request.getSession().getAttribute("CIRUJIASUSUARIO");
/* 464:462 */       cirujias.remove(Integer.parseInt(request.getParameter("num_cir")));
/* 465:    */       
/* 466:464 */       int x = 0;
/* 467:465 */       while (x < cirujias.size())
/* 468:    */       {
/* 469:466 */         CirujiasUsuario cirujiaUsuario = (CirujiasUsuario)cirujias.get(x);
/* 470:467 */         cirujiaUsuario.setCiru_cod(new BigDecimal(x + 1));
/* 471:468 */         cirujias.set(x, cirujiaUsuario);
/* 472:469 */         x++;
/* 473:    */       }
/* 474:    */     }
/* 475:    */     catch (Exception e)
/* 476:    */     {
                    e.printStackTrace();
/* 477:474 */       return mapping.findForward("failure");
/* 478:    */     }
/* 479:476 */     return mapping.findForward("success");
/* 480:    */   }
/* 481:    */   
/* 482:    */   private ActionForward performTransfer_cir(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 483:    */   {
/* 484:479 */     CirujiasUsuarioForm form = (CirujiasUsuarioForm)actionForm;
/* 485:    */     try
/* 486:    */     {
/* 487:482 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/* 488:483 */       List cirujias = (List)request.getSession().getAttribute("CIRUJIASUSUARIO");
/* 489:484 */       CirujiasUsuario cirujiasUsuario = new CirujiasUsuario();
/* 490:    */       
/* 491:486 */       BeanUtils.copyProperties(cirujiasUsuario, form);
/* 492:487 */       cirujiasUsuario.setCiru_usuf_cod(usuarioFamily.getUsuf_cod());
/* 493:489 */       if (request.getParameter("num_cir") == null) {
/* 494:490 */         cirujias.add(cirujiasUsuario);
/* 495:    */       } else {
/* 496:492 */         cirujias.set(Integer.parseInt(request.getParameter("num_cir")), cirujiasUsuario);
/* 497:    */       }
/* 498:    */     }
/* 499:    */     catch (Exception e)
/* 500:    */     {
                    e.printStackTrace();
/* 501:497 */       return mapping.findForward("failure");
/* 502:    */     }
/* 503:499 */     return mapping.findForward("success");
/* 504:    */   }
/* 505:    */   
/* 506:    */   private ActionForward performEdit_med(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 507:    */   {
/* 508:502 */     MedicamentosForm form = (MedicamentosForm)actionForm;
/* 509:    */     try
/* 510:    */     {
/* 511:506 */       List medicamentos = (List)request.getSession().getAttribute("MEDICAMENTOSUSUARIO");
/* 512:507 */       UsuarioMedicamentos medicamento = new UsuarioMedicamentos();
/* 513:508 */       medicamento = (UsuarioMedicamentos)medicamentos.get(Integer.parseInt(request.getParameter("num_medto")));
/* 514:    */       
/* 515:510 */       BeanUtils.copyProperties(form, medicamento);
/* 516:511 */       form.setMtom_fecdesde(ManejoFechas.FormateoFecha(medicamento.getMtom_fecdesde().toString()));
/* 517:    */       
/* 518:513 */       MedidaDAO medidaDAO = new MedidaDAO();
/* 519:514 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 520:515 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 521:516 */         medidaDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 522:    */       }
/* 523:518 */       //medidaDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    medidaDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 524:519 */       request.setAttribute("MEDIDAS", medidaDAO.list());
/* 525:    */       
/* 526:521 */       FormaDAO formaDAO = new FormaDAO();
/* 527:522 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 528:523 */         formaDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 529:    */       }
/* 530:525 */       //formaDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    formaDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 531:526 */       request.setAttribute("FORMAS", formaDAO.list());
/* 532:    */       
/* 533:528 */       PeriodoDAO periodoDAO = new PeriodoDAO();
/* 534:529 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 535:530 */         periodoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 536:    */       }
/* 537:532 */       //periodoDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    periodoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 538:533 */       request.setAttribute("PERIODOS", periodoDAO.list());
/* 539:    */       
/* 540:535 */       ViaAdministracionDAO viaAdministracionDAO = new ViaAdministracionDAO();
/* 541:536 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 542:537 */         viaAdministracionDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 543:    */       }
/* 544:539 */       //viaAdministracionDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    viaAdministracionDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 545:540 */       request.setAttribute("VIASADMINISTRACION", viaAdministracionDAO.list());
/* 546:    */     }
/* 547:    */     catch (Exception e)
/* 548:    */     {
                    e.printStackTrace();
/* 549:544 */       return mapping.findForward("failure");
/* 550:    */     }
/* 551:546 */     return mapping.findForward("success");
/* 552:    */   }
/* 553:    */   
/* 554:    */   private ActionForward performAdd_med(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 555:    */   {
/* 556:550 */     MedicamentosForm form = (MedicamentosForm)actionForm;
/* 557:    */     try
/* 558:    */     {
/* 559:554 */       MedidaDAO medidaDAO = new MedidaDAO();
/* 560:555 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 561:556 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 562:557 */         medidaDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 563:    */       }
/* 564:559 */       //medidaDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    medidaDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 565:560 */       request.setAttribute("MEDIDAS", medidaDAO.list());
/* 566:    */       
/* 567:562 */       FormaDAO formaDAO = new FormaDAO();
/* 568:563 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 569:564 */         formaDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 570:    */       }
/* 571:566 */       //formaDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    formaDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 572:567 */       request.setAttribute("FORMAS", formaDAO.list());
/* 573:    */       
/* 574:569 */       PeriodoDAO periodoDAO = new PeriodoDAO();
/* 575:570 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 576:571 */         periodoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 577:    */       }
/* 578:573 */       //periodoDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    periodoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 579:574 */       request.setAttribute("PERIODOS", periodoDAO.list());
/* 580:    */       
/* 581:576 */       ViaAdministracionDAO viaAdministracionDAO = new ViaAdministracionDAO();
/* 582:577 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 583:578 */         viaAdministracionDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 584:    */       }
/* 585:580 */       //viaAdministracionDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    viaAdministracionDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 586:581 */       request.setAttribute("VIASADMINISTRACION", viaAdministracionDAO.list());
/* 587:    */     }
/* 588:    */     catch (Exception e)
/* 589:    */     {
                    e.printStackTrace();
/* 590:584 */       return mapping.findForward("failure");
/* 591:    */     }
/* 592:587 */     return mapping.findForward("success");
/* 593:    */   }
/* 594:    */   
/* 595:    */   private ActionForward performRemove_med(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 596:    */   {
/* 597:591 */     MedicamentosForm form = (MedicamentosForm)actionForm;
/* 598:    */     try
/* 599:    */     {
/* 600:594 */       List medicamentos = (List)request.getSession().getAttribute("MEDICAMENTOSUSUARIO");
/* 601:595 */       medicamentos.remove(Integer.parseInt(request.getParameter("num_medto")));
/* 602:    */       
/* 603:597 */       int x = 0;
/* 604:598 */       while (x < medicamentos.size())
/* 605:    */       {
/* 606:599 */         UsuarioMedicamentos medicamento = (UsuarioMedicamentos)medicamentos.get(x);
/* 607:600 */         medicamento.setMtom_cod(new BigDecimal(x + 1));
/* 608:601 */         medicamentos.set(x, medicamento);
/* 609:602 */         x++;
/* 610:    */       }
/* 611:    */     }
/* 612:    */     catch (Exception e)
/* 613:    */     {
                    e.printStackTrace();
/* 614:606 */       return mapping.findForward("failure");
/* 615:    */     }
/* 616:608 */     return mapping.findForward("success");
/* 617:    */   }
/* 618:    */   
/* 619:    */   private ActionForward performTransfer_med(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 620:    */   {
/* 621:611 */     MedicamentosForm form = (MedicamentosForm)actionForm;
/* 622:    */     try
/* 623:    */     {
/* 624:614 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/* 625:615 */       form.setMtom_fecdesde(ManejoFechas.getChangeFecha(form.getMtom_fecdesde()));
/* 626:    */       
/* 627:617 */       List medicamentos = (List)request.getSession().getAttribute("MEDICAMENTOSUSUARIO");
/* 628:618 */       UsuarioMedicamentos medicamento = new UsuarioMedicamentos();
/* 629:619 */       InicializaData.inicializa(medicamento.getClass(), medicamento);
/* 630:620 */       BeanUtils.copyProperties(medicamento, form);
/* 631:621 */       medicamento.setMtom_usuf_cod(usuarioFamily.getUsuf_cod());
/* 632:623 */       if (request.getParameter("num_medto") == null) {
/* 633:624 */         medicamentos.add(medicamento);
/* 634:    */       } else {
/* 635:626 */         medicamentos.set(Integer.parseInt(request.getParameter("num_medto")), medicamento);
/* 636:    */       }
/* 637:    */     }
/* 638:    */     catch (Exception e)
/* 639:    */     {
                    e.printStackTrace();
/* 640:630 */       return mapping.findForward("failure");
/* 641:    */     }
/* 642:632 */     return mapping.findForward("success");
/* 643:    */   }
/* 644:    */   
/* 645:    */   private ActionForward performAdd_ante(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 646:    */   {
/* 647:636 */     AntecedentesUsuarioForm form = (AntecedentesUsuarioForm)actionForm;
/* 648:    */     try
/* 649:    */     {
/* 650:639 */       AntecedentesDAO antecedentesDAO = new AntecedentesDAO();
/* 651:640 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 652:641 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 653:642 */         antecedentesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 654:    */       }
/* 655:644 */       //antecedentesDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    antecedentesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 656:645 */       List listAntecedentes = antecedentesDAO.list();
/* 657:    */       
/* 658:647 */       List antecedentes = (List)request.getSession().getAttribute("ANTECEDENTESUSUARIO");
/* 659:648 */       if (antecedentes == null) {
/* 660:649 */         antecedentes = new ArrayList();
/* 661:    */       }
/* 662:651 */       Antecedentes antecedenteTemp = new Antecedentes();
/* 663:652 */       for (Iterator iter = antecedentes.iterator(); iter.hasNext();)
/* 664:    */       {
/* 665:653 */         AntecedentesUsuario antecedentUsuario = (AntecedentesUsuario)iter.next();
/* 666:654 */         antecedenteTemp.setAnte_cod(antecedentUsuario.getAnteu_ante_cod());
/* 667:655 */         listAntecedentes.remove(antecedenteTemp);
/* 668:    */       }
/* 669:658 */       request.setAttribute("ANTECEDENTES", listAntecedentes);
/* 670:    */     }
/* 671:    */     catch (Exception e)
/* 672:    */     {
                    e.printStackTrace();
/* 673:661 */       return mapping.findForward("failure");
/* 674:    */     }
/* 675:664 */     return mapping.findForward("success");
/* 676:    */   }
/* 677:    */   
/* 678:    */   private ActionForward performTransfer_ante(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 679:    */   {
/* 680:668 */     AntecedentesUsuarioForm form = (AntecedentesUsuarioForm)actionForm;
/* 681:    */     try
/* 682:    */     {
/* 683:671 */       List antecedentes = (List)request.getSession().getAttribute("ANTECEDENTESUSUARIO");
/* 684:672 */       AntecedentesUsuario antecedenteUsuario = new AntecedentesUsuario();
/* 685:673 */       InicializaData.inicializa(antecedenteUsuario.getClass(), antecedenteUsuario);
/* 686:674 */       BeanUtils.copyProperties(antecedenteUsuario, form);
/* 687:675 */       antecedentes.add(antecedenteUsuario);
/* 688:    */     }
/* 689:    */     catch (Exception e)
/* 690:    */     {
                    e.printStackTrace();
/* 691:679 */       return mapping.findForward("failure");
/* 692:    */     }
/* 693:681 */     return mapping.findForward("success");
/* 694:    */   }
/* 695:    */ }



/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\

 * Qualified Name:     com.servidoctor.sdfamily.controller.PopupHistoriaMedicaAction

 * JD-Core Version:    0.7.0.1

 */