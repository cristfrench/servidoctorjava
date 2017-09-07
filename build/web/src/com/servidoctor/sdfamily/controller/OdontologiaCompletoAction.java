/*   1:    */ package com.servidoctor.sdfamily.controller;
/*   2:    */ 
/*   3:    */ import com.essecorp.util.GestorFechasCompleto;
/*   4:    */ import com.servidoctor.common.controller.BaseAction;
/*   5:    */ import com.servidoctor.constantes.IConstantes;
/*   6:    */ import com.servidoctor.parametros.dao.OdontologiaDAO;
/*   7:    */ import com.servidoctor.parametros.model.Odontologia;
/*   8:    */ import com.servidoctor.sdfamily.dao.DatosPersonalesDAO;
/*   9:    */ import com.servidoctor.sdfamily.dao.GruposUsuarioDAO;
/*  10:    */ import com.servidoctor.sdfamily.dao.OdontologiaCompletoDAO;
/*  11:    */ import com.servidoctor.sdfamily.dao.OdontologiaUsuarioDAO;
/*  12:    */ import com.servidoctor.sdfamily.model.ControlOdontologia;
/*  13:    */ import com.servidoctor.sdfamily.model.DatosPersonales;
/*  14:    */ import com.servidoctor.sdfamily.model.GruposUsuario;
/*  15:    */ import com.servidoctor.sdfamily.model.OdontologiaCompleto;
/*  16:    */ import com.servidoctor.sdfamily.model.OdontologiaUsuario;
/*  17:    */ import com.servidoctor.seguridad.model.Servidores;
/*  18:    */ import com.servidoctor.seguridad.model.UsuarioFamily;
/*  19:    */ import com.servidoctor.util.classes.BorrarSession;
/*  20:    */ import com.servidoctor.util.classes.InicializaData;
/*  21:    */ import com.servidoctor.util.classes.ManejoFechas;
/*  22:    */ import java.io.PrintStream;
/*  23:    */ import java.math.BigDecimal;
/*  24:    */ import java.util.List;
/*  25:    */ import javax.servlet.http.HttpServletRequest;
/*  26:    */ import javax.servlet.http.HttpServletResponse;
/*  27:    */ import javax.servlet.http.HttpSession;
/*  28:    */ import org.apache.commons.beanutils.BeanUtils;
/*  29:    */ import org.apache.struts.action.ActionForm;
/*  30:    */ import org.apache.struts.action.ActionForward;
/*  31:    */ import org.apache.struts.action.ActionMapping;
/*  32:    */ 
/*  33:    */ public class OdontologiaCompletoAction
/*  34:    */   extends BaseAction
/*  35:    */ {
/*  36:    */   public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  37:    */     throws Exception
/*  38:    */   {
/*  39: 43 */     ActionForward myforward = super.execute(mapping, actionForm, request, response);
/*  40: 44 */     String myaction = mapping.getParameter();
/*  41: 46 */     if (myforward == null)
/*  42:    */     {
/*  43: 47 */       DatosPersonales datosPersonales = (DatosPersonales)request.getSession().getAttribute("datosPersonales");
/*  44: 48 */       if (datosPersonales.getDatp_usuf_cod() == null) {
/*  45: 49 */         myforward = mapping.findForward("datospersonales");
/*  46: 50 */       } else if ("".equalsIgnoreCase(myaction)) {
/*  47: 51 */         myforward = mapping.findForward("failure");
/*  48: 52 */       } else if ("VIEW".equalsIgnoreCase(myaction)) {
/*  49: 53 */         myforward = performView(mapping, actionForm, request, response);
/*  50: 54 */       } else if ("EDIT".equalsIgnoreCase(myaction)) {
/*  51: 55 */         myforward = performEdit(mapping, actionForm, request, response);
/*  52: 56 */       } else if ("ADD".equalsIgnoreCase(myaction)) {
/*  53: 57 */         myforward = performAdd(mapping, actionForm, request, response);
/*  54: 58 */       } else if ("SAVE".equalsIgnoreCase(myaction)) {
/*  55: 59 */         myforward = performSave(mapping, actionForm, request, response);
/*  56:    */       } else {
/*  57: 61 */         myforward = mapping.findForward("failure");
/*  58:    */       }
/*  59:    */     }
/*  60: 65 */     return myforward;
/*  61:    */   }
/*  62:    */   
/*  63:    */   private ActionForward performView(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  64:    */   {
/*  65: 69 */     OdontologiaCompletoForm form = (OdontologiaCompletoForm)actionForm;
/*  66: 70 */     Boolean nuevo = Boolean.valueOf(false);
/*  67:    */     try
/*  68:    */     {
/*  69: 74 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/*  70:    */       
/*  71: 76 */       BorrarSession.eliminaAtributos(request.getSession(), "odontologiaCompletoForm");
/*  72: 77 */       OdontologiaCompletoDAO odontologiaCompletoDAO = new OdontologiaCompletoDAO();
/*  73: 78 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  74: 79 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  75: 80 */         odontologiaCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  76:    */       }
/*  77: 82 */       //odontologiaCompletoDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    odontologiaCompletoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  78: 83 */       OdontologiaCompleto odontologiaCompleto = odontologiaCompletoDAO.retrieve(usuarioFamily.getUsuf_cod());
/*  79: 84 */       List tablaUniversal = odontologiaCompleto.getTablaUniversal();
/*  80: 85 */       request.getSession().setAttribute("CONTROLES_ODON", tablaUniversal);
/*  81:    */       
/*  82: 87 */       List tablaAjustada = odontologiaCompleto.getTablaAjustada();
/*  83: 88 */       List usuarioControlesU = odontologiaCompleto.getControlesAnteriores();
/*  84: 89 */       List usuarioControlesP = odontologiaCompleto.getControlesProximos();
/*  85:    */       
/*  86: 91 */       Odontologia temp = new Odontologia();
/*  87: 92 */       InicializaData.inicializa(temp.getClass(), temp);
/*  88:    */       
/*  89: 94 */       int i = 0;
/*  90: 95 */       OdontologiaDAO odontologiaDAO = new OdontologiaDAO();
/*  91: 96 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  92: 97 */         odontologiaDAO.setServerNumber(servidor.getServ_cod().intValue());
/*  93:    */       }
/*  94: 99 */       //odontologiaDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    odontologiaDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/*  95:100 */       while (i < tablaUniversal.size())
/*  96:    */       {
/*  97:101 */         Odontologia odontologia = (Odontologia)tablaUniversal.get(i);
/*  98:102 */         request.setAttribute("odo_destratamiento" + odontologia.getOdo_cod(), odontologia.getOdo_destratamiento());
/*  99:103 */         i++;
/* 100:    */       }
/* 101:106 */       request.getSession().setAttribute("CONTROLES_ODON_T", tablaAjustada);
/* 102:107 */       request.getSession().setAttribute("CONTROLES_ODON_U", usuarioControlesU);
/* 103:108 */       request.getSession().setAttribute("CONTROLES_ODON_P", usuarioControlesP);
/* 104:    */       
/* 105:110 */       GruposUsuario gruposUsuario = odontologiaCompleto.getGrupoUsuario();
/* 106:111 */       BeanUtils.copyProperties(form, gruposUsuario);
/* 107:    */     }
/* 108:    */     catch (Exception e)
/* 109:    */     {
/* 110:114 */       e.printStackTrace();
/* 111:115 */       return mapping.findForward("failure");
/* 112:    */     }
/* 113:117 */     return mapping.findForward("success");
/* 114:    */   }
/* 115:    */   
/* 116:    */   private ActionForward performEdit(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 117:    */   {
/* 118:121 */     OdontologiaCompletoForm form = (OdontologiaCompletoForm)actionForm;
/* 119:    */     
/* 120:    */ 
/* 121:    */ 
/* 122:    */ 
/* 123:    */ 
/* 124:    */ 
/* 125:128 */     return mapping.findForward("success");
/* 126:    */   }
/* 127:    */   
/* 128:    */   private ActionForward performAdd(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 129:    */   {
/* 130:132 */     OdontologiaCompletoForm form = (OdontologiaCompletoForm)actionForm;
/* 131:    */     try
/* 132:    */     {
/* 133:135 */       List controlesPC = (List)request.getSession().getAttribute("CONTROLES_ODON_P");
/* 134:136 */       List controlesUC = (List)request.getSession().getAttribute("CONTROLES_ODON_U");
/* 135:137 */       List controlesT = (List)request.getSession().getAttribute("CONTROLES_ODON_T");
/* 136:138 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/* 137:    */       
/* 138:140 */       BorrarSession.eliminaAtributos(request.getSession(), "odontologiaCompletoForm");
/* 139:141 */       OdontologiaCompletoDAO odontologiaCompletoDAO = new OdontologiaCompletoDAO();
/* 140:142 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 141:143 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 142:144 */         odontologiaCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 143:    */       }
/* 144:146 */       //odontologiaCompletoDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    odontologiaCompletoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 145:147 */       OdontologiaCompleto odontologiaCompleto = odontologiaCompletoDAO.retrieve(usuarioFamily.getUsuf_cod());
/* 146:    */       
/* 147:    */ 
/* 148:    */ 
/* 149:    */ 
/* 150:152 */       List tablaUniversal = odontologiaCompleto.getTablaUniversal();
/* 151:153 */       request.getSession().setAttribute("CONTROLES_ODON", tablaUniversal);
/* 152:154 */       int i = 0;
/* 153:155 */       OdontologiaDAO odontologiaDAO = new OdontologiaDAO();
/* 154:156 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 155:157 */         odontologiaDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 156:    */       }
/* 157:159 */       //odontologiaDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    odontologiaDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 158:160 */       while (i < tablaUniversal.size())
/* 159:    */       {
/* 160:161 */         Odontologia odontologia = (Odontologia)tablaUniversal.get(i);
/* 161:162 */         request.setAttribute("odo_destratamiento" + odontologia.getOdo_cod(), odontologia.getOdo_destratamiento());
/* 162:163 */         i++;
/* 163:    */       }
/* 164:165 */       request.getSession().setAttribute("CONTROLES_ODON_P", controlesPC);
/* 165:166 */       request.getSession().setAttribute("CONTROLES_ODON_U", controlesUC);
/* 166:167 */       request.getSession().setAttribute("CONTROLES_ODON_T", controlesT);
/* 167:    */       
/* 168:    */ 
/* 169:170 */       //y = 0;
/* 170:    */     }
/* 171:    */     catch (Exception e)
/* 172:    */     {
/* 173:    */       int y;
/* 174:172 */       e.printStackTrace();
/* 175:173 */       return mapping.findForward("failure");
/* 176:    */     }
/* 177:176 */     return mapping.findForward("success");
/* 178:    */   }
/* 179:    */   
/* 180:    */   private ActionForward performSave(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/* 181:    */   {
/* 182:180 */     OdontologiaCompletoForm form = (OdontologiaCompletoForm)actionForm;
/* 183:    */     try
/* 184:    */     {
/* 185:183 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/* 186:    */       
/* 187:185 */       OdontologiaCompletoDAO odontologiaCompletoDAO = new OdontologiaCompletoDAO();
/* 188:186 */       OdontologiaUsuarioDAO odontologiaUsuarioDAO = new OdontologiaUsuarioDAO();
/* 189:187 */       String fechaActual = ManejoFechas.getFechaActual();
/* 190:188 */       Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 191:189 */       if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 192:190 */         odontologiaCompletoDAO.setServerNumber(servidor.getServ_cod().intValue());
/* 193:    */       }
/* 194:192 */       //odontologiaCompletoDAO.setIdioma(request.getSession().getAttribute("idioma").toString());
                    odontologiaCompletoDAO.setIdioma(request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2));
/* 195:193 */       OdontologiaCompleto odontologiaCompleto = odontologiaCompletoDAO.retrieve(usuarioFamily.getUsuf_cod());
/* 196:194 */       DatosPersonalesDAO datosPersonalesDAO = new DatosPersonalesDAO();
/* 197:195 */       DatosPersonales datosPersonales = datosPersonalesDAO.retrive(usuarioFamily.getUsuf_cod());
/* 198:    */       
/* 199:    */ 
/* 200:    */ 
/* 201:199 */       List controlesPC = (List)request.getSession().getAttribute("CONTROLES_ODON_P");
/* 202:200 */       List controlesUC = (List)request.getSession().getAttribute("CONTROLES_ODON_U");
/* 203:201 */       List controlesT = (List)request.getSession().getAttribute("CONTROLES_ODON_T");
/* 204:    */       
/* 205:    */ 
/* 206:204 */       GruposUsuarioDAO gruposUsuarioDAO = new GruposUsuarioDAO();
/* 207:205 */       OdontologiaUsuario odontologiaUsuarioTemp = new OdontologiaUsuario();
/* 208:215 */       for (int i = 0; i < controlesPC.size(); i++)
/* 209:    */       {
/* 210:216 */         ControlOdontologia controlOdontologicoPC = (ControlOdontologia)controlesPC.get(i);
/* 211:217 */         ControlOdontologia controlOdontologicoUC = (ControlOdontologia)controlesUC.get(i);
/* 212:218 */         OdontologiaUsuario odontologiaUsuario = (OdontologiaUsuario)controlesT.get(i);
/* 213:219 */         List odontologiaUsuario2 = odontologiaUsuarioDAO.list2(controlOdontologicoPC.getCodo_usuf_cod(), controlOdontologicoPC.getCodo_cod());
/* 214:220 */         String controlActual = datosPersonales.getDatp_fecnacim().toString();
/* 215:226 */         if (odontologiaUsuario2.size() != 0)
/* 216:    */         {
/* 217:227 */           OdontologiaUsuario odoUsuarioCodigo = (OdontologiaUsuario)odontologiaUsuario2.get(0);
/* 218:228 */           controlOdontologicoPC.setCodo_odo_cod(odoUsuarioCodigo.getOdou_odo_cod());
/* 219:229 */           controlOdontologicoPC.setElementoTabla(odoUsuarioCodigo);
/* 220:230 */           controlOdontologicoUC.setCodo_odo_cod(odoUsuarioCodigo.getOdou_odo_cod());
/* 221:231 */           controlOdontologicoUC.setElementoTabla(odoUsuarioCodigo);
/* 222:    */         }
/* 223:236 */         int diasAntesn = 0;
/* 224:237 */         int diasAntesn2 = 0;
/* 225:238 */         if (form.getGrupu_dias_antes().equals("0"))
/* 226:    */         {
/* 227:239 */           GruposUsuario gruposUsuarioX = gruposUsuarioDAO.retrieve(usuarioFamily.getUsuf_cod(), controlOdontologicoPC.getCodo_grup_cod());
/* 228:240 */           diasAntesn = gruposUsuarioX.getGrupu_dias_antes().intValue();
/* 229:241 */           diasAntesn2 = gruposUsuarioX.getGrupu_dias_antes().intValue() / 2;
/* 230:    */         }
/* 231:    */         else
/* 232:    */         {
/* 233:243 */           diasAntesn = new BigDecimal(form.getGrupu_dias_antes()).intValue();
/* 234:244 */           diasAntesn2 = diasAntesn / 2;
/* 235:    */         }
/* 236:246 */         int frecuencia = odontologiaUsuario.getOdou_frecuencia().intValue();
/* 237:247 */         if ((controlOdontologicoPC.getCodo_feccontrol().equals(controlOdontologicoUC.getCodo_feccontrol())) && (controlOdontologicoPC.getCodo_feccontrol().toString().equals("0")))
/* 238:    */         {
/* 239:250 */           int numeroMesesMinimo = controlOdontologicoPC.getElementoTabla().getOdou_edaddesdemes().intValue() + controlOdontologicoPC.getElementoTabla().getOdou_edaddesdeanio().intValue() * 12;
/* 240:251 */           int numeroMesesMaximo = controlOdontologicoPC.getElementoTabla().getOdou_edadhastames().intValue() + controlOdontologicoPC.getElementoTabla().getOdou_edadhastaanio().intValue() * 12;
/* 241:252 */           if ((GestorFechasCompleto.convertStringToLong(GestorFechasCompleto.fechaMasMeses(datosPersonales.getDatp_fecnacim().toString(), "yyyyMMdd", numeroMesesMinimo), "yyyyMMdd") < System.currentTimeMillis()) && (GestorFechasCompleto.convertStringToLong(GestorFechasCompleto.fechaMasMeses(datosPersonales.getDatp_fecnacim().toString(), "yyyyMMdd", numeroMesesMaximo), "yyyyMMdd") > System.currentTimeMillis()))
/* 242:    */           {
/* 243:254 */             while (controlActual.compareTo(fechaActual) < 1) {
/* 244:255 */               controlActual = GestorFechasCompleto.fechaMasMeses(controlActual, "yyyyMMdd", frecuencia);
/* 245:    */             }
/* 246:258 */             controlOdontologicoUC.setCodo_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlActual), "yyyyMMdd", -2)));
/* 247:259 */             controlOdontologicoUC.setCodo_fecenvion(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlActual), "yyyyMMdd", -diasAntesn)));
/* 248:260 */             controlOdontologicoUC.setCodo_fecenvion2(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlActual), "yyyyMMdd", -diasAntesn2)));
/* 249:261 */             controlOdontologicoUC.setCodo_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlActual), "yyyyMMdd", 15)));
/* 250:262 */             controlOdontologicoPC.setCodo_fecenvio2(BigDecimal.ZERO);
/* 251:263 */             controlOdontologicoPC.setCodo_fecenvion(BigDecimal.ZERO);
/* 252:264 */             controlOdontologicoPC.setCodo_fecenvion2(BigDecimal.ZERO);
/* 253:265 */             controlOdontologicoPC.setCodo_quince_dias(BigDecimal.ZERO);
/* 254:    */           }
/* 255:    */           else
/* 256:    */           {
/* 257:267 */             controlOdontologicoUC.setCodo_fecenvio2(BigDecimal.ZERO);
/* 258:268 */             controlOdontologicoUC.setCodo_fecenvion(BigDecimal.ZERO);
/* 259:269 */             controlOdontologicoUC.setCodo_fecenvion2(BigDecimal.ZERO);
/* 260:270 */             controlOdontologicoUC.setCodo_quince_dias(BigDecimal.ZERO);
/* 261:271 */             controlOdontologicoPC.setCodo_fecenvio2(IConstantes.CODIGO_NO);
/* 262:272 */             controlOdontologicoPC.setCodo_fecenvion(IConstantes.CODIGO_NO);
/* 263:273 */             controlOdontologicoPC.setCodo_fecenvion2(IConstantes.CODIGO_NO);
/* 264:274 */             controlOdontologicoPC.setCodo_quince_dias(IConstantes.CODIGO_NO);
/* 265:    */           }
/* 266:    */         }
/* 267:280 */         else if ((!controlOdontologicoPC.getCodo_feccontrol().equals(controlOdontologicoUC.getCodo_feccontrol())) && (controlOdontologicoPC.getCodo_feccontrol().toString().equals("0")) && (controlOdontologicoPC.getCodo_feccontrol().toString().equals("0")))
/* 268:    */         {
/* 269:282 */           String fechaParametro = controlOdontologicoUC.getCodo_feccontrol().toString();
/* 270:283 */           while (fechaParametro.compareTo(fechaActual) < 1) {
/* 271:284 */             fechaParametro = GestorFechasCompleto.fechaMasMeses(fechaParametro, "yyyyMMdd", frecuencia);
/* 272:    */           }
/* 273:286 */           System.out.println("PC");
/* 274:    */           
/* 275:288 */           controlOdontologicoUC.setCodo_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(fechaParametro), "yyyyMMdd", -2)));
/* 276:289 */           controlOdontologicoUC.setCodo_fecenvion(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(fechaParametro), "yyyyMMdd", -diasAntesn)));
/* 277:290 */           controlOdontologicoUC.setCodo_fecenvion2(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(fechaParametro), "yyyyMMdd", -diasAntesn2)));
/* 278:291 */           controlOdontologicoUC.setCodo_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(fechaParametro), "yyyyMMdd", 15)));
/* 279:292 */           controlOdontologicoPC.setCodo_fecenvio2(BigDecimal.ZERO);
/* 280:293 */           controlOdontologicoPC.setCodo_fecenvion(BigDecimal.ZERO);
/* 281:294 */           controlOdontologicoPC.setCodo_fecenvion2(BigDecimal.ZERO);
/* 282:295 */           controlOdontologicoPC.setCodo_quince_dias(BigDecimal.ZERO);
/* 283:    */         }
/* 284:    */         else
/* 285:    */         {
/* 286:301 */           System.out.println("PC");
/* 287:302 */           controlOdontologicoPC.setCodo_fecenvio2(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlOdontologicoPC.getCodo_feccontrol().toString()), "yyyyMMdd", -2)));
/* 288:303 */           controlOdontologicoPC.setCodo_fecenvion(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlOdontologicoPC.getCodo_feccontrol().toString()), "yyyyMMdd", -diasAntesn)));
/* 289:304 */           controlOdontologicoPC.setCodo_fecenvion2(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlOdontologicoPC.getCodo_feccontrol().toString()), "yyyyMMdd", -diasAntesn2)));
/* 290:305 */           controlOdontologicoPC.setCodo_quince_dias(new BigDecimal(GestorFechasCompleto.fechaMasDias(ManejoFechas.getChangeFecha(controlOdontologicoPC.getCodo_feccontrol().toString()), "yyyyMMdd", 15)));
/* 291:306 */           controlOdontologicoUC.setCodo_fecenvio2(BigDecimal.ZERO);
/* 292:307 */           controlOdontologicoUC.setCodo_fecenvion(BigDecimal.ZERO);
/* 293:308 */           controlOdontologicoUC.setCodo_fecenvion2(BigDecimal.ZERO);
/* 294:309 */           controlOdontologicoUC.setCodo_quince_dias(BigDecimal.ZERO);
/* 295:    */         }
/* 296:315 */         controlesUC.set(i, controlOdontologicoUC);
/* 297:316 */         controlesPC.set(i, controlOdontologicoPC);
/* 298:317 */         request.getSession().setAttribute("CONTROLES_ODON_P", controlesPC);
/* 299:    */       }
/* 300:320 */       odontologiaCompleto.setTablaAjustada((List)request.getSession().getAttribute("CONTROLES_ODON_T"));
/* 301:321 */       odontologiaCompleto.setControlesAnteriores((List)request.getSession().getAttribute("CONTROLES_ODON_U"));
/* 302:322 */       odontologiaCompleto.setControlesProximos((List)request.getSession().getAttribute("CONTROLES_ODON_P"));
/* 303:    */       
/* 304:324 */       GruposUsuario gruposUsuario = odontologiaCompleto.getGrupoUsuario();
/* 305:325 */       gruposUsuario.setGrupu_dias_antes(new BigDecimal(form.getGrupu_dias_antes()));
/* 306:    */       
/* 307:327 */       odontologiaCompletoDAO.update(odontologiaCompleto, usuarioFamily.getUsuf_cod());
/* 308:    */     }
/* 309:    */     catch (Exception e)
/* 310:    */     {
/* 311:331 */       e.printStackTrace();
/* 312:332 */       return mapping.findForward("failure");
/* 313:    */     }
/* 314:334 */     return mapping.findForward("success");
/* 315:    */   }
/* 316:    */ }



/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\

 * Qualified Name:     com.servidoctor.sdfamily.controller.OdontologiaCompletoAction

 * JD-Core Version:    0.7.0.1

 */