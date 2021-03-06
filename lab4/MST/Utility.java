public class Utility {
    private static final double FLOATING_POINT_EPSILON = 1E-12;
	private static final int station1 = 7;
	private static final int station2 = 14;
	private static final int station3 = 28;
	private static final int station4 = 25;
	private static final int station5 = 40;
    
	private double weight;
	private Queue<Edge> mst = new Queue<Edge>();

    public Utility(EdgeWeightedGraph G) {
		MinPQ<Edge> pq = new MinPQ<Edge>();
		for (Edge e : G.edges()) {
			pq.insert(e);
		}

		UF uf = new UF(G.V());
		while (!pq.isEmpty() && mst.size() < G.V() - 1) {
			Edge e = pq.delMin();
			int v = e.either();
			int w = e.other(v);
			if (!uf.connected(v, w) && !connectedToStations(uf, v, station1, station2, station3, station4, station5)) {
				uf.union(v, w);
				mst.enqueue(e);
				weight += e.weight();
			}
		}
    }

	private boolean connectedToStations(UF uf, int v, int s1, int s2, int s3, int s4, int s5) {
		return uf.connected(v, s1) || uf.connected(v, s2) || uf.connected(v, station3) || uf.connected(v, station4) || uf.connected(v, station5);
	}

	public Iterable<Edge> edges() {
		return mst;
	}

    public double weight() {
        return weight;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        Utility mst = new Utility(G);
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.printf("%.5f\n", mst.weight());
    }
    
    
}

/*
 * more input.txt
 * 50
 * 128
 * 0 1 33
 * 0 2 30
 * 0 6 17
 * 0 9 25
 * 1 6 18
 * 1 4 25
 * 1 5 13
 * 4 5 20
 * 5 6 20
 * 6 9 21
 * 2 9 20
 * 2 10 35
 * 2 12 27
 * 2 3 15
 * 10 13 28
 * 10 12 22
 * 4 16 40
 * 4 7 31
 * 5 7 15
 * 5 8 30
 * 6 8 25
 * 9 8 16
 * 9 3 31
 * 3 12 23
 * 12 15 30
 * 13 15 28
 * 13 20 40
 * ...
 *
 * javac Utility.java
 *
 * java Utility input.txt
 * 23-28 13.00000
 * 1-5 13.00000
 * 41-43 14.00000
 * 43-47 15.00000
 * 32-18 15.00000
 * 17-32 15.00000
 * 5-7 15.00000
 * 3-14 15.00000
 * 46-48 15.00000
 * 2-3 15.00000
 * 24-29 15.00000
 * 9-8 16.00000
 * 0-6 17.00000
 * 33-49 20.00000
 * 21-18 20.00000
 * 39-46 20.00000
 * 26-31 20.00000
 * 4-5 20.00000
 * 34-42 20.00000
 * 45-11 21.00000
 * 6-9 21.00000
 * 12-14 22.00000
 * 10-12 22.00000
 * 41-45 23.00000
 * 42-44 24.00000
 * 33-38 25.00000
 * 19-25 25.00000
 * 33-39 25.00000
 * 17-23 25.00000
 * 37-38 25.00000
 * 15-20 25.00000
 * 36-39 25.00000
 * 27-34 25.00000
 * 24-25 25.00000
 * 34-41 25.00000
* 41-40 27.00000
* 13-15 28.00000
* 20-26 30.00000
* 0-2 30.00000
* 16-17 30.00000
* 30-37 30.00000
* 22-28 30.00000
* 36-40 30.00000
* 35-41 30.00000
* 31-37 35.00000
* 996.00000
 */
