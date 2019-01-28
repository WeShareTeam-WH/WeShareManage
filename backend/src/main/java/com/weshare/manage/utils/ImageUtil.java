package com.weshare.manage.utils;
import java.io.*;  
import java.awt.*;  
import java.awt.image.*;  
import java.awt.Graphics;  
import java.awt.color.ColorSpace;  
import javax.imageio.ImageIO;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.misc.BASE64Decoder;

public class ImageUtil {
	private static Logger logger = LogManager.getLogger(ImageUtil.class);

	public static String uploadImage(File localFile){
        // 1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials("AKID21pSuPJz3vc7RazL1VowsbAXjjXAgrvo", "sb91lgVBfw1xhEnDgy4ygEZjhgJo7E8q");
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region("ap-guangzhou"));
        // 3 生成cos客户端
        COSClient cosclient = new COSClient(cred, clientConfig);
        // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
        String bucketName = "weshare-1256677300";
        String basicUrlDomain = "https://weshare-1256677300.cos.ap-guangzhou.myqcloud.com";
        // 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20M以下的文件使用该接口
        // 大文件上传请参照 API 文档高级 API 上传
        // File localFile = new File("src/test/resources/len5M.txt");
        // 指定要上传到 COS 上对象键
        // 对象键（Key）是对象在存储桶中的唯一标识。例如，在对象的访问域名 `bucket1-1250000000.cos.ap-guangzhou.myqcloud.com/doc1/pic1.jpg` 中，对象键为 doc1/pic1.jpg, 详情参考 [对象键](https://cloud.tencent.com/document/product/436/13324)
        String key = UtilsHelper.getRandomNum(10)+".png";
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest);

        return basicUrlDomain+"/"+key;
    }

    public static String GenerateImage(String base64str)
    {   //对字节数组字符串进行Base64解码并生成图片
        if (base64str == null) //图像数据为空
            return null;
        // System.out.println("开始解码");
        base64str = base64str.substring(base64str.lastIndexOf(",")+1);
        BASE64Decoder decoder = new BASE64Decoder();
        try
        {
//              File file = new File(savepath);
//            File fileParent = file.getParentFile();
//            if(!fileParent.exists()){
//                fileParent.mkdirs();
//            }
//            if(!file.exists())
//            {
//                file.createNewFile();
//            }

            //Base64解码
            byte[] b = decoder.decodeBuffer(base64str);
            //  System.out.println("解码完成");
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }

//            InputStream input = new FileInputStream(b);
            // System.out.println("开始生成图片");
            //生成jpeg图片
//            OutputStream out = new FileOutputStream(savepath);
//            out.write(b);
//            out.flush();
//            out.close();
            String savepath = UtilsHelper.getRandomNum(10)+".png";
            File file = new File(savepath);
            OutputStream output = new FileOutputStream(file);
            BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);
            bufferedOutput.write(b);
            bufferedOutput.flush();
            bufferedOutput.close();
            String cloudPath = uploadImage(file);
            if (file.exists())
            {
                file.delete();
            }
            return cloudPath;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    /**  
     * 图像切割（改）     *  
     * @param srcImageFile            源图像地址 
     * @param dirImageFile            新图像地址 
     * @param x                       目标切片起点x坐标 
     * @param y                      目标切片起点y坐标 
     * @param destWidth              目标切片宽度 
     * @param destHeight             目标切片高度 
     */
    public static void abscut(String srcImageFile,String dirImageFile, int x, int y, int destWidth,  
            int destHeight) {  
        try {  
            Image img;  
            ImageFilter cropFilter;  
            // 读取源图像  
            BufferedImage bi = ImageIO.read(new File(srcImageFile));  
            int srcWidth = bi.getWidth(); // 源图宽度  
            int srcHeight = bi.getHeight(); // 源图高度            
            if (srcWidth >= destWidth && srcHeight >= destHeight) {  
                Image image = bi.getScaledInstance(srcWidth, srcHeight,  
                        Image.SCALE_DEFAULT);  
                // 改进的想法:是否可用多线程加快切割速度  
                // 四个参数分别为图像起点坐标和宽高  
                // 即: CropImageFilter(int x,int y,int width,int height)  
                cropFilter = new CropImageFilter(x, y, destWidth, destHeight);
                img = Toolkit.getDefaultToolkit().createImage(  
                        new FilteredImageSource(image.getSource(), cropFilter));  
                BufferedImage tag = new BufferedImage(destWidth, destHeight,  
                        BufferedImage.TYPE_INT_RGB);  
                Graphics g = tag.getGraphics();  
                g.drawImage(img, 0, 0, null); // 绘制缩小后的图  
                g.dispose();  
                // 输出为文件  
                ImageIO.write(tag, "JPEG", new File(dirImageFile));  
            }  
        } catch (Exception e) {
        	logger.error(e); 
        	e.printStackTrace(); 
        }  
    }  
    public static void cut(InputStream is,File dirImageFile, int x, int y, int destWidth,  
            int destHeight) throws IOException {  
        cut(ImageIO.read(is),dirImageFile,x,y,destWidth,destHeight);
    }  
    public static void cut(BufferedImage bi,File dirImageFile, int x, int y, int destWidth,  
            int destHeight) {  
        try {  
            Image img;  
            ImageFilter cropFilter;  
            // 读取源图像  
            int srcWidth = bi.getWidth(); // 源图宽度  
            int srcHeight = bi.getHeight(); // 源图高度            
            if (srcWidth >= destWidth && srcHeight >= destHeight) {  
                Image image = bi.getScaledInstance(srcWidth, srcHeight,  
                        Image.SCALE_DEFAULT);  
                // 改进的想法:是否可用多线程加快切割速度  
                // 四个参数分别为图像起点坐标和宽高  
                // 即: CropImageFilter(int x,int y,int width,int height)  
                cropFilter = new CropImageFilter(x, y, destWidth, destHeight);
                img = Toolkit.getDefaultToolkit().createImage(  
                        new FilteredImageSource(image.getSource(), cropFilter));  
                BufferedImage tag = new BufferedImage(destWidth, destHeight,  
                        BufferedImage.TYPE_INT_RGB);  
                Graphics g = tag.getGraphics();  
                g.drawImage(img, 0, 0, null); // 绘制缩小后的图  
                g.dispose();  
                // 输出为文件  
                ImageIO.write(tag, "JPEG", dirImageFile);  
            }  
        } catch (Exception e) {  
        	logger.error(e);
        	e.printStackTrace(); 
        }  
    }   
    /** 
     * 缩放图像 
     *  
     * @param srcImageFile       源图像文件地址 
     * @param result             缩放后的图像地址 
     * @param scale              缩放比例 
     * @param flag               缩放选择:true 放大; false 缩小; 
     */  
    public static void scale(String srcImageFile, String result, int scale,  
            boolean flag) {  
        try {  
            BufferedImage src = ImageIO.read(new File(srcImageFile)); // 读入文件  
            int width = src.getWidth(); // 得到源图宽  
            int height = src.getHeight(); // 得到源图长  
            if (flag) {  
                // 放大  
                width = width * scale;  
                height = height * scale;  
            } else {  
                // 缩小  
                width = width / scale;  
                height = height / scale;  
            }  
            Image image = src.getScaledInstance(width, height,Image.SCALE_DEFAULT);  
            BufferedImage tag = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);  
            Graphics g = tag.getGraphics();  
            g.drawImage(image, 0, 0, null); // 绘制缩小后的图  
            g.dispose();  
            ImageIO.write(tag, "JPEG", new File(result));// 输出到文件流  
        } catch (IOException e) {  
        	logger.error(e);
        	e.printStackTrace(); 
        }  
    }  

    /** 
     * 重新生成按指定宽度和高度的图像 
     * @param srcImageFile       源图像文件地址 
     * @param result             新的图像地址 
     * @param _width             设置新的图像宽度 
     * @param _height            设置新的图像高度 
     */  
    public static void scale(String srcImageFile, String result, int _width,int _height) {        
        scale(srcImageFile,result,_width,_height,0,0);  
    }  

    public static void scale(String srcImageFile, String result, int _width,int _height,int x,int y) {  
        try {  

            BufferedImage src = ImageIO.read(new File(srcImageFile)); // 读入文件  

            int width = src.getWidth(); // 得到源图宽  
            int height = src.getHeight(); // 得到源图长  

            if (width > _width) {  
                 width = _width;  
            }  
            if (height > _height) {  
                height = _height;  
            }             
            Image image = src.getScaledInstance(width, height,Image.SCALE_DEFAULT);  
            BufferedImage tag = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);  
            Graphics g = tag.getGraphics();  
            g.drawImage(image, x, y, null); // 绘制缩小后的图  
            g.dispose();              
            ImageIO.write(tag, "JPEG", new File(result));// 输出到文件流  
        } catch (IOException e) {
        	logger.error(e); 
            e.printStackTrace();  
        }  
    }  

    /** 
     * 图像类型转换 GIF->JPG GIF->PNG PNG->JPG PNG->GIF(X) 
     */  
    public static void convert(String source, String result) {  
        try {  
            File f = new File(source);  
            f.canRead();  
            f.canWrite();  
            BufferedImage src = ImageIO.read(f);  
            ImageIO.write(src, "JPG", new File(result));  
        } catch (Exception e) {
        	logger.error(e); 
            e.printStackTrace();  
        }  
    }  

    /** 
     * 彩色转为黑白 
     *  
     * @param source 
     * @param result 
     */  
    public static void gray(String source, String result) {  
        try {  
            BufferedImage src = ImageIO.read(new File(source));  
            ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);  
            ColorConvertOp op = new ColorConvertOp(cs, null);  
            src = op.filter(src, null);  
            ImageIO.write(src, "JPEG", new File(result));  
        } catch (IOException e) { 
        	logger.error(e);
            e.printStackTrace();  
        }  
    }     
}  
