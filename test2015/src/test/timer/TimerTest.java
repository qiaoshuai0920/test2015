package test.timer;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
 
public class TimerTest {
    
    
     public static void main(String[] args)
      {
       Timer timer = new Timer();
      
       //每隔三秒执行一次
    
       timer.schedule(new MyTask(), 0, 3000);
      
      
      
          Date datetime= new Date();
         // SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         //  System.out.println(simpleDateFormat.format(datetime));
      
        Calendar calendar  =Calendar.getInstance(Locale.CHINA);
        //  System.out.println(calendar.get(calendar.YEAR)); 
        //  System.out.println(calendar.get(calendar.MONTH));//月份少一个月数
        //  System.out.println(calendar.get(calendar.DATE));
      
      
        calendar.set(2015,7,24,9,17,20 );//利用Calendar定义一个时间
         Date time =calendar.getTime(); //Calander转换成Date格式
        // System.out.println(simpleDateFormat.format(time));
      // timer.schedule(new MyTask(), time);
    
      
    
      }
 
 
 
     private static class MyTask extends TimerTask
      {
       public void run()
       {
       
       
          
           System.out.println("自己定义的时间到了!!!");
       }
      }
    
}