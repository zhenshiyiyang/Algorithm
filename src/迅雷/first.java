package 迅雷;

import java.util.HashMap;
import java.util.Scanner;

public class first {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<chars.length;i++){
             String s = String.valueOf(chars[i]);
             if(map.containsKey(s)){
                 map.put(s,map.get(s)+1);
             }else{
                 map.put(s,1);
             }
        }
        int n = map.size();
        String res = "";
        for(int i=0;i<chars.length;i++){
            String s1 = String.valueOf(chars[i]);
            if(!res.contains(s1)){
                if(map.get(s1)>=2){
                    res += s1+String.valueOf(map.get(s1));
                }else{
                    res += s1;
                }
            }
        }
        System.out.println(res);
    }
}
