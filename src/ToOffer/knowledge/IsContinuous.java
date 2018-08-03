package ToOffer.knowledge;

import java.util.Arrays;
/*
    从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 */
public class IsContinuous {
    public static void main(String[] args) {
        int[] numbers = {0,0,1,3,5};
        System.out.println(isContinuous(numbers,5));
    }
    public static boolean isContinuous(int[] numbers,int length){
        if(numbers == null || length<1){
            return false;
        }
        Arrays.sort(numbers);
        int numberOfZero = 0;
        int numberOfGap = 0;
        //统计数组中0的个数
        for (int i = 0; i < length && numbers[i] == 0; i++) {
            ++numberOfZero;
        }
        int small = numberOfZero;
        int big = small+1;
        while(big < length){
            if(numbers[small]==numbers[big]){
                return false;
            }
            numberOfGap += numbers[big] - numbers[small] -1;
            small = big;
            ++big;
        }
        return (numberOfGap>numberOfZero)?false:true;
    }
}
