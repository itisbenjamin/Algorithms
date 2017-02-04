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
    
    public void addBegainning(Item item) {
        Node oldfirst = first;
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
        Node oldlast = last;
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
	private Node loopItem(Item item) {
		private Node current = first;
		while (current.item !== item) {
			current = current.next;
			if (current == null) {
				return -1;
			}
		}
		return current;
	}
	
    public void addBeforeNode(Item item) {
		private Node current = loopItem(item);
		while (current.item !== item) {
			current = current.next; 
			if (current == null) {
				break;
			}
		}
		if (current == null) {
			System.out.println("There is no item named " + item);
		} else {
			Node olditem = current;
			current = new Node;
			current.before = olditem.before;
			current.next = olditem;
			N++;
		}
    }
    
    public void addAfterNode(Item item) {
    	private Node current = first;
		while (current.item !== item) {
			current = current.next;
			if (current == null) {
				break;
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
    }
    
    public void moveToFront(Item item) {
    }
    
    public void moveToEnd(Item item) {
    }
}
