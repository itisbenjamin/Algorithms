public class PriorityQueue {

	private static int FIFOTime(int[] queueIn) {
		int time = 0;
		int size = queueIn.length;
		Queue<Integer> timeQ = new Queue<Integer>();
		int[] queue = new int[size];

		for (int i = 0; i < size; i++) {
			queue[i] = queueIn[i];
		}

		for (int i = 0; i < size; i++) {
			int item = queue[i];
			time = time + item;
			timeQ.enqueue(time);
		}
		
		int t = 0;
		while (!timeQ.isEmpty()) {
			t += timeQ.dequeue();
		}
		int average = t / size;
		return average;
	}

	private static int SJFTime(int[] queueIn) {
		int time = 0;
		int size = queueIn.length;
		Queue<Integer> timeQ = new Queue<Integer>();
		int[] queue = new int[size];

		for (int i = 0; i < size; i++) {
			queue[i] = queueIn[i];
		}
		Heapsort.sort(queue);
		for (int i = 0; i < size; i++) {
			time = time + queue[i];
			timeQ.enqueue(time);
		}

		int t = 0;
		while (!timeQ.isEmpty()) {
			t += timeQ.dequeue();
		}

		int average = t / size;
		return average;
	}

	private static int RRTime(int[] queueIn, int slice) {
		int time = 0;
		int size = queueIn.length;
		Queue<Integer> timeQ = new Queue<Integer>();
		Queue<Integer> q = new Queue<Integer>();
		int[] queue = new int[size];

		for (int i = 0; i < size; i++) {
			queue[i] = queueIn[i];
		}
		for (int i = 0; i < size; i++) {
			q.enqueue(queue[i]);
		}

		while (!q.isEmpty()) {
			int i = q.dequeue();
			if (i <= slice) {
	 	 		time = time + i;
				timeQ.enqueue(time);
			} else {
	  	 		i -= slice;
				time = time + slice;
				timeQ.enqueue(time);
				q.enqueue(i);
			}
		}

		int t = 0;
		while (!timeQ.isEmpty()) {
			t += timeQ.dequeue();
		}

		int average = t / size;
		return average;
	}

	public static void main(String[] args) {

		int[] queue = StdIn.readAllInts();

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

/* 
 * $ more input.txt 
 * 59 81 82 97 32 96 35 7 33 76 92 36 17 10 40 8 31 11 97 61 88 18 26 78 26 7 9 49 80 68 31 12 51 68 25 41 77 70 64 26 52 55 86 95 58 48 20 71 20 91 8 63 41 88 80 3 1 93 76 35 11 6 50 18 29 16 24 81 18 48 76 30 27 28 68 61 35 11 39 60 12 78 29 96 40 24 67 4 84 78 19 1 57 55 31 20 80 59 92 47 
 *
 * $ javac PriorityQueue.java 
 * $ java PriorityQueue < input.txt 
 * The turnaround time for FIFO queue is 2424
 * The turnaround time for SJF queue is 1547
 * The turnaround time for RR queue is 6861
 * The turnaround time for RR queue with the slice of 5 is 23547
 * The turnaround time for RR queue with the slice of 10 is 12396
 * The turnaround time for RR queue with the slice of 15 is 9169
 * The turnaround time for RR queue with the slice of 20 is 6861
 * The turnaround time for RR queue with the slice of 25 is 6162
 * The turnaround time for RR queue with the slice of 30 is 5327
 * The turnaround time for RR queue with the slice of 35 is 4650
 * The turnaround time for RR queue with the slice of 40 is 4304
 * The turnaround time for RR queue with the slice of 45 is 4134
 * The turnaround time for RR queue with the slice of 50 is 3690
 * The turnaround time for RR queue with the slice of 55 is 3678
 * The turnaround time for RR queue with the slice of 60 is 3598
 * The turnaround time for RR queue with the slice of 65 is 3540
 * The turnaround time for RR queue with the slice of 70 is 3418
 * The turnaround time for RR queue with the slice of 75 is 3461
 * The turnaround time for RR queue with the slice of 80 is 3069
 * The turnaround time for RR queue with the slice of 85 is 2928
 * The turnaround time for RR queue with the slice of 90 is 2821
 * The turnaround time for RR queue with the slice of 95 is 2608
 * The turnaround time for RR queue with the slice of 100 is 2424
 */
