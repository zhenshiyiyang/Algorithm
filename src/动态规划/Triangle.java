package 动态规划;

import java.util.Scanner;
/*
 * 在上面的数字三角形中寻找一条从顶部到底边的路径，
 * 使得路径上所经过的数字之和最大。路径上的每一步
 * 都只能往左下或 右下走。只需要求出这个最大和即可，
 * 不必给出具体路径。 三角形的行数大于1小于等于100，
 * 数字为 0 - 99
 */
public class Triangle {
	public static final int max = 100;
	public static int[][] D = new int[max][max];
	public static int[][] maxSum = new int[max][max];
	public static final int n = 5;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<n;i++){
			for(int j=0;j<=i;j++){
				D[i][j] = sc.nextInt();
				maxSum[i][j] = -1;
			}
		}
		System.out.println(MaxSum(0,0));
	}
	public static int MaxSum(int i,int j){
		if(maxSum[i][j]!=-1){
			return maxSum[i][j];
		}
		if(i==max){
		   maxSum[i][j] = D[i][j];
		}
		else{
		   //状态转移方程
		   int x = MaxSum(i+1,j);
		   int y = MaxSum(i+1,j+1);
		   maxSum[i][j] = Math.max(x, y) + D[i][j];
		}
		return maxSum[i][j];
	}
}
