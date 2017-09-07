/*   1:    */ package com.servidoctor.sdcars.controller;
/*   2:    */ 
/*   3:    */ import com.essecorp.util.GestorFechasCompleto;
/*   4:    */ import com.servidoctor.constantes.IConstantes;
/*   5:    */ import com.servidoctor.constantes.IGrupos;
/*   6:    */ import com.servidoctor.parametros.controller.GastosVehiculosForm;
/*   7:    */ import com.servidoctor.parametros.controller.RevisionesVehiculoForm;
/*   8:    */ import com.servidoctor.parametros.dao.CiudadDAO;
/*   9:    */ import com.servidoctor.parametros.dao.PaisDAO;
/*  10:    */ import com.servidoctor.parametros.dao.RevisionAccionDAO;
/*  11:    */ import com.servidoctor.parametros.dao.RevisionAlternativaDAO;
/*  12:    */ import com.servidoctor.parametros.dao.RevisionesVehiculoDAO;
/*  13:    */ import com.servidoctor.parametros.model.GastosVehiculosAnuales;
/*  14:    */ import com.servidoctor.parametros.model.GastosVehiculosMecanica;
/*  15:    */ import com.servidoctor.parametros.model.GastosVehiculosNoAnuales;
/*  16:    */ import com.servidoctor.parametros.model.Paises;
/*  17:    */ import com.servidoctor.parametros.model.RevisionesVehiculo;
/*  18:    */ import com.servidoctor.sdcars.model.Combustible;
/*  19:    */ import com.servidoctor.sdcars.model.ControlesVehiculos;
/*  20:    */ import com.servidoctor.sdcars.model.ImpuestoVehiculo;
/*  21:    */ import com.servidoctor.sdcars.model.SegurosVehiculos;
/*  22:    */ import com.servidoctor.sdcars.model.Vehiculos;
/*  23:    */ import com.servidoctor.seguridad.model.Servidores;
/*  24:    */ import com.servidoctor.util.classes.InicializaData;
/*  25:    */ import com.servidoctor.util.classes.ManejoFechas;
/*  26:    */ import java.math.BigDecimal;
/*  27:    */ import java.util.ArrayList;
/*  28:    */ import java.util.List;
/*  29:    */ import javax.servlet.http.HttpServletRequest;
/*  30:    */ import javax.servlet.http.HttpServletResponse;
/*  31:    */ import javax.servlet.http.HttpSession;
/*  32:    */ import org.apache.commons.beanutils.BeanUtils;
/*  33:    */ import org.apache.struts.action.Action;
/*  34:    */ import org.apache.struts.action.ActionForm;
/*  35:    */ import org.apache.struts.action.ActionForward;
/*  36:    */ import org.apache.struts.action.ActionMapping;
/*  37:    */ 
/*  38:    */ public class PopupAction
/*  39:    */   extends Action
/*  40:    */ {
/*  41:    */   public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  42:    */     throws Exception
/*  43:    */   {
/*  44: 43 */     ActionForward myforward = null;
/*  45: 44 */     String myaction = mapping.getParameter();
/*  46: 46 */     if ("".equalsIgnoreCase(myaction)) {
/*  47: 47 */       myforward = mapping.findForward("failure");
/*  48: 48 */     } else if ("ADD_SEGURO".equalsIgnoreCase(myaction)) {
/*  49: 49 */       myforward = performAdd_seguro(mapping, actionForm, request, response);
/*  50: 50 */     } else if ("TRASF_SEGURO".equalsIgnoreCase(myaction)) {
/*  51: 51 */       myforward = performTrasf_seguro(mapping, actionForm, request, response);
/*  52: 52 */     } else if ("EDIT_SEGURO".equalsIgnoreCase(myaction)) {
/*  53: 53 */       myforward = performEdit_seguro(mapping, actionForm, request, response);
/*  54: 54 */     } else if ("REMOVE_SEGURO".equalsIgnoreCase(myaction)) {
/*  55: 55 */       myforward = performRemove_seguro(mapping, actionForm, request, response);
/*  56: 56 */     } else if ("ADD_CONTROL".equalsIgnoreCase(myaction)) {
/*  57: 57 */       myforward = performAdd_control(mapping, actionForm, request, response);
/*  58: 58 */     } else if ("TRASF_CONTROL".equalsIgnoreCase(myaction)) {
/*  59: 59 */       myforward = performTrasf_control(mapping, actionForm, request, response);
/*  60: 60 */     } else if ("EDIT_CONTROL".equalsIgnoreCase(myaction)) {
/*  61: 61 */       myforward = performEdit_control(mapping, actionForm, request, response);
/*  62: 62 */     } else if ("REMOVE_CONTROL".equalsIgnoreCase(myaction)) {
/*  63: 63 */       myforward = performRemove_control(mapping, actionForm, request, response);
/*  64: 64 */     } else if ("ADD_REVISIONES".equalsIgnoreCase(myaction)) {
/*  65: 65 */       myforward = performAdd_revision(mapping, actionForm, request, response);
/*  66: 66 */     } else if ("TRASF_REVISIONES".equalsIgnoreCase(myaction)) {
/*  67: 67 */       myforward = performTrasf_revision(mapping, actionForm, request, response);
/*  68: 68 */     } else if ("EDIT_REVISIONES".equalsIgnoreCase(myaction)) {
/*  69: 69 */       myforward = performEdit_revision(mapping, actionForm, request, response);
/*  70: 70 */     } else if ("REMOVE_REVISIONES".equalsIgnoreCase(myaction)) {
/*  71: 71 */       myforward = performRemove_revision(mapping, actionForm, request, response);
/*  72: 72 */     } else if ("UNDO_REVISIONES".equalsIgnoreCase(myaction)) {
/*  73: 73 */       myforward = performUndo_revision(mapping, actionForm, request, response);
/*  74: 74 */     } else if ("ADD_GASTOS_MEC".equalsIgnoreCase(myaction)) {
/*  75: 75 */       myforward = performAdd_gastosMec(mapping, actionForm, request, response);
/*  76: 76 */     } else if ("TRASF_GASTOS_MEC".equalsIgnoreCase(myaction)) {
/*  77: 77 */       myforward = performTrasf_gastosMec(mapping, actionForm, request, response);
/*  78: 78 */     } else if ("EDIT_GASTOS_MEC".equalsIgnoreCase(myaction)) {
/*  79: 79 */       myforward = performEdit_gastosMec(mapping, actionForm, request, response);
/*  80: 80 */     } else if ("REMOVE_GASTOS_MEC".equalsIgnoreCase(myaction)) {
/*  81: 81 */       myforward = performRemove_gastosMec(mapping, actionForm, request, response);
/*  82: 82 */     } else if ("ADD_GASTOS".equalsIgnoreCase(myaction)) {
/*  83: 83 */       myforward = performAdd_gastos(mapping, actionForm, request, response);
/*  84: 84 */     } else if ("TRASF_GASTOS".equalsIgnoreCase(myaction)) {
/*  85: 85 */       myforward = performTrasf_gastos(mapping, actionForm, request, response);
/*  86: 86 */     } else if ("EDIT_GASTOS".equalsIgnoreCase(myaction)) {
/*  87: 87 */       myforward = performEdit_gastos(mapping, actionForm, request, response);
/*  88: 88 */     } else if ("REMOVE_GASTOS".equalsIgnoreCase(myaction)) {
/*  89: 89 */       myforward = performRemove_gastos(mapping, actionForm, request, response);
/*  90: 90 */     } else if ("ADD_GASTOSANU".equalsIgnoreCase(myaction)) {
/*  91: 91 */       myforward = performAdd_gastosanuales(mapping, actionForm, request, response);
/*  92: 92 */     } else if ("TRASF_GASTOSANU".equalsIgnoreCase(myaction)) {
/*  93: 93 */       myforward = performTrasf_gastosanuales(mapping, actionForm, request, response);
/*  94: 94 */     } else if ("EDIT_GASTOSANU".equalsIgnoreCase(myaction)) {
/*  95: 95 */       myforward = performEdit_gastosanuales(mapping, actionForm, request, response);
/*  96: 96 */     } else if ("REMOVE_GASTOSANU".equalsIgnoreCase(myaction)) {
/*  97: 97 */       myforward = performRemove_gastosanuales(mapping, actionForm, request, response);
/*  98: 98 */     } else if ("ADD_IMPUESTO".equalsIgnoreCase(myaction)) {
/*  99: 99 */       myforward = performAdd_impuesto(mapping, actionForm, request, response);
/* 100:100 */     } else if ("TRASF_IMPUESTO".equalsIgnoreCase(myaction)) {
/* 101:101 */       myforward = performTrasf_impuestos(mapping, actionForm, request, response);
/* 102:102 */     } else if ("EDIT_IMPUESTO".equalsIgnoreCase(myaction)) {
/* 103:103 */       myforward = performEdit_impuestos(mapping, actionForm, request, response);
/* 104:104 */     } else if ("REMOVE_IMPUESTO".equalsIgnoreCase(myaction)) {
/* 105:105 */       myforward = performRemove_impuestos(mapping, actionForm, request, response);
/* 106:106 */     } else if ("ADD_COMBUSTIBLE".equalsIgnoreCase(myaction)) {
/* 107:107 */       myforward = performAdd_combustible(mapping, actionForm, request, response);
/* 108:108 */     } else if ("TRASF_COMBUSTIBLE".equalsIgnoreCase(myaction)) {
/* 109:109 */       myforward = performTrasf_combustible(mapping, actionForm, request, response);
/* 110:110 */     } else if ("EDIT_COMBUSTIBLE".equalsIgnoreCase(myaction)) {
/* 111:111 */       myforward = performEdit_combustible(mapping, actionForm, request, response);
/* 112:112 */     } else if ("REMOVE_COMBUSTIBLE".equalsIgnoreCase(myaction)) {
/* 113:113 */       myforward = performRemove_combustible(mapping, actionForm, request, response);
/* 114:    */     } else {
/* 115:115 */       myforward = mapping.findForward("failure");
/* 116:    */     }
/* 117:118 */     return myforward;
/* 118:    */   }
/* 119:    */   
/* 120:    */   private ActionForward performAdd_seguro(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 121:    */   {
/* 122:122 */     SegurosVehiculosForm form = (SegurosVehiculosForm)actionForm;
/* 123:    */     try
/* 124:    */     {
/* 125:125 */       PaisDAO paisDAO = new PaisDAO();
/* 126:126 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 127:127 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 128:128 */         paisDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 129:    */       }
/* 130:130 */       paisDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 131:131 */       List paises = paisDAO.list();
/* 132:132 */       request.setAttribute("PAISES", paises);
/* 133:    */       
/* 134:134 */       CiudadDAO ciudadDAO = new CiudadDAO();
/* 135:135 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 136:136 */         ciudadDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 137:    */       }
/* 138:138 */       ciudadDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 139:139 */       List ciudades = null;
/* 140:140 */       if (paises.size() > 0) {
/* 141:141 */         if (!form.getSveh_pais_cod().equals("0")) {
/* 142:142 */           ciudades = ciudadDAO.search(form.getSveh_pais_cod());
/* 143:    */         } else {
/* 144:144 */           ciudades = ciudadDAO.search(((Paises)paises.get(0)).getPais_cod().toString());
/* 145:    */         }
/* 146:    */       }
/* 147:147 */       request.setAttribute("CIUDADES", ciudades);
/* 148:    */     }
/* 149:    */     catch (Exception e)
/* 150:    */     {
/* 151:149 */       return mapping.findForward("failure");
/* 152:    */     }
/* 153:152 */     return mapping.findForward("success");
/* 154:    */   }
/* 155:    */   
/* 156:    */   private ActionForward performTrasf_seguro(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 157:    */   {
/* 158:155 */     SegurosVehiculosForm form = (SegurosVehiculosForm)actionForm;
/* 159:    */     try
/* 160:    */     {
/* 161:157 */       Vehiculos vehiculo = (Vehiculos)request.getSession().getAttribute("vehiculo");
/* 162:158 */       int diasAntes = 0;
/* 163:159 */       String diasAntesS = null;
/* 164:160 */       if (request.getSession().getAttribute("SEGUROSVEHICULOSDIAS") != null)
/* 165:    */       {
/* 166:161 */         diasAntesS = request.getSession().getAttribute("SEGUROSVEHICULOSDIAS").toString();
/* 167:162 */         diasAntes = diasAntesS != null ? new Integer(diasAntesS).intValue() : 0;
/* 168:    */       }
/* 169:164 */       SegurosVehiculos segurosVehiculos = new SegurosVehiculos();
/* 170:165 */       InicializaData.inicializa(segurosVehiculos.getClass(), segurosVehiculos);
/* 171:166 */       BeanUtils.copyProperties(segurosVehiculos, form);
/* 172:167 */       segurosVehiculos.setSveh_veh_cod(vehiculo.getVehi_cod());
/* 173:168 */       segurosVehiculos.setSveh_grup_cod(IGrupos.CARS_SEGUROS);
/* 174:169 */       segurosVehiculos.setSveh_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(segurosVehiculos.getSveh_fecvigenchasta().toString(), "yyyyMMdd", -2)));
/* 175:170 */       segurosVehiculos.setSveh_fecenvion(new BigDecimal(GestorFechasCompleto.fechaMasDias(segurosVehiculos.getSveh_fecvigenchasta().toString(), "yyyyMMdd", -diasAntes)));
/* 176:171 */       segurosVehiculos.setSveh_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(segurosVehiculos.getSveh_fecenvio2().toString(), "yyyyMMdd", 17)));
/* 177:    */       
/* 178:173 */       List seguros = new ArrayList();
/* 179:175 */       if (request.getSession().getAttribute("SEGUROSVEHICULOS") != null) {
/* 180:176 */         seguros = (List)request.getSession().getAttribute("SEGUROSVEHICULOS");
/* 181:    */       }
/* 182:179 */       if (request.getParameter("num_seguro") == null) {
/* 183:180 */         seguros.add(segurosVehiculos);
/* 184:    */       } else {
/* 185:182 */         seguros.set(Integer.parseInt(request.getParameter("num_seguro")), segurosVehiculos);
/* 186:    */       }
/* 187:185 */       request.getSession().setAttribute("SEGUROSVEHICULOS", seguros);
/* 188:    */     }
/* 189:    */     catch (Exception e)
/* 190:    */     {
/* 191:188 */       return mapping.findForward("failure");
/* 192:    */     }
/* 193:191 */     return mapping.findForward("success");
/* 194:    */   }
/* 195:    */   
/* 196:    */   private ActionForward performEdit_seguro(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 197:    */   {
/* 198:194 */     SegurosVehiculosForm form = (SegurosVehiculosForm)actionForm;
/* 199:    */     try
/* 200:    */     {
/* 201:197 */       List seguros = (List)request.getSession().getAttribute("SEGUROSVEHICULOS");
/* 202:198 */       SegurosVehiculos segurosVehiculos = (SegurosVehiculos)seguros.get(Integer.parseInt(request.getParameter("num_seguro")));
/* 203:199 */       if (request.getParameter("change") == null)
/* 204:    */       {
/* 205:200 */         BeanUtils.copyProperties(form, segurosVehiculos);
/* 206:201 */         form.setSveh_fecvigenchasta(ManejoFechas.FormateoFecha(segurosVehiculos.getSveh_fecvigenchasta().toString()));
/* 207:    */       }
/* 208:204 */       PaisDAO paisDAO = new PaisDAO();
/* 209:205 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 210:206 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 211:207 */         paisDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 212:    */       }
/* 213:209 */       paisDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 214:210 */       List paises = paisDAO.list();
/* 215:211 */       request.setAttribute("PAISES", paises);
/* 216:    */       
/* 217:213 */       CiudadDAO ciudadDAO = new CiudadDAO();
/* 218:214 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 219:215 */         ciudadDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 220:    */       }
/* 221:217 */       ciudadDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 222:218 */       List ciudades = null;
/* 223:219 */       if (paises.size() > 0) {
/* 224:220 */         if (!form.getSveh_pais_cod().equals("0")) {
/* 225:221 */           ciudades = ciudadDAO.search(form.getSveh_pais_cod());
/* 226:    */         } else {
/* 227:223 */           ciudades = ciudadDAO.search(((Paises)paises.get(0)).getPais_cod().toString());
/* 228:    */         }
/* 229:    */       }
/* 230:226 */       request.setAttribute("CIUDADES", ciudades);
/* 231:    */     }
/* 232:    */     catch (Exception e)
/* 233:    */     {
/* 234:229 */       return mapping.findForward("failure");
/* 235:    */     }
/* 236:231 */     return mapping.findForward("success");
/* 237:    */   }
/* 238:    */   
/* 239:    */   private ActionForward performRemove_seguro(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 240:    */   {
/* 241:235 */     SegurosVehiculosForm form = (SegurosVehiculosForm)actionForm;
/* 242:    */     try
/* 243:    */     {
/* 244:239 */       List seguros = (List)request.getSession().getAttribute("SEGUROSVEHICULOS");
/* 245:240 */       seguros.remove(Integer.parseInt(request.getParameter("num_seguro")));
/* 246:    */       
/* 247:242 */       int x = 0;
/* 248:243 */       while (x < seguros.size())
/* 249:    */       {
/* 250:244 */         SegurosVehiculos segurosVehiculos = (SegurosVehiculos)seguros.get(x);
/* 251:245 */         segurosVehiculos.setSveh_cod(new BigDecimal(x + 1));
/* 252:246 */         seguros.set(x, segurosVehiculos);
/* 253:247 */         x++;
/* 254:    */       }
/* 255:250 */       request.getSession().setAttribute("SEGUROSVEHICULOS", seguros);
/* 256:    */     }
/* 257:    */     catch (Exception e)
/* 258:    */     {
/* 259:253 */       return mapping.findForward("failure");
/* 260:    */     }
/* 261:256 */     return mapping.findForward("success");
/* 262:    */   }
/* 263:    */   
/* 264:    */   private ActionForward performAdd_control(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 265:    */   {
/* 266:262 */     ControlesVehiculosForm form = (ControlesVehiculosForm)actionForm;
/* 267:    */     
/* 268:    */ 
/* 269:    */ 
/* 270:    */ 
/* 271:    */ 
/* 272:    */ 
/* 273:    */ 
/* 274:270 */     return mapping.findForward("success");
/* 275:    */   }
/* 276:    */   
/* 277:    */   private ActionForward performTrasf_control(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 278:    */   {
/* 279:273 */     ControlesVehiculosForm form = (ControlesVehiculosForm)actionForm;
/* 280:    */     try
/* 281:    */     {
/* 282:276 */       Vehiculos vehiculo = (Vehiculos)request.getSession().getAttribute("vehiculo");
/* 283:    */       
/* 284:278 */       ControlesVehiculos controlesVehiculos = new ControlesVehiculos();
/* 285:279 */       InicializaData.inicializa(controlesVehiculos.getClass(), controlesVehiculos);
/* 286:280 */       int diasAntes = 0;
/* 287:281 */       String diasAntesS = null;
/* 288:282 */       BeanUtils.copyProperties(controlesVehiculos, form);
/* 289:284 */       if (request.getSession().getAttribute("CONTROLESVEHICULOSDIAS") != null)
/* 290:    */       {
/* 291:285 */         diasAntesS = request.getSession().getAttribute("CONTROLESVEHICULOSDIAS").toString();
/* 292:286 */         diasAntes = diasAntesS != null ? new Integer(diasAntesS).intValue() : 0;
/* 293:    */       }
/* 294:289 */       controlesVehiculos.setCveh_veh_cod(vehiculo.getVehi_cod());
/* 295:290 */       controlesVehiculos.setCveh_grup_cod(IGrupos.CARS_CONTROLES);
/* 296:291 */       controlesVehiculos.setCveh_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(controlesVehiculos.getCveh_fecvigenc().toString(), "yyyyMMdd", -2)));
/* 297:292 */       controlesVehiculos.setCveh_fecenvion(new BigDecimal(GestorFechasCompleto.fechaMasDias(controlesVehiculos.getCveh_fecvigenc().toString(), "yyyyMMdd", -diasAntes)));
/* 298:293 */       controlesVehiculos.setCveh_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(controlesVehiculos.getCveh_fecenvio2().toString(), "yyyyMMdd", 17)));
/* 299:294 */       List controles = new ArrayList();
/* 300:298 */       if (request.getSession().getAttribute("CONTROLESVEHICULOS") != null) {
/* 301:299 */         controles = (List)request.getSession().getAttribute("CONTROLESVEHICULOS");
/* 302:    */       }
/* 303:302 */       if (request.getParameter("num_control") == null) {
/* 304:303 */         controles.add(controlesVehiculos);
/* 305:    */       } else {
/* 306:305 */         controles.set(Integer.parseInt(request.getParameter("num_control")), controlesVehiculos);
/* 307:    */       }
/* 308:308 */       request.getSession().setAttribute("CONTROLESVEHICULOS", controles);
/* 309:    */     }
/* 310:    */     catch (Exception e)
/* 311:    */     {
/* 312:311 */       return mapping.findForward("failure");
/* 313:    */     }
/* 314:314 */     return mapping.findForward("success");
/* 315:    */   }
/* 316:    */   
/* 317:    */   private ActionForward performEdit_control(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 318:    */   {
/* 319:317 */     ControlesVehiculosForm form = (ControlesVehiculosForm)actionForm;
/* 320:    */     try
/* 321:    */     {
/* 322:320 */       List controles = (List)request.getSession().getAttribute("CONTROLESVEHICULOS");
/* 323:321 */       ControlesVehiculos controlesVehiculos = (ControlesVehiculos)controles.get(Integer.parseInt(request.getParameter("num_control")));
/* 324:322 */       BeanUtils.copyProperties(form, controlesVehiculos);
/* 325:323 */       form.setCveh_fecvigenc(ManejoFechas.FormateoFecha(form.getCveh_fecvigenc()));
/* 326:    */     }
/* 327:    */     catch (Exception e)
/* 328:    */     {
/* 329:326 */       return mapping.findForward("failure");
/* 330:    */     }
/* 331:329 */     return mapping.findForward("success");
/* 332:    */   }
/* 333:    */   
/* 334:    */   private ActionForward performRemove_control(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 335:    */   {
/* 336:333 */     ControlesVehiculosForm form = (ControlesVehiculosForm)actionForm;
/* 337:    */     try
/* 338:    */     {
/* 339:337 */       List controles = new ArrayList();
/* 340:338 */       controles = (List)request.getSession().getAttribute("CONTROLESVEHICULOS");
/* 341:339 */       controles.remove(Integer.parseInt(request.getParameter("num_control")));
/* 342:    */       
/* 343:341 */       int x = 0;
/* 344:342 */       while (x < controles.size())
/* 345:    */       {
/* 346:343 */         ControlesVehiculos controlesVehiculos = (ControlesVehiculos)controles.get(x);
/* 347:344 */         controlesVehiculos.setCveh_cod(new BigDecimal(x + 1));
/* 348:345 */         controles.set(x, controlesVehiculos);
/* 349:346 */         x++;
/* 350:    */       }
/* 351:349 */       request.getSession().setAttribute("CONTROLESVEHICULOS", controles);
/* 352:    */     }
/* 353:    */     catch (Exception e)
/* 354:    */     {
/* 355:351 */       return mapping.findForward("failure");
/* 356:    */     }
/* 357:354 */     return mapping.findForward("success");
/* 358:    */   }
/* 359:    */   
/* 360:    */   private ActionForward performAdd_revision(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 361:    */   {
/* 362:360 */     RevisionesVehiculoForm form = (RevisionesVehiculoForm)actionForm;
/* 363:    */     try
/* 364:    */     {
/* 365:363 */       RevisionAlternativaDAO revisionAlternativaDAO = new RevisionAlternativaDAO();
/* 366:364 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 367:365 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 368:366 */         revisionAlternativaDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 369:    */       }
/* 370:368 */       revisionAlternativaDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 371:369 */       List revisionAlternativas = revisionAlternativaDAO.list();
/* 372:370 */       request.setAttribute("alternativas", revisionAlternativas);
/* 373:    */       
/* 374:372 */       RevisionAccionDAO revisionAccionDAO = new RevisionAccionDAO();
/* 375:373 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 376:374 */         revisionAccionDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 377:    */       }
/* 378:376 */       revisionAccionDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 379:377 */       List revisionAcciones = revisionAccionDAO.list();
/* 380:378 */       request.setAttribute("acciones", revisionAcciones);
/* 381:    */     }
/* 382:    */     catch (Exception e)
/* 383:    */     {
/* 384:381 */       return mapping.findForward("failure");
/* 385:    */     }
/* 386:384 */     return mapping.findForward("success");
/* 387:    */   }
/* 388:    */   
/* 389:    */   private ActionForward performTrasf_revision(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 390:    */   {
/* 391:387 */     RevisionesVehiculoForm form = (RevisionesVehiculoForm)actionForm;
/* 392:    */     try
/* 393:    */     {
/* 394:390 */       Vehiculos vehiculo = (Vehiculos)request.getSession().getAttribute("vehiculo");
/* 395:    */       
/* 396:392 */       RevisionesVehiculo revisionesVehiculo = new RevisionesVehiculo();
/* 397:393 */       InicializaData.inicializa(revisionesVehiculo.getClass(), revisionesVehiculo);
/* 398:394 */       form.setRveh_control_fec(ManejoFechas.getChangeFecha(form.getRveh_control_fec()));
/* 399:395 */       BeanUtils.copyProperties(revisionesVehiculo, form);
/* 400:396 */       revisionesVehiculo.setRveh_veh_cod(vehiculo.getVehi_cod());
/* 401:    */       
/* 402:398 */       List revisiones = new ArrayList();
/* 403:400 */       if (request.getSession().getAttribute("REVISIONES") != null) {
/* 404:401 */         revisiones = (List)request.getSession().getAttribute("REVISIONES");
/* 405:    */       }
/* 406:404 */       if (request.getParameter("num_revision") == null) {
/* 407:405 */         revisiones.add(revisionesVehiculo);
/* 408:    */       } else {
/* 409:407 */         revisiones.set(Integer.parseInt(request.getParameter("num_revision")), revisionesVehiculo);
/* 410:    */       }
/* 411:410 */       request.getSession().setAttribute("REVISIONES", revisiones);
/* 412:    */     }
/* 413:    */     catch (Exception e)
/* 414:    */     {
/* 415:413 */       return mapping.findForward("failure");
/* 416:    */     }
/* 417:416 */     return mapping.findForward("success");
/* 418:    */   }
/* 419:    */   
/* 420:    */   private ActionForward performEdit_revision(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 421:    */   {
/* 422:419 */     RevisionesVehiculoForm form = (RevisionesVehiculoForm)actionForm;
/* 423:    */     try
/* 424:    */     {
/* 425:422 */       List revisiones = (List)request.getSession().getAttribute("REVISIONES");
/* 426:423 */       RevisionesVehiculo revisionesVehiculo = (RevisionesVehiculo)revisiones.get(Integer.parseInt(request.getParameter("num_revision")));
/* 427:424 */       BeanUtils.copyProperties(form, revisionesVehiculo);
/* 428:425 */       form.setRveh_control_fec(ManejoFechas.FormateoFecha(revisionesVehiculo.getRveh_control_fec().toString()));
/* 429:    */       
/* 430:427 */       RevisionAlternativaDAO revisionAlternativaDAO = new RevisionAlternativaDAO();
/* 431:428 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 432:429 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 433:430 */         revisionAlternativaDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 434:    */       }
/* 435:432 */       revisionAlternativaDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 436:433 */       List revisionAlternativas = revisionAlternativaDAO.list();
/* 437:434 */       request.setAttribute("alternativas", revisionAlternativas);
/* 438:    */       
/* 439:436 */       RevisionAccionDAO revisionAccionDAO = new RevisionAccionDAO();
/* 440:437 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 441:438 */         revisionAccionDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 442:    */       }
/* 443:440 */       revisionAccionDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 444:441 */       List revisionAcciones = revisionAccionDAO.list();
/* 445:442 */       request.setAttribute("acciones", revisionAcciones);
/* 446:    */     }
/* 447:    */     catch (Exception e)
/* 448:    */     {
/* 449:444 */       return mapping.findForward("failure");
/* 450:    */     }
/* 451:446 */     return mapping.findForward("success");
/* 452:    */   }
/* 453:    */   
/* 454:    */   private ActionForward performRemove_revision(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 455:    */   {
/* 456:450 */     RevisionesVehiculoForm form = (RevisionesVehiculoForm)actionForm;
/* 457:    */     try
/* 458:    */     {
/* 459:454 */       List revisiones = new ArrayList();
/* 460:455 */       revisiones = (List)request.getSession().getAttribute("REVISIONES");
/* 461:456 */       revisiones.remove(Integer.parseInt(request.getParameter("num_revision")));
/* 462:    */       
/* 463:458 */       int x = 0;
/* 464:459 */       while (x < revisiones.size())
/* 465:    */       {
/* 466:460 */         RevisionesVehiculo revisionesVehiculo = (RevisionesVehiculo)revisiones.get(x);
/* 467:461 */         revisionesVehiculo.setRveh_cod(new BigDecimal(x + 1));
/* 468:462 */         revisiones.set(x, revisionesVehiculo);
/* 469:463 */         x++;
/* 470:    */       }
/* 471:466 */       request.getSession().setAttribute("REVISIONES", revisiones);
/* 472:    */     }
/* 473:    */     catch (Exception e)
/* 474:    */     {
/* 475:468 */       return mapping.findForward("failure");
/* 476:    */     }
/* 477:471 */     return mapping.findForward("success");
/* 478:    */   }
/* 479:    */   
/* 480:    */   private ActionForward performUndo_revision(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 481:    */   {
/* 482:477 */     RevisionesVehiculoForm form = (RevisionesVehiculoForm)actionForm;
/* 483:    */     try
/* 484:    */     {
/* 485:480 */       Vehiculos vehiculo = (Vehiculos)request.getSession().getAttribute("vehiculo");
/* 486:    */       
/* 487:482 */       List revisiones = (List)request.getSession().getAttribute("REVISIONES");
/* 488:483 */       RevisionesVehiculo revisionVehiculoActual = (RevisionesVehiculo)revisiones.get(Integer.parseInt(request.getParameter("num_revision")));
/* 489:    */       
/* 490:485 */       RevisionesVehiculoDAO revisionesVehiculosDAO = new RevisionesVehiculoDAO();
/* 491:486 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 492:487 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 493:488 */         revisionesVehiculosDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 494:    */       }
/* 495:490 */       RevisionesVehiculo revisionVehiculoBase = revisionesVehiculosDAO.retrive(revisionVehiculoActual.getRveh_cod(), vehiculo.getVehi_cod());
/* 496:492 */       if (revisionVehiculoBase.getRveh_cod() == null)
/* 497:    */       {
/* 498:493 */         revisionesVehiculosDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 499:494 */         revisionVehiculoBase = revisionesVehiculosDAO.retrive(revisionVehiculoActual.getRveh_cod(), IConstantes.CODIGO_VEHICULO_DEFAULT);
/* 500:    */       }
/* 501:497 */       BeanUtils.copyProperties(revisionVehiculoActual, revisionVehiculoBase);
/* 502:    */     }
/* 503:    */     catch (Exception e)
/* 504:    */     {
/* 505:500 */       return mapping.findForward("failure");
/* 506:    */     }
/* 507:503 */     return mapping.findForward("success");
/* 508:    */   }
/* 509:    */   
/* 510:    */   private ActionForward performAdd_gastosMec(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 511:    */   {
/* 512:509 */     GastosVehiculosForm form = (GastosVehiculosForm)actionForm;
/* 513:    */     
/* 514:    */ 
/* 515:    */ 
/* 516:    */ 
/* 517:    */ 
/* 518:    */ 
/* 519:    */ 
/* 520:517 */     return mapping.findForward("success");
/* 521:    */   }
/* 522:    */   
/* 523:    */   private ActionForward performTrasf_gastosMec(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 524:    */   {
/* 525:520 */     GastosVehiculosForm form = (GastosVehiculosForm)actionForm;
/* 526:    */     try
/* 527:    */     {
/* 528:523 */       Vehiculos vehiculo = (Vehiculos)request.getSession().getAttribute("vehiculo");
/* 529:    */       
/* 530:525 */       GastosVehiculosMecanica gastosVehiculosMecanica = new GastosVehiculosMecanica();
/* 531:526 */       InicializaData.inicializa(gastosVehiculosMecanica.getClass(), gastosVehiculosMecanica);
/* 532:527 */       BeanUtils.copyProperties(gastosVehiculosMecanica, form);
/* 533:528 */       gastosVehiculosMecanica.setGasv_veh_cod(vehiculo.getVehi_cod());
/* 534:    */       
/* 535:530 */       List gastos = new ArrayList();
/* 536:532 */       if (request.getSession().getAttribute("GASTOSVEHICULOSMECANICA") != null) {
/* 537:533 */         gastos = (List)request.getSession().getAttribute("GASTOSVEHICULOSMECANICA");
/* 538:    */       }
/* 539:536 */       if (request.getParameter("num_gastosmecanica") == null) {
/* 540:537 */         gastos.add(gastosVehiculosMecanica);
/* 541:    */       } else {
/* 542:539 */         gastos.set(Integer.parseInt(request.getParameter("num_gastosmecanica")), gastosVehiculosMecanica);
/* 543:    */       }
/* 544:542 */       request.getSession().setAttribute("GASTOSVEHICULOSMECANICA", gastos);
/* 545:    */     }
/* 546:    */     catch (Exception e)
/* 547:    */     {
/* 548:545 */       return mapping.findForward("failure");
/* 549:    */     }
/* 550:548 */     return mapping.findForward("success");
/* 551:    */   }
/* 552:    */   
/* 553:    */   private ActionForward performEdit_gastosMec(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 554:    */   {
/* 555:551 */     GastosVehiculosForm form = (GastosVehiculosForm)actionForm;
/* 556:    */     try
/* 557:    */     {
/* 558:554 */       List gastos = (List)request.getSession().getAttribute("GASTOSVEHICULOSMECANICA");
/* 559:555 */       GastosVehiculosMecanica gastosVehiculosMecanica = (GastosVehiculosMecanica)gastos.get(Integer.parseInt(request.getParameter("num_gastosmecanica")));
/* 560:556 */       BeanUtils.copyProperties(form, gastosVehiculosMecanica);
/* 561:557 */       form.setGasv_fechaini(ManejoFechas.FormateoFecha(form.getGasv_fechaini()));
/* 562:558 */       form.setGasv_fechafin(ManejoFechas.FormateoFecha(form.getGasv_fechafin()));
/* 563:    */     }
/* 564:    */     catch (Exception e)
/* 565:    */     {
/* 566:561 */       return mapping.findForward("failure");
/* 567:    */     }
/* 568:564 */     return mapping.findForward("success");
/* 569:    */   }
/* 570:    */   
/* 571:    */   private ActionForward performRemove_gastosMec(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 572:    */   {
/* 573:568 */     GastosVehiculosForm form = (GastosVehiculosForm)actionForm;
/* 574:    */     try
/* 575:    */     {
/* 576:572 */       List gastos = (List)request.getSession().getAttribute("GASTOSVEHICULOSMECANICA");
/* 577:573 */       gastos.remove(Integer.parseInt(request.getParameter("num_gastosmecanica")));
/* 578:    */       
/* 579:575 */       int x = 0;
/* 580:576 */       while (x < gastos.size())
/* 581:    */       {
/* 582:577 */         GastosVehiculosMecanica gastosVehiculosMecanica = (GastosVehiculosMecanica)gastos.get(x);
/* 583:578 */         gastosVehiculosMecanica.setGasv_cod(new BigDecimal(x + 1));
/* 584:579 */         gastos.set(x, gastosVehiculosMecanica);
/* 585:580 */         x++;
/* 586:    */       }
/* 587:583 */       request.getSession().setAttribute("GASTOSVEHICULOSMECANICA", gastos);
/* 588:    */     }
/* 589:    */     catch (Exception e)
/* 590:    */     {
/* 591:585 */       return mapping.findForward("failure");
/* 592:    */     }
/* 593:588 */     return mapping.findForward("success");
/* 594:    */   }
/* 595:    */   
/* 596:    */   private ActionForward performAdd_gastos(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 597:    */   {
/* 598:594 */     GastosVehiculosForm form = (GastosVehiculosForm)actionForm;
/* 599:    */     
/* 600:    */ 
/* 601:    */ 
/* 602:    */ 
/* 603:    */ 
/* 604:    */ 
/* 605:    */ 
/* 606:602 */     return mapping.findForward("success");
/* 607:    */   }
/* 608:    */   
/* 609:    */   private ActionForward performTrasf_gastos(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 610:    */   {
/* 611:605 */     GastosVehiculosForm form = (GastosVehiculosForm)actionForm;
/* 612:    */     try
/* 613:    */     {
/* 614:608 */       Vehiculos vehiculo = (Vehiculos)request.getSession().getAttribute("vehiculo");
/* 615:    */       
/* 616:610 */       GastosVehiculosNoAnuales gastosVehiculosNoAnuales = new GastosVehiculosNoAnuales();
/* 617:611 */       InicializaData.inicializa(gastosVehiculosNoAnuales.getClass(), gastosVehiculosNoAnuales);
/* 618:612 */       BeanUtils.copyProperties(gastosVehiculosNoAnuales, form);
/* 619:613 */       gastosVehiculosNoAnuales.setGasv_veh_cod(vehiculo.getVehi_cod());
/* 620:    */       
/* 621:615 */       List gastos = new ArrayList();
/* 622:617 */       if (request.getSession().getAttribute("GASTOSVEHICULOSNOANUALES") != null) {
/* 623:618 */         gastos = (List)request.getSession().getAttribute("GASTOSVEHICULOSNOANUALES");
/* 624:    */       }
/* 625:621 */       if (request.getParameter("num_gastos") == null) {
/* 626:622 */         gastos.add(gastosVehiculosNoAnuales);
/* 627:    */       } else {
/* 628:624 */         gastos.set(Integer.parseInt(request.getParameter("num_gastos")), gastosVehiculosNoAnuales);
/* 629:    */       }
/* 630:627 */       request.getSession().setAttribute("GASTOSVEHICULOSNOANUALES", gastos);
/* 631:    */     }
/* 632:    */     catch (Exception e)
/* 633:    */     {
/* 634:630 */       return mapping.findForward("failure");
/* 635:    */     }
/* 636:633 */     return mapping.findForward("success");
/* 637:    */   }
/* 638:    */   
/* 639:    */   private ActionForward performEdit_gastos(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 640:    */   {
/* 641:636 */     GastosVehiculosForm form = (GastosVehiculosForm)actionForm;
/* 642:    */     try
/* 643:    */     {
/* 644:639 */       List gastos = (List)request.getSession().getAttribute("GASTOSVEHICULOSNOANUALES");
/* 645:640 */       GastosVehiculosNoAnuales gastosVehiculosNoAnuales = (GastosVehiculosNoAnuales)gastos.get(Integer.parseInt(request.getParameter("num_gastos")));
/* 646:641 */       BeanUtils.copyProperties(form, gastosVehiculosNoAnuales);
/* 647:642 */       form.setGasv_fechaini(ManejoFechas.FormateoFecha(form.getGasv_fechaini()));
/* 648:643 */       form.setGasv_fechafin(ManejoFechas.FormateoFecha(form.getGasv_fechafin()));
/* 649:    */     }
/* 650:    */     catch (Exception e)
/* 651:    */     {
/* 652:646 */       return mapping.findForward("failure");
/* 653:    */     }
/* 654:649 */     return mapping.findForward("success");
/* 655:    */   }
/* 656:    */   
/* 657:    */   private ActionForward performRemove_gastos(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 658:    */   {
/* 659:653 */     GastosVehiculosForm form = (GastosVehiculosForm)actionForm;
/* 660:    */     try
/* 661:    */     {
/* 662:657 */       List gastos = new ArrayList();
/* 663:658 */       gastos = (List)request.getSession().getAttribute("GASTOSVEHICULOSNOANUALES");
/* 664:659 */       gastos.remove(Integer.parseInt(request.getParameter("num_gastos")));
/* 665:    */       
/* 666:661 */       int x = 0;
/* 667:662 */       while (x < gastos.size())
/* 668:    */       {
/* 669:663 */         GastosVehiculosNoAnuales gastosVehiculosNoAnuales = (GastosVehiculosNoAnuales)gastos.get(x);
/* 670:664 */         gastosVehiculosNoAnuales.setGasv_cod(new BigDecimal(x + 1));
/* 671:665 */         gastos.set(x, gastosVehiculosNoAnuales);
/* 672:666 */         x++;
/* 673:    */       }
/* 674:669 */       request.getSession().setAttribute("GASTOSVEHICULOSNOANUALES", gastos);
/* 675:    */     }
/* 676:    */     catch (Exception e)
/* 677:    */     {
/* 678:671 */       return mapping.findForward("failure");
/* 679:    */     }
/* 680:674 */     return mapping.findForward("success");
/* 681:    */   }
/* 682:    */   
/* 683:    */   private ActionForward performAdd_gastosanuales(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 684:    */   {
/* 685:680 */     GastosVehiculosForm form = (GastosVehiculosForm)actionForm;
/* 686:    */     
/* 687:    */ 
/* 688:    */ 
/* 689:    */ 
/* 690:    */ 
/* 691:    */ 
/* 692:    */ 
/* 693:688 */     return mapping.findForward("success");
/* 694:    */   }
/* 695:    */   
/* 696:    */   private ActionForward performTrasf_gastosanuales(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 697:    */   {
/* 698:691 */     GastosVehiculosForm form = (GastosVehiculosForm)actionForm;
/* 699:    */     try
/* 700:    */     {
/* 701:694 */       Vehiculos vehiculo = (Vehiculos)request.getSession().getAttribute("vehiculo");
/* 702:    */       
/* 703:696 */       GastosVehiculosAnuales gastosVehiculosAnuales = new GastosVehiculosAnuales();
/* 704:697 */       InicializaData.inicializa(gastosVehiculosAnuales.getClass(), gastosVehiculosAnuales);
/* 705:698 */       BeanUtils.copyProperties(gastosVehiculosAnuales, form);
/* 706:699 */       gastosVehiculosAnuales.setGasv_veh_cod(vehiculo.getVehi_cod());
/* 707:    */       
/* 708:701 */       List gastos = new ArrayList();
/* 709:703 */       if (request.getSession().getAttribute("GASTOSVEHICULOSANUALES") != null) {
/* 710:704 */         gastos = (List)request.getSession().getAttribute("GASTOSVEHICULOSANUALES");
/* 711:    */       }
/* 712:707 */       if (request.getParameter("num_gastosanuales") == null) {
/* 713:708 */         gastos.add(gastosVehiculosAnuales);
/* 714:    */       } else {
/* 715:710 */         gastos.set(Integer.parseInt(request.getParameter("num_gastosanuales")), gastosVehiculosAnuales);
/* 716:    */       }
/* 717:713 */       request.getSession().setAttribute("GASTOSVEHICULOSANUALES", gastos);
/* 718:    */     }
/* 719:    */     catch (Exception e)
/* 720:    */     {
/* 721:716 */       return mapping.findForward("failure");
/* 722:    */     }
/* 723:719 */     return mapping.findForward("success");
/* 724:    */   }
/* 725:    */   
/* 726:    */   private ActionForward performEdit_gastosanuales(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 727:    */   {
/* 728:722 */     GastosVehiculosForm form = (GastosVehiculosForm)actionForm;
/* 729:    */     try
/* 730:    */     {
/* 731:725 */       List gastos = (List)request.getSession().getAttribute("GASTOSVEHICULOSANUALES");
/* 732:726 */       GastosVehiculosAnuales gastosVehiculosAnuales = (GastosVehiculosAnuales)gastos.get(Integer.parseInt(request.getParameter("num_gastosanuales")));
/* 733:727 */       BeanUtils.copyProperties(form, gastosVehiculosAnuales);
/* 734:728 */       form.setGasv_fechaini(ManejoFechas.FormateoFecha(form.getGasv_fechaini()));
/* 735:729 */       form.setGasv_fechafin(ManejoFechas.FormateoFecha(form.getGasv_fechafin()));
/* 736:    */     }
/* 737:    */     catch (Exception e)
/* 738:    */     {
/* 739:732 */       return mapping.findForward("failure");
/* 740:    */     }
/* 741:735 */     return mapping.findForward("success");
/* 742:    */   }
/* 743:    */   
/* 744:    */   private ActionForward performRemove_gastosanuales(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 745:    */   {
/* 746:739 */     GastosVehiculosForm form = (GastosVehiculosForm)actionForm;
/* 747:    */     try
/* 748:    */     {
/* 749:743 */       List gastos = new ArrayList();
/* 750:744 */       gastos = (List)request.getSession().getAttribute("GASTOSVEHICULOSANUALES");
/* 751:745 */       gastos.remove(Integer.parseInt(request.getParameter("num_gastosanuales")));
/* 752:    */       
/* 753:747 */       int x = 0;
/* 754:748 */       while (x < gastos.size())
/* 755:    */       {
/* 756:749 */         GastosVehiculosAnuales gastosVehiculosAnuales = (GastosVehiculosAnuales)gastos.get(x);
/* 757:750 */         gastosVehiculosAnuales.setGasv_cod(new BigDecimal(x + 1));
/* 758:751 */         gastos.set(x, gastosVehiculosAnuales);
/* 759:752 */         x++;
/* 760:    */       }
/* 761:755 */       request.getSession().setAttribute("GASTOSVEHICULOSANUALES", gastos);
/* 762:    */     }
/* 763:    */     catch (Exception e)
/* 764:    */     {
/* 765:757 */       return mapping.findForward("failure");
/* 766:    */     }
/* 767:760 */     return mapping.findForward("success");
/* 768:    */   }
/* 769:    */   
/* 770:    */   private ActionForward performAdd_impuesto(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 771:    */   {
/* 772:766 */     ImpuestoVehiculoForm form = (ImpuestoVehiculoForm)actionForm;
/* 773:    */     
/* 774:    */ 
/* 775:    */ 
/* 776:    */ 
/* 777:    */ 
/* 778:    */ 
/* 779:    */ 
/* 780:774 */     return mapping.findForward("success");
/* 781:    */   }
/* 782:    */   
/* 783:    */   private ActionForward performTrasf_impuestos(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 784:    */   {
/* 785:777 */     ImpuestoVehiculoForm form = (ImpuestoVehiculoForm)actionForm;
/* 786:    */     try
/* 787:    */     {
/* 788:780 */       Vehiculos vehiculo = (Vehiculos)request.getSession().getAttribute("vehiculo");
/* 789:    */       
/* 790:    */ 
/* 791:783 */       int diasAntes = 0;
/* 792:784 */       String diasAntesS = null;
/* 793:785 */       if (request.getSession().getAttribute("IMPUESTOSVEHICULOSDIAS") != null)
/* 794:    */       {
/* 795:786 */         diasAntesS = request.getSession().getAttribute("IMPUESTOSVEHICULOSDIAS").toString();
/* 796:787 */         diasAntes = diasAntesS != null ? new Integer(diasAntesS).intValue() : 0;
/* 797:    */       }
/* 798:789 */       ImpuestoVehiculo impuestoVehiculo = new ImpuestoVehiculo();
/* 799:790 */       InicializaData.inicializa(impuestoVehiculo.getClass(), impuestoVehiculo);
/* 800:791 */       BeanUtils.copyProperties(impuestoVehiculo, form);
/* 801:792 */       impuestoVehiculo.setImpv_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(impuestoVehiculo.getImpv_vigenciahasta().toString(), "yyyyMMdd", -2)));
/* 802:793 */       impuestoVehiculo.setImpv_fecenvion(new BigDecimal(GestorFechasCompleto.fechaMasDias(impuestoVehiculo.getImpv_vigenciahasta().toString(), "yyyyMMdd", -diasAntes)));
/* 803:794 */       impuestoVehiculo.setImpv_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(impuestoVehiculo.getImpv_fecenvio2().toString(), "yyyyMMdd", 17)));
/* 804:    */       
/* 805:    */ 
/* 806:    */ 
/* 807:798 */       impuestoVehiculo.setImpv_veh_cod(vehiculo.getVehi_cod());
/* 808:799 */       impuestoVehiculo.setImpv_grup_cod(IGrupos.CARS_IMPUESTOS);
/* 809:    */       
/* 810:801 */       List impuestos = new ArrayList();
/* 811:803 */       if (request.getSession().getAttribute("IMPUESTOS") != null) {
/* 812:804 */         impuestos = (List)request.getSession().getAttribute("IMPUESTOS");
/* 813:    */       }
/* 814:807 */       if (request.getParameter("num_impuesto") == null) {
/* 815:808 */         impuestos.add(impuestoVehiculo);
/* 816:    */       } else {
/* 817:810 */         impuestos.set(Integer.parseInt(request.getParameter("num_impuesto")), impuestoVehiculo);
/* 818:    */       }
/* 819:813 */       request.getSession().setAttribute("IMPUESTOS", impuestos);
/* 820:    */     }
/* 821:    */     catch (Exception e)
/* 822:    */     {
/* 823:816 */       return mapping.findForward("failure");
/* 824:    */     }
/* 825:819 */     return mapping.findForward("success");
/* 826:    */   }
/* 827:    */   
/* 828:    */   private ActionForward performEdit_impuestos(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 829:    */   {
/* 830:822 */     ImpuestoVehiculoForm form = (ImpuestoVehiculoForm)actionForm;
/* 831:    */     try
/* 832:    */     {
/* 833:825 */       List impuestos = (List)request.getSession().getAttribute("IMPUESTOS");
/* 834:826 */       ImpuestoVehiculo impuestoVehiculo = (ImpuestoVehiculo)impuestos.get(Integer.parseInt(request.getParameter("num_impuesto")));
/* 835:827 */       BeanUtils.copyProperties(form, impuestoVehiculo);
/* 836:828 */       form.setImpv_fechapago(ManejoFechas.FormateoFecha(form.getImpv_fechapago()));
/* 837:829 */       form.setImpv_vigenciahasta(ManejoFechas.FormateoFecha(form.getImpv_vigenciahasta()));
/* 838:    */     }
/* 839:    */     catch (Exception e)
/* 840:    */     {
/* 841:832 */       return mapping.findForward("failure");
/* 842:    */     }
/* 843:835 */     return mapping.findForward("success");
/* 844:    */   }
/* 845:    */   
/* 846:    */   private ActionForward performRemove_impuestos(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 847:    */   {
/* 848:839 */     ImpuestoVehiculoForm form = (ImpuestoVehiculoForm)actionForm;
/* 849:    */     try
/* 850:    */     {
/* 851:843 */       List impuestos = (List)request.getSession().getAttribute("IMPUESTOS");
/* 852:844 */       impuestos.remove(Integer.parseInt(request.getParameter("num_impuesto")));
/* 853:    */       
/* 854:846 */       int x = 0;
/* 855:847 */       while (x < impuestos.size())
/* 856:    */       {
/* 857:848 */         ImpuestoVehiculo impuestoVehiculo = (ImpuestoVehiculo)impuestos.get(x);
/* 858:849 */         impuestoVehiculo.setImpv_cod(new BigDecimal(x + 1));
/* 859:850 */         impuestos.set(x, impuestoVehiculo);
/* 860:851 */         x++;
/* 861:    */       }
/* 862:854 */       request.getSession().setAttribute("IMPUESTOS", impuestos);
/* 863:    */     }
/* 864:    */     catch (Exception e)
/* 865:    */     {
/* 866:856 */       return mapping.findForward("failure");
/* 867:    */     }
/* 868:859 */     return mapping.findForward("success");
/* 869:    */   }
/* 870:    */   
/* 871:    */   private ActionForward performAdd_combustible(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 872:    */   {
/* 873:865 */     CombustibleForm form = (CombustibleForm)actionForm;
/* 874:    */     
/* 875:    */ 
/* 876:    */ 
/* 877:    */ 
/* 878:    */ 
/* 879:    */ 
/* 880:    */ 
/* 881:873 */     return mapping.findForward("success");
/* 882:    */   }
/* 883:    */   
/* 884:    */   private ActionForward performTrasf_combustible(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 885:    */   {
/* 886:876 */     CombustibleForm form = (CombustibleForm)actionForm;
/* 887:    */     try
/* 888:    */     {
/* 889:879 */       Vehiculos vehiculo = (Vehiculos)request.getSession().getAttribute("vehiculo");
/* 890:    */       
/* 891:881 */       Combustible combustible = new Combustible();
/* 892:882 */       InicializaData.inicializa(combustible.getClass(), combustible);
/* 893:883 */       BeanUtils.copyProperties(combustible, form);
/* 894:884 */       combustible.setCom_veh_cod(vehiculo.getVehi_cod());
/* 895:    */       
/* 896:886 */       List combustibles = new ArrayList();
/* 897:888 */       if (request.getSession().getAttribute("COMBUSTIBLEVEHICULO") != null) {
/* 898:889 */         combustibles = (List)request.getSession().getAttribute("COMBUSTIBLEVEHICULO");
/* 899:    */       }
/* 900:892 */       if ((!form.getCom_lecturaini().equals("0")) && (!form.getCom_lecturafin().equals("0")) && (!form.getCom_cantidadconsumo().equals("0")) && (!form.getCom_costocombustible().equals("0"))) {
/* 901:893 */         if (request.getParameter("num_combustible") == null) {
/* 902:894 */           combustibles.add(combustible);
/* 903:    */         } else {
/* 904:896 */           combustibles.set(Integer.parseInt(request.getParameter("num_combustible")), combustible);
/* 905:    */         }
/* 906:    */       }
/* 907:899 */       request.getSession().setAttribute("COMBUSTIBLEVEHICULO", combustibles);
/* 908:    */     }
/* 909:    */     catch (Exception e)
/* 910:    */     {
/* 911:902 */       return mapping.findForward("failure");
/* 912:    */     }
/* 913:905 */     return mapping.findForward("success");
/* 914:    */   }
/* 915:    */   
/* 916:    */   private ActionForward performEdit_combustible(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 917:    */   {
/* 918:908 */     CombustibleForm form = (CombustibleForm)actionForm;
/* 919:    */     try
/* 920:    */     {
/* 921:911 */       List combustibles = (List)request.getSession().getAttribute("COMBUSTIBLEVEHICULO");
/* 922:912 */       Combustible combustible = (Combustible)combustibles.get(Integer.parseInt(request.getParameter("num_combustible")));
/* 923:913 */       BeanUtils.copyProperties(form, combustible);
/* 924:914 */       form.setCom_fechaini(ManejoFechas.FormateoFecha(form.getCom_fechaini()));
/* 925:915 */       form.setCom_fechafin(ManejoFechas.FormateoFecha(form.getCom_fechafin()));
/* 926:    */     }
/* 927:    */     catch (Exception e)
/* 928:    */     {
/* 929:918 */       return mapping.findForward("failure");
/* 930:    */     }
/* 931:921 */     return mapping.findForward("success");
/* 932:    */   }
/* 933:    */   
/* 934:    */   private ActionForward performRemove_combustible(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 935:    */   {
/* 936:925 */     CombustibleForm form = (CombustibleForm)actionForm;
/* 937:    */     try
/* 938:    */     {
/* 939:929 */       List combustibles = (List)request.getSession().getAttribute("COMBUSTIBLEVEHICULO");
/* 940:930 */       combustibles.remove(Integer.parseInt(request.getParameter("num_combustible")));
/* 941:    */       
/* 942:932 */       int x = 0;
/* 943:933 */       while (x < combustibles.size())
/* 944:    */       {
/* 945:934 */         Combustible combustible = (Combustible)combustibles.get(x);
/* 946:935 */         combustible.setCom_cod(new BigDecimal(x + 1));
/* 947:936 */         combustibles.set(x, combustible);
/* 948:937 */         x++;
/* 949:    */       }
/* 950:940 */       request.getSession().setAttribute("COMBUSTIBLEVEHICULO", combustibles);
/* 951:    */     }
/* 952:    */     catch (Exception e)
/* 953:    */     {
/* 954:942 */       return mapping.findForward("failure");
/* 955:    */     }
/* 956:945 */     return mapping.findForward("success");
/* 957:    */   }
/* 958:    */ }



/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\

 * Qualified Name:     com.servidoctor.sdcars.controller.PopupAction

 * JD-Core Version:    0.7.0.1

 */