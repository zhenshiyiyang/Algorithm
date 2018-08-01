package 图;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 
 *基于邻接矩阵实现的深度和广度遍历
 */
public class Graph {
	final static int INF = 100000;
	final int max = 100;
	int[] vexs = new int[max]; //存放顶点的数组
	int[][] edges = new int[max][max]; //存放边的数组
	
	/*
	 * 创建邻接矩阵
	 */
	public void createGraph(Graph graph ,int[][] A,int[] vs) {
		vexs = vs;
		for(int i=0;i<A.length;i++) {
				for(int j=0;j<A.length;j++) {
						graph.edges[i][j] = A[i][j];
				}
		}
		
	}
	
	/*
	 * 输出邻接矩阵
	 */
	public void print_Graph(Graph graph) {
		for(int i=0;i<graph.vexs.length;i++) {
			for(int j=0;j<graph.vexs.length;j++) {
				if (graph.edges[i][j] == INF) {
					System.out.printf("%4s", "/");
				}else {
					System.out.printf("%4d",graph.edges[i][j]);
				}
			}
			System.out.println("\n");
		}
	}
	
	
	/**
	 * 找出给定顶点的第一个邻接顶点
	 * @param graph
	 * @param v
	 * @return
	 */
	public int getFirst(Graph graph, int v) {
		 	for(int i=0;i<graph.vexs.length;i++) {
		 		if (graph.edges[v][i]==1) {
					return i;
				}
		 	}
		 	return -1;
	}
	
	/**
	 * 找出给定顶点v的第k个邻接顶点的邻接顶点
	 * @param graph
	 * @param v
	 * @param k
	 * @return
	 */
	public int getNext(Graph graph ,int v,int k) {
		for(int i=k+1;i<graph.vexs.length;i++) {
			if (graph.edges[v][i] == 1) {
				return i;
			}
		}
		return -1;
	}
	
	
	/*
	 * 深度遍历
	 * 利用visited数组标识节点是否被访问，如果被访问标识为1，继续找下一个未被访问的，
	 * 如果未被访问，则继续递归调用深度遍历。利用getFirst函数找下一层邻接顶点，利用
	 * getNext函数寻找同一层邻接顶点。
	 */
	public void DFS(Graph graph ,int v,int[] visited) {
			int next;
			System.out.println(v);
			visited[v] =1;
			next=graph.getFirst(graph, v);
			while (next!=-1) {
				if (visited[next]==0) {
					graph.DFS(graph, next,visited);
				}
				next=graph.getNext(graph, v, next);
			}
	}
	/*
	 * 广度遍历
	 * 利用队列记录广度遍历每层节点，类似于二叉树层次遍历。
	 * 利用getNext函数找到同一层的邻接顶点，利用队列保存，弹出队列元素，
	 * 再利用getFirst函数进行下一层寻找。
	 */
	public void BFS(Graph graph,int v,int[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		int next;
		queue.add(v);
		visited[v]=1;
		while (!queue.isEmpty()) {
			next=queue.remove();
			System.out.println(next);
			int vex = graph.getFirst(graph, next);
			while (vex!=-1) {
				if (visited[vex]==0) {
					queue.add(vex);
					visited[vex]=1;
				}
				vex=graph.getNext(graph, next, vex);
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		int[] vs  = {0,1,2,3,4};
		int[][] A = {
				{INF,1,INF,1,INF},
				{1,INF,1,INF,INF},
				{INF,1,INF,1,1},
				{1,INF,1,INF,1},
				{INF,INF,1,1,INF}
		};
		
		Graph graph = new Graph();
		graph.createGraph(graph, A, vs);
		graph.print_Graph(graph);
		int[] visited = new int[100];
		int[] visited1 = new int[100];
		graph.DFS(graph, 0,visited);
		System.out.println("-----------");
		graph.BFS(graph, 0, visited1);
	}
 
}
