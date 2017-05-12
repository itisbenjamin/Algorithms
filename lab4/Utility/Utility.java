public class Utility {
	private double weight;
	private Queue<edge> mst = new Queue<Edge>();

	public Utility(EdgeWeightedGraph G) {
		MinPQ<Edge> pq = new MinPQ<Edge>();
		for (Edge e : G.edges()) {
			pq.insert(e);
		}
	
		UF uf = new UF(G)}}
