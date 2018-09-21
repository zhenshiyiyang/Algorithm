package boss;

import java.util.HashSet;
import java.util.Scanner;

public class second {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int x = sc.nextInt();
         String[] str = sc.next().split(",");
         int n = str.length;
         HashSet<String> set = new HashSet<>();
         set.add("0");
         for(int i=0;i<n;i++){
             set.add(str[i]);
         }
         int min = 0;
         for (int i = 0; i < 10; i++) {
            if(!set.contains(String.valueOf(i))){
                min = i;
                break;
            }
         }
         int m = String.valueOf(x).length();
         char[] chars = String.valueOf(x).toCharArray();
         String res = "";
         int count = 0;
         for(int i=0;i<m;i++){
            if(set.contains(String.valueOf(chars[i]))){
                if(count == 0){
                    System.out.println(chars[i]+1);
                    for(int j=Integer.valueOf(chars[i])+1;j<10;j++) {
                        System.out.println(j);
                        if (!set.contains(String.valueOf(j))) {
                            System.out.println(j);
                            res += String.valueOf(j);
                            count++;
                            break;
                        } else {
                            System.out.println(j);
                        }
                    }
                }else{
                    res += String.valueOf(min);
                }
            }else{
                res += String.valueOf(chars[i]);
            }
         }
         System.out.println(res);
    }
}
