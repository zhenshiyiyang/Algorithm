package leetCode;

import java.util.Scanner;
import java.util.Stack;

public class IsValid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(isValid(str));
    }
    public static boolean isValid(String s) {
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < c.length; i++) {
            if(c[i]=='{' || c[i]=='(' || c[i]=='['){
                stack.push(c[i]);
            }else{
                if(stack.empty()) return false;
                if(c[i]==']' && stack.peek()!='[') return false;
                if(c[i]=='}' && stack.peek()!='{') return false;
                if(c[i]==')' && stack.peek()!='(') return false;
                stack.pop();
            }
        }
        return stack.empty();
    }
}
