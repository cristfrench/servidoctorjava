/*    1:     */ package com.servidoctor.sdpets.controller;
/*    2:     */ 
/*    3:     */ import com.essecorp.util.GestorFechasCompleto;
/*    4:     */ import com.servidoctor.constantes.IConstantes;
/*    5:     */ import com.servidoctor.constantes.IGrupos;
/*    6:     */ import com.servidoctor.parametros.dao.CiudadDAO;
/*    7:     */ import com.servidoctor.parametros.dao.GruposDAO;
/*    8:     */ import com.servidoctor.parametros.dao.IdiomaDAO;
/*    9:     */ import com.servidoctor.parametros.dao.PaisDAO;
/*   10:     */ import com.servidoctor.parametros.dao.RazasDAO;
/*   11:     */ import com.servidoctor.parametros.dao.VacunasCuidadosDAO;
/*   12:     */ import com.servidoctor.parametros.model.Grupos;
/*   13:     */ import com.servidoctor.parametros.model.Paises;
/*   14:     */ import com.servidoctor.parametros.model.VacunasCuidados;
/*   15:     */ import com.servidoctor.sdpets.dao.GestorHojasCalculoPets;
/*   16:     */ import com.servidoctor.sdpets.dao.GruposMascotaDAO;
/*   17:     */ import com.servidoctor.sdpets.dao.MascotaCompletoDAO;
/*   18:     */ import com.servidoctor.sdpets.dao.MascotaDAO;
/*   19:     */ import com.servidoctor.sdpets.model.ContactosMascota;
/*   20:     */ import com.servidoctor.sdpets.model.ControlCuidados;
/*   21:     */ import com.servidoctor.sdpets.model.GruposMascota;
/*   22:     */ import com.servidoctor.sdpets.model.Mascota;
/*   23:     */ import com.servidoctor.sdpets.model.MascotaAlimentacion;
/*   24:     */ import com.servidoctor.sdpets.model.MascotaCompleto;
/*   25:     */ import com.servidoctor.sdpets.model.PropietariosMascota;
/*   26:     */ import com.servidoctor.seguridad.model.Servidores;
/*   27:     */ import com.servidoctor.seguridad.model.UsuarioPets;
/*   28:     */ import com.servidoctor.util.classes.BorrarSession;
/*   29:     */ import com.servidoctor.util.classes.InicializaData;
/*   30:     */ import com.servidoctor.util.classes.ManejoFechas;
/*   31:     */ import java.io.OutputStream;
/*   32:     */ import java.lang.reflect.Field;
/*   33:     */ import java.math.BigDecimal;
/*   34:     */ import java.util.ArrayList;
/*   35:     */ import java.util.List;
/*   36:     */ import java.util.ResourceBundle;
/*   37:     */ import javax.servlet.http.HttpServletRequest;
/*   38:     */ import javax.servlet.http.HttpServletResponse;
/*   39:     */ import javax.servlet.http.HttpSession;
/*   40:     */ import org.apache.commons.beanutils.BeanUtils;
/*   41:     */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*   42:     */ import org.apache.struts.action.Action;
/*   43:     */ import org.apache.struts.action.ActionForm;
/*   44:     */ import org.apache.struts.action.ActionForward;
/*   45:     */ import org.apache.struts.action.ActionMapping;
/*   46:     */ 
/*   47:     */ public class MascotaAction
/*   48:     */   extends Action
/*   49:     */ {
/*   50:     */   public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*   51:     */     throws Exception
/*   52:     */   {
/*   53:  51 */     ActionForward myforward = null;
/*   54:  52 */     String myaction = mapping.getParameter();
/*   55:  54 */     if ("".equalsIgnoreCase(myaction)) {
/*   56:  55 */       myforward = mapping.findForward("failure");
/*   57:  56 */     } else if ("EDIT".equalsIgnoreCase(myaction)) {
/*   58:  57 */       myforward = performEdit(mapping, actionForm, request, response);
/*   59:  58 */     } else if ("ADD".equalsIgnoreCase(myaction)) {
/*   60:  59 */       myforward = performAdd(mapping, actionForm, request, response);
/*   61:  60 */     } else if ("LOAD".equalsIgnoreCase(myaction)) {
/*   62:  61 */       myforward = performLoad(mapping, actionForm, request, response);
/*   63:  62 */     } else if ("SEARCH".equalsIgnoreCase(myaction)) {
/*   64:  63 */       myforward = performList(myaction, mapping, actionForm, request, response);
/*   65:  64 */     } else if ("LIST".equalsIgnoreCase(myaction)) {
/*   66:  65 */       myforward = performList(myaction, mapping, actionForm, request, response);
/*   67:  66 */     } else if ("REMOVE".equalsIgnoreCase(myaction)) {
/*   68:  67 */       myforward = performRemove(myaction, mapping, actionForm, request, response);
/*   69:  68 */     } else if ("SAVE".equalsIgnoreCase(myaction)) {
/*   70:  69 */       myforward = performSave(mapping, actionForm, request, response);
/*   71:  70 */     } else if ("SAVEEDIT".equalsIgnoreCase(myaction)) {
/*   72:  71 */       myforward = performSaveEdit(mapping, actionForm, request, response);
/*   73:  72 */     } else if ("REPORT".equalsIgnoreCase(myaction)) {
/*   74:  73 */       myforward = performReports(mapping, actionForm, request, response);
/*   75:  74 */     } else if ("MPERROS".equalsIgnoreCase(myaction)) {
/*   76:  75 */       myforward = performMPerros(mapping, actionForm, request, response);
/*   77:  76 */     } else if ("MGATOS".equalsIgnoreCase(myaction)) {
/*   78:  77 */       myforward = performMGatos(mapping, actionForm, request, response);
/*   79:  78 */     } else if ("ASPECTOS".equalsIgnoreCase(myaction)) {
/*   80:  79 */       myforward = performAspectos(mapping, actionForm, request, response);
/*   81:     */     } else {
/*   82:  81 */       myforward = mapping.findForward("failure");
/*   83:     */     }
/*   84:  84 */     return myforward;
/*   85:     */   }
/*   86:     */   
/*   87:     */   private ActionForward performSave(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*   88:     */   {
/*   89:  96 */     if (isTokenValid(request, true))
/*   90:     */     {
/*   91:  97 */       MascotaCompletoForm form = (MascotaCompletoForm)actionForm;
/*   92:     */       try
/*   93:     */       {
/*   94: 100 */         UsuarioPets usuarioPets = (UsuarioPets)request.getSession().getAttribute("usuarioPets");
/*   95:     */         
/*   96: 102 */         form.setMas_fecnac(ManejoFechas.getChangeFecha(form.getMas_fecnac()));
/*   97: 103 */         form.setMas_fecinscripcion(ManejoFechas.getFechaActual());
/*   98: 104 */         form.setMali_fecultpeso(ManejoFechas.getChangeFecha(form.getMali_fecultpeso()));
/*   99: 105 */         form.setCmas_fecnacim(ManejoFechas.getChangeFecha(form.getCmas_fecnacim()));
/*  100: 107 */         if (form.getPmas_indpais1().length() == 0) {
/*  101: 108 */           form.setPmas_indpais1("0");
/*  102:     */         }
/*  103: 110 */         if (form.getPmas_indciudad1().length() == 0) {
/*  104: 111 */           form.setPmas_indciudad1("0");
/*  105:     */         }
/*  106: 113 */         if (form.getPmas_indpais2().length() == 0) {
/*  107: 114 */           form.setPmas_indpais2("0");
/*  108:     */         }
/*  109: 117 */         MascotaCompleto mascotaCompleto = new MascotaCompleto();
/*  110:     */         
/*  111: 119 */         Mascota mascota = new Mascota();
/*  112: 120 */         InicializaData.inicializa(mascota.getClass(), mascota);
/*  113: 121 */         BeanUtils.copyProperties(mascota, form);
/*  114: 122 */         mascota.setMas_usup_cod(usuarioPets.getUsup_cod());
/*  115:     */         
/*  116: 124 */         mascotaCompleto.setMascota(mascota);
/*  117: 125 */         mascotaCompleto.setControles(null);
/*  118:     */         
/*  119: 127 */         PropietariosMascota propietariosMascota = new PropietariosMascota();
/*  120: 128 */         InicializaData.inicializa(propietariosMascota.getClass(), propietariosMascota);
/*  121: 129 */         BeanUtils.copyProperties(propietariosMascota, form);
/*  122: 130 */         propietariosMascota.setPmas_mas_cod(mascota.getMas_cod());
/*  123:     */         
/*  124: 132 */         MascotaAlimentacion mascotaAlimentacion = new MascotaAlimentacion();
/*  125: 133 */         InicializaData.inicializa(mascotaAlimentacion.getClass(), mascotaAlimentacion);
/*  126: 134 */         BeanUtils.copyProperties(mascotaAlimentacion, form);
/*  127: 135 */         mascotaAlimentacion.setMali_mas_cod(mascota.getMas_cod());
/*  128:     */         
/*  129: 137 */         ContactosMascota contactosMascota = new ContactosMascota();
/*  130: 138 */         InicializaData.inicializa(contactosMascota.getClass(), contactosMascota);
/*  131: 139 */         BeanUtils.copyProperties(contactosMascota, form);
/*  132: 140 */         contactosMascota.setCmas_mas_cod(mascota.getMas_cod());
/*  133: 141 */         contactosMascota.setCmas_mail(usuarioPets.getUsup_usuario());
/*  134: 142 */         if (request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2).equals("es")) {
/*  135: 143 */           contactosMascota.setCmas_idio_cod(BigDecimal.ONE);
/*  136:     */         }
/*  137: 145 */         if (request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2).equals("en")) {
/*  138: 146 */           contactosMascota.setCmas_idio_cod(new BigDecimal(2));
/*  139:     */         }
/*  140: 150 */         int x = 0;
/*  141: 151 */         VacunasCuidadosDAO vacunasCuidadosDAO = new VacunasCuidadosDAO();
/*  142: 152 */         Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  143: 153 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  144: 154 */           vacunasCuidadosDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  145:     */         }
/*  146: 156 */         ArrayList controlCuidados = new ArrayList();
/*  147: 157 */         vacunasCuidadosDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  148: 158 */         mascotaCompleto.setTablaAjustada(vacunasCuidadosDAO.list(IConstantes.CODIGO_MASCOTA_DEFAULT, new BigDecimal(mascotaCompleto.getMascota().getMas_tipo())));
/*  149: 159 */         List vacunasCuidados = mascotaCompleto.getTablaAjustada();
/*  150: 160 */         while (x < vacunasCuidados.size())
/*  151:     */         {
/*  152: 161 */           VacunasCuidados vacunaCuidados = (VacunasCuidados)vacunasCuidados.get(x);
/*  153: 162 */           vacunaCuidados.setVcui_mas_cod(mascota.getMas_cod());
/*  154: 163 */           ControlCuidados control = new ControlCuidados();
/*  155: 164 */           InicializaData.inicializa(control.getClass(), control);
/*  156: 165 */           control.setElementoTabla(vacunaCuidados);
/*  157: 167 */           if (vacunaCuidados.getVcui_raz_tipo().equals(BigDecimal.ZERO)) {
/*  158: 168 */             if ((vacunaCuidados.getVcui_cod().equals(BigDecimal.ONE)) || (vacunaCuidados.getVcui_cod().equals(new BigDecimal("2"))) || (vacunaCuidados.getVcui_cod().equals(new BigDecimal("3"))) || (vacunaCuidados.getVcui_cod().equals(new BigDecimal("4")))) {
/*  159: 169 */               control.setCcui_grup_cod(IGrupos.PETS_GRUPO_A);
/*  160:     */             } else {
/*  161: 171 */               control.setCcui_grup_cod(IGrupos.PETS_GRUPO_B);
/*  162:     */             }
/*  163:     */           }
/*  164: 174 */           if (vacunaCuidados.getVcui_raz_tipo().equals(BigDecimal.ONE)) {
/*  165: 175 */             if ((vacunaCuidados.getVcui_cod().equals(new BigDecimal("15"))) || (vacunaCuidados.getVcui_cod().equals(new BigDecimal("16"))) || (vacunaCuidados.getVcui_cod().equals(new BigDecimal("17"))) || (vacunaCuidados.getVcui_cod().equals(new BigDecimal("18")))) {
/*  166: 176 */               control.setCcui_grup_cod(IGrupos.PETS_GRUPO_A);
/*  167:     */             } else {
/*  168: 178 */               control.setCcui_grup_cod(IGrupos.PETS_GRUPO_B);
/*  169:     */             }
/*  170:     */           }
/*  171: 182 */           controlCuidados.add(control);
/*  172: 183 */           x++;
/*  173:     */         }
/*  174: 186 */         x = 0;
/*  175: 187 */         GruposDAO gruposDAO = new GruposDAO();
/*  176: 188 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  177: 189 */           gruposDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  178:     */         }
/*  179: 191 */         gruposDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  180: 192 */         GruposMascotaDAO gruposMascotaDAO = new GruposMascotaDAO();
/*  181: 193 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  182: 194 */           gruposMascotaDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  183:     */         }
/*  184: 196 */         List gruposMascota = new ArrayList();
/*  185: 197 */         Field[] constantes = IGrupos.class.getFields();
/*  186: 198 */         for (int j = 0; j < constantes.length; j++) {
/*  187: 199 */           if (constantes[j].getName().indexOf("PETS") != -1)
/*  188:     */           {
/*  189: 200 */             GruposMascota grupoMascota = gruposMascotaDAO.search(mascota.getMas_cod(), (BigDecimal)constantes[j].get(null));
/*  190: 201 */             if (grupoMascota.getGrupm_mas_cod() == null)
/*  191:     */             {
/*  192: 204 */               Grupos grupo = gruposDAO.retrive((BigDecimal)constantes[j].get(null));
/*  193: 205 */               grupoMascota.setGrupm_cod(new BigDecimal(x + 1.0D));
/*  194: 206 */               grupoMascota.setGrupm_dias_antes(grupo.getGrup_dias_antes());
/*  195: 207 */               grupoMascota.setGrupm_grup_cod(grupo.getGrup_cod());
/*  196: 208 */               grupoMascota.setGrupm_mas_cod(mascota.getMas_cod());
/*  197:     */             }
/*  198: 210 */             gruposMascota.add(grupoMascota);
/*  199:     */           }
/*  200:     */         }
/*  201: 214 */         mascotaCompleto.setGrupos(gruposMascota);
/*  202: 215 */         mascotaCompleto.setControles(controlCuidados);
/*  203: 216 */         mascotaCompleto.setTablaAjustada(vacunasCuidados);
/*  204: 217 */         mascotaCompleto.setMascota(mascota);
/*  205: 218 */         mascotaCompleto.setContactoMascota(contactosMascota);
/*  206: 219 */         mascotaCompleto.setMascotaAlimentacion(mascotaAlimentacion);
/*  207: 220 */         mascotaCompleto.setPropietarioMascota(propietariosMascota);
/*  208:     */         
/*  209: 222 */         MascotaCompletoDAO mascotaCompletoDAO = new MascotaCompletoDAO();
/*  210: 223 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  211: 224 */           mascotaCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  212:     */         }
/*  213: 226 */         mascotaCompletoDAO.insert(mascotaCompleto);
/*  214:     */         
/*  215: 228 */         request.getSession().removeAttribute("mascotaCompletoForm");
/*  216:     */       }
/*  217:     */       catch (Exception e)
/*  218:     */       {
/*  219: 231 */         e.printStackTrace();
/*  220: 232 */         return mapping.findForward("failure");
/*  221:     */       }
/*  222:     */     }
/*  223:     */     else
/*  224:     */     {
/*  225: 237 */       return mapping.findForward("failure");
/*  226:     */     }
/*  227: 240 */     return mapping.findForward("success");
/*  228:     */   }
/*  229:     */   
/*  230:     */   private ActionForward performEdit(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  231:     */   {
/*  232: 252 */     MascotaCompletoForm form = (MascotaCompletoForm)actionForm;
/*  233: 253 */     Boolean nuevo = Boolean.valueOf(false);
/*  234:     */     try
/*  235:     */     {
/*  236: 256 */       MascotaCompletoDAO mascotaCompletoDAO = new MascotaCompletoDAO();
/*  237: 257 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  238: 258 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  239: 259 */         mascotaCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  240:     */       }
/*  241: 261 */       mascotaCompletoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  242: 262 */       MascotaCompleto mascotaCompleto = mascotaCompletoDAO.retrieve(new BigDecimal(request.getParameter("mas_cod")));
/*  243:     */       
/*  244: 264 */       Mascota mascota = mascotaCompleto.getMascota();
/*  245:     */       
/*  246: 266 */       request.getSession().setAttribute("mascota", mascota);
/*  247: 267 */       PropietariosMascota propietariosMascota = mascotaCompleto.getPropietarioMascota();
/*  248: 268 */       MascotaAlimentacion mascotaAlimentacion = mascotaCompleto.getMascotaAlimentacion();
/*  249:     */       
/*  250: 270 */       BeanUtils.copyProperties(form, mascota);
/*  251: 271 */       BeanUtils.copyProperties(form, propietariosMascota);
/*  252: 272 */       BeanUtils.copyProperties(form, mascotaAlimentacion);
/*  253:     */       
/*  254: 274 */       form.setMas_fecnac(ManejoFechas.FormateoFecha(form.getMas_fecnac()));
/*  255: 275 */       form.setMas_fecinscripcion(ManejoFechas.FormateoFecha(form.getMas_fecinscripcion()));
/*  256: 276 */       form.setMali_fecultpeso(ManejoFechas.FormateoFecha(form.getMali_fecultpeso()));
/*  257:     */       
/*  258: 278 */       List vacunasCuidados = mascotaCompleto.getTablaAjustada();
/*  259: 279 */       List controlCuidados = mascotaCompleto.getControles();
/*  260:     */       
/*  261: 281 */       int x = 0;
/*  262: 282 */       if (vacunasCuidados.size() == 0)
/*  263:     */       {
/*  264: 283 */         nuevo = Boolean.valueOf(true);
/*  265: 284 */         vacunasCuidados = mascotaCompleto.getTablaUniversal();
/*  266: 285 */         while (x < vacunasCuidados.size())
/*  267:     */         {
/*  268: 286 */           VacunasCuidados vacunaCuidados = (VacunasCuidados)vacunasCuidados.get(x);
/*  269: 287 */           vacunaCuidados.setVcui_mas_cod(mascota.getMas_cod());
/*  270: 288 */           ControlCuidados control = new ControlCuidados();
/*  271: 289 */           InicializaData.inicializa(control.getClass(), control);
/*  272: 290 */           control.setElementoTabla(vacunaCuidados);
/*  273: 291 */           control.setCcui_grup_cod(IGrupos.PETS_GRUPO_A);
/*  274: 292 */           controlCuidados.add(control);
/*  275: 293 */           x++;
/*  276:     */         }
/*  277:     */       }
/*  278: 300 */       request.getSession().setAttribute("VACUNASCUIDADOS", vacunasCuidados);
/*  279: 301 */       request.getSession().setAttribute("VACUNASCUIDADOSUNIVERSALES", mascotaCompleto.getTablaUniversal());
/*  280:     */       
/*  281: 303 */       request.getSession().setAttribute("CONTROLCUIDADOS", controlCuidados);
/*  282: 304 */       ContactosMascota contactosMascota = mascotaCompleto.getContactoMascota();
/*  283: 305 */       BeanUtils.copyProperties(form, contactosMascota);
/*  284: 306 */       form.setCmas_fecnacim(ManejoFechas.FormateoFecha(form.getCmas_fecnacim()));
/*  285:     */       
/*  286: 308 */       List mascotaMedicamentos = mascotaCompleto.getMedicamentos();
/*  287: 309 */       request.getSession().setAttribute("MASCOTAMEDICAMENTOS", mascotaMedicamentos);
/*  288:     */       
/*  289: 311 */       List mascotaSeguros = mascotaCompleto.getSeguros();
/*  290: 312 */       request.getSession().setAttribute("SEGUROPETS", mascotaSeguros);
/*  291:     */       
/*  292: 314 */       List mascotaEnfermedades = mascotaCompleto.getEnfermedades();
/*  293: 315 */       request.getSession().setAttribute("ENFERMEDADESPETS", mascotaEnfermedades);
/*  294:     */       
/*  295: 317 */       List mascotaAlergias = mascotaCompleto.getAlergias();
/*  296: 318 */       request.getSession().setAttribute("ALERGIASPETS", mascotaAlergias);
/*  297:     */       
/*  298: 320 */       List mascotaCirugias = mascotaCompleto.getCirugias();
/*  299: 321 */       request.getSession().setAttribute("CIRUGIASPETS", mascotaCirugias);
/*  300:     */       
/*  301:     */ 
/*  302:     */ 
/*  303: 325 */       PaisDAO paisDAO = new PaisDAO();
/*  304: 326 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  305: 327 */         paisDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  306:     */       }
/*  307: 329 */       paisDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  308: 330 */       List paises = paisDAO.list();
/*  309: 331 */       request.setAttribute("PAISES", paises);
/*  310:     */       
/*  311: 333 */       List ciudadesProp = new ArrayList();
/*  312: 334 */       List ciudadesCont1 = new ArrayList();
/*  313: 335 */       CiudadDAO ciudadesDAO = new CiudadDAO();
/*  314: 336 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  315: 337 */         ciudadesDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  316:     */       }
/*  317: 339 */       ciudadesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  318: 340 */       if (paises.size() > 0)
/*  319:     */       {
/*  320: 341 */         if ((!form.getPmas_pais_cod().equals("")) && (!form.getPmas_pais_cod().equals("0"))) {
/*  321: 342 */           ciudadesProp = ciudadesDAO.search(form.getPmas_pais_cod());
/*  322:     */         } else {
/*  323: 344 */           ciudadesProp = ciudadesDAO.search(((Paises)paises.get(0)).getPais_cod().toString());
/*  324:     */         }
/*  325: 347 */         if ((!form.getCmas_pais_cod().equals("")) && (!form.getCmas_pais_cod().equals("0"))) {
/*  326: 348 */           ciudadesCont1 = ciudadesDAO.search(form.getCmas_pais_cod());
/*  327:     */         } else {
/*  328: 350 */           ciudadesCont1 = ciudadesDAO.search(((Paises)paises.get(0)).getPais_cod().toString());
/*  329:     */         }
/*  330:     */       }
/*  331: 354 */       request.setAttribute("CIUDADESPROP", ciudadesProp);
/*  332: 355 */       request.setAttribute("CIUDADESCONT1", ciudadesCont1);
/*  333:     */       
/*  334: 357 */       List razas = new ArrayList();
/*  335: 358 */       RazasDAO razasDAO = new RazasDAO();
/*  336: 359 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  337: 360 */         razasDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  338:     */       }
/*  339: 362 */       razasDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  340: 363 */       if (!form.getMas_tipo().equals("")) {
/*  341: 364 */         razas = razasDAO.list(new BigDecimal(form.getMas_tipo()));
/*  342:     */       }
/*  343: 366 */       request.setAttribute("RAZAS", razas);
/*  344:     */       
/*  345: 368 */       x = 0;
/*  346: 369 */       GruposDAO gruposDAO = new GruposDAO();
/*  347: 370 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  348: 371 */         gruposDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  349:     */       }
/*  350: 373 */       gruposDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  351: 374 */       GruposMascotaDAO gruposMascotaDAO = new GruposMascotaDAO();
/*  352: 375 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  353: 376 */         gruposMascotaDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  354:     */       }
/*  355: 378 */       List gruposMascota = new ArrayList();
/*  356: 379 */       Field[] constantes = IGrupos.class.getFields();
/*  357: 380 */       for (int j = 0; j < constantes.length; j++) {
/*  358: 381 */         if (constantes[j].getName().indexOf("PETS") != -1)
/*  359:     */         {
/*  360: 382 */           GruposMascota grupoMascota = gruposMascotaDAO.search(mascota.getMas_cod(), (BigDecimal)constantes[j].get(null));
/*  361: 383 */           if (grupoMascota.getGrupm_mas_cod() == null)
/*  362:     */           {
/*  363: 386 */             Grupos grupo = gruposDAO.retrive((BigDecimal)constantes[j].get(null));
/*  364: 387 */             grupoMascota.setGrupm_cod(new BigDecimal(x + 1.0D));
/*  365: 388 */             grupoMascota.setGrupm_dias_antes(grupo.getGrup_dias_antes());
/*  366: 389 */             grupoMascota.setGrupm_grup_cod(grupo.getGrup_cod());
/*  367: 390 */             grupoMascota.setGrupm_mas_cod(mascota.getMas_cod());
/*  368:     */           }
/*  369: 392 */           gruposMascota.add(grupoMascota);
/*  370:     */         }
/*  371:     */       }
/*  372: 395 */       List gruposLabels = new ArrayList();
/*  373: 396 */       int i = 0;
/*  374: 397 */       while (i < gruposMascota.size())
/*  375:     */       {
/*  376: 398 */         Grupos grupo = gruposDAO.retrive(((GruposMascota)gruposMascota.get(i)).getGrupm_grup_cod());
/*  377: 399 */         gruposLabels.add(grupo);
/*  378: 400 */         request.setAttribute("grupm_desc" + i, grupo.getGrup_desc());
/*  379: 401 */         i++;
/*  380:     */       }
/*  381: 404 */       request.getSession().setAttribute("GRUPOSMASCOTA", gruposMascota);
/*  382: 405 */       request.setAttribute("GRUPOS", gruposLabels);
/*  383:     */       
/*  384: 407 */       IdiomaDAO idiomaDAO = new IdiomaDAO();
/*  385: 408 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  386: 409 */         idiomaDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  387:     */       }
/*  388: 411 */       request.setAttribute("IDIOMAS", idiomaDAO.list());
/*  389:     */     }
/*  390:     */     catch (Exception e)
/*  391:     */     {
/*  392: 423 */       e.printStackTrace();
/*  393: 424 */       return mapping.findForward("failure");
/*  394:     */     }
/*  395: 427 */     return mapping.findForward("success");
/*  396:     */   }
/*  397:     */   
/*  398:     */   private ActionForward performSaveEdit(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  399:     */   {
/*  400: 440 */     MascotaCompletoForm form = (MascotaCompletoForm)actionForm;
/*  401:     */     try
/*  402:     */     {
/*  403: 443 */       UsuarioPets usuarioPets = (UsuarioPets)request.getSession().getAttribute("usuarioPets");
/*  404:     */       
/*  405: 445 */       form.setMas_fecnac(ManejoFechas.getChangeFecha(form.getMas_fecnac()));
/*  406: 446 */       form.setMas_fecinscripcion(ManejoFechas.getChangeFecha(form.getMas_fecinscripcion()));
/*  407: 447 */       form.setMali_fecultpeso(ManejoFechas.getChangeFecha(form.getMali_fecultpeso()));
/*  408: 448 */       form.setCmas_fecnacim(ManejoFechas.getChangeFecha(form.getCmas_fecnacim()));
/*  409: 450 */       if (form.getPmas_indpais1().length() == 0) {
/*  410: 451 */         form.setPmas_indpais1("0");
/*  411:     */       }
/*  412: 453 */       if (form.getPmas_indciudad1().length() == 0) {
/*  413: 454 */         form.setPmas_indciudad1("0");
/*  414:     */       }
/*  415: 456 */       if (form.getPmas_indpais2().length() == 0) {
/*  416: 457 */         form.setPmas_indpais2("0");
/*  417:     */       }
/*  418: 460 */       MascotaCompleto mascotaCompleto = new MascotaCompleto();
/*  419:     */       
/*  420: 462 */       Mascota mascota = new Mascota();
/*  421: 463 */       InicializaData.inicializa(mascota.getClass(), mascota);
/*  422: 464 */       BeanUtils.copyProperties(mascota, form);
/*  423: 465 */       mascota.setMas_usup_cod(usuarioPets.getUsup_cod());
/*  424:     */       
/*  425: 467 */       PropietariosMascota propietariosMascota = new PropietariosMascota();
/*  426: 468 */       InicializaData.inicializa(propietariosMascota.getClass(), propietariosMascota);
/*  427: 469 */       BeanUtils.copyProperties(propietariosMascota, form);
/*  428:     */       
/*  429: 471 */       MascotaAlimentacion mascotaAlimentacion = new MascotaAlimentacion();
/*  430: 472 */       InicializaData.inicializa(mascotaAlimentacion.getClass(), mascotaAlimentacion);
/*  431: 473 */       BeanUtils.copyProperties(mascotaAlimentacion, form);
/*  432:     */       
/*  433: 475 */       ContactosMascota contactosMascota = new ContactosMascota();
/*  434: 476 */       InicializaData.inicializa(contactosMascota.getClass(), contactosMascota);
/*  435: 477 */       if (request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2).equals("es")) {
/*  436: 478 */         contactosMascota.setCmas_idio_cod(BigDecimal.ONE);
/*  437:     */       }
/*  438: 480 */       if (request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2).equals("en")) {
/*  439: 481 */         contactosMascota.setCmas_idio_cod(new BigDecimal(2));
/*  440:     */       }
/*  441: 483 */       BeanUtils.copyProperties(contactosMascota, form);
/*  442:     */       
/*  443: 485 */       List vacunasCuidados = (List)request.getSession().getAttribute("VACUNASCUIDADOS");
/*  444: 486 */       List controlCuidados = (List)request.getSession().getAttribute("CONTROLCUIDADOS");
/*  445:     */       
/*  446:     */ 
/*  447:     */ 
/*  448: 490 */       int x = 0;
/*  449: 491 */       if (request.getParameter("control[0].ccui_grup_cod") != null)
/*  450:     */       {
/*  451: 492 */         while (x < controlCuidados.size())
/*  452:     */         {
/*  453: 493 */           ControlCuidados controlCuidado = (ControlCuidados)controlCuidados.get(x);
/*  454: 494 */           controlCuidado.setCcui_grup_cod(new BigDecimal(request.getParameter("control[" + x + "].ccui_grup_cod")));
/*  455: 495 */           x++;
/*  456:     */         }
/*  457: 498 */         List grupos = (List)request.getSession().getAttribute("GRUPOSMASCOTA");
/*  458: 499 */         x = 0;
/*  459: 500 */         while (x < grupos.size())
/*  460:     */         {
/*  461: 501 */           GruposMascota grupoMascota = (GruposMascota)grupos.get(x);
/*  462: 502 */           grupoMascota.setGrupm_dias_antes(new BigDecimal(request.getParameter("grupo[" + x + "].grupm_dias_antes")));
/*  463: 503 */           x++;
/*  464:     */         }
/*  465: 505 */         request.getSession().setAttribute("GRUPOSMASCOTA", grupos);
/*  466: 506 */         mascotaCompleto.setGrupos(grupos);
/*  467:     */       }
/*  468: 512 */       x = 0;
/*  469: 513 */       String fechaActual = ManejoFechas.getFechaActual();
/*  470: 514 */       String fecnacMascota = mascota.getMas_fecnac().toString();
/*  471: 515 */       List grupos2 = (List)request.getSession().getAttribute("GRUPOSMASCOTA");
/*  472: 517 */       while (x < vacunasCuidados.size())
/*  473:     */       {
/*  474: 518 */         VacunasCuidados vacunasCuidadosS = (VacunasCuidados)vacunasCuidados.get(x);
/*  475: 520 */         if (request.getParameter("check030" + x) != null) {
/*  476: 521 */           vacunasCuidadosS.setVcui_30("1");
/*  477:     */         } else {
/*  478: 523 */           vacunasCuidadosS.setVcui_30("0");
/*  479:     */         }
/*  480: 524 */         if (request.getParameter("check045" + x) != null) {
/*  481: 525 */           vacunasCuidadosS.setVcui_45("1");
/*  482:     */         } else {
/*  483: 527 */           vacunasCuidadosS.setVcui_45("0");
/*  484:     */         }
/*  485: 528 */         if (request.getParameter("check060" + x) != null) {
/*  486: 529 */           vacunasCuidadosS.setVcui_60("1");
/*  487:     */         } else {
/*  488: 531 */           vacunasCuidadosS.setVcui_60("0");
/*  489:     */         }
/*  490: 532 */         if (request.getParameter("check075" + x) != null) {
/*  491: 533 */           vacunasCuidadosS.setVcui_75("1");
/*  492:     */         } else {
/*  493: 535 */           vacunasCuidadosS.setVcui_75("0");
/*  494:     */         }
/*  495: 536 */         if (request.getParameter("check090" + x) != null) {
/*  496: 537 */           vacunasCuidadosS.setVcui_90("1");
/*  497:     */         } else {
/*  498: 539 */           vacunasCuidadosS.setVcui_90("0");
/*  499:     */         }
/*  500: 540 */         if (request.getParameter("check105" + x) != null) {
/*  501: 541 */           vacunasCuidadosS.setVcui_105("1");
/*  502:     */         } else {
/*  503: 543 */           vacunasCuidadosS.setVcui_105("0");
/*  504:     */         }
/*  505: 544 */         if (request.getParameter("check120" + x) != null) {
/*  506: 545 */           vacunasCuidadosS.setVcui_120("1");
/*  507:     */         } else {
/*  508: 547 */           vacunasCuidadosS.setVcui_120("0");
/*  509:     */         }
/*  510: 548 */         if (request.getParameter("check150" + x) != null) {
/*  511: 549 */           vacunasCuidadosS.setVcui_150("1");
/*  512:     */         } else {
/*  513: 551 */           vacunasCuidadosS.setVcui_150("0");
/*  514:     */         }
/*  515: 552 */         if (request.getParameter("check180" + x) != null) {
/*  516: 553 */           vacunasCuidadosS.setVcui_180("1");
/*  517:     */         } else {
/*  518: 555 */           vacunasCuidadosS.setVcui_180("0");
/*  519:     */         }
/*  520: 557 */         vacunasCuidadosS.setVcui_control(new BigDecimal(request.getParameter("control" + x).toString()));
/*  521:     */         
/*  522:     */ 
/*  523: 560 */         ControlCuidados controlCuidadosS = (ControlCuidados)controlCuidados.get(x);
/*  524: 561 */         GruposMascota gruposMascota = (GruposMascota)grupos2.get(controlCuidadosS.getCcui_grup_cod().intValue() - 1);
/*  525: 562 */         int frecuencia = controlCuidadosS.getElementoTabla().getVcui_control().intValue();
/*  526: 563 */         int diasAntes = gruposMascota.getGrupm_dias_antes().intValue();
/*  527: 564 */         int noRecordatorios = 0;
/*  528: 565 */         if (gruposMascota.getGrupm_grup_cod().intValue() == 1) {
/*  529: 565 */           noRecordatorios = 2;
/*  530:     */         } else {
/*  531: 566 */           noRecordatorios = 1;
/*  532:     */         }
/*  533: 568 */         if ((controlCuidadosS.getCcui_fecproxapli().toString().equals("0")) && (controlCuidadosS.getCcui_fecultapli().toString().equals("0")))
/*  534:     */         {
/*  535: 571 */           int dias = 0;
/*  536: 572 */           String fechaParametro = fecnacMascota;
/*  537: 573 */           String fechaParametro2 = fecnacMascota;
/*  538: 574 */           while (fechaParametro2.compareTo(fechaActual) < 1)
/*  539:     */           {
/*  540: 575 */             fechaParametro2 = GestorFechasCompleto.fechaMasDias(fechaParametro2, "yyyyMMdd", 1);
/*  541: 576 */             dias++;
/*  542:     */           }
/*  543: 581 */           boolean siguiente = false;
/*  544: 582 */           if ((controlCuidadosS.getElementoTabla().getVcui_30().equals("1")) && (dias < 30))
/*  545:     */           {
/*  546: 583 */             if (noRecordatorios == 2) {
/*  547: 583 */               controlCuidadosS.setCcui_fecenvion(new BigDecimal(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 30 - diasAntes))));
/*  548:     */             } else {
/*  549: 584 */               controlCuidadosS.setCcui_fecenvion(BigDecimal.ZERO);
/*  550:     */             }
/*  551: 585 */             controlCuidadosS.setCcui_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(fecnacMascota, "yyyyMMdd", 28)));
/*  552: 586 */             controlCuidadosS.setCcui_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 45)));
/*  553: 587 */             siguiente = true;
/*  554:     */           }
/*  555: 589 */           if ((controlCuidadosS.getElementoTabla().getVcui_45().equals("1")) && (dias < 45) && (!siguiente))
/*  556:     */           {
/*  557: 590 */             if (noRecordatorios == 2) {
/*  558: 590 */               controlCuidadosS.setCcui_fecenvion(new BigDecimal(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 45 - diasAntes))));
/*  559:     */             } else {
/*  560: 591 */               controlCuidadosS.setCcui_fecenvion(BigDecimal.ZERO);
/*  561:     */             }
/*  562: 592 */             controlCuidadosS.setCcui_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(fecnacMascota, "yyyyMMdd", 43)));
/*  563: 593 */             controlCuidadosS.setCcui_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 60)));
/*  564: 594 */             siguiente = true;
/*  565:     */           }
/*  566: 596 */           if ((controlCuidadosS.getElementoTabla().getVcui_60().equals("1")) && (dias < 60) && (!siguiente))
/*  567:     */           {
/*  568: 597 */             if (noRecordatorios == 2) {
/*  569: 597 */               controlCuidadosS.setCcui_fecenvion(new BigDecimal(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 60 - diasAntes))));
/*  570:     */             } else {
/*  571: 598 */               controlCuidadosS.setCcui_fecenvion(BigDecimal.ZERO);
/*  572:     */             }
/*  573: 599 */             controlCuidadosS.setCcui_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(fecnacMascota, "yyyyMMdd", 58)));
/*  574: 600 */             controlCuidadosS.setCcui_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 75)));
/*  575: 601 */             siguiente = true;
/*  576:     */           }
/*  577: 603 */           if ((controlCuidadosS.getElementoTabla().getVcui_75().equals("1")) && (dias < 75) && (!siguiente))
/*  578:     */           {
/*  579: 604 */             if (noRecordatorios == 2) {
/*  580: 604 */               controlCuidadosS.setCcui_fecenvion(new BigDecimal(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 75 - diasAntes))));
/*  581:     */             } else {
/*  582: 605 */               controlCuidadosS.setCcui_fecenvion(BigDecimal.ZERO);
/*  583:     */             }
/*  584: 606 */             controlCuidadosS.setCcui_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(fecnacMascota, "yyyyMMdd", 73)));
/*  585: 607 */             controlCuidadosS.setCcui_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 90)));
/*  586: 608 */             siguiente = true;
/*  587:     */           }
/*  588: 610 */           if ((controlCuidadosS.getElementoTabla().getVcui_90().equals("1")) && (dias < 90) && (!siguiente))
/*  589:     */           {
/*  590: 611 */             if (noRecordatorios == 2) {
/*  591: 611 */               controlCuidadosS.setCcui_fecenvion(new BigDecimal(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 90 - diasAntes))));
/*  592:     */             } else {
/*  593: 612 */               controlCuidadosS.setCcui_fecenvion(BigDecimal.ZERO);
/*  594:     */             }
/*  595: 613 */             controlCuidadosS.setCcui_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(fecnacMascota, "yyyyMMdd", 88)));
/*  596: 614 */             controlCuidadosS.setCcui_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 105)));
/*  597: 615 */             siguiente = true;
/*  598:     */           }
/*  599: 617 */           if ((controlCuidadosS.getElementoTabla().getVcui_105().equals("1")) && (dias < 105) && (!siguiente))
/*  600:     */           {
/*  601: 618 */             if (noRecordatorios == 2) {
/*  602: 618 */               controlCuidadosS.setCcui_fecenvion(new BigDecimal(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 105 - diasAntes))));
/*  603:     */             } else {
/*  604: 619 */               controlCuidadosS.setCcui_fecenvion(BigDecimal.ZERO);
/*  605:     */             }
/*  606: 620 */             controlCuidadosS.setCcui_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(fecnacMascota, "yyyyMMdd", 103)));
/*  607: 621 */             controlCuidadosS.setCcui_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 120)));
/*  608: 622 */             siguiente = true;
/*  609:     */           }
/*  610: 624 */           if ((controlCuidadosS.getElementoTabla().getVcui_120().equals("1")) && (dias < 120) && (!siguiente))
/*  611:     */           {
/*  612: 625 */             if (noRecordatorios == 2) {
/*  613: 625 */               controlCuidadosS.setCcui_fecenvion(new BigDecimal(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 120 - diasAntes))));
/*  614:     */             } else {
/*  615: 626 */               controlCuidadosS.setCcui_fecenvion(BigDecimal.ZERO);
/*  616:     */             }
/*  617: 627 */             controlCuidadosS.setCcui_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(fecnacMascota, "yyyyMMdd", 118)));
/*  618: 628 */             controlCuidadosS.setCcui_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 135)));
/*  619: 629 */             siguiente = true;
/*  620:     */           }
/*  621: 631 */           if ((controlCuidadosS.getElementoTabla().getVcui_150().equals("1")) && (dias < 150) && (!siguiente))
/*  622:     */           {
/*  623: 632 */             if (noRecordatorios == 2) {
/*  624: 632 */               controlCuidadosS.setCcui_fecenvion(new BigDecimal(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 150 - diasAntes))));
/*  625:     */             } else {
/*  626: 633 */               controlCuidadosS.setCcui_fecenvion(BigDecimal.ZERO);
/*  627:     */             }
/*  628: 634 */             controlCuidadosS.setCcui_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(fecnacMascota, "yyyyMMdd", 148)));
/*  629: 635 */             controlCuidadosS.setCcui_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 165)));
/*  630: 636 */             siguiente = true;
/*  631:     */           }
/*  632: 638 */           if ((controlCuidadosS.getElementoTabla().getVcui_180().equals("1")) && (dias < 180) && (!siguiente))
/*  633:     */           {
/*  634: 639 */             if (noRecordatorios == 2) {
/*  635: 639 */               controlCuidadosS.setCcui_fecenvion(new BigDecimal(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 180 - diasAntes))));
/*  636:     */             } else {
/*  637: 640 */               controlCuidadosS.setCcui_fecenvion(BigDecimal.ZERO);
/*  638:     */             }
/*  639: 641 */             controlCuidadosS.setCcui_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(fecnacMascota, "yyyyMMdd", 178)));
/*  640: 642 */             controlCuidadosS.setCcui_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 195)));
/*  641: 643 */             siguiente = true;
/*  642:     */           }
/*  643: 645 */           if ((dias >= 180) && (!siguiente) && 
/*  644: 646 */             (frecuencia != 0))
/*  645:     */           {
/*  646: 647 */             fechaParametro = GestorFechasCompleto.fechaMasDias(fecnacMascota, "yyyyMMdd", 180);
/*  647: 648 */             while (fechaParametro.compareTo(fechaActual) < 1) {
/*  648: 649 */               fechaParametro = GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", frecuencia);
/*  649:     */             }
/*  650: 651 */             if (noRecordatorios == 2) {
/*  651: 651 */               controlCuidadosS.setCcui_fecenvion(new BigDecimal(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", -diasAntes))));
/*  652:     */             } else {
/*  653: 652 */               controlCuidadosS.setCcui_fecenvion(BigDecimal.ZERO);
/*  654:     */             }
/*  655: 653 */             controlCuidadosS.setCcui_fecenvio2(new BigDecimal(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", -2))));
/*  656: 654 */             controlCuidadosS.setCcui_quince_dias(new BigDecimal(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 15))));
/*  657:     */           }
/*  658:     */         }
/*  659: 660 */         if (!controlCuidadosS.getCcui_fecproxapli().toString().equals("0")) {
/*  660: 662 */           if (controlCuidadosS.getCcui_cita_prox().toString().equals("1"))
/*  661:     */           {
/*  662: 663 */             if (noRecordatorios == 2) {
/*  663: 663 */               controlCuidadosS.setCcui_fecenvion(new BigDecimal(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(controlCuidadosS.getCcui_fecproxapli().toString(), "yyyyMMdd", -diasAntes))));
/*  664:     */             } else {
/*  665: 664 */               controlCuidadosS.setCcui_fecenvion(BigDecimal.ZERO);
/*  666:     */             }
/*  667: 665 */             controlCuidadosS.setCcui_fecenvio2(new BigDecimal(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(controlCuidadosS.getCcui_fecproxapli().toString(), "yyyyMMdd", -2))));
/*  668: 666 */             controlCuidadosS.setCcui_quince_dias(new BigDecimal(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(controlCuidadosS.getCcui_fecproxapli().toString(), "yyyyMMdd", 15))));
/*  669:     */           }
/*  670:     */         }
/*  671: 669 */         if ((controlCuidadosS.getCcui_fecproxapli().toString().equals("0")) && (!controlCuidadosS.getCcui_fecultapli().toString().equals("0"))) {
/*  672: 671 */           if (controlCuidadosS.getCcui_cita_prox().toString().equals("0"))
/*  673:     */           {
/*  674: 672 */             String fechaParametro = controlCuidadosS.getCcui_fecultapli().toString();
/*  675:     */             
/*  676:     */ 
/*  677: 675 */             int dias = 0;
/*  678: 676 */             int dias2 = 0;
/*  679: 677 */             String fechaParametroEdad = fecnacMascota;
/*  680: 678 */             while (fechaParametroEdad.compareTo(fechaActual) < 1)
/*  681:     */             {
/*  682: 679 */               fechaParametroEdad = GestorFechasCompleto.fechaMasDias(fechaParametroEdad, "yyyyMMdd", 1);
/*  683: 680 */               dias++;
/*  684:     */             }
/*  685: 688 */             boolean siguiente = false;
/*  686: 689 */             if ((controlCuidadosS.getElementoTabla().getVcui_30().equals("1")) && (dias < 30))
/*  687:     */             {
/*  688: 690 */               if (noRecordatorios == 2) {
/*  689: 690 */                 controlCuidadosS.setCcui_fecenvion(new BigDecimal(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 30 - diasAntes))));
/*  690:     */               } else {
/*  691: 691 */                 controlCuidadosS.setCcui_fecenvion(BigDecimal.ZERO);
/*  692:     */               }
/*  693: 692 */               controlCuidadosS.setCcui_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(fecnacMascota, "yyyyMMdd", 28)));
/*  694: 693 */               controlCuidadosS.setCcui_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 45)));
/*  695: 694 */               siguiente = true;
/*  696:     */             }
/*  697: 696 */             if ((controlCuidadosS.getElementoTabla().getVcui_45().equals("1")) && (dias < 45) && (!siguiente))
/*  698:     */             {
/*  699: 697 */               if (noRecordatorios == 2) {
/*  700: 697 */                 controlCuidadosS.setCcui_fecenvion(new BigDecimal(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 45 - diasAntes))));
/*  701:     */               } else {
/*  702: 698 */                 controlCuidadosS.setCcui_fecenvion(BigDecimal.ZERO);
/*  703:     */               }
/*  704: 699 */               controlCuidadosS.setCcui_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(fecnacMascota, "yyyyMMdd", 43)));
/*  705: 700 */               controlCuidadosS.setCcui_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 60)));
/*  706: 701 */               siguiente = true;
/*  707:     */             }
/*  708: 703 */             if ((controlCuidadosS.getElementoTabla().getVcui_60().equals("1")) && (dias < 60) && (!siguiente))
/*  709:     */             {
/*  710: 704 */               if (noRecordatorios == 2) {
/*  711: 704 */                 controlCuidadosS.setCcui_fecenvion(new BigDecimal(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 60 - diasAntes))));
/*  712:     */               } else {
/*  713: 705 */                 controlCuidadosS.setCcui_fecenvion(BigDecimal.ZERO);
/*  714:     */               }
/*  715: 706 */               controlCuidadosS.setCcui_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(fecnacMascota, "yyyyMMdd", 58)));
/*  716: 707 */               controlCuidadosS.setCcui_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 75)));
/*  717: 708 */               siguiente = true;
/*  718:     */             }
/*  719: 710 */             if ((controlCuidadosS.getElementoTabla().getVcui_75().equals("1")) && (dias < 75) && (!siguiente))
/*  720:     */             {
/*  721: 711 */               if (noRecordatorios == 2) {
/*  722: 711 */                 controlCuidadosS.setCcui_fecenvion(new BigDecimal(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 75 - diasAntes))));
/*  723:     */               } else {
/*  724: 712 */                 controlCuidadosS.setCcui_fecenvion(BigDecimal.ZERO);
/*  725:     */               }
/*  726: 713 */               controlCuidadosS.setCcui_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(fecnacMascota, "yyyyMMdd", 73)));
/*  727: 714 */               controlCuidadosS.setCcui_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 90)));
/*  728: 715 */               siguiente = true;
/*  729:     */             }
/*  730: 717 */             if ((controlCuidadosS.getElementoTabla().getVcui_90().equals("1")) && (dias < 90) && (!siguiente))
/*  731:     */             {
/*  732: 718 */               if (noRecordatorios == 2) {
/*  733: 718 */                 controlCuidadosS.setCcui_fecenvion(new BigDecimal(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 90 - diasAntes))));
/*  734:     */               } else {
/*  735: 719 */                 controlCuidadosS.setCcui_fecenvion(BigDecimal.ZERO);
/*  736:     */               }
/*  737: 720 */               controlCuidadosS.setCcui_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(fecnacMascota, "yyyyMMdd", 88)));
/*  738: 721 */               controlCuidadosS.setCcui_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 105)));
/*  739: 722 */               siguiente = true;
/*  740:     */             }
/*  741: 724 */             if ((controlCuidadosS.getElementoTabla().getVcui_105().equals("1")) && (dias < 105) && (!siguiente))
/*  742:     */             {
/*  743: 725 */               if (noRecordatorios == 2) {
/*  744: 725 */                 controlCuidadosS.setCcui_fecenvion(new BigDecimal(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 105 - diasAntes))));
/*  745:     */               } else {
/*  746: 726 */                 controlCuidadosS.setCcui_fecenvion(BigDecimal.ZERO);
/*  747:     */               }
/*  748: 727 */               controlCuidadosS.setCcui_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(fecnacMascota, "yyyyMMdd", 103)));
/*  749: 728 */               controlCuidadosS.setCcui_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 120)));
/*  750: 729 */               siguiente = true;
/*  751:     */             }
/*  752: 731 */             if ((controlCuidadosS.getElementoTabla().getVcui_120().equals("1")) && (dias < 120) && (!siguiente))
/*  753:     */             {
/*  754: 732 */               if (noRecordatorios == 2) {
/*  755: 732 */                 controlCuidadosS.setCcui_fecenvion(new BigDecimal(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 120 - diasAntes))));
/*  756:     */               } else {
/*  757: 733 */                 controlCuidadosS.setCcui_fecenvion(BigDecimal.ZERO);
/*  758:     */               }
/*  759: 734 */               controlCuidadosS.setCcui_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(fecnacMascota, "yyyyMMdd", 118)));
/*  760: 735 */               controlCuidadosS.setCcui_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 135)));
/*  761: 736 */               siguiente = true;
/*  762:     */             }
/*  763: 738 */             if ((controlCuidadosS.getElementoTabla().getVcui_150().equals("1")) && (dias < 150) && (!siguiente))
/*  764:     */             {
/*  765: 739 */               if (noRecordatorios == 2) {
/*  766: 739 */                 controlCuidadosS.setCcui_fecenvion(new BigDecimal(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 150 - diasAntes))));
/*  767:     */               } else {
/*  768: 740 */                 controlCuidadosS.setCcui_fecenvion(BigDecimal.ZERO);
/*  769:     */               }
/*  770: 741 */               controlCuidadosS.setCcui_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(fecnacMascota, "yyyyMMdd", 148)));
/*  771: 742 */               controlCuidadosS.setCcui_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 165)));
/*  772: 743 */               siguiente = true;
/*  773:     */             }
/*  774: 745 */             if ((controlCuidadosS.getElementoTabla().getVcui_180().equals("1")) && (dias < 180) && (!siguiente))
/*  775:     */             {
/*  776: 746 */               if (noRecordatorios == 2) {
/*  777: 746 */                 controlCuidadosS.setCcui_fecenvion(new BigDecimal(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 180 - diasAntes))));
/*  778:     */               } else {
/*  779: 747 */                 controlCuidadosS.setCcui_fecenvion(BigDecimal.ZERO);
/*  780:     */               }
/*  781: 748 */               controlCuidadosS.setCcui_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(fecnacMascota, "yyyyMMdd", 178)));
/*  782: 749 */               controlCuidadosS.setCcui_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 195)));
/*  783: 750 */               siguiente = true;
/*  784:     */             }
/*  785: 752 */             if ((dias >= 180) && (!siguiente) && 
/*  786: 753 */               (frecuencia != 0))
/*  787:     */             {
/*  788: 754 */               fechaParametro = GestorFechasCompleto.fechaMasDias(fecnacMascota, "yyyyMMdd", 180);
/*  789: 755 */               while (fechaParametro.compareTo(fechaActual) < 1) {
/*  790: 756 */                 fechaParametro = GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", frecuencia);
/*  791:     */               }
/*  792: 758 */               if (noRecordatorios == 2) {
/*  793: 758 */                 controlCuidadosS.setCcui_fecenvion(new BigDecimal(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", -diasAntes))));
/*  794:     */               } else {
/*  795: 759 */                 controlCuidadosS.setCcui_fecenvion(BigDecimal.ZERO);
/*  796:     */               }
/*  797: 760 */               controlCuidadosS.setCcui_fecenvio2(new BigDecimal(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", -2))));
/*  798: 761 */               controlCuidadosS.setCcui_quince_dias(new BigDecimal(ManejoFechas.getChangeFecha(GestorFechasCompleto.fechaMasDias(fechaParametro, "yyyyMMdd", 15))));
/*  799:     */             }
/*  800:     */           }
/*  801:     */         }
/*  802: 768 */         controlCuidados.set(x, controlCuidadosS);
/*  803: 769 */         vacunasCuidados.set(x, vacunasCuidadosS);
/*  804: 770 */         x++;
/*  805:     */       }
/*  806: 772 */       request.getSession().setAttribute("VACUNASCUIDADOS", vacunasCuidados);
/*  807: 773 */       request.getSession().setAttribute("CONTROLCUIDADOS", controlCuidados);
/*  808: 774 */       List medicamentos = (List)request.getSession().getAttribute("MASCOTAMEDICAMENTOS");
/*  809: 775 */       List seguros = (List)request.getSession().getAttribute("SEGUROPETS");
/*  810: 776 */       List enfermedades = (List)request.getSession().getAttribute("ENFERMEDADESPETS");
/*  811: 777 */       List cirugias = (List)request.getSession().getAttribute("CIRUGIASPETS");
/*  812: 778 */       List alergias = (List)request.getSession().getAttribute("ALERGIASPETS");
/*  813: 779 */       mascotaCompleto.setMascota(mascota);
/*  814: 780 */       mascotaCompleto.setContactoMascota(contactosMascota);
/*  815: 781 */       mascotaCompleto.setMascotaAlimentacion(mascotaAlimentacion);
/*  816:     */       
/*  817: 783 */       mascotaCompleto.setTablaAjustada(vacunasCuidados);
/*  818: 784 */       mascotaCompleto.setControles(controlCuidados);
/*  819: 785 */       mascotaCompleto.setMedicamentos(medicamentos);
/*  820: 786 */       mascotaCompleto.setSeguros(seguros);
/*  821: 787 */       mascotaCompleto.setEnfermedades(enfermedades);
/*  822: 788 */       mascotaCompleto.setAlergias(alergias);
/*  823: 789 */       mascotaCompleto.setCirugias(cirugias);
/*  824: 790 */       mascotaCompleto.setPropietarioMascota(propietariosMascota);
/*  825:     */       
/*  826:     */ 
/*  827:     */ 
/*  828:     */ 
/*  829:     */ 
/*  830:     */ 
/*  831: 797 */       MascotaCompletoDAO mascotaCompletoDAO = new MascotaCompletoDAO();
/*  832: 798 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  833: 799 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  834: 800 */         mascotaCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  835:     */       }
/*  836: 802 */       mascotaCompletoDAO.update(mascotaCompleto, mascota.getMas_cod());
/*  837:     */     }
/*  838:     */     catch (Exception e)
/*  839:     */     {
/*  840: 806 */       e.printStackTrace();
/*  841: 807 */       return mapping.findForward("failure");
/*  842:     */     }
/*  843: 810 */     return mapping.findForward("success");
/*  844:     */   }
/*  845:     */   
/*  846:     */   private ActionForward performAdd(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  847:     */   {
/*  848: 823 */     MascotaCompletoForm form = (MascotaCompletoForm)actionForm;
/*  849:     */     try
/*  850:     */     {
/*  851: 826 */       if (request.getParameter("recargar") == null)
/*  852:     */       {
/*  853: 827 */         BorrarSession.eliminaAtributos(request.getSession(), "");
/*  854: 828 */         saveToken(request);
/*  855:     */       }
/*  856: 831 */       form.setMas_fecnac(ManejoFechas.FormateoFecha(form.getMas_fecnac()));
/*  857:     */       
/*  858: 833 */       PaisDAO paisDAO = new PaisDAO();
/*  859: 834 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  860: 835 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  861: 836 */         paisDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  862:     */       }
/*  863: 838 */       paisDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  864: 839 */       List paises = paisDAO.list();
/*  865: 840 */       request.setAttribute("PAISES", paises);
/*  866:     */       
/*  867: 842 */       List seguros = new ArrayList();
/*  868: 843 */       if (request.getSession().getAttribute("SEGUROSPETS") != null) {
/*  869: 844 */         seguros = (List)request.getSession().getAttribute("SEGUROSPETS");
/*  870:     */       }
/*  871: 845 */       request.getSession().setAttribute("SEGUROSPETS", seguros);
/*  872:     */       
/*  873: 847 */       List ciudadesProp = null;
/*  874: 848 */       CiudadDAO ciudadesDAO = new CiudadDAO();
/*  875: 849 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  876: 850 */         ciudadesDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  877:     */       }
/*  878: 852 */       ciudadesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  879: 853 */       if (paises.size() > 0) {
/*  880: 854 */         if (!form.getPmas_pais_cod().equals("0")) {
/*  881: 855 */           ciudadesProp = ciudadesDAO.search(form.getPmas_pais_cod());
/*  882:     */         } else {
/*  883: 857 */           ciudadesProp = ciudadesDAO.search(((Paises)paises.get(0)).getPais_cod().toString());
/*  884:     */         }
/*  885:     */       }
/*  886: 861 */       request.setAttribute("CIUDADESPROP", ciudadesProp);
/*  887:     */       
/*  888: 863 */       List razas = new ArrayList();
/*  889: 864 */       RazasDAO razasDAO = new RazasDAO();
/*  890: 865 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  891: 866 */         razasDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  892:     */       }
/*  893: 868 */       razasDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  894: 869 */       if (!form.getMas_tipo().equals("")) {
/*  895: 870 */         razas = razasDAO.list(new BigDecimal(form.getMas_tipo()));
/*  896:     */       }
/*  897: 872 */       request.setAttribute("RAZAS", razas);
/*  898:     */     }
/*  899:     */     catch (Exception e)
/*  900:     */     {
/*  901: 875 */       e.printStackTrace();
/*  902: 876 */       return mapping.findForward("failure");
/*  903:     */     }
/*  904: 879 */     return mapping.findForward("success");
/*  905:     */   }
/*  906:     */   
/*  907:     */   private ActionForward performLoad(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  908:     */   {
/*  909: 892 */     MascotaCompletoForm form = (MascotaCompletoForm)actionForm;
/*  910:     */     try
/*  911:     */     {
/*  912: 895 */       Mascota mascota = (Mascota)request.getSession().getAttribute("mascota");
/*  913:     */       
/*  914: 897 */       form.setMas_fecnac(ManejoFechas.FormateoFecha(form.getMas_fecnac()));
/*  915: 898 */       form.setMas_fecinscripcion(ManejoFechas.FormateoFecha(form.getMas_fecinscripcion()));
/*  916: 899 */       form.setMali_fecultpeso(ManejoFechas.FormateoFecha(form.getMali_fecultpeso()));
/*  917: 900 */       form.setCmas_fecnacim(ManejoFechas.getChangeFecha(form.getCmas_fecnacim()));
/*  918:     */       
/*  919: 902 */       PaisDAO paisDAO = new PaisDAO();
/*  920: 903 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  921: 904 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  922: 905 */         paisDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  923:     */       }
/*  924: 907 */       paisDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  925: 908 */       List paises = paisDAO.list();
/*  926: 909 */       request.setAttribute("PAISES", paises);
/*  927:     */       
/*  928: 911 */       List ciudadesProp = new ArrayList();
/*  929: 912 */       List ciudadesCont1 = new ArrayList();
/*  930: 913 */       CiudadDAO ciudadesDAO = new CiudadDAO();
/*  931: 914 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  932: 915 */         ciudadesDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  933:     */       }
/*  934: 917 */       ciudadesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  935: 918 */       if (paises.size() > 0)
/*  936:     */       {
/*  937: 919 */         if ((!form.getPmas_pais_cod().equals("")) && (!form.getPmas_pais_cod().equals("0"))) {
/*  938: 920 */           ciudadesProp = ciudadesDAO.search(form.getPmas_pais_cod());
/*  939:     */         } else {
/*  940: 922 */           ciudadesProp = ciudadesDAO.search(((Paises)paises.get(0)).getPais_cod().toString());
/*  941:     */         }
/*  942: 925 */         if ((!form.getCmas_pais_cod().equals("")) && (!form.getCmas_pais_cod().equals("0"))) {
/*  943: 926 */           ciudadesCont1 = ciudadesDAO.search(form.getCmas_pais_cod());
/*  944:     */         } else {
/*  945: 928 */           ciudadesCont1 = ciudadesDAO.search(((Paises)paises.get(0)).getPais_cod().toString());
/*  946:     */         }
/*  947:     */       }
/*  948: 932 */       request.setAttribute("CIUDADESPROP", ciudadesProp);
/*  949: 933 */       request.setAttribute("CIUDADESCONT1", ciudadesCont1);
/*  950:     */       
/*  951: 935 */       List vacunasCuidados = (List)request.getSession().getAttribute("VACUNASCUIDADOS");
/*  952: 936 */       List controlCuidadosUniversales = (List)request.getSession().getAttribute("VACUNASCUIDADOSUNIVERSALES");
/*  953:     */       
/*  954: 938 */       int x = 0;
/*  955: 940 */       if (request.getParameter("load") != null) {
/*  956: 941 */         while (x < vacunasCuidados.size())
/*  957:     */         {
/*  958: 942 */           VacunasCuidados vacunasCuidadosS = (VacunasCuidados)vacunasCuidados.get(x);
/*  959: 944 */           if (request.getParameter("check030" + x) != null) {
/*  960: 945 */             vacunasCuidadosS.setVcui_30("1");
/*  961:     */           } else {
/*  962: 947 */             vacunasCuidadosS.setVcui_30("0");
/*  963:     */           }
/*  964: 948 */           if (request.getParameter("check045" + x) != null) {
/*  965: 949 */             vacunasCuidadosS.setVcui_45("1");
/*  966:     */           } else {
/*  967: 951 */             vacunasCuidadosS.setVcui_45("0");
/*  968:     */           }
/*  969: 952 */           if (request.getParameter("check060" + x) != null) {
/*  970: 953 */             vacunasCuidadosS.setVcui_60("1");
/*  971:     */           } else {
/*  972: 955 */             vacunasCuidadosS.setVcui_60("0");
/*  973:     */           }
/*  974: 956 */           if (request.getParameter("check075" + x) != null) {
/*  975: 957 */             vacunasCuidadosS.setVcui_75("1");
/*  976:     */           } else {
/*  977: 959 */             vacunasCuidadosS.setVcui_75("0");
/*  978:     */           }
/*  979: 960 */           if (request.getParameter("check090" + x) != null) {
/*  980: 961 */             vacunasCuidadosS.setVcui_90("1");
/*  981:     */           } else {
/*  982: 963 */             vacunasCuidadosS.setVcui_90("0");
/*  983:     */           }
/*  984: 964 */           if (request.getParameter("check105" + x) != null) {
/*  985: 965 */             vacunasCuidadosS.setVcui_105("1");
/*  986:     */           } else {
/*  987: 967 */             vacunasCuidadosS.setVcui_105("0");
/*  988:     */           }
/*  989: 968 */           if (request.getParameter("check120" + x) != null) {
/*  990: 969 */             vacunasCuidadosS.setVcui_120("1");
/*  991:     */           } else {
/*  992: 971 */             vacunasCuidadosS.setVcui_120("0");
/*  993:     */           }
/*  994: 972 */           if (request.getParameter("check150" + x) != null) {
/*  995: 973 */             vacunasCuidadosS.setVcui_150("1");
/*  996:     */           } else {
/*  997: 975 */             vacunasCuidadosS.setVcui_150("0");
/*  998:     */           }
/*  999: 976 */           if (request.getParameter("check180" + x) != null) {
/* 1000: 977 */             vacunasCuidadosS.setVcui_180("1");
/* 1001:     */           } else {
/* 1002: 979 */             vacunasCuidadosS.setVcui_180("0");
/* 1003:     */           }
/* 1004: 981 */           vacunasCuidadosS.setVcui_control(new BigDecimal(request.getParameter("control" + x).toString()));
/* 1005:     */           
/* 1006: 983 */           vacunasCuidados.set(x, vacunasCuidadosS);
/* 1007:     */           
/* 1008: 985 */           x++;
/* 1009:     */         }
/* 1010:     */       }
/* 1011: 989 */       request.getSession().setAttribute("VACUNASCUIDADOS", vacunasCuidados);
/* 1012:     */       
/* 1013: 991 */       List razas = new ArrayList();
/* 1014: 992 */       RazasDAO razasDAO = new RazasDAO();
/* 1015: 993 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1016: 994 */         razasDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1017:     */       }
/* 1018: 996 */       razasDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 1019: 997 */       if (!form.getMas_tipo().equals("")) {
/* 1020: 998 */         razas = razasDAO.list(new BigDecimal(form.getMas_tipo()));
/* 1021:     */       }
/* 1022:1000 */       request.setAttribute("RAZAS", razas);
/* 1023:     */       
/* 1024:1002 */       List controlCuidados = (List)request.getSession().getAttribute("CONTROLCUIDADOS");
/* 1025:1003 */       x = 0;
/* 1026:1004 */       if (request.getParameter("control[0].ccui_grup_cod") != null)
/* 1027:     */       {
/* 1028:1005 */         while (x < controlCuidados.size())
/* 1029:     */         {
/* 1030:1006 */           ControlCuidados controlCuidado = (ControlCuidados)controlCuidados.get(x);
/* 1031:1007 */           controlCuidado.setCcui_grup_cod(new BigDecimal(request.getParameter("control[" + x + "].ccui_grup_cod")));
/* 1032:1008 */           x++;
/* 1033:     */         }
/* 1034:1011 */         List grupos = (List)request.getSession().getAttribute("GRUPOSMASCOTA");
/* 1035:1012 */         x = 0;
/* 1036:1013 */         while (x < grupos.size())
/* 1037:     */         {
/* 1038:1014 */           GruposMascota grupoMascota = (GruposMascota)grupos.get(x);
/* 1039:1015 */           grupoMascota.setGrupm_dias_antes(new BigDecimal(request.getParameter("grupo[" + x + "].grupm_dias_antes")));
/* 1040:1016 */           x++;
/* 1041:     */         }
/* 1042:     */       }
/* 1043:1020 */       List gruposMascota = (List)request.getSession().getAttribute("GRUPOSMASCOTA");
/* 1044:1021 */       GruposDAO gruposDAO = new GruposDAO();
/* 1045:1022 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1046:1023 */         gruposDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1047:     */       }
/* 1048:1025 */       gruposDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 1049:1026 */       List gruposLabels = new ArrayList();
/* 1050:1027 */       int i = 0;
/* 1051:1028 */       while (i < gruposMascota.size())
/* 1052:     */       {
/* 1053:1029 */         Grupos grupo = gruposDAO.retrive(((GruposMascota)gruposMascota.get(i)).getGrupm_grup_cod());
/* 1054:1030 */         gruposLabels.add(grupo);
/* 1055:1031 */         request.setAttribute("grupm_desc" + i, grupo.getGrup_desc());
/* 1056:1032 */         i++;
/* 1057:     */       }
/* 1058:1035 */       request.getSession().setAttribute("GRUPOSMEDICINA", gruposMascota);
/* 1059:1036 */       request.setAttribute("GRUPOS", gruposLabels);
/* 1060:     */       
/* 1061:1038 */       IdiomaDAO idiomaDAO = new IdiomaDAO();
/* 1062:1039 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1063:1040 */         idiomaDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1064:     */       }
/* 1065:1042 */       request.setAttribute("IDIOMAS", idiomaDAO.list());
/* 1066:     */     }
/* 1067:     */     catch (Exception e)
/* 1068:     */     {
/* 1069:1045 */       e.printStackTrace();
/* 1070:1046 */       return mapping.findForward("failure");
/* 1071:     */     }
/* 1072:1049 */     if (request.getParameter("redirect") != null) {
/* 1073:1050 */       return new ActionForward(request.getParameter("redirect"));
/* 1074:     */     }
/* 1075:1052 */     return mapping.findForward("success");
/* 1076:     */   }
/* 1077:     */   
/* 1078:     */   private ActionForward performRemove(String myaction, ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 1079:     */   {
/* 1080:     */     try
/* 1081:     */     {
/* 1082:1067 */       MascotaCompletoDAO mascotaCompletoDAO = new MascotaCompletoDAO();
/* 1083:1068 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 1084:1069 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1085:1070 */         mascotaCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1086:     */       }
/* 1087:1072 */       mascotaCompletoDAO.delete(new BigDecimal(request.getParameter("mas_cod")));
/* 1088:     */     }
/* 1089:     */     catch (Exception e)
/* 1090:     */     {
/* 1091:1075 */       e.printStackTrace();
/* 1092:1076 */       return mapping.findForward("failure");
/* 1093:     */     }
/* 1094:1079 */     return mapping.findForward("success");
/* 1095:     */   }
/* 1096:     */   
/* 1097:     */   private ActionForward performList(String myaction, ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 1098:     */   {
/* 1099:1092 */     MascotaCompletoForm form = (MascotaCompletoForm)actionForm;
/* 1100:     */     try
/* 1101:     */     {
/* 1102:1095 */       MascotaDAO mascotaDAO = new MascotaDAO();
/* 1103:1096 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 1104:1097 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1105:1098 */         mascotaDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1106:     */       }
/* 1107:1100 */       UsuarioPets usuarioPets = (UsuarioPets)request.getSession().getAttribute("usuarioPets");
/* 1108:     */       
/* 1109:1102 */       List mascotas = mascotaDAO.list(usuarioPets.getUsup_cod());
/* 1110:1103 */       request.setAttribute("MASCOTAS", mascotas);
/* 1111:     */     }
/* 1112:     */     catch (Exception e)
/* 1113:     */     {
/* 1114:1106 */       e.printStackTrace();
/* 1115:1107 */       return mapping.findForward("failure");
/* 1116:     */     }
/* 1117:1110 */     return mapping.findForward("success");
/* 1118:     */   }
/* 1119:     */   
/* 1120:     */   private ActionForward performReports(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 1121:     */   {
/* 1122:1123 */     String infobasica = null;
/* 1123:1124 */     String contalipes = null;
/* 1124:1125 */     String contvacuna = null;
/* 1125:1126 */     String contactmas = null;
/* 1126:1127 */     String medicammas = null;
/* 1127:     */     
/* 1128:1129 */     ResourceBundle res = ResourceBundle.getBundle("com.servidoctor.resources.ApplicationResources");
/* 1129:1130 */     UsuarioPets usuarioPets = (UsuarioPets)request.getSession().getAttribute("usuarioPets");
/* 1130:     */     try
/* 1131:     */     {
/* 1132:1133 */       GestorHojasCalculoPets.generarArchivo();
/* 1133:1135 */       if (request.getParameter("infobasica") != null)
/* 1134:     */       {
/* 1135:1136 */         infobasica = request.getParameter("infobasica");
/* 1136:1137 */         GestorHojasCalculoPets.generarHoja(infobasica, usuarioPets, res);
/* 1137:1138 */         Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 1138:1139 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1139:1140 */           GestorHojasCalculoPets.generarDatosInfobasica(infobasica, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), servidor.getServ_cod().intValue());
/* 1140:     */         } else {
/* 1141:1142 */           GestorHojasCalculoPets.generarDatosInfobasica(infobasica, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), 0);
/* 1142:     */         }
/* 1143:     */       }
/* 1144:1146 */       if (request.getParameter("contalipes") != null)
/* 1145:     */       {
/* 1146:1147 */         contalipes = request.getParameter("contalipes");
/* 1147:1148 */         GestorHojasCalculoPets.generarHoja(contalipes, usuarioPets, res);
/* 1148:1149 */         Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 1149:1150 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1150:1151 */           GestorHojasCalculoPets.generarDatosContalipes(contalipes, servidor.getServ_cod().intValue());
/* 1151:     */         } else {
/* 1152:1153 */           GestorHojasCalculoPets.generarDatosContalipes(contalipes, 0);
/* 1153:     */         }
/* 1154:     */       }
/* 1155:1157 */       if (request.getParameter("contvacuna") != null)
/* 1156:     */       {
/* 1157:1158 */         contvacuna = request.getParameter("contvacuna");
/* 1158:1159 */         GestorHojasCalculoPets.generarHoja(contvacuna, usuarioPets, res);
/* 1159:1160 */         Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 1160:1161 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1161:1162 */           GestorHojasCalculoPets.generarDatosContvacuna(contvacuna, servidor.getServ_cod().intValue());
/* 1162:     */         } else {
/* 1163:1164 */           GestorHojasCalculoPets.generarDatosContvacuna(contvacuna, 0);
/* 1164:     */         }
/* 1165:     */       }
/* 1166:1168 */       if (request.getParameter("contactmas") != null)
/* 1167:     */       {
/* 1168:1169 */         contactmas = request.getParameter("contactmas");
/* 1169:1170 */         GestorHojasCalculoPets.generarHoja(contactmas, usuarioPets, res);
/* 1170:1171 */         Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 1171:1172 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1172:1173 */           GestorHojasCalculoPets.generarDatosContactmas(contactmas, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), servidor.getServ_cod().intValue());
/* 1173:     */         } else {
/* 1174:1175 */           GestorHojasCalculoPets.generarDatosContactmas(contactmas, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), 0);
/* 1175:     */         }
/* 1176:     */       }
/* 1177:1180 */       if (request.getParameter("medicammas") != null)
/* 1178:     */       {
/* 1179:1181 */         medicammas = request.getParameter("medicammas");
/* 1180:1182 */         GestorHojasCalculoPets.generarHoja(medicammas, usuarioPets, res);
/* 1181:1183 */         Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 1182:1184 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1183:1185 */           GestorHojasCalculoPets.generarDatosMedicammas(medicammas, servidor.getServ_cod().intValue());
/* 1184:     */         } else {
/* 1185:1187 */           GestorHojasCalculoPets.generarDatosMedicammas(medicammas, 0);
/* 1186:     */         }
/* 1187:     */       }
/* 1188:1191 */       response.setContentType("application/vnd.ms-excel");
/* 1189:1192 */       OutputStream out = response.getOutputStream();
/* 1190:1194 */       if (GestorHojasCalculoPets.getWb() != null)
/* 1191:     */       {
/* 1192:1195 */         GestorHojasCalculoPets.getWb().write(out);
/* 1193:1196 */         out.close();
/* 1194:1197 */         return null;
/* 1195:     */       }
/* 1196:1200 */       request.setAttribute("CONFIRM", res.getString("2294"));
/* 1197:1201 */       return mapping.findForward("success");
/* 1198:     */     }
/* 1199:     */     catch (Exception e)
/* 1200:     */     {
/* 1201:1206 */       request.setAttribute("FAILURE", e.getMessage());
/* 1202:     */     }
/* 1203:1207 */     return mapping.findForward("failure");
/* 1204:     */   }
/* 1205:     */   
/* 1206:     */   private ActionForward performMPerros(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 1207:     */   {
/* 1208:1220 */     return mapping.findForward("success");
/* 1209:     */   }
/* 1210:     */   
/* 1211:     */   private ActionForward performMGatos(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 1212:     */   {
/* 1213:1231 */     return mapping.findForward("success");
/* 1214:     */   }
/* 1215:     */   
/* 1216:     */   private ActionForward performAspectos(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 1217:     */   {
/* 1218:1241 */     return mapping.findForward("success");
/* 1219:     */   }
/* 1220:     */ }



/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\

 * Qualified Name:     com.servidoctor.sdpets.controller.MascotaAction

 * JD-Core Version:    0.7.0.1

 */