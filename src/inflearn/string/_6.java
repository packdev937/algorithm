package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ori = br.readLine().toCharArray();
        String str = "";

        for (int i = 0; i < ori.length; i++) {
            if (str.contains(Character.toString(ori[i])))
                continue;
            else {
                str += ori[i];
            }
        }
        System.out.print(str);
    }
}
