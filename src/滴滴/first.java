package 滴滴;

import java.util.Scanner;
import java.util.ArrayList;

public class first {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            list.add(sc.nextInt());
        }
        int flag = 0;
        for (int i = 0; i < y; i++) {
            int tmp = Integer.MAX_VALUE;
            for (int j = 0; j < x-1; j++) {
                int t = list.get(j) + list.get(j+1);
                if (t < tmp){
                    tmp = t;
                    flag = j;
                }
            }
            int res = list.get(flag) + list.get(flag+1);

            list.add(flag, res);
            list.remove(flag+1);
            list.remove(flag+1);
            x--;
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) < result){
                result = list.get(i);
            }
        }
        System.out.println(result);
    }
}