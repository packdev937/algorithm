package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _8_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase().replaceAll("[^A-Z]", "");
        boolean isPelindrome = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                isPelindrome = false;
                break;
            }
        }

        if (isPelindrome)
            System.out.print("YES");
        else System.out.print("NO");
    }
}
