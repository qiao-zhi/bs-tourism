package cn.qs;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
public static void main(String[] args) {
	 SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //加上时间
	String stime ="2019-03-29 00:00:00";
     //必须捕获异常
     try {
         Date sdate=sDateFormat.parse(stime);
         System.out.println(sdate);
     }catch(Exception e ){
    	 e.printStackTrace();
     }
}
}
