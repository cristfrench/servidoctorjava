/*   1:    */ package com.servidoctor.sdfamily.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.parametros.dao.AlergiasDAO;
/*   5:    */ import com.servidoctor.parametros.dao.AntecedentesDAO;
/*   6:    */ import com.servidoctor.parametros.dao.CirujiasDAO;
/*   7:    */ import com.servidoctor.parametros.dao.ElementoConsumoDAO;
/*   8:    */ import com.servidoctor.parametros.dao.EnfermedadesDAO;
/*   9:    */ import com.servidoctor.parametros.dao.GinecologiaOperacionesDAO;
/*  10:    */ import com.servidoctor.parametros.dao.PartesCuerpoDAO;
/*  11:    */ import com.servidoctor.sdfamily.model.AlergiasUsuario;
/*  12:    */ import com.servidoctor.sdfamily.model.AntecedentesUsuario;
/*  13:    */ import com.servidoctor.sdfamily.model.CirujiasUsuario;
/*  14:    */ import com.servidoctor.sdfamily.model.ElementoConsumoUsuario;
/*  15:    */ import com.servidoctor.sdfamily.model.EnfermedadesUsuario;
/*  16:    */ import com.servidoctor.sdfamily.model.Ginecologia;
/*  17:    */ import com.servidoctor.sdfamily.model.GinecologiaOperacionesUsuario;
/*  18:    */ import com.servidoctor.sdfamily.model.HistoriaMedica;
/*  19:    */ import com.servidoctor.sdfamily.model.PartesCuerpoUsuario;
/*  20:    */ import com.servidoctor.sdfamily.model.UsuarioMedicamentos;
/*  21:    */ import java.math.BigDecimal;
/*  22:    */ import java.sql.Connection;
/*  23:    */ import java.util.Collection;
/*  24:    */ import java.util.HashMap;
/*  25:    */ import java.util.Iterator;
/*  26:    */ import java.util.List;
/*  27:    */ import java.util.Map;
/*  28:    */ import javax.sql.DataSource;
/*  29:    */ 
/*  30:    */ public class HistoriaMedicaDAO
/*  31:    */   extends DAO
/*  32:    */ {
/*  33:    */   public void update(HistoriaMedica historiaMedica, BigDecimal usuf_cod, String sexo)
/*  34:    */     throws Exception
/*  35:    */   {
/*  36: 39 */     update(historiaMedica, usuf_cod, sexo, null);
/*  37:    */   }
/*  38:    */   
/*  39:    */   public void update(HistoriaMedica historiaMedica, BigDecimal usuf_cod, String sexo, Connection conn)
/*  40:    */     throws Exception
/*  41:    */   {
/*  42: 44 */     boolean manejado = conn != null;
/*  43:    */     try
/*  44:    */     {
/*  45: 48 */       if (!manejado)
/*  46:    */       {
/*  47: 49 */         conn = this.ds.getConnection();
/*  48: 50 */         conn.setAutoCommit(false);
/*  49:    */       }
/*  50: 55 */       String[] llavesElementoConsumo = { "econu_cod", "econu_usuf_cod" };
/*  51: 56 */       ElementoConsumoUsuarioDAO elementoConsumoUsuarioDAO = new ElementoConsumoUsuarioDAO();
/*  52: 57 */       elementoConsumoUsuarioDAO.setServerNumber(this.serverNumber);
/*  53: 58 */       List elementosConsumoBase = elementoConsumoUsuarioDAO.list(usuf_cod);
/*  54:    */       
/*  55: 60 */       Map elementosConsumoBaseMap = new HashMap();
/*  56: 61 */       for (Iterator it = elementosConsumoBase.iterator(); it.hasNext();)
/*  57:    */       {
/*  58: 62 */         ElementoConsumoUsuario elementoConsumoUsuario = (ElementoConsumoUsuario)it.next();
/*  59: 63 */         elementosConsumoBaseMap.put(elementoConsumoUsuario.getEconu_cod(), elementoConsumoUsuario);
/*  60:    */       }
/*  61: 66 */       for (Iterator it = historiaMedica.getElementosConsumoUsuario().iterator(); it.hasNext();)
/*  62:    */       {
/*  63: 67 */         ElementoConsumoUsuario elementoConsumoUsuario = (ElementoConsumoUsuario)it.next();
/*  64: 68 */         elementoConsumoUsuario.setEconu_usuf_cod(usuf_cod);
/*  65: 69 */         if (elementosConsumoBaseMap.containsKey(elementoConsumoUsuario.getEconu_cod()))
/*  66:    */         {
/*  67: 70 */           elementoConsumoUsuarioDAO.update(elementoConsumoUsuario, llavesElementoConsumo, conn);
/*  68: 71 */           elementosConsumoBaseMap.remove(elementoConsumoUsuario.getEconu_cod());
/*  69:    */         }
/*  70:    */         else
/*  71:    */         {
/*  72: 73 */           elementoConsumoUsuarioDAO.insert(elementoConsumoUsuario, conn);
/*  73:    */         }
/*  74:    */       }
/*  75: 77 */       for (Iterator it = elementosConsumoBaseMap.values().iterator(); it.hasNext();)
/*  76:    */       {
/*  77: 78 */         ElementoConsumoUsuario elementoConsumoUsuario = (ElementoConsumoUsuario)it.next();
/*  78: 79 */         elementoConsumoUsuarioDAO.delete(elementoConsumoUsuario, conn);
/*  79:    */       }
/*  80: 83 */       String[] llavesEnfermedades = { "enfu_cod", "enfu_usuf_cod" };
/*  81: 84 */       EnfermedadesUsuarioDAO enfermedadesUsuarioDAO = new EnfermedadesUsuarioDAO();
/*  82: 85 */       enfermedadesUsuarioDAO.setServerNumber(this.serverNumber);
/*  83: 86 */       List enfermedadesBase = enfermedadesUsuarioDAO.list(usuf_cod);
/*  84:    */       
/*  85: 88 */       Map enfermedadesBaseMap = new HashMap();
/*  86: 89 */       for (Iterator it = enfermedadesBase.iterator(); it.hasNext();)
/*  87:    */       {
/*  88: 90 */         EnfermedadesUsuario enfermedadesUsuario = (EnfermedadesUsuario)it.next();
/*  89: 91 */         enfermedadesBaseMap.put(enfermedadesUsuario.getEnfu_cod(), enfermedadesUsuario);
/*  90:    */       }
/*  91: 94 */       for (Iterator it = historiaMedica.getEnfermedadesUsuario().iterator(); it.hasNext();)
/*  92:    */       {
/*  93: 95 */         EnfermedadesUsuario enfermedadesUsuario = (EnfermedadesUsuario)it.next();
/*  94: 96 */         enfermedadesUsuario.setEnfu_usuf_cod(usuf_cod);
/*  95: 97 */         if (enfermedadesBaseMap.containsKey(enfermedadesUsuario.getEnfu_cod()))
/*  96:    */         {
/*  97: 98 */           enfermedadesUsuarioDAO.update(enfermedadesUsuario, llavesEnfermedades, conn);
/*  98: 99 */           enfermedadesBaseMap.remove(enfermedadesUsuario.getEnfu_cod());
/*  99:    */         }
/* 100:    */         else
/* 101:    */         {
/* 102:101 */           enfermedadesUsuarioDAO.insert(enfermedadesUsuario, conn);
/* 103:    */         }
/* 104:    */       }
/* 105:105 */       for (Iterator it = enfermedadesBaseMap.values().iterator(); it.hasNext();)
/* 106:    */       {
/* 107:106 */         EnfermedadesUsuario enfermedadesUsuario = (EnfermedadesUsuario)it.next();
/* 108:107 */         enfermedadesUsuarioDAO.delete(enfermedadesUsuario, conn);
/* 109:    */       }
/* 110:111 */       String[] llavesAlergias = { "aleu_cod", "aleu_usuf_cod" };
/* 111:112 */       AlergiasUsuarioDAO alergiasUsuarioDAO = new AlergiasUsuarioDAO();
/* 112:113 */       alergiasUsuarioDAO.setServerNumber(this.serverNumber);
/* 113:114 */       List alergiasBase = alergiasUsuarioDAO.list(usuf_cod);
/* 114:    */       
/* 115:116 */       Map alergiasBaseMap = new HashMap();
/* 116:117 */       for (Iterator it = alergiasBase.iterator(); it.hasNext();)
/* 117:    */       {
/* 118:118 */         AlergiasUsuario alergiasUsuario = (AlergiasUsuario)it.next();
/* 119:119 */         alergiasBaseMap.put(alergiasUsuario.getAleu_cod().toString(), alergiasUsuario);
/* 120:    */       }
/* 121:122 */       for (Iterator it = historiaMedica.getAlergiasUsuario().iterator(); it.hasNext();)
/* 122:    */       {
/* 123:123 */         AlergiasUsuario alergiasUsuario = (AlergiasUsuario)it.next();
/* 124:124 */         alergiasUsuario.setAleu_usuf_cod(usuf_cod);
/* 125:125 */         if (alergiasBaseMap.containsKey(alergiasUsuario.getAleu_cod().toString()))
/* 126:    */         {
/* 127:126 */           alergiasUsuarioDAO.update(alergiasUsuario, llavesAlergias, conn);
/* 128:127 */           alergiasBaseMap.remove(alergiasUsuario.getAleu_cod().toString());
/* 129:    */         }
/* 130:    */         else
/* 131:    */         {
/* 132:129 */           alergiasUsuarioDAO.insert(alergiasUsuario, conn);
/* 133:    */         }
/* 134:    */       }
/* 135:133 */       for (Iterator it = alergiasBaseMap.values().iterator(); it.hasNext();)
/* 136:    */       {
/* 137:134 */         AlergiasUsuario alergiasUsuario = (AlergiasUsuario)it.next();
/* 138:135 */         alergiasUsuarioDAO.delete(alergiasUsuario, conn);
/* 139:    */       }
/* 140:139 */       String[] llavesCirujias = { "ciru_cod", "ciru_usuf_cod" };
/* 141:140 */       CirujiasUsuarioDAO cirujiasUsuarioDAO = new CirujiasUsuarioDAO();
/* 142:141 */       cirujiasUsuarioDAO.setServerNumber(this.serverNumber);
/* 143:142 */       List cirujiasBase = cirujiasUsuarioDAO.list(usuf_cod);
/* 144:    */       
/* 145:144 */       Map cirujiasBaseMap = new HashMap();
/* 146:145 */       for (Iterator it = cirujiasBase.iterator(); it.hasNext();)
/* 147:    */       {
/* 148:146 */         CirujiasUsuario cirujiasUsuario = (CirujiasUsuario)it.next();
/* 149:147 */         cirujiasBaseMap.put(cirujiasUsuario.getCiru_cod(), cirujiasUsuario);
/* 150:    */       }
/* 151:150 */       for (Iterator it = historiaMedica.getCirujiasUsuario().iterator(); it.hasNext();)
/* 152:    */       {
/* 153:151 */         CirujiasUsuario cirujiasUsuario = (CirujiasUsuario)it.next();
/* 154:152 */         cirujiasUsuario.setCiru_usuf_cod(usuf_cod);
/* 155:153 */         if (cirujiasBaseMap.containsKey(cirujiasUsuario.getCiru_cod()))
/* 156:    */         {
/* 157:154 */           cirujiasUsuarioDAO.update(cirujiasUsuario, llavesCirujias, conn);
/* 158:155 */           cirujiasBaseMap.remove(cirujiasUsuario.getCiru_cod());
/* 159:    */         }
/* 160:    */         else
/* 161:    */         {
/* 162:157 */           cirujiasUsuarioDAO.insert(cirujiasUsuario, conn);
/* 163:    */         }
/* 164:    */       }
/* 165:161 */       for (Iterator it = cirujiasBaseMap.values().iterator(); it.hasNext();)
/* 166:    */       {
/* 167:162 */         CirujiasUsuario cirujiasUsuario = (CirujiasUsuario)it.next();
/* 168:163 */         cirujiasUsuarioDAO.delete(cirujiasUsuario, conn);
/* 169:    */       }
/* 170:167 */       String[] llavesMedicamentos = { "mtom_cod", "mtom_usuf_cod" };
/* 171:168 */       UsuarioMedicamentosDAO usuarioMedicamentosDAO = new UsuarioMedicamentosDAO();
/* 172:169 */       usuarioMedicamentosDAO.setServerNumber(this.serverNumber);
/* 173:170 */       List usuarioMedicamentosBase = usuarioMedicamentosDAO.list(usuf_cod);
/* 174:    */       
/* 175:172 */       Map usuarioMedicamentosBaseMap = new HashMap();
/* 176:173 */       for (Iterator it = usuarioMedicamentosBase.iterator(); it.hasNext();)
/* 177:    */       {
/* 178:174 */         UsuarioMedicamentos usuarioMedicamentos = (UsuarioMedicamentos)it.next();
/* 179:175 */         usuarioMedicamentosBaseMap.put(usuarioMedicamentos.getMtom_cod(), usuarioMedicamentos);
/* 180:    */       }
/* 181:178 */       for (Iterator it = historiaMedica.getMedicamentosUsuario().iterator(); it.hasNext();)
/* 182:    */       {
/* 183:179 */         UsuarioMedicamentos usuarioMedicamentos = (UsuarioMedicamentos)it.next();
/* 184:180 */         usuarioMedicamentos.setMtom_usuf_cod(usuf_cod);
/* 185:181 */         if (usuarioMedicamentosBaseMap.containsKey(usuarioMedicamentos.getMtom_cod()))
/* 186:    */         {
/* 187:182 */           usuarioMedicamentosDAO.update(usuarioMedicamentos, llavesMedicamentos, conn);
/* 188:183 */           usuarioMedicamentosBaseMap.remove(usuarioMedicamentos.getMtom_cod());
/* 189:    */         }
/* 190:    */         else
/* 191:    */         {
/* 192:185 */           usuarioMedicamentosDAO.insert(usuarioMedicamentos, conn);
/* 193:    */         }
/* 194:    */       }
/* 195:189 */       for (Iterator it = usuarioMedicamentosBaseMap.values().iterator(); it.hasNext();)
/* 196:    */       {
/* 197:190 */         UsuarioMedicamentos usuarioMedicamentos = (UsuarioMedicamentos)it.next();
/* 198:191 */         usuarioMedicamentosDAO.delete(usuarioMedicamentos, conn);
/* 199:    */       }
/* 200:195 */       String[] llavesAntecedentes = { "anteu_cod", "anteu_usuf_cod" };
/* 201:196 */       AntecedentesUsuarioDAO antecedentesUsuarioDAO = new AntecedentesUsuarioDAO();
/* 202:197 */       antecedentesUsuarioDAO.setServerNumber(this.serverNumber);
/* 203:198 */       List antecedentesBase = antecedentesUsuarioDAO.list(usuf_cod);
/* 204:    */       
/* 205:200 */       Map antecedentesBaseMap = new HashMap();
/* 206:201 */       for (Iterator it = antecedentesBase.iterator(); it.hasNext();)
/* 207:    */       {
/* 208:202 */         AntecedentesUsuario antecedentesUsuario = (AntecedentesUsuario)it.next();
/* 209:203 */         antecedentesBaseMap.put(antecedentesUsuario.getAnteu_cod(), antecedentesUsuario);
/* 210:    */       }
/* 211:206 */       for (Iterator it = historiaMedica.getAntecedentesUsuario().iterator(); it.hasNext();)
/* 212:    */       {
/* 213:207 */         AntecedentesUsuario antecedentesUsuario = (AntecedentesUsuario)it.next();
/* 214:208 */         antecedentesUsuario.setAnteu_usuf_cod(usuf_cod);
/* 215:209 */         if (antecedentesBaseMap.containsKey(antecedentesUsuario.getAnteu_cod()))
/* 216:    */         {
/* 217:210 */           antecedentesUsuarioDAO.update(antecedentesUsuario, llavesAntecedentes, conn);
/* 218:211 */           antecedentesBaseMap.remove(antecedentesUsuario.getAnteu_cod());
/* 219:    */         }
/* 220:    */         else
/* 221:    */         {
/* 222:213 */           antecedentesUsuarioDAO.insert(antecedentesUsuario, conn);
/* 223:    */         }
/* 224:    */       }
/* 225:217 */       for (Iterator it = antecedentesBaseMap.values().iterator(); it.hasNext();)
/* 226:    */       {
/* 227:218 */         AntecedentesUsuario antecedentesUsuario = (AntecedentesUsuario)it.next();
/* 228:219 */         antecedentesUsuarioDAO.delete(antecedentesUsuario, conn);
/* 229:    */       }
/* 230:223 */       String[] llavesPartesCuerpo = { "pcueu_cod", "pcueu_usuf_cod" };
/* 231:224 */       PartesCuerpoUsuarioDAO partesCuerpoUsuarioDAO = new PartesCuerpoUsuarioDAO();
/* 232:225 */       partesCuerpoUsuarioDAO.setServerNumber(this.serverNumber);
/* 233:226 */       List partesCuerpoBase = partesCuerpoUsuarioDAO.list(usuf_cod);
/* 234:    */       
/* 235:228 */       Map partesCuerpoBaseMap = new HashMap();
/* 236:229 */       for (Iterator it = partesCuerpoBase.iterator(); it.hasNext();)
/* 237:    */       {
/* 238:230 */         PartesCuerpoUsuario partesCuerpoUsuario = (PartesCuerpoUsuario)it.next();
/* 239:231 */         partesCuerpoBaseMap.put(partesCuerpoUsuario.getPcueu_cod(), partesCuerpoUsuario);
/* 240:    */       }
/* 241:234 */       for (Iterator it = historiaMedica.getPartesCuerpoUsuario().iterator(); it.hasNext();)
/* 242:    */       {
/* 243:235 */         PartesCuerpoUsuario partesCuerpoUsuario = (PartesCuerpoUsuario)it.next();
/* 244:236 */         partesCuerpoUsuario.setPcueu_usuf_cod(usuf_cod);
/* 245:237 */         if (partesCuerpoBaseMap.containsKey(partesCuerpoUsuario.getPcueu_cod()))
/* 246:    */         {
/* 247:238 */           partesCuerpoUsuarioDAO.update(partesCuerpoUsuario, llavesPartesCuerpo, conn);
/* 248:239 */           partesCuerpoBaseMap.remove(partesCuerpoUsuario.getPcueu_cod());
/* 249:    */         }
/* 250:    */         else
/* 251:    */         {
/* 252:241 */           partesCuerpoUsuarioDAO.insert(partesCuerpoUsuario, conn);
/* 253:    */         }
/* 254:    */       }
/* 255:245 */       for (Iterator it = partesCuerpoBaseMap.values().iterator(); it.hasNext();)
/* 256:    */       {
/* 257:246 */         PartesCuerpoUsuario partesCuerpoUsuario = (PartesCuerpoUsuario)it.next();
/* 258:247 */         partesCuerpoUsuarioDAO.delete(partesCuerpoUsuario, conn);
/* 259:    */       }
/* 260:251 */       String[] llavesGinecología = { "gine_usuf_cod" };
/* 261:252 */       GinecologiaDAO ginecologiaDAO = new GinecologiaDAO();
/* 262:253 */       ginecologiaDAO.setServerNumber(this.serverNumber);
/* 263:254 */       if (sexo.equals("F"))
/* 264:    */       {
/* 265:255 */         if (ginecologiaDAO.retrive(usuf_cod).getGine_usuf_cod() == null) {
/* 266:256 */           ginecologiaDAO.insert(historiaMedica.getGinecologia(), conn);
/* 267:    */         } else {
/* 268:258 */           ginecologiaDAO.update(historiaMedica.getGinecologia(), llavesGinecología, conn);
/* 269:    */         }
/* 270:    */       }
/* 271:    */       else {
/* 272:261 */         ginecologiaDAO.delete(usuf_cod, conn);
/* 273:    */       }
/* 274:266 */       String[] llavesOperacionesGinecologia = { "gopeu_cod", "gopeu_usuf_cod" };
/* 275:267 */       GinecologiaOperacionesUsuarioDAO ginecologiaOperacionesUsuarioDAO = new GinecologiaOperacionesUsuarioDAO();
/* 276:268 */       ginecologiaOperacionesUsuarioDAO.setServerNumber(this.serverNumber);
/* 277:269 */       List operacionesGinecologiaBase = ginecologiaOperacionesUsuarioDAO.list(usuf_cod);
/* 278:    */       
/* 279:271 */       Map operacionesGinecologiaBaseMap = new HashMap();
/* 280:272 */       for (Iterator it = operacionesGinecologiaBase.iterator(); it.hasNext();)
/* 281:    */       {
/* 282:273 */         GinecologiaOperacionesUsuario ginecologiaOperacionesUsuario = (GinecologiaOperacionesUsuario)it.next();
/* 283:274 */         operacionesGinecologiaBaseMap.put(ginecologiaOperacionesUsuario.getGopeu_gope_cod(), ginecologiaOperacionesUsuario);
/* 284:    */       }
/* 285:277 */       for (Iterator it = historiaMedica.getGinecologiaOperacionesUsuario().iterator(); it.hasNext();)
/* 286:    */       {
/* 287:278 */         GinecologiaOperacionesUsuario ginecologiaOperacionesUsuario = (GinecologiaOperacionesUsuario)it.next();
/* 288:279 */         ginecologiaOperacionesUsuario.setGopeu_usuf_cod(usuf_cod);
/* 289:280 */         if (operacionesGinecologiaBaseMap.containsKey(ginecologiaOperacionesUsuario.getGopeu_cod()))
/* 290:    */         {
/* 291:281 */           ginecologiaOperacionesUsuarioDAO.update(ginecologiaOperacionesUsuario, llavesOperacionesGinecologia, conn);
/* 292:282 */           operacionesGinecologiaBaseMap.remove(ginecologiaOperacionesUsuario.getGopeu_cod());
/* 293:    */         }
/* 294:    */         else
/* 295:    */         {
/* 296:284 */           ginecologiaOperacionesUsuarioDAO.insert(ginecologiaOperacionesUsuario, conn);
/* 297:    */         }
/* 298:    */       }
/* 299:288 */       for (Iterator it = operacionesGinecologiaBaseMap.values().iterator(); it.hasNext();)
/* 300:    */       {
/* 301:289 */         GinecologiaOperacionesUsuario ginecologiaOperacionesUsuario = (GinecologiaOperacionesUsuario)it.next();
/* 302:290 */         ginecologiaOperacionesUsuarioDAO.delete(ginecologiaOperacionesUsuario, conn);
/* 303:    */       }
/* 304:294 */       if (!manejado) {
/* 305:295 */         conn.commit();
/* 306:    */       }
/* 307:    */     }
/* 308:    */     catch (Exception e)
/* 309:    */     {
/* 310:299 */       if (!manejado) {
/* 311:300 */         rollback(conn);
/* 312:    */       }
/* 313:302 */       throw e;
/* 314:    */     }
/* 315:    */     finally
/* 316:    */     {
/* 317:304 */       if (!manejado) {
/* 318:305 */         close(conn);
/* 319:    */       }
/* 320:    */     }
/* 321:    */   }
/* 322:    */   
/* 323:    */   public HistoriaMedica retrieve(BigDecimal usuf_cod)
/* 324:    */     throws Exception
/* 325:    */   {
/* 326:312 */     HistoriaMedica historiaMedica = new HistoriaMedica();
/* 327:    */     try
/* 328:    */     {
/* 329:317 */       ElementoConsumoUsuarioDAO elementoConsumoUsuarioDAO = new ElementoConsumoUsuarioDAO();
/* 330:318 */       elementoConsumoUsuarioDAO.setServerNumber(this.serverNumber);
/* 331:319 */       historiaMedica.setElementosConsumoUsuario(elementoConsumoUsuarioDAO.list(usuf_cod));
/* 332:    */       
/* 333:    */ 
/* 334:322 */       ElementoConsumoDAO elementoConsumoDAO = new ElementoConsumoDAO();
/* 335:323 */       elementoConsumoDAO.setServerNumber(this.serverNumber);
/* 336:324 */       elementoConsumoDAO.setIdioma(this.idioma);
/* 337:325 */       historiaMedica.setElementosConsumo(elementoConsumoDAO.list());
/* 338:    */       
/* 339:    */ 
/* 340:328 */       EnfermedadesUsuarioDAO enfermedadesUsuarioDAO = new EnfermedadesUsuarioDAO();
/* 341:329 */       enfermedadesUsuarioDAO.setServerNumber(this.serverNumber);
/* 342:330 */       historiaMedica.setEnfermedadesUsuario(enfermedadesUsuarioDAO.list(usuf_cod));
/* 343:    */       
/* 344:    */ 
/* 345:333 */       EnfermedadesDAO enfermedadesDAO = new EnfermedadesDAO();
/* 346:334 */       enfermedadesDAO.setServerNumber(this.serverNumber);
/* 347:335 */       enfermedadesDAO.setIdioma(this.idioma);
/* 348:336 */       historiaMedica.setEnfermedades(enfermedadesDAO.list());
/* 349:    */       
/* 350:    */ 
/* 351:339 */       AlergiasUsuarioDAO alergiasUsuarioDAO = new AlergiasUsuarioDAO();
/* 352:340 */       alergiasUsuarioDAO.setServerNumber(this.serverNumber);
/* 353:341 */       historiaMedica.setAlergiasUsuario(alergiasUsuarioDAO.list(usuf_cod));
/* 354:    */       
/* 355:    */ 
/* 356:344 */       AlergiasDAO alergiasDAO = new AlergiasDAO();
/* 357:345 */       alergiasDAO.setServerNumber(this.serverNumber);
/* 358:346 */       alergiasDAO.setIdioma(this.idioma);
/* 359:347 */       historiaMedica.setAlergias(alergiasDAO.list());
/* 360:    */       
/* 361:    */ 
/* 362:350 */       CirujiasUsuarioDAO cirujiasUsuarioDAO = new CirujiasUsuarioDAO();
/* 363:351 */       cirujiasUsuarioDAO.setServerNumber(this.serverNumber);
/* 364:352 */       historiaMedica.setCirujiasUsuario(cirujiasUsuarioDAO.list(usuf_cod));
/* 365:    */       
/* 366:    */ 
/* 367:355 */       CirujiasDAO cirujiasDAO = new CirujiasDAO();
/* 368:356 */       cirujiasDAO.setServerNumber(this.serverNumber);
/* 369:357 */       cirujiasDAO.setIdioma(this.idioma);
/* 370:358 */       historiaMedica.setCirujias(cirujiasDAO.list());
/* 371:    */       
/* 372:    */ 
/* 373:361 */       UsuarioMedicamentosDAO usuarioMedicamentosDAO = new UsuarioMedicamentosDAO();
/* 374:362 */       usuarioMedicamentosDAO.setServerNumber(this.serverNumber);
/* 375:363 */       historiaMedica.setMedicamentosUsuario(usuarioMedicamentosDAO.list(usuf_cod));
/* 376:    */       
/* 377:    */ 
/* 378:366 */       AntecedentesUsuarioDAO antecedentesUsuarioDAO = new AntecedentesUsuarioDAO();
/* 379:367 */       antecedentesUsuarioDAO.setServerNumber(this.serverNumber);
/* 380:368 */       historiaMedica.setAntecedentesUsuario(antecedentesUsuarioDAO.list(usuf_cod));
/* 381:    */       
/* 382:    */ 
/* 383:371 */       AntecedentesDAO antecedentesDAO = new AntecedentesDAO();
/* 384:372 */       antecedentesDAO.setServerNumber(this.serverNumber);
/* 385:373 */       antecedentesDAO.setIdioma(this.idioma);
/* 386:374 */       historiaMedica.setAntecedentes(antecedentesDAO.list());
/* 387:    */       
/* 388:    */ 
/* 389:377 */       PartesCuerpoUsuarioDAO partesCuerpoUsuarioDAO = new PartesCuerpoUsuarioDAO();
/* 390:378 */       partesCuerpoUsuarioDAO.setServerNumber(this.serverNumber);
/* 391:379 */       historiaMedica.setPartesCuerpoUsuario(partesCuerpoUsuarioDAO.list(usuf_cod));
/* 392:    */       
/* 393:    */ 
/* 394:382 */       PartesCuerpoDAO partesCuerpoDAO = new PartesCuerpoDAO();
/* 395:383 */       partesCuerpoDAO.setServerNumber(this.serverNumber);
/* 396:384 */       partesCuerpoDAO.setIdioma(this.idioma);
/* 397:385 */       historiaMedica.setPartesCuerpo(partesCuerpoDAO.list());
/* 398:    */       
/* 399:    */ 
/* 400:388 */       GinecologiaDAO ginecologiaDAO = new GinecologiaDAO();
/* 401:389 */       ginecologiaDAO.setServerNumber(this.serverNumber);
/* 402:390 */       historiaMedica.setGinecologia(ginecologiaDAO.retrive(usuf_cod));
/* 403:    */       
/* 404:    */ 
/* 405:393 */       GinecologiaOperacionesUsuarioDAO ginecologiaOperacionesUsuarioDAO = new GinecologiaOperacionesUsuarioDAO();
/* 406:394 */       ginecologiaOperacionesUsuarioDAO.setServerNumber(this.serverNumber);
/* 407:395 */       historiaMedica.setGinecologiaOperacionesUsuario(ginecologiaOperacionesUsuarioDAO.list(usuf_cod));
/* 408:    */       
/* 409:    */ 
/* 410:398 */       GinecologiaOperacionesDAO ginecologiaOperacionesDAO = new GinecologiaOperacionesDAO();
/* 411:399 */       ginecologiaOperacionesDAO.setServerNumber(this.serverNumber);
/* 412:400 */       ginecologiaOperacionesDAO.setIdioma(this.idioma);
/* 413:401 */       historiaMedica.setGinecologiaOperaciones(ginecologiaOperacionesDAO.list());
/* 414:    */     }
/* 415:    */     catch (Exception e)
/* 416:    */     {
/* 417:404 */       throw e;
/* 418:    */     }
/* 419:407 */     return historiaMedica;
/* 420:    */   }
/* 421:    */   
/* 422:    */   public void delete(BigDecimal usuf_cod, Connection conn)
/* 423:    */     throws Exception
/* 424:    */   {
/* 425:412 */     boolean manejado = conn != null;
/* 426:    */     try
/* 427:    */     {
/* 428:416 */       if (!manejado)
/* 429:    */       {
/* 430:417 */         conn = this.ds.getConnection();
/* 431:418 */         conn.setAutoCommit(false);
/* 432:    */       }
/* 433:423 */       ElementoConsumoUsuarioDAO elementoConsumoUsuarioDAO = new ElementoConsumoUsuarioDAO();
/* 434:424 */       elementoConsumoUsuarioDAO.setServerNumber(this.serverNumber);
/* 435:425 */       elementoConsumoUsuarioDAO.deleteAll(usuf_cod, conn);
/* 436:    */       
/* 437:    */ 
/* 438:428 */       EnfermedadesUsuarioDAO enfermedadesUsuarioDAO = new EnfermedadesUsuarioDAO();
/* 439:429 */       enfermedadesUsuarioDAO.setServerNumber(this.serverNumber);
/* 440:430 */       enfermedadesUsuarioDAO.deleteAll(usuf_cod, conn);
/* 441:    */       
/* 442:    */ 
/* 443:433 */       AlergiasUsuarioDAO alergiasUsuarioDAO = new AlergiasUsuarioDAO();
/* 444:434 */       alergiasUsuarioDAO.setServerNumber(this.serverNumber);
/* 445:435 */       alergiasUsuarioDAO.deleteAll(usuf_cod, conn);
/* 446:    */       
/* 447:    */ 
/* 448:438 */       CirujiasUsuarioDAO cirujiasUsuarioDAO = new CirujiasUsuarioDAO();
/* 449:439 */       cirujiasUsuarioDAO.setServerNumber(this.serverNumber);
/* 450:440 */       cirujiasUsuarioDAO.deleteAll(usuf_cod, conn);
/* 451:    */       
/* 452:    */ 
/* 453:443 */       UsuarioMedicamentosDAO usuarioMedicamentosDAO = new UsuarioMedicamentosDAO();
/* 454:444 */       usuarioMedicamentosDAO.setServerNumber(this.serverNumber);
/* 455:445 */       usuarioMedicamentosDAO.deleteAll(usuf_cod, conn);
/* 456:    */       
/* 457:    */ 
/* 458:448 */       AntecedentesUsuarioDAO antecedentesUsuarioDAO = new AntecedentesUsuarioDAO();
/* 459:449 */       antecedentesUsuarioDAO.setServerNumber(this.serverNumber);
/* 460:450 */       antecedentesUsuarioDAO.deleteAll(usuf_cod, conn);
/* 461:    */       
/* 462:    */ 
/* 463:453 */       PartesCuerpoUsuarioDAO partesCuerpoUsuarioDAO = new PartesCuerpoUsuarioDAO();
/* 464:454 */       partesCuerpoUsuarioDAO.setServerNumber(this.serverNumber);
/* 465:455 */       partesCuerpoUsuarioDAO.deleteAll(usuf_cod, conn);
/* 466:    */       
/* 467:    */ 
/* 468:458 */       GinecologiaDAO ginecologiaDAO = new GinecologiaDAO();
/* 469:459 */       ginecologiaDAO.setServerNumber(this.serverNumber);
/* 470:460 */       ginecologiaDAO.delete(usuf_cod, conn);
/* 471:    */       
/* 472:    */ 
/* 473:463 */       GinecologiaOperacionesUsuarioDAO ginecologiaOperacionesUsuarioDAO = new GinecologiaOperacionesUsuarioDAO();
/* 474:464 */       ginecologiaOperacionesUsuarioDAO.setServerNumber(this.serverNumber);
/* 475:465 */       ginecologiaOperacionesUsuarioDAO.deleteAll(usuf_cod, conn);
/* 476:467 */       if (!manejado) {
/* 477:468 */         conn.commit();
/* 478:    */       }
/* 479:    */     }
/* 480:    */     catch (Exception e)
/* 481:    */     {
/* 482:472 */       if (!manejado) {
/* 483:473 */         rollback(conn);
/* 484:    */       }
/* 485:475 */       throw e;
/* 486:    */     }
/* 487:    */     finally
/* 488:    */     {
/* 489:477 */       if (!manejado) {
/* 490:478 */         close(conn);
/* 491:    */       }
/* 492:    */     }
/* 493:    */   }
/* 494:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.dao.HistoriaMedicaDAO
 * JD-Core Version:    0.7.0.1
 */