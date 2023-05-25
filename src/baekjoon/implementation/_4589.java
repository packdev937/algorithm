package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4589 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        sb.append("Gnomes:\n");
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            if (Integer.parseInt(s[0]) > Integer.parseInt(s[1]) && Integer.parseInt(s[1]) > Integer.parseInt(s[2]))
                sb.append("Ordered\n");
            else if (Integer.parseInt(s[0]) < Integer.parseInt(s[1]) && Integer.parseInt(s[1]) < Integer.parseInt(s[2]))
                sb.append("Ordered\n");
            else sb.append("Unordered\n");
        }

        System.out.println(sb);
    }
}
