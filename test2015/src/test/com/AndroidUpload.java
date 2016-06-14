package test.com;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import com.sun.org.apache.xml.internal.security.utils.Base64;

public class AndroidUpload {
	
	public static void main(String[] args) throws IOException {
		 File file=new File("d:/272.jpg");
	     FileInputStream fis = new FileInputStream(file);
	     ByteArrayOutputStream baos = new ByteArrayOutputStream();  
	     byte[] buffer = new byte[1024];  
         int count = 0;  
         while((count = fis.read(buffer)) >= 0){  
             baos.write(buffer, 0, count);  
         }  
         String uploadBuffer = new String(Base64.encode(baos.toByteArray()));  //进行Base64编码  
         fis.close();  
         writeSmilFile(uploadBuffer);
		System.out.println("uploadBuffer:"+uploadBuffer);
	}
	
	//写到txt
	public static void writeSmilFile(String content) {
		File file1 = new File( "d:/272.txt");
		try {
			file1.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter pw;
		try {
			 OutputStreamWriter os = null;
			 os = new OutputStreamWriter(new FileOutputStream(file1),"UTF-8");
			  os.write(content);
		        os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}
