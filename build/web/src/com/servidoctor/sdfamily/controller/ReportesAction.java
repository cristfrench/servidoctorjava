/*   1:    */ package com.servidoctor.sdfamily.controller;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.controller.BaseAction;
/*   4:    */ import com.servidoctor.sdfamily.dao.GestorHojasCalculoFamily;
/*   5:    */ import com.servidoctor.sdfamily.model.DatosPersonales;
/*   6:    */ import com.servidoctor.seguridad.model.Servidores;
/*   7:    */ import com.servidoctor.seguridad.model.UsuarioFamily;
/*   8:    */ import java.io.OutputStream;
/*   9:    */ import java.math.BigDecimal;
/*  10:    */ import java.util.ResourceBundle;
/*  11:    */ import javax.servlet.http.HttpServletRequest;
/*  12:    */ import javax.servlet.http.HttpServletResponse;
/*  13:    */ import javax.servlet.http.HttpSession;
/*  14:    */ import javax.sql.DataSource;
/*  15:    */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*  16:    */ import org.apache.struts.action.ActionForm;
/*  17:    */ import org.apache.struts.action.ActionForward;
/*  18:    */ import org.apache.struts.action.ActionMapping;
/*  19:    */ 
/*  20:    */ public class ReportesAction
/*  21:    */   extends BaseAction
/*  22:    */ {
/*  23: 33 */   private DataSource ds = null;
/*  24:    */   
/*  25:    */   public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  26:    */     throws Exception
/*  27:    */   {
/*  28: 36 */     ActionForward myforward = super.execute(mapping, actionForm, request, response);
/*  29: 37 */     String myaction = mapping.getParameter();
/*  30: 39 */     if (myforward == null)
/*  31:    */     {
/*  32: 40 */       DatosPersonales datosPersonales = (DatosPersonales)request.getSession().getAttribute("datosPersonales");
/*  33: 41 */       if (datosPersonales.getDatp_usuf_cod() == null) {
/*  34: 42 */         myforward = mapping.findForward("datospersonales");
/*  35: 43 */       } else if ("".equalsIgnoreCase(myaction)) {
/*  36: 44 */         myforward = mapping.findForward("failure");
/*  37: 45 */       } else if ("REPORT".equalsIgnoreCase(myaction)) {
/*  38: 46 */         myforward = performReports(mapping, actionForm, request, response);
/*  39:    */       } else {
/*  40: 48 */         myforward = mapping.findForward("failure");
/*  41:    */       }
/*  42:    */     }
/*  43: 52 */     return myforward;
/*  44:    */   }
/*  45:    */   
/*  46:    */   private ActionForward performReports(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response)
/*  47:    */   {
/*  48: 63 */     String datosPersonales1 = null;
/*  49: 64 */     String datosPersonales2 = null;
/*  50: 65 */     String datosPersonales3 = null;
/*  51: 66 */     String datosPersonales4 = null;
/*  52: 67 */     String historiaMedica1 = null;
/*  53: 68 */     String historiaMedica2 = null;
/*  54: 69 */     String historiaMedica3 = null;
/*  55: 70 */     String historiaMedica4 = null;
/*  56: 71 */     String historiaMedica5 = null;
/*  57: 72 */     String historiaMedica6 = null;
/*  58: 73 */     String historiaMedica7 = null;
/*  59: 74 */     String historiaMedica8 = null;
/*  60: 75 */     String optometria1 = null;
/*  61: 76 */     String optometria2 = null;
/*  62: 77 */     String odontologia1 = null;
/*  63: 78 */     String odontologia2 = null;
/*  64: 79 */     String medico1 = null;
/*  65: 80 */     String medico2 = null;
/*  66: 81 */     String vacunas = null;
/*  67: 82 */     String laboratorio = null;
/*  68:    */     
/*  69: 84 */     ResourceBundle res = ResourceBundle.getBundle("com.servidoctor.resources.ApplicationResources");
/*  70:    */     try
/*  71:    */     {
/*  72: 87 */       UsuarioFamily usuarioFamily = (UsuarioFamily)request.getSession().getAttribute("usuarioFamily");
/*  73:    */       
/*  74: 89 */       GestorHojasCalculoFamily.generarArchivo();
/*  75: 91 */       if (request.getParameter("datosPersonales1") != null)
/*  76:    */       {
/*  77: 92 */         datosPersonales1 = request.getParameter("datosPersonales1");
/*  78: 93 */         GestorHojasCalculoFamily.generarHoja(datosPersonales1, usuarioFamily, res);
/*  79: 94 */         Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  80: 95 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  81: 96 */           GestorHojasCalculoFamily.generarDatosInfoBasica(datosPersonales1, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), servidor.getServ_cod().intValue());
/*  82:    */         } else {
/*  83: 98 */           GestorHojasCalculoFamily.generarDatosInfoBasica(datosPersonales1, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), 0);
/*  84:    */         }
/*  85:    */       }
/*  86:102 */       if (request.getParameter("datosPersonales2") != null)
/*  87:    */       {
/*  88:103 */         datosPersonales2 = request.getParameter("datosPersonales2");
/*  89:104 */         GestorHojasCalculoFamily.generarHoja(datosPersonales2, usuarioFamily, res);
/*  90:105 */         Servidores servidor = (Servidores)request.getSession().getAttribute("servidor");
/*  91:106 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/*  92:107 */           GestorHojasCalculoFamily.generarDatosInformacionEmergencia(datosPersonales2, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), servidor.getServ_cod().intValue());
/*  93:    */         } else {
/*  94:109 */           GestorHojasCalculoFamily.generarDatosInformacionEmergencia(datosPersonales2, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), 0);
/*  95:    */         }
/*  96:    */       }
/*  97:    */       Servidores servidor;
/*  98:113 */       if (request.getParameter("datosPersonales3") != null)
/*  99:    */       {
/* 100:114 */         datosPersonales3 = request.getParameter("datosPersonales3");
/* 101:115 */         GestorHojasCalculoFamily.generarHoja(datosPersonales3, usuarioFamily, res);
/* 102:116 */         servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 103:117 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 104:118 */           GestorHojasCalculoFamily.generarDatosSeguros(datosPersonales3, servidor.getServ_cod().intValue());
/* 105:    */         } else {
/* 106:120 */           GestorHojasCalculoFamily.generarDatosSeguros(datosPersonales3, 0);
/* 107:    */         }
/* 108:    */       }
/* 109:124 */       if (request.getParameter("datosPersonales4") != null)
/* 110:    */       {
/* 111:125 */         datosPersonales4 = request.getParameter("datosPersonales4");
/* 112:126 */         GestorHojasCalculoFamily.generarHoja(datosPersonales4, usuarioFamily, res);
/* 113:127 */         servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 114:    */       }
/* 115:135 */       if (request.getParameter("historiaMedica1") != null)
/* 116:    */       {
/* 117:136 */         historiaMedica1 = request.getParameter("historiaMedica1");
/* 118:137 */         GestorHojasCalculoFamily.generarHoja(historiaMedica1, usuarioFamily, res);
/* 119:138 */         servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 120:139 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 121:140 */           GestorHojasCalculoFamily.generarDatosConsumo(historiaMedica1, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), servidor.getServ_cod().intValue());
/* 122:    */         } else {
/* 123:142 */           GestorHojasCalculoFamily.generarDatosConsumo(historiaMedica1, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), 0);
/* 124:    */         }
/* 125:    */       }
/* 126:146 */       if (request.getParameter("historiaMedica2") != null)
/* 127:    */       {
/* 128:147 */         historiaMedica2 = request.getParameter("historiaMedica2");
/* 129:148 */         GestorHojasCalculoFamily.generarHoja(historiaMedica2, usuarioFamily, res);
/* 130:149 */         servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 131:150 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 132:151 */           GestorHojasCalculoFamily.generarDatosEnfermedades(historiaMedica2, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), servidor.getServ_cod().intValue());
/* 133:    */         } else {
/* 134:153 */           GestorHojasCalculoFamily.generarDatosEnfermedades(historiaMedica2, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), 0);
/* 135:    */         }
/* 136:    */       }
/* 137:157 */       if (request.getParameter("historiaMedica3") != null)
/* 138:    */       {
/* 139:158 */         historiaMedica3 = request.getParameter("historiaMedica3");
/* 140:159 */         GestorHojasCalculoFamily.generarHoja(historiaMedica3, usuarioFamily, res);
/* 141:160 */         servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 142:161 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 143:162 */           GestorHojasCalculoFamily.generarDatosAlergias(historiaMedica3, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), servidor.getServ_cod().intValue());
/* 144:    */         } else {
/* 145:164 */           GestorHojasCalculoFamily.generarDatosAlergias(historiaMedica3, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), 0);
/* 146:    */         }
/* 147:    */       }
/* 148:168 */       if (request.getParameter("historiaMedica4") != null)
/* 149:    */       {
/* 150:169 */         historiaMedica4 = request.getParameter("historiaMedica4");
/* 151:170 */         GestorHojasCalculoFamily.generarHoja(historiaMedica4, usuarioFamily, res);
/* 152:171 */         servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 153:172 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 154:173 */           GestorHojasCalculoFamily.generarDatosCirujias(historiaMedica4, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), servidor.getServ_cod().intValue());
/* 155:    */         } else {
/* 156:175 */           GestorHojasCalculoFamily.generarDatosCirujias(historiaMedica4, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), 0);
/* 157:    */         }
/* 158:    */       }
/* 159:179 */       if (request.getParameter("historiaMedica5") != null)
/* 160:    */       {
/* 161:180 */         historiaMedica5 = request.getParameter("historiaMedica5");
/* 162:181 */         GestorHojasCalculoFamily.generarHoja(historiaMedica5, usuarioFamily, res);
/* 163:182 */         servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 164:183 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 165:184 */           GestorHojasCalculoFamily.generarDatosMedicamentos(historiaMedica5, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), servidor.getServ_cod().intValue());
/* 166:    */         } else {
/* 167:186 */           GestorHojasCalculoFamily.generarDatosMedicamentos(historiaMedica5, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), 0);
/* 168:    */         }
/* 169:    */       }
/* 170:190 */       if (request.getParameter("historiaMedica6") != null)
/* 171:    */       {
/* 172:191 */         historiaMedica6 = request.getParameter("historiaMedica6");
/* 173:192 */         GestorHojasCalculoFamily.generarHoja(historiaMedica6, usuarioFamily, res);
/* 174:193 */         servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 175:194 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 176:195 */           GestorHojasCalculoFamily.generarDatosAntecedentes(historiaMedica6, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), servidor.getServ_cod().intValue());
/* 177:    */         } else {
/* 178:197 */           GestorHojasCalculoFamily.generarDatosAntecedentes(historiaMedica6, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), 0);
/* 179:    */         }
/* 180:    */       }
/* 181:201 */       if (request.getParameter("historiaMedica7") != null)
/* 182:    */       {
/* 183:202 */         historiaMedica7 = request.getParameter("historiaMedica7");
/* 184:203 */         GestorHojasCalculoFamily.generarHoja(historiaMedica7, usuarioFamily, res);
/* 185:204 */         servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 186:205 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 187:206 */           GestorHojasCalculoFamily.generarDatosHistoriaOtros(historiaMedica7, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), servidor.getServ_cod().intValue());
/* 188:    */         } else {
/* 189:208 */           GestorHojasCalculoFamily.generarDatosHistoriaOtros(historiaMedica7, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), 0);
/* 190:    */         }
/* 191:    */       }
/* 192:212 */       if (request.getParameter("historiaMedica8") != null)
/* 193:    */       {
/* 194:213 */         historiaMedica8 = request.getParameter("historiaMedica8");
/* 195:214 */         GestorHojasCalculoFamily.generarHoja(historiaMedica8, usuarioFamily, res);
/* 196:215 */         servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 197:216 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 198:217 */           GestorHojasCalculoFamily.generarDatosGinecologia(historiaMedica8, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), servidor.getServ_cod().intValue());
/* 199:    */         } else {
/* 200:219 */           GestorHojasCalculoFamily.generarDatosGinecologia(historiaMedica8, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), 0);
/* 201:    */         }
/* 202:    */       }
/* 203:223 */       if (request.getParameter("optometria1") != null)
/* 204:    */       {
/* 205:224 */         optometria1 = request.getParameter("optometria1");
/* 206:225 */         GestorHojasCalculoFamily.generarHoja(optometria1, usuarioFamily, res);
/* 207:226 */         servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 208:227 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 209:228 */           GestorHojasCalculoFamily.generarDatosTablaAjustadaOptometria(optometria1, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), servidor.getServ_cod().intValue());
/* 210:    */         } else {
/* 211:230 */           GestorHojasCalculoFamily.generarDatosTablaAjustadaOptometria(optometria1, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), 0);
/* 212:    */         }
/* 213:    */       }
/* 214:234 */       if (request.getParameter("optometria2") != null)
/* 215:    */       {
/* 216:235 */         optometria2 = request.getParameter("optometria2");
/* 217:236 */         GestorHojasCalculoFamily.generarHoja(optometria2, usuarioFamily, res);
/* 218:237 */         servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 219:238 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 220:239 */           GestorHojasCalculoFamily.generarDatosUltimoOptometria(optometria2, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), servidor.getServ_cod().intValue());
/* 221:    */         } else {
/* 222:241 */           GestorHojasCalculoFamily.generarDatosUltimoOptometria(optometria2, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), 0);
/* 223:    */         }
/* 224:    */       }
/* 225:245 */       if (request.getParameter("odontologia1") != null)
/* 226:    */       {
/* 227:246 */         odontologia1 = request.getParameter("odontologia1");
/* 228:247 */         GestorHojasCalculoFamily.generarHoja(odontologia1, usuarioFamily, res);
/* 229:248 */         servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 230:249 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 231:250 */           GestorHojasCalculoFamily.generarDatosTablaAjustadaOdontologia(odontologia1, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), servidor.getServ_cod().intValue());
/* 232:    */         } else {
/* 233:252 */           GestorHojasCalculoFamily.generarDatosTablaAjustadaOdontologia(odontologia1, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), 0);
/* 234:    */         }
/* 235:    */       }
/* 236:256 */       if (request.getParameter("odontologia2") != null)
/* 237:    */       {
/* 238:257 */         odontologia2 = request.getParameter("odontologia2");
/* 239:258 */         GestorHojasCalculoFamily.generarHoja(odontologia2, usuarioFamily, res);
/* 240:259 */         servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 241:260 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 242:261 */           GestorHojasCalculoFamily.generarDatosUltimoOdontologia(odontologia2, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), servidor.getServ_cod().intValue());
/* 243:    */         } else {
/* 244:263 */           GestorHojasCalculoFamily.generarDatosUltimoOdontologia(odontologia2, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), 0);
/* 245:    */         }
/* 246:    */       }
/* 247:267 */       if (request.getParameter("medico1") != null)
/* 248:    */       {
/* 249:268 */         medico1 = request.getParameter("medico1");
/* 250:269 */         GestorHojasCalculoFamily.generarHoja(medico1, usuarioFamily, res);
/* 251:270 */         servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 252:271 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 253:272 */           GestorHojasCalculoFamily.generarDatosTablaAjustadaMedico(medico1, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), servidor.getServ_cod().intValue());
/* 254:    */         } else {
/* 255:274 */           GestorHojasCalculoFamily.generarDatosTablaAjustadaMedico(medico1, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), 0);
/* 256:    */         }
/* 257:    */       }
/* 258:279 */       if (request.getParameter("medico2") != null)
/* 259:    */       {
/* 260:280 */         medico2 = request.getParameter("medico2");
/* 261:281 */         GestorHojasCalculoFamily.generarHoja(medico2, usuarioFamily, res);
/* 262:282 */         servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 263:283 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 264:284 */           GestorHojasCalculoFamily.generarDatosUtimoMedicina(medico2, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), servidor.getServ_cod().intValue());
/* 265:    */         } else {
/* 266:286 */           GestorHojasCalculoFamily.generarDatosUtimoMedicina(medico2, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), 0);
/* 267:    */         }
/* 268:    */       }
/* 269:290 */       if (request.getParameter("vacunas") != null)
/* 270:    */       {
/* 271:291 */         vacunas = request.getParameter("vacunas");
/* 272:292 */         GestorHojasCalculoFamily.generarHoja(vacunas, usuarioFamily, res);
/* 273:293 */         servidor = (Servidores)request.getSession().getAttribute("servidor");
/* 274:294 */         if ((servidor != null) && (servidor.getServ_cod() != null)) {
/* 275:295 */           GestorHojasCalculoFamily.generarDatosVacunas(vacunas, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), servidor.getServ_cod().intValue());
/* 276:    */         } else {
/* 277:297 */           GestorHojasCalculoFamily.generarDatosVacunas(vacunas, request.getSession().getAttribute("org.apache.struts.action.LOCALE").toString().substring(0,2), 0);
/* 278:    */         }
/* 279:    */       }
/* 280:301 */       if (request.getParameter("laboratorio") != null)
/* 281:    */       {
/* 282:302 */         laboratorio = request.getParameter("laboratorio");
/* 283:303 */         GestorHojasCalculoFamily.generarHoja(laboratorio, usuarioFamily, res);
/* 284:304 */         GestorHojasCalculoFamily.generarDatosLaboratorio(laboratorio);
/* 285:    */       }
/* 286:307 */       response.setContentType("application/vnd.ms-excel");
/* 287:308 */       OutputStream out = response.getOutputStream();
/* 288:310 */       if (GestorHojasCalculoFamily.getWb() != null)
/* 289:    */       {
/* 290:311 */         GestorHojasCalculoFamily.getWb().write(out);
/* 291:312 */         out.close();
/* 292:313 */         return null;
/* 293:    */       }
/* 294:316 */       request.setAttribute("CONFIRM", res.getString("6179"));
/* 295:317 */       return mapping.findForward("success");
/* 296:    */     }
/* 297:    */     catch (Exception e)
/* 298:    */     {
/* 299:322 */       e.printStackTrace();
/* 300:323 */       request.setAttribute("FAILURE", e.getMessage());
/* 301:    */     }
/* 302:324 */     return mapping.findForward("failure");
/* 303:    */   }
/* 304:    */ }



/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\

 * Qualified Name:     com.servidoctor.sdfamily.controller.ReportesAction

 * JD-Core Version:    0.7.0.1

 */