package test.com;

import java.io.IOException;
import java.net.URL;

import test.httpUp.HttpPostUtil;

public class Test0123 {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://60.216.117.244/nxcj/json/upload/uploadImage.action");
		//URL url = new URL("http://www.baidu.com");
		int port = url.getPort() == -1 ? 80 : url.getPort();
		System.out.println(url.getPort());
		System.out.println(port);
	}
}
