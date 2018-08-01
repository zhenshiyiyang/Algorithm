package 第四范式;
//给定一个无序数组，求其中的最长连续递增子串，返回子串的起始和结束位置，
//例如：3,2,4,5,6,1,7,8,9 最长连续子串为1,7,8,9 返回值应该为5和8
//利用第二个数组进行标记，可以查出递增或递减最长子串，如果是单纯递增，
//需要更改一下条件。
public class LongSubArray {
	public static void main(String[] args) {
		// 找到最大单调子串的起止下标
		solution(new int[] {10,9,8,7,6,1,7,8,9});
	}
	public static void solution(int[] nums) {
		int max = 1;
		int startIndex = nums.length - 1;
		int[] a = new int[nums.length];
		for(int i=nums.length-2;i>=0;i--) {
			if(nums[i]>nums[i+1]) {
				if(a[i+1]<=0) {
					a[i] = a[i+1] - 1;
				}
				else {
					a[i] = -1;
				}
			}
			if(nums[i]<nums[i+1]) {
				if(a[i+1]>=0) {
					a[i] = a[i+1] + 1;
				}
				else {
					a[i] = 1;
				}
			}
			if(Math.abs(a[i])>max) {
				startIndex = i;
				max = Math.abs(a[i]);
			}
		}
		for(int i=0;i<nums.length;i++){
			System.out.println(a[i]);
		}
		System.out.println(startIndex + " - " + (startIndex+max));
	}
}
