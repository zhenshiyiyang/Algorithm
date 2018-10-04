package leetCode;
/*
  利用最少的跳跃次数跳到数组尾部，利用贪心算法解题。
 */
public class CanJump2 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // cur是维护的当前能跳到的最大位置
        // 第step+1步，能到达的最远距离
        int cur = 0;
        // last是指从之前的点能reach到得最远位置
        // 已经可以到达的最大距离
        int last = 0;
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            // 当i 大于之前点能碰到的最大位置时，就需要跳一步，
            // 并把last更新为cur.
            if (i > last) {
                step++;
                last = cur;
            }
            // 计算step+1的最大距离
            cur = Math.max(cur, nums[i] + i);
        }
        // 最后返回若是cur能到最后一个元素，就返回step,
        // 若是到不了，就说明根本走不到最后一步，返回-1.
        return cur < nums.length - 1 ? -1 : step;
    }
}
