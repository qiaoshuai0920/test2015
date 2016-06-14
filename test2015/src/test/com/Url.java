package test.com;

import java.net.URLDecoder;
import java.net.URLEncoder;

import com.sun.xml.internal.fastinfoset.Encoder;

public class Url {
	
	public static void main(String[] args) {
		
		
		
		//%E5%88%98%E5%85%AC%E5%B2%9B
		String asd=URLEncoder.encode("");
		System.out.println(asd);
		String asdasd=URLDecoder.decode("%E5%88%98%E5%85%AC%E5%B2%9B");
		System.out.println(asdasd);
		
		
		
	}

}
