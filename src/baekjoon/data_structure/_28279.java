package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class _28279 {

    static Deque<Integer> deque = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if (st.hasMoreTokens()) {
	int param = Integer.parseInt(st.nextToken());
	execute(command, param);
            } else {
	execute(command);
            }
        }
        System.out.print(sb);
    }

    public static void execute(int command) {
        switch (command) {
            case 3:
	if (deque.isEmpty()) {
	    sb.append("-1\n");
	} else {
	    sb.append(deque.pollFirst()).append("\n");
	}
	break;
            case 4:
	if (deque.isEmpty()) {
	    sb.append("-1\n");
	} else {
	    sb.append(deque.pollLast()).append("\n");
	}
	break;
            case 5:
	sb.append(deque.size()).append("\n");
	break;
            case 6:
	sb.append(deque.isEmpty() ? "1\n" : "0\n");
	break;
            case 7:
	if (deque.isEmpty()) {
	    sb.append("-1\n");
	} else {
	    sb.append(deque.peekFirst()).append("\n");
	}
	break;
            case 8:
	if (deque.isEmpty()) {
	    sb.append("-1\n");
	} else {
	    sb.append(deque.peekLast()).append("\n");
	}
	break;
        }
    }

    public static void execute(int command, int param) {
        switch (command) {
            case 1:
	deque.addFirst(param);
	break;
            case 2:
	deque.addLast(param);
	break;
        }
    }
}
