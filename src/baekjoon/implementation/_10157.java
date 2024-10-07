package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10157 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 가로 길이 (열의 개수)
        int C = Integer.parseInt(st.nextToken());
        // 세로 길이 (행의 개수)
        int R = Integer.parseInt(st.nextToken());
        // 찾고자 하는 좌석 번호
        int K = Integer.parseInt(br.readLine());

        // 좌석 번호가 전체 좌석 수보다 큰 경우
        if (K > R * C) {
            System.out.println(0);
            return;
        }

        // 방향 배열 (상, 우, 하, 좌 순서)
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        // 초기 위치 및 초기 방향
        int x = 0, y = 0, direction = 0;
        int[][] board = new int[R][C];
        int num = 1;

        // num이 R* C보다 커질 때 까지
        while (num <= R * C) {
            board[y][x] = num;

            // 찾고자 하는 좌석 번호에 도달한 경우
            if(num == K) {
	System.out.println((x + 1) + " " + (y + 1));
	return;
            }

            num++;
            // 다음 위치 계산
            int ny = y + dy[direction];
            int nx = x + dx[direction];

            // 배열 경계 체크 및 이미 방문한 경우 방향 전환
            if(ny < 0 || nx < 0 || ny >= R || nx >= C || board[ny][nx] != 0) {
	direction = (direction + 1) % 4;
	ny = y + dy[direction];
	nx = x + dx[direction];
            }

            // 다음 위치로 이동
            y = ny;
            x = nx;
        }
    }
}
