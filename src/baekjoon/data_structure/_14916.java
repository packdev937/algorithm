package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _14916 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 5) {
            System.out.print(1);
            return;
        } else if (N < 5) {
            if (N % 2 == 0) {
	System.out.print(N / 2);
	return;
            }
            System.out.print(-1);
            return;
        }

        int count = 0;
        count = N / 5;
        while (count >= 0) {
            if ((N - 5 * count) % 2 == 0) {
	System.out.print(count + (N - 5 * count) / 2);
	return;
            }
            count--;
        }
        System.out.print(count);
    }
}

// 5원과 2원을 최소 조합으로 사용해서 풀어야 하는 문제
// 중요한건 13원 같은 경우 5 + 2 * 4 인데 5 *2 를 해버리면 3이 남는다
// 그래서 5원을 최대한 많이 사용하고 남은 돈을 짝수로 하게금
