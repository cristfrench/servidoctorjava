/*   1:    */ package com.servidoctor.sdfamily.controller;
/*   2:    */ 
/*   3:    */ import com.essecorp.util.GestorFechasCompleto;
/*   4:    */ import com.servidoctor.common.controller.BaseAction;
/*   5:    */ import com.servidoctor.constantes.IGrupos;
/*   6:    */ import com.servidoctor.parametros.dao.VacunasDAO;
/*   7:    */ import com.servidoctor.parametros.model.Vacunas;
/*   8:    */ import com.servidoctor.sdfamily.dao.DatosPersonalesDAO;
/*   9:    */ import com.servidoctor.sdfamily.dao.VacunasCompletoDAO;
/*  10:    */ import com.servidoctor.sdfamily.model.DatosPersonales;
/*  11:    */ import com.servidoctor.sdfamily.model.GruposUsuario;
/*  12:    */ import com.servidoctor.sdfamily.model.VacunasCompleto;
/*  13:    */ import com.servidoctor.sdfamily.model.VacunasUsuario;
/*  14:    */ import com.servidoctor.seguridad.model.Servidores;
/*  15:    */ import com.servidoctor.seguridad.model.UsuarioFamily;
/*  16:    */ import com.servidoctor.util.classes.BorrarSession;
/*  17:    */ import com.servidoctor.util.classes.ManejoFechas;
/*  18:    */ import java.math.BigDecimal;
/*  19:    */ import java.util.List;
/*  20:    */ import javax.servlet.http.HttpServletRequest;
/*  21:    */ import javax.servlet.http.HttpServletResponse;
/*  22:    */ import javax.servlet.http.HttpSession;
/*  23:    */ import org.apache.commons.beanutils.BeanUtils;
/*  24:    */ import org.apache.struts.action.ActionForm;
/*  25:    */ import org.apache.struts.action.ActionForward;
/*  26:    */ import org.apache.struts.action.ActionMapping;
/*  27:    */ 
/*  28:    */ public class ControlVacunasAction
/*  29:    */   extends BaseAction
/*  30:    */ {
/*  31:    */   public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  32:    */     throws Exception
/*  33:    */   {
/*  34: 41 */     ActionForward myforward = super.execute(mapping, actionForm, request, response);
/*  35: 42 */     String myaction = mapping.getParameter();
/*  36: 44 */     if (myforward == null)
/*  37:    */     {
/*  38: 45 */       DatosPersonales datosPersonales = (DatosPersonales)request.getSession().getAttribute("datosPersonales");
/*  39: 46 */       if (datosPersonales.getDatp_usuf_cod() == null) {
/*  40: 47 */         myforward = mapping.findForward("datospersonales");
/*  41: 48 */       } else if ("".equalsIgnoreCase(myaction)) {
/*  42: 49 */         myforward = mapping.findForward("failure");
/*  43: 50 */       } else if ("VIEW".equalsIgnoreCase(myaction)) {
/*  44: 51 */         myforward = performView(mapping, actionForm, request, response);
/*  45: 52 */       } else if ("EDIT".equalsIgnoreCase(myaction)) {
/*  46: 53 */         myforward = performEdit(mapping, actionForm, request, response);
/*  47: 54 */       } else if ("ADD".equalsIgnoreCase(myaction)) {
/*  48: 55 */         myforward = performAdd(mapping, actionForm, request, response);
/*  49: 56 */       } else if ("SAVE".equalsIgnoreCase(myaction)) {
/*  50: 57 */         myforward = performSave(mapping, actionForm, request, response);
/*  51:    */       } else {
/*  52: 59 */         myforward = mapping.findForward("failure");
/*  53:    */       }
/*  54:    */     }
/*  55: 63 */     return myforward;
/*  56:    */   }
/*  57:    */   
/*  58:    */   private ActionForward performView(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  59:    */   {
/*  60: 67 */     ControlVacunasForm form = (ControlVacunasForm)actionForm;
/*  61: 68 */     Boolean nuevo = Boolean.valueOf(false);
/*  62:    */     try
/*  63:    */     {
/*  64: 72 */       BorrarSession.eliminaAtributos(request.getSession(), "controlVacunasForm");
/*  65:    */       
/*  66: 74 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/*  67:    */       
/*  68: 76 */       VacunasCompletoDAO vacunasCompletoDAO = new VacunasCompletoDAO();
/*  69: 77 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  70: 78 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  71: 79 */         vacunasCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  72:    */       }
/*  73: 81 */       //vacunasCompletoDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    vacunasCompletoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  74:    */       
/*  75: 83 */       VacunasCompleto vacunasCompleto = vacunasCompletoDAO.retrieve(usuarioFamily.getUsuf_cod());
/*  76:    */       
/*  77: 85 */       List tablaUniversal = vacunasCompleto.getTablaUniversal();
/*  78: 86 */       request.getSession().setAttribute("VACUNAS", tablaUniversal);
/*  79:    */       
/*  80: 88 */       List tablaAjustada = vacunasCompleto.getTablaAjustada();
/*  81:    */       
/*  82: 90 */       VacunasDAO vacunasDAO = new VacunasDAO();
/*  83: 91 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  84: 92 */         vacunasDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  85:    */       }
/*  86: 94 */       //vacunasDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    vacunasDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  87:    */       
/*  88: 96 */       int i = 0;
/*  89: 97 */       while (i < tablaAjustada.size())
/*  90:    */       {
/*  91: 98 */         request.setAttribute("vacu_des" + i, vacunasDAO.retrieve(((VacunasUsuario)tablaAjustada.get(i)).getVacu_vac_cod()).getVac_des());
/*  92: 99 */         i++;
/*  93:    */       }
/*  94:102 */       GruposUsuario gruposUsuario = vacunasCompleto.getGrupoUsuario();
/*  95:103 */       BeanUtils.copyProperties(form, gruposUsuario);
/*  96:    */       
/*  97:105 */       request.getSession().setAttribute("USUARIO_VACUNAS", tablaAjustada);
/*  98:    */     }
/*  99:    */     catch (Exception e)
/* 100:    */     {
/* 101:108 */       e.printStackTrace();
/* 102:109 */       return mapping.findForward("failure");
/* 103:    */     }
/* 104:111 */     return mapping.findForward("success");
/* 105:    */   }
/* 106:    */   
/* 107:    */   private ActionForward performEdit(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 108:    */   {
/* 109:115 */     ControlVacunasForm form = (ControlVacunasForm)actionForm;
/* 110:    */     
/* 111:    */ 
/* 112:    */ 
/* 113:    */ 
/* 114:    */ 
/* 115:    */ 
/* 116:    */ 
/* 117:123 */     return mapping.findForward("success");
/* 118:    */   }
/* 119:    */   
/* 120:    */   private ActionForward performAdd(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 121:    */   {
/* 122:127 */     ControlVacunasForm form = (ControlVacunasForm)actionForm;
/* 123:    */     try
/* 124:    */     {
/* 125:130 */       List vacunasUsuario = (List)request.getSession().getAttribute("USUARIO_VACUNAS");
/* 126:    */       
/* 127:132 */       int num_vacunas = ((List)request.getSession().getAttribute("USUARIO_VACUNAS")).size();
/* 128:133 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/* 129:    */       
/* 130:135 */       int x = 0;
/* 131:136 */       if (request.getParameter("add") != null) {
/* 132:137 */         while (x < num_vacunas)
/* 133:    */         {
/* 134:138 */           VacunasUsuario vacunaUsuario = (VacunasUsuario)vacunasUsuario.get(x);
/* 135:139 */           vacunaUsuario.setVacu_cod(new BigDecimal(x + 10));
/* 136:140 */           if (request.getParameter("vacu_edad_mes1" + x) != null) {
/* 137:141 */             vacunaUsuario.setVacu_edad_mes1(new BigDecimal("1"));
/* 138:    */           } else {
/* 139:143 */             vacunaUsuario.setVacu_edad_mes1(new BigDecimal("0"));
/* 140:    */           }
/* 141:144 */           if (request.getParameter("vacu_edad_mes2" + x) != null) {
/* 142:145 */             vacunaUsuario.setVacu_edad_mes2(new BigDecimal("1"));
/* 143:    */           } else {
/* 144:147 */             vacunaUsuario.setVacu_edad_mes2(new BigDecimal("0"));
/* 145:    */           }
/* 146:148 */           if (request.getParameter("vacu_edad_mes3" + x) != null) {
/* 147:149 */             vacunaUsuario.setVacu_edad_mes3(new BigDecimal("1"));
/* 148:    */           } else {
/* 149:151 */             vacunaUsuario.setVacu_edad_mes3(new BigDecimal("0"));
/* 150:    */           }
/* 151:152 */           if (request.getParameter("vacu_edad_mes4" + x) != null) {
/* 152:153 */             vacunaUsuario.setVacu_edad_mes4(new BigDecimal("1"));
/* 153:    */           } else {
/* 154:155 */             vacunaUsuario.setVacu_edad_mes4(new BigDecimal("0"));
/* 155:    */           }
/* 156:156 */           if (request.getParameter("vacu_edad_mes5" + x) != null) {
/* 157:157 */             vacunaUsuario.setVacu_edad_mes5(new BigDecimal("1"));
/* 158:    */           } else {
/* 159:159 */             vacunaUsuario.setVacu_edad_mes5(new BigDecimal("0"));
/* 160:    */           }
/* 161:160 */           if (request.getParameter("vacu_edad_mes6" + x) != null) {
/* 162:161 */             vacunaUsuario.setVacu_edad_mes6(new BigDecimal("1"));
/* 163:    */           } else {
/* 164:163 */             vacunaUsuario.setVacu_edad_mes6(new BigDecimal("0"));
/* 165:    */           }
/* 166:164 */           if (request.getParameter("vacu_edad_mes7" + x) != null) {
/* 167:165 */             vacunaUsuario.setVacu_edad_mes7(new BigDecimal("1"));
/* 168:    */           } else {
/* 169:167 */             vacunaUsuario.setVacu_edad_mes7(new BigDecimal("0"));
/* 170:    */           }
/* 171:168 */           if (request.getParameter("vacu_edad_mes8" + x) != null) {
/* 172:169 */             vacunaUsuario.setVacu_edad_mes8(new BigDecimal("1"));
/* 173:    */           } else {
/* 174:171 */             vacunaUsuario.setVacu_edad_mes8(new BigDecimal("0"));
/* 175:    */           }
/* 176:172 */           if (request.getParameter("vacu_edad_mes9" + x) != null) {
/* 177:173 */             vacunaUsuario.setVacu_edad_mes9(new BigDecimal("1"));
/* 178:    */           } else {
/* 179:175 */             vacunaUsuario.setVacu_edad_mes9(new BigDecimal("0"));
/* 180:    */           }
/* 181:176 */           if (request.getParameter("vacu_edad_mes10" + x) != null) {
/* 182:177 */             vacunaUsuario.setVacu_edad_mes10(new BigDecimal("1"));
/* 183:    */           } else {
/* 184:179 */             vacunaUsuario.setVacu_edad_mes10(new BigDecimal("0"));
/* 185:    */           }
/* 186:180 */           if (request.getParameter("vacu_edad_mes11" + x) != null) {
/* 187:181 */             vacunaUsuario.setVacu_edad_mes11(new BigDecimal("1"));
/* 188:    */           } else {
/* 189:183 */             vacunaUsuario.setVacu_edad_mes11(new BigDecimal("0"));
/* 190:    */           }
/* 191:184 */           if (request.getParameter("vacu_edad_mes12" + x) != null) {
/* 192:185 */             vacunaUsuario.setVacu_edad_mes12(new BigDecimal("1"));
/* 193:    */           } else {
/* 194:187 */             vacunaUsuario.setVacu_edad_mes12(new BigDecimal("0"));
/* 195:    */           }
/* 196:188 */           if (request.getParameter("vacu_edad_mes13" + x) != null) {
/* 197:189 */             vacunaUsuario.setVacu_edad_mes13(new BigDecimal("1"));
/* 198:    */           } else {
/* 199:191 */             vacunaUsuario.setVacu_edad_mes13(new BigDecimal("0"));
/* 200:    */           }
/* 201:192 */           if (request.getParameter("vacu_edad_mes14" + x) != null) {
/* 202:193 */             vacunaUsuario.setVacu_edad_mes14(new BigDecimal("1"));
/* 203:    */           } else {
/* 204:195 */             vacunaUsuario.setVacu_edad_mes14(new BigDecimal("0"));
/* 205:    */           }
/* 206:196 */           if (request.getParameter("vacu_edad_mes15" + x) != null) {
/* 207:197 */             vacunaUsuario.setVacu_edad_mes15(new BigDecimal("1"));
/* 208:    */           } else {
/* 209:199 */             vacunaUsuario.setVacu_edad_mes15(new BigDecimal("0"));
/* 210:    */           }
/* 211:200 */           if (request.getParameter("vacu_edad_mes16" + x) != null) {
/* 212:201 */             vacunaUsuario.setVacu_edad_mes16(new BigDecimal("1"));
/* 213:    */           } else {
/* 214:203 */             vacunaUsuario.setVacu_edad_mes16(new BigDecimal("0"));
/* 215:    */           }
/* 216:204 */           if (request.getParameter("vacu_edad_mes17" + x) != null) {
/* 217:205 */             vacunaUsuario.setVacu_edad_mes17(new BigDecimal("1"));
/* 218:    */           } else {
/* 219:207 */             vacunaUsuario.setVacu_edad_mes17(new BigDecimal("0"));
/* 220:    */           }
/* 221:208 */           if (request.getParameter("vacu_edad_mes18" + x) != null) {
/* 222:209 */             vacunaUsuario.setVacu_edad_mes18(new BigDecimal("1"));
/* 223:    */           } else {
/* 224:211 */             vacunaUsuario.setVacu_edad_mes18(new BigDecimal("0"));
/* 225:    */           }
/* 226:212 */           if (request.getParameter("vacu_edad_mes19" + x) != null) {
/* 227:213 */             vacunaUsuario.setVacu_edad_mes19(new BigDecimal("1"));
/* 228:    */           } else {
/* 229:215 */             vacunaUsuario.setVacu_edad_mes19(new BigDecimal("0"));
/* 230:    */           }
/* 231:216 */           if (request.getParameter("vacu_edad_mes20" + x) != null) {
/* 232:217 */             vacunaUsuario.setVacu_edad_mes20(new BigDecimal("1"));
/* 233:    */           } else {
/* 234:219 */             vacunaUsuario.setVacu_edad_mes20(new BigDecimal("0"));
/* 235:    */           }
/* 236:220 */           if (request.getParameter("vacu_edad_mes21" + x) != null) {
/* 237:221 */             vacunaUsuario.setVacu_edad_mes21(new BigDecimal("1"));
/* 238:    */           } else {
/* 239:223 */             vacunaUsuario.setVacu_edad_mes21(new BigDecimal("0"));
/* 240:    */           }
/* 241:224 */           if (request.getParameter("vacu_edad_mes22" + x) != null) {
/* 242:225 */             vacunaUsuario.setVacu_edad_mes22(new BigDecimal("1"));
/* 243:    */           } else {
/* 244:227 */             vacunaUsuario.setVacu_edad_mes22(new BigDecimal("0"));
/* 245:    */           }
/* 246:228 */           if (request.getParameter("vacu_edad_mes23" + x) != null) {
/* 247:229 */             vacunaUsuario.setVacu_edad_mes23(new BigDecimal("1"));
/* 248:    */           } else {
/* 249:231 */             vacunaUsuario.setVacu_edad_mes23(new BigDecimal("0"));
/* 250:    */           }
/* 251:232 */           if (request.getParameter("vacu_edad_mes24" + x) != null) {
/* 252:233 */             vacunaUsuario.setVacu_edad_mes24(new BigDecimal("1"));
/* 253:    */           } else {
/* 254:235 */             vacunaUsuario.setVacu_edad_mes24(new BigDecimal("0"));
/* 255:    */           }
/* 256:236 */           if (request.getParameter("vacu_edad_anno3" + x) != null) {
/* 257:237 */             vacunaUsuario.setVacu_edad_anno3(new BigDecimal("1"));
/* 258:    */           } else {
/* 259:239 */             vacunaUsuario.setVacu_edad_anno3(new BigDecimal("0"));
/* 260:    */           }
/* 261:240 */           if (request.getParameter("vacu_edad_anno4" + x) != null) {
/* 262:241 */             vacunaUsuario.setVacu_edad_anno4(new BigDecimal("1"));
/* 263:    */           } else {
/* 264:243 */             vacunaUsuario.setVacu_edad_anno4(new BigDecimal("0"));
/* 265:    */           }
/* 266:244 */           if (request.getParameter("vacu_edad_anno5" + x) != null) {
/* 267:245 */             vacunaUsuario.setVacu_edad_anno5(new BigDecimal("1"));
/* 268:    */           } else {
/* 269:247 */             vacunaUsuario.setVacu_edad_anno5(new BigDecimal("0"));
/* 270:    */           }
/* 271:248 */           if (request.getParameter("vacu_edad_anno6" + x) != null) {
/* 272:249 */             vacunaUsuario.setVacu_edad_anno6(new BigDecimal("1"));
/* 273:    */           } else {
/* 274:251 */             vacunaUsuario.setVacu_edad_anno6(new BigDecimal("0"));
/* 275:    */           }
/* 276:252 */           if (request.getParameter("vacu_edad_anno7" + x) != null) {
/* 277:253 */             vacunaUsuario.setVacu_edad_anno7(new BigDecimal("1"));
/* 278:    */           } else {
/* 279:255 */             vacunaUsuario.setVacu_edad_anno7(new BigDecimal("0"));
/* 280:    */           }
/* 281:256 */           if (request.getParameter("vacu_edad_anno8" + x) != null) {
/* 282:257 */             vacunaUsuario.setVacu_edad_anno8(new BigDecimal("1"));
/* 283:    */           } else {
/* 284:259 */             vacunaUsuario.setVacu_edad_anno8(new BigDecimal("0"));
/* 285:    */           }
/* 286:260 */           if (request.getParameter("vacu_edad_anno9" + x) != null) {
/* 287:261 */             vacunaUsuario.setVacu_edad_anno9(new BigDecimal("1"));
/* 288:    */           } else {
/* 289:263 */             vacunaUsuario.setVacu_edad_anno9(new BigDecimal("0"));
/* 290:    */           }
/* 291:264 */           if (request.getParameter("vacu_edad_anno10" + x) != null) {
/* 292:265 */             vacunaUsuario.setVacu_edad_anno10(new BigDecimal("1"));
/* 293:    */           } else {
/* 294:267 */             vacunaUsuario.setVacu_edad_anno10(new BigDecimal("0"));
/* 295:    */           }
/* 296:268 */           if (request.getParameter("vacu_edad_anno11" + x) != null) {
/* 297:269 */             vacunaUsuario.setVacu_edad_anno11(new BigDecimal("1"));
/* 298:    */           } else {
/* 299:271 */             vacunaUsuario.setVacu_edad_anno11(new BigDecimal("0"));
/* 300:    */           }
/* 301:272 */           if (request.getParameter("vacu_edad_anno12" + x) != null) {
/* 302:273 */             vacunaUsuario.setVacu_edad_anno12(new BigDecimal("1"));
/* 303:    */           } else {
/* 304:275 */             vacunaUsuario.setVacu_edad_anno12(new BigDecimal("0"));
/* 305:    */           }
/* 306:276 */           if (request.getParameter("vacu_edad_anno13" + x) != null) {
/* 307:277 */             vacunaUsuario.setVacu_edad_anno13(new BigDecimal("1"));
/* 308:    */           } else {
/* 309:279 */             vacunaUsuario.setVacu_edad_anno13(new BigDecimal("0"));
/* 310:    */           }
/* 311:280 */           if (request.getParameter("vacu_edad_anno14" + x) != null) {
/* 312:281 */             vacunaUsuario.setVacu_edad_anno14(new BigDecimal("1"));
/* 313:    */           } else {
/* 314:283 */             vacunaUsuario.setVacu_edad_anno14(new BigDecimal("0"));
/* 315:    */           }
/* 316:284 */           if (request.getParameter("vacu_edad_anno15" + x) != null) {
/* 317:285 */             vacunaUsuario.setVacu_edad_anno15(new BigDecimal("1"));
/* 318:    */           } else {
/* 319:287 */             vacunaUsuario.setVacu_edad_anno15(new BigDecimal("0"));
/* 320:    */           }
/* 321:288 */           if (request.getParameter("vacu_edad_anno16" + x) != null) {
/* 322:289 */             vacunaUsuario.setVacu_edad_anno16(new BigDecimal("1"));
/* 323:    */           } else {
/* 324:291 */             vacunaUsuario.setVacu_edad_anno16(new BigDecimal("0"));
/* 325:    */           }
/* 326:292 */           if (request.getParameter("vacu_edad_anno17" + x) != null) {
/* 327:293 */             vacunaUsuario.setVacu_edad_anno17(new BigDecimal("1"));
/* 328:    */           } else {
/* 329:295 */             vacunaUsuario.setVacu_edad_anno17(new BigDecimal("0"));
/* 330:    */           }
/* 331:296 */           if (request.getParameter("vacu_edad_anno18" + x) != null) {
/* 332:297 */             vacunaUsuario.setVacu_edad_anno18(new BigDecimal("1"));
/* 333:    */           } else {
/* 334:299 */             vacunaUsuario.setVacu_edad_anno18(new BigDecimal("0"));
/* 335:    */           }
/* 336:300 */           if (request.getParameter("vacu_edad_anno20" + x) != null) {
/* 337:301 */             vacunaUsuario.setVacu_edad_anno20(new BigDecimal("1"));
/* 338:    */           } else {
/* 339:303 */             vacunaUsuario.setVacu_edad_anno20(new BigDecimal("0"));
/* 340:    */           }
/* 341:304 */           if (request.getParameter("vacu_edad_anno30" + x) != null) {
/* 342:305 */             vacunaUsuario.setVacu_edad_anno30(new BigDecimal("1"));
/* 343:    */           } else {
/* 344:307 */             vacunaUsuario.setVacu_edad_anno30(new BigDecimal("0"));
/* 345:    */           }
/* 346:308 */           if (request.getParameter("vacu_edad_anno40" + x) != null) {
/* 347:309 */             vacunaUsuario.setVacu_edad_anno40(new BigDecimal("1"));
/* 348:    */           } else {
/* 349:311 */             vacunaUsuario.setVacu_edad_anno40(new BigDecimal("0"));
/* 350:    */           }
/* 351:312 */           if (request.getParameter("vacu_edad_anno50" + x) != null) {
/* 352:313 */             vacunaUsuario.setVacu_edad_anno50(new BigDecimal("1"));
/* 353:    */           } else {
/* 354:315 */             vacunaUsuario.setVacu_edad_anno50(new BigDecimal("0"));
/* 355:    */           }
/* 356:316 */           if (request.getParameter("vacu_edad_anno60" + x) != null) {
/* 357:317 */             vacunaUsuario.setVacu_edad_anno60(new BigDecimal("1"));
/* 358:    */           } else {
/* 359:319 */             vacunaUsuario.setVacu_edad_anno60(new BigDecimal("0"));
/* 360:    */           }
/* 361:320 */           if (request.getParameter("vacu_edad_anno70" + x) != null) {
/* 362:321 */             vacunaUsuario.setVacu_edad_anno70(new BigDecimal("1"));
/* 363:    */           } else {
/* 364:323 */             vacunaUsuario.setVacu_edad_anno70(new BigDecimal("0"));
/* 365:    */           }
/* 366:324 */           if (request.getParameter("vacu_edad_anno80" + x) != null) {
/* 367:325 */             vacunaUsuario.setVacu_edad_anno80(new BigDecimal("1"));
/* 368:    */           } else {
/* 369:327 */             vacunaUsuario.setVacu_edad_anno80(new BigDecimal("0"));
/* 370:    */           }
/* 371:328 */           if (request.getParameter("vacu_edad_anno90" + x) != null) {
/* 372:329 */             vacunaUsuario.setVacu_edad_anno90(new BigDecimal("1"));
/* 373:    */           } else {
/* 374:331 */             vacunaUsuario.setVacu_edad_anno90(new BigDecimal("0"));
/* 375:    */           }
/* 376:333 */           vacunaUsuario.setVacu_usuf_cod(usuarioFamily.getUsuf_cod());
/* 377:334 */           vacunaUsuario.setVacu_grup_cod(IGrupos.FAMILY_VACUNAS);
/* 378:335 */           x++;
/* 379:    */         }
/* 380:    */       }
/* 381:341 */       request.getSession().setAttribute("USUARIO_VACUNAS", vacunasUsuario);
/* 382:    */       
/* 383:343 */       VacunasDAO vacunasDAO = new VacunasDAO();
/* 384:344 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 385:345 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 386:346 */         vacunasDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 387:    */       }
/* 388:348 */       //vacunasDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    vacunasDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 389:349 */       int i = 0;
/* 390:350 */       while (i < vacunasUsuario.size())
/* 391:    */       {
/* 392:351 */         request.setAttribute("vacu_des" + i, vacunasDAO.retrieve(((VacunasUsuario)vacunasUsuario.get(i)).getVacu_vac_cod()).getVac_des());
/* 393:352 */         i++;
/* 394:    */       }
/* 395:    */     }
/* 396:    */     catch (Exception e)
/* 397:    */     {
/* 398:356 */       e.printStackTrace();
/* 399:357 */       return mapping.findForward("failure");
/* 400:    */     }
/* 401:360 */     if (request.getParameter("redirect") != null) {
/* 402:361 */       return new ActionForward(request.getParameter("redirect"));
/* 403:    */     }
/* 404:363 */     return mapping.findForward("success");
/* 405:    */   }
/* 406:    */   
/* 407:    */   private ActionForward performSave(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 408:    */   {
/* 409:367 */     ControlVacunasForm form = (ControlVacunasForm)actionForm;
/* 410:    */     try
/* 411:    */     {
/* 412:371 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/* 413:372 */       String ProximaCita = null;
/* 414:373 */       int NoDiasAntes = new Integer(form.getGrupu_dias_antes().toString()).intValue();
/* 415:374 */       VacunasCompletoDAO vacunasCompletoDAO = new VacunasCompletoDAO();
/* 416:375 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 417:376 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 418:377 */         vacunasCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 419:    */       }
/* 420:379 */       //vacunasCompletoDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    vacunasCompletoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 421:    */       
/* 422:381 */       VacunasCompleto vacunasCompleto = vacunasCompletoDAO.retrieve(usuarioFamily.getUsuf_cod());
/* 423:382 */       int num_vacunas = ((List)request.getSession().getAttribute("USUARIO_VACUNAS")).size();
/* 424:    */       
/* 425:384 */       int x = 0;
/* 426:    */       
/* 427:386 */       List tablaAjustada = (List)request.getSession().getAttribute("USUARIO_VACUNAS");
/* 428:    */       
/* 429:388 */       DatosPersonalesDAO datosPersonalesDAO = new DatosPersonalesDAO();
/* 430:389 */       DatosPersonales datosPersonales = datosPersonalesDAO.retrive(usuarioFamily.getUsuf_cod());
/* 431:    */       
/* 432:    */ 
/* 433:392 */       String fechaNacimiento = datosPersonales.getDatp_fecnacim().toString();
/* 434:393 */       String fechaActual = ManejoFechas.getFechaActual();
/* 435:394 */       String controlActual = fechaNacimiento;
/* 436:395 */       int meses = 0;
/* 437:396 */       while (controlActual.compareTo(fechaActual) < 1)
/* 438:    */       {
/* 439:397 */         controlActual = GestorFechasCompleto.fechaMasMeses(controlActual, "yyyyMMdd", 1);
/* 440:398 */         meses++;
/* 441:    */       }
/* 442:400 */       meses--;
/* 443:401 */       while (x < num_vacunas)
/* 444:    */       {
/* 445:402 */         VacunasUsuario vacunaUsuario = (VacunasUsuario)tablaAjustada.get(x);
/* 446:403 */         if (request.getParameter("vacu_edad_mes1" + x) != null) {
/* 447:404 */           vacunaUsuario.setVacu_edad_mes1(new BigDecimal("1"));
/* 448:    */         } else {
/* 449:406 */           vacunaUsuario.setVacu_edad_mes1(new BigDecimal("0"));
/* 450:    */         }
/* 451:407 */         if (request.getParameter("vacu_edad_mes2" + x) != null) {
/* 452:408 */           vacunaUsuario.setVacu_edad_mes2(new BigDecimal("1"));
/* 453:    */         } else {
/* 454:410 */           vacunaUsuario.setVacu_edad_mes2(new BigDecimal("0"));
/* 455:    */         }
/* 456:411 */         if (request.getParameter("vacu_edad_mes3" + x) != null) {
/* 457:412 */           vacunaUsuario.setVacu_edad_mes3(new BigDecimal("1"));
/* 458:    */         } else {
/* 459:414 */           vacunaUsuario.setVacu_edad_mes3(new BigDecimal("0"));
/* 460:    */         }
/* 461:415 */         if (request.getParameter("vacu_edad_mes4" + x) != null) {
/* 462:416 */           vacunaUsuario.setVacu_edad_mes4(new BigDecimal("1"));
/* 463:    */         } else {
/* 464:418 */           vacunaUsuario.setVacu_edad_mes4(new BigDecimal("0"));
/* 465:    */         }
/* 466:419 */         if (request.getParameter("vacu_edad_mes5" + x) != null) {
/* 467:420 */           vacunaUsuario.setVacu_edad_mes5(new BigDecimal("1"));
/* 468:    */         } else {
/* 469:422 */           vacunaUsuario.setVacu_edad_mes5(new BigDecimal("0"));
/* 470:    */         }
/* 471:423 */         if (request.getParameter("vacu_edad_mes6" + x) != null) {
/* 472:424 */           vacunaUsuario.setVacu_edad_mes6(new BigDecimal("1"));
/* 473:    */         } else {
/* 474:426 */           vacunaUsuario.setVacu_edad_mes6(new BigDecimal("0"));
/* 475:    */         }
/* 476:427 */         if (request.getParameter("vacu_edad_mes7" + x) != null) {
/* 477:428 */           vacunaUsuario.setVacu_edad_mes7(new BigDecimal("1"));
/* 478:    */         } else {
/* 479:430 */           vacunaUsuario.setVacu_edad_mes7(new BigDecimal("0"));
/* 480:    */         }
/* 481:431 */         if (request.getParameter("vacu_edad_mes8" + x) != null) {
/* 482:432 */           vacunaUsuario.setVacu_edad_mes8(new BigDecimal("1"));
/* 483:    */         } else {
/* 484:434 */           vacunaUsuario.setVacu_edad_mes8(new BigDecimal("0"));
/* 485:    */         }
/* 486:435 */         if (request.getParameter("vacu_edad_mes9" + x) != null) {
/* 487:436 */           vacunaUsuario.setVacu_edad_mes9(new BigDecimal("1"));
/* 488:    */         } else {
/* 489:438 */           vacunaUsuario.setVacu_edad_mes9(new BigDecimal("0"));
/* 490:    */         }
/* 491:439 */         if (request.getParameter("vacu_edad_mes10" + x) != null) {
/* 492:440 */           vacunaUsuario.setVacu_edad_mes10(new BigDecimal("1"));
/* 493:    */         } else {
/* 494:442 */           vacunaUsuario.setVacu_edad_mes10(new BigDecimal("0"));
/* 495:    */         }
/* 496:443 */         if (request.getParameter("vacu_edad_mes11" + x) != null) {
/* 497:444 */           vacunaUsuario.setVacu_edad_mes11(new BigDecimal("1"));
/* 498:    */         } else {
/* 499:446 */           vacunaUsuario.setVacu_edad_mes11(new BigDecimal("0"));
/* 500:    */         }
/* 501:447 */         if (request.getParameter("vacu_edad_mes12" + x) != null) {
/* 502:448 */           vacunaUsuario.setVacu_edad_mes12(new BigDecimal("1"));
/* 503:    */         } else {
/* 504:450 */           vacunaUsuario.setVacu_edad_mes12(new BigDecimal("0"));
/* 505:    */         }
/* 506:451 */         if (request.getParameter("vacu_edad_mes13" + x) != null) {
/* 507:452 */           vacunaUsuario.setVacu_edad_mes13(new BigDecimal("1"));
/* 508:    */         } else {
/* 509:454 */           vacunaUsuario.setVacu_edad_mes13(new BigDecimal("0"));
/* 510:    */         }
/* 511:455 */         if (request.getParameter("vacu_edad_mes14" + x) != null) {
/* 512:456 */           vacunaUsuario.setVacu_edad_mes14(new BigDecimal("1"));
/* 513:    */         } else {
/* 514:458 */           vacunaUsuario.setVacu_edad_mes14(new BigDecimal("0"));
/* 515:    */         }
/* 516:459 */         if (request.getParameter("vacu_edad_mes15" + x) != null) {
/* 517:460 */           vacunaUsuario.setVacu_edad_mes15(new BigDecimal("1"));
/* 518:    */         } else {
/* 519:462 */           vacunaUsuario.setVacu_edad_mes15(new BigDecimal("0"));
/* 520:    */         }
/* 521:463 */         if (request.getParameter("vacu_edad_mes16" + x) != null) {
/* 522:464 */           vacunaUsuario.setVacu_edad_mes16(new BigDecimal("1"));
/* 523:    */         } else {
/* 524:466 */           vacunaUsuario.setVacu_edad_mes16(new BigDecimal("0"));
/* 525:    */         }
/* 526:467 */         if (request.getParameter("vacu_edad_mes17" + x) != null) {
/* 527:468 */           vacunaUsuario.setVacu_edad_mes17(new BigDecimal("1"));
/* 528:    */         } else {
/* 529:470 */           vacunaUsuario.setVacu_edad_mes17(new BigDecimal("0"));
/* 530:    */         }
/* 531:471 */         if (request.getParameter("vacu_edad_mes18" + x) != null) {
/* 532:472 */           vacunaUsuario.setVacu_edad_mes18(new BigDecimal("1"));
/* 533:    */         } else {
/* 534:474 */           vacunaUsuario.setVacu_edad_mes18(new BigDecimal("0"));
/* 535:    */         }
/* 536:475 */         if (request.getParameter("vacu_edad_mes19" + x) != null) {
/* 537:476 */           vacunaUsuario.setVacu_edad_mes19(new BigDecimal("1"));
/* 538:    */         } else {
/* 539:478 */           vacunaUsuario.setVacu_edad_mes19(new BigDecimal("0"));
/* 540:    */         }
/* 541:479 */         if (request.getParameter("vacu_edad_mes20" + x) != null) {
/* 542:480 */           vacunaUsuario.setVacu_edad_mes20(new BigDecimal("1"));
/* 543:    */         } else {
/* 544:482 */           vacunaUsuario.setVacu_edad_mes20(new BigDecimal("0"));
/* 545:    */         }
/* 546:483 */         if (request.getParameter("vacu_edad_mes21" + x) != null) {
/* 547:484 */           vacunaUsuario.setVacu_edad_mes21(new BigDecimal("1"));
/* 548:    */         } else {
/* 549:486 */           vacunaUsuario.setVacu_edad_mes21(new BigDecimal("0"));
/* 550:    */         }
/* 551:487 */         if (request.getParameter("vacu_edad_mes22" + x) != null) {
/* 552:488 */           vacunaUsuario.setVacu_edad_mes22(new BigDecimal("1"));
/* 553:    */         } else {
/* 554:490 */           vacunaUsuario.setVacu_edad_mes22(new BigDecimal("0"));
/* 555:    */         }
/* 556:491 */         if (request.getParameter("vacu_edad_mes23" + x) != null) {
/* 557:492 */           vacunaUsuario.setVacu_edad_mes23(new BigDecimal("1"));
/* 558:    */         } else {
/* 559:494 */           vacunaUsuario.setVacu_edad_mes23(new BigDecimal("0"));
/* 560:    */         }
/* 561:495 */         if (request.getParameter("vacu_edad_mes24" + x) != null) {
/* 562:496 */           vacunaUsuario.setVacu_edad_mes24(new BigDecimal("1"));
/* 563:    */         } else {
/* 564:498 */           vacunaUsuario.setVacu_edad_mes24(new BigDecimal("0"));
/* 565:    */         }
/* 566:499 */         if (request.getParameter("vacu_edad_anno3" + x) != null) {
/* 567:500 */           vacunaUsuario.setVacu_edad_anno3(new BigDecimal("1"));
/* 568:    */         } else {
/* 569:502 */           vacunaUsuario.setVacu_edad_anno3(new BigDecimal("0"));
/* 570:    */         }
/* 571:503 */         if (request.getParameter("vacu_edad_anno4" + x) != null) {
/* 572:504 */           vacunaUsuario.setVacu_edad_anno4(new BigDecimal("1"));
/* 573:    */         } else {
/* 574:506 */           vacunaUsuario.setVacu_edad_anno4(new BigDecimal("0"));
/* 575:    */         }
/* 576:507 */         if (request.getParameter("vacu_edad_anno5" + x) != null) {
/* 577:508 */           vacunaUsuario.setVacu_edad_anno5(new BigDecimal("1"));
/* 578:    */         } else {
/* 579:510 */           vacunaUsuario.setVacu_edad_anno5(new BigDecimal("0"));
/* 580:    */         }
/* 581:511 */         if (request.getParameter("vacu_edad_anno6" + x) != null) {
/* 582:512 */           vacunaUsuario.setVacu_edad_anno6(new BigDecimal("1"));
/* 583:    */         } else {
/* 584:514 */           vacunaUsuario.setVacu_edad_anno6(new BigDecimal("0"));
/* 585:    */         }
/* 586:515 */         if (request.getParameter("vacu_edad_anno7" + x) != null) {
/* 587:516 */           vacunaUsuario.setVacu_edad_anno7(new BigDecimal("1"));
/* 588:    */         } else {
/* 589:518 */           vacunaUsuario.setVacu_edad_anno7(new BigDecimal("0"));
/* 590:    */         }
/* 591:519 */         if (request.getParameter("vacu_edad_anno8" + x) != null) {
/* 592:520 */           vacunaUsuario.setVacu_edad_anno8(new BigDecimal("1"));
/* 593:    */         } else {
/* 594:522 */           vacunaUsuario.setVacu_edad_anno8(new BigDecimal("0"));
/* 595:    */         }
/* 596:523 */         if (request.getParameter("vacu_edad_anno9" + x) != null) {
/* 597:524 */           vacunaUsuario.setVacu_edad_anno9(new BigDecimal("1"));
/* 598:    */         } else {
/* 599:526 */           vacunaUsuario.setVacu_edad_anno9(new BigDecimal("0"));
/* 600:    */         }
/* 601:527 */         if (request.getParameter("vacu_edad_anno10" + x) != null) {
/* 602:528 */           vacunaUsuario.setVacu_edad_anno10(new BigDecimal("1"));
/* 603:    */         } else {
/* 604:530 */           vacunaUsuario.setVacu_edad_anno10(new BigDecimal("0"));
/* 605:    */         }
/* 606:531 */         if (request.getParameter("vacu_edad_anno11" + x) != null) {
/* 607:532 */           vacunaUsuario.setVacu_edad_anno11(new BigDecimal("1"));
/* 608:    */         } else {
/* 609:534 */           vacunaUsuario.setVacu_edad_anno11(new BigDecimal("0"));
/* 610:    */         }
/* 611:535 */         if (request.getParameter("vacu_edad_anno12" + x) != null) {
/* 612:536 */           vacunaUsuario.setVacu_edad_anno12(new BigDecimal("1"));
/* 613:    */         } else {
/* 614:538 */           vacunaUsuario.setVacu_edad_anno12(new BigDecimal("0"));
/* 615:    */         }
/* 616:539 */         if (request.getParameter("vacu_edad_anno13" + x) != null) {
/* 617:540 */           vacunaUsuario.setVacu_edad_anno13(new BigDecimal("1"));
/* 618:    */         } else {
/* 619:542 */           vacunaUsuario.setVacu_edad_anno13(new BigDecimal("0"));
/* 620:    */         }
/* 621:543 */         if (request.getParameter("vacu_edad_anno14" + x) != null) {
/* 622:544 */           vacunaUsuario.setVacu_edad_anno14(new BigDecimal("1"));
/* 623:    */         } else {
/* 624:546 */           vacunaUsuario.setVacu_edad_anno14(new BigDecimal("0"));
/* 625:    */         }
/* 626:547 */         if (request.getParameter("vacu_edad_anno15" + x) != null) {
/* 627:548 */           vacunaUsuario.setVacu_edad_anno15(new BigDecimal("1"));
/* 628:    */         } else {
/* 629:550 */           vacunaUsuario.setVacu_edad_anno15(new BigDecimal("0"));
/* 630:    */         }
/* 631:551 */         if (request.getParameter("vacu_edad_anno16" + x) != null) {
/* 632:552 */           vacunaUsuario.setVacu_edad_anno16(new BigDecimal("1"));
/* 633:    */         } else {
/* 634:554 */           vacunaUsuario.setVacu_edad_anno16(new BigDecimal("0"));
/* 635:    */         }
/* 636:555 */         if (request.getParameter("vacu_edad_anno17" + x) != null) {
/* 637:556 */           vacunaUsuario.setVacu_edad_anno17(new BigDecimal("1"));
/* 638:    */         } else {
/* 639:558 */           vacunaUsuario.setVacu_edad_anno17(new BigDecimal("0"));
/* 640:    */         }
/* 641:559 */         if (request.getParameter("vacu_edad_anno18" + x) != null) {
/* 642:560 */           vacunaUsuario.setVacu_edad_anno18(new BigDecimal("1"));
/* 643:    */         } else {
/* 644:562 */           vacunaUsuario.setVacu_edad_anno18(new BigDecimal("0"));
/* 645:    */         }
/* 646:563 */         if (request.getParameter("vacu_edad_anno20" + x) != null) {
/* 647:564 */           vacunaUsuario.setVacu_edad_anno20(new BigDecimal("1"));
/* 648:    */         } else {
/* 649:566 */           vacunaUsuario.setVacu_edad_anno20(new BigDecimal("0"));
/* 650:    */         }
/* 651:567 */         if (request.getParameter("vacu_edad_anno30" + x) != null) {
/* 652:568 */           vacunaUsuario.setVacu_edad_anno30(new BigDecimal("1"));
/* 653:    */         } else {
/* 654:570 */           vacunaUsuario.setVacu_edad_anno30(new BigDecimal("0"));
/* 655:    */         }
/* 656:571 */         if (request.getParameter("vacu_edad_anno40" + x) != null) {
/* 657:572 */           vacunaUsuario.setVacu_edad_anno40(new BigDecimal("1"));
/* 658:    */         } else {
/* 659:574 */           vacunaUsuario.setVacu_edad_anno40(new BigDecimal("0"));
/* 660:    */         }
/* 661:575 */         if (request.getParameter("vacu_edad_anno50" + x) != null) {
/* 662:576 */           vacunaUsuario.setVacu_edad_anno50(new BigDecimal("1"));
/* 663:    */         } else {
/* 664:578 */           vacunaUsuario.setVacu_edad_anno50(new BigDecimal("0"));
/* 665:    */         }
/* 666:579 */         if (request.getParameter("vacu_edad_anno60" + x) != null) {
/* 667:580 */           vacunaUsuario.setVacu_edad_anno60(new BigDecimal("1"));
/* 668:    */         } else {
/* 669:582 */           vacunaUsuario.setVacu_edad_anno60(new BigDecimal("0"));
/* 670:    */         }
/* 671:583 */         if (request.getParameter("vacu_edad_anno70" + x) != null) {
/* 672:584 */           vacunaUsuario.setVacu_edad_anno70(new BigDecimal("1"));
/* 673:    */         } else {
/* 674:586 */           vacunaUsuario.setVacu_edad_anno70(new BigDecimal("0"));
/* 675:    */         }
/* 676:587 */         if (request.getParameter("vacu_edad_anno80" + x) != null) {
/* 677:588 */           vacunaUsuario.setVacu_edad_anno80(new BigDecimal("1"));
/* 678:    */         } else {
/* 679:590 */           vacunaUsuario.setVacu_edad_anno80(new BigDecimal("0"));
/* 680:    */         }
/* 681:591 */         if (request.getParameter("vacu_edad_anno90" + x) != null) {
/* 682:592 */           vacunaUsuario.setVacu_edad_anno90(new BigDecimal("1"));
/* 683:    */         } else {
/* 684:594 */           vacunaUsuario.setVacu_edad_anno90(new BigDecimal("0"));
/* 685:    */         }
/* 686:596 */         vacunaUsuario.setVacu_usuf_cod(usuarioFamily.getUsuf_cod());
/* 687:597 */         vacunaUsuario.setVacu_grup_cod(IGrupos.FAMILY_VACUNAS);
/* 688:    */         
/* 689:599 */         int proximaeleccion = -1;
/* 690:600 */         boolean escogido = false;
/* 691:601 */         boolean terminado = false;
/* 692:602 */         while ((!escogido) && (!terminado))
/* 693:    */         {
/* 694:603 */           int i = meses;
/* 695:604 */           while (i < 25)
/* 696:    */           {
/* 697:605 */             if (request.getParameter("vacu_edad_mes" + i + x) != null)
/* 698:    */             {
/* 699:606 */               proximaeleccion = i;
/* 700:607 */               escogido = true;
/* 701:608 */               i = 25;
/* 702:    */             }
/* 703:610 */             i++;
/* 704:    */           }
/* 705:612 */           if ((i > 25) && (!escogido))
/* 706:    */           {
/* 707:613 */             int anniox = meses / 12;
/* 708:614 */             if (anniox < 20) {
/* 709:614 */               anniox++;
/* 710:    */             } else {
/* 711:615 */               anniox += 10;
/* 712:    */             }
/* 713:617 */             while (anniox < 100)
/* 714:    */             {
/* 715:618 */               if (request.getParameter("vacu_edad_anno" + anniox + x) != null)
/* 716:    */               {
/* 717:619 */                 proximaeleccion = anniox;
/* 718:620 */                 escogido = true;
/* 719:621 */                 anniox = 200;
/* 720:    */               }
/* 721:623 */               if (anniox < 20) {
/* 722:623 */                 anniox++;
/* 723:    */               } else {
/* 724:624 */                 anniox += 10;
/* 725:    */               }
/* 726:    */             }
/* 727:626 */             if (anniox >= 100) {
/* 728:626 */               terminado = true;
/* 729:    */             }
/* 730:    */           }
/* 731:    */         }
/* 732:629 */         proximaeleccion = proximaeleccion * 12 - meses;
/* 733:630 */         if (escogido)
/* 734:    */         {
/* 735:631 */           ProximaCita = GestorFechasCompleto.fechaMasMeses(controlActual, "yyyyMMdd", -1);
/* 736:632 */           ProximaCita = GestorFechasCompleto.fechaMasMeses(ProximaCita, "yyyyMMdd", proximaeleccion);
/* 737:633 */           vacunaUsuario.setVacu_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(ProximaCita), "yyyyMMdd", -2)));
/* 738:634 */           vacunaUsuario.setVacu_fecenvion2(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(ProximaCita), "yyyyMMdd", -NoDiasAntes / 2)));
/* 739:635 */           vacunaUsuario.setVacu_fecenvion(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(ProximaCita), "yyyyMMdd", -NoDiasAntes)));
/* 740:636 */           vacunaUsuario.setVacu_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(ProximaCita), "yyyyMMdd", 15)));
/* 741:    */         }
/* 742:638 */         tablaAjustada.set(x, vacunaUsuario);
/* 743:639 */         x++;
/* 744:    */       }
/* 745:641 */       request.getSession().setAttribute("USUARIO_VACUNAS", tablaAjustada);
/* 746:642 */       vacunasCompleto.setTablaAjustada(tablaAjustada);
/* 747:    */       
/* 748:    */ 
/* 749:645 */       GruposUsuario gruposUsuario = vacunasCompleto.getGrupoUsuario();
/* 750:646 */       gruposUsuario.setGrupu_usuf_cod(usuarioFamily.getUsuf_cod());
/* 751:    */       
/* 752:    */ 
/* 753:    */ 
/* 754:    */ 
/* 755:    */ 
/* 756:    */ 
/* 757:653 */       gruposUsuario.setGrupu_dias_antes(new BigDecimal(form.getGrupu_dias_antes()));
/* 758:    */       
/* 759:655 */       vacunasCompletoDAO.update(vacunasCompleto, usuarioFamily.getUsuf_cod());
/* 760:    */     }
/* 761:    */     catch (Exception e)
/* 762:    */     {
/* 763:658 */       e.printStackTrace();
/* 764:659 */       return mapping.findForward("failure");
/* 765:    */     }
/* 766:661 */     return mapping.findForward("success");
/* 767:    */   }
/* 768:    */ }



/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\

 * Qualified Name:     com.servidoctor.sdfamily.controller.ControlVacunasAction

 * JD-Core Version:    0.7.0.1

 */