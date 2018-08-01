package 华为;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class first {
	public static String subStr(String str, int subSLength) throws UnsupportedEncodingException  
	   {  
	         
	       if (str == null)  
	           return null;  
	       else  
	       {  
	           int tempSubLength = subSLength;//截取字节数  
	             
	           String subStr = str.substring(0, subSLength);//截取的子串  
	             
	           int subStrByetsL = subStr.getBytes("GBK").length;//截取子串的字节长度  
	             
	           // 说明截取的字符串中包含有汉字  
	           while (subStrByetsL > tempSubLength)  
	           {  
	               subStr = str.substring(0, --subSLength);  
	               subStrByetsL = subStr.getBytes("GBK").length;  
	           }  
	           return subStr;  
	       }  
	         
	   }  
	public static void main(String[] args) throws UnsupportedEncodingException{
		//String str = "华HUA中国";
		//int length = 6;
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		int length = in.nextInt();
		char[] tmpChars = str.toCharArray();
        str = "";
        for(char c : tmpChars) {
            if(!(c >= '0' && c <='9'))
                str += c;
        }
		System.out.println(subStr(str,length));
	}
}
