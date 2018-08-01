package 华为;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class second {
	public static int dayForWeek(String pTime) throws Exception {
		  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		  Calendar c = Calendar.getInstance();
		  c.setTime(format.parse(pTime));
		  int dayForWeek = 0;
		  if(c.get(Calendar.DAY_OF_WEEK) == 1){
		      dayForWeek = 0;
		  }else{
		      dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		  }
		  return dayForWeek;
    }
	public static void main(String[] args) throws Exception{
		    Scanner in = new Scanner(System.in);
			int n = in.nextInt();
			int year_start = 1990;
			int year_end = 1990+n-1;
			int week = in.nextInt();
			if(n>400 || week<0 || week>6){
				System.out.println("-1");
                return;
			}
			int count = 0;
			for(int i=year_start;i<=year_end;i++){
				for(int j=1;j<=12;j++){
					String str = String.valueOf(i)+"-"+String.valueOf(j)+"-13";
					if(dayForWeek(str)==week){
						count++;
					}
				}
			}
			System.out.println(count);
	}
}
