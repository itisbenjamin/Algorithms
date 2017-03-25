public class randomInput {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		for (int i = 0; i < n; i++) {
			double out = StdRandom.uniform(0.0, 30.0);
			System.out.print(out + " ");
		}
	}
}
