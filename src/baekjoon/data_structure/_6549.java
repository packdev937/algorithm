package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _6549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int max = Integer.MIN_VALUE;
        int[] arr = new int[N];
        Stack<Integer> stack = new Stack<>();

        // 높이를 구함
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i + 1]);
        }

        for (int i = 0; i < arr.length; i++) {
            if (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int index = stack.pop();
                int size = arr[index] * (i - stack.peek());
                max = Math.max(max, size);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            int size = arr[index] * (N - index);
            max = Math.max(max, size);
        }

        System.out.println(max);
    }
}
