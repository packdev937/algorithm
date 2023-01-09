package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        String result = s[0];

        for (int i = 1; i < N; i++) {
            if (Integer.parseInt(s[i - 1]) < Integer.parseInt(s[i])) {
                result += " " + s[i];
            }
        }
        System.out.println(result);
    }
}
