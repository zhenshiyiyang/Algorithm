package 腾讯;

import java.util.Scanner;

public class third {
    public static void main(String args[])
    {
        Scanner sc =new Scanner(System.in);
        int t=sc.nextInt();
        int[] x=new int[t];
        int[] y=new int[t];
        int[] z=new int[t];
        for(int i=0;i<t;i++)
        {
            x[i]=sc.nextInt();
            y[i]=sc.nextInt();
            z[i]=sc.nextInt();
            int flag=0;
            for(int j=0;j<1000;j++) {
                if ((x[i] * j - z[i]) % y[i] == 0)
                {
                    flag=1;
                }
            }
            if(flag==0)
                System.out.println("NO");
            else
                System.out.println("YES");
        }

    }
}
