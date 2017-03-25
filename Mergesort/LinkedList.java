import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item> {
	
	private Node first;
	private Node last;

	private class Node {
		Item item;
		Node next;
	}

	private Node loopItem(Item item, LinkedList list) {
		Node current = null;
		for (i : list) {
			if (i.item == item) {
				current = i;
			}
		}
		return current;
	}

	public void add(Item item) {
		Node oldfirst = first;
		first.item = item;
		first.next = oldfirst;
		oldfirst = null;
		N++;
	}

	public Node remove(Item item, LinkedList list) {
		Node current = loopItem(item, list);
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
		private Node current - first;
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
