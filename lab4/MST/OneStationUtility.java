public class OneStationUtility {
    private static final double FLOATING_POINT_EPSILON = 1E-12;
    
	private double weight;
	private Queue<Edge> mst = new Queue<Edge>();

    public OneStationUtility(EdgeWeightedGraph G, int station, int other1, int other2, int other3, int other4) {
		MinPQ<Edge> pq = new MinPQ<Edge>();
		for (Edge e : G.edges()) {
			pq.insert(e);
		}

		UF uf = new UF(G.V());
		while (!pq.isEmpty() && mst.size() < G.V() - 5) {
			Edge e = pq.delMin();
			int v = e.either();
			int w = e.other(v);
			if (checkOtherStations(v, w, other1, other2, other3, other4)) continue;
			if (!uf.connected(v, w) && !uf.connected(v, station)) {
				uf. union(v,  w);
				mst.enqueue(e);
				weight += e.weight();
			}
		}
    }

	private boolean checkOtherStations(int v, int w, int other1, int other2, int other3, int other4) {
		if (v == other1 || v == other2 || v == other3 || v == other4) return true;
		if (w == other1 || w == other2 || w == other3 || w == other4) return true;
		return false;
	}

	public Iterable<Edge> edges() {
		return mst;
	}

    public double weight() {
        return weight;
    }

	public void show() {
		for (Edge e : this.edges()) {
			StdOut.println(e);
		}
		StdOut.println(this.weight());
	}

    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        //OneStationUtility mst1 = new OneStationUtility(G, 7, 14, 28, 25, 40);
        //OneStationUtility mst2 = new OneStationUtility(G, 14, 7, 28, 25, 40);
        //OneStationUtility mst3 = new OneStationUtility(G, 28, 7, 14, 25, 40);
        //OneStationUtility mst4 = new OneStationUtility(G, 25, 7, 14, 28, 40);
        OneStationUtility mst5 = new OneStationUtility(G, 40, 7, 14, 28, 25);
		//mst1.show();
		//mst2.show();
		//mst3.show();
		//mst4.show();
		mst5.show();
		/*double minWeight = mst1.weight();
		int stationNum = 7;
		if (mst2.weight() < minWeight) {
			minWeight = mst2.weight();
			stationNum = 14;
		}
		if (mst3.weight() < minWeight) {
			minWeight = mst3.weight();
			stationNum = 28;
		}
		if (mst4.weight() < minWeight) {
			minWeight = mst4.weight();
			stationNum = 25;
		}
		if (mst5.weight() < minWeight) {
			minWeight = mst5.weight();
			stationNum = 40;
		}
		System.out.println("The only station should be kept is station " + stationNum + ", and the lowest cost with keeping this station is " + minWeight);*/
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
 * javac OneStationUtility.java
 *
 * java OneStationUtility input.txt
 * 1-5 13.00000
 * 41-43 14.00000
 * 43-47 15.00000
 * 32-18 15.00000
 * 17-32 15.00000
 * 5-7 15.00000
 * 3-8 15.00000
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
 * 3-21 20.00000
 * 45-11 21.00000
 * 6-9 21.00000
 * 10-12 22.00000
 * 41-45 23.00000
 * 3-12 23.00000
 * 42-44 24.00000
 * 33-38 25.00000
 * 33-39 25.00000
 * 17-23 25.00000
 * 37-38 25.00000
 * 15-20 25.00000
 * 36-39 25.00000
 * 27-34 25.00000
 * 34-41 25.00000
 * 17-22 28.00000
 * 13-15 28.00000
* 10-13 28.00000
* 20-26 30.00000
* 19-20 30.00000
* 45-46 30.00000
* 16-17 30.00000
* 30-37 30.00000
* 39-35 30.00000
* 23-29 32.00000
* 0-1 33.00000
* 983.0
* 1-5 13.00000
* 41-43 14.00000
* 43-47 15.00000
* 32-18 15.00000
* 17-32 15.00000
* 3-14 15.00000
* 46-48 15.00000
* 2-3 15.00000
* 24-29 15.00000
* 9-8 16.00000
* 0-6 17.00000
* 1-6 18.00000
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
* 33-39 25.00000
* 17-23 25.00000
* 37-38 25.00000
* 15-20 25.00000
* 36-39 25.00000
* 27-34 25.00000
* 34-41 25.00000
* 17-22 28.00000
* 13-15 28.00000
* 20-26 30.00000
* 19-20 30.00000
* 21-19 30.00000
* 0-2 30.00000
* 45-46 30.00000
* 16-17 30.00000
* 30-37 30.00000
* 39-35 30.00000
* 23-29 32.00000
* 31-37 35.00000
* 999.0
* 23-28 13.00000
* 1-5 13.00000
* 41-43 14.00000
* 43-47 15.00000
* 32-18 15.00000
* 17-32 15.00000
* 3-8 15.00000
* 46-48 15.00000
* 2-3 15.00000
* 24-29 15.00000
* 9-8 16.00000
* 0-6 17.00000
* 1-6 18.00000
* 33-49 20.00000
* 21-18 20.00000
* 39-46 20.00000
* 26-31 20.00000
* 4-5 20.00000
* 34-42 20.00000
* 3-21 20.00000
* 45-11 21.00000
* 6-9 21.00000
* 10-12 22.00000
* 41-45 23.00000
* 3-12 23.00000
* 42-44 24.00000
* 33-38 25.00000
* 33-39 25.00000
* 17-23 25.00000
* 37-38 25.00000
* 15-20 25.00000
* 36-39 25.00000
* 27-34 25.00000
* 34-41 25.00000
* 13-15 28.00000
* 20-26 30.00000
* 19-20 30.00000
* 45-46 30.00000
* 16-17 30.00000
* 30-37 30.00000
* 22-28 30.00000
* 39-35 30.00000
* 31-37 35.00000
* 29-30 35.00000
* 27-28 43.00000
* 1021.0
* 1-5 13.00000
* 41-43 14.00000
* 43-47 15.00000
* 32-18 15.00000
* 17-32 15.00000
* 3-8 15.00000
* 46-48 15.00000
* 2-3 15.00000
* 24-29 15.00000
* 9-8 16.00000
* 0-6 17.00000
* 1-6 18.00000
* 33-49 20.00000
* 21-18 20.00000
* 39-46 20.00000
* 26-31 20.00000
* 4-5 20.00000
* 34-42 20.00000
* 3-21 20.00000
* 45-11 21.00000
* 6-9 21.00000
* 10-12 22.00000
* 41-45 23.00000
* 3-12 23.00000
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
* 17-22 28.00000
* 13-15 28.00000
* 10-13 28.00000
* 20-26 30.00000
* 21-19 30.00000
* 45-46 30.00000
* 16-17 30.00000
* 30-37 30.00000
* 39-35 30.00000
* 971.0
* 1-5 13.00000
* 41-43 14.00000
* 43-47 15.00000
* 32-18 15.00000
* 17-32 15.00000
* 3-8 15.00000
* 46-48 15.00000
* 2-3 15.00000
* 24-29 15.00000
* 9-8 16.00000
* 0-6 17.00000
* 1-6 18.00000
* 33-49 20.00000
* 21-18 20.00000
* 39-46 20.00000
* 26-31 20.00000
* 4-5 20.00000
* 34-42 20.00000
* 3-21 20.00000
* 45-11 21.00000
* 6-9 21.00000
* 10-12 22.00000
* 41-45 23.00000
* 3-12 23.00000
* 42-44 24.00000
* 33-38 25.00000
* 33-39 25.00000
* 17-23 25.00000
* 37-38 25.00000
* 15-20 25.00000
* 36-39 25.00000
* 27-34 25.00000
* 34-41 25.00000
* 41-40 27.00000
* 17-22 28.00000
* 13-15 28.00000
* 10-13 28.00000
* 20-26 30.00000
* 19-20 30.00000
* 16-17 30.00000
* 30-37 30.00000
* 36-40 30.00000
* 35-41 30.00000
* 23-29 32.00000
* 31-37 35.00000
* 1015.0
* The only station should be kept is station 25, and the lowest cost with keeping this station is 971.0
 */
