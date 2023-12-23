package baekjoon.data_structure.priority_queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _2304 {

    static PriorityQueue<Word> pq = new PriorityQueue<>((o1, o2) -> {
        if (o1.count != o2.count) {
            return o2.count - o1.count;
        } else if (o1.word.length() != o2.word.length()) {
            return o2.word.length() - o1.word.length();
        } else {
            return o1.word.compareTo(o2.word);
        }
    });

    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.length() < M) {
	continue;
            }
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        for (String key : map.keySet()) {
            pq.add(new Word(map.get(key), key));
        }

        while (!pq.isEmpty()) {
            Word word = pq.poll();
            bw.write(word.word+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static class Word {

        private int count;
        private String word;

        public Word(int count, String word) {
            this.count = count;
            this.word = word;
        }
    }
}
