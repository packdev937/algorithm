package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.toLowerCase();
        char c = br.readLine().charAt(0);
        int cnt = 0;

        // for-each 문으로 대체 가능
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == Character.toLowerCase(c))
                cnt++;
        }

        System.out.println(cnt);
    }
}
