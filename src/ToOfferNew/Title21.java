package ToOfferNew;

import java.util.Stack;
/*
  包含min函数的栈
 */
public class Title21 {
    public static Stack<Integer> stack = new Stack<>();
    public static Stack<Integer> stack_min = new Stack<>();
    //入栈
    public static void push(int value){
        stack.push(value);
        if(stack_min.size()==0 || value<stack_min.peek()){
            stack_min.push(value);
        }else{
            stack_min.push(stack_min.peek());
        }
    }
    //出栈
    public static int pop(){
        int value = stack.pop();
        stack_min.pop();
        return value;
    }
    //求栈的最小值
    public static int min(){
        return stack_min.peek();
    }
}
