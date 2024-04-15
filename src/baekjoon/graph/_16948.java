package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16948 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r1, c1, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            int count = current[2];

            if (y == r2 && x == c2) {
	System.out.println(count);
	return;
            }

            if (visited[y][x]) {
	continue;
            }

            visited[y][x] = true;

            int[] dy = {-2, -2, 0, 0, 2, 2};
            int[] dx = {-1, 1, -2, 2, -1, 1};

            for (int i = 0; i < 6; i++) {
	int ny = y + dy[i];
	int nx = x + dx[i];

	if (ny >= 0 && nx >= 0 && ny < N && nx < N) {
	    queue.add(new int[]{ny, nx, count + 1});
	}
            }
        }
        System.out.println(-1);
    }
}
