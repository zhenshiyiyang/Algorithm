package ToOffer.knowledge;
/*
   求1+2+3+…+n，要求不能使用乘除法、for、while、if、else、switch、case
   等关键字及条件判断语句（A?B:C）
 */
public class Sum {
    public static void main(String[] args) {
        System.out.println(sum_solution(5));
        System.out.println(sum(5));
    }
    /*
     1.利用公式sum = n*(n+1)/2
     2.将上面的公式变形sum = (n^2 +n)/2
     3.利用指数函数和移位操作
     */
    public static int sum_solution(int n){
        return (int)(Math.pow(n,2)+n)>>1;
    }
    /*
     1.利用短路特性和递归
     2.当n==0时，(n>0)&&((sum+=sum(n-1))>0)只执行前面的判断，为false，然后直接返回0；
     3.当n>0时，执行sum+=sum(n-1)，实现递归计算sum(n)。
     */
    public static int sum(int n){
        int sum = n;
        boolean ans = (n>0)&&((sum+=sum(n-1))>0);
        return sum;
    }
}
