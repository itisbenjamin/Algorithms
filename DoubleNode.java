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
        if (isEmpty) {
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
    
    public void addBeforeNode(Item item) {
        
    }
    
    public void addAfterNode(Item item) {
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
		last
	}
    
    public void remove(Item item) {
    }
    
    public void moveToFront(Item item) {
    }
    
    public void moveToEnd(Item item) {
    }
}
