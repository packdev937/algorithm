package programmers.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 점프와_순간_이동 {

    public static int solution(int n) {
        int battery = 1;

        while (n != 1) {
            if (n % 2 == 0) {
	n /= 2;
            } else {
	n -= 1;
	battery++;
            }
        }

        return battery;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(solution(N));
    }
}
