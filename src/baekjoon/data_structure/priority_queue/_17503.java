package baekjoon.data_structure.priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _17503 {
    static int N, M, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Integer> prefers = new PriorityQueue<>();
        List<B> bs = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            bs.add(new B(p, a));
        }
        bs.sort(new Comparator<B>() {
            @Override
            public int compare(B o1, B o2) {
                if (o1.a == o2.a) {
                    return o2.p - o1.p;
                }
                return o1.a - o2.a;
            }
        });

        int total = 0;
        int answer = -1;
        for (B b : bs) {
            prefers.add(b.p);
            total += b.p;

            if (prefers.size() > N) {
                total -= prefers.poll();
            }
            if (prefers.size() == N && total >= M) {
                answer = b.a;
                break;
            }
        }
        System.out.print(answer);
    }

    static class B {
        int p, a;

        public B(int p, int a) {
            this.p = p;
            this.a = a;
        }
    }
}
