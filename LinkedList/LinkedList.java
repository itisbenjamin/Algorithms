public class LinkedList {
	private static void printList(DoubleNode<String> doubleNode) {
		for (String item : doubleNode) {
			System.out.print(item + " ");
		}
		System.out.println(" ");
	}

	public static void main(String[] args) {
		
		DoubleNode<String> doubleNode = new DoubleNode<String>();

		System.out.println("Add to the begainning of the list: ");
		doubleNode.addBegainning("addBegainning");
		printList(doubleNode);
		
		System.out.println("Add to the end of the list: ");
		doubleNode.addEnd("addEnd");
		printList(doubleNode);
		
		System.out.println("Add before an item of the list: ");
		doubleNode.addBeforeNode("addEnd", "addBefore");
		printList(doubleNode);
		
		System.out.println("Add after an item of the list: ");
		doubleNode.addAfterNode("addBegainning", "addAfter");
		printList(doubleNode); 
		
		System.out.println("Remove the begainning of the list: ");
		doubleNode.removeBegainning();
		printList(doubleNode);
		
		System.out.println("Remove the end of the list: ");
		doubleNode.removeEnd();
		printList(doubleNode);
		
		System.out.println("Add to the begainning of the list: ");
		doubleNode.addBegainning("addBegainning");
		printList(doubleNode);

		System.out.println("Remove an item of the list: ");
		doubleNode.remove("addAfter");
		printList(doubleNode);
		
		System.out.println("Add to the end of the list: ");
		doubleNode.addEnd("addEnd");
		printList(doubleNode);
		
		System.out.println("Move an item to the front of the list: ");
		doubleNode.moveToFront("addBefore");
		printList(doubleNode);
		
		System.out.println("Move an item to the end of the list: ");
		doubleNode.moveToEnd("addBegainning");
		printList(doubleNode);
	}
}
