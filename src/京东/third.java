package 京东;
import java.util.Scanner;  
  
/*
 * 括号匹配
        用一个数统计左括号，一个数统计右括号，每遍历一个字符时，
        需要统计求右括号-左括号的差值，并用一个值维护最大值。最
        后判断最大差值是不是小于等于1.同时需要满足左括号个数等于
        右括号个数。又因为题目交代必须有一次操作，所以左右括号必
        须大于等于2.满足以上条件才能满足匹配。
   输入：
   2
   ())(
   )))(((
   输出：
   Yes
   No
 */
public class third {  
    public static String solve(String string)  
    {  
        int ls=string.length();  
        int ans=0;  
        int left=0;  
        int right=0;  
        for(int i=0;i<ls;i++)  
        {  
            if(string.charAt(i)=='(')  
                left+=1;  
            if(string.charAt(i)==')')  
                right+=1;  
            ans=Math.max(ans, right-left);  
        }  
        if(left==right&&ans<=1&&left>=2)  
            return "Yes";  
        return "No";  
    }  
  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        Scanner scanner=new Scanner(System.in);  
        int t=scanner.nextInt();  
        for(int i=0;i<t;i++)  
        {  
            String string=scanner.next();  
            System.out.println(solve(string));  
        }  
  
    }  
  
}  
