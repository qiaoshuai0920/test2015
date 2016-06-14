package test.com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test0630DateMonth {
	
	public static void main(String[] args) throws ParseException {
		//获取当前年份
		Calendar cNow = Calendar.getInstance();
		int year = cNow.get(Calendar.YEAR); 
		
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		date=format.parse(year+"-"+"02"+"-01");
		
        Calendar c = Calendar.getInstance();   
        c.setTime(date);
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        String first = format.format(c.getTime());
        System.out.println("===============first:"+first);
       
        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();  
        ca.setTime(date);
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH)); 
        String last = format.format(ca.getTime());
        System.out.println("===============last:"+last);
	}

}
