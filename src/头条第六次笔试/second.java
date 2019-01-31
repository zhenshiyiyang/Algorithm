package 头条第六次笔试;

import java.util.Scanner;
import java.util.Stack;

public class second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack1 = new Stack<>();
        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch=='i'){
                if (!stack.isEmpty()){
                    stack1.push(stack.peek());
                    stack.pop();
                }
            }else if(ch=='o'){
                if(i!=0&&str.charAt(i-1)=='i'&&!stack1.isEmpty()){
                    stack.push(stack1.peek());
                    stack1.pop();
                }else{
                    if(!stack.isEmpty()) {
                        stack.pop();
                    }
                }
            }else{
                stack.push(ch);
            }
        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        System.out.println(result.reverse());
    }
}
