package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _1946 {

    static ArrayList<Newbie> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            // Input Test
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                list.add(
                    new Newbie(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            Collections.sort(list,
                (n1, n2) -> Integer.compare(n1.a, n2.a));
            int cnt = 1;
            int maxInterview = list.get(0).b;
            for (int j = 1; j < N; j++) {
                if (list.get(j).b < maxInterview) {
                    cnt++;
                    maxInterview = list.get(j).b;
                }
            }
            System.out.println(cnt);
            list.clear();
        }
    }

    static class Newbie {
        int a, b;

        public Newbie(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}



