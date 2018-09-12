package 去哪儿;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MinInt {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int[] minLengthAvailable(String testcase) {
            String[] testcases = testcase.split(" ");
            int N=Integer.valueOf(testcases[0]);
            int M=Integer.valueOf(testcases[1]);
            int K=Integer.valueOf(testcases[2]);
            int num=0;
            int[] result;
            if(N==1||(N==2&&M%2==0)||K==1){
                result = new int[]{-1};
                return result;
            }
            if(M>(K-1)){
                if((K-1)%N==0){
                    K-=1;
                }
                num=M/(K-1);
            }
            if((num+1)%N==0)
                num+=2;
            else{
                num+=1;
            }
            result = new int[]{num};
            return result;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] res;

        String _testcase;
        try {
            _testcase = in.nextLine();
        } catch (Exception e) {
            _testcase = null;
        }

        res = minLengthAvailable(_testcase);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}
