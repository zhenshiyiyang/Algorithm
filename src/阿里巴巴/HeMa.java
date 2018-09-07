package 阿里巴巴;

import java.util.Scanner;

public class HeMa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        if(first<3) {
            System.out.println("yes,0");
        }else{
            System.out.println("no,2");
        }
    }
}
