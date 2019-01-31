package 创新工场;

import java.util.Scanner;
import java.util.Stack;

public class second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String[] strs1 = str1.split(" ");
        int n = Integer.parseInt(strs1[0]);
        int m = Integer.parseInt(strs1[1]);
        char[] chars = str2.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(chars[m]);
        int loc = 0;
        for (int i = m+1; i < n; i++) {
            if(chars[i]=='{'){
                stack.push(chars[i]);
            }
            if(chars[i]=='('){
                stack.push(chars[i]);
            }
            if(chars[i]==')' && !stack.isEmpty()){
                stack.pop();
            }
            if(chars[i]=='}' && !stack.isEmpty()){
                stack.pop();
            }
            if(stack.isEmpty()){
               loc = i;
               break;
            }
        }
        System.out.println(loc);

    }
}
