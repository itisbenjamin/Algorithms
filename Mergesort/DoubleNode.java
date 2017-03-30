import java.util.Iterator;

public class DoubleNode<Item> implements Iterable<Item> {
    
    public Node first;
    public Node last;
    private int N;
    
    public class Node {
        Item item; 
        Node next;
		Node before;
    }
    
    public boolean isEmpty() {
        return N == 0;
    }
    
    public int size() {
        return N;
    }
	
	private Node loopItem(Item item) {
		Node current = first;
		while (current.item != item) {
			current = current.next;
			if (current == null) {
				System.out.println("There is no item named " + item);
				return null;
			}
		}
		return current;
	}

    public void addBegainning(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
		first.before = null;
        if (isEmpty()) {
            last = first;
        } else {
			oldfirst.before = first;
		}
        N++;
    }
    
    public void addEnd(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
		last.before = oldlast;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
		oldlast = null;
        N++;
    }
	
    public void addBeforeNode(Item item, Item add) {
		Node current = loopItem(item);
		if (current != null) {
			Node olditem = current;
			current = new Node();
			current.item = add;
			Node oldBefore = olditem.before;
			oldBefore.next = current;
			olditem.before = current;
			current.before = oldBefore;
			current.next = olditem;
			N++;
		}
    }
    
    public void addAfterNode(Item item, Item add) {
    	Node current = loopItem(item);
		if (current != null) {
			Node olditem = current;
			current = new Node();
			current.item = add;
			Node oldAfter = olditem.next;
			oldAfter.before = current;
			olditem.next = current;
			current.next = oldAfter;
			current.before = olditem;
			N++;
		}
	}
    
    public void removeBegainning() {
    	Item item = first.item;
		first = first.next;
		first.before = null;
		if (isEmpty()) {
			last = null;
		}
		N--;
	}
    
    public void removeEnd() {
    	Item item = last.item;
		last = last.before;
		last.next = null;
		if (isEmpty()) {
			first = null;
		}
		N--;
	}

	private void linkNodes(Item item) {
		Node pointer = new Node();
		pointer = loopItem(item);
		Node pointerBefore = pointer.before;
		Node pointerNext = pointer.next;
		pointerBefore.next = pointerNext;
		pointerNext.before = pointerBefore;
		pointer = null;
	}
    
    public void remove(Item item) {
		linkNodes(item);
		N--;
	}
    
    public void moveToFront(Item item) {
		Node current = new Node();
		current = loopItem(item);
    	linkNodes(item);
		Node oldfirst = first;
		first = current;
		first.before = null;
		first.next = oldfirst;
		oldfirst.before = first;
		oldfirst = null;
		current = null;
	}
    
    public void moveToEnd(Item item) {
		Node current = new Node();
		current = loopItem(item);
		linkNodes(item);
		Node oldend = last;
		last = current;
		last.next = null;
		last.before = oldend;
		oldend.next = last;
		oldend = null;
		current = null;
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
