package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _16937 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        // 스티커의 개수
        int N = Integer.parseInt(br.readLine());
        List<int[]> stickers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            stickers.add(new int[]{r, c});
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
	int[] first = stickers.get(i);
	int[] second = stickers.get(j);

	answer = Math.max(answer, calculateMaxArea(first, second, H, W));
            }
        }

        System.out.println(answer);
    }

    public static int calculateMaxArea(int[] first, int[] second, int H, int W) {
        int maxArea = 0;

        // 각 스티커의 회전 경우를 모두 고려
        int[][] configs = {
            {first[0], first[1], second[0], second[1]},
            {first[0], first[1], second[1], second[0]},
            {first[1], first[0], second[0], second[1]},
            {first[1], first[0], second[1], second[0]}
        };

        for (int[] config : configs) {
            int r1 = config[0], c1 = config[1];
            int r2 = config[2], c2 = config[3];

            // 1. 두 스티커를 나란히 가로로 배치 (두 스티커의 높이를 더함)
            if (r1 + r2 <= H && Math.max(c1, c2) <= W) {
	maxArea = Math.max(maxArea, r1 * c1 + r2 * c2);
            }

            // 2. 두 스티커를 나란히 세로로 배치 (두 스티커의 너비를 더함)
            if (Math.max(r1, r2) <= H && c1 + c2 <= W) {
	maxArea = Math.max(maxArea, r1 * c1 + r2 * c2);
            }
        }

        return maxArea;
    }
}

