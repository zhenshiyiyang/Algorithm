package ToOffer.Array;

/*
   一个整型数组，除了两个数字之外，其他数字都出现两次。找出只出现一次的数字。
   利用两个相同数字异或操作为0这一个特点。分成两个子数组进行求值。
 */
public class FindNumsAppearOnce {
    public static void main(String[] args){
         int[] data = {2,4,3,6,3,2,5,5};
         find(data,8);
    }
    public static void find(int[] data,int length){
        if(data==null || length<2){
            return;
        }
        int result = 0;
        for(int i=0;i<length;i++){
            result ^= data[i];
        }
        int indexOf = findFirstBitIs1(result);
        int num1=0;
        int num2=0;
        for(int j=0;j<length;j++){
            if(isBit1(data[j],indexOf))
                num1^=data[j];
            else
                num2^=data[j];
        }
        System.out.println("num1:"+num1+"num2:"+num2);

    }
    public static int findFirstBitIs1(int num){
        int indexBit = 0;
        while(((num&1)==0)&&(indexBit<8)){
             num = num >> 1;
             indexBit++;
        }
        return indexBit;
    }
    public static boolean isBit1(int num,int indexOf){
        num = num >> indexOf;
        if((num&1)==0){
            return true;
        }
        return false;
    }
}
