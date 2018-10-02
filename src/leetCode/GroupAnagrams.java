package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String res = new String(chars);
            if(map.containsKey(res)){
                map.get(res).add(str);
            }else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(res,list);
            }
        }
        for(String key:map.keySet()){
            List<String> list = map.get(key);
            result.add(list);
        }
        return result;
    }
}
