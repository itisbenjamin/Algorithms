public class Maze {
	
	private int[] id;
	private int count;

	public Maze(int N) {
		count = N * N;
		id = new int[N * N];

		for (int i = 0; i < N * N; i++) {
			id[i] = i;
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

	public static int findQ(int p, int N) {
		int q = -1;
		int up = p - N;
		int down = p + N;
		int left = p - 1;
		int right = p + 1;
		if (StdRandom.bernoulli(0.5)) {
			if (StdRandom.bernoulli(0.5) && up > -1) {
				q = up;
			} else if (down < 25) {
				q = down;
			}
		} else {
			if (StdRandom.bernoulli(0.5) && (left + 1) % N != 0) {
				q = left;
			} else if (right % N != 0) {
				q = right;
			}
		}
		return q;
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

	public static void draw(int[] draw) {
		for (int i = 0; i < N; i++) {
			System.out.print("+---");
		}
			System.out.print("+\n");
		System.out.print("|   ");
		for (int i = 0; i < N; i++) {
			if (m.connected(i, draw(i))) {
				System.out.print(" ");
			} else {
				System.out.print("|");
			}
		}
		}

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int[] draw = new int[N * N];
		Maze m = new Maze(N);
		while (true) {
			if (m.connected(0, N * N - 1)) {
				break;
			}
			int p = StdRandom.uniform(N * N);
			int q = findQ(p, N);
			if (q == -1) {
				continue;
			}
			if (m.connected(p, q)) {
				continue;
			}
			m.union(p, q);
			draw[p] = q;
			System.out.println(p + " " + q);
		}
		System.out.println(m.count() + " components. ");
	}
}
