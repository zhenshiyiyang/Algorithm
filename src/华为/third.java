package 华为;

import java.util.Scanner;
import java.math.BigDecimal;

public class third {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        if(n<1) {
            System.out.println("[]");
            return;
        }
        
        double totalAmount=Math.pow(6, n);
        int resultAmount= n*6 - n*1 + 1;
        int[] times = new int[resultAmount];
        for(int i=1;i<=6;i++){
            recursion(n, i, n, 0, times);
        }
        String res = "";
        res += "[";
        for(int i=0;i<resultAmount;i++){
        	double p = times[i]/totalAmount;
        	BigDecimal b = new BigDecimal(p);
        	p = b.setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
            res += "[" + (i+n) + ", " + p + "], ";
        }
        res = res.substring(0, res.length()-2) + "]";
        System.out.println(res);
    }
    
    public static void recursion(int n,int addValue,int leftTimes,int oldSum,int[] times){
        if(leftTimes == 1){
            int sum = oldSum + addValue;
            times[sum - n]++;
        }
        else {  
            int sum = oldSum + addValue;
            for(int i=1;i<=6;i++){
                recursion(n, i, leftTimes-1, sum, times);
            }
        }
    }
}
