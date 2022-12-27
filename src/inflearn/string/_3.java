package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int len, max = 0;
        String str, maxStr = "";

        while (st.hasMoreTokens()) {
            str = st.nextToken();
            len = str.length();
            if (max == 0) {
                max = len;
                maxStr = str;
            } else {
                if (max < len) {
                    max = len;
                    maxStr = str;
                }
            }
        }

        System.out.println(maxStr);
    }
}
