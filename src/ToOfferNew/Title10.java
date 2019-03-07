package ToOfferNew;
//二进制中1的个数
public class Title10 {
    public static void main(String[] args) {
        System.out.println(numberofbit(10,13));
    }
    public static int NumberOf1(int n){
        int count = 0;
        while(n>0){
            count++;
            n = (n-1)&n;
        }
        return count;
    }
    //利用整数二进制的位数。考虑到n可能是负数。
    public static int number(int n){
        int count = 0;
        int flag = 1;
        while(flag!=0){
            if((n&flag)!=0){
                count++;
            }
            flag = flag<<1;
        }
        return count;
    }
    //判断一个整数是不是2到整数次方。
    public static boolean isVal(int n){
        boolean flag = false;
        if(((n-1)&n)==0){
            flag = true;
        }
        return flag;
    }
    //判断两个整数m和n需要改变m的二进制多少位才能得到n。
    public static int numberofbit(int m,int n){
        int x = m^n;
        int count = 0;
        while(x!=0){
            count++;
            x = (x-1)&x;
        }
        return count;
    }
}
