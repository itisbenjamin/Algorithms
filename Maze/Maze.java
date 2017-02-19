public class Maze {
	
	private int[] id;
	//private int index;
	private int count;

	public Maze(int N) {
		count = N * N;
		//index = 0;
		id = new int[N * N];

		for (int i = 0; i < N * N; i++) {
			//for (int j = 0; j < N; j++) {
				id[i] = i;
				//index++;
			//}
		}
	}
	
	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot) {
			return;
		}
		id[pRoot] = qRoot;
	
		count--;
	}

	public int find(int p) {
		while (p != id[p]) {
			p = id[p];
		}
		return p;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public int count() {
		return count;
	}

/*	public static void breakWall() {
		int p = StdRandom.uniform(N * N);
		if (p == 0) {
			}}*/

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		Maze m = new Maze(N);
		while (true) {
			if (m.connected(0, N - 1)) {
				break;
			}
			int p = StdRandom.uniform(N * N);
			int q = StdRandom.uniform(N * N);
			if (m.connected(p, q)) {
				continue;
			}
			m.union(p, q);
			System.out.println(p + " " + q);
		}
		System.out.println(m.count() + " components. ");
	}
}
