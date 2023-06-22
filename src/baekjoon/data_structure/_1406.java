package baekjoon.data_structure;

import java.io.*;
import java.util.Stack;

public class _1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> lStack = new Stack<>();
        Stack<Character> rStack = new Stack<>();

        String initialStr = br.readLine();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < initialStr.length(); i++) {
            lStack.push(initialStr.charAt(i));
        }

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            char command = s[0].charAt(0);

            switch (command) {
                case 'P':
                    lStack.push(s[1].charAt(0));
                    break;
                case 'B':
                    if (!lStack.isEmpty()) lStack.pop();
                    break;
                case 'L':
                    if (!lStack.isEmpty()) rStack.push(lStack.pop());
                    break;
                case 'D':
                    if (!rStack.empty()) lStack.push(rStack.pop());
                    break;
                default:
                    break;
            }
        }

        while (!lStack.empty()) {
            rStack.push(lStack.pop());
        }

        while (!rStack.empty()) {
            bw.write(rStack.pop());
        }

        bw.close();
        br.close();
    }
}