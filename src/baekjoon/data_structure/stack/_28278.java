package baekjoon.data_structure.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class _28278 {

    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
	case "1":
	    stack.push(Integer.parseInt(st.nextToken()));
	    break;
	case "2":
	    if (stack.isEmpty()) {
	        bw.write(-1 + "\n");
	    } else {
	        bw.write(stack.pop() + "\n");
	    }
	    break;
	case "3":
	    bw.write(stack.size() + "\n");
	    break;
	case "4":
	    if (stack.isEmpty()) {
	        bw.write(1 + "\n");
	        break;
	    }
	    bw.write(0 + "\n");
	    break;
	case "5":
	    if (stack.isEmpty()) {
	        bw.write(-1 + "\n");
	        break;
	    }
	    bw.write(stack.peek() + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
