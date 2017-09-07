/*   1:    */ package com.essecorp.util;
/*   2:    */ 
/*   3:    */ import java.io.PrintStream;
/*   4:    */ import java.util.Date;
/*   5:    */ import java.util.Properties;
/*   6:    */ import javax.mail.Message;
/*   7:    */ import javax.mail.Message.RecipientType;
/*   8:    */ import javax.mail.Session;
/*   9:    */ import javax.mail.Transport;
/*  10:    */ import javax.mail.internet.InternetAddress;
/*  11:    */ import javax.mail.internet.MimeMessage;
/*  12:    */ import javax.naming.Context;
/*  13:    */ import javax.naming.InitialContext;
/*  14:    */ import org.apache.struts.util.MessageResources;
/*  15:    */ 
/*  16:    */ public class GestorCorreoSD
/*  17:    */ {
/*  18: 29 */   private static String server = null;
/*  19: 30 */   private static String user = null;
/*  20: 31 */   private static String password = null;
/*  21: 32 */   private static String from = null;
/*  22: 33 */   private static String to = null;
/*  23: 34 */   private static String cc = null;
/*  24: 35 */   private static String bcc = null;
/*  25: 36 */   private static String subject = null;
/*  26: 37 */   private static StringBuffer contents = null;
/*  27: 38 */   private static boolean DEBUG = false;
/*  28: 39 */   private static boolean AUTH = false;
/*  29: 41 */   private static MessageResources RESOURCES = MessageResources.getMessageResources("com.servidoctor.resources.MailManager");
/*  30: 42 */   private static Session session = null;
/*  31:    */   
/*  32:    */   public static void setContents(String title, String header, String msg, String footer)
/*  33:    */   {
/*  34: 53 */     contents = new StringBuffer(RESOURCES.getMessage("mail.contents.part1"));
/*  35: 54 */     if ((title != null) && (!title.equals(""))) {
/*  36: 55 */       contents.append(title);
/*  37:    */     } else {
/*  38: 57 */       contents.append(RESOURCES.getMessage("mail.contents.title"));
/*  39:    */     }
/*  40: 59 */     contents.append(RESOURCES.getMessage("mail.contents.part2"));
/*  41: 60 */     if ((header != null) && (!header.equals(""))) {
/*  42: 61 */       contents.append(header);
/*  43:    */     } else {
/*  44: 63 */       contents.append(RESOURCES.getMessage("mail.contents.title"));
/*  45:    */     }
/*  46: 66 */     contents.append(RESOURCES.getMessage("mail.contents.part3"));
/*  47: 67 */     contents.append(RESOURCES.getMessage("mail.contents.left"));
/*  48: 68 */     contents.append(RESOURCES.getMessage("mail.contents.part4"));
/*  49: 69 */     if ((msg != null) && (!msg.equals(""))) {
/*  50: 70 */       contents.append(msg);
/*  51:    */     } else {
/*  52: 72 */       contents.append(RESOURCES.getMessage("mail.contents.msg"));
/*  53:    */     }
/*  54: 74 */     contents.append(RESOURCES.getMessage("mail.contents.part5"));
/*  55: 75 */     contents.append(RESOURCES.getMessage("mail.contents.right"));
/*  56: 76 */     contents.append(RESOURCES.getMessage("mail.contents.part6"));
/*  57: 77 */     if ((footer != null) && (!footer.equals(""))) {
/*  58: 78 */       contents.append(footer);
/*  59:    */     } else {
/*  60: 80 */       contents.append(RESOURCES.getMessage("mail.contents.footer"));
/*  61:    */     }
/*  62: 83 */     contents.append(RESOURCES.getMessage("mail.contents.part7"));
/*  63:    */   }
/*  64:    */   
/*  65:    */   public static final void enviarCorreo()
/*  66:    */     throws Exception
/*  67:    */   {
/*  68:    */     try
/*  69:    */     {
/*  70: 94 */       if (subject == null) {
/*  71: 95 */         subject = RESOURCES.getMessage("mail.subject");
/*  72:    */       }
/*  73: 98 */       if (from == null) {
/*  74: 99 */         from = RESOURCES.getMessage("mail.from");
/*  75:    */       }
/*  76:102 */       if (to == null) {
/*  77:103 */         to = RESOURCES.getMessage("mail.to");
/*  78:    */       }
/*  79:106 */       if (cc == null) {
/*  80:107 */         cc = RESOURCES.getMessage("mail.cc");
/*  81:    */       }
/*  82:110 */       if (bcc == null) {
/*  83:111 */         bcc = RESOURCES.getMessage("mail.bcc");
/*  84:    */       }
/*  85:114 */       if (contents == null)
/*  86:    */       {
/*  87:115 */         contents = new StringBuffer(RESOURCES.getMessage("mail.contents.part1"));
/*  88:116 */         contents.append(RESOURCES.getMessage("mail.contents.title"));
/*  89:117 */         contents.append(RESOURCES.getMessage("mail.contents.part2"));
/*  90:118 */         contents.append(RESOURCES.getMessage("mail.contents.header"));
/*  91:119 */         contents.append(RESOURCES.getMessage("mail.contents.part3"));
/*  92:120 */         contents.append(RESOURCES.getMessage("mail.contents.left"));
/*  93:121 */         contents.append(RESOURCES.getMessage("mail.contents.part4"));
/*  94:122 */         contents.append(RESOURCES.getMessage("mail.contents.msg"));
/*  95:123 */         contents.append(RESOURCES.getMessage("mail.contents.part5"));
/*  96:124 */         contents.append(RESOURCES.getMessage("mail.contents.right"));
/*  97:125 */         contents.append(RESOURCES.getMessage("mail.contents.part6"));
/*  98:126 */         contents.append(RESOURCES.getMessage("mail.contents.footer"));
/*  99:127 */         contents.append(RESOURCES.getMessage("mail.contents.part7"));
/* 100:    */       }
/* 101:130 */       if (session == null) {
/* 102:131 */         obtenerSesionCorreo();
/* 103:    */       }
/* 104:134 */       Message msg = new MimeMessage(session);
/* 105:135 */       if (from.trim().length() > 0) {
/* 106:136 */         msg.setFrom(new InternetAddress(from));
/* 107:    */       } else {
/* 108:139 */         throw new Exception(RESOURCES.getMessage("mail.msg.nofrom"));
/* 109:    */       }
/* 110:142 */       if (to.trim().length() > 0) {
/* 111:143 */         msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
/* 112:    */       }
/* 113:145 */       if (cc.trim().length() > 0) {
/* 114:146 */         msg.setRecipient(Message.RecipientType.CC, new InternetAddress(cc));
/* 115:    */       }
/* 116:149 */       if (bcc.trim().length() > 0) {
/* 117:150 */         msg.setRecipient(Message.RecipientType.BCC, new InternetAddress(bcc));
/* 118:    */       }
/* 119:152 */       if (subject.trim().length() > 0) {
/* 120:153 */         msg.setSubject(subject);
/* 121:    */       }
/* 122:156 */       if ((to.trim().length() <= 0) && (cc.trim().length() <= 0) && (bcc.trim().length() <= 0)) {
/* 123:157 */         throw new Exception(RESOURCES.getMessage("mail.msg.notoccbcc"));
/* 124:    */       }
/* 125:160 */       msg.setContent(contents.toString(), "text/html");
/* 126:161 */       msg.setSentDate(new Date());
/* 127:162 */       System.out.println("Envio de correo: " + from.trim());
/* 128:163 */       Transport.send(msg);
/* 129:    */     }
/* 130:    */     catch (Exception e)
/* 131:    */     {
/* 132:166 */       throw e;
/* 133:    */     }
/* 134:    */   }
/* 135:    */   
/* 136:    */   private static final void obtenerSesionCorreo()
/* 137:    */     throws Exception
/* 138:    */   {
/* 139:    */     try
/* 140:    */     {
/* 141:177 */       if (RESOURCES.getMessage("mail.session.type").equalsIgnoreCase("jndi"))
/* 142:    */       {
/* 143:178 */         Context ctx = new InitialContext();
/* 144:179 */         session = (Session)ctx.lookup(RESOURCES.getMessage("jndi.mail.server"));
/* 145:    */       }
/* 146:    */       else
/* 147:    */       {
/* 148:182 */         Properties props = System.getProperties();
/* 149:183 */         props.put("mail.smtp.host", RESOURCES.getMessage("mail.server"));
/* 150:184 */         props.put("mail.smtp.user", RESOURCES.getMessage("mail.server.user"));
/* 151:    */       }
/* 152:    */     }
/* 153:    */     catch (Exception e)
/* 154:    */     {
/* 155:191 */       throw e;
/* 156:    */     }
/* 157:    */   }
/* 158:    */   
/* 159:    */   public static void main(String[] args) {}
/* 160:    */   
/* 161:    */   public static boolean isAUTH()
/* 162:    */   {
/* 163:209 */     return AUTH;
/* 164:    */   }
/* 165:    */   
/* 166:    */   public static String getBcc()
/* 167:    */   {
/* 168:216 */     return bcc;
/* 169:    */   }
/* 170:    */   
/* 171:    */   public static String getCc()
/* 172:    */   {
/* 173:223 */     return cc;
/* 174:    */   }
/* 175:    */   
/* 176:    */   public static StringBuffer getContents()
/* 177:    */   {
/* 178:230 */     return contents;
/* 179:    */   }
/* 180:    */   
/* 181:    */   public static boolean isDEBUG()
/* 182:    */   {
/* 183:237 */     return DEBUG;
/* 184:    */   }
/* 185:    */   
/* 186:    */   public static String getFrom()
/* 187:    */   {
/* 188:244 */     return from;
/* 189:    */   }
/* 190:    */   
/* 191:    */   public static String getPassword()
/* 192:    */   {
/* 193:251 */     return password;
/* 194:    */   }
/* 195:    */   
/* 196:    */   public static MessageResources getRESOURCES()
/* 197:    */   {
/* 198:258 */     return RESOURCES;
/* 199:    */   }
/* 200:    */   
/* 201:    */   public static String getServer()
/* 202:    */   {
/* 203:265 */     return server;
/* 204:    */   }
/* 205:    */   
/* 206:    */   public static Session getSession()
/* 207:    */   {
/* 208:272 */     return session;
/* 209:    */   }
/* 210:    */   
/* 211:    */   public static String getSubject()
/* 212:    */   {
/* 213:279 */     return subject;
/* 214:    */   }
/* 215:    */   
/* 216:    */   public static String getTo()
/* 217:    */   {
/* 218:286 */     return to;
/* 219:    */   }
/* 220:    */   
/* 221:    */   public static String getUser()
/* 222:    */   {
/* 223:293 */     return user;
/* 224:    */   }
/* 225:    */   
/* 226:    */   public static void setAUTH(boolean b)
/* 227:    */   {
/* 228:300 */     AUTH = b;
/* 229:    */   }
/* 230:    */   
/* 231:    */   public static void setBcc(String string)
/* 232:    */   {
/* 233:307 */     bcc = string;
/* 234:    */   }
/* 235:    */   
/* 236:    */   public static void setCc(String string)
/* 237:    */   {
/* 238:314 */     cc = string;
/* 239:    */   }
/* 240:    */   
/* 241:    */   public static void setContents(StringBuffer buffer)
/* 242:    */   {
/* 243:321 */     contents = buffer;
/* 244:    */   }
/* 245:    */   
/* 246:    */   public static void setDEBUG(boolean b)
/* 247:    */   {
/* 248:328 */     DEBUG = b;
/* 249:    */   }
/* 250:    */   
/* 251:    */   public static void setFrom(String string)
/* 252:    */   {
/* 253:335 */     from = string;
/* 254:    */   }
/* 255:    */   
/* 256:    */   public static void setPassword(String string)
/* 257:    */   {
/* 258:342 */     password = string;
/* 259:    */   }
/* 260:    */   
/* 261:    */   public static void setRESOURCES(MessageResources bundle)
/* 262:    */   {
/* 263:349 */     RESOURCES = bundle;
/* 264:    */   }
/* 265:    */   
/* 266:    */   public static void setServer(String string)
/* 267:    */   {
/* 268:356 */     server = string;
/* 269:    */   }
/* 270:    */   
/* 271:    */   public static void setSession(Session session)
/* 272:    */   {
/* 273:363 */     session = session;
/* 274:    */   }
/* 275:    */   
/* 276:    */   public static void setSubject(String string)
/* 277:    */   {
/* 278:370 */     System.out.println("paso..2");
/* 279:371 */     subject = string;
/* 280:    */   }
/* 281:    */   
/* 282:    */   public static void setTo(String string)
/* 283:    */   {
/* 284:378 */     to = string;
/* 285:    */   }
/* 286:    */   
/* 287:    */   public static void setUser(String string)
/* 288:    */   {
/* 289:385 */     user = string;
/* 290:    */   }
/* 291:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.essecorp.util.GestorCorreoSD
 * JD-Core Version:    0.7.0.1
 */