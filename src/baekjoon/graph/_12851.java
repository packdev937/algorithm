package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _12851 {

    static int[] dist = new int[100001];
    static private final int INF = 999999;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, INF);
        dist[N] = 0;
        queue.add(new int[]{N, 0});

        int cnt = 0;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int currPos = temp[0];
            int currDist = temp[1];

            if (currPos < 0 || currPos > 100000) {
                continue;
            }

            if (dist[currPos] < currDist) {
                continue;
            }

            if (currPos == K) {
                cnt++;
            }

            if (currPos - 1 >= 0 && dist[currPos - 1] >= currDist + 1) {
                dist[currPos - 1] = currDist + 1;
                queue.add(new int[]{currPos - 1, currDist + 1});
            }

            if (currPos + 1 <= 100000 && dist[currPos + 1] >= currDist + 1) {
                dist[currPos + 1] = currDist + 1;
                queue.add(new int[]{currPos + 1, currDist + 1});
            }

            if (currPos * 2 <= 100000 && dist[currPos * 2] >= currDist + 1) {
                dist[currPos * 2] = currDist + 1;
                queue.add(new int[]{currPos * 2, currDist + 1});
            }
        }

        System.out.println(dist[K] + "\n" + cnt);
    }
}
