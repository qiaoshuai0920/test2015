package test.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

import sun.misc.BASE64Decoder;

public class Base64ToPic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a=readTxtFile("D:/272.txt");
		System.out.println(a);
		getPhotoByAndroid(a);
	}

	//获取客户端传来的图片文件 （  客户端处理是文件转换为流  Base64编码成字符串）
	public static String getPhotoByAndroid(String photoPath){
		
		//图片存放路径 放到正式需要修改
		String newFilePath="d:/";
		
		String newFileName =UUID.randomUUID().toString()+".jpg";
		 	FileOutputStream fos = null;
	        byte[] buffer;
			try {
				buffer = new BASE64Decoder().decodeBuffer(photoPath);
			 
			//对android传过来的图片字符串进行解码   
	        File destDir = new File(newFilePath);    
	        if(!destDir.exists()) destDir.mkdir();  
	        fos = new FileOutputStream(new File(destDir,newFileName));   //保存图片  
	        fos.write(buffer);  
	        fos.flush();  
	        fos.close(); 
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        System.out.println("上传图片成功!" + "图片路径为：" + newFilePath+newFileName);   
		return newFileName;
		
	}
	
	
	 public static String readTxtFile(String filePath){
		 String text="";
	        try {
	                String encoding="utf-8";
	                File file=new File(filePath);
	                if(file.isFile() && file.exists()){ //判断文件是否存在
	                    InputStreamReader read = new InputStreamReader(
	                    new FileInputStream(file),encoding);//考虑到编码格式
	                    BufferedReader bufferedReader = new BufferedReader(read);
	                    String lineTxt = null;
	                    while((lineTxt = bufferedReader.readLine()) != null){
	                      // System.out.println(lineTxt);
	                       text=text+ lineTxt;
	                       
	                    }
	                    read.close();
	        }else{
	            System.out.println("找不到指定的文件");
	        }
	        } catch (Exception e) {
	            System.out.println("读取文件内容出错");
	            e.printStackTrace();
	        }
	        return text;
	    }
	
}
