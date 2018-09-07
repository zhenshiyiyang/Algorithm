package 图.graph;

public class Edge {
	String beginCity;
	String endCity;
	int cost;
 
	public Edge(String beginCity, String endCity, int cost) {
		super();
		this.beginCity = beginCity;
		this.endCity = endCity;
		this.cost = cost;
	}
}
