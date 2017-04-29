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
			exch(pq, k, j);
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

/*
 * $ more input.txt 
 * A C D E B J K J A O P R T S X Z O O P V U M N I I L V S O P V S W C X V F W R S L K P I E J U K W M L S A X Z C D E R T T Y B N J F E W L M Q S D P K I W E C V S A Q Z C H P O W E R U I D M K F H G W
 * 
 * $ javac Heapsort.java
 * $ java Heapsort < input.txt 
 * A A A A B B C C C C C D D D D E E E E E E F F F G H H I I I I I J J J J K K K K K L L L L M M M M N N O O O O O P P P P P P Q Q R R R R S S S S S S S T T T U U U V V V V V W W W W W W W X X X Y Z Z Z  
 */
