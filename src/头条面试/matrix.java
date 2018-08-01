package 头条面试;

public class matrix{
    public static void main(String[] args){
       int[][] A = {
           {1,2,3,4},
           {1,2,3,4},
           {1,2,3,4},
           {1,2,3,4}
       };
       int[][] B = {
           {1,2,3,4},
           {1,2,3,4},
           {1,2,3,4},
           {1,2,3,4}
       };
       int[][] C = multy(A,B);
       for(int i=0;i<C.length;i++){
    	   for(int j=0;j<C[0].length;j++){
    		   System.out.print(C[i][j]);
    	   }
    	   System.out.println();
       }
    }
    public static int[][] multy(int[][] A,int[][] B){
        if(A==null || B==null) return null;
        int A_row = A.length;
        int A_column = A[0].length;
        int[][] C = new int[A_row][A_column];
        int B_row = B.length;
        int B_column = B[0].length;
        if(A_row!=B_column) return null;
        for(int i=0;i<A_row;i++){
            for(int k=0;k<B_column;k++){
                for(int j=0;j<A_column;j++){
                   C[i][j] += A[i][j]*B[j][k];
                }
                
            }
        }
        return C;
    }
}