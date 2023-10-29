package baekjoon.graph.bfs;

import java.util.*;

public class _13565 {
    static int M, N;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static boolean bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    if (!visited[nx][ny] && grid[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        queue.add(new int[] {nx, ny});

                        // 만약 최하단 행에 도달하면 true 반환
                        if (nx == M - 1) return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        M = scanner.nextInt();
        N = scanner.nextInt();
        grid = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String line = scanner.next();
            for (int j = 0; j < N; j++) {
                grid[i][j] = line.charAt(j) - '0';
            }
        }

        boolean percolates = false;
        for (int j = 0; j < N; j++) {
            if (grid[0][j] == 0 && !visited[0][j]) {
                if (bfs(0, j)) {
                    percolates = true;
                    break;
                }
            }
        }

        System.out.println(percolates ? "YES" : "NO");
    }
}
