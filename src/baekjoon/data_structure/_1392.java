package baekjoon.data_structure;

import java.util.Scanner;

public class _1392 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 악보의 수
        int Q = scanner.nextInt(); // 질문의 수

        int[] sheetDurations = new int[N];
        for (int i = 0; i < N; i++) {
            sheetDurations[i] = scanner.nextInt(); // 각 악보의 시간
        }

        // 각 시간에 해당하는 악보를 찾아서 출력
        for (int i = 0; i < Q; i++) {
            int time = scanner.nextInt();
            System.out.println(findSheetAtTime(sheetDurations, time));
        }
    }

    // 주어진 시간에 해당하는 악보를 찾는 메소드
    private static int findSheetAtTime(int[] durations, int time) {
        int currentTime = 0;
        for (int i = 0; i < durations.length; i++) {
            if (time < currentTime + durations[i]) {
	return i + 1;
            }
            currentTime += durations[i];
        }
        return -1; // 시간이 범위를 벗어날 경우
    }
}
