package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _17202 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        StringBuilder newString = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            newString.append(A.charAt(i)).append(B.charAt(i));
        }

        while (newString.length() > 2) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < newString.length() - 1; i++) {
	int sum = (newString.charAt(i) - '0') + (newString.charAt(i + 1) - '0');
	sb.append(sum % 10);
            }
            newString = sb;
        }

        System.out.println(newString);
    }

}
