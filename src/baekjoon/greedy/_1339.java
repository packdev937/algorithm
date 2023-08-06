package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1339 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        Map<Character, Integer> valueMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
            int power = (int) Math.pow(10, words[i].length() - 1); // 위치의 가치를 결정

            for (char c : words[i].toCharArray()) {
                valueMap.put(c, valueMap.getOrDefault(c, 0) + power);
                power /= 10;
            }
        }

        // 가치가 높은 순으로 정렬
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(valueMap.entrySet());
        entryList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        int num = 9;
        Map<Character, Integer> numMap = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : entryList) {
            numMap.put(entry.getKey(), num--);
        }

        int sum = 0;
        for (String word : words) {
            int number = 0;

            for (char c : word.toCharArray()) {
                number = number * 10 + numMap.get(c);
            }

            sum += number;
        }

        System.out.println(sum);
    }
}
