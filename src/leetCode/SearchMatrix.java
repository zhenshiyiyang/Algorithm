package leetCode;

public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int target = 3;
        System.out.println(searchMatrix(matrix,target));
    }
    public static boolean searchMatrix(int[][] matrix,int target){
        if(matrix==null || matrix.length==0){
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = column-1; j >= 0; j--) {
                if(matrix[i][j]==target){
                    return true;
                }
                else if(matrix[i][j]>target){
                    continue;
                }
                else{
                    break;
                }
            }
        }
        return false;
    }
}
