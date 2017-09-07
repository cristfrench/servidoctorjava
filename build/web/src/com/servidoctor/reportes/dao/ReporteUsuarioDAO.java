/*   1:    */ package com.servidoctor.reportes.dao;
/*   2:    */ 
/*   3:    */ import com.servidoctor.common.dao.DAO;
/*   4:    */ import com.servidoctor.reportes.model.ReporteUsuario;
/*   5:    */ import com.servidoctor.sdfamily.dao.CasoEmergenciaDAO;
/*   6:    */ import com.servidoctor.sdfamily.dao.SeguroMedicoDAO;
/*   7:    */ import com.servidoctor.sdfamily.dao.UsuarioParentDAO;
/*   8:    */ import com.servidoctor.sdfamily.model.UsuarioParent;
/*   9:    */ import com.servidoctor.util.classes.DBUtil;
/*  10:    */ import com.servidoctor.util.classes.InicializaData;
/*  11:    */ import java.io.PrintStream;
/*  12:    */ import java.sql.Connection;
/*  13:    */ import java.sql.PreparedStatement;
/*  14:    */ import java.sql.ResultSet;
/*  15:    */ import java.sql.SQLException;
/*  16:    */ import java.util.ArrayList;
/*  17:    */ import java.util.HashMap;
/*  18:    */ import java.util.List;
/*  19:    */ import java.util.Map;
/*  20:    */ import javax.sql.DataSource;
/*  21:    */ 
/*  22:    */ public class ReporteUsuarioDAO
/*  23:    */   extends DAO
/*  24:    */ {
/*  25:    */   public List retrive(ReporteUsuario reporteUsuario, String[] conditions)
/*  26:    */     throws SQLException
/*  27:    */   {
/*  28: 33 */     Map datos = new HashMap();
/*  29: 34 */     List reporte = new ArrayList();
/*  30: 35 */     Connection conn = null;
/*  31: 36 */     PreparedStatement pstmt = null;
/*  32: 37 */     ResultSet rs = null;
/*  33: 38 */     ReporteUsuario reporteUsuarioS = new ReporteUsuario();
/*  34:    */     
/*  35: 40 */     CasoEmergenciaDAO casoEmergenciaDAO = new CasoEmergenciaDAO();
/*  36: 41 */     UsuarioParentDAO usuarioParentDAO = new UsuarioParentDAO();
/*  37: 42 */     SeguroMedicoDAO seguroMedicoDAO = new SeguroMedicoDAO();
/*  38:    */     try
/*  39:    */     {
/*  40: 45 */       conn = this.ds.getConnection();
/*  41: 46 */       DBUtil db = new DBUtil();
/*  42: 47 */       String sql = db.creaSQLSELECT(reporteUsuarioS);
/*  43: 48 */       String join = " ";
/*  44: 49 */       String where = " where ";
/*  45: 50 */       if (reporteUsuario.getNombres().length() > 0) {
/*  46: 51 */         where = where + " reporteusuario.nombres like ('%" + reporteUsuario.getNombres() + "%') and ";
/*  47:    */       }
/*  48: 53 */       if (reporteUsuario.getApellido().length() > 0) {
/*  49: 54 */         where = where + " reporteusuario.apellido like ('%" + reporteUsuario.getApellido() + "%') and ";
/*  50:    */       }
/*  51: 56 */       if (reporteUsuario.getPais().length() > 0) {
/*  52: 57 */         where = where + " reporteusuario.pais like ('%" + reporteUsuario.getPais() + "%') and ";
/*  53:    */       }
/*  54: 59 */       if (reporteUsuario.getId_doc_si().length() > 0) {
/*  55: 60 */         where = where + " reporteusuario.id_doc_si like ('%" + reporteUsuario.getId_doc_si() + "%') and ";
/*  56:    */       }
/*  57: 62 */       if (reporteUsuario.getIdentificadores().length() > 0) {
/*  58: 63 */         where = where + " reporteusuario.identificadores like ('%" + reporteUsuario.getIdentificadores() + "%') and ";
/*  59:    */       }
/*  60: 65 */       if (conditions[0].length() > 0)
/*  61:    */       {
/*  62: 66 */         join = join + "join SDOCTOR.usuarioenfermedades on SDOCTOR.reporteusuario.usu_cod = SDOCTOR.usuarioenfermedades.uenf_usu_cod";
/*  63: 67 */         where = where + " usuarioenfermedades.uenf_posee like ('%" + conditions[0] + "%') and ";
/*  64:    */       }
/*  65: 69 */       if (conditions[1].length() > 0)
/*  66:    */       {
/*  67: 70 */         join = join + "join SDOCTOR.usuarioalergias on SDOCTOR.reporteusuario.usu_cod = SDOCTOR.usuarioalergias.uale_usu_cod";
/*  68: 71 */         where = where + " (usuarioalergias.uale_alergia_spa like ('%" + conditions[1] + "%') or usuarioalergias.uale_alergia_eng like ('%" + conditions[1] + "%')) and ";
/*  69:    */       }
/*  70: 73 */       if (conditions[2].length() > 0)
/*  71:    */       {
/*  72: 74 */         join = join + "join SDOCTOR.usuariocirujias on SDOCTOR.reporteusuario.usu_cod = SDOCTOR.usuariocirujias.ucir_usu_cod";
/*  73: 75 */         where = where + " usuariocirujias.operado like ('%" + conditions[2] + "%') and ";
/*  74:    */       }
/*  75: 77 */       if (conditions[3].length() > 0)
/*  76:    */       {
/*  77: 78 */         join = join + "join SDOCTOR.usuarioexamenes on SDOCTOR.reporteusuario.usu_cod = SDOCTOR.usuarioexamenes.exa_usu_cod";
/*  78: 79 */         where = where + " usuarioexamenes.exa_des like ('%" + conditions[3] + "%') and ";
/*  79:    */       }
/*  80: 81 */       if (conditions[4].length() > 0)
/*  81:    */       {
/*  82: 82 */         join = join + "join SDOCTOR.usuarioconoptom on SDOCTOR.reporteusuario.usu_cod = SDOCTOR.usuarioconoptom.ucop_usu_cod";
/*  83: 83 */         where = where + " usuarioconoptom.ucop_nommedico like ('%" + conditions[4] + "%') and ";
/*  84:    */       }
/*  85: 85 */       if (conditions[5].length() > 0)
/*  86:    */       {
/*  87: 86 */         join = join + "join SDOCTOR.UsuarioConOdon on SDOCTOR.reporteusuario.usu_cod = SDOCTOR.UsuarioConOdon.ucod_usu_cod";
/*  88: 87 */         where = where + " UsuarioConOdon.ucod_destratamiento like ('%" + conditions[5] + "%') and ";
/*  89:    */       }
/*  90: 89 */       if (conditions[6].length() > 0)
/*  91:    */       {
/*  92: 90 */         join = join + "join SDOCTOR.Vacunas on SDOCTOR.reporteusuario.usu_cod = SDOCTOR.Vacunas.uvac_usu_cod";
/*  93: 91 */         where = where + " Vacunas.uvac_des like ('%" + conditions[6] + "%') and ";
/*  94:    */       }
/*  95: 93 */       if ((conditions[8].length() > 0) && (conditions[9].length() > 0)) {
/*  96: 95 */         where = where + " fecha_registro between " + conditions[8] + " and " + conditions[9] + " and ";
/*  97:    */       }
/*  98: 97 */       where = where.substring(0, where.length() - 4);
/*  99:    */       
/* 100: 99 */       sql = sql.substring(0, 6) + " distinct " + sql.substring(7, sql.length());
/* 101:101 */       if (join.length() > 1) {
/* 102:102 */         sql = sql + join;
/* 103:    */       }
/* 104:104 */       if (where.length() > 7)
/* 105:    */       {
/* 106:105 */         pstmt = conn.prepareStatement(sql + where + conditions[7]);
/* 107:106 */         System.out.println("ejecutando: " + sql + where + conditions[7]);
/* 108:    */       }
/* 109:    */       else
/* 110:    */       {
/* 111:108 */         pstmt = conn.prepareStatement(sql + conditions[7]);
/* 112:109 */         System.out.println("ejecutando: " + sql + conditions[7]);
/* 113:    */       }
/* 114:113 */       rs = pstmt.executeQuery();
/* 115:114 */       while (rs.next())
/* 116:    */       {
/* 117:115 */         ReporteUsuario reporteUsuarioSS = new ReporteUsuario();
/* 118:116 */         InicializaData.inicializa(reporteUsuarioSS.getClass(), reporteUsuarioSS);
/* 119:117 */         populate(reporteUsuarioSS, rs);
/* 120:118 */         datos.put("datos", reporteUsuarioSS);
/* 121:    */         
/* 122:120 */         List contactos = new ArrayList();
/* 123:121 */         List seguros = new ArrayList();
/* 124:122 */         UsuarioParent usuarioParent = usuarioParentDAO.retrieve(reporteUsuarioSS.getUsu_cod());
/* 125:123 */         contactos = casoEmergenciaDAO.list(reporteUsuarioSS.getUsu_cod());
/* 126:124 */         seguros = seguroMedicoDAO.list(reporteUsuarioSS.getUsu_cod());
/* 127:    */         
/* 128:    */ 
/* 129:127 */         datos.put("contactos", contactos);
/* 130:128 */         datos.put("seguros", seguros);
/* 131:129 */         datos.put("pariente", usuarioParent);
/* 132:    */         
/* 133:    */ 
/* 134:132 */         reporte.add(datos);
/* 135:    */       }
/* 136:134 */       close(rs);
/* 137:135 */       close(pstmt);
/* 138:    */     }
/* 139:    */     catch (SQLException e)
/* 140:    */     {
/* 141:138 */       close(rs);
/* 142:139 */       close(pstmt);
/* 143:140 */       rollback(conn);
/* 144:141 */       e.printStackTrace();
/* 145:    */     }
/* 146:    */     finally
/* 147:    */     {
/* 148:143 */       close(conn);
/* 149:    */     }
/* 150:145 */     return reporte;
/* 151:    */   }
/* 152:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.reportes.dao.ReporteUsuarioDAO
 * JD-Core Version:    0.7.0.1
 */