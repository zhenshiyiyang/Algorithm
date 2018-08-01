package 华为.大数相乘;
import java.util.Scanner;
/*
 * 编写“长整数相乘”程序，实现两个任意长度的长整数（正数）相乘，
 * 输出结果。
 * 输入描述：
 * 第一行输入数字A的字符串，字符范围（0~9），第二行输入数字B的字符串，字符
 * 范围（0~9）。
 * 输出描述：
 * 输出A、B俩数相乘的结果，结果为字符串。
 * 示例1
 * 输入：
 * 1234
 * 4321
 * 输出：
 * 5332114
 * 说明:
 * 第一排数字*第二排数字
 */
public class Third {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	String num1 = in.nextLine();
    	String num2 = in.nextLine();
        System.out.println(mul(num1, num2));
    }
    public static String mul(String num1, String num2) {
        int num1_len = num1.length();
        int num2_len = num2.length();
        int[] num = new int[num1_len+num2_len];
        for(int i=0;i<num1_len;i++) {
            int n1=num1.charAt(num1_len-1-i)-'0';
            int temp=0;
            for(int j=0;j<num2_len;j++) {
                int n2=num2.charAt(num2_len-1-j)-'0';
                temp=temp+num[i+j]+n1*n2;
                num[i+j]=temp%10;
                temp/=10;
            }
            num[i+num2_len]=temp;
        }
        int i=num1_len+num2_len-1;
        while(i>0&&num[i]==0){
            i--;
        }
        String result="";
        while(i>=0) {
            result += num[i--];
        }
       return result;
    }
}
