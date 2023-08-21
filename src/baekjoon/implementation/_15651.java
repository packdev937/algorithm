package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15651 {

    static int N, M;
    static int[] num;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[M];
        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int index) {
        if (index == M) {
            for (int i = 0; i < num.length; i++) {
                sb.append(num[i] + " ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= N; i++) {
                num[index] = i;
                dfs(index + 1);
            }
        }
    }
}
