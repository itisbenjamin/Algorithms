public class QuicksortPivot {

	private QuicksortPivot() {	}

	public static void sort(Comparable[] a) {
		//StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
		assert isSorted(a);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
		assert isSorted(a, lo, hi);
	}

	private static int getMedian(Comparable[] a, int left, int center, int right) {
		return (less(a[left], a[center]) ? (less(a[center], a[right]) ? center : less(a[left], a[right]) ? right : left) : (less(a[right], a[center]) ? center : less(a[right], a[left]) ? right : left));
	}

	private static int partition(Comparable[] a, int lo, int hi) {
		int num = hi - lo + 1;
		int i = lo;
		int j = hi + 1;
		int k = getMedian(a, lo, lo + num / 2, hi);
		Comparable v = a[k];
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
	
		if (eq(v, a[lo])) {
			exch(a, k, j);
			return j;
		} else if (eq(v, a[hi])) {
			exch(a, k, i);
			return i;
		} //else if (v.compareTo(a[k + 1]) > 0){
		//	exch(a, k, k + 1);
	//	}
	
		return k;
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static boolean eq(Comparable v, Comparable w) {
		return v.compareTo(w) == 0;
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
		QuicksortPivot.sort(a);
		show(a);
		assert isSorted(a);
	}
}
