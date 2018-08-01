package ToOffer.Array;
/*
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照
 * 从上到下递增的顺序排序，请完成一个函数，输入这样的一个二维数组和一个
 * 整数，判断数组中是否含有该整数。
 */
public class Matrix {
     public static void main(String[] args){
    	 int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
    	 System.out.println(find(array,6));
     }
     public static String find(int[][] array,int target){
    	 int row = 0;
    	 int column = array[0].length-1;
    	 for(;row<array.length&&column>=0;){
    		     if(target==array[row][column]){
    		    	 return String.valueOf(row)+" "+String.valueOf(column);
    		     }
    			 if(target>array[row][column]){
    				 row++;
    			 }
    			 if(target<array[row][column]){
    				 column--;
    			 }
         }
    	 return null;
     }
}
