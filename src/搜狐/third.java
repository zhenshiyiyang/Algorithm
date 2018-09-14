package 搜狐;

import java.util.Scanner;
public class third {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        String[] aSplit =a.split("\\.");
        String[] bSplit = b.split("\\.");
        int alength=aSplit.length;
        int blength=bSplit.length;
        for(int i=0;i<(alength>blength?blength:alength);i++){
            if (Integer.valueOf(aSplit[i])>Integer.valueOf(bSplit[i])){
                System.out.println(1);
                return;
            }else if(Integer.valueOf(aSplit[i])<Integer.valueOf(bSplit[i])){
                System.out.println(-1);
                return;
            }
        }
        if (alength>blength){
            for(int i=blength;i<alength;i++){
                if (Integer.valueOf(aSplit[i])!=0){
                    System.out.println(1);
                    return;
                }
            }
            System.out.println(0);
        }else if(alength<blength){
            for(int i=alength;i<blength;i++){
                if (Integer.valueOf(bSplit[i])!=0){
                    System.out.println(-1);
                    return;
                }
            }
            System.out.println(0);
        }else {
            System.out.println(0);
        }
    }
}