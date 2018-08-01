package 爱奇艺;

import java.util.Scanner;
/*别人写的代码
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
public class third {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int last = in.nextInt();
        int count = 1;
        while (in.hasNextInt()) {
        	count++;
            int now = in.nextInt();
            if(now != last) {
            	if(count == 2) {
            		if(now == in.nextInt()) {
            			System.out.println(1);
            			return;
            		}
            	}
            	System.out.println(count);
            	return;
            }
            last = now;
        }
	}
}
