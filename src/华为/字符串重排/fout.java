package 华为.字符串重排;
import java.util.Scanner;
/*
 * 字符串重排，给你一个原始字符串，根据该字符串内每个字符出现的
 * 次数，按照ASCⅡ码递增顺序重新调整输出。
 * 举例，假设原始字符串为：
 * eeefgghhh
 * 则每种字符出现的次数分别为：
 * (1).eee       3次
 * (2).f         1次
 * (3).gg        2次
 * (4).hhh       3次
 * 重排输出后的字符串如下：
 * efghegheh
 * 编写程序，实现上述功能。
 * 【温馨提示】
 * 输入描述：
 * eeefgghhh
 * 输出描述：
 * efghegheh
 * 
 */
public class fout {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		StringBuilder sb = new StringBuilder();
		char[] tmp = input.toCharArray();
		int[] arr = new int[70];
		for (int i = 0; i < tmp.length; i++) {
			char c = tmp[i];
			int k = c;
			if(k>=48&&k<=57) {
				arr[k-48]++;
			}else if(k>=65&&k<=90) {
				arr[k-55]++;
			}else {
				arr[k-61]++;
			}
		}
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>max)
				max = arr[i];
		}
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[j]!=0) {
					if(j<=9) {
						sb.append((char)(j+48));
						arr[j]--;
					}else if(j<=35){
						sb.append((char)(j+55));
						arr[j]--;
					}else {
						sb.append((char)(j+61));
						arr[j]--;
					}
				}
			}
		}
		System.out.println(sb);
    }
}
