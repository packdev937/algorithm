package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1700 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] plug = new int[N];
        int[] usage = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            usage[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i = 0; i < K; i++) {
            boolean isPlugged = false;
            for (int j = 0; j < N; j++) {
	if (plug[j] == usage[i]) {
	    isPlugged = true;
	    break;
	}
            }
            if (isPlugged) {
	continue;
            }

            for (int j = 0; j < N; j++) {
	if (plug[j] == 0) {
	    plug[j] = usage[i];
	    isPlugged = true;
	    break;
	}
            }
            if (isPlugged) {
	continue;
            }

            int maxIndex = 0;
            int maxLastIndex = 0;
            for (int j = 0; j < N; j++) {
	int lastIndex = 0;
	for (int k = i + 1; k < K; k++) {
	    if (plug[j] == usage[k]) {
	        break;
	    }
	    lastIndex++;
	}
	if (lastIndex > maxLastIndex) {
	    maxIndex = j;
	    maxLastIndex = lastIndex;
	}
            }
            plug[maxIndex] = usage[i];
            count++;
        }
        System.out.println(count);
    }
}
