package baekjoon.data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String expression = br.readLine();
        double[] values = new double[N];

        for (int i = 0; i < N; i++) {
            values[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isLetter(ch)) {
	stack.push(values[ch - 'A']);
            } else {
	double operand2 = stack.pop();
	double operand1 = stack.pop();

	switch (ch) {
	    case '+':
	        stack.push(operand1 + operand2);
	        break;
	    case '-':
	        stack.push(operand1 - operand2);
	        break;
	    case '*':
	        stack.push(operand1 * operand2);
	        break;
	    case '/':
	        stack.push(operand1 / operand2);
	        break;
	}
            }
        }

        System.out.printf("%.2f", stack.peek());
    }
}