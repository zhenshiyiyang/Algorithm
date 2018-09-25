package 快手;

import java.util.*;
/*
   堆积木问题，上面的积木x和y分别小于下面的积木x和y即可保证堆起来，问可以堆多少块。
 */
public class third {
    private static class Point implements Comparable<Point>{
        int x;
        int y;
        Point(int x,int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Point o) {
            return this.x - o.x;
        }
    }
    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            Point point = new Point(x,y);
            list.add(point);
        }
        Collections.sort(list);
        int[] nums = new int[n];
        int i = 0;
        for(Point p:list){
           nums[i] = p.y;
           i++;
        }
        System.out.println(longestIncreasingSubsequence(nums));
    }
    public static int longestIncreasingSubsequence(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int dp[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>=nums[j]&&dp[j]+1>dp[i])
                    dp[i]=dp[j]+1;
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max, dp[i]);
        }
        return max;
    }

}
