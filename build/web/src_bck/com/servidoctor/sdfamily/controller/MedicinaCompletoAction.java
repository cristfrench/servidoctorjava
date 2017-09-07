/*   1:    */ package com.servidoctor.sdfamily.controller;
/*   2:    */ 
/*   3:    */ import com.essecorp.util.GestorFechasCompleto;
/*   4:    */ import com.servidoctor.common.controller.BaseAction;
/*   5:    */ import com.servidoctor.parametros.dao.GruposDAO;
/*   6:    */ import com.servidoctor.parametros.model.Examenes;
/*   7:    */ import com.servidoctor.parametros.model.Grupos;
/*   8:    */ import com.servidoctor.sdfamily.dao.DatosPersonalesDAO;
/*   9:    */ import com.servidoctor.sdfamily.dao.ExamenesUsuarioDAO;
/*  10:    */ import com.servidoctor.sdfamily.dao.MedicinaCompletoDAO;
/*  11:    */ import com.servidoctor.sdfamily.model.ControlMedico;
/*  12:    */ import com.servidoctor.sdfamily.model.DatosPersonales;
/*  13:    */ import com.servidoctor.sdfamily.model.ExamenesUsuario;
/*  14:    */ import com.servidoctor.sdfamily.model.GruposUsuario;
/*  15:    */ import com.servidoctor.sdfamily.model.MedicinaCompleto;
/*  16:    */ import com.servidoctor.seguridad.model.Servidores;
/*  17:    */ import com.servidoctor.seguridad.model.UsuarioFamily;
/*  18:    */ import com.servidoctor.util.classes.BorrarSession;
/*  19:    */ import com.servidoctor.util.classes.ManejoFechas;
/*  20:    */ import java.math.BigDecimal;
/*  21:    */ import java.util.ArrayList;
/*  22:    */ import java.util.List;
/*  23:    */ import javax.servlet.http.HttpServletRequest;
/*  24:    */ import javax.servlet.http.HttpServletResponse;
/*  25:    */ import javax.servlet.http.HttpSession;
/*  26:    */ import org.apache.struts.action.ActionForm;
/*  27:    */ import org.apache.struts.action.ActionForward;
/*  28:    */ import org.apache.struts.action.ActionMapping;
/*  29:    */ 
/*  30:    */ public class MedicinaCompletoAction
/*  31:    */   extends BaseAction
/*  32:    */ {
/*  33:    */   public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  34:    */     throws Exception
/*  35:    */   {
/*  36: 36 */     ActionForward myforward = super.execute(mapping, actionForm, request, response);
/*  37: 37 */     String myaction = mapping.getParameter();
/*  38: 39 */     if (myforward == null)
/*  39:    */     {
/*  40: 40 */       DatosPersonales datosPersonales = (DatosPersonales)request.getSession().getAttribute("datosPersonales");
/*  41: 41 */       if (datosPersonales.getDatp_usuf_cod() == null) {
/*  42: 42 */         myforward = mapping.findForward("datospersonales");
/*  43: 43 */       } else if ("".equalsIgnoreCase(myaction)) {
/*  44: 44 */         myforward = mapping.findForward("failure");
/*  45: 45 */       } else if ("VIEW".equalsIgnoreCase(myaction)) {
/*  46: 46 */         myforward = performView(mapping, actionForm, request, response);
/*  47: 47 */       } else if ("EDIT".equalsIgnoreCase(myaction)) {
/*  48: 48 */         myforward = performEdit(mapping, actionForm, request, response);
/*  49: 49 */       } else if ("ADD".equalsIgnoreCase(myaction)) {
/*  50: 50 */         myforward = performAdd(mapping, actionForm, request, response);
/*  51: 51 */       } else if ("SAVE".equalsIgnoreCase(myaction)) {
/*  52: 52 */         myforward = performSave(mapping, actionForm, request, response);
/*  53:    */       } else {
/*  54: 54 */         myforward = mapping.findForward("failure");
/*  55:    */       }
/*  56:    */     }
/*  57: 58 */     return myforward;
/*  58:    */   }
/*  59:    */   
/*  60:    */   private ActionForward performView(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  61:    */   {
/*  62: 62 */     MedicinaCompletoForm form = (MedicinaCompletoForm)actionForm;
/*  63: 63 */     Boolean nuevo = Boolean.valueOf(false);
/*  64:    */     try
/*  65:    */     {
/*  66: 66 */       BorrarSession.eliminaAtributos(request.getSession(), "medicinaCompletoForm");
/*  67:    */       
/*  68: 68 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/*  69:    */       
/*  70: 70 */       DatosPersonales datosPersonales = (DatosPersonales)request.getSession().getAttribute("datosPersonales");
/*  71:    */       
/*  72: 72 */       MedicinaCompletoDAO medicinaCompletoDAO = new MedicinaCompletoDAO();
/*  73: 73 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  74: 74 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  75: 75 */         medicinaCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  76:    */       }
/*  77: 77 */       //medicinaCompletoDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    medicinaCompletoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
                    
/*  78: 78 */       MedicinaCompleto medicinaCompleto = medicinaCompletoDAO.retrieve(usuarioFamily.getUsuf_cod(), datosPersonales.getDatp_sexo());
/*  79:    */       
/*  80: 80 */       List tablaUniversal = medicinaCompleto.getTablaUniversal();
/*  81: 81 */       request.getSession().setAttribute("EXAMENES", tablaUniversal);
/*  82:    */       
/*  83: 83 */       List tablaAjustada = medicinaCompleto.getTablaAjustada();
/*  84: 84 */       List controlesAnteriores = medicinaCompleto.getControlesAnteriores();
/*  85: 85 */       List controlesProximos = medicinaCompleto.getControlesProximos();
/*  86:    */       
/*  87: 87 */       request.getSession().setAttribute("EXAMENES_USUARIO", tablaAjustada);
/*  88: 88 */       request.getSession().setAttribute("CONTROLESANTERIORES", controlesAnteriores);
/*  89: 89 */       request.getSession().setAttribute("CONTROLESPROXIMOS", controlesProximos);
/*  90:    */       
/*  91: 91 */       int i = 0;
/*  92: 92 */       while (i < tablaUniversal.size())
/*  93:    */       {
/*  94: 93 */         Examenes examen = (Examenes)tablaUniversal.get(i);
/*  95: 94 */         request.setAttribute("exa_des" + examen.getExa_cod(), examen.getExa_des());
/*  96: 95 */         i++;
/*  97:    */       }
/*  98: 97 */       GruposDAO gruposDAO = new GruposDAO();
/*  99: 98 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 100: 99 */         gruposDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 101:    */       }
/* 102:101 */       //gruposDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    gruposDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 103:102 */       List gruposUsuario = medicinaCompleto.getGrupos();
/* 104:103 */       List gruposLabels = new ArrayList();
/* 105:104 */       i = 0;
/* 106:105 */       while (i < gruposUsuario.size())
/* 107:    */       {
/* 108:106 */         Grupos grupo = gruposDAO.retrive(((GruposUsuario)gruposUsuario.get(i)).getGrupu_grup_cod());
/* 109:107 */         gruposLabels.add(grupo);
/* 110:108 */         request.setAttribute("grupu_desc" + i, grupo.getGrup_desc());
/* 111:109 */         i++;
/* 112:    */       }
/* 113:112 */       request.getSession().setAttribute("GRUPOSMEDICINA", gruposUsuario);
/* 114:113 */       request.setAttribute("GRUPOS", gruposLabels);
/* 115:    */     }
/* 116:    */     catch (Exception e)
/* 117:    */     {
/* 118:117 */       e.printStackTrace();
/* 119:118 */       return mapping.findForward("failure");
/* 120:    */     }
/* 121:120 */     return mapping.findForward("success");
/* 122:    */   }
/* 123:    */   
/* 124:    */   private ActionForward performEdit(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 125:    */   {
/* 126:124 */     MedicinaCompletoForm form = (MedicinaCompletoForm)actionForm;
/* 127:    */     
/* 128:    */ 
/* 129:    */ 
/* 130:    */ 
/* 131:    */ 
/* 132:    */ 
/* 133:    */ 
/* 134:132 */     return mapping.findForward("success");
/* 135:    */   }
/* 136:    */   
/* 137:    */   private ActionForward performAdd(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 138:    */   {
/* 139:136 */     MedicinaCompletoForm form = (MedicinaCompletoForm)actionForm;
/* 140:    */     try
/* 141:    */     {
/* 142:140 */       List controlesProximos = (List)request.getSession().getAttribute("CONTROLESPROXIMOS");
/* 143:141 */       List controlesAnteriores = (List)request.getSession().getAttribute("CONTROLESANTERIORES");
/* 144:142 */       int x = 0;
/* 145:143 */       if (request.getParameter("control[0].cmed_grup_cod") != null)
/* 146:    */       {
/* 147:144 */         while (x < controlesProximos.size())
/* 148:    */         {
/* 149:145 */           ControlMedico controlMedico = (ControlMedico)controlesProximos.get(x);
/* 150:146 */           controlMedico.setCmed_grup_cod(new BigDecimal(request.getParameter("control[" + x + "].cmed_grup_cod")));
/* 151:147 */           controlMedico = (ControlMedico)controlesAnteriores.get(x);
/* 152:148 */           controlMedico.setCmed_grup_cod(new BigDecimal(request.getParameter("control[" + x + "].cmed_grup_cod")));
/* 153:149 */           x++;
/* 154:    */         }
/* 155:152 */         List grupos = (List)request.getSession().getAttribute("GRUPOSMEDICINA");
/* 156:153 */         x = 0;
/* 157:154 */         while (x < grupos.size())
/* 158:    */         {
/* 159:155 */           GruposUsuario grupoUsuario = (GruposUsuario)grupos.get(x);
/* 160:156 */           grupoUsuario.setGrupu_dias_antes(new BigDecimal(request.getParameter("grupo[" + x + "].grupu_dias_antes")));
/* 161:157 */           x++;
/* 162:    */         }
/* 163:    */       }
/* 164:161 */       List tablaUniversal = (List)request.getSession().getAttribute("EXAMENES");
/* 165:162 */       int i = 0;
/* 166:163 */       while (i < tablaUniversal.size())
/* 167:    */       {
/* 168:164 */         Examenes examen = (Examenes)tablaUniversal.get(i);
/* 169:165 */         request.setAttribute("exa_des" + examen.getExa_cod(), examen.getExa_des());
/* 170:166 */         i++;
/* 171:    */       }
/* 172:168 */       List gruposUsuario = (List)request.getSession().getAttribute("GRUPOSMEDICINA");
/* 173:169 */       GruposDAO gruposDAO = new GruposDAO();
/* 174:170 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 175:171 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 176:172 */         gruposDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 177:    */       }
/* 178:174 */       //gruposDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    gruposDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 179:175 */       List gruposLabels = new ArrayList();
/* 180:176 */       i = 0;
/* 181:177 */       while (i < gruposUsuario.size())
/* 182:    */       {
/* 183:178 */         Grupos grupo = gruposDAO.retrive(((GruposUsuario)gruposUsuario.get(i)).getGrupu_grup_cod());
/* 184:179 */         gruposLabels.add(grupo);
/* 185:180 */         request.setAttribute("grupu_desc" + i, grupo.getGrup_desc());
/* 186:181 */         i++;
/* 187:    */       }
/* 188:184 */       request.getSession().setAttribute("GRUPOSMEDICINA", gruposUsuario);
/* 189:185 */       request.setAttribute("GRUPOS", gruposLabels);
/* 190:186 */       request.getSession().setAttribute("CONTROLESANTERIORES", controlesAnteriores);
/* 191:187 */       request.getSession().setAttribute("CONTROLESPROXIMOS", controlesProximos);
/* 192:    */     }
/* 193:    */     catch (Exception e)
/* 194:    */     {
/* 195:191 */       e.printStackTrace();
/* 196:192 */       return mapping.findForward("failure");
/* 197:    */     }
/* 198:195 */     return mapping.findForward("success");
/* 199:    */   }
/* 200:    */   
/* 201:    */   private ActionForward performSave(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 202:    */   {
/* 203:199 */     MedicinaCompletoForm form = (MedicinaCompletoForm)actionForm;
/* 204:    */     try
/* 205:    */     {
/* 206:205 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/* 207:    */       
/* 208:207 */       ExamenesUsuarioDAO examenesUsuarioDAO = new ExamenesUsuarioDAO();
/* 209:208 */       MedicinaCompletoDAO medicinaCompletoDAO = new MedicinaCompletoDAO();
/* 210:209 */       String fechaActual = ManejoFechas.getFechaActual();
/* 211:210 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 212:211 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 213:212 */         medicinaCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 214:    */       }
/* 215:214 */       DatosPersonalesDAO datosPersonalesDAO = new DatosPersonalesDAO();
/* 216:215 */       DatosPersonales datosPersonales = datosPersonalesDAO.retrive(usuarioFamily.getUsuf_cod());
/* 217:216 */       //medicinaCompletoDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    medicinaCompletoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 218:217 */       MedicinaCompleto medicinaCompleto = medicinaCompletoDAO.retrieve(usuarioFamily.getUsuf_cod(), datosPersonales.getDatp_sexo().toString());
/* 219:    */       
/* 220:    */ 
/* 221:    */ 
/* 222:221 */       int diasAntesn = 0;
/* 223:222 */       int diasAntesn2 = 0;
/* 224:    */       
/* 225:    */ 
/* 226:    */ 
/* 227:    */ 
/* 228:    */ 
/* 229:    */ 
/* 230:    */ 
/* 231:    */ 
/* 232:    */ 
/* 233:    */ 
/* 234:    */ 
/* 235:    */ 
/* 236:    */ 
/* 237:    */ 
/* 238:    */ 
/* 239:    */ 
/* 240:    */ 
/* 241:    */ 
/* 242:    */ 
/* 243:242 */       List grupos = (List)request.getSession().getAttribute("GRUPOSMEDICINA");
/* 244:243 */       List gruposX = new ArrayList();
/* 245:244 */       gruposX.clear();
/* 246:245 */       int x = 0;
/* 247:247 */       while (x < grupos.size())
/* 248:    */       {
/* 249:248 */         GruposUsuario grupoUsuario = (GruposUsuario)grupos.get(x);
/* 250:249 */         String gruposDiasantes = request.getParameter(new StringBuilder("grupo[").append(x).append("].grupu_dias_antes").toString());
/* 251:    */         
/* 252:    */ 
/* 253:252 */         grupoUsuario.setGrupu_dias_antes(new BigDecimal(request.getParameter("grupo[" + x + "].grupu_dias_antes")));
/* 254:    */         
/* 255:254 */         x++;
/* 256:255 */         gruposX.add(grupoUsuario);
/* 257:    */       }
/* 258:260 */       request.getSession().setAttribute("GRUPOSMEDICINA", gruposX);
/* 259:    */       
/* 260:    */ 
/* 261:263 */       List tablaAjustada = (List)request.getSession().getAttribute("EXAMENES_USUARIO");
/* 262:264 */       List controlesAnteriores = (List)request.getSession().getAttribute("CONTROLESANTERIORES");
/* 263:265 */       List controlesProximos = (List)request.getSession().getAttribute("CONTROLESPROXIMOS");
/* 264:266 */       List gruposUsuario = (List)request.getSession().getAttribute("GRUPOSMEDICINA");
/* 265:    */       
/* 266:    */ 
/* 267:    */ 
/* 268:    */ 
/* 269:    */ 
/* 270:272 */       int limite = controlesProximos.size() - 1;
/* 271:273 */       for (int i = 0; i <= limite; i++)
/* 272:    */       {
/* 273:274 */         ControlMedico controlMedicoPC = (ControlMedico)controlesProximos.get(i);
/* 274:275 */         ControlMedico controlMedicoUC = (ControlMedico)controlesAnteriores.get(i);
/* 275:276 */         ExamenesUsuario examenesUsuario = (ExamenesUsuario)tablaAjustada.get(i);
/* 276:    */         
/* 277:278 */         int minEdad = examenesUsuario.getExau_edad().intValue() * 12;
/* 278:280 */         for (x = 0; x < gruposX.size(); x++)
/* 279:    */         {
/* 280:281 */           GruposUsuario grupoUsuario2 = (GruposUsuario)gruposUsuario.get(x);
/* 281:282 */           if (controlMedicoPC.getCmed_grup_cod().equals(grupoUsuario2.getGrupu_grup_cod()))
/* 282:    */           {
/* 283:283 */             diasAntesn = grupoUsuario2.getGrupu_dias_antes().intValue();
/* 284:284 */             diasAntesn2 = diasAntesn / 2;
/* 285:285 */             x = gruposX.size();
/* 286:    */           }
/* 287:    */         }
/* 288:290 */         String controlActual = datosPersonales.getDatp_fecnacim().toString();
/* 289:291 */         List examenesUsuario2 = examenesUsuarioDAO.list2(controlMedicoPC.getCmed_usuf_cod(), controlMedicoPC.getCmed_cod());
/* 290:294 */         if (examenesUsuario2.size() != 0)
/* 291:    */         {
/* 292:296 */           ExamenesUsuario exaUsuarioCodigo = (ExamenesUsuario)examenesUsuario2.get(0);
/* 293:297 */           controlMedicoPC.setCmed_exa_cod(exaUsuarioCodigo.getExau_exa_cod());
/* 294:298 */           controlMedicoPC.setElementoTabla(exaUsuarioCodigo);
/* 295:299 */           controlMedicoUC.setCmed_exa_cod(exaUsuarioCodigo.getExau_exa_cod());
/* 296:300 */           controlMedicoUC.setElementoTabla(exaUsuarioCodigo);
/* 297:    */         }
/* 298:307 */         int frecuencia = examenesUsuario.getExau_frecuencia().intValue();
/* 299:310 */         if ((controlMedicoPC.getCmed_feccontrol().equals(controlMedicoUC.getCmed_feccontrol())) && (controlMedicoPC.getCmed_feccontrol().toString().equals("0")))
/* 300:    */         {
/* 301:312 */           if (GestorFechasCompleto.convertStringToLong(GestorFechasCompleto.fechaMasMeses(datosPersonales.getDatp_fecnacim().toString(), "yyyyMMdd", minEdad), "yyyyMMdd") < System.currentTimeMillis())
/* 302:    */           {
/* 303:313 */             while (controlActual.compareTo(fechaActual) < 1) {
/* 304:314 */               controlActual = GestorFechasCompleto.fechaMasMeses(controlActual, "yyyyMMdd", frecuencia);
/* 305:    */             }
/* 306:316 */             controlMedicoUC.setCmed_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlActual), "yyyyMMdd", -2)));
/* 307:317 */             controlMedicoUC.setCmed_fecenvion(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlActual), "yyyyMMdd", -diasAntesn)));
/* 308:318 */             controlMedicoUC.setCmed_fecenvion2(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlActual), "yyyyMMdd", -diasAntesn2)));
/* 309:319 */             controlMedicoUC.setCmed_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlActual), "yyyyMMdd", 15)));
/* 310:320 */             controlMedicoPC.setCmed_fecenvio2(BigDecimal.ZERO);
/* 311:321 */             controlMedicoPC.setCmed_fecenvion(BigDecimal.ZERO);
/* 312:322 */             controlMedicoPC.setCmed_fecenvion2(BigDecimal.ZERO);
/* 313:323 */             controlMedicoPC.setCmed_quince_dias(BigDecimal.ZERO);
/* 314:    */           }
/* 315:    */         }
/* 316:330 */         else if ((!controlMedicoPC.getCmed_feccontrol().equals(controlMedicoUC.getCmed_feccontrol())) && (controlMedicoPC.getCmed_feccontrol().toString().equals("0")) && (controlMedicoPC.getCmed_feccontrol().toString().equals("0")))
/* 317:    */         {
/* 318:332 */           String fechaParametro = controlMedicoUC.getCmed_feccontrol().toString();
/* 319:333 */           while (fechaParametro.compareTo(fechaActual) < 1) {
/* 320:334 */             fechaParametro = GestorFechasCompleto.fechaMasMeses(fechaParametro, "yyyyMMdd", frecuencia);
/* 321:    */           }
/* 322:338 */           controlMedicoUC.setCmed_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(fechaParametro), "yyyyMMdd", -2)));
/* 323:339 */           controlMedicoUC.setCmed_fecenvion(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(fechaParametro), "yyyyMMdd", -diasAntesn)));
/* 324:340 */           controlMedicoUC.setCmed_fecenvion2(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(fechaParametro), "yyyyMMdd", -diasAntesn2)));
/* 325:341 */           controlMedicoUC.setCmed_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(fechaParametro), "yyyyMMdd", 15)));
/* 326:342 */           controlMedicoPC.setCmed_fecenvio2(BigDecimal.ZERO);
/* 327:343 */           controlMedicoPC.setCmed_fecenvion(BigDecimal.ZERO);
/* 328:344 */           controlMedicoPC.setCmed_fecenvion2(BigDecimal.ZERO);
/* 329:345 */           controlMedicoPC.setCmed_quince_dias(BigDecimal.ZERO);
/* 330:    */         }
/* 331:    */         else
/* 332:    */         {
/* 333:352 */           controlMedicoPC.setCmed_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlMedicoPC.getCmed_feccontrol().toString()), "yyyyMMdd", -2)));
/* 334:353 */           controlMedicoPC.setCmed_fecenvion(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlMedicoPC.getCmed_feccontrol().toString()), "yyyyMMdd", -diasAntesn)));
/* 335:354 */           controlMedicoPC.setCmed_fecenvion2(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlMedicoPC.getCmed_feccontrol().toString()), "yyyyMMdd", -diasAntesn2)));
/* 336:355 */           controlMedicoPC.setCmed_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlMedicoPC.getCmed_feccontrol().toString()), "yyyyMMdd", 15)));
/* 337:356 */           controlMedicoUC.setCmed_fecenvio2(BigDecimal.ZERO);
/* 338:357 */           controlMedicoUC.setCmed_fecenvion(BigDecimal.ZERO);
/* 339:358 */           controlMedicoUC.setCmed_fecenvion2(BigDecimal.ZERO);
/* 340:359 */           controlMedicoUC.setCmed_quince_dias(BigDecimal.ZERO);
/* 341:    */         }
/* 342:364 */         controlesProximos.set(i, controlMedicoPC);
/* 343:365 */         controlesAnteriores.set(i, controlMedicoUC);
/* 344:    */       }
/* 345:369 */       request.getSession().setAttribute("CONTROLESPROXIMOS", controlesProximos);
/* 346:    */       
/* 347:    */ 
/* 348:372 */       medicinaCompleto.setTablaAjustada(tablaAjustada);
/* 349:373 */       medicinaCompleto.setControlesAnteriores(controlesAnteriores);
/* 350:374 */       medicinaCompleto.setControlesProximos(controlesProximos);
/* 351:375 */       medicinaCompleto.setGrupos(gruposUsuario);
/* 352:376 */       medicinaCompletoDAO.update(medicinaCompleto, usuarioFamily.getUsuf_cod());
/* 353:    */     }
/* 354:    */     catch (Exception e)
/* 355:    */     {
/* 356:382 */       e.printStackTrace();
/* 357:383 */       return mapping.findForward("failure");
/* 358:    */     }
/* 359:385 */     return mapping.findForward("success");
/* 360:    */   }
/* 361:    */ }



/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\

 * Qualified Name:     com.servidoctor.sdfamily.controller.MedicinaCompletoAction

 * JD-Core Version:    0.7.0.1

 */