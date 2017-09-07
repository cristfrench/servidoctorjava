/*  1:   */ package com.servidoctor.util.classes;
/*  2:   */ 
/*  3:   */ import java.util.Enumeration;
/*  4:   */ import javax.servlet.http.HttpSession;
/*  5:   */ 
/*  6:   */ public class BorrarSession
/*  7:   */ {
/*  8:   */   public static void eliminaAtributos(HttpSession session, String nombreForm)
/*  9:   */   {
/* 10:11 */     Enumeration totalAtributos = session.getAttributeNames();
/* 11:12 */     while (totalAtributos.hasMoreElements())
/* 12:   */     {
/* 13:13 */       String nombreAtributo = (String)totalAtributos.nextElement();
/* 14:14 */       if ((!nombreAtributo.equals("servidor")) && (!nombreAtributo.equals("vehiculo")) && (!nombreAtributo.equals("usuarioCar")) && (!nombreAtributo.equals("mascota")) && (!nombreAtributo.equals("usuarioPets")) && (!nombreAtributo.equals("idioma")) && (!nombreAtributo.equals("logo")) && (!nombreAtributo.equals("datosPersonales")) && (!nombreAtributo.equals("usuarioFamily")) && (!nombreAtributo.equals("sysname")) && (!nombreAtributo.equals("org.apache.struts.action.LOCALE")) && (!nombreAtributo.equals(nombreForm)) && (!nombreAtributo.equals("soloLectura"))) {
/* 15:15 */         session.removeAttribute(nombreAtributo);
/* 16:   */       }
/* 17:   */     }
/* 18:   */   }
/* 19:   */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.util.classes.BorrarSession
 * JD-Core Version:    0.7.0.1
 */