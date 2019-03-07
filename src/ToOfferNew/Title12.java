package ToOfferNew;

import java.util.Stack;

public class Title12 {
    //打印1到最大的n位数的主方法
    public void printToMaxOfDigits(int n){
        if(n <= 0){
            System.out.println("输入的n没有意义");
            return;
        }
        char number[] = new char[n];
        for (int i = 0; i < number.length; i++) {
            number[i] = '0';
        }
        for (int i = 0; i < 10; ++i) {
            number[0] = (char) (i + '0');
            printToMaxOfNDigitsRecursively(number, n, 0);
        }
    }
    //利用递归实现1到最大的n位数的全排列
    public void printToMaxOfNDigitsRecursively(char[] number, int n, int index) {
        if(index == n - 1){
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; ++i) {
            number[index + 1] = (char) (i + '0');
            printToMaxOfNDigitsRecursively(number, n, index + 1);
        }
    }

    //输出
    private void printNumber(char[] number) {
        boolean isBeginning0 = true;
        int nLength = number.length;
        for (int i = 0; i < nLength; ++i) {
            if(isBeginning0 && number[i]!='0'){
                isBeginning0 = false;
            }
            if(!isBeginning0){
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }
    //两个大数相加
    //把字符串以字符形式放进栈中
    public static Stack stringToStack(String str)
    {
        Stack stack=new Stack();
        for(int i=0; i<str.length(); i++)
        {
            char c=str.charAt(i);
            if(c>='0' && c<='9')
                stack.push(Integer.valueOf(String.valueOf(c)));
            else
                continue;
        }
        return stack;
    }

    //大数相加
    public static String add(String a, String b)
    {
        Stack stackA=stringToStack(a);   //存放第一个数
        Stack stackB=stringToStack(b);   //存放第二个数
        Stack stackSum=new Stack();     //存放结果和
        int tempSum;    //两位数求和
        boolean isCarry=false;    //进位标志

        while(!stackA.isEmpty() && !stackB.isEmpty())
        {
            tempSum=(Integer)stackA.pop()+(Integer)stackB.pop();
            //若有进位，加1
            if(isCarry)
            {
                tempSum++;
                isCarry=false;
            }
            //位数和大于10，个位数入栈，标志进位
            if(tempSum>=10)
            {
                tempSum-=10;
                stackSum.push(tempSum);
                isCarry=true;
            }
            else
            {
                stackSum.push(tempSum);
            }
        }
        //取不为空的栈
        Stack stackTemp=!stackA.isEmpty()?stackA:stackB;
        while(!stackTemp.isEmpty())
        {
            //若原先有进位
            if(isCarry)
            {
                int end= (Integer)stackTemp.pop(); //取出栈中的数
                ++end;
                if(end>=10)     //大于10，进位
                {
                    end-=10;
                    stackSum.push(end);
                }
                else    //小于10，直接入栈
                {
                    stackSum.push(end);
                    isCarry=false;
                }
            }
            //若原先无进位
            else
            {
                stackSum.push(stackTemp.pop());
            }
        }
        //最高位有进位时,直接最后一个数为1
        if(isCarry)
            stackSum.push(1);
        //把栈中结果转为字符串
        String result=new String();
        while(!stackSum.isEmpty())
        {
            result=result.concat(stackSum.pop().toString());
        }
        return result;
    }

    public static void main(String[] args) {
        String a="6 293 379 654 943 111 722 643 403";
        String b="1 523 502 388 432 201 489 337 789";
        System.out.println("和为: "+add(a,b));
    }
}
