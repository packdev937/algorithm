package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _2696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            ArrayList<Integer> a = new ArrayList<>();

            int N = Integer.parseInt(br.readLine());
            sb.append(((N + 1) / 2) + "\n");
            int cnt = 0;

            for (int j = 0; j < N; j++) {
                if (j % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }

                int x = Integer.parseInt(st.nextToken());
                a.add(x);
                Collections.sort(a);

                if (j % 2 == 0) {
                    // 한 줄의 최대 10개만 가능.
                    if (cnt == 9 || j == N - 1) {
                        sb.append(a.get(j / 2) + "\n");
                        cnt = 0;
                    } else {
                        sb.append(a.get(j / 2) + " ");
                    }
                    cnt++;
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}