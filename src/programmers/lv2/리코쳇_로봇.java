package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 리코쳇_로봇 {

    class Solution {

        boolean[][][] visited;
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        int answer = Integer.MAX_VALUE;

        public int solution(String[] board) {
            visited = new boolean[board.length][board[0].length()][4];

            for (int i = 0; i < board.length; i++) {
	for (int j = 0; j < board[0].length(); j++) {
	    if (board[i].charAt(j) == 'R') {
	        bfs(i, j, board); // 'R' 위치에서 BFS 시작
	        break;
	    }
	}
            }

            return answer == Integer.MAX_VALUE ? -1 : answer;
        }

        public void bfs(int i, int j, String[] board) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{i, j, 0}); // 시작 위치
            for (int k = 0; k < 4; k++) {
	visited[i][j][k] = true;
            }

            while (!queue.isEmpty()) {
	int[] temp = queue.poll();
	int y = temp[0];
	int x = temp[1];
	int count = temp[2];

	if (board[y].charAt(x) == 'G') { // 목표지점에 도달하면 최솟값 갱신
	    answer = Math.min(count, answer);
	    continue;
	}

	// 4방향으로 이동
	for (int k = 0; k < 4; k++) {
	    int ny = y;
	    int nx = x;

	    // 경계 내에서 계속 이동
	    while (true) {
	        ny += dy[k];
	        nx += dx[k];

	        // 배열 경계 밖으로 나가면 그 전 위치로 돌아감
	        if (ny < 0 || nx < 0 || ny >= board.length || nx >= board[0].length()
	            || board[ny].charAt(nx) == 'D') {
	            ny -= dy[k];
	            nx -= dx[k];
	            break;
	        }
	    }

	    // 이미 방문한 경우 스킵
	    if (!visited[ny][nx][k]) {
	        visited[ny][nx][k] = true;
	        queue.add(new int[]{ny, nx, count + 1}); // 새로운 위치에서 이동
	    }
	}
            }
        }
    }


}
