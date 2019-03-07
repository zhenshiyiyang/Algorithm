package ToOffer.BigData;

public class BigNumberSum {
        public static void main(String args[]) {
            String num1 = "-1004215696420130001";
            String num2 = "123";
            char num[] = add(num1, num2);
            printNumber(num);
        }

        public static char[] add(String str1, String str2) {
            char[] num1 = str1.toCharArray();//调用函数将字符串转换成字符数组
            char[] num2 = str2.toCharArray();
            int nsum = 0;
            int nTakeOver = 0;
            boolean flag = false;
            char[] num = null;
            // 两个大数做加法运算有两种情况1. 一正一负 2.同时为正或同时为负数
            // 对于第一种情况取绝对值做减法运算，如果负数的绝对值更大则结果是负数，否则结果为正数
            // 对于第二种情况 直接做加法运算 同为正数 结果则为正数 否则结果为负数
            // 第一种情况
            if ((num1[0] == '-' && num2[0] != '-')
                    || (num1[0] != '-' && num2[0] == '-')) {
                if (num1[0] == '-' && num2[0] != '-') {
                    num1 = absNum(num1);
                    num2 = absNum(num2);
                    if (getMaxAbs(num2, num1)) {
                        // num2大结果为正数
                        char temp[] = num1;
                        num1 = num2;
                        num2 = temp;
                    } else {
                        flag = true;// num1大结果为负数
                    }
                } else {
                    num1 = absNum(num1);
                    num2 = absNum(num2);
                    if (getMaxAbs(num2, num1)) {
                        flag = true;// 结果为负数
                        char temp[] = num1;
                        num1 = num2;
                        num2 = temp;
                    }
                    // 否则num1大 结果为正数
                }
                num = new char[num1.length];
                for (int i = num1.length - 1, j = num2.length - 1; i >= 0; i--, j--) {
                    if (j >= 0) {
                        nsum = num1[i] - num2[j] + nTakeOver;
                        if (nsum < 0) {
                            // 相减结果小于0 向上借一位
                            nTakeOver = -1;
                            nsum = nsum + 10;
                            num[i] = (char) (nsum + '0');
                        } else {
                            nTakeOver = 0;
                            num[i] = (char) (nsum + '0');
                        }
                    } else {
                        nsum = num1[i] + nTakeOver - '0';
                        if (nsum < 0) {
                            nTakeOver = -1;
                            nsum = nsum + 10;
                            num[i] = (char) (nsum + '0');
                        } else {
                            nTakeOver = 0;
                            num[i] = (char) (nsum + '0');
                        }
                    }
                }
            } else {//第二种情况
                if (num1[0] == '-' && num2[0] == '-') {
                    num1 = absNum(num1);
                    num2 = absNum(num2);
                    flag = true;
                }
                if (getMaxAbs(num2, num1)) {
                    char[] temp = num1;
                    num1 = num2;
                    num2 = temp;
                }
                num = new char[num1.length];
                for (int i = num1.length - 1, j = num2.length - 1; i >= 0; i--, j--) {
                    if (j >= 0) {
                        nsum = num1[i] - '0' + num2[j] - '0' + nTakeOver;
                        if (nsum >= 10) {
                            // 相加大于等于十 产生进位
                            nTakeOver = 1;
                            nsum = nsum - 10;
                            num[i] = (char) (nsum + '0');
                        } else {
                            nTakeOver = 0;
                            num[i] = (char) (nsum + '0');
                        }
                    } else {
                        nsum = num1[i] - '0' + nTakeOver;
                        if (nsum >= 10) {
                            nTakeOver = 1;
                            nsum = nsum - 10;
                            num[i] = (char) (nsum + '0');
                        } else {
                            nTakeOver = 0;
                            num[i] = (char) (nsum + '0');
                        }
                    }

                }
            }
            if (flag) {
                char temp[] = new char[num.length + 1];
                temp[0] = '-';
                for (int i = 0; i < num.length; i++) {
                    temp[i + 1] = num[i];
                }
                return temp;
            } else {
                return num;
            }
        }

        // 获得一个数的绝对值
        public static char[] absNum(char[] num) {
            if (num[0] != '-')
                return num;
            char temp[] = new char[num.length - 1];
            for (int i = 1; i < num.length; i++) {
                temp[i - 1] = num[i];
            }
            return temp;
        }

        // 判断两个数的绝对值的大小
        public static boolean getMaxAbs(char[] num1, char[] num2) {
            num1 = absNum(num1);
            num2 = absNum(num2);
            int length1 = num1.length;
            int length2 = num2.length;
            if (length1 > length2)
                return true;
            if (length1 < length2)
                return false;
            for (int i = 0; i < length1; i++) {
                if (num1[i] > num2[i])
                    return true;
                if (num1[i] < num2[i])
                    return false;
            }
            return true;
        }

        //打印结果
        public static void printNumber(char number[]) {
            boolean IsBeginWith0 = true;
            //如果第一个字符为'-'则先打印出该字符 然后i从1开始遍历该字符数组 从第一个非0字符开始打印该字符数组
            int i = 0;
            if (number[0] == '-') {
                System.out.print(number[0]);
                i = 1;
            }
            for (; i < number.length; i++) {
                if (IsBeginWith0 && number[i] != '0') {
                    break;
                }
            }
            for (; i < number.length; i++) {
                System.out.print(number[i]);
            }
            System.out.print("\t");
        }
}
