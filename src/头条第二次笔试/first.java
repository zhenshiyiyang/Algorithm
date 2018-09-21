package 头条第二次笔试;

import java.util.Scanner;
import java.util.Stack;

public class first {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String path = in.next();
        String[] str = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals(".") || str[i].length() == 0)
                continue;
            else if (!str[i].equals(".."))
                stack.push(str[i]);
            else {
                if (!stack.isEmpty())
                    stack.pop();
            }
        }

        if (stack.isEmpty()) {
            System.out.println("/" + "");
        } else {
            int i = 0;
            String result = "";
            while(!stack.isEmpty()) {
                result += "/";
                result += stack.remove(i);
            }
            System.out.println(result);
        }
    }
}