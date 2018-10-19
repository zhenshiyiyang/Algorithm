package leetCode;

public class ClimbStairs {
    public static void main(String[] args) {
         int n = 3;
         System.out.println(climbStairs(n));
    }
    public static int climbStairs(int n) {
         if(n<=0){
             return 0;
         }
         else if(n==1){
             return 1;
         }
         else if(n==2){
             return 2;
         }else{
             int[] res = new int[n];
             res[0] = 1;
             res[1] = 2;
             for (int i = 2; i < n; i++) {
                 res[i] = res[i-1]+res[i-2];
             }
             return res[n-1];
         }
    }
}
