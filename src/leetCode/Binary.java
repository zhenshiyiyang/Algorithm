package leetCode;

public class Binary {
    public static void main(String[] args) {
        long num = 5;
        String str  = Long.toBinaryString(num);
        int x = (1<<1) | 1;
        int y = (1<<1) | 1;
        System.out.println(x);
        System.out.println(y);
        System.out.println(str);
    }
}
