package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] ori = str.toCharArray();

        int lt = 0, rt = ori.length - 1;
        for (int i = 0; i < ori.length; i++) {
            while (!Character.isAlphabetic(ori[lt])) {
                lt++;
            }
            while (!Character.isAlphabetic(ori[rt])) {
                rt--;
            }
            if (rt < lt)
                break;
            char temp = ori[lt];
            ori[lt] = ori[rt];
            ori[rt] = temp;
            lt++;
            rt--;
        }

        for (char x : ori) {
            System.out.print(x);
        }

    }
}
