package 京东;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * 牛牛特别喜欢回文串，他手中有一个字符串s，牛牛思考能否
 * 从字符串中移除部分（0个或多个）字符使其变成回文串，并且
 * 牛牛认为空串不是回文串。
 * 输入：
 * XXY
 * 输出：
 * 4
 * 输入：
 * ABA
 * 输出：
 * 5
 */

public class huiwen {
	 public static int solve(String s) {    
	        ArrayList<String> result = new ArrayList<String>();  
	        ArrayList<ArrayList<String>> lists=new ArrayList<>();  
	        for (int i = 1; i <= s.length(); i++) {    
	            solution(s, i, result,lists);    
	        }  
	        int ans=0;  
	        ArrayList<String> arrayList;  
	        for(int i=0;i<lists.size();i++)  
	        {  
	            arrayList=lists.get(i);  
	              
	            if(isPalindrome(arrayList, 0, arrayList.size()-1))  
	                ans++;  
	              
	        }  
	        return ans;  
	    }    
	    
	    public static void solution(String s, int m, ArrayList<String> result,ArrayList<ArrayList<String>> lists) {    
	      
	        if (m == 0) {    
	            lists.add(new ArrayList<>(result));  
	               
	            return;    
	        }    
	    
	        if (s.length() != 0) {    
	            // 选择当前元素    
	            result.add(s.charAt(0) + "");    
	            solution(s.substring(1, s.length()), m - 1, result,lists);    
	            result.remove(result.size() - 1);    
	            // 不选当前元素    
	            solution(s.substring(1, s.length()), m, result,lists);    
	        }    
	    }    
	   
	  
	  
	    public static boolean isPalindrome(ArrayList<String> sb, int left, int right) {  
	        while (left <= right && sb.get(left).equals(sb.get(right)) ) {  
	            left++;  
	            right--;  
	        }  
	        if(left>right)  
	            return true;  
	        return false;  
	    }  
	    public static void main(String args[]) {  
	        Scanner sc = new Scanner(System.in);  
	        String string = sc.nextLine();  
	        System.out.println(solve(string));  
	    }  
}
