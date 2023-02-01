package inflearn.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class _1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int max = 0;
        char maxChar = 'a';

        for (char x : map.keySet()) {
            if (map.get(x) > max) {
                max = map.get(x);
                maxChar = x;
            }
        }

        System.out.println(maxChar);
    }
}
