package test.com;

import java.io.File;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

public class TestDatahandler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		 String filePath = "D:/272.jpg";  
	        DataHandler dataHandler = new DataHandler(new FileDataSource(filePath));
	System.out.println(dataHandler);
	}

}
