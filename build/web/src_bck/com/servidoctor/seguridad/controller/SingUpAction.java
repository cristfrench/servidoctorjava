/*   1:    */ package com.servidoctor.seguridad.controller;
/*   2:    */ 
/*   3:    */ import com.maxmind.geoip.Country;
/*   4:    */ import com.maxmind.geoip.LookupService;
/*   5:    */ import com.servidoctor.parametros.dao.PaisDAO;
/*   6:    */ import com.servidoctor.parametros.model.Paises;
/*   7:    */ import com.servidoctor.seguridad.dao.Compras_licenciasDAO;
/*   8:    */ import com.servidoctor.seguridad.dao.Compras_merchantDAO;
/*   9:    */ import com.servidoctor.seguridad.dao.Compras_productosDAO;
/*  10:    */ import com.servidoctor.seguridad.dao.GrupoSegmentacionDAO;
/*  11:    */ import com.servidoctor.seguridad.dao.GrupoUsuarioSegmentacionDAO;
/*  12:    */ import com.servidoctor.seguridad.dao.ServidoresDAO;
/*  13:    */ import com.servidoctor.seguridad.dao.UsuarioCarDAO;
/*  14:    */ import com.servidoctor.seguridad.dao.UsuarioFamilyDAO;
/*  15:    */ import com.servidoctor.seguridad.dao.UsuarioPetsDAO;
/*  16:    */ import com.servidoctor.seguridad.model.Compras_licencias;
/*  17:    */ import com.servidoctor.seguridad.model.Compras_merchant;
/*  18:    */ import com.servidoctor.seguridad.model.Compras_productos;
/*  19:    */ import com.servidoctor.seguridad.model.GrupoSegmentacion;
/*  20:    */ import com.servidoctor.seguridad.model.GrupoUsuarioSegmentacion;
/*  21:    */ import com.servidoctor.seguridad.model.UsuarioCar;
/*  22:    */ import com.servidoctor.seguridad.model.UsuarioFamily;
/*  23:    */ import com.servidoctor.seguridad.model.UsuarioPets;
/*  24:    */ import com.servidoctor.util.classes.InicializaData;
/*  25:    */ import com.servidoctor.util.classes.ManejoFechas;
/*  26:    */ import java.io.PrintStream;
/*  27:    */ import java.math.BigDecimal;
/*  28:    */ import java.sql.SQLException;
/*  29:    */ import java.sql.Timestamp;
/*  30:    */ import java.text.SimpleDateFormat;
/*  31:    */ import java.util.Calendar;
/*  32:    */ import java.util.Date;
/*  33:    */ import java.util.GregorianCalendar;
/*  34:    */ import java.util.Iterator;
/*  35:    */ import java.util.List;
/*  36:    */ import java.util.ResourceBundle;
/*  37:    */ import javax.servlet.http.HttpServletRequest;
/*  38:    */ import javax.servlet.http.HttpServletResponse;
/*  39:    */ import net.tanesha.recaptcha.ReCaptchaImpl;
/*  40:    */ import net.tanesha.recaptcha.ReCaptchaResponse;
/*  41:    */ import org.apache.struts.action.Action;
/*  42:    */ import org.apache.struts.action.ActionError;
/*  43:    */ import org.apache.struts.action.ActionErrors;
/*  44:    */ import org.apache.struts.action.ActionForm;
/*  45:    */ import org.apache.struts.action.ActionForward;
/*  46:    */ import org.apache.struts.action.ActionMapping;
/*  47:    */ 
/*  48:    */ public class SingUpAction
/*  49:    */   extends Action
/*  50:    */ {
/*  51: 59 */   private ResourceBundle config = ResourceBundle.getBundle("com.servidoctor.resources.Config");
/*  52:    */   
/*  53:    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*  54:    */     throws Exception
/*  55:    */   {
/*  56: 62 */     ActionForward myforward = null;
/*  57: 63 */     String myaction = mapping.getParameter();
/*  58: 65 */     if ("".equalsIgnoreCase(myaction)) {
/*  59: 66 */       myforward = mapping.findForward("failure");
/*  60: 67 */     } else if ("ACTIVATE".equalsIgnoreCase(myaction)) {
/*  61: 68 */       myforward = performActivate(mapping, form, request, response);
/*  62: 69 */     } else if ("RELOAD_ACTIVATE".equalsIgnoreCase(myaction)) {
/*  63: 70 */       myforward = performReloadActivate(mapping, form, request, response);
/*  64:    */     } else {
/*  65: 72 */       myforward = mapping.findForward("failure");
/*  66:    */     }
/*  67: 74 */     return myforward;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public ActionForward performActivate(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  71:    */     throws Exception
/*  72:    */   {
/*  73: 80 */     SingUpForm form = (SingUpForm)actionForm;
/*  74: 81 */     UsuarioFamilyDAO usuarioFamilyDAO = null;
/*  75: 82 */     UsuarioCarDAO usuarioCarDAO = null;
/*  76: 83 */     UsuarioPetsDAO usuarioPetsDAO = null;
/*  77: 84 */     UsuarioFamily usuarioFamily2 = null;
/*  78: 85 */     UsuarioCar usuarioCar2 = null;
/*  79: 86 */     UsuarioPets usuarioPets2 = null;
/*  80: 87 */     UsuarioFamily usuarioFamily = null;
/*  81: 88 */     UsuarioCar usuarioCar = null;
/*  82: 89 */     UsuarioPets usuarioPets = null;
/*  83: 90 */     String resultado = null;
/*  84:    */     try
/*  85:    */     {
/*  86: 92 */       boolean special = false;
/*  87:    */       
/*  88: 94 */       String remoteAddr = request.getRemoteAddr();
/*  89: 95 */       ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
/*  90: 96 */       reCaptcha.setPrivateKey("6LdOD8ESAAAAAIa7S3BTVvZqgD5ZI2843vthykjL");
/*  91:    */       
/*  92: 98 */       String challenge = request.getParameter("recaptcha_challenge_field") != null ? request.getParameter("recaptcha_challenge_field") : "";
/*  93: 99 */       String uresponse = request.getParameter("recaptcha_response_field") != null ? request.getParameter("recaptcha_response_field") : "";
/*  94:100 */       if ((challenge != "") && (uresponse != ""))
/*  95:    */       {
/*  96:101 */         ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);
/*  97:102 */         System.out.println(remoteAddr);
/*  98:103 */         System.out.println(challenge);
/*  99:104 */         System.out.println(uresponse);
/* 100:106 */         if (!reCaptchaResponse.isValid())
/* 101:    */         {
/* 102:107 */           ActionErrors errors = new ActionErrors();
/* 103:108 */           errors.add("org.apache.struts.action.GLOBAL_ERROR", new ActionError("error.CodigoSuperado"));
/* 104:109 */           saveErrors(request, errors);
/* 105:110 */           resultado = "failure";
/* 106:111 */           return mapping.findForward(resultado);
/* 107:    */         }
/* 108:    */       }
/* 109:116 */       Compras_licenciasDAO compras_licenciasDAO = new Compras_licenciasDAO();
/* 110:117 */       Compras_licencias compras_licencias = compras_licenciasDAO.retrive(form.getCompras_licencias_codact());
/* 111:118 */       Compras_merchantDAO compras_merchantDAO = new Compras_merchantDAO();
/* 112:119 */       Compras_merchant compras_merchant = new Compras_merchant();
/* 113:120 */       Compras_productosDAO compras_productosDAO = new Compras_productosDAO();
/* 114:121 */       Compras_productos compras_productos = new Compras_productos();
/* 115:    */       
/* 116:    */ 
/* 117:    */ 
/* 118:    */ 
/* 119:    */ 
/* 120:127 */       usuarioFamilyDAO = new UsuarioFamilyDAO();
/* 121:128 */       usuarioCarDAO = new UsuarioCarDAO();
/* 122:129 */       usuarioPetsDAO = new UsuarioPetsDAO();
/* 123:130 */       usuarioFamily2 = new UsuarioFamily();
/* 124:131 */       usuarioCar2 = new UsuarioCar();
/* 125:132 */       usuarioPets2 = new UsuarioPets();
/* 126:133 */       String codigoMayor = null;
/* 127:134 */       String codigoPais = null;
/* 128:136 */       if (compras_licencias.getCompras_licencias_codact() == null)
/* 129:    */       {
/* 130:137 */         compras_merchant = compras_merchantDAO.retriveBySpecialCode(form.getCompras_licencias_codact());
/* 131:138 */         if (compras_merchant.getCompras_merchant_cdgcmp() == null)
/* 132:    */         {
/* 133:139 */           ActionErrors errors = new ActionErrors();
/* 134:140 */           errors.add("org.apache.struts.action.GLOBAL_ERROR", new ActionError("errors.noCodigo"));
/* 135:141 */           saveErrors(request, errors);
/* 136:142 */           resultado = "failure";
/* 137:143 */           return mapping.findForward(resultado);
/* 138:    */         }
/* 139:145 */         compras_productos = compras_productosDAO.retrive(compras_merchant.getCompras_merchant_id());
/* 140:146 */         if (compras_productos.getCompras_productos_cantidad().intValue() <= usuarioFamilyDAO.count(form.getCompras_licencias_codact()) + usuarioPetsDAO.count(form.getCompras_licencias_codact()) + usuarioCarDAO.count(form.getCompras_licencias_codact()))
/* 141:    */         {
/* 142:147 */           ActionErrors errors = new ActionErrors();
/* 143:148 */           errors.add("org.apache.struts.action.GLOBAL_ERROR", new ActionError("errors.noCodigo"));
/* 144:149 */           saveErrors(request, errors);
/* 145:150 */           resultado = "failure";
/* 146:151 */           return mapping.findForward(resultado);
/* 147:    */         }
/* 148:153 */         special = true;
/* 149:    */       }
/* 150:158 */       codigoMayor = compras_merchant.getCompras_merchant_cdgcmp();
/* 151:159 */       String tipoLicencia = null;
/* 152:161 */       if (!special)
/* 153:    */       {
/* 154:162 */         if (compras_licencias.getCompras_licencias_actc() != null)
/* 155:    */         {
/* 156:163 */           ActionErrors errors = new ActionErrors();
/* 157:164 */           errors.add("org.apache.struts.action.GLOBAL_ERROR", new ActionError("errors.CodigoAsignado"));
/* 158:165 */           saveErrors(request, errors);
/* 159:166 */           resultado = "failure";
/* 160:167 */           return mapping.findForward(resultado);
/* 161:    */         }
/* 162:170 */         List cmechant = compras_merchantDAO.listPadre(compras_licencias.getCompras_productos_id());
/* 163:171 */         codigoPais = ((Compras_merchant)cmechant.get(0)).getCompras_pais();
/* 164:172 */         String sep = System.getProperty("file.separator");
/* 165:    */         
/* 166:    */ 
/* 167:    */ 
/* 168:    */ 
/* 169:    */ 
/* 170:    */ 
/* 171:    */ 
/* 172:180 */         //String dir = "/usr/local/share/GeoIP";
                      String dir = "C:\\apache-tomcat-7.0.56\\usr\\local\\share\\GeoIP";
/* 173:181 */         String dbfile = dir + sep + "GeoIP.dat";
/* 174:182 */       //  LookupService cl = new LookupService(dbfile, 1);
/* 175:183 */       //  System.out.println(cl.getCountry(request.getRemoteAddr()).getName());
/* 176:    */         
/* 177:    */ 
/* 178:    */ 
/* 179:187 */        // String paisRequest = cl.getCountry(request.getRemoteAddr()).getName().substring(0, 4);
/* 180:188 */        // String paisRequestFinal = cl.getCountry(request.getRemoteAddr()).getName().substring(cl.getCountry(request.getRemoteAddr()).getName().length() - 4, cl.getCountry(request.getRemoteAddr()).getName().length());
/* 181:189 */        // PaisDAO paisDAO = new PaisDAO();
/* 182:190 */        // Paises pais = paisDAO.retrive(new BigDecimal(codigoPais));
/* 183:191 */        // String paisBase = pais.getPais_des().substring(0, 4);
/* 184:192 */        // String paisBaseFinal = pais.getPais_des().substring(pais.getPais_des().length() - 4, pais.getPais_des().length());
/* 185:195 */        // if ((paisBase.compareTo(paisRequest) != 0) || (paisBaseFinal.compareTo(paisRequestFinal) != 0))
/* 186:    */        // {
/* 187:196 */        //   ActionErrors errors = new ActionErrors();
/* 188:197 */        //   errors.add("org.apache.struts.action.GLOBAL_ERROR", new ActionError("error.noPais"));
/* 189:198 */        //   saveErrors(request, errors);
/* 190:199 */        //   resultado = "failure";
/* 191:200 */        //   return mapping.findForward(resultado);
/* 192:    */        // }

/* 193:205 */         Calendar cal = new GregorianCalendar();
/* 194:206 */         Calendar cal2 = new GregorianCalendar();
/* 195:    */         
/* 196:    */ 
/* 197:    */ 
/* 198:    */ 
/* 199:211 */         List compra_licencias = compras_licenciasDAO.listLicencias(((Compras_merchant)cmechant.get(0)).getCompras_merchant_cdgcmp());
/* 200:212 */         int NoUsuarios = compra_licencias.size();                        
/* 201:213 */         int margen = new Integer(((Compras_merchant)cmechant.get(0)).getCompras_margen_emision()).intValue() / 100;
/* 202:214 */         margen++;
/* 203:215 */         int noMaxRegistros = NoUsuarios / margen;
/* 204:216 */         int noRegistrosRealizados = 0;
/* 205:218 */         for (Iterator licenciasIterator = compra_licencias.iterator(); licenciasIterator.hasNext();)
/* 206:    */         {
/* 207:219 */           Compras_licencias licencias = (Compras_licencias)licenciasIterator.next();
/* 208:220 */           if (licencias.getCompras_licencias_actc() != null) {
/* 209:221 */             noRegistrosRealizados++;
/* 210:    */           }
/* 211:    */         }
/* 212:225 */         if (noRegistrosRealizados > noMaxRegistros)
/* 213:    */         {
/* 214:226 */           ActionErrors errors = new ActionErrors();
/* 215:227 */           errors.add("org.apache.struts.action.GLOBAL_ERROR", new ActionError("error.CodigoSuperado"));
/* 216:228 */           saveErrors(request, errors);
/* 217:229 */           resultado = "failure";
/* 218:230 */           return mapping.findForward(resultado);
/* 219:    */         }
/* 220:233 */         StringBuffer fechaaprobacion = new StringBuffer();
/* 221:234 */         StringBuffer fechaAprobacion = new StringBuffer();
/* 222:    */         
/* 223:    */ 
/* 224:    */         
                      if (((Compras_merchant)cmechant.get(0)).getCompras_merchant_date_aprob() != null)
    /* 225:238 */         fechaaprobacion = fechaaprobacion.replace(0, fechaaprobacion.length(), ((Compras_merchant)cmechant.get(0)).getCompras_merchant_date_aprob());
                      else{
                          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                          String fecha = sdf.format(new Date());
                          
                          fechaaprobacion = fechaaprobacion.replace(0, fechaaprobacion.length(), fecha);
                          
                      }
                      
                      String diasactivarmayor = "0";
                      if (((Compras_merchant)cmechant.get(0)).getCompras_dias_activar_mayor()!=null)
    /* 226:239 */         diasactivarmayor = ((Compras_merchant)cmechant.get(0)).getCompras_dias_activar_mayor();
                      
    /* 227:240 */         if (diasactivarmayor.substring(diasactivarmayor.length() - 1, diasactivarmayor.length()).compareTo(",") == 0) {
    /* 228:241 */           diasactivarmayor = diasactivarmayor.substring(0, diasactivarmayor.length() - 1);
    /* 229:    */         } else {
    /* 230:243 */           diasactivarmayor = diasactivarmayor.substring(0, diasactivarmayor.length());
    /* 231:    */         }
    /* 232:244 */         fechaAprobacion = fechaAprobacion.replace(0, fechaAprobacion.length(), fechaaprobacion.substring(0, 4));
    /* 233:245 */         fechaAprobacion = fechaAprobacion.append(fechaaprobacion.substring(5, 7));
    /* 234:246 */         fechaAprobacion = fechaAprobacion.append(fechaaprobacion.substring(8, 10));
    /* 235:    */         System.out.println("fecha4:" + fechaaprobacion);
    /* 236:    */ 
    /* 237:249 */         SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    /* 238:    */         
    /* 239:251 */         cal2.setTime(sdf.parse(fechaAprobacion.toString()));
                          System.out.println("dias activar mayor:" + diasactivarmayor.toString());
    /* 240:252 */         cal2.add(7, new Integer(diasactivarmayor.toString()).intValue());
    /* 241:    */         System.out.println("getTime:" + cal2.getTime());
                          System.out.println("codigo:" + ((Compras_merchant)cmechant.get(0)).getCompras_merchant_cdgcmp());
    /* 242:254 */         Date hoy = new Date();
    /* 243:256 */        // if (hoy.compareTo(cal2.getTime()) == 1)
    /* 244:    */        // {
    /* 245:257 */        //   ActionErrors errors = new ActionErrors();
    /* 246:258 */        //   errors.add("org.apache.struts.action.GLOBAL_ERROR", new ActionError("error.CodigoCancelado"));
    /* 247:259 */        //   saveErrors(request, errors);
    /* 248:260 */        //   resultado = "failure";
    /* 249:261 */        //   return mapping.findForward(resultado);
    /* 250:    */        // }
                      
/* 251:264 */         compras_licencias.setCompras_licencias_actc(new Timestamp(System.currentTimeMillis()));
/* 252:    */         
/* 253:266 */         cal.setTime(compras_licencias.getCompras_licencias_actc());
/* 254:267 */         cal.add(2, compras_licencias.getCompras_licencias_nma().intValue());
/* 255:268 */         compras_licencias.setCompras_licencias_dattl(cal.getTime());
/* 256:269 */         tipoLicencia = compras_licencias.getGrp_precio_id().toString();
/* 257:    */       }
/* 258:    */       else
/* 259:    */       {
/* 260:271 */         tipoLicencia = compras_productos.getGrp_precio_id().toString();
                         
/* 261:272 */         if (((tipoLicencia.compareTo("5") == 0) || (tipoLicencia.compareTo("6") == 0) || (tipoLicencia.compareTo("7") == 0) || (tipoLicencia.compareTo("8") == 0)) && 
/* 262:273 */           (!form.getAplicacion().equals("family")) && (!form.getAplicacion().equals("car")) && (!form.getAplicacion().equals("pets")))
/* 263:    */         {
/* 264:274 */           request.setAttribute("mostrarModulos2", "true");
/* 265:276 */           if (tipoLicencia.equals("5"))
/* 266:    */           {
/* 267:278 */             request.setAttribute("familyespecial", "");
/* 268:279 */             request.setAttribute("petsespecial", "");
/* 269:    */           }
/* 270:281 */           if (tipoLicencia.equals("6"))
/* 271:    */           {
/* 272:283 */             request.setAttribute("familyespecial", "");
/* 273:284 */             request.setAttribute("carespecial", "");
/* 274:    */           }
/* 275:287 */           if (tipoLicencia.equals("7"))
/* 276:    */           {
/* 277:289 */             request.setAttribute("carespecial", "");
/* 278:290 */             request.setAttribute("petsespecial", "");
/* 279:    */           }
/* 280:293 */           if (tipoLicencia.equals("8"))
/* 281:    */           {
/* 282:295 */             request.setAttribute("familyespecial", "");
/* 283:296 */             request.setAttribute("petsespecial", "");
/* 284:297 */             request.setAttribute("carespecial", "");
/* 285:    */           }
/* 286:299 */           resultado = "success";
/* 287:300 */           return mapping.findForward(resultado);
/* 288:    */         }
/* 289:    */       }
/* 290:306 */       int tam = 0;
/* 291:307 */       while (tam < 5) {
/* 292:308 */         tam = 6 + (int)(System.currentTimeMillis() % 5L);
/* 293:    */       }
/* 294:311 */       char[] password = new char[tam];
/* 295:313 */       for (int i = 0; i < password.length; i++) {
/* 296:314 */         while ((password[i] < '0') || ((password[i] > '9') && (password[i] < 'A')) || ((password[i] > 'Z') && (password[i] < 'a')) || (password[i] > 'z'))
/* 297:    */         {
/* 298:315 */           int current = (int)(Math.random() * 123.0D);
/* 299:316 */           password[i] = ((char)(current % 123));
/* 300:    */         }
/* 301:    */       }
/* 302:321 */       String licenciaUsuarioEspecial = form.getAplicacion() != null ? form.getAplicacion() : "";
/* 303:324 */       if ((tipoLicencia.equals("1")) || (tipoLicencia.equals("4")) || (licenciaUsuarioEspecial.equals("family")))
/* 304:    */       {
/* 305:325 */         usuarioFamily = new UsuarioFamily();
/* 306:326 */         InicializaData.inicializa(usuarioFamily.getClass(), usuarioFamily);
/* 307:327 */         usuarioFamily.setUsuf_clave(form.getPassword());
System.out.println("clave:" + form.getPassword());
/* 308:328 */         usuarioFamily.setUsuf_clave_emer(String.valueOf(password));
/* 309:329 */         usuarioFamily.setUsuf_usuario(form.getLogin());
System.out.println("email:" + form.getLogin());
/* 310:330 */         usuarioFamily.setUsuf_licencia(!special ? compras_licencias.getCompras_licencias_codact() : compras_merchant.getCompras_merchant_cdgesp());
/* 311:331 */         usuarioFamily.setUsuf_especial(!special ? BigDecimal.ZERO : BigDecimal.ONE);
/* 312:332 */         usuarioFamily.setUsuf_servidor_cod(!special ? compras_licencias.getServer_id() : compras_merchant.getServer_id());
                      if (usuarioFamily.getUsuf_servidor_cod()==null)
                          usuarioFamily.setUsuf_servidor_cod(new BigDecimal(1));
System.out.println("servidor:" + usuarioFamily.getUsuf_servidor_cod());
/* 313:333 */         usuarioFamily.setUsuf_fecha_activacion(new BigDecimal(ManejoFechas.getFechaActual()));
/* 314:334 */         usuarioFamily.setUsuf_may_cod(codigoMayor);
                      usuarioFamily.setUsuf_logm_cod(new BigDecimal(1));
                      
/* 315:335 */         usuarioFamily2 = usuarioFamilyDAO.loginPassword(form.getReLogin(), usuarioFamily.getUsuf_clave());
/* 316:336 */         if (usuarioFamily2.getUsuf_cod() == null)
/* 317:    */         {
/* 318:337 */           Calendar cal = new GregorianCalendar();
/* 319:338 */           SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
/* 320:339 */           String fechaActual = ManejoFechas.getFechaActual().toString();
/* 321:340 */           if (!special) {
/* 322:341 */             cal.setTime(compras_licencias.getCompras_licencias_datgc());
/* 323:    */           } else {
/* 324:343 */             cal.setTime(compras_merchant.getCompras_merchant_datec());
/* 325:    */           }
/* 326:345 */           cal.add(6, 90);
/* 327:    */           
/* 328:347 */           String fecha90s = sdf.format(cal.getTime());
/* 329:348 */           String f90 = sdf.format(cal.getTime());
/* 330:349 */           if ((ManejoFechas.restaFechas(fechaActual, fecha90s) <= 90) && (ManejoFechas.restaFechas(fechaActual, fecha90s) > 0))
/* 331:    */           {
/* 332:350 */             usuarioFamilyDAO.insert(usuarioFamily);
/* 333:352 */             if (special)
/* 334:    */             {
/* 335:354 */               GrupoSegmentacionDAO grupoSegmentacionDAOV = new GrupoSegmentacionDAO();
/* 336:355 */               GrupoSegmentacionDAO grupoSegmentacionDAO2 = new GrupoSegmentacionDAO();
/* 337:356 */               GrupoSegmentacion grupoSegmentacion = new GrupoSegmentacion();
/* 338:357 */               InicializaData.inicializa(grupoSegmentacion.getClass(), grupoSegmentacion);
/* 339:    */               
/* 340:359 */               int numeroGruposCM = grupoSegmentacionDAOV.count(usuarioFamily.getUsuf_may_cod().toString());
/* 341:360 */               if (numeroGruposCM > 0)
/* 342:    */               {
/* 343:362 */                 GrupoUsuarioSegmentacionDAO grupoUsuarioSegmentacionDAOV = new GrupoUsuarioSegmentacionDAO();
/* 344:363 */                 GrupoUsuarioSegmentacion grupoUsuarioSegmentacion = new GrupoUsuarioSegmentacion();
/* 345:364 */                 InicializaData.inicializa(grupoUsuarioSegmentacion.getClass(), grupoUsuarioSegmentacion);
/* 346:365 */                 GrupoUsuarioSegmentacionDAO grupoUsuarioSegmentacionDAO = new GrupoUsuarioSegmentacionDAO();
/* 347:369 */                 if (numeroGruposCM == 1)
/* 348:    */                 {
/* 349:371 */                   GrupoSegmentacion grupoSegmentacion2 = grupoSegmentacionDAO2.retrieve(usuarioFamily.getUsuf_may_cod());
/* 350:373 */                   if (grupoUsuarioSegmentacionDAOV.countUsersPerGroup(usuarioFamily.getUsuf_cod().toString(), grupoSegmentacion2.getConsecutivo().toString()) == 0)
/* 351:    */                   {
/* 352:374 */                     grupoUsuarioSegmentacion.setUsuario_id("F" + usuarioFamily.getUsuf_cod().toString());
/* 353:375 */                     grupoUsuarioSegmentacion.setGrupo_id(grupoSegmentacion2.getConsecutivo());
/* 354:376 */                     grupoUsuarioSegmentacionDAO.insert(grupoUsuarioSegmentacion);
/* 355:    */                   }
/* 356:    */                 }
/* 357:    */               }
/* 358:    */             }
/* 359:382 */             resultado = "success_family";
/* 360:383 */             return mapping.findForward(resultado);
/* 361:    */           }
/* 362:385 */           ActionErrors errors = new ActionErrors();
/* 363:386 */           errors.add("org.apache.struts.action.GLOBAL_ERROR", new ActionError("errors.login.noactivacion"));
/* 364:387 */           saveErrors(request, errors);
/* 365:388 */           resultado = "failure";
/* 366:389 */           return mapping.findForward(resultado);
/* 367:    */         }
/* 368:394 */         ActionErrors errors = new ActionErrors();
/* 369:395 */         errors.add("org.apache.struts.action.GLOBAL_ERROR", new ActionError("errors.login.repetido"));
/* 370:396 */         saveErrors(request, errors);
/* 371:397 */         compras_licencias.setCompras_licencias_dattl(null);
/* 372:398 */         resultado = "failure";
/* 373:399 */         return mapping.findForward(resultado);
/* 374:    */       }
/* 375:404 */       if ((tipoLicencia.equals("2")) || (tipoLicencia.equals("9")) || (licenciaUsuarioEspecial.equals("car")))
/* 376:    */       {
/* 377:405 */         usuarioCar = new UsuarioCar();
/* 378:406 */         InicializaData.inicializa(usuarioCar.getClass(), usuarioCar);
/* 379:407 */         usuarioCar.setUsuc_clave(form.getPassword());
/* 380:408 */         usuarioCar.setUsuc_clave_emer(String.valueOf(password));
/* 381:409 */         usuarioCar.setUsuc_usuario(form.getReLogin());
/* 382:410 */         usuarioCar.setUsuc_licencia(!special ? compras_licencias.getCompras_licencias_codact() : compras_merchant.getCompras_merchant_cdgesp());
/* 383:411 */         usuarioCar.setUsuc_especial(!special ? BigDecimal.ZERO : BigDecimal.ONE);
/* 384:412 */         usuarioCar.setUsuc_servidor_cod(!special ? compras_licencias.getServer_id() : compras_merchant.getServer_id());
                      if (usuarioCar.getUsuc_servidor_cod()==null)
                          usuarioCar.setUsuc_servidor_cod(new BigDecimal(1));
/* 385:413 */         usuarioCar.setUsuc_fecha_activacion(new BigDecimal(ManejoFechas.getFechaActual()));
/* 386:414 */         usuarioCar.setUsuc_may_cod(codigoMayor);
                      usuarioCar.setUsuc_logm_cod(new BigDecimal(1));
/* 387:415 */         usuarioCar2 = usuarioCarDAO.loginPassword(form.getReLogin(), usuarioCar.getUsuc_clave());
/* 388:416 */         if (usuarioCar2.getUsuc_cod() == null)
/* 389:    */         {
/* 390:417 */           Calendar cal = new GregorianCalendar();
/* 391:418 */           SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
/* 392:419 */           String fechaActual = ManejoFechas.getFechaActual().toString();
/* 393:420 */           if (!special) {
/* 394:421 */             cal.setTime(compras_licencias.getCompras_licencias_datgc());
/* 395:    */           } else {
/* 396:423 */             cal.setTime(compras_merchant.getCompras_merchant_datec());
/* 397:    */           }
/* 398:425 */           cal.add(6, 90);
/* 399:    */           
/* 400:427 */           String fecha90s = sdf.format(cal.getTime());
/* 401:428 */           String f90 = sdf.format(cal.getTime());
/* 402:429 */           if ((ManejoFechas.restaFechas(fechaActual, f90) <= 90) && (ManejoFechas.restaFechas(fechaActual, fecha90s) > 0))
/* 403:    */           {
/* 404:430 */             usuarioCarDAO.insert(usuarioCar);
/* 405:431 */             if (special)
/* 406:    */             {
/* 407:433 */               GrupoSegmentacionDAO grupoSegmentacionDAOV = new GrupoSegmentacionDAO();
/* 408:434 */               GrupoSegmentacionDAO grupoSegmentacionDAO2 = new GrupoSegmentacionDAO();
/* 409:435 */               GrupoSegmentacion grupoSegmentacion = new GrupoSegmentacion();
/* 410:436 */               InicializaData.inicializa(grupoSegmentacion.getClass(), grupoSegmentacion);
/* 411:    */               
/* 412:438 */               int numeroGruposCM = grupoSegmentacionDAOV.count(usuarioCar.getUsuc_may_cod().toString());
/* 413:439 */               if (numeroGruposCM > 0)
/* 414:    */               {
/* 415:441 */                 GrupoUsuarioSegmentacionDAO grupoUsuarioSegmentacionDAOV = new GrupoUsuarioSegmentacionDAO();
/* 416:442 */                 GrupoUsuarioSegmentacion grupoUsuarioSegmentacion = new GrupoUsuarioSegmentacion();
/* 417:443 */                 InicializaData.inicializa(grupoUsuarioSegmentacion.getClass(), grupoUsuarioSegmentacion);
/* 418:444 */                 GrupoUsuarioSegmentacionDAO grupoUsuarioSegmentacionDAO = new GrupoUsuarioSegmentacionDAO();
/* 419:448 */                 if (numeroGruposCM == 1)
/* 420:    */                 {
/* 421:450 */                   GrupoSegmentacion grupoSegmentacion2 = grupoSegmentacionDAO2.retrieve(usuarioCar.getUsuc_may_cod());
/* 422:452 */                   if (grupoUsuarioSegmentacionDAOV.countUsersPerGroup(usuarioCar.getUsuc_cod().toString(), grupoSegmentacion2.getConsecutivo().toString()) == 0)
/* 423:    */                   {
/* 424:453 */                     grupoUsuarioSegmentacion.setUsuario_id("C" + usuarioCar.getUsuc_cod().toString());
/* 425:454 */                     grupoUsuarioSegmentacion.setGrupo_id(grupoSegmentacion2.getConsecutivo());
/* 426:455 */                     grupoUsuarioSegmentacionDAO.insert(grupoUsuarioSegmentacion);
/* 427:    */                   }
/* 428:    */                 }
/* 429:    */               }
/* 430:    */             }
/* 431:461 */             resultado = "success_car";
/* 432:462 */             return mapping.findForward(resultado);
/* 433:    */           }
/* 434:464 */           ActionErrors errors = new ActionErrors();
/* 435:465 */           errors.add("org.apache.struts.action.GLOBAL_ERROR", new ActionError("errors.login.noactivacion"));
/* 436:466 */           saveErrors(request, errors);
/* 437:467 */           resultado = "failure";
/* 438:468 */           return mapping.findForward(resultado);
/* 439:    */         }
/* 440:472 */         ActionErrors errors = new ActionErrors();
/* 441:473 */         errors.add("org.apache.struts.action.GLOBAL_ERROR", new ActionError("errors.login.repetido"));
/* 442:474 */         saveErrors(request, errors);
/* 443:475 */         compras_licencias.setCompras_licencias_dattl(null);
/* 444:476 */         resultado = "failure";
/* 445:477 */         return mapping.findForward(resultado);
/* 446:    */       }
/* 447:481 */       if ((tipoLicencia.equals("3")) || (tipoLicencia.equals("10")) || (licenciaUsuarioEspecial.equals("pets")))
/* 448:    */       {
/* 449:482 */         usuarioPets = new UsuarioPets();
/* 450:483 */         InicializaData.inicializa(usuarioPets.getClass(), usuarioPets);
/* 451:484 */         usuarioPets.setUsup_clave(form.getPassword());
/* 452:485 */         usuarioPets.setUsup_clave_emer(String.valueOf(password));
/* 453:486 */         usuarioPets.setUsup_usuario(form.getReLogin());
/* 454:487 */         usuarioPets.setUsup_licencia(!special ? compras_licencias.getCompras_licencias_codact() : compras_merchant.getCompras_merchant_cdgesp());
/* 455:488 */         usuarioPets.setUsup_especial(!special ? BigDecimal.ZERO : BigDecimal.ONE);
/* 456:489 */         usuarioPets.setUsup_servidor_cod(!special ? compras_licencias.getServer_id() : compras_merchant.getServer_id());
                      if (usuarioPets.getUsup_servidor_cod()==null)
                          usuarioPets.setUsup_servidor_cod(new BigDecimal(1));
/* 457:490 */         usuarioPets.setUsup_fecha_activacion(new BigDecimal(ManejoFechas.getFechaActual()));
/* 458:491 */         usuarioPets.setUsup_may_cod(codigoMayor);
                      usuarioPets.setUsup_logm_cod(new BigDecimal(1));
/* 459:492 */         usuarioPets2 = usuarioPetsDAO.loginPassword(form.getReLogin(), usuarioPets.getUsup_clave());
/* 460:493 */         if (usuarioPets2.getUsup_cod() == null)
/* 461:    */         {
/* 462:494 */           Calendar cal = new GregorianCalendar();
/* 463:495 */           SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
/* 464:496 */           String fechaActual = ManejoFechas.getFechaActual().toString();
/* 465:497 */           if (!special) {
/* 466:498 */             cal.setTime(compras_licencias.getCompras_licencias_datgc());
/* 467:    */           } else {
/* 468:500 */             cal.setTime(compras_merchant.getCompras_merchant_datec());
/* 469:    */           }
/* 470:502 */           cal.add(6, 90);/* 471:    */           
/* 472:504 */           String fecha90s = sdf.format(cal.getTime());
/* 473:505 */           String f90 = sdf.format(cal.getTime());
/* 474:506 */           if ((ManejoFechas.restaFechas(fechaActual, f90) <= 90) && (ManejoFechas.restaFechas(fechaActual, fecha90s) > 0))
/* 475:    */           {
/* 476:507 */             usuarioPetsDAO.insert(usuarioPets);
/* 477:508 */             if (special)
/* 478:    */             {
/* 479:510 */               GrupoSegmentacionDAO grupoSegmentacionDAOV = new GrupoSegmentacionDAO();
/* 480:511 */               GrupoSegmentacionDAO grupoSegmentacionDAO2 = new GrupoSegmentacionDAO();
/* 481:512 */               GrupoSegmentacion grupoSegmentacion = new GrupoSegmentacion();
/* 482:513 */               InicializaData.inicializa(grupoSegmentacion.getClass(), grupoSegmentacion);
/* 483:    */               
/* 484:515 */               int numeroGruposCM = grupoSegmentacionDAOV.count(usuarioPets.getUsup_may_cod().toString());
/* 485:516 */               if (numeroGruposCM > 0)
/* 486:    */               {
/* 487:518 */                 GrupoUsuarioSegmentacionDAO grupoUsuarioSegmentacionDAOV = new GrupoUsuarioSegmentacionDAO();
/* 488:519 */                 GrupoUsuarioSegmentacion grupoUsuarioSegmentacion = new GrupoUsuarioSegmentacion();
/* 489:520 */                 InicializaData.inicializa(grupoUsuarioSegmentacion.getClass(), grupoUsuarioSegmentacion);
/* 490:521 */                 GrupoUsuarioSegmentacionDAO grupoUsuarioSegmentacionDAO = new GrupoUsuarioSegmentacionDAO();
/* 491:525 */                 if (numeroGruposCM == 1)
/* 492:    */                 {
/* 493:527 */                   GrupoSegmentacion grupoSegmentacion2 = grupoSegmentacionDAO2.retrieve(usuarioPets.getUsup_may_cod());
/* 494:529 */                   if (grupoUsuarioSegmentacionDAOV.countUsersPerGroup(usuarioPets.getUsup_cod().toString(), grupoSegmentacion2.getConsecutivo().toString()) == 0)
/* 495:    */                   {
/* 496:530 */                     grupoUsuarioSegmentacion.setUsuario_id("P" + usuarioPets.getUsup_cod().toString());
/* 497:531 */                     grupoUsuarioSegmentacion.setGrupo_id(grupoSegmentacion2.getConsecutivo());
/* 498:532 */                     grupoUsuarioSegmentacionDAO.insert(grupoUsuarioSegmentacion);
/* 499:    */                   }
/* 500:    */                 }
/* 501:    */               }
/* 502:    */             }
/* 503:538 */             resultado = "success_pets";
/* 504:539 */             return mapping.findForward(resultado);
/* 505:    */           }
/* 506:541 */           ActionErrors errors = new ActionErrors();
/* 507:542 */           errors.add("org.apache.struts.action.GLOBAL_ERROR", new ActionError("errors.login.noactivacion"));
/* 508:543 */           saveErrors(request, errors);
/* 509:544 */           resultado = "failure";
/* 510:545 */           return mapping.findForward(resultado);
/* 511:    */         }
/* 512:550 */         ActionErrors errors = new ActionErrors();
/* 513:551 */         errors.add("org.apache.struts.action.GLOBAL_ERROR", new ActionError("errors.login.repetido"));
/* 514:552 */         saveErrors(request, errors);
/* 515:553 */         compras_licencias.setCompras_licencias_dattl(null);
/* 516:554 */         resultado = "failure";
/* 517:555 */         return mapping.findForward(resultado);
/* 518:    */       }
/* 519:560 */       int matchNumber = 0;
/* 520:562 */       if (!special) {
/* 521:563 */         compras_licenciasDAO.update(compras_licencias);
/* 522:    */       }
/* 523:566 */       if (this.config.getString("countActivations").equals("true")) {
/* 524:567 */         actualizarServidor(!special ? compras_licencias.getServer_id() : compras_merchant.getServer_id());
/* 525:    */       }
/* 526:    */     }
/* 527:    */     catch (SQLException e)
/* 528:    */     {
/* 529:571 */       if (e.getErrorCode() == 1062)
/* 530:    */       {
/* 531:572 */         ActionErrors errors = new ActionErrors();
/* 532:573 */         errors.add("org.apache.struts.action.GLOBAL_ERROR", new ActionError("errors.login.duplicado"));
/* 533:574 */         saveErrors(request, errors);
/* 534:575 */         resultado = "failure";
/* 535:576 */         return mapping.findForward(resultado);
/* 536:    */       }
                    e.printStackTrace();
/* 537:578 */       ActionErrors errors = new ActionErrors();
/* 538:579 */       errors.add("org.apache.struts.action.GLOBAL_ERROR", new ActionError("errors.activationFailed"));
/* 539:580 */       saveErrors(request, errors);
/* 540:581 */       resultado = "failure";
/* 541:582 */       return mapping.findForward(resultado);
/* 542:    */     }
/* 543:    */     catch (Exception e)
/* 544:    */     {
                    e.printStackTrace();
/* 545:585 */       ActionErrors errors = new ActionErrors();
/* 546:586 */       errors.add("org.apache.struts.action.GLOBAL_ERROR", new ActionError("errors.errorConsultaDB"));
/* 547:587 */       saveErrors(request, errors);
/* 548:588 */       resultado = "failure";
/* 549:589 */       return mapping.findForward(resultado);
/* 550:    */     }
/* 551:592 */     return mapping.findForward(resultado);
/* 552:    */   }
/* 553:    */   
/* 554:    */   private synchronized void actualizarServidor(BigDecimal codigoServidor)
/* 555:    */   {
/* 556:596 */     ServidoresDAO servidoresDAO = new ServidoresDAO();
/* 557:    */     try
/* 558:    */     {
/* 559:598 */       servidoresDAO.updateNewUser(codigoServidor);
/* 560:    */     }
/* 561:    */     catch (SQLException e)
/* 562:    */     {
/* 563:600 */       e.printStackTrace();
/* 564:    */     }
/* 565:    */   }
/* 566:    */   
/* 567:    */   public ActionForward performReloadActivate(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 568:    */     throws Exception
/* 569:    */   {
/* 570:605 */     String resultado = null;
/* 571:606 */     resultado = "failure";
/* 572:607 */     return mapping.findForward(resultado);
/* 573:    */   }
/* 574:    */ }



/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\

 * Qualified Name:     com.servidoctor.seguridad.controller.SingUpAction

 * JD-Core Version:    0.7.0.1

 */