package test.com.jianti2fanti;

import com.spreada.utils.chinese.ZHConverter;

public class Test {
	 public static void main(String[] args) throws Exception {  
		 
	        ZHConverter converter = ZHConverter.getInstance(ZHConverter.SIMPLIFIED);  
	        String traditionalSrc = "喬乔";  
	        String simplified = converter.convert(traditionalSrc);  
	        System.out.println(simplified);  
	  
	  
	        // Or   
	        String simplifiedSrc = "乔喬";  
	        String traditional = ZHConverter.convert(simplifiedSrc, ZHConverter.TRADITIONAL);  
	        System.out.println(traditional);      
	    }  
}
