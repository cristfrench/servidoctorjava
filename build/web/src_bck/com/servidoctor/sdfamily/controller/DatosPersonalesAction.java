/*   1:    */ package com.servidoctor.sdfamily.controller;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.controller.BaseAction;
/*   4:    */ import com.servidoctor.constantes.IConstantes;
/*   5:    */ import com.servidoctor.constantes.IGrupos;
/*   6:    */ import com.servidoctor.parametros.dao.CiudadDAO;
/*   7:    */ import com.servidoctor.parametros.dao.DocumentoDAO;
/*   8:    */ import com.servidoctor.parametros.dao.EscolaridadDAO;
/*   9:    */ import com.servidoctor.parametros.dao.EstadoCivilDAO;
/*  10:    */ import com.servidoctor.parametros.dao.GruposDAO;
/*  11:    */ import com.servidoctor.parametros.dao.IdiomaDAO;
/*  12:    */ import com.servidoctor.parametros.dao.PaisDAO;
/*  13:    */ import com.servidoctor.parametros.dao.ParentescoDAO;
/*  14:    */ import com.servidoctor.parametros.dao.TipoSangreDAO;
/*  15:    */ import com.servidoctor.parametros.model.Antecedentes;
/*  16:    */ import com.servidoctor.parametros.model.ElementoConsumo;
/*  17:    */ import com.servidoctor.parametros.model.Examenes;
/*  18:    */ import com.servidoctor.parametros.model.GinecologiaOperaciones;
/*  19:    */ import com.servidoctor.parametros.model.Grupos;
/*  20:    */ import com.servidoctor.parametros.model.Odontologia;
/*  21:    */ import com.servidoctor.parametros.model.Optometria;
/*  22:    */ import com.servidoctor.parametros.model.Paises;
/*  23:    */ import com.servidoctor.parametros.model.Parentesco;
/*  24:    */ import com.servidoctor.parametros.model.PartesCuerpo;
/*  25:    */ import com.servidoctor.parametros.model.Vacunas;
/*  26:    */ import com.servidoctor.sdfamily.dao.DatosPersonalesCompletoDAO;
/*  27:    */ import com.servidoctor.sdfamily.dao.FamilyCompletoDAO;
/*  28:    */ import com.servidoctor.sdfamily.dao.GruposUsuarioDAO;
/*  29:    */ import com.servidoctor.sdfamily.dao.HistoriaMedicaDAO;
/*  30:    */ import com.servidoctor.sdfamily.dao.MedicinaCompletoDAO;
/*  31:    */ import com.servidoctor.sdfamily.dao.OdontologiaCompletoDAO;
/*  32:    */ import com.servidoctor.sdfamily.dao.OptometriaCompletoDAO;
/*  33:    */ import com.servidoctor.sdfamily.dao.VacunasCompletoDAO;
/*  34:    */ import com.servidoctor.sdfamily.model.AntecedentesUsuario;
/*  35:    */ import com.servidoctor.sdfamily.model.ControlMedico;
/*  36:    */ import com.servidoctor.sdfamily.model.ControlOdontologia;
/*  37:    */ import com.servidoctor.sdfamily.model.ControlOptometria;
/*  38:    */ import com.servidoctor.sdfamily.model.DatosPersonales;
/*  39:    */ import com.servidoctor.sdfamily.model.DatosPersonalesCompleto;
/*  40:    */ import com.servidoctor.sdfamily.model.ElementoConsumoUsuario;
/*  41:    */ import com.servidoctor.sdfamily.model.ExamenesUsuario;
/*  42:    */ import com.servidoctor.sdfamily.model.FamilyCompleto;
/*  43:    */ import com.servidoctor.sdfamily.model.Ginecologia;
/*  44:    */ import com.servidoctor.sdfamily.model.GinecologiaOperacionesUsuario;
/*  45:    */ import com.servidoctor.sdfamily.model.GruposUsuario;
/*  46:    */ import com.servidoctor.sdfamily.model.HistoriaMedica;
/*  47:    */ import com.servidoctor.sdfamily.model.MedicinaCompleto;
/*  48:    */ import com.servidoctor.sdfamily.model.OdontologiaCompleto;
/*  49:    */ import com.servidoctor.sdfamily.model.OdontologiaUsuario;
/*  50:    */ import com.servidoctor.sdfamily.model.OptometriaCompleto;
/*  51:    */ import com.servidoctor.sdfamily.model.PartesCuerpoUsuario;
/*  52:    */ import com.servidoctor.sdfamily.model.UsuarioParent;
/*  53:    */ import com.servidoctor.sdfamily.model.VacunasCompleto;
/*  54:    */ import com.servidoctor.sdfamily.model.VacunasUsuario;
/*  55:    */ import com.servidoctor.seguridad.model.Servidores;
/*  56:    */ import com.servidoctor.seguridad.model.UsuarioFamily;
/*  57:    */ import com.servidoctor.util.classes.BorrarSession;
/*  58:    */ import com.servidoctor.util.classes.InicializaData;
/*  59:    */ import com.servidoctor.util.classes.ManejoFechas;
/*  60:    */ import java.io.PrintStream;
/*  61:    */ import java.math.BigDecimal;
/*  62:    */ import java.util.ArrayList;
/*  63:    */ import java.util.List;
/*  64:    */ import javax.servlet.http.HttpServletRequest;
/*  65:    */ import javax.servlet.http.HttpServletResponse;
/*  66:    */ import javax.servlet.http.HttpSession;
/*  67:    */ import org.apache.commons.beanutils.BeanUtils;
/*  68:    */ import org.apache.struts.action.ActionForm;
/*  69:    */ import org.apache.struts.action.ActionForward;
/*  70:    */ import org.apache.struts.action.ActionMapping;
/*  71:    */ 
/*  72:    */ public class DatosPersonalesAction
/*  73:    */   extends BaseAction
/*  74:    */ {
/*  75:    */   public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  76:    */     throws Exception
/*  77:    */   {
/*  78: 75 */     ActionForward myforward = super.execute(mapping, actionForm, request, response);
/*  79: 76 */     String myaction = mapping.getParameter();
/*  80: 78 */     if (myforward == null) {
/*  81: 79 */       if ("".equalsIgnoreCase(myaction)) {
/*  82: 80 */         myforward = mapping.findForward("failure");
/*  83: 81 */       } else if ("VIEW".equalsIgnoreCase(myaction)) {
/*  84: 82 */         myforward = performView(mapping, actionForm, request, response);
/*  85: 83 */       } else if ("EDIT".equalsIgnoreCase(myaction)) {
/*  86: 84 */         myforward = performEdit(mapping, actionForm, request, response);
/*  87: 85 */       } else if ("ADD".equalsIgnoreCase(myaction)) {
/*  88: 86 */         myforward = performAdd(mapping, actionForm, request, response);
/*  89: 87 */       } else if ("SEARCH".equalsIgnoreCase(myaction)) {
/*  90: 88 */         myforward = performList(myaction, mapping, actionForm, request, response);
/*  91: 89 */       } else if ("LIST".equalsIgnoreCase(myaction)) {
/*  92: 90 */         myforward = performList(myaction, mapping, actionForm, request, response);
/*  93: 91 */       } else if ("SAVE".equalsIgnoreCase(myaction)) {
/*  94: 92 */         myforward = performSave(mapping, actionForm, request, response);
/*  95:    */       } else {
/*  96: 94 */         myforward = mapping.findForward("failure");
/*  97:    */       }
/*  98:    */     }
/*  99: 98 */     return myforward;
/* 100:    */   }
/* 101:    */   
/* 102:    */   private ActionForward performView(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 103:    */   {
/* 104:102 */     DatosPersonalesForm form = (DatosPersonalesForm)actionForm;
/* 105:    */     try
/* 106:    */     {
/* 107:106 */       BorrarSession.eliminaAtributos(request.getSession(), "datosPersonalesForm");
/* 108:    */       
/* 109:108 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/* 110:    */       
/* 111:110 */       DatosPersonalesCompletoDAO datosPersonalesCompletoDAO = new DatosPersonalesCompletoDAO();
/* 112:111 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 113:112 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 114:113 */         datosPersonalesCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 115:    */       }
/* 116:115 */       //datosPersonalesCompletoDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    datosPersonalesCompletoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 117:116 */       DatosPersonalesCompleto datosPersonalesCompleto = datosPersonalesCompletoDAO.retrieve(usuarioFamily.getUsuf_cod());
/* 118:117 */       List contactos = datosPersonalesCompleto.getContactos();
/* 119:118 */       List seguros = datosPersonalesCompleto.getSeguros();
/* 120:119 */       DatosPersonales datosPersonales = datosPersonalesCompleto.getDatosPersonales();
/* 121:120 */       request.getSession().setAttribute("datosPersonales", datosPersonales);
/* 122:121 */       UsuarioParent usuarioParent = datosPersonalesCompleto.getUsuarioParent();
/* 123:122 */       if (usuarioParent.getParent_usuf_cod() == null) {
/* 124:123 */         InicializaData.inicializa(usuarioParent.getClass(), usuarioParent);
/* 125:    */       }
/* 126:125 */       BeanUtils.copyProperties(form, datosPersonales);
/* 127:126 */       BeanUtils.copyProperties(form, usuarioParent);
/* 128:    */       
/* 129:128 */       form.setDatp_fecnacim(ManejoFechas.FormateoFecha(form.getDatp_fecnacim()));
/* 130:129 */       form.setDatp_med_fecha1(ManejoFechas.FormateoFecha(form.getDatp_med_fecha1()));
/* 131:130 */       form.setDatp_med_fecha2(ManejoFechas.FormateoFecha(form.getDatp_med_fecha2()));
/* 132:131 */       form.setDatp_med_fecha3(ManejoFechas.FormateoFecha(form.getDatp_med_fecha3()));
/* 133:    */       
/* 134:133 */       GruposUsuarioDAO gruposUsuarioDAO = new GruposUsuarioDAO();
/* 135:134 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 136:135 */         gruposUsuarioDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 137:    */       }
/* 138:137 */       GruposUsuario gruposUsuario = gruposUsuarioDAO.search(usuarioFamily.getUsuf_cod(), IGrupos.FAMILY_SEGUROS);
/* 139:138 */       if (gruposUsuario.getGrupu_usuf_cod() != null)
/* 140:    */       {
/* 141:139 */         BeanUtils.copyProperties(form, gruposUsuario);
/* 142:    */       }
/* 143:    */       else
/* 144:    */       {
/* 145:141 */         GruposDAO gruposDAO = new GruposDAO();
/* 146:142 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 147:143 */           gruposDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 148:    */         }
/* 149:145 */         //gruposDAO.setIdioma(request.getSession().getAttribute("idioma").toString().toLowerCase());
                      gruposDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 150:146 */         Grupos grupos = gruposDAO.retrive(IGrupos.FAMILY_SEGUROS);
/* 151:147 */         form.setGrupu_dias_antes(grupos.getGrup_dias_antes().toString());
/* 152:    */       }
/* 153:150 */       request.getSession().setAttribute("CONTACTOS", contactos);
/* 154:151 */       request.getSession().setAttribute("SEGUROS", seguros);
/* 155:    */       
/* 156:153 */       TipoSangreDAO tipoSangreDAO = new TipoSangreDAO();
/* 157:154 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 158:155 */         tipoSangreDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 159:    */       }
/* 160:157 */       List tipoSangre = tipoSangreDAO.list();
/* 161:158 */       request.setAttribute("TIPOSANGRE", tipoSangre);
/* 162:    */       
/* 163:160 */       PaisDAO paisDAO = new PaisDAO();
/* 164:161 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 165:162 */         paisDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 166:    */       }
/* 167:164 */       //paisDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    paisDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 168:165 */       List paises = paisDAO.list();
/* 169:166 */       request.setAttribute("PAISES", paises);
/* 170:    */       
/* 171:168 */       List ciudades = null;
/* 172:169 */       CiudadDAO ciudadesDAO = new CiudadDAO();
/* 173:170 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 174:171 */         ciudadesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 175:    */       }
/* 176:173 */       //ciudadesDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    ciudadesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 177:174 */       if ((paises.size() > 0) && (form.getDatp_pais_cod() != null)) {
/* 178:175 */         ciudades = ciudadesDAO.search(form.getDatp_pais_cod());
/* 179:176 */       } else if (paises.size() > 0) {
/* 180:177 */         ciudades = ciudadesDAO.search(((Paises)paises.get(0)).getPais_cod().toString());
/* 181:    */       }
/* 182:179 */       request.setAttribute("CIUDADES", ciudades);
/* 183:    */       
/* 184:181 */       ParentescoDAO parentescoDAO = new ParentescoDAO();
/* 185:182 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 186:183 */         parentescoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 187:    */       }
/* 188:185 */       //parentescoDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    parentescoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 189:186 */       List parentescos = parentescoDAO.list();
/* 190:187 */       request.setAttribute("PARENTESCOS", parentescos);
/* 191:188 */       request.setAttribute("rfam_des", parentescoDAO.retrive(datosPersonalesCompleto.getUsuarioParent().getParent_rfam_cod()).getRfam_des());
/* 192:    */       
/* 193:190 */       DocumentoDAO documentoDAO = new DocumentoDAO();
/* 194:191 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 195:192 */         documentoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 196:    */       }
/* 197:194 */       //documentoDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    documentoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 198:195 */       List documentos = documentoDAO.list();
/* 199:196 */       request.setAttribute("DOCUMENTOS", documentos);
/* 200:    */       
/* 201:198 */       EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
/* 202:199 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 203:200 */         estadoCivilDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 204:    */       }
/* 205:202 */       //estadoCivilDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    estadoCivilDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 206:203 */       List estadoCivil = estadoCivilDAO.list();
/* 207:204 */       request.setAttribute("ESTADOCIVIL", estadoCivil);
/* 208:    */       
/* 209:206 */       EscolaridadDAO escolaridadDAO = new EscolaridadDAO();
/* 210:207 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 211:208 */         escolaridadDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 212:    */       }
/* 213:210 */       //escolaridadDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    escolaridadDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 214:211 */       List escolaridad = escolaridadDAO.list();
/* 215:212 */       request.setAttribute("ESCOLARIDAD", escolaridad);
/* 216:    */       
/* 217:214 */       IdiomaDAO idiomaDAO = new IdiomaDAO();
/* 218:215 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 219:216 */         idiomaDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 220:    */       }
/* 221:218 */       request.setAttribute("IDIOMAS", idiomaDAO.list());
/* 222:    */     }
/* 223:    */     catch (Exception e)
/* 224:    */     {
/* 225:221 */       e.printStackTrace();
/* 226:222 */       return mapping.findForward("failure");
/* 227:    */     }
/* 228:224 */     return mapping.findForward("success");
/* 229:    */   }
/* 230:    */   
/* 231:    */   private ActionForward performSave(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 232:    */   {
/* 233:228 */     DatosPersonalesForm form = (DatosPersonalesForm)actionForm;
/* 234:229 */     Boolean nuevo = Boolean.valueOf(false);
/* 235:    */     try
/* 236:    */     {
/* 237:232 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/* 238:234 */       if (form.getDatp_indpais1().length() == 0) {
/* 239:235 */         form.setDatp_indpais1("0");
/* 240:    */       }
/* 241:236 */       if (form.getDatp_indciudad1().length() == 0) {
/* 242:237 */         form.setDatp_indciudad1("0");
/* 243:    */       }
/* 244:238 */       if (form.getDatp_indpais2().length() == 0) {
/* 245:239 */         form.setDatp_indpais2("0");
/* 246:    */       }
/* 247:240 */       if (form.getDatp_med_est1().length() == 0) {
/* 248:241 */         form.setDatp_med_est1("0");
/* 249:    */       }
/* 250:242 */       if (form.getDatp_med_est1b().length() == 0) {
/* 251:243 */         form.setDatp_med_est1b("0");
/* 252:    */       }
/* 253:244 */       if (form.getDatp_med_peso1().length() == 0) {
/* 254:245 */         form.setDatp_med_peso1("0");
/* 255:    */       }
/* 256:246 */       if (form.getDatp_med_est2().length() == 0) {
/* 257:247 */         form.setDatp_med_est2("0");
/* 258:    */       }
/* 259:248 */       if (form.getDatp_med_est2b().length() == 0) {
/* 260:249 */         form.setDatp_med_est2b("0");
/* 261:    */       }
/* 262:250 */       if (form.getDatp_med_peso2().length() == 0) {
/* 263:251 */         form.setDatp_med_peso2("0");
/* 264:    */       }
/* 265:252 */       if (form.getDatp_med_est3().length() == 0) {
/* 266:253 */         form.setDatp_med_est3("0");
/* 267:    */       }
/* 268:254 */       if (form.getDatp_med_est3b().length() == 0) {
/* 269:255 */         form.setDatp_med_est3b("0");
/* 270:    */       }
/* 271:256 */       if (form.getDatp_med_peso3().length() == 0) {
/* 272:257 */         form.setDatp_med_peso3("0");
/* 273:    */       }
/* 274:258 */       if (form.getDatp_num_dias_no_mail().length() == 0) {
/* 275:259 */         form.setDatp_num_dias_no_mail("2");
/* 276:    */       }
/* 277:260 */       if (form.getDatp_fecinscripcion().length() == 0) {
/* 278:261 */         form.setDatp_fecinscripcion("0");
/* 279:    */       }
/* 280:264 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 281:265 */       GruposDAO gruposDAO = new GruposDAO();
/* 282:266 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 283:267 */         gruposDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 284:    */       }
/* 285:269 */       GruposUsuarioDAO gruposUsuarioDAO = new GruposUsuarioDAO();
/* 286:270 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 287:271 */         gruposUsuarioDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 288:    */       }
/* 289:273 */       //gruposUsuarioDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    gruposUsuarioDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 290:274 */       //gruposDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    gruposDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 291:    */       
/* 292:    */ 
/* 293:277 */       boolean primeravez = !usuarioFamily.getUsuf_cod().toString().equals(form.getDatp_usuf_cod());
/* 294:    */       
/* 295:279 */       boolean cambioSexo = false;
/* 296:    */       
/* 297:281 */       List contactos = (List)request.getSession().getAttribute("CONTACTOS");
/* 298:282 */       List seguros = (List)request.getSession().getAttribute("SEGUROS");
/* 299:    */       
/* 300:    */ 
/* 301:285 */       DatosPersonalesCompletoDAO datosPersonalesCompletoDAO = new DatosPersonalesCompletoDAO();
/* 302:286 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 303:287 */         datosPersonalesCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 304:    */       }
/* 305:289 */       //datosPersonalesCompletoDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    datosPersonalesCompletoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
                    
