package test.com;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTransferWs {
	
	 public int uploadFile(byte []bs, String fileName) {
	        FileOutputStream out = null;
	        try {
	            String newFile = "C:/tmp/" + fileName;    //上传文件存放路径
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
	            return -1;
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
	        return 0;
	    }

}
