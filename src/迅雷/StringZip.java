package 迅雷;

import java.util.Scanner;

public class StringZip {
    public static String stringZip(char[] inputStr) {
        String stringZip = "";
        int sum = 1;
        int i = 0, j = i + 1, len = inputStr.length;

        while (/* i < len && */j < len) {

            if (inputStr[i] == inputStr[j]) {
                sum++;

            } else {
                stringZip += inputStr[i];

                if (sum != 1) {
                    stringZip += sum;
                }
                sum = 1;
            }

            if (j == len - 1) {
                stringZip += inputStr[len - 1];
                if (sum != 1) {
                    stringZip += sum;
                }
            }

            i++;
            j = i + 1;

        }

        return stringZip.trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(stringZip(str.toCharArray()));
    }

    //解压
    static String stringUnzip(char[] inputStr){
        String stringUnzip = "";

        int i = 0,len = inputStr.length;
        while(i<len-1){
            if(Character.isDigit(inputStr[i+1])){
                int count = Integer.parseInt(inputStr[i+1]+"");
                for(int s =0; s< count ;s++){
                    stringUnzip +=inputStr[i];
                }
                i=i+2;
            }else{
                stringUnzip+=inputStr[i];
                i++;
            }


            if(i >= len-1){
                if(!Character.isDigit(inputStr[len-1])){
                    stringUnzip += inputStr[len-1];
                }

            }
        }

        return stringUnzip;
    }

}
