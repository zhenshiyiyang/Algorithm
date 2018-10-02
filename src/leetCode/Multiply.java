package leetCode;

public class Multiply {
    public static void main(String[] args) {
        String num1 = "10";
        String num2 = "10";
        System.out.println(multiply(num1,num2));
    }
    public static String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)) return "0";
        int len1 = num1.length(), len2 = num2.length();
        int A[] = new int[len1 + len2];
        //数组A保存大数每一位相乘之后的结果。
        for(int i = len1-1; i >= 0; i--){
            for(int j = len2-1; j >= 0; j--){
                A[len1+len2-2-i-j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        String result = "";
        for(int i = 0; i < len1+len2-1; i++){
            A[i+1] += A[i]/10;
            A[i] %= 10;
            result = (char)(A[i] + '0') + result;
        }
        result = (0 == A[len1+len2-1] ? "" : (char)(A[len1+len2-1]+'0')) + result;

        return result;
    }
}
