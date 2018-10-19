package leetCode;
/*
  利用二分法求数字的平方根，如果是小数则向下取整。
 */
public class Sqrt {
    public static void main(String[] args) {
        int x = 8;
        System.out.println(mySqrt(x));
    }
    public static int mySqrt(int x) {
        if(x<=1){
            return x;
        }else{
            int begin = 1;
            int end = x;
            int middle = 0;
            while(begin<=end){
                middle = (begin+end)/2;
                if(middle == x/middle){
                    return middle;
                }else if(middle<x/middle){
                    begin = middle+1;
                }else{
                    end = middle-1;
                }
            }
            return end;
        }
    }
}
