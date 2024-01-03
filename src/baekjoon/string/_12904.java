package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _12904 {

    static String input;
    static String target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        target = br.readLine();

        dfs(input);
        System.out.println(0);
    }

    public static void dfs(String input) {
        if (input.length() > target.length()) {
            return;
        }

        if (input.equals(target)) {
            System.out.println(1);
            System.exit(0);
        }

        StringBuilder sb = new StringBuilder(input);
        dfs(sb.append("A").toString());
        dfs(sb.reverse().toString() + "B");
    }
}