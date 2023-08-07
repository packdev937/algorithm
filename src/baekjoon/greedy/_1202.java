package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1202 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 보석의 개수
        int N = Integer.parseInt(st.nextToken());
        // 가방의 개수
        int K = Integer.parseInt(st.nextToken());

        List<Jewel> jewels = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(M, V));
        }
        jewels.sort(Comparator.comparingInt(o -> o.M));

        Integer[] bag = new Integer[K];
        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        // PriorityQueue를 보석의 가치를 기준으로 내림차순 정렬
        PriorityQueue<Jewel> jewelsPQ = new PriorityQueue<>(
            (j1, j2) -> Integer.compare(j2.V, j1.V)
        );

        // 가방 무게 오름차순 정렬
        Arrays.sort(bag);

        long sum = 0;
        int jewelIndex = 0;
        for (int i = 0; i < K; i++) {
            while (jewelIndex < N && jewels.get(jewelIndex).M <= bag[i]) {
                jewelsPQ.add(jewels.get(jewelIndex++));
            }

            if (!jewelsPQ.isEmpty()) {
                sum += jewelsPQ.poll().V;
            }
        }

        System.out.println(sum);

    }

    static class Jewel {

        int M; // 무게
        int V; // 가격

        public Jewel(int m, int v) {
            M = m;
            V = v;
        }
    }

}
