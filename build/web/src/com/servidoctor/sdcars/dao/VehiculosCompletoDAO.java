/*   1:    */ package com.servidoctor.sdcars.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.constantes.IGrupos;
/*   5:    */ import com.servidoctor.parametros.dao.GastosVehiculosAnualesDAO;
/*   6:    */ import com.servidoctor.parametros.dao.GastosVehiculosMecanicaDAO;
/*   7:    */ import com.servidoctor.parametros.dao.GastosVehiculosNoAnualesDAO;
/*   8:    */ import com.servidoctor.parametros.dao.RevisionesVehiculoDAO;
/*   9:    */ import com.servidoctor.parametros.model.GastosVehiculosAnuales;
/*  10:    */ import com.servidoctor.parametros.model.GastosVehiculosMecanica;
/*  11:    */ import com.servidoctor.parametros.model.GastosVehiculosNoAnuales;
/*  12:    */ import com.servidoctor.parametros.model.RevisionesVehiculo;
/*  13:    */ import com.servidoctor.sdcars.model.Combustible;
/*  14:    */ import com.servidoctor.sdcars.model.ControlesVehiculos;
/*  15:    */ import com.servidoctor.sdcars.model.GruposVehiculo;
/*  16:    */ import com.servidoctor.sdcars.model.ImpuestoVehiculo;
/*  17:    */ import com.servidoctor.sdcars.model.MantenimientoGeneral;
/*  18:    */ import com.servidoctor.sdcars.model.PropietariosVehiculos;
/*  19:    */ import com.servidoctor.sdcars.model.SegurosVehiculos;
/*  20:    */ import com.servidoctor.sdcars.model.Vehiculos;
/*  21:    */ import com.servidoctor.sdcars.model.VehiculosCompleto;
/*  22:    */ import com.servidoctor.util.classes.InicializaData;
/*  23:    */ import java.math.BigDecimal;
/*  24:    */ import java.sql.Connection;
/*  25:    */ import java.util.Collection;
/*  26:    */ import java.util.HashMap;
/*  27:    */ import java.util.Iterator;
/*  28:    */ import java.util.List;
/*  29:    */ import java.util.Map;
/*  30:    */ import javax.sql.DataSource;
/*  31:    */ 
/*  32:    */ public class VehiculosCompletoDAO
/*  33:    */   extends DAO
/*  34:    */ {
/*  35:    */   public void update(VehiculosCompleto vehiculosCompleto, BigDecimal vehi_cod)
/*  36:    */     throws Exception
/*  37:    */   {
/*  38: 41 */     Connection conn = null;
/*  39:    */     try
/*  40:    */     {
/*  41: 45 */       conn = this.ds.getConnection();
/*  42: 46 */       conn.setAutoCommit(false);
/*  43:    */       
/*  44:    */ 
/*  45: 49 */       String[] llavesVehiculo = { "vehi_cod" };
/*  46: 50 */       VehiculosDAO vehiculosDAO = new VehiculosDAO();
/*  47: 51 */       vehiculosDAO.setServerNumber(this.serverNumber);
/*  48: 52 */       vehiculosDAO.update(vehiculosCompleto.getVehiculo(), llavesVehiculo, conn);
/*  49:    */       
/*  50:    */ 
/*  51: 55 */       String[] llavesPropietario = { "pveh_cod", "pveh_veh_cod" };
/*  52: 56 */       PropietariosVehiculosDAO propietariosVehiculosDAO = new PropietariosVehiculosDAO();
/*  53: 57 */       propietariosVehiculosDAO.setServerNumber(this.serverNumber);
/*  54: 58 */       propietariosVehiculosDAO.update(vehiculosCompleto.getPropietario(), llavesPropietario, conn);
/*  55:    */       
/*  56:    */ 
/*  57: 61 */       String[] llavesMantenimiento = { "mant_cod", "mant_veh_cod" };
/*  58: 62 */       MantenimientoGeneralDAO mantenimientoGeneralDAO = new MantenimientoGeneralDAO();
/*  59: 63 */       mantenimientoGeneralDAO.setServerNumber(this.serverNumber);
/*  60: 64 */       mantenimientoGeneralDAO.update(vehiculosCompleto.getMantenimientoGeneral(), llavesMantenimiento, conn);
/*  61:    */       
/*  62:    */ 
/*  63: 67 */       String[] llavesControles = { "cveh_cod", "cveh_veh_cod" };
/*  64: 68 */       ControlesVehiculosDAO controlesVehiculosDAO = new ControlesVehiculosDAO();
/*  65: 69 */       controlesVehiculosDAO.setServerNumber(this.serverNumber);
/*  66: 70 */       List controlesBase = controlesVehiculosDAO.list(vehi_cod);
/*  67:    */       
/*  68: 72 */       Map controlesBaseMap = new HashMap();
/*  69: 73 */       for (Iterator it = controlesBase.iterator(); it.hasNext();)
/*  70:    */       {
/*  71: 74 */         ControlesVehiculos controlesVehiculos = (ControlesVehiculos)it.next();
/*  72: 75 */         controlesBaseMap.put(controlesVehiculos.getCveh_cod(), controlesVehiculos);
/*  73:    */       }
/*  74: 78 */       for (Iterator it = vehiculosCompleto.getControles().iterator(); it.hasNext();)
/*  75:    */       {
/*  76: 79 */         ControlesVehiculos controlesVehiculos = (ControlesVehiculos)it.next();
/*  77: 80 */         if (controlesBaseMap.containsKey(controlesVehiculos.getCveh_cod()))
/*  78:    */         {
/*  79: 81 */           controlesVehiculosDAO.update(controlesVehiculos, llavesControles, conn);
/*  80: 82 */           controlesBaseMap.remove(controlesVehiculos.getCveh_cod());
/*  81:    */         }
/*  82:    */         else
/*  83:    */         {
/*  84: 84 */           controlesVehiculosDAO.insert(controlesVehiculos, conn);
/*  85:    */         }
/*  86:    */       }
/*  87: 88 */       for (Iterator it = controlesBaseMap.values().iterator(); it.hasNext();)
/*  88:    */       {
/*  89: 89 */         ControlesVehiculos controlesVehiculos = (ControlesVehiculos)it.next();
/*  90: 90 */         controlesVehiculosDAO.delete(controlesVehiculos, conn);
/*  91:    */       }
/*  92: 94 */       String[] llavesGastos = { "gasv_cod", "gasv_veh_cod" };
/*  93: 95 */       GastosVehiculosAnualesDAO gastosVehiculosAnualesDAO = new GastosVehiculosAnualesDAO();
/*  94: 96 */       gastosVehiculosAnualesDAO.setServerNumber(this.serverNumber);
/*  95: 97 */       List gastosAnualesBase = gastosVehiculosAnualesDAO.list(vehi_cod);
/*  96:    */       
/*  97: 99 */       Map gastosAnualesBaseMap = new HashMap();
/*  98:100 */       for (Iterator it = gastosAnualesBase.iterator(); it.hasNext();)
/*  99:    */       {
/* 100:101 */         GastosVehiculosAnuales gastosVehiculosAnuales = (GastosVehiculosAnuales)it.next();
/* 101:102 */         gastosAnualesBaseMap.put(gastosVehiculosAnuales.getGasv_cod(), gastosVehiculosAnuales);
/* 102:    */       }
/* 103:105 */       for (Iterator it = vehiculosCompleto.getGastosAnuales().iterator(); it.hasNext();)
/* 104:    */       {
/* 105:106 */         GastosVehiculosAnuales gastosVehiculosAnuales = (GastosVehiculosAnuales)it.next();
/* 106:107 */         if (gastosAnualesBaseMap.containsKey(gastosVehiculosAnuales.getGasv_cod()))
/* 107:    */         {
/* 108:108 */           gastosVehiculosAnualesDAO.update(gastosVehiculosAnuales, llavesGastos, conn);
/* 109:109 */           gastosAnualesBaseMap.remove(gastosVehiculosAnuales.getGasv_cod());
/* 110:    */         }
/* 111:    */         else
/* 112:    */         {
/* 113:111 */           gastosVehiculosAnualesDAO.insert(gastosVehiculosAnuales, conn);
/* 114:    */         }
/* 115:    */       }
/* 116:115 */       for (Iterator it = gastosAnualesBaseMap.values().iterator(); it.hasNext();)
/* 117:    */       {
/* 118:116 */         GastosVehiculosAnuales gastosVehiculosAnuales = (GastosVehiculosAnuales)it.next();
/* 119:117 */         gastosVehiculosAnualesDAO.delete(gastosVehiculosAnuales, conn);
/* 120:    */       }
/* 121:121 */       GastosVehiculosNoAnualesDAO gastosVehiculosNoAnualesDAO = new GastosVehiculosNoAnualesDAO();
/* 122:122 */       gastosVehiculosNoAnualesDAO.setServerNumber(this.serverNumber);
/* 123:123 */       List gastosNoAnualesBase = gastosVehiculosNoAnualesDAO.list(vehi_cod);
/* 124:    */       
/* 125:125 */       Map gastosNoAnualesBaseMap = new HashMap();
/* 126:126 */       for (Iterator it = gastosNoAnualesBase.iterator(); it.hasNext();)
/* 127:    */       {
/* 128:127 */         GastosVehiculosNoAnuales gastosVehiculosNoAnuales = (GastosVehiculosNoAnuales)it.next();
/* 129:128 */         gastosNoAnualesBaseMap.put(gastosVehiculosNoAnuales.getGasv_cod(), gastosVehiculosNoAnuales);
/* 130:    */       }
/* 131:131 */       for (Iterator it = vehiculosCompleto.getGastosNoAnuales().iterator(); it.hasNext();)
/* 132:    */       {
/* 133:132 */         GastosVehiculosNoAnuales gastosVehiculosNoAnuales = (GastosVehiculosNoAnuales)it.next();
/* 134:133 */         if (gastosNoAnualesBaseMap.containsKey(gastosVehiculosNoAnuales.getGasv_cod()))
/* 135:    */         {
/* 136:134 */           gastosVehiculosNoAnualesDAO.update(gastosVehiculosNoAnuales, llavesGastos, conn);
/* 137:135 */           gastosNoAnualesBaseMap.remove(gastosVehiculosNoAnuales.getGasv_cod());
/* 138:    */         }
/* 139:    */         else
/* 140:    */         {
/* 141:137 */           gastosVehiculosNoAnualesDAO.insert(gastosVehiculosNoAnuales, conn);
/* 142:    */         }
/* 143:    */       }
/* 144:141 */       for (Iterator it = gastosNoAnualesBaseMap.values().iterator(); it.hasNext();)
/* 145:    */       {
/* 146:142 */         GastosVehiculosNoAnuales gastosVehiculosNoAnuales = (GastosVehiculosNoAnuales)it.next();
/* 147:143 */         gastosVehiculosNoAnualesDAO.delete(gastosVehiculosNoAnuales, conn);
/* 148:    */       }
/* 149:147 */       GastosVehiculosMecanicaDAO gastosVehiculosMecanicaDAO = new GastosVehiculosMecanicaDAO();
/* 150:148 */       gastosVehiculosMecanicaDAO.setServerNumber(this.serverNumber);
/* 151:149 */       List gastosMecanicaBase = gastosVehiculosMecanicaDAO.list(vehi_cod);
/* 152:    */       
/* 153:151 */       Map gastosMecanicaBaseMap = new HashMap();
/* 154:152 */       for (Iterator it = gastosMecanicaBase.iterator(); it.hasNext();)
/* 155:    */       {
/* 156:153 */         GastosVehiculosMecanica gastosVehiculosMecanica = (GastosVehiculosMecanica)it.next();
/* 157:154 */         gastosMecanicaBaseMap.put(gastosVehiculosMecanica.getGasv_cod(), gastosVehiculosMecanica);
/* 158:    */       }
/* 159:157 */       for (Iterator it = vehiculosCompleto.getGastosMecanica().iterator(); it.hasNext();)
/* 160:    */       {
/* 161:158 */         GastosVehiculosMecanica gastosVehiculosMecanica = (GastosVehiculosMecanica)it.next();
/* 162:159 */         if (gastosMecanicaBaseMap.containsKey(gastosVehiculosMecanica.getGasv_cod()))
/* 163:    */         {
/* 164:160 */           gastosVehiculosMecanicaDAO.update(gastosVehiculosMecanica, llavesGastos, conn);
/* 165:161 */           gastosMecanicaBaseMap.remove(gastosVehiculosMecanica.getGasv_cod());
/* 166:    */         }
/* 167:    */         else
/* 168:    */         {
/* 169:163 */           gastosVehiculosMecanicaDAO.insert(gastosVehiculosMecanica, conn);
/* 170:    */         }
/* 171:    */       }
/* 172:167 */       for (Iterator it = gastosMecanicaBaseMap.values().iterator(); it.hasNext();)
/* 173:    */       {
/* 174:168 */         GastosVehiculosMecanica gastosVehiculosMecanica = (GastosVehiculosMecanica)it.next();
/* 175:169 */         gastosVehiculosMecanicaDAO.delete(gastosVehiculosMecanica, conn);
/* 176:    */       }
/* 177:173 */       String[] llavesImpuestos = { "impv_cod", "impv_veh_cod" };
/* 178:174 */       ImpuestoVehiculoDAO impuestoVehiculoDAO = new ImpuestoVehiculoDAO();
/* 179:175 */       impuestoVehiculoDAO.setServerNumber(this.serverNumber);
/* 180:176 */       List impuestosBase = impuestoVehiculoDAO.list(vehi_cod);
/* 181:    */       
/* 182:178 */       Map impuestosBaseMap = new HashMap();
/* 183:179 */       for (Iterator it = impuestosBase.iterator(); it.hasNext();)
/* 184:    */       {
/* 185:180 */         ImpuestoVehiculo impuestoVehiculo = (ImpuestoVehiculo)it.next();
/* 186:181 */         impuestosBaseMap.put(impuestoVehiculo.getImpv_cod(), impuestoVehiculo);
/* 187:    */       }
/* 188:184 */       for (Iterator it = vehiculosCompleto.getImpuestos().iterator(); it.hasNext();)
/* 189:    */       {
/* 190:185 */         ImpuestoVehiculo impuestoVehiculo = (ImpuestoVehiculo)it.next();
/* 191:186 */         if (impuestosBaseMap.containsKey(impuestoVehiculo.getImpv_cod()))
/* 192:    */         {
/* 193:187 */           impuestoVehiculoDAO.update(impuestoVehiculo, llavesImpuestos, conn);
/* 194:188 */           impuestosBaseMap.remove(impuestoVehiculo.getImpv_cod());
/* 195:    */         }
/* 196:    */         else
/* 197:    */         {
/* 198:190 */           impuestoVehiculoDAO.insert(impuestoVehiculo, conn);
/* 199:    */         }
/* 200:    */       }
/* 201:194 */       for (Iterator it = impuestosBaseMap.values().iterator(); it.hasNext();)
/* 202:    */       {
/* 203:195 */         ImpuestoVehiculo impuestoVehiculo = (ImpuestoVehiculo)it.next();
/* 204:196 */         impuestoVehiculoDAO.delete(impuestoVehiculo, conn);
/* 205:    */       }
/* 206:200 */       String[] llavesCombustible = { "com_cod", "com_veh_cod" };
/* 207:201 */       CombustibleDAO combustibleDAO = new CombustibleDAO();
/* 208:202 */       combustibleDAO.setServerNumber(this.serverNumber);
/* 209:203 */       List consumosCombustibleBase = combustibleDAO.list(vehi_cod);
/* 210:    */       
/* 211:205 */       Map consumosCombustibleBaseMap = new HashMap();
/* 212:206 */       for (Iterator it = consumosCombustibleBase.iterator(); it.hasNext();)
/* 213:    */       {
/* 214:207 */         Combustible combustible = (Combustible)it.next();
/* 215:208 */         consumosCombustibleBaseMap.put(combustible.getCom_cod(), combustible);
/* 216:    */       }
/* 217:211 */       for (Iterator it = vehiculosCompleto.getConsumosCombustible().iterator(); it.hasNext();)
/* 218:    */       {
/* 219:212 */         Combustible combustible = (Combustible)it.next();
/* 220:213 */         if (consumosCombustibleBaseMap.containsKey(combustible.getCom_cod()))
/* 221:    */         {
/* 222:214 */           combustibleDAO.update(combustible, llavesCombustible, conn);
/* 223:215 */           consumosCombustibleBaseMap.remove(combustible.getCom_cod());
/* 224:    */         }
/* 225:    */         else
/* 226:    */         {
/* 227:217 */           combustibleDAO.insert(combustible, conn);
/* 228:    */         }
/* 229:    */       }
/* 230:221 */       for (Iterator it = consumosCombustibleBaseMap.values().iterator(); it.hasNext();)
/* 231:    */       {
/* 232:222 */         Combustible combustible = (Combustible)it.next();
/* 233:223 */         combustibleDAO.delete(combustible, conn);
/* 234:    */       }
/* 235:227 */       String[] llavesRevisiones = { "rveh_cod", "rveh_veh_cod" };
/* 236:228 */       RevisionesVehiculoDAO revisionesVehiculoDAO = new RevisionesVehiculoDAO();
/* 237:229 */       revisionesVehiculoDAO.setServerNumber(this.serverNumber);
/* 238:230 */       List revisionesBase = revisionesVehiculoDAO.list(vehi_cod);
/* 239:    */       
/* 240:232 */       Map revisionesBaseMap = new HashMap();
/* 241:233 */       for (Iterator it = revisionesBase.iterator(); it.hasNext();)
/* 242:    */       {
/* 243:234 */         RevisionesVehiculo revisionesVehiculo = (RevisionesVehiculo)it.next();
/* 244:235 */         revisionesBaseMap.put(revisionesVehiculo.getRveh_cod(), revisionesVehiculo);
/* 245:    */       }
/* 246:238 */       for (Iterator it = vehiculosCompleto.getRevisiones().iterator(); it.hasNext();)
/* 247:    */       {
/* 248:239 */         RevisionesVehiculo revisionesVehiculo = (RevisionesVehiculo)it.next();
/* 249:240 */         if (revisionesBaseMap.containsKey(revisionesVehiculo.getRveh_cod()))
/* 250:    */         {
/* 251:241 */           revisionesVehiculoDAO.update(revisionesVehiculo, llavesRevisiones, conn);
/* 252:242 */           revisionesBaseMap.remove(revisionesVehiculo.getRveh_cod());
/* 253:    */         }
/* 254:    */         else
/* 255:    */         {
/* 256:244 */           revisionesVehiculoDAO.insert(revisionesVehiculo, conn);
/* 257:    */         }
/* 258:    */       }
/* 259:248 */       for (Iterator it = revisionesBaseMap.values().iterator(); it.hasNext();)
/* 260:    */       {
/* 261:249 */         RevisionesVehiculo revisionesVehiculo = (RevisionesVehiculo)it.next();
/* 262:250 */         revisionesVehiculoDAO.delete(revisionesVehiculo, conn);
/* 263:    */       }
/* 264:254 */       String[] llavesSeguros = { "sveh_cod", "sveh_veh_cod" };
/* 265:255 */       SegurosVehiculosDAO segurosVehiculosDAO = new SegurosVehiculosDAO();
/* 266:256 */       segurosVehiculosDAO.setServerNumber(this.serverNumber);
/* 267:257 */       List segurosBase = segurosVehiculosDAO.list(vehi_cod);
/* 268:    */       
/* 269:259 */       Map segurosBaseMap = new HashMap();
/* 270:260 */       for (Iterator it = segurosBase.iterator(); it.hasNext();)
/* 271:    */       {
/* 272:261 */         SegurosVehiculos segurosVehiculos = (SegurosVehiculos)it.next();
/* 273:262 */         segurosBaseMap.put(segurosVehiculos.getSveh_cod(), segurosVehiculos);
/* 274:    */       }
/* 275:265 */       for (Iterator it = vehiculosCompleto.getSeguros().iterator(); it.hasNext();)
/* 276:    */       {
/* 277:266 */         SegurosVehiculos segurosVehiculos = (SegurosVehiculos)it.next();
/* 278:267 */         if (segurosBaseMap.containsKey(segurosVehiculos.getSveh_cod()))
/* 279:    */         {
/* 280:268 */           segurosVehiculosDAO.update(segurosVehiculos, llavesSeguros, conn);
/* 281:269 */           segurosBaseMap.remove(segurosVehiculos.getSveh_cod());
/* 282:    */         }
/* 283:    */         else
/* 284:    */         {
/* 285:271 */           segurosVehiculosDAO.insert(segurosVehiculos, conn);
/* 286:    */         }
/* 287:    */       }
/* 288:275 */       for (Iterator it = segurosBaseMap.values().iterator(); it.hasNext();)
/* 289:    */       {
/* 290:276 */         SegurosVehiculos segurosVehiculos = (SegurosVehiculos)it.next();
/* 291:277 */         segurosVehiculosDAO.delete(segurosVehiculos, conn);
/* 292:    */       }
/* 293:280 */       conn.commit();
/* 294:    */     }
/* 295:    */     catch (Exception e)
/* 296:    */     {
/* 297:283 */       rollback(conn);
/* 298:284 */       throw e;
/* 299:    */     }
/* 300:    */     finally
/* 301:    */     {
/* 302:286 */       close(conn);
/* 303:    */     }
/* 304:    */   }
/* 305:    */   
/* 306:    */   public VehiculosCompleto retrieve(BigDecimal vehi_cod)
/* 307:    */     throws Exception
/* 308:    */   {
/* 309:292 */     VehiculosCompleto vehiculosCompleto = new VehiculosCompleto();
/* 310:    */     try
/* 311:    */     {
/* 312:297 */       VehiculosDAO vehiculosDAO = new VehiculosDAO();
/* 313:298 */       vehiculosDAO.setServerNumber(this.serverNumber);
/* 314:299 */       vehiculosCompleto.setVehiculo(vehiculosDAO.retrive(vehi_cod));
/* 315:    */       
/* 316:    */ 
/* 317:302 */       PropietariosVehiculosDAO propietariosVehiculosDAO = new PropietariosVehiculosDAO();
/* 318:303 */       propietariosVehiculosDAO.setServerNumber(this.serverNumber);
/* 319:304 */       vehiculosCompleto.setPropietario((PropietariosVehiculos)propietariosVehiculosDAO.list(vehi_cod).get(0));
/* 320:    */       
/* 321:    */ 
/* 322:307 */       MantenimientoGeneralDAO mantenimientoGeneralDAO = new MantenimientoGeneralDAO();
/* 323:308 */       mantenimientoGeneralDAO.setServerNumber(this.serverNumber);
/* 324:309 */       vehiculosCompleto.setMantenimientoGeneral((MantenimientoGeneral)mantenimientoGeneralDAO.list(vehi_cod).get(0));
/* 325:    */       
/* 326:    */ 
/* 327:312 */       ControlesVehiculosDAO controlesVehiculosDAO = new ControlesVehiculosDAO();
/* 328:313 */       controlesVehiculosDAO.setServerNumber(this.serverNumber);
/* 329:314 */       vehiculosCompleto.setControles(controlesVehiculosDAO.list(vehi_cod));
/* 330:    */       
/* 331:    */ 
/* 332:317 */       GastosVehiculosAnualesDAO gastosVehiculosAnualesDAO = new GastosVehiculosAnualesDAO();
/* 333:318 */       gastosVehiculosAnualesDAO.setServerNumber(this.serverNumber);
/* 334:319 */       vehiculosCompleto.setGastosAnuales(gastosVehiculosAnualesDAO.list(vehi_cod));
/* 335:    */       
/* 336:    */ 
/* 337:322 */       GastosVehiculosNoAnualesDAO gastosVehiculosNoAnualesDAO = new GastosVehiculosNoAnualesDAO();
/* 338:323 */       gastosVehiculosNoAnualesDAO.setServerNumber(this.serverNumber);
/* 339:324 */       vehiculosCompleto.setGastosNoAnuales(gastosVehiculosNoAnualesDAO.list(vehi_cod));
/* 340:    */       
/* 341:    */ 
/* 342:327 */       GastosVehiculosMecanicaDAO gastosVehiculosMecanicaDAO = new GastosVehiculosMecanicaDAO();
/* 343:328 */       gastosVehiculosMecanicaDAO.setServerNumber(this.serverNumber);
/* 344:329 */       vehiculosCompleto.setGastosMecanica(gastosVehiculosMecanicaDAO.list(vehi_cod));
/* 345:    */       
/* 346:    */ 
/* 347:332 */       ImpuestoVehiculoDAO impuestoVehiculoDAO = new ImpuestoVehiculoDAO();
/* 348:333 */       impuestoVehiculoDAO.setServerNumber(this.serverNumber);
/* 349:334 */       vehiculosCompleto.setImpuestos(impuestoVehiculoDAO.list(vehi_cod));
/* 350:    */       
/* 351:    */ 
/* 352:337 */       CombustibleDAO combustibleDAO = new CombustibleDAO();
/* 353:338 */       combustibleDAO.setServerNumber(this.serverNumber);
/* 354:339 */       vehiculosCompleto.setConsumosCombustible(combustibleDAO.list(vehi_cod));
/* 355:    */       
/* 356:    */ 
/* 357:342 */       RevisionesVehiculoDAO revisionesVehiculoDAO = new RevisionesVehiculoDAO();
/* 358:343 */       revisionesVehiculoDAO.setServerNumber(this.serverNumber);
/* 359:344 */       vehiculosCompleto.setRevisiones(revisionesVehiculoDAO.list(vehi_cod));
/* 360:    */       
/* 361:    */ 
/* 362:347 */       SegurosVehiculosDAO segurosVehiculosDAO = new SegurosVehiculosDAO();
/* 363:348 */       segurosVehiculosDAO.setServerNumber(this.serverNumber);
/* 364:349 */       vehiculosCompleto.setSeguros(segurosVehiculosDAO.list(vehi_cod));
/* 365:    */     }
/* 366:    */     catch (Exception e)
/* 367:    */     {
/* 368:352 */       throw e;
/* 369:    */     }
/* 370:355 */     return vehiculosCompleto;
/* 371:    */   }
/* 372:    */   
/* 373:    */   public void delete(BigDecimal vehi_cod)
/* 374:    */     throws Exception
/* 375:    */   {
/* 376:360 */     Connection conn = null;
/* 377:    */     try
/* 378:    */     {
/* 379:364 */       conn = this.ds.getConnection();
/* 380:365 */       conn.setAutoCommit(false);
/* 381:    */       
/* 382:    */ 
/* 383:368 */       VehiculosDAO vehiculosDAO = new VehiculosDAO();
/* 384:369 */       vehiculosDAO.setServerNumber(this.serverNumber);
/* 385:370 */       vehiculosDAO.delete(vehi_cod, conn);
/* 386:    */       
/* 387:    */ 
/* 388:373 */       PropietariosVehiculosDAO propietariosVehiculosDAO = new PropietariosVehiculosDAO();
/* 389:374 */       propietariosVehiculosDAO.setServerNumber(this.serverNumber);
/* 390:375 */       propietariosVehiculosDAO.deleteAll(vehi_cod, conn);
/* 391:    */       
/* 392:    */ 
/* 393:378 */       MantenimientoGeneralDAO mantenimientoGeneralDAO = new MantenimientoGeneralDAO();
/* 394:379 */       mantenimientoGeneralDAO.setServerNumber(this.serverNumber);
/* 395:380 */       mantenimientoGeneralDAO.deleteAll(vehi_cod, conn);
/* 396:    */       
/* 397:    */ 
/* 398:383 */       ControlesVehiculosDAO controlesVehiculosDAO = new ControlesVehiculosDAO();
/* 399:384 */       controlesVehiculosDAO.setServerNumber(this.serverNumber);
/* 400:385 */       controlesVehiculosDAO.deleteAll(vehi_cod, conn);
/* 401:    */       
/* 402:    */ 
/* 403:388 */       GastosVehiculosAnualesDAO gastosVehiculosAnualesDAO = new GastosVehiculosAnualesDAO();
/* 404:389 */       gastosVehiculosAnualesDAO.deleteAll(vehi_cod, conn);
/* 405:    */       
/* 406:    */ 
/* 407:392 */       GastosVehiculosNoAnualesDAO gastosVehiculosNoAnualesDAO = new GastosVehiculosNoAnualesDAO();
/* 408:393 */       gastosVehiculosNoAnualesDAO.setServerNumber(this.serverNumber);
/* 409:394 */       gastosVehiculosNoAnualesDAO.deleteAll(vehi_cod, conn);
/* 410:    */       
/* 411:    */ 
/* 412:397 */       GastosVehiculosMecanicaDAO gastosVehiculosMecanicaDAO = new GastosVehiculosMecanicaDAO();
/* 413:398 */       gastosVehiculosMecanicaDAO.setServerNumber(this.serverNumber);
/* 414:399 */       gastosVehiculosMecanicaDAO.deleteAll(vehi_cod, conn);
/* 415:    */       
/* 416:    */ 
/* 417:402 */       ImpuestoVehiculoDAO impuestoVehiculoDAO = new ImpuestoVehiculoDAO();
/* 418:403 */       impuestoVehiculoDAO.setServerNumber(this.serverNumber);
/* 419:404 */       impuestoVehiculoDAO.deleteAll(vehi_cod, conn);
/* 420:    */       
/* 421:    */ 
/* 422:407 */       CombustibleDAO combustibleDAO = new CombustibleDAO();
/* 423:408 */       combustibleDAO.setServerNumber(this.serverNumber);
/* 424:409 */       combustibleDAO.deleteAll(vehi_cod, conn);
/* 425:    */       
/* 426:    */ 
/* 427:412 */       RevisionesVehiculoDAO revisionesVehiculoDAO = new RevisionesVehiculoDAO();
/* 428:413 */       revisionesVehiculoDAO.setServerNumber(this.serverNumber);
/* 429:414 */       revisionesVehiculoDAO.deleteAll(vehi_cod, conn);
/* 430:    */       
/* 431:    */ 
/* 432:417 */       SegurosVehiculosDAO segurosVehiculosDAO = new SegurosVehiculosDAO();
/* 433:418 */       segurosVehiculosDAO.setServerNumber(this.serverNumber);
/* 434:419 */       segurosVehiculosDAO.deleteAll(vehi_cod, conn);
/* 435:    */       
/* 436:    */ 
/* 437:422 */       GruposVehiculoDAO gruposVehiculoDAO = new GruposVehiculoDAO();
/* 438:423 */       gruposVehiculoDAO.setServerNumber(this.serverNumber);
/* 439:424 */       gruposVehiculoDAO.deleteAll(vehi_cod, conn);
/* 440:    */       
/* 441:426 */       conn.commit();
/* 442:    */     }
/* 443:    */     catch (Exception e)
/* 444:    */     {
/* 445:429 */       rollback(conn);
/* 446:430 */       throw e;
/* 447:    */     }
/* 448:    */     finally
/* 449:    */     {
/* 450:432 */       close(conn);
/* 451:    */     }
/* 452:    */   }
/* 453:    */   
/* 454:    */   public void insert(VehiculosCompleto vehiculosCompleto)
/* 455:    */     throws Exception
/* 456:    */   {
/* 457:438 */     Connection conn = null;
/* 458:    */     try
/* 459:    */     {
/* 460:442 */       conn = this.ds.getConnection();
/* 461:443 */       conn.setAutoCommit(false);
/* 462:    */       
/* 463:    */ 
/* 464:446 */       VehiculosDAO vehiculosDAO = new VehiculosDAO();
/* 465:447 */       vehiculosDAO.setServerNumber(this.serverNumber);
/* 466:448 */       vehiculosDAO.insert(vehiculosCompleto.getVehiculo(), conn);
/* 467:    */       
/* 468:450 */       BigDecimal vehi_cod = vehiculosCompleto.getVehiculo().getVehi_cod();
/* 469:    */       
/* 470:    */ 
/* 471:453 */       PropietariosVehiculosDAO propietariosVehiculosDAO = new PropietariosVehiculosDAO();
/* 472:454 */       propietariosVehiculosDAO.setServerNumber(this.serverNumber);
/* 473:455 */       vehiculosCompleto.getPropietario().setPveh_veh_cod(vehiculosCompleto.getVehiculo().getVehi_cod());
/* 474:456 */       propietariosVehiculosDAO.insert(vehiculosCompleto.getPropietario(), conn);
/* 475:    */       
/* 476:    */ 
/* 477:459 */       MantenimientoGeneralDAO mantenimientoGeneralDAO = new MantenimientoGeneralDAO();
/* 478:460 */       mantenimientoGeneralDAO.setServerNumber(this.serverNumber);
/* 479:461 */       vehiculosCompleto.getMantenimientoGeneral().setMant_veh_cod(vehiculosCompleto.getVehiculo().getVehi_cod());
/* 480:462 */       mantenimientoGeneralDAO.insert(vehiculosCompleto.getMantenimientoGeneral(), conn);
/* 481:    */       
/* 482:    */ 
/* 483:    */ 
/* 484:    */ 
/* 485:    */ 
/* 486:468 */       GastosVehiculosAnualesDAO gastosVehiculosAnualesDAO = new GastosVehiculosAnualesDAO();
/* 487:469 */       gastosVehiculosAnualesDAO.setServerNumber(this.serverNumber);
/* 488:470 */       for (Iterator it = vehiculosCompleto.getGastosAnuales().iterator(); it.hasNext();)
/* 489:    */       {
/* 490:471 */         GastosVehiculosAnuales gastosVehiculosAnuales = (GastosVehiculosAnuales)it.next();
/* 491:472 */         gastosVehiculosAnuales.setGasv_veh_cod(vehi_cod);
/* 492:473 */         gastosVehiculosAnualesDAO.insert(gastosVehiculosAnuales, conn);
/* 493:    */       }
/* 494:478 */       GastosVehiculosNoAnualesDAO gastosVehiculosNoAnualesDAO = new GastosVehiculosNoAnualesDAO();
/* 495:479 */       gastosVehiculosNoAnualesDAO.setServerNumber(this.serverNumber);
/* 496:480 */       for (Iterator it = vehiculosCompleto.getGastosNoAnuales().iterator(); it.hasNext();)
/* 497:    */       {
/* 498:481 */         GastosVehiculosNoAnuales gastosVehiculosNoAnuales = (GastosVehiculosNoAnuales)it.next();
/* 499:482 */         gastosVehiculosNoAnuales.setGasv_veh_cod(vehi_cod);
/* 500:483 */         gastosVehiculosNoAnualesDAO.insert(gastosVehiculosNoAnuales, conn);
/* 501:    */       }
/* 502:488 */       GastosVehiculosMecanicaDAO gastosVehiculosMecanicaDAO = new GastosVehiculosMecanicaDAO();
/* 503:489 */       gastosVehiculosMecanicaDAO.setServerNumber(this.serverNumber);
/* 504:490 */       for (Iterator it = vehiculosCompleto.getGastosMecanica().iterator(); it.hasNext();)
/* 505:    */       {
/* 506:491 */         GastosVehiculosMecanica gastosVehiculosMecanica = (GastosVehiculosMecanica)it.next();
/* 507:492 */         gastosVehiculosMecanica.setGasv_veh_cod(vehi_cod);
/* 508:493 */         gastosVehiculosMecanicaDAO.insert(gastosVehiculosMecanica, conn);
/* 509:    */       }
/* 510:499 */       RevisionesVehiculoDAO revisionesVehiculoDAO = new RevisionesVehiculoDAO();
/* 511:500 */       revisionesVehiculoDAO.setServerNumber(this.serverNumber);
/* 512:501 */       for (Iterator it = vehiculosCompleto.getRevisiones().iterator(); it.hasNext();)
/* 513:    */       {
/* 514:502 */         RevisionesVehiculo revisionesVehiculo = (RevisionesVehiculo)it.next();
/* 515:503 */         revisionesVehiculo.setRveh_veh_cod(vehi_cod);
/* 516:504 */         revisionesVehiculoDAO.insert(revisionesVehiculo, conn);
/* 517:    */       }
/* 518:512 */       GruposVehiculoDAO gruposVehiculoDAO = new GruposVehiculoDAO();
/* 519:513 */       gruposVehiculoDAO.setServerNumber(this.serverNumber);
/* 520:514 */       GruposVehiculo gruposVehiculo = new GruposVehiculo();
/* 521:515 */       BigDecimal dias_anticipacion = new BigDecimal(20);
/* 522:516 */       for (int i = 0; i < 3; i++)
/* 523:    */       {
/* 524:517 */         InicializaData.inicializa(gruposVehiculo.getClass(), gruposVehiculo);
/* 525:518 */         switch (i)
/* 526:    */         {
/* 527:    */         case 0: 
/* 528:520 */           gruposVehiculo.setGrupv_dias_antes(dias_anticipacion);
/* 529:521 */           gruposVehiculo.setGrupv_grup_cod(IGrupos.CARS_CONTROLES);
/* 530:522 */           break;
/* 531:    */         case 1: 
/* 532:524 */           gruposVehiculo.setGrupv_dias_antes(dias_anticipacion);
/* 533:525 */           gruposVehiculo.setGrupv_grup_cod(IGrupos.CARS_SEGUROS);
/* 534:526 */           break;
/* 535:    */         case 2: 
/* 536:528 */           gruposVehiculo.setGrupv_dias_antes(dias_anticipacion);
/* 537:529 */           gruposVehiculo.setGrupv_grup_cod(IGrupos.CARS_IMPUESTOS);
/* 538:    */         }
/* 539:532 */         gruposVehiculo.setGrupv_vehi_cod(vehiculosCompleto.getVehiculo().getVehi_cod());
/* 540:533 */         gruposVehiculoDAO.insert(gruposVehiculo, conn);
/* 541:    */       }
/* 542:536 */       conn.commit();
/* 543:    */     }
/* 544:    */     catch (Exception e)
/* 545:    */     {
/* 546:539 */       rollback(conn);
/* 547:540 */       throw e;
/* 548:    */     }
/* 549:    */     finally
/* 550:    */     {
/* 551:542 */       close(conn);
/* 552:    */     }
/* 553:    */   }
/* 554:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdcars.dao.VehiculosCompletoDAO
 * JD-Core Version:    0.7.0.1
 */