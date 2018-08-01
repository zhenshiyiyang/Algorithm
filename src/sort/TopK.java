package sort;

import java.util.Arrays;
//海量数据处理的 Top K算法(问题) 小顶堆实现
public class TopK {
	//保存最原始的前10个数
	public static int[] dui = {1,2,3,4,5,6,7,8,9,10};
	public static int K = 10;    ///Top K,K的取值

	public static void main(String[] args)
	{
	    int[] array = {11,12,13,14,15,16,17,18,19,20};
        create_dui();  ///对dui数组建立小顶堆
        for(int i=0;i<array.length;i++)
        {
        	int tmp = array[i];
            if(tmp>dui[0])  ///只有大于根节点才处理
            {
                dui[0]=tmp;
                UpToDown(0);    ///向下调整堆
            }
        }
        System.out.print(Arrays.toString(dui));
	    
	}
	///建堆
	public static void create_dui()
	{
	    int i;
	    int pos=K/2;      ///从末尾数，第一个非叶节点的位置K/2
	    for(i=pos-1;i>=0;i--){
	        UpToDown(i);
	    }
	}
	///从上到下调整
	public static void UpToDown(int i)
	{
	    int t1,t2,tmp,pos;
	    t1=2*i+1; ///左孩子(存在的话)
	    t2=2*i+2;    ///右孩子(存在的话)  
	    if(t1<K && dui[t1]<dui[i]){
	        pos=t1;
	    }else{
	        pos=i;
	    }
	    if(t2<K && dui[t2]<dui[pos]){
	        pos=t2;
	    }
	    if(pos!=i) ///pos保存在子孩子中，数值较小者的位置
	    {
	        tmp=dui[i];
	        dui[i]=dui[pos];
	        dui[pos]=tmp;
	        UpToDown(pos);
	    }
	}
}
