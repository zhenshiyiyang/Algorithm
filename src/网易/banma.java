package 网易;

import java.util.Scanner;

public class banma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] c = str.toCharArray();
        int max = 0;
        int count = 1;
        for (int i = 0; i < c.length - 1; i++) {
            if (c[i] != c[i + 1]) {
                count++;
                if (count >= max) {
                    max = count;
                }
            } else {
                if (count >= max) {
                    max = count;
                    count = 1;
                } else {
                    count = 1;
                }
            }
        }
        for(int j=0;j<str.length()-1;j++) {
            String str1 = str.substring(0,j);
            String str2 = str.substring(j+1,str.length()-1);
            String rev1 = new StringBuilder(str1).reverse().toString();
            String rev2 = new StringBuilder(str2).reverse().toString();
            char[] c2 = (rev1+rev2).toCharArray();
            count = 1;
            for (int i = 0; i < c2.length - 1; i++) {
                if (c2[i] != c2[i + 1]) {
                    count++;
                    if (count >= max) {
                        max = count;
                    }
                } else {
                    if (count >= max) {
                        max = count;
                        count = 1;
                    } else {
                        count = 1;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
