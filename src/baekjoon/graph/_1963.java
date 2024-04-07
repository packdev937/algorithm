package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1963 {

    static int[] prime = new int[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            init();
            StringTokenizer st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            bfs(A, B);
        }
    }

    private static void bfs(String A, String B) {
        Queue<String> queue = new LinkedList<>();

        boolean[] visited = new boolean[10000];
        int[] count = new int[10000];
        count[Integer.parseInt(A)] = 0;
        visited[Integer.parseInt(A)] = true;

        queue.add(A);

        while (!queue.isEmpty()) {
            String temp = queue.poll();
            int tempInt = Integer.parseInt(temp);

            if (temp.equals(B)) {
	System.out.println(count[tempInt]);
	return;
            }

            for (int i = 0; i < 4; i++) {
	for (int j = 0; j < 10; j++) {
	    if (i == 0 && j == 0) {
	        continue;
	    }
	    String next = temp.substring(0, i) + j + temp.substring(i + 1);
	    int nextInt = Integer.parseInt(next);
	    if (prime[nextInt] != 0 && !visited[nextInt]) {
	        visited[nextInt] = true;
	        count[nextInt] = count[tempInt] + 1;
	        queue.add(next);
	    }
	}
            }
        }
        System.out.println("Impossible");
    }

    private static void init() {
        for (int i = 2; i < 10000; i++) {
            prime[i] = i;
        }
        for (int i = 2; i < 10000; i++) {
            if (prime[i] == 0) {
	continue;
            }
            for (int j = i + i; j < 10000; j += i) {
	prime[j] = 0;
            }
        }
    }

    // 에라토스테네스 체
    // boolean []
}
