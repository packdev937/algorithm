package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String s = "";
        int rt = str.length() - 1, lt = 0;

        for (int i = 0; i < str.length() / 2; i++) {
            while (!Character.isAlphabetic(str.charAt(lt))) {
                lt++;
            }
            while (!Character.isAlphabetic(str.charAt(rt))) {
                rt--;
            }

        }
    }
}
