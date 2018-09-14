package ToOffer.knowledge;
/*
   写一个函数，求两个整数的和，要求在函数体内不得使用+、-、x、/四则运算符号。
   利用与或的思想解决问题。
 */
public class Add {
    public static void main(String[] args) {
        System.out.println(add(5,17));
    }
    public static int add(int num1,int num2){
        int sum = 0;
        int carry = 0;
        while(num2!=0){
            sum = num1 ^ num2;
            carry = (num1 & num2)<<1; //进位
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }

}
