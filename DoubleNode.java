public class DoubleNod<Item> {
    
    private Node first;
    private Node last;
    private int N;
    
    public DoubleNode {
    }
    
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
		private Node current = first;
		while (current.item !== item) {
			current = current.next;
			if (current == null) {
				System.out.println("There is no item named " + item);
				return null;
			}
		}
		return current;
	}
    
    public void addBegainning(Item item) {
        private Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
		first.before = null;
        if (isEmpty()) {
            last == first;
        } else {
			oldfirst.before = first;
		}
        N++;
    }
    
    public void addEnd(Item item) {
        private Node oldlast = last;
        last = new Node();
        last.item = item;
		last.before = oldlast;
        last.next = null;
        if (isEmpty()) {
            first == last;
        } else {
            oldlast.next = last;
        }
        N++;
    }
 
/*
	private class Iterator<Item> {
		private Node current = first;
		public boolean hasNext() {
			return current.next != null;
		}
		public void remove() {	}
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
*/
	
    public void addBeforeNode(Item item) {
		private Node current = loopItem(item);
		/*
		while (current.item !== item) {
			current = current.next; 
			if (current == null) {
				break;
			}
		}
		*/
		if (current !== null) {
			Node olditem = current;
			current = new Node;
			current.item = item;
			current.before = olditem.before;
			current.next = olditem;
			N++;
		}
    }
    
    public void addAfterNode(Item item) {
    	private Node current = loopItem(item);
		if (current !== null) {
			Node olditem = current;
			current = new Node;
			current.item = item;
			current.before = olditem;
			current.next = oldite.next;
			N++;
		}
	}
    
    public Item removeBegainning() {
    	Item item = first.item;
		first = first.next;
		if (isEmpty()) {
			last = null;
		}
		N--;
		return item;
	}
    
    public Item removeEnd() {
    	Item item = last.item;
		last = last.before;
		if (isEmpty()) {
			pass;
		}
		N--;
		return item;
	}
    
    public void remove(Item item) {
    	private Node current = loopItem(item);
		private Node currentBefore = current.before;
		private Node currentNext = current.next;
		currentBefore.next = currentNext;
		currentNext.before = currentBefore;
		current = null;
		N--;
	}
    
    public void moveToFront(Item item) {
    	private Node current = loopItem(item);
		private Node currentBefore = current.before;
		private Node currentNext = current.next;
		currentBefore.next = currentNext;
		currentNext.before = currentBefore;
		private Node oldfirst = first;
		first = current;
		oldfirst = null;
		current.before = null;
		current.next = first;
		first.before = current;
	}
    
    public void moveToEnd(Item item) {
    }
}
