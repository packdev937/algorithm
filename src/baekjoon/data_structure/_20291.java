package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _20291 {

    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("\\.");
            map.put(input[1], map.getOrDefault(input[1], 0) + 1);
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> o1.compareTo(o2));

        for (String key : keySet) {
            bw.write(key + " " + map.get(key) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
