/*   1:    */ package com.servidoctor.sdfamily.controller;
/*   2:    */ 
/*   3:    */ import com.essecorp.util.GestorFechasCompleto;
/*   4:    */ import com.servidoctor.constantes.IConstantes;
/*   5:    */ import com.servidoctor.constantes.IGrupos;
/*   6:    */ import com.servidoctor.parametros.dao.CiudadDAO;
/*   7:    */ import com.servidoctor.parametros.dao.OdontologiaDAO;
/*   8:    */ import com.servidoctor.parametros.dao.PaisDAO;
/*   9:    */ import com.servidoctor.parametros.model.Odontologia;
/*  10:    */ import com.servidoctor.parametros.model.Paises;
/*  11:    */ import com.servidoctor.sdfamily.dao.GruposUsuarioDAO;
/*  12:    */ import com.servidoctor.sdfamily.model.ControlOdontologia;
/*  13:    */ import com.servidoctor.sdfamily.model.GruposUsuario;
/*  14:    */ import com.servidoctor.sdfamily.model.OdontologiaUsuario;
/*  15:    */ import com.servidoctor.seguridad.model.Servidores;
/*  16:    */ import com.servidoctor.seguridad.model.UsuarioFamily;
/*  17:    */ import com.servidoctor.util.classes.InicializaData;
/*  18:    */ import com.servidoctor.util.classes.ManejoFechas;
/*  19:    */ import java.math.BigDecimal;
/*  20:    */ import java.util.ArrayList;
/*  21:    */ import java.util.Iterator;
/*  22:    */ import java.util.List;
/*  23:    */ import javax.servlet.http.HttpServletRequest;
/*  24:    */ import javax.servlet.http.HttpServletResponse;
/*  25:    */ import javax.servlet.http.HttpSession;
/*  26:    */ import org.apache.commons.beanutils.BeanUtils;
/*  27:    */ import org.apache.struts.action.Action;
/*  28:    */ import org.apache.struts.action.ActionForm;
/*  29:    */ import org.apache.struts.action.ActionForward;
/*  30:    */ import org.apache.struts.action.ActionMapping;
/*  31:    */ 
/*  32:    */ public class PopupControlesOdontAction
/*  33:    */   extends Action
/*  34:    */ {
/*  35:    */   public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  36:    */     throws Exception
/*  37:    */   {
/*  38: 37 */     ActionForward myforward = null;
/*  39: 38 */     String myaction = mapping.getParameter();
/*  40: 40 */     if ("".equalsIgnoreCase(myaction)) {
/*  41: 41 */       myforward = mapping.findForward("failure");
/*  42: 42 */     } else if ("TRANSFER_TABLA".equalsIgnoreCase(myaction)) {
/*  43: 43 */       myforward = performTrasf_tabla(mapping, actionForm, request, response);
/*  44: 44 */     } else if ("EDIT_TABLA".equalsIgnoreCase(myaction)) {
/*  45: 45 */       myforward = performEdit_tabla(mapping, actionForm, request, response);
/*  46: 46 */     } else if ("ADD_TABLA".equalsIgnoreCase(myaction)) {
/*  47: 47 */       myforward = performAdd_tabla(mapping, actionForm, request, response);
/*  48: 48 */     } else if ("REMOVE_TABLA".equalsIgnoreCase(myaction)) {
/*  49: 49 */       myforward = performRemove_tabla(mapping, actionForm, request, response);
/*  50: 50 */     } else if ("TRANSFER_CONTROLU".equalsIgnoreCase(myaction)) {
/*  51: 51 */       myforward = performTrasf_controlu(mapping, actionForm, request, response);
/*  52: 52 */     } else if ("EDIT_CONTROLU".equalsIgnoreCase(myaction)) {
/*  53: 53 */       myforward = performEdit_controlu(mapping, actionForm, request, response);
/*  54: 54 */     } else if ("TRANSFER_CONTROLP".equalsIgnoreCase(myaction)) {
/*  55: 55 */       myforward = performTrasf_controlp(mapping, actionForm, request, response);
/*  56: 56 */     } else if ("EDIT_CONTROLP".equalsIgnoreCase(myaction)) {
/*  57: 57 */       myforward = performEdit_controlp(mapping, actionForm, request, response);
/*  58:    */     } else {
/*  59: 59 */       myforward = mapping.findForward("failure");
/*  60:    */     }
/*  61: 62 */     return myforward;
/*  62:    */   }
/*  63:    */   
/*  64:    */   private ActionForward performTrasf_tabla(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  65:    */   {
/*  66: 66 */     OdontologiaUsuarioForm form = (OdontologiaUsuarioForm)actionForm;
/*  67:    */     try
/*  68:    */     {
/*  69: 68 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/*  70: 69 */       GruposUsuarioDAO gruposUsuarioDAO = new GruposUsuarioDAO();
/*  71:    */       
/*  72: 71 */       List listaTabla = null;
/*  73: 72 */       if (request.getSession().getAttribute("CONTROLES_ODON_T") != null) {
/*  74: 73 */         listaTabla = (List)request.getSession().getAttribute("CONTROLES_ODON_T");
/*  75:    */       } else {
/*  76: 75 */         listaTabla = new ArrayList();
/*  77:    */       }
/*  78: 78 */       List controlesAnteriores = null;
/*  79: 79 */       List controlesProximos = null;
/*  80: 80 */       if (request.getSession().getAttribute("CONTROLES_ODON_U") != null) {
/*  81: 81 */         controlesAnteriores = (List)request.getSession().getAttribute("CONTROLES_ODON_U");
/*  82:    */       } else {
/*  83: 83 */         controlesAnteriores = new ArrayList();
/*  84:    */       }
/*  85: 85 */       if (request.getSession().getAttribute("CONTROLES_ODON_P") != null) {
/*  86: 86 */         controlesProximos = (List)request.getSession().getAttribute("CONTROLES_ODON_P");
/*  87:    */       } else {
/*  88: 88 */         controlesProximos = new ArrayList();
/*  89:    */       }
/*  90: 91 */       OdontologiaUsuario odontologiaUsuario = null;
/*  91: 92 */       OdontologiaDAO odontologiaDAO = new OdontologiaDAO();
/*  92: 93 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  93: 94 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  94: 95 */         odontologiaDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  95:    */       }
/*  96: 97 */       //odontologiaDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    odontologiaDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
                    
/*  97: 98 */       List tablaUniversal = odontologiaDAO.list();
/*  98: 99 */       Odontologia temp = new Odontologia();
/*  99:100 */       InicializaData.inicializa(temp.getClass(), temp);
/* 100:102 */       if (request.getParameter("num_tabla") == null)
/* 101:    */       {
/* 102:103 */         odontologiaUsuario = new OdontologiaUsuario();
/* 103:104 */         InicializaData.inicializa(odontologiaUsuario.getClass(), odontologiaUsuario);
/* 104:105 */         BeanUtils.copyProperties(odontologiaUsuario, form);
/* 105:106 */         odontologiaUsuario.setOdou_usuf_cod(usuarioFamily.getUsuf_cod());
/* 106:107 */         listaTabla.add(odontologiaUsuario);
/* 107:108 */         ControlOdontologia control = new ControlOdontologia();
/* 108:109 */         InicializaData.inicializa(control.getClass(), control);
/* 109:110 */         control.setCodo_usuf_cod(usuarioFamily.getUsuf_cod());
/* 110:111 */         control.setElementoTabla(odontologiaUsuario);
/* 111:112 */         if (!odontologiaUsuario.getOdou_odo_cod().equals(IConstantes.CODIGO_NO_EXISTE))
/* 112:    */         {
/* 113:113 */           temp.setOdo_cod(odontologiaUsuario.getOdou_odo_cod());
/* 114:114 */           control.setCodo_destratamiento(((Odontologia)tablaUniversal.get(tablaUniversal.indexOf(temp))).getOdo_destratamiento());
/* 115:    */         }
/* 116:    */         else
/* 117:    */         {
/* 118:116 */           control.setCodo_destratamiento(odontologiaUsuario.getOdou_destratamiento());
/* 119:    */         }
/* 120:118 */         control.setCodo_grup_cod(IGrupos.FAMILY_ODONTOLOGIA);
/* 121:119 */         control.setCodo_tipo(IConstantes.CODIGO_CONTROL_ANTERIOR);
/* 122:120 */         controlesAnteriores.add(control);
/* 123:121 */         control = new ControlOdontologia();
/* 124:122 */         control.setCodo_usuf_cod(usuarioFamily.getUsuf_cod());
/* 125:123 */         InicializaData.inicializa(control.getClass(), control);
/* 126:124 */         control.setElementoTabla(odontologiaUsuario);
/* 127:125 */         if (!odontologiaUsuario.getOdou_odo_cod().equals(IConstantes.CODIGO_NO_EXISTE))
/* 128:    */         {
/* 129:126 */           temp.setOdo_cod(odontologiaUsuario.getOdou_odo_cod());
/* 130:127 */           control.setCodo_destratamiento(((Odontologia)tablaUniversal.get(tablaUniversal.indexOf(temp))).getOdo_destratamiento());
/* 131:    */         }
/* 132:    */         else
/* 133:    */         {
/* 134:129 */           control.setCodo_destratamiento(odontologiaUsuario.getOdou_destratamiento());
/* 135:    */         }
/* 136:131 */         control.setCodo_grup_cod(IGrupos.FAMILY_ODONTOLOGIA);
/* 137:132 */         control.setCodo_tipo(IConstantes.CODIGO_CONTROL_PROXIMO);
/* 138:    */         
/* 139:134 */         controlesProximos.add(control);
/* 140:    */       }
/* 141:    */       else
/* 142:    */       {
/* 143:147 */         odontologiaUsuario = new OdontologiaUsuario();
/* 144:148 */         InicializaData.inicializa(odontologiaUsuario.getClass(), odontologiaUsuario);
/* 145:149 */         BeanUtils.copyProperties(odontologiaUsuario, form);
/* 146:150 */         odontologiaUsuario.setOdou_usuf_cod(usuarioFamily.getUsuf_cod());
/* 147:151 */         listaTabla.set(Integer.parseInt(request.getParameter("num_tabla")), odontologiaUsuario);
/* 148:152 */         ControlOdontologia control = (ControlOdontologia)controlesAnteriores.get(Integer.parseInt(request.getParameter("num_tabla")));
/* 149:153 */         control.setCodo_usuf_cod(usuarioFamily.getUsuf_cod());
/* 150:154 */         control.setElementoTabla(odontologiaUsuario);
/* 151:155 */         if (!odontologiaUsuario.getOdou_odo_cod().equals(IConstantes.CODIGO_NO_EXISTE))
/* 152:    */         {
/* 153:156 */           temp.setOdo_cod(odontologiaUsuario.getOdou_odo_cod());
/* 154:157 */           control.setCodo_destratamiento(((Odontologia)tablaUniversal.get(tablaUniversal.indexOf(temp))).getOdo_destratamiento());
/* 155:    */         }
/* 156:    */         else
/* 157:    */         {
/* 158:159 */           control.setCodo_destratamiento(odontologiaUsuario.getOdou_destratamiento());
/* 159:    */         }
/* 160:161 */         control.setCodo_grup_cod(IGrupos.FAMILY_ODONTOLOGIA);
/* 161:    */         
/* 162:163 */         GruposUsuario gruposUsuario = gruposUsuarioDAO.retrieve(control.getCodo_usuf_cod(), control.getCodo_grup_cod());
/* 163:164 */         int diasantes = gruposUsuario.getGrupu_dias_antes().intValue();
/* 164:165 */         control.setCodo_tipo(IConstantes.CODIGO_CONTROL_ANTERIOR);
/* 165:166 */         controlesAnteriores.set(Integer.parseInt(request.getParameter("num_tabla")), control);
/* 166:167 */         control = (ControlOdontologia)controlesProximos.get(Integer.parseInt(request.getParameter("num_tabla")));
/* 167:168 */         control.setCodo_usuf_cod(usuarioFamily.getUsuf_cod());
/* 168:169 */         control.setElementoTabla(odontologiaUsuario);
/* 169:170 */         if (!odontologiaUsuario.getOdou_odo_cod().equals(IConstantes.CODIGO_NO_EXISTE))
/* 170:    */         {
/* 171:171 */           temp.setOdo_cod(odontologiaUsuario.getOdou_odo_cod());
/* 172:172 */           control.setCodo_destratamiento(((Odontologia)tablaUniversal.get(tablaUniversal.indexOf(temp))).getOdo_destratamiento());
/* 173:    */         }
/* 174:    */         else
/* 175:    */         {
/* 176:174 */           control.setCodo_destratamiento(odontologiaUsuario.getOdou_destratamiento());
/* 177:    */         }
/* 178:176 */         control.setCodo_grup_cod(IGrupos.FAMILY_ODONTOLOGIA);
/* 179:177 */         control.setCodo_tipo(IConstantes.CODIGO_CONTROL_PROXIMO);
/* 180:    */         
/* 181:179 */         controlesProximos.set(Integer.parseInt(request.getParameter("num_tabla")), control);
/* 182:    */       }
/* 183:182 */       request.getSession().setAttribute("CONTROLES_ODON_T", listaTabla);
/* 184:183 */       request.getSession().setAttribute("CONTROLES_ODON_U", controlesAnteriores);
/* 185:184 */       request.getSession().setAttribute("CONTROLES_ODON_P", controlesProximos);
/* 186:    */     }
/* 187:    */     catch (Exception e)
/* 188:    */     {
/* 189:188 */       return mapping.findForward("failure");
/* 190:    */     }
/* 191:191 */     return mapping.findForward("success");
/* 192:    */   }
/* 193:    */   
/* 194:    */   private ActionForward performEdit_tabla(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 195:    */   {
/* 196:195 */     OdontologiaUsuarioForm form = (OdontologiaUsuarioForm)actionForm;
/* 197:    */     try
/* 198:    */     {
/* 199:199 */       List odontologias = (List)request.getSession().getAttribute("CONTROLES_ODON_T");
/* 200:200 */       OdontologiaUsuario odontologiaUsuario = (OdontologiaUsuario)odontologias.get(Integer.parseInt(request.getParameter("num_tabla")));
/* 201:201 */       BeanUtils.copyProperties(form, odontologiaUsuario);
/* 202:    */       
/* 203:203 */       OdontologiaDAO odontologiaDAO = new OdontologiaDAO();
/* 204:204 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 205:205 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 206:206 */         odontologiaDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 207:    */       }
/* 208:208 */       //odontologiaDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    odontologiaDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
                    
/* 209:209 */       List listOdontologia = odontologiaDAO.list();
/* 210:    */       
/* 211:211 */       Odontologia odontologiaTemp = new Odontologia();
/* 212:212 */       for (Iterator iter = odontologias.iterator(); iter.hasNext();)
/* 213:    */       {
/* 214:213 */         OdontologiaUsuario odontologiaUsu = (OdontologiaUsuario)iter.next();
/* 215:214 */         if (!odontologiaUsu.equals(odontologiaUsuario))
/* 216:    */         {
/* 217:215 */           odontologiaTemp.setOdo_cod(odontologiaUsu.getOdou_odo_cod());
/* 218:216 */           listOdontologia.remove(odontologiaTemp);
/* 219:    */         }
/* 220:    */       }
/* 221:219 */       request.setAttribute("LISTAUNIVERSAL", listOdontologia);
/* 222:    */     }
/* 223:    */     catch (Exception e)
/* 224:    */     {
/* 225:222 */       return mapping.findForward("failure");
/* 226:    */     }
/* 227:224 */     return mapping.findForward("success");
/* 228:    */   }
/* 229:    */   
/* 230:    */   private ActionForward performAdd_tabla(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 231:    */   {
/* 232:227 */     OdontologiaUsuarioForm form = (OdontologiaUsuarioForm)actionForm;
/* 233:    */     try
/* 234:    */     {
/* 235:231 */       OdontologiaDAO odontologiaDAO = new OdontologiaDAO();
/* 236:232 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 237:233 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 238:234 */         odontologiaDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 239:    */       }
/* 240:236 */       //odontologiaDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    odontologiaDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
                    
/* 241:237 */       List listOdontologia = odontologiaDAO.list();
/* 242:    */       
/* 243:239 */       List odontologias = (List)request.getSession().getAttribute("CONTROLES_ODON_T");
/* 244:240 */       if (odontologias == null) {
/* 245:241 */         odontologias = new ArrayList();
/* 246:    */       }
/* 247:243 */       Odontologia odontologiaTemp = new Odontologia();
/* 248:244 */       for (Iterator iter = odontologias.iterator(); iter.hasNext();)
/* 249:    */       {
/* 250:245 */         OdontologiaUsuario odontologiaUsu = (OdontologiaUsuario)iter.next();
/* 251:246 */         odontologiaTemp.setOdo_cod(odontologiaUsu.getOdou_odo_cod());
/* 252:247 */         listOdontologia.remove(odontologiaTemp);
/* 253:    */       }
/* 254:249 */       request.setAttribute("LISTAUNIVERSAL", listOdontologia);
/* 255:    */     }
/* 256:    */     catch (Exception e)
/* 257:    */     {
/* 258:252 */       return mapping.findForward("failure");
/* 259:    */     }
/* 260:254 */     return mapping.findForward("success");
/* 261:    */   }
/* 262:    */   
/* 263:    */   private ActionForward performRemove_tabla(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 264:    */   {
/* 265:257 */     OdontologiaUsuarioForm form = (OdontologiaUsuarioForm)actionForm;
/* 266:    */     try
/* 267:    */     {
/* 268:261 */       List listaTabla = (List)request.getSession().getAttribute("CONTROLES_ODON_T");
/* 269:262 */       List controlesAnteriores = (List)request.getSession().getAttribute("CONTROLES_ODON_U");
/* 270:263 */       List controlesProximos = (List)request.getSession().getAttribute("CONTROLES_ODON_P");
/* 271:    */       
/* 272:265 */       int x = 0;
/* 273:266 */       while (x < controlesAnteriores.size())
/* 274:    */       {
/* 275:267 */         ControlOdontologia control = (ControlOdontologia)controlesAnteriores.get(x);
/* 276:268 */         if (control.getElementoTabla().equals((OdontologiaUsuario)listaTabla.get(Integer.parseInt(request.getParameter("num_tabla"))))) {
/* 277:269 */           controlesAnteriores.remove(x);
/* 278:    */         }
/* 279:271 */         control = (ControlOdontologia)controlesProximos.get(x);
/* 280:272 */         if (control.getElementoTabla().equals((OdontologiaUsuario)listaTabla.get(Integer.parseInt(request.getParameter("num_tabla"))))) {
/* 281:273 */           controlesProximos.remove(x);
/* 282:    */         }
/* 283:275 */         x++;
/* 284:    */       }
/* 285:278 */       listaTabla.remove(Integer.parseInt(request.getParameter("num_tabla")));
/* 286:    */     }
/* 287:    */     catch (Exception e)
/* 288:    */     {
/* 289:281 */       e.printStackTrace();
/* 290:282 */       return mapping.findForward("failure");
/* 291:    */     }
/* 292:284 */     return mapping.findForward("success");
/* 293:    */   }
/* 294:    */   
/* 295:    */   private ActionForward performTrasf_controlu(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 296:    */   {
/* 297:287 */     ControlOdontologiaForm form = (ControlOdontologiaForm)actionForm;
/* 298:    */     try
/* 299:    */     {
/* 300:289 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/* 301:290 */       if (form.getCodo_indpais().length() == 0) {
/* 302:291 */         form.setCodo_indpais("0");
/* 303:    */       }
/* 304:292 */       if (form.getCodo_indciudad().length() == 0) {
/* 305:293 */         form.setCodo_indciudad("0");
/* 306:    */       }
/* 307:296 */       List controles = null;
/* 308:297 */       if (request.getSession().getAttribute("CONTROLES_ODON_U") != null) {
/* 309:298 */         controles = (List)request.getSession().getAttribute("CONTROLES_ODON_U");
/* 310:    */       }
/* 311:301 */       ControlOdontologia control = null;
/* 312:303 */       if (request.getParameter("num_controlu") != null)
/* 313:    */       {
/* 314:306 */         control = (ControlOdontologia)controles.get(Integer.parseInt(request.getParameter("num_controlu")));
/* 315:    */         
/* 316:308 */         form.setCodo_feccontrol(ManejoFechas.getChangeFecha(form.getCodo_feccontrol()));
/* 317:309 */         form.setCodo_cod(control.getCodo_cod().toString());
/* 318:310 */         form.setCodo_grup_cod(control.getCodo_grup_cod().toString());
/* 319:311 */         form.setCodo_mails_enviados(control.getCodo_mails_enviados().toString());
/* 320:312 */         form.setCodo_ultimo_mail(control.getCodo_ultimo_mail().toString());
/* 321:313 */         form.setCodo_usuf_cod(usuarioFamily.getUsuf_cod().toString());
/* 322:314 */         form.setCodo_tipo(IConstantes.CODIGO_CONTROL_ANTERIOR.toString());
/* 323:315 */         form.setCodo_odo_cod(control.getCodo_odo_cod().toString());
/* 324:    */         
/* 325:    */ 
/* 326:    */ 
/* 327:    */ 
/* 328:    */ 
/* 329:    */ 
/* 330:    */ 
/* 331:    */ 
/* 332:    */ 
/* 333:325 */         GruposUsuarioDAO gruposUsuarioDAO = new GruposUsuarioDAO();
/* 334:326 */         GruposUsuario gruposUsuario = gruposUsuarioDAO.retrieve(new BigDecimal(form.getCodo_usuf_cod()), control.getCodo_grup_cod());
/* 335:327 */         int diasAntesn = gruposUsuario.getGrupu_dias_antes().intValue();
/* 336:328 */         int diasAntesn2 = gruposUsuario.getGrupu_dias_antes().intValue() / 2;
/* 337:    */         
/* 338:    */ 
/* 339:    */ 
/* 340:332 */         String controlUltimo = form.getCodo_feccontrol().toString();
/* 341:333 */         String fechaActual = ManejoFechas.getFechaActual();
/* 342:334 */         List odontologias = (List)request.getSession().getAttribute("CONTROLES_ODON_T");
/* 343:335 */         OdontologiaUsuario odontologiaUsuario = (OdontologiaUsuario)odontologias.get(Integer.parseInt(request.getParameter("num_controlu")));
/* 344:    */         
/* 345:337 */         int frecuencia = odontologiaUsuario.getOdou_frecuencia().intValue();
/* 346:338 */         while (controlUltimo.compareTo(fechaActual) < 1) {
/* 347:339 */           controlUltimo = GestorFechasCompleto.fechaMasMeses(controlUltimo, "yyyyMMdd", frecuencia);
/* 348:    */         }
/* 349:341 */         form.setCodo_fecenvio2(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlUltimo), "yyyyMMdd", -2));
/* 350:342 */         form.setCodo_fecenvion(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlUltimo), "yyyyMMdd", -diasAntesn));
/* 351:343 */         form.setCodo_fecenvion2(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlUltimo), "yyyyMMdd", -diasAntesn2));
/* 352:344 */         form.setCodo_quince_dias(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlUltimo), "yyyyMMdd", 15));
/* 353:345 */         control.setCodo_fecenvio2(new BigDecimal(form.getCodo_fecenvio2()));
/* 354:346 */         control.setCodo_fecenvion(new BigDecimal(form.getCodo_fecenvion()));
/* 355:347 */         control.setCodo_fecenvion2(new BigDecimal(form.getCodo_fecenvion2()));
/* 356:348 */         control.setCodo_quince_dias(new BigDecimal(form.getCodo_quince_dias()));
/* 357:349 */         BeanUtils.copyProperties(control, form);
/* 358:350 */         controles.set(Integer.parseInt(request.getParameter("num_controlu")), control);
/* 359:351 */         request.getSession().setAttribute("CONTROLES_ODON_U", controles);
/* 360:    */       }
/* 361:    */     }
/* 362:    */     catch (Exception e)
/* 363:    */     {
/* 364:358 */       return mapping.findForward("failure");
/* 365:    */     }
/* 366:361 */     return mapping.findForward("success");
/* 367:    */   }
/* 368:    */   
/* 369:    */   private ActionForward performEdit_controlu(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 370:    */   {
/* 371:365 */     ControlOdontologiaForm form = (ControlOdontologiaForm)actionForm;
/* 372:    */     try
/* 373:    */     {
/* 374:368 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 375:369 */       OdontologiaDAO odontologiaDAO = new OdontologiaDAO();
/* 376:370 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 377:371 */         odontologiaDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 378:    */       }
/* 379:373 */       //odontologiaDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    odontologiaDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 380:    */       
/* 381:375 */       List controles = new ArrayList();
/* 382:376 */       ControlOdontologia controlMedico = new ControlOdontologia();
/* 383:377 */       controles = (List)request.getSession().getAttribute("CONTROLES_ODON_U");
/* 384:378 */       controlMedico = (ControlOdontologia)controles.get(Integer.parseInt(request.getParameter("num_controlu")));
/* 385:    */       
/* 386:380 */       BeanUtils.copyProperties(form, controlMedico);
/* 387:381 */       if (!controlMedico.getCodo_odo_cod().equals(IConstantes.CODIGO_NO_EXISTE)) {
/* 388:382 */         form.setCodo_destratamiento(odontologiaDAO.retrive(controlMedico.getCodo_odo_cod()).getOdo_destratamiento());
/* 389:    */       }
/* 390:384 */       form.setCodo_feccontrol(ManejoFechas.FormateoFecha(form.getCodo_feccontrol()));
/* 391:    */       
/* 392:386 */       PaisDAO paisDAO = new PaisDAO();
/* 393:387 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 394:388 */         paisDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 395:    */       }
/* 396:390 */       //paisDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    paisDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 397:391 */       List paises = paisDAO.list();
/* 398:392 */       request.setAttribute("PAISES", paises);
/* 399:    */       
/* 400:394 */       List ciudades = null;
/* 401:395 */       CiudadDAO ciudadesDAO = new CiudadDAO();
/* 402:396 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 403:397 */         ciudadesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 404:    */       }
/* 405:399 */       //ciudadesDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    ciudadesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 406:400 */       if ((paises.size() > 0) && (!form.getCodo_pais_cod().equals("0"))) {
/* 407:401 */         ciudades = ciudadesDAO.search(form.getCodo_pais_cod());
/* 408:402 */       } else if (paises.size() > 0) {
/* 409:403 */         ciudades = ciudadesDAO.search(((Paises)paises.get(0)).getPais_cod().toString());
/* 410:    */       }
/* 411:405 */       request.setAttribute("CIUDADES", ciudades);
/* 412:    */     }
/* 413:    */     catch (Exception e)
/* 414:    */     {
/* 415:408 */       return mapping.findForward("failure");
/* 416:    */     }
/* 417:410 */     return mapping.findForward("success");
/* 418:    */   }
/* 419:    */   
/* 420:    */   private ActionForward performRemove_controlu(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 421:    */   {
/* 422:414 */     ControlOdontologiaForm form = (ControlOdontologiaForm)actionForm;
/* 423:    */     try
/* 424:    */     {
/* 425:418 */       List odontologias = new ArrayList();
/* 426:419 */       odontologias = (List)request.getSession().getAttribute("CONTROLES_ODON_U");
/* 427:420 */       int num_controlu = Integer.parseInt(request.getParameter("num_controlu"));
/* 428:421 */       odontologias.remove(num_controlu);
/* 429:422 */       request.getSession().setAttribute("CONTROLES_ODON_U", odontologias);
/* 430:    */     }
/* 431:    */     catch (Exception e)
/* 432:    */     {
/* 433:425 */       return mapping.findForward("failure");
/* 434:    */     }
/* 435:427 */     return mapping.findForward("success");
/* 436:    */   }
/* 437:    */   
/* 438:    */   private ActionForward performTrasf_controlp(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 439:    */   {
/* 440:430 */     ControlOdontologiaForm form = (ControlOdontologiaForm)actionForm;
/* 441:    */     try
/* 442:    */     {
/* 443:432 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/* 444:    */       
/* 445:434 */       List controles = null;
/* 446:435 */       if (request.getSession().getAttribute("CONTROLES_ODON_P") != null) {
/* 447:436 */         controles = (List)request.getSession().getAttribute("CONTROLES_ODON_P");
/* 448:    */       }
/* 449:439 */       ControlOdontologia control = null;
/* 450:441 */       if (request.getParameter("num_controlp") != null)
/* 451:    */       {
/* 452:444 */         control = (ControlOdontologia)controles.get(Integer.parseInt(request.getParameter("num_controlp")));
/* 453:445 */         form.setCodo_feccontrol(ManejoFechas.getChangeFecha(form.getCodo_feccontrol()));
/* 454:446 */         form.setCodo_hora(ManejoFechas.getChangeHoraAMPM(form.getCodo_hora()));
/* 455:447 */         form.setCodo_feccontrol(ManejoFechas.getChangeFecha(form.getCodo_feccontrol()));
/* 456:448 */         form.setCodo_cod(control.getCodo_cod().toString());
/* 457:449 */         form.setCodo_grup_cod(control.getCodo_grup_cod().toString());
/* 458:450 */         form.setCodo_mails_enviados(control.getCodo_mails_enviados().toString());
/* 459:451 */         form.setCodo_ultimo_mail(control.getCodo_ultimo_mail().toString());
/* 460:452 */         form.setCodo_usuf_cod(usuarioFamily.getUsuf_cod().toString());
/* 461:453 */         form.setCodo_tipo(IConstantes.CODIGO_CONTROL_PROXIMO.toString());
/* 462:454 */         form.setCodo_odo_cod(control.getCodo_odo_cod().toString());
/* 463:    */         
/* 464:456 */         GruposUsuarioDAO gruposUsuarioDAO = new GruposUsuarioDAO();
/* 465:457 */         GruposUsuario gruposUsuario = gruposUsuarioDAO.retrieve(new BigDecimal(form.getCodo_usuf_cod()), control.getCodo_grup_cod());
/* 466:458 */         int diasAntesn = gruposUsuario.getGrupu_dias_antes().intValue();
/* 467:459 */         int diasAntesn2 = gruposUsuario.getGrupu_dias_antes().intValue() / 2;
/* 468:460 */         form.setCodo_fecenvio2(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(form.getCodo_feccontrol()), "yyyyMMdd", -2));
/* 469:461 */         form.setCodo_fecenvion(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(form.getCodo_feccontrol()), "yyyyMMdd", -diasAntesn));
/* 470:462 */         form.setCodo_fecenvion2(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(form.getCodo_feccontrol()), "yyyyMMdd", -diasAntesn2));
/* 471:463 */         form.setCodo_quince_dias(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(form.getCodo_feccontrol()), "yyyyMMdd", 16));
/* 472:464 */         control.setCodo_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(form.getCodo_feccontrol()), "yyyyMMdd", -2)));
/* 473:465 */         control.setCodo_fecenvion(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(form.getCodo_feccontrol()), "yyyyMMdd", -diasAntesn)));
/* 474:466 */         control.setCodo_fecenvion2(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(form.getCodo_feccontrol()), "yyyyMMdd", -diasAntesn2)));
/* 475:467 */         control.setCodo_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(form.getCodo_feccontrol()), "yyyyMMdd", 15)));
/* 476:    */         
/* 477:469 */         controles.set(Integer.parseInt(request.getParameter("num_controlp")), control);
/* 478:470 */         request.getSession().setAttribute("CONTROLES_ODON_P", controles);
/* 479:471 */         BeanUtils.copyProperties(control, form);
/* 480:    */       }
/* 481:    */     }
/* 482:    */     catch (Exception e)
/* 483:    */     {
/* 484:489 */       return mapping.findForward("failure");
/* 485:    */     }
/* 486:492 */     return mapping.findForward("success");
/* 487:    */   }
/* 488:    */   
/* 489:    */   private ActionForward performEdit_controlp(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 490:    */   {
/* 491:496 */     ControlOdontologiaForm form = (ControlOdontologiaForm)actionForm;
/* 492:    */     try
/* 493:    */     {
/* 494:499 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 495:500 */       OdontologiaDAO odontologiaDAO = new OdontologiaDAO();
/* 496:501 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 497:502 */         odontologiaDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 498:    */       }
/* 499:504 */       //odontologiaDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    odontologiaDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 500:    */       
/* 501:506 */       List controles = (List)request.getSession().getAttribute("CONTROLES_ODON_P");
/* 502:507 */       ControlOdontologia controlMedico = (ControlOdontologia)controles.get(Integer.parseInt(request.getParameter("num_controlp")));
/* 503:    */       
/* 504:509 */       BeanUtils.copyProperties(form, controlMedico);
/* 505:510 */       if (!controlMedico.getCodo_odo_cod().equals(IConstantes.CODIGO_NO_EXISTE)) {
/* 506:511 */         form.setCodo_destratamiento(odontologiaDAO.retrive(controlMedico.getCodo_odo_cod()).getOdo_destratamiento());
/* 507:    */       }
/* 508:513 */       form.setCodo_feccontrol(ManejoFechas.FormateoFecha(form.getCodo_feccontrol()));
/* 509:514 */       form.setCodo_hora(ManejoFechas.FormateoHoraAMPM(form.getCodo_hora()));
/* 510:    */       
/* 511:516 */       PaisDAO paisDAO = new PaisDAO();
/* 512:517 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 513:518 */         paisDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 514:    */       }
/* 515:520 */       //paisDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    paisDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 516:521 */       List paises = paisDAO.list();
/* 517:522 */       request.setAttribute("PAISES", paises);
/* 518:    */       
/* 519:524 */       List ciudades = null;
/* 520:525 */       CiudadDAO ciudadesDAO = new CiudadDAO();
/* 521:526 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 522:527 */         ciudadesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 523:    */       }
/* 524:529 */       //ciudadesDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    ciudadesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 525:530 */       if ((paises.size() > 0) && (!form.getCodo_pais_cod().equals("0"))) {
/* 526:531 */         ciudades = ciudadesDAO.search(form.getCodo_pais_cod());
/* 527:532 */       } else if (paises.size() > 0) {
/* 528:533 */         ciudades = ciudadesDAO.search(((Paises)paises.get(0)).getPais_cod().toString());
/* 529:    */       }
/* 530:535 */       request.setAttribute("CIUDADES", ciudades);
/* 531:    */     }
/* 532:    */     catch (Exception e)
/* 533:    */     {
/* 534:538 */       return mapping.findForward("failure");
/* 535:    */     }
/* 536:540 */     return mapping.findForward("success");
/* 537:    */   }
/* 538:    */ }



/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\

 * Qualified Name:     com.servidoctor.sdfamily.controller.PopupControlesOdontAction

 * JD-Core Version:    0.7.0.1

 */