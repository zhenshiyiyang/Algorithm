package 链家;
import java.util.Scanner;
public class second {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            int j = 0;
            for(int i=1; i<=t; i++) {
                if(t%i==0) {
                    System.out.println(t + " 可以被 " + i + " 整除，商为 " + t/i + "。");
                    j++;
                }else if(j==0) {
                    System.out.println(t + "没有可以被整除的数。");
                }
            }
            System.out.println(j);
        }
}

