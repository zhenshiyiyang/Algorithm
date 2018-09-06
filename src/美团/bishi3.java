package 美团;
/*
   求一个n容量的数组区间，是否包含执行的超过了t次的数字，
   区间j-i+1=k
 */
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
public class bishi3{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int[] a = new int[n];
        int k = sc.nextInt();
        int t = sc.nextInt();
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0; i < n; i++){
            if(i + k -1 < n){
                for(int j = i; j <= i + k -1; j++){
                    if(map.containsKey(a[j]))
                        map.put(a[j], map.get(a[j]) + 1);
                    else {
                        map.put(a[j], 1);
                    }
                }
                boolean flag = false;
                for(Map.Entry entry : map.entrySet()){
                    if((Integer)entry.getValue() >= t){
                        flag = true;
                        break;
                    }
                }
                if(flag == true)
                    sum++;
                map.clear();
            }else{
                break;
            }
        }
        System.out.println(sum);
    }
}