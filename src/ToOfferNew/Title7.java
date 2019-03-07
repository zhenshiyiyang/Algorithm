package ToOfferNew;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Title7 {
    /*
      用两个栈实现队列
    */
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();
    public static void push(int value){
        stack1.push(value);
    }
    public static int pop(){
        Integer val = 0;
        if(!stack2.isEmpty()){
            val = stack2.pop();
        }else{
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            /*记住pop操作是一次一个，而不是一次全部pop完*/
            if(!stack2.isEmpty()){
                val = stack2.pop();
            }
        }
        return val;
    }
    /*
      扩展：利用两个队列实现栈
     */
    static Queue<Integer> queue1 = new ArrayDeque<>();
    static Queue<Integer> queue2 = new ArrayDeque<>();
    public static void push_queue(int value){
        //两个队列都为空，优先考虑队列1进行插入
        if(queue1.isEmpty()&&queue2.isEmpty()){
            queue1.add(value);
            return;
        }
        //如果有一个队列不为空，则插入不为空的队列
        if(queue1.isEmpty()){
            queue2.add(value);
            return;
        }
        if(queue2.isEmpty()){
            queue1.add(value);
            return;
        }
    }
    public static int pop_queue(){
        //两个队列都为空时，没有元素可以弹出
        if(queue1.isEmpty()&&queue2.isEmpty()){
            try{
                throw new Exception("stack is empty");
            }catch (Exception e){

            }
        }
        //如果queue1为空，queue2有元素， 将queue2的元素依次放入queue1中，直到最后一个元素，我们弹出。
        if(queue1.isEmpty()){
            while(queue2.size()>1){
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        }
        //同理
        if(queue2.isEmpty()){
            while(queue1.size()>1){
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        }
        return (Integer)null;
    }
}
