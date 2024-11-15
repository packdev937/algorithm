package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _2456 {

    static Map<Integer, Integer> countMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] votes = new int[3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 3) {
	countMap.put(1, countMap.getOrDefault(1, 0) + 1);
            } else if (b == 3) {
	countMap.put(2, countMap.getOrDefault(2, 0) + 1);
            } else if (c == 3) {
	countMap.put(3, countMap.getOrDefault(3, 0) + 1);
            }

            votes[0] += a;
            votes[1] += b;
            votes[2] += c;
        }

        int max = Arrays.stream(votes).max().getAsInt();

        int maxIndex = -1;
        int maxCount = 0;
        int index = 0;
        for (int vote : votes) {
            if (vote == max) {
	if (countMap.containsKey(index + 1)) {
	    if (countMap.get(index + 1) > maxCount) {
	        maxIndex = index;
	        maxCount = countMap.get(index + 1);
	    } else if (countMap.get(index + 1) == maxCount) {
	        maxIndex = -1;
	    }
	} else {
	    maxIndex = index;
	}
            }
            index++;
        }

        System.out.println((maxIndex + 1) + " " + max);
    }
}
