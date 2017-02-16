import java.util.Iterator;

public class DoubleNode<Item> implements Iterable<Item> {
    
    private Node first;
    private Node last;
    private int N;
    
    private class Node {
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
/*
	private void printResult() {
		for (Item item : DoubleNode) {
			System.out.print(item + " ");
		}
	}
  */  
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
	//	printResult();
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
        N++;
	//	printResult();
    }
	
    public void addBeforeNode(Item item, Item add) {
		Node current = loopItem(item);
		if (current != null) {
			Node olditem = new Node();
			olditem = current;
			current = new Node();
			current.item = add;
			current.before = olditem.before;
			current.next = olditem;
			N++;
		//	printResult();
		}
    }
    
    public void addAfterNode(Item item, Item add) {
    	Node current = loopItem(item);
		if (current != null) {
			Node olditem = new Node();
			olditem = current;
			current = new Node();
			current.item = add;
			current.next = olditem.next;
			current.before = olditem;
			N++;
		//	printResult();
		}
	}
    
    public void removeBegainning() {
    	Item item = first.item;
		first = first.next;
		if (isEmpty()) {
			last = null;
		}
		N--;
	//	printResult();
		//return item;
	}
    
    public void removeEnd() {
		//if (isEmpty()) {
			//return null;
		//}
    	Item item = last.item;
		last = last.before;
		N--;
	//	printResult();
		//return item;
	}

	private void linkNodes(Item item) {
		Node current = new Node();
		current = loopItem(item);
		Node currentBefore = new Node();
		currentBefore = current.before;
		Node currentNext = new Node();
		currentNext = current.next;
		currentBefore.next = currentNext;
		currentNext.before = currentBefore;
	}
    
    public void remove(Item item) {
		Node current = new Node();
		current = loopItem(item);
		linkNodes(item);
		current = null;
		N--;
	//	printResult();
	}
    
    public void moveToFront(Item item) {
		Node current = new Node();
		current = loopItem(item);
    	linkNodes(item);
		Node oldfirst = first;
		first = current;
		first.before = null;
		first.next = oldfirst;
		oldfirst = null;
//		printResult();
	}
    
    public void moveToEnd(Item item) {
		Node current = new Node();
		current = loopItem(item);
		linkNodes(item);
		Node oldend = last;
		last = current;
		last.next = null;
		last.before = oldend;
		oldend = null;
//		printResult();
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
