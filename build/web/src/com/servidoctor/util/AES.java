/*   1:    */ package com.servidoctor.util;
/*   2:    */ 
/*   3:    */ import com.sun.crypto.provider.SunJCE;
/*   4:    */ import java.io.PrintStream;
/*   5:    */ import java.security.Key;
/*   6:    */ import java.security.Security;
/*   7:    */ import java.util.Scanner;
/*   8:    */ import java.util.StringTokenizer;
/*   9:    */ import javax.crypto.Cipher;
/*  10:    */ import javax.crypto.spec.IvParameterSpec;
/*  11:    */ import javax.crypto.spec.SecretKeySpec;
/*  12:    */ 
/*  13:    */ public class AES
/*  14:    */ {
/*  15: 18 */   private Cipher cipher = null;
/*  16: 19 */   private static String algoritmo = "AES/CBC/PKCS5Padding";
/*  17: 20 */   private static Key key = null;
/*  18:    */   private static String provider;
/*  19:    */   
/*  20:    */   static
/*  21:    */   {
/*  22:    */     try
/*  23:    */     {
/*  24: 26 */       Security.addProvider(new SunJCE());
/*  25: 27 */       provider = "SunJCE";
/*  26:    */       
/*  27: 29 */       byte[] ps = "ADRZ1_ADRZ1_ADRZ".getBytes();
/*  28: 30 */       key = new SecretKeySpec(ps, "AES");
/*  29:    */     }
/*  30:    */     catch (Exception e)
/*  31:    */     {
/*  32: 32 */       e.printStackTrace();
/*  33:    */     }
/*  34:    */   }
/*  35:    */   
/*  36:    */   public AES()
/*  37:    */   {
/*  38:    */     try
/*  39:    */     {
/*  40: 38 */       this.cipher = Cipher.getInstance(algoritmo, provider);
/*  41:    */     }
/*  42:    */     catch (Exception e)
/*  43:    */     {
/*  44: 40 */       e.printStackTrace();
/*  45:    */     }
/*  46:    */   }
/*  47:    */   
/*  48:    */   public String encrypt(String pDato)
/*  49:    */   {
/*  50: 45 */     byte[] ciphertext = (byte[])null;
/*  51:    */     try
/*  52:    */     {
/*  53: 47 */       this.cipher.init(1, key, new IvParameterSpec("0123456701234567".getBytes("ASCII")));
/*  54: 48 */       ciphertext = this.cipher.doFinal(pDato.getBytes());
/*  55:    */     }
/*  56:    */     catch (Exception e)
/*  57:    */     {
/*  58: 51 */       e.printStackTrace();
/*  59:    */     }
/*  60: 53 */     return bytesToString(ciphertext);
/*  61:    */   }
/*  62:    */   
/*  63:    */   public String decrypt(String pDato)
/*  64:    */   {
/*  65: 57 */     byte[] decryptedText = (byte[])null;
/*  66:    */     try
/*  67:    */     {
/*  68: 59 */       this.cipher.init(2, key, new IvParameterSpec("0123456701234567".getBytes("ASCII")));
/*  69: 60 */       decryptedText = this.cipher.doFinal(stringToBytes(pDato));
/*  70:    */     }
/*  71:    */     catch (Exception e)
/*  72:    */     {
/*  73: 63 */       e.printStackTrace();
/*  74:    */     }
/*  75: 65 */     return new String(decryptedText);
/*  76:    */   }
/*  77:    */   
/*  78:    */   private String bytesToString(byte[] pDato)
/*  79:    */   {
/*  80: 71 */     StringBuilder temp = new StringBuilder();
/*  81: 72 */     for (byte b : pDato) {
/*  82: 73 */       temp.append(b).append(',');
/*  83:    */     }
/*  84: 75 */     stringToBytes(temp.toString());
/*  85: 76 */     return temp.toString();
/*  86:    */   }
/*  87:    */   
/*  88:    */   private byte[] stringToBytes(String pDato)
/*  89:    */   {
/*  90: 80 */     byte[] temp = (byte[])null;
/*  91: 81 */     StringTokenizer st = new StringTokenizer(pDato, ",");
/*  92: 82 */     temp = new byte[st.countTokens()];
/*  93: 83 */     for (int i = 0; st.hasMoreTokens(); i++) {
/*  94: 84 */       temp[i] = Byte.parseByte(st.nextToken());
/*  95:    */     }
/*  96: 86 */     return temp;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public static void main(String[] args)
/* 100:    */   {
/* 101: 90 */     Scanner scanner = new Scanner(System.in);
/* 102: 91 */     System.out.println("Ingrese datos para probar");
/* 103: 92 */     int numeroPruebas = scanner.nextInt();
/* 104: 93 */     scanner.nextLine();
/* 105: 94 */     System.out.println("Pruebas a correr: " + numeroPruebas);
/* 106: 95 */     boolean error = false;
/* 107: 96 */     int maxLength = 0;
/* 108: 97 */     for (int i = 0; i < numeroPruebas; i++)
/* 109:    */     {
/* 110: 98 */       String entrada = scanner.nextLine();
/* 111: 99 */       AES a = new AES();
/* 112:100 */       String datoEncriptado = a.encrypt(entrada);
/* 113:101 */       System.out.print(entrada);
/* 114:102 */       System.out.print("--> Longitud " + datoEncriptado.length() + "-->");
/* 115:103 */       System.out.print(datoEncriptado);
/* 116:104 */       String dato = a.decrypt(datoEncriptado);
/* 117:105 */       if (dato.equals(entrada))
/* 118:    */       {
/* 119:106 */         if (datoEncriptado.length() > maxLength) {
/* 120:107 */           maxLength = datoEncriptado.length();
/* 121:    */         }
/* 122:109 */         System.out.println("-->: OK");
/* 123:    */       }
/* 124:    */       else
/* 125:    */       {
/* 126:111 */         System.out.println("-->: ERROR");
/* 127:112 */         error = true;
/* 128:    */       }
/* 129:    */     }
/* 130:115 */     System.out.println("Resultado-->" + (error ? "ERROR" : "OK"));
/* 131:116 */     System.out.println("Longitud máxima-->" + maxLength);
/* 132:    */   }
/* 133:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.util.AES
 * JD-Core Version:    0.7.0.1
 */