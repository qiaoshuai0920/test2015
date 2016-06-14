package test.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test1103 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//FileTransferWsProxy p = new FileTransferWsProxy();  //生成webservice代理对象
        
        String filePath = "d:/272.jpg";
        String fileName = "1.jpg";
        
        File file = new File(filePath);
        
        FileInputStream in = new FileInputStream(file);
        
        byte []bs = new byte[in.available()];
        
        in.read(bs);
        
        in.close();
        
        System.out.println("正在传输文件“" + fileName + "”");
        //p.uploadFile(bs, fileName);  //调用webservice进行文件上传
        System.out.println("文件传输完毕");
        System.out.println(bs);
        
        
        FileOutputStream out = null;
        File newFile =new File("D:/123.jpg");
		 //String newFile = "D:/tmp/123.jpg" ; 
		 
	        try {
	               //上传文件存放路径
	            out = new FileOutputStream(newFile);
	            try {
	                out.write(bs);
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	           
	        } finally  {
	            if (out != null) {
	                try {
	                    out.close();
	                } catch (IOException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	            }
	        }
	}
	
	
	

}
