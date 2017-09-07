/*   1:    */ package com.servidoctor.sdfamily.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.constantes.IConstantes;
/*   5:    */ import com.servidoctor.constantes.IGrupos;
/*   6:    */ import com.servidoctor.parametros.dao.ExamenesDAO;
/*   7:    */ import com.servidoctor.sdfamily.model.ControlMedico;
/*   8:    */ import com.servidoctor.sdfamily.model.ExamenesUsuario;
/*   9:    */ import com.servidoctor.sdfamily.model.GruposUsuario;
/*  10:    */ import com.servidoctor.sdfamily.model.MedicinaCompleto;
/*  11:    */ import java.math.BigDecimal;
/*  12:    */ import java.sql.Connection;
/*  13:    */ import java.util.ArrayList;
/*  14:    */ import java.util.Collection;
/*  15:    */ import java.util.HashMap;
/*  16:    */ import java.util.Iterator;
/*  17:    */ import java.util.List;
/*  18:    */ import java.util.Map;
/*  19:    */ import javax.sql.DataSource;
/*  20:    */ 
/*  21:    */ public class MedicinaCompletoDAO
/*  22:    */   extends DAO
/*  23:    */ {
/*  24:    */   public void update(MedicinaCompleto medicinaCompleto, BigDecimal usu_cod)
/*  25:    */     throws Exception
/*  26:    */   {
/*  27: 30 */     update(medicinaCompleto, usu_cod, null);
/*  28:    */   }
/*  29:    */   
/*  30:    */   public void update(MedicinaCompleto medicinaCompleto, BigDecimal usu_cod, Connection conn)
/*  31:    */     throws Exception
/*  32:    */   {
/*  33: 35 */     boolean manejado = conn != null;
/*  34:    */     try
/*  35:    */     {
/*  36: 39 */       if (!manejado)
/*  37:    */       {
/*  38: 40 */         conn = this.ds.getConnection();
/*  39: 41 */         conn.setAutoCommit(false);
/*  40:    */       }
/*  41: 45 */       String[] llavesGrupos = { "grupu_cod", "grupu_usuf_cod" };
/*  42: 46 */       GruposUsuarioDAO gruposUsuarioDAO = new GruposUsuarioDAO();
/*  43: 47 */       gruposUsuarioDAO.setServerNumber(this.serverNumber);
/*  44: 48 */       List gruposBase = gruposUsuarioDAO.list(usu_cod);
/*  45:    */       
/*  46: 50 */       Map gruposBaseMap = new HashMap();
/*  47: 51 */       for (Iterator it = gruposBase.iterator(); it.hasNext();)
/*  48:    */       {
/*  49: 52 */         GruposUsuario gruposUsuario = (GruposUsuario)it.next();
/*  50: 53 */         gruposBaseMap.put(gruposUsuario.getGrupu_grup_cod(), gruposUsuario);
/*  51:    */       }
/*  52: 56 */       for (Iterator it = medicinaCompleto.getGrupos().iterator(); it.hasNext();)
/*  53:    */       {
/*  54: 57 */         GruposUsuario gruposUsuario = (GruposUsuario)it.next();
/*  55: 58 */         gruposUsuario.setGrupu_usuf_cod(usu_cod);
/*  56: 59 */         if (gruposBaseMap.containsKey(gruposUsuario.getGrupu_grup_cod()))
/*  57:    */         {
/*  58: 60 */           gruposUsuarioDAO.update(gruposUsuario, llavesGrupos, conn);
/*  59: 61 */           gruposBaseMap.remove(gruposUsuario.getGrupu_grup_cod());
/*  60:    */         }
/*  61:    */         else
/*  62:    */         {
/*  63: 63 */           gruposUsuarioDAO.insert(gruposUsuario, conn);
/*  64:    */         }
/*  65:    */       }
/*  66: 66 */       for (Iterator it = gruposBaseMap.values().iterator(); it.hasNext();)
/*  67:    */       {
/*  68: 67 */         GruposUsuario gruposUsuario = (GruposUsuario)it.next();
/*  69: 68 */         if ((gruposUsuario.getGrupu_grup_cod().equals(IGrupos.FAMILY_MEDICINA_A)) || (gruposUsuario.getGrupu_grup_cod().equals(IGrupos.FAMILY_MEDICINA_B)) || (gruposUsuario.getGrupu_grup_cod().equals(IGrupos.FAMILY_MEDICINA_C))) {
/*  70: 69 */           gruposUsuarioDAO.delete(gruposUsuario, conn);
/*  71:    */         }
/*  72:    */       }
/*  73: 74 */       String[] llavesTablaAjustada = { "exau_cod", "exau_usuf_cod" };
/*  74: 75 */       ExamenesUsuarioDAO examenesUsuarioDAO = new ExamenesUsuarioDAO();
/*  75: 76 */       examenesUsuarioDAO.setServerNumber(this.serverNumber);
/*  76: 77 */       List tablaAjustadaBase = examenesUsuarioDAO.list(usu_cod);
/*  77:    */       
/*  78: 79 */       Map tablaAjustadaBaseMap = new HashMap();
/*  79: 80 */       for (Iterator it = tablaAjustadaBase.iterator(); it.hasNext();)
/*  80:    */       {
/*  81: 81 */         ExamenesUsuario examenesUsuario = (ExamenesUsuario)it.next();
/*  82: 82 */         tablaAjustadaBaseMap.put(examenesUsuario.getExau_cod(), examenesUsuario);
/*  83:    */       }
/*  84: 85 */       for (Iterator it = medicinaCompleto.getTablaAjustada().iterator(); it.hasNext();)
/*  85:    */       {
/*  86: 86 */         ExamenesUsuario examenesUsuario = (ExamenesUsuario)it.next();
/*  87: 87 */         examenesUsuario.setExau_usuf_cod(usu_cod);
/*  88: 88 */         if (tablaAjustadaBaseMap.containsKey(examenesUsuario.getExau_cod()))
/*  89:    */         {
/*  90: 89 */           examenesUsuarioDAO.update(examenesUsuario, llavesTablaAjustada, conn);
/*  91: 90 */           tablaAjustadaBaseMap.remove(examenesUsuario.getExau_cod());
/*  92:    */         }
/*  93:    */         else
/*  94:    */         {
/*  95: 92 */           examenesUsuarioDAO.insert(examenesUsuario, conn);
/*  96:    */         }
/*  97:    */       }
/*  98: 96 */       for (Iterator it = tablaAjustadaBaseMap.values().iterator(); it.hasNext();)
/*  99:    */       {
/* 100: 97 */         ExamenesUsuario examenesUsuario = (ExamenesUsuario)it.next();
/* 101: 98 */         examenesUsuarioDAO.delete(examenesUsuario, conn);
/* 102:    */       }
/* 103:102 */       String[] llavesControles = { "cmed_cod", "cmed_usuf_cod", "cmed_tipo" };
/* 104:103 */       ControlMedicoDAO controlMedicoDAO = new ControlMedicoDAO();
/* 105:104 */       controlMedicoDAO.setServerNumber(this.serverNumber);
/* 106:105 */       List controlesAnterioresBase = controlMedicoDAO.list(usu_cod, IConstantes.CODIGO_CONTROL_ANTERIOR);
/* 107:    */       
/* 108:107 */       Map controlesAnterioresBaseMap = new HashMap();
/* 109:108 */       for (Iterator it = controlesAnterioresBase.iterator(); it.hasNext();)
/* 110:    */       {
/* 111:109 */         ControlMedico controlMedico = (ControlMedico)it.next();
/* 112:110 */         controlesAnterioresBaseMap.put(controlMedico.getCmed_cod(), controlMedico);
/* 113:    */       }
/* 114:113 */       for (Iterator it = medicinaCompleto.getControlesAnteriores().iterator(); it.hasNext();)
/* 115:    */       {
/* 116:114 */         ControlMedico controlMedico = (ControlMedico)it.next();
/* 117:115 */         controlMedico.setCmed_usuf_cod(usu_cod);
/* 118:116 */         controlMedico.setCmed_exa_cod(controlMedico.getElementoTabla().getExau_cod());
/* 119:117 */         controlMedico.setCmed_cod(controlMedico.getElementoTabla().getExau_cod());
/* 120:119 */         if (controlesAnterioresBaseMap.containsKey(controlMedico.getCmed_cod()))
/* 121:    */         {
/* 122:120 */           controlMedicoDAO.update(controlMedico, llavesControles, conn);
/* 123:121 */           controlesAnterioresBaseMap.remove(controlMedico.getCmed_cod());
/* 124:    */         }
/* 125:    */         else
/* 126:    */         {
/* 127:124 */           controlMedicoDAO.insert(controlMedico, conn);
/* 128:    */         }
/* 129:    */       }
/* 130:128 */       for (Iterator it = controlesAnterioresBaseMap.values().iterator(); it.hasNext();)
/* 131:    */       {
/* 132:129 */         ControlMedico controlMedico = (ControlMedico)it.next();
/* 133:130 */         controlMedicoDAO.delete(controlMedico, conn);
/* 134:    */       }
/* 135:134 */       List controlesProximosBase = controlMedicoDAO.list(usu_cod, IConstantes.CODIGO_CONTROL_PROXIMO);
/* 136:    */       
/* 137:136 */       Map controlesProximosBaseMap = new HashMap();
/* 138:137 */       for (Iterator it = controlesProximosBase.iterator(); it.hasNext();)
/* 139:    */       {
/* 140:138 */         ControlMedico controlMedico = (ControlMedico)it.next();
/* 141:139 */         controlesProximosBaseMap.put(controlMedico.getCmed_cod(), controlMedico);
/* 142:    */       }
/* 143:143 */       for (Iterator it = medicinaCompleto.getControlesProximos().iterator(); it.hasNext();)
/* 144:    */       {
/* 145:144 */         ControlMedico controlMedico = (ControlMedico)it.next();
/* 146:145 */         controlMedico.setCmed_usuf_cod(usu_cod);
/* 147:146 */         controlMedico.setCmed_exa_cod(controlMedico.getElementoTabla().getExau_cod());
/* 148:147 */         controlMedico.setCmed_cod(controlMedico.getElementoTabla().getExau_cod());
/* 149:148 */         if (controlesProximosBaseMap.containsKey(controlMedico.getCmed_cod()))
/* 150:    */         {
/* 151:149 */           controlMedicoDAO.update(controlMedico, llavesControles, conn);
/* 152:150 */           controlesProximosBaseMap.remove(controlMedico.getCmed_cod());
/* 153:    */         }
/* 154:    */         else
/* 155:    */         {
/* 156:153 */           controlMedicoDAO.insert(controlMedico, conn);
/* 157:    */         }
/* 158:    */       }
/* 159:157 */       for (Iterator it = controlesProximosBaseMap.values().iterator(); it.hasNext();)
/* 160:    */       {
/* 161:158 */         ControlMedico controlMedico = (ControlMedico)it.next();
/* 162:159 */         controlMedicoDAO.delete(controlMedico, conn);
/* 163:    */       }
/* 164:165 */       if (!manejado) {
/* 165:166 */         conn.commit();
/* 166:    */       }
/* 167:    */     }
/* 168:    */     catch (Exception e)
/* 169:    */     {
/* 170:170 */       if (!manejado) {
/* 171:171 */         rollback(conn);
/* 172:    */       }
/* 173:173 */       throw e;
/* 174:    */     }
/* 175:    */     finally
/* 176:    */     {
/* 177:175 */       if (!manejado) {
/* 178:176 */         close(conn);
/* 179:    */       }
/* 180:    */     }
/* 181:    */   }
/* 182:    */   
/* 183:    */   public MedicinaCompleto retrieve(BigDecimal usu_cod, String usu_sexo)
/* 184:    */     throws Exception
/* 185:    */   {
/* 186:183 */     MedicinaCompleto medicinaCompleto = new MedicinaCompleto();
/* 187:    */     try
/* 188:    */     {
/* 189:188 */       GruposUsuarioDAO gruposUsuarioDAO = new GruposUsuarioDAO();
/* 190:189 */       gruposUsuarioDAO.setServerNumber(this.serverNumber);
/* 191:190 */       ArrayList grupos = new ArrayList();
/* 192:191 */       grupos.add(gruposUsuarioDAO.search(usu_cod, IGrupos.FAMILY_MEDICINA_A));
/* 193:192 */       grupos.add(gruposUsuarioDAO.search(usu_cod, IGrupos.FAMILY_MEDICINA_B));
/* 194:193 */       grupos.add(gruposUsuarioDAO.search(usu_cod, IGrupos.FAMILY_MEDICINA_C));
/* 195:194 */       medicinaCompleto.setGrupos(grupos);
/* 196:    */       
/* 197:    */ 
/* 198:197 */       ExamenesDAO examenesDAO = new ExamenesDAO();
/* 199:198 */       examenesDAO.setServerNumber(this.serverNumber);
/* 200:199 */       examenesDAO.setIdioma(this.idioma);
/* 201:200 */       medicinaCompleto.setTablaUniversal(examenesDAO.list(usu_sexo));
/* 202:    */       
/* 203:202 */       ExamenesUsuario examenUsuarioTemp = new ExamenesUsuario();
/* 204:    */       
/* 205:    */ 
/* 206:205 */       ExamenesUsuarioDAO examenesUsuarioDAO = new ExamenesUsuarioDAO();
/* 207:206 */       examenesUsuarioDAO.setServerNumber(this.serverNumber);
/* 208:207 */       medicinaCompleto.setTablaAjustada(examenesUsuarioDAO.list(usu_cod));
/* 209:    */       
/* 210:    */ 
/* 211:210 */       ControlMedicoDAO controlMedicoDAO = new ControlMedicoDAO();
/* 212:211 */       controlMedicoDAO.setServerNumber(this.serverNumber);
/* 213:212 */       medicinaCompleto.setControlesAnteriores(controlMedicoDAO.list(usu_cod, IConstantes.CODIGO_CONTROL_ANTERIOR));
/* 214:213 */       for (Iterator iter = medicinaCompleto.getControlesAnteriores().iterator(); iter.hasNext();)
/* 215:    */       {
/* 216:214 */         ControlMedico controlMedico = (ControlMedico)iter.next();
/* 217:215 */         examenUsuarioTemp.setExau_cod(controlMedico.getCmed_exa_cod());
/* 218:216 */         examenUsuarioTemp.setExau_usuf_cod(usu_cod);
/* 219:217 */         controlMedico.setElementoTabla((ExamenesUsuario)medicinaCompleto.getTablaAjustada().get(medicinaCompleto.getTablaAjustada().indexOf(examenUsuarioTemp)));
/* 220:    */       }
/* 221:221 */       medicinaCompleto.setControlesProximos(controlMedicoDAO.list(usu_cod, IConstantes.CODIGO_CONTROL_PROXIMO));
/* 222:222 */       for (Iterator iter = medicinaCompleto.getControlesProximos().iterator(); iter.hasNext();)
/* 223:    */       {
/* 224:223 */         ControlMedico controlMedico = (ControlMedico)iter.next();
/* 225:224 */         examenUsuarioTemp.setExau_cod(controlMedico.getCmed_exa_cod());
/* 226:225 */         examenUsuarioTemp.setExau_usuf_cod(usu_cod);
/* 227:226 */         controlMedico.setElementoTabla((ExamenesUsuario)medicinaCompleto.getTablaAjustada().get(medicinaCompleto.getTablaAjustada().indexOf(examenUsuarioTemp)));
/* 228:    */       }
/* 229:    */     }
/* 230:    */     catch (Exception e)
/* 231:    */     {
/* 232:230 */       throw e;
/* 233:    */     }
/* 234:233 */     return medicinaCompleto;
/* 235:    */   }
/* 236:    */   
/* 237:    */   public void delete(BigDecimal usu_cod, Connection conn)
/* 238:    */     throws Exception
/* 239:    */   {
/* 240:238 */     boolean manejado = conn != null;
/* 241:    */     try
/* 242:    */     {
/* 243:242 */       if (!manejado)
/* 244:    */       {
/* 245:243 */         conn = this.ds.getConnection();
/* 246:244 */         conn.setAutoCommit(false);
/* 247:    */       }
/* 248:249 */       GruposUsuarioDAO gruposUsuarioDAO = new GruposUsuarioDAO();
/* 249:250 */       gruposUsuarioDAO.setServerNumber(this.serverNumber);
/* 250:251 */       GruposUsuario grupoUsuarioABorrar = new GruposUsuario();
/* 251:252 */       grupoUsuarioABorrar.setGrupu_cod(IGrupos.FAMILY_MEDICINA_A);
/* 252:253 */       grupoUsuarioABorrar.setGrupu_usuf_cod(usu_cod);
/* 253:254 */       gruposUsuarioDAO.delete(grupoUsuarioABorrar, conn);
/* 254:255 */       grupoUsuarioABorrar.setGrupu_cod(IGrupos.FAMILY_MEDICINA_B);
/* 255:256 */       gruposUsuarioDAO.delete(grupoUsuarioABorrar, conn);
/* 256:257 */       grupoUsuarioABorrar.setGrupu_cod(IGrupos.FAMILY_MEDICINA_C);
/* 257:258 */       gruposUsuarioDAO.delete(grupoUsuarioABorrar, conn);
/* 258:    */       
/* 259:    */ 
/* 260:261 */       ExamenesUsuarioDAO examenesUsuarioDAO = new ExamenesUsuarioDAO();
/* 261:262 */       examenesUsuarioDAO.setServerNumber(this.serverNumber);
/* 262:263 */       examenesUsuarioDAO.deleteAll(usu_cod, conn);
/* 263:    */       
/* 264:    */ 
/* 265:266 */       ControlMedicoDAO controlMedicoDAO = new ControlMedicoDAO();
/* 266:267 */       controlMedicoDAO.setServerNumber(this.serverNumber);
/* 267:268 */       controlMedicoDAO.deleteAll(usu_cod, conn);
/* 268:270 */       if (!manejado) {
/* 269:271 */         conn.commit();
/* 270:    */       }
/* 271:    */     }
/* 272:    */     catch (Exception e)
/* 273:    */     {
/* 274:275 */       if (!manejado) {
/* 275:276 */         rollback(conn);
/* 276:    */       }
/* 277:278 */       throw e;
/* 278:    */     }
/* 279:    */     finally
/* 280:    */     {
/* 281:280 */       if (!manejado) {
/* 282:281 */         close(conn);
/* 283:    */       }
/* 284:    */     }
/* 285:    */   }
/* 286:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.dao.MedicinaCompletoDAO
 * JD-Core Version:    0.7.0.1
 */