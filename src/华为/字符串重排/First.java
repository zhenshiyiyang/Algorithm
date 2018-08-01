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
 * (1)原始字符串中仅可能出现"数字"和"字母"；
 * (2)请注意区分字母大小写。
 * 输入描述：
 * eeefgghhh
 * 输出描述：
 * efghegheh
 * 
 */
public class First {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.next();
            int[] array=new int[10000];
            for (int i = 0; i < str.length(); i++)
            	array[str.charAt(i)]++;
            int temp = 1;
            while (temp==1)
            {
                temp = 0;
                for (int j = 48; j <= 122; ++j)
                    if (array[j] > 0)
                    {
                        System.out.print((char) j);
                        array[j]--;
                        temp = 1;
                    }
            }
            System.out.println();
        }
    }
}