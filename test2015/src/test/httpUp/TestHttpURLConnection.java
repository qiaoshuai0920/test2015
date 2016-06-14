package test.httpUp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;





public class TestHttpURLConnection {
	
	  public static String test(String action,String json,String type){
	    	
	    	StringBuffer buffer = new StringBuffer();

	        URL url;

	       try {

	           url = new URL(action);

	           HttpURLConnection http = (HttpURLConnection) url.openConnection();

	           // 设定请求的方法为"POST"，默认是GET  
	           http.setRequestMethod(type);

	           // 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
	           // 意思是正文是urlencoded编码过的form参数，下面我们可以看到我们对正文内容使用URLEncoder.encode
	           // 进行编码
	           http.setRequestProperty("Content-Type",

	                   "application/x-www-form-urlencoded");

	           http.setDoOutput(true);

	           http.setDoInput(true);

	           
	           /* 
	            * 超时设置，防止 网络异常的情况下，可能会导致程序僵死而不继续往下执行 
	            */  
	             
	           //JDK 1.5以前的版本，只能通过设置这两个系统属性来控制网络超时:  
	           //连接主机的超时时间（单位：毫秒）  
	          // System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
	          //从主机读取数据的超时时间（单位：毫秒）  
	          // System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
	           
	           
	           //在JDK 1.5以后可以这样来设置超时时间  
	           http.setConnectTimeout(30000);  
	           http.setReadTimeout(30000);  
	           

	           if ("GET".equalsIgnoreCase(type)){
					http.connect();
	           }
	           
	           if (null != json) {

	        	   OutputStream os = http.getOutputStream();

	        	   os.write(json.getBytes("UTF-8"));// 传入参数

	        	   os.flush();

	        	   os.close();

	           }


	        // 将返回的输入流转换成字符串
				InputStream inputStream = http.getInputStream();
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

				String str = null;
				while ((str = bufferedReader.readLine()) != null) {
					buffer.append(str);
				}
				bufferedReader.close();
				inputStreamReader.close();
				// 释放资源
				inputStream.close();
				inputStream = null;
				http.disconnect();

	           System.out.println("请求返回结果:"+buffer.toString());

	       } catch (Exception e) {

	           e.printStackTrace();

	       }
	       
	       return buffer.toString();

	    }
}
