package 图.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {  
    int size;  
    int[][] matrix;  
    String[] cityArray;  
  
    /** 
     *  
     * @param cityArray 
     *            代表所有的城市信息 
     * @param edges 
     *            代表所有的边 
     * @param direction 
     *            true代表构建有向图，false代表无向图 
     */  
    public Graph(String[] cityArray, Edge[] edges, boolean direction) {  
        this.cityArray = cityArray;  
  
        this.size = cityArray.length;  
  
        matrix = new int[size][size];  
        for(int i=0;i<size;i++) {  
            for(int j=0;j<size;j++) {  
                  
                if(i==j) {  
                    matrix[i][j] = 0;  
                }else {  
                    matrix[i][j] = Integer.MAX_VALUE>>1;  
                }  
            }  
        }  
  
        for (Edge e : edges) {  
            int begin = findIndex(e.beginCity, cityArray);  
            int end = findIndex(e.endCity, cityArray);  
            matrix[begin][end] = e.cost;  
            if (!direction) {  
                matrix[end][begin] = e.cost;  
            }  
        }  
  
    }  
  
    /** 
     * 找出指定数组中某个元素的位置，如果找不到，则返回-1 
     */  
    public int findIndex(String city, String[] cityArray) {  
        for (int i = 0; i < cityArray.length; i++) {  
            if (city.equals(cityArray[i]))  
                return i;  
        }  
        return -1;  
    }  
  
    public void print() {  
        for (int i = 0; i < matrix.length; i++) {  
            int[] ii = matrix[i];  
            System.out.print(cityArray[i] + "  ");  
            for (int j : ii) {  
                System.out.printf("%-16d", j);  
            }  
            System.out.println();  
        }  
    }  
    /*
     * 深度优先遍历递归
     */
    public void dfs(int start,int[] visit){
    	System.out.print(cityArray[start]+" ");
    	visit[start] = 1;
    	for(int i=0;i<visit.length;i++){
    		if(matrix[start][i]>0 && visit[i]==0){
    			dfs(i,visit);
    		}
    	}
    }
    /*
     * 深度优先遍历非递归,利用栈记录
     */
    public void dfs_no(int[] visit){
    	Stack<Integer> stack = new Stack<Integer>();
    	for(int i=0;i<cityArray.length;i++){
    		if(visit[i]==0){
    			visit[i]=1;
    			System.out.print(cityArray[i]+" ");
    			stack.add(i);
    		}
    	    while(!stack.isEmpty()){
    	    	int k = stack.pop();
    	    	for(int j=0;j<cityArray.length;j++){
	    	    	if(matrix[k][j]>0 && visit[j]==0){
	    	    		visit[j]=1;
	    	    		System.out.print(cityArray[j]+" ");
	    	    		stack.add(j);
	    	    		break;
	    	    	}
    	    	}
    	    }
       }
    }
    /*
     * 广度优先遍历非递归
     */
    public void bfs(int start,int[] visit) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visit[start]=1;
		while (!queue.isEmpty()) {
			int node=queue.remove();
			System.out.print(cityArray[node]+" ");
			for(int i=0;i<cityArray.length;i++){
				if(matrix[node][i]!=0 && matrix[node][i]!=Integer.MAX_VALUE>>1 && visit[i]==0){
					queue.add(i);
					visit[i]=1;
				}
			}
		}
		
	}
    /*
     * prim算法
     */
    public int prim(Graph graph, int start) {
		if (graph != null) {
			int size = graph.size;
			int[] lowCost = new int[size];
			int[] visit = new int[size];
 
			// 初始化lowCost数组
			for (int i = 0; i < size; i++) {
				lowCost[i] = graph.matrix[start][i];
			}
 
			// 对进树节点的操作
			StringBuilder builder = new StringBuilder();
			builder.append(graph.cityArray[start]).append(" ");
 
			visit[start] = 1;
 
			int sum = 0;
 
			// 起始节点不需要找，所以我们总共要找(size-1)个节点，故这里n从1开始
			for (int n = 1; n < size; n++) {
 
				int min = Integer.MAX_VALUE>>1;
				int k = -1;
 
				// 选出下一个进树的节点
				for (int i = 0; i < size; i++) {
					if (visit[i] == 0 && lowCost[i] < min) {
						min = lowCost[i];
						k = i;
					}
				}
 
				builder.append(graph.cityArray[k]).append(" ");
				visit[k] = 1;
				sum += min;
 
				// 更新剩下节点的lowCost
				for (int i = 0; i < size; i++) {
					if (visit[i] == 0 && graph.matrix[k][i] < lowCost[i]) {
						lowCost[i] = graph.matrix[k][i];
					}
				}
 
			}
 
			System.out.println("Prim 数的构造顺序如下：");
			System.out.println(builder.toString());
			return sum;
		}
 
		return 0;
	}
}
