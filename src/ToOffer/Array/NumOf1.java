package ToOffer.Array;

public class NumOf1 {
//    public static void main(String[] args) {
//        int n = 5;
//        int count = 0;
//        int flag = 1;
//        while(flag!=0){
//            if((n&flag)!=0){
//                count++;
//            }
//            flag = flag << 1;
//            System.out.println(flag);
//        }
//        System.out.println(count);
//    }
    public static void main(String[] args) {
        int n = 5;
        int count = 0;
        while(n!=0){
            count++;
            n = (n-1)&n;
        }
        System.out.println(count);
    }
}
