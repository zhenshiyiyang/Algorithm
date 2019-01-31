package 头条面试题;
/*
   36进制求和。
 */
import java.util.HashMap;
public class Sum {
        private static final String byte36 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";// 36进制转十进制时使用  字母大写
        private static final String[] arrBy36 = "0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z".split(",");//十进制转36进制使用
        public static void main(String[] args) {
            System.out.println(byte36ToTen("1b"));
            System.out.println(byteTenTo36(47));
            System.out.println(add("1b", "2x"));
        }
        public static String add(String s1,String s2){
            //先转十进制然后相加在转36进制
            int sum=byte36ToTen(s1)+byte36ToTen(s2);
            return byteTenTo36(sum);
        }
        /** 将36进制转10进制*/
        public static int byte36ToTen(String s1){
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            for (int i = 0; i < byte36.length(); i++) {
                map.put(byte36.charAt(i), i);
            }
            int size = s1.length();

            char[] s = s1.toCharArray();
            int num = 0;
            for(int i = 0; i<size; i++) {
                String char2str = String.valueOf(s1.charAt(i)).toUpperCase();//将字母转大写 并将char转字符串
                num = (int) (map.get(char2str.charAt(0)) * Math.pow(36, size - i - 1) + num);//根据key 取map中对应的value即数字和字母对应的值 然后乘36的n次幂 再相加
            }
            return num;
        }
        /** 将十进制转36进制*/
        public static String byteTenTo36(int num) {
            StringBuffer sBuffer = new StringBuffer();
            if(num == 0) {
                sBuffer.append("0");
            }
            while(num > 0) {
                sBuffer.append(arrBy36[num % 36]);//十进制数除36
                num = num / 36;
            }

            return sBuffer.reverse().toString();//反转一下
        }
}
