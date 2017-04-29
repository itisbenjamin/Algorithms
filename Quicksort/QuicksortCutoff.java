public class QuicksortCutoff {

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
		assert isSorted(a);
	}
}

/* 
 * $ javac randomInput.java
 * $ java randomInput 1000 > randomInput10E3.txt
 * $ java randomInput 10000 > randomInput10E4.txt
 * $ java randomInput 100000 > randomInput10E5.txt
 * $ java randomInput 1000000 > randomInput10E6.txt
 *
 * $ javac QuicksortCutoff.java
 * $ java QuicksortCutoff < randomInput10E3.txt 
 * 0 0.006
 * 1 0.001
 * 2 0.001
 * 3 0.001
 * 4 0.001
 * 5 0.001
 * 6 0.001
 * 7 0.001
 * 8 0.001
 * 9 0.001
 * 10 0.001
 * 11 0.001
 * 12 0.001
 * 13 0.001
 * 14 0.0
 * 15 0.0
 * 16 0.001
 * 17 0.001
 * 18 0.001
 * 19 0.001
 * 20 0.001
 * 21 0.001
 * 22 0.001
 * 23 0.001
 * 24 0.001
 * 25 0.001
 * 26 0.001
 * 27 0.0
 * 28 0.001
 * 29 0.001
 * 30 0.0
 *
 * java QuicksortCutoff < randomInput10E4.txt
 * 0 0.022
 * 1 0.009
 * 2 0.01
 * 3 0.019
 * 4 0.014
 * 5 0.018
 * 6 0.023
 * 7 0.023
 * 8 0.021
 * 9 0.014
 * 10 0.011
 * 11 0.014
 * 12 0.01
 * 13 0.005
 * 14 0.005
 * 15 0.009
 * 16 0.006
 * 17 0.016
 * 18 0.005
 * 19 0.005
 * 20 0.003
 * 21 0.005
 * 22 0.01
 * 23 0.008
 * 24 0.005
 * 25 0.006
 * 26 0.011
 * 27 0.004
 * 28 0.005
* 29 0.008
* 30 0.009
*
* $ java QuicksortCutoff < randomInput10E5.txt 
* 0 0.115
* 1 0.06
* 2 0.096
* 3 0.057
* 4 0.087
* 5 0.06
* 6 0.076
* 7 0.074
* 8 0.058
* 9 0.081
* 10 0.056
* 11 0.08
* 12 0.054
* 13 0.087
* 14 0.056
* 15 0.074
* 16 0.066
* 17 0.062
* 18 0.069
* 19 0.071
* 20 0.066
* 21 0.067
* 22 0.073
* 23 0.067
* 24 0.084
* 25 0.061
* 26 0.087
* 27 0.059
* 28 0.096
* 29 0.055
* 30 0.083
*
* $ java QuicksortCutoff < randomInput10E6.txt 
* 0 0.939
* 1 0.883
* 2 0.924
* 3 0.918
* 4 0.915
* 5 0.906
* 6 0.881
* 7 0.923
* 8 0.911
* 9 0.87
* 10 0.914
* 11 0.894
* 12 0.854
* 13 0.886
* 14 0.89
* 15 0.895
* 16 0.862
* 17 0.863
* 18 0.9
* 19 0.904
* 20 0.928
* 21 0.885
* 22 0.907
* 23 0.866
* 24 0.917
* 25 0.873
* 26 0.949
* 27 0.909
* 28 0.89
* 29 0.872
* 30 0.875
*/
