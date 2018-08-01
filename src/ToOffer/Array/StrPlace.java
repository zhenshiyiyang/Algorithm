package ToOffer.Array;
//字符排列问题
public class StrPlace {
    public static void main(String[] args){
    	String[] array = {"a","b","c"};
    	change(array,0);
    }
    public static void change(String[] array,int begin){
    	int len = array.length;
    	if(array == null || len == 0){
    		return;
    	}
    	if(begin == len-1){
    		for(int i=0;i<len;i++){
    			System.out.print(array[i]+" ");
    		}
    		System.out.print("\n");
    	}else{
    		for(int i=begin;i<len;i++){
    			//第一位与后面交换
    			String temp = array[begin];
    			array[begin] = array[i];
    			array[i] = temp;
    			change(array,begin+1);
    			//交换回来
    			temp = array[begin];
    			array[begin] = array[i];
    			array[i] = temp;
    		}
    	}
    	
    }
}
