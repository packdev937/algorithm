package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5586 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int JOI = 0;
        int IOI = 0;
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.substring(i, i + 3).equals("JOI")) {
	JOI++;
            } else if (str.substring(i, i + 3).equals("IOI")) {
	IOI++;
            }
        }
        System.out.println(JOI);
        System.out.println(IOI);
    }
}
