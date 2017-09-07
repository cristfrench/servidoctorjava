/*   1:    */ package com.servidoctor.sdfamily.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.constantes.IGrupos;
/*   5:    */ import com.servidoctor.parametros.dao.VacunasDAO;
/*   6:    */ import com.servidoctor.sdfamily.model.GruposUsuario;
/*   7:    */ import com.servidoctor.sdfamily.model.VacunasCompleto;
/*   8:    */ import com.servidoctor.sdfamily.model.VacunasUsuario;
/*   9:    */ import java.math.BigDecimal;
/*  10:    */ import java.sql.Connection;
/*  11:    */ import java.util.Collection;
/*  12:    */ import java.util.HashMap;
/*  13:    */ import java.util.Iterator;
/*  14:    */ import java.util.List;
/*  15:    */ import java.util.Map;
/*  16:    */ import javax.sql.DataSource;
/*  17:    */ 
/*  18:    */ public class VacunasCompletoDAO
/*  19:    */   extends DAO
/*  20:    */ {
/*  21:    */   public void update(VacunasCompleto vacunasCompleto, BigDecimal usuf_cod)
/*  22:    */     throws Exception
/*  23:    */   {
/*  24: 27 */     update(vacunasCompleto, usuf_cod, null);
/*  25:    */   }
/*  26:    */   
/*  27:    */   public void update(VacunasCompleto vacunasCompleto, BigDecimal usuf_cod, Connection conn)
/*  28:    */     throws Exception
/*  29:    */   {
/*  30: 32 */     boolean manejado = conn != null;
/*  31:    */     try
/*  32:    */     {
/*  33: 36 */       if (!manejado)
/*  34:    */       {
/*  35: 37 */         conn = this.ds.getConnection();
/*  36: 38 */         conn.setAutoCommit(false);
/*  37:    */       }
/*  38: 43 */       String[] llavesGruposUsuario = { "grupu_cod", "grupu_usuf_cod" };
/*  39: 44 */       GruposUsuarioDAO gruposUsuarioDAO = new GruposUsuarioDAO();
/*  40: 45 */       gruposUsuarioDAO.setServerNumber(this.serverNumber);
/*  41: 46 */       if (gruposUsuarioDAO.search(vacunasCompleto.getGrupoUsuario().getGrupu_usuf_cod(), IGrupos.FAMILY_VACUNAS).getGrupu_cod() != null) {
/*  42: 47 */         gruposUsuarioDAO.update(vacunasCompleto.getGrupoUsuario(), llavesGruposUsuario, conn);
/*  43:    */       } else {
/*  44: 49 */         gruposUsuarioDAO.insert(vacunasCompleto.getGrupoUsuario(), conn);
/*  45:    */       }
/*  46: 53 */       String[] llavesTablaAjustada = { "vacu_cod", "vacu_usuf_cod" };
/*  47: 54 */       VacunasUsuarioDAO vacunasUsuarioDAO = new VacunasUsuarioDAO();
/*  48: 55 */       vacunasUsuarioDAO.setServerNumber(this.serverNumber);
/*  49: 56 */       List tablaAjustadaBase = vacunasUsuarioDAO.list(usuf_cod);
/*  50:    */       
/*  51: 58 */       Map tablaAjustadaBaseMap = new HashMap();
/*  52: 59 */       for (Iterator it = tablaAjustadaBase.iterator(); it.hasNext();)
/*  53:    */       {
/*  54: 60 */         VacunasUsuario vacunasUsuario = (VacunasUsuario)it.next();
/*  55: 61 */         tablaAjustadaBaseMap.put(vacunasUsuario.getVacu_cod(), vacunasUsuario);
/*  56:    */       }
/*  57: 64 */       for (Iterator it = vacunasCompleto.getTablaAjustada().iterator(); it.hasNext();)
/*  58:    */       {
/*  59: 65 */         VacunasUsuario vacunasUsuario = (VacunasUsuario)it.next();
/*  60: 66 */         vacunasUsuario.setVacu_usuf_cod(usuf_cod);
/*  61: 67 */         if (tablaAjustadaBaseMap.containsKey(vacunasUsuario.getVacu_cod()))
/*  62:    */         {
/*  63: 68 */           vacunasUsuarioDAO.update(vacunasUsuario, llavesTablaAjustada, conn);
/*  64: 69 */           tablaAjustadaBaseMap.remove(vacunasUsuario.getVacu_cod());
/*  65:    */         }
/*  66:    */         else
/*  67:    */         {
/*  68: 71 */           vacunasUsuarioDAO.insert(vacunasUsuario, conn);
/*  69:    */         }
/*  70:    */       }
/*  71: 75 */       for (Iterator it = tablaAjustadaBaseMap.values().iterator(); it.hasNext();)
/*  72:    */       {
/*  73: 76 */         VacunasUsuario vacunasUsuario = (VacunasUsuario)it.next();
/*  74: 77 */         vacunasUsuarioDAO.delete(vacunasUsuario, conn);
/*  75:    */       }
/*  76: 80 */       if (!manejado) {
/*  77: 81 */         conn.commit();
/*  78:    */       }
/*  79:    */     }
/*  80:    */     catch (Exception e)
/*  81:    */     {
/*  82: 85 */       if (!manejado) {
/*  83: 86 */         rollback(conn);
/*  84:    */       }
/*  85: 88 */       throw e;
/*  86:    */     }
/*  87:    */     finally
/*  88:    */     {
/*  89: 90 */       if (!manejado) {
/*  90: 91 */         close(conn);
/*  91:    */       }
/*  92:    */     }
/*  93:    */   }
/*  94:    */   
/*  95:    */   public VacunasCompleto retrieve(BigDecimal usuf_cod)
/*  96:    */     throws Exception
/*  97:    */   {
/*  98: 98 */     VacunasCompleto vacunasCompleto = new VacunasCompleto();
/*  99:    */     try
/* 100:    */     {
/* 101:103 */       GruposUsuarioDAO gruposUsuarioDAO = new GruposUsuarioDAO();
/* 102:104 */       gruposUsuarioDAO.setServerNumber(this.serverNumber);
/* 103:105 */       vacunasCompleto.setGrupoUsuario(gruposUsuarioDAO.search(usuf_cod, IGrupos.FAMILY_VACUNAS));
/* 104:    */       
/* 105:    */ 
/* 106:108 */       VacunasDAO vacunasDAO = new VacunasDAO();
/* 107:109 */       vacunasDAO.setServerNumber(this.serverNumber);
/* 108:110 */       vacunasDAO.setIdioma(this.idioma);
/* 109:111 */       vacunasCompleto.setTablaUniversal(vacunasDAO.list());
/* 110:    */       
/* 111:    */ 
/* 112:114 */       VacunasUsuarioDAO vacunasUsuarioDAO = new VacunasUsuarioDAO();
/* 113:115 */       vacunasUsuarioDAO.setServerNumber(this.serverNumber);
/* 114:116 */       vacunasCompleto.setTablaAjustada(vacunasUsuarioDAO.list(usuf_cod));
/* 115:    */     }
/* 116:    */     catch (Exception e)
/* 117:    */     {
/* 118:119 */       throw e;
/* 119:    */     }
/* 120:122 */     return vacunasCompleto;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public void delete(BigDecimal usuf_cod, Connection conn)
/* 124:    */     throws Exception
/* 125:    */   {
/* 126:127 */     boolean manejado = conn != null;
/* 127:    */     try
/* 128:    */     {
/* 129:131 */       if (!manejado)
/* 130:    */       {
/* 131:132 */         conn = this.ds.getConnection();
/* 132:133 */         conn.setAutoCommit(false);
/* 133:    */       }
/* 134:137 */       VacunasUsuarioDAO vacunasUsuarioDAO = new VacunasUsuarioDAO();
/* 135:138 */       vacunasUsuarioDAO.setServerNumber(this.serverNumber);
/* 136:139 */       vacunasUsuarioDAO.deleteAll(usuf_cod, conn);
/* 137:    */       
/* 138:    */ 
/* 139:142 */       GruposUsuarioDAO gruposUsuarioDAO = new GruposUsuarioDAO();
/* 140:143 */       gruposUsuarioDAO.setServerNumber(this.serverNumber);
/* 141:144 */       GruposUsuario grupoUsuarioABorrar = new GruposUsuario();
/* 142:145 */       grupoUsuarioABorrar.setGrupu_cod(IGrupos.FAMILY_VACUNAS);
/* 143:146 */       grupoUsuarioABorrar.setGrupu_usuf_cod(usuf_cod);
/* 144:147 */       gruposUsuarioDAO.delete(grupoUsuarioABorrar, conn);
/* 145:149 */       if (!manejado) {
/* 146:150 */         conn.commit();
/* 147:    */       }
/* 148:    */     }
/* 149:    */     catch (Exception e)
/* 150:    */     {
/* 151:154 */       if (!manejado) {
/* 152:155 */         rollback(conn);
/* 153:    */       }
/* 154:157 */       throw e;
/* 155:    */     }
/* 156:    */     finally
/* 157:    */     {
/* 158:159 */       if (!manejado) {
/* 159:160 */         close(conn);
/* 160:    */       }
/* 161:    */     }
/* 162:    */   }
/* 163:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.sdfamily.dao.VacunasCompletoDAO
 * JD-Core Version:    0.7.0.1
 */