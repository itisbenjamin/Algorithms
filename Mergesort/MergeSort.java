public class MergeSort {
	
	private Node first;
	private Node last;
	private int n;

	private class Node {
		private int item;
		private Node next;
	}

	public MergeSort() {
		first = null;
		last = null;
		n = 0;
	}

	public void sort() {
		Node start = first;
		while (true) {
			if (isSorted(first, last)) {
				break;
			}
			if (start == null) {
				start = first;
			}
			Node mid = findEnd(start);
			Node end = findEnd(mid.next);
			merge(start, mid, end);
			start = end.next;
		}
	}

	public void merge(Node start, Node mid, Node end) {
		Node start2 = mid.next;
		while (true) {
			Node startNext = start.next;
			Node start2Next = start2.next;
			Node midNext = mid.next;

			if (start == midNext || startNext == null || start2Next == null) {
				break;
			}
			if (startNext.item < start2.item && start != mid) {
		 		start = startNext;
				if (start == mid) {
	 				mid.next = start2; 
					break;
				}
			} else if (start2Next.item < start.item && start2 != end) {
	 			start2 = start2Next;
				if (start2 == end) {
			 		mid.next = end.next; 
					end.next = start;
					break;
				}
			} else if (start.item < start2.item) {
			 	Node oldstart = start;
				start = startNext;
				oldstart.next = start2;
			} else {
				Node oldstart2 = start2; 
				start2 = start2.next;
				oldstart2.next = start;
			}
		}
	}

	public boolean isSorted(Node start, Node end) {
		while (true) {
			Node next = start.next;
			if (start.item > next.item) {
				return false;
			} else if (next == end) {
				break;
			}
			start = next;
		}
		return true;
	} 

	public Node findEnd(Node start) {
		Node end = start;
		while (true) {
			Node next = end.next;
			if (next == null) {
				break;
			} else if (end.item <= next.item) {
				end = end.next;
			} else {
				break;
			}
		}
		return end;
	}

	public void add(int item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		} else {
			oldlast.next = last;
		}
 		n++;
	}

	public void linkItems(Node i, Node j) {
		i.next = j;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	public void show() {
		Node i = first;
		while (true) {
			if (i == null) {
				break;
			}
			System.out.print(i.item + " ");
			i = i.next;
		}
		System.out.println(" ");
	}

	public static void main(String[] args) {
		MergeSort list = new MergeSort();
		while (!StdIn.isEmpty()) {
			int i = StdIn.readInt();
			list.add(i);
		}
		list.show();
		list.sort();
		list.show();
	}
}

/*
 * $ more input.txt
 * 3 8 19 7 11 12 20 89  
 *
 * $ javac MergeSort.java
 * $ java MergeSort < input.txt 
 * 3 8 19 7 11 12 20 89  
 * 3 7 8 11 12 19 20 89 
 */
