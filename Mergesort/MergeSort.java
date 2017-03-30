public class MergeSort {

	private class Node {
		String item;
		Node next;
		Node before;
	}

	public static Node findEnd(DoubleNode<String> list, Node start) {
		Node end = start;
		while (true) {
			Node next = end.next;
			if (end.item <= next.item) {
				end = end.next;
			} else {
				break;
			}
		}
		return end;
	}

	public void sort(DoubleNode<String> list) {
		Node start = list.first;
		while (true) {
			//if (isSorted) {
			//	break;
			//}
			if (start == null){
				start = list.first;
			}
			Node mid = findEnd(list, start);
			Node end = findEnd(list, mid.next);
			merge(list, start, mid, end);
			start = end.next;
		}
	}

	public void merge(DoubleNode<String> list, Node start, Node mid, Node end) {
		Node start2 = mid.next;
		mid.next = null;
		start2.before = null;
		if (start == null) {
			mid.next = start2;
			start2.before = mid;
		} else if (start2 == null) {
			end.next = start;
			start.before = end;
		} else if (start.item > start2.item) {
			Node start2Before = start2.before;
			Node startBefore = start.before;
			start = start.next;
			start2 = start2.next;
			list.addAfterNode(startBefore.item, start2Before.item);
			list.remove(startBefore.item);
		} else {
			Node startBefore = start.before;
			Node start2Before = start2.before;
			start = start.next;
			start2 = start2.next;
			list.addAfterNode(start2Before.item, startBefore.item);
			list.remvove(start2Before.item);
		}
	}
	
	public static void main(String[] args) {
		DoubleNode<String> list = new DoubleList<String>();
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			list.addEnd(s);
		}
		for (Node i : list) {
			System.out.print(i.item + " ");
		}
		System.out.println(" ");
	}
}
