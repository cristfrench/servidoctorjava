/*   1:    */ package com.servidoctor.sdfamily.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.constantes.IConstantes;
/*   5:    */ import com.servidoctor.constantes.IGrupos;
/*   6:    */ import com.servidoctor.parametros.dao.OdontologiaDAO;
/*   7:    */ import com.servidoctor.sdfamily.model.ControlOdontologia;
/*   8:    */ import com.servidoctor.sdfamily.model.GruposUsuario;
/*   9:    */ import com.servidoctor.sdfamily.model.OdontologiaCompleto;
/*  10:    */ import com.servidoctor.sdfamily.model.OdontologiaUsuario;
/*  11:    */ import java.math.BigDecimal;
/*  12:    */ import java.sql.Connection;
/*  13:    */ import java.util.Collection;
/*  14:    */ import java.util.HashMap;
/*  15:    */ import java.util.Iterator;
/*  16:    */ import java.util.List;
/*  17:    */ import java.util.Map;
/*  18:    */ import javax.sql.DataSource;
/*  19:    */ 
/*  20:    */ public class OdontologiaCompletoDAO
/*  21:    */   extends DAO
/*  22:    */ {
/*  23:    */   public void update(OdontologiaCompleto odontologiaCompleto, BigDecimal usuf_cod)
/*  24:    */     throws Exception
/*  25:    */   {
/*  26: 29 */     update(odontologiaCompleto, usuf_cod, null);
/*  27:    */   }
/*  28:    */   
/*  29:    */   public void update(OdontologiaCompleto odontologiaCompleto, BigDecimal usuf_cod, Connection conn)
/*  30:    */     throws Exception
/*  31:    */   {
/*  32: 34 */     boolean manejado = conn != null;
/*  33:    */     try
/*  34:    */     {
/*  35: 38 */       if (!manejado)
/*  36:    */       {
/*  37: 39 */         conn = this.ds.getConnection();
/*  38: 40 */         conn.setAutoCommit(false);
/*  39:    */       }
/*  40: 44 */       String[] llavesGruposUsuario = { "grupu_cod", "grupu_usuf_cod" };
/*  41: 45 */       GruposUsuarioDAO gruposUsuarioDAO = new GruposUsuarioDAO();
/*  42: 46 */       gruposUsuarioDAO.setServerNumber(this.serverNumber);
/*  43: 47 */       if (gruposUsuarioDAO.search(odontologiaCompleto.getGrupoUsuario().getGrupu_usuf_cod(), IGrupos.FAMILY_ODONTOLOGIA).getGrupu_cod() != null) {
/*  44: 48 */         gruposUsuarioDAO.update(odontologiaCompleto.getGrupoUsuario(), llavesGruposUsuario, conn);
/*  45:    */       } else {
/*  46: 50 */         gruposUsuarioDAO.insert(odontologiaCompleto.getGrupoUsuario(), conn);
/*  47:    */       }
/*  48: 54 */       String[] llavesTablaAjustada = { "odou_cod", "odou_usuf_cod" };
/*  49: 55 */       OdontologiaUsuarioDAO odontologiaUsuarioDAO = new OdontologiaUsuarioDAO();
/*  50: 56 */       odontologiaUsuarioDAO.setServerNumber(this.serverNumber);
/*  51: 57 */       List tablaAjustadaBase = odontologiaUsuarioDAO.list(usuf_cod);
/*  52:    */       
/*  53: 59 */       Map tablaAjustadaBaseMap = new HashMap();
/*  54: 60 */       for (Iterator it = tablaAjustadaBase.iterator(); it.hasNext();)
/*  55:    */       {
/*  56: 61 */         OdontologiaUsuario odontologiaUsuario = (OdontologiaUsuario)it.next();
/*  57: 62 */         tablaAjustadaBaseMap.put(odontologiaUsuario.getOdou_cod(), odontologiaUsuario);
/*  58:    */       }
/*  59: 65 */       for (Iterator it = odontologiaCompleto.getTablaAjustada().iterator(); it.hasNext();)
/*  60:    */       {
/*  61: 66 */         OdontologiaUsuario odontologiaUsuario = (OdontologiaUsuario)it.next();
/*  62: 67 */         odontologiaUsuario.setOdou_usuf_cod(usuf_cod);
/*  63: 68 */         if (tablaAjustadaBaseMap.containsKey(odontologiaUsuario.getOdou_cod()))
/*  64:    */         {
/*  65: 69 */           odontologiaUsuarioDAO.update(odontologiaUsuario, llavesTablaAjustada, conn);
/*  66: 70 */           tablaAjustadaBaseMap.remove(odontologiaUsuario.getOdou_cod());
/*  67:    */         }
/*  68:    */         else
/*  69:    */         {
/*  70: 72 */           odontologiaUsuarioDAO.insert(odontologiaUsuario, conn);
/*  71:    */         }
/*  72:    */       }
/*  73: 76 */       for (Iterator it = tablaAjustadaBaseMap.values().iterator(); it.hasNext();)
/*  74:    */       {
/*  75: 77 */         OdontologiaUsuario odontologiaUsuario = (OdontologiaUsuario)it.next();
/*  76: 78 */         odontologiaUsuarioDAO.delete(odontologiaUsuario, conn);
/*  77:    */       }
/*  78: 82 */       String[] llavesControles = { "codo_cod", "codo_usuf_cod", "codo_tipo" };
/*  79: 83 */       ControlOdontologiaDAO controlOdontologiaDAO = new ControlOdontologiaDAO();
/*  80: 84 */       controlOdontologiaDAO.setServerNumber(this.serverNumber);
/*  81: 85 */       List controlesAnterioresBase = controlOdontologiaDAO.list(usuf_cod, IConstantes.CODIGO_CONTROL_ANTERIOR);
/*  82:    */       
/*  83: 87 */       Map controlesAnterioresBaseMap = new HashMap();
/*  84: 88 */       for (Iterator it = controlesAnterioresBase.iterator(); it.hasNext();)
/*  85:    */       {
/*  86: 89 */         ControlOdontologia controlOdontologia = (ControlOdontologia)it.next();
/*  87: 90 */         controlesAnterioresBaseMap.put(controlOdontologia.getCodo_cod(), controlOdontologia);
/*  88:    */       }
/*  89: 93 */       for (Iterator it = odontologiaCompleto.getControlesAnteriores().iterator(); it.hasNext();)
/*  90:    */       {
/*  91: 94 */         ControlOdontologia controlOdontologia = (ControlOdontologia)it.next();
/*  92: 95 */         controlOdontologia.setCodo_usuf_cod(usuf_cod);
/*  93: 96 */         controlOdontologia.setCodo_odo_cod(controlOdontologia.getElementoTabla().getOdou_cod());
/*  94: 97 */         if (controlesAnterioresBaseMap.containsKey(controlOdontologia.getCodo_cod()))
/*  95:    */         {
/*  96: 98 */           controlOdontologiaDAO.update(controlOdontologia, llavesControles, conn);
/*  97: 99 */           controlesAnterioresBaseMap.remove(controlOdontologia.getCodo_cod());
/*  98:    */         }
/*  99:    */         else
/* 100:    */         {
/* 101:101 */           controlOdontologia.setCodo_cod(controlOdontologia.getElementoTabla().getOdou_cod());
/* 102:102 */           controlOdontologiaDAO.insert(controlOdontologia, conn);
/* 103:    */         }
/* 104:    */       }
/* 105:106 */       for (Iterator it = controlesAnterioresBaseMap.values().iterator(); it.hasNext();)
/* 106:    */       {
/* 107:107 */         ControlOdontologia controlOdontologia = (ControlOdontologia)it.next();
/* 108:108 */         controlOdontologiaDAO.delete(controlOdontologia, conn);
/* 109:    */       }
/* 110:112 */       List controlesProximosBase = controlOdontologiaDAO.list(usuf_cod, IConstantes.CODIGO_CONTROL_PROXIMO);
/* 111:    */       
/* 112:114 */       Map controlesProximosBaseMap = new HashMap();
/* 113:115 */       for (Iterator it = controlesProximosBase.iterator(); it.hasNext();)
/* 114:    */       {
/* 115:116 */         ControlOdontologia controlOdontologia = (ControlOdontologia)it.next();
/* 116:117 */         controlesProximosBaseMap.put(controlOdontologia.getCodo_cod(), controlOdontologia);
/* 117:    */       }
/* 118:120 */       for (Iterator it = odontologiaCompleto.getControlesProximos().iterator(); it.hasNext();)
/* 119:    */       {
/* 120:121 */         ControlOdontologia controlOdontologia = (ControlOdontologia)it.next();
/* 121:122 */         controlOdontologia.setCodo_usuf_cod(usuf_cod);
/* 122:    */         
/* 123:124 */         controlOdontologia.setCodo_odo_cod(controlOdontologia.getElementoTabla().getOdou_cod());
/* 124:125 */         if (controlesProximosBaseMap.containsKey(controlOdontologia.getCodo_cod()))
/* 125:    */         {
/* 126:126 */           controlOdontologiaDAO.update(controlOdontologia, llavesControles, conn);
/* 127:127 */           controlesProximosBaseMap.remove(controlOdontologia.getCodo_cod());
/* 128:    */         }
/* 129:    */         else
/* 130:    */         {
/* 131:129 */           controlOdontologia.setCodo_cod(controlOdontologia.getElementoTabla().getOdou_cod());
/* 132:130 */           controlOdontologiaDAO.insert(controlOdontologia, conn);
/* 133:    */         }
/* 134:    */       }
/* 135:134 */       for (Iterator it = controlesProximosBaseMap.values().iterator(); it.hasNext();)
/* 136:    */       {
/* 137:135 */         ControlOdontologia controlOdontologia = (ControlOdontologia)it.next();
/* 138:136 */         controlOdontologiaDAO.delete(controlOdontologia, conn);
/* 139:    */       }
/* 140:140 */       if (!manejado) {
/* 141:141 */         conn.commit();
/* 142:    */       }
/* 143:    */     }
/* 144:    */     catch (Exception e)
/* 145:    */     {
/* 146:145 */       if (!manejado) {
/* 147:146 */         rollback(conn);
/* 148:    */       }
/* 149:148 */       throw e;
/* 150:    */     }
/* 151:    */     finally
/* 152:    */     {
/* 153:150 */       if (!manejado) {
/* 154:151 */         close(conn);
/* 155:    */       }
/* 156:    */     }
/* 157:    */   }
/* 158:    */   
/* 159:    */   public OdontologiaCompleto retrieve(BigDecimal usuf_cod)
/* 160:    */     throws Exception
/* 161:    */   {
/* 162:158 */     OdontologiaCompleto odontologiaCompleto = new OdontologiaCompleto();
/* 163:    */     try
/* 164:    */     {
/* 165:162 */       GruposUsuarioDAO gruposUsuarioDAO = new GruposUsuarioDAO();
/* 166:163 */       gruposUsuarioDAO.setServerNumber(this.serverNumber);
/* 167:164 */       odontologiaCompleto.setGrupoUsuario(gruposUsuarioDAO.search(usuf_cod, IGrupos.FAMILY_ODONTOLOGIA));
/* 168:    */       
/* 169:    */ 
/* 170:167 */       OdontologiaDAO odontologiaDAO = new OdontologiaDAO();
/* 171:168 */       odontologiaDAO.setServerNumber(this.serverNumber);
/* 172:169 */       odontologiaDAO.setIdioma(this.idioma);
/* 173:170 */       odontologiaCompleto.setTablaUniversal(odontologiaDAO.list());
/* 174:    */       
/* 175:172 */       OdontologiaUsuario odontologiaUsuarioTemp = new OdontologiaUsuario();
/* 176:    */       
/* 177:    */ 
/* 178:175 */       OdontologiaUsuarioDAO odontologiaUsuarioDAO = new OdontologiaUsuarioDAO();
/* 179:176 */       odontologiaUsuarioDAO.setServerNumber(this.serverNumber);
/* 180:177 */       odontologiaCompleto.setTablaAjustada(odontologiaUsuarioDAO.list(usuf_cod));
/* 181:    */       
/* 182:    */ 
/* 183:180 */       ControlOdontologiaDAO controlOdontologiaDAO = new ControlOdontologiaDAO();
/* 184:181 */       controlOdontologiaDAO.setServerNumber(this.serverNumber);
/* 185:182 */       odontologiaCompleto.setControlesAnteriores(controlOdontologiaDAO.list(usuf_cod, IConstantes.CODIGO_CONTROL_ANTERIOR));
/* 186:183 */       for (Iterator iter = odontologiaCompleto.getControlesAnteriores().iterator(); iter.hasNext();)
/* 187:    */       {
/* 188:184 */         ControlOdontologia controlOdontologia = (ControlOdontologia)iter.next();
/* 189:185 */         odontologiaUsuarioTemp.setOdou_cod(controlOdontologia.getCodo_odo_cod());
/* 190:186 */         odontologiaUsuarioTemp.setOdou_usuf_cod(usuf_cod);
/* 191:187 */         controlOdontologia.setElementoTabla((OdontologiaUsuario)odontologiaCompleto.getTablaAjustada().get(odontologiaCompleto.getTablaAjustada().indexOf(odontologiaUsuarioTemp)));
/* 192:    */       }
/* 193:191 */       odontologiaCompleto.setControlesProximos(controlOdontologiaDAO.list(usuf_cod, IConstantes.CODIGO_CONTROL_PROXIMO));
/* 194:192 */       for (Iterator iter = odontologiaCompleto.getControlesProximos().iterator(); iter.hasNext();)
/* 195:    */       {
/* 196:193 */         ControlOdontologia controlOdontologia = (ControlOdontologia)iter.next();
/* 197:194 */         odontologiaUsuarioTemp.setOdou_cod(controlOdontologia.getCodo_odo_cod());
/* 198:195 */         odontologiaUsuarioTemp.setOdou_usuf_cod(usuf_cod);
/* 199:196 */         int indice = odontologiaCompleto.getTablaAjustada().indexOf(odontologiaUsuarioTemp);
/* 200:197 */         OdontologiaUsuario odo = (OdontologiaUsuario)odontologiaCompleto.getTablaAjustada().get(indice);
/* 201:198 */         controlOdontologia.setElementoTabla(odo);
/* 202:    */       }
/* 203:    */     }
/* 204:    */     catch (Exception e)
/* 205:    */     {
/* 206:202 */       throw e;
/* 207:    */     }
/* 208:205 */     return odontologiaCompleto;
/* 209:    */   }
/* 210:    */   
/* 211:    */   public void delete(BigDecimal usuf_cod, Connection conn)
/* 212:    */     throws Exception
/* 213:    */   {
/* 214:210 */     boolean manejado = conn != null;
/* 215:    */     try
/* 216:    */     {
/* 217:214 */       if (!manejado)
/* 218:    */       {
/* 219:215 */         conn = this.ds.getConnection();
/* 220:216 */         conn.setAutoCommit(false);
/* 221:    */       }
/* 222:220 */       ControlOdontologiaDAO controlOdontologiaDAO = new ControlOdontologiaDAO();
/* 223:221 */       controlOdontologiaDAO.setServerNumber(this.serverNumber);
/* 224:222 */       controlOdontologiaDAO.deleteAll(usuf_cod, conn);
/* 225:    */       
/* 226:    */ 
/* 227:225 */       OdontologiaUsuarioDAO odontologiaUsuarioDAO = new OdontologiaUsuarioDAO();
/* 228:226 */       odontologiaUsuarioDAO.setServerNumber(this.serverNumber);
/* 229:227 */       odontologiaUsuarioDAO.deleteAll(usuf_cod, conn);
/* 230:    */       
/* 231:    */ 
/* 232:230 */       GruposUsuarioDAO gruposUsuarioDAO = new GruposUsuarioDAO();
/* 233:231 */       gruposUsuarioDAO.setServerNumber(this.serverNumber);
/* 234:232 */       GruposUsuario grupoUsuarioABorrar = new GruposUsuario();
/* 235:233 */       grupoUsuarioABorrar.setGrupu_cod(IGrupos.FAMILY_ODONTOLOGIA);
/* 236:234 */       grupoUsuarioABorrar.setGrupu_usuf_cod(usuf_cod);
/* 237:235 */       gruposUsuarioDAO.delete(grupoUsuarioABorrar, conn);
/* 238:237 */       if (!manejado) {
/* 239:238 */         conn.commit();
/* 240:    */       }
/* 241:    */     }
/* 242:    */     catch (Exception e)
/* 243:    */     {
/* 244:242 */       if (!manejado) {
/* 245:243 */         rollback(conn);
/* 246:    */       }
/* 247:245 */       throw e;
/* 248:    */     }
/* 249:    */     finally
/* 250:    */     {
/* 251:247 */       if (!manejado) {
/* 252:248 */         close(conn);
/* 253:    */       }
/* 254:    */     }
/* 255:    */   }
/* 256:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.dao.OdontologiaCompletoDAO
 * JD-Core Version:    0.7.0.1
 */