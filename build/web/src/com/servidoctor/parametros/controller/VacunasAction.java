/*   1:    */ package com.servidoctor.parametros.controller;
/*   2:    */ 
/*   3:    */ import com.servidoctor.parametros.dao.VacunasDAO;
/*   4:    */ import com.servidoctor.parametros.model.Vacunas;
/*   5:    */ import com.servidoctor.seguridad.model.Servidores;
/*   6:    */ import com.servidoctor.util.classes.InicializaData;
/*   7:    */ import java.math.BigDecimal;
/*   8:    */ import java.util.ArrayList;
/*   9:    */ import java.util.List;
/*  10:    */ import javax.servlet.http.HttpServletRequest;
/*  11:    */ import javax.servlet.http.HttpServletResponse;
/*  12:    */ import javax.servlet.http.HttpSession;
/*  13:    */ import org.apache.commons.beanutils.BeanUtils;
/*  14:    */ import org.apache.struts.action.Action;
/*  15:    */ import org.apache.struts.action.ActionForm;
/*  16:    */ import org.apache.struts.action.ActionForward;
/*  17:    */ import org.apache.struts.action.ActionMapping;
/*  18:    */ 
/*  19:    */ public class VacunasAction
/*  20:    */   extends Action
/*  21:    */ {
/*  22:    */   public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  23:    */     throws Exception
/*  24:    */   {
/*  25: 32 */     ActionForward myforward = null;
/*  26: 33 */     String myaction = mapping.getParameter();
/*  27: 35 */     if ("".equalsIgnoreCase(myaction)) {
/*  28: 36 */       myforward = mapping.findForward("failure");
/*  29: 37 */     } else if ("EDIT".equalsIgnoreCase(myaction)) {
/*  30: 38 */       myforward = performEdit(mapping, actionForm, request, response);
/*  31: 39 */     } else if ("ADD".equalsIgnoreCase(myaction)) {
/*  32: 40 */       myforward = performAdd(mapping, actionForm, request, response);
/*  33: 41 */     } else if ("SAVE_N".equalsIgnoreCase(myaction)) {
/*  34: 42 */       myforward = performSave_N(mapping, actionForm, request, response);
/*  35: 43 */     } else if ("SAVE".equalsIgnoreCase(myaction)) {
/*  36: 44 */       myforward = performSave(mapping, actionForm, request, response);
/*  37: 45 */     } else if ("SEARCH".equalsIgnoreCase(myaction)) {
/*  38: 46 */       myforward = performList(myaction, mapping, actionForm, request, response);
/*  39: 47 */     } else if ("REMOVE".equalsIgnoreCase(myaction)) {
/*  40: 48 */       myforward = performRemove(myaction, mapping, actionForm, request, response);
/*  41: 49 */     } else if ("LIST".equalsIgnoreCase(myaction)) {
/*  42: 50 */       myforward = performList(myaction, mapping, actionForm, request, response);
/*  43:    */     } else {
/*  44: 52 */       myforward = mapping.findForward("failure");
/*  45:    */     }
/*  46: 55 */     return myforward;
/*  47:    */   }
/*  48:    */   
/*  49:    */   private ActionForward performSave(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  50:    */   {
/*  51: 59 */     VacunasForm form = (VacunasForm)actionForm;
/*  52:    */     try
/*  53:    */     {
/*  54: 62 */       int num_vacunas = Integer.parseInt(request.getParameter("total_vacunas"));
/*  55:    */       
/*  56: 64 */       int x = 11;
/*  57:    */       
/*  58: 66 */       List vacunas = new ArrayList();
/*  59:    */       
/*  60: 68 */       VacunasDAO usuarioVacunasDAO = new VacunasDAO();
/*  61: 69 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  62: 70 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  63: 71 */         usuarioVacunasDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  64:    */       }
/*  65: 73 */       usuarioVacunasDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  66:    */       
/*  67: 75 */       String[] llaves = { "vac_cod" };
/*  68: 77 */       while (x < num_vacunas)
/*  69:    */       {
/*  70: 79 */         Vacunas usuarioVacunas = new Vacunas();
/*  71: 80 */         InicializaData.inicializa(usuarioVacunas.getClass(), usuarioVacunas);
/*  72: 81 */         usuarioVacunas.setVac_cod(new BigDecimal(request.getParameter("vac_cod" + x)));
/*  73: 82 */         if (request.getParameter("vac_edad_mes1" + x) != null) {
/*  74: 83 */           usuarioVacunas.setVac_edad_mes1(new BigDecimal("1"));
/*  75:    */         } else {
/*  76: 85 */           usuarioVacunas.setVac_edad_mes1(new BigDecimal("0"));
/*  77:    */         }
/*  78: 86 */         if (request.getParameter("vac_edad_mes2" + x) != null) {
/*  79: 87 */           usuarioVacunas.setVac_edad_mes2(new BigDecimal("1"));
/*  80:    */         } else {
/*  81: 89 */           usuarioVacunas.setVac_edad_mes2(new BigDecimal("0"));
/*  82:    */         }
/*  83: 90 */         if (request.getParameter("vac_edad_mes3" + x) != null) {
/*  84: 91 */           usuarioVacunas.setVac_edad_mes3(new BigDecimal("1"));
/*  85:    */         } else {
/*  86: 93 */           usuarioVacunas.setVac_edad_mes3(new BigDecimal("0"));
/*  87:    */         }
/*  88: 94 */         if (request.getParameter("vac_edad_mes4" + x) != null) {
/*  89: 95 */           usuarioVacunas.setVac_edad_mes4(new BigDecimal("1"));
/*  90:    */         } else {
/*  91: 97 */           usuarioVacunas.setVac_edad_mes4(new BigDecimal("0"));
/*  92:    */         }
/*  93: 98 */         if (request.getParameter("vac_edad_mes5" + x) != null) {
/*  94: 99 */           usuarioVacunas.setVac_edad_mes5(new BigDecimal("1"));
/*  95:    */         } else {
/*  96:101 */           usuarioVacunas.setVac_edad_mes5(new BigDecimal("0"));
/*  97:    */         }
/*  98:102 */         if (request.getParameter("vac_edad_mes6" + x) != null) {
/*  99:103 */           usuarioVacunas.setVac_edad_mes6(new BigDecimal("1"));
/* 100:    */         } else {
/* 101:105 */           usuarioVacunas.setVac_edad_mes6(new BigDecimal("0"));
/* 102:    */         }
/* 103:106 */         if (request.getParameter("vac_edad_mes7" + x) != null) {
/* 104:107 */           usuarioVacunas.setVac_edad_mes7(new BigDecimal("1"));
/* 105:    */         } else {
/* 106:109 */           usuarioVacunas.setVac_edad_mes7(new BigDecimal("0"));
/* 107:    */         }
/* 108:110 */         if (request.getParameter("vac_edad_mes8" + x) != null) {
/* 109:111 */           usuarioVacunas.setVac_edad_mes8(new BigDecimal("1"));
/* 110:    */         } else {
/* 111:113 */           usuarioVacunas.setVac_edad_mes8(new BigDecimal("0"));
/* 112:    */         }
/* 113:114 */         if (request.getParameter("vac_edad_mes9" + x) != null) {
/* 114:115 */           usuarioVacunas.setVac_edad_mes9(new BigDecimal("1"));
/* 115:    */         } else {
/* 116:117 */           usuarioVacunas.setVac_edad_mes9(new BigDecimal("0"));
/* 117:    */         }
/* 118:118 */         if (request.getParameter("vac_edad_mes10" + x) != null) {
/* 119:119 */           usuarioVacunas.setVac_edad_mes10(new BigDecimal("1"));
/* 120:    */         } else {
/* 121:121 */           usuarioVacunas.setVac_edad_mes10(new BigDecimal("0"));
/* 122:    */         }
/* 123:122 */         if (request.getParameter("vac_edad_mes11" + x) != null) {
/* 124:123 */           usuarioVacunas.setVac_edad_mes11(new BigDecimal("1"));
/* 125:    */         } else {
/* 126:125 */           usuarioVacunas.setVac_edad_mes11(new BigDecimal("0"));
/* 127:    */         }
/* 128:126 */         if (request.getParameter("vac_edad_mes12" + x) != null) {
/* 129:127 */           usuarioVacunas.setVac_edad_mes12(new BigDecimal("1"));
/* 130:    */         } else {
/* 131:129 */           usuarioVacunas.setVac_edad_mes12(new BigDecimal("0"));
/* 132:    */         }
/* 133:130 */         if (request.getParameter("vac_edad_mes13" + x) != null) {
/* 134:131 */           usuarioVacunas.setVac_edad_mes13(new BigDecimal("1"));
/* 135:    */         } else {
/* 136:133 */           usuarioVacunas.setVac_edad_mes13(new BigDecimal("0"));
/* 137:    */         }
/* 138:134 */         if (request.getParameter("vac_edad_mes14" + x) != null) {
/* 139:135 */           usuarioVacunas.setVac_edad_mes14(new BigDecimal("1"));
/* 140:    */         } else {
/* 141:137 */           usuarioVacunas.setVac_edad_mes14(new BigDecimal("0"));
/* 142:    */         }
/* 143:138 */         if (request.getParameter("vac_edad_mes15" + x) != null) {
/* 144:139 */           usuarioVacunas.setVac_edad_mes15(new BigDecimal("1"));
/* 145:    */         } else {
/* 146:141 */           usuarioVacunas.setVac_edad_mes15(new BigDecimal("0"));
/* 147:    */         }
/* 148:142 */         if (request.getParameter("vac_edad_mes16" + x) != null) {
/* 149:143 */           usuarioVacunas.setVac_edad_mes16(new BigDecimal("1"));
/* 150:    */         } else {
/* 151:145 */           usuarioVacunas.setVac_edad_mes16(new BigDecimal("0"));
/* 152:    */         }
/* 153:146 */         if (request.getParameter("vac_edad_mes17" + x) != null) {
/* 154:147 */           usuarioVacunas.setVac_edad_mes17(new BigDecimal("1"));
/* 155:    */         } else {
/* 156:149 */           usuarioVacunas.setVac_edad_mes17(new BigDecimal("0"));
/* 157:    */         }
/* 158:150 */         if (request.getParameter("vac_edad_mes18" + x) != null) {
/* 159:151 */           usuarioVacunas.setVac_edad_mes18(new BigDecimal("1"));
/* 160:    */         } else {
/* 161:153 */           usuarioVacunas.setVac_edad_mes18(new BigDecimal("0"));
/* 162:    */         }
/* 163:154 */         if (request.getParameter("vac_edad_mes19" + x) != null) {
/* 164:155 */           usuarioVacunas.setVac_edad_mes19(new BigDecimal("1"));
/* 165:    */         } else {
/* 166:157 */           usuarioVacunas.setVac_edad_mes19(new BigDecimal("0"));
/* 167:    */         }
/* 168:158 */         if (request.getParameter("vac_edad_mes20" + x) != null) {
/* 169:159 */           usuarioVacunas.setVac_edad_mes20(new BigDecimal("1"));
/* 170:    */         } else {
/* 171:161 */           usuarioVacunas.setVac_edad_mes20(new BigDecimal("0"));
/* 172:    */         }
/* 173:162 */         if (request.getParameter("vac_edad_mes21" + x) != null) {
/* 174:163 */           usuarioVacunas.setVac_edad_mes21(new BigDecimal("1"));
/* 175:    */         } else {
/* 176:165 */           usuarioVacunas.setVac_edad_mes21(new BigDecimal("0"));
/* 177:    */         }
/* 178:166 */         if (request.getParameter("vac_edad_mes22" + x) != null) {
/* 179:167 */           usuarioVacunas.setVac_edad_mes22(new BigDecimal("1"));
/* 180:    */         } else {
/* 181:169 */           usuarioVacunas.setVac_edad_mes22(new BigDecimal("0"));
/* 182:    */         }
/* 183:170 */         if (request.getParameter("vac_edad_mes23" + x) != null) {
/* 184:171 */           usuarioVacunas.setVac_edad_mes23(new BigDecimal("1"));
/* 185:    */         } else {
/* 186:173 */           usuarioVacunas.setVac_edad_mes23(new BigDecimal("0"));
/* 187:    */         }
/* 188:174 */         if (request.getParameter("vac_edad_mes24" + x) != null) {
/* 189:175 */           usuarioVacunas.setVac_edad_mes24(new BigDecimal("1"));
/* 190:    */         } else {
/* 191:177 */           usuarioVacunas.setVac_edad_mes24(new BigDecimal("0"));
/* 192:    */         }
/* 193:178 */         if (request.getParameter("vac_edad_anno3" + x) != null) {
/* 194:179 */           usuarioVacunas.setVac_edad_anno3(new BigDecimal("1"));
/* 195:    */         } else {
/* 196:181 */           usuarioVacunas.setVac_edad_anno3(new BigDecimal("0"));
/* 197:    */         }
/* 198:182 */         if (request.getParameter("vac_edad_anno4" + x) != null) {
/* 199:183 */           usuarioVacunas.setVac_edad_anno4(new BigDecimal("1"));
/* 200:    */         } else {
/* 201:185 */           usuarioVacunas.setVac_edad_anno4(new BigDecimal("0"));
/* 202:    */         }
/* 203:186 */         if (request.getParameter("vac_edad_anno5" + x) != null) {
/* 204:187 */           usuarioVacunas.setVac_edad_anno5(new BigDecimal("1"));
/* 205:    */         } else {
/* 206:189 */           usuarioVacunas.setVac_edad_anno5(new BigDecimal("0"));
/* 207:    */         }
/* 208:190 */         if (request.getParameter("vac_edad_anno6" + x) != null) {
/* 209:191 */           usuarioVacunas.setVac_edad_anno6(new BigDecimal("1"));
/* 210:    */         } else {
/* 211:193 */           usuarioVacunas.setVac_edad_anno6(new BigDecimal("0"));
/* 212:    */         }
/* 213:194 */         if (request.getParameter("vac_edad_anno7" + x) != null) {
/* 214:195 */           usuarioVacunas.setVac_edad_anno7(new BigDecimal("1"));
/* 215:    */         } else {
/* 216:197 */           usuarioVacunas.setVac_edad_anno7(new BigDecimal("0"));
/* 217:    */         }
/* 218:198 */         if (request.getParameter("vac_edad_anno8" + x) != null) {
/* 219:199 */           usuarioVacunas.setVac_edad_anno8(new BigDecimal("1"));
/* 220:    */         } else {
/* 221:201 */           usuarioVacunas.setVac_edad_anno8(new BigDecimal("0"));
/* 222:    */         }
/* 223:202 */         if (request.getParameter("vac_edad_anno9" + x) != null) {
/* 224:203 */           usuarioVacunas.setVac_edad_anno9(new BigDecimal("1"));
/* 225:    */         } else {
/* 226:205 */           usuarioVacunas.setVac_edad_anno9(new BigDecimal("0"));
/* 227:    */         }
/* 228:206 */         if (request.getParameter("vac_edad_anno10" + x) != null) {
/* 229:207 */           usuarioVacunas.setVac_edad_anno10(new BigDecimal("1"));
/* 230:    */         } else {
/* 231:209 */           usuarioVacunas.setVac_edad_anno10(new BigDecimal("0"));
/* 232:    */         }
/* 233:210 */         if (request.getParameter("vac_edad_anno11" + x) != null) {
/* 234:211 */           usuarioVacunas.setVac_edad_anno11(new BigDecimal("1"));
/* 235:    */         } else {
/* 236:213 */           usuarioVacunas.setVac_edad_anno11(new BigDecimal("0"));
/* 237:    */         }
/* 238:214 */         if (request.getParameter("vac_edad_anno12" + x) != null) {
/* 239:215 */           usuarioVacunas.setVac_edad_anno12(new BigDecimal("1"));
/* 240:    */         } else {
/* 241:217 */           usuarioVacunas.setVac_edad_anno12(new BigDecimal("0"));
/* 242:    */         }
/* 243:218 */         if (request.getParameter("vac_edad_anno13" + x) != null) {
/* 244:219 */           usuarioVacunas.setVac_edad_anno13(new BigDecimal("1"));
/* 245:    */         } else {
/* 246:221 */           usuarioVacunas.setVac_edad_anno13(new BigDecimal("0"));
/* 247:    */         }
/* 248:222 */         if (request.getParameter("vac_edad_anno14" + x) != null) {
/* 249:223 */           usuarioVacunas.setVac_edad_anno14(new BigDecimal("1"));
/* 250:    */         } else {
/* 251:225 */           usuarioVacunas.setVac_edad_anno14(new BigDecimal("0"));
/* 252:    */         }
/* 253:226 */         if (request.getParameter("vac_edad_anno15" + x) != null) {
/* 254:227 */           usuarioVacunas.setVac_edad_anno15(new BigDecimal("1"));
/* 255:    */         } else {
/* 256:229 */           usuarioVacunas.setVac_edad_anno15(new BigDecimal("0"));
/* 257:    */         }
/* 258:230 */         if (request.getParameter("vac_edad_anno16" + x) != null) {
/* 259:231 */           usuarioVacunas.setVac_edad_anno16(new BigDecimal("1"));
/* 260:    */         } else {
/* 261:233 */           usuarioVacunas.setVac_edad_anno16(new BigDecimal("0"));
/* 262:    */         }
/* 263:234 */         if (request.getParameter("vac_edad_anno17" + x) != null) {
/* 264:235 */           usuarioVacunas.setVac_edad_anno17(new BigDecimal("1"));
/* 265:    */         } else {
/* 266:237 */           usuarioVacunas.setVac_edad_anno17(new BigDecimal("0"));
/* 267:    */         }
/* 268:238 */         if (request.getParameter("vac_edad_anno18" + x) != null) {
/* 269:239 */           usuarioVacunas.setVac_edad_anno18(new BigDecimal("1"));
/* 270:    */         } else {
/* 271:241 */           usuarioVacunas.setVac_edad_anno18(new BigDecimal("0"));
/* 272:    */         }
/* 273:242 */         if (request.getParameter("vac_edad_anno20" + x) != null) {
/* 274:243 */           usuarioVacunas.setVac_edad_anno20(new BigDecimal("1"));
/* 275:    */         } else {
/* 276:245 */           usuarioVacunas.setVac_edad_anno20(new BigDecimal("0"));
/* 277:    */         }
/* 278:246 */         if (request.getParameter("vac_edad_anno30" + x) != null) {
/* 279:247 */           usuarioVacunas.setVac_edad_anno30(new BigDecimal("1"));
/* 280:    */         } else {
/* 281:249 */           usuarioVacunas.setVac_edad_anno30(new BigDecimal("0"));
/* 282:    */         }
/* 283:250 */         if (request.getParameter("vac_edad_anno40" + x) != null) {
/* 284:251 */           usuarioVacunas.setVac_edad_anno40(new BigDecimal("1"));
/* 285:    */         } else {
/* 286:253 */           usuarioVacunas.setVac_edad_anno40(new BigDecimal("0"));
/* 287:    */         }
/* 288:254 */         if (request.getParameter("vac_edad_anno50" + x) != null) {
/* 289:255 */           usuarioVacunas.setVac_edad_anno50(new BigDecimal("1"));
/* 290:    */         } else {
/* 291:257 */           usuarioVacunas.setVac_edad_anno50(new BigDecimal("0"));
/* 292:    */         }
/* 293:258 */         if (request.getParameter("vac_edad_anno60" + x) != null) {
/* 294:259 */           usuarioVacunas.setVac_edad_anno60(new BigDecimal("1"));
/* 295:    */         } else {
/* 296:261 */           usuarioVacunas.setVac_edad_anno60(new BigDecimal("0"));
/* 297:    */         }
/* 298:262 */         if (request.getParameter("vac_edad_anno70" + x) != null) {
/* 299:263 */           usuarioVacunas.setVac_edad_anno70(new BigDecimal("1"));
/* 300:    */         } else {
/* 301:265 */           usuarioVacunas.setVac_edad_anno70(new BigDecimal("0"));
/* 302:    */         }
/* 303:266 */         if (request.getParameter("vac_edad_anno80" + x) != null) {
/* 304:267 */           usuarioVacunas.setVac_edad_anno80(new BigDecimal("1"));
/* 305:    */         } else {
/* 306:269 */           usuarioVacunas.setVac_edad_anno80(new BigDecimal("0"));
/* 307:    */         }
/* 308:270 */         if (request.getParameter("vac_edad_anno90" + x) != null) {
/* 309:271 */           usuarioVacunas.setVac_edad_anno90(new BigDecimal("1"));
/* 310:    */         } else {
/* 311:273 */           usuarioVacunas.setVac_edad_anno90(new BigDecimal("0"));
/* 312:    */         }
/* 313:275 */         usuarioVacunas.setVac_des(request.getParameter("vac_des" + x));
/* 314:    */         
/* 315:277 */         vacunas.add(usuarioVacunas);
/* 316:    */         
/* 317:279 */         x++;
/* 318:    */         
/* 319:281 */         Vacunas vacuna = usuarioVacunasDAO.retrieve(usuarioVacunas.getVac_cod());
/* 320:282 */         if (vacuna.getVac_cod() == null) {
/* 321:283 */           usuarioVacunasDAO.insert(usuarioVacunas);
/* 322:    */         } else {
/* 323:285 */           usuarioVacunasDAO.update(usuarioVacunas, llaves);
/* 324:    */         }
/* 325:    */       }
/* 326:    */     }
/* 327:    */     catch (Exception e)
/* 328:    */     {
/* 329:291 */       return mapping.findForward("failure");
/* 330:    */     }
/* 331:293 */     return mapping.findForward("success");
/* 332:    */   }
/* 333:    */   
/* 334:    */   private ActionForward performEdit(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 335:    */   {
/* 336:297 */     VacunasForm form = (VacunasForm)actionForm;
/* 337:    */     
/* 338:    */ 
/* 339:    */ 
/* 340:    */ 
/* 341:    */ 
/* 342:    */ 
/* 343:    */ 
/* 344:    */ 
/* 345:    */ 
/* 346:307 */     return mapping.findForward("success");
/* 347:    */   }
/* 348:    */   
/* 349:    */   private ActionForward performAdd(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 350:    */   {
/* 351:311 */     VacunasForm form = (VacunasForm)actionForm;
/* 352:    */     
/* 353:    */ 
/* 354:    */ 
/* 355:    */ 
/* 356:    */ 
/* 357:    */ 
/* 358:318 */     return mapping.findForward("success");
/* 359:    */   }
/* 360:    */   
/* 361:    */   private ActionForward performList(String myaction, ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 362:    */   {
/* 363:323 */     VacunasForm form = (VacunasForm)actionForm;
/* 364:    */     try
/* 365:    */     {
/* 366:325 */       VacunasDAO usuarioVacunasDAO = new VacunasDAO();
/* 367:326 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 368:327 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 369:328 */         usuarioVacunasDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 370:    */       }
/* 371:330 */       usuarioVacunasDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 372:331 */       List usuarioVacunas = usuarioVacunasDAO.list();
/* 373:332 */       request.setAttribute("VACUNAS", usuarioVacunas);
/* 374:    */     }
/* 375:    */     catch (Exception e)
/* 376:    */     {
/* 377:334 */       return mapping.findForward("failure");
/* 378:    */     }
/* 379:336 */     return mapping.findForward("success");
/* 380:    */   }
/* 381:    */   
/* 382:    */   private ActionForward performSave_N(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 383:    */   {
/* 384:340 */     VacunasForm form = (VacunasForm)actionForm;
/* 385:    */     try
/* 386:    */     {
/* 387:343 */       VacunasDAO usuarioVacunasDAO = new VacunasDAO();
/* 388:344 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 389:345 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 390:346 */         usuarioVacunasDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 391:    */       }
/* 392:348 */       usuarioVacunasDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 393:349 */       Vacunas usuarioVacunas = new Vacunas();
/* 394:350 */       InicializaData.inicializa(usuarioVacunas.getClass(), usuarioVacunas);
/* 395:351 */       BeanUtils.copyProperties(usuarioVacunas, form);
/* 396:352 */       usuarioVacunasDAO.insert(usuarioVacunas);
/* 397:    */     }
/* 398:    */     catch (Exception e)
/* 399:    */     {
/* 400:356 */       return mapping.findForward("failure");
/* 401:    */     }
/* 402:358 */     return mapping.findForward("success");
/* 403:    */   }
/* 404:    */   
/* 405:    */   private ActionForward performRemove(String myaction, ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 406:    */   {
/* 407:362 */     VacunasForm form = (VacunasForm)actionForm;
/* 408:    */     try
/* 409:    */     {
/* 410:366 */       VacunasDAO usuarioVacunasDAO = new VacunasDAO();
/* 411:367 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 412:368 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 413:369 */         usuarioVacunasDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 414:    */       }
/* 415:371 */       usuarioVacunasDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 416:372 */       Vacunas usuarioVacunas = new Vacunas();
/* 417:373 */       InicializaData.inicializa(usuarioVacunas.getClass(), usuarioVacunas);
/* 418:374 */       BeanUtils.copyProperties(usuarioVacunas, form);
/* 419:375 */       usuarioVacunasDAO.delete(usuarioVacunas);
/* 420:    */     }
/* 421:    */     catch (Exception e)
/* 422:    */     {
/* 423:378 */       e.printStackTrace();
/* 424:379 */       return mapping.findForward("failure");
/* 425:    */     }
/* 426:382 */     return mapping.findForward("success");
/* 427:    */   }
/* 428:    */ }



/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\

 * Qualified Name:     com.servidoctor.parametros.controller.VacunasAction

 * JD-Core Version:    0.7.0.1

 */