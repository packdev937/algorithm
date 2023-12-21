package baekjoon.data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _15815 {

    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
	stack.push(Character.getNumericValue(ch));
            } else {
	int operand2 = stack.pop();
	int operand1 = stack.pop();

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
        System.out.println(stack.peek());
    }
}
