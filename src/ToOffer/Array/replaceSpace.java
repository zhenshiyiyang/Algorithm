package ToOffer.Array;
/*
 * 字符串空格替换成“%20” 网络编程中，URL参数里面不能含有特殊字符。#可以替换成“%23”
 */
public class replaceSpace {
      public static void main(String[] args){
    	  String str = "We Are Happy";
          StringBuffer string = new StringBuffer(str);
    	  System.out.println(replace(string));
      }
      public static String replace(StringBuffer str){
    	  if(str==null) return null;
    	  int index = 0;
    	  StringBuffer temp = new StringBuffer();
    	  int fromIndex = 0;
    	  while(index<str.length()){
    		  index = str.indexOf(" ",fromIndex);
    		  if(index>=0){
    			  temp.append(str.subSequence(fromIndex, index)).append("%20");
    			  index = index+1;
    			  fromIndex = index;
    		  }else{  //查不到空格，返回-1
        		  temp.append(str.subSequence(fromIndex, str.length()));
        		  break;
        	  }
    	  }
    	  return temp.toString();
      }
}
