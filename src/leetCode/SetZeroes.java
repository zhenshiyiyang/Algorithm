package leetCode;

import java.util.Arrays;

public class SetZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        setZeroes(matrix);
        System.out.println(Arrays.toString(matrix[0]));
        System.out.println(Arrays.toString(matrix[1]));
        System.out.println(Arrays.toString(matrix[2]));
    }
    public static void setZeroes(int[][] matrix){
        if(matrix.length == 0){
            return;
        }
        boolean firstRowIsZero = false,firstColIsZero = false;
        for(int i =0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i!=0 && j!=0 && matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }else if(matrix[i][j]==0){
                    firstRowIsZero = i==0? true:firstRowIsZero;
                    firstColIsZero = j==0? true:firstColIsZero;
                }
            }
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[0][j]==0 || matrix[i][0] == 0){
                    matrix[i][j]=0;
                }
            }
        }
        //第一列含0
        if(firstColIsZero){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0] = 0;
            }
        }
        //第一行含0
        if(firstRowIsZero){
            for(int j=0;j<matrix[0].length;j++){
                matrix[0][j] = 0;
            }
        }
    }
}
