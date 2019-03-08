package ToOfferNew;

import java.util.ArrayList;
import java.util.Stack;

public class Title22 {
    //栈的压入、弹出序列
    public static boolean IsPopOrder(ArrayList<Integer> pushA,ArrayList<Integer> popA){
        if(pushA.size()!=popA.size()){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.size(); i++) {
            stack.push(pushA.get(i));
            while(!stack.isEmpty()&&stack.peek()==popA.get(j)){
                stack.pop();
                j++;
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
