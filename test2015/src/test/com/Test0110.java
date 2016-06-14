package test.com;

import java.util.Arrays;

public class Test0110 {

	public static void main(String[] args) {
		CLA c1=null;
		String qqq="";
		String[] str;
	 	CLA[] classs = null ;
	 	
	 	c1.name="name";
	 	c1.pass="123";
	 	classs[0]=c1;
		String asd="a,b,c,d";
		str=asd.split(",");
		
		System.out.println(str);
		System.out.println(Arrays.toString(str));
		for(int i=0;i<str.length;i++){
			//System.out.println(str[i]);
			qqq+=str[i]+",";
		}
		System.out.println("{"+qqq+"}");
	}
	
	class CLA{
		String name;
		String pass;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPass() {
			return pass;
		}
		public void setPass(String pass) {
			this.pass = pass;
		}
		
	}
}
