package ToOffer.String;

import java.util.ArrayList;
import java.util.List;

public class zuHe {
	public static void main(String ss[]) {
        List<List<Character>> ret = new ArrayList<List<Character>>();
        List<Character> list = new ArrayList<Character>();
        perm("123",ret,list);
        for (int i = 0; i < ret.size(); i++) {
            System.out.println(ret.get(i));
        }
    }
  
    // 求字符串中所有字符的组合abc>a,b,c,ab,ac,bc,abc  
    public static void perm(String s,List<List<Character>> ret,List<Character> list) {
        for (int i = 1; i <= s.length(); i++) {
            perm(s, i, ret,list,0);
        }
    }  
  
    // 从字符串s中选择m个字符  
    public static void perm(String s, int m, List<List<Character>> ret ,List<Character> list,int start) {
        if (list.size() == m) {
            ret.add(new ArrayList<Character>(list));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            list.add(s.toCharArray()[i]);
            perm(s, m, ret, list,i + 1);
            list.remove(list.size() - 1);
        }
    }  
}

