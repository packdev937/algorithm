package baekjoon.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9663 {

    static int[] col = new int[15];
    static int N;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int index) {
        if (index == N) {
            answer++;
            return;
        } else {
            for (int i = 0; i < N; i++) {
                col[index] = i;
                if (check(index)) {
                    dfs(index + 1);
                }
            }
        }
    }

    public static boolean check(int index) {

        // col[j] == col[i] 란 뜻은 다른 행인데 같은 열에 퀸이 위치하고 있다는걸 의미
        for (int j = 0; j < index; j++) { // < index +1 이 아닌 index
            if (col[j] == col[index] || Math.abs(j - index) == Math.abs(col[j] - col[index])) {
                return false;
            }
        }
        return true;
    }
}