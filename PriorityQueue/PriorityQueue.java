public class PriorityQueue {

	private static int FIFOTime(Queue<Integer> queue) {
		int time = 0;
		int size = queue.size();

		while (true) {
			if (queue.isEmpty()) {
				break;
			}
			time = time * 2 + queue.dequeue();
		}
		int average = time / size;
		return average;
	}

	private static int SJFTime(Queue<Integer> queue) {
		int time = 0;
		int size = queue.size();

		Comparable[] a = new Comparable[size];
		for (int i = 0; i < a.length; i++) {
			a[i] = queue.dequeue();
		}
		Heapsort.sort(a);
		for (int i = 0; i < a.length; i++) {
			time = time * 2 + (int)a[i];
		}

		int average = time / size;
		return average;
	}

	private static int RRTime(Queue<Integer> queue, int slice) {
		int time = 0;
		int size = queue.size();

		while (!queue.isEmpty()) {
			int i = queue.dequeue();
			if (i <= slice) {
				time = time * 2 + i;
			} else {
				i -= slice;
				time = time * 2 + slice;
				queue.enqueue(i);
			}
		}

		int average = time / size;
		return average;
	}

	public static void main(String[] args) {
		Queue<Integer> queue1 = new Queue<Integer>();
		Queue<Integer> queue2 = new Queue<Integer>();
		Queue<Integer> queue3 = new Queue<Integer>();

		while (!StdIn.isEmpty()) {
			int s = StdIn.readInt();
			queue1.enqueue(s);
			queue2.enqueue(s);
			queue3.enqueue(s);
		}

		int FIFOTime = FIFOTime(queue1);
		int SJFTime = SJFTime(queue2);
		int RRTime = RRTime(queue3, 20);

		System.out.println("The turnaround time for FIFO queue is " + FIFOTime);
		System.out.println("The turnaround time for SJF queue is " + SJFTime);
		System.out.println("The turnaround time for RR queue is " + RRTime);

		/*for (int i = 0; i <= 100; i = i + 5) {
			int increaseRR = RRTime(queue, i);
			System.out.println("The turnaround time for RR queue with the slice of " + i + " is " + increaseRR);
		}*/
	}
}
