package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1748_ {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 마지막 값이 100000000 일 때, 계산이 안되는 문제가 있었습니다.
        int[] numbers = new int[]{0, 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999,
            Integer.MAX_VALUE};
        int result = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (N > numbers[i]) {
	result += (i) * (numbers[i] - numbers[i - 1]);
            } else {
	result += (N - numbers[i - 1]) * (i);
	break;
            }
        }
        System.out.println(result);
    }

}
