package ToOffer.Array;

public class UglyNumber {
	public static void main(String[] args){
		System.out.println(GetUglyNumber_Solution(4));
	}
	public static int GetUglyNumber_Solution(int index) {
		if(index<=0)
			return 0;
		int [] ugly=new int[index];
		ugly[0]=1;
		int uglyNum = 1;
		int multiply2 = 0;
		int multiply3 = 0;
		int multiply5 = 0;
		while(uglyNum<index){
			int min=findMin(ugly[multiply2]*2,ugly[multiply3]*3,ugly[multiply5]*5);
			ugly[uglyNum]=min;
			//更新multoply2位置，令其*2后大于目前最大的丑数
			while(ugly[multiply2]*2<=min)
				multiply2++;
			//更新multoply3位置，令其*3后大于目前最大的丑数
			while(ugly[multiply3]*3<=min)
				multiply3++;
			//更新multoply5位置，令其*5后大于目前最大的丑数
			while(ugly[multiply5]*5<=min)
				multiply5++;
			uglyNum++;
		}
		return ugly[uglyNum-1];
	}
	public static int findMin(int a,int b,int c){
		int min = a < b ? a : b;
		return min = min < c ? min : c;
	}

}
