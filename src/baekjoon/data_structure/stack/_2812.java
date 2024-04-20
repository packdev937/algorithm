package baekjoon.data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _2812 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);
        String number = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);
            // 스택이 비어있지 않고, K가 0보다 크며, 현재 숫자가 스택의 최상단 숫자보다 클 때 계속해서 pop
            while (!stack.isEmpty() && K > 0 && stack.peek() < current) {
	stack.pop();
	K--;
            }
            stack.push(current);
        }

        // K가 남아 있으면 그만큼 스택에서 제거
        while (K > 0) {
            stack.pop();
            K--;
        }

        // 결과를 문자열로 변환
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        // 스택의 특성상 뒤집힌 순서로 결과가 나오므로 다시 뒤집어 줌
        System.out.println(result.reverse().toString());
    }
}
