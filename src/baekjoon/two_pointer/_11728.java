package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _11728 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] A = new int[N];
        int[] B = new int[M];
        int[] answer = new int[N + M];

        int aIdx = 0;
        int bIdx = 0;
        int idx = 0;

        String[] partsA = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(partsA[i]);
        }

        String[] partsB = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(partsB[i]);
        }

        while (aIdx < N || bIdx < M) {
            if (aIdx == N) {
                answer[idx++] = B[bIdx++];
            } else if (bIdx == M) {
                answer[idx++] = A[aIdx++];
            } else if (A[aIdx] < B[bIdx]) {
                answer[idx++] = A[aIdx++];
            } else {
                answer[idx++] = B[bIdx++];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            sb.append(answer[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
