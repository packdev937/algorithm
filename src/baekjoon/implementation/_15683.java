package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _15683 {

    private static class CCTV {
        int x, y, type;

        // 상, 우, 하, 좌
        private static final int[][] DIRECTIONS = {
            {-1, 0}, // 상
            {0, 1},  // 우
            {1, 0},  // 하
            {0, -1}  // 좌
        };

        public CCTV(int y, int x, int type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }

        // 해당 CCTV 유형의 가능한 방향 조합을 반환
        public int[][] getDirections(int direction) {
            switch (type) {
	case 1: // 한 방향만 감시 가능
	    return new int[][]{DIRECTIONS[direction]};
	case 2: // 두 방향 (서로 반대 방향)
	    return direction % 2 == 0
	        ? new int[][]{DIRECTIONS[0], DIRECTIONS[2]}  // 상, 하
	        : new int[][]{DIRECTIONS[1], DIRECTIONS[3]}; // 좌, 우
	case 3: // 직각 두 방향
	    return new int[][]{DIRECTIONS[direction], DIRECTIONS[(direction + 1) % 4]};
	case 4: // 세 방향
	    return new int[][]{DIRECTIONS[direction], DIRECTIONS[(direction + 1) % 4], DIRECTIONS[(direction + 3) % 4]};
	case 5: // 모든 방향 감시 가능
	    return new int[][]{DIRECTIONS[0], DIRECTIONS[1], DIRECTIONS[2], DIRECTIONS[3]};
            }
            return new int[0][0];
        }
    }

    static int[][] board;
    static int N, M;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        List<CCTV> cctvList = new ArrayList<>();

        // 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
	board[i][j] = Integer.parseInt(st.nextToken());
	if (1 <= board[i][j] && board[i][j] <= 5) {
	    cctvList.add(new CCTV(i, j, board[i][j]));
	}
            }
        }

        // DFS로 모든 경우 탐색
        dfs(0, cctvList);
        System.out.println(answer);
    }

    public static void dfs(int depth, List<CCTV> cctvList) {
        if (depth == cctvList.size()) {
            // 모든 CCTV의 방향이 설정되었을 때 사각 지대를 계산
            checkBlindSpot();
            return;
        }

        CCTV current = cctvList.get(depth);
        int[][] original = copyBoard(board);

        // 현재 CCTV의 모든 가능한 방향 설정
        for (int dir = 0; dir < 4; dir++) {
            // 각 CCTV 유형에 따라 감시할 방향 조합을 가져와 처리
            calculate(current, dir);
            dfs(depth + 1, cctvList); // 다음 CCTV로 이동
            restoreBoard(board, original); // 원래 상태로 복원
        }
    }

    // CCTV가 보이는 곳을 계산하는 메서드
    public static void calculate(CCTV cctv, int direction) {
        int[][] directions = cctv.getDirections(direction);

        for (int[] dir : directions) {
            int ny = cctv.y;
            int nx = cctv.x;

            // 지정된 방향으로 끝까지 탐색
            while (true) {
	ny += dir[0];
	nx += dir[1];

	// 보드의 범위를 벗어나거나 벽(6)을 만난 경우 탐색 종료
	if (ny < 0 || ny >= N || nx < 0 || nx >= M || board[ny][nx] == 6) {
	    break;
	}

	// 빈 공간(0)인 경우 감시 가능 영역으로 표시
	if (board[ny][nx] == 0) {
	    board[ny][nx] = -1; // 감시 가능한 영역 표시
	}
            }
        }
    }

    // 사각지대를 카운트하는 메서드
    public static void checkBlindSpot() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
	if (board[i][j] == 0) {
	    count++;
	}
            }
        }
        answer = Math.min(answer, count);
    }

    // 보드를 복사하는 메서드
    public static int[][] copyBoard(int[][] original) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, M);
        }
        return copy;
    }

    // 보드를 원래 상태로 복원하는 메서드
    public static void restoreBoard(int[][] board, int[][] original) {
        for (int i = 0; i < N; i++) {
            System.arraycopy(original[i], 0, board[i], 0, M);
        }
    }
}
