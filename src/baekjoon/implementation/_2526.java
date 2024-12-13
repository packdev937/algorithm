package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _2526 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> remainderMap = new HashMap<>();
        int current = N % P;
        int index = 0;

        while (!remainderMap.containsKey(current)) {
            remainderMap.put(current, index);
            current = (current * N) % P;
            index++;
        }

        int cycleStartIndex = remainderMap.get(current);
        int cycleLength = index - cycleStartIndex;

        System.out.println(cycleLength);
    }
}
