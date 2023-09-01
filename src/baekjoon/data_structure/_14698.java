package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _14698 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        PriorityQueue<BigInteger> pq = new PriorityQueue<>();
        BigInteger MOD = new BigInteger("1000000007");
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                pq.add(new BigInteger(st.nextToken()));
            }
            BigInteger answer = BigInteger.ONE;
            while (pq.size() != 1) {
                BigInteger a = pq.poll();
                BigInteger b = pq.poll();
                BigInteger temp = a.multiply(b);
                answer = answer.multiply(temp).remainder(MOD);

                pq.add(temp);
            }

            sb.append(answer + "\n");
            pq.clear();
        }
        System.out.println(sb);
    }
}
