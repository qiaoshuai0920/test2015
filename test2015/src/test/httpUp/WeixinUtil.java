package test.httpUp;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;



/**
 * 公众平台通用接口工具类
 * 
 * @author liuyq
 * @date 2013-08-09
 */
public class WeixinUtil {


	
	// 头像上传（POST） 限未知
	public static String head_upload_url = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";
	
	
	
	
	
	
	/**
	 * 向微信服务器上传文件
	 * 
	 * @param accessToken
	 *            进入的接口
	 * @param type
	 *            文件类型(语音或者是图片)(对于文档不适合)
	 * @param url
	 *            文件的存储路径
	 * @return json的格式{"media_id":
	 *         "nrSKG2eY1E_svLs0Iv2Vvh46PleKk55a47cNO1ZS5_pdiNiSXuijbCmWWc8unzBQ"
	 *         ,"created_at":1408436207,"type":"image"}
	 */

	   public static String uploadFile(String url0, File file)

	           throws Exception {

	       // 上传文件请求路径

	       URL url = new URL(url0);

	       String result = null;

	       // File file = new File(filePath);

	       if (!file.exists() || !file.isFile()) {

	           throw new IOException("上传的文件不存在");

	       }

	       HttpURLConnection con = (HttpURLConnection) url.openConnection();

	       con.setRequestMethod("POST"); // 以Post方式提交表单，默认get方式

	       con.setDoInput(true);

	       con.setDoOutput(true);

	       con.setUseCaches(false); // post方式不能使用缓存

	       // 设置请求头信息

	       con.setRequestProperty("Connection", "Keep-Alive");

	       con.setRequestProperty("Charset", "UTF-8");

	       // 设置边界

	       String BOUNDARY = "----------" + System.currentTimeMillis();

	       con.setRequestProperty("Content-Type", "multipart/form-data; boundary="

	               + BOUNDARY);

	       // 请求正文信息

	       // 第一部分：

	       StringBuilder sb = new StringBuilder();

	       sb.append("--"); // 必须多两道线

	       sb.append(BOUNDARY);

	       sb.append("\r\n");

	       sb.append("Content-Disposition: form-data;name=\"picFile\";filename=\""

	               + file.getName() + "\"\r\n");

	       sb.append("Content-Type:application/octet-stream\r\n\r\n");

	       byte[] head = sb.toString().getBytes("utf-8");

	       // 获得输出流

	       OutputStream out = new DataOutputStream(con.getOutputStream());

	       // 输出表头

	       out.write(head);

	       // 文件正文部分

	       // 把文件已流文件的方式 推入到url中

	       DataInputStream in = new DataInputStream(new FileInputStream(file));

	       int bytes = 0;

	       byte[] bufferOut = new byte[1024];

	       while ((bytes = in.read(bufferOut)) != -1) {

	           out.write(bufferOut, 0, bytes);

	       }

	       in.close();

	       // 结尾部分

	       byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线

	       out.write(foot);

	       out.flush();

	       out.close();

	       StringBuffer buffer = new StringBuffer();

	       BufferedReader reader = null;

	       try {

	           // 定义BufferedReader输入流来读取URL的响应

	           reader = new BufferedReader(new InputStreamReader(con

	                   .getInputStream()));

	           String line = null;

	           while ((line = reader.readLine()) != null) {

	               buffer.append(line);

	           }

	           if (result == null) {

	               result = buffer.toString();

	           }

	       } catch (IOException e) {

	           System.out.println("发送POST请求出现异常！" + e);

	           e.printStackTrace();

	           throw new IOException("数据读取异常");

	       } finally {

	           if (reader != null) {

	               reader.close();

	           }

	       }


	       return result;

	   }
	   
	   
	   
	   
	   
	 	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
//	   /**
//
//	     * 微信公共账号发送给账号
//
//	     * @param content 文本内容
//
//	     * @param toUser 微信用户  
//
//	     * @return
//
//	     */
//
//	    public  void sendTextMessageToUser(String content,String toUser){
//
//	       String json = "{\"touser\": \""+toUser+"\",\"msgtype\": \"text\", \"text\": {\"content\": \""+content+"\"}}";
//
//	       //获取access_token
//
//	       GetExistAccessToken getExistAccessToken = GetExistAccessToken.getInstance();
//
//	       String accessToken = getExistAccessToken.getExistAccessToken();
//
//	       //获取请求路径
//
//	       String action = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+accessToken;
//
//	       System.out.println("json:"+json);
//
//	       try {
//
//	           connectWeiXinInterface(action,json);
//
//	       } catch (Exception e) {
//
//	           e.printStackTrace();
//
//	       }
//
//	   }
//
//	    /**
//
//	     * 微信公共账号发送给账号(本方法限制使用的消息类型是语音或者图片)
//
//	     * @param mediaId 图片或者语音内容
//
//	     * @param toUser 微信用户  
//
//	     * @param messageType 消息类型
//
//	     * @return
//
//	     */
//
//	    public  void sendPicOrVoiceMessageToUser(String mediaId,String toUser,String msgType){
//
//	        String json=null;
//
//	        if(msgType.equals(REQ_MESSAGE_TYPE_IMAGE)){
//
//	             json = "{\"touser\": \""+toUser+"\",\"msgtype\": \"image\", \"image\": {\"media_id\": \""+mediaId+"\"}}";
//
//	        }else if(msgType.equals(REQ_MESSAGE_TYPE_VOICE)){
//
//	            json = "{\"touser\": \""+toUser+"\",\"msgtype\": \"voice\", \"voice\": {\"media_id\": \""+mediaId+"\"}}";
//
//	        }
//
//	        //获取access_token
//
//	       GetExistAccessToken getExistAccessToken = GetExistAccessToken.getInstance();
//
//	       String accessToken = getExistAccessToken.getExistAccessToken();
//
//	       //获取请求路径
//
//	       String action = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+accessToken;
//
//	       try {
//
//	           connectWeiXinInterface(action,json);
//
//	       } catch (Exception e) {
//
//	           e.printStackTrace();
//
//	       }
//
//	   }
//
//	    /**
//
//	     *  发送图文给所有的用户
//
//	     * @param openId 用户的id
//
//	     */
//
//	    public  void sendNewsToUser(String openId){
//
//	        MediaUtil mediaUtil = MediaUtil.getInstance();
//
//	        ArrayList<Object> articles = new ArrayList<Object>();
//
//	       Article a = new Article();
//
//	       articles.add(a);
//
//	       String str = JsonUtil.getJsonStrFromList(articles);
//
//	        String json = "{\"touser\":\""+openId+"\",\"msgtype\":\"news\",\"news\":" +
//
//	                "{\"articles\":" +str +"}"+"}";
//
//	        json = json.replace("picUrl", "picurl");
//
//	        System.out.println(json);
//
//	        //获取access_token
//
//	       String access_token = mediaUtil.getAccess_token();
//
//	       //获取请求路径
//
//	       String action = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+access_token;
//
//	       try {
//
//	           connectWeiXinInterface(action,json);
//
//	       } catch (Exception e) {
//
//	           e.printStackTrace();
//
//	       }
//
//	    }

	    /**

	     * 连接请求微信后台接口

	     * @param action 接口url

	     * @param json  请求接口传送的json字符串

	     */

	    public static String connectInterface(String action,String json,String type){
	    	
	    	StringBuffer buffer = new StringBuffer();

	        URL url;

	       try {

	           url = new URL(action);

	           HttpURLConnection http = (HttpURLConnection) url.openConnection();

	           http.setRequestMethod(type);

	           http.setRequestProperty("Content-Type",

	                   "application/x-www-form-urlencoded");

	           http.setDoOutput(true);

	           http.setDoInput(true);

	           System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒

	           System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒

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