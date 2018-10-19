package leetCode;

public class AddBinary {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a,b));
    }
    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int al = a.length()-1;
        int bl = b.length()-1;
        int carry = 0;
        while( al >=0  || bl >=0 )
        {
            int sum = carry;
            if(al >= 0)
            {
                sum += (a.charAt(al) - '0');
                al--;
            }
            if(bl >= 0)
            {
                sum += (b.charAt(bl) - '0');
                bl--;
            }
            //相加结果
            result.append(sum%2);
            //进位，如果是1那么carry=0，如果是2则要进位给下面一位+1
            carry = sum /2;
        }
        //都相加完了，还要进位的情况
        if(carry !=0 )
            result.append(1);
        //先反转，再输出
        return result.reverse().toString();
    }

}
