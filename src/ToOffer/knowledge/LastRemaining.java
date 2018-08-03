package ToOffer.knowledge;

import java.util.ArrayList;
import java.util.List;
/*
  0——n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字。
  求圆圈中剩下的最后一个数字。
  利用list存储，然后利用公式idx=(idx+1)%list.size()即可实现圆圈循环。
 */
public class LastRemaining {
    public static void main(String[] args) {
        //System.out.println(lastNumber(5,2));
        System.out.println(last(5,3));
    }
    public static int lastNumber(int n,int m){
        if(n < 1 || m < 1){
            return -1;
        }
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < n ; i++) {
            numbers.add(i);
        }
        //要删除元素的位置
        int idx = 0;
        //开始计数的位置
        int start = 0;
        while(numbers.size()>1){
            //只要移动m-1次就可以移动到下一个要删除到元素上。
            for (int i = 0; i < m; i++) {
                //保证每次都可以按照圆圈来循环。
                idx = (idx+1)%numbers.size();
            }
            numbers.remove(idx);
        }
        return numbers.get(0);
    }
    public static int last(int n,int m){
        if(n<1 || m<1){
            return -1;
        }
        int last = 0;
        for(int i=2;i<=n;i++){
            last = (last+m)%i;
        }
        return last;
    }
}
