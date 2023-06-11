package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class _5089 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int weekIdx = 1;
        while (true) {
            Set<String> set = new TreeSet<>();
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            for (int i = 0; i < N; i++) {
                set.add(br.readLine());
            }
            System.out.println("Week " + weekIdx++ + " " + set.size());
        }
    }
}
