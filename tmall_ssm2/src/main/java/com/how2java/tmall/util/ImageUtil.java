package com.how2java.tmall.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class ImageUtil{
    public static BufferedImage change2jpg(File f){//静态方法 可以直接使用类名进行调用
        try {
            Image i = Toolkit.getDefaultToolkit().createImage(f.getAbsolutePath());
            PixelGrabber pg = new PixelGrabber(i, 0, 0, -1, -1, true);
            pg.grabPixels();
                int width= pg.getWidth();
                int hieght= pg.getHeight();
                final int[] RGB_MASKS={0XFF0000,0XFF00,0XFF};
                final ColorModel RGB_OPAQUE = new DirectColorModel(32,RGB_MASKS[0],RGB_MASKS[1],RGB_MASKS[2]);
            DataBuffer buffer = new DataBufferInt((int[])pg.getPixels(),pg.getWidth()*pg.getHeight());
            WritableRaster raster = Raster.createPackedRaster(buffer,width,hieght,width,RGB_MASKS,null);
            BufferedImage img=new BufferedImage(RGB_OPAQUE,raster,false,null);
            return  img;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return  null;
        }
    }
    public static void  resizeImage(File srcFile,int width,int height,File destFile){
        try {
            if(!destFile.getParentFile().exists()){
                destFile.getParentFile().mkdirs();
            }
            Image i = ImageIO.read(srcFile);
            i= resizeImage(i,width,height);
            ImageIO.write((RenderedImage) i,"jpg",destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static  Image resizeImage(Image srcImage,int width,int height){
        try {
            BufferedImage bufferedImage= null;
            bufferedImage= new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
            bufferedImage.getGraphics().drawImage(srcImage.getScaledInstance(width,height,Image.SCALE_SMOOTH),0,0,null);
        return bufferedImage;
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }
}
