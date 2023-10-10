package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _13913 {

    static int MAX = 100001;
    static int[] route = new int[MAX];
    static int[] weight = new int[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Arrays.fill(weight, -1); // 초기 값을 -1로 설정

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        weight[N] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == K) break;

            // next: curr-1
            if (curr > 0 && weight[curr - 1] == -1) {
                queue.offer(curr - 1);
                weight[curr - 1] = weight[curr] + 1;
                route[curr - 1] = curr;
            }

            // next: curr+1
            if (curr + 1 < MAX && weight[curr + 1] == -1) {
                queue.offer(curr + 1);
                weight[curr + 1] = weight[curr] + 1;
                route[curr + 1] = curr;
            }

            // next: 2*curr
            if (curr * 2 < MAX && weight[curr * 2] == -1) {
                queue.offer(curr * 2);
                weight[curr * 2] = weight[curr] + 1;
                route[curr * 2] = curr;
            }
        }

        System.out.println(weight[K]);

        // 경로 출력
        Stack<Integer> stack = new Stack<>();
        for (int i = K; i != N; i = route[i]) {
            stack.push(i);
        }
        stack.push(N);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
