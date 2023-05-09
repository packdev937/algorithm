package programmers.lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {
    int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    int[] dy = {0, 1, 0, -1};
    int INF = Integer.MAX_VALUE;

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
        }
        dist[0][0] = 1; // 시작점 초기화
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (maps[nx][ny] == 0) {
                    continue;
                }
                if (dist[nx][ny] > dist[x][y] + 1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        if (dist[n - 1][m - 1] == INF) {
            return -1; // 도달 불가
        } else {
            return dist[n - 1][m - 1]; // 상대팀 진영까지의 최단 거리
        }
    }

    public static void main(String[] args) {
        게임_맵_최단거리 T = new 게임_맵_최단거리();
        System.out.println(T.solution(new int[][]{}));
    }
}
