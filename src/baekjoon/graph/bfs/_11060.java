package baekjoon.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _11060 {

    static Queue<int[]> queue = new LinkedList<>();
    static int[] jump;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        jump = new int[N];
        count = new int[N + 1];

        Arrays.fill(count, 10000);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            jump[i] = Integer.parseInt(st.nextToken());
        }

        bfs();
        System.out.println(count[N - 1] == 10000 ? -1 : count[N - 1]);
    }

    public static void bfs() {
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            if (count[temp[0]] <= temp[1]) {
                continue;
            }
            if (count[temp[0]] > temp[1]) {
                count[temp[0]] = temp[1];
            }
            if (temp[0] == count.length - 1) {
                break;
            }
            int maxJumpDistance = jump[temp[0]];
            if (maxJumpDistance != 0) {
                for (int i = 1; i <= maxJumpDistance; i++) {
                    queue.add(new int[]{temp[0] + i, count[temp[0]] + 1});
                }
            }
        }
    }

}
