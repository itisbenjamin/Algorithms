public class PriorityQueue {

	private static int FIFOTime(int[] queue) {
		int time = 0;
		int size = queue.length;//queue.size();
		Queue<Integer> timeQ = new Queue<Integer>();

		for (int i = 0; i < size; i++) {
			int item = queue[i];
			//System.out.print(item + " ");
			time = time + item;
			timeQ.enqueue(time);
			/*if (i == 0) {
				time = item;
			} else {
				time = time + queue[i-1] + item;
			}*/
			//time = time * 2 + item;
			//System.out.print(time + " ");
		}
		//System.out.println(" ");
		
		int t = 0;
		while (!timeQ.isEmpty()) {
			t += timeQ.dequeue();
		}
		/*
		while (true) {
			if (queue.isEmpty()) {
				break;
			}
			time = time * 2 + queue.dequeue();
		}*/

		//System.out.println(t);
		int average = t / size;
		return average;
	}

	private static int SJFTime(int[] queue) {
		int time = 0;
		int size = queue.length;//queue.size();
		Queue<Integer> timeQ = new Queue<Integer>();

		//Comparable[] a = new Comparable[size];
		//for (int i = 0; i < size; i++) {
		//	a[i] = queue[i];
			//a[i] = queue.dequeue();
		//}
		Heapsort.sort(queue);
		for (int i = 0; i < size; i++) {
			System.out.print(queue[i] + " ");
		}
		for (int i = 0; i < size; i++) {
			time = time + queue[i];
			timeQ.enqueue(time);
		}

		int t = 0;
		while (!timeQ.isEmpty()) {
			t += timeQ.dequeue();
		}

		//System.out.println(t);
		int average = t / size;
		return average;
	}

	private static int RRTime(int[] queue, int slice) {
		int time = 0;
		int size = queue.length;//queue.size();
		Queue<Integer> timeQ = new Queue<Integer>();
		//int n = size;
		//int i = 0;

		/*while (true) {
			if (n == 0) {
				break;
			}
			int item = queue[i];
			if (item != null) {
				if (item <= slice) {
					time = time * 2 + item;
					n--;
				} else {
					queue[i] = item - slice;
					time = time * 2 + slice;
				}
			} 
		}
	}*/
		Queue<Integer> q = new Queue<Integer>();
		for (int i = 0; i < size; i++) {
			q.enqueue(queue[i]);
		}

		while (!q.isEmpty()) {
			int i = q.dequeue();
			//System.out.print(i + " ");
			if (i <= slice) {
	 			time = time + i;
				timeQ.enqueue(time);
			} else {
	  			i -= slice;
				time = time + slice;
				//System.out.print(i + " ");
				timeQ.enqueue(time);
				q.enqueue(i);
			}
		}
		//System.out.println(" ");

		int t = 0;
		while (!timeQ.isEmpty()) {
			t += timeQ.dequeue();
		}

		//System.out.println(t);
		int average = t / size;
		return average;
	}

	public static void main(String[] args) {
		//Queue<Integer> queue1 = new Queue<Integer>();
		//Queue<Integer> queue2 = new Queue<Integer>();
		//Queue<Integer> queue3 = new Queue<Integer>();

		int[] queue = StdIn.readAllInts();
		/*int[] queue = new int[5];
		int i = 0;

		while (!StdIn.isEmpty()) {
			int s = StdIn.readInt();
			queue[i] = s;
			i++;*/
			//queue1.enqueue(s);
			//queue2.enqueue(s);
			//queue3.enqueue(s);
		//}

		int FIFOTime = FIFOTime(queue);
		int SJFTime = SJFTime(queue);
		int RRTime = RRTime(queue, 20);

		System.out.println("The turnaround time for FIFO queue is " + FIFOTime);
		System.out.println("The turnaround time for SJF queue is " + SJFTime);
		System.out.println("The turnaround time for RR queue is " + RRTime);

		for (int i = 5; i <= 100; i = i + 5) {
			int increaseRR = RRTime(queue, i);
			System.out.println("The turnaround time for RR queue with the slice of " + i + " is " + increaseRR);
		}
	}
}
