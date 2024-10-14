package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _30804 {

    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] fruits = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < N; right++) {
            int number = Integer.parseInt(st.nextToken());
            fruits[right] = number;
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            while (map.size() > 2) {
	map.put(fruits[left], map.get(fruits[left]) - 1);

	if (map.getOrDefault(fruits[left], 0) == 0) {
	    map.remove(fruits[left]);
	}

	left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.println(maxLength);

    }

}

