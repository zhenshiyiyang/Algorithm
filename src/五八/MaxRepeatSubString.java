package 五八;
/*
  思路：使用两个指针，两个指针的间隔从1，2，3...依次增大，
  同时向右移动两个指针，在移动的过程中判断指针位置的字符是
  否相同，并记录最长子串的长度。
 */
public class MaxRepeatSubString {
    // 求解字符串中的最长重复子串
    public static String maxRepat(String input) {
        // 参数检查
        if (input == null || input.length() == 0) {
            return null;
        }
        // 重复子串的最长长度
        int max = 0;
        // 最长重复子串的起始位置
        int first = 0;
        int k = 0;
        //衡量两指针之间的距离
        for (int i = 1; i < input.length(); i++) {
            //j和i+j分别为两个指针。
            for (int j = 0; j < input.length() - i; j++) {
                if (input.charAt(j) == input.charAt(i + j)) {
                    k++;
                } else {
                    k = 0;
                }
                if (k > max) {
                    max = k;
                    first = j - k + 1;
                }
            }
        }
        if (max > 0) {
            System.out.println(max);
            return input.substring(first, first + max);
        }
        return null;
    }
    public static void main(String[] args) {
        String str1 = "hellowdhelloko";
        String result = maxRepat(str1);
        System.out.println(result);
    }
}
