public class QuicksortCutoff {

	//private static final int INSERTION_SORT_CUTOFF = 8;
	//private static final int ME

	private QuicksortCutoff() {	}

	public static void sort(Comparable[] a, int cutoff) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1, cutoff);
		assert isSorted(a);
	}

	private static void sort(Comparable[] a, int lo, int hi, int cutoff) {

		int n = hi - lo + 1;

		if (n <= cutoff) {
			insertionSort(a, lo, hi);
			return;
		}

		if (hi <= lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1, cutoff);
		sort(a, j + 1, hi, cutoff);
		assert isSorted(a, lo, hi);
	}
 
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		Comparable v = a[lo];
		while (true) {
			while (less(a[++i], v)) {
				if (i == hi) break;
			}
			while (less(v, a[--j])) {
				if (j == lo) break;
			}
			if (i >= j) break;
		
			exch(a, i, j);
		}
	
		exch(a, lo, j);
	
		return j;
	}

	private static void insertionSort(Comparable[] a, int lo, int hi) {
		for (int i = lo; i <= hi; i++) {
			for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Object[] a, int i, int j) {
		Object tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	private static boolean isSorted(Comparable[] a) {
		return isSorted(a, 0, a.length - 1);
	}

	private static boolean isSorted(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++) {
			if (less(a[i], a[i-1])) return false;
		}
	return true;
	}
	
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println(" ");
	}

	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		for (int n = 0; n < 31; n++) {
			Stopwatch timer = new Stopwatch();
			QuicksortCutoff.sort(a, n);
			double time = timer.elapsedTime();
			System.out.println(n + " " + time);
		}
		//show(a);
		assert isSorted(a);
	}
}
