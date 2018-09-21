package boss;

import java.util.Scanner;

public class first {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String string = sc.nextLine();
            int length = string.length();
            int max = 0;
            int dp[] = new int[length];
            int flag = 0;
            if (string.charAt(0) >= '0' && string.charAt(0) <= '9') {

                dp[0] = 1;
            }
            for (int i = 1; i < length; i++) {
                if (string.charAt(i) >= '0' && string.charAt(i) <= '9') {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = 0;
                }
            }
            for (int i = 0; i < dp.length; i++) {
                if (dp[i] > max) {
                    max = dp[i];
                    flag = i;
                }
            }
            String tmp = "";
            for (int i = 0; i < dp.length; i++) {
                if (dp[i] == max) {
                    tmp += string.substring(i - max + 1, i + 1);
                }
            }
            System.out.println(tmp);
        }
    }
}
