/*    1:     */ package com.servidoctor.sdcars.controller;
/*    2:     */ 
/*    3:     */ import com.servidoctor.common.controller.BaseAction;
/*    4:     */ import com.servidoctor.constantes.IConstantes;
/*    5:     */ import com.servidoctor.constantes.IGrupos;
/*    6:     */ import com.servidoctor.parametros.dao.CiudadDAO;
/*    7:     */ import com.servidoctor.parametros.dao.GastosAnualesDAO;
/*    8:     */ import com.servidoctor.parametros.dao.GastosMecanicaDAO;
/*    9:     */ import com.servidoctor.parametros.dao.GastosNoAnualesDAO;
/*   10:     */ import com.servidoctor.parametros.dao.GastosVehiculosAnualesDAO;
/*   11:     */ import com.servidoctor.parametros.dao.GastosVehiculosMecanicaDAO;
/*   12:     */ import com.servidoctor.parametros.dao.GastosVehiculosNoAnualesDAO;
/*   13:     */ import com.servidoctor.parametros.dao.GruposDAO;
/*   14:     */ import com.servidoctor.parametros.dao.IdiomaDAO;
/*   15:     */ import com.servidoctor.parametros.dao.MarcasAutosDAO;
/*   16:     */ import com.servidoctor.parametros.dao.PaisDAO;
/*   17:     */ import com.servidoctor.parametros.dao.RevisionAccionDAO;
/*   18:     */ import com.servidoctor.parametros.dao.RevisionAlternativaDAO;
/*   19:     */ import com.servidoctor.parametros.dao.RevisionesDAO;
/*   20:     */ import com.servidoctor.parametros.dao.RevisionesVehiculoDAO;
/*   21:     */ import com.servidoctor.parametros.dao.TipoVehiculoDAO;
/*   22:     */ import com.servidoctor.parametros.model.GastosAnuales;
/*   23:     */ import com.servidoctor.parametros.model.GastosMecanica;
/*   24:     */ import com.servidoctor.parametros.model.GastosNoAnuales;
/*   25:     */ import com.servidoctor.parametros.model.GastosVehiculosAnuales;
/*   26:     */ import com.servidoctor.parametros.model.GastosVehiculosMecanica;
/*   27:     */ import com.servidoctor.parametros.model.GastosVehiculosNoAnuales;
/*   28:     */ import com.servidoctor.parametros.model.Grupos;
/*   29:     */ import com.servidoctor.parametros.model.MarcasAutos;
/*   30:     */ import com.servidoctor.parametros.model.Paises;
/*   31:     */ import com.servidoctor.parametros.model.RevisionAccion;
/*   32:     */ import com.servidoctor.parametros.model.RevisionAlternativa;
/*   33:     */ import com.servidoctor.parametros.model.Revisiones;
/*   34:     */ import com.servidoctor.parametros.model.RevisionesVehiculo;
/*   35:     */ import com.servidoctor.parametros.model.TipoVehiculo;
/*   36:     */ import com.servidoctor.sdcars.dao.CombustibleDAO;
/*   37:     */ import com.servidoctor.sdcars.dao.ControlesVehiculosDAO;
/*   38:     */ import com.servidoctor.sdcars.dao.GestorHojasCalculoCars;
/*   39:     */ import com.servidoctor.sdcars.dao.GruposVehiculoDAO;
/*   40:     */ import com.servidoctor.sdcars.dao.ImpuestoVehiculoDAO;
/*   41:     */ import com.servidoctor.sdcars.dao.MantenimientoGeneralDAO;
/*   42:     */ import com.servidoctor.sdcars.dao.SegurosVehiculosDAO;
/*   43:     */ import com.servidoctor.sdcars.dao.VehiculosCompletoDAO;
/*   44:     */ import com.servidoctor.sdcars.dao.VehiculosDAO;
/*   45:     */ import com.servidoctor.sdcars.model.Combustible;
/*   46:     */ import com.servidoctor.sdcars.model.GruposVehiculo;
/*   47:     */ import com.servidoctor.sdcars.model.MantenimientoGeneral;
/*   48:     */ import com.servidoctor.sdcars.model.PropietariosVehiculos;
/*   49:     */ import com.servidoctor.sdcars.model.Vehiculos;
/*   50:     */ import com.servidoctor.sdcars.model.VehiculosCompleto;
/*   51:     */ import com.servidoctor.seguridad.model.Servidores;
/*   52:     */ import com.servidoctor.seguridad.model.UsuarioCar;
/*   53:     */ import com.servidoctor.util.classes.BorrarSession;
/*   54:     */ import com.servidoctor.util.classes.InicializaData;
/*   55:     */ import com.servidoctor.util.classes.ManejoFechas;
/*   56:     */ import java.io.OutputStream;
/*   57:     */ import java.math.BigDecimal;
/*   58:     */ import java.text.SimpleDateFormat;
/*   59:     */ import java.util.ArrayList;
/*   60:     */ import java.util.Calendar;
/*   61:     */ import java.util.Date;
/*   62:     */ import java.util.GregorianCalendar;
/*   63:     */ import java.util.Iterator;
/*   64:     */ import java.util.List;
/*   65:     */ import java.util.ResourceBundle;
/*   66:     */ import javax.servlet.http.HttpServletRequest;
/*   67:     */ import javax.servlet.http.HttpServletResponse;
/*   68:     */ import javax.servlet.http.HttpSession;
/*   69:     */ import org.apache.commons.beanutils.BeanUtils;
/*   70:     */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*   71:     */ import org.apache.struts.action.ActionForm;
/*   72:     */ import org.apache.struts.action.ActionForward;
/*   73:     */ import org.apache.struts.action.ActionMapping;
/*   74:     */ 
/*   75:     */ public class VehiculosAction
/*   76:     */   extends BaseAction
/*   77:     */ {
/*   78:     */   public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*   79:     */     throws Exception
/*   80:     */   {
/*   81:  82 */     ActionForward myforward = super.execute(mapping, actionForm, request, response);
/*   82:  83 */     String myaction = mapping.getParameter();
/*   83:  85 */     if (myforward == null) {
/*   84:  86 */       if ("".equalsIgnoreCase(myaction)) {
/*   85:  87 */         myforward = mapping.findForward("failure");
/*   86:  88 */       } else if ("LOAD".equalsIgnoreCase(myaction)) {
/*   87:  89 */         myforward = performLoad(mapping, actionForm, request, response);
/*   88:  90 */       } else if ("EDIT".equalsIgnoreCase(myaction)) {
/*   89:  91 */         myforward = performEdit(mapping, actionForm, request, response);
/*   90:  92 */       } else if ("ADD".equalsIgnoreCase(myaction)) {
/*   91:  93 */         myforward = performAdd(mapping, actionForm, request, response);
/*   92:  94 */       } else if ("SEARCH".equalsIgnoreCase(myaction)) {
/*   93:  95 */         myforward = performList(myaction, mapping, actionForm, request, response);
/*   94:  96 */       } else if ("LIST".equalsIgnoreCase(myaction)) {
/*   95:  97 */         myforward = performList(myaction, mapping, actionForm, request, response);
/*   96:  98 */       } else if ("REMOVE".equalsIgnoreCase(myaction)) {
/*   97:  99 */         myforward = performRemove(myaction, mapping, actionForm, request, response);
/*   98: 100 */       } else if ("SAVE".equalsIgnoreCase(myaction)) {
/*   99: 101 */         myforward = performSave(mapping, actionForm, request, response);
/*  100: 102 */       } else if ("SAVEFIRST".equalsIgnoreCase(myaction)) {
/*  101: 103 */         myforward = performSaveFirst(mapping, actionForm, request, response);
/*  102: 104 */       } else if ("SAVEEDIT".equalsIgnoreCase(myaction)) {
/*  103: 105 */         myforward = performSaveEdit(mapping, actionForm, request, response);
/*  104: 106 */       } else if ("REPORT".equalsIgnoreCase(myaction)) {
/*  105: 107 */         myforward = performReports(mapping, actionForm, request, response);
/*  106: 108 */       } else if ("CURVA".equalsIgnoreCase(myaction)) {
/*  107: 109 */         myforward = performCurva(mapping, actionForm, request, response);
/*  108: 110 */       } else if ("SAVECURVA".equalsIgnoreCase(myaction)) {
/*  109: 111 */         myforward = performSaveCurva(mapping, actionForm, request, response);
/*  110: 112 */       } else if ("ASPECTOS".equalsIgnoreCase(myaction)) {
/*  111: 113 */         myforward = performAspectos(mapping, actionForm, request, response);
/*  112: 114 */       } else if ("ODOMETRO".equalsIgnoreCase(myaction)) {
/*  113: 115 */         myforward = performOdometro(mapping, actionForm, request, response);
/*  114: 116 */       } else if ("DELLIST".equalsIgnoreCase(myaction)) {
/*  115: 117 */         myforward = performDelList(mapping, actionForm, request, response);
/*  116: 118 */       } else if ("CANCELAR".equalsIgnoreCase(myaction)) {
/*  117: 119 */         myforward = performCancelar(mapping, actionForm, request, response);
/*  118: 120 */       } else if ("SAVEODOMETRO".equalsIgnoreCase(myaction)) {
/*  119: 121 */         myforward = performSaveOdometro(mapping, actionForm, request, response);
/*  120: 122 */       } else if ("EDITCONTROLES".equalsIgnoreCase(myaction)) {
/*  121: 123 */         myforward = performEditControles(mapping, actionForm, request, response);
/*  122: 124 */       } else if ("LOADCONTROLES".equalsIgnoreCase(myaction)) {
/*  123: 125 */         myforward = performLoadControles(mapping, actionForm, request, response);
/*  124: 126 */       } else if ("SAVEEDITCONTROL".equalsIgnoreCase(myaction)) {
/*  125: 127 */         myforward = performSaveEditControl(mapping, actionForm, request, response);
/*  126:     */       } else {
/*  127: 129 */         myforward = mapping.findForward("failure");
/*  128:     */       }
/*  129:     */     }
/*  130: 132 */     return myforward;
/*  131:     */   }
/*  132:     */   
/*  133:     */   private ActionForward performReports(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  134:     */   {
/*  135: 143 */     String infobasica = null;
/*  136: 144 */     String manAct = null;
/*  137: 145 */     String manUlt = null;
/*  138: 146 */     String contLey = null;
/*  139: 147 */     String seguros = null;
/*  140: 148 */     String gastosMec = null;
/*  141: 149 */     String gastosAnuales = null;
/*  142: 150 */     String gastosNoAnuales = null;
/*  143: 151 */     String impuestos = null;
/*  144: 152 */     String combustible = null;
/*  145:     */     
/*  146: 154 */     ResourceBundle res = ResourceBundle.getBundle("com.servidoctor.resources.ApplicationResources");
/*  147: 155 */     UsuarioCar usuarioCar = (UsuarioCar)request.getSession().getAttribute("usuarioCar");
/*  148:     */     try
/*  149:     */     {
/*  150: 158 */       if (request.getParameter("infobasica") != null)
/*  151:     */       {
/*  152: 159 */         infobasica = request.getParameter("infobasica");
/*  153: 160 */         GestorHojasCalculoCars.generarHoja(infobasica, usuarioCar, res);
/*  154: 161 */         Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  155: 162 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  156: 163 */           GestorHojasCalculoCars.generarDatosInfobasica(infobasica, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), servidor.getServ_cod().intValue());
/*  157:     */         } else {
/*  158: 165 */           GestorHojasCalculoCars.generarDatosInfobasica(infobasica, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), 0);
/*  159:     */         }
/*  160:     */       }
/*  161: 169 */       if (request.getParameter("manAct") != null)
/*  162:     */       {
/*  163: 170 */         manAct = request.getParameter("manAct");
/*  164: 171 */         GestorHojasCalculoCars.generarHoja(manAct, usuarioCar, res);
/*  165: 172 */         Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  166: 173 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  167: 174 */           GestorHojasCalculoCars.generarDatosMantenimientoActividades(manAct, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), servidor.getServ_cod().intValue());
/*  168:     */         } else {
/*  169: 176 */           GestorHojasCalculoCars.generarDatosMantenimientoActividades(manAct, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), 0);
/*  170:     */         }
/*  171:     */       }
/*  172: 180 */       if (request.getParameter("manUlt") != null)
/*  173:     */       {
/*  174: 181 */         manUlt = request.getParameter("manUlt");
/*  175: 182 */         GestorHojasCalculoCars.generarHoja(manUlt, usuarioCar, res);
/*  176: 183 */         Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  177: 184 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  178: 185 */           GestorHojasCalculoCars.generarDatosMantenimientoUltimo(manUlt, servidor.getServ_cod().intValue());
/*  179:     */         } else {
/*  180: 187 */           GestorHojasCalculoCars.generarDatosMantenimientoUltimo(manUlt, 0);
/*  181:     */         }
/*  182:     */       }
/*  183: 191 */       if (request.getParameter("contLey") != null)
/*  184:     */       {
/*  185: 192 */         contLey = request.getParameter("contLey");
/*  186: 193 */         GestorHojasCalculoCars.generarHoja(contLey, usuarioCar, res);
/*  187: 194 */         Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  188: 195 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  189: 196 */           GestorHojasCalculoCars.generarDatosControlesLey(contLey, servidor.getServ_cod().intValue());
/*  190:     */         } else {
/*  191: 198 */           GestorHojasCalculoCars.generarDatosControlesLey(contLey, 0);
/*  192:     */         }
/*  193:     */       }
/*  194: 202 */       if (request.getParameter("seguros") != null)
/*  195:     */       {
/*  196: 203 */         seguros = request.getParameter("seguros");
/*  197: 204 */         GestorHojasCalculoCars.generarHoja(seguros, usuarioCar, res);
/*  198: 205 */         Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  199: 206 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  200: 207 */           GestorHojasCalculoCars.generarDatosSeguros(seguros, servidor.getServ_cod().intValue());
/*  201:     */         } else {
/*  202: 209 */           GestorHojasCalculoCars.generarDatosSeguros(seguros, 0);
/*  203:     */         }
/*  204:     */       }
/*  205: 213 */       if (request.getParameter("gastosMec") != null)
/*  206:     */       {
/*  207: 214 */         gastosMec = request.getParameter("gastosMec");
/*  208: 215 */         GestorHojasCalculoCars.generarHoja(gastosMec, usuarioCar, res);
/*  209: 216 */         Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  210: 217 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  211: 218 */           GestorHojasCalculoCars.generarDatosGastosMecanica(gastosMec, servidor.getServ_cod().intValue());
/*  212:     */         } else {
/*  213: 220 */           GestorHojasCalculoCars.generarDatosGastosMecanica(gastosMec, 0);
/*  214:     */         }
/*  215:     */       }
/*  216: 224 */       if (request.getParameter("gastosAnuales") != null)
/*  217:     */       {
/*  218: 225 */         gastosAnuales = request.getParameter("gastosAnuales");
/*  219: 226 */         GestorHojasCalculoCars.generarHoja(gastosAnuales, usuarioCar, res);
/*  220: 227 */         Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  221: 228 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  222: 229 */           GestorHojasCalculoCars.generarDatosGastosAnuales(gastosAnuales, servidor.getServ_cod().intValue());
/*  223:     */         } else {
/*  224: 231 */           GestorHojasCalculoCars.generarDatosGastosAnuales(gastosAnuales, 0);
/*  225:     */         }
/*  226:     */       }
/*  227: 235 */       if (request.getParameter("gastosNoAnuales") != null)
/*  228:     */       {
/*  229: 236 */         gastosNoAnuales = request.getParameter("gastosNoAnuales");
/*  230: 237 */         GestorHojasCalculoCars.generarHoja(gastosNoAnuales, usuarioCar, res);
/*  231: 238 */         Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  232: 239 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  233: 240 */           GestorHojasCalculoCars.generarDatosGastosNoAnuales(gastosNoAnuales, servidor.getServ_cod().intValue());
/*  234:     */         } else {
/*  235: 242 */           GestorHojasCalculoCars.generarDatosGastosNoAnuales(gastosNoAnuales, 0);
/*  236:     */         }
/*  237:     */       }
/*  238: 246 */       if (request.getParameter("impuestos") != null)
/*  239:     */       {
/*  240: 247 */         impuestos = request.getParameter("impuestos");
/*  241: 248 */         GestorHojasCalculoCars.generarHoja(impuestos, usuarioCar, res);
/*  242: 249 */         Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  243: 250 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  244: 251 */           GestorHojasCalculoCars.generarDatosImpuestos(impuestos, servidor.getServ_cod().intValue());
/*  245:     */         } else {
/*  246: 253 */           GestorHojasCalculoCars.generarDatosImpuestos(impuestos, 0);
/*  247:     */         }
/*  248:     */       }
/*  249: 257 */       if (request.getParameter("combustible") != null)
/*  250:     */       {
/*  251: 258 */         combustible = request.getParameter("combustible");
/*  252: 259 */         GestorHojasCalculoCars.generarHoja(combustible, usuarioCar, res);
/*  253: 260 */         Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  254: 261 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  255: 262 */           GestorHojasCalculoCars.generarDatosCombustible(combustible, servidor.getServ_cod().intValue());
/*  256:     */         } else {
/*  257: 264 */           GestorHojasCalculoCars.generarDatosCombustible(combustible, 0);
/*  258:     */         }
/*  259:     */       }
/*  260: 268 */       response.setContentType("application/vnd.ms-excel");
/*  261: 269 */       OutputStream out = response.getOutputStream();
/*  262: 271 */       if (GestorHojasCalculoCars.getWb() != null)
/*  263:     */       {
/*  264: 272 */         GestorHojasCalculoCars.getWb().write(out);
/*  265: 273 */         out.close();
/*  266: 274 */         return null;
/*  267:     */       }
/*  268: 277 */       request.setAttribute("CONFIRM", res.getString("6179"));
/*  269: 278 */       return mapping.findForward("success");
/*  270:     */     }
/*  271:     */     catch (Exception e)
/*  272:     */     {
/*  273: 283 */       e.printStackTrace();
/*  274: 284 */       request.setAttribute("FAILURE", e.getMessage());
/*  275:     */     }
/*  276: 285 */     return mapping.findForward("failure");
/*  277:     */   }
/*  278:     */   
/*  279:     */   private ActionForward performSave(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  280:     */   {
/*  281: 290 */     if (isTokenValid(request, true))
/*  282:     */     {
/*  283: 291 */       VehiculosCompletoForm form = (VehiculosCompletoForm)actionForm;
/*  284:     */       try
/*  285:     */       {
/*  286: 293 */         UsuarioCar usuarioCar = (UsuarioCar)request.getSession().getAttribute("usuarioCar");
/*  287: 294 */         form.setVehi_fecinscripcion(ManejoFechas.getFechaActual());
/*  288:     */         
/*  289: 296 */         VehiculosCompleto vehiculosCompleto = new VehiculosCompleto();
/*  290: 297 */         Vehiculos vehiculo = new Vehiculos();
/*  291: 299 */         if (form.getPveh_indpais1().length() == 0) {
/*  292: 300 */           form.setPveh_indpais1("0");
/*  293:     */         }
/*  294: 302 */         if (form.getPveh_indciudad1().length() == 0) {
/*  295: 303 */           form.setPveh_indciudad1("0");
/*  296:     */         }
/*  297: 305 */         if (form.getPveh_indpais2().length() == 0) {
/*  298: 306 */           form.setPveh_indpais2("0");
/*  299:     */         }
/*  300: 308 */         if (Integer.parseInt(form.getVehi_num_dias_no_mail()) < 2) {
/*  301: 309 */           form.setVehi_num_dias_no_mail("2");
/*  302:     */         }
/*  303: 312 */         vehiculosCompleto.setVehiculo(vehiculo);
/*  304: 313 */         InicializaData.inicializa(vehiculo.getClass(), vehiculo);
/*  305: 314 */         BeanUtils.copyProperties(vehiculo, form);
/*  306: 315 */         vehiculo.setVehi_fechaodometroinicial(new BigDecimal(form.getVehi_fechaodometro()));
/*  307: 316 */         vehiculo.setVehi_kmsodometroinicial(new BigDecimal(form.getVehi_kmsact()));
/*  308: 317 */         vehiculo.setVehi_usuc_cod(usuarioCar.getUsuc_cod());
/*  309:     */         
/*  310: 319 */         PropietariosVehiculos propietariosVehiculos = new PropietariosVehiculos();
/*  311: 320 */         vehiculosCompleto.setPropietario(propietariosVehiculos);
/*  312: 321 */         InicializaData.inicializa(propietariosVehiculos.getClass(), propietariosVehiculos);
/*  313: 322 */         BeanUtils.copyProperties(propietariosVehiculos, form);
/*  314:     */         
/*  315: 324 */         MantenimientoGeneral mantenimientoGeneral = new MantenimientoGeneral();
/*  316: 325 */         vehiculosCompleto.setMantenimientoGeneral(mantenimientoGeneral);
/*  317: 326 */         InicializaData.inicializa(mantenimientoGeneral.getClass(), mantenimientoGeneral);
/*  318: 327 */         BeanUtils.copyProperties(mantenimientoGeneral, form);
/*  319:     */         
/*  320: 329 */         int x = 0;
/*  321: 330 */         RevisionesVehiculoDAO revisionesVehiculoDAO = new RevisionesVehiculoDAO();
/*  322: 331 */         RevisionesDAO revisionesDAO = new RevisionesDAO();
/*  323: 332 */         Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  324: 333 */         if ((servidor != null) && (servidor.getServ_cod() != null))
/*  325:     */         {
/*  326: 334 */           revisionesVehiculoDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  327: 335 */           revisionesDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  328:     */         }
/*  329: 337 */         revisionesVehiculoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  330: 338 */         revisionesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  331: 339 */         List revisiones = revisionesDAO.list();
/*  332: 341 */         if (form.getVehi_distancia().equals("M"))
/*  333:     */         {
/*  334: 342 */           vehiculo.setVehi_enero(new BigDecimal(form.getVehi_enero()).multiply(IConstantes.FACTOR_KMS_MILLAS));
/*  335: 343 */           vehiculo.setVehi_febrero(new BigDecimal(form.getVehi_febrero()).multiply(IConstantes.FACTOR_KMS_MILLAS));
/*  336: 344 */           vehiculo.setVehi_marzo(new BigDecimal(form.getVehi_marzo()).multiply(IConstantes.FACTOR_KMS_MILLAS));
/*  337: 345 */           vehiculo.setVehi_abril(new BigDecimal(form.getVehi_abril()).multiply(IConstantes.FACTOR_KMS_MILLAS));
/*  338: 346 */           vehiculo.setVehi_mayo(new BigDecimal(form.getVehi_mayo()).multiply(IConstantes.FACTOR_KMS_MILLAS));
/*  339: 347 */           vehiculo.setVehi_junio(new BigDecimal(form.getVehi_junio()).multiply(IConstantes.FACTOR_KMS_MILLAS));
/*  340: 348 */           vehiculo.setVehi_julio(new BigDecimal(form.getVehi_julio()).multiply(IConstantes.FACTOR_KMS_MILLAS));
/*  341: 349 */           vehiculo.setVehi_agosto(new BigDecimal(form.getVehi_agosto()).multiply(IConstantes.FACTOR_KMS_MILLAS));
/*  342: 350 */           vehiculo.setVehi_septiembre(new BigDecimal(form.getVehi_septiembre()).multiply(IConstantes.FACTOR_KMS_MILLAS));
/*  343: 351 */           vehiculo.setVehi_octubre(new BigDecimal(form.getVehi_octubre()).multiply(IConstantes.FACTOR_KMS_MILLAS));
/*  344: 352 */           vehiculo.setVehi_noviembre(new BigDecimal(form.getVehi_noviembre()).multiply(IConstantes.FACTOR_KMS_MILLAS));
/*  345: 353 */           vehiculo.setVehi_diciembre(new BigDecimal(form.getVehi_diciembre()).multiply(IConstantes.FACTOR_KMS_MILLAS));
/*  346:     */         }
/*  347: 356 */         List revisionesVehiculo = new ArrayList();
/*  348: 357 */         while (x < revisiones.size())
/*  349:     */         {
/*  350: 358 */           Revisiones revision = (Revisiones)revisiones.get(x);
/*  351:     */           
/*  352: 360 */           RevisionesVehiculo revisionVehiculo = new RevisionesVehiculo();
/*  353: 361 */           InicializaData.inicializa(revisionVehiculo.getClass(), revisionVehiculo);
/*  354:     */           
/*  355: 363 */           revisionVehiculo.setRveh_cod(revision.getRev_cod());
/*  356: 364 */           revisionVehiculo.setRveh_actividad(revision.getRev_actividad());
/*  357: 365 */           revisionVehiculo.setRveh_acc_cod(revision.getRev_acc_cod());
/*  358: 366 */           revisionVehiculo.setRveh_alt_cod(revision.getRev_alt_cod());
/*  359: 367 */           revisionVehiculo.setRveh_cada_cdk(revision.getRev_cada_cdk());
/*  360: 368 */           revisionVehiculo.setRveh_cada_cdm(revision.getRev_cada_cdm());
/*  361:     */           
/*  362: 370 */           revisionVehiculo.setRveh_veh_cod(vehiculosCompleto.getVehiculo().getVehi_cod());
/*  363: 371 */           if (revisionVehiculo.getRveh_cada_cdk().equals(new BigDecimal(0))) {
/*  364: 372 */             revisionVehiculo.setRveh_alt_cod(new BigDecimal(2));
/*  365:     */           }
/*  366: 374 */           if (form.getVehi_distancia().equals("M"))
/*  367:     */           {
/*  368: 375 */             revisionVehiculo.setRveh_cada_cdk(revisionVehiculo.getRveh_cada_cdk().multiply(IConstantes.FACTOR_KMS_MILLAS));
/*  369: 376 */             revisionVehiculo.setRveh_cada_cdk(new BigDecimal(revisionVehiculo.getRveh_cada_cdk().toBigInteger()));
/*  370:     */           }
/*  371: 378 */           revisionesVehiculo.add(revisionVehiculo);
/*  372: 379 */           x++;
/*  373:     */         }
/*  374: 383 */         SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
/*  375: 384 */         BigDecimal distanciaReferencia = BigDecimal.ZERO;
/*  376: 385 */         Date fechaReferencia = null;
/*  377: 386 */         if (vehiculo.getVehi_kmsact().compareTo(distanciaReferencia) == 1)
/*  378:     */         {
/*  379: 387 */           distanciaReferencia = vehiculo.getVehi_kmsact();
/*  380:     */           try
/*  381:     */           {
/*  382: 389 */             fechaReferencia = sdf.parse(vehiculo.getVehi_fechaodometro().toString());
/*  383:     */           }
/*  384:     */           catch (Exception e)
/*  385:     */           {
/*  386: 391 */             fechaReferencia = new Date();
/*  387:     */           }
/*  388:     */         }
/*  389: 393 */         if (mantenimientoGeneral.getMant_control_kms().compareTo(distanciaReferencia) == 1)
/*  390:     */         {
/*  391: 394 */           distanciaReferencia = mantenimientoGeneral.getMant_control_kms();
/*  392:     */           try
/*  393:     */           {
/*  394: 396 */             fechaReferencia = sdf.parse(mantenimientoGeneral.getMant_control_fec().toString());
/*  395:     */           }
/*  396:     */           catch (Exception e)
/*  397:     */           {
/*  398: 398 */             fechaReferencia = new Date();
/*  399:     */           }
/*  400:     */         }
/*  401: 400 */         for (Iterator revisionesIterator = revisionesVehiculo.iterator(); revisionesIterator.hasNext();)
/*  402:     */         {
/*  403: 401 */           RevisionesVehiculo revisionVehiculo = (RevisionesVehiculo)revisionesIterator.next();
/*  404: 402 */           if ((revisionVehiculo.getRveh_bloqueado().compareTo(BigDecimal.ZERO) == 0) && 
/*  405: 403 */             (revisionVehiculo.getRveh_control_kms().compareTo(distanciaReferencia) == 1))
/*  406:     */           {
/*  407: 404 */             distanciaReferencia = revisionVehiculo.getRveh_control_kms();
/*  408:     */             try
/*  409:     */             {
/*  410: 406 */               fechaReferencia = sdf.parse(revisionVehiculo.getRveh_control_fec().toString());
/*  411:     */             }
/*  412:     */             catch (Exception e)
/*  413:     */             {
/*  414: 408 */               fechaReferencia = new Date();
/*  415:     */             }
/*  416:     */           }
/*  417:     */         }
/*  418: 414 */         StringBuffer ultimaFecha = ManejoFechas.getUltimaFechaPorUsuario(vehiculo.getVehi_usuc_cod(), revisionesVehiculo);
/*  419: 415 */         ManejoFechas.setFechaRevision(vehiculo, mantenimientoGeneral, revisiones, distanciaReferencia, fechaReferencia, ultimaFecha);
/*  420:     */         
/*  421: 417 */         Iterator rev_iterator = revisionesVehiculo.iterator();
/*  422: 418 */         while (rev_iterator.hasNext())
/*  423:     */         {
/*  424: 419 */           RevisionesVehiculo revision = (RevisionesVehiculo)rev_iterator.next();
/*  425: 420 */           if (revision.getRveh_bloqueado().compareTo(BigDecimal.ZERO) == 0) {
/*  426: 421 */             ManejoFechas.setFechaRevision(vehiculo, revision, distanciaReferencia, fechaReferencia, ultimaFecha);
/*  427:     */           }
/*  428:     */         }
/*  429: 425 */         vehiculosCompleto.setRevisiones(revisionesVehiculo);
/*  430:     */         
/*  431: 427 */         GastosNoAnualesDAO gastosNoAnualesDAO = new GastosNoAnualesDAO();
/*  432: 428 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  433: 429 */           gastosNoAnualesDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  434:     */         }
/*  435: 431 */         gastosNoAnualesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  436: 432 */         List gastosNoAnuales = gastosNoAnualesDAO.list();
/*  437: 433 */         List gastosVehiculosNoAnuales = new ArrayList();
/*  438: 434 */         x = 0;
/*  439: 435 */         while (x < gastosNoAnuales.size())
/*  440:     */         {
/*  441: 436 */           GastosNoAnuales gastoNoAnual = (GastosNoAnuales)gastosNoAnuales.get(x);
/*  442: 437 */           GastosVehiculosNoAnuales gastoVehiculoNoAnual = new GastosVehiculosNoAnuales();
/*  443: 438 */           InicializaData.inicializa(gastoVehiculoNoAnual.getClass(), gastoVehiculoNoAnual);
/*  444:     */           
/*  445: 440 */           gastoVehiculoNoAnual.setGasv_cod(gastoNoAnual.getGas_cod());
/*  446: 441 */           gastoVehiculoNoAnual.setGasv_descripcion(gastoNoAnual.getGas_descripcion());
/*  447: 442 */           gastoVehiculoNoAnual.setGasv_fechaini(new BigDecimal(ManejoFechas.getFechaActual()));
/*  448: 443 */           gastoVehiculoNoAnual.setGasv_fechafin(new BigDecimal(ManejoFechas.getFechaActual()).add(new BigDecimal(10000)));
/*  449: 444 */           gastoVehiculoNoAnual.setGasv_valor(BigDecimal.ZERO);
/*  450: 445 */           gastoVehiculoNoAnual.setGasv_veh_cod(vehiculosCompleto.getVehiculo().getVehi_cod());
/*  451:     */           
/*  452: 447 */           gastosVehiculosNoAnuales.add(gastoVehiculoNoAnual);
/*  453: 448 */           x++;
/*  454:     */         }
/*  455: 450 */         vehiculosCompleto.setGastosNoAnuales(gastosVehiculosNoAnuales);
/*  456:     */         
/*  457: 452 */         GastosAnualesDAO gastosAnualesDAO = new GastosAnualesDAO();
/*  458: 453 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  459: 454 */           gastosAnualesDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  460:     */         }
/*  461: 456 */         gastosAnualesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  462: 457 */         List gastosAnuales = gastosAnualesDAO.list();
/*  463: 458 */         List gastosVehiculosAnuales = new ArrayList();
/*  464: 459 */         x = 0;
/*  465: 460 */         while (x < gastosAnuales.size())
/*  466:     */         {
/*  467: 461 */           GastosAnuales gastoAnual = (GastosAnuales)gastosAnuales.get(x);
/*  468: 462 */           GastosVehiculosAnuales gastoVehiculoAnual = new GastosVehiculosAnuales();
/*  469: 463 */           InicializaData.inicializa(gastoVehiculoAnual.getClass(), gastoVehiculoAnual);
/*  470:     */           
/*  471: 465 */           gastoVehiculoAnual.setGasv_cod(gastoAnual.getGas_cod());
/*  472: 466 */           gastoVehiculoAnual.setGasv_descripcion(gastoAnual.getGas_descripcion());
/*  473: 467 */           gastoVehiculoAnual.setGasv_fechaini(new BigDecimal(ManejoFechas.getFechaActual()));
/*  474: 468 */           gastoVehiculoAnual.setGasv_fechafin(new BigDecimal(ManejoFechas.getFechaActual()).add(new BigDecimal(10000)));
/*  475: 469 */           gastoVehiculoAnual.setGasv_valor(BigDecimal.ZERO);
/*  476: 470 */           gastoVehiculoAnual.setGasv_veh_cod(vehiculosCompleto.getVehiculo().getVehi_cod());
/*  477:     */           
/*  478: 472 */           gastosVehiculosAnuales.add(gastoVehiculoAnual);
/*  479: 473 */           x++;
/*  480:     */         }
/*  481: 475 */         vehiculosCompleto.setGastosAnuales(gastosVehiculosAnuales);
/*  482:     */         
/*  483: 477 */         GastosMecanicaDAO gastosMecanicaDAO = new GastosMecanicaDAO();
/*  484: 478 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  485: 479 */           gastosMecanicaDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  486:     */         }
/*  487: 481 */         gastosMecanicaDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  488: 482 */         List gastosMecanica = gastosMecanicaDAO.list();
/*  489: 483 */         List gastosVehiculosMecanica = new ArrayList();
/*  490: 484 */         x = 0;
/*  491: 485 */         while (x < gastosMecanica.size())
/*  492:     */         {
/*  493: 486 */           GastosMecanica gastoMecanica = (GastosMecanica)gastosMecanica.get(x);
/*  494: 487 */           GastosVehiculosMecanica gastoVehiculoMecanica = new GastosVehiculosMecanica();
/*  495: 488 */           InicializaData.inicializa(gastoVehiculoMecanica.getClass(), gastoVehiculoMecanica);
/*  496:     */           
/*  497: 490 */           gastoVehiculoMecanica.setGasv_cod(gastoMecanica.getGas_cod());
/*  498: 491 */           gastoVehiculoMecanica.setGasv_descripcion(gastoMecanica.getGas_descripcion());
/*  499: 492 */           gastoVehiculoMecanica.setGasv_fechaini(new BigDecimal(ManejoFechas.getFechaActual()));
/*  500: 493 */           gastoVehiculoMecanica.setGasv_fechafin(new BigDecimal(ManejoFechas.getFechaActual()).add(new BigDecimal(10000)));
/*  501: 494 */           gastoVehiculoMecanica.setGasv_valor(BigDecimal.ZERO);
/*  502: 495 */           gastoVehiculoMecanica.setGasv_veh_cod(vehiculosCompleto.getVehiculo().getVehi_cod());
/*  503:     */           
/*  504: 497 */           gastosVehiculosMecanica.add(gastoVehiculoMecanica);
/*  505: 498 */           x++;
/*  506:     */         }
/*  507: 500 */         vehiculosCompleto.setGastosMecanica(gastosVehiculosMecanica);
/*  508:     */         
/*  509: 502 */         VehiculosCompletoDAO vehiculosCompletoDAO = new VehiculosCompletoDAO();
/*  510: 503 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  511: 504 */           vehiculosCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  512:     */         }
/*  513: 507 */         vehiculosCompletoDAO.insert(vehiculosCompleto);
/*  514:     */       }
/*  515:     */       catch (Exception e)
/*  516:     */       {
/*  517: 510 */         e.printStackTrace();
/*  518: 511 */         return mapping.findForward("failure");
/*  519:     */       }
/*  520:     */     }
/*  521:     */     else
/*  522:     */     {
/*  523: 516 */       return mapping.findForward("failure");
/*  524:     */     }
/*  525: 518 */     return mapping.findForward("success");
/*  526:     */   }
/*  527:     */   
/*  528:     */   private ActionForward performSaveEdit(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  529:     */   {
/*  530: 522 */     VehiculosCompletoForm form = (VehiculosCompletoForm)actionForm;
/*  531:     */     try
/*  532:     */     {
/*  533: 524 */       UsuarioCar usuarioCar = (UsuarioCar)request.getSession().getAttribute("usuarioCar");
/*  534: 525 */       Vehiculos vehiculo = (Vehiculos)request.getSession().getAttribute("vehiculo");
/*  535: 526 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  536: 527 */       VehiculosCompleto vehiculosCompleto = new VehiculosCompleto();
/*  537: 528 */       vehiculosCompleto.setVehiculo(vehiculo);
/*  538: 529 */       VehiculosDAO vehiculosDAO = new VehiculosDAO();
/*  539: 530 */       Vehiculos vehiculosR = vehiculosDAO.retrieveCarByUser(usuarioCar.getUsuc_cod());
/*  540: 531 */       RevisionesVehiculoDAO revisionesVehiculoDAO = new RevisionesVehiculoDAO();
/*  541: 532 */       MantenimientoGeneralDAO mantenimientoGeneralDao2 = new MantenimientoGeneralDAO();
/*  542: 533 */       MantenimientoGeneral mantenimientoGeneral = mantenimientoGeneralDao2.retrive(BigDecimal.ONE, vehiculosR.getVehi_cod());
/*  543:     */       
/*  544:     */ 
/*  545: 536 */       BigDecimal FechaOdometroCero = BigDecimal.ZERO;
/*  546: 537 */       BigDecimal FechaCompra = BigDecimal.ZERO;
/*  547: 538 */       BigDecimal FechaOdometroInicial = BigDecimal.ZERO;
/*  548: 539 */       BigDecimal FechaOdometro = BigDecimal.ZERO;
/*  549: 540 */       BigDecimal DistanciaOdometro = BigDecimal.ZERO;
/*  550: 541 */       BigDecimal DistanciaOdometroInicial = BigDecimal.ZERO;
/*  551: 542 */       List revisiones = revisionesVehiculoDAO.list2(vehiculosR.getVehi_cod());
/*  552: 543 */       List revisiones2 = (List)request.getSession().getAttribute("REVISIONES");
/*  553: 544 */       SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
/*  554: 545 */       SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
/*  555: 547 */       if (form.getOdometroBloqueado().compareTo(new String("1")) == 0) {
/*  556: 548 */         vehiculo.setVehi_bloqueado(BigDecimal.ONE);
/*  557:     */       }
/*  558: 550 */       if (form.getMntnmntoBloqueado().compareTo(new String("1")) == 0) {
/*  559: 551 */         mantenimientoGeneral.setMant_bloqueado(BigDecimal.ONE);
/*  560:     */       }
/*  561: 553 */       if (vehiculo.getVehi_fechaencero().compareTo(BigDecimal.ZERO) != 0)
/*  562:     */       {
/*  563: 556 */         FechaOdometroCero = vehiculo.getVehi_fechaencero();
/*  564: 558 */         if (vehiculo.getVehi_feccomp().compareTo(BigDecimal.ZERO) != 0) {
/*  565: 559 */           FechaCompra = vehiculo.getVehi_feccomp();
/*  566:     */         }
/*  567: 562 */         if (vehiculo.getVehi_fechaodometroinicial().compareTo(BigDecimal.ZERO) != 0) {
/*  568: 563 */           FechaOdometroInicial = vehiculo.getVehi_fechaodometroinicial();
/*  569:     */         }
/*  570: 566 */         if (vehiculo.getVehi_fechaodometro().compareTo(BigDecimal.ZERO) != 0) {
/*  571: 567 */           FechaOdometro = vehiculo.getVehi_fechaodometro();
/*  572:     */         }
/*  573: 570 */         if (vehiculo.getVehi_kmsact().compareTo(BigDecimal.ZERO) != 0) {
/*  574: 571 */           DistanciaOdometro = vehiculo.getVehi_kmsact();
/*  575:     */         }
/*  576: 574 */         if (vehiculo.getVehi_kmsodometroinicial().compareTo(BigDecimal.ZERO) != 0) {
/*  577: 575 */           DistanciaOdometroInicial = vehiculo.getVehi_kmsodometroinicial();
/*  578:     */         }
/*  579: 578 */         BigDecimal[] curva = { vehiculo.getVehi_enero().divideToIntegralValue(new BigDecimal(31.0D)), 
/*  580: 579 */           vehiculo.getVehi_febrero().divideToIntegralValue(new BigDecimal(28.0D)), 
/*  581: 580 */           vehiculo.getVehi_marzo().divideToIntegralValue(new BigDecimal(31.0D)), 
/*  582: 581 */           vehiculo.getVehi_abril().divideToIntegralValue(new BigDecimal(30.0D)), 
/*  583: 582 */           vehiculo.getVehi_mayo().divideToIntegralValue(new BigDecimal(31.0D)), 
/*  584: 583 */           vehiculo.getVehi_junio().divideToIntegralValue(new BigDecimal(30.0D)), 
/*  585: 584 */           vehiculo.getVehi_julio().divideToIntegralValue(new BigDecimal(31.0D)), 
/*  586: 585 */           vehiculo.getVehi_agosto().divideToIntegralValue(new BigDecimal(31.0D)), 
/*  587: 586 */           vehiculo.getVehi_septiembre().divideToIntegralValue(new BigDecimal(30.0D)), 
/*  588: 587 */           vehiculo.getVehi_octubre().divideToIntegralValue(new BigDecimal(31.0D)), 
/*  589: 588 */           vehiculo.getVehi_noviembre().divideToIntegralValue(new BigDecimal(30.0D)), 
/*  590: 589 */           vehiculo.getVehi_diciembre().divideToIntegralValue(new BigDecimal(31.0D)) };
/*  591:     */         
/*  592:     */ 
/*  593:     */ 
/*  594:     */ 
/*  595: 594 */         Iterator rev_iterator2 = revisiones2.iterator();
/*  596: 595 */         int DistanciaAcumulada = 0;int opcion = 0;
/*  597: 596 */         while (rev_iterator2.hasNext())
/*  598:     */         {
/*  599: 598 */           RevisionesVehiculo revision = (RevisionesVehiculo)rev_iterator2.next();
/*  600: 599 */           BigDecimal DistanciaUltimaControl = BigDecimal.ZERO;
/*  601: 600 */           if (revision.getRveh_bloqueado().compareTo(BigDecimal.ZERO) == 0)
/*  602:     */           {
/*  603: 602 */             if (revision.getRveh_control_kms() != BigDecimal.ZERO) {
/*  604: 603 */               DistanciaUltimaControl = revision.getRveh_control_kms();
/*  605:     */             }
/*  606: 605 */             BigDecimal FechaUltimaControl = BigDecimal.ZERO;
/*  607: 606 */             if (revision.getRveh_control_fec() != BigDecimal.ZERO) {
/*  608: 607 */               FechaUltimaControl = revision.getRveh_control_fec();
/*  609:     */             }
/*  610: 610 */             if (FechaCompra.compareTo(BigDecimal.ZERO) == 1)
/*  611:     */             {
/*  612: 611 */               DistanciaAcumulada = FechaCompra.intValue();
/*  613: 612 */               opcion = 1;
/*  614:     */             }
/*  615: 615 */             if (FechaOdometroInicial.compareTo(new BigDecimal(DistanciaAcumulada)) == 1)
/*  616:     */             {
/*  617: 616 */               DistanciaAcumulada = FechaOdometroInicial.intValue();
/*  618: 617 */               opcion = 2;
/*  619:     */             }
/*  620: 620 */             if (FechaUltimaControl.compareTo(new BigDecimal(DistanciaAcumulada)) == 1)
/*  621:     */             {
/*  622: 621 */               DistanciaAcumulada = FechaUltimaControl.intValue();
/*  623: 622 */               opcion = 3;
/*  624:     */             }
/*  625: 624 */             BigDecimal fechaInicial = BigDecimal.ZERO;
/*  626: 625 */             BigDecimal DistanciaInicial = BigDecimal.ZERO;
/*  627: 626 */             switch (opcion)
/*  628:     */             {
/*  629:     */             case 2: 
/*  630: 627 */               fechaInicial = FechaOdometroInicial;
/*  631: 628 */               DistanciaInicial = DistanciaOdometroInicial;
/*  632: 629 */               break;
/*  633:     */             case 3: 
/*  634: 630 */               fechaInicial = FechaUltimaControl;
/*  635: 631 */               DistanciaInicial = DistanciaUltimaControl;
/*  636:     */             }
/*  637: 634 */             Calendar fechaSimulada = new GregorianCalendar();
/*  638: 635 */             fechaSimulada.setTime(sdf.parse(fechaInicial.toString()));
/*  639: 637 */             if (fechaInicial.compareTo(FechaOdometroCero) == 0) {
/*  640: 638 */               revision.setRveh_kmscero(DistanciaInicial);
/*  641:     */             } else {
/*  642: 640 */               while (fechaInicial.compareTo(FechaOdometroCero) < 1)
/*  643:     */               {
/*  644: 642 */                 DistanciaInicial = DistanciaInicial.add(curva[fechaSimulada.get(2)]);
/*  645: 643 */                 fechaSimulada.add(6, 1);
/*  646: 644 */                 fechaInicial = new BigDecimal(sdf.format(fechaSimulada.getTime()));
/*  647:     */               }
/*  648:     */             }
/*  649: 648 */             revision.setRveh_kmscero(DistanciaInicial);
/*  650:     */           }
/*  651:     */         }
/*  652:     */       }
/*  653: 654 */       vehiculosCompleto.setRevisiones(revisiones2);
/*  654: 661 */       if (form.getPveh_indpais1().length() == 0) {
/*  655: 662 */         form.setPveh_indpais1("0");
/*  656:     */       }
/*  657: 664 */       if (form.getPveh_indciudad1().length() == 0) {
/*  658: 665 */         form.setPveh_indciudad1("0");
/*  659:     */       }
/*  660: 667 */       if (form.getPveh_indpais2().length() == 0) {
/*  661: 668 */         form.setPveh_indpais2("0");
/*  662:     */       }
/*  663: 670 */       if (Integer.parseInt(form.getVehi_num_dias_no_mail()) < 2) {
/*  664: 671 */         form.setVehi_num_dias_no_mail("2");
/*  665:     */       }
/*  666: 673 */       boolean calculoOdoCero = false;
/*  667: 674 */       if (form.getVehi_cerobasica().compareTo(new String("0")) != 0) {
/*  668: 675 */         calculoOdoCero = true;
/*  669:     */       }
/*  670: 677 */       if (form.getVehi_fechaencero().compareTo(new String("0")) != 0) {
/*  671: 678 */         calculoOdoCero = true;
/*  672:     */       }
/*  673: 680 */       boolean cerotab1 = false;
/*  674: 681 */       if (form.getVehi_cerobasica().compareTo(new String("0")) != 0) {
/*  675: 682 */         cerotab1 = true;
/*  676:     */       }
/*  677: 684 */       boolean cerotab9 = false;
/*  678: 685 */       if (form.getVehi_cerorevision().compareTo(new String("0")) != 0) {
/*  679: 686 */         cerotab9 = true;
/*  680:     */       }
/*  681: 689 */       if ((cerotab1) || (cerotab9))
/*  682:     */       {
/*  683: 693 */         BigDecimal distanciaReferencia = BigDecimal.ZERO;
/*  684: 694 */         BigDecimal diferenciaMenorA = new BigDecimal(10000000);
/*  685: 695 */         BigDecimal diferenciaMenorB = new BigDecimal(10000000);
/*  686: 696 */         Integer fechacero = new Integer(new String(form.getVehi_fechaencero()));
/*  687:     */         
/*  688: 698 */         BigDecimal fechaReferenciaInicial = new BigDecimal(fechacero.intValue());
/*  689: 699 */         BigDecimal fechaReferenciaInicial0 = new BigDecimal(fechacero.intValue());
/*  690: 700 */         BigDecimal distanciaReferenciaInicial = BigDecimal.ZERO;
/*  691: 701 */         if (vehiculo.getVehi_fechaodometro().compareTo(fechaReferenciaInicial) == -1)
/*  692:     */         {
/*  693: 703 */           diferenciaMenorA = fechaReferenciaInicial.subtract(vehiculo.getVehi_fechaodometro());
/*  694: 704 */           fechaReferenciaInicial = vehiculo.getVehi_fechaodometro();
/*  695: 705 */           distanciaReferenciaInicial = vehiculo.getVehi_kmsact();
/*  696:     */         }
/*  697: 707 */         diferenciaMenorB = fechaReferenciaInicial.subtract(mantenimientoGeneral.getMant_control_fec());
/*  698: 708 */         if ((diferenciaMenorB.intValue() < diferenciaMenorA.intValue()) && (diferenciaMenorB.intValue() > 0))
/*  699:     */         {
/*  700: 709 */           fechaReferenciaInicial = mantenimientoGeneral.getMant_control_fec();
/*  701: 710 */           distanciaReferenciaInicial = mantenimientoGeneral.getMant_control_kms();
/*  702: 711 */           diferenciaMenorA = diferenciaMenorB;
/*  703:     */         }
/*  704: 714 */         for (Iterator revisionesIterator = revisiones2.iterator(); revisionesIterator.hasNext();)
/*  705:     */         {
/*  706: 716 */           RevisionesVehiculo revisionVehiculoA = (RevisionesVehiculo)revisionesIterator.next();
/*  707: 717 */           diferenciaMenorB = fechaReferenciaInicial0.subtract(revisionVehiculoA.getRveh_control_fec());
/*  708: 718 */           if (revisionVehiculoA.getRveh_bloqueado().compareTo(BigDecimal.ZERO) == 0) {
/*  709: 720 */             if ((diferenciaMenorB.intValue() < diferenciaMenorA.intValue()) && (diferenciaMenorB.intValue() > 0))
/*  710:     */             {
/*  711: 721 */               fechaReferenciaInicial = revisionVehiculoA.getRveh_control_fec();
/*  712: 722 */               distanciaReferenciaInicial = revisionVehiculoA.getRveh_control_kms();
/*  713: 723 */               diferenciaMenorA = diferenciaMenorB;
/*  714:     */             }
/*  715:     */           }
/*  716:     */         }
/*  717: 728 */         if (form.getVehi_fechaencero().toString().compareTo(new String("0")) != 0) {
/*  718: 729 */           form.setVehi_kmsencero(ManejoFechas.getDistanciaOdometroCero(vehiculo, sdf.parse(fechaReferenciaInicial.toString()), distanciaReferenciaInicial, sdf.parse(form.getVehi_fechaencero().toString())));
/*  719:     */         }
/*  720:     */       }
/*  721: 736 */       List controles = (List)request.getSession().getAttribute("CONTROLESVEHICULOS");
/*  722: 737 */       vehiculosCompleto.setControles(controles);
/*  723:     */       
/*  724: 739 */       List seguros = (List)request.getSession().getAttribute("SEGUROSVEHICULOS");
/*  725: 740 */       vehiculosCompleto.setSeguros(seguros);
/*  726:     */       
/*  727: 742 */       List gastosMecanica = (List)request.getSession().getAttribute("GASTOSVEHICULOSMECANICA");
/*  728: 743 */       vehiculosCompleto.setGastosMecanica(gastosMecanica);
/*  729:     */       
/*  730: 745 */       List gastosNoAnuales = (List)request.getSession().getAttribute("GASTOSVEHICULOSNOANUALES");
/*  731: 746 */       vehiculosCompleto.setGastosNoAnuales(gastosNoAnuales);
/*  732:     */       
/*  733: 748 */       List gastosAnuales = (List)request.getSession().getAttribute("GASTOSVEHICULOSANUALES");
/*  734: 749 */       vehiculosCompleto.setGastosAnuales(gastosAnuales);
/*  735:     */       
/*  736: 751 */       List impuestos = (List)request.getSession().getAttribute("IMPUESTOS");
/*  737: 752 */       vehiculosCompleto.setImpuestos(impuestos);
/*  738:     */       
/*  739: 754 */       List combustibles = (List)request.getSession().getAttribute("COMBUSTIBLEVEHICULO");
/*  740: 755 */       if ((!form.getCom_lecturaini().equals("0")) && (!form.getCom_lecturafin().equals("0")) && (!form.getCom_cantidadconsumo().equals("0")) && (!form.getCom_costocombustible().equals("0")) && (combustibles.size() < 5))
/*  741:     */       {
/*  742: 756 */         Combustible combustible = new Combustible();
/*  743: 757 */         InicializaData.inicializa(combustible.getClass(), combustible);
/*  744: 758 */         BeanUtils.copyProperties(combustible, form);
/*  745: 759 */         combustible.setCom_veh_cod(vehiculo.getVehi_cod());
/*  746: 760 */         combustibles.add(0, combustible);
/*  747:     */       }
/*  748: 762 */       vehiculosCompleto.setConsumosCombustible(combustibles);
/*  749:     */       
/*  750:     */ 
/*  751: 765 */       VehiculosCompletoDAO vehiculosCompletoDAO = new VehiculosCompletoDAO();
/*  752: 766 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  753: 767 */         vehiculosCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  754:     */       }
/*  755: 771 */       BeanUtils.copyProperties(vehiculo, form);
/*  756: 772 */       vehiculo.setVehi_usuc_cod(usuarioCar.getUsuc_cod());
/*  757:     */       
/*  758: 774 */       Date fechaActual = new Date();
/*  759:     */       
/*  760: 776 */       vehiculo.setVehi_registro(new BigDecimal(sdf2.format(fechaActual)));
/*  761:     */       
/*  762: 778 */       PropietariosVehiculos propietariosVehiculos = new PropietariosVehiculos();
/*  763: 779 */       vehiculosCompleto.setPropietario(propietariosVehiculos);
/*  764: 780 */       InicializaData.inicializa(propietariosVehiculos.getClass(), propietariosVehiculos);
/*  765: 781 */       BeanUtils.copyProperties(propietariosVehiculos, form);
/*  766:     */       
/*  767: 783 */       vehiculosCompleto.setMantenimientoGeneral(mantenimientoGeneral);
/*  768: 784 */       InicializaData.inicializa(mantenimientoGeneral.getClass(), mantenimientoGeneral);
/*  769: 785 */       BeanUtils.copyProperties(mantenimientoGeneral, form);
/*  770: 787 */       if (ManejoFechas.restaFechas(mantenimientoGeneral.getMant_control_fec().toString(), ManejoFechas.getFechaActual()) < 0) {
/*  771: 788 */         mantenimientoGeneral.setMant_control_fec(new BigDecimal(ManejoFechas.getFechaActual()));
/*  772:     */       }
/*  773: 791 */       BigDecimal odo_actual = vehiculo.getVehi_kmsact();
/*  774:     */       
/*  775:     */ 
/*  776:     */ 
/*  777: 795 */       vehiculosCompletoDAO.update(vehiculosCompleto, vehiculo.getVehi_cod());
/*  778:     */       
/*  779:     */ 
/*  780:     */ 
/*  781: 799 */       GruposVehiculoDAO gruposVehiculoDAO = new GruposVehiculoDAO();
/*  782: 800 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  783: 801 */         gruposVehiculoDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  784:     */       }
/*  785: 803 */       String[] llavesGrupos = { "grupv_cod", "grupv_vehi_cod" };
/*  786: 804 */       GruposVehiculo gruposVehiculo = new GruposVehiculo();
/*  787: 805 */       for (int i = 0; i < 3; i++)
/*  788:     */       {
/*  789: 806 */         switch (i)
/*  790:     */         {
/*  791:     */         case 0: 
/*  792: 808 */           gruposVehiculo = gruposVehiculoDAO.search(vehiculosCompleto.getVehiculo().getVehi_cod(), IGrupos.CARS_CONTROLES);
/*  793: 809 */           break;
/*  794:     */         case 1: 
/*  795: 811 */           gruposVehiculo = gruposVehiculoDAO.search(vehiculosCompleto.getVehiculo().getVehi_cod(), IGrupos.CARS_SEGUROS);
/*  796: 812 */           break;
/*  797:     */         case 2: 
/*  798: 814 */           gruposVehiculo = gruposVehiculoDAO.search(vehiculosCompleto.getVehiculo().getVehi_cod(), IGrupos.CARS_IMPUESTOS);
/*  799:     */         }
/*  800: 817 */         switch (i)
/*  801:     */         {
/*  802:     */         case 0: 
/*  803: 819 */           if (Integer.parseInt(form.getCveh_dias_antes()) < 2) {
/*  804: 820 */             form.setCveh_dias_antes("2");
/*  805:     */           }
/*  806: 822 */           gruposVehiculo.setGrupv_dias_antes(new BigDecimal(form.getCveh_dias_antes()));
/*  807: 823 */           break;
/*  808:     */         case 1: 
/*  809: 825 */           if (Integer.parseInt(form.getSveh_dias_antes()) < 2) {
/*  810: 826 */             form.setSveh_dias_antes("2");
/*  811:     */           }
/*  812: 828 */           gruposVehiculo.setGrupv_dias_antes(new BigDecimal(form.getSveh_dias_antes()));
/*  813: 829 */           break;
/*  814:     */         case 2: 
/*  815: 831 */           if (Integer.parseInt(form.getIveh_dias_antes()) < 2) {
/*  816: 832 */             form.setIveh_dias_antes("2");
/*  817:     */           }
/*  818: 834 */           gruposVehiculo.setGrupv_dias_antes(new BigDecimal(form.getIveh_dias_antes()));
/*  819:     */         }
/*  820: 837 */         gruposVehiculoDAO.update(gruposVehiculo, llavesGrupos);
/*  821:     */       }
/*  822: 855 */       BigDecimal distanciaReferencia = BigDecimal.ZERO;
/*  823: 856 */       BigDecimal fechaReferenciaInicial = BigDecimal.ZERO;
/*  824: 857 */       Date fechaReferencia = null;
/*  825: 858 */       BigDecimal distanciaReferenciaInicial = BigDecimal.ZERO;
/*  826: 859 */       if ((vehiculo.getVehi_fechaodometro().compareTo(fechaReferenciaInicial) == 1) && 
/*  827: 860 */         (vehiculo.getVehi_bloqueado().compareTo(BigDecimal.ZERO) == 0))
/*  828:     */       {
/*  829: 861 */         fechaReferenciaInicial = vehiculo.getVehi_fechaodometro();
/*  830: 862 */         distanciaReferenciaInicial = vehiculo.getVehi_kmsact();
/*  831:     */       }
/*  832: 866 */       if ((mantenimientoGeneral.getMant_control_fec().compareTo(fechaReferenciaInicial) == 1) && 
/*  833: 867 */         (mantenimientoGeneral.getMant_bloqueado().compareTo(BigDecimal.ZERO) == 0))
/*  834:     */       {
/*  835: 868 */         fechaReferenciaInicial = mantenimientoGeneral.getMant_control_fec();
/*  836: 869 */         distanciaReferenciaInicial = mantenimientoGeneral.getMant_control_kms();
/*  837:     */       }
/*  838: 872 */       for (Iterator revisionesIterator = revisiones2.iterator(); revisionesIterator.hasNext();)
/*  839:     */       {
/*  840: 873 */         RevisionesVehiculo revisionVehiculo = (RevisionesVehiculo)revisionesIterator.next();
/*  841: 874 */         if (revisionVehiculo.getRveh_bloqueado().compareTo(BigDecimal.ZERO) == 0) {
/*  842: 876 */           if (revisionVehiculo.getRveh_control_fec().compareTo(fechaReferenciaInicial) == 1)
/*  843:     */           {
/*  844: 877 */             fechaReferenciaInicial = revisionVehiculo.getRveh_control_fec();
/*  845: 878 */             distanciaReferenciaInicial = revisionVehiculo.getRveh_control_kms();
/*  846:     */           }
/*  847:     */         }
/*  848:     */       }
/*  849: 884 */       fechaReferencia = sdf.parse(fechaReferenciaInicial.toString());
/*  850: 885 */       distanciaReferencia = distanciaReferenciaInicial;
/*  851:     */       
/*  852:     */ 
/*  853: 888 */       StringBuffer ultimaFecha = ManejoFechas.getUltimaFechaPorUsuario(vehiculo.getVehi_usuc_cod(), revisiones2);
/*  854:     */       
/*  855: 890 */       ManejoFechas.setFechaRevision(vehiculo, mantenimientoGeneral, revisiones2, distanciaReferencia, fechaReferencia, ultimaFecha);
/*  856:     */       
/*  857:     */ 
/*  858:     */ 
/*  859: 894 */       Iterator rev_iterator = revisiones2.iterator();
/*  860: 895 */       while (rev_iterator.hasNext())
/*  861:     */       {
/*  862: 896 */         RevisionesVehiculo revision = (RevisionesVehiculo)rev_iterator.next();
/*  863: 897 */         if (revision.getRveh_bloqueado().compareTo(BigDecimal.ZERO) == 0)
/*  864:     */         {
/*  865: 898 */           BigDecimal diferencia = distanciaReferenciaInicial.subtract(revision.getRveh_control_kms());
/*  866: 899 */           ManejoFechas.setFechaRevision(vehiculo, revision, diferencia, fechaReferencia, ultimaFecha);
/*  867:     */         }
/*  868:     */       }
/*  869: 902 */       int y = 0;
/*  870: 903 */       vehiculosCompleto.setRevisiones(revisiones2);
/*  871: 904 */       vehiculosCompletoDAO.update(vehiculosCompleto, vehiculo.getVehi_cod());
/*  872:     */     }
/*  873:     */     catch (Exception e)
/*  874:     */     {
/*  875: 907 */       e.printStackTrace();
/*  876: 908 */       return mapping.findForward("failure");
/*  877:     */     }
/*  878: 911 */     return mapping.findForward("success");
/*  879:     */   }
/*  880:     */   
/*  881:     */   private ActionForward performEdit(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  882:     */   {
/*  883: 915 */     VehiculosCompletoForm form = (VehiculosCompletoForm)actionForm;
/*  884: 916 */     Boolean nuevo = Boolean.valueOf(false);
/*  885:     */     try
/*  886:     */     {
/*  887: 919 */       VehiculosCompletoDAO vehiculosCompletoDAO = new VehiculosCompletoDAO();
/*  888: 920 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  889: 921 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  890: 922 */         vehiculosCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  891:     */       }
/*  892: 924 */       VehiculosCompleto vehiculosCompleto = vehiculosCompletoDAO.retrieve(new BigDecimal(request.getParameter("vehi_cod")));
/*  893:     */       
/*  894: 926 */       request.getSession().setAttribute("vehiculo", vehiculosCompleto.getVehiculo());
/*  895:     */       
/*  896: 928 */       BeanUtils.copyProperties(form, vehiculosCompleto.getVehiculo());
/*  897: 929 */       BeanUtils.copyProperties(form, vehiculosCompleto.getPropietario());
/*  898: 930 */       BeanUtils.copyProperties(form, vehiculosCompleto.getMantenimientoGeneral());
/*  899:     */       
/*  900: 932 */       form.setVehi_feccomp(ManejoFechas.FormateoFecha(form.getVehi_feccomp()));
/*  901: 933 */       form.setVehi_fechaodometro(ManejoFechas.FormateoFecha(form.getVehi_fechaodometro()));
/*  902: 934 */       form.setPveh_fecnacim(ManejoFechas.FormateoFecha(form.getPveh_fecnacim()));
/*  903: 935 */       form.setCom_fechaini(ManejoFechas.FormateoFecha(form.getCom_fechaini()));
/*  904: 936 */       form.setCom_fechafin(ManejoFechas.FormateoFecha(form.getCom_fechafin()));
/*  905: 937 */       form.setFechaMantenimientosBasicos(ManejoFechas.FormateoFecha(form.getFechaMantenimientosBasicos()));
/*  906: 938 */       form.setMant_control_fec(ManejoFechas.FormateoFecha(form.getMant_control_fec()));
/*  907: 939 */       form.setVehi_fechaencero(ManejoFechas.FormateoFecha(form.getVehi_fechaencero()));
/*  908:     */       
/*  909: 941 */       List revisiones = vehiculosCompleto.getRevisiones();
/*  910:     */       
/*  911: 943 */       int x = 0;
/*  912:     */       
/*  913: 945 */       request.getSession().setAttribute("REVISIONES", revisiones);
/*  914:     */       
/*  915: 947 */       RevisionAccionDAO revisionAccionDAO = new RevisionAccionDAO();
/*  916: 948 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  917: 949 */         revisionAccionDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  918:     */       }
/*  919: 951 */       revisionAccionDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  920: 952 */       RevisionAlternativaDAO revisionAlternativaDAO = new RevisionAlternativaDAO();
/*  921: 953 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  922: 954 */         revisionAlternativaDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  923:     */       }
/*  924: 956 */       revisionAlternativaDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  925: 957 */       x = 0;
/*  926: 958 */       while (x < revisiones.size())
/*  927:     */       {
/*  928: 959 */         request.setAttribute("rveh_acc_des" + x, revisionAccionDAO.retrive(((RevisionesVehiculo)revisiones.get(x)).getRveh_acc_cod()).getRacc_cod().toString());
/*  929: 960 */         request.setAttribute("rveh_alt_cod" + x, revisionAlternativaDAO.retrive(((RevisionesVehiculo)revisiones.get(x)).getRveh_alt_cod()).getRalt_des());
/*  930: 961 */         x++;
/*  931:     */       }
/*  932: 964 */       List seguros = vehiculosCompleto.getSeguros();
/*  933: 965 */       request.getSession().setAttribute("SEGUROSVEHICULOS", seguros);
/*  934:     */       
/*  935: 967 */       List controles = vehiculosCompleto.getControles();
/*  936: 968 */       request.getSession().setAttribute("CONTROLESVEHICULOS", controles);
/*  937:     */       
/*  938: 970 */       List gastosVehiculosMecanica = vehiculosCompleto.getGastosMecanica();
/*  939: 971 */       GastosVehiculosMecanicaDAO gastosVehiculosMecanicaDAO = new GastosVehiculosMecanicaDAO();
/*  940: 972 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  941: 973 */         gastosVehiculosMecanicaDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  942:     */       }
/*  943: 975 */       request.getSession().setAttribute("GASTOSVEHICULOSMECANICA", gastosVehiculosMecanica);
/*  944:     */       
/*  945: 977 */       List gastosVehiculosNoAnuales = vehiculosCompleto.getGastosNoAnuales();
/*  946: 978 */       GastosVehiculosNoAnualesDAO gastosVehiculosNoAnualesDAO = new GastosVehiculosNoAnualesDAO();
/*  947: 979 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  948: 980 */         gastosVehiculosNoAnualesDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  949:     */       }
/*  950: 982 */       request.getSession().setAttribute("GASTOSVEHICULOSNOANUALES", gastosVehiculosNoAnuales);
/*  951:     */       
/*  952: 984 */       List gastosVehiculosAnuales = vehiculosCompleto.getGastosAnuales();
/*  953: 985 */       request.getSession().setAttribute("GASTOSVEHICULOSANUALES", gastosVehiculosAnuales);
/*  954:     */       
/*  955: 987 */       List impuestos = vehiculosCompleto.getImpuestos();
/*  956: 988 */       request.getSession().setAttribute("IMPUESTOS", impuestos);
/*  957:     */       
/*  958: 990 */       List combustibleAuto = vehiculosCompleto.getConsumosCombustible();
/*  959: 991 */       request.getSession().setAttribute("COMBUSTIBLEVEHICULO", combustibleAuto);
/*  960:     */       
/*  961: 993 */       TipoVehiculoDAO tipoVehiculoDAO = new TipoVehiculoDAO();
/*  962: 994 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  963: 995 */         tipoVehiculoDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  964:     */       }
/*  965: 997 */       tipoVehiculoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  966: 998 */       List tipoVehiculos = tipoVehiculoDAO.list();
/*  967: 999 */       request.setAttribute("TIPOVEHICULO", tipoVehiculos);
/*  968:     */       
/*  969:1001 */       PaisDAO paisDAO = new PaisDAO();
/*  970:1002 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  971:1003 */         paisDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  972:     */       }
/*  973:1005 */       paisDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  974:1006 */       List paises = paisDAO.list();
/*  975:1007 */       request.setAttribute("PAISES", paises);
/*  976:     */       
/*  977:1009 */       List ciudades = null;
/*  978:1010 */       CiudadDAO ciudadesDAO = new CiudadDAO();
/*  979:1011 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  980:1012 */         ciudadesDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  981:     */       }
/*  982:1014 */       ciudadesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  983:1015 */       if (paises.size() > 0) {
/*  984:1016 */         if (!form.getPveh_pais_cod().equals("0")) {
/*  985:1017 */           ciudades = ciudadesDAO.search(form.getPveh_pais_cod());
/*  986:     */         } else {
/*  987:1019 */           ciudades = ciudadesDAO.search(((Paises)paises.get(0)).getPais_cod().toString());
/*  988:     */         }
/*  989:     */       }
/*  990:1022 */       request.setAttribute("CIUDADES", ciudades);
/*  991:     */       
/*  992:1024 */       List revisionAlternativas = revisionAlternativaDAO.list();
/*  993:1025 */       request.setAttribute("alternativas", revisionAlternativas);
/*  994:     */       
/*  995:1027 */       List revisionAcciones = revisionAccionDAO.list();
/*  996:1028 */       request.setAttribute("acciones", revisionAcciones);
/*  997:     */       
/*  998:1030 */       MarcasAutosDAO marcasAutoDAO = new MarcasAutosDAO();
/*  999:1031 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1000:1032 */         marcasAutoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1001:     */       }
/* 1002:1034 */       marcasAutoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 1003:1035 */       List marcasAuto = marcasAutoDAO.list();
/* 1004:1036 */       request.setAttribute("MARCASAUTOS", marcasAuto);
/* 1005:     */       
/* 1006:1038 */       request.getSession().setAttribute("tipoMedida", vehiculosCompleto.getVehiculo().getVehi_distancia());
/* 1007:     */       
/* 1008:1040 */       GruposVehiculoDAO gruposVehiculoDAO = new GruposVehiculoDAO();
/* 1009:1041 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1010:1042 */         gruposVehiculoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1011:     */       }
/* 1012:1045 */       for (int i = 0; i < 3; i++)
/* 1013:     */       {
/* 1014:1046 */         GruposVehiculo gruposVehiculo = new GruposVehiculo();
/* 1015:1047 */         switch (i)
/* 1016:     */         {
/* 1017:     */         case 0: 
/* 1018:1049 */           gruposVehiculo = gruposVehiculoDAO.search(vehiculosCompleto.getVehiculo().getVehi_cod(), IGrupos.CARS_CONTROLES);
/* 1019:1050 */           break;
/* 1020:     */         case 1: 
/* 1021:1052 */           gruposVehiculo = gruposVehiculoDAO.search(vehiculosCompleto.getVehiculo().getVehi_cod(), IGrupos.CARS_SEGUROS);
/* 1022:1053 */           break;
/* 1023:     */         case 2: 
/* 1024:1055 */           gruposVehiculo = gruposVehiculoDAO.search(vehiculosCompleto.getVehiculo().getVehi_cod(), IGrupos.CARS_IMPUESTOS);
/* 1025:     */         }
/* 1026:1058 */         if (gruposVehiculo.getGrupv_vehi_cod() != null)
/* 1027:     */         {
/* 1028:1059 */           switch (i)
/* 1029:     */           {
/* 1030:     */           case 0: 
/* 1031:1061 */             form.setCveh_dias_antes(gruposVehiculo.getGrupv_dias_antes().toString());
/* 1032:1062 */             request.getSession().setAttribute("CONTROLESVEHICULOSDIAS", form.getCveh_dias_antes());
/* 1033:1063 */             break;
/* 1034:     */           case 1: 
/* 1035:1065 */             form.setSveh_dias_antes(gruposVehiculo.getGrupv_dias_antes().toString());
/* 1036:1066 */             request.getSession().setAttribute("SEGUROSVEHICULOSDIAS", form.getSveh_dias_antes());
/* 1037:1067 */             break;
/* 1038:     */           case 2: 
/* 1039:1069 */             form.setIveh_dias_antes(gruposVehiculo.getGrupv_dias_antes().toString());
/* 1040:1070 */             request.getSession().setAttribute("IMPUESTOSVEHICULOSDIAS", form.getIveh_dias_antes());
/* 1041:     */           }
/* 1042:     */         }
/* 1043:     */         else
/* 1044:     */         {
/* 1045:1074 */           GruposDAO gruposDAO = new GruposDAO();
/* 1046:1075 */           if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1047:1076 */             gruposDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1048:     */           }
/* 1049:1078 */           gruposDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 1050:1079 */           Grupos grupos = new Grupos();
/* 1051:1080 */           switch (i)
/* 1052:     */           {
/* 1053:     */           case 0: 
/* 1054:1082 */             grupos = gruposDAO.retrive(IGrupos.CARS_CONTROLES);
/* 1055:1083 */             form.setCveh_dias_antes(grupos.getGrup_dias_antes().toString());
/* 1056:1084 */             request.getSession().setAttribute("CONTROLESVEHICULOSDIAS", form.getCveh_dias_antes());
/* 1057:1085 */             break;
/* 1058:     */           case 1: 
/* 1059:1087 */             grupos = gruposDAO.retrive(IGrupos.CARS_SEGUROS);
/* 1060:1088 */             form.setSveh_dias_antes(grupos.getGrup_dias_antes().toString());
/* 1061:1089 */             request.getSession().setAttribute("SEGUROSVEHICULOSDIAS", form.getSveh_dias_antes());
/* 1062:1090 */             break;
/* 1063:     */           case 2: 
/* 1064:1092 */             grupos = gruposDAO.retrive(IGrupos.CARS_IMPUESTOS);
/* 1065:1093 */             form.setIveh_dias_antes(grupos.getGrup_dias_antes().toString());
/* 1066:1094 */             request.getSession().setAttribute("IMPUESTOSVEHICULOSDIAS", form.getIveh_dias_antes());
/* 1067:     */           }
/* 1068:     */         }
/* 1069:     */       }
/* 1070:1100 */       IdiomaDAO idiomaDAO = new IdiomaDAO();
/* 1071:1101 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1072:1102 */         idiomaDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1073:     */       }
/* 1074:1104 */       request.setAttribute("IDIOMAS", idiomaDAO.list());
/* 1075:     */     }
/* 1076:     */     catch (Exception e)
/* 1077:     */     {
/* 1078:1107 */       return mapping.findForward("failure");
/* 1079:     */     }
/* 1080:1109 */     return mapping.findForward("success");
/* 1081:     */   }
/* 1082:     */   
/* 1083:     */   private ActionForward performAdd(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 1084:     */   {
/* 1085:1113 */     VehiculosCompletoForm form = (VehiculosCompletoForm)actionForm;
/* 1086:     */     try
/* 1087:     */     {
/* 1088:1116 */       if (request.getParameter("recargar") == null)
/* 1089:     */       {
/* 1090:1117 */         BorrarSession.eliminaAtributos(request.getSession(), "");
/* 1091:1118 */         saveToken(request);
/* 1092:     */       }
/* 1093:1120 */       TipoVehiculoDAO tipoVehiculoDAO = new TipoVehiculoDAO();
/* 1094:1121 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 1095:1122 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1096:1123 */         tipoVehiculoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1097:     */       }
/* 1098:1125 */       tipoVehiculoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 1099:1126 */       List tipoVehiculos = tipoVehiculoDAO.list();
/* 1100:1127 */       request.setAttribute("TIPOVEHICULO", tipoVehiculos);
/* 1101:     */       
/* 1102:1129 */       PaisDAO paisDAO = new PaisDAO();
/* 1103:1130 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1104:1131 */         paisDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1105:     */       }
/* 1106:1133 */       paisDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 1107:1134 */       List paises = paisDAO.list();
/* 1108:1135 */       request.setAttribute("PAISES", paises);
/* 1109:     */       
/* 1110:1137 */       List ciudades = null;
/* 1111:1138 */       CiudadDAO ciudadesDAO = new CiudadDAO();
/* 1112:1139 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1113:1140 */         ciudadesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1114:     */       }
/* 1115:1142 */       ciudadesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 1116:1143 */       if (paises.size() > 0) {
/* 1117:1144 */         if (!form.getPveh_pais_cod().equals("0")) {
/* 1118:1145 */           ciudades = ciudadesDAO.search(form.getPveh_pais_cod());
/* 1119:     */         } else {
/* 1120:1147 */           ciudades = ciudadesDAO.search(((Paises)paises.get(0)).getPais_cod().toString());
/* 1121:     */         }
/* 1122:     */       }
/* 1123:1150 */       request.setAttribute("CIUDADES", ciudades);
/* 1124:     */       
/* 1125:1152 */       MarcasAutosDAO marcasAutoDAO = new MarcasAutosDAO();
/* 1126:1153 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1127:1154 */         marcasAutoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1128:     */       }
/* 1129:1156 */       marcasAutoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 1130:1157 */       List marcasAuto = marcasAutoDAO.list();
/* 1131:1158 */       request.setAttribute("MARCASAUTOS", marcasAuto);
/* 1132:     */       
/* 1133:1160 */       form.setVehi_feccomp(ManejoFechas.FormateoFecha(form.getVehi_feccomp()));
/* 1134:1161 */       form.setVehi_fechaodometro(ManejoFechas.FormateoFecha(form.getVehi_fechaodometro()));
/* 1135:1162 */       form.setPveh_fecnacim(ManejoFechas.FormateoFecha(form.getPveh_fecnacim()));
/* 1136:     */       
/* 1137:1164 */       IdiomaDAO idiomaDAO = new IdiomaDAO();
/* 1138:1165 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1139:1166 */         idiomaDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1140:     */       }
/* 1141:1168 */       request.setAttribute("IDIOMAS", idiomaDAO.list());
/* 1142:     */     }
/* 1143:     */     catch (Exception e)
/* 1144:     */     {
/* 1145:1171 */       e.printStackTrace();
/* 1146:1172 */       return mapping.findForward("failure");
/* 1147:     */     }
/* 1148:1175 */     return mapping.findForward("success");
/* 1149:     */   }
/* 1150:     */   
/* 1151:     */   private ActionForward performLoad(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 1152:     */   {
/* 1153:1179 */     VehiculosCompletoForm form = (VehiculosCompletoForm)actionForm;
/* 1154:     */     try
/* 1155:     */     {
/* 1156:1182 */       TipoVehiculoDAO tipoVehiculoDAO = new TipoVehiculoDAO();
/* 1157:1183 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 1158:1184 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1159:1185 */         tipoVehiculoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1160:     */       }
/* 1161:1187 */       tipoVehiculoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 1162:1188 */       List tipoVehiculos = tipoVehiculoDAO.list();
/* 1163:1189 */       request.setAttribute("TIPOVEHICULO", tipoVehiculos);
/* 1164:     */       
/* 1165:1191 */       PaisDAO paisDAO = new PaisDAO();
/* 1166:1192 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1167:1193 */         paisDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1168:     */       }
/* 1169:1195 */       paisDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 1170:1196 */       List paises = paisDAO.list();
/* 1171:1197 */       request.setAttribute("PAISES", paises);
/* 1172:     */       
/* 1173:1199 */       List ciudades = null;
/* 1174:1200 */       CiudadDAO ciudadesDAO = new CiudadDAO();
/* 1175:1201 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1176:1202 */         ciudadesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1177:     */       }
/* 1178:1204 */       ciudadesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 1179:1205 */       if (paises.size() > 0) {
/* 1180:1206 */         if (!form.getPveh_pais_cod().equals("0")) {
/* 1181:1207 */           ciudades = ciudadesDAO.search(form.getPveh_pais_cod());
/* 1182:     */         } else {
/* 1183:1209 */           ciudades = ciudadesDAO.search(((Paises)paises.get(0)).getPais_cod().toString());
/* 1184:     */         }
/* 1185:     */       }
/* 1186:1212 */       request.setAttribute("CIUDADES", ciudades);
/* 1187:     */       
/* 1188:     */ 
/* 1189:     */ 
/* 1190:1216 */       form.setVehi_feccomp(ManejoFechas.FormateoFecha(form.getVehi_feccomp()));
/* 1191:1217 */       form.setVehi_fechaodometro(ManejoFechas.FormateoFecha(form.getVehi_fechaodometro()));
/* 1192:1218 */       form.setPveh_fecnacim(ManejoFechas.FormateoFecha(form.getPveh_fecnacim()));
/* 1193:1219 */       form.setFechaMantenimientosBasicos(ManejoFechas.FormateoFecha(form.getFechaMantenimientosBasicos()));
/* 1194:1220 */       form.setMant_control_fec(ManejoFechas.FormateoFecha(form.getMant_control_fec()));
/* 1195:1221 */       if (form.getVehi_fechaencero().compareTo(form.getTempcero()) == 1) {
/* 1196:1222 */         form.setVehi_fechaencero(ManejoFechas.FormateoFecha(form.getVehi_fechaencero()));
/* 1197:     */       } else {
/* 1198:1224 */         form.setVehi_fechaencero(ManejoFechas.FormateoFecha(form.getTempcero()));
/* 1199:     */       }
/* 1200:1227 */       form.setTempcero(ManejoFechas.FormateoFecha(form.getTempcero()));
/* 1201:     */       
/* 1202:     */ 
/* 1203:1230 */       String str = form.getRevisionesBloqueadasA();
/* 1204:1231 */       if (str.compareTo("-1") == 0) {
/* 1205:1232 */         str = "";
/* 1206:     */       }
/* 1207:1237 */       RevisionAlternativaDAO revisionAlternativaDAO = new RevisionAlternativaDAO();
/* 1208:1238 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1209:1239 */         revisionAlternativaDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1210:     */       }
/* 1211:1241 */       revisionAlternativaDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 1212:1242 */       List revisionAlternativas = revisionAlternativaDAO.list();
/* 1213:1243 */       request.setAttribute("alternativas", revisionAlternativas);
/* 1214:     */       
/* 1215:1245 */       RevisionAccionDAO revisionAccionDAO = new RevisionAccionDAO();
/* 1216:1246 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1217:1247 */         revisionAccionDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1218:     */       }
/* 1219:1249 */       revisionAccionDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 1220:1250 */       List revisionAcciones = revisionAccionDAO.list();
/* 1221:1251 */       request.setAttribute("acciones", revisionAcciones);
/* 1222:     */       
/* 1223:1253 */       MarcasAutosDAO marcasAutoDAO = new MarcasAutosDAO();
/* 1224:1254 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1225:1255 */         marcasAutoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1226:     */       }
/* 1227:1257 */       marcasAutoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 1228:1258 */       List marcasAuto = marcasAutoDAO.list();
/* 1229:1259 */       request.setAttribute("MARCASAUTOS", marcasAuto);
/* 1230:     */       
/* 1231:1261 */       List revisionesVehiculo = (List)request.getSession().getAttribute("REVISIONES");
/* 1232:1262 */       BigDecimal bloqueado = BigDecimal.TEN;
/* 1233:1263 */       int x = 0;
/* 1234:1265 */       while (x < revisionesVehiculo.size())
/* 1235:     */       {
/* 1236:1266 */         if (str.length() > 0)
/* 1237:     */         {
/* 1238:1267 */           String[] arrayBloqueadas = str.split(",");
/* 1239:1268 */           for (int contador = 0; contador < arrayBloqueadas.length; contador++)
/* 1240:     */           {
/* 1241:1269 */             if (request.getParameter("mantenimientosBasicos" + x) != null)
/* 1242:     */             {
/* 1243:1270 */               ((RevisionesVehiculo)revisionesVehiculo.get(x)).setRveh_control_fec(new BigDecimal(ManejoFechas.getChangeFecha(form.getFechaMantenimientosBasicos())));
/* 1244:1271 */               ((RevisionesVehiculo)revisionesVehiculo.get(x)).setRveh_control_kms(new BigDecimal(form.getDistanciaMantenimientosBasicos()));
/* 1245:1272 */               ((RevisionesVehiculo)revisionesVehiculo.get(x)).setRveh_bloqueado(new BigDecimal("2"));
/* 1246:     */             }
/* 1247:1274 */             request.setAttribute("rveh_acc_des" + x, revisionAccionDAO.retrive(((RevisionesVehiculo)revisionesVehiculo.get(x)).getRveh_acc_cod()).getRacc_cod().toString());
/* 1248:1275 */             request.setAttribute("rveh_alt_cod" + x, revisionAlternativaDAO.retrive(((RevisionesVehiculo)revisionesVehiculo.get(x)).getRveh_alt_cod()).getRalt_des());
/* 1249:1276 */             int valornuevo = new Integer(arrayBloqueadas[contador]).intValue();
/* 1250:1277 */             if (x == valornuevo - 1) {
/* 1251:1278 */               ((RevisionesVehiculo)revisionesVehiculo.get(x)).setRveh_bloqueado(BigDecimal.ONE);
/* 1252:     */             }
/* 1253:     */           }
/* 1254:     */         }
/* 1255:     */         else
/* 1256:     */         {
/* 1257:1283 */           if (request.getParameter("mantenimientosBasicos" + x) != null)
/* 1258:     */           {
/* 1259:1284 */             bloqueado = ((RevisionesVehiculo)revisionesVehiculo.get(x)).getRveh_bloqueado();
/* 1260:1285 */             if (bloqueado.compareTo(BigDecimal.ONE) == 0) {
/* 1261:1286 */               ((RevisionesVehiculo)revisionesVehiculo.get(x)).setRveh_bloqueado(BigDecimal.ZERO);
/* 1262:     */             }
/* 1263:1288 */             ((RevisionesVehiculo)revisionesVehiculo.get(x)).setRveh_control_fec(new BigDecimal(ManejoFechas.getChangeFecha(form.getFechaMantenimientosBasicos())));
/* 1264:1289 */             ((RevisionesVehiculo)revisionesVehiculo.get(x)).setRveh_control_kms(new BigDecimal(form.getDistanciaMantenimientosBasicos()));
/* 1265:     */           }
/* 1266:1292 */           request.setAttribute("rveh_acc_des" + x, revisionAccionDAO.retrive(((RevisionesVehiculo)revisionesVehiculo.get(x)).getRveh_acc_cod()).getRacc_cod().toString());
/* 1267:1293 */           request.setAttribute("rveh_alt_cod" + x, revisionAlternativaDAO.retrive(((RevisionesVehiculo)revisionesVehiculo.get(x)).getRveh_alt_cod()).getRalt_des());
/* 1268:     */         }
/* 1269:1297 */         x++;
/* 1270:     */       }
/* 1271:1302 */       List combustibles = (List)request.getSession().getAttribute("COMBUSTIBLEVEHICULO");
/* 1272:1303 */       request.setAttribute("COMBUSTIBLEVEHICULO", combustibles);
/* 1273:     */       
/* 1274:1305 */       IdiomaDAO idiomaDAO = new IdiomaDAO();
/* 1275:1306 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1276:1307 */         idiomaDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1277:     */       }
/* 1278:1309 */       request.setAttribute("IDIOMAS", idiomaDAO.list());
/* 1279:     */     }
/* 1280:     */     catch (Exception e)
/* 1281:     */     {
/* 1282:1313 */       e.printStackTrace();
/* 1283:1314 */       return mapping.findForward("failure");
/* 1284:     */     }
/* 1285:1317 */     return mapping.findForward("success");
/* 1286:     */   }
/* 1287:     */   
/* 1288:     */   private ActionForward performRemove(String myaction, ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 1289:     */   {
/* 1290:1321 */     VehiculosCompletoForm form = (VehiculosCompletoForm)actionForm;
/* 1291:     */     try
/* 1292:     */     {
/* 1293:1323 */       request.setAttribute("nuevo", "0");
/* 1294:1324 */       VehiculosCompletoDAO vehiculosCompletoDAO = new VehiculosCompletoDAO();
/* 1295:1325 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 1296:1326 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1297:1327 */         vehiculosCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1298:     */       }
/* 1299:1329 */       vehiculosCompletoDAO.delete(new BigDecimal(request.getParameter("vehi_cod")));
/* 1300:     */     }
/* 1301:     */     catch (Exception e)
/* 1302:     */     {
/* 1303:1332 */       e.printStackTrace();
/* 1304:1333 */       return mapping.findForward("failure");
/* 1305:     */     }
/* 1306:1335 */     return mapping.findForward("success");
/* 1307:     */   }
/* 1308:     */   
/* 1309:     */   private ActionForward performList(String myaction, ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 1310:     */   {
/* 1311:1339 */     VehiculosCompletoForm form = (VehiculosCompletoForm)actionForm;
/* 1312:     */     try
/* 1313:     */     {
/* 1314:1341 */       UsuarioCar usuarioCar = (UsuarioCar)request.getSession().getAttribute("usuarioCar");
/* 1315:     */       
/* 1316:1343 */       VehiculosDAO vehiculosDAO = new VehiculosDAO();
/* 1317:1344 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 1318:1345 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1319:1346 */         vehiculosDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1320:     */       }
/* 1321:1348 */       List vehiculos = vehiculosDAO.list(usuarioCar.getUsuc_cod());
/* 1322:     */       
/* 1323:1350 */       TipoVehiculoDAO tipoVehiculoDAO = new TipoVehiculoDAO();
/* 1324:1351 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1325:1352 */         tipoVehiculoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1326:     */       }
/* 1327:1354 */       tipoVehiculoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 1328:1355 */       int x = 0;
/* 1329:1356 */       while (x < vehiculos.size())
/* 1330:     */       {
/* 1331:1357 */         request.setAttribute("tveh_des" + x, tipoVehiculoDAO.retrive(((Vehiculos)vehiculos.get(x)).getVehi_tveh_cod()).getTveh_des());
/* 1332:1358 */         x++;
/* 1333:     */       }
/* 1334:1361 */       MarcasAutosDAO marcasAutoDAO = new MarcasAutosDAO();
/* 1335:1362 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1336:1363 */         marcasAutoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1337:     */       }
/* 1338:1365 */       marcasAutoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 1339:1366 */       x = 0;
/* 1340:1367 */       while (x < vehiculos.size())
/* 1341:     */       {
/* 1342:1368 */         request.setAttribute("mveh_des" + x, marcasAutoDAO.retrive(((Vehiculos)vehiculos.get(x)).getVehi_maut_cod()).getMaut_des());
/* 1343:1369 */         x++;
/* 1344:     */       }
/* 1345:1372 */       request.setAttribute("VEHICULOS", vehiculos);
/* 1346:     */     }
/* 1347:     */     catch (Exception e)
/* 1348:     */     {
/* 1349:1375 */       e.printStackTrace();
/* 1350:1376 */       return mapping.findForward("failure");
/* 1351:     */     }
/* 1352:1379 */     return mapping.findForward("success");
/* 1353:     */   }
/* 1354:     */   
/* 1355:     */   private ActionForward performCurva(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 1356:     */   {
/* 1357:1383 */     VehiculosCompletoForm form = (VehiculosCompletoForm)actionForm;
/* 1358:     */     try
/* 1359:     */     {
/* 1360:1385 */       UsuarioCar usuarioCar = (UsuarioCar)request.getSession().getAttribute("usuarioCar");
/* 1361:     */       
/* 1362:1387 */       VehiculosDAO vehiculosDAO = new VehiculosDAO();
/* 1363:1388 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 1364:1389 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1365:1390 */         vehiculosDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1366:     */       }
/* 1367:1393 */       List vehiculos = vehiculosDAO.list(usuarioCar.getUsuc_cod());
/* 1368:1395 */       if (vehiculos.isEmpty()) {
/* 1369:1396 */         return mapping.findForward("vehiculo");
/* 1370:     */       }
/* 1371:1398 */       Vehiculos vehiculo = (Vehiculos)vehiculos.get(0);
/* 1372:     */       
/* 1373:1400 */       BeanUtils.copyProperties(form, vehiculo);
/* 1374:     */     }
/* 1375:     */     catch (Exception e)
/* 1376:     */     {
/* 1377:1404 */       e.printStackTrace();
/* 1378:1405 */       return mapping.findForward("failure");
/* 1379:     */     }
/* 1380:1408 */     return mapping.findForward("success");
/* 1381:     */   }
/* 1382:     */   
/* 1383:     */   private ActionForward performAspectos(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 1384:     */   {
/* 1385:1414 */     VehiculosCompletoForm form = (VehiculosCompletoForm)actionForm;
/* 1386:     */     
/* 1387:     */ 
/* 1388:     */ 
/* 1389:     */ 
/* 1390:     */ 
/* 1391:     */ 
/* 1392:     */ 
/* 1393:1422 */     return mapping.findForward("success");
/* 1394:     */   }
/* 1395:     */   
/* 1396:     */   private ActionForward performCancelar(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 1397:     */   {
/* 1398:1426 */     VehiculosCompletoForm form = (VehiculosCompletoForm)actionForm;
/* 1399:     */     
/* 1400:     */ 
/* 1401:     */ 
/* 1402:     */ 
/* 1403:     */ 
/* 1404:     */ 
/* 1405:     */ 
/* 1406:1434 */     return mapping.findForward("success");
/* 1407:     */   }
/* 1408:     */   
/* 1409:     */   private ActionForward performOdometro(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 1410:     */   {
/* 1411:1437 */     VehiculosCompletoForm form = (VehiculosCompletoForm)actionForm;
/* 1412:     */     try
/* 1413:     */     {
/* 1414:1439 */       VehiculosCompletoDAO vehiculosCompletoDAO = new VehiculosCompletoDAO();
/* 1415:1440 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 1416:1441 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1417:1442 */         vehiculosCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1418:     */       }
/* 1419:1444 */       VehiculosDAO vehiculosDAO = new VehiculosDAO();
/* 1420:1445 */       UsuarioCar usuarioCar = (UsuarioCar)request.getSession().getAttribute("usuarioCar");
/* 1421:1446 */       List vehiculos = vehiculosDAO.list(usuarioCar.getUsuc_cod());
/* 1422:1450 */       if (vehiculos.isEmpty()) {
/* 1423:1451 */         return mapping.findForward("vehiculo");
/* 1424:     */       }
/* 1425:1453 */       Vehiculos vehiculo = (Vehiculos)vehiculos.get(0);
/* 1426:     */       
/* 1427:1455 */       BeanUtils.copyProperties(form, vehiculo);
/* 1428:     */       
/* 1429:     */ 
/* 1430:     */ 
/* 1431:1459 */       TipoVehiculoDAO tipoVehiculoDAO = new TipoVehiculoDAO();
/* 1432:1460 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1433:1461 */         tipoVehiculoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1434:     */       }
/* 1435:1463 */       tipoVehiculoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 1436:1464 */       int x = 0;
/* 1437:1465 */       while (x < vehiculos.size())
/* 1438:     */       {
/* 1439:1466 */         request.setAttribute("tveh_des" + x, tipoVehiculoDAO.retrive(((Vehiculos)vehiculos.get(x)).getVehi_tveh_cod()).getTveh_des());
/* 1440:1467 */         x++;
/* 1441:     */       }
/* 1442:1470 */       MarcasAutosDAO marcasAutoDAO = new MarcasAutosDAO();
/* 1443:1471 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1444:1472 */         marcasAutoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1445:     */       }
/* 1446:1474 */       marcasAutoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 1447:1475 */       x = 0;
/* 1448:1476 */       while (x < vehiculos.size())
/* 1449:     */       {
/* 1450:1477 */         request.setAttribute("mveh_des" + x, marcasAutoDAO.retrive(((Vehiculos)vehiculos.get(x)).getVehi_maut_cod()).getMaut_des());
/* 1451:1478 */         x++;
/* 1452:     */       }
/* 1453:1483 */       int y = 0;
/* 1454:1484 */       BigDecimal numeroVehiculo = ((Vehiculos)vehiculos.get(y)).getVehi_cod();
/* 1455:1485 */       VehiculosCompleto vehiculosCompleto = vehiculosCompletoDAO.retrieve(numeroVehiculo);
/* 1456:     */       
/* 1457:1487 */       request.getSession().setAttribute("vehiculo", vehiculosCompleto.getVehiculo());
/* 1458:1488 */       form.setVehi_fechaodometro(ManejoFechas.FormateoFecha(((Vehiculos)vehiculos.get(y)).getVehi_fechaodometro().toString()));
/* 1459:1489 */       form.setVehi_kmsact(((Vehiculos)vehiculos.get(y)).getVehi_kmsact().toString());
/* 1460:1490 */       form.setVehi_fechaencero(ManejoFechas.FormateoFecha(((Vehiculos)vehiculos.get(y)).getVehi_fechaencero().toString()));
/* 1461:1491 */       form.setVehi_cod(ManejoFechas.FormateoFecha(((Vehiculos)vehiculos.get(y)).getVehi_cod().toString()));
/* 1462:     */     }
/* 1463:     */     catch (Exception e)
/* 1464:     */     {
/* 1465:1494 */       e.printStackTrace();
/* 1466:1495 */       return mapping.findForward("failure");
/* 1467:     */     }
/* 1468:1498 */     return mapping.findForward("success");
/* 1469:     */   }
/* 1470:     */   
/* 1471:     */   private ActionForward performDelList(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 1472:     */   {
/* 1473:1501 */     VehiculosCompletoForm form = (VehiculosCompletoForm)actionForm;
/* 1474:     */     try
/* 1475:     */     {
/* 1476:1503 */       UsuarioCar usuarioCar = (UsuarioCar)request.getSession().getAttribute("usuarioCar");
/* 1477:     */       
/* 1478:1505 */       VehiculosDAO vehiculosDAO = new VehiculosDAO();
/* 1479:1506 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 1480:1507 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1481:1508 */         vehiculosDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1482:     */       }
/* 1483:1510 */       List vehiculos = vehiculosDAO.list(usuarioCar.getUsuc_cod());
/* 1484:     */       
/* 1485:1512 */       TipoVehiculoDAO tipoVehiculoDAO = new TipoVehiculoDAO();
/* 1486:1513 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1487:1514 */         tipoVehiculoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1488:     */       }
/* 1489:1516 */       tipoVehiculoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 1490:1517 */       int x = 0;
/* 1491:1518 */       while (x < vehiculos.size())
/* 1492:     */       {
/* 1493:1519 */         request.setAttribute("tveh_des" + x, tipoVehiculoDAO.retrive(((Vehiculos)vehiculos.get(x)).getVehi_tveh_cod()).getTveh_des());
/* 1494:1520 */         x++;
/* 1495:     */       }
/* 1496:1523 */       MarcasAutosDAO marcasAutoDAO = new MarcasAutosDAO();
/* 1497:1524 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1498:1525 */         marcasAutoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1499:     */       }
/* 1500:1527 */       marcasAutoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 1501:1528 */       x = 0;
/* 1502:1529 */       while (x < vehiculos.size())
/* 1503:     */       {
/* 1504:1530 */         request.setAttribute("mveh_des" + x, marcasAutoDAO.retrive(((Vehiculos)vehiculos.get(x)).getVehi_maut_cod()).getMaut_des());
/* 1505:1531 */         x++;
/* 1506:     */       }
/* 1507:1534 */       request.setAttribute("VEHICULOS", vehiculos);
/* 1508:     */     }
/* 1509:     */     catch (Exception e)
/* 1510:     */     {
/* 1511:1537 */       e.printStackTrace();
/* 1512:1538 */       return mapping.findForward("failure");
/* 1513:     */     }
/* 1514:1541 */     return mapping.findForward("success");
/* 1515:     */   }
/* 1516:     */   
/* 1517:     */   private ActionForward performSaveOdometro(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 1518:     */   {
/* 1519:1544 */     VehiculosCompletoForm form = (VehiculosCompletoForm)actionForm;
/* 1520:     */     try
/* 1521:     */     {
/* 1522:1547 */       UsuarioCar usuarioCar = (UsuarioCar)request.getSession().getAttribute("usuarioCar");
/* 1523:1548 */       Vehiculos vehiculo = (Vehiculos)request.getSession().getAttribute("vehiculo");
/* 1524:1549 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 1525:1550 */       VehiculosCompleto vehiculosCompleto = new VehiculosCompleto();
/* 1526:1551 */       vehiculosCompleto.setVehiculo(vehiculo);
/* 1527:1552 */       VehiculosDAO vehiculosDAO = new VehiculosDAO();
/* 1528:1553 */       Vehiculos vehiculosR = vehiculosDAO.retrieveCarByUser(usuarioCar.getUsuc_cod());
/* 1529:1554 */       RevisionesVehiculoDAO revisionesVehiculoDAO = new RevisionesVehiculoDAO();
/* 1530:1555 */       MantenimientoGeneralDAO mantenimientoGeneralDao2 = new MantenimientoGeneralDAO();
/* 1531:1556 */       MantenimientoGeneral mantenimientoGeneral = mantenimientoGeneralDao2.retrive(BigDecimal.ONE, vehiculosR.getVehi_cod());
/* 1532:1557 */       form.setVehi_placa(vehiculosR.getVehi_placa());
/* 1533:1558 */       form.setVehi_modelo(vehiculosR.getVehi_modelo().toString());
/* 1534:1559 */       form.setVehi_feccomp(vehiculosR.getVehi_feccomp().toString());
/* 1535:1560 */       form.setVehi_tveh_cod(vehiculosR.getVehi_tveh_cod().toString());
/* 1536:1561 */       form.setVehi_fecinscripcion(vehiculosR.getVehi_fecinscripcion().toString());
/* 1537:1562 */       form.setVehi_tipo(vehiculosR.getVehi_tipo().toString());
/* 1538:1563 */       form.setVehi_maut_cod(vehiculosR.getVehi_maut_cod().toString());
/* 1539:     */       
/* 1540:1565 */       BigDecimal FechaOdometroCero = BigDecimal.ZERO;
/* 1541:1566 */       BigDecimal FechaCompra = BigDecimal.ZERO;
/* 1542:1567 */       BigDecimal FechaOdometroInicial = BigDecimal.ZERO;
/* 1543:1568 */       BigDecimal FechaOdometro = BigDecimal.ZERO;
/* 1544:1569 */       BigDecimal DistanciaOdometro = BigDecimal.ZERO;
/* 1545:1570 */       BigDecimal DistanciaOdometroInicial = BigDecimal.ZERO;
/* 1546:1571 */       List revisiones2 = revisionesVehiculoDAO.list2(vehiculosR.getVehi_cod());
/* 1547:1572 */       List revisiones = (List)request.getSession().getAttribute("REVISIONES");
/* 1548:1573 */       SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
/* 1549:1574 */       SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
/* 1550:1576 */       if (form.getOdometroBloqueado().compareTo(new String("1")) == 0) {
/* 1551:1577 */         vehiculo.setVehi_bloqueado(BigDecimal.ONE);
/* 1552:     */       }
/* 1553:1579 */       if (form.getMntnmntoBloqueado().compareTo(new String("1")) == 0) {
/* 1554:1580 */         mantenimientoGeneral.setMant_bloqueado(BigDecimal.ONE);
/* 1555:     */       }
/* 1556:1584 */       if (vehiculo.getVehi_fechaencero().compareTo(BigDecimal.ZERO) != 0)
/* 1557:     */       {
/* 1558:1586 */         FechaOdometroCero = vehiculo.getVehi_fechaencero();
/* 1559:1588 */         if (vehiculo.getVehi_feccomp().compareTo(BigDecimal.ZERO) != 0) {
/* 1560:1589 */           FechaCompra = vehiculo.getVehi_feccomp();
/* 1561:     */         }
/* 1562:1592 */         if (vehiculo.getVehi_fechaodometroinicial().compareTo(BigDecimal.ZERO) != 0) {
/* 1563:1593 */           FechaOdometroInicial = vehiculo.getVehi_fechaodometroinicial();
/* 1564:     */         }
/* 1565:1596 */         if (vehiculo.getVehi_fechaodometro().compareTo(BigDecimal.ZERO) != 0) {
/* 1566:1597 */           FechaOdometro = vehiculo.getVehi_fechaodometro();
/* 1567:     */         }
/* 1568:1600 */         if (vehiculo.getVehi_kmsact().compareTo(BigDecimal.ZERO) != 0) {
/* 1569:1601 */           DistanciaOdometro = vehiculo.getVehi_kmsact();
/* 1570:     */         }
/* 1571:1604 */         if (vehiculo.getVehi_kmsodometroinicial().compareTo(BigDecimal.ZERO) != 0) {
/* 1572:1605 */           DistanciaOdometroInicial = vehiculo.getVehi_kmsodometroinicial();
/* 1573:     */         }
/* 1574:1608 */         BigDecimal[] curva = { vehiculo.getVehi_enero().divideToIntegralValue(new BigDecimal(31.0D)), 
/* 1575:1609 */           vehiculo.getVehi_febrero().divideToIntegralValue(new BigDecimal(28.0D)), 
/* 1576:1610 */           vehiculo.getVehi_marzo().divideToIntegralValue(new BigDecimal(31.0D)), 
/* 1577:1611 */           vehiculo.getVehi_abril().divideToIntegralValue(new BigDecimal(30.0D)), 
/* 1578:1612 */           vehiculo.getVehi_mayo().divideToIntegralValue(new BigDecimal(31.0D)), 
/* 1579:1613 */           vehiculo.getVehi_junio().divideToIntegralValue(new BigDecimal(30.0D)), 
/* 1580:1614 */           vehiculo.getVehi_julio().divideToIntegralValue(new BigDecimal(31.0D)), 
/* 1581:1615 */           vehiculo.getVehi_agosto().divideToIntegralValue(new BigDecimal(31.0D)), 
/* 1582:1616 */           vehiculo.getVehi_septiembre().divideToIntegralValue(new BigDecimal(30.0D)), 
/* 1583:1617 */           vehiculo.getVehi_octubre().divideToIntegralValue(new BigDecimal(31.0D)), 
/* 1584:1618 */           vehiculo.getVehi_noviembre().divideToIntegralValue(new BigDecimal(30.0D)), 
/* 1585:1619 */           vehiculo.getVehi_diciembre().divideToIntegralValue(new BigDecimal(31.0D)) };
/* 1586:     */         
/* 1587:1621 */         Iterator rev_iterator2 = revisiones2.iterator();
/* 1588:1622 */         int DistanciaAcumulada = 0;int opcion = 0;
/* 1589:1623 */         BigDecimal fechaCercanaCero = BigDecimal.ZERO;
/* 1590:1624 */         BigDecimal distanciaCercanaCero = BigDecimal.ZERO;
/* 1591:     */         
/* 1592:1626 */         int Diferencia = 90000000;
/* 1593:1628 */         while (rev_iterator2.hasNext())
/* 1594:     */         {
/* 1595:1629 */           RevisionesVehiculo revision = (RevisionesVehiculo)rev_iterator2.next();
/* 1596:1630 */           if (revision.getRveh_bloqueado().compareTo(BigDecimal.ZERO) == 0)
/* 1597:     */           {
/* 1598:1631 */             int Diferencia2 = vehiculo.getVehi_fechaencero().intValue() - revision.getRveh_control_fec().intValue();
/* 1599:1632 */             if ((Diferencia2 > 0) && (Diferencia2 < Diferencia))
/* 1600:     */             {
/* 1601:1633 */               fechaCercanaCero = revision.getRveh_control_fec();
/* 1602:1634 */               distanciaCercanaCero = revision.getRveh_control_kms();
/* 1603:1635 */               Diferencia = Diferencia2;
/* 1604:     */             }
/* 1605:     */           }
/* 1606:     */         }
/* 1607:1642 */         while (rev_iterator2.hasNext())
/* 1608:     */         {
/* 1609:1643 */           RevisionesVehiculo revision = (RevisionesVehiculo)rev_iterator2.next();
/* 1610:1644 */           BigDecimal DistanciaUltimaControl = BigDecimal.ZERO;
/* 1611:1645 */           if (revision.getRveh_bloqueado().compareTo(BigDecimal.ZERO) == 0)
/* 1612:     */           {
/* 1613:1647 */             if (revision.getRveh_control_kms() != BigDecimal.ZERO) {
/* 1614:1648 */               DistanciaUltimaControl = revision.getRveh_control_kms();
/* 1615:     */             }
/* 1616:1650 */             BigDecimal FechaUltimaControl = BigDecimal.ZERO;
/* 1617:1651 */             if (revision.getRveh_control_fec() != BigDecimal.ZERO) {
/* 1618:1652 */               FechaUltimaControl = revision.getRveh_control_fec();
/* 1619:     */             }
/* 1620:1655 */             if (FechaCompra.compareTo(BigDecimal.ZERO) == 1)
/* 1621:     */             {
/* 1622:1656 */               DistanciaAcumulada = FechaCompra.intValue();
/* 1623:1657 */               opcion = 1;
/* 1624:     */             }
/* 1625:1660 */             if (FechaOdometroInicial.compareTo(new BigDecimal(DistanciaAcumulada)) == 1)
/* 1626:     */             {
/* 1627:1661 */               DistanciaAcumulada = FechaOdometroInicial.intValue();
/* 1628:1662 */               opcion = 2;
/* 1629:     */             }
/* 1630:1665 */             if (FechaUltimaControl.compareTo(new BigDecimal(DistanciaAcumulada)) == 1)
/* 1631:     */             {
/* 1632:1666 */               DistanciaAcumulada = FechaUltimaControl.intValue();
/* 1633:1667 */               opcion = 3;
/* 1634:     */             }
/* 1635:1669 */             if (fechaCercanaCero.compareTo(new BigDecimal(DistanciaAcumulada)) == 1)
/* 1636:     */             {
/* 1637:1670 */               DistanciaAcumulada = distanciaCercanaCero.intValue();
/* 1638:1671 */               opcion = 4;
/* 1639:     */             }
/* 1640:1673 */             BigDecimal fechaInicial = BigDecimal.ZERO;
/* 1641:1674 */             BigDecimal DistanciaInicial = BigDecimal.ZERO;
/* 1642:1675 */             switch (opcion)
/* 1643:     */             {
/* 1644:     */             case 2: 
/* 1645:1676 */               fechaInicial = FechaOdometroInicial;
/* 1646:1677 */               DistanciaInicial = DistanciaOdometroInicial;
/* 1647:1678 */               break;
/* 1648:     */             case 3: 
/* 1649:1679 */               fechaInicial = FechaUltimaControl;
/* 1650:1680 */               DistanciaInicial = DistanciaUltimaControl;
/* 1651:1681 */               break;
/* 1652:     */             case 4: 
/* 1653:1682 */               fechaInicial = fechaCercanaCero;
/* 1654:1683 */               DistanciaInicial = distanciaCercanaCero;
/* 1655:     */             }
/* 1656:1686 */             Calendar fechaSimulada = new GregorianCalendar();
/* 1657:1687 */             fechaSimulada.setTime(sdf.parse(fechaInicial.toString()));
/* 1658:1689 */             if (fechaInicial.compareTo(FechaOdometroCero) == 0) {
/* 1659:1690 */               revision.setRveh_kmscero(DistanciaInicial);
/* 1660:     */             } else {
/* 1661:1692 */               while (fechaInicial.compareTo(FechaOdometroCero) < 1)
/* 1662:     */               {
/* 1663:1694 */                 DistanciaInicial = DistanciaInicial.add(curva[fechaSimulada.get(2)]);
/* 1664:1695 */                 fechaSimulada.add(6, 1);
/* 1665:1696 */                 fechaInicial = new BigDecimal(sdf.format(fechaSimulada.getTime()));
/* 1666:     */               }
/* 1667:     */             }
/* 1668:1700 */             revision.setRveh_kmscero(DistanciaInicial);
/* 1669:     */           }
/* 1670:     */         }
/* 1671:     */       }
/* 1672:1706 */       vehiculosCompleto.setRevisiones(revisiones2);
/* 1673:1713 */       if (form.getPveh_indpais1().length() == 0) {
/* 1674:1714 */         form.setPveh_indpais1("0");
/* 1675:     */       }
/* 1676:1716 */       if (form.getPveh_indciudad1().length() == 0) {
/* 1677:1717 */         form.setPveh_indciudad1("0");
/* 1678:     */       }
/* 1679:1719 */       if (form.getPveh_indpais2().length() == 0) {
/* 1680:1720 */         form.setPveh_indpais2("0");
/* 1681:     */       }
/* 1682:1722 */       if (Integer.parseInt(form.getVehi_num_dias_no_mail()) < 2) {
/* 1683:1723 */         form.setVehi_num_dias_no_mail("2");
/* 1684:     */       }
/* 1685:1730 */       BigDecimal distanciaReferencia = BigDecimal.ZERO;
/* 1686:1731 */       BigDecimal diferenciaMenorA = new BigDecimal(10000000);
/* 1687:1732 */       BigDecimal diferenciaMenorB = new BigDecimal(10000000);
/* 1688:1733 */       String fechaencero = form.getVehi_fechaencero().toString();
/* 1689:1734 */       String fechaodometro = form.getVehi_fechaodometro().toString();
/* 1690:1735 */       String fechaCeroW = null;
/* 1691:1736 */       String fechaOdometroW = new String();
/* 1692:1737 */       StringBuffer fechaCeroa = new StringBuffer();
/* 1693:1738 */       StringBuffer fechaOdometroa = new StringBuffer();
/* 1694:1739 */       if (fechaodometro.length() == 10)
/* 1695:     */       {
/* 1696:1740 */         fechaOdometroa.replace(0, fechaodometro.length(), fechaodometro.toString());
/* 1697:1741 */         fechaOdometroW = fechaOdometroa.substring(0, 4);
/* 1698:1742 */         fechaOdometroW = fechaOdometroW + fechaOdometroa.substring(5, 7);
/* 1699:1743 */         fechaOdometroW = fechaOdometroW + fechaOdometroa.substring(8, 10);
/* 1700:1744 */         form.setVehi_fechaodometro(fechaOdometroW);
/* 1701:     */       }
/* 1702:1746 */       if (fechaodometro.length() == 8)
/* 1703:     */       {
/* 1704:1747 */         fechaOdometroa.replace(0, fechaodometro.length(), fechaodometro.toString());
/* 1705:1748 */         fechaOdometroW = fechaOdometroa.substring(0, 8);
/* 1706:1749 */         form.setVehi_fechaodometro(fechaOdometroW);
/* 1707:     */       }
/* 1708:1755 */       if (fechaencero.length() == 10)
/* 1709:     */       {
/* 1710:1756 */         fechaCeroa.replace(0, fechaencero.length(), fechaencero.toString());
/* 1711:1757 */         fechaCeroW = fechaCeroa.substring(0, 4);
/* 1712:1758 */         fechaCeroW = fechaCeroW + fechaCeroa.substring(5, 7);
/* 1713:1759 */         fechaCeroW = fechaCeroW + fechaCeroa.substring(8, 10);
/* 1714:1760 */         form.setVehi_fechaencero(fechaCeroW);
/* 1715:     */       }
/* 1716:1762 */       if (fechaencero.length() == 8)
/* 1717:     */       {
/* 1718:1763 */         fechaCeroa.replace(0, fechaencero.length(), fechaencero.toString());
/* 1719:1764 */         fechaCeroW = fechaCeroa.substring(0, 8);
/* 1720:1765 */         form.setVehi_fechaencero(fechaCeroW);
/* 1721:     */       }
/* 1722:1767 */       Integer fechacero = Integer.valueOf(0);
/* 1723:1768 */       if (fechaCeroW != null) {
/* 1724:1769 */         fechacero = new Integer(fechaCeroW);
/* 1725:     */       } else {
/* 1726:1771 */         fechacero = Integer.valueOf(0);
/* 1727:     */       }
/* 1728:1774 */       BigDecimal fechaReferenciaInicial = new BigDecimal(fechacero.intValue());
/* 1729:1775 */       BigDecimal fechaReferenciaInicial0 = new BigDecimal(fechacero.intValue());
/* 1730:1776 */       BigDecimal distanciaReferenciaInicial = BigDecimal.ZERO;
/* 1731:1777 */       if (vehiculo.getVehi_fechaodometro().compareTo(fechaReferenciaInicial) == -1)
/* 1732:     */       {
/* 1733:1779 */         diferenciaMenorA = fechaReferenciaInicial.subtract(vehiculo.getVehi_fechaodometro());
/* 1734:1780 */         fechaReferenciaInicial = vehiculo.getVehi_fechaodometro();
/* 1735:1781 */         distanciaReferenciaInicial = vehiculo.getVehi_kmsact();
/* 1736:     */       }
/* 1737:1783 */       diferenciaMenorB = fechaReferenciaInicial.subtract(mantenimientoGeneral.getMant_control_fec());
/* 1738:1784 */       if ((diferenciaMenorB.intValue() < diferenciaMenorA.intValue()) && (diferenciaMenorB.intValue() > 0))
/* 1739:     */       {
/* 1740:1785 */         fechaReferenciaInicial = mantenimientoGeneral.getMant_control_fec();
/* 1741:1786 */         distanciaReferenciaInicial = mantenimientoGeneral.getMant_control_kms();
/* 1742:1787 */         diferenciaMenorA = diferenciaMenorB;
/* 1743:     */       }
/* 1744:1790 */       for (Iterator revisionesIterator = revisiones2.iterator(); revisionesIterator.hasNext();)
/* 1745:     */       {
/* 1746:1791 */         RevisionesVehiculo revisionVehiculoA = (RevisionesVehiculo)revisionesIterator.next();
/* 1747:1792 */         diferenciaMenorB = fechaReferenciaInicial0.subtract(revisionVehiculoA.getRveh_control_fec());
/* 1748:1793 */         if (revisionVehiculoA.getRveh_bloqueado().compareTo(BigDecimal.ZERO) == 0) {
/* 1749:1795 */           if ((diferenciaMenorB.intValue() < diferenciaMenorA.intValue()) && (diferenciaMenorB.intValue() > 0))
/* 1750:     */           {
/* 1751:1796 */             fechaReferenciaInicial = revisionVehiculoA.getRveh_control_fec();
/* 1752:1797 */             distanciaReferenciaInicial = revisionVehiculoA.getRveh_control_kms();
/* 1753:1798 */             diferenciaMenorA = diferenciaMenorB;
/* 1754:     */           }
/* 1755:     */         }
/* 1756:     */       }
/* 1757:1803 */       if (form.getVehi_fechaencero().toString().compareTo(new String("0")) != 0) {
/* 1758:1804 */         form.setVehi_kmsencero(ManejoFechas.getDistanciaOdometroCero(vehiculo, sdf.parse(fechaReferenciaInicial.toString()), distanciaReferenciaInicial, sdf.parse(form.getVehi_fechaencero().toString())));
/* 1759:     */       }
/* 1760:1807 */       PropietariosVehiculos propietariosVehiculos = new PropietariosVehiculos();
/* 1761:1808 */       vehiculosCompleto.setPropietario(propietariosVehiculos);
/* 1762:1809 */       InicializaData.inicializa(propietariosVehiculos.getClass(), propietariosVehiculos);
/* 1763:1810 */       BeanUtils.copyProperties(propietariosVehiculos, form);
/* 1764:     */       
/* 1765:     */ 
/* 1766:1813 */       ControlesVehiculosDAO controlesVehiculoDAO = new ControlesVehiculosDAO();
/* 1767:1814 */       List controles = controlesVehiculoDAO.list(vehiculosR.getVehi_cod());
/* 1768:1815 */       vehiculosCompleto.setControles(controles);
/* 1769:1816 */       InicializaData.inicializa(controles.getClass(), controles);
/* 1770:1817 */       BeanUtils.copyProperties(controles, form);
/* 1771:     */       
/* 1772:1819 */       SegurosVehiculosDAO segurosVehiculoDAO = new SegurosVehiculosDAO();
/* 1773:1820 */       List seguros = segurosVehiculoDAO.list(vehiculosR.getVehi_cod());
/* 1774:1821 */       vehiculosCompleto.setSeguros(seguros);
/* 1775:1822 */       InicializaData.inicializa(seguros.getClass(), seguros);
/* 1776:1823 */       BeanUtils.copyProperties(seguros, form);
/* 1777:     */       
/* 1778:1825 */       ImpuestoVehiculoDAO impuestoVehiculoDAO = new ImpuestoVehiculoDAO();
/* 1779:1826 */       List impuestos = impuestoVehiculoDAO.list(vehiculosR.getVehi_cod());
/* 1780:1827 */       vehiculosCompleto.setImpuestos(impuestos);
/* 1781:1828 */       InicializaData.inicializa(impuestos.getClass(), impuestos);
/* 1782:1829 */       BeanUtils.copyProperties(impuestos, form);
/* 1783:     */       
/* 1784:1831 */       GastosVehiculosNoAnualesDAO gastosNoAnualesDAO = new GastosVehiculosNoAnualesDAO();
/* 1785:1832 */       List gastosNoAnuales = gastosNoAnualesDAO.list(vehiculosR.getVehi_cod());
/* 1786:1833 */       vehiculosCompleto.setGastosNoAnuales(gastosNoAnuales);
/* 1787:1834 */       InicializaData.inicializa(gastosNoAnuales.getClass(), gastosNoAnuales);
/* 1788:1835 */       BeanUtils.copyProperties(gastosNoAnuales, form);
/* 1789:     */       
/* 1790:1837 */       GastosVehiculosAnualesDAO gastosAnualesDAO = new GastosVehiculosAnualesDAO();
/* 1791:1838 */       GastosVehiculosAnuales gastosanuales = new GastosVehiculosAnuales();
/* 1792:1839 */       List gastosAnuales = gastosAnualesDAO.list(vehiculosR.getVehi_cod());
/* 1793:1840 */       vehiculosCompleto.setGastosAnuales(gastosAnuales);
/* 1794:1841 */       InicializaData.inicializa(gastosAnuales.getClass(), gastosAnuales);
/* 1795:1842 */       BeanUtils.copyProperties(gastosAnuales, form);
/* 1796:     */       
/* 1797:     */ 
/* 1798:1845 */       GastosVehiculosMecanicaDAO gastosVehiculosMecanicaDAO = new GastosVehiculosMecanicaDAO();
/* 1799:1846 */       List gastosMecanicos = gastosVehiculosMecanicaDAO.list(vehiculosR.getVehi_cod());
/* 1800:1847 */       vehiculosCompleto.setGastosMecanica(gastosMecanicos);
/* 1801:1848 */       InicializaData.inicializa(gastosMecanicos.getClass(), gastosMecanicos);
/* 1802:1849 */       BeanUtils.copyProperties(gastosMecanicos, form);
/* 1803:     */       
/* 1804:     */ 
/* 1805:1852 */       CombustibleDAO combustibleDAO = new CombustibleDAO();
/* 1806:1853 */       List combustibles = combustibleDAO.list(vehiculosR.getVehi_cod());
/* 1807:1856 */       if ((!form.getCom_lecturaini().equals("0")) && (!form.getCom_lecturafin().equals("0")) && (!form.getCom_cantidadconsumo().equals("0")) && (!form.getCom_costocombustible().equals("0")) && (combustibles.size() < 5))
/* 1808:     */       {
/* 1809:1857 */         Combustible combustible = new Combustible();
/* 1810:1858 */         InicializaData.inicializa(combustible.getClass(), combustible);
/* 1811:1859 */         BeanUtils.copyProperties(combustible, form);
/* 1812:1860 */         combustible.setCom_veh_cod(vehiculo.getVehi_cod());
/* 1813:1861 */         combustibles.add(0, combustible);
/* 1814:     */       }
/* 1815:1863 */       vehiculosCompleto.setConsumosCombustible(combustibles);
/* 1816:     */       
/* 1817:     */ 
/* 1818:1866 */       VehiculosCompletoDAO vehiculosCompletoDAO = new VehiculosCompletoDAO();
/* 1819:1867 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1820:1868 */         vehiculosCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1821:     */       }
/* 1822:1872 */       BeanUtils.copyProperties(vehiculo, form);
/* 1823:1873 */       vehiculo.setVehi_usuc_cod(usuarioCar.getUsuc_cod());
/* 1824:     */       
/* 1825:1875 */       Date fechaActual = new Date();
/* 1826:     */       
/* 1827:1877 */       vehiculo.setVehi_registro(new BigDecimal(sdf2.format(fechaActual)));
/* 1828:     */       
/* 1829:1879 */       PropietariosVehiculos propietariosVehiculos2 = new PropietariosVehiculos();
/* 1830:1880 */       vehiculosCompleto.setPropietario(propietariosVehiculos2);
/* 1831:1881 */       InicializaData.inicializa(propietariosVehiculos2.getClass(), propietariosVehiculos2);
/* 1832:1882 */       BeanUtils.copyProperties(propietariosVehiculos2, form);
/* 1833:     */       
/* 1834:1884 */       vehiculosCompleto.setMantenimientoGeneral(mantenimientoGeneral);
/* 1835:1885 */       InicializaData.inicializa(mantenimientoGeneral.getClass(), mantenimientoGeneral);
/* 1836:1886 */       BeanUtils.copyProperties(mantenimientoGeneral, form);
/* 1837:1888 */       if (ManejoFechas.restaFechas(mantenimientoGeneral.getMant_control_fec().toString(), ManejoFechas.getFechaActual()) < 0) {
/* 1838:1889 */         mantenimientoGeneral.setMant_control_fec(new BigDecimal(ManejoFechas.getFechaActual()));
/* 1839:     */       }
/* 1840:1892 */       BigDecimal odo_actual = vehiculo.getVehi_kmsact();
/* 1841:     */       
/* 1842:     */ 
/* 1843:     */ 
/* 1844:1896 */       vehiculosCompletoDAO.update(vehiculosCompleto, vehiculo.getVehi_cod());
/* 1845:     */       
/* 1846:     */ 
/* 1847:     */ 
/* 1848:1900 */       GruposVehiculoDAO gruposVehiculoDAO = new GruposVehiculoDAO();
/* 1849:1901 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1850:1902 */         gruposVehiculoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1851:     */       }
/* 1852:1904 */       String[] llavesGrupos = { "grupv_cod", "grupv_vehi_cod" };
/* 1853:1905 */       GruposVehiculo gruposVehiculo = new GruposVehiculo();
/* 1854:1906 */       for (int i = 0; i < 3; i++)
/* 1855:     */       {
/* 1856:1907 */         switch (i)
/* 1857:     */         {
/* 1858:     */         case 0: 
/* 1859:1909 */           gruposVehiculo = gruposVehiculoDAO.search(vehiculosCompleto.getVehiculo().getVehi_cod(), IGrupos.CARS_CONTROLES);
/* 1860:1910 */           break;
/* 1861:     */         case 1: 
/* 1862:1912 */           gruposVehiculo = gruposVehiculoDAO.search(vehiculosCompleto.getVehiculo().getVehi_cod(), IGrupos.CARS_SEGUROS);
/* 1863:1913 */           break;
/* 1864:     */         case 2: 
/* 1865:1915 */           gruposVehiculo = gruposVehiculoDAO.search(vehiculosCompleto.getVehiculo().getVehi_cod(), IGrupos.CARS_IMPUESTOS);
/* 1866:     */         }
/* 1867:1918 */         switch (i)
/* 1868:     */         {
/* 1869:     */         case 0: 
/* 1870:1920 */           if (Integer.parseInt(form.getCveh_dias_antes()) < 2) {
/* 1871:1921 */             form.setCveh_dias_antes("2");
/* 1872:     */           }
/* 1873:1923 */           gruposVehiculo.setGrupv_dias_antes(new BigDecimal(form.getCveh_dias_antes()));
/* 1874:1924 */           break;
/* 1875:     */         case 1: 
/* 1876:1926 */           if (Integer.parseInt(form.getSveh_dias_antes()) < 2) {
/* 1877:1927 */             form.setSveh_dias_antes("2");
/* 1878:     */           }
/* 1879:1929 */           gruposVehiculo.setGrupv_dias_antes(new BigDecimal(form.getSveh_dias_antes()));
/* 1880:1930 */           break;
/* 1881:     */         case 2: 
/* 1882:1932 */           if (Integer.parseInt(form.getIveh_dias_antes()) < 2) {
/* 1883:1933 */             form.setIveh_dias_antes("2");
/* 1884:     */           }
/* 1885:1935 */           gruposVehiculo.setGrupv_dias_antes(new BigDecimal(form.getIveh_dias_antes()));
/* 1886:     */         }
/* 1887:1938 */         gruposVehiculoDAO.update(gruposVehiculo, llavesGrupos);
/* 1888:     */       }
/* 1889:1956 */       distanciaReferencia = BigDecimal.ZERO;
/* 1890:1957 */       fechaReferenciaInicial = BigDecimal.ZERO;
/* 1891:1958 */       Date fechaReferencia = null;
/* 1892:1959 */       distanciaReferenciaInicial = BigDecimal.ZERO;
/* 1893:1960 */       if ((vehiculo.getVehi_fechaodometro().compareTo(fechaReferenciaInicial) == 1) && 
/* 1894:1961 */         (vehiculo.getVehi_bloqueado().compareTo(BigDecimal.ZERO) == 0))
/* 1895:     */       {
/* 1896:1962 */         fechaReferenciaInicial = vehiculo.getVehi_fechaodometro();
/* 1897:1963 */         distanciaReferenciaInicial = vehiculo.getVehi_kmsact();
/* 1898:     */       }
/* 1899:1967 */       if ((mantenimientoGeneral.getMant_control_fec().compareTo(fechaReferenciaInicial) == 1) && 
/* 1900:1968 */         (mantenimientoGeneral.getMant_bloqueado().compareTo(BigDecimal.ZERO) == 0))
/* 1901:     */       {
/* 1902:1969 */         fechaReferenciaInicial = mantenimientoGeneral.getMant_control_fec();
/* 1903:1970 */         distanciaReferenciaInicial = mantenimientoGeneral.getMant_control_kms();
/* 1904:     */       }
/* 1905:1973 */       for (Iterator revisionesIterator = revisiones2.iterator(); revisionesIterator.hasNext();)
/* 1906:     */       {
/* 1907:1974 */         RevisionesVehiculo revisionVehiculo = (RevisionesVehiculo)revisionesIterator.next();
/* 1908:1975 */         if (revisionVehiculo.getRveh_bloqueado().compareTo(BigDecimal.ZERO) == 0) {
/* 1909:1977 */           if (revisionVehiculo.getRveh_control_fec().compareTo(fechaReferenciaInicial) == 1)
/* 1910:     */           {
/* 1911:1978 */             fechaReferenciaInicial = revisionVehiculo.getRveh_control_fec();
/* 1912:1979 */             distanciaReferenciaInicial = revisionVehiculo.getRveh_control_kms();
/* 1913:     */           }
/* 1914:     */         }
/* 1915:     */       }
/* 1916:1985 */       fechaReferencia = sdf.parse(fechaReferenciaInicial.toString());
/* 1917:1986 */       distanciaReferencia = distanciaReferenciaInicial;
/* 1918:     */       
/* 1919:     */ 
/* 1920:1989 */       StringBuffer ultimaFecha = ManejoFechas.getUltimaFechaPorUsuario(vehiculo.getVehi_usuc_cod(), revisiones2);
/* 1921:     */       
/* 1922:1991 */       ManejoFechas.setFechaRevision(vehiculo, mantenimientoGeneral, revisiones2, distanciaReferencia, fechaReferencia, ultimaFecha);
/* 1923:     */       
/* 1924:     */ 
/* 1925:     */ 
/* 1926:1995 */       Iterator rev_iterator = revisiones2.iterator();
/* 1927:1996 */       while (rev_iterator.hasNext())
/* 1928:     */       {
/* 1929:1997 */         RevisionesVehiculo revision = (RevisionesVehiculo)rev_iterator.next();
/* 1930:1998 */         if (revision.getRveh_bloqueado().compareTo(BigDecimal.ZERO) == 0)
/* 1931:     */         {
/* 1932:1999 */           BigDecimal diferencia = distanciaReferenciaInicial.subtract(revision.getRveh_control_kms());
/* 1933:2000 */           ManejoFechas.setFechaRevision(vehiculo, revision, diferencia, fechaReferencia, ultimaFecha);
/* 1934:     */         }
/* 1935:     */       }
/* 1936:2003 */       int y = 0;
/* 1937:2004 */       vehiculosCompleto.setRevisiones(revisiones2);
/* 1938:2005 */       vehiculosCompletoDAO.update(vehiculosCompleto, vehiculo.getVehi_cod());
/* 1939:2006 */       form.setVehi_fechaodometro(ManejoFechas.FormateoFecha(vehiculo.getVehi_fechaodometro().toString()));
/* 1940:2007 */       form.setVehi_fechaencero(ManejoFechas.FormateoFecha(vehiculo.getVehi_fechaencero().toString()));
/* 1941:     */     }
/* 1942:     */     catch (Exception e)
/* 1943:     */     {
/* 1944:2009 */       e.printStackTrace();
/* 1945:2010 */       return mapping.findForward("failure");
/* 1946:     */     }
/* 1947:2013 */     return mapping.findForward("success");
/* 1948:     */   }
/* 1949:     */   
/* 1950:     */   private ActionForward performEditControles(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 1951:     */   {
/* 1952:2017 */     VehiculosCompletoForm form = (VehiculosCompletoForm)actionForm;
/* 1953:2018 */     Boolean nuevo = Boolean.valueOf(false);
/* 1954:     */     try
/* 1955:     */     {
/* 1956:2020 */       VehiculosCompletoDAO vehiculosCompletoDAO = new VehiculosCompletoDAO();
/* 1957:2021 */       VehiculosDAO vehiculosDAO = new VehiculosDAO();
/* 1958:2022 */       UsuarioCar usuarioCar = (UsuarioCar)request.getSession().getAttribute("usuarioCar");
/* 1959:2023 */       List vehiculos = vehiculosDAO.list(usuarioCar.getUsuc_cod());
/* 1960:2024 */       if (vehiculos.isEmpty()) {
/* 1961:2025 */         return mapping.findForward("vehiculo");
/* 1962:     */       }
/* 1963:2027 */       Vehiculos vehiculo = (Vehiculos)vehiculos.get(0);
/* 1964:     */       
/* 1965:2029 */       BeanUtils.copyProperties(form, vehiculo);
/* 1966:     */       
/* 1967:     */ 
/* 1968:2032 */       int y = 0;
/* 1969:2033 */       BigDecimal numeroVehiculo = ((Vehiculos)vehiculos.get(y)).getVehi_cod();
/* 1970:2034 */       VehiculosCompleto vehiculosCompleto = vehiculosCompletoDAO.retrieve(numeroVehiculo);
/* 1971:     */       
/* 1972:2036 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 1973:2037 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1974:2038 */         vehiculosCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 1975:     */       }
/* 1976:2041 */       request.getSession().setAttribute("vehiculo", vehiculosCompleto.getVehiculo());
/* 1977:     */       
/* 1978:2043 */       BeanUtils.copyProperties(form, vehiculosCompleto.getVehiculo());
/* 1979:2044 */       BeanUtils.copyProperties(form, vehiculosCompleto.getPropietario());
/* 1980:2045 */       BeanUtils.copyProperties(form, vehiculosCompleto.getMantenimientoGeneral());
/* 1981:     */       
/* 1982:2047 */       form.setVehi_feccomp(ManejoFechas.FormateoFecha(form.getVehi_feccomp()));
/* 1983:2048 */       form.setVehi_fechaodometro(ManejoFechas.FormateoFecha(form.getVehi_fechaodometro()));
/* 1984:2049 */       form.setPveh_fecnacim(ManejoFechas.FormateoFecha(form.getPveh_fecnacim()));
/* 1985:2050 */       form.setCom_fechaini(ManejoFechas.FormateoFecha(form.getCom_fechaini()));
/* 1986:2051 */       form.setCom_fechafin(ManejoFechas.FormateoFecha(form.getCom_fechafin()));
/* 1987:2052 */       form.setFechaMantenimientosBasicos(ManejoFechas.FormateoFecha(form.getFechaMantenimientosBasicos()));
/* 1988:2053 */       form.setMant_control_fec(ManejoFechas.FormateoFecha(form.getMant_control_fec()));
/* 1989:     */       
/* 1990:2055 */       form.setTempcero("0");
/* 1991:2056 */       List revisiones = vehiculosCompleto.getRevisiones();
/* 1992:     */       
/* 1993:2058 */       int x = 0;
/* 1994:     */       
/* 1995:2060 */       request.getSession().setAttribute("REVISIONES", revisiones);
/* 1996:     */       
/* 1997:2062 */       RevisionAccionDAO revisionAccionDAO = new RevisionAccionDAO();
/* 1998:2063 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 1999:2064 */         revisionAccionDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 2000:     */       }
/* 2001:2066 */       revisionAccionDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 2002:2067 */       RevisionAlternativaDAO revisionAlternativaDAO = new RevisionAlternativaDAO();
/* 2003:2068 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 2004:2069 */         revisionAlternativaDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 2005:     */       }
/* 2006:2071 */       revisionAlternativaDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 2007:2072 */       x = 0;
/* 2008:2073 */       while (x < revisiones.size())
/* 2009:     */       {
/* 2010:2074 */         request.setAttribute("rveh_acc_des" + x, revisionAccionDAO.retrive(((RevisionesVehiculo)revisiones.get(x)).getRveh_acc_cod()).getRacc_cod().toString());
/* 2011:2075 */         request.setAttribute("rveh_alt_cod" + x, revisionAlternativaDAO.retrive(((RevisionesVehiculo)revisiones.get(x)).getRveh_alt_cod()).getRalt_des());
/* 2012:2076 */         x++;
/* 2013:     */       }
/* 2014:2079 */       List seguros = vehiculosCompleto.getSeguros();
/* 2015:2080 */       request.getSession().setAttribute("SEGUROSVEHICULOS", seguros);
/* 2016:     */       
/* 2017:2082 */       List controles = vehiculosCompleto.getControles();
/* 2018:2083 */       request.getSession().setAttribute("CONTROLESVEHICULOS", controles);
/* 2019:     */       
/* 2020:2085 */       List gastosVehiculosMecanica = vehiculosCompleto.getGastosMecanica();
/* 2021:2086 */       GastosVehiculosMecanicaDAO gastosVehiculosMecanicaDAO = new GastosVehiculosMecanicaDAO();
/* 2022:2087 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 2023:2088 */         gastosVehiculosMecanicaDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 2024:     */       }
/* 2025:2090 */       request.getSession().setAttribute("GASTOSVEHICULOSMECANICA", gastosVehiculosMecanica);
/* 2026:     */       
/* 2027:2092 */       List gastosVehiculosNoAnuales = vehiculosCompleto.getGastosNoAnuales();
/* 2028:2093 */       GastosVehiculosNoAnualesDAO gastosVehiculosNoAnualesDAO = new GastosVehiculosNoAnualesDAO();
/* 2029:2094 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 2030:2095 */         gastosVehiculosNoAnualesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 2031:     */       }
/* 2032:2097 */       request.getSession().setAttribute("GASTOSVEHICULOSNOANUALES", gastosVehiculosNoAnuales);
/* 2033:     */       
/* 2034:2099 */       List gastosVehiculosAnuales = vehiculosCompleto.getGastosAnuales();
/* 2035:2100 */       request.getSession().setAttribute("GASTOSVEHICULOSANUALES", gastosVehiculosAnuales);
/* 2036:     */       
/* 2037:2102 */       List impuestos = vehiculosCompleto.getImpuestos();
/* 2038:2103 */       request.getSession().setAttribute("IMPUESTOS", impuestos);
/* 2039:     */       
/* 2040:2105 */       List combustibleAuto = vehiculosCompleto.getConsumosCombustible();
/* 2041:2106 */       request.getSession().setAttribute("COMBUSTIBLEVEHICULO", combustibleAuto);
/* 2042:     */       
/* 2043:2108 */       TipoVehiculoDAO tipoVehiculoDAO = new TipoVehiculoDAO();
/* 2044:2109 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 2045:2110 */         tipoVehiculoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 2046:     */       }
/* 2047:2112 */       tipoVehiculoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 2048:2113 */       List tipoVehiculos = tipoVehiculoDAO.list();
/* 2049:2114 */       request.setAttribute("TIPOVEHICULO", tipoVehiculos);
/* 2050:     */       
/* 2051:2116 */       PaisDAO paisDAO = new PaisDAO();
/* 2052:2117 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 2053:2118 */         paisDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 2054:     */       }
/* 2055:2120 */       paisDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 2056:2121 */       List paises = paisDAO.list();
/* 2057:2122 */       request.setAttribute("PAISES", paises);
/* 2058:     */       
/* 2059:2124 */       List ciudades = null;
/* 2060:2125 */       CiudadDAO ciudadesDAO = new CiudadDAO();
/* 2061:2126 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 2062:2127 */         ciudadesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 2063:     */       }
/* 2064:2129 */       ciudadesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 2065:2130 */       if (paises.size() > 0) {
/* 2066:2131 */         if (!form.getPveh_pais_cod().equals("0")) {
/* 2067:2132 */           ciudades = ciudadesDAO.search(form.getPveh_pais_cod());
/* 2068:     */         } else {
/* 2069:2134 */           ciudades = ciudadesDAO.search(((Paises)paises.get(0)).getPais_cod().toString());
/* 2070:     */         }
/* 2071:     */       }
/* 2072:2137 */       request.setAttribute("CIUDADES", ciudades);
/* 2073:     */       
/* 2074:2139 */       List revisionAlternativas = revisionAlternativaDAO.list();
/* 2075:2140 */       request.setAttribute("alternativas", revisionAlternativas);
/* 2076:     */       
/* 2077:2142 */       List revisionAcciones = revisionAccionDAO.list();
/* 2078:2143 */       request.setAttribute("acciones", revisionAcciones);
/* 2079:     */       
/* 2080:2145 */       MarcasAutosDAO marcasAutoDAO = new MarcasAutosDAO();
/* 2081:2146 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 2082:2147 */         marcasAutoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 2083:     */       }
/* 2084:2149 */       marcasAutoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 2085:2150 */       List marcasAuto = marcasAutoDAO.list();
/* 2086:2151 */       request.setAttribute("MARCASAUTOS", marcasAuto);
/* 2087:     */       
/* 2088:2153 */       request.getSession().setAttribute("tipoMedida", vehiculosCompleto.getVehiculo().getVehi_distancia());
/* 2089:     */       
/* 2090:2155 */       GruposVehiculoDAO gruposVehiculoDAO = new GruposVehiculoDAO();
/* 2091:2156 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 2092:2157 */         gruposVehiculoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 2093:     */       }
/* 2094:2160 */       for (int i = 0; i < 3; i++)
/* 2095:     */       {
/* 2096:2161 */         GruposVehiculo gruposVehiculo = new GruposVehiculo();
/* 2097:2162 */         switch (i)
/* 2098:     */         {
/* 2099:     */         case 0: 
/* 2100:2164 */           gruposVehiculo = gruposVehiculoDAO.search(vehiculosCompleto.getVehiculo().getVehi_cod(), IGrupos.CARS_CONTROLES);
/* 2101:2165 */           request.getSession().setAttribute("CONTROLESVEHICULOSDIAS", form.getCveh_dias_antes());
/* 2102:2166 */           break;
/* 2103:     */         case 1: 
/* 2104:2168 */           gruposVehiculo = gruposVehiculoDAO.search(vehiculosCompleto.getVehiculo().getVehi_cod(), IGrupos.CARS_SEGUROS);
/* 2105:2169 */           request.getSession().setAttribute("SEGUROSVEHICULOSDIAS", form.getSveh_dias_antes());
/* 2106:2170 */           break;
/* 2107:     */         case 2: 
/* 2108:2172 */           gruposVehiculo = gruposVehiculoDAO.search(vehiculosCompleto.getVehiculo().getVehi_cod(), IGrupos.CARS_IMPUESTOS);
/* 2109:2173 */           request.getSession().setAttribute("IMPUESTOSVEHICULOSDIAS", form.getIveh_dias_antes());
/* 2110:     */         }
/* 2111:2176 */         if (gruposVehiculo.getGrupv_vehi_cod() != null)
/* 2112:     */         {
/* 2113:2177 */           switch (i)
/* 2114:     */           {
/* 2115:     */           case 0: 
/* 2116:2179 */             form.setCveh_dias_antes(gruposVehiculo.getGrupv_dias_antes().toString());
/* 2117:2180 */             request.getSession().setAttribute("CONTROLESVEHICULOSDIAS", form.getCveh_dias_antes());
/* 2118:2181 */             break;
/* 2119:     */           case 1: 
/* 2120:2183 */             form.setSveh_dias_antes(gruposVehiculo.getGrupv_dias_antes().toString());
/* 2121:2184 */             request.getSession().setAttribute("SEGUROSVEHICULOSDIAS", form.getSveh_dias_antes());
/* 2122:2185 */             break;
/* 2123:     */           case 2: 
/* 2124:2187 */             form.setIveh_dias_antes(gruposVehiculo.getGrupv_dias_antes().toString());
/* 2125:2188 */             request.getSession().setAttribute("IMPUESTOSVEHICULOSDIAS", form.getIveh_dias_antes());
/* 2126:     */           }
/* 2127:     */         }
/* 2128:     */         else
/* 2129:     */         {
/* 2130:2192 */           GruposDAO gruposDAO = new GruposDAO();
/* 2131:2193 */           if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 2132:2194 */             gruposDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 2133:     */           }
/* 2134:2196 */           gruposDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 2135:2197 */           Grupos grupos = new Grupos();
/* 2136:2198 */           switch (i)
/* 2137:     */           {
/* 2138:     */           case 0: 
/* 2139:2200 */             grupos = gruposDAO.retrive(IGrupos.CARS_CONTROLES);
/* 2140:2201 */             form.setCveh_dias_antes(grupos.getGrup_dias_antes().toString());
/* 2141:2202 */             request.getSession().setAttribute("CONTROLESVEHICULOSDIAS", form.getCveh_dias_antes());
/* 2142:2203 */             break;
/* 2143:     */           case 1: 
/* 2144:2205 */             grupos = gruposDAO.retrive(IGrupos.CARS_SEGUROS);
/* 2145:2206 */             form.setSveh_dias_antes(grupos.getGrup_dias_antes().toString());
/* 2146:2207 */             request.getSession().setAttribute("SEGUROSVEHICULOSDIAS", form.getSveh_dias_antes());
/* 2147:2208 */             break;
/* 2148:     */           case 2: 
/* 2149:2210 */             grupos = gruposDAO.retrive(IGrupos.CARS_IMPUESTOS);
/* 2150:2211 */             form.setIveh_dias_antes(grupos.getGrup_dias_antes().toString());
/* 2151:2212 */             request.getSession().setAttribute("IMPUESTOSVEHICULOSDIAS", form.getIveh_dias_antes());
/* 2152:     */           }
/* 2153:     */         }
/* 2154:     */       }
/* 2155:2218 */       IdiomaDAO idiomaDAO = new IdiomaDAO();
/* 2156:2219 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 2157:2220 */         idiomaDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 2158:     */       }
/* 2159:2222 */       request.setAttribute("IDIOMAS", idiomaDAO.list());
/* 2160:     */     }
/* 2161:     */     catch (Exception e)
/* 2162:     */     {
/* 2163:2225 */       return mapping.findForward("failure");
/* 2164:     */     }
/* 2165:2227 */     return mapping.findForward("success");
/* 2166:     */   }
/* 2167:     */   
/* 2168:     */   private ActionForward performSaveEditControl(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 2169:     */   {
/* 2170:2230 */     VehiculosCompletoForm form = (VehiculosCompletoForm)actionForm;
/* 2171:     */     try
/* 2172:     */     {
/* 2173:2232 */       UsuarioCar usuarioCar = (UsuarioCar)request.getSession().getAttribute("usuarioCar");
/* 2174:2233 */       Vehiculos vehiculo = (Vehiculos)request.getSession().getAttribute("vehiculo");
/* 2175:2234 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 2176:2235 */       VehiculosCompleto vehiculosCompleto = new VehiculosCompleto();
/* 2177:2236 */       vehiculosCompleto.setVehiculo(vehiculo);
/* 2178:2237 */       VehiculosDAO vehiculosDAO = new VehiculosDAO();
/* 2179:2238 */       Vehiculos vehiculosR = vehiculosDAO.retrieveCarByUser(usuarioCar.getUsuc_cod());
/* 2180:2239 */       RevisionesVehiculoDAO revisionesVehiculoDAO = new RevisionesVehiculoDAO();
/* 2181:2240 */       MantenimientoGeneralDAO mantenimientoGeneralDao2 = new MantenimientoGeneralDAO();
/* 2182:2241 */       MantenimientoGeneral mantenimientoGeneral = mantenimientoGeneralDao2.retrive(BigDecimal.ONE, vehiculosR.getVehi_cod());
/* 2183:     */       
/* 2184:     */ 
/* 2185:2244 */       BigDecimal FechaOdometroCero = BigDecimal.ZERO;
/* 2186:2245 */       BigDecimal FechaCompra = BigDecimal.ZERO;
/* 2187:2246 */       BigDecimal FechaOdometroInicial = BigDecimal.ZERO;
/* 2188:2247 */       BigDecimal FechaOdometro = BigDecimal.ZERO;
/* 2189:2248 */       BigDecimal DistanciaOdometro = BigDecimal.ZERO;
/* 2190:2249 */       BigDecimal DistanciaOdometroInicial = BigDecimal.ZERO;
/* 2191:2250 */       List revisiones = revisionesVehiculoDAO.list2(vehiculosR.getVehi_cod());
/* 2192:2251 */       List revisiones2 = (List)request.getSession().getAttribute("REVISIONES");
/* 2193:2252 */       SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
/* 2194:2253 */       SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
/* 2195:     */       
/* 2196:2255 */       form.setVehi_fechaodometro(vehiculosR.getVehi_fechaodometro().toString());
/* 2197:2256 */       form.setVehi_fechaencero(vehiculosR.getVehi_fechaencero().toString());
/* 2198:2257 */       form.setVehi_kmsact(vehiculosR.getVehi_kmsact().toString());
/* 2199:2259 */       if (form.getOdometroBloqueado().compareTo(new String("1")) == 0) {
/* 2200:2260 */         vehiculo.setVehi_bloqueado(BigDecimal.ONE);
/* 2201:     */       }
/* 2202:2262 */       if (form.getMntnmntoBloqueado().compareTo(new String("1")) == 0) {
/* 2203:2263 */         mantenimientoGeneral.setMant_bloqueado(BigDecimal.ONE);
/* 2204:     */       }
/* 2205:2265 */       if (form.getTempcero().compareTo("0") != 0)
/* 2206:     */       {
/* 2207:2266 */         vehiculo.setVehi_fechaencero(new BigDecimal(form.getTempcero()));
/* 2208:2267 */         form.setVehi_fechaencero(form.getTempcero().toString());
/* 2209:     */       }
/* 2210:2271 */       if (vehiculo.getVehi_fechaencero().compareTo(BigDecimal.ZERO) != 0)
/* 2211:     */       {
/* 2212:2274 */         FechaOdometroCero = vehiculo.getVehi_fechaencero();
/* 2213:2276 */         if (vehiculo.getVehi_feccomp().compareTo(BigDecimal.ZERO) != 0) {
/* 2214:2277 */           FechaCompra = vehiculo.getVehi_feccomp();
/* 2215:     */         }
/* 2216:2280 */         if (vehiculo.getVehi_fechaodometroinicial().compareTo(BigDecimal.ZERO) != 0) {
/* 2217:2281 */           FechaOdometroInicial = vehiculo.getVehi_fechaodometroinicial();
/* 2218:     */         }
/* 2219:2284 */         if (vehiculo.getVehi_fechaodometro().compareTo(BigDecimal.ZERO) != 0) {
/* 2220:2285 */           FechaOdometro = vehiculo.getVehi_fechaodometro();
/* 2221:     */         }
/* 2222:2288 */         if (vehiculo.getVehi_kmsact().compareTo(BigDecimal.ZERO) != 0) {
/* 2223:2289 */           DistanciaOdometro = vehiculo.getVehi_kmsact();
/* 2224:     */         }
/* 2225:2292 */         if (vehiculo.getVehi_kmsodometroinicial().compareTo(BigDecimal.ZERO) != 0) {
/* 2226:2293 */           DistanciaOdometroInicial = vehiculo.getVehi_kmsodometroinicial();
/* 2227:     */         }
/* 2228:2296 */         BigDecimal[] curva = { vehiculo.getVehi_enero().divideToIntegralValue(new BigDecimal(31.0D)), 
/* 2229:2297 */           vehiculo.getVehi_febrero().divideToIntegralValue(new BigDecimal(28.0D)), 
/* 2230:2298 */           vehiculo.getVehi_marzo().divideToIntegralValue(new BigDecimal(31.0D)), 
/* 2231:2299 */           vehiculo.getVehi_abril().divideToIntegralValue(new BigDecimal(30.0D)), 
/* 2232:2300 */           vehiculo.getVehi_mayo().divideToIntegralValue(new BigDecimal(31.0D)), 
/* 2233:2301 */           vehiculo.getVehi_junio().divideToIntegralValue(new BigDecimal(30.0D)), 
/* 2234:2302 */           vehiculo.getVehi_julio().divideToIntegralValue(new BigDecimal(31.0D)), 
/* 2235:2303 */           vehiculo.getVehi_agosto().divideToIntegralValue(new BigDecimal(31.0D)), 
/* 2236:2304 */           vehiculo.getVehi_septiembre().divideToIntegralValue(new BigDecimal(30.0D)), 
/* 2237:2305 */           vehiculo.getVehi_octubre().divideToIntegralValue(new BigDecimal(31.0D)), 
/* 2238:2306 */           vehiculo.getVehi_noviembre().divideToIntegralValue(new BigDecimal(30.0D)), 
/* 2239:2307 */           vehiculo.getVehi_diciembre().divideToIntegralValue(new BigDecimal(31.0D)) };
/* 2240:     */         
/* 2241:     */ 
/* 2242:     */ 
/* 2243:     */ 
/* 2244:2312 */         Iterator rev_iterator2 = revisiones2.iterator();
/* 2245:2313 */         int DistanciaAcumulada = 0;int opcion = 0;
/* 2246:     */         
/* 2247:2315 */         int Diferencia = 90000000;
/* 2248:     */         
/* 2249:2317 */         BigDecimal fechaCercanaCero = BigDecimal.ZERO;
/* 2250:2318 */         BigDecimal distanciaCercanaCero = BigDecimal.ZERO;
/* 2251:2319 */         while (rev_iterator2.hasNext())
/* 2252:     */         {
/* 2253:2320 */           RevisionesVehiculo revision = (RevisionesVehiculo)rev_iterator2.next();
/* 2254:2321 */           if (revision.getRveh_bloqueado().compareTo(BigDecimal.ZERO) == 0)
/* 2255:     */           {
/* 2256:2322 */             int Diferencia2 = vehiculo.getVehi_fechaencero().intValue() - revision.getRveh_control_fec().intValue();
/* 2257:2323 */             if ((Diferencia2 > 0) && (Diferencia2 < Diferencia))
/* 2258:     */             {
/* 2259:2324 */               fechaCercanaCero = revision.getRveh_control_fec();
/* 2260:2325 */               distanciaCercanaCero = revision.getRveh_control_kms();
/* 2261:2326 */               Diferencia = Diferencia2;
/* 2262:     */             }
/* 2263:     */           }
/* 2264:     */         }
/* 2265:2332 */         rev_iterator2 = revisiones2.iterator();
/* 2266:2333 */         while (rev_iterator2.hasNext())
/* 2267:     */         {
/* 2268:2335 */           RevisionesVehiculo revision = (RevisionesVehiculo)rev_iterator2.next();
/* 2269:2336 */           BigDecimal DistanciaUltimaControl = BigDecimal.ZERO;
/* 2270:2337 */           if (revision.getRveh_bloqueado().compareTo(BigDecimal.ZERO) == 0)
/* 2271:     */           {
/* 2272:2339 */             if (revision.getRveh_control_kms() != BigDecimal.ZERO) {
/* 2273:2340 */               DistanciaUltimaControl = revision.getRveh_control_kms();
/* 2274:     */             }
/* 2275:2342 */             BigDecimal FechaUltimaControl = BigDecimal.ZERO;
/* 2276:2343 */             if (revision.getRveh_control_fec() != BigDecimal.ZERO) {
/* 2277:2344 */               FechaUltimaControl = revision.getRveh_control_fec();
/* 2278:     */             }
/* 2279:2347 */             if (FechaCompra.compareTo(BigDecimal.ZERO) == 1)
/* 2280:     */             {
/* 2281:2348 */               DistanciaAcumulada = FechaCompra.intValue();
/* 2282:2349 */               opcion = 1;
/* 2283:     */             }
/* 2284:2352 */             if (FechaOdometroInicial.compareTo(new BigDecimal(DistanciaAcumulada)) == 1)
/* 2285:     */             {
/* 2286:2353 */               DistanciaAcumulada = FechaOdometroInicial.intValue();
/* 2287:2354 */               opcion = 2;
/* 2288:     */             }
/* 2289:2357 */             if (FechaUltimaControl.compareTo(new BigDecimal(DistanciaAcumulada)) == 1)
/* 2290:     */             {
/* 2291:2358 */               DistanciaAcumulada = FechaUltimaControl.intValue();
/* 2292:2359 */               opcion = 3;
/* 2293:     */             }
/* 2294:2361 */             if (fechaCercanaCero.compareTo(new BigDecimal(DistanciaAcumulada)) == 1)
/* 2295:     */             {
/* 2296:2362 */               DistanciaAcumulada = distanciaCercanaCero.intValue();
/* 2297:2363 */               opcion = 4;
/* 2298:     */             }
/* 2299:2367 */             BigDecimal fechaInicial = BigDecimal.ZERO;
/* 2300:2368 */             BigDecimal DistanciaInicial = BigDecimal.ZERO;
/* 2301:2369 */             switch (opcion)
/* 2302:     */             {
/* 2303:     */             case 2: 
/* 2304:2370 */               fechaInicial = FechaOdometroInicial;
/* 2305:2371 */               DistanciaInicial = DistanciaOdometroInicial;
/* 2306:2372 */               break;
/* 2307:     */             case 3: 
/* 2308:2373 */               fechaInicial = FechaUltimaControl;
/* 2309:2374 */               DistanciaInicial = DistanciaUltimaControl;
/* 2310:2375 */               break;
/* 2311:     */             case 4: 
/* 2312:2376 */               fechaInicial = fechaCercanaCero;
/* 2313:2377 */               DistanciaInicial = distanciaCercanaCero;
/* 2314:     */             }
/* 2315:2380 */             Calendar fechaSimulada = new GregorianCalendar();
/* 2316:     */             
/* 2317:2382 */             fechaSimulada.setTime(sdf.parse(fechaInicial.toString()));
/* 2318:2385 */             if (fechaInicial.compareTo(FechaOdometroCero) == 0) {
/* 2319:2386 */               revision.setRveh_kmscero(DistanciaInicial);
/* 2320:     */             } else {
/* 2321:2388 */               while (fechaInicial.compareTo(FechaOdometroCero) < 1)
/* 2322:     */               {
/* 2323:2390 */                 DistanciaInicial = DistanciaInicial.add(curva[fechaSimulada.get(2)]);
/* 2324:2391 */                 fechaSimulada.add(6, 1);
/* 2325:2392 */                 fechaInicial = new BigDecimal(sdf.format(fechaSimulada.getTime()));
/* 2326:     */               }
/* 2327:     */             }
/* 2328:2396 */             revision.setRveh_kmscero(DistanciaInicial);
/* 2329:     */           }
/* 2330:     */         }
/* 2331:     */       }
/* 2332:2402 */       vehiculosCompleto.setRevisiones(revisiones2);
/* 2333:2409 */       if (form.getPveh_indpais1().length() == 0) {
/* 2334:2410 */         form.setPveh_indpais1("0");
/* 2335:     */       }
/* 2336:2412 */       if (form.getPveh_indciudad1().length() == 0) {
/* 2337:2413 */         form.setPveh_indciudad1("0");
/* 2338:     */       }
/* 2339:2415 */       if (form.getPveh_indpais2().length() == 0) {
/* 2340:2416 */         form.setPveh_indpais2("0");
/* 2341:     */       }
/* 2342:2418 */       if (Integer.parseInt(form.getVehi_num_dias_no_mail()) < 2) {
/* 2343:2419 */         form.setVehi_num_dias_no_mail("2");
/* 2344:     */       }
/* 2345:2421 */       boolean calculoOdoCero = false;
/* 2346:2422 */       if (form.getVehi_cerobasica().compareTo(new String("0")) != 0) {
/* 2347:2423 */         calculoOdoCero = true;
/* 2348:     */       }
/* 2349:2425 */       if (form.getVehi_fechaencero().compareTo(new String("0")) != 0) {
/* 2350:2426 */         calculoOdoCero = true;
/* 2351:     */       }
/* 2352:2432 */       BigDecimal distanciaReferencia = BigDecimal.ZERO;
/* 2353:2433 */       BigDecimal diferenciaMenorA = new BigDecimal(10000000);
/* 2354:2434 */       BigDecimal diferenciaMenorB = new BigDecimal(10000000);
/* 2355:2435 */       Integer fechacero = new Integer(new String(form.getVehi_fechaencero()));
/* 2356:     */       
/* 2357:2437 */       BigDecimal fechaReferenciaInicial = new BigDecimal(fechacero.intValue());
/* 2358:2438 */       BigDecimal fechaReferenciaInicial0 = new BigDecimal(fechacero.intValue());
/* 2359:2439 */       BigDecimal distanciaReferenciaInicial = BigDecimal.ZERO;
/* 2360:2440 */       if (vehiculo.getVehi_fechaodometro().compareTo(fechaReferenciaInicial) == -1)
/* 2361:     */       {
/* 2362:2442 */         diferenciaMenorA = fechaReferenciaInicial.subtract(vehiculo.getVehi_fechaodometro());
/* 2363:2443 */         fechaReferenciaInicial = vehiculo.getVehi_fechaodometro();
/* 2364:2444 */         distanciaReferenciaInicial = vehiculo.getVehi_kmsact();
/* 2365:     */       }
/* 2366:2446 */       diferenciaMenorB = fechaReferenciaInicial.subtract(mantenimientoGeneral.getMant_control_fec());
/* 2367:2447 */       if ((diferenciaMenorB.intValue() < diferenciaMenorA.intValue()) && (diferenciaMenorB.intValue() > 0))
/* 2368:     */       {
/* 2369:2448 */         fechaReferenciaInicial = mantenimientoGeneral.getMant_control_fec();
/* 2370:2449 */         distanciaReferenciaInicial = mantenimientoGeneral.getMant_control_kms();
/* 2371:2450 */         diferenciaMenorA = diferenciaMenorB;
/* 2372:     */       }
/* 2373:2453 */       for (Iterator revisionesIterator = revisiones2.iterator(); revisionesIterator.hasNext();)
/* 2374:     */       {
/* 2375:2455 */         RevisionesVehiculo revisionVehiculoA = (RevisionesVehiculo)revisionesIterator.next();
/* 2376:2456 */         diferenciaMenorB = fechaReferenciaInicial0.subtract(revisionVehiculoA.getRveh_control_fec());
/* 2377:2457 */         if (revisionVehiculoA.getRveh_bloqueado().compareTo(BigDecimal.ZERO) == 0) {
/* 2378:2459 */           if ((diferenciaMenorB.intValue() < diferenciaMenorA.intValue()) && (diferenciaMenorB.intValue() > 0))
/* 2379:     */           {
/* 2380:2460 */             fechaReferenciaInicial = revisionVehiculoA.getRveh_control_fec();
/* 2381:2461 */             distanciaReferenciaInicial = revisionVehiculoA.getRveh_control_kms();
/* 2382:2462 */             diferenciaMenorA = diferenciaMenorB;
/* 2383:     */           }
/* 2384:     */         }
/* 2385:     */       }
/* 2386:2467 */       if (form.getVehi_fechaencero().toString().compareTo(new String("0")) != 0) {
/* 2387:2468 */         form.setVehi_kmsencero(ManejoFechas.getDistanciaOdometroCero(vehiculo, sdf.parse(fechaReferenciaInicial.toString()), distanciaReferenciaInicial, sdf.parse(form.getVehi_fechaencero().toString())));
/* 2388:     */       }
/* 2389:2475 */       List controles = (List)request.getSession().getAttribute("CONTROLESVEHICULOS");
/* 2390:2476 */       vehiculosCompleto.setControles(controles);
/* 2391:     */       
/* 2392:2478 */       List seguros = (List)request.getSession().getAttribute("SEGUROSVEHICULOS");
/* 2393:2479 */       vehiculosCompleto.setSeguros(seguros);
/* 2394:     */       
/* 2395:2481 */       List gastosMecanica = (List)request.getSession().getAttribute("GASTOSVEHICULOSMECANICA");
/* 2396:2482 */       vehiculosCompleto.setGastosMecanica(gastosMecanica);
/* 2397:     */       
/* 2398:2484 */       List gastosNoAnuales = (List)request.getSession().getAttribute("GASTOSVEHICULOSNOANUALES");
/* 2399:2485 */       vehiculosCompleto.setGastosNoAnuales(gastosNoAnuales);
/* 2400:     */       
/* 2401:2487 */       List gastosAnuales = (List)request.getSession().getAttribute("GASTOSVEHICULOSANUALES");
/* 2402:2488 */       vehiculosCompleto.setGastosAnuales(gastosAnuales);
/* 2403:     */       
/* 2404:2490 */       List impuestos = (List)request.getSession().getAttribute("IMPUESTOS");
/* 2405:2491 */       vehiculosCompleto.setImpuestos(impuestos);
/* 2406:     */       
/* 2407:2493 */       List combustibles = (List)request.getSession().getAttribute("COMBUSTIBLEVEHICULO");
/* 2408:2494 */       if ((!form.getCom_lecturaini().equals("0")) && (!form.getCom_lecturafin().equals("0")) && (!form.getCom_cantidadconsumo().equals("0")) && (!form.getCom_costocombustible().equals("0")) && (combustibles.size() < 5))
/* 2409:     */       {
/* 2410:2495 */         Combustible combustible = new Combustible();
/* 2411:2496 */         InicializaData.inicializa(combustible.getClass(), combustible);
/* 2412:2497 */         BeanUtils.copyProperties(combustible, form);
/* 2413:2498 */         combustible.setCom_veh_cod(vehiculo.getVehi_cod());
/* 2414:2499 */         combustibles.add(0, combustible);
/* 2415:     */       }
/* 2416:2501 */       vehiculosCompleto.setConsumosCombustible(combustibles);
/* 2417:     */       
/* 2418:     */ 
/* 2419:2504 */       VehiculosCompletoDAO vehiculosCompletoDAO = new VehiculosCompletoDAO();
/* 2420:2505 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 2421:2506 */         vehiculosCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 2422:     */       }
/* 2423:2510 */       BeanUtils.copyProperties(vehiculo, form);
/* 2424:2511 */       vehiculo.setVehi_usuc_cod(usuarioCar.getUsuc_cod());
/* 2425:     */       
/* 2426:     */ 
/* 2427:2514 */       Date fechaActual = new Date();
/* 2428:     */       
/* 2429:2516 */       vehiculo.setVehi_registro(new BigDecimal(sdf2.format(fechaActual)));
/* 2430:     */       
/* 2431:2518 */       PropietariosVehiculos propietariosVehiculos = new PropietariosVehiculos();
/* 2432:2519 */       vehiculosCompleto.setPropietario(propietariosVehiculos);
/* 2433:2520 */       InicializaData.inicializa(propietariosVehiculos.getClass(), propietariosVehiculos);
/* 2434:2521 */       BeanUtils.copyProperties(propietariosVehiculos, form);
/* 2435:     */       
/* 2436:2523 */       vehiculosCompleto.setMantenimientoGeneral(mantenimientoGeneral);
/* 2437:2524 */       InicializaData.inicializa(mantenimientoGeneral.getClass(), mantenimientoGeneral);
/* 2438:2525 */       BeanUtils.copyProperties(mantenimientoGeneral, form);
/* 2439:2527 */       if (ManejoFechas.restaFechas(mantenimientoGeneral.getMant_control_fec().toString(), ManejoFechas.getFechaActual()) < 0) {
/* 2440:2528 */         mantenimientoGeneral.setMant_control_fec(new BigDecimal(ManejoFechas.getFechaActual()));
/* 2441:     */       }
/* 2442:2531 */       BigDecimal odo_actual = vehiculo.getVehi_kmsact();
/* 2443:     */       
/* 2444:     */ 
/* 2445:     */ 
/* 2446:2535 */       vehiculosCompletoDAO.update(vehiculosCompleto, vehiculo.getVehi_cod());
/* 2447:     */       
/* 2448:     */ 
/* 2449:     */ 
/* 2450:     */ 
/* 2451:     */ 
/* 2452:2541 */       GruposVehiculoDAO gruposVehiculoDAO = new GruposVehiculoDAO();
/* 2453:2542 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 2454:2543 */         gruposVehiculoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 2455:     */       }
/* 2456:2545 */       String[] llavesGrupos = { "grupv_cod", "grupv_vehi_cod" };
/* 2457:2546 */       GruposVehiculo gruposVehiculo = new GruposVehiculo();
/* 2458:2547 */       for (int i = 0; i < 3; i++)
/* 2459:     */       {
/* 2460:2548 */         switch (i)
/* 2461:     */         {
/* 2462:     */         case 0: 
/* 2463:2550 */           gruposVehiculo = gruposVehiculoDAO.search(vehiculosCompleto.getVehiculo().getVehi_cod(), IGrupos.CARS_CONTROLES);
/* 2464:2551 */           break;
/* 2465:     */         case 1: 
/* 2466:2553 */           gruposVehiculo = gruposVehiculoDAO.search(vehiculosCompleto.getVehiculo().getVehi_cod(), IGrupos.CARS_SEGUROS);
/* 2467:2554 */           break;
/* 2468:     */         case 2: 
/* 2469:2556 */           gruposVehiculo = gruposVehiculoDAO.search(vehiculosCompleto.getVehiculo().getVehi_cod(), IGrupos.CARS_IMPUESTOS);
/* 2470:     */         }
/* 2471:2559 */         switch (i)
/* 2472:     */         {
/* 2473:     */         case 0: 
/* 2474:2561 */           if (Integer.parseInt(form.getCveh_dias_antes()) < 2) {
/* 2475:2562 */             form.setCveh_dias_antes("2");
/* 2476:     */           }
/* 2477:2564 */           gruposVehiculo.setGrupv_dias_antes(new BigDecimal(form.getCveh_dias_antes()));
/* 2478:2565 */           request.getSession().setAttribute("CONTROLESVEHICULOSDIAS", form.getCveh_dias_antes());
/* 2479:2566 */           break;
/* 2480:     */         case 1: 
/* 2481:2568 */           if (Integer.parseInt(form.getSveh_dias_antes()) < 2) {
/* 2482:2569 */             form.setSveh_dias_antes("2");
/* 2483:     */           }
/* 2484:2571 */           gruposVehiculo.setGrupv_dias_antes(new BigDecimal(form.getSveh_dias_antes()));
/* 2485:2572 */           request.getSession().setAttribute("SEGUROSESVEHICULOSDIAS", form.getSveh_dias_antes());
/* 2486:2573 */           break;
/* 2487:     */         case 2: 
/* 2488:2575 */           if (Integer.parseInt(form.getIveh_dias_antes()) < 2) {
/* 2489:2576 */             form.setIveh_dias_antes("2");
/* 2490:     */           }
/* 2491:2578 */           gruposVehiculo.setGrupv_dias_antes(new BigDecimal(form.getIveh_dias_antes()));
/* 2492:2579 */           request.getSession().setAttribute("IMPUESTOSVEHICULOSDIAS", form.getIveh_dias_antes());
/* 2493:     */         }
/* 2494:2582 */         gruposVehiculoDAO.update(gruposVehiculo, llavesGrupos);
/* 2495:     */       }
/* 2496:2601 */       Date fechaReferencia = null;
/* 2497:2602 */       distanciaReferenciaInicial = BigDecimal.ZERO;
/* 2498:2603 */       if ((vehiculo.getVehi_fechaodometro().compareTo(fechaReferenciaInicial) == 1) && 
/* 2499:2604 */         (vehiculo.getVehi_bloqueado().compareTo(BigDecimal.ZERO) == 0))
/* 2500:     */       {
/* 2501:2605 */         fechaReferenciaInicial = vehiculo.getVehi_fechaodometro();
/* 2502:2606 */         distanciaReferenciaInicial = vehiculo.getVehi_kmsact();
/* 2503:     */       }
/* 2504:2610 */       if ((mantenimientoGeneral.getMant_control_fec().compareTo(fechaReferenciaInicial) == 1) && 
/* 2505:2611 */         (mantenimientoGeneral.getMant_bloqueado().compareTo(BigDecimal.ZERO) == 0))
/* 2506:     */       {
/* 2507:2612 */         fechaReferenciaInicial = mantenimientoGeneral.getMant_control_fec();
/* 2508:2613 */         distanciaReferenciaInicial = mantenimientoGeneral.getMant_control_kms();
/* 2509:     */       }
/* 2510:2616 */       for (Iterator revisionesIterator = revisiones2.iterator(); revisionesIterator.hasNext();)
/* 2511:     */       {
/* 2512:2617 */         RevisionesVehiculo revisionVehiculo = (RevisionesVehiculo)revisionesIterator.next();
/* 2513:2618 */         if (revisionVehiculo.getRveh_bloqueado().compareTo(BigDecimal.ZERO) == 0) {
/* 2514:2620 */           if (revisionVehiculo.getRveh_control_fec().compareTo(fechaReferenciaInicial) == 1)
/* 2515:     */           {
/* 2516:2621 */             fechaReferenciaInicial = revisionVehiculo.getRveh_control_fec();
/* 2517:2622 */             distanciaReferenciaInicial = revisionVehiculo.getRveh_control_kms();
/* 2518:     */           }
/* 2519:     */         }
/* 2520:     */       }
/* 2521:2628 */       fechaReferencia = sdf.parse(fechaReferenciaInicial.toString());
/* 2522:2629 */       distanciaReferencia = distanciaReferenciaInicial;
/* 2523:     */       
/* 2524:     */ 
/* 2525:2632 */       StringBuffer ultimaFecha = ManejoFechas.getUltimaFechaPorUsuario(vehiculo.getVehi_usuc_cod(), revisiones2);
/* 2526:     */       
/* 2527:2634 */       ManejoFechas.setFechaRevision(vehiculo, mantenimientoGeneral, revisiones2, distanciaReferencia, fechaReferencia, ultimaFecha);
/* 2528:     */       
/* 2529:     */ 
/* 2530:     */ 
/* 2531:2638 */       Iterator rev_iterator = revisiones2.iterator();
/* 2532:2639 */       while (rev_iterator.hasNext())
/* 2533:     */       {
/* 2534:2640 */         RevisionesVehiculo revision = (RevisionesVehiculo)rev_iterator.next();
/* 2535:2641 */         if (revision.getRveh_bloqueado().compareTo(BigDecimal.ZERO) == 0)
/* 2536:     */         {
/* 2537:2642 */           BigDecimal diferencia = distanciaReferenciaInicial.subtract(revision.getRveh_control_kms());
/* 2538:2643 */           ManejoFechas.setFechaRevision(vehiculo, revision, diferencia, fechaReferencia, ultimaFecha);
/* 2539:     */         }
/* 2540:     */       }
/* 2541:2646 */       int y = 0;
/* 2542:2647 */       vehiculosCompleto.setRevisiones(revisiones2);
/* 2543:2648 */       vehiculosCompletoDAO.update(vehiculosCompleto, vehiculo.getVehi_cod());
/* 2544:     */     }
/* 2545:     */     catch (Exception e)
/* 2546:     */     {
/* 2547:2651 */       e.printStackTrace();
/* 2548:2652 */       return mapping.findForward("failure");
/* 2549:     */     }
/* 2550:2655 */     return mapping.findForward("success");
/* 2551:     */   }
/* 2552:     */   
/* 2553:     */   private ActionForward performLoadControles(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 2554:     */   {
/* 2555:2658 */     VehiculosCompletoForm form = (VehiculosCompletoForm)actionForm;
/* 2556:     */     try
/* 2557:     */     {
/* 2558:2661 */       TipoVehiculoDAO tipoVehiculoDAO = new TipoVehiculoDAO();
/* 2559:2662 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 2560:2663 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 2561:2664 */         tipoVehiculoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 2562:     */       }
/* 2563:2666 */       tipoVehiculoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 2564:2667 */       List tipoVehiculos = tipoVehiculoDAO.list();
/* 2565:2668 */       request.setAttribute("TIPOVEHICULO", tipoVehiculos);
/* 2566:     */       
/* 2567:2670 */       PaisDAO paisDAO = new PaisDAO();
/* 2568:2671 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 2569:2672 */         paisDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 2570:     */       }
/* 2571:2674 */       paisDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 2572:2675 */       List paises = paisDAO.list();
/* 2573:2676 */       request.setAttribute("PAISES", paises);
/* 2574:     */       
/* 2575:2678 */       List ciudades = null;
/* 2576:2679 */       CiudadDAO ciudadesDAO = new CiudadDAO();
/* 2577:2680 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 2578:2681 */         ciudadesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 2579:     */       }
/* 2580:2683 */       ciudadesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 2581:2684 */       if (paises.size() > 0) {
/* 2582:2685 */         if (!form.getPveh_pais_cod().equals("0")) {
/* 2583:2686 */           ciudades = ciudadesDAO.search(form.getPveh_pais_cod());
/* 2584:     */         } else {
/* 2585:2688 */           ciudades = ciudadesDAO.search(((Paises)paises.get(0)).getPais_cod().toString());
/* 2586:     */         }
/* 2587:     */       }
/* 2588:2691 */       request.setAttribute("CIUDADES", ciudades);
/* 2589:     */       
/* 2590:     */ 
/* 2591:     */ 
/* 2592:2695 */       form.setVehi_feccomp(ManejoFechas.FormateoFecha(form.getVehi_feccomp()));
/* 2593:2696 */       form.setVehi_fechaodometro(ManejoFechas.FormateoFecha(form.getVehi_fechaodometro()));
/* 2594:2697 */       form.setPveh_fecnacim(ManejoFechas.FormateoFecha(form.getPveh_fecnacim()));
/* 2595:2698 */       form.setFechaMantenimientosBasicos(ManejoFechas.FormateoFecha(form.getFechaMantenimientosBasicos()));
/* 2596:2699 */       form.setMant_control_fec(ManejoFechas.FormateoFecha(form.getMant_control_fec()));
/* 2597:2700 */       request.setAttribute("ODOMETROENCERO", "0");
/* 2598:2701 */       if (form.getVehi_fechaencero().compareTo(form.getTempcero()) == 1)
/* 2599:     */       {
/* 2600:2702 */         form.setVehi_fechaencero(ManejoFechas.FormateoFecha(form.getVehi_fechaencero()));
/* 2601:2703 */         request.setAttribute("ODOMETROENCERO", ManejoFechas.FormateoFecha(form.getVehi_fechaencero()));
/* 2602:     */       }
/* 2603:     */       else
/* 2604:     */       {
/* 2605:2705 */         form.setVehi_fechaencero(ManejoFechas.FormateoFecha(form.getTempcero()));
/* 2606:2706 */         request.setAttribute("ODOMETROENCERO", ManejoFechas.FormateoFecha(form.getTempcero()));
/* 2607:     */       }
/* 2608:2709 */       form.setTempcero(ManejoFechas.FormateoFecha(form.getTempcero()));
/* 2609:     */       
/* 2610:     */ 
/* 2611:2712 */       String str = form.getRevisionesBloqueadasA();
/* 2612:2713 */       if (str.compareTo("-1") == 0) {
/* 2613:2714 */         str = "";
/* 2614:     */       }
/* 2615:2719 */       RevisionAlternativaDAO revisionAlternativaDAO = new RevisionAlternativaDAO();
/* 2616:2720 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 2617:2721 */         revisionAlternativaDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 2618:     */       }
/* 2619:2723 */       revisionAlternativaDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 2620:2724 */       List revisionAlternativas = revisionAlternativaDAO.list();
/* 2621:2725 */       request.setAttribute("alternativas", revisionAlternativas);
/* 2622:     */       
/* 2623:2727 */       RevisionAccionDAO revisionAccionDAO = new RevisionAccionDAO();
/* 2624:2728 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 2625:2729 */         revisionAccionDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 2626:     */       }
/* 2627:2731 */       revisionAccionDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 2628:2732 */       List revisionAcciones = revisionAccionDAO.list();
/* 2629:2733 */       request.setAttribute("acciones", revisionAcciones);
/* 2630:     */       
/* 2631:2735 */       MarcasAutosDAO marcasAutoDAO = new MarcasAutosDAO();
/* 2632:2736 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 2633:2737 */         marcasAutoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 2634:     */       }
/* 2635:2739 */       marcasAutoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 2636:2740 */       List marcasAuto = marcasAutoDAO.list();
/* 2637:2741 */       request.setAttribute("MARCASAUTOS", marcasAuto);
/* 2638:     */       
/* 2639:2743 */       List revisionesVehiculo = (List)request.getSession().getAttribute("REVISIONES");
/* 2640:2744 */       BigDecimal bloqueado = BigDecimal.TEN;
/* 2641:2745 */       int x = 0;
/* 2642:2747 */       while (x < revisionesVehiculo.size())
/* 2643:     */       {
/* 2644:2748 */         if (str.length() > 0)
/* 2645:     */         {
/* 2646:2749 */           String[] arrayBloqueadas = str.split(",");
/* 2647:2750 */           for (int contador = 0; contador < arrayBloqueadas.length; contador++)
/* 2648:     */           {
/* 2649:2751 */             if (request.getParameter("mantenimientosBasicos" + x) != null)
/* 2650:     */             {
/* 2651:2752 */               ((RevisionesVehiculo)revisionesVehiculo.get(x)).setRveh_control_fec(new BigDecimal(ManejoFechas.getChangeFecha(form.getFechaMantenimientosBasicos())));
/* 2652:2753 */               ((RevisionesVehiculo)revisionesVehiculo.get(x)).setRveh_control_kms(new BigDecimal(form.getDistanciaMantenimientosBasicos()));
/* 2653:2754 */               ((RevisionesVehiculo)revisionesVehiculo.get(x)).setRveh_bloqueado(new BigDecimal("2"));
/* 2654:     */             }
/* 2655:2756 */             request.setAttribute("rveh_acc_des" + x, revisionAccionDAO.retrive(((RevisionesVehiculo)revisionesVehiculo.get(x)).getRveh_acc_cod()).getRacc_cod().toString());
/* 2656:2757 */             request.setAttribute("rveh_alt_cod" + x, revisionAlternativaDAO.retrive(((RevisionesVehiculo)revisionesVehiculo.get(x)).getRveh_alt_cod()).getRalt_des());
/* 2657:2758 */             int valornuevo = new Integer(arrayBloqueadas[contador]).intValue();
/* 2658:2759 */             if (x == valornuevo - 1) {
/* 2659:2760 */               ((RevisionesVehiculo)revisionesVehiculo.get(x)).setRveh_bloqueado(BigDecimal.ONE);
/* 2660:     */             }
/* 2661:     */           }
/* 2662:     */         }
/* 2663:     */         else
/* 2664:     */         {
/* 2665:2765 */           if (request.getParameter("mantenimientosBasicos" + x) != null)
/* 2666:     */           {
/* 2667:2766 */             bloqueado = ((RevisionesVehiculo)revisionesVehiculo.get(x)).getRveh_bloqueado();
/* 2668:2767 */             if (bloqueado.compareTo(BigDecimal.ONE) == 0) {
/* 2669:2768 */               ((RevisionesVehiculo)revisionesVehiculo.get(x)).setRveh_bloqueado(BigDecimal.ZERO);
/* 2670:     */             }
/* 2671:2770 */             ((RevisionesVehiculo)revisionesVehiculo.get(x)).setRveh_control_fec(new BigDecimal(ManejoFechas.getChangeFecha(form.getFechaMantenimientosBasicos())));
/* 2672:2771 */             ((RevisionesVehiculo)revisionesVehiculo.get(x)).setRveh_control_kms(new BigDecimal(form.getDistanciaMantenimientosBasicos()));
/* 2673:     */           }
/* 2674:2774 */           request.setAttribute("rveh_acc_des" + x, revisionAccionDAO.retrive(((RevisionesVehiculo)revisionesVehiculo.get(x)).getRveh_acc_cod()).getRacc_cod().toString());
/* 2675:2775 */           request.setAttribute("rveh_alt_cod" + x, revisionAlternativaDAO.retrive(((RevisionesVehiculo)revisionesVehiculo.get(x)).getRveh_alt_cod()).getRalt_des());
/* 2676:     */         }
/* 2677:2777 */         x++;
/* 2678:     */       }
/* 2679:2780 */       List combustibles = (List)request.getSession().getAttribute("COMBUSTIBLEVEHICULO");
/* 2680:2781 */       request.setAttribute("COMBUSTIBLEVEHICULO", combustibles);
/* 2681:     */       
/* 2682:2783 */       IdiomaDAO idiomaDAO = new IdiomaDAO();
/* 2683:2784 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 2684:2785 */         idiomaDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 2685:     */       }
/* 2686:2787 */       request.setAttribute("IDIOMAS", idiomaDAO.list());
/* 2687:     */     }
/* 2688:     */     catch (Exception e)
/* 2689:     */     {
/* 2690:2791 */       e.printStackTrace();
/* 2691:2792 */       return mapping.findForward("failure");
/* 2692:     */     }
/* 2693:2795 */     return mapping.findForward("success");
/* 2694:     */   }
/* 2695:     */   
/* 2696:     */   private ActionForward performSaveFirst(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 2697:     */   {
/* 2698:2799 */     if (isTokenValid(request, true))
/* 2699:     */     {
/* 2700:2800 */       VehiculosCompletoForm form = (VehiculosCompletoForm)actionForm;
/* 2701:     */       try
/* 2702:     */       {
/* 2703:2802 */         UsuarioCar usuarioCar = (UsuarioCar)request.getSession().getAttribute("usuarioCar");
/* 2704:2803 */         form.setVehi_fecinscripcion(ManejoFechas.getFechaActual());
/* 2705:     */         
/* 2706:2805 */         VehiculosCompleto vehiculosCompleto = new VehiculosCompleto();
/* 2707:2806 */         Vehiculos vehiculo = new Vehiculos();
/* 2708:2808 */         if (form.getPveh_indpais1().length() == 0) {
/* 2709:2809 */           form.setPveh_indpais1("0");
/* 2710:     */         }
/* 2711:2811 */         if (form.getPveh_indciudad1().length() == 0) {
/* 2712:2812 */           form.setPveh_indciudad1("0");
/* 2713:     */         }
/* 2714:2814 */         if (form.getPveh_indpais2().length() == 0) {
/* 2715:2815 */           form.setPveh_indpais2("0");
/* 2716:     */         }
/* 2717:2817 */         if (Integer.parseInt(form.getVehi_num_dias_no_mail()) < 2) {
/* 2718:2818 */           form.setVehi_num_dias_no_mail("2");
/* 2719:     */         }
/* 2720:2821 */         vehiculosCompleto.setVehiculo(vehiculo);
/* 2721:2822 */         InicializaData.inicializa(vehiculo.getClass(), vehiculo);
/* 2722:2823 */         BeanUtils.copyProperties(vehiculo, form);
/* 2723:2824 */         vehiculo.setVehi_fechaodometroinicial(new BigDecimal(form.getVehi_fechaodometro()));
/* 2724:2825 */         vehiculo.setVehi_kmsodometroinicial(new BigDecimal(form.getVehi_kmsact()));
/* 2725:2826 */         vehiculo.setVehi_usuc_cod(usuarioCar.getUsuc_cod());
/* 2726:     */         
/* 2727:2828 */         PropietariosVehiculos propietariosVehiculos = new PropietariosVehiculos();
/* 2728:2829 */         vehiculosCompleto.setPropietario(propietariosVehiculos);
/* 2729:2830 */         InicializaData.inicializa(propietariosVehiculos.getClass(), propietariosVehiculos);
/* 2730:2831 */         BeanUtils.copyProperties(propietariosVehiculos, form);
/* 2731:     */         
/* 2732:2833 */         MantenimientoGeneral mantenimientoGeneral = new MantenimientoGeneral();
/* 2733:2834 */         vehiculosCompleto.setMantenimientoGeneral(mantenimientoGeneral);
/* 2734:2835 */         InicializaData.inicializa(mantenimientoGeneral.getClass(), mantenimientoGeneral);
/* 2735:2836 */         BeanUtils.copyProperties(mantenimientoGeneral, form);
/* 2736:     */         
/* 2737:2838 */         int x = 0;
/* 2738:2839 */         RevisionesVehiculoDAO revisionesVehiculoDAO = new RevisionesVehiculoDAO();
/* 2739:2840 */         RevisionesDAO revisionesDAO = new RevisionesDAO();
/* 2740:2841 */         Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 2741:2842 */         if ((servidor != null) && (servidor.getServ_cod() != null))
/* 2742:     */         {
/* 2743:2843 */           revisionesVehiculoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 2744:2844 */           revisionesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 2745:     */         }
/* 2746:2846 */         revisionesVehiculoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 2747:2847 */         revisionesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 2748:2848 */         List revisiones = revisionesDAO.list();
/* 2749:2850 */         if (form.getVehi_distancia().equals("M"))
/* 2750:     */         {
/* 2751:2851 */           vehiculo.setVehi_enero(new BigDecimal(form.getVehi_enero()).multiply(IConstantes.FACTOR_KMS_MILLAS));
/* 2752:2852 */           vehiculo.setVehi_febrero(new BigDecimal(form.getVehi_febrero()).multiply(IConstantes.FACTOR_KMS_MILLAS));
/* 2753:2853 */           vehiculo.setVehi_marzo(new BigDecimal(form.getVehi_marzo()).multiply(IConstantes.FACTOR_KMS_MILLAS));
/* 2754:2854 */           vehiculo.setVehi_abril(new BigDecimal(form.getVehi_abril()).multiply(IConstantes.FACTOR_KMS_MILLAS));
/* 2755:2855 */           vehiculo.setVehi_mayo(new BigDecimal(form.getVehi_mayo()).multiply(IConstantes.FACTOR_KMS_MILLAS));
/* 2756:2856 */           vehiculo.setVehi_junio(new BigDecimal(form.getVehi_junio()).multiply(IConstantes.FACTOR_KMS_MILLAS));
/* 2757:2857 */           vehiculo.setVehi_julio(new BigDecimal(form.getVehi_julio()).multiply(IConstantes.FACTOR_KMS_MILLAS));
/* 2758:2858 */           vehiculo.setVehi_agosto(new BigDecimal(form.getVehi_agosto()).multiply(IConstantes.FACTOR_KMS_MILLAS));
/* 2759:2859 */           vehiculo.setVehi_septiembre(new BigDecimal(form.getVehi_septiembre()).multiply(IConstantes.FACTOR_KMS_MILLAS));
/* 2760:2860 */           vehiculo.setVehi_octubre(new BigDecimal(form.getVehi_octubre()).multiply(IConstantes.FACTOR_KMS_MILLAS));
/* 2761:2861 */           vehiculo.setVehi_noviembre(new BigDecimal(form.getVehi_noviembre()).multiply(IConstantes.FACTOR_KMS_MILLAS));
/* 2762:2862 */           vehiculo.setVehi_diciembre(new BigDecimal(form.getVehi_diciembre()).multiply(IConstantes.FACTOR_KMS_MILLAS));
/* 2763:     */         }
/* 2764:2865 */         List revisionesVehiculo = new ArrayList();
/* 2765:2866 */         while (x < revisiones.size())
/* 2766:     */         {
/* 2767:2867 */           Revisiones revision = (Revisiones)revisiones.get(x);
/* 2768:     */           
/* 2769:2869 */           RevisionesVehiculo revisionVehiculo = new RevisionesVehiculo();
/* 2770:2870 */           InicializaData.inicializa(revisionVehiculo.getClass(), revisionVehiculo);
/* 2771:     */           
/* 2772:2872 */           revisionVehiculo.setRveh_cod(revision.getRev_cod());
/* 2773:2873 */           revisionVehiculo.setRveh_actividad(revision.getRev_actividad());
/* 2774:2874 */           revisionVehiculo.setRveh_acc_cod(revision.getRev_acc_cod());
/* 2775:2875 */           revisionVehiculo.setRveh_alt_cod(revision.getRev_alt_cod());
/* 2776:2876 */           revisionVehiculo.setRveh_cada_cdk(revision.getRev_cada_cdk());
/* 2777:2877 */           revisionVehiculo.setRveh_cada_cdm(revision.getRev_cada_cdm());
/* 2778:     */           
/* 2779:2879 */           revisionVehiculo.setRveh_veh_cod(vehiculosCompleto.getVehiculo().getVehi_cod());
/* 2780:2880 */           if (revisionVehiculo.getRveh_cada_cdk().equals(new BigDecimal(0))) {
/* 2781:2881 */             revisionVehiculo.setRveh_alt_cod(new BigDecimal(2));
/* 2782:     */           }
/* 2783:2883 */           if (form.getVehi_distancia().equals("M"))
/* 2784:     */           {
/* 2785:2884 */             revisionVehiculo.setRveh_cada_cdk(revisionVehiculo.getRveh_cada_cdk().multiply(IConstantes.FACTOR_KMS_MILLAS));
/* 2786:2885 */             revisionVehiculo.setRveh_cada_cdk(new BigDecimal(revisionVehiculo.getRveh_cada_cdk().toBigInteger()));
/* 2787:     */           }
/* 2788:2887 */           revisionesVehiculo.add(revisionVehiculo);
/* 2789:2888 */           x++;
/* 2790:     */         }
/* 2791:2892 */         SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
/* 2792:2893 */         BigDecimal distanciaReferencia = BigDecimal.ZERO;
/* 2793:2894 */         Date fechaReferencia = null;
/* 2794:2895 */         if (vehiculo.getVehi_kmsact().compareTo(distanciaReferencia) == 1)
/* 2795:     */         {
/* 2796:2896 */           distanciaReferencia = vehiculo.getVehi_kmsact();
/* 2797:     */           try
/* 2798:     */           {
/* 2799:2898 */             fechaReferencia = sdf.parse(vehiculo.getVehi_fechaodometro().toString());
/* 2800:     */           }
/* 2801:     */           catch (Exception e)
/* 2802:     */           {
/* 2803:2900 */             fechaReferencia = new Date();
/* 2804:     */           }
/* 2805:     */         }
/* 2806:2902 */         if (mantenimientoGeneral.getMant_control_kms().compareTo(distanciaReferencia) == 1)
/* 2807:     */         {
/* 2808:2903 */           distanciaReferencia = mantenimientoGeneral.getMant_control_kms();
/* 2809:     */           try
/* 2810:     */           {
/* 2811:2905 */             fechaReferencia = sdf.parse(mantenimientoGeneral.getMant_control_fec().toString());
/* 2812:     */           }
/* 2813:     */           catch (Exception e)
/* 2814:     */           {
/* 2815:2907 */             fechaReferencia = new Date();
/* 2816:     */           }
/* 2817:     */         }
/* 2818:2909 */         for (Iterator revisionesIterator = revisionesVehiculo.iterator(); revisionesIterator.hasNext();)
/* 2819:     */         {
/* 2820:2910 */           RevisionesVehiculo revisionVehiculo = (RevisionesVehiculo)revisionesIterator.next();
/* 2821:2911 */           if ((revisionVehiculo.getRveh_bloqueado().compareTo(BigDecimal.ZERO) == 0) && 
/* 2822:2912 */             (revisionVehiculo.getRveh_control_kms().compareTo(distanciaReferencia) == 1))
/* 2823:     */           {
/* 2824:2913 */             distanciaReferencia = revisionVehiculo.getRveh_control_kms();
/* 2825:     */             try
/* 2826:     */             {
/* 2827:2915 */               fechaReferencia = sdf.parse(revisionVehiculo.getRveh_control_fec().toString());
/* 2828:     */             }
/* 2829:     */             catch (Exception e)
/* 2830:     */             {
/* 2831:2917 */               fechaReferencia = new Date();
/* 2832:     */             }
/* 2833:     */           }
/* 2834:     */         }
/* 2835:2923 */         StringBuffer ultimaFecha = new StringBuffer(form.getVehi_fechaodometro());
/* 2836:2924 */         ultimaFecha.append("-");
/* 2837:2925 */         ultimaFecha.append(form.getVehi_kmsact());
/* 2838:2926 */         ManejoFechas.setFechaRevision(vehiculo, mantenimientoGeneral, revisiones, distanciaReferencia, fechaReferencia, ultimaFecha);
/* 2839:     */         
/* 2840:2928 */         Iterator rev_iterator = revisionesVehiculo.iterator();
/* 2841:2929 */         while (rev_iterator.hasNext())
/* 2842:     */         {
/* 2843:2930 */           RevisionesVehiculo revision = (RevisionesVehiculo)rev_iterator.next();
/* 2844:2931 */           if (revision.getRveh_bloqueado().compareTo(BigDecimal.ZERO) == 0) {
/* 2845:2932 */             ManejoFechas.setFechaRevision(vehiculo, revision, distanciaReferencia, fechaReferencia, ultimaFecha);
/* 2846:     */           }
/* 2847:     */         }
/* 2848:2936 */         vehiculosCompleto.setRevisiones(revisionesVehiculo);
/* 2849:     */         
/* 2850:2938 */         GastosNoAnualesDAO gastosNoAnualesDAO = new GastosNoAnualesDAO();
/* 2851:2939 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 2852:2940 */           gastosNoAnualesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 2853:     */         }
/* 2854:2942 */         gastosNoAnualesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 2855:2943 */         List gastosNoAnuales = gastosNoAnualesDAO.list();
/* 2856:2944 */         List gastosVehiculosNoAnuales = new ArrayList();
/* 2857:2945 */         x = 0;
/* 2858:2946 */         while (x < gastosNoAnuales.size())
/* 2859:     */         {
/* 2860:2947 */           GastosNoAnuales gastoNoAnual = (GastosNoAnuales)gastosNoAnuales.get(x);
/* 2861:2948 */           GastosVehiculosNoAnuales gastoVehiculoNoAnual = new GastosVehiculosNoAnuales();
/* 2862:2949 */           InicializaData.inicializa(gastoVehiculoNoAnual.getClass(), gastoVehiculoNoAnual);
/* 2863:     */           
/* 2864:2951 */           gastoVehiculoNoAnual.setGasv_cod(gastoNoAnual.getGas_cod());
/* 2865:2952 */           gastoVehiculoNoAnual.setGasv_descripcion(gastoNoAnual.getGas_descripcion());
/* 2866:2953 */           gastoVehiculoNoAnual.setGasv_fechaini(new BigDecimal(ManejoFechas.getFechaActual()));
/* 2867:2954 */           gastoVehiculoNoAnual.setGasv_fechafin(new BigDecimal(ManejoFechas.getFechaActual()).add(new BigDecimal(10000)));
/* 2868:2955 */           gastoVehiculoNoAnual.setGasv_valor(BigDecimal.ZERO);
/* 2869:2956 */           gastoVehiculoNoAnual.setGasv_veh_cod(vehiculosCompleto.getVehiculo().getVehi_cod());
/* 2870:     */           
/* 2871:2958 */           gastosVehiculosNoAnuales.add(gastoVehiculoNoAnual);
/* 2872:2959 */           x++;
/* 2873:     */         }
/* 2874:2961 */         vehiculosCompleto.setGastosNoAnuales(gastosVehiculosNoAnuales);
/* 2875:     */         
/* 2876:2963 */         GastosAnualesDAO gastosAnualesDAO = new GastosAnualesDAO();
/* 2877:2964 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 2878:2965 */           gastosAnualesDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 2879:     */         }
/* 2880:2967 */         gastosAnualesDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 2881:2968 */         List gastosAnuales = gastosAnualesDAO.list();
/* 2882:2969 */         List gastosVehiculosAnuales = new ArrayList();
/* 2883:2970 */         x = 0;
/* 2884:2971 */         while (x < gastosAnuales.size())
/* 2885:     */         {
/* 2886:2972 */           GastosAnuales gastoAnual = (GastosAnuales)gastosAnuales.get(x);
/* 2887:2973 */           GastosVehiculosAnuales gastoVehiculoAnual = new GastosVehiculosAnuales();
/* 2888:2974 */           InicializaData.inicializa(gastoVehiculoAnual.getClass(), gastoVehiculoAnual);
/* 2889:     */           
/* 2890:2976 */           gastoVehiculoAnual.setGasv_cod(gastoAnual.getGas_cod());
/* 2891:2977 */           gastoVehiculoAnual.setGasv_descripcion(gastoAnual.getGas_descripcion());
/* 2892:2978 */           gastoVehiculoAnual.setGasv_fechaini(new BigDecimal(ManejoFechas.getFechaActual()));
/* 2893:2979 */           gastoVehiculoAnual.setGasv_fechafin(new BigDecimal(ManejoFechas.getFechaActual()).add(new BigDecimal(10000)));
/* 2894:2980 */           gastoVehiculoAnual.setGasv_valor(BigDecimal.ZERO);
/* 2895:2981 */           gastoVehiculoAnual.setGasv_veh_cod(vehiculosCompleto.getVehiculo().getVehi_cod());
/* 2896:     */           
/* 2897:2983 */           gastosVehiculosAnuales.add(gastoVehiculoAnual);
/* 2898:2984 */           x++;
/* 2899:     */         }
/* 2900:2986 */         vehiculosCompleto.setGastosAnuales(gastosVehiculosAnuales);
/* 2901:     */         
/* 2902:2988 */         GastosMecanicaDAO gastosMecanicaDAO = new GastosMecanicaDAO();
/* 2903:2989 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 2904:2990 */           gastosMecanicaDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 2905:     */         }
/* 2906:2992 */         gastosMecanicaDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 2907:2993 */         List gastosMecanica = gastosMecanicaDAO.list();
/* 2908:2994 */         List gastosVehiculosMecanica = new ArrayList();
/* 2909:2995 */         x = 0;
/* 2910:2996 */         while (x < gastosMecanica.size())
/* 2911:     */         {
/* 2912:2997 */           GastosMecanica gastoMecanica = (GastosMecanica)gastosMecanica.get(x);
/* 2913:2998 */           GastosVehiculosMecanica gastoVehiculoMecanica = new GastosVehiculosMecanica();
/* 2914:2999 */           InicializaData.inicializa(gastoVehiculoMecanica.getClass(), gastoVehiculoMecanica);
/* 2915:     */           
/* 2916:3001 */           gastoVehiculoMecanica.setGasv_cod(gastoMecanica.getGas_cod());
/* 2917:3002 */           gastoVehiculoMecanica.setGasv_descripcion(gastoMecanica.getGas_descripcion());
/* 2918:3003 */           gastoVehiculoMecanica.setGasv_fechaini(new BigDecimal(ManejoFechas.getFechaActual()));
/* 2919:3004 */           gastoVehiculoMecanica.setGasv_fechafin(new BigDecimal(ManejoFechas.getFechaActual()));
/* 2920:3005 */           gastoVehiculoMecanica.setGasv_valor(BigDecimal.ZERO);
/* 2921:3006 */           gastoVehiculoMecanica.setGasv_veh_cod(vehiculosCompleto.getVehiculo().getVehi_cod());
/* 2922:     */           
/* 2923:3008 */           gastosVehiculosMecanica.add(gastoVehiculoMecanica);
/* 2924:3009 */           x++;
/* 2925:     */         }
/* 2926:3011 */         vehiculosCompleto.setGastosMecanica(gastosVehiculosMecanica);
/* 2927:     */         
/* 2928:3013 */         VehiculosCompletoDAO vehiculosCompletoDAO = new VehiculosCompletoDAO();
/* 2929:3014 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 2930:3015 */           vehiculosCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 2931:     */         }
/* 2932:3018 */         vehiculosCompletoDAO.insert(vehiculosCompleto);
/* 2933:     */       }
/* 2934:     */       catch (Exception e)
/* 2935:     */       {
/* 2936:3021 */         e.printStackTrace();
/* 2937:3022 */         return mapping.findForward("failure");
/* 2938:     */       }
/* 2939:     */     }
/* 2940:     */     else
/* 2941:     */     {
/* 2942:3027 */       return mapping.findForward("failure");
/* 2943:     */     }
/* 2944:3029 */     return mapping.findForward("success");
/* 2945:     */   }
/* 2946:     */   
/* 2947:     */   private ActionForward performSaveCurva(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 2948:     */   {
/* 2949:3032 */     VehiculosCompletoForm form = (VehiculosCompletoForm)actionForm;
/* 2950:     */     try
/* 2951:     */     {
/* 2952:3034 */       UsuarioCar usuarioCar = (UsuarioCar)request.getSession().getAttribute("usuarioCar");
/* 2953:     */       
/* 2954:3036 */       SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
/* 2955:     */       
/* 2956:3038 */       VehiculosDAO vehiculosDAO = new VehiculosDAO();
/* 2957:3039 */       Vehiculos vehiculo = vehiculosDAO.retrieveCarByUser(usuarioCar.getUsuc_cod());
/* 2958:3040 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 2959:     */       
/* 2960:     */ 
/* 2961:     */ 
/* 2962:3044 */       VehiculosCompletoDAO vehiculosCompletoDAO = new VehiculosCompletoDAO();
/* 2963:3045 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 2964:3046 */         vehiculosCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 2965:     */       }
/* 2966:3048 */       VehiculosCompleto vehiculosCompleto = vehiculosCompletoDAO.retrieve(vehiculo.getVehi_cod());
/* 2967:3049 */       vehiculosCompleto.setVehiculo(vehiculo);
/* 2968:3051 */       if (form.getVehi_enero().compareTo(new String("0")) != 0) {
/* 2969:3052 */         vehiculo.setVehi_enero(new BigDecimal(form.getVehi_enero()));
/* 2970:     */       }
/* 2971:3054 */       if (form.getVehi_febrero().compareTo(new String("0")) != 0) {
/* 2972:3055 */         vehiculo.setVehi_febrero(new BigDecimal(form.getVehi_febrero()));
/* 2973:     */       }
/* 2974:3057 */       if (form.getVehi_marzo().compareTo(new String("0")) != 0) {
/* 2975:3058 */         vehiculo.setVehi_marzo(new BigDecimal(form.getVehi_marzo()));
/* 2976:     */       }
/* 2977:3060 */       if (form.getVehi_abril().compareTo(new String("0")) != 0) {
/* 2978:3061 */         vehiculo.setVehi_abril(new BigDecimal(form.getVehi_abril()));
/* 2979:     */       }
/* 2980:3063 */       if (form.getVehi_mayo().compareTo(new String("0")) != 0) {
/* 2981:3064 */         vehiculo.setVehi_mayo(new BigDecimal(form.getVehi_mayo()));
/* 2982:     */       }
/* 2983:3066 */       if (form.getVehi_junio().compareTo(new String("0")) != 0) {
/* 2984:3067 */         vehiculo.setVehi_junio(new BigDecimal(form.getVehi_junio()));
/* 2985:     */       }
/* 2986:3069 */       if (form.getVehi_julio().compareTo(new String("0")) != 0) {
/* 2987:3070 */         vehiculo.setVehi_julio(new BigDecimal(form.getVehi_julio()));
/* 2988:     */       }
/* 2989:3072 */       if (form.getVehi_agosto().compareTo(new String("0")) != 0) {
/* 2990:3073 */         vehiculo.setVehi_agosto(new BigDecimal(form.getVehi_agosto()));
/* 2991:     */       }
/* 2992:3075 */       if (form.getVehi_septiembre().compareTo(new String("0")) != 0) {
/* 2993:3076 */         vehiculo.setVehi_septiembre(new BigDecimal(form.getVehi_septiembre()));
/* 2994:     */       }
/* 2995:3078 */       if (form.getVehi_octubre().compareTo(new String("0")) != 0) {
/* 2996:3079 */         vehiculo.setVehi_octubre(new BigDecimal(form.getVehi_enero()));
/* 2997:     */       }
/* 2998:3081 */       if (form.getVehi_noviembre().compareTo(new String("0")) != 0) {
/* 2999:3082 */         vehiculo.setVehi_noviembre(new BigDecimal(form.getVehi_noviembre()));
/* 3000:     */       }
/* 3001:3084 */       if (form.getVehi_diciembre().compareTo(new String("0")) != 0) {
/* 3002:3085 */         vehiculo.setVehi_diciembre(new BigDecimal(form.getVehi_diciembre()));
/* 3003:     */       }
/* 3004:3087 */       if (form.getVehi_promedio().compareTo(new String("0")) != 0) {
/* 3005:3088 */         vehiculo.setVehi_promedio(new BigDecimal(form.getVehi_promedio()));
/* 3006:     */       }
/* 3007:3092 */       BigDecimal[] list = { vehiculo.getVehi_enero().divideToIntegralValue(new BigDecimal(31.0D)), 
/* 3008:3093 */         vehiculo.getVehi_febrero().divideToIntegralValue(new BigDecimal(28.0D)), 
/* 3009:3094 */         vehiculo.getVehi_marzo().divideToIntegralValue(new BigDecimal(31.0D)), 
/* 3010:3095 */         vehiculo.getVehi_abril().divideToIntegralValue(new BigDecimal(30.0D)), 
/* 3011:3096 */         vehiculo.getVehi_mayo().divideToIntegralValue(new BigDecimal(31.0D)), 
/* 3012:3097 */         vehiculo.getVehi_junio().divideToIntegralValue(new BigDecimal(30.0D)), 
/* 3013:3098 */         vehiculo.getVehi_julio().divideToIntegralValue(new BigDecimal(31.0D)), 
/* 3014:3099 */         vehiculo.getVehi_agosto().divideToIntegralValue(new BigDecimal(31.0D)), 
/* 3015:3100 */         vehiculo.getVehi_septiembre().divideToIntegralValue(new BigDecimal(30.0D)), 
/* 3016:3101 */         vehiculo.getVehi_octubre().divideToIntegralValue(new BigDecimal(31.0D)), 
/* 3017:3102 */         vehiculo.getVehi_noviembre().divideToIntegralValue(new BigDecimal(30.0D)), 
/* 3018:3103 */         vehiculo.getVehi_diciembre().divideToIntegralValue(new BigDecimal(31.0D)) };
/* 3019:3104 */       Object promedio = list;
/* 3020:     */       
/* 3021:     */ 
/* 3022:     */ 
/* 3023:     */ 
/* 3024:     */ 
/* 3025:     */ 
/* 3026:     */ 
/* 3027:     */ 
/* 3028:     */ 
/* 3029:3114 */       MantenimientoGeneral mantenimientoGeneral = vehiculosCompleto.getMantenimientoGeneral();
/* 3030:3115 */       if ((ManejoFechas.restaFechas(mantenimientoGeneral.getMant_control_fec().toString(), ManejoFechas.getFechaActual()) < 0) || (ManejoFechas.restaFechas(mantenimientoGeneral.getMant_control_fec().toString(), ManejoFechas.getFechaActual()) == 0)) {
/* 3031:3116 */         mantenimientoGeneral.setMant_control_fec(new BigDecimal(ManejoFechas.getFechaActual()));
/* 3032:     */       }
/* 3033:3119 */       BigDecimal odo_rev = mantenimientoGeneral.getMant_cada_cdk();
/* 3034:3120 */       String ultimarevision = mantenimientoGeneral.getMant_control_fec().toString();
/* 3035:3121 */       String fecinscripcion = vehiculo.getVehi_fechaodometro().toString();
/* 3036:3122 */       BigDecimal odo_actual = vehiculo.getVehi_kmsact();
/* 3037:3123 */       Date fechaActual = new Date();
/* 3038:     */       
/* 3039:3125 */       BigDecimal meses = mantenimientoGeneral.getMant_cada_cdm();
/* 3040:     */       
/* 3041:3127 */       List revisiones = vehiculosCompleto.getRevisiones();
/* 3042:     */       
/* 3043:     */ 
/* 3044:3130 */       SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
/* 3045:3131 */       BigDecimal distanciaReferencia = BigDecimal.ZERO;
/* 3046:3132 */       Date fechaReferencia = null;
/* 3047:3133 */       if (vehiculo.getVehi_kmsact().compareTo(distanciaReferencia) == 1)
/* 3048:     */       {
/* 3049:3134 */         distanciaReferencia = vehiculo.getVehi_kmsact();
/* 3050:     */         try
/* 3051:     */         {
/* 3052:3136 */           fechaReferencia = sdf.parse(vehiculo.getVehi_fechaodometro().toString());
/* 3053:     */         }
/* 3054:     */         catch (Exception e)
/* 3055:     */         {
/* 3056:3138 */           fechaReferencia = new Date();
/* 3057:     */         }
/* 3058:     */       }
/* 3059:3140 */       if (mantenimientoGeneral.getMant_control_kms().compareTo(distanciaReferencia) == 1)
/* 3060:     */       {
/* 3061:3141 */         distanciaReferencia = mantenimientoGeneral.getMant_control_kms();
/* 3062:     */         try
/* 3063:     */         {
/* 3064:3143 */           fechaReferencia = sdf.parse(mantenimientoGeneral.getMant_control_fec().toString());
/* 3065:     */         }
/* 3066:     */         catch (Exception e)
/* 3067:     */         {
/* 3068:3145 */           fechaReferencia = new Date();
/* 3069:     */         }
/* 3070:     */       }
/* 3071:3147 */       for (Iterator revisionesIterator = revisiones.iterator(); revisionesIterator.hasNext();)
/* 3072:     */       {
/* 3073:3148 */         RevisionesVehiculo revisionVehiculo = (RevisionesVehiculo)revisionesIterator.next();
/* 3074:3149 */         if ((revisionVehiculo.getRveh_bloqueado().compareTo(BigDecimal.ZERO) == 0) && 
/* 3075:3150 */           (revisionVehiculo.getRveh_control_kms().compareTo(distanciaReferencia) == 1))
/* 3076:     */         {
/* 3077:3151 */           distanciaReferencia = revisionVehiculo.getRveh_control_kms();
/* 3078:     */           try
/* 3079:     */           {
/* 3080:3153 */             fechaReferencia = sdf.parse(revisionVehiculo.getRveh_control_fec().toString());
/* 3081:     */           }
/* 3082:     */           catch (Exception e)
/* 3083:     */           {
/* 3084:3155 */             fechaReferencia = new Date();
/* 3085:     */           }
/* 3086:     */         }
/* 3087:     */       }
/* 3088:3160 */       StringBuffer ultimaFecha = ManejoFechas.getUltimaFechaPorUsuario(vehiculo.getVehi_usuc_cod(), revisiones);
/* 3089:3161 */       ManejoFechas.setFechaRevision(vehiculo, mantenimientoGeneral, revisiones, distanciaReferencia, fechaReferencia, ultimaFecha);
/* 3090:     */       
/* 3091:3163 */       Iterator rev_iterator = revisiones.iterator();
/* 3092:3164 */       while (rev_iterator.hasNext())
/* 3093:     */       {
/* 3094:3165 */         RevisionesVehiculo revision = (RevisionesVehiculo)rev_iterator.next();
/* 3095:3166 */         if (revision.getRveh_bloqueado().compareTo(BigDecimal.ZERO) == 0) {
/* 3096:3167 */           ManejoFechas.setFechaRevision(vehiculo, revision, distanciaReferencia, fechaReferencia, ultimaFecha);
/* 3097:     */         }
/* 3098:     */       }
/* 3099:3173 */       vehiculosCompleto.setMantenimientoGeneral(mantenimientoGeneral);
/* 3100:3174 */       vehiculosCompleto.setRevisiones(revisiones);
/* 3101:3175 */       vehiculosCompletoDAO.update(vehiculosCompleto, vehiculo.getVehi_cod());
/* 3102:     */     }
/* 3103:     */     catch (Exception e)
/* 3104:     */     {
/* 3105:3178 */       e.printStackTrace();
/* 3106:3179 */       return mapping.findForward("failure");
/* 3107:     */     }
/* 3108:3182 */     return mapping.findForward("success");
/* 3109:     */   }
/* 3110:     */ }



/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\

 * Qualified Name:     com.servidoctor.sdcars.controller.VehiculosAction

 * JD-Core Version:    0.7.0.1

 */