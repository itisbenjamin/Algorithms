public class randomInput {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		for (int i = 0; i < n; i++) {
			int out = StdRandom.uniform(100);
			System.out.print(out + " ");
		}
	}
}
