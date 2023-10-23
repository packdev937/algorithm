package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _12605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            String[] words = line.split(" ");

            System.out.print("Case #" + i + ": ");

            for (int j = words.length - 1; j >= 0; j--) {
                System.out.print(words[j]);
                if (j != 0) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
