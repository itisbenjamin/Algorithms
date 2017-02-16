// package Stacks;

public class ArithmeticExpressionEvaluator {
	
	private static double EvaluatePostfix(Queue<String> output) {
		Stack<Double> calculate = new Stack<Double>();

		while (true) {
			if (output.isEmpty()) {
				break;
			}
			String val = output.dequeue();
			System.out.print(val + " ");
			if (val.equals("+")) {
				Double num1 = calculate.pop();
				Double num2 = calculate.pop();
				calculate.push(num2 + num1);
			} else if (val.equals("-")) {
		 		Double num1 = calculate.pop();
				Double num2 = calculate.pop();
				calculate.push(num2 - num1);
			} else if (val.equals("*")) {
				Double num1 = calculate.pop();
				Double num2 = calculate.pop();
	 			calculate.push(num2 * num1);
			} else if (val.equals("/")) {
	 			Double num1 = calculate.pop();
				Double num2 = calculate.pop();
				calculate.push(num2 / num1);
			} else {
				calculate.push(Double.parseDouble(val));
			}
		}
		
		return calculate.pop();
	}
	
	private static void infixToPostfix(String input, Stack<String> stack, Queue<String> output) {
		if (input.equals("(")) {		}		
		else if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {
			stack.push(input);
		} else if (input.equals(")")) {
			String op;
			while (true) {
  				if (stack.isEmpty()) {
					break;
				}
				op = stack.pop();
				output.enqueue(op);
			}
		} else {
			output.enqueue(input);
		}
	}

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		Queue<String> output = new Queue<String>();

		while (!StdIn.isEmpty()) {
 			String s = StdIn.readString();
			infixToPostfix(s, stack, output);
		}

		double answer = EvaluatePostfix(output);
		System.out.println(" ");
		System.out.println("The answer is: " + answer);
	}
}
