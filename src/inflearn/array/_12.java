package inflearn.array;

import java.util.Scanner;

public class _12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int cnt = 0;

        int[][] arr = new int[M][N];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int k = 0; k < N; k++) { // 0, 1, 2, 3 번 학생 부터 순서대로 탐색
            for (int l = 0; l < N; l++) { // 조합 탐색
                boolean isTrue = true;
                if (k == l)
                    continue;
                for (int i = 0; i < M; i++) {
                    if(!isTrue) break;
                    int kRank = 0, lRank = 0;
                    for (int j = 0; j < arr[i].length; j++) {
                        if (arr[i][j] == k + 1)
                            kRank = j + 1;
                        if (arr[i][j] == l + 1)
                            lRank = j + 1;
                        if (kRank != 0 && lRank != 0) {
                            if (kRank > lRank) {
                                isTrue = false;
                            }
                        }
                    }
                }
                if(isTrue) cnt++;
            }
        }
        System.out.println(cnt);
    }
}