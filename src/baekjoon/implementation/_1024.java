package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1024 {

    private static final int MAX_LENGTH = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long target = Integer.parseInt(st.nextToken());
        long length = Integer.parseInt(st.nextToken());
        boolean isPossible = false;

        /**
         * 15, 5 가 [1, 2, 3, 4, 5] 로 이루어진 수열이라면
         * 15 / 5 = 3 , (5 - 1) / 2 = 2 이므로 시작 값은 1이다.
         *
         * 시작 값으로 부터 Length 개의 수로 합을 도출할 수 있는지는 다음을 통해 확인한다.
         * (start + (start + length - 1)) * length / 2 = target -> 길이가 N인 등차 수열의 합
         */

        while (length <= MAX_LENGTH) {
            long startIndex = target / length - (length - 1) / 2;

            if (startIndex < 0) {
	break;
            }

            long sum = (startIndex + (startIndex + length - 1)) * length / 2;
            if (sum == target) {
	isPossible = true;
	for (long difference = 0; difference < length; difference++) {
	    bw.write(startIndex + difference + " ");
	}
	break;
            }

            length++;
        }

        if (!isPossible) {
            bw.write("-1");
        } else {
            bw.flush();
        }

        bw.close();
        br.close();
    }
}