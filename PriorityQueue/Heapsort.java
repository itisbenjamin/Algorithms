public class Heapsort {

	public Heapsort() {	}

	public static void sort(int[] pq) {
		int n = pq.length;
		//Comparable[] pq = new Comparable[n];

		//for (int i = 0; i < n; i++) {
		//	pq[i] = input[i];
		//}
		for (int k = n / 2; k >= 1; k--) {
			sink(pq, k, n);
		}
		while (n > 1) {
			exch(pq, 1, n--);
			sink(pq, 1, n);
		}
	}

	private static void sink(int[] pq, int k, int n) {
		while (2 * k <= n) {
			int j = 2 * k;
			if (j < n && less(pq, j, j + 1)) j++;
			if (!less(pq, k, j)) break;
			exch(pq, k, j);
			k = j;
		}
	}

	private static boolean less(int[] pq, int i, int j) {
		return pq[i - 1] < pq[j - 1];
	}

	private static void exch(int[] pq, int i, int j) {
		int swap = pq[i - 1];
		pq[i - 1] = pq[j - 1];
		pq[j - 1] = swap;
	}

	private static void show(int[] input) {
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] +  " ");
		}
		System.out.println(" ");
	}

	/*public static void main(String[] args) {
		int[] a = StdIn.readAllInts();
		//for (int i = 0; i < a.length; i++) {
		//	a[i] = StdIn.readInt();
		//}
		//Comparable[] b = new Comparable[5];
		//for (int i = 0; i < a.length; i++) {
		//	b[i] = a[i];
		//}
		Heapsort.sort(a);
		show(a);
	}*/
}
