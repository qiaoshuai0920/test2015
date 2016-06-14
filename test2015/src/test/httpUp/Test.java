package test.httpUp;

import net.sf.json.JSONArray;

public class Test {
	
	
	public static void main(String[] args) {
		
		//JSONArray jsonArr = new JSONArray();
		String oriJsonObj=WeixinUtil.connectInterface("http://localhost:8080/ythz/json/passport/weixinLogin.action?passport.passportNum=001000405&passport.phoneNum=15653251234", null,"GET");
		//jsonArr = JSONArray.fromObject(oriJsonObj);
		 JSONArray array = JSONArray.fromObject(oriJsonObj);
		 System.out.println(array);

	
	}
}