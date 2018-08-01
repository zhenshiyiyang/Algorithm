package 爱奇艺;

import java.util.Scanner;
/*自己写的代码
 * 找次品，
 * 每个输入包含一个测试用例，
 * 每个测试用例的第一行包含一个正整数，表示玩偶的数量N(3<=N<=1000000)
 * 接下来一行包含N个正整数，第i个正整数表示第i个玩偶的重量为Wi(Wi<=1000000)
 * 数据保证有且仅有一个次品与其他玩偶重量不同，并且除次品外其他玩偶质量都一样。
 * 输出描述：
 * 输出一个正整数表示次品是第几个玩偶。
 * 事例：
 * 输入：
 * 3
 * 2 3 3
 * 输出：
 * 1
 */
public class frist {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int num = in.nextInt();
	        if(num<3){
	        	return;
	        }else{
		        int a = in.nextInt();
	            int b = in.nextInt();
	            int c = in.nextInt();
		        int count = 3;
	            if(a!=b){
	            	if(a==c){
	            	  System.out.println(2);
	            	  return;
	            	}
	            	System.out.println(1);
	            }else{
	            	if(b!=c){
	            		System.out.println(count);
	            	}else{
				        while (in.hasNextInt()) {
			            	b = c;
				            count++;
				            if(count>num){
				            	return;
				            }
				            c = in.nextInt();
				            if(b!=c){
				            	System.out.println(count);
				            	return;
				            }
				        }
	            	}
	            }
	        }
	 }
}
