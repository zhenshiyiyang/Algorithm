package 链家;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/*木棍问题：在迷迷糊糊的大草原上，小红捡到了n根木棍,
 *第i根木棍的长度为i,小红现在很开心。 她想选出其中的
 *三根木棍组成美丽的三角形，但是小明想捉弄一下小红，
 *想去掉一些木棍，使得小红任意选三根木棍都不能组成三
 *角形。请问小明最少去掉多少根木棍。
 *本题包含若干组测试数据，对于每一组测试数据。
 *第一行一个n，表示木棍的数量，满足1<=n<=100000
 *输出：最少去掉多少个木棍？
 */
public class Wood {
	public static void main(String args[]){
	   int a = 1,b = 1,c = 1;
	   Set<Integer> set = new HashSet<Integer>();
	   Scanner sc = new Scanner(System.in);
	   int n = sc.nextInt();
	   while(c<=n){
		   if(c<=n){
			   set.add(c);
		   }
		   c = a + b;
		   b = c;
		   a = b;
	   }
	   System.out.println(n-set.size());
	}
}
