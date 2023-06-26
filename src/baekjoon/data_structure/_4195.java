package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _4195 {
    static Map<String, String> parent = new HashMap<>();
    static Map<String, Integer> count = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            parent.clear();
            count.clear();
            int F = Integer.parseInt(br.readLine());
            for (int i = 0; i < F; i++) {
                String[] friends = br.readLine().split(" ");
                if (!parent.containsKey(friends[0])) {
                    parent.put(friends[0], friends[0]);
                    count.put(friends[0], 1);
                }
                if (!parent.containsKey(friends[1])) {
                    parent.put(friends[1], friends[1]);
                    count.put(friends[1], 1);
                }
                union(friends[0], friends[1]);
                sb.append(count.get(find(friends[0]))).append('\n');
            }
        }
        System.out.print(sb.toString());
    }

    public static String find(String x) {
        if (x.equals(parent.get(x))) {
            return x;
        }
        String p = find(parent.get(x));
        parent.put(x, p);
        return p;
    }

    public static void union(String x, String y) {
        x = find(x);
        y = find(y);
        if (!x.equals(y)) {
            parent.put(y, x);
            count.put(x, count.get(x) + count.get(y));
        }
    }
}