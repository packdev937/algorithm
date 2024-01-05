package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class _13164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] students = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }

        int[] differences = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            differences[i] = students[i + 1] - students[i];
        }

        Arrays.sort(differences);

        int cost = 0;
        for (int i = 0; i < N - K; i++) {
            cost += differences[i];
        }

        System.out.println(cost);
    }
}
