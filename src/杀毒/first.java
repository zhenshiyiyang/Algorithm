package 杀毒;

import java.util.HashSet;
import java.util.Scanner;

public class first {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(circul(x,c));
    }
    public static int circul(int x,int c){
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        int k = 0;
        while(true){
            int tmp = (int) (Math.pow(x,k) %c);
            if(set.contains(tmp)){
                break;
            }
            else{
                set.add(tmp);
                res++;
                k++;
            }
        }
        return res;
    }
}
