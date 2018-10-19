package 滴滴;

import java.util.Scanner;
import java.util.Stack;

public class second {
        private static Stack<String> stack = new Stack<String>();
        private static Stack<String> list = new Stack<String>();
        private static StringBuffer out = new StringBuffer();
        private static boolean flag = false;
        public static void main(String[] args) {
            list.push("4");
            list.push("3");
            list.push("2");
            list.push("1");
            Scanner sc = new Scanner(System.in);
            String str = "";
            for(int i=0;i<4;i++){
                str += sc.nextLine();
            }
            recur(str,flag);
            if (flag==true){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
        public static void recur(String s,boolean flag){//递归方法
            if(stack.empty() && list.empty()){//栈空，序列也空，则输出
                if(s.equals(out)){
                    flag = true;
                }
                return;
            } else if(!stack.empty() && !list.empty()){
                String str = stack.pop();
                out.append(str);
                recur(s,flag);
                out.deleteCharAt(out.length() - 1);
                stack.push(str);
                str = list.pop();
                stack.push(str);
                recur(s,flag);
                str = stack.pop();
                list.push(str);
            } else if(!stack.empty() && list.empty()){
                String str = stack.pop();
                out.append(str);
                recur(s,flag);
                out.deleteCharAt(out.length() - 1);
                stack.push(str);
            } else if(stack.empty() && !list.empty()){
                String str = list.pop();
                stack.push(str);
                recur(s,flag);
                str = stack.pop();
                list.push(str);
            }
        }
}
