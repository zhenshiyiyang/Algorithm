package ToOfferNew;
/*
  斐波那契数列
 */
public class Title9 {
    public static void main(String[] args) {
        System.out.println(Fibonacci(2));
    }
    //非递归
    public static int Fibonacci(int n){
        int[] result = {0,1};
        if(n<2){
            return result[n];
        }
        int one = 1;
        int two = 0;
        int fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = one + two;
            two = one;
            one = fibN;
        }
        return fibN;
    }
    //递归，效率不够高，存在很多重复计算
     public static int fib(int n){
        if(n<=0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fib(n-1)+fib(n-2);
     }
     //青蛙跳台阶，每次跳一个或两个，和斐波那契函数一样的道理。
     //递归
     public static int JumpFloor(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return JumpFloor(n-1)+JumpFloor(n-2);
     }
     //非递归
     public static int JumpFloor2(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int x = 1;
        int y = 2;
        int z = 0;
        for (int i = 3; i <= n; i++) {
             z = x+y;
             x = y;
             y = z;
        }
        return z;
     }
     //变态青蛙跳台阶
     //递归
     public static int JumpFloorBT(int n){
        if(n<1){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return 2*JumpFloorBT(n-1);
     }
     //非递归
     public static int JumpFloorBT2(int n){
        if(n<1){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int temp = 1;
        int x = 1;
        for (int i = 2; i <= n; i++) {
             temp = 2*x;
             x = temp;
        }
        return temp;
     }
}
