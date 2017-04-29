public class SeparateChainingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;
    
    private int n;
    private int m;
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }
    
    public SeparateChainingHashST(int m) {
        this.m = m;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++)
            st[i] = new SequentialSearchST<Key, Value>();
    }

    private void resize(int chains) {
        SeparateChainingHashST<Key, Value> temp = new SeparateChainingHashST<Key, Value>(chains);
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.m  = temp.m;
        this.n  = temp.n;
        this.st = temp.st;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        int i = hash(key);
        return st[i].get(key);
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }

        if (n >= 10*m) resize(2*m);
        
        int i = hash(key);
        if (!st[i].contains(key)) n++;
        st[i].put(key, val);
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        
        int i = hash(key);
        if (st[i].contains(key)) n--;
        st[i].delete(key);

        if (m > INIT_CAPACITY && n <= 2*m) resize(m/2);
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys())
                queue.enqueue(key);
        }
        return queue;
    }

	public void addBeginning(SeparateChainingHashST<String, Integer> st, String input) {
		for (String s : st.keys()) {
			String ns = s.substring(1);
			if (st.hash(ns) == st.hash(input) && ns.equals(input)) {
				System.out.println("the misspelled word is " + input + ", and the possible word by adding one character to the beginning is " + s);
			}
		}
	}

	public void addEnd(SeparateChainingHashST<String, Integer> st, String input) {
		for (String s : st.keys()) {
			String ns = s.substring(0, s.length() - 1);
			if (st.hash(ns) == st.hash(input) && ns.equals(input)) {
				System.out.println("the misspelled word is " + input + ", and the possible word by adding one character to the end is " + s);
			}
		}
	}

	public void removeToBeginning(SeparateChainingHashST<String, Integer> st, String input) {
		for (String s : st.keys()) {
			if (s.length() == input.length()) {
				for  (int i = 1; i < s.length(); i ++) {
			 		String ns = input.charAt(i) + input.substring(0, i) + input.substring(i + 1);
					if (st.hash(ns) == st.hash(s) && ns.equals(s)) {
						System.out.println("the misspelled word is " + input + ", and the possible word by removing the " + i + "th character to the beginning is "+ s);
					}
				}
			}
		}
	}

	public void removeFromEnd(SeparateChainingHashST<String, Integer> st, String input) {
		for (String s : st.keys()) {
			String ns = input.substring(0, input.length() - 1);
			if (st.hash(ns) == st.hash(s) && ns.equals(s)) {
				System.out.println("the misspelled word is " + input + ", and the possible word by removing one character from the end is " + s);
			}
		}
	}

	public void exchangeAdjacent(SeparateChainingHashST<String, Integer> st, String input) {
		for (String s : st.keys()) {
			if (s.length() == input.length()) {
				for (int i = 0; i < s.length(); i++) {
					if (i == 0) {
						String ns = input.charAt(i + 1) + input.charAt(i) + input.substring(i + 2);
						if (st.hash(ns) == st.hash(s) && ns.equals(s)) {
							System.out.println("the misspelled word is " + input + ", and the possible word by exchanging the first character with its adjacents is " + s);
						}
					} else if (i == s.length() - 1) {
						String ns = input.substring(0, i - 1) + input.charAt(i) + input.charAt(i - 1);
						if (st.hash(ns) == st.hash(s) && ns.equals(s)) {
							System.out.println("the misspelled word is " + input + ", and the possible word by exchanging the last character with its adjacents is " + s);
						}
					} else {
						String ns1 = input.substring(0, i - 1) + input.charAt(i) + input.charAt(i - 1) + input.substring(i + 1);
						String ns2 = input.substring(0, i) + input.charAt(i + 1) + input.charAt(i) + input.substring(i + 2);
						if ((st.hash(ns1) == st.hash(s) && ns1.equals(s)) || (st.hash(ns2) == st.hash(s) && ns2.equals(s))) {
							System.out.println("the misspelled word is " + input + ", and the possible word by exchanging the " + i + " th character with its adjacents is " + s);
						}
					}
				}
			}
		}
	}

    public static void main(String[] args) {
        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
		st.addBeginning(st, args[0]);
		st.addEnd(st, args[0]);
		st.removeToBeginning(st, args[0]);
		st.removeFromEnd(st, args[0]);
		st.exchangeAdjacent(st, args[0]);
	}
}

/*
 * $ javac SeparateChainningHashST.java
 *
 * $ java SeparateChainingHashST orld < leipzig100K.txt 
 * the misspelled word is orld, and the possible word by adding one character to the beginning is world
 * the misspelled word is orld, and the possible word by adding one character to the beginning is World
 * the misspelled word is orld, and the possible word by removing the 2th character to the beginning is lord
 *
 * $ java SeparateChainingHashST ab < leipzig100K.txt 
 * the misspelled word is ab, and the possible word by adding one character to the beginning is dab
 * the misspelled word is ab, and the possible word by adding one character to the beginning is Bab
 * the misspelled word is ab, and the possible word by adding one character to the beginning is Tab
 * the misspelled word is ab, and the possible word by adding one character to the beginning is Cab
 * the misspelled word is ab, and the possible word by adding one character to the beginning is gab
 * the misspelled word is ab, and the possible word by adding one character to the beginning is lab
 * the misspelled word is ab, and the possible word by adding one character to the beginning is Lab
 * the misspelled word is ab, and the possible word by adding one character to the beginning is tab
 * the misspelled word is ab, and the possible word by adding one character to the beginning is cab
 * the misspelled word is ab, and the possible word by adding one character to the end is abd
 * the misspelled word is ab, and the possible word by removing one character from the end is a
 */