/* 306:290 */       DatosPersonalesCompleto datosPersonalesCompleto = datosPersonalesCompletoDAO.retrieve(usuarioFamily.getUsuf_cod());
/* 307:291 */       if (!primeravez) {
/* 308:292 */         cambioSexo = !datosPersonalesCompleto.getDatosPersonales().getDatp_sexo().equals(form.getDatp_sexo());
/* 309:    */       }
/* 310:295 */       form.setDatp_usuf_cod(usuarioFamily.getUsuf_cod().toString());
/* 311:    */       
/* 312:    */ 
/* 313:298 */       BeanUtils.copyProperties(datosPersonalesCompleto.getDatosPersonales(), form);
/* 314:299 */       BeanUtils.copyProperties(datosPersonalesCompleto.getUsuarioParent(), form);
/* 315:300 */       datosPersonalesCompleto.setContactos(contactos);
/* 316:301 */       datosPersonalesCompleto.setSeguros(seguros);
/* 317:    */       
/* 318:303 */       GruposUsuario grupoUsuarioSeguros = datosPersonalesCompleto.getGrupoUsuario();
/* 319:304 */       grupoUsuarioSeguros.setGrupu_dias_antes(new BigDecimal(form.getGrupu_dias_antes()));
/* 320:305 */       grupoUsuarioSeguros.setGrupu_usuf_cod(usuarioFamily.getUsuf_cod());
/* 321:306 */       grupoUsuarioSeguros.setGrupu_grup_cod(IGrupos.FAMILY_SEGUROS);
/* 322:    */       
/* 323:308 */       FamilyCompletoDAO familyCompletoDAO = new FamilyCompletoDAO();
/* 324:309 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 325:310 */         familyCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 326:    */       }
/* 327:312 */       //familyCompletoDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    familyCompletoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
                    
