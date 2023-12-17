package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _2161 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> deck = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            deck.add(i + 1);
        }

        while (true) {
            sb.append(deck.poll() + " ");
            int next = deck.poll();
            if (deck.isEmpty()) {
	sb.append(next + " ");
	break;
            }
            deck.add(next);
        }

        System.out.println(sb.toString());
    }

}
