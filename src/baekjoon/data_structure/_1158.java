package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class _1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        sb.append("<");
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            dq.addLast(i + 1);
        }
        int cnt = 0;
        while (!dq.isEmpty()) {
            cnt++;
            if (cnt == K) {
                sb.append(dq.pollFirst());
                cnt = 0;
                if(dq.size()!=0)
                    sb.append(", ");
            } else {
                dq.addLast(dq.pollFirst());
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
