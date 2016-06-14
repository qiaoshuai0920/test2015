package test.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJdbcSqlserver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // 加载JDBC驱动

	        //SQL SERVER 2008：使用localhost,127.0.0.1和本机实际ip192.168.0.101都可以连接SQL SERVER 2008
	        //String dbURL = "jdbc:sqlserver://localhost:5419;DatabaseName=InsideTSQL2008";
	        //String dbURL = "jdbc:sqlserver://127.0.0.1:5419;DatabaseName=InsideTSQL2008"; 
	        //String dbURL = "jdbc:sqlserver://192.168.0.101:5419;DatabaseName=InsideTSQL2008"; 
	        
	        //SQL SERVER 2012：端口号从原来的5419变成了5413，数据库名称变成了TSQL2012
	        //跟上述SQL SERVER 2008一样，可以使用localhost，127.0.0.1和192.168.0.101
	        //String dbURL = "jdbc:sqlserver://localhost:5413;DatabaseName=TSQL2012"; 
	        //String dbURL = "jdbc:sqlserver://127.0.0.1:5413;DatabaseName=TSQL2012"; 
	        String dbURL = "jdbc:sqlserver://192.168.1.56:1433;DatabaseName=ythz"; 
	    
	        String userName = "sa"; // 用户名
	        String userPwd = "sql2005"; // 密码

	        try {
	            // 加载SQLSERVER JDBC驱动程序
	            Class.forName(driverName);
	            //建立数据库连接
	            Connection connect = DriverManager.getConnection(dbURL, userName,userPwd);
	            Statement stmt = connect.createStatement();
	            ResultSet rs = stmt.executeQuery("select * from t_info_activity;");
	            while (rs.next()) {
	                System.out.println(rs.getString("activity_name"));
	            }
	        } catch (ClassNotFoundException e) {
	            System.out.print("Error loading SQLServer Driver!");
	            e.printStackTrace();
	        } catch (Exception e) {
	            System.out.print("get data error!");
	            e.printStackTrace();
	        }

	}

}
