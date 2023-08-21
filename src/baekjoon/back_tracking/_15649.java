package baekjoon.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15649 {

    static boolean ch[];
    static int a[];
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ch = new boolean[N + 1];
        a = new int[M];
        dfs(0);
    }

    public static void dfs(int index) {
        if (index == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < a.length; i++) {
                sb.append(a[i] + " ");
            }
            System.out.println(sb);
            return;
        } else {
            for (int i = 1; i < N + 1; i++) {
                if (ch[i]) {
                    continue;
                } else {
                    a[index] = i;
                    ch[i] = true;
                    dfs(index+1);
                    ch[i] = false;
                }
            }
        }
    }

}
