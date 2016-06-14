package test.com;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbcsql2005 {
	public static void main(String[] args) {

		  String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  //加载JDBC驱动
		  String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=ythz";  //连接服务器和数据库sample
		  String userName = "sa";  //默认用户名
		  String userPwd = "sql2005";  //密码
		  Connection dbConn;

		  try {
		   Class.forName(driverName);
		   dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
		   System.out.println("Connection Successful!");  //如果连接成功 控制台输出Connection Successful!
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
	}

}
