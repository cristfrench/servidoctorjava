/*    1:     */ package com.servidoctor.sdcars.dao;
/*    2:     */ 
/*    3:     */ import com.servidoctor.parametros.dao.CiudadDAO;
/*    4:     */ import com.servidoctor.parametros.dao.GastosVehiculosAnualesDAO;
/*    5:     */ import com.servidoctor.parametros.dao.GastosVehiculosMecanicaDAO;
/*    6:     */ import com.servidoctor.parametros.dao.GastosVehiculosNoAnualesDAO;
/*    7:     */ import com.servidoctor.parametros.dao.MarcasAutosDAO;
/*    8:     */ import com.servidoctor.parametros.dao.PaisDAO;
/*    9:     */ import com.servidoctor.parametros.dao.RevisionAccionDAO;
/*   10:     */ import com.servidoctor.parametros.dao.RevisionAlternativaDAO;
/*   11:     */ import com.servidoctor.parametros.dao.RevisionesVehiculoDAO;
/*   12:     */ import com.servidoctor.parametros.dao.TipoVehiculoDAO;
/*   13:     */ import com.servidoctor.parametros.model.Ciudades;
/*   14:     */ import com.servidoctor.parametros.model.GastosVehiculosAnuales;
/*   15:     */ import com.servidoctor.parametros.model.GastosVehiculosMecanica;
/*   16:     */ import com.servidoctor.parametros.model.GastosVehiculosNoAnuales;
/*   17:     */ import com.servidoctor.parametros.model.MarcasAutos;
/*   18:     */ import com.servidoctor.parametros.model.Paises;
/*   19:     */ import com.servidoctor.parametros.model.RevisionAccion;
/*   20:     */ import com.servidoctor.parametros.model.RevisionAlternativa;
/*   21:     */ import com.servidoctor.parametros.model.RevisionesVehiculo;
/*   22:     */ import com.servidoctor.parametros.model.TipoVehiculo;
/*   23:     */ import com.servidoctor.sdcars.model.Combustible;
/*   24:     */ import com.servidoctor.sdcars.model.ControlesVehiculos;
/*   25:     */ import com.servidoctor.sdcars.model.ImpuestoVehiculo;
/*   26:     */ import com.servidoctor.sdcars.model.PropietariosVehiculos;
/*   27:     */ import com.servidoctor.sdcars.model.SegurosVehiculos;
/*   28:     */ import com.servidoctor.sdcars.model.Vehiculos;
/*   29:     */ import com.servidoctor.seguridad.model.UsuarioCar;
/*   30:     */ import com.servidoctor.util.classes.ManejoFechas;
/*   31:     */ import java.io.OutputStream;
/*   32:     */ import java.math.BigDecimal;
/*   33:     */ import java.util.Iterator;
/*   34:     */ import java.util.List;
/*   35:     */ import java.util.ResourceBundle;
/*   36:     */ import org.apache.poi.hssf.usermodel.HSSFCell;
/*   37:     */ import org.apache.poi.hssf.usermodel.HSSFCellStyle;
/*   38:     */ import org.apache.poi.hssf.usermodel.HSSFFont;
/*   39:     */ import org.apache.poi.hssf.usermodel.HSSFRow;
/*   40:     */ import org.apache.poi.hssf.usermodel.HSSFSheet;
/*   41:     */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*   42:     */ 
/*   43:     */ public class GestorHojasCalculoCars
/*   44:     */ {
/*   45:  57 */   private static final HSSFWorkbook wb = new HSSFWorkbook();
/*   46:  58 */   private static UsuarioCar usuario = null;
/*   47:  59 */   private static ResourceBundle RES = null;
/*   48:  60 */   private static OutputStream out = null;
/*   49:     */   
/*   50:     */   public static void generarHoja(String nombreHoja, UsuarioCar user, ResourceBundle res)
/*   51:     */     throws Exception
/*   52:     */   {
/*   53:     */     try
/*   54:     */     {
/*   55:  71 */       usuario = user;
/*   56:  72 */       RES = res;
/*   57:  73 */       HSSFSheet sheet = wb.createSheet(nombreHoja);
/*   58:     */       
/*   59:  75 */       sheet.setColumnWidth((short)0, (short)6000);
/*   60:  76 */       sheet.setColumnWidth((short)1, (short)6000);
/*   61:  77 */       sheet.setColumnWidth((short)2, (short)6000);
/*   62:  78 */       sheet.setColumnWidth((short)3, (short)6000);
/*   63:  79 */       sheet.setColumnWidth((short)4, (short)6000);
/*   64:  80 */       sheet.setColumnWidth((short)5, (short)6000);
/*   65:  81 */       sheet.setColumnWidth((short)6, (short)6000);
/*   66:  82 */       sheet.setColumnWidth((short)7, (short)6000);
/*   67:  83 */       sheet.setColumnWidth((short)8, (short)6000);
/*   68:  84 */       sheet.setColumnWidth((short)9, (short)6000);
/*   69:  85 */       sheet.setColumnWidth((short)10, (short)6000);
/*   70:  86 */       sheet.setColumnWidth((short)11, (short)6000);
/*   71:  87 */       sheet.setColumnWidth((short)12, (short)6000);
/*   72:  88 */       sheet.setColumnWidth((short)13, (short)6000);
/*   73:  89 */       sheet.setColumnWidth((short)14, (short)6000);
/*   74:  90 */       sheet.setColumnWidth((short)15, (short)6000);
/*   75:  91 */       sheet.setColumnWidth((short)16, (short)6000);
/*   76:  92 */       sheet.setColumnWidth((short)17, (short)6000);
/*   77:  93 */       sheet.setColumnWidth((short)18, (short)6000);
/*   78:  94 */       sheet.setColumnWidth((short)19, (short)6000);
/*   79:  95 */       sheet.setColumnWidth((short)20, (short)6000);
/*   80:  96 */       sheet.setColumnWidth((short)21, (short)6000);
/*   81:  97 */       sheet.setColumnWidth((short)22, (short)6000);
/*   82:  98 */       sheet.setColumnWidth((short)23, (short)6000);
/*   83:  99 */       sheet.setColumnWidth((short)24, (short)6000);
/*   84: 100 */       sheet.setColumnWidth((short)25, (short)6000);
/*   85: 101 */       sheet.setColumnWidth((short)26, (short)6000);
/*   86: 102 */       sheet.setColumnWidth((short)27, (short)6000);
/*   87: 103 */       sheet.setColumnWidth((short)28, (short)6000);
/*   88: 104 */       sheet.setColumnWidth((short)29, (short)6000);
/*   89:     */     }
/*   90:     */     catch (Exception e)
/*   91:     */     {
/*   92: 107 */       throw e;
/*   93:     */     }
/*   94:     */   }
/*   95:     */   
/*   96:     */   public static void generarDatosInfobasica(String nombreHoja, String idioma, int servidor)
/*   97:     */     throws Exception
/*   98:     */   {
/*   99:     */     try
/*  100:     */     {
/*  101: 119 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/*  102: 120 */       HSSFFont boldFont = wb.createFont();
/*  103: 121 */       boldFont.setBoldweight((short)700);
/*  104: 122 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/*  105: 123 */       boldStyle.setFont(boldFont);
/*  106:     */       
/*  107: 125 */       VehiculosDAO vehiculosDAO = new VehiculosDAO();
/*  108: 126 */       vehiculosDAO.setServerNumber(servidor);
/*  109: 127 */       PropietariosVehiculosDAO propietariosVehiculosDAO = new PropietariosVehiculosDAO();
/*  110: 128 */       propietariosVehiculosDAO.setServerNumber(servidor);
/*  111: 129 */       MarcasAutosDAO marcasAutoDAO = new MarcasAutosDAO();
/*  112: 130 */       marcasAutoDAO.setServerNumber(servidor);
/*  113: 131 */       PaisDAO paisDAO = new PaisDAO();
/*  114: 132 */       CiudadDAO ciudadDAO = new CiudadDAO();
/*  115: 133 */       ciudadDAO.setServerNumber(servidor);
/*  116: 134 */       TipoVehiculoDAO tipoVehiculoDAO = new TipoVehiculoDAO();
/*  117: 135 */       tipoVehiculoDAO.setServerNumber(servidor);
/*  118: 136 */       List vehiculos = vehiculosDAO.list(usuario.getUsuc_cod());
/*  119:     */       
/*  120: 138 */       HSSFRow row = null;
/*  121: 139 */       HSSFCell cell = null;
/*  122:     */       
/*  123: 141 */       row = sheet.createRow(0);
/*  124:     */       
/*  125: 143 */       cell = row.createCell((short)0);
/*  126: 144 */       cell.setCellValue(RES.getString("xls.vehi_placa"));
/*  127: 145 */       cell.setCellStyle(boldStyle);
/*  128:     */       
/*  129: 147 */       cell = row.createCell((short)1);
/*  130: 148 */       cell.setCellValue(RES.getString("xls.vehi_marca"));
/*  131: 149 */       cell.setCellStyle(boldStyle);
/*  132:     */       
/*  133: 151 */       cell = row.createCell((short)2);
/*  134: 152 */       cell.setCellValue(RES.getString("xls.vehi_tipo"));
/*  135: 153 */       cell.setCellStyle(boldStyle);
/*  136:     */       
/*  137: 155 */       cell = row.createCell((short)3);
/*  138: 156 */       cell.setCellValue(RES.getString("xls.vehi_modelo"));
/*  139: 157 */       cell.setCellStyle(boldStyle);
/*  140:     */       
/*  141: 159 */       cell = row.createCell((short)4);
/*  142: 160 */       cell.setCellValue(RES.getString("xls.vehi_feccomp"));
/*  143: 161 */       cell.setCellStyle(boldStyle);
/*  144:     */       
/*  145: 163 */       cell = row.createCell((short)5);
/*  146: 164 */       cell.setCellValue(RES.getString("xls.vehi_kmsact"));
/*  147: 165 */       cell.setCellStyle(boldStyle);
/*  148:     */       
/*  149: 167 */       cell = row.createCell((short)6);
/*  150: 168 */       cell.setCellValue(RES.getString("xls.vehi_distancia"));
/*  151: 169 */       cell.setCellStyle(boldStyle);
/*  152:     */       
/*  153: 171 */       cell = row.createCell((short)7);
/*  154: 172 */       cell.setCellValue(RES.getString("xls.pveh_nombre"));
/*  155: 173 */       cell.setCellStyle(boldStyle);
/*  156:     */       
/*  157: 175 */       cell = row.createCell((short)8);
/*  158: 176 */       cell.setCellValue(RES.getString("xls.pveh_apellido"));
/*  159: 177 */       cell.setCellStyle(boldStyle);
/*  160:     */       
/*  161: 179 */       cell = row.createCell((short)9);
/*  162: 180 */       cell.setCellValue(RES.getString("xls.pveh_pais_cod"));
/*  163: 181 */       cell.setCellStyle(boldStyle);
/*  164:     */       
/*  165: 183 */       cell = row.createCell((short)10);
/*  166: 184 */       cell.setCellValue(RES.getString("xls.pveh_ciu_cod"));
/*  167: 185 */       cell.setCellStyle(boldStyle);
/*  168:     */       
/*  169: 187 */       cell = row.createCell((short)11);
/*  170: 188 */       cell.setCellValue(RES.getString("xls.pveh_mail"));
/*  171: 189 */       cell.setCellStyle(boldStyle);
/*  172:     */       
/*  173: 191 */       cell = row.createCell((short)12);
/*  174: 192 */       cell.setCellValue(RES.getString("xls.pveh_indpais1"));
/*  175: 193 */       cell.setCellStyle(boldStyle);
/*  176:     */       
/*  177: 195 */       cell = row.createCell((short)13);
/*  178: 196 */       cell.setCellValue(RES.getString("xls.pveh_indciudad1"));
/*  179: 197 */       cell.setCellStyle(boldStyle);
/*  180:     */       
/*  181: 199 */       cell = row.createCell((short)14);
/*  182: 200 */       cell.setCellValue(RES.getString("xls.pveh_telefono1"));
/*  183: 201 */       cell.setCellStyle(boldStyle);
/*  184:     */       
/*  185: 203 */       cell = row.createCell((short)15);
/*  186: 204 */       cell.setCellValue(RES.getString("xls.pveh_indpais2"));
/*  187: 205 */       cell.setCellStyle(boldStyle);
/*  188:     */       
/*  189: 207 */       cell = row.createCell((short)16);
/*  190: 208 */       cell.setCellValue(RES.getString("xls.pveh_telefono2"));
/*  191: 209 */       cell.setCellStyle(boldStyle);
/*  192:     */       
/*  193: 211 */       int x = 1;
/*  194: 212 */       int y = 0;
/*  195:     */       
/*  196: 214 */       Iterator it = vehiculos.iterator();
/*  197:     */       do
/*  198:     */       {
/*  199: 216 */         Vehiculos vehiculo = (Vehiculos)it.next();
/*  200:     */         
/*  201: 218 */         MarcasAutos marcasAutos = marcasAutoDAO.retrive(vehiculo.getVehi_maut_cod());
/*  202: 219 */         tipoVehiculoDAO.setIdioma(idioma);
/*  203: 220 */         TipoVehiculo tipoVehiculo = tipoVehiculoDAO.retrive(vehiculo.getVehi_tveh_cod());
/*  204: 221 */         PropietariosVehiculos propietariosVehiculos = (PropietariosVehiculos)propietariosVehiculosDAO.list(vehiculo.getVehi_cod()).get(0);
/*  205: 222 */         Paises paises = paisDAO.retrive(propietariosVehiculos.getPveh_pais_cod());
/*  206: 223 */         Ciudades ciudades = ciudadDAO.retrive(propietariosVehiculos.getPveh_pais_cod(), propietariosVehiculos.getPveh_ciu_cod());
/*  207:     */         
/*  208: 225 */         row = sheet.createRow(x++);
/*  209:     */         
/*  210: 227 */         cell = row.createCell((short)y++);
/*  211: 228 */         cell.setCellValue(vehiculo.getVehi_placa());
/*  212:     */         
/*  213: 230 */         cell = row.createCell((short)y++);
/*  214: 231 */         cell.setCellValue(marcasAutos.getMaut_des());
/*  215:     */         
/*  216: 233 */         cell = row.createCell((short)y++);
/*  217: 234 */         cell.setCellValue(tipoVehiculo.getTveh_des());
/*  218:     */         
/*  219: 236 */         cell = row.createCell((short)y++);
/*  220: 237 */         cell.setCellValue(vehiculo.getVehi_modelo().doubleValue());
/*  221:     */         
/*  222: 239 */         cell = row.createCell((short)y++);
/*  223: 240 */         cell.setCellValue(ManejoFechas.FormateoFecha(vehiculo.getVehi_feccomp().toString()));
/*  224:     */         
/*  225: 242 */         cell = row.createCell((short)y++);
/*  226: 243 */         cell.setCellValue(vehiculo.getVehi_kmsact().doubleValue() * 1000.0D);
/*  227:     */         
/*  228: 245 */         cell = row.createCell((short)y++);
/*  229: 246 */         cell.setCellValue(vehiculo.getVehi_distancia());
/*  230:     */         
/*  231: 248 */         cell = row.createCell((short)y++);
/*  232: 249 */         cell.setCellValue(propietariosVehiculos.getPveh_nombre());
/*  233:     */         
/*  234: 251 */         cell = row.createCell((short)y++);
/*  235: 252 */         cell.setCellValue(propietariosVehiculos.getPveh_apellido());
/*  236:     */         
/*  237: 254 */         cell = row.createCell((short)y++);
/*  238: 255 */         cell.setCellValue(paises.getPais_des());
/*  239:     */         
/*  240: 257 */         cell = row.createCell((short)y++);
/*  241: 258 */         cell.setCellValue(ciudades.getCiu_des());
/*  242:     */         
/*  243: 260 */         cell = row.createCell((short)y++);
/*  244: 261 */         cell.setCellValue(propietariosVehiculos.getPveh_mail());
/*  245:     */         
/*  246: 263 */         cell = row.createCell((short)y++);
/*  247: 264 */         cell.setCellValue(propietariosVehiculos.getPveh_indpais1().intValue());
/*  248:     */         
/*  249: 266 */         cell = row.createCell((short)y++);
/*  250: 267 */         cell.setCellValue(propietariosVehiculos.getPveh_indciudad1().intValue());
/*  251:     */         
/*  252: 269 */         cell = row.createCell((short)y++);
/*  253: 270 */         cell.setCellValue(propietariosVehiculos.getPveh_telefono1());
/*  254:     */         
/*  255: 272 */         cell = row.createCell((short)y++);
/*  256: 273 */         cell.setCellValue(propietariosVehiculos.getPveh_indpais2().intValue());
/*  257:     */         
/*  258: 275 */         cell = row.createCell((short)y++);
/*  259: 276 */         cell.setCellValue(propietariosVehiculos.getPveh_telefono2());
/*  260:     */         
/*  261: 278 */         y = 0;
/*  262: 215 */         if (it == null) {
/*  263:     */           break;
/*  264:     */         }
/*  265: 215 */       } while (it.hasNext());
/*  266:     */     }
/*  267:     */     catch (Exception e)
/*  268:     */     {
/*  269: 282 */       throw e;
/*  270:     */     }
/*  271:     */   }
/*  272:     */   
/*  273:     */   public static void generarDatosMantenimientoActividades(String nombreHoja, String idioma, int servidor)
/*  274:     */     throws Exception
/*  275:     */   {
/*  276:     */     try
/*  277:     */     {
/*  278: 294 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/*  279: 295 */       HSSFFont boldFont = wb.createFont();
/*  280: 296 */       boldFont.setBoldweight((short)700);
/*  281: 297 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/*  282: 298 */       boldStyle.setFont(boldFont);
/*  283:     */       
/*  284: 300 */       VehiculosDAO vehiculosDAO = new VehiculosDAO();
/*  285: 301 */       vehiculosDAO.setServerNumber(servidor);
/*  286: 302 */       MarcasAutosDAO marcasAutoDAO = new MarcasAutosDAO();
/*  287: 303 */       marcasAutoDAO.setServerNumber(servidor);
/*  288: 304 */       RevisionesVehiculoDAO revisionesVehiculoDAO = new RevisionesVehiculoDAO();
/*  289: 305 */       revisionesVehiculoDAO.setServerNumber(servidor);
/*  290: 306 */       RevisionAccionDAO revisionAccionDAO = new RevisionAccionDAO();
/*  291: 307 */       revisionAccionDAO.setServerNumber(servidor);
/*  292: 308 */       RevisionAlternativaDAO revisionAlternativaDAO = new RevisionAlternativaDAO();
/*  293: 309 */       revisionAlternativaDAO.setServerNumber(servidor);
/*  294: 310 */       List vehiculos = vehiculosDAO.list(usuario.getUsuc_cod());
/*  295:     */       
/*  296: 312 */       HSSFRow row = null;
/*  297: 313 */       HSSFCell cell = null;
/*  298:     */       
/*  299: 315 */       row = sheet.createRow(0);
/*  300:     */       
/*  301: 317 */       cell = row.createCell((short)0);
/*  302: 318 */       cell.setCellValue(RES.getString("xls.vehi_placa"));
/*  303: 319 */       cell.setCellStyle(boldStyle);
/*  304:     */       
/*  305: 321 */       cell = row.createCell((short)1);
/*  306: 322 */       cell.setCellValue(RES.getString("xls.vehi_marca"));
/*  307: 323 */       cell.setCellStyle(boldStyle);
/*  308:     */       
/*  309: 325 */       cell = row.createCell((short)2);
/*  310: 326 */       cell.setCellValue(RES.getString("xls.rveh_actividad"));
/*  311: 327 */       cell.setCellStyle(boldStyle);
/*  312:     */       
/*  313: 329 */       cell = row.createCell((short)3);
/*  314: 330 */       cell.setCellValue(RES.getString("xls.rveh_acc_cod"));
/*  315: 331 */       cell.setCellStyle(boldStyle);
/*  316:     */       
/*  317: 333 */       cell = row.createCell((short)4);
/*  318: 334 */       cell.setCellValue(RES.getString("xls.rveh_alt_cod"));
/*  319: 335 */       cell.setCellStyle(boldStyle);
/*  320:     */       
/*  321: 337 */       cell = row.createCell((short)5);
/*  322: 338 */       cell.setCellValue(RES.getString("xls.rveh_cada_cdm"));
/*  323: 339 */       cell.setCellStyle(boldStyle);
/*  324:     */       
/*  325: 341 */       cell = row.createCell((short)6);
/*  326: 342 */       cell.setCellValue(RES.getString("xls.rveh_cada_cdk"));
/*  327: 343 */       cell.setCellStyle(boldStyle);
/*  328:     */       
/*  329: 345 */       cell = row.createCell((short)7);
/*  330: 346 */       cell.setCellValue(RES.getString("xls.rveh_control_fec"));
/*  331: 347 */       cell.setCellStyle(boldStyle);
/*  332:     */       
/*  333: 349 */       int x = 1;
/*  334: 350 */       int y = 0;
/*  335:     */       
/*  336: 352 */       Iterator it = vehiculos.iterator();
/*  337:     */       do
/*  338:     */       {
/*  339: 354 */         Vehiculos vehiculo = (Vehiculos)it.next();
/*  340: 355 */         MarcasAutos marcasAutos = marcasAutoDAO.retrive(vehiculo.getVehi_maut_cod());
/*  341: 356 */         List revisiones = revisionesVehiculoDAO.list(vehiculo.getVehi_cod());
/*  342:     */         
/*  343: 358 */         Iterator iterator = revisiones.iterator();
/*  344: 359 */         while ((iterator != null) && (iterator.hasNext()))
/*  345:     */         {
/*  346: 360 */           RevisionesVehiculo revisionesVehiculo = (RevisionesVehiculo)iterator.next();
/*  347: 361 */           revisionAccionDAO.setIdioma(idioma);
/*  348: 362 */           RevisionAccion revisionAccion = revisionAccionDAO.retrive(revisionesVehiculo.getRveh_acc_cod());
/*  349: 363 */           revisionAlternativaDAO.setIdioma(idioma);
/*  350: 364 */           RevisionAlternativa revisionAlternativa = revisionAlternativaDAO.retrive(revisionesVehiculo.getRveh_alt_cod());
/*  351:     */           
/*  352: 366 */           row = sheet.createRow(x++);
/*  353: 368 */           if (x == 2)
/*  354:     */           {
/*  355: 369 */             cell = row.createCell((short)y++);
/*  356: 370 */             cell.setCellValue(vehiculo.getVehi_placa());
/*  357:     */             
/*  358: 372 */             cell = row.createCell((short)y++);
/*  359: 373 */             cell.setCellValue(marcasAutos.getMaut_des());
/*  360:     */           }
/*  361:     */           else
/*  362:     */           {
/*  363: 375 */             y += 2;
/*  364:     */           }
/*  365: 378 */           cell = row.createCell((short)y++);
/*  366: 379 */           cell.setCellValue(revisionesVehiculo.getRveh_actividad());
/*  367:     */           
/*  368: 381 */           cell = row.createCell((short)y++);
/*  369: 382 */           cell.setCellValue(revisionAccion.getRacc_des());
/*  370:     */           
/*  371: 384 */           cell = row.createCell((short)y++);
/*  372: 385 */           cell.setCellValue(revisionAlternativa.getRalt_des());
/*  373:     */           
/*  374: 387 */           cell = row.createCell((short)y++);
/*  375: 388 */           cell.setCellValue(Double.parseDouble(revisionesVehiculo.getRveh_cada_cdm().toString()));
/*  376:     */           
/*  377: 390 */           cell = row.createCell((short)y++);
/*  378: 391 */           cell.setCellValue(Double.parseDouble(revisionesVehiculo.getRveh_cada_cdk().toString()));
/*  379:     */           
/*  380: 393 */           cell = row.createCell((short)y++);
/*  381: 394 */           cell.setCellValue(ManejoFechas.FormateoFecha(revisionesVehiculo.getRveh_control_fec().toString()));
/*  382:     */           
/*  383: 396 */           y = 0;
/*  384:     */         }
/*  385: 353 */         if (it == null) {
/*  386:     */           break;
/*  387:     */         }
/*  388: 353 */       } while (it.hasNext());
/*  389:     */     }
/*  390:     */     catch (Exception e)
/*  391:     */     {
/*  392: 402 */       throw e;
/*  393:     */     }
/*  394:     */   }
/*  395:     */   
/*  396:     */   public static void generarDatosMantenimientoUltimo(String nombreHoja, int servidor)
/*  397:     */     throws Exception
/*  398:     */   {
/*  399:     */     try
/*  400:     */     {
/*  401: 414 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/*  402: 415 */       HSSFFont boldFont = wb.createFont();
/*  403: 416 */       boldFont.setBoldweight((short)700);
/*  404: 417 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/*  405: 418 */       boldStyle.setFont(boldFont);
/*  406:     */       
/*  407: 420 */       VehiculosDAO vehiculosDAO = new VehiculosDAO();
/*  408: 421 */       vehiculosDAO.setServerNumber(servidor);
/*  409: 422 */       MarcasAutosDAO marcasAutoDAO = new MarcasAutosDAO();
/*  410: 423 */       marcasAutoDAO.setServerNumber(servidor);
/*  411: 424 */       RevisionesVehiculoDAO revisionesVehiculoDAO = new RevisionesVehiculoDAO();
/*  412: 425 */       revisionesVehiculoDAO.setServerNumber(servidor);
/*  413: 426 */       RevisionAccionDAO revisionAccionDAO = new RevisionAccionDAO();
/*  414: 427 */       revisionAccionDAO.setServerNumber(servidor);
/*  415: 428 */       RevisionAlternativaDAO revisionAlternativaDAO = new RevisionAlternativaDAO();
/*  416: 429 */       revisionAlternativaDAO.setServerNumber(servidor);
/*  417: 430 */       List vehiculos = vehiculosDAO.list(usuario.getUsuc_cod());
/*  418:     */       
/*  419: 432 */       HSSFRow row = null;
/*  420: 433 */       HSSFCell cell = null;
/*  421:     */       
/*  422: 435 */       row = sheet.createRow(0);
/*  423:     */       
/*  424: 437 */       cell = row.createCell((short)0);
/*  425: 438 */       cell.setCellValue(RES.getString("xls.vehi_placa"));
/*  426: 439 */       cell.setCellStyle(boldStyle);
/*  427:     */       
/*  428: 441 */       cell = row.createCell((short)1);
/*  429: 442 */       cell.setCellValue(RES.getString("xls.vehi_marca"));
/*  430: 443 */       cell.setCellStyle(boldStyle);
/*  431:     */       
/*  432: 445 */       cell = row.createCell((short)2);
/*  433: 446 */       cell.setCellValue(RES.getString("xls.rveh_actividad"));
/*  434: 447 */       cell.setCellStyle(boldStyle);
/*  435:     */       
/*  436: 449 */       cell = row.createCell((short)3);
/*  437: 450 */       cell.setCellValue(RES.getString("xls.rveh_control_fec"));
/*  438: 451 */       cell.setCellStyle(boldStyle);
/*  439:     */       
/*  440: 453 */       cell = row.createCell((short)4);
/*  441: 454 */       cell.setCellValue(RES.getString("xls.rveh_control_kms"));
/*  442: 455 */       cell.setCellStyle(boldStyle);
/*  443:     */       
/*  444: 457 */       int x = 1;
/*  445: 458 */       int y = 0;
/*  446:     */       
/*  447: 460 */       Iterator it = vehiculos.iterator();
/*  448:     */       do
/*  449:     */       {
/*  450: 462 */         Vehiculos vehiculo = (Vehiculos)it.next();
/*  451: 463 */         MarcasAutos marcasAutos = marcasAutoDAO.retrive(vehiculo.getVehi_maut_cod());
/*  452: 464 */         List revisiones = revisionesVehiculoDAO.list(vehiculo.getVehi_cod());
/*  453:     */         
/*  454: 466 */         Iterator iterator = revisiones.iterator();
/*  455: 467 */         while ((iterator != null) && (iterator.hasNext()))
/*  456:     */         {
/*  457: 468 */           RevisionesVehiculo revisionesVehiculo = (RevisionesVehiculo)iterator.next();
/*  458:     */           
/*  459: 470 */           row = sheet.createRow(x++);
/*  460: 472 */           if (x == 2)
/*  461:     */           {
/*  462: 473 */             cell = row.createCell((short)y++);
/*  463: 474 */             cell.setCellValue(vehiculo.getVehi_placa());
/*  464:     */             
/*  465: 476 */             cell = row.createCell((short)y++);
/*  466: 477 */             cell.setCellValue(marcasAutos.getMaut_des());
/*  467:     */           }
/*  468:     */           else
/*  469:     */           {
/*  470: 479 */             y += 2;
/*  471:     */           }
/*  472: 482 */           cell = row.createCell((short)y++);
/*  473: 483 */           cell.setCellValue(revisionesVehiculo.getRveh_actividad());
/*  474:     */           
/*  475: 485 */           cell = row.createCell((short)y++);
/*  476: 486 */           cell.setCellValue(ManejoFechas.FormateoFecha(revisionesVehiculo.getRveh_control_fec().toString()));
/*  477:     */           
/*  478: 488 */           cell = row.createCell((short)y++);
/*  479: 489 */           cell.setCellValue(revisionesVehiculo.getRveh_control_kms().floatValue());
/*  480:     */           
/*  481: 491 */           y = 0;
/*  482:     */         }
/*  483: 461 */         if (it == null) {
/*  484:     */           break;
/*  485:     */         }
/*  486: 461 */       } while (it.hasNext());
/*  487:     */     }
/*  488:     */     catch (Exception e)
/*  489:     */     {
/*  490: 497 */       throw e;
/*  491:     */     }
/*  492:     */   }
/*  493:     */   
/*  494:     */   public static void generarDatosControlesLey(String nombreHoja, int servidor)
/*  495:     */     throws Exception
/*  496:     */   {
/*  497:     */     try
/*  498:     */     {
/*  499: 509 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/*  500: 510 */       HSSFFont boldFont = wb.createFont();
/*  501: 511 */       boldFont.setBoldweight((short)700);
/*  502: 512 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/*  503: 513 */       boldStyle.setFont(boldFont);
/*  504:     */       
/*  505: 515 */       VehiculosDAO vehiculosDAO = new VehiculosDAO();
/*  506: 516 */       vehiculosDAO.setServerNumber(servidor);
/*  507: 517 */       MarcasAutosDAO marcasAutoDAO = new MarcasAutosDAO();
/*  508: 518 */       marcasAutoDAO.setServerNumber(servidor);
/*  509: 519 */       ControlesVehiculosDAO controlesVehiculosDAO = new ControlesVehiculosDAO();
/*  510: 520 */       controlesVehiculosDAO.setServerNumber(servidor);
/*  511: 521 */       List vehiculos = vehiculosDAO.list(usuario.getUsuc_cod());
/*  512:     */       
/*  513: 523 */       HSSFRow row = null;
/*  514: 524 */       HSSFCell cell = null;
/*  515:     */       
/*  516: 526 */       row = sheet.createRow(0);
/*  517:     */       
/*  518: 528 */       cell = row.createCell((short)0);
/*  519: 529 */       cell.setCellValue(RES.getString("xls.vehi_placa"));
/*  520: 530 */       cell.setCellStyle(boldStyle);
/*  521:     */       
/*  522: 532 */       cell = row.createCell((short)1);
/*  523: 533 */       cell.setCellValue(RES.getString("xls.vehi_marca"));
/*  524: 534 */       cell.setCellStyle(boldStyle);
/*  525:     */       
/*  526: 536 */       cell = row.createCell((short)2);
/*  527: 537 */       cell.setCellValue(RES.getString("xls.cveh_concepto"));
/*  528: 538 */       cell.setCellStyle(boldStyle);
/*  529:     */       
/*  530: 540 */       cell = row.createCell((short)3);
/*  531: 541 */       cell.setCellValue(RES.getString("xls.cveh_fecvigenc"));
/*  532: 542 */       cell.setCellStyle(boldStyle);
/*  533:     */       
/*  534: 544 */       int x = 1;
/*  535: 545 */       int y = 0;
/*  536:     */       
/*  537: 547 */       Iterator it = vehiculos.iterator();
/*  538:     */       do
/*  539:     */       {
/*  540: 549 */         Vehiculos vehiculo = (Vehiculos)it.next();
/*  541: 550 */         MarcasAutos marcasAutos = marcasAutoDAO.retrive(vehiculo.getVehi_maut_cod());
/*  542: 551 */         List controles = controlesVehiculosDAO.list(vehiculo.getVehi_cod());
/*  543:     */         
/*  544: 553 */         Iterator iterator = controles.iterator();
/*  545: 554 */         while ((iterator != null) && (iterator.hasNext()))
/*  546:     */         {
/*  547: 555 */           ControlesVehiculos controlesVehiculos = (ControlesVehiculos)iterator.next();
/*  548:     */           
/*  549: 557 */           row = sheet.createRow(x++);
/*  550: 559 */           if (x == 2)
/*  551:     */           {
/*  552: 560 */             cell = row.createCell((short)y++);
/*  553: 561 */             cell.setCellValue(vehiculo.getVehi_placa());
/*  554:     */             
/*  555: 563 */             cell = row.createCell((short)y++);
/*  556: 564 */             cell.setCellValue(marcasAutos.getMaut_des());
/*  557:     */           }
/*  558:     */           else
/*  559:     */           {
/*  560: 566 */             y += 2;
/*  561:     */           }
/*  562: 569 */           cell = row.createCell((short)y++);
/*  563: 570 */           cell.setCellValue(controlesVehiculos.getCveh_concepto());
/*  564:     */           
/*  565: 572 */           cell = row.createCell((short)y++);
/*  566: 573 */           cell.setCellValue(ManejoFechas.FormateoFecha(controlesVehiculos.getCveh_fecvigenc().toString()));
/*  567:     */           
/*  568: 575 */           y = 0;
/*  569:     */         }
/*  570: 548 */         if (it == null) {
/*  571:     */           break;
/*  572:     */         }
/*  573: 548 */       } while (it.hasNext());
/*  574:     */     }
/*  575:     */     catch (Exception e)
/*  576:     */     {
/*  577: 581 */       throw e;
/*  578:     */     }
/*  579:     */   }
/*  580:     */   
/*  581:     */   public static void generarDatosSeguros(String nombreHoja, int servidor)
/*  582:     */     throws Exception
/*  583:     */   {
/*  584:     */     try
/*  585:     */     {
/*  586: 588 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/*  587: 589 */       HSSFFont boldFont = wb.createFont();
/*  588: 590 */       boldFont.setBoldweight((short)700);
/*  589: 591 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/*  590: 592 */       boldStyle.setFont(boldFont);
/*  591:     */       
/*  592: 594 */       VehiculosDAO vehiculosDAO = new VehiculosDAO();
/*  593: 595 */       vehiculosDAO.setServerNumber(servidor);
/*  594: 596 */       MarcasAutosDAO marcasAutoDAO = new MarcasAutosDAO();
/*  595: 597 */       marcasAutoDAO.setServerNumber(servidor);
/*  596: 598 */       SegurosVehiculosDAO segurosVehiculosDAO = new SegurosVehiculosDAO();
/*  597: 599 */       segurosVehiculosDAO.setServerNumber(servidor);
/*  598: 600 */       List vehiculos = vehiculosDAO.list(usuario.getUsuc_cod());
/*  599: 601 */       PaisDAO paisDAO = new PaisDAO();
/*  600: 602 */       CiudadDAO ciudadDAO = new CiudadDAO();
/*  601: 603 */       ciudadDAO.setServerNumber(servidor);
/*  602:     */       
/*  603: 605 */       HSSFRow row = null;
/*  604: 606 */       HSSFCell cell = null;
/*  605:     */       
/*  606: 608 */       row = sheet.createRow(0);
/*  607:     */       
/*  608: 610 */       cell = row.createCell((short)0);
/*  609: 611 */       cell.setCellValue(RES.getString("xls.vehi_placa"));
/*  610: 612 */       cell.setCellStyle(boldStyle);
/*  611:     */       
/*  612: 614 */       cell = row.createCell((short)1);
/*  613: 615 */       cell.setCellValue(RES.getString("xls.vehi_marca"));
/*  614: 616 */       cell.setCellStyle(boldStyle);
/*  615:     */       
/*  616: 618 */       cell = row.createCell((short)2);
/*  617: 619 */       cell.setCellValue(RES.getString("xls.sveh_ciaaseg"));
/*  618: 620 */       cell.setCellStyle(boldStyle);
/*  619:     */       
/*  620: 622 */       cell = row.createCell((short)3);
/*  621: 623 */       cell.setCellValue(RES.getString("xls.sveh_ageemisor"));
/*  622: 624 */       cell.setCellStyle(boldStyle);
/*  623:     */       
/*  624: 626 */       cell = row.createCell((short)4);
/*  625: 627 */       cell.setCellValue(RES.getString("xls.sveh_pais_cod"));
/*  626: 628 */       cell.setCellStyle(boldStyle);
/*  627:     */       
/*  628: 630 */       cell = row.createCell((short)5);
/*  629: 631 */       cell.setCellValue(RES.getString("xls.sveh_ciu_cod"));
/*  630: 632 */       cell.setCellStyle(boldStyle);
/*  631:     */       
/*  632: 634 */       cell = row.createCell((short)6);
/*  633: 635 */       cell.setCellValue(RES.getString("xls.sveh_mail"));
/*  634: 636 */       cell.setCellStyle(boldStyle);
/*  635:     */       
/*  636: 638 */       cell = row.createCell((short)7);
/*  637: 639 */       cell.setCellValue(RES.getString("xls.sveh_indpais1"));
/*  638: 640 */       cell.setCellStyle(boldStyle);
/*  639:     */       
/*  640: 642 */       cell = row.createCell((short)8);
/*  641: 643 */       cell.setCellValue(RES.getString("xls.sveh_indciudad1"));
/*  642: 644 */       cell.setCellStyle(boldStyle);
/*  643:     */       
/*  644: 646 */       cell = row.createCell((short)9);
/*  645: 647 */       cell.setCellValue(RES.getString("xls.sveh_telefono1"));
/*  646: 648 */       cell.setCellStyle(boldStyle);
/*  647:     */       
/*  648: 650 */       cell = row.createCell((short)10);
/*  649: 651 */       cell.setCellValue(RES.getString("xls.sveh_movilindicativopais"));
/*  650: 652 */       cell.setCellStyle(boldStyle);
/*  651:     */       
/*  652: 654 */       cell = row.createCell((short)11);
/*  653: 655 */       cell.setCellValue(RES.getString("xls.sveh_movilnumero"));
/*  654: 656 */       cell.setCellStyle(boldStyle);
/*  655:     */       
/*  656: 658 */       cell = row.createCell((short)12);
/*  657: 659 */       cell.setCellValue(RES.getString("xls.sveh_fijoindicativopais"));
/*  658: 660 */       cell.setCellStyle(boldStyle);
/*  659:     */       
/*  660: 662 */       cell = row.createCell((short)13);
/*  661: 663 */       cell.setCellValue(RES.getString("xls.sveh_fijoindicativociudad"));
/*  662: 664 */       cell.setCellStyle(boldStyle);
/*  663:     */       
/*  664: 666 */       cell = row.createCell((short)14);
/*  665: 667 */       cell.setCellValue(RES.getString("xls.sveh_fijonumero"));
/*  666: 668 */       cell.setCellStyle(boldStyle);
/*  667:     */       
/*  668: 670 */       cell = row.createCell((short)15);
/*  669: 671 */       cell.setCellValue(RES.getString("xls.sveh_numpoliza"));
/*  670: 672 */       cell.setCellStyle(boldStyle);
/*  671:     */       
/*  672: 674 */       cell = row.createCell((short)16);
/*  673: 675 */       cell.setCellValue(RES.getString("xls.sveh_responsabilidad"));
/*  674: 676 */       cell.setCellStyle(boldStyle);
/*  675:     */       
/*  676: 678 */       cell = row.createCell((short)17);
/*  677: 679 */       cell.setCellValue(RES.getString("xls.sveh_juridica"));
/*  678: 680 */       cell.setCellStyle(boldStyle);
/*  679:     */       
/*  680: 682 */       cell = row.createCell((short)18);
/*  681: 683 */       cell.setCellValue(RES.getString("xls.sveh_perdidaparcialdanos"));
/*  682: 684 */       cell.setCellStyle(boldStyle);
/*  683:     */       
/*  684: 686 */       cell = row.createCell((short)19);
/*  685: 687 */       cell.setCellValue(RES.getString("xls.sveh_perdidatotaldanos"));
/*  686: 688 */       cell.setCellStyle(boldStyle);
/*  687:     */       
/*  688: 690 */       cell = row.createCell((short)20);
/*  689: 691 */       cell.setCellValue(RES.getString("xls.sveh_perdidahurto"));
/*  690: 692 */       cell.setCellStyle(boldStyle);
/*  691:     */       
/*  692: 694 */       cell = row.createCell((short)21);
/*  693: 695 */       cell.setCellValue(RES.getString("xls.sveh_amparodanos"));
/*  694: 696 */       cell.setCellStyle(boldStyle);
/*  695:     */       
/*  696: 698 */       cell = row.createCell((short)22);
/*  697: 699 */       cell.setCellValue(RES.getString("xls.sveh_amparocivil"));
/*  698: 700 */       cell.setCellStyle(boldStyle);
/*  699:     */       
/*  700: 702 */       cell = row.createCell((short)23);
/*  701: 703 */       cell.setCellValue(RES.getString("xls.sveh_transpordedanos"));
/*  702: 704 */       cell.setCellStyle(boldStyle);
/*  703:     */       
/*  704: 706 */       cell = row.createCell((short)24);
/*  705: 707 */       cell.setCellValue(RES.getString("xls.sveh_transportehurto"));
/*  706: 708 */       cell.setCellStyle(boldStyle);
/*  707:     */       
/*  708: 710 */       cell = row.createCell((short)25);
/*  709: 711 */       cell.setCellValue(RES.getString("xls.sveh_asistenciaviaje"));
/*  710: 712 */       cell.setCellStyle(boldStyle);
/*  711:     */       
/*  712: 714 */       cell = row.createCell((short)26);
/*  713: 715 */       cell.setCellValue(RES.getString("xls.sveh_terremoto"));
/*  714: 716 */       cell.setCellStyle(boldStyle);
/*  715:     */       
/*  716:     */ 
/*  717:     */ 
/*  718:     */ 
/*  719:     */ 
/*  720:     */ 
/*  721:     */ 
/*  722:     */ 
/*  723:     */ 
/*  724: 726 */       cell = row.createCell((short)27);
/*  725: 727 */       cell.setCellValue(RES.getString("xls.sveh_fecvigenchasta"));
/*  726: 728 */       cell.setCellStyle(boldStyle);
/*  727:     */       
/*  728: 730 */       int x = 1;
/*  729: 731 */       int y = 0;
/*  730:     */       
/*  731: 733 */       Iterator it = vehiculos.iterator();
/*  732:     */       do
/*  733:     */       {
/*  734: 735 */         Vehiculos vehiculo = (Vehiculos)it.next();
/*  735: 736 */         MarcasAutos marcasAutos = marcasAutoDAO.retrive(vehiculo.getVehi_maut_cod());
/*  736:     */         
/*  737: 738 */         List seguros = segurosVehiculosDAO.list(vehiculo.getVehi_cod());
/*  738:     */         
/*  739: 740 */         Iterator iterator = seguros.iterator();
/*  740: 741 */         while ((iterator != null) && (iterator.hasNext()))
/*  741:     */         {
/*  742: 742 */           SegurosVehiculos segurosVehiculos = (SegurosVehiculos)iterator.next();
/*  743: 743 */           Paises paises = paisDAO.retrive(segurosVehiculos.getSveh_pais_cod());
/*  744: 744 */           Ciudades ciudades = ciudadDAO.retrive(segurosVehiculos.getSveh_pais_cod(), segurosVehiculos.getSveh_ciu_cod());
/*  745:     */           
/*  746: 746 */           row = sheet.createRow(x++);
/*  747: 748 */           if (x == 2)
/*  748:     */           {
/*  749: 749 */             cell = row.createCell((short)y++);
/*  750: 750 */             cell.setCellValue(vehiculo.getVehi_placa());
/*  751:     */             
/*  752: 752 */             cell = row.createCell((short)y++);
/*  753: 753 */             cell.setCellValue(marcasAutos.getMaut_des());
/*  754:     */           }
/*  755:     */           else
/*  756:     */           {
/*  757: 755 */             y += 2;
/*  758:     */           }
/*  759: 758 */           cell = row.createCell((short)y++);
/*  760: 759 */           cell.setCellValue(segurosVehiculos.getSveh_ciaaseg());
/*  761:     */           
/*  762: 761 */           cell = row.createCell((short)y++);
/*  763: 762 */           cell.setCellValue(segurosVehiculos.getSveh_ageemisor());
/*  764:     */           
/*  765: 764 */           cell = row.createCell((short)y++);
/*  766: 765 */           cell.setCellValue(paises.getPais_des());
/*  767:     */           
/*  768: 767 */           cell = row.createCell((short)y++);
/*  769: 768 */           cell.setCellValue(ciudades.getCiu_des());
/*  770:     */           
/*  771: 770 */           cell = row.createCell((short)y++);
/*  772: 771 */           cell.setCellValue(segurosVehiculos.getSveh_mail());
/*  773:     */           
/*  774: 773 */           cell = row.createCell((short)y++);
/*  775: 774 */           cell.setCellValue(segurosVehiculos.getSveh_indpais1().toString());
/*  776:     */           
/*  777: 776 */           cell = row.createCell((short)y++);
/*  778: 777 */           cell.setCellValue(segurosVehiculos.getSveh_indciudad1().toString());
/*  779:     */           
/*  780: 779 */           cell = row.createCell((short)y++);
/*  781: 780 */           cell.setCellValue(segurosVehiculos.getSveh_telefono1());
/*  782:     */           
/*  783: 782 */           cell = row.createCell((short)y++);
/*  784: 783 */           cell.setCellValue(segurosVehiculos.getSveh_movilindicativopais().toString());
/*  785:     */           
/*  786: 785 */           cell = row.createCell((short)y++);
/*  787: 786 */           cell.setCellValue(segurosVehiculos.getSveh_movilnumero());
/*  788:     */           
/*  789: 788 */           cell = row.createCell((short)y++);
/*  790: 789 */           cell.setCellValue(segurosVehiculos.getSveh_fijoindicativopais().toString());
/*  791:     */           
/*  792: 791 */           cell = row.createCell((short)y++);
/*  793: 792 */           cell.setCellValue(segurosVehiculos.getSveh_fijoindicativociudad().toString());
/*  794:     */           
/*  795: 794 */           cell = row.createCell((short)y++);
/*  796: 795 */           cell.setCellValue(segurosVehiculos.getSveh_fijonumero());
/*  797:     */           
/*  798: 797 */           cell = row.createCell((short)y++);
/*  799: 798 */           cell.setCellValue(segurosVehiculos.getSveh_numpoliza());
/*  800:     */           
/*  801: 800 */           cell = row.createCell((short)y++);
/*  802: 801 */           cell.setCellValue(segurosVehiculos.getSveh_responsabilidad().toString());
/*  803:     */           
/*  804: 803 */           cell = row.createCell((short)y++);
/*  805: 804 */           cell.setCellValue(segurosVehiculos.getSveh_juridica().toString());
/*  806:     */           
/*  807: 806 */           cell = row.createCell((short)y++);
/*  808: 807 */           cell.setCellValue(segurosVehiculos.getSveh_perdidatotaldanos().toString());
/*  809:     */           
/*  810: 809 */           cell = row.createCell((short)y++);
/*  811: 810 */           cell.setCellValue(segurosVehiculos.getSveh_perdidatotaldanos().toString());
/*  812:     */           
/*  813: 812 */           cell = row.createCell((short)y++);
/*  814: 813 */           cell.setCellValue(segurosVehiculos.getSveh_perdidahurto().toString());
/*  815:     */           
/*  816: 815 */           cell = row.createCell((short)y++);
/*  817: 816 */           cell.setCellValue(segurosVehiculos.getSveh_amparodanos().toString());
/*  818:     */           
/*  819: 818 */           cell = row.createCell((short)y++);
/*  820: 819 */           cell.setCellValue(segurosVehiculos.getSveh_amparocivil().toString());
/*  821:     */           
/*  822: 821 */           cell = row.createCell((short)y++);
/*  823: 822 */           cell.setCellValue(segurosVehiculos.getSveh_transpordedanos().toString());
/*  824:     */           
/*  825: 824 */           cell = row.createCell((short)y++);
/*  826: 825 */           cell.setCellValue(segurosVehiculos.getSveh_transportehurto().toString());
/*  827:     */           
/*  828: 827 */           cell = row.createCell((short)y++);
/*  829: 828 */           cell.setCellValue(segurosVehiculos.getSveh_asistenciaviaje().toString());
/*  830:     */           
/*  831: 830 */           cell = row.createCell((short)y++);
/*  832: 831 */           cell.setCellValue(segurosVehiculos.getSveh_terremoto().toString());
/*  833:     */           
/*  834:     */ 
/*  835:     */ 
/*  836:     */ 
/*  837:     */ 
/*  838:     */ 
/*  839:     */ 
/*  840: 839 */           cell = row.createCell((short)y++);
/*  841: 840 */           cell.setCellValue(ManejoFechas.FormateoFecha(segurosVehiculos.getSveh_fecvigenchasta().toString()));
/*  842:     */           
/*  843: 842 */           y = 0;
/*  844:     */         }
/*  845: 734 */         if (it == null) {
/*  846:     */           break;
/*  847:     */         }
/*  848: 734 */       } while (it.hasNext());
/*  849:     */     }
/*  850:     */     catch (Exception e)
/*  851:     */     {
/*  852: 848 */       throw e;
/*  853:     */     }
/*  854:     */   }
/*  855:     */   
/*  856:     */   public static void generarDatosGastosMecanica(String nombreHoja, int servidor)
/*  857:     */     throws Exception
/*  858:     */   {
/*  859:     */     try
/*  860:     */     {
/*  861: 860 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/*  862: 861 */       HSSFFont boldFont = wb.createFont();
/*  863: 862 */       boldFont.setBoldweight((short)700);
/*  864: 863 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/*  865: 864 */       boldStyle.setFont(boldFont);
/*  866:     */       
/*  867: 866 */       VehiculosDAO vehiculosDAO = new VehiculosDAO();
/*  868: 867 */       vehiculosDAO.setServerNumber(servidor);
/*  869: 868 */       MarcasAutosDAO marcasAutoDAO = new MarcasAutosDAO();
/*  870: 869 */       marcasAutoDAO.setServerNumber(servidor);
/*  871: 870 */       GastosVehiculosMecanicaDAO gastosVehiculosMecanicaDAO = new GastosVehiculosMecanicaDAO();
/*  872: 871 */       gastosVehiculosMecanicaDAO.setServerNumber(servidor);
/*  873: 872 */       List vehiculos = vehiculosDAO.list(usuario.getUsuc_cod());
/*  874:     */       
/*  875: 874 */       HSSFRow row = null;
/*  876: 875 */       HSSFCell cell = null;
/*  877:     */       
/*  878: 877 */       row = sheet.createRow(0);
/*  879:     */       
/*  880: 879 */       cell = row.createCell((short)0);
/*  881: 880 */       cell.setCellValue(RES.getString("xls.vehi_placa"));
/*  882: 881 */       cell.setCellStyle(boldStyle);
/*  883:     */       
/*  884: 883 */       cell = row.createCell((short)1);
/*  885: 884 */       cell.setCellValue(RES.getString("xls.vehi_marca"));
/*  886: 885 */       cell.setCellStyle(boldStyle);
/*  887:     */       
/*  888: 887 */       cell = row.createCell((short)2);
/*  889: 888 */       cell.setCellValue(RES.getString("xls.gastos_descripcion"));
/*  890: 889 */       cell.setCellStyle(boldStyle);
/*  891:     */       
/*  892: 891 */       cell = row.createCell((short)3);
/*  893: 892 */       cell.setCellValue(RES.getString("xls.gastos_fechaini"));
/*  894: 893 */       cell.setCellStyle(boldStyle);
/*  895:     */       
/*  896: 895 */       cell = row.createCell((short)4);
/*  897: 896 */       cell.setCellValue(RES.getString("xls.gastos_fechafin"));
/*  898: 897 */       cell.setCellStyle(boldStyle);
/*  899:     */       
/*  900: 899 */       cell = row.createCell((short)5);
/*  901: 900 */       cell.setCellValue(RES.getString("xls.gastos_valor"));
/*  902: 901 */       cell.setCellStyle(boldStyle);
/*  903:     */       
/*  904: 903 */       cell = row.createCell((short)6);
/*  905: 904 */       cell.setCellValue(RES.getString("xls.gastos_mensual"));
/*  906: 905 */       cell.setCellStyle(boldStyle);
/*  907:     */       
/*  908: 907 */       cell = row.createCell((short)7);
/*  909: 908 */       cell.setCellValue(RES.getString("xls.gastos_anual"));
/*  910: 909 */       cell.setCellStyle(boldStyle);
/*  911:     */       
/*  912: 911 */       int x = 1;
/*  913: 912 */       int y = 0;
/*  914:     */       
/*  915: 914 */       Iterator it = vehiculos.iterator();
/*  916:     */       do
/*  917:     */       {
/*  918: 916 */         Vehiculos vehiculo = (Vehiculos)it.next();
/*  919: 917 */         MarcasAutos marcasAutos = marcasAutoDAO.retrive(vehiculo.getVehi_maut_cod());
/*  920: 918 */         List gastos = gastosVehiculosMecanicaDAO.list(vehiculo.getVehi_cod());
/*  921:     */         
/*  922: 920 */         Iterator iterator = gastos.iterator();
/*  923: 921 */         while ((iterator != null) && (iterator.hasNext()))
/*  924:     */         {
/*  925: 922 */           GastosVehiculosMecanica gastosVehiculosMecanica = (GastosVehiculosMecanica)iterator.next();
/*  926:     */           
/*  927: 924 */           row = sheet.createRow(x++);
/*  928: 926 */           if (x == 2)
/*  929:     */           {
/*  930: 927 */             cell = row.createCell((short)y++);
/*  931: 928 */             cell.setCellValue(vehiculo.getVehi_placa());
/*  932:     */             
/*  933: 930 */             cell = row.createCell((short)y++);
/*  934: 931 */             cell.setCellValue(marcasAutos.getMaut_des());
/*  935:     */           }
/*  936:     */           else
/*  937:     */           {
/*  938: 933 */             y += 2;
/*  939:     */           }
/*  940: 936 */           cell = row.createCell((short)y++);
/*  941: 937 */           cell.setCellValue(gastosVehiculosMecanica.getGasv_descripcion());
/*  942:     */           
/*  943: 939 */           cell = row.createCell((short)y++);
/*  944: 940 */           cell.setCellValue(ManejoFechas.FormateoFecha(gastosVehiculosMecanica.getGasv_fechaini().toString()));
/*  945:     */           
/*  946: 942 */           cell = row.createCell((short)y++);
/*  947: 943 */           cell.setCellValue(ManejoFechas.FormateoFecha(gastosVehiculosMecanica.getGasv_fechafin().toString()));
/*  948:     */           
/*  949: 945 */           cell = row.createCell((short)y++);
/*  950: 946 */           cell.setCellValue(gastosVehiculosMecanica.getGasv_valor().toString());
/*  951:     */           
/*  952: 948 */           y = 0;
/*  953:     */         }
/*  954: 915 */         if (it == null) {
/*  955:     */           break;
/*  956:     */         }
/*  957: 915 */       } while (it.hasNext());
/*  958:     */     }
/*  959:     */     catch (Exception e)
/*  960:     */     {
/*  961: 954 */       throw e;
/*  962:     */     }
/*  963:     */   }
/*  964:     */   
/*  965:     */   public static void generarDatosGastosAnuales(String nombreHoja, int servidor)
/*  966:     */     throws Exception
/*  967:     */   {
/*  968:     */     try
/*  969:     */     {
/*  970: 966 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/*  971: 967 */       HSSFFont boldFont = wb.createFont();
/*  972: 968 */       boldFont.setBoldweight((short)700);
/*  973: 969 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/*  974: 970 */       boldStyle.setFont(boldFont);
/*  975:     */       
/*  976: 972 */       VehiculosDAO vehiculosDAO = new VehiculosDAO();
/*  977: 973 */       vehiculosDAO.setServerNumber(servidor);
/*  978: 974 */       MarcasAutosDAO marcasAutoDAO = new MarcasAutosDAO();
/*  979: 975 */       marcasAutoDAO.setServerNumber(servidor);
/*  980: 976 */       GastosVehiculosAnualesDAO gastosVehiculosAnualesDAO = new GastosVehiculosAnualesDAO();
/*  981: 977 */       List vehiculos = vehiculosDAO.list(usuario.getUsuc_cod());
/*  982:     */       
/*  983: 979 */       HSSFRow row = null;
/*  984: 980 */       HSSFCell cell = null;
/*  985:     */       
/*  986: 982 */       row = sheet.createRow(0);
/*  987:     */       
/*  988: 984 */       cell = row.createCell((short)0);
/*  989: 985 */       cell.setCellValue(RES.getString("xls.vehi_placa"));
/*  990: 986 */       cell.setCellStyle(boldStyle);
/*  991:     */       
/*  992: 988 */       cell = row.createCell((short)1);
/*  993: 989 */       cell.setCellValue(RES.getString("xls.vehi_marca"));
/*  994: 990 */       cell.setCellStyle(boldStyle);
/*  995:     */       
/*  996: 992 */       cell = row.createCell((short)2);
/*  997: 993 */       cell.setCellValue(RES.getString("xls.gastos_descripcion"));
/*  998: 994 */       cell.setCellStyle(boldStyle);
/*  999:     */       
/* 1000: 996 */       cell = row.createCell((short)3);
/* 1001: 997 */       cell.setCellValue(RES.getString("xls.gastos_fechaini"));
/* 1002: 998 */       cell.setCellStyle(boldStyle);
/* 1003:     */       
/* 1004:1000 */       cell = row.createCell((short)4);
/* 1005:1001 */       cell.setCellValue(RES.getString("xls.gastos_fechafin"));
/* 1006:1002 */       cell.setCellStyle(boldStyle);
/* 1007:     */       
/* 1008:1004 */       cell = row.createCell((short)5);
/* 1009:1005 */       cell.setCellValue(RES.getString("xls.gastos_valor"));
/* 1010:1006 */       cell.setCellStyle(boldStyle);
/* 1011:     */       
/* 1012:1008 */       cell = row.createCell((short)6);
/* 1013:1009 */       cell.setCellValue(RES.getString("xls.gastos_costomes"));
/* 1014:1010 */       cell.setCellStyle(boldStyle);
/* 1015:     */       
/* 1016:1012 */       int x = 1;
/* 1017:1013 */       int y = 0;
/* 1018:     */       
/* 1019:1015 */       Iterator it = vehiculos.iterator();
/* 1020:     */       do
/* 1021:     */       {
/* 1022:1017 */         Vehiculos vehiculo = (Vehiculos)it.next();
/* 1023:1018 */         MarcasAutos marcasAutos = marcasAutoDAO.retrive(vehiculo.getVehi_maut_cod());
/* 1024:1019 */         List gastos = gastosVehiculosAnualesDAO.list(vehiculo.getVehi_cod());
/* 1025:     */         
/* 1026:1021 */         Iterator iterator = gastos.iterator();
/* 1027:1022 */         while ((iterator != null) && (iterator.hasNext()))
/* 1028:     */         {
/* 1029:1023 */           GastosVehiculosAnuales gastosVehiculosAnuales = (GastosVehiculosAnuales)iterator.next();
/* 1030:     */           
/* 1031:1025 */           row = sheet.createRow(x++);
/* 1032:1027 */           if (x == 2)
/* 1033:     */           {
/* 1034:1028 */             cell = row.createCell((short)y++);
/* 1035:1029 */             cell.setCellValue(vehiculo.getVehi_placa());
/* 1036:     */             
/* 1037:1031 */             cell = row.createCell((short)y++);
/* 1038:1032 */             cell.setCellValue(marcasAutos.getMaut_des());
/* 1039:     */           }
/* 1040:     */           else
/* 1041:     */           {
/* 1042:1034 */             y += 2;
/* 1043:     */           }
/* 1044:1037 */           cell = row.createCell((short)y++);
/* 1045:1038 */           cell.setCellValue(gastosVehiculosAnuales.getGasv_descripcion());
/* 1046:     */           
/* 1047:1040 */           cell = row.createCell((short)y++);
/* 1048:1041 */           cell.setCellValue(ManejoFechas.FormateoFecha(gastosVehiculosAnuales.getGasv_fechaini().toString()));
/* 1049:     */           
/* 1050:1043 */           cell = row.createCell((short)y++);
/* 1051:1044 */           cell.setCellValue(ManejoFechas.FormateoFecha(gastosVehiculosAnuales.getGasv_fechafin().toString()));
/* 1052:     */           
/* 1053:1046 */           cell = row.createCell((short)y++);
/* 1054:1047 */           cell.setCellValue(gastosVehiculosAnuales.getGasv_valor().toString());
/* 1055:     */           
/* 1056:1049 */           y = 0;
/* 1057:     */         }
/* 1058:1016 */         if (it == null) {
/* 1059:     */           break;
/* 1060:     */         }
/* 1061:1016 */       } while (it.hasNext());
/* 1062:     */     }
/* 1063:     */     catch (Exception e)
/* 1064:     */     {
/* 1065:1055 */       throw e;
/* 1066:     */     }
/* 1067:     */   }
/* 1068:     */   
/* 1069:     */   public static void generarDatosGastosNoAnuales(String nombreHoja, int servidor)
/* 1070:     */     throws Exception
/* 1071:     */   {
/* 1072:     */     try
/* 1073:     */     {
/* 1074:1067 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/* 1075:1068 */       HSSFFont boldFont = wb.createFont();
/* 1076:1069 */       boldFont.setBoldweight((short)700);
/* 1077:1070 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/* 1078:1071 */       boldStyle.setFont(boldFont);
/* 1079:     */       
/* 1080:1073 */       VehiculosDAO vehiculosDAO = new VehiculosDAO();
/* 1081:1074 */       vehiculosDAO.setServerNumber(servidor);
/* 1082:1075 */       MarcasAutosDAO marcasAutoDAO = new MarcasAutosDAO();
/* 1083:1076 */       marcasAutoDAO.setServerNumber(servidor);
/* 1084:1077 */       GastosVehiculosNoAnualesDAO gastosVehiculosNoAnualesDAO = new GastosVehiculosNoAnualesDAO();
/* 1085:1078 */       gastosVehiculosNoAnualesDAO.setServerNumber(servidor);
/* 1086:1079 */       List vehiculos = vehiculosDAO.list(usuario.getUsuc_cod());
/* 1087:     */       
/* 1088:1081 */       HSSFRow row = null;
/* 1089:1082 */       HSSFCell cell = null;
/* 1090:     */       
/* 1091:1084 */       row = sheet.createRow(0);
/* 1092:     */       
/* 1093:1086 */       cell = row.createCell((short)0);
/* 1094:1087 */       cell.setCellValue(RES.getString("xls.vehi_placa"));
/* 1095:1088 */       cell.setCellStyle(boldStyle);
/* 1096:     */       
/* 1097:1090 */       cell = row.createCell((short)1);
/* 1098:1091 */       cell.setCellValue(RES.getString("xls.vehi_marca"));
/* 1099:1092 */       cell.setCellStyle(boldStyle);
/* 1100:     */       
/* 1101:1094 */       cell = row.createCell((short)2);
/* 1102:1095 */       cell.setCellValue(RES.getString("xls.gastos_descripcion"));
/* 1103:1096 */       cell.setCellStyle(boldStyle);
/* 1104:     */       
/* 1105:1098 */       cell = row.createCell((short)3);
/* 1106:1099 */       cell.setCellValue(RES.getString("xls.gastos_fechaini"));
/* 1107:1100 */       cell.setCellStyle(boldStyle);
/* 1108:     */       
/* 1109:1102 */       cell = row.createCell((short)4);
/* 1110:1103 */       cell.setCellValue(RES.getString("xls.gastos_fechafin"));
/* 1111:1104 */       cell.setCellStyle(boldStyle);
/* 1112:     */       
/* 1113:1106 */       cell = row.createCell((short)5);
/* 1114:1107 */       cell.setCellValue(RES.getString("xls.gastos_valor"));
/* 1115:1108 */       cell.setCellStyle(boldStyle);
/* 1116:     */       
/* 1117:1110 */       cell = row.createCell((short)6);
/* 1118:1111 */       cell.setCellValue(RES.getString("xls.gastos_mensual"));
/* 1119:1112 */       cell.setCellStyle(boldStyle);
/* 1120:     */       
/* 1121:1114 */       cell = row.createCell((short)7);
/* 1122:1115 */       cell.setCellValue(RES.getString("xls.gastos_anual"));
/* 1123:1116 */       cell.setCellStyle(boldStyle);
/* 1124:     */       
/* 1125:1118 */       int x = 1;
/* 1126:1119 */       int y = 0;
/* 1127:     */       
/* 1128:1121 */       Iterator it = vehiculos.iterator();
/* 1129:     */       do
/* 1130:     */       {
/* 1131:1123 */         Vehiculos vehiculo = (Vehiculos)it.next();
/* 1132:1124 */         MarcasAutos marcasAutos = marcasAutoDAO.retrive(vehiculo.getVehi_maut_cod());
/* 1133:1125 */         List gastos = gastosVehiculosNoAnualesDAO.list(vehiculo.getVehi_cod());
/* 1134:     */         
/* 1135:1127 */         Iterator iterator = gastos.iterator();
/* 1136:1128 */         while ((iterator != null) && (iterator.hasNext()))
/* 1137:     */         {
/* 1138:1129 */           GastosVehiculosNoAnuales gastosVehiculosNoAnuales = (GastosVehiculosNoAnuales)iterator.next();
/* 1139:     */           
/* 1140:1131 */           row = sheet.createRow(x++);
/* 1141:1133 */           if (x == 2)
/* 1142:     */           {
/* 1143:1134 */             cell = row.createCell((short)y++);
/* 1144:1135 */             cell.setCellValue(vehiculo.getVehi_placa());
/* 1145:     */             
/* 1146:1137 */             cell = row.createCell((short)y++);
/* 1147:1138 */             cell.setCellValue(marcasAutos.getMaut_des());
/* 1148:     */           }
/* 1149:     */           else
/* 1150:     */           {
/* 1151:1140 */             y += 2;
/* 1152:     */           }
/* 1153:1143 */           cell = row.createCell((short)y++);
/* 1154:1144 */           cell.setCellValue(gastosVehiculosNoAnuales.getGasv_descripcion());
/* 1155:     */           
/* 1156:1146 */           cell = row.createCell((short)y++);
/* 1157:1147 */           cell.setCellValue(ManejoFechas.FormateoFecha(gastosVehiculosNoAnuales.getGasv_fechaini().toString()));
/* 1158:     */           
/* 1159:1149 */           cell = row.createCell((short)y++);
/* 1160:1150 */           cell.setCellValue(ManejoFechas.FormateoFecha(gastosVehiculosNoAnuales.getGasv_fechafin().toString()));
/* 1161:     */           
/* 1162:1152 */           cell = row.createCell((short)y++);
/* 1163:1153 */           cell.setCellValue(gastosVehiculosNoAnuales.getGasv_valor().toString());
/* 1164:     */           
/* 1165:1155 */           y = 0;
/* 1166:     */         }
/* 1167:1122 */         if (it == null) {
/* 1168:     */           break;
/* 1169:     */         }
/* 1170:1122 */       } while (it.hasNext());
/* 1171:     */     }
/* 1172:     */     catch (Exception e)
/* 1173:     */     {
/* 1174:1161 */       throw e;
/* 1175:     */     }
/* 1176:     */   }
/* 1177:     */   
/* 1178:     */   public static void generarDatosImpuestos(String nombreHoja, int servidor)
/* 1179:     */     throws Exception
/* 1180:     */   {
/* 1181:     */     try
/* 1182:     */     {
/* 1183:1173 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/* 1184:1174 */       HSSFFont boldFont = wb.createFont();
/* 1185:1175 */       boldFont.setBoldweight((short)700);
/* 1186:1176 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/* 1187:1177 */       boldStyle.setFont(boldFont);
/* 1188:     */       
/* 1189:1179 */       VehiculosDAO vehiculosDAO = new VehiculosDAO();
/* 1190:1180 */       vehiculosDAO.setServerNumber(servidor);
/* 1191:1181 */       MarcasAutosDAO marcasAutoDAO = new MarcasAutosDAO();
/* 1192:1182 */       marcasAutoDAO.setServerNumber(servidor);
/* 1193:1183 */       ImpuestoVehiculoDAO impuestoVehiculoDAO = new ImpuestoVehiculoDAO();
/* 1194:1184 */       impuestoVehiculoDAO.setServerNumber(servidor);
/* 1195:1185 */       List vehiculos = vehiculosDAO.list(usuario.getUsuc_cod());
/* 1196:     */       
/* 1197:1187 */       HSSFRow row = null;
/* 1198:1188 */       HSSFCell cell = null;
/* 1199:     */       
/* 1200:1190 */       row = sheet.createRow(0);
/* 1201:     */       
/* 1202:1192 */       cell = row.createCell((short)0);
/* 1203:1193 */       cell.setCellValue(RES.getString("xls.vehi_placa"));
/* 1204:1194 */       cell.setCellStyle(boldStyle);
/* 1205:     */       
/* 1206:1196 */       cell = row.createCell((short)1);
/* 1207:1197 */       cell.setCellValue(RES.getString("xls.vehi_marca"));
/* 1208:1198 */       cell.setCellStyle(boldStyle);
/* 1209:     */       
/* 1210:1200 */       cell = row.createCell((short)2);
/* 1211:1201 */       cell.setCellValue(RES.getString("xls.impuestos_descripcion"));
/* 1212:1202 */       cell.setCellStyle(boldStyle);
/* 1213:     */       
/* 1214:1204 */       cell = row.createCell((short)3);
/* 1215:1205 */       cell.setCellValue(RES.getString("xls.impuestos_fechapago"));
/* 1216:1206 */       cell.setCellStyle(boldStyle);
/* 1217:     */       
/* 1218:1208 */       cell = row.createCell((short)4);
/* 1219:1209 */       cell.setCellValue(RES.getString("xls.impuestos_vighasta"));
/* 1220:1210 */       cell.setCellStyle(boldStyle);
/* 1221:     */       
/* 1222:     */ 
/* 1223:     */ 
/* 1224:     */ 
/* 1225:     */ 
/* 1226:1216 */       int x = 1;
/* 1227:1217 */       int y = 0;
/* 1228:     */       
/* 1229:1219 */       Iterator it = vehiculos.iterator();
/* 1230:     */       do
/* 1231:     */       {
/* 1232:1221 */         Vehiculos vehiculo = (Vehiculos)it.next();
/* 1233:1222 */         MarcasAutos marcasAutos = marcasAutoDAO.retrive(vehiculo.getVehi_maut_cod());
/* 1234:1223 */         List impuestos = impuestoVehiculoDAO.list(vehiculo.getVehi_cod());
/* 1235:     */         
/* 1236:1225 */         Iterator iterator = impuestos.iterator();
/* 1237:1226 */         while ((iterator != null) && (iterator.hasNext()))
/* 1238:     */         {
/* 1239:1227 */           ImpuestoVehiculo impuestoVehiculo = (ImpuestoVehiculo)iterator.next();
/* 1240:     */           
/* 1241:1229 */           row = sheet.createRow(x++);
/* 1242:1231 */           if (x == 2)
/* 1243:     */           {
/* 1244:1232 */             cell = row.createCell((short)y++);
/* 1245:1233 */             cell.setCellValue(vehiculo.getVehi_placa());
/* 1246:     */             
/* 1247:1235 */             cell = row.createCell((short)y++);
/* 1248:1236 */             cell.setCellValue(marcasAutos.getMaut_des());
/* 1249:     */           }
/* 1250:     */           else
/* 1251:     */           {
/* 1252:1238 */             y += 2;
/* 1253:     */           }
/* 1254:1241 */           cell = row.createCell((short)y++);
/* 1255:1242 */           cell.setCellValue(impuestoVehiculo.getImpv_descripcion());
/* 1256:     */           
/* 1257:     */ 
/* 1258:     */ 
/* 1259:     */ 
/* 1260:1247 */           cell = row.createCell((short)y++);
/* 1261:1248 */           cell.setCellValue(ManejoFechas.FormateoFecha(impuestoVehiculo.getImpv_fechapago().toString()));
/* 1262:     */           
/* 1263:1250 */           cell = row.createCell((short)y++);
/* 1264:1251 */           cell.setCellValue(ManejoFechas.FormateoFecha(impuestoVehiculo.getImpv_vigenciahasta().toString()));
/* 1265:     */           
/* 1266:1253 */           y = 0;
/* 1267:     */         }
/* 1268:1220 */         if (it == null) {
/* 1269:     */           break;
/* 1270:     */         }
/* 1271:1220 */       } while (it.hasNext());
/* 1272:     */     }
/* 1273:     */     catch (Exception e)
/* 1274:     */     {
/* 1275:1259 */       throw e;
/* 1276:     */     }
/* 1277:     */   }
/* 1278:     */   
/* 1279:     */   public static void generarDatosCombustible(String nombreHoja, int servidor)
/* 1280:     */     throws Exception
/* 1281:     */   {
/* 1282:     */     try
/* 1283:     */     {
/* 1284:1271 */       HSSFSheet sheet = wb.getSheet(nombreHoja);
/* 1285:1272 */       HSSFFont boldFont = wb.createFont();
/* 1286:1273 */       boldFont.setBoldweight((short)700);
/* 1287:1274 */       HSSFCellStyle boldStyle = wb.createCellStyle();
/* 1288:1275 */       boldStyle.setFont(boldFont);
/* 1289:     */       
/* 1290:1277 */       VehiculosDAO vehiculosDAO = new VehiculosDAO();
/* 1291:1278 */       vehiculosDAO.setServerNumber(servidor);
/* 1292:1279 */       MarcasAutosDAO marcasAutoDAO = new MarcasAutosDAO();
/* 1293:1280 */       marcasAutoDAO.setServerNumber(servidor);
/* 1294:1281 */       CombustibleDAO combustibleDAO = new CombustibleDAO();
/* 1295:1282 */       combustibleDAO.setServerNumber(servidor);
/* 1296:1283 */       List vehiculos = vehiculosDAO.list(usuario.getUsuc_cod());
/* 1297:     */       
/* 1298:1285 */       HSSFRow row = null;
/* 1299:1286 */       HSSFCell cell = null;
/* 1300:     */       
/* 1301:1288 */       row = sheet.createRow(0);
/* 1302:     */       
/* 1303:1290 */       cell = row.createCell((short)0);
/* 1304:1291 */       cell.setCellValue(RES.getString("xls.vehi_placa"));
/* 1305:1292 */       cell.setCellStyle(boldStyle);
/* 1306:     */       
/* 1307:1294 */       cell = row.createCell((short)1);
/* 1308:1295 */       cell.setCellValue(RES.getString("xls.vehi_marca"));
/* 1309:1296 */       cell.setCellStyle(boldStyle);
/* 1310:     */       
/* 1311:1298 */       cell = row.createCell((short)2);
/* 1312:1299 */       cell.setCellValue(RES.getString("xls.combustible_fechaini"));
/* 1313:1300 */       cell.setCellStyle(boldStyle);
/* 1314:     */       
/* 1315:1302 */       cell = row.createCell((short)3);
/* 1316:1303 */       cell.setCellValue(RES.getString("xls.combustible_fechafin"));
/* 1317:1304 */       cell.setCellStyle(boldStyle);
/* 1318:     */       
/* 1319:1306 */       cell = row.createCell((short)4);
/* 1320:1307 */       cell.setCellValue(RES.getString("xls.combustible_lecturaini"));
/* 1321:1308 */       cell.setCellStyle(boldStyle);
/* 1322:     */       
/* 1323:1310 */       cell = row.createCell((short)5);
/* 1324:1311 */       cell.setCellValue(RES.getString("xls.combustible_lecturafin"));
/* 1325:1312 */       cell.setCellStyle(boldStyle);
/* 1326:     */       
/* 1327:1314 */       cell = row.createCell((short)6);
/* 1328:1315 */       cell.setCellValue(RES.getString("xls.combustible_cantidadconsumo"));
/* 1329:1316 */       cell.setCellStyle(boldStyle);
/* 1330:     */       
/* 1331:1318 */       cell = row.createCell((short)7);
/* 1332:1319 */       cell.setCellValue(RES.getString("xls.combustible_costocombustible"));
/* 1333:1320 */       cell.setCellStyle(boldStyle);
/* 1334:     */       
/* 1335:1322 */       int x = 1;
/* 1336:1323 */       int y = 0;
/* 1337:     */       
/* 1338:1325 */       Iterator it = vehiculos.iterator();
/* 1339:     */       do
/* 1340:     */       {
/* 1341:1327 */         Vehiculos vehiculo = (Vehiculos)it.next();
/* 1342:1328 */         MarcasAutos marcasAutos = marcasAutoDAO.retrive(vehiculo.getVehi_maut_cod());
/* 1343:1329 */         List combustibles = combustibleDAO.list(vehiculo.getVehi_cod());
/* 1344:     */         
/* 1345:1331 */         Iterator iterator = combustibles.iterator();
/* 1346:1332 */         while ((iterator != null) && (iterator.hasNext()))
/* 1347:     */         {
/* 1348:1333 */           Combustible combustible = (Combustible)iterator.next();
/* 1349:     */           
/* 1350:1335 */           row = sheet.createRow(x++);
/* 1351:1337 */           if (x == 2)
/* 1352:     */           {
/* 1353:1338 */             cell = row.createCell((short)y++);
/* 1354:1339 */             cell.setCellValue(vehiculo.getVehi_placa());
/* 1355:     */             
/* 1356:1341 */             cell = row.createCell((short)y++);
/* 1357:1342 */             cell.setCellValue(marcasAutos.getMaut_des());
/* 1358:     */           }
/* 1359:     */           else
/* 1360:     */           {
/* 1361:1344 */             y += 2;
/* 1362:     */           }
/* 1363:1347 */           cell = row.createCell((short)y++);
/* 1364:1348 */           cell.setCellValue(ManejoFechas.FormateoFecha(combustible.getCom_fechaini().toString()));
/* 1365:     */           
/* 1366:1350 */           cell = row.createCell((short)y++);
/* 1367:1351 */           cell.setCellValue(ManejoFechas.FormateoFecha(combustible.getCom_fechafin().toString()));
/* 1368:     */           
/* 1369:1353 */           cell = row.createCell((short)y++);
/* 1370:1354 */           cell.setCellValue(combustible.getCom_lecturaini().toString());
/* 1371:     */           
/* 1372:1356 */           cell = row.createCell((short)y++);
/* 1373:1357 */           cell.setCellValue(combustible.getCom_lecturafin().toString());
/* 1374:     */           
/* 1375:1359 */           cell = row.createCell((short)y++);
/* 1376:1360 */           cell.setCellValue(combustible.getCom_cantidadconsumo().toString());
/* 1377:     */           
/* 1378:1362 */           cell = row.createCell((short)y++);
/* 1379:1363 */           cell.setCellValue(combustible.getCom_costocombustible().toString());
/* 1380:     */           
/* 1381:1365 */           y = 0;
/* 1382:     */         }
/* 1383:1326 */         if (it == null) {
/* 1384:     */           break;
/* 1385:     */         }
/* 1386:1326 */       } while (it.hasNext());
/* 1387:     */     }
/* 1388:     */     catch (Exception e)
/* 1389:     */     {
/* 1390:1371 */       throw e;
/* 1391:     */     }
/* 1392:     */   }
/* 1393:     */   
/* 1394:     */   public static HSSFWorkbook getWb()
/* 1395:     */   {
/* 1396:1379 */     return wb;
/* 1397:     */   }
/* 1398:     */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdcars.dao.GestorHojasCalculoCars
 * JD-Core Version:    0.7.0.1
 */