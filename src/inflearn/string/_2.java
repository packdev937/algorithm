package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c))
                System.out.print(Character.toUpperCase(c));
            else System.out.print(Character.toLowerCase(c));
        }
    }
}
