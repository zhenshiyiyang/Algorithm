package ToOffer.Array;
/*
 * 无序数组中找到两个元素使得相差最小值 
 */
public class MinuteMin {
    public static void main(String[] args){
    	int[] val = {3,5,9,14,1,19};
    	System.out.println(getMinuteMin(val));
    }
    public static int getMinuteMin(int[] val){
        if(val.length<2){
        	return 0;
        }
        int maxValOfA = val[0];
        for(int i=1;i<val.length;i++){
        	maxValOfA = Math.max(maxValOfA, val[i]);
        }
        //初始化桶
        int[] bucket = new int[maxValOfA+1];
        for(int i=0;i<val.length;i++){
        	//判断数组中是否有重复元素，如果有重复元素则差值为0
            if(bucket[val[i]]!=0){
            	return 0;
            }
            bucket[val[i]]++;
        }
        //桶中的数是有序的，遍历桶找到相减的最小值
        int minuteMin = Integer.MAX_VALUE;
        //利用start、end标记两个相邻元素
        int start = -1,end = -1;
        for(int j=0;j<bucket.length;j++){
            if(bucket[j]!=0){
                if(start==-1){
                	start=j;
                }
                else{
                    end=j;
                    minuteMin=Math.min(minuteMin, end-start);
                    start=j;
                }
            }
        }
        return minuteMin;
    }
}