/* 328:313 */       FamilyCompleto familyCompleto = new FamilyCompleto();
/* 329:315 */       if (primeravez)
/* 330:    */       {
/* 331:318 */         datosPersonalesCompleto.getDatosPersonales().setDatp_usuf_cod(usuarioFamily.getUsuf_cod());
/* 332:319 */         datosPersonalesCompleto.getUsuarioParent().setParent_usuf_cod(usuarioFamily.getUsuf_cod());
/* 333:320 */         datosPersonalesCompleto.getDatosPersonales().setDatp_fecinscripcion(new BigDecimal(ManejoFechas.getFechaActual()));
/* 334:    */         
/* 335:322 */         familyCompleto.setDatosPersonalesCompleto(datosPersonalesCompleto);
/* 336:    */         
/* 337:    */ 
/* 338:325 */         OptometriaCompletoDAO optometriaCompletoDAO = new OptometriaCompletoDAO();
/* 339:326 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 340:327 */           optometriaCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 341:    */         }
/* 342:329 */         //optometriaCompletoDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                      optometriaCompletoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 343:330 */         OptometriaCompleto optometriaCompleto = optometriaCompletoDAO.retrieve(usuarioFamily.getUsuf_cod());
/* 344:331 */         List tablaUniversal = optometriaCompleto.getTablaUniversal();
/* 345:332 */         List tablaAjustada = optometriaCompleto.getTablaAjustada();
/* 346:334 */         for (int i = 0; i < tablaUniversal.size(); i++)
/* 347:    */         {
/* 348:335 */           Optometria optometria = new Optometria();
/* 349:336 */           BeanUtils.copyProperties(optometria, (Optometria)tablaUniversal.get(i));
/* 350:337 */           optometria.setOpt_usuf_cod(usuarioFamily.getUsuf_cod());
/* 351:338 */           tablaAjustada.add(optometria);
/* 352:    */         }
/* 353:341 */         List controlesAnteriores = optometriaCompleto.getControlesAnteriores();
/* 354:342 */         List controlesProximos = optometriaCompleto.getControlesProximos();
/* 355:    */         
/* 356:344 */         ControlOptometria controlOptometriaAnterior = new ControlOptometria();
/* 357:345 */         InicializaData.inicializa(controlOptometriaAnterior.getClass(), controlOptometriaAnterior);
/* 358:346 */         controlOptometriaAnterior.setCopt_tipo(IConstantes.CODIGO_CONTROL_ANTERIOR);
/* 359:347 */         controlOptometriaAnterior.setCopt_grup_cod(IGrupos.FAMILY_OPTOMETRIA);
/* 360:348 */         controlOptometriaAnterior.setCopt_usuf_cod(usuarioFamily.getUsuf_cod());
/* 361:349 */         controlOptometriaAnterior.setCopt_fecenvio2(BigDecimal.ZERO);
/* 362:350 */         controlOptometriaAnterior.setCopt_fecenvion2(BigDecimal.ZERO);
/* 363:351 */         controlOptometriaAnterior.setCopt_fecenvion(BigDecimal.ZERO);
/* 364:    */         
/* 365:    */ 
/* 366:    */ 
/* 367:355 */         ControlOptometria controlOptometriaProximo = new ControlOptometria();
/* 368:356 */         InicializaData.inicializa(controlOptometriaProximo.getClass(), controlOptometriaProximo);
/* 369:357 */         controlOptometriaProximo.setCopt_tipo(IConstantes.CODIGO_CONTROL_PROXIMO);
/* 370:358 */         controlOptometriaProximo.setCopt_grup_cod(IGrupos.FAMILY_OPTOMETRIA);
/* 371:359 */         controlOptometriaProximo.setCopt_usuf_cod(usuarioFamily.getUsuf_cod());
/* 372:360 */         controlOptometriaProximo.setCopt_fecenvio2(BigDecimal.ZERO);
/* 373:361 */         controlOptometriaProximo.setCopt_fecenvion2(BigDecimal.ZERO);
/* 374:362 */         controlOptometriaProximo.setCopt_fecenvion(BigDecimal.ZERO);
/* 375:363 */         controlesAnteriores.add(controlOptometriaAnterior);
/* 376:364 */         controlesProximos.add(controlOptometriaProximo);
/* 377:    */         
/* 378:366 */         Grupos grupos = gruposDAO.retrive(IGrupos.FAMILY_OPTOMETRIA);
/* 379:    */         
/* 380:368 */         optometriaCompleto.setTablaAjustada(tablaAjustada);
/* 381:369 */         optometriaCompleto.setControlesAnteriores(controlesAnteriores);
/* 382:370 */         optometriaCompleto.setControlesProximos(controlesProximos);
/* 383:    */         
/* 384:372 */         GruposUsuario grupoUsuarioOptometria = optometriaCompleto.getGrupoUsuario();
/* 385:373 */         grupoUsuarioOptometria.setGrupu_dias_antes(grupos.getGrup_dias_antes());
/* 386:374 */         grupoUsuarioOptometria.setGrupu_usuf_cod(usuarioFamily.getUsuf_cod());
/* 387:375 */         grupoUsuarioOptometria.setGrupu_grup_cod(IGrupos.FAMILY_OPTOMETRIA);
/* 388:    */         
/* 389:377 */         familyCompleto.setOptometriaCompleto(optometriaCompleto);
/* 390:    */         
/* 391:    */ 
/* 392:380 */         OdontologiaCompletoDAO odontologiaCompletoDAO = new OdontologiaCompletoDAO();
/* 393:381 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 394:382 */           odontologiaCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 395:    */         }
/* 396:384 */         //odontologiaCompletoDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                      odontologiaCompletoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 397:385 */         OdontologiaCompleto odontologiaCompleto = odontologiaCompletoDAO.retrieve(usuarioFamily.getUsuf_cod());
/* 398:386 */         tablaUniversal = odontologiaCompleto.getTablaUniversal();
/* 399:387 */         tablaAjustada = odontologiaCompleto.getTablaAjustada();
/* 400:388 */         List usuarioControlesU = odontologiaCompleto.getControlesAnteriores();
/* 401:389 */         List usuarioControlesP = odontologiaCompleto.getControlesProximos();
/* 402:    */         
/* 403:391 */         Odontologia temp = new Odontologia();
/* 404:392 */         InicializaData.inicializa(temp.getClass(), temp);
/* 405:    */         
/* 406:394 */         int x = 0;
/* 407:395 */         while (x < tablaUniversal.size())
/* 408:    */         {
/* 409:396 */           Odontologia odontologia = (Odontologia)tablaUniversal.get(x);
/* 410:397 */           OdontologiaUsuario odontologiaUsuario = new OdontologiaUsuario();
/* 411:398 */           InicializaData.inicializa(odontologiaUsuario.getClass(), odontologiaUsuario);
/* 412:399 */           odontologiaUsuario.setOdou_cod(new BigDecimal(x + 1.0D));
/* 413:400 */           odontologiaUsuario.setOdou_usuf_cod(usuarioFamily.getUsuf_cod());
/* 414:401 */           odontologiaUsuario.setOdou_odo_cod(odontologia.getOdo_cod());
/* 415:402 */           odontologiaUsuario.setOdou_edaddesdeanio(odontologia.getOdo_edaddesdeanio());
/* 416:403 */           odontologiaUsuario.setOdou_edaddesdemes(odontologia.getOdo_edaddesdemes());
/* 417:404 */           odontologiaUsuario.setOdou_edadhastaanio(odontologia.getOdo_edadhastaanio());
/* 418:405 */           odontologiaUsuario.setOdou_edadhastames(odontologia.getOdo_edadhastames());
/* 419:406 */           odontologiaUsuario.setOdou_frecuencia(odontologia.getOdo_frecuencia());
/* 420:407 */           tablaAjustada.add(odontologiaUsuario);
/* 421:408 */           x++;
/* 422:    */         }
/* 423:410 */         x = 0;
/* 424:411 */         while (x < tablaAjustada.size())
/* 425:    */         {
/* 426:412 */           OdontologiaUsuario odontologiaUsuario = (OdontologiaUsuario)tablaAjustada.get(x);
/* 427:413 */           odontologiaUsuario.setOdou_usuf_cod(usuarioFamily.getUsuf_cod());
/* 428:414 */           ControlOdontologia control = new ControlOdontologia();
/* 429:415 */           InicializaData.inicializa(control.getClass(), control);
/* 430:416 */           control.setElementoTabla(odontologiaUsuario);
/* 431:417 */           control.setCodo_tipo(IConstantes.CODIGO_CONTROL_ANTERIOR);
/* 432:418 */           usuarioControlesU.add(control);
/* 433:419 */           control.setCodo_grup_cod(IGrupos.FAMILY_ODONTOLOGIA);
/* 434:420 */           control = new ControlOdontologia();
/* 435:421 */           InicializaData.inicializa(control.getClass(), control);
/* 436:422 */           control.setElementoTabla(odontologiaUsuario);
/* 437:423 */           control.setCodo_grup_cod(IGrupos.FAMILY_ODONTOLOGIA);
/* 438:424 */           control.setCodo_tipo(IConstantes.CODIGO_CONTROL_PROXIMO);
/* 439:425 */           usuarioControlesP.add(control);
/* 440:426 */           x++;
/* 441:    */         }
/* 442:428 */         odontologiaCompleto.setTablaAjustada(tablaAjustada);
/* 443:429 */         odontologiaCompleto.setControlesAnteriores(usuarioControlesU);
/* 444:430 */         odontologiaCompleto.setControlesProximos(usuarioControlesP);
/* 445:    */         
/* 446:432 */         grupos = gruposDAO.retrive(IGrupos.FAMILY_ODONTOLOGIA);
/* 447:    */         
/* 448:434 */         GruposUsuario grupoUsuarioOdontologia = odontologiaCompleto.getGrupoUsuario();
/* 449:435 */         grupoUsuarioOdontologia.setGrupu_dias_antes(grupos.getGrup_dias_antes());
/* 450:436 */         grupoUsuarioOdontologia.setGrupu_grup_cod(IGrupos.FAMILY_ODONTOLOGIA);
/* 451:437 */         grupoUsuarioOdontologia.setGrupu_usuf_cod(usuarioFamily.getUsuf_cod());
/* 452:    */         
/* 453:439 */         familyCompleto.setOdontologiaCompleto(odontologiaCompleto);
/* 454:    */         
/* 455:    */ 
/* 456:442 */         VacunasCompletoDAO vacunasCompletoDAO = new VacunasCompletoDAO();
/* 457:443 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 458:444 */           vacunasCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 459:    */         }
/* 460:446 */         //vacunasCompletoDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                      vacunasCompletoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 461:447 */         VacunasCompleto vacunasCompleto = vacunasCompletoDAO.retrieve(usuarioFamily.getUsuf_cod());
/* 462:448 */         tablaUniversal = vacunasCompleto.getTablaUniversal();
/* 463:449 */         tablaAjustada = vacunasCompleto.getTablaAjustada();
/* 464:    */         
/* 465:451 */         x = 0;
/* 466:452 */         while (x < tablaUniversal.size())
/* 467:    */         {
/* 468:453 */           Vacunas vacuna = (Vacunas)tablaUniversal.get(x);
/* 469:454 */           VacunasUsuario vacunaUsuario = new VacunasUsuario();
/* 470:455 */           InicializaData.inicializa(vacunaUsuario.getClass(), vacunaUsuario);
/* 471:456 */           vacunaUsuario.setVacu_usuf_cod(usuarioFamily.getUsuf_cod());
/* 472:457 */           vacunaUsuario.setVacu_edad_mes1(vacuna.getVac_edad_mes1());
/* 473:458 */           vacunaUsuario.setVacu_edad_mes2(vacuna.getVac_edad_mes2());
/* 474:459 */           vacunaUsuario.setVacu_edad_mes3(vacuna.getVac_edad_mes3());
/* 475:460 */           vacunaUsuario.setVacu_edad_mes4(vacuna.getVac_edad_mes4());
/* 476:461 */           vacunaUsuario.setVacu_edad_mes5(vacuna.getVac_edad_mes5());
/* 477:462 */           vacunaUsuario.setVacu_edad_mes6(vacuna.getVac_edad_mes6());
/* 478:463 */           vacunaUsuario.setVacu_edad_mes7(vacuna.getVac_edad_mes7());
/* 479:464 */           vacunaUsuario.setVacu_edad_mes8(vacuna.getVac_edad_mes8());
/* 480:465 */           vacunaUsuario.setVacu_edad_mes9(vacuna.getVac_edad_mes9());
/* 481:466 */           vacunaUsuario.setVacu_edad_mes10(vacuna.getVac_edad_mes10());
/* 482:467 */           vacunaUsuario.setVacu_edad_mes11(vacuna.getVac_edad_mes11());
/* 483:468 */           vacunaUsuario.setVacu_edad_mes12(vacuna.getVac_edad_mes12());
/* 484:469 */           vacunaUsuario.setVacu_edad_mes13(vacuna.getVac_edad_mes13());
/* 485:470 */           vacunaUsuario.setVacu_edad_mes14(vacuna.getVac_edad_mes14());
/* 486:471 */           vacunaUsuario.setVacu_edad_mes15(vacuna.getVac_edad_mes15());
/* 487:472 */           vacunaUsuario.setVacu_edad_mes16(vacuna.getVac_edad_mes16());
/* 488:473 */           vacunaUsuario.setVacu_edad_mes17(vacuna.getVac_edad_mes17());
/* 489:474 */           vacunaUsuario.setVacu_edad_mes18(vacuna.getVac_edad_mes18());
/* 490:475 */           vacunaUsuario.setVacu_edad_mes19(vacuna.getVac_edad_mes19());
/* 491:476 */           vacunaUsuario.setVacu_edad_mes20(vacuna.getVac_edad_mes20());
/* 492:477 */           vacunaUsuario.setVacu_edad_mes21(vacuna.getVac_edad_mes21());
/* 493:478 */           vacunaUsuario.setVacu_edad_mes22(vacuna.getVac_edad_mes22());
/* 494:479 */           vacunaUsuario.setVacu_edad_mes23(vacuna.getVac_edad_mes23());
/* 495:480 */           vacunaUsuario.setVacu_edad_mes24(vacuna.getVac_edad_mes24());
/* 496:481 */           vacunaUsuario.setVacu_edad_anno3(vacuna.getVac_edad_anno3());
/* 497:482 */           vacunaUsuario.setVacu_edad_anno4(vacuna.getVac_edad_anno4());
/* 498:483 */           vacunaUsuario.setVacu_edad_anno5(vacuna.getVac_edad_anno5());
/* 499:484 */           vacunaUsuario.setVacu_edad_anno6(vacuna.getVac_edad_anno6());
/* 500:485 */           vacunaUsuario.setVacu_edad_anno7(vacuna.getVac_edad_anno7());
/* 501:486 */           vacunaUsuario.setVacu_edad_anno8(vacuna.getVac_edad_anno8());
/* 502:487 */           vacunaUsuario.setVacu_edad_anno9(vacuna.getVac_edad_anno9());
/* 503:488 */           vacunaUsuario.setVacu_edad_anno10(vacuna.getVac_edad_anno10());
/* 504:489 */           vacunaUsuario.setVacu_edad_anno11(vacuna.getVac_edad_anno11());
/* 505:490 */           vacunaUsuario.setVacu_edad_anno12(vacuna.getVac_edad_anno12());
/* 506:491 */           vacunaUsuario.setVacu_edad_anno13(vacuna.getVac_edad_anno13());
/* 507:492 */           vacunaUsuario.setVacu_edad_anno14(vacuna.getVac_edad_anno14());
/* 508:493 */           vacunaUsuario.setVacu_edad_anno15(vacuna.getVac_edad_anno15());
/* 509:494 */           vacunaUsuario.setVacu_edad_anno16(vacuna.getVac_edad_anno16());
/* 510:495 */           vacunaUsuario.setVacu_edad_anno17(vacuna.getVac_edad_anno17());
/* 511:496 */           vacunaUsuario.setVacu_edad_anno18(vacuna.getVac_edad_anno18());
/* 512:497 */           vacunaUsuario.setVacu_edad_anno19(vacuna.getVac_edad_anno19());
/* 513:498 */           vacunaUsuario.setVacu_edad_anno20(vacuna.getVac_edad_anno20());
/* 514:499 */           vacunaUsuario.setVacu_edad_anno30(vacuna.getVac_edad_anno30());
/* 515:500 */           vacunaUsuario.setVacu_edad_anno40(vacuna.getVac_edad_anno40());
/* 516:501 */           vacunaUsuario.setVacu_edad_anno50(vacuna.getVac_edad_anno50());
/* 517:502 */           vacunaUsuario.setVacu_edad_anno60(vacuna.getVac_edad_anno60());
/* 518:503 */           vacunaUsuario.setVacu_edad_anno70(vacuna.getVac_edad_anno70());
/* 519:504 */           vacunaUsuario.setVacu_edad_anno80(vacuna.getVac_edad_anno80());
/* 520:505 */           vacunaUsuario.setVacu_edad_anno90(vacuna.getVac_edad_anno90());
/* 521:506 */           vacunaUsuario.setVacu_vac_cod(vacuna.getVac_cod());
/* 522:507 */           vacunaUsuario.setVacu_grup_cod(IGrupos.FAMILY_VACUNAS);
/* 523:508 */           vacunaUsuario.setVacu_des(vacuna.getVac_des());
/* 524:509 */           tablaAjustada.add(vacunaUsuario);
/* 525:510 */           x++;
/* 526:    */         }
/* 527:513 */         vacunasCompleto.setTablaAjustada(tablaAjustada);
/* 528:    */         
/* 529:515 */         grupos = gruposDAO.retrive(IGrupos.FAMILY_VACUNAS);
/* 530:    */         
/* 531:517 */         GruposUsuario grupoUsuarioVacunas = vacunasCompleto.getGrupoUsuario();
/* 532:518 */         grupoUsuarioVacunas.setGrupu_dias_antes(grupos.getGrup_dias_antes());
/* 533:519 */         grupoUsuarioVacunas.setGrupu_grup_cod(IGrupos.FAMILY_VACUNAS);
/* 534:520 */         grupoUsuarioVacunas.setGrupu_usuf_cod(usuarioFamily.getUsuf_cod());
/* 535:    */         
/* 536:522 */         familyCompleto.setVacunasCompleto(vacunasCompleto);
/* 537:    */         
/* 538:    */ 
/* 539:525 */         HistoriaMedicaDAO historiaMedicaDAO = new HistoriaMedicaDAO();
/* 540:526 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 541:527 */           historiaMedicaDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 542:    */         }
/* 543:529 */         //historiaMedicaDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                      historiaMedicaDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 544:530 */         HistoriaMedica historiaMedica = historiaMedicaDAO.retrieve(usuarioFamily.getUsuf_cod());
/* 545:531 */         List elementosConsumo = historiaMedica.getElementosConsumo();
/* 546:532 */         List elementosConsumoUsuario = historiaMedica.getElementosConsumoUsuario();
/* 547:    */         
/* 548:534 */         x = 0;
/* 549:535 */         while (x < elementosConsumo.size())
/* 550:    */         {
/* 551:536 */           ElementoConsumo elementoConsumo = (ElementoConsumo)elementosConsumo.get(x);
/* 552:537 */           ElementoConsumoUsuario elementoConsumoUsuario = new ElementoConsumoUsuario();
/* 553:538 */           InicializaData.inicializa(elementoConsumoUsuario.getClass(), elementoConsumoUsuario);
/* 554:539 */           elementoConsumoUsuario.setEconu_cons_cod(IConstantes.CODIGO_NO_EXISTE);
/* 555:540 */           elementoConsumoUsuario.setEconu_econ_cod(elementoConsumo.getEcon_cod());
/* 556:541 */           elementoConsumoUsuario.setEconu_usuf_cod(usuarioFamily.getUsuf_cod());
/* 557:542 */           elementosConsumoUsuario.add(elementoConsumoUsuario);
/* 558:543 */           x++;
/* 559:    */         }
/* 560:546 */         historiaMedica.setElementosConsumoUsuario(elementosConsumoUsuario);
/* 561:    */         
/* 562:548 */         List antecedentes = historiaMedica.getAntecedentes();
/* 563:549 */         List antecedentesUsuario = historiaMedica.getAntecedentesUsuario();
/* 564:    */         
/* 565:551 */         x = 0;
/* 566:552 */         while (x < antecedentes.size())
/* 567:    */         {
/* 568:553 */           Antecedentes antecedente = (Antecedentes)antecedentes.get(x);
/* 569:554 */           AntecedentesUsuario antecedenteUsuario = new AntecedentesUsuario();
/* 570:555 */           InicializaData.inicializa(antecedenteUsuario.getClass(), antecedenteUsuario);
/* 571:556 */           antecedenteUsuario.setAnteu_ante_cod(antecedente.getAnte_cod());
/* 572:557 */           antecedenteUsuario.setAnteu_usuf_cod(usuarioFamily.getUsuf_cod());
/* 573:558 */           antecedentesUsuario.add(antecedenteUsuario);
/* 574:559 */           x++;
/* 575:    */         }
/* 576:562 */         historiaMedica.setAntecedentesUsuario(antecedentesUsuario);
/* 577:    */         
/* 578:564 */         List partesCuerpo = historiaMedica.getPartesCuerpo();
/* 579:565 */         List partesCuerpoUsuario = historiaMedica.getPartesCuerpoUsuario();
/* 580:    */         
/* 581:567 */         x = 0;
/* 582:568 */         while (x < partesCuerpo.size())
/* 583:    */         {
/* 584:569 */           PartesCuerpo parteCuerpo = (PartesCuerpo)partesCuerpo.get(x);
/* 585:570 */           PartesCuerpoUsuario parteCuerpoUsuario = new PartesCuerpoUsuario();
/* 586:571 */           InicializaData.inicializa(parteCuerpoUsuario.getClass(), parteCuerpoUsuario);
/* 587:572 */           parteCuerpoUsuario.setPcueu_pcue_cod(parteCuerpo.getPcue_cod());
/* 588:573 */           parteCuerpoUsuario.setPcueu_usuf_cod(usuarioFamily.getUsuf_cod());
/* 589:574 */           partesCuerpoUsuario.add(parteCuerpoUsuario);
/* 590:575 */           x++;
/* 591:    */         }
/* 592:578 */         historiaMedica.setPartesCuerpoUsuario(partesCuerpoUsuario);
/* 593:    */         
/* 594:580 */         familyCompleto.setHistoriaMedica(historiaMedica);
/* 595:    */       }
/* 596:584 */       if ((primeravez) || (cambioSexo))
/* 597:    */       {
/* 598:585 */         System.out.println("---------------------------paso1-----------------");
/* 599:586 */         MedicinaCompletoDAO medicinaCompletoDAO = new MedicinaCompletoDAO();
/* 600:587 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 601:588 */           medicinaCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 602:    */         }
/* 603:590 */         //medicinaCompletoDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                      medicinaCompletoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 604:591 */         MedicinaCompleto medicinaCompleto = medicinaCompletoDAO.retrieve(usuarioFamily.getUsuf_cod(), form.getDatp_sexo());
/* 605:    */         
/* 606:593 */         List tablaUniversal = medicinaCompleto.getTablaUniversal();
/* 607:    */         
/* 608:595 */         List tablaAjustada = new ArrayList();
/* 609:596 */         List controlesAnteriores = new ArrayList();
/* 610:597 */         List controlesProximos = new ArrayList();
/* 611:    */         
/* 612:599 */         Examenes tempExamenes = new Examenes();
/* 613:600 */         InicializaData.inicializa(tempExamenes.getClass(), tempExamenes);
/* 614:    */         
/* 615:602 */         int x = 0;
/* 616:604 */         while (x < tablaUniversal.size())
/* 617:    */         {
/* 618:605 */           Examenes examen = (Examenes)tablaUniversal.get(x);
/* 619:606 */           ExamenesUsuario examenUsuario = new ExamenesUsuario();
/* 620:607 */           InicializaData.inicializa(examenUsuario.getClass(), examenUsuario);
/* 621:608 */           examenUsuario.setExau_cod(new BigDecimal(x + 1.0D));
/* 622:609 */           examenUsuario.setExau_usuf_cod(usuarioFamily.getUsuf_cod());
/* 623:610 */           examenUsuario.setExau_exa_cod(examen.getExa_cod());
/* 624:611 */           examenUsuario.setExau_edad(examen.getExa_edad());
/* 625:612 */           examenUsuario.setExau_frecuencia(examen.getExa_frecuencia());
/* 626:613 */           examenUsuario.setExau_grup_cod(examen.getExa_grup_cod());
/* 627:614 */           tablaAjustada.add(examenUsuario);
/* 628:615 */           x++;
/* 629:    */         }
/* 630:617 */         x = 0;
/* 631:618 */         while (x < tablaAjustada.size())
/* 632:    */         {
/* 633:619 */           ExamenesUsuario examenUsuario = (ExamenesUsuario)tablaAjustada.get(x);
/* 634:620 */           ControlMedico control = new ControlMedico();
/* 635:621 */           InicializaData.inicializa(control.getClass(), control);
/* 636:622 */           control.setElementoTabla(examenUsuario);
/* 637:623 */           control.setCmed_grup_cod(examenUsuario.getExau_grup_cod());
/* 638:624 */           control.setCmed_tipo(IConstantes.CODIGO_CONTROL_ANTERIOR);
/* 639:625 */           controlesAnteriores.add(control);
/* 640:626 */           control = new ControlMedico();
/* 641:627 */           InicializaData.inicializa(control.getClass(), control);
/* 642:628 */           control.setElementoTabla(examenUsuario);
/* 643:629 */           control.setCmed_grup_cod(examenUsuario.getExau_grup_cod());
/* 644:630 */           control.setCmed_tipo(IConstantes.CODIGO_CONTROL_PROXIMO);
/* 645:631 */           controlesProximos.add(control);
/* 646:632 */           x++;
/* 647:    */         }
/* 648:635 */         List gruposUsuarioMedicina = new ArrayList();
/* 649:636 */         BigDecimal[] gruposMedicina = { IGrupos.FAMILY_MEDICINA_A, IGrupos.FAMILY_MEDICINA_B, IGrupos.FAMILY_MEDICINA_C };
/* 650:637 */         for (int j = 0; j < gruposMedicina.length; j++)
/* 651:    */         {
/* 652:638 */           GruposUsuario grupoUsuario = gruposUsuarioDAO.search(usuarioFamily.getUsuf_cod(), gruposMedicina[j]);
/* 653:639 */           if (grupoUsuario.getGrupu_usuf_cod() == null)
/* 654:    */           {
/* 655:642 */             Grupos grupo = gruposDAO.retrive(gruposMedicina[j]);
/* 656:643 */             grupoUsuario.setGrupu_dias_antes(grupo.getGrup_dias_antes());
/* 657:644 */             grupoUsuario.setGrupu_grup_cod(grupo.getGrup_cod());
/* 658:645 */             grupoUsuario.setGrupu_usuf_cod(usuarioFamily.getUsuf_cod());
/* 659:    */           }
/* 660:647 */           gruposUsuarioMedicina.add(grupoUsuario);
/* 661:    */         }
/* 662:650 */         medicinaCompleto.setTablaAjustada(tablaAjustada);
/* 663:651 */         medicinaCompleto.setControlesAnteriores(controlesAnteriores);
/* 664:652 */         medicinaCompleto.setControlesProximos(controlesProximos);
/* 665:653 */         medicinaCompleto.setGrupos(gruposUsuarioMedicina);
/* 666:    */         
/* 667:655 */         familyCompleto.setMedicinaCompleto(medicinaCompleto);
/* 668:    */         
/* 669:    */ 
/* 670:658 */         HistoriaMedicaDAO historiaMedicaDAO = new HistoriaMedicaDAO();
/* 671:659 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 672:660 */           historiaMedicaDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 673:    */         }
/* 674:662 */         //historiaMedicaDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                      historiaMedicaDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 675:663 */         HistoriaMedica historiaMedica = familyCompleto.getHistoriaMedica();
/* 676:    */         
/* 677:665 */         List ginecologiaOperaciones = historiaMedica.getGinecologiaOperaciones();
/* 678:666 */         List ginecologiaOperacionesUsuario = historiaMedica.getGinecologiaOperacionesUsuario();
/* 679:668 */         if (form.getDatp_sexo().equals("F"))
/* 680:    */         {
/* 681:669 */           x = 0;
/* 682:670 */           while (x < ginecologiaOperaciones.size())
/* 683:    */           {
/* 684:671 */             GinecologiaOperaciones operacion = (GinecologiaOperaciones)ginecologiaOperaciones.get(x);
/* 685:672 */             GinecologiaOperacionesUsuario operacionUsuario = new GinecologiaOperacionesUsuario();
/* 686:673 */             InicializaData.inicializa(operacionUsuario.getClass(), operacionUsuario);
/* 687:674 */             operacionUsuario.setGopeu_gope_cod(operacion.getGope_cod());
/* 688:675 */             operacionUsuario.setGopeu_usuf_cod(usuarioFamily.getUsuf_cod());
/* 689:676 */             ginecologiaOperacionesUsuario.add(operacionUsuario);
/* 690:677 */             x++;
/* 691:    */           }
/* 692:    */         }
/* 693:681 */         historiaMedica.setGinecologiaOperacionesUsuario(ginecologiaOperacionesUsuario);
/* 694:    */         
/* 695:683 */         Ginecologia ginecologia = historiaMedica.getGinecologia();
/* 696:684 */         InicializaData.inicializa(ginecologia.getClass(), ginecologia);
/* 697:685 */         ginecologia.setGine_usuf_cod(usuarioFamily.getUsuf_cod());
/* 698:    */         
/* 699:687 */         familyCompletoDAO.update(familyCompleto);
/* 700:    */       }
/* 701:    */       else
/* 702:    */       {
/* 703:689 */         datosPersonalesCompletoDAO.update(datosPersonalesCompleto);
/* 704:    */       }
/* 705:692 */       request.getSession().setAttribute("datosPersonales", datosPersonalesCompleto.getDatosPersonales());
/* 706:    */     }
/* 707:    */     catch (Exception e)
/* 708:    */     {
/* 709:695 */       e.printStackTrace();
/* 710:696 */       return mapping.findForward("failure");
/* 711:    */     }
/* 712:698 */     return mapping.findForward("success");
/* 713:    */   }
/* 714:    */   
/* 715:    */   private ActionForward performEdit(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 716:    */   {
/* 717:702 */     DatosPersonalesForm form = (DatosPersonalesForm)actionForm;
/* 718:    */     
/* 719:    */ 
/* 720:    */ 
/* 721:    */ 
/* 722:    */ 
/* 723:    */ 
/* 724:    */ 
/* 725:710 */     return mapping.findForward("success");
/* 726:    */   }
/* 727:    */   
/* 728:    */   private ActionForward performAdd(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 729:    */   {
/* 730:714 */     DatosPersonalesForm form = (DatosPersonalesForm)actionForm;
/* 731:    */     try
/* 732:    */     {
/* 733:718 */       form.setDatp_fecnacim(ManejoFechas.FormateoFecha(form.getDatp_fecnacim()));
/* 734:719 */       form.setDatp_med_fecha1(ManejoFechas.FormateoFecha(form.getDatp_med_fecha1()));
/* 735:720 */       form.setDatp_med_fecha2(ManejoFechas.FormateoFecha(form.getDatp_med_fecha2()));
/* 736:721 */       form.setDatp_med_fecha3(ManejoFechas.FormateoFecha(form.getDatp_med_fecha3()));
/* 737:    */       
/* 738:723 */       List contactos = new ArrayList();
/* 739:724 */       if (request.getSession().getAttribute("CONTACTOS") != null) {
/* 740:725 */         contactos = (List)request.getSession().getAttribute("CONTACTOS");
/* 741:    */       }
/* 742:726 */       request.getSession().setAttribute("CONTACTOS", contactos);
/* 743:    */       
/* 744:728 */       List seguros = new ArrayList();
/* 745:729 */       if (request.getSession().getAttribute("SEGUROS") != null) {
/* 746:730 */         seguros = (List)request.getSession().getAttribute("SEGUROS");
/* 747:    */       }
/* 748:731 */       request.getSession().setAttribute("SEGUROS", seguros);
/* 749:    */       
/* 750:733 */       TipoSangreDAO tipoSangreDAO = new TipoSangreDAO();
/* 751:734 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 752:735 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 753:736 */         tipoSangreDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 754:    */       }
/* 755:738 */       List tipoSangre = tipoSangreDAO.list();
/* 756:739 */       request.setAttribute("TIPOSANGRE", tipoSangre);
/* 757:    */       
/* 758:741 */       PaisDAO paisDAO = new PaisDAO();
/* 759:742 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 760:743 */         paisDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 761:    */       }
/* 762:745 */       //paisDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    paisDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 763:746 */       List paises = paisDAO.list();
/* 764:747 */       request.setAttribute("PAISES", paises);
/* 765:    */       
/* 766:749 */       List ciudades = null;
/* 767:750 */       CiudadDAO ciudadesDAO = new CiudadDAO();
/* 768:751 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 769:752 */         ciudadesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 770:    */       }
/* 771:754 */       //ciudadesDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    ciudadesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 772:755 */       if ((paises.size() > 0) && (!form.getDatp_pais_cod().equals("0"))) {
/* 773:756 */         ciudades = ciudadesDAO.search(form.getDatp_pais_cod());
/* 774:757 */       } else if (paises.size() > 0) {
/* 775:758 */         ciudades = ciudadesDAO.search(((Paises)paises.get(0)).getPais_cod().toString());
/* 776:    */       }
/* 777:761 */       request.setAttribute("CIUDADES", ciudades);
/* 778:    */       
/* 779:763 */       ParentescoDAO parentescoDAO = new ParentescoDAO();
/* 780:764 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 781:765 */         parentescoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 782:    */       }
/* 783:767 */       //parentescoDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    parentescoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 784:768 */       List parentescos = parentescoDAO.list();
/* 785:769 */       request.setAttribute("PARENTESCOS", parentescos);
/* 786:770 */       request.setAttribute("rfam_des", parentescoDAO.retrive(new BigDecimal(form.getParent_rfam_cod())).getRfam_des());
/* 787:    */       
/* 788:772 */       DocumentoDAO documentoDAO = new DocumentoDAO();
/* 789:773 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 790:774 */         documentoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 791:    */       }
/* 792:776 */       //documentoDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    documentoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 793:777 */       List documentos = documentoDAO.list();
/* 794:778 */       request.setAttribute("DOCUMENTOS", documentos);
/* 795:    */       
/* 796:780 */       EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
/* 797:781 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 798:782 */         estadoCivilDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 799:    */       }
/* 800:784 */       //estadoCivilDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    estadoCivilDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 801:785 */       List estadoCivil = estadoCivilDAO.list();
/* 802:786 */       request.setAttribute("ESTADOCIVIL", estadoCivil);
/* 803:    */       
/* 804:788 */       EscolaridadDAO escolaridadDAO = new EscolaridadDAO();
/* 805:789 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 806:790 */         escolaridadDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 807:    */       }
/* 808:792 */       //escolaridadDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    escolaridadDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 809:793 */       List escolaridad = escolaridadDAO.list();
/* 810:794 */       request.setAttribute("ESCOLARIDAD", escolaridad);
/* 811:    */       
/* 812:796 */       IdiomaDAO idiomaDAO = new IdiomaDAO();
/* 813:797 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 814:798 */         idiomaDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 815:    */       }
/* 816:800 */       request.setAttribute("IDIOMAS", idiomaDAO.list());
/* 817:    */     }
/* 818:    */     catch (Exception e)
/* 819:    */     {
/* 820:803 */       e.printStackTrace();
/* 821:804 */       return mapping.findForward("failure");
/* 822:    */     }
/* 823:807 */     return mapping.findForward("success");
/* 824:    */   }
/* 825:    */   
/* 826:    */   private ActionForward performRemove(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 827:    */   {
/* 828:811 */     return performView(mapping, actionForm, request, response);
/* 829:    */   }
/* 830:    */   
/* 831:    */   private ActionForward performList(String myaction, ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 832:    */   {
/* 833:816 */     DatosPersonalesForm form = (DatosPersonalesForm)actionForm;
/* 834:    */     
/* 835:    */ 
/* 836:    */ 
/* 837:    */ 
/* 838:    */ 
/* 839:    */ 
/* 840:    */ 
/* 841:824 */     return mapping.findForward("success");
/* 842:    */   }
/* 843:    */ }



/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\

 * Qualified Name:     com.servidoctor.sdfamily.controller.DatosPersonalesAction

 * JD-Core Version:    0.7.0.1

 */