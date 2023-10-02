package baekjoon.data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Pair> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());

            // 스택의 탑에 있는 탑이 현재 탑의 높이보다 낮으면, 신호를 수신할 수 없으므로 pop
            while (!stack.isEmpty() && stack.peek().height < height) {
                stack.pop();
            }

            // 스택이 비어있지 않으면 현재 탑의 왼쪽에 신호를 수신할 수 있는 탑이 존재
            if (!stack.isEmpty()) {
                sb.append(stack.peek().index + 1).append(" ");
            } else {
                sb.append(0).append(" ");
            }

            // 현재 탑을 스택에 넣음
            stack.push(new Pair(i, height));
        }

        System.out.println(sb);
    }

    static class Pair {
        int index, height;

        Pair(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}
