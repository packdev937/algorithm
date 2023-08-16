package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1484 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int G = Integer.parseInt(br.readLine());
        int ldx = 1;
        int rdx = 1;

        while (true) {
            int result = (int) (Math.pow(rdx, 2) - Math.pow(ldx, 2));
            if (result < G) {
                rdx++;
            } else if (result >= G) {
                if (result == G) {
                    sb.append(rdx + "\n");
                }
                if (rdx - ldx == 1) {
                    break;
                }
                ldx++;
            }
        }

        System.out.println(sb.length() == 0 ? -1 : sb);
    }
}
