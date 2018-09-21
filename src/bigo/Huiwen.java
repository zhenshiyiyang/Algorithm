package bigo;
/*
   求最长回文子串，时间效率肯定是很低了，但是思路很清晰
   首先利用两层for循环求出字符串所有的子串的可能
   然后最里面一层针对每个字符串子串进行反转，然后变成char数组，进行是否是回文的判断
   时间复杂度为n的3次方。
 */
public class Huiwen {
    public static void main(String[] args) {
        String str = "abccbaaabbccddccbbaa";
        int max = 0;
        String result = "";
        for (int i = 0; i <str.length() ; i++) {
            for(int j = i;j<=str.length();j++){
                if(!str.substring(i,j).equals("")) {
                    String str1 = str.substring(i,j);
                    char[] c1 = str.substring(i,j).toCharArray();
                    char[] c2 = String.valueOf(new StringBuffer(str1).reverse()).toCharArray();
                    boolean flag = true;
                    for(int k=0;k<c1.length;k++){
                        if(c1[k]!=c2[k]){
                            flag = false;
                        }
                    }
                    if(flag==true && (j-i)>max) {
                        max = j - i;
                        result = str1;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
