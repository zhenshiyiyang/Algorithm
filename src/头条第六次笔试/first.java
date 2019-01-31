package 头条第六次笔试;

import java.util.Scanner;
public class first {
    public static final char UNDERLINE = '_';
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = sc.nextLine();
        }
        for (int i = 0; i < n; i++) {
            System.out.println(underscoreName(strings[i]));
        }
    }
    public static String underscoreName(String camelCaseName) {
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        if (camelCaseName != null && camelCaseName.length() > 0) {
            result.append(camelCaseName.substring(0, 1).toLowerCase());
            for (int i = 1; i < camelCaseName.length(); i++) {
                char ch = camelCaseName.charAt(i);
                if(i<camelCaseName.length()-1&&Character.isLowerCase(camelCaseName.charAt(i+1))){
                    flag = false;
                }
                if (Character.isUpperCase(ch) && flag == false) {
                    flag = true;
                    result.append("_");
                    result.append(Character.toLowerCase(ch));
                }else if(Character.isUpperCase(ch) && flag == true){
                    result.append(Character.toLowerCase(ch));
                }
                else {
                    flag = false;
                    result.append(ch);
                }
            }
        }
        return result.toString();
    }
}
