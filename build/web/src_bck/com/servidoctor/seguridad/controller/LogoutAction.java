/*   1:    */ package com.servidoctor.seguridad.controller;
/*   2:    */ 
/*   3:    */ import com.essecorp.util.GestorCorreoSD;
/*   4:    */ import com.servidoctor.parametros.dao.LogosMayorDAO;
/*   5:    */ import com.servidoctor.parametros.model.LogosMayor;
/*   6:    */ import com.servidoctor.sdfamily.dao.DatosPersonalesDAO;
/*   7:    */ import com.servidoctor.seguridad.dao.Compras_licenciasDAO;
/*   8:    */ import com.servidoctor.seguridad.dao.IntercambioDatosDAO;
/*   9:    */ import com.servidoctor.seguridad.dao.ServidoresDAO;
/*  10:    */ import com.servidoctor.seguridad.dao.UsuarioCarDAO;
/*  11:    */ import com.servidoctor.seguridad.dao.UsuarioFamilyDAO;
/*  12:    */ import com.servidoctor.seguridad.dao.UsuarioPetsDAO;
/*  13:    */ import com.servidoctor.seguridad.model.Compras_licencias;
/*  14:    */ import com.servidoctor.seguridad.model.IntercambioDatos;
/*  15:    */ import com.servidoctor.seguridad.model.Servidores;
/*  16:    */ import com.servidoctor.seguridad.model.UsuarioCar;
/*  17:    */ import com.servidoctor.seguridad.model.UsuarioFamily;
/*  18:    */ import com.servidoctor.seguridad.model.UsuarioPets;
/*  19:    */ import com.servidoctor.util.AES;
/*  20:    */ import com.servidoctor.util.classes.InicializaData;
/*  21:    */ import com.servidoctor.util.classes.ManejoFechas;
/*  22:    */ import java.io.BufferedReader;
/*  23:    */ import java.io.IOException;
/*  24:    */ import java.io.InputStream;
/*  25:    */ import java.io.InputStreamReader;
/*  26:    */ import java.io.OutputStream;
/*  27:    */ import java.io.PrintStream;
/*  28:    */ import java.io.PrintWriter;
/*  29:    */ import java.math.BigDecimal;
/*  30:    */ import java.net.HttpURLConnection;
/*  31:    */ import java.net.Socket;
/*  32:    */ import java.net.URL;
/*  33:    */ import java.net.URLConnection;
/*  34:    */ import java.net.URLEncoder;
/*  35:    */ import java.sql.SQLException;
/*  36:    */ import java.util.Date;
/*  37:    */ import java.util.Enumeration;
/*  38:    */ import java.util.HashMap;
/*  39:    */ import java.util.Iterator;
/*  40:    */ import java.util.List;
/*  41:    */ import java.util.Locale;
/*  42:    */ import java.util.Map;
/*  43:    */ import java.util.ResourceBundle;
/*  44:    */ import javax.servlet.http.Cookie;
/*  45:    */ import javax.servlet.http.HttpServletRequest;
/*  46:    */ import javax.servlet.http.HttpServletResponse;
/*  47:    */ import javax.servlet.http.HttpSession;
/*  48:    */ import javax.servlet.jsp.jstl.core.Config;
/*  49:    */ import org.apache.struts.action.Action;
/*  50:    */ import org.apache.struts.action.ActionForm;
/*  51:    */ import org.apache.struts.action.ActionForward;
/*  52:    */ import org.apache.struts.action.ActionMapping;
/*  53:    */ import org.apache.struts.util.MessageResources;
/*  54:    */ 
/*  55:    */ public class LogoutAction
/*  56:    */   extends Action
/*  57:    */ {
/*  58: 59 */   private ResourceBundle config = ResourceBundle.getBundle("com.servidoctor.resources.Config");
/*  59:    */   
/*  60:    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*  61:    */   {
/*  62: 62 */     ActionForward myforward = null;
/*  63: 63 */     String myaction = mapping.getParameter();
/*  64: 65 */     if ("".equalsIgnoreCase(myaction)) {
/*  65: 66 */       myforward = mapping.findForward("failure");
/*  66: 67 */     } else if ("LOGIN".equalsIgnoreCase(myaction)) {
/*  67: 68 */       myforward = performLogin(mapping, form, request, response);
/*  68: 69 */     } else if ("RELOAD_LOGIN_DATA".equalsIgnoreCase(myaction)) {
/*  69: 70 */       myforward = performReloadLoginData(mapping, form, request, response);
/*  70: 71 */     } else if ("LOGOUT".equalsIgnoreCase(myaction)) {
/*  71: 72 */       myforward = performLogout(mapping, form, request, response);
/*  72: 73 */     } else if ("PASSREM".equalsIgnoreCase(myaction)) {
/*  73: 74 */       myforward = performPassword(mapping, form, request, response);
/*  74: 75 */     } else if ("PASSCHANGE".equalsIgnoreCase(myaction)) {
/*  75: 76 */       myforward = performPasschange(mapping, form, request, response);
/*  76: 77 */     } else if ("IDIOMA".equalsIgnoreCase(myaction)) {
/*  77: 78 */       myforward = performIdioma(mapping, form, request, response);
/*  78:    */     } else {
/*  79: 80 */       myforward = mapping.findForward("failure");
/*  80:    */     }
/*  81: 82 */     return myforward;
/*  82:    */   }
/*  83:    */   
/*  84:    */   private ActionForward performPasschange(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*  85:    */   {
/*  86: 86 */     LoginForm loginForm = (LoginForm)form;
/*  87: 87 */     UsuarioFamily usuarioFamily = null;
/*  88: 88 */     UsuarioPets usuarioPets = null;
/*  89: 89 */     UsuarioCar usuarioCar = null;
/*  90: 90 */     UsuarioFamily usuarioFamily2 = null;
/*  91: 91 */     UsuarioPets usuarioPets2 = null;
/*  92: 92 */     UsuarioCar usuarioCar2 = null;
/*  93:    */     
/*  94: 94 */     String resultado = "success";
/*  95: 95 */     UsuarioFamilyDAO usuarioFamilyDAO = new UsuarioFamilyDAO();
/*  96: 96 */     UsuarioPetsDAO usuarioPetsDAO = new UsuarioPetsDAO();
/*  97: 97 */     UsuarioCarDAO usuarioCarDAO = new UsuarioCarDAO();
/*  98: 98 */     Locale locale = null;
/*  99: 99 */     String password = new AES().encrypt(loginForm.getPassword());
/* 100:    */     
                    System.out.println("aqui estoy");
/* 101:101 */     String servicio = loginForm.getServicio().toString();
/* 102:    */     try
/* 103:    */     {
/* 104:104 */       if ((loginForm.getPassword1().toString().compareTo("") != 0) && (request.getParameter("pass") != null))
/* 105:    */       {
/* 106:106 */         if (servicio.compareTo("family") == 0)
/* 107:    */         {
                        
/* 108:107 */           usuarioFamily = usuarioFamilyDAO.loginPassword(loginForm.getUsername(), password);
/* 109:108 */           usuarioFamily.setUsuf_clave(request.getParameter("password1"));
/* 110:109 */           if (usuarioFamily.getUsuf_cod() != null)
/* 111:    */           {
/* 112:111 */             usuarioFamilyDAO.updatePassword(usuarioFamily.getUsuf_cod(), request.getParameter("login") != null ? request.getParameter("username1") : usuarioFamily.getUsuf_usuario(), request.getParameter("pass") != null ? new AES().encrypt(request.getParameter("password1")) : usuarioFamily.getUsuf_clave());
/* 113:    */           }
/* 114:    */           else
/* 115:    */           {
/* 116:114 */             request.setAttribute("FAILURE", getResources(request).getMessage(locale, "main.login.loginNoExiste"));
/* 117:115 */             resultado = "failure";
/* 118:116 */             return mapping.findForward(resultado);
/* 119:    */           }
/* 120:    */         }
/* 121:119 */         if (servicio.compareTo("pets") == 0)
/* 122:    */         {
/* 123:120 */           usuarioPets = usuarioPetsDAO.loginPassword(loginForm.getUsername(), password);
/* 124:121 */           if (usuarioPets.getUsup_cod() != null)
/* 125:    */           {
/* 126:122 */             usuarioPetsDAO.updatePassword(usuarioPets.getUsup_cod(), request.getParameter("login") != null ? request.getParameter("username1") : usuarioPets.getUsup_usuario(), request.getParameter("pass") != null ? new AES().encrypt(request.getParameter("password1")) : usuarioPets.getUsup_clave());
/* 127:    */           }
/* 128:    */           else
/* 129:    */           {
/* 130:125 */             request.setAttribute("FAILURE", getResources(request).getMessage(locale, "main.login.loginNoExiste"));
/* 131:126 */             resultado = "failure";
/* 132:127 */             return mapping.findForward(resultado);
/* 133:    */           }
/* 134:    */         }
/* 135:130 */         if (servicio.compareTo("car") == 0)
/* 136:    */         {
/* 137:131 */           usuarioCar = usuarioCarDAO.login(loginForm.getUsername(), password);
/* 138:132 */           if (usuarioCar.getUsuc_cod() != null)
/* 139:    */           {
/* 140:133 */             usuarioCarDAO.updatePassword(usuarioCar.getUsuc_cod(), request.getParameter("login") != null ? request.getParameter("username1") : usuarioCar.getUsuc_usuario(), request.getParameter("pass") != null ? new AES().encrypt(request.getParameter("password1")) : usuarioCar.getUsuc_clave());
/* 141:134 */             usuarioCar.setUsuc_clave(request.getParameter("password1"));
/* 142:135 */             request.getSession().setAttribute("usuarioCar", usuarioCar);
/* 143:136 */             request.setAttribute("car", "");
/* 144:    */           }
/* 145:    */           else
/* 146:    */           {
/* 147:138 */             request.setAttribute("FAILURE", getResources(request).getMessage(locale, "main.login.loginNoExiste"));
/* 148:139 */             resultado = "failure";
/* 149:140 */             return mapping.findForward(resultado);
/* 150:    */           }
/* 151:    */         }
/* 152:    */       }
/* 153:146 */       if ((loginForm.getUsername1().toString().compareTo("") != 0) && (request.getParameter("login") != null))
/* 154:    */       {
/* 155:148 */         if (servicio.compareTo("family") == 0)
/* 156:    */         {
                        System.out.println("en family");
/* 157:149 */           usuarioFamily = usuarioFamilyDAO.loginPassword(loginForm.getUsername1(), password);
/* 158:150 */           if (usuarioFamily.getUsuf_cod() == null)
/* 159:    */           {
/* 160:151 */             usuarioFamily2 = usuarioFamilyDAO.loginPassword(loginForm.getUsername(), password);
/* 161:152 */             if (usuarioFamily2.getUsuf_cod() != null)
/* 162:    */             {
/* 163:153 */               loginForm.setUsername(loginForm.getUsername1());
/* 164:154 */               usuarioFamilyDAO.updatePassword(usuarioFamily2.getUsuf_cod(), request.getParameter("login") != null ? request.getParameter("username1") : usuarioFamily.getUsuf_usuario(), request.getParameter("pass") != null ? request.getParameter("password1") : usuarioFamily.getUsuf_clave());
/* 165:    */             }
/* 166:    */             else
/* 167:    */             {
/* 168:158 */               request.setAttribute("FAILURE", getResources(request).getMessage(locale, "main.login.loginNoExiste"));
/* 169:159 */               resultado = "failure";
/* 170:160 */               return mapping.findForward(resultado);
/* 171:    */             }
/* 172:    */           }
/* 173:    */           else
/* 174:    */           {
/* 175:164 */             request.setAttribute("FAILURE", getResources(request).getMessage(locale, "main.login.loginyaexiste"));
/* 176:165 */             return mapping.findForward("failure");
/* 177:    */           }
/* 178:    */         }
/* 179:168 */         if (servicio.compareTo("pets") == 0)
/* 180:    */         {
/* 181:169 */           usuarioPets = usuarioPetsDAO.loginPassword(loginForm.getUsername1(), password);
/* 182:170 */           if (usuarioPets.getUsup_cod() == null)
/* 183:    */           {
/* 184:171 */             usuarioPets2 = usuarioPetsDAO.loginPassword(loginForm.getUsername(), password);
/* 185:172 */             if (usuarioPets2.getUsup_cod() != null)
/* 186:    */             {
/* 187:173 */               loginForm.setUsername(loginForm.getUsername1());
/* 188:174 */               usuarioPetsDAO.updatePassword(usuarioPets2.getUsup_cod(), request.getParameter("login") != null ? request.getParameter("username1") : usuarioPets.getUsup_usuario(), request.getParameter("pass") != null ? request.getParameter("password1") : usuarioPets.getUsup_clave());
/* 189:    */             }
/* 190:    */             else
/* 191:    */             {
/* 192:178 */               request.setAttribute("FAILURE", getResources(request).getMessage(locale, "main.login.loginNoExiste"));
/* 193:179 */               resultado = "failure";
/* 194:180 */               return mapping.findForward(resultado);
/* 195:    */             }
/* 196:    */           }
/* 197:    */           else
/* 198:    */           {
/* 199:184 */             request.setAttribute("FAILURE", getResources(request).getMessage(locale, "main.login.loginyaexiste"));
/* 200:185 */             return mapping.findForward("failure");
/* 201:    */           }
/* 202:    */         }
/* 203:188 */         if (servicio.compareTo("car") == 0)
/* 204:    */         {
/* 205:189 */           usuarioCar = usuarioCarDAO.login(loginForm.getUsername1(), password);
/* 206:190 */           if (usuarioCar.getUsuc_cod() == null)
/* 207:    */           {
/* 208:191 */             usuarioCar2 = usuarioCarDAO.login(loginForm.getUsername(), password);
/* 209:192 */             if (usuarioCar2.getUsuc_cod() != null)
/* 210:    */             {
/* 211:193 */               loginForm.setUsername(loginForm.getUsername1());
/* 212:194 */               usuarioCarDAO.updatePassword(usuarioCar2.getUsuc_cod(), request.getParameter("login") != null ? request.getParameter("username1") : usuarioCar.getUsuc_usuario(), request.getParameter("pass") != null ? request.getParameter("password1") : usuarioCar.getUsuc_clave());
/* 213:    */             }
/* 214:    */             else
/* 215:    */             {
/* 216:198 */               request.setAttribute("FAILURE", getResources(request).getMessage(locale, "main.login.loginNoExiste"));
/* 217:199 */               resultado = "failure";
/* 218:200 */               return mapping.findForward(resultado);
/* 219:    */             }
/* 220:    */           }
/* 221:    */           else
/* 222:    */           {
/* 223:204 */             request.setAttribute("FAILURE", getResources(request).getMessage(locale, "main.login.loginyaexiste"));
/* 224:205 */             return mapping.findForward("failure");
/* 225:    */           }
/* 226:    */         }
/* 227:    */       }
/* 228:    */     }
/* 229:    */     catch (Exception e)
/* 230:    */     {
/* 231:295 */       request.setAttribute("FAILURE", getResources(request).getMessage(locale, "main.login.loginyaexiste"));
/* 232:296 */       return mapping.findForward("failure");
/* 233:    */     }
/* 234:299 */     return mapping.findForward(resultado);
/* 235:    */   }
/* 236:    */   
/* 237:    */   private ActionForward performIdioma(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/* 238:    */   {
/* 239:303 */     ActionForward temp = mapping.findForward("failure");
/* 240:    */     try
/* 241:    */     {
/* 242:305 */       updateLanguage(request, response, request.getParameter("idioma"));
/* 243:306 */       if (request.getParameter("activar") != null) {
/* 244:307 */         temp = mapping.findForward("activar");
/* 245:308 */       } else if (request.getParameter("login") != null) {
/* 246:309 */         temp = mapping.findForward("login");
/* 247:310 */       } else if (request.getParameter("cambiar") != null) {
/* 248:311 */         temp = mapping.findForward("cambiar");
/* 249:    */       }
/* 250:    */     }
/* 251:    */     catch (Exception e)
/* 252:    */     {
/* 253:314 */       request.getSession().setAttribute("message", e.getMessage());
/* 254:315 */       return mapping.findForward("failure");
/* 255:    */     }
/* 256:317 */     return temp;
/* 257:    */   }
/* 258:    */   
/* 259:    */   private ActionForward performPassword(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/* 260:    */   {
/* 261:321 */     String passforget = null;
/* 262:322 */     UsuarioFamilyDAO usuarioFamilyDAO = new UsuarioFamilyDAO();
/* 263:323 */     UsuarioCarDAO usuarioCarDAO = new UsuarioCarDAO();
/* 264:324 */     UsuarioPetsDAO usuarioPetsDAO = new UsuarioPetsDAO();
/* 265:325 */     StringBuffer claves = new StringBuffer();
/* 266:326 */     String mail = null;
/* 267:    */     try
/* 268:    */     {
/* 269:329 */       passforget = request.getParameter("passforget");
/* 270:    */       
/* 271:331 */       LoginForm loginForm = (LoginForm)form;
/* 272:333 */       if ((passforget != null) && (passforget.trim().equalsIgnoreCase("1")))
/* 273:    */       {
/* 274:334 */         List usuarioS = usuarioFamilyDAO.retrive_list(loginForm.getUsername());
/* 275:335 */         Iterator usu_iterator = usuarioS.iterator();
/* 276:336 */         if (usu_iterator.hasNext()) {
/* 277:337 */           claves.append("</b>Family:<br><b>");
/* 278:    */         }
/* 279:339 */         while (usu_iterator.hasNext())
/* 280:    */         {
/* 281:340 */           UsuarioFamily usuarioFamily = (UsuarioFamily)usu_iterator.next();
/* 282:    */           
/* 283:342 */           claves.append(new AES().decrypt(new AES().decrypt(usuarioFamily.getUsuf_clave())));
/* 290:349 */           claves.append("<br>");
/* 291:350 */           mail = usuarioFamily.getUsuf_usuario();
/* 292:    */         }
/* 293:352 */         usuarioS = usuarioCarDAO.retrive_list(loginForm.getUsername());
/* 294:353 */         usu_iterator = usuarioS.iterator();
/* 295:354 */         if (usu_iterator.hasNext()) {
/* 296:355 */           claves.append("</b>Car:<br><b>");
/* 297:    */         }
/* 298:357 */         while (usu_iterator.hasNext())
/* 299:    */         {
/* 300:358 */           UsuarioCar usuarioCar = (UsuarioCar)usu_iterator.next();
/* 301:359 */           claves.append(new AES().decrypt(new AES().decrypt(usuarioCar.getUsuc_clave())) + "<br>");
/* 302:360 */           mail = usuarioCar.getUsuc_usuario();
/* 303:    */         }
/* 304:362 */         usuarioS = usuarioPetsDAO.retrive_list(loginForm.getUsername());
/* 305:363 */         usu_iterator = usuarioS.iterator();
/* 306:364 */         if (usu_iterator.hasNext()) {
/* 307:365 */           claves.append("</b>Pets:<br><b>");
/* 308:    */         }
/* 309:367 */         while (usu_iterator.hasNext())
/* 310:    */         {
/* 311:368 */           UsuarioPets usuarioPets = (UsuarioPets)usu_iterator.next();
/* 312:369 */           claves.append(new AES().decrypt(new AES().decrypt(usuarioPets.getUsup_clave())) + "<br>");
/* 313:370 */           mail = usuarioPets.getUsup_usuario();
/* 314:    */         }
/* 315:372 */         String idioma = null;
/* 316:373 */         //idioma = request.getSession().getAttribute("idioma") != null ? "en_EN" : "es_ES";
                      idioma = request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2);
                      //if (request.getSession().getAttribute("idioma")=="en")
                      //    idioma = "en_EN";
                      //else
                      //    idioma = "es_ES";
                      
/* 317:374 */         Locale locale = new Locale(idioma);
/* 318:375 */         System.out.println("paso");
/* 319:376 */         GestorCorreoSD.setContents(
/* 320:377 */           GestorCorreoSD.getRESOURCES().getMessage(locale, "passforget.mail.contents.title"), 
/* 321:378 */           GestorCorreoSD.getRESOURCES().getMessage(locale, "passforget.mail.contents.header"), 
/* 322:379 */           GestorCorreoSD.getRESOURCES().getMessage(locale, "passforget.mail.contents.msg") + claves.toString() + "</b>", 
/* 323:380 */           GestorCorreoSD.getRESOURCES().getMessage(locale, "passforget.mail.contents.footer"));
/* 324:381 */         GestorCorreoSD.setTo(mail);
/* 325:382 */         GestorCorreoSD.setSubject(GestorCorreoSD.getRESOURCES().getMessage(locale, "mail.subject"));
/* 326:383 */         GestorCorreoSD.enviarCorreo();
/* 327:    */         
/* 328:385 */         request.setAttribute("FAILURE", GestorCorreoSD.getRESOURCES().getMessage(locale, "mail.send"));
/* 329:    */       }
/* 330:389 */       request.removeAttribute("passforget");
/* 331:390 */       request.getSession().removeAttribute("passforget");
/* 332:    */       
/* 333:392 */       return mapping.findForward("success");
/* 334:    */     }
/* 335:    */     catch (Exception e)
/* 336:    */     {
/* 337:395 */       request.setAttribute("FAILURE", e.getMessage());
/* 338:    */     }
/* 339:396 */     return mapping.findForward("failure");
/* 340:    */   }
/* 341:    */   
/* 342:    */   private ActionForward performLogout(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/* 343:    */   {
/* 344:    */     try
/* 345:    */     {
/* 346:402 */       HttpSession session = request.getSession();
/* 347:403 */       session.invalidate();
/* 348:    */     }
/* 349:    */     catch (Exception localException) {}
/* 350:407 */     return mapping.findForward("success");
/* 351:    */   }
/* 352:    */   
/* 353:    */   private ActionForward performLogin(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/* 354:    */   {
/* 355:411 */     LoginForm loginForm = (LoginForm)form;
/* 356:412 */     UsuarioFamily usuarioFamily = null;
/* 357:413 */     UsuarioPets usuarioPets = null;
/* 358:414 */     UsuarioCar usuarioCar = null;
/* 359:415 */     String resultado = null;
/* 360:416 */     boolean existeFamily = false;
/* 361:417 */     boolean existePets = false;
/* 362:418 */     boolean existeCar = false;
/* 363:419 */     boolean soloLecturaFamily = false;
/* 364:420 */     boolean soloLecturaPets = false;
/* 365:421 */     boolean soloLecturaCar = false;
/* 366:    */     
/* 367:423 */     Compras_licencias compras_licenciasFamily = null;
/* 368:424 */     Compras_licencias compras_licenciasPets = null;
/* 369:425 */     Compras_licencias compras_licenciasCar = null;
/* 370:426 */     Compras_licenciasDAO compras_licenciasDAO = new Compras_licenciasDAO();
/* 371:    */     
/* 372:428 */     ServidoresDAO servidoresDAO = null;
/* 373:429 */     Servidores servidor = null;
/* 374:    */     
/* 375:431 */     IntercambioDatosDAO intercambioDatosDAO = null;
/* 376:    */     
/* 377:    */ 
/* 378:434 */     char app = 'F';
/* 379:435 */     LogosMayorDAO logosMayorDAO = null;
/* 380:    */     
/* 381:    */ 
/* 382:    */ 
/* 383:439 */     String fechaActual = ManejoFechas.getFechaActual();
/* 384:    */     System.out.println("español5:" + request.getSession().getAttribute("org.apache.struts.action.LOCALE"));
/* 385:    */ 
/* 386:442 */     Locale locale = null;
/* 387:    */     try
/* 388:    */     {
/* 389:445 */       //if (request.getSession().getAttribute("idioma") == null) {
/* 390:446 */       //  updateLanguage(request, response, "");
/* 391:    */       //}
                    System.out.println("language:" + request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
                    String language = request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2);
                    language = language.substring(0, 1);
                    
/* 392:449 */       locale = new Locale(language);
/* 393:    */        
/* 394:    */ 
/* 395:452 */       request.getSession().removeAttribute("usuarioFamily");
/* 396:453 */       request.getSession().removeAttribute("usuarioPets");
/* 397:454 */       request.getSession().removeAttribute("usuarioCar");
/* 398:    */       
/* 399:456 */       UsuarioFamilyDAO usuarioFamilyDAO = new UsuarioFamilyDAO();
/* 400:457 */       usuarioFamily = usuarioFamilyDAO.login(loginForm.getUsername());
/* 401:458 */       if (usuarioFamily.getUsuf_cod() != null)
/* 402:    */       {
/* 403:459 */         existeFamily = true;
/* 404:460 */         if (usuarioFamily.getUsuf_especial().equals(BigDecimal.ZERO)) {
/* 405:461 */           compras_licenciasFamily = compras_licenciasDAO.retrive(usuarioFamily.getUsuf_licencia());
/* 406:    */         }
/* 407:    */       }
/* 408:464 */       usuarioFamily = usuarioFamilyDAO.login(loginForm.getUsername(), new AES().encrypt(loginForm.getPassword()));
/* 409:465 */       if (usuarioFamily.getUsuf_cod() == null)
/* 410:    */       {
/* 411:466 */         usuarioFamily = usuarioFamilyDAO.loginEmergencia(loginForm.getUsername(), loginForm.getPassword());
/* 412:467 */         if (usuarioFamily.getUsuf_cod() != null) {
/* 413:468 */           soloLecturaFamily = true;
/* 414:    */         }
/* 415:    */       }
/* 416:472 */       UsuarioPetsDAO usuarioPetsDAO = new UsuarioPetsDAO();
/* 417:473 */       usuarioPets = usuarioPetsDAO.login(loginForm.getUsername());
/* 418:474 */       if (usuarioPets.getUsup_cod() != null)
/* 419:    */       {
/* 420:475 */         existePets = true;
/* 421:476 */         if (usuarioPets.getUsup_especial().equals(BigDecimal.ZERO)) {
/* 422:477 */           compras_licenciasPets = compras_licenciasDAO.retrive(usuarioPets.getUsup_licencia());
/* 423:    */         }
/* 424:    */       }
/* 425:480 */       usuarioPets = usuarioPetsDAO.login(loginForm.getUsername(), new AES().encrypt(loginForm.getPassword()));
/* 426:481 */       if (usuarioPets.getUsup_cod() == null)
/* 427:    */       {
/* 428:482 */         usuarioPets = usuarioPetsDAO.loginEmergencia(loginForm.getUsername(), loginForm.getPassword());
/* 429:483 */         if (usuarioPets.getUsup_cod() != null) {
/* 430:484 */           soloLecturaPets = true;
/* 431:    */         }
/* 432:    */       }
/* 433:488 */       UsuarioCarDAO usuarioCarDAO = new UsuarioCarDAO();
/* 434:489 */       usuarioCar = usuarioCarDAO.login(loginForm.getUsername());
/* 435:490 */       if (usuarioCar.getUsuc_cod() != null)
/* 436:    */       {
/* 437:491 */         existeCar = true;
/* 438:492 */         if (usuarioCar.getUsuc_especial().equals(BigDecimal.ZERO)) {
/* 439:493 */           compras_licenciasCar = compras_licenciasDAO.retrive(usuarioCar.getUsuc_licencia());
/* 440:    */         }
/* 441:    */       }
/* 442:496 */       usuarioCar = usuarioCarDAO.login(loginForm.getUsername(), new AES().encrypt(loginForm.getPassword()));
/* 443:497 */       if (usuarioCar.getUsuc_cod() == null)
/* 444:    */       {
/* 445:498 */         usuarioCar = usuarioCarDAO.loginEmergencia(loginForm.getUsername(), loginForm.getPassword());
/* 446:499 */         if (usuarioCar.getUsuc_cod() != null) {
/* 447:500 */           soloLecturaCar = true;
/* 448:    */         }
/* 449:    */       }
/* 450:504 */       int matchNumber = 0;
/* 451:505 */       servidoresDAO = new ServidoresDAO();
/* 452:506 */       logosMayorDAO = new LogosMayorDAO();
/* 453:508 */       if (usuarioFamily.getUsuf_cod() != null)
/* 454:    */       {
/* 455:509 */         if (this.config.getString("urlRedirect").equals("false")) {
/* 456:510 */           request.getSession().setAttribute("usuarioFamily", usuarioFamily);
/* 457:    */         }
/* 458:512 */         resultado = "success_family";app = 'F';
/* 459:513 */         matchNumber++;
/* 460:514 */         request.setAttribute("family", "");
/* 461:515 */         servidor = servidoresDAO.retrive(usuarioFamily.getUsuf_servidor_cod());
/* 462:    */       }
/* 463:519 */       if (usuarioPets.getUsup_cod() != null)
/* 464:    */       {
/* 465:520 */         if (this.config.getString("urlRedirect").equals("false")) {
/* 466:521 */           request.getSession().setAttribute("usuarioPets", usuarioPets);
/* 467:    */         }
/* 468:523 */         resultado = "success_pets";app = 'P';
/* 469:524 */         matchNumber++;
/* 470:525 */         request.setAttribute("pets", "");
/* 471:526 */         servidor = servidoresDAO.retrive(usuarioPets.getUsup_servidor_cod());
/* 472:    */       }
/* 473:530 */       if (usuarioCar.getUsuc_cod() != null)
/* 474:    */       {
/* 475:531 */         if (this.config.getString("urlRedirect").equals("false")) {
/* 476:532 */           request.getSession().setAttribute("usuarioCar", usuarioCar);
/* 477:    */         }
/* 478:534 */         resultado = "success_car";app = 'C';
/* 479:535 */         matchNumber++;
/* 480:536 */         request.setAttribute("car", "");
/* 481:537 */         servidor = servidoresDAO.retrive(usuarioCar.getUsuc_servidor_cod());
/* 482:    */       }
/* 483:542 */       if ((existeFamily) || (existePets) || (existeCar))
/* 484:    */       {
/* 485:543 */         if (matchNumber == 0)
/* 486:    */         {
/* 487:544 */           request.setAttribute("FAILURE", getResources(request).getMessage(locale, "main.login.passwordNoPertenece"));
/* 488:545 */           resultado = "failure";
/* 489:    */         }
/* 490:546 */         else if (matchNumber == 1)
/* 491:    */         {
/* 492:547 */           if (this.config.getString("urlRedirect").equals("false")) {
/* 493:548 */             if ((soloLecturaFamily) || (soloLecturaPets) || (soloLecturaCar)) {
/* 494:549 */               request.getSession().setAttribute("soloLectura", "true");
/* 495:    */             } else {
/* 496:551 */               request.getSession().removeAttribute("soloLectura");
/* 497:    */             }
/* 498:    */           }
/* 499:    */         }
/* 500:554 */         else if (matchNumber > 1)
/* 501:    */         {
/* 502:555 */           if (loginForm.getAplicacion().equals("family"))
/* 503:    */           {
/* 504:556 */             if (this.config.getString("urlRedirect").equals("false")) {
/* 505:557 */               if (soloLecturaFamily) {
/* 506:558 */                 request.getSession().setAttribute("soloLectura", "true");
/* 507:    */               } else {
/* 508:560 */                 request.getSession().removeAttribute("soloLectura");
/* 509:    */               }
/* 510:    */             }
/* 511:563 */             resultado = "success_family";app = 'F';
/* 512:    */           }
/* 513:565 */           else if (loginForm.getAplicacion().equals("pets"))
/* 514:    */           {
/* 515:566 */             if (this.config.getString("urlRedirect").equals("false")) {
/* 516:567 */               if (soloLecturaPets) {
/* 517:568 */                 request.getSession().setAttribute("soloLectura", "true");
/* 518:    */               } else {
/* 519:570 */                 request.getSession().removeAttribute("soloLectura");
/* 520:    */               }
/* 521:    */             }
/* 522:573 */             resultado = "success_pets";app = 'P';
/* 523:    */           }
/* 524:575 */           else if (loginForm.getAplicacion().equals("car"))
/* 525:    */           {
/* 526:576 */             if (this.config.getString("urlRedirect").equals("false")) {
/* 527:577 */               if (soloLecturaCar) {
/* 528:578 */                 request.getSession().setAttribute("soloLectura", "true");
/* 529:    */               } else {
/* 530:580 */                 request.getSession().removeAttribute("soloLectura");
/* 531:    */               }
/* 532:    */             }
/* 533:583 */             resultado = "success_car";app = 'C';
/* 534:    */           }
/* 535:    */           else
/* 536:    */           {
/* 537:586 */             request.setAttribute("mostrarModulos", "true");
/* 538:587 */             resultado = "success";
/* 539:    */           }
/* 540:    */         }
/* 541:591 */         if ((resultado.equals("success_family")) || (resultado.equals("success_pets")) || (resultado.equals("success_car")))
/* 542:    */         {
/* 543:593 */           if (this.config.getString("urlRedirect").equals("false")) {
/* 544:595 */             request.getSession().setAttribute("servidor", servidor);
/* 545:    */           }
/* 546:598 */          // if ((resultado.equals("success_family")) && 
/* 547:599 */          //   (compras_licenciasFamily != null) && (ManejoFechas.restaFechas(ManejoFechas.getChangeFecha(compras_licenciasFamily.getCompras_licencias_dattl().toString()), ManejoFechas.getFechaActual().toString()) >= 0))
/* 548:    */          // {
/* 549:600 */          //   existeFamily = false;
/* 550:601 */          //   throw new Exception(getResources(request).getMessage(locale, "errors.loginLicVen"));
/* 551:    */          // }
/* 552:605 */          // if ((resultado.equals("success_pets")) && 
/* 553:606 */          //   (compras_licenciasPets != null) && (ManejoFechas.restaFechas(ManejoFechas.getChangeFecha(compras_licenciasPets.getCompras_licencias_dattl().toString()), ManejoFechas.getFechaActual().toString()) >= 0))
/* 554:    */          // {
/* 555:607 */          //   existePets = false;
/* 556:608 */          //   throw new Exception(getResources(request).getMessage(locale, "errors.loginLicVen"));
/* 557:    */          // }
/* 558:612 */          // if ((resultado.equals("success_car")) && 
/* 559:613 */          //   (compras_licenciasCar != null) && (ManejoFechas.restaFechas(ManejoFechas.getChangeFecha(compras_licenciasCar.getCompras_licencias_dattl().toString()), ManejoFechas.getFechaActual().toString()) >= 0))
/* 560:    */          // {
/* 561:614 */          //   existeCar = false;
/* 562:615 */          //   throw new Exception(getResources(request).getMessage(locale, "errors.loginLicVen"));
/* 563:    */          // }
/* 564:637 */           if (this.config.getString("urlRedirect").equals("true"))
/* 565:    */           {
/* 566:638 */             int i = servidor.getServ_ip().indexOf(":");
/* 567:639 */             new Socket(i == -1 ? servidor.getServ_ip() : servidor.getServ_ip().substring(0, i), i == -1 ? 80 : Integer.parseInt(servidor.getServ_ip().substring(++i)));
/* 568:    */             
/* 569:641 */             IntercambioDatos intercambioDatos = new IntercambioDatos();
/* 570:642 */             InicializaData.inicializa(IntercambioDatos.class, intercambioDatos);
///* 571:643 */             intercambioDatos.setIdioma(request.getSession().getAttribute("idioma").toString());
                          intercambioDatos.setIdioma(language);
/* 572:644 */             intercambioDatos.setServ_cod(servidor.getServ_cod());
/* 573:645 */             intercambioDatos.setServ_ip(servidor.getServ_ip());
/* 574:    */             
/* 575:647 */             String to = "http://" + servidor.getServ_ip() + "/ServiDoctor/reloadLoginData.do";
/* 576:648 */             if (((resultado.equals("success_family")) || (resultado.equals("success_pets")) || (resultado.equals("success_car"))) && (!request.getHeader("referer").equals(to)))
/* 577:    */             {
/* 578:649 */               Map<String, String> parameters = new HashMap();
/* 579:650 */               if (resultado.equals("success_family"))
/* 580:    */               {
/* 581:651 */                 intercambioDatos.setUsu_cod(usuarioFamily.getUsuf_cod());
/* 582:652 */                 intercambioDatos.setUsu_licencia(usuarioFamily.getUsuf_licencia());
/* 583:653 */                 intercambioDatos.setUsu_usuario(usuarioFamily.getUsuf_usuario());
/* 584:654 */                 intercambioDatos.setApp(app);
/* 585:655 */                 intercambioDatos.setUsu_solo_lectura(soloLecturaFamily ? BigDecimal.ONE : BigDecimal.ZERO);
/* 586:656 */                 intercambioDatos.setUsu_may_cod(usuarioFamily.getUsuf_may_cod());
/* 587:    */               }
/* 588:666 */               else if (resultado.equals("success_pets"))
/* 589:    */               {
/* 590:667 */                 intercambioDatos.setUsu_cod(usuarioPets.getUsup_cod());
/* 591:668 */                 intercambioDatos.setUsu_licencia(usuarioPets.getUsup_licencia());
/* 592:669 */                 intercambioDatos.setUsu_usuario(usuarioPets.getUsup_usuario());
/* 593:670 */                 intercambioDatos.setApp(app);
/* 594:671 */                 intercambioDatos.setUsu_solo_lectura(soloLecturaPets ? BigDecimal.ONE : BigDecimal.ZERO);
/* 595:672 */                 intercambioDatos.setUsu_may_cod(usuarioPets.getUsup_may_cod());
/* 596:    */               }
/* 597:682 */               else if (resultado.equals("success_car"))
/* 598:    */               {
/* 599:683 */                 intercambioDatos.setUsu_cod(usuarioCar.getUsuc_cod());
/* 600:684 */                 intercambioDatos.setUsu_licencia(usuarioCar.getUsuc_licencia());
/* 601:685 */                 intercambioDatos.setUsu_usuario(usuarioCar.getUsuc_usuario());
/* 602:686 */                 intercambioDatos.setApp(app);
/* 603:687 */                 intercambioDatos.setUsu_solo_lectura(soloLecturaCar ? BigDecimal.ONE : BigDecimal.ZERO);
/* 604:688 */                 intercambioDatos.setUsu_may_cod(usuarioCar.getUsuc_may_cod());
/* 605:    */               }
/* 606:699 */               intercambioDatosDAO = new IntercambioDatosDAO();
/* 607:700 */               intercambioDatosDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 608:701 */               intercambioDatosDAO.delete(intercambioDatos);
/* 609:702 */               intercambioDatosDAO.insert(intercambioDatos);
/* 610:    */               
/* 611:704 */               response.sendRedirect(response.encodeURL(to + "?usu_cod=" + intercambioDatos.getUsu_cod()));
/* 612:705 */               parameters.put("usu_cod", intercambioDatos.getUsu_cod());
/* 613:    */               
/* 614:    */ 
/* 615:708 */               response.addCookie(new Cookie("JSESSIONID", request.getSession().getId()));
/* 616:709 */               return null;
/* 617:    */             }
/* 618:    */           }
/* 619:    */         }
/* 620:    */       }
/* 621:    */       else
/* 622:    */       {
/* 623:715 */         request.setAttribute("FAILURE", getResources(request).getMessage(locale, "main.login.loginNoExiste"));
/* 624:716 */         resultado = "failure";
/* 625:    */       }
/* 626:719 */       if (app == 'F')
/* 627:    */       {
/* 628:720 */         request.getSession().removeAttribute("usuarioPets");
/* 629:721 */         request.getSession().removeAttribute("usuarioCar");
/* 630:722 */         DatosPersonalesDAO datosPersonalesDAO = new DatosPersonalesDAO();
/* 631:723 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 632:724 */           datosPersonalesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 633:    */         }

                        
/* 634:726 */         //datosPersonalesDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                      datosPersonalesDAO.setIdioma(language);
/* 635:727 */         request.getSession().setAttribute("datosPersonales", datosPersonalesDAO.retrive(usuarioFamily.getUsuf_cod()));
/* 636:    */       }
/* 637:728 */       else if (app == 'P')
/* 638:    */       {
/* 639:729 */         request.getSession().removeAttribute("usuarioCar");
/* 640:730 */         request.getSession().removeAttribute("usuarioFamily");
/* 641:    */       }
/* 642:731 */       else if (app == 'C')
/* 643:    */       {
/* 644:732 */         request.getSession().removeAttribute("usuarioPets");
/* 645:733 */         request.getSession().removeAttribute("usuarioFamily");
/* 646:    */       }
/* 647:    */     }
/* 648:    */     catch (IOException e)
/* 649:    */     {
/* 650:737 */       request.setAttribute("FAILURE", getResources(request).getMessage(locale, "main.servidorNoDisponible"));
/* 651:738 */       e.printStackTrace();
/* 652:739 */       return mapping.findForward("failure");
/* 653:    */     }
/* 654:    */     catch (SQLException e)
/* 655:    */     {
/* 656:741 */       request.setAttribute("FAILURE", getResources(request).getMessage(locale, "main.servidorNoDisponible"));
/* 657:742 */       e.printStackTrace();
/* 658:743 */       return mapping.findForward("failure");
/* 659:    */     }
/* 660:    */     catch (Exception e)
/* 661:    */     {
/* 662:745 */       request.setAttribute("FAILURE", getResources(request).getMessage(locale, "main.login.loginNoExiste"));
/* 663:746 */       e.printStackTrace();
/* 664:747 */       return mapping.findForward("failure");
/* 665:    */     }
/* 666:750 */     return mapping.findForward(resultado);
/* 667:    */   }
/* 668:    */   
/* 669:    */   private ActionForward performReloadLoginData(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/* 670:    */   {
/* 671:754 */     resultado = null;
/* 672:755 */     String idioma = null;
/* 673:756 */     HttpSession session = null;
/* 674:757 */     IntercambioDatosDAO intercambioDatosDAO = null;
/* 675:758 */     UsuarioFamily usuarioFamily = null;
/* 676:759 */     UsuarioPets usuarioPets = null;
/* 677:760 */     UsuarioCar usuarioCar = null;
/* 678:    */     
/* 679:762 */     Servidores servidor = null;
/* 680:763 */     LogosMayor logoMayor = null;
/* 681:    */     
/* 682:765 */     BigDecimal usu_cod = null;
/* 683:    */     try
/* 684:    */     {
/* 685:767 */       session = request.getSession();
/* 686:    */       try
/* 687:    */       {
/* 688:771 */         char app = 'F';
/* 689:    */         
/* 690:773 */         usuarioFamily = new UsuarioFamily();
/* 691:774 */         usuarioPets = new UsuarioPets();
/* 692:775 */         usuarioCar = new UsuarioCar();
/* 693:    */         
/* 694:777 */         usu_cod = new BigDecimal(request.getParameter("usu_cod"));
/* 695:778 */         intercambioDatosDAO = new IntercambioDatosDAO();
/* 696:779 */         IntercambioDatos intercambioDatos = intercambioDatosDAO.retrive(usu_cod);
/* 697:780 */         if (intercambioDatos.getUsu_cod() == null)
/* 698:    */         {
/* 699:781 */           resultado = "failure";
/* 700:    */         }
/* 701:    */         else
/* 702:    */         {
/* 703:783 */           String licencia = null;
/* 704:784 */           String usu_usuario = null;
/* 705:785 */           BigDecimal usu_logm_cod = null;
/* 706:786 */           boolean soloLectura = false;
/* 707:789 */           if (soloLectura) {
/* 708:790 */             session.setAttribute("soloLectura", "true");
/* 709:    */           } else {
/* 710:792 */             session.removeAttribute("soloLectura");
/* 711:    */           }
/* 712:795 */           licencia = intercambioDatos.getUsu_licencia();
/* 713:796 */           usu_usuario = intercambioDatos.getUsu_usuario();
/* 714:797 */           usu_logm_cod = intercambioDatos.getLogm_cod();
/* 715:798 */           idioma = intercambioDatos.getIdioma();

                        System.out.println("idiomaintercambio:" + idioma);
/* 716:799 */           soloLectura = intercambioDatos.getUsu_solo_lectura().equals(BigDecimal.ONE);
/* 717:800 */           String codigoMayor = intercambioDatos.getUsu_may_cod();
/* 718:    */           
/* 719:802 */           servidor = new Servidores();
/* 720:803 */           servidor.setServ_cod(intercambioDatos.getServ_cod());
/* 721:804 */           servidor.setServ_ip(intercambioDatos.getServ_ip());
/* 722:805 */           session.setAttribute("servidor", servidor);
/* 723:    */           
/* 724:807 */           logoMayor = new LogosMayor();
/* 725:808 */           logoMayor.setLogm_cod(usu_logm_cod);
/* 726:809 */           logoMayor.setLogm_ruta(intercambioDatos.getLogm_ruta());
/* 727:810 */           logoMayor.setLogm_link(intercambioDatos.getLogm_link());
/* 728:811 */           logoMayor.setLogm_left_text(intercambioDatos.getLogm_left_text());
/* 729:812 */           logoMayor.setLogm_link_text(intercambioDatos.getLogm_link_text());
/* 730:    */           
/* 731:814 */           app = intercambioDatos.getApp().charAt(0);
/* 732:816 */           if (app == 'F')
/* 733:    */           {
/* 734:817 */             usuarioFamily.setUsuf_cod(usu_cod);
/* 735:818 */             usuarioFamily.setUsuf_licencia(licencia);
/* 736:819 */             usuarioFamily.setUsuf_usuario(usu_usuario);
/* 737:820 */             usuarioFamily.setUsuf_logm_cod(usu_logm_cod);
/* 738:821 */             usuarioFamily.setUsuf_may_cod(codigoMayor);
/* 739:822 */             session.setAttribute("usuarioFamily", usuarioFamily);
/* 740:823 */             session.removeAttribute("usuarioPets");
/* 741:824 */             session.removeAttribute("usuarioCar");
/* 742:825 */             resultado = "success_family";
/* 743:    */           }
/* 744:826 */           else if (app == 'P')
/* 745:    */           {
/* 746:827 */             usuarioPets.setUsup_cod(usu_cod);
/* 747:828 */             usuarioPets.setUsup_licencia(licencia);
/* 748:829 */             usuarioPets.setUsup_usuario(usu_usuario);
/* 749:830 */             usuarioPets.setUsup_logm_cod(usu_logm_cod);
/* 750:831 */             usuarioPets.setUsup_may_cod(codigoMayor);
/* 751:832 */             session.setAttribute("usuarioPets", usuarioPets);
/* 752:833 */             session.removeAttribute("usuarioCar");
/* 753:834 */             session.removeAttribute("usuarioFamily");
/* 754:835 */             resultado = "success_pets";
/* 755:    */           }
/* 756:836 */           else if (app == 'C')
/* 757:    */           {
/* 758:837 */             usuarioCar.setUsuc_cod(usu_cod);
/* 759:838 */             usuarioCar.setUsuc_licencia(licencia);
/* 760:839 */             usuarioCar.setUsuc_usuario(usu_usuario);
/* 761:840 */             usuarioCar.setUsuc_logm_cod(usu_logm_cod);
/* 762:841 */             usuarioCar.setUsuc_may_cod(codigoMayor);
/* 763:842 */             session.setAttribute("usuarioCar", usuarioCar);
/* 764:843 */             session.removeAttribute("usuarioPets");
/* 765:844 */             session.removeAttribute("usuarioFamily");
/* 766:845 */             resultado = "success_car";
/* 767:    */           }
/* 768:847 */           session.setAttribute("logo", logoMayor.getLogm_ruta() + '^' + logoMayor.getLogm_link() + '^' + logoMayor.getLogm_left_text() + '^' + logoMayor.getLogm_link_text() + '^' + app);
/* 769:    */           
/* 770:849 */           updateLanguage(request, response, idioma);
/* 771:850 */           response.addCookie(new Cookie("JSESSIONID", session.getId()));
/* 772:    */         }
/* 773:852 */         intercambioDatosDAO.delete(intercambioDatos);
/* 774:    */       }
/* 775:    */       catch (Exception e)
/* 776:    */       {
/* 777:855 */         if (session.getAttribute("usuarioFamily") != null) {
/* 778:856 */           resultado = "success_family";
/* 779:857 */         } else if (session.getAttribute("usuarioPets") != null) {
/* 780:858 */           resultado = "success_pets";
/* 781:859 */         } else if (session.getAttribute("usuarioCar") != null) {
/* 782:860 */           resultado = "success_car";
/* 783:    */         }
/* 784:862 */         updateLanguage(request, response, session.getAttribute("idioma").toString());
/* 785:    */       }
/* 786:870 */       return mapping.findForward(resultado);
/* 787:    */     }
/* 788:    */     catch (Exception e)
/* 789:    */     {
/* 790:866 */       e.printStackTrace();
/* 791:867 */       resultado = "failure";
/* 792:    */     }
/* 793:    */   }
/* 794:    */   
/* 795:    */   private void updateLanguage(HttpServletRequest request, HttpServletResponse response, String languageId)
/* 796:    */     throws Exception
/* 797:    */   {
                 System.out.println("probando antes");
/* 798:874 */     HttpSession session = request.getSession();
/* 799:875 */     Locale locale = null;
/* 800:876 */     if ((languageId != null) && (languageId.length() > 1)) {
/* 801:877 */       locale = new Locale(languageId.substring(0, 2).toLowerCase());
/* 802:    */     } else {
/* 803:879 */       locale = Locale.getDefault();
/* 804:    */     }
/* 805:882 */     Config.set(session, "javax.servlet.jsp.jstl.fmt.locale", locale);
/* 806:883 */     session.setAttribute("org.apache.struts.action.LOCALE", locale);
/* 807:884 */     response.setLocale(locale);
/* 808:885 */     setLocale(request, locale);
/* 809:886 */     response.setHeader("Locale", locale.toString());
/* 810:887 */     session.setAttribute("idioma", locale.getLanguage().toLowerCase());
/* 811:888 */     session.setMaxInactiveInterval(300);
/* 812:889 */     updateCookie(response, locale);
System.out.println("probando despues");
/* 813:    */   }
/* 814:    */   
/* 815:    */   public static void updateCookie(HttpServletResponse response, Locale locale)
/* 816:    */   {
/* 817:892 */     Cookie languageIdCookie = new Cookie("GUEST_LANGUAGE_ID", locale.getLanguage());
/* 818:893 */     languageIdCookie.setPath("/");
/* 819:894 */     languageIdCookie.setMaxAge(31536000);
/* 820:    */     
/* 821:896 */     response.addCookie(languageIdCookie);
/* 822:    */   }
/* 823:    */   
/* 824:    */   public void sendRedirect(HttpServletRequest request, HttpServletResponse response, String location, Map<String, String> parameters)
/* 825:    */     throws IOException
/* 826:    */   {
/* 827:903 */     StringBuffer buffer = new StringBuffer();
/* 828:    */     
/* 829:    */ 
/* 830:906 */     Enumeration enumeration = request.getParameterNames();
/* 831:    */     String value;
/* 832:909 */     while (enumeration.hasMoreElements())
/* 833:    */     {
/* 834:910 */       String param = (String)enumeration.nextElement();
/* 835:911 */       value = request.getParameter(param);
/* 836:912 */       buffer.append(URLEncoder.encode(param) + "=" + 
/* 837:913 */         URLEncoder.encode(value) + "&");
/* 838:    */     }
/* 839:916 */     for (String param : parameters.keySet())
/* 840:    */     {
/* 841:917 */       String value = (String)parameters.get(param);
/* 842:918 */       buffer.append(URLEncoder.encode(param) + "=" + 
/* 843:919 */         URLEncoder.encode(value) + "&");
/* 844:    */     }
/* 845:923 */     URLConnection ucon = null;
/* 846:924 */     HttpURLConnection con = null;
/* 847:    */     try
/* 848:    */     {
/* 849:926 */       URL url = new URL(location);
/* 850:927 */       ucon = url.openConnection();
/* 851:928 */       if ((ucon instanceof HttpURLConnection)) {
/* 852:929 */         con = (HttpURLConnection)ucon;
/* 853:    */       } else {
/* 854:931 */         return;
/* 855:    */       }
/* 856:    */     }
/* 857:    */     catch (Exception e)
/* 858:    */     {
/* 859:934 */       System.out.println(enumeration);
/* 860:935 */       throw new IOException("Can not connect to " + location);
/* 861:    */     }
/* 862:937 */     con.setRequestMethod("POST");
/* 863:938 */     con.setDoOutput(true);
/* 864:939 */     con.connect();
/* 865:    */     
/* 866:    */ 
/* 867:942 */     con.getOutputStream().write(new String(buffer).getBytes());
/* 868:    */     
/* 869:    */ 
/* 870:945 */     PrintWriter out = response.getWriter();
/* 871:946 */     InputStream in = con.getInputStream();
/* 872:947 */     BufferedReader reader = new BufferedReader(new InputStreamReader(in));
/* 873:    */     
/* 874:    */ 
/* 875:950 */     String line = null;
/* 876:951 */     while ((line = reader.readLine()) != null) {
/* 877:952 */       out.println(line);
/* 878:    */     }
/* 879:956 */     response.setStatus(307);
/* 880:957 */     response.setHeader("Location", location);
/* 881:    */   }
/* 882:    */ }



/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\

 * Qualified Name:     com.servidoctor.seguridad.controller.LogoutAction

 * JD-Core Version:    0.7.0.1

 */