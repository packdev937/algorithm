package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5212 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
	board[i][j] = str.charAt(j);
            }
        }

        // 1. 물로 변할 섬을 확인하여 큐에 추가
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
	if (board[i][j] == 'X') {
	    int count = 0;
	    for (int k = 0; k < 4; k++) {
	        int ny = i + dy[k];
	        int nx = j + dx[k];

	        // 경계를 벗어나면 물로 간주하여 바로 count 증가
	        if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
	            count++;
	        } else if (board[ny][nx] == '.') {
	            count++;
	        }
	    }

	    if (count >= 3) {
	        queue.add(new int[]{i, j});
	    }
	}
            }
        }

        // 2. 큐에 있는 섬을 물로 바꾸기
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            board[y][x] = '.';
        }

        // 3. 유효한 영역 찾기 (섬이 존재하는 최소/최대 좌표 찾기)
        int maxY = 0, maxX = 0;
        int minY = R, minX = C;  // 주의: minX, minY를 C, R로 초기화

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
	if (board[i][j] == 'X') {
	    maxY = Math.max(maxY, i);
	    maxX = Math.max(maxX, j);
	    minY = Math.min(minY, i);
	    minX = Math.min(minX, j);
	}
            }
        }

        // 4. 유효한 영역만 출력
        for (int i = minY; i <= maxY; i++) {
            for (int j = minX; j <= maxX; j++) {
	System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}

// 배열의 경계 또한 바다라는 사실 (문제를 잘 확인하자)