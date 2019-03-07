package leetCode;

public class Pow {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println(pow(x,n));
    }
    public static double pow(double x,int n){
        if(n<0){
            return 1/(power(x,-n));
        }else{
            return power(x,n);
        }
    }
    public static double power(double x,int n){
        if(n==0){
            return 1;
        }
        double v = power(x,n>>1);
        if((n&1)==0){
            return v*v;
        }else{
            return v*v*x;
        }
    }
}
