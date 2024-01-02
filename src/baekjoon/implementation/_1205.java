package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class _1205 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long score = Long.parseLong(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if(N == 0){
            System.out.println(1);
            return;
        }

        Integer[] scores = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(scores, Collections.reverseOrder());

        if (N == P && scores[N - 1] >= score) {
            System.out.println(-1);
            return;
        } else {
            int rank = 1;
            for (int i = 0; i < N; i++) {
	if (scores[i] > score) {
	    rank++;
	} else {
	    break;
	}
            }
            System.out.println(rank);
        }
    }
}