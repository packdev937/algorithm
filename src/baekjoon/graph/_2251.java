package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2251 {

    static Queue<int[]> queue = new LinkedList<>();
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        visited = new boolean[A + 1][B + 1][C + 1];

        Set<Integer> answer = new HashSet<>();
        queue.add(new int[]{0, 0, C});

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int a = arr[0]; // 현재 A 물통의 양
            int b = arr[1]; // 현재 B 물통의 양
            int c = arr[2]; // 현재 C 물통의 양

            // 한 번 방문한 경우 다시 방문하지 않도록 함
            if (visited[a][b][c]) {
	continue;
            }
            visited[a][b][c] = true;

            // 현재 A 물통이 비워있을 때 C를 답안에 추가 함
            if (a == 0) {
	answer.add(c);
            }

            // A -> B
            pour(a, b, c, A, B, C, 0, 1);
            // A -> C
            pour(a, b, c, A, B, C, 0, 2);
            // B -> A
            pour(a, b, c, A, B, C, 1, 0);
            // B -> C
            pour(a, b, c, A, B, C, 1, 2);
            // C -> A
            pour(a, b, c, A, B, C, 2, 0);
            // C -> B
            pour(a, b, c, A, B, C, 2, 1);
        }

        answer.stream().sorted().forEach(
            x -> System.out.print(x + " ")
        );
    }

    static void pour(int a, int b, int c, int A, int B, int C, int from, int to) {
        int[] water = new int[]{a, b, c};
        int[] capacity = new int[]{A, B, C};

        // from 물통에서 to 물통으로 물을 부음
        if (water[from] + water[to] > capacity[to]) {
            water[from] -= capacity[to] - water[to];
            water[to] = capacity[to];
        } else {
            water[to] += water[from];
            water[from] = 0;
        }

        if (!visited[water[0]][water[1]][water[2]]) {
            queue.add(new int[]{water[0], water[1], water[2]});
        }
    }
}
