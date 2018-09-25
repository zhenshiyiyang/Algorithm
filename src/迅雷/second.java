package 迅雷;
import java.util.Scanner;

public class second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for(int i = 1; i <= n; i++)
            for(int j = i; j < n; j++)
                for(int k = j; k < n; k++)
                    if(i*i+j*j==k*k)
                        if(junge(i,j)&&junge(j,k)&&junge(i,k))
                            count++;
        System.out.println(count);

    }
    private static boolean junge(int m,int n){
        int temp = 0;
        while(true){
            temp = m%n;
            if(temp == 0)
                break;
            else{
                m = n;
                n = temp;
            }
        }
        if(n == 1)
            return true;
        else
            return false;
    }
}
