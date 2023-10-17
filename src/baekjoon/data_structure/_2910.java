package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class _2910 {

    static HashMap<Integer, Integer> map = new HashMap<>();
    static HashMap<Integer, Integer> inputTime = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (!inputTime.containsKey(num)) {
                inputTime.put(num, i);
            }
        }

        List<Integer> keyList = new ArrayList<>(map.keySet());
        keyList.sort((o1, o2) -> {
            if (!Objects.equals(map.get(o2), map.get(o1))) {
                return map.get(o2) - map.get(o1);
            }
            return inputTime.get(o1) - inputTime.get(o2);
        });

        for (int i = 0; i < keyList.size(); i++) {
            for (int j = 0; j < map.get(keyList.get(i)); j++) {
                System.out.print(keyList.get(i) + " ");
            }
        }
    }

}
