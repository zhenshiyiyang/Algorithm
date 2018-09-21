package 拼多多;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
  字符串
 */
public class str {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] string = sc.nextLine().split(" ");
        HashMap<String,Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < string.length; i++) {
            String str = "";
            if(string[i].contains("?")||string[i].contains("!")||string[i].contains(",")||
                    string[i].contains(":")||string[i].contains(";")||string[i].contains(".")){
                int n = string[i].length()-1;
                str = string[i].substring(0,n).toLowerCase();
            }else if(string[i].contains("-")){
                String[] s = string[i].split("-");
                str = s[0]+s[1];
            }
            else{
                str = string[i].toLowerCase();
            }
            char[] chars = str.toCharArray();
            String res = new String(chars);
            if(map.containsKey(res)){
                int num = map.get(res)+1;
                map.put(res,num);
            }else{
                map.put(res,1);
            }
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue()>=max){
                 max = entry.getValue();
            }
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue()==max){
                 System.out.print(entry.getKey()+" ");
            }
        }
    }
}
