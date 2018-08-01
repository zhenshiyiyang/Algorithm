package 一点资讯;
/*
 * 给定一个二维矩阵m*n，矩阵边和角落可能会有残缺，残缺形状未知，
 * 给1*2的方砖，问能否用方砖铺满这一整块。
 */
public class Matrix {
		public static void main(String[] args) {
			int[][] matrix = {
					{0,1,1,1,1,1},
					{0,1,1,1,1,1},
					{1,1,1,1,1,1},
					{1,1,1,1,1,1}
			};
			System.out.println("结果为："+method(matrix));
		}
		public static boolean method(int[][] matrix) {
			int sum = 0;
//			int[] head = new int[matrix.length];
//			head[0] = 1;
//			for(int i=1;i<head.length;i++) {
//				head[i] = -head[i-1];
//			}
			for(int i=0;i<matrix.length;i++) {
				//int bw_flag = head[i];
				for(int j=0;j<matrix[0].length;j++) {
					//bw_flag = -bw_flag;
					//sum += matrix[i][j] * bw_flag;
					sum += matrix[i][j] * ((i+j)%2==0?1:-1);
					System.out.print(matrix[i][j]);
				}
				System.out.println();
			}
			if(sum==0) return true;
			return false;
		}
}
