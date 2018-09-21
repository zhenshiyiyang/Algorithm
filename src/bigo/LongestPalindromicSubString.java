package bigo;
/*
  假设dp[ i ][ j ]的值为true，表示字符串s中下标从 i 到 j 的字符组成的子串是回文串。那么可以推出：
    dp[ i ][ j ] = dp[ i + 1][ j - 1] && s[ i ] == s[ j ]。
    这是一般的情况，由于需要依靠i+1, j -1，所以有可能 i + 1 = j -1, i +1 = (j - 1) -1，因此需要求出基准情况才能套用以上的公式：
    a. i + 1 = j -1，即回文长度为1时，dp[ i ][ i ] = true;
    b. i +1 = (j - 1) -1，即回文长度为2时，dp[ i ][ i + 1] = （s[ i ] == s[ i + 1]）。
 */
public class LongestPalindromicSubString {
    public static String longestPalindrome2(String s) {
        if (s == null)
            return null;
        if (s.length() <= 1)
            return s;
        int maxLen = 0;
        String longestStr = null;
        int length = s.length();
        int[][] table = new int[length][length];
        //i和i进行比较赋值
        for (int i = 0; i < length; i++) {
            table[i][i] = 1;
        }
        //i和i+1进行比较赋值
        for (int i = 0; i <= length - 2; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = 1;
                longestStr = s.substring(i, i + 2);
            }
        }
        //dp[ i ][ j ] = dp[ i + 1][ j - 1] && s[ i ] == s[ j ]
        for (int l = 3; l <= length; l++) {
            for (int i = 0; i <= length - l; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    table[i][j] = table[i + 1][j - 1];
                    if (table[i][j] == 1 && l > maxLen)
                        longestStr = s.substring(i, j + 1);
                } else {
                    table[i][j] = 0;
                }
            }
        }
        return longestStr;
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome2("abcbcaaabbccddccbbaa"));//babcbabcbaccba
    }
}