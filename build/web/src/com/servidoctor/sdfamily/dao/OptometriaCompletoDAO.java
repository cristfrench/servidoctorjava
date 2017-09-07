/*   1:    */ package com.servidoctor.sdfamily.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.constantes.IConstantes;
/*   5:    */ import com.servidoctor.constantes.IGrupos;
/*   6:    */ import com.servidoctor.parametros.dao.OptometriaDAO;
/*   7:    */ import com.servidoctor.parametros.model.Optometria;
/*   8:    */ import com.servidoctor.sdfamily.model.ControlOptometria;
/*   9:    */ import com.servidoctor.sdfamily.model.GruposUsuario;
/*  10:    */ import com.servidoctor.sdfamily.model.OptometriaCompleto;
/*  11:    */ import java.math.BigDecimal;
/*  12:    */ import java.sql.Connection;
/*  13:    */ import java.util.Collection;
/*  14:    */ import java.util.HashMap;
/*  15:    */ import java.util.Iterator;
/*  16:    */ import java.util.List;
/*  17:    */ import java.util.Map;
/*  18:    */ import javax.sql.DataSource;
/*  19:    */ 
/*  20:    */ public class OptometriaCompletoDAO
/*  21:    */   extends DAO
/*  22:    */ {
/*  23:    */   public void update(OptometriaCompleto optometriaCompleto, BigDecimal usuf_cod)
/*  24:    */     throws Exception
/*  25:    */   {
/*  26: 29 */     update(optometriaCompleto, usuf_cod, null);
/*  27:    */   }
/*  28:    */   
/*  29:    */   public void update(OptometriaCompleto optometriaCompleto, BigDecimal usuf_cod, Connection conn)
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
/*  43: 47 */       if (gruposUsuarioDAO.search(optometriaCompleto.getGrupoUsuario().getGrupu_usuf_cod(), IGrupos.FAMILY_OPTOMETRIA).getGrupu_cod() != null) {
/*  44: 48 */         gruposUsuarioDAO.update(optometriaCompleto.getGrupoUsuario(), llavesGruposUsuario, conn);
/*  45:    */       } else {
/*  46: 50 */         gruposUsuarioDAO.insert(optometriaCompleto.getGrupoUsuario(), conn);
/*  47:    */       }
/*  48: 54 */       String[] llavesTablaAjustada = { "opt_cod", "opt_usuf_cod" };
/*  49: 55 */       OptometriaDAO optometriaDAO = new OptometriaDAO();
/*  50: 56 */       optometriaDAO.setServerNumber(this.serverNumber);
/*  51: 57 */       List tablaAjustadaBase = optometriaDAO.list(usuf_cod);
/*  52:    */       
/*  53: 59 */       Map tablaAjustadaBaseMap = new HashMap();
/*  54: 60 */       for (Iterator it = tablaAjustadaBase.iterator(); it.hasNext();)
/*  55:    */       {
/*  56: 61 */         Optometria optometria = (Optometria)it.next();
/*  57: 62 */         tablaAjustadaBaseMap.put(optometria.getOpt_cod(), optometria);
/*  58:    */       }
/*  59: 65 */       for (Iterator it = optometriaCompleto.getTablaAjustada().iterator(); it.hasNext();)
/*  60:    */       {
/*  61: 66 */         Optometria optometria = (Optometria)it.next();
/*  62: 67 */         if (tablaAjustadaBaseMap.containsKey(optometria.getOpt_cod()))
/*  63:    */         {
/*  64: 68 */           optometriaDAO.update(optometria, llavesTablaAjustada, conn);
/*  65: 69 */           tablaAjustadaBaseMap.remove(optometria.getOpt_cod());
/*  66:    */         }
/*  67:    */         else
/*  68:    */         {
/*  69: 71 */           optometriaDAO.insert(optometria, conn);
/*  70:    */         }
/*  71:    */       }
/*  72: 75 */       for (Iterator it = tablaAjustadaBaseMap.values().iterator(); it.hasNext();)
/*  73:    */       {
/*  74: 76 */         Optometria optometria = (Optometria)it.next();
/*  75: 77 */         optometriaDAO.delete(optometria, conn);
/*  76:    */       }
/*  77: 81 */       String[] llavesControles = { "copt_cod", "copt_usuf_cod" };
/*  78: 82 */       ControlOptometriaDAO controlOptometriaDAO = new ControlOptometriaDAO();
/*  79: 83 */       controlOptometriaDAO.setServerNumber(this.serverNumber);
/*  80: 84 */       List controlesAnterioresBase = controlOptometriaDAO.list(usuf_cod, IConstantes.CODIGO_CONTROL_ANTERIOR);
/*  81:    */       
/*  82: 86 */       Map controlesAnterioresBaseMap = new HashMap();
/*  83: 87 */       for (Iterator it = controlesAnterioresBase.iterator(); it.hasNext();)
/*  84:    */       {
/*  85: 88 */         ControlOptometria controlOptometria = (ControlOptometria)it.next();
/*  86: 89 */         controlesAnterioresBaseMap.put(controlOptometria.getCopt_cod(), controlOptometria);
/*  87:    */       }
/*  88: 92 */       for (Iterator it = optometriaCompleto.getControlesAnteriores().iterator(); it.hasNext();)
/*  89:    */       {
/*  90: 93 */         ControlOptometria controlOptometria = (ControlOptometria)it.next();
/*  91: 94 */         controlOptometria.setCopt_usuf_cod(usuf_cod);
/*  92: 95 */         if (controlesAnterioresBaseMap.containsKey(controlOptometria.getCopt_cod()))
/*  93:    */         {
/*  94: 96 */           controlOptometriaDAO.update(controlOptometria, llavesControles, conn);
/*  95: 97 */           controlesAnterioresBaseMap.remove(controlOptometria.getCopt_cod());
/*  96:    */         }
/*  97:    */         else
/*  98:    */         {
/*  99: 99 */           controlOptometriaDAO.insert(controlOptometria, conn);
/* 100:    */         }
/* 101:    */       }
/* 102:103 */       for (Iterator it = controlesAnterioresBaseMap.values().iterator(); it.hasNext();)
/* 103:    */       {
/* 104:104 */         ControlOptometria controlOptometria = (ControlOptometria)it.next();
/* 105:105 */         controlOptometriaDAO.delete(controlOptometria, conn);
/* 106:    */       }
/* 107:109 */       List controlesProximosBase = controlOptometriaDAO.list(usuf_cod, IConstantes.CODIGO_CONTROL_PROXIMO);
/* 108:    */       
/* 109:111 */       Map controlesProximosBaseMap = new HashMap();
/* 110:112 */       for (Iterator it = controlesProximosBase.iterator(); it.hasNext();)
/* 111:    */       {
/* 112:113 */         ControlOptometria controlOptometria = (ControlOptometria)it.next();
/* 113:114 */         controlesProximosBaseMap.put(controlOptometria.getCopt_cod(), controlOptometria);
/* 114:    */       }
/* 115:117 */       for (Iterator it = optometriaCompleto.getControlesProximos().iterator(); it.hasNext();)
/* 116:    */       {
/* 117:118 */         ControlOptometria controlOptometria = (ControlOptometria)it.next();
/* 118:119 */         controlOptometria.setCopt_usuf_cod(usuf_cod);
/* 119:120 */         if (controlesProximosBaseMap.containsKey(controlOptometria.getCopt_cod()))
/* 120:    */         {
/* 121:121 */           controlOptometriaDAO.update(controlOptometria, llavesControles, conn);
/* 122:122 */           controlesProximosBaseMap.remove(controlOptometria.getCopt_cod());
/* 123:    */         }
/* 124:    */         else
/* 125:    */         {
/* 126:124 */           controlOptometriaDAO.insert(controlOptometria, conn);
/* 127:    */         }
/* 128:    */       }
/* 129:128 */       for (Iterator it = controlesProximosBaseMap.values().iterator(); it.hasNext();)
/* 130:    */       {
/* 131:129 */         ControlOptometria controlOptometria = (ControlOptometria)it.next();
/* 132:130 */         controlOptometriaDAO.delete(controlOptometria, conn);
/* 133:    */       }
/* 134:133 */       if (!manejado) {
/* 135:134 */         conn.commit();
/* 136:    */       }
/* 137:    */     }
/* 138:    */     catch (Exception e)
/* 139:    */     {
/* 140:138 */       if (!manejado) {
/* 141:139 */         rollback(conn);
/* 142:    */       }
/* 143:141 */       throw e;
/* 144:    */     }
/* 145:    */     finally
/* 146:    */     {
/* 147:143 */       if (!manejado) {
/* 148:144 */         close(conn);
/* 149:    */       }
/* 150:    */     }
/* 151:    */   }
/* 152:    */   
/* 153:    */   public OptometriaCompleto retrieve(BigDecimal usuf_cod)
/* 154:    */     throws Exception
/* 155:    */   {
/* 156:151 */     OptometriaCompleto optometriaCompleto = new OptometriaCompleto();
/* 157:    */     try
/* 158:    */     {
/* 159:155 */       GruposUsuarioDAO gruposUsuarioDAO = new GruposUsuarioDAO();
/* 160:156 */       gruposUsuarioDAO.setServerNumber(this.serverNumber);
/* 161:157 */       optometriaCompleto.setGrupoUsuario(gruposUsuarioDAO.search(usuf_cod, IGrupos.FAMILY_OPTOMETRIA));
/* 162:    */       
/* 163:    */ 
/* 164:160 */       OptometriaDAO optometriaDAO = new OptometriaDAO();
/* 165:161 */       optometriaDAO.setServerNumber(this.serverNumber);
/* 166:162 */       optometriaCompleto.setTablaUniversal(optometriaDAO.list(BigDecimal.ZERO));
/* 167:    */       
/* 168:    */ 
/* 169:165 */       optometriaCompleto.setTablaAjustada(optometriaDAO.list(usuf_cod));
/* 170:    */       
/* 171:    */ 
/* 172:168 */       ControlOptometriaDAO controlOptometriaDAO = new ControlOptometriaDAO();
/* 173:169 */       controlOptometriaDAO.setServerNumber(this.serverNumber);
/* 174:170 */       optometriaCompleto.setControlesAnteriores(controlOptometriaDAO.list(usuf_cod, IConstantes.CODIGO_CONTROL_ANTERIOR));
/* 175:    */       
/* 176:    */ 
/* 177:173 */       optometriaCompleto.setControlesProximos(controlOptometriaDAO.list(usuf_cod, IConstantes.CODIGO_CONTROL_PROXIMO));
/* 178:    */     }
/* 179:    */     catch (Exception e)
/* 180:    */     {
/* 181:176 */       throw e;
/* 182:    */     }
/* 183:179 */     return optometriaCompleto;
/* 184:    */   }
/* 185:    */   
/* 186:    */   public void delete(BigDecimal usuf_cod, Connection conn)
/* 187:    */     throws Exception
/* 188:    */   {
/* 189:184 */     boolean manejado = conn != null;
/* 190:    */     try
/* 191:    */     {
/* 192:188 */       if (!manejado)
/* 193:    */       {
/* 194:189 */         conn = this.ds.getConnection();
/* 195:190 */         conn.setAutoCommit(false);
/* 196:    */       }
/* 197:193 */       ControlOptometriaDAO controlOptometriaDAO = new ControlOptometriaDAO();
/* 198:194 */       controlOptometriaDAO.setServerNumber(this.serverNumber);
/* 199:195 */       controlOptometriaDAO.deleteAll(usuf_cod, conn);
/* 200:    */       
/* 201:    */ 
/* 202:198 */       OptometriaDAO optometriaDAO = new OptometriaDAO();
/* 203:199 */       optometriaDAO.setServerNumber(this.serverNumber);
/* 204:200 */       optometriaDAO.deleteAll(usuf_cod, conn);
/* 205:    */       
/* 206:    */ 
/* 207:203 */       GruposUsuarioDAO gruposUsuarioDAO = new GruposUsuarioDAO();
/* 208:204 */       gruposUsuarioDAO.setServerNumber(this.serverNumber);
/* 209:205 */       GruposUsuario grupoUsuarioABorrar = new GruposUsuario();
/* 210:206 */       grupoUsuarioABorrar.setGrupu_cod(IGrupos.FAMILY_OPTOMETRIA);
/* 211:207 */       grupoUsuarioABorrar.setGrupu_usuf_cod(usuf_cod);
/* 212:208 */       gruposUsuarioDAO.delete(grupoUsuarioABorrar, conn);
/* 213:210 */       if (!manejado) {
/* 214:211 */         conn.commit();
/* 215:    */       }
/* 216:    */     }
/* 217:    */     catch (Exception e)
/* 218:    */     {
/* 219:215 */       if (!manejado) {
/* 220:216 */         rollback(conn);
/* 221:    */       }
/* 222:218 */       throw e;
/* 223:    */     }
/* 224:    */     finally
/* 225:    */     {
/* 226:220 */       if (!manejado) {
/* 227:221 */         close(conn);
/* 228:    */       }
/* 229:    */     }
/* 230:    */   }
/* 231:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.dao.OptometriaCompletoDAO
 * JD-Core Version:    0.7.0.1
 */