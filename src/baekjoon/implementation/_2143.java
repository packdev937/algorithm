package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _2143 {

    static HashMap<Long, Long> firstMap = new HashMap<>();
    static HashMap<Long, Long> secondMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long T = Long.parseLong(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[] first = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < first.length; i++) {
            first[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] second = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < second.length; i++) {
            second[i] = Integer.parseInt(st.nextToken());
        }

        calculateSubArray(first, firstMap);
        calculateSubArray(second, secondMap);

        long answer = 0;
        for (long key : firstMap.keySet()) {
            if (secondMap.containsKey(T - key)) {
	answer += firstMap.get(key) * secondMap.get(T - key);
            }
        }
        System.out.println(answer);
    }

    private static void calculateSubArray(int[] array, HashMap<Long, Long> map) {
        for (int i = 0; i < array.length; i++) {
            long sum = 0;
            for (int k = i; k < array.length; k++) {
	sum += array[k];
	map.put(sum, map.getOrDefault(sum, 0L) + 1);
            }
        }
    }
}
