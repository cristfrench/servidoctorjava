/*   1:    */ package com.maxmind.geoip;
/*   2:    */ 
/*   3:    */ import java.io.File;
/*   4:    */ import java.io.IOException;
/*   5:    */ import java.io.PrintStream;
/*   6:    */ import java.io.RandomAccessFile;
/*   7:    */ import java.net.InetAddress;
/*   8:    */ import java.net.UnknownHostException;
/*   9:    */ import java.util.HashMap;
/*  10:    */ import java.util.Hashtable;
/*  11:    */ import java.util.StringTokenizer;
/*  12:    */ import javax.naming.NamingException;
/*  13:    */ import javax.naming.directory.Attribute;
/*  14:    */ import javax.naming.directory.Attributes;
/*  15:    */ import javax.naming.directory.DirContext;
/*  16:    */ import javax.naming.directory.InitialDirContext;
/*  17:    */ 
/*  18:    */ public class LookupService
/*  19:    */ {
/*  20: 73 */   private RandomAccessFile file = null;
/*  21: 74 */   private File databaseFile = null;
/*  22: 79 */   private DatabaseInfo databaseInfo = null;
/*  23: 84 */   byte databaseType = 1;
/*  24:    */   int[] databaseSegments;
/*  25:    */   int recordLength;
/*  26:    */   String licenseKey;
/*  27: 90 */   int dnsService = 0;
/*  28:    */   int dboptions;
/*  29:    */   byte[] dbbuffer;
/*  30:    */   byte[] index_cache;
/*  31:    */   long mtime;
/*  32:    */   private static final int US_OFFSET = 1;
/*  33:    */   private static final int CANADA_OFFSET = 677;
/*  34:    */   private static final int WORLD_OFFSET = 1353;
/*  35:    */   private static final int FIPS_RANGE = 360;
/*  36:    */   private static final int COUNTRY_BEGIN = 16776960;
/*  37:    */   private static final int STATE_BEGIN_REV0 = 16700000;
/*  38:    */   private static final int STATE_BEGIN_REV1 = 16000000;
/*  39:    */   private static final int STRUCTURE_INFO_MAX_SIZE = 20;
/*  40:    */   private static final int DATABASE_INFO_MAX_SIZE = 100;
/*  41:    */   public static final int GEOIP_STANDARD = 0;
/*  42:    */   public static final int GEOIP_MEMORY_CACHE = 1;
/*  43:    */   public static final int GEOIP_CHECK_CACHE = 2;
/*  44:    */   public static final int GEOIP_INDEX_CACHE = 4;
/*  45:    */   public static final int GEOIP_UNKNOWN_SPEED = 0;
/*  46:    */   public static final int GEOIP_DIALUP_SPEED = 1;
/*  47:    */   public static final int GEOIP_CABLEDSL_SPEED = 2;
/*  48:    */   public static final int GEOIP_CORPORATE_SPEED = 3;
/*  49:    */   private static final int SEGMENT_RECORD_LENGTH = 3;
/*  50:    */   private static final int STANDARD_RECORD_LENGTH = 3;
/*  51:    */   private static final int ORG_RECORD_LENGTH = 4;
/*  52:    */   private static final int MAX_RECORD_LENGTH = 4;
/*  53:    */   private static final int MAX_ORG_RECORD_LENGTH = 300;
/*  54:    */   private static final int FULL_RECORD_LENGTH = 60;
/*  55:122 */   private static final Country UNKNOWN_COUNTRY = new Country("--", "N/A");
/*  56:124 */   private static final HashMap hashmapcountryCodetoindex = new HashMap(512);
/*  57:125 */   private static final HashMap hashmapcountryNametoindex = new HashMap(512);
/*  58:126 */   private static final String[] countryCode = {
/*  59:127 */     "--", "AP", "EU", "AD", "AE", "AF", "AG", "AI", "AL", "AM", "AN", "AO", "AQ", "AR", 
/*  60:128 */     "AS", "AT", "AU", "AW", "AZ", "BA", "BB", "BD", "BE", "BF", "BG", "BH", "BI", "BJ", 
/*  61:129 */     "BM", "BN", "BO", "BR", "BS", "BT", "BV", "BW", "BY", "BZ", "CA", "CC", "CD", "CF", 
/*  62:130 */     "CG", "CH", "CI", "CK", "CL", "CM", "CN", "CO", "CR", "CU", "CV", "CX", "CY", "CZ", 
/*  63:131 */     "DE", "DJ", "DK", "DM", "DO", "DZ", "EC", "EE", "EG", "EH", "ER", "ES", "ET", "FI", 
/*  64:132 */     "FJ", "FK", "FM", "FO", "FR", "FX", "GA", "GB", "GD", "GE", "GF", "GH", "GI", "GL", 
/*  65:133 */     "GM", "GN", "GP", "GQ", "GR", "GS", "GT", "GU", "GW", "GY", "HK", "HM", "HN", "HR", 
/*  66:134 */     "HT", "HU", "ID", "IE", "IL", "IN", "IO", "IQ", "IR", "IS", "IT", "JM", "JO", "JP", 
/*  67:135 */     "KE", "KG", "KH", "KI", "KM", "KN", "KP", "KR", "KW", "KY", "KZ", "LA", "LB", "LC", 
/*  68:136 */     "LI", "LK", "LR", "LS", "LT", "LU", "LV", "LY", "MA", "MC", "MD", "MG", "MH", "MK", 
/*  69:137 */     "ML", "MM", "MN", "MO", "MP", "MQ", "MR", "MS", "MT", "MU", "MV", "MW", "MX", "MY", 
/*  70:138 */     "MZ", "NA", "NC", "NE", "NF", "NG", "NI", "NL", "NO", "NP", "NR", "NU", "NZ", "OM", 
/*  71:139 */     "PA", "PE", "PF", "PG", "PH", "PK", "PL", "PM", "PN", "PR", "PS", "PT", "PW", "PY", 
/*  72:140 */     "QA", "RE", "RO", "RU", "RW", "SA", "SB", "SC", "SD", "SE", "SG", "SH", "SI", "SJ", 
/*  73:141 */     "SK", "SL", "SM", "SN", "SO", "SR", "ST", "SV", "SY", "SZ", "TC", "TD", "TF", "TG", 
/*  74:142 */     "TH", "TJ", "TK", "TM", "TN", "TO", "TL", "TR", "TT", "TV", "TW", "TZ", "UA", "UG", 
/*  75:143 */     "UM", "US", "UY", "UZ", "VA", "VC", "VE", "VG", "VI", "VN", "VU", "WF", "WS", "YE", 
/*  76:144 */     "YT", "RS", "ZA", "ZM", "ME", "ZW", "A1", "A2", "O1", "AX", "GG", "IM", "JE" };
/*  77:146 */   private static final String[] countryName = {
/*  78:147 */     "N/A ", "Asia/Pacific Region", "Europe", "Andorra", "United Arab Emirates", 
/*  79:148 */     "Afghanistan", "Antigua and Barbuda", "Anguilla", "Albania", "Armenia", 
/*  80:149 */     "Netherlands Antilles", "Angola", "Antarctica", "Argentina", "American Samoa", 
/*  81:150 */     "Austria", "Australia", "Aruba", "Azerbaijan", "Bosnia and Herzegovina", 
/*  82:151 */     "Barbados", "Bangladesh", "Belgium", "Burkina Faso", "Bulgaria", "Bahrain", 
/*  83:152 */     "Burundi", "Benin", "Bermuda", "Brunei Darussalam", "Bolivia", "Brazil", "Bahamas", 
/*  84:153 */     "Bhutan", "Bouvet Island", "Botswana", "Belarus", "Belize", "Canada", 
/*  85:154 */     "Cocos (Keeling) Islands", "Congo, The Democratic Republic of the", 
/*  86:155 */     "Central African Republic", "Congo", "Switzerland", "Cote D'Ivoire", 
/*  87:156 */     "Cook Islands", "Chile", "Cameroon", "China", "Colombia", "Costa Rica", "Cuba", 
/*  88:157 */     "Cape Verde", "Christmas Island", "Cyprus", "Czech Republic", "Germany", 
/*  89:158 */     "Djibouti", "Denmark", "Dominica", "Dominican Republic", "Algeria", "Ecuador", 
/*  90:159 */     "Estonia", "Egypt", "Western Sahara", "Eritrea", "Spain", "Ethiopia", "Finland", 
/*  91:160 */     "Fiji", "Falkland Islands (Malvinas)", "Micronesia, Federated States of", 
/*  92:161 */     "Faroe Islands", "France", "France, Metropolitan", "Gabon", "United Kingdom", 
/*  93:162 */     "Grenada", "Georgia", "French Guiana", "Ghana", "Gibraltar", "Greenland", "Gambia", 
/*  94:163 */     "Guinea", "Guadeloupe", "Equatorial Guinea", "Greece", 
/*  95:164 */     "South Georgia and the South Sandwich Islands", "Guatemala", "Guam", 
/*  96:165 */     "Guinea-Bissau", "Guyana", "Hong Kong", "Heard Island and McDonald Islands", 
/*  97:166 */     "Honduras", "Croatia", "Haiti", "Hungary", "Indonesia", "Ireland", "Israel", "India", 
/*  98:167 */     "British Indian Ocean Territory", "Iraq", "Iran, Islamic Republic of", 
/*  99:168 */     "Iceland", "Italy", "Jamaica", "Jordan", "Japan", "Kenya", "Kyrgyzstan", "Cambodia", 
/* 100:169 */     "Kiribati", "Comoros", "Saint Kitts and Nevis", 
/* 101:170 */     "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait", 
/* 102:171 */     "Cayman Islands", "Kazakstan", "Lao People's Democratic Republic", "Lebanon", 
/* 103:172 */     "Saint Lucia", "Liechtenstein", "Sri Lanka", "Liberia", "Lesotho", "Lithuania", 
/* 104:173 */     "Luxembourg", "Latvia", "Libyan Arab Jamahiriya", "Morocco", "Monaco", 
/* 105:174 */     "Moldova, Republic of", "Madagascar", "Marshall Islands", 
/* 106:175 */     "Macedonia", "Mali", "Myanmar", "Mongolia", 
/* 107:176 */     "Macau", "Northern Mariana Islands", "Martinique", "Mauritania", "Montserrat", 
/* 108:177 */     "Malta", "Mauritius", "Maldives", "Malawi", "Mexico", "Malaysia", "Mozambique", 
/* 109:178 */     "Namibia", "New Caledonia", "Niger", "Norfolk Island", "Nigeria", "Nicaragua", 
/* 110:179 */     "Netherlands", "Norway", "Nepal", "Nauru", "Niue", "New Zealand", "Oman", "Panama", 
/* 111:180 */     "Peru", "French Polynesia", "Papua New Guinea", "Philippines", "Pakistan", 
/* 112:181 */     "Poland", "Saint Pierre and Miquelon", "Pitcairn Islands", "Puerto Rico", "Palestinian Territory", 
/* 113:182 */     "Portugal", "Palau", "Paraguay", "Qatar", 
/* 114:183 */     "Reunion", "Romania", "Russian Federation", "Rwanda", "Saudi Arabia", 
/* 115:184 */     "Solomon Islands", "Seychelles", "Sudan", "Sweden", "Singapore", "Saint Helena", 
/* 116:185 */     "Slovenia", "Svalbard and Jan Mayen", "Slovakia", "Sierra Leone", "San Marino", 
/* 117:186 */     "Senegal", "Somalia", "Suriname", "Sao Tome and Principe", "El Salvador", 
/* 118:187 */     "Syrian Arab Republic", "Swaziland", "Turks and Caicos Islands", "Chad", 
/* 119:188 */     "French Southern Territories", "Togo", "Thailand", "Tajikistan", "Tokelau", 
/* 120:189 */     "Turkmenistan", "Tunisia", "Tonga", "Timor-Leste", "Turkey", "Trinidad and Tobago", 
/* 121:190 */     "Tuvalu", "Taiwan", "Tanzania, United Republic of", "Ukraine", "Uganda", 
/* 122:191 */     "United States Minor Outlying Islands", "United States", "Uruguay", "Uzbekistan", 
/* 123:192 */     "Holy See (Vatican City State)", "Saint Vincent and the Grenadines", 
/* 124:193 */     "Venezuela", "Virgin Islands, British", "Virgin Islands, U.S.", "Vietnam", 
/* 125:194 */     "Vanuatu", "Wallis and Futuna", "Samoa", "Yemen", "Mayotte", "Serbia", 
/* 126:195 */     "South Africa", "Zambia", "Montenegro", "Zimbabwe", "Anonymous Proxy", 
/* 127:196 */     "Satellite Provider", "Other", "Aland Islands", "Guernsey", "Isle of Man", "Jersey" };
/* 128:    */   
/* 129:    */   public LookupService(String databaseFile, String licenseKey)
/* 130:    */     throws IOException
/* 131:    */   {
/* 132:206 */     this(new File(databaseFile));
/* 133:207 */     this.licenseKey = licenseKey;
/* 134:208 */     this.dnsService = 1;
/* 135:    */   }
/* 136:    */   
/* 137:    */   public LookupService(File databaseFile, String licenseKey)
/* 138:    */     throws IOException
/* 139:    */   {
/* 140:217 */     this(databaseFile);
/* 141:218 */     this.licenseKey = licenseKey;
/* 142:219 */     this.dnsService = 1;
/* 143:    */   }
/* 144:    */   
/* 145:    */   public LookupService(int options, String licenseKey)
/* 146:    */     throws IOException
/* 147:    */   {
/* 148:228 */     this.licenseKey = licenseKey;
/* 149:229 */     this.dnsService = 1;
/* 150:230 */     init();
/* 151:    */   }
/* 152:    */   
/* 153:    */   public LookupService(String databaseFile)
/* 154:    */     throws IOException
/* 155:    */   {
/* 156:240 */     this(new File(databaseFile));
/* 157:    */   }
/* 158:    */   
/* 159:    */   public LookupService(File databaseFile)
/* 160:    */     throws IOException
/* 161:    */   {
/* 162:251 */     this.databaseFile = databaseFile;
/* 163:252 */     this.file = new RandomAccessFile(databaseFile, "r");
/* 164:253 */     init();
/* 165:    */   }
/* 166:    */   
/* 167:    */   public LookupService(String databaseFile, int options)
/* 168:    */     throws IOException
/* 169:    */   {
/* 170:267 */     this(new File(databaseFile), options);
/* 171:    */   }
/* 172:    */   
/* 173:    */   public LookupService(File databaseFile, int options)
/* 174:    */     throws IOException
/* 175:    */   {
/* 176:281 */     this.databaseFile = databaseFile;
/* 177:282 */     this.file = new RandomAccessFile(databaseFile, "r");
/* 178:283 */     this.dboptions = options;
/* 179:284 */     init();
/* 180:    */   }
/* 181:    */   
/* 182:    */   private void init()
/* 183:    */     throws IOException
/* 184:    */   {
/* 185:293 */     byte[] delim = new byte[3];
/* 186:294 */     byte[] buf = new byte[3];
/* 187:296 */     if (this.file == null)
/* 188:    */     {
/* 189:298 */       for (int i = 0; i < 233; i++)
/* 190:    */       {
/* 191:299 */         hashmapcountryCodetoindex.put(countryCode[i], new Integer(i));
/* 192:300 */         hashmapcountryNametoindex.put(countryName[i], new Integer(i));
/* 193:    */       }
/* 194:302 */       return;
/* 195:    */     }
/* 196:304 */     if ((this.dboptions & 0x2) != 0) {
/* 197:305 */       this.mtime = this.databaseFile.lastModified();
/* 198:    */     }
/* 199:307 */     this.file.seek(this.file.length() - 3L);
/* 200:308 */     for (int i = 0; i < 20; i++)
/* 201:    */     {
/* 202:309 */       this.file.read(delim);
/* 203:310 */       if ((delim[0] == -1) && (delim[1] == -1) && (delim[2] == -1))
/* 204:    */       {
/* 205:311 */         this.databaseType = this.file.readByte();
/* 206:312 */         if (this.databaseType >= 106) {
/* 207:314 */           this.databaseType = ((byte)(this.databaseType - 105));
/* 208:    */         }
/* 209:317 */         if (this.databaseType == 7)
/* 210:    */         {
/* 211:318 */           this.databaseSegments = new int[1];
/* 212:319 */           this.databaseSegments[0] = 16700000;
/* 213:320 */           this.recordLength = 3; break;
/* 214:    */         }
/* 215:321 */         if (this.databaseType == 3)
/* 216:    */         {
/* 217:322 */           this.databaseSegments = new int[1];
/* 218:323 */           this.databaseSegments[0] = 16000000;
/* 219:324 */           this.recordLength = 3; break;
/* 220:    */         }
/* 221:326 */         if ((this.databaseType != 6) && 
/* 222:327 */           (this.databaseType != 2) && 
/* 223:328 */           (this.databaseType != 5) && 
/* 224:329 */           (this.databaseType != 4) && 
/* 225:330 */           (this.databaseType != 9)) {
/* 226:    */           break;
/* 227:    */         }
/* 228:331 */         this.databaseSegments = new int[1];
/* 229:332 */         this.databaseSegments[0] = 0;
/* 230:333 */         if ((this.databaseType == 6) || 
/* 231:334 */           (this.databaseType == 2)) {
/* 232:335 */           this.recordLength = 3;
/* 233:    */         } else {
/* 234:338 */           this.recordLength = 4;
/* 235:    */         }
/* 236:340 */         this.file.read(buf);
/* 237:341 */         for (int j = 0; j < 3; j++) {
/* 238:342 */           this.databaseSegments[0] += (unsignedByteToInt(buf[j]) << j * 8);
/* 239:    */         }
/* 240:345 */         break;
/* 241:    */       }
/* 242:348 */       this.file.seek(this.file.getFilePointer() - 4L);
/* 243:    */     }
/* 244:353 */     if (((this.databaseType == 1 ? 1 : 0) | (this.databaseType == 8 ? 1 : 0) | (this.databaseType == 10 ? 1 : 0)) != 0)
/* 245:    */     {
/* 246:354 */       this.databaseSegments = new int[1];
/* 247:355 */       this.databaseSegments[0] = 16776960;
/* 248:356 */       this.recordLength = 3;
/* 249:    */     }
/* 250:358 */     if ((this.dboptions & 0x1) == 1)
/* 251:    */     {
/* 252:359 */       int l = (int)this.file.length();
/* 253:360 */       this.dbbuffer = new byte[l];
/* 254:361 */       this.file.seek(0L);
/* 255:362 */       this.file.read(this.dbbuffer, 0, l);
/* 256:363 */       this.databaseInfo = getDatabaseInfo();
/* 257:364 */       this.file.close();
/* 258:    */     }
/* 259:366 */     if ((this.dboptions & 0x4) != 0)
/* 260:    */     {
/* 261:367 */       int l = this.databaseSegments[0] * this.recordLength * 2;
/* 262:368 */       this.index_cache = new byte[l];
/* 263:369 */       if (this.index_cache != null)
/* 264:    */       {
/* 265:370 */         this.file.seek(0L);
/* 266:371 */         this.file.read(this.index_cache, 0, l);
/* 267:    */       }
/* 268:    */     }
/* 269:    */     else
/* 270:    */     {
/* 271:374 */       this.index_cache = null;
/* 272:    */     }
/* 273:    */   }
/* 274:    */   
/* 275:    */   public void close()
/* 276:    */   {
/* 277:    */     try
/* 278:    */     {
/* 279:383 */       if (this.file != null) {
/* 280:384 */         this.file.close();
/* 281:    */       }
/* 282:386 */       this.file = null;
/* 283:    */     }
/* 284:    */     catch (Exception localException) {}
/* 285:    */   }
/* 286:    */   
/* 287:    */   public Country getCountry(String ipAddress)
/* 288:    */   {
/* 289:    */     try
/* 290:    */     {
/* 291:400 */       addr = InetAddress.getByName(ipAddress);
/* 292:    */     }
/* 293:    */     catch (UnknownHostException e)
/* 294:    */     {
/* 295:    */       InetAddress addr;
/* 296:403 */       return UNKNOWN_COUNTRY;
/* 297:    */     }
/* 298:    */     InetAddress addr;
/* 299:405 */     return getCountry(bytesToLong(addr.getAddress()));
/* 300:    */   }
/* 301:    */   
/* 302:    */   public Country getCountry(InetAddress ipAddress)
/* 303:    */   {
/* 304:415 */     return getCountry(bytesToLong(ipAddress.getAddress()));
/* 305:    */   }
/* 306:    */   
/* 307:    */   public Country getCountry(long ipAddress)
/* 308:    */   {
/* 309:425 */     if ((this.file == null) && ((this.dboptions & 0x1) == 0)) {
/* 310:426 */       throw new IllegalStateException("Database has been closed.");
/* 311:    */     }
/* 312:428 */     int ret = seekCountry(ipAddress) - 16776960;
/* 313:429 */     if (ret == 0) {
/* 314:430 */       return UNKNOWN_COUNTRY;
/* 315:    */     }
/* 316:433 */     return new Country(countryCode[ret], countryName[ret]);
/* 317:    */   }
/* 318:    */   
/* 319:    */   public int getID(String ipAddress)
/* 320:    */   {
/* 321:    */     try
/* 322:    */     {
/* 323:440 */       addr = InetAddress.getByName(ipAddress);
/* 324:    */     }
/* 325:    */     catch (UnknownHostException e)
/* 326:    */     {
/* 327:    */       InetAddress addr;
/* 328:443 */       return 0;
/* 329:    */     }
/* 330:    */     InetAddress addr;
/* 331:445 */     return getID(bytesToLong(addr.getAddress()));
/* 332:    */   }
/* 333:    */   
/* 334:    */   public int getID(InetAddress ipAddress)
/* 335:    */   {
/* 336:449 */     return getID(bytesToLong(ipAddress.getAddress()));
/* 337:    */   }
/* 338:    */   
/* 339:    */   public int getID(long ipAddress)
/* 340:    */   {
/* 341:453 */     if ((this.file == null) && ((this.dboptions & 0x1) == 0)) {
/* 342:454 */       throw new IllegalStateException("Database has been closed.");
/* 343:    */     }
/* 344:456 */     int ret = seekCountry(ipAddress) - this.databaseSegments[0];
/* 345:457 */     return ret;
/* 346:    */   }
/* 347:    */   
/* 348:    */   public DatabaseInfo getDatabaseInfo()
/* 349:    */   {
/* 350:466 */     if (this.databaseInfo != null) {
/* 351:467 */       return this.databaseInfo;
/* 352:    */     }
/* 353:    */     try
/* 354:    */     {
/* 355:471 */       synchronized (this)
/* 356:    */       {
/* 357:472 */         _check_mtime();
/* 358:473 */         boolean hasStructureInfo = false;
/* 359:474 */         byte[] delim = new byte[3];
/* 360:    */         
/* 361:476 */         this.file.seek(this.file.length() - 3L);
/* 362:477 */         for (int i = 0; i < 20; i++)
/* 363:    */         {
/* 364:478 */           this.file.read(delim);
/* 365:479 */           if ((delim[0] == 255) && (delim[1] == 255) && (delim[2] == 255))
/* 366:    */           {
/* 367:480 */             hasStructureInfo = true;
/* 368:481 */             break;
/* 369:    */           }
/* 370:    */         }
/* 371:484 */         if (hasStructureInfo) {
/* 372:485 */           this.file.seek(this.file.getFilePointer() - 3L);
/* 373:    */         } else {
/* 374:489 */           this.file.seek(this.file.length() - 3L);
/* 375:    */         }
/* 376:492 */         for (int i = 0; i < 100; i++)
/* 377:    */         {
/* 378:493 */           this.file.read(delim);
/* 379:494 */           if ((delim[0] == 0) && (delim[1] == 0) && (delim[2] == 0))
/* 380:    */           {
/* 381:495 */             byte[] dbInfo = new byte[i];
/* 382:496 */             this.file.read(dbInfo);
/* 383:    */             
/* 384:498 */             this.databaseInfo = new DatabaseInfo(new String(dbInfo));
/* 385:499 */             return this.databaseInfo;
/* 386:    */           }
/* 387:501 */           this.file.seek(this.file.getFilePointer() - 4L);
/* 388:    */         }
/* 389:    */       }
/* 390:508 */       return new DatabaseInfo("");
/* 391:    */     }
/* 392:    */     catch (Exception e)
/* 393:    */     {
/* 394:506 */       e.printStackTrace();
/* 395:    */     }
/* 396:    */   }
/* 397:    */   
/* 398:    */   synchronized void _check_mtime()
/* 399:    */   {
/* 400:    */     try
/* 401:    */     {
/* 402:513 */       if ((this.dboptions & 0x2) != 0)
/* 403:    */       {
/* 404:514 */         long t = this.databaseFile.lastModified();
/* 405:515 */         if (t != this.mtime)
/* 406:    */         {
/* 407:518 */           this.file.close();
/* 408:519 */           this.file = new RandomAccessFile(this.databaseFile, "r");
/* 409:520 */           init();
/* 410:    */         }
/* 411:    */       }
/* 412:    */     }
/* 413:    */     catch (IOException e)
/* 414:    */     {
/* 415:524 */       System.out.println("file not found");
/* 416:    */     }
/* 417:    */   }
/* 418:    */   
/* 419:    */   public Location getLocation(InetAddress addr)
/* 420:    */   {
/* 421:530 */     return getLocation(bytesToLong(addr.getAddress()));
/* 422:    */   }
/* 423:    */   
/* 424:    */   public Location getLocation(String str)
/* 425:    */   {
/* 426:535 */     if (this.dnsService == 0)
/* 427:    */     {
/* 428:    */       try
/* 429:    */       {
/* 430:538 */         addr = InetAddress.getByName(str);
/* 431:    */       }
/* 432:    */       catch (UnknownHostException e)
/* 433:    */       {
/* 434:    */         InetAddress addr;
/* 435:541 */         return null;
/* 436:    */       }
/* 437:    */       InetAddress addr;
/* 438:544 */       return getLocation(addr);
/* 439:    */     }
/* 440:546 */     String str2 = getDnsAttributes(str);
/* 441:547 */     return getLocationwithdnsservice(str2);
/* 442:    */   }
/* 443:    */   
/* 444:    */   String getDnsAttributes(String ip)
/* 445:    */   {
/* 446:    */     try
/* 447:    */     {
/* 448:554 */       Hashtable env = new Hashtable();
/* 449:555 */       env.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
/* 450:    */       
/* 451:557 */       env.put("java.naming.provider.url", "dns://ws1.maxmind.com/");
/* 452:    */       
/* 453:559 */       DirContext ictx = new InitialDirContext(env);
/* 454:560 */       Attributes attrs = ictx.getAttributes(this.licenseKey + "." + ip + ".s.maxmind.com", new String[] { "txt" });
/* 455:    */       
/* 456:562 */       return attrs.get("txt").get().toString();
/* 457:    */     }
/* 458:    */     catch (NamingException e)
/* 459:    */     {
/* 460:567 */       System.out.println("DNS error");
/* 461:    */     }
/* 462:568 */     return null;
/* 463:    */   }
/* 464:    */   
/* 465:    */   public Location getLocationwithdnsservice(String str)
/* 466:    */   {
/* 467:574 */     Location record = new Location();
/* 468:    */     
/* 469:    */ 
/* 470:577 */     StringTokenizer st = new StringTokenizer(str, ";=\"");
/* 471:578 */     while (st.hasMoreTokens())
/* 472:    */     {
/* 473:579 */       String key = st.nextToken();
/* 474:    */       String value;
/* 475:    */       String value;
/* 476:580 */       if (st.hasMoreTokens()) {
/* 477:581 */         value = st.nextToken();
/* 478:    */       } else {
/* 479:583 */         value = "";
/* 480:    */       }
/* 481:584 */       if (key.equals("co"))
/* 482:    */       {
/* 483:585 */         Integer i = (Integer)hashmapcountryCodetoindex.get(value);
/* 484:586 */         record.countryCode = value;
/* 485:587 */         record.countryName = countryName[i.intValue()];
/* 486:    */       }
/* 487:589 */       if (key.equals("ci")) {
/* 488:590 */         record.city = value;
/* 489:    */       }
/* 490:592 */       if (key.equals("re")) {
/* 491:593 */         record.region = value;
/* 492:    */       }
/* 493:595 */       if (key.equals("zi")) {
/* 494:596 */         record.postalCode = value;
/* 495:    */       }
/* 496:605 */       if (key.equals("la")) {
/* 497:    */         try
/* 498:    */         {
/* 499:607 */           record.latitude = Float.parseFloat(value);
/* 500:    */         }
/* 501:    */         catch (NumberFormatException e)
/* 502:    */         {
/* 503:609 */           record.latitude = 0.0F;
/* 504:    */         }
/* 505:    */       }
/* 506:612 */       if (key.equals("lo")) {
/* 507:    */         try
/* 508:    */         {
/* 509:614 */           record.longitude = Float.parseFloat(value);
/* 510:    */         }
/* 511:    */         catch (NumberFormatException e)
/* 512:    */         {
/* 513:616 */           record.latitude = 0.0F;
/* 514:    */         }
/* 515:    */       }
/* 516:619 */       if (key.equals("dm")) {
/* 517:    */         try
/* 518:    */         {
/* 519:621 */           record.dma_code = Integer.parseInt(value);
/* 520:    */         }
/* 521:    */         catch (NumberFormatException e)
/* 522:    */         {
/* 523:623 */           record.dma_code = 0;
/* 524:    */         }
/* 525:    */       }
/* 526:626 */       if (key.equals("ac")) {
/* 527:    */         try
/* 528:    */         {
/* 529:628 */           record.area_code = Integer.parseInt(value);
/* 530:    */         }
/* 531:    */         catch (NumberFormatException e)
/* 532:    */         {
/* 533:630 */           record.area_code = 0;
/* 534:    */         }
/* 535:    */       }
/* 536:    */     }
/* 537:634 */     return record;
/* 538:    */   }
/* 539:    */   
/* 540:    */   public synchronized Region getRegion(String str)
/* 541:    */   {
/* 542:    */     try
/* 543:    */     {
/* 544:640 */       addr = InetAddress.getByName(str);
/* 545:    */     }
/* 546:    */     catch (UnknownHostException e)
/* 547:    */     {
/* 548:    */       InetAddress addr;
/* 549:643 */       return null;
/* 550:    */     }
/* 551:    */     InetAddress addr;
/* 552:646 */     return getRegion(bytesToLong(addr.getAddress()));
/* 553:    */   }
/* 554:    */   
/* 555:    */   public synchronized Region getRegion(long ipnum)
/* 556:    */   {
/* 557:650 */     Region record = new Region();
/* 558:651 */     int seek_region = 0;
/* 559:652 */     if (this.databaseType == 7)
/* 560:    */     {
/* 561:653 */       seek_region = seekCountry(ipnum) - 16700000;
/* 562:654 */       char[] ch = new char[2];
/* 563:655 */       if (seek_region >= 1000)
/* 564:    */       {
/* 565:656 */         record.countryCode = "US";
/* 566:657 */         record.countryName = "United States";
/* 567:658 */         ch[0] = ((char)((seek_region - 1000) / 26 + 65));
/* 568:659 */         ch[1] = ((char)((seek_region - 1000) % 26 + 65));
/* 569:660 */         record.region = new String(ch);
/* 570:    */       }
/* 571:    */       else
/* 572:    */       {
/* 573:662 */         record.countryCode = countryCode[seek_region];
/* 574:663 */         record.countryName = countryName[seek_region];
/* 575:664 */         record.region = "";
/* 576:    */       }
/* 577:    */     }
/* 578:666 */     else if (this.databaseType == 3)
/* 579:    */     {
/* 580:667 */       seek_region = seekCountry(ipnum) - 16000000;
/* 581:668 */       char[] ch = new char[2];
/* 582:669 */       if (seek_region < 1)
/* 583:    */       {
/* 584:670 */         record.countryCode = "";
/* 585:671 */         record.countryName = "";
/* 586:672 */         record.region = "";
/* 587:    */       }
/* 588:673 */       else if (seek_region < 677)
/* 589:    */       {
/* 590:674 */         record.countryCode = "US";
/* 591:675 */         record.countryName = "United States";
/* 592:676 */         ch[0] = ((char)((seek_region - 1) / 26 + 65));
/* 593:677 */         ch[1] = ((char)((seek_region - 1) % 26 + 65));
/* 594:678 */         record.region = new String(ch);
/* 595:    */       }
/* 596:679 */       else if (seek_region < 1353)
/* 597:    */       {
/* 598:680 */         record.countryCode = "CA";
/* 599:681 */         record.countryName = "Canada";
/* 600:682 */         ch[0] = ((char)((seek_region - 677) / 26 + 65));
/* 601:683 */         ch[1] = ((char)((seek_region - 677) % 26 + 65));
/* 602:684 */         record.region = new String(ch);
/* 603:    */       }
/* 604:    */       else
/* 605:    */       {
/* 606:686 */         record.countryCode = countryCode[((seek_region - 1353) / 360)];
/* 607:687 */         record.countryName = countryName[((seek_region - 1353) / 360)];
/* 608:688 */         record.region = "";
/* 609:    */       }
/* 610:    */     }
/* 611:691 */     return record;
/* 612:    */   }
/* 613:    */   
/* 614:    */   public synchronized Location getLocation(long ipnum)
/* 615:    */   {
/* 616:696 */     byte[] record_buf = new byte[60];
/* 617:697 */     int record_buf_offset = 0;
/* 618:698 */     Location record = new Location();
/* 619:699 */     int str_length = 0;
/* 620:    */     
/* 621:701 */     double latitude = 0.0D;double longitude = 0.0D;
/* 622:    */     try
/* 623:    */     {
/* 624:704 */       int seek_country = seekCountry(ipnum);
/* 625:705 */       if (seek_country == this.databaseSegments[0]) {
/* 626:706 */         return null;
/* 627:    */       }
/* 628:708 */       int record_pointer = seek_country + (2 * this.recordLength - 1) * this.databaseSegments[0];
/* 629:710 */       if ((this.dboptions & 0x1) == 1)
/* 630:    */       {
/* 631:712 */         for (int i = 0; i < 60; i++) {
/* 632:713 */           record_buf[i] = this.dbbuffer[(i + record_pointer)];
/* 633:    */         }
/* 634:    */       }
/* 635:    */       else
/* 636:    */       {
/* 637:717 */         this.file.seek(record_pointer);
/* 638:718 */         this.file.read(record_buf);
/* 639:    */       }
/* 640:722 */       record.countryCode = countryCode[unsignedByteToInt(record_buf[0])];
/* 641:723 */       record.countryName = countryName[unsignedByteToInt(record_buf[0])];
/* 642:724 */       record_buf_offset++;
/* 643:727 */       while (record_buf[(record_buf_offset + str_length)] != 0) {
/* 644:728 */         str_length++;
/* 645:    */       }
/* 646:729 */       if (str_length > 0) {
/* 647:730 */         record.region = new String(record_buf, record_buf_offset, str_length);
/* 648:    */       }
/* 649:732 */       record_buf_offset += str_length + 1;
/* 650:733 */       str_length = 0;
/* 651:736 */       while (record_buf[(record_buf_offset + str_length)] != 0) {
/* 652:737 */         str_length++;
/* 653:    */       }
/* 654:738 */       if (str_length > 0) {
/* 655:739 */         record.city = new String(record_buf, record_buf_offset, str_length, "ISO-8859-1");
/* 656:    */       }
/* 657:741 */       record_buf_offset += str_length + 1;
/* 658:742 */       str_length = 0;
/* 659:745 */       while (record_buf[(record_buf_offset + str_length)] != 0) {
/* 660:746 */         str_length++;
/* 661:    */       }
/* 662:747 */       if (str_length > 0) {
/* 663:748 */         record.postalCode = new String(record_buf, record_buf_offset, str_length);
/* 664:    */       }
/* 665:750 */       record_buf_offset += str_length + 1;
/* 666:753 */       for (int j = 0; j < 3; j++) {
/* 667:754 */         latitude += (unsignedByteToInt(record_buf[(record_buf_offset + j)]) << j * 8);
/* 668:    */       }
/* 669:755 */       record.latitude = ((float)latitude / 10000.0F - 180.0F);
/* 670:756 */       record_buf_offset += 3;
/* 671:759 */       for (j = 0; j < 3; j++) {
/* 672:760 */         longitude += (unsignedByteToInt(record_buf[(record_buf_offset + j)]) << j * 8);
/* 673:    */       }
/* 674:761 */       record.longitude = ((float)longitude / 10000.0F - 180.0F);
/* 675:    */       
/* 676:763 */       record.dma_code = 0;
/* 677:764 */       record.area_code = 0;
/* 678:765 */       if (this.databaseType == 2)
/* 679:    */       {
/* 680:767 */         int dmaarea_combo = 0;
/* 681:768 */         if (record.countryCode == "US")
/* 682:    */         {
/* 683:769 */           record_buf_offset += 3;
/* 684:770 */           for (j = 0; j < 3; j++) {
/* 685:771 */             dmaarea_combo += (unsignedByteToInt(record_buf[(record_buf_offset + j)]) << j * 8);
/* 686:    */           }
/* 687:772 */           record.dma_code = (dmaarea_combo / 1000);
/* 688:773 */           record.area_code = (dmaarea_combo % 1000);
/* 689:    */         }
/* 690:    */       }
/* 691:    */     }
/* 692:    */     catch (IOException e)
/* 693:    */     {
/* 694:778 */       System.err.println("IO Exception while seting up segments");
/* 695:    */     }
/* 696:780 */     return record;
/* 697:    */   }
/* 698:    */   
/* 699:    */   public String getOrg(InetAddress addr)
/* 700:    */   {
/* 701:784 */     return getOrg(bytesToLong(addr.getAddress()));
/* 702:    */   }
/* 703:    */   
/* 704:    */   public String getOrg(String str)
/* 705:    */   {
/* 706:    */     try
/* 707:    */     {
/* 708:790 */       addr = InetAddress.getByName(str);
/* 709:    */     }
/* 710:    */     catch (UnknownHostException e)
/* 711:    */     {
/* 712:    */       InetAddress addr;
/* 713:793 */       return null;
/* 714:    */     }
/* 715:    */     InetAddress addr;
/* 716:795 */     return getOrg(addr);
/* 717:    */   }
/* 718:    */   
/* 719:    */   public synchronized String getOrg(long ipnum)
/* 720:    */   {
/* 721:802 */     int str_length = 0;
/* 722:803 */     byte[] buf = new byte[300];
/* 723:    */     try
/* 724:    */     {
/* 725:807 */       int seek_org = seekCountry(ipnum);
/* 726:808 */       if (seek_org == this.databaseSegments[0]) {
/* 727:809 */         return null;
/* 728:    */       }
/* 729:812 */       int record_pointer = seek_org + (2 * this.recordLength - 1) * this.databaseSegments[0];
/* 730:813 */       if ((this.dboptions & 0x1) == 1)
/* 731:    */       {
/* 732:815 */         for (int i = 0; i < 60; i++) {
/* 733:816 */           buf[i] = this.dbbuffer[(i + record_pointer)];
/* 734:    */         }
/* 735:    */       }
/* 736:    */       else
/* 737:    */       {
/* 738:820 */         this.file.seek(record_pointer);
/* 739:821 */         this.file.read(buf);
/* 740:    */       }
/* 741:823 */       while (buf[str_length] != 0) {
/* 742:824 */         str_length++;
/* 743:    */       }
/* 744:826 */       return new String(buf, 0, str_length, "ISO-8859-1");
/* 745:    */     }
/* 746:    */     catch (IOException e)
/* 747:    */     {
/* 748:830 */       System.out.println("IO Exception");
/* 749:    */     }
/* 750:831 */     return null;
/* 751:    */   }
/* 752:    */   
/* 753:    */   private synchronized int seekCountry(long ipAddress)
/* 754:    */   {
/* 755:842 */     byte[] buf = new byte[8];
/* 756:843 */     int[] x = new int[2];
/* 757:844 */     int offset = 0;
/* 758:845 */     _check_mtime();
/* 759:846 */     for (int depth = 31; depth >= 0; depth--)
/* 760:    */     {
/* 761:847 */       if ((this.dboptions & 0x1) == 1) {
/* 762:849 */         for (int i = 0; i < 8; i++) {
/* 763:850 */           buf[i] = this.dbbuffer[(2 * this.recordLength * offset + i)];
/* 764:    */         }
/* 765:852 */       } else if ((this.dboptions & 0x4) != 0) {
/* 766:854 */         for (int i = 0; i < 8; i++) {
/* 767:855 */           buf[i] = this.index_cache[(2 * this.recordLength * offset + i)];
/* 768:    */         }
/* 769:    */       } else {
/* 770:    */         try
/* 771:    */         {
/* 772:860 */           this.file.seek(2 * this.recordLength * offset);
/* 773:861 */           this.file.read(buf);
/* 774:    */         }
/* 775:    */         catch (IOException e)
/* 776:    */         {
/* 777:864 */           System.out.println("IO Exception");
/* 778:    */         }
/* 779:    */       }
/* 780:867 */       for (int i = 0; i < 2; i++)
/* 781:    */       {
/* 782:868 */         x[i] = 0;
/* 783:869 */         for (int j = 0; j < this.recordLength; j++)
/* 784:    */         {
/* 785:870 */           int y = buf[(i * this.recordLength + j)];
/* 786:871 */           if (y < 0) {
/* 787:872 */             y += 256;
/* 788:    */           }
/* 789:874 */           x[i] += (y << j * 8);
/* 790:    */         }
/* 791:    */       }
/* 792:878 */       if ((ipAddress & 1 << depth) > 0L)
/* 793:    */       {
/* 794:879 */         if (x[1] >= this.databaseSegments[0]) {
/* 795:880 */           return x[1];
/* 796:    */         }
/* 797:882 */         offset = x[1];
/* 798:    */       }
/* 799:    */       else
/* 800:    */       {
/* 801:885 */         if (x[0] >= this.databaseSegments[0]) {
/* 802:886 */           return x[0];
/* 803:    */         }
/* 804:888 */         offset = x[0];
/* 805:    */       }
/* 806:    */     }
/* 807:893 */     System.err.println("Error seeking country while seeking " + ipAddress);
/* 808:894 */     return 0;
/* 809:    */   }
/* 810:    */   
/* 811:    */   private static long bytesToLong(byte[] address)
/* 812:    */   {
/* 813:904 */     long ipnum = 0L;
/* 814:905 */     for (int i = 0; i < 4; i++)
/* 815:    */     {
/* 816:906 */       long y = address[i];
/* 817:907 */       if (y < 0L) {
/* 818:908 */         y += 256L;
/* 819:    */       }
/* 820:910 */       ipnum += (y << (3 - i) * 8);
/* 821:    */     }
/* 822:912 */     return ipnum;
/* 823:    */   }
/* 824:    */   
/* 825:    */   private static int unsignedByteToInt(byte b)
/* 826:    */   {
/* 827:916 */     return b & 0xFF;
/* 828:    */   }
/* 829:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.maxmind.geoip.LookupService
 * JD-Core Version:    0.7.0.1
 */