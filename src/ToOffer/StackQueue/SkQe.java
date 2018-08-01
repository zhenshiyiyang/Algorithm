package ToOffer.StackQueue;

import java.util.Stack;
//用两个栈实现一个队列的入队和出队的操作。
public class SkQe {
	 static Stack<Integer> s1 = new Stack<Integer>();
	 static Stack<Integer> s2 = new Stack<Integer>();
     public static void main(String[] args){
    	 
     }
     public static void appendTail(int val){
    	 s1.push(val);
     }
     public static int deleteHead(){
    	 Integer val = 0;
    	 if(!s2.isEmpty()){
    		 val = s2.pop();
    	 }else{
	    	 while(!s1.isEmpty()){
	    		 s2.push(s1.pop());
	    	 }
	    	 //记住pop操作是一次一个，而不是一次全部pop完
	    	 if(!s2.isEmpty()){
	    		 val = s2.pop();
	    	 }
    	 }
    	 return val;
     }
}
