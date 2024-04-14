package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16174 {

    static int[][] board;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 게임 구역의 크기
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
	board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        // 시작 지점을 삽입한다
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            int jump = board[temp[0]][temp[1]];
            int newRow = temp[0] + jump;
            int newCol = temp[1] + jump;

            if (board[temp[0]][temp[1]] == -1) {
	System.out.println("HaruHaru");
	return;
            }

            if (newRow < N && !visited[newRow][temp[1]]) {
	queue.add(new int[]{newRow, temp[1]});
	visited[newRow][temp[1]] = true;
            }

            // 그리드 범위 내에서 오른쪽으로 이동 가능한지 확인
            if (newCol < N && !visited[temp[0]][newCol]) {
	queue.add(new int[]{temp[0], newCol});
	visited[temp[0]][newCol] = true;
            }
        }
        System.out.println("Hing");
        return;
    }
}

// Visited 체크를 안해서 무한 루프가 발생할 가능성이 존재했음