import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {

	private Node first;
	private Node last;
	private int N;

	private class Node {
		Item item;
		Node next;
	}

	public void enqueue(Item item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		} else {
			oldlast.next = last;
		}
		N++;
	}

	public Item dequeue() {
		Item item = first.item;
		first = first.next;
		if (isEmpty()) {
			last = null;
		}
		N--;
		return item;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		public boolean hasNext() {
			return current != null;
		}
		public void remove() {		}
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
} 
