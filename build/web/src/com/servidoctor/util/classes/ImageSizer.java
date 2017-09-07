/*   1:    */ package com.servidoctor.util.classes;
/*   2:    */ 
/*   3:    */ import com.sun.image.codec.jpeg.JPEGCodec;
/*   4:    */ import com.sun.image.codec.jpeg.JPEGEncodeParam;
/*   5:    */ import com.sun.image.codec.jpeg.JPEGImageEncoder;
/*   6:    */ import java.awt.Component;
/*   7:    */ import java.awt.Graphics2D;
/*   8:    */ import java.awt.Image;
/*   9:    */ import java.awt.MediaTracker;
/*  10:    */ import java.awt.Toolkit;
/*  11:    */ import java.awt.image.BufferedImage;
/*  12:    */ import java.io.FileOutputStream;
/*  13:    */ import java.io.IOException;
/*  14:    */ import java.io.OutputStream;
/*  15:    */ import java.io.PrintStream;
/*  16:    */ 
/*  17:    */ public class ImageSizer
/*  18:    */ {
/*  19: 22 */   public static final MediaTracker tracker = new MediaTracker(new Component() {});
/*  20:    */   
/*  21:    */   public static Image setSize(Image image, int width, int height)
/*  22:    */   {
/*  23: 27 */     return setSize(image, width, height, 1);
/*  24:    */   }
/*  25:    */   
/*  26:    */   public static Image setSize(Image image, int width, int height, int hints)
/*  27:    */   {
/*  28: 37 */     return image.getScaledInstance(width, height, hints);
/*  29:    */   }
/*  30:    */   
/*  31:    */   public static void checkImage(Image image)
/*  32:    */   {
/*  33: 42 */     waitForImage(image);
/*  34: 43 */     int imageWidth = image.getWidth(null);
/*  35: 44 */     if (imageWidth < 1) {
/*  36: 45 */       throw new IllegalArgumentException("image width " + imageWidth + " is out of range");
/*  37:    */     }
/*  38: 46 */     int imageHeight = image.getHeight(null);
/*  39: 47 */     if (imageHeight < 1) {
/*  40: 48 */       throw new IllegalArgumentException("image height " + imageHeight + " is out of range");
/*  41:    */     }
/*  42:    */   }
/*  43:    */   
/*  44:    */   public static void waitForImage(Image image)
/*  45:    */   {
/*  46:    */     try
/*  47:    */     {
/*  48: 55 */       tracker.addImage(image, 0);
/*  49: 56 */       tracker.waitForID(0);
/*  50:    */       
/*  51: 58 */       tracker.removeImage(image, 0);
/*  52:    */     }
/*  53:    */     catch (InterruptedException e)
/*  54:    */     {
/*  55: 59 */       e.printStackTrace();
/*  56:    */     }
/*  57:    */   }
/*  58:    */   
/*  59:    */   public static void encodeJPEG(OutputStream outputStream, Image outputImage, float outputQuality)
/*  60:    */     throws IOException
/*  61:    */   {
/*  62: 65 */     int outputWidth = outputImage.getWidth(null);
/*  63: 66 */     if (outputWidth < 1) {
/*  64: 67 */       throw new IllegalArgumentException("output image width " + outputWidth + " is out of range");
/*  65:    */     }
/*  66: 68 */     int outputHeight = outputImage.getHeight(null);
/*  67: 69 */     if (outputHeight < 1) {
/*  68: 70 */       throw new IllegalArgumentException("output image height " + outputHeight + " is out of range");
/*  69:    */     }
/*  70: 73 */     BufferedImage bi = new BufferedImage(outputWidth, outputHeight, 
/*  71: 74 */       1);
/*  72: 75 */     Graphics2D biContext = bi.createGraphics();
/*  73: 76 */     biContext.drawImage(outputImage, 0, 0, null);
/*  74:    */     
/*  75:    */ 
/*  76:    */ 
/*  77: 80 */     JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(outputStream);
/*  78:    */     
/*  79: 82 */     JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(bi);
/*  80: 83 */     jep.setQuality(outputQuality, true);
/*  81: 84 */     encoder.encode(bi, jep);
/*  82:    */     
/*  83: 86 */     outputStream.flush();
/*  84:    */   }
/*  85:    */   
/*  86:    */   public static void main(String[] args)
/*  87:    */     throws IOException
/*  88:    */   {
/*  89: 92 */     if (args.length < 4)
/*  90:    */     {
/*  91: 93 */       System.out.println("ImageSizer - changes the size of an image.");
/*  92: 94 */       System.out.println("use: java ImageSizer inputFile outputFile outputWidth outputQuality");
/*  93: 95 */       return;
/*  94:    */     }
/*  95: 98 */     String inputFileName = args[0];
/*  96: 99 */     String outputFileName = args[1];
/*  97:100 */     int outputWidth = Integer.parseInt(args[2]);
/*  98:101 */     if (outputWidth < 1) {
/*  99:102 */       throw new IllegalArgumentException("output width \"" + args[2] + "\" out of range");
/* 100:    */     }
/* 101:103 */     float outputQuality = Float.parseFloat(args[3]);
/* 102:104 */     if ((outputQuality < 0.0F) || (outputQuality > 1.0F)) {
/* 103:105 */       throw new IllegalArgumentException("output quality \"" + args[3] + "\" out of range");
/* 104:    */     }
/* 105:108 */     Image inputImage = Toolkit.getDefaultToolkit().getImage(inputFileName);
/* 106:109 */     checkImage(inputImage);
/* 107:    */     
/* 108:    */ 
/* 109:    */ 
/* 110:113 */     Image outputImage = setSize(inputImage, outputWidth, -1);
/* 111:114 */     checkImage(outputImage);
/* 112:    */     
/* 113:    */ 
/* 114:    */ 
/* 115:118 */     FileOutputStream fos = new FileOutputStream(outputFileName);
/* 116:119 */     encodeJPEG(fos, outputImage, outputQuality);
/* 117:120 */     fos.close();
/* 118:    */     
/* 119:122 */     System.exit(0);
/* 120:    */   }
/* 121:    */ }


/* Location:           Z:\Proyectos_2017\colombia\ServiDoctor\WEB-INF\classes\
 * Qualified Name:     com.servidoctor.util.classes.ImageSizer
 * JD-Core Version:    0.7.0.1
 */