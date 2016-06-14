package test.com;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;



public class JavaWriteTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println(	writeSmilFile("123asd阿斯顿撒"));
		

	}
	public static String writeSmilFile(String content) {
		
		/*File file = new java.io.File("d:/test");
		if (!file.exists()) {
			file.mkdir();
		}*/
		File file1 = new File( "d:/test/characterCode.txt");
		try {
			file1.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter pw;
		try {
			//pw = new PrintWriter(new FileWriter("d:/test/characterCode.txt"));
			//pw.print(content);
			//pw.close();
			 OutputStreamWriter os = null;
			 os = new OutputStreamWriter(new FileOutputStream(file1),"UTF-8");
			  os.write(content);
		        os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return  File.separator + "characterCode.txt";
	}
}
