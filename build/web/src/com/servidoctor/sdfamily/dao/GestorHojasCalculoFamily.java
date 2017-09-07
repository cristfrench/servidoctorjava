/*    1:     */ package com.servidoctor.sdfamily.dao;
/*    2:     */ 
/*    3:     */ import com.servidoctor.constantes.IConstantes;
/*    4:     */ import com.servidoctor.parametros.dao.AlergiasDAO;
/*    5:     */ import com.servidoctor.parametros.dao.AntecedentesDAO;
/*    6:     */ import com.servidoctor.parametros.dao.CirujiasDAO;
/*    7:     */ import com.servidoctor.parametros.dao.CiudadDAO;
/*    8:     */ import com.servidoctor.parametros.dao.ConsumoDAO;
/*    9:     */ import com.servidoctor.parametros.dao.DocumentoDAO;
/*   10:     */ import com.servidoctor.parametros.dao.ElementoConsumoDAO;
/*   11:     */ import com.servidoctor.parametros.dao.EnfermedadesDAO;
/*   12:     */ import com.servidoctor.parametros.dao.EscolaridadDAO;
/*   13:     */ import com.servidoctor.parametros.dao.EstadoCivilDAO;
/*   14:     */ import com.servidoctor.parametros.dao.ExamenesDAO;
/*   15:     */ import com.servidoctor.parametros.dao.FormaDAO;
/*   16:     */ import com.servidoctor.parametros.dao.GinecologiaOperacionesDAO;
/*   17:     */ import com.servidoctor.parametros.dao.IdiomaDAO;
/*   18:     */ import com.servidoctor.parametros.dao.MedidaDAO;
/*   19:     */ import com.servidoctor.parametros.dao.OdontologiaDAO;
/*   20:     */ import com.servidoctor.parametros.dao.PaisDAO;
/*   21:     */ import com.servidoctor.parametros.dao.ParentescoDAO;
/*   22:     */ import com.servidoctor.parametros.dao.PartesCuerpoDAO;
/*   23:     */ import com.servidoctor.parametros.dao.PeriodoDAO;
/*   24:     */ import com.servidoctor.parametros.dao.TipoSangreDAO;
/*   25:     */ import com.servidoctor.parametros.dao.VacunasDAO;
/*   26:     */ import com.servidoctor.parametros.dao.ViaAdministracionDAO;
/*   27:     */ import com.servidoctor.parametros.model.Alergias;
/*   28:     */ import com.servidoctor.parametros.model.Antecedentes;
/*   29:     */ import com.servidoctor.parametros.model.Cirujias;
/*   30:     */ import com.servidoctor.parametros.model.Ciudades;
/*   31:     */ import com.servidoctor.parametros.model.Consumo;
/*   32:     */ import com.servidoctor.parametros.model.Documento;
/*   33:     */ import com.servidoctor.parametros.model.ElementoConsumo;
/*   34:     */ import com.servidoctor.parametros.model.Enfermedades;
/*   35:     */ import com.servidoctor.parametros.model.Escolaridad;
/*   36:     */ import com.servidoctor.parametros.model.EstadoCivil;
/*   37:     */ import com.servidoctor.parametros.model.Examenes;
/*   38:     */ import com.servidoctor.parametros.model.Forma;
/*   39:     */ import com.servidoctor.parametros.model.GinecologiaOperaciones;
/*   40:     */ import com.servidoctor.parametros.model.Idioma;
/*   41:     */ import com.servidoctor.parametros.model.Medida;
/*   42:     */ import com.servidoctor.parametros.model.Odontologia;
/*   43:     */ import com.servidoctor.parametros.model.Optometria;
/*   44:     */ import com.servidoctor.parametros.model.Paises;
/*   45:     */ import com.servidoctor.parametros.model.Parentesco;
/*   46:     */ import com.servidoctor.parametros.model.PartesCuerpo;
/*   47:     */ import com.servidoctor.parametros.model.Periodo;
/*   48:     */ import com.servidoctor.parametros.model.TiposSangre;
/*   49:     */ import com.servidoctor.parametros.model.Vacunas;
/*   50:     */ import com.servidoctor.parametros.model.ViaAdministracion;
/*   51:     */ import com.servidoctor.sdfamily.model.AlergiasUsuario;
/*   52:     */ import com.servidoctor.sdfamily.model.AntecedentesUsuario;
/*   53:     */ import com.servidoctor.sdfamily.model.CasoEmergencia;
/*   54:     */ import com.servidoctor.sdfamily.model.CirujiasUsuario;
/*   55:     */ import com.servidoctor.sdfamily.model.ControlMedico;
/*   56:     */ import com.servidoctor.sdfamily.model.ControlOdontologia;
/*   57:     */ import com.servidoctor.sdfamily.model.ControlOptometria;
/*   58:     */ import com.servidoctor.sdfamily.model.DatosPersonales;
/*   59:     */ import com.servidoctor.sdfamily.model.DatosPersonalesCompleto;
/*   60:     */ import com.servidoctor.sdfamily.model.ElementoConsumoUsuario;
/*   61:     */ import com.servidoctor.sdfamily.model.EnfermedadesUsuario;
/*   62:     */ import com.servidoctor.sdfamily.model.ExamenesUsuario;
/*   63:     */ import com.servidoctor.sdfamily.model.Ginecologia;
/*   64:     */ import com.servidoctor.sdfamily.model.GinecologiaOperacionesUsuario;
/*   65:     */ import com.servidoctor.sdfamily.model.HistoriaMedica;
/*   66:     */ import com.servidoctor.sdfamily.model.MedicinaCompleto;
/*   67:     */ import com.servidoctor.sdfamily.model.OdontologiaCompleto;
/*   68:     */ import com.servidoctor.sdfamily.model.OdontologiaUsuario;
/*   69:     */ import com.servidoctor.sdfamily.model.OptometriaCompleto;
/*   70:     */ import com.servidoctor.sdfamily.model.PartesCuerpoUsuario;
/*   71:     */ import com.servidoctor.sdfamily.model.SeguroMedico;
/*   72:     */ import com.servidoctor.sdfamily.model.UsuarioMedicamentos;
/*   73:     */ import com.servidoctor.sdfamily.model.UsuarioParent;
/*   74:     */ import com.servidoctor.sdfamily.model.VacunasUsuario;
/*   75:     */ import com.servidoctor.seguridad.model.UsuarioFamily;
/*   76:     */ import com.servidoctor.util.classes.ManejoFechas;
/*   77:     */ import java.io.OutputStream;
/*   78:     */ import java.math.BigDecimal;
/*   79:     */ import java.util.Iterator;
/*   80:     */ import java.util.List;
/*   81:     */ import java.util.ResourceBundle;
/*   82:     */ import org.apache.poi.hssf.usermodel.HSSFCell;
/*   83:     */ import org.apache.poi.hssf.usermodel.HSSFCellStyle;
/*   84:     */ import org.apache.poi.hssf.usermodel.HSSFFont;
/*   85:     */ import org.apache.poi.hssf.usermodel.HSSFRow;
/*   86:     */ import org.apache.poi.hssf.usermodel.HSSFSheet;
/*   87:     */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*   88:     */ 
/*   89:     */ public class GestorHojasCalculoFamily
/*   90:     */ {
/*   91:  86 */   private static HSSFWorkbook wb = new HSSFWorkbook();
/*   92:  87 */   private static UsuarioFamily usuarioFamily = null;
/*   93:  88 */   private static ResourceBundle RES = null;
/*   94:  89 */   private static OutputStream out = null;
/*   95:     */   
/*   96:     */   public static void generarArchivo()
/*   97:     */     throws Exception
/*   98:     */   {
/*   99:     */     try
/*  100:     */     {
/*  101:  93 */       wb = new HSSFWorkbook();
/*  102:     */     }
/*  103:     */     catch (Exception e)
/*  104:     */     {
/*  105:  95 */       throw e;
/*  106:     */     }
/*  107:     */   }
/*  108:     */   
/*  109:     */   public static void generarHoja(String nombreHoja, UsuarioFamily user, ResourceBundle res)
/*  110:     */     throws Exception
/*  111:     */   {
/*  112:     */     try
/*  113:     */     {
/*  114: 108 */       usuarioFamily = user;
/*  115: 109 */       RES = res;
/*  116: 110 */       HSSFSheet sheet = wb.createSheet(nombreHoja);
/*  117:     */       
/*  118: 112 */       sheet.setColumnWidth((short)0, (short)6000);
/*  119: 113 */       sheet.setColumnWidth((short)1, (short)6000);
/*  120: 114 */       sheet.setColumnWidth((short)2, (short)6000);
/*  121: 115 */       sheet.setColumnWidth((short)3, (short)6000);
/*  122: 116 */       sheet.setColumnWidth((short)4, (short)6000);
/*  123: 117 */       sheet.setColumnWidth((short)5, (short)6000);
/*  124: 118 */       sheet.setColumnWidth((short)6, (short)6000);
/*  125: 119 */       sheet.setColumnWidth((short)7, (short)6000);
/*  126: 120 */       sheet.setColumnWidth((short)8, (short)6000);
/*  127: 121 */       sheet.setColumnWidth((short)9, (short)6000);
/*  128: 122 */       sheet.setColumnWidth((short)10, (short)6000);
/*  129: 123 */       sheet.setColumnWidth((short)11, (short)6000);
/*  130: 124 */       sheet.setColumnWidth((short)12, (short)6000);
/*  131: 125 */       sheet.setColumnWidth((short)13, (short)6000);
/*  132: 126 */       sheet.setColumnWidth((short)14, (short)6000);
/*  133: 127 */       sheet.setColumnWidth((short)15, (short)6000);
/*  134: 128 */       sheet.setColumnWidth((short)16, (short)6000);
/*  135: 129 */       sheet.setColumnWidth((short)17, (short)6000);
/*  136: 130 */       sheet.setColumnWidth((short)18, (short)6000);
/*  137: 131 */       sheet.setColumnWidth((short)19, (short)6000);
/*  138: 132 */       sheet.setColumnWidth((short)20, (short)6000);
/*  139: 133 */       sheet.setColumnWidth((short)21, (short)6000);
/*  140: 134 */       sheet.setColumnWidth((short)22, (short)6000);
/*  141: 135 */       sheet.setColumnWidth((short)23, (short)6000);
/*  142: 136 */       sheet.setColumnWidth((short)24, (short)6000);
/*  143: 137 */       sheet.setColumnWidth((short)25, (short)6000);
/*  144: 138 */       sheet.setColumnWidth((short)26, (short)6000);
/*  145: 139 */       sheet.setColumnWidth((short)27, (short)6000);
/*  146: 140 */       sheet.setColumnWidth((short)28, (short)6000);
/*  147: 141 */       sheet.setColumnWidth((short)29, (short)6000);
/*  148:     */     }
/*  149:     */     catch (Exception e)
/*  150:     */     {
/*  151: 144 */       throw e;
/*  152:     */     }
/*  153:     */   }
/*  154:     */   
/*  155:     */   public static void generarDatosInfoBasica(String nombreHoja, String idioma, int servidor)
/*  156:     */     throws Exception
/*  157:     */   {
/*  158:     */     try
/*  159:     */     {
/*  160: 156 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/*  161: 157 */       HSSFFont boldFont = wb.createFont();
/*  162: 158 */       boldFont.setBoldweight((short)700);
/*  163: 159 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/*  164: 160 */       boldStyle.setFont(boldFont);
/*  165:     */       
/*  166: 162 */       DatosPersonalesCompletoDAO datosPersonalesCompletoDAO = new DatosPersonalesCompletoDAO();
/*  167: 163 */       datosPersonalesCompletoDAO.setServerNumber(servidor);
/*  168:     */       
/*  169: 165 */       DatosPersonalesCompleto datosPersonalesCompleto = null;
/*  170: 166 */       TipoSangreDAO tipoSangreDAO = new TipoSangreDAO();
/*  171: 167 */       tipoSangreDAO.setServerNumber(servidor);
/*  172: 168 */       EscolaridadDAO escolaridadDAO = new EscolaridadDAO();
/*  173: 169 */       escolaridadDAO.setServerNumber(servidor);
/*  174: 170 */       escolaridadDAO.setIdioma(idioma);
/*  175: 171 */       EstadoCivilDAO estadoCivilDAO = new EstadoCivilDAO();
/*  176: 172 */       estadoCivilDAO.setServerNumber(servidor);
/*  177: 173 */       estadoCivilDAO.setIdioma(idioma);
/*  178: 174 */       DocumentoDAO documentoDAO = new DocumentoDAO();
/*  179: 175 */       documentoDAO.setServerNumber(servidor);
/*  180: 176 */       documentoDAO.setIdioma(idioma);
/*  181: 177 */       ParentescoDAO parentescoDAO = new ParentescoDAO();
/*  182: 178 */       parentescoDAO.setServerNumber(servidor);
/*  183: 179 */       parentescoDAO.setIdioma(idioma);
/*  184: 180 */       IdiomaDAO idiomaDAO = new IdiomaDAO();
/*  185: 181 */       idiomaDAO.setServerNumber(servidor);
/*  186: 182 */       PaisDAO paisDAO = new PaisDAO();
/*  187: 183 */       paisDAO.setServerNumber(servidor);
/*  188: 184 */       paisDAO.setIdioma(idioma);
/*  189: 185 */       CiudadDAO ciudadDAO = new CiudadDAO();
/*  190: 186 */       ciudadDAO.setServerNumber(servidor);
/*  191: 187 */       ciudadDAO.setIdioma(idioma);
/*  192:     */       
/*  193: 189 */       HSSFRow row = null;
/*  194: 190 */       HSSFCell cell = null;
/*  195:     */       
/*  196: 192 */       row = sheet.createRow(0);
/*  197: 193 */       int i = 0;
/*  198:     */       
/*  199: 195 */       cell = row.createCell((short)i++);
/*  200: 196 */       cell.setCellValue(RES.getString("xls.usu_nombre"));
/*  201: 197 */       cell.setCellStyle(boldStyle);
/*  202:     */       
/*  203: 199 */       cell = row.createCell((short)i++);
/*  204: 200 */       cell.setCellValue(RES.getString("xls.usu_apellido"));
/*  205: 201 */       cell.setCellStyle(boldStyle);
/*  206:     */       
/*  207: 203 */       cell = row.createCell((short)i++);
/*  208: 204 */       cell.setCellValue(RES.getString("xls.usu_pais_cod"));
/*  209: 205 */       cell.setCellStyle(boldStyle);
/*  210:     */       
/*  211: 207 */       cell = row.createCell((short)i++);
/*  212: 208 */       cell.setCellValue(RES.getString("xls.usu_ciu_cod"));
/*  213: 209 */       cell.setCellStyle(boldStyle);
/*  214:     */       
/*  215: 211 */       cell = row.createCell((short)i++);
/*  216: 212 */       cell.setCellValue(RES.getString("xls.usu_sexo"));
/*  217: 213 */       cell.setCellStyle(boldStyle);
/*  218:     */       
/*  219: 215 */       cell = row.createCell((short)i++);
/*  220: 216 */       cell.setCellValue(RES.getString("xls.usu_fecnacim"));
/*  221: 217 */       cell.setCellStyle(boldStyle);
/*  222:     */       
/*  223: 219 */       cell = row.createCell((short)i++);
/*  224: 220 */       cell.setCellValue(RES.getString("xls.usu_tipsan_cod"));
/*  225: 221 */       cell.setCellStyle(boldStyle);
/*  226:     */       
/*  227: 223 */       cell = row.createCell((short)i++);
/*  228: 224 */       cell.setCellValue(RES.getString("xls.usu_escolaridad"));
/*  229: 225 */       cell.setCellStyle(boldStyle);
/*  230:     */       
/*  231: 227 */       cell = row.createCell((short)i++);
/*  232: 228 */       cell.setCellValue(RES.getString("xls.usu_estado"));
/*  233: 229 */       cell.setCellStyle(boldStyle);
/*  234:     */       
/*  235: 231 */       cell = row.createCell((short)i++);
/*  236: 232 */       cell.setCellValue(RES.getString("xls.usu_hijos"));
/*  237: 233 */       cell.setCellStyle(boldStyle);
/*  238:     */       
/*  239: 235 */       cell = row.createCell((short)i++);
/*  240: 236 */       cell.setCellValue(RES.getString("xls.usu_idioma"));
/*  241: 237 */       cell.setCellStyle(boldStyle);
/*  242:     */       
/*  243: 239 */       cell = row.createCell((short)i++);
/*  244: 240 */       cell.setCellValue(RES.getString("xls.usu_id_tipo"));
/*  245: 241 */       cell.setCellStyle(boldStyle);
/*  246:     */       
/*  247: 243 */       cell = row.createCell((short)i++);
/*  248: 244 */       cell.setCellValue(RES.getString("xls.usu_id_doc"));
/*  249: 245 */       cell.setCellStyle(boldStyle);
/*  250:     */       
/*  251: 247 */       cell = row.createCell((short)i++);
/*  252: 248 */       cell.setCellValue(RES.getString("xls.usu_relacion"));
/*  253: 249 */       cell.setCellStyle(boldStyle);
/*  254:     */       
/*  255: 251 */       cell = row.createCell((short)i++);
/*  256: 252 */       cell.setCellValue(RES.getString("xls.parent_nombre_aux"));
/*  257: 253 */       cell.setCellStyle(boldStyle);
/*  258:     */       
/*  259: 255 */       cell = row.createCell((short)i++);
/*  260: 256 */       cell.setCellValue(RES.getString("xls.parent_apellido_aux"));
/*  261: 257 */       cell.setCellStyle(boldStyle);
/*  262:     */       
/*  263: 259 */       cell = row.createCell((short)i++);
/*  264: 260 */       cell.setCellValue(RES.getString("xls.parent_tarjeta"));
/*  265: 261 */       cell.setCellStyle(boldStyle);
/*  266:     */       
/*  267: 263 */       cell = row.createCell((short)i++);
/*  268: 264 */       cell.setCellValue(RES.getString("xls.usu_indpais1"));
/*  269: 265 */       cell.setCellStyle(boldStyle);
/*  270:     */       
/*  271: 267 */       cell = row.createCell((short)i++);
/*  272: 268 */       cell.setCellValue(RES.getString("xls.usu_indciudad1"));
/*  273: 269 */       cell.setCellStyle(boldStyle);
/*  274:     */       
/*  275: 271 */       cell = row.createCell((short)i++);
/*  276: 272 */       cell.setCellValue(RES.getString("xls.usu_telefono1"));
/*  277: 273 */       cell.setCellStyle(boldStyle);
/*  278:     */       
/*  279: 275 */       cell = row.createCell((short)i++);
/*  280: 276 */       cell.setCellValue(RES.getString("xls.usu_indpais2"));
/*  281: 277 */       cell.setCellStyle(boldStyle);
/*  282:     */       
/*  283: 279 */       cell = row.createCell((short)i++);
/*  284: 280 */       cell.setCellValue(RES.getString("xls.usu_telefono2"));
/*  285: 281 */       cell.setCellStyle(boldStyle);
/*  286:     */       
/*  287: 283 */       cell = row.createCell((short)i++);
/*  288: 284 */       cell.setCellValue(RES.getString("xls.usu_mail"));
/*  289: 285 */       cell.setCellStyle(boldStyle);
/*  290:     */       
/*  291: 287 */       int x = 1;
/*  292: 288 */       int y = 0;
/*  293:     */       
/*  294: 290 */       datosPersonalesCompleto = datosPersonalesCompletoDAO.retrieve(usuarioFamily.getUsuf_cod());
/*  295:     */       
/*  296: 292 */       TiposSangre tipoSangre = tipoSangreDAO.retrieve(datosPersonalesCompleto.getDatosPersonales().getDatp_tipsan_cod());
/*  297: 293 */       Escolaridad escolaridad = escolaridadDAO.retrive(datosPersonalesCompleto.getDatosPersonales().getDatp_escolaridad());
/*  298: 294 */       EstadoCivil estadoCivil = estadoCivilDAO.retrive(datosPersonalesCompleto.getDatosPersonales().getDatp_estado());
/*  299: 295 */       Idioma idiomaUsuario = idiomaDAO.retrive(datosPersonalesCompleto.getDatosPersonales().getDatp_idioma().toString());
/*  300: 296 */       Parentesco parentesco = parentescoDAO.retrive(datosPersonalesCompleto.getUsuarioParent().getParent_rfam_cod());
/*  301: 297 */       Documento documento = documentoDAO.retrieve(datosPersonalesCompleto.getDatosPersonales().getDatp_id_tipo());
/*  302: 298 */       Paises paises = paisDAO.retrive(datosPersonalesCompleto.getDatosPersonales().getDatp_pais_cod());
/*  303: 299 */       Ciudades ciudades = ciudadDAO.retrive(datosPersonalesCompleto.getDatosPersonales().getDatp_pais_cod(), datosPersonalesCompleto.getDatosPersonales().getDatp_ciu_cod());
/*  304:     */       
/*  305: 301 */       row = sheet.createRow(x++);
/*  306:     */       
/*  307: 303 */       cell = row.createCell((short)y++);
/*  308: 304 */       cell.setCellValue(datosPersonalesCompleto.getDatosPersonales().getDatp_nombre());
/*  309:     */       
/*  310: 306 */       cell = row.createCell((short)y++);
/*  311: 307 */       cell.setCellValue(datosPersonalesCompleto.getDatosPersonales().getDatp_apellido());
/*  312:     */       
/*  313: 309 */       cell = row.createCell((short)y++);
/*  314: 310 */       cell.setCellValue(paises.getPais_des());
/*  315:     */       
/*  316: 312 */       cell = row.createCell((short)y++);
/*  317: 313 */       cell.setCellValue(ciudades.getCiu_des());
/*  318:     */       
/*  319: 315 */       cell = row.createCell((short)y++);
/*  320: 316 */       cell.setCellValue(datosPersonalesCompleto.getDatosPersonales().getDatp_sexo());
/*  321:     */       
/*  322: 318 */       cell = row.createCell((short)y++);
/*  323: 319 */       cell.setCellValue(ManejoFechas.FormateoFecha(datosPersonalesCompleto.getDatosPersonales().getDatp_fecnacim().toString()));
/*  324:     */       
/*  325: 321 */       cell = row.createCell((short)y++);
/*  326: 322 */       cell.setCellValue(tipoSangre.getTipsan_des());
/*  327:     */       
/*  328: 324 */       cell = row.createCell((short)y++);
/*  329: 325 */       cell.setCellValue(escolaridad.getEsco_des());
/*  330:     */       
/*  331: 327 */       cell = row.createCell((short)y++);
/*  332: 328 */       cell.setCellValue(estadoCivil.getEciv_des());
/*  333:     */       
/*  334: 330 */       cell = row.createCell((short)y++);
/*  335: 331 */       cell.setCellValue(datosPersonalesCompleto.getDatosPersonales().getDatp_hijos().toString());
/*  336:     */       
/*  337: 333 */       cell = row.createCell((short)y++);
/*  338: 334 */       cell.setCellValue(idiomaUsuario.getIdio_descripcion());
/*  339:     */       
/*  340: 336 */       cell = row.createCell((short)y++);
/*  341: 337 */       cell.setCellValue(documento.getDoc_des());
/*  342:     */       
/*  343: 339 */       cell = row.createCell((short)y++);
/*  344: 340 */       cell.setCellValue(datosPersonalesCompleto.getDatosPersonales().getDatp_id_doc());
/*  345:     */       
/*  346: 342 */       cell = row.createCell((short)y++);
/*  347: 343 */       cell.setCellValue(parentesco.getRfam_des());
/*  348:     */       
/*  349: 345 */       cell = row.createCell((short)y++);
/*  350: 346 */       cell.setCellValue(datosPersonalesCompleto.getUsuarioParent().getParent_nombre());
/*  351:     */       
/*  352: 348 */       cell = row.createCell((short)y++);
/*  353: 349 */       cell.setCellValue(datosPersonalesCompleto.getUsuarioParent().getParent_apellido());
/*  354:     */       
/*  355: 351 */       cell = row.createCell((short)y++);
/*  356: 352 */       cell.setCellValue(datosPersonalesCompleto.getUsuarioParent().getParent_tarjeta());
/*  357:     */       
/*  358: 354 */       cell = row.createCell((short)y++);
/*  359: 355 */       cell.setCellValue(datosPersonalesCompleto.getDatosPersonales().getDatp_indpais1().toString());
/*  360:     */       
/*  361: 357 */       cell = row.createCell((short)y++);
/*  362: 358 */       cell.setCellValue(datosPersonalesCompleto.getDatosPersonales().getDatp_indciudad1().toString());
/*  363:     */       
/*  364: 360 */       cell = row.createCell((short)y++);
/*  365: 361 */       cell.setCellValue(datosPersonalesCompleto.getDatosPersonales().getDatp_telefono1());
/*  366:     */       
/*  367: 363 */       cell = row.createCell((short)y++);
/*  368: 364 */       cell.setCellValue(datosPersonalesCompleto.getDatosPersonales().getDatp_indpais2().toString());
/*  369:     */       
/*  370: 366 */       cell = row.createCell((short)y++);
/*  371: 367 */       cell.setCellValue(datosPersonalesCompleto.getDatosPersonales().getDatp_telefono2());
/*  372:     */       
/*  373: 369 */       cell = row.createCell((short)y++);
/*  374: 370 */       cell.setCellValue(datosPersonalesCompleto.getDatosPersonales().getDatp_mail());
/*  375:     */       
/*  376: 372 */       y = 0;
/*  377:     */     }
/*  378:     */     catch (Exception e)
/*  379:     */     {
/*  380: 375 */       throw e;
/*  381:     */     }
/*  382:     */   }
/*  383:     */   
/*  384:     */   public static void generarDatosInformacionEmergencia(String nombreHoja, String idioma, int servidor)
/*  385:     */     throws Exception
/*  386:     */   {
/*  387:     */     try
/*  388:     */     {
/*  389: 387 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/*  390: 388 */       HSSFFont boldFont = wb.createFont();
/*  391: 389 */       boldFont.setBoldweight((short)700);
/*  392: 390 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/*  393: 391 */       boldStyle.setFont(boldFont);
/*  394:     */       
/*  395: 393 */       DatosPersonalesCompletoDAO datosPersonalesCompletoDAO = new DatosPersonalesCompletoDAO();
/*  396: 394 */       datosPersonalesCompletoDAO.setServerNumber(servidor);
/*  397:     */       
/*  398: 396 */       DatosPersonalesCompleto datosPersonalesCompleto = null;
/*  399: 397 */       ParentescoDAO parentescoDAO = new ParentescoDAO();
/*  400: 398 */       parentescoDAO.setServerNumber(servidor);
/*  401: 399 */       parentescoDAO.setIdioma(idioma);
/*  402: 400 */       PaisDAO paisDAO = new PaisDAO();
/*  403: 401 */       paisDAO.setServerNumber(servidor);
/*  404: 402 */       paisDAO.setIdioma(idioma);
/*  405: 403 */       CiudadDAO ciudadDAO = new CiudadDAO();
/*  406: 404 */       ciudadDAO.setServerNumber(servidor);
/*  407: 405 */       ciudadDAO.setIdioma(idioma);
/*  408:     */       
/*  409: 407 */       HSSFRow row = null;
/*  410: 408 */       HSSFCell cell = null;
/*  411:     */       
/*  412: 410 */       row = sheet.createRow(0);
/*  413:     */       
/*  414: 412 */       int i = 0;
/*  415:     */       
/*  416: 414 */       cell = row.createCell((short)i++);
/*  417: 415 */       cell.setCellValue(RES.getString("xls.case_nombre"));
/*  418: 416 */       cell.setCellStyle(boldStyle);
/*  419:     */       
/*  420: 418 */       cell = row.createCell((short)i++);
/*  421: 419 */       cell.setCellValue(RES.getString("xls.case_apellido"));
/*  422: 420 */       cell.setCellStyle(boldStyle);
/*  423:     */       
/*  424: 422 */       cell = row.createCell((short)i++);
/*  425: 423 */       cell.setCellValue(RES.getString("xls.case_rfamcod"));
/*  426: 424 */       cell.setCellStyle(boldStyle);
/*  427:     */       
/*  428: 426 */       cell = row.createCell((short)i++);
/*  429: 427 */       cell.setCellValue(RES.getString("xls.case_pais_cod"));
/*  430: 428 */       cell.setCellStyle(boldStyle);
/*  431:     */       
/*  432: 430 */       cell = row.createCell((short)i++);
/*  433: 431 */       cell.setCellValue(RES.getString("xls.case_ciu_cod"));
/*  434: 432 */       cell.setCellStyle(boldStyle);
/*  435:     */       
/*  436: 434 */       cell = row.createCell((short)i++);
/*  437: 435 */       cell.setCellValue(RES.getString("xls.case_indpais1"));
/*  438: 436 */       cell.setCellStyle(boldStyle);
/*  439:     */       
/*  440: 438 */       cell = row.createCell((short)i++);
/*  441: 439 */       cell.setCellValue(RES.getString("xls.case_indciudad1"));
/*  442: 440 */       cell.setCellStyle(boldStyle);
/*  443:     */       
/*  444: 442 */       cell = row.createCell((short)i++);
/*  445: 443 */       cell.setCellValue(RES.getString("xls.case_telefono1"));
/*  446: 444 */       cell.setCellStyle(boldStyle);
/*  447:     */       
/*  448: 446 */       cell = row.createCell((short)i++);
/*  449: 447 */       cell.setCellValue(RES.getString("xls.case_indpais2"));
/*  450: 448 */       cell.setCellStyle(boldStyle);
/*  451:     */       
/*  452: 450 */       cell = row.createCell((short)i++);
/*  453: 451 */       cell.setCellValue(RES.getString("xls.case_telefono2"));
/*  454: 452 */       cell.setCellStyle(boldStyle);
/*  455:     */       
/*  456: 454 */       cell = row.createCell((short)i++);
/*  457: 455 */       cell.setCellValue(RES.getString("xls.case_mail"));
/*  458: 456 */       cell.setCellStyle(boldStyle);
/*  459:     */       
/*  460: 458 */       cell = row.createCell((short)i++);
/*  461: 459 */       cell.setCellValue(RES.getString("xls.case_orden"));
/*  462: 460 */       cell.setCellStyle(boldStyle);
/*  463:     */       
/*  464: 462 */       int x = 1;
/*  465: 463 */       int y = 0;
/*  466:     */       
/*  467: 465 */       datosPersonalesCompleto = datosPersonalesCompletoDAO.retrieve(usuarioFamily.getUsuf_cod());
/*  468:     */       
/*  469: 467 */       Iterator iterator = datosPersonalesCompleto.getContactos().iterator();
/*  470: 468 */       while (iterator.hasNext())
/*  471:     */       {
/*  472: 469 */         CasoEmergencia casoEmergencia = (CasoEmergencia)iterator.next();
/*  473:     */         
/*  474: 471 */         Parentesco parentesco = parentescoDAO.retrive(casoEmergencia.getCase_rfam_cod());
/*  475: 472 */         Paises paises = paisDAO.retrive(casoEmergencia.getCase_pais_cod());
/*  476: 473 */         Ciudades ciudades = ciudadDAO.retrive(casoEmergencia.getCase_pais_cod(), casoEmergencia.getCase_ciu_cod());
/*  477:     */         
/*  478: 475 */         row = sheet.createRow(x++);
/*  479:     */         
/*  480: 477 */         cell = row.createCell((short)y++);
/*  481: 478 */         cell.setCellValue(casoEmergencia.getCase_nombre());
/*  482:     */         
/*  483: 480 */         cell = row.createCell((short)y++);
/*  484: 481 */         cell.setCellValue(casoEmergencia.getCase_apellido());
/*  485:     */         
/*  486: 483 */         cell = row.createCell((short)y++);
/*  487: 484 */         cell.setCellValue(parentesco.getRfam_des());
/*  488:     */         
/*  489: 486 */         cell = row.createCell((short)y++);
/*  490: 487 */         cell.setCellValue(paises.getPais_des());
/*  491:     */         
/*  492: 489 */         cell = row.createCell((short)y++);
/*  493: 490 */         cell.setCellValue(ciudades.getCiu_des());
/*  494:     */         
/*  495: 492 */         cell = row.createCell((short)y++);
/*  496: 493 */         cell.setCellValue(casoEmergencia.getCase_indpais1().toString());
/*  497:     */         
/*  498: 495 */         cell = row.createCell((short)y++);
/*  499: 496 */         cell.setCellValue(casoEmergencia.getCase_indciudad1().toString());
/*  500:     */         
/*  501: 498 */         cell = row.createCell((short)y++);
/*  502: 499 */         cell.setCellValue(casoEmergencia.getCase_telefono1());
/*  503:     */         
/*  504: 501 */         cell = row.createCell((short)y++);
/*  505: 502 */         cell.setCellValue(casoEmergencia.getCase_indpais2().toString());
/*  506:     */         
/*  507: 504 */         cell = row.createCell((short)y++);
/*  508: 505 */         cell.setCellValue(casoEmergencia.getCase_telefono2());
/*  509:     */         
/*  510: 507 */         cell = row.createCell((short)y++);
/*  511: 508 */         cell.setCellValue(casoEmergencia.getCase_mail());
/*  512:     */         
/*  513: 510 */         cell = row.createCell((short)y++);
/*  514: 511 */         cell.setCellValue(casoEmergencia.getCase_orden().toString());
/*  515:     */         
/*  516: 513 */         y = 0;
/*  517:     */       }
/*  518:     */     }
/*  519:     */     catch (Exception e)
/*  520:     */     {
/*  521: 517 */       throw e;
/*  522:     */     }
/*  523:     */   }
/*  524:     */   
/*  525:     */   public static void generarDatosSeguros(String nombreHoja, int servidor)
/*  526:     */     throws Exception
/*  527:     */   {
/*  528:     */     try
/*  529:     */     {
/*  530: 529 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/*  531: 530 */       HSSFFont boldFont = wb.createFont();
/*  532: 531 */       boldFont.setBoldweight((short)700);
/*  533: 532 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/*  534: 533 */       boldStyle.setFont(boldFont);
/*  535:     */       
/*  536: 535 */       DatosPersonalesCompletoDAO datosPersonalesCompletoDAO = new DatosPersonalesCompletoDAO();
/*  537: 536 */       datosPersonalesCompletoDAO.setServerNumber(servidor);
/*  538: 537 */       DatosPersonalesCompleto datosPersonalesCompleto = null;
/*  539:     */       
/*  540: 539 */       HSSFRow row = null;
/*  541: 540 */       HSSFCell cell = null;
/*  542:     */       
/*  543: 542 */       row = sheet.createRow(0);
/*  544:     */       
/*  545: 544 */       int i = 0;
/*  546:     */       
/*  547: 546 */       cell = row.createCell((short)i++);
/*  548: 547 */       cell.setCellValue(RES.getString("xls.segm_nomcia"));
/*  549: 548 */       cell.setCellStyle(boldStyle);
/*  550:     */       
/*  551: 550 */       cell = row.createCell((short)i++);
/*  552: 551 */       cell.setCellValue(RES.getString("xls.segm_polizaafi"));
/*  553: 552 */       cell.setCellStyle(boldStyle);
/*  554:     */       
/*  555: 554 */       cell = row.createCell((short)i++);
/*  556: 555 */       cell.setCellValue(RES.getString("xls.segm_contacto"));
/*  557: 556 */       cell.setCellStyle(boldStyle);
/*  558:     */       
/*  559: 558 */       cell = row.createCell((short)i++);
/*  560: 559 */       cell.setCellValue(RES.getString("xls.segm_vig_desde"));
/*  561: 560 */       cell.setCellStyle(boldStyle);
/*  562:     */       
/*  563: 562 */       cell = row.createCell((short)i++);
/*  564: 563 */       cell.setCellValue(RES.getString("xls.segm_vig_hasta"));
/*  565: 564 */       cell.setCellStyle(boldStyle);
/*  566:     */       
/*  567: 566 */       cell = row.createCell((short)i++);
/*  568: 567 */       cell.setCellValue(RES.getString("xls.segm_indpais1"));
/*  569: 568 */       cell.setCellStyle(boldStyle);
/*  570:     */       
/*  571: 570 */       cell = row.createCell((short)i++);
/*  572: 571 */       cell.setCellValue(RES.getString("xls.segm_indciudad1"));
/*  573: 572 */       cell.setCellStyle(boldStyle);
/*  574:     */       
/*  575: 574 */       cell = row.createCell((short)i++);
/*  576: 575 */       cell.setCellValue(RES.getString("xls.segm_telefono1"));
/*  577: 576 */       cell.setCellStyle(boldStyle);
/*  578:     */       
/*  579: 578 */       cell = row.createCell((short)i++);
/*  580: 579 */       cell.setCellValue(RES.getString("xls.segm_indpais2"));
/*  581: 580 */       cell.setCellStyle(boldStyle);
/*  582:     */       
/*  583: 582 */       cell = row.createCell((short)i++);
/*  584: 583 */       cell.setCellValue(RES.getString("xls.segm_telefono2"));
/*  585: 584 */       cell.setCellStyle(boldStyle);
/*  586:     */       
/*  587: 586 */       cell = row.createCell((short)i++);
/*  588: 587 */       cell.setCellValue(RES.getString("xls.segm_indpais3"));
/*  589: 588 */       cell.setCellStyle(boldStyle);
/*  590:     */       
/*  591: 590 */       cell = row.createCell((short)i++);
/*  592: 591 */       cell.setCellValue(RES.getString("xls.segm_indciudad3"));
/*  593: 592 */       cell.setCellStyle(boldStyle);
/*  594:     */       
/*  595: 594 */       cell = row.createCell((short)i++);
/*  596: 595 */       cell.setCellValue(RES.getString("xls.segm_telefono3"));
/*  597: 596 */       cell.setCellStyle(boldStyle);
/*  598:     */       
/*  599: 598 */       cell = row.createCell((short)i++);
/*  600: 599 */       cell.setCellValue(RES.getString("xls.segm_mail"));
/*  601: 600 */       cell.setCellStyle(boldStyle);
/*  602:     */       
/*  603: 602 */       int x = 1;
/*  604: 603 */       int y = 0;
/*  605:     */       
/*  606: 605 */       datosPersonalesCompleto = datosPersonalesCompletoDAO.retrieve(usuarioFamily.getUsuf_cod());
/*  607:     */       
/*  608: 607 */       Iterator iterator = datosPersonalesCompleto.getSeguros().iterator();
/*  609: 608 */       while (iterator.hasNext())
/*  610:     */       {
/*  611: 609 */         SeguroMedico seguroMedico = (SeguroMedico)iterator.next();
/*  612:     */         
/*  613: 611 */         row = sheet.createRow(x++);
/*  614:     */         
/*  615: 613 */         cell = row.createCell((short)y++);
/*  616: 614 */         cell.setCellValue(seguroMedico.getSegm_nomcia());
/*  617:     */         
/*  618: 616 */         cell = row.createCell((short)y++);
/*  619: 617 */         cell.setCellValue(seguroMedico.getSegm_polizaafi());
/*  620:     */         
/*  621: 619 */         cell = row.createCell((short)y++);
/*  622: 620 */         cell.setCellValue(seguroMedico.getSegm_contacto());
/*  623:     */         
/*  624: 622 */         cell = row.createCell((short)y++);
/*  625: 623 */         cell.setCellValue(ManejoFechas.FormateoFecha(seguroMedico.getSegm_vig_desde().toString()));
/*  626:     */         
/*  627: 625 */         cell = row.createCell((short)y++);
/*  628: 626 */         cell.setCellValue(ManejoFechas.FormateoFecha(seguroMedico.getSegm_vig_hasta().toString()));
/*  629:     */         
/*  630: 628 */         cell = row.createCell((short)y++);
/*  631: 629 */         cell.setCellValue(seguroMedico.getSegm_indpais1().toString());
/*  632:     */         
/*  633: 631 */         cell = row.createCell((short)y++);
/*  634: 632 */         cell.setCellValue(seguroMedico.getSegm_indciudad1().toString());
/*  635:     */         
/*  636: 634 */         cell = row.createCell((short)y++);
/*  637: 635 */         cell.setCellValue(seguroMedico.getSegm_telefono1());
/*  638:     */         
/*  639: 637 */         cell = row.createCell((short)y++);
/*  640: 638 */         cell.setCellValue(seguroMedico.getSegm_indpais2().toString());
/*  641:     */         
/*  642: 640 */         cell = row.createCell((short)y++);
/*  643: 641 */         cell.setCellValue(seguroMedico.getSegm_telefono2());
/*  644:     */         
/*  645: 643 */         cell = row.createCell((short)y++);
/*  646: 644 */         cell.setCellValue(seguroMedico.getSegm_indpais3().toString());
/*  647:     */         
/*  648: 646 */         cell = row.createCell((short)y++);
/*  649: 647 */         cell.setCellValue(seguroMedico.getSegm_indciudad3().toString());
/*  650:     */         
/*  651: 649 */         cell = row.createCell((short)y++);
/*  652: 650 */         cell.setCellValue(seguroMedico.getSegm_telefono3());
/*  653:     */         
/*  654: 652 */         cell = row.createCell((short)y++);
/*  655: 653 */         cell.setCellValue(seguroMedico.getSegm_email());
/*  656:     */         
/*  657: 655 */         y = 0;
/*  658:     */       }
/*  659:     */     }
/*  660:     */     catch (Exception e)
/*  661:     */     {
/*  662: 659 */       throw e;
/*  663:     */     }
/*  664:     */   }
/*  665:     */   
/*  666:     */   public static void generarDatosConsumo(String nombreHoja, String idioma, int servidor)
/*  667:     */     throws Exception
/*  668:     */   {
/*  669:     */     try
/*  670:     */     {
/*  671: 671 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/*  672: 672 */       HSSFFont boldFont = wb.createFont();
/*  673: 673 */       boldFont.setBoldweight((short)700);
/*  674: 674 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/*  675: 675 */       boldStyle.setFont(boldFont);
/*  676:     */       
/*  677: 677 */       ConsumoDAO consumoDAO = new ConsumoDAO();
/*  678: 678 */       consumoDAO.setServerNumber(servidor);
/*  679: 679 */       consumoDAO.setIdioma(idioma);
/*  680: 680 */       ElementoConsumoDAO elementoConsumoDAO = new ElementoConsumoDAO();
/*  681: 681 */       elementoConsumoDAO.setServerNumber(servidor);
/*  682: 682 */       elementoConsumoDAO.setIdioma(idioma);
/*  683: 683 */       ElementoConsumoUsuarioDAO elementoConsumoUsuarioDAO = new ElementoConsumoUsuarioDAO();
/*  684: 684 */       elementoConsumoUsuarioDAO.setServerNumber(servidor);
/*  685:     */       
/*  686: 686 */       HSSFRow row = null;
/*  687: 687 */       HSSFCell cell = null;
/*  688:     */       
/*  689: 689 */       row = sheet.createRow(0);
/*  690:     */       
/*  691: 691 */       cell = row.createCell((short)0);
/*  692: 692 */       cell.setCellValue(RES.getString("xls.econ_des"));
/*  693: 693 */       cell.setCellStyle(boldStyle);
/*  694:     */       
/*  695: 695 */       cell = row.createCell((short)1);
/*  696: 696 */       cell.setCellValue(RES.getString("xls.econ_consumo_cod"));
/*  697: 697 */       cell.setCellStyle(boldStyle);
/*  698:     */       
/*  699: 699 */       int x = 1;
/*  700: 700 */       int y = 0;
/*  701:     */       
/*  702: 702 */       List consumos = elementoConsumoUsuarioDAO.list(usuarioFamily.getUsuf_cod());
/*  703:     */       
/*  704: 704 */       Iterator iterator = consumos.iterator();
/*  705: 705 */       while (iterator.hasNext())
/*  706:     */       {
/*  707: 706 */         ElementoConsumoUsuario elementoConsumoUsuario = (ElementoConsumoUsuario)iterator.next();
/*  708: 707 */         ElementoConsumo elementoConsumo = elementoConsumoDAO.retrive(elementoConsumoUsuario.getEconu_econ_cod());
/*  709:     */         
/*  710: 709 */         row = sheet.createRow(x++);
/*  711:     */         
/*  712: 711 */         cell = row.createCell((short)y++);
/*  713: 712 */         cell.setCellValue(elementoConsumo.getEcon_des());
/*  714:     */         
/*  715: 714 */         cell = row.createCell((short)y++);
/*  716: 715 */         cell.setCellValue(consumoDAO.retrive(elementoConsumoUsuario.getEconu_cons_cod()).getCons_des());
/*  717:     */         
/*  718: 717 */         y = 0;
/*  719:     */       }
/*  720:     */     }
/*  721:     */     catch (Exception e)
/*  722:     */     {
/*  723: 721 */       throw e;
/*  724:     */     }
/*  725:     */   }
/*  726:     */   
/*  727:     */   public static void generarDatosEnfermedades(String nombreHoja, String idioma, int servidor)
/*  728:     */     throws Exception
/*  729:     */   {
/*  730:     */     try
/*  731:     */     {
/*  732: 733 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/*  733: 734 */       HSSFFont boldFont = wb.createFont();
/*  734: 735 */       boldFont.setBoldweight((short)700);
/*  735: 736 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/*  736: 737 */       boldStyle.setFont(boldFont);
/*  737:     */       
/*  738: 739 */       EnfermedadesDAO enfermedadesDAO = new EnfermedadesDAO();
/*  739: 740 */       enfermedadesDAO.setServerNumber(servidor);
/*  740: 741 */       enfermedadesDAO.setIdioma(idioma);
/*  741: 742 */       HistoriaMedicaDAO historiaMedicaDAO = new HistoriaMedicaDAO();
/*  742: 743 */       historiaMedicaDAO.setServerNumber(servidor);
/*  743:     */       
/*  744: 745 */       HSSFRow row = null;
/*  745: 746 */       HSSFCell cell = null;
/*  746:     */       
/*  747: 748 */       row = sheet.createRow(0);
/*  748:     */       
/*  749: 750 */       int i = 0;
/*  750:     */       
/*  751: 752 */       cell = row.createCell((short)i++);
/*  752: 753 */       cell.setCellValue(RES.getString("xls.uenf_posee"));
/*  753: 754 */       cell.setCellStyle(boldStyle);
/*  754:     */       
/*  755: 756 */       cell = row.createCell((short)i++);
/*  756: 757 */       cell.setCellValue(RES.getString("xls.uenf_aniodesde"));
/*  757: 758 */       cell.setCellStyle(boldStyle);
/*  758:     */       
/*  759: 760 */       cell = row.createCell((short)i++);
/*  760: 761 */       cell.setCellValue(RES.getString("xls.uenf_novedad"));
/*  761: 762 */       cell.setCellStyle(boldStyle);
/*  762:     */       
/*  763: 764 */       int x = 1;
/*  764: 765 */       int y = 0;
/*  765:     */       
/*  766: 767 */       HistoriaMedica historiaMedica = historiaMedicaDAO.retrieve(usuarioFamily.getUsuf_cod());
/*  767:     */       
/*  768: 769 */       Iterator iterator = historiaMedica.getEnfermedadesUsuario().iterator();
/*  769: 770 */       while (iterator.hasNext())
/*  770:     */       {
/*  771: 771 */         EnfermedadesUsuario enfermedadUsuario = (EnfermedadesUsuario)iterator.next();
/*  772:     */         
/*  773: 773 */         row = sheet.createRow(x++);
/*  774:     */         
/*  775: 775 */         cell = row.createCell((short)y++);
/*  776: 776 */         cell.setCellValue(enfermedadUsuario.getEnfu_enf_cod().equals(IConstantes.CODIGO_NO_EXISTE) ? enfermedadUsuario.getEnfu_des() : enfermedadesDAO.retrive(enfermedadUsuario.getEnfu_enf_cod()).getEnf_des());
/*  777:     */         
/*  778: 778 */         cell = row.createCell((short)y++);
/*  779: 779 */         cell.setCellValue(enfermedadUsuario.getEnfu_anio_desde().toString());
/*  780:     */         
/*  781: 781 */         cell = row.createCell((short)y++);
/*  782: 782 */         cell.setCellValue(enfermedadUsuario.getEnfu_novedad());
/*  783:     */         
/*  784: 784 */         y = 0;
/*  785:     */       }
/*  786:     */     }
/*  787:     */     catch (Exception e)
/*  788:     */     {
/*  789: 788 */       throw e;
/*  790:     */     }
/*  791:     */   }
/*  792:     */   
/*  793:     */   public static void generarDatosAlergias(String nombreHoja, String idioma, int servidor)
/*  794:     */     throws Exception
/*  795:     */   {
/*  796:     */     try
/*  797:     */     {
/*  798: 800 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/*  799: 801 */       HSSFFont boldFont = wb.createFont();
/*  800: 802 */       boldFont.setBoldweight((short)700);
/*  801: 803 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/*  802: 804 */       boldStyle.setFont(boldFont);
/*  803:     */       
/*  804: 806 */       AlergiasDAO alergiasDAO = new AlergiasDAO();
/*  805: 807 */       alergiasDAO.setServerNumber(servidor);
/*  806: 808 */       alergiasDAO.setIdioma(idioma);
/*  807: 809 */       HistoriaMedicaDAO historiaMedicaDAO = new HistoriaMedicaDAO();
/*  808: 810 */       historiaMedicaDAO.setServerNumber(servidor);
/*  809:     */       
/*  810: 812 */       HSSFRow row = null;
/*  811: 813 */       HSSFCell cell = null;
/*  812:     */       
/*  813: 815 */       row = sheet.createRow(0);
/*  814:     */       
/*  815: 817 */       int i = 0;
/*  816:     */       
/*  817: 819 */       cell = row.createCell((short)i++);
/*  818: 820 */       cell.setCellValue(RES.getString("xls.uale_alergia_spa"));
/*  819: 821 */       cell.setCellStyle(boldStyle);
/*  820:     */       
/*  821: 823 */       cell = row.createCell((short)i++);
/*  822: 824 */       cell.setCellValue(RES.getString("xls.uale_aniodesde"));
/*  823: 825 */       cell.setCellStyle(boldStyle);
/*  824:     */       
/*  825: 827 */       cell = row.createCell((short)i++);
/*  826: 828 */       cell.setCellValue(RES.getString("xls.uale_novedad"));
/*  827: 829 */       cell.setCellStyle(boldStyle);
/*  828:     */       
/*  829: 831 */       int x = 1;
/*  830: 832 */       int y = 0;
/*  831:     */       
/*  832: 834 */       HistoriaMedica historiaMedica = historiaMedicaDAO.retrieve(usuarioFamily.getUsuf_cod());
/*  833:     */       
/*  834: 836 */       Iterator iterator = historiaMedica.getAlergiasUsuario().iterator();
/*  835: 837 */       while (iterator.hasNext())
/*  836:     */       {
/*  837: 838 */         AlergiasUsuario alergiasUsuario = (AlergiasUsuario)iterator.next();
/*  838:     */         
/*  839: 840 */         row = sheet.createRow(x++);
/*  840:     */         
/*  841: 842 */         cell = row.createCell((short)y++);
/*  842: 843 */         cell.setCellValue(alergiasUsuario.getAleu_ale_cod().equals(IConstantes.CODIGO_NO_EXISTE) ? alergiasUsuario.getAleu_des() : alergiasDAO.retrive(alergiasUsuario.getAleu_ale_cod()).getAle_des());
/*  843:     */         
/*  844: 845 */         cell = row.createCell((short)y++);
/*  845: 846 */         cell.setCellValue(alergiasUsuario.getAleu_anio_desde().toString());
/*  846:     */         
/*  847: 848 */         cell = row.createCell((short)y++);
/*  848: 849 */         cell.setCellValue(alergiasUsuario.getAleu_novedad());
/*  849:     */         
/*  850: 851 */         y = 0;
/*  851:     */       }
/*  852:     */     }
/*  853:     */     catch (Exception e)
/*  854:     */     {
/*  855: 855 */       throw e;
/*  856:     */     }
/*  857:     */   }
/*  858:     */   
/*  859:     */   public static void generarDatosCirujias(String nombreHoja, String idioma, int servidor)
/*  860:     */     throws Exception
/*  861:     */   {
/*  862:     */     try
/*  863:     */     {
/*  864: 867 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/*  865: 868 */       HSSFFont boldFont = wb.createFont();
/*  866: 869 */       boldFont.setBoldweight((short)700);
/*  867: 870 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/*  868: 871 */       boldStyle.setFont(boldFont);
/*  869:     */       
/*  870: 873 */       HistoriaMedicaDAO historiaMedicaDAO = new HistoriaMedicaDAO();
/*  871: 874 */       historiaMedicaDAO.setServerNumber(servidor);
/*  872: 875 */       CirujiasDAO cirujiasDAO = new CirujiasDAO();
/*  873: 876 */       cirujiasDAO.setServerNumber(servidor);
/*  874: 877 */       cirujiasDAO.setIdioma(idioma);
/*  875:     */       
/*  876: 879 */       HSSFRow row = null;
/*  877: 880 */       HSSFCell cell = null;
/*  878:     */       
/*  879: 882 */       row = sheet.createRow(0);
/*  880:     */       
/*  881: 884 */       int i = 0;
/*  882:     */       
/*  883: 886 */       cell = row.createCell((short)i++);
/*  884: 887 */       cell.setCellValue(RES.getString("xls.ucir_operado"));
/*  885: 888 */       cell.setCellStyle(boldStyle);
/*  886:     */       
/*  887: 890 */       cell = row.createCell((short)i++);
/*  888: 891 */       cell.setCellValue(RES.getString("xls.ucir_aniodesde"));
/*  889: 892 */       cell.setCellStyle(boldStyle);
/*  890:     */       
/*  891: 894 */       int x = 1;
/*  892: 895 */       int y = 0;
/*  893:     */       
/*  894: 897 */       HistoriaMedica historiaMedica = historiaMedicaDAO.retrieve(usuarioFamily.getUsuf_cod());
/*  895:     */       
/*  896: 899 */       Iterator iterator = historiaMedica.getCirujiasUsuario().iterator();
/*  897: 900 */       while (iterator.hasNext())
/*  898:     */       {
/*  899: 901 */         CirujiasUsuario cirujiasUsuario = (CirujiasUsuario)iterator.next();
/*  900:     */         
/*  901: 903 */         row = sheet.createRow(x++);
/*  902:     */         
/*  903: 905 */         cell = row.createCell((short)y++);
/*  904: 906 */         cell.setCellValue(cirujiasUsuario.getCiru_cir_cod().equals(IConstantes.CODIGO_NO_EXISTE) ? cirujiasUsuario.getCiru_des() : cirujiasDAO.retrive(cirujiasUsuario.getCiru_cir_cod()).getCir_des());
/*  905:     */         
/*  906: 908 */         cell = row.createCell((short)y++);
/*  907: 909 */         cell.setCellValue(cirujiasUsuario.getCiru_anio().toString());
/*  908:     */         
/*  909: 911 */         y = 0;
/*  910:     */       }
/*  911:     */     }
/*  912:     */     catch (Exception e)
/*  913:     */     {
/*  914: 915 */       throw e;
/*  915:     */     }
/*  916:     */   }
/*  917:     */   
/*  918:     */   public static void generarDatosMedicamentos(String nombreHoja, String idioma, int servidor)
/*  919:     */     throws Exception
/*  920:     */   {
/*  921:     */     try
/*  922:     */     {
/*  923: 927 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/*  924: 928 */       HSSFFont boldFont = wb.createFont();
/*  925: 929 */       boldFont.setBoldweight((short)700);
/*  926: 930 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/*  927: 931 */       boldStyle.setFont(boldFont);
/*  928:     */       
/*  929: 933 */       FormaDAO formaDAO = new FormaDAO();
/*  930: 934 */       formaDAO.setServerNumber(servidor);
/*  931: 935 */       formaDAO.setIdioma(idioma);
/*  932: 936 */       MedidaDAO medidaDAO = new MedidaDAO();
/*  933: 937 */       medidaDAO.setServerNumber(servidor);
/*  934: 938 */       medidaDAO.setIdioma(idioma);
/*  935: 939 */       PeriodoDAO periodoDAO = new PeriodoDAO();
/*  936: 940 */       periodoDAO.setServerNumber(servidor);
/*  937: 941 */       periodoDAO.setIdioma(idioma);
/*  938: 942 */       ViaAdministracionDAO viaAdministracionDAO = new ViaAdministracionDAO();
/*  939: 943 */       viaAdministracionDAO.setServerNumber(servidor);
/*  940: 944 */       viaAdministracionDAO.setIdioma(idioma);
/*  941: 945 */       HistoriaMedicaDAO historiaMedicaDAO = new HistoriaMedicaDAO();
/*  942: 946 */       historiaMedicaDAO.setServerNumber(servidor);
/*  943:     */       
/*  944: 948 */       HSSFRow row = null;
/*  945: 949 */       HSSFCell cell = null;
/*  946:     */       
/*  947: 951 */       row = sheet.createRow(0);
/*  948:     */       
/*  949: 953 */       int i = 0;
/*  950:     */       
/*  951: 955 */       cell = row.createCell((short)i++);
/*  952: 956 */       cell.setCellValue(RES.getString("xls.mtom_des"));
/*  953: 957 */       cell.setCellStyle(boldStyle);
/*  954:     */       
/*  955: 959 */       cell = row.createCell((short)i++);
/*  956: 960 */       cell.setCellValue(RES.getString("xls.mtom_forma"));
/*  957: 961 */       cell.setCellStyle(boldStyle);
/*  958:     */       
/*  959: 963 */       cell = row.createCell((short)i++);
/*  960: 964 */       cell.setCellValue(RES.getString("xls.mtom_fecdesde"));
/*  961: 965 */       cell.setCellStyle(boldStyle);
/*  962:     */       
/*  963: 967 */       cell = row.createCell((short)i++);
/*  964: 968 */       cell.setCellValue(RES.getString("xls.mtom_dosis"));
/*  965: 969 */       cell.setCellStyle(boldStyle);
/*  966:     */       
/*  967: 971 */       cell = row.createCell((short)i++);
/*  968: 972 */       cell.setCellValue(RES.getString("xls.mtom_medida"));
/*  969: 973 */       cell.setCellStyle(boldStyle);
/*  970:     */       
/*  971: 975 */       cell = row.createCell((short)i++);
/*  972: 976 */       cell.setCellValue(RES.getString("xls.mtom_periodo"));
/*  973: 977 */       cell.setCellStyle(boldStyle);
/*  974:     */       
/*  975: 979 */       cell = row.createCell((short)i++);
/*  976: 980 */       cell.setCellValue(RES.getString("xls.mtom_cantidad"));
/*  977: 981 */       cell.setCellStyle(boldStyle);
/*  978:     */       
/*  979: 983 */       cell = row.createCell((short)i++);
/*  980: 984 */       cell.setCellValue(RES.getString("xls.mtom_viaadmon"));
/*  981: 985 */       cell.setCellStyle(boldStyle);
/*  982:     */       
/*  983: 987 */       int x = 1;
/*  984: 988 */       int y = 0;
/*  985:     */       
/*  986: 990 */       HistoriaMedica historiaMedica = historiaMedicaDAO.retrieve(usuarioFamily.getUsuf_cod());
/*  987:     */       
/*  988: 992 */       Iterator iterator = historiaMedica.getMedicamentosUsuario().iterator();
/*  989: 993 */       while (iterator.hasNext())
/*  990:     */       {
/*  991: 994 */         UsuarioMedicamentos usuarioFamilyMedicamentos = (UsuarioMedicamentos)iterator.next();
/*  992:     */         
/*  993: 996 */         row = sheet.createRow(x++);
/*  994:     */         
/*  995: 998 */         cell = row.createCell((short)y++);
/*  996: 999 */         cell.setCellValue(usuarioFamilyMedicamentos.getMtom_des());
/*  997:     */         
/*  998:1001 */         cell = row.createCell((short)y++);
/*  999:1002 */         cell.setCellValue(formaDAO.retrive(usuarioFamilyMedicamentos.getMtom_form_cod()).getForm_des());
/* 1000:     */         
/* 1001:1004 */         cell = row.createCell((short)y++);
/* 1002:1005 */         cell.setCellValue(ManejoFechas.FormateoFecha(usuarioFamilyMedicamentos.getMtom_fecdesde().toString()));
/* 1003:     */         
/* 1004:1007 */         cell = row.createCell((short)y++);
/* 1005:1008 */         cell.setCellValue(usuarioFamilyMedicamentos.getMtom_dosis().toString());
/* 1006:     */         
/* 1007:1010 */         cell = row.createCell((short)y++);
/* 1008:1011 */         cell.setCellValue(medidaDAO.retrive(usuarioFamilyMedicamentos.getMtom_medi_cod()).getMedi_des());
/* 1009:     */         
/* 1010:1013 */         cell = row.createCell((short)y++);
/* 1011:1014 */         cell.setCellValue(periodoDAO.retrive(usuarioFamilyMedicamentos.getMtom_peri_cod()).getPeri_des());
/* 1012:     */         
/* 1013:1016 */         cell = row.createCell((short)y++);
/* 1014:1017 */         cell.setCellValue(usuarioFamilyMedicamentos.getMtom_cantidad().toString());
/* 1015:     */         
/* 1016:1019 */         cell = row.createCell((short)y++);
/* 1017:1020 */         cell.setCellValue(viaAdministracionDAO.retrive(usuarioFamilyMedicamentos.getMtom_vadm_cod()).getVadm_des());
/* 1018:     */         
/* 1019:1022 */         y = 0;
/* 1020:     */       }
/* 1021:     */     }
/* 1022:     */     catch (Exception e)
/* 1023:     */     {
/* 1024:1026 */       throw e;
/* 1025:     */     }
/* 1026:     */   }
/* 1027:     */   
/* 1028:     */   public static void generarDatosAntecedentes(String nombreHoja, String idioma, int servidor)
/* 1029:     */     throws Exception
/* 1030:     */   {
/* 1031:     */     try
/* 1032:     */     {
/* 1033:1038 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/* 1034:1039 */       HSSFFont boldFont = wb.createFont();
/* 1035:1040 */       boldFont.setBoldweight((short)700);
/* 1036:1041 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/* 1037:1042 */       boldStyle.setFont(boldFont);
/* 1038:     */       
/* 1039:1044 */       AntecedentesDAO antecedentesDAO = new AntecedentesDAO();
/* 1040:1045 */       antecedentesDAO.setServerNumber(servidor);
/* 1041:1046 */       antecedentesDAO.setIdioma(idioma);
/* 1042:1047 */       HistoriaMedicaDAO historiaMedicaDAO = new HistoriaMedicaDAO();
/* 1043:1048 */       historiaMedicaDAO.setServerNumber(servidor);
/* 1044:     */       
/* 1045:1050 */       HSSFRow row = null;
/* 1046:1051 */       HSSFCell cell = null;
/* 1047:     */       
/* 1048:1053 */       row = sheet.createRow(0);
/* 1049:     */       
/* 1050:1055 */       int i = 0;
/* 1051:     */       
/* 1052:1057 */       cell = row.createCell((short)i++);
/* 1053:1058 */       cell.setCellValue(RES.getString("xls.ante_des_spa"));
/* 1054:1059 */       cell.setCellStyle(boldStyle);
/* 1055:     */       
/* 1056:1061 */       cell = row.createCell((short)i++);
/* 1057:1062 */       cell.setCellValue(RES.getString("xls.ante_padre"));
/* 1058:1063 */       cell.setCellStyle(boldStyle);
/* 1059:     */       
/* 1060:1065 */       cell = row.createCell((short)i++);
/* 1061:1066 */       cell.setCellValue(RES.getString("xls.ante_madre"));
/* 1062:1067 */       cell.setCellStyle(boldStyle);
/* 1063:     */       
/* 1064:1069 */       cell = row.createCell((short)i++);
/* 1065:1070 */       cell.setCellValue(RES.getString("xls.ante_abuelos"));
/* 1066:1071 */       cell.setCellStyle(boldStyle);
/* 1067:     */       
/* 1068:1073 */       cell = row.createCell((short)i++);
/* 1069:1074 */       cell.setCellValue(RES.getString("xls.ante_hermanos"));
/* 1070:1075 */       cell.setCellStyle(boldStyle);
/* 1071:     */       
/* 1072:1077 */       int x = 1;
/* 1073:1078 */       int y = 0;
/* 1074:     */       
/* 1075:1080 */       HistoriaMedica historiaMedica = historiaMedicaDAO.retrieve(usuarioFamily.getUsuf_cod());
/* 1076:     */       
/* 1077:1082 */       Iterator iterator = historiaMedica.getAntecedentesUsuario().iterator();
/* 1078:1083 */       while (iterator.hasNext())
/* 1079:     */       {
/* 1080:1084 */         AntecedentesUsuario antecedenteUsuario = (AntecedentesUsuario)iterator.next();
/* 1081:     */         
/* 1082:1086 */         row = sheet.createRow(x++);
/* 1083:     */         
/* 1084:1088 */         cell = row.createCell((short)y++);
/* 1085:1089 */         cell.setCellValue(antecedenteUsuario.getAnteu_ante_cod().equals(IConstantes.CODIGO_NO_EXISTE) ? antecedenteUsuario.getAnteu_des() : antecedentesDAO.retrive(antecedenteUsuario.getAnteu_ante_cod()).getAnte_des());
/* 1086:     */         
/* 1087:1091 */         cell = row.createCell((short)y++);
/* 1088:1092 */         cell.setCellValue(antecedenteUsuario.getAnteu_padre().equals(IConstantes.CODIGO_SI) ? RES.getString("global.si") : RES.getString("global.no"));
/* 1089:     */         
/* 1090:1094 */         cell = row.createCell((short)y++);
/* 1091:1095 */         cell.setCellValue(antecedenteUsuario.getAnteu_madre().equals(IConstantes.CODIGO_SI) ? RES.getString("global.si") : RES.getString("global.no"));
/* 1092:     */         
/* 1093:1097 */         cell = row.createCell((short)y++);
/* 1094:1098 */         cell.setCellValue(antecedenteUsuario.getAnteu_abuelos().equals(IConstantes.CODIGO_SI) ? RES.getString("global.si") : RES.getString("global.no"));
/* 1095:     */         
/* 1096:1100 */         cell = row.createCell((short)y++);
/* 1097:1101 */         cell.setCellValue(antecedenteUsuario.getAnteu_hermanos().equals(IConstantes.CODIGO_SI) ? RES.getString("global.si") : RES.getString("global.no"));
/* 1098:     */         
/* 1099:1103 */         y = 0;
/* 1100:     */       }
/* 1101:     */     }
/* 1102:     */     catch (Exception e)
/* 1103:     */     {
/* 1104:1107 */       throw e;
/* 1105:     */     }
/* 1106:     */   }
/* 1107:     */   
/* 1108:     */   public static void generarDatosHistoriaOtros(String nombreHoja, String idioma, int servidor)
/* 1109:     */     throws Exception
/* 1110:     */   {
/* 1111:     */     try
/* 1112:     */     {
/* 1113:1119 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/* 1114:1120 */       HSSFFont boldFont = wb.createFont();
/* 1115:1121 */       boldFont.setBoldweight((short)700);
/* 1116:1122 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/* 1117:1123 */       boldStyle.setFont(boldFont);
/* 1118:     */       
/* 1119:1125 */       HistoriaMedicaDAO historiaMedicaDAO = new HistoriaMedicaDAO();
/* 1120:1126 */       historiaMedicaDAO.setServerNumber(servidor);
/* 1121:1127 */       PartesCuerpoDAO partesCuerpoDAO = new PartesCuerpoDAO();
/* 1122:1128 */       partesCuerpoDAO.setServerNumber(servidor);
/* 1123:1129 */       partesCuerpoDAO.setIdioma(idioma);
/* 1124:     */       
/* 1125:1131 */       HSSFRow row = null;
/* 1126:1132 */       HSSFCell cell = null;
/* 1127:     */       
/* 1128:1134 */       row = sheet.createRow(0);
/* 1129:     */       
/* 1130:1136 */       int i = 0;
/* 1131:     */       
/* 1132:1138 */       cell = row.createCell((short)i++);
/* 1133:1139 */       cell.setCellValue(RES.getString("xls.pcue_des"));
/* 1134:1140 */       cell.setCellStyle(boldStyle);
/* 1135:     */       
/* 1136:1142 */       cell = row.createCell((short)i++);
/* 1137:1143 */       cell.setCellValue(RES.getString("xls.pcue_comentario"));
/* 1138:1144 */       cell.setCellStyle(boldStyle);
/* 1139:     */       
/* 1140:1146 */       int x = 1;
/* 1141:1147 */       int y = 0;
/* 1142:     */       
/* 1143:1149 */       HistoriaMedica historiaMedica = historiaMedicaDAO.retrieve(usuarioFamily.getUsuf_cod());
/* 1144:     */       
/* 1145:1151 */       Iterator iterator = historiaMedica.getPartesCuerpoUsuario().iterator();
/* 1146:1152 */       while (iterator.hasNext())
/* 1147:     */       {
/* 1148:1153 */         PartesCuerpoUsuario partesCuerpoUsuario = (PartesCuerpoUsuario)iterator.next();
/* 1149:     */         
/* 1150:1155 */         row = sheet.createRow(x++);
/* 1151:     */         
/* 1152:1157 */         cell = row.createCell((short)y++);
/* 1153:1158 */         cell.setCellValue(partesCuerpoDAO.retrive(partesCuerpoUsuario.getPcueu_pcue_cod()).getPcue_des());
/* 1154:     */         
/* 1155:1160 */         cell = row.createCell((short)y++);
/* 1156:1161 */         cell.setCellValue(partesCuerpoUsuario.getPcueu_comentario());
/* 1157:     */         
/* 1158:1163 */         y = 0;
/* 1159:     */       }
/* 1160:     */     }
/* 1161:     */     catch (Exception e)
/* 1162:     */     {
/* 1163:1167 */       throw e;
/* 1164:     */     }
/* 1165:     */   }
/* 1166:     */   
/* 1167:     */   public static void generarDatosGinecologia(String nombreHoja, String idioma, int servidor)
/* 1168:     */     throws Exception
/* 1169:     */   {
/* 1170:     */     try
/* 1171:     */     {
/* 1172:1179 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/* 1173:1180 */       HSSFFont boldFont = wb.createFont();
/* 1174:1181 */       boldFont.setBoldweight((short)700);
/* 1175:1182 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/* 1176:1183 */       boldStyle.setFont(boldFont);
/* 1177:     */       
/* 1178:1185 */       GinecologiaOperacionesDAO ginecologiaOperacionesDAO = new GinecologiaOperacionesDAO();
/* 1179:1186 */       ginecologiaOperacionesDAO.setServerNumber(servidor);
/* 1180:1187 */       ginecologiaOperacionesDAO.setIdioma(idioma);
/* 1181:1188 */       HistoriaMedicaDAO historiaMedicaDAO = new HistoriaMedicaDAO();
/* 1182:1189 */       historiaMedicaDAO.setServerNumber(servidor);
/* 1183:     */       
/* 1184:1191 */       HSSFRow row = null;
/* 1185:1192 */       HSSFCell cell = null;
/* 1186:     */       
/* 1187:1194 */       row = sheet.createRow(0);
/* 1188:     */       
/* 1189:1196 */       int i = 0;
/* 1190:     */       
/* 1191:1198 */       cell = row.createCell((short)i++);
/* 1192:1199 */       cell.setCellValue(RES.getString("xls.gine_tipo_ovul"));
/* 1193:1200 */       cell.setCellStyle(boldStyle);
/* 1194:     */       
/* 1195:1202 */       cell = row.createCell((short)i++);
/* 1196:1203 */       cell.setCellValue(RES.getString("xls.gine_fec_ult"));
/* 1197:1204 */       cell.setCellStyle(boldStyle);
/* 1198:     */       
/* 1199:1206 */       cell = row.createCell((short)i++);
/* 1200:1207 */       cell.setCellValue(RES.getString("xls.gine_periodo"));
/* 1201:1208 */       cell.setCellStyle(boldStyle);
/* 1202:     */       
/* 1203:1210 */       cell = row.createCell((short)i++);
/* 1204:1211 */       cell.setCellValue(RES.getString("xls.gine_frecuencia"));
/* 1205:1212 */       cell.setCellStyle(boldStyle);
/* 1206:     */       
/* 1207:1214 */       int x = 1;
/* 1208:1215 */       int y = 0;
/* 1209:     */       
/* 1210:1217 */       HistoriaMedica historiaMedica = historiaMedicaDAO.retrieve(usuarioFamily.getUsuf_cod());
/* 1211:     */       
/* 1212:1219 */       row = sheet.createRow(x++);
/* 1213:     */       
/* 1214:1221 */       cell = row.createCell((short)y++);
/* 1215:1222 */       cell.setCellValue(historiaMedica.getGinecologia().getGine_tipo_ovul().toString().equals("1") ? RES.getString("825") : RES.getString("826"));
/* 1216:     */       
/* 1217:1224 */       cell = row.createCell((short)y++);
/* 1218:1225 */       cell.setCellValue(ManejoFechas.FormateoFecha(historiaMedica.getGinecologia().getGine_fec_ult().toString()));
/* 1219:     */       
/* 1220:1227 */       cell = row.createCell((short)y++);
/* 1221:1228 */       cell.setCellValue(historiaMedica.getGinecologia().getGine_periodo().toString());
/* 1222:     */       
/* 1223:1230 */       cell = row.createCell((short)y++);
/* 1224:1231 */       cell.setCellValue(historiaMedica.getGinecologia().getGine_frecuencia().toString());
/* 1225:     */       
/* 1226:1233 */       y = 0;
/* 1227:1234 */       i = 0;
/* 1228:1235 */       x += 2;
/* 1229:     */       
/* 1230:1237 */       row = sheet.createRow(x);
/* 1231:     */       
/* 1232:1239 */       cell = row.createCell((short)i++);
/* 1233:1240 */       cell.setCellValue(RES.getString("xls.gope_des"));
/* 1234:1241 */       cell.setCellStyle(boldStyle);
/* 1235:     */       
/* 1236:1243 */       cell = row.createCell((short)i++);
/* 1237:1244 */       cell.setCellValue(RES.getString("xls.gope_fecha"));
/* 1238:1245 */       cell.setCellStyle(boldStyle);
/* 1239:     */       
/* 1240:1247 */       cell = row.createCell((short)i++);
/* 1241:1248 */       cell.setCellValue(RES.getString("xls.gope_cantidad"));
/* 1242:1249 */       cell.setCellStyle(boldStyle);
/* 1243:     */       
/* 1244:1251 */       y = 0;
/* 1245:1252 */       x++;
/* 1246:     */       
/* 1247:1254 */       Iterator iterator = historiaMedica.getGinecologiaOperacionesUsuario().iterator();
/* 1248:1255 */       while (iterator.hasNext())
/* 1249:     */       {
/* 1250:1256 */         GinecologiaOperacionesUsuario ginecologiaOperacionesUsuario = (GinecologiaOperacionesUsuario)iterator.next();
/* 1251:     */         
/* 1252:1258 */         row = sheet.createRow(x++);
/* 1253:     */         
/* 1254:1260 */         cell = row.createCell((short)y++);
/* 1255:1261 */         cell.setCellValue(ginecologiaOperacionesUsuario.getGopeu_gope_cod().equals(IConstantes.CODIGO_NO_EXISTE) ? ginecologiaOperacionesUsuario.getGopeu_des() : ginecologiaOperacionesDAO.retrive(ginecologiaOperacionesUsuario.getGopeu_gope_cod()).getGope_des());
/* 1256:     */         
/* 1257:1263 */         cell = row.createCell((short)y++);
/* 1258:1264 */         cell.setCellValue(ManejoFechas.FormateoFecha(ginecologiaOperacionesUsuario.getGopeu_fecha().toString()));
/* 1259:     */         
/* 1260:1266 */         cell = row.createCell((short)y++);
/* 1261:1267 */         cell.setCellValue(ginecologiaOperacionesUsuario.getGopeu_cantidad().toString());
/* 1262:     */         
/* 1263:1269 */         y = 0;
/* 1264:     */       }
/* 1265:     */     }
/* 1266:     */     catch (Exception e)
/* 1267:     */     {
/* 1268:1273 */       throw e;
/* 1269:     */     }
/* 1270:     */   }
/* 1271:     */   
/* 1272:     */   public static void generarDatosTablaAjustadaOptometria(String nombreHoja, String idioma, int servidor)
/* 1273:     */     throws Exception
/* 1274:     */   {
/* 1275:     */     try
/* 1276:     */     {
/* 1277:1285 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/* 1278:1286 */       HSSFFont boldFont = wb.createFont();
/* 1279:1287 */       boldFont.setBoldweight((short)700);
/* 1280:1288 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/* 1281:1289 */       boldStyle.setFont(boldFont);
/* 1282:     */       
/* 1283:1291 */       OptometriaCompletoDAO optometriaCompletoDAO = new OptometriaCompletoDAO();
/* 1284:1292 */       optometriaCompletoDAO.setServerNumber(servidor);
/* 1285:     */       
/* 1286:1294 */       HSSFRow row = null;
/* 1287:1295 */       HSSFCell cell = null;
/* 1288:     */       
/* 1289:1297 */       row = sheet.createRow(0);
/* 1290:     */       
/* 1291:1299 */       int i = 0;
/* 1292:     */       
/* 1293:1301 */       cell = row.createCell((short)i++);
/* 1294:1302 */       cell.setCellValue(RES.getString("xls.uopt_aniosdesde"));
/* 1295:1303 */       cell.setCellStyle(boldStyle);
/* 1296:     */       
/* 1297:1305 */       cell = row.createCell((short)i++);
/* 1298:1306 */       cell.setCellValue(RES.getString("xls.uopt_anioshasta"));
/* 1299:1307 */       cell.setCellStyle(boldStyle);
/* 1300:     */       
/* 1301:1309 */       cell = row.createCell((short)i++);
/* 1302:1310 */       cell.setCellValue(RES.getString("xls.uopt_frecuencia"));
/* 1303:1311 */       cell.setCellStyle(boldStyle);
/* 1304:     */       
/* 1305:1313 */       int x = 1;
/* 1306:1314 */       int y = 0;
/* 1307:     */       
/* 1308:1316 */       OptometriaCompleto optometriaCompleto = optometriaCompletoDAO.retrieve(usuarioFamily.getUsuf_cod());
/* 1309:     */       
/* 1310:1318 */       Iterator iterator = optometriaCompleto.getTablaAjustada().iterator();
/* 1311:1319 */       while (iterator.hasNext())
/* 1312:     */       {
/* 1313:1320 */         Optometria optometria = (Optometria)iterator.next();
/* 1314:     */         
/* 1315:1322 */         row = sheet.createRow(x++);
/* 1316:     */         
/* 1317:1324 */         cell = row.createCell((short)y++);
/* 1318:1325 */         cell.setCellValue(optometria.getOpt_aniosdesde().toString());
/* 1319:     */         
/* 1320:1327 */         cell = row.createCell((short)y++);
/* 1321:1328 */         cell.setCellValue(optometria.getOpt_anioshasta().toString());
/* 1322:     */         
/* 1323:1330 */         cell = row.createCell((short)y++);
/* 1324:1331 */         cell.setCellValue(optometria.getOpt_frecuencia().toString());
/* 1325:     */         
/* 1326:1333 */         y = 0;
/* 1327:     */       }
/* 1328:     */     }
/* 1329:     */     catch (Exception e)
/* 1330:     */     {
/* 1331:1337 */       throw e;
/* 1332:     */     }
/* 1333:     */   }
/* 1334:     */   
/* 1335:     */   public static void generarDatosUltimoOptometria(String nombreHoja, String idioma, int servidor)
/* 1336:     */     throws Exception
/* 1337:     */   {
/* 1338:     */     try
/* 1339:     */     {
/* 1340:1349 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/* 1341:1350 */       HSSFFont boldFont = wb.createFont();
/* 1342:1351 */       boldFont.setBoldweight((short)700);
/* 1343:1352 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/* 1344:1353 */       boldStyle.setFont(boldFont);
/* 1345:     */       
/* 1346:1355 */       OptometriaCompletoDAO optometriaCompletoDAO = new OptometriaCompletoDAO();
/* 1347:1356 */       optometriaCompletoDAO.setServerNumber(servidor);
/* 1348:1357 */       PaisDAO paisDAO = new PaisDAO();
/* 1349:1358 */       paisDAO.setServerNumber(servidor);
/* 1350:1359 */       paisDAO.setIdioma(idioma);
/* 1351:1360 */       CiudadDAO ciudadDAO = new CiudadDAO();
/* 1352:1361 */       ciudadDAO.setServerNumber(servidor);
/* 1353:1362 */       ciudadDAO.setIdioma(idioma);
/* 1354:     */       
/* 1355:1364 */       HSSFRow row = null;
/* 1356:1365 */       HSSFCell cell = null;
/* 1357:     */       
/* 1358:1367 */       row = sheet.createRow(0);
/* 1359:     */       
/* 1360:1369 */       int i = 0;
/* 1361:     */       
/* 1362:1371 */       cell = row.createCell((short)i++);
/* 1363:1372 */       cell.setCellValue(RES.getString("839"));
/* 1364:1373 */       cell.setCellStyle(boldStyle);
/* 1365:     */       
/* 1366:1375 */       int x = 1;
/* 1367:1376 */       row = sheet.createRow(x);
/* 1368:1377 */       i = 0;
/* 1369:     */       
/* 1370:1379 */       cell = row.createCell((short)i++);
/* 1371:1380 */       cell.setCellValue(RES.getString("xls.ucop_feccontrol"));
/* 1372:1381 */       cell.setCellStyle(boldStyle);
/* 1373:     */       
/* 1374:1383 */       cell = row.createCell((short)i++);
/* 1375:1384 */       cell.setCellValue(RES.getString("xls.ucop_nommedico"));
/* 1376:1385 */       cell.setCellStyle(boldStyle);
/* 1377:     */       
/* 1378:1387 */       cell = row.createCell((short)i++);
/* 1379:1388 */       cell.setCellValue(RES.getString("xls.ucop_apemedico"));
/* 1380:1389 */       cell.setCellStyle(boldStyle);
/* 1381:     */       
/* 1382:1391 */       cell = row.createCell((short)i++);
/* 1383:1392 */       cell.setCellValue(RES.getString("xls.ucop_direccion"));
/* 1384:1393 */       cell.setCellStyle(boldStyle);
/* 1385:     */       
/* 1386:1395 */       cell = row.createCell((short)i++);
/* 1387:1396 */       cell.setCellValue(RES.getString("xls.ucop_entidad"));
/* 1388:1397 */       cell.setCellStyle(boldStyle);
/* 1389:     */       
/* 1390:1399 */       cell = row.createCell((short)i++);
/* 1391:1400 */       cell.setCellValue(RES.getString("xls.ucop_pais_cod"));
/* 1392:1401 */       cell.setCellStyle(boldStyle);
/* 1393:     */       
/* 1394:1403 */       cell = row.createCell((short)i++);
/* 1395:1404 */       cell.setCellValue(RES.getString("xls.ucop_ciudad_cod"));
/* 1396:1405 */       cell.setCellStyle(boldStyle);
/* 1397:     */       
/* 1398:1407 */       cell = row.createCell((short)i++);
/* 1399:1408 */       cell.setCellValue(RES.getString("xls.ucop_indpais"));
/* 1400:1409 */       cell.setCellStyle(boldStyle);
/* 1401:     */       
/* 1402:1411 */       cell = row.createCell((short)i++);
/* 1403:1412 */       cell.setCellValue(RES.getString("xls.ucop_indciudad"));
/* 1404:1413 */       cell.setCellStyle(boldStyle);
/* 1405:     */       
/* 1406:1415 */       cell = row.createCell((short)i++);
/* 1407:1416 */       cell.setCellValue(RES.getString("xls.ucop_telefono"));
/* 1408:1417 */       cell.setCellStyle(boldStyle);
/* 1409:     */       
/* 1410:1419 */       cell = row.createCell((short)i++);
/* 1411:1420 */       cell.setCellValue(RES.getString("xls.ucop_email"));
/* 1412:1421 */       cell.setCellStyle(boldStyle);
/* 1413:     */       
/* 1414:1423 */       x++;
/* 1415:1424 */       int y = 0;
/* 1416:     */       
/* 1417:1426 */       OptometriaCompleto optometriaCompleto = optometriaCompletoDAO.retrieve(usuarioFamily.getUsuf_cod());
/* 1418:     */       
/* 1419:1428 */       Iterator iterator = optometriaCompleto.getControlesAnteriores().iterator();
/* 1420:1429 */       while (iterator.hasNext())
/* 1421:     */       {
/* 1422:1430 */         ControlOptometria controlOptometria = (ControlOptometria)iterator.next();
/* 1423:     */         
/* 1424:1432 */         Paises paises = paisDAO.retrive(controlOptometria.getCopt_pais_cod());
/* 1425:1433 */         Ciudades ciudades = ciudadDAO.retrive(controlOptometria.getCopt_pais_cod(), controlOptometria.getCopt_ciudad_cod());
/* 1426:     */         
/* 1427:1435 */         row = sheet.createRow(x++);
/* 1428:     */         
/* 1429:1437 */         cell = row.createCell((short)y++);
/* 1430:1438 */         cell.setCellValue(ManejoFechas.FormateoFecha(controlOptometria.getCopt_feccontrol().toString()));
/* 1431:     */         
/* 1432:1440 */         cell = row.createCell((short)y++);
/* 1433:1441 */         cell.setCellValue(controlOptometria.getCopt_nommedico());
/* 1434:     */         
/* 1435:1443 */         cell = row.createCell((short)y++);
/* 1436:1444 */         cell.setCellValue(controlOptometria.getCopt_apemedico());
/* 1437:     */         
/* 1438:1446 */         cell = row.createCell((short)y++);
/* 1439:1447 */         cell.setCellValue(controlOptometria.getCopt_direccion());
/* 1440:     */         
/* 1441:1449 */         cell = row.createCell((short)y++);
/* 1442:1450 */         cell.setCellValue(controlOptometria.getCopt_entidad());
/* 1443:     */         
/* 1444:1452 */         cell = row.createCell((short)y++);
/* 1445:1453 */         cell.setCellValue(paises.getPais_des());
/* 1446:     */         
/* 1447:1455 */         cell = row.createCell((short)y++);
/* 1448:1456 */         cell.setCellValue(ciudades.getCiu_des());
/* 1449:     */         
/* 1450:1458 */         cell = row.createCell((short)y++);
/* 1451:1459 */         cell.setCellValue(controlOptometria.getCopt_indpais().toString());
/* 1452:     */         
/* 1453:1461 */         cell = row.createCell((short)y++);
/* 1454:1462 */         cell.setCellValue(controlOptometria.getCopt_indciudad().toString());
/* 1455:     */         
/* 1456:1464 */         cell = row.createCell((short)y++);
/* 1457:1465 */         cell.setCellValue(controlOptometria.getCopt_telefono());
/* 1458:     */         
/* 1459:1467 */         cell = row.createCell((short)y++);
/* 1460:1468 */         cell.setCellValue(controlOptometria.getCopt_email());
/* 1461:     */         
/* 1462:1470 */         y = 0;
/* 1463:     */       }
/* 1464:1473 */       x++;
/* 1465:1474 */       i = 0;
/* 1466:1475 */       row = sheet.createRow(++x);
/* 1467:1476 */       cell = row.createCell((short)i++);
/* 1468:1477 */       cell.setCellValue(RES.getString("838"));
/* 1469:1478 */       cell.setCellStyle(boldStyle);
/* 1470:     */       
/* 1471:1480 */       x++;
/* 1472:1481 */       i = 0;
/* 1473:1482 */       row = sheet.createRow(x++);
/* 1474:1483 */       cell = row.createCell((short)i++);
/* 1475:1484 */       cell.setCellValue(RES.getString("xls.ucop_feccontrol"));
/* 1476:1485 */       cell.setCellStyle(boldStyle);
/* 1477:     */       
/* 1478:1487 */       cell = row.createCell((short)i++);
/* 1479:1488 */       cell.setCellValue(RES.getString("xls.ucop_hora"));
/* 1480:1489 */       cell.setCellStyle(boldStyle);
/* 1481:     */       
/* 1482:1491 */       cell = row.createCell((short)i++);
/* 1483:1492 */       cell.setCellValue(RES.getString("xls.ucop_nommedico"));
/* 1484:1493 */       cell.setCellStyle(boldStyle);
/* 1485:     */       
/* 1486:1495 */       cell = row.createCell((short)i++);
/* 1487:1496 */       cell.setCellValue(RES.getString("xls.ucop_apemedico"));
/* 1488:1497 */       cell.setCellStyle(boldStyle);
/* 1489:     */       
/* 1490:1499 */       cell = row.createCell((short)i++);
/* 1491:1500 */       cell.setCellValue(RES.getString("xls.ucop_direccion"));
/* 1492:1501 */       cell.setCellStyle(boldStyle);
/* 1493:     */       
/* 1494:1503 */       cell = row.createCell((short)i++);
/* 1495:1504 */       cell.setCellValue(RES.getString("xls.ucop_entidad"));
/* 1496:1505 */       cell.setCellStyle(boldStyle);
/* 1497:     */       
/* 1498:1507 */       cell = row.createCell((short)i++);
/* 1499:1508 */       cell.setCellValue(RES.getString("xls.ucop_pais_cod"));
/* 1500:1509 */       cell.setCellStyle(boldStyle);
/* 1501:     */       
/* 1502:1511 */       cell = row.createCell((short)i++);
/* 1503:1512 */       cell.setCellValue(RES.getString("xls.ucop_ciudad_cod"));
/* 1504:1513 */       cell.setCellStyle(boldStyle);
/* 1505:     */       
/* 1506:1515 */       cell = row.createCell((short)i++);
/* 1507:1516 */       cell.setCellValue(RES.getString("xls.ucop_indpais"));
/* 1508:1517 */       cell.setCellStyle(boldStyle);
/* 1509:     */       
/* 1510:1519 */       cell = row.createCell((short)i++);
/* 1511:1520 */       cell.setCellValue(RES.getString("xls.ucop_indciudad"));
/* 1512:1521 */       cell.setCellStyle(boldStyle);
/* 1513:     */       
/* 1514:1523 */       cell = row.createCell((short)i++);
/* 1515:1524 */       cell.setCellValue(RES.getString("xls.ucop_telefono"));
/* 1516:1525 */       cell.setCellStyle(boldStyle);
/* 1517:     */       
/* 1518:1527 */       cell = row.createCell((short)i++);
/* 1519:1528 */       cell.setCellValue(RES.getString("xls.ucop_email"));
/* 1520:1529 */       cell.setCellStyle(boldStyle);
/* 1521:     */       
/* 1522:1531 */       iterator = optometriaCompleto.getControlesProximos().iterator();
/* 1523:1532 */       while (iterator.hasNext())
/* 1524:     */       {
/* 1525:1533 */         ControlOptometria controlOptometria = (ControlOptometria)iterator.next();
/* 1526:     */         
/* 1527:1535 */         Paises paises = paisDAO.retrive(controlOptometria.getCopt_pais_cod());
/* 1528:1536 */         Ciudades ciudades = ciudadDAO.retrive(controlOptometria.getCopt_pais_cod(), controlOptometria.getCopt_ciudad_cod());
/* 1529:     */         
/* 1530:1538 */         row = sheet.createRow(x++);
/* 1531:     */         
/* 1532:1540 */         cell = row.createCell((short)y++);
/* 1533:1541 */         cell.setCellValue(ManejoFechas.FormateoFecha(controlOptometria.getCopt_feccontrol().toString()));
/* 1534:     */         
/* 1535:1543 */         cell = row.createCell((short)y++);
/* 1536:     */         
/* 1537:1545 */         cell.setCellValue(ManejoFechas.FormateoHoraAMPMReportes(controlOptometria.getCopt_horacontrol().toString()));
/* 1538:     */         
/* 1539:1547 */         cell = row.createCell((short)y++);
/* 1540:1548 */         cell.setCellValue(controlOptometria.getCopt_nommedico());
/* 1541:     */         
/* 1542:1550 */         cell = row.createCell((short)y++);
/* 1543:1551 */         cell.setCellValue(controlOptometria.getCopt_apemedico());
/* 1544:     */         
/* 1545:1553 */         cell = row.createCell((short)y++);
/* 1546:1554 */         cell.setCellValue(controlOptometria.getCopt_direccion());
/* 1547:     */         
/* 1548:1556 */         cell = row.createCell((short)y++);
/* 1549:1557 */         cell.setCellValue(controlOptometria.getCopt_entidad());
/* 1550:     */         
/* 1551:1559 */         cell = row.createCell((short)y++);
/* 1552:1560 */         cell.setCellValue(paises.getPais_des());
/* 1553:     */         
/* 1554:1562 */         cell = row.createCell((short)y++);
/* 1555:1563 */         cell.setCellValue(ciudades.getCiu_des());
/* 1556:     */         
/* 1557:1565 */         cell = row.createCell((short)y++);
/* 1558:1566 */         cell.setCellValue(controlOptometria.getCopt_indpais().toString());
/* 1559:     */         
/* 1560:1568 */         cell = row.createCell((short)y++);
/* 1561:1569 */         cell.setCellValue(controlOptometria.getCopt_indciudad().toString());
/* 1562:     */         
/* 1563:1571 */         cell = row.createCell((short)y++);
/* 1564:1572 */         cell.setCellValue(controlOptometria.getCopt_telefono());
/* 1565:     */         
/* 1566:1574 */         cell = row.createCell((short)y++);
/* 1567:1575 */         cell.setCellValue(controlOptometria.getCopt_email());
/* 1568:     */         
/* 1569:1577 */         y = 0;
/* 1570:     */       }
/* 1571:     */     }
/* 1572:     */     catch (Exception e)
/* 1573:     */     {
/* 1574:1581 */       throw e;
/* 1575:     */     }
/* 1576:     */   }
/* 1577:     */   
/* 1578:     */   public static void generarDatosTablaAjustadaOdontologia(String nombreHoja, String idioma, int servidor)
/* 1579:     */     throws Exception
/* 1580:     */   {
/* 1581:     */     try
/* 1582:     */     {
/* 1583:1593 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/* 1584:1594 */       HSSFFont boldFont = wb.createFont();
/* 1585:1595 */       boldFont.setBoldweight((short)700);
/* 1586:1596 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/* 1587:1597 */       boldStyle.setFont(boldFont);
/* 1588:     */       
/* 1589:1599 */       OdontologiaCompletoDAO odontologiaCompletoDAO = new OdontologiaCompletoDAO();
/* 1590:1600 */       odontologiaCompletoDAO.setServerNumber(servidor);
/* 1591:1601 */       odontologiaCompletoDAO.setIdioma(idioma);
/* 1592:1602 */       OdontologiaDAO odontologiaDAO = new OdontologiaDAO();
/* 1593:1603 */       odontologiaDAO.setServerNumber(servidor);
/* 1594:1604 */       odontologiaDAO.setIdioma(idioma);
/* 1595:     */       
/* 1596:1606 */       HSSFRow row = null;
/* 1597:1607 */       HSSFCell cell = null;
/* 1598:     */       
/* 1599:1609 */       row = sheet.createRow(0);
/* 1600:     */       
/* 1601:1611 */       int i = 0;
/* 1602:     */       
/* 1603:1613 */       cell = row.createCell((short)i++);
/* 1604:1614 */       cell.setCellValue(RES.getString("xls.uodo_destratamiento"));
/* 1605:1615 */       cell.setCellStyle(boldStyle);
/* 1606:     */       
/* 1607:1617 */       cell = row.createCell((short)i++);
/* 1608:1618 */       cell.setCellValue(RES.getString("xls.uodo_edaddesdemes"));
/* 1609:1619 */       cell.setCellStyle(boldStyle);
/* 1610:     */       
/* 1611:1621 */       cell = row.createCell((short)i++);
/* 1612:1622 */       cell.setCellValue(RES.getString("xls.uodo_edaddesdeanio"));
/* 1613:1623 */       cell.setCellStyle(boldStyle);
/* 1614:     */       
/* 1615:1625 */       cell = row.createCell((short)i++);
/* 1616:1626 */       cell.setCellValue(RES.getString("xls.uodo_edadhastames"));
/* 1617:1627 */       cell.setCellStyle(boldStyle);
/* 1618:     */       
/* 1619:1629 */       cell = row.createCell((short)i++);
/* 1620:1630 */       cell.setCellValue(RES.getString("xls.uodo_edadhastaanio"));
/* 1621:1631 */       cell.setCellStyle(boldStyle);
/* 1622:     */       
/* 1623:1633 */       cell = row.createCell((short)i++);
/* 1624:1634 */       cell.setCellValue(RES.getString("xls.uodo_frecuencia"));
/* 1625:1635 */       cell.setCellStyle(boldStyle);
/* 1626:     */       
/* 1627:1637 */       int x = 1;
/* 1628:1638 */       int y = 0;
/* 1629:     */       
/* 1630:1640 */       OdontologiaCompleto odontologiaCompleto = odontologiaCompletoDAO.retrieve(usuarioFamily.getUsuf_cod());
/* 1631:     */       
/* 1632:1642 */       Iterator iterator = odontologiaCompleto.getTablaAjustada().iterator();
/* 1633:1643 */       while (iterator.hasNext())
/* 1634:     */       {
/* 1635:1644 */         OdontologiaUsuario odontologiaUsuario = (OdontologiaUsuario)iterator.next();
/* 1636:     */         
/* 1637:1646 */         row = sheet.createRow(x++);
/* 1638:     */         
/* 1639:1648 */         cell = row.createCell((short)y++);
/* 1640:1649 */         cell.setCellValue(odontologiaUsuario.getOdou_odo_cod().equals(IConstantes.CODIGO_NO_EXISTE) ? odontologiaUsuario.getOdou_destratamiento() : odontologiaDAO.retrive(odontologiaUsuario.getOdou_odo_cod()).getOdo_destratamiento());
/* 1641:     */         
/* 1642:1651 */         cell = row.createCell((short)y++);
/* 1643:1652 */         cell.setCellValue(odontologiaUsuario.getOdou_edaddesdemes().toString());
/* 1644:     */         
/* 1645:1654 */         cell = row.createCell((short)y++);
/* 1646:1655 */         cell.setCellValue(odontologiaUsuario.getOdou_edaddesdeanio().toString());
/* 1647:     */         
/* 1648:1657 */         cell = row.createCell((short)y++);
/* 1649:1658 */         cell.setCellValue(odontologiaUsuario.getOdou_edadhastames().toString());
/* 1650:     */         
/* 1651:1660 */         cell = row.createCell((short)y++);
/* 1652:1661 */         cell.setCellValue(odontologiaUsuario.getOdou_edadhastaanio().toString());
/* 1653:     */         
/* 1654:1663 */         cell = row.createCell((short)y++);
/* 1655:1664 */         cell.setCellValue(odontologiaUsuario.getOdou_frecuencia().toString());
/* 1656:     */         
/* 1657:1666 */         y = 0;
/* 1658:     */       }
/* 1659:     */     }
/* 1660:     */     catch (Exception e)
/* 1661:     */     {
/* 1662:1670 */       throw e;
/* 1663:     */     }
/* 1664:     */   }
/* 1665:     */   
/* 1666:     */   public static void generarDatosUltimoOdontologia(String nombreHoja, String idioma, int servidor)
/* 1667:     */     throws Exception
/* 1668:     */   {
/* 1669:     */     try
/* 1670:     */     {
/* 1671:1682 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/* 1672:1683 */       HSSFFont boldFont = wb.createFont();
/* 1673:1684 */       boldFont.setBoldweight((short)700);
/* 1674:1685 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/* 1675:1686 */       boldStyle.setFont(boldFont);
/* 1676:     */       
/* 1677:1688 */       OdontologiaCompletoDAO odontologiaCompletoDAO = new OdontologiaCompletoDAO();
/* 1678:1689 */       odontologiaCompletoDAO.setServerNumber(servidor);
/* 1679:1690 */       odontologiaCompletoDAO.setIdioma(idioma);
/* 1680:1691 */       PaisDAO paisDAO = new PaisDAO();
/* 1681:1692 */       paisDAO.setServerNumber(servidor);
/* 1682:1693 */       paisDAO.setIdioma(idioma);
/* 1683:1694 */       CiudadDAO ciudadDAO = new CiudadDAO();
/* 1684:1695 */       ciudadDAO.setServerNumber(servidor);
/* 1685:1696 */       ciudadDAO.setIdioma(idioma);
/* 1686:     */       
/* 1687:1698 */       HSSFRow row = null;
/* 1688:1699 */       HSSFCell cell = null;
/* 1689:     */       
/* 1690:1701 */       int x = 0;
/* 1691:1702 */       int i = 0;
/* 1692:     */       
/* 1693:1704 */       row = sheet.createRow(x++);
/* 1694:1705 */       cell = row.createCell((short)i++);
/* 1695:1706 */       cell.setCellValue(RES.getString("839"));
/* 1696:1707 */       cell.setCellStyle(boldStyle);
/* 1697:     */       
/* 1698:1709 */       i = 0;
/* 1699:     */       
/* 1700:1711 */       row = sheet.createRow(x++);
/* 1701:1712 */       cell = row.createCell((short)i++);
/* 1702:1713 */       cell.setCellValue(RES.getString("xls.ucod_destratamiento"));
/* 1703:1714 */       cell.setCellStyle(boldStyle);
/* 1704:     */       
/* 1705:1716 */       cell = row.createCell((short)i++);
/* 1706:1717 */       cell.setCellValue(RES.getString("xls.ucod_feccontrol"));
/* 1707:1718 */       cell.setCellStyle(boldStyle);
/* 1708:     */       
/* 1709:1720 */       cell = row.createCell((short)i++);
/* 1710:1721 */       cell.setCellValue(RES.getString("xls.ucod_nommedico"));
/* 1711:1722 */       cell.setCellStyle(boldStyle);
/* 1712:     */       
/* 1713:1724 */       cell = row.createCell((short)i++);
/* 1714:1725 */       cell.setCellValue(RES.getString("xls.ucod_apemedico"));
/* 1715:1726 */       cell.setCellStyle(boldStyle);
/* 1716:     */       
/* 1717:1728 */       cell = row.createCell((short)i++);
/* 1718:1729 */       cell.setCellValue(RES.getString("xls.ucod_direccion"));
/* 1719:1730 */       cell.setCellStyle(boldStyle);
/* 1720:     */       
/* 1721:1732 */       cell = row.createCell((short)i++);
/* 1722:1733 */       cell.setCellValue(RES.getString("xls.ucod_entidad"));
/* 1723:1734 */       cell.setCellStyle(boldStyle);
/* 1724:     */       
/* 1725:1736 */       cell = row.createCell((short)i++);
/* 1726:1737 */       cell.setCellValue(RES.getString("xls.ucod_pais_cod"));
/* 1727:1738 */       cell.setCellStyle(boldStyle);
/* 1728:     */       
/* 1729:1740 */       cell = row.createCell((short)i++);
/* 1730:1741 */       cell.setCellValue(RES.getString("xls.ucod_ciudad_cod"));
/* 1731:1742 */       cell.setCellStyle(boldStyle);
/* 1732:     */       
/* 1733:1744 */       cell = row.createCell((short)i++);
/* 1734:1745 */       cell.setCellValue(RES.getString("xls.ucod_indpais"));
/* 1735:1746 */       cell.setCellStyle(boldStyle);
/* 1736:     */       
/* 1737:1748 */       cell = row.createCell((short)i++);
/* 1738:1749 */       cell.setCellValue(RES.getString("xls.ucod_indciudad"));
/* 1739:1750 */       cell.setCellStyle(boldStyle);
/* 1740:     */       
/* 1741:1752 */       cell = row.createCell((short)i++);
/* 1742:1753 */       cell.setCellValue(RES.getString("xls.ucod_telefono"));
/* 1743:1754 */       cell.setCellStyle(boldStyle);
/* 1744:     */       
/* 1745:1756 */       cell = row.createCell((short)i++);
/* 1746:1757 */       cell.setCellValue(RES.getString("xls.ucod_email"));
/* 1747:1758 */       cell.setCellStyle(boldStyle);
/* 1748:     */       
/* 1749:1760 */       int y = 0;
/* 1750:     */       
/* 1751:1762 */       OdontologiaCompleto odontologiaCompleto = odontologiaCompletoDAO.retrieve(usuarioFamily.getUsuf_cod());
/* 1752:     */       
/* 1753:1764 */       Iterator iterator = odontologiaCompleto.getControlesAnteriores().iterator();
/* 1754:1765 */       while (iterator.hasNext())
/* 1755:     */       {
/* 1756:1766 */         ControlOdontologia controlOdontologia = (ControlOdontologia)iterator.next();
/* 1757:     */         
/* 1758:1768 */         Paises paises = paisDAO.retrive(controlOdontologia.getCodo_pais_cod());
/* 1759:1769 */         Ciudades ciudades = ciudadDAO.retrive(controlOdontologia.getCodo_pais_cod(), controlOdontologia.getCodo_ciudad_cod());
/* 1760:     */         
/* 1761:1771 */         row = sheet.createRow(x++);
/* 1762:     */         
/* 1763:1773 */         cell = row.createCell((short)y++);
/* 1764:1774 */         cell.setCellValue(controlOdontologia.getCodo_destratamiento());
/* 1765:     */         
/* 1766:1776 */         cell = row.createCell((short)y++);
/* 1767:1777 */         cell.setCellValue(ManejoFechas.FormateoFecha(controlOdontologia.getCodo_feccontrol().toString()));
/* 1768:     */         
/* 1769:1779 */         cell = row.createCell((short)y++);
/* 1770:1780 */         cell.setCellValue(controlOdontologia.getCodo_nommedico());
/* 1771:     */         
/* 1772:1782 */         cell = row.createCell((short)y++);
/* 1773:1783 */         cell.setCellValue(controlOdontologia.getCodo_apemedico());
/* 1774:     */         
/* 1775:1785 */         cell = row.createCell((short)y++);
/* 1776:1786 */         cell.setCellValue(controlOdontologia.getCodo_direccion());
/* 1777:     */         
/* 1778:1788 */         cell = row.createCell((short)y++);
/* 1779:1789 */         cell.setCellValue(controlOdontologia.getCodo_entidad());
/* 1780:     */         
/* 1781:1791 */         cell = row.createCell((short)y++);
/* 1782:1792 */         cell.setCellValue(paises.getPais_des());
/* 1783:     */         
/* 1784:1794 */         cell = row.createCell((short)y++);
/* 1785:1795 */         cell.setCellValue(ciudades.getCiu_des());
/* 1786:     */         
/* 1787:1797 */         cell = row.createCell((short)y++);
/* 1788:1798 */         cell.setCellValue(controlOdontologia.getCodo_indpais().toString());
/* 1789:     */         
/* 1790:1800 */         cell = row.createCell((short)y++);
/* 1791:1801 */         cell.setCellValue(controlOdontologia.getCodo_indciudad().toString());
/* 1792:     */         
/* 1793:1803 */         cell = row.createCell((short)y++);
/* 1794:1804 */         cell.setCellValue(controlOdontologia.getCodo_telefono());
/* 1795:     */         
/* 1796:1806 */         cell = row.createCell((short)y++);
/* 1797:1807 */         cell.setCellValue(controlOdontologia.getCodo_email());
/* 1798:     */         
/* 1799:1809 */         y = 0;
/* 1800:     */       }
/* 1801:1812 */       x++;
/* 1802:1813 */       i = 0;
/* 1803:1814 */       row = sheet.createRow(x++);
/* 1804:1815 */       cell = row.createCell((short)i++);
/* 1805:1816 */       cell.setCellValue(RES.getString("838"));
/* 1806:1817 */       cell.setCellStyle(boldStyle);
/* 1807:     */       
/* 1808:1819 */       i = 0;
/* 1809:     */       
/* 1810:1821 */       row = sheet.createRow(x++);
/* 1811:1822 */       cell = row.createCell((short)i++);
/* 1812:1823 */       cell.setCellValue(RES.getString("xls.ucod_destratamiento"));
/* 1813:1824 */       cell.setCellStyle(boldStyle);
/* 1814:     */       
/* 1815:1826 */       cell = row.createCell((short)i++);
/* 1816:1827 */       cell.setCellValue(RES.getString("xls.ucod_feccontrol"));
/* 1817:1828 */       cell.setCellStyle(boldStyle);
/* 1818:     */       
/* 1819:1830 */       cell = row.createCell((short)i++);
/* 1820:1831 */       cell.setCellValue(RES.getString("xls.ucod_hora"));
/* 1821:1832 */       cell.setCellStyle(boldStyle);
/* 1822:     */       
/* 1823:1834 */       cell = row.createCell((short)i++);
/* 1824:1835 */       cell.setCellValue(RES.getString("xls.ucod_nommedico"));
/* 1825:1836 */       cell.setCellStyle(boldStyle);
/* 1826:     */       
/* 1827:1838 */       cell = row.createCell((short)i++);
/* 1828:1839 */       cell.setCellValue(RES.getString("xls.ucod_apemedico"));
/* 1829:1840 */       cell.setCellStyle(boldStyle);
/* 1830:     */       
/* 1831:1842 */       cell = row.createCell((short)i++);
/* 1832:1843 */       cell.setCellValue(RES.getString("xls.ucod_direccion"));
/* 1833:1844 */       cell.setCellStyle(boldStyle);
/* 1834:     */       
/* 1835:1846 */       cell = row.createCell((short)i++);
/* 1836:1847 */       cell.setCellValue(RES.getString("xls.ucod_entidad"));
/* 1837:1848 */       cell.setCellStyle(boldStyle);
/* 1838:     */       
/* 1839:1850 */       cell = row.createCell((short)i++);
/* 1840:1851 */       cell.setCellValue(RES.getString("xls.ucod_pais_cod"));
/* 1841:1852 */       cell.setCellStyle(boldStyle);
/* 1842:     */       
/* 1843:1854 */       cell = row.createCell((short)i++);
/* 1844:1855 */       cell.setCellValue(RES.getString("xls.ucod_ciudad_cod"));
/* 1845:1856 */       cell.setCellStyle(boldStyle);
/* 1846:     */       
/* 1847:1858 */       cell = row.createCell((short)i++);
/* 1848:1859 */       cell.setCellValue(RES.getString("xls.ucod_indpais"));
/* 1849:1860 */       cell.setCellStyle(boldStyle);
/* 1850:     */       
/* 1851:1862 */       cell = row.createCell((short)i++);
/* 1852:1863 */       cell.setCellValue(RES.getString("xls.ucod_indciudad"));
/* 1853:1864 */       cell.setCellStyle(boldStyle);
/* 1854:     */       
/* 1855:1866 */       cell = row.createCell((short)i++);
/* 1856:1867 */       cell.setCellValue(RES.getString("xls.ucod_telefono"));
/* 1857:1868 */       cell.setCellStyle(boldStyle);
/* 1858:     */       
/* 1859:1870 */       cell = row.createCell((short)i++);
/* 1860:1871 */       cell.setCellValue(RES.getString("xls.ucod_email"));
/* 1861:1872 */       cell.setCellStyle(boldStyle);
/* 1862:     */       
/* 1863:1874 */       iterator = odontologiaCompleto.getControlesProximos().iterator();
/* 1864:1875 */       while (iterator.hasNext())
/* 1865:     */       {
/* 1866:1876 */         ControlOdontologia controlOdontologia = (ControlOdontologia)iterator.next();
/* 1867:     */         
/* 1868:1878 */         Paises paises = paisDAO.retrive(controlOdontologia.getCodo_pais_cod());
/* 1869:1879 */         Ciudades ciudades = ciudadDAO.retrive(controlOdontologia.getCodo_pais_cod(), controlOdontologia.getCodo_ciudad_cod());
/* 1870:     */         
/* 1871:1881 */         row = sheet.createRow(x++);
/* 1872:     */         
/* 1873:1883 */         cell = row.createCell((short)y++);
/* 1874:1884 */         cell.setCellValue(controlOdontologia.getCodo_destratamiento());
/* 1875:     */         
/* 1876:1886 */         cell = row.createCell((short)y++);
/* 1877:1887 */         cell.setCellValue(ManejoFechas.FormateoFecha(controlOdontologia.getCodo_feccontrol().toString()));
/* 1878:     */         
/* 1879:1889 */         cell = row.createCell((short)y++);
/* 1880:1890 */         cell.setCellValue(ManejoFechas.FormateoHoraAMPMReportes(controlOdontologia.getCodo_hora().toString()));
/* 1881:     */         
/* 1882:1892 */         cell = row.createCell((short)y++);
/* 1883:1893 */         cell.setCellValue(controlOdontologia.getCodo_nommedico());
/* 1884:     */         
/* 1885:1895 */         cell = row.createCell((short)y++);
/* 1886:1896 */         cell.setCellValue(controlOdontologia.getCodo_apemedico());
/* 1887:     */         
/* 1888:1898 */         cell = row.createCell((short)y++);
/* 1889:1899 */         cell.setCellValue(controlOdontologia.getCodo_direccion());
/* 1890:     */         
/* 1891:1901 */         cell = row.createCell((short)y++);
/* 1892:1902 */         cell.setCellValue(controlOdontologia.getCodo_entidad());
/* 1893:     */         
/* 1894:1904 */         cell = row.createCell((short)y++);
/* 1895:1905 */         cell.setCellValue(paises.getPais_des());
/* 1896:     */         
/* 1897:1907 */         cell = row.createCell((short)y++);
/* 1898:1908 */         cell.setCellValue(ciudades.getCiu_des());
/* 1899:     */         
/* 1900:1910 */         cell = row.createCell((short)y++);
/* 1901:1911 */         cell.setCellValue(controlOdontologia.getCodo_indpais().toString());
/* 1902:     */         
/* 1903:1913 */         cell = row.createCell((short)y++);
/* 1904:1914 */         cell.setCellValue(controlOdontologia.getCodo_indciudad().toString());
/* 1905:     */         
/* 1906:1916 */         cell = row.createCell((short)y++);
/* 1907:1917 */         cell.setCellValue(controlOdontologia.getCodo_telefono());
/* 1908:     */         
/* 1909:1919 */         cell = row.createCell((short)y++);
/* 1910:1920 */         cell.setCellValue(controlOdontologia.getCodo_email());
/* 1911:     */         
/* 1912:1922 */         y = 0;
/* 1913:     */       }
/* 1914:     */     }
/* 1915:     */     catch (Exception e)
/* 1916:     */     {
/* 1917:1926 */       throw e;
/* 1918:     */     }
/* 1919:     */   }
/* 1920:     */   
/* 1921:     */   public static void generarDatosTablaAjustadaMedico(String nombreHoja, String idioma, int servidor)
/* 1922:     */     throws Exception
/* 1923:     */   {
/* 1924:     */     try
/* 1925:     */     {
/* 1926:1938 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/* 1927:1939 */       HSSFFont boldFont = wb.createFont();
/* 1928:1940 */       boldFont.setBoldweight((short)700);
/* 1929:1941 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/* 1930:1942 */       boldStyle.setFont(boldFont);
/* 1931:     */       
/* 1932:1944 */       MedicinaCompletoDAO medicinaCompletoDAO = new MedicinaCompletoDAO();
/* 1933:1945 */       medicinaCompletoDAO.setServerNumber(servidor);
/* 1934:1946 */       medicinaCompletoDAO.setIdioma(idioma);
/* 1935:1947 */       DatosPersonalesDAO datosPersonalesDAO = new DatosPersonalesDAO();
/* 1936:1948 */       datosPersonalesDAO.setServerNumber(servidor);
/* 1937:     */       
/* 1938:1950 */       ExamenesDAO examenesDAO = new ExamenesDAO();
/* 1939:1951 */       examenesDAO.setServerNumber(servidor);
/* 1940:1952 */       examenesDAO.setIdioma(idioma);
/* 1941:1953 */       PaisDAO paisDAO = new PaisDAO();
/* 1942:1954 */       paisDAO.setServerNumber(servidor);
/* 1943:1955 */       paisDAO.setIdioma(idioma);
/* 1944:1956 */       CiudadDAO ciudadDAO = new CiudadDAO();
/* 1945:1957 */       ciudadDAO.setServerNumber(servidor);
/* 1946:1958 */       ciudadDAO.setIdioma(idioma);
/* 1947:     */       
/* 1948:1960 */       HSSFRow row = null;
/* 1949:1961 */       HSSFCell cell = null;
/* 1950:     */       
/* 1951:1963 */       row = sheet.createRow(0);
/* 1952:     */       
/* 1953:1965 */       int i = 0;
/* 1954:     */       
/* 1955:1967 */       cell = row.createCell((short)i++);
/* 1956:1968 */       cell.setCellValue(RES.getString("xls.exa_des"));
/* 1957:1969 */       cell.setCellStyle(boldStyle);
/* 1958:     */       
/* 1959:1971 */       cell = row.createCell((short)i++);
/* 1960:1972 */       cell.setCellValue(RES.getString("xls.exa_edad"));
/* 1961:1973 */       cell.setCellStyle(boldStyle);
/* 1962:     */       
/* 1963:1975 */       int x = 1;
/* 1964:1976 */       int y = 0;
/* 1965:     */       
/* 1966:1978 */       DatosPersonales datosPersonales = datosPersonalesDAO.retrive(usuarioFamily.getUsuf_cod());
/* 1967:1979 */       MedicinaCompleto medicinaCompleto = medicinaCompletoDAO.retrieve(usuarioFamily.getUsuf_cod(), datosPersonales.getDatp_sexo());
/* 1968:     */       
/* 1969:1981 */       Iterator iterator = medicinaCompleto.getTablaAjustada().iterator();
/* 1970:1982 */       while (iterator.hasNext())
/* 1971:     */       {
/* 1972:1983 */         ExamenesUsuario examenesUsuario = (ExamenesUsuario)iterator.next();
/* 1973:     */         
/* 1974:1985 */         row = sheet.createRow(x++);
/* 1975:     */         
/* 1976:1987 */         cell = row.createCell((short)y++);
/* 1977:1988 */         cell.setCellValue(examenesUsuario.getExau_exa_cod().equals(IConstantes.CODIGO_NO_EXISTE) ? examenesUsuario.getExau_des() : examenesDAO.retrive(examenesUsuario.getExau_exa_cod()).getExa_des());
/* 1978:     */         
/* 1979:1990 */         cell = row.createCell((short)y++);
/* 1980:1991 */         cell.setCellValue(examenesUsuario.getExau_edad().toString());
/* 1981:     */         
/* 1982:1993 */         y = 0;
/* 1983:     */       }
/* 1984:     */     }
/* 1985:     */     catch (Exception e)
/* 1986:     */     {
/* 1987:1997 */       throw e;
/* 1988:     */     }
/* 1989:     */   }
/* 1990:     */   
/* 1991:     */   public static void generarDatosUtimoMedicina(String nombreHoja, String idioma, int servidor)
/* 1992:     */     throws Exception
/* 1993:     */   {
/* 1994:     */     try
/* 1995:     */     {
/* 1996:2009 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/* 1997:2010 */       HSSFFont boldFont = wb.createFont();
/* 1998:2011 */       boldFont.setBoldweight((short)700);
/* 1999:2012 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/* 2000:2013 */       boldStyle.setFont(boldFont);
/* 2001:     */       
/* 2002:2015 */       MedicinaCompletoDAO medicinaCompletoDAO = new MedicinaCompletoDAO();
/* 2003:2016 */       medicinaCompletoDAO.setServerNumber(servidor);
/* 2004:2017 */       DatosPersonalesDAO datosPersonalesDAO = new DatosPersonalesDAO();
/* 2005:2018 */       datosPersonalesDAO.setServerNumber(servidor);
/* 2006:     */       
/* 2007:2020 */       medicinaCompletoDAO.setIdioma(idioma);
/* 2008:2021 */       PaisDAO paisDAO = new PaisDAO();
/* 2009:2022 */       paisDAO.setServerNumber(servidor);
/* 2010:2023 */       paisDAO.setIdioma(idioma);
/* 2011:2024 */       CiudadDAO ciudadDAO = new CiudadDAO();
/* 2012:2025 */       ciudadDAO.setServerNumber(servidor);
/* 2013:2026 */       ciudadDAO.setIdioma(idioma);
/* 2014:     */       
/* 2015:2028 */       HSSFRow row = null;
/* 2016:2029 */       HSSFCell cell = null;
/* 2017:     */       
/* 2018:2031 */       int i = 0;
/* 2019:2032 */       int x = 0;
/* 2020:     */       
/* 2021:2034 */       row = sheet.createRow(x++);
/* 2022:2035 */       cell = row.createCell((short)i++);
/* 2023:2036 */       cell.setCellValue(RES.getString("839"));
/* 2024:2037 */       cell.setCellStyle(boldStyle);
/* 2025:     */       
/* 2026:2039 */       i = 0;
/* 2027:2040 */       row = sheet.createRow(x++);
/* 2028:2041 */       cell = row.createCell((short)i++);
/* 2029:2042 */       cell.setCellValue(RES.getString("xls.cmed_destratamiento"));
/* 2030:2043 */       cell.setCellStyle(boldStyle);
/* 2031:     */       
/* 2032:2045 */       cell = row.createCell((short)i++);
/* 2033:2046 */       cell.setCellValue(RES.getString("xls.cmed_feccontrol"));
/* 2034:2047 */       cell.setCellStyle(boldStyle);
/* 2035:     */       
/* 2036:2049 */       cell = row.createCell((short)i++);
/* 2037:2050 */       cell.setCellValue(RES.getString("xls.cmed_nommedico"));
/* 2038:2051 */       cell.setCellStyle(boldStyle);
/* 2039:     */       
/* 2040:2053 */       cell = row.createCell((short)i++);
/* 2041:2054 */       cell.setCellValue(RES.getString("xls.cmed_apemedico"));
/* 2042:2055 */       cell.setCellStyle(boldStyle);
/* 2043:     */       
/* 2044:2057 */       cell = row.createCell((short)i++);
/* 2045:2058 */       cell.setCellValue(RES.getString("xls.cmed_direccion"));
/* 2046:2059 */       cell.setCellStyle(boldStyle);
/* 2047:     */       
/* 2048:2061 */       cell = row.createCell((short)i++);
/* 2049:2062 */       cell.setCellValue(RES.getString("xls.cmed_entidad"));
/* 2050:2063 */       cell.setCellStyle(boldStyle);
/* 2051:     */       
/* 2052:2065 */       cell = row.createCell((short)i++);
/* 2053:2066 */       cell.setCellValue(RES.getString("xls.cmed_pais_cod"));
/* 2054:2067 */       cell.setCellStyle(boldStyle);
/* 2055:     */       
/* 2056:2069 */       cell = row.createCell((short)i++);
/* 2057:2070 */       cell.setCellValue(RES.getString("xls.cmed_ciudad_cod"));
/* 2058:2071 */       cell.setCellStyle(boldStyle);
/* 2059:     */       
/* 2060:2073 */       cell = row.createCell((short)i++);
/* 2061:2074 */       cell.setCellValue(RES.getString("xls.cmed_indpais"));
/* 2062:2075 */       cell.setCellStyle(boldStyle);
/* 2063:     */       
/* 2064:2077 */       cell = row.createCell((short)i++);
/* 2065:2078 */       cell.setCellValue(RES.getString("xls.cmed_indciudad"));
/* 2066:2079 */       cell.setCellStyle(boldStyle);
/* 2067:     */       
/* 2068:2081 */       cell = row.createCell((short)i++);
/* 2069:2082 */       cell.setCellValue(RES.getString("xls.cmed_telefono"));
/* 2070:2083 */       cell.setCellStyle(boldStyle);
/* 2071:     */       
/* 2072:2085 */       cell = row.createCell((short)i++);
/* 2073:2086 */       cell.setCellValue(RES.getString("xls.cmed_email"));
/* 2074:2087 */       cell.setCellStyle(boldStyle);
/* 2075:     */       
/* 2076:2089 */       int y = 0;
/* 2077:     */       
/* 2078:2091 */       DatosPersonales datosPersonales = datosPersonalesDAO.retrive(usuarioFamily.getUsuf_cod());
/* 2079:2092 */       MedicinaCompleto medicinaCompleto = medicinaCompletoDAO.retrieve(usuarioFamily.getUsuf_cod(), datosPersonales.getDatp_sexo());
/* 2080:     */       
/* 2081:2094 */       Iterator iterator = medicinaCompleto.getControlesAnteriores().iterator();
/* 2082:2095 */       while (iterator.hasNext())
/* 2083:     */       {
/* 2084:2096 */         ControlMedico controlMedico = (ControlMedico)iterator.next();
/* 2085:     */         
/* 2086:2098 */         Paises paises = paisDAO.retrive(controlMedico.getCmed_pais_cod());
/* 2087:2099 */         Ciudades ciudades = ciudadDAO.retrive(controlMedico.getCmed_pais_cod(), controlMedico.getCmed_ciudad_cod());
/* 2088:     */         
/* 2089:2101 */         row = sheet.createRow(x++);
/* 2090:     */         
/* 2091:2103 */         cell = row.createCell((short)y++);
/* 2092:2104 */         cell.setCellValue(controlMedico.getCmed_destratamiento());
/* 2093:     */         
/* 2094:2106 */         cell = row.createCell((short)y++);
/* 2095:2107 */         cell.setCellValue(ManejoFechas.FormateoFecha(controlMedico.getCmed_feccontrol().toString()));
/* 2096:     */         
/* 2097:2109 */         cell = row.createCell((short)y++);
/* 2098:2110 */         cell.setCellValue(controlMedico.getCmed_nommedico());
/* 2099:     */         
/* 2100:2112 */         cell = row.createCell((short)y++);
/* 2101:2113 */         cell.setCellValue(controlMedico.getCmed_apemedico());
/* 2102:     */         
/* 2103:2115 */         cell = row.createCell((short)y++);
/* 2104:2116 */         cell.setCellValue(controlMedico.getCmed_direccion());
/* 2105:     */         
/* 2106:2118 */         cell = row.createCell((short)y++);
/* 2107:2119 */         cell.setCellValue(controlMedico.getCmed_entidad());
/* 2108:     */         
/* 2109:2121 */         cell = row.createCell((short)y++);
/* 2110:2122 */         cell.setCellValue(paises.getPais_des());
/* 2111:     */         
/* 2112:2124 */         cell = row.createCell((short)y++);
/* 2113:2125 */         cell.setCellValue(ciudades.getCiu_des());
/* 2114:     */         
/* 2115:2127 */         cell = row.createCell((short)y++);
/* 2116:2128 */         cell.setCellValue(controlMedico.getCmed_indpais().toString());
/* 2117:     */         
/* 2118:2130 */         cell = row.createCell((short)y++);
/* 2119:2131 */         cell.setCellValue(controlMedico.getCmed_indciudad().toString());
/* 2120:     */         
/* 2121:2133 */         cell = row.createCell((short)y++);
/* 2122:2134 */         cell.setCellValue(controlMedico.getCmed_telefono());
/* 2123:     */         
/* 2124:2136 */         cell = row.createCell((short)y++);
/* 2125:2137 */         cell.setCellValue(controlMedico.getCmed_email());
/* 2126:     */         
/* 2127:2139 */         y = 0;
/* 2128:     */       }
/* 2129:2142 */       x++;
/* 2130:2143 */       i = 0;
/* 2131:2144 */       row = sheet.createRow(x++);
/* 2132:2145 */       cell = row.createCell((short)i++);
/* 2133:2146 */       cell.setCellValue(RES.getString("838"));
/* 2134:2147 */       cell.setCellStyle(boldStyle);
/* 2135:     */       
/* 2136:2149 */       i = 0;
/* 2137:2150 */       row = sheet.createRow(x++);
/* 2138:2151 */       cell = row.createCell((short)i++);
/* 2139:2152 */       cell.setCellValue(RES.getString("xls.cmed_destratamiento"));
/* 2140:2153 */       cell.setCellStyle(boldStyle);
/* 2141:     */       
/* 2142:2155 */       cell = row.createCell((short)i++);
/* 2143:2156 */       cell.setCellValue(RES.getString("xls.cmed_feccontrol"));
/* 2144:2157 */       cell.setCellStyle(boldStyle);
/* 2145:     */       
/* 2146:2159 */       cell = row.createCell((short)i++);
/* 2147:2160 */       cell.setCellValue(RES.getString("xls.cmed_hora"));
/* 2148:2161 */       cell.setCellStyle(boldStyle);
/* 2149:     */       
/* 2150:2163 */       cell = row.createCell((short)i++);
/* 2151:2164 */       cell.setCellValue(RES.getString("xls.cmed_nommedico"));
/* 2152:2165 */       cell.setCellStyle(boldStyle);
/* 2153:     */       
/* 2154:2167 */       cell = row.createCell((short)i++);
/* 2155:2168 */       cell.setCellValue(RES.getString("xls.cmed_apemedico"));
/* 2156:2169 */       cell.setCellStyle(boldStyle);
/* 2157:     */       
/* 2158:2171 */       cell = row.createCell((short)i++);
/* 2159:2172 */       cell.setCellValue(RES.getString("xls.cmed_direccion"));
/* 2160:2173 */       cell.setCellStyle(boldStyle);
/* 2161:     */       
/* 2162:2175 */       cell = row.createCell((short)i++);
/* 2163:2176 */       cell.setCellValue(RES.getString("xls.cmed_entidad"));
/* 2164:2177 */       cell.setCellStyle(boldStyle);
/* 2165:     */       
/* 2166:2179 */       cell = row.createCell((short)i++);
/* 2167:2180 */       cell.setCellValue(RES.getString("xls.cmed_pais_cod"));
/* 2168:2181 */       cell.setCellStyle(boldStyle);
/* 2169:     */       
/* 2170:2183 */       cell = row.createCell((short)i++);
/* 2171:2184 */       cell.setCellValue(RES.getString("xls.cmed_ciudad_cod"));
/* 2172:2185 */       cell.setCellStyle(boldStyle);
/* 2173:     */       
/* 2174:2187 */       cell = row.createCell((short)i++);
/* 2175:2188 */       cell.setCellValue(RES.getString("xls.cmed_indpais"));
/* 2176:2189 */       cell.setCellStyle(boldStyle);
/* 2177:     */       
/* 2178:2191 */       cell = row.createCell((short)i++);
/* 2179:2192 */       cell.setCellValue(RES.getString("xls.cmed_indciudad"));
/* 2180:2193 */       cell.setCellStyle(boldStyle);
/* 2181:     */       
/* 2182:2195 */       cell = row.createCell((short)i++);
/* 2183:2196 */       cell.setCellValue(RES.getString("xls.cmed_telefono"));
/* 2184:2197 */       cell.setCellStyle(boldStyle);
/* 2185:     */       
/* 2186:2199 */       cell = row.createCell((short)i++);
/* 2187:2200 */       cell.setCellValue(RES.getString("xls.cmed_email"));
/* 2188:2201 */       cell.setCellStyle(boldStyle);
/* 2189:     */       
/* 2190:2203 */       iterator = medicinaCompleto.getControlesProximos().iterator();
/* 2191:2204 */       while (iterator.hasNext())
/* 2192:     */       {
/* 2193:2205 */         ControlMedico controlMedico = (ControlMedico)iterator.next();
/* 2194:     */         
/* 2195:2207 */         Paises paises = paisDAO.retrive(controlMedico.getCmed_pais_cod());
/* 2196:2208 */         Ciudades ciudades = ciudadDAO.retrive(controlMedico.getCmed_pais_cod(), controlMedico.getCmed_ciudad_cod());
/* 2197:     */         
/* 2198:2210 */         row = sheet.createRow(x++);
/* 2199:     */         
/* 2200:2212 */         cell = row.createCell((short)y++);
/* 2201:2213 */         cell.setCellValue(controlMedico.getCmed_destratamiento());
/* 2202:     */         
/* 2203:2215 */         cell = row.createCell((short)y++);
/* 2204:2216 */         cell.setCellValue(ManejoFechas.FormateoFecha(controlMedico.getCmed_feccontrol().toString()));
/* 2205:     */         
/* 2206:2218 */         cell = row.createCell((short)y++);
/* 2207:2219 */         cell.setCellValue(ManejoFechas.FormateoHoraAMPMReportes(controlMedico.getCmed_hora().toString()));
/* 2208:     */         
/* 2209:2221 */         cell = row.createCell((short)y++);
/* 2210:2222 */         cell.setCellValue(controlMedico.getCmed_nommedico());
/* 2211:     */         
/* 2212:2224 */         cell = row.createCell((short)y++);
/* 2213:2225 */         cell.setCellValue(controlMedico.getCmed_apemedico());
/* 2214:     */         
/* 2215:2227 */         cell = row.createCell((short)y++);
/* 2216:2228 */         cell.setCellValue(controlMedico.getCmed_direccion());
/* 2217:     */         
/* 2218:2230 */         cell = row.createCell((short)y++);
/* 2219:2231 */         cell.setCellValue(controlMedico.getCmed_entidad());
/* 2220:     */         
/* 2221:2233 */         cell = row.createCell((short)y++);
/* 2222:2234 */         cell.setCellValue(paises.getPais_des());
/* 2223:     */         
/* 2224:2236 */         cell = row.createCell((short)y++);
/* 2225:2237 */         cell.setCellValue(ciudades.getCiu_des());
/* 2226:     */         
/* 2227:2239 */         cell = row.createCell((short)y++);
/* 2228:2240 */         cell.setCellValue(controlMedico.getCmed_indpais().toString());
/* 2229:     */         
/* 2230:2242 */         cell = row.createCell((short)y++);
/* 2231:2243 */         cell.setCellValue(controlMedico.getCmed_indciudad().toString());
/* 2232:     */         
/* 2233:2245 */         cell = row.createCell((short)y++);
/* 2234:2246 */         cell.setCellValue(controlMedico.getCmed_telefono());
/* 2235:     */         
/* 2236:2248 */         cell = row.createCell((short)y++);
/* 2237:2249 */         cell.setCellValue(controlMedico.getCmed_email());
/* 2238:     */         
/* 2239:2251 */         y = 0;
/* 2240:     */       }
/* 2241:     */     }
/* 2242:     */     catch (Exception e)
/* 2243:     */     {
/* 2244:2255 */       throw e;
/* 2245:     */     }
/* 2246:     */   }
/* 2247:     */   
/* 2248:     */   public static void generarDatosVacunas(String nombreHoja, String idioma, int servidor)
/* 2249:     */     throws Exception
/* 2250:     */   {
/* 2251:     */     try
/* 2252:     */     {
/* 2253:2267 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/* 2254:2268 */       HSSFFont boldFont = wb.createFont();
/* 2255:2269 */       boldFont.setBoldweight((short)700);
/* 2256:2270 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/* 2257:2271 */       boldStyle.setFont(boldFont);
/* 2258:     */       
/* 2259:2273 */       VacunasUsuarioDAO vacunasUsuarioDAO = new VacunasUsuarioDAO();
/* 2260:2274 */       vacunasUsuarioDAO.setServerNumber(servidor);
/* 2261:2275 */       VacunasDAO vacunasDAO = new VacunasDAO();
/* 2262:2276 */       vacunasDAO.setServerNumber(servidor);
/* 2263:2277 */       vacunasDAO.setIdioma(idioma);
/* 2264:     */       
/* 2265:2279 */       HSSFRow row = null;
/* 2266:2280 */       HSSFCell cell = null;
/* 2267:     */       
/* 2268:2282 */       row = sheet.createRow(0);
/* 2269:     */       
/* 2270:2284 */       int i = 0;
/* 2271:     */       
/* 2272:2286 */       cell = row.createCell((short)i++);
/* 2273:2287 */       cell.setCellValue(RES.getString("xls.uvac_des"));
/* 2274:2288 */       cell.setCellStyle(boldStyle);
/* 2275:     */       
/* 2276:2290 */       cell = row.createCell((short)i++);
/* 2277:2291 */       cell.setCellValue(RES.getString("xls.uvac_edad_mes1"));
/* 2278:2292 */       cell.setCellStyle(boldStyle);
/* 2279:     */       
/* 2280:2294 */       cell = row.createCell((short)i++);
/* 2281:2295 */       cell.setCellValue(RES.getString("xls.uvac_edad_mes2"));
/* 2282:2296 */       cell.setCellStyle(boldStyle);
/* 2283:     */       
/* 2284:2298 */       cell = row.createCell((short)i++);
/* 2285:2299 */       cell.setCellValue(RES.getString("xls.uvac_edad_mes3"));
/* 2286:2300 */       cell.setCellStyle(boldStyle);
/* 2287:     */       
/* 2288:2302 */       cell = row.createCell((short)i++);
/* 2289:2303 */       cell.setCellValue(RES.getString("xls.uvac_edad_mes4"));
/* 2290:2304 */       cell.setCellStyle(boldStyle);
/* 2291:     */       
/* 2292:2306 */       cell = row.createCell((short)i++);
/* 2293:2307 */       cell.setCellValue(RES.getString("xls.uvac_edad_mes5"));
/* 2294:2308 */       cell.setCellStyle(boldStyle);
/* 2295:     */       
/* 2296:2310 */       cell = row.createCell((short)i++);
/* 2297:2311 */       cell.setCellValue(RES.getString("xls.uvac_edad_mes6"));
/* 2298:2312 */       cell.setCellStyle(boldStyle);
/* 2299:     */       
/* 2300:2314 */       cell = row.createCell((short)i++);
/* 2301:2315 */       cell.setCellValue(RES.getString("xls.uvac_edad_mes7"));
/* 2302:2316 */       cell.setCellStyle(boldStyle);
/* 2303:     */       
/* 2304:2318 */       cell = row.createCell((short)i++);
/* 2305:2319 */       cell.setCellValue(RES.getString("xls.uvac_edad_mes8"));
/* 2306:2320 */       cell.setCellStyle(boldStyle);
/* 2307:     */       
/* 2308:2322 */       cell = row.createCell((short)i++);
/* 2309:2323 */       cell.setCellValue(RES.getString("xls.uvac_edad_mes9"));
/* 2310:2324 */       cell.setCellStyle(boldStyle);
/* 2311:     */       
/* 2312:2326 */       cell = row.createCell((short)i++);
/* 2313:2327 */       cell.setCellValue(RES.getString("xls.uvac_edad_mes10"));
/* 2314:2328 */       cell.setCellStyle(boldStyle);
/* 2315:     */       
/* 2316:2330 */       cell = row.createCell((short)i++);
/* 2317:2331 */       cell.setCellValue(RES.getString("xls.uvac_edad_mes11"));
/* 2318:2332 */       cell.setCellStyle(boldStyle);
/* 2319:     */       
/* 2320:2334 */       cell = row.createCell((short)i++);
/* 2321:2335 */       cell.setCellValue(RES.getString("xls.uvac_edad_mes12"));
/* 2322:2336 */       cell.setCellStyle(boldStyle);
/* 2323:     */       
/* 2324:2338 */       cell = row.createCell((short)i++);
/* 2325:2339 */       cell.setCellValue(RES.getString("xls.uvac_edad_mes13"));
/* 2326:2340 */       cell.setCellStyle(boldStyle);
/* 2327:     */       
/* 2328:2342 */       cell = row.createCell((short)i++);
/* 2329:2343 */       cell.setCellValue(RES.getString("xls.uvac_edad_mes14"));
/* 2330:2344 */       cell.setCellStyle(boldStyle);
/* 2331:     */       
/* 2332:2346 */       cell = row.createCell((short)i++);
/* 2333:2347 */       cell.setCellValue(RES.getString("xls.uvac_edad_mes15"));
/* 2334:2348 */       cell.setCellStyle(boldStyle);
/* 2335:     */       
/* 2336:2350 */       cell = row.createCell((short)i++);
/* 2337:2351 */       cell.setCellValue(RES.getString("xls.uvac_edad_mes16"));
/* 2338:2352 */       cell.setCellStyle(boldStyle);
/* 2339:     */       
/* 2340:2354 */       cell = row.createCell((short)i++);
/* 2341:2355 */       cell.setCellValue(RES.getString("xls.uvac_edad_mes17"));
/* 2342:2356 */       cell.setCellStyle(boldStyle);
/* 2343:     */       
/* 2344:2358 */       cell = row.createCell((short)i++);
/* 2345:2359 */       cell.setCellValue(RES.getString("xls.uvac_edad_mes18"));
/* 2346:2360 */       cell.setCellStyle(boldStyle);
/* 2347:     */       
/* 2348:2362 */       cell = row.createCell((short)i++);
/* 2349:2363 */       cell.setCellValue(RES.getString("xls.uvac_edad_mes19"));
/* 2350:2364 */       cell.setCellStyle(boldStyle);
/* 2351:     */       
/* 2352:2366 */       cell = row.createCell((short)i++);
/* 2353:2367 */       cell.setCellValue(RES.getString("xls.uvac_edad_mes20"));
/* 2354:2368 */       cell.setCellStyle(boldStyle);
/* 2355:     */       
/* 2356:2370 */       cell = row.createCell((short)i++);
/* 2357:2371 */       cell.setCellValue(RES.getString("xls.uvac_edad_mes21"));
/* 2358:2372 */       cell.setCellStyle(boldStyle);
/* 2359:     */       
/* 2360:2374 */       cell = row.createCell((short)i++);
/* 2361:2375 */       cell.setCellValue(RES.getString("xls.uvac_edad_mes22"));
/* 2362:2376 */       cell.setCellStyle(boldStyle);
/* 2363:     */       
/* 2364:2378 */       cell = row.createCell((short)i++);
/* 2365:2379 */       cell.setCellValue(RES.getString("xls.uvac_edad_mes23"));
/* 2366:2380 */       cell.setCellStyle(boldStyle);
/* 2367:     */       
/* 2368:2382 */       cell = row.createCell((short)i++);
/* 2369:2383 */       cell.setCellValue(RES.getString("xls.uvac_edad_mes24"));
/* 2370:2384 */       cell.setCellStyle(boldStyle);
/* 2371:     */       
/* 2372:2386 */       cell = row.createCell((short)i++);
/* 2373:2387 */       cell.setCellValue(RES.getString("xls.uvac_edad_anno3"));
/* 2374:2388 */       cell.setCellStyle(boldStyle);
/* 2375:     */       
/* 2376:2390 */       cell = row.createCell((short)i++);
/* 2377:2391 */       cell.setCellValue(RES.getString("xls.uvac_edad_anno4"));
/* 2378:2392 */       cell.setCellStyle(boldStyle);
/* 2379:     */       
/* 2380:2394 */       cell = row.createCell((short)i++);
/* 2381:2395 */       cell.setCellValue(RES.getString("xls.uvac_edad_anno5"));
/* 2382:2396 */       cell.setCellStyle(boldStyle);
/* 2383:     */       
/* 2384:2398 */       cell = row.createCell((short)i++);
/* 2385:2399 */       cell.setCellValue(RES.getString("xls.uvac_edad_anno6"));
/* 2386:2400 */       cell.setCellStyle(boldStyle);
/* 2387:     */       
/* 2388:2402 */       cell = row.createCell((short)i++);
/* 2389:2403 */       cell.setCellValue(RES.getString("xls.uvac_edad_anno7"));
/* 2390:2404 */       cell.setCellStyle(boldStyle);
/* 2391:     */       
/* 2392:2406 */       cell = row.createCell((short)i++);
/* 2393:2407 */       cell.setCellValue(RES.getString("xls.uvac_edad_anno8"));
/* 2394:2408 */       cell.setCellStyle(boldStyle);
/* 2395:     */       
/* 2396:2410 */       cell = row.createCell((short)i++);
/* 2397:2411 */       cell.setCellValue(RES.getString("xls.uvac_edad_anno9"));
/* 2398:2412 */       cell.setCellStyle(boldStyle);
/* 2399:     */       
/* 2400:2414 */       cell = row.createCell((short)i++);
/* 2401:2415 */       cell.setCellValue(RES.getString("xls.uvac_edad_anno10"));
/* 2402:2416 */       cell.setCellStyle(boldStyle);
/* 2403:     */       
/* 2404:2418 */       cell = row.createCell((short)i++);
/* 2405:2419 */       cell.setCellValue(RES.getString("xls.uvac_edad_anno11"));
/* 2406:2420 */       cell.setCellStyle(boldStyle);
/* 2407:     */       
/* 2408:2422 */       cell = row.createCell((short)i++);
/* 2409:2423 */       cell.setCellValue(RES.getString("xls.uvac_edad_anno12"));
/* 2410:2424 */       cell.setCellStyle(boldStyle);
/* 2411:     */       
/* 2412:2426 */       cell = row.createCell((short)i++);
/* 2413:2427 */       cell.setCellValue(RES.getString("xls.uvac_edad_anno13"));
/* 2414:2428 */       cell.setCellStyle(boldStyle);
/* 2415:     */       
/* 2416:2430 */       cell = row.createCell((short)i++);
/* 2417:2431 */       cell.setCellValue(RES.getString("xls.uvac_edad_anno14"));
/* 2418:2432 */       cell.setCellStyle(boldStyle);
/* 2419:     */       
/* 2420:2434 */       cell = row.createCell((short)i++);
/* 2421:2435 */       cell.setCellValue(RES.getString("xls.uvac_edad_anno15"));
/* 2422:2436 */       cell.setCellStyle(boldStyle);
/* 2423:     */       
/* 2424:2438 */       cell = row.createCell((short)i++);
/* 2425:2439 */       cell.setCellValue(RES.getString("xls.uvac_edad_anno16"));
/* 2426:2440 */       cell.setCellStyle(boldStyle);
/* 2427:     */       
/* 2428:2442 */       cell = row.createCell((short)i++);
/* 2429:2443 */       cell.setCellValue(RES.getString("xls.uvac_edad_anno17"));
/* 2430:2444 */       cell.setCellStyle(boldStyle);
/* 2431:     */       
/* 2432:2446 */       cell = row.createCell((short)i++);
/* 2433:2447 */       cell.setCellValue(RES.getString("xls.uvac_edad_anno18"));
/* 2434:2448 */       cell.setCellStyle(boldStyle);
/* 2435:     */       
/* 2436:2450 */       cell = row.createCell((short)i++);
/* 2437:2451 */       cell.setCellValue(RES.getString("xls.uvac_edad_anno20"));
/* 2438:2452 */       cell.setCellStyle(boldStyle);
/* 2439:     */       
/* 2440:2454 */       cell = row.createCell((short)i++);
/* 2441:2455 */       cell.setCellValue(RES.getString("xls.uvac_edad_anno30"));
/* 2442:2456 */       cell.setCellStyle(boldStyle);
/* 2443:     */       
/* 2444:2458 */       cell = row.createCell((short)i++);
/* 2445:2459 */       cell.setCellValue(RES.getString("xls.uvac_edad_anno40"));
/* 2446:2460 */       cell.setCellStyle(boldStyle);
/* 2447:     */       
/* 2448:2462 */       cell = row.createCell((short)i++);
/* 2449:2463 */       cell.setCellValue(RES.getString("xls.uvac_edad_anno50"));
/* 2450:2464 */       cell.setCellStyle(boldStyle);
/* 2451:     */       
/* 2452:2466 */       cell = row.createCell((short)i++);
/* 2453:2467 */       cell.setCellValue(RES.getString("xls.uvac_edad_anno60"));
/* 2454:2468 */       cell.setCellStyle(boldStyle);
/* 2455:     */       
/* 2456:2470 */       cell = row.createCell((short)i++);
/* 2457:2471 */       cell.setCellValue(RES.getString("xls.uvac_edad_anno70"));
/* 2458:2472 */       cell.setCellStyle(boldStyle);
/* 2459:     */       
/* 2460:2474 */       cell = row.createCell((short)i++);
/* 2461:2475 */       cell.setCellValue(RES.getString("xls.uvac_edad_anno80"));
/* 2462:2476 */       cell.setCellStyle(boldStyle);
/* 2463:     */       
/* 2464:2478 */       cell = row.createCell((short)i++);
/* 2465:2479 */       cell.setCellValue(RES.getString("xls.uvac_edad_anno90"));
/* 2466:2480 */       cell.setCellStyle(boldStyle);
/* 2467:     */       
/* 2468:2482 */       int x = 1;
/* 2469:2483 */       int y = 0;
/* 2470:     */       
/* 2471:2485 */       List vacunas = vacunasUsuarioDAO.list(usuarioFamily.getUsuf_cod());
/* 2472:     */       
/* 2473:2487 */       Iterator iterator = vacunas.iterator();
/* 2474:2488 */       while (iterator.hasNext())
/* 2475:     */       {
/* 2476:2489 */         VacunasUsuario vacunasUsuario = (VacunasUsuario)iterator.next();
/* 2477:     */         
/* 2478:2491 */         row = sheet.createRow(x++);
/* 2479:     */         
/* 2480:2493 */         cell = row.createCell((short)y++);
/* 2481:2494 */         cell.setCellValue(vacunasUsuario.getVacu_vac_cod().equals(IConstantes.CODIGO_NO_EXISTE) ? vacunasUsuario.getVacu_des() : vacunasDAO.retrieve(vacunasUsuario.getVacu_vac_cod()).getVac_des());
/* 2482:     */         
/* 2483:2496 */         cell = row.createCell((short)y++);
/* 2484:2497 */         cell.setCellValue(vacunasUsuario.getVacu_edad_mes1().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2485:     */         
/* 2486:2499 */         cell = row.createCell((short)y++);
/* 2487:2500 */         cell.setCellValue(vacunasUsuario.getVacu_edad_mes2().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2488:     */         
/* 2489:2502 */         cell = row.createCell((short)y++);
/* 2490:2503 */         cell.setCellValue(vacunasUsuario.getVacu_edad_mes3().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2491:     */         
/* 2492:2505 */         cell = row.createCell((short)y++);
/* 2493:2506 */         cell.setCellValue(vacunasUsuario.getVacu_edad_mes4().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2494:     */         
/* 2495:2508 */         cell = row.createCell((short)y++);
/* 2496:2509 */         cell.setCellValue(vacunasUsuario.getVacu_edad_mes5().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2497:     */         
/* 2498:2511 */         cell = row.createCell((short)y++);
/* 2499:2512 */         cell.setCellValue(vacunasUsuario.getVacu_edad_mes6().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2500:     */         
/* 2501:2514 */         cell = row.createCell((short)y++);
/* 2502:2515 */         cell.setCellValue(vacunasUsuario.getVacu_edad_mes7().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2503:     */         
/* 2504:2517 */         cell = row.createCell((short)y++);
/* 2505:2518 */         cell.setCellValue(vacunasUsuario.getVacu_edad_mes8().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2506:     */         
/* 2507:2520 */         cell = row.createCell((short)y++);
/* 2508:2521 */         cell.setCellValue(vacunasUsuario.getVacu_edad_mes9().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2509:     */         
/* 2510:2523 */         cell = row.createCell((short)y++);
/* 2511:2524 */         cell.setCellValue(vacunasUsuario.getVacu_edad_mes10().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2512:     */         
/* 2513:2526 */         cell = row.createCell((short)y++);
/* 2514:2527 */         cell.setCellValue(vacunasUsuario.getVacu_edad_mes11().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2515:     */         
/* 2516:2529 */         cell = row.createCell((short)y++);
/* 2517:2530 */         cell.setCellValue(vacunasUsuario.getVacu_edad_mes12().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2518:     */         
/* 2519:2532 */         cell = row.createCell((short)y++);
/* 2520:2533 */         cell.setCellValue(vacunasUsuario.getVacu_edad_mes13().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2521:     */         
/* 2522:2535 */         cell = row.createCell((short)y++);
/* 2523:2536 */         cell.setCellValue(vacunasUsuario.getVacu_edad_mes14().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2524:     */         
/* 2525:2538 */         cell = row.createCell((short)y++);
/* 2526:2539 */         cell.setCellValue(vacunasUsuario.getVacu_edad_mes15().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2527:     */         
/* 2528:2541 */         cell = row.createCell((short)y++);
/* 2529:2542 */         cell.setCellValue(vacunasUsuario.getVacu_edad_mes16().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2530:     */         
/* 2531:2544 */         cell = row.createCell((short)y++);
/* 2532:2545 */         cell.setCellValue(vacunasUsuario.getVacu_edad_mes17().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2533:     */         
/* 2534:2547 */         cell = row.createCell((short)y++);
/* 2535:2548 */         cell.setCellValue(vacunasUsuario.getVacu_edad_mes18().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2536:     */         
/* 2537:2550 */         cell = row.createCell((short)y++);
/* 2538:2551 */         cell.setCellValue(vacunasUsuario.getVacu_edad_mes19().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2539:     */         
/* 2540:2553 */         cell = row.createCell((short)y++);
/* 2541:2554 */         cell.setCellValue(vacunasUsuario.getVacu_edad_mes20().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2542:     */         
/* 2543:2556 */         cell = row.createCell((short)y++);
/* 2544:2557 */         cell.setCellValue(vacunasUsuario.getVacu_edad_mes21().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2545:     */         
/* 2546:2559 */         cell = row.createCell((short)y++);
/* 2547:2560 */         cell.setCellValue(vacunasUsuario.getVacu_edad_mes22().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2548:     */         
/* 2549:2562 */         cell = row.createCell((short)y++);
/* 2550:2563 */         cell.setCellValue(vacunasUsuario.getVacu_edad_mes23().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2551:     */         
/* 2552:2565 */         cell = row.createCell((short)y++);
/* 2553:2566 */         cell.setCellValue(vacunasUsuario.getVacu_edad_mes24().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2554:     */         
/* 2555:2568 */         cell = row.createCell((short)y++);
/* 2556:2569 */         cell.setCellValue(vacunasUsuario.getVacu_edad_anno3().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2557:     */         
/* 2558:2571 */         cell = row.createCell((short)y++);
/* 2559:2572 */         cell.setCellValue(vacunasUsuario.getVacu_edad_anno4().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2560:     */         
/* 2561:2574 */         cell = row.createCell((short)y++);
/* 2562:2575 */         cell.setCellValue(vacunasUsuario.getVacu_edad_anno5().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2563:     */         
/* 2564:2577 */         cell = row.createCell((short)y++);
/* 2565:2578 */         cell.setCellValue(vacunasUsuario.getVacu_edad_anno6().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2566:     */         
/* 2567:2580 */         cell = row.createCell((short)y++);
/* 2568:2581 */         cell.setCellValue(vacunasUsuario.getVacu_edad_anno7().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2569:     */         
/* 2570:2583 */         cell = row.createCell((short)y++);
/* 2571:2584 */         cell.setCellValue(vacunasUsuario.getVacu_edad_anno8().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2572:     */         
/* 2573:2586 */         cell = row.createCell((short)y++);
/* 2574:2587 */         cell.setCellValue(vacunasUsuario.getVacu_edad_anno9().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2575:     */         
/* 2576:2589 */         cell = row.createCell((short)y++);
/* 2577:2590 */         cell.setCellValue(vacunasUsuario.getVacu_edad_anno10().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2578:     */         
/* 2579:2592 */         cell = row.createCell((short)y++);
/* 2580:2593 */         cell.setCellValue(vacunasUsuario.getVacu_edad_anno11().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2581:     */         
/* 2582:2595 */         cell = row.createCell((short)y++);
/* 2583:2596 */         cell.setCellValue(vacunasUsuario.getVacu_edad_anno12().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2584:     */         
/* 2585:2598 */         cell = row.createCell((short)y++);
/* 2586:2599 */         cell.setCellValue(vacunasUsuario.getVacu_edad_anno13().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2587:     */         
/* 2588:2601 */         cell = row.createCell((short)y++);
/* 2589:2602 */         cell.setCellValue(vacunasUsuario.getVacu_edad_anno14().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2590:     */         
/* 2591:2604 */         cell = row.createCell((short)y++);
/* 2592:2605 */         cell.setCellValue(vacunasUsuario.getVacu_edad_anno15().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2593:     */         
/* 2594:2607 */         cell = row.createCell((short)y++);
/* 2595:2608 */         cell.setCellValue(vacunasUsuario.getVacu_edad_anno16().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2596:     */         
/* 2597:2610 */         cell = row.createCell((short)y++);
/* 2598:2611 */         cell.setCellValue(vacunasUsuario.getVacu_edad_anno17().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2599:     */         
/* 2600:2613 */         cell = row.createCell((short)y++);
/* 2601:2614 */         cell.setCellValue(vacunasUsuario.getVacu_edad_anno18().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2602:     */         
/* 2603:2616 */         cell = row.createCell((short)y++);
/* 2604:2617 */         cell.setCellValue(vacunasUsuario.getVacu_edad_anno20().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2605:     */         
/* 2606:2619 */         cell = row.createCell((short)y++);
/* 2607:2620 */         cell.setCellValue(vacunasUsuario.getVacu_edad_anno30().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2608:     */         
/* 2609:2622 */         cell = row.createCell((short)y++);
/* 2610:2623 */         cell.setCellValue(vacunasUsuario.getVacu_edad_anno40().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2611:     */         
/* 2612:2625 */         cell = row.createCell((short)y++);
/* 2613:2626 */         cell.setCellValue(vacunasUsuario.getVacu_edad_anno50().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2614:     */         
/* 2615:2628 */         cell = row.createCell((short)y++);
/* 2616:2629 */         cell.setCellValue(vacunasUsuario.getVacu_edad_anno60().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2617:     */         
/* 2618:2631 */         cell = row.createCell((short)y++);
/* 2619:2632 */         cell.setCellValue(vacunasUsuario.getVacu_edad_anno70().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2620:     */         
/* 2621:2634 */         cell = row.createCell((short)y++);
/* 2622:2635 */         cell.setCellValue(vacunasUsuario.getVacu_edad_anno80().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2623:     */         
/* 2624:2637 */         cell = row.createCell((short)y++);
/* 2625:2638 */         cell.setCellValue(vacunasUsuario.getVacu_edad_anno90().toString().equals("1") ? RES.getString("global.si") : RES.getString("global.no"));
/* 2626:2639 */         y = 0;
/* 2627:     */       }
/* 2628:     */     }
/* 2629:     */     catch (Exception e)
/* 2630:     */     {
/* 2631:2643 */       throw e;
/* 2632:     */     }
/* 2633:     */   }
/* 2634:     */   
/* 2635:     */   public static void generarDatosLaboratorio(String nombreHoja)
/* 2636:     */     throws Exception
/* 2637:     */   {}
/* 2638:     */   
/* 2639:     */   public static HSSFWorkbook getWb()
/* 2640:     */   {
/* 2641:2811 */     return wb;
/* 2642:     */   }
/* 2643:     */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.dao.GestorHojasCalculoFamily
 * JD-Core Version:    0.7.0.1
 */