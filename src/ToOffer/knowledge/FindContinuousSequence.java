package ToOffer.knowledge;
/*
   输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。
 */
public class FindContinuousSequence {
    public static void main(String[] args){
         find(15);
    }
    public static void find(int sum){
          if(sum<3)
              return;
          int small = 1;
          int big = 2;
          int middle = (1+sum)/2;
          int curSum = small+big;
          while(small<middle){
              if(curSum == sum){
                   printContinuousSequence(small,big);
              }
              while(curSum>sum&&small<middle){
                  curSum -= small;
                  small++;
                  if(curSum==sum){
                     printContinuousSequence(small,big);
                  }
              }
              big++;
              curSum += big;
          }
    }
    public static void printContinuousSequence(int small,int big){
        for(int i=small;i<=big;i++){
            System.out.print(i+" ");
        }
        System.out.println("\n");
    }

}
