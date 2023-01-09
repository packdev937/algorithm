package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String answer = "";
        int cnt = 1;
        answer += str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                if (cnt > 1)
                    answer += cnt;
                answer += str.charAt(i);
                cnt = 1;
            } else {
                cnt++;
                if (i == str.length() - 1) {
                    answer += cnt;
                }
            }
        }
        System.out.println(answer);
    }
}

