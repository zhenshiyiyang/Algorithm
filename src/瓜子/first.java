package 瓜子;

import java.util.HashMap;
import java.util.Scanner;
public class first {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        char[] temp = {'A','B','C','D','E','F','G','H'};
        HashMap<String,String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(sc.nextLine(),"");
        }
        char[] array = new char[3];
        for (int i = 0; i < 3; i++) {
            array[i] = temp[i];
        }
        change(map,array,0);
    }
    public static void change(HashMap<String,String> map,char[] array,int i){
        if(i == array.length-1){
            if(!map.containsKey(new String(array))){
                System.out.println(array);
            }
        }
        else{
            for(int j = i;j<array.length;j++){
                char temp = array[j];
                array[j] = array[i];
                array[i] = temp;
                change(map,array,i+1);
                temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
    }
}
