package ToOffer.knowledge;

public class power {
    public static void main(String[] args) {
        int x = 2;
        int n = 3;
        System.out.println(pow(x,n));
    }
    public static int pow(int x,int n){
        if(n==0){
            return 1;
        }
        if(n==1){
            return x;
        }
        int result = pow(x,n>>1);
        result *= result;
        if(n%2==1){
            result *= x;
        }
        return result;
    }
}
