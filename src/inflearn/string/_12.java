package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String code = br.readLine();
        String result = "";

        for (int i = 0; i < N; i++) {
            int ASCII = 0;
            for (int j = 0; j < 7; j++) {
                if (code.charAt(i * 7 + j) == '#') {
                    ASCII += Math.pow(2, 6 - j);
                } else continue;
            }
            result += (char) ASCII;
        }
        System.out.println(result);
    }
}
