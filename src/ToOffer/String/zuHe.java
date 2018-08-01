package ToOffer.String;

import java.util.ArrayList;
import java.util.List;

public class zuHe {
	public static void main(String ss[]) {  
        perm("123");  
        System.out.println();  
    }  
  
    // 求字符串中所有字符的组合abc>a,b,c,ab,ac,bc,abc  
    public static void perm(String s) {  
        List<String> result = new ArrayList<String>();  
        for (int i = 1; i <= s.length(); i++) {  
            perm(s, i, result);  
        }  
    }  
  
    // 从字符串s中选择m个字符  
    public static void perm(String s, int m, List<String> result) {  
  
        // 如果m==0，则递归结束。输出当前结果  
        if (m == 0) {  
            for (int i = 0; i < result.size(); i++) {  
                System.out.print(result.get(i));  
            }  
            System.out.println();  
            return;  
        }  
  
        if (s.length() != 0) {  
            // 选择当前元素  
            result.add(s.charAt(0) + "");  
            perm(s.substring(1, s.length()), m - 1, result);  
            result.remove(result.size() - 1);  //移除当前元素
            // 不选当前元素  
            perm(s.substring(1, s.length()), m, result);  
        }  
    }  
}  
