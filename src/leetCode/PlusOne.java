package leetCode;

import java.util.Arrays;
/*
  考虑大数问题和数组进位问题。
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {1,2,3};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
    public static int[] plusOne(int[] digits) {
          int carry = 1;
          int i = digits.length-1;
          while(i>=0&&carry>0){
              int sum = digits[i]+1;
              carry = sum/10;
              digits[i] = sum%10;
              i--;
          }
          if(carry>0){
              int[] newArray = new int[digits.length+1];
              System.arraycopy(digits,0,newArray,1,digits.length);
              newArray[0] = carry;
              return newArray;
          }
          return digits;
    }
}
