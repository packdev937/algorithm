package programmers.lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 미로_탈출 {

    Queue<int[]> queue = new LinkedList<>();
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, 1, 0, -1};

    public int solution(String[] maps) {
        int answer = 0;
        int[] start = new int[2];
        int[] lever = new int[2];
        int[][] dp = new int[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
	if (maps[i].charAt(j) == 'S') {
	    start = new int[]{i, j};
	}

	if (maps[i].charAt(j) == 'L') {
	    lever = new int[]{i, j};
	}
            }
        }

        // 출발 -> 레버
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 99999);
        }

        int leverLength = Integer.MAX_VALUE;
        queue.add(new int[]{start[0], start[1], 0});

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            if (dp[temp[0]][temp[1]] <= temp[2]) {
	continue;
            }

            if (maps[temp[0]].charAt(temp[1]) == 'L') {
	leverLength = Math.min(leverLength, temp[2]);
            }

            dp[temp[0]][temp[1]] = temp[2];

            for (int i = 0; i < 4; i++) {
	int ny = temp[0] + dy[i];
	int nx = temp[1] + dx[i];

	if (ny >= 0 && nx >= 0 && ny < maps.length && nx < maps[0].length()
	    && maps[ny].charAt(nx) != 'X') {
	    queue.add(new int[]{ny, nx, temp[2] + 1});
	}
            }
        }

        // 레버 -> 출구
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 99999);
        }

        int exitLength = Integer.MAX_VALUE;
        queue.add(new int[]{lever[0], lever[1], 0});

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            if (dp[temp[0]][temp[1]] <= temp[2]) {
	continue;
            }

            if (maps[temp[0]].charAt(temp[1]) == 'E') {
	exitLength = Math.min(exitLength, temp[2]);
            }

            dp[temp[0]][temp[1]] = temp[2];

            for (int i = 0; i < 4; i++) {
	int ny = temp[0] + dy[i];
	int nx = temp[1] + dx[i];

	if (ny >= 0 && nx >= 0 && ny < maps.length && nx < maps[0].length()
	    && maps[ny].charAt(nx) != 'X') {
	    queue.add(new int[]{ny, nx, temp[2] + 1});
	}
            }
        }

        if (leverLength == Integer.MAX_VALUE || exitLength == Integer.MAX_VALUE) {
            return -1;
        }

        return leverLength + exitLength;
    }
}

