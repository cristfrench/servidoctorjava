/*   1:    */ package com.essecorp.util;
/*   2:    */ 
/*   3:    */ import com.essecorp.date.util.GestorFechas;
/*   4:    */ import java.text.ParseException;
/*   5:    */ import java.text.SimpleDateFormat;
/*   6:    */ import java.util.Calendar;
/*   7:    */ import java.util.Date;
/*   8:    */ import java.util.GregorianCalendar;
/*   9:    */ 
/*  10:    */ public class GestorFechasCompleto
/*  11:    */   extends GestorFechas
/*  12:    */ {
/*  13:    */   public static final String PRESENTABLE = "EEEEEEEE, dd 'de' MMMMMMMM yyyy 'a las' HH:mm";
/*  14:    */   public static final String YYYYMMDDHHMM = "yyyyMMddHHmm";
/*  15:    */   
/*  16:    */   public static int restaFechas(String fechaIni, String fechaFin, String formato)
/*  17:    */   {
/*  18:    */     try
/*  19:    */     {
/*  20: 33 */       SimpleDateFormat sdf = new SimpleDateFormat(formato);
/*  21: 34 */       Date date1 = sdf.parse(fechaIni);
/*  22: 35 */       Date date2 = sdf.parse(fechaFin);
/*  23: 36 */       long mills = date2.getTime() - date1.getTime();
/*  24: 37 */       return (int)(mills / 86400000L);
/*  25:    */     }
/*  26:    */     catch (ParseException e) {}
/*  27: 39 */     return 0;
/*  28:    */   }
/*  29:    */   
/*  30:    */   public static String fechaMasDias(String fechaIni, String formato, int dias)
/*  31:    */   {
/*  32:    */     try
/*  33:    */     {
/*  34: 53 */       SimpleDateFormat sdf = new SimpleDateFormat(formato);
/*  35: 54 */       Date date = sdf.parse(fechaIni);
/*  36: 55 */       Calendar cal = new GregorianCalendar();
/*  37: 56 */       cal.setTime(date);
/*  38: 57 */       cal.add(5, dias);
/*  39: 58 */       return sdf.format(new Date(cal.getTime().getTime()));
/*  40:    */     }
/*  41:    */     catch (ParseException e) {}
/*  42: 60 */     return fechaIni;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public static String fechaMasMeses(String fechaIni, String formato, int meses)
/*  46:    */   {
/*  47:    */     try
/*  48:    */     {
/*  49: 74 */       SimpleDateFormat sdf = new SimpleDateFormat(formato);
/*  50: 75 */       Date date = sdf.parse(fechaIni);
/*  51: 76 */       Calendar cal = new GregorianCalendar();
/*  52: 77 */       cal.setTime(date);
/*  53: 78 */       cal.add(2, meses);
/*  54: 79 */       return sdf.format(new Date(cal.getTime().getTime()));
/*  55:    */     }
/*  56:    */     catch (ParseException e) {}
/*  57: 81 */     return fechaIni;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public static String formatoFecha(String fecha, String formatoIni, String formatoFin)
/*  61:    */   {
/*  62:    */     try
/*  63:    */     {
/*  64: 95 */       SimpleDateFormat sdf = new SimpleDateFormat(formatoIni);
/*  65: 96 */       Date date = sdf.parse(fecha);
/*  66: 97 */       Calendar cal = new GregorianCalendar();
/*  67: 98 */       cal.setTime(date);
/*  68: 99 */       sdf.applyPattern(formatoFin);
/*  69:100 */       return sdf.format(date);
/*  70:    */     }
/*  71:    */     catch (ParseException e) {}
/*  72:102 */     return fecha;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public static String formatoAMPM(String hora)
/*  76:    */   {
/*  77:    */     try
/*  78:    */     {
/*  79:116 */       String horario = hora.substring(5, hora.length());
/*  80:117 */       if (horario.equals("01")) {
/*  81:118 */         return "PM";
/*  82:    */       }
/*  83:120 */       return "AM";
/*  84:    */     }
/*  85:    */     catch (Exception e) {}
/*  86:123 */     return "AM";
/*  87:    */   }
/*  88:    */   
/*  89:    */   public static long convertStringToLong(String pFecha, String pFormat)
/*  90:    */     throws ParseException
/*  91:    */   {
/*  92:128 */     SimpleDateFormat sdf = new SimpleDateFormat(pFormat);
/*  93:129 */     sdf.setCalendar(Calendar.getInstance());
/*  94:130 */     Date d = sdf.parse(pFecha);
/*  95:131 */     return d.getTime();
/*  96:    */   }
/*  97:    */   
/*  98:    */   public static String getChangeFecha(String fecha)
/*  99:    */   {
/* 100:    */     try
/* 101:    */     {
/* 102:136 */       if (fecha != null) {
/* 103:137 */         if ((!fecha.equals("")) && (fecha.length() == 10))
/* 104:    */         {
/* 105:142 */           String ano = fecha.substring(0, 4);
/* 106:143 */           String mes = fecha.substring(5, 7);
/* 107:144 */           String dia = fecha.substring(8, 10);
/* 108:145 */           fecha = ano + mes + dia;
/* 109:    */         }
/* 110:146 */         else if ((!fecha.equals("")) && (fecha.length() == 7))
/* 111:    */         {
/* 112:151 */           String ano = fecha.substring(0, 4);
/* 113:152 */           String mes = fecha.substring(5, 7);
/* 114:    */           
/* 115:154 */           fecha = ano + mes;
/* 116:    */         }
/* 117:    */         else
/* 118:    */         {
/* 119:156 */           return fecha;
/* 120:    */         }
/* 121:    */       }
/* 122:    */     }
/* 123:    */     catch (Exception e)
/* 124:    */     {
/* 125:160 */       return fecha;
/* 126:    */     }
/* 127:163 */     return fecha;
/* 128:    */   }
/* 129:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.essecorp.util.GestorFechasCompleto
 * JD-Core Version:    0.7.0.1
 */