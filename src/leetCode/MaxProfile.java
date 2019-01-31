package leetCode;

public class MaxProfile {
    public static void main(String[] args) {

    }
    public static int maxProfile(int[] prices){
        int length = prices.length;
        if(length<2){
            return 0;
        }
        int minPrice = prices[0];
        int maxDiff = prices[1]-prices[0];
        for (int i = 2; i < length; i++) {
             if(prices[i-1]<minPrice){
                 minPrice = prices[i-1];
             }
             int currentDiff = prices[i]-minPrice;
             if(currentDiff>maxDiff){
                 maxDiff = currentDiff;
             }
        }
        if(maxDiff<0){
            return 0;
        }
        return maxDiff;

    }
}
