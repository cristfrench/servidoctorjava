/*   1:    */ package com.servidoctor.sdfamily.controller;
/*   2:    */ 
/*   3:    */ import com.essecorp.util.GestorFechasCompleto;
/*   4:    */ import com.servidoctor.common.controller.BaseAction;
/*   5:    */ import com.servidoctor.constantes.IConstantes;
/*   6:    */ import com.servidoctor.constantes.IGrupos;
/*   7:    */ import com.servidoctor.parametros.dao.CiudadDAO;
/*   8:    */ import com.servidoctor.parametros.dao.PaisDAO;
/*   9:    */ import com.servidoctor.parametros.model.Optometria;
/*  10:    */ import com.servidoctor.parametros.model.Paises;
/*  11:    */ import com.servidoctor.sdfamily.dao.DatosPersonalesDAO;
/*  12:    */ import com.servidoctor.sdfamily.dao.OptometriaCompletoDAO;
/*  13:    */ import com.servidoctor.sdfamily.model.ControlOptometria;
/*  14:    */ import com.servidoctor.sdfamily.model.DatosPersonales;
/*  15:    */ import com.servidoctor.sdfamily.model.GruposUsuario;
/*  16:    */ import com.servidoctor.sdfamily.model.OptometriaCompleto;
/*  17:    */ import com.servidoctor.seguridad.model.Servidores;
/*  18:    */ import com.servidoctor.seguridad.model.UsuarioFamily;
/*  19:    */ import com.servidoctor.util.classes.BorrarSession;
/*  20:    */ import com.servidoctor.util.classes.ManejoFechas;
/*  21:    */ import java.io.PrintStream;
/*  22:    */ import java.math.BigDecimal;
/*  23:    */ import java.util.ArrayList;
/*  24:    */ import java.util.List;
/*  25:    */ import javax.servlet.http.HttpServletRequest;
/*  26:    */ import javax.servlet.http.HttpServletResponse;
/*  27:    */ import javax.servlet.http.HttpSession;
/*  28:    */ import org.apache.commons.beanutils.BeanUtils;
/*  29:    */ import org.apache.struts.action.ActionForm;
/*  30:    */ import org.apache.struts.action.ActionForward;
/*  31:    */ import org.apache.struts.action.ActionMapping;
/*  32:    */ 
/*  33:    */ public class OptometriaCompletoAction
/*  34:    */   extends BaseAction
/*  35:    */ {
/*  36:    */   public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  37:    */     throws Exception
/*  38:    */   {
/*  39: 38 */     ActionForward myforward = super.execute(mapping, actionForm, request, response);
/*  40: 39 */     String myaction = mapping.getParameter();
/*  41: 41 */     if (myforward == null)
/*  42:    */     {
/*  43: 42 */       DatosPersonales datosPersonales = (DatosPersonales)request.getSession().getAttribute("datosPersonales");
/*  44: 43 */       if (datosPersonales.getDatp_usuf_cod() == null) {
/*  45: 44 */         myforward = mapping.findForward("datospersonales");
/*  46: 45 */       } else if ("".equalsIgnoreCase(myaction)) {
/*  47: 46 */         myforward = mapping.findForward("failure");
/*  48: 47 */       } else if ("VIEW".equalsIgnoreCase(myaction)) {
/*  49: 48 */         myforward = performView(mapping, actionForm, request, response);
/*  50: 49 */       } else if ("ADD".equalsIgnoreCase(myaction)) {
/*  51: 50 */         myforward = performAdd(mapping, actionForm, request, response);
/*  52: 51 */       } else if ("SAVE".equalsIgnoreCase(myaction)) {
/*  53: 52 */         myforward = performSave(mapping, actionForm, request, response);
/*  54:    */       } else {
/*  55: 54 */         myforward = mapping.findForward("failure");
/*  56:    */       }
/*  57:    */     }
/*  58: 58 */     return myforward;
/*  59:    */   }
/*  60:    */   
/*  61:    */   private ActionForward performView(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  62:    */   {
/*  63: 62 */     OptometriaCompletoForm form = (OptometriaCompletoForm)actionForm;
/*  64: 63 */     Boolean nuevo = Boolean.valueOf(false);
/*  65:    */     try
/*  66:    */     {
/*  67: 67 */       BorrarSession.eliminaAtributos(request.getSession(), "optometriaCompletoForm");
/*  68:    */       
/*  69: 69 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/*  70: 70 */       OptometriaCompletoDAO optometriaCompletoDAO = new OptometriaCompletoDAO();
                    System.out.println("el servidor es:" + request.getSession().getAttribute("servidor"));
/*  71: 71 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  72: 72 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  73: 73 */         optometriaCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  74:    */       }
/*  75: 75 */       //optometriaCompletoDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    optometriaCompletoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  76:    */       
/*  77: 77 */       OptometriaCompleto optometriaCompleto = optometriaCompletoDAO.retrieve(usuarioFamily.getUsuf_cod());
/*  78:    */       
/*  79:    */ 
/*  80: 80 */       List tablaUniversal = optometriaCompleto.getTablaUniversal();
/*  81: 81 */       request.getSession().setAttribute("CONTROLES_OPTO", tablaUniversal);
/*  82:    */       
/*  83:    */ 
/*  84: 84 */       List tablaAjustada = optometriaCompleto.getTablaAjustada();
/*  85: 86 */       if (tablaAjustada.size() == 0)
/*  86:    */       {
/*  87: 87 */         nuevo = Boolean.valueOf(true);
/*  88: 88 */         for (int i = 0; i < tablaUniversal.size(); i++)
/*  89:    */         {
/*  90: 89 */           Optometria optometria = new Optometria();
/*  91: 90 */           BeanUtils.copyProperties(optometria, (Optometria)tablaUniversal.get(i));
/*  92: 91 */           optometria.setOpt_usuf_cod(usuarioFamily.getUsuf_cod());
/*  93: 92 */           tablaAjustada.add(optometria);
/*  94:    */         }
/*  95:    */       }
/*  96: 96 */       request.getSession().setAttribute("USUARIO_OPTO", tablaAjustada);
/*  97:    */       
/*  98:    */ 
/*  99:    */ 
/* 100:100 */       List controlesAnteriores = optometriaCompleto.getControlesAnteriores();
/* 101:101 */       List controlesProximos = optometriaCompleto.getControlesProximos();
/* 102:103 */       if (controlesAnteriores.size() > 0)
/* 103:    */       {
/* 104:105 */         ControlOptometria controlOptometria = (ControlOptometria)controlesAnteriores.get(0);
/* 105:106 */         form.setCopt_cod1(controlOptometria.getCopt_cod().toString());
/* 106:    */         
/* 107:    */ 
/* 108:    */ 
/* 109:110 */         form.setCopt_feccontrol1(ManejoFechas.FormateoFecha(controlOptometria.getCopt_feccontrol().toString()));
/* 110:    */         
/* 111:112 */         form.setCopt_nommedico1(controlOptometria.getCopt_nommedico());
/* 112:113 */         form.setCopt_pais_cod1(controlOptometria.getCopt_pais_cod().toString());
/* 113:114 */         form.setCopt_ciudad_cod1(controlOptometria.getCopt_ciudad_cod().toString());
/* 114:115 */         form.setCopt_telefono1(controlOptometria.getCopt_telefono());
/* 115:116 */         form.setCopt_email1(controlOptometria.getCopt_email());
/* 116:117 */         form.setCopt_horacontrol1(ManejoFechas.FormateoHoraAMPM(controlOptometria.getCopt_horacontrol().toString()));
/* 117:118 */         form.setCopt_apemedico1(controlOptometria.getCopt_apemedico());
/* 118:119 */         form.setCopt_direccion1(controlOptometria.getCopt_direccion());
/* 119:120 */         form.setCopt_entidad1(controlOptometria.getCopt_entidad());
/* 120:121 */         form.setCopt_indpais1(controlOptometria.getCopt_indpais().toString());
/* 121:122 */         form.setCopt_indciudad1(controlOptometria.getCopt_indciudad().toString());
/* 122:    */       }
/* 123:    */       else
/* 124:    */       {
/* 125:125 */         form.setCopt_feccontrol1(ManejoFechas.FormateoFecha("1901-01-01"));
/* 126:    */       }
/* 127:128 */       if (controlesProximos.size() > 0)
/* 128:    */       {
/* 129:129 */         ControlOptometria controlOptometria = (ControlOptometria)controlesProximos.get(0);
/* 130:130 */         form.setCopt_cod2(controlOptometria.getCopt_cod().toString());

/* 134:134 */         form.setCopt_feccontrol2(ManejoFechas.FormateoFecha(controlOptometria.getCopt_feccontrol().toString()));
/* 135:    */         
/* 136:136 */         form.setCopt_nommedico2(controlOptometria.getCopt_nommedico());
/* 137:137 */         form.setCopt_pais_cod2(controlOptometria.getCopt_pais_cod().toString());
/* 138:138 */         form.setCopt_ciudad_cod2(controlOptometria.getCopt_ciudad_cod().toString());
/* 139:139 */         form.setCopt_telefono2(controlOptometria.getCopt_telefono());
/* 140:140 */         form.setCopt_email2(controlOptometria.getCopt_email());
/* 141:141 */         form.setCopt_horacontrol2(ManejoFechas.FormateoHoraAMPM(controlOptometria.getCopt_horacontrol().toString()));
/* 142:142 */         form.setCopt_apemedico2(controlOptometria.getCopt_apemedico());
/* 143:143 */         form.setCopt_direccion2(controlOptometria.getCopt_direccion());
/* 144:144 */         form.setCopt_entidad2(controlOptometria.getCopt_entidad());
/* 145:145 */         form.setCopt_indpais2(controlOptometria.getCopt_indpais().toString());
/* 146:146 */         form.setCopt_indciudad2(controlOptometria.getCopt_indciudad().toString());
/* 147:    */         
/* 148:148 */         BeanUtils.copyProperties(form, controlOptometria);
/* 149:    */       }
/* 150:    */       else
/* 151:    */       {
/* 152:150 */         form.setCopt_feccontrol2(ManejoFechas.FormateoFecha("1901-01-01"));
/* 153:    */       }
/* 154:153 */       GruposUsuario gruposUsuario = optometriaCompleto.getGrupoUsuario();
/* 155:154 */       BeanUtils.copyProperties(form, gruposUsuario);
/* 156:    */       
/* 157:156 */       PaisDAO paisDAO = new PaisDAO();
/* 158:157 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 159:158 */         paisDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 160:    */       }
/* 161:160 */       //paisDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    paisDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 162:161 */       List paises = paisDAO.list();
/* 163:162 */       request.setAttribute("PAISES", paises);
/* 164:    */       
/* 165:164 */       List ciudades = null;
/* 166:165 */       CiudadDAO ciudadesDAO = new CiudadDAO();
/* 167:166 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 168:167 */         ciudadesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 169:    */       }
/* 170:169 */       //ciudadesDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    ciudadesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 171:170 */       if ((paises.size() > 0) && (!form.getCopt_pais_cod1().equals(""))) {
/* 172:171 */         ciudades = ciudadesDAO.search(form.getCopt_pais_cod1());
/* 173:172 */       } else if (paises.size() > 0) {
/* 174:173 */         ciudades = ciudadesDAO.search(((Paises)paises.get(0)).getPais_cod().toString());
/* 175:    */       }
/* 176:175 */       request.setAttribute("CIUDADES1", ciudades);
/* 177:    */       
/* 178:177 */       List ciudades2 = null;
/* 179:178 */       if ((paises.size() > 0) && (!form.getCopt_pais_cod2().equals(""))) {
/* 180:179 */         ciudades2 = ciudadesDAO.search(form.getCopt_pais_cod2());
/* 181:180 */       } else if (paises.size() > 0) {
/* 182:181 */         ciudades2 = ciudadesDAO.search(((Paises)paises.get(0)).getPais_cod().toString());
/* 183:    */       }
/* 184:183 */       request.setAttribute("CIUDADES2", ciudades2);
/* 185:    */     }
/* 186:    */     catch (Exception e)
/* 187:    */     {
/* 188:186 */       e.printStackTrace();
/* 189:187 */       return mapping.findForward("failure");
/* 190:    */     }
/* 191:189 */     return mapping.findForward("success");
/* 192:    */   }
/* 193:    */   
/* 194:    */   private ActionForward performAdd(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 195:    */   {
/* 196:193 */     OptometriaCompletoForm form = (OptometriaCompletoForm)actionForm;
/* 197:    */     try
/* 198:    */     {
/* 199:196 */       List usuariooptometria = new ArrayList();
/* 200:197 */       if (request.getSession().getAttribute("CONTROLES_OPTO") != null) {
/* 201:198 */         usuariooptometria = (List)request.getSession().getAttribute("CONTROLES_OPTO");
/* 202:    */       }
/* 203:199 */       request.getSession().setAttribute("CONTROLES_OPTO", usuariooptometria);
/* 204:201 */       if (request.getSession().getAttribute("USUARIO_OPTO") != null) {
/* 205:202 */         usuariooptometria = (List)request.getSession().getAttribute("USUARIO_OPTO");
/* 206:    */       }
/* 207:203 */       request.getSession().setAttribute("USUARIO_OPTO", usuariooptometria);
/* 208:    */       
/* 209:205 */       PaisDAO paisDAO = new PaisDAO();
/* 210:206 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 211:207 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 212:208 */         paisDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 213:    */       }
/* 214:210 */       //paisDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    paisDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 215:211 */       List paises = paisDAO.list();
/* 216:212 */       request.setAttribute("PAISES", paises);
/* 217:    */       
/* 218:214 */       List ciudades = null;
/* 219:215 */       CiudadDAO ciudadesDAO = new CiudadDAO();
/* 220:216 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 221:217 */         ciudadesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 222:    */       }
/* 223:219 */       //ciudadesDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    ciudadesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 224:220 */       if ((paises.size() > 0) && (!form.getCopt_pais_cod1().equals(""))) {
/* 225:221 */         ciudades = ciudadesDAO.search(form.getCopt_pais_cod1());
/* 226:222 */       } else if (paises.size() > 0) {
/* 227:223 */         ciudades = ciudadesDAO.search(((Paises)paises.get(0)).getPais_cod().toString());
/* 228:    */       }
/* 229:225 */       request.setAttribute("CIUDADES1", ciudades);
/* 230:    */       
/* 231:227 */       List ciudades2 = null;
/* 232:228 */       if ((paises.size() > 0) && (!form.getCopt_pais_cod2().equals(""))) {
/* 233:229 */         ciudades2 = ciudadesDAO.search(form.getCopt_pais_cod2());
/* 234:230 */       } else if (paises.size() > 0) {
/* 235:231 */         ciudades2 = ciudadesDAO.search(((Paises)paises.get(0)).getPais_cod().toString());
/* 236:    */       }
/* 237:233 */       request.setAttribute("CIUDADES2", ciudades2);
/* 238:    */       
/* 239:235 */       form.setCopt_feccontrol1(ManejoFechas.FormateoFecha(form.getCopt_feccontrol1()));
/* 240:236 */       form.setCopt_feccontrol2(ManejoFechas.FormateoFecha(form.getCopt_feccontrol2()));
/* 241:    */       
/* 242:238 */       form.setCopt_horacontrol1(ManejoFechas.FormateoHoraAMPM(form.getCopt_horacontrol1()));
/* 243:239 */       form.setCopt_horacontrol2(ManejoFechas.FormateoHoraAMPM(form.getCopt_horacontrol2()));
/* 244:    */     }
/* 245:    */     catch (Exception e)
/* 246:    */     {
/* 247:242 */       e.printStackTrace();
/* 248:243 */       return mapping.findForward("failure");
/* 249:    */     }
/* 250:246 */     return mapping.findForward("success");
/* 251:    */   }
/* 252:    */   
/* 253:    */   private ActionForward performSave(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 254:    */   {
/* 255:250 */     OptometriaCompletoForm form = (OptometriaCompletoForm)actionForm;
/* 256:    */     try
/* 257:    */     {
/* 258:254 */       List tablaAjustada = (List)request.getSession().getAttribute("USUARIO_OPTO");
/* 259:256 */       if (form.getCopt_indpais1().length() == 0) {
/* 260:257 */         form.setCopt_indpais1("0");
/* 261:    */       }
/* 262:259 */       if (form.getCopt_indciudad1().length() == 0) {
/* 263:260 */         form.setCopt_indciudad2("0");
/* 264:    */       }
/* 265:262 */       if (form.getCopt_indpais2().length() == 0) {
/* 266:263 */         form.setCopt_indpais2("0");
/* 267:    */       }
/* 268:265 */       if (form.getCopt_indciudad2().length() == 0) {
/* 269:266 */         form.setCopt_indciudad2("0");
/* 270:    */       }
/* 271:268 */       if (form.getGrupu_dias_antes().length() == 0) {
/* 272:269 */         form.setGrupu_dias_antes("2");
/* 273:    */       }
/* 274:272 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/* 275:273 */       DatosPersonalesDAO datosPersonalesDAO = new DatosPersonalesDAO();
/* 276:274 */       DatosPersonales datosPersonales = datosPersonalesDAO.retrive(usuarioFamily.getUsuf_cod());
/* 277:275 */       String fechaActual = ManejoFechas.getFechaActual();
/* 278:276 */       OptometriaCompletoDAO optometriaCompletoDAO = new OptometriaCompletoDAO();
/* 279:277 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 280:278 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 281:279 */         optometriaCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 282:    */       }
/* 283:281 */       OptometriaCompleto optometriaCompleto = optometriaCompletoDAO.retrieve(usuarioFamily.getUsuf_cod());
/* 284:    */       
/* 285:283 */       ControlOptometria controlOptometriaAnterior = (ControlOptometria)optometriaCompleto.getControlesAnteriores().get(0);
/* 286:284 */       ControlOptometria controlOptometriaProximo = (ControlOptometria)optometriaCompleto.getControlesProximos().get(0);
/* 287:    */       
/* 288:286 */       controlOptometriaAnterior.setCopt_usuf_cod(usuarioFamily.getUsuf_cod());
/* 289:287 */       controlOptometriaProximo.setCopt_usuf_cod(usuarioFamily.getUsuf_cod());
/* 290:    */       
/* 291:289 */       BeanUtils.copyProperties(controlOptometriaAnterior, form);
/* 292:    */       
/* 293:291 */       controlOptometriaAnterior.setCopt_nommedico(form.getCopt_nommedico1());
/* 294:292 */       controlOptometriaAnterior.setCopt_pais_cod(new BigDecimal(form.getCopt_pais_cod1()));
/* 295:293 */       controlOptometriaAnterior.setCopt_ciudad_cod(new BigDecimal(form.getCopt_ciudad_cod1()));
/* 296:294 */       controlOptometriaAnterior.setCopt_telefono(form.getCopt_telefono1());
/* 297:295 */       controlOptometriaAnterior.setCopt_email(form.getCopt_email1());
/* 298:    */       
/* 299:297 */       controlOptometriaAnterior.setCopt_apemedico(form.getCopt_apemedico1());
/* 300:298 */       controlOptometriaAnterior.setCopt_direccion(form.getCopt_direccion1());
/* 301:299 */       controlOptometriaAnterior.setCopt_entidad(form.getCopt_entidad1());
/* 302:300 */       controlOptometriaAnterior.setCopt_indpais(new BigDecimal(form.getCopt_indpais1()));
/* 303:301 */       controlOptometriaAnterior.setCopt_indciudad(new BigDecimal(form.getCopt_indciudad1()));
/* 304:302 */       controlOptometriaAnterior.setCopt_cod(new BigDecimal(form.getCopt_cod1()));
/* 305:303 */       controlOptometriaAnterior.setCopt_feccontrol(new BigDecimal(ManejoFechas.getChangeFecha(form.getCopt_feccontrol1())));
/* 306:304 */       controlOptometriaAnterior.setCopt_grup_cod(IGrupos.FAMILY_OPTOMETRIA);
/* 307:305 */       controlOptometriaAnterior.setCopt_tipo(IConstantes.CODIGO_CONTROL_ANTERIOR);
/* 308:    */       
/* 309:    */ 
/* 310:308 */       BeanUtils.copyProperties(controlOptometriaProximo, form);
/* 311:    */       
/* 312:310 */       controlOptometriaProximo.setCopt_nommedico(form.getCopt_nommedico2());
/* 313:311 */       controlOptometriaProximo.setCopt_pais_cod(new BigDecimal(form.getCopt_pais_cod2()));
/* 314:312 */       controlOptometriaProximo.setCopt_ciudad_cod(new BigDecimal(form.getCopt_ciudad_cod2()));
/* 315:313 */       controlOptometriaProximo.setCopt_telefono(form.getCopt_telefono2());
/* 316:314 */       controlOptometriaProximo.setCopt_email(form.getCopt_email2());
/* 317:315 */       controlOptometriaProximo.setCopt_apemedico(form.getCopt_apemedico2());
/* 318:316 */       controlOptometriaProximo.setCopt_direccion(form.getCopt_direccion2());
/* 319:317 */       controlOptometriaProximo.setCopt_entidad(form.getCopt_entidad2());
/* 320:318 */       controlOptometriaProximo.setCopt_indpais(new BigDecimal(form.getCopt_indpais2()));
/* 321:319 */       controlOptometriaProximo.setCopt_indciudad(new BigDecimal(form.getCopt_indciudad2()));
/* 322:320 */       controlOptometriaProximo.setCopt_cod(new BigDecimal(form.getCopt_cod2()));
/* 323:321 */       controlOptometriaProximo.setCopt_feccontrol(new BigDecimal(ManejoFechas.getChangeFecha(form.getCopt_feccontrol2())));
/* 324:322 */       if (form.getCopt_horacontrol2().length() == 8) {
/* 325:324 */         controlOptometriaProximo.setCopt_horacontrol(new BigDecimal(ManejoFechas.getChangeHoraAMPM2(form.getCopt_horacontrol2())));
/* 326:    */       }
/* 327:325 */       if (form.getCopt_horacontrol2().length() == 7) {
/* 328:326 */         controlOptometriaProximo.setCopt_horacontrol(new BigDecimal(ManejoFechas.getChangeHoraAMPM(form.getCopt_horacontrol2())));
/* 329:    */       }
/* 330:327 */       controlOptometriaProximo.setCopt_grup_cod(IGrupos.FAMILY_OPTOMETRIA);
/* 331:328 */       controlOptometriaProximo.setCopt_tipo(IConstantes.CODIGO_CONTROL_PROXIMO);
/* 332:329 */       List opto = new ArrayList();
/* 333:330 */       if (request.getSession().getAttribute("USUARIO_OPTO") != null) {
/* 334:331 */         opto = (List)request.getSession().getAttribute("USUARIO_OPTO");
/* 335:    */       }
/* 336:333 */       int diasAntesn = 0;
/* 337:334 */       int diasAntesn2 = 0;
/* 338:335 */       if (!form.getGrupu_dias_antes().equals("0")) {
/* 339:336 */         diasAntesn = new BigDecimal(form.getGrupu_dias_antes()).intValue();
/* 340:    */       }
/* 341:338 */       diasAntesn2 = diasAntesn / 2;
/* 342:339 */       if ((controlOptometriaAnterior.getCopt_feccontrol().compareTo(controlOptometriaProximo.getCopt_feccontrol()) == 0) && (controlOptometriaAnterior.getCopt_feccontrol().equals("0")))
/* 343:    */       {
/* 344:341 */         System.out.println("TA");
/* 345:342 */         for (int chequeos = 0; chequeos > opto.size(); chequeos++)
/* 346:    */         {
/* 347:343 */           int numeroMesesMinimo = ((Optometria)opto.get(chequeos)).getOpt_aniosdesde().intValue() * 12;
/* 348:344 */           int numeroMesesMaximo = ((Optometria)opto.get(chequeos)).getOpt_anioshasta().intValue() * 12;
/* 349:345 */           int numeroVecesAnio = ((Optometria)opto.get(chequeos)).getOpt_frecuencia().intValue();
/* 350:346 */           int numeroDiasControles = 0;
/* 351:347 */           if (numeroVecesAnio != 0) {
/* 352:348 */             numeroDiasControles = 365 / numeroVecesAnio;
/* 353:    */           }
/* 354:350 */           if ((GestorFechasCompleto.convertStringToLong(GestorFechasCompleto.fechaMasMeses(datosPersonales.getDatp_fecnacim().toString(), "yyyyMMdd", numeroMesesMinimo), "yyyyMMdd") < System.currentTimeMillis()) && (GestorFechasCompleto.convertStringToLong(GestorFechasCompleto.fechaMasMeses(datosPersonales.getDatp_fecnacim().toString(), "yyyyMMdd", numeroMesesMaximo), "yyyyMMdd") > System.currentTimeMillis()))
/* 355:    */           {
/* 356:351 */             String controlActual = datosPersonales.getDatp_fecnacim().toString();
/* 357:352 */             while (controlActual.compareTo(fechaActual) < 1) {
/* 358:353 */               controlActual = GestorFechasCompleto.fechaMasDias(controlActual, "yyyyMMdd", numeroDiasControles);
/* 359:    */             }
/* 360:356 */             controlOptometriaAnterior.setCopt_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlActual), "yyyyMMdd", -2)));
/* 361:357 */             controlOptometriaAnterior.setCopt_fecenvion(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlActual), "yyyyMMdd", -diasAntesn)));
/* 362:358 */             controlOptometriaAnterior.setCopt_fecenvion2(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlActual), "yyyyMMdd", -diasAntesn2)));
/* 363:359 */             controlOptometriaAnterior.setCopt_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlActual), "yyyyMMdd", 15)));
/* 364:360 */             controlOptometriaProximo.setCopt_fecenvio2(BigDecimal.ZERO);
/* 365:361 */             controlOptometriaProximo.setCopt_fecenvion(BigDecimal.ZERO);
/* 366:362 */             controlOptometriaProximo.setCopt_fecenvion2(BigDecimal.ZERO);
/* 367:363 */             controlOptometriaProximo.setCopt_quince_dias(BigDecimal.ZERO);
/* 368:    */           }
/* 369:    */         }
/* 370:    */       }
/* 371:    */       else
/* 372:    */       {
/* 373:367 */         if ((!controlOptometriaAnterior.getCopt_feccontrol().toString().equals("0")) && (controlOptometriaProximo.getCopt_feccontrol().toString().equals("0")))
/* 374:    */         {
/* 375:369 */           System.out.println("UC");
/* 376:370 */           for (int chequeos = 0; chequeos < opto.size(); chequeos++)
/* 377:    */           {
/* 378:371 */             int numeroMesesMinimo = ((Optometria)opto.get(chequeos)).getOpt_aniosdesde().intValue() * 12;
/* 379:372 */             int numeroMesesMaximo = ((Optometria)opto.get(chequeos)).getOpt_anioshasta().intValue() * 12;
/* 380:373 */             int numeroVecesAnio = ((Optometria)opto.get(chequeos)).getOpt_frecuencia().intValue();
/* 381:374 */             int numeroDiasControles = 0;
/* 382:377 */             if (numeroVecesAnio != 0) {
/* 383:378 */               numeroDiasControles = 365 / numeroVecesAnio;
/* 384:    */             }
/* 385:380 */             String controlActual = controlOptometriaAnterior.getCopt_feccontrol().toString();
/* 386:381 */             while (controlActual.compareTo(fechaActual) < 1) {
/* 387:382 */               controlActual = GestorFechasCompleto.fechaMasDias(controlActual, "yyyyMMdd", numeroDiasControles);
/* 388:    */             }
/* 389:384 */             controlOptometriaAnterior.setCopt_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlActual), "yyyyMMdd", -2)));
/* 390:385 */             controlOptometriaAnterior.setCopt_fecenvion(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlActual), "yyyyMMdd", -diasAntesn)));
/* 391:386 */             controlOptometriaAnterior.setCopt_fecenvion2(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlActual), "yyyyMMdd", -diasAntesn2)));
/* 392:387 */             controlOptometriaAnterior.setCopt_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlActual), "yyyyMMdd", 15)));
/* 393:388 */             controlOptometriaProximo.setCopt_fecenvio2(BigDecimal.ZERO);
/* 394:389 */             controlOptometriaProximo.setCopt_fecenvion(BigDecimal.ZERO);
/* 395:390 */             controlOptometriaProximo.setCopt_fecenvion2(BigDecimal.ZERO);
/* 396:391 */             controlOptometriaProximo.setCopt_quince_dias(BigDecimal.ZERO);
/* 397:    */           }
/* 398:    */         }
/* 399:395 */         if ((!controlOptometriaProximo.getCopt_feccontrol().toString().equals("0")) && (!controlOptometriaProximo.getCopt_feccontrol().toString().equals("0")))
/* 400:    */         {
/* 401:397 */           System.out.println("PC");
/* 402:398 */           controlOptometriaProximo.setCopt_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlOptometriaProximo.getCopt_feccontrol().toString()), "yyyyMMdd", -2)));
/* 403:399 */           controlOptometriaProximo.setCopt_fecenvion(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlOptometriaProximo.getCopt_feccontrol().toString()), "yyyyMMdd", -diasAntesn)));
/* 404:400 */           controlOptometriaProximo.setCopt_fecenvion2(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlOptometriaProximo.getCopt_feccontrol().toString()), "yyyyMMdd", -diasAntesn2)));
/* 405:401 */           controlOptometriaProximo.setCopt_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlOptometriaProximo.getCopt_feccontrol().toString()), "yyyyMMdd", 15)));
/* 406:402 */           controlOptometriaAnterior.setCopt_fecenvio2(BigDecimal.ZERO);
/* 407:403 */           controlOptometriaAnterior.setCopt_fecenvion(BigDecimal.ZERO);
/* 408:404 */           controlOptometriaAnterior.setCopt_fecenvion2(BigDecimal.ZERO);
/* 409:405 */           controlOptometriaAnterior.setCopt_quince_dias(BigDecimal.ZERO);
/* 410:    */         }
/* 411:    */       }
/* 412:    */       try
/* 413:    */       {
/* 414:411 */         controlOptometriaProximo.setCopt_horacontrol(new BigDecimal(ManejoFechas.getChangeHoraAMPM(form.getCopt_horacontrol2())));
/* 415:    */       }
/* 416:    */       catch (Exception e)
/* 417:    */       {
/* 418:413 */         controlOptometriaProximo.setCopt_horacontrol(new BigDecimal("0"));
/* 419:    */       }
/* 420:416 */       optometriaCompleto.setTablaAjustada(tablaAjustada);
/* 421:417 */       List ControlesAnteriores = optometriaCompleto.getControlesAnteriores();
/* 422:418 */       ControlesAnteriores.set(0, controlOptometriaAnterior);
/* 423:419 */       List ControlesProximos = optometriaCompleto.getControlesProximos();
/* 424:420 */       ControlesProximos.set(0, controlOptometriaProximo);
/* 425:421 */       optometriaCompleto.setControlesAnteriores(ControlesAnteriores);
/* 426:422 */       optometriaCompleto.setControlesProximos(ControlesProximos);
/* 427:    */       
/* 428:424 */       GruposUsuario gruposUsuario = optometriaCompleto.getGrupoUsuario();
/* 429:425 */       gruposUsuario.setGrupu_dias_antes(new BigDecimal(form.getGrupu_dias_antes()));
/* 430:    */       
/* 431:427 */       optometriaCompletoDAO.update(optometriaCompleto, usuarioFamily.getUsuf_cod());
/* 432:    */     }
/* 433:    */     catch (Exception e)
/* 434:    */     {
/* 435:432 */       e.printStackTrace();
/* 436:433 */       return mapping.findForward("failure");
/* 437:    */     }
/* 438:435 */     return mapping.findForward("success");
/* 439:    */   }
/* 440:    */ }



/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\

 * Qualified Name:     com.servidoctor.sdfamily.controller.OptometriaCompletoAction

 * JD-Core Version:    0.7.0.1

 */