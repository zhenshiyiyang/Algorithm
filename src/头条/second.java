package 头条;
/*
  假设把某股票的价格按照时间先后顺序存储在数组中，
  请问买卖该股票一次可获得的最大利润是多少？
  例如，一只股票在某些时间节点的价格为{9,11,8,5,7,12,16,14}。
  如果我们能在价格为5的时候买入并在价格为16时卖出，则能获得最大的利润为11.
 */
public class second {
    public static void main(String[] args) {
        int[] prices = {9,11,8,5,7,12,16,14};
        System.out.println(maxProfile(prices));
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
