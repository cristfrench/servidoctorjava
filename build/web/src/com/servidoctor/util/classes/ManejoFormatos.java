/*   1:    */ package com.servidoctor.util.classes;
/*   2:    */ 
/*   3:    */ import java.math.BigDecimal;
/*   4:    */ import java.text.NumberFormat;
/*   5:    */ import java.text.ParseException;
/*   6:    */ 
/*   7:    */ public class ManejoFormatos
/*   8:    */ {
/*   9:    */   public static BigDecimal quitarFormato(String str)
/*  10:    */     throws Exception
/*  11:    */   {
/*  12:    */     try
/*  13:    */     {
/*  14: 11 */       NumberFormat num = NumberFormat.getInstance();
/*  15: 12 */       Number numf = num.parse(str);
/*  16: 13 */       return new BigDecimal(numf.doubleValue());
/*  17:    */     }
/*  18:    */     catch (ParseException e)
/*  19:    */     {
/*  20: 16 */       Exception ex = new Exception("Debe digitar un número");
/*  21: 17 */       throw ex;
/*  22:    */     }
/*  23:    */   }
/*  24:    */   
/*  25:    */   public static String quitarFormatonit(String str)
/*  26:    */     throws Exception
/*  27:    */   {
/*  28:    */     try
/*  29:    */     {
/*  30: 23 */       String n = null;
/*  31: 25 */       if (str.trim().length() > 10)
/*  32:    */       {
/*  33: 26 */         int a = str.indexOf("-");
/*  34: 28 */         if (a > 0)
/*  35:    */         {
/*  36: 29 */           String b = str.substring(0, a);
/*  37: 30 */           BigDecimal nit = quitarFormato(b);
/*  38: 31 */           n = nit.toString() + str.substring(a + 1, str.length());
/*  39:    */         }
/*  40:    */         else
/*  41:    */         {
/*  42: 33 */           n = quitarFormato(str).toString();
/*  43:    */         }
/*  44:    */       }
/*  45: 37 */       return quitarFormato(str).toString();
/*  46:    */     }
/*  47:    */     catch (ParseException e)
/*  48:    */     {
/*  49: 41 */       Exception ex = new Exception("Debe digitar un número");
/*  50: 42 */       throw ex;
/*  51:    */     }
/*  52:    */   }
/*  53:    */   
/*  54:    */   public static String formatoValor(String str)
/*  55:    */   {
/*  56: 46 */     String nit = null;
/*  57: 47 */     if (str.equals(null)) {
/*  58: 48 */       nit = "";
/*  59:    */     } else {
/*  60:    */       try
/*  61:    */       {
/*  62: 51 */         NumberFormat num = NumberFormat.getInstance();
/*  63: 52 */         String parte1 = null;
/*  64: 53 */         nit = num.format(Long.parseLong(str));
/*  65:    */       }
/*  66:    */       catch (Exception e)
/*  67:    */       {
/*  68: 55 */         nit = str + " error";
/*  69:    */       }
/*  70:    */     }
/*  71: 59 */     return nit;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public static String formatoNit(String str)
/*  75:    */   {
/*  76: 63 */     String nit = null;
/*  77: 64 */     if (str.equals(null)) {
/*  78: 65 */       nit = "";
/*  79:    */     } else {
/*  80:    */       try
/*  81:    */       {
/*  82: 68 */         NumberFormat num = NumberFormat.getInstance();
/*  83: 69 */         String parte1 = null;
/*  84: 70 */         String parte2 = null;
/*  85: 71 */         if (str.trim().length() > 8)
/*  86:    */         {
/*  87: 72 */           parte1 = str.substring(0, str.length() - 1);
/*  88: 73 */           parte2 = str.substring(str.length() - 1, str.length());
/*  89: 74 */           nit = num.format(Long.parseLong(parte1)) + "-" + parte2;
/*  90:    */         }
/*  91:    */         else
/*  92:    */         {
/*  93: 76 */           nit = num.format(Long.parseLong(str));
/*  94:    */         }
/*  95:    */       }
/*  96:    */       catch (Exception e)
/*  97:    */       {
/*  98: 81 */         nit = str + " error";
/*  99:    */       }
/* 100:    */     }
/* 101: 85 */     return nit;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public static String formatoFecha(String str)
/* 105:    */   {
/* 106:    */     try
/* 107:    */     {
/* 108: 91 */       String parte1 = null;
/* 109: 92 */       String parte2 = null;
/* 110: 93 */       String parte3 = null;
/* 111: 94 */       parte1 = str.substring(0, 4);
/* 112: 95 */       parte2 = str.substring(4, 6);
/* 113: 96 */       parte3 = str.substring(6, 8);
/* 114: 97 */       if (parte2.trim().equals("01")) {
/* 115: 98 */         parte2 = "Enero";
/* 116:    */       }
/* 117:100 */       if (parte2.trim().equals("02")) {
/* 118:101 */         parte2 = "Febrero";
/* 119:    */       }
/* 120:103 */       if (parte2.trim().equals("03")) {
/* 121:104 */         parte2 = "Marzo";
/* 122:    */       }
/* 123:106 */       if (parte2.trim().equals("04")) {
/* 124:107 */         parte2 = "Abril";
/* 125:    */       }
/* 126:109 */       if (parte2.trim().equals("05")) {
/* 127:110 */         parte2 = "Mayo";
/* 128:    */       }
/* 129:112 */       if (parte2.trim().equals("06")) {
/* 130:113 */         parte2 = "Junio";
/* 131:    */       }
/* 132:115 */       if (parte2.trim().equals("07")) {
/* 133:116 */         parte2 = "Julio";
/* 134:    */       }
/* 135:118 */       if (parte2.trim().equals("08")) {
/* 136:119 */         parte2 = "Agosto";
/* 137:    */       }
/* 138:121 */       if (parte2.trim().equals("09")) {
/* 139:122 */         parte2 = "Septiembre";
/* 140:    */       }
/* 141:124 */       if (parte2.trim().equals("10")) {
/* 142:125 */         parte2 = "Octubre";
/* 143:    */       }
/* 144:127 */       if (parte2.trim().equals("11")) {
/* 145:128 */         parte2 = "Noviembre";
/* 146:    */       }
/* 147:130 */       if (parte2.trim().equals("12")) {
/* 148:131 */         parte2 = "Diciembre";
/* 149:    */       }
/* 150:134 */       str = parte2 + " " + parte3 + " de " + parte1;
/* 151:    */     }
/* 152:    */     catch (Exception localException) {}
/* 153:140 */     return str;
/* 154:    */   }
/* 155:    */   
/* 156:    */   public static BigDecimal quitarFormatoFechaL(String str)
/* 157:    */     throws Exception
/* 158:    */   {
/* 159:    */     try
/* 160:    */     {
/* 161:145 */       String parte1 = null;
/* 162:146 */       String parte2 = null;
/* 163:147 */       String parte3 = null;
/* 164:    */       
/* 165:149 */       parte2 = str.substring(0, 3).trim();
/* 166:150 */       parte1 = str.substring(5, 7);
/* 167:151 */       parte3 = str.substring(11, 15);
/* 168:153 */       if (parte2.trim().equals("Ene")) {
/* 169:154 */         parte2 = "01";
/* 170:    */       }
/* 171:156 */       if (parte2.trim().equals("Feb")) {
/* 172:157 */         parte2 = "02";
/* 173:    */       }
/* 174:159 */       if (parte2.trim().equals("Mar")) {
/* 175:160 */         parte2 = "03";
/* 176:    */       }
/* 177:162 */       if (parte2.trim().equals("Abr")) {
/* 178:163 */         parte2 = "04";
/* 179:    */       }
/* 180:165 */       if (parte2.trim().equals("May")) {
/* 181:166 */         parte2 = "05";
/* 182:    */       }
/* 183:168 */       if (parte2.trim().equals("Jun")) {
/* 184:169 */         parte2 = "06";
/* 185:    */       }
/* 186:171 */       if (parte2.trim().equals("Jul")) {
/* 187:172 */         parte2 = "07";
/* 188:    */       }
/* 189:174 */       if (parte2.trim().equals("Ago")) {
/* 190:175 */         parte2 = "08";
/* 191:    */       }
/* 192:177 */       if (parte2.trim().equals("Sep")) {
/* 193:178 */         parte2 = "09";
/* 194:    */       }
/* 195:180 */       if (parte2.trim().equals("Oct")) {
/* 196:181 */         parte2 = "10";
/* 197:    */       }
/* 198:183 */       if (parte2.trim().equals("Nov")) {
/* 199:184 */         parte2 = "11";
/* 200:    */       }
/* 201:186 */       if (parte2.trim().equals("Dic")) {
/* 202:187 */         parte2 = "12";
/* 203:    */       }
/* 204:190 */       str = parte3 + parte2 + parte1;
/* 205:    */     }
/* 206:    */     catch (Exception localException) {}
/* 207:196 */     return new BigDecimal(str);
/* 208:    */   }
/* 209:    */   
/* 210:    */   public static String armarFecha(String ano, String mes, String dia)
/* 211:    */     throws Exception
/* 212:    */   {
/* 213:    */     try
/* 214:    */     {
/* 215:202 */       String fecha = null;
/* 216:    */       
/* 217:204 */       fecha = ano + "    ";
/* 218:205 */       fecha = fecha.substring(0, 4);
/* 219:206 */       fecha = fecha + mes + "  ";
/* 220:207 */       fecha = fecha.substring(0, 6);
/* 221:208 */       fecha = fecha + dia + "  ";
/* 222:209 */       return fecha.substring(0, 8);
/* 223:    */     }
/* 224:    */     catch (Exception ex)
/* 225:    */     {
/* 226:212 */       throw ex;
/* 227:    */     }
/* 228:    */   }
/* 229:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.util.classes.ManejoFormatos
 * JD-Core Version:    0.7.0.1
 */