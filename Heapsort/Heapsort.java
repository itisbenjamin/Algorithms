public class Heapsort {

	private Heapsort() {	}

	public static void sort(Comparable[] pq) {
		int n = pq.length;
		for (int k = (n + 1) / 3; k >= 1; k--) {
			sink(pq, k, n);
		}
		while (n > 1) {
			exch(pq, 1, n--);
			sink(pq, 1, n);
		}
	}

	private static void sink(Comparable[] pq, int k, int n) {
		while (3 * k <= n) {
			int j = 3 * k;
			if (j < n && less(pq, j, j + 1)) {
				if (less(pq, j - 1, j + 1)) {
					j = j + 1;
				} else {
					j = j - 1;
				}
			} else if (j <= n && less(pq, j, j - 1)) {
				j = j - 1;
			} else if (j == n + 1){
				j = n;
			}
			if (!less(pq, k, j)) break;
			//System.out.println(j);
			exch(pq, k, j);
			//show(pq);
			k = j;
		}
	}

	private static boolean less(Comparable[] pq, int i, int j) {
		return pq[i - 1].compareTo(pq[j - 1]) < 0;
	}

	private static void exch(Object[] pq, int i, int j) {
		Object swap = pq[i - 1];
		pq[i - 1] = pq[j - 1];
		pq[j - 1] = swap;
	}

	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] +  " ");
		}
		System.out.println(" ");
	}

	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		Heapsort.sort(a);
		show(a);
	}
}
