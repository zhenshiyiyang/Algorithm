package 算法;

import java.util.Scanner;



public class MinTree {
	public static class Edge{
	    int v; //边的权值
	    int[] ConnectPoint = new int[2];  //边所连接的点
	    int isSelect; //是否被选择，1表示被选，0表示没有被选
	    char No; //图的编号,a,b,c,d...在创建图的时候初始化的
	}
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("请输入图有几条边和几个点:");
        int n = scn.nextInt();  //保存边数
        int m = scn.nextInt(); //保存点数
        Edge edge[] = new Edge[n]; 
        for(int i=0;i<n;i++){
            edge[i] = new Edge();  //创建出真实的边出来
            edge[i].v = scn.nextInt();
            edge[i].ConnectPoint[0] = scn.nextInt();
            edge[i].ConnectPoint[1] = scn.nextInt();
            edge[i].No = (char) ('a' + i);
        }
        
        //输入完了之后，将这些边按权值进行排序
        sort(edge);
        
        //定义一个点的数组，来存放已经选择的边的关联顶点编号
        int hasSelectPoint[] = new int[2*m];  //因为每条边都有关联两个顶点,选择的边存放进来可能会存放两次
        //初始化，这个数组开始全部存0，都没有被选择
        for(int i=0;i<hasSelectPoint.length;i++){
            hasSelectPoint[i] = 0;
        }
        
        //权值排序完成之后就开始选边
        int j=0;
        int step = 1;//选的边数，开始选第一条边
        for(int i=0;i<n;i++){
            //最小生成树要选的边数等于顶点数-1,那么开始要选m-1最后一条边时这样选。再break退出
            if(step == m-1 && allInSelectPoint(edge[i],hasSelectPoint)){ //最后一条边了
                    edge[i].isSelect = 1;//直接选择
                    break;
            }else if(edge[i].isSelect ==0 && !allInSelectPoint(edge[i],hasSelectPoint)){ //如果边没有被选，并且这条边的两个顶点不同时在顶点的数组里
                    edge[i].isSelect = 1;
                    hasSelectPoint[j] = edge[i].ConnectPoint[0];
                    j++;
                    hasSelectPoint[j] = edge[i].ConnectPoint[1];
                    j++;
                    step++; //开始选第二条边
            }
        }
        
        //打印所选的边
        int sum = 0; // 计算权值
        System.out.print("所选的边为:");
        for(int i=0;i<n;i++){
            if(edge[i].isSelect==1){
                sum = sum + edge[i].v;
                System.out.print(edge[i].No + " ");
            }
        }
        System.out.println();
        System.out.println("权值为: " + sum);
    }

    private static boolean allInSelectPoint(Edge edge, int[] hasSelectPoint) {
        int flag1 = 0;
        int flag2 = 0;//这两个变量是分别看边的两个端点在不在存放已经选择点的数组里面
        for(int i=0;i<hasSelectPoint.length;i++){
            if(edge.ConnectPoint[0] ==hasSelectPoint[i]){
                flag1 = 1;
            }
            if(edge.ConnectPoint[1] ==hasSelectPoint[i]){
                flag2 = 1;
            }
        }
        if(flag1 ==1 && flag2 ==1){  //两个点都在
            return true;
        }else {  //都不在或者有一个点不在
            return false;
        }
    }

    //将权值进行交换
    private static void sort(Edge[] edge) {
        Edge tempEdge = null;
        for(int i=0;i<edge.length;i++){
            for(int j=i+1;j<edge.length;j++){
                if(edge[j].v<edge[i].v){
                    tempEdge = edge[i];
                    edge[i] = edge[j];
                    edge[j] = tempEdge;
                }
            }
        }
    }
}