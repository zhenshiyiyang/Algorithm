package ToOffer.knowledge;

public class Fibonacci {
     public static void main(String[] args){
    	 int n = 6;
    	 System.out.println(Fib(n));
     }
     public static int Fib(int n){
    	 int[] result = new int[]{0,1};
    	 if(n<2){
    		 return result[n];
    	 }
    	 int oneVal = 1;
    	 int twoVal = 0;
    	 int fib = 0;
    	 for(int i = 2; i <= n; i++){
    		 fib = oneVal + twoVal;
    		 int temp = oneVal;
    		 oneVal = fib;
    		 twoVal = temp;
    	 }
    	 return fib;
     }
}
