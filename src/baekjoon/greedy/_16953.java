package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16953 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int cnt = 1;
        while (true) {
            if (A.equals(B)) {
                System.out.println(cnt);
                break;
            } else if (Long.parseLong(A) > Long.parseLong(B)) {
                System.out.println(-1);
                break;
            } else if (B.charAt(B.length() - 1) != '1') {
                if (Character.getNumericValue(B.charAt(B.length() - 1)) % 2 == 0) {
                    B = String.valueOf((Long.parseLong(B) / 2));
                    cnt++;
                } else {
                    System.out.println(-1);
                    break;
                }
            } else if (B.charAt(B.length() - 1) == '1') {
                B = B.substring(0, B.length() - 1);
                cnt++;
            }
        }
    }

}
