// package Stacks;
import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
	
	private Node first;
	private int N;

	private class Node {
		Item item;
		Node next;
	}

	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		oldfirst = null;
		N++;
	}

	public Item pop() {
		Item item = first.item;
		first = first.next;
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