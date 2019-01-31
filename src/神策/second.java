package 神策;

import java.util.Scanner;

public class second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            arr[i] = str;
        }
        for (int i = 0; i < n; i++) {
            if (isNumeric(arr[i])==true) {
                System.out.println("TRUE");
            }else{
                System.out.println("FALSE");
            }
        }
    }
    public static boolean isNumeric(String string) {
        if(string.contains(".")){
            int n = string.indexOf(".");
            if(n==0 || n==string.length()-1){
                return false;
            }else if(isNum(string.substring(n-1,n).toCharArray())&&isNum(string.substring(n,n+1).toCharArray())){
                return true;
            }else{
                return isNum(string.toCharArray());
            }
        }else{
            return isNum(string.toCharArray());
        }
    }
    public static boolean isNum(char[] str){
        try {
            double re = Double.parseDouble(new String(str));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
