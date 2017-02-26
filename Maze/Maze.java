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
			} else if (down < N * N) {
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

	public static void draw(int[][] draw, int N) {
		for (int i = 0; i < N; i++) {
			System.out.print("+---");
		}
		System.out.print("+\n");
		int k = 0;
		//int j = 0;
		while (true) {
			if (k == N * 2 - 1) {
				break;
			}
			if (k % 2 == 0) {
		 		System.out.print("|   ");
				for (int j = N * k / 2; j < N * (k / 2 + 1) - 1; j++) {
 					if (draw[j][j + 1] != -1) {
						System.out.print("    ");
					} else {
						System.out.print("|   ");
					}
	 			}
				System.out.print("|\n");
			} else {
 				for (int j = N * (k - 1) / 2; j < N * (k + 1) / 2; j++) {
	   				if (draw[j][j + N] != -1) {
						System.out.print("+   ");
					} else {
						System.out.print("+---");
					}
				}
				System.out.print("+\n");
			}
			k++;
		}
		for (int i = 0; i < N; i++) {
			System.out.print("+---");
		}
		System.out.print("+\n");
	}

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int[][] draw = new int[N * N][N * N];
		Maze m = new Maze(N);
		for (int i = 0; i < N * N; i++) {
			for (int j = 0; j < N * N; j++){
				draw[i][j] = -1;
			}
		}
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
			if (p > q) {
				draw[q][p] = 1;
			} else {
				draw[p][q] = 1;
			}
			//System.out.println(p + " " + q);
		}
		//System.out.println(m.count() + " components. ");
		draw(draw, N);
	}
}
