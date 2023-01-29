package inflearn.array;

import java.util.Scanner;

public class _11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][5];
        int maxStudent = 1, maxCnt = 0, cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            cnt = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 5; k++) {
                    if (i == j)
                        continue;
                    else {
                        if (arr[i][k] == arr[j][k]) {
                            cnt++;
                            break;
                        }
                    }
                }
            }
            if (cnt > maxCnt) {
                maxStudent = i + 1;
                maxCnt = cnt;
            }
        }
        System.out.println(maxStudent);
    }
}

// 이 문제의 핵심은 한 학생과 다른 학생들을 어떻게 비교하냐 이다
// 만약 N번 학생과 나머지 학생들을 학년 순으로 비교한다면 1, 2 학생이 3학년 4학년때 같은 반이였다면 두 번 중복 체크될 가능성이 있다.
// 따라서 비교를 학년 순이 아닌 한번에 두 학생을 통째로 비교해야 한다
// 추가로 한번 값이 나온다면 break; 로 반복문을 탈출해 중복적으로 같은 반을 체크하지 않도록 해야한다.